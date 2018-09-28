/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * UI for managing the contract status of EAttributes.
 * 
 * <p>
 * The UI is a table. The first column is the name, the second is the type, the third is the
 * contract.
 */
public class AttributesContractComposite extends Composite {

	private static final String NAME_COL = "Name"; //$NON-NLS-1$
	private static final String TYPE_COL = "Type"; //$NON-NLS-1$
	private static final String CONTRACT_COL = "Contract"; //$NON-NLS-1$
	private static final String MUTABLE_COL = "is Mutable"; //$NON-NLS-1$
	private static final String[] COLUMN_NAMES = new String[] { NAME_COL, TYPE_COL, CONTRACT_COL,
			MUTABLE_COL };

	private boolean isMutable = false;
	private static final int PUBLIC_EDITABLE = 1;
//	private static final int PUBLIC = 1;
	private static final int PRIVATE = 0;

	private final FormToolkit formToolkit;

	private DeployModelObject dmo;
//	private boolean mutable;

	private TableViewer tviewer;
	private HashMap<EStructuralFeature, Integer> contractMap;
	private HashMap<EAttribute, IItemPropertyDescriptor> descriptors;

	private final String[] contractTypes = { Messages.GeneralDmoSyncHelperModel_Private_,
			Messages.GeneralDmoSyncHelperModel_Public_Editable_ };
	private final boolean showContract;

	/**
	 * Variant that doesn't use FormToolkit, creates composites using SWT
	 * 
	 * @param parent
	 * @param dmo
	 *           used to verify no collision in attribute names; EAs will not be touched
	 * @param style
	 */
	public AttributesContractComposite(Composite parent, int style, DeployModelObject dmo) {
		this(parent, style, dmo, null, true);
	}

	/**
	 * @param parent
	 * @param style
	 * @param dmo
	 *           used to verify no collision in attribute names; EAs will not be touched
	 * @param ft
	 * @param showContractSettings
	 */
	public AttributesContractComposite(Composite parent, int style, DeployModelObject dmo,
			FormToolkit ft, boolean showContractSettings) {
		super(parent, style);
		Topology topology = dmo.getEditTopology();
		isMutable = topology.isMutabilityConfigurable();
		formToolkit = ft;
		showContract = showContractSettings;
		setLayout(new GridLayout());
		setLayoutData(new GridData(GridData.FILL_BOTH));

		createTable(this);

		setInput(dmo);
		//		setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GREEN));
	}

	/**
	 * @param dmo
	 */
	public void setInput(DeployModelObject dmo) {
		this.dmo = dmo;
		determineCurrentContracts();
		setupDescriptors();
		tviewer.setInput(dmo);
//		enableDisableControls();
	}

	private void createTable(Composite parent) {
//		SelectionListener selectionListener = new SelectionAdapter() {
//
//			public void widgetSelected(SelectionEvent e) {
//				enableDisableControls();
//			}
//		};

		Table table;
		if (formToolkit != null) {
			table = formToolkit.createTable(parent, SWT.MULTI | SWT.FULL_SELECTION | SWT.V_SCROLL);
		} else {
			table = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		}

//		table.addSelectionListener(selectionListener);

		//		ConstraintMouseListener listener = new ConstraintMouseListener();
		//		table.addMouseTrackListener(listener);
		//		table.addMouseListener(listener);

		TableLayout tlAttribs = new TableLayout();
		tlAttribs.addColumnData(new ColumnWeightData(45)); // name
		tlAttribs.addColumnData(new ColumnWeightData(45)); // type
		if (showContract) {
			tlAttribs.addColumnData(new ColumnWeightData(45)); // contract
		}
		if (isMutable) {
			tlAttribs.addColumnData(new ColumnWeightData(20)); // type
		}
		table.setLayout(tlAttribs);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] colHeadersAttrib = new String[0];

		if (showContract && isMutable) {
			colHeadersAttrib = new String[] { Messages.RequirementsPropertySection5_Nam_,
					Messages.AttributesContractComposite_Typ_,
					Messages.ExtendedAttributesComposite2_Contrac_,
					Messages.ExtendedAttributesComposite2_is_Mutabl_ };
		}
		if (!showContract && isMutable) {
			colHeadersAttrib = new String[] { Messages.RequirementsPropertySection5_Nam_,
					Messages.AttributesContractComposite_Typ_,
					Messages.ExtendedAttributesComposite2_is_Mutabl_ };
		}

		if (showContract && !isMutable) {
			colHeadersAttrib = new String[] { Messages.RequirementsPropertySection5_Nam_,
					Messages.AttributesContractComposite_Typ_,
					Messages.ExtendedAttributesComposite2_Contrac_ };
		}

		for (int i = 0; i < colHeadersAttrib.length; i++) {
			TableColumn col = new TableColumn(table, SWT.LEFT);
			col.setText(colHeadersAttrib[i]);
			col.setWidth(115);
		}

		tviewer = new TableViewer(table);
		tviewer.setContentProvider(new AttributeTableProvider());
		tviewer.setLabelProvider(new AttributeContractTableLabelProvider());

		GridData gdTable = new GridData(GridData.FILL_BOTH);
		gdTable.minimumHeight = 85;
		table.setLayoutData(gdTable);

		attachCellEditors();
	}

//	protected void enableDisableControls() {
//		List<ExtendedAttribute> extendedAttribute = getSelectedExtendedAttributes();
//		//		ExtendedAttribute first = extendedAttribute != null && extendedAttribute.size() > 0 ? extendedAttribute.get(0) : null;
//
//		boolean selected = extendedAttribute != null;
//		buttonAdd.setEnabled(mutable);
//		buttonDel.setEnabled(mutable && selected);
//	}

//	private List<ExtendedAttribute> getSelectedExtendedAttributes() {
//		if (tviewer.getSelection() instanceof StructuredSelection) {
//			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
//			if (ss.getFirstElement() instanceof ExtendedAttribute) {
//				return ss.toList();
//			}
//		}
//
//		return null;
//	}

	private void attachCellEditors() {
		// Assign 'names' to each column
		tviewer.setColumnProperties(COLUMN_NAMES);

		Table table = tviewer.getTable();
		tviewer.setCellEditors(new CellEditor[] { new TextCellEditor(table, SWT.LEFT), // name
				new TextCellEditor(table, SWT.LEFT), // type
				new ComboBoxCellEditor(table, contractTypes, SWT.READ_ONLY), // contract
				new CheckboxCellEditor(table, SWT.FILL) });

		tviewer.setCellModifier(new AttributeContractModifier());
	}

	private void determineCurrentContracts() {
		contractMap = new HashMap<EStructuralFeature, Integer>();
		for (EAttribute ea : dmo.eClass().getEAllAttributes()) {
			if (suitable(ea)) {
				ConfigurationContract contract = dmo.getTopology().getConfigurationContract();
				boolean publicEditable = contract != null
						&& contract.isPublicEditable(dmo, ea.getName());
				if (!publicEditable) {
					contractMap.put(ea, PRIVATE);
				} else {
					contractMap.put(ea, PUBLIC_EDITABLE);
				}
			}
		}
	}

	private void setupDescriptors() {
		descriptors = new HashMap<EAttribute, IItemPropertyDescriptor>();
		IItemPropertySource ips = getPropertySource();
		if (ips != null) {
			for (IItemPropertyDescriptor ipd : ips.getPropertyDescriptors(dmo)) {
				EAttribute ea = (EAttribute) ipd.getFeature(dmo);
				if (contractMap.get(ea) != null) {
					descriptors.put(ea, ipd);
				}
			}
		}
	}

	/**
	 * Get the EMF.Edit ItemPropertySource for the {@link DeployModelObject}.
	 * 
	 * @return an EMF.Edit descriptor with useful stuff like translated display name and description
	 */
	protected IItemPropertySource getPropertySource() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(dmo,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

	private String getName(EAttribute ea) {
		IItemPropertyDescriptor ipd = descriptors.get(ea);
		return ipd != null ? ipd.getDisplayName(dmo) : ea.getName();
	}

	private int getContractStatusInt(EStructuralFeature esf) {
		return contractMap.get(esf).intValue();
	}

	private String getContractStatus(EStructuralFeature esf) {
		int status = getContractStatusInt(esf);
		if (status == PRIVATE) {
			return Messages.GeneralDmoSyncHelperModel_Private_;
//		} else if (status == PUBLIC) {
//			return Messages.GeneralDmoSyncHelperModel_Public_;
		} else if (status == PUBLIC_EDITABLE) {
			return Messages.GeneralDmoSyncHelperModel_Public_Editable_;
		}

		throw new IllegalStateException();
	}

	/**
	 * 
	 */
	public void performStatusChanges() {
		ConfigurationContract contract = dmo.getTopology().getConfigurationContract();
		if (contract == null) {
			return;
		}

		for (Map.Entry<EStructuralFeature, Integer> me : contractMap.entrySet()) {
			if (me.getValue().intValue() == PRIVATE) {
				if (contract.isPublicEditable(dmo, me.getKey().getName())) {
					contract.unexport(dmo, me.getKey());
				}
			} else if (me.getValue().intValue() == PUBLIC_EDITABLE) {
				if (!contract.isPublicEditable(dmo, me.getKey().getName())) {
					contract.export(dmo, me.getKey());
				}
			}
		}
	}

	private boolean suitable(EAttribute ea) {
		if (ea.getUpperBound() != 1) {
			return false;
		}

		if (ea == CorePackage.Literals.DEPLOY_MODEL_OBJECT__MUTABLE
				|| ea == CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME
				|| ea == CorePackage.Literals.CAPABILITY__LINK_TYPE
				|| ea == CorePackage.Literals.CAPABILITY__ORIGIN
				|| ea == CorePackage.Literals.CAPABILITY__BUILD_VERSION) {
			return false;
		}

		return true;
	}

	//	/**
	//	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
	//	 * 1. the list of Capabilities changing<br>
	//	 * 2. the name changing for the current capability.
	//	 */
	//	private final ResourceSetListenerImpl eventListener = new ResourceSetListenerImpl(getFilter()) {
	//
	//		public void resourceSetChanged(ResourceSetChangeEvent event) {
	//
	//			// We just assume, if we get a notification 
	//			boolean extendedAttributeListStale = false;
	//
	//			//
	//			for (Iterator<Notification> it = event.getNotifications().iterator(); it.hasNext()
	//					&& !extendedAttributeListStale;) {
	//				Notification notif = it.next();
	//
	//				extendedAttributeListStale |= notif.getFeature() == CorePackage.eINSTANCE
	//						.getDeployModelObject_ExtendedAttributes();
	//				extendedAttributeListStale |= notif.getNotifier() instanceof ExtendedAttribute;
	//			}
	//
	//			if (extendedAttributeListStale && !tviewer.getTable().isDisposed()) {
	//				// If any of the notifications changed the {@link Unit#getCapabilityGroup} ref, refresh table
	//				Display.getDefault().asyncExec(new Runnable() {
	//					public void run() {
	//						tviewer.refresh(true);
	//
	//						enableDisableControls();
	//					}
	//				});
	//			}
	//		}
	//
	//		public boolean isPostcommitOnly() {
	//			return true;
	//		}
	//
	//	};
	//
	//	private NotificationFilter getFilter() {
	//		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
	//				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
	//				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
	//		return retVal;
	//	}

	private class AttributeTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DeployModelObject) {
				DeployModelObject dmoInput = (DeployModelObject) inputElement;

				List<EAttribute> retVal = new LinkedList<EAttribute>();
				for (EAttribute ea : dmoInput.eClass().getEAllAttributes()) {
					if (suitable(ea)) {
						retVal.add(ea);
					}
				}
				return retVal.toArray();
			}

			return new Object[0];
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private static Image checkedImage = DiagramUIPluginImages.DESC_CHECKBOX_SELECTED.createImage();

	private static Image uncheckedImage = DiagramUIPluginImages.DESC_CHECKBOX_CLEARED.createImage();

	private class AttributeContractTableLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		private AttributeContractTableLabelProvider() {
			// does nothing
		}

		protected Image getImage(boolean isSelected) {
			return isSelected ? checkedImage : uncheckedImage;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof EAttribute) {
				if (columnIndex == 2) {
					int status = getContractStatusInt((EAttribute) element);
					if (status == PRIVATE) {
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PRIVATE);
					} else if (status == PUBLIC_EDITABLE) {
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
					}
				}

				if (columnIndex == 3) {
					EAttribute ea = (EAttribute) element;
					AttributeMetaData data = dmo.getAttributeMetaData(ea.getName());
					if (data == null) {
						return getImage(false);
					}
					return getImage(data.isMutable());
				}

			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof EAttribute) {
				EAttribute ea = (EAttribute) element;

				if (columnIndex == 0) {
					return getName(ea);
				} else if (columnIndex == 1) {
					return ea.getEType().getName();
				} else if (columnIndex == 2) {
					return getContractStatus(ea);
				} else if (columnIndex == 3) {
					return ""; //$NON-NLS-1$
				}
			}

			return element.toString();
		}

	} // end inner class ExtendedAttributeTableLabelProvider

	private class AttributeContractModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			return property.equals(CONTRACT_COL) || property.equals(MUTABLE_COL);
		}

		public Object getValue(Object element, String property) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			if (element instanceof EAttribute) {
				EStructuralFeature esf = (EStructuralFeature) element;
				if (property.equals(CONTRACT_COL)) {
					return getContractStatusInt(esf);
				}
				if (property.equals(MUTABLE_COL)) {
					EAttribute ea = (EAttribute) element;
					AttributeMetaData data = dmo.getAttributeMetaData(ea.getName());
					if (data == null) {
						return false;
					} else {
						return data.isMutable();
					}
				}
			}

			return null;
		}

		public void modify(Object element, String property, Object value) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			if (element instanceof EAttribute) {
				final EStructuralFeature esf = (EStructuralFeature) element;
				if (property.equals(CONTRACT_COL) && value instanceof Integer) {
					contractMap.put(esf, (Integer) value);

//					System.out.println("el=" + element + " prop=" + property + " val=" + stringValue); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				}
				if (property.equals(MUTABLE_COL)) {
					EAttribute ea = (EAttribute) element;
					AttributeMetaData data = dmo.getAttributeMetaData(ea.getName());
					if (data == null) {
						AttributeMetaData metaData = CoreFactory.eINSTANCE.createAttributeMetaData();
						metaData.setAttributeName(ea.getName());
						metaData.setMutable(true);
						addMetaDataOperation(dmo, metaData);

					} else {
						setMetaDataOperation(data);

					}
				}
				tviewer.refresh(esf);
			}
		}

		private void setMetaDataOperation(AttributeMetaData data) {
			final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(dmo);
			try {
				changeScope.execute(getModifyOperation(changeScope, data),
						ChangeScope.OPTION_DO_NOT_SAVE, null);
			} finally {
				if (changeScope != null) {
					changeScope.close(null);
				}
			}

		}

		private IUndoableOperation getModifyOperation(ChangeScope changeScope,
				final AttributeMetaData data) {

			AbstractEMFOperation op = new AbstractEMFOperation(changeScope
					.getTransactionalEditingDomain(),
					Messages.AttributesContractComposite_Add_attribute_meta_data_for_mutable_) {
				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					data.setMutable(!data.isMutable());
					return Status.OK_STATUS;
				}
			};

			return op;
		}

		private void addMetaDataOperation(DeployModelObject dmo, AttributeMetaData metaData) {
			final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(dmo);
			try {
				changeScope.execute(getModifyOperation(dmo, changeScope, metaData),
						ChangeScope.OPTION_DO_NOT_SAVE, null);
			} finally {
				if (changeScope != null) {
					changeScope.close(null);
				}
			}

		}

		private IUndoableOperation getModifyOperation(final DeployModelObject dmo,
				ChangeScope changeScope, final AttributeMetaData metaData) {
			AbstractEMFOperation op = new AbstractEMFOperation(changeScope
					.getTransactionalEditingDomain(),
					Messages.AttributesContractComposite_Add_attribute_meta_data_for_mutable_) {
				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					dmo.getAttributeMetaData().add(metaData);
					return Status.OK_STATUS;
				}
			};

			return op;
		}
	} // end inner class AttributeContractModifier

} // end class AttributesContractComposite
