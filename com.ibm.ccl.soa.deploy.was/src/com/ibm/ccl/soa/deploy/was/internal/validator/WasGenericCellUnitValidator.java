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
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasGenericCellUnitValidator extends UnitValidator {
	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasCellUnit();
	}

	/**
	 * common capabilityType Constraint and RequirementType Cosntrants
	 * 
	 */
	public WasGenericCellUnitValidator() {
		super(WasPackage.eINSTANCE.getWasCellUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasCell(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSharedLibContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSubstitutionVariable(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNode(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_CELL_CELLNAME_EMPTY_001, WasPackage.Literals.WAS_CELL__CELL_NAME,
				IStatus.ERROR));

		//MK 10/07/2006 removed this check.  It is repeated below in call to validateStrictVersionNumberSyntax
		// if we want it here (which makes it was specific) then it should be removed from validateStrictVersionNumberSyntax
		// which means updates elsewhere in the code (all callers).  Another alternative would be to provide a validator
		// id to validateStrictVersionNumberSyntax
		/*
		 * addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
		 * IWasValidatorID.WAS_CELL_WASVERSION_EMPTY_001, WasPackage.Literals.WAS_CELL__WAS_VERSION,
		 * IStatus.ERROR));
		 */
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

		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasCell());
		if (wasCellCap == null) {
			return;
		}

		ValidatorUtils.validateStrictVersionNumberSyntax(wasCellCap,
				WasPackage.Literals.WAS_CELL__WAS_VERSION, reporter);

		Unit host = ValidatorUtils.getHost(unit);
		if (host == null) {
			return;
		}

		assert host instanceof WasNodeUnit;
		WasNodeUnit hostNodeUnit = (WasNodeUnit) host;

		for (Requirement req : ValidatorUtils.findRequirements(hostNodeUnit, WasPackage.eINSTANCE
				.getWasCellUnit(), null)) {
			List groupList = TopologyDiscovererService.INSTANCE.getGroups(hostNodeUnit, req, host
					.getTopology());
			if (groupList == null || groupList.size() <= 0) {
				continue;
			}

			UnitDescriptor wasCellUnitDesc = (UnitDescriptor) groupList.get(0);
			assert wasCellUnitDesc != null;

			Object obj = wasCellUnitDesc.getUnitValue();
			assert obj instanceof WasCellUnit;

			WasCellUnit wasCellunit = (WasCellUnit) obj;
			if (wasCellunit == null) {
				continue;
			}
			if (wasCellunit.equals(unit)) {
				break;
			}

			List linkList = host.getHostingLinks();
			assert linkList != null;
			Iterator links = linkList.iterator();
			while (links.hasNext()) {
				HostingLink link = (HostingLink) links.next();
				if (link.getTarget().equals(unit)) {
					IDeployStatus message = DeployWasMessageFactory
							.createHostingTargetWasNodeInvalidStatus(link);
					reporter.addStatus(message);
					break;
				}
			}
			break;
		}//end of for
	}
}
