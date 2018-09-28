/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.test.provider.JUnitObjectPathReference;
import com.ibm.ccl.soa.deploy.core.test.provider.JUnitTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.test.provider.JUnitTopologyProvider;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployReporter;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorAdapter;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.internal.emfworkbench.TransactionEMFWorkbenchContext.SmartTransactionEditingDomainFactory;

/**
 * Extends {@link TestCase} with SOA topology-specific utilities.
 */
public class TopologyTestCase extends TestCase {

	/** Standard name of topologies source folder. */
	public static final String TOPOLOGIES_FOLDER = "topologies"; //$NON-NLS-1$

	/** Temporary project for storing unit-test IFiles */
	private IProject project;

	/** Topologies source folder in {@link #project}. */
	private INamespaceFragmentRoot topologiesRoot;

	/** Controls deletion of the project. */
	private boolean deleteProjectOnTearDown = true;

	/**
	 * Key for
	 * {@link DeployValidatorService#getValidatorService(Object)         
	 */
	public static final String SHARED_VALIDATION_SERVICE = "TopologyTestCaseValidationService";

	protected IEditModelScribbler scribbler = null;

	/**
	 * Construct a topology test case (setup creates project).
	 * 
	 * @param name
	 *            the name of the project.
	 */
	public TopologyTestCase(String name) {
		super(name);

		try {
			assert false;
			System.err.println("Warning: " + getClass().getName()
					+ ": assertions are not enabled in Java VM");
		} catch (AssertionError e) {
			// ok
		}
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		SmartTransactionEditingDomainFactory.INSTANCE.setTestingMode(false);

		ResourcesPlugin.getWorkspace().run(
				new IWorkspaceRunnable() {

					public void run(IProgressMonitor monitor)
							throws CoreException {

						// Create Eclipse project
						project = ResourcesPlugin.getWorkspace().getRoot()
								.getProject(getName());
						project.delete(true, true, monitor);
						project.create(monitor);
						project.open(monitor);

						// Create topologies source folder
						topologiesRoot = NamespaceCore.createRoot(project
								.getFolder(TOPOLOGIES_FOLDER), monitor);
						INamespaceFragment fragment = topologiesRoot
								.getNamespaceFragment(getName());
						if (!fragment.exists()) {
							fragment.create(monitor);
						}
					}
				},
				ResourcesPlugin.getWorkspace().getRoot(),
				IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE
						| IResource.FORCE, new NullProgressMonitor());

		scribbler = IEditModelFactory.eINSTANCE.createScribbler(project,
				getName(), new DefaultScribblerDomain() {

					public String getEditModelLabel() {
						return TopologyTestCase.this.getName();
					}

					public IResourceDescriptor[] getResourceDescriptors() {
						return new IResourceDescriptor[0];
					}
				}, false);
	}

	/*
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		if (deleteProjectOnTearDown) {

			ResourceSet set = WorkbenchResourceHelper.getResourceSet(project);

			IStatus result = new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(set), "Close Resources") {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {

					try {
						scribbler.close(null);
					} catch (EditModelException e) {
						return DeployCorePlugin.createErrorStatus(0, e
								.getMessage(), e);
					}
					scribbler = null;
					return Status.OK_STATUS;
				}

			}.execute(null, null);

			assertTrue(result.isOK());

			ResourcesPlugin.getWorkspace().run(
					new IWorkspaceRunnable() {

						public void run(IProgressMonitor monitor)
								throws CoreException {
							project.delete(true, true, null);
						}
					},
					ResourcesPlugin.getWorkspace().getRoot(),
					IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE
							| IResource.FORCE, new NullProgressMonitor());

		}
	}

	/**
	 * @return the project created in the {@link #setUp()} method.
	 */
	protected IProject getProject() {
		return project;
	}

	/**
	 * Configures the test case to delete the project when {@link #tearDown()}
	 * is invoked.
	 * 
	 * @param deleteOnTearDown
	 *            true if the project should be deleted, false otherwise.
	 */
	protected void setDeleteProjectOnTearDown(boolean deleteOnTearDown) {
		this.deleteProjectOnTearDown = deleteOnTearDown;
	}

	/**
	 * Creates an empty topology associated with an Eclipse resource on a null
	 * namespace.
	 * <p>
	 * The topology file is created in the topology source folder of the test
	 * case's project ({@link #getProject()}). The null namespace is used.
	 * 
	 * 
	 * @param name
	 *            the name used for the topology and the resource URI (if it
	 *            contains a '.' character, the prefix will be treated as the
	 *            namespace).
	 * @param save
	 *            true if the resource should be saved.
	 * 
	 * @throws IOException
	 *             if the save fails.
	 * 
	 * @return the Topology object.
	 * @see #createTopology(String, String, boolean)
	 */
	protected Topology createTopology(String name, boolean save)
			throws IOException {
		if (name == null)
			name = "" + System.currentTimeMillis();
		int dotIndex = name.lastIndexOf(IConstants.DOT_SEPARATOR);
		String namespace = null;
		if (dotIndex != -1) {
			namespace = name.substring(0, dotIndex);
			name = name.substring(dotIndex + 1);
		}
		return createTopology(name, namespace, save);
	}

	/**
	 * Returns the URI corresponding to the topology name and namespace in the
	 * local test project.
	 * 
	 * @param name
	 *            the topology name.
	 * @param namespace
	 *            the topology namespace.
	 * @return the test project URI for the topology name and namespace.
	 * @see #getProject()
	 * @see Topology#getName()
	 * @see Topology#getNamespace()
	 */
	protected URI getURI(String name, String namespace) {
		assert name.indexOf(IConstants.DOT_SEPARATOR) == -1;
		String fullPath = getName() + '/' + TOPOLOGIES_FOLDER + '/';
		if (namespace != null) {
			fullPath += namespace.replace(IConstants.DOT_SEPARATOR, '/') + '/';
		}
		fullPath += name + ".topology";
		return URI.createPlatformResourceURI(fullPath);
	}

	/**
	 * Creates an empty topology associated with an Eclipse resource on a null
	 * namespace.
	 * <p>
	 * The topology file is created in the topology source folder of the test
	 * case's project ({@link #getProject()}). The null namespace is used.
	 * 
	 * 
	 * @param name
	 *            the name used for the topology and the resource URI.
	 * @param save
	 *            true if the resource should be saved.
	 * 
	 * @throws IOException
	 *             if the save fails.
	 * 
	 * @return the Topology object.
	 */
	protected Topology createTopology(String name, String namespace,
			boolean save) throws IOException {
		assert name.indexOf(IConstants.DOT_SEPARATOR) == -1;
		URI uri = getURI(name, namespace);
		Resource res = scribbler.getResource(uri);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		res.getContents().add(root);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName(name);
		top.setNamespace(namespace);
		root.setTopology(top);

		if (save) {
			res.save(null);
		}
		return top;
	}

	/**
	 * Loads a topology from the URL provided.
	 * 
	 * @param url
	 *            the URL to the topology file.
	 * @return the topology file.
	 */
	protected Topology loadTopology(String url) throws IOException {
		URI templateURI = URI.createURI(url);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);
		if ((resource == null) || (resource.getContents() == null)
				|| (resource.getContents().isEmpty())) {
			return null;
		}

		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		if (root == null) {
			return null;
		}
		return root.getTopology();
	}

	/**
	 * Copies a saved topology from its resource.
	 * 
	 * @param source
	 *            the saved source topology.
	 * @param targetName
	 *            the target topology name.
	 * @param targetNamespace
	 *            the target topology namespace (may be null).
	 * @return the topology file.
	 */
	protected Topology copyTopology(Topology source, String targetName,
			String targetNamespace) throws IOException {
		if (source == null || source.eResource() == null) {
			return null;
		}
		return copyTopology(source.eResource().getURI().toString(), targetName,
				targetNamespace);
	}
	
	/**
	 * Copies a saved topology from its resource.
	 * 
	 * @param sourceURL
	 *            the URL to an existing topology file.
	 * @param targetName
	 *            the target topology name.
	 * @param targetNamespace
	 *            the target topology namespace (may be null).
	 * @return the topology file.
	 */
	protected Topology copyTopology(String sourceURL, String targetName,
			String targetNamespace) throws IOException {
		if (sourceURL == null) {
			return null;
		}
		//
		// Read source
		//
		URI templateURI = URI.createURI(sourceURL);
		Resource sourceRes = JEMUtilPlugin.getPluginResourceSet().getResource(
				templateURI, true);
		if ((sourceRes == null) || (sourceRes.getContents() == null)
				|| (sourceRes.getContents().isEmpty())) {
			return null;
		}
		DeployCoreRoot root = (DeployCoreRoot) sourceRes.getContents().get(0);
		if (root == null) {
			return null;
		}

		//
		// Write target
		//
		assert targetName.indexOf(IConstants.DOT_SEPARATOR) == -1;
		URI targetURI = getURI(targetName, targetNamespace);
		Resource targetRes = scribbler.getResource(targetURI);
		sourceRes.getContents().remove(root);
		targetRes.getContents().add(root);
		targetRes.save(null);
		sourceRes.unload();
		targetRes.unload();
		targetRes.load(null);
		
		Topology copy = getTopology(targetRes);
		copy.setName(targetName);
		copy.setNamespace(targetNamespace);
		save(copy);
		return copy;
	}

	/**
	 * Returns the topology stored in the resource.
	 * 
	 * @param res
	 *            an EMF resource.
	 * @return the topology contained in the resource.
	 */
	protected Topology getTopology(Resource res) {
		assertTrue(res.getContents().size() == 1);
		DeployCoreRoot root = (DeployCoreRoot) res.getContents().get(0);
		assertNotNull(root);
		assertNotNull(root.getTopology());
		return root.getTopology();
	}

	/**
	 * Creates an empty saved topology associated with an Eclipse resource, and
	 * a GMF editing domain.
	 * <p>
	 * All changes to the topology must be performed in a write transaction
	 * using {@link #executeEditOperation(Runnable)}
	 * 
	 * @param name
	 *            the name used for the topology and the resource URI.
	 * 
	 * @throws IOException
	 *             if the save fails.
	 * 
	 * @return the Topology object.
	 */
	protected Topology createTopologyInEditingDomain(String name)
			throws IOException {
		Topology top = createTopology(name, true);
		Resource res = top.getEObject().eResource();
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(res
				.getResourceSet());
		return top;
	}

	/**
	 * Unloads a topology in an editing domain safe way.
	 * 
	 * @param top
	 *            a topology to be unloaded.
	 * @return the result of the unload operation.
	 */
	protected IStatus unloadTopologyInEditingDomain(final Topology top) {
		return executeEditOperation(top, new Runnable() {
			public void run() {
				top.eResource().unload();
			}
		});
	}

	/**
	 * Executes the runnable in editing domain of the topology
	 * 
	 * @param topology
	 *            the topology whose editing domain will be used.
	 * @param opepration
	 *            the operation to be executed.
	 */
	protected IStatus executeEditOperation(Topology topology,
			final Runnable operation) {
		return executeEditOperation(topology, topology.getName(), operation);
	}

	/**
	 * Executes the runnable in editing domain of the topology
	 * 
	 * @param object
	 *            the EObject whose editing domain will be used.
	 * @param name
	 *            the name of the EMF operation.
	 * @param opepration
	 *            the operation to be executed.
	 */
	protected IStatus executeEditOperation(EObject object, String name,
			final Runnable operation) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(object);
		if (editingDomain == null) {
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE
					.createEditingDomain();
		}
		AbstractEMFOperation emfOperation = new AbstractEMFOperation(
				editingDomain, name) {

			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) {
				try {
					operation.run();
					return Status.OK_STATUS;
				} catch (Throwable e) {
					e.printStackTrace();
					return new Status(IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID, 0, "Operation error: "
									+ e.getMessage(), e);
				}
			}
		};

		try {
			return OperationHistoryFactory.getOperationHistory().execute(
					emfOperation, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					"Operation error: " + e.getMessage(), e);
		}
	}

	/**
	 * Creates an empty topology associated with an Eclipse resource.
	 * <p>
	 * <strong>Note</strong>: the topology resource <em>is not saved</em>.
	 * 
	 * @param name
	 *            the name used for the topology and the resource URI (if it
	 *            contains a '.' character, the prefix will be treated as the
	 *            namespace).
	 * 
	 * @return the Topology object.
	 */
	protected Topology createTopology(String name) {
		try {
			return createTopology(name, false);
		} catch (IOException e) {
			// should not happen since we did not save
			throw new RuntimeException(e);
		}
	}

	/**
	 * Configures the monitoring on the topology to be blocking.
	 * <p>
	 * Normally, validation is performed asynchronously. For testing purposes,
	 * it is useful to switch it to blocking mode in order to assert that an
	 * error message has been created.
	 * 
	 * @param top
	 *            a topology that has been monitored.
	 * @param blocking
	 *            true if the monitor should block.
	 * 
	 * @exception IllegalArgumentException
	 *                if the topology has not been monitored.
	 * 
	 * @see DeployValidatorService#monitor(Topology, long, boolean)
	 */
	protected void setValidationMonitorBlocking(Topology top, boolean blocking) {
		boolean found = false;
		for (Iterator iter = top.getEObject().eAdapters().iterator(); iter
				.hasNext();) {
			Adapter adapter = (Adapter) iter.next();
			if (adapter instanceof DeployValidatorAdapter) {
				((DeployValidatorAdapter) adapter).setBlocking(blocking);
				found = true;
			}
		}
		if (!found) {
			throw new IllegalArgumentException("Topoloy \"" + top.getName()
					+ "\" is not monitored");
		}
	}

	/**
	 * Returns a iterator of all deploy status objects associated wit the
	 * object.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @return Iterator<IDeployStatus>
	 */
	protected Iterator findDeployStatus(DeployModelObject object) {
		return new FilterIterator(new StatusIterator(object),
				StatusIterator.DEPLOY_STATUS_FILTER);
	}

	/**
	 * Asserts that the object has count status objects of the specified marker
	 * type and problem type.
	 * 
	 * @param object
	 *            the deploy model object (may not be null).
	 * @param markerType
	 *            the marker type (may be null to ignore).
	 * @param problemType
	 *            the problem type (may be null to ignore).
	 * @param count
	 *            the number of status instances found (-1 for greater than 0)
	 * 
	 * @throws CoreException
	 *             if the marker on the status cannot be accessed.
	 * @deprecated use
	 *             {@link #assertHasDeployStatus(DeployModelObject, String, int)}
	 */
	protected void assertHasStatus(DeployModelObject object, String markerType,
			String problemType, int count) throws CoreException {
		int found = 0;
		StringBuffer markerDescriptions = new StringBuffer();
		for (Iterator iter = findDeployStatus(object); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if ((markerType != null)
					&& (!status.getMarker().isSubtypeOf(markerType))) {
				continue;
			}

			if ((problemType != null)
					&& (!problemType.equals(DeployMarker.getProblemType(status
							.getMarker())))) {
				continue;
			}

			if (markerDescriptions.length() > 0) {
				markerDescriptions.append('\n');
			}
			markerDescriptions
					.append(DeployMarker.toString(status.getMarker()));

			found++;
		}

		if (count < 0) {
			assert found > 0 : object.getName()
					+ " does not have required status";
		} else {
			assert found == count : object.getName() + " has " + found
					+ " required status; expected " + count + ":\n"
					+ markerDescriptions;
		}
	}

	/**
	 * Asserts that the values contained in the found array exactly the ones
	 * contained in the expected array, without considering order.
	 * <p>
	 * Equality is determined using Object.equals()
	 * 
	 * @param found
	 *            the found values.
	 * @param expected
	 *            the expected values.
	 */
	protected void assertSetEquals(Object[] found, Object[] expected) {
		assertSetEquals(Arrays.asList(found).iterator(), expected);
	}

	/**
	 * Asserts that the values returned by the collection iterator are exactly
	 * the ones contained in the array, without considering order.
	 * <p>
	 * Equality is determined using Object.equals()
	 * 
	 * @param c
	 *            a collection whose elements will be iterated over.
	 * @param values
	 *            the values returned by the iterator, independent of order (may
	 *            be null).
	 */
	public void assertSetEquals(Collection c, Object[] values) {
		assertSetEquals(c.iterator(), values);
	}

	/**
	 * Asserts that the values returned by the iterator are exactly the ones
	 * contained in the array, without considering order.
	 * <p>
	 * Equality is determined using Object.equals()
	 * 
	 * @param iter
	 *            an iterator over objects.
	 * @param values
	 *            the values returned by the iterator, independent of order (may
	 *            be null).
	 */
	protected void assertSetEquals(Iterator iter, Object[] values) {
		StringBuffer errors = new StringBuffer();
		Set set;
		if ((values == null) || (values.length == 0)) {
			set = Collections.EMPTY_SET;
		} else {
			set = new LinkedHashSet();
			for (int i = 0; i < values.length; i++) {
				set.add(values[i]);
			}
		}

		// Unexpected values
		int unexpectedCount = 0;
		while (iter.hasNext()) {
			Object value = iter.next();
			if (!set.remove(value)) {
				unexpectedCount++;
				if (errors.length() > 0) {
					errors.append("\n");
				}
				errors.append("Unexpected value: ");
				errors.append(value);
			}
		}

		// Missing values
		int missingCount = 0;
		if (set.size() != 0) {
			for (Iterator iter2 = set.iterator(); iter2.hasNext();) {
				Object value = iter2.next();
				missingCount++;
				if (errors.length() > 0) {
					errors.append("\n");
				}
				errors.append("Missing value: ");
				errors.append(value);
			}
		}
		if (errors.length() > 0) {
			throw new AssertionFailedError("Set equality error(s): "
					+ unexpectedCount + " unexpected values, and "
					+ missingCount + " missing values:\n" + errors.toString());
		}
	}

	/**
	 * Asserts that the list contains the same values as the array.
	 * <p>
	 * Equality is determined using Object.equals()
	 * 
	 * @param list
	 *            a list of objects (may be null).
	 * @param values
	 *            the values returned by the iterator, independent of order (may
	 *            be null).
	 */
	protected void assertListEquals(List<?> list, Object[] values) {
		int listSize = 0;
		if (list != null) {
			listSize = list.size();
		}
		int valuesSize = 0;
		if (values != null) {
			valuesSize = values.length;
		}
		assertEquals(valuesSize, listSize);
		if (listSize == 0) {
			return;
		}
		int i = 0;
		for (Object obj : list) {
			assertEquals("List[" + i + "]=" + values[i] + " != " + obj,
					values[i], obj);
			i++;
		}
	}

	/**
	 * Asserts that the iterator returns the same values as those contained in
	 * the array.
	 * <p>
	 * Equality is determined using Object.equals()
	 * 
	 * @param iter
	 *            an iterator over objects (may be null).
	 * @param values
	 *            the values returned by the iterator, independent of order (may
	 *            be null).
	 */
	protected void assertListEquals(Iterator<?> iter, Object[] values) {
		if ((iter == null) || (!iter.hasNext())) {
			if (values != null) {
				assertEquals(values.length, 0);
			}
			return;
		}

		int i = 0;
		while (iter.hasNext()) {
			Object obj = iter.next();
			assertTrue("Iterator returned additional value = " + obj,
					i < values.length);
			assertEquals("Iterator[" + i + "]=" + values[i] + " != " + obj,
					values[i], obj);
			i++;
		}
	}

	/**
	 * Creates a validation context for the topology.
	 * 
	 * @param topology
	 *            the topology to be validated
	 * @return the created context.
	 */
	protected IDeployValidationContext createValidationContext(Topology topology) {
		return new DeployValidationContext(topology, null, null);
	}

	/**
	 * Creates a resolution context.
	 * 
	 * @param status
	 *            the resolution status.
	 * @return the resolution context
	 */
	protected IDeployResolutionContext createResolutionContext(
			IDeployStatus status) {
		return new DeployResolutionContext(status, getValidatorService(),
				new NullProgressMonitor());
	}

	/**
	 * Asserts that the iterator returns the specified value.
	 * 
	 * @param iter
	 *            an iterator.
	 * @param value
	 *            the expected value.
	 */
	public void assertContains(Iterator iter, Object value) {
		while (iter.hasNext()) {
			Object cur = iter.next();
			if (ValidatorUtils.equals(cur, value)) {
				return;
			}
		}
		assert false : "Does not contain value=" + value;
	}

	/**
	 * Asserts that the arary contains the specified value.
	 * 
	 * @param array
	 *            an array of values.
	 * @param value
	 *            the expected value.
	 */
	public void assertContains(Object[] array, Object value) {
		for (int i = 0; i < array.length; i++) {
			if (ValidatorUtils.equals(array[i], value)) {
				return;
			}
		}
		assert false : "Does not contain value=" + value;
	}

	/**
	 * Creates a deploy message reporter.
	 * 
	 * @return the reporter.
	 */
	protected IDeployReporter createDeployReporter() {
		return createDeployReporter(true);
	}

	/**
	 * Creates a deploy message reporter which creates markers.
	 * 
	 * @param createMarkers
	 *            true if markers should be created.
	 * @return the reporter.
	 */
	protected IDeployReporter createDeployReporter(boolean createMarkers) {
		return new DeployReporter(createMarkers);
	}

	/**
	 * Asserts that a {@link DeployMarker} of the specified problem type exists
	 * for the object.
	 * 
	 * @param markers
	 *            the markers on the topology of the object.
	 * @param type
	 *            the {@link IDeployMarker#PROBLEM_TYPE} marker attribute value.
	 * @param objectID
	 *            the {@link DeployMarker#OBJECT_ID} marker attribute value.
	 */
	protected void assertMarkerExists(IMarker[] markers, String type,
			String objectID) {
		assert type != null;
		assert objectID != null;
		try {
			for (int i = 0; i < markers.length; i++) {
				if (type.equals(markers[i]
						.getAttribute(IDeployMarker.PROBLEM_TYPE))) {
					if (objectID.equals(markers[i]
							.getAttribute(DeployMarker.OBJECT_ID))) {
						return;
					}
				}
			}

			assert false : "No DeployObjectMarker of problem type=" + type
					+ " found on objectID=" + objectID;
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Asserts that the topology validates with no errors.
	 * 
	 * @param topology
	 *            a topology to be validated.
	 */
	protected void assertNoValidationErrors(Topology topology) throws Exception {
		DeployValidatorService service = getValidatorService();
		service.validate(topology);
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = topology.findAllDeployModelObjects(); iter
				.hasNext();) {
			DeployModelObject object = (DeployModelObject) iter.next();
			if (object.getStatus().getSeverity() == IStatus.ERROR) {
				if (buffer.length() > 0) {
					buffer.append('\n');
				}
				buffer.append(getString(object.getStatus()));
			}
		}
		assert buffer.length() == 0 : buffer.toString();
	}

	/**
	 * Dumps the contents of the topology resource.
	 * 
	 * @param top
	 *            a saved topology.
	 */
	protected void dumpResource(Topology top) {
		dumpResource(WorkbenchResourceHelper.getFile(top));
	}

	/**
	 * Dumps the contents of the Eclipse file resource.
	 * 
	 * @param file
	 *            a file Eclipse resource.
	 */
	protected void dumpResource(IFile file) {
		if (file == null) {
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					file.getContents()));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Debugging utility method that dumps all deployment markers into
	 * System.out.
	 * 
	 * @param top
	 *            the topology whose markers are printed.
	 * 
	 * @throws CoreException
	 *             if the markers could not be retrieved.
	 */
	protected String dumpMarkers(Topology top) throws CoreException {
		StringBuffer buffer = new StringBuffer();
		IMarker[] markers = DeployMarker.getInstances(top);
		buffer.append("--- Marker dump [size=" + markers.length
				+ "] ----------------------------");
		buffer.append('\n');
		for (int i = 0; i < markers.length; i++) {
			buffer.append("[");
			buffer.append(i);
			buffer.append("] ");
			buffer.append(DeployMarker.toString(markers[i]));
			buffer.append('\n');
		}
		System.out.println(buffer);
		return buffer.toString();
	}

	/**
	 * Debugging utility method that dumps all status markers on the topology
	 * (recursive) to System.out, and returns them.
	 * 
	 * @param top
	 *            the topology whose status are printed.
	 * @return the appended status messages on all
	 *         {@link Topology#findAllDeployModelObjects()}.
	 */
	protected String dumpStatus(Topology top) {
		String result = getStatusDescription(top);
		System.out.println(result);
		return result;
	}

	/**
	 * Returns a string describing all the statuses on the topology (recursive).
	 * 
	 * @param top
	 *            a deployment topology.
	 * @return a string description of all statuses on the topology and all its
	 *         contained objects (recursive).
	 */
	protected String getStatusDescription(Topology top) {
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iter.next();
			if (dmo.getStatus() != Status.OK_STATUS) {
				for (Iterator iter2 = new StatusIterator(dmo.getStatus()); iter2
						.hasNext();) {
					IStatus status = (IStatus) iter2.next();
					if (status instanceof MultiStatus) {
						continue;
					}
					if (buffer.length() > 0) {
						buffer.append('\n');
						buffer.append('\n');
					}
					if (status instanceof IDeployStatus) {
						IDeployStatus deployStatus = (IDeployStatus) status;
						buffer.append(getString(deployStatus));
					} else {
						if ((status.getMessage() == null)
								|| (status.getMessage().trim().length() == 0)) {
							buffer.append(status);
						} else {
							buffer.append(status.getMessage());
						}
					}
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * Saves the topology contents in its resource.
	 * 
	 * @param top
	 *            a topology.
	 */
	public void save(Topology top) throws IOException {
		if (top != null) {
			top.eResource().save(null);
		}
	}

	/**
	 * Unloads the topology resource, reloads and returns the new topology
	 * reference.
	 * 
	 * @param top
	 *            a topology to be unloaded (will before invalid).
	 * @param save
	 *            true if the topology should be saved before unloading.
	 * @return the reloaded topology (old reference will be invalidated).
	 * @exception IOException
	 *                if the resource could not be saved/reload.
	 */
	public Topology reload(Topology top, boolean save) throws IOException {
		Resource res = top.getEObject().eResource();
		if (save) {
			res.save(null);
		}
		res.unload();
		res.load(null);
		assert res.getErrors().size() == 0 : dumpResourceErrors(res);
		assert res.getWarnings().size() == 0 : dumpResourceWarnings(res);
		top = ((DeployCoreRoot) res.getContents().get(0)).getTopology();
		return top;
	}

	/**
	 * Dumps the errors in the {@link Resource}
	 * 
	 * @param res
	 *            an EMF resource.
	 * @return the errors (never null).
	 * @see Resource#getErrors()
	 */
	protected String dumpResourceErrors(Resource res) {
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = res.getErrors().iterator(); iter.hasNext();) {
			Resource.Diagnostic error = (Resource.Diagnostic) iter.next();
			if (buffer.length() > 0) {
				buffer.append('\n');
			}
			buffer.append(error.getMessage());
			buffer.append(':');
			buffer.append(error.getLine());
		}
		String result = buffer.toString();
		System.out.println(result);
		return result;
	}

	/**
	 * Dumps the warnings in the {@link Resource}
	 * 
	 * @param res
	 *            an EMF resource.
	 * @return the errors (never null).
	 * @see Resource#getWarnings()
	 */
	protected String dumpResourceWarnings(Resource res) {
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = res.getWarnings().iterator(); iter.hasNext();) {
			Resource.Diagnostic error = (Resource.Diagnostic) iter.next();
			if (buffer.length() > 0) {
				buffer.append('\n');
			}
			buffer.append(error.getMessage());
			buffer.append(':');
			buffer.append(error.getLine());
		}
		String result = buffer.toString();
		System.out.println(result);
		return result;
	}

	/**
	 * Returns a string representation of the status.
	 * 
	 * @param status
	 *            a status whose string representation should be returned.
	 */
	protected String getString(IStatus status) {
		return getString(status, IStatus.INFO | IStatus.WARNING | IStatus.ERROR);
	}

	/**
	 * Returns a string representation of the status.
	 * 
	 * @param status
	 *            a status whose string representation should be returned.
	 * @param severityMask
	 *            the mask of status severity to be returned (see
	 *            {@link IStatus#matches(int)}).
	 */
	protected String getString(IStatus status, int severityMask) {
		if (!status.matches(severityMask)) {
			return "";
		}
		if (!status.isMultiStatus()) {
			if (status instanceof IDeployStatus) {
				return getString((IDeployStatus) status);
			}
			return status.toString();
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("Multi-status: ");
		buffer.append(status.getMessage());
		IStatus[] children = status.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (!children[i].matches(severityMask)) {
				continue;
			}
			buffer.append('\n');
			buffer.append('\n');
			buffer.append('\t');
			if (children[i] instanceof IDeployStatus) {
				buffer.append(getString(children[i]));
			} else {
				buffer.append(children[i].toString());
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns a description of the deploy status.
	 * 
	 * @param status
	 *            a deploy status.
	 * @return a description of the status.
	 */
	protected String getString(IDeployStatus status) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("message=");
		buffer.append(status.getMessage());
		buffer.append("\n\tmessage-ttype=");
		buffer.append(status.getClass().getName());
		buffer.append("\n\tobject-type=");
		buffer.append(status.getDeployObject().eClass().getName());
		buffer.append("\n\tobject-name=");
		buffer.append(status.getDeployObject().getName());
		buffer.append("\n\tobject-path=");
		buffer.append(status.getDeployObject().getFullPath());
		buffer.append("\n\tseverity=");
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			buffer.append("ERROR");
			break;
		case IStatus.WARNING:
			buffer.append("WARNING");
			break;
		case IStatus.INFO:
			buffer.append("INFO");
			break;
		case IStatus.OK:
			buffer.append(status.getSeverity());
		}
		buffer.append("\n\tproblemType=");
		buffer.append(status.getProblemType());
		buffer.append("\n\tvalidatorID=");
		buffer.append(status.getValidatorID());
		if (status instanceof IDeployAttributeStatus) {
			buffer.append("\n\tattributeFullName=");
			buffer.append(((IDeployAttributeStatus) status).getAttributeName());
			if (status instanceof IDeployAttributeValueStatus) {
				buffer.append("\n\tattributeValue=");
				buffer.append(((IDeployAttributeValueStatus) status)
						.getAttributeExpectedValue());
			}
		}
		if (status instanceof IDeployWrapperStatus) {
			IDeployWrapperStatus wStatus = (IDeployWrapperStatus) status;
			if (wStatus.getWrappedStatus() != null) {
				buffer.append("\n\twrappedStatus=");
				String wStatusString = getString(wStatus.getWrappedStatus());
				BufferedReader reader = new BufferedReader(new StringReader(
						wStatusString));
				String line;
				try {
					while ((line = reader.readLine()) != null) {
						buffer.append("\n\t\t");
						buffer.append(line);
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * Asserts that the deploy model object has a status with the specified
	 * problem type and severity.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param problemType
	 *            the problem type (non-null)>
	 * @param severity
	 *            a valid value for {@link IStatus#getSeverity()}.
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasDeployStatus(DeployModelObject object,
			String problemType, int severity) {
		for (Iterator iter = new DeployStatusIterator(object); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if (severity == status.getSeverity()) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(
						object.getStatus()),
						StatusIterator.DEPLOY_STATUS_FILTER); iter2.hasNext();) {
					IDeployStatus dStatus = (IDeployStatus) iter2.next();
					if (problemType.equals(dStatus.getProblemType())) {
						return;
					}
				}
			}
		}

		assert false : "No status with severity=" + severity
				+ " and problem type=" + problemType + " found in:\n"
				+ getString(object.getStatus());
	}

	/**
	 * Asserts that the deploy model object has a deploy attribute status with
	 * the specified problem type and severity.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param problemType
	 *            the problem type (non-null)
	 * @param severity
	 *            a valid value for {@link IStatus#getSeverity()}.
	 * @param attribute
	 *            the {@link IDeployAttributeStatus#getAttributeType()}(non-null).
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasDeployAttributeStatus(DeployModelObject object,
			String problemType, int severity, EAttribute attribute) {
		for (Iterator iter = new DeployStatusIterator(object); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if (((problemType.equals(status.getProblemType()))
					&& (severity == status.getSeverity())
					&& (status instanceof IDeployAttributeStatus) && (attribute
					.equals(((IDeployAttributeStatus) status)
							.getAttributeType())))) {
				return;
			}
		}
		assert false : "No attribute status with severity=" + severity
				+ " and problem type=" + problemType + " on attribute "
				+ attribute.getName() + " found in:\n"
				+ getString(object.getStatus());
	}

	/**
	 * Asserts that the deploy model object has a {@link IDeployWrappedStatus}
	 * status wrapping a {@link IDeployAttribute} status with the specified
	 * problem type and severity.
	 * 
	 * @param wrapStatusObject
	 *            the object on which the wrapped status is found.
	 * @param attributeObject
	 *            a deploy model object of the attribute status.
	 * @param problemType
	 *            the problem type (non-null)
	 * @param severity
	 *            a valid value for {@link IStatus#getSeverity()}.
	 * @param attribute
	 *            the {@link IDeployAttributeStatus#getAttributeType()}(non-null).
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasWrappedDeployAttributeStatus(
			DeployModelObject wrapStatusObject,
			DeployModelObject attributeObject, String problemType,
			int severity, EAttribute attribute) {
		for (Iterator iter = new DeployStatusIterator(wrapStatusObject); iter
				.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if (status instanceof IDeployWrapperStatus) {
				IDeployStatus cStatus = ((IDeployWrapperStatus) status)
						.getWrappedStatus();
				if ((cStatus != null)
						&& (attributeObject.equals(cStatus.getDeployObject()))
						&& (problemType.equals(cStatus.getProblemType()))
						&& (severity == cStatus.getSeverity())
						&& (cStatus instanceof IDeployAttributeStatus)
						&& (attribute.equals(((IDeployAttributeStatus) cStatus)
								.getAttributeType()))) {
					return;
				}
			}
		}
		assert false : "No attribute status with severity=" + severity
				+ " and problem type=" + problemType + " on attribute "
				+ attribute.getName() + " was wrapped in in:\n"
				+ getString(wrapStatusObject.getStatus());
	}

	/**
	 * Asserts that the deploy model object has the specified status directly,
	 * or indirectly.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param status
	 *            a status that is directly or indirectly (child) contained.
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasDeployStatus(DeployModelObject object,
			IStatus status) {
		for (Iterator iter = new StatusIterator(object.getStatus()); iter
				.hasNext();) {
			IStatus curr = (IStatus) iter.next();
			if (curr == status) {
				return;
			}
		}

		assert false : "Object " + object.getName() + " does not have status "
				+ status + "\nfound:\n" + getString(object.getStatus());
	}

	/**
	 * Asserts that the deploy model object does <b>not</b> have the specified
	 * status directly, or indirectly.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param status
	 *            a status that should not be directly or indirectly (child)
	 *            contained.
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasNoDeployStatus(DeployModelObject object,
			IStatus status) {
		for (Iterator iter = new StatusIterator(object.getStatus()); iter
				.hasNext();) {
			IStatus curr = (IStatus) iter.next();
			assert curr != status : "Object " + object.getName()
					+ " has status " + status;
			return;
		}
	}

	/**
	 * Assert that the topology does not contain any objects with an
	 * {@link IStatus#ERROR} severity.
	 * 
	 * @param top
	 *            the topology checked.
	 */
	protected void assertHasNoErrorStatus(Topology top) {
		StringBuffer buffer = new StringBuffer();
		if (top.getStatus().getSeverity() == IStatus.ERROR) {
			buffer.append(getString(top.getStatus()));
		}
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				if (buffer.length() > 0) {
					buffer.append('\n');
				}
				buffer.append(getString(obj.getStatus()));
			}
		}
		if (buffer.length() > 0) {
			throw new AssertionError(
					"Topology has objects with ERROR status:\n" + buffer);
		}
	}

	/**
	 * Assert that the topology contains at least one object with an
	 * {@link IStatus#ERROR} severity status
	 * 
	 * @param top
	 *            the topology checked.
	 */
	protected void assertHasErrorStatus(Topology top) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				return;
			}
		}
		assert false : "no errors found in topology"; //$NON-NLS-1$
	}

	/**
	 * Assert that the topology contains at least one object with an
	 * {@link IStatus#ERROR} severity status with a specific problem type.
	 * 
	 * @param top
	 *            the topology checked.
	 * @param problemType
	 *            the type of the problem.
	 * @return the status found.
	 */
	protected IStatus assertHasErrorStatus(Topology top, String problemType) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IDeployStatus dStatus = (IDeployStatus) iter2.next();
					if (dStatus.getProblemType() == null) {
						if (problemType == null) {
							return dStatus;
						}
					} else if (dStatus.getProblemType().equals(problemType)) {
						return dStatus;
					}
				}
			}
		}
		String status = getStatusDescription(top);
		assert false : "no errors found in topology with problem type = " + problemType + (status.length() == 0 ? "" : "; found:\n" + status); //$NON-NLS-1$
		return null;
	}

	/**
	 * Assert that the topology contains at least one object with an severity
	 * severity status with a specific problem type.
	 * 
	 * @param top
	 *            the topology checked.
	 * @param problemType
	 *            the type of the problem.
	 */
	protected void assertHasStatus(Topology top, String problemType,
			int severity) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == severity) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IDeployStatus dStatus = (IDeployStatus) iter2.next();
					if (dStatus.getProblemType() == null) {
						if (problemType == null) {
							return;
						}
					} else if (dStatus.getProblemType().equals(problemType)) {
						return;
					}
				}
				// return;
			}
		}
		assert false : "no statuses of severity " + severity + " found in topology with problem type = " + problemType; //$NON-NLS-1$
	}

	/**
	 * Asserts that the deploy model object <em>does not</em> have status with
	 * the specified problem type.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param problemType
	 *            the problem type (non-null)>
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasNoErrorStatus(Topology top, String problemType) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IDeployStatus dStatus = (IDeployStatus) iter2.next();
					if (dStatus.getProblemType() != null) {
						assert (!dStatus.getProblemType().equals(problemType));
					}
				}
			}
		}
	}

	/**
	 * Asserts that the deploy model object <em>does not</em> have status with
	 * the specified problem type.
	 * 
	 * @param object
	 *            a deploy model object.
	 * @param problemType
	 *            the problem type (non-null)>
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	protected void assertHasNoDeployStatus(DeployModelObject object,
			String problemType, int severity) {
		// TODO provide cleaner implementation
		boolean error = false;
		try {
			assertHasDeployStatus(object, problemType, severity);
		} catch (AssertionError e) {
			error = true;
		}
		assert error : "found problem type=" + problemType
				+ " in object status:\n" + getString(object.getStatus());
	}

	/**
	 * Validates a unit using the unit validator.
	 * <p>
	 * Prior to validation all topology markers and status are cleared.
	 * 
	 * @param top
	 *            the topology of the unit.
	 * @param validator
	 *            the unit validator to be used.
	 * @param unit
	 *            the unit to be validated.
	 * @param context
	 *            the validation context.
	 * @param reporter
	 *            the validation status reporter.
	 * @return the unit status.
	 * @throws IOException
	 *             if markers cannot be cleared.
	 * @throws CoreException
	 *             if markers cannot be created.
	 */
	protected IStatus validateUnit(Topology top, UnitValidator validator,
			Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) throws IOException, CoreException {
		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		DeployValidatorAdapter.clearDeployNonPublisherStatus(top);
		assert unit.getStatus().getSeverity() == IStatus.OK;
		validator.validate(unit, context, reporter);
		// assert ldapUnit.getStatus().getSeverity() == IStatus.OK;
		IStatus status = unit.getStatus();
		dumpMarkers(top);
		return status;
	}

	/**
	 * Creates a hosting link and adds it to the host.
	 * 
	 * @param name
	 *            {@link HostingLink#setName(String)}
	 * @param host
	 *            {@link Unit#getHostingLinks()}
	 * @param hosted
	 *            {@link HostingLink#setHosted(Unit)}
	 * @return the hosting link created and added.
	 */
	protected HostingLink createHostingLink(String name, Unit host, Unit hosted) {
		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setName(name);
		link.setHosted(hosted);
		host.getHostingLinks().add(link);
		return link;
	}

	/**
	 * Creates a dependency link and sets it on the requirement.
	 * 
	 * @param name
	 *            {@link HostingLink#setName(String)}
	 * @param requirement
	 *            {@link Requirement#setLink(DependencyLink)}
	 * @param capability
	 *            {@link Capability}
	 * @return the dependency link created and set on the requirement.
	 */
	protected DependencyLink createDependencyLink(String name,
			Requirement requirement, Capability capability) {
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName(name);
		link.setTarget(capability);
		requirement.setLink(link);
		return link;
	}

	/**
	 * @return a shared copy of the deploy validator service.
	 */
	protected DeployValidatorService getValidatorService() {
		return DeployValidatorService.getDefaultValidatorService();
	}

	/**
	 * Blocking validation of the topology.
	 * 
	 * @param top
	 *            the topology to be validated.
	 */
	protected void validate(Topology top) {
		DeployValidatorService validator = getValidatorService();
		validator.validate(top);
	}

	/**
	 * Asserts that the {@link DeployValidatorService} does not return an
	 * instance of the domain validator type for the topology.
	 * 
	 * @param top
	 */
	protected void assertHasNoDomainValidator(Topology top, Class validatorType) {
		Collection<IDomainValidator> validators = getValidatorService()
				.getDomainValidators(top);
		for (IDomainValidator validator : validators) {
			assert !validatorType.isInstance(validator) : validator;

		}
	}

	/**
	 * Asserts that the {@link DeployValidatorService} returns an instance of
	 * the domain validator type for the topology.
	 * 
	 * @param top
	 */
	protected void assertHasDomainValidator(Topology top, Class validatorType) {
		Collection<IDomainValidator> validators = getValidatorService()
				.getDomainValidators(top);
		for (IDomainValidator validator : validators) {
			if (validatorType.isInstance(validator)) {
				// OK
				return;
			}
		}
		assert false : validatorType.getName()
				+ " not associated with topology";
	}

	/**
	 * Resolve a topology import to its topology.
	 * 
	 * @param i
	 *            a topology import.
	 * @return the topology object, or null if it cannot be resolved.
	 * 
	 * @see #getImportedObject(Topology, DeployModelObject)
	 */
	public Topology resolve(Import i) {
		return TopologyUtil.resolve(i);
	}

	/**
	 * Returns the imported view of a specified object in a topology.
	 * 
	 * @param top
	 *            the edit topology in whose context the view will be returned.
	 * @param object
	 *            a view of an object that was obtained outside of the context
	 *            of the current topology.
	 * @return the proxy object implementing the view.
	 * 
	 * @exception IllegalArgumentException
	 *                if the topology, or object are null, or the object is not
	 *                imported by the topology.
	 * 
	 * @see #getGlobalPath(DeployModelObject)
	 * @see Topology#resolve(String)
	 */
	protected <T extends DeployModelObject> T getImportedObject(Topology top,
			T object) throws IllegalArgumentException {
		if (top == null) {
			throw new IllegalArgumentException("null topology parameter");
		}
		if (object == null) {
			throw new IllegalArgumentException("null object parameter");
		}
		if (top.getImports().isEmpty()) {
			throw new IllegalArgumentException("topology " + top.getName()
					+ " does not have any imports");
		}
		if (object.getTopology() == top) {
			return object;
		}
		T result = (T) top.resolve(getGlobalPath(object));
		if (result == null) {
			throw new IllegalArgumentException("object " + object.getName()
					+ " not imported by topology " + top.getName());
		}
		return result;
	}

	/**
	 * Returns a path to the deploy model object including the topology
	 * namespace and name.
	 * 
	 * @param dmo
	 *            a deploy model object.
	 * @return a path to the object that can be resolved across topologies.
	 * @see DeployModelObjectUtil#getGlobalPath(DeployModelObject)
	 */
	public String getGlobalPath(DeployModelObject dmo) {
		return DeployModelObjectUtil.getGlobalPath(dmo);
	}

	/**
	 * Adds a unit to the topology.
	 * 
	 * @param top
	 *            the topology.
	 * @param name
	 *            the name of the unit.
	 * @return the unit created and added.
	 */
	protected Unit addUnit(Topology top, String name) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(name);
		top.getUnits().add(unit);
		return unit;
	}

	/**
	 * Adds a group unit to the topology.
	 * <p>
	 * The cardinality of the group is zero to any.
	 * 
	 * @param top
	 *            the topology.
	 * @param name
	 *            the name of the unit.
	 * @return the group unit created and added.
	 */
	protected Unit addGroupUnit(Topology top, String name) {
		return addGroupUnit(top, name, 0, -1);
	}

	/**
	 * Adds a group unit to the topology.
	 * 
	 * @param top
	 *            the topology.
	 * @param name
	 *            the name of the unit.
	 * @param min
	 *            minimum group cardinality.
	 * @param max
	 *            maximum group cardinality (-1 for unbounded).
	 * @return the group unit created and added.
	 */
	protected Unit addGroupUnit(Topology top, String name, int min, int max) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(name);
		top.getUnits().add(unit);
		Requirement req = addRequirement(unit, "memberReq",
				RequirementLinkTypes.MEMBER_LITERAL);

		MemberCardinalityConstraint mc = ConstraintFactory.eINSTANCE
				.createMemberCardinalityConstraint();
		mc.setName("mc");
		if (min > 0) {
			mc.setMinValue(Integer.toString(min));
		}
		if (max >= 0) {
			mc.setMaxValue(Integer.toString(max));
		}
		req.getConstraints().add(mc);
		assertTrue(unit.isGroup());

		return unit;
	}

	/**
	 * Adds a member unit to the topology.
	 * <p>
	 * The cardinality of the membership is zero to any.
	 * 
	 * @param top
	 *            the topology.
	 * @param name
	 *            the name of the unit.
	 * @return the member unit created and added.
	 */
	protected Unit addMemberUnit(Topology top, String name) {
		return addMemberUnit(top, name, 0, -1);
	}

	/**
	 * Adds a member unit to the topology.
	 * 
	 * @param top
	 *            the topology.
	 * @param name
	 *            the name of the unit.
	 * @param min
	 *            minimum membership cardinality.
	 * @param max
	 *            maximum membership cardinality (-1 for unbounded).
	 * @return the member unit created and added.
	 */
	protected Unit addMemberUnit(Topology top, String name, int min, int max) {
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName(name);
		top.getUnits().add(unit);
		Requirement req = addRequirement(unit, "memberReq",
				RequirementLinkTypes.MEMBER_LITERAL);

		GroupCardinalityConstraint gc = ConstraintFactory.eINSTANCE
				.createGroupCardinalityConstraint();
		gc.setName("gc");
		if (min > 0) {
			gc.setMinValue(Integer.toString(min));
		}
		if (max >= 0) {
			gc.setMaxValue(Integer.toString(max));
		}
		req.getConstraints().add(gc);
		assertFalse(unit.isGroup());

		return unit;
	}

	/**
	 * Add a requirement to the unit.
	 * 
	 * @param unit
	 *            the unit container.
	 * @param name
	 *            the requirement name.
	 * @param linkType
	 *            the requirement link type.
	 * @return the requirement created and added.
	 */
	protected Requirement addRequirement(Unit unit, String name,
			RequirementLinkTypes linkType) {
		return addRequirement(unit, name, null, linkType);
	}

	/**
	 * Add a requirement to the unit.
	 * 
	 * @param unit
	 *            the unit container.
	 * @param name
	 *            the requirement name.
	 * @param type
	 *            the requirement object type.
	 * @param linkType
	 *            the requirement link type.
	 * @return the requirement created and added.
	 */
	protected Requirement addRequirement(Unit unit, String name, EClass type,
			RequirementLinkTypes linkType) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName(name);
		req.setDmoEType(type);
		req.setLinkType(linkType);
		unit.getRequirements().add(req);
		return req;
	}

	/**
	 * Create a generic capability and add it to the unit.
	 * 
	 * @param unit
	 *            the capability container.
	 * @param name
	 *            the capability name.
	 * @param linkType
	 *            the capability link type
	 * @return the capability created and added.
	 */
	protected Capability addCapability(Unit unit, String name,
			CapabilityLinkTypes linkType) {
		return addCapability(unit, name, null, linkType);

	}

	/**
	 * Create a capability of the specified type and add it to the unit.
	 * 
	 * @param unit
	 *            the capability container.
	 * @param name
	 *            the capability name.
	 * @param type
	 *            the capability type (null = {@link Capability}).
	 * @param linkType
	 *            the capability link type
	 * @return the capability created and added.
	 */
	protected Capability addCapability(Unit unit, String name, EClass type,
			CapabilityLinkTypes linkType) {
		Capability cap;
		if (type == null) {
			cap = CoreFactory.eINSTANCE.createCapability();
		} else {
			cap = (Capability) type.getEPackage().getEFactoryInstance().create(
					type);
		}
		cap.setName(name);
		cap.setLinkType(linkType);
		unit.getCapabilities().add(cap);
		return cap;
	}

	/**
	 * Adds an extended attribute to the deploy object.
	 * 
	 * @param obj
	 *            the deploy object.
	 * @param name
	 *            the name of the attribute.
	 * @param type
	 *            the type of the attribute (e.g.
	 *            {@link XMLTypePackage.eINSTANCE.getString()}.
	 * @return the extended attribute that was added.
	 */
	public ExtendedAttribute addExtendedAttribute(DeployModelObject obj,
			String name, EDataType type) {
		assertNull(obj.getExtendedAttribute(name));
		ExtendedAttribute a = CoreFactory.eINSTANCE.createExtendedAttribute();
		a.setName(name);
		a.setInstanceType(type);
		obj.getExtendedAttributes().add(a);
		return a;
	}

	/**
	 * Asserts that the list of unit descriptors contains the specified unit
	 * values.
	 * 
	 * @param list
	 *            List<UnitDescriptor>
	 * @param values
	 *            array of {@link Unit}s.
	 */
	public void assertUnitDescriptorListContainsUnitValues(List list,
			Object[] values) {
		List units = new ArrayList(list.size());
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			units.add(((UnitDescriptor) iter.next()).getUnitValue());
		}
		assertSetEquals(units, values);
	}

	/**
	 * Provides a unit from the infrastructure topology to the edit topology.
	 * 
	 * @param unit
	 *            a unit from the {@link #setInfrastructureTopology(Topology)}.
	 * @param editTop
	 *            the topology to which the unit will be added (not the
	 *            infrastructure topology).
	 * @return the provided unit (copy) contained in the edit topology.
	 */
	protected Unit addTestInfrastructureUnit(Unit unit, Topology editTop) {
		JUnitTopologyProvider provider = JUnitTopologyProvider.getInstance();
		JUnitObjectPathReference ref = new JUnitObjectPathReference(unit);
		TopologyUnitStub[] stubs = provider.resolveStubs(ref);

		Unit result = null;
		for (int i = 0; i < stubs.length; i++) {
			Object[] objects = provider.resolveUnit(stubs[i], false, null);
			for (int j = 0; j < objects.length; j++) {
				if (objects[j] instanceof Unit) {
					result = (Unit) objects[j];
					editTop.getUnits().add(result);
				}
			}
			provider.resolveLinks(Arrays.asList(objects), null);
		}
		return result;
	}

	/**
	 * Configures the unit test discoverer to return units from the specified
	 * topology.
	 * <p>
	 * The {@link JUnitTopologyDiscoverer} is declared in the core.test plug-in
	 * for single-threaded testing of topology-based unit-discovery.
	 * <p>
	 * It is important to understand that the topology discoverer may effect
	 * other tests. It is strongly recommended that testers follow the code
	 * pattern: <code>
	 * try {
	 * 	setInfrastructureTopology(top);
	 * } finally {
	 * 	setInfrastructureTopology(null);
	 * }
	 * </code>
	 * 
	 * @param top
	 *            the topology from which units will be discovered.
	 */
	protected void setInfrastructureTopology(Topology top) {
		JUnitTopologyProvider provider = JUnitTopologyProvider.getInstance();
		JUnitTopologyDiscoverer discoverer = JUnitTopologyDiscoverer
				.getInstance();
		discoverer.setTopology(top);
		provider.setTopology(top);
	}

	/**
	 * Adds an explicit configuration contract to the topology, with defaults of
	 * public/public
	 * 
	 * @param top
	 *            Topology to add a configuration contract to.
	 * @return The explicit contract added to the topology
	 */
	protected ExplicitContract addExplicitContractDefaultPublic(Topology top) {
		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();
		explicitContract.setDefaultConceptualPolicy(Visibility.PUBLIC_LITERAL);
		explicitContract.setDefaultPolicy(Visibility.PUBLIC_LITERAL);
		explicitContract.setName("ExplicitContract");
		explicitContract.setDescription("ExplicitContractPublicDefault");
		top.setConfigurationContract(explicitContract);
		return explicitContract;
	}

	/**
	 * Adds an explicit configuration contract to the topology, with defaults of
	 * private/private
	 * 
	 * @param top
	 *            Topology to add a configuration contract to.
	 * @return The explicit contract added to the topology
	 */
	protected ExplicitContract addExplicitContractDefaultPrivate(Topology top) {
		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();
		explicitContract.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
		explicitContract.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
		explicitContract.setName("ExplicitContract");
		explicitContract.setDescription("ExplicitContractPrivateDefault");
		top.setConfigurationContract(explicitContract);
		return explicitContract;
	}

	/**
	 * Adds an explicit configuration contract to the topology, with defaults of
	 * public editable/public editable
	 * 
	 * @param top
	 *            Topology to add a configuration contract to.
	 * @return The explicit contract added to the topology
	 */
	protected ExplicitContract addExplicitContractDefaultPublicEditable(
			Topology top) {
		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();
		explicitContract
				.setDefaultConceptualPolicy(Visibility.PUBLIC_EDITABLE_LITERAL);
		explicitContract.setDefaultPolicy(Visibility.PUBLIC_EDITABLE_LITERAL);
		explicitContract.setName("ExplicitContract");
		explicitContract
				.setDescription("ExplicitContractPublicEditableDefault");
		top.setConfigurationContract(explicitContract);
		return explicitContract;
	}

	/**
	 * Adds an explicit configuration contract to the topology, with defaults
	 * passed in as parameters.
	 * 
	 * @param top
	 *            Topology to add a configuration contract to.
	 * @param defaultPolicy
	 *            Default policy for concrete units
	 * @param defaultConceptualPolicy
	 *            Default policy for conceptual units
	 * @return The explicit contract added to the topology
	 */
	protected ExplicitContract addExplicitContract(Topology top,
			Visibility defaultPolicy, Visibility defaultConceptualPolicy) {
		ExplicitContract explicitContract = CoreFactory.eINSTANCE
				.createExplicitContract();
		explicitContract.setDefaultConceptualPolicy(defaultConceptualPolicy);
		explicitContract.setDefaultPolicy(defaultPolicy);
		explicitContract.setName("ExplicitContract");
		top.setConfigurationContract(explicitContract);
		return explicitContract;
	}
}
