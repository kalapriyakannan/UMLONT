package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;

import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class AddToCurrentTopolgoyDiagramWrapperAction extends Action {
	AddToCurrentTopologyDiagramAction addToCurrentTopologyDiagramAction = new AddToCurrentTopologyDiagramAction();

	private ISelection selection;

	public AddToCurrentTopolgoyDiagramWrapperAction(ISelection aSelection) {
		selection = aSelection;
	}

	@Override
	public void run() {
		addToCurrentTopologyDiagramAction.selectionChanged(this, selection);
		addToCurrentTopologyDiagramAction.run(this);
		super.run();
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return UmlUIMessages.AddToCurrentTopolgoyDiagramWrapperAction_Add_to_Current_Diagra_;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
