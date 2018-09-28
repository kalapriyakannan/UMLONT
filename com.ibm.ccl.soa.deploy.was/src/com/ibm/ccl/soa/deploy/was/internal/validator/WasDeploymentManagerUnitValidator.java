/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link WasDatasourceUnit}
 */
public class WasDeploymentManagerUnitValidator extends UnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasDeploymentManagerUnit();
	}

	/**
	 * 
	 */
	public WasDeploymentManagerUnitValidator() {
		super(WasPackage.eINSTANCE.getWasDeploymentManagerUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasDeploymentManager(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNode(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		//this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(), RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		//the profilType of the WasNode Capability on the WasNodeUnit of which a WasDeploymentManagerUnit is a member must be "dmgr"
		List reqL = ValidatorUtils.getRequirements(unit, WasPackage.eINSTANCE.getWasNodeUnit());
		if (reqL.size() < 1) {
			return;
		}
		Requirement inReq = (Requirement) reqL.get(0); //wasNodeUnit is its only requirment
		List unitDescrList = TopologyDiscovererService.INSTANCE.getGroups(unit, inReq, unit
				.getTopology());
		if (unitDescrList == null) {
			return;
		}
		if (unitDescrList.size() <= 0) {
			return;
		}

		UnitDescriptor nodeUnitDescriptor = (UnitDescriptor) unitDescrList.get(0);
		assert nodeUnitDescriptor.getUnitValue() instanceof WasNodeUnit;
		WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDescriptor.getUnitValue();
		assert nodeUnit != null;

		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap == null) {
			return;
		}

		if (!nodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					IWasValidatorID.VALIDAT_WAS_DMGR_S_CONTAINER_NODE_S_PROFILETYPE, nodeCap,
					WasPackage.Literals.WAS_NODE__PROFILE_TYPE, WasProfileTypeEnum.DMGR_LITERAL);
			reporter.addStatus(message);
		}

		// TODO - the following
//		Validation:
//			(b) validate that all Port capabilities (on hosted PortConfigUnits) have a valid portName (ie, was specific list; use enumeration WasDeploymentManagerPortNames)
//			(c) validate that all Port capabilities (on hosted PortConfigUnits) are unqiue for the WasDeploymentManagerUnit		
	}
}
