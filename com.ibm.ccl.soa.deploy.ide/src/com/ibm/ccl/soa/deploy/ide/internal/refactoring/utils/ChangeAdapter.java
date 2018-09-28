package com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IAdvancedUndoableOperation;
import org.eclipse.core.commands.operations.IAdvancedUndoableOperation2;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

public class ChangeAdapter extends Change implements IUndoableOperation,
		IAdvancedUndoableOperation, IAdvancedUndoableOperation2 {

	private final IUndoableOperation operation;
	private final Object[] modifies;
	private final Operation action;
	private RefactoringChangeDescriptor descriptor;

	private final List fContexts = new ArrayList();

	public static enum Operation {
		EXECUTE, UNDO, REDO
	};

	public ChangeAdapter(IUndoableOperation operation, Object[] modifies, Operation action) {
		this.operation = operation;
		this.modifies = modifies;
		this.action = action == null ? Operation.EXECUTE : action;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getDescriptor()
	 */
	@Override
	public ChangeDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(RefactoringChangeDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public IUndoableOperation getUnderlyingOperation() {
		return operation;
	}

	@Override
	public Object getModifiedElement() {
		return modifies[0];
	}

	@Override
	public Object[] getAffectedObjects() {
		return modifies;
	}

	@Override
	public String getName() {

		String prefix = new String();
		if (action == Operation.UNDO) {
			prefix = "undo "; //$NON-NLS-1$
		} else if (action == Operation.REDO) {
			prefix = "redo "; //$NON-NLS-1$
		}

		return prefix + operation.getLabel();
	}

	@Override
	public void initializeValidationData(IProgressMonitor monitor) {
		// default empty implementation
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {

		RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);

		try {

			if (action == Operation.EXECUTE) {
				if (!operation.canExecute()) {
					if (operation instanceof IAdvancedUndoableOperation2) {
						status = RefactoringStatus.create(((IAdvancedUndoableOperation2) operation)
								.computeExecutionStatus(monitor));
					}
					status = RefactoringStatus.createErrorStatus("Cannot execute change."); //$NON-NLS-1$
				}
			} else if (action == Operation.UNDO) {
				if (!operation.canUndo()) {
					if (operation instanceof IAdvancedUndoableOperation2) {
						status = RefactoringStatus.create(((IAdvancedUndoableOperation) operation)
								.computeUndoableStatus(monitor));
					}

					status = RefactoringStatus.createErrorStatus("Cannot undo change."); //$NON-NLS-1$
				}
			} else if (action == Operation.REDO) {
				if (!operation.canRedo()) {
					if (operation instanceof IAdvancedUndoableOperation2) {
						status = RefactoringStatus.create(((IAdvancedUndoableOperation) operation)
								.computeRedoableStatus(monitor));
					}

					status = RefactoringStatus.createErrorStatus("Cannot redo change."); //$NON-NLS-1$
				}
			}

		} catch (ExecutionException ex) {
			throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, ex.toString(),
					ex));
		}

		if (status.isOK()) {
			status = validateEdit();
		}

		return status;
	}

	private List<IResource> getAffectedResources() {
		// adapt the array of affected objects to instances of IResource
		Object[] affected = getAffectedObjects();
		final List<IResource> resources = new ArrayList<IResource>(affected.length + 2);
		for (int i = 0; i < affected.length; i++) {
			IResource resource = (IResource) adapt(affected[i], IResource.class);
			if (!resources.contains(resource)) {
				resources.add(resource);
			}
		}

		return resources;
	}

	private RefactoringStatus validateEdit() {

		RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);
		final List<IFile> files = new ArrayList<IFile>();
		List<IResource> resources = getAffectedResources();
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (!files.contains(file)) {
					files.add(file);
				}
			}
		}

		if (files.size() > 0) {
			IStatus validate = ResourcesPlugin.getWorkspace().validateEdit(
					files.toArray(new IFile[files.size()]),
					DeployCorePlugin.getDefault().getDeployValidateEditHelper().getUIContext());
			if (!validate.isOK()) {
				RefactoringStatusEntry[] entries = RefactoringStatus.create(validate).getEntries();
				for (int i = 0; i < entries.length; i++) {
					status.addEntry(entries[i]);
				}
			}
		}

		return status;
	}

	@Override
	public Change perform(IProgressMonitor monitor) throws CoreException {

		try {

			IStatus status = executeDefaultOperationAction(monitor, PlatformUI.getWorkbench());

			if (!status.isOK()) {
				IStatus highest = getStatusWithHighestSeverity(status);
				Throwable error = highest.getException() != null ? highest.getException() : null;
				String message = error != null ? error.toString() : highest.getMessage();
				throw new CoreException(new Status(status.getSeverity(), IDEPlugin.PLUGIN_ID, message,
						error));
			}

			return getComplimentaryChange();

		} catch (ExecutionException ex) {
			throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, ex.toString(),
					ex));
		}
	}

	public String getLabel() {
		return operation.getLabel();
	}

	public boolean runInBackground() {
		return false;
	}

	public void setQuietCompute(boolean quiet) {
		// empty default implementation
	}

	public boolean hasContext(IUndoContext context) {
		return operation.hasContext(context);
	}

	public void removeContext(IUndoContext context) {
		operation.removeContext(context);
	}

	public IUndoContext[] getContexts() {
		return operation.getContexts();
	}

	public void addContext(IUndoContext context) {
		operation.addContext(context);
	}

	public boolean canExecute() {
		return operation.canExecute();
	}

	public boolean canRedo() {
		return operation.canRedo();
	}

	public boolean canUndo() {
		return operation.canUndo();
	}

	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		return operation.execute(monitor, info);
	}

	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		return operation.redo(monitor, info);
	}

	public IStatus computeRedoableStatus(IProgressMonitor monitor) throws ExecutionException {

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		if (operation instanceof IAdvancedUndoableOperation) {
			return ((IAdvancedUndoableOperation) operation).computeRedoableStatus(monitor);
		} else if (operation instanceof IAdvancedUndoableOperation2) {
			return ((IAdvancedUndoableOperation2) operation).computeExecutionStatus(monitor);
		} else if (!operation.canRedo()) {
			return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, "cannot redo operation", null); //$NON-NLS-1$
		}

		return Status.OK_STATUS;
	}

	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		return operation.undo(monitor, info);
	}

	public IStatus computeUndoableStatus(IProgressMonitor monitor) throws ExecutionException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		if (operation instanceof IAdvancedUndoableOperation) {
			return ((IAdvancedUndoableOperation) operation).computeUndoableStatus(monitor);
		} else if (operation instanceof IAdvancedUndoableOperation2) {
			return ((IAdvancedUndoableOperation2) operation).computeExecutionStatus(monitor);
		} else if (!operation.canUndo()) {
			return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, "cannot undo operation", null); //$NON-NLS-1$
		}

		return Status.OK_STATUS;
	}

	public IStatus computeExecutionStatus(IProgressMonitor monitor) throws ExecutionException {
		if (operation instanceof IAdvancedUndoableOperation2) {
			return ((IAdvancedUndoableOperation2) operation).computeExecutionStatus(monitor);
		}

		if (action == Operation.EXECUTE) {
			if (!operation.canExecute()) {
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0,
						"cannot execute operation", null); //$NON-NLS-1$
			}
		} else if (action == Operation.UNDO) {
			if (!operation.canUndo()) {
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, "cannot undo operation", null); //$NON-NLS-1$
			}
		} else if (action == Operation.REDO) {
			if (!operation.canRedo()) {
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, "cannot redo operation", null); //$NON-NLS-1$
			}
		}

		return Status.OK_STATUS;
	}

	protected IStatus executeDefaultOperationAction(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		IStatus status = Status.OK_STATUS;
		IEditModelScribbler scribbler = null;

		try {

			try {
				List<IResource> resources = getAffectedResources();
				scribbler = IEditModelFactory.eINSTANCE.createScribblerForWrite(resources.get(0)
						.getProject(), new ChangeScribblerDomain(resources));
			} catch (EditModelException ex) {
				throw new ExecutionException(ex.toString(), ex);
			}

			if (action == Operation.REDO) {
				status = operation.redo(monitor, info);
			} else if (action == Operation.UNDO) {
				status = operation.undo(monitor, info);
			} else {
				status = operation.execute(monitor, info);
			}

			if (status.isOK()) {
				try {
					scribbler.save(false, new SubProgressMonitor(monitor, 1));
				} catch (EditModelException ex) {
					throw new ExecutionException(ex.toString(), ex);
				}
			}

		} finally {
			if (null != scribbler) {
				try {
					scribbler.close(new SubProgressMonitor(monitor, 1));
				} catch (EditModelException ex) {
					throw new ExecutionException(ex.toString(), ex);
				}
			}
		}

		return status;
	}

	protected Change getComplimentaryChange() {

		Operation compliment = Operation.UNDO;

		if (action == Operation.UNDO) {
			compliment = Operation.REDO;
		}

		return new ChangeAdapter(operation, modifies, compliment);
	}

	private Object adapt(Object adaptable, Class adapter) {
		if (null == adaptable) {
			return null;
		}
		Object adapted = null;
		if (adaptable instanceof IAdaptable) {
			adapted = ((IAdaptable) adaptable).getAdapter(adapter);
		}
		if (null == adapted) {
			adapted = Platform.getAdapterManager().getAdapter(adaptable, adapter);
		}
		return adapted;
	}

	protected IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

	public void aboutToNotify(OperationHistoryEvent event) {
		switch (event.getEventType())
		{
		case OperationHistoryEvent.ABOUT_TO_EXECUTE:
		case OperationHistoryEvent.ABOUT_TO_UNDO:
		case OperationHistoryEvent.ABOUT_TO_REDO:
		case OperationHistoryEvent.DONE:
		case OperationHistoryEvent.UNDONE:
		case OperationHistoryEvent.REDONE:
		case OperationHistoryEvent.OPERATION_NOT_OK:
			ResourcesPlugin.getWorkspace().checkpoint(false);
			break;
		}
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (IUndoableOperation.class.isAssignableFrom(adapter)) {
			return operation;
		}

		return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		super.dispose();
		SafeRunner.run(new ISafeRunnable() {
			@SuppressWarnings("restriction")
			public void run() throws Exception {
				if (null != operation) {
					operation.dispose();
				}
			}

			public void handleException(Throwable ex) {
				IDEPlugin.logError(0, ex.toString(), ex);
			}
		});
	}
}
