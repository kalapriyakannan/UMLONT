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

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInGroupValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValueValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasGenericNodeUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasNodeUnit();
	}

	public WasGenericNodeUnitValidator() {
		super(WasPackage.eINSTANCE.getWasNodeUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasNode(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSubstitutionVariable(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSharedLibContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasCellUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1); //InCardinality (1..1)

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_NODE_UNIT_WAS_VERSION_EMPTY_001,
				WasPackage.Literals.WAS_NODE__WAS_VERSION, IStatus.ERROR));

		addAttributeValidator(new ProfileNameAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_EMPTY_001,
				WasPackage.Literals.WAS_NODE__PROFILE_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_NODE_UNIT_PROFILE_NAME_001,
				WasPackage.Literals.WAS_NODE__PROFILE_NAME) {
			public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
				if (!super.appliesTo(object, context)) {
					return false;
				}
				return ((WasNode) object).getProfileType() != WasProfileTypeEnum.NONE_LITERAL;
			}
		});

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_NODE_UNIT_NODE_NAME_EMPTY_001,
				WasPackage.Literals.WAS_NODE__NODE_NAME, IStatus.ERROR));

		//profileLocation not empty, fit for OS
		DeployAttributeValueValidator profileLocationValidator = new DeployAttributeValueValidator(
				IWasValidatorID.WAS_NODE_UNIT_PROFILE_LOCATION_003,
				WasPackage.Literals.WAS_NODE__PROFILE_LOCATION) {
			/*
			 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValueValidator#getExpectedValue(com.ibm.ccl.soa.deploy.core.DeployModelObject,
			 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext)
			 */
			public Object getExpectedValue(DeployModelObject object, IDeployValidationContext context) {
				WasNode wasNode = (WasNode) object;
				WasSystem wasSystem = (WasSystem) ValidatorUtils.discoverHostCapability(wasNode,
						WasPackage.Literals.WAS_SYSTEM, context.getProgressMonitor());
				if (wasSystem == null || wasSystem.getWasHome() == null
						|| wasSystem.getWasHome().length() == 0 || wasNode.getProfileName() == null
						|| wasNode.getProfileName().length() == 0) {
					return null;
				}
				String pathSeparator = OsValidatorUtils.getPathSeparator(wasSystem, wasSystem
						.getWasHome());
				if (pathSeparator == null) {
					return null;
				}
				return wasSystem.getWasHome() + pathSeparator
						+ "profiles" + pathSeparator + wasNode.getProfileName(); //$NON-NLS-1$
			}

			public void validate(DeployModelObject object, IDeployValidationContext context,
					IDeployReporter reporter) {
				// TODO add test here for dangling node (no hosting OS)
				super.validate(object, context, reporter);
			}

			// Hack for Mass Mutual engagement, though it might work permanently
			// If dangling (unhosted) node, member of distributed cell, then do not check profile location - not discoverable
			public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
				if (!super.appliesTo(object, context)) {
					return false;
				}

				DeployModelObject dmo = object;
				while (!(dmo != null && dmo instanceof Unit)) {
					dmo = (DeployModelObject) dmo.eContainer();
				}
				if (dmo != null) {
					Unit host = ValidatorUtils.discoverHost((Unit) dmo, context.getProgressMonitor());
					WasCellUnit cellUnit = (WasCellUnit) ValidatorUtils.discoverGroupByUnitType(
							((Unit) dmo), WasPackage.eINSTANCE.getWasCellUnit(), context
									.getProgressMonitor());
					WasCell cell = null;
					if (cellUnit != null) {
						cell = (WasCell) ValidatorUtils.getCapability(cellUnit, WasPackage.eINSTANCE
								.getWasCell());
					}
					if (object instanceof WasNode
							&& host == null
							&& !((WasNode) object).getProfileType().equals(
									WasProfileTypeEnum.MANAGED_LITERAL) && cell != null
							&& cell.isIsDistributed()) {
						return false;
					}
					return true;
				}
				return false;
			}
		};
		profileLocationValidator.setSeverity(IStatus.WARNING);
		addAttributeValidator(profileLocationValidator);

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_NODE_UNIT_PROFILE_LOCATION_002,
				WasPackage.Literals.WAS_NODE__PROFILE_LOCATION) {
			public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
				if (!super.appliesTo(object, context)) {
					return false;
				}
				return ((WasNode) object).getProfileType() != WasProfileTypeEnum.NONE_LITERAL;
			}
		});

		DeployAttributeInvalidPathnameValidator wasNodeProfileLocationPathValidator = new DeployAttributeInvalidPathnameValidator(
				IWasValidatorID.WAS_NODE_UNIT_PROFILE_LOCATION_INVALID_001,
				WasPackage.Literals.WAS_NODE__PROFILE_LOCATION);

		wasNodeProfileLocationPathValidator.setRequireDriveLetterWindows(true);
		wasNodeProfileLocationPathValidator.setRequireRootedPathUnix(true);
		wasNodeProfileLocationPathValidator.setAllowForwardSlashesWindows(true);
		wasNodeProfileLocationPathValidator.setAllowLeadingDollarChar(true);
		addAttributeValidator(wasNodeProfileLocationPathValidator);

		addAttributeValidator(new CapabilityAttributeUniqueInGroupValidator(
				IWasValidatorID.WAS_NODE_NODE_NAME_UNIQUE_001, WasPackage.Literals.WAS_NODE_UNIT,
				WasPackage.Literals.WAS_NODE__NODE_NAME, WasPackage.Literals.WAS_CELL_UNIT));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.WAS_NODE_UNIT__WAS_VERSION_EQUALS_SYSTEM, WasPackage.eINSTANCE
						.getWasNode_WasVersion(), WasPackage.eINSTANCE.getWasSystem_WasVersion()));
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

		WasNode wasNode = (WasNode) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNode == null) {
			return;
		}

		ValidatorUtils.validateStrictVersionNumberSyntax(wasNode,
				WasPackage.Literals.WAS_NODE__WAS_VERSION, reporter);

		//
		// If node is not a profile, find its corresponding profile, and
		// check that the profile name and location match.
		//
		if (wasNode.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
			WasNode profile = null;
			Unit wasSystemUnit = ValidatorUtils.discoverHost(wasNode, context.getProgressMonitor());
			List peerWasNodeList = ValidatorUtils.discoverHostedCapabilities(wasSystemUnit,
					WasPackage.eINSTANCE.getWasNode(), false, context.getProgressMonitor());
			if (wasNode.getProfileName() != null) {
				// Find profile by name
				for (Iterator iter = peerWasNodeList.iterator(); iter.hasNext();) {
					WasNode curNode = (WasNode) iter.next();
					if (curNode != wasNode
							&& curNode.getProfileType() != WasProfileTypeEnum.NONE_LITERAL
							&& wasNode.getProfileName().equals(curNode.getProfileName())) {
						profile = curNode;
					}
				}
			}
			if (profile == null && wasNode.getProfileLocation() != null) {
				// Find profile by location
				for (Iterator iter = peerWasNodeList.iterator(); iter.hasNext();) {
					WasNode curNode = (WasNode) iter.next();
					if (curNode != wasNode
							&& curNode.getProfileType() != WasProfileTypeEnum.NONE_LITERAL
							&& wasNode.getProfileLocation().equals(curNode.getProfileLocation())) {
						profile = curNode;
					}
				}
			}

			// If no profile found by name or location use an existing one (if unambigious).
			WasSystem wasSystem = (WasSystem) ValidatorUtils.getFirstCapability(wasSystemUnit,
					WasPackage.Literals.WAS_SYSTEM);
			if (wasSystem != null && profile == null) {
				WasNode defaultProfile = null;
				boolean ambigious = false;
				for (Iterator iter = peerWasNodeList.iterator(); iter.hasNext();) {
					WasNode curNode = (WasNode) iter.next();
					if (curNode.getProfileType() != WasProfileTypeEnum.NONE_LITERAL
							&& curNode.getProfileType() != WasProfileTypeEnum.DMGR_LITERAL) {
						if (defaultProfile == null) {
							defaultProfile = curNode;
						} else {
							ambigious = true;
						}
					}
				}
				if (!ambigious) {
					profile = defaultProfile;
				}
			}

			// Validate profile name and location propagation
			if (profile != null) {
				ValidatorUtils.validatePropagation(profile, WasPackage.eINSTANCE
						.getWasNode_ProfileName(), wasNode,
						WasPackage.eINSTANCE.getWasNode_ProfileName(),
						IWasValidatorID.WAS_NODE_PROFILE_NAME_MATCH_001, context, reporter);
				ValidatorUtils.validatePropagation(profile, WasPackage.eINSTANCE
						.getWasNode_ProfileLocation(), wasNode, WasPackage.eINSTANCE
						.getWasNode_ProfileLocation(),
						IWasValidatorID.WAS_NODE_PROFILE_LOCATION_MATCH_001, context, reporter);
				// Check that the unmanaged node is part of the same cell as the profile node
				WasCell profileCell = (WasCell) ValidatorUtils.discoverGroupByCapabilityType(
						(Unit) profile.getParent(), WasPackage.Literals.WAS_CELL, context
								.getProgressMonitor());
				if (profileCell != null) {
					WasCell nodeCell = (WasCell) ValidatorUtils.discoverGroupByCapabilityType(unit,
							WasPackage.Literals.WAS_CELL, context.getProgressMonitor());
					if (nodeCell == null || !nodeCell.equals(profileCell)) {

					}

				}
			}

			// Base systems can only have one webserver unmanaged node per
			// profile.
			if (wasSystem != null && wasSystem.getWasEdition() == WasEditionEnum.BASE_LITERAL) {
				// Find other non-profile nodes
				for (Iterator iter = peerWasNodeList.iterator(); iter.hasNext();) {
					WasNode curNode = (WasNode) iter.next();
					if (curNode != wasNode
							&& curNode.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
						if (ValidatorUtils.equals(curNode.getProfileName(), wasNode.getProfileName())
								|| ValidatorUtils.equals(curNode.getProfileLocation(), wasNode
										.getProfileLocation())) {
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE
									.createDeployStatus(
											IStatus.ERROR,
											IWasValidatorID.WAS_SYSTEM_BASE_PROFILE_CARDINALITY_002,
											IWASProblemType.WAS_BASE_MAY_ONLY_HAVE_ONE_WEBSERVER_NODE,
											WasDomainMessages.Validator_WAS_base_system_0_can_only_host_one_webserver_unmanaged_node,
											new Object[] { wasNode }, wasNode);
							reporter.addStatus(status);
						}

					}
				}

			}
		}
	}

	/**
	 * if the Node is a Dmgr Node: wasNode.wasVersion equals to wasCell.wasVersion, if not, marker
	 * the cell. if the Node is not a Dmgr Node: marker the Node
	 * 
	 * @param wasNodeUnit
	 * @param reporter
	 */
	public static void wasNonDmgrNodeVersionLessThanWasCellVersion(WasNodeUnit wasNodeUnit,
			IDeployReporter reporter) {
		WasCell wasCellCap = WasUtil.getWasCellCap(wasNodeUnit, wasNodeUnit.getEditTopology());
		if (wasCellCap == null) {
			return;
		}
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(wasNodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			return;
		}
		String wasNodeVersion = wasNodeCap.getWasVersion();

		String wasCellVersion = wasCellCap.getWasVersion();
		if (wasCellVersion != null && wasCellVersion.length() > 0 && wasNodeVersion != null
				&& wasNodeVersion.length() > 0) {
			if (WasUtil.compare2VersionString(wasCellVersion, wasNodeVersion) < 0) {
				IDeployStatus message = DeployWasMessageFactory
						.createWasInvalidMemberUnitInGroupUnitStatus(
								wasNodeUnit,
								(Unit) wasCellCap.getParent(),
								IWasValidatorID.WAS_NODE_UNIT_WAS_VERSION_INVALID_001,
								DeployNLS
										.bind(
												WasDomainMessages.Validator_Was_Node_0_Invalid_with_Was_Cell_1_NodewasVersion_2,
												new Object[] { wasNodeCap.getNodeName(),
														wasCellCap.getCellName(), wasNodeCap.getWasVersion() }));
				reporter.addStatus(message);
			}
		}
	}

	private class ProfileNameAttributeStringNotEmptyValidator extends
			DeployAttributeStringNotEmptyValidator {

		/**
		 * Constructs a profile name name validator.
		 * 
		 * @param validatorID
		 *           the validator identifier.
		 * @param attribute
		 *           the attribute validated (must be of type {@link String}).
		 * @param severity
		 */
		public ProfileNameAttributeStringNotEmptyValidator(String validatorID, EAttribute attribute,
				int severity) {
			super(validatorID, attribute, severity);
			assert attribute.getEAttributeType().getInstanceClass().equals(String.class);
		}

		// Hack for Mass Mutual engagement, though it might work permanently		
		// If dangling (unhosted) node, member of distributed cell, then do not check profile location - not discoverable		
		public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
			if (!super.appliesTo(object, context)) {
				return false;
			}

			DeployModelObject dmo = object;
			while (!(dmo != null && dmo instanceof Unit)) {
				dmo = (DeployModelObject) dmo.eContainer();
			}
			if (dmo != null) {
				Unit host = ValidatorUtils.discoverHost((Unit) dmo, context.getProgressMonitor());
				WasCellUnit cellUnit = (WasCellUnit) ValidatorUtils
						.discoverGroupByUnitType(((Unit) dmo), WasPackage.eINSTANCE.getWasCellUnit(),
								context.getProgressMonitor());
				WasCell cell = null;
				if (cellUnit != null) {
					cell = (WasCell) ValidatorUtils.getCapability(cellUnit, WasPackage.eINSTANCE
							.getWasCell());
				}
				if (object instanceof WasNode
						&& host == null
						&& !((WasNode) object).getProfileType()
								.equals(WasProfileTypeEnum.MANAGED_LITERAL) && cell != null
						&& cell.isIsDistributed()) {
					return false;
				}
				return true;
			}
			return false;
		}

	}
}
