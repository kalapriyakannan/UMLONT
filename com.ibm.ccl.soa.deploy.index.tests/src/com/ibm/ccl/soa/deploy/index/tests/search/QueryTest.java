package com.ibm.ccl.soa.deploy.index.tests.search;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.core.test.TestSetup;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.deploy.index.tests.emf.index.xml.providers.ZDMEIndexTestWorkspace;
import com.ibm.ccl.soa.deploy.index.tests.emf.index.xml.providers.ZDMEModelIndexTests;
import com.ibm.xtools.emf.index.search.IndexContext;

public class QueryTest extends TestCase {

	private static final String ZDME_MODEL_INDEX_TESTS_PROJECT = ZDMEModelIndexTests.class
			.getSimpleName();
	private static final String NAMESPACE_FRAGMENT = ZDMEModelIndexTests.class.getPackage()
			.getName();
	private static final String TOPOLOGY_DIAGRAM_CONTENT_TYPE_ID = "com.ibm.ccl.soa.deploy.core.ui.topologyDiagramContentType"; //$NON-NLS-1$;
	private static final String TOPOLOGY_MODEL_CONTENT_TYPE_ID = "com.ibm.ccl.soa.deploy.core.topologyModelContentType"; //$NON-NLS-1$;
	private TestSetup<ZDMEIndexTestWorkspace> testSetup;
	private ROTopologyModelManager manager = null;

	public QueryTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {

		testSetup = new TestSetup<ZDMEIndexTestWorkspace>(ZDME_MODEL_INDEX_TESTS_PROJECT,
				NAMESPACE_FRAGMENT, new ZDMEIndexTestWorkspace());
		manager = ROTopologyModelManager.create();
	}

	protected void tearDown() throws Exception {
		testSetup.dispose();
		manager.dispose();
	}

	public void testFindReferences() throws Exception {

		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

		DeployModelObject dmo = aTopology.resolve("Unit");

		Collection<URI> results = null;

		for (int i = 0; i < 10; i++) {

			results = Query.findReferencers(Arrays.asList(new IContentType[] {
					Query.TOPOLOGY_MODEL_CONTENT_TYPE, Query.TOPOLOGY_DIAGRAM_CONTENT_TYPE }), dmo,
					Arrays.asList(new IResource[] { ResourcesPlugin.getWorkspace().getRoot() }), true,
					false, true, false, null);

			IndexContext context = new IndexContext(dmo.eResource().getResourceSet(), Arrays
					.asList(new IResource[] { ResourcesPlugin.getWorkspace().getRoot() }), null);
			Collection<URI> loaded = context.getLoadedResourceURIs();
			assertFalse(loaded
					.contains(URI
							.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv")));
			assertFalse(loaded
					.contains(URI
							.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/B.topology")));
			assertFalse(loaded
					.contains(URI
							.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/B.topologyv")));

			System.out.println("Results of search number " + (i + 1) + ", for references to ("
					+ EcoreUtil.getURI(dmo) + "):");
			int k = 1;
			for (Iterator<URI> iter = results.iterator(); iter.hasNext(); k++) {
				System.out.println(k + ": " + iter.next().toString());
			}

			assertTrue(
					"Did not find /ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv#_Qkb5cKjvEdyD25MX4NRYfQ",
					results
							.contains(URI
									.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv#_Qkb5cKjvEdyD25MX4NRYfQ")));
			assertTrue(
					"Did not find /ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/",
					results
							.contains(URI
									.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/A.topology#/")));
			assertTrue(
					"Did not find /ZDMEIndexTest/topologies/com/acme/topologies/B.topology#com.acme.topologies.A:/Unit",
					results
							.contains(URI
									.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/B.topology#com.acme.topologies.A:/Unit")));
			assertTrue(
					"Did not find /ZDMEIndexTest/topologies/com/acme/topologies/B.topology#/Unit",
					results
							.contains(URI
									.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/B.topology#/Unit")));
			assertTrue(
					"Did not find /ZDMEIndexTest/topologies/com/acme/topologies/B.topologyv#_OwDxwKjvEdyD25MX4NRYfQ",
					results
							.contains(URI
									.createPlatformResourceURI("/ZDMEIndexTest/topologies/com/acme/topologies/B.topologyv#_OwDxwKjvEdyD25MX4NRYfQ")));
			assertTrue(results.size() == 5);
		}
	}

	public void testFindReferencingDiagramResources() throws Exception {
		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

		Collection<IFile> results = Query.findReferencingDiagramResources(aTopology, null, true,
				false, true, false, null);

		boolean foundDiagramResource = false;
		for (Iterator<IFile> iter = results.iterator(); iter.hasNext();) {
			IFile resource = iter.next();
			if ("/ZDMEIndexTest/topologies/com/acme/topologies/A.topologyv".equals(resource
					.getFullPath().toString())) {
				foundDiagramResource = true;
			}
		}

		assertTrue(
				"Did not find the diagram for the topology at ZDMEIndexTest/topologies/com/acme/topologies/A.topology",
				foundDiagramResource);
	}

	public void testFindImportingTopologyReferences() throws Exception {
		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

		Collection<IFile> results = Query.findImportingTopologyReferences(aTopology, null, true,
				false, true, false, null);

		boolean foundTopologyBResource = false;
		for (Iterator<IFile> iter = results.iterator(); iter.hasNext();) {
			IFile resource = iter.next();
			if (new Path("/ZDMEIndexTest/topologies/com/acme/topologies/B.topology").equals(resource
					.getFullPath())) {
				foundTopologyBResource = true;
			}
		}

		assertTrue("Did not find the topology B resource that imports topology A.",
				foundTopologyBResource);
	}

	public void testFindDeployLinksByImportedTarget() throws Exception {
		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

		DeployModelObject a = aTopology.resolve("Unit");
		Collection<URI> results = Query.findDeployLinksByImportedTarget(a, null, true, false, true,
				false, null);

		boolean foundTopologyBLink = false;
		for (Iterator<URI> iter = results.iterator(); iter.hasNext();) {
			URI eObject = iter.next();
			if (URI.createPlatformResourceURI(
					"/ZDMEIndexTest/topologies/com/acme/topologies/B.topology").appendFragment(
					"/Unit/UnitHostsUnit").equals(eObject)) {
				foundTopologyBLink = true;
			}
		}

		assertTrue(
				"Did not find DeployLink in topology B that points to the import of topology a's Unit.",
				foundTopologyBLink);
	}

	public void testFindDeployLinksByImportedTopology() throws Exception {
		Topology aTopology = manager.openModel(testSetup.getWorkspace().getTopologyA(),
				new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

		Collection<URI> results = Query.findDeployLinksByImportedTopology(aTopology, null, true,
				false, true, false, null);

		boolean foundTopologyBLink = false;
		for (Iterator<URI> iter = results.iterator(); iter.hasNext();) {
			URI eObject = iter.next();
			if (URI.createPlatformResourceURI(
					"/ZDMEIndexTest/topologies/com/acme/topologies/B.topology").appendFragment(
					"/Unit/UnitHostsUnit").equals(eObject)) {
				foundTopologyBLink = true;
			}
		}

		assertTrue(
				"Did not find DeployLink in topology B that points to the import of topology a's Unit.",
				foundTopologyBLink);
	}
}
