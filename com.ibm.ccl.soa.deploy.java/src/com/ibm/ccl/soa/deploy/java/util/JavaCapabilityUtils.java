/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.util;

import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;

public class JavaCapabilityUtils {

	/**
	 * Returns the value of the providerName attribute in the JdbcProvider capability contained by
	 * the specified jdbc provider unit. Returns null if the unit does not contain a capability of
	 * type JdbcProvider
	 * 
	 * @param unit
	 * @return the provider name, or null
	 */
	public static String getProviderName(JdbcProviderUnit provider) {
		return (String) CapabilityUtil.getAttributeFromUnitCapability(provider, JavaPackage.eINSTANCE
				.getJdbcProvider_ProviderName(), JavaPackage.eINSTANCE.getJdbcProvider());

	}

}
