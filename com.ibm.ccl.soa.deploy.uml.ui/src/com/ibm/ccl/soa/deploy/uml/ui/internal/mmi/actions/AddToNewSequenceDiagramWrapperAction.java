package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;

import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class AddToNewSequenceDiagramWrapperAction extends Action {
	AddToNewSequenceDiagramAction addToNewSequenceDiagramAction = new AddToNewSequenceDiagramAction();

	private ISelection selection;

	public AddToNewSequenceDiagramWrapperAction(ISelection aSelection) {
		selection = aSelection;
	}

	@Override
	public void run() {
		addToNewSequenceDiagramAction.selectionChanged(this, selection);
		addToNewSequenceDiagramAction.run(this);
		super.run();
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return UmlUIMessages.AddToNewSequenceDiagramWrapperAction_Sequence_Diagra_;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
