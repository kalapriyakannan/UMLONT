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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployCreateElementAndViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployToggleCanonicalModeCommand;

/**
 * This edit policy adds a member/hostee to a hybrid compartment
 * 
 * @author jswanke
 */
public class HybridListCreationEditPolicy extends CreationEditPolicy {

	/**
	 * Method getCreateElementAndViewCommand.
	 * 
	 * @param request
	 * @return Command Which creates the sematnic and the view command for the given
	 *         CreateViewAndElementRequest
	 */
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {

		/*
		 * first we setup
		 */
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
		CreateElementRequest createElementRequest = (CreateElementRequest) requestAdapter
				.getAdapter(CreateElementRequest.class);
		// semantic element is always a child of the model
		View view = (View) getHost().getModel();
		EObject hostElement = view.getDiagram();
		if (hostElement == null) {
			return null;
		}
		createElementRequest.setContainer(hostElement);

		/*
		 * next we create the command that will create the objects and views and any hosting link this
		 * conceptual node
		 */
		String semanticHint = null;
		if (createElementRequest.getElementType() != null) {
			semanticHint = ((IHintedType) createElementRequest.getElementType()).getSemanticHint();
		}
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		DeployCreateElementAndViewCommand createElementAndViewCommand = new DeployCreateElementAndViewCommand(
				editingDomain, request.getLocation(),
				DeployCreateElementAndViewCommand.HYBRID_LIST_CONTAINER, semanticHint, request,
				(CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class),
				getHost(), (View) getHost().getModel());
		if (createElementAndViewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}

		/*
		 * make sure conceputal node compartment is expanded
		 */
		ChangePropertyValueRequest expandReq = new ChangePropertyValueRequest(
				DiagramUIMessages.PropertyDescriptorFactory_CollapseCompartment,
				Properties.ID_COLLAPSED, new Boolean(false));
		Command expandCmd = getHost().getCommand(expandReq);

		/*
		 * finally, we put all the commands into one composite command and wrap that in a proxy
		 * command
		 */
		CompositeCommand cc = new CompositeCommand(createElementAndViewCommand.getLabel());
		// turn off the editpolicy in the diagram that makes sure each semantic elements have views
		// otherwise the CU element will get a view in the diagram and in the server
		DeployToggleCanonicalModeCommand tcmd = DeployToggleCanonicalModeCommand
				.getToggleCanonicalModeCommand(getDiagramEditPartList(), false, false, false);
		cc.compose(new CommandProxy(tcmd));
		cc.compose(new CommandProxy(expandCmd));
		cc.compose(createElementAndViewCommand);
		cc.compose(new CommandProxy(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
				tcmd, false, true, false)));
		return new ICommandProxy(cc);
	}

	private Collection getDiagramEditPartList() {
		List list = new ArrayList();
		EditPart ep = getHost();
		while (!(ep instanceof DiagramEditPart)) {
			ep = ep.getParent();
			if (ep == null) {
				list.add(getHost());
				return list;
			}
		}
		list.add(ep);
		return list;
	}
}
