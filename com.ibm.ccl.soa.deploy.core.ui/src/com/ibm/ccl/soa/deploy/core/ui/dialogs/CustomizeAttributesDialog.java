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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.AttributesContractComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.ExtendedAttributesComposite2;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * Dialog for editing Extended Attributes
 * 
 * @author Ed Snible
 */
public class CustomizeAttributesDialog extends Dialog {

	private final DeployModelObject source;
	private ExtendedAttributesComposite2 eac;
	private AttributesContractComposite acc;
	private final boolean showContract;

	/**
	 * @param parentShell
	 * @param dmo
	 */
	public CustomizeAttributesDialog(Shell parentShell, DeployModelObject dmo) {
		this(parentShell, dmo, true);
	}

	/**
	 * @param parentShell
	 * @param dmo
	 * @param showContractSettings
	 */
	public CustomizeAttributesDialog(Shell parentShell, DeployModelObject dmo,
			boolean showContractSettings) {

		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.MAX);
		source = dmo;
		showContract = showContractSettings;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.ExtendedAttributeDialog_Customize_Attribute_);

	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(data);

		addCoreAttributesSection(composite);
		addExtendedAttributesSection(composite);

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
		acc.setInput(source);
	}

	private void addCoreAttributesSection(Composite parent) {

		Label l = new Label(parent, SWT.LEFT);
		l.setText(Messages.CustomizeAttributesDialog_Attribute_);
		acc = new AttributesContractComposite(parent, SWT.NULL, source, null, showContract);
	}

	private void addExtendedAttributesSection(Composite parent) {
		eac = new ExtendedAttributesComposite2(parent, SWT.NULL, source, source
				.getExtendedAttributes(), null, showContract);
		eac.setLayoutData(new GridData(GridData.FILL_BOTH));
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
				acc.performStatusChanges();
				source.getExtendedAttributes().removeAll(eac.removals());
				source.getExtendedAttributes().addAll(eac.additions());
				eac.performStatusChanges();
			}
		});

		super.okPressed();
	}

} // end class ExtendedAttributeDialog
