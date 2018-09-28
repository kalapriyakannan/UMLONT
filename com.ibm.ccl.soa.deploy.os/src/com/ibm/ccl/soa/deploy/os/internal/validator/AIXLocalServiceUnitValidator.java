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

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link AIXLocalServiceUnit}.
 * <p>
 */
public class AIXLocalServiceUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link AIXLocalServiceUnit} instance validator.
	 */
	public AIXLocalServiceUnitValidator() {
		this(OsPackage.eINSTANCE.getAIXLocalServiceUnit());
	}

	/**
	 * Construct a {@link AIXLocalServiceUnit} validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link AIXLocalServiceUnit}.
	 */
	protected AIXLocalServiceUnitValidator(EClass unitType) {
		super(unitType);
	}
}
