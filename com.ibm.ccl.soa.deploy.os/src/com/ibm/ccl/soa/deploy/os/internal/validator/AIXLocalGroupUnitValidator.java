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

import com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link AIXLocalGroupUnit}.
 * <p>
 */
public class AIXLocalGroupUnitValidator extends UserGroupUnitValidator {

	/**
	 * Construct a {@link AIXLocalGroupUnit} instance validator.
	 */
	public AIXLocalGroupUnitValidator() {
		this(OsPackage.eINSTANCE.getAIXLocalGroupUnit());

	}

	/**
	 * Construct a {@link AIXLocalGroupUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link AIXLocalGroupUnit}.
	 */
	protected AIXLocalGroupUnitValidator(EClass unitType) {
		super(unitType);
	}
}
