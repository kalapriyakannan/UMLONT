/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.wizards;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;

/**
 * This page is used for users to select source units to be discovered.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see TopologyDiscoveryWizard
 */
public class DiscoveryWizardSourceUnitSelectPage extends DataModelWizardPage {
	public static String PAGE_NAME = "SrcUnitSelectPage"; //$NON-NLS-1$
	private CheckboxTableViewer selectedUnitsList;

	public DiscoveryWizardSourceUnitSelectPage(IDataModel model) {
		super(model, PAGE_NAME);
		setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE1_TITLE);

		setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE1_DESC);
		model
				.setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
						new Boolean(false));
	}

	protected boolean showValidationErrorsOnEnter() {
		return true;
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { ITopologyDiscoveryProperties.SELECTED_ITEMS };
	}

	protected Composite createTopLevelComposite(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(top, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createSourceUnitComposite(composite);

		createAdditionalButtonControls(composite);

		return top;
	}

	private void createSourceUnitComposite(Composite parent) {

		Group sourceComposite = new Group(parent, SWT.NONE);
		sourceComposite.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE1_SOURCE_UNIT_SELECTION);
		sourceComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		sourceComposite.setLayout(new GridLayout());

		Table table = new Table(sourceComposite, SWT.CHECK | SWT.BORDER);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setLayout(new GridLayout());
		selectedUnitsList = new CheckboxTableViewer(table);
		selectedUnitsList.setContentProvider(new SrcUnitSelectTabContentProvider());
		selectedUnitsList.setLabelProvider(new SrcUnitSelectTabLabelProvider());
		selectedUnitsList.setInput(getDataModel().getProperty(
				ITopologyDiscoveryProperties.SELECTED_ITEMS));

		synchHelper.synchCheckBoxTableViewer(selectedUnitsList,
				ITopologyDiscoveryProperties.SELECTED_ITEMS, null);
	}

	private class SrcUnitSelectTabContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private class SrcUnitSelectTabLabelProvider implements ILabelProvider {
		public String getText(Object element) {
			Unit srcUnit = (Unit) element;
			String displayName = srcUnit.getCaptionProvider().title(srcUnit);
			String unitName = srcUnit.getName();

			if (displayName != null && displayName.length() > 0) {
				return displayName;
			}

			return unitName;
		}

		public Image getImage(Object element) {
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}
	}

	private void createAdditionalButtonControls(Composite parent) {
		/** Add "Select All" and "Deselect All" buttons */
		Composite btnComposite = new Composite(parent, SWT.NONE);
		btnComposite.setLayout(new GridLayout(2, false));

		Button selAllBtn = new Button(btnComposite, SWT.PUSH);
		selAllBtn.setText(Messages.TOPOLOGY_BTN_SELECT_ALL_TXT);
		selAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectedUnitsList.setAllChecked(true);
				updateSelectedItemsProperty();
			}
		});

		Button deselAllBtn = new Button(btnComposite, SWT.PUSH);
		deselAllBtn.setText(Messages.TOPOLOGY_BTN_DESELECT_ALL_TXT);
		deselAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectedUnitsList.setAllChecked(false);
				updateSelectedItemsProperty();
			}
		});
	}

	private void updateSelectedItemsProperty() {
		Object[] items = selectedUnitsList.getCheckedElements();
		getDataModel().setProperty(ITopologyDiscoveryProperties.SELECTED_ITEMS, items);
	}
}
