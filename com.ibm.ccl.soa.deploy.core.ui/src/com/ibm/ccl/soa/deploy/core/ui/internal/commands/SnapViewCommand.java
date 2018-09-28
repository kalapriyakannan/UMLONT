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

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 * @since 1.0
 * 
 */
public class SnapViewCommand extends DeployTransactionalCommand {
	final private Rectangle _rectAttachment;
	final private GraphicalEditPart _attachmentEP;
	final private GraphicalEditPart _touchingPart;
	final private boolean _isSnapCommand;
	final private boolean _isAlignViews;
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	/**
	 * @param editingDomain
	 * @param rect
	 * @param attachmentEP
	 * @param touchingPart
	 * @param toContainerEP
	 * @param isSnapCommand
	 */
	public SnapViewCommand(TransactionalEditingDomain editingDomain, Rectangle rect,
			GraphicalEditPart attachmentEP, GraphicalEditPart touchingPart,
			DeployShapeNodeEditPart toContainerEP, boolean isSnapCommand) {
		super(editingDomain, Messages.AttachViewCommand_0, getWorkspaceFiles(attachmentEP));

		if (rect != null) {
			_rectAttachment = rect;
			if (toContainerEP != null) {
				Point loc = _rectAttachment.getTopLeft();
				com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.translateToCompartment(loc, toContainerEP);
				_rectAttachment.setLocation(loc);
			}
		} else {
			_rectAttachment = null;
		}
		_attachmentEP = attachmentEP;
		_touchingPart = touchingPart;
		_isSnapCommand = isSnapCommand;
		_isAlignViews = true;
		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * @param editingDomain
	 * @param detachmentEP
	 * @param alignViews
	 */
	public SnapViewCommand(TransactionalEditingDomain editingDomain, GraphicalEditPart detachmentEP,
			boolean alignViews) {
		super(editingDomain, Messages.AttachViewCommand_0, getWorkspaceFiles(detachmentEP));

		_rectAttachment = null;
		_attachmentEP = detachmentEP;
		_touchingPart = null;
		_isSnapCommand = false;
		_isAlignViews = alignViews;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		View snapView = _attachmentEP.getNotationView();
		EditPartViewer viewer = _attachmentEP.getViewer();
		// attaching
		if (_isSnapCommand) {
			// get touching view's snap row	and group
			// if none, create row and group and add to 1st row'
			View touchingView = _touchingPart.getNotationView();
			int[] touchingRowIndex = new int[] { 0 };
			View touchSnapGroup = getSnapGroup(touchingView, touchingRowIndex);

			// get attachment view's snap row and group
			// if none, create row and group and add to 1st row'
			int[] attachmentRowIndex = new int[] { 0 };
			View attachmentSnapGroup = getSnapGroup(snapView, attachmentRowIndex);

			// merge attachment group into touching group
			Rectangle rectTouching = _touchingPart.getFigure().getBounds().getCopy();
			Rectangle r = rectTouching.getCopy().expand(6 * Q, 6 * Q).getIntersection(_rectAttachment);
			if (!r.isEmpty()) {
				// if merging attachment group to top/bottom of touch group, change touch row index
				if (r.width > r.height) {
					if (_rectAttachment.getTop().y < rectTouching.getTop().y) {
						touchingRowIndex[0]--;
					} else {
						touchingRowIndex[0]++;
					}
				}
				// merging attachment group to left/right of touching group
				View fromGroup = null;
				View intoGroup = null;
				int index = 0;
				boolean isLeft = _rectAttachment.getLeft().x < rectTouching.getLeft().x;
				if (attachmentRowIndex[0] <= touchingRowIndex[0]) {
					fromGroup = attachmentSnapGroup;
					intoGroup = touchSnapGroup;
					index = touchingRowIndex[0] - attachmentRowIndex[0];
				} else {
					fromGroup = touchSnapGroup;
					intoGroup = attachmentSnapGroup;
					index = attachmentRowIndex[0] - touchingRowIndex[0];
				}
				mergeSnapGroups(fromGroup, intoGroup, index, isLeft);
			}
			ArrangeSnappedViewsCommand.arrangeSnappedViews(touchingView, viewer, 0, null);

			// detaching
		} else {
			// remove from my snap row
			DeployStyle snapViewStyle = (DeployStyle) snapView
					.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
			View snapRow = snapViewStyle.getSnapParent();
			snapViewStyle.setSnapParent(null);

			if (snapRow != null) {
				DeployStyle snapRowStyle = (DeployStyle) snapRow
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				snapRowStyle.getSnapChildren().remove(snapView);
				View snapGroup = (View) snapRow.eContainer();

				// if row is now empty, remove from group
				if (snapRowStyle.getSnapChildren().isEmpty()) {

					// if row is in the middle of the group, create a new group
					int inx = snapGroup.getPersistedChildren().indexOf(snapRow);
					int siz = snapGroup.getPersistedChildren().size();
					// if not at top or bottom, see if we should create a new group for other rows
					if (inx > 0 && inx < siz - 1) {
						// is there enough in bottom to create a new group? 
						// (multiple rows or last row has multiple snap children)
						View bottomRow = (View) snapGroup.getPersistedChildren().get(siz - 1);
						DeployStyle bottomRowStyle = (DeployStyle) bottomRow
								.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
						if (inx < siz - 2 || bottomRowStyle.getSnapChildren().size() > 1) {
							// create a second snapGroup
							View snapGroup2 = ViewService.getInstance().createView(Node.class, null,
									(View) snapGroup.eContainer(),
									DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1, true,
									_attachmentEP.getDiagramPreferencesHint());

							// move the bottom rows to the new group
							for (int i = 0; i < siz - inx - 1; i++) {
								snapGroup2
										.insertChild((View) snapGroup.getPersistedChildren().get(inx + 1));
							}
							// SPECIAL CASE: bottom row has a single view, just delete it from group
						} else if (inx == siz - 2 && bottomRowStyle.getSnapChildren().size() == 1) {
							// remove the empty row
							View bottomView = bottomRowStyle.getSnapChildren().get(0);
							DeployStyle bottomViewStyle = (DeployStyle) bottomView
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							bottomViewStyle.setSnapParent(null);
							snapGroup.getPersistedChildren().remove(bottomRow);
							org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(bottomRow);
						}
					}
					// remove the empty row
					snapGroup.getPersistedChildren().remove(snapRow);
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(snapRow);
				}

				// if snap group now only has one row/view, destroy the group
				if (snapGroup.getChildren().size() == 1) {
					snapRow = (View) snapGroup.getChildren().get(0);
					snapRowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
							.getDeployStyle());
					if (snapRowStyle.getSnapChildren().size() == 1) {
						View view = snapRowStyle.getSnapChildren().get(0);
						DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
								.getDeployStyle());
						style.setSnapParent(null);
						org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(snapGroup);
						snapGroup = null;
					}
				}
				if (snapGroup != null && _isAlignViews) {
					ArrangeSnappedViewsCommand.arrangeSnappedViews(snapGroup, viewer,
							SnapUtils.ANCHOR_GROUP, null);
				}
			}
		}
		CanonicalUtils.refreshLinks();

		return CommandResult.newOKCommandResult();
	}

	private View getSnapGroup(View view, int[] rowIndex) {
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		View snapRow = style.getSnapParent();
		View snapGroup = null;
		if (snapRow != null) {
			snapGroup = (View) snapRow.eContainer();
		} else {
			// create a new snapGroup
			snapGroup = ViewService.getInstance().createView(Node.class, null,
					(View) view.eContainer(), DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1, true,
					_attachmentEP.getDiagramPreferencesHint());

			// create a new snapRow
			snapRow = ViewService.getInstance().createView(Node.class, null, snapGroup,
					DeployCoreConstants.SNAPROW_SEMANTICHINT, -1, true,
					_attachmentEP.getDiagramPreferencesHint());

			// add view to snapRow and vice versa
			style.setSnapParent(snapRow);
			DeployStyle rowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			rowStyle.getSnapChildren().add(view);
		}
		rowIndex[0] = snapGroup.getChildren().indexOf(snapRow);
		return snapGroup;
	}

	private void mergeSnapGroups(View fromGroup, View intoGroup, int intoRowIndex, boolean isLeft) {

		// if index is -1, we are adding to bottom of into group
		if (intoRowIndex == -1) {
			intoRowIndex = intoGroup.getChildren().size();
		}

		// for each fromGroup row, add to the intoGroup
		for (Iterator<?> it = fromGroup.getChildren().iterator(); it.hasNext();) {
			View fromRowView = (View) it.next();
			DeployStyle fromRowStyle = (DeployStyle) fromRowView
					.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());

			// get intoGroup row
			View intoRowView = null;
			if (intoRowIndex < intoGroup.getChildren().size()) {
				intoRowView = (View) intoGroup.getChildren().get(intoRowIndex);
			} else {
				intoRowView = ViewService.getInstance().createView(Node.class, null, intoGroup,
						DeployCoreConstants.SNAPROW_SEMANTICHINT, -1, true,
						_attachmentEP.getDiagramPreferencesHint());
			}
			DeployStyle toRowStyle = (DeployStyle) intoRowView
					.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());

			if (isLeft) {
				toRowStyle.getSnapChildren().addAll(0, fromRowStyle.getSnapChildren());
			} else {
				toRowStyle.getSnapChildren().addAll(fromRowStyle.getSnapChildren());
			}

			// update merged views to new snap row
			for (Iterator<View> itRow = fromRowStyle.getSnapChildren().iterator(); itRow.hasNext();) {
				View view = itRow.next();
				DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				style.setSnapParent(intoRowView);
			}
			intoRowIndex++;
		}

		// destroy from group
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(fromGroup);

	}

	public boolean canExecute() {
		return true;
	}

	/**
	 * @param view
	 * @return how many members are in this snap group?
	 */
	public static int getMemberSize(View view) {
		int members = 0;
		for (Iterator<?> it = view.getPersistedChildren().iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof View) {
				View v = (View) o;
				if (v.getType() != null && v.getType().equals(DeployCoreConstants.SNAPROW_SEMANTICHINT)) {
					DeployStyle snapRowStyle = (DeployStyle) v.getStyle(DeployNotationPackage.eINSTANCE
							.getDeployStyle());
					members += snapRowStyle.getSnapChildren().size();
				}
			}
		}
		return members;
	}

}
