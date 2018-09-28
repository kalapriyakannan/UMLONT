package com.ibm.ccl.soa.deploy.index.tests.emf.index.xml.providers;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.xtools.emf.index.search.IIndexSearchManager;
import com.ibm.xtools.emf.index.search.IndexContext;

public class ZDMEModelIndexTests extends TestCase {

	private static final String ZDME_MODEL_INDEX_TESTS_PROJECT = ZDMEModelIndexTests.class
			.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = ZDMEModelIndexTests.class.getPackage()
			.getName();
	private TestSetup<ZDMEIndexTestWorkspace> testSetup;
	private ROTopologyModelManager manager;

	protected void setUp() throws Exception {

		testSetup = new TestSetup<ZDMEIndexTestWorkspace>(ZDME_MODEL_INDEX_TESTS_PROJECT,
				NAMESPACE_FRAGMENT, new ZDMEIndexTestWorkspace());
		manager = ROTopologyModelManager.create();

	}

	protected void tearDown() throws Exception {
		testSetup.dispose();
		manager.dispose();
	}

	public void testFindUnitReferencesByEObject() throws Exception {
		IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE.getContext(testSetup
				.getWorkspace().getZDMEIndexTestProject());
		IndexContext context = IndexContext.createWorkspaceContext(emfContext.getResourceSet());

		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});
		DeployModelObject dmo = aTopology.resolve("Unit");
		Collection results = IIndexSearchManager.INSTANCE
				.findReferencingResources(context, dmo, null);

		boolean foundModelResource = false;
		boolean foundDiagramResource = false;
		for (Iterator<Resource> iter = results.iterator(); iter.hasNext();) {
			Resource resource = iter.next();
			URI uri = resource.getURI();
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topology").equals(uri)) {
				foundModelResource = true;
			}

			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv").equals(uri)) {
				foundDiagramResource = true;
			}
		}

		assertTrue(
				"Did not find the model resource reference for the unit at: \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit\"",
				foundModelResource);
		assertTrue(
				"Did not find the diagram resource reference for the unit at: \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit\"",
				foundDiagramResource);
	}

	public void testFindUnitReferencesByURI() throws Exception {
		IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE.getContext(testSetup
				.getWorkspace().getZDMEIndexTestProject());
		IndexContext context = IndexContext.createWorkspaceContext(emfContext.getResourceSet());
		Collection results = IIndexSearchManager.INSTANCE
				.findReferencingResources(
						context,
						URI
								.createURI("platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit"),
						null);

		boolean foundModelResource = false;
		boolean foundDiagramResource = false;
		for (Iterator<Resource> iter = results.iterator(); iter.hasNext();) {
			Resource resource = iter.next();
			URI uri = resource.getURI();
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topology").equals(uri)) {
				foundModelResource = true;
			}

			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv").equals(uri)) {
				foundDiagramResource = true;
			}
		}

		assertTrue(
				"Did not find the diagram resource reference for the uri: \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv#/Unit\"",
				foundDiagramResource);
//		assertTrue(
//				"Did not find the model resource reference for the uri: \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit\"",
//				foundModelResource);
	}

	public void testFindUnitsByEClass() throws Exception {
		IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE.getContext(testSetup
				.getWorkspace().getZDMEIndexTestProject());
		IndexContext context = IndexContext.createWorkspaceContext(emfContext.getResourceSet());
		context.getOptions().put(IndexContext.STRICT_ECLASS_EQUALITY, Boolean.TRUE);
		Collection results = IIndexSearchManager.INSTANCE.findEObjects(context, CorePackage.eINSTANCE
				.getUnit(), null);

		boolean foundModelAResource = false;
		boolean foundModelBResource = false;
		for (Iterator<EObject> iter = results.iterator(); iter.hasNext();) {
			EObject object = iter.next();
			assertTrue("Found unit that does not extend DeployModelObject: " + object,
					CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(object.eClass()));
			URI uri = EcoreUtil.getURI(object);
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topology").appendFragment("/Unit")
					.equals(uri)) {
				foundModelAResource = true;
			}
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/B.topology").appendFragment("/Unit")
					.equals(uri)) {
				foundModelBResource = true;
			}
		}

		assertTrue(
				"Did not find the model resource reference for the unit located at \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit\"",
				foundModelAResource);
		assertTrue(
				"Did not find the model resource reference for the unit located at \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/B.topology#/Unit\"",
				foundModelBResource);
	}

	public void testFindUnitsByName() throws Exception {
		IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE.getContext(testSetup
				.getWorkspace().getZDMEIndexTestProject());
		IndexContext context = IndexContext.createWorkspaceContext(emfContext.getResourceSet());
		Collection results = IIndexSearchManager.INSTANCE.findEObjects(context, "Unit",
				CorePackage.eINSTANCE.getDeployModelObject_Name(), CorePackage.eINSTANCE.getUnit(),
				null);

		boolean foundModelAResource = false;
		boolean foundModelBResource = false;
		for (Iterator<EObject> iter = results.iterator(); iter.hasNext();) {
			EObject object = iter.next();
			assertTrue("Found unit that does not extend Unit: " + object, CorePackage.eINSTANCE
					.getUnit().isSuperTypeOf(object.eClass()));
			URI uri = EcoreUtil.getURI(object);
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/A.topology").appendFragment("/Unit")
					.equals(uri)) {
				foundModelAResource = true;
			}
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/B.topology").appendFragment("/Unit")
					.equals(uri)) {
				foundModelBResource = true;
			}
		}

		assertTrue(
				"Did not find the unit located in the resource at \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/Unit\"",
				foundModelAResource);
		assertTrue(
				"Did not find the unit located in the resource at \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/B.topology#/Unit\"",
				foundModelBResource);
	}

	public void testFindImportsByNamespace() throws Exception {
		IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE.getContext(testSetup
				.getWorkspace().getZDMEIndexTestProject());
		IndexContext context = IndexContext.createWorkspaceContext(emfContext.getResourceSet());
		Collection results = IIndexSearchManager.INSTANCE.findEObjects(context,
				"com.acme.topologies", CorePackage.eINSTANCE.getImport_Namespace(),
				CorePackage.eINSTANCE.getImport(), null);

		boolean foundModelBResource = false;
		for (Iterator<EObject> iter = results.iterator(); iter.hasNext();) {
			EObject object = iter.next();
			assertTrue("Found unit that does not extend Import: " + object, CorePackage.eINSTANCE
					.getImport().isSuperTypeOf(object.eClass()));
			URI uri = EcoreUtil.getURI(object);
			if (URI.createPlatformResourceURI(
					"ZDMEIndexTest/topologies/com/acme/topologies/B.topology").appendFragment("/A")
					.equals(uri)) {
				foundModelBResource = true;
			}
		}

		assertTrue(
				"Did not find the import located in the resource at \"platform:/resource/ZDMEIndexTest/topologies/com/acme/topologies/B.topology#/A\"",
				foundModelBResource);
	}
}
