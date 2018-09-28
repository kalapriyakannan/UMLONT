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

import com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link AIXLocalUserUnit}.
 * <p>
 */
public class AIXLocalUserUnitValidator extends UserUnitValidator {

	/**
	 * Construct a {@link AIXLocalUserUnit} instance validator.
	 */
	public AIXLocalUserUnitValidator() {
		this(OsPackage.eINSTANCE.getAIXLocalUserUnit());

	}

	/**
	 * Construct a {@link AIXLocalUserUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link AIXLocalUserUnit}.
	 */
	protected AIXLocalUserUnitValidator(EClass unitType) {
		super(unitType);
	}
}
