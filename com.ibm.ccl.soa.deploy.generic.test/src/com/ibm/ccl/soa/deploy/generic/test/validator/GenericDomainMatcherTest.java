/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.test.validator;

/**
 * Test for generic domain matchers
 * 
 * @version
 * @author Bill Arnold (barnold@us.ibm.com)
 */

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.generic.validator.GenericDomainValidator;
import com.ibm.ccl.soa.deploy.generic.validator.matcher.GenericDomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Tests {@link GenericDomainMatcher}.
 */
public class GenericDomainMatcherTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "GenericDomainMatcherTest"; //$NON-NLS-1$

	public GenericDomainMatcherTest() {
		super(PROJECT_NAME);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
// project.delete(true, true, null);
	}

	public void testDB2DomainMatcher() throws IOException, CoreException {

		Topology top = createTopology("GenericDomainValidator", true); //$NON-NLS-1$

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		GenericDomainValidator validator = new GenericDomainValidator();

		// TODO some basic tests here, if we add a custom matcher.
// assert
// (validator.getDomainMatcher().canCreateLink(databaseUnit,systemUnit,LinkType.ALL_LINK_TYPES).isOK());
// assert
// (validator.getDomainMatcher().canCreateLink(systemUnit,databaseUnit,LinkType.ALL_LINK_TYPES).isOK());
//		
// LinkDescriptor [] hld =
// validator.getDomainMatcher().getPossibleLinks(databaseUnit,
// systemUnit,LinkType.ALL_LINK_TYPES);
// assert hld.length > 0;

		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		validator.validate(context, reporter);
		dumpMarkers(top);
	}
}
