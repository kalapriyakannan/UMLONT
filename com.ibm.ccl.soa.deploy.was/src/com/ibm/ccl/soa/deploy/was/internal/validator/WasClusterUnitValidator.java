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
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * A generic {@link WasClusterUnit} validator which dispatches to other unit validators based on
 * unit version.
 * <p>
 * <table>
 * <tr>
 * <th>
 * <th> Validator
 * <tr>
 * <th> version = 5.*
 * <td> {@link Was5ClusterUnitValidator}
 * <tr>
 * <th> version = 6.*
 * <td> {@link Was6ClusterUnitValidator}
 * <tr>
 * <th> version = other *
 * <td> {@link WasUnknownVersionClusterUnitValidator} </table>
 */
public class WasClusterUnitValidator implements IUnitValidator {

	protected Was5ClusterUnitValidator cluster5;

	protected Was6ClusterUnitValidator cluster6;

	protected WasUnknownVersionClusterUnitValidator unknownCluster;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_CLUSTER_UNIT;
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
		WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(unit,
				WasPackage.eINSTANCE.getWasCluster());
		if (wasClusterCap == null) {
			// Treat as unknown version
			getWasUnknownVersionClusterUnitValidator().validate(unit, context, reporter);
			return;
		}

		UnitValidator validator;
		String version = wasClusterCap.getWasVersion();
		if ((version != null) && (version.startsWith(WasUtil.WAS_5_MAIN_VERSION))) {
			validator = getWas5ClusterUnitValidator();
		} else if ((version != null) && (version.startsWith(WasUtil.WAS_6_MAIN_VERSION))) {
			validator = getWas6ClusterUnitValidator();
		} else {
			validator = getWasUnknownVersionClusterUnitValidator();
		}
		validator.validate(unit, context, reporter);
	}

	public Was5ClusterUnitValidator getWas5ClusterUnitValidator() {
		if (cluster5 == null) {
			cluster5 = new Was5ClusterUnitValidator();
		}
		return cluster5;
	}

	public Was6ClusterUnitValidator getWas6ClusterUnitValidator() {
		if (cluster6 == null) {
			cluster6 = new Was6ClusterUnitValidator();
		}
		return cluster6;
	}

	public WasUnknownVersionClusterUnitValidator getWasUnknownVersionClusterUnitValidator() {
		if (unknownCluster == null) {
			unknownCluster = new WasUnknownVersionClusterUnitValidator();
		}
		return unknownCluster;
	}
}
