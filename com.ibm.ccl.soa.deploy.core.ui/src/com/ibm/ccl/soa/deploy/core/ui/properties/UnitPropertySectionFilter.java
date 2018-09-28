/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Filter for {@link Unit}.
 * 
 * @since V8M6
 */
public class UnitPropertySectionFilter implements IFilter {

	public boolean select(Object candidate) {
		return candidate instanceof Unit;
	}

}
