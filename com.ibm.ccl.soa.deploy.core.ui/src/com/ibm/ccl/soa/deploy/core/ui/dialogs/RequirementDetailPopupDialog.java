/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.DetailRequirementComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsPropertiesLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;

/**
 * The pop-up for a single {@link Requirement}'s details.
 * 
 * @author daberg
 * @see DetailRequirementComposite
 * @see RequirementsPopupDialog
 */
public class RequirementDetailPopupDialog extends PopupDialog implements
		RequirementLinkChangeHandler {
	private DetailRequirementComposite detailComposite;
	private final RequirementsPropertiesLabelProvider labelProvider;
	private boolean isFirstInputSet = true;
	protected FormToolkit toolkit;

	/**
	 * @param parent
	 * @param aLabelProvider
	 */
	public RequirementDetailPopupDialog(Shell parent,
			RequirementsPropertiesLabelProvider aLabelProvider) {
		super(parent, SWT.RESIZE, false, true, false, false, null, null);
		labelProvider = aLabelProvider;
	}

	public void setRequirement(Requirement requirement) {
		if (detailComposite != null) {
			detailComposite.setInput(requirement);
		}
	}

	public void setInterface(Interface interfaceObj) {
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_REQUIREMENTS_FLYOUT_DETAILS);

		toolkit = new TabbedPropertySheetWidgetFactory();
		detailComposite = new DetailRequirementComposite(parent, SWT.NONE, labelProvider, toolkit,
				true);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		detailComposite.setPopupDialog(true, this.getParentShell());
		return detailComposite;
	}

	int getAdjustedWidth(int currentWidth) {
		return currentWidth < 325 ? 325 : currentWidth;
	}

	@Override
	protected void adjustBounds() {
		Composite comp = (Composite) getContents();
		if (comp != null) {
			Point size = comp.getSize();
			if (size.x < 325 || size.y < 195) {
				getShell().setSize(getAdjustedWidth(size.x), size.y < 195 ? 195 : size.y);
			}
		}
	}

	public void setInput(Object obj) {
		detailComposite.setInput(obj);
		if (isFirstInputSet) {
			isFirstInputSet = false;
			getShell().pack();
		}
	}

	/*
	 * Overridden to force change of colors. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=136244
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.PopupDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		changeDefaultColors(parent);
		DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose((Composite) contents, this);
		return contents;
	}

	/*
	 * Set the colors of the popup. The contents have already been created.
	 */
	private void changeDefaultColors(Control control) {
		applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
				control);
		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
				control);
	}

	private void dispose() {
		if (detailComposite != null && !detailComposite.isDisposed()) {
			detailComposite.dispose();
		}
		if (toolkit != null) {
			toolkit.dispose();
		}
	}

	public boolean hasFocus() {
		if (detailComposite.isDisposed()) {
			return false;
		}
		return getShell().isFocusControl() || detailComposite.isFocusControl();
	}

	@Override
	public int open() {
		this.getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
		return super.open();
	}

	@Override
	protected List getBackgroundColorExclusions() {
		List exclusions = super.getBackgroundColorExclusions();
		if (detailComposite != null && !detailComposite.isDisposed()) {
			collectAllChildren(detailComposite, exclusions);
		}
		return exclusions;
	}

	private void collectAllChildren(Composite composite, Collection<Control> children) {
		for (Control control : composite.getChildren()) {
			if (control instanceof Composite) {
				children.add(control);
				collectAllChildren((Composite) control, children);
			} else {
				children.add(control);
			}
		}
	}

	public IStatus handleRequirementLinkChange(Notification notification) {
		if (detailComposite != null && !detailComposite.isDisposed()) {
			return detailComposite.handleRequirementLinkChange(notification);
		}
		return Status.OK_STATUS;
	}
}
