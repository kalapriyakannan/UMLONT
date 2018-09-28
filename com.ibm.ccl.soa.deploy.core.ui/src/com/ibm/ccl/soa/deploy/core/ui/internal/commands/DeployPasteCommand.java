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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @since 1.0
 * 
 */
public class DeployPasteCommand extends DeployTransactionalCommand {

	private final DeployDiagramEditPart _dep;
	private View _toContainer;

	/**
	 * @param editingDomain
	 * @param dep
	 * @param toContainer
	 */
	public DeployPasteCommand(TransactionalEditingDomain editingDomain, DeployDiagramEditPart dep,
			View toContainer) {
		super(editingDomain, DiagramUIMessages.PasteCommand_Label, getAllWorkspaceFiles(toContainer));
		_dep = dep;
		_toContainer = toContainer;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		// get clip from clipboard
		Display display = _dep.getViewer().getControl().getDisplay();
		Clipboard clipboard = new Clipboard(display);
		Object o = clipboard.getContents(DeployObjectTransfer.getInstance());
		if (o instanceof Diagram) {
			Diagram fromDiagram = (Diagram) o;

			// determine the to container
			if (!(_toContainer instanceof Diagram)) {
				View compartment = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.getChildBySemanticHint(_toContainer,
								DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (compartment == null) {
					compartment = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
							.getChildBySemanticHint(_toContainer,
									DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				}
				_toContainer = compartment != null ? compartment : _toContainer.getDiagram();
			}

			// add to current diagram
			ViewUtil.copyDiagramElementsAndViews(DiagramUtils
					.getAllChildViewsIncludingGroup(fromDiagram), _toContainer, _dep, null, true, null);
		}
		clipboard.dispose();

		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		return true;
	}

}
