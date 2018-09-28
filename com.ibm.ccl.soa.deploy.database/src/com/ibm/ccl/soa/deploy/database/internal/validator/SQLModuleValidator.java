/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.SQLModule;

/**
 * Validates a {@link SQLModule}.
 * 
 * @see DatabaseDomainValidator
 */
public class SQLModuleValidator extends UnitValidator {

	/**
	 * Construct a new {@link SQLModule} validator.
	 */
	public SQLModuleValidator() {
		this(DatabasePackage.eINSTANCE.getSQLModule());
	}

	/**
	 * Construct a validator for a subtype of {@link SQLModule}.
	 * 
	 * @param unitType
	 *           an {@link SQLModule} subtype.
	 */
	protected SQLModuleValidator(EClass unitType) {
		super(unitType);
		//assert DatabasePackage.eINSTANCE.getSQLModule().isSuperTypeOf(unitType);
		this.addCapabilityTypeConstraint(DatabasePackage.Literals.SQL_USER,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(DatabasePackage.Literals.DATABASE,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
	}
}
