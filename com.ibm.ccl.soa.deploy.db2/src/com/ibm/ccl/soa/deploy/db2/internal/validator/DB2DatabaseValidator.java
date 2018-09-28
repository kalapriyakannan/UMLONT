/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Validates a {@link DB2Database} capability independent of its unit.
 * <p>
 * <ul>
 * <li> {@link IDB2ValidatorID#DB2_DATABASE_DB_NAME_001}
 * <li> {@link IDB2ValidatorID#DB2_DATABASE_DB_ALIAS_001}
 * </ul>
 * 
 * Note: the generic validator does not required that <code>dbName</code> or <code>dbAlias</code>
 * be set.
 */
public class DB2DatabaseValidator extends UnitCapabilityValidator {

	/**
	 * 
	 */
	public DB2DatabaseValidator() {
		this(Db2Package.eINSTANCE.getDB2Database());
	}

	protected DB2DatabaseValidator(EClass capabilityType) {
		super(capabilityType);
		assert Db2Package.eINSTANCE.getDB2Database().isSuperTypeOf(capabilityType);

		addAttributeValidator(new DeployAttributeValidator(IDB2ValidatorID.DB2_DATABASE_DB_NAME_001,
				Db2Package.eINSTANCE.getDB2Database_DbName()) {
			public void validate(DeployModelObject object, IDeployValidationContext context,
					IDeployReporter reporter) {
				String dbName = (String) getAttributeValue(object);
				if (dbName != null && dbName.length() > 0) {
					DB2ValidatorUtils.validateDB2GenericName(dbName, object, attribute, reporter);
				}
			}
		});

		addAttributeValidator(new DeployAttributeValidator(IDB2ValidatorID.DB2_DATABASE_DB_ALIAS_001,
				Db2Package.eINSTANCE.getDB2Database_DbAlias()) {
			public void validate(DeployModelObject object, IDeployValidationContext context,
					IDeployReporter reporter) {
				String dbAlias = (String) getAttributeValue(object);
				if (dbAlias != null && dbAlias.length() > 0) {
					DB2ValidatorUtils.validateDB2GenericName(dbAlias, object, attribute, reporter);
				}
			}
		});
	}
}
