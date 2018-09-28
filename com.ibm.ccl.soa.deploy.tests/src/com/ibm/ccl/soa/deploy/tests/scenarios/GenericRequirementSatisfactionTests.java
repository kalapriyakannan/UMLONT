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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.GenericRealizationSatisfactionResolutionGenerator;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Tests some single-unit link suggestion resolutions. Currently only tests single-unit realization.
 * 
 * TODO add other tests. 
 * 
 */
public class GenericRequirementSatisfactionTests extends TopologyTestCase {

	/** Platform path to test topology files. */
	private static final String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/genericReqSatTest";

	private static final String DEFERRED_HOSTING_REALIZATION_VALIDITY = URL_PREFIX
			+ "/deferred_hosting_realization_validity.topology";

	/**
	 * 
	 */
	public GenericRequirementSatisfactionTests() {
		super("AutoRealizationTests");
		setDeleteProjectOnTearDown(false);
	}

	/**
	 * Test single unit realization resolution, with deferred hosting restricting number of valid solutions
	 * 
	 * @throws Exception
	 */
	public void testDeferredHostingToServerRealizationValidity() throws Exception {
		Topology top = loadTopologyAndShuffleUnits(GenericRequirementSatisfactionTests.DEFERRED_HOSTING_REALIZATION_VALIDITY);
		assert top.getConfigurationContract() != null;

		DB2RuntimeClientUnit db2rcUC = null;
		UserUnit uuC = null;
		for (Unit u : (List<Unit>) top.getUnits()) {
			if (!u.isConceptual()) {
				continue;
			}
			if (u instanceof DB2RuntimeClientUnit) {
				db2rcUC = (DB2RuntimeClientUnit) u;
				break;
			}
		}
		assert (db2rcUC != null);

		// Baseline expect 1 solution
		assertNSingleUnitRealizationResolutions(db2rcUC, top, 1);
		
		Collection<ConstraintLink> clColl = top.getRelationships().getConstraintLinkTargetsLinks(db2rcUC);
		assert(clColl.size() == 1);
		assert(clColl.iterator().next().getConstraints().size() == 1);
		assert(clColl.iterator().next().getConstraints().get(0) instanceof DeferredHostingConstraint);
		EcoreUtil.delete(clColl.iterator().next());
		// With no deferred hosting constraint link, expect n
		assertNSingleUnitRealizationResolutions(db2rcUC, top, 2);
	}
	
	private static void assertNSingleUnitRealizationResolutions(Unit u, Topology top, int expectedSingleUnitRealizationResolutionCount) {
		DeployValidatorService deployValidatorService = new DeployValidatorService();
		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
//		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		GenericRealizationSatisfactionResolutionGenerator grsrg = new GenericRealizationSatisfactionResolutionGenerator();
		IStatus status = u.getStatus();
		assert (!status.isOK());
		StatusIterator si = new StatusIterator(status);
		boolean foundGrrsg = false;
		for (; si.hasNext();) {
			IStatus s = si.next();
			if (s instanceof IDeployStatus) {
				IDeployResolutionContext context = new DeployResolutionContext((IDeployStatus) s, deployValidatorService, null);
				if (grsrg.hasResolutions(context)) {
					foundGrrsg = true;
					IDeployResolution[] grsrgArray = grsrg.getResolutions(context);
					assert (grsrgArray.length == expectedSingleUnitRealizationResolutionCount) : grsrgArray.length;
				}
			}
		}
		assert foundGrrsg;
	}

	private static int conceptualUnitCount(Topology top) {
		int conceptualUnitCount = 0;

		for (Iterator<Unit> iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = iter.next();
			if (unit.isConceptual()) {
				++conceptualUnitCount;
			}
		}
		return conceptualUnitCount;
	}

	private Collection<Unit> conceptualUnitsInTopology(Topology top) {
		Set<Unit> retval = new HashSet<Unit>();
		for (Iterator<Unit> iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = iter.next();
			if (unit.isConceptual()) {
				retval.add(unit);
			}
		}
		return retval;
	}

	private void shuffleList(List l) {
		// int inithc = l.hashCode();
		// Collections.shuffle(l);
		if (l.size() > 1) {
			List nl = new ArrayList<Unit>(l);
			Collections.shuffle(nl);
			l.clear();
			l.addAll(nl);
		}
		// int newhc = l.hashCode();
		// if (l.size() > 2) {
		// System.out.println("size=" + l.size() + " hci:" + inithc + " hcn:" + newhc);
		// }
	}

	/*
	 * This is intended to randomize the order that various list iterators in the topology return results.
	 * 
	 */
	protected void shuffleTop(Topology top) {
		shuffleList(top.getUnits());
		shuffleList(top.getUnitLinks());
		shuffleList(top.getRealizationLinks());
		shuffleList(top.getConstraintLinks());
		shuffleList(top.getAttributeMetaData());
		shuffleList(top.getDependencyLinks());

		shuffleUnitListsInTop(top);
	}

	private void shuffleUnitListsInTop(Topology top) {
		for (Unit u : (List<Unit>) top.getUnits()) {
			shuffleList(u.getArtifacts());
			shuffleList(u.getAttributeMetaData());
			shuffleList(u.getCapabilities());
			shuffleList(u.getConstraintLinks());
			shuffleList(u.getConstraints());
			shuffleList(u.getExtendedAttributes());
			shuffleList(u.getHostingLinks());
			shuffleList(u.getMemberLinks());
			shuffleList(u.getRealizationLinks());
			shuffleList(u.getRequirements());
			shuffleList(u.getUnitLinks());
		}
	}

	private Topology loadTopologyAndShuffleUnits(String url) throws IOException {
		Topology top = loadTopology(url);
		shuffleTop(top);
		return top;
	}

}
