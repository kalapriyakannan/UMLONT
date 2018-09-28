/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.EObjectEventLogger;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RemoveInstantiationPropertyResolution;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RemoveInstantiationResolution;

/**
 * Tests the validation of imported topologies.
 * 
 * @see Topology#getImports()
 */
public class TopologyImportValidationTest extends TopologyTestCase {

	public TopologyImportValidationTest() {
		super("TopologyImportValidationTest");
	}

	/**
	 * Tests the separation of {@link DeployModelObject#getStatus()} between
	 * object and proxy.
	 * 
	 * @throws Exception
	 */
	public void testStatusSeparation() throws Exception {
		//
		// Create topology 1
		//
		Topology top1 = createTopology("testStatusSeparation1");

		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		top1.getUnits().add(u1);
		assert top1 == top1.getEditTopology();
		save(top1);

		//
		// Create topology 2 and import topology 1
		//
		Topology top2 = createTopology("testStatusSeparation2");
		Import importDcl = TopologyUtil.importTopology(top1, top2);
		save(top2);
		Unit importU1 = (Unit) top2.resolve(getGlobalPath(u1));
		assert importU1 != null;
		Topology importedTop1 = TopologyUtil.resolve(importDcl);
		assert importedTop1 != top1;
		assert importedTop1.getEditTopology() == top2;

		assert u1 != importU1;

		//
		// Add listeners to events on the regular object as well as the proxy
		// for u1
		//
		EObjectEventLogger u1Listener = new EObjectEventLogger();
		u1.eAdapters().add(u1Listener);
		EObjectEventLogger importU1Listener = new EObjectEventLogger();
		importU1.eAdapters().add(importU1Listener);
		int u1EventCount = 0;
		int importU1EventCount = 0;

		//
		// Test status interference
		//
		IDeployStatus status1 = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(IStatus.ERROR, "V1", "V1", "V1", null, u1);
		u1.addStatus(status1);
		u1EventCount++;
		assertEquals(u1.getStatus(), status1);
		assertEquals(importU1.getStatus(), Status.OK_STATUS);
		assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		assertEquals(importU1Listener.getNotifications().size(),
				importU1EventCount);

		IDeployStatus status2 = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(IStatus.ERROR, "V2", "V2", "V2", null,
						importU1);
		importU1.addStatus(status2);
		importU1EventCount++;
		assertEquals(u1.getStatus(), status1);
		assertEquals(importU1.getStatus(), status2);
		assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		assertEquals(importU1Listener.getNotifications().size(),
				importU1EventCount);

		importU1.clearStatus();
		importU1EventCount++;
		assertEquals(u1.getStatus(), status1);
		assertEquals(importU1.getStatus(), Status.OK_STATUS);
		assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		assertEquals(importU1Listener.getNotifications().size(),
				importU1EventCount);

		importU1.addStatus(status2);
		importU1EventCount++;
		assertEquals(u1.getStatus(), status1);
		assertEquals(importU1.getStatus(), status2);
		assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		assertEquals(importU1Listener.getNotifications().size(),
				importU1EventCount);

		u1.clearStatus();
		u1EventCount++;
		assertEquals(u1.getStatus(), Status.OK_STATUS);
		assertEquals(importU1.getStatus(), status2);
		assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		assertEquals(importU1Listener.getNotifications().size(),
				importU1EventCount);

		save(top2);

		// Test event notification on u1 set event
		// TODO
		// importU1.setDescription("test description");
		// importU1EventCount++;
		// assertEquals(u1Listener.getNotifications().size(), u1EventCount);
		// assertEquals(importU1Listener.getNotifications().size(),
		// importU1EventCount);

		// TODO check that the importU1 status is serialized as a marker on the
		// top2 resource
		TopologyTestUtils
				.assertAllTopologyMethodsReturnProxyObjects(resolve(importDcl));
	}

	/**
	 * Tests the validation of a cross-topology hosting link where the hosted
	 * unit is imported.
	 * 
	 * @throws Exception
	 */
	public void testCrossTopologyHostingLinkHostedImported() throws Exception {
		//
		// Create imported topology
		//
		Topology importTop = createTopology("testCrossTopologyHostingLinkHostImported-Import");
		Unit hosted = CoreFactory.eINSTANCE.createUnit();
		hosted.setName("hosted");
		importTop.getUnits().add(hosted);

		Requirement hostReq = CoreFactory.eINSTANCE.createRequirement();
		hostReq.setName("hostReq");
		hostReq.setDmoEType(CorePackage.Literals.CAPABILITY);
		hostReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hosted.getRequirements().add(hostReq);

		save(importTop);
		validate(importTop);
		assertHasDeployStatus(hosted, ICoreProblemType.UNIT_NOT_HOSTED,
				IStatus.ERROR);

		//
		// Create edit topology
		//
		Topology top = createTopology("testCrossTopologyHostingLinkHostImported-Edit");

		Unit host = CoreFactory.eINSTANCE.createUnit();
		host.setName("host");
		top.getUnits().add(host);

		Capability hostCap = CoreFactory.eINSTANCE.createCapability();
		hostCap.setName("hostCap");
		hostCap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		host.getCapabilities().add(hostCap);

		save(top);
		validate(top);
		assertHasNoErrorStatus(top);

		assert top.resolve(getGlobalPath(hosted)) == null;

		//
		// Import topology
		//
		Import importDcl = TopologyUtil.importTopology(importTop, top);
		assert importDcl != null;

		//
		// Lookup proxy references for imported topology
		//
		importTop = TopologyUtil.resolve(importDcl);
		hosted = (Unit) top.resolve(getGlobalPath(hosted));
		hostReq = (Requirement) top.resolve(getGlobalPath(hostReq));
		assert importTop != null;
		assert hosted != null;
		assert hostReq != null;
		assertSetEquals(hosted.getRequirements(), new Requirement[] { hostReq });

		validate(top);
		assertHasErrorStatus(top);
		assertHasDeployStatus(hosted, ICoreProblemType.UNIT_NOT_HOSTED,
				IStatus.ERROR);

		//
		// Create hosting link
		//
		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setTarget(hosted);
		link.setName("hlink");
		host.getHostingLinks().add(link);
		UnitUtil.assignUniqueName(link);

		assertSetEquals(top.findHosts(hosted), new Unit[] { host });
		assertSetEquals(importTop.findHosts(hosted), new Unit[] { host });
		assertEquals(TopologyDiscovererService.INSTANCE.findHost(hosted, top),
				host);
		assertEquals(TopologyDiscovererService.INSTANCE.findHost(hosted,
				importTop), host);
		List descriptorList = TopologyDiscovererService.INSTANCE.findHosted(
				host, top);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				hosted);

		descriptorList = TopologyDiscovererService.INSTANCE.findHosted(host,
				importTop);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				hosted);

		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Check serialization
		//
		top = reload(top, true);
		assert top != null;
		assert top.getImports().size() == 1;
		importDcl = (Import) top.getImports().get(0);
		assert importDcl != null;

		importTop = TopologyUtil.resolve(importDcl);
		hosted = (Unit) top.resolve(getGlobalPath(hosted));
		host = (Unit) top.resolve(getGlobalPath(host));
		hostReq = (Requirement) top.resolve(getGlobalPath(hostReq));
		hostCap = (Capability) top.resolve(getGlobalPath(hostCap));
		assert importTop != null;
		assert hosted != null;
		assert host != null;
		assert hostReq != null;
		assert hostCap != null;

		assert host.getHostingLinks().size() == 1;
		link = (HostingLink) host.getHostingLinks().get(0);
		assert host.equals(link.getSource());
		assert hosted.equals(link.getTarget());

		assertSetEquals(hosted.getRequirements(), new Requirement[] { hostReq });
		assertSetEquals(host.getCapabilities(), new Capability[] { hostCap });
		// assertEquals(TopologyDiscovererService.INSTANCE.findTarget(sourceUnit,
		// reqType, topology)(u1, top), u2);
		// assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1,
		// importTop), u2);

		validate(top);
		assertHasNoErrorStatus(top);

		assertSetEquals(top.findHosts(hosted), new Unit[] { host });
		assertSetEquals(importTop.findHosts(hosted), new Unit[] { host });

		// this line is asking the imported topology to identify the
		// hosts in the edited topology; is this really what you meant?
		// TODO assertSetEquals(u1.getTopology().findHosts(u1), new Unit[] { u2
		// });
		TopologyTestUtils
				.assertAllTopologyMethodsReturnProxyObjects(resolve(importDcl));
	}

	/**
	 * Tests the validation of a cross-topology hosting link where the host unit
	 * is imported.
	 * 
	 * @throws Exception
	 */
	public void testCrossTopologyHostingLinkHostImported() throws Exception {
		//
		// Create imported topology
		//
		Topology importTop = createTopology("testCrossTopologyHostingLinkHostedImported-Import");

		Unit host = CoreFactory.eINSTANCE.createUnit();
		host.setName("host");
		importTop.getUnits().add(host);

		Capability hostCap = CoreFactory.eINSTANCE.createCapability();
		hostCap.setName("hostCap");
		hostCap.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		host.getCapabilities().add(hostCap);

		save(importTop);
		validate(importTop);
		assertHasNoErrorStatus(importTop);

		//
		// Create edit topology
		//
		Topology top = createTopology("testCrossTopologyHostingLinkHostedImported-Edit");

		Unit hosted = CoreFactory.eINSTANCE.createUnit();
		hosted.setName("hosted");
		top.getUnits().add(hosted);

		Requirement hostReq = CoreFactory.eINSTANCE.createRequirement();
		hostReq.setName("hostReq");
		hostReq.setDmoEType(CorePackage.Literals.CAPABILITY);
		hostReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hosted.getRequirements().add(hostReq);

		save(top);
		validate(top);
		assertHasDeployStatus(hosted, ICoreProblemType.UNIT_NOT_HOSTED,
				IStatus.ERROR);

		assert top.resolve(getGlobalPath(host)) == null;

		//
		// Import topology
		//
		Import importDcl = TopologyUtil.importTopology(importTop, top);
		assert importDcl != null;

		//
		// Lookup proxy references for imported topology
		//
		importTop = TopologyUtil.resolve(importDcl);
		host = (Unit) top.resolve(getGlobalPath(host));
		hostCap = (Capability) top.resolve(getGlobalPath(hostCap));
		assert importTop != null;
		assert host != null;
		assert hostCap != null;
		assertSetEquals(host.getCapabilities(), new Capability[] { hostCap });

		validate(top);
		assertHasErrorStatus(top);
		assertHasDeployStatus(hosted, ICoreProblemType.UNIT_NOT_HOSTED,
				IStatus.ERROR);

		//
		// Create hosting link
		//
		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setTarget(hosted);
		link.setName("hlink");
		link.setSource(host);
		top.getHostingLinks().add(link);
		UnitUtil.assignUniqueName(link);

		assertSetEquals(top.findHosts(hosted), new Unit[] { host });
		assertSetEquals(importTop.findHosts(hosted), new Unit[] { host });
		assertEquals(TopologyDiscovererService.INSTANCE.findHost(hosted, top),
				host);
		assertEquals(TopologyDiscovererService.INSTANCE.findHost(hosted,
				importTop), host);
		List descriptorList = TopologyDiscovererService.INSTANCE.findHosted(
				host, top);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				hosted);

		descriptorList = TopologyDiscovererService.INSTANCE.findHosted(host,
				importTop);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				hosted);

		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Check serialization
		//
		top = reload(top, true);
		assert top != null;
		assert top.getImports().size() == 1;
		importDcl = (Import) top.getImports().get(0);
		assert importDcl != null;

		importTop = TopologyUtil.resolve(importDcl);
		hosted = (Unit) top.resolve(getGlobalPath(hosted));
		host = (Unit) top.resolve(getGlobalPath(host));
		hostReq = (Requirement) top.resolve(getGlobalPath(hostReq));
		hostCap = (Capability) top.resolve(getGlobalPath(hostCap));
		assert importTop != null;
		assert hosted != null;
		assert host != null;
		assert hostReq != null;
		assert hostCap != null;

		assert top.getHostingLinks().size() == 1;
		link = (HostingLink) top.getHostingLinks().get(0);
		assert host.equals(link.getSource());
		assert hosted.equals(link.getTarget());

		assertSetEquals(hosted.getRequirements(), new Requirement[] { hostReq });
		assertSetEquals(host.getCapabilities(), new Capability[] { hostCap });
		// assertEquals(TopologyDiscovererService.INSTANCE.findTarget(sourceUnit,
		// reqType, topology)(u1, top), u2);
		// assertEquals(TopologyDiscovererService.INSTANCE.findHost(u1,
		// importTop), u2);

		validate(top);
		assertHasNoErrorStatus(top);

		assertSetEquals(top.findHosts(hosted), new Unit[] { host });
		assertSetEquals(importTop.findHosts(hosted), new Unit[] { host });

		// this line is asking the imported topology to identify the
		// hosts in the edited topology; is this really what you meant?
		// TODO assertSetEquals(u1.getTopology().findHosts(u1), new Unit[] { u2
		// });
		TopologyTestUtils
				.assertAllTopologyMethodsReturnProxyObjects(resolve(importDcl));
	}

	/**
	 * Test validation of cross-topology dependency links contained in the
	 * topology.
	 * 
	 * @throws Exception
	 */
	public void XXXtestCrossTopologyDependencyLinkInTopology() throws Exception {
		internalTestCrossTopologyDependencyLink(false);
	}

	/**
	 * Test validation of cross-topology dependency links contained in the
	 * source requirement.
	 * 
	 * @throws Exception
	 */
	public void testCrossTopologyDependencyLinkInSource() throws Exception {
		internalTestCrossTopologyDependencyLink(true);
	}

	/**
	 * Tests the validation of a cross-topology dependency link.
	 * 
	 * @param linkContainedInSource
	 *            true if the dependency link should be contained in the
	 *            requirement source, false in the topology.
	 * 
	 * @throws Exception
	 */
	protected void internalTestCrossTopologyDependencyLink(
			boolean linkContainedInSource) throws Exception {
		//
		// Create imported topology
		//
		Topology importTop = createTopology("testCrossTopologyDependencyLink-"
				+ linkContainedInSource + "-Import");
		Unit u1 = CoreFactory.eINSTANCE.createUnit();
		u1.setName("u1");
		importTop.getUnits().add(u1);

		Capability c1 = CoreFactory.eINSTANCE.createCapability();
		c1.setName("c1");
		c1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		u1.getCapabilities().add(c1);

		save(importTop);
		validate(importTop);
		assertHasNoErrorStatus(importTop);

		//
		// Create edit topology
		//
		Topology top = createTopology("testCrossTopologyDependnencyLink-"
				+ linkContainedInSource + "-Edit");

		Unit u2 = CoreFactory.eINSTANCE.createUnit();
		u2.setName("u2");
		top.getUnits().add(u2);

		Requirement r2 = CoreFactory.eINSTANCE.createRequirement();
		r2.setName("r2");
		r2.setDmoEType(CorePackage.Literals.CAPABILITY);
		r2.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		u2.getRequirements().add(r2);

		save(top);
		validate(top);
		assertHasDeployStatus(r2,
				ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED,
				IStatus.ERROR);

		assert top.resolve(getGlobalPath(u1)) == null;

		//
		// Import topology
		//
		Import importDcl = TopologyUtil.importTopology(importTop, top);
		assert importDcl != null;

		//
		// Lookup proxy references for imported topology
		//
		importTop = TopologyUtil.resolve(importDcl);
		u1 = (Unit) top.resolve(getGlobalPath(u1));
		c1 = (Capability) top.resolve(getGlobalPath(c1));
		assert importTop != null;
		assert u1 != null;
		assert r2 != null;
		assertSetEquals(u1.getCapabilities(), new Capability[] { c1 });

		// Validate top + importTop
		validate(top);
		assert top.getStatus().isOK();
		assertHasDeployStatus(r2,
				ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED,
				IStatus.ERROR);

		//
		// Create dependency link
		//
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setTarget(c1);
		link.setName("dlink");
		if (linkContainedInSource) {
			r2.setLink(link);
		} else {
			link.setSource(r2);
			top.getDependencyLinks().add(link);
		}
		UnitUtil.assignUniqueName(link);

		assertSetEquals(top.findDependentRequirements(c1),
				new Requirement[] { r2 });
		assertSetEquals(importTop.findDependentRequirements(c1),
				new Requirement[] { r2 });
		List descriptorList = TopologyDiscovererService.INSTANCE.findSources(
				u1, c1, top);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				u2);
		descriptorList = TopologyDiscovererService.INSTANCE.findSources(u1, c1,
				importTop);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				u2);

		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Check serialization
		//
		top = reload(top, true);
		assert top != null;
		assert top.getImports().size() == 1;
		importDcl = (Import) top.getImports().get(0);
		assert importDcl != null;

		importTop = TopologyUtil.resolve(importDcl);
		u1 = (Unit) top.resolve(getGlobalPath(u1));
		u2 = (Unit) top.resolve(getGlobalPath(u2));
		r2 = (Requirement) top.resolve(getGlobalPath(r2));
		c1 = (Capability) top.resolve(getGlobalPath(c1));
		assert u1 != null;
		assert u2 != null;
		assert r2 != null;
		assert c1 != null;

		if (linkContainedInSource) {
			assert top.getDependencyLinks().size() == 0;
			link = (DependencyLink) r2.getLink();
		} else {
			assert top.getDependencyLinks().size() == 1;
			link = (DependencyLink) top.getDependencyLinks().get(0);
		}
		assert r2.equals(link.getSource());
		assert c1.equals(link.getTarget());

		assertSetEquals(u1.getCapabilities(), new Capability[] { c1 });
		assertSetEquals(u2.getRequirements(), new Requirement[] { r2 });

		validate(top);
		// TODO assertHasNoErrorStatus(top);

		// this line is asking the imported topology to identify the
		// hosts in the edited topology; is this really what you meant?
		// TODO assertSetEquals(u1.getTopology().findHosts(u1), new Unit[] { u2
		// });
		TopologyTestUtils
				.assertAllTopologyMethodsReturnProxyObjects(resolve(importDcl));
	}

	/**
	 * Test validation of cross-topology member links contained in the topology.
	 * 
	 * @throws Exception
	 */
	public void XXXtestCrossTopologyMemberLinkInTopology() throws Exception {
		internalTestCrossTopologyMemberLink(false);
	}

	/**
	 * Test validation of cross-topology member links contained in the group
	 * unit (source).
	 * 
	 * @throws Exception
	 */
	public void testCrossTopologyMemberLinkInSource() throws Exception {
		internalTestCrossTopologyMemberLink(true);
	}

	/**
	 * Tests the validation of a cross-topology member link.
	 * 
	 * @param linkContainedInSource
	 *            true if the member link should be contained in the group unit,
	 *            false in the topology.
	 * 
	 * @throws Exception
	 */
	protected void internalTestCrossTopologyMemberLink(
			boolean linkContainedInSource) throws Exception {
		//
		// Create imported topology
		//
		Topology importTop = createTopology("testCrossTopologyMemberLink-"
				+ linkContainedInSource + "-Import");
		Unit member = CoreFactory.eINSTANCE.createUnit();
		member.setName("member");
		importTop.getUnits().add(member);

		Requirement groupReq = CoreFactory.eINSTANCE.createRequirement();
		groupReq.setName("groupReq");
		groupReq.setDmoEType(CorePackage.Literals.UNIT);
		groupReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		member.getRequirements().add(groupReq);

		RequirementExpression groupReqExpr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		groupReqExpr.setName("groupReqExpr");
		groupReqExpr.setInterpreter(InCardinality.INTERPRETER_ID);
		groupReqExpr.setValue("1");
		groupReq.getExpressions().add(groupReqExpr);

		save(importTop);
		validate(importTop);
		assertHasDeployStatus(groupReqExpr,
				ICoreProblemType.GROUP_IN_CARDINALITY_INVALID, IStatus.ERROR);

		//
		// Create edit topology
		//
		Topology top = createTopology("testCrossTopologyMemberLink-"
				+ linkContainedInSource + "-Edit");

		Unit group = CoreFactory.eINSTANCE.createUnit();
		group.setName("group");
		top.getUnits().add(group);

		Requirement memberReq = CoreFactory.eINSTANCE.createRequirement();
		memberReq.setName("memberReq");
		memberReq.setDmoEType(CorePackage.Literals.UNIT);
		memberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		group.getRequirements().add(memberReq);

		RequirementExpression memberReqExpr = CoreFactory.eINSTANCE
				.createRequirementExpression();
		memberReqExpr.setName("memberReqExpr");
		memberReqExpr.setInterpreter(OutCardinality.INTERPRETER_ID);
		memberReqExpr.setValue("*");
		memberReq.getExpressions().add(memberReqExpr);

		save(top);
		validate(top);
		assertHasNoErrorStatus(top);

		assert top.resolve(getGlobalPath(member)) == null;

		//
		// Import topology
		//
		Import importDcl = TopologyUtil.importTopology(importTop, top);
		assert importDcl != null;

		//
		// Lookup proxy references for imported topology
		//
		importTop = TopologyUtil.resolve(importDcl);
		member = (Unit) top.resolve(getGlobalPath(member));
		groupReq = (Requirement) top.resolve(getGlobalPath(groupReq));
		groupReqExpr = (RequirementExpression) top
				.resolve(getGlobalPath(groupReqExpr));
		assert importTop != null;
		assert member != null;
		assert groupReq != null;
		assert groupReqExpr != null;
		assertSetEquals(member.getRequirements(),
				new Requirement[] { groupReq });
		assertSetEquals(groupReq.getExpressions(),
				new RequirementExpression[] { groupReqExpr });

		// validate (has imported topology error)
		validate(top);
		assert top.getStatus().isOK();
		assertHasDeployStatus(groupReqExpr,
				ICoreProblemType.GROUP_IN_CARDINALITY_INVALID, IStatus.ERROR);

		//
		// Create member link
		//
		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setTarget(member);
		link.setName("dlink");
		if (linkContainedInSource) {
			group.getMemberLinks().add(link);
		} else {
			link.setSource(group);
			top.getMemberLinks().add(link);
		}
		UnitUtil.assignUniqueName(link);

		assertSetEquals(top.findMemberOf(member), new Unit[] { group });
		assertSetEquals(importTop.findMemberOf(member), new Unit[] { group });
		List descriptorList = TopologyDiscovererService.INSTANCE.getGroups(
				member, null, top);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				group);
		descriptorList = TopologyDiscovererService.INSTANCE.getGroups(member,
				null, importTop);
		assertEquals(descriptorList.size(), 1);
		assertEquals(((UnitDescriptor) descriptorList.get(0)).getUnitValue(),
				group);

		validate(top);
		assertHasNoErrorStatus(top);

		//
		// Check serialization
		//
		top = reload(top, true);
		assert top != null;
		assert top.getImports().size() == 1;
		importDcl = (Import) top.getImports().get(0);
		assert importDcl != null;

		importTop = TopologyUtil.resolve(importDcl);
		member = (Unit) top.resolve(getGlobalPath(member));
		group = (Unit) top.resolve(getGlobalPath(group));
		memberReq = (Requirement) top.resolve(getGlobalPath(memberReq));
		memberReqExpr = (RequirementExpression) top
				.resolve(getGlobalPath(memberReqExpr));
		groupReq = (Requirement) top.resolve(getGlobalPath(groupReq));
		groupReqExpr = (RequirementExpression) top
				.resolve(getGlobalPath(groupReqExpr));
		assert importTop != null;
		assert member != null;
		assert memberReq != null;
		assert memberReqExpr != null;
		assert group != null;
		assert groupReq != null;
		assert groupReqExpr != null;

		if (linkContainedInSource) {
			assert group.getMemberLinks().size() == 1;
			link = (MemberLink) group.getMemberLinks().get(0);
		} else {
			assert top.getMemberLinks().size() == 1;
			link = (MemberLink) top.getMemberLinks().get(0);
		}
		assert group.equals(link.getSource());
		assert member.equals(link.getTarget());

		assertSetEquals(member.getRequirements(),
				new Requirement[] { groupReq });
		assertSetEquals(group.getRequirements(),
				new Requirement[] { memberReq });

		validate(top);
		// TODO assertHasNoErrorStatus(top);

		// this line is asking the imported topology to identify the
		// hosts in the edited topology; is this really what you meant?
		// TODO assertSetEquals(u1.getTopology().findHosts(u1), new Unit[] { u2
		// });
		TopologyTestUtils
				.assertAllTopologyMethodsReturnProxyObjects(resolve(importDcl));
	}

	public void testMemberLinksImported() throws Exception {
		Topology importTop = createTopology("testMemberLinksImported-Import");

		Unit member1 = CoreFactory.eINSTANCE.createUnit();
		member1.setName("member1");
		importTop.getUnits().add(member1);

		Unit member2 = CoreFactory.eINSTANCE.createUnit();
		member2.setName("member2");
		importTop.getUnits().add(member2);

		Unit group = CoreFactory.eINSTANCE.createUnit();
		group.setName("group");
		importTop.getUnits().add(group);

		Requirement memberReq = CoreFactory.eINSTANCE.createRequirement();
		memberReq.setName("memberReq");
		memberReq.setDmoEType(CorePackage.Literals.UNIT);
		memberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		group.getRequirements().add(memberReq);

		MemberLink link1 = CoreFactory.eINSTANCE.createMemberLink();
		link1.setTarget(member1);
		link1.setName("dlink");
		group.getMemberLinks().add(link1);
		UnitUtil.assignUniqueName(link1);

		MemberLink link2 = CoreFactory.eINSTANCE.createMemberLink();
		link2.setTarget(member2);
		link2.setName("dlink");
		group.getMemberLinks().add(link2);
		UnitUtil.assignUniqueName(link2);

		save(importTop);

		Topology top = createTopology("testMemberLinksImported-Edit");

		Import importDcl = TopologyUtil.importTopology(importTop, top);

		// Make sure imported units only own member links that they should own
		for (Iterator it = importDcl.getInstanceConfiguration()
				.getPublicUnits().iterator(); it.hasNext();) {
			Unit importUnit = (Unit) it.next();
			for (Iterator it2 = importUnit.getMemberLinks().iterator(); it2
					.hasNext();) {
				MemberLink ml = (MemberLink) it2.next();
// System.out.println(ml);
				assert ml.getSource() == importUnit;
			}
		}

		// Now add a new unit and link it.
		Unit member3 = CoreFactory.eINSTANCE.createUnit();
		member3.setName("member3");
		top.getUnits().add(member3);
		MemberLink link3 = CoreFactory.eINSTANCE.createMemberLink();
		link3.setSource(group);
		link3.setTarget(member3);
		link3.setName("dlink");
		top.getMemberLinks().add(link3);
		UnitUtil.assignUniqueName(link3);

		// Make sure imported units only own member links that they should own
		for (Iterator it = importDcl.getInstanceConfiguration()
				.getPublicUnits().iterator(); it.hasNext();) {
			Unit importUnit = (Unit) it.next();
			for (Iterator it2 = importUnit.getMemberLinks().iterator(); it2
					.hasNext();) {
				MemberLink ml = (MemberLink) it2.next();
// if (ml.getSource() == null) {
// System.out.println("Problem, imported unit " + importUnit.title()
// + " has a link from <null> to " + ml.getTarget().title());
// System.out.println("Class is " + ml.getClass());
// }
				assert ml.getSource() != null;

// if (ml.getSource() != null && ml.getSource() != importUnit) {
// System.out.println("Problem, imported unit " + importUnit.title()
// + " has a link from " + ml.getSource().title() + " to " +
// ml.getTarget().title());
// }

				assert ml.getSource() == importUnit;
			}
		}

	} // end method testMemberLinksImported

	/**
	 * Tests links contained in the edit topology whose source and target are in
	 * imported topologies.
	 */
	public void testCrossImportedTopologyLinks() throws Exception {
		//
		Topology businessTopEdit = createTopologyWithAllLinkTargetTypes("testCrossImportedTopologyLinks-Business");
		Topology infraTopEdit = createTopologyWithAllLinkTargetTypes("testCrossImportedTopologyLinks-Infra");
		Topology deployTop = createTopology("testCrossImportedTopologyLinks-Deploy");
		Import businessImport = TopologyUtil.importTopology(businessTopEdit,
				deployTop);
		Import infraImport = TopologyUtil.importTopology(infraTopEdit,
				deployTop);
		Topology businessTop = TopologyUtil.resolve(businessImport);
		Topology infraTop = TopologyUtil.resolve(infraImport);
		assert businessTop != null;
		assert infraTop != null;

		Unit businessHost = (Unit) businessTop.resolve("host");
		Unit businessHosted = (Unit) businessTop.resolve("hosted");
		Unit businessGroup = (Unit) businessTop.resolve("group");
		Unit businessMember = (Unit) businessTop.resolve("member");
		Capability businessDependencyTarget = (Capability) businessTop
				.resolve("dependencyTarget/dependencyTarget");
		Requirement businessDependent = (Requirement) businessTop
				.resolve("dependent/dependent");
		assert businessHost != null;
		assert businessHosted != null;
		assert businessGroup != null;
		assert businessMember != null;
		assert businessDependencyTarget != null;
		assert businessDependent != null;

		Unit infraHost = (Unit) infraTop.resolve("host");
		Unit infraHosted = (Unit) infraTop.resolve("hosted");
		Unit infraGroup = (Unit) infraTop.resolve("group");
		Unit infraMember = (Unit) infraTop.resolve("member");
		Capability infraDependencyTarget = (Capability) infraTop
				.resolve("dependencyTarget/dependencyTarget");
		Requirement infraDependent = (Requirement) infraTop
				.resolve("dependent/dependent");
		assert infraHost != null;
		assert infraHosted != null;
		assert infraGroup != null;
		assert infraMember != null;
		assert infraDependencyTarget != null;
		assert infraDependent != null;

		validate(deployTop);
		assertHasErrorStatus(deployTop);

		LinkFactory.createHostingLink(businessHost, infraHosted);
		LinkFactory.createDependencyLink(businessDependent,
				infraDependencyTarget);
		LinkFactory.createMemberLink(businessGroup, infraMember);

		LinkFactory.createHostingLink(infraHost, businessHosted);
		LinkFactory.createDependencyLink(infraDependent,
				businessDependencyTarget);
		LinkFactory.createMemberLink(infraGroup, businessMember);

		assertEquals(TopologyDiscovererService.INSTANCE.findHost(
				businessHosted, deployTop), infraHost);
		assertEquals(TopologyDiscovererService.INSTANCE.findHost(infraHosted,
				deployTop), businessHost);

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(infraHost,
						deployTop), new Object[] { businessHosted });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findHosted(businessHost,
						deployTop), new Object[] { infraHosted });

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getGroups(infraMember, null,
						deployTop), new Object[] { businessGroup });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getGroups(businessMember,
						null, deployTop), new Object[] { infraGroup });

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getMembers(infraGroup, null,
						deployTop), new Object[] { businessMember });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.getMembers(businessGroup,
						null, deployTop), new Object[] { infraMember });

		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findSources(
						(Unit) infraDependencyTarget.getParent(),
						infraDependencyTarget, deployTop),
				new Object[] { businessDependent.getParent() });
		assertUnitDescriptorListContainsUnitValues(
				TopologyDiscovererService.INSTANCE.findSources(
						(Unit) businessDependencyTarget.getParent(),
						businessDependencyTarget, deployTop),
				new Object[] { infraDependent.getParent() });

		assertEquals(TopologyDiscovererService.INSTANCE.findTarget(
				(Unit) infraDependent.getParent(), infraDependent, deployTop)
				.getUnitValue(), businessDependencyTarget.getParent());
		assertEquals(TopologyDiscovererService.INSTANCE.findTarget(
				(Unit) businessDependent.getParent(), businessDependent,
				deployTop).getUnitValue(), infraDependencyTarget.getParent());

		//
		validate(deployTop);
		assertHasNoErrorStatus(deployTop);
	}

	/**
	 * Creates a topology with all link endpoint types.
	 * <p>
	 * Units and requirements created with the following names
	 * <ul>
	 * <li> host
	 * <li> host/host
	 * <li> hosted
	 * <li> hosted/hosted
	 * <li> group
	 * <li> group/group
	 * <li> member
	 * <li> dependent
	 * <li> dependent/dependent
	 * <li> dependencyTarget
	 * </ul>
	 * 
	 * @param name
	 *            the name of the topology to be created.
	 * @return
	 * @throws Exception
	 */
	private Topology createTopologyWithAllLinkTargetTypes(String name)
			throws Exception {
		//
		Topology top = createTopology(name);

		// Host and hosted units
		Unit hostUnit = addUnit(top, "host");
		addCapability(hostUnit, "host", CapabilityLinkTypes.HOSTING_LITERAL);

		Unit hosted = addUnit(top, "hosted");
		addRequirement(hosted, "hosted", RequirementLinkTypes.HOSTING_LITERAL);

		// Dependendent and dependency-target units
		Unit dependentUnit = addUnit(top, "dependent");
		addRequirement(dependentUnit, "dependent",
				RequirementLinkTypes.DEPENDENCY_LITERAL);

		Unit dependencyTarget = addUnit(top, "dependencyTarget");
		addCapability(dependencyTarget, "dependencyTarget",
				CapabilityLinkTypes.DEPENDENCY_LITERAL);

		// Group and member units
		Unit group = addGroupUnit(top, "group");
		((Requirement) group.getRequirements().get(0)).setName("group");
		addUnit(top, "member");

		save(top);

		return top;
	}

	/**
	 * Tests the {@link Unit} methods to get links are proxied appropriately.
	 * 
	 * @see Unit#getHostingLinks()
	 * @see Unit#getMemberLinks()
	 * @see Unit#getRealizationLinks()
	 * @see Unit#getConstraintLinks()
	 * 
	 * @throws Exception
	 */
	public void testUnitGetXXXLinks() throws Exception {
		//
		// Create topology 1
		//
		Topology top1 = createTopology("testUnitGetXXXLinks-Import");

		Unit u1a = addUnit(top1, "u1a");
		u1a.setConceptual(true);
		Capability c1a = addCapability(u1a, "c1a",
				CapabilityLinkTypes.ANY_LITERAL);
		Requirement r1a = addRequirement(u1a, "r1a",
				RequirementLinkTypes.DEPENDENCY_LITERAL);

		Unit u1b = addUnit(top1, "u1b");
		u1b.setConceptual(true);
		Requirement r1b = addRequirement(u1b, "r1b",
				RequirementLinkTypes.DEPENDENCY_LITERAL);

		ExplicitContract contract = CoreFactory.eINSTANCE
				.createExplicitContract();
		contract.setName("contract");
		top1.setConfigurationContract(contract);
		save(top1);

		//
		// Create topology 2 and import topology 1
		//
		Topology top2 = createTopology("testUnitGetXXXLinks-Edit");
		Import top1Import = TopologyUtil.importTopology(top1, top2);
		Topology importTop1 = TopologyUtil.resolve(top1Import);
		Unit u2 = addUnit(top2, "u2");
		u2.setConceptual(true);
		Capability c2 = addCapability(u2, "c2", CapabilityLinkTypes.ANY_LITERAL);
		Requirement r2 = addRequirement(u2, "r2",
				RequirementLinkTypes.DEPENDENCY_LITERAL);

		Unit importU1a = (Unit) top2.resolve(getGlobalPath(u1a));
		Capability importC1a = (Capability) top2.resolve(getGlobalPath(c1a));
		Requirement importR1a = (Requirement) top2.resolve(getGlobalPath(r1a));
		Unit importU1b = (Unit) top2.resolve(getGlobalPath(u1b));
		Requirement importR1b = (Requirement) top2.resolve(getGlobalPath(r1b));

		HostingLink hl1 = LinkFactory.createHostingLink(importU1a, u2);
		HostingLink hl2 = LinkFactory.createHostingLink(u2, importU1a);
		MemberLink ml1 = LinkFactory.createMemberLink(importU1a, u2);
		MemberLink ml2 = LinkFactory.createMemberLink(u2, importU1a);
		RealizationLink url1 = LinkFactory.createRealizationLink(importU1a, u2);
		RealizationLink url2 = LinkFactory.createRealizationLink(u2, importU1a);
		RealizationLink crl1 = LinkFactory.createRealizationLink(importC1a, c2);
		RealizationLink crl2 = LinkFactory.createRealizationLink(c2, importC1a);
		ConstraintLink ll1 = LinkFactory.createConstraintLink(importU1a, u2);
		ConstraintLink ll2 = LinkFactory.createConstraintLink(u2, importU1a);
		DependencyLink dl1 = LinkFactory.createDependencyLink(importR1a, c2);
		DependencyLink dl2 = LinkFactory.createDependencyLink(r2, importC1a);

		// All links can be found through either topology (imported top1, or
		// top2)
		assertSetEquals(importTop1.findAllHostingLinks(), new Object[] { hl1,
				hl2 });
		assertSetEquals(importTop1.findAllMemberLinks(), new Object[] { ml1,
				ml2 });
		assertSetEquals(importTop1.findAllRealizationLinks(), new Object[] {
				url1, url2, crl1, crl2 });
		assertSetEquals(importTop1.findAllConstraintLinks(), new Object[] { ll1,
				ll2 });
		assertSetEquals(importTop1.findAllDependencyLinks(), new Object[] {
				dl1, dl2 });

		assertSetEquals(top2.findAllHostingLinks(), new Object[] { hl1, hl2 });
		assertSetEquals(top2.findAllMemberLinks(), new Object[] { ml1, ml2 });
		assertSetEquals(top2.findAllRealizationLinks(), new Object[] { url1,
				url2, crl1, crl2 });
		assertSetEquals(top2.findAllConstraintLinks(), new Object[] { ll1, ll2 });
		assertSetEquals(top2.findAllDependencyLinks(),
				new Object[] { dl1, dl2 });

		// Verify that the links sourced on imported objects were created on the
		// topology
		assertSetEquals(top2.getHostingLinks(), new Object[] { hl1 });
		assertSetEquals(top2.getMemberLinks(), new Object[] { ml1 });
		// The factory always creates realization links at the topology level,
		// why?
		assertSetEquals(top2.getRealizationLinks(), new Object[] { url1, url2,
				crl1, crl2 });
		assertSetEquals(top2.getDependencyLinks(), new Object[] { dl1 });

		// No links have "bled-in" to u1b
		assertSetEquals(importU1b.getHostingLinks(), null);
		assertSetEquals(importU1b.getMemberLinks(), null);
		assertSetEquals(importU1b.getRealizationLinks(), null);
		assertSetEquals(importU1b.getConstraintLinks(), null);
		assertTrue(importR1b.getLink() == null);

		// Import u1a can only see its own links
		assertSetEquals(importU1a.getHostingLinks(), new Object[] { hl1 });
		assertSetEquals(importU1a.getMemberLinks(), new Object[] { ml1 });
		assertSetEquals(importU1a.getRealizationLinks(), new Object[] { url1,
				crl1 });
		assertSetEquals(importU1a.getConstraintLinks(), new Object[] { ll1 });
		assertEquals(dl1, importR1a.getLink());

		// u2 can only see its own links
		assertSetEquals(u2.getHostingLinks(), new Object[] { hl2 });
		assertSetEquals(u2.getMemberLinks(), new Object[] { ml2 });
		assertSetEquals(u2.getConstraintLinks(), new Object[] { ll2 });
		assertEquals(dl2, r2.getLink());
	}
	
	/**
	 * Tests the behavior of a set operation on a non-editable attribute.
	 * 
	 * @throws Exception
	 */
	public void XXXtestSetOfNonEditableAttribute() throws Exception {
		String descr1 = "DESCR1";
		String descr2 = "DESCR2";

		//
		// Create a topology top1 with a public unit
		//
		Topology top1 = createTopology("testSetBehavior-Import");
		Unit unit = addUnit(top1, "unit");
		unit.setDescription(descr1);

		ExplicitContract top1Contract = CoreFactory.eINSTANCE
				.createExplicitContract();
		top1.setConfigurationContract(top1Contract);
		top1Contract.export(unit, false);
		save(top1);

		//
		// Create topology top2 importing top1
		//
		Topology top2 = createTopology("testSetBehavior-Edit");
		Import top1Import = TopologyUtil.importTopology(top1, top2);
		Topology importTop1 = TopologyUtil.resolve(top1Import);
		assertNotNull(importTop1);

		ConfigurationContract top1ImportContract = importTop1
				.getConfigurationContract();
		Unit importUnit = (Unit) importTop1.resolve(getGlobalPath(unit));
		assertNotNull(importUnit);
		assertNotSame(unit, importUnit);

		// Verify that the description of the unit is not editable
		assertTrue(top1ImportContract.isPublic(importUnit));
		assertFalse(top1ImportContract.isPublicEditable(importUnit,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName()));

		// Try to change the description
		try {
			importUnit.setDescription(descr2);
			// Error: no exception thrown even though we did not have permission to edit the attribute (silent fail).
			assertTrue("Set on non-editable attribute failed silently", false);
		} catch (RuntimeException e) {
			// OK: verify that the description remains unaltered
			assertEquals(descr1, importUnit.getDescription());
		}
	}

	/**
	 * Tests the validation of a contract.
	 * 
	 * @throws Exception
	 */
	public void testContractValidation() throws Exception {
		String descr1 = "DESCR1";
		String descr2 = "DESCR2";

		//
		// Create topology top1 containing a public editable unit with
		// description DESCR1, and a private unit.
		//
		Topology top1 = createTopology("testContractValidation-Import");
		Unit unit1 = addUnit(top1, "unit1");
		unit1.setDescription(descr1);
		Unit unit2 = addUnit(top1, "unit2");

		ExplicitContract top1Contract = CoreFactory.eINSTANCE
				.createExplicitContract();
		top1.setConfigurationContract(top1Contract);
		top1Contract.export(unit1, true);

		assertTrue(top1Contract.isPublic(unit1));
		assertTrue(top1Contract.isPublicEditable(unit1));
		assertFalse(top1Contract.isPublic(unit2));
		assertFalse(top1Contract.isPublicEditable(unit2));

		save(top1);
		validate(top1);
		assertHasErrorStatus(top1);

		//
		// Create topology top2 importing top1
		//
		Topology top2 = createTopology("testContractValidation-Edit");
		Import top1Import = TopologyUtil.importTopology(top1, top2);
		Topology importTop1 = TopologyUtil.resolve(top1Import);
		assertNotNull(importTop1);
		Unit importUnit1 = (Unit) importTop1.resolve(getGlobalPath(unit1));
		assertNotNull(importUnit1);
		assertNotSame(unit1, importUnit1);

		Unit importUnit2 = (Unit) importTop1.resolve(getGlobalPath(unit2));
		assertNotNull(importUnit2);
		assertNotSame(unit2, importUnit2);

		save(top2);
		validate(top2);
		assertHasNoErrorStatus(top2);

		// Reference the imported topology contract and test that it reports
		// importUnit1 as public editable, and importUnit2 as private
		// non-editable.
		ConfigurationContract top1ImportContract = importTop1
				.getConfigurationContract();
		assertNotSame(top1Contract, top1ImportContract);
		assertTrue(top1ImportContract.isPublic(importUnit1));
		assertTrue(top1ImportContract.isPublicEditable(importUnit1));
		assertTrue(top1ImportContract.isPublicEditable(importUnit1,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName()));
		assertFalse(top1ImportContract.isPublic(importUnit2));
		assertFalse(top1ImportContract.isPublicEditable(importUnit2));
		assertFalse(top1ImportContract.isPublicEditable(importUnit2,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName()));

		//
		// Change the description on the imported unit (permitted because its
		// public editable)
		//
		importUnit1.setDescription(descr2);
		assertEquals(descr2, importUnit1.getDescription());
		assertEquals(descr1, unit1.getDescription());

		validate(top2);
		assertHasNoErrorStatus(top2);

		// Make the imported unit public but NON-EDITABLE
		top1Contract.unexport(unit1);
		top1Contract.export(unit1, false);
		save(top1);

		// Verify that the change has been picked up by the contract and its
		// proxy.
		assertTrue(top1Contract.isPublic(unit1));
		assertFalse(top1Contract.isPublicEditable(unit1, CorePackage.eINSTANCE
				.getDeployModelObject_Description().getName()));
		assertTrue(top1ImportContract.isPublic(importUnit1));
		assertFalse(top1ImportContract.isPublicEditable(importUnit1,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName()));

		// Changing the contract does not "hide" the modified value
		assertEquals(descr2, importUnit1.getDescription());
		assertEquals(descr1, unit1.getDescription());

		// Verify that validation catches this.
		save(top2);
		validate(top2);
		IStatus status = assertHasErrorStatus(
				top2,
				ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_ATTRIBUTE_NOT_EDITABLE);
		
		// Assert that the core resolution for this is found.
		RemoveInstantiationPropertyResolution resolution = null;
		for(IDeployResolution cur : getValidatorService().getResolutions(status)) {
			if (cur instanceof RemoveInstantiationPropertyResolution) {
				resolution = (RemoveInstantiationPropertyResolution) cur;
			}
		}
		assertNotNull(resolution);
		
		// Invoke the resolution to fix error.
		status = resolution.resolve(new NullProgressMonitor());
		assertTrue(getString(status), status.isOK());
		save(top2);
		validate(top2);
		assertHasNoErrorStatus(top2);

		// Make the imported unit private and non-editable
		top1Contract.unexport(unit1);
		save(top1);

		// Export the unit, set desc, and unexport it
		// Leaves crumbs behind in the InstanceConfiguration
		top1Contract.export(unit1, true);
		save(top1);		
		importUnit1.setDescription(descr2);
		top1Contract.unexport(unit1);
		save(top1);		
		// Validate that we create an error for its appearance in the contract
		// instantiation.
		validate(top2);
		status = assertHasErrorStatus(top2,
				ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_NOT_PUBLIC);

		// Find the resolution
		RemoveInstantiationResolution resolution2 = null;
		for(IDeployResolution cur : getValidatorService().getResolutions(status)) {
			if (cur instanceof RemoveInstantiationResolution) {
				resolution2 = (RemoveInstantiationResolution) cur;
			}
		}
		assertNotNull(resolution2);

		// Undo the change
		status = resolution2.resolve(new NullProgressMonitor());
		assertTrue(status.isOK());
		save(top2);
		validate(top2);
		assertHasNoErrorStatus(top2);

		//
		// Test capability editing of public, non-editable capability
		//
		Capability c1 = addCapability(unit1, "c1",
				CapabilityLinkTypes.ANY_LITERAL);
		c1.setDescription(descr1);
		top1Contract.unexport(unit1);
		top1Contract.export(c1, true);
		assertTrue(top1Contract.isPublic(c1));
		assertTrue(top1Contract.isPublicEditable(c1));
		save(top1);

		Capability c1Import = (Capability) importUnit1.getCapabilities().get(0);
		assertNotNull(c1Import);
		assertEquals(c1.getDescription(), c1Import.getDescription());
		validate(top2);
		assertHasNoErrorStatus(top2);

		assertTrue(top1ImportContract.isPublic(c1Import));
		assertTrue(top1ImportContract.isPublicEditable(c1Import));

		// Override the description and check that it it does not cause a validation error.
		c1Import.setDescription(descr2);
		assertEquals(descr2, c1Import.getDescription());
		validate(top2);
		assertHasNoErrorStatus(top2);
		
		// Make capability public non-editable
		top1Contract.unexport(c1);
		top1Contract.export(c1, false);
		save(top1);

		validate(top2);
		assertHasErrorStatus(
				top2,
				ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_ATTRIBUTE_NOT_EDITABLE);

		// Undo the change
		boolean result = ResolutionUtils.removeInstantiationProperty(c1Import,
				CorePackage.eINSTANCE.getDeployModelObject_Description()
						.getName());
		assertTrue(result);
		validate(top2);
		assertHasNoErrorStatus(top2);

		// Make the capability private non-editable
		top1Contract.unexport(c1);
		save(top1);

		validate(top2);
		assertHasErrorStatus(top2,
				ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_NOT_PUBLIC);

		// Undo the change
		result = ResolutionUtils.removeInstantiation(c1Import);
		assertTrue(result);
		validate(top2);
		assertHasNoErrorStatus(top2);
	}
}
