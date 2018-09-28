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
import org.eclipse.swt.SWT;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.decorators.RealizationLinkDecoration;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.RealizationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.RealizationLinkViewFactory;

/**
 * Figure for {@link RealizationLink}.
 * 
 * @see RealizationLinkEditPart
 * @see RealizationLink
 * @see RealizationLinkDecoration
 * @see RealizationLinkViewFactory
 */
public class RealizationLinkConnection extends DeployLinkConnection {

	/**
	 * @param connectionEP
	 */
	public RealizationLinkConnection(DeployConnectionNodeEditPart connectionEP) {
		super(connectionEP, FULL_JOG_LENGTH);
	}

	/**
	 * This method actually draws the line (but not the arrowheads/anchors at the ends. Those are set
	 * up somewhere in {@link SelectionUtils}, sometimes -- but not always -- using a
	 * {@link DeployCustomDecoration}.
	 */
	protected void outlineShape(Graphics g) {
		PointList ptList = getPoints();
		if (ptList != null) {
			clipParentClientArea(g);
			if (isFaded()) {
				g.setAlpha(DeployCoreConstants.SELECTION_FADE);
			}
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] { 7, 3 });
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
			g.drawPolyline(ptList);

			// draw the link label
			paintCaptions(ptList, g);

			if (!isBackfillMode()) {
				updateConnectionLabel(ptList);
				updateConnectionLayer(ptList);
			}
		}
	}

	protected String getToolTipMessage(DeployModelObject linkDmo, DeployModelObject srcDmo,
			String srcDup, DeployModelObject tgtDmo, String tgtDup) {
		String linkName = PropertyUtils.getDmoName(linkDmo);
		String srcName = PropertyUtils.getDmoName(srcDmo) + srcDup;
		String tgtName = PropertyUtils.getDmoName(tgtDmo) + tgtDup;
		return NLS.bind(Messages.LINK_TOOLTIP, new Object[] { Messages.REALIZATIONLINK_CATEGORY,
				linkName, srcName, tgtName });
	}

} // end class RealizationLinkConnection
