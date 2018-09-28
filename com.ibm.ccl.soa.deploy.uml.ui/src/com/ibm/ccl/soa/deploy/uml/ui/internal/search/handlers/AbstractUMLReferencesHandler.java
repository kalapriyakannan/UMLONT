package com.ibm.ccl.soa.deploy.uml.ui.internal.search.handlers;

import org.eclipse.core.internal.content.ContentTypeManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers.AbstractReferencesHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.query.UMLSearchQuery;
import com.ibm.xtools.uml.msl.contenttype.MSLContentTypes;

@SuppressWarnings("restriction")
public abstract class AbstractUMLReferencesHandler extends AbstractReferencesHandler {

	public static final IContentType UML_MODEL_CONTENT_TYPE = ContentTypeManager.getInstance()
			.getContentType(MSLContentTypes.MODEL_CONTENTTYPE);

	public static final IContentType UML_PROFILE_CONTENT_TYPE = ContentTypeManager.getInstance()
			.getContentType(MSLContentTypes.PROFILE_CONTENTTYPE);

	public static final IContentType UML_MODEL_FRAGMENT_CONTENT_TYPE = ContentTypeManager
			.getInstance().getContentType(MSLContentTypes.MODEL_FRAGMENT_CONTENTTYPE);

	@Override
	protected void doSearch(Object selection, Scope searchScope, IProgressMonitor monitor)
			throws InterruptedException, CoreException {

		if (monitor != null && monitor.isCanceled()) {
			throw new InterruptedException();
		}

		if (searchScope == null) {
			return;
		}

		assert selection != null;

		// no point in continuing is there?
		if (selection == null) {
			return;
		}

		if (!(selection instanceof EObject)) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
					Messages.UMLReferencesInWorkspaceHandler_Selection_was_not_an_instance_of_EO_, null));
		}

		// create a model search query
		ISearchQuery query = new UMLSearchQuery((EObject) selection, searchScope);

		if (monitor != null && monitor.isCanceled()) {
			throw new InterruptedException();
		}

		// execute the search
		NewSearchUI.activateSearchResultView();

		if (monitor != null && monitor.isCanceled()) {
			throw new InterruptedException();
		}

		NewSearchUI.runQueryInBackground(query);
	}

}
