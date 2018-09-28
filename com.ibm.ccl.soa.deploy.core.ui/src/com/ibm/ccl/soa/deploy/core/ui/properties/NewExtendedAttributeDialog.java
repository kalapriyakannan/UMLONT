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

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
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

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.ui.composites.ExtendedAttributesComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Dialog for creating ExtendedAttributes
 * 
 * @author Ed Snible
 * @see ExtendedAttribute
 * @see CapabilitiesPropertySection
 * @see ExtendedAttributesComposite
 * @deprecated
 */
public class NewExtendedAttributeDialog extends TitleAreaDialog {

	private final DeployModelObject cap;

	private Text textName;
	private Button buttonString;
	private Button buttonInt;
	private Button buttonBoolean;
	private ExtendedAttribute result;

	private final String initialName;

	private final EDataType initialType;

	private final String originalName;

	private final List<ExtendedAttribute> additions;

	private final List<ExtendedAttribute> subtractions;

	/**
	 * @param parentShell
	 * @param cap
	 *           the Capability where the attribute is to live. Used to check for name collisions.
	 */
	public NewExtendedAttributeDialog(Shell parentShell, DeployModelObject cap) {
		this(parentShell, cap, null, null);
	}

	/**
	 * @param parentShell
	 * @param cap
	 *           the Capability where the attribute is to live. Used to check for name collisions.
	 * @param additions
	 * @param subtractions
	 */
	public NewExtendedAttributeDialog(Shell parentShell, DeployModelObject cap,
			List<ExtendedAttribute> additions, List<ExtendedAttribute> subtractions) {
		super(parentShell);

		this.cap = cap;
		this.additions = additions;
		this.subtractions = subtractions;
		initialName = Messages.CapabilitiesPropertySection_6;
		originalName = null;
		initialType = XMLTypePackage.eINSTANCE.getString();
	}

	/**
	 * @param shell
	 * @param cap
	 *           the Capability where the attribute is to live. Used to check for name collisions.
	 * @param ea
	 *           original ExtendedAttribute. It will not be modified.
	 */
	public NewExtendedAttributeDialog(Shell shell, DeployModelObject cap, ExtendedAttribute ea) {
		super(shell);

		this.cap = cap;
		initialName = ea.getName();
		originalName = ea.getName();
		initialType = ea.getInstanceType();
		additions = null;
		subtractions = null;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.CapabilitiesPropertySection_4);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_CUSTOMIZE_ATTR);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addBasicSection(composite);

		initializeControls();

		applyDialogFont(composite);

		return composite;
	}

	private void addBasicSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		Label labelNewAttrName = new Label(composite, SWT.LEFT);
		labelNewAttrName.setText(Messages.CapabilitiesPropertySection_5);

		textName = new Text(composite, SWT.BORDER);
		textName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		buttonString = new Button(composite, SWT.RADIO);
		buttonString.setText(Messages.NewExtendedAttributeDialog_STRING);

		buttonInt = new Button(composite, SWT.RADIO);
		buttonInt.setText(Messages.NewExtendedAttributeDialog_INTEGER);

		buttonBoolean = new Button(composite, SWT.RADIO);
		buttonBoolean.setText(Messages.NewExtendedAttributeDialog_BOOLEAN);

		ModifyListener nameListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		};

		textName.addModifyListener(nameListener);

	}

	private void initializeControls() {
		//		buttonString.setSelection(true);
		textName.setText(initialName);
		textName.setFocus();
		textName.selectAll();

		if (initialType == XMLTypePackage.eINSTANCE.getInteger()) {
			buttonInt.setSelection(true);
		} else if (initialType == XMLTypePackage.eINSTANCE.getBooleanObject()) {
			buttonBoolean.setSelection(true);
		} else {
			buttonString.setSelection(true);
		}
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		dialogChanged();

		return c;
	}

	private void dialogChanged() {
		// NOTE: This method must check that textName is a legal ExtendedAttribute
		// name.  I am assuming we only want to allow ExtendedAttributes to look like
		// Java identifiers, but this may be overly-restrictive.

		if (textName.getText().length() == 0) {
			updateStatus(Messages.NewExtendedAttributeDialog_INVALID_NAME);
			return;
		}

		if (!Character.isJavaIdentifierStart(textName.getText().charAt(0))) {
			updateStatus(Messages.NewExtendedAttributeDialog_INVALID_NAME);
			return;
		}

		for (int i = 1; i < textName.getText().length(); i++) {
			if (!Character.isJavaIdentifierPart(textName.getText().charAt(i))) {
				updateStatus(Messages.NewExtendedAttributeDialog_INVALID_NAME);
				return;
			}
		}

		if (duplicate(textName.getText())) {
			updateStatus(Messages.NewExtendedAttributeDialog_DUPLICATE_NAME);
			return;
		}

		updateStatus(null);
	}

	private boolean duplicate(String name) {
		// When editing, the name isn't a duplicate even if it exists -- the
		// original will be removed when the new ExtendedAttribute is created.
		if (name.equals(originalName)) {
			return false;
		}

		return PropertyUtils.hasAttribute(cap, name, additions, subtractions);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);

		Button b = getButton(IDialogConstants.OK_ID);
		if (b != null) {
			b.setEnabled(message == null);
		}
	}

	protected void okPressed() {
		result = CoreFactory.eINSTANCE.createExtendedAttribute();
		result.setName(textName.getText());

		// Note that it isn't safe to set the type without setting the value;
		// and setting the value implicitly sets the type.
		if (buttonString.getSelection()) {
			//			result.setInstanceType(EcorePackage.eINSTANCE.getEString());
			result.setValue(""); //$NON-NLS-1$
		} else if (buttonInt.getSelection()) {
			//			result.setInstanceType(EcorePackage.eINSTANCE.getEBigInteger());
			result.setValue(BigInteger.valueOf(0));
		} else {
			//			result.setInstanceType(EcorePackage.eINSTANCE.getEBoolean());
			result.setValue(Boolean.FALSE);
		}

		//		System.out.println(result.getValue());
		//		System.out.println();

		super.okPressed();
	}

	/**
	 * @return the ExtendedAttribute the user created by pressing OK
	 */
	public ExtendedAttribute getNewExtendedAttribute() {
		return result;
	}
} // end class NewCapabilityDialog
