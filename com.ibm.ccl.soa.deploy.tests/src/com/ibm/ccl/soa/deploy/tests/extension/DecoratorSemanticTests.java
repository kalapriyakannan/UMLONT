/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.internal.core.extension.DecoratorSemanticDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.DecoratorSemanticPatternBindingDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.tests.domains.DomainTestCase;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * @since 1.0
 * 
 */
public class DecoratorSemanticTests extends DomainTestCase {

	private static final String PROJECT_NAME = "DecoratorSemanticTest";
	private static final String BUS_APP_SEMANTIC_ID = "businessApplication";
	private static final String TEST_SEMANTIC_ID = "test.testDecoratorSemantic";
	private static final String TEST_SEMANTIC_NAME = "Test Decorator Semantic";
	private static final String ICON_NAME = "images/someicon.gif";
	private static final String TEST_SEMANTIC_DESC = "A Test Decorator Semantic";

	/**
	 * 
	 */
	public DecoratorSemanticTests() {
		super(PROJECT_NAME);
	}

	/**
	 * @throws Exception
	 */
	public void testDecoratorSemantic() throws Exception {

		/**
		 * Setup
		 */
		URI uri = URI.createPlatformResourceURI(PROJECT_NAME
				+ "/decoratorSemantic.topology");
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("Decorator Semantic Topology");
		
		IDecoratorSemanticService dsService = ExtensionsCore
		.createDecoratorSemanticService();

		// Add a semantic manually
		top.setDecoratorSemantic(BUS_APP_SEMANTIC_ID);
		assert (top.getDecoratorSemantic().equals(BUS_APP_SEMANTIC_ID));

		// Test Decorator Semantic extension/manager/service
		DecoratorSemanticDescriptor[] dsDescs = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		assert (dsDescs.length != 0); // Should be at least one from this test
										// plugin
		String[] names = dsService
				.getAllDecoratorSemanticNames();
		assert names.length > 0;

		// Look up decorator semantic by ID
		DecoratorSemanticDescriptor dsDesc1 = TopologyManager.getInstance()
				.findDecoratorSemantic(TEST_SEMANTIC_ID);
		assert dsDesc1 != null;
		assert dsDesc1.getName().equals(TEST_SEMANTIC_NAME);
		assert dsDesc1.getIcon().equals(ICON_NAME);
		DecoratorSemanticDescriptor dsDesc2 = TopologyManager.getInstance()
				.findDecoratorSemantic("aBogusId");
		assert dsDesc2 == null;

		// Look up semantic ID, desc by name
		assert dsService.getDecoratorSemanticId(
				TEST_SEMANTIC_NAME).equals(TEST_SEMANTIC_ID);
		assert dsService
				.getDecoratorSemanticDescription(TEST_SEMANTIC_NAME).equals(
						TEST_SEMANTIC_DESC);

		// Test Decorator Semantic Pattern Binding extension/manager
		DecoratorSemanticPatternBindingDescriptor[] dspdDescs = TopologyManager
				.getInstance().findAvailableDecoratorSemanticPatternBindings();
		// assert( dspdDescs.length == 3 ); // Should be three from this test
		// plugin
		DecoratorSemanticPatternBindingDescriptor[] dspdDescs1 = TopologyManager
				.getInstance().findDecoratorSemanticPatternBindings(
						TEST_SEMANTIC_ID);
		assert dspdDescs1.length == 1;

		// Test memberOf service - should not contain was content
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		SoftwareComponent sc = CoreFactory.eINSTANCE.createSoftwareComponent();
		WebsphereAppServerUnit wasUnit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		WebModule webUnit = J2eeFactory.eINSTANCE.createWebModule();
		Unit conceptualUnit = CoreFactory.eINSTANCE.createUnit();
		conceptualUnit.setConceptual(true);

		// Type Content
		assert dsService.isDmoMemberOf(
				TEST_SEMANTIC_ID, unit) == false;
		assert dsService.isDmoMemberOf(
				TEST_SEMANTIC_ID, sc) == false;
		assert dsService.isDmoMemberOf(
				TEST_SEMANTIC_ID, conceptualUnit) == false;
		assert dsService.isDmoMemberOf(
				TEST_SEMANTIC_ID, wasUnit) == false;
		assert dsService.isDmoMemberOf(
				TEST_SEMANTIC_ID, webUnit) == false;
		assert dsService.isDmoMemberOf(null, unit) == true;

		// Menu Content
		assert dsService.isMenuMemberOf("foo", "bar") == false;
		assert dsService.isMenuMemberOf(
				TEST_SEMANTIC_ID, "com.some.menus.MyMenu") == true;
		assert dsService.isMenuMemberOf(
				TEST_SEMANTIC_ID, "not.these.menus.MyMenu") == false;
		assert dsService.isMenuMemberOf(null,
				"anything") == true;

		// Validator Content
		/*assert dsService.isValidatorMemberOf("foo",
				"bar") == false;
		assert dsService.isValidatorMemberOf(
				TEST_SEMANTIC_ID, "com.some.ValidatorClass") == true;
		assert dsService.isValidatorMemberOf(
				TEST_SEMANTIC_ID, "not.this.Validator") == false;
		assert dsService.isValidatorMemberOf(null,
				"anything") == true;
*/
		// View Content
		assert dsService.isViewMemberOf("foo", "bar") == false;
		assert dsService.isViewMemberOf(
				TEST_SEMANTIC_ID, "com.include.view") == true;
		assert dsService.isViewMemberOf(
				TEST_SEMANTIC_ID, "com.not.these.view.SomeView") == false;
		assert dsService.isViewMemberOf(null,
				"anything") == true;

		// Unit Proivder Content
		/*assert dsService.isUnitProviderMemberOf("foo",
				"bar") == false;
		assert dsService.isUnitProviderMemberOf(
				TEST_SEMANTIC_ID, "anything.else") == true;
		assert dsService.isUnitProviderMemberOf(
				TEST_SEMANTIC_ID, "com.not.these.providers.SomeProvider") == false;
		assert dsService.isUnitProviderMemberOf(null,
				"anything") == true;*/

		// Property Sheet Content
		assert dsService.isPropertySheetMemberOf("foo",
				"bar") == false;
		assert dsService.isPropertySheetMemberOf(
				TEST_SEMANTIC_ID, "com.include.this.propertySheet") == true;
		assert dsService.isPropertySheetMemberOf(
				TEST_SEMANTIC_ID, "some.other.sheet") == false;
		assert dsService.isPropertySheetMemberOf(null,
				"anything") == true;

		// Palette Entry Content
		assert dsService.isPaletteEntryMemberOf("foo",
				"bar") == false;
		assert dsService.isPaletteEntryMemberOf(
				TEST_SEMANTIC_ID, "MyPaletteEntry1") == true;
		assert dsService.isPaletteEntryMemberOf(
				TEST_SEMANTIC_ID, "FooYesBar") == true;
		assert dsService.isPaletteEntryMemberOf(
				TEST_SEMANTIC_ID, "FooNotBar") == false;
		assert dsService.isPaletteEntryMemberOf(
				TEST_SEMANTIC_ID, "no.way") == false;
		assert dsService.isPaletteEntryMemberOf(null,
				"anything") == true;

		// User Defined Content
		assert dsService.isUserContentMemberOf("not",
				"not", "not") == false;
		assert dsService.isUserContentMemberOf(
				TEST_SEMANTIC_ID, "fooCategory", "fooforever") == true;
		assert dsService.isUserContentMemberOf(
				TEST_SEMANTIC_ID, "fooCategory", "shouldbefalse") == false;
		assert dsService.isUserContentMemberOf(
				TEST_SEMANTIC_ID, "barCategory", "fooforever") == true;
		assert dsService.isUserContentMemberOf(
				TEST_SEMANTIC_ID, "barCategory", "notBarSomething") == false;

		// Content Provider Content
		assert dsService.isContentProviderMemberOf(
				"foo", "forcontent") == false;
		assert dsService.isContentProviderMemberOf(
				TEST_SEMANTIC_ID, "TestContentProvider") == true;
		assert dsService.isContentProviderMemberOf(
				TEST_SEMANTIC_ID, "provYes") == true;
		assert dsService.isContentProviderMemberOf(
				TEST_SEMANTIC_ID, "provNotThisOne") == false;
		assert dsService.isContentProviderMemberOf(
				null, "anything") == true;

		root.setTopology(top);

		res.save(null);

		// Load resource, check contents
		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(
				0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		res.unload();

	}

}
