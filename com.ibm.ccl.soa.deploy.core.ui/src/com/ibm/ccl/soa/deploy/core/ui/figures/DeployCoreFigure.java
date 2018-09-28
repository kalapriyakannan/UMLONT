/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
/*
 */
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.NodeFigureEx;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @since 1.0
 * 
 */
public class DeployCoreFigure extends NodeFigure {
	private static final Dimension SIZE = new Dimension(DeployCoreConstants.SERVER_UNIT_WIDTH,
			DeployCoreConstants.SERVER_UNIT_HEIGHT);
	private static final Dimension NAMESPACER = new Dimension(MapModeUtil.getMapMode().DPtoLP(22),
			MapModeUtil.getMapMode().DPtoLP(10));
	private static final int NAMEHEIGHT = 14;
	public static final int CATEGORYHEIGHT = 6;
	protected static final int MIN_CATEGORY_PAD = MapModeUtil.getMapMode().DPtoLP(5);
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
	private static final int SHADOW = MapModeUtil.getMapMode().DPtoLP(4);

	/**
	 * shrink image to fit descritpion underneath
	 */
	public static final int SHINK = 1 << 0;
	/**
	 * width is synced with heigth
	 */
	public static final int CONSTRAINED = 1 << 1;
	/**
	 * width is synced with heigth
	 */
	public static final int CENTERED = 1 << 2;

	/**
	 * @deprecated Use field initialization code directly.
	 */
	protected Font nameFont = DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
			ISharedFonts.FIG_NAME);

	// having categoryFont as a static caused GEF problems when used with setAlpha()
	/**
	 * @deprecated Use field initialization code directly.
	 */
	protected Font categoryFont = DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
			ISharedFonts.FIG_CATEGORY);
	private String category = null;
	private int categoryWidth = 0;
	private boolean filterCategory = false;

	/**
	 * @deprecated Use field initialization code directly.
	 */
	protected Font importFont = DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
			ISharedFonts.FIG_IMPORT);
	private Import importObj = null;
	private boolean isImported = false;
	protected String importName = null;
	protected int importNameWidth = 0;
	protected static final int IMPORTHEIGHT = 11;

	private String duplicateIndex = null;
	private int duplicateIndexWidth = 0;

	private boolean isConceptual = false;

	protected boolean isFaded = false;

	/**
	 * @return duplicate index
	 */
	public String getDuplicateIndex() {
		return duplicateIndex;
	}

	private EObject element = null;
	private Color _fillColor = null;
	private Color _lineColor = null;
	private Color _liteFillColor = null;
	private Color _darkFillColor = null;

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
	 * @param duplicateIndex
	 */
	public void setDuplicateIndex(String duplicateIndex) {
		if (this.duplicateIndex != duplicateIndex) {
		this.duplicateIndex = duplicateIndex;
		duplicateIndexWidth = getStringWidth(duplicateIndex, DeployCoreUIPlugin.getDefault()
				.getSharedFonts().getFont(ISharedFonts.FIG_DUP_INDEX));
		repaint();
		}
	}

	/**
	 * @return String
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
		categoryWidth = getStringWidth(category, categoryFont);
	}

	/**
	 * @param filterTypeName
	 */
	public void setFilterCategory(boolean filterTypeName) {
		filterCategory = filterTypeName;
	}

	/**
	 * @return
	 */
	public boolean isTypeNameFiltered() {
		return filterCategory;
	}

	/**
	 * @param imprt --
	 *           if this unit doesn't belong to the editing topology, what import does it belong to?
	 */
	public void setImport(Import imprt) {
		isImported = true;
		importObj = imprt;
		String name = "unknown"; //$NON-NLS-1$
		if (imprt != null) {
			name = imprt.getNamespace();
			if (name != null && name.length() > 0) {
				name += "#";//$NON-NLS-1$
			}
			name += imprt.getDisplayName();
		}
		importName = name;
		importNameWidth = getStringWidth(importName, importFont);
	}

	/**
	 * @return is this figure of an imported unit
	 */
	public boolean isImported() {
		return isImported;
	}

	protected int getStringWidth(String s, Font f) {
		if (s != null && s.length() > 0) {
			return MapModeUtil.getMapMode().DPtoLP(
					org.eclipse.draw2d.FigureUtilities.getStringExtents(s, f).width);
		}
		return 0;
	}

	/**
	 * @return IFigure
	 */
	public IFigure getContentPane() {
		return (IFigure) getChildren().get(0);
	}

	/**
	 * 
	 */
	public DeployCoreFigure() {
		setOpaque(true);
		getBounds().width = getMinimalSize().width;
		getBounds().height = getMinimalSize().height;
	}

	/**
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension dim = super.getPreferredSize(wHint, hHint);
		Dimension siz = getMinimalSize();
		Dimension spcr = getNameSpaceSize();

		// override dim to contain it's name with spacers
		DeployWrapLabel label = GEFUtils.findWrapLabel(getChildren());
		if (label != null) {
			Dimension dim2 = label.getPreferredSize();
			// for width, account for name being centered with 22pix spacers on both sides 
			dim.width = dim2.width + spcr.width * 2;
			// for height, account for name being positioned at 20pix down and having 10pix spacer underneath
			dim.height = dim2.height + 20 * Q + spcr.height + getExtraHeight();
		}

		// if category line width is even wider then name line, use category width
		if (!filterCategory) {
			int cWidth = categoryWidth + MapModeUtil.getMapMode().DPtoLP(12) + duplicateIndexWidth
					+ spcr.width * 2;
			if (cWidth > dim.width) {
				dim.width = cWidth;
			}
		}

		// if text width is still less then our minimum width, use min width
		if (dim.width < siz.width) {
			dim.width = siz.width;
		}

		// if text height is still less then our minimum height, use min height
		// min height increases if there's an imported path at the bottom
		int sizHeight = siz.height;
		if (dim.height < sizHeight) {
			dim.height = sizHeight;
		}
		if (filterCategory) {
			dim.height -= 6 * Q;
		}

		return dim;
	}

	protected int getSubclassedFigureTextWidth() {
		return 0;
	}

	protected Dimension getMinimalSize() {
		return SIZE;
	}

	protected Dimension getNameSpaceSize() {
		return NAMESPACER;
	}

	// ex: used by group to account for group/hosting list titles
	protected int getExtraHeight() {
		return 0;
	}

	/*
	 * draw an application for the figure #11 = ColorConstants.titleGradient #14 =
	 * ColorConstants.buttonDarkest #19 = ColorConstants.buttonDarker
	 */
	protected void paintDeployApplication(Graphics g) {
		Rectangle r = paintBackground(g);

		if (!isFaded) {
			// gradiant fill
			g.setForegroundColor(getLiteFillColor(ColorConstants.white));
			g.setBackgroundColor(getFillColor(DeployColorConstants.appGradiantFill));
			g.fillGradient(r, true);

			// title bar #14 +85% white
			g.setForegroundColor(getFillColor(DeployColorConstants.appTitleBar));
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(3));
			g.drawLine(r.x, r.y + Q * 2, r.x + r.width, r.y + Q * 2);

			// draw some white highlights
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
			g.setForegroundColor(ColorConstants.white);
			g.drawLine(r.x + 2 * Q, r.y + Q, r.x + r.width - 2 * Q, r.y + Q);
			g.drawLine(r.x + Q, r.y + Q, r.x + Q, r.y + r.height - 5 * Q);
			g.drawLine(r.x + r.width - 2 * Q, r.y + Q, r.x + r.width - 2 * Q, r.y + r.height - 5 * Q);
			g.drawLine(r.x + Q, r.y + r.height - 5 * Q, r.x + r.width - 1 * Q, r.y + r.height - 5 * Q);

			g.drawPoint(r.x, r.y + r.height);
			g.drawPoint(r.x + r.width, r.y + r.height);
			g.drawPoint(r.x + 3 * Q, r.y + 3 * Q);
			g.drawPoint(r.x + r.width - 3 * Q, r.y + 3 * Q);
		}

		// outer rect #14 +65% white
		g.setForegroundColor(getLineColor(DeployColorConstants.appOutline));
		g.drawLine(r.x + Q, r.y, r.x + r.width - 2 * Q, r.y);
		g.drawLine(r.x, r.y + Q, r.x, r.y + r.height - 2 * Q);
		g.drawLine(r.x + r.width, r.y + Q, r.x + r.width, r.y + r.height - 2 * Q);
		g.drawLine(r.x + Q, r.y + r.height, r.x + r.width - 2 * Q, r.y + r.height);

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		paintTitles(g, r);
	}

	/*
	 * draw a server for the figure
	 */
	protected void paintDeployServer(Graphics g) {
		Rectangle r = paintBackground(g);

		if (!isFaded) {
			// gradiant fill
			g.setForegroundColor(getFillColor(DeployColorConstants.srvrGradiantFill));
			g.setBackgroundColor(getLiteFillColor(ColorConstants.white));
			g.fillGradient(r, true);

			// title bar
			g.setForegroundColor(ColorConstants.white);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(6));
			g.drawLine(r.x, r.y + Q * 2, r.x + r.width, r.y + Q * 2);

			// draw some dot highlights
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
			g.setForegroundColor(getLineColor(DeployColorConstants.srvrOutline));
			int x = r.x + r.width - 16 * Q;
			int y = r.y + 3 * Q;
			for (int i = 0; i < 3; i++) {
				g.drawLine(x, y, x + 2 * Q, y);
				x += 4 * Q;
			}
		}

		// outer rect
		g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
		g.drawLine(r.x, r.y + Q * 5, r.x + r.width, r.y + Q * 5);
		g.drawRectangle(r);

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		paintTitles(g, r);
	}

	/*
	 * draw an operating system for the figure
	 */
	protected void paintDeployOS(Graphics g) {
		Rectangle r = paintBackground(g);

		// fill rect
		if (_fillColor != null && !isFaded) {
			// 1/3 gradiant fill
			Rectangle gradiantRect = new Rectangle(r);
			int thirdHeight = gradiantRect.height / 3;
			g.setBackgroundColor(_liteFillColor);
			g.setForegroundColor(_fillColor);
			gradiantRect.height = thirdHeight * 2;
			g.fillGradient(gradiantRect, true);

			// 1/3 gradiant fill
			g.setForegroundColor(_liteFillColor);
			g.setBackgroundColor(_fillColor);
			gradiantRect.y += thirdHeight * 2;
			g.fillGradient(gradiantRect, true);
		}

		// outer rect
		g.setForegroundColor(getLineColor(DeployColorConstants.osOutline));
		g.drawRectangle(r);

		// title bar gradiant fill
		if (!isFaded) {
			Rectangle gradiantRect = new Rectangle(r);
			gradiantRect.shrink(Q, Q);
			gradiantRect.height = 3 * Q;
			g.setForegroundColor(DeployColorConstants.osGradiantFill1);
			g.setBackgroundColor(DeployColorConstants.osGradiantFill2);
			g.fillGradient(gradiantRect, false);
			g.setForegroundColor(getLineColor(DeployColorConstants.osOutline));
			g.drawLine(r.x, r.y + 4 * Q, r.x + r.width, r.y + 4 * Q);
		}

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		paintTitles(g, r);
	}

	/*
	 * draw a database for the figure
	 */
	protected void paintDeployDatabase(Graphics g) {
		Rectangle r = paintBackground(g);

		if (!isFaded) {
			// 1/2 gradiant fill
			Rectangle gradiantRect = new Rectangle(r);
			int halfWidth = gradiantRect.width / 2;
			g.setForegroundColor(getFillColor(DeployColorConstants.dbGradiantFill1));
			g.setBackgroundColor(getLiteFillColor(ColorConstants.white));
			gradiantRect.width = halfWidth;
			g.fillGradient(gradiantRect, false);

			// 1/2 gradiant fill
			g.setForegroundColor(getLiteFillColor(ColorConstants.white));
			g.setBackgroundColor(getFillColor(DeployColorConstants.dbGradiantFill1));
			gradiantRect.x += halfWidth;
			g.fillGradient(gradiantRect, false);
		}

		// outer rect 
		g.setForegroundColor(getLineColor(DeployColorConstants.dbOutline));
		int arc = MapModeUtil.getMapMode().DPtoLP(8);
		g.drawRoundRectangle(r, arc, arc);

		// paint conceptual
		paintConceptual(g, r, arc, arc);

		paintTitles(g, r);
	}

	/*
	 * draw an SQL figure
	 */
	protected void paintDeploySQL(Graphics g) {
		Rectangle r = paintBackground(g);

		Rectangle shapeRect = new Rectangle(r);
		if (!isFaded) {
			// draw shadow fillers
			if (!isOverlapped()) {
				shapeRect.height -= 4 * Q;
				shapeRect.width -= 4 * Q;
				shapeRect.translate(4 * Q, 4 * Q);
				g.setBackgroundColor(DeployColorConstants.sqlFill3);
				g.fillRectangle(shapeRect);
				shapeRect.translate(-2 * Q, -2 * Q);
				g.setBackgroundColor(DeployColorConstants.sqlFill2);
				g.fillRectangle(shapeRect);
				shapeRect.translate(-2 * Q, -2 * Q);
			}
			g.setBackgroundColor(getFillColor(DeployColorConstants.sqlFill1));
			g.fillRectangle(shapeRect);
		}

		// draw outline rect
		g.setForegroundColor(getLineColor(DeployColorConstants.sqlOutline));
		g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
		g.drawRectangle(shapeRect);

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		paintTitles(g, r);
	}

	/*
	 * draw an image for the figure
	 */
	protected void paintDeployImage(Graphics g, Image deployImg, int style) {
		Rectangle r = paintBackground(g);

		// draw image
		Rectangle rImage = r.getCopy();
		if ((style & SHINK) != 0) {
			rImage.height -= MapModeUtil.getMapMode().DPtoLP(NAMEHEIGHT);
		}
		Image img = deployImg;
		org.eclipse.swt.graphics.Rectangle imgRect = img.getBounds();
		int width = rImage.width;
		int height = rImage.height;
		if ((style & CONSTRAINED) != 0) {
			width = height * imgRect.width / imgRect.height;
		}
		rImage.x += (style & CENTERED) != 0 ? (r.width - width) / 2 : 0;
		g.drawImage(img, 0, 0, imgRect.width, imgRect.height, rImage.x, rImage.y, width, height);

		// draw border
		g.setForegroundColor(getLineColor(ColorConstants.lightGray));
		g.drawRectangle(r);

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		paintTitles(g, r);
	}

	protected Rectangle paintBackground(Graphics g) {
		Rectangle r = getBounds().getCopy();
		r.shrink(Q, Q);

		// if overlapped, shrink rect and paint shadow underneath
		if (isOverlapped()) {
			// shrink rect
			r.height -= SHADOW;
			r.width -= SHADOW;
			// paint shadow 
			boolean b = g.getXORMode();
			g.setXORMode(true);
			g.setBackgroundColor(DeployColorConstants.overlapShadow);
			g.fillRectangle(r.getCopy().translate(SHADOW, SHADOW));
			g.setXORMode(b);
		}
		g.setBackgroundColor(ColorConstants.white);
		g.fillRectangle(r);

		// if figure is faded, set the alpha	
		if (isFaded) {
			g.setAlpha(DeployCoreConstants.SELECTION_FADE);
		}
		return r;
	}

	/*
	 * if figure is conceptual, paint conceptual artifacts on figure
	 */
	protected void paintConceptual(Graphics g, Rectangle r, int arcWidth, int arcHeight) {
		if (isConceptual) {
			Color rgb = g.getForegroundColor();
			g.setLineStyle(SWT.LINE_SOLID);
			g.setForegroundColor(ColorConstants.white);
			if (arcWidth == 0 && arcHeight == 0) {
				g.drawRectangle(r);
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] { 4, 4 });
				g.setForegroundColor(getLineColor(ColorConstants.darkGray));
				g.drawRectangle(r);
			} else {
				g.drawRoundRectangle(r, arcWidth, arcHeight);
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] { 4, 4 });
				g.setForegroundColor(getLineColor(ColorConstants.darkGray));
				g.drawRoundRectangle(r, arcWidth, arcHeight);
			}
			g.setForegroundColor(rgb);
			g.setLineStyle(SWT.LINE_SOLID);
		}
	}

	/*
	 * add titles to image
	 */
	protected void paintTitles(Graphics g, Rectangle r) {
		paintCategory(g, r);
		paintDuplicateIndex(g, r);
	}

	protected void paintCategory(Graphics g, Rectangle r) {
		String cat = getCategory();
		if (cat != null && !filterCategory) {
			g.setForegroundColor(DeployColorConstants.categoryColor);
			g.setFont(categoryFont);
			int catWidth = categoryWidth;
			int x, y;
			x = y = 0;
			int xD = (r.width - catWidth) / 2 + 5 * Q;
			if (xD < MIN_CATEGORY_PAD) {
				xD = MIN_CATEGORY_PAD;
			}
			x = r.x + xD;
			y = r.y + MapModeUtil.getMapMode().DPtoLP(CATEGORYHEIGHT);
			g.drawString(cat, x, y);
		}
	}

	protected void paintDuplicateIndex(Graphics g, Rectangle r) {
		String index = getDuplicateIndex();

		if (index == null || filterCategory) {
			return;
		}

		// Get the width of the category string
		int catWidth = 0;
		String catStr = getCategory();
		if (catStr != null) {
			catWidth = categoryWidth + Q;
		}

		// Calculate the start point for index string
		int x, y;
		x = y = 0;
		int xD = (r.width - catWidth) / 2;
		//if (xD<MIN_CATEGORY_PAD) xD=MIN_CATEGORY_PAD;

		x = r.x + xD + catWidth;
		y = r.y + MapModeUtil.getMapMode().DPtoLP(CATEGORYHEIGHT);

		// Draw the index string
		g.setForegroundColor(DeployColorConstants.categoryColor);
		g.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts()
				.getFont(ISharedFonts.FIG_DUP_INDEX));
		g.drawString(index, x, y);
	}

	/**
	 * @return if overlapped by a unit group
	 */
	public boolean isOverlapped() {
		if (getParent() instanceof NodeFigureEx) {
			return ((NodeFigureEx) getParent()).isOverlapped();
		}
		return false;
	}

	/**
	 * @param b
	 *           --is conceptual
	 */
	public void setConceptual(boolean b) {
		boolean r = isConceptual != b;
		isConceptual = b;
		if (r) {
			invalidate();
			repaint();
		}
	}

	/**
	 * @return is conceptual
	 */
	public boolean isConceptual() {
		return isConceptual;
	}

	/**
	 * @return getCategoryWidth
	 */
	public int getCategoryWidth() {
		return categoryWidth;
	}

	/**
	 * @param isFaded
	 */
	public void setFaded(boolean isFaded) {
		this.isFaded = isFaded;
	}

	/**
	 * @return the import that this figure belongs to
	 */
	public Import getImportObj() {
		return importObj;
	}

	/**
	 * @param fillColor
	 * @param liteFillColor
	 * @param darkFillColor
	 */
	public void setFillColors(Color fillColor, Color liteFillColor, Color darkFillColor) {
		_fillColor = fillColor;
		_liteFillColor = liteFillColor;
		_darkFillColor = darkFillColor;
	}

	/**
	 * @param lineColor
	 */
	public void setLineColor(Color lineColor) {
		_lineColor = lineColor;
	}

	/**
	 * @param defaultColor --
	 *           if the preferences and the style of this figure hasn't been set, returns this color
	 */
	protected Color getFillColor(Color defaultColor) {
		if (_fillColor != null) {
			return _fillColor;
		}
		return defaultColor;
	}

	/**
	 * @param defaultColor --
	 *           if the preferences and the style of this figure hasn't been set, returns this color
	 */
	protected Color getLiteFillColor(Color defaultColor) {
		if (_liteFillColor != null) {
			return _liteFillColor;
		}
		return defaultColor;
	}

	/**
	 * @param defaultColor --
	 *           if the preferences and the style of this figure hasn't been set, returns this color
	 */
	protected Color getDarkFillColor(Color defaultColor) {
		if (_darkFillColor != null) {
			return _darkFillColor;
		}
		return defaultColor;
	}

	/**
	 * @param defaultColor --
	 *           if the preferences and the style of this figure hasn't been set, returns this color
	 */
	protected Color getLineColor(Color defaultColor) {
		if (_lineColor != null) {
			return _lineColor;
		}
		return defaultColor;
	}

}
