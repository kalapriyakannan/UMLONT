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

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.tools.ConstraintLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.DeployLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;

/**
 * 
 * @since 1.0
 * 
 */
public class CreateConstraintLinkCommand extends CreateRelationshipCommand {

	/**
	 * 
	 * @param request
	 */
	public CreateConstraintLinkCommand(CreateRelationshipRequest request) {
		super(request);
		setEClass(CorePackage.eINSTANCE.getUnit());
	}

	protected EObject doDefaultElementCreation() {
		Object requestDescriptor = getRequest().getParameter(ConstraintLinkCreationTool.DESCRIPTOR);
		if (requestDescriptor != null) {
			if (requestDescriptor instanceof ShortConstraintDescriptor) {
				ShortConstraintDescriptor descriptor = (ShortConstraintDescriptor) requestDescriptor;
				// has this link already been created by a previous command?
				Map<ShortConstraintDescriptor, ConstraintLink> linkResultMap = (Map<ShortConstraintDescriptor, ConstraintLink>) getRequest()
						.getParameter(DeployLinkCreationTool.LINKRESULTMAP);
				ConstraintLink link = linkResultMap.get(descriptor);
				if (link == null) {
					Unit target = (Unit) getTarget();
					Unit source = (Unit) getSource();
					link = CoreFactory.eINSTANCE.createConstraintLink();
					link.setName(UnitUtil.generateUniqueName(source, "cl")); //$NON-NLS-1$
					Constraint constraint = descriptor.createConstraint(link);
					constraint.setName(UnitUtil.generateUniqueName(link, "c")); //$NON-NLS-1$
					link.getConstraints().add(constraint);
					link.setTarget(target);
					link.setSource(source);
					source.getConstraintLinks().add(link);
					linkResultMap.put(descriptor, link);
				}
				return link;
			} else if (requestDescriptor instanceof LinkDescriptor) {
				LinkDescriptor descriptor = (LinkDescriptor) requestDescriptor;
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
		}
		return null;
	}

	/**
	 * Constraint Link can always be created
	 */
	public boolean canExecute() {
		// on first call to canExecute() the target isn't set yet
		EObject target = getTarget();
		if (target == null) {
			return true;
		}
		EObject source = getSource();
		if (source == target) {
			return false;
		}
		if (!(source instanceof Unit) || !(target instanceof Unit)) {
			return false;
		}
		return true;
	}
}
