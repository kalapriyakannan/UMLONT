package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixPrimaryDialog;

public class OpenQuickFixDialog extends UnitPropertyFlyoutHandler {

	public OpenQuickFixDialog() {
		super();
	}

	public OpenQuickFixDialog(IWorkbenchPage wbPage) {
		super(wbPage);
		setId(DeployActionIds.ACTION_OPEN_QUICK_FIX_DIALOG);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.ACTION_OPEN_QUICK_FIX_DIALOG);
	}

	@Override
	protected void openFlyout(Shell shell, Unit unit, Point point) {
		QuickFixPrimaryDialog dialog = new QuickFixPrimaryDialog(shell, unit, point, null, null,
				null, null, null, !CorePackage.Literals.IMPORT
						.isSuperTypeOf(unit.getEObject().eClass()));
		dialog.open();
	}

}
