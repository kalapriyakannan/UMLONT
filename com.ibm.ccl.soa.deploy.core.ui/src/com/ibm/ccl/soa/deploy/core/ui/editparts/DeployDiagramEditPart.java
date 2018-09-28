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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployElementToEditPartsMap;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployContainerEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployDiagramCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployDiagramDragDropEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployXYLayoutEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DuplicateEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ShowConnectionErrorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployDiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DragFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.SemanticCacheData;
import com.ibm.ccl.soa.deploy.core.ui.util.ConsolidationLinkUtils.ConsolidatedLinkData;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutStates.LayoutState;

/**
 * 
 * @since 1.0
 * 
 */
public class DeployDiagramEditPart extends DiagramEditPart implements IPropertyChangeListener {

	// keep track of duplicate views with link cycle problems
	private final Map linkCycleDupMap = new HashMap();
	// keep track of move feedback figures
	private final Map<EditPart, IFigure> feedbackMap = new HashMap<EditPart, IFigure>();
	// keep track of Layout States for LayoutUtils
	private Map<View, Object> lastCompartmentViewMap = null;
	private final List<LayoutState> layoutStateList = new ArrayList<LayoutState>();
	// keep track of fading state of canvas
	private boolean isCanvasUnfaded = true;
	private final List selectedFigures = new ArrayList();
	// key track of shift/alt/ctrl keys
	private boolean isControlKey = false;
	private boolean isShiftKey = false;
	private boolean isAltKey = false;
	// prevent arrange from executing more then once
	private boolean toBeArranged = false;
	// maintain semantic model data for canonical edit policies
	private final SemanticCacheData semanticCacheData = new CanonicalUtils().new SemanticCacheData();

	boolean isDeactivated = false;
	protected EContentAdapter _topologyAdapter = null;
	// determines if a link tool is primed to search canvas for a target
	private boolean linkCanvasSearch;

	// cache the elements to their editparts
	private final DeployElementToEditPartsMap elementToEditPartsMap = new DeployElementToEditPartsMap();

	// keep track of consolidated links
	private final List<ConsolidatedLinkData> consolidatedLinkDataList = new ArrayList<ConsolidatedLinkData>();

	// keep track of initial canonical changes to the diagram to explain why a diagram is loaded dirty
	private List<DiagramUpdateData> _initialCanonicalChanges = new ArrayList<DiagramUpdateData>();

	// list of units to create through canonical edit policies
	private List<DeployModelObject> _creationList;
	private boolean _ignoreRestrictions = false;

	private ISharedImages sharedImages;
	private DragFeedbackFigure _primaryMoveFeedbackFigure;
	private boolean _isMousePressed;

	public void activate() {
		addTopologyListener(resolveSemanticElement());
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		super.activate();
	}

	public void deactivate() {
		isDeactivated = true;
		if (_topologyAdapter != null) {

			// avoid calling resolveSemanticElement() from deactivate();
			EObject semanticElement = getSemanticElementIfResolved();
			// can be null in the case of deletions
			if (semanticElement != null && !semanticElement.eIsProxy()) {
				semanticElement.eAdapters().remove(_topologyAdapter);
			}
		}
		_topologyAdapter = null;
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);

		if (sharedImages != null) {
			sharedImages.dispose();
			sharedImages = null;
		}

		super.deactivate();
	}

	private EObject getSemanticElementIfResolved() {
		EObject semanticElement = null;
		Object basicModel = basicGetModel();
		if (hasNotationView()) {
			semanticElement = (EObject) ((View) basicModel).eGet(
					NotationPackage.Literals.VIEW__ELEMENT, false);
		} else if (basicModel instanceof EObject) {
			semanticElement = (EObject) basicModel;
		}
		return semanticElement;
	}

	private void addTopologyListener(EObject eo) {
		final DeployDiagramEditPart ddep = this;
		// first initialization of cache
		CanonicalUtils.refreshSemanticLinkCache(ddep);
		_topologyAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				if (!isDeactivated) {
					if (notification.getNewValue() instanceof DeployModelObject
							|| notification.getOldValue() instanceof DeployModelObject) {
						CanonicalUtils.refreshSemanticLinkCache(ddep);
					}
				}
			}
		};
		if (eo != null) {
			eo.eAdapters().add(_topologyAdapter);
		} else {
			DeployCoreUIPlugin.logError(0, "model is corrupt", null); //$NON-NLS-1$
		}
	}

	/**
	 * listen for changes in preference store and update diagram accordingly
	 */
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS)) {
			CanonicalUtils.refreshLinks();
		}
		if (event.getProperty().equals(IDeployPreferences.PREF_MULTIPLE_LINKS_STYLE)) {
			CanonicalUtils.refreshLinks();
		}
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS)) {
			DuplicateEditPolicy.refreshDupIndicators(getChildren());
			getFigure().invalidate();
			getFigure().repaint();
		}
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_DISABLE_SELECTION_FADING)) {
			SelectionUtils.unfadeFigures();
		}
	}

	/**
	 * 
	 * @param diagramView
	 */
	public DeployDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	protected IFigure createFigure() {
		IFigure f = new DeployDiagramFigure();
		f.setLayoutManager(new FreeformLayout());
		f.addLayoutListener(LayoutAnimator.getDefault());
		return f;
	}

	// kill that hovering bubble toolbar (DiagramActionBarEditPolicy)
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		//Remove pop up bar on the diagram
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

		// override to provide support for arranging groups
		removeEditPolicy(EditPolicy.CONTAINER_ROLE);
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new DeployContainerEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DeployDiagramDragDropEditPolicy());

		// Allow diagram views to be refreshed against the semantic model
		// The default CANONICAL_ROLE constant prevents just the view from being deleted		
		installEditPolicy(DeployEditPolicyRoles.DIAGRAM_CANONICAL_ROLE,
				new DeployDiagramCanonicalEditPolicy());

		// use our own DeploySetBoundsCommand
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeployXYLayoutEditPolicy());

		// use our own creation policy which jumps in when a unit group is created
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DeployCreationEditPolicy());

		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ShowConnectionErrorEditPolicy());
		//		installEditPolicy(DeployEditPolicyRoles.CUSTOM_FILTER_ROLE, new CustomFilterEditPolicy());
	}

	public Object getAdapter(Class adapter) {
		if (adapter == String.class) {
			return DeployCoreConstants.DEPLOY_NAME;
		}

		return super.getAdapter(adapter);
	}

	/**
	 * @return map of units that have a duplicate view in diagram because they would disappear due to
	 *         linking cycles if they did not have a dup view in the diagram
	 */
	public Map getLinkCycleDupMap() {
		return linkCycleDupMap;
	}

	/**
	 * @return moving feedback
	 */
	public Map<EditPart, IFigure> getMoveFeedbackMap() {
		return feedbackMap;
	}

	/**
	 * @return is control key pressed
	 */
	public boolean isControlKey() {
		return isControlKey;
	}

	/**
	 * @param isControlKey
	 */
	public void setControlKey(boolean isControlKey) {
		this.isControlKey = isControlKey;
	}

	/**
	 * @return is shift key pressed
	 */
	public boolean isShiftKey() {
		return isShiftKey;
	}

	/**
	 * @param isShiftKey
	 */
	public void setShiftKey(boolean isShiftKey) {
		this.isShiftKey = isShiftKey;
	}

	/**
	 * @return is alt key pressed
	 */
	public boolean isAltKey() {
		return isAltKey;
	}

	/**
	 * @param isAltKey
	 */
	public void setAltKey(boolean isAltKey) {
		this.isAltKey = isAltKey;
	}

	/**
	 * @return list of the last compartments on the canvas (HostingList, Group, etc.)
	 */
	public Map<View, Object> getLastCompartmentViewMap() {
		return lastCompartmentViewMap;
	}

	/**
	 * @return list of currently rememberd layout states (positions of all views in canvas)
	 */
	public List<LayoutState> getLayoutStateList() {
		return layoutStateList;
	}

	/**
	 * @param lastCompartmentViewMap
	 */
	public void setLastCompartmentViewMap(Map<View, Object> lastCompartmentViewMap) {
		this.lastCompartmentViewMap = lastCompartmentViewMap;
	}

	/**
	 * @return whether canvas is unfaded
	 */
	public boolean isCanvasUnfaded() {
		return isCanvasUnfaded;
	}

	/**
	 * @param isCanvasUnfaded
	 */
	public void setCanvasUnfaded(boolean isCanvasUnfaded) {
		this.isCanvasUnfaded = isCanvasUnfaded;
	}

	/**
	 * @param selectedFigures
	 */
	public void setSelectedFigure(Set selectedFigures) {
		this.selectedFigures.clear();
		if (selectedFigures != null) {
			this.selectedFigures.addAll(selectedFigures);
		}
	}

	/**
	 * @return currentlyu selected and associated selected figures on canvas
	 */
	public List<IFigure> getSelectedFigures() {
		return selectedFigures;
	}

	/**
	 * @param b
	 */
	public void setToBeArranged(boolean b) {
		toBeArranged = b;
	}

	/**
	 * @return is to be arranged
	 */
	public boolean isToBeArranged() {
		return toBeArranged;
	}

	/**
	 * @return all cached data for semantic model
	 */
	public SemanticCacheData getSemanticCacheData() {
		return semanticCacheData;
	}

	/**
	 * @return is the link tool primed to do a search for the target of a link
	 */
	public boolean isLinkCanvasSearch() {
		return linkCanvasSearch;
	}

	/**
	 * @param b --
	 *           prime the link tool to search canvas for target
	 */
	public void setLinkCanvasSearch(boolean b) {
		linkCanvasSearch = b;
	}

	/**
	 * @param eo
	 * @param ep
	 */
	public void registerEditPartForElement(EObject eo, AbstractGraphicalEditPart ep) {
		elementToEditPartsMap.registerEditPartForElement(eo, ep);
	}

	/**
	 * @param eo
	 * @param ep
	 */
	public void unregisterEditPartForElement(EObject eo, AbstractGraphicalEditPart ep) {
		elementToEditPartsMap.unregisterEditPartForElement(eo, ep);
	}

	/**
	 * @param eo
	 * @param cls
	 * @return list of editparts with this element
	 */
	public List findEditPartsForElement(EObject eo, Class cls) {
		return elementToEditPartsMap.findEditPartsForElement(eo, cls);
	}

	/**
	 * @param topology
	 * @return list of proxy editparts for this topology
	 */
	public List findProxyEditPartsForTopology(Topology topology) {
		return elementToEditPartsMap.findProxyEditPartsForTopology(topology);
	}

	/**
	 * @return current consolidated links
	 */
	public List<ConsolidatedLinkData> getConsolidatedLinkDataList() {
		return consolidatedLinkDataList;
	}

	/**
	 * @return the list of initial canonical changes to diagram
	 */
	public List<DiagramUpdateData> getInitialCanonicalChanges() {
		return _initialCanonicalChanges;
	}

	/**
	 * @param changes --
	 *           set to null to turn off this function after diagram has been fully loaded
	 */
	public void setInitialCanonicalChanges(List<DiagramUpdateData> changes) {
		_initialCanonicalChanges = changes;
	}

	/**
	 * @param creationList
	 */
	public void setCreationList(List<DeployModelObject> creationList) {
		_creationList = creationList;
	}

	/**
	 * @param b --
	 *           create all views using canonical edit policies
	 */
	public void setIgnoreRestrictions(boolean b) {
		_ignoreRestrictions = b;
	}

	/**
	 * @return list of units to create through canonical edit policies
	 */
	public List<DeployModelObject> getCreationList() {
		return _creationList;
	}

	/**
	 * @return create all units to create through canonical edit policies
	 */
	public boolean isIgnoreRestrictions() {
		return _ignoreRestrictions;
	}

	/**
	 * @return get shared images
	 */
	public ISharedImages getSharedImages() {
		if (sharedImages == null) {
			sharedImages = ISharedImages.Factory.createSharedImages(DeployCoreUIPlugin.getDefault()
					.getSharedImages());
		}
		return sharedImages;
	}

	/**
	 * @return if moving multiple units, the unit that's under the cursor
	 */
	public DragFeedbackFigure getPrimaryMoveFeedbackFigure() {
		return _primaryMoveFeedbackFigure;
	}

	/**
	 * @param feedback
	 */
	public void setPrimaryMoveFeedbackFigure(DragFeedbackFigure feedback) {
		_primaryMoveFeedbackFigure = feedback;
	}

	/**
	 * @param b
	 */
	public void setIsMousePressed(boolean b) {
		_isMousePressed = b;
	}

	public boolean isMousePressed() {
		return _isMousePressed;
	}

}
