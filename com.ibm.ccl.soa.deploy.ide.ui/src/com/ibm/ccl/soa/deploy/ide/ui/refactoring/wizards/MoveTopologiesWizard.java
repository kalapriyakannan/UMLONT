package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.ltk.core.refactoring.participants.MoveRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

public class MoveTopologiesWizard extends RefactoringWizard {

	public MoveTopologiesWizard(MoveRefactoring refactoring, String pageTitle) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE | PREVIEW_EXPAND_FIRST_NODE);
		setDefaultPageTitle(pageTitle);
	}

	@Override
	protected void addUserInputPages() {
		addPage(new MoveTopologiesWizardPage1(
				MoveTopologiesWizardPage1.PAGE_NAME));
	}

}
