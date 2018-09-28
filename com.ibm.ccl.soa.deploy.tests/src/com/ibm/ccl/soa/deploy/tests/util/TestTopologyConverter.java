/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.util;

import java.io.IOException;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

/**
 * Test case for realization of WAS clusters. Exercises auto-realization and
 * WebSphere code.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class TestTopologyConverter extends TopologyTestCase {

	/** Platform path to test topology files. */
	String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies/wasCluster";

	String topologyURIStrings[] = { 
			URL_PREFIX + "/NDPlusDeploymentManagerConceptual.topology",
			URL_PREFIX + "/NDPlusDeploymentManager.topology", 
			URL_PREFIX + "/NDAppServerConceptual.topology",
			URL_PREFIX + "/NDAppServer.topology",
			URL_PREFIX + "/AbstractNDCluster.topology",
			URL_PREFIX + "/AbstractWASServerInNDCluster.topology"
	};

	/** Test case ctor */
	public TestTopologyConverter() {
		super("ClusterRealizationsTest");
		setDeleteProjectOnTearDown(false);
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * @throws IOException
	 */
	public void testConvertRequirementExpressions() throws IOException {
		for (int i = 0; i < topologyURIStrings.length; ++i) {
			String uriString = topologyURIStrings[i];
			String uriStringSegments[] = uriString.split("/");
			Topology top = loadTopology(uriString);
			String topName = top.getName();
			if (uriStringSegments.length > 1) {
				topName = uriStringSegments[uriStringSegments.length-1];
				String splitName[] = topName.split("\\.");
				if (splitName.length == 2) {
					topName = splitName[0];
				}
			}
			top.eResource().setURI(getURI(topName, top.getNamespace()));
			RequirementExpressionToConstraintConversionUtils.convertExpressions(top);
			save(top);
		}
	}
}
