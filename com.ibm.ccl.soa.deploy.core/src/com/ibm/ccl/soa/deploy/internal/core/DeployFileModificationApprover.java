package com.ibm.ccl.soa.deploy.internal.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationApprover2;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.operation.DeployModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.operation.IDeployModelObjectOperation;

/**
 * An {@link IOperationApprover2} used to support validateEdit calls on
 * {@link DeployModelObjectOperation}s.
 * 
 * @since 7.0
 * 
 */
public class DeployFileModificationApprover implements IOperationApprover2 {
	private DeployValidateEditHelper helper;

	/**
	 * A helper type that will provide UI integration when running in a UI environment.
	 * 
	 */
	public interface DeployValidateEditHelper {
		/**
		 * @return A Shell to allow UI prompting.
		 */
		Object getUIContext();

		/**
		 * @return A {@link List} of {@link IFile}s for diagram files being affected.
		 */
		List<IFile> getAffectedUIFiles();
	}

	/**
	 * Approves file modification for {@link IDeployModelObjectOperation}s.
	 */
	public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history,
			IAdaptable info) {

		if (operation instanceof IDeployModelObjectOperation) {
			return approveFileModification((IDeployModelObjectOperation) operation);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Approves file modification for {@link IDeployModelObjectOperation}s.
	 */
	public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history,
			IAdaptable info) {

		if (operation instanceof IDeployModelObjectOperation) {
			return approveFileModification((IDeployModelObjectOperation) operation);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Approves file modification for {@link IDeployModelObjectOperation}s.
	 */
	public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history,
			IAdaptable info) {

		if (operation instanceof IDeployModelObjectOperation) {
			return approveFileModification((IDeployModelObjectOperation) operation);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Checks that affected {@link IFile}s can be modified.
	 * 
	 * @return the approval status
	 */
	private IStatus approveFileModification(IDeployModelObjectOperation fileModifier) {

		List<IFile> files = new ArrayList<IFile>();

		IStatus status = processFiles(fileModifier.getAffectedFiles(), files);

		if (!status.isOK()) {
			return status;
		}

		Object context = null;
		if (helper != null) {
			status = processFiles(helper.getAffectedUIFiles(), files);
			if (!status.isOK()) {
				return status;
			}
			context = helper.getUIContext();
		}

		return ResourcesPlugin.getWorkspace().validateEdit(files.toArray(new IFile[] {}), context);

	}

	private IStatus processFiles(List<IFile> affectedFiles, List<IFile> files) {
		if (affectedFiles == null) {
			return Status.OK_STATUS;
		}
		for (Iterator<IFile> i = affectedFiles.iterator(); i.hasNext();) {
			IFile nextFile = i.next();

			if (nextFile == null) {
				continue;
			}

			if (nextFile.exists()) {
				// the file is in the workspace
				files.add(nextFile);

			} else {
				// the file is not in the workspace
				IPath path = nextFile.getRawLocation();
				if (path == null) {
					// cancel if we can't find the file
					return Status.CANCEL_STATUS;
				}
				File file = path.toFile();
				if (file != null && file.exists() && !file.canWrite()) {
					// cancel if we find a read-only file outside the
					// workspace
					return Status.CANCEL_STATUS;
				}
			}
		}
		return Status.OK_STATUS;
	}

	public void setHelper(DeployValidateEditHelper helper) {
		this.helper = helper;
	}

	public DeployValidateEditHelper getHelper() {
		return helper;
	}
}
