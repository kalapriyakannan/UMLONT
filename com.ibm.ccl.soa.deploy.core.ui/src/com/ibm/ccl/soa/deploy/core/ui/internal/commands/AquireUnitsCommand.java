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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.tools.common.CreationToolWithFeedback;
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
public class AquireUnitsCommand extends AbstractTransactionalCommand {

	protected CreateViewRequest.ViewDescriptor _shapesViewDescriptor = null;
	protected List<View> _overlappedViewList = null;
	protected DeployDiagramEditPart _diagramEP = null;

	/**
	 * @param editingDomain
	 * @param viewDescriptor
	 * @param overlappedList
	 * @param part
	 * @param containerView
	 */
	public AquireUnitsCommand(TransactionalEditingDomain editingDomain,
			CreateViewRequest.ViewDescriptor viewDescriptor, List<View> overlappedList, EditPart part,
			View containerView) {
		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));
		_shapesViewDescriptor = viewDescriptor;
		_overlappedViewList = overlappedList;
		_diagramEP = GMFUtils.getDeployDiagramEditPart(part);

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		try {
			// get new group's particulars from descriptor
			View containerView = (View) _shapesViewDescriptor.getAdapter(NodeImpl.class);
			Unit containerUnit = (Unit) ViewUtil.resolveSemanticElement(containerView);
			View toCompartmentView = ViewUtil.getChildBySemanticHint(containerView,
					DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);

			// for each overlapped unit
			for (View view : _overlappedViewList) {
				Unit unit = (Unit) ViewUtil.resolveSemanticElement(view);

				// create a member link between unit and group or a hosting link between a hostee and a host
				boolean isCreated = false;
				boolean isHostingCreated = false;
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (dvs.canCreateLink(containerUnit, unit, LinkType.MEMBER_SET).isOK()) {
					LinkDescriptor[] hld = dvs
							.getPossibleLinks(containerUnit, unit, LinkType.MEMBER_SET);
					if (hld.length > 0) {
						hld[0].create();
						isCreated = true;
					}
				}
				if (!isCreated) {
					if (dvs.canCreateLink(containerUnit, unit, LinkType.HOSTING_SET).isOK()) {
						LinkDescriptor[] hld = dvs.getPossibleLinks(containerUnit, unit,
								LinkType.HOSTING_SET);
						if (hld.length > 0) {
							hld[0].create();
							isCreated = isHostingCreated = true;
						}
					}
				}
				if (!isCreated) {
					return CommandResult
							.newErrorCommandResult(Messages.AquireUnitsCommand_Can_t_add_units_to_this_group_or_ho_);
				}

				Node newView = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(_diagramEP,
						toCompartmentView, view);

				// set position of new view where it was located in diagram
				int x = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
						.getLocation_X())).intValue();
				int y = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
						.getLocation_Y())).intValue();
				// if it was in a GMF group, add the group's coordinates
				if (view.eContainer() instanceof View
						&& ((View) view.eContainer()).getType().equals(ViewType.GROUP)) {
					View container = (View) view.eContainer();
					x += ((Integer) ViewUtil.getStructuralFeatureValue(container,
							NotationPackage.eINSTANCE.getLocation_X())).intValue();
					y += ((Integer) ViewUtil.getStructuralFeatureValue(container,
							NotationPackage.eINSTANCE.getLocation_Y())).intValue();

				}
				Point location = new Point(x, y);

				// adjust location for group
				Point groupLocation = CreationToolWithFeedback.getLassoBounds().getTopLeft();
				location.x -= groupLocation.x + DeployCoreConstants.SHAPES_UNIT_INSET;
				location.y -= groupLocation.y + DeployCoreConstants.SERVER_UNIT_HEADER;
				if (location.x < 0) {
					location.x = 0;
				}
				if (location.y < 0) {
					location.y = 0;
				}
				ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_X(),
						new Integer(location.x));
				ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_Y(),
						new Integer(location.y));

				// if this was a hosting link creation, mark the view as contained
				if (isHostingCreated) {
					ContainmentStateUtils.setContainedUnitState(newView, true);
				}

				// delete the view in the diagram
				ViewUtil.destroy(view);
			}
			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}
		return CommandResult.newErrorCommandResult(Messages.CANT_GROUP_MESSAGE);
	}

	public boolean canExecute() {
		return true;
	}

}
