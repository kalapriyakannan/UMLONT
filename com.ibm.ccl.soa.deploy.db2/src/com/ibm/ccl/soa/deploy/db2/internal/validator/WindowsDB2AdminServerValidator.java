/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;

/**
 * Validates a {@link WindowsDB2AdminServer} capability.
 * <p>
 * <ul>
 * <li> {@link IDB2ValidatorID#WINDOWS_DB2_ADMIN_SERVER_DAS_DOMAIN_001}
 * <li> {@link IDB2ValidatorID#WINDOWS_DB2_ADMIN_SERVER_DAS_USER_NAME_001}
 * </ul>
 */
public class WindowsDB2AdminServerValidator extends UnitCapabilityValidator {

	public WindowsDB2AdminServerValidator() {
		this(Db2Package.eINSTANCE.getWindowsDB2AdminServer());
	}

	public WindowsDB2AdminServerValidator(EClass capabilityType) {
		super(capabilityType);
		assert Db2Package.eINSTANCE.getWindowsDB2AdminServer().isSuperTypeOf(capabilityType);

		// dasDomain is optional
//		addAttributeValidator(new DeployAttributeNotNullValidator(
//				IDB2ValidatorID.WINDOWS_DB2_ADMIN_SERVER_DAS_DOMAIN_001,
//				Db2Package.eINSTANCE.getWindowsDB2AdminServer_DasDomain(),
//				IStatus.ERROR));

		// TODO implement validity checks other than emptiness?
		// WindowsDB2AdminServer.dasDomain valid
		// WindowsDB2AdminServer.dasUserName valid

	}
}
