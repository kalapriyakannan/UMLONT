/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionProviderAction;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterDialog;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class StatusView extends ViewPart implements ISelectionListener {
	public static final String TAG_STATUSVIEW_ID = "statusview"; //$NON-NLS-1$

	private static final String TAG_STATUSVIEW_CONFIGPROVIDER = "configprovider"; //$NON-NLS-1$

	private static final String TAG_CLASS = "class"; //$NON-NLS-1$

	private final HashSet viewConfigSet = new HashSet();

	protected static IMemento storememento;

	private StatusTreeViewer viewer;

	private Clipboard clipboard;

	// Contribution Items

	private DropDownAction filterDropDown;

	private Action[] filterActions;

	private Action[] groupActions;

	private IMenuManager selectFilterMenu;

	private DropDownAction groupDropDown;

	private DropDownAction subViewDropDown;

	private Action[] subViewActions;

	private Action doubleClickAction;

	private Action propertiesAction;

	private Action configFilterAction;

	private SelectionProviderAction selectAllAction;

	private Action copyAction;

	private Action sortAction;

	private Action saveAction;

	private Action openAction;

	private Action clearAction;

	private final HashSet subConfigs = new HashSet();

	private StatusViewConfig currentConfig = null;

	private Composite parent;

	protected boolean seperate = false;

	/**
	 * @return view ID need same with the org.ui.view extension
	 */
	public String getViewID() {
		return "com.ibm.ccl.soa.deploy.core.ui.statusview"; //$NON-NLS-1$
	}

	protected IStatusViewConfig getSetting() {
		return currentConfig;
	}

	protected void configViewer() {
		viewer.createControl();
		viewer.setSorter(getSetting().getSorter());
		viewer.setSortIndicators();
		viewer.setLabelProvider(getSetting().getConfigProvider().getLabelProvider(
				getSetting().getTableViewerConfig().getTableFields()));
		viewer.setContentProvider(getSetting().getConfigProvider().getContentProvider(this));
		ISelectionChangedListener listener = getSetting().getConfigProvider().getTreeSelectionAction(
				getSite().getPage());
		if (listener != null) {
			viewer.addSelectionChangedListener(listener);
		}
		viewer.setInput(getSetting());
	}

	protected FilterDialog createFiltersDialog() {
		return getSetting().getConfigProvider().createFilterDialog(getSite().getShell(),
				getSetting().getFilters());
	}

	protected void contributeToActionBars() {
		final IActionBars bars = getViewSite().getActionBars();
		fillContributionItems(bars.getMenuManager(), getPullDownContributions());
		fillContributionItems(bars.getToolBarManager(), getToolBarContributions());

	}

	protected void reDrawActionBars() {
		final IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().removeAll();
		bars.getToolBarManager().removeAll();
		fillContributionItems(bars.getMenuManager(), getPullDownContributions());
		fillContributionItems(bars.getToolBarManager(), getToolBarContributions());
	}

	protected Action createCopyAction() {
		Action copy = new Action(Messages.Views_Action_Copy) {
			public void run() {
				final ISelection selection = viewer.getSelection();
				Object[] obj = ((IStructuredSelection) selection).toArray();
				try {
					clipboard.setContents(new Object[] { transferToString(obj) },
							new Transfer[] { TextTransfer.getInstance() });
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}

			private String transferToString(Object[] objs) {
				String temp = ""; //$NON-NLS-1$
				for (int i = 0; i < getSetting().getTableViewerConfig().getTableFields().length; i++) {
					temp = temp
							+ '\t'
							+ getSetting().getTableViewerConfig().getTableFields()[i]
									.getColumnHeaderText();
				}
				temp = temp + '\n';
				for (int i = 0; i < objs.length; i++) {
					for (int j = 0; j < getSetting().getTableViewerConfig().getTableFields().length; j++) {
						try {
							temp = temp
									+ '\t'
									+ getSetting().getTableViewerConfig().getTableFields()[j]
											.getValue(objs[i]);
						} catch (NotSupportedTargetException e) {
							return e.getTarget().toString();
						}
					}
					temp = temp + '\n';
				}

				return temp;
			}
		};

		return copy;
	}

	protected DropDownAction createDropDownFiltersAction() {
		DropDownAction dropDown = new DropDownAction(DeployCoreImages.IMAGE_SELECT_FILTER,
				DeployCoreImages.IMAGE_SELECT_FILTER_D) {

			public Action[] getSubActions() {
				return filterActions;
			}

			public IContributionItem[] getSubItems() {
				return new IContributionItem[] { new ActionContributionItem(configFilterAction) };
			}

		};
		dropDown.setToolTipText(Messages.Views_Action_Filter_Tip);
		return dropDown;
	}

	protected DropDownAction createDropDownGroupsAction() {
		DropDownAction dropDown = new DropDownAction(DeployCoreImages.IMAGE_GROUPBY,
				DeployCoreImages.IMAGE_GROUPBY_D) {

			public Action[] getSubActions() {

				return groupActions;
			}

			public IContributionItem[] getSubItems() {

				return new IContributionItem[0];
			}

		};
		dropDown.setToolTipText(Messages.Views_Action_GroupBy_Tip);
		return dropDown;
	}

	protected DropDownAction createDropDownSubViewAction() {

		if (subViewActions.length == 0) {
			return null;
		}
		DropDownAction dropDown = new DropDownAction(DeployCoreImages.IMAGE_SUBVIEW,
				DeployCoreImages.IMAGE_SUBVIEW) {

			public Action[] getSubActions() {

				return subViewActions;
			}

			public IContributionItem[] getSubItems() {
				return new IContributionItem[0];
			}

		};
		dropDown.setToolTipText(dropDown.getText());
		setContentDescription(getActivatedConfig().getConfigProvider().getName());
		return dropDown;

	}

	protected Action createDoubleClickAction() {
		return new DetailsDialogAction(this.getSite().getShell(), viewer, getSetting()
				.getExtendFields());
	}

	protected void createFilterActions() {
		ArrayList array = new ArrayList();
		for (int i = 0; i < getSetting().getFilters().length; i++) {
			FilterConfig filter = getSetting().getFilters()[i];
			if (filter.isEnabled()) {
				SelectFilterAction action = new SelectFilterAction(this, getSetting(), i);
				array.add(action);
			}
		}
		if (array.size() == 0) {
			getSetting().getFilter(0).setEnabled(true);
			SelectFilterAction action = new SelectFilterAction(this, getSetting(), 0);
			array.add(action);
		}
		filterActions = new Action[array.size()];
		filterActions = (Action[]) array.toArray(filterActions);

	}

	protected void createGroupByActions() {
		groupActions = new Action[getSetting().getGroupFields().length];
		groupActions[0] = new SelectGroupAction(this, "None", 0); //$NON-NLS-1$
		for (int i = 1; i < getSetting().getGroupFields().length; i++) {
			groupActions[i] = new SelectGroupAction(this, getSetting(), i);

		}
	}

	private void createSelectSubViewAction() {
		subViewActions = new Action[subConfigs.size()];
		int i = 0;
		for (Iterator it = subConfigs.iterator(); it.hasNext();) {
			IStatusViewConfig config = (IStatusViewConfig) it.next();
			subViewActions[i] = new SelectSubViewAction(this, config);
			i++;
		}
	}

	protected Action createOpenFilterDialogyAction() {
		Action openDialog = new Action() {
			public void run() {
				FilterDialog dialog = createFiltersDialog();
				if (dialog.open() == Window.OK && dialog.isDirty()) {
					getSetting().setFilters(dialog.getFilters());
					updateForNewFilterSettings();
					viewer.setInput(null);
					viewer.setInput(getSetting());

				}
			}
		};
		openDialog.setText(Messages.Views_Action_ConfigFilter_Text);

		openDialog.setImageDescriptor(DeployCoreImages.IMAGE_CONFIG_FILTER);
		return openDialog;
	}

	/**
	 * @see ViewPart#createPartControl(Composite)
	 */

	public void createPartControl(Composite parent) {
		if (getSetting() == null) {
			return;
		}
		clipboard = new Clipboard(parent.getDisplay());
		viewer = createViewer(parent);
		configViewer();
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		refresh();
	}

	protected Action createSortAction() {
		Action action = new Action() {
			private SortDialog sortDialog;

			public void run() {
				if (sortDialog == null) {
					sortDialog = createSortDialog();
				}
				if (sortDialog.open() == Window.OK && sortDialog.isDirty()) {
					viewer.updateSorter(sortDialog);
					sortDialog.getSorter().saveState(
							StatusView.this.getSetting().getSorterDialogSettings());
				}
			}
		};
		action.setEnabled(true);
		action.setText(Messages.Views_Action_Sort_Text);
		action.setImageDescriptor(DeployCoreImages.IMAGE_SORT);
		return action;
	}

	/**
	 * Return a sort dialog for the receiver.
	 * 
	 * @return TableSortDialog
	 */
	protected SortDialog createSortDialog() {
		return new SortDialog(getSite(), viewer.getTableSorter());

	}

	protected StatusTreeViewer createViewer(Composite parent) {
		StatusTreeViewer viewer = new StatusTreeViewer(parent, getSetting().getTableViewerConfig(),
				getProgressService());
		return viewer;
	}

	/**
	 * @see ViewPart#dispose()
	 */

	public void dispose() {
		IWorkbenchPage page = ResourceUtils.getActiveWorkbenchPage();
		if (page != null) {
			page.removeSelectionListener(DeployCorePerspectiveFactory.ID_PROJECT_NAV, this);
		}
		super.dispose();
		saveState(storememento);
	}

	private void fillContributionItems(IContributionManager manager, IContributionItem[] items) {
		for (int i = 0; i < items.length; i++) {
			manager.add(items[i]);
		}
	}

	protected IContributionItem[] getContextMenuContributions() {
		Vector itemArray = new Vector();
		itemArray.add(new ActionContributionItem(selectAllAction));
		itemArray.add(new ActionContributionItem(copyAction));
		if (clearAction != null) {
			itemArray.add(new ActionContributionItem(clearAction));
		}

		itemArray.add(new Separator());
		itemArray.add(new ActionContributionItem(propertiesAction));
		IContributionItem[] items = new IContributionItem[itemArray.size()];
		return (IContributionItem[]) itemArray.toArray(items);
	}

	protected IWorkbenchSiteProgressService getProgressService() {
		IWorkbenchSiteProgressService service = null;
		final Object siteService = getSite().getAdapter(IWorkbenchSiteProgressService.class);
		if (siteService != null) {
			service = (IWorkbenchSiteProgressService) siteService;
		}
		return service;
	}

	protected Action createPropertiesAction() {
		return new DetailsDialogAction(this.getSite().getShell(), viewer, getSetting()
				.getExtendFields());
	}

	protected IContributionItem[] getPullDownContributions() {
		MenuManager groupByMenu = new MenuManager(Messages.Views_Action_GroupBy_Text);
		for (int i = 0; i < groupActions.length; i++) {

			groupByMenu.add(groupActions[i]);
		}

		selectFilterMenu = new MenuManager(Messages.Views_Action_SelectFilter_Text);

		for (int i = 0; i < filterActions.length; i++) {
			selectFilterMenu.add(filterActions[i]);
		}
		Vector itemArray = new Vector();

		itemArray.add(new ActionContributionItem(sortAction));
		itemArray.add(groupByMenu);
		itemArray.add(selectFilterMenu);
		itemArray.add(new ActionContributionItem(configFilterAction));

		IContributionItem[] items = new IContributionItem[itemArray.size()];
		return (IContributionItem[]) itemArray.toArray(items);
	}

	private IResource getResource(IStructuredSelection selection) {
		// TODO
		return null;
	}

	protected IContributionItem[] getToolBarContributions() {
		Vector itemArray = new Vector();
		itemArray.add(new ActionContributionItem(propertiesAction));
		if (openAction != null) {
			itemArray.add(new ActionContributionItem(openAction));
		}
		if (clearAction != null) {
			itemArray.add(new ActionContributionItem(clearAction));
		}
		if (saveAction != null) {
			itemArray.add(new ActionContributionItem(saveAction));
		}
		if (filterDropDown != null) {
			itemArray.add(new ActionContributionItem(filterDropDown));
		}
		if (groupDropDown != null) {
			itemArray.add(new ActionContributionItem(groupDropDown));
		}
		if (subViewDropDown != null) {
			itemArray.add(new ActionContributionItem(subViewDropDown));
		}
		IContributionItem[] items = new IContributionItem[itemArray.size()];
		items = (IContributionItem[]) itemArray.toArray(items);
		return items;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize it.
	 * 
	 * @return current viewer
	 */
	public StatusTreeViewer getViewer() {
		return viewer;
	}

	protected void hookContextMenu() {
		final MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				StatusView.this.fillContributionItems(manager, getContextMenuContributions());
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}
		});
		final Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	protected void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * @see ViewPart#init(IViewSite, IMemento)
	 */
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		IStatusViewConfig config = getSetting();
		if (config == null) {
			return;
		}
		if (config.getConfigProvider().listeningResource()) {

			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			if (page != null) {
				page.addSelectionListener(DeployCorePerspectiveFactory.ID_PROJECT_NAV, this);
			}
		}

		if (memento != null) {
			storememento = memento;
		}
		if (getSetting() != null) {
			getSetting().restoreState(storememento);
		}

	}

	private void makeActions() {
		sortAction = createSortAction();
		copyAction = createCopyAction();
		doubleClickAction = createDoubleClickAction();
		configFilterAction = createOpenFilterDialogyAction();
		createFilterActions();
		filterDropDown = createDropDownFiltersAction();
		createGroupByActions();
		groupDropDown = createDropDownGroupsAction();
		if (!seperate) {
			createSelectSubViewAction();
			subViewDropDown = createDropDownSubViewAction();
		}

		clearAction = createClearAction();
		// synchonizeWithEditorAction = new
		// SetSelectionOnEditorAction(getSite().getPage());
		selectAllAction = new SelectionProviderAction(viewer, Messages.Views_Action_SelectAll_Text) {

			public void run() {
				viewer.expandAll();
				viewer.setSelection(new StructuredSelection(getAllElements()));

			}

			private List getAllElements() {
				TreeItem[] items = viewer.getTree().getItems();
				LinkedList result = new LinkedList();
				for (int i = 0; i < items.length; i++) {
					Object data = items[i].getData();
					if (data instanceof StatusNode) {
						result.add(data);
					} else if (data instanceof StatusGroup) {
						StatusGroup group = (StatusGroup) data;
						Object[] children = group.getChildren();
						for (int j = 0; j < group.getChildrenNum(); j++) {
							result.add(children[j]);
						}
					}
				}
				return result;
			}

		};
		selectAllAction.setText(Messages.Views_Action_SelectAll_Text);
		selectAllAction.setEnabled(true);
		propertiesAction = createPropertiesAction();
	}

	protected Action createClearAction() {
		return getSetting().getConfigProvider().getClearAction(this);
	}

	protected Action createSaveAction() {
		return getSetting().getConfigProvider().getSaveAction();
	}

	protected Action createOpenAction() {
		return getSetting().getConfigProvider().getOpenAction();
	}

	/**
	 * Open a dialog on the filters
	 * 
	 */
	public final void openFiltersDialog() {

		FilterDialog dialog = createFiltersDialog();

		if (dialog.open() == Window.OK && dialog.isDirty()) {

			FilterConfig[] result = dialog.getFilters();
			getSetting().setFilters(result);
			viewer.setInput(getSetting());
		}
	}

	protected Action[] getDisabledActionsWhenNoElement() {
		Vector actionArray = new Vector();
		if (clearAction != null) {
			actionArray.add(clearAction);
		}
		if (selectAllAction != null) {
			actionArray.add(selectAllAction);
		}
		if (copyAction != null) {
			actionArray.add(copyAction);
		}
		if (propertiesAction != null) {
			actionArray.add(propertiesAction);
		}
		Action[] actions = new Action[actionArray.size()];
		return (Action[]) actionArray.toArray(actions);

	}

	/**
	 * refresh Publish Problem View,if no item need be shown, context menu subitem will be diable.
	 * 
	 * @return stauts
	 */
	public IStatus refresh() {
		try {

			if (viewer.getControl().isDisposed()) {

				return Status.CANCEL_STATUS;
			}
			viewer.refresh(true);
			int count;
			count = viewer.getTree().getItemCount();
			Action[] actions = getDisabledActionsWhenNoElement();
			boolean enable = count != 0;
			for (int i = 0; i < actions.length; i++) {
				actions[i].setEnabled(enable);
			}

		} catch (final RuntimeException e) {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	/**
	 * 
	 * 
	 */
	public void resetColumnWidth() {
		viewer.resetColumnWidth();

	}

	/**
	 * 
	 * @param memento
	 */
	public void restoreState(IMemento memento) {
		getSetting().restoreState(memento);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.ViewPart#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {

		super.saveState(memento);
		getSetting().saveState(memento);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		final Viewer viewer = getViewer();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (viewer != null && !viewer.getControl().isDisposed()) {
					viewer.getControl().setFocus();
				}

			}
		});

	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		if (getSetting().getConfigProvider().listeningResource()) {

			if (selection instanceof IStructuredSelection) {
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof IResource) {
					IResource resource = (IResource) obj;
					FilterConfig filterConfig = getSetting().getSelectedFilter();
					filterConfig.setSelectedResource(resource);
					filterConfig.setEnableResource(getSetting().getConfigProvider().listeningResource());
					update();
				}

			}
		}

	}

	/**
	 * 
	 * 
	 */
	public void update() {
		viewer.setInput(null);
		viewer.setInput(getSetting());
		// this.refresh();

	}

	private void updateForNewFilterSettings() {
		createFilterActions();
		selectFilterMenu.removeAll();
		for (int i = 0; i < filterActions.length; i++) {
			selectFilterMenu.add(filterActions[i]);
		}
	}

	public StatusViewConfig[] getConfig() {
		return null;
	}

	/**
	 * @return the activatedSubView
	 */
	protected IStatusViewConfig getActivatedConfig() {
		return currentConfig;
	}

	/**
	 * @param activatedSubView
	 *           the activatedSubView to set
	 */
	protected void setActivatedSubView(IStatusViewConfig newConfig) {
		currentConfig = (StatusViewConfig) newConfig;
	}

	void redraw() {

		parent.redraw();
		this.update();
		this.refresh();

	}
}
