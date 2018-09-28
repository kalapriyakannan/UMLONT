package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchQuery;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;

public abstract class AbstractReferencesHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {

			final Object selection = getSelection(event);

			// if selection is null then we cannot proceed
			if (null == selection) {
				return null;
			}

			final Scope searchScope = getSearchScope(event);

			// if searchScope is null then we cannot proceed
			if (null == searchScope) {
				return null;
			}

			doSearch(selection, searchScope, new NullProgressMonitor());

		} catch (InterruptedException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			ErrorDialog.openError(window.getShell(),
					Messages.AbstractReferencesHandler_Error_Occurre_, ex.getMessage(), new Status(
							IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
		} catch (CoreException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			ErrorDialog.openError(window.getShell(),
					Messages.AbstractReferencesHandler_Error_Occurre_, ex.getMessage(), new Status(
							IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
		}

		return null;
	}

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
					Messages.AbstractReferencesHandler_Selection_was_not_an_instance_of_EO_, null));
		}

		// create a model search query
		ISearchQuery query = new DeploySearchQuery((EObject) selection, searchScope);

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

	protected Object getSelection(ExecutionEvent event) throws CoreException, ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		Object object = selection;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 0 && elements.length > 1) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						Messages.AbstractReferencesHandler_Cannot_search_for_more_than_a_singl_, null));
			}
			object = elements[0];
		}

		Object adapted = Platform.getAdapterManager().getAdapter(object, Unit.class);
		if (null == adapted) {
			// we found something other than a unit
			return null;
		}

		if (!(adapted instanceof EObject)) {
			// we found something other than a unit
			return null;
		}

		return adapted;
	}

	/**
	 * Returns the search scope
	 */
	protected abstract Scope getSearchScope(ExecutionEvent event) throws CoreException,
			ExecutionException;

}
