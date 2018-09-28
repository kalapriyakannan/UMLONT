/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployLollipopFigure.LollyType;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * This editpolicy is responsible for adding the lollipops to a shape.
 */
public class DeployLollipopEditPolicy extends DiagramAssistantEditPolicy {

	private class PopupBarMouseListener extends MouseListener.Stub {
		/**
		 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
		 */
		public void mousePressed(MouseEvent me) {
			hideDiagramAssistant();
		}
	}

	/** mouse keys listener for the owner shape */
	private final PopupBarMouseListener myMouseKeyListener = new PopupBarMouseListener();

	/**
	 * Listens to the owner figure being moved so the handles can be removed when this occurs.
	 */
	private class OwnerMovedListener implements FigureListener {

		/**
		 * @see org.eclipse.draw2d.FigureListener#figureMoved(org.eclipse.draw2d.IFigure)
		 */
		public void figureMoved(IFigure source) {
			hideDiagramAssistant();
		}
	}

	/** listener for owner shape movement */
	private final OwnerMovedListener ownerMovedListener = new OwnerMovedListener();

	/** list of connection handles currently being displayed */
	private List handles = null;

	protected int getAppearanceDelay() {
		return 200;
	}

	protected int getDisappearanceDelayUponExit() {
		return 1000;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////   create and show the lollipops (handles) ////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////

	protected void showDiagramAssistant(Point referencePoint) {
		// if user is dragging/selecting mouse, no popup
		if (GMFUtils.getDeployDiagramEditPart(getHost()).isMousePressed()) {
			return;
		}

		// get all of the handles for this figure (the lollipops)
		handles = getHandleFigures();
		if (handles == null) {
			return;
		}

		// get the handle layer
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);

		// now one-by-one add each lollipop to the handle layer
		for (Iterator iter = handles.iterator(); iter.hasNext();) {
			DeployLollipopFigure handle = (DeployLollipopFigure) iter.next();

			// create the locator for each lollipop
			DeployLollipopLocator locator = new DeployLollipopLocator(getHost().getViewer(),
					getHostFigure());
			handle.setLocator(locator);

			handle.addMouseMotionListener(this);
			layer.add(handle);

			// Register this figure with it's host editpart so mouse events
			// will be propagated to it's host.
			getHost().getViewer().getVisualPartMap().put(handle, getHost());
		}

		if (!shouldAvoidHidingDiagramAssistant()) {
			// dismiss the handles after a delay
			hideDiagramAssistantAfterDelay(getDisappearanceDelay());
		}
	}

	/**
	 * Never avoid hiding the lollypops. Without this they can become immortal if a
	 * DiagramAssistantEditPolicy.showDiagramAssistantAfterDelay() put a timer task in queue as
	 * hideDiagramAssistant() was removing the handles.
	 */
	protected boolean shouldAvoidHidingDiagramAssistant() {
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////   remove the lollipops (handles) ////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	protected void hideDiagramAssistant() {
		if (handles == null) {
			return;
		}
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		for (Iterator iter = handles.iterator(); iter.hasNext();) {
			IFigure handle = (IFigure) iter.next();
			handle.removeMouseMotionListener(this);
			layer.remove(handle);
			getHost().getViewer().getVisualPartMap().remove(handle);
		}
		handles = null;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////   helpers  ////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////

	// creates the lollipops 
	protected List<DeployLollipopFigure> getHandleFigures() {
		List<DeployLollipopFigure> list = new ArrayList<DeployLollipopFigure>(3); // up to 3 hosting lollipop per editpart
		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());

		if (o instanceof Unit) {
			Unit unit = (Unit) o;
// MDE 01/10/2008 Do not restrict the assisted creation of dependency links to just Business Components.
			/*
			 * GraphicalEditPart parent = (GraphicalEditPart) ((GraphicalEditPart)
			 * getHost()).getParent();
			 */

			// hosting lolly -- add if not a nub
			if (dvs.canBeLinkTarget(unit, new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT })
					.isOK()) {
				list.add(new DeployLollipopFigure((IGraphicalEditPart) getHost(), LollyType.HOSTING,
						Messages.DEPLOY_HOST));
			}

			// dependency lolly -- add if a dependency nub or if not a nub and the parent doesn't have nubs
			// always show lolly if on compoenent since reuirements can be created 
			/*
			 * boolean isComponent = getHost() instanceof BusinessComponentEditPart || parent
			 * instanceof BusinessComponentEditPart;
			 */
			// allow all Units to have Dependency Link creation lollis.
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			boolean allowMatchCreation = store != null
					&& store.getBoolean(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION);
			if (allowMatchCreation
					|| dvs.canBeLinkSource(unit,
							new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT },
							DeployValidatorService.MATCHER_DEPTH_ALL).isOK()) {
				list.add(new DeployLollipopFigure((IGraphicalEditPart) getHost(), LollyType.DEPENDENCY,
						Messages.COMSUME_SERVICE));
			}

			// realization link
			if (dvs.canBeLinkSource(unit, new LinkType[] { LinkType.REALIZATION }).isOK()) {
				list.add(new DeployLollipopFigure((IGraphicalEditPart) getHost(),
						LollyType.REALIZATION, Messages.CONSUME_REALIZATION));
			}

			// constraint link
			list.add(new DeployLollipopFigure((IGraphicalEditPart) getHost(), LollyType.CONSTRAINT,
					Messages.DeployLollipopEditPolicy_Create_constraint_lin_));
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistant(java.lang.Object)
	 */
	protected boolean isDiagramAssistant(Object object) {
		return object instanceof DeployLollipopFigure || getHostFigure() == object;
	}

	public void activate() {
		super.activate();
		((IGraphicalEditPart) getHost()).getFigure().addFigureListener(ownerMovedListener);
		((IGraphicalEditPart) getHost()).getFigure().addMouseListener(myMouseKeyListener);
	}

	public void deactivate() {
		((IGraphicalEditPart) getHost()).getFigure().removeFigureListener(ownerMovedListener);
		((IGraphicalEditPart) getHost()).getFigure().removeMouseListener(myMouseKeyListener);
		super.deactivate();
	}

	private boolean isSelectionToolActive() {
		// getViewer calls getParent so check for null
		if (getHost().getParent() != null) {
			Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
			if (theTool != null && theTool instanceof SelectionTool) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#shouldShowDiagramAssistant()
	 */
	protected boolean shouldShowDiagramAssistant() {
		if (!(getHost().isActive() && isHostEditable())) {
			return false;
		}
		if (handles != null || !isSelectionToolActive()) {
			return false;
		}
		return true;
	}

	private boolean isHostEditable() {
		if (getHost() instanceof GraphicalEditPart) {
			return ((GraphicalEditPart) getHost()).isEditModeEnabled();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistantShowing()
	 */
	protected boolean isDiagramAssistantShowing() {
		return handles != null;
	}

	public void showTargetFeedback(Request request) {
		if (RequestConstants.REQ_CONNECTION_START.equals(request.getType())) {
			// hide the lollypop
			this.hideDiagramAssistant();

			// unfade other figures
			SelectionUtils.unfadeFigures();
		}
		super.showTargetFeedback(request);
	}

}
