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

/**
 * Defines preference constants for presentation plugin.
 * 
 * @author jswanke
 * 
 */
public interface IDeployPreferences {

	/**
	 * whether to auto open deploy perspective; shows up in DeployToolMainPreferencePage
	 */
	public static final String OPEN_DEPLOY_PERSPECTIVE = "DiagramCreationPreference.open_deploy_perspective_on_model_creation"; //$NON-NLS-1$

	/**
	 * How to draw hosting -- three horizontal or vertical lines by default
	 */
	public static final String HOSTING_LINK_ROUTING = "DiagramPreference.hosting_link_routing_style"; //$NON-NLS-1$

	/**
	 * whether to draw multiple links between two units consolidated or fanned
	 */
	public static final String PREF_MULTIPLE_LINKS_STYLE = "DiagramPreference.multiple_link_style"; //$NON-NLS-1$

	/**
	 * whther to fade other figures when selecting figures in editor
	 */
	public static final String DEPLOY_DISABLE_SELECTION_FADING = "DiagramPreference.disable_selection_fading"; //$NON-NLS-1$

	/**
	 * whether to display a group as a collection of shapes or a tree
	 */
	public static final String PREF_GROUP_STYLE = "DiagramPreference.group_style"; //$NON-NLS-1$

	/**
	 * whether to align snapped shapes centered or rectangular
	 */
	public static final String PREF_SNAP_STYLE = "DiagramPreference.snap_style"; //$NON-NLS-1$

	/**
	 * whther to show link labels on links that go offscreen
	 */
	public static final String DEPLOY_DISABLE_LINK_LABELS = "DiagramPreference.disable_link_labels"; //$NON-NLS-1$
	/**
	 * used to transition canvas to all unfaded
	 */
	public static final String DEPLOY_DISABLE_SELECTION_FADING_TRANSISTION = "DiagramPreference.disable_selection_fading_transit"; //$NON-NLS-1$;

	/**
	 * Indicate the location binding usage
	 */
	public static final String LOCATION_BINDING_USAGE = "TopologyPreference.LOCATION_BINDING_USAGE"; //$NON-NLS-1$;
	/**
	 * Indicate the location binding usage
	 */
	public static final String ENVIRONMENT_CONTEXT = "TopologyPreference.ENVIRONMENT_CONTEXT"; //$NON-NLS-1$;
	/**
	 * enable quickfix results dialog
	 */
	public static final String DEPLOY_ENABLE_QUICKFIX_RESULTS_DIALOG = "DiagramPreference.enable_quickfix_results_dialog"; //$NON-NLS-1$;

	/**
	 * filter secondary duplicate links
	 */
	public static final String DEPLOY_FILTER_SECONDARY_DUP_LINKS = "DiagramPreference.filter_secondary_dup_links"; //$NON-NLS-1$

	/**
	 * filter duplicate link indicators (ex: 1(2))
	 */
	public static final String DEPLOY_FILTER_DUP_VIEW_INDICATORS = "DiagramPreference.filter_dup_view_indicators"; //$NON-NLS-1$

	/**
	 * tell user that delete from diagram does not delete from model
	 */
	public static final String DEPLOY_DELETE_DIAGRAM_REMINDER = "DiagramPreference.delete_diagram_reminder"; //$NON-NLS-1$
	/**
	 * tell user that deleting links always deletes from model
	 */
	public static final String DEPLOY_DELETE_LINK_REMINDER = "DiagramPreference.delete_link_reminder"; //$NON-NLS-1$
	/**
	 * tell user that deleting links always deletes from model
	 */
	public static final String DEPLOY_DELETE_CONTAINED_REMINDER = "DiagramPreference.delete_contained_reminder"; //$NON-NLS-1$
	/**
	 * filter contract decorator
	 */
	public static final String DEPLOY_FILTER_CONTRACTS = "DiagramPreference.filter_contracts"; //$NON-NLS-1$
	/**
	 * filter type names
	 */
	public static final String DEPLOY_FILTER_TYPE_NAMES = "DiagramPreference.filter_type_names"; //$NON-NLS-1$

	/**
	 * filter figure nubs
	 */

	public static final String DEPLOY_FILTER_NUBS = "DiagramPreference.filter_nubs"; //$NON-NLS-1$

	/**
	 * filter attributes
	 */
	public static final String DEPLOY_FILTER_ATTRIBUTES = "DiagramPreference.filter_attributes"; //$NON-NLS-1$

	/**
	 * filter private units from diagram nodes
	 */
	public static final String DEPLOY_FILTER_DIAGRAM_CONTRACTS = "DiagramPreference.filter_diagram_contracts"; //$NON-NLS-1$
	/**
	 * hide error markers
	 */
	public static final String DEPLOY_HIDE_ERROR_MARKERS = "DiagramPreference.hide_error_markers";//$NON-NLS-1$
	/**
	 * hide warning markers
	 */
	public static final String DEPLOY_HIDE_WARNING_MARKERS = "DiagramPreference.hide_warning_markers";//$NON-NLS-1$
	/**
	 * hide informational markers
	 */
	public static final String DEPLOY_HIDE_INFO_MARKERS = "DiagramPreference.hide_info_markers";//$NON-NLS-1$
	/**
	 * Reuse existing instances from current topology
	 */
	public static final String DEPLOY_REUSE_EXISTING_INSTANCES = "TopologyPreference.REUSE_EXISTING_INSTANCES_PREFERENCE";//$NON-NLS-1$
	/**
	 * for dependency link creation dialog: create a link when there's just one 100% match
	 */
	public static final String DEPLOY_DLCD_AUTO_CREATE_LINK = "TopologyPreference.DEPLOY_DLCD_AUTO_CREATE_LINK";//$NON-NLS-1$
	/**
	 * for dependency link creation dialog: allow matches to be created by dialog
	 */
	public static final String DEPLOY_DLCP_ALLOW_MATCH_CREATION = "TopologyPreference.DEPLOY_DLCP_ALLOW_MATCH_CREATION";//$NON-NLS-1$
	/**
	 * for dependency link creation dialog: filter 0% matches
	 */
	public static final String DEPLOY_DLCP_FILTER_0_MATCHES = "TopologyPreference.DEPLOY_DLCP_FILTER_0_MATCHES";//$NON-NLS-1$

}
