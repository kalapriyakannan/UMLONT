/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher;

import java.io.IOException;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

public class LinkDescriptorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "RealizationLinkApiTest";

	public LinkDescriptorTest() {
		super(PROJECT_NAME);
	}

	public LinkDescriptorTest(String name) {
		super(name);
	}

	public void testLinkDescriptor() throws IOException {
		Topology top = createTopology("testLinkDescriptor");

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);

		Requirement req1 = CoreFactory.eINSTANCE.createRequirement();
		req1.setName("req1");
		unit1.getRequirements().add(req1);

		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		unit2.getCapabilities().add(cap2);

		assert req1.getLink() == null;
		assert unit1.getHostingLinks().size() == 0;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getConstraintLinks().size() == 0;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getUnitLinks().size() == 0;
		assert unit2.getUnitLinks().size() == 0;
		assert unit1.getRequirements().size() == 1;
		assert unit2.getCapabilities().size() == 1;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { req1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] {});

		//
		// DEPENDENCY LINK CREATION
		//

		LinkDescriptor d = new LinkDescriptor(LinkType.DEPENDENCY, unit1, req1,
				unit2, cap2);
		DeployModelObject dLink = d.create();
// System.out.println("dLink name:" + dLink.getName());
// System.out.println("dLink path:" + dLink.getFullPath());

		assert dLink.getEObject().eClass().equals(
				CorePackage.Literals.DEPENDENCY_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 0;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getConstraintLinks().size() == 0;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getUnitLinks().size() == 0;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { req1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		//
		// HOSTING LINK CREATION
		//

		d = new LinkDescriptor(LinkType.HOSTING, unit1, unit2);
		DeployModelObject hLink = d.create();
// System.out.println("hLink name:" + hLink.getName());
// System.out.println("hLink path:" + hLink.getFullPath());

		assert hLink.getEObject().eClass().equals(
				CorePackage.Literals.HOSTING_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 0;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getUnitLinks().size() == 1;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		//
		// LOGICAL LINK CREATION
		//

		d = new LinkDescriptor(LinkType.CONSTRAINT, unit1, (Requirement) null,
				unit2, null);
		DeployModelObject lLink1 = d.create();
// System.out.println("lLink1 name:" + lLink1.getName());
// System.out.println("lLink1 path:" + lLink1.getFullPath());

		assert lLink1.getEObject().eClass().equals(
				CorePackage.Literals.CONSTRAINT_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 1;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(lLink1);
		assert unit1.getUnitLinks().size() == 1;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		// TODO when logical links are added to this list uncomment this
		// assert unit1.getContainedModelObjects().get(1).equals(lLink1);
		assert unit2.getContainedModelObjects().size() == 1;

		d = new LinkDescriptor(LinkType.CONSTRAINT, unit1, req1, unit2, null);
		DeployModelObject lLink2 = d.create();
// System.out.println("lLink2 name:" + lLink2.getName());
// System.out.println("lLink2 path:" + lLink2.getFullPath());

		assert lLink2.getEObject().eClass().equals(
				CorePackage.Literals.CONSTRAINT_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 2;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(lLink1);
		assert unit1.getConstraintLinks().get(1).equals(lLink2);
		assert unit1.getUnitLinks().size() == 1;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2 });
		assert unit2.getContainedModelObjects().size() == 1;

		d = new LinkDescriptor(LinkType.CONSTRAINT, unit1, req1, unit2, cap2);
		DeployModelObject lLink3 = d.create();
// System.out.println("lLink3 name:" + lLink3.getName());
// System.out.println("lLink3 path:" + lLink3.getFullPath());

		assert lLink3.getEObject().eClass().equals(
				CorePackage.Literals.CONSTRAINT_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 3;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(lLink1);
		assert unit1.getConstraintLinks().get(1).equals(lLink2);
		assert unit1.getConstraintLinks().get(2).equals(lLink3);
		assert unit1.getUnitLinks().size() == 1;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		d = new LinkDescriptor(LinkType.CONSTRAINT, unit1, (Requirement) null,
				unit2, cap2);
		DeployModelObject lLink4 = d.create();
// System.out.println("lLink4 name:" + lLink4.getName());
// System.out.println("lLink4 path:" + lLink4.getFullPath());

		assert lLink4.getEObject().eClass().equals(
				CorePackage.Literals.CONSTRAINT_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 4;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(lLink1);
		assert unit1.getConstraintLinks().get(1).equals(lLink2);
		assert unit1.getConstraintLinks().get(2).equals(lLink3);
		assert unit1.getConstraintLinks().get(3).equals(lLink4);
		assert unit1.getUnitLinks().size() == 1;
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		//
		// MEMBER LINK CREATION
		//

		d = new LinkDescriptor(LinkType.MEMBER, unit1, unit2);
		DeployModelObject cLink = d.create();
// System.out.println("cLink name:" + cLink.getName());
// System.out.println("cLink path:" + cLink.getFullPath());

		assert cLink.getEObject().eClass().equals(
				CorePackage.Literals.MEMBER_LINK);
		assert req1.getLink() != null;
		assert req1.getLink() == dLink;
		assert unit1.getHostingLinks().size() == 1;
		assert unit2.getHostingLinks().size() == 0;
		assert unit1.getHostingLinks().get(0).equals(hLink);
		assert unit1.getConstraintLinks().size() == 4;
		assert unit2.getConstraintLinks().size() == 0;
		assert unit1.getConstraintLinks().get(0).equals(lLink1);
		assert unit1.getConstraintLinks().get(1).equals(lLink2);
		assert unit1.getConstraintLinks().get(2).equals(lLink3);
		assert unit1.getConstraintLinks().get(3).equals(lLink4);
		assert unit1.getMemberLinks().size() == 1;
		assert unit1.getMemberLinks().get(0).equals(cLink);
		assert unit1.getUnitLinks().size() == 2; // hosting and member links
		assert unit2.getUnitLinks().size() == 0;
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		//
		// REALIZATION LINK CREATION
		//

		d = new LinkDescriptor(LinkType.REALIZATION, unit1, unit2);// , top);
// RealizationContext context = new RealizationContext (top);

		DeployModelObject rLink1 = d.create();
// System.out.println("rLink name:" + rLink1.getName());
// System.out.println("rLink path:" + rLink1.getFullPath());

		// TODO asserts
		assert top.getRealizationLinks().size() == 1;
		assert RealizationLinkUtil.getRealizations(unit1)[0].equals(unit2); // ,
																		// context).equals(unit2);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink });
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2, rLink1 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		Capability cap1 = CoreFactory.eINSTANCE.createCapability();
		cap1.setName("cap1");
		unit1.getCapabilities().add(cap1);

		d = new LinkDescriptor(LinkType.REALIZATION, cap1, cap2); // , top);
		DeployModelObject rLink2 = d.create();
// System.out.println("rLink name:" + rLink2.getName());
// System.out.println("rLink path:" + rLink2.getFullPath());

		// TODO assert statements
		assert top.getRealizationLinks().size() == 2;
		assert RealizationLinkUtil.getRealizations(cap1)[0].equals(cap2); // ,
																		// context).equals(cap2);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink, cap1 });
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2, rLink1, rLink2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink, cap1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });

		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setName("req2");
		unit2.getRequirements().add(req2);

		d = new LinkDescriptor(LinkType.REALIZATION, req1, req2); // , top);
		DeployModelObject rLink3 = d.create();
// System.out.println("rLink name:" + rLink3.getName());
// System.out.println("rLink path:" + rLink3.getFullPath());

		// TODO assert statements
		assert top.getRealizationLinks().size() == 3;
		assert RealizationLinkUtil.getRealizations(req1)[0].equals(req2); // ,
																		// context).equals(req2);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2, rLink1, rLink2, rLink3 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { hLink,
				req1, lLink1, lLink2, lLink3, lLink4, cLink, cap1 });
		assertSetEquals(unit2.getContainedModelObjects(), new Object[] { cap2,
				req2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { dLink });
	}
}
