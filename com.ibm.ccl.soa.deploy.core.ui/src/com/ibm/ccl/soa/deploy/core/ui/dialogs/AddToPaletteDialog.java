package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;

public class AddToPaletteDialog extends TrayDialog {
	private final AddToPaletteDataModel dataModel;

	protected AddToPaletteDialog(Shell shell, AddToPaletteDataModel dataModel) {
		super(shell);
		this.dataModel = dataModel;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		return super.createDialogArea(parent);
	}

}
