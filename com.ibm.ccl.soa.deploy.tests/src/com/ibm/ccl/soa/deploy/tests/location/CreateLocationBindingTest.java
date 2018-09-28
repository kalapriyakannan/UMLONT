/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.location;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationFactory;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;

/**
 * @since 1.0
 * 
 */
public class CreateLocationBindingTest extends DomainTestCase {

	private static final String PROJECT_NAME = "CreateLocationBindingTest";

	/**
	 * 
	 */
	public CreateLocationBindingTest() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testLocationBinding() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/testCreateLocationBinding_rdm.tloc");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		LocationBindingRoot root = LocationFactory.eINSTANCE
				.createLocationBindingRoot();
		res.getContents().add(root);
		LocationBinding locbind = LocationFactory.eINSTANCE
				.createLocationBinding();
		locbind.setName("name1");
		locbind.setTopology("Top1");
		locbind.setContext("ide");
		root.setLocationBinding(locbind);
		// res.getContents().add( locbind );

		BindingEntry en1 = LocationFactory.eINSTANCE.createBindingEntry();
		en1.setDmoPath("populate.populate");
		en1.setLocation("file://D:/Sample/populate.ddl");
		locbind.getBindingEntry().add(en1);

		BindingEntry en2 = LocationFactory.eINSTANCE.createBindingEntry();
		en2.setDmoPath("WebComponent");
		en2.setLocation("platform://WebComponent");
		locbind.getBindingEntry().add(en2);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		LocationBindingRoot locationRoot = (LocationBindingRoot) res
				.getContents().get(0);
		LocationBinding locbind1 = locationRoot.getLocationBinding();
		assertNotNull(locbind1);

		res.unload();

	}

}
