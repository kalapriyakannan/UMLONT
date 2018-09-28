package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.infrastructure.internal.emf.Messages;

public class LightweightOperationFactory {

	public static IStatus execute(EditingDomain domain, IUndoableOperation operation) {
		return DeployCoreUIPlugin
				.executeInContextWithProgress(createContext(domain), operation, null);
	}

	public static IStatus execute(EObject context, IUndoableOperation operation) {
		return DeployCoreUIPlugin.executeInContextWithProgress(createContext(context), operation,
				null);
	}

	public static IStatus execute(EObject context, IUndoableOperation operation,
			IProgressMonitor monitor) {

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(Messages.Executing_operation, 10);
		IStatus status = null;
		try {
			IUndoContext undoContext = createContext(context);
			if (undoContext != null) {
				operation.addContext(undoContext);
			}

			status = getOperationHistory().execute(operation, monitor, null);

		} catch (ExecutionException e) {
			status = DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}
		return status;
	}

	public static IUndoContext createContext(EObject context) {
		if (context != null) {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(context);
			if (editingDomain != null) {
				return new EditingDomainUndoContext(editingDomain);
			}
		}
//		return EMFUndoContext.create(context);
		return null;
	}

	public static IUndoContext createContext(EditingDomain domain) {
		return new EditingDomainUndoContext(domain);
	}

	public static void undo(IUndoableOperation operation) {
		DeployCoreUIPlugin.undoWithProgress(operation, null);
	}

	public static IStatus undo(IUndoableOperation operation, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		IStatus status = null;

		try {
			status = getOperationHistory().undoOperation(operation, monitor, null);

		} catch (ExecutionException e) {
			status = DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}
		return status;
	}

	public static void redo(IUndoableOperation operation) {
		DeployCoreUIPlugin.redoWithProgress(operation, null);
	}

	public static IStatus redo(IUndoableOperation operation, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		IStatus status = null;
		try {
			status = getOperationHistory().redoOperation(operation, monitor, null);

		} catch (ExecutionException e) {
			status = DeployCoreUIPlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
		}
		return status;
	}

	/**
	 * Configure the undo context for the given operation
	 * 
	 * @param op
	 *           The operation about to be executed.
	 * @param eobj
	 *           The model object about to be modified.
	 */
	public static void addUndoContext(AbstractEMFOperation op, EObject eobj) {
		IUndoContext undoContext = createContext(eobj);
		if (undoContext != null) {
			op.addContext(undoContext);
		}
	}

//
//	public static IStatus undoLast(EObject context) {
//		IProgressMonitor monitor = null;
//		if (monitor == null) {
//			monitor = new NullProgressMonitor();
//		}
//
//		IStatus status = null;
//		try {
//			status = getOperationHistory().undo(createContext(context), monitor, null);
//
//		} catch (ExecutionException e) {
//			status = EMFInfrastructurePlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
//		}
//		return status;
//	}
//
//	public static IStatus redoLast(EObject context) {
//		IProgressMonitor monitor = null;
//		if (monitor == null) {
//			monitor = new NullProgressMonitor();
//		}
//		IStatus status = null;
//		try {
//			status = getOperationHistory().redo(createContext(context), monitor, null);
//
//		} catch (ExecutionException e) {
//			status = EMFInfrastructurePlugin.createErrorStatus(0, e.getLocalizedMessage(), e);
//		}
//		return status;
//	}

	private static IOperationHistory getOperationHistory() {
		return OperationHistoryFactory.getOperationHistory();
	}

}
