/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.properties.AbstractTopologyPropertySection;

/**
 * Property section displaying General unit values.
 * 
 * @author NKruk
 * 
 * TODO code cleanup
 * 
 */
public class GeneralPropertySection extends AbstractTopologyPropertySection {
	DeployModelObject dmo;
	GeneralPropertyComposite composite;
	private Composite parentComposite;

	public void doCreateControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {

		parentComposite = parent;
		//parent.setLayout(new LyingLayout());
		setCsHelp();
		parent.setLayout(new LyingLayout());
		composite = new GeneralPropertyComposite(parent, SWT.NONE, getWidgetFactory());
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	private void setCsHelp() {
		if (parentComposite != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_GENERAL_TAB);
		}
	}

	@Override
	public void refresh() {
		// force a refresh
		if (composite != null) {
			composite.setInput(dmo);
		}
	}

	protected void setInput(DeployModelObject input) {
		if (dmo == input) {
			return;
		}
		dmo = input;

		if (dmo != null && composite != null) {
			setCsHelp();
			composite.setInput(dmo);
		}
	}

	public void doDispose() {
		if (composite != null) {
			composite.dispose();
		}
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}
}
