package com.ibm.ccl.soa.deploy.index.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.content.ContentTypeManager;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.index.internal.Activator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.emf.index.internal.plugin.IndexPlugin;
import com.ibm.xtools.emf.index.search.IIndexSearchManager;
import com.ibm.xtools.emf.index.search.IndexContext;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;
import com.ibm.xtools.mmi.core.util.MMICoreUtil;

/**
 * The Query class is used to search for occurances of {@link DeployModelObject},
 * {@link DeployLink}, {@link Topology}, and {@link EObject}s within EMF based models that can be
 * found in the {@link IWorkspaceRoot} or in bundles deployed to the currently running instance of
 * the {@link org.eclipse#IWorkbench}. All methods in the Query class provide for the ability to
 * limit the scope of the search via a {@link Collection} of {@link IResource}s, {@code boolean}'s
 * to indicate if unloaded {@link Resource}s should be searched as well as {@link Resource}s
 * deployed in bundles. All methods also allow the caller to indicate if the index needs to be
 * synchronized prior to executing the search. This is very handy as it might take some time to
 * perform the synchronization and if the caller knows that a synchronization is not necessary
 * he/she can avoid the extra overhead. Also most of the methods will automatically limit the search
 * to a particular {@link IContentType} ( one of {@link #TOPOLOGY_MODEL_CONTENT_TYPE} or
 * {@link #TOPOLOGY_DIAGRAM_CONTENT_TYPE}.
 * 
 * @author Tim Pouyer <t>dot<pouyer>at<us>dot<ibm>dot<com>
 * @version %I%, %G%
 * @since 8.0
 * 
 */
@SuppressWarnings("restriction")
public class Query {

	protected static final String WILDCARD = "*"; //$NON-NLS-1$
	private static final boolean DEBUG = Activator.getDefault().isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(Activator.PLUGIN_ID
							+ "/debug/" + Query.class.getCanonicalName())); //$NON-NLS-1$

	/**
	 * {@link String} identifier for topology model file content types. i.e. files that have the
	 * extension {@link IConstants#TOPOLOGY_EXTENSION}
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IConstants#TOPOLOGY_EXTENSION
	 */
	public static final String TOPOLOGY_MODEL_CONTENT_TYPE_ID = "com.ibm.ccl.soa.deploy.core.topologyModelContentType"; //$NON-NLS-1$;

	/**
	 * An instance of {@link IContentType} for topology model file content types.
	 * 
	 * @see IContentType
	 * @see #TOPOLOGY_MODEL_CONTENT_TYPE_ID
	 * @see IConstants#TOPOLOGY_EXTENSION
	 */
	@SuppressWarnings("restriction")
	public static final IContentType TOPOLOGY_MODEL_CONTENT_TYPE = ContentTypeManager.getInstance()
			.getContentType(TOPOLOGY_MODEL_CONTENT_TYPE_ID);

	/**
	 * {@link String} identifier for topology diagram file content types. i.e. files that have the
	 * extension {@link IConstants#TOPOLOGYV_EXTENSION}
	 */
	public static final String TOPOLOGY_DIAGRAM_CONTENT_TYPE_ID = "com.ibm.ccl.soa.deploy.core.ui.topologyDiagramContentType"; //$NON-NLS-1$;

	/**
	 * An instance of {@link IContentType} for topology diagram file content types.
	 */
	@SuppressWarnings("restriction")
	public static final IContentType TOPOLOGY_DIAGRAM_CONTENT_TYPE = ContentTypeManager
			.getInstance().getContentType(TOPOLOGY_DIAGRAM_CONTENT_TYPE_ID);

	/**
	 * <p>
	 * Locates occurances of topology diagram {@link IFile}s that refer to the passed in
	 * {@link EObject} by use of {@link org.eclipse.emf.ecore#EReference} objects within the
	 * {@link Diagram} model. Only {@link #TOPOLOGY_DIAGRAM_CONTENT_TYPE}s will be searched.<br>
	 * <b>Note:</b> This method will not return diagram {@link IFile}s that refer to the passed in
	 * {@link EObject} through the use of an import. To find all diagrams that reference an
	 * {@link EObject} including via imports use
	 * {@link #findReferencingDiagramViews(DeployModelObject, Collection, boolean, boolean, boolean, boolean, IProgressMonitor)}.
	 * </p>
	 * 
	 * @param eObject
	 *           an instance of {@link EObject} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within EMF based models.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           {@code null} the {@code scope} will be automatically set to
	 *           {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link IFile}s that matched the search criteria
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<IFile> findReferencingDiagramResources(EObject eObject,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != eObject;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_DIAGRAM_CONTENT_TYPE);
		IndexContext context = createScopedContext(eObject.eResource().getResourceSet(), scope, types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findReferencingDiagramResources(context, eObject, monitor);
	}

	private static Collection<IFile> findReferencingDiagramResources(IndexContext context,
			EObject eObject, IProgressMonitor monitor) throws CoreException {

		@SuppressWarnings("unchecked")
		Collection<Resource> results = IIndexSearchManager.INSTANCE.findReferencingResources(context,
				eObject, monitor);
		return convertToIFileCollection(results);
	}

	/**
	 * <p>
	 * Locates occurances of {@link com.ibm.ccl.soa.deploy.core#Import} that refer to the passed in
	 * {@link Topology}. Matching logic is based on the values of the {@link Import#getNamespace()}
	 * and {@link Import#getName()} found in the instance of {@link Import} within the searched
	 * models. Only {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on matching the {@link Import#getNamespace()}
	 * and {@link Import#getName()} values from the {@link Import} class it is possible to return a
	 * match for an {@link Import} that points to a different {@link Topology} than the passed in
	 * {@link Topology}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * between two different {@link Topology} classes that reside in different {@link IProject}s in
	 * the {@link IWorkspaceRoot}.
	 * </p>
	 * 
	 * @param eObject
	 *           an instance of {@link Topology} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within EMF based models.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           {@code null} the {@code scope} will be automatically set to
	 *           {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link URI}s that point to the model element that matched the
	 *         search criteria.
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findImportingTopologyEObjects(Topology eObject,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != eObject;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);
		IndexContext context = createScopedContext(eObject.eResource().getResourceSet(), limitScope(
				scope, eObject), types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findImportingTopologyEObjects(context, eObject, monitor);
	}

	private static Collection<URI> findImportingTopologyEObjects(IndexContext context,
			Topology topology, IProgressMonitor monitor) throws CoreException {

		return findImportingTopologyEObjects(context, WorkbenchResourceHelper.getProject(topology
				.eResource()), topology.getNamespace(), topology.getName(), topology.eResource()
				.getResourceSet(), monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findImportingTopologyEObjects(IndexContext context,
			IProject project, String namespace, String topologyName, ResourceSet rset,
			IProgressMonitor monitor) throws CoreException {

		String ns = namespace;
		if (ns == null) {
			ns = IConstants.EMPTY_STRING;
		}

		@SuppressWarnings("unchecked")
		Collection<EObject> results = IIndexSearchManager.INSTANCE
				.findEObjects(context, ns, CorePackage.eINSTANCE.getImport_Namespace(),
						CorePackage.eINSTANCE.getImport(), monitor);

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);
		IndexContext anotherContext = createScopedContext(rset, limitScope(
				convertToIResourceCollection(results), project), types);
		anotherContext.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		anotherContext.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
		anotherContext.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
		anotherContext.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
				context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
		anotherContext.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
		anotherContext.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);
		Collection<EObject> refinedResults = IIndexSearchManager.INSTANCE.findEObjects(
				anotherContext, topologyName, CorePackage.eINSTANCE.getImport_Pattern(),
				CorePackage.eINSTANCE.getImport(), monitor);
		return convertToURICollection(refinedResults);
	}

	/**
	 * <p>
	 * Locates occurances of {@link com.ibm.ccl.soa.deploy.core#Import} that refer to the passed in
	 * {@link Topology}. Matching logic is based on the values of the {@link Import#getNamespace()}
	 * and {@link Import#getName()} found in the instance of {@link Import} within the searched
	 * models. Only {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on matching the {@link Import#getNamespace()}
	 * and {@link Import#getName()} values from the {@link Import} class it is possible to return a
	 * match for an {@link Import} that points to a different {@link Topology} than the passed in
	 * {@link Topology}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * between two different {@link Topology} classes that reside in different {@link IProject}s in
	 * the {@link IWorkspaceRoot}.
	 * </p>
	 * 
	 * @param topology
	 *           an instance of {@link Topology} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within EMF based models.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           {@code null} the {@code scope} will be automatically set to
	 *           {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link IFile}s that matched the search criteria
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<IFile> findImportingTopologyReferences(Topology topology,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != topology;

		IProject project = WorkbenchResourceHelper.getProject(topology.eResource());
		return findImportingTopologyReferences(project, topology.getNamespace(), topology.getName(),
				topology.eResource().getResourceSet(), scope, searchUnloadedResources,
				searchDeployedResources, synchronizeIndex, strictEclassEquality, monitor);
	}

	/**
	 * <p>
	 * Locates occurances of {@link com.ibm.ccl.soa.deploy.core#Import} that refer to the passed in
	 * {@link Topology}. Matching logic is based on the values of the {@link Import#getNamespace()}
	 * and {@link Import#getName()} found in the instance of {@link Import} within the searched
	 * models. Only {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on matching the {@link Import#getNamespace()}
	 * and {@link Import#getName()} values from the {@link Import} class it is possible to return a
	 * match for an {@link Import} that points to a different {@link Topology} than the passed in
	 * {@link Topology}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * between two different {@link Topology} classes that reside in different {@link IProject}s in
	 * the {@link IWorkspaceRoot}.
	 * </p>
	 * 
	 * @param project
	 *           The project that the target topology resides in
	 * @param namespace
	 *           The namespace of the target Topology
	 * @param topologyName
	 *           The name of the Topology
	 * @param rset
	 *           The associated ResourceSet to use for loading *
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           {@code null} the {@code scope} will be automatically set to
	 *           {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link IFile}s that matched the search criteria
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<IFile> findImportingTopologyReferences(IProject project,
			String namespace, String topologyName, ResourceSet rset, Collection<IResource> scope,
			boolean searchUnloadedResources, boolean searchDeployedResources,
			boolean synchronizeIndex, boolean strictEclassEquality, IProgressMonitor monitor)
			throws CoreException {

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);

		IndexContext context = createScopedContext(rset, limitScope(scope, project), types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findImportingTopologyReferences(context, project, namespace, topologyName, rset,
				monitor);
	}

	private static Collection<IFile> findImportingTopologyReferences(IndexContext context,
			IProject project, String namespace, String topologyName, ResourceSet rset,
			IProgressMonitor monitor) throws CoreException {
		Collection<URI> results = findImportingTopologyEObjects(context, project, namespace,
				topologyName, rset, monitor);

		// aggregate EObject results so that we only return 1 instance of
		// resource no matter how many hits we may have had on that resource
		Collection<IFile> returns = new ArrayList<IFile>(results.size());
		for (Iterator<URI> iter = results.iterator(); iter.hasNext();) {
			URI uri = iter.next();
			if (null != uri && !returns.contains(uri)) {
				IFile file = WorkbenchResourceHelper.getPlatformFile(uri);
				returns.add(file);
			}
		}

		return returns;
	}

	/**
	 * <p>
	 * Locate instances of {@link com.ibm.ccl.soa.deploy.core#DeployLink} who reference the passed in
	 * {@link DeployModelObject} via an {@link EReference} contained within the
	 * {@link DeployLink#getTargetURI()} {@link org.eclipse.emf.ecore#EFeature}. Only
	 * {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on matching the existence of a {@link String}
	 * value matching the standard import uri fragment formating ( i.e.
	 * %qualified.name.topology.name%:%/full/path/to/DMO% ) it is possible to return a match for a
	 * {@link DeployLink} that points to a different {@link Topology} than the passed in
	 * {@link DeployLink#getTopology()}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * and {@link DeployModelObject#getFullPath()} between two different {@link DeployModelObject}s
	 * that reside in different {@link Topology} models in different {@link IProject}s in the
	 * {@link IWorkspaceRoot}.
	 * 
	 * @param target
	 *           an instance of {@link DeployModelObject} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within {@link DeployLink}'s
	 *           {@link DeployLink#getTargetURI()}.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           {@code null} the {@code scope} will be automatically set to
	 *           {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link URI}s that point to the model element that matched the
	 *         search criteria.
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findDeployLinksByImportedTarget(final DeployModelObject target,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != target;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);
		final IndexContext context = createScopedContext(target.eResource().getResourceSet(),
				limitScope(scope, target), types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findDeployLinksByImportedTarget(context, target, monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findDeployLinksByImportedTarget(IndexContext context,
			DeployModelObject target, IProgressMonitor monitor) throws CoreException {

		String path = target.getFullPath();

		// if special zephyr proxy we need to find the real path of the target
		// not the import path
		path = getURI(target).fragment();

		// need to create a special context to limit the scope to only the project of the target
		// b/c we are searching for the zephyr proxy string %namespace.name% and not a true EReference
		// this opens up the possiblity of returning a false match if more than one deploy link exists
		// that points to another topology in another project that is not related to the topology
		// we are actually searching for ( should be a rare case but we still need to protect against it )
		IndexContext limited = createScopedContext(target.eResource().getResourceSet(), limitScope(
				convertToIResourceCollection2(context.getAllResourceURIs()), target), null);
		limited.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		limited.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
		limited.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
		limited.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
				context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
		limited.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
		limited.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		@SuppressWarnings("unchecked")
		Collection<EObject> results = IIndexSearchManager.INSTANCE.findEObjects(limited, target
				.getTopology().getQualifiedName()
				+ IConstants.TOPOLOGY_SEPARATOR + path + WILDCARD, false, CorePackage.eINSTANCE
				.getDeployLink_TargetURI(), CorePackage.eINSTANCE.getDeployLink(), monitor);

		return convertToURICollection(results);
	}

	/**
	 * <p>
	 * Locate instances of {@link com.ibm.ccl.soa.deploy.core#DeployLink} who reference the passed in
	 * {@link DeployModelObject} via an {@link EReference} contained within the
	 * {@link DeployLink#getSourceURI()} {@link org.eclipse.emf.ecore#EFeature}. Only
	 * {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on the existence of a {@link String} value
	 * matching the standard import uri fragment formating ( i.e.
	 * %qualified.name.topology.name%:%/full/path/to/DMO% ) it is possible to return a match for a
	 * {@link DeployLink} that points to a different {@link Topology} than the passed in
	 * {@link DeployLink#getTopology()}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * and {@link DeployModelObject#getFullPath()} between two different {@link DeployModelObject}s
	 * that reside in different {@link Topology} models in different {@link IProject}s in the
	 * {@link IWorkspaceRoot}.
	 * 
	 * @param source
	 *           an instance of {@link DeployModelObject} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within {@link DeployLink}'s
	 *           {@link DeployLink#getTargetURI()}.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           {@link IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           null the scope will be automatically set to {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link URI}s that point to the model element that matched the
	 *         search criteria.
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findDeployLinksByImportedSource(final DeployModelObject source,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != source;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);
		final IndexContext context = createScopedContext(source.eResource().getResourceSet(),
				limitScope(scope, source), types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findDeployLinksByImportedSource(context, source, monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findDeployLinksByImportedSource(IndexContext context,
			DeployModelObject source, IProgressMonitor monitor) throws CoreException {

		String path = source.getFullPath();

		// if special zephyr proxy we need to find the real path of the target
		// not the import path
		path = getURI(source).fragment();

		// need to create a special context to limit the scope to only the project of the source
		// b/c we are searching for the zephyr proxy string %namespace.name% and not a true EReference
		// this opens up the possiblity of returning a false match if more than one deploy link exists
		// that points to another topology in another project that is not related to the topology
		// we are actually searching for ( should be a rare case but we still need to protect against it )
		IndexContext limited = createScopedContext(source.eResource().getResourceSet(), limitScope(
				convertToIResourceCollection2(context.getAllResourceURIs()), source), null);
		limited.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		limited.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
		limited.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
		limited.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
				context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
		limited.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
		limited.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		@SuppressWarnings("unchecked")
		Collection<EObject> results = IIndexSearchManager.INSTANCE.findEObjects(limited, source
				.getTopology().getQualifiedName()
				+ IConstants.TOPOLOGY_SEPARATOR + path + WILDCARD, false, CorePackage.eINSTANCE
				.getDeployLink_SourceURI(), CorePackage.eINSTANCE.getDeployLink(), monitor);

		return convertToURICollection(results);
	}

	/**
	 * <p>
	 * Locate instances of {@link com.ibm.ccl.soa.deploy.core#DeployLink} who reference
	 * {@link DeployModelObject}s whose {@link DeployModelObject#getTopology()} match the passed in
	 * {@link Topology} via an {@link EReference} contained within the
	 * {@link DeployLink#getTargetURI()} {@link org.eclipse.emf.ecore#EFeature} or
	 * {@link DeployLink#getSourceURI()} {@link org.eclipse.emf.ecore#EFeature}. Only
	 * {@link #TOPOLOGY_MODEL_CONTENT_TYPE}s will be searched.<br>
	 * <b>NOTE:</b>Since the matching logic is based on the existence of a {@link String} value
	 * matching the standard import uri fragment formating ( i.e.
	 * %qualified.name.topology.name%:%/full/path/to/DMO% ) it is possible to return a match for a
	 * {@link DeployLink} that points to a different {@link Topology} than the passed in
	 * {@link DeployLink#getTopology()}, this is due to the fact that we can search the entire
	 * {@link IWorkspaceRoot} and it is possible to have the same {@link Topology#getQualifiedName()}
	 * and {@link DeployModelObject#getFullPath()} between two different {@link DeployModelObject}s
	 * that reside in different {@link Topology} models in different {@link IProject}s in the
	 * {@link IWorkspaceRoot}.
	 * 
	 * @param topology
	 *           an instance of {@link Topology} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within {@link DeployLink}'s
	 *           {@link DeployLink#getTargetURI()} or {@link DeployLink#getSourceURI()}.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           {@link IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           null the scope will be automatically set to {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link URI}s that point to the model element that matched the
	 *         search criteria.
	 * @throws CoreException
	 * 
	 * @see #findDeployLinksByImportedSource(DeployModelObject, Collection, boolean, boolean,
	 *      boolean, boolean, IProgressMonitor)
	 * @see #findDeployLinksByImportedTarget(DeployModelObject, Collection, boolean, boolean,
	 *      boolean, boolean, IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findDeployLinksByImportedTopology(Topology topology,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != topology;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_MODEL_CONTENT_TYPE);
		IndexContext context = createScopedContext(topology.eResource().getResourceSet(), limitScope(
				scope, topology), types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findDeployLinksByImportedTopology(context, topology, monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findDeployLinksByImportedTopology(IndexContext context,
			Topology topology, IProgressMonitor monitor) throws CoreException {
		Collection<URI> results = new ArrayList<URI>();

		// need to create a special context to limit the scope to only the project of the topology
		// b/c we are searching for the zephyr proxy string %namespace.name% and not a true EReference
		// this opens up the possiblity of returning a false match if more than one deploy link exists
		// that points to another topology in another project that is not related to the topology
		// we are actually searching for ( should be a rare case but we still need to protect against it )
		IndexContext limited = createScopedContext(topology.eResource().getResourceSet(), limitScope(
				convertToIResourceCollection2(context.getAllResourceURIs()), topology), null);
		limited.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		limited.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
		limited.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
		limited.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
				context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
		limited.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
		limited.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		// add all links with imported source
		results.addAll(convertToURICollection(IIndexSearchManager.INSTANCE.findEObjects(limited,
				topology.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
						+ WILDCARD, false, CorePackage.eINSTANCE.getDeployLink_SourceURI(),
				CorePackage.eINSTANCE.getDeployLink(), monitor)));

		// add all links with imported targets
		results.addAll(convertToURICollection(IIndexSearchManager.INSTANCE.findEObjects(limited,
				topology.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
						+ WILDCARD, false, CorePackage.eINSTANCE.getDeployLink_TargetURI(),
				CorePackage.eINSTANCE.getDeployLink(), monitor)));

		return results;
	}

	/**
	 * <p>
	 * Locates occurances of topology diagram {@link IFile}s that refer to the passed in
	 * {@link DeployModelObject} by use of {@link org.eclipse.emf.ecore#EReference} objects within
	 * the {@link Diagram} model. Only {@link #TOPOLOGY_DIAGRAM_CONTENT_TYPE}s will be searched.<br>
	 * <b>Note:</b> This method <b>will</b> return diagram {@link IFile}s that refer to the passed
	 * in {@link DeployModelObject} through the use of an {@link com.ibm.ccl.soa.deploy.core#Import}
	 * in the {@link Topology} model that the {@link Diagram} visualizes.
	 * </p>
	 * 
	 * @param dmo
	 *           an instance of {@link DeployModelObject} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within EMF based models.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           {@link IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           null the scope will be automatically set to {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link IFile}s that matched the search criteria
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findReferencingDiagramViews(DeployModelObject dmo,
			Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != dmo;

		List<IContentType> types = new ArrayList<IContentType>();
		types.add(TOPOLOGY_DIAGRAM_CONTENT_TYPE);
		IndexContext context = createScopedContext(dmo.eResource().getResourceSet(), scope, types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return findReferencingDiagramViews(context, dmo, monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findReferencingDiagramViews(IndexContext context,
			DeployModelObject eObject, IProgressMonitor monitor) throws CoreException {

		Collection<URI> results = convertToURICollection(IIndexSearchManager.INSTANCE
				.findReferencingEObjects(context, eObject, NotationPackage.Literals.VIEW__ELEMENT,
						NotationPackage.Literals.VIEW, monitor));

		// find all other topology models that import this eObject's topology
		Collection<IFile> imports = findImportingTopologyReferences(eObject.getTopology(), null,
				true, false, false, false, monitor);

		// search for diagrams which contain view's that reference the 'proxied'
		// uri of the passed in eObject within the importing topology model, this
		// is a very special case because of how we handle imported units in 
		// another topology, the diagram for those topology models point to a 
		// 'proxified' version of the dmo from the imported topology within the 
		// importing topology. e.g. if A.topology imports B.topology and A.topology 
		// has a diagram of A.topologyv then any view elements within A.topologyv 
		// that visualize imported elements from B.topology in A.topology will 
		// use a special href uri like this: href="A.topology#%name%.%space%.B:/%path%/%to%/%unit%"
		// which when searching for all diagram references for a unit in
		// B.topology you will need to looking for diagrams that reference the proxy
		// of the unit in any topology model that imports B.topology
		for (Iterator<IFile> iter = imports.iterator(); iter.hasNext();) {
			URI uri = URI.createPlatformResourceURI(iter.next().getFullPath().toString(), false);
			results
					.addAll(convertToURICollection(IIndexSearchManager.INSTANCE
							.findReferencingEObjects(context, uri.appendFragment(eObject.getTopology()
									.getQualifiedName()
									+ IConstants.TOPOLOGY_SEPARATOR + eObject.getFullPath()),
									NotationPackage.Literals.VIEW__ELEMENT, NotationPackage.Literals.VIEW,
									monitor)));
		}

		return results;
	}

	/**
	 * <p>
	 * Locates {@link EObject}'s that reference the {@code dmo} in EMF model {@link Resource}s. All
	 * referencers are returned including {@link EObject}s that reference the 'proxied' instance of
	 * the {@code dmo} in other EMF model {@link Resource}s.
	 * </p>
	 * 
	 * @param types
	 *           a {@link Collection} of {@link IContentType}s that will limit the scope of the
	 *           search to only those {@link IResource}s that match at least one of the provided
	 *           {@link IContentType}s. This scope constraint works in conjunction with the
	 *           {@code scope} parameter. {@code types} may be null to indicate that all
	 *           {@link IResource}s contained in the {@code scope} parameter will be searched.
	 * @param dmo
	 *           an instance of {@link DeployModelObject} to search for occurances of
	 *           {@link org.eclipse.emf.ecore#EReference}s within EMF based models.
	 * @param scope
	 *           a {@link Collection} of {@link IResource} objects that limit the extent of the
	 *           {@link IResource}s that will be searched. Instances of
	 *           {@link org.eclipse.core.resources#IContainer} will automatically have their
	 *           {@link IContainer#members()} added to the search {@code scope}. If {@code scope} is
	 *           null the scope will be automatically set to {@link IWorkspace#getRoot()}.
	 * @param searchUnloadedResources
	 *           a {@code boolean} value indicating if previously unloaded {@link Resource}s should
	 *           be searched.
	 * @param searchDeployedResources
	 *           a {@code boolean} value indicating if {@link Resource}s in deployed artifacts
	 *           (eclipse plugin bundles) should be searched.
	 * @param synchronizeIndex
	 *           a {@code boolean} value indicating if the index should be synchronized with the
	 *           current {@link IWorkspace#getRoot()}'s state prior to executing the search.
	 * @param strictEclassEquality
	 *           a {@code boolean} value indicating if only exact matches of the {@link EObject}'s
	 *           {@link EObject#eClass()} should be returned, ignoring matches to instances that
	 *           subclass the {@link EObject}'s {@link EObject#eClass()}.
	 * @param monitor
	 *           an instance of {@link IProgressMonitor} or {@code null}
	 * @return a {@link Collection} of {@link IFile}s that matched the search criteria
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public static Collection<URI> findReferencers(Collection<IContentType> types,
			final DeployModelObject dmo, Collection<IResource> scope, boolean searchUnloadedResources,
			boolean searchDeployedResources, boolean synchronizeIndex, boolean strictEclassEquality,
			IProgressMonitor monitor) throws CoreException {

		assert null != dmo;

		if (null == types) {
			types = new ArrayList<IContentType>(0);
		}

		if (DEBUG) {
			System.out
					.println("************************* Query.findReferences() - begin ****************************"); //$NON-NLS-1$

			System.out.println("Searching for references to: " + EcoreUtil.getURI(dmo)); //$NON-NLS-1$
			System.out.println("Searching for references to: " + getURI(dmo)); //$NON-NLS-1$
			System.out.println("Content Types: " + types); //$NON-NLS-1$
			System.out.println("Scope: " + scope); //$NON-NLS-1$
			System.out.println("Search Unloaded Resources: " + searchUnloadedResources); //$NON-NLS-1$
			System.out.println("Search Deployed Resources: " + searchDeployedResources); //$NON-NLS-1$
			System.out.println("Synchronize Index: " + synchronizeIndex); //$NON-NLS-1$
			System.out.println("Strict EClass Equality: " + strictEclassEquality); //$NON-NLS-1$
		}

		IndexContext context = createScopedContext(dmo.eResource().getResourceSet(), scope, types);
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(searchUnloadedResources));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(searchDeployedResources));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		if (DEBUG) {
			System.out.println("IndexContext.getAllResourceURIs(): " + context.getAllResourceURIs()); //$NON-NLS-1$
			System.out
					.println("IndexContext.getLoadedResourceURIs(): " + context.getLoadedResourceURIs()); //$NON-NLS-1$
			System.out.println("IndexContext.getOptions(): " + context.getOptions()); //$NON-NLS-1$
			System.out.println("IndexContext.getProxyData(): " + context.getProxyData()); //$NON-NLS-1$
			System.out.println("IndexContext.getResourceSet(): " + context.getResourceSet()); //$NON-NLS-1$
			System.out.println("IndexContext.getResourceURIs(): " + context.getResourceURIs()); //$NON-NLS-1$

			System.out
					.println("IndexPlugin.closedProjectToResourceCache: " + IndexPlugin.closedProjectToResourceCache); //$NON-NLS-1$
			System.out
					.println("IndexPlugin.resourceToModTimeCache: " + IndexPlugin.resourceToModTimeCache); //$NON-NLS-1$
			System.out.println("IndexPlugin.resSyncCache: " + IndexPlugin.resSyncCache); //$NON-NLS-1$
			System.out.println("IndexPlugin.subObjToUriCache: " + IndexPlugin.subObjToUriCache); //$NON-NLS-1$
			System.out.println("IndexPlugin.uriToSubObjCache: " + IndexPlugin.uriToSubObjCache); //$NON-NLS-1$
		}

		return findReferencers(context, dmo, monitor);
	}

	@SuppressWarnings("unchecked")
	private static Collection<URI> findReferencers(IndexContext context,
			final DeployModelObject dmo, IProgressMonitor monitor) throws CoreException {
		final Collection<URI> results = new ArrayList<URI>();

		results.addAll(convertToURICollection(IIndexSearchManager.INSTANCE.findReferencingEObjects(
				context, dmo, null, null, monitor)));

		// if dmo is a Zephyr proxy we need to search for references to the original dmo as well
		if (!dmo.getTopology().equals(dmo.getEditTopology())) {

			URI realDmoUri = getURI(dmo);
			Collection<EObject> objs = IIndexSearchManager.INSTANCE.findReferencingEObjects(context,
					realDmoUri, null, null, monitor);
			for (Iterator<EObject> iter = objs.iterator(); iter.hasNext();) {
				EObject eObject = iter.next();
				URI uri = EcoreUtil.getURI(eObject);
				if (null != uri && !results.contains(uri)) {
					results.add(uri);
				}
			}
		}

		String dmoPath = getURI(dmo).fragment();
		if (dmoPath != null) {

			// search for DeployLink objects whose sourceURI == %dmoPath%*
			// need to create a special context to limit the scope to only the project of the dmo
			// b/c we are searching for the zephyr proxy string %namespace.name% and not a true EReference
			// this opens up the possiblity of returning a false match if more than one deploy link exists
			// that points to another topology in another project that is not related to the topology
			// we are actually searching for ( should be a rare case but we still need to protect against it )
			IndexContext limitedSource = createScopedContext(dmo.eResource().getResourceSet(),
					limitScope(convertToIResourceCollection2(context.getAllResourceURIs()), dmo), null);
			limitedSource.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
			limitedSource.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
					context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
			limitedSource.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
					context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
			limitedSource.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
					context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
			limitedSource.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
					context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
			limitedSource.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
					Boolean.TRUE);
			Collection<EObject> links = IIndexSearchManager.INSTANCE.findEObjects(limitedSource,
					dmoPath + WILDCARD, false, CorePackage.Literals.DEPLOY_LINK__SOURCE_URI,
					CorePackage.Literals.DEPLOY_LINK, monitor);

			// Add uri of links we found to results
			for (Iterator<EObject> iter = links.iterator(); iter.hasNext();) {
				DeployLink link = (DeployLink) iter.next();
				URI linkUri = EcoreUtil.getURI(link);
				if (!results.contains(linkUri)) {
					results.add(linkUri);
				}
			}

			// search for DeployLink objects whose targetURI == %dmoPath%*
			// need to create a special context to limit the scope to only the project of the dmo
			// b/c we are searching for the zephyr proxy string %namespace.name% and not a true EReference
			// this opens up the possiblity of returning a false match if more than one deploy link exists
			// that points to another topology in another project that is not related to the topology
			// we are actually searching for ( should be a rare case but we still need to protect against it )
			IndexContext limitedTarget = createScopedContext(dmo.eResource().getResourceSet(),
					limitScope(convertToIResourceCollection2(context.getAllResourceURIs()), dmo), null);
			limitedTarget.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
			limitedTarget.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
					context.getOptions().get(IndexContext.SEARCH_UNLOADED_RESOURCES));
			limitedTarget.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
					context.getOptions().get(IndexContext.SEARCH_DEPLOYED_RESOURCES));
			limitedTarget.getOptions().put(IndexContext.SYNCHRONIZE_INDEX,
					context.getOptions().get(IndexContext.SYNCHRONIZE_INDEX));
			limitedTarget.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
					context.getOptions().get(IndexContext.STRICT_ECLASS_EQUALITY));
			limitedTarget.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
					Boolean.TRUE);
			links = IIndexSearchManager.INSTANCE.findEObjects(limitedTarget, dmoPath + WILDCARD,
					false, CorePackage.Literals.DEPLOY_LINK__TARGET_URI,
					CorePackage.Literals.DEPLOY_LINK, monitor);

			// Add uri of links we found to results
			for (Iterator<EObject> iter = links.iterator(); iter.hasNext();) {

				DeployLink link = (DeployLink) iter.next();
				URI linkUri = EcoreUtil.getURI(link);
				if (!results.contains(linkUri)) {
					results.add(linkUri);
				}
			}
		}

		// track the imported instance of the dmo in other topology models
		// we will need these to find any Views that reference the imported
		// instance in a diagram
		final Collection<URI> imports = new ArrayList<URI>();

		// find all links whose sourceURI property references the imported dmo and add to results
		for (Iterator<URI> iter = findDeployLinksByImportedSource(context, dmo, monitor).iterator(); iter
				.hasNext();) {
			URI uri = iter.next();
			if (!results.contains(uri)) {
				results.add(uri);
			}

			String source = (String) IIndexSearchManager.INSTANCE.findValue(context, uri,
					CorePackage.Literals.DEPLOY_LINK__SOURCE_URI, monitor);

			// add the imported instance of the dmo to the imports
			// collection if it does not already contain it
			if (null != source) {
				source = getUnitPath(source);
				URI sourceUri = uri.trimFragment().appendFragment(source);
				if (!imports.contains(sourceUri)) {
					imports.add(sourceUri);
				}
			}
		}

		// find all links whose targetURI property references the imported dmo and add to results
		for (Iterator<URI> iter = findDeployLinksByImportedTarget(context, dmo, monitor).iterator(); iter
				.hasNext();) {
			URI uri = iter.next();
			if (!results.contains(uri)) {
				results.add(uri);
			}

			String target = (String) IIndexSearchManager.INSTANCE.findValue(context, uri,
					CorePackage.Literals.DEPLOY_LINK__TARGET_URI, monitor);

			// add the imported instance of the dmo to the imports
			// collection if it does not already contain it
			if (null != target) {
				target = getUnitPath(target);
				URI targetUri = uri.trimFragment().appendFragment(target);
				if (!imports.contains(targetUri)) {
					imports.add(targetUri);
				}
			}
		}

		// find other topology models that import the dmo's topology and create a uri that
		// points to an imported instance of the dmo in the other topology, this will cover
		// any import instances of the dmo we might have missed by looking at the deploy links
		// above, such as an imported instance of the dmo that does not link to anything
		Topology topology = dmo.getTopology();
		for (Iterator<IFile> iter = findImportingTopologyReferences(context,
				WorkbenchResourceHelper.getProject(topology.eResource()), topology.getNamespace(),
				topology.getName(), topology.eResource().getResourceSet(), monitor).iterator(); iter
				.hasNext();) {
			IFile aTopologyFile = iter.next();
			URI uri = URI.createPlatformResourceURI(aTopologyFile.getFullPath().toOSString());
			uri = uri.appendFragment(dmo.getTopology().getQualifiedName()
					+ IConstants.TOPOLOGY_SEPARATOR + dmo.getFullPath());
			if (!imports.contains(uri)) {
				imports.add(uri);
			}
		}

		// find all views who reference the imported instances of the dmo in topology models other than the dmo's topology
		for (Iterator<URI> iter = imports.iterator(); iter.hasNext();) {

			for (Iterator<URI> iter2 = convertToURICollection(
					IIndexSearchManager.INSTANCE.findReferencingEObjects(context, iter.next(), null,
							null, monitor)).iterator(); iter2.hasNext();) {
				URI uri = iter2.next();
				if (!results.contains(uri)) {
					results.add(uri);
				}
			}
		}

		// find all StructuredReferences in other models that resolve to dmo
		EObject fugative = lightweightProxyResolve(dmo, context);
		if (fugative != null) {

			IFile resource = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(getURI(fugative).toPlatformString(true)));
			TransactionalEditingDomain domain = getEditingDomain(resource);
			StructuredReference reference = StructuredReferenceService.getStructuredReference(domain,
					fugative);

			if (null != reference) {

				Map referencingMap = IIndexSearchManager.INSTANCE.findReferencingEObjects(context,
						Arrays.asList(new URI[] { MMICoreUtil.getURI(reference.toString()) }), null,
						null, monitor);

				if (referencingMap != null && referencingMap.size() > 0) {
					for (Iterator i = referencingMap.values().iterator(); i.hasNext();) {
						Collection referencing = (Collection) i.next();
						Iterator referencing_it = referencing.iterator();
						while (referencing_it.hasNext()) {
							EObject referencer = (EObject) referencing_it.next();
							URI uri = EcoreUtil.getURI(referencer);
							if (!results.contains(uri)) {
								results.add(uri);
							}
						}
					}
				}
			}
		}

		return results;
	}

	@SuppressWarnings("unchecked")
	private static IndexContext createScopedContext(ResourceSet set, Collection<IResource> scope,
			Collection<IContentType> types) throws CoreException {
		IndexContext context = null;
		if (null != scope && scope.size() > 0) {
			context = new IndexContext(set, scope, types);
		} else {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			if (workspace != null) {
				IWorkspaceRoot root = workspace.getRoot();
				if (root != null) {
					context = new IndexContext(set, Collections.singleton(root), types);
				} else {
					throw new CoreException(
							new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
									DeployCoreMessages.Query_Unable_to_construct_IndexContext_in_,
									new NullPointerException(
											DeployCoreMessages.Query_The_workspace_root_was_null_)
											.fillInStackTrace()));
				}
			} else {
				throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
						DeployCoreMessages.Query_Unable_to_construct_IndexContext_in__2,
						new NullPointerException(DeployCoreMessages.Query_The_workspace_was_null_)
								.fillInStackTrace()));
			}
		}

		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES, Boolean.TRUE);
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.FALSE);
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY, Boolean.FALSE);
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return context;
	}

	private static Collection<IFile> convertToIFileCollection(Collection<Resource> resources)
			throws CoreException {
		try {
			Collection<IFile> files = new ArrayList<IFile>(resources.size());
			for (Iterator<Resource> iter = resources.iterator(); iter.hasNext();) {
				Resource resource = iter.next();
				IFile file = WorkbenchResourceHelper.getFile(resource);
				if (!files.contains(file)) {
					files.add(file);
				}
			}

			return files;
		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		}
	}

	private static Collection<URI> convertToURICollection(Collection<EObject> eObjects)
			throws CoreException {
		try {
			Collection<URI> uris = new ArrayList<URI>(eObjects.size());
			for (Iterator<EObject> iter = eObjects.iterator(); iter.hasNext();) {
				EObject eObject = iter.next();
				URI uri = EcoreUtil.getURI(eObject);
				if (!uris.contains(uri)) {
					uris.add(uri);
				}
			}

			return uris;
		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		}
	}

	private static Collection<IResource> convertToIResourceCollection(Collection<EObject> eObjects)
			throws CoreException {
		try {
			Collection<IResource> resources = new ArrayList<IResource>(eObjects.size());
			for (Iterator<EObject> iter = eObjects.iterator(); iter.hasNext();) {
				EObject eObject = iter.next();
				URI uri = EcoreUtil.getURI(eObject);
				IPath path = new Path(uri.toPlatformString(true));
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (!resources.contains(file)) {
					resources.add(file);
				}
			}

			return resources;
		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		}
	}

	private static Collection<IResource> convertToIResourceCollection2(Collection<URI> uris)
			throws CoreException {
		try {
			Collection<IResource> resources = new ArrayList<IResource>(uris.size());
			for (Iterator<URI> iter = uris.iterator(); iter.hasNext();) {
				URI uri = iter.next();
				IPath path = new Path(uri.toPlatformString(true));
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (!resources.contains(file)) {
					resources.add(file);
				}
			}

			return resources;
		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		}
	}

	private static URI getURI(EObject eObject) {

		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(eObject.eClass())) {

			DeployModelObject dmo = (DeployModelObject) eObject;
			if (dmo.eIsProxy()) {
				DeployCorePlugin.log(IStatus.WARNING, 0,
						"Query attempted to obtain the URI from an eProxy", null); //$NON-NLS-1$
				return ((InternalEObject) dmo).eProxyURI();
			}
			// special check for deploy proxies ( these do not respond "true" to eIsProxy())
			if (!dmo.getEditTopology().equals(dmo.getTopology())) {
				String qualifiedTopologyName = dmo.getTopology().getQualifiedName();
				if (dmo.getFullPath().startsWith(qualifiedTopologyName)
						&& dmo.getFullPath().length() > qualifiedTopologyName.length() + 1) {
					String path = dmo.getFullPath().substring(qualifiedTopologyName.length() + 1,
							dmo.getFullPath().length());

					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
							new Path(EcoreUtil.getURI(dmo).toPlatformString(true)));
					INamespaceFragment fragment = NamespaceCore.findNamespace(file.getProject(), dmo
							.getTopology().getNamespace());
					IFile topology = fragment.getTopology(dmo.getTopology().getName());
					URI uri = URI.createPlatformResourceURI(topology.getFullPath().toOSString());
					return uri.appendFragment(path);
				}
			}
		}

		return EcoreUtil.getURI(eObject);
	}

	private static String getUnitPath(String path) {
		if (path.indexOf(IConstants.PATH_SEPARATOR, path.indexOf(IConstants.PATH_SEPARATOR)) > -1) {
			String[] segments = path.split(new String() + IConstants.PATH_SEPARATOR);
			path = segments[0] + IConstants.PATH_SEPARATOR + segments[1];
		}

		return path;
	}

	private static final TransactionalEditingDomain getEditingDomain(IResource resource) {
		IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE.getContext(resource
				.getProject());
		TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(context.getResourceSet());

		if (txdomain == null) {
			txdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(context
					.getResourceSet());
		}

		return txdomain;
	}

	private static EObject lightweightProxyResolve(EObject eObject, IndexContext context)
			throws CoreException {
		if (!eObject.eIsProxy()) {
			return eObject;
		}

		URI uri = EcoreUtil.getURI(eObject);

		if (DEBUG) {
			System.out.println("Looking up eProxyURI (" + uri + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		EObject proxy = getEObject(uri, context);
		if (proxy == null) {

			// we don't want to bother loading the resource if it is not in the scope of our search
			if (context.getResourceURIs().contains(uri.trimFragment())) {

				// this means that the proxy (eObject) points to another proxy (ref) and 
				// the ProxyData class does not have any information about the proxy (ref)
				// so we need to load the resource that ref belongs to independently of
				// it's resource set so as to not alert any listeners of the resource set
				// that the resource has been loaded
				Resource resource = context.getResource(uri, true);
				try {
					resource.load(Collections.EMPTY_MAP);
					proxy = resource.getEObject(uri.fragment());
				} catch (IOException ex) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							IStatus.ERROR, ex.toString(), ex));
				}
			}
		}

		return proxy;
	}

	@SuppressWarnings("unchecked")
	private static EObject getEObject(URI uri, IndexContext context) throws CoreException {

		Collection<EObject> eObjects = IIndexSearchManager.INSTANCE.findEObjects(context, uri
				.fragment(), null, null);
		EObject result = null;
		if (null != eObjects && eObjects.size() > 0) {
			result = eObjects.iterator().next();
		}

		return result;
	}

	private static Collection<IResource> limitScope(Collection<IResource> aScope, EObject eObject) {
		IProject project = WorkbenchResourceHelper.getProject(eObject.eResource());
		return limitScope(aScope, project);
	}

	private static Collection<IResource> limitScope(Collection<IResource> aScope, IProject project) {

		if (null == aScope) {
			return Arrays.asList(new IResource[] { project });
		}

		ArrayList<IResource> scope = new ArrayList<IResource>();

		for (Iterator<IResource> iter = aScope.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			switch (resource.getType())
			{
			case IResource.ROOT:
				if (!scope.contains(project)) {
					scope.add(project);
				}
				break;

			case IResource.PROJECT:
				if (project.equals(resource.getProject()) && !scope.contains(resource.getProject())) {
					scope.add(resource.getProject());
				}
				break;

			case IResource.FOLDER:
			case IResource.FILE:
				if (project.equals(resource.getProject()) && !scope.contains(resource)) {
					scope.add(resource);
				}
				break;
			}
		}

		if (scope.isEmpty()) {
			scope.add(project);
		}

		return scope;
	}
}
