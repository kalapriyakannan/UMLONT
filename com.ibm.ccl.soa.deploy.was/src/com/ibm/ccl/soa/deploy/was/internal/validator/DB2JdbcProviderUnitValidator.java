/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.Arrays;
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
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validates a {link DB2JdbcProviderUnit}.
 */
public class DB2JdbcProviderUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getDB2JdbcProviderUnit();
	}

	/**
	 * 
	 */
	public DB2JdbcProviderUnitValidator() {
		super();
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getDB2JdbcProvider(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2JdbcDriver(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		//this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasServer(), RequirementLinkTypes.HOSTING_LITERAL,1, 1);

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.DB2_JDBC_PROVIDER_JDBC_TYPE_FROM_DB2_JDBC_DRIVER_JDBC_TYPE,
				WasPackage.eINSTANCE.getDB2JdbcProvider_JdbcType(), Db2Package.eINSTANCE
						.getDB2JdbcDriver_JdbcType()));

		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IWasValidatorID.WAS_DB2JDBCPROVIDER_DB2JDBCDRIVER_LINK_NON_LOCAL_001,
				Db2Package.eINSTANCE.getDB2JdbcDriver(), OsPackage.eINSTANCE.getOperatingSystem(),
				IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.DB2_JDBC_PROVIDER_PROVIDER_TYPE_001,
				JavaPackage.Literals.JDBC_PROVIDER__PROVIDER_TYPE, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.DB2_JDBC_PROVIDER_PROVIDER_NAME_001,
				JavaPackage.Literals.JDBC_PROVIDER__PROVIDER_NAME, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.DB2_JDBC_PROVIDER_CLASSPATH_001,
				JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH, IStatus.ERROR));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		DB2JdbcProvider jdbcProviderCap = (DB2JdbcProvider) ValidatorUtils.getCapability(unit,
				WasPackage.Literals.DB2_JDBC_PROVIDER);
		if (jdbcProviderCap != null) {
			validPath(jdbcProviderCap, JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH, reporter,
					jdbcProviderCap.getClasspath(), true);
			if (jdbcProviderCap.getNativepath() != null
					&& jdbcProviderCap.getNativepath().trim().length() > 0) {
				// scarlett 11/21/2006 trim the string to avoid empty path 
				// MK 11/16/2006 changed JDBC_PROVIDER__CLASSPATH to JDBC_PROVIDER__NATIVEPATH
				// MK 11/20/2006 removed until allows empty path
				validPath(jdbcProviderCap, JavaPackage.Literals.JDBC_PROVIDER__NATIVEPATH, reporter,
						jdbcProviderCap.getNativepath(), false);
			}
		}

		// TODO implement
//		DB2JdbcProvider.implementationClassName valid
//		DB2JdbcProvider.nativepath valid
//		DB2JdbcProvider.providerType valid (This is a freeform string)
	}

	private void validPath(Capability capability, EAttribute attribute, IDeployReporter reporter,
			String path, boolean checkClasspathSuffixes) {

		if (path == null) {
			return;
		}
		String classPathParts[] = path.split("[;\n]"); //$NON-NLS-1$
		List pathList = Arrays.asList(classPathParts);
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
//																				   IWasValidatorID.WAS_INVALID_CLASSPATH_VALUE_002, 
//																				   capability, 
//																				   attribute);
//						reporter.addStatus(status);
						}
					}
				}
			}
		}
	}
//	protected void validateDependencyLink(DependencyLink link, Unit unit,
//			IDeployValidationContext context, IDeployReporter reporter) {
//		super.validateDependencyLink(link, unit, context, reporter);
//	}
}
