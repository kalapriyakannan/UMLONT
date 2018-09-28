/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.gef.EditDomain;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.GeneralPropertyFlyoutDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;

/**
 * Keybinding/Context Action which opens a unit's general property page.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class OpenGeneralPropertyFlyout extends UnitPropertyFlyoutHandler {

	public OpenGeneralPropertyFlyout() {
		super();
	}

	/**
	 * @param wbPage
	 */
	public OpenGeneralPropertyFlyout(IWorkbenchPage wbPage) {
		super(wbPage);
		setText(Messages.OpenGeneralPropertyFlyout);
		setId(DeployActionIds.ACTION_OPEN_GENERAL_PROPERTY_FLYOUT);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.ACTION_OPEN_GENERAL_PROPERTY_FLYOUT);
		setToolTipText(Messages.OpenGeneralPropertyFlout_Desc);
	}

	@Override
	protected void openFlyout(Shell shell, Unit unit, org.eclipse.swt.graphics.Point point) {
		EditDomain domain = editPart.getViewer().getEditDomain();
		GeneralPropertyFlyoutDialog flyout = new GeneralPropertyFlyoutDialog(shell, unit, point,
				domain);
		new UnitFlyOutPropertiesToggler(unit, domain, flyout);
		flyout.open();
	}

}
