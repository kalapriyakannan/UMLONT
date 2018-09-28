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
import com.ibm.ccl.soa.deploy.cmdb.ui.internal.commands.DiscoverDependencySourcesCommand;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * The action to discover dependency sources.
 */
public class DiscoverDependencySourcesAction extends AbstractDiscoverAction {

	/**
	 * Construct a dependency sources discovery action.
	 * 
	 * @param page
	 *            the workbench page context.
	 */
	public DiscoverDependencySourcesAction(IWorkbenchPage page) {
		super(page);
		setId(CmdbActionIds.DEPLOY_DISCOVER_DEPENDENCY_SOURCES);
		setText(Messages.Discover_dependency_sources);
	}

	@Override
	protected AbstractDiscoverCommand createDiscoverCommand(List<Unit> units) {
		return new DiscoverDependencySourcesCommand(units,
				getSelectedObjects(), getDiagramEditPart(), getActionPoint());
	}

	@Override
	protected boolean isEnabledOnUnit(Unit unit) {
		if (unit == null) {
			return false;
		}
		for (Capability cap : (List<Capability>) unit.getCapabilities()) {
			if (cap.getLinkType() == CapabilityLinkTypes.DEPENDENCY_LITERAL) {
				return true;
			}
			if (cap.getLinkType() == CapabilityLinkTypes.ANY_LITERAL) {
				return true;
			}
		}
		return false;
	}
}
