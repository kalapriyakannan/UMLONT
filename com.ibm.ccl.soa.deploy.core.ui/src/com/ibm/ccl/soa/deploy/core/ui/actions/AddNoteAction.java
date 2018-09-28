/***************************************************************************************************
 * Copyright (c) 2004, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.actions.AttachShapeAction;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.l10n.DiagramUIActionsMessages;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.l10n.DiagramUIActionsPluginImages;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.IEditableEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author <a href="mailto:guojg@cn.ibm.com">Guo Jian Guang</a>
 * 
 * This action is used to replace the GMF built-in AddNodeAction. It will create note on the diagram
 * for those nested units.
 */
public class AddNoteAction extends AttachShapeAction {

	public AddNoteAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	public void init() {
		super.init();
		setText(DiagramUIActionsMessages.AddNoteAction_ActionLabelText);
		setId(DeployActionIds.ACTION_ADD_NOTELINK);
		setToolTipText(DiagramUIActionsMessages.AddNoteAction_ActionToolTipText);
		setImageDescriptor(DiagramUIActionsPluginImages.DESC_NOTE_ATTACHMENT);
		setHoverImageDescriptor(getImageDescriptor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#calculateEnabled()
	 */
	protected boolean calculateEnabled() {
		if (getSelectedObjects().isEmpty()) {
			return true;
		}
		List parts = getSelectedObjects();
		for (int i = 0; i < parts.size(); i++) {
			Object o = parts.get(i);
			if (!(o instanceof INodeEditPart)) {
				return false;
			} else {
				INodeEditPart nodeEditPart = (INodeEditPart) o;
				if (!nodeEditPart.canAttachNote()) {
					return false;
				}

				// consider edit mode of selected edit part
				if (nodeEditPart instanceof IEditableEditPart
						&& !((IEditableEditPart) nodeEditPart).isEditModeEnabled()) {
					return false;
				}

				// consider edit mode of selected edit part's container
				EditPart parentPart = nodeEditPart.getParent();
				if (parentPart instanceof IEditableEditPart
						&& !((IEditableEditPart) parentPart).isEditModeEnabled()) {
					return false;
				}

			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#doRun(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		List selectedEditParts = getSelectedObjects();
		IDiagramWorkbenchPart editor = getDiagramWorkbenchPart();

		// note request
		ViewDescriptor viewDescriptor = new ViewDescriptor(null, Node.class, "Note", //$NON-NLS-1$
				getPreferencesHint());
		CreateViewRequest noteRequest = new CreateViewRequest(viewDescriptor);

		noteRequest.setLocation(getLocation(selectedEditParts));

		IGraphicalEditPart primaryPart = (IGraphicalEditPart) selectedEditParts.get(0);
		if (primaryPart instanceof ConnectionEditPart) {
			primaryPart = (IGraphicalEditPart) ((ConnectionEditPart) primaryPart).getSource();
		}

		//add the note to diagram
		Command createNoteCmd = getDiagramEditPart().getCommand(noteRequest);
		// note view adapter
		IAdaptable noteViewAdapter = (IAdaptable) ((List) noteRequest.getNewObject()).get(0);

		// create the note attachments commands
		CompositeCommand noteAttachmentCC = new CompositeCommand(getToolTipText());

		Iterator iter = selectedEditParts.iterator();
		while (iter.hasNext()) {
			IGraphicalEditPart targetEditPart = (IGraphicalEditPart) iter.next();

			noteAttachmentCC.compose(new DeferredCreateConnectionViewCommand(targetEditPart
					.getEditingDomain(), ViewType.NOTEATTACHMENT, noteViewAdapter, new EObjectAdapter(
					(EObject) targetEditPart.getModel()), editor.getDiagramGraphicalViewer(),
					getPreferencesHint()));
		}

		CompoundCommand cc = new CompoundCommand(getToolTipText());
		cc.add(createNoteCmd);
		cc.add(new ICommandProxy(noteAttachmentCC));

		if (cc.canExecute()) {
			editor.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			selectAddedObject(editor.getDiagramGraphicalViewer(), noteRequest);
		}
	}

}
