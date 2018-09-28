package com.ibm.ccl.soa.deploy.ide.tests.refactoring;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.ITechnologyFlavorLifecycle;

public class RenameTopologyRefactoringTests extends TestCase {

	private static final String REFACTORING_TESTS_PROJECT = RenameTopologyRefactoringTests.class.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = RenameTopologyRefactoringTests.class.getPackage().getName();
	
	private TestSetup<RefactoringTestsWorkspace> testSetup;
	
	public RenameTopologyRefactoringTests(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
//		suite.addTest(new RenameTopologyRefactoringTests("testRenameTopologyX2"));
		suite.addTestSuite(RenameTopologyRefactoringTests.class);
		return suite;
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
	
	public void testRenameTopologyWithNoImports() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		RenameTopologyDescriptor model = RenameTopologyDescriptor.createModel();
		model.setTopology(testSetup.getWorkspace().getTopologyC().getFullPath().toString());
		model.setName(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("D.topology").toString());
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyCLocation = testSetup.getWorkspace().getTopologyC();
		assertFalse( "The C.topology still exists in the workspace.", oldTopologyCLocation.exists());
		
		IFile newTopologyCLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("D.topology"));
		assertTrue( "The C.topology was not sucessfully renamed to D.topology.", newTopologyCLocation.exists());
		
		Topology topologyC = model.getTopology(newTopologyCLocation);
		assertEquals( "The new D.topology does not have the correct namespace 'com.acme.topologies'.", "com.acme.topologies", topologyC.getNamespace());
		assertEquals( "The new D.topology does not have the correct name 'D'.", "D", topologyC.getName());
		
		newTopologyCLocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyCDiagram = newTopologyCLocation.getProject().getFile(newTopologyCLocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for C.topology was not renamed to '" + topologyCDiagram.getName() + "'.", topologyCDiagram.exists());
		
		IEditModelScribbler scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(testSetup.getProject(), new ScribblerDomain( topologyCDiagram ) );
		
		try { 
			
			XMIResource resource = (XMIResource) scribbler.getResource(topologyCDiagram);
			
			View topologyCDiagramView = (View) resource.getEObject("_9fZFILpbEdyYMsxxHQObZQ");
			DeployModelObject topologyCElement = ( DeployModelObject ) topologyCDiagramView.getElement();
			assertEquals( "The href of the defined element for the view '_9fZFILpbEdyYMsxxHQObZQ' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/", newTopologyCLocation.getName() + "#" + topologyCElement.getFullPath() );
			
			View topologyCUnit1View = (View) resource.getEObject("_-gXZ8LpbEdyYMsxxHQObZQ");
			DeployModelObject unit1 = ( DeployModelObject ) topologyCUnit1View.getElement();
			assertEquals( "The href of the defined element for the view '_-gXZ8LpbEdyYMsxxHQObZQ' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit1", newTopologyCLocation.getName() + "#" + unit1.getFullPath() );
			
			View topologyCUnit2View = (View) resource.getEObject("_2g_-UM6hEdy8Q-oz9nBi4g");
			DeployModelObject unit2 = ( DeployModelObject ) topologyCUnit2View.getElement();
			assertEquals( "The href of the defined element for the view '_2g_-UM6hEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit2", newTopologyCLocation.getName() + "#" + unit2.getFullPath() );
		
			View topologyCUnit3View = (View) resource.getEObject("_UyM4sM6yEdy8Q-oz9nBi4g");
			DeployModelObject unit3 = ( DeployModelObject ) topologyCUnit3View.getElement();
			assertEquals( "The href of the defined element for the view '_UyM4sM6yEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit3", newTopologyCLocation.getName() + "#" + unit3.getFullPath() );
		
			View topologyCUnit4View = (View) resource.getEObject("_44qh0M64Edy8Q-oz9nBi4g");
			DeployModelObject unit4 = ( DeployModelObject ) topologyCUnit4View.getElement();
			assertEquals( "The href of the defined element for the view '_44qh0M64Edy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit4", newTopologyCLocation.getName() + "#" + unit4.getFullPath() );
		
			View topologyCUnit1DependencyLinkToUnit2View = (View) resource.getEObject("_B8ysMM6iEdy8Q-oz9nBi4g");
			DeployModelObject link = ( DeployModelObject ) topologyCUnit1DependencyLinkToUnit2View.getElement();
			assertEquals( "The href of the defined element for the view '_B8ysMM6iEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit1/r0/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic", newTopologyCLocation.getName() + "#" + link.getFullPath() );
		
		} finally {
			scribbler.close(new NullProgressMonitor());
		}
	}
	
	public void testRenameTopologyThatOtherTopologiesImport() throws Exception {
		assertRefactoringTestsWorkspaceExtracted(testSetup);
		RenameTopologyDescriptor model = RenameTopologyDescriptor.createModel();
		model.setTopology(testSetup.getWorkspace().getTopologyA().getFullPath().toString());
		model.setName(testSetup.getWorkspace().getTopologyA().getFullPath().removeLastSegments(1).append("D.topology").toString());
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyALocation = testSetup.getWorkspace().getTopologyA();
		assertFalse( "The A.topology still exists in the workspace.", oldTopologyALocation.exists());
		
		IFile newTopologyALocation = ResourcesPlugin.getWorkspace().getRoot().getFile(testSetup.getWorkspace().getTopologyA().getFullPath().removeLastSegments(1).append("D.topology"));
		assertTrue( "The A.topology was not sucessfully renamed to D.topology.", newTopologyALocation.exists());
		
		Topology topologyA = model.getTopology(newTopologyALocation);
		assertEquals( "The new D.topology does not have the correct namespace 'com.acme.topologies'.", "com.acme.topologies", topologyA.getNamespace());
		assertEquals( "The new D.topology does not have the correct name 'D'.", "D", topologyA.getName());
		
		IFile topologyBLocation = testSetup.getWorkspace().getTopologyB();
		Topology topologyB = model.getTopology(topologyBLocation);
		
		assertNull( "The B.topology still imports the now non-existent com.acme.topologies.A topology.", topologyB.getImport("com.acme.topologies", "A"));
		assertNotNull( "The B.topology does not import the new name for the A.topology 'com.acme.topologies.D'.", topologyB.getImport("com.acme.topologies", "D"));
		
		DeployLink link = (DeployLink) topologyB.resolve("/TopologyA_Unit3_Hosts_TopologyB_Unit2"); 
		assertEquals( "The link 'TopologyA_Unit3_Hosts_TopologyB_Unit2' in B.topology does not point to the new topology A location 'com.acme.topologies.D'.", 
				"com.acme.topologies.D:/TopologyA_Unit3", link.getSourceURI()	);
		
		DeployLink link2 = (DeployLink) topologyB.resolve("/TopologyB_Unit1/TopologyB_Unit1_Hosts_TopologyA_Unit1");
		assertEquals( "The link 'TopologyB_Unit1_Hosts_TopologyA_Unit1' in B.topology does not point to the new topology A location 'com.acme.topologies.D'.",
				"com.acme.topologies.D:/TopologyA_Unit1", link2.getTargetURI()	);
		
		newTopologyALocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyADiagram = newTopologyALocation.getProject().getFile(newTopologyALocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for A.topology was not renamed to '" + topologyADiagram.getName() + "'.", topologyADiagram.exists());
	}
	
	public void testRenameTopologyX2() throws Exception {
		// X1
		testRenameTopologyWithNoImports();
		
		// X2
		RenameTopologyDescriptor model = RenameTopologyDescriptor.createModel();
		model.setTopology(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("D.topology").toString());
		model.setName(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("E.topology").toString());
		
		IStatus status = model.createConfiguredOperation().execute(new NullProgressMonitor(), null);
		
		assertTrue("The operation did not complete successfully: " + getStatusWithHighestSeverity( status ).getMessage(), status.isOK());
		
		IFile oldTopologyCLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("D.topology"));
		assertFalse( "The D.topology still exists in the workspace.", oldTopologyCLocation.exists());
		
		IFile newTopologyCLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(testSetup.getWorkspace().getTopologyC().getFullPath().removeLastSegments(1).append("E.topology"));
		assertTrue( "The C.topology was not sucessfully renamed to E.topology.", newTopologyCLocation.exists());
		
		Topology topologyC = model.getTopology(newTopologyCLocation);
		assertEquals( "The new E.topology does not have the correct namespace 'com.acme.topologies'.", "com.acme.topologies", topologyC.getNamespace());
		assertEquals( "The new E.topology does not have the correct name 'E'.", "E", topologyC.getName());
		
		newTopologyCLocation.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile topologyCDiagram = newTopologyCLocation.getProject().getFile(newTopologyCLocation.getProjectRelativePath().removeFileExtension().addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
		assertTrue( "The default diagram for D.topology was not renamed to '" + topologyCDiagram.getName() + "'.", topologyCDiagram.exists());
		
		IEditModelScribbler scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(testSetup.getProject(), new ScribblerDomain( topologyCDiagram ) );
		
		try { 
			
			XMIResource resource = (XMIResource) scribbler.getResource(topologyCDiagram);
			
			View topologyCDiagramView = (View) resource.getEObject("_9fZFILpbEdyYMsxxHQObZQ");
			DeployModelObject topologyCElement = ( DeployModelObject ) topologyCDiagramView.getElement();
			assertEquals( "The href of the defined element for the view '_9fZFILpbEdyYMsxxHQObZQ' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/", newTopologyCLocation.getName() + "#" + topologyCElement.getFullPath() );
			
			View topologyCUnit1View = (View) resource.getEObject("_-gXZ8LpbEdyYMsxxHQObZQ");
			DeployModelObject unit1 = ( DeployModelObject ) topologyCUnit1View.getElement();
			assertEquals( "The href of the defined element for the view '_-gXZ8LpbEdyYMsxxHQObZQ' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit1", newTopologyCLocation.getName() + "#" + unit1.getFullPath() );
			
			View topologyCUnit2View = (View) resource.getEObject("_2g_-UM6hEdy8Q-oz9nBi4g");
			DeployModelObject unit2 = ( DeployModelObject ) topologyCUnit2View.getElement();
			assertEquals( "The href of the defined element for the view '_2g_-UM6hEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit2", newTopologyCLocation.getName() + "#" + unit2.getFullPath() );
		
			View topologyCUnit3View = (View) resource.getEObject("_UyM4sM6yEdy8Q-oz9nBi4g");
			DeployModelObject unit3 = ( DeployModelObject ) topologyCUnit3View.getElement();
			assertEquals( "The href of the defined element for the view '_UyM4sM6yEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit3", newTopologyCLocation.getName() + "#" + unit3.getFullPath() );
		
			View topologyCUnit4View = (View) resource.getEObject("_44qh0M64Edy8Q-oz9nBi4g");
			DeployModelObject unit4 = ( DeployModelObject ) topologyCUnit4View.getElement();
			assertEquals( "The href of the defined element for the view '_44qh0M64Edy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit4", newTopologyCLocation.getName() + "#" + unit4.getFullPath() );
		
			View topologyCUnit1DependencyLinkToUnit2View = (View) resource.getEObject("_B8ysMM6iEdy8Q-oz9nBi4g");
			DeployModelObject link = ( DeployModelObject ) topologyCUnit1DependencyLinkToUnit2View.getElement();
			assertEquals( "The href of the defined element for the view '_B8ysMM6iEdy8Q-oz9nBi4g' in the " +  topologyCDiagram.getName() + " diagram is incorrect.", newTopologyCLocation.getName() + "#/TopologyC_Unit1/r0/TopologyC_Unit1_r0_to_TopologyC_Unit2_Generic", newTopologyCLocation.getName() + "#" + link.getFullPath() );
		
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
