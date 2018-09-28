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

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.ArrangeUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;

/**
 */
public class SnapViewsCommand extends AbstractTransactionalCommand {
	private final List<GraphicalEditPart> _selectedList;
	private final GraphicalEditPart _snapParent;
	private final boolean _isUnsnap;

	/**
	 * @param selectedList
	 * @param parent
	 * @param isUnsnap
	 */
	public SnapViewsCommand(List<GraphicalEditPart> selectedList, GraphicalEditPart parent,
			boolean isUnsnap) {
		super(selectedList.get(0).getEditingDomain(), isUnsnap ? Messages.SnapViewsAction_1
				: Messages.SnapViewsAction_0, getWorkspaceFiles(selectedList.get(0).getNotationView()));

		_selectedList = selectedList;
		_snapParent = parent;
		_isUnsnap = isUnsnap;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		// for snap or unsnap we start by detaching the ep from any snap group it's currently a member of
		int sz = _selectedList.size();
		for (int i = 0; i < sz; i++) {
			GraphicalEditPart ep = _selectedList.get(i);
			new ICommandProxy(new SnapViewCommand(getEditingDomain(), ep, i == sz - 1)).execute();
		}

		// if snap together, we just create one big snap group and have arrange position the results
		SelectionUtils.unfadeFigures();
		if (!_isUnsnap) {

			// create a new snapGroup
			View snapGroup = ViewService.getInstance().createView(Node.class, null,
					_snapParent.getNotationView(), DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1, true,
					_selectedList.get(0).getDiagramPreferencesHint());

			// create a new snapRow
			View snapRow = ViewService.getInstance().createView(Node.class, null, snapGroup,
					DeployCoreConstants.SNAPROW_SEMANTICHINT, -1, true,
					_selectedList.get(0).getDiagramPreferencesHint());
			DeployStyle rowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());

			// add to this row
			View firstView = null;
			for (GraphicalEditPart ep : _selectedList) {
				View view = ep.getNotationView();
				if (firstView == null) {
					firstView = view;
				}
				DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				// add view to snapRow and vice versa
				style.setSnapParent(snapRow);
				rowStyle.getSnapChildren().add(view);
			}

			// arrange attached ep's
			ArrangeSnappedViewsCommand
					.arrangeSnappedViews(firstView, _snapParent.getViewer(), 0, null);

		} else {
			// arrange detached ep's
			ArrangeUtils.arrangeEditParts(_selectedList, null, true, false);
		}

		return CommandResult.newOKCommandResult(null);
	}
}
