/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * Suggests {@link Capability} types to be offered by an {@link SoftwareComponent} (but not
 * subclasses).
 * 
 * @author <a href="mailto:jeswanke@us.ibm.com">John Swanke</a>
 * @see SoftwareComponent
 */
public class SoftwareComponentFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableNubDmoTypes(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<String> getAllowableNubDmoTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();
		// because all compoenets are derived from Software componet they all call this filter
		// but we only want the generic SoftwareComponetnt to have all services available
		if (anInputUnit.getClass().getName().endsWith("SoftwareComponentImpl")) { //$NON-NLS-1$	
			list.add("deploy.Service"); //$NON-NLS-1$
			list.add("web.WebService"); //$NON-NLS-1$
			list.add("web.URLService"); //$NON-NLS-1$
			list.add("database.DatabaseDefinition"); //$NON-NLS-1$
		}

		return list;
	}

}
