/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.GenericConnectedSetRealizationSatisfactionResolution;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.IJ2EETemplateConstants;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasClassLoaderConfigurationUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Test auto-realization with collocation constraints between conceptual and concrete units
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class SetRealizationsTestWithCollocationConstraints extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */


	private DeployValidatorService deployValidatorService;

	boolean verbose = false;

	private boolean testAllLinkEndpointCombinations = false;

	private int numPasses = 1;

	/** Test case ctor */
	public SetRealizationsTestWithCollocationConstraints() {
		super("SetRealizationsTestWithCollocationConstraints");
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	private void assertAllConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int unrealizedConceptualUnitErrorCount = 0;

		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (unit.isConceptual()) {
				if (unit.getStatus().getSeverity() == IStatus.ERROR) {
					for (Iterator iter2 = new FilterIterator(new StatusIterator(unit.getStatus()),
							StatusIterator.DEPLOY_STATUS_FILTER); iter2.hasNext();) {
						IDeployStatus deployStatus = (IDeployStatus) iter2.next();
						if (deployStatus.getValidatorID().equals(IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
							++unrealizedConceptualUnitErrorCount;
						}
					}
				}
			}
		}
		assert (unrealizedConceptualUnitErrorCount == 0) : unrealizedConceptualUnitErrorCount;
	}

	private void assertNoConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int conceptualUnitCount = 0;
		int conceptualUnitNotRealizedCount = 0;
		Set<Unit> notRealizedSet = new HashSet<Unit>();

		for (Iterator<Unit> iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = iter.next();
			if (unit.isConceptual()) {
				++conceptualUnitCount;
				if (hasNotRealizedStatus(unit)) {
					++conceptualUnitNotRealizedCount;
					notRealizedSet.add(unit);
				}
			}
		}
		if (verbose && !(conceptualUnitNotRealizedCount == conceptualUnitCount)) {
			RealizationPatternUtil.dumpUnitSet(notRealizedSet, "Units Not Realized");
		}
		assert (conceptualUnitNotRealizedCount == conceptualUnitCount) : conceptualUnitNotRealizedCount + ":" +
				conceptualUnitCount;
		assert (conceptualUnitCount > 0);
	}

	private boolean hasNotRealizedStatus(Unit unit) {
		if (unit.getStatus().getSeverity() == IStatus.ERROR) {
			assert (unit.getStatus() instanceof IDeployStatus || unit.getStatus() instanceof MultiStatus);
			for (Iterator iter2 = new FilterIterator(new StatusIterator(unit.getStatus()),
					StatusIterator.DEPLOY_STATUS_FILTER); iter2.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getValidatorID().equals(IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
					return true;
				}
			}
		}
		return false;
	}

	private void dumpTopology(Topology t) {
		System.out.println("Topology " + t.getName());
		for (Iterator unitIter = t.getUnits().iterator(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			System.out.println("(conceptual=" + u.isConceptual() + ") " + u.getCaptionProvider().titleWithContext(u));
		}
	}

	/**
	 * Test constraint links constraining realization choices
	 * 
	 * @throws Exception
	 */
	public void testConstraintLinkValidationAndSetRealizationFromTemplates() throws Exception {
		for (int i=0; i<numPasses ; ++i) {
			singlePassTestConstraintLinkValidationAndSetRealizationFromTemplates(i);
		}
	}
	
	private void singlePassTestConstraintLinkValidationAndSetRealizationFromTemplates(int pass) throws Exception {
		Topology top;

		Import importTopConcept;

		Import importTopInfra;

		Topology editTopConcept;

		Topology editTopInfra;

		Topology conceptTop;

		Topology infraTop;

		String infraTID = IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE;
		String conceptualTID = IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL;

		deployValidatorService = new DeployValidatorService();
		editTopConcept = createTopology("Conceptual" + pass, true);
		addExplicitContractDefaultPublic(editTopConcept);
		editTopInfra = createTopology("Infra" + pass, true);
		addExplicitContractDefaultPublic(editTopInfra);

		Unit ruFromTemplate = (Unit) ResolutionUtils.addFromTemplate(infraTID, editTopInfra);
		save(editTopInfra);
		assert (editTopInfra.getUnits().size() > 1);
		Unit cuFromTemplate = (Unit) ResolutionUtils.addFromTemplate(conceptualTID, editTopConcept);
		save(editTopConcept);
		assert (editTopConcept.getUnits().size() > 1);

		WebsphereAppServerUnit websphereAppServerUnitC = (WebsphereAppServerUnit) getFirstUnitOfType(
				WasPackage.eINSTANCE.getWebsphereAppServerUnit(), editTopConcept, true);
		assert (websphereAppServerUnitC != null);
		EarModule earModule = (EarModule) ResolutionUtils.addFromTemplate(IJ2EETemplateConstants.EAR_COMPONENT,
				editTopConcept);
		LinkFactory.createHostingLink(websphereAppServerUnitC, earModule);

		WasSystemUnit wasSystemUnit = (WasSystemUnit) getFirstUnitOfType(WasPackage.eINSTANCE.getWasSystemUnit(),
				editTopInfra, false);
		assert (wasSystemUnit != null);
		OperatingSystemUnit wasStackOSUnit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_2003_UNIT, editTopInfra);

		LinkFactory.createHostingLink(wasStackOSUnit, wasSystemUnit);

		save(editTopConcept);

		WasSystemUnit wasSystemUnitC = (WasSystemUnit) getFirstUnitOfType(WasPackage.eINSTANCE.getWasSystemUnit(),
				editTopConcept, true);
		assert (wasSystemUnitC != null);

		// First concrete DB2 stack - hosted alone
		{
			DB2InstanceUnit db2InstanceUnit = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(
					IDb2TemplateConstants.DB2_INSTANCE_UNIT, editTopInfra);
			DB2SystemUnit db2SystemUnit = (DB2SystemUnit) ResolutionUtils.addFromTemplate(
					IDb2TemplateConstants.DB2_SYSTEM_UNIT, editTopInfra);
			OperatingSystemUnit db2StackOSUnit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(
					IOsTemplateConstants.OS_WINDOWS_2003_UNIT, editTopInfra);
			LinkFactory.createHostingLink(db2StackOSUnit, db2SystemUnit);
			LinkFactory.createHostingLink(db2SystemUnit, db2InstanceUnit);
		}

		// Second concrete DB2 stack - hosted alone
		DB2InstanceUnit db2InstanceUnit3 = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_INSTANCE_UNIT, editTopInfra);
		DB2SystemUnit db2SystemUnit3 = (DB2SystemUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_SYSTEM_UNIT, editTopInfra);
		OperatingSystemUnit db2StackOSUnit3 = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_2003_UNIT, editTopInfra);
		LinkFactory.createHostingLink(db2StackOSUnit3, db2SystemUnit3);
		LinkFactory.createHostingLink(db2SystemUnit3, db2InstanceUnit3);

		// Third concrete DB2 stack - hosted on same operating system as
		// WAS
		DB2InstanceUnit db2InstanceUnit2 = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_INSTANCE_UNIT, editTopInfra);
		DB2SystemUnit db2SystemUnit2 = (DB2SystemUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_SYSTEM_UNIT, editTopInfra);
		LinkFactory.createHostingLink(wasStackOSUnit, db2SystemUnit2);
		LinkFactory.createHostingLink(db2SystemUnit2, db2InstanceUnit2);

		// Conceptual DB2 stack, with concrete database
		DB2DatabaseUnit db2DatabaseUnit = (DB2DatabaseUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_DATABASE_UNIT, editTopConcept);
		DB2InstanceUnit db2InstanceUnit2C = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_INSTANCE_UNIT_CONCEPTUAL, editTopConcept);
		DB2SystemUnit db2SystemUnitC = (DB2SystemUnit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_SYSTEM_UNIT_CONCEPTUAL, editTopConcept);
		LinkFactory.createHostingLink(db2SystemUnitC, db2InstanceUnit2C);
		LinkFactory.createHostingLink(db2InstanceUnit2C, db2DatabaseUnit);

		Unit realizedConceptualUnit = addUnit(editTopConcept, "RealizedConceptualUnit");
		realizedConceptualUnit.setConceptual(true);
		LinkFactory.createRealizationLink(realizedConceptualUnit, db2InstanceUnit2C);

		save(editTopConcept);
		save(editTopInfra);

// dumpTopology(editTopConcept);

		long startTime = System.currentTimeMillis();
		RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
		int conceptualUnitCount = editTopConcept.getUnits().size();
		assert (conceptualUnitCount > 0);

		top = createTopology("TemplateRealizations" + pass, true);
		top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addExplicitContractDefaultPrivate(top);

		importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
		importTopConcept = TopologyUtil.importTopology(editTopConcept, top);

		infraTop = TopologyUtil.resolve(importTopInfra);
		conceptTop = TopologyUtil.resolve(importTopConcept);
		save(top);

		WasSystemUnit wasSystemUnitCImp = (WasSystemUnit) getFirstUnitOfType(WasPackage.eINSTANCE.getWasSystemUnit(),
				top, true);
		assert (wasSystemUnitCImp != null);

		WasClassLoaderConfigurationUnit wasClassLoaderConfigurationUnitCImp = (WasClassLoaderConfigurationUnit) getFirstUnitOfType(
				WasPackage.eINSTANCE.getWasClassLoaderConfigurationUnit(), top, true);
		assert (wasClassLoaderConfigurationUnitCImp != null);

		DB2SystemUnit db2SysUnitCImp = (DB2SystemUnit) getFirstUnitOfType(Db2Package.eINSTANCE.getDB2SystemUnit(), top,
				true);
		assert (db2SysUnitCImp != null);

		DB2InstanceUnit db2InstanceUnitCImp = (DB2InstanceUnit) getFirstUnitOfType(Db2Package.eINSTANCE
				.getDB2InstanceUnit(), top, true);
		assert (db2InstanceUnitCImp != null);

		Set<DeployModelObject> realizedUnits = RealizationLinkUtil.getRealizes(db2InstanceUnitCImp);
		Unit realizedConceptualUnitImp = (Unit) realizedUnits.iterator().next();

		EarModule earModuleImp = (EarModule) getFirstUnitOfType(J2eePackage.eINSTANCE.getEarModule(), top, false);
		assert (earModuleImp != null);

		DB2DatabaseUnit db2DatabaseUnitImp = (DB2DatabaseUnit) getFirstUnitOfType(Db2Package.eINSTANCE
				.getDB2DatabaseUnit(), top, false);
		assert (db2DatabaseUnitImp != null);

		// Put constraint links in importing topology
		Unit[][] linkEndpoints;
		if (!testAllLinkEndpointCombinations) {
			// Limited tests due to test slowness
			linkEndpoints = new Unit[][] { { db2SysUnitCImp, wasSystemUnitCImp }, //
					{ wasSystemUnitCImp, db2SysUnitCImp }, //
					{ db2DatabaseUnitImp, earModuleImp }, //
					/* { earModuleImp, db2DatabaseUnitImp }, *///
					{ db2DatabaseUnitImp, wasClassLoaderConfigurationUnitCImp }, //
					/* { wasClassLoaderConfigurationUnitCImp, db2DatabaseUnitImp }, *///
					{ realizedConceptualUnitImp, wasClassLoaderConfigurationUnitCImp } //
			/* { wasClassLoaderConfigurationUnitCImp, realizedConceptualUnitImp } */};
		} else {

			Set<Unit> conceptualDB2Stack = getAllStackSetUpIncludingParameter(db2SysUnitCImp, top);
			Set<Unit> conceptualWASStack = getAllStackSetUpIncludingParameter(wasSystemUnitCImp, top);
			linkEndpoints = new Unit[conceptualDB2Stack.size() * conceptualWASStack.size() * 2][2];
			int ind = 0;
			for (Unit db2StackUnit : conceptualDB2Stack) {
				for (Unit wasStackUnit : conceptualWASStack) {
					linkEndpoints[ind][0] = db2StackUnit;
					linkEndpoints[ind][1] = wasStackUnit;
					++ind;
					// and reverse
					linkEndpoints[ind][0] = wasStackUnit;
					linkEndpoints[ind][1] = db2StackUnit;
					++ind;
				}
			}
		}

		ConstraintLink cl = null;

		for (int i = 0; i < linkEndpoints.length; ++i) {
			deleteRealizationLinks(top);

			// Add collocation link/constraint to indicated point in conceptual
			// stacks.
			if (cl != null) {
				EcoreUtil.remove(cl);
			}
			cl = LinkFactory.createConstraintLink(linkEndpoints[i][0], linkEndpoints[i][1]);
			if (verbose) {
				System.out.println("Testing constraint link from ["
						+ linkEndpoints[i][0].getCaptionProvider().titleWithContext(linkEndpoints[i][0]) + "]["
						+ linkEndpoints[i][0].getCaptionProvider().titleWithContext(linkEndpoints[i][1]) + "]");
			}
			CollocationConstraint cc = ConstraintFactory.eINSTANCE.createCollocationConstraint();
			cc.setName("cc1");
			cc.setCapabilityEType(OsPackage.eINSTANCE.getOperatingSystem());
			cl.getConstraints().add(cc);
			System.out.println("Pass[" + i + "] - " + cl.getName());

			cc.setType(CollocationConstraintTypes.COLLOCATION_LITERAL);
			save(top);
			cycleDefaultRealizationPatternCache();

			// For collocation - expect 1 set realizations for conceptual DB2 stack, 1
			// set realization for conceptual WAS stack
			
			// Exercise validation/resolution just once
			if (i == 0) {
			wrappedValidate(deployValidatorService, top);
			assertHasConnectedSetRealizationStatusCount(wasSystemUnitCImp, 1);
			}
			assertConnectedSetRealizationSolutionCount(wasSystemUnitCImp, 1);
			if (!linkEndpoints[i][0].isConceptual() || !linkEndpoints[i][1].isConceptual()) {
				assertConnectedSetRealizationSolutionCount(db2SysUnitCImp, 3);
				if (i == 0) {
				assertHasConnectedSetRealizationStatusCount(db2SysUnitCImp, 0);
				}
			} else {
				assertConnectedSetRealizationSolutionCount(db2SysUnitCImp, 1);
				if (!alreadyRealized(linkEndpoints[i][0]) && !alreadyRealized(linkEndpoints[i][1])) {
					if (i == 0) {
					assertHasConnectedSetRealizationStatusCount(db2SysUnitCImp, 1);
					}
				}
			}

			if (i == 0) {
			if (linkEndpoints[i][0].isConceptual() && linkEndpoints[i][1].isConceptual()) {
				runSingleStackRealization(wasSystemUnitCImp);
				save(top);
				Unit wasSystemUnitRImp = (Unit) RealizationLinkUtil.getFinalRealization(wasSystemUnitCImp);
				Unit db2SysUnitRImp = (Unit) RealizationLinkUtil.getFinalRealization(db2SysUnitCImp);
				assert (wasSystemUnitRImp != wasSystemUnitCImp);
				assert (db2SysUnitRImp != db2SysUnitCImp);
				Unit wasSystemUnitRImp_OS = ValidatorUtils.findHostInStack(wasSystemUnitRImp, OsPackage.eINSTANCE
						.getOperatingSystemUnit());
				Unit db2SysUnitCImp_OS = ValidatorUtils.findHostInStack(db2SysUnitCImp, OsPackage.eINSTANCE
						.getOperatingSystemUnit());
				assert (wasSystemUnitRImp_OS != null);
				assert (db2SysUnitCImp_OS != null);
				assert (wasSystemUnitRImp_OS == db2SysUnitCImp_OS);
			}

			// Cleanup
			deleteRealizationLinks(top);
			}

			// Switch to anticollocation
			cc.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
			save(top);
			cycleDefaultRealizationPatternCache();

			// Expect baseline set realization counts
//			wrappedValidate(deployValidatorService, top);
//			assertHasConnectedSetRealizationStatusCount(wasSystemUnitCImp, 1);
			assertConnectedSetRealizationSolutionCount(wasSystemUnitCImp, 1);
			if (!linkEndpoints[i][0].isConceptual() || !linkEndpoints[i][1].isConceptual()) {
				assertConnectedSetRealizationSolutionCount(db2SysUnitCImp, 3);
//				assertHasConnectedSetRealizationStatusCount(db2SysUnitCImp, 0);
			} else {
				assertConnectedSetRealizationSolutionCount(db2SysUnitCImp, 1);
//				if (!alreadyRealized(linkEndpoints[i][0]) && !alreadyRealized(linkEndpoints[i][1])) {
//					assertHasConnectedSetRealizationStatusCount(db2SysUnitCImp, 0);
//				}
			}

//			if (linkEndpoints[i][0].isConceptual() && linkEndpoints[i][1].isConceptual()) {
//				runSingleStackRealization(wasSystemUnitCImp);
//				save(top);
//				Unit wasSystemUnitRImp = (Unit) RealizationLinkUtil.getFinalRealization(wasSystemUnitCImp);
//				Unit db2SysUnitRImp = (Unit) RealizationLinkUtil.getFinalRealization(db2SysUnitCImp);
//				assert (wasSystemUnitRImp != wasSystemUnitCImp);
//				assert (db2SysUnitRImp != db2SysUnitCImp);
//				Unit wasSystemUnitRImp_OS = ValidatorUtils.findHostInStack(wasSystemUnitRImp, OsPackage.eINSTANCE
//						.getOperatingSystemUnit());
//				Unit db2SysUnitCImp_OS = ValidatorUtils.findHostInStack(db2SysUnitCImp, OsPackage.eINSTANCE
//						.getOperatingSystemUnit());
//				assert (wasSystemUnitRImp_OS != null);
//				assert (db2SysUnitCImp_OS != null);
//				assert (wasSystemUnitRImp_OS != db2SysUnitCImp_OS);
//			}

		}
		long time = System.currentTimeMillis();
		if (verbose)
			System.out.println(this.getName()
					+ " : Elapsed milliseconds for all constrained realization mappings = " + (time - startTime)); //$NON-NLS-1$						

	}

	private boolean alreadyRealized(Unit u) {
		return (RealizationLinkUtil.getFinalRealization(u) != u);
	}

	private void assertConnectedSetRealizationSolutionCount(Unit u, int i) {
		List<Map<Unit, Unit>> lmuu = RealizationPatternCacheService.INSTANCE.realizationMapsConnectedSet(u, u
				.getEditTopology(), DeployValidatorService.getDefaultValidatorService(), null);
		assert lmuu.size() == i : lmuu.size();
	}

	// Delete the realization links in the topology, 
	// but not the realization links in the imported topologies.
	private void deleteRealizationLinks(Topology topWithRLinks) {
		List<RealizationLink> rLinks = new ArrayList<RealizationLink>(topWithRLinks.getRealizationLinks());
		for (RealizationLink rLink : rLinks) {
			EcoreUtil.delete(rLink);
		}
	}

	private void runSingleStackRealization(Unit startUnit) {
		int connectedSetRealizationResolutionCount = 0;
		assert (hasNotRealizedStatus(startUnit));
		IStatus status = startUnit.getStatus();
		GenericConnectedSetRealizationSatisfactionResolution gcsrsr = null;
		List<IDeployResolution> resolutions = deployValidatorService.getResolutions(status);
		for (IDeployResolution resolution : resolutions) {
			if (resolution instanceof GenericConnectedSetRealizationSatisfactionResolution) {
				++connectedSetRealizationResolutionCount;
				gcsrsr = (GenericConnectedSetRealizationSatisfactionResolution) resolution;
			}
		}
		assert (connectedSetRealizationResolutionCount == 1) : connectedSetRealizationResolutionCount;
		gcsrsr.resolve(null);
	}

	private void assertHasConnectedSetRealizationStatusCount(Unit u, int expectedCount) {
		int connectedSetRealizationResolutionCount = 0;
		assert (hasNotRealizedStatus(u));
		IStatus status = u.getStatus();
		List<IDeployResolution> resolutions = deployValidatorService.getResolutions(status);
		for (IDeployResolution resolution : resolutions) {
			if (resolution instanceof GenericConnectedSetRealizationSatisfactionResolution) {
				++connectedSetRealizationResolutionCount;
			}
		}
//		System.out.println("connectedSetRealizationResolutionCount for " + u.getCaptionProvider().titleWithContext(u) +
//				" = " + connectedSetRealizationResolutionCount);
		assert (connectedSetRealizationResolutionCount == expectedCount) : connectedSetRealizationResolutionCount;

	}

	private static Unit getFirstUnitOfType(EClass eClass, Topology top, boolean conceptual) {
		Iterator<Unit> i = ValidatorUtils.findAllInstances(top, eClass);
		for (; i.hasNext();) {
			Unit u = i.next();
			if (u.isConceptual() == conceptual) {
				return u;
			}
		}
		return null;
	}

	private static void wrappedValidate(DeployValidatorService dvs, Topology top) throws InterruptedException {
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();
		dvs.validate(top);
		TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
	}
	
	private static void cycleDefaultRealizationPatternCache() {
		RealizationPatternCacheService.INSTANCE.leaveRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.leaveRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
	}

	/**
	 * Compute and return set of units hosted by unit or by other units in its realization chain, recursively. Note: returns parameter unit!
	 * 
	 * @param u
	 *            Unit to find all hosted units from
	 * @param top
	 * @return Set of all units hosted by unit or by other units in its realization chain
	 */
	private static Set<Unit> getAllStackSetUpIncludingParameter(Unit u, Topology top) {
		Set<Unit> visited = new HashSet<Unit>();
		return getAllHostedRecursive(u, visited, top);
	}

	// Visited check is for efficiency, not correctness
	private static Set<Unit> getAllHostedRecursive(Unit u, Set<Unit> alreadyVisited, Topology top) {
		Set<Unit> s = new HashSet<Unit>();
		if (alreadyVisited.contains(u)) {
			return s;
		}
		for (DeployModelObject dmo : RealizationLinkUtil.getAllRealizationLinkedObjects(u)) {
			if (dmo instanceof Unit) {
				Unit relLinkedUnit = (Unit) dmo;
				s.add(relLinkedUnit);
				alreadyVisited.add(relLinkedUnit);
				for (Unit hosted : ValidatorUtils.getHosted(relLinkedUnit)) {
					if (!alreadyVisited.contains(hosted)) {
						s.addAll(getAllHostedRecursive(hosted, alreadyVisited, top));
					}
				}
			}
		}
		return s;
	}

	private static Unit getImmediateBottomOfHostingStack(Unit startU) {
		Unit u;
		Unit tmpU = startU;
		do {
			u = tmpU;
			tmpU = ValidatorUtils.getHost(u);
		} while (tmpU != null);
		return u;
	}

}
