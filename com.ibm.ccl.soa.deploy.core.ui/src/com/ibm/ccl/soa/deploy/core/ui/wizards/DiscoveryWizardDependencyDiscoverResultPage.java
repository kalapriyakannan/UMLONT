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

//import java.util.ArrayList;
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
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement; //import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit; //import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.Messages; //import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;

//import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
//import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
//import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
/**
 * This page is used to show possible target capabilities matching the dependency
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see TopologyDiscoveryWizard
 */
public class DiscoveryWizardDependencyDiscoverResultPage extends DataModelWizardPage {
	private CheckboxTreeViewer targetSelectTab;

	/**
	 * wizard page name
	 */
	public static String PAGE_NAME = "DependcyResult"; //$NON-NLS-1$

	private static int EXPAND_LEVEL = 2;

	public DiscoveryWizardDependencyDiscoverResultPage(IDataModel model) {
		super(model, PAGE_NAME);
		setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_DESC);
		setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_TITLE);
	}

	protected boolean showValidationErrorsOnEnter() {
		return true;
	}

	protected void enter() {
		super.enter();
		getDataModel().setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
				new Boolean(true));
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { ITopologyDiscoveryProperties.SELECTED_UNIT_DESCRIPTORS };
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
				Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_COLUMN_REQUIREMENT_NAME,
				Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_COLUMN_CAPABILITY_NAME };
		targetSelectTab.setColumnProperties(COLUMN_PROPERTIES);

		TreeColumn colSrc = new TreeColumn(targetSelectTree, SWT.LEFT);
		colSrc.setText(COLUMN_PROPERTIES[0]);
		colSrc.setWidth(200);
		colSrc.setMoveable(false);

		TreeColumn colHosts = new TreeColumn(targetSelectTree, SWT.LEFT);
		colHosts.setText(COLUMN_PROPERTIES[1]);
		colHosts.setWidth(300);
		colHosts.setMoveable(false);

		// Set content provider
		DependencySelectTreeContentProvider contentProvider = new DependencySelectTreeContentProvider();
		targetSelectTab.setContentProvider(contentProvider);

		// Set label provider
		DependencySelectTreeLabelProvider labelProvider = new DependencySelectTreeLabelProvider();
		targetSelectTab.setLabelProvider(labelProvider);

		// Set Cell Editors
		ComboBoxCellEditor cellEditor = new ComboBoxCellEditor(targetSelectTree, new String[] {},
				SWT.READ_ONLY);
		targetSelectTab.setCellEditors(new CellEditor[] { null, cellEditor });

		// Set Cell Modifier
		DependencySelectTreeCellModifier cellModifier = new DependencySelectTreeCellModifier(
				cellEditor);
		targetSelectTab.setCellModifier(cellModifier);

		getDataModel().setProperty(ITopologyDiscoveryProperties.HAVE_SELECT_DISCOVERY_TYPE,
				new Boolean(true));
		targetSelectTab.setInput(getDataModel().getProperty(
				ITopologyDiscoveryProperties.POSSIBLE_UNIT_DESCRIPTORS));

		checkBoxViewerStateListener = new CheckBoxViewerListener();
		targetSelectTab.addCheckStateListener(checkBoxViewerStateListener);

		targetSelectTab.expandToLevel(EXPAND_LEVEL);
		targetSelectTab.setAllChecked(true);

		Label legendLabel = new Label(top, SWT.NONE);
		legendLabel.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_LEGENT_LABEL);

		updateSelectedUnitDescriptors();

		return top;
	}

	private class DependencySelectTreeContentProvider implements ITreeContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Map) {
				return ((Map) inputElement).entrySet().toArray();
			}

			return null;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Map.Entry) // Unit -> List(Unit) 
			{
				// Get requirement -> capabilities map
				Map.Entry parent = (Map.Entry) parentElement;
				//				Unit srcUnit = (Unit)parent.getKey();
				//List targetUnitDescs = (List)parent.getValue();
				Map req2CapsMap = (Map) parent.getValue();
				//Map req2CapsMap = new HashMap();
				//				for(Iterator i=srcUnit.getRequirements().iterator(); i.hasNext(); ) {
				//					Requirement req = (Requirement)i.next();
				//					if (!(req.getLinkType().getValue() == RequirementLinkTypes.DEPENDENCY))
				//						continue;
				//					
				//					List targetCaps = new ArrayList();
				//					for(Iterator j=targetUnitDescs.iterator(); j.hasNext(); ) {
				//						UnitDescriptor targetUnitDesc = (UnitDescriptor)j.next();
				//						Unit targetUnit = targetUnitDesc.getUnitValue();
				//						List childCaps = targetUnit.getCapabilities();
				//						for(Iterator k=childCaps.iterator(); k.hasNext(); ) {
				//							Capability cap = (Capability)k.next();
				//							
				//							DeployValidatorService dvs= DeployValidatorService.getOrCreateValidatorService(DeployCoreEditor.VALIDATOR_SERVICE);
				//							if(dvs.canCreateLink(srcUnit, req, targetUnit, cap, LinkType.DEPENDENCY_SET).isOK()){
				//								targetCaps.add(cap);
				//							}
				//						}
				//					}
				//					
				//					if (targetCaps.size() > 0) {
				//						req2CapsMap.put(req, targetCaps);
				//					}
				//				}

				return req2CapsMap.entrySet().toArray(); //Req -> List(Capability)
			}

			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof Map.Entry) {
				Map.Entry entry = (Map.Entry) element;
				Object key = entry.getKey();
				if (key instanceof Unit) {
					return true;
				}
			}

			return false; // Req -> List(Cap)
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

	private class DependencySelectTreeLabelProvider implements ITableLabelProvider, ILabelProvider {

		public String getColumnText(Object element, int columnIndex) {
			if (!(element instanceof Map.Entry)) {
				return null;
			}

			Map.Entry entry = (Map.Entry) element;
			Object key = entry.getKey();
			Object value = entry.getValue();

			if (key instanceof Unit) {
				if (columnIndex == 0) {
					return ((Unit) key).getCaptionProvider().title((Unit) key);
				}
				if (columnIndex == 1) {
					return null;
				}
			}

			if (key instanceof Requirement) {
				if (columnIndex == 0) {
					return ((Requirement) key).getDisplayName();
				}
				if (columnIndex == 1) {
					List caps = (List) value;
					if (caps.size() > 0) {
						Requirement req = (Requirement) key;
						Capability cap = (Capability) caps.get(0);
						Unit srcUnit = (Unit) req.getParent();
						Unit targetUnit = (Unit) cap.getParent();
						String capDisplayName = cap.getCaptionProvider().title(cap);
						String targetUnitDisplayName = targetUnit.getCaptionProvider().title(targetUnit);

						if (srcUnit.getTopology() == targetUnit.getTopology()) {
							return targetUnitDisplayName + ":" + capDisplayName; //$NON-NLS-1$
						}

						return targetUnitDisplayName + ":" + capDisplayName + " *"; //$NON-NLS-1$ //$NON-NLS-2$
					}

					return null;
				}
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

	private class DependencySelectTreeCellModifier implements ICellModifier {
		private final ComboBoxCellEditor targetCellEditor;

		/**
		 * @param targetHostsCellEditor
		 */
		public DependencySelectTreeCellModifier(ComboBoxCellEditor targetHostsCellEditor) {
			targetCellEditor = targetHostsCellEditor;
		}

		public boolean canModify(Object element, String property) {
			if (!(element instanceof Map.Entry)) {
				return false;
			}

			Map.Entry entry = (Map.Entry) element;
			Object key = entry.getKey();
			Object value = entry.getValue();

			if (key instanceof Requirement) {
				Requirement req = (Requirement) key;
				Unit srcUnit = (Unit) req.getParent();
				List caps = (List) value;
				String[] capNames = new String[caps.size()];
				for (int i = 0; i < caps.size(); i++) {
					Capability cap = (Capability) caps.get(i);
					Unit targetUnit = (Unit) cap.getParent();
					String capDisplayName = cap.getCaptionProvider().title(cap);
					String targetUnitDisplayName = targetUnit.getCaptionProvider().title(targetUnit);

					if (srcUnit.getTopology() == targetUnit.getTopology()) {
						capNames[i] = targetUnitDisplayName + ":" + capDisplayName; //$NON-NLS-1$
					} else {
						capNames[i] = targetUnitDisplayName + ":" + capDisplayName + " *"; //$NON-NLS-1$ //$NON-NLS-2$
					}
				}

				targetCellEditor.setItems(capNames);

				if (caps.size() <= 1) {
					return false;
				}
				return true;
			}

			return false;
		}

		public Object getValue(Object element, String property) {
			return new Integer(0);
		}

		public void modify(Object element, String property, Object value) {
			Map.Entry entry = (Map.Entry) ((TreeItem) element).getData();
			List caps = (List) entry.getValue();
			String[] items = targetCellEditor.getItems();

			int selectedIndex = ((Integer) value).intValue();
			if (selectedIndex != 0) {
				Object tmp = caps.get(0);
				caps.set(0, caps.get(selectedIndex));
				caps.set(selectedIndex, tmp);

				String tmpStr = items[0];
				items[0] = items[selectedIndex];
				items[selectedIndex] = tmpStr;
				targetCellEditor.setItems(items);
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
				targetSelectTab.expandToLevel(EXPAND_LEVEL);
				targetSelectTab.setAllChecked(true);
				targetSelectTab.refresh();
				updateSelectedUnitDescriptors();
			}
		}
	}

	private CheckBoxViewerListener checkBoxViewerStateListener;

	private class CheckBoxViewerListener implements ICheckStateListener {

		public void checkStateChanged(CheckStateChangedEvent event) {
			StructuredViewer viewer = (StructuredViewer) event.getSource();
			CheckboxTreeViewer checkBoxTreeViewer = (CheckboxTreeViewer) viewer;

			Map.Entry selectEntry = (Map.Entry) event.getElement();
			Object selectkey = selectEntry.getKey();
			if (selectkey instanceof Unit) {
				TreeItem[] treeEntry = checkBoxTreeViewer.getTree().getItems();
				for (int i = 0; i < treeEntry.length; i++) {
					if (((Map.Entry) treeEntry[i].getData()).getKey().equals(selectkey)) {
						TreeItem[] childEntry = treeEntry[i].getItems();
						if (treeEntry[i].getChecked()) {
							for (int j = 0; j < childEntry.length; j++) {
								childEntry[j].setChecked(true);
							}
						} else {
							for (int j = 0; j < childEntry.length; j++) {
								childEntry[j].setChecked(false);
							}
						}
					}

				}

			}
			TreeItem[] treeEntry = checkBoxTreeViewer.getTree().getItems();
			for (int i = 0; i < treeEntry.length; i++) {
				TreeItem[] childEntry = treeEntry[i].getItems();
				boolean allChecked = true;
				for (int j = 0; j < childEntry.length; j++) {
					if (!childEntry[j].getChecked()) {
						allChecked = false;
					}
				}
				treeEntry[i].setChecked(allChecked);

			}

			updateSelectedUnitDescriptors();
		}
	}

	private void updateSelectedUnitDescriptors() {
		Object[] items = targetSelectTab.getCheckedElements();
		Map selectedReq2CapsMap = new HashMap();
		for (int i = 0; i < items.length; i++) {
			Map.Entry entry = (Map.Entry) items[i];
			Object key = entry.getKey();
			if (key instanceof Requirement) {
				List value = (List) entry.getValue();
				selectedReq2CapsMap.put(key, value);
			}

		}
		getDataModel().setProperty(ITopologyDiscoveryProperties.SELECTED_UNIT_DESCRIPTORS,
				selectedReq2CapsMap);
	}
}
