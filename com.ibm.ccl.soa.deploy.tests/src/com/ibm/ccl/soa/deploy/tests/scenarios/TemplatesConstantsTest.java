/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.database.IDatabaseTemplateConstants;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.generic.IGenericTemplateConstants; // import
import com.ibm.ccl.soa.deploy.ihs.IIhsTemplateConstants;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.deploy.j2ee.IJ2EETemplateConstants;
import com.ibm.ccl.soa.deploy.j2ee.jms.IJmsTemplateConstants;
																	// com.ibm.ccl.soa.deploy.ihs.*;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.server.IServerTemplateConstants;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * JUnit test case for Template constant files we know about.
 * 
 * <p>
 * 
 * @author Michael Kalantar
 */
public class TemplatesConstantsTest extends TopologyTestCase {

	private static final String ID = "TemplateConstantsTest";

	public static Class[] constantClasses = new Class[] {
			// ICoreTemplateConstants.class,
			IDatabaseTemplateConstants.class,
			IDb2TemplateConstants.class,
			// IDerbyTemplateConstants.class,
			IGenericTemplateConstants.class,
			// IHttpTemplateConstants.class,
			IIhsTemplateConstants.class,
			IJ2EETemplateConstants.class,
			IJmsTemplateConstants.class,
			// IJavaTemplateConstants.class,
			// ILdapTemplateConstants.class,
			IOsTemplateConstants.class, 
			IServerTemplateConstants.class,
			IWasTemplateConstants.class // ,
	// IWasWebPluginTemplateConstants.class
	};

	private boolean verbose = false;

	/** Test case ctor */
	public TemplatesConstantsTest() {
		super(ID);
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology(ID);
	}

	/**
	 * Test all available templates, loading and looking for basic errors
	 * 
	 * @throws Exception
	 */
	public void testTemplateConstants() throws Exception {
		Topology top = createTopology(ID);
		top
				.setDescription("Load templates defined by template constant files.");
		Resource res;
		res = top.getEObject().eResource();

		ResourceSet resSet = new ResourceSetImpl();
		res = resSet.createResource(res.getURI());
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(top);
		res.getContents().add(root);

		int errorCount = 0;
		StringBuffer errLog = new StringBuffer("");
		String templateURIString = null;
		for (int i = 0; i < constantClasses.length; i++) {
			for (Iterator<String> templates = new TemplateUriIterator(
					constantClasses[i]); templates.hasNext();) {
				top.getUnits().clear();
				top.getImports().clear();
				top.getRealizationLinks().clear();
				top.setDecoratorSemantic(null);
				DeployModelObject u = null;
				try {
					templateURIString = templates.next();
					System.out.println("template: " + templateURIString);
					u = ResolutionUtils.addFromTemplate(templateURIString, top);
					if (u == null) {
						ResourceTypeDescriptor descriptor = ResourceTypeService.getInstance().getResourceTypeDescriptor(templateURIString);
						EClass eclass = descriptor.getEclass();
						if (eclass == null) {
							throw new IllegalStateException("ResourceType eClass and TemplateURI should not be null. " + templateURIString);
						}
						if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(eclass)) {
							//ignore
							continue;
						}
						throw new IllegalStateException("ResourceType templateURI should not be null. " + templateURIString);
					}
					int count = 0;
					for (Iterator<Unit> units = u.getEditTopology()
							.findAllUnits(); units.hasNext();) {
						Unit unit = units.next();
						count++;
					}
					System.out.println("   created " + count + " units.");
					if (u == null) {
						errLog.append("No units read from template: "
								+ templateURIString);
						errorCount++;
					}
				} catch (Exception e) {
					if (templateURIString == null) {
						errLog.append("Not able to find templateURIString.\n");
					} else {
						errLog.append("Failed loading template with id = "
								+ templateURIString + "\n" + e.getMessage());
					}
					errorCount++;
				}
			}
		}
		if (errorCount > 0) {
			throw new IllegalArgumentException("Found " + errorCount
					+ " templates with errors.\n\n" + errLog.toString());
		}

	}

	private class TemplateUriIterator implements Iterator<String> {

		private final String[] constants;
		private int index;

		/**
		 * Class that iterates over the
		 * 
		 * @param templateConstantsClass
		 * @throws IllegalAccessException
		 */
		public TemplateUriIterator(Class templateConstantsClass)
				throws IllegalAccessException {
			Field[] fields = templateConstantsClass.getDeclaredFields();
			this.constants = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				try {
					this.constants[i] = (String) fields[i].get(null);
				} catch (IllegalAccessException e) {
					this.constants[i] = null;
				}
			}
			this.index = 0;
		}

		public boolean hasNext() {
			return index < (constants.length - 1);
		}

		public String next() {
			return this.constants[index++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
