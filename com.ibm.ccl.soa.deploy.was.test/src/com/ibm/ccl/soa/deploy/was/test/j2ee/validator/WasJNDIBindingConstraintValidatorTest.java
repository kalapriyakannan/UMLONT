/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.j2ee.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJNDIBindingConstraintValidator;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.resolution.RemoveWasJ2EEConstraintResolutionGenerator;

public class WasJNDIBindingConstraintValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasJNDIBindingConstraintValidatorTest";

	private NullProgressMonitor monitor = new NullProgressMonitor();
	private WasJNDIBindingConstraintValidator validator = new WasJNDIBindingConstraintValidator();
    private DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	private RemoveWasJ2EEConstraintResolutionGenerator removeGenerator = new RemoveWasJ2EEConstraintResolutionGenerator();
	
	private static EClass WasJNDIBindingConstraintType = WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT;
	private static String WasJNDIBindingConstraintName = "WebSphere JNDI Binding Constraint";


	/**
	 * 
	 * 
	 */
	public WasJNDIBindingConstraintValidatorTest() {
		super(PROJECT_NAME);
	}
	
	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}
	
	public void testWasJNDIBindingConstraintValidator() throws Exception {
		Unit u = CoreFactory.eINSTANCE.createUnit();
		u.setName( "unit" );
		WasJNDIBindingConstraint constraint = WasFactory.eINSTANCE.createWasJNDIBindingConstraint();
		assert 0 == u.getConstraints().size();
		u.getConstraints().add( constraint );
		IDeployStatus errorStatus = assertContainsStatus(
				validator.validate(constraint, u, monitor),
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
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
				IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
				1);
		context = new DeployResolutionContext (errorStatus, dvs, null);
		assert removeGenerator.hasResolutions(context);
		resolutions =  removeGenerator.getResolutions(context);
		assert 1 == resolutions.length;
		resolutions[0].resolve(monitor);
		assert 0 == hl.getConstraints().size();
	}
	
	public void testWasJNDIBindingConstraintPlacement1() throws Exception {
		
		// a WasJNDIBindingConstraint should not be possible on lots of types of units, capabilities, links, and requirements
		Unit unit;
		Requirement req;
		Capability cap;
		unit = CoreFactory.eINSTANCE.createUnit();
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, unit);
		req = addRequirement(unit, "req", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.DEPENDENCY_LITERAL);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, req);
		cap = addCapability(unit, "cap", CorePackage.Literals.CAPABILITY, CapabilityLinkTypes.ANY_LITERAL);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, cap);
		
		unit = WasFactory.eINSTANCE.createWasCellUnit();
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, unit);		
	}

	public void testWasJNDIBindingConstraintPlacement2() throws Exception {
		// WasJNDIBindingConstraint is allowed on a J2EE datasource requirement on a J2ee module hosted on WAS server/cluster
		Topology top = createTopology("testWasJNDIBindingConstraintPlacement2");
		Unit ejb = J2eeFactory.eINSTANCE.createEjbModule();
		Requirement req = addRequirement(ejb, "req", J2eePackage.Literals.J2EE_DATASOURCE, RequirementLinkTypes.DEPENDENCY_LITERAL);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, req);
		top.getUnits().add(ejb);
		Unit ear = J2eeFactory.eINSTANCE.createEarModule();
		top.getUnits().add(ear);
		LinkFactory.createMemberLink(ear, ejb);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, req);
		Unit host = WasFactory.eINSTANCE.createWebsphereAppServerUnit();
		top.getUnits().add(host);
		LinkFactory.createHostingLink(host, ear);
		assert constraintAllowedOn(WasJNDIBindingConstraintName, req);
	}

	public void testWasJNDIBindingConstraintPlacement3() throws Exception {
		// WasJNDIBindingConstraint is allowed on a EnterpriseBeanService on a j2ee module hosted on WAS server/cluster
		Topology top = createTopology("testWasJNDIBindingConstraintPlacement3");
		Unit ejb = J2eeFactory.eINSTANCE.createEjbModule();
		Capability cap = addCapability(ejb, "cap", J2eePackage.Literals.J2EE_DATASOURCE, CapabilityLinkTypes.ANY_LITERAL);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, cap);
		top.getUnits().add(ejb);
		Unit ear = J2eeFactory.eINSTANCE.createEarModule();
		top.getUnits().add(ear);
		LinkFactory.createMemberLink(ear, ejb);
		assert !constraintAllowedOn(WasJNDIBindingConstraintName, cap);
		Unit host = WasFactory.eINSTANCE.createWasClusterUnit();
		top.getUnits().add(host);
		LinkFactory.createHostingLink(host, ear);
		assert constraintAllowedOn(WasJNDIBindingConstraintName, cap);
	}

	private boolean XconstraintAllowedOn (EClass constraintType, DeployModelObject dmo) {
		List<ShortConstraintDescriptor> constraints = ConstraintService.INSTANCE.applicableConstraints(dmo);
		for (ShortConstraintDescriptor cd : (List<ShortConstraintDescriptor>) ConstraintService.INSTANCE.applicableConstraints(dmo)) {
//			System.out.println ("CONSTRAINT: " + cd.getTitle());
//			System.out.println ("CONSTRAINT TYPE: " + constraintType.getName());
			Constraint c  = cd.createConstraint(dmo);
			if (constraintType.isSuperTypeOf(c.getEObject().eClass())) {
				return true;
			}
			dmo.getConstraints().remove(c);
		}
		return false;
	}

	private boolean constraintAllowedOn (String constraintName, DeployModelObject dmo) {
		List<ShortConstraintDescriptor> constraints = ConstraintService.INSTANCE.applicableConstraints(dmo);
		for (ShortConstraintDescriptor cd : (List<ShortConstraintDescriptor>) ConstraintService.INSTANCE.applicableConstraints(dmo)) {
//			System.out.println ("CONSTRAINT: " + cd.getTitle());
			if (cd.getTitle().equals(constraintName)) {
				return true;
			}
		}
		return false;
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
