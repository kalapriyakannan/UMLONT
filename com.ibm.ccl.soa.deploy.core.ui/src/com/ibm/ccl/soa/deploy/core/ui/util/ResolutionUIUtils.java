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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.type.UnitTypeFactory;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution.GuiPropertySetResolutionGenerator;

/**
 * Utility methods for resolutions that rely on elements in core.ui
 */
public class ResolutionUIUtils {
	/**
	 * Set an attribute
	 * 
	 * @param unit
	 *           the unit
	 * @param type
	 *           the type of the capability containing the attribute
	 * @param attribute
	 *           the attribute
	 * @param context
	 *           the resolution context
	 */
	public static void resolveUndefinedAttribute(Unit unit, EClass type, EAttribute attribute,
			IDeployResolutionContext context) {

		Capability cap = ValidatorUtils.getFirstCapability(unit, type);
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				IStatus.ERROR,
				ResolutionUtils.class.getName() + "setAttribute", //$NON-NLS-1$
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
				DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined, new Object[] {
						cap, attribute }, cap, attribute);
		IDeployResolutionContext newContext = ResolutionUtils.createResolutionContextProxy(status,
				context);
		GuiPropertySetResolutionGenerator generator = new GuiPropertySetResolutionGenerator();
		if (generator.hasResolutions(newContext)) {
			IDeployResolution[] resolutions = generator.getResolutions(newContext);
			resolutions[0].resolve(new NullProgressMonitor());
		}
	}

	/**
	 * Returns the semantic hint used to obtain the template URI for the element type.
	 * 
	 * @param type
	 *           an element type.
	 * @return the semantic hint if found, or null otherwise.
	 */
	public static String getSemanticHint(IElementType type) {
		if (type instanceof UnitTypeFactory.HintedSpecializationType) {
			return ((UnitTypeFactory.HintedSpecializationType) type).getSemanticHint();
		}
		return null;
	}

	/**
	 * Returns the template URI for the element type.
	 * 
	 * @param type
	 *           an element type.
	 * @return the template URI if found, or null otherwise.
	 */
	public static String getTemplateURI(IElementType type) {
		if (type instanceof UnitTypeFactory.HintedSpecializationType) {
			return ((UnitTypeFactory.HintedSpecializationType) type).getTemplateURI();
		}
		return null;
	}

	/**
	 * Returns the templateV URI for the element type.
	 * 
	 * @param type
	 *           an element type.
	 * @return the template URI if found, or null otherwise.
	 */
	public static String getTemplateVURI(IElementType type) {
		if (type instanceof UnitTypeFactory.HintedSpecializationType) {
			return ((UnitTypeFactory.HintedSpecializationType) type).getTemplateVURI();
		}
		return null;
	}

	/**
	 * Used to create elements in diagram from palette.
	 * 
	 * @param type
	 * @param container
	 * @return all of the created objects
	 */
	public static Collection doRealElementCreation(IElementType type, Topology container) {

		String templateURIString = getTemplateURI(type);
		boolean isDynamic = ExtensionsCore.createResourceTypeService().isDynamicPaletteEntry(
				type.getId());
		return ResolutionUtils.doRealElementCreation(templateURIString, container, isDynamic);
	}

	/**
	 * Create a default element for the UI element type from a template.
	 * 
	 * @param type
	 * @param container
	 * @return the EObject for the ui element
	 */
	public static EObject doDefaultElementCreation(IElementType type, Topology container) {

		String templateURIString = getTemplateURI(type);
		return ResolutionUtils.doDefaultElementCreation(templateURIString, container);
	}

	/**
	 * Use this method to refresh and highlight the differential of the units from the last save.
	 * 
	 * @param state --
	 *           saved topology state
	 * @param topLeftPt --
	 *           location where new new units should be positioned
	 * @param refreshCollapsedCompartmentViews --
	 *           add views to collapsed units
	 * @return a map of the resolution results for resolution dialog
	 */
	static public Map<Object, ResolutionResultsData> refreshAndHighlightTopologyDiff(
			TopologyStateData state, Point topLeftPt, boolean refreshCollapsedCompartmentViews) {

		//////////////////////////////////////////////////
		////////////// build map of resolution results
		///////////////////////////////////////////////////
		final Map<Object, ResolutionResultsData> resolutionResultsMap = new HashMap<Object, ResolutionResultsData>();

		// add new states
		for (Iterator<Unit> it = state.getNewUnits().iterator(); it.hasNext();) {
			Unit unit = it.next();
			resolutionResultsMap.put(unit,
					new ResolutionResultsData(unit, ResolutionResultsData.ADDED));
		}
		for (Iterator<DeployModelObject> it = state.getNewLinks().iterator(); it.hasNext();) {
			DeployModelObject link = it.next();
			resolutionResultsMap.put(link,
					new ResolutionResultsData(link, ResolutionResultsData.ADDED));
		}
		// modified states
		for (Iterator<DeployModelObject> it = state.getModifiedDmos().iterator(); it.hasNext();) {
			ResolutionResultsData data = resolutionResultsMap.get(it.next());
			if (data != null) {
				data.setChange(ResolutionResultsData.RETARGETED);
			}
		}

		// deleted states
		for (Iterator<DeployModelObject> it = state.getDeletedDmos().iterator(); it.hasNext();) {
			resolutionResultsMap.put(new Object(), new ResolutionResultsData(it.next(),
					ResolutionResultsData.DELETED));
		}

		//////////////////////////////////////////////////
		////////////// create new views and editparts for new dmo's added by resolution
		///////////////////////////////////////////////////
		//resume canonical refreshes on changes to topology
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) editor.getDiagramEditPart();

			// do canonical edit policies which add views to diagram
			// also arrange those new views
			// remember the old canvas children
			List<GraphicalEditPart> oldChildren = new ArrayList<GraphicalEditPart>();
			oldChildren.addAll(diagramEP.getChildren());

			// pause the canvas from painting
			final EditPartViewer viewer = diagramEP.getViewer();
			viewer.getControl().setRedraw(false);

			// do edit policies to add views for new units or source/target of new links
			CanonicalUtils.refreshViews(diagramEP, state.getNewViews(),
					refreshCollapsedCompartmentViews);
			CanonicalUtils.refreshLinks(diagramEP);

			// add editparts for new views
			diagramEP.refresh();

			// determine if there are any new editparts
			List<GraphicalEditPart> newChildren = new ArrayList<GraphicalEditPart>();
			newChildren.addAll(diagramEP.getChildren());
			for (Iterator<GraphicalEditPart> it = oldChildren.iterator(); it.hasNext();) {
				Object o = it.next();
				if (newChildren.contains(o)) {
					newChildren.remove(o);
				}
			}

			//////////////////////////////////////////////////
			////////////// expose, layout and select any new or modified dmos
			///////////////////////////////////////////////////
			// if there are any new units on the canvas, lay them out on the canvas
			if (newChildren.size() > 0) {
				// convert SWT point to canvas point
				Point p = viewer.getControl().toControl(topLeftPt);
				org.eclipse.draw2d.geometry.Point loc = new org.eclipse.draw2d.geometry.Point(p.x, p.y);
				diagramEP.getFigure().translateToRelative(loc);
				LayoutUtils.layoutNewShapes(newChildren, loc);
			}

			// expose all new units (expand their compartments if collapsed)
			final Map<View, EditPart> editpartMap = viewer.getEditPartRegistry();
			exposeNewAndModifiedUnits(resolutionResultsMap, editpartMap);

			// select all new units/links
			// need to do it async so that everything has a chance to settle first
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					selectNewUnits(resolutionResultsMap, viewer, editpartMap);
				}
			});

			// restart canvas paint
			viewer.getControl().setRedraw(true);
		}
		return resolutionResultsMap;
	}

	/**
	 * expose all new units/links to units
	 * 
	 * @param editPartViewer
	 */
	static private void exposeNewAndModifiedUnits(
			Map<Object, ResolutionResultsData> resolutionResultsMap, Map<View, EditPart> editpartMap) {
		for (Iterator it = resolutionResultsMap.entrySet().iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			ResolutionResultsData data = (ResolutionResultsData) entry.getValue();
			if (data.getChange() == ResolutionResultsData.ADDED) {
				DeployModelObject dmo = data.getDmo();
				if (dmo instanceof HostingLink) {
					HostingLink link = (HostingLink) dmo;
					dmo = link.getTarget();
					if (!(dmo instanceof Unit) || !((Unit) dmo).isConfigurationUnit()) {
						continue;
					}
				} else if (dmo instanceof MemberLink) {
					MemberLink link = (MemberLink) dmo;
					dmo = link.getTarget();
				} else if (dmo instanceof DependencyLink) {
					continue;
				}
				List epList = getEditPartsForUnit(editpartMap, dmo);
				for (Iterator<DeployShapeNodeEditPart> it2 = epList.iterator(); it2.hasNext();) {
					DeployShapeNodeEditPart ep = it2.next();
					if (!ZoomUtils.expose(ep)) {
						LayoutUtils.layoutNewTreeItem(ep);
					}
				}
			}
		}
	}

	/**
	 * expose all new units/links to units
	 */
	static private void selectNewUnits(Map<Object, ResolutionResultsData> resolutionResultsMap,
			EditPartViewer viewer, Map<View, EditPart> editpartMap) {
		viewer.deselectAll();
		for (Iterator it = resolutionResultsMap.entrySet().iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			ResolutionResultsData data = (ResolutionResultsData) entry.getValue();
			if (data.getChange() == ResolutionResultsData.ADDED) {
				DeployModelObject dmo = data.getDmo();
				List epList = Collections.EMPTY_LIST;
				if (dmo instanceof Unit || dmo instanceof ConstraintLink
						|| dmo instanceof DependencyLink || dmo instanceof RealizationLink) {
					epList = getEditPartsForUnit(editpartMap, dmo);
				} else if (dmo instanceof HostingLink) {
					HostingLink link = (HostingLink) dmo;
					DeployModelObject tgtDmo = link.getTarget();
					if (tgtDmo instanceof Unit && ((Unit) tgtDmo).isConfigurationUnit()) {
						epList = getTargetEditParts(editpartMap, link.getSource(), link.getTarget());
					} else {
						epList = getEditPartsForUnit(editpartMap, dmo);
					}
				} else if (dmo instanceof MemberLink) {
					MemberLink link = (MemberLink) dmo;
					epList = getTargetEditParts(editpartMap, link.getSource(), link.getTarget());
				}
				for (Iterator<DeployShapeNodeEditPart> it2 = epList.iterator(); it2.hasNext();) {
					viewer.appendSelection(it2.next());
				}
			}
		}
	}

	/**
	 * @param editPartReg
	 * @param dmo
	 * @return editparts belonging to this dmo
	 */
	public static List<AbstractGraphicalEditPart> getEditPartsForUnit(Map editPartReg,
			DeployModelObject dmo) {
		assert editPartReg != null;
		assert dmo != null;

		List<AbstractGraphicalEditPart> epList = new ArrayList<AbstractGraphicalEditPart>();

		Set viewSet = editPartReg.keySet();
		for (Iterator i = viewSet.iterator(); i.hasNext();) {
			Object key = i.next();
			EditPart ep = (EditPart) editPartReg.get(key);
			if (ep instanceof DeployShapeNodeEditPart || ep instanceof DeployConnectionNodeEditPart) {
				View view = (View) key;
				// Filter out view objects which container is ChangeDescritor
				View containerView = ViewUtil.getContainerView(view);
				if (containerView != null) {
					EObject semanticEle = ViewUtil.resolveSemanticElement(view);
					if (semanticEle == dmo) {
						epList.add((AbstractGraphicalEditPart) ep);
					}
				}
			}
		}

		return epList;
	}

	/**
	 * @param editPartReg
	 * @param srcDmo
	 * @param tgtDmo
	 * @return a list of target editparts that are a child of the srcDmo in the UI
	 */
	public static List<AbstractGraphicalEditPart> getTargetEditParts(Map editPartReg,
			DeployModelObject srcDmo, DeployModelObject tgtDmo) {
		List<AbstractGraphicalEditPart> epList = new ArrayList<AbstractGraphicalEditPart>();
		List<AbstractGraphicalEditPart> srcList = getEditPartsForUnit(editPartReg, srcDmo);
		List<AbstractGraphicalEditPart> tgtList = getEditPartsForUnit(editPartReg, tgtDmo);
		for (Iterator<AbstractGraphicalEditPart> it = tgtList.iterator(); it.hasNext();) {
			AbstractGraphicalEditPart tgtEP = it.next();
			for (Iterator<AbstractGraphicalEditPart> it2 = srcList.iterator(); it2.hasNext();) {
				AbstractGraphicalEditPart srcEP = it2.next();
				if (isChildOf(tgtEP, srcEP)) {
					epList.add(tgtEP);
				}
			}
		}
		return epList;
	}

	private static boolean isChildOf(EditPart child, EditPart parent) {
		if (child == parent) {
			return false;
		}
		boolean passedCompartment = false;
		EditPart walker = child;
		while (walker != null && !(walker instanceof DiagramEditPart)) {
			walker = walker.getParent();
			if (walker == parent) {
				return true;
			}
			// only break through one compartment above
			if (walker instanceof ResizableCompartmentEditPart) {
				if (passedCompartment) {
					return false;
				}
				passedCompartment = true;
			}
		}
		return false;
	}

	/**
	 * if a link did a resolution, refresh diagram to add units/links
	 * 
	 * @param descriptor
	 */
	public static void refreshForLinkResolution(final LinkDescriptor descriptor) {
		if (descriptor.getNewUnits().size() > 0 || descriptor.endpointsChanged()) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (descriptor.getNewUnits().size() > 0) {
						CanonicalUtils.refreshViews(descriptor.getNewUnits(), false);
					}
					if (descriptor.endpointsChanged()) {
						CanonicalUtils.refreshLinks();
					}
				}
			});
		}
	}

}
