package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.providers.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class ConstrainTopologyDialog extends Dialog implements IDeployMMInterface {

	private final String topologyName;
	private final String resourceName;
	private Button remButton;

	public ConstrainTopologyDialog(Shell parentShell, String topologyName, String resourceName) {
		super(parentShell);
		this.topologyName = topologyName;
		this.resourceName = resourceName;

	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("UML - Topology validation"); //$NON-NLS-1$ 

	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		Label message = new Label(composite, SWT.WRAP);
		message.setText(getMessage());
		message.setFont(JFaceResources.getDefaultFont());
		GridData gd = new GridData();
		gd.widthHint = 300;
		message.setLayoutData(gd);
		Label dirtyNote = new Label(composite, SWT.WRAP);
		dirtyNote.setText(getDirtyMessage());
		GridData gdDirty = new GridData();
		gdDirty.verticalIndent = 5;
		dirtyNote.setLayoutData(gdDirty);
		GridData gdRem = new GridData();
		gdRem.verticalIndent = 10;
		gdRem.widthHint = 200;
		remButton = new Button(composite, SWT.CHECK | SWT.WRAP);
		remButton.setText(UmlUIMessages.ConstrainTopologyDialog_Remember_decisio_);
		remButton.setLayoutData(gdRem);
		remButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			public void widgetSelected(SelectionEvent e) {
				remButton.getSelection();
				setRememberPreference(remButton.getSelection());
			}
		});
		applyDialogFont(composite);
		return composite;
	}

	private String getMessage() {
		return NLS.bind(UmlUIMessages.ConstrainTopologyDialog_Use_0_to_validate_topology_1_2_,
				new Object[] { resourceName, topologyName });

	}

	private String getDirtyMessage() {
		// TODO Auto-generated method stub
		return UmlUIMessages.ConstrainTopologyDialog_Note_the_topology_resource_will_be_;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
		setConstraintPreference(true);
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
		setConstraintPreference(false);
	}

	public String getTopologyName() {
		return topologyName;

	}

	public void setRememberPreference(Boolean value) {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		store.setValue(REMEMBER_CONSTRAINT, value);
	}

	public void setConstraintPreference(Boolean value) {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		store.setValue(SHOULD_CONSTRAIN_KEY, value);
	}

	public Boolean getRememberPreference() {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		return store.getBoolean(REMEMBER_CONSTRAINT);
	}

	public Boolean getConstraintPreference() {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		return store.getBoolean(SHOULD_CONSTRAIN_KEY);
	}

}
