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
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DiagramNodeCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DiagramNodeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @author jswanke
 * 
 */
public class DiagramNodeEditPart extends DeployShapeNodeEditPart {

	private String _diagramName = Messages.DiagramNodeEditPart_Unresolve_;
	List<DeployModelObject> _diagramUnits = null;

	/**
	 * @param view
	 */
	public DiagramNodeEditPart(View view) {
		super(view);
		setCategory("Diagram"); //$NON-NLS-1$

		EObject eo = view.getElement();
		if (eo instanceof Diagram) {
			_diagramName = eo.eResource().getURI().lastSegment();
			_diagramName = _diagramName.substring(0, _diagramName.lastIndexOf(".")); //$NON-NLS-1$
		}
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new DiagramNodeFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

	/**
	 * refresh category can conceptual
	 */
	public void refreshValues() {
		NodeFigure figure = (NodeFigure) getMainFigure();
		if (figure instanceof DiagramNodeFigure) {
			DiagramNodeFigure fig = (DiagramNodeFigure) figure;
			fig.setCategory(category);
		}
		// since import model notifications are sent here we have to pass them down the line
		// not apparently used--removed for performance
		//refreshValuesHelper(getChildren());
	}

	private void refreshValuesHelper(List children) {
		for (Iterator<EditPart> it = children.iterator(); it.hasNext();) {
			EditPart child = it.next();
			if (child instanceof DeployShapeNodeEditPart) {
				((DeployShapeNodeEditPart) child).refreshValues();
			} else if (child instanceof NameCompartmentEditPart) {
				((NameCompartmentEditPart) child).refreshLabel();
			}
			refreshValuesHelper(child.getChildren());
		}
	}

	// allow children
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// inappropriate for import topologies
		removeEditPolicy(DeployEditPolicyRoles.DUPLICATE_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

		/**
		 * install CreationEditPolicy to intercept the creation request from the context popup bar and
		 * return composite creation command
		 */
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DiagramNodeCreationEditPolicy());
	}

	/**
	 * @return list of compartment editparts which can be expanded
	 */

	public List getExpandableCompartmentEditParts() {
		List list = new ArrayList();
		IGraphicalEditPart ep = getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		ep = getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		return list;
	}

	/**
	 * @return name of Diagram
	 */
	public String getDiagramName() {
		return _diagramName;
	}

	/**
	 * @return the units that are the direct children of this diagram-- determines which views are
	 *         added to the diagram tree
	 */
	public List<DeployModelObject> getDiagramUnits() {
		if (_diagramUnits != null) {
			return _diagramUnits;
		}
		return refreshDiagramUnits();
	}

	/**
	 * refresh what units are in the diagram
	 * 
	 * @return the current units
	 */
	public List<DeployModelObject> refreshDiagramUnits() {
		if (_diagramUnits == null) {
			_diagramUnits = new ArrayList<DeployModelObject>();
		}
		_diagramUnits.clear();
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Diagram) {
			Diagram diagram = (Diagram) eObject;
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			boolean isFilterDiagramPrivates = store != null
					&& store.getBoolean(IDeployPreferences.DEPLOY_FILTER_DIAGRAM_CONTRACTS);
			for (Iterator<View> it = DiagramUtils.getAllChildViewsIncludingGroup(diagram).iterator(); it
					.hasNext();) {
				View view = it.next();
				EObject eo = view.getElement();
				if (eo instanceof Unit
						&& (!isFilterDiagramPrivates || ((Unit) eo).getTopology()
								.getConfigurationContract().isVisible((DeployModelObject) eo))) {
					_diagramUnits.add((Unit) eo);
				}
			}
		}
		return _diagramUnits;
	}

}
