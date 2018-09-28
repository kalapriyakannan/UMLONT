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

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInTopologyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.internal.OsDomainInternalMessages;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.server.ServerPackage;

/**
 * Validates {@link OperatingSystemUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * <li> {@link IOsDomainValidators#OPERATING_SYSTEM_UNIT_OS_HOSTNAME_001}
 * </ul>
 */
public class OperatingSystemUnitValidator extends UnitValidator {

	/**
	 * Construct a validator for {@link OperatingSystemUnit} instances.
	 */
	public OperatingSystemUnitValidator() {
		this(OsPackage.eINSTANCE.getOperatingSystemUnit());
	}

	/**
	 * Construct a validator for {@link OperatingSystemUnit} subtypes.
	 * 
	 * @param unitType
	 *           a subtype of {@link OperatingSystemUnit}.
	 */
	protected OperatingSystemUnitValidator(EClass unitType) {
		super(unitType);

		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(OsPackage.Literals.DIRECTORY,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(ServerPackage.eINSTANCE.getServer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IOsDomainValidators.OPERATING_SYSTEM_UNIT_OS_HOSTNAME_001, OsPackage.eINSTANCE
						.getOperatingSystem_Hostname(), IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInTopologyValidator(
				IOsDomainValidators.OPERATING_SYSTEM_UNIT_OS_HOSTNAME_002, OsPackage.eINSTANCE
						.getOperatingSystem_Hostname(), IStatus.WARNING));
		// Validate osType?
		// Validate osVersion?
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		if (unit instanceof OperatingSystemUnit) {
			validateNoPortConflicts((OperatingSystemUnit) unit, context.getTopology()
					.getEditTopology(), null, context, reporter);
			validateIsSoloHosteeOS((OperatingSystemUnit) unit, context, reporter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);
		if (capability instanceof WindowsOperatingSystem) {
			String osType = ((WindowsOperatingSystem) capability).getOsType();
			if (!(osType.equalsIgnoreCase(OperatingSystemType.WINDOWS_CYGWIN_LITERAL.toString()) || osType
					.equalsIgnoreCase(OperatingSystemType.WINDOWS_LITERAL.toString()))) {
				IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, capability,
						OsPackage.Literals.OPERATING_SYSTEM__OS_TYPE);
				status
						.setUnboundMessage(OsDomainInternalMessages.Validator_osType_0_invalid_for_Windows_Operating_System);
				status.setBindings(new Object[] { osType });
				status
						.setValidatorID(IOsDomainValidators.OS_TYPE_INVALID_FOR_WINDOWS_OPERATING_SYSTEM_001);
				reporter.addStatus(status);
			}
		}
		// TODO Linux types
	}

	/**
	 * @param osUnit
	 *           Unit being considered
	 * @param topology
	 *           Topology (which should be the topology represented by the UI)
	 * @param unitToReportErrorsOn
	 *           if null, report errors on every PortConfig with conflicts, otherwise just report
	 *           errors for this unit
	 * @param context
	 * @param reporter *
	 */
	static void validateNoPortConflicts(OperatingSystemUnit osUnit, Topology topology,
			PortConfigUnit unitToReportErrorsOn, IDeployValidationContext context,
			IDeployReporter reporter) {
		Set<Capability> conflictSet = new HashSet<Capability>();
		Map<PortSignature, Capability> signatureMap = new TreeMap<PortSignature, Capability>();
		Set<Unit> visitedSet = new HashSet<Unit>();

		searchForPortConflicts(osUnit, topology, conflictSet, signatureMap, visitedSet, context,
				reporter, 0);
		for (Iterator<Capability> iter = conflictSet.iterator(); iter.hasNext();) {
			Port conflictingPortCap = (Port) iter.next();
			// If unit is in current topology
			if (conflictingPortCap.getEditTopology() == topology) {
				if (unitToReportErrorsOn != null
						&& !unitToReportErrorsOn.getCapabilities().contains(conflictingPortCap)) {
					continue;
				}
				EAttribute eAttribute = OsPackage.eINSTANCE.getPort_Port();
				BigInteger value = (BigInteger) conflictingPortCap.getEObject().eGet(eAttribute);
				IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, conflictingPortCap, eAttribute);
				status
						.setUnboundMessage(OsDomainInternalMessages.Validator_port_0_attribute_1_value_2_conflicts_with_another_port);
				status.setBindings(new Object[] { conflictingPortCap, eAttribute, value });
				status.setValidatorID(IOsDomainValidators.PORT_CONFIG_PORT_CONFLICT_001);

				reporter.addStatus(status);
			}
		}

	}

	/**
	 * @param unit
	 *           Unit being considered
	 * @param topology
	 *           Topology (which should be the topology represented by the UI)
	 * @param conflictSet
	 *           Set of PortConfig units with port conflicts
	 * @param signatureMap
	 *           Map from port "signature" to first instance found of Port with that signature
	 * @param visitedSet
	 *           Units visited so far
	 * @param context
	 * @param reporter
	 */
	private static void searchForPortConflicts(Unit unit, Topology topology,
			Set<Capability> conflictSet, Map<PortSignature, Capability> signatureMap,
			Set<Unit> visitedSet, IDeployValidationContext context, IDeployReporter reporter, int depth) {
//		for (int i = 0; i < depth; ++i) {
//			System.out.print("    ");} //$NON-NLS-1$
//		System.out.print("Visiting " + unit.getName()); //$NON-NLS-1$
		if (visitedSet.contains(unit)) {
//			System.out.println(" - skipping"); //$NON-NLS-1$
			return;
		} else {
//			System.out.println(" - processing"); //$NON-NLS-1$
			// fixme detect cycles for discovered units
			visitedSet.add(unit);
		}
		if (unit instanceof PortConfigUnit) {
			validatePortCapabilities(unit, conflictSet, signatureMap, context, reporter);
		}
		if (cancelled(context)) {
			return;
		}
		List<UnitDescriptor> hosteeUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(
				unit, topology, context.getProgressMonitor());
		for (UnitDescriptor hosteeUnitDescriptor : hosteeUnitDescriptors) {
			if (cancelled(context)) {
				return;
			}
			Unit hosteeUnit = hosteeUnitDescriptor.getUnitValue();
			searchForPortConflicts(hosteeUnit, topology, conflictSet, signatureMap, visitedSet,
					context, reporter, depth + 1);
		}
	}

	/**
	 * @param unit
	 *           Unit being considered
	 * @param conflictSet
	 *           Set of PortConfig units with port conflicts
	 * @param signatureMap
	 *           Map from port "signature" to first instance found of Port with that signature
	 * @param context
	 * @param reporter *
	 */
	private static void validatePortCapabilities(Unit unit, Set<Capability> conflictSet,
			Map<PortSignature, Capability> signatureMap, IDeployValidationContext context,
			IDeployReporter reporter) {
		List<Capability> portCapsList = ValidatorUtils.getCapabilities(unit, OsPackage.Literals.PORT);
		for (Iterator<Capability> iter = portCapsList.iterator(); iter.hasNext();) {
			Port portCap = (Port) iter.next();
			PortSignature portSignature = new PortSignature(portCap);
			//			System.out.println("portSignature=" + portSignature.toString()); //$NON-NLS-1$
			if (signatureMap.containsKey(portSignature)) {
				conflictSet.add(portCap);
				conflictSet.add(signatureMap.get(portSignature));
				//				System.out.println("Conflict: " + portSignature.toString()); //$NON-NLS-1$
			} else {
				signatureMap.put(portSignature, portCap);
			}
		}
	}

	/**
	 * Return true if unit is not solo hosted operating system.
	 * 
	 * @param osUnit
	 *           Should be an OperatingSystemUnit
	 * @param context
	 * @param reporter
	 * @return true if unit is not solo hosted operating system.
	 */
	private boolean isSoloHosteeOS(OperatingSystemUnit osUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// Do not use discovery to find host. If discovery reports that there are two+ operating 
		// systems on one server, then it must be possible, so no need to check the case of 
		// two installed operating systems on the canvas without hosting server. 
		Unit host = ValidatorUtils.getHost(osUnit);
		if (host == null) {
			return true;
		}
		int hostedOperatingSystemsCount = 0;
		List<UnitDescriptor> hosteeUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(
				host, context.getTopology().getEditTopology(), context.getProgressMonitor());
		if (hosteeUnitDescriptors == null) {
			return true;
		}
		for (Iterator<UnitDescriptor> iter = hosteeUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hosteeUD = iter.next();
			if (hosteeUD == null) {
				return true;
			}
			Unit hostee = hosteeUD.getUnitValue();
			if (hostee == null) {
				return true;
			}
			if (hostee instanceof OperatingSystemUnit) {
				++hostedOperatingSystemsCount;
			}
		}
		return hostedOperatingSystemsCount == 1;
	}

	/**
	 * Validate that the unit (operating system unit) is the sole operating system unit hosted by the
	 * hosting server
	 * 
	 * @param unit
	 *           operating system unit
	 * @param context
	 * @param reporter
	 */
	private void validateIsSoloHosteeOS(OperatingSystemUnit osUnit,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (!isSoloHosteeOS(osUnit, context, reporter)) {
			HostingLink hl = ValidatorUtils.getHostingLink(osUnit);
			if (hl != null) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IOsDomainValidators.OPERATING_SYSTEM_0_NOT_SINGLE_HOSTED_BY_HOST,
						ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
						OsDomainMessages.Validator_operating_system_0_not_single_hosted_by_host,
						new String[] { osUnit.getCaptionProvider().title(osUnit) }, hl);
				reporter.addStatus(status);
			}
		}
	}

	private static boolean cancelled(IDeployValidationContext context) {
		if (context == null || context.getProgressMonitor() == null) {
			return false;
		}
		return context.getProgressMonitor().isCanceled();
	}
}
