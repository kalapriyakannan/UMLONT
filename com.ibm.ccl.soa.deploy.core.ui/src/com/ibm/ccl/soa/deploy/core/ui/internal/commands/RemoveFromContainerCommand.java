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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.RemoveFromContainerAction;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;

/**
 * @author Ed Snible
 * @see RemoveFromContainerAction
 */
public class RemoveFromContainerCommand extends DeployTransactionalCommand {

	private final Unit member;
	private final Unit container;

	/**
	 * @param domain
	 * @param member
	 * @param container
	 */
	public RemoveFromContainerCommand(TransactionalEditingDomain domain, Unit member, Unit container) {
		super(domain, Messages.CMD_LABEL_REMOVE_FROM_GROUP, getAllWorkspaceFiles(container));

		this.member = member;
		this.container = container;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) /*
	 * throws
	 * ExecutionException
	 */{
		removeLink();

		// refresh diagram
		List<DeployModelObject> newList = new ArrayList<DeployModelObject>();
		newList.add(member);
		CanonicalUtils.refreshViews(newList, false);

		return CommandResult.newOKCommandResult();
	}

	private void removeLink() {
		for (Iterator it = container.getMemberLinks().iterator(); it.hasNext();) {
			MemberLink link = (MemberLink) it.next();
			if (link.getTarget() == member) {
				// Assume only one memberlink between member and container
				it.remove();
				return;
			}
		}
	}

}
