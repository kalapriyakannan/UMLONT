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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @since 1.0
 * 
 */
public class CreateMemberOrHostingLinkCommand extends DeployTransactionalCommand {

	protected CreateViewRequest.ViewDescriptor _viewDescriptor = null;
	protected Unit _unit = null;
	protected View _view = null;
	protected View _containerView = null;

	/**
	 * @param editingDomain
	 * @param viewDescriptor
	 * @param containerView
	 */
	public CreateMemberOrHostingLinkCommand(TransactionalEditingDomain editingDomain,
			CreateViewRequest.ViewDescriptor viewDescriptor, View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label,
				getAllWorkspaceFiles(containerView));

		_viewDescriptor = viewDescriptor;
		_containerView = containerView;
		_view = null;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * @param editingDomain
	 * @param unit
	 * @param containerView
	 */
	public CreateMemberOrHostingLinkCommand(TransactionalEditingDomain editingDomain, Unit unit,
			View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));

		_unit = unit;
		_containerView = containerView;
		_view = null;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(unit));
	}

	/**
	 * @param editingDomain
	 * @param view
	 * @param containerView
	 */
	public CreateMemberOrHostingLinkCommand(TransactionalEditingDomain editingDomain, View view,
			View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));

		_viewDescriptor = null;
		_containerView = containerView;
		_view = view;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(view));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		try {
			Unit unit1 = (Unit) ViewUtil.resolveSemanticElement(_containerView);

			// get created view from descriptor
			View view = null;
			Unit unit2 = _unit;
			if (unit2 == null) {
				if (_viewDescriptor != null) {
					unit2 = (Unit) ((EObjectAdapter) _viewDescriptor.getElementAdapter())
							.getRealObject();
					view = (View) _viewDescriptor.getAdapter(NodeImpl.class);
				} else if (_view != null) {
					unit2 = (Unit) ViewUtil.resolveSemanticElement(_view);
					view = _view;
				}
			}
			if (unit2 != null) {
				// if just filtered from container, unfilter it
				if (com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.filterSemanticElement(_containerView,
						unit2, false)) {
					return CommandResult.newOKCommandResult(null);
				} else {
					// else create the link
					DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

					// try creating a member link first
					if (dvs.canCreateLink(unit1, unit2, LinkType.MEMBER_SET).isOK()) {
						LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
						if (hld.length > 0) {
							return CommandResult.newOKCommandResult(hld[0].create());
						}
					}
					// then try creating a hosting link
					if (dvs.canCreateLink(unit1, unit2, LinkType.HOSTING_SET).isOK()) {
						LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.HOSTING_SET);
						if (hld.length > 0) {
							// created hosting link-- view is contained in host
							if (view != null) {
								ContainmentStateUtils.setContainedUnitState(view, true);
							}
							return CommandResult.newOKCommandResult(hld[0].create());
						}
					}
				}
			}
		} catch (Exception e) {
		}
		return CommandResult.newErrorCommandResult(Messages.CANT_GROUP_MESSAGE);
	}

	public boolean canExecute() {
		Unit unit1 = (Unit) ViewUtil.resolveSemanticElement(_containerView);
		Unit unit2 = _unit;
		if (unit2 == null) {
			if (_viewDescriptor != null) {
				unit2 = (Unit) ((EObjectAdapter) _viewDescriptor.getElementAdapter()).getRealObject();
			} else if (_view != null) {
				unit2 = (Unit) ViewUtil.resolveSemanticElement(_view);
			}
		}
		if (unit2 != null) {
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

			// try creating a member link first
			if (dvs.canCreateLink(unit1, unit2, LinkType.MEMBER_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.MEMBER_SET);
				if (hld.length > 0) {
					return true;
				}
			}
			// then try creating a hosting link
			if (dvs.canCreateLink(unit1, unit2, LinkType.HOSTING_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, LinkType.HOSTING_SET);
				if (hld.length > 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param targetEP
	 * @param location
	 * @return location translated by parent container
	 */
	static public Point getLocation(IGraphicalEditPart targetEP, Point location) {
		Point pt = location != null ? new Point(location) : new Point(50, 50);

		// if user dropped on a user group compartment, get command from compartment
		if (targetEP instanceof HybridShapesCompartmentEditPart) {
			Point parentPt = targetEP.getFigure().getBounds().getTopLeft();
			pt.translate(parentPt.getNegated());
			if (pt.x < 0) {
				pt.x = 10;
			}
			if (pt.y < 0) {
				pt.y = 10;
			}
			// if this compartment isn't expanded, we need to account for shapes header size
			if (!GMFUtils.isShapesExpanded(targetEP.getParent())) {
				pt.x += 10;
				pt.y += 30;
			}
			location = pt;
		}
		if (DeployShapeNodeEditPart.isShapesMode(targetEP)) {
			Point parentPt = targetEP.getFigure().getBounds().getTopLeft();
			pt.translate(parentPt.getNegated());
			pt.x += 10;
			pt.y += 30;
			location = pt;
		}
		return location;
	}

	/**
	 * @param editingDomain
	 * @param targetEP
	 * @param rootViewList
	 */
	static public void createLinks(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<View> rootViewList) {
		// if user dropped on a user group compartment, get command from compartment
		boolean addMemberOrHostingLink = false;
		boolean shouldExpand = false;
		EditPart editPart = GMFUtils.getDeployDiagramEditPart(targetEP);
		if (targetEP instanceof HybridShapesCompartmentEditPart) {
			shouldExpand = true;
			addMemberOrHostingLink = true;
			editPart = targetEP;
		}
		if (targetEP instanceof HybridListCompartmentEditPart) {
			shouldExpand = true;
			addMemberOrHostingLink = true;
			editPart = targetEP;
		}
		if (DeployShapeNodeEditPart.isShapesMode(targetEP)) {
			addMemberOrHostingLink = true;
			shouldExpand = true;
			editPart = targetEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		}
		if (DeployShapeNodeEditPart.isTreeMode(targetEP)) {
			addMemberOrHostingLink = true;
			shouldExpand = true;
			editPart = targetEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		// if user dropped on an import, get command from compartment
		if (targetEP instanceof ImportListCompartmentEditPart) {
			shouldExpand = true;
			editPart = targetEP;
		}
		if (targetEP instanceof ImportTopologyEditPart) {
			shouldExpand = true;
			editPart = targetEP
					.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		}

		Unit targetUnit = null;
		if (targetEP.resolveSemanticElement() instanceof Unit) {
			targetUnit = (Unit) targetEP.resolveSemanticElement();
		}
		if (addMemberOrHostingLink) {
			CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain,
					DiagramUIMessages.AddCommand_Label);
			for (View view : rootViewList) {

				// if there already isn't a link, create one now
				if (targetUnit != null) {
					EObject eo = ViewUtil.resolveSemanticElement(view);
					if (GMFUtils.isHosteeOf(eo, targetUnit) || GMFUtils.isMemberOf(eo, targetUnit)) {
						continue;
					}
				}

				cc.add(new CreateMemberOrHostingLinkCommand(editingDomain, view, (View) editPart
						.getParent().getModel()));
				if (shouldExpand) {
					CollapseCommand expandCommand = new CollapseCommand(editingDomain,
							(IGraphicalEditPart) editPart, false);
					cc.compose(expandCommand);
				}
			}
			if (cc.canExecute()) {
				try {
					cc.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
