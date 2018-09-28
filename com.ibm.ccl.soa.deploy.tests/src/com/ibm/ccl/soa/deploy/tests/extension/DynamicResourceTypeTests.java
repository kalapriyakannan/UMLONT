/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

/**
 * Tests the {@link IUnitProviderService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class DynamicResourceTypeTests extends TopologyTestCase {

	private static final String PROJECT_NAME = "testDynamicResourceType";
	
	/**
	 * 
	 */
	public DynamicResourceTypeTests() {
		super(PROJECT_NAME);
		setDeleteProjectOnTearDown( false );
	}


	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testDynamicResourceType() throws Exception {

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		assert rts != null;
		
		// Test dynamic resource creation
		String id = "test.resource.id";
		String path = "/localExtensions/";
		String label = "Test Dynamic Resource";
		String description = "A sample test dynamic resource description";
		String smallIcon = "";  // TODO
		String largeIcon = ""; // TODO
		
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("testUnit");
		unit.setDisplayName("Test Unit");
		Unit units[] = new Unit[1];
		units[0] = unit;
		
		rts.addDynamicResourceType( id, path, label, description, smallIcon, largeIcon, units, PROJECT_NAME);
		rts.addDynamicResourceType( "id2", path, "label2", description, smallIcon, largeIcon, units, PROJECT_NAME);
		
		int len = rts.getDynamicPaletteEntries().length;
		assert len > 0;
		
		// Test rename
		String newname = "Renamed Test Dynamic Resource";
		String origname = rts.getResourceTypeName(id);
		assert rts.getResourceTypeName(id).equals(label);
		rts.renameResourceType(id, newname);
		String name = rts.getResourceTypeName(id);
		assert rts.getResourceTypeName(id).equals(newname);
		
		// Test created topology
		String uri = rts.getTemplateURI(id);
		assert uri != null;
		Topology top = getTopology( uri );
		assert top != null;
		assert rts.isDynamicPaletteEntry(top);
		assert !rts.isDynamicPaletteEntry(CoreFactory.eINSTANCE.createTopology());
		
		rts.removeDynamicResourceType(id);
		assert rts.getDynamicPaletteEntries().length == (len-1);
		
		rts.addDynamicPaletteStack("stackid", "/somedrawer", "stacklabel", smallIcon, PROJECT_NAME);
		assert rts.getDynamicStackEntries().length > 0;
		
	}
	
	private Topology getTopology(String templateURIString)
	{
		URI templateURI = URI.createURI(templateURIString);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(templateURI, true);

		if (resource != null) {
			DeployCoreRoot root = null;
			if (resource.getContents() != null && !resource.getContents().isEmpty()) {
				root = (DeployCoreRoot) resource.getContents().get(0);
			}
			if (root != null) {
				return root.getTopology();
			}
		}
		return null;
	}

}
