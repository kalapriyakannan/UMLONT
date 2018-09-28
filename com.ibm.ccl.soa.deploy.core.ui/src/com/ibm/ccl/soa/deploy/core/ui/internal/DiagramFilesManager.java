package com.ibm.ccl.soa.deploy.core.ui.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.internal.core.EventQueueJob;
import com.ibm.ccl.soa.deploy.internal.core.IWorkspaceAssistant;
import com.ibm.ccl.soa.deploy.internal.core.index.IndexMessages;

/**
 * Adds and removes assistants to keep the diagram file in good condition as the model file changes.
 * 
 */
public class DiagramFilesManager {

	protected static final long DELAY = 250;

	protected static String getCorrespondingDiagramFileName(IFile modelFile) {
		return modelFile.getName().replaceFirst(
				IConstants.DOT_SEPARATOR + IConstants.TOPOLOGY_EXTENSION,
				IConstants.DOT_SEPARATOR + IConstants.TOPOLOGYV_EXTENSION);
	}

	private final AbstractModelIndexListener diagramFileCleaner = new AbstractModelIndexListener() {

		public void modelsRemoved(IFile[] modelFiles) {

			final List<IFile> diagramFiles = new ArrayList<IFile>();
			for (int i = 0; i < modelFiles.length; i++) {
				Path diagramFilePath = new Path(getCorrespondingDiagramFileName(modelFiles[i]));
				diagramFiles.add(modelFiles[i].getParent().getFile(diagramFilePath));

			}

			final MultiRule schedulingRule = new MultiRule(diagramFiles.toArray(new IFile[diagramFiles
					.size()]));
			EventQueueJob deleteDiagramJob = new EventQueueJob(
					IndexMessages.ModelFileIndexer_Delete_diagram_files_associated_wit_, schedulingRule);
			deleteDiagramJob.enqueue(new IWorkspaceAssistant() {
				public void run(IProgressMonitor monitor) throws CoreException {

					monitor.beginTask("Deleting Files..", diagramFiles.size()); //$NON-NLS-1$
					try {
						for (Iterator<IFile> iter = diagramFiles.iterator(); iter.hasNext();) {
							IFile file = iter.next();
							if (file.isAccessible()) {
								monitor.subTask(file.getName());
								file.delete(true, new SubProgressMonitor(monitor, 1));
							}
						}
					} finally {
						monitor.done();
					}
				}

				public ISchedulingRule getSchedulingRule() {
					return schedulingRule;
				}

			});

			deleteDiagramJob.schedule(DELAY);
		}
	};

	private final AbstractModelIndexListener renameAssistant = new AbstractModelIndexListener() {

		private EventQueueJob renameDiagramJob = new EventQueueJob(
				"Update diagram files associated with renamed model files", ResourcesPlugin //$NON-NLS-1$
						.getWorkspace().getRoot());

		@Override
		public void modelsRenamed(IFile[] originalFiles, IFile[] renamedFiles) {

			for (int i = 0; i < renamedFiles.length; i++) {
				renameDiagramJob.enqueue(new RenameAssistant(originalFiles[i], renamedFiles[i]));
			}

			renameDiagramJob.schedule(DELAY);
		}

	};

	/**
	 * Must be called to initialize the listeners managed by this type.
	 */
	public void init() {
		addModelListener(diagramFileCleaner);
//		addModelListener(renameAssistant);
	}

	/**
	 * Must be called to dispose the listeners managed by this type.
	 */
	public void dispose() {
		removeModelListener(diagramFileCleaner);
//		removeModelListener(renameAssistant);
	}

	private void addModelListener(AbstractModelIndexListener listener) {
		DeployCorePlugin.getDefault().getIndexer().addModelListener(listener);
	}

	private void removeModelListener(AbstractModelIndexListener listener) {
		DeployCorePlugin.getDefault().getIndexer().removeModelListener(listener);
	}

}
