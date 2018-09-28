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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * @author jswanke
 * 
 */
public class ContainmentStateUtils {

	/**
	 * @param view
	 * @param isContained
	 */
	public static void setContainedUnitState(View view, boolean isContained) {
		Diagram diagram = getNativeDiagram(view);
		if (diagram != null) {
			DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				Unit unit = (Unit) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.resolveSemanticElement(view);
				style.getContainedObjs().remove(unit);
				style.getUncontainedObjs().remove(unit);
				if (isContained && !unit.isConfigurationUnit()) {
					style.getContainedObjs().add(unit);
				} else if (!isContained && unit.isConfigurationUnit()) {
					style.getUncontainedObjs().add(unit);
				}
			}
		}
	}

	/**
	 * @param unit
	 * @return is this unit visually contained
	 */
	public static boolean isContainedUnit(Unit unit) {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			return isContainedUnit(editor.getDiagramEditPart(), unit);
		}
		return unit != null ? unit.isConfigurationUnit() : false;
	}

	/**
	 * @param ddep
	 * @param ep
	 * @param unit
	 * @return is this unit visually contained
	 */
	public static boolean isContainedUnit(DeployDiagramEditPart ddep, EditPart ep, Unit unit) {
		return isContainedUnit(ep == null ? ddep : ep, unit);
	}

	/**
	 * @param ep
	 * @param unit
	 * @return is this unit visually contained
	 */
	public static boolean isContainedUnit(EditPart ep, Unit unit) {
		if (ep != null) {
			View diagram = getDiagram((EObject) ep.getModel());
			if (diagram != null) {
				DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				if (style != null) {
					if (isContained(style.getContainedObjs(), unit)) {
						return true;
					}
					if (isContained(style.getUncontainedObjs(), unit)) {
						return false;
					}
				}
			}
		}
		return unit != null ? unit.isConfigurationUnit() : false;
	}

	/**
	 * @param ep
	 * @param unit
	 * @return was this unit set to be "Show on Host" by user
	 */
	static public boolean isShowOnHost(EditPart ep, Unit unit) {
		View diagram = getDiagram((EObject) ep.getModel());
		if (diagram != null) {
			DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				if (isContained(style.getContainedObjs(), unit)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param srcView
	 * @param tgtView
	 */
	public static void copyState(View srcView, View tgtView) {
		Diagram srcDiagram = getDiagram(srcView);
		Diagram tgtDiagram = getDiagram(tgtView);
		if (srcDiagram != tgtDiagram) {
			EObject tgtEO = tgtView.getElement();
			DeployStyle tgtStyle = (DeployStyle) tgtDiagram.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (tgtStyle != null && !tgtStyle.getContainedObjs().contains(tgtEO)
					&& !tgtStyle.getUncontainedObjs().contains(tgtEO)) {
				EObject srcEO = srcView.getElement();
				DeployStyle srcStyle = (DeployStyle) srcDiagram
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (srcStyle != null) {
					if (isContained(srcStyle.getContainedObjs(), (Unit) srcEO)) {
						tgtStyle.getContainedObjs().add(tgtEO);
					}
					if (isContained(srcStyle.getUncontainedObjs(), (Unit) srcEO)) {
						tgtStyle.getUncontainedObjs().add(tgtEO);
					}
				}
			}
		}
	}

	/**
	 * after a view is deleted, remove from diagram states if last one
	 * 
	 * @param viewToBeDeleted
	 */
	public static void updateStates(EObject viewToBeDeleted) {
		if (!(viewToBeDeleted instanceof View)) {
			return;
		}
		// we're only concerned with native units or units in imports-- 
		// import diagrams and diagrams have their own containment lists
		EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.resolveSemanticElement((View) viewToBeDeleted);
		if (!(eo instanceof Unit) && !isImport((View) viewToBeDeleted, eo)) {
			return;
		}

		// process this view and all contained views
		Diagram diagram = getDiagram(viewToBeDeleted);
		DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		for (View view : getContainedViews((View) viewToBeDeleted)) {
			eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.resolveSemanticElement(view);
			if (eo instanceof Unit) {

				if (!isContained(style.getContainedObjs(), (Unit) eo)
						&& !isContained(style.getUncontainedObjs(), (Unit) eo)) {
					continue;
				}

				List<View> views = getAllDuplicateViewsFor(diagram, (View) viewToBeDeleted, (Unit) eo);
				if (views.size() == 0) {
					style.getContainedObjs().remove(eo);
					style.getUncontainedObjs().remove(eo);
				}
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////// HELPERS ////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	private static boolean isContained(EList<EObject> list, Unit unit) {
		if (!PropertyUtils.isProxy(unit)) {
			return list.contains(unit);
		} else {
			for (Iterator<?> it = list.iterator(); it.hasNext();) {
				if (unit.getQualifiedName().equals(((DeployModelObject) it.next()).getQualifiedName())) {
					return true;
				}
			}
		}
		return false;
	}

	private static Diagram getNativeDiagram(EObject view) {
		EObject walker = view;
		while (walker != null) {
			if (walker instanceof Diagram) {
				return (Diagram) walker;
			}
			walker = walker.eContainer();
		}
		return null;
	}

	/**
	 * @param view
	 * @return diagram for this view (native, or the element of a DiagramNodeEditPart or the linked
	 *         diagram of an ImportTopologyEditPart
	 */
	public static Diagram getDiagram(EObject view) {
		Diagram diagram = null;
		EObject walker = view;
		while (walker != null) {
			if (walker instanceof Diagram) {
				diagram = (Diagram) walker;
				break;
			} else if (walker instanceof View) {
				View v = (View) walker;
				DiagramLinkStyle style = (DiagramLinkStyle) v.getStyle(NotationPackage.eINSTANCE
						.getDiagramLinkStyle());
				if (style != null && style.getDiagramLink() != null) {
					diagram = style.getDiagramLink();
					break;
				}
				EObject eo = v.getElement();
				if (eo instanceof Diagram) {
					diagram = (Diagram) eo;
					break;
				}
			}
			walker = walker.eContainer();
		}
		if (diagram != null && diagram.eIsProxy()) {
			diagram = (Diagram) EcoreUtil.resolve(diagram, view);
		}
		return diagram;
	}

	// look for all views, excluding import diagrams and diagrams but including imports
	private static List<View> getAllDuplicateViewsFor(View containerView, View ignoreView, Unit unit) {
		List<View> views = new ArrayList<View>();
		getAllDuplicateViewsForHelper(containerView, ignoreView, unit, views);
		return views;
	}

	private static void getAllDuplicateViewsForHelper(View containerView, View ignoreView,
			Unit unit, List<View> views) {
		for (Iterator<?> it = containerView.getPersistedChildren().iterator(); it.hasNext();) {
			View v = (View) it.next();
			if (v == ignoreView) {
				continue;
			}
			EObject eo = ViewUtil.resolveSemanticElement(v);
			if (eo instanceof Unit) {
				Unit u = (Unit) eo;
				if (u.equals(unit)) {
					views.add(v);
				}
				View compartment = ViewUtil.getChildBySemanticHint(v,
						DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (compartment == null) {
					compartment = ViewUtil.getChildBySemanticHint(v,
							DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				}
				if (compartment != null) {
					getAllDuplicateViewsForHelper(compartment, ignoreView, unit, views);
				}
			} else if (isImport(v, eo)) {
				View compartment = ViewUtil.getChildBySemanticHint(v,
						DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
				if (compartment == null) {
					compartment = ViewUtil.getChildBySemanticHint(v,
							DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
				}
				if (compartment != null) {
					getAllDuplicateViewsForHelper(compartment, ignoreView, unit, views);
				}
			} else if (v.getType() != null && v.getType().compareToIgnoreCase(ViewType.GROUP) == 0) {
				getAllDuplicateViewsForHelper(v, ignoreView, unit, views);
			}
		}
	}

	// when a view is deleted it delets all its contained views-- find them now
	private static List<View> getContainedViews(View view) {
		List<View> views = new ArrayList<View>();
		getContainedViewsHelper(view, views);
		return views;
	}

	private static void getContainedViewsHelper(View view, List<View> views) {
		views.add(view);
		View compartment = ViewUtil.getChildBySemanticHint(view,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (compartment == null) {
			compartment = ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (compartment == null) {
			compartment = ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		}
		if (compartment == null) {
			compartment = ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
		}
		if (compartment != null) {
			for (Iterator<?> it = compartment.getPersistedChildren().iterator(); it.hasNext();) {
				View v = (View) it.next();
				getContainedViewsHelper(v, views);
			}
		}

	}

	private static boolean isImport(View view, EObject eo) {
		if (eo instanceof Import) {
			DiagramLinkStyle style = (DiagramLinkStyle) view.getStyle(NotationPackage.eINSTANCE
					.getDiagramLinkStyle());
			return style == null || style.getDiagramLink() == null;
		}
		return false;
	}

}
