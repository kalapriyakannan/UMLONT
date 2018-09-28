/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * Tests {@link DeployModelObjectUtil} and {@link UnitUtil}
 */
public class DeployModelObjectUtilTest extends TopologyTestCase {

	public DeployModelObjectUtilTest() {
		super("DeployModelObjectUtilTest");
	}

	public void testAttributeMethods() throws Exception {
		Topology top = createTopology("testAttributeMethods");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		//
		// Static attribute
		//
		String staticName = CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME
				.getName();
		assert DeployModelObjectUtil.hasAttribute(unit, staticName);
		assert DeployModelObjectUtil.getAttributeValue(unit, staticName) == null;
		String displayName = "unit display name";
		assert DeployModelObjectUtil.setAttributeValue(unit, staticName,
				displayName);
		assert DeployModelObjectUtil.getAttributeValue(unit, staticName)
				.equals(displayName);

		// full name
		String fullStaticName = DeployModelObjectUtil.getFullPathToAttribute(
				unit, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME);
		assert !staticName.equals(fullStaticName);
		assert DeployModelObjectUtil.hasAttribute(unit, fullStaticName);
		assert DeployModelObjectUtil.getAttributeValue(unit, fullStaticName)
				.equals(displayName);
		displayName += "2";
		assert !DeployModelObjectUtil.getAttributeValue(unit, fullStaticName)
				.equals(displayName);
		assert DeployModelObjectUtil.setAttributeValue(unit, staticName,
				displayName);
		assert DeployModelObjectUtil.getAttributeValue(unit, staticName)
				.equals(displayName);

		//
		// Dynamic attribute
		//
		String dynValue = "dynValue";
		String dynamicName = "dynamictestattribute";
		assert !DeployModelObjectUtil.hasAttribute(unit, dynamicName);
		ExtendedAttribute extAttr = DeployModelObjectUtil
				.createExtendedAttribute(unit, dynamicName,
						XMLTypePackage.eINSTANCE.getString());
		assert extAttr != null;
		assert DeployModelObjectUtil.hasAttribute(unit, dynamicName);
//		assert DeployModelObjectUtil.getAttributeValue(unit, dynamicName)
//		.equals(extAttr.getValue());
		Assert.assertEquals(DeployModelObjectUtil.getAttributeValue(unit, dynamicName), extAttr.getValue());
		assert DeployModelObjectUtil.setAttributeValue(unit, dynamicName,
				dynValue);
		assert DeployModelObjectUtil.getAttributeValue(unit, dynamicName)
				.equals(dynValue);
		assert !DeployModelObjectUtil.hasAttribute(unit, "nosuchattribute");
		assert !DeployModelObjectUtil.setAttributeValue(unit,
				"nosuchattribute", dynValue);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");

		// full name
		String fullDynamicName = DeployModelObjectUtil.getFullPathToAttribute(
				unit, dynamicName);
		assert fullDynamicName.equals(DeployModelObjectUtil
				.getFullPathToAttribute(extAttr));
		assert !dynamicName.equals(fullDynamicName);
		assert DeployModelObjectUtil.hasAttribute(unit, fullDynamicName);
		assert DeployModelObjectUtil.getAttributeValue(unit, fullDynamicName)
				.equals(dynValue);
		dynValue += "2";
		assert !DeployModelObjectUtil.getAttributeValue(unit, fullDynamicName)
				.equals(dynValue);
		assert DeployModelObjectUtil.setAttributeValue(unit, staticName,
				dynValue);
		assert DeployModelObjectUtil.getAttributeValue(unit, staticName)
				.equals(dynValue);

	}

	/**
	 * Make sure UnitUtil.duplicate() copies Requirements properly
	 */
	public void testUnitCopy() {
		Topology top = createTopology("testUnitCopy");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		Requirement reqPhys = CoreFactory.eINSTANCE.createRequirement();
		reqPhys.setName("reqPhys");
		unit.getRequirements().add(reqPhys);

		Requirement reqLog = CoreFactory.eINSTANCE.createRequirement();
		reqPhys.setName("reqLog");
		unit.getRequirements().add(reqLog);

		Unit unitB = duplicate(unit);
	}
	
	/* 
	 * It isn't safe to call EcoreUtil.copy() for our units, call this method instead. This version
	 * only copies dependency links (maintaining their targets. If it is necessary to preserve links
	 * in a copy, use {@link ResolutionUtils#partialIntelligentDeepCopy(List, Topology, boolean)}.
	 * 
	 * @param u
	 *           the unit to duplicate
	 * @return a copy of the u
	 */
	public static Unit duplicate(Unit u) {
		Unit retVal = (Unit) EcoreUtil.copy(u);

		// Note that the copied Unit's Dmo ETypes will be invalid
		// until explicitly.  This is because the automatic copy
		// needs namespaces.  (A better solution would be to add transient
		// field for DmoEType to compliment DmoEType, and customize
		// the DmoEType getter.)

		for (int i = 0; i < retVal.getRequirements().size(); i++) {
			Requirement reqSrc = (Requirement) u.getRequirements().get(i);
			Requirement reqDst = (Requirement) retVal.getRequirements().get(i);
			reqDst.setDmoEType(reqSrc.getDmoEType());
			DependencyLink lnk = reqSrc.getLink();
			if (null != lnk) {
				lnk.setSource(reqSrc); // PREVENT BAD SOURCEURI CACHED VALUE!
			}
		}

		// eliminate other link types
		retVal.getUnitLinks().clear();
		retVal.getRealizationLinks().clear();
		retVal.getConstraintLinks().clear();
		// it isn't obvious that dependency links should stay either.  We leave them for now.

		return retVal;
	}
	 
	/**
	 * @param list
	 * @return
	 */
	public static Collection<Unit> duplicate(List<Unit> list) {

		// Note that this doesn't put the copies into the dummy topology.  (Without a topology, the
		// TopologyUtil methods won't work.)
		Topology dummy = CoreFactory.eINSTANCE.createTopology();
		Collection<Unit> copies = ResolutionUtils.partialIntelligentDeepCopy(list, dummy, false);
		return copies;
	}

	/**
	 * Make sure UnitUtil.duplicate() copies Requirements properly
	 */
	public void testUnitMultiCopy() {
		Topology top = createTopology("testUnitMultiCopy");

		// Create unitA, which requires UnitB
		Unit unitA = CoreFactory.eINSTANCE.createUnit();
		unitA.setName("unitA");
		top.getUnits().add(unitA);

		Requirement reqPhys = CoreFactory.eINSTANCE.createRequirement();
		reqPhys.setName("reqPhys");
		unitA.getRequirements().add(reqPhys);

		Unit unitB = CoreFactory.eINSTANCE.createUnit();
		unitB.setName("unitB");
		top.getUnits().add(unitB);

		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.setName("cap");
		unitB.getCapabilities().add(cap);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setTarget(cap);
		reqPhys.setLink(link);

		// Link A and B with realization
		RealizationLink rlinkAB = CoreFactory.eINSTANCE.createRealizationLink();
		rlinkAB.setTarget(unitB);
		rlinkAB.setSource(unitA); // Note that containment isn't sufficient...
		unitA.getRealizationLinks().add(rlinkAB);

		// Make a third Unit, UnitC, and have UnitA depend on it, too
		Unit unitC = CoreFactory.eINSTANCE.createUnit();
		unitC.setName("unitC");
		top.getUnits().add(unitC);
		RealizationLink rlinkAC = CoreFactory.eINSTANCE.createRealizationLink();
		rlinkAC.setTarget(unitC);
		rlinkAC.setSource(unitA); // Note that containment isn't sufficient...
		unitA.getRealizationLinks().add(rlinkAC);

// System.out.println("unitA has " +
// TopologyUtil.getImmediateRealizationLinksOut(unitA).size() + " realization
// links");

		// Link A and B with hosting
		HostingLink hlinkAB = CoreFactory.eINSTANCE.createHostingLink();
		hlinkAB.setTarget(unitB);
		hlinkAB.setSource(unitA); // Note that containment isn't sufficient...
		unitA.getHostingLinks().add(hlinkAB);

		// Link A and C with hosting too
		HostingLink hlinkAC = CoreFactory.eINSTANCE.createHostingLink();
		hlinkAC.setTarget(unitC);
		hlinkAC.setSource(unitA); // Note that containment isn't sufficient...
		unitA.getHostingLinks().add(hlinkAC);

// System.out.println("unitA has " +
// TopologyUtil.getImmediateHostingLinksOut(unitA).size() + " hosting links");

		assert TopologyUtil.getImmediateRealizationLinksOut(unitA).size() == 2;
		assert TopologyUtil.getImmediateHostingLinksOut(unitA).size() == 2;

		// Copy the first two units, but not UnitC
		Collection<Unit> copies = duplicate(Arrays.asList(new Unit[] {
				unitA, unitB }));

		Unit copyUnitA = getNamedUnit(copies, "unitA");
		Unit copyUnitB = getNamedUnit(copies, "unitB");

		Requirement copyReqPhys = (Requirement) copyUnitA.getRequirements()
				.get(0);

		Capability copyCap = (Capability) copyUnitB.getCapabilities().get(0);

// System.out.println(copyCap);
// System.out.println(copyReqPhys.getLink().getTarget());

		assert copyReqPhys.getLink().getTarget() == copyCap;

// System.out.println("copyUnitA has " + copyUnitA.getRealizationLinks().size()
// + " realization links");
// System.out.println("copyUnitA has " + copyUnitA.getHostingLinks().size() + "
// hosting links");

		// We can't use TopologyUtils, as the copies aren't in a topology
		assert copyUnitA.getRealizationLinks().size() == 1;
		assert copyUnitA.getHostingLinks().size() == 1;
	}

	private static Unit getNamedUnit(Collection<Unit> copies, String s) {
		for (Iterator<Unit> it = copies.iterator(); it.hasNext();) {
			Unit unit = it.next();
			if (unit.getName().equals(s)) {
				return unit;
			}
		}

		return null;
	}

	private static class IdentityObjectAdapter implements IObjectAdapter {

		public Object adapt(Object object) {
			return object;
		}

	} // end static inner class IdentityObjectAdapter

	/**
	 * Tests {@link DeployModelObjectUtil#createDeployModelObjectName(String)}
	 */
	public void testCreateDeployModelObjectName() {
		assertEquals(null, DeployModelObjectUtil.createDeployModelObjectName(null));
		assertEquals("", DeployModelObjectUtil.createDeployModelObjectName(""));
		assertEquals("a2c", DeployModelObjectUtil.createDeployModelObjectName("a2c"));
		assertEquals("", DeployModelObjectUtil.createDeployModelObjectName("#"));
		assertEquals("", DeployModelObjectUtil.createDeployModelObjectName("#!"));
		assertEquals("a", DeployModelObjectUtil.createDeployModelObjectName("a#"));
		assertEquals("a", DeployModelObjectUtil.createDeployModelObjectName("#a"));
		assertEquals("ac", DeployModelObjectUtil.createDeployModelObjectName("#ac"));
		assertEquals("ac", DeployModelObjectUtil.createDeployModelObjectName("a#c"));
		assertEquals("ac", DeployModelObjectUtil.createDeployModelObjectName("ac#"));
		assertEquals("aaac", DeployModelObjectUtil.createDeployModelObjectName("aaa#c"));
		assertEquals("accc", DeployModelObjectUtil.createDeployModelObjectName("#accc"));
		assertEquals("accc", DeployModelObjectUtil.createDeployModelObjectName("a#ccc"));
	}
} // end class DeployModelObjectUtilTest
