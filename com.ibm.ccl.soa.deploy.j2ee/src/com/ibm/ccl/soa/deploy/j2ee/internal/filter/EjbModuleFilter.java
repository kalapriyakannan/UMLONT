/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.IJ2EETemplateConstants;

/**
 * Suggests {@link Capability} types to be offered by an {@link EjbModule}.
 * 
 * @see EjbModule
 */
public class EjbModuleFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableNubDmoTypes(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<String> getAllowableNubDmoTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();

		list.add(IJ2EETemplateConstants.ENTITY_SERVICE);
		list.add(IJ2EETemplateConstants.SESSION_SERVICE);

		return list;
	}
}
