/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PopUpHelper;
import org.eclipse.draw2d.ToolTipHelper;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;

/**
 * @author jswanke
 * 
 */
public class DeployToolTipHelper extends ToolTipHelper {

	private boolean firstTime = true;
	private IFigure currentTipSource;

	private class ToolTipJob extends UIJob {

		/**
		 * Create a job for displaying tooltip: delay on opening and then keep open 3 minutes
		 */
		public ToolTipJob(DeployToolTipHelper tooltip) {
			super("Display tooltip"); //$NON-NLS-1$
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (!getShell().isDisposed()) {
				if (firstTime) {
					firstTime = false;
					show();
					schedule(3 * 60000); //leave up for 3 minutes
				} else {
					hide();
				}
			}
			return Status.OK_STATUS;
		}

	};

	private final ToolTipJob _tooltipJob = new ToolTipJob(this);

	/**
	 * @param c
	 */
	public DeployToolTipHelper(Control c) {
		super(c);
	}

	/**
	 * Disposes of the tooltip's shell and kills the timer.
	 * 
	 * @see PopUpHelper#dispose()
	 */
	public void dispose() {
		_tooltipJob.cancel();
		if (isShowing()) {
			hide();
		}
		getShell().dispose();
	}

	/**
	 * close tooltip
	 */
	public void close() {
		_tooltipJob.cancel();
		hide();
	}

	public void displayToolTipNear(IFigure hoverSource, IFigure tip, int eventX, int eventY) {
		boolean isOnList = hoverSource instanceof DeployListItemFigure
				|| hoverSource instanceof CompositeShapeFigure
				&& ((CompositeShapeFigure) hoverSource).getInnerFigure() instanceof DeployListItemFigure;
		if (isOnList && !(hoverSource instanceof DeployListItemFigure)) {
			hoverSource = ((CompositeShapeFigure) hoverSource).getInnerFigure();
		}
		if (tip != null && hoverSource != currentTipSource) {
			getLightweightSystem().setContents(tip);
			Point displayPoint = computeWindowLocation(tip, hoverSource, isOnList, eventX, eventY);
			Dimension shellSize = getLightweightSystem().getRootFigure().getPreferredSize()
					.getExpanded(getShellTrimSize());
			setShellBounds(displayPoint.x, displayPoint.y, shellSize.width, shellSize.height);
			currentTipSource = hoverSource;
			firstTime = true;
			_tooltipJob.cancel();
			_tooltipJob.schedule(isOnList ? 300 : 100); //longer delay on tree items
		}
	}

	private Point computeWindowLocation(IFigure tip, IFigure hoverSource, boolean isOnList,
			int eventX, int eventY) {
		org.eclipse.swt.graphics.Rectangle clientArea = control.getDisplay().getClientArea();
		Point preferredLocation = new Point(eventX, eventY + 26);
		if (isOnList && hoverSource.getBounds() != null && hoverSource.getParent() != null) {
			Rectangle r = hoverSource.getBounds().getCopy();
			hoverSource.translateToAbsolute(r);
			preferredLocation = control.toDisplay(r.getRight().x, r.getTop().y - 12);
		}

		Dimension tipSize = getLightweightSystem().getRootFigure().getPreferredSize().getExpanded(
				getShellTrimSize());

		// Adjust location if tip is going to fall outside display
		if (preferredLocation.y + tipSize.height > clientArea.height) {
			preferredLocation.y = eventY - tipSize.height;
		}

		if (preferredLocation.x + tipSize.width > clientArea.width) {
			preferredLocation.x -= preferredLocation.x + tipSize.width - clientArea.width;
		}

		return preferredLocation;
	}

	public void updateToolTip(IFigure figureUnderMouse, IFigure tip, int eventX, int eventY) {
		/*
		 * If the cursor is not on any Figures, it has been moved off of the control. Hide the tool
		 * tip.
		 */
		if (figureUnderMouse == null) {
			if (isShowing()) {
				hide();
				_tooltipJob.cancel();
			}
		}
		// Makes tooltip appear without a hover event if a tip is currently being displayed
		if (isShowing() && figureUnderMouse != currentTipSource) {
			hide();
			_tooltipJob.cancel();
			displayToolTipNear(figureUnderMouse, tip, eventX, eventY);
		} else if (!isShowing() && figureUnderMouse != currentTipSource) {
			currentTipSource = null;
		}
	}

	/**
	 * @see PopUpHelper#hookShellListeners()
	 */
	protected void hookShellListeners() {
		// Close the tooltip window if the mouse enters the tooltip
		getShell().addMouseTrackListener(new MouseTrackAdapter() {
			public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
				hide();
				currentTipSource = null;
				_tooltipJob.cancel();
			}
		});
	}

}
