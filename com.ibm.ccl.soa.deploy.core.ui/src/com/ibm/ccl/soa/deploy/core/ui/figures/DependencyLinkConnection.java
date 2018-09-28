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

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DependencyLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @since 1.0
 * 
 */
public class DependencyLinkConnection extends DeployLinkConnection {
	/**
	 * @param connectionEP
	 */
	public DependencyLinkConnection(DeployConnectionNodeEditPart connectionEP) {
		super(connectionEP, FULL_JOG_LENGTH);
	}

	protected void outlineShape(Graphics g) {
		PointList ptList = getPoints();
		if (ptList != null) {
			clipParentClientArea(g);
			if (isFaded()) {
				g.setAlpha(DeployCoreConstants.SELECTION_FADE);
			}
			//g.setLineWidth(rgb.equals(DeployColorConstants.selectedOuter)
			//		|| rgb.equals(DeployColorConstants.associatedOuter) ? 2 : 1);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));

			if (_isBorderLine) {
				setBorderLineProperties(g);
			}

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
		if (getConnectionEP() instanceof DependencyLinkEditPart) {
			DependencyLink dLink = (DependencyLink) linkDmo;
			return NLS.bind(Messages.DEPENDENCYLINK_TOOLTIP, new Object[] {
					Messages.DEPENDENCYLINK_CATEGORY, linkName, srcName,
					PropertyUtils.getDmoName(dLink.getSource()), tgtName,
					PropertyUtils.getDmoName(dLink.getTarget()) });
		}
		ConstraintLink lLink = (ConstraintLink) linkDmo;
		return NLS.bind(Messages.DEPENDENCYLINK_TOOLTIP, new Object[] {
				Messages.CONSTRAINTLINK_CATEGORY, linkName, srcName,
				PropertyUtils.getDmoName(lLink.getSource()), tgtName,
				PropertyUtils.getDmoName(lLink.getTarget()) });
	}

	@Override
	public PointList getPoints() {
		_isBorderLine = false;
		PointList ptList = super.getPoints();
		if (doBorderLineLink()) {
			PointList ptList2 = getBorderLinePointList();
			if (ptList2 != null) {
				_isBorderLine = true;
				return ptList2;
			}
		}
		return ptList;
	}

}
