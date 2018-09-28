package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;

import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Creates the SetContractVisibilityAction pulldown toolbar menu.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class SetContractVisibilityToolbarAction extends BasicToolbarAction {

	public SetContractVisibilityToolbarAction() {
		super(Messages.SetContractVisibilityAction_Public_Editabl_, DeployCoreUIPlugin.getDefault()
				.getSharedImages().getImageDescriptor(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE),
				DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
						ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
	}

	@Override
	public void populateMenu(IWorkbenchPage activePage, Menu emptyMenu) {

		createMenuItem(SetContractVisibilityAction.createSetAllPublicEditableAction(activePage),
				emptyMenu);
		createMenuItem(SetContractVisibilityAction.createSetAllPublicAction(activePage), emptyMenu);
		createMenuItem(SetContractVisibilityAction.createSetAllPrivateAction(activePage), emptyMenu);

	}

	@Override
	public boolean isEnabled(IStructuredSelection selection) {
		for (Iterator iter = selection.iterator(); iter.hasNext();) {
			if (!isUnit(iter.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public IAction createDefaultAction(IWorkbenchPage activePage) {
		return SetContractVisibilityAction.createSetAllPublicEditableAction(activePage);
	}

	private boolean isUnit(Object element) {
		if (element instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
			if (editPart.getModel() instanceof Node) {
				Node node = (Node) editPart.getModel();
				if (node.getElement() instanceof Unit) {
					return true;
				}
			}
		}
		return false;
	}

}
