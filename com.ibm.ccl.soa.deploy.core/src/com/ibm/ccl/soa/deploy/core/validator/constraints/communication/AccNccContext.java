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

import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;

public class AccNccContext extends CVC {

	public final static String ACC = "ACC"; //$NON-NLS-1$
	public final static String NCC = "NCC"; //$NON-NLS-1$

	public AccNccContext(ApplicationCommunicationConstraint acc, NetworkCommunicationConstraint ncc) {
		setAcc(acc);
		setNcc(ncc);
		setContext(acc);
	}

	public void setNcc(NetworkCommunicationConstraint ncc) {
		this.setAttribute(NCC, ncc);
	}

	public NetworkCommunicationConstraint getNcc() {
		return (NetworkCommunicationConstraint) this.getAttribute(NCC);
	}

	public void setAcc(ApplicationCommunicationConstraint acc) {
		this.setAttribute(ACC, acc);
	}

	public ApplicationCommunicationConstraint getAcc() {
		return (ApplicationCommunicationConstraint) this.getAttribute(ACC);
	}
}
