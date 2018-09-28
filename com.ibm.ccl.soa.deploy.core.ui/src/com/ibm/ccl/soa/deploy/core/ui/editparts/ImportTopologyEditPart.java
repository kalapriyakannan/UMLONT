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
import java.util.List;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ImportTopologyCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.ImportTopologyFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @author jswanke
 * 
 */
public class ImportTopologyEditPart extends DeployShapeNodeEditPart {

	// for import diagrams
	private boolean _isImportDiagram = false;
	private Diagram _importDiagram = null;
	private String _importDiagramName;

	/**
	 * @param shapeView
	 */
	public ImportTopologyEditPart(View shapeView) {
		super(shapeView);
		setCategory("Import Topology"); //$NON-NLS-1$

		// if this is a Import Diagram, get the diagram and its name
		DiagramLinkStyle style = (DiagramLinkStyle) shapeView.getStyle(NotationPackage.eINSTANCE
				.getDiagramLinkStyle());
		if (style != null) {
			_importDiagram = style.getDiagramLink();
			if (_importDiagram != null) {
				_isImportDiagram = true;
				if (_importDiagram.eIsProxy()) {
					_importDiagram = (Diagram) EcoreUtil.resolve(_importDiagram, shapeView);
				}
				if (_importDiagram instanceof Diagram && _importDiagram.eResource() != null) {
					_importDiagramName = _importDiagram.eResource().getURI().lastSegment();
					_importDiagramName = _importDiagramName.substring(0, _importDiagramName
							.lastIndexOf(".")); //$NON-NLS-1$
				} else {
					_importDiagramName = Messages.DiagramNodeEditPart_Unresolve_;
				}
				setCategory("Import Diagram"); //$NON-NLS-1$
			}
		}
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new ImportTopologyFigure(_isImportDiagram);
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

	/**
	 * refresh category can conceptual
	 */
	public void refreshValues() {
		if (isDeactivated) {
			return;
		}
		NodeFigure f = (NodeFigure) getMainFigure();
		Import imprt = (Import) ViewUtil.resolveSemanticElement((View) getModel());
		if (imprt != null) {
			if (f instanceof ImportTopologyFigure) {
				ImportTopologyFigure fig = (ImportTopologyFigure) f;
				fig.setCategory(category);

				String namespace = imprt.getNamespace();
				if (!_isImportDiagram) {
					fig.setNamespace(namespace);
				} else {
					// if Import Diagram, tag the import name to the namespace
					namespace = imprt.getNamespace();
					if (namespace != null && namespace.length() > 0) {
						namespace += "#";//$NON-NLS-1$
					}
					namespace += imprt.getDisplayName();
					fig.setNamespace(namespace);
				}
			}
			// since import model notifications are sent here we have to pass them down the line
			refreshVisibleChildren(imprt);
		}
	}

	private void refreshVisibleChildren(Import imprt) {
		InstanceConfiguration ic = imprt.getInstanceConfiguration();
		for (Unit unit : ic.getVisibleUnits()) {
			for (DeployShapeNodeEditPart ep : GMFUtils.getEditPartsFor(this, unit)) {
				ep.refreshValues();
				IGraphicalEditPart nameEP = ep.getChildBySemanticHint(DeployCoreConstants.DEPLOY_NAME);
				if (nameEP instanceof NameCompartmentEditPart) {
					((NameCompartmentEditPart) nameEP).refreshLabel();
				}
			}
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
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new ImportTopologyCreationEditPolicy());
	}

	/**
	 * @return list of compartment editparts which can be expanded
	 */

	public List getExpandableCompartmentEditParts() {
		List list = new ArrayList();
		IGraphicalEditPart ep = getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		ep = getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		return list;
	}

	/**
	 * @return the diagram if this is an Import Diagram
	 */
	public Diagram getImportDiagram() {
		return _importDiagram;
	}

	/**
	 * @return the name of the imported diagram
	 */
	public String getImportDiagramName() {
		return _importDiagramName;
	}

	/**
	 * @return is this an Import Diagram
	 */
	public boolean isImportDiagram() {
		return _isImportDiagram;
	}

}
