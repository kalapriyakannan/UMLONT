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
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * This Figure represents a listed Unit
 */
public class DeployListItemFigure extends NodeFigure {

	static private Font duplicateIndexFont = new Font(null, new FontData("Tahoma", 8, SWT.NORMAL));//$NON-NLS-1$
	private String duplicateIndex = null;
	private int nameWidth = 0;
	private boolean isInnerList = false;

	private static final int FIRST = 0;
	private static final int MIDDLE = 1;
	private static final int LAST = 2;
	private static final int ONLY = 3;
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	public static final int IMPORT_NO_STATE = 0;
	public static final int IMPORT_FORIEGN_UNIT = 1;
	private int importStatus = IMPORT_NO_STATE;

	private boolean isConceptual = false;

	private boolean isFaded = false;
	private EObject element = null;

	/**
	 * @return figure's element
	 */
	public EObject getElement() {
		return element;
	}

	/**
	 * allow figure to know it's element
	 * 
	 * @param element
	 */
	public void setElement(EObject element) {
		this.element = element;
	}

	/**
	 * Figure constructor
	 * 
	 * @param part
	 * 
	 */
	public DeployListItemFigure(DeployListCompartmentEditPart part) {
		setOpaque(true);
		if (part != null && part.getFigure() instanceof DeployListCompartmentFigure) {
			DeployListCompartmentFigure listFigure = (DeployListCompartmentFigure) part.getFigure();
			isInnerList = listFigure.isInnerList();
		}
		setBorder(null);
	}

	/**
	 * @param duplicateIndex
	 */
	public void setDuplicateIndex(String duplicateIndex) {
		if (this.duplicateIndex != duplicateIndex) {
			this.duplicateIndex = duplicateIndex;
			repaint();
		}
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		nameWidth = super.getPreferredSize(wHint, hHint).width + MapModeUtil.getMapMode().DPtoLP(16);
		// fixed height of a list item plus any inner list height
		Dimension dim = new Dimension(wHint, hHint);
		int listHeight = getListHeight();

		// get list item height based on height of name
		int itemHeight = GEFUtils.getListItemHeight(this);
		dim.height = itemHeight + (listHeight != 0 ? listHeight : Q);
		if (hasScrollbar()) {
			dim.width -= MapModeUtil.getMapMode().DPtoLP(11);
		}
		return dim;
	}

	private boolean hasScrollbar() {
		IFigure walker = this;
		while (walker != null) {
			if (walker instanceof ScrollPane) {
				ScrollPane sp = (ScrollPane) walker;
				return sp.getVerticalScrollBar().isVisible();
			}
			walker = walker.getParent();
		}
		return false;
	}

	/**
	 * @return actual preferred size
	 */
	public int getActualWidth() {
		// get name width
		int width = 0;

		// start with name width
		String name = GMFUtils.getDmoName(element);
		DeployWrapLabel label = GEFUtils.findWrapLabel(getChildren());
		if (name != null && name.length() > 0 && label != null) {
			width = org.eclipse.draw2d.FigureUtilities.getStringExtents(name, label.getFont()).width;
		}
		// add duplicate index width
		if (duplicateIndex != null && duplicateIndex.length() > 0) {
			width += org.eclipse.draw2d.FigureUtilities.getStringExtents(duplicateIndex,
					duplicateIndexFont).width;
		}

		// add space for icon at front and icons/links at the end
		width += 40;

		return MapModeUtil.getMapMode().DPtoLP(width);
	}

	/*
	 * simply locates the list of this item to call getListHeight() to get its size
	 */
	private int getListHeight() {
		if (getParent() instanceof CompositeShapeFigure) {
			CompositeShapeFigure parent = (CompositeShapeFigure) getParent();
			CompartmentFigure outerFigure = parent.getOuterFigure();
			List children = outerFigure.getChildren();
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i) instanceof DeployListCompartmentFigure) {
					DeployListCompartmentFigure listFigure = (DeployListCompartmentFigure) children
							.get(i);
					return listFigure.getListHeight();
				}
			}
		}
		return 0;
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = this.getBounds().getCopy();
		r.shrink(Q, Q);
		g.setBackgroundColor(DeployColorConstants.white);
		g.fillRectangle(r);
		int itemHeight = GEFUtils.getListItemHeight(this);

		if (isFaded) {
			g.setAlpha(DeployCoreConstants.SELECTION_FADE);
		}

		// draw import status
		if (importStatus == IMPORT_FORIEGN_UNIT) {
			Rectangle rx = r.getCopy();
			rx.height = itemHeight;
			g.setBackgroundColor(DeployColorConstants.lightYellow);
			g.fillRectangle(rx);
		}

		// paint tree lines
		paintTreeLines(g);

		// Draw the index string
		if (duplicateIndex != null && duplicateIndex.length() > 0) {
			g.setForegroundColor(DeployColorConstants.categoryColor);
			g.setFont(duplicateIndexFont);
			int xoffset = nameWidth + 5 * Q;
			g.drawString(duplicateIndex, r.x + xoffset, r.y + itemHeight / 2 - 8 * Q);
		}
	}

	private void paintTreeLines(Graphics g) {

		// get this figure's place in parent
		int order = getFigureOrder();
		if (order == ONLY) {
			return;
		}

		// setup
		Rectangle r = this.getBounds();
		g.pushState();
		g.setForegroundColor(ColorConstants.gray);
		g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] { 1, 1 });

		// draw a line from tree trunk to this branch
		int a = 4 * Q; // offset from left
		int b = GEFUtils.getListItemHeight(this) / 2;// offset from top
		int c = 16 * Q;// offset from right
		g.drawLine(r.x + a, r.y + b, r.x + c, r.y + b);

		// if this isn't the first branch, draw top of trunk
		if (order != FIRST) {
			g.drawLine(r.x + a, r.y, r.x + a, r.y + b);
		}

		// if this isn't the first branch, draw top of trunk
		if (order != LAST) {
			g.drawLine(r.x + a, r.y + b, r.x + a, r.y + r.height);
		}
		g.popState();

	}

	/*
	 * determine this figure's place in the list
	 */
	private int getFigureOrder() {
		int order = MIDDLE;
		if (getParent() instanceof CompositeShapeFigure) {
			CompositeShapeFigure parent = (CompositeShapeFigure) getParent();
			List list = parent.getParent().getChildren();
			int index = 0;
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof CompositeShapeFigure) {
					CompositeShapeFigure child = (CompositeShapeFigure) o;
					if (child.getInnerFigure() == this) {
						break;
					}
				}
				index++;
			}
			if (list.size() == 1 && !isInnerList) {
				order = ONLY;
			} else if (index == 0 && !isInnerList) {
				order = FIRST;
			} else if (index == list.size() - 1) {
				order = LAST;
			}
		}
		return order;
	}

	/**
	 * @param isFaded
	 */
	public void setFaded(boolean isFaded) {
		this.isFaded = isFaded;
	}

	/**
	 * @param importStatus --
	 *           if this item is in an import tree, display a special status
	 */
	public void setImportStatus(int importStatus) {
		this.importStatus = importStatus;
	}

	/**
	 * @return if figure represents a conceptual unit
	 */
	public boolean isConceptual() {
		return isConceptual;
	}

	/**
	 * @param conceptual --
	 *           if figure represents a conceptual unit
	 */
	public void setConceptual(boolean conceptual) {
		isConceptual = conceptual;
	}

	/**
	 * @return duplicate index
	 */
	public String getDuplicateIndex() {
		return duplicateIndex;
	}

}
