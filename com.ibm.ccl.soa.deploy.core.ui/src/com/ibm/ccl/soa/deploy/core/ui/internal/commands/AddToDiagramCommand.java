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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * This command is used to create duplicate views on the diagram from selected group members.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class AddToDiagramCommand extends AbstractTransactionalCommand {
	private final DiagramEditPart diagramEP;
	private final List selectedParts;

	private final List newViews = new ArrayList();

	/**
	 * @param selectedParts
	 * @param diagramEP
	 */
	public AddToDiagramCommand(DiagramEditPart diagramEP, List selectedParts) {
		super(diagramEP.getEditingDomain(), Messages.CMD_LABEL_ADD_TO_DIAGRAM,
				getWorkspaceFiles(diagramEP.getNotationView()));

		this.selectedParts = selectedParts;
		this.diagramEP = diagramEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (Iterator i = selectedParts.iterator(); i.hasNext();) {
			EditPart srcEP = (EditPart) i.next();
			View srcView = (View) srcEP.getModel();

			// Create a new view object on the diagram	
			// if not proxy view, copy children views too
			Node newNode = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(diagramEP, diagramEP,
					srcView, null, true, !PropertyUtils
							.isProxy((DeployModelObject) srcView.getElement()), true, false, null);
			newViews.add(newNode);

			// Set "Do not auto delete" attribute
			DeployStyle deployStyleSelected = (DeployStyle) newNode
					.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
			deployStyleSelected.setIsDuplicateCanvasView(true);

			/** relocate the view around the source view */

			// Get get the diagram view's direct child which contains the source view
			View directChild = srcView;
			while (true) {
				if (directChild.eContainer() instanceof Diagram) {
					break;
				}

				directChild = (View) directChild.eContainer();
			}

			// put next to creating view on outside of container
			int x = ((Integer) ViewUtil.getStructuralFeatureValue(directChild,
					NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int width = ((Integer) ViewUtil.getStructuralFeatureValue(directChild,
					NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int y = ((IGraphicalEditPart) srcEP).getFigure().getBounds().getTop().y;
			if (srcEP.getParent() instanceof HybridShapesCompartmentEditPart) {
				y = ((Integer) ViewUtil.getStructuralFeatureValue(directChild,
						NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			}

			// Relocate the newly create view at the bottom-left point
			ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE.getLocation_X(),
					new Integer(x + width + 250));
			ViewUtil.setStructuralFeatureValue(newNode, NotationPackage.eINSTANCE.getLocation_Y(),
					new Integer(y));
		}

		return CommandResult.newOKCommandResult();
	}
}
