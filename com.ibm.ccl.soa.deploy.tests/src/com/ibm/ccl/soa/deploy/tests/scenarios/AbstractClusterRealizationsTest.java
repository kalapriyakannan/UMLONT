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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;

/**
 * JUnit test case for realization of abstract websphere clusters
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class AbstractClusterRealizationsTest extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Import importTopConcept;

	private Import importTopInfra;

	private Topology editTopConcept;

	private Topology editTopInfra;

	private Topology conceptTop;

	private Topology infraTop;

	private DeployValidatorService deployValidatorService;

	boolean verbose = true;

	private boolean createRealizationLinks = true;

	private boolean startComputationFromAllUnits = false;

	private boolean useImports = false;

	private int realizationMappingStartCount = 0;

	private int realizationMappingElapsedTime = 0;

	private int maxRuns = 4;

	private int minServers = 3;

	private int maxServers = 3;

	private int serverIncrement = 1;

	private int startAtUnitCount = 4;

	private int maxInfraClusters = 16;

	/** Platform path to test topology files. */
	String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/wasCluster";

	String ABSTRACT_CONCEPTUAL_ND_CLUSTER_URL = URL_PREFIX + "/AbstractNDCluster.topology";

	String ND_PLUS_DEPLOYMENT_MANAGER_STACK_URL = URL_PREFIX + "/NDPlusDeploymentManager.topology";

	String ABSTRACT_WAS_SERVER_IN_ND_CLUSTER_URL = URL_PREFIX + "/AbstractWASServerInNDCluster.topology";

	String ND_APP_SERVER_STACK_URL = URL_PREFIX + "/NDAppServer.topology";

	/** Test case ctor */
	public AbstractClusterRealizationsTest() {
		super("AbstractClusterRealizationsTest");
		setDeleteProjectOnTearDown(false);
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
	public void testAbstractClusterRealizationFromTemplates() throws Exception {

		deployValidatorService = new DeployValidatorService();

		deployValidatorService = new DeployValidatorService();

		for (int clusterCnt = 1; clusterCnt <= maxInfraClusters; ++clusterCnt) {
			for (int runs = 0; runs < maxRuns; ++runs) {
				for (int serverCnt = minServers; serverCnt <= maxServers; serverCnt += serverIncrement) {
					realizationMappingElapsedTime = 0;
					realizationMappingStartCount = 0;
					editTopConcept = createTopology(serverCnt + "ConceptualServerInfra", true);
					editTopInfra = createTopology(clusterCnt + "_" + serverCnt + "ServerInfra");

					for (int clusterNum = 0; clusterNum < clusterCnt; ++clusterNum) {
						buildCluster(serverCnt, clusterNum, false, editTopInfra);
						assert (editTopInfra.getUnits().size() > 1);
						addIdentityContract(editTopInfra);
						save(editTopInfra);
					}

					buildCluster(serverCnt, clusterCnt, true, editTopConcept);
					assert (editTopConcept.getUnits().size() > 1);
					addIdentityContract(editTopConcept);
					save(editTopConcept);

					if (verbose) {
						System.out.println("Mapping " + editTopConcept.getUnits().size() + " conceptual units to "
								+ editTopInfra.getUnits().size() + " concrete units");
					}
					attemptRealizationsStartingAtEachUnit(false, startComputationFromAllUnits, createRealizationLinks,
							serverCnt, clusterCnt);
					if (verbose) {
						System.out.println("Mean realization mapping time [" + serverCnt + "] servers, [" + clusterCnt
								+ "] clusters = " + realizationMappingElapsedTime / realizationMappingStartCount);
					}
				}
			}
		}
	}

	private void addIdentityContract(Topology top) {
		ExplicitContract ic = CoreFactory.eINSTANCE.createExplicitContract();
		ic.setName("Identity0");
		ic.setDisplayName("Identity contract");
		top.setConfigurationContract(ic);
	}
	
	private void addNullContract(Topology top) {
		ExplicitContract nc = CoreFactory.eINSTANCE.createExplicitContract();
		nc.setName("Null0");
		nc.setDisplayName("Null contract");
		top.setConfigurationContract(nc);
	}	

	private void buildCluster(int appServerCount, int clusterNum, boolean conceptual, Topology targetTop)
			throws IOException {
		Topology top = null;
		if (conceptual) {
			top = loadTopology(ABSTRACT_CONCEPTUAL_ND_CLUSTER_URL);
		} else {
			top = loadTopology(ND_PLUS_DEPLOYMENT_MANAGER_STACK_URL);
		}
		assert (top.getUnits().size() > 0);

		WasNodeUnit dmgrNodeUnit = null;
		WasNodeUnit nodeUnit = null;
		OperatingSystemUnit serverOs = null;
		WebsphereAppServerUnit appServerUnit = null;
		WasClusterUnit clusterUnit = null;
		for (Iterator<Unit> unitsIter = top.getUnits().iterator(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			if (u instanceof WasNodeUnit) {
				dmgrNodeUnit = (WasNodeUnit) u;
			}
			if (u instanceof WasClusterUnit) {
				clusterUnit = (WasClusterUnit) u;
			}
		}
		if (!conceptual) {
			assert (dmgrNodeUnit != null);
		}
		assert (clusterUnit != null);
		WasCluster cluster = (WasCluster) ValidatorUtils.getCapability(clusterUnit, WasPackage.eINSTANCE
				.getWasCluster());
		if (!conceptual) {
			cluster.setClusterName("cluster" + clusterNum);
		}
		for (int i = 0; i < appServerCount; ++i) {
			int prevSize = top.getUnits().size();
			Topology tmpTop;
			if (conceptual) {
				tmpTop = loadTopology(ABSTRACT_WAS_SERVER_IN_ND_CLUSTER_URL);
			} else {
				tmpTop = loadTopology(ND_APP_SERVER_STACK_URL);
			}
			assert ((!conceptual && tmpTop.getUnits().size() > 1) || (conceptual && tmpTop.getUnits().size() >= 1)) : tmpTop.getUnits().size();
			Collection<Unit> c = ResolutionUtils.intelligentDeepCopy(tmpTop.getUnits(), top);
			unloadTopologyInEditingDomain(tmpTop);
			nodeUnit = null;
			for (Iterator<Unit> unitsIter = c.iterator(); unitsIter.hasNext();) {
				Unit u = unitsIter.next();
				if (u instanceof WasNodeUnit) {
					nodeUnit = (WasNodeUnit) u;
				}
				if (u instanceof OperatingSystemUnit) {
					serverOs = (OperatingSystemUnit) u;
				}
				if (u instanceof WebsphereAppServerUnit) {
					appServerUnit = (WebsphereAppServerUnit) u;
				}
			}
			if (!conceptual) {
				WasNode node = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE.getWasNode());
				node.setNodeName("node" + i);
			}
			if (!conceptual) {
				assert (nodeUnit != null);
				assert (serverOs != null);
			}

			assert (appServerUnit != null);
			addUnits(c, top);
			assert (prevSize < top.getUnits().size());
			if (!conceptual) {
				boolean fedStatus = federate(null, dmgrNodeUnit, nodeUnit);
				assert (fedStatus == true);
			}
			MemberLink ml = LinkFactory.createMemberLink(clusterUnit, appServerUnit);
			assert ml != null;
			if (!conceptual) {
				OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(serverOs, OsPackage.eINSTANCE
						.getOperatingSystem());
				osCap.setHostname("ASHost" + i);
			}
		}
		addUnits(ResolutionUtils.intelligentDeepCopy(top.getUnits(), targetTop), targetTop);
		unloadTopologyInEditingDomain(top);
	}

	private void addUnits(Collection<Unit> units, Topology top) {
		for (Iterator<Unit> unitsIter = units.iterator(); unitsIter.hasNext();) {
			Unit unit = unitsIter.next();
			top.getUnits().add(unit);
		}
	}

	private void attemptRealizationsStartingAtEachUnit(boolean failureExpected, boolean startWithAllUnits,
			boolean createRealizationLinks, int serverCount, int clusterCount) throws IOException, CoreException {
		RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
		int conceptualUnitCount = editTopConcept.getUnits().size();
		assert (conceptualUnitCount > 0);

		Topology top = null;
		long startTime = System.currentTimeMillis();

		int tryCount = conceptualUnitCount > startAtUnitCount ? startAtUnitCount : conceptualUnitCount;
		List<Integer> randomizedIndexes = new ArrayList<Integer>();
		for (int i = 0; i < conceptualUnitCount; ++i) {
			randomizedIndexes.add(new Integer(i));
		}
		Collections.shuffle(randomizedIndexes);
		for (int cuNum = 0; cuNum < tryCount; ++cuNum) {
			if (createRealizationLinks || cuNum == 0) {
				top = createTopology(clusterCount + "_" + serverCount + "ServerSetRealization", true);
				top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
				addNullContract(top);

				if (useImports) {
					importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
					importTopConcept = TopologyUtil.importTopology(editTopConcept, top);

					infraTop = TopologyUtil.resolve(importTopInfra);
					conceptTop = TopologyUtil.resolve(importTopConcept);
				} else {
					addUnits(ResolutionUtils.intelligentDeepCopy(editTopInfra.getUnits(), top), top);
					addUnits(ResolutionUtils.intelligentDeepCopy(editTopConcept.getUnits(), top), top);
				}

				save(top);
			}

// deployValidatorService.validate(top);
// assertNoConceptualUnitsRealized(top);
			ArrayList conceptualUnits = new ArrayList();
			for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
				Unit unit = (Unit) iter.next();
				if (unit.isConceptual()) {
					conceptualUnits.add(unit);
				}
			}
			assert (conceptualUnits.size() == conceptualUnitCount) : conceptualUnits.size() + ":" + conceptualUnitCount;
			int index = randomizedIndexes.get(cuNum).intValue();
			Unit cu = (Unit) conceptualUnits.get(index);
// assert (cu.getStatus().getSeverity() == IStatus.ERROR);
// assert (hasNotRealizedStatus(cu));

			realizeConnectedSet(cu, failureExpected, createRealizationLinks, top, serverCount, clusterCount);

			if (!startWithAllUnits)
				break;
		}

		long time = System.currentTimeMillis();
		if (verbose)
			System.out.println(getName() + " : Elapsed milliseconds for all realizations = " + (time - startTime)); //$NON-NLS-1$						

	}

	private void realizeConnectedSet(Unit cu, boolean failureExpected, boolean createRealizationLinks, Topology top,
			int serverCount, int clusterCount) {

// if (verbose) {
// System.out.println("Realizing starting at {" + cu.titleWithContext() + "}");
// System.out.println("Realization -- before"); //$NON-NLS-1$
// }
		RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		Set<Unit> ics = null;
		long startTime = System.currentTimeMillis();
		List<Map<Unit,Unit>> csrmList = RealizationPatternCacheService.INSTANCE.realizationMapsConnectedSet(cu, top,
				deployValidatorService, null);
		{
			long time = System.currentTimeMillis();
			if (verbose)
				System.out.println("Server cnt [" + serverCount + "] infra cluster cnt [" + clusterCount
						+ "] - ms for connected set realization mapping = " + (time - startTime)
						+ " - start {" + cu.getCaptionProvider().titleWithContext(cu) + "}"); //$NON-NLS-1$
			realizationMappingElapsedTime += time - startTime;
			++realizationMappingStartCount;
		}

		ics = RealizationPatternCacheService.INSTANCE.getImmediateConnectedSet(cu);
		if (verbose) {
// RealizationPatternUtil.dumpUnitSet(ics, "starting at (conceptual=" +
// cu.isConceptual() + ")" + cu.titleWithContext()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		assert (csrmList.size() == clusterCount);

		if (csrmList.size() > 0) {
			if (verbose && !(((Map) csrmList.get(0)).keySet().size() == ics.size())) {
				System.out.println("+++++ics - size=" + ics.size());
				RealizationPatternUtil.dumpUnitSet(ics, "ics");
				System.out.println("+++++csrmList(0) - size=" + ((Map) csrmList.get(0)).keySet().size());
				RealizationPatternUtil.dumpUnitSet(csrmList.get(0).keySet(), "First realization map keyset");
			}
			assert (((Map) csrmList.get(0)).keySet().size() == ics.size()) : ((Map) csrmList.get(0)).keySet().size()
					+ " : " + ics.size();
		}

		if (createRealizationLinks && csrmList.size() > 0) {
			realize(csrmList.get(0));
		}

		if (createRealizationLinks) {
			if (verbose) {
				System.out.println("Realization -- after"); //$NON-NLS-1$
				RealizationPatternUtil.dumpUnitSet(
						RealizationPatternCacheService.INSTANCE.getImmediateConnectedSet(cu),
						"starting at (conceptual=" + cu.isConceptual() + ")" + cu.getCaptionProvider().titleWithContext(cu)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (!failureExpected) {
				assertAllConceptualUnitsRealized(top);
			} else {
				assertNoConceptualUnitsRealized(top);
			}
		}
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

		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (unit.isConceptual()) {
				++conceptualUnitCount;
				if (hasNotRealizedStatus(unit)) {
					++conceptualUnitNotRealizedCount;
				}
			}
		}
		assert (conceptualUnitNotRealizedCount == conceptualUnitCount) : conceptualUnitNotRealizedCount + ":"
				+ conceptualUnitCount;
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

	private IStatus realize(Map rMap) {

		for (Iterator rMapIter = rMap.keySet().iterator(); rMapIter.hasNext();) {
			Unit source = (Unit) rMapIter.next();
			Unit target = (Unit) rMap.get(source);
			LinkFactory.createRealizationLink(source, target);
		}

		return Status.OK_STATUS;
	}

	private boolean federate(IDeployResolutionContext context, WasNodeUnit dmgrUnit, WasNodeUnit nodeUnit) {
		WasCell dmgrCell = WasValidationUtil.getWasCell(dmgrUnit);
		WasCell nodeCell = WasValidationUtil.getWasCell(nodeUnit);

		if (dmgrCell == null) {
			return false;
		}

		if (dmgrCell == nodeCell) {
			return true;
		}

		Unit nodeCellUnit = ValidatorUtils.getUnit(nodeCell);
		Unit dmgrCellUnit = ValidatorUtils.getUnit(dmgrCell);
		if (dmgrCellUnit == null) {
			return false;
		}
		// Remove node from its cell
		if (nodeCellUnit != null) {
			ResolutionUtils.removeMemberFromGroup(nodeUnit, nodeCellUnit);
		}

		// Remove node from its node group
		WasNodeGroup nodeGroup = WasValidationUtil.getWasNodeGroup(nodeUnit);
		Unit nodeGroupUnit = ValidatorUtils.getUnit(nodeGroup);
		if (nodeGroupUnit != null) {
			ResolutionUtils.removeMemberFromGroup(nodeUnit, nodeGroupUnit);
		}

		// Reap cell if it was hosted on node
		if ((nodeCellUnit != null) && (ValidatorUtils.hosts(nodeUnit, nodeCellUnit))) {
			ResolutionUtils.removeFromTopology(nodeCellUnit);
		}

		// Reap node group if it is empty
		if ((nodeGroupUnit != null) && (nodeGroupUnit.getMemberLinks().size() == 0)) {
			ResolutionUtils.removeFromTopology(nodeGroupUnit);
		}

		// Add node to dmgr cell
		ResolutionUtils.group(dmgrCellUnit, nodeUnit);
		WasNode node = (WasNode) ValidatorUtils.getFirstCapability(nodeUnit, WasPackage.Literals.WAS_NODE);
		if (node != null) {
			node.setIsManaged(true);
		}

		// Add node to node group (if only one exists)
		List groupList = ValidatorUtils.discoverMembers(dmgrCellUnit, WasPackage.Literals.WAS_NODE_GROUP_UNIT, context == null ? null : context.getProgressMonitor());
		if (groupList.size() == 1) {
			WasNodeGroupUnit cellNodeGroup = (WasNodeGroupUnit) groupList.get(0);
			ResolutionUtils.group(cellNodeGroup, nodeUnit);

		}
		return true;
	}

}
