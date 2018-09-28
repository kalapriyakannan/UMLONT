/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * SAF UI handler for a {@link ExclusionConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 */
public class ExclusionConstraintUIHandler extends AttributeValueUIHandler {

	/**
	 * 
	 */
	public ExclusionConstraintUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.eINSTANCE.getExclusionConstraint();
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		ExclusionConstraintValueComposite composite = new ExclusionConstraintValueComposite(parent,
				(ExclusionConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		return composite;
	}

	private static class ExclusionConstraintValueComposite extends
			AttributeValueUIHandler.AttributeValueComposite {

		private SingleValueListComposite slc;
		private ExclusionConstraint exConstraint;
		private boolean mutable;

		protected ExclusionConstraintValueComposite(Composite parent, ExclusionConstraint enumc,
				FormToolkit formToolkit) {
			super(parent, enumc, formToolkit);

			setInput(enumc);
			exConstraint = enumc;
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			super.synthFields(synthExclusions);

			addExclusionSection();
		}

		/** 
		 */
		private void addExclusionSection() {

			slc = new SingleValueListComposite(this, exConstraint.getValues(), mutable,
					getWidgetFactory(), TransactionUtil.getEditingDomain(exConstraint), dmo);
			GridData gdSLC = new GridData(SWT.FILL, SWT.FILL, true, true);
			gdSLC.horizontalSpan = 2;
			slc.setLayoutData(gdSLC);
		}

		@Override
		public void setInput(Object object) {
			assert object instanceof ExclusionConstraint;
			super.setInput(object);
			exConstraint = (ExclusionConstraint) object;
			mutable = DeployModelObjectUtil.isMutable(exConstraint);

			if (slc != null) {
				slc.setInput(exConstraint.getValues(), mutable);
			}
		}

	} // end static inner class ExclusionConstraintValueComposite

	private static class SingleValueListComposite extends Composite {

		private static final String DESCR_COL = "DESCR_COL"; //$NON-NLS-1$
		private static final String ID_COL = "ID_COL"; //$NON-NLS-1$
		private static final String[] COLUMN_NAMES = new String[] { ID_COL, DESCR_COL };

		private final FormToolkit formToolkit;
		private Button buttonAdd;
		private Button buttonDel;
		private TableViewer tviewer;
		private boolean mutable;
		private List<SingleValue> theList;
		private final TransactionalEditingDomain domain;
		private final DeployModelObject dmo;

		private SingleValueListComposite(Composite parent, List<SingleValue> values, boolean mutable,
				FormToolkit ft, TransactionalEditingDomain domain, DeployModelObject dmo) {
			super(parent, SWT.FLAT);

			this.domain = domain;
			this.dmo = dmo;
			formToolkit = ft;
			setLayout(new GridLayout());

			createStripOfControls();
			createTable(this);

			setInput(values, mutable);
			theList = values;
		}

		/**
		 * @param values
		 * @param mutable
		 */
		public void setInput(List<SingleValue> values, boolean mutable) {
			this.mutable = mutable;
			theList = values;
			tviewer.setInput(values);
		}

		private void createStripOfControls() {
			Composite row = formToolkit.createComposite(this, SWT.FLAT);
			GridLayout gd = new GridLayout(2, false);
			gd.marginHeight = 0;
			row.setLayout(gd);
			row.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			formToolkit.createLabel(row, Messages.EnumerationConstraintUIHandler_Value_);
			Composite commandRow = createAddRemoveRow(row);
			commandRow.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));
		}

		private Composite createAddRemoveRow(Composite parent) {
			Composite row = formToolkit.createComposite(parent, SWT.FLAT);
			GridLayout gd = new GridLayout(2, false);
			gd.marginHeight = 0;
			gd.marginWidth = 0;
			row.setLayout(gd);

			buttonAdd = formToolkit.createButton(row, "", SWT.PUSH); //$NON-NLS-1$
			buttonAdd.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_ADD));
			buttonAdd.setToolTipText(Messages.EnumerationConstraintUIHandler_Add_Valu_);
			buttonAdd.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					// do nothing
				}

				public void widgetSelected(SelectionEvent e) {
					addSingleValue();
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
					deleteSingleValue();
				}
			});

			return row;
		}

		private void deleteSingleValue() {
			PropertyUtils.deleteFromModel(getSelectedSingleValues(), dmo,
					Messages.EnumerationConstraintUIHandler_Remove_Valu_);
			tviewer.refresh(false);
		}

		private void addSingleValue() {
			SingleValue sv = ConstraintFactory.eINSTANCE.createSingleValue();
			sv.setValue(Messages.EnumerationConstraintUIHandler_newValu_);

			// Create a Command (so Undo will work, and to get transactional wrapper)
			//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theList);
			if (domain != null) {
				AddCommand ac = new AddCommand(domain, (EList<?>) theList, sv);
				PropertyUtils.executeWithUndo(dmo, ac);
			}

			tviewer.refresh(false);
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

			String[] colHeadersAttrib = new String[] { Messages.EnumerationConstraintUIHandler_Valu_,
					Messages.EnumerationConstraintUIHandler_Descriptio_ };
			for (int i = 0; i < colHeadersAttrib.length; i++) {
				TableColumn col = new TableColumn(table, SWT.LEFT);
				col.setText(colHeadersAttrib[i]);
				col.setWidth(115);
			}

			tviewer = new TableViewer(table);
			tviewer.setContentProvider(new ListTableContentProvider());
			tviewer.setLabelProvider(new SingleValueTableLabelProvider());

			GridData gdTable = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
			gdTable.minimumHeight = 85;
			table.setLayoutData(gdTable);

			attachCellEditors();
		}

		protected void enableDisableControls() {
			List<SingleValue> singleValues = getSelectedSingleValues();
			//		ExtendedAttribute first = extendedAttribute != null && extendedAttribute.size() > 0 ? extendedAttribute.get(0) : null;

			boolean selected = singleValues != null;
			buttonAdd.setEnabled(mutable);
			buttonDel.setEnabled(mutable && selected);
		}

		private List<SingleValue> getSelectedSingleValues() {
			if (tviewer.getSelection() instanceof StructuredSelection) {
				StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
				if (ss.getFirstElement() instanceof SingleValue) {
					return ss.toList();
				}
			}

			return null;
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

			tviewer.setCellModifier(new SingleValueValueModifier(this));
		}

		private boolean isMutable() {
			return mutable;
		}

		private void refresh() {
			tviewer.refresh();
		}

		private static class ListTableContentProvider implements IStructuredContentProvider {

			private final static Object[] NONE = new Object[0];

			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					List<?> l = (List<?>) inputElement;
					return l.toArray();
				}

				return NONE;
			}

			public void dispose() {
				// do nothing
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// do nothing
			}

		} // end static inner class ListTableContentProvider

		private static class SingleValueTableLabelProvider extends LabelProvider implements
				ITableLabelProvider {

			private SingleValueTableLabelProvider() {
				// does nothing
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof SingleValue) {
					SingleValue sv = (SingleValue) element;

					if (columnIndex == 1) {
						return sv.getDescription() != null ? sv.getDescription() : ""; //$NON-NLS-1$
					}

					return sv.getValue() != null ? sv.getValue() : ""; //$NON-NLS-1$
				}

				return element.toString();
			}

		} // end inner class SingleValueTableLabelProvider

		private static class SingleValueValueModifier implements ICellModifier {

			private final SingleValueListComposite svc;

			private SingleValueValueModifier(SingleValueListComposite svc) {
				this.svc = svc;
			}

			public boolean canModify(Object element, String property) {
				return svc.isMutable();
			}

			public Object getValue(Object element, String property) {
				// Note that it is possible for an SWT Item to be passed instead of the model element.
				if (element instanceof Item) {
					element = ((Item) element).getData();
				}

				//			System.out.println(element);

				if (element instanceof SingleValue) {
					SingleValue sv = (SingleValue) element;
					if (property.equals(DESCR_COL)) {
						return sv.getDescription() != null ? sv.getDescription() : ""; //$NON-NLS-1$
					} else {
						return sv.getValue();
					}
				}

				return null;
			}

			public void modify(Object element, final String property, final Object value) {
				// Note that it is possible for an SWT Item to be passed instead of the model element.
				if (element instanceof Item) {
					element = ((Item) element).getData();
				}

				//	System.out.println("el=" + element + " prop=" + property + " val=" + value); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				if (element instanceof SingleValue) {
					final SingleValue sv = (SingleValue) element;
					String msg = Messages.EnumerationConstraintUIHandler_Set_Valu_;
					PropertyUtils.executeWithUndo(sv, msg, new Runnable() {

						public void run() {
							String v = (String) value;
							if (property.equals(DESCR_COL)) {
								sv.setDescription(v);
							} else {
								sv.setValue(v);
							}
						}
					});

					svc.refresh();
				}
			}
		} // end inner class SingleValueValueModifier

	} // end class StringListComposite

} // end class ScriptUIHandler

