package com.ibm.ccl.soa.deploy.core.test.imports;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Collections;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestPlugin;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyConfiguration;

public class WhataLoadaTests extends TestCase {

	public static final CoreFactory FACTORY = CoreFactory.eINSTANCE;

	public static final String NAMESPACE_FRAGMENT = "";

	public static final String IMPORTED = "Application";
	public static final String EDITED = "Infrastructure";

	public static final String EAR_MODULE_UNIT = "EarModule0";
	public static final String WEB_MODULE_UNIT = "WebModule0";
	public static final String JAR_MODULE_UNIT = "JarModule0";
	public static final String EJB1_MODULE_UNIT = "EjbModule0";
	public static final String EJB2_MODULE_UNIT = "EjbModule1";

	public static final String WAS_SERVER_UNIT = "WebsphereAppServerUnit0";
	public static final String WAS_NODE_UNIT = "WasNodeUnit0";

	public static final String DATABASE_COMPONENT_UNIT = "DatabaseComponent0";
	public static final String CONCEPTUAL_NODE_UNIT = "ConceptualNode0";
	public static final String DB2_UNIT = "DB2DatabaseUnit0";

	protected final String projectName;
	protected SimpleChangeScope importedTopologyScope;
	protected SimpleChangeScope referencingTopologyScope;
	protected TestSetup testSetup;

	public WhataLoadaTests() {
		projectName = getClass().getSimpleName();
	}

	public WhataLoadaTests(String name) {
		super(name);
		projectName = name;
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		// suite.addTest(new
		// ExplicitContractTests("testPrivatePrivateAttributeNesting"));
		suite.addTestSuite(WhataLoadaTests.class);
		return suite;
	}

	protected void setUp() throws Exception {
		super.setUp();

		testSetup = new TestSetup(projectName, NAMESPACE_FRAGMENT);
		setupImportedTopology();

		setupReferencingTopology();

		// Must be setup by this method.
		assertNotNull(importedTopologyScope);
		assertNotNull(referencingTopologyScope);
	}

	private void setupImportedTopology() throws ExecutionException {
		importedTopologyScope = testSetup.createTopologyScope(IMPORTED,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Configure Imported Topology") {

					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();

						URL url = FileLocator.find(TopologyTestPlugin
								.getDefault().getBundle(), new Path(
								"testdata/Application.template"),
								Collections.EMPTY_MAP);
						String templateURIString = url.toString();

						ResolutionUtils.doDefaultElementCreation(
								templateURIString, topology);

						return Status.OK_STATUS;
					}
				});
	}

	protected void setupReferencingTopology() throws ExecutionException {
		referencingTopologyScope = testSetup.createTopologyScope(EDITED,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Configure Edited Topology") {

					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {

						Topology topology = scope.openTopology();

						// No setup at this time.

						return Status.OK_STATUS;
					}
				});
	}

	@Override
	protected void tearDown() throws Exception {
		importedTopologyScope.close(new NullProgressMonitor());
		referencingTopologyScope.close(new NullProgressMonitor());
		testSetup.dispose();
	}

	private void setupImport() throws ExecutionException {
		IStatus status;
		status = referencingTopologyScope.execute(new ModelChange(
				"Configure Imported Topology") {

			public IStatus execute(IProgressMonitor monitor, ChangeScope scope)
					throws ExecutionException {

				Topology topology = scope.openTopology();

				// setup import
				Import imported = FACTORY.createImport();
				imported.setNamespace(NAMESPACE_FRAGMENT);
				imported.setPattern(IMPORTED);
				InstanceConfiguration configuration = FACTORY
						.createInstanceConfiguration();
				imported.setInstanceConfiguration(configuration);

				topology.getImports().add(imported);

				return Status.OK_STATUS;
			}
		}, new NullProgressMonitor());

		referencingTopologyScope.saveChanges(true, null);

		assertTrue(status.isOK());

	}

	public void testReload() throws Exception {

		setupImport();

		Topology editTopology = referencingTopologyScope.openTopology();
		DeployModelObject earProxy0 = editTopology
				.resolve(computeImportedPath(EAR_MODULE_UNIT));

		DeployModelObject earProxy1 = editTopology
				.resolve(computeImportedPath(EAR_MODULE_UNIT));
		assertTrue(earProxy0 == earProxy1);

		importedTopologyScope.execute(new ModelChange(projectName) {

			@Override
			public IStatus execute(IProgressMonitor monitor, ChangeScope scope)
					throws ExecutionException {
				Topology topology = scope.openTopology();

				Unit unit = FACTORY.createUnit();
				topology.getUnits().add(unit);
				UnitUtil.assignUniqueName(unit);
				return Status.OK_STATUS;
			}

		}, null);
		
		importedTopologyScope.saveChanges(true, null); 

		earProxy1 = editTopology.resolve(computeImportedPath(EAR_MODULE_UNIT));
		
		assertTrue(earProxy0 == earProxy1);
		
		// call once before equals
		assertEquals(earProxy0.hashCode(), earProxy1.hashCode());
		
		assertTrue(earProxy0.equals(earProxy1));
		
		// call once after equals
		assertEquals(earProxy0.hashCode(), earProxy1.hashCode());	
		
		final IProxyConfiguration ear0 = (IProxyConfiguration) Proxy.getInvocationHandler(earProxy0);
		final IProxyConfiguration ear1 = (IProxyConfiguration) Proxy.getInvocationHandler(earProxy1);
			 		
		assertTrue(ProxyConfiguration.getSource(ear0) == ProxyConfiguration.getSource(ear1));

		assertEquals(ProxyConfiguration.getSource(ear0), ProxyConfiguration.getSource(ear1));  
		
		assertEquals(earProxy0.hashCode(), earProxy1.hashCode());

	}

	private String computeImportedPath(String dmoname) {
		return NAMESPACE_FRAGMENT + IConstants.DOT_SEPARATOR + IMPORTED
				+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
				+ dmoname;
	}

}
