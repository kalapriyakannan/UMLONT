/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * Creates a rule that conflicts with no other rule
 * but itself.
 *
 */
public class NonConflictingRule implements ISchedulingRule {
	
	public static final NonConflictingRule INSTANCE = new NonConflictingRule();

	public boolean contains(ISchedulingRule rule) { 
		return rule == this;
	}

	public boolean isConflicting(ISchedulingRule rule) { 
		return rule == this;
	}

}
