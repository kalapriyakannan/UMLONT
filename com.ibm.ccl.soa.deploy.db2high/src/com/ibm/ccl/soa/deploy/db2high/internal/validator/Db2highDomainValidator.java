/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2high.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;
import com.ibm.ccl.soa.deploy.db2high.internal.validator.matcher.Db2highDomainMatcher;

/**
 * Validates objects in the {@link Db2highPackage} deploy domain.
 */
public class Db2highDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link Db2highPackage} domain validator.
	 */
	public Db2highDomainValidator() {
		super(Db2highPackage.eINSTANCE);
		
		addValidator(new DB2BufferPoolUnitValidator());
		addValidator(new DB2ConstraintUnitValidator());
		addValidator(new DB2FieldUnitValidator());
		addValidator(new DB2IndexUnitValidator());
		addValidator(new DB2ManagerUnitValidator());
		addValidator(new DB2PartitionGroupUnitValidator());
		addValidator(new DB2PermissionUnitValidator());
		addValidator(new DB2TableSpaceUnitValidator());
		addValidator(new DB2TableUnitValidator());
		addValidator(new DB2UserUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new Db2highDomainMatcher();
	}
}
