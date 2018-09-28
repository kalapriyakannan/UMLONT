/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationConstraintValidator;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validator for instances of {@link ApplicationCommunicationConstraint} that checks for a
 * compatible {@link NetworkCommunicationConstraint} that is applicable to communication between the
 * operating systems hosting the source and target of the {@link ApplicationCommunicationConstraint}.
 */
public class OsApplicationCommunicationConstraintValidator extends
		ApplicationCommunicationConstraintValidator {

	@Override
	protected List<Unit> discoverStack(Unit unit, IProgressMonitor monitor) {
		ArrayList<Unit> hosts = new ArrayList<Unit>();
		while (null != unit) {
			hosts.add(unit);
			unit = ValidatorUtils.discoverHost(unit, monitor);
		}
		return hosts;
	}

	@Override
	protected EClass getExpectedSourceUnitType() {
		return OsPackage.Literals.OPERATING_SYSTEM_UNIT;
	}

	@Override
	protected EClass getExpectedTargetUnitType() {
		return OsPackage.Literals.OPERATING_SYSTEM_UNIT;
	}

	@Override
	protected String getNccContextDescription() {
		return OsDomainMessages.ncc_context_operating_systems;
	}
}
