/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConstrainedToolbarLayoutEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * An editpart to show an unresolved proxy view.
 * 
 * @author jswanke
 */
public class UnresolvedProxyEditPart extends ShapeNodeEditPart {

	/**
	 * Rectangle figure with error text.
	 */
	static public class UnresolvedProxyFigure extends NodeFigure {
		private static final Dimension SIZE = new Dimension(MapModeUtil.getMapMode().DPtoLP(150),
				DeployCoreConstants.SERVER_UNIT_HEIGHT);
		protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
		boolean _isInList = false;
		String _proxyName;
		String _proxyCategory;
		String _importPath;
		int catWidth;
		int importWidth;
		int nameWidth;

		/**
		 * @param isInList
		 * @param proxyName
		 * @param proxyCategory
		 * @param importPath
		 */
		public UnresolvedProxyFigure(boolean isInList, String proxyName, String proxyCategory,
				String importPath) {
			_isInList = isInList;
			_proxyName = proxyName;
			_proxyCategory = proxyCategory;
			_importPath = importPath;
			catWidth = MapModeUtil.getMapMode().DPtoLP(
					FigureUtilities.getStringExtents(_proxyCategory, DeployCoreUIPlugin.getDefault()
							.getSharedFonts().getFont(ISharedFonts.FIG_CATEGORY)).width);
			nameWidth = MapModeUtil.getMapMode().DPtoLP(
					FigureUtilities.getStringExtents(_proxyName, DeployCoreUIPlugin.getDefault()
							.getSharedFonts().getFont(ISharedFonts.FIG_NAME)).width);
			importWidth = MapModeUtil.getMapMode().DPtoLP(
					FigureUtilities.getStringExtents(_importPath, DeployCoreUIPlugin.getDefault()
							.getSharedFonts().getFont(ISharedFonts.FIG_IMPORT)).width);
			if (_isInList) {
				Label __toolTip = new Label(_proxyCategory) {
					public Insets getInsets() {
						return new Insets(2);
					}
				};
				setToolTip(__toolTip);
			}
		}

		public Dimension getPreferredSize(int wHint, int hHint) {
			Dimension siz = SIZE.getCopy();

			int cWidth = catWidth + MapModeUtil.getMapMode().DPtoLP(16);
			if (cWidth > siz.width) {
				siz.width = cWidth;
			}
			cWidth = nameWidth + MapModeUtil.getMapMode().DPtoLP(32);
			if (cWidth > siz.width) {
				siz.width = cWidth;
			}
			cWidth = importWidth + MapModeUtil.getMapMode().DPtoLP(32);
			if (cWidth > siz.width) {
				siz.width = cWidth;
			}
			if (_isInList) {
				siz.height = MapModeUtil.getMapMode(this).DPtoLP(
						DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT);
				if (siz.width < MapModeUtil.getMapMode().DPtoLP(200)) {
					siz.width = MapModeUtil.getMapMode().DPtoLP(200);
				}
			}
			return siz;
		}

		protected void paintFigure(Graphics g) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBounds());

			if (_isInList) {
				// fill background with pink
				g.setBackgroundColor(DiagramColorConstants.diagramLightRed);
				g.fillRectangle(r);

				// add a white border
				g.setForegroundColor(ColorConstants.white);
				r.width--;
				r.height--;
				g.drawRectangle(r);

				// draw name
				g.setForegroundColor(ColorConstants.black);
				g.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
						ISharedFonts.FIG_NAME));
				g.drawString(_proxyName, r.x + MapModeUtil.getMapMode().DPtoLP(25), r.y
						+ MapModeUtil.getMapMode().DPtoLP(2));
			} else {
				// paint shape
				paintErrorShape(g, r);

				// paint title
				g.setForegroundColor(ColorConstants.black);
				g.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
						ISharedFonts.FIG_NAME));
				paintTitle(g, r, _proxyName, 18, nameWidth);

				// paint "Unresolved Reference" for category
				g.setForegroundColor(DeployColorConstants.categoryColor);
				g.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
						ISharedFonts.FIG_CATEGORY));
				paintTitle(g, r, _proxyCategory, 6, catWidth);

				// paint import path
				g.setForegroundColor(DeployColorConstants.importLabel);
				g.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
						ISharedFonts.FIG_IMPORT));
				paintTitle(g, r, "[" + _importPath + "]", 32, importWidth); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		private void paintErrorShape(Graphics g, Rectangle r) {
			g.setForegroundColor(ColorConstants.white);
			g.setBackgroundColor(DiagramColorConstants.diagramLightRed);
			g.fillGradient(r, true);
			g.setForegroundColor(DiagramColorConstants.diagramLightRed);
			g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(3));
			g.drawLine(r.x, r.y + Q * 2, r.x + r.width, r.y + Q * 2);
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
			g.setForegroundColor(DeployColorConstants.appOutline);
			g.drawLine(r.x + Q, r.y, r.x + r.width - 2 * Q, r.y);
			g.drawLine(r.x, r.y + Q, r.x, r.y + r.height - 2 * Q);
			g.drawLine(r.x + r.width, r.y + Q, r.x + r.width, r.y + r.height - 2 * Q);
			g.drawLine(r.x + Q, r.y + r.height, r.x + r.width - 2 * Q, r.y + r.height);
		}

		private void paintTitle(Graphics g, Rectangle r, String title, int yOff, int width) {
			int x, y;
			x = y = 0;
			int xD = (r.width - width) / 2;
			x = r.x + xD;
			y = r.y + MapModeUtil.getMapMode().DPtoLP(yOff);
			g.drawString(title, x, y);
		}

		/**
		 * @return is in a tree
		 */
		public boolean isInList() {
			return _isInList;
		}
	}

	/**
	 * Constructs a new instance.
	 * 
	 * @param view
	 */
	public UnresolvedProxyEditPart(View view) {
		super(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createNodeFigure()
	 */
	protected NodeFigure createNodeFigure() {
		boolean isInList = getParent() instanceof DeployListCompartmentEditPart;
		DeployStyle style = (DeployStyle) getNotationView().getStyle(
				DeployNotationPackage.eINSTANCE.getDeployStyle());

		String importPath = ""; //$NON-NLS-1$
		if (style.getImport() instanceof Import) {
			Import imprt = (Import) style.getImport();
			if (imprt != null) {
				importPath = imprt.getNamespace();
				if (importPath != null && importPath.length() > 0) {
					importPath += "#";//$NON-NLS-1$
				}
				importPath += imprt.getDisplayName();
			}
		}
		return new UnresolvedProxyFigure(isInList, style.getElementName(),
				style.getElementCategory(), importPath);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		// remove drop down handle from inside of config unit list
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeployConstrainedToolbarLayoutEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new NonResizableEditPolicyEx());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicyEx());
	}

	// don't allow editpart to resize-- it contains other views that would get upset
	public EditPolicy getPrimaryDragEditPolicy() {
		return new NonResizableEditPolicyEx();
	}

}
