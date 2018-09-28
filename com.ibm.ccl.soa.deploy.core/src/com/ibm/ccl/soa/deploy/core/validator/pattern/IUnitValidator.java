/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Implemented by unit-level deployment validators.
 * 
 * @see UnitDomainValidator
 */
public interface IUnitValidator {

	/**
	 * Returns the type of unit that this validator can chek.
	 * 
	 * @return the EMF class of the unit type (a subtype of {@link Unit}).
	 */
	public EClass getUnitType();

	/**
	 * Returns an id for the UnitValidator
	 * 
	 * @return a string which is the ID for the UnitValidator.
	 */
	public String getUnitValidatorId();

	/**
	 * Validates the deployment unit, and its contained objects.
	 * <p>
	 * The unit validator is responsible for validating the unit and its contained objects including:
	 * <ul>
	 * <li>{@link Unit#getCapabilities()}
	 * <li>{@link Unit#getRequirements()}
	 * <ul>
	 * <li>{@link Requirement#getExpressions()}
	 * <li>{@link Requirement#getLink()}
	 * </ul>
	 * <li>{@link Unit#getUnitLinks()}
	 * <li>{@link Unit#getArtifacts()}
	 * </ul>
	 * <p>
	 * Implementations are responsible for restricting validation based on the
	 * {@link Unit#getInitInstallState()} and {@link Unit#getPublishIntent()}. For
	 * {@link InstallState#INSTALLED} and {@link PublishIntent#DO_NOT_PUBLISH} units only limited
	 * validation of outgoing hosting and logical should be performed.
	 * 
	 * @param unit
	 *           the unit to be validated.
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	public void validate(Unit unit, IDeployValidationContext context, IDeployReporter reporter);
}
