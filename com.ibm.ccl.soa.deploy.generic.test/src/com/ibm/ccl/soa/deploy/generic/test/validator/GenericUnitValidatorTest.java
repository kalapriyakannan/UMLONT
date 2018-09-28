/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.test.validator;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 */
public class GenericUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "GenericUnitValidatorTest"; //$NON-NLS-1$

	public GenericUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testGenericUnitValidator() throws IOException, CoreException {

		doTemplateLoad("platform:/plugin/com.ibm.ccl.soa.deploy.generic/templates/Generic.template");

		Topology top = createTopology("GenericUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		//GenericUnitValidator validator = new GenericUnitValidator();

		//
		// build test topology
		//

		Unit genericUnit = CoreFactory.eINSTANCE.createUnit();
		genericUnit.setName("genericUnit");
		genericUnit.setDisplayName("genericUnit");
		top.getUnits().add(genericUnit);


	}


	/**
	 * @param templateURIString
	 * @throws IOException
	 */
	private void doTemplateLoad(String templateURIString) throws IOException {
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);

		resource.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) resource.getContents()
				.get(0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);
		resource.unload();
	}
}
