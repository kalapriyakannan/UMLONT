package com.ibm.ccl.soa.deploy.analysis.test;

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

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.analysis.internal.validator.IAnalysisProblemType;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationProtocolConstraintMappingService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class AnalysisValidationTest extends TestCase {

	private static final String PROJECT_NAME = "AnalysisValidationTest";
	
	private static final String ANALYSIS_COMP_RESOURCE_ID = IAnalysisTemplateConstants.COMPONENT_UNIT;
	private static final String ANALYSIS_EDU_RESOURCE_ID = IAnalysisTemplateConstants.EXECUTION_DEPLOYMENTUNIT_UNIT;
	private static final String ANALYSIS_NODE_RESOURCE_ID = IAnalysisTemplateConstants.NODE_UNIT;
	private static final String ANALYSIS_LOCATION_RESOURCE_ID = IAnalysisTemplateConstants.LOCATION_UNIT;

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
	public void testDeploymentUnitValidation() throws IOException {
		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testDeploymentUnitValidation.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("TestDeploymentUnitValidation Topology");
		top.setDecoratorSemantic(IAnalysisTemplateConstants.ANALYSIS_DECORATOR_SEMANTIC);

		root.setTopology(top);
		
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		
		// Create Deployment Unit 
		DeployModelObject dmo = rts.createFromTemplate( ANALYSIS_EDU_RESOURCE_ID );
		assert dmo instanceof DeploymentUnit;
		DeploymentUnit du = (DeploymentUnit)dmo;
		top.getUnits().add( du );
		
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		Set set = new HashSet();
		set.add(ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);
		assert checkTopologyProblemTypesInSet(top, set);
		
		// create Component

		 dmo = rts.createFromTemplate(ANALYSIS_COMP_RESOURCE_ID);
		assert dmo instanceof SoftwareComponent;
		SoftwareComponent comp = (SoftwareComponent)dmo;
		top.getUnits().add(comp);

		
		ValidatorTestUtils.member( comp, du );
		validator.validate(top);
		assert !checkTopologyProblemTypesInSet(top, set);
		
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
	
	/**
	 * @throws IOException
	 */
	public void testNodeUnitValidation() throws IOException {
		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testNodeUnitValidation.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("TestNodeUnitValidation Topology");
		top.setDecoratorSemantic(IAnalysisTemplateConstants.ANALYSIS_DECORATOR_SEMANTIC);

		root.setTopology(top);
		
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		
		// Create Deployment Unit 
		// Create  node 
		DeployModelObject dmo = rts.createFromTemplate( ANALYSIS_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node1 = (NodeUnit)dmo;
		top.getUnits().add( node1 );
		
		dmo = rts.createFromTemplate( ANALYSIS_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node2 = (NodeUnit)dmo;
		top.getUnits().add( node2);
		
		//Create communication constraint
		//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]					
//		CommunicationConstraint constraint = ConstraintFactory.eINSTANCE.createCommunicationConstraint();
//		constraint.setApplicationLayerProtocol("HTTP");
		ApplicationCommunicationConstraint acc = ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint();
		ApplicationCommunicationProtocolConstraint acpc = ConstraintFactory.eINSTANCE.createApplicationCommunicationProtocolConstraint();
		acpc.setApplicationLayerProtocol(ApplicationCommunicationProtocolConstraintMappingService.HTTP);
		acpc.setName(ApplicationCommunicationProtocolConstraintMappingService.HTTP);
		acc.getConstraints().add(acpc);
		
		//Create ConstraintLink
		//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]					
//		ConstraintLink clink = CoreFactory.eINSTANCE.createConstraintLink();
//		clink.getConstraints().add(constraint);
//		clink.setSource(node1);
//		clink.setTarget(node2);
//		node1.getConstraintLinks().add(clink);
		ConstraintLink cLink = LinkFactory.createConstraintLink(node1, node2);
		cLink.getConstraints().add(acc);
		
		
		// Create  Location 
		dmo = rts.createFromTemplate( ANALYSIS_LOCATION_RESOURCE_ID );
		assert dmo instanceof LocationUnit;
		LocationUnit location1 = (LocationUnit)dmo;
		top.getUnits().add( location1 );
		
		// Create  Location 
		dmo = rts.createFromTemplate( ANALYSIS_LOCATION_RESOURCE_ID );
		assert dmo instanceof LocationUnit;
		LocationUnit location2 = (LocationUnit)dmo;
		top.getUnits().add( location2 );
		
		ValidatorTestUtils.member(location1, node1);	
		ValidatorTestUtils.member(location2, node2);	
		
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		Set set = new HashSet();
		set.add(IAnalysisProblemType.COMMUNICATION_LINK_UNDEFINED);
		assert checkTopologyProblemTypesInSet(top, set);
		
		//Create communication constraint
		//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]					
//		constraint = ConstraintFactory.eINSTANCE.createCommunicationConstraint();
//		constraint.setApplicationLayerProtocol("HTTP");

		NetworkCommunicationConstraint ncc = ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint();
		CommunicationPortConstraint cpc = ConstraintFactory.eINSTANCE.createCommunicationPortConstraint();
		cpc.setPort(ApplicationCommunicationProtocolConstraintMappingService.HTTP_PORT);
		cpc.setName("" + ApplicationCommunicationProtocolConstraintMappingService.HTTP_PORT);
		ncc.getConstraints().add(cpc);
		
		//Create ConstraintLink
		//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]					
//		clink = CoreFactory.eINSTANCE.createConstraintLink();
//		clink.getConstraints().add(constraint);
//		clink.setSource(location1);
//		clink.setTarget(location2);
//		location1.getConstraintLinks().add(clink);
		cLink = LinkFactory.createConstraintLink(location1, location2);
		cLink.getConstraints().add(ncc);

		validator.validate(top);
		assert !checkTopologyProblemTypesInSet(top, set);
		
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
	
	/**
	 * @throws IOException
	 */
	public void testLocationUnitValidation() throws IOException {
		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testLocationUnitValidation.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("TestLocationUnitValidation Topology");
		top.setDecoratorSemantic(IAnalysisTemplateConstants.ANALYSIS_DECORATOR_SEMANTIC);

		root.setTopology(top);
		
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		// Create  Location 
		DeployModelObject dmo = rts.createFromTemplate( ANALYSIS_LOCATION_RESOURCE_ID );
		assert dmo instanceof LocationUnit;
		LocationUnit location = (LocationUnit)dmo;
		top.getUnits().add( location );
		
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		Set set = new HashSet();
		set.add(IAnalysisProblemType.ANALYSIS_INVALID_MEMBERUNIT_IN_GROUPUNIT);
		assert checkTopologyProblemTypesInSet(top, set);
		
		// Create  node 
		dmo = rts.createFromTemplate( ANALYSIS_NODE_RESOURCE_ID );
		assert dmo instanceof NodeUnit;
		NodeUnit node = (NodeUnit)dmo;
		top.getUnits().add( node );

		
		ValidatorTestUtils.member( location, node );
		validator.validate(top);
		assert !checkTopologyProblemTypesInSet(top, set);
		
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
