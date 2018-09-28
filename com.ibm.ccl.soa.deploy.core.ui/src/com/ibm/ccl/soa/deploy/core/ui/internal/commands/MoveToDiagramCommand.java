/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Move members from groups onto the diagram
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class MoveToDiagramCommand extends AbstractTransactionalCommand {
	private DiagramEditPart diagramEP;
	private List selectedParts;

	/**
	 * @param selectedParts
	 * @param diagramEP
	 */
	public MoveToDiagramCommand(DiagramEditPart diagramEP, List selectedParts) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_MOVE_TO_DIAGRAM,
				getWorkspaceFiles(diagramEP.getNotationView()));

		this.selectedParts = selectedParts;
		this.diagramEP = diagramEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (Iterator i = selectedParts.iterator(); i.hasNext();) {
			EditPart srcEP = (EditPart) i.next();
			View srcView = (View) srcEP.getModel();
			View containerView = (View) srcView.eContainer();
			Unit srcUnit = (Unit) srcView.getElement();

			// Delete the member link
			MemberLink memberLink = findMemberLink((Unit) containerView.getElement(), srcUnit);
			if (memberLink != null) {
				EcoreUtil.remove(memberLink);
			}

			/** Reposition the moved view object around the original group */

			// Get get the diagram view's direct child which contains the source view
			View directChild = srcView;
			while (true) {
				if (directChild.eContainer() instanceof Diagram)
					break;

				directChild = (View) directChild.eContainer();
			}

			// Get the bottom-left position
			Integer blX = (Integer) ViewUtil.getStructuralFeatureValue(directChild,
					NotationPackage.eINSTANCE.getLocation_X());
			Integer blY = (Integer) ViewUtil.getStructuralFeatureValue(directChild,
					NotationPackage.eINSTANCE.getLocation_Y());
			Integer width = (Integer) ViewUtil.getStructuralFeatureValue(directChild,
					NotationPackage.eINSTANCE.getSize_Width());

			Integer newX = new Integer(blX.intValue() + width.intValue() + 200);
			Integer newY = blY;
			// Relocate the newly create view at the bottom-left point
			ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_X(),
					newX);
			ViewUtil.setStructuralFeatureValue(srcView, NotationPackage.eINSTANCE.getLocation_Y(),
					newY);

			// Insert srcView into children list of the diagram view
			diagramEP.getNotationView().insertChild(srcView, true);
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
