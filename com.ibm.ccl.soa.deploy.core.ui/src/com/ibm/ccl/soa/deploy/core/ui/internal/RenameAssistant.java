package com.ibm.ccl.soa.deploy.core.ui.internal;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.internal.core.IWorkspaceAssistant;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import org.eclipse.osgi.util.NLS;

/**
 * An assistant to handle the work of updating the diagram file and model file contents based on a
 * model file rename event.
 * 
 */
public class RenameAssistant implements IWorkspaceAssistant {

	private final IFile originalFile;
	private final IFile newFile;
	private IFile originalDiagramFile;
	private IFile newDiagramFile;

	/**
	 * Create an assistant to handle the work of updating the diagram file and model file contents
	 * based on a model file rename event.
	 * 
	 * @param originalModelFile
	 *           The original model file (e.g. *.topology) that was renamed.
	 * @param newModelFile
	 *           The renamed model file (e.g. *.topology) that original file was renamed to.
	 */
	public RenameAssistant(IFile originalModelFile, IFile newModelFile) {
		originalFile = originalModelFile;
		newFile = newModelFile;
		init();
	}

	private void init() {

		IContainer originalContainer = originalFile.getParent();
		IContainer newContainer = newFile.getParent();
		originalDiagramFile = originalContainer.getFile(new Path(DiagramFilesManager
				.getCorrespondingDiagramFileName(originalFile)));
		newDiagramFile = newContainer.getFile(new Path(DiagramFilesManager
				.getCorrespondingDiagramFileName(newFile)));

	}

	/**
	 * Return a scheduling rule appropriate for this RenameAssistant.
	 * 
	 * @return A scheduling rule appropriate for this RenameAssistant.
	 */
	public ISchedulingRule getSchedulingRule() {
		IResourceRuleFactory factory = ResourcesPlugin.getWorkspace().getRuleFactory();
		return factory.moveRule(originalDiagramFile, newDiagramFile);
	}

	public void run(IProgressMonitor monitor) throws CoreException {

		checkCancelled(monitor);
		monitor.beginTask(NLS.bind(Messages.RenameAssistant_Updating_model_file_0_due_to_re_, newFile
				.getName()), 5);

		ChangeScope<Topology, DeploymentTopologyDomain> scope = null;
		try {
			scope = ChangeScope.createChangeScopeForWrite(newFile);

			// update the model contents (namespace, pattern)
			scope.execute(new AbstractEMFOperation(scope.getTransactionalEditingDomain(), NLS.bind(
					Messages.RenameAssistant_Updating_model_contents_of_0_, newFile.getName())) {

				@Override
				protected IStatus doExecute(IProgressMonitor localMonitor, IAdaptable info)
						throws ExecutionException {

					localMonitor.beginTask(getLabel(), 2);

					ChangeScope<Topology, DeploymentTopologyDomain> localScope = ChangeScope
							.findChangeScope(info);

					localMonitor.subTask(CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME.getName());

					Topology topology = localScope.openTopology();
					String fileName = newFile.getName();
					int index = fileName.indexOf(IConstants.DOT_SEPARATOR
							+ IConstants.TOPOLOGY_EXTENSION);
					String newName = fileName;
					if (index > -1) {
						newName = fileName.substring(0, index);
					}
					topology.setName(newName);
					localMonitor.worked(1);

					localMonitor.subTask(CorePackage.Literals.TOPOLOGY__NAMESPACE.getName());

					INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(localScope
							.getTopologyFile().getProject(), new SubProgressMonitor(localMonitor, 2,
							SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
					String namespace = null;
					for (int i = 0; i < roots.length && namespace == null; i++) {
						IContainer container = roots[i].getCorrespondingResource();
						if (container.contains(newFile)) {
							IPath containerPath = container.getFullPath();
							IPath fullPath = newFile.getParent().getFullPath();
							IPath namespacePath = fullPath.removeFirstSegments(containerPath
									.segmentCount());
							namespace = namespacePath.toString().replace(IConstants.PATH_SEPARATOR,
									IConstants.DOT_SEPARATOR);
						}
					}
					topology.setNamespace(namespace);
					localMonitor.worked(1);

					localMonitor.done();

					return Status.OK_STATUS;
				}

			}, ChangeScope.OPTION_FORCE_SAVE, new SubProgressMonitor(monitor, 3,
					SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));

			// update referencing Topologies
			// ...

			// relocate the diagram file to match the model file
//			if (originalFile.getParent().isAccessible() && originalDiagramFile.exists()) {
//				originalDiagramFile.move(newDiagramFile.getFullPath(), true, monitor);
//			}
			checkCancelled(monitor);
			monitor.worked(1);

			// update diagram model 
//			Diagram model = scope.openModel(newDiagramFile, NotationPackage.Literals.DIAGRAM); 
			// ...

		} finally {
			if (scope != null) {
				scope.close(new SubProgressMonitor(monitor, 1,
						SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
			}
		}

		monitor.done();

	}

	private void checkCancelled(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

	}
}
