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

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.ExtendedAttributesComposite2;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * Dialog for editing Extended Attributes
 * 
 * @author Ed Snible
 * @deprecated
 */
public class ExtendedAttributeDialog extends TrayDialog {

	//	private final EditDomain gefDomain;
	private final DeployModelObject source;
	private ExtendedAttributesComposite2 eac;

	/**
	 * @param parentShell
	 * @param dmo
	 */
	public ExtendedAttributeDialog(Shell parentShell, DeployModelObject dmo /* , EditDomain ed */) {
		super(parentShell);

		source = dmo;
		//		gefDomain = ed;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.ExtendedAttributeDialog_Customize_Attribute_);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_CUSTOMIZE_ATTR);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addExtendedAttributeSection(composite);

		initializeControls();

		applyDialogFont(composite);

		return composite;
	}

	//	protected Control createButtonBar(Composite parent) {
	//		Control c = super.createButtonBar(parent);
	//
	//		dialogChanged();
	//
	//		return c;
	//	}

	private void initializeControls() {
		eac.setInput(source, source.getExtendedAttributes());
		//		setTitle(NLS.bind(Messages.NewLinkDialog_Source_Unit_0_, name));
	}

	private void addExtendedAttributeSection(Composite parent) {

		eac = new ExtendedAttributesComposite2(parent, SWT.NULL, source, source
				.getExtendedAttributes());
	}

	//	private void dialogChanged() {
	//		updateStatus(null);
	//	}

	//	private void updateStatus(String message) {
	//		setErrorMessage(message);
	//		getButton(IDialogConstants.OK_ID).setEnabled(message == null);
	//	}

	protected void okPressed() {
		String msg = Messages.ExtendedAttributeDialog_Customize_Attribute_;
		PropertyUtils.executeWithUndo(source, msg, new Runnable() {

			public void run() {
				source.getExtendedAttributes().removeAll(eac.removals());
				source.getExtendedAttributes().addAll(eac.additions());
			}
		});

		super.okPressed();
	}

} // end class ExtendedAttributeDialog
