/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

/**
 * This static class collects constant strings such as GMF semantic hints.
 */
public class DeployCoreConstants {
	//Supported Connections	
	public static final String TOOL_DEPENDENCYLINK = "deploy.dependencylink"; //$NON-NLS-1$
	public static final String TOOL_HOSTINGLINK = "deploy.hostinglink"; //$NON-NLS-1$
	public static final String TOOL_REALIZATIONLINK = "deploy.realizationlink"; //$NON-NLS-1$
	public static final String TOOL_CONSTRAINTLINK = "deploy.constraintlink"; //$NON-NLS-1$

	//Unit collection tool
	public static final String TOOL_UNITGROUP = "deploy.unitGroup"; //$NON-NLS-1$

	public static final String DEPLOY_CORE = "DeployCore"; //$NON-NLS-1$

	// Semantic Hints	
	public static final String DEPENDENCYLINK_SEMANTICHINT = "DependencyLink"; //$NON-NLS-1$
	public static final String HOSTINGLINK_SEMANTICHINT = "HostingLink"; //$NON-NLS-1$
	public static final String REALIZATIONLINK_SEMANTICHINT = "RealizationLink"; //$NON-NLS-1$
	public static final String CONSTRAINTLINK_SEMANTICHINT = "ConstraintLink"; //$NON-NLS-1$
	public static final String CONSOLIDATIONLINK_SEMANTICHINT = "ConsolidationLink"; //$NON-NLS-1$

	public static final String HYBRIDLIST_SEMANTICHINT = "HybridList"; //$NON-NLS-1$
	public static final String HYBRIDSHAPES_SEMANTICHINT = "HybridShapes"; //$NON-NLS-1$
	public static final String IMPORTTOPOLOGY_SEMANTICHINT = "Import"; //$NON-NLS-1$
	public static final String IMPORTTOPOLOGYLIST_SEMANTICHINT = "ImportTopologyList"; //$NON-NLS-1$
	public static final String IMPORTTOPOLOGYSHAPES_SEMANTICHINT = "ImportTopologyShapes"; //$NON-NLS-1$
	public static final String UNRESOLVEDPROXY_SEMANTICHINT = "UnresolvedProxy"; //$NON-NLS-1$

	// Diagram Semantic Hints
	public static final String DIAGRAMNODEVIEW_SEMANTICHINT = "DiagramNode"; //$NON-NLS-1$
	public static final String DIAGRAMNODELIST_SEMANTICHINT = "DiagramNodeList"; //$NON-NLS-1$
	public static final String DIAGRAMNODESHAPES_SEMANTICHINT = "DiagramNodeShapes"; //$NON-NLS-1$

	// support for domains that don't have a ui plugin
	public static final String MISSINGDOMAINUI_SEMANTICHINT = "MissingDomainUI"; //$NON-NLS-1$	

	// Snap Group Hints
	public static final String SNAPROW_SEMANTICHINT = "SnapRow"; //$NON-NLS-1$
	public static final String SNAPGROUP_SEMANTICHINT = "SnapGroup"; //$NON-NLS-1$

	/**
	 * A link that represents a connection into a filtered node.
	 * 
	 * @deprecated
	 */
	public static final String FILTERSURROGATELINK_SEMANTICHINT = "FilterSurrogateLink"; //$NON-NLS-1$

	/**
	 * A node acting as a hub for filter surrogate links, represents all filtered units.
	 * 
	 * @deprecated
	 */
	public static final String FILTERSURROGATEHUB_SEMANTICHINT = "FilterSurrogateHub"; //$NON-NLS-1$

	public static final String MODULE_SEMANTICHINT_PREFIX = "module."; //$NON-NLS-1$
	public static final String CONFIGURATION_SEMANTICHINT_PREFIX = "configurationUnit."; //$NON-NLS-1$
	public static final String COMPONENT_SEMANTICHINT_PREFIX = "component."; //$NON-NLS-1$
	public static final String UNIT_SEMANTICHINT_PREFIX = "unit."; //$NON-NLS-1$
	public static final String UNITGROUP_SEMANTICHINT_PREFIX = "unitGroup."; //$NON-NLS-1$

	// selection alpha fade of other figures
	public static final int SELECTION_FADE = 90;

	public final static int Q = MapModeUtil.getMapMode().DPtoLP(1);

	public static final int SERVER_UNIT_DPWIDTH = 125;
	public static final int SERVER_UNIT_DPHEIGHT = 43;

	public static final int SERVER_UNIT_WIDTH = MapModeUtil.getMapMode().DPtoLP(125);
	public static final int SERVER_UNIT_HEIGHT = MapModeUtil.getMapMode().DPtoLP(43);
	public static final int SERVER_UNIT_HEADER = MapModeUtil.getMapMode().DPtoLP(27);
	public static final int SERVER_UNIT_MARGINS = MapModeUtil.getMapMode().DPtoLP(10);
	public static final int SERVER_UNIT_COLLAPSED = MapModeUtil.getMapMode().DPtoLP(30);
	public static final int SERVER_UNIT_PAD_HEIGHT = MapModeUtil.getMapMode().DPtoLP(9);
	public static final int SERVER_UNIT_MIN_HEIGHT = MapModeUtil.getMapMode().DPtoLP(40);
	public static final int SERVER_UNIT_MIN_WIDTH = MapModeUtil.getMapMode().DPtoLP(60);
	public static final int SHAPES_UNIT_INSET = MapModeUtil.getMapMode().DPtoLP(5);
	public final static int HOSTINGLISTITEM_DPHEIGHT = 18;
	public final static int LISTITEM_INDENT = MapModeUtil.getMapMode().DPtoLP(20);

	public static final int NODE_UNIT_WIDTH = SERVER_UNIT_WIDTH;
	public static final int NODE_UNIT_HEIGHT = SERVER_UNIT_HEIGHT;

	public static final int CONCEPTUAL_NODE_WIDTH = SERVER_UNIT_WIDTH;
	public static final int CONCEPTUAL_NODE_HEIGHT = SERVER_UNIT_HEIGHT;
	public static final int CONCEPTUAL_NODE_INSET = MapModeUtil.getMapMode().DPtoLP(1);
	public static final int CONCEPTUAL_NODE_NEW_WIDTH = MapModeUtil.getMapMode().DPtoLP(250);
	public static final int CONCEPTUAL_NODE_NEW_HEIGHT = MapModeUtil.getMapMode().DPtoLP(200);

	public static final int BUSINESS_COMP_WIDTH = SERVER_UNIT_WIDTH;
	public static final int BUSINESS_COMP_HEIGHT = SERVER_UNIT_HEIGHT;
	public static final int BUSINESS_COMP_INSET = MapModeUtil.getMapMode().DPtoLP(1);
	public static final int BUSINESS_COMP_NEW_WIDTH = MapModeUtil.getMapMode().DPtoLP(250);
	public static final int BUSINESS_COMP_NEW_HEIGHT = MapModeUtil.getMapMode().DPtoLP(200);

	public static final int IMPORT_TOPOLOGY_WIDTH = SERVER_UNIT_WIDTH;
	public static final int IMPORT_TOPOLOGY_HEIGHT = MapModeUtil.getMapMode().DPtoLP(50);
	public static final int IMPORT_TOPOLOGY_INSET = MapModeUtil.getMapMode().DPtoLP(1);
	public static final int IMPORT_TOPOLOGY_NEW_WIDTH = MapModeUtil.getMapMode().DPtoLP(250);
	public static final int IMPORT_TOPOLOGY_NEW_HEIGHT = MapModeUtil.getMapMode().DPtoLP(200);

	public static final int UNIT_NEW_SHAPES_WIDTH = MapModeUtil.getMapMode().DPtoLP(250);
	public static final int UNIT_NEW_SHAPES_HEIGHT = MapModeUtil.getMapMode().DPtoLP(200);

	public static final String DEPLOY_NAME = "DeployName"; //$NON-NLS-1$
	public static final String DEPLOY_TYPE = "DeployType"; //$NON-NLS-1$

	public final static String ACTION_ARRANGE_GROUP_ALL = "arrangeGroupAllAction"; //$NON-NLS-1$

	public final static int SNAP_CENTERED = 1;
	public final static int SNAP_RECTANGULAR = 2;

}
