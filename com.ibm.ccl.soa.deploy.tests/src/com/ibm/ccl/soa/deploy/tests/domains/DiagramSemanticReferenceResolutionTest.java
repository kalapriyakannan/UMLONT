/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.domains;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;

/**
 * Tests the use of {@link EMFCoreUtil#getReferencers} in a topology and its
 * topologyv diagram.
 */
public class DiagramSemanticReferenceResolutionTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "CrossDomainRequirementSerializationTest";

	public DiagramSemanticReferenceResolutionTest() {
		super(PROJECT_NAME);
	}

	/**
	 * Creates a diagram and diagramv file referencing it to test the
	 * {@link EMFCoreUtil#getReferencers}.
	 * 
	 * @throws Exception
	 *             if an error occurs.
	 */
	public void testReferenceResolution() throws Exception {
		// Create the semantic model topology and file.
		final Topology top = createTopology("testCrossDomainSerialization",
				true);

		// Create a WAS unit with an OS requirement.
		final Unit[] units = new Unit[1];
		executeEditOperation(top, new Runnable() {
			public void run() {
				WasSystemUnit was = WasFactory.eINSTANCE.createWasSystemUnit();
				was.setName("was");
				top.getUnits().add(was);

				Requirement req = CoreFactory.eINSTANCE.createRequirement();
				req.setName("req");
				req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				req.setDmoEType(OsPackage.eINSTANCE.getOperatingSystem());
				was.getRequirements().add(req);

				units[0] = was;
			}
		});

		top.eResource().save(null);

		// Create diagram model and file.
		final Diagram diagram = createDiagram(top.getName(), true);

		// Create a diagram Node whose element is the WAS unit.
		IStatus status = executeEditOperation(top, top.getName(),
				new Runnable() {
					public void run() {
						Node node = diagram
								.createChild(NotationPackage.eINSTANCE
										.getNode());
						node.setElement(units[0]);

						// Validate that the Node is indexed in reverse from the
						// was unit.
						Collection c = EMFCoreUtil.getReferencers(units[0],
								new EReference[] { NotationPackage.eINSTANCE
										.getView_Element() });
						assert c.size() == 1 : c.size();
						assert c.iterator().next().equals(units[0]);
					}
				});
		assert status.getSeverity() == IStatus.OK : status.getMessage();

		diagram.eResource().save(null);
	}

	/**
	 * Creates an empty notation diagram associated with an Eclipse resource.
	 * 
	 * @param name
	 *            the name used for the diagram and the resource URI.
	 * @param save
	 *            true if the resource should be saved.
	 * 
	 * @throws IOException
	 *             if the save fails.
	 * 
	 * @return the diagram object.
	 */
	protected Diagram createDiagram(String name, boolean save)
			throws IOException {
		URI uri = URI.createPlatformResourceURI(getName() + '/' + name
				+ ".topologyv");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		Diagram dia = NotationFactory.eINSTANCE.createDiagram();
		res.getContents().add(dia);

		if (save) {
			res.save(null);
		}
		return dia;
	}
}
