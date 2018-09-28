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
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.uml.UMLActor;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UMLInterface;
import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;

/**
 * Tests that exercise the UML domain unit providers.
 * @since 1.0
 */
public class UMLCapProviderTest extends TestCase {

	private static final String PROJECT_NAME = "UMLCapProviderTest";
	private static final String COMP_NAME="TestCompName";
	private static final String INT_NAME="TestIntName";
	private static final String PKG_NAME="TestPKGName";
	private static final String ACTOR_NAME="ActorPKGName";
	

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	/**
	 * @throws IOException
	 */
	public void testUmlCapabilityProviders() throws IOException {

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
		
		///////////// Component //////////////////
		Component comp = UMLFactory.eINSTANCE.createComponent();
		comp.setName(COMP_NAME);
		
		// Load object from provider
		Object obj = verifyProviderResolved( comp );
		assert obj instanceof UMLComponent;
		UMLComponent umlcomp = (UMLComponent)obj;
		assert umlcomp.getName().equals(COMP_NAME);
		
		////////////// Interface ///////////////
		Interface interf = UMLFactory.eINSTANCE.createInterface();
		interf.setName(INT_NAME);
		
		// Load object from provider
		obj = verifyProviderResolved( interf );
		assert obj instanceof UMLInterface;
		UMLInterface umlint = (UMLInterface)obj;
		assert umlint.getName().equals(INT_NAME);
		
		///////// Package ///////
		Package pkg = UMLFactory.eINSTANCE.createPackage();
		pkg.setName(PKG_NAME);
		
		// Load object from provider
		obj = verifyProviderResolved( pkg );
		assert obj instanceof UMLPackageCap;
		UMLPackageCap umlpkg = (UMLPackageCap)obj;
		assert umlpkg.getName().equals(PKG_NAME);
		
		///////// Actor ///////
		Actor actor = UMLFactory.eINSTANCE.createActor();
		actor.setName(ACTOR_NAME);
		
		// Load object from provider
		obj = verifyProviderResolved( actor );
		assert obj instanceof UMLActor;
		UMLActor umlActor = (UMLActor)obj;
		assert umlActor.getName().equals(ACTOR_NAME);
		
		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		res.unload();

	}
	
	protected Object verifyProviderResolved(Object inputObj) {
		
		ICapabilityProviderService icps = ExtensionsCore.createCapabilityProviderService();
		
		CapabilityProvider[] provs = icps.findEnabledCapabilityProvidersByInputOnly(inputObj);
		if (provs.length == 0) {
			Assert.fail("No Capability Providers found");
		}
		
		for (int i = 0; i < provs.length; i++) {
			CapabilityProvider provider = provs[i];
			Object objs[] = provider.resolveCapabilities(inputObj);
			for (int j = 0; j < objs.length; j++) {
				Object obj = objs[j];
				if (obj instanceof Capability)
					return obj;
			}
		}
		Assert
				.fail("Capability Providers failed to resolve DeployModelObject."
						+ inputObj);
		return null;
	}


}
