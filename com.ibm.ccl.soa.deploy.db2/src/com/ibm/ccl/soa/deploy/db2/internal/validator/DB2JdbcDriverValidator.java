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

import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeRestrictedValueValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.java.validator.pattern.ClassNameAttributeValidator;

/**
 * Generic validation of the {@link DB2JdbcDriver} capability, independent of the unit which
 * contains it.
 * <p>
 * <ul>
 * <li> {@link IDB2ValidatorID.DB2_JDBC_DRIVER_001}
 * <li> {@link IDB2ValidatorID.DB2_JDBC_DRIVER_002}
 * </ul>
 */
public class DB2JdbcDriverValidator extends UnitCapabilityValidator {

	/**
	 * Construct a {@link DB2JdbcDriver} validator.
	 */
	public DB2JdbcDriverValidator() {
		this(Db2Package.eINSTANCE.getDB2JdbcDriver());
	}

	/**
	 * Construct a validator for a {@link DB2JdbcDriver} subtype.
	 * 
	 * @param capabilityType
	 *           a subtype of {@link DB2JdbcDriver}.
	 */
	protected DB2JdbcDriverValidator(EClass capabilityType) {
		super(capabilityType);
		assert Db2Package.eINSTANCE.getDB2JdbcDriver().isSuperTypeOf(capabilityType);

		addAttributeValidator(new DeployAttributeRestrictedValueValidator(
				IDB2ValidatorID.DB2_JDBC_DRIVER_JDBC_TYPE_001, Db2Package.eINSTANCE
						.getDB2JdbcDriver_JdbcType(), new Object[] { JdbcTypeType._2_LITERAL,
						JdbcTypeType._4_LITERAL }));

		addAttributeValidator(new ClassNameAttributeValidator(IDB2ValidatorID.DB2_JDBC_DRIVER_002,
				Db2Package.eINSTANCE.getDB2JdbcDriver_Classname()));

		addAttributeValidator(new ClassPathAttributeValidator(IDB2ValidatorID.DB2_JDBC_DRIVER_003,
				Db2Package.eINSTANCE.getDB2JdbcDriver_Classpath()));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_JDBC_DRIVER_004, Db2Package.eINSTANCE.getDB2JdbcDriver_Classpath(),
				IStatus.ERROR));

		// Valid driver path for operating system (generic check).
		// TODO
		// DB2ValidatorUtils.validatePathValidForHostingOS(db2JdbcDriver,
		// Db2Package.Literals.DB2_JDBC_DRIVER__DRIVER_PATH, reporter);

		// DB2JdbcDriver.driverPath valid
		// DB2JdbcDriver.driverPath implied OS matches operatingSystem.osType
	}
}
