package com.ibm.ccl.soa.deploy.core.ui.composites;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * @since 7.0
 * @author nmakin
 * 
 * 1) WIZARD PAGE public void createControl(Composite parent) { super.createControl(parent);
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
 * IDeployHelpContextIds.XXX_WIZARD_PAGE); }
 * 
 * 
 * 2) DIALOG // modeless? protected void configureShell(Shell newShell) {
 * super.configureShell(newShell); PlatformUI.getWorkbench().getHelpSystem().setHelp(newShell,
 * IDeployHelpContextIds.XXX_DIALOG); } // modal? protected Control createDialogArea(Composite
 * parent) { Control comp = super.createDialogArea(parent);
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(comp, IDeployHelpContextIds.XXX_DIALOG); return
 * comp; }
 * 
 * 
 * 2) JFACE ACTION public AddToFavoritesAction() {
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDeployHelpContextIds.XXX_ACTION); }
 * 
 * 3) GENERIC VIEW public final void createPartControl(Composite parent) {
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId()); }
 * 
 * 5) NAVIGATOR VIEW public void createPartControl(Composite parent) { TreeViewer viewer =
 * createViewer(parent); this.viewer = viewer; // Set help for the view
 * getSite().getWorkbenchWindow().getWorkbench().getHelpSystem().setHelp( viewer.getControl(),
 * getHelpContextId()); }
 * 
 * 6) PREFERENCE PAGE public void createControl(Composite parent) { super.createControl(parent);
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
 * IDeployHelpContextIds.XXX_PREFERENCE_PAGE); }
 * 
 * 7) PROPERTY PAGE public void createControl(Composite parent) { super.createControl(parent);
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
 * IDeployHelpContextIds.XXX_PROPERTY_PAGE); }
 * 
 * 8) EDITOR public void createPartControl(Composite parent) {
 * 
 * PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IDeployHelpContextIds.XXX_EDITOR); }
 * 
 * 
 */

public interface IDeployHelpContextIds {
	/**
	 * 
	 */
	public final String PREFIX = DeployCoreUIPlugin.PLUGIN_ID + ".cshelp."; //$NON-NLS-1$

	/**
	 * General context for the topology editor
	 */
	public static final String TODO_AAA = PREFIX + "toped9999"; //$NON-NLS-1$

	/**
	 * General context for the topology editor
	 */
	public static final String TOPOLOGY_EDITOR_GENERAL = PREFIX + "toped0000"; //$NON-NLS-1$
	/**
	 * Diagram Update window, on opening a topology with problems
	 */
	public static final String TOPOLOGY_EDITOR_UPDATE_WINDOW = PREFIX + "toped0001"; //$NON-NLS-1$

	/**
	 * toped0100 Properties view, showing info from a unit in the topology General tab
	 */
	public static final String TOPOLOGY_PROPERTIES_GENERAL_TAB = PREFIX + "toped0100"; //$NON-NLS-1$

	/**
	 * toped0101 Properties view, Requirements tab
	 */
	public static final String TOPOLOGY_PROPERTIES_REQUIREMENTS_TAB = PREFIX + "toped0101"; //$NON-NLS-1$

	/**
	 * toped0102 Properties view, Capabilities tab
	 */
	public static final String TOPOLOGY_PROPERTIES_CAPABILITIES_TAB = PREFIX + "toped0102"; //$NON-NLS-1$

	/**
	 * toped0103 Links composite
	 */
	public static final String TOPOLOGY_PROPERTIES_LINKS_TAB = PREFIX + "toped0103"; //$NON-NLS-1$

	/**
	 * toped0104 Properties view, Artifacts tab
	 */
	public static final String TOPOLOGY_PROPERTIES_ARTIFACTS_TAB = PREFIX + "toped0104"; //$NON-NLS-1$

	/**
	 * toped0106 Properties view, Import topology selected, Variables tab
	 */
	public static final String TOPOLOGY_PROPERTIES_IMPORT_VARIABLES_TAB = PREFIX + "toped0106"; //$NON-NLS-1$

	/**
	 * toped0109 Properties view with nothing selected in the topology editor, Topology tab
	 */
	public static final String TOPOLOGY_PROPERTIES_NO_TOP_SEL_TOP_TAB = PREFIX + "toped0109"; //$NON-NLS-1$

	/**
	 * toped0111 Properties view with nothing selected in the topology editor, Variables tab
	 * 
	 */
	public static final String TOPOLOGY_PROPERTIES_VARIABLES_TAB = PREFIX + "toped0111"; //$NON-NLS-1$

	/**
	 * toped0102 Properties view, Advanced tab
	 */
	public static final String TOPOLOGY_PROPERTIES_ADVANCED_TAB = PREFIX + "toped0112"; //$NON-NLS-1$

	/**
	 * toped0113 Create a new variable in the Variables tab of the Properties view for a topology
	 * 
	 */
	public static final String TOPOLOGY_PROPERTIES_CREATE_NEW_VARIABLE = PREFIX + "toped0113"; //$NON-NLS-1$

	/**
	 * toped0114 edit artifact window
	 */
	public static final String TOPOLOGY_PROPERTIES_ARTIFACTS_LIST_EDIT = PREFIX + "toped0114"; //$NON-NLS-1$

	/**
	 * toped0200 Topology status view
	 * 
	 */
	public static final String TOPOLOGY_STATUS_VIEW = PREFIX + "toped0200"; //$NON-NLS-1$

	/**
	 * toped0201 Export Problems view
	 * 
	 */
	public static final String TOPOLOGY_EXPORT_PROBLEMS_VIEW = PREFIX + "toped0201"; //$NON-NLS-1$

	/**
	 * toped0202 Resource Explorer view (which we may not specialize, in which case this context is
	 * not needed)
	 * 
	 */
	public static final String TOPOLOGY_RESOURCE_EXPLORER_VIEW = PREFIX + "toped0202"; //$NON-NLS-1$

	/**
	 * toped0300 New Topology wizard
	 * 
	 */
	public static final String TOPOLOGY_NEW_TOPOLOGY_WIZARD = PREFIX + "toped0300"; //$NON-NLS-1$

	/**
	 * toped0301 New topology wizard Source folder selection window
	 * 
	 */
	public static final String TOPOLOGY_NEW_TOPOLOGY_WIZARD_SOURCE_FOLDER_SEL_WINDOW = PREFIX
			+ "toped0301"; //$NON-NLS-1$

	/**
	 * toped0302 New topology wizard Namespace selection window
	 * 
	 */
	public static final String TOPOLOGY_NEW_TOPOLOGY_WIZARD_NAMESPACE_SEL_WINDOW = PREFIX
			+ "toped0302"; //$NON-NLS-1$

	/**
	 * toped0303 From the topology editor, right-click a unit or group of units and then click Add to
	 * Palette
	 * 
	 */
	public static final String TOPOLOGY_EDITOR_ADD_TO_PALETTE_WIZARD = PREFIX + "toped0303"; //$NON-NLS-1$

	/**
	 * toped0304 Add to Palette window, click Define New Stack
	 */
	public static final String TOPOLOGY_EDITOR_ADD_TO_PALETTE_DEFINE_NEW_STACK = PREFIX
			+ "toped0304"; //$NON-NLS-1$

	/**
	 * toped0305 Add to Palette window, click Browse (by Icon)
	 */
	public static final String TOPOLOGY_EDITOR_ADD_TO_PALETTE_BROWSE_ICON = PREFIX + "toped0305"; //$NON-NLS-1$

	/**
	 * toped0306 New namespace wizard
	 */
	public static final String TOPOLOGY_EDITOR_NEW_NAMESPACE_WIZARD = PREFIX + "toped0306"; //$NON-NLS-1$

	/**
	 * toped0400 Window > Preferences > Topology editor
	 */
	public static final String TOPOLOGY_EDITOR_WINDOW_PREFERENCES = PREFIX + "toped0400"; //$NON-NLS-1$

	/**
	 * toped0401 Window > Preferences > Topology editor > Color and Font
	 */
	public static final String TOPOLOGY_EDITOR_WINDOW_PREFERENCES_COLOR_AND_FONT = PREFIX
			+ "toped0401"; //$NON-NLS-1$

	/*
	 * For printing preference page
	 */
	public final String TOPOLOGY_EDITOR_PRINTING_PREFERENCE_PAGE_HELPID = PREFIX + "toped0402"; //$NON-NLS-1$

	/**
	 * toped0500 Quick palette, press Ctrl+T
	 */
	public static final String TOPOLOGY_QUICK_PALETTE_DIALOG = PREFIX + "toped0500"; //$NON-NLS-1$

	/**
	 * toped0501 Open Topology, press Ctrl+Shift+I
	 */
	public static final String TOPOLOGY_OPEN_DIALOG = PREFIX + "toped0501"; //$NON-NLS-1$

	/**
	 * toped0502 Capabilities fly-out
	 * 
	 */
	public static final String TOPOLOGY_CAPABILITIES_FLYOUT = PREFIX + "toped0502"; //$NON-NLS-1$

	/**
	 * toped0503 Open Capabilities fly-out and click the add capability button
	 * 
	 */
	public static final String TOPOLOGY_CAPABILITIES_FLYOUT_ADD_CAPABILITY = PREFIX + "toped0503"; //$NON-NLS-1$

	/**
	 * toped0504 Open Capabilities fly-out, select a capability, and click Customize Attributes
	 * button
	 * 
	 * 
	 */
	public static final String TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_CUSTOMIZE_ATTR = PREFIX
			+ "toped0504"; //$NON-NLS-1$

	/**
	 * toped0505 Open capability fly-out and click on a capability to show the properties for that
	 * capability
	 * 
	 */
	public static final String TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_SHOW_PROPERTIES = PREFIX
			+ "toped0505"; //$NON-NLS-1$

	/**
	 * toped0506 Open Requirements fly-out
	 */
	public static final String TOPOLOGY_REQUIREMENTS_FLYOUT = PREFIX + "toped0506"; //$NON-NLS-1$

	/**
	 * toped0507 Requirements fly-out showing details of a requirement
	 */
	public static final String TOPOLOGY_REQUIREMENTS_FLYOUT_DETAILS = PREFIX + "toped0507"; //$NON-NLS-1$

	/**
	 * toped0508 Select a Requirement and click Browse to choose a type
	 */
	public static final String TOPOLOGY_REQUIREMENTS_FLYOUT_SEL_REQUIREMENT_BROWSE_TYPE = PREFIX
			+ "toped0508"; //$NON-NLS-1$

	/**
	 * toped0509 Unit properties fly-out
	 */
	public static final String TOPOLOGY_UNIT_PROPERTIES_FLYOUT = PREFIX + "toped0509"; //$NON-NLS-1$

	/**
	 * toped0510 Press Ctrl+F
	 * 
	 */
	public static final String TOPOLOGY_FIND_DIALOG = PREFIX + "toped0510"; //$NON-NLS-1$	

	/**
	 * toped0511 Press Ctrl+O
	 * 
	 */
	public static final String TOPOLOGY_OUTLINE_VIEW = PREFIX + "toped0511"; //$NON-NLS-1$	

	/**
	 * toped0512 Click error/warning/info icon at the bottom left corner of the unit or link
	 */
	public static final String TOPOLOGY_STATUS = PREFIX + "toped0512"; //$NON-NLS-1$	

	/**
	 * toped0519 On creating a dependency link between two nodes
	 * 
	 */
	public static final String TOPOLOGY_COMMUNICATION_CONSTRAINT_WIZARD = PREFIX + "toped0519"; //$NON-NLS-1$
	/**
	 * toped0520 Search for realization links by dragging the realization link handle to blank canvas
	 * 
	 */
	public static final String TOPOLOGY_SEL_REALIZATION_LINK_DIALOG = PREFIX + "toped0520"; //$NON-NLS-1$

	/**
	 * toped0521 Search for hosting links by dragging the hosting link handle to blank canvas
	 */
	public static final String TOPOLOGY_SEARCH_HOSTING_TARGET = PREFIX + "toped0521"; //$NON-NLS-1$

	/**
	 * toped0522 Dependency link helper dialog
	 */
	public static final String TOPOLOGY_CREATE_DEPENDENCY_LINK = PREFIX + "toped0522"; //$NON-NLS-1$	
	/**
	 * toped0523 Delete a group
	 */
	public static final String TOPOLOGY_DELETE_GROUP = PREFIX + "toped0523"; //$NON-NLS-1$	

	/**
	 * toped0524 Choose a type of constraint when you're adding a constraint
	 */
	public static final String TOPOLOGY_SEL_CONSTRAINT = PREFIX + "toped0524"; //$NON-NLS-1$
	/**
	 * "toped0532" choose a type of constraint when you're adding a constraint link
	 */
	public final String TOPOLOGY_SEL_CONSTRAINT_LINK = PREFIX + "toped0532"; //$NON-NLS-1$

	/**
	 * toped0525 Attributes for a new constraint
	 */
	public static final String TOPOLOGY_CONSTRAINT_PROPERTIES = PREFIX + "toped0525"; //$NON-NLS-1$
	/**
	 * toped0526 Suggestions for quick fixes to problems
	 */
	public static final String TOPOLOGY_QUICK_FIX_RESOLUTION_WINDOW = PREFIX + "toped0526"; //$NON-NLS-1$
	/**
	 * "toped0531" script creation dialog
	 */
	public final String TOPOLOGY_SCRIPT_CREATION_DIALOG = PREFIX + "toped0531"; //$NON-NLS-1$

	/**
	 * "toped0534" delete consolidated link dialog
	 */
	public final String TOPOLOGY_DELETE_CONSOLIDATED_LINK_DIALOG = PREFIX + "toped0534"; //$NON-NLS-1$

	/**
	 * "toped0538" set password dialog
	 */
	public final String TOPOLOGY_SET_PASSWORD_DIALOG = PREFIX + "toped0538"; //$NON-NLS-1$

	/**
	 * Export Wizard -> Select Toplogy->Export Topology toped0002
	 */
	public static final String EXPORT_TOPOLOGY_WIZARD = PREFIX + "toped0002"; //$NON-NLS-1$

	/**
	 * With preferences set to "Enable the QuickFix results dialog," use a quick fix and this window
	 * appears to tell you what was done as a result of the fix.
	 */
	public static final String ENABLE_QUICKFIX_RESULT_DIALOG = PREFIX + "toped0003"; //$NON-NLS-1$

	/**
	 * Right-click a unit and click Visualize > Visualize to New Topology Diagram
	 */
	public static final String VISUALIZE_NEW_TOPOLOGY_DIAGRAM = PREFIX + "toped0004"; //$NON-NLS-1$+

	/**
	 * toped0005 Synchronize from model to workspace
	 */
	public static final String SYNC_MODEL_TO_WORKSPACE = PREFIX + "toped0005"; //$NON-NLS-1$

	/**
	 * Constraint Composite
	 */
	public static final String TOPOLOGY_CONSTRAINT_COMPOSITE = PREFIX + "toped0527"; //$NON-NLS-1$
	/**
	 * toped0529 Collocation Constraint Browse
	 * 
	 */
	public static final String TOPOLOGY_COLLOCATION_CONSTRAINT_BROWSE = PREFIX + "toped0529"; //$NON-NLS-1$

	/**
	 * toped0536 Type constraint browse
	 */
	public static final String TOPOLOGY_TYPE_CONSTRAINT_BROWSE = PREFIX + "toped0536"; //$NON-NLS-1$

	/**
	 * "toped0537" Realization assistant
	 */
	public final String REALIZATION_ASSISTANT = PREFIX + "toped0537"; //$NON-NLS-1$

	/**
	 * toped0535 Stereotypes composite
	 */
	public static final String TOPOLOGY_STEREOTYPE_COMPOSITE = PREFIX + "toped0535"; //$NON-NLS-1$

	/**
	 * toped0530 ProductVersionFlyout
	 * 
	 */
	public static final String TOPOLOGY_PRODUCT_VERSION_FLYOUT_DIALOG = PREFIX + "toped0530"; //$NON-NLS-1$

	/**
	 * toped0533 Properties view, scripts tab, as created by
	 * com.ibm.ccl.soa.deploy.generic.ui.properties.ScriptPropertySection
	 * 
	 */
	public static final String TOPOLOGY_SCRIPT_PROPERTIES = PREFIX + "toped0533"; //$NON-NLS-1$

	/**
	 * toped0007 move unit
	 * 
	 */
	public static final String TOPOLOGY_REFACTOR_MOVE_UNIT = PREFIX + "toped0007"; //$NON-NLS-1$

	/**
	 * Select Unit, Context Action, New Interface
	 */
	public static final String TOPOLOGY_NEW_INTERFACE_DIALOG = PREFIX + "toped0513"; //$NON-NLS-1$

	/**
	 * Select Unit, Context Action, New Service
	 */
	public static final String TOPOLOGY_NEW_SERVICE_DIALOG = PREFIX + "toped0600"; //$NON-NLS-1$

	/**
	 * toped0601 Edit WSDL interface
	 * 
	 */
	public static final String TOPOLOGY_EDIT_WSDL_INTERFACE = PREFIX + "toped0601"; //$NON-NLS-1$

	/**
	 * toped0602 Edit URL interface
	 * 
	 */
	public static final String TOPOLOGY_EDIT_URL_INTERFACE = PREFIX + "toped0602"; //$NON-NLS-1$

	/**
	 * toped0603 Edit DDL interface
	 * 
	 */
	public static final String TOPOLOGY_EDIT_DDL_INTERFACE = PREFIX + "toped0603"; //$NON-NLS-1$

	/**
	 * toped0604 Edit Java interface
	 * 
	 */
	public static final String TOPOLOGY_EDIT_JAVA_INTERFACE = PREFIX + "toped0604"; //$NON-NLS-1$

	/**
	 * toped0546 Description tab of unit props fly-out
	 * 
	 */
	public static final String TOPOLOGY_PROPERTIES_DESCRIPTION_TAB = PREFIX + "toped0546"; //$NON-NLS-1$

	/** ***TO BE ADDED***************** */
	/**
	 * The property dialog that shows when resolutions are run
	 */
	public static final String RESOLUTION_PROPERTY_SET_DIALOG = PREFIX + "toped0547"; //$NON-NLS-1$

	/**
	 * Attribute propagation constraint
	 */
	public static final String ATTRIBUTE_PROPAGATION_CONSTRAINT = PREFIX + "toped0548"; //$NON-NLS-1$

	/**
	 * Attribute propagation constraint popups
	 */
	public static final String ATTRIBUTE_PROPAGATION_CONSTRAINT_POPUP = PREFIX + "toped0553"; //$NON-NLS-1$

	/**
	 * toped0105 Properties page, Import topology selected, Import tab
	 */
	public static final String TOPOLOGY_PROPERTIES_INTERFACE_TAB = PREFIX + "toped0105"; //$NON-NLS-1$

	/**
	 * With preferences set to "Enable the QuickFix results dialog," use a quick fix and this window
	 * appears to tell you what was done as a result of the fix.
	 */
	public static final String SHOW_RELATED_ELEMENT_DIALOG = PREFIX + "toped0549"; //$NON-NLS-1$

	/**
	 * toped0550, unit caption popup
	 */
	public static final String UNIT_CAPTION_POPUP = PREFIX + "toped0550"; //$NON-NLS-1$

	/**
	 * toped0552 customize attributes for an artifact
	 */
	public static final String CUSTOMIZE_ARTIFACT_ATTRIBUTES = PREFIX + "toped0552"; //$NON-NLS-1$

	/**
	 * Dialog for the creation of declarative constraints on unit's attributes
	 */
	public final String CONSTRAINT_ATTRIBUTE = PREFIX + "toped0700"; //$NON-NLS-1$
	/**
	 * Dialog for the creation of declarative constraints on units' hosts
	 */
	public final String CONSTRAINT_HOSTS = PREFIX + "toped0701"; //$NON-NLS-1$
	/**
	 * Dialog for the creation of declarative constraints on group unit's size
	 */
	public final String CONSTRAINT_GROUPSIZE = PREFIX + "toped0702"; //$NON-NLS-1$

	/**
	 * For selection wizard page
	 */
	public final String CONSTRAINT_WIZARD_SELECTION = PREFIX + "toped0703"; //$NON-NLS-1$
	/**
	 * For unit navigation step by step
	 */
	public final String CONSTRAINT_WIZARD_NAVIGATION = PREFIX + "toped0704"; //$NON-NLS-1$
	/**
	 * For wild navigation of units (by "wild", refer to the "wild card" in regular expression)
	 */
	public final String CONSTRAINT_WIZARD_WILD_NAVIGATION = PREFIX + "toped0705"; //$NON-NLS-1$

	/**
	 * For constraint repository
	 */
	public final String CONSTRAINT_REPOSITORY = PREFIX + "toped0706"; //$NON-NLS-1$

}
