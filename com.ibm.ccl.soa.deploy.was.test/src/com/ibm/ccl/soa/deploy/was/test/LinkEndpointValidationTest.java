/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * @since 3.2
 * 
 */
public class LinkEndpointValidationTest extends TopologyTestCase {

	/**
	 * 
	 */
	public LinkEndpointValidationTest() {
		super("LinkEndpointValidationTest");
	}

	/**
	 * @throws Exception
	 */
	public void testHostingLink() throws Exception {
		Topology top = createTopology("testHostingLink", true);

		WebsphereAppServerUnit wasUnit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		wasUnit.setName("wasUnit");
		top.getUnits().add(wasUnit);

		EJBContainer ejbContainer = J2eeFactory.eINSTANCE.createEJBContainer();
		ejbContainer.setName("ejbContainer");
		wasUnit.getHostingOrAnyCapabilities().add(ejbContainer);

		//

		EjbModule ejbModule = J2eeFactory.eINSTANCE.createEjbModule();
		ejbModule.setName("ejbModule");
		top.getUnits().add(ejbModule);

		Requirement requiredWasServer = CoreFactory.eINSTANCE
				.createRequirement();
		requiredWasServer.setName("requiredWasServer");
		requiredWasServer.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasServer.setDmoEType(WasPackage.Literals.WAS_SERVER);
		ejbModule.getRequirements().add(requiredWasServer);

		//

		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setName("link");
		link.setHosted(ejbModule);
		wasUnit.getHostingLinks().add(link);

		//
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		assert link.getStatus().getSeverity() == IStatus.ERROR;

		WasServer wasServer = WasFactory.eINSTANCE.createWasServer();
		wasServer.setName("wasServer");
		wasUnit.getHostingOrAnyCapabilities().add(wasServer);

		validator.validate(top);
		assert link.getStatus().getSeverity() == IStatus.OK : getString(link
				.getStatus());
	}
}
