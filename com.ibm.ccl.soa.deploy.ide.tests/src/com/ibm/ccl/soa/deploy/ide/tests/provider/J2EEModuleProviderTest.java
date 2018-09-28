/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.provider;

import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jst.j2ee.common.CommonFactory;
import org.eclipse.jst.j2ee.common.ResourceRef;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchiveFactory;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchivePackage;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EJBJarFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.WARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.OpenFailureException;
import org.eclipse.jst.j2ee.internal.ejb.project.operations.EjbFacetProjectCreationDataModelProvider;
import org.eclipse.jst.j2ee.internal.web.archive.operations.WebFacetProjectCreationDataModelProvider;
import org.eclipse.jst.j2ee.project.facet.EARFacetProjectCreationDataModelProvider;
import org.eclipse.jst.j2ee.web.componentcore.util.WebArtifactEdit;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.wst.common.componentcore.datamodel.properties.IFacetProjectCreationDataModelProperties;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.internal.emf.resource.EMF2DOMRendererFactory;
import org.eclipse.wst.common.internal.emf.resource.RendererFactory;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.ide.packager.IDEJ2EEDomainPackager;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.internal.validator.J2EEDomainValidator;

/**
 * 
 * @since 1.0
 * 
 */
public class J2EEModuleProviderTest extends TestCase {

	private static String IDE_DOMAIN_ID = "com.ibm.ccl.soa.deploy.ide.domain";
	private static String J2EE_DOMAIN_ID = "com.ibm.ccl.soa.deploy.j2ee.domain";
	protected RendererFactory originalRendererFactory;

	protected void setUp() throws Exception {
		super.setUp();
		J2eeFactory.eINSTANCE.createEJB(); // hack to load J2EE plugin.
		// swap out renderer factories so SSE is not used.
		originalRendererFactory = RendererFactory.getDefaultRendererFactory();
		RendererFactory
				.setDefaultRendererFactory(EMF2DOMRendererFactory.INSTANCE);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		RendererFactory.setDefaultRendererFactory(originalRendererFactory);
	}

	/**
	 * @throws Exception
	 */
	public void testDomainManagerLookup() throws Exception {
		DomainManager domainManager = DomainManager.getInstance();
		DomainDescriptor[] domainDescriptors = domainManager
				.findDomainDescriptorsByTargetNamespace(J2eePackage.eINSTANCE
						.getNsURI(), null);
		Assert.assertNotNull(domainManager);

		for (int i = 0; i < domainDescriptors.length; i++) {
			if (domainDescriptors[i].getId().equals(IDE_DOMAIN_ID)) {
				DomainPackager packager = domainDescriptors[i]
						.createDomainPackager();
				Assert.assertNotNull(packager);
				Assert.assertTrue(packager instanceof IDEJ2EEDomainPackager);
			}
			if (domainDescriptors[i].getId().equals(J2EE_DOMAIN_ID)) {
				DomainValidator validator = domainDescriptors[i]
						.createDomainValidator();
				Assert.assertNotNull(validator);
				Assert.assertTrue(validator instanceof J2EEDomainValidator);
			}
		}
	}

	/**
	 * @throws Exception
	 */
	public void testEjbModuleProvider() throws Exception {
		String projectName = "FooEJB";
		IDataModel dataModel = DataModelFactory
				.createDataModel(new EjbFacetProjectCreationDataModelProvider());
		dataModel.setProperty(
				IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME,
				projectName);
		dataModel.getDefaultOperation()
				.execute(new NullProgressMonitor(), null);
		IProject project = ProjectUtilities.getProject(projectName);

		EjbModule ejbModule = verifyTestEjbModuleProvider(project);

		DomainManager domainManager = DomainManager.getInstance();
		DomainDescriptor[] allJ2EEDomainDescriptor = domainManager
				.findDomainDescriptorsByTargetNamespace(J2eePackage.eINSTANCE
						.getNsURI(), null);
		DomainDescriptor domainDescriptor = null;

		for (int i = 0; i < allJ2EEDomainDescriptor.length; i++) {
			if (allJ2EEDomainDescriptor[i].getId().equals(IDE_DOMAIN_ID)) {
				domainDescriptor = allJ2EEDomainDescriptor[i];
			}
		}
		assert (domainDescriptor != null);

		DomainPackager packager = domainDescriptor.createDomainPackager();

		InputStream in = packager.export(ejbModule);
		IFile file1 = project.getFile("testOuput1.jar");
		file1.create(in, true, new NullProgressMonitor());

		CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
		CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
		EJBJarFile ejbJarFile1 = factory.openEJBJarFile(file1.getRawLocation()
				.toOSString());
		Assert.assertNotNull(ejbJarFile1);

		verifyTestEjbModuleProvider(ejbJarFile1);

		in = packager.export(ejbModule);
		IFile file2 = project.getFile("testOuput2.jar");
		file2.create(in, true, new NullProgressMonitor());

		EJBJarFile ejbJarFile2 = factory.openEJBJarFile(file2.getRawLocation()
				.toOSString());
		Assert.assertNotNull(ejbJarFile2);

		ejbJarFile1.close();
		ejbJarFile2.close();
		file1.delete(true, new NullProgressMonitor());
		file2.delete(true, new NullProgressMonitor());

		Assert.assertFalse(file1.exists());
		Assert.assertFalse(file2.exists());
	}

	/**
	 * @throws Exception
	 */
	public void testWebModuleProvider() throws Exception {
		String projectName = "FooWeb";
		IDataModel dataModel = DataModelFactory
				.createDataModel(new WebFacetProjectCreationDataModelProvider());
		dataModel.setProperty(
				IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME,
				projectName);
		dataModel.getDefaultOperation()
				.execute(new NullProgressMonitor(), null);
		IProject project = ProjectUtilities.getProject(projectName);
		WebArtifactEdit edit = null;
		try {
			edit = WebArtifactEdit.getWebArtifactEditForWrite(project);
			WebApp webApp = edit.getWebApp();
			List resourceRefs = webApp.getResourceRefs();
			ResourceRef ref = CommonFactory.eINSTANCE.createResourceRef();
			ref.setName("foo");
			resourceRefs.add(ref);
		} finally {
			if (edit != null) {
				edit.saveIfNecessary(new NullProgressMonitor());
				edit.dispose();
			}
		}

		WebModule webModule = verifyTestWebModuleProvider(project);

		DomainManager domainManager = DomainManager.getInstance();
		DomainDescriptor[] allJ2EEDomainDescriptor = domainManager
				.findDomainDescriptorsByTargetNamespace(J2eePackage.eINSTANCE
						.getNsURI(), null);
		DomainDescriptor domainDescriptor = null;

		for (int i = 0; i < allJ2EEDomainDescriptor.length; i++) {
			if (allJ2EEDomainDescriptor[i].getId().equals(IDE_DOMAIN_ID)) {
				domainDescriptor = allJ2EEDomainDescriptor[i];
			}
		}
		assert (domainDescriptor != null);

		DomainPackager packager = domainDescriptor.createDomainPackager();

		InputStream in = packager.export(webModule);
		IFile file1 = project.getFile("testOuput1.war");
		file1.create(in, true, new NullProgressMonitor());

		CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
		CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
		WARFile warFile1 = factory.openWARFile(file1.getRawLocation()
				.toOSString());
		Assert.assertNotNull(warFile1);

		verifyTestWebModuleProvider(warFile1);

		in = packager.export(webModule);
		IFile file2 = project.getFile("testOuput2.war");
		file2.create(in, true, new NullProgressMonitor());

		WARFile warFile2 = factory.openWARFile(file2.getRawLocation()
				.toOSString());
		Assert.assertNotNull(warFile2);

		warFile1.close();
		warFile2.close();
		file1.delete(true, new NullProgressMonitor());
		file2.delete(true, new NullProgressMonitor());

		Assert.assertFalse(file1.exists());
		Assert.assertFalse(file2.exists());

	}

	private EjbModule verifyTestEjbModuleProvider(Object obj) throws Exception,
			CoreException, OpenFailureException {
		EjbModule ejbModule = (EjbModule) verifyProviderResolved(obj);
		return ejbModule;
	}

	private WebModule verifyTestWebModuleProvider(Object obj) throws Exception,
			CoreException, OpenFailureException {
		WebModule webModule = (WebModule) verifyProviderResolved(obj);
		List hostingReqs = webModule.getRequirements(
				RequirementLinkTypeFilter.HOSTING_FILTER, null);
		Assert.assertEquals(3, hostingReqs.size());
		Object[] literalsToFind = { J2EEContainerVersion._14_LITERAL,
				ServletContainerVersion._24_LITERAL,
				JSPContainerVersion._20_LITERAL };
		verifyHostingReqs(hostingReqs, literalsToFind);

		List dependencyRequirements = webModule.getRequirements(
				RequirementLinkTypeFilter.DEPENDENCY_FILTER, null);
		Assert.assertEquals(0, dependencyRequirements.size());

		return webModule;
	}

	private void verifyHostingReqs(List hostingReqs, Object[] literalsToFind)
			throws Exception {
		boolean[] literalsFound = new boolean[literalsToFind.length];
		for (int i = 0; i < literalsFound.length; i++) {
			literalsFound[i] = false;
		}
		// TODO make this test work
// for (int i = 0; i < hostingReqs.size(); i++) {
// Object container = hostingReqs.get(i);
// Class clazz = container.getClass();
// Method method = clazz.getMethod("getContainerVersion", null);
// Object containerVersion = method.invoke(container, null);
// boolean found = false;
// for (int j = 0; j < literalsFound.length && !found; j++) {
// if (literalsToFind[j].equals(containerVersion)) {
// if (literalsFound[j]) {
// Assert.fail("J2EEContainer found twice:" + container);
// }
// literalsFound[j] = true;
// found = true;
// }
// }
// }
// for (int i = 0; i < literalsFound.length; i++) {
// Assert.assertTrue("Literal not found:" + literalsToFind, literalsFound[i]);
// }
	}

	/**
	 * @throws Exception
	 */
	public void testEarModuleProvider() throws Exception {
		String projectName = "FooEar";
		IDataModel dataModel = DataModelFactory
				.createDataModel(new EARFacetProjectCreationDataModelProvider());
		dataModel.setProperty(
				IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME,
				projectName);
		dataModel.getDefaultOperation()
				.execute(new NullProgressMonitor(), null);
		IProject project = ProjectUtilities.getProject(projectName);

		EarModule earModule = (EarModule) verifyProviderResolved(project);
		List hostingReqs = earModule.getRequirements(
				RequirementLinkTypeFilter.HOSTING_FILTER, null);
		Assert.assertEquals(1, hostingReqs.size());
		verifyHostingReqs(hostingReqs,
				new Object[] { J2EEContainerVersion._14_LITERAL });

		IDEJ2EEDomainPackager packager = new IDEJ2EEDomainPackager();
		InputStream in = packager.export(earModule);
		IFile file = project.getFile("testOuput.ear");
		file.create(in, true, new NullProgressMonitor());

		CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
		CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
		EARFile earFile = factory.openEARFile(file.getRawLocation()
				.toOSString());
		Assert.assertNotNull(earFile);
		earFile.close();
		file.delete(true, new NullProgressMonitor());

		Assert.assertFalse(file.exists());
	}

	protected Object verifyProviderResolved(Object obj) {
		UnitLifeCycleManager manager = UnitLifeCycleManager.getInstance();
		UnitProviderDescriptor[] descriptors = manager
				.findEnabledTopologyUnitProvidersByInputOnly(obj);
		if (descriptors.length == 0) {
			Assert.fail("No Unit Providers found");
		}
		for (int i = 0; i < descriptors.length; i++) {
			UnitProvider provider = descriptors[i].createUnitProvider();
			TopologyUnitStub[] stubs = provider.resolveStubs(obj);
			for (int j = 0; j < stubs.length; j++) {
				Object[] objs = provider.resolveUnit(stubs[j], false, null);
				for (int k = 0; k < objs.length; k++) {
					String displayName = null;
					if (obj instanceof IProject) {
						displayName = ((IProject) obj).getName();
					} else if (obj instanceof WARFile) {
						displayName = ((WARFile) obj).getDeploymentDescriptor()
								.getDisplayName();
					} else if (obj instanceof EARFile) {
						displayName = ((EARFile) obj).getDeploymentDescriptor()
								.getDisplayName();
					} else if (obj instanceof EJBJarFile) {
						displayName = ((EJBJarFile) obj)
								.getDeploymentDescriptor().getDisplayName();
					}
					if (objs[k] instanceof DeployModelObject) {
						Assert.assertEquals(displayName,
								((DeployModelObject) objs[k]).getName());
					}
					return objs[k];
				}
			}
		}
		Assert
				.fail("Unit Providers failed to resolve DeployModelObject."
						+ obj);
		return null;
	}
}
