package com.ibm.ccl.soa.deploy.ide.tests.refactoring;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.ITechnologyFlavorLifecycle;

public class MoveTopologyRefactoringTests extends TestCase {

	private static final String REFACTORING_TESTS_PROJECT = MoveTopologyRefactoringTests.class.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = MoveTopologyRefactoringTests.class.getPackage().getName();
	
	private TestSetup<RefactoringTestsWorkspace> testSetup;
	
	public MoveTopologyRefactoringTests(String name) { 
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
	
	public void testMoveTopologyWithNoImports() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveTopologyDescriptor model = MoveTopologyDescriptor.createModel();
		model.setTopologies(new IResource[] { testSetup.getWorkspace().getTopologyC()});
		model.setContainer( testSetup.getWorkspace().getTopologyC().getParent().getParent().getFullPath().toString() );
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyCLocation = testSetup.getWorkspace().getTopologyC();
		assertFalse( "The C.topology still exists in it's old location.", oldTopologyCLocation.exists() );
		
		IFile newTopologyCLocation = testSetup.getWorkspace().getTopologyC().getParent().getParent().getFile(new Path("C.topology"));
		assertTrue( "The C.topology was not moved to it's new location.", newTopologyCLocation.exists() );
		
		Topology topologyC = model.getTopology(newTopologyCLocation);
		
		assertEquals( "The namespace of C.topology was not updated to reflect it's new location.", "com.acme", topologyC.getNamespace() );
		
		newTopologyCLocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyCDiagram = newTopologyCLocation.getProject().getFile(newTopologyCLocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for the C.topology was not moved to the same location as the C.topology file.", topologyCDiagram.exists());
	}
	
	public void testMoveTopologyToEmptyNamespace() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveTopologyDescriptor model = MoveTopologyDescriptor.createModel();
		model.setTopologies(new IResource[] { testSetup.getWorkspace().getTopologyA()});
		model.setContainer( testSetup.getWorkspace().getTopologyA().getParent().getParent().getParent().getParent().getFullPath().toString() );
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyALocation = testSetup.getWorkspace().getTopologyA();
		assertFalse( "The A.topology still exists in it's old location.", oldTopologyALocation.exists() );
		
		IFile newTopologyALocation = testSetup.getWorkspace().getTopologyA().getParent().getParent().getParent().getParent().getFile(new Path("A.topology"));
		assertTrue( "The A.topology was not moved to it's new location.", newTopologyALocation.exists() );
		
		Topology topologyA = model.getTopology(newTopologyALocation);
		
		assertEquals( "The namespace of A.topology was not updated to reflect it's new location.", "", topologyA.getNamespace() );
		
		IFile topologyBLocation = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBLocation);
		
		assertNull( "The B.topology still imports the now non-existent com.acme.topologies.A.", topologyB.getImport("com.acme.topologies", "A"));
		assertNotNull( "The B.topology does not import topology A in it's new qualifed name com.acme.A", topologyB.getImport(null, "A"));
		
		DeployLink link = (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"); 
		assertEquals( "The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' in B.topology does not point to the new topology A location 'A'.", 
				"A:/TopologyA_Unit3", link.getSourceURI()	);
		
		DeployLink link2 = (DeployLink) topologyB.resolve("/TopologyB_Unit1/TopologyB_Unit1_Hosts_TopologyA_Unit1");
		assertEquals( "The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' in B.topology does not point to the new topology A location 'A'.",
				"A:/TopologyA_Unit1", link2.getTargetURI()	);
		
		newTopologyALocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyADiagram = newTopologyALocation.getProject().getFile(newTopologyALocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for the A.topology was not moved to the same location as the A.topology file.", topologyADiagram.exists());
		
		IFile topologyBDiagram = testSetup.getWorkspace().getTopologyBDiagram();
		IEditModelScribbler scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(testSetup.getProject(), new ScribblerDomain( topologyBDiagram ) );
		
		try { 
			
			XMIResource resource = (XMIResource) scribbler.getResource(topologyBDiagram);
			
			View topologyAUnit2ProxyView = (View) resource.getEObject("_2rdYgM66Edy8Q-oz9nBi4g");
			DeployModelObject unit2 = ( DeployModelObject ) topologyAUnit2ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rdYgM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#A:/TopologyA_Unit2", "B.topology#" + EcoreUtil.getURI(unit2).fragment() );
			
			View topologyAUnit3ProxyView = (View) resource.getEObject("_2rdYis66Edy8Q-oz9nBi4g" );
			DeployModelObject unit3 = ( DeployModelObject ) topologyAUnit3ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rdYis66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#A:/TopologyA_Unit3", "B.topology#" + EcoreUtil.getURI(unit3).fragment() );
			
			View topologyAUnit1ProxyView = (View) resource.getEObject("_2rnJgM66Edy8Q-oz9nBi4g" );
			DeployModelObject unit1 = ( DeployModelObject ) topologyAUnit1ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rnJgM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#A:/TopologyA_Unit1", "B.topology#" + EcoreUtil.getURI(unit1).fragment() );
			
			View topologyAUnit1DependencyLinkToTopologyAUnit2ProxyView = (View) resource.getEObject("_2rw6gM66Edy8Q-oz9nBi4g" );
			DeployModelObject dependencyLink1 = ( DeployModelObject ) topologyAUnit1DependencyLinkToTopologyAUnit2ProxyView.getElement();
			assertEquals( "The href of the defined element for the edge '_2rw6gM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#A:/TopologyA_Unit1/r1/TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic", "B.topology#" + EcoreUtil.getURI(dependencyLink1).fragment() );
			
		} finally {
			scribbler.close(new NullProgressMonitor());
		}
	}
	
	public void testMoveTopologyThatOtherTopologiesImport() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		MoveTopologyDescriptor model = MoveTopologyDescriptor.createModel();
		model.setTopologies(new IResource[] { testSetup.getWorkspace().getTopologyA()});
		model.setContainer( testSetup.getWorkspace().getTopologyA().getParent().getParent().getFullPath().toString() );
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyALocation = testSetup.getWorkspace().getTopologyA();
		assertFalse( "The A.topology still exists in it's old location.", oldTopologyALocation.exists() );
		
		IFile newTopologyALocation = testSetup.getWorkspace().getTopologyA().getParent().getParent().getFile(new Path("A.topology"));
		assertTrue( "The A.topology was not moved to it's new location.", newTopologyALocation.exists() );
		
		Topology topologyA = model.getTopology(newTopologyALocation);
		
		assertEquals( "The namespace of A.topology was not updated to reflect it's new location.", "com.acme", topologyA.getNamespace() );
		
		IFile topologyBLocation = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBLocation);
		
		assertNull( "The B.topology still imports the now non-existent com.acme.topologies.A.", topologyB.getImport("com.acme.topologies", "A"));
		assertNotNull( "The B.topology does not import topology A in it's new qualifed name com.acme.A", topologyB.getImport("com.acme", "A"));
		
		DeployLink link = (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"); 
		assertEquals( "The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' in B.topology does not point to the new topology A location 'com.acme.A'.", 
				"com.acme.A:/TopologyA_Unit3", link.getSourceURI()	);
		
		DeployLink link2 = (DeployLink) topologyB.resolve("/TopologyB_Unit1/TopologyB_Unit1_Hosts_TopologyA_Unit1");
		assertEquals( "The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' in B.topology does not point to the new topology A location 'com.acme.A'.",
				"com.acme.A:/TopologyA_Unit1", link2.getTargetURI()	);
		
		newTopologyALocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyADiagram = newTopologyALocation.getProject().getFile(newTopologyALocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for the A.topology was not moved to the same location as the A.topology file.", topologyADiagram.exists());
		
		IFile topologyBDiagram = testSetup.getWorkspace().getTopologyBDiagram();
		IEditModelScribbler scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(testSetup.getProject(), new ScribblerDomain( topologyBDiagram ) );
		
		try { 
			
			XMIResource resource = (XMIResource) scribbler.getResource(topologyBDiagram);
			
			View topologyAUnit2ProxyView = (View) resource.getEObject("_2rdYgM66Edy8Q-oz9nBi4g");
			DeployModelObject unit2 = ( DeployModelObject ) topologyAUnit2ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rdYgM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#com.acme.A:/TopologyA_Unit2", "B.topology#" + EcoreUtil.getURI(unit2).fragment() );
			
			View topologyAUnit3ProxyView = (View) resource.getEObject("_2rdYis66Edy8Q-oz9nBi4g" );
			DeployModelObject unit3 = ( DeployModelObject ) topologyAUnit3ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rdYis66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#com.acme.A:/TopologyA_Unit3", "B.topology#" + EcoreUtil.getURI(unit3).fragment() );
			
			View topologyAUnit1ProxyView = (View) resource.getEObject("_2rnJgM66Edy8Q-oz9nBi4g" );
			DeployModelObject unit1 = ( DeployModelObject ) topologyAUnit1ProxyView.getElement();
			assertEquals( "The href of the defined element for the view '_2rnJgM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#com.acme.A:/TopologyA_Unit1", "B.topology#" + EcoreUtil.getURI(unit1).fragment() );
			
			View topologyAUnit1DependencyLinkToTopologyAUnit2ProxyView = (View) resource.getEObject("_2rw6gM66Edy8Q-oz9nBi4g" );
			DeployModelObject dependencyLink1 = ( DeployModelObject ) topologyAUnit1DependencyLinkToTopologyAUnit2ProxyView.getElement();
			assertEquals( "The href of the defined element for the edge '_2rw6gM66Edy8Q-oz9nBi4g' in the B.topologyv diagram is incorrect.", "B.topology#com.acme.A:/TopologyA_Unit1/r1/TopologyA_Unit1_r1_to_TopologyA_Unit2_Generic", "B.topology#" + EcoreUtil.getURI(dependencyLink1).fragment() );
			
		} finally {
			scribbler.close(new NullProgressMonitor());
		}
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
	
	public static class ScribblerDomain extends DefaultScribblerDomain {

		private final List<IFile> files;

		public ScribblerDomain(IFile file) {
			files = new ArrayList<IFile>();
			files.add(file);
		}

		public void addTechnologyFlavorLifecycle(ITechnologyFlavorLifecycle arg0) {
			// do nothing
		}

		public String getEditModelLabel() {
			return ScribblerDomain.class.getName() + ".editmodel"; //$NON-NLS-1$
		}

		public IResourceDescriptor[] getResourceDescriptors() {
			return new IResourceDescriptor[0];
		}

		public ITechnologyFlavorLifecycle getTechnologyFlavorLifecycle(String arg0) {
			return null;
		}

		public ITechnologyFlavorLifecycle[] getTechnologyFlavorLifecycles() {
			return new ITechnologyFlavorLifecycle[0];
		}

		public boolean isContained(IResourceDescriptor arg0) {
			return false;
		}

		public boolean isContained(Resource aResource) {
			if (files.contains(aResource)) {
				return true;
			}
			return false;
		}

		public String getLabel() {
			return getEditModelLabel();
		}

		public boolean matches(IUndoContext context) {
			return false;
		}

	}
	
}
