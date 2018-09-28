package com.ibm.ccl.soa.deploy.core.ui.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.GlobalActionManager;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalAction;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.edithelpers.ContainerEditHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class NavigatorDeleteFromModelHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		List<DeployModelObject> dmos = new ArrayList<DeployModelObject>();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			for (Iterator iter = extended.iterator(); iter.hasNext();) {
				Object sel = iter.next();
				if (sel instanceof EObject) {
					if (CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(
							((EObject) sel).eClass())) {
						DeployModelObject dmo = (DeployModelObject) sel;
						if (!PropertyUtils.isProxy(dmo)) {
							dmos.add(dmo);
						}
					}
				}
			}

			if (dmos.size() == extended.size()) {
				DeleteHelper helper = new DeleteHelper();
				ICommand delete = null;
				for (Iterator<DeployModelObject> iter = dmos.iterator(); iter.hasNext();) {
					DeployModelObject dmo = iter.next();
					ICommand cmd = helper
							.getDestroyCommand(dmo, HandlerUtil.getActivePartChecked(event));
					if (delete == null) {
						delete = cmd;
					} else {
						delete = delete.compose(cmd);
					}
				}

				if (delete != null && delete.canExecute()) {
					PropertyUtils.executeWithUndo(dmos.get(0), delete);
					CommandResult result = delete.getCommandResult();

					if (result != null && !result.getStatus().isOK()) {
						MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error Occurred", //$NON-NLS-1$
								result.getStatus().getMessage());
					}
				}
			}

		}

		return null;
	}

	class DeleteHelper extends ContainerEditHelper {

		public ICommand getDestroyCommand(DeployModelObject dmo, IWorkbenchPart part) {
			IResource resource = WorkbenchResourceHelper.getFile(dmo.eResource());
			TransactionalEditingDomain domain = getEditingDomain(resource);
			DestroyElementRequest req = new DestroyElementRequest(domain, dmo, false);
			ICommand cmd = super.getDestroyElementCommand(req);
			cmd.addContext(new ResourceUndoContext(domain, dmo.eResource()));
//			GlobalUndoAction undoAction = (GlobalUndoAction) getAction(GlobalActionId.UNDO, part);
//			undoAction.setUndoContext(new ResourceUndoContext(domain, dmo.eResource()));
			return cmd;
		}

		public TransactionalEditingDomain getEditingDomain(IResource resource) {
			IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE.getContext(resource
					.getProject());
			TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
					.getEditingDomain(context.getResourceSet());

			if (txdomain == null) {
				txdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(context
						.getResourceSet());
			}

			return txdomain;
		}

		/**
		 * Gets the specified global action for this view. If the GlobalActionManager already has the
		 * specidied global action for this view, it is used. Otherwise, the global action is created
		 * by the GlobalActionManager and returned.
		 * 
		 * @return the specified global action
		 */
		protected GlobalAction getAction(String id, IWorkbenchPart part) {
			GlobalAction globalAction = GlobalActionManager.getInstance().getGlobalAction(part, id);
			if (globalAction == null) {
				globalAction = GlobalActionManager.getInstance().createActionHandler(part, id);
			}
			return globalAction;
		}
	}
}
