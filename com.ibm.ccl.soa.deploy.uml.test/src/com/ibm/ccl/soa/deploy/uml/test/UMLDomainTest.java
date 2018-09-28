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

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;
import com.ibm.ccl.soa.deploy.uml.IUMLTemplateConstants;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit;
import com.ibm.ccl.soa.deploy.uml.UMLPackageUnit;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class UMLDomainTest extends TestCase {

	private static final String PROJECT_NAME = "UMLDomainTest";
	private static final String UML_COMP_RESOURCE_ID = IUMLTemplateConstants.COMPONENT_UNIT;
	private static final String UML_ACTOR_RESOURCE_ID = IUMLTemplateConstants.ACTOR_UNIT;
	private static final String CONC_NODE_RESOURCE_ID = IAnalysisTemplateConstants.NODE_UNIT;
	

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
	public void testUmlDomain() throws IOException {

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
		
		// Test UMLComponent resource type definition (loads template)
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		DeployModelObject dmo = rts.createFromTemplate(UML_COMP_RESOURCE_ID);
		assert dmo instanceof SoftwareComponent;
		SoftwareComponent comp = (SoftwareComponent)dmo;
		top.getUnits().add(comp);

		// Create conceptual node 
		dmo = rts.createFromTemplate( CONC_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node = (NodeUnit)dmo;
		top.getUnits().add( node );
		
		// Host uml component on conceptual node
		ValidatorTestUtils.hosts( node, comp );
		
		// Test UMLActorUnit resource type definition (loads template)
		DeployModelObject dmo1 = rts.createFromTemplate(UML_ACTOR_RESOURCE_ID);
		//DeployModelObject dmo1 = UmlFactory.eINSTANCE.createUMLActorUnit();
		assert dmo1 instanceof UMLActorUnit;
		UMLActorUnit actor = (UMLActorUnit)dmo1;
		top.getUnits().add(actor);
		
		// New up other UML units from factory (no templates yet)
		UMLInterfaceUnit intUnit = UmlFactory.eINSTANCE.createUMLInterfaceUnit();
		top.getUnits().add(intUnit);
		UMLPackageUnit pkgUnit = UmlFactory.eINSTANCE.createUMLPackageUnit();
		top.getUnits().add(pkgUnit);
		
		res.save(null);
		
		// Get the UI binding for the UML component and UML actor
		ResourceTypeUIBindingDescriptor desc = 
			rts.getResourceTypeUIBindingDescriptor(UML_COMP_RESOURCE_ID);
		assert desc != null;
		assert desc.isEnabledForPalette() == true;
		
		desc = 
			rts.getResourceTypeUIBindingDescriptor(UML_ACTOR_RESOURCE_ID);
		assert desc != null;
		assert desc.isEnabledForPalette() == true;
		
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


}
