/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.constraints;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeCapacityStatus;
import com.ibm.ccl.soa.deploy.server.IServerTemplateConstants;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.tomcat.ITomcatTemplateConstants;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * Tests conceptual node communication paths against application nodes.
 */
public class CapacityConstraintValidatorTest extends TopologyTestCase {

	private static final String MEMORY_SIZE = "memorySize";

	private static final String PROJECT_NAME = "CapacityConstraintValidatorTest"; //$NON-NLS-1$

	/** Shared validator instance. */
	private DeployValidatorService service;

	public CapacityConstraintValidatorTest() {
		super(PROJECT_NAME);
		service = new DeployValidatorService();
	}

	public void testMemoryCapacity() throws IOException, CoreException {
		Collection<IStatus> statuses = null;
		final Topology top = createTopology("empty topology", true); //$NON-NLS-1$

		final TomcatWebServerUnit tomcat1 = createConstraintTomcat(top, "256",
				false);

		service.validate(top);

		// we should have 0 statuses at this point
		for (Iterator allUnits = top.findAllUnits(); allUnits.hasNext();) {
			Unit u = (Unit) allUnits.next();
			statuses = DeployCoreStatusUtil.findMatchingStatuses(
					ICoreProblemType.CAPACITY_RESTRICTION, u.getStatus());
			assertEquals(0, statuses.size());
		}

		final ServerUnit x86server1 = createConceptualServer(top);
		ResolutionUtils.host(x86server1, tomcat1);

		service.validate(top);

		for (Iterator allUnits = top.findAllUnits(); allUnits.hasNext();) {
			Unit u = (Unit) allUnits.next();
			if (u != x86server1) {
				statuses = DeployCoreStatusUtil.findMatchingStatuses(
						ICoreProblemType.CAPACITY_RESTRICTION, u.getStatus());
				assertEquals(0, statuses.size());
			}
		}

		DeployCoreStatusUtil.findMatchingStatuses(
				ICoreProblemType.CAPACITY_RESTRICTION, x86server1.getStatus());

		assertEquals(1, statuses.size());

		IStatus[] status = statuses.toArray(new IStatus[1]);
		assertTrue(status[0] instanceof DeployAttributeCapacityStatus);

		DeployAttributeCapacityStatus capacityStatus = (DeployAttributeCapacityStatus) status[0];
		assertEquals(MEMORY_SIZE, capacityStatus.getAttributeName());
		assertEquals(true, capacityStatus.getRestriction().isExclusive());

		// the attribute should be unset at this time, so it shouldn't be exceeded.
		statuses = DeployCoreStatusUtil.findMatchingStatuses(
				ICoreProblemType.CAPACITY_EXCEEDED, x86server1.getStatus());
		assertEquals(0, statuses.size());

	}

	private ServerUnit createConceptualServer(final Topology top) {
		final ServerUnit x86server1 = (ServerUnit) ResolutionUtils
				.createFromTemplate(
						IServerTemplateConstants.SERVER_INTEL_X86_UNIT_CONCEPTUAL,
						top);
		UnitUtil.assignUniqueName(x86server1);

		Server serverCapability = (Server) ValidatorUtils.getCapability(
				x86server1, ServerPackage.Literals.SERVER);

		if (serverCapability.eIsSet(ServerPackage.Literals.SERVER__MEMORY_SIZE)) {
			serverCapability.eUnset(ServerPackage.Literals.SERVER__MEMORY_SIZE);
		}
		return x86server1;
	}

	private TomcatWebServerUnit createConstraintTomcat(final Topology top,
			String value, boolean exclusive) {
		final TomcatWebServerUnit tomcat1 = (TomcatWebServerUnit) ResolutionUtils
				.createFromTemplate(
						ITomcatTemplateConstants.TOMCAT_50_UNIT_CONCEPTUAL, top);

		CapacityConstraint serverConstraint1 = ConstraintFactory.eINSTANCE
				.createCapacityConstraint();
		serverConstraint1.setDmoEType(ServerPackage.Literals.SERVER);

		AttributeCapacityConstraint memoryConstraint1 = ConstraintFactory.eINSTANCE
				.createAttributeCapacityConstraint();
		memoryConstraint1.setAttributeName(MEMORY_SIZE);
		memoryConstraint1.setValue(value);
		memoryConstraint1.setExclusive(exclusive); 

		serverConstraint1.getConstraints().add(memoryConstraint1);
		tomcat1.getConstraints().add(serverConstraint1);
		
		UnitUtil.assignUniqueName(tomcat1);
		UnitUtil.assignUniqueName(serverConstraint1);
		UnitUtil.assignUniqueName(memoryConstraint1);
		return tomcat1;
	}
}
