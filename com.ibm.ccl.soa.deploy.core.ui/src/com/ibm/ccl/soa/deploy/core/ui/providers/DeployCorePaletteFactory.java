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

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;

import com.ibm.ccl.soa.deploy.core.ui.tools.ConstraintLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.DependencyLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.HostingLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.RealizationLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.TopologyZoomTool;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * A palette factory for Deploy Tools Entries
 * 
 * This is the default factory for palette contribution to Deploy Core editor. Clients should define
 * their palette entries using the GMF extension point and use this factory. If clients want to
 * define their own factory, then can.
 * 
 * @author manishb
 */
public class DeployCorePaletteFactory extends PaletteFactory.Adapter {
	/*
	 * In order to have DeployCorePaletteFactory process palette creation, the palette entry should
	 * be defined with id in the format deploy.<element id>.
	 */
	private static final String TOPOLOGY_ZOOM_IN_TOOL = "topologyZoomToolIn"; //$NON-NLS-1$
	private static final String TOPOLOGY_ZOOM_OUT_TOOL = "topologyZoomToolOut"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rational.xtools.gef.ui.palette.PaletteFactory#createTool(java.lang.String)
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(TOPOLOGY_ZOOM_IN_TOOL)) {
			return new TopologyZoomTool(true);
		} else if (toolId.equals(TOPOLOGY_ZOOM_OUT_TOOL)) {
			return new TopologyZoomTool(false);
		} else if (toolId.equals(DeployCoreConstants.TOOL_DEPENDENCYLINK)) {
			return new DependencyLinkCreationTool(DeploySemanticType.DEPENDENCYLINK);
		} else if (toolId.equals(DeployCoreConstants.TOOL_HOSTINGLINK)) {
			return new HostingLinkCreationTool(DeploySemanticType.HOSTINGLINK);
		} else if (toolId.equals(DeployCoreConstants.TOOL_REALIZATIONLINK)) {
			return new RealizationLinkCreationTool(DeploySemanticType.REALIZATIONLINK);
		} else if (toolId.equals(DeployCoreConstants.TOOL_CONSTRAINTLINK)) {
			return new ConstraintLinkCreationTool(DeploySemanticType.CONSTRAINTLINK);
		}
		return null;
	}
}
