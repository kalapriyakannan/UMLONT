/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.location;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationFactory;
import com.ibm.ccl.soa.deploy.location.LocationPackage;
import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;

/**
 * @since 1.0
 * 
 */
public class LocationBindingUsageTests extends TopologyTestCase {

	private static final String PROJECT_NAME = "LocationBindingUsageTests";
	private static final String WebModuleName = "BankWar";
	private static final String DbComponen1Name = "DbComponen1";
	private static final String SecondDbComponentName = "SecondDbComponent";

	/**
	 * 
	 */
	public LocationBindingUsageTests() {
		super(PROJECT_NAME);
	}
	
	public LocationBindingUsageTests(String name) {
		super(name);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		//suite.addTest(new LocationBindingUsageTests("testLocationBindingUsage"));
		suite.addTestSuite(LocationBindingUsageTests.class);
		return suite;
	}
	
	protected URI getLocationBindingURI(String name, String namespace) {
		assert name.indexOf(IConstants.DOT_SEPARATOR) == -1;
		String fullPath = getName() + '/' + TOPOLOGIES_FOLDER + '/';
		if (namespace != null) {
			fullPath += namespace.replace(IConstants.DOT_SEPARATOR, '/') + '/';
		}
		fullPath += name +'/'+ name+IConstants.DOT_SEPARATOR + IConstants.LOCBINDING_EXTENSION;
		return URI.createPlatformResourceURI(fullPath);
	}

	protected LocationBinding createLocationBinding(Topology topology,
			boolean save) throws IOException {
		URI uri = getLocationBindingURI(topology.getName(), topology.getNamespace());
		ResourceSet resourceSet = topology.eResource().getResourceSet();
		Resource resource = resourceSet.createResource(uri);
		final LocationBindingRoot root = LocationFactory.eINSTANCE.createLocationBindingRoot();
		resource.getContents().add(root);
		LocationBinding source = LocationFactory.eINSTANCE.createLocationBinding();
		String topQualifiedName = topology.getQualifiedName();
		source.setName(topology.getName());
		source.setTopology(topQualifiedName);
		root.setLocationBinding(source);
		if (save) {
			resource.save(null);
		}
		return source;
	}
	
	/**
	 * Test the location binding usage
	 * 
	 * @throws Exception
	 */
	public void testLocationBindingUsage() throws Exception {
		try {
			//LocationBindingService.INSTANCE.setLocationBindingUsage(true);
			Topology top = createTopology("testLocationBindingUsage");
			LocationBinding topLocBinding = createLocationBinding(top, true);
			// Create test bank web module
			WebModule bankWebMod = J2eeFactory.eINSTANCE.createWebModule();
			bankWebMod.setName(WebModuleName);
			IProject bankProject = TomcatTestWorkspace
					.getProject(TomcatTestWorkspace.BANK_PROJECT_NAME);
			// Add a war to the web module
			FileArtifact warArt = CoreFactory.eINSTANCE.createFileArtifact();
			warArt.setName("TestWar1");
			warArt.setDisplayName("TestWar1");
			warArt.getFileURIs().add(bankProject.getName());
			bankWebMod.getArtifacts().add(warArt);
			top.getUnits().add(bankWebMod);
			assert warArt.getFileURIs().contains(bankProject.getName()) == true;

			// Create database component
			DatabaseComponent dbComponent = DatabaseFactory.eINSTANCE
					.createDatabaseComponent();
			dbComponent.setName(DbComponen1Name);
			// Add a ddl file URI
			FileArtifact dbArt = CoreFactory.eINSTANCE.createFileArtifact();
			dbArt.setName("TestDb1");
			dbArt.setDisplayName("TestDb1");
			dbArt.getFileURIs().add("/TestDb1/db1.ddl");
			dbArt.getFileURIs().add("/TestDb1/db2.ddl");
			dbArt.getFileURIs().add("/TestDb1/db3.ddl");
			dbArt.getFileURIs().remove("/TestDb1/db3.ddl");
			assert dbArt.getFileURIs().size() == 2;
			dbComponent.getArtifacts().add(dbArt);
			top.getUnits().add(dbComponent);

			/*//reload
			top = reload(top, true);

			assert top.getUnits().size() == 2;
			List units = top.getUnits();
			// verify location binding entries
			FileArtifact dbArt2 = null;
			FileArtifact warArt2 = null;
			for (Iterator iterator = units.iterator(); iterator.hasNext();) {
				DeployModelObject dmo = (DeployModelObject) iterator.next();
				if (dmo.getName().equals(WebModuleName)) {
					warArt2 = ((FileArtifact) dmo.getArtifacts().get(0));
				} else if (dmo.getName().equals(DbComponen1Name)) {
					dbArt2 = ((FileArtifact) dmo.getArtifacts().get(0));
				}
			}
			int numdbArt2 = 2;
			int numwarArt2 = 1;
			assert dbArt2 != null;
			assert dbArt2.getFileURIs().size() == numdbArt2;
			assert warArt2 != null;
			assert warArt2.getFileURIs().contains(bankProject.getName()) == true;

			// getlocation binding
			final ChangeScope changeScope = ChangeScope
					.createChangeScope(dbArt2);
			try {
				LocationBinding locBinding = getLocationBinding(changeScope,
						dbArt2);
				assert locBinding.getBindingEntry().size() == (dbArt2
						.getFileURIs().size() + warArt2.getFileURIs().size());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				changeScope.close(new NullProgressMonitor());
			}

			// add another database component
			DatabaseComponent SecondDbComponent = DatabaseFactory.eINSTANCE
					.createDatabaseComponent();
			SecondDbComponent.setName(SecondDbComponentName);
			// Add a ddl file URI
			FileArtifact SecondDbComponentArt = CoreFactory.eINSTANCE
					.createFileArtifact();
			SecondDbComponentArt.setName("TestDb1");
			SecondDbComponentArt.setDisplayName("TestDb1");
			SecondDbComponentArt.getFileURIs().add("/TestDb1/db1.ddl");
			assert SecondDbComponentArt.getFileURIs().size() == 1;
			SecondDbComponent.getArtifacts().add(SecondDbComponentArt);
			top.getUnits().add(SecondDbComponent);
			top = reload(top, true);

			// getlocation binding
			final ChangeScope changeScope2 = ChangeScope.createChangeScope(top);
			try {
				LocationBinding locBinding = getLocationBinding(changeScope2,
						top);
				assert locBinding.getBindingEntry().size() == (1 + numwarArt2 + numdbArt2);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				changeScope2.close(new NullProgressMonitor());
			}

			// remove second database component
			List units2 = top.getUnits();
			DeployModelObject dmo2 = null;
			for (Iterator iterator = units2.iterator(); iterator.hasNext();) {
				DeployModelObject dmo = (DeployModelObject) iterator.next();
				if (dmo.getName().equals(SecondDbComponentName)) {
					dmo2 = dmo;
					break;
				}
			}

			assert dmo2 != null;
			top.getUnits().remove(dmo2);
			top = reload(top, true);

			// getlocation binding
			final ChangeScope changeScope3 = ChangeScope.createChangeScope(top);
			try {
				LocationBinding locBinding = getLocationBinding(changeScope3,
						top);
				assert locBinding.getBindingEntry().size() == (numwarArt2 + numdbArt2);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				changeScope3.close(new NullProgressMonitor());
			}*/
		} finally {
			//LocationBindingService.INSTANCE.setLocationBindingUsage(false);
		}
	}

	public void testNoLocationBindingUsage() throws Exception {
		//LocationBindingService.INSTANCE.setLocationBindingUsage(false);
		Topology top = createTopology("testNoLocationBindingUsage");
		// Create test bank web module
		WebModule bankWebMod = J2eeFactory.eINSTANCE.createWebModule();
		bankWebMod.setName(WebModuleName);
		IProject bankProject = TomcatTestWorkspace
				.getProject(TomcatTestWorkspace.BANK_PROJECT_NAME);
		// Add a war to the web module
		FileArtifact warArt = CoreFactory.eINSTANCE.createFileArtifact();
		warArt.setName("TestWar1");
		warArt.setDisplayName("TestWar1");
		warArt.getFileURIs().add(bankProject.getName());
		bankWebMod.getArtifacts().add(warArt);
		top.getUnits().add(bankWebMod);
		assert warArt.getFileURIs().contains(bankProject.getName()) == true;

		// Create database component
		DatabaseComponent dbComponent = DatabaseFactory.eINSTANCE
				.createDatabaseComponent();
		dbComponent.setName(DbComponen1Name);
		// Add a ddl file URI
		FileArtifact dbArt = CoreFactory.eINSTANCE.createFileArtifact();
		dbArt.setName("TestDb1");
		dbArt.setDisplayName("TestDb1");
		dbArt.getFileURIs().add("/TestDb1/db1.ddl");
		dbArt.getFileURIs().add("/TestDb1/db2.ddl");
		dbArt.getFileURIs().add("/TestDb1/db3.ddl");
		dbArt.getFileURIs().remove("/TestDb1/db3.ddl");
		assert dbArt.getFileURIs().size() == 2;
		dbComponent.getArtifacts().add(dbArt);
		top.getUnits().add(dbComponent);

		// verify contents
		top = reload(top, true);

		assert top.getUnits().size() == 2;
		List units = top.getUnits();
		// verify location binding entries
		FileArtifact dbArt2 = null;
		FileArtifact warArt2 = null;
		for (Iterator iterator = units.iterator(); iterator.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iterator.next();
			if (dmo.getName().equals(WebModuleName)) {
				warArt2 = ((FileArtifact) dmo.getArtifacts().get(0));
			} else if (dmo.getName().equals(DbComponen1Name)) {
				dbArt2 = ((FileArtifact) dmo.getArtifacts().get(0));
			}
		}
		int numdbArt2 = 2;
		int numwarArt2 = 1;
		assert dbArt2 != null;
		assert dbArt2.getFileURIs().size() == numdbArt2;
		assert warArt2 != null;
		assert warArt2.getFileURIs().contains(bankProject.getName()) == true;

		// check location binding does not exist
		IPath possibleLocFilePath = new Path(LocationBindingService.INSTANCE
				.getLocBindingId(top.getName())
				+ IConstants.LOCBINDING_EXTENSION);
		assert possibleLocFilePath.toFile().exists() == false;

	}

	protected LocationBinding getLocationBinding(
			ChangeScope<LocationBindingRoot, DeploymentTopologyDomain> changeScope,
			final DeployModelObject dmo) throws ExecutionException {
		final String topQualifiedName = dmo.getTopology().getQualifiedName();
		final String topName = dmo.getTopology().getName();
		LocationBindingRoot root = changeScope.openModel(changeScope
				.getDomain().getLocationFile(), LocationPackage.eINSTANCE
				.getLocationBindingRoot());
		return root.getLocationBinding();
	}

	public Topology reload(Topology top, boolean save) throws IOException {
		Resource res = top.getEObject().eResource();
		if (save) {
			res.save(null);
		}
		res.unload();
		res.load(null);
		res.setTrackingModification(true);
		assert res.getErrors().size() == 0 : dumpResourceErrors(res);
		assert res.getWarnings().size() == 0 : dumpResourceWarnings(res);
		top = ((DeployCoreRoot) res.getContents().get(0)).getTopology();
		return top;
	}
}
