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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.tools.DeployLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @since 1.0
 * 
 */
public class CreateDependencyLinkCommand extends CreateRelationshipCommand {

	/**
	 * @param request
	 */
	public CreateDependencyLinkCommand(CreateRelationshipRequest request) {
		super(request);
		setEClass(CorePackage.eINSTANCE.getTopology());
	}

	protected EObject doDefaultElementCreation() {
		LinkDescriptor descriptor = (LinkDescriptor) getRequest().getParameter(
				DeployLinkCreationTool.DESCRIPTOR);
		if (descriptor != null) {
			// has this link already been created by a previous command?
			Map<LinkDescriptor, DeployModelObject> linkResultMap = (Map<LinkDescriptor, DeployModelObject>) getRequest()
					.getParameter(DeployLinkCreationTool.LINKRESULTMAP);
			DeployModelObject link = linkResultMap.get(descriptor);
			if (link == null) {
				link = descriptor.create();
				linkResultMap.put(descriptor, link);
				// if this creation was actually a resolution
				ResolutionUIUtils.refreshForLinkResolution(descriptor);
			}
			return link;
		}
		return null;
	}

	/**
	 * determine is any DependencyLink can be created
	 */
	public boolean canExecute() {
		// on first call to canExecute() the target isn't set yet
		EObject target = getTarget();
		if (target == null) {
			return true;
		}

		// if there's no link descriptor, the user is just seeing if there's a match of any kind between
		// two units-- so do a general match check		
		LinkDescriptor descriptor = (LinkDescriptor) getRequest().getParameter(
				DeployLinkCreationTool.DESCRIPTOR);
		if (descriptor == null) {
			EObject source = getSource();
			if (source == target) {
				return false;
			}
			if (!(source instanceof Unit) || !(target instanceof Unit)) {
				return false;
			}
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			return dvs.canCreateLink((Unit) source, null, (Unit) target, null,
					new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT },
					DeployValidatorService.MATCHER_DEPTH_ALL).isOK();
		}
		// else the user has picked a link from an approved list so we just assume it's good 
		return true;
	}

}
