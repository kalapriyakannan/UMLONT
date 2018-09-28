package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.RequirementsPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoPrimaryPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler.UnitFlyOutPropertiesTogglerDialog;

/**
 * Keybinding/Context Action which opens a unit's requirements property page.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class OpenRequirementsFlyout extends UnitPropertyFlyoutHandler {

	public OpenRequirementsFlyout() {
		super();
	}

	/**
	 * @param wbPage
	 */
	public OpenRequirementsFlyout(IWorkbenchPage wbPage) {
		super(wbPage);
		setText(Messages.OpenRequirementsFlyout_Open_Requirement_);
		setId(DeployActionIds.ACTION_OPEN_REQUIREMENTS_FLYOUT);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.ACTION_OPEN_REQUIREMENTS_FLYOUT);
		setToolTipText(Messages.OpenRequirementsFlyout_Open_Requirements_property_flyout_s_);
	}

	@Override
	protected void openFlyout(Shell shell, Unit unit, org.eclipse.swt.graphics.Point point) {
		DmoPrimaryPopupDialog flyout = new RequirementsPopupDialog(shell, unit, point);
		new UnitFlyOutPropertiesToggler(unit, editPart.getViewer().getEditDomain(),
				(UnitFlyOutPropertiesTogglerDialog) flyout);
		flyout.open();

	}

	@Override
	protected void openFlyoutAndSelect(Shell shell, Unit unit, Point point, DeployModelObject dmo) {
		RequirementsPopupDialog flyout = new RequirementsPopupDialog(shell, unit, point);
		new UnitFlyOutPropertiesToggler(unit, editPart.getViewer().getEditDomain(), flyout);
		flyout.create();
		flyout.open();
		flyout.selectReveal(new StructuredSelection(dmo));
	}

}
