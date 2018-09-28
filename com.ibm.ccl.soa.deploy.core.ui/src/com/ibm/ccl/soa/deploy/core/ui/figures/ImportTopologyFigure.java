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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Font;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * @author jswanke
 * 
 */
public class ImportTopologyFigure extends DeployCoreFigure {
	private static final Dimension SIZE = new Dimension(DeployCoreConstants.IMPORT_TOPOLOGY_WIDTH,
			DeployCoreConstants.IMPORT_TOPOLOGY_HEIGHT);
	private String namespace = null;
	private int namespaceWidth = 0;
	private static Font namespaceFont = DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
			ISharedFonts.FIG_IMPORT);
	protected static final int NAMESPACEHEIGHT = 14;
	private final boolean _isImportDiagram;

	/**
	 * constructor
	 * 
	 * @param isImportDiagram
	 */
	public ImportTopologyFigure(boolean isImportDiagram) {
		_isImportDiagram = isImportDiagram;
	}

	/**
	 * @return String
	 */
	public String getNamespace() {
		return namespace;
	}

	protected Dimension getMinimalSize() {
		return SIZE.getCopy();
	}

	/**
	 * @param namespce
	 */
	public void setNamespace(String namespce) {
		namespace = namespce;
		namespaceWidth = getStringWidth(namespace, namespaceFont);
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension dim = super.getPreferredSize(wHint, hHint);

		// if namespace line width is even wider use that width
		int lWidth = namespaceWidth + getNameSpaceSize().width * 2;

		// if import is expanded also add name too
		if (GMFUtils.isImportExpanded(getParent())) {
			lWidth += getNameWidth();
		}
		if (lWidth > dim.width) {
			dim.width = lWidth;
		}
		return dim;
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = paintBackground(g);

		// fill rect
		g
				.setBackgroundColor(getFillColor(_isImportDiagram ? DeployColorConstants.imprtDiagramNodeFill
						: DeployColorConstants.importTopologyFill));
		g.fillRectangle(r.getCopy());

		// draw inside rect
		Rectangle innerRect = r.getCopy();
		innerRect.shrink(Q, Q);
		g.setForegroundColor(ColorConstants.white);
		g.drawRectangle(innerRect);

		// draw outside rect
		g
				.setForegroundColor(getLineColor(_isImportDiagram ? DeployColorConstants.imprtDiagramNodeBorder
						: DeployColorConstants.importTopologyBorder1));
		g.drawRectangle(r);

		// draw category & namespace
		paintCategory(g, r);
		paintNamespace(g, r);
	}

	protected void paintNamespace(Graphics g, Rectangle r) {
		String ns = getNamespace();
		if (ns == null || ns.length() == 0) {
			setNamespace(Messages.ImportTopologyFigure_no_namespac_);
			ns = getNamespace();
		}
		int x = 0;
		int y = 0;
		g.setForegroundColor(ColorConstants.black);
		g.setFont(namespaceFont);
		if (GMFUtils.isImportExpanded(getParent())) {
			x = r.x + MapModeUtil.getMapMode().DPtoLP(35) + getNameWidth();
			int itemHeight = GEFUtils.getListItemHeight(this);
			y = r.y + itemHeight / 2 + MapModeUtil.getMapMode().DPtoLP(10);
			g.drawText("[" + ns + "]", x, y); //$NON-NLS-1$//$NON-NLS-2$
		} else {
			int nsWidth = namespaceWidth;
			int xD = (r.width - nsWidth) / 2;
			if (xD < MIN_CATEGORY_PAD) {
				xD = MIN_CATEGORY_PAD;
			}
			x = r.x + xD;
			y = r.y + r.height - MapModeUtil.getMapMode().DPtoLP(NAMESPACEHEIGHT);
		}
		g.drawString("[" + ns + "]", x, y); //$NON-NLS-1$//$NON-NLS-2$
	}

	// get name width based on font of 
	private int getNameWidth() {
		DeployWrapLabel label = GEFUtils.findWrapLabel(getChildren());
		if (label != null) {
			return label.getPreferredSize(-1, -1).width;
		}
		return MapModeUtil.getMapMode().DPtoLP(55);
	}

}
