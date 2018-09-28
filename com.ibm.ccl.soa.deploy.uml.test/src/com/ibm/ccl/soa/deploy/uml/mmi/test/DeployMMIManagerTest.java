package com.ibm.ccl.soa.deploy.uml.mmi.test;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.DeployMMIManager;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.providers.DeployModelMappingProvider;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.sync.SyncHelper;
import com.ibm.ccl.soa.deploy.uml.test.workspaces.ZephyrUmlTestWorkspace;
import com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.providers.DeployUmlVizUIHandler;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.internal.VizStructuralFeatureValueGetter;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.umlviz.core.internal.model.VizArtifactImpl;

public class DeployMMIManagerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		ZephyrUmlTestWorkspace.init();
	}

	ITarget target;

	public void testManager() {

		ZephyrUmlTestWorkspace
				.getProject(ZephyrUmlTestWorkspace.TOPOLOGY_PROJECT);
		URI topologyResourceURI = URI.createPlatformResourceURI(
				ZephyrUmlTestWorkspace.TOPOLOGY_PROJECT
						+ "/topologies/test/UMLTopology.topology", true);
		Resource topologyResoruce = WorkbenchResourceHelperBase
				.createResource(topologyResourceURI);
		try {
			topologyResoruce.load(null);
		} catch (IOException e) {
			assert (false);
		}
		Resource umlResource = ZephyrUmlTestWorkspace.getModelResource();
		DeployMMIManager manager = DeployMMIManager.getInstance();
		final TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(umlResource);
		DeployCoreRoot root = (DeployCoreRoot) topologyResoruce.getContents()
				.get(0);
		assert (root != null);
		Topology topology = root.getTopology();
		assert (topology != null);
		final Unit node = (Unit) topology.resolve("Node");
		assert (node != null);
		final EClass artifactClass = DeployUmlVizUIHandler.getInstance()
				.getTargetEClass(null, node, null);
		assert (artifactClass != null);
		ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(topology);

		AbstractEMFOperation op = new AbstractEMFOperation(domain, "test") {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				target = (ITarget) DeployModelMappingProvider.getInstance()
						.adapt(domain, node, artifactClass);

				return Status.OK_STATUS;

			}
		};
		try {
			changeScope.execute(op, ChangeScope.OPTION_FORCE_SAVE, null);
		} finally {
			if (changeScope != null) {
				changeScope.close(null);
			}
		}
		assert (target != null);
		List<StructuredReference> references = manager
				.getStructuredReferences(topologyResoruce.getURI()
						.toPlatformString(true));
		assert (references != null);
		StructuredReference reference = references.get(0);
		assert (target.getStructuredReference() == reference);
		node.setDisplayName("node2");
		try {
			topologyResoruce.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		references = manager.getStructuredReferences(topologyResoruce.getURI()
				.toPlatformString(true));
		assert (references != null);

		final SyncHelper helper = new SyncHelper(reference);
		ChangeScope changeScope2 = ChangeScope.createChangeScopeForWrite(topology);

		AbstractEMFOperation op2 = new AbstractEMFOperation(domain, "test") {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				DeployModelMappingProvider.getInstance().synchronizeFeature(
						target, uml2().getNamedElement_Name(), helper);

				return Status.OK_STATUS;

			}
		};
		try {
			changeScope2.execute(op2, ChangeScope.OPTION_FORCE_SAVE, null);
		} finally {
			if (changeScope2 != null) {
				changeScope2.close(null);
			}
		}

		AbstractEMFOperation op3 = new AbstractEMFOperation(domain, "test") {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				VizArtifactImpl artifact = (VizArtifactImpl) DeployModelMappingProvider.getInstance()
						.adapt(domain, node, artifactClass);
				assert (artifact.getName().equals("node2"));
				return Status.OK_STATUS;

			}
		};

		ChangeScope changeScope3 = ChangeScope.createChangeScopeForWrite(topology);

		try {
			changeScope3.execute(op3, ChangeScope.OPTION_FORCE_SAVE, null);
		} finally {
			if (changeScope3 != null) {
				changeScope3.close(null);
			}
		}

	}

	static UMLPackage uml2() {
		return UMLPackage.eINSTANCE;
	}

}
