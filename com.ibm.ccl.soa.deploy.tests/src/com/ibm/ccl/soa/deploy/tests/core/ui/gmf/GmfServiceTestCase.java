/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.gmf;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin; // import
															// com.ibm.ccl.soa.deploy.core.ui.properties.ServiceLinkLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.was.test.PlantsByWebsphereTest;

/**
 * Tests for GMF
 * 
 * @author Ed Snible <snible@us.ibm.com>
 */
public class GmfServiceTestCase extends TopologyTestCase {

	/**
	 * Test case ctor
	 * 
	 * @param name
	 */
	public GmfServiceTestCase(String name) {
		super(name);
	}

	/** Test to see if {@link ServiceLinkLabelProvider} ctor works */
	public void testPlants() throws Exception {

		// Create Topology
		PlantsByWebsphereTest pbwt = new PlantsByWebsphereTest();
		// TODO This fails, because PlantsByWebsphereTest uses a different 'top'
		Topology top = pbwt.createPlantsByTopology();

		PreferencesHint ph = new PreferencesHint(DeployCoreUIPlugin.PLUGIN_ID);

		// TODO We'd like to test/use TopologyDiagramCreateHelper here, but it
		// is internal...
// Diagram diagram = TopologyDiagramCreateHelper.create(top);

		// Create a Diagram based on the Topology instance
		Diagram diagram = ViewService.getInstance().createDiagram(
				new EObjectAdapter(top), DeployCoreConstants.DEPLOY_CORE, ph);
		Assert.assertNotNull(diagram);

		// Create a Node for each Unit
		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();

			// Create a Node in the diagram
			Node node = ViewService.createNode(diagram, unit, null, ph);
			Assert.assertNotNull(node);
		}

		// (Ignore edges)

		// Verify an EditPart can be built for each Node
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();

			IGraphicalEditPart igep = EditPartService.getInstance()
					.createGraphicEditPart(node);
			Assert.assertNotNull(igep);
		}

	}

} // end class PropertiesTestCase
