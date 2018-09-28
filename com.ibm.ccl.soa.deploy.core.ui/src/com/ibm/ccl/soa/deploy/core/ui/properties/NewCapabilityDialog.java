/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Dialog for creating Capabilities.
 * 
 * @author Ed Snible
 * @see Capability
 * @see CapabilitiesPropertySection
 * @deprecated
 */
public class NewCapabilityDialog extends Dialog {

	private Button buttonGeneric;
	private Button buttonLibrary;
	private List libraryCaps;
	private Capability newCap;
	private Text genCapName;

	/**
	 * @deprecated
	 * @param parentShell
	 */
	public NewCapabilityDialog(Shell parentShell) {
		super(parentShell);

	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.NewCapabilityDialog_ADD_CAPABILITY);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_ADD_CAPABILITY);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addBasicSection(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_CUSTOMIZE_ATTR);

		return composite;
	}

	private void addBasicSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		buttonGeneric = new Button(composite, SWT.RADIO);
		buttonGeneric.setText(Messages.NewCapabilityDialog_NEW_GENERIC_CAPABILITY);

		Composite compGenWrapper = new Composite(composite, SWT.NULL);
		compGenWrapper.setLayout(new GridLayout(2, false));
		Label labelNewCapName = new Label(compGenWrapper, SWT.LEFT);
		labelNewCapName.setText(Messages.NewCapabilityDialog_NAME_LABEL);
		genCapName = new Text(compGenWrapper, SWT.BORDER);

		//======================================================

		buttonLibrary = new Button(composite, SWT.RADIO);
		buttonLibrary.setText(Messages.NewCapabilityDialog_CAPABILITY_HEADING);

		SelectionListener buttonListener = new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				enableDisableButtons();
			}
		};

		buttonGeneric.addSelectionListener(buttonListener);

		Composite compCapWrapper = new Composite(composite, SWT.NULL);
		compCapWrapper.setLayout(new GridLayout(2, false));
		new Label(compCapWrapper, SWT.LEFT); // spacer 
		libraryCaps = new List(compCapWrapper, SWT.BORDER | SWT.V_SCROLL);
		GridData gd = new GridData();
		gd.heightHint = 250;
		libraryCaps.setLayoutData(gd);
	}

	private void initializeControls() {
		buttonGeneric.setSelection(true);
		genCapName.setText(Messages.NewCapabilityDialog_NEW_GENERIC_NAME);

		String[] capNames = PropertyUtils.getCapTypeNames().toArray(new String[0]);
		libraryCaps.setItems(capNames);
		libraryCaps.select(1);

		enableDisableButtons();
	}

	private void enableDisableButtons() {
		genCapName.setEnabled(buttonGeneric.getSelection());
		libraryCaps.setEnabled(buttonLibrary.getSelection());
	}

	/**
	 * @return the Capability the user created using the dialog
	 */
	public Capability getNewCapability() {
		return newCap;
	}

	protected void okPressed() {
		// TODO Problem the display names of the Requirement Expressions might no longer be correct....

		if (buttonGeneric.getSelection()) {
			newCap = CoreFactory.eINSTANCE.createCapability();
			if (newCap.getCaptionProvider().title(newCap) == null) {
				newCap.setDisplayName(genCapName.getText());
			}
			newCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			// Use GenericCapability instead of Capability, set gencap.type same as display name

			super.okPressed();
		} else {
			String ecName = libraryCaps.getSelection()[0];
			newCap = PropertyUtils.createCapability(ecName);
			if (newCap.getCaptionProvider().title(newCap) == null) {
				newCap.setDisplayName(ecName);
			}

			super.okPressed();
		}
	}
} // end class NewCapabilityDialog
