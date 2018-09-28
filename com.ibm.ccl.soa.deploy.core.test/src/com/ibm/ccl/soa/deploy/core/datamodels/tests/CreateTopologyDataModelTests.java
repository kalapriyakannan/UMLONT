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

import junit.framework.TestCase;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.infrastructure.internal.emf.ResourceUtilities;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel }
 * 
 * <p>
 * Clients should use
 * {@link CreateTopologyDataModel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel
 */
public class CreateTopologyDataModelTests extends TestCase {

	private static final String PROJECT_NAME = "CreateTopologyDataModelTests_Project";

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

		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();

		typesafeModel.setTopologyName("Test1");
		// Use project as the container.
		typesafeModel.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(project.getFolder( "topologies" ), topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("Test1", topology.getDisplayName());
		assertNotNull(topology.getDescription());
		assertNull(topology.getDecoratorSemantic());
	}

	public void testOperationWithTopologyDescriptionProperty() throws Exception {

		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();

		typesafeModel.setTopologyName("Test2");
		// Use project as the container.
		typesafeModel.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		typesafeModel.setTopologyDescription("This is a test.");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(project.getFolder( "topologies" ), topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test2", topology.getName());
		assertEquals("Test2", topology.getDisplayName());
		assertEquals("This is a test.", topology.getDescription());
		// TODO test that the decoratorSemantic is null.

	}

	public void testOperationWithDecoratorSemanticProperty() throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		IDecoratorSemanticService dsService = ExtensionsCore
		.createDecoratorSemanticService();
		String[] semanticNames = dsService
				.getAllDecoratorSemanticNames();
		typesafeModel.setDecoratorSemantic(semanticNames[0]);
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertNotNull(topology.getDecoratorSemantic());
		assertEquals(dsService
				.getDecoratorSemanticId(semanticNames[0]), topology
				.getDecoratorSemantic());
	}

	public void testOperationWithInvalidDecoratorSemanticProperty()
			throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setDecoratorSemantic("fooBar");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertFalse("The operation should have failed.", status.isOK()); // $NON-NLS-1$
	}

	public void testOperationWithNamespacePathProperty() throws Exception {

// CreateTopologyDataModel typesafeModel =
// CreateTopologyDataModel.createModel();
//				
// typesafeModel.setTopologyName(null);
// typesafeModel.setDecoratorSemanticDescription(null);
// typesafeModel.setSourcePath(null);
// typesafeModel.setTopologyFile(null);
// typesafeModel.setNamespacePath(null);
//		
// IDataModelOperation op = typesafeModel.createConfiguredOperation();
//		
// IProgressMonitor monitor = createProgressMonitor();
// IStatus status = op.execute(monitor, null);
//		
// assertTrue("The operation did not complete successfully.", status.isOK()); //
// $NON-NLS-1$
//		
// // TODO Verify the proper execution of the operation.
//		
	}

	/**
	 * Test that creation with a sourcePath that exists passes.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_WithExistingSourcePath() throws Exception {
		// Set a source folder.
		IFolder sourceFolder = createFolder("topologies");
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(sourceFolder, topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("Test1", topology.getDisplayName());
		assertNotNull(topology.getDescription());
		assertTrue("The namespace should be empty.", topology.getNamespace().length() == 0);

		// Test that the source folder was marked as a root.
		INamespaceElement rootFrag = NamespaceCore.create(sourceFolder);
		assertNotNull("The namespace fragment root should have been created.",
				rootFrag);
		assertTrue("The namespace fragment root should exist.", rootFrag
				.exists());
		assertTrue(rootFrag.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT);
		assertEquals(sourceFolder, ((INamespaceFragmentRoot) rootFrag)
				.getCorrespondingResource());
	}

	/**
	 * Same as test2 except that the source folder does not exist prior to the
	 * execution of the operation.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_WithoutExsistingSourceFolder()
			throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies2")
				.toString());
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		// Test that the source folder was marked as a root and created.
		IFolder sourceFolder = project.getFolder("topologies2");
		INamespaceElement rootFrag = NamespaceCore.create(sourceFolder);
		assertNotNull("The namespace fragment root should have been created.",
				rootFrag);
		assertTrue("The namespace fragment root should exist.", rootFrag
				.exists());
		assertTrue(rootFrag.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT);
		assertEquals(sourceFolder, ((INamespaceFragmentRoot) rootFrag)
				.getCorrespondingResource());

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("Test1", topology.getDisplayName());
		assertNotNull(topology.getDescription());
		assertTrue("The namespace should be empty.", topology.getNamespace().length() == 0);
	}

	/**
	 * Test that validation failure thrown properly when the source path is not
	 * set. This will ensure that the validation for the name will complete
	 * without failing since the source folder is not set.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_ValidateFailureForMissingSourcePath()
			throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test3");

		IStatus status = typesafeModel.validate();

		assertFalse("The datamodel should not validate successfully.", status
				.isOK()); // $NON-NLS-1$
	}

	/**
	 * Test that a namespace path is created when it doesn't exist.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_NamespacePathCreation() throws Exception {
		// Set a source folder.
		IFolder sourceFolder = createFolder("topologies");
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setNamespacePath("com.ibm.foo");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		IFolder namespaceFolder = sourceFolder
				.getFolder(new Path("com/ibm/foo"));
		assertEquals(namespaceFolder, topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("Test1", topology.getDisplayName());
		assertNotNull(topology.getDescription());
		assertEquals("com.ibm.foo", topology.getNamespace());

		// Test namespace.
		INamespaceElement namespace = NamespaceCore.create(namespaceFolder);
		assertNotNull(namespace);
		assertTrue(namespace.exists());
		assertTrue(namespace.getType() == INamespaceElement.TOPOLOGY_NAMESPACE);
		assertEquals("com.ibm.foo", ((INamespaceFragment) namespace)
				.getQualifiedName());
		assertTrue(((INamespaceFragment) namespace).containsTopologies());

		INamespaceFragmentRoot rootFrag = (INamespaceFragmentRoot) NamespaceCore
				.create(sourceFolder);
		assertNotNull("The namespace fragment root should have been created.",
				rootFrag);
		assertEquals(sourceFolder, rootFrag.getCorrespondingResource());
	}

	/**
	 * Test creation with an existing namespace path.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_WithExistingNamespacePath()
			throws Exception {
		// Set a source folder.
		IFolder namespaceFolder = createFolder(new Path(
				"topologies/com/ibm/bar"));
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setNamespacePath("com.ibm.bar");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(namespaceFolder, topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("Test1", topology.getDisplayName());
		assertNotNull(topology.getDescription());
		assertEquals("com.ibm.bar", topology.getNamespace());
		// TODO test that the decoratorSemantic is null.

	}

	/**
	 * Test pass of two topologies in a single namespace.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_TwoTopologiesSingleNamespace()
			throws Exception {
		// Set a source folder.
		IFolder namespaceFolder = createFolder(new Path(
				"topologies/com/ibm/bar"));
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setNamespacePath("com.ibm.bar");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(namespaceFolder, topologyFile.getParent());

		// Try to create another topology in same namespace.
		typesafeModel = CreateTopologyDataModel.createModel();
		typesafeModel.setTopologyName("Test2");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setNamespacePath("com.ibm.bar");
		op = typesafeModel.createConfiguredOperation();
		monitor = createProgressMonitor();
		IStatus status2 = op.execute(monitor, null);

		assertTrue("The operation should have completed successfully.", status2
				.isOK()); // $NON-NLS-1$
		topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		assertEquals(namespaceFolder, topologyFile.getParent());
	}

	/**
	 * Test pass of two topologies in a with namespaces that overlap but with
	 * different cases.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_TwoTopologiesWithOverlappingNamespaceCase()
			throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		typesafeModel.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		typesafeModel.setNamespacePath("FVT.TC");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		// Try to create another topology in same namespace.
		typesafeModel = CreateTopologyDataModel.createModel();
		typesafeModel.setTopologyName("Test2");
		typesafeModel.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		typesafeModel.setNamespacePath("fvt.tc.deploy");
		op = typesafeModel.createConfiguredOperation();
		monitor = createProgressMonitor();
		IStatus status2 = op.execute(monitor, null);
		if (isLinux()) {
			assertTrue("The operation did not complete successfully.", status2
					.isOK()); // $NON-NLS-1$
		} else {
			assertFalse("The operation should not have completed successfully.",
					status2.isOK()); // $NON-NLS-1$
		}
	}

	private boolean isLinux() {
		return Platform.OS_LINUX.equals(Platform.getOS());
	}

	/**
	 * With an invalid Project in the sourcePath fails.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_ValidateFailureOfInvalidProject()
			throws Exception {
		// Set a source folder.
		IFolder sourceFolder = createFolder("topologies");
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath("Test3");

		IStatus status = typesafeModel.validate();

		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$
	}

	/**
	 * Test with a valid Project in the sourcePath but a non-existing source
	 * folder. Ensure the source folder is created.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_ValidProjectNoSourceFolder()
			throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Set a non-existing source folder within the Test1 project.
		typesafeModel.setSourcePath(project.getFullPath().append("topologies")
				.toString());
		typesafeModel.setNamespacePath("com.ibm.bar");
		IStatus dataModelStatus = typesafeModel.validate();
		assertTrue("There should be a warning in the datamodel.",
				dataModelStatus.getSeverity() == IStatus.WARNING);
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		// We should have a warning for the missing source folder which will be
		// created.
		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());
		IFolder namespaceFolder = project.getFolder(new Path(
				"topologies/com/ibm/bar"));
		assertEquals(namespaceFolder, topologyFile.getParent());

		Resource resource = ResourceUtilities.getResource(topologyFile,
				true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		assertNotNull(topology);
		assertEquals("Test1", topology.getName());
		assertEquals("com.ibm.bar", topology.getNamespace());
	}

	/**
	 * Test that creation fails when using a source folder under a project that
	 * is already defined as a namepsace.
	 */
	public void test_TopologyCreation_ValidateFailureWithNamespaceInAnotherSourceFolder()
			throws Exception {
		// Set a source folder.
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getName() + System.getProperty( "file.separator" ) + "topologies");
		typesafeModel.setNamespacePath("com.acme.test");
		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		IFile topologyFile = typesafeModel.getTopologyFile();
		assertTrue("The topology file should exist.", topologyFile.exists());

		// Test that the source folder was marked as a root.
		INamespaceElement rootFrag = NamespaceCore.create(project.getFolder( "topologies" ) );
		assertTrue("The namespace fragment root should exist.", rootFrag
				.exists());
		assertTrue(rootFrag.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT);

		// Create second topology under source folder for project.
		CreateTopologyDataModel typesafeModel2 = CreateTopologyDataModel
				.createModel();
		typesafeModel2.setTopologyName("Test2");
		// Use source folder as the container.
		typesafeModel2.setSourcePath(project.getFolder( "topologies" ).getFullPath().append("com")
				.toString());
		typesafeModel2.setNamespacePath("test.me");
		IDataModelOperation op2 = typesafeModel2.createConfiguredOperation();
		IProgressMonitor monitor2 = createProgressMonitor();
		IStatus status2 = op2.execute(monitor2, null);

		assertFalse("This should fail.", status2.isOK());
	}
	
	/**
	 * LI: 896 was open due to an NPE in the Topology wizard.  The problem
	 * was due to the fact that the source folder was null and the validation
	 * for the namespace was throwing the NPE.  This test is for this failure.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_NoSourceFolder() throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		//The failure only happens when the namespace path is set and the source
		//folder is not.
		typesafeModel.setNamespacePath("some.namespace");
		IStatus status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$
	}

	/**
	 * Test invalid namespace characters.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_InvalidNamespaceChars() throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");

		IStatus status = null;
		
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getName());
		status = typesafeModel.validate();
		assertTrue("The datamodel should have failed validation.", status.getSeverity() == IStatus.ERROR
				); // $NON-NLS-1$
		
		typesafeModel.setSourcePath(project.getName() + "/topologies");

		// Test invalid chars.
		typesafeModel.setNamespacePath("com.$&(){}[].//test");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test repeating periods.
		typesafeModel.setNamespacePath("com...test");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test slashes for separator char.
		typesafeModel.setNamespacePath("com/test/foo");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test dot at the beginning
		typesafeModel.setNamespacePath(".com.test.foo");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test dot at the end
		typesafeModel.setNamespacePath("com.test.foo.");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test spaces in the namespace.
		typesafeModel.setNamespacePath("com.test foo.bar");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test Uppercase.
		typesafeModel.setNamespacePath("Com.test.foo");
		status = typesafeModel.validate();
		assertTrue("The datamodel should have a warning.",
				status.getSeverity() == IStatus.WARNING); // $NON-NLS-1$

		// Test non-existing warning
		typesafeModel.setNamespacePath("com.test.foo");
		status = typesafeModel.validate();
		assertTrue("The datamodel should have a warning.",
				status.getSeverity() == IStatus.WARNING); // $NON-NLS-1$
	}

	/**
	 * Test invalid name characters.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_InvalidNameChars() throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getName());
		IStatus status = null;

		// Test invalid chars.
		typesafeModel.setTopologyName("Test1$&(){}[].//t");
		// typesafeModel.setNamespacePath("com.$&(){}[].//test");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test periods.
		typesafeModel.setTopologyName("Test1.t");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test slashes for separator char.
		typesafeModel.setTopologyName("Test1/t");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test dot at the beginning
		typesafeModel.setTopologyName(".Test1");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test dot at the end
		typesafeModel.setTopologyName("Test1.");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$
	}

	/**
	 * Test invalid source folder characters.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_InvalidSourceFolderChars()
			throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		IStatus status = null;

		// Test invalid chars.
		typesafeModel.setSourcePath("Foo.x");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test periods.
		typesafeModel.setSourcePath(project.getName() + "/foo.x");
		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$

		// Test slashes
		typesafeModel.setSourcePath(project.getName() + "/foo/ee");
		status = typesafeModel.validate();
		//Slashes are valid on Linux.
		if (isLinux()) {
			assertTrue("The datamodel failed validation.", status.isOK()); // $NON-NLS-1$
		} else {
			assertFalse("The datamodel should have failed validation.", status
					.isOK()); // $NON-NLS-1$
		}

		// Test invalid char
		typesafeModel.setSourcePath(project.getName() + "/foo*");
		status = typesafeModel.validate();
		assertEquals("The datamodel should have failed validation.",
				IStatus.ERROR, status.getSeverity()); // $NON-NLS-1$

		// Test invalid char
		typesafeModel.setSourcePath(project.getName() + "/foo<");
		status = typesafeModel.validate();
		assertEquals("The datamodel should have failed validation.",
				IStatus.ERROR, status.getSeverity()); // $NON-NLS-1$
	}

	/**
	 * Test missing name.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_MissingName() throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		// Use source folder as the container.
		typesafeModel.setSourcePath(project.getName());
		IStatus status = null;

		status = typesafeModel.validate();
		assertFalse("The datamodel should have failed validation.", status
				.isOK()); // $NON-NLS-1$
	}

	/**
	 * Test duplicate topology qualified names in different source folders.
	 * 
	 * @throws Exception
	 */
	public void test_TopologyCreation_DuplicateQualifiedNamesDiffFolders()
			throws Exception {
		CreateTopologyDataModel typesafeModel = CreateTopologyDataModel
				.createModel();
		typesafeModel.setTopologyName("Test1");
		typesafeModel.setSourcePath(project.getFullPath().append("root1")
				.toString());
		typesafeModel.setNamespacePath("com.acme.test");

		IDataModelOperation op = typesafeModel.createConfiguredOperation();
		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue(status.isOK());

		typesafeModel = CreateTopologyDataModel.createModel();
		typesafeModel.setTopologyName("Test1");
		// Create a second root.
		typesafeModel.setSourcePath(project.getFullPath().append("root2")
				.toString());
		typesafeModel.setNamespacePath("com.acme.test");

		assertTrue("This should have failed.", typesafeModel.validate()
				.getSeverity() == IStatus.ERROR);
	}

	private IFolder createFolder(IPath path) throws CoreException {
		String[] segments = path.segments();
		IFolder folder = null;
		for (int i = 0; i < segments.length; i++) {
			folder = createFolder(folder == null ? (IContainer) project
					: folder, segments[i]);
		}
		return folder;
	}

	private IFolder createFolder(String folderName) throws CoreException {
		return createFolder(project, folderName);
	}

	private IFolder createFolder(IContainer container, String folderName)
			throws CoreException {
		IFolder folder = null;
		switch (container.getType()) {
		case IResource.PROJECT:
			folder = container.getFolder(new Path(folderName));
			break;
		case IResource.FOLDER:
			folder = ((IFolder) container).getFolder(folderName);
			break;
		}
		folder.create(true, true, null);
		return folder;
	}

//	
// public void testOperationWithDecoratorSemanticProperty() throws Exception {
//	
// CreateTopologyDataModel typesafeModel =
// CreateTopologyDataModel.createModel();
//				
// typesafeModel.setTopologyName(null);
// typesafeModel.setDecoratorSemantic(null);
//		
// IDataModelOperation op = typesafeModel.createConfiguredOperation();
//		
// IProgressMonitor monitor = createProgressMonitor();
// IStatus status = op.execute(monitor, null);
//		
// assertTrue("The operation did not complete successfully.", status.isOK()); //
// $NON-NLS-1$
//		
// // TODO Verify the proper execution of the operation.
//		
// }
// 	
	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}
}
