/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.GenericStackRealizationSatisfactionResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class StackRealizationsFromTemplatesTest extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Topology top;
	private Import importTopConcept;
	private Import importTopInfra;
	private Topology editTopConcept;
	private Topology editTopInfra;
	private Topology conceptTop;
	private Topology infraTop;
	private DeployValidatorService deployValidatorService;
	boolean verbose = false;

	/** Test case ctor */
	public StackRealizationsFromTemplatesTest() {
		super("StackRealizationsFromTemplatesTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Test creating, saving, and validating in one topology.
	 * 
	 * @throws Exception
	 */
	public void testRealizationFromTemplates() throws Exception {
		deployValidatorService = new DeployValidatorService();

		realizeConceptualToInfra(IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE,
				IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL);
		realizeConceptualToInfra(
				IWasTemplateConstants.WAS_6_DISTRIBUTED_BUNDLE,
				IWasTemplateConstants.WAS_6_DISTRIBUTED_BUNDLE_CONCEPTUAL);
		realizeConceptualToInfra(
				IWasTemplateConstants.WAS_6_APPLICATION_SERVER_PROFILE_CONCEPTUAL,
				IWasTemplateConstants.WAS_6_APPLICATION_SERVER_PROFILE);
		realizeConceptualToInfra(
				IWasTemplateConstants.WAS_6_DEPLOYMENT_MANAGER_PROFILE_CONCEPTUAL,
				IWasTemplateConstants.WAS_6_DEPLOYMENT_MANAGER_PROFILE);
		realizeConceptualToInfra(
				IWasTemplateConstants.WAS_6_ND_APPLICATION_SERVER_BUNDLE_CONCEPTUAL,
				IWasTemplateConstants.WAS_6_ND_APPLICATION_SERVER_BUNDLE);
	}

	private void realizeConceptualToInfra(String conceptualTID, String infraTID)
			throws IOException {

		if (verbose)
			System.out
					.println("Realizing " + conceptualTID + " to " + infraTID);
		long prevTime = System.currentTimeMillis();
		editTopConcept = createTopology("Conceptual", true);
		editTopInfra = createTopology("Infra", true);

		ResolutionUtils.addFromTemplate(infraTID, editTopInfra);
		save(editTopInfra);
		assert (editTopInfra.getUnits().size() > 1);
		ResolutionUtils.addFromTemplate(conceptualTID, editTopConcept);
		save(editTopConcept);
		assert (editTopConcept.getUnits().size() > 1);

		int conceptualUnitCount = editTopConcept.getUnits().size();
		assert (conceptualUnitCount > 0);

		for (int cuNum = 0; cuNum < conceptualUnitCount; ++cuNum) {

			top = createTopology("TemplateRealizations", true);
			top
					.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);

			importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
			importTopConcept = TopologyUtil.importTopology(editTopConcept, top);

			infraTop = TopologyUtil.resolve(importTopInfra);
			conceptTop = TopologyUtil.resolve(importTopConcept);

			save(top);

			deployValidatorService.validate(top);
			assertNoConceptualUnitsRealized(top);
			List<Unit> conceptualUnits = new ArrayList<Unit>();
			for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
				Unit unit = (Unit) iter.next();
				if (unit.isConceptual()) {
					conceptualUnits.add(unit);
				}
			}
			assert (conceptualUnits.size() == conceptualUnitCount);
			Unit cu = conceptualUnits.get(cuNum);
			assert (cu.getStatus().getSeverity() == IStatus.ERROR);
			assert (cu.getStatus() instanceof IDeployStatus);
			IDeployStatus status = (IDeployStatus) cu.getStatus();
			assert (status.getValidatorID()
					.equals(IDeployCoreValidators.CONCEPTUAL_UNIT_001));
			realizeHostingStack(cu);

			assertAllConceptualUnitsRealized(top);
		}
		long time = System.currentTimeMillis();
		if (verbose)
			System.out
					.println(this.getName()
							+ " : Elapsed milliseconds for all realizations = " + (time - prevTime)); //$NON-NLS-1$						

		save(top);

	}

	private void realizeHostingStack(Unit cu) {

		GenericStackRealizationSatisfactionResolutionGenerator gsrsrg = new GenericStackRealizationSatisfactionResolutionGenerator();

		if (verbose) {
			System.out.println("Realizing starting at {"
					+ cu.getCaptionProvider().titleWithContext(cu) + "}");
			System.out.println("Realization -- before"); //$NON-NLS-1$
			RealizationPatternUtil
					.dumpUnitSet(
							RealizationPatternUtil.getImmediateConnectedSet(cu, RealizationPatternCacheService.INSTANCE),
							"starting at (conceptual=" + cu.isConceptual() + ")" + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IStatus status = cu.getStatus();
		assert (!status.isOK());
		IDeployResolutionContext context = new DeployResolutionContext(
				(IDeployStatus) status, deployValidatorService, null);
		if (gsrsrg.hasResolutions(context)) {
			IDeployResolution[] gsrsrArray = gsrsrg.getResolutions(context);
			if (gsrsrArray.length > 0) {
				gsrsrArray[0].resolve(null);
			} else {
				if (verbose)
					System.out.println("No realization resolutions");
			}
		}
		if (verbose) {
			System.out.println("Realization -- after"); //$NON-NLS-1$
			RealizationPatternUtil
					.dumpUnitSet(
							RealizationPatternUtil.getImmediateConnectedSet(cu, RealizationPatternCacheService.INSTANCE),
							"starting at (conceptual=" + cu.isConceptual() + ")" + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private void assertAllConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int unrealizedConceptualUnitError = 0;

		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (unit.isConceptual()) {
				if (unit.getStatus().getSeverity() == IStatus.ERROR) {
					assert (unit.getStatus() instanceof IDeployStatus);
					IDeployStatus status = (IDeployStatus) unit.getStatus();
					if (status.getValidatorID().equals(
							IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
						++unrealizedConceptualUnitError;
					}
				}
			}
		}
		assert (unrealizedConceptualUnitError == 0);
	}

	private void assertNoConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int conceptualUnitCount = 0;

		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (unit.isConceptual()) {
				++conceptualUnitCount;
				boolean conceptualUnitNotRealized = false;
				if (unit.getStatus().getSeverity() == IStatus.ERROR) {
					assert (unit.getStatus() instanceof IDeployStatus);
					IDeployStatus status = (IDeployStatus) unit.getStatus();
					if (status.getValidatorID().equals(
							IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
						conceptualUnitNotRealized = true;
					}
				}
				assert (conceptualUnitNotRealized == true);
			}
		}
		assert (conceptualUnitCount > 0);
	}

}
