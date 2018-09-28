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
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * A generic {@link WasCellUnit} validator which dispatches to other unit validators based on unit
 * attributes.
 * <p>
 * <table>
 * <tr>
 * <th>
 * <th> isDistributed = false
 * <th> isDistributed = true
 * <tr>
 * <th> version = 5.*
 * <td> {@link Was5StandaloneCellUnitValidator}
 * <td> {@link Was5DistributedCellUnitValidator}
 * <tr>
 * <th> version = 6.*
 * <td> {@link Was6StandaloneCellUnitValidator}
 * <td> {@link Was6DistributedCellUnitValidator}
 * <tr>
 * <th> version = other
 * <td> {@link WasUnknownVersionCellUnitValidator}
 * <td> {@link WasUnknownVersionCellUnitValidator} </table>
 */
public class WasCellUnitValidator implements IUnitValidator {

	protected Was5DistributedCellUnitValidator dcell5;

	protected Was6DistributedCellUnitValidator dcell6;

	protected Was5StandaloneCellUnitValidator scell5;

	protected Was6StandaloneCellUnitValidator scell6;

	protected WasUnknownVersionCellUnitValidator unknownCell;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_CELL_UNIT;
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
		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasCell());
		if (wasCellCap == null) {
			// Treat as unknown version/isDistributed
			getWasUnknownVersionCellUnitValidator().validate(unit, context, reporter);
			return;
		}

		checkNumberOfDmgrInBaseSystem((WasCellUnit) unit, reporter);
		checkUnderlyingSystem((WasCellUnit) unit, wasCellCap, reporter);

		UnitValidator validator;
		String version = wasCellCap.getWasVersion();

		if (version != null && version.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			if (wasCellCap.isIsDistributed()) {
				validator = getWas5DistributedCellUnitValidator();
			} else {
				validator = getWas5StandaloneCellUnitValidator();
			}
		} else if (version != null && version.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {

			if (wasCellCap.isIsDistributed()) {
				validator = getWas6DistributedCellUnitValidator();
			} else {
				validator = getWas6StandaloneCellUnitValidator();
			}
		} else {
			validator = getWasUnknownVersionCellUnitValidator();
		}
		validator.validate(unit, context, reporter);
	}

	public Was5DistributedCellUnitValidator getWas5DistributedCellUnitValidator() {
		if (dcell5 == null) {
			dcell5 = new Was5DistributedCellUnitValidator();
		}
		return dcell5;
	}

	public Was6DistributedCellUnitValidator getWas6DistributedCellUnitValidator() {
		if (dcell6 == null) {
			dcell6 = new Was6DistributedCellUnitValidator();
		}
		return dcell6;
	}

	public Was5StandaloneCellUnitValidator getWas5StandaloneCellUnitValidator() {
		if (scell5 == null) {
			scell5 = new Was5StandaloneCellUnitValidator();
		}
		return scell5;
	}

	public Was6StandaloneCellUnitValidator getWas6StandaloneCellUnitValidator() {
		if (scell6 == null) {
			scell6 = new Was6StandaloneCellUnitValidator();
		}
		return scell6;
	}

	public WasUnknownVersionCellUnitValidator getWasUnknownVersionCellUnitValidator() {
		if (unknownCell == null) {
			unknownCell = new WasUnknownVersionCellUnitValidator();
		}
		return unknownCell;
	}

	public void checkNumberOfDmgrInBaseSystem(WasCellUnit cell, IDeployReporter reporter) {
		if (WasUtil.isCellHostedOnBaseSystem(cell) && WasUtil.getDeploymentManager(cell) != null) {
			IDeployStatus message = DeployWasMessageFactory
					.createUnallowedDmgrInACellUnitOnBaseSystemStatus(cell);
			reporter.addStatus(message);
			return;
		}
	}

	private void checkUnderlyingSystem(WasCellUnit unit, WasCell cellCap, IDeployReporter reporter) {
		if (cellCap.isIsDistributed() && WasUtil.isCellHostedOnBaseSystem(unit)) {
			IDeployStatus message = DeployWasMessageFactory
					.createDistributedCellUnitHostedOnBaseSystemStatus(unit);
			reporter.addStatus(message);
			return;
		}

	}
}
