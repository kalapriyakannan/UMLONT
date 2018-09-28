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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.graphics.Point;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixPrimaryDialog;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;

/**
 * @since 1.0
 * @see QuickFixDialog
 */
public class QuickFixPopUpCommand extends AbstractCommand {

	private PopupDialog quickFixPopUp;

	private final MarkerResolutionHelper resolutionHelper;

	/**
	 * @param containerEP
	 * @param markers
	 * @param decorator
	 * @param label
	 * @param parentShell
	 */
	public QuickFixPopUpCommand(IGraphicalEditPart containerEP, IMarker[] markers, IStatus status,
			Point p, ErrorMarkerDecorator decorator) {
		super("Show Resolutions"); //$NON-NLS-1$
		resolutionHelper = new MarkerResolutionHelper(markers);
		EObject eObject = containerEP.resolveSemanticElement();
		if (eObject instanceof DeployModelObject) {
			quickFixPopUp = new QuickFixPrimaryDialog(containerEP.getViewer().getControl().getShell(),
					(DeployModelObject) eObject, p, Messages.QuickFixPopUpCommand_Error_,
					Messages.QuickFixPopUpCommand_Click_on_error_to_see_resolutions_, null, decorator,
					null, !(eObject instanceof Import));
		} else if (containerEP instanceof ConsolidationLinkEditPart) {
			ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) containerEP;
			List<DeployModelObject> dmoList = new ArrayList<DeployModelObject>();
			for (Iterator<DeployConnectionNodeEditPart> it = consolidationLinkEP
					.getConsolidatedLinkList().iterator(); it.hasNext();) {
				dmoList.add((DeployModelObject) it.next().resolveSemanticElement());
			}
			quickFixPopUp = new QuickFixPrimaryDialog(containerEP.getViewer().getControl().getShell(),
					null, p, Messages.QuickFixPopUpCommand_Error_,
					Messages.QuickFixPopUpCommand_Click_on_error_to_see_resolutions_, null, decorator,
					dmoList, false);
		} else if (containerEP instanceof DiagramNodeEditPart) {
			DiagramNodeEditPart diagramNodeEP = (DiagramNodeEditPart) containerEP;
			Diagram diagram = (Diagram) diagramNodeEP.resolveSemanticElement();

			List<DeployModelObject> dmoList = new ArrayList<DeployModelObject>();
			collectDiagramUnits(diagram.getChildren(), dmoList);

			quickFixPopUp = new QuickFixPrimaryDialog(containerEP.getViewer().getControl().getShell(),
					null, p, Messages.QuickFixPopUpCommand_Error_,
					Messages.QuickFixPopUpCommand_Click_on_error_to_see_resolutions_, null, decorator,
					dmoList, false);
		}

	}

	private void collectDiagramUnits(EList children, List<DeployModelObject> dmoList) {
		for (Iterator<View> it = children.iterator(); it.hasNext();) {
			View view = it.next();
			EObject eo = view.getElement();
			if (eo instanceof DeployModelObject && !dmoList.contains(eo)) {
				dmoList.add((DeployModelObject) eo);
			}
			if (view.getChildren().size() > 0) {
				collectDiagramUnits(view.getChildren(), dmoList);
			}
		}
	}

	public boolean isExecutable() {
		if (quickFixPopUp != null) {
			return true;
		}
		return false;
	}

	/*
	 * Pops up the dialog with the content provided. If the user selects 'select existing', then the
	 * select elements dialog also appears.
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		if (quickFixPopUp != null) {
			quickFixPopUp.open();

		}
		return CommandResult.newOKCommandResult();
	}

	/*
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return CommandResult.newErrorCommandResult(Messages.UNIMP);
	}

	/*
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return CommandResult.newErrorCommandResult(Messages.UNIMP);
	}
}
