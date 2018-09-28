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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.util.IOpenEventListener;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Provide the user with a list of options to choose from using a modal, but easy to dismiss, quick
 * dialog.
 * 
 * @param <T>
 *           The Type of options that can be returned from {@link #getSelectedOptions()}.
 */
public class SelectChangeQuickDialog<T> extends RobustPopupDialog {

	private final String DIALOG_SETTINGS_ID = "topology.diagram.selectchange"; //$NON-NLS-1$
	/**
	 * Border thickness in pixels.
	 */
	private static final int BORDER_THICKNESS = 1;

	private final Point location;
	private final Collection<T> choices;
	private final Collection<T> selected = new ArrayList<T>(3);
	private TableViewer viewer;
	private boolean listenToDeactivate;
	protected boolean listenToParentDeactivate;
	private Listener parentDeactivateListener;
	private final IBaseLabelProvider labelProvider;
	private String[] columnTitles;
	private int[] columnWidths;

	/**
	 * Create a quick dialog that is modal, but easy to dismiss, in order to present the user with
	 * the given list of options. The labelProvider will be used to provide the user with a
	 * translated message for each option in the list.
	 * 
	 * @param parent
	 *           The parent shell to open in front of.
	 * @param openLocation
	 *           The location of the top left corner of the quick dialog when it opens.
	 * @param options
	 *           The list of choices that should be presented to the user.
	 * @param optionLabelProvider
	 *           The label provider to provide translated text labels and icons for the list of
	 *           options.
	 */
	public SelectChangeQuickDialog(Shell parent, Point openLocation, Collection<T> options,
			ITableLabelProvider optionLabelProvider) {
		super(parent, SWT.TOOL | SWT.RESIZE | SWT.APPLICATION_MODAL, true, false, false, false, null,
				Messages.SelectChangeQuickDialog_Please_select_a_change_to_perform_);
		this.location = openLocation;
		this.choices = options;
		this.labelProvider = optionLabelProvider;
		setBlockOnOpen(true);
	}

	/**
	 * Create a quick dialog that is modal, but easy to dismiss, in order to present the user with
	 * the given list of options. The labelProvider will be used to provide the user with a
	 * translated message for each option in the list.
	 * 
	 * @param parent
	 *           The parent shell to open in front of.
	 * @param openLocation
	 *           The location of the top left corner of the quick dialog when it opens.
	 * @param options
	 *           The list of choices that should be presented to the user.
	 * @param instruction
	 *           A translated string to show the user instructing them on what the choice will do.
	 * @param optionLabelProvider
	 *           The label provider to provide translated text labels and icons for the list of
	 *           options.
	 * @param columnLabels
	 *           A list of translated column labels to display to the user.
	 * @param initialColumnWidths
	 *           The set of initial widths for each column.
	 */
	public SelectChangeQuickDialog(Shell parent, Point openLocation, Collection<T> options,
			String instruction, ITableLabelProvider optionLabelProvider, String[] columnLabels,
			int[] initialColumnWidths) {
		super(parent, SWT.TOOL | SWT.RESIZE | SWT.APPLICATION_MODAL, true, false, false, false, null,
				instruction);
		this.location = openLocation;
		this.choices = options;
		this.labelProvider = optionLabelProvider;
		this.columnTitles = columnLabels;
		this.columnWidths = initialColumnWidths;
		setBlockOnOpen(true);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		viewer = new TableViewer(parent, getTableStyleBits()) {

			protected void hookControl(Control control) {
				super.hookControl(control);
				CustomizedOpenStrategy handler = new CustomizedOpenStrategy(control,
						getOpenStrategyType());
				handler.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent e) {
						SelectChangeQuickDialog.this.handleSelect(e);
						handleSelect(e);
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						handleDoubleSelect(e);
					}
				});
				handler.addPostSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						handlePostSelect(e);
					}
				});
				handler.addOpenListener(new IOpenEventListener() {
					public void handleOpen(SelectionEvent e) {
						apply();
					}
				});
			}
		};

		viewer.setContentProvider(new SelectChangeContentProvider());
		viewer.setLabelProvider(labelProvider);
		viewer.setInput(choices);

		viewer.setSelection(StructuredSelection.EMPTY);

		if (columnTitles != null && columnTitles.length > 0) {
			viewer.setColumnProperties(columnTitles);
			TableLayout tableLayout = new TableLayout();
			Table table = (Table) viewer.getControl();
			table.setLayout(tableLayout);
			table.setHeaderVisible(true);
			table.setLinesVisible(false);

			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.widthHint = 300;
			gridData.heightHint = 100;
			table.setLayoutData(gridData);
			table.setFont(parent.getFont());

			for (int i = 0; i < columnTitles.length; i++) {
				tableLayout.addColumnData(new ColumnWeightData(columnWidths[i]));
				TableColumn tc = new TableColumn(table, SWT.NONE, i);
				tc.setResizable(true);
				tc.setText(columnTitles[i]);

				tc.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						// Header was selected so sort the table by this column.
						TableColumn column = (TableColumn) e.getSource();
						Table myTable = viewer.getTable();
						myTable.setSortColumn(column);
						int direction = toggleSortDirection(column);
						myTable.setSortDirection(direction);
						viewer.refresh();
					}

					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
			}

		}

		viewer.setComparator(new ViewerComparator() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				Table table = ((TableViewer) viewer).getTable();
				TableColumn sortColumn = table.getSortColumn();
				int col_index = 0; // default column to sort by
				if (sortColumn != null) {
					col_index = table.indexOf(sortColumn);
				}
				ITableLabelProvider provider = (ITableLabelProvider) ((TableViewer) viewer)
						.getLabelProvider();
				String s1 = provider.getColumnText(e1, col_index);
				String s2 = provider.getColumnText(e2, col_index);

				//Default for SWT.DOWN.
				String first = s2;
				String second = s1;

				if (table.getSortDirection() == SWT.UP) {
					first = s1;
					second = s2;
				}

				boolean isFirstEmpty = first == null || first.length() == 0;
				boolean isSecondEmpty = second == null || second.length() == 0;

				if (isFirstEmpty) {
					if (isSecondEmpty) {
						return 0;
					}
					return -1;
				} else if (isSecondEmpty) {
					if (isFirstEmpty) {
						return 0;
					}
					return 1;
				}

				if (s1.indexOf('%') > -1 && s2.indexOf('%') > -1) {

					//Compare integers.
					Integer firstInt = Integer.valueOf(first.substring(0, first.length() - 1));
					Integer secondInt = Integer.valueOf(second.substring(0, second.length() - 1));
					return firstInt.compareTo(secondInt);
				}
				return getComparator().compare(first, second);
			}
		});

		return viewer.getControl();
	}

	/**
	 * @return An int for the table style.
	 */
	protected int getTableStyleBits() {
		return SWT.BORDER | SWT.FULL_SELECTION | SWT.SINGLE;
	}

	protected void handleSelect(SelectionEvent e) {
		if (_applyControl != null) {
			if (e.getSource() == viewer.getTable()) {
				ISelection selection = viewer.getSelection();
				_applyControl.setEnabled(!selection.isEmpty());
			}
		}
	}

	/**
	 * Override to change the click behavior of the dialog (defaults to Single Click) via
	 * {@link CustomizedOpenStrategy#SINGLE_CLICK} ro {@link CustomizedOpenStrategy#DOUBLE_CLICK}
	 */
	protected int getOpenStrategyType() {
		return CustomizedOpenStrategy.SINGLE_CLICK;
	}

	protected int toggleSortDirection(TableColumn column) {
		Object data = column.getData();
		if (data == null) {
			//Set initial direction
			column.setData(new Integer(SWT.DOWN));
			return SWT.DOWN;
		}
		switch (((Integer) data).intValue())
		{
		case SWT.DOWN:
			column.setData(new Integer(SWT.UP));
			return SWT.UP;
		case SWT.UP:
			column.setData(new Integer(SWT.DOWN));
			return SWT.DOWN;
		}
		return SWT.DOWN;
	}

	protected Point getInitialLocation(Point initialSize) {
		return location;
	}

	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings().getSection(
				DIALOG_SETTINGS_ID);

		if (settings == null) {
			settings = DeployCoreUIPlugin.getDefault().getDialogSettings().addNewSection(
					DIALOG_SETTINGS_ID);
		}
		return settings;
	}

	public Collection<T> getSelectedOptions() {
		if (selected == null) {
			return Collections.emptyList();
		}
		return selected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(Shell)
	 */
	protected void configureShell(Shell shell) {
		Display display = shell.getDisplay();
		shell.setBackground(display.getSystemColor(SWT.COLOR_BLACK));

		int border = (getShellStyle() & SWT.NO_TRIM) == 0 ? 0 : BORDER_THICKNESS;
		GridLayoutFactory.fillDefaults().margins(border, border).spacing(5, 5).applyTo(shell);

		// Set this true whenever we activate. It may have been turned
		// off by a menu or secondary popup showing.
		shell.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event event) {
				// ignore this event if we have launched a child
				if (event.widget == getShell() && getShell().getShells().length == 0) {
					listenToDeactivate = true;
					// Typically we start listening for parent deactivate after
					// we are activated, except on the Mac, where the deactivate
					// is received after activate.
					// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=100668
					listenToParentDeactivate = !"carbon".equals(SWT.getPlatform()); //$NON-NLS-1$
				}
			}
		});

		if ((getShellStyle() & SWT.ON_TOP) != 0 && shell.getParent() != null) {
			parentDeactivateListener = new Listener() {
				public void handleEvent(Event event) {
					if (listenToParentDeactivate) {
						close();
					} else {
						// Our first deactivate, now start listening on the Mac.
						listenToParentDeactivate = listenToDeactivate;
					}
				}
			};
			shell.getParent().addListener(SWT.Deactivate, parentDeactivateListener);
		}

	}

	protected void apply() {
		ISelection selection = viewer.getSelection();
		if (!selection.isEmpty()) {
			IStructuredSelection sSel = (IStructuredSelection) selection;
			for (Iterator iterator = sSel.iterator(); iterator.hasNext();) {
				T stub = (T) iterator.next();
				selected.add(stub);
			}
			close();
		}
	}

	/**
	 * A simple content provider that returns the set of options supplied in the Constructor.
	 * 
	 */
	public class SelectChangeContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object parentElement) {
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection) {
				return ((Collection) inputElement).toArray();
			}
			return null;
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

}
