/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Customized deletion dialog
 * 
 */

public class DeployDeleteContainerDialog extends MessageDialog {
	private Button delContainedHosteesBtn;
	private Button delNonContainedHosteesBtn;
	private Button delMembersBtn;

	private boolean isDeleteContainedHostees;
	private boolean isDeleteNonContainedHostees;
	private boolean isDeleteMembers;

	private final boolean hasMember;
	private final boolean hasContainedHostee;
	private final boolean hasNonContainedHostee;

	private class UpdateController implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			updateDeleteControls();
		}

		/**
		 * Update delete option controls
		 */
		public void updateDeleteControls() {
			delMembersBtn.setEnabled(hasMember);
			delContainedHosteesBtn.setEnabled(hasContainedHostee);
			delNonContainedHosteesBtn.setEnabled(hasNonContainedHostee);
		}
	}

	private final UpdateController updateController;

	/**
	 * @param parentShell
	 * @param hasMember
	 * @param hasConfigHostee
	 * @param hasNonConfigHostee
	 * @param isDeleteViewOnly
	 */
	public DeployDeleteContainerDialog(Shell parentShell, boolean hasMember, boolean hasContainedHostee,
			boolean hasNonContainedHostee, boolean isDeleteViewOnly) {
		super(parentShell, NLS.bind(Messages.DEPLOY_DEL_DIALOG_TITLE,
				(isDeleteViewOnly ? Messages.DeployDeleteAction_Diagra_
						: Messages.DeployDeleteAction_Mode_)), null, NLS
				.bind(Messages.DEPLOY_DEL_DIALOG_MESSAGE,
						(isDeleteViewOnly ? Messages.DeployDeleteAction_Vie_
								: Messages.DeployDeleteAction_Uni_)), MessageDialog.WARNING, new String[] {
				IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
		this.hasMember = hasMember;
		this.hasContainedHostee = hasContainedHostee;
		this.hasNonContainedHostee = hasNonContainedHostee;

		updateController = new UpdateController();
	}

	/**
	 * @return isDeleteAllMembers
	 */
	public boolean isDeleteMembers() {
		return isDeleteMembers;
	}

	/**
	 * @return isDeleteAllHostees
	 */
	public boolean isDeleteContainedHostees() {
		return isDeleteContainedHostees;
	}

	/**
	 * @return isDeleteAllHostees
	 */
	public boolean isDeleteNonContainedHostees() {
		return isDeleteNonContainedHostees;
	}

	/**
	 * Set delete options before widget is disposed.
	 */
	public boolean close() {
		isDeleteMembers = delMembersBtn.getSelection();
		isDeleteContainedHostees = delContainedHosteesBtn.getSelection();
		isDeleteNonContainedHostees = delNonContainedHosteesBtn.getSelection();
		return super.close();
	}

	/**
	 * Add controls for delete options
	 */
	protected Control createCustomArea(Composite parent) {

		//parent.gets
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout(1, false));

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_DELETE_GROUP);

		top.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// Add the check box for delete contained hostee
		delContainedHosteesBtn = new Button(top, SWT.CHECK);
		delContainedHosteesBtn.setText(Messages.DeployDeleteDialog_Delete_configuration_unit_);
		delContainedHosteesBtn.addSelectionListener(updateController);
		delContainedHosteesBtn.setSelection(hasContainedHostee);
		delContainedHosteesBtn.setLayoutData(gd);
		// Add the check box for delete non contained hostee
		delNonContainedHosteesBtn = new Button(top, SWT.CHECK);
		delNonContainedHosteesBtn
				.setText(Messages.DeployDeleteDialog_Delete_non_configuration_hosted_uni_);
		delNonContainedHosteesBtn.addSelectionListener(updateController);
		delNonContainedHosteesBtn.setSelection(false);
		delNonContainedHosteesBtn.setLayoutData(gd);
		// Add the check box for delete all members
		delMembersBtn = new Button(top, SWT.CHECK);
		delMembersBtn.setText(Messages.DeployDeleteDialog_Delete_members_unit_);
		delMembersBtn.addSelectionListener(updateController);
		delMembersBtn.setSelection(hasMember);
		delMembersBtn.setLayoutData(gd);

		updateController.updateDeleteControls();

		return top;
	}
}
