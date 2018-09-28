/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IActionBars;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.NewLinkWizard;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * @since 7.0
 * 
 */
public class RequirementsToolBarManager extends SharedReqCapsToolBarManager implements
		RequirementLinkChangeHandler {

	public interface RequirementsToolBarHelper {
		/**
		 * Ensure that the details composite is shown for the passed {@link Requirement}.
		 * 
		 * @param aRequirement
		 *           A {@link Requirement} to show details.
		 */
		void showRequirementDetails(Requirement aRequirement);

		/**
		 * Hide the requirement details content.
		 */
		void hideRequirementDetails();

		/**
		 * @return A String that will be used to acquire setting values;
		 */
		String getSettingsPrefix();

		/**
		 * The links column visibility has been toggle so update the view.
		 */
		void resizeForLinkColumnVisibilityChange();

		/**
		 * The action bar has changed so propogate the changes throught the UI.
		 * 
		 * @see IActionBars#updateActionBars()
		 */
		void handleUpdateActionBars();

	}

	/**
	 * 
	 * Show/hide links for the dialog.
	 */
	private class ToggleLinksAction extends Action {

		ToggleLinksAction() {
			super(Messages.RequirementsDialog_Show_target_, IAction.AS_CHECK_BOX);
			setChecked(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			listComposite.setLinkColumnsVisable(isChecked());
			helper.resizeForLinkColumnVisibilityChange();
			handleLinksShown(isChecked());
			updateFillMenuForToggleLinks();
		}
	}

	/**
	 * 
	 * Show/hide the headers in the tree.
	 */
	private class ToggleHeadersAction extends Action {

		ToggleHeadersAction() {
			super(Messages.RequirementsDialog_Show_headers_, IAction.AS_CHECK_BOX);
			setChecked(false);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			listComposite.showHeaders(isChecked());
		}
	}

	//DialogSettings
	private static final String SETTINGS_SHOW_LINKS = "_showLinks"; //$NON-NLS-1$
	private static final String SETTINGS_SHOW_HEADERS = "_showHeaders"; //$NON-NLS-1$

	private static final String DELETE_LINK_ID = "DELETE_LINK_ID"; //$NON-NLS-1$
	private static final String DISCOVER_LINK_ID = "DISCOVER_LINK_ID"; //$NON-NLS-1$

	// Tool Item actions
	private ActionContributionItem deleteLinkToolItem;
	private ActionContributionItem discoverLinksItem;
	private IAction deleteRequirementItem;
	private IAction addRequirementItem;

	private ToggleLinksAction toggleLinksAction;
	private ToggleHeadersAction toggleHeadersAction;

	private final List<DeployLink> selectedLinks = new ArrayList<DeployLink>();

	private RequirementsListComposite listComposite;

	private final RequirementsToolBarHelper helper;
	private Object[] listCompositeSelections;

	private ISelectionChangedListener linksEnablementListener;
	private List<Requirement> selectedRequirements;

	private IMenuManager fillMenu;

	/**
	 * Create a new toolbar manager.
	 * 
	 * @param parent
	 *           The parent {@link Composite}.
	 * @param isImport
	 *           Set to true if the passed {@link Unit} is imported.
	 * @param aUnit
	 *           The owning {@link Unit}.
	 * @param aToolBarHelper
	 *           A {@link RequirementsToolBarHelper} instance.
	 * @param aToolBarManager
	 *           An {@link IToolBarManager} that will be responsible for managing the {@link ToolBar}.
	 */
	public RequirementsToolBarManager(Composite parent, boolean isImport, Unit aUnit,
			RequirementsToolBarHelper aToolBarHelper, IToolBarManager aToolBarManager) {
		super(parent, isImport, aUnit, aToolBarManager);
		helper = aToolBarHelper;
		initializeActions();
	}

	@Override
	protected void initializeActions() {
		super.initializeActions();
		// Toggle Menu Actoins
		createToggleMenuActions();
		// Add
		createAddRequirementToolItem();
		// Delete
		createDeleteRequirementToolItem();
		if (showLinks()) {
			// Discover Links
			createDiscoverLinksToolItem();
			// Delete Links
			createDeleteLinkToolItem();
		}
	}

	private void ensureLinkActionsCreated() {
		if (discoverLinksItem == null) {
			createDiscoverLinksToolItem();
		}
		if (deleteLinkToolItem == null) {
			createDeleteLinkToolItem();
		}
	}

	private void createToggleMenuActions() {
		toggleLinksAction = new ToggleLinksAction();
		toggleHeadersAction = new ToggleHeadersAction();
		// Restore settings
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings();
		String linksKey = helper.getSettingsPrefix() + SETTINGS_SHOW_LINKS;
		if (settings.get(linksKey) != null) {
			toggleLinksAction.setChecked(settings.getBoolean(linksKey));
		} else {
			//By default do not show the links.
			toggleLinksAction.setChecked(false);
		}
		String headersKey = helper.getSettingsPrefix() + SETTINGS_SHOW_HEADERS;
		if (settings.get(headersKey) != null) {
			toggleHeadersAction.setChecked(settings.getBoolean(headersKey));
		}
	}

	/**
	 * Clients must call this method to add the actions to the {@link IToolBarManager} that was
	 * passed in the constructor.
	 */
	@Override
	public void addActionsToToolbar() {
		super.addActionsToToolbar();
		toolBar.add(addRequirementItem);
		toolBar.add(deleteRequirementItem);
		toolBar.add(new Separator());
		if (showLinks()) {
			toolBar.add(discoverLinksItem);
			toolBar.add(deleteLinkToolItem);
		}
	}

	/**
	 * Add menu actions to aMenuManager.
	 * 
	 * @param aMenuManager
	 *           An {@link IMenuManager} that will create and manage the actions in the menu.
	 */
	public void fillMenu(IMenuManager aMenuManager) {
		fillMenu = aMenuManager;
		if (fillMenu != null) {
			fillMenu.add(toggleHeadersAction);
			fillMenu.add(toggleLinksAction);
			fillMenu.add(addRequirementItem);
			fillMenu.add(deleteRequirementItem);
			if (showLinks()) {
				fillMenu.add(discoverLinksItem.getAction());
				fillMenu.add(deleteLinkToolItem.getAction());
			}
		}
	}

	private void updateFillMenuForToggleLinks() {
		if (fillMenu != null) {
			fillMenu.remove(DELETE_LINK_ID);
			fillMenu.remove(DISCOVER_LINK_ID);
			if (showLinks()) {
				fillMenu.add(discoverLinksItem.getAction());
				fillMenu.add(deleteLinkToolItem.getAction());
			}
			fillMenu.update(true);
		}
	}

	private void createDeleteLinkToolItem() {
		IAction action = new Action() {
			@Override
			public void run() {
				PropertyUtils.deleteLinkElementsAndViews(selectedLinks,
						Messages.RequirementsDialog_Remove_link_to_selected_target_);
				listComposite.updateTree(listCompositeSelections);
				deleteLinkToolItem.getAction().setEnabled(false);
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}
		};
		action.setId(DELETE_LINK_ID);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE_LINK));
		action.setDisabledImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE_LINK_DISABLED));
		action.setToolTipText(Messages.RequirementsDialog_Remove_link_to_selected_target_);
		action.setText(Messages.RequirementsDialog_Remove_link_to_selected_target_);
		action.setEnabled(false);

		deleteLinkToolItem = new ActionContributionItem(action);
	}

	private void createDeleteRequirementToolItem() {
		deleteRequirementItem = new Action() {

			@Override
			public void run() {
				handleDeleteRequirement();
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}
		};
		deleteRequirementItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE_REQUIREMENT));
		deleteRequirementItem.setDisabledImageDescriptor(DeployCoreUIPlugin.getDefault()
				.getSharedImages().getImageDescriptor(ISharedImages.IMG_DELETE_REQUIREMENT_DISABLED));
		deleteRequirementItem
				.setToolTipText(Messages.RequirementsPopupDialog_Delete_the_selected_requirement_);
		deleteRequirementItem
				.setText(Messages.RequirementsPopupDialog_Delete_the_selected_requirement_);
		deleteRequirementItem.setEnabled(false);
	}

	/*
	 * TODO Rework to use a simpler add requirement dialog.
	 */
	protected void handleAddRequirement() {
		final Requirement requirement = CoreFactory.eINSTANCE.createRequirement();
		IUndoableOperation op = new DeployTransactionalCommand(unit,
				Messages.RequirementsPropertySection5_Add_Requiremen_) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				requirement.setName(generateUniqueName());
				unit.getRequirements().add(requirement);
				listComposite.refresh();
				listComposite.setSelection(requirement);
				return null;
			}

			private String generateUniqueName() {
				List<String> names = getReqNames();
				int cnt = 0;
				String candidate = "r0"; //$NON-NLS-1$
				while (names.contains(candidate)) {
					candidate = "r" + ++cnt; //$NON-NLS-1$
				}

				return candidate;
			}

			private List<String> getReqNames() {
				List<String> retVal = new LinkedList<String>();
				for (Iterator<Requirement> it = unit.getRequirements().iterator(); it.hasNext();) {
					Requirement req = it.next();
					retVal.add(req.getName());
				}
				return retVal;
			}

		};
		LightweightOperationFactory.execute(unit, op);

		if (requirement != null) {
			//Select the new Requirement.
			listComposite.setSelection(requirement);
			//Setting the selection will open the details.
			//	helper.showRequirementDetails(requirement);
		}
	}

	private Shell getShell() {
		return listComposite.getShell();
	}

	private void createDiscoverLinksToolItem() {
		IAction action = new Action() {

			@Override
			public void run() {
				// dan if you have the requirment use it instead of the unit.
				LinkDiscoveryDataModel linkDiscoveryModel = LinkDiscoveryDataModel.createModel();
				linkDiscoveryModel.setUnit(unit);
				NewLinkWizard wizard = new NewLinkWizard(linkDiscoveryModel);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				dialog.create();
				if (dialog.open() != Window.CANCEL) {
					listComposite.refresh();
				}
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}

		};
		action.setId(DISCOVER_LINK_ID);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DISCOVER_LINK));

		action.setToolTipText(Messages.RequirementsDialog_Discover_missing_links_);
		action.setText(Messages.RequirementsDialog_Discover_missing_links_);
		action.setEnabled(showLinks());

		discoverLinksItem = new ActionContributionItem(action);
	}

	/**
	 * 
	 */
	private void handleDeleteRequirement() {
		PropertyUtils.deleteRequirements(selectedRequirements, unit,
				Messages.RequirementsPopupDialog_Delete_the_selected_requirement_);
		listComposite.refresh();
		deleteRequirementItem.setEnabled(false);
		helper.hideRequirementDetails();

		//	listComposite.selectFirst();
	}

	private void createAddRequirementToolItem() {
		addRequirementItem = new Action() {

			@Override
			public void run() {
				if (unit != null && unit.isPublic()) {
					handleAddRequirement();
				}
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}

		};
		addRequirementItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD_REQUIREMENT));
		addRequirementItem.setDisabledImageDescriptor(DeployCoreUIPlugin.getDefault()
				.getSharedImages().getImageDescriptor(ISharedImages.IMG_ADD_REQUIREMENT_DISABLED));
		addRequirementItem.setToolTipText(Messages.RequirementsPropertySection5_Add_Requiremen_);
		addRequirementItem.setText(Messages.RequirementsPropertySection5_Add_Requiremen_);

		//Can we add requirements?
		if (unit == null || !unit.isPublic()) {
			addRequirementItem.setEnabled(false);
		}
	}

	@Override
	protected void saveDialogSettings() {
		super.saveDialogSettings();
		IDialogSettings settings = getDialogSettings();
		settings.put(helper.getSettingsPrefix() + SETTINGS_SHOW_LINKS, toggleLinksAction.isChecked());
		settings.put(helper.getSettingsPrefix() + SETTINGS_SHOW_HEADERS, toggleHeadersAction
				.isChecked());
	}

	@Override
	protected String getSettingsPrefix() {
		return helper.getSettingsPrefix();
	}

	@Override
	protected List<? extends DeployModelObject> getSelectedDMOs() {
		return selectedRequirements;
	}

	/**
	 * The toolbar manager acts as a helper to a given list composite; and triggers updates as needed
	 * once Requirements are added or removed.
	 * 
	 * @param aListComposite
	 */
	public void setRequirementListComposite(RequirementsListComposite aListComposite) {
		listComposite = aListComposite;
		if (listComposite != null) {
			listComposite.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					selectedRequirements = null;
					selectedLinks.clear();
					listCompositeSelections = null;
					if (event.getSelection().isEmpty()) {
						if (deleteLinkToolItem != null) {
							deleteLinkToolItem.getAction().setEnabled(false);
						}
						deleteRequirementItem.setEnabled(false);
						setVisibilityItemEnabled(false);
					} else if (event.getSelection() instanceof IStructuredSelection) {
						Topology editTop = unit.getEditTopology();
						boolean isImportedUnit = editTop != unit.getTopology();
						Iterator<?> it = ((IStructuredSelection) event.getSelection()).iterator();
						boolean enable = true;
						while (enable && it.hasNext()) {
							Object item = it.next();
							if (!(item instanceof Requirement) || !((Requirement) item).isMutable()) {
								enable = false;
							} else {
								if (isImportedUnit && ((Requirement) item).getTopology() != editTop) {
									enable = false;
								}
							}
						}
						selectedRequirements = ((IStructuredSelection) event.getSelection()).toList();
						deleteRequirementItem.setEnabled(enable);
						setVisibilityItemEnabled(enable);
					}
				}
			});
		}
		if (showLinks()) {
			addLinksEnablementSupport();
		}
	}

	private void addLinksEnablementSupport() {
		if (linksEnablementListener == null) {
			linksEnablementListener = new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					calculateSelectedLinks(event.getSelection());
				}
			};
		}
		if (listComposite != null) {
			listComposite.addSelectionChangedListener(linksEnablementListener);
		}
	}

	private void calculateSelectedLinks(ISelection selection) {
		selectedLinks.clear();
		listCompositeSelections = null;
		if (selection.isEmpty() && deleteLinkToolItem != null) {
			deleteLinkToolItem.getAction().setEnabled(false);
		} else if (selection instanceof IStructuredSelection) {
			calculateLinksAndEnablement((IStructuredSelection) selection);
		}
	}

	private void removeLinksEnablementSupport() {
		if (linksEnablementListener != null && listComposite != null) {
			listComposite.removeSelectionListener(linksEnablementListener);
		}
	}

	protected void calculateLinksAndEnablement(IStructuredSelection selection) {
		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			DeployLink link = listComposite.getLink(item);
			if (link == null) {
				deleteLinkToolItem.getAction().setEnabled(false);
				return;
			}
			Topology topology = link.getTopology();
			if (topology != null && topology != link.getEditTopology()) {
				deleteLinkToolItem.getAction().setEnabled(false);
				return;
			}
			selectedLinks.add(link);
		}
		listCompositeSelections = selection.toArray();
		deleteLinkToolItem.getAction().setEnabled(true);

	}

	/**
	 * If the delete {@link ToolItem} is enabled then invoke its action based on the current
	 * selection from the {@link RequirementsListComposite}.
	 */
	public void invokeDeleteRequirementItem() {
		if (deleteRequirementItem != null && deleteRequirementItem.isEnabled()) {
			//Delete the requirements
			handleDeleteRequirement();
		}
	}

	/**
	 * The links can be shown or hidden from the {@link RequirementsListComposite}. When this
	 * happens we need to adjust the link tool items.
	 * 
	 * @param doShowLinks
	 *           A boolean indicating whether links are shown or not.
	 */
	private void handleLinksShown(boolean doShowLinks) {
		if (doShowLinks) {
			ensureLinkActionsCreated();
			toolBar.add(discoverLinksItem);
			toolBar.add(deleteLinkToolItem);
			discoverLinksItem.getAction().setEnabled(true);
			addLinksEnablementSupport();
		} else {
			if (discoverLinksItem != null) {
				toolBar.remove(discoverLinksItem);
				discoverLinksItem.getAction().setEnabled(false);
			}
			if (deleteLinkToolItem != null) {
				toolBar.remove(deleteLinkToolItem);
				deleteLinkToolItem.getAction().setEnabled(false);
			}
			removeLinksEnablementSupport();
		}
		toolBar.update(false);
		helper.handleUpdateActionBars();
	}

	@Override
	protected void didSetInput(Unit aUnit) {
		//Can we add requirements?
		if (aUnit == null || !aUnit.isPublicEditable()) {
			addRequirementItem.setEnabled(false);
		} else {
			addRequirementItem.setEnabled(true);
		}
	}

	/**
	 * 
	 * @return true if the headers should be shown based on the menu action.
	 */
	public boolean showHeaders() {
		if (toggleHeadersAction != null) {
			return toggleHeadersAction.isChecked();
		}
		return false;
	}

	/**
	 * 
	 * @return true if the links should be shown based on the menu action.
	 */
	public boolean showLinks() {
		if (toggleLinksAction != null) {
			return toggleLinksAction.isChecked();
		}
		return true;
	}

	public IStatus handleRequirementLinkChange(Notification notification) {
		//Update the deleteLinkToolItem if a hosting requirement is currently selected.
		if (deleteLinkToolItem != null && deleteLinkToolItem.isVisible() && listComposite != null) {
			calculateSelectedLinks(listComposite.getTreeViewer().getSelection());
		}
		return Status.OK_STATUS;
	}
}