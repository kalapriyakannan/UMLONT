/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * Provides a default implementation of {@link UnitFilter} that can be returned when clients provide
 * unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.unitLifecycle</b>.
 * 
 * @since 1.0
 * @see UnitFilter
 * 
 */
public class SkeletonUnitFilter extends UnitFilter {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonUnitFilter INSTANCE = new SkeletonUnitFilter();

	private SkeletonUnitFilter() {
	}

	public List<?> getAllowableHostingUnitTypes(Unit anInputUnit) {
		return null;
	}

	public List<?> getAllowableMemberUnitTypes(Unit anInputUnit) {
		return null;
	}

}
