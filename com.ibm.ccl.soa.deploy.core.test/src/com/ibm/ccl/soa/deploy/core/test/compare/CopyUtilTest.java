package com.ibm.ccl.soa.deploy.core.test.compare;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.internal.update.RefreshDeployEtoolsCopyUtility;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class CopyUtilTest extends TopologyTestCase {
	public CopyUtilTest(String name) {
		super("testMerge");
		// TODO Auto-generated constructor stub
	}

	Unit unitProviderUnit;
	Unit diagramUnit;
	Topology top;

	protected void setUpMixedTwoDeepMerge() {
		top = createTopology("compareTopology");
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("test Unit");
		// /////////common base for sourceUnit and targetUnit
		// /////////both units will have exstMetaData
		AttributeMetaData exstdata = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		exstdata.setAttributeName("existing Attribute");
		unit.getAttributeMetaData().add(exstdata);
		top.getUnits().add(unit);
		Resource resource = top.eResource();
		// save, unload, and reload
		try {
			resource.save(Collections.EMPTY_MAP);
			resource.unload();
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// //////Load the first unit -> sourceUnit
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		top = root.getTopology();
		diagramUnit = (Unit) top.getUnits().get(0);
		// /////// Add two fileArtifacts -> diagramUnit
		FileArtifact sourceArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		sourceArtifact.getFileURIs().add("some uri string");
		diagramUnit.getArtifacts().add(sourceArtifact);
		FileArtifact sourceArtifact2 = CoreFactory.eINSTANCE
				.createFileArtifact();
		sourceArtifact2.getFileURIs().add("some other uri string");
		diagramUnit.getArtifacts().add(sourceArtifact2);
		// ///////Add one capability -> diagramUnit
		Capability capability = CoreFactory.eINSTANCE.createCapability();
		capability.setName("test Cap");
		// /////// Add one annotation -> diagramUnit
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext("test");
		diagramUnit.getAnnotations().add(annotation);
		// /////// Add one atributeMetaData to the capability 2-deep case ->
		// diagramUnit
		AttributeMetaData data = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		data.setAttributeName("test attribute");
		capability.getAttributeMetaData().add(data);
		diagramUnit.getCapabilities().add(capability);

		// ////Load resource from disk -> simulate UnitProvider
//		resource = ResourceUtil.getResourceSet().getResource(resource.getURI(),
//				true);
		root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		unitProviderUnit = (Unit) topology.getUnits().get(0);
		final FileArtifact targetArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		targetArtifact.getFileURIs().add("target artifact");
		TransactionalEditingDomain ed = TransactionUtil
				.getEditingDomain(unitProviderUnit);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				"To initialize COMFORT Constraint") {
			// /////Add a file artifact --> targetUnit
			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				unitProviderUnit.getArtifacts().add(targetArtifact);
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};
		try {
			update.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	public void testMerge() {
		testMergeTwoDeep();
		testMergeStraightCopy();
		testLinkCopy();
	}

	public void testMergeTwoDeep() {
		setUpMixedTwoDeepMerge();
		assertTrue(diagramUnit.getCapabilities().size() == 1);
		assertTrue(diagramUnit.getArtifacts().size() == 2);
		// two deep case
		assertTrue(((Capability) diagramUnit.getCapabilities().get(0))
				.getAttributeMetaData().size() == 1);
		assertTrue(unitProviderUnit.getCapabilities().isEmpty());
		IRelationshipChecker checker = top.getRelationships();
		TransactionalEditingDomain ed = TransactionUtil
				.getEditingDomain(unitProviderUnit);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				"Two deep Merge") {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				EObject obj = RefreshDeployEtoolsCopyUtility.createCopy(diagramUnit,
						unitProviderUnit.getTopology(), null);
				Unit copyUnit = (Unit) obj;
				assertTrue(copyUnit.getCapabilities().size() == 1);
				assertTrue(copyUnit.getArtifacts().size() == 2);
				assertTrue(copyUnit.getAttributeMetaData().size() == 1);
				// two deep case
				assertTrue(((Capability) copyUnit.getCapabilities().get(0))
						.getAttributeMetaData().size() == 1);

				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};

		try {
			update.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void setUpMergeStraightCopy() {
		top = createTopology("compareTopologyA");
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("test Unit");
		top.getUnits().add(unit);
		Resource resource = top.eResource();
		// save, unload, and reload
		try {
			resource.save(Collections.EMPTY_MAP);
			resource.unload();
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// //////Load the first unit -> diagramUnit
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		top = root.getTopology();
		diagramUnit = (Unit) top.getUnits().get(0);
		// /////// Add two fileArtifacts -> diagramUnit
		FileArtifact sourceArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		sourceArtifact.getFileURIs().add("some uri string");
		diagramUnit.getArtifacts().add(sourceArtifact);
		FileArtifact sourceArtifact2 = CoreFactory.eINSTANCE
				.createFileArtifact();
		sourceArtifact2.getFileURIs().add("some other uri string");
		diagramUnit.getArtifacts().add(sourceArtifact2);
		// ///////Add one capability -> diagramUnit
		Capability capability = CoreFactory.eINSTANCE.createCapability();
		capability.setName("test Cap");
		// /////// Add one annotation -> diagramUnit
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext("test");
		diagramUnit.getAnnotations().add(annotation);
		diagramUnit.getCapabilities().add(capability);

		// ////Load resource from disk -> simulate UnitProvider
//		resource = ResourceUtil.getResourceSet().getResource(resource.getURI(),
//				true);
		root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		unitProviderUnit = (Unit) topology.getUnits().get(0);
		// targetUnit empty

	}

	public void testMergeStraightCopy() {
		setUpMergeStraightCopy();
		assertTrue(diagramUnit.getCapabilities().size() == 1);
		assertTrue(diagramUnit.getArtifacts().size() == 2);
		assertTrue(unitProviderUnit.getCapabilities().isEmpty());
		IRelationshipChecker checker = top.getRelationships();
		TransactionalEditingDomain ed = TransactionUtil
				.getEditingDomain(unitProviderUnit);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				"one deep copy") {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				EObject obj = RefreshDeployEtoolsCopyUtility.createCopy(diagramUnit,
						unitProviderUnit.getTopology(), null);
				Unit copyUnit = (Unit) obj;
				assertTrue(copyUnit.getCapabilities().size() == 1);
				assertTrue(copyUnit.getArtifacts().size() == 2);
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};

		try {
			update.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void setUpLinkCopy() {
		top = createTopology("compareTopologyC");
		Unit unitA = CoreFactory.eINSTANCE.createUnit();
		unitA.setName("test Unit");
		FileArtifact sourceArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		sourceArtifact.getFileURIs().add("some uri string");
		unitA.getArtifacts().add(sourceArtifact);
		top.getUnits().add(unitA);
		Unit unitB = CoreFactory.eINSTANCE.createUnit();
		unitB.setName("test Unit");
		top.getUnits().add(unitB);
		Resource resource = top.eResource();
		// save, unload, and reload
		try {
			resource.save(Collections.EMPTY_MAP);
			resource.unload();
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// //////Load the first unit -> diagramUnit
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		top = root.getTopology();
		diagramUnit = (Unit) top.getUnits().get(0);
		HostingLink hLink = CoreFactory.eINSTANCE.createHostingLink();
		hLink.setSource(unitB);
		hLink.setTarget(diagramUnit);
		diagramUnit.getHostingLinks().add(hLink);

		// ////Load resource from disk -> simulate UnitProvider
//		resource = ResourceUtil.getResourceSet().getResource(resource.getURI(),
//				true);
		root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology = root.getTopology();
		unitProviderUnit = (Unit) topology.getUnits().get(0);
		

	}

	public void testLinkCopy() {
		setUpLinkCopy();

		IRelationshipChecker checker = top.getRelationships();
		TransactionalEditingDomain ed = TransactionUtil
				.getEditingDomain(unitProviderUnit);
		AbstractEMFOperation update = new AbstractEMFOperation(ed, "link copy") {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				EObject obj = RefreshDeployEtoolsCopyUtility.createCopy(unitProviderUnit,
						diagramUnit.getTopology(), null);
				Unit copyUnit = (Unit) obj;
				assertTrue(copyUnit.getHostingLinks().size() == 1);
				assertTrue(((HostingLink) copyUnit.getHostingLinks().get(0))
						.getTarget() != null);
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};

		try {
			update.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
