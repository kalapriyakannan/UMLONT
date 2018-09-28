/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.comparator;

import java.util.Comparator;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * @author daberg Used to sort {@link DeployModelObject}s based on their displayName if it is not
 *         null or name if the displayName is null;
 */
public class DeployModelObjectComparator implements Comparator<DeployModelObject> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(DeployModelObject dmo1, DeployModelObject dmo2) {
		assert dmo1 != null;
		assert dmo2 != null;
		String name1 = DeployModelObjectUtil.getTitle(dmo1);
		String name2 = DeployModelObjectUtil.getTitle(dmo2);
		return name1.compareToIgnoreCase(name2);
	}

}
