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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployCreateElementAndViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployToggleCanonicalModeCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;

/**
 * This edit policy creates a hostingList within a host compartment
 * 
 * @author jeswanke
 */
public class DeployCreationEditPolicy extends CreationEditPolicy {

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

		// get the semantic request
		// semantic element is always a child of the model
		View view = (View) getHost().getModel();
		EObject hostElement = view.getDiagram();
		if (hostElement == null) {
			return null;
		}
		createElementRequest.setContainer(hostElement);

		// is this a group creation?
		String semanticHint = null;
		if (createElementRequest.getElementType() instanceof IHintedType) {
			semanticHint = ((IHintedType) createElementRequest.getElementType()).getSemanticHint();
		}

		/*
		 * next we create the command that will create the objects and views
		 */
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		DeployCreateElementAndViewCommand createElementAndViewCommand = new DeployCreateElementAndViewCommand(
				editingDomain, request.getLocation(),
				DeployCreateElementAndViewCommand.DIAGRAM_CONTAINER, semanticHint, request,
				(CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class),
				getHost(), (View) getHost().getModel());
		if (createElementAndViewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}

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
		cc.compose(createElementAndViewCommand);
		cc.compose(new CommandProxy(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
				tcmd, false, true, false)));
		return new ICommandProxy(cc);
	}

	@Override
	protected Command getCreateCommand(CreateViewRequest request) {

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain,
				DiagramUIMessages.AddCommand_Label);

		Iterator descriptors = request.getViewDescriptors().iterator();

		while (descriptors.hasNext()) {
			final CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptors
					.next();
			final View containerView = (View) getHost().getModel();

			cc.compose(new AbstractTransactionalCommand(editingDomain, "", null) {//$NON-NLS-1$
						protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
								IAdaptable info) {

							View newView = ViewUtil.createView(descriptor.getViewKind(), descriptor
									.getElementAdapter(), containerView, descriptor.getSemanticHint(),
									descriptor.getIndex(), descriptor.isPersisted(), descriptor
											.getPreferencesHint());
							Assert.isNotNull(newView, "failed to create a view"); //$NON-NLS-1$
							descriptor.setView(newView);

							return CommandResult.newOKCommandResult();
						}
					});

		}
		return new ICommandProxy(cc.reduce());

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
