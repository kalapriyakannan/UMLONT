package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.delta.ModelChangeDelta;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class CreateOperation extends AbstractCommand {
	ModelChangeDelta delta;

	public CreateOperation(String label, ModelChangeDelta createDelta) {
		super(label);
		delta = createDelta;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		if (delta.getValue() instanceof Operation && delta.getOwner() instanceof NamedElement) {
			Operation operation = (Operation) delta.getValue();
			NamedElement element = (NamedElement) delta.getOwner();
			StructuredReference reference = OperationStructuredReferenceHandler.getInstance()
					.constructStructuredReference(element, operation.getName());
			ITarget target = (ITarget) operation;
			target.activate(DeployModelMappingProvider.getInstance(), reference);
		}
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		// TODO Auto-generated method stub
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		// TODO Auto-generated method stub
		return CommandResult.newOKCommandResult();
	}

	@Override
	public boolean canUndo() {
		return false;
	}

}
