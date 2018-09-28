/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.core.ui.gmf;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.was.WasFactory;

/**
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class EMFCoreUtilTestCase extends TopologyTestCase {

	public EMFCoreUtilTestCase(String name) {
		super(name);
	}

	/**
	 * This test case is used to test EMFCoreUtil.getReferencers method.
	 * 
	 * @throws Exception
	 */
	public void testGetViewElement() throws Exception {
		Topology top = createTopology("testGetViewElement");
		Unit wasNode = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNode.setName("testNode");
		top.getUnits().add(wasNode);

		PreferencesHint ph = new PreferencesHint(DeployCoreUIPlugin.PLUGIN_ID);
		// Create a Diagram based on the Topology instance
		Diagram diagram = ViewService.getInstance().createDiagram(
				new EObjectAdapter(top), DeployCoreConstants.DEPLOY_CORE, ph);
		diagram.setName("testDiagram");
		assertNotNull(diagram);

		// Create a Node for each Unit
		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();

			// Create a Node in the diagram
			Node node = ViewService.createNode(diagram, unit, "unitGroup.was",
					ph);
			assertNotNull(node);
		}

		// Verify an EditPart can be built for each Node
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();

			IGraphicalEditPart igep = EditPartService.getInstance()
					.createGraphicEditPart(node);
			assertNotNull(igep);
		}

		// Verify EMFCoreUtil.getReferencers method
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			Collection views = EMFCoreUtil.getReferencers(node.getElement(),
					new EReference[] { NotationPackage.eINSTANCE
							.getView_Element() });
			assertTrue(views.size() > 1);
		}
	}
}
