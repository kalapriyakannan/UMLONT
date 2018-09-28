/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

public class ContainedObjectTest extends TopologyTestCase {

	public ContainedObjectTest() {
		super("DmoPathTest");
	}

	protected void createAnnotation(DeployModelObject obj) {
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext("test");
		obj.getAnnotations().add(annotation);
	}

	public void testPaths() throws Exception {
		Topology top = createTopology("testPaths");
		createAnnotation(top);
		assert top.getContainedModelObjects().size() == 0;

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1 });
		assert unit1.getContainedModelObjects().size() == 0;

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });

		Capability cap1 = CoreFactory.eINSTANCE.createCapability();
		cap1.setName("cap1");
		unit1.getCapabilities().add(cap1);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1 });
		assert cap1.getContainedModelObjects().size() == 0;

		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		unit1.getCapabilities().add(cap2);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2 });

		Requirement req1 = CoreFactory.eINSTANCE.createRequirement();
		req1.setName("req1");
		unit1.getRequirements().add(req1);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1 });
		assert req1.getContainedModelObjects().size() == 0;

		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setName("req2");
		unit1.getRequirements().add(req2);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2 });

		RequirementExpression expr1 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr1.setName("expr1");
		req1.getExpressions().add(expr1);
		createAnnotation(top);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { expr1 });
		assert expr1.getContainedModelObjects().size() == 0;

		RequirementExpression expr2 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr2.setName("expr2");
		req1.getExpressions().add(expr2);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { expr1,
				expr2 });

		DependencyLink dlink1 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink1.setName("dlink1");
		req1.setLink(dlink1);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { expr1,
				expr2, dlink1 });
		assert dlink1.getContainedModelObjects().size() == 0;

		dlink1.setTarget(cap1);
		assert dlink1.getContainedModelObjects().size() == 0;
		assert cap1.getContainedModelObjects().size() == 0;

		DependencyLink dlink2 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink2.setName("dlink2");
		req2.setLink(dlink2);
		assertSetEquals(top.getContainedModelObjects(), new Object[] { unit1,
				unit2 });
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { expr1,
				expr2, dlink1 });
		assertSetEquals(req2.getContainedModelObjects(),
				new Object[] { dlink2 });
		assert dlink1.getContainedModelObjects().size() == 0;

		FileArtifact a1 = CoreFactory.eINSTANCE.createFileArtifact();
		a1.setName("artifact1");
		unit1.getArtifacts().add(a1);
		createAnnotation(top);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1 });
		assert a1.getContainedModelObjects().size() == 0;

		FileArtifact a2 = CoreFactory.eINSTANCE.createFileArtifact();
		a2.setName("artifact2");
		unit1.getArtifacts().add(a2);
		createAnnotation(top);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2 });

		HostingLink hlink1 = CoreFactory.eINSTANCE.createHostingLink();
		hlink1.setName("hlink1");
		unit1.getHostingLinks().add(hlink1);
		createAnnotation(top);
		assert hlink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1 });

		hlink1.setTarget(unit2);
		assert hlink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1 });
		assert unit2.getContainedModelObjects().size() == 0;

		HostingLink hlink2 = CoreFactory.eINSTANCE.createHostingLink();
		hlink2.setName("hlink2");
		unit1.getHostingLinks().add(hlink2);
		createAnnotation(top);
		assert hlink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2 });
		assert unit2.getContainedModelObjects().size() == 0;

		MemberLink mlink1 = CoreFactory.eINSTANCE.createMemberLink();
		mlink1.setName("mlink1");
		unit1.getMemberLinks().add(mlink1);
		createAnnotation(top);
		assert mlink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1 });

		MemberLink mlink2 = CoreFactory.eINSTANCE.createMemberLink();
		mlink2.setName("mlink2");
		unit1.getMemberLinks().add(mlink2);
		createAnnotation(top);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2 });

		mlink1.setTarget(unit2);
		assert mlink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2 });
		assert unit2.getContainedModelObjects().size() == 0;

		ConstraintLink llink1 = CoreFactory.eINSTANCE.createConstraintLink();
		llink1.setName("llink1");
		unit1.getConstraintLinks().add(llink1);
		createAnnotation(top);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2,
				llink1 });

		llink1.setTarget(cap1);
		assert llink1.getContainedModelObjects().size() == 0;
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2,
				llink1 });
		assert unit2.getContainedModelObjects().size() == 0;

		ConstraintLink llink2 = CoreFactory.eINSTANCE.createConstraintLink();
		llink2.setName("llink2");
		unit1.getConstraintLinks().add(llink2);
		createAnnotation(top);
		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2,
				llink1, llink2 });

		//
		// Test serialization
		//
		top = reload(top, true);
		assert unit1 != top.resolve(unit1.getFullPath());
		unit1 = (Unit) top.resolve(unit1.getFullPath());
		assert unit1 != null;
		unit2 = (Unit) top.resolve(unit2.getFullPath());
		assert unit1 != null;
		cap1 = (Capability) top.resolve(cap1.getFullPath());
		assert cap1 != null;
		cap2 = (Capability) top.resolve(cap2.getFullPath());
		assert cap2 != null;
		req1 = (Requirement) top.resolve(req1.getFullPath());
		assert req1 != null;
		req2 = (Requirement) top.resolve(req2.getFullPath());
		assert req2 != null;
		dlink1 = (DependencyLink) top.resolve(dlink1.getFullPath());
		assert dlink1 != null;
		expr1 = (RequirementExpression) top.resolve(expr1.getFullPath());
		assert expr1 != null;
		expr2 = (RequirementExpression) top.resolve(expr2.getFullPath());
		assert expr2 != null;
		dlink2 = (DependencyLink) top.resolve(dlink2.getFullPath());
		assert dlink2 != null;
		a1 = (FileArtifact) top.resolve(a1.getFullPath());
		assert a1 != null;
		a2 = (FileArtifact) top.resolve(a2.getFullPath());
		assert a2 != null;
		hlink1 = (HostingLink) top.resolve(hlink1.getFullPath());
		assert hlink1 != null;
		hlink2 = (HostingLink) top.resolve(hlink2.getFullPath());
		assert hlink2 != null;
		mlink1 = (MemberLink) top.resolve(mlink1.getFullPath());
		assert mlink1 != null;
		mlink2 = (MemberLink) top.resolve(mlink2.getFullPath());
		assert mlink2 != null;
		llink1 = (ConstraintLink) top.resolve(llink1.getFullPath());
		assert llink1 != null;
		llink2 = (ConstraintLink) top.resolve(llink2.getFullPath());
		assert llink2 != null;

		assertSetEquals(unit1.getContainedModelObjects(), new Object[] { cap1,
				cap2, req1, req2, a1, a2, hlink1, hlink2, mlink1, mlink2,
				llink1, llink2 });
		assertSetEquals(req1.getContainedModelObjects(), new Object[] { expr1,
				expr2, dlink1 });
		assertSetEquals(req2.getContainedModelObjects(),
				new Object[] { dlink2 });
		assert unit2.getContainedModelObjects().size() == 0;
	}
}
