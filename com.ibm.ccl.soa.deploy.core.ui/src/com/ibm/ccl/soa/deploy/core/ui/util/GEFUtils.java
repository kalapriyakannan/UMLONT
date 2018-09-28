/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployConnectionLayerEx;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployDiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;

/**
 * @author jswanke
 * 
 */
public class GEFUtils {

	/**
	 * some layers: LayerConstants.FEEDBACK_LAYER, CONNECTION_LAYER, HANDLE_LAYER, PRIMARY_LAYER
	 * DiagramRootEditPart.DECORATION_PRINTABLE_LAYER -- decorators
	 * 
	 * @param ep
	 * @param layer
	 * @return layer
	 */
	public static IFigure getLayer(EditPart ep, Object layer) {
		if (ep == null) {
			DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
			if (editor != null) {
				return LayerManager.Helper.find(editor.getDiagramEditPart()).getLayer(layer);
			}
			return null;
		}
		return LayerManager.Helper.find(ep).getLayer(layer);
	}

	/**
	 * @param ep --
	 *           any ep, or null
	 * @param fig --
	 *           figure to add
	 */
	public static void addFeedback(EditPart ep, IFigure fig) {
		IFigure layer = getLayer(ep, LayerConstants.FEEDBACK_LAYER);
		if (layer != null) {
			layer.add(fig);
		}
	}

	/**
	 * @param ep --
	 *           any ep, or null
	 * @param fig --
	 *           figure to add
	 */
	public static void removeFeedback(EditPart ep, IFigure fig) {
		IFigure layer = getLayer(ep, LayerConstants.FEEDBACK_LAYER);
		if (layer != null) {
			layer.remove(fig);
		}
	}

	/**
	 * @param fig
	 * @return editpart
	 */
	public static GraphicalEditPart getEditpart(IFigure fig) {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			return (GraphicalEditPart) editor.getDiagramEditPart().getViewer().getVisualPartMap().get(
					fig);
		}
		return null;
	}

	/**
	 * @param child
	 * @param parent
	 * @return is child the child of parent?
	 */
	public static boolean isChildOf(EditPart child, EditPart parent) {
		if (child == parent) {
			return false;
		}
		EditPart walker = child;
		while (walker != null && !(walker instanceof DiagramEditPart)) {
			walker = walker.getParent();
			if (walker == parent) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param child
	 * @param parentList
	 * @return is child the child of parent?
	 */
	public static boolean isChildOf(EditPart child, List<?> parentList) {
		for (Iterator<?> it = parentList.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof EditPart && isChildOf(child, (EditPart) o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param figure
	 * @return figure that sits on diagram
	 */
	public static IFigure getTopFigure(IFigure figure) {
		IFigure walker = figure;
		while (walker != null) {
			IFigure parent = walker.getParent();
			if (parent instanceof DeployDiagramFigure) {
				return walker;
			}
			walker = parent;
		}
		return null;
	}

	/**
	 * @param figure
	 * @return diagram
	 */
	public static IFigure getDiagramFigure(IFigure figure) {
		IFigure walker = figure;
		while (walker != null) {
			if (walker instanceof DeployDiagramFigure) {
				return walker;
			}
			walker = walker.getParent();
		}
		return null;
	}

	/**
	 * @param ep
	 * @return ep that sits on diagram
	 */
	public static EditPart getTopEditPart(EditPart ep) {
		EditPart walker = ep;
		while (walker != null) {
			EditPart parent = walker.getParent();
			if (parent instanceof DeployDiagramEditPart || parent instanceof GroupEditPart) {
				return walker;
			}
			walker = parent;
		}
		return null;
	}

	/**
	 * @param part
	 * @return return the viewport given an editpart
	 */
	public static Viewport findViewport(AbstractGraphicalEditPart part) {
		IFigure figure = null;
		Viewport port = null;
		part = (AbstractGraphicalEditPart) part.getRoot();
		do {
			if (figure == null) {
				figure = part.getContentPane();
			} else {
				figure = figure.getParent();
			}
			if (figure instanceof Viewport) {
				port = (Viewport) figure;
				break;
			}
		} while (figure != part.getFigure() && figure != null);
		return port;
	}

	/**
	 * much more accurate then getSelectedEditParts()
	 * 
	 * @param map
	 * @return list of selected editparts
	 */
	public static List getSelectedEditParts() {
		// There is a significant performance penalty here, as the map.values()
		// can easily contain nearly 40K elements even for very very small topologies.
//		Set selected = new LinkedHashSet();
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
//		if (editor != null) {
//			Map map = editor.getDiagramEditPart().getViewer().getVisualPartMap();
//			for (Iterator it = map.values().iterator(); it.hasNext();) {
//				AbstractEditPart ep = (AbstractEditPart) it.next();
//				if (ep.getSelected() != 0 && !selected.contains(ep))
//					selected.add(ep);
//			}
//		}
//		return new ArrayList(selected);
		if (editor != null) {
			return editor.getDiagramEditPart().getViewer().getSelectedEditParts();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * refresh all chidren of the editpart
	 * 
	 * @param ep
	 *           --object to referesh and all of it's children
	 */
	public static void refreshTree(IGraphicalEditPart ep) {
		ep.refresh();
		for (Iterator it = ep.getChildren().iterator(); it.hasNext();) {
			refreshTree((IGraphicalEditPart) it.next());
		}
	}

	/**
	 * translate rect to scrolled coordinated
	 * 
	 * @param rect
	 */
	public static void translateToScrolled(Rectangle rect) {
		IFigure layer = getLayer(null, LayerConstants.SCALABLE_LAYERS);
		if (layer != null) {
			layer.translateToRelative(rect);
		}
	}

	/**
	 * because Manhattan link routing is CPU intensive, suspend it when deleting multiple units
	 * 
	 * @param isValidateEnabled
	 */
	public static void toggleConnectionLayerValidateEnabled(boolean isValidateEnabled) {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			DeployConnectionLayerEx connectionLayer = editor.getConnectionLayer();
			connectionLayer.toggleValidateEnabled(isValidateEnabled);
		}
	}

	/**
	 * given a figure, look for it's name child figure and return its dimensions
	 * 
	 * @param fig --
	 *           parent figure
	 * @return dimension of name
	 */
	public static Dimension getNameSize(IFigure fig) {
		DeployWrapLabel label = findWrapLabel(fig.getChildren());
		if (label != null) {
			return label.getPreferredSize(-1, -1);
		}
		return new Dimension(0, 0);
	}

	/**
	 * get the name figure in this figure
	 * 
	 * @param children --
	 *           children of the parent figure
	 * @return the name figure
	 */
	static public DeployWrapLabel findWrapLabel(List children) {
		for (Iterator<IFigure> it = children.iterator(); it.hasNext();) {
			IFigure child = it.next();
			if (child instanceof DeployWrapLabel) {
				return (DeployWrapLabel) child;
			}
			DeployWrapLabel label = findWrapLabel(child.getChildren());
			if (label != null) {
				return label;
			}
		}
		return null;

	}

	/**
	 * determine the header height of a figure based on a minumum size and the font size
	 * 
	 * @param parent
	 * @return header height
	 */
	public static int getListHeaderHeight(IFigure parent) {
		int hdrHeight = GEFUtils.getNameSize(parent).height + 10 * DeployCoreConstants.Q;
		if (hdrHeight < DeployCoreConstants.SERVER_UNIT_HEADER) {
			hdrHeight = DeployCoreConstants.SERVER_UNIT_HEADER;
		}
		return hdrHeight;
	}

	/**
	 * determine the header height of a figure based on a minumum size and the font size
	 * 
	 * @param parent
	 * @return header height
	 */
	public static int getShapesHeaderHeight(IFigure parent) {
		return getListHeaderHeight(parent) + 2 * DeployCoreConstants.Q;
	}

	/**
	 * determine the header height of a figure based on a minumum size and the font size
	 * 
	 * @param parent
	 * @return item height
	 */
	public static int getListItemHeight(IFigure parent) {
		int itemHeight = getNameSize(parent).height;
		if (itemHeight < MapModeUtil.getMapMode(parent).DPtoLP(
				DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT)) {
			itemHeight = MapModeUtil.getMapMode(parent).DPtoLP(
					DeployCoreConstants.HOSTINGLISTITEM_DPHEIGHT);
		}
		return itemHeight;
	}

	/**
	 * determine the header height of a figure based on a minumum size and the font size
	 * 
	 * @param parent
	 * @return item height
	 */
	public static int getListItemDPHeight(IFigure parent) {
		Rectangle r = new Rectangle(0, 0, 0, getListItemHeight(parent));
		parent.translateToAbsolute(r);
		return r.height;
	}

	/**
	 * clear selections before link reorientation
	 */
	public static void deselectAll() {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			editor.getDiagramGraphicalViewer().deselectAll();
		}
		SelectionUtils.unfadeFigures();
	}

	/**
	 * layout connectors
	 */
	public static void layoutConnectors() {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			DeployConnectionLayerEx layer = editor.getConnectionLayer();
			layer.invalidateTree();
			layer.validate();
			layer.repaint();
		}
	}

}
