package com.ibm.ccl.soa.deploy.uml.internal.mmi.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.sync.UnitSynchronizer;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class DeployMMIManager implements IResourceChangeListener, IDeployMMInterface {

	private static DeployMMIManager instance;
	private final Map<String, List<StructuredReference>> resourceStructureReferenceMap = new HashMap<String, List<StructuredReference>>();
	private final Map<IProject, List<String>> projectResourceMap = new HashMap<IProject, List<String>>();
	private final ArrayList<Resource> resources = new ArrayList<Resource>();
	private final ArrayList<IProject> projects = new ArrayList<IProject>();
	private final Map<String, String> interestedUMLResourcePaths = new HashMap<String, String>();

	private TransactionalEditingDomain domain;

	public void cache(TransactionalEditingDomain tDomain, StructuredReference reference,
			DeployModelObject dmo, ITarget target) {
		Resource resource = dmo.eResource();
		assert resource != null;
		assert tDomain != null;
		addDomain(tDomain);
		addMMICache(domain, target);
		addResource(resource);
		addResourceURI(reference, resource);
		addProject(resource);
	}

	private void addDomain(TransactionalEditingDomain tDomain) {
		if (domain == null || domain != tDomain) {
			domain = tDomain;
		}
	}

	private DeployMMIManager() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	private void addProject(Resource resource) {
		IProject project = ProjectUtilities.getProject(resource);
		assert project != null;
		if (projects.contains(project)) {
			return;
		}
		URI uri = resource.getURI();
		String path = uri.toPlatformString(true);
		projects.add(ProjectUtilities.getProject(resource));
		List<String> pathList = projectResourceMap.get(project);
		if (pathList == null) {
			pathList = new ArrayList<String>();
			pathList.add(path);
			projectResourceMap.put(project, pathList);
		} else {
			pathList.add(path);
		}

	}

	private void addMMICache(TransactionalEditingDomain domain, ITarget target) {
		MMIResourceCache.cache(domain, target);
	}

	private boolean addResourceURI(StructuredReference reference, Resource resource) {
		assert resource != null;
		URI uri = resource.getURI();
		String path = uri.toPlatformString(true);
		List<StructuredReference> referencesList = resourceStructureReferenceMap.get(path);
		if (referencesList == null) {
			referencesList = new ArrayList<StructuredReference>();
			referencesList.add(reference);
			resourceStructureReferenceMap.put(path, referencesList);
		} else if (!referencesList.contains(reference)) {
			referencesList.add(reference);
		}
		return true;
	}

	private void addResource(Resource resource) {
		if (resources.contains(resource)) {
			return;
		}
		resources.add(resource);
	}

	public static DeployMMIManager getInstance() {
		if (instance == null) {
			instance = new DeployMMIManager();
		}
		return instance;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() != IResourceChangeEvent.POST_CHANGE) {
			return;
		}
		IResourceDeltaVisitor visitor = createVisitor();
		assert event.getDelta() != null;
		try {
			event.getDelta().accept(visitor);
		} catch (CoreException e) {
			DeployCorePlugin.logError(IStatus.ERROR, e.getLocalizedMessage(), e);
		}
	}

	private IResourceDeltaVisitor createVisitor() {
		return new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (delta != null) {
					final IResource resource = delta.getResource();
					if (!resource.isDerived()) {
						switch (resource.getType())
						{
						case IResource.ROOT:
							return true;
						case IResource.PROJECT: {
							IProject project = (IProject) resource;
							if (!isInterestedProject(project)) {
								return false;
							} else if (delta.getKind() == IResourceDelta.REMOVED) {
								uncacheResources(project);
								return false;
							} else if (delta.getKind() == IResourceDelta.CHANGED) {
								syncUI(project);
								return false;
							}
							return true;
						}
						case IResource.FILE: {
							if (isContentChange(delta)) {
								if (isInterestedResource(resource)) {
									handleFileDelta(delta, resource);
								} else if (isInterestedUMLResource(resource)) {
									notifyValidation();
								}
								return false;
							}
						}
						}
					}
				}
				return true;
			}

			private void notifyValidation() {
				// TODO Auto-generated method stub

			}

		};
	}

	protected void handleFileDelta(IResourceDelta delta, IResource resource) {
		if (delta.getKind() == IResourceDelta.CHANGED) {
			Object list = resourceStructureReferenceMap.get(resource.getFullPath().toString());
			if (list == null) {
				return;
			}
			List<StructuredReference> structuredReferences = (List<StructuredReference>) list;
			new UnitSynchronizer(domain, structuredReferences);

		}
	}

	protected void uncacheResources(IProject project) {

	}

	protected boolean isInterestedProject(IProject project) {
		return projects.contains(project);
	}

	protected boolean isInterestedResource(IResource resource) {
		return resources.contains(resource);
	}

	private boolean isContentChange(IResourceDelta delta) {
		return delta.getKind() == IResourceDelta.CHANGED
				&& (delta.getFlags() & IResourceDelta.CONTENT) != 0;
	}

	private boolean isDescriptionChange(IResourceDelta delta) {
		return delta.getKind() == IResourceDelta.CHANGED
				&& (delta.getFlags() & IResourceDelta.DESCRIPTION) != 0;
	}

	private void syncUI(IProject project) {
		Object pathObj = projectResourceMap.get(project);
		if (pathObj == null || !(pathObj instanceof List)) {
			return;
		}
		List<String> paths = (List<String>) pathObj;
		List<StructuredReference> structuredReferences = new ArrayList<StructuredReference>();
		for (Iterator<String> iterator = paths.iterator(); iterator.hasNext();) {
			String path = iterator.next();
			if (path == null) {
				continue;
			}
			Object referenceObj = resourceStructureReferenceMap.get(path);
			if (referenceObj == null || !(referenceObj instanceof List)) {
				continue;
			}
			List<StructuredReference> currentStructuredReferences = (List<StructuredReference>) referenceObj;
			structuredReferences.addAll(currentStructuredReferences);
		}
		if (!structuredReferences.isEmpty()) {
			new UnitSynchronizer(domain, structuredReferences);
		}
	}

	public List<StructuredReference> getStructuredReferences(String path) {
		return resourceStructureReferenceMap.get(path);
	}

	public void addUMLResoruce(Resource umlresource, String topologyPath) {
		if (umlresource == null) {
			return;
		}
		URI uri = umlresource.getURI();
		String path = uri.toPlatformString(true);
		interestedUMLResourcePaths.put(path, topologyPath);
	}

	public void removeUMLResoruce(Resource resource) {
		if (resource == null) {
			return;
		}
		URI uri = resource.getURI();
		String path = uri.toPlatformString(true);
		interestedUMLResourcePaths.remove(path);
	}

	protected boolean isInterestedUMLResource(IResource resource) {
		if (resource == null) {
			return false;
		}
		Set<String> paths = interestedUMLResourcePaths.keySet();
		return paths.contains(resource.getFullPath().toString());
	}

	protected void notifyListeners() {

	}

}
