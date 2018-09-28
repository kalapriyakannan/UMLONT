/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import java.util.Iterator;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployResizableCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * @since 1.0
 * 
 */
public class DeployListCompartmentFigure extends DeployResizableCompartmentFigure {

	protected boolean isInnerList = false;
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	protected static final int INVISIBLE = 0;
	protected static final int VISIBLE = 1;
	protected static final int PARTIAL = 2;
	private static Rectangle overlapRect = new Rectangle();

	/**
	 * @param isInner
	 * @param compartmentTitle
	 * @param mm
	 */
	public DeployListCompartmentFigure(boolean isInner, String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);

		isInnerList = isInner;
		setOpaque(true);
		setBackgroundColor(DeployColorConstants.white);
		if (!isInnerList) {
			setBorder(new LineBorder(DeployColorConstants.groupCompartmentGray));
		} else {
			setBorder(null);
		}
		// don't show scroll bar on inner list items
		getScrollPane().setVerticalScrollBarVisibility(
				isInnerList ? ScrollPane.NEVER : ScrollPane.AUTOMATIC);
		scrollPane.getViewport().setContentsTracksHeight(isInnerList);
	}

	@Override
	public void expand() {
		super.expand();
		// don't show scroll bar on inner list items
		getScrollPane().setVerticalScrollBarVisibility(
				isInnerList ? ScrollPane.NEVER : ScrollPane.AUTOMATIC);
	}

	@Override
	public void setExpanded() {
		super.setExpanded();
		// don't show scroll bar on inner list items
		getScrollPane().setVerticalScrollBarVisibility(
				isInnerList ? ScrollPane.NEVER : ScrollPane.AUTOMATIC);
	}

	public void paint(Graphics g) {

		switch (getCompartmentVisibility())
		{
		case INVISIBLE:
			return;
		case PARTIAL:
			Rectangle rect = new Rectangle();
			g.getClip(rect);
			g.clipRect(overlapRect);
			break;
		case VISIBLE:
		default:
		}

		super.paint(g);
	}

	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		switch (getCompartmentVisibility())
		{
		case INVISIBLE:
			return null;
		case PARTIAL:
		case VISIBLE:
		default:
		}
		return super.findFigureAt(x, y, search);
	}

	/*
	 * don't draw border when an inner list
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintBorder(Graphics g) {
		if (!isInnerList) {
			super.paintBorder(g);
		}
	}

	/**
	 * @return the height of this list used in get preferred height
	 */
	@SuppressWarnings("unchecked")
	public int getListHeight() {
		if (!this.isExpanded()) {
			return 0;
		}

		int height = 0;
		CompositeShapeFigure firstFigure = findFirstChild(this);
		if (firstFigure == null) {
			return 0;
		}
		Iterator<CompositeShapeFigure> it = firstFigure.getParent().getChildren().iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof CompositeShapeFigure) {
				CompositeShapeFigure composite = (CompositeShapeFigure) o;
				DeployListItemFigure listFigure = (DeployListItemFigure) composite.getInnerFigure();
				height += listFigure.getPreferredSize(-1, -1).height;
			}
		}
		return height;
	}

	// dig down till we reach first composite
	@SuppressWarnings("unchecked")
	private CompositeShapeFigure findFirstChild(IFigure figure) {
		if (figure instanceof CompositeShapeFigure) {
			return (CompositeShapeFigure) figure;
		}
		Iterator<IFigure> it = figure.getChildren().iterator();
		while (it.hasNext()) {
			CompositeShapeFigure f = findFirstChild(it.next());
			if (f != null) {
				return f;
			}
		}
		return null;
	}

	/**
	 * @return is this an inner list
	 */
	public boolean isInnerList() {
		return isInnerList;
	}

	private int getCompartmentVisibility() {
		// get this compartment in terms of absolutes
		Rectangle refRect = this.getBounds().getCopy();
		this.translateToAbsolute(refRect);
		overlapRect.setSize(0, 0);

		IFigure walker = this.getParent();
		while (walker != null) {
			if (!walker.isVisible()) {
				return INVISIBLE;
			}
			// walk up until we get to the top list figure
			if (walker instanceof DeployListCompartmentFigure
					&& !((DeployListCompartmentFigure) walker).isInnerList()) {

				Rectangle parentClientArea = walker.getClientArea().getCopy();
				walker.translateToAbsolute(parentClientArea);
				if (!parentClientArea.contains(refRect)) {
					overlapRect = parentClientArea.getIntersection(refRect);
					if (overlapRect.isEmpty()) {
						return INVISIBLE;
					}
					this.translateToRelative(overlapRect);
					return PARTIAL;
				}
			}
			walker = walker.getParent();
		}
		return VISIBLE;
	}

}
