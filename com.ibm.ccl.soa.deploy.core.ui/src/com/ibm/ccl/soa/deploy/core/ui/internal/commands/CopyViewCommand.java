/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;

/**
 * @since 1.0
 * 
 */
public class CopyViewCommand extends AbstractTransactionalCommand {
	private final DeployDiagramEditPart diagramEP;
	private final DeployShapeNodeEditPart toContainerEP;
	private final DeployShapeNodeEditPart fromContainerEP;
	private final DeployShapeNodeEditPart movedPart;
	private final Set<View> _containedViewSet;
	private View movedView;
	private final Unit movedUnit;
	private final Point originalPt;
	private final Rectangle rect;
	boolean isImportCopy = false;
	boolean isFromShape = false;
	boolean isToShape = false;

	/**
	 * @param editingDomain
	 * @param diagramEP --
	 *           the diagram editpart
	 * @param toContainerEP --
	 *           the destination container if any
	 * @param fromContainerEP --
	 *           the source container if any
	 * @param movedPart
	 * @param containedUnitSet
	 *           if the moved part has inner selected units
	 * @param movedView --
	 *           the view that's moving
	 * @param originalPt --
	 *           the original x,y position of the member
	 * @param rect --
	 *           the bounds of where this member is going
	 * @param containerView
	 */
	public CopyViewCommand(TransactionalEditingDomain editingDomain,
			DeployDiagramEditPart diagramEP, DeployShapeNodeEditPart toContainerEP,
			DeployShapeNodeEditPart fromContainerEP, GraphicalEditPart movedPart,
			Set<View> containedViewSet, View movedView, Point originalPt, Rectangle rect,
			View containerView) {

		super(editingDomain, "Copy View Command", getWorkspaceFiles(containerView)); //$NON-NLS-1$

		Assert.isNotNull(diagramEP);
		Assert.isNotNull(movedView);
		Assert.isNotNull(originalPt);

		this.diagramEP = diagramEP;
		this.toContainerEP = toContainerEP;
		this.fromContainerEP = fromContainerEP;
		this.movedPart = (DeployShapeNodeEditPart) movedPart;
		_containedViewSet = containedViewSet;
		this.movedView = movedView;
		movedUnit = (Unit) ViewUtil.resolveSemanticElement(movedView);
		this.originalPt = originalPt;
		this.rect = rect;
		initFlags();

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(null));
	}

	private void initFlags() {
		isImportCopy = PropertyUtils.isProxy(movedUnit);
		isToShape = toContainerEP == null
				|| toContainerEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) != null;
		isFromShape = fromContainerEP == null
				|| DeployShapeNodeEditPart.isShapesMode(fromContainerEP);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		// if view is null, see if we can find it now
		if (movedView == null) {
			List list = GMFUtils.getEditPartsFor(diagramEP, movedUnit);
			if (list.size() > 0) {
				movedView = ((DeployShapeNodeEditPart) list.get(0)).getNotationView();
			}
		}
		// if after all that, no view, give up
		if (movedView == null) {
			return CommandResult.newOKCommandResult();
		}

		// if copying into a container try creating a member or hosting link
		boolean isHostedOnToContainer = false;
		if (toContainerEP != null) {
			try {
				isHostedOnToContainer = MoveViewCommand.createHostingOrMemberLink(toContainerEP,
						movedUnit);
				for (View innerView : _containedViewSet) {
					MoveViewCommand.createHostingOrMemberLink(toContainerEP, (Unit) innerView
							.getElement());
				}
			} catch (Exception e) {
				return CommandResult.newErrorCommandResult(Messages.CANT_GROUP_MESSAGE);
			}
		}

		// make sure toContainer is expanded
		if (toContainerEP != null) {
			IGraphicalEditPart ep = toContainerEP
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (ep == null) {
				ep = toContainerEP
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			}
			if (ep != null) {
				boolean isCollapsed = ((Boolean) ViewUtil.getStructuralFeatureValue(ep
						.getNotationView(), NotationPackage.eINSTANCE.getDrawerStyle_Collapsed()))
						.booleanValue();
				if (isCollapsed) {
					ViewUtil.setStructuralFeatureValue(ep.getNotationView(), NotationPackage.eINSTANCE
							.getDrawerStyle_Collapsed(), Boolean.FALSE);
					if (isToShape) {
						rect.translate(30, 30);
					}
				}
			}
		}

		// create the new view
		Node newView = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(diagramEP,
				toContainerEP, movedView, rect.getTopLeft(), isToShape, true, true, false, null);

		// copy any inner views to container
		Point pt = rect.getTopRight().translate(100, 0);
		for (View innerView : _containedViewSet) {
			com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(diagramEP, toContainerEP, innerView,
					pt, isToShape, true, true, false, null);
			pt.translate(100, 100);
		}

		// if copying to a group, enlarge group if necessary
		if (toContainerEP != null && isToShape) {
			Point location = (Point) MapModeUtil.getMapMode().DPtoLP(rect.getTopLeft());
			location.x = ((Integer) ViewUtil.getStructuralFeatureValue(newView,
					NotationPackage.eINSTANCE.getLocation_X())).intValue();
			location.y = ((Integer) ViewUtil.getStructuralFeatureValue(newView,
					NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			Dimension size = (Dimension) MapModeUtil.getMapMode().DPtoLP(rect.getSize());
			LayoutUtils.layoutViews(getEditingDomain(), newView, location, location, size, size, null,
					false, -1);
		}

		// if new view is in diagram, mark it to prevent canonical policies from deleting it
		if (toContainerEP == null) {
			DeployStyle deployStyle = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			deployStyle.setIsDuplicateCanvasView(true);
		}

		// if copying from import, setup ref views
		if (isImportCopy) {
			com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyImportSupport(movedView, newView);
		}

		if (isFromShape) {
			// position original view where it was before we started (undo SetBoundsCommand)
			ViewUtil.setStructuralFeatureValue(movedView, NotationPackage.eINSTANCE.getLocation_X(),
					new Integer(originalPt.x));
			ViewUtil.setStructuralFeatureValue(movedView, NotationPackage.eINSTANCE.getLocation_Y(),
					new Integer(originalPt.y));
		}

		// if moved view came from the diagram mark it to prevent canonical policies from deleting it
		if (fromContainerEP == null) {
			DeployStyle deployStyle = (DeployStyle) movedView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			deployStyle.setIsDuplicateCanvasView(true);
		}

		// is hosted on to container
		if (isHostedOnToContainer) {
			ContainmentStateUtils.setContainedUnitState(newView, true);
			ShowOrNotShowUnitOnHostCommand.moveAllViewsOnOrOffHost(diagramEP, movedPart,
					toContainerEP, false, false);
		}

		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		return true;
	}

}
