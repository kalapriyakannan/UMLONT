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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * UI for managing String attributes with maxOccurs>1
 */
public class AttributeValueListComposite extends Composite implements CompositeForDmoComposite {

	private static final String ID_COL = "Value"; //$NON-NLS-1$
	private static final String[] COLUMN_NAMES = new String[] { ID_COL };

//	private final Button button;
//	private final org.eclipse.swt.widgets.Label label;
	private EAttribute esf;
	private DmoSyncHelperModel dmoModel;
	private final TabbedPropertySheetWidgetFactory ft;
	private TableViewer tviewer;
	private Button buttonAdd;
	private Button buttonDel;
	private boolean isEnabled = true;

	/**
	 * @param parent
	 * @param style
	 */
	public AttributeValueListComposite(Composite parent, int style) {
		super(parent, style);

		// Listen for the Dispose event
		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if (ft != null) {
					ft.dispose();
				}
			}
		});

		ft = new TabbedPropertySheetWidgetFactory();

		GridLayout gl = new GridLayout(2, false);
		gl.marginHeight = 0;
		gl.marginBottom = 0;
//		gl.marginLeft = 0;
		gl.marginRight = 0;
		gl.marginWidth = 0;
		gl.marginTop = 0;
		gl.marginWidth = 0;
		setLayout(gl);

		createTable();
		createStripOfControls();

//		setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_GREEN));

//		label = ft.createLabel(this, ""); //$NON-NLS-1$
//		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
//		button = ft.createButton(this, Messages.DmoComposite_Edit_, SWT.PUSH);
	}

	private void createTable() {

		Table table = ft.createTable(this, SWT.MULTI | SWT.FULL_SELECTION);
//		table.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));

		table.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		});

//		table.setLinesVisible(true);

		tviewer = new TableViewer(table);
		tviewer.setContentProvider(new ListTableContentProvider());
//		tviewer.setLabelProvider(new SingleValueTableLabelProvider());

		GridData gdTable = new GridData(GridData.FILL_BOTH);
		//gdTable.minimumHeight = 85;
		table.setLayoutData(gdTable);
	}

	private void createStripOfControls() {
		Composite row = ft.createComposite(this, SWT.FLAT);
//		row.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_CYAN));
		GridLayout gd = new GridLayout();
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		row.setLayout(gd);
		row.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		buttonAdd = ft.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
		buttonAdd.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD));
		buttonAdd.setToolTipText(Messages.EnumerationConstraintUIHandler_Add_Valu_);
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				addValue();
			}
		});

		buttonDel = ft.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
		buttonDel.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE));
		buttonDel.setToolTipText(Messages.ExtendedAttributesComposite_Delete_Extended_Attribut_);
		buttonDel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				deleteValue();
			}
		});

	}

	private void enableDisableControls() {
		buttonAdd.setEnabled(isEnabled);
		buttonDel.setEnabled(isEnabled && hasSelectedValues());
	}

	private boolean hasSelectedValues() {
		ISelection isel = tviewer.getSelection();
		if (isel instanceof StructuredSelection) {
			StructuredSelection sel = (StructuredSelection) isel;
			return !sel.isEmpty();
		}

		return false;
	}

	private void deleteValue() {
		// Copy the old list
		List<String> newList = new LinkedList<String>(dmoModel.getStringListProperty(esf));

		ISelection isel = tviewer.getSelection();
		if (isel instanceof StructuredSelection) {
			StructuredSelection sel = (StructuredSelection) isel;

			for (Iterator<?> it = sel.iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Wrapper) {
					Wrapper wrapper = (Wrapper) obj;
					obj = wrapper.contents();
				}
				newList.remove(obj);
			}
		}

		dmoModel.setProperty(esf, newList);
		tviewer.refresh();
	}

	@SuppressWarnings("unchecked")
	protected void addValue() {
		// TODO Test with lists of other-than-string
		final List<String> newList = new LinkedList<String>((List<String>) dmoModel.getProperty(esf));

		newList.add(Messages.EnumerationConstraintUIHandler_newValu_);

		dmoModel.setProperty(esf, newList);

		tviewer.refresh();

		// Select the newly added item
		tviewer.getTable().select(tviewer.getTable().getItemCount() - 1);
		enableDisableControls();
//		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(list);
//		if (domain != null) {
//			String msg = Messages.EnumerationConstraintUIHandler_Add_Valu_;
//			PropertyUtils.executeWithUndo(domain, msg, new Runnable() {
//
//				public void run() {
//					list.add(Messages.EnumerationConstraintUIHandler_newValu_);
//				}
//			});
//			
//			tviewer.refresh();
//		}
	}

	public void showValue() {
		if (dmoModel != null) {
			List<String> newVal = dmoModel.getStringListProperty(esf);
			tviewer.setInput(newVal);
			enableDisableControls();
//			setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW));
//			label.setText(renderAsText(newVal));
		}
	}

	@SuppressWarnings("unchecked")
	private void attachCellEditors() {
		// Assign 'names' to each column
		tviewer.setColumnProperties(COLUMN_NAMES);

		Table table = tviewer.getTable();
		tviewer.setCellEditors(new CellEditor[] { new TextCellEditor(table, SWT.LEFT), });

//		List<String> theList = (List<String>) dmoModel.getProperty(esf);
		tviewer.setCellModifier(new StringValueModifier(dmoModel, esf, isEnabled));
	}

//	private String renderAsText(List<String> newVal) {
//		// Formerly we just called newVal.toString() but this did was not translatable
//		// to RTL languages.
//
//		if (newVal.size() == 0) {
//			return Messages.ImportPropertySection_;
//		}
//
//		Iterator<String> it = newVal.iterator();
//		// Work around for hasNext bug
//		if (it.hasNext() == false) {
//			return Messages.ImportPropertySection_;
//		}
//
//		String retVal = it.next();
//		while (it.hasNext()) {
//			String next = it.next();
//
//			retVal = NLS.bind(Messages.AttributeValueListComposite_0_1_, retVal, next);
//		}
//		return TextProcessor.process(retVal, ":/.,\\"); //$NON-NLS-1$
//	}

	/**
	 * @param model
	 * @param attribute
	 *           must be an EAttribute
	 */
	public void setup(DmoSyncHelperModel model, EStructuralFeature attribute) {
		esf = (EAttribute) attribute;
		dmoModel = model;
//		button.addSelectionListener(new SelectionAdapter() {
//
//			public void widgetSelected(SelectionEvent e) {
//				ListEditorDialog led = new ListEditorDialog(button.getShell());
//				Object value = dmoModel.getProperty(esf);
//
//				if (value instanceof List) {
//					led.setList((List<?>) value);
//
//					if (led.open() == Window.OK) {
//						List<?> val = led.getList();
//						dmoModel.setProperty(esf, val);
//					}
//				}
//			}
//		});
		attachCellEditors();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		isEnabled = enabled;
		enableDisableControls();
	}

	private static class ListTableContentProvider implements IStructuredContentProvider {

		private final static Object[] NONE = new Object[0];

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List<?> l = (List<?>) inputElement;
				// We can't merely "return l.toArray()" because the results will 
				// be editable and stored in a structure that will use equals() on them
				// so the user might be editing the second "foo" string but the system will
				// think the first is being edited.
				return wrap(l).toArray();
			}

			return NONE;
		}

		private List<Wrapper> wrap(List<?> l) {
			List<Wrapper> retVal = new LinkedList<Wrapper>();
			for (Object o : l) {
				retVal.add(new Wrapper(o));
			}
			return retVal;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	} // end static inner class ListTableContentProvider

	private static class Wrapper {

		private final Object contents;

		private Wrapper(Object o) {
			contents = o;
		}

		@Override
		public String toString() {
			return contents.toString();
		}

		private Object contents() {
			return contents;
		}
	}

	private static class StringValueModifier implements ICellModifier {

		final private EAttribute esf;
		final private DmoSyncHelperModel dmoModel;
//		final List<String> owner;
		final boolean mutable;

		private StringValueModifier(/* List<String> theList, */DmoSyncHelperModel model,
				EAttribute eattrib, boolean canModify) {
//			owner = theList;
			dmoModel = model;
			esf = eattrib;
			mutable = canModify;
		}

		public boolean canModify(Object element, String property) {
			return mutable;
		}

		public Object getValue(Object element, String property) {
			System.out
					.println("getValue() for element=\"" + element + "\"/" + System.identityHashCode(element)); //$NON-NLS-1$//$NON-NLS-2$
			Wrapper w = (Wrapper) element;
			return w.contents();
//			return element;
		}

		@SuppressWarnings("unchecked")
		public void modify(Object element, final String property, final Object value) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			if (element instanceof Wrapper) {
				Wrapper wrapper = (Wrapper) element;
				element = wrapper.contents();
			}

			// Find the index in the original list
			List<String> owner = (List<String>) dmoModel.getProperty(esf);

			// Dump the list
			for (int i = 0; i < owner.size(); i++) {
				String s = owner.get(i);
				System.out.println("owner[" + i + "]=\"" + s + "\"/" + System.identityHashCode(s)); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			}
			System.out.println("element=\"" + element + "\"/" + System.identityHashCode(element)); //$NON-NLS-1$//$NON-NLS-2$

			int pos = -1;
			for (int i = 0; i < owner.size(); i++) {
				if (owner.get(i) == element) {
					pos = i;
					break;
				}
			}

			if (pos >= 0) {
				// Copy the list
				final List<String> newList = new LinkedList<String>((List<String>) dmoModel
						.getProperty(esf));

				if (!newList.get(pos).equals(value)) {

					// Modify the copy
					newList.set(pos, (String) value);

					// Save the copy
					dmoModel.setProperty(esf, newList);
				}

//				final int nPos = pos;
//				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(owner);
//				if (domain != null) {
//					String msg = Messages.EnumerationConstraintUIHandler_Set_Valu_;
//					PropertyUtils.executeWithUndo(domain, msg, new Runnable() {
//
//						public void run() {
//							owner.set(nPos, (String) value);
//						}
//					});
//
////					svc.refresh();
//				}
			}
		}
	} // end inner class SingleValueValueModifier

} // end class AttributeValueListComposite
