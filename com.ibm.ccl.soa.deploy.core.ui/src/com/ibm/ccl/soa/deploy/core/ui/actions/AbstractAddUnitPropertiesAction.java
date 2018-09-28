package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;

public abstract class AbstractAddUnitPropertiesAction extends DiagramAction {

	public AbstractAddUnitPropertiesAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	public AbstractAddUnitPropertiesAction(IWorkbenchPart workbenchpart) {
		super(workbenchpart);
	}

	protected Unit getSelectedUnit() {
		IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (win != null) {
			return getSelectedUnit(win.getSelectionService().getSelection());
		}
		return null;
	}

	private Unit getSelectedUnit(ISelection sel) {
		if (sel == null) {
			return null;
		}
		Unit retVal = null;
		DeployShapeNodeEditPart editPart;
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sel;
			if (selection.size() == 1) {
				Object element = selection.getFirstElement();
				if (element instanceof DeployShapeNodeEditPart) {
					editPart = (DeployShapeNodeEditPart) element;
					if (editPart.getModel() instanceof Node) {
						Node node = (Node) editPart.getModel();
						if (node.getElement() instanceof Unit) {
							retVal = (Unit) node.getElement();
						}
					}
				}
			}
		}
		return retVal;
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return false;
	}

	@Override
	public final void run() {
		final Unit owner = getSelectedUnit();
		if (owner == null) {
			return;
		}
		if (!canEditUnit(owner)) {
			//Unit is not editable so prompt the user.
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), getOperationTitle(),
					NLS.bind(Messages.AbstractAddUnitPropertiesAction_0_is_not_editable_, owner
							.getCaptionProvider().title(owner)));
			return;
		}
		final DeployModelObject newDmo = createDmo();
		if (newDmo == null) {
			return;
		}
		IUndoableOperation op = new DeployTransactionalCommand(owner, getOperationTitle()) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				return doRun(owner, newDmo);
			}

		};
		IUndoContext undoContext = LightweightOperationFactory.createContext(owner);
		DeployCoreUIPlugin.executeInContextWithProgress(undoContext, op, null);

		if (newDmo != null) {
			//Select the new Requirement.
			UnitPropertyFlyoutHandler flyoutHandler = createUnitPropertyFlyoutHandler();
			try {
				flyoutHandler.executeAndSelect(newDmo);
			} catch (ExecutionException e) {
			}
		}
	}

	protected boolean canEditUnit(final Unit owner) {
		return owner.isMutable();
	}

	@Override
	public void runWithEvent(Event event) {
		this.run();
	}

	protected abstract CommandResult doRun(Unit owner, DeployModelObject newDmo);

	protected abstract UnitPropertyFlyoutHandler createUnitPropertyFlyoutHandler();

	protected abstract DeployModelObject createDmo();

	protected abstract String getOperationTitle();
}
