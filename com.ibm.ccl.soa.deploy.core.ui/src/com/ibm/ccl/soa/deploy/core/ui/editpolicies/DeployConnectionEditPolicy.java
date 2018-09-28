/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @author jswanke
 * 
 */
public class DeployConnectionEditPolicy extends ConnectionEditPolicy {

	// instead of deleting the notational view, delete the semantic element
	// when refreshed, the view will automatically delete
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		return createDeleteSemanticCommand(deleteRequest);
	}

	/**
	 * Return a command to delete the host's semantic elements. This method is called if the host is
	 * canonical.
	 * 
	 * @see #shouldDeleteSemantic()
	 * @param deleteRequest
	 *           the original delete request.
	 * @return Command
	 */
	protected Command createDeleteSemanticCommand(GroupRequest deleteRequest) {
		final EObject elementToDestroy = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (elementToDestroy != null && !PropertyUtils.isProxy((DeployModelObject) elementToDestroy)) {
			CompositeCommand cc = new CompositeCommand(null);
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
					.getEditingDomain();
			final List linkEPs = GMFUtils.getLinkEditPartsFor(this.getHost(), elementToDestroy);
			cc.compose(new AbstractTransactionalCommand(editingDomain, Messages.DELETE_LINKS, null) {
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
						IAdaptable info) {

					// delete model element
					EcoreUtil.remove(elementToDestroy);

					// delete view elements
					for (int i = 0; i < linkEPs.size(); i++) {
						IGraphicalEditPart gep = (IGraphicalEditPart) linkEPs.get(i);
						ViewUtil.destroy((View) gep.getModel());
					}

					return CommandResult.newOKCommandResult();
				}
			});
			return new ICommandProxy(cc);
		}
		return super.createDeleteViewCommand(deleteRequest);
	}
}
