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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class AddToNewGroupCommand extends DeployTransactionalCommand {

	private static final int VIEW_OFFSET = 500;
	private final List selectedParts;
	private final DiagramEditPart diagramEP;

	/**
	 * @param selectedParts
	 * @param targetGroupPart
	 * @param diagramEP
	 */
	public AddToNewGroupCommand(List selectedParts, DiagramEditPart diagramEP) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_ADD_TO_NEW_GROUP,
				getAllWorkspaceFiles(diagramEP.getNotationView()));

		this.selectedParts = selectedParts;
		this.diagramEP = diagramEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		/** Create a new unit group */
		CreateViewAndElementRequest createGroupReq = (CreateViewAndElementRequest) CreateViewRequestFactory
				.getCreateShapeRequest(DeploySemanticType.UNITGROUP, diagramEP
						.getDiagramPreferencesHint());
		Command newGroupCommand = diagramEP.getCommand(createGroupReq);
		newGroupCommand.execute();
		List<View> createdRootViews = (List<View>) createGroupReq.getExtendedData().get(
				DeployCreateElementAndViewCommand.CREATEDROOTVIEWS);
		View newGrpView = createdRootViews.get(0);
		boolean isTree = false;
		View newGrpAreaView = ViewUtil.getChildBySemanticHint(newGrpView,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (newGrpAreaView == null) {
			isTree = true;
			newGrpAreaView = ViewUtil.getChildBySemanticHint(newGrpView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		Unit newGrp = (Unit) newGrpView.getElement();

		/** Set the position and size of the new group */
		if (selectedParts.size() > 0) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) GEFUtils
					.getTopEditPart((EditPart) selectedParts.get(0));
			View view = (View) ep.getModel();
			Integer oldX = (Integer) ViewUtil.getStructuralFeatureValue(view,
					NotationPackage.eINSTANCE.getLocation_X());
			Integer oldY = (Integer) ViewUtil.getStructuralFeatureValue(view,
					NotationPackage.eINSTANCE.getLocation_Y());
			Integer newX = new Integer(oldX.intValue() + DeployCoreConstants.SERVER_UNIT_WIDTH);
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getLocation_X(),
					newX);
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getLocation_Y(),
					oldY);
		}

		ViewUtil.setStructuralFeatureValue(newGrpAreaView, NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), new Boolean(false));
		if (!isTree) {
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getSize_Width(),
					new Integer(DeployCoreConstants.UNIT_NEW_SHAPES_WIDTH));
			ViewUtil.setStructuralFeatureValue(newGrpView, NotationPackage.eINSTANCE.getSize_Height(),
					new Integer(DeployCoreConstants.UNIT_NEW_SHAPES_HEIGHT));
		}

		/** Add selected units to the unit group newly created */
		for (int i = 0; i < selectedParts.size(); i++) {
			DeployShapeNodeEditPart selectedPart = (DeployShapeNodeEditPart) selectedParts.get(i);
			View selectedView = selectedPart.getNotationView();
			Unit selectedUnit = (Unit) selectedView.getElement();

			// create member link relationship
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			if (dvs.canCreateLink(newGrp, selectedUnit, LinkType.MEMBER_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(newGrp, selectedUnit, LinkType.MEMBER_SET);
				if (hld.length > 0) {
					hld[0].create();
				}
			}

			// Create a new view object
			Node newNode = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(diagramEP,
					newGrpAreaView, selectedView);

			// Set "do not auto delete" attribute to true for selected object
			DeployStyle deployStyleSelected = (DeployStyle) selectedView
					.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
			deployStyleSelected.setIsDuplicateCanvasView(true);

			// Set position offset for new view object
			if (!isTree) {
				ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE.getLocation_X(),
						new Integer(VIEW_OFFSET * i));
				ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE.getLocation_Y(),
						new Integer(VIEW_OFFSET * i));
			}
		}

		return CommandResult.newOKCommandResult();
	}
}
