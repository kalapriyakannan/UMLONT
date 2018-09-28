/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.server.IServerTemplateConstants;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.validator.resolution.IncrementWasPortValuesResolution;
import com.ibm.ccl.soa.deploy.was.validator.resolution.IncrementWasPortValuesResolutionGenerator;

/**
 * JUnit test case for two-was-server topology
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class TwoWebsphereApplicationServersFromTemplatesTest extends
		TopologyTestCase {

	// Use instance variables for now
	private Topology top;

	private WasSystemUnit wasSystemUnit;

	private OperatingSystemUnit operatingSystemUnitWAS;

	private ServerUnit serverUnitWAS;

	private WasNodeUnit wasNodeUnit;

	private WasNodeGroupUnit wasNodeGroupUnit;

	private DeployValidatorService deployValidatorService;

	private WebsphereAppServerUnit was6ServerUnit1;

	private WebsphereAppServerUnit was6ServerUnit2;

	private WasCellUnit wasCellUnit;

	/** Test case ctor */
	public TwoWebsphereApplicationServersFromTemplatesTest() {
		super("TwoWebsphereApplicationServersFromTemplatesTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	private void createWASStack() {
		// TODO consider changing to the WAS6 Standalone Server mega-template
		was6ServerUnit1 = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); 
		was6ServerUnit2 = (WebsphereAppServerUnit) ResolutionUtils
				.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); 		
		wasNodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_UNIT, top); 
		wasNodeGroupUnit = (WasNodeGroupUnit) ResolutionUtils.addFromTemplate(
				IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT, top);
		wasCellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(
				IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT, top);

		wasSystemUnit = (WasSystemUnit) ResolutionUtils.addFromTemplate(
				IWasTemplateConstants.WAS_6_SYSTEM_UNIT, top);
		operatingSystemUnitWAS = (OperatingSystemUnit) ResolutionUtils
				.addFromTemplate(IOsTemplateConstants.OS_WINDOWS_2003_UNIT, top); 
		serverUnitWAS = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT, top);	

		ValidatorTestUtils.hosts(serverUnitWAS, operatingSystemUnitWAS);
		ValidatorTestUtils.hosts(operatingSystemUnitWAS, wasSystemUnit);
		ValidatorTestUtils.hosts(wasSystemUnit, wasNodeUnit);
		ValidatorTestUtils.hosts(wasNodeUnit, wasCellUnit);

		OperatingSystem operatingSystemWAS = (OperatingSystem) ValidatorUtils
				.getCapability(operatingSystemUnitWAS, OsPackage.eINSTANCE
						.getOperatingSystem());
		operatingSystemWAS.setHostname("osWAS");

		WasServer was6Server1 = (WasServer) ValidatorUtils.getCapability(
				was6ServerUnit1, WasPackage.eINSTANCE.getWasServer());
		was6Server1.setServerName("server1");

		WasServer was6Server2 = (WasServer) ValidatorUtils.getCapability(
				was6ServerUnit2, WasPackage.eINSTANCE.getWasServer());
		was6Server2.setServerName("server2");

		WasNode wasNode = (WasNode) ValidatorUtils.getCapability(wasNodeUnit,
				WasPackage.eINSTANCE.getWasNode());
		wasNode.setProfileName("default");
		wasNode
				.setProfileLocation("C:\\Program Files\\IBM\\WebSphere\\AppServer\\profiles");

		WasNodeGroup wasNodeGroup = (WasNodeGroup) ValidatorUtils
				.getCapability(wasNodeGroupUnit, WasPackage.eINSTANCE
						.getWasNodeGroup());
		wasNodeGroup.setNodeGroupName("nodegroup1"); // What is the default?
		wasNodeGroup.setIsDefaultType(true);

		MemberLink mlServerInNode1 = CoreFactory.eINSTANCE.createMemberLink();
		mlServerInNode1.setSource(wasNodeUnit);
		mlServerInNode1.setTarget(was6ServerUnit1);
		mlServerInNode1.setName(was6ServerUnit1.getName() + "In"
				+ wasNodeUnit.getName());
		mlServerInNode1.setDisplayName(mlServerInNode1.getName());
		wasNodeUnit.getMemberLinks().add(mlServerInNode1);

		MemberLink mlServerInNode2 = CoreFactory.eINSTANCE.createMemberLink();
		mlServerInNode2.setSource(wasNodeUnit);
		mlServerInNode2.setTarget(was6ServerUnit2);
		mlServerInNode2.setName(was6ServerUnit2.getName() + "In"
				+ wasNodeUnit.getName());
		mlServerInNode2.setDisplayName(mlServerInNode2.getName());
		wasNodeUnit.getMemberLinks().add(mlServerInNode2);

		MemberLink mlNodeInNodeGroup = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeInNodeGroup.setSource(wasNodeGroupUnit);
		mlNodeInNodeGroup.setTarget(wasNodeUnit);
		mlNodeInNodeGroup.setName(wasNodeUnit.getName() + "In"
				+ wasNodeGroupUnit.getName());
		mlNodeInNodeGroup.setDisplayName(mlNodeInNodeGroup.getName());
		wasNodeGroupUnit.getMemberLinks().add(mlNodeInNodeGroup);

		MemberLink mlNodeGroupInCell = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeGroupInCell.setSource(wasCellUnit);
		mlNodeGroupInCell.setTarget(wasNodeGroupUnit);
		mlNodeGroupInCell.setName(wasNodeGroupUnit.getName() + "In"
				+ wasCellUnit.getName());
		mlNodeGroupInCell.setDisplayName(mlNodeGroupInCell.getName());
		wasCellUnit.getMemberLinks().add(mlNodeGroupInCell);

		MemberLink mlNodeInCell = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeInCell.setSource(wasCellUnit);
		mlNodeInCell.setTarget(wasNodeUnit);
		mlNodeInCell.setName(wasNodeUnit.getName() + "In"
				+ wasCellUnit.getName());
		mlNodeInCell.setDisplayName(mlNodeInCell.getName());
		wasCellUnit.getMemberLinks().add(mlNodeInCell);
	}

	/**
	 * @return a two-server WAS stack example topology
	 * @throws Exception
	 */
	public Topology createTwoWASServerTopology() throws Exception {
		top = createTopology("WasTwoServerStackFromTemplates");
		top.setDescription("Two WAS servers in stack from templates");
		createWASStack();
		return top;
	}

	/**
	 * Test creating, saving, and validating.
	 * 
	 * @throws Exception
	 */
	public void testTwoWebsphereApplicationServerFromTemplates()
			throws Exception {
		deployValidatorService = new DeployValidatorService();
		createTwoWASServerTopology();

		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName()
				+ " : Elapsed milliseconds for validation = "
				+ (time - prevTime));
// System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		Set<String> expectedValidatorIDsSet = new HashSet<String>();
		expectedValidatorIDsSet
				.add(IOsDomainValidators.PORT_CONFIG_PORT_CONFLICT_001);
		assert (ValidatorTestUtils.topologyValidatorIDsInSet(top,
				expectedValidatorIDsSet)) : dumpStatus(top);
		assert (ValidatorTestUtils.getTopologyErrorCount(top) > 0);

		resolvePortConflicts();

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName()
				+ " : Elapsed milliseconds for validation = "
				+ (time - prevTime));
		// System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		assert (ValidatorTestUtils.getTopologyErrorCount(top) == 0);

		// --------------------------------------
		// save/load tests.
		Resource res = top.getEObject().eResource();
		res.save(null);

		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName()
				+ " : Elapsed milliseconds for validation = "
				+ (time - prevTime));
		assertNoValidationErrors(topology);
	}

	private void resolvePortConflicts() {

		IncrementWasPortValuesResolutionGenerator iwpvrg = new IncrementWasPortValuesResolutionGenerator();
		List<Unit> hostedPortConfigUnits = ValidatorUtils.getHosted(was6ServerUnit1,
				OsPackage.eINSTANCE.getPortConfigUnit());
		for (Iterator<Unit> pcuIter = hostedPortConfigUnits.iterator(); pcuIter
				.hasNext();) {
			PortConfigUnit pcu = (PortConfigUnit) pcuIter.next();
			for (Iterator pcuCapsIter = ValidatorUtils.getCapabilities(pcu,
					OsPackage.eINSTANCE.getPort()).iterator(); pcuCapsIter
					.hasNext();) {
				Port pcuPortCap = (Port) pcuCapsIter.next();
				IDeployStatus status = (IDeployStatus) pcuPortCap.getStatus();
				IDeployResolutionContext context = new DeployResolutionContext(
						status, deployValidatorService, null);
				if (iwpvrg.hasResolutions(context)) {
					// System.out.println("Found anchor");
					IncrementWasPortValuesResolution iwpvr = new IncrementWasPortValuesResolution(
							context, iwpvrg, CorePackage.eINSTANCE
									.getCommunicationCapability_Port(),
							pcuPortCap);
					iwpvr.resolve(null/* monitor */);
				}
			}
		}

	}
}
