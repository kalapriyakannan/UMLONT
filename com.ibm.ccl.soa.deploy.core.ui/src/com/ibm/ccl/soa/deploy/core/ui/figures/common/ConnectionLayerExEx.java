/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;

/**
 * @author jswanke
 * 
 */
public class ConnectionLayerExEx extends ConnectionLayerEx {
	public final static int Q = MapModeUtil.getMapMode().DPtoLP(1);

	// cross under
	private final Set<IFigure> _overlappedFigureSet = new HashSet<IFigure>();
	private final Map<IFigure, List<PolylineConnectionExEx>> _backfillFigureMap = new HashMap<IFigure, List<PolylineConnectionExEx>>();
	private final List<IFigure> _redrawnFigureList = new ArrayList<IFigure>();

	// offscreen connection label
	private DiagramEditPart _diagramEditPart = null;
	private Viewport _port = null;
	private boolean _inFlux = false;

	private class RefreshLabelsJob extends UIJob {
		ConnectionLayerExEx _layer;

		/**
		 * Create a job for refreshing offscreen link labels
		 */
		public RefreshLabelsJob() {
			super("Refresh offscreen link labels"); //$NON-NLS-1$
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			updateConnectionLabels();
			_inFlux = false;
			return Status.OK_STATUS;
		}

	};

	private final RefreshLabelsJob _refreshLabelsJob = new RefreshLabelsJob();

	/**
	 */
	public ConnectionLayerExEx() {
		super();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// CROSS UNDER CONNECTION SUPPORT ///////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	protected void paintChildren(Graphics graphics) {
		super.paintChildren(graphics);

		// don't enlarge clip rect when painting which is what super class does
		boolean isMousePressed = _diagramEditPart instanceof DeployDiagramEditPart
				&& ((DeployDiagramEditPart) _diagramEditPart).isMousePressed();
		Rectangle clip = Rectangle.SINGLETON;
		for (int i = 0; i < getChildren().size(); i++) {
			IFigure child = (IFigure) getChildren().get(i);
			if (child.isVisible() && child.intersects(graphics.getClip(clip))) {
				// if mouse is pressed, just update area around moved editpart
				if (isMousePressed) {
					child.paint(graphics);
				} else {
					// else update entire link so that it doesn't appear broken
					graphics.clipRect(child.getBounds());
					child.paint(graphics);
					graphics.restoreState();
				}
			}
		}

		// repaint the figures that were painted over by any connections
		_redrawnFigureList.clear();
		for (Iterator<IFigure> it = _overlappedFigureSet.iterator(); it.hasNext();) {
			IFigure child = it.next();
			if (child != null && child.isVisible() && child.intersects(graphics.getClip(clip))) {

				// first draw a white background 1 pixel bigger then figure so that
				// connections don't seem to go to this figure
				Rectangle r = child.getBounds().getCopy().expand(Q, Q);
				graphics.clipRect(r);
				graphics.setBackgroundColor(ColorConstants.white);
				graphics.fillRectangle(r);
				child.paint(graphics);
				_redrawnFigureList.add(child);

				// now repaint any connections that go to/into just this figure (and not pass totally underneath)
				// these links are drawn clipped to the figure so just the part that appears on the figure is redrawn
				//  otherwise to repaint the whole connection would have it potentially cross over another figure again;
				// backfillFigureMap is maintained by the PolylineConnectionExEx class
				List<PolylineConnectionExEx> backfillList = _backfillFigureMap.get(child);
				if (backfillList != null) {
					for (PolylineConnectionExEx conn : backfillList) {
						conn.setBackfillMode(true);
						conn.paint(graphics);
						conn.setBackfillMode(false);
					}
				}
				graphics.restoreState();
			}
		}

		// now restore the Z-order of any figure that was repainted; IOW, a figure that was redrawn over a link, which itself had
		// a figure drawn over it
		if (_redrawnFigureList.size() > 0) {
			IFigure df = getDiagramFigure();
			if (df != null) {
				for (IFigure child : _redrawnFigureList) {
					Rectangle r = child.getBounds();

					// see if this figure overlapped another
					boolean isPastChildInHierarchy = false;
					for (Iterator<?> it = df.getChildren().iterator(); it.hasNext();) {
						IFigure fig = (IFigure) it.next();
						if (!isPastChildInHierarchy) {
							isPastChildInHierarchy = fig.equals(child);
							continue;
						} else {
							if (r.intersects(fig.getBounds())) {
								Rectangle or = fig.getBounds();
								graphics.clipRect(or);
								graphics.setBackgroundColor(ColorConstants.white);
								graphics.fillRectangle(or);
								fig.paint(graphics);
								graphics.restoreState();
							}
						}
					}
				}
			}
		}
		_overlappedFigureSet.clear();
		_backfillFigureMap.clear();

		// finally, repaint connections that have been request to be on top (due to selection);
		List<?> children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			if (child.isVisible() && child.intersects(graphics.getClip(clip))) {
				if (child instanceof PolylineConnectionExEx
						&& ((PolylineConnectionExEx) child).isBringToFront()) {
					graphics.clipRect(child.getBounds());
					child.paint(graphics);
					graphics.restoreState();
				}
			}
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// OFFSCREEN CONNECTION LABEL SUPPORT ///////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param diagramEditPart
	 */
	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		_diagramEditPart = diagramEditPart;
		_port = _diagramEditPart.getViewport();
		_port.getHorizontalRangeModel().addPropertyChangeListener(changeListener);
		_port.getVerticalRangeModel().addPropertyChangeListener(changeListener);
	}

	private final PropertyChangeListener changeListener = new PropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent event) {
			if (!_inFlux) {
				removeConnectionLabels(false);
			}
			_inFlux = true;
			_refreshLabelsJob.cancel();
			_refreshLabelsJob.schedule(500);
		}
	};

	@Override
	protected void layout() {
		super.layout();
		removeConnectionLabels(true);
	}

	// add necessary link labels
	protected void updateConnectionLabels() {
		// update link labels on each link
		List children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			if (child instanceof PolylineConnectionExEx) {
				PolylineConnectionExEx conn = (PolylineConnectionExEx) child;
				conn.updateConnectionLabel();
			}
		}
	}

	// erase any link feedback
	protected void removeConnectionLabels(boolean forceRedraw) {
		List children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			if (child instanceof PolylineConnectionExEx) {
				((PolylineConnectionExEx) child).removeConnectionLabels(forceRedraw);
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// SETTERS/GETTERS  ///////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * overlappedFigureSet is filled by PolylineConnectionExEx with figures that overlap it so that
	 * they can be redrawn here
	 * 
	 * @return set of figures overlapped by links
	 */
	public Set<IFigure> getOverlappedFigureSet() {
		return _overlappedFigureSet;
	}

	/**
	 * backfillFigureMap is filled in by PolylineConnectionExEx with the owners of their links so
	 * that after a figure is redrawn here, its connections are redrawn too
	 * 
	 * @return backfillFigureMap
	 */
	public Map<IFigure, List<PolylineConnectionExEx>> getBackfillFigureMap() {
		return _backfillFigureMap;
	}

	/**
	 * @return diagram's figure
	 */
	public DiagramFigure getDiagramFigure() {
		return (DiagramFigure) _diagramEditPart.getFigure();
	}

}
