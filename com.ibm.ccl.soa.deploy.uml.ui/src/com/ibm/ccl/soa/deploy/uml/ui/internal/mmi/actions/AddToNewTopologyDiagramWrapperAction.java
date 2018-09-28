package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;

import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class AddToNewTopologyDiagramWrapperAction extends Action {
	AddToNewTopologyDiagramAction addToNewTopologyDiagramAction = new AddToNewTopologyDiagramAction();

	private ISelection selection;

	public AddToNewTopologyDiagramWrapperAction(ISelection aSelection) {
		selection = aSelection;
	}

	@Override
	public void run() {
		addToNewTopologyDiagramAction.selectionChanged(this, selection);
		addToNewTopologyDiagramAction.run(this);
		super.run();
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return UmlUIMessages.AddToNewTopologyDiagramWrapperAction_Topology_Diagra_;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
