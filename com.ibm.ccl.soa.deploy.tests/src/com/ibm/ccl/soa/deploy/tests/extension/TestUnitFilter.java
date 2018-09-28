/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * Provides a default test implementation of UnitProvider
 * 
 * @since 1.0
 * 
 */
public class TestUnitFilter extends UnitFilter {

	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();
		list.add("was.WasDatasourceUnit.50"); //$NON-NLS-1$
		list.add("was.WasDatasourceUnit.40"); //$NON-NLS-1$
		return list;
	}

	public List getAllowableMemberUnitTypes(Unit anInputUnit) {
		return null;
	}

}
