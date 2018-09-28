package com.ibm.ccl.soa.deploy.core.ui.internal.search.query;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match.EObjectLookupCallback;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class DeploySearchQuery implements ISearchQuery {

	// the result produces by the search query
	private DeploySearchResult searchResult = null;;

	// the referenced eObject
	private EObject referenced = null;

	// search scope
	private Scope searchScope = null;

	// the name of the reference eObject
	private String nameOfReferencedEObject = null;

	/**
	 * 
	 * @param referenced
	 * @param searchScope
	 */
	public DeploySearchQuery(EObject referenced, Scope searchScope) {
		assert referenced != null;
		assert searchScope != null;

		this.referenced = referenced;
		this.searchScope = searchScope;
		searchResult = new DeploySearchResult(this) {
			@Override
			public String getLabel() {
				return NLS.bind(Messages.DeploySearchQuery_Found_0_matches_to_1_, new Object[] {
						new Integer(getElements().size()), nameOfReferencedEObject });
			}
		};

		nameOfReferencedEObject = EMFCoreUtil.getQualifiedName(referenced, false);
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		try {

			// create a status object and clear the search result
			IStatus status = new Status(IStatus.OK, DeployCoreUIPlugin.PLUGIN_ID, IStatus.OK,
					Messages.DeploySearchQuery_o_, null);

			if (searchResult.getElements().size() > 0) {
				searchResult.clear();
			}

			// initialize the monitor
			if (monitor != null) {
				monitor.beginTask(Messages.DeploySearchQuery_Searching_, 100);
			}

			// get the referencers
			Collection<URI> referencing = Query.findReferencers(getSearchScope().getContentTypes(),
					(DeployModelObject) getReferenced(), getSearchScope().getResources(),
					getSearchScope().includeUnloadedResources(), getSearchScope()
							.includeDeployedResources(), true, false,
					monitor != null ? new SubProgressMonitor(monitor, 25) : null);

			if (monitor != null) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				monitor.worked(25);
			}

			// add matches to result
			for (Iterator<URI> iter = referencing.iterator(); iter.hasNext();) {
				URI uri = iter.next();

				// don't want references to myself and don't want containers
				if (null != uri
						&& !uri.equals(EcoreUtil.getURI(referenced))
						&& !(new String() + IConstants.PATH_SEPARATOR).equals(uri.fragment())
						// special expression to filter out containment references for imports of dmo's
						&& !uri.fragment().endsWith(
								(new String() + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR))) {
					addReferenceMatch(uri, new EObjectLookupCallback(getReferenced().eResource()
							.getResourceSet(), getSearchScope(), true, false), monitor);
				}
			}

			// complete the search result
			searchResult.complete();

			if (monitor != null) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				monitor.worked(25);
			}

			return status;
		} catch (OperationCanceledException ex) {
			// rethrow
			throw ex;
		} catch (CoreException ex) {
			return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, IStatus.ERROR, ex
					.toString(), ex);
		} catch (RuntimeException ex) {
			return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, IStatus.ERROR, ex
					.toString(), ex);
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
	}

	public String getLabel() {
		return NLS.bind(Messages.DeploySearchQuery_search_query_for_references_to_0_,
				nameOfReferencedEObject);
	}

	public boolean canRerun() {
		return true;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public ISearchResult getSearchResult() {
		return searchResult;
	}

	public EObject getReferenced() {
		return referenced;
	}

	public Scope getSearchScope() {
		return searchScope;
	}

	/**
	 * Add a reference match
	 * 
	 * @param referencing
	 *           the referencing element
	 * @param proxyData
	 *           the proxy data
	 * @param monitor
	 *           the progress monitor\
	 * @throws OperationCanceledException
	 */
	public void addReferenceMatch(URI referencer, EObjectLookupCallback referencerCallback,
			IProgressMonitor monitor) throws OperationCanceledException {

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		// create the match
		Match match = new Match(EcoreUtil.getURI(getReferenced()), new EObjectLookupCallback(
				getReferenced().eResource().getResourceSet()), referencer, referencerCallback);

		// add the match
		((DeploySearchResult) getSearchResult()).addMatch(match);
	}
}
