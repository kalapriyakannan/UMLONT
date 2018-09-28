/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeNotNullValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;

/**
 * Validates a {@link UnixDB2AdminServer} capability.
 * <p>
 * <ul>
 * <li> {@link IDB2ValidatorID#UNIX_DB2_ADMIN_SERVER_DAS_GID_001}
 * <li> {@link IDB2ValidatorID#UNIX_DB2_ADMIN_SERVER_DAS_GROUP_NAME_001}
 * <li> {@link IDB2ValidatorID#UNIX_DB2_ADMIN_SERVER_DAS_UID_001}
 * <li> {@link IDB2ValidatorID#UNIX_DB2_ADMIN_SERVER_DAS_USER_NAME_001}
 * </ul>
 */
public class UnixDB2AdminServerValidator extends UnitCapabilityValidator {

	public UnixDB2AdminServerValidator() {
		this(Db2Package.eINSTANCE.getUnixDB2AdminServer());
	}

	public UnixDB2AdminServerValidator(EClass capabilityType) {
		super(capabilityType);
		assert Db2Package.eINSTANCE.getUnixDB2AdminServer().isSuperTypeOf(capabilityType);
		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.UNIX_DB2_ADMIN_SERVER_DAS_GID_001, Db2Package.eINSTANCE
						.getUnixDB2AdminServer_DasGID(), IStatus.ERROR));
		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.UNIX_DB2_ADMIN_SERVER_DAS_GROUP_NAME_001, Db2Package.eINSTANCE
						.getUnixDB2AdminServer_DasGroupName(), IStatus.ERROR));
		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.UNIX_DB2_ADMIN_SERVER_DAS_UID_001, Db2Package.eINSTANCE
						.getUnixDB2AdminServer_DasUID(), IStatus.ERROR));
		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.UNIX_DB2_ADMIN_SERVER_DAS_USER_NAME_001, Db2Package.eINSTANCE
						.getUnixDB2AdminServer_DasUserName(), IStatus.ERROR));
		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.UNIX_DB2_ADMIN_SERVER_DAS_USER_PASSWORD_001, Db2Package.eINSTANCE
						.getUnixDB2AdminServer_DasUserPassword(), IStatus.ERROR));

		// TODO
		// UnixDB2AdminServer.dasGroupName valid
		// UnixDB2AdminServer.dasUserName valid
	}
}
