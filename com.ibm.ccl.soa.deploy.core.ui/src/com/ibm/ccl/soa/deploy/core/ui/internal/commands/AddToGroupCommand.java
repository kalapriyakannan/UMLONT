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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * This command receives two parameters. One is the target unit, and the other is the list of unit
 * editparts which are going to be added in the target unit group. After getting these two
 * parameters, this command will iterate the list of editparts, and do what are listed as below for
 * each selected editpart: 1. create the memeber link between unit and unit group 2. move the view
 * to unit group view or create a duplicate view in the unit group, dependent on whether the
 * selected editpart has belonged to some unit group or not.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author Ed Snible
 */
public class AddToGroupCommand extends DeployTransactionalCommand {

	private static final int VIEW_OFFSET = 500;

	private final List selectedParts;
	//	private UnitGroupEditPart targetGroupPart;
	private final Unit target;
	//	private ViewDescriptor targetGroupViewDesc;
	private final DiagramEditPart diagramEP;

	List newViews = new ArrayList();

	/**
	 * @param target
	 * @param selectedParts
	 * @param diagramEP
	 */
	public AddToGroupCommand(Unit target, List selectedParts, DiagramEditPart diagramEP) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_ADD_TO_GROUP,
				getAllWorkspaceFiles(diagramEP.getNotationView()));

		//		this.targetGroupPart = targetGroupPart;
		this.target = target;
		this.selectedParts = selectedParts;
		this.diagramEP = diagramEP;
	}

	/**
	 * @param targetGroupViewDesc
	 * @param selectedParts
	 * @param diagramEP
	 */
	public AddToGroupCommand(ViewDescriptor targetGroupViewDesc, List selectedParts,
			DiagramEditPart diagramEP) {
		this(getUnit(targetGroupViewDesc), selectedParts, diagramEP);
	}

	private static Unit getUnit(ViewDescriptor desc) {
		Node n = (Node) desc.getAdapter(Node.class);
		return (Unit) n.getElement();
	}

	private static GraphicalEditPart getUnitGroupEditPart(Unit unit) {
		//		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart)workbenchPage.getActivePart();
		IDiagramWorkbenchPart diagramWBPart = (IDiagramWorkbenchPart) ResourceUtils
				.getActiveWorkbenchPage().getActivePart();
		EditPartViewer viewer = diagramWBPart.getDiagramGraphicalViewer();
		List epList = GMFUtils.getEditPartsFor(viewer, unit);
		if (epList.size() > 0) {
			return (GraphicalEditPart) epList.get(0);
		}

		return null;
	}

	private View getUnitGroupView(Unit unit) {
		GraphicalEditPart ep = getUnitGroupEditPart(unit);
		return ep == null ? null : ep.getNotationView();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		/** Get UnitGroup semantic model element */
		View unitGroupView = getUnitGroupView(target);
		Unit unitGroup = target;

		View hybridShapesView = null;
		View hybridListView = null;
		// Does the view already exist (not lazily waiting for birth?)
		if (unitGroupView != null) {
			hybridShapesView = ViewUtil.getChildBySemanticHint(unitGroupView,
					DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			hybridListView = ViewUtil.getChildBySemanticHint(unitGroupView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}

		/**
		 * indicate that the target unit group is in the hosting list or in the member area
		 */
		boolean shownInMemberArea = hybridShapesView == null ? false : true;
		boolean shownInHybridList = hybridListView == null ? false : true;

		View containerView = null;
		if (shownInMemberArea) {
			containerView = hybridShapesView;
		} else if (shownInHybridList) {
			containerView = hybridListView;
		}
		ViewUtil.setStructuralFeatureValue(containerView, NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), new Boolean(false));

		/** Create new views in the unit group compartment */

		for (int i = 0; i < selectedParts.size(); i++) {
			DeployShapeNodeEditPart selectedPart = (DeployShapeNodeEditPart) selectedParts.get(i);
			View selectedView = selectedPart.getNotationView();
			Unit selectedUnit = (Unit) selectedView.getElement();

			// create member link relationship
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			if (dvs.canCreateLink(unitGroup, selectedUnit, LinkType.MEMBER_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(unitGroup, selectedUnit,
						LinkType.MEMBER_SET);
				if (hld.length > 0) {
					hld[0].create();
				}
			}

			if (containerView != null) {
				// Create a new view object 
				Node newNode = null;
				if (shownInMemberArea) {
					newNode = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(diagramEP,
							containerView, selectedView);
				} else {
					newNode = ViewService.getInstance().createNode(new EObjectAdapter(selectedUnit),
							containerView, selectedView.getType(), ViewUtil.APPEND, true,
							diagramEP.getDiagramPreferencesHint());
				}
				newViews.add(newNode);

				// Set do not delete attribute to true for selected object
				DeployStyle deployStyleSelected = (DeployStyle) selectedView
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				deployStyleSelected.setIsDuplicateCanvasView(true);

				// Set position offset for new view object
				if (shownInMemberArea) {
					ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE
							.getLocation_X(), new Integer(VIEW_OFFSET * i));
					ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE
							.getLocation_Y(), new Integer(VIEW_OFFSET * i));
				}
			}
		}

		return CommandResult.newOKCommandResult();
	}

}
