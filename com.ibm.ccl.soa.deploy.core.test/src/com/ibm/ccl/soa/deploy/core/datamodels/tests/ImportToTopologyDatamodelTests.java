/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel;
import com.ibm.ccl.soa.deploy.core.test.ModelChange;
import com.ibm.ccl.soa.deploy.core.test.SimpleChangeScope;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.core.test.TestWorkspace;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestPlugin;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel }
 * 
 * <p>
 * Clients should use
 * {@link ImportToTopologyDatamodel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.internal.datamodels.ImportToTopologyDatamodelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel
 */
public class ImportToTopologyDatamodelTests extends TestCase {

	private static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace()
			.getRoot();

	private static final String DEPLOYMENTS = "Deployments";
	private static final String TPCWAPPLICATION = "TPCWApplication";
	private static final String TPCWEJB1 = "TPCWEJB1";
	private static final String TPCWEJB2 = "TPCWEJB2";
	private static final String TPCWWEB = "TPCWWEB";

	private static final IPath TEST_DATA = new Path("testdata/ImportTests.zip");
	private static final String[] PROJECT_NAMES = new String[] { DEPLOYMENTS,
			TPCWAPPLICATION, TPCWEJB1, TPCWEJB2, TPCWWEB };

	private static final IProject[] PROJECTS = new IProject[] { ROOT
			.getProject(TPCWAPPLICATION) };

	private static final String TOPOLOGY1 = "Topology1";

	private static final String TOPOLOGY2 = "Topology2";

	private TestWorkspace workspace = new TestWorkspace(TopologyTestPlugin
			.getDefault().getBundle(), TEST_DATA, PROJECT_NAMES);
	private TestSetup<TestWorkspace> modelSetup;
	private SimpleChangeScope primaryScope;

	private SimpleChangeScope secondaryScope;

	public ImportToTopologyDatamodelTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		//suite.addTest(new ImportToTopologyDatamodelTests("testImportTopologyOperationWithTopologyIntoItself"));
		suite.addTestSuite(ImportToTopologyDatamodelTests.class);
		return suite;
	}

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() throws Exception {

//		workspace.init();
		modelSetup = new TestSetup(DEPLOYMENTS, "com.acme", workspace);
		primaryScope = modelSetup.createTopologyScope(TOPOLOGY1,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Create Topology") {

					@Override
					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {
						Topology topology = scope.openTopology();

						topology.setDisplayName(TOPOLOGY1);

						ContractProvider provider = ContractProviderManager.INSTANCE
								.createProvider(IdentityContractProvider.ID);
						provider.installContract(topology);

						return Status.OK_STATUS;
					}

				});

		secondaryScope = modelSetup.createTopologyScope(TOPOLOGY2,
				ChangeScope.OPTION_FORCE_SAVE, new ModelChange(
						"Create Topology") {

					@Override
					public IStatus execute(IProgressMonitor monitor,
							ChangeScope scope) throws ExecutionException {
						Topology topology = scope.openTopology();

						topology.setDisplayName(TOPOLOGY2);

						ContractProvider provider = ContractProviderManager.INSTANCE
								.createProvider(IdentityContractProvider.ID);
						provider.installContract(topology);

						return Status.OK_STATUS;
					}

				});

	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
		primaryScope.close(new NullProgressMonitor());
		secondaryScope.close(new NullProgressMonitor());
		try {
			modelSetup.dispose();
		} catch(CoreException ce) {
			
		} 
	}

	public void testOperationWithRequiredProperties() throws Exception {
  
    ImportToTopologyDatamodel typesafeModel = ImportToTopologyDatamodel.createModel();		
    typesafeModel.setTopologyFile(null); 		
    typesafeModel.setResources(null); 
    IDataModelOperation op = typesafeModel.createConfiguredOperation();
    
    IProgressMonitor monitor = createProgressMonitor();
    try {
    	IStatus status = op.execute(monitor, null);
    	Assert.fail();
    } catch (Exception e) {
		
	}
    
    // TODO Verify the proper execution of the operation.

  }

  public void testImportTopologyOperationWithEARProject() throws Exception {

		ImportToTopologyDatamodel typesafeModel = ImportToTopologyDatamodel
				.createModel();

		typesafeModel.setTopologyFile(primaryScope.getTopologyFile());
		typesafeModel.setResources(PROJECTS);
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		Topology topology = primaryScope.openTopology();

		// 5 units, one for the EAR, one for the Web Module, two for the
		// EJB Modules, and one for the Utility.jar
		assertEquals(5, topology.getUnits().size());

		// TODO Verify the proper execution of the operation.

	}

	public void testImportTopologyOperationWithDifferentTopology()
			throws Exception {

		ImportToTopologyDatamodel typesafeModel = ImportToTopologyDatamodel
				.createModel();

		typesafeModel.setTopologyFile(primaryScope.getTopologyFile());
		typesafeModel.setResources(new IResource[] { secondaryScope
				.getTopologyFile() });
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		Topology topology = primaryScope.openTopology();

		// 5 units, one for the EAR, one for the Web Module, two for the
		// EJB Modules, and one for the Utility.jar
		assertEquals(1, topology.getImports().size());

		// TODO Verify the proper execution of the operation.

	}

	public void testImportTopologyOperationWithTopologyIntoItself()
			throws Exception {

		ImportToTopologyDatamodel typesafeModel = ImportToTopologyDatamodel
				.createModel();

		typesafeModel.setTopologyFile(primaryScope.getTopologyFile());
		typesafeModel.setResources(new IResource[] { primaryScope
				.getTopologyFile() });
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertFalse("The operation should not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		// TODO Verify the proper execution of the operation.

	}

	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}
}
