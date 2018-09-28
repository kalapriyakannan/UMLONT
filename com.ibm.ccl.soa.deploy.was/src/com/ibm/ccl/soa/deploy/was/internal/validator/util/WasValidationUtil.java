/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

public class WasValidationUtil {

	public final static String WAS_DEFAULT_SERVER_NAME = "server1"; //$NON-NLS-1$

	public final static String WAS_VARIABLE_PREFIX = "${"; //$NON-NLS-1$
	public final static String WAS_VARIABLE_POSTFIX = "}"; //$NON-NLS-1$

	public final static String CONSTRAINT_TYPE = "CONSTRAINT_TYPE"; //$NON-NLS-1$
	public final static String WAS_HOST = "WAS_HOST"; //$NON-NLS-1$

	private WasValidationUtil() {
		// static methods only.
	}

	public static IDeployStatus createContainOneDmgrNodeStatus(Unit unit, Requirement req,
			EClass source, EClass target) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createObjectStatus(
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, unit);
		status
				.setUnboundMessage(DeployCoreMessages.Validator_hosting_link_0_requirement_1_does_not_match);
		status.setBindings(new Object[] { unit, req });
		return status;
	}

	/**
	 * Creates a status on a unit whose source units have a requirement whose type does not match.
	 * 
	 * @param link
	 *           the marked hosting link.
	 * @param cap
	 *           the hosted unit's consumed capability whose attribute does not match.
	 * @param source
	 *           the type of the source hosting capability.
	 * @param target
	 *           the type of the target hosting capability.
	 * @return the created status.
	 */
	public static IDeployStatus createContainOneDmgrNodeStatus(Unit unit, Capability cap,
			EClass source, EClass target) {
		// TODO move to hosting link status in C5
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createObjectStatus(
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, unit);
		status
				.setUnboundMessage(DeployCoreMessages.Validator_hosting_link_0_requirement_1_does_not_match);
		status.setBindings(new Object[] { unit, cap });
		return status;
	}

	/**
	 * Creates a status on a unit whose source units have a requirement whose type does not match.
	 * 
	 * @param link
	 *           the marked hosting link.
	 * @param cap
	 *           the hosted unit's consumed capability whose attribute does not match.
	 * @param source
	 *           the type of the source hosting capability.
	 * @param target
	 *           the type of the target hosting capability.
	 * @return the created status.
	 */
	public static IDeployStatus createContainOneAppserverNodeStatus(Unit unit, Capability cap,
			EClass source, EClass target) {
		// TODO move to hosting link status in C5
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createObjectStatus(
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID, unit);
		status
				.setUnboundMessage(DeployCoreMessages.Validator_hosting_link_0_requirement_1_does_not_match);
		status.setBindings(new Object[] { unit, cap });
		return status;
	}

	/**
	 * 
	 * @param path
	 * @param osType
	 *           osType field from hosting operating system, or null if not known
	 * @return status of the classPath String -1, if the path not end with
	 *         ('.jar'||'.zip'||'.dll'||'.so'||'.lib', which means it is wrong 1, the string may
	 *         invovled variables 0, most likely right path //TODO more checking for the path
	 */
	public static int validWasConfigPathString(String path, String osType,
			boolean checkClasspathSuffixes) {
		if (path == null || path.trim().length() <= 0) {
			return -1;
		}

		// MK 11/06/2006 added .zip as a possiblility since this is the default
		// for
		// DB2 Legacy CLI-based Type 2 JDBC Driver (XA)
		if (checkClasspathSuffixes
				&& !path.endsWith(".jar") && !path.endsWith(".zip") && !path.endsWith(".dll") && !path.endsWith(".so") && !path.endsWith(".lib") && !path.endsWith(WAS_VARIABLE_POSTFIX)) {//$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			return -1;
		}
		if (path.startsWith(".")) { //$NON-NLS-1$
			return -1;
		}
		if (-1 != path.indexOf(WAS_VARIABLE_PREFIX)) {
			return 1;
		}

		// if we ended with  WAS_VARIABLE_POSTFIX but we didn't find the start then we have a problem
		if (path.endsWith("}")) { //$NON-NLS-1$
			return -1;
		}

		// Strictly, should check if the path doesn't start with a WAS Variable Prefix. 
		if (OsValidatorUtils.isUnixOsType(osType)) {
			if (!OsValidatorUtils.isValidRootedUnixPath(path, true)) {
				return -1;
			}
		} else if (OsValidatorUtils.isWindowsOsType(osType)) {
			if (!OsValidatorUtils.isValidWindowsPathWithDriveLetter(path, true, true)) {
				return -1;
			}
		} else {
			// OS unknown, assume ?windows?
			if (!(OsValidatorUtils.isValidWindowsPathWithDriveLetter(path, true, true) || OsValidatorUtils
					.isValidRootedUnixPath(path, true))) {
				return -1;
			}
		}

		return 0;
	}

	/**
	 * parse out the variable Names occured in the input path string
	 * 
	 * @param path
	 * @return a list of variable Names that occured in the path string
	 */
	public static List parseUsingVariables(String path) {
		if (path == null || path.length() == 0) {
			return Collections.EMPTY_LIST;
		}
		List variableNameList = new ArrayList();

		while (-1 != path.indexOf(WAS_VARIABLE_PREFIX)) {
			// while(path.contains(WAS_VARIABLE_PREFIX)){
			path = path.substring(path.indexOf(WAS_VARIABLE_PREFIX) + 2);
			if (-1 == path.indexOf(WAS_VARIABLE_POSTFIX)) {
				return null;
			}
			// if(! path.contains(WAS_VARIABLE_POSTFIX)) return null;
			String variableName = path.substring(0, path.indexOf(WAS_VARIABLE_POSTFIX));
			if (variableName != null && variableName.length() > 0) {
				variableNameList.add(variableName);
			}
		}

		return variableNameList;
	}

	/**
	 * 
	 * @param variableName
	 * @param scopeUnit
	 * @return if there are WasSubstitutionVariable capability for the scopeUnit and extended
	 *         attributes had been added to it return true, otherwise false
	 */
	private static boolean hasVariable(String variableName, Unit scopeUnit) {
		WasSubstitutionVariable subVarialbeEntryCap = (WasSubstitutionVariable) ValidatorUtils
				.getCapability(scopeUnit, WasPackage.Literals.WAS_SUBSTITUTION_VARIABLE);
		if (subVarialbeEntryCap != null) {
			List extendeAttributeL = subVarialbeEntryCap.getExtendedAttributes();
			if (extendeAttributeL != null) {
				Iterator attriIt = extendeAttributeL.iterator();
				while (attriIt.hasNext()) {
					ExtendedAttribute attribute = (ExtendedAttribute) attriIt.next();
					if (attribute.getName().equals(variableName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * check whether or not the variable had been set
	 * 
	 * @param variableName
	 * @param configurationCap
	 * @return boolean
	 */
	public static boolean checkExistnessOfVariable(String variableName, Capability configurationCap) {
		// collect and check existeness
		assert configurationCap != null;
		assert variableName != null;
		Topology top = configurationCap.getEditTopology();

		Unit configUnit = (Unit) configurationCap.getParent();
		Unit scopeUnit = WasUtil.getWasScope(configUnit, top);
		// cell, server, node, cluster scope
		if (hasVariable(variableName, scopeUnit)) {
			return true;
		}

		if (scopeUnit instanceof WebsphereAppServerUnit) {
			Capability nodeCap = WasUtil.getWasNodeCap((WebsphereAppServerUnit) scopeUnit, top);
			if (nodeCap == null) {
				return false;
			}

			scopeUnit = (Unit) nodeCap.getParent();
			if (hasVariable(variableName, scopeUnit)) {
				return true;
			}
		}

		Capability cellCap = null;
		if (scopeUnit instanceof WasNodeUnit) {
			cellCap = WasUtil.getWasCellCap((WasNodeUnit) scopeUnit, top);
		} else if (scopeUnit instanceof WasClusterUnit) {
			cellCap = WasUtil.getWasCellCap((WasClusterUnit) scopeUnit, top);
		} else if (scopeUnit instanceof WasCellUnit) {
			return false;
		}
		if (cellCap == null) {
			return false;
		}

		scopeUnit = (Unit) cellCap.getParent();
		if (hasVariable(variableName, scopeUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the cell of the WAS node unit.
	 * 
	 * @param nodeUnit
	 *           a WAS node unit.
	 * @return the cell capability that groups the node, or null if not found.
	 */
	public static WasCell getWasCell(WasNodeUnit nodeUnit) {
		if (nodeUnit == null) {
			return null;
		}
		return (WasCell) ValidatorUtils.discoverGroupByCapabilityType(nodeUnit,
				WasPackage.Literals.WAS_CELL, null);
	}

	/**
	 * Returns the node gorup of the WAS node unit.
	 * 
	 * @param nodeUnit
	 *           a WAS node unit.
	 * @return the node group capability that groups the node, or null if not found.
	 */
	public static WasNodeGroup getWasNodeGroup(WasNodeUnit nodeUnit) {
		if (nodeUnit == null) {
			return null;
		}
		return (WasNodeGroup) ValidatorUtils.discoverGroupByCapabilityType(nodeUnit,
				WasPackage.Literals.WAS_NODE_GROUP, null);
	}

	public static IDeployStatus createMissingSharedLibraryReference(int severity,
			String validatorID, Unit appModule, Unit sourceApp, Unit wasHost, Unit jarModule) {

		WasDeployStatus status = new WasDeployStatus(severity, validatorID,
				IWASProblemType.MISSING_SHARED_LIBARY,
				WasDomainMessages.Validator_Missing_Shared_Library_Reference_0,
				new Object[] { jarModule.getCaptionProvider().title(jarModule) }, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_REFERER, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_APP, sourceApp);
		status.setAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_HOST, wasHost);
		status.setAttribute(IWasDeployStatusAttributeNames.MISSING_SHARED_LIBRARY_TARGET_JAR,
				jarModule);
		return status;
	}

	public static WasDeployStatus createConflictingSharedLibraryReferences(int severity,
			String validatorID, Unit appModule, Unit sharedLibA, Unit sharedLibB) {

		WasDeployStatus status = new WasDeployStatus(severity, validatorID,
				IWASProblemType.CONFLICTING_SHARED_LIBARIES,
				WasDomainMessages.Validator_Inconsistent_Shared_Library_References, new Object[] {},
				appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_A, sharedLibA);
		status.setAttribute(IWasDeployStatusAttributeNames.CONFLICTING_SHARED_LIBRARY_B, sharedLibB);
		return status;
	}

	public static IDeployStatus createSharedLibraryHostingConflict(int severity, String validatorID,
			Unit sharedLib, Unit module, Unit appHost) {

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				validatorID, IWASProblemType.REFERENCED_SHARED_LIBARY_HOSTING_CONFLICT,
				WasDomainMessages.Validator_Referenced_Shared_Library_Hosting_Inconsistency,
				new Object[] { module.getCaptionProvider().title(module) }, sharedLib);
		return status;
	}

	public static IDeployStatus createSharedLibraryReference(int severity, String validatorID,
			Unit appModule, Unit sourceApp, Unit wasHost, Unit jarModule) {
		WasDeployStatus status = new WasDeployStatus(severity, validatorID,
				IWASProblemType.CREATE_SHARED_LIBRARY,
				WasDomainMessages.Validator_Create_Shared_Library_Reference_0, new Object[] { jarModule
						.getCaptionProvider().title(jarModule) }, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_REFERER, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_APP, sourceApp);
		status.setAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_HOST, wasHost);
		status.setAttribute(IWasDeployStatusAttributeNames.CREATE_SHARED_LIBRARY_TARGET_JAR,
				jarModule);
		return status;
	}

	public static IDeployStatus addToSharedLibraryReference(int severity, String validatorID,
			Unit appModule, Unit sourceApp, Unit wasHost, Unit jarModule, List<Unit> appSLs,
			List<Unit> serverSLs) {
		WasDeployStatus status = new WasDeployStatus(severity, validatorID,
				IWASProblemType.ADD_TO_SHARED_LIBRARY,
				WasDomainMessages.Validator_Add_to_Existing_Shared_Library_Reference_0,
				new Object[] { jarModule.getCaptionProvider().title(jarModule) }, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_REFERER, appModule);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_APP, sourceApp);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_HOST, wasHost);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_TARGET_JAR,
				jarModule);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_APP_SLS, appSLs);
		status.setAttribute(IWasDeployStatusAttributeNames.ADD_TO_SHARED_LIBRARY_SERVER_SLS,
				serverSLs);
		return status;
	}

	public static IDeployStatus createActionPreconditionValid(String validatorID,
			String unboundedMessage, Object[] bindings, Unit unit, List<DeployModelObject> parameters) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createActionStatus(IStatus.INFO,
				validatorID, validatorID, unboundedMessage, bindings, unit, parameters);
		return status;
	}

	public static IDeployStatus createActionPreconditionValid(int severity, String validatorID,
			String unboundedMessage, Object[] bindings, Unit unit, List<DeployModelObject> parameters) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createActionStatus(severity,
				validatorID, validatorID, unboundedMessage, bindings, unit, parameters);
		return status;
	}

	/**
	 * Create a status that indicates that an optional constraint is not present.
	 * 
	 * @param severity
	 *           severity of status message
	 * @param validatorID
	 *           identifier of the validator that identified the problem
	 * @param dmo
	 *           the object on which the constraint is optionally present
	 * @param constraintType
	 *           the type of the constraint
	 * @param was
	 *           the was host
	 * @return the status
	 */
	public static IDeployStatus createMissingConstraint(int severity, String validatorID,
			DeployModelObject dmo, EClass constraintType, Unit was) {

		WasDeployStatus status = new WasDeployStatus(severity, validatorID,
				IWASProblemType.OPTIONAL_CONSTRAINT_NOT_PRESENT,
				WasDomainMessages.Validator_Optional_Constraint_Not_Present_0,
				new Object[] { constraintType.getName() }, dmo);
		status.setAttribute(CONSTRAINT_TYPE, constraintType);
		status.setAttribute(WAS_HOST, was);
		return status;
	}

	/**
	 * Create a status that indicates that too many instances of a given constraint type is present
	 * on an object.
	 * 
	 * @param severity
	 *           severity of the status message
	 * @param validatorID
	 *           identifier of the validator that identified the problem
	 * @param dmo
	 *           the object on which too many constraints are present
	 * @param constraintType
	 *           the type of the constraint
	 * @return the status
	 */
	public static IDeployStatus createTooManyConstraints(int severity, String validatorID,
			DeployModelObject dmo, EClass constraintType) {

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				validatorID, IWASProblemType.TOO_MANY_CONSTRAINTS_PRESENT,
				WasDomainMessages.Validator_Too_Many_Constraints_Present_0,
				new Object[] { constraintType.toString() }, dmo);
		return status;
	}

	/**
	 * Check if an attribute on a particular capability of a unit has a particular value.
	 * 
	 * @param unit
	 *           the unit
	 * @param attribute
	 *           the attribute
	 * @param capability
	 *           the capability on which the attribute is defined
	 * @param expectedValue
	 *           the expected value
	 * @return true if the attribute is defined and equals the expectedValue, false otherwise
	 */
	public static boolean attributeValueEquals(Unit unit, EAttribute attribute, EClass capability,
			Object expectedValue, boolean trueIfUndefined) {
		Object value = CapabilityUtil.getAttributeFromUnitCapability(unit, attribute, capability);
		if (null == value) {
			return trueIfUndefined;
		}

		return expectedValue.equals(value);
	}

}
