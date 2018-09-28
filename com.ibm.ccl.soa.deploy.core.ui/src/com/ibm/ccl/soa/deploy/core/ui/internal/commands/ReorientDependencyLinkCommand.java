/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Command to change the source or target of a wire.
 */
public class ReorientDependencyLinkCommand extends EditElementCommand {

	/**
	 * @param request
	 */
	public ReorientDependencyLinkCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		DependencyLink link = (DependencyLink) getElementToEdit();
		Unit source = getUnit(link.getSource());
		Unit target = getUnit(link.getTarget());
		String displayName = link.getDisplayName();
		String description = link.getDescription();
		ReorientRelationshipRequest request = (ReorientRelationshipRequest) getRequest();
		EObject eo = request.getNewRelationshipEnd();
		// if user dropped on canvas, just do a no-op
		if (eo instanceof Topology) {
			return CommandResult.newOKCommandResult();
		} else if (eo instanceof Unit) {
			GEFUtils.deselectAll();
			// delete current link
			EcoreUtil.remove(link);

			// create new link
			if (request.getDirection() == ReorientRequest.REORIENT_SOURCE) {
				source = (Unit) eo;
			} else {
				target = (Unit) eo;
			}
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

			if (dvs.canBeLinkTarget(target,
					new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT }).isOK()
					&& dvs.canCreateLink(source, target,
							new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT }).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(source, target, new LinkType[] {
						LinkType.DEPENDENCY, LinkType.CONSTRAINT });
				if (hld.length > 0) {
					DeployModelObject newLink = hld[0].create();
					if (newLink != null) {
						newLink.setDisplayName(displayName);
						newLink.setDescription(description);
						return CommandResult.newOKCommandResult(newLink);
					}
				}
			}
		}
		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageBox msgBox = new MessageBox(parentShell, SWT.ICON_ERROR);
		msgBox.setText(Messages.ReorientHostingLinkCommand_Reorientation_Failur_);
		msgBox.setMessage(Messages.ReorientHostingLinkCommand_Could_not_move_this_link_to_this_so_);
		msgBox.open();
		throw new ExecutionException("couldn't reorient dependency link"); //$NON-NLS-1$
	}

	private Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}
}
