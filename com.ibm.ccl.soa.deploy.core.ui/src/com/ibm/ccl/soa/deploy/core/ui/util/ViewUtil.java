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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.providers.GeoshapeConstants;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.TextStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToDiagramCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AddToNewGroupCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.AquireUnitsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ConvertToShapesOrTreeCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CopyViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateMemberOrHostingLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.MoveViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @author jswanke
 * 
 */
public class ViewUtil extends org.eclipse.gmf.runtime.diagram.core.util.ViewUtil {

	private static Point _cascadingPt = new Point(0, 0);
	private static Unit _fromUnit = null;
	private static List<Unit> _allCopiedElements = new ArrayList<Unit>();

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// //////////// Copy a View to a New Shapes Container or the Diagram ///////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * copies a view from one container view to another (by recreating it and copying its
	 * attributes/children views)-- destination can be a shapes container or the diagram
	 * 
	 * @see CopyViewCommand -- used when dragging a view from one container to another
	 * @see MoveViewCommand -- used when dragging a view from one container to another
	 * @see AddToDiagramCommand -- used to create a duplicate view on the diagram (from context menu)
	 * 
	 * @param diagramEP
	 *           -- the diagram editpart
	 * @param toShapesEP
	 *           -- shapes compartment or diagram to copy this view into
	 * @param viewToBeCopied
	 *           -- view to be copied
	 * @param location
	 *           -- location to place view-- if null, the old view's position is used instead
	 * @param translateToParent
	 *           TODO
	 * @param isCopyChildren
	 *           -- copy this view's children views too re-entrantly until all children are copied
	 * @param isTargetShapesMode
	 *           is the target a shapes container?
	 * @param isCollapseCopiedView
	 *           TODO
	 * @param visibleList
	 *           -- if copying from an import diagram we need to convert the from view's element into
	 *           a proxy in this topology using this list-- if a match can't be found, the unit is
	 *           private and a view shouldn't be created for it
	 * @return the new view
	 */

	public static Node copyView(DiagramEditPart diagramEP, AbstractGraphicalEditPart toShapesEP,
			View viewToBeCopied, Point location, boolean translateToParent, boolean isCopyChildren,
			boolean isTargetShapesMode, boolean isCollapseCopiedView,
			List<DeployModelObject> visibleList) {

		// determine the compartment view for the copied view
		View toCompartmentView = null;
		if (toShapesEP == null || toShapesEP instanceof DiagramEditPart) {
			toCompartmentView = diagramEP.getNotationView();
		} else if (toShapesEP instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) toShapesEP;
			EditPart toCompartmentEP = DeployShapeNodeEditPart.getShapesCompartment(ep);
			if (toCompartmentEP == null) {
				toCompartmentEP = DeployShapeNodeEditPart.getListCompartment(ep);
			}
			if (toCompartmentEP == null) {
				return null;
			}
			toCompartmentView = (View) toCompartmentEP.getModel();
		} else if (toShapesEP instanceof HybridShapesCompartmentEditPart
				|| toShapesEP instanceof HybridListCompartmentEditPart) {
			toCompartmentView = (View) toShapesEP.getModel();
		}

		// create new view in compartment; if isCopyChildren, also create child views that were in old view in the new view
		Node newView = copyViewHelper(diagramEP, toCompartmentView, viewToBeCopied, location,
				translateToParent, false, isCopyChildren, isTargetShapesMode, isCollapseCopiedView,
				visibleList, false, toShapesEP);
		return newView;
	}

	/**
	 * same as above but we have the toCompartment already
	 * 
	 * @see AddToGroupCommand -- used when dragging a view from one container to another
	 * @see AddToNewGroupCommand -- used when dragging a view from one container to another
	 * @see AquireUnitsCommand -- used to create a duplicate view on the diagram (from context menu)
	 * 
	 * @param diagramEP
	 *           -- the diagram editpart
	 * @param toShapesCompartmentView
	 *           -- shapes compartment or diagram to copy this view into
	 * @param viewToBeCopied
	 *           -- view to be copied
	 * 
	 *           Location of new view must be set by caller-- otherwise the old view's location is
	 *           used Children are copied too
	 * 
	 * @return new view
	 */

	public static Node copyView(DiagramEditPart diagramEP, View toShapesCompartmentView,
			View viewToBeCopied) {
		Node newView = copyViewHelper(diagramEP, toShapesCompartmentView, viewToBeCopied, null,
				false, false, true, true, false, null, false, null);
		return newView;
	}

	/**
	 * 
	 * @see ConvertToShapesOrTreeCommand -- used when copying children views from one container to
	 *      another
	 * 
	 * @param diagramEP
	 *           --
	 * @param fromView
	 * @param toView
	 * 
	 */

	public static void copyViewChildren(DiagramEditPart diagramEP, View fromView, View toView) {
		for (Iterator<?> it = fromView.getChildren().iterator(); it.hasNext();) {
			Node fromViewChild = (Node) it.next();
			copyViewHelper(diagramEP, toView, fromViewChild, null, false, true, true, true, false,
					null, true, null);
		}
	}

	/**
	 * copies a view from one container view to another (by recreating it and copying its
	 * attributes/children views)-- destination can be a shapes container or the diagram
	 * 
	 * @param diagramEP
	 *           -- the diagram editpart
	 * @param toCompartmentView
	 *           -- shapes compartment or diagram to copy this view into
	 * @param viewToBeCopied
	 *           -- view to be copied
	 * @param location
	 *           -- location to place view-- if null the old view's location is used instead
	 * @param translateToParent
	 *           TODO
	 * @param createGrid
	 *           -- position children in a grid
	 * @param isCopyChildren
	 *           -- copy this view's children views and it's attributes
	 * @param isTargetShapesMode
	 *           is target in shapes mode
	 * @param isParentCollapsed
	 *           TODO
	 * @param visibleList
	 *           -- if copying a view from an import diagram, this is a list of all visible units
	 *           from that import
	 * @param searchForMatchInNewCompartment
	 *           -- set to false originally, then set to true when called re-entrantly by this method
	 *           to copy the children-- tells the method to find a matching new view in the target
	 *           compartment before trying to create one
	 * @param toEditPart
	 *           -- if provided, the location is assumed to be in screen coordinates and therefore
	 *           must be translated to be relative to this editpart's compartment
	 * @return the new view
	 */
	private static Node copyViewHelper(DiagramEditPart diagramEP, View toCompartmentView,
			View viewToBeCopied, Point location, boolean translateToParent, boolean createGrid,
			boolean isCopyChildren, boolean isTargetShapesMode, boolean isParentCollapsed,
			List<DeployModelObject> visibleList, boolean searchForMatchInNewCompartment,
			AbstractGraphicalEditPart toEditPart) {

		// get the element for which we will be creating a new view
		EObject elementToBeCopied = viewToBeCopied.getElement();

		// if copying from an import diagram, find the matching proxy in this topology
		if (visibleList != null && elementToBeCopied instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) elementToBeCopied;
			elementToBeCopied = null;
			for (DeployModelObject proxyDmo : visibleList) {
				if (dmo.getQualifiedName().equals(proxyDmo.getQualifiedName())) {
					elementToBeCopied = proxyDmo;
					break;
				}

			}
		}

		// when re-rentrantly creating child views, try to find a match in the new compartment
		// --just finds name, list or shapes compartment views
		Node newView = null;
		if (searchForMatchInNewCompartment) {
			for (Iterator it = toCompartmentView.getChildren().iterator(); it.hasNext();) {
				String type = viewToBeCopied.getType();
				Node view = (Node) it.next();
				if (typesEqual(type, view.getType()) && view.getElement() == elementToBeCopied) {
					newView = view;
					break;
				}
			}
		}

		// we need to create a new view
		if (newView == null) {
			// if we didn't find a matching proxy, then this might be private so don't create view
			if (elementToBeCopied == null) {
				return null;
			}

			// create the container view as a tree or shapes container based on source view
			if (elementToBeCopied != null
					&& (viewToBeCopied.getType() == null || viewToBeCopied.getType().length() == 0)) {
				boolean hasList = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.getChildBySemanticHint(viewToBeCopied,
								DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) != null;
				boolean hasShapes = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.getChildBySemanticHint(viewToBeCopied,
								DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) != null;
				if (hasList || hasShapes) {
					DeployCoreViewProvider
							.setOverridePreference(hasList ? DeployCoreViewProvider.FORCE_TREE
									: DeployCoreViewProvider.FORCE_SHAPES);
				}
			}

			// create the view
			newView = createNode(new EObjectAdapter(elementToBeCopied), toCompartmentView,
					viewToBeCopied.getType(), -1, diagramEP.getDiagramPreferencesHint());
			DeployCoreViewProvider.setOverridePreference(0);
			if (newView == null) {
				return null;
			}
		}

		// if this view supports drawers, copy drawer state
		if (isTargetShapesMode) {
			if (isFeatureSupported(viewToBeCopied, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed())) {
				// once we encounter a collapsed parent, all other views are collapsed
				boolean isCollapsed = isParentCollapsed
						|| ((Boolean) getStructuralFeatureValue(viewToBeCopied, NotationPackage.eINSTANCE
								.getDrawerStyle_Collapsed())).booleanValue();
				setStructuralFeatureValue(newView,
						NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), new Boolean(isCollapsed));
				if (isCollapsed) {
					isParentCollapsed = true;
				}
			}

			// copy size
			int width = ((Integer) getStructuralFeatureValue(viewToBeCopied, NotationPackage.eINSTANCE
					.getSize_Width())).intValue();
			int height = ((Integer) getStructuralFeatureValue(viewToBeCopied,
					NotationPackage.eINSTANCE.getSize_Height())).intValue();
			if (isParentCollapsed || toCompartmentView.getType() != null
					&& toCompartmentView.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)) {
				width = height = -1;
			}
			setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Width(), new Integer(
					width));
			setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Height(),
					new Integer(height));

			// set position of new view 
			Point loc = null;
			// if location is null, use original position of old view
			// when copying child views, their view locations are used "as-is"
			if (location == null) {
				int x = ((Integer) getStructuralFeatureValue(viewToBeCopied, NotationPackage.eINSTANCE
						.getLocation_X())).intValue();
				int y = ((Integer) getStructuralFeatureValue(viewToBeCopied, NotationPackage.eINSTANCE
						.getLocation_Y())).intValue();
				loc = new Point(x, y);
				// else use position specified by calling method
			} else {
				loc = location.getCopy();
				// if location is relative to the screen, should we convert to be relative to this parent
				if (translateToParent && toEditPart != null) {
					translateToCompartment(loc, toEditPart);
				}
			}
			setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_X(), new Integer(
					loc.x));
			setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_Y(), new Integer(
					loc.y));
		}

		// copy font
		copyFont(viewToBeCopied, newView);

		// copy colors
		copyColorsAndText(viewToBeCopied, newView);

		// copy filter states
		DeployStyle fromStyle = (DeployStyle) viewToBeCopied.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		DeployStyle toStyle = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (fromStyle != null && toStyle != null) {
			toStyle.getFilteredSemanticElements().addAll(fromStyle.getFilteredSemanticElements());
			toStyle.getFilteredDecorations().addAll(fromStyle.getFilteredDecorations());

			// copy collpased/expand sizes
			toStyle.setCollapseHeight(fromStyle.getCollapseHeight());
			toStyle.setCollapseWidth(fromStyle.getCollapseWidth());
			toStyle.setExpandHeight(fromStyle.getExpandHeight());
			toStyle.setExpandWidth(fromStyle.getExpandWidth());
		}

		// copy containment state (if hosted does it appear in host)
		ContainmentStateUtils.copyState(viewToBeCopied, newView);

		// now process the children
		if (isCopyChildren) {
			int i = 0;
			Point childLocation = null;
			if (createGrid && isCompartmentView(viewToBeCopied)) {
				childLocation = new Point(500, 500);
			}
			for (Iterator it = viewToBeCopied.getChildren().iterator(); it.hasNext();) {
				Node oldViewChild = (Node) it.next();
				// copy attributes from old view to new view
				// the view we just created in the to container
				// for each child of the old view, copy their traits to the new view's children
				// location is null-- use the old child's location
				// searchForMatchInNewCompartment is true so that traits are passed on to an existing view else created
				copyViewHelper(diagramEP, newView, oldViewChild, childLocation, translateToParent,
						createGrid, true, isTargetShapesMode, isParentCollapsed, visibleList, true, null);

				// if we are tiling the children, calc new position now
				if (childLocation != null) {
					childLocation.x += DeployCoreConstants.SERVER_UNIT_WIDTH * 3 / 2;
					if (++i > 2) {
						i = 0;
						childLocation.x = 500;
						childLocation.y += DeployCoreConstants.SERVER_UNIT_HEIGHT + 400;
					}
				}
			}
		} else {
			// if we're not copying the children, at least collapse any shape container
			View shapeContainerEP = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			if (shapeContainerEP != null) {
				setStructuralFeatureValue(shapeContainerEP, NotationPackage.eINSTANCE
						.getDrawerStyle_Collapsed(), new Boolean(true));
			}

		}
		return newView;
	}

	private static boolean typesEqual(String type, String type2) {
		if (type == null) {
			type = ""; //$NON-NLS-1$
		}
		if (type2 == null) {
			type2 = ""; //$NON-NLS-1$
		}
		boolean bRet = type.compareTo(type2) == 0;
		if (!bRet) {
			// if converting from shapes to list while copying
			bRet = (type.equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) || type
					.equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT))
					&& (type2.equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) || type2
							.equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT));
		}
		return bRet;
	}

	/**
	 * adjust an editpart's location from a screen coordinate to be relative to the upper corner of
	 * it's new container
	 * 
	 * @param screenLocation
	 *           -- initial location
	 * @param translateForThisEditpart
	 *           -- the editpart for which this location must be converted to a location inside of a
	 *           shape container
	 */
	public static void translateToCompartment(Point screenLocation,
			AbstractGraphicalEditPart translateForThisEditpart) {
		EditPart walker = translateForThisEditpart;
		while (walker != null && !(walker instanceof DeployDiagramEditPart)) {
			if (DeployShapeNodeEditPart.isShapesMode(walker)) {
				View shapesView = (View) ((DeployShapeNodeEditPart) walker).getModel();
				screenLocation.x -= ((Integer) getStructuralFeatureValue(shapesView,
						NotationPackage.eINSTANCE.getLocation_X())).intValue();
				screenLocation.y -= ((Integer) getStructuralFeatureValue(shapesView,
						NotationPackage.eINSTANCE.getLocation_Y())).intValue();
				int hdrHeight = GEFUtils.getShapesHeaderHeight(((IGraphicalEditPart) walker)
						.getFigure())
						+ DeployCoreConstants.SHAPES_UNIT_INSET * 2;
				screenLocation.x -= DeployCoreConstants.SHAPES_UNIT_INSET;
				screenLocation.y -= hdrHeight;
			}
			walker = walker.getParent();
		}
	}

	/**
	 * copy color styles on one view to another
	 * 
	 * @param fromView
	 * @param toView
	 */
	public static void copyColorsAndText(View fromView, View toView) {
		FillStyle fillStyle = (FillStyle) fromView.getStyle(NotationPackage.Literals.FILL_STYLE);
		if (fillStyle != null) {
			if (fillStyle.eIsSet(NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
				int fillClr = fillStyle.getFillColor();
				setStructuralFeatureValue(toView, NotationPackage.Literals.FILL_STYLE__FILL_COLOR,
						new Integer(fillClr));
			}
		}
		ShapeStyle shapeStyle = (ShapeStyle) fromView.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		if (shapeStyle != null) {
			ShapeStyle shapetoStyle = (ShapeStyle) toView
					.getStyle(NotationPackage.Literals.SHAPE_STYLE);
			if (shapeStyle != null && shapetoStyle != null) {
				shapetoStyle.setFillColor(shapeStyle.getFillColor());
				shapetoStyle.setDescription(shapeStyle.getDescription());
			}
		}

		TextStyle textStyle = (TextStyle) fromView.getStyle(NotationPackage.Literals.TEXT_STYLE);
		if (textStyle != null) {
			TextStyle texttoStyle = (TextStyle) toView.getStyle(NotationPackage.Literals.TEXT_STYLE);
			if (textStyle != null && texttoStyle != null) {
				texttoStyle.setTextAlignment(textStyle.getTextAlignment());
			}
		}

		LineStyle lineStyle = (LineStyle) fromView.getStyle(NotationPackage.Literals.LINE_STYLE);
		if (lineStyle != null) {
			if (lineStyle.eIsSet(NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
				int lineClr = lineStyle.getLineColor();
				setStructuralFeatureValue(toView, NotationPackage.Literals.LINE_STYLE__LINE_COLOR,
						new Integer(lineClr));
			}
		}

	}

	/**
	 * copy font from one view to another
	 * 
	 * @param fromView
	 * @param toView
	 */
	public static void copyFont(View fromView, View toView) {
		FontStyle style = (FontStyle) fromView.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		if (style != null) {
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__FONT_NAME)) {
				setStructuralFeatureValue(toView, NotationPackage.Literals.FONT_STYLE__FONT_NAME, style
						.getFontName());
			}
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT)) {
				setStructuralFeatureValue(toView, NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT,
						new Integer(style.getFontHeight()));
			}
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__FONT_COLOR)) {
				setStructuralFeatureValue(toView, NotationPackage.Literals.FONT_STYLE__FONT_COLOR,
						new Integer(style.getFontColor()));
			}
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__BOLD)) {
				setStructuralFeatureValue(toView, NotationPackage.Literals.FONT_STYLE__BOLD, style
						.isBold() ? Boolean.TRUE : Boolean.FALSE);
			}
		}

	}

	/**
	 * @param fromView
	 * @param toView
	 */
	public static void copyFilteredElements(View fromView, View toView) {
		copyFilteredElementsHelper(fromView, toView, null, false);
	}

	private static void copyFilteredElementsHelper(View fromView, View toView,
			View toCompartmentView, boolean searchForMatch) {
		EObject elementToBeCopied = fromView.getElement();
		if (searchForMatch && toCompartmentView != null) {
			for (Iterator<?> it = toCompartmentView.getChildren().iterator(); it.hasNext();) {
				String type = fromView.getType();
				Node view = (Node) it.next();
				if (typesEqual(type, view.getType()) && view.getElement() == elementToBeCopied) {
					toView = view;
					break;
				}
			}
		}
		// no match-- impossible case
		if (toView == null) {
			return;
		}

		// copy filtered elements
		DeployStyle fromStyle = (DeployStyle) fromView.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (fromStyle != null && fromStyle.getFilteredSemanticElements().size() > 0) {
			DeployStyle toStyle = (DeployStyle) toView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			toStyle.getFilteredSemanticElements().addAll(fromStyle.getFilteredSemanticElements());
		}

		// now process the children
		for (Iterator<?> it = fromView.getChildren().iterator(); it.hasNext();) {
			Node oldViewChild = (Node) it.next();
			copyFilteredElementsHelper(oldViewChild, null, toView, true);
		}
	}

	/**
	 * copy import related stuff to new view
	 * 
	 * @param fromView
	 * @param toView
	 */
	public static void copyImportSupport(View fromView, View toView) {
		DeployStyle style = (DeployStyle) fromView.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			if (style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__IMPORT)) {
				setStructuralFeatureValue(toView, DeployNotationPackage.Literals.DEPLOY_STYLE__IMPORT,
						style.getImport());
			}
			if (style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__PROXY_HASH_CODE)) {
				setStructuralFeatureValue(toView,
						DeployNotationPackage.Literals.DEPLOY_STYLE__PROXY_HASH_CODE, style
								.getProxyHashCode());
			}
			if (style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_NAME)) {
				setStructuralFeatureValue(toView,
						DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_NAME, style.getElementName());
			}
			if (style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_CATEGORY)) {
				setStructuralFeatureValue(toView,
						DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_CATEGORY, style
								.getElementCategory());
			}
		}
	}

	/**
	 * create views from a template and topologyv file
	 * 
	 * @param templateUri
	 * @param templateVUri
	 * @param toContainer
	 * @param diagramEP
	 * @param point
	 */
	static public void copyTemplateElementsAndViews(String templateUri, String templateVUri,
			View toContainer, DeployDiagramEditPart diagramEP, Point point) {
		Resource notationResource = loadTemplateResource(templateVUri, true);
		//Need to force the reload of the template resource as well to avoid failing
		//semantic element resolutions.
		loadTemplateResource(templateUri, true);

		EObject eobject = notationResource.getContents().get(0);
		if (eobject instanceof Diagram) {
			Diagram fromDiagram = (Diagram) eobject;
			copyDiagramElementsAndViews(DiagramUtils.getAllChildViewsIncludingGroup(fromDiagram),
					toContainer, diagramEP, point, false, templateUri);
		}
	}

	private static Resource loadTemplateResource(String uriString, boolean forceReload) {
		URI uri = org.eclipse.emf.common.util.URI.createURI(uriString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(uri, false);
		if (resource != null) {
			if (resource.isLoaded() && forceReload) {
				resource.unload();
				try {
					if (!resource.isLoaded()) {
						resource.load(Collections.emptyMap());
					}
				} catch (IOException e) {
					DeployCorePlugin.logError(0, e.getMessage(), e);
				} finally {
					resource.setModified(false);
				}
			}
		} else {
			resource = JEMUtilPlugin.getPluginResourceSet().getResource(uri, true);
		}
		return resource;
	}

	/**
	 * @param fromViewList
	 * @param toContainer
	 * @param diagramEP
	 * @param point
	 * @param cascadeViews
	 * @param templateUri
	 */
	static public void copyDiagramElementsAndViews(List fromViewList, View toContainer,
			final DeployDiagramEditPart diagramEP, Point point, boolean cascadeViews,
			String templateUri) {

		// copy topologyv's topology units to our topology
		Diagram toDiagram = toContainer.getDiagram();
		Topology topTo = (Topology) toDiagram.getElement();
		List<Unit> unitsFrom = new ArrayList<Unit>();
		Topology topology = collectDiagramUnits(fromViewList, unitsFrom);
		Map<Unit, Unit> unitMap = null;
		if (templateUri != null) {
			Resource resource = loadTemplateResource(templateUri, true);
			EObject eobject = resource.getContents().get(0);
			if (eobject instanceof DeployCoreRoot) {
				DeployCoreRoot root = (DeployCoreRoot) eobject;
				topology = root.getTopology();
			}
			if (topology == null) {
				return;
			}
			unitMap = ResolutionUtils.intelligentDeepCopyMap(topology.getUnits(), topTo, true);
		} else {
			unitMap = ResolutionUtils.intelligentDeepCopyMap(unitsFrom, topTo, true);
		}

		for (Iterator<Map.Entry<Unit, Unit>> it = unitMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Unit, Unit> entry = it.next();
			topTo.getUnits().add(entry.getValue());
		}

		// calculate upper, left of top most view
		Point offsetPt = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		for (Iterator<?> it = fromViewList.iterator(); it.hasNext();) {
			View child = (View) it.next();
			int x = ((Integer) getStructuralFeatureValue(child, NotationPackage.eINSTANCE
					.getLocation_X())).intValue();
			int y = ((Integer) getStructuralFeatureValue(child, NotationPackage.eINSTANCE
					.getLocation_Y())).intValue();
			offsetPt.x = x < offsetPt.x ? x : offsetPt.x;
			offsetPt.y = y < offsetPt.y ? y : offsetPt.y;
		}

		// if toContainer isn't diagram and it's a view to an element that 
		// we just created, change the toContainer to the diagram (we don't want to paste one new unit into the next new unit)
		boolean isNotDiagram = toContainer != toDiagram;
		if (isNotDiagram && _allCopiedElements.contains(resolveSemanticElement(toContainer))) {
			toContainer = toDiagram;
			isNotDiagram = false;
		}

		// when pasting, cascade units back into diagram
		if (cascadeViews) {
			if (_fromUnit == null || !unitsFrom.contains(_fromUnit)) {
				_fromUnit = unitsFrom.size() > 0 ? unitsFrom.get(0) : null;
				_allCopiedElements.clear();
				_cascadingPt.setLocation(offsetPt);
			}
			_allCopiedElements.addAll(unitMap.values());
			_cascadingPt.performTranslate(250, 250);

			// if cascading point falls outside of screen, put it in center 
			Viewport vp = diagramEP.getViewport();
			Point screenOffset = new Point(vp.getHorizontalRangeModel().getValue(), vp
					.getVerticalRangeModel().getValue());
			Rectangle portRect = (Rectangle) MapModeUtil.getMapMode().DPtoLP(
					vp.getBounds().getCopy().translate(screenOffset));
			if (!portRect.contains(_cascadingPt)) {
				_cascadingPt = portRect.getCenter();
			}
			point = _cascadingPt.getCopy();
		}

		// create views from fromDiagram in toContainer
		if (isNotDiagram) {
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(toContainer,
					NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), Boolean.FALSE);
		}

		final List<View> newViews = new ArrayList<View>();
		for (Iterator<?> it = fromViewList.iterator(); it.hasNext();) {
			View oldView = (View) it.next();
			View newView = copyTemplateElementsAndViewsHelper(oldView, unitMap, toContainer,
					diagramEP, false, offsetPt, point);
			newViews.add(newView);

			// if adding to a group or hosting list, create the links now
			if (isNotDiagram) {
				try {
					new CreateMemberOrHostingLinkCommand(diagramEP.getEditingDomain(), newView,
							toContainer).execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					DeployCorePlugin.logError(0, e.getMessage(), e);
				}
			}
		}

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				ConsolidationLinkUtils.refreshConsolidatedLinks(diagramEP);
			}
		});

		// select created views
		final EditPartViewer viewer = diagramEP.getViewer();
		final Map v2eMap = viewer.getEditPartRegistry();
		viewer.deselectAll();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				for (View view : newViews) {
					EditPart ep = (EditPart) v2eMap.get(view);
					if (ep != null) {
						viewer.appendSelection(ep);
					}
				}
			}
		});
	}

	private static View copyTemplateElementsAndViewsHelper(View oldView, Map<Unit, Unit> unitMap,
			View toContainer, DeployDiagramEditPart diagramEP, boolean isParentCollapsed,
			Point offsetPt, Point point) {

		// create new view
		boolean hasList = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.getChildBySemanticHint(
				oldView, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) != null;
		boolean hasShapes = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getChildBySemanticHint(oldView, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) != null;
		if (hasList || hasShapes) {
			DeployCoreViewProvider.setOverridePreference(hasList ? DeployCoreViewProvider.FORCE_TREE
					: DeployCoreViewProvider.FORCE_SHAPES);
		}
		EObject eo = resolveSemanticElement(oldView);
		View newView = createNode(eo != null ? new EObjectAdapter(eo) : null, toContainer, oldView
				.getType(), -1, diagramEP.getDiagramPreferencesHint());
		newView.setElement(unitMap.get(eo));
		DeployCoreViewProvider.setOverridePreference(0);

		// position the new view
		int x = ((Integer) getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		if (offsetPt != null && point != null) {
			x = x - offsetPt.x + point.x;
			y = y - offsetPt.y + point.y;
		}
		setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_X(), new Integer(x));
		setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_Y(), new Integer(y));

		// copy size
		int width = ((Integer) getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		int height = ((Integer) getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE
				.getSize_Height())).intValue();
		if (isParentCollapsed) {
			width = height = -1;
		}
		setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Width(), new Integer(
				width));
		setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Height(), new Integer(
				height));

		// copy font
		copyFont(oldView, newView);

		// copy colors
		copyColorsAndText(oldView, newView);

		// copy filter states
		DeployStyle fromStyle = (DeployStyle) oldView.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		DeployStyle toStyle = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (fromStyle != null && toStyle != null) {
			toStyle.getFilteredSemanticElements().addAll(fromStyle.getFilteredSemanticElements());
			toStyle.getFilteredDecorations().addAll(fromStyle.getFilteredDecorations());

			//copy collpased/expand sizes
			toStyle.setCollapseHeight(fromStyle.getCollapseHeight());
			toStyle.setCollapseWidth(fromStyle.getCollapseWidth());
			toStyle.setExpandHeight(fromStyle.getExpandHeight());
			toStyle.setExpandWidth(fromStyle.getExpandWidth());
		}

		// copy containment state (if hosted does it appear in host)
		ContainmentStateUtils.copyState(oldView, newView);

		// now create children
		View fromCompartment = getChildBySemanticHint(oldView,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (fromCompartment == null) {
			fromCompartment = getChildBySemanticHint(oldView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		View toCompartment = getChildBySemanticHint(newView,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (toCompartment == null) {
			toCompartment = getChildBySemanticHint(newView,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (fromCompartment != null && toCompartment != null) {
			// copy collapse state
			if (isFeatureSupported(fromCompartment, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed())) {
				// once we encounter a collapsed parent, all other views are collapsed
				boolean isCollapsed = isParentCollapsed
						|| ((Boolean) getStructuralFeatureValue(fromCompartment,
								NotationPackage.eINSTANCE.getDrawerStyle_Collapsed())).booleanValue();
				setStructuralFeatureValue(toCompartment, NotationPackage.eINSTANCE
						.getDrawerStyle_Collapsed(), new Boolean(isCollapsed));
				if (isCollapsed) {
					isParentCollapsed = true;
				}
			}
			// copy children
			for (Iterator<?> it = fromCompartment.getChildren().iterator(); it.hasNext();) {
				copyTemplateElementsAndViewsHelper((View) it.next(), unitMap, toCompartment, diagramEP,
						isParentCollapsed, null, null);
			}
		}
		return newView;
	}

	/**
	 * given a view, return all the units of all its child views
	 * 
	 * @param views
	 * @param units
	 */
	public static Topology collectDiagramUnits(List<View> views, List<Unit> units) {
		Topology topology = null;
		for (Iterator<View> it = views.iterator(); it.hasNext();) {
			View view = it.next();
			EObject eo = resolveSemanticElement(view);
			if (eo instanceof Unit) {
				Unit unit = (Unit) eo;
				units.add(unit);
				View compartment = getChildBySemanticHint(view,
						DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (compartment != null) {
					collectDiagramUnits(compartment.getChildren(), units);
				} else {
					compartment = getChildBySemanticHint(view,
							DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
					if (compartment != null) {
						collectDiagramUnits(compartment.getChildren(), units);
					}
				}
			}
		}
		return topology;
	}

	/**
	 * convert unresolved proxy views to place holders --OR-- restore place holder proxy views back
	 * to real proxy views
	 * 
	 * @param diagram
	 *           -- a parent view, diagram or individual import topology compartment
	 * @param list
	 */
	public static void refreshProxyViews(Diagram diagram, final List<DiagramUpdateData> list) {

		// find all proxy views that need to be converted to place holders or are currently place holders
		final Set<View> unresolvedProxyViews = new HashSet<View>();
		final Set<View> destroyProxyViews = new HashSet<View>();
		final Map<Import, Boolean> imprtCache = new HashMap<Import, Boolean>();
		final Map<Integer, List<View>> placeholderViews = new HashMap<Integer, List<View>>();
		findProxyViews(diagram.getVisibleChildren(), unresolvedProxyViews, destroyProxyViews,
				imprtCache, placeholderViews);

		// find all proxies in topology
		final List<Unit> proxyList = new ArrayList<Unit>();
		Topology topology = (Topology) resolveSemanticElement(diagram);
		if (topology != null) {
			for (Iterator<Import> it = topology.getImports().iterator(); it.hasNext();) {
				InstanceConfiguration ic = it.next().getInstanceConfiguration();
				proxyList.addAll(ic.getVisibleUnits());
			}
		}

		if (unresolvedProxyViews.size() != 0 || destroyProxyViews.size() != 0
				|| placeholderViews.size() != 0) {
			// set type to "UnresolvedProxy" and element to null
			try {
				new AbstractEMFOperation(TransactionUtil.getEditingDomain(diagram),
						"refresh proxy views") { //$NON-NLS-1$
					protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {

						// convert any unresolved proxy views into place holders
						// (the Import is missing along with its proxies)
						for (Iterator<View> it = unresolvedProxyViews.iterator(); it.hasNext();) {
							View view = it.next();
							// if the import is gone, we make these into unref views
							view.setElement(null);
							view.setType(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT);
							recordChange(view, list, DiagramUpdateData.UNREFED);
						}

						// destroy views to proxies that no longer exist in an import that still exists
						// (the Import still exists but the unit doesn't)
						for (Iterator<View> it = destroyProxyViews.iterator(); it.hasNext();) {
							View view = it.next();
							if (view != null) {
								recordChange(view, list, DiagramUpdateData.DELETED);
								destroy(view);
							}
						}

						// see if we can convert any placeholder views back into real proxy views
						if (placeholderViews.size() > 0) {
							for (Iterator<Unit> it = proxyList.iterator(); it.hasNext();) {
								Unit proxy = it.next();
								List<View> views = placeholderViews.get(new Integer(proxy.hashCode()));
								if (views != null) {
									for (Iterator<View> it2 = views.iterator(); it2.hasNext();) {
										View view = it2.next();
										// delete edges-- policies will fill back in
										if (view instanceof Edge) {
											destroy(view);
										} else {
											view.setType(""); //$NON-NLS-1$
											view.setElement(proxy);
										}
										recordChange(view, list, DiagramUpdateData.REREFED);
									}
								}
							}
						}
						return Status.OK_STATUS;
					}

					private void recordChange(View view, List<DiagramUpdateData> list, int change) {
						String name = DiagramUpdateData.getQualifiedName(view,
								change == DiagramUpdateData.DELETED);
						list.add(new DiagramUpdateData(null, view, null, name,
								view instanceof Edge ? Messages.DeployLinkCanonicalConnectorEditPolicy_Lin_
										: Messages.DeployDeleteAction_Uni_, false, change));
					}

				}.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}
		}
	}

	private static void findProxyViews(EList visibleChildren, Set<View> unresolvedProxyViews,
			Set<View> destroyProxyViews, Map<Import, Boolean> importCache,
			Map<Integer, List<View>> placeholderViews) {
		for (Iterator<View> it = visibleChildren.iterator(); it.hasNext();) {
			View view = it.next();
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null
					&& style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__PROXY_HASH_CODE)) {
				// if proxy is unresolved (and not already converted), add to unresolved set
				String type = view.getType();
				if (type == null || !type.equals(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT)) {
					if (resolveSemanticElement(view) == null) {
						if (isImportMissing(view, importCache)) {
							unresolvedProxyViews.add(view);
							unresolvedProxyViews.addAll(view.getSourceEdges());
							unresolvedProxyViews.addAll(view.getTargetEdges());
						} else if (view != null) {
							// if the import still exists, we assume only its contents have changed 
							//  (not that it hasn't been checked out) so we delete the view
							destroyProxyViews.add(view);
						}
					}
				} else if (type != null
						&& type.equals(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT)) {
					// else if view type is a place holder, add to place holder map
					Integer hashCode = new Integer(style.getProxyHashCode());
					List<View> views = placeholderViews.get(hashCode);
					if (views == null) {
						views = new ArrayList<View>();
						placeholderViews.put(hashCode, views);
					}
					views.add(view);
					views.addAll(view.getSourceEdges());
					views.addAll(view.getTargetEdges());
				}
			}
			findProxyViews(view.getVisibleChildren(), unresolvedProxyViews, destroyProxyViews,
					importCache, placeholderViews);
		}
	}

	// if the import is still there, we allow the canonical edit policies to delete the view
	private static boolean isImportMissing(View view, Map<Import, Boolean> importCache) {
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style.getImport() instanceof Import) {
			Import imprt = (Import) style.getImport();
			// determine if a file exists for this import; cache results
			if (!importCache.containsKey(imprt)) {
				IFile file = WorkbenchResourceHelper.getFile(imprt);
				if (file != null) {
					IProject project = file.getProject();
					IFile f = NamespaceCore.resolveTopology(project, imprt.getNamespace(), imprt
							.getDisplayName());
					importCache.put(imprt, new Boolean(f == null || !f.exists()));
				}
			}
			return importCache.get(imprt) != null ? importCache.get(imprt).booleanValue() : true;
		}
		return true;
	}

	/**
	 * @param view
	 * @return is this a note view (doesn't have an element)
	 */
	public static boolean isNoteType(View view) {
		String type = view.getType();
		if (type != null && type.length() > 0) {

			if (type.equals("Note") || type.equals("Text") || //$NON-NLS-1$ //$NON-NLS-2$
					type.equals(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT)) {
				return true;
			}

			// don't delete geoshapes
			for (Iterator<String> it2 = GeoshapeConstants.getSupportedShapes().iterator(); it2
					.hasNext();) {
				if (type.equals(it2.next())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * make sure values stored in deploystyle are up to date; used when the model element becomes
	 * unresolved to still display name/category in display
	 * 
	 * @param ep
	 */
	public static void refreshDeployStyle(final DeployShapeNodeEditPart ep) {
		View view = ep.getNotationView();
		final EObject eo = ep.resolveSemanticElement();
		final String name = getElementName(eo);
		final String category = ep.getCategory();
		final DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null
				&& (style.getElementName() == null || !style.getElementName().equals(name)
						|| style.getElementCategory() == null || !style.getElementCategory().equals(
						category))) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(ep.getEditingDomain(),
					"", Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE), null) { //$NON-NLS-1$
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
						IAdaptable info) throws ExecutionException {
					style.setElementName(name);
					style.setElementCategory(category);
					// set proxy info only once
					if (PropertyUtils.isProxy((DeployModelObject) eo)
							&& !style.eIsSet(DeployNotationPackage.Literals.DEPLOY_STYLE__PROXY_HASH_CODE)) {
						style.setProxyHashCode(eo.hashCode());
						style.setImport(getImport(ep, eo));
					}
					return CommandResult.newOKCommandResult();
				}
			};
			if (cmd.canExecute()) {
				try {
					cmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		}

	}

	static private String getElementName(EObject element) {
		String name = null;
		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			return unit.getCaptionProvider().title(unit);
		} else if (element instanceof DeployModelObject) {
			name = ((DeployModelObject) element).getDisplayName();
		}
		if (name == null || name.trim().length() == 0) {
			name = ((DeployModelObject) element).getName();
		}
		return name;
	}

	static private Import getImport(DeployShapeNodeEditPart ep, EObject element) {
		if (element instanceof Unit) {
			Import imprt = GMFUtils.getImport((Unit) element);
			if (imprt != null) {
				List<DeployShapeNodeEditPart> list = GMFUtils.getEditPartsFor(ep, imprt);
				if (list.size() > 0) {
					return (Import) list.get(0).resolveSemanticElement();
				}
			}
		}
		return null;
	}

	/**
	 * filter/unfilter this element from its canonical edit policy
	 * 
	 * @param toContainerEP
	 * @param element
	 * @param bFilter
	 * @return was it filtered/unfiltered?
	 * 
	 */
	public static boolean filterSemanticElement(DeployShapeNodeEditPart toContainerEP,
			EObject element, boolean bFilter) {
		return filterSemanticElement(toContainerEP.getNotationView(), element, bFilter);
	}

	/**
	 * filter/unfilter this element from its canonical edit policy
	 * 
	 * @param containerView
	 * @param element
	 * @param bFilter
	 * @return was it filtered/unfiltered?
	 * 
	 */
	public static boolean filterSemanticElement(View containerView, EObject element, boolean bFilter) {
		boolean bRet = false;
		if (containerView instanceof View) {
			DeployStyle style = (DeployStyle) containerView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				if (bFilter) {
					bRet = !style.getFilteredSemanticElements().contains(element);
					if (bRet) {
						style.getFilteredSemanticElements().add(element);
					}
				} else {
					bRet = style.getFilteredSemanticElements().contains(element);
					if (bRet) {
						style.getFilteredSemanticElements().remove(element);
					}
				}
			}
		}
		return bRet;
	}

	/**
	 * @param view
	 * @return if a view is a member of a snap group, all of the views in that group
	 */
	public static List<View> getAllSnapGroupViews(View view) {
		List<View> list = new ArrayList<View>();
		if (view != null) {
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getSnapParent() != null
					&& style.getSnapParent().eContainer() instanceof View) {
				for (Iterator<?> it = ((View) style.getSnapParent().eContainer()).getChildren()
						.iterator(); it.hasNext();) {
					View v = (View) it.next();
					DeployStyle s = (DeployStyle) v.getStyle(DeployNotationPackage.eINSTANCE
							.getDeployStyle());
					list.addAll(s.getSnapChildren());
				}
			}
		}
		return list;
	}

	/**
	 * @param diagram
	 * @param unit
	 * @return the first view with this unit in this diagram
	 */
	public static View findViewInDiagram(Diagram diagram, Unit unit) {
		return findViewInDiagramHelper(DiagramUtils.getAllChildViewsIncludingGroup(diagram), unit);
	}

	private static View findViewInDiagramHelper(List<View> list, Unit unit) {
		View view = null;
		for (Iterator<?> it = list.iterator(); it.hasNext() && view == null;) {
			View v = (View) it.next();
			EObject eo = resolveSemanticElement(v);
			if (eo instanceof Unit) {
				Unit u = (Unit) eo;
				if (u.getQualifiedName().equals(unit.getQualifiedName())) {
					view = v;
				} else {
					View compartment = getChildBySemanticHint(v,
							DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
					if (compartment != null) {
						view = findViewInDiagramHelper(compartment.getChildren(), unit);
					} else {
						compartment = getChildBySemanticHint(v,
								DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
						if (compartment != null) {
							view = findViewInDiagramHelper(compartment.getChildren(), unit);
						}
					}
				}
			}
		}
		return view;
	}

	/**
	 * @param view
	 * @return compartment view
	 */
	public static View getCompartmentView(View view) {
		View compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getChildBySemanticHint(view, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(view, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(view, DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(view, DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(view, DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(view, DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		return compartmentView;
	}

	/**
	 * @param view
	 * @return is view a compartment
	 */
	public static boolean isCompartmentView(View view) {
		String type = view.getType();
		if (type != null) {
			return type.equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT)
					|| type.equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)
					|| type.equals(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT)
					|| type.equals(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT)
					|| type.equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT)
					|| type.equals(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		return false;
	}

	/**
	 * @param viewKind
	 * @param elementAdapter
	 * @param containerView
	 * @param semanticHint
	 * @param index
	 * @param persisted
	 * @param preferencesHint
	 * @return new view
	 */
	public static View createView(Class viewKind, IAdaptable elementAdapter, View containerView,
			String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		View newView = ViewService.getInstance().createView(viewKind, elementAdapter, containerView,
				semanticHint, index, persisted, preferencesHint);
		if (newView == null && viewKind == Node.class) {
			newView = ViewService.getInstance().createView(viewKind, elementAdapter, containerView,
					DeployCoreConstants.MISSINGDOMAINUI_SEMANTICHINT, index, persisted, preferencesHint);
			if (newView != null) {
				newView.setType(""); //$NON-NLS-1$
			}
		}
		return newView;
	}

	/**
	 * @param objectAdapter
	 * @param containerView
	 * @param type
	 * @param i
	 * @param diagramPreferencesHint
	 * @return new view
	 */
	public static Node createNode(EObjectAdapter objectAdapter, View containerView, String type,
			int i, PreferencesHint diagramPreferencesHint) {
		Node newView = ViewService.getInstance().createNode(objectAdapter, containerView, type, -1,
				diagramPreferencesHint);
		// if no view found, the domain might not be providing a ui plugin, so create the view from core ui
		if (newView == null) {
			newView = ViewService.getInstance().createNode(objectAdapter, containerView,
					DeployCoreConstants.MISSINGDOMAINUI_SEMANTICHINT, -1, diagramPreferencesHint);
			if (newView != null) {
				newView.setType(""); //$NON-NLS-1$
			}
		}
		return newView;
	}

	/**
	 * given a view, remove it from its container and insert next to its top parent on the diagram
	 * 
	 * @param view
	 */
	public static void insertViewNextToParent(View view) {
		// make sure backed by a unit
		EObject eo = resolveSemanticElement(view);
		if (!(eo instanceof DeployModelObject)) {
			return;
		}
		DeployModelObject dmo = (DeployModelObject) eo;

		// get diagram and top view on diagram
		View directChild = null;
		Diagram diagram = null;
		EObject walker = view;
		while (walker != null) {
			if (walker instanceof Diagram) {
				diagram = (Diagram) walker;
				break;
			} else if (walker instanceof View) {
				directChild = (View) walker;
			}
			walker = walker.eContainer();
		}

		// make sure diagram doesn't already have this view
		for (Iterator<?> it = diagram.getPersistedChildren().iterator(); it.hasNext();) {
			eo = resolveSemanticElement((View) it.next());
			if (eo instanceof DeployModelObject) {
				if (dmo.getQualifiedName().equals(((DeployModelObject) eo).getQualifiedName())) {
					//if so, just delete
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(view);
					return;
				}
			}
		}

		if (diagram != null && directChild != null) {
			Integer blX = (Integer) getStructuralFeatureValue(directChild, NotationPackage.eINSTANCE
					.getLocation_X());
			Integer blY = (Integer) getStructuralFeatureValue(directChild, NotationPackage.eINSTANCE
					.getLocation_Y());
			Integer width = (Integer) getStructuralFeatureValue(directChild, NotationPackage.eINSTANCE
					.getSize_Width());

			Integer newX = new Integer(blX.intValue() + width.intValue() + 200);
			Integer newY = blY;
			// Relocate the newly create view at the bottom-left point
			setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), newX);
			setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), newY);

			// Insert srcView into children list of the diagram view
			diagram.insertChild(view, true);
		}
	}

}
