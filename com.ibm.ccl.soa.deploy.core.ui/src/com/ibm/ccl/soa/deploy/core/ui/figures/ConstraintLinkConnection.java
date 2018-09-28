/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

/**
 * Draw2D connection for {@link ConstraintLink}.
 * <p>
 * Customizes the dependency link connection with line shape
 */
public class ConstraintLinkConnection extends DependencyLinkConnection {

	/**
	 * Construct a logical link connection.
	 * 
	 * @param connectionEP
	 *           the deploy connection edit part.
	 */
	public ConstraintLinkConnection(DeployConnectionNodeEditPart connectionEP) {
		super(connectionEP);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.figures.DependencyLinkConnection#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	protected void outlineShape(Graphics g) {
		PointList ptList = getPoints();
		if (ptList != null) {
			clipParentClientArea(g);
			if (isFaded()) {
				g.setAlpha(DeployCoreConstants.SELECTION_FADE);
			}
			Color rgb = g.getForegroundColor();
			boolean isSelected = rgb.equals(DeployColorConstants.selectedOuter)
					|| rgb.equals(DeployColorConstants.associatedOuter);

			// set color based on constraint type
			if (!isSelected) {
				setConstraintColor(g);
			}

			// draw the link
			//g.setLineWidth(isSelected ? 2 : 1);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
			if (_isBorderLine) {
				setBorderLineProperties(g);
			}
			g.drawPolyline(ptList);

			// draw the link label
			paintCaptions(ptList, g);

			// if constraint was selected we overlay the contraint color now if it's different
			if (isSelected && setConstraintColor(g)) {
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] { 3, 5 });
				g.drawPolyline(ptList);
				g.setForegroundColor(rgb);
			}

			if (!isBackfillMode()) {
				updateConnectionLabel(ptList);
				updateConnectionLayer(ptList);
			}
		}
	}

	private boolean setConstraintColor(Graphics g) {
		if (isCollocation((DeployConnectionNodeEditPart) getConnectionEP())) {
			g.setForegroundColor(ColorConstants.darkGreen);
			return true;
		} else if (isAnticollocation((DeployConnectionNodeEditPart) getConnectionEP())) {
			g.setForegroundColor(ColorConstants.red);
			return true;
		}
		return false;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.figures.DependencyLinkConnection#getToolTipMessage(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	@Override
	protected String getToolTipMessage(DeployModelObject linkDmo, DeployModelObject srcDmo,
			String srcDup, DeployModelObject tgtDmo, String tgtDup) {
		if (!(linkDmo instanceof ConstraintLink) || linkDmo.getConstraints().size() != 1) {
			return super.getToolTipMessage(linkDmo, srcDmo, srcDup, tgtDmo, tgtDup);
		}
		Constraint c = (Constraint) linkDmo.getConstraints().get(0);
		String message = ConstraintService.INSTANCE.title(c);
		if (message == null || message.trim().length() == 0) {
			return super.getToolTipMessage(linkDmo, srcDmo, srcDup, tgtDmo, tgtDup);
		}
		String linkName = PropertyUtils.getDmoName(linkDmo);
		String srcName = PropertyUtils.getDmoName(srcDmo) + srcDup;
		String tgtName = PropertyUtils.getDmoName(tgtDmo) + tgtDup;
		return DeployNLS.bind(Messages.CONSTRAINTLINK_TOOLTIP, new Object[] { message, linkName,
				srcName, tgtName });
	}

	/**
	 * Check if the edit part models a {@link ConstraintLink} and return the link if found.
	 * 
	 * @param connectionEP
	 *           the edit part representing the connection.
	 * @return the logical link represented by the connection, or null if not found.
	 */
	public static ConstraintLink getConstraintLink(DeployConnectionNodeEditPart connectionEP) {
		if (connectionEP == null) {
			return null;
		}
		if (connectionEP.getNotationView() == null) {
			return null;
		}
		EObject object = connectionEP.getNotationView().getElement();
		if (object instanceof ConstraintLink) {
			return (ConstraintLink) object;
		}
		return null;
	}

	/**
	 * Checks if the connection is a logical link with a collocation constraint of type collocate.
	 * 
	 * @param connectionEP
	 *           the edit part representing the connection.
	 * 
	 * @return true if the logical link contains a single {@link CollocationConstraint} with
	 *         {@link CollocationConstraint#getType()} equal to
	 *         {@link CollocationConstraintTypes#COLLOCATION}.
	 */
	public static boolean isCollocation(DeployConnectionNodeEditPart connectionEP) {
		ConstraintLink link = getConstraintLink(connectionEP);
		if (link == null || link.getConstraints().size() != 1) {
			return false;
		}
		if (!(link.getConstraints().get(0) instanceof CollocationConstraint)) {
			return false;
		}
		CollocationConstraint cc = (CollocationConstraint) link.getConstraints().get(0);
		return cc.getType() == CollocationConstraintTypes.COLLOCATION_LITERAL;
	}

	/**
	 * Checks if the connection is a logical link with a collocation constraint of type
	 * anticollocate.
	 * 
	 * @param connectionEP
	 *           the edit part representing the connection.
	 * 
	 * @return true if the logical link contains a single {@link CollocationConstraint} with
	 *         {@link CollocationConstraint#getType()} equal to
	 *         {@link CollocationConstraintTypes#ANTICOLLOCATION}.
	 */
	public static boolean isAnticollocation(DeployConnectionNodeEditPart connectionEP) {
		ConstraintLink link = getConstraintLink(connectionEP);
		if (link == null || link.getConstraints().size() != 1) {
			return false;
		}
		if (!(link.getConstraints().get(0) instanceof CollocationConstraint)) {
			return false;
		}
		CollocationConstraint cc = (CollocationConstraint) link.getConstraints().get(0);
		return cc.getType() == CollocationConstraintTypes.ANTICOLLOCATION_LITERAL;
	}

	/**
	 * Checks if the connection is a logical link with a deferred hosting constraint of type
	 * anticollocate.
	 * 
	 * @param connectionEP
	 *           the edit part representing the connection.
	 * 
	 * @return true if the logical link contains a single {@link DeferredHostingConstraint}.
	 */
	public static boolean isDeferredHosting(DeployConnectionNodeEditPart connectionEP) {
		ConstraintLink link = getConstraintLink(connectionEP);
		if (link == null || link.getConstraints().size() != 1) {
			return false;
		}
		return link.getConstraints().get(0) instanceof DeferredHostingConstraint;
	}
}
