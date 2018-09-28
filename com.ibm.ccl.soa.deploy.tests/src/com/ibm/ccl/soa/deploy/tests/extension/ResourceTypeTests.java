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
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;

/**
 * Tests the {@link IUnitProviderService} implementation available from
 * <b>com.ibm.ccl.soa.deploy.core</b>.
 * 
 */
public class ResourceTypeTests extends DomainTestCase {

	private static final String PROJECT_NAME = "ResourceTypeTests";

	private static final String WIN_2K_RESOURCE_ID = IOsTemplateConstants.OS_WINDOWS_2000_UNIT; //"os.OperatingSystemUnit.W2K";
	private static final String WIN_2K_RESOURCE_ID_CONC = IOsTemplateConstants.OS_WINDOWS_2000_UNIT_CONCEPTUAL; //"os.OperatingSystemUnit.W2K.conceptual";
	private static final String WIN_2K_RESOURCE_NAME = "Windows 2000";
	private static final String WIN_2K_RESOURCE_URL = "platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/Windows2000.template";

    private static final String WIN_2K_SMALL_ICON = "icons/pal/win_2000_16.gif";
    private static final String WIN_2K_LARGE_ICON = "icons/pal/win_2000_20.gif";
    private static final String WIN_2K_PATH = "/operatingSystemDrawer/windowsOperatingSystemStack";
    
	private static final String WTP_CONTEXT = "wtp";
    
	/**
	 * Create the test.
	 * 
	 * @param name
	 */
	public ResourceTypeTests() {
		super(PROJECT_NAME);
	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testResourceTypeExtension() throws Exception {

		ResourceTypeDescriptor rsDesc = DomainManager.getInstance()
				.getResourceType(WIN_2K_RESOURCE_ID);
		assert rsDesc.getId().equals(WIN_2K_RESOURCE_ID);
		assert rsDesc.getName().equals(WIN_2K_RESOURCE_NAME);
		assert rsDesc.getTemplateUri().equals(WIN_2K_RESOURCE_URL);
	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testResourceTypePaletteBindingExtension() throws Exception {

		ResourceTypeUIBindingDescriptor rsDesc = DomainManager
				.getInstance().getResourceTypeUIBinding(WIN_2K_RESOURCE_ID_CONC);
		assert rsDesc != null;
		assert rsDesc.getLabel().equals(WIN_2K_RESOURCE_NAME);
		assert rsDesc.getPath().equals(WIN_2K_PATH);
		assert rsDesc.getSmallIcon().equals(WIN_2K_SMALL_ICON);
		assert rsDesc.getLargeIcon().equals(WIN_2K_LARGE_ICON);

		rsDesc = DomainManager.getInstance().getResourceTypeUIBinding(
				"DUMMY");
		assert rsDesc == null;

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		DynamicPaletteEntry[] paletteEntries = rts
				.getRegisteredPaletteEntries();
		assert paletteEntries != null;
		assert paletteEntries.length > 0;
	}

	/**
	 * Verify that a test extension can be consumed correctly.
	 * 
	 * @throws Exception
	 *             When bad things happen.
	 */
	public void testTemplateLoading() throws Exception {
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/resourceType.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Resource Type Topology");
		// do stuff
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		Unit unit = (Unit)rts.createFromTemplate(
				WIN_2K_RESOURCE_ID, top);

		root.setTopology(top);
		res.save(null);
		res.unload();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void testDynamicResourceTypes() throws Exception {
		// Hard code some of this for now
		String path = "/some/place";
		String id = "my.new.resource.id";
		String label = "My Resource";
		String desc = "A description of my new resource id";
		String smallIcon = "/small/icon";
		String largeIcon = "/large/icon";
		Unit units[] = new Unit[1];

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("a test unit ");
		units[0] = unit;

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		rts.addDynamicResourceType(id, path, label,
				desc, smallIcon, largeIcon, units, PROJECT_NAME);

		assert rts.isDynamicPaletteEntry(id);
		assert !rts.isDynamicPaletteEntry("foo");
	}
	
	public void testEclassResourceTypes()
	{
		String REFERENCE_ID = "deploy.Reference";
		ResourceTypeDescriptor rsDesc = DomainManager.getInstance().getResourceType(REFERENCE_ID);
		assert rsDesc != null;
		assert rsDesc.getEclass() != null;
		
	}

}
