package com.ibm.ccl.soa.deploy.core.ui.internal.search.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IContributorResourceAdapter;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.xtools.emf.index.search.IIndexSearchManager;
import com.ibm.xtools.emf.index.search.IndexContext;

public class Match implements Serializable, IAdaptable, IContributorResourceAdapter {

	private static final long serialVersionUID = -5091768793154733485L;

	private static final boolean DEBUG = DeployCoreUIPlugin.getDefault().isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DeployCoreUIPlugin.PLUGIN_ID
							+ "/debug/" + Match.class.getCanonicalName())); //$NON-NLS-1$

	public static class EObjectLookupCallback {

		private final ResourceSet resourceSet;
		private IndexContext context = null;
		private Scope scope = null;
		private boolean synchronizeIndex = false;
		private boolean strictEclassEquality = false;

		public EObjectLookupCallback(ResourceSet resourceSet) {
			this.resourceSet = resourceSet;
			context = null;
		}

		public EObjectLookupCallback(ResourceSet resourceSet, Scope scope, boolean synchronizeIndex,
				boolean strictEclassEquality) {
			this.resourceSet = resourceSet;
			this.scope = scope;
			this.synchronizeIndex = synchronizeIndex;
			this.strictEclassEquality = strictEclassEquality;
		}

		public ResourceSet getResourceSet() {
			return resourceSet;
		}

		public Scope getScope() {
			return scope;
		}

		public boolean getShouldSynchronizeIndex() {
			return synchronizeIndex;
		}

		public boolean getShouldUseStrictEclassEquality() {
			return strictEclassEquality;
		}

		public IndexContext getIndexContext(URI uri) throws CoreException {

			if (null != getScope()) {
				return getIndexContext(getResourceSet(), getShouldSynchronizeIndex(),
						getShouldUseStrictEclassEquality(), getScope());
			}

			IPath path = new Path(uri.toPlatformString(true));
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			return createScopedContext(getResourceSet(), Arrays.asList(new IResource[] { file }),
					Collections.EMPTY_LIST);
		}

		public IndexContext getIndexContext() throws CoreException {
			if (null != context) {
				return context;
			}

			if (null != getScope()) {
				return getIndexContext(getResourceSet(), getShouldSynchronizeIndex(),
						getShouldUseStrictEclassEquality(), getScope());
			}

			return null;
		}

		@SuppressWarnings("unchecked")
		public EObject getEObject(URI uri, boolean resolveProxies, boolean synchronizeIndex,
				boolean strictEclassEquality) throws CoreException {

			IndexContext context = getIndexContext(uri);
			context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.valueOf(resolveProxies));
			context.getOptions()
					.put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
			context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
					Boolean.valueOf(strictEclassEquality));
			context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
					Boolean.TRUE);
			Collection<EObject> eObjects = IIndexSearchManager.INSTANCE.findEObjects(context, uri
					.fragment(), null, null);
			EObject result = null;
			if (null != eObjects && eObjects.size() > 0) {
				result = eObjects.iterator().next();
			}

			return result;
		}

		@SuppressWarnings("unchecked")
		protected IndexContext getIndexContext(ResourceSet set, boolean synchronizeIndex,
				boolean strictEclassEquality, Scope scope) throws CoreException {
			IndexContext context = createScopedContext(set, scope.getResources(), scope
					.getContentTypes());
			context.getOptions().put(IndexContext.RESOLVE_PROXIES, Boolean.FALSE);
			context.getOptions().put(IndexContext.SEARCH_UNLOADED_RESOURCES,
					Boolean.valueOf(scope.includeUnloadedResources()));
			context.getOptions().put(IndexContext.SEARCH_DEPLOYED_RESOURCES,
					Boolean.valueOf(scope.includeDeployedResources()));
			context.getOptions()
					.put(IndexContext.SYNCHRONIZE_INDEX, Boolean.valueOf(synchronizeIndex));
			context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY,
					Boolean.valueOf(strictEclassEquality));
			context.getOptions().put(IndexContext.PROVIDE_INDEXED_DATA_FOR_PROXIES_AND_PARENTS,
					Boolean.TRUE);

			return context;
		}

		@SuppressWarnings("unchecked")
		protected IndexContext createScopedContext(ResourceSet set, Collection<IResource> scope,
				Collection<IContentType> types) throws CoreException {
			if (null != scope && scope.size() > 0) {
				context = new IndexContext(set, scope, types);
			} else {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				if (workspace != null) {
					IWorkspaceRoot root = workspace.getRoot();
					if (root != null) {
						context = new IndexContext(set, Collections.singleton(root), types);
					} else {
						throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
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

	}

	private final URI referenced;
	private final EObjectLookupCallback referencedCallback;
	private final URI referencing;
	private final EObjectLookupCallback referencerCallback;

	public Match(URI referenced, EObjectLookupCallback referencedCallback, URI referencing,
			EObjectLookupCallback referencerCallback) {
		this.referenced = referenced;
		this.referencedCallback = referencedCallback;
		this.referencing = referencing;
		this.referencerCallback = referencerCallback;
	}

	public URI getReferenced() {
		return referenced;
	}

	public URI getReferencing() {
		return referencing;
	}

	public EObject getReferencedEObject(boolean resolveProxies, boolean synchronizeIndex,
			boolean strictEclassEquality) throws CoreException {
		return referencedCallback.getEObject(referenced, resolveProxies, synchronizeIndex,
				strictEclassEquality);
	}

	public EObjectLookupCallback getReferencedCallback() {
		return referencedCallback;
	}

	public EObject getReferencerEObject(boolean resolveProxies, boolean synchronizeIndex,
			boolean strictEclassEquality) throws CoreException {
		return referencerCallback.getEObject(referencing, resolveProxies, synchronizeIndex,
				strictEclassEquality);
	}

	public EObjectLookupCallback getReferencerCallback() {
		return referencerCallback;
	}

	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	public IResource getAdaptedResource(IAdaptable adaptable) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(getReferencing().toPlatformString(true)));
	}

}
