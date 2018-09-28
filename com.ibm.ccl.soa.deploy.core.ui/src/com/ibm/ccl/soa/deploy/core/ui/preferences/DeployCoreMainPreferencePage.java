/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.gmf.runtime.common.ui.preferences.ComboFieldEditor;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * The Deploy Core preference page.
 * 
 * @author Ed Snible
 * @author jswanke
 */
public class DeployCoreMainPreferencePage extends AbstractPreferencePage {

	public void createControl(Composite parent) {
		super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
				IDeployHelpContextIds.TOPOLOGY_EDITOR_WINDOW_PREFERENCES);
	}

	//	 * To get a preference from another class:
	//		 *			IPreferenceStore preferenceStore = DeployToolPlugin.getDefault().getPreferenceStore();
	//		 *			boolean bOpenPerspective = preferenceStore.getBoolean(IDeployPreferences.OPEN_DEPLOY_PERSPECTIVE);

	//preference page editor controls
	private ComboFieldEditor openDeployPerspective = null;
	private ComboFieldEditor reuseExistingInstances = null;
	private ComboFieldEditor hostingLinkStyleFieldEditor = null;
	private ComboFieldEditor multipleLinkStyleFieldEditor = null;
	private ComboFieldEditor lineStyleFieldEditor;
	private ComboFieldEditor groupStyleFieldEditor;
	private ComboFieldEditor snapStyleFieldEditor;
	private CheckBoxFieldEditor selectionFading = null;
	private CheckBoxFieldEditor offscreenLinkLabels = null;
	private CheckBoxFieldEditor quickfixResultsDialog = null;
	private CheckBoxFieldEditor filterSecondaryDupLinks = null;
	private CheckBoxFieldEditor filterDupViewIndicators = null;
	private CheckBoxFieldEditor filterAttributes = null;
	private CheckBoxFieldEditor filterNubs = null;
	private CheckBoxFieldEditor filterContracts = null;
	private CheckBoxFieldEditor filterTypeNames = null;
	private CheckBoxFieldEditor filterDiagramContracts = null;
	private CheckBoxFieldEditor filterErrorMarkers = null;
	private CheckBoxFieldEditor filterWarningMarkers = null;
	private CheckBoxFieldEditor filterInfoMarkers = null;
	private CheckBoxFieldEditor dlcdAutoCreateLink = null;
	private CheckBoxFieldEditor dlcpAllowMatchCreate = null;
	private CheckBoxFieldEditor dlcpFilter0Matches = null;
	private CheckBoxFieldEditor locationBindingUsage = null;

	private boolean canChange = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xtools.common.ui.preferences.AbstractPreferencePage#addFields(org.eclipse.swt.widgets.Composite)
	 */
	protected void addFields(Composite parent) {
		canChange = canChange();
		Group generalGlobalGroup = new Group(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		generalGlobalGroup.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		generalGlobalGroup.setLayoutData(gridData);
		generalGlobalGroup.setText(Messages.GENERAL_SETTINGS_LABEL);

		Composite composite = new Composite(generalGlobalGroup, SWT.NONE);

		// when to open deployment perspective
		openDeployPerspective = new ComboFieldEditor(IDeployPreferences.OPEN_DEPLOY_PERSPECTIVE,
				Messages.OPEN_DEPLOY_PERSPECTIVE_LABEL, composite, ComboFieldEditor.STRING_TYPE, true,
				0, 0, true);
		openDeployPerspective.autoStorage = true;
		addField(openDeployPerspective);
		// fill up labels
		Combo openStyleCombo = openDeployPerspective.getComboControl();
		openStyleCombo.add(Messages.DeployCoreMainPreferencePage_alway_);
		openStyleCombo.add(Messages.DeployCoreMainPreferencePage_neve_);
		openStyleCombo.add(Messages.DeployCoreMainPreferencePage_promp_);

		// reuse existing instances from topology
		reuseExistingInstances = new ComboFieldEditor(
				IDeployPreferences.DEPLOY_REUSE_EXISTING_INSTANCES,
				Messages.DEPLOY_REUSE_EXISTING_INSTANCES_LABEL, composite,
				ComboFieldEditor.STRING_TYPE, true, 0, 0, true);
		reuseExistingInstances.autoStorage = true;
		addField(reuseExistingInstances);
		// fill up labels
		Combo openStyleCombo1 = reuseExistingInstances.getComboControl();
		openStyleCombo1.add(Messages.DeployCoreMainPreferencePage_alway_);
		openStyleCombo1.add(Messages.DeployCoreMainPreferencePage_neve_);
		openStyleCombo1.add(Messages.DeployCoreMainPreferencePage_promp_);

		// when routing style to use with Hosting Links
		hostingLinkStyleFieldEditor = new ComboFieldEditor(IDeployPreferences.HOSTING_LINK_ROUTING,
				Messages.HOSTING_LINK_LINE_ROUTING_STYLE, composite, ComboFieldEditor.STRING_TYPE,
				true, 0, 0, true);
		hostingLinkStyleFieldEditor.autoStorage = true;
		addField(hostingLinkStyleFieldEditor);
		{
			Combo lineStyleCombo = hostingLinkStyleFieldEditor.getComboControl();
			lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Manual_text);
			lineStyleCombo
					.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Rectilinear_text);
		}

		lineStyleFieldEditor = new ComboFieldEditor(IPreferenceConstants.PREF_LINE_STYLE,
				Messages.DeployCoreMainPreferencePage_Dependency_Routing, composite,
				ComboFieldEditor.INT_TYPE, true, 0, 0, true);
		lineStyleFieldEditor.autoStorage = true;
		addField(lineStyleFieldEditor);
		{
			Combo lineStyleCombo = lineStyleFieldEditor.getComboControl();
			lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Manual_text);
			lineStyleCombo
					.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Rectilinear_text);
		}

		// how to draw multiple links between 2 units-- consolidated or fanned
		multipleLinkStyleFieldEditor = new ComboFieldEditor(
				IDeployPreferences.PREF_MULTIPLE_LINKS_STYLE,
				Messages.DeployCoreMainPreferencePage_Routing_of_multiple_links_, composite,
				ComboFieldEditor.INT_TYPE, true, 0, 0, true);
		multipleLinkStyleFieldEditor.autoStorage = true;
		addField(multipleLinkStyleFieldEditor);
		{
			Combo multipleLinkStyleCombo = multipleLinkStyleFieldEditor.getComboControl();
			multipleLinkStyleCombo.add(Messages.DeployCoreMainPreferencePage_Consolidated_);
			multipleLinkStyleCombo.add(Messages.DeployCoreMainPreferencePage_Fanned_);
		}

		// how to display groups-- as a collection of shapes or as a tree
		groupStyleFieldEditor = new ComboFieldEditor(IDeployPreferences.PREF_GROUP_STYLE,
				Messages.DeployCoreMainPreferencePage_Create_groups_as_, composite,
				ComboFieldEditor.INT_TYPE, true, 0, 0, true);
		groupStyleFieldEditor.autoStorage = true;
		addField(groupStyleFieldEditor);
		{
			Combo groupStyleCombo = groupStyleFieldEditor.getComboControl();
			groupStyleCombo.add(Messages.DeployCoreMainPreferencePage_Tree_);
			groupStyleCombo.add(Messages.DeployCoreMainPreferencePage_Shape_compartmen_);
		}

		// how to snap shapes-- centered or rectangular
		snapStyleFieldEditor = new ComboFieldEditor(IDeployPreferences.PREF_SNAP_STYLE,
				Messages.DeployCoreMainPreferencePage_Alignment_of_snapped_shapes_, composite,
				ComboFieldEditor.INT_TYPE, true, 0, 0, true);
		snapStyleFieldEditor.autoStorage = true;
		addField(snapStyleFieldEditor);
		{
			Combo snapStyleCombo = snapStyleFieldEditor.getComboControl();
			snapStyleCombo.add(Messages.DeployCoreMainPreferencePage_Centered_);
			snapStyleCombo.add(Messages.DeployCoreMainPreferencePage_Justified_);
		}

		// whether to disable selection fading
		selectionFading = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING,
				Messages.DISABLE_SELECTION_FADING, composite);
		addField(selectionFading);

		// whether to disable offscreen link labels
		offscreenLinkLabels = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_DISABLE_LINK_LABELS,
				Messages.DISABLE_OFFSCREEN_LINKS, composite);
		addField(offscreenLinkLabels);

		// whether to open a quickfix results dialog
		quickfixResultsDialog = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_ENABLE_QUICKFIX_RESULTS_DIALOG,
				Messages.ENABLE_QUICKFIX_RESULTS_DIALOG, composite);
		addField(quickfixResultsDialog);

		Group filterGroup = new Group(parent, SWT.NONE);
		gridLayout = new GridLayout(2, false);
		filterGroup.setLayout(gridLayout);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		filterGroup.setLayoutData(gridData);
		filterGroup.setText(Messages.DeployCoreMainPreferencePage_7);
		composite = new Composite(filterGroup, SWT.NONE);

		// whether to filter secondary duplicate links
		filterSecondaryDupLinks = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS,
				Messages.DeployCoreMainPreferencePage_Filter_secondary_duplicate_link_, composite);
		addField(filterSecondaryDupLinks);

		// whether to filter duplicate view indicators x(x)
		filterDupViewIndicators = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS,
				Messages.DeployCoreMainPreferencePage_Filter_duplicate_view_counters_ex_, composite);
		addField(filterDupViewIndicators);

		// whether to filter private units from diagram trees
		filterDiagramContracts = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_FILTER_DIAGRAM_CONTRACTS,
				Messages.DeployCoreMainPreferencePage_Filter_figures_that_contain_diagram_, composite);
		addField(filterDiagramContracts);

		// whether to filter attributes
		filterAttributes = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES,
				Messages.DeployCoreMainPreferencePage_2, composite);
		addField(filterAttributes);

		// whether to filter nubs
		filterNubs = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_FILTER_NUBS,
				Messages.DeployCoreMainPreferencePage_3, composite);
		addField(filterNubs);

		// whether to filter contracts
		filterContracts = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_FILTER_CONTRACTS,
				Messages.DeployCoreMainPreferencePage_0, composite);
		addField(filterContracts);

		// whether to filter typenames
		filterTypeNames = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES,
				Messages.DeployCoreMainPreferencePage_1, composite);
		addField(filterTypeNames);

		// whether to filter error markers
		filterErrorMarkers = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS,
				Messages.DeployCoreMainPreferencePage_Hide_Error_Marker_, composite);
		addField(filterErrorMarkers);

		// whether to filter warning markers
		filterWarningMarkers = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS,
				Messages.DeployCoreMainPreferencePage_Hide_warning_validation_statuse_, composite);
		addField(filterWarningMarkers);

		// whether to filter informational markers
		filterInfoMarkers = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS,
				Messages.DeployCoreMainPreferencePage_Hide_informational_validation_statu_, composite);
		addField(filterInfoMarkers);

		Group dependencyLinkGroup = new Group(parent, SWT.NONE);
		gridLayout = new GridLayout(2, false);
		dependencyLinkGroup.setLayout(gridLayout);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		dependencyLinkGroup.setLayoutData(gridData);
		dependencyLinkGroup.setText(Messages.DeployCoreMainPreferencePage_8);
		composite = new Composite(dependencyLinkGroup, SWT.NONE);

		// whether to create dependency link if there's just one 100% match
		dlcdAutoCreateLink = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_DLCD_AUTO_CREATE_LINK,
				Messages.DeployCoreMainPreferencePage_4, composite);
		addField(dlcdAutoCreateLink);

		// whether to allow match creation thru the dependency link dialog
		dlcpAllowMatchCreate = new CheckBoxFieldEditor(
				IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION,
				Messages.DeployCoreMainPreferencePage_5, composite);
		addField(dlcpAllowMatchCreate);

		// whether to filter 0% matches from dependency link dialog
		dlcpFilter0Matches = new CheckBoxFieldEditor(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES,
				Messages.DeployCoreMainPreferencePage_6, composite);
		addField(dlcpFilter0Matches);
	}

	protected void addLocationUsageField(Composite composite) {
		// whether to disable location binding
		locationBindingUsage = new CheckBoxFieldEditor(IDeployPreferences.LOCATION_BINDING_USAGE,
				Messages.USE_LOCATION_BINDING, composite);
		addField(locationBindingUsage);
		locationBindingUsage.setEnabled(canChange, composite);
	}

	/**
	 * Initializes the default preference values for this preference store.
	 * 
	 * @param preferenceStore
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(IDeployPreferences.OPEN_DEPLOY_PERSPECTIVE,
				Messages.DeployCoreMainPreferencePage_promp_);
		preferenceStore.setDefault(IDeployPreferences.HOSTING_LINK_ROUTING, ""); //$NON-NLS-1$
		preferenceStore.setDefault(IPreferenceConstants.PREF_LINE_STYLE, ""); //$NON-NLS-1$
		preferenceStore.setDefault(IDeployPreferences.PREF_GROUP_STYLE,
				Messages.DeployCoreMainPreferencePage_Tree_);
		preferenceStore.setDefault(IDeployPreferences.PREF_SNAP_STYLE,
				Messages.DeployCoreMainPreferencePage_Centered_);
		preferenceStore.setDefault(IDeployPreferences.PREF_MULTIPLE_LINKS_STYLE,
				Messages.DeployCoreMainPreferencePage_Consolidated_);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_ENABLE_QUICKFIX_RESULTS_DIALOG, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS, true);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS, true);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_NUBS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_CONTRACTS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_FILTER_DIAGRAM_CONTRACTS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DLCD_AUTO_CREATE_LINK, false);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION, true);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES, true);

		// (not visible in preference page)
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DELETE_DIAGRAM_REMINDER,
				Messages.DeployCoreMainPreferencePage_promp_);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DELETE_LINK_REMINDER,
				Messages.DeployCoreMainPreferencePage_promp_);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_DELETE_CONTAINED_REMINDER,
				Messages.DeployCoreMainPreferencePage_promp_);
		preferenceStore.setDefault(IDeployPreferences.DEPLOY_REUSE_EXISTING_INSTANCES,
				Messages.DeployCoreMainPreferencePage_promp_);

		//This will be read via extension when environment context extension is available
		/*
		 * preferenceStore.setDefault(IDeployPreferences.LOCATION_BINDING_USAGE,
		 * LocationBindingService.LOCATION_BINDING_USAGE_DEFAULT);
		 */
	}

	protected void initHelp() {
		//setPageHelpContextId(...);
		//do nothing, no context help for modeler yet
	}

	/**
	 * Creates a new instance and initializes the preference store.
	 */
	public DeployCoreMainPreferencePage() {
		super();
		setPreferenceStore(DeployCoreUIPlugin.getDefault().getPreferenceStore());
	}

	/**
	 * The field editor preference page implementation of this <code>IPreferencePage</code> (and
	 * <code>IPropertyChangeListener</code>) method intercepts <code>IS_VALID</code> events but
	 * passes other events on to its superclass.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		// DO NOT enforce decisions until user presses OK.
		//        if (event.getSource() == locationBindingUsage) {    
		//            boolean newValue = ((Boolean) event.getNewValue()).booleanValue();
		//            LocationBindingService.INSTANCE.setLocationBindingUsage(newValue);
		//        }else if(event.getSource() == environmentContext) { 
		//            String newValue = (String) event.getNewValue();
		//            LocationBindingService.INSTANCE.setEnvironmentContext(newValue);
		//        }
	}

	private boolean canChange() {
		boolean canChange = true;
		//check whether there is an editor active. If there is then prompt to close editors.
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < windows.length && canChange; i++) {
			IWorkbenchPage[] pages = windows[i].getPages();
			for (int j = 0; j < pages.length && canChange; j++) {
				IEditorReference[] editorRefs = pages[j].getEditorReferences();
				for (int k = 0; k < editorRefs.length && canChange; k++) {
					if (editorRefs[k].getId().equals(DeployCoreUIPlugin.EDITOR_ID)) {
						canChange = false;
					}
				}
			}
		}
		return canChange;
	}

	/**
	 * The field editor preference page implementation of a <code>PreferencePage</code> method
	 * loads all the field editors with their default values.
	 */
	protected void performDefaults() {
		super.performDefaults();
		setProperties();
	}

	/**
	 * The field editor preference page implementation of this <code>PreferencePage</code> method
	 * saves all field editors by calling <code>FieldEditor.store</code>. Note that this method
	 * does not save the preference store itself; it just stores the values back into the preference
	 * store.
	 * 
	 * @see FieldEditor#store()
	 */
	public boolean performOk() {
		setProperties();
		return super.performOk();
	}

	protected void setProperties() {
		/*
		 * LocationBindingService.INSTANCE.setLocationBindingUsage(locationBindingUsage
		 * .getBooleanValue());
		 */
	}

}
