package com.ibm.ccl.soa.deploy.ide.tests.refactoring;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor;

public class MoveUnitsRefactoringTests extends TestCase {

	private static final String REFACTORING_TESTS_PROJECT = MoveUnitsRefactoringTests.class.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = MoveUnitsRefactoringTests.class.getPackage().getName();
	
	private TestSetup<RefactoringTestsWorkspace> testSetup;
	
	public MoveUnitsRefactoringTests(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() 
		throws Exception {
		testSetup = new TestSetup<RefactoringTestsWorkspace>(
			REFACTORING_TESTS_PROJECT, NAMESPACE_FRAGMENT,
			new RefactoringTestsWorkspace( REFACTORING_TESTS_PROJECT ) );
	}
	
	@Override
	protected void tearDown() 
		throws Exception {
		testSetup.dispose();
	}
		
	public void testMoveSingleUnit() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		model.setUnits(new Unit[]{(Unit)topologyC.resolve("/TopologyC_Unit3")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyC_Unit3' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit3"));
		assertNull("The unit 'TopologyC_Unit3' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit3"));
	}
	
	public void testMoveMultipleUnits() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		model.setUnits(new Unit[]{(Unit)topologyC.resolve("/TopologyC_Unit3"), (Unit)topologyC.resolve("/TopologyC_Unit4")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyC_Unit3' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit3"));
		assertNull("The unit 'TopologyC_Unit3' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit3"));
		
		assertNotNull("The unit 'TopologyC_Unit4' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit4"));
		assertNull("The unit 'TopologyC_Unit4' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit4"));
	}
	
	public void testMoveSourceAndTargetOfLinkedUnits() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		model.setUnits(new Unit[]{(Unit)topologyC.resolve("/TopologyC_Unit1"), (Unit)topologyC.resolve("/TopologyC_Unit2")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyC_Unit1' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit1"));
		assertNull("The unit 'TopologyC_Unit1' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit1"));
		
		assertNotNull("The unit 'TopologyC_Unit2' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit2"));
		assertNull("The unit 'TopologyC_Unit2' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit2"));
		
		assertNotNull("The link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' was not moved to the " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic"));
		assertNull("The link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' was not removed from the " + topologyC.getQualifiedName() + " topology.",
				topologyC.resolve("/TopologyC_Unit1/r0/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic"));
		
		DependencyLink link = ( DependencyLink ) topologyA.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic");
		assertEquals( "The source of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' post the move does not equal the source of the link prior to the move.", 
				topologyA.resolve("/TopologyC_Unit1/r0"), link.getSource());
		assertEquals( "The target of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' post the move does not equal the target of the link prior to the move.",
				topologyA.resolve("/TopologyC_Unit2/Generic"), link.getTarget());
	}
	
	public void testMoveSourceOfLinkedUnits() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		model.setUnits(new Unit[]{(Unit)topologyC.resolve("/TopologyC_Unit1")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyC_Unit1' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit1"));
		assertNull("The unit 'TopologyC_Unit1' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit1"));
		
		assertNotNull("The unit 'TopologyC_Unit2' was removed from the " + topologyC.getQualifiedName() + " topology.",
				topologyC.resolve("/TopologyC_Unit2"));
		
		assertNotNull("The link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' was removed from the " + topologyC.getQualifiedName() + " topology.",
				topologyC.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic"));
		
		assertNotNull("An import for the " + topologyA.getQualifiedName() + " topology was not created in the source topology of the move refactoring.",
				topologyC.getImport(topologyA.getNamespace(), topologyA.getName()));
		
		assertEquals("The source of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' is not imported from the destination topology of the move refactoring.",
				topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + "/TopologyC_Unit1/r0", ( (DeployLink) topologyC.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic")).getSourceURI() );
		
		assertEquals("The target of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' should not be imported.", 
				topologyC.resolve("/TopologyC_Unit2/Generic"), ((DependencyLink) topologyC.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic")).getTarget());
	}
	
	public void testMoveTargetOfLinkedUnits() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		model.setPreserveLinks(IMoveUnitsModelProperties.PRESERVE_LINKS_IN_DESTINATION);
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		model.setUnits(new Unit[]{(Unit)topologyC.resolve("/TopologyC_Unit2")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyC_Unit2' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyC_Unit2"));
		assertNull("The unit 'TopologyC_Unit2' was not removed from the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyC_Unit2"));
		
		assertNotNull("The unit 'TopologyC_Unit1' was removed from the " + topologyC.getQualifiedName() + " topology.",
				topologyC.resolve("/TopologyC_Unit1"));
		
		assertNotNull("The link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' was not moved to " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic"));
		
		assertNotNull("An import for the " + topologyC.getQualifiedName() + " topology was not created in the destination topology of the move refactoring.",
				topologyA.getImport(topologyC.getNamespace(), topologyC.getName()));
		
		assertEquals("The source of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' is not imported from the source topology of the move refactoring.",
				topologyC.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + "/TopologyC_Unit1/r0", ( (DeployLink) topologyA.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic")).getSourceURI() );
		
		assertEquals("The target of the link 'TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic' should not be imported.", 
				topologyA.resolve("/TopologyC_Unit2/Generic"), ((DependencyLink) topologyA.resolve("/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic")).getTarget());
	}
	
	public void testMoveTargetOfLinkToTopologyOfImportedSourceOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		model.setUnits(new Unit[]{(Unit)topologyB.resolve("/TopologyB_Unit2")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyB_Unit2' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyB_Unit2"));
		assertNull("The unit 'TopologyB_Unit2' was not removed from the " + topologyB.getQualifiedName() + " topology.", 
				topologyB.resolve("/TopologyB_Unit2"));
		
		assertNotNull("The unit 'TopologyA_Unit3' was removed from the " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyA_Unit3"));
		
		assertNotNull("The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' was not moved to " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertFalse("The source of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is imported.",
				( (DeployLink) topologyA.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getSourceURI().startsWith((topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR)) );
		
		assertEquals("The target of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is imported.", 
				topologyA.resolve("/TopologyB_Unit2"), ((HostingLink) topologyA.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getTarget());
	}
	
	public void testMoveSourceOfLinkToTopologyOfImportedTargetOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		model.setUnits(new Unit[]{(Unit)topologyB.resolve("/TopologyB_Unit1")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		
		assertNotNull("The unit 'TopologyB_Unit1' was not moved to the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyB_Unit1"));
		assertNull("The unit 'TopologyB_Unit1' was not removed from the " + topologyB.getQualifiedName() + " topology.", 
				topologyB.resolve("/TopologyB_Unit1"));
		
		assertNotNull("The unit 'TopologyA_Unit1' was removed from the " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyA_Unit1"));
		
		assertNotNull("The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' was not moved to " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertFalse("The source of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is imported.",
				( (DeployLink) topologyA.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getSourceURI().startsWith((topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR )) );
		
		assertEquals("The target of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is imported.", 
				topologyA.resolve("/TopologyA_Unit1"), ((HostingLink) topologyA.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getTarget());
	}
	
	public void testMoveTargetOfLinkToTopologyOfImportedTargetOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyB().getFullPath().toString());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		model.setUnits(new Unit[]{(Unit)topologyA.resolve("/TopologyA_Unit1")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		
		assertNotNull("The unit 'TopologyA_Unit1' was not moved to the " + topologyB.getQualifiedName() + " topology.", 
				topologyB.resolve("/TopologyA_Unit1"));
		assertNull("The unit 'TopologyA_Unit1' was not removed from the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyA_Unit1"));
		
		assertNotNull("The unit 'TopologyB_Unit1' was removed from the " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit1"));
		
		assertNotNull("The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' was not moved to " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertFalse("The source of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is imported.",
				( (DeployLink) topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getSourceURI().startsWith((topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR )) );
		
		assertEquals("The target of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is imported.", 
				topologyB.resolve("/TopologyA_Unit1"), ((HostingLink) topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getTarget());
		
		assertNotNull("The link 'TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic' was not moved to " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic"));
		
		assertEquals("The target of the link 'TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic' should be imported from the " + topologyA.getQualifiedName() + " topology.",
				topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + topologyA.resolve("/TopologyA_Unit2/Generic").getFullPath(), ( (DeployLink)topologyB.resolve("/TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic")).getTargetURI());
		
		assertEquals("The source of the link 'TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic' is imported.", 
				topologyB.resolve("/TopologyA_Unit1/r1"), ((DependencyLink)topologyB.resolve("/TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic")).getSource());
	}
	
	public void testMoveSourceOfLinkToTopologyOfImportedSourceOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyB().getFullPath().toString());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		model.setUnits(new Unit[]{(Unit)topologyA.resolve("/TopologyA_Unit3")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		
		assertNotNull("The unit 'TopologyA_Unit3' was not moved to the " + topologyB.getQualifiedName() + " topology.", 
				topologyB.resolve("/TopologyA_Unit3"));
		assertNull("The unit 'TopologyA_Unit3' was not removed from the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyA_Unit3"));
		
		assertNotNull("The unit 'TopologyB_Unit2' was removed from the " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit2"));
		
		assertNull("The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' was moved to " + topologyA.getQualifiedName() + " topology.",
				topologyA.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertFalse("The source of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is imported.",
				( (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getSourceURI().startsWith((topologyA.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR )) );
		
		assertEquals("The target of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is imported.", 
				topologyB.resolve("/TopologyB_Unit2"), ((HostingLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getTarget());
	}
	
	public void testMoveTargetOfLinkToTopologyOtherThanTheImportedTargetOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyC().getFullPath().toString());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		model.setUnits(new Unit[]{(Unit)topologyA.resolve("/TopologyA_Unit1")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK()); // $NON-NLS-1$
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		
		assertNotNull("The unit 'TopologyA_Unit1' was not moved to the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyA_Unit1"));
		assertNull("The unit 'TopologyA_Unit1' was not removed from the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyA_Unit1"));
		
		assertNotNull("The unit 'TopologyB_Unit1' was removed from the " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit1"));
		
		assertNotNull("The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' was not moved to " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the destination topology of the move refactoring.",
				topologyC.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertNotNull("An import for the " + topologyC.getQualifiedName() + " topology was not created in the source topology of the move refactoring.",
				topologyA.getImport(topologyC.getNamespace(), topologyC.getName()));
		
		assertNotNull("An import for the " + topologyC.getQualifiedName() + " topology was not created in the " + topologyB.getQualifiedName() + " topology.",
				topologyB.getImport(topologyC.getNamespace(), topologyC.getName()));
		
		assertFalse("The source of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is imported.",
				( (DeployLink) topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getSourceURI().startsWith((topologyB.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR )) );
		
		assertEquals("The target of the link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' is not imported.", 
				topologyC.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + topologyC.resolve("/TopologyA_Unit1").getFullPath(), ( (DeployLink) topologyB.resolve("/TopologyB_Unit1_Hosts_TopologyA_Unit1")).getTargetURI());
	}
	
	public void testMoveSourceOfLinkToTopologyOtherThanTheImportedSourceOfLink() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveUnitsRefactoringDescriptor model = MoveUnitsRefactoringDescriptor.createModel();
		model.setExistingTopologyFile(testSetup.getWorkspace().getTopologyC().getFullPath().toString());
		
		IFile topologyAFile = testSetup.getWorkspace().getTopologyA();
		Topology topologyA = model.getTopology(topologyAFile);
		model.setUnits(new Unit[]{(Unit)topologyA.resolve("/TopologyA_Unit3")});
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$
		
		IFile topologyCFile = testSetup.getWorkspace().getTopologyC();
		Topology topologyC = model.getTopology(topologyCFile);
		
		IFile topologyBFile = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBFile);
		
		assertNotNull("The unit 'TopologyA_Unit3' was not moved to the " + topologyC.getQualifiedName() + " topology.", 
				topologyC.resolve("/TopologyA_Unit3"));
		assertNull("The unit 'TopologyA_Unit3' was not removed from the " + topologyA.getQualifiedName() + " topology.", 
				topologyA.resolve("/TopologyA_Unit3"));
		
		assertNotNull("The unit 'TopologyB_Unit2' was removed from the " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyB_Unit2"));
		
		assertNotNull("The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' was not moved to " + topologyB.getQualifiedName() + " topology.",
				topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertNull("An import for the " + topologyB.getQualifiedName() + " topology was created in the destination topology of the move refactoring.",
				topologyC.getImport(topologyB.getNamespace(), topologyB.getName()));
		
		assertNull("An import for the " + topologyC.getQualifiedName() + " topology was created in the source topology of the move refactoring.",
				topologyA.getImport(topologyC.getNamespace(), topologyC.getName()));
		
		assertNotNull("An import for the " + topologyC.getQualifiedName() + " topology was not created in the " + topologyB.getQualifiedName() + " topology.",
				topologyB.getImport(topologyC.getNamespace(), topologyC.getName()));
		
		assertTrue("The source of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is not imported.",
				( (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getSourceURI().startsWith((topologyC.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR )) );
		
		assertFalse("The target of the link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' is imported.", 
				( (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2")).getTargetURI().equals(topologyC.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + topologyC.resolve("/TopologyA_Unit3").getFullPath()));
	}
	
	private void assertRefactoringTestsWorkspaceExtracted(TestSetup<RefactoringTestsWorkspace> testSetup) throws Exception {
		assertTrue( "The project '" + testSetup.getProject().getName() + "' did not get extracted or is not open.", testSetup.getWorkspace().getRefactoringTestsProject().isAccessible() );
		assertFileExists(testSetup.getWorkspace().getTopologyA());
		assertFileExists(testSetup.getWorkspace().getTopologyADiagram());
		assertFileExists(testSetup.getWorkspace().getTopologyB());
		assertFileExists(testSetup.getWorkspace().getTopologyBDiagram());
		assertFileExists(testSetup.getWorkspace().getTopologyC());
		assertFileExists(testSetup.getWorkspace().getTopologyCDiagram());
	}
	
	private void assertFileExists(IFile aFile) throws Exception {
		assertTrue( "The file '" + aFile.getFullPath() + "' did not get extracted.", aFile.exists() );
	}
	
	private IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}
}
