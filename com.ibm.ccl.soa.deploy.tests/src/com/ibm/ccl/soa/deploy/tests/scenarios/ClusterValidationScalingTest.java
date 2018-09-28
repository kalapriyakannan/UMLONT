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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
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
 * Test WAS cluster realization (and exercise validation)
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class ClusterValidationScalingTest extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Import importTopInfra;

	private Topology editTopInfra;

	private Topology infraTop;

	private DeployValidatorService deployValidatorService;

	boolean verbose = true;

	private boolean useImports = false;

	private int maxValidationRuns = 10;

	private int minServers = 0;

	private int maxServers = 10;

	private int serverIncrement = 1;

	/** Platform path to test topology files. */
	String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/wasCluster";

	String ND_PLUS_DEPLOYMENT_MANAGER_STACK_URL = URL_PREFIX + "/NDPlusDeploymentManager.topology";

	String ND_APP_SERVER_STACK_URL = URL_PREFIX + "/NDAppServer.topology";

	/** Test case ctor */
	public ClusterValidationScalingTest() {
		super("ClusterRealizationsTest");
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
	public void testClusterValidationScaling() throws Exception {

		deployValidatorService = new DeployValidatorService();

		for (int serversInCluster = minServers; serversInCluster <= maxServers; serversInCluster += serverIncrement) {
			editTopInfra = createTopology(serversInCluster + "ServerInfra");

			buildCluster(serversInCluster, editTopInfra);
			assert (editTopInfra.getUnits().size() > 1);
			addIdentityContract(editTopInfra);
			save(editTopInfra);
			Topology top = createTopology(serversInCluster + "_WASClusterValidation", true);
			top.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
			addNullContract(top);

			if (useImports) {
				importTopInfra = TopologyUtil.importTopology(editTopInfra, top);
				infraTop = TopologyUtil.resolve(importTopInfra);
			} else {
				addUnits(ResolutionUtils.intelligentDeepCopy(editTopInfra.getUnits(), top), top);
			}

			save(top);
			// initial validation to load classes
			deployValidatorService.validate(top); 
			for (int runs = 0; runs < maxValidationRuns; ++runs) {
				timedValidation(top, serversInCluster);
			}
		}
	}

	private void timedValidation(Topology top, int serversInCluster) {
		cacheControlStart();
		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(serversInCluster + " servers in cluster : Elapsed seconds for validation = "
				+ ((double)(time - prevTime))/1000 + " : unit count = " + topUnitCount(top));
	}
	
	private int topUnitCount(Topology top) {
		int cnt = 0;
		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			++cnt;
			iter.next();
		}
		return cnt;
	}

	private void cacheControlStart() {
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();
		try {
			RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
			RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
			RealizationPatternCacheService.INSTANCE.enterRealizationPatternCache();
			RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
		} finally {
			TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
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

	private void buildCluster(int appServerCount, Topology targetTop) throws IOException {
		Topology top = null;
		top = loadTopology(ND_PLUS_DEPLOYMENT_MANAGER_STACK_URL);
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
		assert (dmgrNodeUnit != null);
		assert (clusterUnit != null);
		WasCluster cluster = (WasCluster) ValidatorUtils.getCapability(clusterUnit, WasPackage.eINSTANCE
				.getWasCluster());
		cluster.setClusterName("cluster1");
		for (int i = 0; i < appServerCount; ++i) {
			int prevSize = top.getUnits().size();
			Topology tmpTop;
			tmpTop = loadTopology(ND_APP_SERVER_STACK_URL);
			assert (tmpTop.getUnits().size() > 1);
			Collection c = ResolutionUtils.intelligentDeepCopy(tmpTop.getUnits(), top);
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
			WasNode node = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE.getWasNode());
			node.setNodeName("node" + i);
			assert (nodeUnit != null);
			assert (serverOs != null);
			assert (appServerUnit != null);
			addUnits(c, top);
			assert (prevSize < top.getUnits().size());
			boolean fedStatus = federate(null, dmgrNodeUnit, nodeUnit);
			assert (fedStatus == true);
			MemberLink ml = LinkFactory.createMemberLink(clusterUnit, appServerUnit);
			assert ml != null;
			OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(serverOs, OsPackage.eINSTANCE
					.getOperatingSystem());
			osCap.setHostname("ASHost" + i);
		}
		List<Unit> unitsList = new ArrayList<Unit>(top.getUnits());
		addUnits(unitsList, targetTop);
		unloadTopologyInEditingDomain(top);
	}

	private void addUnits(Collection<Unit> units, Topology top) {
		for (Iterator<Unit> unitsIter = units.iterator(); unitsIter.hasNext();) {
			Unit unit = unitsIter.next();
			top.getUnits().add(unit);
		}
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

	public boolean federate(IDeployResolutionContext context, WasNodeUnit dmgrUnit, WasNodeUnit nodeUnit) {
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
