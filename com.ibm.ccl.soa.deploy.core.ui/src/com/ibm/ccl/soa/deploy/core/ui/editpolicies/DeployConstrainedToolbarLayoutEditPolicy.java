/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SetShapesBoundsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ShrinkWrapViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 1.0
 * 
 */
public class DeployConstrainedToolbarLayoutEditPolicy extends ConstrainedToolbarLayoutEditPolicy {

	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ResizableCompartmentEditPart) {
				return new DeployResizableCompartmentEditPolicy(isHorizontal());
			}
		}
		return super.createChildEditPolicy(child);
	}

	public Command getCommand(Request request) {
		IGraphicalEditPart hostEP = (IGraphicalEditPart) getHost();

		if (RequestConstants.REQ_AUTOSIZE.equals(request.getType())) {
			ResizableCompartmentFigure shapesContainer = GMFUtils.getShapesFigure(hostEP);
			if (DeployShapeNodeEditPart.isShapesMode(hostEP)
					&& shapesContainer.getChildren().size() > 0 && shapesContainer.isExpanded()) {
				return getUnitGroupAutoSizeCommand(request).chain(getArrangeSnapCommand());
			} else {
				return getShrinkWrapViewCommand().chain(getArrangeSnapCommand());
			}
		}

		return super.getCommand(request);
	}

	/**
	 * This command will change the unit group size to fit all its members.
	 */
	protected Command getShrinkWrapViewCommand() {

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		ICommand resizeCommand = new ShrinkWrapViewCommand(editingDomain,
				(IGraphicalEditPart) getHost());

		return new ICommandProxy(resizeCommand);
	}

	/**
	 * This command will change the unit group size to fit all its members.
	 */
	protected Command getUnitGroupAutoSizeCommand(Request request) {

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		ICommand resizeCommand = new SetShapesBoundsCommand(editingDomain,
				DiagramUIMessages.SetAutoSizeCommand_Label, new EObjectAdapter((View) getHost()
						.getModel()), (IGraphicalEditPart) getHost());

		return new ICommandProxy(resizeCommand);
	}

	/**
	 * This command will change the unit group size to fit all its members.
	 */
	protected Command getArrangeSnapCommand() {
		final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return new ICommandProxy(new AbstractTransactionalCommand(editingDomain, "", null) {//$NON-NLS-1$
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
							IAdaptable info) {
						ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(editingDomain,
								(View) getHost().getModel(), null, 0, getHost().getViewer());
						return CommandResult.newOKCommandResult();
					}

					@Override
					protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(editingDomain,
								(View) getHost().getModel(), null, 0, getHost().getViewer());
						return super.doRedo(monitor, info);
					}

					@Override
					protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(editingDomain,
								(View) getHost().getModel(), null, 0, getHost().getViewer());
						return super.doUndo(monitor, info);
					}

				});
	}

}
