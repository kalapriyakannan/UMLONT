package com.ibm.ccl.soa.deploy.uml.ui.internal.search.query;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchQuery;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchResult;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match.EObjectLookupCallback;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.ui.Activator;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;
import com.ibm.xtools.emf.index.search.IIndexSearchManager;
import com.ibm.xtools.emf.index.search.IndexContext;

public class UMLSearchQuery extends DeploySearchQuery {

	public UMLSearchQuery(EObject referenced, Scope searchScope) {
		super(referenced, searchScope);
	}

	@SuppressWarnings("unchecked")
	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {

		super.run(monitor);

		try {

			// create a status object and clear the search result
			IStatus status = new Status(IStatus.OK, Activator.PLUGIN_ID, IStatus.OK,
					Messages.UMLSearchQuery_o_, null);

			// initialize the monitor
			if (monitor != null) {
				monitor.beginTask(Messages.UMLSearchQuery_Searching_, 50);
			}

			// get the referencers
			NamedElement element = getUMLSelection(getReferenced());
			Collection<EObject> referencingElements = IIndexSearchManager.INSTANCE
					.findReferencingEObjects(getIndexContext(ResourceUtil.getResourceSet(), true, false,
							getSearchScope()), element, null, null,
							monitor != null ? new SubProgressMonitor(monitor, 25) : null);

			if (monitor != null) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				monitor.worked(25);
			}

			for (Iterator<EObject> e = referencingElements.iterator(); e.hasNext();) {
				EObject next = e.next();

				// get container
				EObject container = getReferenced().eContainer();

				// don't want references to myself and don't want containers
				if (next != null && next != container) {
					addReferenceMatch(EcoreUtil.getURI(next), new EObjectLookupCallback(next.eResource()
							.getResourceSet(), getSearchScope(), true, false), monitor);
				}
			}

			// complete the search result
			((DeploySearchResult) getSearchResult()).complete();

			if (monitor != null) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				monitor.worked(25);
			}

			return status;
		} catch (OperationCanceledException ex) {
			// rethrow
			ex.fillInStackTrace();
			throw ex;
		} catch (CoreException ex) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, ex.toString(), ex);
		} catch (RuntimeException ex) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, ex.toString(), ex);
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected NamedElement getUMLSelection(Object selection) {
		if (selection instanceof EObject) {
			if (CorePackage.Literals.UNIT.isSuperTypeOf(((EObject) selection).eClass())) {
				Unit unit = (Unit) selection;

				try {

					UMLElementArtifact artifact = ZephyrUmlUtil.getUMLElementArtifact(unit);
					String qualifiedName = artifact.getQualifiedName();
					String resourceUri = artifact.getResourceURI();

					IProject proj = ProjectUtilities.getProject(unit);
					String resolvedURI = ZephyrUmlUtil.getResolvedResourceURI(resourceUri, proj
							.getName());

					URI resUri = URI.createURI(resolvedURI);
					IndexContext context = getIndexContext(ResourceUtil.getResourceSet(), false, false,
							Scope.getWorkspaceScope(true, false));
					Resource resource = context.getResource(resUri, false);
					if (null != resource) {
						Collection elements = UMLUtil.findNamedElements(resource, qualifiedName);
						if (elements.size() > 0) {
							// Return the 1st one
							return (NamedElement) elements.iterator().next();
						}
					}

				} catch (CoreException ex) {
					Activator.logError(0, ex.getMessage(), ex);
				}

				return ZephyrUmlUtil.resolveNamedElement(unit);
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	protected static IndexContext getIndexContext(EObject eObject, boolean synchronizeIndex,
			boolean strictEclassEquality, Scope scope) throws CoreException {
		IndexContext context = createScopedContext(eObject.eResource().getResourceSet(), scope
				.getResources(), scope.getContentTypes());
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(scope.includeUnloadedResources()));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(scope.includeDeployedResources()));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return context;
	}

	@SuppressWarnings("unchecked")
	protected static IndexContext getIndexContext(ResourceSet resourceSet, boolean synchronizeIndex,
			boolean strictEclassEquality, Scope scope) throws CoreException {
		IndexContext context = createScopedContext(resourceSet, scope.getResources(), scope
				.getContentTypes());
		context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
		context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
				Boolean.valueOf(scope.includeUnloadedResources()));
		context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
				Boolean.valueOf(scope.includeDeployedResources()));
		context.getOptions().put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
				Boolean.valueOf(strictEclassEquality));
		context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
				Boolean.TRUE);

		return context;
	}

	protected static IndexContext createScopedContext(ResourceSet set, Collection<IResource> scope,
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
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							Messages.UMLScope_Unable_to_construct_IndexContext_, new NullPointerException(
									Messages.UMLScope_The_workspace_root_was_null_).fillInStackTrace()));
				}
			} else {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						Messages.UMLScope_Unable_to_construct_IndexContext_, new NullPointerException(
								Messages.UMLScope_The_workspace_was_null_).fillInStackTrace()));
			}
		}

		return context;
	}

}
