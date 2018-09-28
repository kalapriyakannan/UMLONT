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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConstraintLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HostingLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.IFeedbackEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.RealizationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.IFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;

/**
 * @since 1.0
 * 
 */
public class SelectionUtils {

	private static final int UNKNOWN_LINK = -1;
	private static final int DEPENDENCY_LINK = 0;
	private static final int LOGICAL_LINK = 1;
	private static final int HOSTING_LINK = 2;
	private static final int REALIZATION_LINK = 3;
	private static final int CONSOLIDATION_LINK = 4;

	// keep track of associated editparts we highlighted so that we can unhighlight 
	private static final Map<DeployDiagramEditPart, List<EditPart>> highlitedEditPartMap = new HashMap<DeployDiagramEditPart, List<EditPart>>();

	/**
	 * hold onto fading data until showFadeFeedback is called
	 */
	public class FadingData {
		protected Set<IFigure> _selectedFigures;
		protected List<EditPart> _selectedEPs;

		/**
		 * @param figures
		 * @param ps
		 */
		public FadingData(Set<IFigure> figures, List<EditPart> ps) {
			super();
			_selectedFigures = figures;
			_selectedEPs = ps;
		}

		public Set getFigures() {
			return _selectedFigures;
		}
	}

	/**
	 * @param host
	 */
	public static FadingData showSelectionFeedback(AbstractGraphicalEditPart host) {
		return setSelectionFeedback(host, true, IFeedbackFigure.STATE_LINK_SELECTED);
	}

	/**
	 * @param host
	 */
	public static void hideSelectionFeedback(AbstractGraphicalEditPart host) {
		setSelectionFeedback(host, false, IFeedbackFigure.STATE_LINK_UNSELECTED);
	}

	/**
	 * @param host
	 */
	public static void showFadeFeedback(AbstractGraphicalEditPart host, FadingData data) {
		Map f2eMap = host.getViewer().getVisualPartMap();
		refreshFaded(true, data._selectedFigures, f2eMap, data._selectedEPs,
				(RenderedDiagramRootEditPart) host.getRoot());
	}

	private static FadingData setSelectionFeedback(AbstractGraphicalEditPart host, boolean isSelect,
			String state) {

		// get starting unit editpart (if a link was selected, get its source)
		boolean isLinkSelected = false;
		AbstractGraphicalEditPart startingEP = host;
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(host);
		Map f2eMap = ddep.getViewer().getVisualPartMap();
		if (startingEP instanceof ConnectionEditPart) {
			isLinkSelected = true;
			startingEP = (AbstractGraphicalEditPart) getVisibleEditPart((ConnectionEditPart) host,
					f2eMap, true);
		}
		if (startingEP == null) {
			return null;
		}

		// cleanup old highlights
		clearHighlights(ddep);

		// get all diagram connection editparts
		List<?> allDiagramConnectionsList = ddep.getConnections();

		// now for all link editparts that have this startEP as its start add to linksEP list
		List<DeployConnectionNodeEditPart> hostingLinkEditPartList = new ArrayList<DeployConnectionNodeEditPart>();
		List<ConnectionEditPart> associatedLinkEditPartList = new ArrayList<ConnectionEditPart>();
		for (Iterator<?> it = allDiagramConnectionsList.iterator(); it.hasNext();) {
			ConnectionEditPart linkEP = (ConnectionEditPart) it.next();
			if (linkEP.getFigure().isVisible()) {
				if (startingEP == getVisibleEditPart(linkEP, f2eMap, true)) {
					associatedLinkEditPartList.add(linkEP);
					if (isHostingLink(linkEP)) {
						hostingLinkEditPartList.add((DeployConnectionNodeEditPart) linkEP);
					}
				}
				if (startingEP == getVisibleEditPart(linkEP, f2eMap, false)) {
					associatedLinkEditPartList.add(linkEP);
				}
			}
		}

		// if there are hosting links emitting from this unit, follow them down to bottom host
		if (hostingLinkEditPartList.size() > 0) {
			List<ConnectionEditPart> extendedHostingLinkEditPartList = new ArrayList<ConnectionEditPart>();
			collectHostingStackLinks(hostingLinkEditPartList, extendedHostingLinkEditPartList, f2eMap);
			associatedLinkEditPartList.addAll(extendedHostingLinkEditPartList);
		}

		// highlight associated link editparts
		List selectedEPs = GEFUtils.getSelectedEditParts();
		for (Iterator it = associatedLinkEditPartList.iterator(); it.hasNext();) {
			ConnectionEditPart link = (ConnectionEditPart) it.next();
			//determine color
			Color clr;
			if (isSelect) {
				if (selectedEPs.contains(link)) {
					clr = DeployColorConstants.selectedOuter;
				} else {
					clr = DeployColorConstants.associatedOuter;
				}
			} else {
				clr = SelectionUtils.getLinkColor(link);
			}

			showLinkFeedback(ddep, link, clr, isSelect);
		}

		// highlight duplicate view editparts
		boolean isSelecting = IFeedbackFigure.STATE_LINK_SELECTED.equals(state);
		Set<IFigure> figureSet = new HashSet<IFigure>();
		figureSet.add(startingEP.getFigure());
		List dupEPs = new ArrayList();
		if (!isLinkSelected && startingEP instanceof GraphicalEditPart) {
			List<DeployShapeNodeEditPart> dupEPList = GMFUtils.getEditPartsFor(startingEP,
					((GraphicalEditPart) startingEP).resolveSemanticElement());
			if (dupEPList.size() > 1) {
				for (Iterator<DeployShapeNodeEditPart> it = dupEPList.iterator(); it.hasNext();) {
					DeployShapeNodeEditPart ep = it.next();
					// if this is the ep being selected, don't echo select
					if (ep == startingEP) {
						continue;
					}
					// if this ep isn't visible, don't echo select
					if (isSelecting && !ZoomUtils.isExposed(ep)) {
						continue;
					}
					dupEPs.add(ep);
					setFeedbackState(ddep, ep, host, isSelecting ? IFeedbackFigure.STATE_DUP_SELECTED
							: IFeedbackFigure.STATE_DUP_UNSELECTED, figureSet);
				}
			}
		}

		// highlight associated shape editparts
		for (Iterator it = associatedLinkEditPartList.iterator(); it.hasNext();) {
			ConnectionEditPart linkEP = (ConnectionEditPart) it.next();
			EditPart srcEP = getVisibleEditPart(linkEP, f2eMap, true);
			EditPart tgtEP = getVisibleEditPart(linkEP, f2eMap, false);
			String srcState = !isSelecting || !selectedEPs.contains(srcEP) ? state
					: IFeedbackFigure.STATE_LINK_UNSELECTED;
			String tgtState = !isSelecting || !selectedEPs.contains(tgtEP) ? state
					: IFeedbackFigure.STATE_LINK_UNSELECTED;
			if (!dupEPs.contains(srcEP)) {
				setFeedbackState(ddep, srcEP, host, srcState, figureSet);
			}
			if (!dupEPs.contains(tgtEP)) {
				setFeedbackState(ddep, tgtEP, host, tgtState, figureSet);
			}
		}
		// also modify host state
		if (host instanceof IFeedbackEditPart && selectedEPs.contains(host)) {
			((IFeedbackEditPart) host).setFeedbackState(IFeedbackFigure.STATE_LINK_UNSELECTED);
		}

		// remember for selection fading
		if (isSelecting) {
			if (associatedLinkEditPartList.size() > 0) {
				// if the user didn't do a move last time, do the fade immediately (they're in selection mode)
				FadingData data = new SelectionUtils().new FadingData(figureSet, selectedEPs);
				if (DeployShapeNodeEditPart.isLastClickWasMove()) {
					// otherwise they're in move mode so just unfade selected figures if canvas has fading
					//  -- drag routine will call for fading
					if (!GMFUtils.getDeployDiagramEditPart(host).isCanvasUnfaded()) {
						// update fading immediately-- otherwise there's a pause
						refreshFaded(true, data._selectedFigures, host.getViewer().getVisualPartMap(),
								data._selectedEPs, (RenderedDiagramRootEditPart) host.getRoot());
					}
				} else {
					// else we do it now
					showFadeFeedback(host, data);
				}
				return data;
			} else {
				unfadeFigures();
			}
		}
		return null;
	}

	// a link's anchor may have been moved to an outer collapsed figure-- so get that figure's editpart instead
	private static EditPart getVisibleEditPart(ConnectionEditPart linkEP, Map f2eMap,
			boolean isSource) {
		EditPart ep = isSource ? linkEP.getSource() : linkEP.getTarget();
		Object o = linkEP.getFigure();
		if (o instanceof PolylineConnectionEx) {
			PolylineConnectionEx line = (PolylineConnectionEx) o;
			ConnectionAnchor anchor = isSource ? line.getSourceAnchor() : line.getTargetAnchor();
			if (anchor != null && anchor.getOwner() != null) {
				EditPart e = (EditPart) f2eMap.get(anchor.getOwner());
				if (e != null) {
					return e;
				}
			}
		}
		return ep;
	}

	private static void collectHostingStackLinks(List<?> linkList,
			List<ConnectionEditPart> extendedHostingLinkEditPartList, Map f2eMap) {
		for (Iterator<?> it = linkList.iterator(); it.hasNext();) {
			Object o = it.next();
			if (isHostingLink(o) && !extendedHostingLinkEditPartList.contains(o)) {
				DeployConnectionNodeEditPart link = (DeployConnectionNodeEditPart) o;
				extendedHostingLinkEditPartList.add(link);
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) link.getTarget();
				EditPart walker = ep;
				while (walker != null) {
					if (walker instanceof DeployShapeNodeEditPart) {
						collectHostingStackLinks(((DeployShapeNodeEditPart) walker)
								.getSourceConnections(), extendedHostingLinkEditPartList, f2eMap);
					}
					walker = walker.getParent();
				}
			}
		}
	}

	private static boolean isHostingLink(Object linkEP) {
		if (linkEP instanceof HostingLinkEditPart) {
			return true;
		} else if (linkEP instanceof ConstraintLinkEditPart) {
			ConstraintLink link = (ConstraintLink) ((ConstraintLinkEditPart) linkEP)
					.resolveSemanticElement();
			if (link != null) {
				return link.getConstraints().size() == 1
						&& link.getConstraints().get(0) instanceof DeferredHostingConstraint;
			}
		}
		return false;
	}

	private static void setFeedbackState(DeployDiagramEditPart ddep, EditPart ep,
			AbstractGraphicalEditPart host, String state, Set<IFigure> figureSet) {
		if (ep != null && ep != host) {
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart gep = (DeployShapeNodeEditPart) ep;
				if (IFeedbackFigure.STATE_LINK_SELECTED.equals(state)) {
					if (gep.isSelectable()) {
						gep.setFeedbackState(state);
						figureSet.add(gep.getFigure());
					}
				} else {
					gep.setFeedbackState(state);
					figureSet.add(gep.getFigure());
				}
				if (!state.equals(IFeedbackFigure.STATE_LINK_UNSELECTED)) {
					highlitedEditPartMap.get(ddep).add(ep);
				}
			}
		}
	}

	private static void showLinkFeedback(DeployDiagramEditPart ddep, ConnectionEditPart linkEP,
			Color color, boolean isSelected) {
		IFigure hostFigure = linkEP.getFigure();
		hostFigure.setForegroundColor(color);
		if (hostFigure instanceof DeployLinkConnection) {
			DeployLinkConnection link = (DeployLinkConnection) hostFigure;
			link.setBringToFront(isSelected);
		}
		if (isSelected) {
			highlitedEditPartMap.get(ddep).add(linkEP);
		}
	}

	private static void clearHighlights(DeployDiagramEditPart ddep) {
		List<EditPart> highlitedEditPartList = highlitedEditPartMap.get(ddep);
		if (highlitedEditPartList == null) {
			highlitedEditPartList = new ArrayList<EditPart>();
			highlitedEditPartMap.put(ddep, highlitedEditPartList);
		} else {
			for (EditPart ep : highlitedEditPartList) {
				if (ep instanceof ConnectionEditPart) {
					IFigure hostFigure = ((ConnectionEditPart) ep).getFigure();
					hostFigure.setForegroundColor(SelectionUtils.getLinkColor(ep));
				} else if (ep instanceof DeployShapeNodeEditPart) {
					((DeployShapeNodeEditPart) ep)
							.setFeedbackState(IFeedbackFigure.STATE_LINK_UNSELECTED);
				}
			}
			highlitedEditPartList.clear();
		}
	}

	private static Color getLinkColor(EditPart host) {
		if (host instanceof HostingLinkEditPart) {
			return DeployColorConstants.hostingLinkColor;
		} else if (host instanceof ConstraintLinkEditPart) {
			// no such thing as hosting logical link yet
			return DeployColorConstants.dependencyLinkColor;
		} else if (host instanceof RealizationLinkEditPart) {
			return DeployColorConstants.realizationLinkColor;
		} else if (host instanceof ConsolidationLinkEditPart) {
			return DeployColorConstants.consolidationLinkColor;
		}
		return DeployColorConstants.dependencyLinkColor;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// refresh faded flag in figures and links /////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param isSomethingSelected
	 * @param selectedFigures
	 * @param f2eMap
	 * @param selectedEPs
	 * @param rootEP
	 * 
	 */
	private static void refreshFaded(boolean isSomethingSelected, Set selectedFigures, Map f2eMap,
			List selectedEPs, RenderedDiagramRootEditPart rootEP) {

		// if user has turned this feature off in preferences, just return
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		if (store.getBoolean(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING)) {
			// unfade figures before we turn off
			if (!store.getBoolean(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING_TRANSISTION)) {
				unfadeFigures();
			}
			return;
		}
		store.setValue(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING_TRANSISTION, false);

		// reset unfade flag
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor == null) {
			return;
		}

		// if we are already unfaded, ignore
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(rootEP);
		ddep.setCanvasUnfaded(false);
		ddep.setSelectedFigure(selectedFigures);

		//////////////////////////////////////////////
		//////// REFRESH FIGURES FLAGS ///////////////////////
		/////////////////////////////////////////////
		IFigure figureLayer = rootEP.getLayer(LayerConstants.PRIMARY_LAYER);

		// determine which figures to fade
		Set<IFigure> unfadedFigures = new HashSet<IFigure>();
		for (Iterator<IFigure> it = selectedFigures.iterator(); it.hasNext();) {
			unfadedFigures.add(GEFUtils.getTopFigure(it.next()));
		}
		refreshFadedShapes(figureLayer.getChildren(), unfadedFigures, f2eMap, selectedEPs,
				isSomethingSelected, true);

		//////////////////////////////////////////////
		//////// REFRESH LINKS FLAGS ///////////////////////
		/////////////////////////////////////////////
		// look through all figures for links--
		// then set faded flag if not selected and something else on canvas is selected

		IFigure connectionLayer = rootEP.getLayer(LayerConstants.CONNECTION_LAYER);
		for (Iterator it = connectionLayer.getChildren().iterator(); it.hasNext();) {
			IFigure child = (IFigure) it.next();
			if (child instanceof DeployLinkConnection) {
				DeployLinkConnection link = (DeployLinkConnection) child;
				// if something is selected but not this link, then fade it 
				boolean isFaded = !link.isBringToFront() && isSomethingSelected
						&& !isSelectedInViewer(link, f2eMap, selectedEPs);
				link.setFaded(isFaded);
			}
		}

		// refresh canvas
		IFigure rootFig = rootEP.getFigure();
		rootFig.invalidate();
		rootFig.repaint();
	}

	// set faded flag on all CompositeShapeFigure based on whether it's selected
	// if not selected and at least one other editpart is selected, then this figure will be faded
	// -- also if my parent isn't faded then don't fade me
	private static void refreshFadedShapes(List children, Set selectedFigures, Map f2eMap,
			List selectedEPs, boolean isSomethingSelected, boolean isParentFaded) {
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			if (child instanceof CompositeShapeFigure) {
				CompositeShapeFigure fig = (CompositeShapeFigure) child;
				boolean isSelectedShape = selectedFigures.contains(fig);
				boolean isFaded = !isSelectedShape && isSomethingSelected && isParentFaded
						&& !isSelectedInViewer(fig, f2eMap, selectedEPs);
				fig.setFaded(isFaded);
				refreshFadedShapes(child.getChildren(), selectedFigures, f2eMap, selectedEPs,
						isSomethingSelected, isFaded);
			} else {
				// non-CompositeShapeFigure that draw figures
				if (child instanceof DeployCoreFigure) {
					((DeployCoreFigure) child).setFaded(isParentFaded);
				} else if (child instanceof DeployListItemFigure) {
					((DeployListItemFigure) child).setFaded(isParentFaded);
				} else if (child instanceof DeployWrapLabel) {
					((DeployWrapLabel) child).setFaded(isParentFaded);
				}
				refreshFadedShapes(child.getChildren(), selectedFigures, f2eMap, selectedEPs,
						isSomethingSelected, isParentFaded);
			}
		}
	}

	/**
	 * show everything in editor
	 * 
	 * @param rootEP
	 */
	public static void unfadeFigures() {

		// if user has turned this feature off in preferences, drop thru only one more time
		boolean isDisabled = false;
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		if (store.getBoolean(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING)) {
			isDisabled = store
					.getBoolean(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING_TRANSISTION);
			if (isDisabled) {
				return;
			}
			isDisabled = true;
		}
		store.setValue(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING_TRANSISTION, isDisabled);

		// get root editpart
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor == null) {
			return;
		}

		// if we are already unfaded, ignore
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) editor.getDiagramEditPart();
		if (ddep.isCanvasUnfaded()) {
			return;
		}
		ddep.setCanvasUnfaded(true);
		ddep.setSelectedFigure(null);
		clearHighlights(ddep);

		// set faded flag false in all shapes
		RenderedDiagramRootEditPart rootEP = (RenderedDiagramRootEditPart) editor
				.getDiagramEditPart().getRoot();
		IFigure figureLayer = rootEP.getLayer(LayerConstants.PRIMARY_LAYER);
		refreshFadedShapes(figureLayer.getChildren(), Collections.EMPTY_SET, null, null, false, false);

		// set faded flag false in all links
		IFigure connectionLayer = rootEP.getLayer(LayerConstants.CONNECTION_LAYER);
		for (Iterator it = connectionLayer.getChildren().iterator(); it.hasNext();) {
			IFigure child = (IFigure) it.next();
			if (child instanceof DeployLinkConnection) {
				((DeployLinkConnection) child).setFaded(false);
			}
		}

		// refresh canvas
		IFigure rootFig = rootEP.getFigure();
		rootFig.invalidateTree();
		rootFig.repaint();
	}

	private static boolean isSelectedInViewer(IFigure figure, Map f2eMap, List selectedEPs) {
		if (f2eMap == null || selectedEPs == null || figure == null) {
			return false;
		}
		EditPart ep = (EditPart) f2eMap.get(figure);
		boolean isLinkSelected = false;
		if (ep instanceof IFeedbackEditPart) {
			String state = ((IFeedbackEditPart) ep).getFeedbackState();
			isLinkSelected = state != null
					&& (state.equals(IFeedbackFigure.STATE_DUP_SELECTED) || state
							.equals(IFeedbackFigure.STATE_LINK_SELECTED));
		}
		return ep != null && selectedEPs.contains(ep) || isLinkSelected;
	}

	/**
	 * reseelct editparts to refresh any hilights
	 * 
	 * @param editPartViewer
	 */
	public static void reselect(EditPartViewer editPartViewer) {
		List epList = editPartViewer.getSelectedEditParts();
		editPartViewer.setSelection(new StructuredSelection(epList));
	}

	/**
	 * seelct the name in an editpart
	 * 
	 * @param editpart
	 */
	public static void selectName(final List<GraphicalEditPart> list) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				GraphicalEditPart topEP = list.get(0);
				if (topEP != null && topEP.getRoot() != null) {
					EditPartViewer viewer = topEP.getViewer();
					viewer.setSelection(new StructuredSelection(list));
					IGraphicalEditPart nameEP = topEP
							.getChildBySemanticHint(DeployCoreConstants.DEPLOY_NAME);
					if (nameEP != null) {
						viewer.reveal(nameEP);
						viewer.appendSelection(nameEP);
					}
				}
			}
		});
	}

}
