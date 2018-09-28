/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.PasteViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployCopyCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployObjectTransfer;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * @since 7.0
 * 
 */
public class DeployDiagramGlobalActionHandler extends DiagramGlobalActionHandler {

	protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart,
			boolean isUndoable) {

		if (!(diagramPart instanceof DeployCoreEditor)) {
			return null;
		}
		DeployCoreEditor editor = (DeployCoreEditor) diagramPart;
		final DeployDiagramEditPart dep = (DeployDiagramEditPart) editor.getDiagramEditPart();
		if (dep == null) {
			return null;
		}

		return new DeployCopyCommand(dep.getEditingDomain(), dep, cntxt.getLabel(),
				getSelectedViews(cntxt.getSelection()), isUndoable);
	}

	protected ICommand getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {

		if (!(diagramPart instanceof DeployCoreEditor)) {
			return null;
		}
		DeployCoreEditor editor = (DeployCoreEditor) diagramPart;
		DiagramEditPart dep = editor.getDiagramEditPart();
		if (dep == null) {
			return null;
		}

		CompositeTransactionalCommand cut = new CompositeTransactionalCommand(dep.getEditingDomain(),
				cntxt.getLabel());

		// Add a copy command - the cut must be undoable/redoable
		cut.compose(getCopyCommand(cntxt, diagramPart, true));

		/* Get the selected edit parts */
		Object[] objects = ((IStructuredSelection) cntxt.getSelection()).toArray();
		for (int i = 0; i < objects.length; i++) {
			/* Get the next part */
			EditPart editPart = (EditPart) objects[i];

			/* Create the delete request */
//			GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
			Request deleteReq = new EditCommandRequestWrapper(new DestroyElementRequest(dep
					.getEditingDomain(), false));

			/* Send the request to the edit part */
			Command deleteCommand = editPart.getCommand(deleteReq);

			/* Add to the compound command */
			if (deleteCommand != null) {
				cut.compose(new CommandProxy(deleteCommand));
			}
		}

		if (!cut.isEmpty() && cut.canExecute()) {
			return cut;
		}

		return null;
	}

	protected boolean canCopy(IGlobalActionContext cntxt) {
		List<?> elements = getSelectedViews(cntxt.getSelection());
		for (Iterator<?> it = elements.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof View) {
				EObject eo = ViewUtil.resolveSemanticElement((View) o);
				if (eo instanceof DeployModelObject) {
					if (PropertyUtils.isProxy((DeployModelObject) eo)) {
						return false;
					}
				}
			}
		}
		return super.canCopy(cntxt);
	}

	protected boolean canPaste(IGlobalActionContext cntxt) {
		IWorkbenchPart part = cntxt.getActivePart();
		if (part instanceof DeployCoreEditor) {
			DeployCoreEditor editor = (DeployCoreEditor) part;
			if (editor.getDiagramGraphicalViewer() != null) {
				Clipboard clipboard = new Clipboard(editor.getDiagramGraphicalViewer().getControl()
						.getDisplay());
				TransferData[] transfers = clipboard.getAvailableTypes();
				clipboard.dispose();
				DeployObjectTransfer transfer = DeployObjectTransfer.getInstance();
				for (int i = 0; i < transfers.length; i++) {
					if (transfer.isSupportedType(transfers[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	protected PasteViewRequest createPasteViewRequest() {
		return new PasteViewRequest(new ICustomData[1]);
	}

}