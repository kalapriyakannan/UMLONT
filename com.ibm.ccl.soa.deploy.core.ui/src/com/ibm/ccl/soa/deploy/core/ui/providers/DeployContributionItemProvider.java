/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.PrintPreviewAction;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddCapabilityAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddNoteAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddRequirementAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddToGroupMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddUnitMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.CollapseAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.CollapseMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.ConstraintsMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.ConvertToShapesOrTreeAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.DeployActionIds;
import com.ibm.ccl.soa.deploy.core.ui.actions.DeployDeleteAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.GlobalDeployMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.GroupingMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.HarvestBoundUnitAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.MoveToGroupMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.OpenDefaultEditorAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.PropertyActionMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.QuickOutlineAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.QuickPaletteAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.RefreshUnitAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.RemoveFromGroupMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.SelectionPropergatorCommonNavigatorAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.ShowOrNotShowUnitOnHostAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.ShowPreferencesAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.ShowRelatedAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.SnapStyleAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.SnapViewsAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.TopologyExportAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.VisualizeMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.AddToPaletteAction;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.OpenTopologyDialogHandler;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.TopologyPublisherAction;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.UnitAmplifierAction;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitAmplifierDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

/**
 * Collects all the actions that are provided by the deploy diagram plug-in.
 * 
 * @see DeployDeleteAction
 */
public class DeployContributionItemProvider extends AbstractContributionItemProvider implements
		DeployActionIds {

	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (!inDeployCoreEditor(partDescriptor)) {
			return null;
		}

		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if (actionId.equals(ACTION_ADD_CAPABILITY)) {
			return new AddCapabilityAction(workbenchPage);
		} else if (actionId.equals(ACTION_ADD_REQUIREMENT)) {
			return new AddRequirementAction(workbenchPage);
		} else if (actionId.equals(DEPLOY_DELETE_VIEW)) {
			return new DeployDeleteAction(workbenchPage, DeployDeleteAction.DELETE_FROM_DIAGRAM,
					DeployDeleteAction.MENUACTION_DELETE);
		} else if (actionId.equals(DEPLOY_DELETE_MODEL)) {
			return new DeployDeleteAction(workbenchPage, DeployDeleteAction.DELETE_FROM_MODEL,
					DeployDeleteAction.MENUACTION_DELETE);
		} else if (actionId.equals(PREFERENCES)) {
			return new ShowPreferencesAction();
		} else if (actionId.equals(EXPORT_ACTION)) {
			return new TopologyExportAction(workbenchPage);
		} else if (actionId.equals(SHOW_OR_NOT_SHOW_UNIT_ON_HOST)) {
			return new ShowOrNotShowUnitOnHostAction(workbenchPage);
		} else if (actionId.equals(HARVEST_BOUND_UNIT)) {
			return new HarvestBoundUnitAction(workbenchPage);
		} else if (actionId.equals(CONVERT_TO_SHAPES_OR_TREE)) {
			return new ConvertToShapesOrTreeAction(workbenchPage);
		} else if (actionId.equals(SNAP_VIEWS)) {
			return new SnapViewsAction(workbenchPage);
		} else if (actionId.equals(SNAP_STYLE)) {
			return new SnapStyleAction(workbenchPage);
		} else if (actionId.equals(SHOW_OR_NOT_SHOW_UNIT_RESOURCE_IN_NAVIGATOR)) {
			return new SelectionPropergatorCommonNavigatorAction();
			//		} else if (actionId.equals(MENU_INSERT_NEW_UNIT)) {
			//			return new InsertNewUnitAction(partDescriptor.getPartPage());
		} else if (actionId.equals(ACTION_ADD_NOTELINK)) {
			return new AddNoteAction(workbenchPage);
		} else if (actionId.equals(ACTION_BANK_UNIT)) {
			return new AddToPaletteAction(workbenchPage);
		} else if (actionId.equals(QUICK_OUTLINE)) {
			return new QuickOutlineAction(workbenchPage);
		} else if (actionId.equals(QUICK_PALETTE)) {
			return new QuickPaletteAction(workbenchPage);
		} else if (actionId.equals(ACTION_OPEN_TOPOLOGY_DIALOG)) {
			return new OpenTopologyDialogHandler();
//		} else if (actionId.equals(MENU_DISCOVER_LINKS)) {
//			return new DiscoverLinksAction(workbenchPage);
		} else if (actionId.equals(ACTION_OPEN_DEFAULT_EDITOR)) {
			return new OpenDefaultEditorAction(workbenchPage);
		} else if (actionId.equals(ACTION_COLLAPSE_ALL)) {
			return CollapseAction.createArrangeAllAction(workbenchPage);
		} else if (actionId.equals(ACTION_COLLAPSE_SELECTION)) {
			return CollapseAction.createArrangeSelectionAction(workbenchPage);
		} else if (actionId.equals(ACTION_TOOLBAR_COLLAPSE_ALL)) {
			return CollapseAction.createToolbarArrangeAllAction(workbenchPage);
		} else if (actionId.equals(ACTION_TOOLBAR_COLLAPSE_SELECTION)) {
			return CollapseAction.createToolbarArrangeSelectionAction(workbenchPage);
		} else if (actionId.equals(ACTION_DUPLICATE_COUNTERS)) {
			return FilterPreferenceAction.createDuplicateCounterAction(workbenchPage);
		} else if (actionId.equals(ACTION_DUPLICATE_LINKS)) {
			return FilterPreferenceAction.createDuplicateLinksAction(workbenchPage);
		} else if (actionId.equals(ACTION_ATTRIBUTES)) {
			return FilterPreferenceAction.createAttributesAction(workbenchPage, false);
		} else if (actionId.equals(ACTION_NUBS)) {
			return FilterPreferenceAction.createNubsAction(workbenchPage, false);
		} else if (actionId.equals(ACTION_CONTRACTS)) {
			return FilterPreferenceAction.createContractAction(workbenchPage, false);
		} else if (actionId.equals(ACTION_TYPE_NAMES)) {
			return FilterPreferenceAction.createTypeNamesAction(workbenchPage, false);
		} else if (actionId.equals(ACTION_ERROR_STATUSES)) {
			return FilterPreferenceAction.createErrorStatusesAction(workbenchPage);
		} else if (actionId.equals(ACTION_WARNING_STATUSES)) {
			return FilterPreferenceAction.createWarningStatusesAction(workbenchPage);
		} else if (actionId.equals(ACTION_INFO_STATUSES)) {
			return FilterPreferenceAction.createInfoStatusesAction(workbenchPage);
		} else if (actionId.equals(ACTION_SHOW_RELATED)) {
			return new ShowRelatedAction(workbenchPage);
		} else if (actionId.equals(PrintPreviewAction.ID)) {
			return new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
		} else if (actionId.equals(ACTION_REFRESH)) {
			return new RefreshUnitAction(workbenchPage);
		}

		return super.createAction(actionId, partDescriptor);
	}

	private boolean inDeployCoreEditor(IWorkbenchPartDescriptor partDescriptor) {
		return partDescriptor.getPartId().equals(DeployCoreUIPlugin.EDITOR_ID);
	}

	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {

		if (menuId.equals(MENU_ADD_UNIT)) {
			/**
			 * Create "Add Unit" menu
			 */
			return new AddUnitMenuManager(partDescriptor.getPartPage());

		} else if (menuId.equals(MENU_PUBLISH)) {
			IStructuredSelection selection = (IStructuredSelection) partDescriptor.getPartPage()
					.getSelection();
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) selection.getFirstElement();
			Topology topology = (Topology) selectedEP.getNotationView().getElement();
			ITopologyPublisherDescriptor[] descriptors = ExtensionsCore
					.createTopologyPublisherService().findAvailableTopologyPublishers();
			IMenuManager pubMenu = new MenuManager(Messages.PUBLISH_TOPOLOGY_SUB_MENU,
					com.ibm.ccl.soa.deploy.core.ui.navigator.actions.ActionIds.PUBLISH_TOPOLOGY_ACTION);
			for (int x = 0; x < descriptors.length; ++x) {
				pubMenu.add(new TopologyPublisherAction(partDescriptor.getPartPage().getActiveEditor()
						.getSite().getShell(), descriptors[x], topology));
			}

			return pubMenu;

		} else if (menuId.equals(MENU_AMPLIFIER)) {
			IStructuredSelection selection = (IStructuredSelection) partDescriptor.getPartPage()
					.getSelection();
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) selection.getFirstElement();
			Object obj = selectedEP.getNotationView().getElement();
			if (!(obj instanceof Unit)) {
				return super.createMenuManager(menuId, partDescriptor);
			}
			Unit unit = (Unit) obj;
			UnitAmplifierDescriptor[] descriptors = UnitLifeCycleManager.getInstance()
					.findEnabledTopologyUnitAmplifiersByInputOnly(unit);
			IMenuManager ampMenu = new MenuManager(Messages.DeployContributionItemProvider_populat_,
					com.ibm.ccl.soa.deploy.core.ui.navigator.actions.ActionIds.AMPLIFY_ACTION);
			for (int x = 0; x < descriptors.length; ++x) {
				ampMenu
						.add(new UnitAmplifierAction(partDescriptor.getPartPage(), descriptors[x], unit));
			}
			return ampMenu;

		} else if (menuId.equals(MENU_GROUPING)) {
			return new GroupingMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_ADD_TO_GROUP)) {
			return new AddToGroupMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_MOVE_TO_GROUP)) {
			return new MoveToGroupMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_REMOVE_FROM_GROUP)) {
			return new RemoveFromGroupMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_VISUALIZE)) {
			return new VisualizeMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_ADD_CONSTRAINTS)) {
			return new ConstraintsMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_GLOBAL_ACTIONS)) {
			return new GlobalDeployMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(DeployActionIds.MENU_PROPERTY_ACTIONS)) {
			return new PropertyActionMenuManager(partDescriptor.getPartPage());
		} else if (menuId.equals(MENU_COLLAPSE)) {
			return new CollapseMenuManager();
		} else if (menuId.equals(MENU_COLLAPSE_TOOLBAR)) {
			IAction action = getAction(ACTION_TOOLBAR_COLLAPSE_ALL, partDescriptor);
			if (action != null) {
				return new CollapseMenuManager();
			}
		} else if (menuId.equals(MENU_FILTER_PREFERENCE)) {
			return new FilterPreferenceMenuManager();
		}
		return super.createMenuManager(menuId, partDescriptor);
	}

} // end class DeployContributionItemProvider