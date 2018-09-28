/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.j2ee;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

public class CrossDomainRequirementTest extends TopologyTestCase {

	public CrossDomainRequirementTest() {
		super("CrossDomainRequirementTest");
	}

	public void testRequirementCapabilityTypeSerialization() throws Exception {
		Topology top = createTopology("testAddRequirementTypeConstraint", true);

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setDmoEType(J2eePackage.eINSTANCE.getJ2CAuthenticationDataEntry());
		unit.getRequirements().add(req);

		top.getEObject().eResource().save(null);

		// Reload the topology
		top = reload(top, true);
		unit = (Unit) top.getUnits().get(0);
		assert unit != null;
		req = (Requirement) unit.getRequirements().get(0);
		assert req != null;
		assert req.getDmoEType().equals(
				J2eePackage.eINSTANCE.getJ2CAuthenticationDataEntry());
	}
}
