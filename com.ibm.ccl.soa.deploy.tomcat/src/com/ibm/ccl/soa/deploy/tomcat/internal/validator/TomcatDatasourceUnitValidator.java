/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.j2ee.validator.J2EEDataSourceValidator;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;

/**
 * {@link TomcatDatasourceUnit}
 * 
 */
public class TomcatDatasourceUnitValidator extends J2EEDataSourceValidator {
	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return TomcatPackage.eINSTANCE.getTomcatDatasourceUnit();
	}

	/**
	 * Construct a {@link TomcatDatasourceUnit} instance validator.
	 */
	public TomcatDatasourceUnitValidator() {
		this(TomcatPackage.eINSTANCE.getTomcatDatasourceUnit());
	}

	/**
	 * @param unitType
	 */
	public TomcatDatasourceUnitValidator(EClass unitType) {
		super(unitType);
		this.addCapabilityTypeConstraint(TomcatPackage.Literals.TOMCAT50_DATASOURCE,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);

		this.addRequirementTypeConstraint(TomcatPackage.Literals.TOMCAT_SERVER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);
	}
}
