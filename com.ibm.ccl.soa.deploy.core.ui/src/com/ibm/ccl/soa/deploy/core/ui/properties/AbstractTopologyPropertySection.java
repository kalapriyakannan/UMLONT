package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UndoRedoActionGroup;

/**
 * A common property sheet section for the Topology editor.
 * 
 * 
 */
public abstract class AbstractTopologyPropertySection extends AbstractPropertySection {

	// group UI refreshes in 50 ms blocks
	protected static final long DELAY = 50;

	protected UndoRedoActionGroup undoGroup;
	protected IActionBars actionBars;
	protected IPageSite site;

	/**
	 * event listener; catches multiplexed events and routes them to us
	 */
	protected final ResourceSetListener eventListener = createEventListener();

	/**
	 * handle updates for the UI in a Job to prevent scheduling lots of asyncExec()'s.
	 */
	protected final Job refreshJob = createUIRefreshJob();

	/**
	 * @see #getPage()
	 */
	private TabbedPropertySheetPage page;

	/**
	 * @see #getEditingDomain()
	 */
	private TransactionalEditingDomain editingDomain;

	private final Object lock = new Object();

	private boolean disposed;

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		synchronized (lock) {
			super.createControls(parent, tabbedPropertySheetPage);

			page = tabbedPropertySheetPage;
			site = tabbedPropertySheetPage.getSite();
			actionBars = site.getActionBars();

			doCreateControls(parent, tabbedPropertySheetPage);
		}
	}

	@Override
	public final void aboutToBeShown() {
		super.aboutToBeShown();

		// Setup to capture notifications after model-changing events (e.g. Edit->Undo)
		if (getEditingDomain() != null && eventListener != null) {
			getEditingDomain().addResourceSetListener(eventListener);
		}

		refreshActions();

		doAboutToBeShown();
	}

	@Override
	public final void aboutToBeHidden() {
		super.aboutToBeHidden();

		if (getEditingDomain() != null && eventListener != null) {
			getEditingDomain().removeResourceSetListener(eventListener);
		}

		doAboutToBeHidden();

	}

	@Override
	public final void dispose() {
		synchronized (lock) {
			disposed = true;
			super.dispose();
			if (undoGroup != null) {
				undoGroup.dispose();
			}
			doDispose();
		}
	}

	public final void setInput(IWorkbenchPart part, ISelection selection) {
		if (!isDisposed()) {
			super.setInput(part, selection);

			if (selection instanceof IStructuredSelection) {
				EObject eobj = null;
				DeployModelObject dmo = null;
				IStructuredSelection iss = (IStructuredSelection) selection;
				Object sel = iss.getFirstElement();
				if (sel instanceof EditPart) {
					EditPart uep = (EditPart) sel;

					Object obj = uep.getModel();
					if (obj instanceof View) {
						View view = (View) obj;

						eobj = ViewUtil.resolveSemanticElement(view);
						if (eobj instanceof DeployModelObject) {
							dmo = (DeployModelObject) eobj;
						}
					}
				} else if (sel instanceof DeployModelObject) {
					dmo = (DeployModelObject) sel;

				} else if (sel instanceof IFile) {

				}

				if (dmo != null) {

					editingDomain = TransactionUtil.getEditingDomain(dmo);
					setInput(dmo);
				} else {
					setInput(null);
				}
			}

			updateUndoGroup();
		}
	}

	protected final boolean isDisposed() {
		return disposed;
	}

	/**
	 * The input extracted from the selection.
	 * 
	 * @param input
	 *           The input extracted from the selection.
	 */
	protected abstract void setInput(DeployModelObject input);

	/**
	 * Refresh the actions by clearing the relevant managers and re-add the actions for the View Menu
	 * and Toolbar.
	 */
	public final void refreshActions() {
		clearManagers();

		updateUndoGroup();

		fillActionBars(actionBars);
		if (actionBars.getMenuManager() != null) {
			addMenuActions(actionBars.getMenuManager());
		}
		if (actionBars.getToolBarManager() != null) {
			addToolBarActions(actionBars.getToolBarManager());
		}

		actionBars.getToolBarManager().update(true);
		actionBars.updateActionBars();
	}

	private void updateUndoGroup() {
		IUndoContext undoContext = getUndoContext();
		if (undoGroup == null) {
			IWorkbenchPartSite workbenchSite = getPart().getSite();

			if (undoContext != null) {
				undoGroup = new UndoRedoActionGroup(workbenchSite, undoContext);
			}
		}
		if (undoGroup != null) {
			if (undoContext != null) {
				undoGroup.setUndoContext(undoContext);
				undoGroup.fillActionBars(actionBars);
			} else {
				undoGroup.dispose();
				undoGroup = null;
			}
		}
	}

	/**
	 * Fill the action bars with retargetable actions.
	 * 
	 * @param bars
	 *           The action bars also accessible through the field passed for convenience.
	 */
	protected void fillActionBars(IActionBars bars) {

	}

	/**
	 * A convenience method to return the {@link IUndoContext} from the {@link EditingDomain}
	 * returned from {{@link #getEditingDomain()}.
	 * 
	 * @return the {@link IUndoContext} from the {@link EditingDomain} returned from {
	 *         {@link #getEditingDomain()}.
	 */
	public IUndoContext getUndoContext() {
		return LightweightOperationFactory.createContext(getEditingDomain());
	}

	/**
	 * Return the Notification Filter to use when processing events from the Resource Set.
	 * 
	 * @return The Notification Filter to use when processing events from the Resource Set.
	 */
	protected NotificationFilter getFilter() {
		return NotificationFilter.createEventTypeFilter(Notification.SET);
	}

	/**
	 * Clear the Menu, ToolBar, and StatusLine managers.
	 */
	protected void clearManagers() {
		actionBars.getMenuManager().removeAll();
		actionBars.getToolBarManager().removeAll();
		actionBars.getStatusLineManager().removeAll();
	}

	/**
	 * Add any necessary menu items for the view menu in the top right corner
	 * 
	 * @param menu
	 *           The menu manager from the action bars for the workbench part.
	 */
	protected void addMenuActions(IMenuManager menu) {
	}

	/**
	 * Add any necessary toolbar items for the view's toolbar
	 * 
	 * @param toolbar
	 *           The toolbar manager from the action bars for the workbench part.
	 */
	protected void addToolBarActions(IToolBarManager toolbar) {
	}

	/**
	 * Override if necessary to create a custom event listener. The default implementation will call
	 * {@link #refresh()}.
	 * 
	 * @return The event listener that will update the UI as changes occur to the model.
	 */
	protected ResourceSetListener createEventListener() {
		return new DemultiplexingListener(getFilter()) {

			protected void handleNotification(TransactionalEditingDomain domain,
					Notification notification) {

				if (!isDisposed()) {
					// only force a refresh if we're not in focus (and hence the change didn't come from us)
					IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					if (shouldProcessEvent(window, notification)) {
						refreshJob.schedule(DELAY);
					}
				}
			}
		};
	}

	protected UIJob createUIRefreshJob() {
		UIJob job = new UIJob(Messages.AbstractTopologyPropertySection_Refreshing_user_interface_) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (!isDisposed()) {
					refreshActions();
					refresh();
				}
				return Status.OK_STATUS;
			}

		};
		job.setSystem(true);
		return job;
	}

	/**
	 * Return the {@link TabbedPropertySheetPage} used to create this property section.
	 * 
	 * @return The {@link TabbedPropertySheetPage} used to create this property section.
	 */
	public TabbedPropertySheetPage getPage() {
		return page;
	}

	/**
	 * Return the relevant {@link EditingDomain} for the model being displayed by the Property Sheet
	 * Page
	 * 
	 * @return The relevant {@link EditingDomain} for the model being displayed by the Property Sheet
	 *         Page
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * Refresh any relevant UI pieces due to model changes
	 */
	public abstract void refresh();

	/**
	 * Create the controls required to render UI for the Property Sheet
	 * 
	 * @param parent
	 *           The parent composite
	 * @param tabbedPropertySheetPage
	 *           The page to access workbench properties
	 */
	protected abstract void doCreateControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage);

	/**
	 * Dispose of any acquired resources.
	 */
	protected abstract void doDispose();

	/**
	 * Override as needed to respond to the section prior to be shown.
	 */
	protected void doAboutToBeShown() {

	}

	/**
	 * Override as needed to respond to the section prior to be hidden.
	 */
	protected void doAboutToBeHidden() {

	}

	/**
	 * Override as needed to respond to the section prior to be hidden.
	 */
	protected boolean shouldProcessEvent(IWorkbenchWindow window, Notification notification) {
		return window == null || window.getActivePage() != site.getPage();
	}

}
