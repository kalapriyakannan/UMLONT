package com.ibm.ccl.soa.deploy.uml.test;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;

import com.ibm.ccl.soa.deploy.analysis.internal.validator.IAnalysisProblemType;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.test.workspaces.UmlTestWorkspace;
import com.ibm.xtools.uml.navigator.ModelElementDescriptor;
import com.ibm.xtools.uml.navigator.ModelServerElement;

/**
 * Tests that exercise the UML domain unit providers.
 * @since 1.0
 */
public class UMLProviderTest extends TestCase {

	private static final String PROJECT_NAME = "UMLProviderTest";
	

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());

		UmlTestWorkspace.init();
		
	}

	/**
	 * @throws IOException
	 */
	public void testUmlUnitProviders() throws IOException {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/uml.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("UML Topology");

		root.setTopology(top);

		// Component provider
		// Use live component from UML project
		Component compA = UmlTestWorkspace.getComponentA();
		
		ModelElementDescriptor desc = new ModelElementDescriptor(compA);
		ModelServerElement elem = new ModelServerElement(desc);

		// Load object from provider
		Object obj = verifyProviderResolved( elem );
		assert obj instanceof SoftwareComponent;
		SoftwareComponent umlcomp = (SoftwareComponent)obj;
		assert umlcomp.getName().equals(compA.getName());
		top.getUnits().add( umlcomp );
		
		// Verify proper capability has been added to unit
		Capability cap = CapabilityUtil.findCapabilityOfType(
				umlcomp, UmlPackage.eINSTANCE.getUMLComponent() );
		assert cap != null;
		
		// Actor provider
		// TODO update UmlTestWorkspace to have an actor
		Actor actorA = UMLFactory.eINSTANCE.createActor();
		actorA.setName("ActorA");
		desc = new ModelElementDescriptor(actorA);
		elem = new ModelServerElement(desc);		
		
		obj = verifyProviderResolved( elem );
		assert obj instanceof UMLActorUnit;
		UMLActorUnit umlactor = (UMLActorUnit)obj;
		assert umlactor.getName().equals(actorA.getName());
		top.getUnits().add( umlactor );
		
		// Test binding validation
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		Set set = new HashSet();
		set.add(ICoreProblemType.BOUND_UNIT_PROVIDER_NOT_FOUND);
		assert !checkTopologyProblemTypesInSet(top, set);
		
		umlcomp.setOrigin("Not A Provider");
		validator.validate(top);
		assert checkTopologyProblemTypesInSet(top, set);
		
		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		assert topology.getUnits().size() > 0;

		res.unload();
		

	}
	
	protected Object verifyProviderResolved(Object obj) {
		
		IUnitProviderService ips = ExtensionsCore.createProviderService();
		
		UnitProvider[] provs = ips.findEnabledProvidersByInputOnly(obj);
		if (provs.length == 0) {
			Assert.fail("No Unit Providers found");
		}
		
		for (int i = 0; i < provs.length; i++) {
			UnitProvider provider = provs[i];
			TopologyUnitStub[] stubs = provider.resolveStubs(obj);
			for (int j = 0; j < stubs.length; j++) {
				Object[] objs = provider.resolveUnit(stubs[j], false, null);
				for (int k = 0; k < objs.length; k++) {
					return objs[k];
				}
			}
		}
		Assert
				.fail("Unit Providers failed to resolve DeployModelObject."
						+ obj);
		return null;
	}
	
	protected static boolean checkTopologyProblemTypesInSet(Topology top, Set set) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (set.contains((deployStatus.getProblemType()))) {
					System.out.println("Problem type in  set : "
							+ deployStatus.getProblemType() + " ("
							+ obj.getName() + ")");
					return true;
				}
			}
		}
		return false;
	}


}
