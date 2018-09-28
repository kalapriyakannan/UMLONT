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
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ImportShapesCompartmentCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ImportTopologyCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Holds the ImportLists that a unit contains.
 */
public class ImportShapesCompartmentEditPart extends DeployCoreCompartmentEditPart {
	boolean isDeactivated = false;
	protected EContentAdapter _contentAdapter = null;
	private boolean _refreshing = false;

	/**
	 * @param view
	 */
	public ImportShapesCompartmentEditPart(View view) {
		super(view);
	}

	public void activate() {
		addListeners();
		super.activate();
	}

	public void deactivate() {
		isDeactivated = true;
		removeListeners();
		super.deactivate();
	}

	private void addListeners() {
		if (_contentAdapter != null) {
			return;
		}
		final EObject eo = findInstanceConfiguration(this.resolveSemanticElement());
		final DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(this);

		// init cache for first time
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				//5269: Ignore touches.  Note proxy resolving is a touch notification.
				if (notification.isTouch()) {
					return;
				}
				super.notifyChanged(notification);
				if (!isDeactivated) {
					if (!_refreshing) {
						_refreshing = true;
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								try {
									// refresh cached import objects
									CanonicalUtils.refreshSemanticImportCache(ddep,
											(InstanceConfiguration) eo);

									// prune the tree of now missing elements
									EditPolicy policy = ImportShapesCompartmentEditPart.this
											.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
									if (policy instanceof ImportShapesCompartmentCanonicalEditPolicy) {
										((ImportShapesCompartmentCanonicalEditPolicy) policy).refresh();
									}

									//	refresh all links
									CanonicalUtils.refreshSemanticLinkCache(ddep);
									CanonicalUtils.refreshLinks(ddep);
									Display.getDefault().asyncExec(new Runnable() {
										public void run() {
											CanonicalUtils.refresh(
													(IGraphicalEditPart) ImportShapesCompartmentEditPart.this
															.getParent(), false);
										}
									});
								} finally {
									_refreshing = false;
								}
							}
						});
					}
				}
			}
		};

		// add listener to instance config
		if (eo instanceof InstanceConfiguration) {
			CanonicalUtils.refreshSemanticImportCache(ddep, (InstanceConfiguration) eo);
			eo.eAdapters().add(_contentAdapter);
		}

		// add listener to diagram (if any)
		if (getParent() instanceof ImportTopologyEditPart) {
			Diagram diagram = ((ImportTopologyEditPart) getParent()).getImportDiagram();
			if (diagram != null) {
				diagram.eAdapters().add(_contentAdapter);
			}
		}
	}

	private void removeListeners() {
		if (_contentAdapter != null) {

			// remove listener from instance config
			EObject eo = findInstanceConfiguration(this.resolveSemanticElement());
			if (eo instanceof InstanceConfiguration) {
				eo.eAdapters().remove(_contentAdapter);
			}
			// remove listener from diagram (if any)
			if (getParent() instanceof ImportTopologyEditPart) {
				Diagram diagram = ((ImportTopologyEditPart) getParent()).getImportDiagram();
				if (diagram != null) {
					diagram.eAdapters().remove(_contentAdapter);
				}
			}
		}
		_contentAdapter = null;
	}

	private EObject findInstanceConfiguration(EObject eo) {
		if (eo instanceof Import) {
			return ((Import) eo).getInstanceConfiguration();
		}
		return eo;
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// update views with all units contained in this import
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ImportShapesCompartmentCanonicalEditPolicy());

		// allow units to be added to this unit
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new ImportTopologyCreationEditPolicy());
	}

	/*
	 * if this is a create request, pass request to CollectionCreationEditPolicy which will add new
	 * unit to compartment else pass request onto parent where it might know how to handlke it
	 * (DeleteRequest, etc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		EditPart parent = this.getParent();
		if (request instanceof CreateViewAndElementRequest
				|| !(parent instanceof ImportTopologyEditPart)) {
			return super.getTargetEditPart(request);
		}
		ImportTopologyEditPart importTopEP = (ImportTopologyEditPart) parent;
		return importTopEP.getTargetEditPart(request);
	}
}
