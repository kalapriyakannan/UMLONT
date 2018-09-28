/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateMemberOrHostingLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @since 1.0
 * 
 */
public class VisualizeFromNotationalCommand extends AbstractTransactionalCommand {
	private final IGraphicalEditPart _targetEP;
	private final boolean _createTargetLinks;
	private final boolean _collapseVisualization;
	private final List<DeployModelObject> _dmoList = new ArrayList<DeployModelObject>();
	private final List<DeployModelObject> _visibleList;
	private final Diagram _sourceDiagram;
	private Map<DeployModelObject, View> _viewMap;
	private Point _location;
	private Map<DeployModelObject, CreateViewRequest.ViewDescriptor> _descriptorMap = null;
	private final View _movedView;
	private final Point _originalPt;

	/**
	 * used when visualizing an import diagram or diagram to current diagram
	 * 
	 * @param editingDomain
	 * @param targetEP
	 * @param dmoList
	 * @param visibleList
	 * @param sourceDiagram
	 * @param location
	 * @param createTargetLinks --
	 *           create hosting/membership links from visualized units to the host/group it's being
	 *           visualized in
	 * @param collapseVisualization --
	 *           whatever is visualized, collapse it
	 */
	public VisualizeFromNotationalCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<DeployModelObject> dmoList,
			List<DeployModelObject> visibleList, Diagram sourceDiagram, Point location,
			boolean createTargetLinks, boolean collapseVisualization) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		_dmoList.addAll(dmoList);
		_visibleList = visibleList;
		_sourceDiagram = sourceDiagram;
		_viewMap = null;
		_location = location;
		_createTargetLinks = createTargetLinks;
		_collapseVisualization = collapseVisualization;
		_movedView = null;
		_originalPt = null;

		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * used when visualizing an import diagram or diagram to current diagram
	 * 
	 * @param editingDomain
	 * @param targetEP
	 * @param dmoList
	 * @param visibleList
	 * @param sourceDiagram
	 * @param location
	 * @param createTargetLinks --
	 *           create hosting/membership links from visualized units to the host/group it's being
	 *           visualized in
	 * @param collapseVisualization --
	 *           whatever is visualized, collapse it
	 * @param originalPt
	 * @param movedView
	 */
	public VisualizeFromNotationalCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<DeployModelObject> dmoList,
			List<DeployModelObject> visibleList, Diagram sourceDiagram, Point location,
			boolean createTargetLinks, boolean collapseVisualization, View movedView, Point originalPt) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		_dmoList.addAll(dmoList);
		_visibleList = visibleList;
		_sourceDiagram = sourceDiagram;
		_viewMap = null;
		_location = location;
		_createTargetLinks = createTargetLinks;
		_collapseVisualization = collapseVisualization;
		_movedView = movedView;
		_originalPt = originalPt;

		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * used by canonical edit policy to fill the views of an import diagram or diagram
	 * 
	 * @param editingDomain
	 * @param targetEP
	 * @param descriptorList
	 * @param visibleList
	 * @param sourceDiagram
	 */
	public VisualizeFromNotationalCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<CreateViewRequest.ViewDescriptor> descriptorList,
			List<DeployModelObject> visibleList, Diagram sourceDiagram) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		// get objects from view descriptors
		_descriptorMap = new HashMap<DeployModelObject, CreateViewRequest.ViewDescriptor>();
		for (CreateViewRequest.ViewDescriptor descriptor : descriptorList) {
			EObject eo = (EObject) descriptor.getElementAdapter().getAdapter(EObject.class);
			if (eo instanceof DeployModelObject) {
				_dmoList.add((DeployModelObject) eo);
				_descriptorMap.put((DeployModelObject) eo, descriptor);
			}
		}
		_visibleList = visibleList;
		_sourceDiagram = sourceDiagram;
		_viewMap = null;
		_location = new Point(0, 0);
		_createTargetLinks = false;
		_collapseVisualization = false;
		_movedView = null;
		_originalPt = null;

		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * used when adding units from one diagram to a newly created diagram
	 * 
	 * @param editingDomain
	 * @param targetEP
	 * @param viewMap
	 * @param location
	 */
	public VisualizeFromNotationalCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, Map<DeployModelObject, View> viewMap, Point location) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		_visibleList = null;
		_sourceDiagram = null;
		_viewMap = viewMap;
		_location = location;
		_createTargetLinks = false;
		_collapseVisualization = false;
		_movedView = null;
		_originalPt = null;

		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		// no units to visualize
		if (_dmoList.size() == 0 && _viewMap == null) {
			return CommandResult.newOKCommandResult();
		}

		// if there's no dmo to view map, create one now using the source diagram
		if (_viewMap == null && _sourceDiagram != null) {
			_viewMap = new HashMap<DeployModelObject, View>();
			fillViewMap(_viewMap, DiagramUtils.getAllChildViewsIncludingGroup(_sourceDiagram),
					_dmoList, false);
		}

		// also save position of all views in source diagram so we can move them to the top-left of the new diagram
		Point upperLeftPt = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Map<View, Point> moveMap = new HashMap<View, Point>();
		List<View> rootViews = new ArrayList<View>();
		for (DeployModelObject dmo : _viewMap.keySet()) {
			View view = _viewMap.get(dmo);
			Point pt = getDiagramLocation(view);
			upperLeftPt.x = pt.x < upperLeftPt.x ? pt.x : upperLeftPt.x;
			upperLeftPt.y = pt.y < upperLeftPt.y ? pt.y : upperLeftPt.y;
			moveMap.put(view, pt);
			rootViews.add(view);
		}

		// if there views to copy, just return
		if (_viewMap.size() == 0) {
			return CommandResult.newOKCommandResult();
		}

		// if we are dropping in a compartment, translate the location to that compartment
		if (_createTargetLinks && _targetEP != null && !(_targetEP instanceof DeployDiagramEditPart)) {
			Point loc = (Point) MapModeUtil.getMapMode().LPtoDP(_location);
			loc = CreateMemberOrHostingLinkCommand.getLocation(_targetEP, loc);
			_location = (Point) MapModeUtil.getMapMode().DPtoLP(loc);
		}

		// determine location of new views in new diagram
		if (_location == null) {
			_location = new Point(500, 500);
		}
		Dimension offset = _location.getDifference(upperLeftPt);
		for (Iterator<Point> it = moveMap.values().iterator(); it.hasNext();) {
			it.next().translate(offset);
		}

		// now copy old views into new diagram
		List<View> newViews = new ArrayList<View>();
		Map<View, View> o2nViewMap = new HashMap<View, View>();
		IGraphicalEditPart targetEP = _targetEP;
		if (targetEP instanceof HybridShapesCompartmentEditPart
				|| targetEP instanceof HybridListCompartmentEditPart) {
			targetEP = (IGraphicalEditPart) targetEP.getParent();
		}
		for (Entry<DeployModelObject, View> oldEntry : _viewMap.entrySet()) {
			DeployModelObject oldEO = oldEntry.getKey();
			View oldView = oldEntry.getValue();
			boolean isTargetShapesMode = DeployShapeNodeEditPart.isShapesMode(targetEP)
					|| targetEP instanceof DeployDiagramEditPart;
			// copies view and all it's children
			View newView = ViewUtil.copyView(GMFUtils.getDeployDiagramEditPart(targetEP),
					(AbstractGraphicalEditPart) targetEP, oldView, moveMap.get(oldView), false, true,
					isTargetShapesMode, _collapseVisualization, _visibleList);
			if (newView != null) {
				newViews.add(newView);
				o2nViewMap.put(oldView, newView);
				// if we were invoked by a descriptor list, stuff the new view back into the descriptor
				if (_descriptorMap != null) {
					_descriptorMap.get(oldEO).setView(newView);
				}
				// if this is a proxy, make it a dup view so canonical edit policy doesn't kill it				
				if (targetEP instanceof DeployDiagramEditPart
						&& PropertyUtils.isProxy((DeployModelObject) newView.getElement())) {
					DeployStyle style = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
							.getDeployStyle());
					style.setIsDuplicateCanvasView(true);
				}
			}
		}

		// if any views were snapped together in source diagram, resnap them here
		resnapNewViews(_viewMap, o2nViewMap, targetEP);

		// if we are dropping in a compartment, add links to our root views
		if (_createTargetLinks && _targetEP != null && !(_targetEP instanceof DeployDiagramEditPart)) {
			CreateMemberOrHostingLinkCommand.createLinks(getEditingDomain(), _targetEP, newViews);
		}

		if (_movedView != null) {
			// position original view where it was before we started (undo SetBoundsCommand)
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_movedView,
					NotationPackage.eINSTANCE.getLocation_X(), new Integer(_originalPt.x));
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_movedView,
					NotationPackage.eINSTANCE.getLocation_Y(), new Integer(_originalPt.y));
		}

		return CommandResult.newOKCommandResult();
	}

	// reentrantly look through source diagram for view that matches something in the dmolist
	private void fillViewMap(Map<DeployModelObject, View> viewMap, List<View> children,
			List<DeployModelObject> dmoList, boolean isContained) {

		// for every view in this container-- until dmolist is empty
		for (Iterator<?> it = children.iterator(); it.hasNext() && !dmoList.isEmpty();) {
			EObject vo = (EObject) it.next();
			if (vo instanceof View) {
				View view = (View) vo;
				// if this is an element view, see if it matches a dmo in dmo list
				String type = view.getType();
				if (type == null || type == "") { //$NON-NLS-1$
					EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
							.resolveSemanticElement(view);
					// if import edit part, continue down
					if (eo instanceof Import) {
						View container = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
								.getChildBySemanticHint(view,
										DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
						if (container == null) {
							container = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
									.getChildBySemanticHint(view,
											DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
						}
						if (container != null) {
							fillViewMap(viewMap, container.getPersistedChildren(), dmoList, false);
						}
					} else {

						// see if this view matches a view in the dmo list
						boolean foundView = false;
						if (_visibleList == null) {
							foundView = dmoList.contains(eo);
						} else {
							for (DeployModelObject o : dmoList) {
								if (o.getQualifiedName()
										.equals(((DeployModelObject) eo).getQualifiedName())) {
									eo = o;
									foundView = true;
									break;
								}
							}
						}
						// if a match is found, stuff in viewMap and remove from dmoList
						if (foundView) {
							dmoList.remove(eo);
							// if this view is already contained by another view that's getting copied, 
							// we don't need to copy it again 
							if (!isContained) {
								viewMap.put((DeployModelObject) eo, view);
							}
							if (!dmoList.isEmpty()) {
								fillViewMap(viewMap, view.getChildren(), dmoList, true);
							}
						} else {
							// else keep going down
							fillViewMap(viewMap, view.getChildren(), dmoList, isContained);
						}
					}
					// else if a compartment, keep reentrantly searching
				} else if (type.equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)
						|| type.equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT)) {
					fillViewMap(viewMap, view.getChildren(), dmoList, isContained);
				}
			}
		}
	}

	private Point getDiagramLocation(View view) {
		Point pt = null;
		View walker = view;
		while (walker != null && !(walker instanceof Diagram)) {
			int x = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(walker, NotationPackage.eINSTANCE.getLocation_X()))
					.intValue();
			int y = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(walker, NotationPackage.eINSTANCE.getLocation_Y()))
					.intValue();
			if (pt == null) {
				pt = new Point(x, y);
			} else {
				pt.translate(x, y);
			}
			walker = (View) walker.eContainer();
		}
		return pt;
	}

	private void resnapNewViews(Map<DeployModelObject, View> viewMap, Map<View, View> o2nViewMap,
			IGraphicalEditPart targetEP) {
		List<View> processedViews = new ArrayList<View>();
		final List<View> alignGroupList = new ArrayList<View>();
		for (View oldView : _viewMap.values()) {
			if (processedViews.contains(oldView)) {
				continue;
			}
			DeployStyle oldStyle = (DeployStyle) oldView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (oldStyle.getSnapParent() != null && oldStyle.getSnapParent().eContainer() != null) {

				// get old group
				View oldSnapGroup = (View) oldStyle.getSnapParent().eContainer();

				// create a new snapGroup
				View newSnapGroup = ViewService.getInstance().createView(Node.class, null,
						targetEP.getNotationView(), DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1, true,
						targetEP.getDiagramPreferencesHint());
				alignGroupList.add(newSnapGroup);

				// for each old snap group row, create a new snap group row
				for (Iterator<?> itRow = oldSnapGroup.getChildren().iterator(); itRow.hasNext();) {
					View oldSnapRow = (View) itRow.next();
					DeployStyle oldRowStyle = (DeployStyle) oldSnapRow
							.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());

					// create a new snapRow
					View newSnapRow = ViewService.getInstance().createView(Node.class, null,
							newSnapGroup, DeployCoreConstants.SNAPROW_SEMANTICHINT, -1, true,
							targetEP.getDiagramPreferencesHint());
					DeployStyle newRowStyle = (DeployStyle) newSnapRow
							.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());

					// for every child in old row, populate new row with new view
					for (Iterator<?> it = oldRowStyle.getSnapChildren().iterator(); it.hasNext();) {
						View oldRowView = (View) it.next();
						processedViews.add(oldRowView);
						View newRowView = o2nViewMap.get(oldRowView);
						if (newRowView != null) {
							newRowStyle.getSnapChildren().add(newRowView);

							// set new view's snap parent
							DeployStyle newStyle = (DeployStyle) newRowView
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							newStyle.setSnapParent(newSnapRow);
						}
					}
				}
			}
		}
		if (alignGroupList.size() > 0) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					for (View snapGroup : alignGroupList) {
						ArrangeSnappedViewsCommand.arrangeSnappedViews(_targetEP.getEditingDomain(),
								snapGroup, _targetEP.getViewer(), SnapUtils.ANCHOR_GROUP, null);
					}
				}
			});
		}
	}

	public boolean canExecute() {
		return true;
	}

}
