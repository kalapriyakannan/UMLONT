/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class CommunicationConstraintUtil {

	/**
	 * Add a {@link CommunicationPortConstraint} to a {@link NetworkCommunicationConstraint} if not
	 * already present.
	 * 
	 * @param ncc
	 *           the target {@link NetworkCommunicationConstraint}
	 * @param port
	 *           the port to be identified by the {@link CommunicationPortConstraint}
	 * @return the {@link CommunicationPortConstraint}
	 */
	public CommunicationPortConstraint addCommunicationPortConstraint(
			NetworkCommunicationConstraint ncc, int port) {

		CommunicationPortConstraint cpc = ConstraintFactory.eINSTANCE
				.createCommunicationPortConstraint();
		cpc.setPort(port);
		ncc.getConstraints().add(cpc);

		return cpc;
	}
}
