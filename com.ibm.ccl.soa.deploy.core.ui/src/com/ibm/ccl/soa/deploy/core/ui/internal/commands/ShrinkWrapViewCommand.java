/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

/**
 * @since 7.0
 * 
 */
public class ShrinkWrapViewCommand extends DeployTransactionalCommand {
	private final IGraphicalEditPart _targetPart;

	/**
	 * @param editingDomain
	 * @param targetPart
	 */
	public ShrinkWrapViewCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetPart) {
		super(editingDomain, DiagramUIMessages.SetAutoSizeCommand_Label,
				getWorkspaceFiles(targetPart));

		_targetPart = targetPart;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		View view = _targetPart.getNotationView();
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			style.setCollapseHeight(-1);
			style.setCollapseWidth(-1);
			style.setExpandHeight(-1);
			style.setExpandWidth(-1);

			refreshCompartment(_targetPart);
		}
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		refreshCompartment(_targetPart);
		return super.doRedo(monitor, info);
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		refreshCompartment(_targetPart);
		return super.doUndo(monitor, info);
	}

	private void refreshCompartment(IGraphicalEditPart hostEP) {
		IGraphicalEditPart compartmentEP = DeployShapeNodeEditPart.getListCompartment(hostEP);
		if (compartmentEP == null) {
			compartmentEP = DeployShapeNodeEditPart.getShapesCompartment(hostEP);
		}
		if (compartmentEP != null) {
			View compartmentView = compartmentEP.getNotationView();
			Boolean b = (Boolean) ViewUtil.getStructuralFeatureValue(compartmentView,
					NotationPackage.eINSTANCE.getDrawerStyle_Collapsed());
			ViewUtil.setStructuralFeatureValue(compartmentView, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed(), b ? Boolean.FALSE : Boolean.TRUE);
			ViewUtil.setStructuralFeatureValue(compartmentView, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed(), b);
		}
	}

}
