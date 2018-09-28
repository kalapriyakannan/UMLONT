/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Adapter;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorAdapter;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyValidationMonitor;

/**
 * Tests the {@link DeployValidatorService} class.
 */
public class DomainValidatorServiceTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DomainValidatorTest";

	public DomainValidatorServiceTest() {
		super(PROJECT_NAME);
	}

	/**
	 * Test for defect 6537.
	 */
	public void testArtifactStatusReset() {
		Topology top = createTopology("testArtifactStatusReset");
		Unit u1 = addUnit(top, "u1");
		FileArtifact a1 = CoreFactory.eINSTANCE.createFileArtifact();
		a1.setName("artifact0");
		a1.getFileURIs().add("C:\\AUTOEXEC.BAT");
		u1.getArtifacts().add(a1);

		Unit u2 = addUnit(top, "u2");
		FileArtifact a2 = CoreFactory.eINSTANCE.createFileArtifact();
		a2.setName("artifact0");
		a2.getFileURIs().add("C:\\MSDOS.SYS");
		u2.getArtifacts().add(a2);

		// No errors in topology
		validate(top);
		assertHasNoErrorStatus(top);

		// Add a constraint link to propagate the artifacts (not satisfied initailly)
		ConstraintLink cLink = LinkFactory.createConstraintLink(u1, u2);
		AttributePropagationConstraint c = ConstraintFactory.eINSTANCE
				.createAttributePropagationConstraint();
		c.setName("c");
		c.setSourceAttributeName("fileURIs");
		c.setTargetAttributeName("fileURIs");
		c.setSourceObjectURI("artifact0");
		c.setTargetObjectURI("artifact0");
		cLink.getConstraints().add(c);
		
		validate(top);
		// Assert that there is an error in the topology due to the propagation constraint
		assertHasErrorStatus(top);

		// Fix the URIs to be equal (satsify constraint)
		a2.getFileURIs().clear();
		a2.getFileURIs().add(a1.getFileURIs().get(0));
		
		// Check that the artifacts going into the same set are not merged
		Set<Artifact> set = new HashSet<Artifact>();
		assertTrue(a1 != a2);
		set.add(a1);
		set.add(a2);
		assertEquals(2, set.size());

		// Validate that there are no propagation errors
		validate(top);
		assertHasNoErrorStatus(top);
	}

	/**
	 * Tests that the domain validation service returns the core domain
	 * validator.
	 */
	public void testDomainValidatorReturnsCoreValidator() throws IOException,
			CoreException {
		final Topology top = createTopology("testDomainValidatorReturnsCoreValidator");

		final Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		final Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("req");
		unit.getOnlyDependencyRequirements().add(req);

		final DependencyLink link = CoreFactory.eINSTANCE
				.createDependencyLink();
		link.setName("link");
		req.setLink(link);

		top.getEObject().eResource().save(null);

		assertHasDomainValidator(top, CoreDomainValidator.class);
	}

	/**
	 * Tests the monitoring of a topology for changes.
	 */
	public void testMessageCoreMonitoring() throws Exception {
		// Create <b>unsaved</b> topology
		final Topology top = createTopology("testMessageCoreMonitoring");

		DeployValidatorService validator = getValidatorService();
		TopologyValidationMonitor.monitor(top, validator, null,
				TopologyValidationMonitor.DEFAULT_MONITOR_DELAY);
		setValidationMonitorBlocking(top, true);

		final Unit unit = CoreFactory.eINSTANCE.createUnit();
		top.getUnits().add(unit);

		// Unit has no name
		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		// Fix name problem
		unit.setName("unit");
		assertHasNoDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		TopologyValidationMonitor.unmonitor(top, validator);
		for (Iterator iter = top.getEObject().eAdapters().iterator(); iter
				.hasNext();) {
			Adapter adapter = (Adapter) iter.next();
			assert !(adapter instanceof DeployValidatorAdapter);

		}
	}

	/**
	 * Tests the monitoring of a topology for changes.
	 */
	public void testMarkerCoreMonitoring() throws Exception {
		final Topology top = createTopology("testMessageMarkerMonitoring", true);

		DeployValidatorService validator = getValidatorService();
		TopologyValidationMonitor.monitor(top, validator, null,
				TopologyValidationMonitor.DEFAULT_MONITOR_DELAY);
		setValidationMonitorBlocking(top, true);

		final Unit unit = CoreFactory.eINSTANCE.createUnit();
		top.getUnits().add(unit);

		// Unit has no name
		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		// Fix name problem
		unit.setName("unit");
		assertHasNoDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		TopologyValidationMonitor.unmonitor(top, validator);
	}

	/**
	 * Tests the monitoring of a topology over two files.
	 */
	public void testMarkerCoreMonitoringOverTwoFiles() throws Exception {
		DeployValidatorService validator = getValidatorService();

		final Topology top1 = createTopology(
				"testMarkerCoreMonitoringOverTwoFiles1", true);
		final Topology top2 = createTopology(
				"testMarkerCoreMonitoringOverTwoFiles2", true);
		TopologyValidationMonitor.monitor(top1, validator, null, 0);
		TopologyValidationMonitor.monitor(top2, validator, null, 0);
		setValidationMonitorBlocking(top1, true);
		setValidationMonitorBlocking(top2, true);

		// unit1@top1 with no name
		final Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		top1.getUnits().add(unit1);

		assertHasDeployStatus(unit1,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		// unit2@top2 with no name
		final Unit unit2 = CoreFactory.eINSTANCE.createUnit();
		top2.getUnits().add(unit2);

		assertHasDeployStatus(unit2,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		unit1.setName("unit1");
		unit2.setName("unit2");

		assertHasNoDeployStatus(unit1,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);
		assertHasNoDeployStatus(unit2,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		TopologyValidationMonitor.unmonitor(top1, validator);
		TopologyValidationMonitor.unmonitor(top2, validator);
	}

	/**
	 * Tests the monitoring of a topology over two files.
	 */
	public void testMarkerCoreMonitoringWithSave() throws Exception {
		DeployValidatorService validator = getValidatorService();

		final Topology top = createTopology("testMarkerCoreMonitoringWithSave",
				true);
		TopologyValidationMonitor.monitor(top, validator, null, 0);
		setValidationMonitorBlocking(top, true);

		// unit1@top1 with no name
		final Unit unit = CoreFactory.eINSTANCE.createUnit();
		top.getUnits().add(unit);
		assert unit.getStatus().getSeverity() == IStatus.ERROR;
		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		top.getEObject().eResource().save(null);

		assertHasDeployStatus(unit,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		TopologyValidationMonitor.unmonitor(top, validator);
	}
}
