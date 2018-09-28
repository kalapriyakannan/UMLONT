/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeNotNullValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.internal.DeployDb2MessageFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;

/**
 * Validates a {link DB2InstanceUnit}.
 */
/**
 * @author barnold
 * 
 */
public class DB2InstanceUnitValidator extends UnitValidator {

	/**
	 * 
	 */
	public DB2InstanceUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2InstanceUnit());
	}

	protected DB2InstanceUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2InstanceUnit().isSuperTypeOf(unitType);

		this.addCapabilityTypeConstraint(Db2Package.Literals.DB2_INSTANCE,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(OsPackage.Literals.PORT_CONSUMER,
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(Db2Package.Literals.DB2_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(OsPackage.Literals.USER,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_USER_NAME_FROM_USER_001,
				Db2Package.Literals.DB2_INSTANCE__USERNAME, OsPackage.Literals.USER__USER_ID));

		// Do not use this propagator - the resolution description displays password
//		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
//				IDB2ValidatorID.DB2_INSTANCE_UNIT_USER_PASSWORD_FROM_USER_001,
//				Db2Package.Literals.DB2_INSTANCE__PASSWORD,
//				OsPackage.Literals.USER__USER_PASSWORD));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_HOSTNAME_EMPTY_001,
				Db2Package.Literals.DB2_INSTANCE__HOSTNAME, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeNotNullValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_PORT_EMPTY_001,
				Db2Package.Literals.DB2_INSTANCE__PORT, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.UNIX_DB2_INSTANCE_UNIT_FENCED_USER_PASSWORD_EMPTY_001,
				Db2Package.Literals.UNIX_DB2_INSTANCE__FENCED_USER_PASSWORD, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.UNIX_DB2_INSTANCE_UNIT_FENCED_USER_NAME_EMPTY_001,
				Db2Package.Literals.UNIX_DB2_INSTANCE__FENCED_USER_NAME, IStatus.ERROR));

		CapabilityAttributeToAttributePropagationValidator hostnameValidator = new CapabilityAttributeToAttributePropagationValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_HOSTNAME_NAME_HOSTING_OS_USER_001,
				Db2Package.Literals.DB2_INSTANCE__HOSTNAME,
				OsPackage.Literals.OPERATING_SYSTEM__HOSTNAME);
		// The OS requirement is on the hosting DB2 system, so we need to
		// configure the validator to go down the hosting stack.
		hostnameValidator.setSearchInHostingStack(true);
		addAttributeValidator(hostnameValidator);

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_INSTANCE_NAME_001,
				Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_PORT_001, Db2Package.Literals.DB2_INSTANCE__PORT));

		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IDB2ValidatorID.DB2_INSTANCE_USER_LINK_NON_LOCAL_001, OsPackage.eINSTANCE.getUser(),
				OsPackage.eINSTANCE.getOperatingSystem(), IStatus.ERROR));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		List<Unit> pcuList = ValidatorUtils.discoverHosted(unit, OsPackage.eINSTANCE
				.getPortConfigUnit(), context.getProgressMonitor());
		// TODO Internal error if > 1 PortConfigUnit?
		if (pcuList.size() > 0) {
			PortConfigUnit pcu = (PortConfigUnit) pcuList.get(0);
			List<Capability> portCapList = ValidatorUtils.getCapabilities(pcu, OsPackage.eINSTANCE
					.getPort());
			for (Iterator<Capability> portCapListIter = portCapList.iterator(); portCapListIter
					.hasNext();) {
				Port portCap = (Port) portCapListIter.next();
				if (portCap.getPortName() == null) {
					IDeployAttributeStatus status = DeployCoreStatusUtil.createAttributeUndefinedStatus(
							IStatus.ERROR, IDB2ValidatorID.DB2_INSTANCE_PORT_CONFIG_PORT_NAME_001,
							portCap, OsPackage.eINSTANCE.getPort_PortName());
					reporter.addStatus(status);
				} else if (DB2InstancePortNames.get(portCap.getPortName()) == null) {
					DeployAttributeStatus status = (DeployAttributeStatus) DeployCoreStatusUtil
							.createAttributeInvalidStatus(IStatus.ERROR,
									IDB2ValidatorID.DB2_INSTANCE_PORT_CONFIG_PORT_NAME_001, portCap,
									OsPackage.eINSTANCE.getPort_PortName());
					EnumerationConstraint c = ConstraintUtil.createEnumerationConstraint(
							"DB2 Instance Port Names", DB2InstancePortNames.VALUES); //$NON-NLS-1$
					status.setConstraints(Collections.singletonList((Constraint) c));
					reporter.addStatus(status);
				}
			}
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);
		if (capability instanceof DB2Instance) {
			validateProvidedDB2Instance(unit, (DB2Instance) capability, reporter, context);
		}
	}

	/**
	 * Validations specific to the DB2 Instance capability
	 * 
	 * @param unit
	 * @param db2Instance
	 * @param reporter
	 * @param context
	 */
	private void validateProvidedDB2Instance(Unit unit, DB2Instance db2Instance,
			IDeployReporter reporter, IDeployValidationContext context) {

		// Propagate port attribute from PortConfig
		propagatePortAttributeFromPortConfig(unit, db2Instance, reporter, context);

		ValidatorUtils.validateStrictVersionNumberSyntax(db2Instance,
				Db2Package.Literals.DB2_BASE_INSTANCE__DB2_VERSION, reporter);
		// db2InstanceName validity rules appear to be same as database name
		// rules.
		if (db2Instance.getDb2InstanceName() == null
				|| db2Instance.getDb2InstanceName().length() == 0) {
			reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(db2Instance,
					Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME));
		} else {
			DB2ValidatorUtils.validateDB2GenericName(db2Instance.getDb2InstanceName(), db2Instance,
					Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME, reporter);
		}

		OperatingSystem os = (OperatingSystem) DeployValidatorUtils
				.findProvidedCapabilityInHostingStack(OsPackage.Literals.OPERATING_SYSTEM, unit);

		if (DB2ValidatorUtils.useridPasswordHostnameFixesAvailable(unit, os).size() > 0) {
			reporter.addStatus(DeployDb2MessageFactory.instanceMissingLinkToInstanceAdminUser(unit,
					db2Instance));
//			return;
		}

		validatePassword(unit, db2Instance, reporter, context);

		if (DB2ValidatorUtils.hostingOSNoDB2InstanceAdminUser(unit, os, false)) {
			reporter.addStatus(DeployDb2MessageFactory
					.instanceMissingLinkToMissingInstanceAdminUser(unit));
		}

		if (os != null) {
			String osType = os.getOsType();
			if (osType != null && db2Instance instanceof WindowsDB2Instance) {
				if (!OsValidatorUtils.isWindowsOsType(osType)) {
					// TODO type specialization resolution
					// error
				}
			} else if (osType != null && db2Instance instanceof UnixDB2Instance) {
				if (!OsValidatorUtils.isUnixOsType(osType)) {
					// TODO type specialization resolution
					// error
				}
			}
		}

		if (!db2Instance.isSetAutoStart()) {
			IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
					db2Instance, Db2Package.Literals.DB2_INSTANCE__AUTO_START);
			reporter.addStatus(status);
		}

		if (db2Instance instanceof WindowsDB2Instance) {
			WindowsDB2Instance windowsDB2Instance = (WindowsDB2Instance) db2Instance;
			if (!windowsDB2Instance.isSetDefaultInstance()) {
				IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
						windowsDB2Instance, Db2Package.Literals.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE);
				reporter.addStatus(status);
			}
			if (windowsDB2Instance.getInstanceType() == null) {
				IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
						windowsDB2Instance, Db2Package.Literals.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE);
				reporter.addStatus(status);
			} else if (!(windowsDB2Instance.getInstanceType().equals(
					WindowsInstanceTypeType.ESE_LITERAL) || windowsDB2Instance.getInstanceType().equals(
					WindowsInstanceTypeType.WSE_LITERAL))) {
				IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						windowsDB2Instance, Db2Package.Literals.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE);
				reporter.addStatus(status);
			}
		}

		if (db2Instance instanceof UnixDB2Instance) {
			// fencedGID valid
			// fencedGroupName valid
			// gID valid
			// groupName
			// uID valid
			UnixDB2Instance unixDB2Instance = (UnixDB2Instance) db2Instance;
			if (unixDB2Instance.getInstanceType() == null) {
				IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
						unixDB2Instance, Db2Package.Literals.UNIX_DB2_INSTANCE__INSTANCE_TYPE);
				reporter.addStatus(status);
			} else if (!(unixDB2Instance.getInstanceType().equals(UnixInstanceTypeType.ESE_LITERAL) || unixDB2Instance
					.getInstanceType().equals(UnixInstanceTypeType.WSE_LITERAL))) {
				IDeployStatus status = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						unixDB2Instance, Db2Package.Literals.UNIX_DB2_INSTANCE__INSTANCE_TYPE);
				reporter.addStatus(status);
			}
		}
	}

	/**
	 * @param unit
	 * @param db2Instance
	 * @param reporter
	 * @param context
	 */
	private void propagatePortAttributeFromPortConfig(Unit unit, DB2Instance db2Instance,
			IDeployReporter reporter, IDeployValidationContext context) {
		BigInteger port = db2Instance.getPort();
		assert unit instanceof DB2InstanceUnit;
		List<UnitDescriptor> db2InstanceHostedUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(unit, unit.getTopology(), context.getProgressMonitor());
		for (UnitDescriptor hostedUD : db2InstanceHostedUnitDescriptors) {
			Unit hosted = hostedUD.getUnitValue();
			if (hosted instanceof PortConfigUnit) {
				for (Iterator<Capability> innerIter = ValidatorUtils.findCapabilities(hosted,
						OsPackage.eINSTANCE.getPort()).iterator(); innerIter.hasNext();) {
					Port portCap = (Port) innerIter.next();
					if (portCap.getPortName() == null
							|| !portCap.getPortName().equals(
									DB2InstancePortNames.INSTANCE_CONNECTION_PORT_LITERAL.getName())) {
						continue;
					}
					if (portCap.getPort() == null) {
						if (port == null) {
							// PortConfiguration.port Undefined
							IDeployAttributeStatus status = DeployCoreStatusUtil
									.createAttributeUndefinedStatus(IStatus.ERROR,
											IDB2ValidatorID.DB2_INSTANCE_PORT_VALUE_001, portCap,
											OsPackage.eINSTANCE.getPort_Port());
							reporter.addStatus(status);
						} else {
							// PortConfiguration.port Invalid (should be = port)
							IDeployAttributeValueStatus status = DeployCoreStatusUtil
									.createAttributeInvalidStatus(IStatus.ERROR,
											IDB2ValidatorID.DB2_INSTANCE_PORT_VALUE_001, portCap,
											OsPackage.eINSTANCE.getPort_Port(), port);
							reporter.addStatus(status);
						}
					} else {
						// portCap.getPort() != null
						// Propagate to port
						if (port == null || !port.equals(portCap.getPort())) {
							IDeployAttributeValueStatus status = DeployCoreStatusUtil
									.createAttributeInvalidStatus(IStatus.ERROR,
											IDB2ValidatorID.DB2_INSTANCE_PORT_VALUE_001, db2Instance,
											Db2Package.eINSTANCE.getDB2Instance_Port(), portCap.getPort());
							reporter.addStatus(status);
						}
					}
				}
			}
		}
	}

	/**
	 * Validate password equal to linked operating system user password
	 * 
	 * @param unit
	 * @param db2Instance
	 * @param reporter
	 * @param context
	 */
	private void validatePassword(Unit unit, DB2Instance db2Instance, IDeployReporter reporter,
			IDeployValidationContext context) {
		if (db2Instance == null || unit == null) {
			return;
		}
		String instPassword = db2Instance.getPassword();
		Requirement userReq = DB2ValidatorUtils.getFirstRequirementOfType(unit.getRequirements(),
				OsPackage.eINSTANCE.getUser());
		if (userReq == null) {
			return;
		}
		Capability userReqTarget = ValidatorUtils.discoverDependencyLinkTarget(userReq, context
				.getProgressMonitor());
		if (!(userReqTarget instanceof User)) {
			return;
		}
		User userCap = (User) userReqTarget;
		if (userCap.getUserPassword() != null) {
			if (instPassword == null || instPassword != null
					&& !instPassword.equals(userCap.getUserPassword())) {
				IDeployAttributeValueSourceStatus status = DeployCoreStatusUtil
						.createAttributeInvalidSourceValueStatus(IStatus.ERROR,
								IDB2ValidatorID.DB2_INSTANCE_UNIT_USER_PASSWORD_FROM_USER_001, db2Instance,
								Db2Package.eINSTANCE.getDB2Instance_Password(), userCap,
								OsPackage.Literals.USER__USER_PASSWORD);
				reporter.addStatus(status);
			}
		}
	}
}
