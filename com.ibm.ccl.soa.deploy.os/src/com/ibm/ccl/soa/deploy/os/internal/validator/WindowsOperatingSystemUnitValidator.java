/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;

/**
 * Validates {@link WindowsOperatingSystemUnit}.
 * <p>
 */
public class WindowsOperatingSystemUnitValidator extends OperatingSystemUnitValidator {

	/**
	 * Construct a validator for {@link WindowsOperatingSystemUnit} instances.
	 */
	public WindowsOperatingSystemUnitValidator() {
		this(OsPackage.eINSTANCE.getWindowsOperatingSystemUnit());
	}

	/**
	 * Construct a validator for {@link WindowsOperatingSystemUnit} subtypes.
	 * 
	 * @param unitType
	 *           a subtype of {@link WindowsOperatingSystemUnit}.
	 */
	protected WindowsOperatingSystemUnitValidator(EClass unitType) {
		super(unitType);

		addAttributeValidator(new DeployAttributeInvalidPathnameValidator(
				IOsDomainValidators.WINDOWS_DIRECTORY_PATH_001,
				OsPackage.Literals.FILE_SYSTEM_CONTENT__FIXED_PATH, true));

	}
}
