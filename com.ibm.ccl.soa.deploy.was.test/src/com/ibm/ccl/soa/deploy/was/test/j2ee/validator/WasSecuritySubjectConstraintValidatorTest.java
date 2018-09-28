/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.j2ee.validator;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasSecuritySubjectConstraintValidator;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.resolution.ConfigureWasSecurityResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.validator.resolution.RemoveWasJ2EEConstraintResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.validator.resolution.SetDefaultWasSecuritySubjectResolutionGenerator;

/**
 * Tests {@link WasSecuritySubjectConstraintValidatorTest}.
 */
public class WasSecuritySubjectConstraintValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSecuritySubjectConstraintValidatorTest";

	private NullProgressMonitor monitor = new NullProgressMonitor();
	private WasSecuritySubjectConstraintValidator validator = new WasSecuritySubjectConstraintValidator();
    private DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	private RemoveWasJ2EEConstraintResolutionGenerator removeGenerator = new RemoveWasJ2EEConstraintResolutionGenerator();
	private SetDefaultWasSecuritySubjectResolutionGenerator setDefaultSubjectGenerator = new SetDefaultWasSecuritySubjectResolutionGenerator();
	private ConfigureWasSecurityResolutionGenerator configureSecurityGenerator = new ConfigureWasSecurityResolutionGenerator();

	/**
	 * 
	 * 
	 */
	public WasSecuritySubjectConstraintValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * test {@link WasSecuritySubjectConstraintValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasSecuritySubjectConstraintValidator() throws IOException,
			CoreException {

		Unit u = CoreFactory.eINSTANCE.createUnit();
		u.setName("unit");
		WasSecuritySubjectConstraint constraint = WasFactory.eINSTANCE
				.createWasSecuritySubjectConstraint();
		assert 0 == u.getConstraints().size();
		u.getConstraints().add(constraint);
		assert 1 == u.getConstraints().size();
		IDeployStatus errorStatus = assertContainsStatus(
				validator.validate(constraint, u, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		IDeployResolutionContext context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		IDeployResolution [] resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == u.getConstraints().size();

		Capability c = CoreFactory.eINSTANCE.createCapability();
		assert 0 == c.getConstraints().size();
		c.getConstraints().add(constraint);
		assert 1 == c.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, c, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == c.getConstraints().size();

		Requirement r = CoreFactory.eINSTANCE.createRequirement();
		assert 0 == r.getConstraints().size();
		r.getConstraints().add(constraint);
		assert 1 == r.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, r, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == r.getConstraints().size();

		DependencyLink dl = CoreFactory.eINSTANCE.createDependencyLink();
		assert 0 == dl.getConstraints().size();
		dl.getConstraints().add(constraint);
		assert 1 == dl.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, dl, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == dl.getConstraints().size();

		ConstraintLink ll = CoreFactory.eINSTANCE.createConstraintLink();
		assert 0 == ll.getConstraints().size();
		ll.getConstraints().add(constraint);
		assert 1 == ll.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, ll, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == ll.getConstraints().size();

		RealizationLink rl = CoreFactory.eINSTANCE.createRealizationLink();
		assert 0 == rl.getConstraints().size();
		rl.getConstraints().add(constraint);
		assert 1 == rl.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, rl, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == rl.getConstraints().size();

		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		assert 0 == hl.getConstraints().size();
		hl.getConstraints().add(constraint);
		assert 1 == hl.getConstraints().size();
		errorStatus = assertContainsStatus(
				validator.validate(constraint, hl, monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == hl.getConstraints().size();

	}

	/**
	 * test {@link WasSecuritySubjectConstraintValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasSecuritySubjectConstraintValidatorForServer()
			throws IOException, CoreException {

		Topology top = createTopology("testWasSecuritySubjectConstraintValidatorForServer");

		WasSecuritySubjectConstraint constraint = WasFactory.eINSTANCE
				.createWasSecuritySubjectConstraint();

		EarModule ear1 = J2eeFactory.eINSTANCE.createEarModule();
		top.getUnits().add( ear1 );
		J2EESecurityRole role = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role.setRole( "foo" );
		role.getConstraints().add(constraint);
		ear1.getCapabilities().add(role);
		WebsphereAppServerUnit server = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		top.getUnits().add( server );
		HostingLink link = LinkFactory.createHostingLink(server, ear1);
		assertDoesNotContainStatus(validator.validate(constraint, role,
				monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);
		top.getUnits().add(ear1);
		top.getUnits().add(server);
		
		IStatus status = validator.validate(constraint, role,
				monitor);
		assertDoesNotContainStatus(status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);
		IDeployStatus errorStatus = assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL,
				1);
		IDeployResolutionContext context = new DeployResolutionContext (errorStatus, dvs, null);
		assert setDefaultSubjectGenerator.hasResolutions(context);
		IDeployResolution [] resolutions =  setDefaultSubjectGenerator.getResolutions(context);
		assert 2 == resolutions.length;
		resolutions[0].resolve(monitor);
		status = validator.validate(constraint, role, monitor);
		assertDoesNotContainStatus (status, IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL);


		constraint.setWasSecuritySubject("bar");
		status = validator
				.validate(constraint, role, monitor);
		assertDoesNotContainStatus(status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);
		assertDoesNotContainStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL);
		errorStatus = assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert configureSecurityGenerator.hasResolutions(context);
		resolutions =  configureSecurityGenerator.getResolutions(context);
		assert 4 == resolutions.length;
		// default is that global security is disabled
		assertDoesNotContainStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND);
//		errorStatus = assertContainsStatus(
//				status,
//				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
//				1);
		WasSecurity security = WasFactory.eINSTANCE.createWasSecurity();
		security.setName("security");
		security.setGlobalSecurityEnabled(true);
		server.getCapabilities().add(security);
		status = validator.validate(constraint, role, monitor);
		errorStatus = assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);
		
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert setDefaultSubjectGenerator.hasResolutions(context);
		resolutions =  setDefaultSubjectGenerator.getResolutions(context);
		assert 2 == resolutions.length;

//		WasSecurity security = WasFactory.eINSTANCE.createWasSecurity();
		security.setGlobalSecurityEnabled(false);
//		server.getCapabilities().add(security);
		status = validator
				.validate(constraint, role, monitor);
		assert status.isOK() : getStatusDescriptions(status);

		security.setGlobalSecurityEnabled(true);
		security.setActiveUserRegistry(WasUserRegistryTypes.OS_LITERAL);
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);

		// add J2EE security role but not Was security subject
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);

		// find OS but not user/group
		WasNodeUnit node = WasFactory.eINSTANCE.createWasNodeUnit();
		top.getUnits().add(node);
		LinkFactory.createHostingLink(node, server);
		WasSystemUnit system = WasFactory.eINSTANCE.createWasSystemUnit();
		top.getUnits().add(system);
		LinkFactory.createHostingLink(system, node);
		OperatingSystemUnit os = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		top.getUnits().add(os);
		LinkFactory.createHostingLink(os, system);
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);

		// add security subject as group
		UserGroupUnit groupUnit = OsFactory.eINSTANCE.createUserGroupUnit();
		UserGroup group = OsFactory.eINSTANCE.createUserGroup();
		group.setGroupName("bar");
		groupUnit.getCapabilities().add(group);
		top.getUnits().add(groupUnit);
		LinkFactory.createHostingLink(os, groupUnit);
		status = validator
				.validate(constraint, role, monitor);
		assert status.isOK();

		security.setActiveUserRegistry(WasUserRegistryTypes.LDAP_LITERAL);
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);
	}

	/**
	 * test {@link WasSecuritySubjectConstraintValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasSecuritySubjectConstraintValidatorForCluster()
			throws IOException, CoreException {

		Topology top = createTopology("testWasSecuritySubjectConstraintValidatorForCluster");

		WasSecuritySubjectConstraint constraint = WasFactory.eINSTANCE
				.createWasSecuritySubjectConstraint();

		EarModule ear = J2eeFactory.eINSTANCE.createEarModule();
		J2EESecurityRole role = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role.setRole("foo");
		ear.getCapabilities().add(role);
		top.getUnits().add(ear);
		WasClusterUnit cluster = WasFactory.eINSTANCE.createWasClusterUnit();
		Requirement member = CoreFactory.eINSTANCE.createRequirement();
		member.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		member.setDmoEType(WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT);
		cluster.getRequirements().add(member);
		top.getUnits().add(cluster);
		HostingLink link = LinkFactory.createHostingLink(cluster, ear);
		role.getConstraints().add(constraint);
		assertDoesNotContainStatus(validator.validate(constraint, role,
				monitor),
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);

		addServer(top, ear, cluster, link, constraint);
		addServer(top, ear, cluster, link, constraint);
	}
	
	private void addServer (Topology top, Unit ear, WasClusterUnit cluster, HostingLink link, WasSecuritySubjectConstraint constraint) throws CoreException {
		WebsphereAppServerUnit server = WasFactory.eINSTANCE
		.createWebsphereAppServerUnit();
		LinkFactory.createMemberLink(cluster, server);
		top.getUnits().add(server);
		
		int numServers = WebsphereContext.getMembers(cluster, WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, cluster.getEditTopology()).size();

		J2EESecurityRole role = ( J2EESecurityRole ) constraint.getParent();
		
		if (1 == numServers) {
//			constraint.setJ2eeSecurityRole("foo");
			IStatus status = validator.validate(constraint, role,
					monitor);
			assertDoesNotContainStatus(status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);
			assertContainsStatus(
					status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL,
					1);
	
			constraint.setWasSecuritySubject("bar");
			status = validator
					.validate(constraint, role, monitor);
			assertDoesNotContainStatus(status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT);
			assertDoesNotContainStatus(
					status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL);
			assertContainsStatus(
					status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED,
					1);
			// default for was security is not false
//			assertContainsStatus(
//					status,
//					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
//					1);

		}
		WasSecurity security = WasFactory.eINSTANCE.createWasSecurity();
		security.setGlobalSecurityEnabled(false);
		server.getCapabilities().add(security);
		IStatus status = validator
				.validate(constraint, role, monitor);
		if (1 == numServers) {
			assert status.isOK() : getStatusDescriptions(status);
		} else {
			assertContainsStatus (status, IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT, 1);
		}
		
		security.setGlobalSecurityEnabled(true);
		security.setActiveUserRegistry(WasUserRegistryTypes.OS_LITERAL);
		status = validator
				.validate(constraint, role, monitor);

		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);
		assertDoesNotContainStatus(status, IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT);

		if (1 == numServers) {
			assertContainsStatus(
					status,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
					1);
		}
		
		
// find OS but not user/group
		WasNodeUnit node = WasFactory.eINSTANCE.createWasNodeUnit();
		top.getUnits().add(node);
		LinkFactory.createHostingLink(node, server);
		WasSystemUnit system = WasFactory.eINSTANCE.createWasSystemUnit();
		top.getUnits().add(system);
		LinkFactory.createHostingLink(system, node);
		OperatingSystemUnit os = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		top.getUnits().add(os);
		LinkFactory.createHostingLink(os, system);
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);
		assertDoesNotContainStatus(status, IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT);

// add security subject as group
		UserGroupUnit groupUnit = OsFactory.eINSTANCE.createUserGroupUnit();
		UserGroup group = OsFactory.eINSTANCE.createUserGroup();
		group.setGroupName("bar");
		groupUnit.getCapabilities().add(group);
		top.getUnits().add(groupUnit);
		LinkFactory.createHostingLink(os, groupUnit);
		status = validator
				.validate(constraint, role, monitor);
		assert status.isOK();

		group.setGroupName("dummy");
		
		// try a user instead
		UserUnit userUnit = OsFactory.eINSTANCE.createUserUnit();
		User user = OsFactory.eINSTANCE.createUser();
		user.setUserId("bar");
		userUnit.getCapabilities().add(user);
		LinkFactory.createHostingLink(os, userUnit);
		status = validator.validate(constraint, role, monitor);
		assert status.isOK();

		security.setActiveUserRegistry(WasUserRegistryTypes.LDAP_LITERAL);
		status = validator
				.validate(constraint, role, monitor);
		assertContainsStatus(
				status,
				IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
				1);
		
		// reset so when add new servers it isn't a problem
		security.setActiveUserRegistry(WasUserRegistryTypes.OS_LITERAL);
	}

	private IDeployStatus assertContainsStatus(IStatus s, String problemType, int count)
			throws CoreException {
		int found = 0;
		StringBuffer markerDescriptions = new StringBuffer();
		IDeployStatus lastFound = null;
		for (Iterator iter = new StatusIterator(s); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus status = (IDeployStatus) st;

				if ((problemType != null)
						&& (!problemType.equals(status.getProblemType()))) {
					continue;
				}

				if (markerDescriptions.length() > 0) {
					markerDescriptions.append('\n');
				}
				markerDescriptions.append(DeployMarker.toString(status
						.getMarker()));

				found++;
				lastFound = status;
			}
		}

		if (count < 0) {
			assert found > 0 : "status does not contain required problem type";
		} else {
			assert found == count : "status has " + found
					+ " required problem type; expected " + count + ":\n"
					+ markerDescriptions;
		}
		return lastFound;
	}

	private void assertDoesNotContainStatus(IStatus s, String problemType)
			throws CoreException {
		int found = 0;
		StringBuffer problemDescriptions = new StringBuffer();

		for (Iterator iter = new StatusIterator(s); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus status = (IDeployStatus) st;

				if ((problemType != null)
						&& (!problemType.equals(status.getProblemType()))) {
					continue;
				}

				if (problemDescriptions.length() > 0) {
					problemDescriptions.append('\n');
				}
				problemDescriptions.append(DeployMarker.toString(status
						.getMarker()));

				found++;
			}
		}

		assert found == 0 : "status has " + found
				+ " required problem type; expected " + 0 + ":\n"
				+ problemDescriptions;
	}

	private String getProblemDescriptions(IStatus status) {
		StringBuffer problemDescriptions = new StringBuffer();
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus s = (IDeployStatus) st;

				if (!s.isOK()) {
					if (problemDescriptions.length() > 0) {
						problemDescriptions.append('\n');
					}
				}

				if (!s.isOK()) {
					problemDescriptions.append(s.getProblemType());
				}
			}
		}

		return problemDescriptions.toString();
	}

	private String getStatusDescriptions(IStatus status) {
		StringBuffer statusDescriptions = new StringBuffer();
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus s = (IDeployStatus) st;

				if (statusDescriptions.length() > 0) {
					statusDescriptions.append('\n');
				}

				statusDescriptions.append(s.toString());
			}
		}

		return statusDescriptions.toString();
	}

}
