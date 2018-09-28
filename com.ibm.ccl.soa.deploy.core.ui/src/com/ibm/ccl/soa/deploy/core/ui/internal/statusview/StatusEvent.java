/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

public class StatusEvent {

	public int severityType;

	boolean shouldFilter;

	public int getSeverityType() {
		return severityType;
	}

	public void setSeverityType(int severityType) {
		this.severityType = severityType;
	}

	public boolean isShouldFilter() {
		return shouldFilter;
	}

	public void setShouldFilter(boolean shouldFilter) {
		this.shouldFilter = shouldFilter;
	}

}
