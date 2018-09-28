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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToGroupCommand extends DeployTransactionalCommand {
	private static final int VIEW_OFFSET = 800;

	private final View targetGroupView;
	private boolean isInHostingList = false;
	private View targetGroupContainerView;
	private final Unit targetGroupUnit;
	private final List selectedParts;

	/**
	 * @param selectedParts
	 * @param targetGroupEP
	 */
	public MoveToGroupCommand(DeployShapeNodeEditPart targetEP, List selectedParts) {
		super(targetEP.getEditingDomain(), Messages.CMD_LABEL_MOVE_TO_GROUP,
				getAllWorkspaceFiles(targetEP.getNotationView()));

		this.selectedParts = selectedParts;
		targetGroupView = targetEP.getNotationView();
		isInHostingList = false;
		targetGroupContainerView = ViewUtil.getChildBySemanticHint(targetGroupView,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (targetGroupContainerView == null) {
			isInHostingList = true;
			targetGroupContainerView = ViewUtil.getChildBySemanticHint(targetGroupView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}

		targetGroupUnit = (Unit) targetGroupView.getElement();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		ViewUtil.setStructuralFeatureValue(targetGroupContainerView, NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), new Boolean(false));

		List movedViews = new ArrayList();
		for (int i = 0; i < selectedParts.size(); i++) {
			EditPart srcEP = (EditPart) selectedParts.get(i);
			View srcView = (View) srcEP.getModel();
			View containerView = (View) srcView.eContainer();
			Unit srcUnit = (Unit) srcView.getElement();

			// Delete the old member link
			if (!(containerView instanceof Diagram)) {
				MemberLink memberLink = findMemberLink((Unit) containerView.getElement(), srcUnit);
				if (memberLink != null) {
					EcoreUtil.remove(memberLink);
				}
			}

			// Create the new member link between selected unit and target unit group
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			if (dvs.canCreateLink(targetGroupUnit, srcUnit, LinkType.MEMBER_SET).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(targetGroupUnit, srcUnit,
						LinkType.MEMBER_SET);
				if (hld.length > 0) {
					hld[0].create();
				}
			}

			// Reposition the view object
			ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_X(),
					new Integer(VIEW_OFFSET * (selectedParts.size() - i - 1)));
			ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_Y(),
					new Integer(VIEW_OFFSET * (selectedParts.size() - i - 1)));

			movedViews.add(srcView);
		}

		// Set offset 
		if (!isInHostingList) {
			for (Iterator i = targetGroupContainerView.getChildren().iterator(); i.hasNext();) {
				Object obj = i.next();
				if (obj instanceof Node) {
					Node childNode = (Node) obj;
					Integer oldX = (Integer) ViewUtil.getStructuralFeatureValue(childNode,
							NotationPackage.eINSTANCE.getLocation_X());
					Integer oldY = (Integer) ViewUtil.getStructuralFeatureValue(childNode,
							NotationPackage.eINSTANCE.getLocation_Y());
					Integer newX = new Integer(oldX.intValue() + VIEW_OFFSET * selectedParts.size());
					Integer newY = new Integer(oldY.intValue() + VIEW_OFFSET * selectedParts.size());
					ViewUtil.setStructuralFeatureValue(childNode, NotationPackage.eINSTANCE
							.getLocation_X(), newX);
					ViewUtil.setStructuralFeatureValue(childNode, NotationPackage.eINSTANCE
							.getLocation_Y(), newY);
				}
			}
		}

		// Insert selected View into children list of the target group view
		for (Iterator i = movedViews.iterator(); i.hasNext();) {
			targetGroupContainerView.insertChild((View) i.next(), true);
		}

		return CommandResult.newOKCommandResult();
	}

	private MemberLink findMemberLink(Unit source, Unit target) {
		List memberLinks = source.getMemberLinks();
		for (int i = 0; i < memberLinks.size(); i++) {
			MemberLink memberLink = (MemberLink) memberLinks.get(i);
			if (memberLink.getTarget() == target) {
				return memberLink;
			}
		}

		return null;
	}
}
