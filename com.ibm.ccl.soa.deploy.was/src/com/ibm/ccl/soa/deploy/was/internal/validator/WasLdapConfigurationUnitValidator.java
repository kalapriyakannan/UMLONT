/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * {@link WasDatasourceUnit}
 */
public class WasLdapConfigurationUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasLdapConfigurationUnit();
	}

	/**
	 * @param unitType
	 * 
	 */
	public WasLdapConfigurationUnitValidator() {
		super();
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasLdapConfiguration(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasAdvancedLdapConfiguration(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);

		// Should be LdapPackage.eINSTANCE.getLdapSuffix()}
		this.addRequirementTypeConstraint(CorePackage.eINSTANCE.getCapability(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 2);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSecurity(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
	}
}
