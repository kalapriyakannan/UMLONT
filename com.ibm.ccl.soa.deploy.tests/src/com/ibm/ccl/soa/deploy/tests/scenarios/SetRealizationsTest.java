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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.GenericConnectedSetRealizationSatisfactionResolution;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.server.IServerTemplateConstants;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class SetRealizationsTest extends TopologyTestCase {

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

	private Unit userUnit;

	private User userCap;

	private Unit db2InstanceUnit;

	private Unit group1;

	private Unit group2;

	private Unit wasSystemUnitConcept;

	private HostingLink hl;

	private boolean createRealizationLinks = true;

	private boolean startComputationFromAllUnits = false;

	private ServerUnit serverUnitConcept;

	private ServerUnit serverUnit;

	private HostingLink serverCOsCHostingLink;

	/** Test case ctor */
	public SetRealizationsTest() {
		super("SetRealizationsTest");
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * Test creating, saving, and validating in one topology.
	 * 
	 * @throws Exception
	 */
	public void testSetRealization() throws Exception {

		String infraTID = IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE;
		String conceptualTID = IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL;

		deployValidatorService = new DeployValidatorService();
		editTopConcept = createTopology("Conceptual", true);
		addExplicitContractDefaultPublic(editTopConcept);
		editTopInfra = createTopology("Infra", true);
		addExplicitContractDefaultPublic(editTopInfra);

		Unit ruFromTemplate = (Unit) ResolutionUtils.addFromTemplate(infraTID, editTopInfra);
		save(editTopInfra);
		assert (editTopInfra.getUnits().size() > 1);
		Unit cuFromTemplate = (Unit) ResolutionUtils.addFromTemplate(conceptualTID, editTopConcept);
		save(editTopConcept);
		assert (editTopConcept.getUnits().size() > 1);

		augmentTemplate(editTopConcept, cuFromTemplate, true);
		save(editTopConcept);
// dumpTopology(editTopConcept);

		augmentTemplate(editTopInfra, ruFromTemplate, false);
		save(editTopInfra);
		
		Iterator i = ValidatorUtils.findAllInstances(editTopConcept, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
		WebsphereAppServerUnit wasAppServerUnitConcept = null;
		if (i.hasNext()) {
			wasAppServerUnitConcept = (WebsphereAppServerUnit) i.next();
		}
		assert (wasAppServerUnitConcept != null);	

		attemptRealizationsStartingAtEachUnit(false, startComputationFromAllUnits, createRealizationLinks);

		// Find was system unit 
		i = ValidatorUtils.findAllInstances(editTopConcept, WasPackage.eINSTANCE.getWasSystemUnit());
		if (i.hasNext()) {
			wasSystemUnitConcept = (Unit) i.next();
		}
		assert (wasSystemUnitConcept != null);

		// TODO fix multi-host test when semantics settle down.
		if (false) {
			// Extra host in conceptual set
			OperatingSystemUnit osUnit = OsFactory.eINSTANCE.createOperatingSystemUnit();
			osUnit.setName("extraHostUnitOS");
			osUnit.setDisplayName("extraHostUnitOS");
			osUnit.setConceptual(true);
			editTopConcept.getUnits().add(osUnit);

			hl = LinkFactory.createHostingLink(osUnit, wasSystemUnitConcept);

			save(editTopConcept);

			attemptRealizationsStartingAtEachUnit(true, startComputationFromAllUnits, createRealizationLinks);

			osUnit.getHostingLinks().remove(hl);
			editTopConcept.getUnits().remove(osUnit);
			save(editTopConcept);

			attemptRealizationsStartingAtEachUnit(false, startComputationFromAllUnits, createRealizationLinks);
		}

		// Extra hosted in conceptual set
		WebsphereAppServerUnit wasUnit2 = WasFactory.eINSTANCE.createWebsphereAppServerUnit();
		wasUnit2.setName("extraHostedUnitwsas");
		wasUnit2.setDisplayName("extraHostedUnitwsas");
		wasUnit2.setConceptual(true);

		editTopConcept.getUnits().add(wasUnit2);
		hl = LinkFactory.createHostingLink(wasSystemUnitConcept, wasUnit2);
		save(editTopConcept);
		attemptRealizationsStartingAtEachUnit(true, startComputationFromAllUnits, createRealizationLinks);

		wasSystemUnitConcept.getHostingLinks().remove(hl);
		editTopConcept.getUnits().remove(wasUnit2);
		save(editTopConcept);

		// Deferred hosting - try with matched and mismatched deferred host
		// server unit
		Server serverC = (Server) ValidatorUtils.getFirstCapability(serverUnitConcept, ServerPackage.eINSTANCE
				.getServer());

		ConstraintLink dhcl = LinkFactory.createConstraintLink(wasAppServerUnitConcept, serverUnitConcept);
		DeferredHostingConstraint dhc = ConstraintFactory.eINSTANCE.createDeferredHostingConstraint();
		dhc.setName("dhc");
		dhcl.getConstraints().add(dhc);
		serverUnitConcept.getHostingLinks().remove(serverCOsCHostingLink);
		save(editTopConcept);
		attemptRealizationsStartingAtEachUnit(false, startComputationFromAllUnits, createRealizationLinks);
		String savedCpuArch = serverC.getCpuArchitecture(); 
		serverC.setCpuArchitecture("power");
		save(editTopConcept);
		attemptRealizationsStartingAtEachUnit(true, startComputationFromAllUnits, createRealizationLinks);
		serverC.setCpuArchitecture(savedCpuArch);
		serverUnitConcept.getHostingLinks().add(serverCOsCHostingLink);
		
		// Extra group
		save(top);

	}

	private void augmentTemplate(Topology editTop, Unit unitToGroup, boolean conceptual) {
		// Augment template with additional complexity
		db2InstanceUnit = (Unit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_INSTANCE_UNIT, editTop);
		group1 = addGroupUnit(editTop, "Group1");
		// Force attribute mismatch
		group1.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
		group2 = addGroupUnit(editTop, "Group2");
		group1.setPublishIntent(PublishIntent.DO_NOT_PUBLISH_LITERAL);
		LinkFactory.createMemberLink(group1, group2);
		LinkFactory.createMemberLink(group2, unitToGroup);
		LinkFactory.createMemberLink(group2, db2InstanceUnit);

		userUnit = (Unit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_USER_UNIT, editTop);
		userCap = (User) ValidatorUtils.getFirstCapability(userUnit, OsPackage.eINSTANCE.getUser());

		LinkFactory.createDependencyLink(ValidatorUtils.getFirstRequirement(db2InstanceUnit, OsPackage.eINSTANCE
				.getUser()), ValidatorUtils.getFirstCapability(userUnit.getCapabilities(), OsPackage.eINSTANCE
				.getUser()));

		OperatingSystemUnit osUnit = null;
		if (conceptual) {
			osUnit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(
					IOsTemplateConstants.OS_WINDOWS_2003_UNIT_CONCEPTUAL, editTop);
		} else {
			osUnit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_WINDOWS_2003_UNIT,
					editTop);
		}
		Iterator i = ValidatorUtils.findAllInstances(editTop, WasPackage.eINSTANCE.getWasSystemUnit());
		WasSystemUnit wasSystemUnit = null;
		if (i.hasNext()) {
			wasSystemUnit = (WasSystemUnit) i.next();
			hl = LinkFactory.createHostingLink(osUnit, wasSystemUnit);
		}
		assert (wasSystemUnit != null);
		LinkFactory.createHostingLink(osUnit, wasSystemUnit);
		
		if (conceptual) {
			serverUnitConcept = (ServerUnit) ResolutionUtils.addFromTemplate(
					IServerTemplateConstants.SERVER_CONCEPTUAL, editTop);
			serverCOsCHostingLink = LinkFactory.createHostingLink(serverUnitConcept, osUnit);
		} else {
			serverUnit = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT,
					editTop);
			LinkFactory.createHostingLink(serverUnit, osUnit);
		}

		// Force everything to specified conceptual flag
		for (Iterator unitIter = editTop.getUnits().iterator(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			u.setConceptual(conceptual);
		}
	}

	private void attemptRealizationsStartingAtEachUnit(boolean failureExpected, boolean startWithAllUnits,
			boolean createRealizationLinks) throws IOException {
		RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
		int conceptualUnitCount = editTopConcept.getUnits().size();
		assert (conceptualUnitCount > 0);

		long startTime = System.currentTimeMillis();

		for (int cuNum = 0; cuNum < conceptualUnitCount; ++cuNum) {

			if (createRealizationLinks || cuNum == 0) {
				top = createTopology(null, true);
				top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);

				importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
				importTopConcept = TopologyUtil.importTopology(editTopConcept, top);

				infraTop = TopologyUtil.resolve(importTopInfra);
				conceptTop = TopologyUtil.resolve(importTopConcept);

				save(top);
			}

			deployValidatorService.validate(top);
			assertNoConceptualUnitsRealized(top);
			List<Unit> conceptualUnits = new ArrayList<Unit>();
			for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
				Unit unit = (Unit) iter.next();
				if (unit.isConceptual()) {
					conceptualUnits.add(unit);
				}
			}
			assert (conceptualUnits.size() == conceptualUnitCount) : conceptualUnits.size() + ":" + conceptualUnitCount;
			Unit cu = conceptualUnits.get(cuNum);
			assert (cu.getStatus().getSeverity() == IStatus.ERROR);
			assert (hasNotRealizedStatus(cu));

			if (!disconnectedUnit(cu)) {
				realizeConnectedSet(cu, failureExpected, createRealizationLinks);
			}

			RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
			RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
			if (!startWithAllUnits)
				break;
		}

		long time = System.currentTimeMillis();
		if (verbose)
			System.out.println(this.getName() + " : Elapsed milliseconds for all realizations = " + (time - startTime)); //$NON-NLS-1$						

	}

	private void realizeConnectedSet(Unit cu, boolean failureExpected, boolean createRealizationLinks) {
		long startTime = System.currentTimeMillis();
		if (verbose) {
			System.out.println("Realizing starting at {" + cu.getCaptionProvider().titleWithContext(cu) + "}");
			System.out.println("Realization -- before"); //$NON-NLS-1$
		}
		Set<Unit> ics = RealizationPatternCacheService.INSTANCE.getImmediateConnectedSet(cu);
		if (verbose) {
			RealizationPatternUtil
					.dumpUnitSet(
							ics,
							"starting at (conceptual=" + cu.isConceptual() + ")" + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		List<Map<Unit,Unit>> csrmList = RealizationPatternCacheService.INSTANCE.realizationMapsConnectedSet(cu, top,
				deployValidatorService, new NullProgressMonitor());
// List csrmList =
// ConnectedSetRealizationMapper.realizationMapsConnectedSet(ics, top,
// deployValidatorService);

		if (csrmList.size() > 0) {
			if (verbose && !(((Map) csrmList.get(0)).keySet().size() == ics.size())) {
				System.out.println("+++++ics - size=" + ics.size());
				RealizationPatternUtil.dumpUnitSet(ics, "ics");
				System.out.println("+++++csrmList(0) - size=" + ((Map) csrmList.get(0)).keySet().size());
				RealizationPatternUtil.dumpUnitSet(csrmList.get(0).keySet(), "First realization map keyset");
			}
			assert (((Map) csrmList.get(0)).keySet().size() >= ics.size()) : ((Map) csrmList.get(0)).keySet().size() +
					" : " + ics.size();
		} else {
			if (!failureExpected) {
				// TODO current set realization does not return result for
				// disconnected unit or unit only connected with
				// constraint link
				if (!disconnectedUnit(cu)) {
					String msg = "No connected set realizations for conceptual unit " +
					cu.getCaptionProvider().titleWithContext(cu);
					System.out.println(msg);
					assert (false) : msg;
				}
			}
		}

		if (createRealizationLinks && csrmList.size() > 0) {
			realize(csrmList.get(0), cu);
		} else {
			if (verbose) {
				System.out.println("No realization maps for - " + cu.getCaptionProvider().titleWithContext(cu));
			}
		}

		if (createRealizationLinks) {
			if (verbose) {
				System.out.println("Realization -- after"); //$NON-NLS-1$
				RealizationPatternUtil
						.dumpUnitSet(
								RealizationPatternCacheService.INSTANCE.getImmediateConnectedSet(cu),
								"starting at (conceptual=" + cu.isConceptual() + ")" + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (!failureExpected && !disconnectedUnit(cu)) {
//				System.out.println("cu - " + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ 				
				assertAllNonDisconnectedConceptualUnitsRealized(top);
			} else {
				assertNoConceptualUnitsRealized(top);
			}
		}
		long time = System.currentTimeMillis();
		if (verbose)
			System.out.println(this.getName() +
					" : Elapsed milliseconds for connected set realization = " + (time - startTime)); //$NON-NLS-1$						
	}

	private boolean disconnectedUnit(Unit u) {
		if (RealizationPatternCacheService.INSTANCE.getMostRealizedHost(u, top) != null ||
				RealizationPatternCacheService.INSTANCE.getMostRealizedHosted(u, top).size() > 0 ||
				RealizationPatternCacheService.INSTANCE.getMostRealizedGroups(u, top).size() > 0 ||
				RealizationPatternCacheService.INSTANCE.getMostRealizedMembers(u, top).size() > 0) {
			return false;
		}
		for (Capability c : (List<Capability>) u.getCapabilities()) {
			if (RealizationPatternCacheService.INSTANCE.getMostRealizedDependencyLinkSources(c, top).size() > 0) {
				return false;
			}
		}
		for (Requirement r : (List<Requirement>) u.getRequirements()) {
			if (RealizationPatternCacheService.INSTANCE.getMostRealizedDependencyLinkTarget(r, top) != null) {
				return false;
			}
		}
		return true;
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

	private void assertAllNonDisconnectedConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int unrealizedConceptualUnitErrorCount = 0;
		int disconnectedUnrealizedUnitCount = 0;
		int unitCount = 0;

		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			++unitCount;
			if (unit.isConceptual()) {
				if (unit.getStatus().getSeverity() == IStatus.ERROR) {
					for (Iterator iter2 = new FilterIterator(new StatusIterator(unit.getStatus()),
							StatusIterator.DEPLOY_STATUS_FILTER); iter2.hasNext();) {
						IDeployStatus deployStatus = (IDeployStatus) iter2.next();
						if (deployStatus.getValidatorID().equals(IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
							if (disconnectedUnit(unit)) {
								++disconnectedUnrealizedUnitCount;
							} else {
								++unrealizedConceptualUnitErrorCount;
							}
						}
					}
				}
			}
		}
		assert (unrealizedConceptualUnitErrorCount == 0) : unrealizedConceptualUnitErrorCount;
		assert (disconnectedUnrealizedUnitCount < unitCount);
	}

	private void assertNoConceptualUnitsRealized(Topology top) {
		deployValidatorService.validate(top);
		int conceptualUnitCount = 0;
		int conceptualUnitNotRealizedCount = 0;
		Set<Unit> notRealizedSet = new HashSet();

		int i=0;
		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			System.out.println("["+(i++)+"]: " + unit.getClass() + ": " + unit.getName() + " from " + unit.getTopology().getName() + " (" + unit.getStatus().getMessage() + ")"); 
			if (unit.isConceptual()) {
				++conceptualUnitCount;
				boolean conceptualUnitNotRealized = false;
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

	private IStatus realize(Map<Unit,Unit> rMap, Unit cu) {
// public DeployResolutionContext(IDeployStatus status, DeployValidatorService
// validator) {
		assert rMap.keySet().size() > 0;
		boolean haveRealizedSet = false;
		for (StatusIterator si = new StatusIterator(cu); si.hasNext();) {
			IStatus is = si.next();
			if (is instanceof IDeployStatus) {
				IDeployStatus ids = (IDeployStatus) is;
				if (ids.getProblemType().equals(ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED)) {
					GenericConnectedSetRealizationSatisfactionResolution gcsrr = new GenericConnectedSetRealizationSatisfactionResolution(
							new DeployResolutionContext(ids, this.deployValidatorService, null), null, cu, cu, rMap);
					gcsrr.resolve(null);
					haveRealizedSet = true;
					break;
				}
			}
		}
		assert haveRealizedSet;
// GenericConnectedSetRealizationSatisfactionResolution(IDeployResolutionContext
// context,
// IDeployResolutionGenerator generator, Unit sourceUnit, Unit targetUnit,
// Map connectedSetRealizationMap)
// for (Iterator rMapIter = rMap.keySet().iterator(); rMapIter.hasNext();) {
// Unit source = (Unit) rMapIter.next();
// Unit target = (Unit) rMap.get(source);
// LinkFactory.createRealizationLink(source, target);
// }

		return Status.OK_STATUS;
	}

}
