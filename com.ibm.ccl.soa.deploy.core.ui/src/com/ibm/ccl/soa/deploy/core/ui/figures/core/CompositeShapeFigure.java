/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.ui.figures.IFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.NodeFigureEx;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Wrapper that contains the real figure and the service compartments. This is required to allow the
 * main figure's layout manager to ignore the service compartments.
 */
public class CompositeShapeFigure extends NodeFigureEx implements IFeedbackFigure {

	private CompartmentFigure outerFigure;
	private final IFigure mainFigure;
	private String feedbackState;
	private boolean isFaded = false;

	private IFigure hoverHiliteFigure;
	private IFigure associatedHiliteFigure;
	private IFigure handlerLayer;

	private final Object lock = new Object();

	private boolean enableDecoratorButton = false;
	private static long UPDATE_DELAY = 250;
	private static long START_DELAY = 20;

	private static class RefreshJob extends UIJob {

		private final ListenerList queue = new ListenerList() {

			public synchronized Object[] getListeners() {
				Object[] data = super.getListeners();
				clear();
				return data;

			}
		};

		public RefreshJob() {
			super("Clear Tooltip Text"); //$NON-NLS-1$ 
			setSystem(true);
		}

		/**
		 * Enqueue the given resource for refresh in the viewer. Refreshes affect the given node and
		 * the children for the node.
		 * 
		 * @param refeshable
		 *           A non-null object to refresh in the viewer.
		 */
		public void start(Runnable refeshable) {
			queue.add(refeshable);
			schedule(START_DELAY);
		}

		/**
		 * Enqueue the given resource for refresh in the viewer. Refreshes affect the given node and
		 * the children for the node.
		 * 
		 * @param refeshable
		 *           A non-null object to refresh in the viewer.
		 */
		public void update(Runnable refeshable) {
			queue.add(refeshable);
			schedule(UPDATE_DELAY);
		}

		public IStatus runInUIThread(IProgressMonitor monitor) {

			// refresh the viewer for the given objects in the queue 

			Object[] refreshables = queue.getListeners();
			try {
				for (int i = 0; i < refreshables.length; i++) {
					((Runnable) refreshables[i]).run();
				}

			} finally {

				monitor.done();
			}
			return Status.OK_STATUS;
		}
	};

	private static RefreshJob refreshJob = new RefreshJob();

	private final Runnable hideHoverHiliteRunnable = new Runnable() {
		public void run() {
//			System.out.println("Hiding hover hilite for " + this + " : " + hoverHiliteFigure); //$NON-NLS-1$ //$NON-NLS-2$
			if (hoverHiliteFigure != null && handlerLayer != null) {
				// is mouse still on this figure?
				if (isMouseOnFigure(CompositeShapeFigure.this)) {
					enableDecoratorButton = true; // ++highliteCounter[0] > 5; ???
					// make sure it's visible (initially created invisible to avoid flashing
					hoverHiliteFigure.setVisible(true);
					refreshJob.update(this);
				} else {
					hoverHiliteFigure.setVisible(false);
					// if mouse is off figure, hide the hilite
					handlerLayer.remove(hoverHiliteFigure);
					hoverHiliteFigure = null;
					enableDecoratorButton = false;
				}
			}
		}
	};

	/**
	 * Creates a new ClassiferNodeFigire figure.
	 * 
	 * @param elementFig
	 *           the figure to use with this figure
	 */
	public CompositeShapeFigure(IFigure elementFig) {
		setOpaque(false); // set transparent by default
		setBorder(null);
		setLayoutManager(null);
		mainFigure = elementFig;

		add(getInnerFigure());
		add(getOuterFigure());

		setBounds(elementFig.getBounds().getCopy());
		getOuterFigure().setBounds(new Rectangle(0, 0, 1, 1));
	}

	/**
	 * 
	 * @return The Point pane
	 */
	public CompartmentFigure getOuterFigure() {
		if (outerFigure == null) {
			outerFigure = new CompartmentFigure();
			outerFigure.setLayoutManager(new DelegatingLayout());
			outerFigure.setVisible(true);
		}
		return outerFigure;
	}

	/**
	 * 
	 * @return The "main" figure
	 */
	public IFigure getInnerFigure() {
		return mainFigure;
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#getClientArea(Rectangle)
	 */
	public Rectangle getClientArea(Rectangle rect) {
		if (mainFigure != null) {
			return mainFigure.getClientArea(rect);
		}
		return super.getClientArea(rect);
	}

	/**
	 * gets the handle bounds of the main figure
	 * 
	 * @return the hnalde bounds
	 * @see org.eclipse.gef.handles.HandleBounds#getHandleBounds()
	 */
	public Rectangle getHandleBounds() {
		if (mainFigure instanceof NodeFigure) {
			return ((NodeFigure) mainFigure).getHandleBounds().getCopy();
		}
		return mainFigure.getBounds().getCopy();
	}

	/**
	 * Give the main figure the entire bounds of the wrapper.
	 */
	protected void layout() {
		if (!this.getBounds().equals(mainFigure.getBounds())) {
			mainFigure.setBounds(this.getBounds().getCopy());
		}
		// When parent resizes, cause the Points to be relocated.
		getOuterFigure().invalidateTree();
		erase();
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#containsPoint(int, int) We need to override this for smooth
	 *      painting of Point items.
	 */
	public boolean containsPoint(int x, int y) {
		if (outerFigure.containsPoint(x, y)) {
			return true;
		}
		return super.containsPoint(x, y);
	}

	protected void primTranslate(int dx, int dy) {
		super.primTranslate(dx, dy);
		erase();
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#erase()
	 */
	public void erase() {
		super.erase();
		if (outerFigure != null) {
			outerFigure.erase();
		}
	}

	/**
	 * Refresh adornments
	 */
	public void repaint() {
		super.repaint();
		if (outerFigure != null) {
			outerFigure.repaint();
		}
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		IFigure result = outerFigure.findFigureAt(x, y, search);
		if (result != null) {
			return result;
		}
		return mainFigure.findFigureAt(x, y, search);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findMouseEventTargetAt(int x, int y) {
		IFigure PointFigure = outerFigure.findMouseEventTargetAt(x, y);
		if (PointFigure != null) {
			return PointFigure;
		}
		return super.findMouseEventTargetAt(x, y);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#intersects(Rectangle)
	 */
	public boolean intersects(Rectangle rect) {
		if (outerFigure.intersects(rect)) {
			return true;
		}
		return super.intersects(rect);
	}

	/**
	 * @see IFigure#getMinimumSize(int, int)
	 */
	public Dimension getMinimumSize(int wHint, int hHint) {
		return mainFigure.getMinimumSize(wHint, hHint);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		return mainFigure.getPreferredSize(wHint, hHint);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#getToolTip()
	 */
	public IFigure getToolTip() {
		return mainFigure.getToolTip();
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#setToolTip(IFigure)
	 */
	public void setToolTip(IFigure f) {
		mainFigure.setToolTip(f);
	}

	/**
	 * Returns a new anchor for this node figure.
	 * 
	 * @param p
	 *           Point on the figure that gives a hint which anchor to return.
	 * @return ConnectionAnchor reference to an anchor associated with the given point on the figure.
	 */
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		if (mainFigure instanceof NodeFigure) {
			return ((NodeFigure) mainFigure).getSourceConnectionAnchorAt(p);
		}
		return super.getSourceConnectionAnchorAt(p);
	}

	/*
	 * @see com.ibm.xtools.gef.ui.figures.NodeFigure#getTargetConnectionAnchorAt(org.eclipse.draw2d.geometry.Point)
	 */
	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		if (mainFigure instanceof NodeFigure) {
			return ((NodeFigure) mainFigure).getTargetConnectionAnchorAt(p);
		}
		return super.getTargetConnectionAnchorAt(p);
	}

	/*
	 * @see com.ibm.xtools.gef.ui.figures.NodeFigure#getConnectionAnchor(java.lang.String)
	 */
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		if (mainFigure instanceof NodeFigure) {
			return ((NodeFigure) mainFigure).getConnectionAnchor(terminal);
		}
		return super.getConnectionAnchor(terminal);
	}

	/*
	 * @see com.ibm.xtools.gef.ui.figures.NodeFigure#getConnectionAnchorTerminal(org.eclipse.draw2d.ConnectionAnchor)
	 */
	public String getConnectionAnchorTerminal(ConnectionAnchor c) {
		if (mainFigure instanceof NodeFigure) {
			return ((NodeFigure) mainFigure).getConnectionAnchorTerminal(c);
		}
		return super.getConnectionAnchorTerminal(c);
	}

	public String getFeedbackState() {
		return feedbackState;
	}

	public void setFeedbackState(String state) {
		feedbackState = state;

		if (STATE_HOVER.equals(state)) {
			showHoverHilite();
		} else if (STATE_TARGET.equals(state)) {
			showHoverHilite();
		} else if (STATE_LINK_SELECTED.equals(state)) {
			showAssociatedHilite(DeployColorConstants.associatedInner,
					DeployColorConstants.associatedOuter);
		} else if (STATE_LINK_UNSELECTED.equals(state)) {
			hideAssociatedHilite();
		} else if (STATE_DUP_SELECTED.equals(state)) {
			showAssociatedHilite(DeployColorConstants.dupInner, DeployColorConstants.dupOuter);
		} else if (STATE_DUP_UNSELECTED.equals(state)) {
			hideAssociatedHilite();
		}
	}

	private void showHoverHilite() {
		if (hoverHiliteFigure != null || GEFUtils.getEditpart(this) == null) {
			return;
		}

//		System.out.println("Showing hover hilite for " + this + " : " + hoverHiliteFigure); //$NON-NLS-1$ //$NON-NLS-2$

		final IFigure shape = this;
		final GraphicalEditPart ep = GEFUtils.getEditpart(shape);
		if (ep != null) {
			hoverHiliteFigure = new AbstractHandle(ep, new Locator() {
				public void relocate(IFigure target) {
					IFigure figure = shape;
					Rectangle r = ((HandleBounds) figure).getHandleBounds().getCopy();
					shape.translateToAbsolute(r);
					target.translateToRelative(r);
					target.setBounds(r);
				}
			}) {
				{
					setBorder(new DeployLineBorder(DeployColorConstants.hiliteInner,
							DeployColorConstants.hiliteOuter, (GMFUtils.isInList(ep) ? 1 : 2), shape));
				}

				// make us invisible to mouse
				public boolean containsPoint(int x, int y) {
					return false;
				}

				// if user selects ep, create selection handles, etc.
				protected DragTracker createDragTracker() {
					return null;
				}
			};
		}
		/*
		 * initially invisible to avoid flashing
		 */
		hoverHiliteFigure.setVisible(false);
		handlerLayer = GEFUtils.getLayer(ep, LayerConstants.HANDLE_LAYER);
		if (handlerLayer != null) {
			int assocInx = handlerLayer.getChildren().indexOf(associatedHiliteFigure) + 1;
			handlerLayer.add(hoverHiliteFigure, assocInx);
			hideHoverHiliteAfterDelay(ep);
		}
	}

	private void hideHoverHiliteAfterDelay(final GraphicalEditPart ep) {
		// final int[] highliteCounter = new int[] { 0 }; ???
//		System.out.println("Queueing hilite removal"); //$NON-NLS-1$
		refreshJob.start(hideHoverHiliteRunnable);
	}

	private void showAssociatedHilite(final Color innerClr, final Color outerClr) {
		synchronized (lock) {
			if (associatedHiliteFigure != null) {
				return;
			}

			final IFigure shape = this;
			final GraphicalEditPart ep = GEFUtils.getEditpart(shape);
			if (ep != null) {
				Locator locator = new Locator() {
					public void relocate(IFigure target) {
						IFigure figure = shape;
						Rectangle r = ((HandleBounds) figure).getHandleBounds().getCopy();
						shape.translateToAbsolute(r);
						target.translateToRelative(r);
						target.setBounds(r);
					}
				};
				associatedHiliteFigure = new AbstractHandle(ep, locator) {
					{
						setBorder(new DeployLineBorder(innerClr, outerClr, 2, shape));
					}

					// make us invisible to mouse
					public boolean containsPoint(int x, int y) {
						return false;
					}

					// if user selects ep, create selection handles, etc.
					protected DragTracker createDragTracker() {
						return null;
					}
				};
				handlerLayer = GEFUtils.getLayer(ep, LayerConstants.HANDLE_LAYER);
				handlerLayer.add(associatedHiliteFigure, 0);
			}
		}
	}

	private void hideAssociatedHilite() {
		synchronized (lock) {

			if (associatedHiliteFigure != null && handlerLayer != null) {
				handlerLayer.remove(associatedHiliteFigure);
				associatedHiliteFigure = null;
			}
		}
	}

	private boolean isMouseOnFigure(IFigure thisFigure) {
		boolean isOnShape = false;
		Control control = Display.getCurrent().getCursorControl();
		if (control != null) {
			Point pt = new Point(control.toControl(Display.getCurrent().getCursorLocation()));
			translateToRelative(pt);
			IFigure fig = findFigureAt(pt);
			CompositeShapeFigure csf = getParentComposite(fig);
			isOnShape = csf == thisFigure;
		}
		return isOnShape;
	}

	private CompositeShapeFigure getParentComposite(IFigure figure) {
		IFigure walker = figure;
		while (walker != null) {
			if (walker instanceof CompositeShapeFigure) {
				return (CompositeShapeFigure) walker;
			}
			walker = walker.getParent();
		}
		return (CompositeShapeFigure) figure;
	}

	@Override
	public void removeNotify() {
		super.removeNotify();
		hideAssociatedHilite();
	}

	/**
	 * @param isFaded
	 */
	public void setFaded(boolean isFaded) {
		this.isFaded = isFaded;
	}

	/**
	 * @return isFaded
	 */
	public boolean isFaded() {
		return isFaded;
	}

	// unused
	public void setFeedbackState(String state, Color fbColor) {
	}

	public Rectangle getFeedbackFigureBounds() {
		return null;
	}

	public boolean isEnableDecoratorButton() {
		return true;//enableDecoratorButton;
	}

}
