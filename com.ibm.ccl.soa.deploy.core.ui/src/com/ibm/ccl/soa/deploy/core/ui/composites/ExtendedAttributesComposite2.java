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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CustomizeAttributesDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * UI for managing the {@link ExtendedAttribute}s on a {@link DeployModelObject}. Used by
 * {@link CustomizeAttributesDialog}.
 * 
 * <p>
 * The UI is a table. The first column is the name, the second is the value.
 */
public class ExtendedAttributesComposite2 extends Composite {

	private static final String NAME_COL = "Name"; //$NON-NLS-1$
	private static final String TYPE_COL = "Type"; //$NON-NLS-1$
	private static final String CONTRACT_COL = "Contract"; //$NON-NLS-1$
	private static final String MUTABLE_COL = "is Mutable"; //$NON-NLS-1$
	private boolean isMutable = false;

	private static final String[] COLUMN_NAMES = new String[] { NAME_COL, TYPE_COL, CONTRACT_COL,
			MUTABLE_COL };

	private static final String[] contractTypes = { Messages.GeneralDmoSyncHelperModel_Private_,
			Messages.GeneralDmoSyncHelperModel_Public_Editable_ };

	private static final String[] dataTypes = { Messages.NewExtendedAttributeDialog_STRING,
			Messages.NewExtendedAttributeDialog_INTEGER, Messages.NewExtendedAttributeDialog_BOOLEAN };

	private static final EDataType[] types = new EDataType[] { XMLTypePackage.eINSTANCE.getString(),
			XMLTypePackage.eINSTANCE.getIntObject(), XMLTypePackage.eINSTANCE.getBooleanObject() };

	private final FormToolkit formToolkit;
	private Button buttonDel;
	private Button buttonAdd;

	private DeployModelObject dmo;
	private boolean mutable;

	private TableViewer tviewer;
	private ArrayList<ExtendedAttributeSurrogate> eaList;
	private ArrayList<ExtendedAttribute> eaOriginal;
	private final boolean showContract;

//	private HashMap<ExtendedAttribute, Integer> contractMap;

	/**
	 * Variant that doesn't use FormToolkit, creates composites using SWT
	 * 
	 * @param parent
	 * @param dmo
	 *           used to verify no collision in attribute names; EAs will not be touched
	 * @param style
	 * @param attribs
	 */
	public ExtendedAttributesComposite2(Composite parent, int style, DeployModelObject dmo,
			List<ExtendedAttribute> attribs) {
		this(parent, style, dmo, attribs, null, true);
	}

	/**
	 * @param parent
	 * @param style
	 * @param dmo
	 *           used to verify no collision in attribute names; EAs will not be touched
	 * @param attribs
	 * @param ft
	 * @param showContractSettings
	 */
	public ExtendedAttributesComposite2(Composite parent, int style, DeployModelObject dmo,
			List<ExtendedAttribute> attribs, FormToolkit ft, boolean showContractSettings) {
		super(parent, style);
		showContract = showContractSettings;
		Topology topology = dmo.getEditTopology();
		isMutable = topology.isMutabilityConfigurable();

		formToolkit = ft;
		setLayout(new GridLayout());

		createStripOfControls(style);
		createTable(this);

		setInput(dmo, attribs);
		//		setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GREEN));
	}

	/**
	 * @param dmo
	 * @param attribs
	 */
	public void setInput(DeployModelObject dmo, List<ExtendedAttribute> attribs) {
		//		if (dmo != null) {
		//			stopListeningForChanges();
		//		}

		eaOriginal = new ArrayList<ExtendedAttribute>(attribs);
		mutable = PropertyUtils.isEditable(dmo);
		//		listenForChanges();
		this.dmo = dmo;
		eaList = createSurrogates(attribs);
//		determineCurrentContracts();

		tviewer.setInput(eaList);
		enableDisableControls();

	}

	private ArrayList<ExtendedAttributeSurrogate> createSurrogates(List<ExtendedAttribute> attribs) {
		ArrayList<ExtendedAttributeSurrogate> retVal = new ArrayList<ExtendedAttributeSurrogate>();

		for (ExtendedAttribute ea : attribs) {
			retVal.add(new ExtendedAttributeSurrogate(ea));
		}

		return retVal;
	}

	private void createStripOfControls(int style) {
		//		//		Composite row = formToolkit.createComposite(this, style);
		//		Composite row = formToolkit == null ? new Composite(this, style) : formToolkit
		//				.createComposite(this, style);
		//		row.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GREEN));
		//		GridLayout gd = new GridLayout(2, false);
		//		gd.marginHeight = 0;
		//		row.setLayout(gd);
		//		row.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Composite commandRow = createAddRemoveRow(this, style);
		commandRow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	private Composite createAddRemoveRow(Composite parent, int style) {
		//		Composite row = formToolkit.createComposite(parent, style);
		Composite row = formToolkit == null ? new Composite(this, style) : formToolkit
				.createComposite(this, style);
		//		row.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_BLUE));
		GridLayout gd = new GridLayout(3, false);
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		row.setLayout(gd);

		if (formToolkit != null) {
			Label l = formToolkit.createLabel(row,
					Messages.ExtendedAttributesComposite2_Extended_Attributes_);
			l.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			buttonAdd = formToolkit.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
		} else {
			Label l = new Label(row, SWT.NULL);
			l.setText(Messages.ExtendedAttributesComposite2_Extended_Attributes_);
			l.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			buttonAdd = new Button(row, SWT.PUSH);
		}
		buttonAdd.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD));
		buttonAdd.setToolTipText(Messages.ExtendedAttributesComposite_Add_Extended_Attribut_);
		buttonAdd.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				addExtendedAttribute();
			}
		});

		if (formToolkit != null) {
			buttonDel = formToolkit.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
		} else {
			buttonDel = new Button(row, SWT.PUSH);
		}
		buttonDel.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE));
		buttonDel.setToolTipText(Messages.ExtendedAttributesComposite_Delete_Extended_Attribut_);
		buttonDel.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				deleteExtendedAttribute();
			}
		});

		return row;
	}

	private void createTable(Composite parent) {
		SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		};

		Table table;
		if (formToolkit != null) {
			table = formToolkit.createTable(parent, SWT.MULTI | SWT.FULL_SELECTION);
		} else {
			table = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		}

		table.addSelectionListener(selectionListener);

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
			TableColumn col = new TableColumn(table, SWT.CENTER);
			col.setText(colHeadersAttrib[i]);
			/*
			 * if (i == 3) { col.setWidth(20); continue; }
			 */
			col.setWidth(115);
			col.setAlignment(SWT.CENTER);
		}

		tviewer = new TableViewer(table);
		tviewer.setContentProvider(new ListTableProvider());
		tviewer.setLabelProvider(new ExtendedAttributeTableLabelProvider());

		GridData gdTable = new GridData(GridData.FILL_BOTH);
		gdTable.minimumHeight = 85;
		table.setLayoutData(gdTable);

		attachCellEditors();
	}

	protected void enableDisableControls() {
		List<ExtendedAttributeSurrogate> extendedAttribute = getSelectedExtendedAttributes();
		//		ExtendedAttribute first = extendedAttribute != null && extendedAttribute.size() > 0 ? extendedAttribute.get(0) : null;

		boolean selected = extendedAttribute != null;
		buttonAdd.setEnabled(mutable);
		buttonDel.setEnabled(mutable && selected);
	}

	private List<ExtendedAttributeSurrogate> getSelectedExtendedAttributes() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			if (ss.getFirstElement() instanceof ExtendedAttributeSurrogate) {
				return ss.toList();
			}
		}

		return null;
	}

	protected void deleteExtendedAttribute() {
		//		PropertyUtils.deleteFromModel(getSelectedExtendedAttributes(),
		//				Messages.ExtendedAttributesComposite_Remove_Extended_Attribute_);
		eaList.removeAll(getSelectedExtendedAttributes());
		tviewer.refresh(false);
		enableDisableControls();
	}

	protected void addExtendedAttribute() {

//		NewExtendedAttributeDialog dlg = new NewExtendedAttributeDialog(getShell(), dmo, additions(),
//				removals());
//		if (dlg.open() == Window.OK) {
//			ExtendedAttribute ea = dlg.getNewExtendedAttribute();
//
//			//			// Create a Command (so Undo will work, and to get transactional wrapper)
//			//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(dmo);
//			//			AddCommand ac = new AddCommand(domain, (EList<?>) dmo.getExtendedAttributes(), ea);
//			//
//			//			TransactionCommandWrapper2 mtcw = new TransactionCommandWrapper2(domain, ac, false);
//			//			ICommandProxy command = new ICommandProxy(mtcw);
//			//			PropertyUtils.executeWithUndo(command);
//			eaList.add(ea);
//			tviewer.refresh(false);
//			enableDisableControls();
//		}

//		ExtendedAttribute ea = CoreFactory.eINSTANCE.createExtendedAttribute();
//		ea.setName(generateNewAttributeName());
//		ea.setValue(""); //$NON-NLS-1$

		ExtendedAttributeSurrogate eas = new ExtendedAttributeSurrogate();

		eaList.add(eas);
		tviewer.refresh(false);
		enableDisableControls();
	}

	/**
	 * @return List of ExtendedAttributes that were removed since setInput() or construction
	 */
	public List<ExtendedAttribute> removals() {
		List<ExtendedAttribute> retVal = new LinkedList<ExtendedAttribute>(eaOriginal);
		retVal.removeAll(realExtendedAttributes(eaList));
		return Collections.unmodifiableList(retVal);
	}

	private Collection<ExtendedAttribute> realExtendedAttributes(
			ArrayList<ExtendedAttributeSurrogate> leas) {
		List<ExtendedAttribute> retVal = new LinkedList<ExtendedAttribute>();

		for (ExtendedAttributeSurrogate eas : leas) {
			retVal.add(eas.getExtendedAttribute());
		}

		return retVal;
	}

	/**
	 * @return List of ExtendedAttributes that were added since setInput() or construction
	 */
	public List<ExtendedAttribute> additions() {
		List<ExtendedAttribute> retVal = new LinkedList<ExtendedAttribute>(
				realExtendedAttributes(eaList));
		retVal.removeAll(eaOriginal);
		return Collections.unmodifiableList(retVal);
	}

//	private void determineCurrentContracts() {
//		contractMap = new HashMap<ExtendedAttribute, Integer>();
//		for (ExtendedAttribute ea : (List<ExtendedAttribute>) dmo.getExtendedAttributes()) {
//			ConfigurationContract contract = dmo.getTopology().getConfigurationContract();
//			boolean publicEditable = contract.isPublicEditable(dmo, ea.getName());
//			if (!publicEditable) {
//				contractMap.put(ea, PRIVATE);
//			} else {
//				contractMap.put(ea, PUBLIC_EDITABLE);
//			}
//		}
//	}
//
//	private int getContractStatusInt(ExtendedAttribute ea) {
//		Integer stat = contractMap.get(ea);
//		return stat != null ? stat.intValue() : PRIVATE;
//	}

//	private int getTypeInt(ExtendedAttribute ea) {
//		try {
//			if (ea.getValue() instanceof Boolean) {
//				return BOOLEAN_TYPE;
//			} else if (ea.getValue() instanceof BigInteger) {
//				return INTEGER_TYPE;
//			}
//		} catch (Exception nfe) {
//			// do nothing.  Indicates the ExtendedAttribute is in an inconsistent
//			// state.  Hopefully the user will correct this by choosing a different
//			// option in the combo box.
//		}
//
//		return STRING_TYPE;
//	}

//	private String getContractStatus(ExtendedAttribute esf) {
//		int status = getContractStatusInt(esf);
//		if (status == PRIVATE) {
//			return Messages.GeneralDmoSyncHelperModel_Private_;
////		} else if (status == PUBLIC) {
////			return Messages.GeneralDmoSyncHelperModel_Public_;
//		} else if (status == PUBLIC_EDITABLE) {
//			return Messages.GeneralDmoSyncHelperModel_Public_Editable_;
//		}
//
//		throw new IllegalStateException();
//	}

	private void attachCellEditors() {
		// Assign 'names' to each column
		tviewer.setColumnProperties(COLUMN_NAMES);
		Table table = tviewer.getTable();
		tviewer.setCellEditors(new CellEditor[] {
				// Name
				new TextCellEditor(table, SWT.LEFT),
				// Value
				new ComboBoxCellEditor(table, dataTypes, SWT.READ_ONLY),
				// Contract
				new ComboBoxCellEditor(table, contractTypes, SWT.READ_ONLY),
				new CheckboxCellEditor(table, SWT.FILL) });

		tviewer.setCellModifier(new ExtendedAttributeValueModifier());
	}

	private static class ListTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List<?> list = (List<?>) inputElement;

				return list.toArray();
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

	private class ExtendedAttributeTableLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		private ExtendedAttributeTableLabelProvider() {
			// does nothing
		}

		protected Image getImage(boolean isSelected) {
			return isSelected ? checkedImage : uncheckedImage;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof ExtendedAttributeSurrogate) {
				if (columnIndex == 2) {
					ExtendedAttributeSurrogate eas = (ExtendedAttributeSurrogate) element;
					return eas.getContractStatusImage();
				}
				if (columnIndex == 3) {
					ExtendedAttributeSurrogate eas = (ExtendedAttributeSurrogate) element;
					return getImage(eas.getMutablity());
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ExtendedAttributeSurrogate) {
				ExtendedAttributeSurrogate ea = (ExtendedAttributeSurrogate) element;

				if (columnIndex == 0) {
					return ea.getName();
				} else if (columnIndex == 1) {
//					return ea.getInstanceType().getName();
					return ea.getInstanceTypeName();
				} else if (columnIndex == 2) {
//					return getContractStatus(ea);
					return ea.getContractStatus();
				} else if (columnIndex == 3) {
					return ""; //$NON-NLS-1$
				}
			}

			return element.toString();
		}

	} // end inner class ExtendedAttributeTableLabelProvider

	/**
	 * Note: MUST be called from within a transaction
	 */
	public void performStatusChanges() {
		// Change names and types of existing EAs
		for (ExtendedAttributeSurrogate eas : eaList) {
			eas.performChanges();
		}
	}

	private class ExtendedAttributeValueModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			// TODO Remove this, when bug 1927 is fixed
			return !property.equals(CONTRACT_COL);
		}

		public Object getValue(Object element, String property) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			//			System.out.println(element);

			if (element instanceof ExtendedAttributeSurrogate) {
				ExtendedAttributeSurrogate ea = (ExtendedAttributeSurrogate) element;
				if (property.equals(CONTRACT_COL)) {
//					return getContractStatusInt(ea);
					return ea.getContractStatusInt();
				} else if (property.equals(TYPE_COL)) {
//					return getTypeInt(ea);
					return ea.getTypeInt();
				} else if (property.equals(NAME_COL)) {
					return ea.getName();
				} else if (property.equals(MUTABLE_COL)) {
					AttributeMetaData data = dmo.getAttributeMetaData(ea.getExtendedAttribute()
							.getName());
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

			//	System.out.println("el=" + element + " prop=" + property + " val=" + value); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			if (element instanceof ExtendedAttributeSurrogate) {
				final ExtendedAttributeSurrogate ea = (ExtendedAttributeSurrogate) element;

				if (property.equals(CONTRACT_COL) && value instanceof Integer) {
//					contractMap.put(ea, (Integer) value);
					ea.setContractStatus((Integer) value);
				} else if (property.equals(TYPE_COL) && value instanceof Integer) {
//					Integer iVal = (Integer) value;
//					switch (iVal.intValue())
//					{
//					case STRING_TYPE:
//						ea.setInstanceType(XMLTypePackage.eINSTANCE.getString());
//						ea.setValue(""); //$NON-NLS-1$
//						break;
//					case INTEGER_TYPE:
//						ea.setInstanceType(XMLTypePackage.eINSTANCE.getInteger());
//						ea.setValue(BigInteger.valueOf(0));
//						break;
//					case BOOLEAN_TYPE:
//						ea.setInstanceType(XMLTypePackage.eINSTANCE.getBooleanObject());
//						ea.setValue(Boolean.FALSE);
//						break;
//					}
					ea.setInstanceType((Integer) value);
				} else if (property.equals(NAME_COL) && value instanceof String) {
					ea.setName((String) value);
				} else if (property.equals(MUTABLE_COL) && value instanceof Boolean) {
					ea.setMutablity((Boolean) value);
				}
				tviewer.refresh();
			}
		}
	} // end inner class ExtendedAttributeValueModifier

	/**
	 * A simple class that stands for an {@link ExtendedAttribute}. We can't directly manipulate the
	 * ExtendedAttributes because we don't want the changes to take effect until 'OK'.
	 */
	private class ExtendedAttributeSurrogate {

		private static final int PUBLIC_EDITABLE = 1;
		private static final int PRIVATE = 0;

		private static final int STRING_TYPE = 0;
		private static final int INTEGER_TYPE = 1;
		private static final int BOOLEAN_TYPE = 2;

		private String name;
		private boolean publicEditable;
		private int type;
		private final ExtendedAttribute extendedAttribute;
		private EDataType eDataType;
		private final ConfigurationContract contract;
		private boolean mutableEA;

		private ExtendedAttributeSurrogate() {
			extendedAttribute = CoreFactory.eINSTANCE.createExtendedAttribute();
//			ea.setName(name);
//			setValue(ea, getTypeInt());

			name = generateNewAttributeName();
			setInstanceType(0);
			contract = dmo.getTopology().getConfigurationContract();
			publicEditable = contract != null && contract.isPublicEditable(dmo);

		}

		private void setMutablity(Boolean value) {
			mutableEA = value;
			AttributeMetaData data = dmo.getAttributeMetaData(extendedAttribute.getName());
			if (data == null) {
				AttributeMetaData metaData = CoreFactory.eINSTANCE.createAttributeMetaData();
				metaData.setAttributeName(extendedAttribute.getName());
				metaData.setMutable(value);
				addMetaDataOperation(dmo, metaData);

			} else {
				setMetaDataOperation(data, value);

			}

		}

		private Image getContractStatusImage() {
			Image image = publicEditable ? DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE) : DeployCoreUIPlugin.getDefault()
					.getSharedImages().getImage(ISharedImages.IMG_CONTRACT_PRIVATE);
			return image;
		}

		private ExtendedAttributeSurrogate(ExtendedAttribute ea) {
			extendedAttribute = ea;

			name = ea.getName();
			contract = ea.getContainer().getTopology().getConfigurationContract();
			publicEditable = contract != null && contract.isPublicEditable(dmo, ea.getName());
			type = calculateTypeInt(ea);
			eDataType = ea.getInstanceType();
			setMutablity(ea);
		}

		private void setMutablity(ExtendedAttribute ea) {
			AttributeMetaData data = dmo.getAttributeMetaData(extendedAttribute.getName());
			if (data == null) {
				mutableEA = false;
			} else {
				mutableEA = data.isMutable();
			}
		}

		private int calculateTypeInt(ExtendedAttribute ea) {
			try {
				if (ea.getValue() instanceof Boolean) {
					return BOOLEAN_TYPE;
				} else if (ea.getValue() instanceof Integer) {
					return INTEGER_TYPE;
				}
			} catch (Exception nfe) {
				// do nothing.  Indicates the ExtendedAttribute is in an inconsistent
				// state.  Hopefully the user will correct this by choosing a different
				// option in the combo box.
			}

			return STRING_TYPE;
		}

		private void setName(String value) {
			name = value;
		}

		private void setInstanceType(Integer value) {
			type = value.intValue();
			eDataType = types[type];
		}

		private void setContractStatus(Integer value) {
			publicEditable = value.intValue() != 0;
		}

		private Integer getTypeInt() {
			return type;
		}

		private int getContractStatusInt() {
			return publicEditable ? PUBLIC_EDITABLE : PRIVATE;
		}

		private String getContractStatus() {
			return contractTypes[getContractStatusInt()];
		}

		private boolean getMutablity() {
			return mutableEA;
		}

		private String getInstanceTypeName() {
			return dataTypes[getTypeInt()];
		}

		private ExtendedAttribute getExtendedAttribute() {
			return extendedAttribute;
		}

		private void setValue(ExtendedAttribute ea, int newType) {
			switch (newType)
			{
			case STRING_TYPE:
				ea.setValue(""); //$NON-NLS-1$
				break;
			case INTEGER_TYPE:
				ea.setValue(Integer.valueOf(0));
				break;
			case BOOLEAN_TYPE:
				ea.setValue(Boolean.FALSE);
				break;
			}
		}

		/** Must be called within a transaction */
		private void performChanges() {
			if (extendedAttribute != null) {
				extendedAttribute.setName(name);
				if (extendedAttribute.getInstanceType() != getInstanceType()) {
					extendedAttribute.setInstanceType(getInstanceType());
					setValue(extendedAttribute, getTypeInt());
				}
			}

			// TODO -- reimplement this once bug 1927 is taken care of
//			// Change contract status... if the real ExtendedAttribute hasn't been deleted
//			if (extendedAttribute.eContainer() != null) {
//				if (publicEditable) {
//					contract.export(dmo, getName());
//				} else {
//					contract.unexport(dmo, getName());
//				}
//			}
		}

		private EDataType getInstanceType() {
			return eDataType;
		}

//		private static int getContractStatusInt(ExtendedAttribute ea) {
//			Integer stat = contractMap.get(ea);
//			return stat != null ? stat.intValue() : PRIVATE;
//		}

		private String generateNewAttributeName() {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				String candidate = "newAttrib" + (i == 1 ? "" : Integer.toString(i)); //$NON-NLS-1$//$NON-NLS-2$
				if (!alreadyUsed(candidate)) {
					return candidate;
				}
			}

			// should never be reached 
			return "newAttrib"; //$NON-NLS-1$
		}

		private boolean alreadyUsed(String s) {
			for (ExtendedAttributeSurrogate ea : eaList) {
				if (ea.getName().equals(s)) {
					return true;
				}
			}

			return false;
		}

		private String getName() {
			return name;
		}

	} // end inner class ExtendedAttributeSurrogate

	private void setMetaDataOperation(AttributeMetaData data, Boolean value) {
		final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(dmo);
		try {
			changeScope.execute(getModifyOperation(changeScope, data, value),
					ChangeScope.OPTION_DO_NOT_SAVE, null);
		} finally {
			if (changeScope != null) {
				changeScope.close(null);
			}
		}

	}

	private IUndoableOperation getModifyOperation(ChangeScope changeScope,
			final AttributeMetaData data, final Boolean value) {

		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(),
				Messages.AttributesContractComposite_Add_attribute_meta_data_for_mutable_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				data.setMutable(value);
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
}
