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

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @since 1.0
 * 
 */
public class MoveViewCommand extends AbstractTransactionalCommand {
	private final DeployDiagramEditPart diagramEP;
	private final DeployShapeNodeEditPart toContainerEP;
	private final DeployShapeNodeEditPart fromContainerEP;
	private final DeployShapeNodeEditPart movedPart;
	private final Set<View> _containedViewSet;
	private final View movedView;
	private final Unit movedUnit;
	private final Rectangle rect;
	boolean isDuplicateView;
	boolean isImportMove = false;
	boolean isFromShape = false;
	boolean isToShape = false;

	/**
	 * @param editingDomain
	 * @param diagramEP --
	 *           the diagram editpart
	 * @param toContainerEP --
	 *           the source Container if any
	 * @param fromContainerEP --
	 *           the destination Container if any
	 * @param movedPart --
	 *           the editpart that's moving
	 * @param containedUnitList
	 *           TODO
	 * @param rect --
	 *           the bounds of where this view is going
	 * @param isDuplicateView --
	 *           is moved editpart a duplicate view
	 * @param containerView
	 */
	public MoveViewCommand(TransactionalEditingDomain editingDomain,
			DeployDiagramEditPart diagramEP, DeployShapeNodeEditPart toContainerEP,
			DeployShapeNodeEditPart fromContainerEP, IGraphicalEditPart movedPart,
			Set<View> containedViewSet, Rectangle rect, boolean isDuplicateView, View containerView) {

		super(editingDomain, "Move View Command", getWorkspaceFiles(containerView)); //$NON-NLS-1$

		Assert.isNotNull(diagramEP);
		Assert.isNotNull(movedPart);
		Assert.isNotNull(containerView);

		this.diagramEP = diagramEP;
		this.toContainerEP = toContainerEP;
		isToShape = toContainerEP == null
				|| toContainerEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) != null;
		this.fromContainerEP = fromContainerEP;
		isFromShape = fromContainerEP == null
				|| fromContainerEP
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) != null;
		this.movedPart = (DeployShapeNodeEditPart) movedPart;
		_containedViewSet = containedViewSet;
		movedView = (View) movedPart.getModel();
		movedUnit = (Unit) ViewUtil.resolveSemanticElement(movedView);
		this.rect = rect;
		this.isDuplicateView = isDuplicateView;
		isImportMove = PropertyUtils.isProxy(movedUnit);

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		boolean isHostedOnToContainer = false;
		boolean isHostedOnFromContainer = false;
		// if moving into a container try creating a member or hosting link
		if (toContainerEP != null) {
			try {
				isHostedOnToContainer = createHostingOrMemberLink(toContainerEP, movedUnit);
				for (View innerView : _containedViewSet) {
					createHostingOrMemberLink(toContainerEP, (Unit) innerView.getElement());
				}
			} catch (Exception e) {
				return CommandResult.newErrorCommandResult(Messages.CANT_GROUP_MESSAGE);
			}
		}

		// if moving out of another group, delete that link
		if (fromContainerEP != null) {
			// if moving between containers that are duplicate views we should just filter the unit from the from container
			if (toContainerEP != null
					&& toContainerEP.resolveSemanticElement() == fromContainerEP
							.resolveSemanticElement()) {
				com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.filterSemanticElement(fromContainerEP,
						movedUnit, true);
			} else {
				// if from container is not an import list, delete the member link
				EObject eo = fromContainerEP.resolveSemanticElement();
				if (eo instanceof Unit) {
					Unit fromContainerUnit = (Unit) eo;
					isHostedOnFromContainer = CanonicalUtils.isHostedUnit(fromContainerEP, movedUnit,
							fromContainerUnit);
					if (!isHostedOnFromContainer) {
						Iterator it = fromContainerUnit.getMemberLinks().iterator();
						while (it.hasNext()) {
							MemberLink link = (MemberLink) it.next();
							if (DeployModelObjectUtil.isMutable(link) && movedUnit == link.getTarget()) {
								EcoreUtil.remove(link);
								break;
							}
						}
						// only delete the hosting link if they're moving to another container
						// so that hosting link will re-appear between unit and container on canvas
					} else if (toContainerEP != null || GMFUtils.isImportTopology(fromContainerEP)) {
						Iterator it = GMFUtils.getAllHostedLinks(fromContainerUnit).iterator();
						while (it.hasNext()) {
							HostingLink link = (HostingLink) it.next();
							if (DeployModelObjectUtil.isMutable(link) && movedUnit == link.getTarget()) {
								EcoreUtil.remove(link);
								break;
							}
						}
					}
				}
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

		// if moving to a group, enlarge group if necessary
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

		// if moving a duplicate view into diagram, mark it so canonical policies don't delete it
		if (toContainerEP == null) {
			DeployStyle deployStyle = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			deployStyle.setIsDuplicateCanvasView(true);
		}

		// is hosted on to container and this unit has not already been marked for containment
		if (isHostedOnToContainer && !ContainmentStateUtils.isContainedUnit(diagramEP, movedUnit)) {
			ShowOrNotShowUnitOnHostCommand.moveAllViewsOnOrOffHost(diagramEP, movedPart,
					toContainerEP, false, false);
			ContainmentStateUtils.setContainedUnitState(newView, true);
		}

		// was hosted on from container
		if (!isHostedOnToContainer && isHostedOnFromContainer) {
			ShowOrNotShowUnitOnHostCommand.moveAllViewsOnOrOffHost(diagramEP, movedPart,
					toContainerEP, true, false);
			ContainmentStateUtils.setContainedUnitState(newView, false);
		}

		// delete the old view
		ViewUtil.destroy(movedView);

		// if last item removed from an inner tree branch, collapse the tree branch
		if (!isFromShape) {
			IGraphicalEditPart ep = fromContainerEP
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (ep instanceof DeployListCompartmentEditPart
					&& ((DeployListCompartmentEditPart) ep).isInnerHostingList()
					&& ep.getNotationView().getPersistedChildren().size() == 0) {
				ViewUtil.setStructuralFeatureValue(ep.getNotationView(), NotationPackage.eINSTANCE
						.getDrawerStyle_Collapsed(), Boolean.TRUE);
			}
		}

		return CommandResult.newOKCommandResult();
	}

	public static boolean createHostingOrMemberLink(DeployShapeNodeEditPart toContainerEP,
			Unit movedUnit) {
		boolean isHostedOnToContainer = false;
		// if moving to a container, make sure to clear this element from the container's filter if its there
		if (!com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.filterSemanticElement(toContainerEP,
				movedUnit, false)) {
			// if a hosting link doesn't already exist
			Unit toContainerUnit = (Unit) toContainerEP.resolveSemanticElement();
			isHostedOnToContainer = CanonicalUtils.isHostedUnit(toContainerEP, movedUnit,
					toContainerUnit);
			if (!isHostedOnToContainer && !GMFUtils.isMemberOf(movedUnit, toContainerUnit)) {
				// try creating a member link first
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (dvs.canCreateLink(toContainerUnit, movedUnit, LinkType.MEMBER_SET).isOK()) {
					LinkDescriptor[] hld = dvs.getPossibleLinks(toContainerUnit, movedUnit,
							LinkType.MEMBER_SET);
					if (hld.length > 0) {
						hld[0].create();
					}
					// else try a hosting link
				} else if (dvs.canCreateLink(toContainerUnit, movedUnit, LinkType.HOSTING_SET).isOK()) {
					LinkDescriptor[] hld = dvs.getPossibleLinks(toContainerUnit, movedUnit,
							LinkType.HOSTING_SET);
					if (hld.length > 0) {
						hld[0].create();
					}
					isHostedOnToContainer = true;
				}
			}
		}
		return isHostedOnToContainer;
	}

	public boolean canExecute() {
		return true;
	}

}
