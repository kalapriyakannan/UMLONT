package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;

public class IconSelectionDialog extends TrayDialog {

	private static final int MAX_COLUMNS = 8;

	private final ILabelProvider renderer;

	private TableViewer tv;

	private final Object[] adpe;

	private DynamicPaletteEntry result;

	private TableCursor cursor;

	public IconSelectionDialog(Shell parent, ILabelProvider rend, Object[] acontent) {
		super(parent);

		renderer = rend;
		adpe = acontent;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.BankUnitAction_Select_Ico_);
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		getButton(IDialogConstants.OK_ID).setEnabled(getSelectedIcon() != null);

		return c;
	}

	private DynamicPaletteEntry getSelectedIcon() {
		if (tv.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tv.getSelection();
			Object res = ss.getFirstElement();
			if (res instanceof List) {
				List<?> l = (List<?>) res;
				if (l.size() > cursor.getColumn()) {
					return (DynamicPaletteEntry) l.get(cursor.getColumn());
				}
			}
		}

		return null;
	}

	/**
	 * @return an object of the type originally passed to constructor
	 */
	public Object getFirstResult() {
		return result;
	}

	private List<List<Object>> chunk(Object[] adpe2) {
		List<List<Object>> retVal = new LinkedList<List<Object>>();
		List<Object> lrow = null;
		for (int i = 0; i < adpe2.length; i++) {
			int row = i / MAX_COLUMNS;
			if (retVal.size() <= row) {
				lrow = new ArrayList<Object>();
				retVal.add(lrow);
			}
			lrow.add(adpe2[i]);
		}

		return retVal;
	}

	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_BROWSE_ICON);

		final Table table = new Table(contents, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);

		for (int i = 0; i < MAX_COLUMNS; i++) {
			TableColumn tc = new TableColumn(table, SWT.CENTER);
			tc.setWidth(32);
			tc.setResizable(false);
		}

		cursor = new TableCursor(table, SWT.NONE);
		cursor.addSelectionListener(new SelectionListener() {
			// when the TableEditor is over a cell, select the corresponding row in 
			// the table
			public void widgetSelected(SelectionEvent e) {
				table.setSelection(new TableItem[] { cursor.getRow() });
				getButton(IDialogConstants.OK_ID).setEnabled(getSelectedIcon() != null);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				okPressed();
			}

		});

		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				okPressed();
			}
		});

		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tv = new TableViewer(table);
		tv.setContentProvider(new IconContentProvider());
		tv.setLabelProvider(new IconLabelProvider(renderer));
		tv.setInput(chunk(adpe));

		cursor.setSelection(0, 0);
		table.setSelection(new TableItem[] { cursor.getRow() });

		return contents;
	}

	@Override
	protected void okPressed() {
		result = getSelectedIcon();
		if (result != null) {
			super.okPressed();
		}
	}

	private static class IconContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection) {
				Collection<?> c = (Collection<?>) inputElement;
				return c.toArray();
			}
			return null;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private static class IconLabelProvider extends LabelProvider implements ITableLabelProvider {

		private final ILabelProvider baseLabelProvider;

		private IconLabelProvider(ILabelProvider labelProvider) {
			baseLabelProvider = labelProvider;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof List) {
				List<?> l = (List<?>) element;
				if (l.size() > columnIndex) {
					Object nth = l.get(columnIndex);
					return baseLabelProvider.getImage(nth);
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			return ""; //$NON-NLS-1$
		}

	}
}
