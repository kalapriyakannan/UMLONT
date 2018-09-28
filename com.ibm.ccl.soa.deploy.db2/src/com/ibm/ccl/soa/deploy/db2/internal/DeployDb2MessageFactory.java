/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;

/**
 * Factory for generating {@link IDeployStatus} that can be serialized as markers.
 */
public class DeployDb2MessageFactory extends DeployCoreStatusUtil {

	/**
	 * Creates a {@link IDB2ProblemType.ATTRIBUTE_NOT_UNIQUE_AMONG_UNITS_HOSTED_BY_HOST_OF_UNIT}
	 * status.
	 * 
	 * @param unit
	 *           the unit which provides an attribute with a name conflict.
	 * @param c
	 * @param ea
	 * @param value
	 * @return the created status.
	 */
	public static IDeployAttributeStatus UnitWithCapabilityWithSameAttributeValueAlsoHosted(
			Unit unit, Capability c, EAttribute ea, Object value) {
		IDeployAttributeStatus status = DeployCoreStatusUtil
				.createObjectAttributeInvalidStatus(c, ea);
		status
				.setProblemType(IDB2ProblemType.ATTRIBUTE_NOT_UNIQUE_AMONG_UNITS_HOSTED_BY_HOST_OF_UNIT);
		status
				.setUnboundMessage(Db2DomainMessages.Validator_attribute_0_value_1_not_unique_among_units_hosted_by_host_of_unit_2);
		status.setBindings(new String[] { ea.getName(),
				c.getEObject().eGet(ea) == null ? null : c.getEObject().eGet(ea).toString(),
				unit.getName(), });
		return status;
	}

	/**
	 * Creates a {@link IDB2ProblemType.INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER} status.
	 * 
	 * @param unit
	 *           the db2 instance unit that is missing a link to a instance admin user
	 * @param i
	 * @return the created status.
	 */
	public static IDeployStatus instanceMissingLinkToInstanceAdminUser(Unit unit, DB2Instance i) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(unit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR, IDeployCoreValidators.CORE_UNASSIGNED,
				IDB2ProblemType.INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER,
				Db2DomainMessages.Validator_DB2_instance_unit_missing_link_to_instance_admin_user,
				null, unit);
		return status;
	}

	/**
	 * Creates a {@link IDB2ProblemType.INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER} status.
	 * 
	 * @param unit
	 *           the db2 instance unit that is missing a link to a instance admin user which is also
	 *           missing
	 * @return the created status.
	 */
	public static IDeployStatus instanceMissingLinkToMissingInstanceAdminUser(Unit unit) {
		int level;
		if (unit.isConceptual()) {
			level = IStatus.INFO;
		} else if (unit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			level = IStatus.WARNING;
		} else {
			level = IStatus.ERROR;
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(level,
				IDB2ValidatorID.DB2_INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER,
				IDB2ProblemType.INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER,
				Db2DomainMessages.Validator_DB2_instance_unit_0_hosted_on_os_with_no_admin_user,
				new Object[] { unit }, unit);
		return status;
	}

	/**
	 * Creates a status indicating that a DB2DatabaseUnit is hosted on a DB2System instead of on an
	 * instance as expected.
	 * 
	 * @param unit
	 *           the hosted db2 database
	 * @param required
	 *           the required hosting capability not provided.
	 * @param host
	 *           the host that does not provide a matching hosting capability.
	 * @return the created message
	 */
	public static IDeployStatus createUnitDatabaseInstanceMissing(Unit unit, Requirement required,
			Unit host) {
		assert required.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(unit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR, IDeployCoreValidators.CORE_UNASSIGNED,
				IDB2ProblemType.DB2_INSTANCE_UNIT_MISSING,
				Db2DomainMessages.Validator_unit_0_requires_intermediate_host_1_on_2, new Object[] {
						unit.getName(), required, host }, required);
		return status;
	}

	/**
	 * Creates a message indicating that a DB2 system installDir is not valid on the hosting
	 * operating system. This uses a custom resolution.
	 * 
	 * @param cap
	 *           the capability with the installDir EAttribte
	 * @param installDirEAttribute
	 *           the installDir EAttribute
	 * @param osType
	 *           the type of the hosting operating system
	 * @param problemType
	 *           suggested value (valid for operating system)
	 * 
	 * @return the created message
	 */
	public static IDeployAttributeStatus createValidDB2InstallPathExpected(Capability cap,
			EAttribute installDirEAttribute, String osType, String problemType) {
		String installDir = (String) cap.getEObject().eGet(installDirEAttribute);
		assert installDir != null;
		IDeployAttributeStatus status = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(cap,
				installDirEAttribute);
		status.setProblemType(problemType);
		status
				.setUnboundMessage(Db2DomainMessages.Validator_install_dir_0_invalid_on_operating_system_of_type_1);
		status.setBindings(new String[] { installDir, osType });
		return status;
	}

	/**
	 * Creates a message indicating that a DB2 system installDir is not valid on the hosting
	 * operating system
	 * 
	 * @param cap
	 *           the capability with the installDir EAttribte
	 * @param installDirEAttribute
	 *           the installDir EAttribute
	 * @param osType
	 *           the type of the hosting operating system
	 * @param problemType
	 *           problem type string
	 * @param suggestedValue
	 *           suggested value (valid for operating system)
	 * 
	 * @return the created message
	 */
	public static IDeployAttributeStatus createValidDB2InstallPathExpected(Capability cap,
			EAttribute installDirEAttribute, String osType, String problemType, String suggestedValue) {
		String installDir = (String) cap.getEObject().eGet(installDirEAttribute);
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
				problemType, cap, installDirEAttribute, suggestedValue);
		status
				.setUnboundMessage(Db2DomainMessages.Validator_install_dir_0_invalid_on_operating_system_of_type_1);
		status.setBindings(new String[] { installDir, osType });
		return status;
	}
}
