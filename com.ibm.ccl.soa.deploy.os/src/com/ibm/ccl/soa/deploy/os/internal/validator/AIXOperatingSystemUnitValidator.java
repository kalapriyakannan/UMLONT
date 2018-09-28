/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link AIXOperatingSystemUnit}.
 * <p>
 */
public class AIXOperatingSystemUnitValidator extends OperatingSystemUnitValidator {

	/**
	 * Construct a validator for {@link AIXOperatingSystemUnit} instances.
	 */
	public AIXOperatingSystemUnitValidator() {
		this(OsPackage.eINSTANCE.getAIXOperatingSystemUnit());
	}

	/**
	 * Construct a validator for {@link AIXOperatingSystemUnit} subtypes.
	 * 
	 * @param unitType
	 *           a subtype of {@link AIXOperatingSystemUnit}.
	 */
	protected AIXOperatingSystemUnitValidator(EClass unitType) {
		super(unitType);
	}
}
