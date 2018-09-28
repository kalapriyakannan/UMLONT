/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigureFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatusGrouper;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.IDeployStatusGroupType;

public class InfoCompositeHandler extends CompositeHandler {

	private Button errorButton;
	private Button warningButton;
	private Button infoButton;
	private Label errorLabel;
	private Label warningLabel;
	private Label infoLabel;
	private boolean globalErrorEnable = true;
	private boolean globalWarningEnable = true;
	private boolean globalInfoEnable = true;

	public InfoCompositeHandler(FormToolkit toolKit, Section section) {
		super(toolKit, section);
	}

	protected Composite createClientComposite() {
		sectionClient = toolKit.createComposite(section, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 6;
		sectionClient.setLayout(layout);
		sectionClient.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		createErrorButton(sectionClient);
		createWarningButton(sectionClient);
		createInfoButton(sectionClient);
		return sectionClient;
	}

	private void createErrorButton(Composite sectionClient) {
		errorButton = toolKit.createButton(sectionClient, "", SWT.TOGGLE); //$NON-NLS-1$
		errorButton.setImage(ErrorMarkerFigureFactory.getFigureImage(IStatus.ERROR, true));
		errorButton.setLayoutData(commonButtonGridData());
		errorLabel = toolKit.createLabel(sectionClient, ""); //$NON-NLS-1$
		errorLabel.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		errorButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				globalErrorEnable = !globalErrorEnable;
				errorLabel.setEnabled(globalErrorEnable);
				notifyListeners(IStatus.ERROR, !globalErrorEnable);
			}
		});

	}

	private GridData commonButtonGridData() {
		GridData data = new GridData();
		data.heightHint = 20;
		data.widthHint = 20;
		return data;
	}

	private void createInfoButton(Composite sectionClient) {
		infoButton = toolKit.createButton(sectionClient, "", SWT.TOGGLE); //$NON-NLS-1$
		infoButton.setImage(ErrorMarkerFigureFactory.getFigureImage(IStatus.INFO, true));
		infoButton.setLayoutData(commonButtonGridData());

		infoLabel = toolKit.createLabel(sectionClient, ""); //$NON-NLS-1$
		infoLabel.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		infoButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				globalInfoEnable = !globalInfoEnable;
				infoLabel.setEnabled(globalInfoEnable);
				notifyListeners(IStatus.INFO, !globalInfoEnable);
			}
		});

	}

	public void update(DeployStatusGrouper grouper, boolean updateStatuNumbers) {
		if (!updateStatuNumbers) {
			return;
		}

		int error_count = grouper.getCount(IDeployStatusGroupType.GLOBAL, IStatus.ERROR);
		int warning_count = grouper.getCount(IDeployStatusGroupType.GLOBAL, IStatus.WARNING);
		int info_count = grouper.getCount(IDeployStatusGroupType.GLOBAL, IStatus.INFO);

		errorLabel.setText(getString(error_count, Messages.InfoCompositeHandler_error_));
		warningLabel.setText(getString(warning_count, Messages.InfoCompositeHandler_warning_));
		infoLabel.setText(getString(info_count, Messages.InfoCompositeHandler_information_message_));
		refresh();
	}

	private String getString(int error_count, String statusString) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(error_count);
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(statusString);
		return buffer.toString();
	}

	@Override
	public void enable(boolean enable) {
		section.setEnabled(enable);
		super.enable(enable);
	}

	private void createWarningButton(Composite sectionClient) {
		warningButton = toolKit.createButton(sectionClient, "", SWT.TOGGLE); //$NON-NLS-1$
		warningButton.setImage(ErrorMarkerFigureFactory.getFigureImage(IStatus.WARNING, true));
		warningButton.setLayoutData(commonButtonGridData());
		warningLabel = toolKit.createLabel(sectionClient, ""); //$NON-NLS-1$
		warningLabel.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		warningButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				globalWarningEnable = !globalWarningEnable;
				warningLabel.setEnabled(globalWarningEnable);
				notifyListeners(IStatus.WARNING, !globalWarningEnable);
			}
		});

	}

}
