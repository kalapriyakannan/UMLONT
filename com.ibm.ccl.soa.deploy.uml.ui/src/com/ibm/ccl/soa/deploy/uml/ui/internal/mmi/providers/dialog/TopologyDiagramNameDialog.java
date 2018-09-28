package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.providers.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;

public class TopologyDiagramNameDialog extends Dialog implements IDeployMMInterface{

	Text topologyNameText;
	String topologyName;

	public TopologyDiagramNameDialog(Shell parentShell, String topologyName) {
		super(parentShell);
		parentShell.setText(TOPOLOGY_NAME);
		this.topologyName = topologyName;
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);
		Label label = new Label(composite, SWT.WRAP);
		label.setText(TOPOLOGY_NAME);
		label.setFont(parent.getFont());
		topologyNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		topologyNameText.setText(topologyName);
		topologyNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		applyDialogFont(composite);
		return composite;
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
	   topologyName = topologyNameText.getText();
		super.buttonPressed(buttonId);
	}

	public String getTopologyName() {
		return topologyName;

	}
	

}
