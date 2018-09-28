/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.database.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.IDatabaseTemplateConstants;

/**
 * Registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code> extension point.
 * 
 * @author <a href="mailto:jeswanke@us.ibm.com">John Swanke</a>
 * @see DatabaseComponent
 */

public class DatabaseComponentFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableNubDmoTypes(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<?> getAllowableNubDmoTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();

		list.add(IDatabaseTemplateConstants.DATABASE_DEFINITION);

		return list;
	}

}
