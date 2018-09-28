/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationConstraintValidator;

/**
 * Validator for instances of {@link ApplicationCommunicationConstraint} that checks for a
 * compatible {@link NetworkCommunicationConstraint} that is applicable to communication between the
 * operating systems hosting the source and target of the {@link ApplicationCommunicationConstraint}.
 */
public class LocationApplicationCommunicationConstraintValidator extends
		ApplicationCommunicationConstraintValidator {
	
	private static EClass nodeUnitType = AnalysisPackage.Literals.NODE_UNIT;
	private static EClass locationUnitType = AnalysisPackage.Literals.LOCATION_UNIT;

	@Override
	protected List<Unit> discoverStack(Unit unit, IProgressMonitor monitor) {
		ArrayList<Unit> hosts = new ArrayList<Unit>();
		while (null != unit) {
			hosts.add(unit);
			if (null != unit && nodeUnitType.isSuperTypeOf(unit.getEObject().eClass())) {
				break;
			}
			unit = ValidatorUtils.discoverHost(unit, monitor);
		}
		if (null != unit && nodeUnitType.isSuperTypeOf(unit.getEObject().eClass())) {
			List<Unit> locations = ValidatorUtils.discoverGroupsByUnitType(unit, locationUnitType, unit.getEditTopology(), monitor);
			for (Unit location : locations) {
				hosts.add(location);
			}
		}
		
		return hosts;
	}

	@Override
	protected EClass getExpectedSourceUnitType() {
		return locationUnitType;
	}

	@Override
	protected EClass getExpectedTargetUnitType() {
		return locationUnitType;
	}

	@Override
	protected String getNccContextDescription() {
		return AnalysisMessages.LOCATION_APPLICATION_COMMUNICATION_CONTEXT;
	}
}
