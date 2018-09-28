/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.DataModelImpl;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;

/**
 * This page is for the select of the link types
 * 
 * @author <a href="mailto:guojg@cn.ibm.com">Jian Guang Guo</a>
 * @see TopologyDiscoveryWizard
 */
public class DiscoveryWizardLinkTypeSelectPage extends DataModelWizardPage {

	public static String PAGE_NAME = "TypeSelect"; //$NON-NLS-1$

	public DiscoveryWizardLinkTypeSelectPage(IDataModel model) {
		super(model, PAGE_NAME);
		setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_TITLE);
		setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_DESC);
	}

	protected boolean showValidationErrorsOnEnter() {
		return true;
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { ITopologyDiscoveryProperties.EXPAND_SEARCH };
	}

	protected void enter() {
		super.enter();
		model
				.setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
						new Boolean(false));
	}

	protected Composite createTopLevelComposite(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(top, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createTypeSelectComposite(composite);

		Button expandSearchBtn = createCheckButton(top,
				Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_EXPAND_SELECTION);
		expandSearchBtn.setSelection(true);

		return top;
	}

	private void createTypeSelectComposite(Composite parent) {
		Group sourceComposite = new Group(parent, SWT.NONE);
		sourceComposite.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_OPTION_SELECTION);
		sourceComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		sourceComposite.setLayout(new GridLayout());

		Button radio1 = createRadioButton(sourceComposite,
				Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_OPTION_HOSTING);
		radio1.setSelection(true);
		createRadioButton(sourceComposite,
				Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_OPTION_DEPENDENCY);
	}

	protected Button createRadioButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.RADIO);
		button.setText(text);
		button.setFont(parent.getFont());
		if (text.equals(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_OPTION_HOSTING)) {
			button.addSelectionListener(hostingLinkSelectionListener);
		} else {
			button.addSelectionListener(dependencyLinkSelectionListener);
		}
		return button;
	}

	protected Button createCheckButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(text);
		button.setFont(parent.getFont());
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				// Set the property for expanding search outside of current topology
				Button button = (Button) e.getSource();
				getDataModel().setProperty(ITopologyDiscoveryProperties.EXPAND_SEARCH,
						new Boolean(button.getSelection()));
			}
		});

		return button;
	}

	SelectionListener hostingLinkSelectionListener = new SelectionListener() {
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			DataModelImpl dataModel = (DataModelImpl) getDataModel();
			dataModel.setProperty(ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER,
					new Boolean(true));
			dataModel.setProperty(ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER,
					new Boolean(false));
		}
	};
	SelectionListener dependencyLinkSelectionListener = new SelectionListener() {
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			DataModelImpl dataModel = (DataModelImpl) getDataModel();
			dataModel.setProperty(ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER,
					new Boolean(false));
			dataModel.setProperty(ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER,
					new Boolean(true));
		}
	};

}
