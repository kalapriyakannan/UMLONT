/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.j2ee.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.validator.EarModuleValidator;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;

/**
 * Tests {@link EarModuleValidator}.
 */
public class J2EEDataSourceLinkValidatorTest extends TopologyTestCase {

	public static final String PROJECT_NAME = J2EEDataSourceLinkValidatorTest.class
			.getName();

	public J2EEDataSourceLinkValidatorTest() {
		super(PROJECT_NAME);
	}

	public void testJndiName() throws Exception {
		Topology top = createTopology("jndiName", true);
		EjbModule ejbModule = J2eeFactory.eINSTANCE.createEjbModule();
		ejbModule.setName("ejbModule");
		top.getUnits().add(ejbModule);

		Requirement dsReq = CoreFactory.eINSTANCE.createRequirement();
		dsReq.setName("consumedDS");
		dsReq.setDmoEType(J2eePackage.eINSTANCE.getJ2EEDatasource());
		dsReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		ejbModule.getRequirements().add(dsReq);

		WasDatasourceUnit dsUnit = WasFactory.eINSTANCE
				.createWasDatasourceUnit();
		dsUnit.setName("dsUnit");
		top.getUnits().add(dsUnit);

		J2EEDatasource providedDS = J2eeFactory.eINSTANCE
				.createJ2EEDatasource();
		providedDS.setName("providedDS");
		providedDS.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedDS.setDatasourceName("Somename");
		providedDS.setJndiName("Somename");
		dsUnit.getOnlyDependencyCapabilities().add(providedDS);

		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("link");
		link.setTarget(providedDS);
		link.setSource(dsReq);
		dsReq.setLink(link);

		top.getEObject().eResource().save(null);

		DeployValidatorService validator = DeployValidatorService.getDefaultValidatorService();

		//
		validator.validate(top);
		assert dsReq.getStatus().getSeverity() == IStatus.OK : getString(dsReq
				.getStatus());
		assert link.getStatus().getSeverity() == IStatus.OK;

		//
		String jndiName = "plantsByWS";
		RequirementUtil.setAttribute(dsReq, J2eePackage.eINSTANCE
				.getJ2EEDatasource_JndiName(), jndiName);
		validator.validate(top);
		assert dsReq.getStatus().getSeverity() == IStatus.OK : getString(dsReq
				.getStatus());
		assert providedDS.getStatus().getSeverity() != IStatus.OK : dumpStatus(top);

		//
		providedDS.setJndiName(jndiName);
		providedDS.clearStatus();
		validator.validate(top);
		assert dsReq.getStatus().getSeverity() == IStatus.OK : getString(dsReq
				.getStatus());
		assert dsReq.getStatus().getSeverity() == IStatus.OK;
		assert providedDS.getStatus().getSeverity() == IStatus.OK;
		assert link.getStatus().getSeverity() == IStatus.OK;

		//
		providedDS.setJndiName("otherName");
		validator.validate(top);
		assert dsReq.getStatus().getSeverity() == IStatus.OK;
		assert providedDS.getStatus().getSeverity() != IStatus.OK : getString(providedDS
				.getStatus());
	}
}
