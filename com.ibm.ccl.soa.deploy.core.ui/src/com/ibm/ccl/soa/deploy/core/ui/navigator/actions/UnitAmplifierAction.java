/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.ui.actions.UnitPropertyFlyoutHandler;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ProductVersionFlyOutSelectionDialog;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitAmplifierDescriptor;

/**
 * TopologyPublisherAction creates publisher actions based on the TopologyPublisherDescriptor.
 * 
 */
public class UnitAmplifierAction extends UnitPropertyFlyoutHandler {

	private final UnitAmplifierDescriptor unitAmplifierDescriptor;
	private final Shell shell;
	private final Unit unit;

	/**
	 * @param workbenchPage
	 * @param topologyPublisher
	 * @param topology
	 * 
	 * Creates TopologyPublisherAction based on the TopologyPublisherDescriptor
	 */
	public UnitAmplifierAction(IWorkbenchPage workbenchPage,
			UnitAmplifierDescriptor unitAmplifierDescriptor, Unit unit) {
		super(workbenchPage);
		shell = workbenchPage.getActiveEditor().getSite().getShell();
		setId(ActionIds.AMPLIFY_ACTION + unitAmplifierDescriptor.getName());
		setText(unitAmplifierDescriptor.getName());
		this.unitAmplifierDescriptor = unitAmplifierDescriptor;
		this.unit = unit;
	}

	public boolean isEnabled() {
		IStructuredSelection selection = (IStructuredSelection) page.getSelection();
		return selection != null && selection.size() == 1;

	}

	private String createAmplifierDialog(String existingValue, String[] objects, Point point) {
		ProductVersionFlyOutSelectionDialog selectionDialog = new ProductVersionFlyOutSelectionDialog(
				shell, unitAmplifierDescriptor.getName(), unitAmplifierDescriptor.getLabel(),
				unitAmplifierDescriptor.getDescription(), objects, 0, point, existingValue);
		selectionDialog.setBlockOnOpen(true);
		selectionDialog.open();
		String value = selectionDialog.getSelectedString();
		return value;

	}

	@Override
	protected void openFlyout(Shell shell, Unit unit, Point point) {
		try {
			UnitAmplifier amplifier = unitAmplifierDescriptor.createUnitAmplifier();
			if (amplifier == null) {
				return;
			}
			String[] objects = amplifier.getValues(unit);
			String existingValue = amplifier.getExistingProductConstraintValue(unit);
			String value = createAmplifierDialog(existingValue, objects, point);
			IStatus status = amplifier.modify(unit, value);
			if (status.getSeverity() != IStatus.OK) {
				//complain
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
