/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

/**
 * 
 * Ids for all action specific to logic diagram
 */
public interface DeployActionIds {

	/**
	 * custom deploy delete action
	 */
	public final String DEPLOY_DELETE_VIEW = "deployDeleteViewAction"; //$NON-NLS-1$
	public final String DEPLOY_DELETE_MODEL = "deployDeleteModelAction"; //$NON-NLS-1$
	public final String DEPLOY_DELETE_FROM_CONTAINER = "deployDeleteFromContainerAction"; //$NON-NLS-1$

	/**
	 * Preferences... Action
	 */
	public final String PREFERENCES = "preferencesAction"; //$NON-NLS-1$

	/* Menu contribution ids */
	public final String MENU_ADD_UNIT = "addUnitMenu"; //$NON-NLS-1$
	public final String MENU_PUBLISH = "publishMenu"; //$NON-NLS-1$
	public final String EXPORT_ACTION = "exportAction"; //$NON-NLS-1$

	/** Unit Group Menu and Action section */
	public static final String MENU_GROUPING = "groupMenu"; //$NON-NLS-1$

	/**
	 * The menu id for "Add to Group" menu
	 */
	public static final String MENU_ADD_TO_GROUP = "addToGroupMenu"; //$NON-NLS-1$

	/**
	 * The menu id for "Move to Group" menu
	 */
	public static final String MENU_MOVE_TO_GROUP = "moveToGroupMenu"; //$NON-NLS-1$

	/**
	 * The menu id for "Remove From Group" menu
	 */
	public static final String MENU_REMOVE_FROM_GROUP = "removeFromGroupMenu"; //$NON-NLS-1$

	public static final String SHOW_OR_NOT_SHOW_UNIT_ON_HOST = "showOrNotShowUnitOnHostAction"; //$NON-NLS-1$

	public static final String HARVEST_BOUND_UNIT = "harvestBoundAction"; //$NON-NLS-1$

	public static final String CONVERT_TO_SHAPES_OR_TREE = "convertToShapesOrTree"; //$NON-NLS-1$

	public static final String SNAP_VIEWS = "snapViews"; //$NON-NLS-1$

	public static final String SNAP_STYLE = "snapStyle"; //$NON-NLS-1$

	public static final String SHOW_OR_NOT_SHOW_UNIT_RESOURCE_IN_NAVIGATOR = "showUnitResourceInNav"; //$NON-NLS-1$

	/**
	 * The menu id for "Constraints" menu
	 */
	public static final String MENU_ADD_CONSTRAINTS = "constraintsMenu"; //$NON-NLS-1$

	/**
	 * Discover menu section
	 */
	public static final String DISCOVER_LINKS_ACTION_GROUP = "discoverLinksActionGroup"; //$NON-NLS-1$
	public static final String MENU_DISCOVER_LINKS = "discoverLinksMenu"; //$NON-NLS-1$
	public static final String DISCOVER = "discoverAction"; //$NON-NLS-1$

	//	/**
	//	 * Action ID for &lt;popupContribution&gt; {@link InsertNewUnitAction}
	//	 */
	//	public final String MENU_INSERT_NEW_UNIT = "insertNewUnit"; //$NON-NLS-1$

	/**
	 * The menu id for "Add Note" menu
	 */
	public final String ACTION_ADD_NOTELINK = "addNewNoteLinkAction"; //$NON-NLS-1$

	/**
	 * The menu id for "Conceptual" menu
	 */
	public final String ACTION_TOGGLE_CONCEPTUAL = "toggleConceptualAction"; //$NON-NLS-1$

	/**
	 * The menu id for "Visualize" menu
	 */
	public static final String MENU_VISUALIZE = "visualizeMenu"; //$NON-NLS-1$
	/**
	 * The menu id for "Amplifier" menu
	 */
	public static final String MENU_AMPLIFIER = "amplifierMenu"; //$NON-NLS-1$

	/**
	 * The menu id for "Visualize" menu
	 */
	public final String ACTION_VISUALIZE = "visualizeAction"; //$NON-NLS-1$

	/**
	 * The menu id banking a Unit
	 * 
	 * @see BankUnitAction
	 */
	public final String ACTION_BANK_UNIT = "bankAction"; //$NON-NLS-1$

	/**
	 * The menu id quick-outline (context menu equivalent of control-o)
	 * 
	 * @see QuickOutlineAction
	 */
	public final String QUICK_OUTLINE = "quickOutlineAction"; //$NON-NLS-1$

	/**
	 * The menu id quick-palette (context menu equivalent of control-t)
	 * 
	 * @see QuickOutlineAction
	 */
	public final String QUICK_PALETTE = "quickPaletteAction"; //$NON-NLS-1$

	/**
	 * Menu manager contianing context menus which open the property flyouts for a unit
	 */
	public final String MENU_PROPERTY_ACTIONS = "propertyActionMenu"; //$NON-NLS-1$

	/**
	 * The context action that opens a unit's general property section
	 */
	public final String ACTION_OPEN_GENERAL_PROPERTY_FLYOUT = "openGeneralPropertyFlyout"; //$NON-NLS-1$

	/**
	 * The context action that opens a unit's requirements property section
	 */
	public final String ACTION_OPEN_REQUIREMENTS_FLYOUT = "openRequirementsPropertyFlyout"; //$NON-NLS-1$

	/**
	 * The context action that opens a unit's capabilities property section
	 */
	public final String ACTION_CAPABILITIES_FLYOUT = "openCapabilitiesPropertyFlyout"; //$NON-NLS-1$

	/**
	 * The context action that opens a unit's quick fix dialog
	 */
	public final String ACTION_OPEN_QUICK_FIX_DIALOG = "openQuickFixDialog"; //$NON-NLS-1$

	/**
	 * Opens a unit in its default editor
	 */
	public final String ACTION_OPEN_DEFAULT_EDITOR = "openDefaultEditor"; //$NON-NLS-1$

	/**
	 * Open dialog for Opening Topologies
	 */
	public final String ACTION_OPEN_TOPOLOGY_DIALOG = "openTopologyDialog"; //$NON-NLS-1$

	public final String MB_TOP = "mbTop"; //$NON-NLS-1$

	/**
	 * Defines the id of the group created in the Topology editor for synchronize actions.
	 */
	public final String MB_SYNCHRONIZE = "mbSynchronizeGroup"; //$NON-NLS-1$

	/**
	 * Defines the id of the group created in the Topology editor for synchronize actions.
	 */
	public final String MB_PUBLISH = "mbPublishGroup"; //$NON-NLS-1$

	public final String MENU_GLOBAL_ACTIONS = "globalActionsMenu"; //$NON-NLS-1$

	public final String MENU_TOGGLE_CONCEPTUAL = "toggleConceptualMenu"; //$NON-NLS-1$

	public final String MENU_CONTRACT_ACTIONS = "contractActionsMenu"; //$NON-NLS-1$

	public final String MENU_INSTALL_STATE_ACTIONS = "installStateActionsMenu"; //$NON-NLS-1$

	public final String ACTION_SET_CONTRACT_STATE = "setContractState"; //$NON-NLS-1$

	public final String ACTION_SET_INSTALL_STATE = "setInstallState"; //$NON-NLS-1$

	// collapse action ids
	public final String MENU_COLLAPSE = "collapseMenu"; //$NON-NLS-1$     
	public final String MENU_COLLAPSE_TOOLBAR = "collapseMenuToolbar"; //$NON-NLS-1$     
	public final String ACTION_COLLAPSE_ALL = "collapseAllAction"; //$NON-NLS-1$
	public final String ACTION_COLLAPSE_SELECTION = "collapseSelectionAction"; //$NON-NLS-1$
	public final String ACTION_TOOLBAR_COLLAPSE_ALL = "toolbarCollapseAllAction"; //$NON-NLS-1$
	public final String ACTION_TOOLBAR_COLLAPSE_SELECTION = "toolbarCollapseSelectionAction"; //$NON-NLS-1$

	// diagram preference action ids
	public final String MENU_FILTER_PREFERENCE = "filterPreferenceMenu"; //$NON-NLS-1$     
	public final String ACTION_SELECTION_FADING = "selectionFadingAction"; //$NON-NLS-1$
	public final String ACTION_LINK_LABELS = "linkLabelAction"; //$NON-NLS-1$
	public final String ACTION_DUPLICATE_LINKS = "duplicateLinksAction"; //$NON-NLS-1$
	public final String ACTION_ERROR_STATUSES = "errorStatuesAction"; //$NON-NLS-1$
	public final String ACTION_WARNING_STATUSES = "warningStatuesAction"; //$NON-NLS-1$
	public final String ACTION_INFO_STATUSES = "infoStatuesAction"; //$NON-NLS-1$
	public final String ACTION_DUPLICATE_COUNTERS = "dupCounterAction"; //$NON-NLS-1$
	public final String ACTION_CONTRACTS = "contractsAction"; //$NON-NLS-1$
	public final String ACTION_TYPE_NAMES = "typeNamesAction"; //$NON-NLS-1$
	public final String ACTION_NUBS = "nubsAction"; //$NON-NLS-1$
	public final String ACTION_ATTRIBUTES = "attributesAction"; //$NON-NLS-1$
	public final String ACTION_ALL_DETAIL_STATUSES = "allDetailAction"; //$NON-NLS-1$

	// show related element action ids
	public final String ACTION_SHOW_RELATED = "showRelatedAction"; //$NON-NLS-1$

	/**
	 * Refresh Unit(s) action
	 */
	public final String ACTION_REFRESH = "refreshUnitAction"; //$NON-NLS-1$

	/**
	 * Unit actions for adding Requirements.
	 */
	public final String ACTION_ADD_REQUIREMENT = "addRequirementAction"; //$NON-NLS-1$
	/**
	 * Unit actions for adding Capabilities
	 */
	public final String ACTION_ADD_CAPABILITY = "addCapabilityAction"; //$NON-NLS-1$
}
