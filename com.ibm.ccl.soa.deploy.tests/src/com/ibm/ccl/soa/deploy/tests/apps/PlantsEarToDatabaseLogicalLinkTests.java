/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.apps;

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestUtils;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Tests the execution of logical links in the Plants by WebSphere topologies.
 * <p>
 * Loads complete topologies from the test plug-in and executes their logical
 * link, asserting that all errors are fixed.
 */
public class PlantsEarToDatabaseLogicalLinkTests extends TopologyTestCase {

	/** Platform path to test topology files. */
	public static final String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/plants";

	public static final String ONE_HOST_URL = URL_PREFIX
			+ "/PlantsSingleHost.topology";

	public static final String TWO_HOSTS_URL = URL_PREFIX
			+ "/PlantsTwoHosts.topology";

	public static final String CLUSTER_ONE_APPSRV_URL = URL_PREFIX
			+ "/PlantsClusterOneAppServer.topology";

	public static final String CLUSTER_TWO_APPSRV_URL = URL_PREFIX
			+ "/PlantsClusterTwoAppServers.topology";

	public PlantsEarToDatabaseLogicalLinkTests() {
		super("PlantsLogicalLinkTests");
	}

	public PlantsEarToDatabaseLogicalLinkTests(String name) {
		super(name);
	}

	/**
	 * Finds the one logical link in the topology and resolves it, asserting
	 * that no errors will be left.
	 * 
	 * @param top
	 *            the topology checked.
	 * @throws Exception
	 */
	protected void resolveConstraintLink(Topology top) throws Exception {
		// find logical link ...
		ConstraintLink link = null;
		for (Iterator iter = top.findAllConstraintLinks(); iter.hasNext();) {
			assert link == null : "multiple logical links found";
			link = (ConstraintLink) iter.next();
		}
		assert link != null;

		// get constraint on the link
		Constraint constraint = null;
		// MK 7/5/2007 replaced use of iterator with explicit loop after finding
		// problem with
		// call to hasNext() after DeployModelObject.getConstraints(); cf. Jazz
		// Defect 2521
		List<Constraint> linkConstraints = link.getConstraints();
		assert !(linkConstraints.size() > 1) : "multiple constraints found";
		if (1 == linkConstraints.size()) {
			constraint = linkConstraints.get(0);
		}
		// for (Iterator iter = link.getConstraints().iterator();
		// iter.hasNext();) {
		// assert constraint == null : "multiple constraints found";
		// constraint = (Constraint) iter.next();
		// }
		assert constraint != null;

		// Validate topology and identify logical link error status
		getValidatorService().validate(top.getEditTopology());
		// assert !link.getStatus().isOK() : "logical link does not have error";
		// assert link.getStatus() instanceof IDeployStatus : "too many logical
		// link errors";
		// IDeployStatus status = (IDeployStatus) link.getStatus();
		assert !constraint.getStatus().isOK() : "constraint does not have error";
		IDeployStatus status = null;
		for (DeployStatusIterator sIt = new DeployStatusIterator (constraint); sIt.hasNext();) {
			IDeployStatus s = sIt.next();
			if (s.getProblemType().equals(IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN)) {
				status = s;
				break;
			}
		}
		assert status != null : "constraint does not have expected error";
		assert status instanceof DatasourceSatisfactionStatus : "constraint does not have expected error";
//		IDeployStatus status = (IDeployStatus) constraint.getStatus();
		((DatasourceSatisfactionStatus) status).setUser("db2admin");

		// Find error status resolutions
		List<IDeployResolution> resolutions = getValidatorService()
				.getResolutions(status);
		assert resolutions.size() != 0 : "No resolutions found for: \n"
				+ getString(constraint.getStatus());
		assert resolutions.size() == 1 : "Too many resolutions found ("
				+ resolutions.size() + "):\n"
				+ getString(constraint.getStatus());

		// Resolve and check for zero validaton errors.
		// prime with a particular user so that the the resolution asks not
		// ((DeployStatus) status).setAttribute(
		// DeployLogicalLinkMessageFactory.DB_USER_ID, "db2admin");
		// moved before resolution generator
		resolutions.get(0).resolve(null);
		getValidatorService().validate(top.getEditTopology());
		assertHasNoErrorStatus(top);
	}

	/**
	 * Copies the topology to the local project, imports it to a new topology,
	 * and returns the import view.
	 * 
	 * @param top
	 *            a topology loaded from the classpath.
	 * @return the import view of the local project topology copy
	 * @throws Exception
	 */
	protected Topology copyAndImport(Topology top) throws Exception {
		assert top != null;
		// Reload the topology to undo any changes
		top = reload(top, false);

		// Save as local copy
		top.eResource().setURI(getURI(top.getName(), top.getNamespace()));
		save(top);

		// Import topology
		Topology top2 = createTopology(top.getName() + "_import_"
				+ System.currentTimeMillis(), top.getNamespace(), false);
		Import importDcl = TopologyUtil.importTopology(top, top2);
		save(top2);
		Topology importTop = resolve(importDcl);
		TopologyTestUtils.assertAllTopologyMethodsReturnProxyObjects(importTop);
		return importTop;
	}

	/**
	 * Test the resolution of a logical link for plants on a single machine
	 * topology.
	 */
	public void testOneHost() throws Exception {
		// Test resolution on topology (private)
		Topology top = loadTopology(ONE_HOST_URL);
		resolveConstraintLink(top);

		// Test resolution on imported topology (editable)
		top = copyAndImport(top);
		assert top != null;
		addExplicitContractDefaultPublicEditable(top);
		resolveConstraintLink(top);
	}

	/**
	 * Test the resolution of a logical link for plants on a two machine
	 * topology.
	 */
	public void testTwoHost() throws Exception {
		// Test resolution on topology (private)
		Topology top = loadTopology(TWO_HOSTS_URL);
		resolveConstraintLink(top);

		// Test resolution on imported topology (editable)
		top = copyAndImport(top);
		assert top != null;
		addExplicitContractDefaultPublicEditable(top);
		resolveConstraintLink(top);
	}

	/**
	 * Test the resolution of a logical link for plants on a cluster with one
	 * application server topology.
	 */
	public void testClusterOneAppServer() throws Exception {
		// Test resolution on topology (private)
		Topology top = loadTopology(CLUSTER_ONE_APPSRV_URL);
		resolveConstraintLink(top);

		// Test resolution on imported topology (editable)
		top = copyAndImport(top);
		assert top != null;
		addExplicitContractDefaultPublicEditable(top);
		resolveConstraintLink(top);
	}

	/**
	 * Test the resolution of a logical link for plants on a cluster with two
	 * application servers topology.
	 */
	public void testClusterTwoAppServers() throws Exception {
		// Test resolution on topology (private)
		Topology top = loadTopology(CLUSTER_TWO_APPSRV_URL);
		resolveConstraintLink(top);

		// Test resolution on imported topology (editable)
		top = copyAndImport(top);
		assert top != null;
		addExplicitContractDefaultPublicEditable(top);
		resolveConstraintLink(top);
	}
}
