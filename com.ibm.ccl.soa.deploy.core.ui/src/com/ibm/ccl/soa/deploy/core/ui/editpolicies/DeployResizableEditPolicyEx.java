/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployLineBorder;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils.FadingData;

/**
 * @since 1.0
 * 
 */
public class DeployResizableEditPolicyEx extends ResizableEditPolicyEx {

	private static Image handleImg = DeployCoreUIPlugin.getImageDescriptor(
			"icons/obj16/handle_obj.gif").createImage(); //$NON-NLS-1$

	private FadingData fadingData = null;

	class DeployMoveHandle extends MoveHandle {
		/**
		 * @param owner
		 */
		public DeployMoveHandle(GraphicalEditPart owner) {
			super(owner);

			setLocator(new MoveHandleLocator(owner.getFigure()) {

				@Override
				public void relocate(IFigure target) {
					Rectangle r = getReference().getBounds().getCopy();
					getReference().translateToAbsolute(r);
					target.translateToRelative(r);
					target.setBounds(r);
				}
			});
		}

		protected void initialize() {
			setOpaque(false);
			// make width 1 when in a snap group
			int width = getOwner() instanceof DeployShapeNodeEditPart
					&& ((DeployShapeNodeEditPart) getOwner()).isInSnapGroup() ? 1 : 2;
			setBorder(new DeployLineBorder(DeployColorConstants.selectedInner,
					DeployColorConstants.selectedOuter, width, getOwner().getFigure()));
			setCursor(Cursors.SIZEALL);
		}

		// make us invisible to mouse
		public boolean containsPoint(int x, int y) {
			return false;
		}
	}

	class DeployResizeHandle extends ResizeHandle {

		/**
		 * @param owner
		 * @param direction
		 */
		public DeployResizeHandle(GraphicalEditPart owner, int direction) {
			super(owner, direction);
			setLocator(new DeployRelativeHandleLocator(owner.getFigure(), direction));
		}

		public void paintFigure(Graphics g) {
			// clip based on any containing containers
			g.setClip(GMFUtils.getClipRectangle(getOwnerFigure()).expand(5, 5));
			g.drawImage(handleImg, this.getBounds().x, this.getBounds().y);
		}
	}

	class DeployRelativeHandleLocator extends RelativeHandleLocator {
		/**
		 * @param reference
		 * @param location
		 */
		public DeployRelativeHandleLocator(IFigure reference, int location) {
			super(reference, location);
		}

		protected Rectangle getReferenceBox() {
			Rectangle r = super.getReferenceBox();
			int x = MapModeUtil.getMapMode().DPtoLP(2);
			r.expand(x, x);
			return r;
		}

	}

	// the feedback rect shows the feedback
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
	}

	protected void showSelection() {
		super.showSelection();
		fadingData = SelectionUtils.showSelectionFeedback((AbstractGraphicalEditPart) getHost());
	}

	protected void hideSelection() {
		super.hideSelection();
		AbstractGraphicalEditPart host = (AbstractGraphicalEditPart) getHost();
		if (host.getModel() instanceof NodeImpl) {
			EObject element = ((NodeImpl) host.getModel()).basicGetElement();
			if (element != null && !element.eIsProxy()) {
				SelectionUtils.hideSelectionFeedback(host);
			}
		} else {
			SelectionUtils.hideSelectionFeedback(host);
		}
		fadingData = null;
	}

	public void showFadeFeedback() {
		if (fadingData != null) {
			SelectionUtils.showFadeFeedback((AbstractGraphicalEditPart) getHost(), fadingData);
		}
	}

	protected List createSelectionHandles() {
		List list = new ArrayList();
		GraphicalEditPart part = (GraphicalEditPart) getHost();
		list.add(new DeployMoveHandle(part));
		if (!(part.getParent() instanceof DeployListCompartmentEditPart)) {
			list.add(new DeployResizeHandle(part, PositionConstants.SOUTH_EAST));
			list.add(new DeployResizeHandle(part, PositionConstants.SOUTH_WEST));
			list.add(new DeployResizeHandle(part, PositionConstants.NORTH_WEST));
			list.add(new DeployResizeHandle(part, PositionConstants.NORTH_EAST));
		}
		return list;
	}

}
