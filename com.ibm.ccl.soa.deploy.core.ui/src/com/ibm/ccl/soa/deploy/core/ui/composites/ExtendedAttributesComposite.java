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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoFeatureValueConverter;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.NewExtendedAttributeDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.properties.TransactionCommandWrapper2;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * UI for managing the {@link ExtendedAttribute}s on a {@link DeployModelObject}. To add this
 * composite to a {@link DmoComposite}, call
 * {@link DmoComposite#addExtendedAttributesSection(Composite, int, boolean)}, which will wrap it
 * in a collapseable Section.
 * 
 * <p>
 * The UI is a table. The first column is the name, the second is the value.
 * 
 * @deprecated
 */
public class ExtendedAttributesComposite extends Composite {

	private static final String NAME_COL = "Name"; //$NON-NLS-1$
	private static final String VAL_COL = "Val"; //$NON-NLS-1$
	private static final String[] COLUMN_NAMES = new String[] { NAME_COL, VAL_COL };

	private final FormToolkit formToolkit;
	private Button buttonDel;
	private Button buttonAdd;

	private DeployModelObject dmo;
	private boolean mutable;

	private TableViewer tviewer;

	/**
	 * @param parent
	 * @param style
	 * @param deployModelObject
	 * @param ft
	 */
	public ExtendedAttributesComposite(Composite parent, int style,
			DeployModelObject deployModelObject, FormToolkit ft) {
		super(parent, style);

		formToolkit = ft;
		setLayout(new GridLayout());

		createStripOfControls(style);
		createTable(this);

		setInput(deployModelObject);
		//		setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GREEN));
	}

	private void listenForChanges() {
		if (dmo != null) {
			TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(dmo);
			if (theEditingDomain != null) {
				theEditingDomain.addResourceSetListener(eventListener);
			}
		}
	}

	@Override
	public void dispose() {
		stopListeningForChanges();

		super.dispose();
	}

	private void stopListeningForChanges() {
		if (dmo != null) {
			TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(dmo);
			if (theEditingDomain != null) {
				theEditingDomain.removeResourceSetListener(eventListener);
			}
		}
	}

	/**
	 * @param newDmo
	 */
	public void setInput(DeployModelObject newDmo) {
		if (dmo != null) {
			stopListeningForChanges();
		}

		dmo = newDmo;
		mutable = DeployModelObjectUtil.isMutable(dmo);
		listenForChanges();
		tviewer.setInput(dmo);
		enableDisableControls();
	}

	private void createStripOfControls(int style) {
		Composite row = formToolkit.createComposite(this, style);
		GridLayout gd = new GridLayout(2, false);
		gd.marginHeight = 0;
		row.setLayout(gd);
		row.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Composite commandRow = createAddRemoveRow(row, style);
		commandRow.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));
	}

	private Composite createAddRemoveRow(Composite parent, int style) {
		Composite row = formToolkit.createComposite(parent);
		GridLayout gd = new GridLayout(2, false);
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		row.setLayout(gd);

		buttonAdd = formToolkit.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
		buttonAdd.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD));
		buttonAdd.setToolTipText(Messages.ExtendedAttributesComposite_Add_Extended_Attribut_);
		buttonAdd.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				addExtendedAttribute();
			}
		});

		buttonDel = formToolkit.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
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

		Table table = formToolkit.createTable(parent, SWT.MULTI | SWT.FULL_SELECTION);

		table.addSelectionListener(selectionListener);

		//		ConstraintMouseListener listener = new ConstraintMouseListener();
		//		table.addMouseTrackListener(listener);
		//		table.addMouseListener(listener);

		TableLayout tlAttribs = new TableLayout();
		tlAttribs.addColumnData(new ColumnWeightData(45)); // name
		tlAttribs.addColumnData(new ColumnWeightData(45)); // value
		table.setLayout(tlAttribs);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] colHeadersAttrib = new String[] { Messages.RequirementsPropertySection5_Nam_,
				Messages.ExtendedAttributesComposite_Valu_ };
		for (int i = 0; i < colHeadersAttrib.length; i++) {
			TableColumn col = new TableColumn(table, SWT.LEFT);
			col.setText(colHeadersAttrib[i]);
			col.setWidth(115);
		}

		tviewer = new TableViewer(table);
		tviewer.setContentProvider(new ExtendedAttributeTableProvider());
		tviewer.setLabelProvider(new ExtendedAttributeTableLabelProvider());

		GridData gdTable = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		gdTable.minimumHeight = 85;
		table.setLayoutData(gdTable);

		attachCellEditors();
	}

	protected void enableDisableControls() {
		List<ExtendedAttribute> extendedAttribute = getSelectedExtendedAttributes();
		//		ExtendedAttribute first = extendedAttribute != null && extendedAttribute.size() > 0 ? extendedAttribute.get(0) : null;

		boolean selected = extendedAttribute != null;
		buttonAdd.setEnabled(mutable);
		buttonDel.setEnabled(mutable && selected);
	}

	private List<ExtendedAttribute> getSelectedExtendedAttributes() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			if (ss.getFirstElement() instanceof ExtendedAttribute) {
				return ss.toList();
			}
		}

		return null;
	}

	protected void deleteExtendedAttribute() {
		PropertyUtils.deleteFromModel(getSelectedExtendedAttributes(), dmo,
				Messages.ExtendedAttributesComposite_Remove_Extended_Attribute_);
	}

	protected void addExtendedAttribute() {
		//		Point loc = buttonAdd.toDisplay(new Point(buttonAdd.getLocation().x,
		//				buttonAdd.getLocation().y + buttonAdd.getBounds().height));

		NewExtendedAttributeDialog dlg = new NewExtendedAttributeDialog(getShell(), dmo);
		if (dlg.open() == Window.OK) {
			ExtendedAttribute ea = dlg.getNewExtendedAttribute();

			// Create a Command (so Undo will work, and to get transactional wrapper)
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(dmo);
			AddCommand ac = new AddCommand(domain, (EList<?>) dmo.getExtendedAttributes(), ea);

			TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, ac, false);
			PropertyUtils.executeWithUndo(dmo, txcmd);
		}
	}

	private void attachCellEditors() {
		// Assign 'names' to each column
		tviewer.setColumnProperties(COLUMN_NAMES);

		Table table = tviewer.getTable();
		tviewer.setCellEditors(new CellEditor[] {
		// Name
				new TextCellEditor(table, SWT.LEFT),
				// Value
				new TextCellEditor(table, SWT.LEFT), });

		tviewer.setCellModifier(new ExtendedAttributeValueModifier());
	}

	/**
	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
	 * 1. the list of Capabilities changing<br>
	 * 2. the name changing for the current capability.
	 */
	private final ResourceSetListenerImpl eventListener = new ResourceSetListenerImpl(getFilter()) {

		public void resourceSetChanged(ResourceSetChangeEvent event) {

			// We just assume, if we get a notification 
			boolean extendedAttributeListStale = false;

			//
			for (Iterator<Notification> it = event.getNotifications().iterator(); it.hasNext()
					&& !extendedAttributeListStale;) {
				Notification notif = it.next();

				extendedAttributeListStale |= notif.getFeature() == CorePackage.eINSTANCE
						.getDeployModelObject_ExtendedAttributes();
				extendedAttributeListStale |= notif.getNotifier() instanceof ExtendedAttribute;
			}

			if (extendedAttributeListStale && !tviewer.getTable().isDisposed()) {
				// If any of the notifications changed the {@link Unit#getCapabilityGroup} ref, refresh table
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						tviewer.refresh(true);

						enableDisableControls();
					}
				});
			}
		}

		public boolean isPostcommitOnly() {
			return true;
		}

	};

	private NotificationFilter getFilter() {
		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
		return retVal;
	}

	private static class ExtendedAttributeTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) inputElement;

				ExtendedAttribute[] result = (ExtendedAttribute[]) dmo.getExtendedAttributes().toArray(
						new ExtendedAttribute[dmo.getExtendedAttributes().size()]);
				Arrays.sort(result, EXTENDED_ATTRIBUTE_NAME_COMPARATOR);
				return result;
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

	/**
	 * Compares two {@link ExtendedAttribute} instances by their name ignoring case.
	 */
	private static final Comparator<ExtendedAttribute> EXTENDED_ATTRIBUTE_NAME_COMPARATOR = new Comparator<ExtendedAttribute>() {
		public int compare(ExtendedAttribute o1, ExtendedAttribute o2) {
			return getExtendedAttributeLabel(o1).compareToIgnoreCase(getExtendedAttributeLabel(o2));
		}
	};

	/**
	 * Returns a label for the extended attribute.
	 * 
	 * @param ea
	 *           an extended attribute.
	 * @return a label for the extended attribute (never null).
	 */
	private static String getExtendedAttributeLabel(ExtendedAttribute ea) {
		if (ea == null || ea.getName() == null) {
			return ""; //$NON-NLS-1$
		}
		if (ea.getContainer() != null) {
			AttributeMetaData md = ea.getContainer().getAttributeMetaData(ea.getName());
			if (md != null && md.getLabel() != null) {
				return md.getLabel();
			}
		}
		return ea.getName();
	}

	private static class ExtendedAttributeTableLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		private ExtendedAttributeTableLabelProvider() {
			// does nothing
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ExtendedAttribute) {
				ExtendedAttribute ea = (ExtendedAttribute) element;

				if (columnIndex == 0) {
					return getExtendedAttributeLabel(ea);
				}

				return ea.getValue().toString();
			}

			return element.toString();
		}

	} // end inner class ExtendedAttributeTableLabelProvider

	private static class ExtendedAttributeValueModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			return property.equals(VAL_COL);
		}

		public Object getValue(Object element, String property) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			//			System.out.println(element);

			if (element instanceof ExtendedAttribute) {
				ExtendedAttribute ea = (ExtendedAttribute) element;
				if (property.equals(VAL_COL)) {
					// We always convert to String, because we are using TextCellEditor, which only handles Strings
					return ea.getValue().toString();
				}
			}

			return null;
		}

		public void modify(Object element, String property, Object stringValue) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			//	System.out.println("el=" + element + " prop=" + property + " val=" + value); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			if (element instanceof ExtendedAttribute) {
				final ExtendedAttribute ea = (ExtendedAttribute) element;
				if (property.equals(VAL_COL)) {
					// Convert to the appropriate type for this Extended Attribute
					// DmoFeatureValueConverter needs an EStructuralFeature and
					// extended attributes don't have them.
					DmoFeatureValueConverter dfvc = new DmoFeatureValueConverter();
					EAttribute aFeature = EcoreFactory.eINSTANCE.createEAttribute();
					aFeature.setEType(ea.getInstanceType());
					final Object realValue = dfvc.convertValue(stringValue, aFeature);

					String msg = Messages.ExtendedAttributesComposite_Set_Extended_Attribut_;
					PropertyUtils.executeWithUndo(ea, msg, new Runnable() {

						public void run() {
							ea.setValue(realValue);
						}
					});
				}
			}
		}
	} // end inner class ExtendedAttributeValueModifier

} // end class ExtendedAttributesComposite
