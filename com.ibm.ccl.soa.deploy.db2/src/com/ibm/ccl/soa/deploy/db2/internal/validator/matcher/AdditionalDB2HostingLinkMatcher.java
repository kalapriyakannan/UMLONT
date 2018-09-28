/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Additional matcher for DB2 domain that allows a {@link DB2DatabaseUnit} to be hosted directly on
 * a {@link DB2SystemUnit}.
 */
public class AdditionalDB2HostingLinkMatcher extends LinkMatcher {

	/**
	 * Constructor to set the link type for this matcher.
	 */
	public AdditionalDB2HostingLinkMatcher() {
		setLinkType(LinkType.HOSTING);
	}

	@Override
	public IStatus canCreateLink(Unit host, Unit hostee) {
		// try special case of hosting DB2DatabaseUnit directly on DB2System
		IStatus status = isDatabaseOnSystem(hostee, host);
		if (status.isOK()) {
			return status;
		}

		return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
	}

	public static IStatus isDatabaseOnSystem(Unit hostee, Unit host) {
		// if one unit is DB2DatabaseUnit and other is DB2SystemUnit then OK
		if (!Db2Package.eINSTANCE.getDB2DatabaseUnit().isSuperTypeOf(hostee.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!Db2Package.eINSTANCE.getDB2SystemUnit().isSuperTypeOf(host.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}
}
