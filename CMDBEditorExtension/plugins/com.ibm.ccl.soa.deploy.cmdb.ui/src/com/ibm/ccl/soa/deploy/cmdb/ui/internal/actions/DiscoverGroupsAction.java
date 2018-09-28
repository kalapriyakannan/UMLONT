/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.internal.actions;

import java.util.List;

import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;
import com.ibm.ccl.soa.deploy.cmdb.ui.internal.commands.AbstractDiscoverCommand;
import com.ibm.ccl.soa.deploy.cmdb.ui.internal.commands.DiscoverGroupsCommand;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * The action to discover groups.
 */
public class DiscoverGroupsAction extends AbstractDiscoverAction {

	/**
	 * Construct a groups discovery action.
	 * 
	 * @param page
	 *            the workbench page context.
	 */
	public DiscoverGroupsAction(IWorkbenchPage page) {
		super(page);
		setId(CmdbActionIds.DEPLOY_DISCOVER_GROUPS);
		setText(Messages.Discover_groups);
	}

	@Override
	protected AbstractDiscoverCommand createDiscoverCommand(List<Unit> units) {
		return new DiscoverGroupsCommand(units, getSelectedObjects(),
				getDiagramEditPart(), getActionPoint());
	}

	@Override
	protected boolean isEnabledOnUnit(Unit unit) {
		if (unit == null) {
			return false;
		}
		for (Requirement req : (List<Requirement>) unit.getRequirements()) {
			if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
				return true;
			}
		}
		return false;
	}
}
