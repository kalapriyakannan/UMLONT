/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class TopologyUiTestCase extends TopologyTestCase {

	public TopologyUiTestCase(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
