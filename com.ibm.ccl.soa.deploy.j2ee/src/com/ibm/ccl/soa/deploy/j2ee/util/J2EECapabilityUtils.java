/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.util;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;

public class J2EECapabilityUtils {

	/**
	 * Returns the value of the datasourceName attribute in the j2eeDataSource capability contained
	 * by the specified unit. Returns null if the unit does not contain a capability of type
	 * J2EEDataSource
	 * 
	 * @param unit
	 * @return
	 */
	public static String getDatasourceName(Unit unit) {
		return (String) CapabilityUtil.getAttributeFromUnitCapability(unit, J2eePackage.eINSTANCE
				.getJ2EEDatasource_DatasourceName(), J2eePackage.eINSTANCE.getJ2EEDatasource());

	}

	/**
	 * Returns the value of the alias attribute in the J2CAuthenticationDataEntry capability
	 * contained by the specified unit. Returns null if the unit does not contain a capability of
	 * type J2CAuthenticationDataEntry
	 * 
	 * @param unit
	 * @return
	 */
	public static String getJ2CAuthAlias(J2CAuthenticationUnit unit) {
		return (String) CapabilityUtil.getAttributeFromUnitCapability(unit, J2eePackage.eINSTANCE
				.getJ2CAuthenticationDataEntry_Alias(), J2eePackage.eINSTANCE
				.getJ2CAuthenticationDataEntry());
	}

	/**
	 * Returns the value of the contextRoot attribute in the webModuleCapability capability contained
	 * by the specified web module. Returns null if the unit does not contain a capability of type
	 * WebModuleCapability
	 * 
	 * @param unit
	 * @return
	 */
	public static String getContextRoot(WebModule webModule) {
		return (String) CapabilityUtil.getAttributeFromUnitCapability(webModule,
				J2eePackage.eINSTANCE.getWebModuleCapability_ContextRoot(), J2eePackage.eINSTANCE
						.getWebModuleCapability());
	}

	/**
	 * Returns the value of the moduleName attribute in the J2EEModuleCapability capability contained
	 * by the specified unit. Returns null if the unit does not contain a capability of type
	 * J2EEModuleCapability
	 * 
	 * @param unit
	 * @return
	 */
	public static String getModuleName(Unit unit) {
		return (String) CapabilityUtil.getAttributeFromUnitCapability(unit, J2eePackage.eINSTANCE
				.getJ2EEModuleCapability_ModuleName(), J2eePackage.eINSTANCE.getJ2EEModuleCapability());
	}

}
