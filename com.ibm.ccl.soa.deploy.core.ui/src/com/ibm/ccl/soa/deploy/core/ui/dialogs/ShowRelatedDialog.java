/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * @since 1.0
 * 
 */
public class ShowRelatedDialog extends Dialog {

	private TableViewer _listViewer = null;

	// column data
	protected String[] variableTableColumnHeaders = { Messages.ShowRelatedDialog_0 };
	protected static String[] tableColumnProperties = { Messages.ShowRelatedDialog_0 };
	protected ColumnLayoutData[] tableColumnLayouts = { new ColumnWeightData(100) };

	private Combo _comboLevel;
	private Button _checkInfinite;

	public static final int SHOW_HOSTS = 2;
	public static final int SHOW_HOSTEES = 3;
	public static final int SHOW_REQUIREMENTS = 4;
	public static final int SHOW_CAPABILITIES = 5;
	public static final int SHOW_REALIZED = 6;
	public static final int SHOW_REALIZER = 7;
	public static final int SHOW_CONSTRAINTS = 8;
	public static final int SHOW_CONSTRAINTERS = 9;
	public static final int SHOW_MEMBERS = 10;
	public static final int SHOW_CONTAINERS = 11;

	private List<Integer> _options;

	private List<Integer> _selections;
	private int _level;

	/**
	 * @param parentShell
	 */
	public ShowRelatedDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle());
	}

	@Override
	protected Point getInitialSize() {
		Point pt = super.getInitialSize();
		pt.x = 280;
		return pt;
	}

	public Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.SHOW_RELATED_ELEMENT_DIALOG);

		getShell().setText(Messages.ShowRelatedDialog_2);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createListArea(composite);
		createLevelArea(composite);

		return composite;
	}

	/**
	 * Create the List widget
	 * 
	 * @param parent
	 *           The parent to create this widget in
	 */
	private void createListArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		Label filler = new Label(composite, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_VERTICAL);
		gd.widthHint = 30;
		filler.setLayoutData(gd);

		Table table = new Table(composite, SWT.CHECK | SWT.BORDER);
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.widthHint = 160;
		gridData.heightHint = 160;
		table.setLayoutData(gridData);
		table.setFont(parent.getFont());

		_listViewer = new TableViewer(table);
		_listViewer.setContentProvider(new DependencyContentProvider());
		_listViewer.setLabelProvider(new DependencyLabelProvider());

		// Create columns
		_listViewer.setColumnProperties(tableColumnProperties);
		for (int i = 0; i < tableColumnProperties.length; i++) {
			tableLayout.addColumnData(tableColumnLayouts[i]);
			TableColumn tc = new TableColumn(table, SWT.NONE, i);
			tc.setResizable(tableColumnLayouts[i].resizable);
			tc.setText(variableTableColumnHeaders[i]);
		}

		Composite composite2 = new Composite(parent, SWT.NULL);
		composite2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout2 = new GridLayout(4, false);
		composite2.setLayout(layout2);
		Label filler2 = new Label(composite2, SWT.NONE);
		GridData gd2 = new GridData(GridData.FILL_VERTICAL);
		gd2.widthHint = 30;
		filler2.setLayoutData(gd2);

		Button selectButton = new Button(composite2, SWT.PUSH);
		selectButton.setText(Messages.ShowRelatedDialog_3);
		selectButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				checkAllItems(true);
			}
		});

		Button deselectButton = new Button(composite2, SWT.PUSH);
		deselectButton.setText(Messages.ShowRelatedDialog_4);
		deselectButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				checkAllItems(false);
			}
		});

		_options = new ArrayList<Integer>();
		_options.add(SHOW_HOSTS);
		_options.add(SHOW_HOSTEES);
		_options.add(SHOW_REQUIREMENTS);
		_options.add(SHOW_CAPABILITIES);
		_options.add(SHOW_REALIZED);
		_options.add(SHOW_REALIZER);
		_options.add(SHOW_CONSTRAINTS);
		_options.add(SHOW_CONSTRAINTERS);
		_options.add(SHOW_MEMBERS);
		_options.add(SHOW_CONTAINERS);

		_listViewer.setInput(this);
	}

	private void checkAllItems(boolean b) {
		TableItem[] items = _listViewer.getTable().getItems();
		for (int i = 0; i < items.length; i++) {
			items[i].setChecked(b);
		}
	}

	private void createLevelArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label prompt1 = new Label(composite, SWT.NONE);
		prompt1.setText(Messages.ShowRelatedDialog_5);

		_comboLevel = new Combo(composite, SWT.READ_ONLY);
		//	_comboLevel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		for (int i = 1; i <= 10; i++) {
			_comboLevel.add(Integer.toString(i));
		}
		_comboLevel.setText("1"); //$NON-NLS-1$
		_comboLevel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		_comboLevel.setFont(parent.getFont());

		Label prompt2 = new Label(composite, SWT.NONE);
		prompt2.setText(Messages.ShowRelatedDialog_6);

		_checkInfinite = new Button(composite, SWT.CHECK);
		_checkInfinite.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				_comboLevel.setEnabled(!_checkInfinite.getSelection());
			}
		});

	}

	@Override
	protected void okPressed() {
		_selections = new ArrayList<Integer>();
		TableItem[] items = _listViewer.getTable().getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				_selections.add((Integer) items[i].getData());
			}
		}
		_level = _comboLevel.getSelectionIndex() + 1;
		if (_checkInfinite.getSelection()) {
			_level = 15;
		}

		super.okPressed();
	}

	/**
	 * @return any selections
	 */
	public List<Integer> getSelections() {
		return _selections;
	}

	/**
	 * @return level of showing
	 */
	public int getLevel() {
		return _level;
	}

	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////

	private class DependencyContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return _options.toArray();
		}

		public void dispose() {
		}

	}

	///////////////////////////////////// LABEL PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// LABEL PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// LABEL PROVIDER /////////////////////////////////////////////

	private class DependencyLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch ((Integer) element)
			{
			case SHOW_HOSTS:
				return Messages.ShowRelatedAction_0;//Host Elements
			case SHOW_HOSTEES:
				return Messages.ShowRelatedAction_1;//Hosted Elements
			case SHOW_REQUIREMENTS:
				return Messages.ShowRelatedAction_2;//Required Elements
			case SHOW_CAPABILITIES:
				return Messages.ShowRelatedAction_3;//Dependent Elements
			case SHOW_REALIZED:
				return Messages.ShowRelatedAction_4;//Conceptual Elements
			case SHOW_REALIZER:
				return Messages.ShowRelatedAction_5;//Concrete Elements
			case SHOW_CONSTRAINTS:
				return Messages.ShowRelatedAction_7;//Constrained Elements
			case SHOW_CONSTRAINTERS:
				return Messages.ShowRelatedAction_6;//Constraining Elements
			case SHOW_MEMBERS:
				return Messages.ShowRelatedAction_8;//Member Elements
			case SHOW_CONTAINERS:
				return Messages.ShowRelatedAction_9;//Group Elements
			}
			return ""; //$NON-NLS-1$
		}
	}

}
