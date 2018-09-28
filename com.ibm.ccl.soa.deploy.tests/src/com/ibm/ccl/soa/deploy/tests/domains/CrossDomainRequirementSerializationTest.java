/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;

/**
 * Tests the serialization of {@link Requirement#getDmoType()} when the domain
 * of the type is not referenced by any other means in the topology.
 */
public class CrossDomainRequirementSerializationTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CrossDomainRequirementSerializationTest";

	public CrossDomainRequirementSerializationTest() {
		super(PROJECT_NAME);
	}

	/**
	 * Test the sequence of setting the
	 * {@link Requirement#setDmoEType(org.eclipse.emf.ecore.EClass)} of a
	 * {@link WasSystemUnit} to the capability type {@link OperatingSystem}
	 * (cross-domain).
	 * <p>
	 * <ol>
	 * <li> Create Topology
	 * <li> Create Unit
	 * <li> Add Unit to Topology
	 * <li> Create Requirement
	 * <li> Add Requirement to Unit
	 * <li> Set Requirement dmoEType (the
	 * {@link Requirement#setDmoEType(org.eclipse.emf.ecore.EClass)} method will
	 * update the XMLNS prefixes of the topology}).
	 * <li> Test serialization/deserialization
	 * </ol>
	 * 
	 * @throws Exception
	 */
	public void testSetDmoEType() throws Exception {
		Topology top = createTopology("testCrossDomainCapabilityTypeSerialization");

		WasSystemUnit was = WasFactory.eINSTANCE.createWasSystemUnit();
		was.setName("was");
		top.getUnits().add(was);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		was.getRequirements().add(req);

		// Should also update the XMLNS prefixes of the topology
		req.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());

		// Test serialization/deserialization
		top = reload(top, true);
		String errors = dumpStatus(top);
		assert errors.length() == 0 : errors;
		was = (WasSystemUnit) top.getUnits().get(0);
		assert was != null : dumpStatus(top);
		req = (Requirement) was.getRequirements().get(0);
		assert req != null : dumpStatus(top);
		assert OsPackage.eINSTANCE.getOperatingSystem().equals(
				req.getDmoEType());
	}

	/**
	 * Test the sequence of setting the
	 * {@link Requirement#setDmoEType(org.eclipse.emf.ecore.EClass)} of a
	 * {@link WasSystemUnit} to the capability type {@link OperatingSystem}
	 * (cross-domain).
	 * <p>
	 * <ol>
	 * <li> Create Topology
	 * <li> Create Unit
	 * <li> Add Unit to Topology
	 * <li> Create Requirement
	 * <li> Set Requirement dmoEType
	 * <li> Add Requirement to Unit ({@list RequirementListAdapter} updates the
	 * XMLNS prefix)
	 * <li> Test serialization/deserialization
	 * </ol>
	 * 
	 * @throws Exception
	 */
	public void testRequirementListAdapter() throws Exception {
		Topology top = createTopology("testCrossDomainCapabilityTypeSerialization");

		WasSystemUnit was = WasFactory.eINSTANCE.createWasSystemUnit();
		was.setName("was");
		top.getUnits().add(was);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		req.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());

		// Requirement list adapter should now set the XMLNS prefix
		was.getRequirements().add(req);

		// Test serialization/deserialization
		top = reload(top, true);
		String errors = dumpStatus(top);
		assert errors.length() == 0 : errors;
		was = (WasSystemUnit) top.getUnits().get(0);
		assert was != null : dumpStatus(top);
		req = (Requirement) was.getRequirements().get(0);
		assert req != null : dumpStatus(top);
		assert OsPackage.eINSTANCE.getOperatingSystem().equals(
				req.getDmoEType());
	}

	/**
	 * Test the sequence of setting the
	 * {@link Requirement#setDmoEType(org.eclipse.emf.ecore.EClass)} of a
	 * {@link WasSystemUnit} to the capability type {@link OperatingSystem}
	 * (cross-domain).
	 * <p>
	 * <ol>
	 * <li> Create Topology
	 * <li> Create Unit
	 * <li> Create Requirement
	 * <li> Set Requirement dmoEType
	 * <li> Add Requirement to Unit
	 * <li> Add Unit to Topology ({@list UnitListAdapter} updates the XMLNS
	 * prefix)
	 * <li> Test serialization/deserialization
	 * </ol>
	 * 
	 * @throws Exception
	 */
	public void testUnitListAdapter() throws Exception {
		Topology top = createTopology("testCrossDomainCapabilityTypeSerialization");

		WasSystemUnit was = WasFactory.eINSTANCE.createWasSystemUnit();
		was.setName("was");

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		req.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
		was.getRequirements().add(req);

		// Unit list adapter should now set the XMLNS prefix
		top.getUnits().add(was);

		// Test serialization/deserialization
		top = reload(top, true);
		String errors = dumpStatus(top);
		assert errors.length() == 0 : errors;
		was = (WasSystemUnit) top.getUnits().get(0);
		assert was != null : dumpStatus(top);
		req = (Requirement) was.getRequirements().get(0);
		assert req != null : dumpStatus(top);
		assert OsPackage.eINSTANCE.getOperatingSystem().equals(
				req.getDmoEType());
	}
}
