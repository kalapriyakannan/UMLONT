/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;

/**
 * Validates {@link ConfigurationUnit}.
 */
public class ConfigurationUnitValidator extends UnitValidator {

	/**
	 * Construct a validator of {@link ConfigurationUnit} instances.
	 */
	public ConfigurationUnitValidator() {
		//TODO C7 model changes - configurationUnit is gone, still need this validator?
		this(CorePackage.eINSTANCE.getUnit());
	}

	/**
	 * Construct a validator of {@link ConfigurationUnit} instances.
	 * 
	 * @param unitType
	 *           a subtype of {@link ConfigurationUnit}.
	 */
	protected ConfigurationUnitValidator(EClass unitType) {
		super(unitType);
	}
}
