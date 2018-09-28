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

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.matcher.DB2DomainMatcher;

/**
 * Validates {@link Unit}s in the DB2 domain by delegating to Unit-specific validators
 * {@link DB2DatabaseUnitValidator}, {@link DB2InstanceUnitValidator},
 * {@link DB2SystemUnitValidator}, {@link DomainMatcher}, {@link DB2CatalogUnitValidator},
 * {@link DB2NodeCatalogUnitValidator}, {@link DB2RuntimeClientUnitValidator} and
 * {@link DB2JdbcProviderUnitValidator}.
 * 
 * <p>
 * Extends plug-in point 'com.ibm.ccl.soa.deploy.core.domains'.
 * 
 * @see Db2Package
 */
public class DB2DomainValidator extends UnitDomainValidator {

	/**
	 * Constructs a validator for the {@link Db2Package} deploy domain.
	 */
	public DB2DomainValidator() {
		super(Db2Package.eINSTANCE);

		addValidator(new DB2AdminClientUnitValidator());
		addValidator(new DB2AdminServerUnitValidator());
		addValidator(new DB2AppDevelClientUnitValidator());
		addValidator(new DB2CatalogUnitValidator());
		addValidator(new DB2DatabaseUnitValidator());
		addValidator(new DB2InstanceUnitValidator());
		addValidator(new DB2NodeCatalogUnitValidator());
		addValidator(new DB2RuntimeClientUnitValidator());
		addValidator(new DB2SystemUnitValidator());
		addValidator(new DB2ClientInstanceUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		return new DB2DomainMatcher();
	}
}
