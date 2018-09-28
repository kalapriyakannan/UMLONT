/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasSharedLibraryEntryUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasSharedLibraryEntryUnit();
	}

	public WasSharedLibraryEntryUnitValidator() {
		super(WasPackage.eINSTANCE.getWasSharedLibraryEntryUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getSharedLibraryEntry(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSharedLibContainer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_SHAREDLIB_UNIT_SHAREDLIBENTRY_NAME_EMPTY_001,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME, IStatus.ERROR));

		// FIXME
//		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
//				IWasValidatorID.WAS_SHAREDLIB_UNIT_CLASSPATH_EMPTY_001,
//				WasPackage.Literals.SHARED_LIBRARY_ENTRY__CLASS_PATH,
//				IStatus.WARNING));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		SharedLibraryEntry sharedLibCap = (SharedLibraryEntry) ValidatorUtils.getCapability(unit,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (sharedLibCap == null) {
			return;
		}

		validatePathList(sharedLibCap, sharedLibCap.getClassPath(),
				WasPackage.Literals.SHARED_LIBRARY_ENTRY__CLASS_PATH, reporter, true);
		if (sharedLibCap.getNativePath() != null && sharedLibCap.getNativePath().size() > 0) {
			validatePathList(sharedLibCap, sharedLibCap.getNativePath(),
					WasPackage.Literals.SHARED_LIBRARY_ENTRY__NATIVE_PATH, reporter, false);
		}

	}

	/**
	 * validate the pathList attribute, check: 1. paths are end with '*.jar' 2. variables are used by
	 * the path are exist and reachable
	 * 
	 * @param capability
	 * @param pathList
	 * @param attribute
	 * @param reporter
	 */
	private void validatePathList(Capability capability, List pathList, EAttribute attribute,
			IDeployReporter reporter, boolean checkClasspathSuffixes) {
		if (pathList == null) {
			return;
		}
		if (pathList.size() <= 0) {
			return;
		}

		Iterator classPathIt = pathList.iterator();
		while (classPathIt.hasNext()) {
			String pathValue = (String) classPathIt.next();
			int validator = WasValidationUtil.validWasConfigPathString(pathValue, OsValidatorUtils
					.getOsType(capability), checkClasspathSuffixes);
			if (validator == 0) {
				continue;
			}

			if (validator == -1) {
				IDeployAttributeStatus status = DeployCoreStatusUtil.createAttributeInvalidStatus(
						IStatus.ERROR, IWasValidatorID.WAS_INVALID_CLASSPATH_VALUE_001, capability,
						attribute);
				reporter.addStatus(status);
			}

			if (validator == 1) {
				//parse out the variables
				List variableNameList = WasValidationUtil.parseUsingVariables(pathValue);

				if (variableNameList.size() > 0) {

					Iterator variableIt = variableNameList.iterator();
					while (variableIt.hasNext()) {
						//check the existness of the variables
						String variableName = (String) variableIt.next();
						if (!WasValidationUtil.checkExistnessOfVariable(variableName, capability)) {
							IDeployStatus status = DeployWasMessageFactory.createVariableUndefinedStatus(
									variableName, attribute, capability);
							reporter.addStatus(status);
							// error already noted; no need to repeat
//						status = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR, 
//																					   IWasValidatorID.WAS_INVALID_CLASSPATH_VALUE_002, 
//																					   capability, 
//																					   attribute);
//						reporter.addStatus(status);
						}
					}
				}
			}
		}
	}
}
