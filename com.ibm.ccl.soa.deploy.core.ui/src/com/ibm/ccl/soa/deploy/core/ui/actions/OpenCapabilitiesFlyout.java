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
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;

/**
 * Keybinding/Context Action which opens a unit's capabilities property page.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class OpenCapabilitiesFlyout extends UnitPropertyFlyoutHandler {

	public OpenCapabilitiesFlyout() {
		super();
	}

	/**
	 * @param wbPage
	 */
	public OpenCapabilitiesFlyout(IWorkbenchPage wbPage) {
		super(wbPage);
		setText(Messages.OpenCapabilitiesFlyout_Open_Capabilitie_);
		setId(DeployActionIds.ACTION_CAPABILITIES_FLYOUT);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.ACTION_CAPABILITIES_FLYOUT);
		setToolTipText(Messages.OpenCapabilitiesFlyout_Open_Capabilities_property_flyout_s_);
	}

	@Override
	protected void openFlyout(Shell shell, Unit unit, Point point) {
		CapabilitiesPopupDialog flyout = new CapabilitiesPopupDialog(shell, unit, point);
		new UnitFlyOutPropertiesToggler(unit, editPart.getViewer().getEditDomain(), flyout);
		flyout.open();
	}

	@Override
	protected void openFlyoutAndSelect(Shell shell, Unit unit, Point point, DeployModelObject dmo) {
		CapabilitiesPopupDialog flyout = new CapabilitiesPopupDialog(shell, unit, point);
		new UnitFlyOutPropertiesToggler(unit, editPart.getViewer().getEditDomain(), flyout);
		flyout.open();
		flyout.selectReveal(new StructuredSelection(dmo));
	}
}
