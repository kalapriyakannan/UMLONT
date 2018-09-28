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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DiagramNodeCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DiagramShapesCompartmentCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;

/**
 * Holds the ImportLists that a unit contains.
 */
public class DiagramShapesCompartmentEditPart extends DeployCoreCompartmentEditPart implements
		IPropertyChangeListener {
	boolean isDeactivated = false;
	protected EContentAdapter _contentAdapter = null;
	private boolean _refreshing = false;

	/**
	 * @param view
	 */
	public DiagramShapesCompartmentEditPart(View view) {
		super(view);
	}

	public void activate() {
		addListeners();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		super.activate();
	}

	public void deactivate() {
		isDeactivated = true;
		removeListeners();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}

	private void addListeners() {
		if (_contentAdapter != null) {
			return;
		}
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				if (!isDeactivated) {
					if (!_refreshing) {
						_refreshing = true;
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								try {
									// prune the tree of now missing elements
									EditPolicy policy = DiagramShapesCompartmentEditPart.this
											.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
									if (policy instanceof DiagramShapesCompartmentCanonicalEditPolicy) {
										((DiagramShapesCompartmentCanonicalEditPolicy) policy).refresh();
									}
									CanonicalUtils.refresh(
											(IGraphicalEditPart) DiagramShapesCompartmentEditPart.this
													.getParent(), false);
								} finally {
									_refreshing = false;
								}
							}
						});
					}
				}
			}
		};
		// add listener to diagram
		EObject eo = resolveSemanticElement();
		if (eo instanceof Diagram) {
			eo.eAdapters().add(_contentAdapter);
		}
		// add listener to topology
		eo = getDiagramView().getElement();
		if (eo instanceof Topology) {
			eo.eAdapters().add(_contentAdapter);
		}
	}

	private void removeListeners() {
		if (_contentAdapter != null) {
			EObject eo = resolveSemanticElement();
			if (eo instanceof Diagram) {
				eo.eAdapters().remove(_contentAdapter);
			}
			// add listener to topology
			eo = getDiagramView().getElement();
			if (eo instanceof Topology) {
				eo.eAdapters().remove(_contentAdapter);
			}
		}
		_contentAdapter = null;
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_DIAGRAM_CONTRACTS)) {
			DiagramShapesCompartmentCanonicalEditPolicy policy = (DiagramShapesCompartmentCanonicalEditPolicy) getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			if (policy != null) {
				policy.refresh();
			}
		}
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// update views with all units contained in this diagram
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new DiagramShapesCompartmentCanonicalEditPolicy());

		// allow units to be added to this unit
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DiagramNodeCreationEditPolicy());
	}

	/*
	 * if this is a create request, pass request to CollectionCreationEditPolicy which will add new
	 * unit to compartment else pass request onto parent where it might know how to handle it
	 * (DeleteRequest, etc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		EditPart parent = this.getParent();
		if (request instanceof CreateViewAndElementRequest
				|| !(parent instanceof DiagramNodeEditPart)) {
			return super.getTargetEditPart(request);
		}
		DiagramNodeEditPart diagramTopEP = (DiagramNodeEditPart) parent;
		return diagramTopEP.getTargetEditPart(request);
	}
}
