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

import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 */
public class SnapStyleCommand extends AbstractTransactionalCommand {
	private final List<GraphicalEditPart> _selectedList;
	private final int _snapStyle;

	/**
	 * @param selectedList
	 * @param snapStyle
	 * @param label
	 */
	public SnapStyleCommand(List<GraphicalEditPart> selectedList, int snapStyle, String label) {
		super(selectedList.get(0).getEditingDomain(), label, getWorkspaceFiles(selectedList.get(0)
				.getNotationView()));

		_selectedList = selectedList;
		_snapStyle = snapStyle;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		EditPartViewer viewer = null;
		HashMap<View, View> snapGroups = new HashMap<View, View>();

		// From the selected list of views, build a map of snapGroups. 
		// Note that two or more of the selected views might belong to the same snapGroup.
		// If only one view is selected within a given snapGroup, that view will be the anchor 
		// view for the alignment of its snapGroup. 
		// If more than one view within a given snapGroup is selected, then
		// the snapGroup itself will be the anchor view for alignment.

		for (GraphicalEditPart ep : _selectedList) {
			View view = ep.getNotationView();
			if (viewer == null) {
				viewer = ep.getViewer();
			}
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style.getSnapParent() != null && style.getSnapParent().eContainer() != null) {
				View snapGroup = (View) style.getSnapParent().eContainer();
				if (snapGroups.get(snapGroup) != null) {
					// the snapGroup will be the anchor
					snapGroups.put(snapGroup, snapGroup);
				} else {
					// this view will be the anchor
					snapGroups.put(snapGroup, view);
				}
			}
		}

		// SelectionUtils.unfadeFigures();

		if (!snapGroups.isEmpty() && viewer != null) {
			for (View snapGroup : snapGroups.keySet()) {
				View anchor = snapGroups.get(snapGroup);
				boolean isAnchorGroup = anchor == snapGroup ? true : false;
				DeployStyle snapGroupStyle = (DeployStyle) snapGroup
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				snapGroupStyle.setSnapStyle(_snapStyle);
				int flag = isAnchorGroup ? SnapUtils.ANCHOR_GROUP : 0;
				ArrangeSnappedViewsCommand.arrangeSnappedViews(anchor, viewer, flag, null);
			}
		}

		return CommandResult.newOKCommandResult(null);
	}
}
