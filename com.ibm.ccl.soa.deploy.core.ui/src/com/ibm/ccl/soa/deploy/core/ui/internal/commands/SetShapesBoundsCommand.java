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

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployCoreCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @author <a href="mailto:guojg@cn.ibm.com">Guo Jian Guang</a>
 * 
 */
public class SetShapesBoundsCommand extends DeployTransactionalCommand {
	private final int blank = DeployCoreConstants.SHAPES_UNIT_INSET * 4;
	private final IAdaptable adapter;
	private final Dimension size;
	private final DeployShapeNodeEditPart targetGroupPart;
	private final List editparts;
	private int widthChange;
	private int heightChange;

	/**
	 * @param editingDomain
	 * @param label
	 * @param adapter
	 * @param targetGroupPart
	 */
	public SetShapesBoundsCommand(TransactionalEditingDomain editingDomain, String label,
			IAdaptable adapter, IGraphicalEditPart targetGroupPart) {
		super(editingDomain, label, getWorkspaceFiles(targetGroupPart));

		this.adapter = adapter;
		size = getSize((DeployShapeNodeEditPart) targetGroupPart);
		Assert.isNotNull(adapter);
		Assert.isNotNull(size);
		this.targetGroupPart = (DeployShapeNodeEditPart) targetGroupPart;
		editparts = this.targetGroupPart.getChildren();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		View view = (View) adapter.getAdapter(View.class);
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			style.setCollapseHeight(-1);
			style.setCollapseWidth(-1);
			style.setExpandHeight(-1);
			style.setExpandWidth(-1);
		}

		if (size != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(),
					new Integer(size.width));
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(),
					new Integer(size.height));
		}

		changePosition();
		return CommandResult.newOKCommandResult();
	}

	/**
	 * getSize Method to get the new size of the UnitGroupEdiPart
	 * 
	 */
	private Dimension getSize(DeployShapeNodeEditPart targetGroupPart) {
		int width = targetGroupPart.getFigure().getBounds().width;
		int height = targetGroupPart.getFigure().getBounds().height;
		List editparts = targetGroupPart.getChildren();
		int oldWidth = 0;
		int oldHeight = 0;
		int newWidth = 0;
		int newHeight = 0;
		for (int i = 0; i < editparts.size(); i++) {

			if ((IGraphicalEditPart) editparts.get(i) instanceof DeployCoreCompartmentEditPart) {
				//get the old size of the UnitGroupCompartmentEditPart
				oldWidth = ((IGraphicalEditPart) editparts.get(i)).getFigure().getBounds().width;
				oldHeight = ((IGraphicalEditPart) editparts.get(i)).getFigure().getBounds().height;
				List editpartsOfUnitGroup = ((IGraphicalEditPart) editparts.get(i)).getChildren();
				if (editpartsOfUnitGroup.size() > 0) {
					//get the new size of the UnitGroupCompartmentEditPart
					newWidth = getNewWidth(editpartsOfUnitGroup);
					newHeight = getNewHeight(editpartsOfUnitGroup);

					//We can't set the size of UnitGroupCompartmentEditPart,because it set it's size according to it's 
					//parent's size, so I have to set it's parent's size large enugh to contain it.
					//that how the blank is used
					widthChange = newWidth + blank - oldWidth;
					heightChange = newHeight + blank - oldHeight;

					width = width + widthChange;
					height = height + heightChange;

				} else {
					width = -1;
					height = -1;
				}

			}
		}

		return new Dimension(width, height);
	}

	protected int getLeftPosition(List editparts) {
		int left = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().x;

		for (int j = 0; j < editparts.size(); j++) {
			int currx = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().x;
			if (currx < left) {
				left = currx;
			}
		}
		return left;
	}

	protected int getTopPosition(List editparts) {
		int top = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().y;

		for (int j = 0; j < editparts.size(); j++) {
			int curry = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().y;
			if (curry < top) {
				top = curry;
			}
		}
		return top;
	}

	protected int getRightPosition(List editparts) {
		int x = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().x;
		int width = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().width;
		int right = x + width;
		for (int j = 0; j < editparts.size(); j++) {
			int currx = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().x;
			int currWidth = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().width;
			int currRight = currx + currWidth;
			if (currRight > right) {
				right = currRight;
			}
		}
		return right;
	}

	protected int getBottomPosition(List editparts) {
		int y = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().y;
		int height = ((IGraphicalEditPart) editparts.get(0)).getFigure().getBounds().height;
		int bottom = y + height;
		for (int j = 0; j < editparts.size(); j++) {
			int curry = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().y;
			int currHeight = ((IGraphicalEditPart) editparts.get(j)).getFigure().getBounds().height;
			int currBottom = curry + currHeight;
			if (currBottom > bottom) {
				bottom = currBottom;
			}
		}
		return bottom;
	}

	protected int getNewWidth(List editparts) {
		return getRightPosition(editparts) - getLeftPosition(editparts);
	}

	protected int getNewHeight(List editparts) {
		return getBottomPosition(editparts) - getTopPosition(editparts);
	}

	/**
	 * changePosition Method to reset the position of all the children in
	 * UnitGroupCompartmentEditPart the new origin is maked by the smallest x and y of all the
	 * children
	 */
	protected void changePosition() {
		for (int i = 0; i < editparts.size(); i++) {
			if ((IGraphicalEditPart) editparts.get(i) instanceof DeployCoreCompartmentEditPart) {
				List editpartsOfUnitGroup = ((IGraphicalEditPart) editparts.get(i)).getChildren();
				if (editpartsOfUnitGroup.size() > 0) {
					//get the two smallest value of position
					int left = getLeftPosition(editpartsOfUnitGroup);
					int top = getTopPosition(editpartsOfUnitGroup);
					for (int j = 0; j < editpartsOfUnitGroup.size(); j++) {
						int currx = ((IGraphicalEditPart) editpartsOfUnitGroup.get(j)).getFigure()
								.getBounds().x;
						int curry = ((IGraphicalEditPart) editpartsOfUnitGroup.get(j)).getFigure()
								.getBounds().y;

						Node node = (Node) ((IGraphicalEditPart) editpartsOfUnitGroup.get(j)).getModel();
						Bounds bounds = (Bounds) node.getLayoutConstraint();

						bounds.setX(currx - left);
						bounds.setY(curry - top);
					}
				}
			}
		}
	}
}
