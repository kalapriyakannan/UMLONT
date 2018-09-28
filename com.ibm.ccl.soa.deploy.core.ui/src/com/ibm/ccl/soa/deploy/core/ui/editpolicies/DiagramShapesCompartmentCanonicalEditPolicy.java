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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Diagram;

import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 1.0
 * 
 * This canonical edit policy is installed on the DiagramEditPart ensuring that all the Unit
 * contained by the Topology is visualized on the Diagram.
 * 
 * Note: Once we move to multiple diagram paradigm, we will have to remove else all diagrams will be
 * identical in terms of their contents.
 */
public class DiagramShapesCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {

	/**
	 * 
	 */
	public DiagramShapesCompartmentCanonicalEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Diagram) {
			EditPart parent = getHost().getParent();
			if (parent instanceof DiagramNodeEditPart) {
				DiagramNodeEditPart dnep = (DiagramNodeEditPart) parent;
				return dnep.refreshDiagramUnits();
			}
		}
		return Collections.EMPTY_LIST;
	}

	protected Command getCreateViewCommand(CreateRequest request) {
		Diagram diagram = GMFUtils.getDiagram(getHost());
		if (diagram != null) {
			IGraphicalEditPart ep = (IGraphicalEditPart) getHost();
			List<CreateViewRequest.ViewDescriptor> descriptorList = ((CreateViewRequest) request)
					.getViewDescriptors();
			return new ICommandProxy(new VisualizeFromNotationalCommand(ep.getEditingDomain(),
					(IGraphicalEditPart) getHost().getParent(), descriptorList, null, diagram));
		}
		return super.getCreateViewCommand(request);
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}

}
