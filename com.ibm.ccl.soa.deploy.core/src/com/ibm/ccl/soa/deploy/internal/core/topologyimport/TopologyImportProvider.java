/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.SynchronizationChange;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * @since 1.0
 * 
 */
public class TopologyImportProvider extends UnitProvider {

	private ROTopologyModelManager modelManager = null;

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;
		if (anInputObject instanceof IFile) {
			IResource resource = (IResource) anInputObject;
			stubs = new TopologyUnitStub[1];
			String resourceName = resource.getName().substring(0,
					resource.getName().length() - resource.getFileExtension().length() - 1);
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			annotation.getDetails().put(IAnnotationConstants.ARCHIVE_URI,
					resource.getFullPath().toPortableString());
			stubs[0] = new TopologyUnitStub(resourceName, null, annotation, resource);
		} else if (anInputObject instanceof Topology) {
			Topology topology = (Topology) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			IFile topFile = WorkbenchResourceHelper.getFile(topology);
			String topFileName = topFile.getName().substring(0,
					topFile.getName().length() - topFile.getFileExtension().length() - 1);

			annotation.getDetails().put(IAnnotationConstants.ARCHIVE_URI,
					topFile.getFullPath().toPortableString());
			// getTopology file name

			stubs[0] = new TopologyUnitStub(topFileName, null, annotation, topology);
		}
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {
		Object anInputObject = aStub.getInput();
		if (aStub.getInput() == null) {
			return null;
		}
		Import topologyImport = null;
		Object target = aStub.getDropTarget();
		boolean useExisting = false;
		if (target instanceof Import) {
			topologyImport = (Import) target;
			useExisting = true;
		} else {
			topologyImport = CoreFactory.eINSTANCE.createImport();
		}
		topologyImport.setName(UnitUtil.fixNameForID(aStub.getName()));
		topologyImport.setPattern(aStub.getName());
		topologyImport.setMutable(true);
		if (anInputObject instanceof IFile) {
			IFile topologyFile = (IFile) anInputObject;
			//topologyImport.setLocation((topologyFile.getFullPath().toPortableString()));	
			topologyImport.setNamespace(NamespaceCore.create(topologyFile.getParent())
					.getQualifiedName());
			InstanceConfiguration instanceConfig = CoreFactory.eINSTANCE.createInstanceConfiguration();
			instanceConfig.setName("default");//$NON-NLS-1$
			Topology top = getTopology(topologyFile);
			if (top != null) {
				topologyImport.setDisplayName(top.getDisplayName());
			} else {
				topologyImport.setDisplayName(aStub.getName());
			}
			topologyImport.setInstanceConfiguration(instanceConfig);
		} else if (anInputObject instanceof Topology) {
			Topology topology = (Topology) anInputObject;
			topologyImport.setDisplayName(topology.getDisplayName());
			//topologyImport.setLocation((WorkbenchResourceHelper.getFile(topology).getFullPath().toPortableString()));	
			topologyImport.setNamespace(topology.getNamespace());
			InstanceConfiguration instanceConfig = CoreFactory.eINSTANCE.createInstanceConfiguration();
			instanceConfig.setName("default"); //$NON-NLS-1$
			topologyImport.setInstanceConfiguration(instanceConfig);
		}
		if (useExisting) {
			return new DeployModelObject[0];
		}
		return new DeployModelObject[] { topologyImport };
	}

	/**
	 */
	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RefactoringStatus checkConditionsForImport(TopologyUnitStub stub, IProgressMonitor monitor)
			throws OperationCanceledException {

		try {
			monitor.beginTask(DeployCoreMessages.TopologyImportProvider_Validating_import_, 10);
			Object stubInput = stub.getInput();
			IFile importedFile = null;
			IFile importedToFile = null;
			if (stubInput instanceof IFile) {
				importedFile = (IFile) stubInput;
			} else if (stubInput instanceof Topology) {
				importedFile = WorkbenchResourceHelper.getFile((Topology) stubInput);
			}
			monitor.worked(2);
			importedToFile = WorkbenchResourceHelper.getFile(stub.getTopology());
			monitor.worked(2);
			if (importedFile == null || importedToFile == null) {
				return RefactoringStatus.createErrorStatus(NLS.bind(
						DeployCoreMessages.TopologyImportProvider_The_source_file_0_does_not_co_,
						importedToFile.getName()));
			}
			monitor.worked(1);
			if (importedToFile.equals(importedFile)) {
				return RefactoringStatus
						.createErrorStatus(DeployCoreMessages.TopologyImportProvider_Cannot_import_a_Topology_into_itsel_);

			}
			monitor.worked(1);
			if (!importedToFile.getProject().equals(importedFile.getProject())) {
				return RefactoringStatus
						.createErrorStatus(DeployCoreMessages.TopologyImportProvider_Cross_project_imports_are_not_yet_s_);
			}
			monitor.worked(1);
			ChangeScope<Topology, DeploymentTopologyDomain> scope = null;
			try {
				scope = ChangeScope.createChangeScopeForWrite(importedFile);

				Topology importedTopology = scope.openTopology();

				Import existingImport = stub.getTopology().getImport(importedTopology.getNamespace(),
						importedTopology.getName());
				if (existingImport != null) {
					return RefactoringStatus.createErrorStatus(NLS.bind(
							DeployCoreMessages.TopologyImportProvider_Import_for_0_already_exists_in_,
							new Object[] { importedTopology.getName(), stub.getTopology().getName() }));
				}
			} finally {
				if (scope != null) {
					scope.close(new SubProgressMonitor(monitor, 1,
							SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
				} else {
					monitor.worked(1);
				}
			}
			monitor.worked(2);
		} finally {
			monitor.done();
		}
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Change[] createImportChange(final Topology topology, final TopologyUnitStub stub,
			IProgressMonitor monitor) {
		Change[] changes = new Change[] { new SynchronizationChange(stub.getTopology(),
				getDescriptor().getDescription()) {

			@Override
			public Change perform(IProgressMonitor monitor) throws CoreException {

				try {
					monitor.beginTask(NLS.bind(DeployCoreMessages.UnitProvider_Resolving_Units_for_0_,
							stub.getName()), 10);

					Object[] resolvedImports = resolveUnit(stub, true, monitor);
					monitor.worked(8);

					topology.getImports().addAll(Arrays.asList(resolvedImports));
					monitor.worked(2);
				} finally {
					monitor.done();
				}

				return null;
			}

		} };
		return changes;
	}

	private Topology getTopology(IFile file) {
		return getModelManager().openModel(file, new ROTopologyModelManager.Listener() {
			public void onUnload(IFile unloadedResource) {
			}
		});
	}

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}
		return modelManager;
	}

}
