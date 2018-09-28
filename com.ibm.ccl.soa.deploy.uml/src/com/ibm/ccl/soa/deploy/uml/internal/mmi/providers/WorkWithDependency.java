package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.delta.ModelChangeDelta;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class WorkWithDependency extends AbstractCommand {
	ModelChangeDelta delta;

	public WorkWithDependency(String label, ModelChangeDelta createDelta) {
		super(label);
		delta = createDelta;
	}

	private static Dependency _dependency = null;
	private static Model _model = null;
	private static Element _client;
	private static Element _supplier;

	/**
	 * Process a command involved in creating dependency. Compound command that creates dependency
	 * includes four different non-compound commands, specifying: <list>
	 * <li><b>packagedElement:</b> owner=model, value=dependency;
	 * <li><b>clientDependency:</b> owner=tail-end node, value=dependency;
	 * <li><b>client:</b> owner=dependency, value=tail-end node;
	 * <li><b>supplier:</b> owner=dependency, value=head-end element</list>
	 * <p>
	 * Each of these commands is issued separately and processed by this method. This method
	 * accumulates relevant info from these commands and creates StructuredReference once sufficient
	 * information has become available
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		if (delta.getOwner() instanceof Model
				&& delta.getFeature().getName().equals("packagedElement") //$NON-NLS-1$
				&& delta.getValue() instanceof Dependency) {
			setupForNewDependency((Model) delta.getOwner(), (Dependency) delta.getValue());
			StructuredReference modelReference = ModelStructuredReferenceHandler.getInstance()
					.constructStructuredReference(_model, _model);
			ITarget target = (ITarget) _model;
			target.activate(DeployModelMappingProvider.getInstance(), modelReference);
		} else if (delta.getFeature().getName().equals("client")) { //$NON-NLS-1$
			_client = (Element) delta.getValue();
		} else if (delta.getFeature().getName().equals("supplier")) { //$NON-NLS-1$
			_supplier = (Element) delta.getValue();
		} else if (delta.getOwner() instanceof Dependency
				&& delta.getFeature().getName().equals("name")) { //$NON-NLS-1$
			ITarget target = (ITarget) delta.getOwner();
			DependencyStructuredReferenceHandler.getInstance().setName(target,
					(String) delta.getValue());
			return CommandResult.newOKCommandResult();
		}
		if (_dependency != null && _model != null && _client != null && _supplier != null) {
			if (_dependency.getName() == null) {
				_dependency.setName(""); //$NON-NLS-1$
			}
			StructuredReference reference = DependencyStructuredReferenceHandler.getInstance()
					.constructStructuredReference(_model, _dependency.getName());
			ITarget target = (ITarget) _dependency;
			target.activate(DeployModelMappingProvider.getInstance(), reference);
		}
		return CommandResult.newOKCommandResult();
	}

	private void setupForNewDependency(Model model, Dependency dependency) {
		_model = model;
		_dependency = dependency;
		_client = null;
		_supplier = null;
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
