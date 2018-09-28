package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

public class RenameTopologyWizard extends RefactoringWizard {

	private String initialValue = new String();

	public RenameTopologyWizard(RenameRefactoring refactoring, String pageTitle) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE | PREVIEW_EXPAND_FIRST_NODE);
		setDefaultPageTitle(pageTitle);
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	@Override
	protected void addUserInputPages() {
//		RenameTopologyParticipant processor = (RenameTopologyParticipant) ((RenameRefactoring) getRefactoring())
//				.getProcessor();
//		addPage(new RenameTopologyInputWizardPage(
//				Messages.RenameTopologyWizard_Rename_Topology_refactoring_wizard_, true, processor
//						.getDataModel().getTopology()));
	}

}
