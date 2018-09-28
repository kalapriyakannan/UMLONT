/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypeFactory;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyConfiguration;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.internal.emf.ResourceUtilities;

/**
 * Service APIs to assist with accessing ResourceType information
 * 
 * @since 2.0
 * 
 * TODO the dynamic palette entries are supposed to be cached upon load before the user does
 * anything, so perhaps the UI plugin should ask for the list of dynamic palette entries on startup,
 * then throw them away? I suspect 99% of the time when our UI plugin starts it is because the user
 * is opening a .topology anyway, so background work will not help them...
 */
public class ResourceTypeService implements IResourceTypeService {

	/** singleton instance of this service */
	private static final ResourceTypeService INSTANCE = new ResourceTypeService();

	private static final String DYNAMIC_TEMPLATE_EXTENSION = ".topology"; //$NON-NLS-1$

	private static final String DYNAMIC_TEMPLATES_FOLDER = "templates"; //$NON-NLS-1$
	private static final String SEPARATOR = "/"; //$NON-NLS-1$
	private static final String PLATFORM_RESOURCE_PREFIX = "platform:/resource/"; //$NON-NLS-1$
	private String templateUri = null;
	private String templateVUri = null;
	private Topology currentTopology = null;

	/**
	 * Palette entries from DomainManager.getInstance().getAllResourceTypePaletteBindings()
	 */
	private List<DynamicPaletteEntry> registeredPaletteEntries;

	/** Palette tool entries from template files in workspace */
	private List<DynamicPaletteEntry> dynamicPaletteEntries;

	/** Palette stack entries for dynamic templates (user-defined) */
	private List<DynamicPaletteEntry> dynamicStackEntries;

	private final List<PaletteExtensionListener> changeListeners = new LinkedList<PaletteExtensionListener>();

	private final ResourceTypeResourceListener resourceTypeResourceListener = new ResourceTypeResourceListener();

	private final IResourceDeltaVisitor resourceDeltaVisitor = new ResourceTypeDeltaVisitor();

	/**
	 * @return the instance
	 */
	public static ResourceTypeService getInstance() {
		return INSTANCE;
	}

	/**
	 * Initialize the service
	 */
	public void init() {
		// Add listener
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceTypeResourceListener);
	}

	/**
	 * Depose the service
	 */
	public void depose() {
		// Remove listener
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceTypeResourceListener);
	}

	/**
	 * Get the resource type id for the specified context, bound id
	 * 
	 * @param context
	 * @param id
	 * @return the resource type id, null if not found
	 */
	public String getResourceTypeId(String context, String id) {
		ResourceTypeBindingDescriptor[] bindingDescs = DomainManager.getInstance()
				.getAllResourceTypeBindings(context);
		for (int i = 0; i < bindingDescs.length; i++) {
			ResourceTypeBindingDescriptor desc = bindingDescs[i];
			if (desc.getId().equals(id)) {
				return desc.getResourceTypeId();
			}
		}
		return null;
	}

	/**
	 * Get the template URI for the specified resource type id
	 * 
	 * @param resourceTypeId
	 * @return the templtaeURI string, null if not found
	 */
	public String getTemplateURI(String resourceTypeId) {
		ResourceTypeDescriptor rtdesc = getrtDesc(resourceTypeId);
		if (rtdesc != null) {
			return rtdesc.getTemplateUri();
		}

		// check in dynamic type list
		DynamicPaletteEntry entry = getDynamicEntry(resourceTypeId);
		if (entry != null) {
			return entry.getTemplateURI();
		}

		return null;
	}

	public String getTemplateVURI(String resourceTypeId) {
		DynamicPaletteEntry entry = getDynamicEntry(resourceTypeId);
		if (entry != null) {
			return entry.getDiagramPath();
		}

		return null;
	}

	private ResourceTypeDescriptor getrtDesc(String resourceTypeId) {
		return DomainManager.getInstance().getResourceType(resourceTypeId);

	}

	private DynamicPaletteEntry getDynamicEntry(String resourceTypeId) {
		if (dynamicPaletteEntries != null) {
			for (Iterator<DynamicPaletteEntry> it = dynamicPaletteEntries.iterator(); it.hasNext();) {
				DynamicPaletteEntry entry = it.next();
				if (entry.getId().equals(resourceTypeId)) {
					return entry;
				}
			}
		}
		return null;
	}

	/**
	 * Return the template URI from the id bound to the specified context
	 * 
	 * @param context
	 *           the context of the resource type binding id
	 * @param id
	 *           the binding id
	 * @return the template URI string, null if not found
	 */
	public String getTemplateURI(String context, String id) {
		ResourceTypeBindingDescriptor[] bindingDescs = DomainManager.getInstance()
				.getAllResourceTypeBindings(context);
		for (int i = 0; i < bindingDescs.length; i++) {
			ResourceTypeBindingDescriptor desc = bindingDescs[i];
			if (desc.getId().equals(id)) {
				String resourceTypeId = desc.getResourceTypeId();
				return getTemplateURI(resourceTypeId);
			}
		}
		return null;
	}

	/**
	 * Create a unit using the template for an existing topology.
	 * 
	 * @param resourceTypeId
	 *           the id of the template to create
	 * @return the object created using the topology
	 */
	public DeployModelObject createFromTemplate(String resourceTypeId) {
		return createFromTemplate(resourceTypeId, CoreFactory.eINSTANCE.createTopology());
	}

	/**
	 * Create a unit using the template for an existing topology.
	 * 
	 * @param resourceTypeId
	 *           the id of the template to create
	 * @param topology
	 *           the target topology
	 * @return the object created using the topology
	 */
	public DeployModelObject createFromTemplate(String resourceTypeId, Topology topology) {
		String uri = getTemplateURI(resourceTypeId);
		return ResolutionUtils.doDefaultElementCreation(uri, topology);
	}

	/**
	 * Locate the resource id for the given binding id, and load its template and return the
	 * corresponding unit.
	 * 
	 * @param bindingId -
	 *           the binding id
	 * @param context -
	 *           the context to which the binding id applies
	 * @return the unit created from the template corresponding to the binding id, null if not found
	 */
	public DeployModelObject createUnitFromBindingId(String bindingId, String context) {
		return createUnitFromBindingId(bindingId, context, CoreFactory.eINSTANCE.createTopology());
	}

	/**
	 * Locate the resource id for the given binding id, and load its template and return the
	 * corresponding unit.
	 * 
	 * @param bindingId -
	 *           the binding id
	 * @param context -
	 *           the context to which the binding id applies
	 * @param topology -
	 *           a topology
	 * @return the object created from the template corresponding to the binding id, null if not
	 *         found
	 */
	public DeployModelObject createUnitFromBindingId(String bindingId, String context,
			Topology topology) {
		// TODO if/when ResolutionUtils APIS do not require a topology to create
		// unit, remove
		// the topology from this method
		String resourceTypeId = getResourceTypeId(context, bindingId);
		if (resourceTypeId != null) {
			return createFromTemplate(resourceTypeId, topology);
		}

		return null;
	}

	/**
	 * Get the reourceTypeDescriptor for the associated Id
	 * 
	 * @param id
	 *           the resourceTypeId
	 * @return the ResourceTypeDescriptor
	 */
	public ResourceTypeDescriptor getResourceTypeDescriptor(String id) {
		return DomainManager.getInstance().getResourceType(id);
	}

	/**
	 * Get the reourceTypeUIBindingDescriptor for the associated Id
	 * 
	 * @param id
	 *           the resourceTypeId
	 * @return the ResourceTypeUIBindingDescriptor
	 */
	public ResourceTypeUIBindingDescriptor getResourceTypeUIBindingDescriptor(String id) {
		return DomainManager.getInstance().getResourceTypeUIBinding(id);
	}

	/**
	 * Returns all the palette entries - static + dynamic
	 * 
	 * @return all the palette entries that are available; both statically registered and dynamically
	 *         loaded.
	 */
	public DynamicPaletteEntry[] getAllPaletteEntries() {
		if (registeredPaletteEntries == null) {
			loadRegisteredPaletteEntries();
		}
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}
		List<DynamicPaletteEntry> allPaletteEntries = new ArrayList<DynamicPaletteEntry>();
		allPaletteEntries.addAll(registeredPaletteEntries);
		allPaletteEntries.addAll(dynamicPaletteEntries);
		//Sort entries.
		Collections.sort(allPaletteEntries, new Comparator<DynamicPaletteEntry>() {
			public int compare(DynamicPaletteEntry object1, DynamicPaletteEntry object2) {
				if (object2 == null) {
					if (object1 != null) {
						return 1;
					} else {
						return 0;
					}
				}
				if (object1 == null) {
					if (object2 != null) {
						return -1;
					} else {
						return 0;
					}
				}
				String label1 = object1.getLabel();
				String label2 = object2.getLabel();
				if (label1 == null || label2 == null) {
					return 0;
				}
				return label1.compareToIgnoreCase(label2);
			}
		});
		return allPaletteEntries.toArray(new DynamicPaletteEntry[allPaletteEntries.size()]);
	}

	/**
	 * Return all the statically defined palette entries
	 * 
	 * @return an array of DeployPaletteEntry objects that comprise the set of entries registered as
	 *         ResourceTypePaletteBindings
	 */
	public DynamicPaletteEntry[] getRegisteredPaletteEntries() {
		if (registeredPaletteEntries == null) {
			loadRegisteredPaletteEntries();
		}
		return registeredPaletteEntries.toArray(new DynamicPaletteEntry[registeredPaletteEntries
				.size()]);
	}

	private void loadRegisteredPaletteEntries() {
		registeredPaletteEntries = new ArrayList<DynamicPaletteEntry>();
		ResourceTypeUIBindingDescriptor[] descs = DomainManager.getInstance()
				.getAllResourceTypeUIBindings();
		for (int i = 0; i < descs.length; i++) {
			ResourceTypeUIBindingDescriptor desc = descs[i];
			if (desc.isEnabledForPalette()) {
				DynamicPaletteEntry paletteEntry = desc.createDeployPaletteEntry();
				if (paletteEntry != null) {
					registeredPaletteEntries.add(paletteEntry);
				}
			}
		}
	}

	/**
	 * Return all the dynamically defined palette entries
	 * 
	 * @return an array of DeployPaletteEntry objects
	 */
	public synchronized DynamicPaletteEntry[] getDynamicPaletteEntries() {
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}
		return dynamicPaletteEntries.toArray(new DynamicPaletteEntry[dynamicPaletteEntries.size()]);
	}

	/**
	 * Return all the dynamically defined palette entries
	 * 
	 * @return an array of DeployPaletteEntry objects
	 */
	public synchronized DynamicPaletteEntry[] getDynamicStackEntries() {
		if (dynamicStackEntries == null) {
			loadDynamicPaletteEntries();
		}
		return dynamicStackEntries.toArray(new DynamicPaletteEntry[dynamicStackEntries.size()]);
	}

	/**
	 * Return the list of known dynamic resource type ids
	 * 
	 * @return the list of dynamic resource type ids
	 */
	public synchronized List<String> getDynamicResourceTypeIds() {
		List<String> dynamicIds = new ArrayList<String>();
		DynamicPaletteEntry[] paletteEntries = getDynamicPaletteEntries();
		for (int i = 0; i < paletteEntries.length; i++) {
			dynamicIds.add(paletteEntries[i].getId());
		}
		return dynamicIds;
	}

	private void loadDynamicPaletteEntries() {
		dynamicPaletteEntries = new ArrayList<DynamicPaletteEntry>();
		dynamicStackEntries = new ArrayList<DynamicPaletteEntry>();

		try {
			ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceVisitor() {

				public boolean visit(IResource resource) /* throws CoreException */{
					if (resource instanceof IFile && isDynamicTypesFile(resource)) {
						loadDynamicPaletteEntry((IFile) resource);
					}

					// Recurse
					return true;
				}
			}, IResource.DEPTH_INFINITE, IResource.FILE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
		}
	}

	protected void loadDynamicPaletteEntry(IFile res) {
		URI uri = URI.createPlatformResourceURI(res.getFullPath().toString());
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource emfResource = resourceSet.getResource(uri, true);
			loadDynamicPaletteEntries(emfResource, res.getProject().getName());
		} catch (Exception ex) {
			DeployCorePlugin.logError(0, "Couldn't load " + res.getFullPath().toString(), ex); //$NON-NLS-1$
		}
	}

	protected void removeDynamicPaletteEntries(IFile res) {
		// For Const 2.0, we do not have project-based indexing of the dynamic types, so we are forced
		// to load the dynamictypes.xml to update the palette registry upon project close/deletion.

		if (res.isAccessible()) {
			Resource resource = getResource(res);
			if (resource == null) {
				return;
			}
			removeDynamicPaletteEntries(resource, res.getProject().getName());
		}
	}

	private Resource getResource(IFile res) {
		URI uri = URI.createPlatformResourceURI(res.getFullPath().toString());
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			return resourceSet.getResource(uri, true);

		} catch (Exception ex) {
			DeployCorePlugin.logError(0, "Couldn't load " + res.getFullPath().toString(), ex); //$NON-NLS-1$
		}
		return null;
	}

	private void loadDynamicPaletteEntries(Resource res, String projectName) {
		if (res.getContents().size() > 0) {
			Object contents = res.getContents().get(0);
			if (contents instanceof DynamicTypeRoot) {
				DynamicTypeRoot root = (DynamicTypeRoot) contents;
				loadDynamicPaletteEntries(root.getDynamicTypes(), projectName);
			}
		}
	}

	private DynamicTypes getDynamicTypes(Resource res) {
		DynamicTypeRoot root = null;
		if (res.getContents().size() <= 0) {
			return null;
		}
		Object contents = res.getContents().get(0);
		if (contents instanceof DynamicTypeRoot) {
			root = (DynamicTypeRoot) contents;
			if (root == null) {
				return null;
			}
		} else {
			return null;
		}

		return root.getDynamicTypes();
	}

	private void removeDynamicPaletteEntries(Resource res, String projectName) {
		DynamicTypes types = getDynamicTypes(res);
		if (types == null) {
			return;
		}
		Iterator<DynamicPaletteEntry> entries = types.getPaletteEntries().iterator();
		while (entries.hasNext()) {
			DynamicPaletteEntry entry = entries.next();
			// TODO this will be cleaned when we have indexing of dyn types entries
			if (entry.getKind().equals(TOOL_KIND)) {
				for (int i = 0; i < dynamicPaletteEntries.size(); i++) {
					DynamicPaletteEntry ent = dynamicPaletteEntries.get(i);
					if (ent.getId().equals(entry.getId())) {
						dynamicPaletteEntries.remove(i);
						break;
					}
				}
			} else if (entry.getKind().equals(STACK_KIND)) {
				for (int i = 0; i < dynamicStackEntries.size(); i++) {
					DynamicPaletteEntry ent = dynamicStackEntries.get(i);
					if (ent.getId().equals(entry.getId())) {
						dynamicStackEntries.remove(i);
						copyStackEntry(ent, projectName);
						break;
					}
				}
			}
		}
	}

	private void copyStackEntry(DynamicPaletteEntry stackEntry, String projectName) {
		for (Iterator<DynamicPaletteEntry> iterator = dynamicPaletteEntries.iterator(); iterator
				.hasNext();) {
			DynamicPaletteEntry type = iterator.next();
			if (type.getPath().contains(stackEntry.getId())) {
				Resource resource = type.eResource();
				if (resource != null) {
					IProject project = null;
					IFile file = ResourceUtilities.getPlatformFile(resource.getURI());
					if (file != null) {
						project = file.getProject();
					}
					if (project != null && !project.getName().equals(projectName)
							&& !dynamicStackEntries.contains(stackEntry)) {
						createStackEntry(stackEntry, project);
					}

				}
			}

		}

	}

	private void createStackEntry(final DynamicPaletteEntry stackEntry, final IProject project) {
		WorkspaceJob job = new WorkspaceJob("modify stack entry") { //$NON-NLS-1$
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				addDynamicPaletteStack(stackEntry, project.getName());
				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(
				getDynamicTypesFile(project)));
		job.schedule();
	}

	public void remo(final IFile file) {

		WorkspaceJob job = new WorkspaceJob("Update Dynamic Xml File") { //$NON-NLS-1$
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				String templatePath = URI.createPlatformResourceURI(file.getFullPath().toString(),
						false).toString();
				getDynamicEntryFromTemplateURI(templatePath);

				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
		job.schedule();
	}

	private void loadDynamicPaletteEntries(DynamicTypes types, String projectName) {

		// TODO handle stacks here

		if (types == null) {
			return;
		}
		Iterator<DynamicPaletteEntry> entries = types.getPaletteEntries().iterator();
		while (entries.hasNext()) {
			DynamicPaletteEntry entry = entries.next();

			if (entry.getKind() == null) {
				// TODO empty palette kind
			} else if (entry.getKind().equals(TOOL_KIND)) {
				// Here we are loading from dynamictype.xml, must build the correct URI path
				String templatePath = entry.getTemplateURI();
				if (!templatePath.startsWith(PLATFORM_RESOURCE_PREFIX + projectName)) {
					String newTemplatePath = createPlatformReourceTemplateUri(projectName, templatePath);
					entry.setTemplateURI(newTemplatePath);
				}
				String diagramPath = entry.getDiagramPath();

				if (diagramPath != null
						&& !diagramPath.startsWith(PLATFORM_RESOURCE_PREFIX + projectName)) {
					diagramPath = createPlatformReourceTemplateUri(projectName, diagramPath);
					entry.setDiagramPath(diagramPath);
				}
				// Add to dynamic list of palette entries
				if (dynamicStackEntries == null) {
					loadDynamicPaletteEntries();
				}
				dynamicPaletteEntries.add(entry);
			} else if (entry.getKind().equals(STACK_KIND)) {
				// Add to dynamic list of stack entries
				dynamicStackEntries.add(entry);
			} else {
				// TODO unsupported palette kind
			}
		}

	}

	private boolean isDynamicTypesFile(IResource resource) {
		// Use below code if desire to enforce dynamictypes.xml files to exist 
		// in a .templates folder.  For M7, we will not enforce this as to not 
		// break existing scenarios with dt.xml files at the project level
		/*
		 * if (resource.getName().equals(IConstants.DYNAMIC_TYPES_FILE) &&
		 * resource.getParent().getName().equals(DYNAMIC_TEMPLATES_FOLDER)) { return true; } return
		 * false;
		 */

		return resource.getName().equals(IConstants.DYNAMIC_TYPES_FILE);
	}

	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName, String templateUri) {
		this.templateUri = templateUri;
		addDynamicResourceType(id, path, label, description, smallIcon, largeIcon, units, projectName);

	}

	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName, String templateUri,
			String templateVUri) {
		this.templateUri = templateUri;
		this.templateVUri = templateVUri;
		addDynamicResourceType(id, path, label, description, smallIcon, largeIcon, units, projectName);

	}

	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName) {

		List<Unit> unitList = resolveProxiedUnits(units);
		List<Unit> copy = new LinkedList<Unit>(ResolutionUtils.partialIntelligentDeepCopy(unitList,
				false));

		// write dynamic template file
		if (templateUri == null) {
			try {
				templateUri = writeDynamicTemplateFile(copy.toArray(new Unit[0]), projectName, id,
						label);
				// TODO new API that does not require an annotation?
			} catch (Exception e) {
				DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
				return;
			}
		}

		DynamicPaletteEntry paletteEntry = createDynamicPaletteEntry(id, path, label, description,
				smallIcon, largeIcon, templateUri);

		if (templateVUri != null) {
			paletteEntry.setDiagramPath(templateVUri);
		}

		// update caches
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}
		dynamicPaletteEntries.add(paletteEntry);

		// Add entry to side file
		addEntryToDynamicTypesFile(projectName, paletteEntry);

		// fire palette extensions changed event
		firePaletteExtensionsChanged();
		templateUri = null;
		templateVUri = null;
	}

	public void addDynamicResourceType(DynamicPaletteEntry paletteEntry, String projectName) {

		// update caches
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}
		String tempUri = paletteEntry.getTemplateURI();
		if (!tempUri.startsWith(PLATFORM_RESOURCE_PREFIX + projectName)) {
			String newTemplatePath = createPlatformReourceTemplateUri(projectName, tempUri);
			paletteEntry.setTemplateURI(newTemplatePath);
		}
		tempUri = paletteEntry.getDiagramPath();
		if (!tempUri.startsWith(PLATFORM_RESOURCE_PREFIX + projectName)) {
			String newTemplatePath = createPlatformReourceTemplateUri(projectName, tempUri);
			paletteEntry.setDiagramPath(newTemplatePath);
		}
		dynamicPaletteEntries.add(paletteEntry);

		// Add entry to side file
		addEntryToDynamicTypesFile(projectName, paletteEntry);

		// fire palette extensions changed event
		firePaletteExtensionsChanged();
		templateUri = null;
		templateVUri = null;
	}

	private List<Unit> resolveProxiedUnits(Unit[] units) {
		List<Unit> unitList = new ArrayList<Unit>();
		for (int i = 0; i < units.length; i++) {
			Unit unit = units[i];
			if (unit instanceof Proxy) {
				Object obj = ProxyConfiguration.getSource(unit);
				if (obj instanceof Unit) {
					unitList.add((Unit) obj);
				}
			} else {
				unitList.add(unit);
			}
		}
		return unitList;
	}

	public void addDynamicPaletteStack(String id, String path, String label, String icon,
			String projectName) {
		DynamicPaletteEntry paletteEntry = createDynamicStackEntry(id, path, label, icon);
		dynamicStackEntries.add(paletteEntry);

		// Add entry to side file
		addEntryToDynamicTypesFile(projectName, paletteEntry);

		// TODO set up so don't have to fire this twice, or hit resource twice, etc.
		// fire palette extensions changed event
		firePaletteExtensionsChanged();

	}

	public void addDynamicPaletteStack(DynamicPaletteEntry entry, String projectName) {
		dynamicStackEntries.add(entry);

		// Add entry to side file
		addEntryToDynamicTypesFile(projectName, entry);

		// TODO set up so don't have to fire this twice, or hit resource twice, etc.
		// fire palette extensions changed event
		firePaletteExtensionsChanged();

	}

	//TODO handle properly via scribbler
	private void addEntryToDynamicTypesFile(String projectName, DynamicPaletteEntry entry) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		String filePath = DYNAMIC_TEMPLATES_FOLDER + SEPARATOR + IConstants.DYNAMIC_TYPES_FILE;
		IPath path = project.getFullPath().append(filePath);
		URI uri = URI.createPlatformResourceURI(path.toString());
		IFile file = ResourceUtilities.getPlatformFile(uri);
		String uristri = null;

		DynamicTypeRoot root;
		DynamicTypes types;
		Resource res;

		// Strip out existing platform URI info
		if (entry.getKind().equals(TOOL_KIND)) {
			uristri = entry.getTemplateURI();
			String removestr = PLATFORM_RESOURCE_PREFIX + projectName + SEPARATOR;
			if (uristri.startsWith(removestr)) {
				String newuristr = uristri.substring(removestr.length());
				entry.setTemplateURI(newuristr);
			}
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		if (file.exists()) {
			res = resourceSet.getResource(uri, true);
			root = (DynamicTypeRoot) res.getContents().get(0);
			types = root.getDynamicTypes();
			types.getPaletteEntries().add(entry);

		} else {
			res = WorkbenchResourceHelper.getOrCreateResource(uri, resourceSet);
			// Need an 1st-class extension parser, but cannot register with current (xml)
			// file extensions for dynamic types file
			// Setting UTF encoding manually here for now
			if (res instanceof XMLResource) {
				((XMLResource) res).setEncoding("UTF-8");//$NON-NLS-1$
			}
			root = DynamictypeFactory.eINSTANCE.createDynamicTypeRoot();
			res.getContents().add(root);
			types = DynamictypeFactory.eINSTANCE.createDynamicTypes();
			root.setDynamicTypes(types);
		}
		types.getPaletteEntries().add(entry);
		try {
			res.save(null);
		} catch (IOException e) {
			DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
		}

		// Reset uri
		if (entry.getKind().equals(TOOL_KIND)) {
			entry.setTemplateURI(uristri);
		}

	}

	/**
	 * 
	 * @param projectName
	 *           The name of a project.
	 * @return An {@link IFile} that will store dynamic resource type information (dynamicTypes.xml).
	 */
	public IFile computeDynamicResourceTypesFile(String projectName) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		String filePath = DYNAMIC_TEMPLATES_FOLDER + SEPARATOR + IConstants.DYNAMIC_TYPES_FILE;
		IPath path = project.getFullPath().append(filePath);
		URI uri = URI.createPlatformResourceURI(path.toString());
		return ResourceUtilities.getPlatformFile(uri);
	}

	//TODO handle properly via scribbler
	private void removeEntryFromDynamicTypesFile(String projectName, DynamicPaletteEntry entry) {
		URI uri = URI.createPlatformResourceURI(projectName + SEPARATOR + DYNAMIC_TEMPLATES_FOLDER
				+ SEPARATOR + IConstants.DYNAMIC_TYPES_FILE);
		IFile file = ResourceUtilities.getPlatformFile(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res;
		if (file.exists()) {
			res = resourceSet.getResource(uri, true);
			DynamicTypeRoot root = (DynamicTypeRoot) res.getContents().get(0);
			DynamicTypes types = root.getDynamicTypes();
			if (types != null) {
				Iterator it = types.getPaletteEntries().iterator();
				while (it.hasNext()) {
					DynamicPaletteEntry dynentry = (DynamicPaletteEntry) it.next();
					if (dynentry.getId().equals(entry.getId())) {
						types.getPaletteEntries().remove(dynentry);
						try {
							res.save(null);
						} catch (IOException e) {
							DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
						}
						return;
					}
				}
			}
		}
	}

	/**
	 * Remove a dynamic resource type
	 * 
	 * @param resourceId
	 */

	public void removeDynamicResourceType(String resourceId) {
		// Remove the entry from the dynamic list(s)
		DynamicPaletteEntry condemned = getDynamicPaletteEntry(resourceId);

		dynamicPaletteEntries.remove(condemned);

		firePaletteExtensionsChanged();

		IFile file = ResourceUtilities.getPlatformFile(URI.createURI(condemned.getTemplateURI()));

		if (file != null && file.isAccessible()) {
			// Remove entry from side file
			removeEntryFromDynamicTypesFile(file.getProject().getName(), condemned);

			try {
				file.delete(true, null);
			} catch (CoreException e) {
				DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
			}

		}
	}

	private DynamicPaletteEntry getDynamicPaletteEntry(String resourceId) {
		Iterator<DynamicPaletteEntry> it = getDynamicPaletteEntriesAsList().iterator();
		while (it.hasNext()) {
			DynamicPaletteEntry entry = it.next();
			if (entry.getId().equals(resourceId)) {
				return entry;
			}
		}

		return null;
	}

	private DynamicPaletteEntry getDynamicStackEntry(String stackId) {
		Iterator<DynamicPaletteEntry> it = getDynamicStackEntriesAsList().iterator();
		while (it.hasNext()) {
			DynamicPaletteEntry entry = it.next();
			if (entry.getId().equals(stackId)) {
				return entry;
			}
		}

		return null;
	}

	private List<DynamicPaletteEntry> getDynamicEntryFromTemplateURI(String templateURI) {
		List<DynamicPaletteEntry> entries = new ArrayList<DynamicPaletteEntry>();

		if (dynamicPaletteEntries != null) {
			for (Iterator<DynamicPaletteEntry> it = dynamicPaletteEntries.iterator(); it.hasNext();) {
				DynamicPaletteEntry entry = it.next();
				if (entry.getTemplateURI().equals(templateURI)) {
					entries.add(entry);
				}
			}
		}
		if (!entries.isEmpty()) {
			dynamicPaletteEntries.removeAll(entries);
			firePaletteExtensionsChanged();
		}
		return entries;
	}

	private List<DynamicPaletteEntry> getDynamicPaletteEntriesAsList() {
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}

		return dynamicPaletteEntries;
	}

	private List<DynamicPaletteEntry> getDynamicStackEntriesAsList() {
		if (dynamicStackEntries == null) {
			loadDynamicPaletteEntries();
		}

		return dynamicStackEntries;
	}

	private String writeDynamicTemplateFile(Unit[] units, String projectName, String id, String label)
			throws EditModelException, ExecutionException, IOException {

		// Create a topology to hold the Unit copies
		currentTopology = CoreFactory.eINSTANCE.createTopology();

		currentTopology.setName(id);
		currentTopology.setDisplayName(label);
		for (int i = 0; i < units.length; i++) {
			currentTopology.getUnits().add(units[i]);
		}
		installPublicEditableContract(currentTopology);
		// Create annotation for resource type id - defect 1923
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext(IAnnotationConstants.DYNAMIC_RESOURCE_TYPE);
		annotation.getDetails().put("resourceId", id); //$NON-NLS-1$
		currentTopology.getAnnotations().add(annotation);
		final DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(currentTopology);

		// Deal with folder here
		String templateFilename = id + DYNAMIC_TEMPLATE_EXTENSION;
		URI uri = URI.createPlatformResourceURI(projectName + SEPARATOR + DYNAMIC_TEMPLATES_FOLDER
				+ SEPARATOR + templateFilename, false);

		try {
			writeToFile(root, uri);
		} finally {
		}

		String templateUri = null;
		templateUri = uri.toString();
		return templateUri;
	}

	private void installPublicEditableContract(Topology top) {
		ContractProvider provider = ContractProviderManager.INSTANCE
				.createProvider(DeployCoreMessages.ContractProviderManager_Make_All_Units_Public_Editable_By_D_);
		provider.installContract(top);
	}

	private void writeToFile(DeployCoreRoot root, URI uri) throws ExecutionException,
			EditModelException, IOException {
		writeToFileScribbler(root, uri);
		//writeToFileEMF(root, uri);
	}

	private void writeToFileScribbler(final DeployCoreRoot root, URI uri) throws EditModelException,
			ExecutionException {
// Write the Topology to uri using a scribbler
		IFile topologyFile = WorkbenchResourceHelper.getPlatformFile(uri);
		IEditModelScribbler scribbler = new DeploymentTopologyDomain(topologyFile)
				.createScribblerForWrite();
		try {
			final Resource res = scribbler.getResource(topologyFile);

			//			res.getContents().add(root);

			AbstractEMFOperation trans = new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(res), IConstants.EMPTY_STRING) {
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					res.getContents().add(root);

					try {
						res.save(null);
					} catch (IOException e) {
						throw new ExecutionException(e.getLocalizedMessage(), e);
					}

					return Status.OK_STATUS;
				}
			};

			IProgressMonitor monitor = new NullProgressMonitor();
			trans.execute(monitor, null);

			scribbler.save(false, monitor);
		} finally {
			if (scribbler != null) {
				scribbler.close(new NullProgressMonitor());
			}

		}
	}

	// TODO I added a listener so editors could tell when the palette extensions
	// change;
	// is this the correct Eclipse pattern for doing this?

	/**
	 * @param listener
	 */
	public synchronized void addPaletteChangeListener(PaletteExtensionListener listener) {
		changeListeners.add(listener);
	}

	/**
	 * @param listener
	 */
	public synchronized void removePaletteChangeListener(PaletteExtensionListener listener) {
		changeListeners.remove(listener);
	}

	/**
	 * Notifies registered listeners of change in the active tool on the palette
	 */
	synchronized private void firePaletteExtensionsChanged() {
		if (changeListeners == null) {
			return;
		}

		for (Iterator it = changeListeners.iterator(); it.hasNext();) {
			PaletteExtensionListener listener = (PaletteExtensionListener) it.next();
			listener.paletteRegistryChanged();
		}
	}

	/**
	 * Returns true if the specifed resourceTypeId is a dynamic palette entry
	 * 
	 * @param resourceTypeId
	 * @return true if the specified id is dynamic
	 */
	public boolean isDynamicPaletteEntry(String resourceTypeId) {
		if (dynamicPaletteEntries == null) {
			loadDynamicPaletteEntries();
		}
		Iterator<DynamicPaletteEntry> it = dynamicPaletteEntries.iterator();
		while (it.hasNext()) {
			DynamicPaletteEntry entry = it.next();
			if (entry.getId().equals(resourceTypeId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the descriptive name of the resource type with the specified id. May be either a static
	 * or dynamic resource
	 * 
	 * @param the
	 *           id
	 * @retrun the name
	 */
	public String getResourceTypeName(String id) {
		ResourceTypeUIBindingDescriptor desc = ResourceTypeService.INSTANCE
				.getResourceTypeUIBindingDescriptor(id);
		if (desc != null) {
			if (desc.getName().equals("")) { //$NON-NLS-1$
				return getResourceTypeDescriptor(id).getName();
			} else {
				return desc.getName();
			}
		}
		DynamicPaletteEntry entry = ResourceTypeService.INSTANCE.getDynamicPaletteEntry(id);
		if (entry != null) {
			return entry.getLabel();
		}
		return null;
	}

	public DynamicPaletteEntry createDynamicPaletteEntry(String id, String path, String label,
			String desc, String smallIcon, String largeIcon, String templateUri) {

		DynamicPaletteEntry entry = DynamictypeFactory.eINSTANCE.createDynamicPaletteEntry();
		entry.setId(id);
		entry.setPath(path);
		entry.setLabel(label);
		entry.setDescription(desc);
		entry.setSmallIcon(smallIcon);
		entry.setLargeIcon(largeIcon);
		entry.setTemplateURI(templateUri);
		entry.setKind(TOOL_KIND);
		return entry;
	}

	public DynamicPaletteEntry createDynamicPaletteEntry(String id, String path, String label,
			String desc, String smallIcon, String largeIcon, String templateUri, String templateVURI) {

		DynamicPaletteEntry entry = createDynamicPaletteEntry(id, path, label, desc, smallIcon,
				largeIcon, templateUri);
		entry.setDiagramPath(templateVURI);
		return entry;
	}

	public DynamicPaletteEntry createDynamicStackEntry(String id, String path, String label,
			String icon) {
		DynamicPaletteEntry entry = DynamictypeFactory.eINSTANCE.createDynamicPaletteEntry();
		entry.setId(id);
		entry.setPath(path);
		entry.setLabel(label);
		entry.setSmallIcon(icon);
		entry.setKind(STACK_KIND);
		return entry;
	}

	public boolean isDynamicPaletteEntry(Topology topology) {

		Annotation annotation = topology.findAnnotation(IAnnotationConstants.DYNAMIC_RESOURCE_TYPE);
		if (annotation != null) {
			String resourceTypeId = (String) annotation.getDetails().get("resourceId"); //$NON-NLS-1$
			if (getDynamicPaletteEntry(resourceTypeId) != null) {
				return true;
			}
		}
		return false;
	}

	public void renameResourceType(String id, String name) {
		DynamicPaletteEntry entry = getDynamicPaletteEntry(id);

		IFile file = ResourceUtilities.getPlatformFile(URI.createURI(entry.getTemplateURI()));
		DynamicPaletteEntry newEntry = renameEntryInDynamicTypesFile(file.getProject().getName(),
				entry, name);

		// update list
		dynamicPaletteEntries.remove(entry);

		// Add full path info to URI for in-memory version
		if (!newEntry.getTemplateURI().startsWith(PLATFORM_RESOURCE_PREFIX)) {
			String newuri = PLATFORM_RESOURCE_PREFIX + file.getProject().getName() + SEPARATOR
					+ newEntry.getTemplateURI();
			newEntry.setTemplateURI(newuri);
		}
		dynamicPaletteEntries.add(newEntry);

		firePaletteExtensionsChanged();
	}

	//TODO handle properly via scribbler
	private DynamicPaletteEntry renameEntryInDynamicTypesFile(String projectName,
			DynamicPaletteEntry entry, String newName) {
		URI uri = URI.createPlatformResourceURI(projectName + SEPARATOR + DYNAMIC_TEMPLATES_FOLDER
				+ SEPARATOR + IConstants.DYNAMIC_TYPES_FILE);

		IFile file = ResourceUtilities.getPlatformFile(uri);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res;
		if (file.exists()) {
			res = resourceSet.getResource(uri, true);
			DynamicTypeRoot root = (DynamicTypeRoot) res.getContents().get(0);
			DynamicTypes types = root.getDynamicTypes();
			if (types != null) {
				Iterator it = types.getPaletteEntries().iterator();
				while (it.hasNext()) {
					DynamicPaletteEntry dynentry = (DynamicPaletteEntry) it.next();
					if (dynentry.getId().equals(entry.getId())) {
						dynentry.setLabel(newName);
						try {
							res.save(null);
						} catch (IOException e) {
							DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
						}
						return dynentry;
					}
				}
			}
		}
		return null;
	}

	private String createPlatformReourceTemplateUri(String projectName, String templatePath) {
		String path = projectName + SEPARATOR + templatePath;
		return URI.createPlatformResourceURI(path).toString();
	}

	private class ResourceTypeResourceListener implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {

			// Project delete/close
			if (event.getType() == IResourceChangeEvent.PRE_DELETE
					|| event.getType() == IResourceChangeEvent.PRE_CLOSE) {
				if (event.getResource().getType() == IResource.PROJECT) {
					IFile file = getDynamicTypesFile((IProject) event.getResource());
					if (file != null) {
						removeDynamicPaletteEntries(file);
						firePaletteExtensionsChanged();
					}
				}
			}
			// All others can be handled post change

			else if (event.getType() != IResourceChangeEvent.POST_CHANGE) {
				return;
			}

			IResourceDelta rootDelta = event.getDelta();

			try {
				if (rootDelta != null) {
					rootDelta.accept(resourceDeltaVisitor);
				}
			} catch (CoreException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
		}
	}

	boolean update = false;

	private class ResourceTypeDeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) {

			IResource resource = delta.getResource();
			switch (resource.getType())
			{
			case IResource.ROOT: {
				return true;
			}
			case IResource.FILE: {
				if (delta.getKind() == IResourceDelta.REMOVED
						&& (delta.getFlags() & IResourceDelta.REPLACED) == 0) {
					IFile file = (IFile) resource;
					if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
						removeDynamicEntries(file);
						//cleanStackEntries();
						return false;
					} else {
						IProject project = file.getProject();
						IFile dynamicFile = getDynamicTypesFile(project);
						if (dynamicFile != null && dynamicFile.exists()) {
							IPath movedToPath = delta.getMovedToPath();
							IPath movedFromPath = file.getFullPath();
							synchEntry(dynamicFile, movedToPath, movedFromPath);
						}
					}
				}
				return true;
			}
			case IResource.PROJECT: {
				IProject project = (IProject) resource;
				IFile file = getDynamicTypesFile(project);
				if (file != null) {
					// New and opened projects
					if (delta.getKind() == IResourceDelta.ADDED) {
						loadDynamicPaletteEntry(file);
						firePaletteExtensionsChanged();
					} else if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
						if (project.isOpen()) {
							loadDynamicPaletteEntry(file);
							firePaletteExtensionsChanged();
						}
					}
				}
				return true; // don't traverse into the project
			}
			default:
				return true; // don't traverse into other branches
			}
		}

	};

	public IFile getDynamicTypesFile(IProject project) {
		IPath dynTypesFilePath = new Path(DYNAMIC_TEMPLATES_FOLDER + SEPARATOR
				+ IConstants.DYNAMIC_TYPES_FILE);
		IResource res = project.findMember(dynTypesFilePath);
		if (res != null && res.getType() == IResource.FILE) {
			return (IFile) res;
		}
		return null;
	}

	public void removeDynamicEntries(final IFile file) {

		WorkspaceJob job = new WorkspaceJob("Update Dynamic Xml File") { //$NON-NLS-1$
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				String templatePath = URI.createPlatformResourceURI(file.getFullPath().toString(),
						false).toString();
				getDynamicEntryFromTemplateURI(templatePath);

				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
		job.schedule();
	}

	public Topology getCurrentTopology() {
		return currentTopology;
	}

	public URI createStandaloneDynamicTypesFile(String fileName, String fileFolder,
			String projectName, String resourceTypeId, boolean setTeamPrivate) {

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		assert project != null;
		String filePath = fileFolder + SEPARATOR + fileName;
		IPath path = project.getFullPath().append(filePath);
		URI uri = URI.createPlatformResourceURI(path.toString());
		IFile file = ResourceUtilities.getPlatformFile(uri);
		String uristri = null;

		DynamicTypeRoot root;
		DynamicTypes types;
		Resource res = null;

		DynamicPaletteEntry entry = getDynamicPaletteEntry(resourceTypeId);
		DynamicPaletteEntry stack = null;

		// TODO see if this entry's path is a custom stack
		String entryPath = entry.getPath();
		String entryStack = entryPath.substring(entryPath.lastIndexOf(SEPARATOR) + 1);
		// Lookup the DynamicStackEntry for it
		if (entryStack != null && entryStack.length() > 0) {
			stack = getDynamicStackEntry(entryStack);
		}

		// Strip out existing platform URI info
		if (entry.getKind().equals(TOOL_KIND)) {
			uristri = entry.getTemplateURI();
			String removestr = PLATFORM_RESOURCE_PREFIX + projectName + SEPARATOR;
			if (uristri.startsWith(removestr)) {
				String newuristr = uristri.substring(removestr.length());
				entry.setTemplateURI(newuristr);
			}
		}
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			if (file.exists()) {
				// Delete it 
				file.delete(true, null);
			}
			res = WorkbenchResourceHelper.getOrCreateResource(uri, resourceSet);
			// Need an 1st-class extension parser, but cannot register with current (xml)
			// file extensions for dynamic types file
			// Setting UTF encoding manually here for now
			if (res instanceof XMLResource) {
				((XMLResource) res).setEncoding("UTF-8");//$NON-NLS-1$
			}
			root = DynamictypeFactory.eINSTANCE.createDynamicTypeRoot();
			res.getContents().add(root);
			types = DynamictypeFactory.eINSTANCE.createDynamicTypes();
			types.getPaletteEntries().add(entry);
			if (stack != null) {
				types.getPaletteEntries().add(stack);
			}
			root.setDynamicTypes(types);
			res.save(null);
			if (setTeamPrivate) {
				file = ResourceUtilities.getPlatformFile(uri);
				file.getParent().setTeamPrivateMember(true);
			}

		} catch (IOException e) {
			DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
		}

		// Reset uri
		if (entry.getKind().equals(TOOL_KIND)) {
			entry.setTemplateURI(uristri);
		}

		if (res != null) {
			return res.getURI();
		}
		return null;

	}

	private IUndoableOperation getModifyEntryOperation(final DynamicPaletteEntry entry,
			final String templateValue, final String templateURIValue, Resource resource) {
		AbstractEMFOperation op = new AbstractEMFOperation(
				TransactionUtil.getEditingDomain(resource),
				DeployCoreMessages.ResourceTypeService_Modify_templateUri_and_templateVuri_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				entry.setTemplateURI(templateValue);
				entry.setDiagramPath(templateURIValue);
				try {
					entry.eResource().save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};

		return op;
	}

	private void synchEntry(final IFile file, final IPath movedToPath, final IPath movedFromPath) {
		WorkspaceJob job = new WorkspaceJob(
				DeployCoreMessages.ResourceTypeService_Modify_templateUri_and_templateVuri_) {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				updateEntry(file, movedToPath, movedFromPath);
				return Status.OK_STATUS;
			}
		};
		job.setRule(file);
		job.schedule();
	}

	private void updateEntry(IFile file, IPath movedToPath, IPath movedFromPath) {

		IProject project = file.getProject();
		if (movedFromPath == null) {
			return;
		}
		Resource resource = getResource(file);
		if (!resource.isLoaded()) {
			try {
				resource.load(null);
			} catch (IOException e) {
				DeployCorePlugin.logError(IStatus.ERROR, e.getMessage(), e);
			}
		}
		if (resource == null) {
			return;
		}
		DynamicTypes types = getDynamicTypes(resource);
		if (types == null) {
			return;
		}
		movedFromPath = movedFromPath.removeFirstSegments(1).makeRelative();
		for (Iterator iterator = types.getPaletteEntries().iterator(); iterator.hasNext();) {
			DynamicPaletteEntry type = (DynamicPaletteEntry) iterator.next();
			if (TOOL_KIND.equals(type.getKind())) {
				String currentPath = type.getTemplateURI();
				if (currentPath.equals(movedFromPath.toString())) {
					updateTemplateInfo(project, type, movedToPath, movedFromPath, resource);
				}
			}
		}

	}

	private void updateTemplateInfo(IProject project, DynamicPaletteEntry entry, IPath movedToPath,
			IPath movedFromPath, Resource resource) {

		Resource dynamicTypesRes = entry.eResource();
		removeDynamicResourceType(entry.getId());
		if (movedToPath != null) {
			IPath diagramPath = movedToPath;
			diagramPath.removeFileExtension();
			diagramPath.addFileExtension(IConstants.TOPOLOGYV_EXTENSION);
			IPath projectRelativemovedToPath = movedToPath.removeFirstSegments(1);
			entry.setTemplateURI(projectRelativemovedToPath.toString());
			entry.setDiagramPath(diagramPath.toString());
			try {
				dynamicTypesRes.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Readd new entry
			// Add full path info to URI for in-memory version
			if (!entry.getTemplateURI().startsWith(PLATFORM_RESOURCE_PREFIX)) {
				String newuri = PLATFORM_RESOURCE_PREFIX + project.getName() + SEPARATOR
						+ entry.getTemplateURI();
				entry.setTemplateURI(newuri);
			}
			dynamicPaletteEntries.add(entry);
		}

		firePaletteExtensionsChanged();
	}

}
