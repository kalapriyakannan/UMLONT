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

import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeploySetBoundsCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

/**
 * @since 7.0
 * 
 */
public class SnapUtils {
	/**
	 * 
	 */
	public static final int ANCHOR_GROUP = 1;
	/**
	 * 
	 */
	public static final int COMPARTMENT_CHANGE = 2;

	/**
	 * @param view
	 * @param v2eMap
	 * @return returns a rectangle with the structural view bounds
	 */
	public static Rectangle getViewBounds(View view, Map<?, ?> v2eMap) {
		GraphicalEditPart ep = (GraphicalEditPart) v2eMap.get(view);
		if (ep != null) {
			Rectangle bounds = ep.getFigure().getBounds().getCopy();
			int x = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
					.getLocation_X())).intValue();
			int y = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
					.getLocation_Y())).intValue();
			bounds.setLocation(x, y);
			return bounds;
		}
		return null;
	}

	/**
	 * @param ep
	 * @return returns the bounds of the EditPart's View
	 */
	public static Rectangle getEditPartBounds(DeployShapeNodeEditPart ep) {
		Rectangle bounds = null;
		if (ep.getViewer() != null && !ep.getViewer().getControl().isDisposed()
				&& ep.getViewer().getEditPartRegistry() != null) {
			Map<?, ?> v2eMap = ep.getViewer().getEditPartRegistry();
			View view = (View) ep.getModel();
			bounds = SnapUtils.getViewBounds(view, v2eMap);
		}
		return bounds;
	}

	/**
	 * @param ep
	 * @return is the edit part in a rectangular snap group
	 */
	public static boolean isInRectangularSnapGroup(EditPart ep) {
		if (ep instanceof DeployShapeNodeEditPart
				&& ((DeployShapeNodeEditPart) ep).getNotationView() != null) {
			return isInRectangularSnapGroup(((DeployShapeNodeEditPart) ep).getNotationView());
		}
		return false;
	}

	/**
	 * @param view
	 * @return the View's SnapGroup or null
	 */
	public static View getSnapGroup(View view) {
		if (view == null) {
			return null;
		}
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null && style.getSnapParent() != null
				&& style.getSnapParent().eContainer() != null) {
			return (View) style.getSnapParent().eContainer();
		}
		return null;
	}

	/**
	 * 
	 * @param view
	 * @return returns the top level SnapGroup of the View or null
	 */
	public static View getTopLevelSnapGroup(View view) {
		if (view == null) {
			return null;
		}
		View snapGroup = getSnapGroup(view);
		if (snapGroup != null) {
			View parentGroup = getSnapGroup(snapGroup);
			while (parentGroup != null) {
				snapGroup = parentGroup;
				parentGroup = getSnapGroup(snapGroup);
			}
		}

		return snapGroup;
	}

	/**
	 * @param ep1
	 * @param ep2
	 * @param checkContainers
	 *           true, if not only the EditParts should be checked, but their containers as well
	 * @return true if ep1 is in the same top level SnapGroup as ep2
	 */
	public static boolean isInSameTopLevelSnapGroup(DeployShapeNodeEditPart ep1,
			DeployShapeNodeEditPart ep2, boolean checkContainers) {
		View top1 = getTopLevelSnapGroup(ep1.getNotationView());
		if (top1 == null && checkContainers == true) {
			EditPart container1 = GMFUtils.getEditPartContainer(ep1);
			if (container1 != null && container1 instanceof DeployShapeNodeEditPart) {
				top1 = getTopLevelSnapGroup(((DeployShapeNodeEditPart) container1).getNotationView());
			}
		}

		View top2 = getTopLevelSnapGroup(ep2.getNotationView());
		if (top2 == null && checkContainers == true) {
			EditPart container2 = GMFUtils.getEditPartContainer(ep2);
			if (container2 != null && container2 instanceof DeployShapeNodeEditPart) {
				top2 = getTopLevelSnapGroup(((DeployShapeNodeEditPart) container2).getNotationView());
			}
		}

		if (top1 != null && top1 == top2) {
			return true;
		}
		return false;
	}

	/**
	 * @param view
	 * @return returns true if the view is in a rectangular snap group
	 */
	public static boolean isInRectangularSnapGroup(View view) {
		View snapGroup = getSnapGroup(view);
		if (snapGroup != null) {
			DeployStyle style = (DeployStyle) snapGroup.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			return style != null && style.getSnapStyle() == DeployCoreConstants.SNAP_RECTANGULAR;
		}
		return false;
	}

	/**
	 * Sets the view to the size and expand the compartments if the expandCompartements is true
	 * 
	 * @param view
	 * @param size
	 * @param expandCompartments
	 */
	public static void setViewDimension(View view, Dimension size, boolean expandCompartments) {

		// determine old bounds and new
		Dimension oldSize = new Dimension(-1, -1);
		oldSize.width = ((Integer) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		oldSize.height = ((Integer) ViewUtil.getStructuralFeatureValue(view,
				NotationPackage.eINSTANCE.getSize_Height())).intValue();

		//		if (view.getElement() instanceof DeployModelObject) {
		//			System.err.println(((DeployModelObject) view.getElement()).getDisplayName()
		//					+ " oldSize = " + oldSize + " newSize = " + size); //$NON-NLS-1$ //$NON-NLS-2$
		//		}

		if (size != null && !oldSize.equals(size)) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(),
					new Integer(size.width));
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(),
					new Integer(size.height));
			DeploySetBoundsCommand.thresholdToggleCompartment(view, size);
		}
	}

	/**
	 * Sets the view to the size and expand the compartments if the expandCompartements is true
	 * 
	 * @param ep
	 * @param size
	 * @param changeCompartments
	 */
	public static void setViewDimension(EditPart ep, Dimension size, boolean changeCompartments) {
		if (ep != null && ep instanceof GraphicalEditPart
				&& ((GraphicalEditPart) ep).getNotationView() != null) {
			setViewDimension(((GraphicalEditPart) ep).getNotationView(), size, changeCompartments);
		}
	}

	/**
	 * 
	 * @param srcEP
	 * @return
	 */
	public static boolean containerIsInRectangularSnapGroup(GraphicalEditPart srcEP) {
		if (srcEP != null) {
			EditPart container = GMFUtils.getEditPartContainer(srcEP);
			if (container != null) {
				return isInRectangularSnapGroup(container);
			}
		}
		return false;
	}

}
