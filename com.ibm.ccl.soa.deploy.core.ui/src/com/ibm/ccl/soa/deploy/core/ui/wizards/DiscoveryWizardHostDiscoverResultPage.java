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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;

/**
 * 
 * @author Ed Snible
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see TopologyDiscoveryWizard
 */
public class DiscoveryWizardHostDiscoverResultPage extends DataModelWizardPage {
	private CheckboxTreeViewer targetSelectTab;
	public static String PAGE_NAME = "HostResult"; //$NON-NLS-1$

	public DiscoveryWizardHostDiscoverResultPage(IDataModel model) {
		super(model, PAGE_NAME);
		setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_DESC);
		setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_TITLE);
	}

	protected boolean showValidationErrorsOnEnter() {
		return true;
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { ITopologyDiscoveryProperties.SELECTED_UNIT_DESCRIPTORS };
	}

	protected void enter() {
		super.enter();

		getDataModel().setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
				new Boolean(true));
	}

	protected Composite createTopLevelComposite(Composite parent) {
		/** Create UI controls */
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		targetSelectTab = new CheckboxTreeViewer(new Tree(top, SWT.CHECK | SWT.BORDER | SWT.SINGLE
				| SWT.FULL_SELECTION));
		Tree targetSelectTree = targetSelectTab.getTree();

		targetSelectTree.setLayoutData(new GridData(GridData.FILL_BOTH));
		targetSelectTree.setHeaderVisible(true);
		targetSelectTree.setLinesVisible(true);
		targetSelectTree.setEnabled(true);

		String[] COLUMN_PROPERTIES = new String[] {
				new String(""), //$NON-NLS-1$
				new String(""), //$NON-NLS-1$
				Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_COLUMN_SOURCE_NAME,
				Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_COLUMN_TARGET_NAME };

		targetSelectTab.setColumnProperties(COLUMN_PROPERTIES);

		TreeColumn checkBox = new TreeColumn(targetSelectTree, SWT.CHECK);
		checkBox.setText(COLUMN_PROPERTIES[0]);
		checkBox.setWidth(50);
		checkBox.setMoveable(false);

		TreeColumn hostType = new TreeColumn(targetSelectTree, SWT.LEFT); //TODO set icon
		hostType.setText(COLUMN_PROPERTIES[1]);
		hostType.setWidth(50);
		hostType.setMoveable(false);

		TreeColumn colSrc = new TreeColumn(targetSelectTree, SWT.LEFT);
		colSrc.setText(COLUMN_PROPERTIES[2]);
		colSrc.setWidth(100);
		colSrc.setMoveable(false);

		TreeColumn colHosts = new TreeColumn(targetSelectTree, SWT.LEFT);
		colHosts.setText(COLUMN_PROPERTIES[3]);
		colHosts.setWidth(200);
		colHosts.setMoveable(false);

		// Set content provider
		HostsSelectTreeContentProvider contentProvider = new HostsSelectTreeContentProvider();
		targetSelectTab.setContentProvider(contentProvider);

		// Set label provider
		HostsSelectTreeLabelProvider labelProvider = new HostsSelectTreeLabelProvider();
		targetSelectTab.setLabelProvider(labelProvider);

		// Set Cell Editors
		ComboBoxCellEditor cellEditor = new ComboBoxCellEditor(targetSelectTree, new String[] {},
				SWT.READ_ONLY);
		targetSelectTab.setCellEditors(new CellEditor[] { null, null, null, cellEditor });

		// Set Cell Modifier
		HostsSelectTreeCellModifier cellModifier = new HostsSelectTreeCellModifier(cellEditor);
		targetSelectTab.setCellModifier(cellModifier);

		getDataModel().setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
				new Boolean(true));
		targetSelectTab.setInput(getDataModel().getProperty(
				ITopologyDiscoveryProperties.POSSIBLE_UNIT_DESCRIPTORS));

		checkBoxViewerStateListener = new CheckBoxViewerListener();
		targetSelectTab.addCheckStateListener(checkBoxViewerStateListener);

		// Add "Select All" and "Deselect All" buttons
		createAdditionalButtonControls(top);

		Label legendLabel = new Label(top, SWT.NONE);
		legendLabel.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_LEGENT_LABEL);

		targetSelectTab.setAllChecked(true);
		updateSelectedUnitDescriptors();

		return top;
	}

	/**
	 * Add "Select All" and "Deselect All" buttons
	 * 
	 * @param parent
	 */
	private void createAdditionalButtonControls(Composite parent) {
		Composite btnComposite = new Composite(parent, SWT.NONE);
		btnComposite.setLayout(new GridLayout(2, false));

		Button selAllBtn = new Button(btnComposite, SWT.PUSH);
		selAllBtn.setText(Messages.TOPOLOGY_BTN_SELECT_ALL_TXT);
		selAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				targetSelectTab.setAllChecked(true);
			}
		});

		Button deselAllBtn = new Button(btnComposite, SWT.PUSH);
		deselAllBtn.setText(Messages.TOPOLOGY_BTN_DESELECT_ALL_TXT);
		deselAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				targetSelectTab.setAllChecked(false);
			}
		});
	}

	private class HostsSelectTreeContentProvider implements ITreeContentProvider {

		public Object[] getElements(Object inputElement) {
			Map possibleHostDescs = (Map) inputElement;

			return possibleHostDescs.entrySet().toArray();
		}

		public Object[] getChildren(Object parentElement) {
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private class HostsSelectTreeLabelProvider implements ITableLabelProvider, ILabelProvider {

		public String getColumnText(Object element, int columnIndex) {
			Map.Entry entry = (Map.Entry) element;
			if (columnIndex == 2) {
				Unit srcUnit = (Unit) entry.getKey();
				String displayName = srcUnit.getCaptionProvider().title(srcUnit);
				String name = srcUnit.getName();

				return displayName != null && displayName.length() > 0 ? displayName : name;
			}

			if (columnIndex == 3) {
				Unit srcUnit = (Unit) entry.getKey();
				List possibleHostDescs = (List) entry.getValue();
				if (possibleHostDescs.size() > 0) {
					UnitDescriptor unitDesc = (UnitDescriptor) possibleHostDescs.get(0);
					Unit targetUnit = unitDesc.getUnitValue();
					String displayName = targetUnit.getCaptionProvider().title(targetUnit);
					String name = targetUnit.getName();
					if (unitDesc.isInTopology(srcUnit.getTopology())) {
						return displayName != null && displayName.length() > 0 ? displayName : name;
					}

					return unitDesc.getDisplayName() + " *"; //$NON-NLS-1$
				}

				return Messages.TOPOLOGY_DISCOVERY_HOST_NOT_AVAILABLE;
			}

			return null;
		}

		public Image getColumnImage(Object element, int columnIndex) {
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

		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			return null;
		}
	}

	private class HostsSelectTreeCellModifier implements ICellModifier {
		private final ComboBoxCellEditor targetHostsCellEditor;

		/**
		 * @param targetHostsCellEditor
		 */
		public HostsSelectTreeCellModifier(ComboBoxCellEditor targetHostsCellEditor) {
			this.targetHostsCellEditor = targetHostsCellEditor;
		}

		public boolean canModify(Object element, String property) {
			Map.Entry entry = (Map.Entry) element;
			Unit srcUnit = (Unit) entry.getKey();
			List possibleHosts = (List) entry.getValue();
			if (possibleHosts.size() > 1) {
				// if the number of possible hosts is more than one
				String[] hostNameList = new String[possibleHosts.size()];
				for (int i = 0; i < possibleHosts.size(); i++) {
					UnitDescriptor hostDesc = (UnitDescriptor) possibleHosts.get(i);
					if (hostDesc.isInTopology(srcUnit.getTopology())) {
						hostNameList[i] = hostDesc.getUnitValue().getCaptionProvider().title(
								hostDesc.getUnitValue());
					} else {
						hostNameList[i] = hostDesc.getUnitValue().getCaptionProvider().title(
								hostDesc.getUnitValue())
								+ " *"; //$NON-NLS-1$
					}
				}
				targetHostsCellEditor.setItems(hostNameList);

				return true;
			}

			return false;
		}

		public Object getValue(Object element, String property) {
			return new Integer(0);
		}

		public void modify(Object element, String property, Object value) {
			Map.Entry entry = (Map.Entry) ((TreeItem) element).getData();
			List possibleHostDescs = (List) entry.getValue();
			String[] items = targetHostsCellEditor.getItems();

			int selectedIndex = ((Integer) value).intValue();
			if (selectedIndex != 0) {
				// Swap the first host desc and selected host desc
				Object tmp = possibleHostDescs.get(0);
				possibleHostDescs.set(0, possibleHostDescs.get(selectedIndex));
				possibleHostDescs.set(selectedIndex, tmp);

				// Swap the first item and selected item
				String tmpStr = items[0];
				items[0] = items[selectedIndex];
				items[selectedIndex] = tmpStr;
				targetHostsCellEditor.setItems(items);
				targetSelectTab.refresh(entry, true);
			}

			return;
		}
	}

	public void propertyChanged(DataModelEvent event) {
		super.propertyChanged(event);
		if (!isCurrentPage()) {
			return;
		}

		if (event.getPropertyName().equals(ITopologyDiscoveryProperties.POSSIBLE_UNIT_DESCRIPTORS)) {
			if (targetSelectTab != null) {
				targetSelectTab.setInput(getDataModel().getProperty(
						ITopologyDiscoveryProperties.POSSIBLE_UNIT_DESCRIPTORS));
				targetSelectTab.setAllChecked(true);
				targetSelectTab.refresh();
				updateSelectedUnitDescriptors();

			}
		}
	}

	private CheckBoxViewerListener checkBoxViewerStateListener;

	private class CheckBoxViewerListener implements ICheckStateListener {
		public void checkStateChanged(CheckStateChangedEvent event) {
			updateSelectedUnitDescriptors();
		}
	}

	private void updateSelectedUnitDescriptors() {
		Object[] items = targetSelectTab.getCheckedElements();

		Map selectedUnitDescrMap = new HashMap(items.length);
		for (int i = 0; i < items.length; i++) {
			Map.Entry entry = (Map.Entry) items[i];
			List possibleList = (List) entry.getValue();
			selectedUnitDescrMap.put(entry.getKey(), possibleList);
		}

		getDataModel().setProperty(ITopologyDiscoveryProperties.SELECTED_UNIT_DESCRIPTORS,
				selectedUnitDescrMap);
	}

	public boolean canFlipToNextPage() {
		return false;
	}
}
