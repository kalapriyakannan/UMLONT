/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.j2ee.ui.marker.resolution;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.validator.resolution.JndiNameDependencyLinkResolutionGenerator;
import com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution.ResolutionTestCase;

/**
 * Tests {@link JndiNameDependencyLinkResolutionGenerator}
 */
public class JndiNameDependencyLinkResolutionTest extends ResolutionTestCase {

	public JndiNameDependencyLinkResolutionTest() {
		super("JndiNameResolutionTest");
	}

	public void testJndiNameResolution() throws Exception {
		Topology top = createTopology("testJndiNameResolution", true);

		// EJB module

		EjbModule ejbModule = J2eeFactory.eINSTANCE.createEjbModule();
		ejbModule.setName("ejbModule");
		top.getUnits().add(ejbModule);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setDmoEType(J2eePackage.eINSTANCE.getJ2EEDatasource());
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		req.setName("reqDS");
//		RequirementExpression expr = Equals.createExpression(
//				J2eePackage.eINSTANCE.getJ2EEDatasource_JndiName(), "jdbc:foo");
//		req.getExpressions().add(expr);
		EqualsConstraint jndiNameEquals = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		jndiNameEquals.setAttributeName(J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME.getName());
		jndiNameEquals.setValue("jdbc:foo");
		req.getConstraints().add(jndiNameEquals);
		ejbModule.getRequirements().add(req);

		Requirement req2 = CoreFactory.eINSTANCE.createRequirement();
		req2.setDmoEType(J2eePackage.eINSTANCE.getJ2EEContainer());
		req2.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		// Hack to avoid having to host.
		req2.setUse(RequirementUsage.OPTIONAL_LITERAL);
		req2.setName("reqJ2EEContainer");
		ejbModule.getRequirements().add(req2);

		// DataSource

		Unit dsUnit = CoreFactory.eINSTANCE.createUnit();
		dsUnit.setName("dsUnit");
		top.getUnits().add(dsUnit);

		J2EEDatasource providedDS = J2eeFactory.eINSTANCE
				.createJ2EEDatasource();
		providedDS.setName("providedDS");
		dsUnit.getOnlyDependencyCapabilities().add(providedDS);

		// Link
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("link");
		link.setTarget(providedDS);
		link.setSource(req);
		req.setLink(link);

		top.getEObject().eResource().save(null);
		//
		assert !jndiNameEquals.getValue().equals(providedDS.getJndiName());

		DeployValidatorService validator = getValidatorService();
		validator.validate(top);
		assert providedDS.getStatus().getSeverity() == IStatus.ERROR : dumpStatus(top);
		IDeployResolution[] resolutions = getDeployResolutions(providedDS
				.getStatus(), DeploySetAttributeResolution.class);
		assert resolutions.length == 1 : resolutions.length + "\n"
				+ dumpStatus(top);

		IStatus resolveStatus = resolutions[0]
				.resolve(new NullProgressMonitor());
		assert resolveStatus.isOK() : getString(resolveStatus) + ":\n"
				+ resolveStatus.getException();
		assert jndiNameEquals.getValue().equals(providedDS.getJndiName());

		validator.validate(top);

		assert providedDS.getStatus().getSeverity() == IStatus.OK;
	}
}
