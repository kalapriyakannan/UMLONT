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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.AutoRealizationBookKeeping;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.AutoRealizationControl;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.ConnectedSetRealizationMapper;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * Tests the execution of logical links in the Plants by WebSphere topologies.
 * <p>
 * Loads complete topologies from the test plug-in and executes their logical link, asserting that all errors are fixed.
 */
public class AutoRealizationTests extends TopologyTestCase {

	/** Platform path to test topology files. */
	private static final String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/autoRealTest";

	private static final String DB2_2INSTANCES_4DATABASES = URL_PREFIX
			+ "/db2_2instances_4databases_multi_solutions_test.topology";

	private static final String TWO_CONCEPTUAL_OS_TO_ONE_CONCRETE_OS = URL_PREFIX
			+ "/two_conceptual_os_to_one_concrete_os.topology";

	private static final String OS_PLUS_USER_TO_USERS = URL_PREFIX + "/os_plus_user_to_users.topology";

	private static final String SIMPLE_ALL_SOLUTIONS_CASE = URL_PREFIX + "/simple_all_solutions_case.topology";

	private static final String DEPENDENCY_LINK_MISSING_IN_INFRA = URL_PREFIX + "/missing_dep_link_in_infra.topology";

	private static final String TWO_SERVER_CLUSTER_REALIZATION = URL_PREFIX + "/2_server_cluster_realization.topology";

	private static final String COLLOCATION_BASIC_TEST = URL_PREFIX + "/collocation_basic_test.topology";

	private static final String ANTICOLLOCATION_BASIC_TEST = URL_PREFIX + "/anticollocation_basic_test.topology";
	
	private static final String REALIZE_DETAILED_CLUSTER_TO_INFRASTRUCTURE = URL_PREFIX + "/RealizeDetailedClusterToInfrastructure.topology";
	
	private static final String WAS_CLUSTER_DEFERRED_HOSTING_PLUS_ANTICOLLOCATION = URL_PREFIX + "/was_cluster_deferredHosting_plus_anticollocation.topology";

	/**
	 * 
	 */
	public AutoRealizationTests() {
		super("AutoRealizationTests");
		setDeleteProjectOnTearDown(false);
	}

	/**
	 * @throws Exception
	 */
	public void testMultiSolutionSupport() throws Exception {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.DB2_2INSTANCES_4DATABASES);
		assert top.getConfigurationContract() != null;

		DB2SystemUnit db2suC = null;
		DB2InstanceUnit db2iu1C = null;
		DB2InstanceUnit db2iu2C = null;
		DB2DatabaseUnit db2du1C = null;
		DB2DatabaseUnit db2du2C = null;
		DB2DatabaseUnit db2du3C = null;
		DB2DatabaseUnit db2du4C = null;

		for (Unit u : (List<Unit>) top.getUnits()) {
			if (!u.isConceptual()) {
				continue;
			}
			if (u instanceof DB2SystemUnit) {
				db2suC = (DB2SystemUnit) u;
			} else if (u instanceof DB2InstanceUnit) {
				DB2Instance dbi = (DB2Instance) ValidatorUtils.getCapability(u, Db2Package.eINSTANCE.getDB2Instance());
				assert (dbi != null);
				if (dbi.getDb2InstanceName().equals("DB2INST1")) {
					db2iu1C = (DB2InstanceUnit) u;
				} else if (dbi.getDb2InstanceName().equals("DB2INST2")) {
					db2iu2C = (DB2InstanceUnit) u;
				} else {
					assert (false);
				}
			} else if (u instanceof DB2DatabaseUnit) {
				DB2Database db = (DB2Database) ValidatorUtils.getCapability(u, Db2Package.eINSTANCE.getDB2Database());
				assert (db != null);
				if (db.getDbName().equals("db1")) {
					db2du1C = (DB2DatabaseUnit) u;
				} else if (db.getDbName().equals("db2")) {
					db2du2C = (DB2DatabaseUnit) u;
				} else if (db.getDbName().equals("db3")) {
					db2du3C = (DB2DatabaseUnit) u;
				} else if (db.getDbName().equals("db4")) {
					db2du4C = (DB2DatabaseUnit) u;
				} else {
					assert (false);
				}
			}
		}
		assert db2suC != null;

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;
		// This test was failing occasionally, so added retries.
		final int MAX_TRIES = 4;

		for (int i = 0; i < MAX_TRIES; ++i) {
			// System.out.println("Pass : " + i);
			// ------------------------------------------------------------------------------------------
			// Base should find a single solution
			arc = new AutoRealizationControl(arcTestBase);
			resultMaps = computeRealizationMaps(db2suC, arc, null);
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
			;

			// ------------------------------------------------------------------------------------------
			// Base plus find all solutions
			// Expected solutions are as follows. Many-to-one solutions are filtered out as uninteresting if
			// one-to-one solutions are available.
			// dbi1 -> dib1
			// db1 -> db1
			// db2 -> db2
			// dbi2 -> dbi2
			// db3 -> db3
			// db4 -> db4
			//
			// dbi1 -> dib1
			// db2 -> db1
			// db1 -> db2
			// dbi2 -> dbi2
			// db3 -> db3
			// db4 -> db4
			//
			// dbi1 -> dib1
			// db1 -> db1
			// db2 -> db2
			// dbi2 -> dbi2
			// db4 -> db3
			// db3 -> db4
			//
			// dbi1 -> dib1
			// db2 -> db1
			// db1 -> db2
			// dbi2 -> dbi2
			// db4 -> db3
			// db3 -> db4
			//
			//
			// dbi1 -> dib2
			// db1 -> db3
			// db2 -> db4
			// dbi2 -> dbi1
			// db3 -> db1
			// db4 -> db2
			//
			// dbi1 -> dib2
			// db2 -> db3
			// db1 -> db4
			// dbi2 -> dbi1
			// db3 -> db1
			// db4 -> db2
			//
			// dbi1 -> dib2
			// db1 -> db3
			// db2 -> db4
			// dbi2 -> dbi1
			// db4 -> db1
			// db3 -> db2
			//
			// dbi1 -> dib2
			// db2 -> db3
			// db1 -> db4
			// dbi2 -> dbi1
			// db4 -> db1
			// db3 -> db2

			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(db2suC, arc, null);
			assert (resultsAreUnique(resultMaps));
			assert (resultMaps.size() == 8) : resultMaps.size() + " expected 8";
			// spot check results:
			Set<Unit> db2suCTargets = new HashSet<Unit>();
			Set<Unit> db2iu1CTargets = new HashSet<Unit>();
			Set<Unit> db2iu2CTargets = new HashSet<Unit>();
			Set<Unit> db2du1CTargets = new HashSet<Unit>();
			Set<Unit> db2du2CTargets = new HashSet<Unit>();
			Set<Unit> db2du3CTargets = new HashSet<Unit>();
			Set<Unit> db2du4CTargets = new HashSet<Unit>();
			for (Map<Unit, Unit> result : resultMaps) {
				// Expect no many to one solutions
				assert (result.keySet().size() == result.values().size());
				for (Unit u : result.keySet()) {
					if (u == db2suC) {
						db2suCTargets.add(result.get(u));
					}
					if (u == db2iu1C) {
						db2iu1CTargets.add(result.get(u));
					}
					if (u == db2iu2C) {
						db2iu2CTargets.add(result.get(u));
					}
					if (u == db2du1C) {
						db2du1CTargets.add(result.get(u));
					}
					if (u == db2du2C) {
						db2du2CTargets.add(result.get(u));
					}
					if (u == db2du3C) {
						db2du3CTargets.add(result.get(u));
					}
					if (u == db2du4C) {
						db2du4CTargets.add(result.get(u));
					}
				}
			}
			assert (db2suCTargets.size() == 1);
			assert (db2iu1CTargets.size() == 2);
			assert (db2iu2CTargets.size() == 2);
			assert (db2du1CTargets.size() == 4);
			assert (db2du2CTargets.size() == 4);
			assert (db2du3CTargets.size() == 4);
			assert (db2du4CTargets.size() == 4);

			// ------------------------------------------------------------------------------------------
			// Database names are specified in both conceptual and concrete units, with neither immutable
			// If strict attribute match mode, only one solution will be found even in all-solutions mode.
			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			arc.setStrictAttributeValueMatchMode(true);
			resultMaps = computeRealizationMaps(db2suC, arc, null);
			assert (resultsAreUnique(resultMaps));
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
		}
	}

	/**
	 * @throws Exception
	 */
	public void testMultiSolutionSupport2() throws Exception {
		final int MAX_TRIES = 10;

		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		for (int i = 0; i < MAX_TRIES; ++i) {
			Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.SIMPLE_ALL_SOLUTIONS_CASE);
			Unit startU = null;
			for (Unit u : (List<Unit>) top.getUnits()) {
				if (u.isConceptual()) {
					startU = u;
					break;
				}
			}
			assert (startU != null);

			arc = new AutoRealizationControl(arcTestBase);
			resultMaps = computeRealizationMaps(startU, arc, null);
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
			assert (conceptualUnitCount(top) == resultMaps.get(0).keySet().size()) : conceptualUnitCount(top) + ","
					+ resultMaps.get(0).keySet().size();

			shuffleUnitListsInTop(top);

			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(startU, arc, null);
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
			assert (conceptualUnitCount(top) == resultMaps.get(0).keySet().size()) : conceptualUnitCount(top) + ","
					+ resultMaps.get(0).keySet().size();
			// unloadTopologyInEditingDomain(top);
		}
	}

	/**
	 * Test realizing two conceptual operating systems to one concrete operating system
	 * 
	 * @throws Exception
	 */
	public void testManyToOneSetRealization() throws Exception {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.TWO_CONCEPTUAL_OS_TO_ONE_CONCRETE_OS);
		assert top.getConfigurationContract() != null;

		ServerUnit suC = null;
		for (Unit u : (List<Unit>) top.getUnits()) {
			if (!u.isConceptual()) {
				continue;
			}
			if (u instanceof ServerUnit) {
				suC = (ServerUnit) u;
			}
		}

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		arc = new AutoRealizationControl(arcTestBase);
		resultMaps = computeRealizationMaps(suC, arc, null);
		assert (resultsAreUnique(resultMaps));
		assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";

		arc = new AutoRealizationControl(arcTestBase);
		arc.setAllowManyToOneRealizations(false);
		resultMaps = computeRealizationMaps(suC, arc, null);
		assert (resultMaps.size() == 0) : resultMaps.size() + " expected 0";
	}

	/**
	 * Similar to test for databases. In all-solutions mode, a user is matched to two possible users if realization attribute values are matched, or 4 otherwise. In single-solution mode, a user is matched to one of the two valid users.
	 * 
	 * @throws Exception
	 */
	public void testUserToUsersSetRealization() throws Exception {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.OS_PLUS_USER_TO_USERS);
		assert top.getConfigurationContract() != null;

		ServerUnit suC = null;
		UserUnit uuC = null;
		for (Unit u : (List<Unit>) top.getUnits()) {
			if (!u.isConceptual()) {
				continue;
			}
			if (u instanceof ServerUnit) {
				suC = (ServerUnit) u;
			}
			if (u instanceof UserUnit) {
				uuC = (UserUnit) u;
			}
		}

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		arc = new AutoRealizationControl(arcTestBase);
		resultMaps = computeRealizationMaps(suC, arc, null);
		assert (resultsAreUnique(resultMaps));
		assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";

		arc = new AutoRealizationControl(arcTestBase);
		arc.setFindAllSolutions(true);
		resultMaps = computeRealizationMaps(suC, arc, null);
		assert (resultMaps.size() == 4) : resultMaps.size() + " expected 4";

		arc = new AutoRealizationControl(arcTestBase);
		arc.setFindAllSolutions(true);
		arc.setStrictAttributeValueMatchMode(true);
		resultMaps = computeRealizationMaps(suC, arc, null);
		assert (resultMaps.size() == 2) : resultMaps.size() + " expected 2";
	}

	/**
	 * Test Cluster To Cluster realization (a handy complex case)
	 * 
	 * @throws IOException
	 */
	public void testClusterToCluster() throws IOException {
		final int MAX_TRIES = 1;
		for (int i = 0; i < MAX_TRIES; ++i) {
			Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.TWO_SERVER_CLUSTER_REALIZATION);
			assert top.getConfigurationContract() != null;

			Unit serverUnit = null;
			for (Unit u : (List<Unit>) top.getUnits()) {
				if (!u.isConceptual()) {
					continue;
				}
				if (u instanceof ServerUnit) {
					serverUnit = u;
				}
			}
			assert (serverUnit != null);

			// Insulate test case from changes in defaults.
			// Use this control as the default.
			AutoRealizationControl arcTestBase = new AutoRealizationControl();
			arcTestBase.setAllowManyToOneRealizations(true);
			arcTestBase.setAllowUnmatchedConfigUnits(false);
			arcTestBase.setFindAllSolutions(false);
			arcTestBase.setFollowStructuralConstraintLinks(true);
			arcTestBase.setFullyValidateConstraintsInMatchMode(false);
			arcTestBase.setStrictAttributeValueMatchMode(false);

			AutoRealizationControl arc;
			List<Map<Unit, Unit>> resultMaps;

			arc = new AutoRealizationControl(arcTestBase);
			AutoRealizationBookKeeping arbk = new AutoRealizationBookKeeping();
			resultMaps = computeRealizationMaps(serverUnit, arc, arbk);
			assert (resultMaps.size() > 0) : resultMaps.size();
			assert (resultMaps.get(0).keySet().size() == conceptualUnitCount(top)) : resultMaps.get(0).keySet().size()
					+ "," + conceptualUnitCount(top);
			for (Unit cm : resultMaps.get(0).keySet()) {
				assert (cm.isConceptual());
				assert (!resultMaps.get(0).get(cm).isConceptual());
			}

			unloadTopologyInEditingDomain(top);
		}
	}

	/**
	 * Test dependency link in pattern but not in infra
	 * 
	 * @throws IOException
	 */
	public void testDependencyLinkMissingInInfra() throws IOException {
		final int MAX_TRIES = 2;
		for (int i = 0; i < MAX_TRIES; ++i) {
			Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.DEPENDENCY_LINK_MISSING_IN_INFRA);
			assert top.getConfigurationContract() != null;

			Unit userUnit = null;
			Unit db2InstanceUnit = null;
			for (Unit u : (List<Unit>) top.getUnits()) {
				if (!u.isConceptual()) {
					continue;
				}
				if (u instanceof UserUnit) {
					userUnit = u;
				} else if (u instanceof DB2InstanceUnit) {
					db2InstanceUnit = u;
				}
			}
			assert (userUnit != null);
			assert (db2InstanceUnit != null);

			// Insulate test case from changes in defaults.
			// Use this control as the default.
			AutoRealizationControl arcTestBase = new AutoRealizationControl();
			arcTestBase.setAllowManyToOneRealizations(true);
			arcTestBase.setAllowUnmatchedConfigUnits(false);
			arcTestBase.setFindAllSolutions(false);
			arcTestBase.setFollowStructuralConstraintLinks(true);
			arcTestBase.setFullyValidateConstraintsInMatchMode(false);
			arcTestBase.setStrictAttributeValueMatchMode(false);

			AutoRealizationControl arc;
			List<Map<Unit, Unit>> resultMaps;

			Collection<Unit> patternUnits = conceptualUnitsInTopology(top);

			for (Unit patternUnit : patternUnits) {
				arc = new AutoRealizationControl(arcTestBase);
				resultMaps = computeRealizationMaps(patternUnit, arc, null);
				assert (resultsAreUnique(resultMaps));
				if (resultMaps.size() > 0) {
					System.out.println("[" + i + "] Incorrectly found mapping starting at {"
							+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
				}
				assert (resultMaps.size() == 0) : resultMaps.size() + " expected 0";
			}
			unloadTopologyInEditingDomain(top);
		}
	}

	/**
	 * Basic collocation test
	 * 
	 * @throws IOException
	 */
	public void testBasicCollocation() throws IOException {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.COLLOCATION_BASIC_TEST);
		assert top.getConfigurationContract() != null;
		assert top.getUnits().size() > 0;

		Unit validOSUnit = null;
		for (Unit u : (List<Unit>) top.getUnits()) {
			if (u.isConceptual()) {
				continue;
			}
			if (u instanceof OperatingSystemUnit) {
				OperatingSystem os = (OperatingSystem) ValidatorUtils.getCapability(u, OsPackage.eINSTANCE
						.getOperatingSystem());
				if (os.getHostname() != null && os.getHostname().equals("ValidHost")) {
					validOSUnit = u;
				}
			}
		}
		assert (validOSUnit != null);

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		Collection<Unit> patternUnits = conceptualUnitsInTopology(top);

		for (Unit patternUnit : patternUnits) {
			//
			arc = new AutoRealizationControl(arcTestBase);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			if (resultMaps.size() > 1) {
				System.out.println("Incorrectly found multiple mappings starting at {"
						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
			}
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
			//
			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			if (resultMaps.size() > 1) {
				System.out.println("Incorrectly found multiple mappings starting at {"
						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
			}
			assert (resultMaps.size() == 1) : resultMaps.size() + " expected 1";
			assert ValidatorUtils.findHostInStack(resultMaps.get(0).get(patternUnit),
					OsPackage.eINSTANCE.getOperatingSystemUnit()).equals(validOSUnit);
		}
		unloadTopologyInEditingDomain(top);
	}

	/**
	 * Basic anticollocation test
	 * 
	 * @throws IOException
	 */
	public void testBasicAntiCollocation() throws IOException {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.ANTICOLLOCATION_BASIC_TEST);
		assert top.getConfigurationContract() != null;
		assert top.getUnits().size() > 0;

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		Collection<Unit> patternUnits = conceptualUnitsInTopology(top);

		for (Unit patternUnit : patternUnits) {
			//
			arc = new AutoRealizationControl(arcTestBase);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			if (resultMaps.size() != 3) {
				System.out.println("Incorrectly found wrong number of mappings starting at {"
						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
			}
			assert (resultMaps.size() == 3) : resultMaps.size() + " expected 3";
			assertUniqueHosts(resultMaps, patternUnits);
			//
			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			if (resultMaps.size() != 8) {
				System.out.println("Incorrectly found wrong numbef of mappings starting at {"
						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
			}
			assert (resultMaps.size() == 8) : resultMaps.size() + " expected 8";
			assertUniqueHosts(resultMaps, patternUnits);
		}
		unloadTopologyInEditingDomain(top);
	}
	
	/**
	 * Basic anticollocation test
	 * 
	 * @throws IOException
	 */
	public void testRealizeDetailedClusterToInfraFindAll() throws IOException {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.REALIZE_DETAILED_CLUSTER_TO_INFRASTRUCTURE);
		assert top.getConfigurationContract() != null;
		assert top.getUnits().size() > 0;

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		Collection<Unit> patternUnits = conceptualUnitsInTopology(top);

		int tryCnt = 0;
		int cap = 4;
//		int cap = Integer.MAX_VALUE;
		for (Unit patternUnit : patternUnits) {
			//
			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			assert (resultMapsAreOneToOne(resultMaps));
			if (resultMaps.size() != 6) {
				System.out.println("Incorrectly found wrong number (" + resultMaps.size() + ") of mappings starting search at {"
						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
//				dumpUnitRealizationMapList(resultMaps, "good map list");
			} 

			assert (resultMaps.size() == 6) : resultMaps.size() + " expected 6";
			if (++tryCnt >= cap) {
				break;
			}
		}
		unloadTopologyInEditingDomain(top);
	}	
	
	/**
	 * Basic anticollocation test
	 * 
	 * @throws IOException
	 */
	public void testWASClusterDeferredHostingPlusAntiCollocation() throws IOException {
		Topology top = loadTopologyAndShuffleUnits(AutoRealizationTests.WAS_CLUSTER_DEFERRED_HOSTING_PLUS_ANTICOLLOCATION);
		assert top.getConfigurationContract() != null;
		assert top.getUnits().size() > 0;

		// Insulate test case from changes in defaults.
		// Use this control as the default.
		AutoRealizationControl arcTestBase = new AutoRealizationControl();
		arcTestBase.setAllowManyToOneRealizations(true);
		arcTestBase.setAllowUnmatchedConfigUnits(false);
		arcTestBase.setFindAllSolutions(false);
		arcTestBase.setFollowStructuralConstraintLinks(true);
		arcTestBase.setFullyValidateConstraintsInMatchMode(false);
		arcTestBase.setStrictAttributeValueMatchMode(false);

		AutoRealizationControl arc;
		List<Map<Unit, Unit>> resultMaps;

		Collection<Unit> patternUnits = conceptualUnitsInTopology(top);

		int tryCnt = 0;
//		int cap = 4;
		int cap = Integer.MAX_VALUE;
		for (Unit patternUnit : patternUnits) {
			//
			arc = new AutoRealizationControl(arcTestBase);
			arc.setFindAllSolutions(true);
			resultMaps = computeRealizationMaps(patternUnit, arc, null);
			assert (resultsAreUnique(resultMaps));
			assert (resultMapsAreOneToOne(resultMaps));
			assert (resultMapsCoverConceptualUnits(resultMaps, patternUnits));
			if (resultMaps.size() != 6) {
//				System.out.println("Incorrectly found wrong number (" + resultMaps.size() + ") of mappings starting search at {"
//						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
//				dumpUnitRealizationMapList(resultMaps, "bad map list");
			} else {
//				System.out.println("Correct number (" + resultMaps.size() + ") of mappings starting search at {"
//						+ patternUnit.getCaptionProvider().titleWithContext(patternUnit) + "}");
//				dumpUnitRealizationMapList(resultMaps, "good map list");
			}

			assert (resultMaps.size() == 6) : resultMaps.size() + " expected 6";
			if (++tryCnt >= cap) {
				break;
			}
		}
		unloadTopologyInEditingDomain(top);
	}	
	
	private boolean resultMapsAreOneToOne(List<Map<Unit, Unit>> resultMaps) {
		for (Map<Unit,Unit> resultMap : resultMaps) {
			Set<Unit> uniqueValues = new HashSet<Unit>(resultMap.values());
			if (uniqueValues.size() != resultMap.size()) {
//				System.out.println("Map not one-to-one: [" + resultMap.size() + "][" + uniqueValues.size() + "]");
				return false;
			} else {
//				System.out.println("Map is one-to-one: [" + resultMap.size() + "][" + uniqueValues.size() + "]");
			}
		}
		return true;
	}
	
	private boolean resultMapsCoverConceptualUnits(List<Map<Unit, Unit>> resultMaps, Collection<Unit> cUnits) {
		for (Map<Unit,Unit> resultMap : resultMaps) {
			if (!(resultMap.keySet().size() == cUnits.size())) return false;
			if (!resultMap.keySet().containsAll(cUnits)) {
				System.out.println("Map does not cover conceptual units: " + resultMap.keySet().size() + "," + cUnits.size());
				return false;
			} 
		}
		return true;
	}	

	private void assertUniqueHosts(List<Map<Unit,Unit>> resultMaps, Collection<Unit> patternUnits) {
		for (Map<Unit, Unit> m : resultMaps) {
			Set<Unit> hosts = new HashSet<Unit>();
			for (Unit patternUnitInner : patternUnits) {
				Unit host = ValidatorUtils.findHostInStack(m.get(patternUnitInner), OsPackage.eINSTANCE
						.getOperatingSystemUnit());
				hosts.add(host);
			}
			assert (hosts.size() == 2) : hosts.size();
		}
	}

	private static boolean resultsAreUnique(List<Map<Unit, Unit>> results) {
		Set<Map<Unit, Unit>> compactedResults = new LinkedHashSet<Map<Unit, Unit>>();
		compactedResults.addAll(results);
		return (compactedResults.size() == results.size());
	}

	private static List<Map<Unit, Unit>> computeRealizationMaps(Unit u, AutoRealizationControl arc,
			AutoRealizationBookKeeping arbk) {
		if (arbk == null) {
			arbk = new AutoRealizationBookKeeping();
		}
		// RealizationPatternCacheService.INSTANCE.flushRealizationNavigationCache();
		// RealizationPatternCacheService.INSTANCE.flushRealizationPatternCache();
		TopologyDiscovererService.INSTANCE.flushDefaultDiscoveryCache();
		RealizationPatternCacheService rpcs = RealizationPatternCacheService.INSTANCE.create(arc, arbk);
		rpcs.enterRealizationNavigationCache();
		rpcs.enterRealizationPatternCache();
		List<Map<Unit, Unit>> maps = ConnectedSetRealizationMapper.realizationMapsConnectedSet(u, u.getEditTopology(),
				rpcs, arbk, arc, DeployValidatorService.getDefaultValidatorService(), new NullProgressMonitor());
		// dumpUnitRealizationMapList(maps, "Maps");
		int n = 0;
		Set<Unit> ics = RealizationPatternUtil.getImmediateConnectedSet(u, rpcs);
		boolean missingUnit = false;
		for (Unit unitInConnectedSet : ics) {
			for (Map<Unit, Unit> map : maps) {
				if (!map.containsKey(unitInConnectedSet)) {
					System.out.println("Missing startU in map[" + n++ + "] + sz=" + map.size() + "  : " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							+ unitInConnectedSet.getCaptionProvider().titleWithContext(unitInConnectedSet));
					missingUnit = true;
				}
			}
		}
		assert (!missingUnit);
		return maps;
	}

	/**
	 * @param m
	 * @param mapName
	 */
	private static void dumpUnitRealizationMap(Map<Unit, Unit> m, String mapName) {
		System.out.println("Map " + mapName + " -----------"); //$NON-NLS-1$ //$NON-NLS-2$
		for (Iterator<Unit> unitIter = m.keySet().iterator(); unitIter.hasNext();) {
			Unit u = unitIter.next();
			Unit mappedU = m.get(u);
			System.out.println("(conceptual=" + u.isConceptual() + " hc=" + u.hashCode() + ") " + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					u.getCaptionProvider().titleWithContext(u) + " mapped to " + //$NON-NLS-1$
					"(conceptual=" + mappedU.isConceptual() + " hc=" + //$NON-NLS-1$ //$NON-NLS-2$
					m.get(u).hashCode() + ") " + mappedU.getCaptionProvider().titleWithContext(mappedU)); //$NON-NLS-1$
		}
	}

	/**
	 * @param maps
	 * @param mapsName
	 */
	private static void dumpUnitRealizationMapList(List<Map<Unit, Unit>> maps, String mapsName) {
		int i = 0;
		for (Map<Unit, Unit> m : maps) {
			dumpUnitRealizationMap(m, mapsName + "[" + i++ + "]"); //$NON-NLS-1$//$NON-NLS-2$
		}
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
	
	private int maxUnitsMapped(Collection<Map<Unit, Unit>> maps) {
		int max = 0;
		for (Map<Unit, Unit> resultMap : maps) {
			if (resultMap.keySet().size() > max) {
				max = resultMap.keySet().size();
			}
		}
		return max;
	}

	private int maxUnitsMapTargets(Collection<Map<Unit, Unit>> maps) {
		int max = 0;
		for (Map<Unit, Unit> resultMap : maps) {
			Set<Unit> s = new LinkedHashSet<Unit>(resultMap.values());
			if (s.size() > max) {
				max = s.size();
			}
		}
		return max;
	}	
}
