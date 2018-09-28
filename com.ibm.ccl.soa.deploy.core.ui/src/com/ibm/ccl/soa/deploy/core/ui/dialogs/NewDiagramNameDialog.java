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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * Dialog for getting a new diagram name.
 */
public class NewDiagramNameDialog extends TitleAreaDialog {

	private final IFile _topologyFile;
	private Text _txtDiagramName;
	private String _diagramName;
	private String _baseName;

	/**
	 * @param parentShell
	 * @param topologyFile
	 * @param diagramName
	 */
	public NewDiagramNameDialog(Shell parentShell, IFile topologyFile, String diagramName) {
		super(parentShell);
		_topologyFile = topologyFile;
		_diagramName = getUniqueDiagramName(topologyFile, diagramName);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.VISUALIZE_NEW_TOPOLOGY_DIAGRAM);
		Composite composite = (Composite) super.createDialogArea(parent);

		getShell().setText(Messages.NewDiagramNameDialog_Enter_new_diagram_nam_);
		setTitle(Messages.NewDiagramNameDialog_Enter_the_name_of_the_new_diagra_);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addDiagramNameSection(composite);

		applyDialogFont(composite);

		initializeControls();

		return composite;
	}

	private void addDiagramNameSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label prompt1 = new Label(composite, SWT.NONE);
		prompt1.setText(Messages.NewDiagramNameDialog_Diagram_Name_);

		_txtDiagramName = new Text(composite, SWT.BORDER);
		_txtDiagramName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		_txtDiagramName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				String filename = _txtDiagramName.getText();
				String errorMsg = null;
				if (!ResourceUtils.isValidName(filename)) {
					errorMsg = Messages.NewDiagramNameDialog_Improper_filenam_;
				} else if (!isUniqueDiagramName(filename)) {
					errorMsg = Messages.NewDiagramNameDialog_Diagram_name_already_exists_;
				}
				setErrorMessage(errorMsg);
				Button btn = getButton(IDialogConstants.OK_ID);
				if (btn != null) {
					btn.setEnabled(errorMsg == null);
				}
			}
		});
	}

	private void initializeControls() {
		_txtDiagramName.setText(_diagramName);
		_txtDiagramName.setSelection(_baseName.length() + 1, _diagramName.length());
	}

	protected void okPressed() {
		_diagramName = _txtDiagramName.getText();
		super.okPressed();
	}

	/**
	 * @return diagram name
	 */
	public String getDiagramName() {
		return _diagramName;
	}

	private String getUniqueDiagramName(IFile topologyFile, String diagramNamePrime) {
		// come up with unique diagram name
		int i = 1;
		boolean exists;
		List<String> existingList = getExistingDiagramNames();
		_baseName = topologyFile.getName().substring(0, topologyFile.getName().lastIndexOf(".")); //$NON-NLS-1$ 
		String baseName = _baseName
				+ (diagramNamePrime != null ? "-" + diagramNamePrime : Messages.NewDiagramNameDialog_0_diagra_); //$NON-NLS-1$
		String diagramName = baseName;
		do {
			exists = false;
			diagramName = baseName + String.valueOf(i++);
			for (Iterator<String> it = existingList.iterator(); it.hasNext() && !exists;) {
				exists = it.next().equals(diagramName);
			}
		} while (exists);
		return diagramName;
	}

	private boolean isUniqueDiagramName(String diagramName) {
		// see if this name is unique
		for (String name : getExistingDiagramNames()) {
			if (name.equals(diagramName)) {
				return false;
			}
		}
		return true;
	}

	private List<String> getExistingDiagramNames() {
		// get all existing diagram file names
		IResource[] siblings = null;
		try {
			siblings = _topologyFile.getParent().members();
		} catch (CoreException e) {
		}
		List<String> existingList = new ArrayList<String>();
		for (int i = 0; i < siblings.length; i++) {
			IResource r = siblings[i];
			if (r instanceof IFile) {
				IFile file = (IFile) r;
				if (file.getFileExtension().equals(IConstants.TOPOLOGYV_EXTENSION)) {
					existingList.add(file.getName().substring(0, file.getName().lastIndexOf("."))); //$NON-NLS-1$
				}
			}
		}
		return existingList;
	}

}
