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

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Validates a {@link DB2AdminServerUnit}.
 * <p>
 * <ul>
 * <li> {@link DB2JdbcDriverValidator}
 * <li> {@link UnixDB2AdminServerValidator}
 * <li> {@link WindowsDB2AdminServerValidator}
 * </ul>
 */
public class DB2AdminServerUnitValidator extends ConfigurationUnitValidator {

	/**
	 * Construct a {@link DB2AdminServerUnit} validator.
	 */
	public DB2AdminServerUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2AdminServerUnit());
	}

	/**
	 * Construct a {@link DB2AdminServerUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link DB2AdminServerUnit}.
	 */
	protected DB2AdminServerUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2AdminServerUnit().isSuperTypeOf(unitType);

		addCapabilityTypeConstraint(Db2Package.Literals.DB2_ADMIN_SERVER,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		addRequirementTypeConstraint(Db2Package.Literals.DB2_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addCapabilityValidator(new WindowsDB2AdminServerValidator());
		addCapabilityValidator(new UnixDB2AdminServerValidator());
	}
}
