/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.apps;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

/**
 * @author Bill Arnold
 * @see TopologyDeploymentWizard
 */
public class TopologyDeploymentCommandLineApp implements IApplication {
	
	/** Platform path to test topology files. */
	public static final String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies";

	/** Standard name of topologies source folder. */
	public static final String TOPOLOGIES_FOLDER = "topologies"; //$NON-NLS-1$
	
	/** Dummy project name */
	public static final String DUMMY_PROJECT_NAME = "TPCWDeploy"; 
	
	/** Zephyr wizard app parameter */
	public static final String ZEPHYR_WIZARD_APP = "zephyr.wizard.app";
	
	/** Zephyr wizard infra parameter */
	public static final String ZEPHYR_WIZARD_INFRA = "zephyr.wizard.infra";
	
	private IProject project;

	private String app;

	private String infra;
	
	public Object start(IApplicationContext context) throws Exception {

		app = System.getProperty(ZEPHYR_WIZARD_APP);
		infra = System.getProperty(ZEPHYR_WIZARD_INFRA);
		if ((app == null) || (infra == null)) {
			System.err.println("Usage: -D" + ZEPHYR_WIZARD_APP + "=<url> -" + ZEPHYR_WIZARD_INFRA + "=<url>");
			return EXIT_OK;
		}
		
		System.out.println("Application=" + app);
		System.out.println("Infrastructure=" + infra);
		
		loadAndMarry(app, infra, "LASPlusDeveloperPlusInfra");
		
		return EXIT_OK;
	}

	public void stop() {
		// do nothing
	}
	
	private void addNullContract(Topology top) {
		ExplicitContract nc = CoreFactory.eINSTANCE.createExplicitContract();
		nc.setName("Null0");
		nc.setDisplayName("Null contract");
		nc.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
		nc.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
		top.setConfigurationContract(nc);
	}
	
	private void loadAndMarry(String conceptualTopURI, String infraTopURI, String editTopName) throws IOException {
		
		Topology concept = loadTopology(conceptualTopURI);
		assert concept.getConfigurationContract() != null;
		concept.eResource().setURI(getURI(concept.getName(), concept.getNamespace()));

		Topology infra = loadTopology(infraTopURI);
		assert infra.getConfigurationContract() != null;
		infra.eResource().setURI(getURI(infra.getName(), infra.getNamespace()));
		
		try {
			marry(concept, infra);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Topology marry(Topology las, Topology infrastructure) throws Exception {
		Topology targetTop = createTopology("Deployment");		
		targetTop.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);		
		addNullContract(targetTop);
		
		createDummyProject(DUMMY_PROJECT_NAME);
		IProgressMonitor monitor = null;
		/*topologiesRoot =*/ NamespaceCore.createRoot(project
				.getFolder(TOPOLOGIES_FOLDER), monitor);
		
		writeToFile(targetTop, DUMMY_PROJECT_NAME); //$NON-NLS-1$
		
		Topology top1 = las;
		assert top1.getConfigurationContract() != null;	
		
		// To successfully import, both topologies must be in the same project.  Save a copy
		// of the inputs alongside 'targetTop'.  Furthermore, the filename must match the Topology name!
		writeToFile(las, las.getName()); //$NON-NLS-1$
		writeToFile(infrastructure, infrastructure.getName()); //$NON-NLS-1$
		
		Import importDcl1 = TopologyUtil.importTopology(top1, targetTop);		
		Topology importTop1 = TopologyUtil.resolve(importDcl1);
		if (importTop1 == null) {
			return targetTop;
		}
		assert top1 != null;		
		assert allUnitsCount(top1) > 0;		
		Topology top2 = infrastructure;
		assert top2.getConfigurationContract() != null;
		
		Import importDcl2 = TopologyUtil.importTopology(top2, targetTop);		
		/*Topology importTop2 = */TopologyUtil.resolve(importDcl2);		
		assert top2 != null;		
		assert allUnitsCount(top2) > 0;		
//		int cntImported = (allUnitsCount(top1) + allUnitsCount(top2));		
//		int cntTarget= allUnitsCount(targetTop);
		
		TemplateScenarioTests.realizationResolution(targetTop, 2, getValidatorService());
		TemplateScenarioTests.resolveConstraintLinks(targetTop, getValidatorService());
		
		targetTop.getEObject().eResource().save(null);
		System.out.println("Deployment topology in " + targetTop.getEObject().eResource().getURI());
		
		return targetTop;
	}
	
	/**
	 * @return a shared copy of the deploy validator service.
	 */
	protected DeployValidatorService getValidatorService() {
		return DeployValidatorService.getDefaultValidatorService();
	}
	
	private void writeToFile(Topology top, String fname) throws IOException {
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(top);
		if (top.getNamespace() != null) {
			fname = top.getNamespace().replace('.', '/') + '/' + fname;
		}
		URI uri = getURI(fname, null);
		Resource res = WorkbenchResourceHelperBase.createResource(uri);
		res.getContents().add(root);
		res.save(null);
	}

	private void createDummyProject(String string) throws CoreException {
		// Create Eclipse project
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
		project.delete(true, true, null);
		project.create(null);
		project.open(null);
	}

	private String getProjectName() {
		return DUMMY_PROJECT_NAME; //$NON-NLS-1$
	}
	
	private int allUnitsCount(Topology top) {
		int count = 0;
		for (Iterator<Unit> unitsIter = top.findAllUnits(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			++count;
		}
		return count;
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
		int dotIndex = name.lastIndexOf(IConstants.DOT_SEPARATOR);
		String namespace = null;
		if (dotIndex != -1) {
			namespace = name.substring(0, dotIndex);
			name = name.substring(dotIndex + 1);
		}
		return createTopology(name, namespace, save);
	}
	
	/**
	 * Creates an empty topology associated with an Eclipse resource on a null
	 * namespace.
	 * <p>
	 * The topology file is created in the topology source folder of the 
	 * project ({@link #getProject()}). The null namespace is used.
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
		URI uri = URI.createFileURI("c:/eclipse-constellation.workspace/Topologies/TestLASPlusDeveloper.topology");
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.createResource(uri);

		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName(name);
		top.setNamespace(namespace);
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(top);
		res.getContents().add(root);

		if (save) {
			res.save(null);
		}
		return top;
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
		String fullPath = /*getName()*/ DUMMY_PROJECT_NAME + '/' + TOPOLOGIES_FOLDER + '/';
		if (namespace != null) {
			fullPath += namespace.replace(IConstants.DOT_SEPARATOR, '/') + '/';
		}
		fullPath += name + ".topology";
		return URI.createPlatformResourceURI(fullPath);
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
}
