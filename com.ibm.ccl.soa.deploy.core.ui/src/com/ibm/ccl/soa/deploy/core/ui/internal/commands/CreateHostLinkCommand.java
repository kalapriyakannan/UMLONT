/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @since 1.0
 * 
 */
public class CreateHostLinkCommand extends AbstractTransactionalCommand {

	protected CreateViewRequest.ViewDescriptor viewDescriptor = null;
	protected Unit hostedUnit = null;
	protected View containerView = null;

	/**
	 * @param editingDomain
	 * @param viewDescriptor
	 * @param containerView
	 */
	public CreateHostLinkCommand(TransactionalEditingDomain editingDomain,
			CreateViewRequest.ViewDescriptor viewDescriptor, View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));

		Assert.isNotNull(viewDescriptor);
		Assert.isNotNull(containerView);

		this.viewDescriptor = viewDescriptor;
		this.containerView = containerView;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * @param editingDomain
	 * @param hostedUnit
	 * @param containerView
	 */
	public CreateHostLinkCommand(TransactionalEditingDomain editingDomain, Unit hostedUnit,
			View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));

		Assert.isNotNull(hostedUnit);
		Assert.isNotNull(containerView);

		this.hostedUnit = hostedUnit;
		this.containerView = containerView;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(hostedUnit));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		try {
			Unit unit1 = (Unit) ViewUtil.resolveSemanticElement(containerView);
			Unit unit2 = hostedUnit != null ? hostedUnit : (Unit) ViewUtil
					.resolveSemanticElement((View) viewDescriptor.getAdapter(NodeImpl.class));

			// bug https://cs.opensource.ibm.com/bugzilla/show_bug.cgi?id=12656 , when creating
			// a unit + hosting link if the parent is conceptual make the child conceptual
			if (unit1.isConceptual()) {
				unit2.setConceptual(true);
			}

			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
// MK
//		if (dvs.canCreateHostingLink(unit1, unit2).isOK()) {
//			LinkDescriptor [] hld = dvs.getPossibleHostingLinks(unit1, unit2);
			if (dvs.canCreateLink(unit1, unit2,
					new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT }).isOK()) {
				LinkDescriptor[] hld = dvs.getPossibleLinks(unit1, unit2, new LinkType[] {
						LinkType.HOSTING, LinkType.CONSTRAINT });
				if (hld.length > 0) {
					hld[0].create();
					return CommandResult.newOKCommandResult(viewDescriptor);
				}
			}
		} catch (Exception e) {
		}
		return CommandResult.newErrorCommandResult(Messages.CANT_HOST_MESSAGE);
	}

	public boolean canExecute() {
		return true;
	}

}
