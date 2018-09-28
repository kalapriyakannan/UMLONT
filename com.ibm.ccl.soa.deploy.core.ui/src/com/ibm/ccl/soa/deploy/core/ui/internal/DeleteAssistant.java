package com.ibm.ccl.soa.deploy.core.ui.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;

import com.ibm.ccl.soa.deploy.internal.core.IWorkspaceAssistant;

/**
 * An assistant to handle the work of updating the diagram file and model file contents based on a
 * model file delete event.
 * 
 */
public class DeleteAssistant implements IWorkspaceAssistant {

	private final IFile[] diagramFiles;

	/**
	 * Create an assistant to handle the work of updating the diagram file and model file contents
	 * based on a model file delete event.
	 * 
	 * @param diagramFilesToDelete
	 *           The array of files to delete
	 */
	public DeleteAssistant(IFile[] diagramFilesToDelete) {
		diagramFiles = diagramFilesToDelete;
	}

	public ISchedulingRule getSchedulingRule() {
		return new MultiRule(diagramFiles);
	}

	public void run(IProgressMonitor monitor) throws CoreException {

		monitor.beginTask("Deleting Files..", diagramFiles.length); //$NON-NLS-1$
		try {
			IFile file = null;
			for (int i = 0; i < diagramFiles.length; i++) {
				file = diagramFiles[i];
				if (file.isAccessible()) {
					monitor.subTask(file.getName());
					file.delete(true, new SubProgressMonitor(monitor, 1));
				}
			}
		} finally {
			monitor.done();
		}
	}

}
