/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.communication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.AddNetworkCommunicationConstraintResolutionGenerator.AddNetworkCommunicationConstraintResolution;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Tests {@link ApplicationCommunicationConstraint} and its possible children
 * constraints.
 */
public class ApplicationCommunicationConstraintTest extends TopologyTestCase {

	private final static String key = "ApplicationCommunicationConstraintTest";
	private final static DeployValidatorService dvs = DeployValidatorService
			.getOrCreateValidatorService(key);

	private final boolean DEBUG = false;

	/**
	 * Tests {@link ApplicationCommunicationConstraint} and its possible
	 * children constraints.
	 */
	public ApplicationCommunicationConstraintTest() {
		super(ApplicationCommunicationConstraintTest.class.getSimpleName());
	}

	/**
	 * Tests that requirements are not contained as
	 * {@link DeployModelObject#getConstraints()} constraints, but are returned
	 * from {@link Unit#getRequirements()}, and that requirement expressions
	 * are child constraints.
	 * 
	 * @throws Exception
	 */
	public void testApplicationCommunicationConstraint() throws Exception {
		String TEST = "testApplicationCommunicationConstraint";
		Topology top = createTopology(TEST);

		ApplicationCommunicationConstraint acc = populateTopology(top);

		dvs.validate(top);
		Resource res = top.getEObject().eResource();
		res.save(null);

		List<IDeployStatus> statuses = getStatuses(acc,
				ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC, IStatus.ERROR);
		assert 1 == statuses.size() : dumpMarkers(top);

		IDeployStatus status = statuses.get(0);
		assert dvs.hasResolutions(status);

		List<IDeployResolution> resolutions = getResolutions(dvs
				.getResolutions(status),
				AddNetworkCommunicationConstraintResolution.class);
		assert 1 == resolutions.size();

		IStatus resolutionStatus = resolutions.get(0).resolve(
				new NullProgressMonitor());
		assert resolutionStatus.isOK();

		dvs.validate(top);
		res.save(null);

		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 0 == statuses.size();
		
		testResults(top, null, null, null);

		// change direction on original link
		acc.setRespectLinkDirection(false);
		dvs.validate(top);
		res.save(null);
		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 1 == statuses.size() : dumpMarkers(top);
		
		deleteNCC(top);

		// create another ncc with different direction
		status = statuses.get(0);
		assert dvs.hasResolutions(status);

		resolutions = getResolutions(dvs.getResolutions(status),
				AddNetworkCommunicationConstraintResolution.class);
		assert 1 == resolutions.size();

		resolutionStatus = resolutions.get(0)
				.resolve(new NullProgressMonitor());
		assert resolutionStatus.isOK();

		dvs.validate(top);
		res.save(null);

		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 0 == statuses.size();
	}

	public void testCommunicationBandwidthConstraint() throws Exception {
		Topology top = createTopology("testApplicationCommunicationConstraint");
		testChildCommunicationConstraint(
				top,
				ConstraintPackage.Literals.COMMUNICATION_BANDWIDTH_CONSTRAINT,
				ConstraintPackage.Literals.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH
						.getName(), new Integer(35));
	}

	public void testCommunicationCostConstraint() throws Exception {
		Topology top = createTopology("testCommunicationCostConstraint");
		testChildCommunicationConstraint(top,
				ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT,
				ConstraintPackage.Literals.COMMUNICATION_COST_CONSTRAINT__COST
						.getName(), new Integer(35));
	}

	public void testCommunicationPortConstraint() throws Exception {
		Topology top = createTopology("testCommunicationPortConstraint");
		testChildCommunicationConstraint(top,
				ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT,
				ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__PORT
						.getName(), new Integer(35));
	}

	public void testApplicationCommunicationProtocolConstraint()
			throws Exception {

	}

	public void testCommunicationTypeConstraint() throws Exception {
		Topology top = createTopology("testTransmissionDelayConstraint");
		testChildCommunicationConstraint(top,
				ConstraintPackage.Literals.COMMUNICATION_TYPE_CONSTRAINT,
				ConstraintPackage.Literals.COMMUNICATION_TYPE_CONSTRAINT__TYPE
						.getName(), CommunicationTypeTypes.LAN_LITERAL);
	}

	public void testTransmissionDelayConstraint() throws Exception {
		Topology top = createTopology("testTransmissionDelayConstraint");
		testChildCommunicationConstraint(top,
				ConstraintPackage.Literals.TRANSMISSION_DELAY_CONSTRAINT,
				ConstraintPackage.Literals.TRANSMISSION_DELAY_CONSTRAINT__DELAY
						.getName(), new Integer(35));
	}

	private void testChildCommunicationConstraint(Topology top,
			EClass childConstraintType, String aName, Object aValue)
			throws Exception {

		ApplicationCommunicationConstraint acc = populateTopology(top);

		// add child constraint
		addChildCommunicationConstraint(acc, childConstraintType, aName, aValue);

		dvs.validate(top);
		Resource res = top.getEObject().eResource();
		res.save(null);

		List<IDeployStatus> statuses = getStatuses(acc,
				ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC, IStatus.ERROR);
		assert 1 == statuses.size() : dumpMarkers(top);

		IDeployStatus status = statuses.get(0);
		assert dvs.hasResolutions(status);

		List<IDeployResolution> resolutions = getResolutions(dvs
				.getResolutions(status),
				AddNetworkCommunicationConstraintResolution.class);
		assert 1 == resolutions.size();

		IStatus resolutionStatus = resolutions.get(0).resolve(
				new NullProgressMonitor());
		assert resolutionStatus.isOK();

		dvs.validate(top);
		res.save(null);

		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 0 == statuses.size() : dumpMarkers(top);

		testResults(top, childConstraintType, aName, aValue);

		// change direction on original link
		acc.setRespectLinkDirection(false);
		dvs.validate(top);
		res.save(null);
		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 1 == statuses.size() : dumpMarkers(top);

		deleteNCC(top);

		// create another ncc with different direction
		status = statuses.get(0);
		assert dvs.hasResolutions(status);

		resolutions = getResolutions(dvs.getResolutions(status),
				AddNetworkCommunicationConstraintResolution.class);
		assert 1 == resolutions.size() : resolutions.size();

		resolutionStatus = resolutions.get(0)
				.resolve(new NullProgressMonitor());
		assert resolutionStatus.isOK();

		dvs.validate(top);
		res.save(null);

		statuses = getStatuses(acc, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC,
				IStatus.ERROR);
		assert 0 == statuses.size() : statuses.size();

		testResults(top, childConstraintType, aName, aValue);
	}

	private Constraint addChildCommunicationConstraint(
			Constraint parentConstraint, EClass constraintType, String aName,
			Object aValue) {

		if (ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT
				.isSuperTypeOf(constraintType)) {
			Constraint acpc = ConstraintFactory.eINSTANCE
					.createApplicationCommunicationProtocolConstraint();
			parentConstraint.getConstraints().add(acpc);
			acpc.setName("childACPC"); //$NON-NLS-1$
			parentConstraint = acpc;
		}

		EObject obj = ConstraintFactory.eINSTANCE.create(constraintType);
		assert null != obj;
		assert constraintType.isSuperTypeOf(obj.eClass());
		Constraint constraint = (Constraint) obj;
		constraint.setName("childCommunicationConstraint");

		assert DeployModelObjectUtil.setAttributeValue(constraint, aName,
				aValue);

		parentConstraint.getConstraints().add(constraint);

		return constraint;

	}

	private void testResults(Topology top, EClass type, String aName,
			Object expectedValue) {
		List<DeployModelObject> nccL = getObjects(
				ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT,
				top);
		assert 1 == nccL.size() : nccL.size();
		assert nccL.get(0) instanceof NetworkCommunicationConstraint;
		NetworkCommunicationConstraint ncc = (NetworkCommunicationConstraint) nccL
				.get(0);
		if (null != type) {
			assert 1 == ncc.getConstraints().size() : ncc.getConstraints()
					.size();
			DeployModelObject childConstraint = (DeployModelObject) ncc
					.getConstraints().get(0);
			assert type.isSuperTypeOf(childConstraint.getEObject().eClass());
			Object aValue = DeployModelObjectUtil.getAttributeValue(
					childConstraint, aName);
			assert aValue.equals(expectedValue);
		}
	}

	private ApplicationCommunicationConstraint populateTopology(
			Topology topology) {
		// WAS stack
		ResolutionUtils.addFromTemplate(
				IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE, topology);
		List<DeployModelObject> wasL = getObjects(
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, topology);
		assert null != wasL;
		assert 1 == wasL.size();
		Unit was = (Unit) wasL.get(0);
		List<DeployModelObject> wasSL = getObjects(
				WasPackage.Literals.WAS_SYSTEM_UNIT, topology);
		assert null != wasSL;
		assert 1 == wasSL.size();
		Unit wasOs = (Unit) ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_XP_UNIT, topology);
		assert null != wasOs;
		LinkFactory.createHostingLink(wasOs, (Unit) wasSL.get(0));

		// DB2 stack
		Unit db = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_DATABASE_UNIT, topology);
		assert null != db;
		Unit dbi = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_INSTANCE_UNIT, topology);
		assert null != dbi;
		LinkFactory.createHostingLink(dbi, db);
		Unit dbs = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_SYSTEM_UNIT, topology);
		assert null != dbs;
		LinkFactory.createHostingLink(dbs, dbi);
		Unit dbOs = (Unit) ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_XP_UNIT, topology);
		assert null != dbOs;
		LinkFactory.createHostingLink(dbOs, dbs);

		// ApplicationCommunicationConstraint
		ConstraintLink link = LinkFactory.createConstraintLink(was, db);
		ApplicationCommunicationConstraint acc = ConstraintFactory.eINSTANCE
				.createApplicationCommunicationConstraint();
		acc.setName("ACC");
		link.getConstraints().add(acc);

		return acc;
	}

	private List<IDeployStatus> getStatuses(DeployModelObject obj,
			String problemType, int severity) {
		if (null == obj || null == problemType) {
			return Collections.emptyList();
		}

		List<IDeployStatus> result = new ArrayList<IDeployStatus>();

		for (DeployStatusIterator sIt = new DeployStatusIterator(obj); sIt
				.hasNext();) {
			IDeployStatus status = sIt.next();

			if (DEBUG) {
				System.out.println("     message: " + status.getMessage());
				System.out.println(" problemType: " + status.getProblemType());
				System.out.println("   validator: " + status.getValidatorID());
			}

			if (problemType.equals(status.getProblemType())
					&& severity == status.getSeverity()) {
				result.add(status);
			}
		}

		return result;
	}

	private List<IDeployResolution> getResolutions(
			List<IDeployResolution> resolutions, Class c) {
		if (null == resolutions || 0 == resolutions.size() || null == c) {
			return Collections.emptyList();
		}

		if (DEBUG) {
			System.out.println("Filtering resolutions for one of type: "
					+ c.getName());
		}

		List<IDeployResolution> result = new ArrayList<IDeployResolution>();

		for (IDeployResolution res : resolutions) {
			if (DEBUG) {
				System.out.println("   considering: " + res.getDescription());
			}
			if (c.isInstance(res)) {
				result.add(res);
			}
		}

		return result;
	}

	private List<DeployModelObject> getObjects(EClass type, Topology topology) {
		if (null == type) {
			return Collections.emptyList();
		}

		List<DeployModelObject> result = new ArrayList<DeployModelObject>();

		for (Iterator<DeployModelObject> oIt = topology
				.findAllDeployModelObjects(); oIt.hasNext();) {
			DeployModelObject obj = oIt.next();
			if (type.isSuperTypeOf(obj.getEObject().eClass())) {
				result.add(obj);
			}
		}

		return result;
	}
	
	private void deleteNCC (Topology topology) {
		List<DeployModelObject> nccL = getObjects(
				ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT,
				topology);
		for (DeployModelObject obj : nccL) {
			EcoreUtil.delete(obj);
		}

	}

}
