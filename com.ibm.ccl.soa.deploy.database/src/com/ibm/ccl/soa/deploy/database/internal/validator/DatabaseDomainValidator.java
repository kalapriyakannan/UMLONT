/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.database.internal.validator;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;

/**
 * Validates {@link Unit} types from the Database domain.
 */
public class DatabaseDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link DatabasePackage} deploy domain validator.
	 */
	public DatabaseDomainValidator() {
		super(DatabasePackage.eINSTANCE);
		addValidator(new SQLModuleValidator());

		// TODO Add validation for DatabaseInstanceUnit
		// TODO Add validation for DatabaseUnit
		// TODO Add validation for DatabaseComponent
	}
}
