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
import java.math.BigInteger;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.analysis.AnalysisFactory;
import com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint;
import com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.DataServiceType;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType;
import com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint;
import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.analysis.LifespanState;
import com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint;
import com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint;
import com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class AnalysisConstraintTest extends TestCase {

	private static final String PROJECT_NAME = "AnalysisConstraintTest";
		
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
	public void testAnalysisConstraints() throws IOException {
		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME + "/testDeploymentUnitConstraint.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("TestDeploymentUnitConstraint Topology");
		top.setDecoratorSemantic(IAnalysisTemplateConstants.ANALYSIS_DECORATOR_SEMANTIC);

		root.setTopology(top);
		
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		
		// Create Deployment Unit 
		DeployModelObject dmo = rts.createFromTemplate( ANALYSIS_EDU_RESOURCE_ID );
		assert dmo instanceof DeploymentUnit;
		DeploymentUnit du = (DeploymentUnit)dmo;
		top.getUnits().add( du );
		
		//add constraint and set percentage value
		AvailabilityConstraint constraint = AnalysisFactory.eINSTANCE.createAvailabilityConstraint();
		constraint.setPercentage(50);
		du.getConstraints().add( constraint );
		assert du.getConstraints().contains(constraint) == true;
		
		//add constraint
		PeakLoadConstraint pl = AnalysisFactory.eINSTANCE.createPeakLoadConstraint();
		pl.setPeakLoad(new BigInteger("50"));
		du.getConstraints().add( pl );
		assert du.getConstraints().contains(pl) == true;
		
		
		//add constraint
		DailyLoadConstraint dl = AnalysisFactory.eINSTANCE.createDailyLoadConstraint();
		dl.setDailyLoad(new BigInteger("50"));
		du.getConstraints().add( dl );
		assert du.getConstraints().contains(dl) == true;
		
		
		//add constraint
		DataServiceConstraint ds = AnalysisFactory.eINSTANCE.createDataServiceConstraint();
		ds.setType(DataServiceType.ONLINE_INTERACTIVE_LITERAL);
		du.getConstraints().add( ds );
		assert du.getConstraints().contains(ds) == true;
		
		
		//add constraint
		ExecutionServiceConstraint es = AnalysisFactory.eINSTANCE.createExecutionServiceConstraint();
		es.setType(ExecutionServiceType.ONLINE_INTERACTIVE_LITERAL);
		du.getConstraints().add( es );
		assert du.getConstraints().contains(es) == true;
		
		//add constraint
		ExpectedLifespanConstraint els = AnalysisFactory.eINSTANCE.createExpectedLifespanConstraint();
		els.setDuration(25.0);
		els.setState(LifespanState.ACCESSIBLE_LITERAL);
		du.getConstraints().add( els );
		assert du.getConstraints().contains(els) == true;
		
		
		//add constraint
		ExpectedVolumeConstraint evs = AnalysisFactory.eINSTANCE.createExpectedVolumeConstraint();
		evs.setInitialSize(new BigInteger("15"));
		evs.setGrowthRatePercentage(15.5);
		du.getConstraints().add( evs );
		assert du.getConstraints().contains(evs) == true;
		
		//add constraint
		ResponseTimeConstraint rt = AnalysisFactory.eINSTANCE.createResponseTimeConstraint();
		rt.setDuration(10.5);
		rt.setPercentage(95);
		du.getConstraints().add( rt );
		assert du.getConstraints().contains(rt) == true;
		
		
		//add constraint
		SizePerSubmissionConstraint sm = AnalysisFactory.eINSTANCE.createSizePerSubmissionConstraint();
		sm.setBytes(new BigInteger("200"));
		du.getConstraints().add( sm );
		assert du.getConstraints().contains(sm) == true;
		
		//add constraint
		UsageWindowPerDayConstraint uw = AnalysisFactory.eINSTANCE.createUsageWindowPerDayConstraint();
		uw.setDuration(20);
		du.getConstraints().add( uw );
		assert du.getConstraints().contains(uw) == true;
		
		
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
