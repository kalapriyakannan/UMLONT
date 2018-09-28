/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.ConstraintLinkUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintBasedLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintHostingLinkMatcher;

/**
 * Link matcher used for creation of deferred hosting constraint links.
 * 
 * TODO this is just a tentattive implementation, that uses {@link ConstraintHostingLinkMatcher}
 * with {@link ConstraintBasedLinkDescriptorFactory}.
 */
public class DeferredHostingConstraintLinkMatcher extends ConstraintHostingLinkMatcher {

	/**
	 * Public costructor.
	 */
	public DeferredHostingConstraintLinkMatcher() {
		super(new EClass[] { CorePackage.Literals.UNIT }, new EClass[] { CorePackage.Literals.UNIT },
				true);
		setLinkDescritptorFactory(new ConstraintBasedLinkDescriptorFactory(
				ConstraintPackage.Literals.DEFERRED_HOSTING_CONSTRAINT));
	}

	public IStatus canCreateLink(Unit hostUnit, Unit hosteeUnit) {
		if (!isHostUnitTypeAcceptable(hostUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus hosteeStatus = canBeLinkTarget(hosteeUnit);
		if (!hosteeStatus.isOK()) {
			return hosteeStatus;
		}

		// or if there is already a logical hosting link
		for (Iterator lIt = hosteeUnit.getConstraintLinks().iterator(); lIt.hasNext();) {
			ConstraintLink link = (ConstraintLink) lIt.next();
			Unit targetUnit = ConstraintLinkUtils.getLogicalLinkTargetedUnit(link);
			if (isHostUnitTypeAcceptable(targetUnit)) {
				return DeployMatcherStatus.LINK_ALREADY_PRESENT;
			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

}
