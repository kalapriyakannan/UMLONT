/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * A generic {@link WasNodeUnit} validator which dispatches to other unit validators based on unit
 * attributes.
 * <p>
 * <table>
 * <tr>
 * <th>
 * <th> profileType = DMGR
 * <th> profileType != DMGR
 * <tr>
 * <th> version = 5.*
 * <td> {@link Was5DmgrNodeUnitValidator}
 * <td> {@link Was5NonDmgrNodeUnitValidator}
 * <tr>
 * <th> version = 6.*
 * <td> {@link Was6DmgrNodeUnitValidator}
 * <td> {@link Was6NonDmgrNodeUnitValidator}
 * <tr>
 * <th> version = other
 * <td> {@link WasUnknownVersionNodeUnitValidator}
 * <td> {@link WasUnknownVersionNodeUnitValidator} </table>
 */
public class WasNodeUnitValidator implements IUnitValidator {

	protected Was5DmgrNodeUnitValidator dmgr5;

	protected Was6DmgrNodeUnitValidator dmgr6;

	protected Was5NonDmgrNodeUnitValidator nonDmgr5;

	protected Was6NonDmgrNodeUnitValidator nonDmgr6;

	protected WasUnknownVersionNodeUnitValidator unknownNode;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_NODE_UNIT;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitValidatorId()
	 */
	public String getUnitValidatorId() {
		return getClass().getName();
	}

	/**
	 * Delegates validation based on {@link WasCell#isIsDistributed()} and
	 * {@link WasCell#getWasVersion()}.
	 * 
	 * 
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			// Treat as unknown version/node profile type
			getWasUnknownVersionNodeUnitValidator().validate(unit, context, reporter);
			return;
		}
		UnitValidator validator;

		String version = wasNodeCap.getWasVersion();
		WasProfileTypeEnum type = wasNodeCap.getProfileType();
		if (version != null && version.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			if (type == WasProfileTypeEnum.DMGR_LITERAL) {
				validator = getWas5DmgrNodeUnitValidator();
			} else {
				validator = getWas5NonDmgrNodeUnitValidator();
			}
		} else if (version != null && version.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			if (type == WasProfileTypeEnum.DMGR_LITERAL) {
				validator = getWas6DmgrNodeUnitValidator();
			} else {
				validator = getWas6NonDmgrNodeUnitValidator();
			}
		} else {
			validator = getWasUnknownVersionNodeUnitValidator();
		}
		validator.validate(unit, context, reporter);
	}

	public Was5DmgrNodeUnitValidator getWas5DmgrNodeUnitValidator() {
		if (dmgr5 == null) {
			dmgr5 = new Was5DmgrNodeUnitValidator();
		}
		return dmgr5;
	}

	public Was6DmgrNodeUnitValidator getWas6DmgrNodeUnitValidator() {
		if (dmgr6 == null) {
			dmgr6 = new Was6DmgrNodeUnitValidator();
		}
		return dmgr6;
	}

	public Was5NonDmgrNodeUnitValidator getWas5NonDmgrNodeUnitValidator() {
		if (nonDmgr5 == null) {
			nonDmgr5 = new Was5NonDmgrNodeUnitValidator();
		}
		return nonDmgr5;
	}

	public Was6NonDmgrNodeUnitValidator getWas6NonDmgrNodeUnitValidator() {
		if (nonDmgr6 == null) {
			nonDmgr6 = new Was6NonDmgrNodeUnitValidator();
		}
		return nonDmgr6;
	}

	public WasUnknownVersionNodeUnitValidator getWasUnknownVersionNodeUnitValidator() {
		if (unknownNode == null) {
			unknownNode = new WasUnknownVersionNodeUnitValidator();
		}
		return unknownNode;
	}
}
