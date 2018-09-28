/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @since 1.0
 * 
 */
public class HostingLinkConnection extends DeployLinkConnection {

	/**
	 * @param connectionEP
	 */
	public HostingLinkConnection(DeployConnectionNodeEditPart connectionEP) {
		super(connectionEP, FULL_JOG_LENGTH);
	}

	protected void outlineShape(Graphics g) {
		PointList ptList = getPoints();
		if (ptList != null) {
			clipParentClientArea(g);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(3));
			g.setAlpha(isFaded() ? DeployCoreConstants.SELECTION_FADE : 255);
			g.drawPolyline(ptList);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
			// set inner color
			Color innerClr = DeployColorConstants.hostingLinkInner;
			Color rgb = g.getForegroundColor();
			if (isBringToFront()) {
				if (rgb == DeployColorConstants.selectedOuter) {
					innerClr = DeployColorConstants.selectedInner;
				} else {
					innerClr = DeployColorConstants.associatedInner;
				}
			}
			g.setForegroundColor(innerClr);
			g.drawPolyline(ptList);

			g.setForegroundColor(rgb);
			// draw the link label
			paintCaptions(ptList, g);

			if (!isBackfillMode()) {
				updateConnectionLabel(ptList);
				updateConnectionLayer(ptList);
			}
		}
	}

	@Override
	protected String getToolTipMessage(DeployModelObject linkDmo, DeployModelObject srcDmo,
			String srcDup, DeployModelObject tgtDmo, String tgtDup) {
		String linkName = PropertyUtils.getDmoName(linkDmo);
		String srcName = PropertyUtils.getDmoName(srcDmo) + srcDup;
		String tgtName = PropertyUtils.getDmoName(tgtDmo) + tgtDup;
		return NLS.bind(Messages.LINK_TOOLTIP, new Object[] {
				(linkDmo instanceof HostingLink ? Messages.HOSTINGLINK_CATEGORY
						: Messages.DEFERREDHOSTINGLINK_CATEGORY), linkName, srcName, tgtName });
	}

}
