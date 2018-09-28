/*******************************************************************************
 * Copyright (c) 2005,2006 IBM Corporation
 * Licensed Material - Property of IBM. All rights reserved. 
 * US Government Users Restricted Rights - Use, duplication or disclosure  v1.0
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * JUnit test case which reads an existing two machine trade6 stack from a CMDB
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class Trade6WASDB2StacksFromCMDBProviderTest extends TopologyTestCase {


	private Topology top;
	private Resource res;
	private DeployValidatorService deployValidatorService;

	/** Test case ctor */
	public Trade6WASDB2StacksFromCMDBProviderTest() {
		super("Trade6WASDB2StacksFromCMDBProviderTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Populates the topology with the Plants by WebSphere objects.
	 * @throws InterruptedException 
 	 */
	public void addTrade6Objects() throws InterruptedException {
//		createDB2Stack("RF09 (WindowsComputerSystem)");
		createDB2Stack("rf09.watson.ibm.com (WindowsComputerSystem)");
		int unitCountDB2Stack = top.getUnits().size();
		assert(unitCountDB2Stack > 2);
//		createWebSphereStack("RF11 (WindowsComputerSystem)");
		createWebSphereStack("rf11.watson.ibm.com (WindowsComputerSystem)");		
//		assert(top.getUnits().size() > (unitCountDB2Stack+2));
	}

	private void createDB2Stack(String db2NavigatorRoot) throws InterruptedException {
		List<Unit> units = CMDBProviderTestUtils.resolveByNavigatorPathSubString(db2NavigatorRoot, top);
		for (Unit unit : units) {
			System.out.println("Resolved : " + unit.getCaptionProvider().titleWithContext(unit)); //$NON-NLS-1$
		}
		System.gc();
		Thread.sleep(2000);
		CmdbQueryService.INSTANCE.displayCacheMemoryUsage();
	}
	
	private void createWebSphereStack(String wasNavigatorRoot) throws InterruptedException {
		List<Unit> units;
		units = CMDBProviderTestUtils.resolveByNavigatorPathTail("rf11Node01 (WebSphereNode)", top);
//		assert units.size() > 0;
		for (Unit unit : units) {
			System.out.println("Resolved : " + unit.getCaptionProvider().titleWithContext(unit)); //$NON-NLS-1$
		}
		units = CMDBProviderTestUtils.resolveByNavigatorPathSubString(wasNavigatorRoot, top);
		for (Unit unit : units) {
			System.out.println("Resolved : " + unit.getCaptionProvider().titleWithContext(unit)); //$NON-NLS-1$
		}
		System.gc();
		Thread.sleep(2000);
		CmdbQueryService.INSTANCE.displayCacheMemoryUsage();
	}
	
	/**
	 * @return a full two-server PlantsBy example topology
	 * @throws Exception
	 */
	public Topology createPlantsByDBStackTopology() throws Exception {
		top = createTopology("PlantsByDBStackFromDCMProvider");
		top.setDescription("Plants by WebSphere Database Stack topology from DCM provider");
		
		res = top.getEObject().eResource();
		
		ResourceSet resSet = new ResourceSetImpl();
        res = resSet.createResource(res.getURI());
        DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
        root.setTopology(top);
        res.getContents().add(root);		
		
		addTrade6Objects();
		return top;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void testPlantsDB2StackCmdbProvider() throws Exception {
		deployValidatorService = new DeployValidatorService();
		System.gc();
		Thread.sleep(4000);
		long startMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		createPlantsByDBStackTopology();
		System.gc();
		Thread.sleep(4000);
		long mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.out.println("Total memory delta after building stack(s) = " + (mem-startMem)); //$NON-NLS-1$

		this.save(top);

		runValidations(top);
		
		Topology editTop = createTopology("Edit", true);

		addExplicitContractDefaultPublicEditable(top);
		Import importTop = TopologyUtil.importTopology(top, editTop);

		Topology resolvedTop = TopologyUtil.resolve(importTop);
		
		addExplicitContractDefaultPrivate(editTop);
		this.save(editTop);

		runValidations(editTop);
	}
	
	private void runValidations(Topology top) {
		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));

		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		
		Set<String> expectedValidatorIdsSet = new HashSet<String>();
		expectedValidatorIdsSet.add(IDeployCoreValidators.DEPENDENCY_LINK_003);
		expectedValidatorIdsSet.add(IDB2ValidatorID.DB2_INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER);
		expectedValidatorIdsSet.add(IWasValidatorID.DB2_JDBC_PROVIDER_CLASSPATH_001);

		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		assert(ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedValidatorIdsSet)) : ValidatorTestUtils.getTopologyErrorDescription(top);
		assert(ValidatorTestUtils.topologyValidatorIDSetCover(top, expectedValidatorIdsSet));

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
	}
		
}
