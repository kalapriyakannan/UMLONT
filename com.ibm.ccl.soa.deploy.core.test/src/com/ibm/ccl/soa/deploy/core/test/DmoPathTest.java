/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

public class DmoPathTest extends TopologyTestCase {

	public DmoPathTest() {
		super("DmoPathTest");
	}

	protected void checkResolveAll(Topology top) {
		assert top.resolve(top.getFullPath()) == top : "Cannot resolve "
				+ top.getFullPath();
		String topName = top.getName();
		top.setName(null);
		assert top.resolve(top.getFullPath()) == top : "Cannot resolve "
				+ top.getFullPath();
		top.setName(topName);

		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iter.next();
			// Full path resolution (valid name)
			assert top.resolve(dmo.getFullPath()) == dmo : "Cannot resolve "
					+ dmo.getFullPath();
			String name = dmo.getName();

			// Full path resolution (null name)
			dmo.setName(null);
			assert top.resolve(dmo.getFullPath()) == dmo : "Cannot resolve "
					+ dmo.getFullPath();
			dmo.setName(name);

			// Relative path resolution (all parents)
			DeployModelObject cur = dmo.getParent();
			while (cur != null) {
				assert cur.resolve(dmo.getRelativePath(cur)) == dmo : "Cannot resolve relative path "
						+ dmo.getRelativePath(cur)
						+ " relative to "
						+ cur.getName();
				cur = cur.getParent();
			}
		}
	}

	public void testPaths() throws Exception {
		Topology top = createTopology("testPaths");
		checkResolveAll(top);

		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);
		checkResolveAll(top);

		Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		unit2.setName("unit2");
		top.getUnits().add(unit2);
		checkResolveAll(top);

		unit2.setName(unit1.getName());
		checkResolveAll(top);
		unit2.setName("unit2");

		assert unit1.resolve(unit1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		Capability cap1 = CoreFactory.eINSTANCE.createCapability();
		cap1.setName("cap1");
		unit1.getCapabilities().add(cap1);
		checkResolveAll(top);

		Capability cap2 = CoreFactory.eINSTANCE.createCapability();
		cap2.setName("cap2");
		unit1.getCapabilities().add(cap2);
		checkResolveAll(top);

		assert cap1.resolve(cap1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		Requirement req1 = CoreFactory.eINSTANCE.createRequirement();
		req1.setName("req1");
		unit1.getRequirements().add(req1);
		checkResolveAll(top);

		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setName("req2");
		unit1.getRequirements().add(req2);
		checkResolveAll(top);

		assert req1.resolve(req1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		RequirementExpression expr1 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr1.setName("expr1");
		req1.getExpressions().add(expr1);
		checkResolveAll(top);

		RequirementExpression expr2 = CoreFactory.eINSTANCE
				.createRequirementExpression();
		expr2.setName("expr2");
		req1.getExpressions().add(expr2);
		checkResolveAll(top);

		assert expr1.resolve(expr1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		DependencyLink dlink1 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink1.setName("dlink1");
		req1.setLink(dlink1);
		checkResolveAll(top);

		dlink1.setTarget(cap1);
		checkResolveAll(top);

		DependencyLink dlink2 = CoreFactory.eINSTANCE.createDependencyLink();
		dlink2.setName("dlink2");
		req2.setLink(dlink2);
		checkResolveAll(top);

		assert dlink1.resolve(dlink1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		FileArtifact a1 = CoreFactory.eINSTANCE.createFileArtifact();
		a1.setName("artifact1");
		unit1.getArtifacts().add(a1);
		checkResolveAll(top);

		FileArtifact a2 = CoreFactory.eINSTANCE.createFileArtifact();
		a2.setName("artifact2");
		unit1.getArtifacts().add(a2);
		checkResolveAll(top);

		assert a1.resolve(a1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		HostingLink hlink1 = CoreFactory.eINSTANCE.createHostingLink();
		hlink1.setName("hlink1");
		unit1.getHostingLinks().add(hlink1);
		checkResolveAll(top);

		hlink1.setTarget(unit2);
		checkResolveAll(top);

		HostingLink hlink2 = CoreFactory.eINSTANCE.createHostingLink();
		hlink2.setName("hlink2");
		unit1.getHostingLinks().add(hlink2);
		checkResolveAll(top);

		assert hlink1.resolve(hlink1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		MemberLink mlink1 = CoreFactory.eINSTANCE.createMemberLink();
		mlink1.setName("mlink1");
		unit1.getMemberLinks().add(mlink1);
		checkResolveAll(top);

		MemberLink mlink2 = CoreFactory.eINSTANCE.createMemberLink();
		mlink2.setName("mlink2");
		unit1.getMemberLinks().add(mlink2);
		checkResolveAll(top);

		assert mlink1.resolve(mlink1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		mlink1.setTarget(unit2);
		checkResolveAll(top);

		ConstraintLink llink1 = CoreFactory.eINSTANCE.createConstraintLink();
		llink1.setName("llink1");
		unit1.getConstraintLinks().add(llink1);
		checkResolveAll(top);

		ConstraintLink llink2 = CoreFactory.eINSTANCE.createConstraintLink();
		llink2.setName("llink2");
		unit1.getConstraintLinks().add(llink2);
		checkResolveAll(top);

		assert llink1.resolve(llink1.getFullPath() + IConstants.PATH_SEPARATOR
				+ "nosuchobject") == null;

		llink1.setTarget(cap1);
		checkResolveAll(top);

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
		expr1 = (RequirementExpression) top.resolve(expr1.getFullPath());
		assert expr1 != null;
		expr2 = (RequirementExpression) top.resolve(expr2.getFullPath());
		assert expr2 != null;
		dlink1 = (DependencyLink) top.resolve(dlink1.getFullPath());
		assert dlink1 != null;
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

		assert dlink1.getTarget() == cap1;
		assert hlink1.getTarget() == unit2;
		assert mlink1.getTarget() == unit2;
		assert llink1.getTarget() == cap1;
	}
}
