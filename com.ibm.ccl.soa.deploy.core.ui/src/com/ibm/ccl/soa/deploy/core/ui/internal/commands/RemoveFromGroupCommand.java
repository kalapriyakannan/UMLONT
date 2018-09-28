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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.RemoveFromAllGroupsAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.RemoveFromCurrentGroupsAction;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see RemoveFromAllGroupsAction
 * @see RemoveFromCurrentGroupsAction
 */
public class RemoveFromGroupCommand extends DeployTransactionalCommand {
	private final DiagramEditPart diagramEP;
	private final List selectedParts;
	private final boolean removeAll;

	/**
	 * @param selectedParts
	 * @param removeAll
	 *           indicate whether to delete all duplicates
	 * @param diagramEP
	 */
	public RemoveFromGroupCommand(List selectedParts, boolean removeAll, DiagramEditPart diagramEP) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_REMOVE_FROM_GROUP,
				getAllWorkspaceFiles(diagramEP.getNotationView()));

		this.selectedParts = selectedParts;
		this.removeAll = removeAll;
		this.diagramEP = diagramEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		if (removeAll) {
			removeAll();
		} else {
			removeSelected();
		}

		// Refresh diagram
		CanonicalUtils.refreshViews(CanonicalUtils.getUnitList(selectedParts), false);

		return CommandResult.newOKCommandResult();
	}

	private void removeSelected() {
		for (int i = 0; i < selectedParts.size(); i++) {
			DeployShapeNodeEditPart selectedPart = (DeployShapeNodeEditPart) selectedParts.get(i);
			View memberView = selectedPart.getNotationView();
			View parentView = (View) memberView.eContainer();
			// find the member link between selected view and its group view
			MemberLink memberLink = findMemberLink((Unit) parentView.getElement(), (Unit) memberView
					.getElement());
			if (memberLink != null) {
				ViewUtil.destroy(memberView);
				EcoreUtil.remove(memberLink);
			}
		}
	}

	private void removeAll() {
		// Get all selected units
		Set selectedUnits = new HashSet();
		for (int i = 0; i < selectedParts.size(); i++) {
			DeployShapeNodeEditPart selectedPart = (DeployShapeNodeEditPart) selectedParts.get(i);
			View memberView = selectedPart.getNotationView();
			EObject memberUnit = memberView.getElement();
			selectedUnits.add(memberUnit);
		}

		// Get all member links targeting to every selected unit
		Topology topology = (Topology) diagramEP.getNotationView().getElement();
		Iterator memberLinksIter = topology.findAllMemberLinks();
		List memberLinksToDestroy = new ArrayList();
		while (memberLinksIter.hasNext()) {
			MemberLink memberLink = (MemberLink) memberLinksIter.next();
			if (selectedUnits.contains(memberLink.getTarget())) {
				memberLinksToDestroy.add(memberLink);
			}
		}

		// Destroy member links
		for (Iterator i = memberLinksToDestroy.iterator(); i.hasNext();) {
			EcoreUtil.remove((MemberLink) i.next());
		}
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
