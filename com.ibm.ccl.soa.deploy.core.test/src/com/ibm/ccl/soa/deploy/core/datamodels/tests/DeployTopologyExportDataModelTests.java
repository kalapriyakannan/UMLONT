/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.tests;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel }
 * 
 * <p>
 * Clients should use
 * {@link DeployTopologyExportDataModel#createConfiguredOperation()} to create
 * an instance of this operation, configured with the necessary model
 * properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.internal.datamodels.DeployTopologyExportDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel
 */
public class DeployTopologyExportDataModelTests extends TestCase {
	private static final String PROJECT_NAME = "DeployTopologyExportDataModelTests_Project";
	private IProject project;

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		if (project.exists()) {
			project.delete(true, null);
		}
		project.create(null);
		project.open(null);
	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
		project.delete(true, null);
	}

	public void testOperationWithRequiredProperties() throws Exception {
		CreateTopologyDataModel typesafeModel1 = CreateTopologyDataModel
				.createModel();

		typesafeModel1.setTopologyName("Test1");
		// Use project as the container.
		typesafeModel1.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		IDataModelOperation op = typesafeModel1.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel1.getTopologyFile();

		DeployTopologyExportDataModel typesafeModel = DeployTopologyExportDataModel
				.createModel();

		typesafeModel.setArchiveDestination(null);
		typesafeModel.setOverwriteExisting(null);
		typesafeModel.setExportSourceFiles(null);
		typesafeModel.setExportWithError(null);
		typesafeModel.setTopologyHasError(null);
		typesafeModel.setTopologyFile(topologyFile);
		typesafeModel.setExporter(null);
		typesafeModel.setExportLogger(null);
		/*
		 * typesafeModel.getDefaultScribblerDefinition().setProjectName(PROJECT_NAME);
		 * IDataModelOperation op1 = typesafeModel.createConfiguredOperation();
		 * 
		 * IProgressMonitor monitor1 = createProgressMonitor(); IStatus status1 =
		 * op.execute(monitor, null);
		 * 
		 * assertTrue("The operation did not complete successfully.",
		 * status1.isOK()); // $NON-NLS-1$
		 */
		// TODO Verify the proper execution of the operation.
	}

	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}
}
