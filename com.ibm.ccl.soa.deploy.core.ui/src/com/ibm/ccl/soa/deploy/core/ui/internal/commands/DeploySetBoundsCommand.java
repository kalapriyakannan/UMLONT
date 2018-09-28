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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DragFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;

/**
 * @author jswanke
 * 
 */
public class DeploySetBoundsCommand extends SetBoundsCommand {

	private final IAdaptable adapter;
	private final Point location;
	private final Dimension size;
	private List noLayoutList;
	private DeployDiagramEditPart _ddep;

	// undo for snap groups
	private boolean _isSnapGroupResize = false;
	private EditPartViewer _viewer;
	private View _view;
	private Rectangle _newBounds;
	private Rectangle _oldBounds;

	// undo/redo snap arrange

	/**
	 * @param editingDomain
	 * @param label
	 * @param adapter
	 * @param bounds
	 */
	public DeploySetBoundsCommand(TransactionalEditingDomain editingDomain, String label,
			IAdaptable adapter, Rectangle bounds) {
		super(editingDomain, label, adapter, bounds);
		this.adapter = adapter;
		location = bounds.getLocation();
		size = bounds.getSize();

		// create a list of views that shouldn't be laid out
		if (ResourceUtils.getActiveDeployEditDomain() != null) {
			_ddep = (DeployDiagramEditPart) ResourceUtils.getActiveDeployEditDomain()
					.getDiagramEditPart();
			_viewer = _ddep.getViewer();
			for (Iterator it = _ddep.getMoveFeedbackMap().values().iterator(); it.hasNext();) {
				DragFeedbackFigure fig = (DragFeedbackFigure) it.next();
				if (!fig.isInsideMoveCommand()) {
					if (noLayoutList == null) {
						noLayoutList = new ArrayList();
					}
					noLayoutList.add(fig.getMovedView());
				}
			}
		}
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		if (adapter == null) {
			return CommandResult
					.newErrorCommandResult("SetBoundsCommand: viewAdapter does not adapt to IView.class"); //$NON-NLS-1$
		}

		_view = (View) adapter.getAdapter(View.class);
		if (_view == null) {
			return CommandResult.newOKCommandResult();
		}

		// determine old bounds and new
		Point oldLocation = new Point();
		oldLocation.x = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(_view, NotationPackage.eINSTANCE.getLocation_X()))
				.intValue();
		oldLocation.y = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(_view, NotationPackage.eINSTANCE.getLocation_Y()))
				.intValue();
		final Dimension oldSize = new Dimension(-1, -1);
		oldSize.width = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(_view, NotationPackage.eINSTANCE.getSize_Width()))
				.intValue();
		oldSize.height = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(_view, NotationPackage.eINSTANCE.getSize_Height()))
				.intValue();
		_oldBounds = new Rectangle(oldLocation.x, oldLocation.y, oldSize.width, oldSize.height);
		_newBounds = _oldBounds.getCopy();

		if (location != null) {
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_view,
					NotationPackage.eINSTANCE.getLocation_X(), new Integer(location.x));
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_view,
					NotationPackage.eINSTANCE.getLocation_Y(), new Integer(location.y));
			_newBounds.setLocation(location);
		}
		int collapseMode = -1;
		if (size != null) {
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_view,
					NotationPackage.eINSTANCE.getSize_Width(), new Integer(size.width));
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_view,
					NotationPackage.eINSTANCE.getSize_Height(), new Integer(size.height));

			// also save in DeployStyle
			if (!oldSize.equals(size)) {
				collapseMode = thresholdToggleCompartment(_view, size);
			}

			_newBounds.setSize(size);
		}

		// layout the views surrounding this newly resize/located view
		// unless the view was moved/copied to another container 
		if (noLayoutList == null || !noLayoutList.contains(_view)) {
			// normal move/resize-- do layout
			Dimension newSize = size != null ? size.getCopy() : oldSize;
			Point newLocation = location != null ? location.getCopy() : oldLocation;
			LayoutUtils.layoutViews(getEditingDomain(), _view, oldLocation, newLocation, oldSize,
					newSize, null, false, collapseMode);
		}

		// if in snap group, realign everything after resize
		if (_oldBounds.getSize() != _newBounds.getSize()) {
			DeployStyle style = (DeployStyle) _view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getSnapParent() != null && _ddep != null) {
				_isSnapGroupResize = true;
				ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(getEditingDomain(), _view,
						_oldBounds, 0, _viewer);
			}
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * collapse or expand compartment based on its new size
	 * 
	 * @param view
	 * @param size
	 * @return layout mode
	 */
	static public int thresholdToggleCompartment(View view, Dimension size) {
		int collapseMode = LayoutUtils.RESIZE;
		View compartment = ViewUtil.getCompartmentView(view);
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (compartment != null && style != null) {
			Boolean isCollapsed = (Boolean) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(compartment, NotationPackage.eINSTANCE
							.getDrawerStyle_Collapsed());
			style.setCollapseWidth(size.width);
			style.setExpandWidth(size.width);
			boolean isCollapse = size.height < DeployCoreConstants.SERVER_UNIT_HEIGHT * 3 / 2;
			boolean isExpand = size.height > DeployCoreConstants.SERVER_UNIT_HEIGHT * 3 / 2;
			if (isCollapse && !isCollapsed) {
				style.setCollapseHeight(size.height);
				collapseCompartment(compartment, true);
				collapseMode = LayoutUtils.COLLAPSE;
			} else if (isExpand && isCollapsed) {
				style.setExpandHeight(size.height);
				collapseCompartment(compartment, false);
				collapseMode = LayoutUtils.EXPAND;
			} else {
				if (isCollapsed) {
					style.setCollapseHeight(size.height);
				} else {
					style.setExpandHeight(size.height);
				}
			}
		}
		return collapseMode;
	}

	static private void collapseCompartment(View compartmentView, boolean isCollapse) {
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(compartmentView,
				NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), (isCollapse ? Boolean.TRUE
						: Boolean.FALSE));
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doRedo(monitor, info);
		if (_isSnapGroupResize) {
			ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(getEditingDomain(), _view,
					_oldBounds, 0, _viewer);
		}
		return status;
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doUndo(monitor, info);
		if (_isSnapGroupResize) {
			ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(getEditingDomain(), _view,
					_newBounds, 0, _viewer);
		}
		return status;
	}
}
