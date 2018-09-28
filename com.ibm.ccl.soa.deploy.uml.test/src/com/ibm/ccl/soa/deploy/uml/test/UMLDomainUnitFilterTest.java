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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitFilterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class UMLDomainUnitFilterTest extends TestCase {

	private static final String PROJECT_NAME = "UMLDomainUnitFilterTest";
	
	private static final String ANALYSIS_COMP_RESOURCE_ID = IAnalysisTemplateConstants.COMPONENT_UNIT;
	private static final String ANALYSIS_NODE_RESOURCE_ID = IAnalysisTemplateConstants.NODE_UNIT;
	private static final String ANALYSIS_LOCATION_RESOURCE_ID = IAnalysisTemplateConstants.LOCATION_UNIT;
	private static final String ANALYSIS_DU_RESOURCE_ID = IAnalysisTemplateConstants.DEPLOYMENTUNIT_UNIT;
	private static final String ANALYSIS_PDU_RESOURCE_ID = IAnalysisTemplateConstants.PRESENTATION_DEPLOYMENTUNIT_UNIT;
	private static final String ANALYSIS_DDU_RESOURCE_ID = IAnalysisTemplateConstants.DATA_DEPLOYMENTUNIT_UNIT;
	private static final String ANALYSIS_EDU_RESOURCE_ID = IAnalysisTemplateConstants.EXECUTION_DEPLOYMENTUNIT_UNIT;
	

	private IProject project;

	protected void setUp() throws Exception {
		super.setUp();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}
	protected void tearDown() throws Exception{
		super.tearDown();
		project.delete(true,new NullProgressMonitor());
	}
	/**
	 * @throws IOException
	 */
	public void testComponentUnitFilter() throws IOException {
		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testComponentUnitUmlFilter.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("testComponentUnitUmlFilter Topology");

		root.setTopology(top);
		
		// create Component
		// create Component
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		DeployModelObject dmo = rts.createFromTemplate(ANALYSIS_COMP_RESOURCE_ID);
		assert dmo instanceof SoftwareComponent;
		SoftwareComponent comp = (SoftwareComponent)dmo;
		top.getUnits().add(comp);
		
		List allIDs = new ArrayList();
		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
		.findEnabledTopologyUnitFiltersByInputOnly(comp);
		for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
			UnitFilter filter = enabledFilters[i].createUnitFilter();			
			List<?> unitElementIDs = filter.getAllowableMemberUnitTypes(comp);	
			if(unitElementIDs != null)
				allIDs.addAll(unitElementIDs);
		}
		
		assert allIDs.contains(IAnalysisTemplateConstants.DEPLOYMENTUNIT_UNIT) == true;
		assert allIDs.contains(IAnalysisTemplateConstants.PRESENTATION_DEPLOYMENTUNIT_UNIT) == true;
		assert allIDs.contains(IAnalysisTemplateConstants.EXECUTION_DEPLOYMENTUNIT_UNIT) == true;
		assert allIDs.contains(IAnalysisTemplateConstants.DATA_DEPLOYMENTUNIT_UNIT) == true;


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
	public void testNodeUnitFilter() throws IOException {
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testNodeUnitUmlFilter.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("TestNodeUnitUmlFilter Topology");

		root.setTopology(top);
		
		// create Component
		// create Component
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		// Create  node 
		DeployModelObject dmo = rts.createFromTemplate( ANALYSIS_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node = (NodeUnit)dmo;
		top.getUnits().add( node );

		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
		.findEnabledTopologyUnitFiltersByInputOnly(node);
		List allIDs = new ArrayList();
		for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
			UnitFilter filter = enabledFilters[i].createUnitFilter();
			List<?> unitElementIDs = filter.getAllowableHostingUnitTypes(node);				
			if(unitElementIDs != null)
				allIDs.addAll(unitElementIDs);
		}
		
		assert allIDs.contains(IAnalysisTemplateConstants.COMPONENT_UNIT) == true;


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
	


}
