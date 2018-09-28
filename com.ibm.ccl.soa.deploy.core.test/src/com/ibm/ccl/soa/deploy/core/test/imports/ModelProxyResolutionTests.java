/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

public class ModelProxyResolutionTests extends TestCase {

	private static final String PROXY_PROJECT_NAME = "ProxyTests";

	private static final String NAMESPACE_FRAGMENT = "com.acme";

	private static final String REFERENCING = "Referencing";
	private static final String REFERENCED = "Referenced";
	private static final String REFERENCED2 = "Referenced2";

	private static final String UNIT = "Unit";
	private static final String TOPOLOGY = "Topology";

	private static final String REFERENCED_UNIT = REFERENCED + UNIT;
	private static final String REFERENCED_TOPOLOGY = REFERENCED + TOPOLOGY;

	private static final String REFERENCING_UNIT = REFERENCING + UNIT;
	private static final String REFERENCING_TOPOLOGY = REFERENCING + TOPOLOGY;
	private static final Object EXPECTED_PATH = NAMESPACE_FRAGMENT
			+ IConstants.DOT_SEPARATOR + REFERENCED_TOPOLOGY
			+ IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
			+ REFERENCED_UNIT;

	private static final String[] REFERENCED_TOPOLOGIES = new String[] {
			REFERENCED, REFERENCED2 };

	private static final String REQUIREMENT1 = "Requirement1";
	private static final String HOSTING_CAPABILITY = "HostingCapability";
	private static final String DEPENDENCY_CAPABILITY = "DependencyCapability";

	private IProject project;
	private DeploymentTopologyDomain referencingDomain;
	private INamespaceFragment fragment;

	public ModelProxyResolutionTests(String name) {
		super(name);
	}

	public static TestSuite suite() {

		TestSuite suite = new TestSuite();
		suite.addTestSuite(ModelProxyResolutionTests.class); 
//		suite.addTest(new ModelProxyResolutionTests("testCreateHostingLinkFromAndTargingReferencedTopology"));
		return suite;
	}

	protected void setUp() throws Exception {
		super.setUp();

		IProgressMonitor monitor = new NullProgressMonitor();

		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROXY_PROJECT_NAME);
		if (!project.exists()) {
			project.create(monitor);
			project.open(monitor);
		}

		INamespaceFragmentRoot root = NamespaceCore.createRoot(project
				.getFolder("topologies"), monitor);
		fragment = root.getNamespaceFragment(NAMESPACE_FRAGMENT);
		if (!fragment.exists())
			fragment.create(monitor);

		referencingDomain = new DeploymentTopologyDomain(fragment
				.getTopology(REFERENCING + TOPOLOGY));

		// setup referenced topology
		setupReferencedTopology(REFERENCED);
		setupReferencedTopology(REFERENCED2);
		setupReferencingTopology(REFERENCING);

		// Must be setup by this method.
		assertNotNull(project);
		assertNotNull(referencingDomain);
		assertNotNull(fragment);
	}

	private void setupReferencingTopology(String baseName)
			throws EditModelException, ExecutionException {
		final IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite( );

		try {
			IFile referencingFile = fragment.getTopology(baseName + TOPOLOGY);

			// setup referencing topology
			final DeployCoreRoot referencingRoot = CoreFactory.eINSTANCE
					.createDeployCoreRoot();
			Topology referencingTopology = CoreFactory.eINSTANCE
					.createTopology();
			referencingTopology.setName(baseName + TOPOLOGY);
			referencingTopology.setNamespace(fragment.getQualifiedName());
			referencingRoot.setTopology(referencingTopology);

			// setup import
			for (int i = 0; i < REFERENCED_TOPOLOGIES.length; i++) {

				Import imported = CoreFactory.eINSTANCE.createImport();
				imported.setNamespace(fragment.getQualifiedName());
				imported.setPattern(REFERENCED_TOPOLOGIES[i] + TOPOLOGY);
				referencingTopology.getImports().add(imported);

				imported.setInstanceConfiguration(CoreFactory.eINSTANCE
						.createInstanceConfiguration());

			}

			Unit host = CoreFactory.eINSTANCE.createUnit();
			host.setName(baseName + UNIT);
			referencingTopology.getUnits().add(host);

			Capability hostingCapability = CoreFactory.eINSTANCE
					.createCapability();
			hostingCapability.setName(HOSTING_CAPABILITY);
			hostingCapability.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
			host.getCapabilities().add(hostingCapability);

			Capability dependencyCapability = CoreFactory.eINSTANCE
					.createCapability();
			dependencyCapability.setName(DEPENDENCY_CAPABILITY);
			dependencyCapability
					.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			host.getCapabilities().add(dependencyCapability);

			final Resource referencingResource = scribbler
					.getResource(referencingFile.getFullPath());

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencingResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					referencingResource.getContents().add(referencingRoot);

					try {
						scribbler.save(true, monitor);
					} catch (EditModelException e) {
						e.printStackTrace();
					}
					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);
		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	private void setupReferencedTopology(String baseName)
			throws ExecutionException, EditModelException {

		IFile referencedFile = fragment.getTopology(baseName + TOPOLOGY);

		final IEditModelScribbler scribbler = new DeploymentTopologyDomain(
				referencedFile).createScribblerForWrite();

		try {

			final DeployCoreRoot referencedRoot = CoreFactory.eINSTANCE
					.createDeployCoreRoot();
			Topology referencedTopology = CoreFactory.eINSTANCE
					.createTopology();
			referencedTopology.setName(baseName + TOPOLOGY);
			referencedTopology.setNamespace(fragment.getQualifiedName());
			referencedRoot.setTopology(referencedTopology); 
			
			ContractProviderManager.INSTANCE.installContract(IdentityContractProvider.ID, referencedTopology);

			Unit referencedUnit = CoreFactory.eINSTANCE.createUnit();
			referencedUnit.setName(baseName + UNIT);
			referencedTopology.getUnits().add(referencedUnit);

			Requirement requirement = CoreFactory.eINSTANCE.createRequirement();
			requirement.setName(REQUIREMENT1);
			requirement.setDmoEType(CorePackage.Literals.CAPABILITY);
			requirement.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
			referencedUnit.getRequirements().add(requirement);

			final Resource referencedResource = scribbler
					.getResource(referencedFile.getFullPath());

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencedResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					referencedResource.getContents().add(referencedRoot);

					try {
						scribbler.save(true, monitor);
					} catch (EditModelException e) {
						e.printStackTrace();
					}
					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);
		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		if (project.exists())
			project.delete(true, new NullProgressMonitor());
	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testCreateHostingLinkTargingReferencedTopology()
			throws Exception {

		IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			final Unit referencingUnit = (Unit) referencingTopology
					.resolve(REFERENCING_UNIT);

			// com.acme.ReferencedTopology:/ReferencedUnit
			String referencedUnitPath = createPath(REFERENCED);

			// The Critical Line
			Unit referencedUnit = (Unit) referencingTopology
					.resolve(referencedUnitPath);

			final HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
			link.setTarget(referencedUnit);

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencingResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					// Should construct correct Path URI for target in
					// referenced Topology
					referencingUnit.getHostingLinks().add(link);

					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);

			assertEquals(EXPECTED_PATH, link.getTargetURI());

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testResolveHostingLinkHostAndHosted() throws Exception {

		IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			final Unit referencingUnit = (Unit) referencingTopology
					.resolve(REFERENCING_UNIT);

			// com.acme.ReferencedTopology:/ReferencedUnit
			String referencedUnitPath = createPath(REFERENCED);

			// The Critical Line
			Unit referencedUnit = (Unit) referencingTopology
					.resolve(referencedUnitPath);

			final HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
			link.setTarget(referencedUnit);

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencingResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					// Should construct correct Path URI for target in
					// referenced Topology
					referencingUnit.getHostingLinks().add(link);

					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);

			assertEquals(EXPECTED_PATH, link.getTargetURI());

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}

		scribbler = referencingDomain.createScribblerForRead();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			final Unit referencingUnit = (Unit) referencingTopology
					.resolve(REFERENCING_UNIT);

			// com.acme.ReferencedTopology:/ReferencedUnit
			String referencedUnitPath = createPath(REFERENCED);

			// The Critical Line
			Unit referencedUnit = (Unit) referencingTopology
					.resolve(referencedUnitPath);

			List links = referencingUnit.getHostingLinks();
			assertEquals(1, links.size());

			HostingLink hLink = (HostingLink) links.get(0);

			assertTrue(hLink.getHost() == referencingUnit);
			assertTrue(hLink.getHosted() == referencedUnit);

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testFetchTopology() throws Exception {

		IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			final Unit referencingUnit = (Unit) referencingTopology
					.resolve(REFERENCING_UNIT);

			List imports = referencingTopology.getImports();
			Import firstImport = (Import) imports.get(0);

			for (Iterator iterator = imports.iterator(); iterator.hasNext();) {
				Import imported = (Import) iterator.next();
				List proxies = imported.getInstanceConfiguration()
						.getPublicUnits();

				assertEquals(1, proxies.size());

				Unit unit = (Unit) proxies.get(0);
				int indexOf = imported.getPattern().indexOf(TOPOLOGY);

				assertEquals(
						imported.getPattern().substring(0, indexOf) + UNIT,
						unit.getName());
			}

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testCreateHostingLinkFromAndTargingReferencedTopology()
			throws Exception {

		IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			// com.acme.ReferencedTopology:/ReferencedUnit
			String referencedUnitPath = createPath(REFERENCED);

			// com.acme.Referenced2Topology:/Referenced2Unit
			String referenced2UnitPath = createPath(REFERENCED2);

			final Unit sourceUnit = (Unit) referencingTopology
					.resolve(referencedUnitPath);

			Unit targetUnit = (Unit) referencingTopology
					.resolve(referenced2UnitPath);

			final HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
			link.setTarget(targetUnit);

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencingResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					// Should construct correct Path URI for target in
					// referenced Topology
					sourceUnit.getHostingLinks().add(link);

					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);

			assertEquals(createPath(REFERENCED), link.getSourceURI());
			assertEquals(createPath(REFERENCED2), link.getTargetURI());

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	/**
	 * Create an instance of FooImpl, and ovearride its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testCreateAndFindDependencyLink() throws Exception {

		IEditModelScribbler scribbler = referencingDomain
				.createScribblerForWrite();
		try {
			Resource referencingResource = scribbler
					.getResource(referencingDomain.getTopologyResource());
			DeployCoreRoot referencingRoot = (DeployCoreRoot) referencingResource
					.getContents().get(0);
			Topology referencingTopology = referencingRoot.getTopology();

			// com.acme.ReferencedTopology:/ReferencedUnit
			String referencedUnitPath = createPath(REFERENCED);
			Unit importedUnit = (Unit) referencingTopology
					.resolve(referencedUnitPath);
			final Requirement sourceRequirement = (Requirement) importedUnit
					.getRequirements().get(0);
			assertNotNull(sourceRequirement);
			assertTrue(Proxy.isProxyClass(sourceRequirement.getClass()));

			Unit targetUnit = (Unit) referencingTopology
					.resolve(createPath(REFERENCING));
			Capability targetCapability = (Capability) targetUnit
					.getCapabilities().get(0);
			assertNotNull(targetCapability);

			final DependencyLink link = CoreFactory.eINSTANCE
					.createDependencyLink();
			link.setTarget(targetCapability);

			new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(referencingResource), "Run Operation") {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					// Should construct correct Path URI for target in
					// referenced Topology
					sourceRequirement.setLink(link);

					return Status.OK_STATUS;
				}
			}.execute(new NullProgressMonitor(), null);

			assertEquals(
					"com.acme.ReferencedTopology:/ReferencedUnit/Requirement1",
					link.getSourceURI());

			// com.acme.ReferencingTopology:/ReferencingUnit
			assertEquals("/ReferencingUnit/HostingCapability", link
					.getTargetURI());

		} finally {
			if (scribbler != null)
				scribbler.close(new NullProgressMonitor());
		}
	}

	// Add unit test for eResource() returning importing resource for a Proxy

	// Add unit test for creation of realization link

	protected String createPath(String unit) {
		return fragment.getQualifiedName() + IConstants.DOT_SEPARATOR + unit
				+ TOPOLOGY + IConstants.TOPOLOGY_SEPARATOR
				+ IConstants.PATH_SEPARATOR + unit + UNIT;
	}

}
