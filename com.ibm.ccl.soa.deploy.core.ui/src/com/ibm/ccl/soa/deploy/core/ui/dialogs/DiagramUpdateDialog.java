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

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
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
public class DiagramUpdateDialog extends Dialog {

	private TableViewer resolutionViewer = null;
	private final List<DiagramUpdateData> _changes;
	private final EditPartViewer _viewer;

	// column data
	protected String[] variableTableColumnHeaders = { Messages.CHANGE, Messages.TYPE, Messages.NAME, };
	protected static String[] tableColumnProperties = { Messages.CHANGE, Messages.TYPE,
			Messages.NAME, };
	protected ColumnLayoutData[] tableColumnLayouts = { new ColumnWeightData(20),
			new ColumnWeightData(25), new ColumnWeightData(55), };

	/**
	 * @param changes
	 * @param viewer
	 * @param parentShell
	 */
	public DiagramUpdateDialog(List<DiagramUpdateData> changes, EditPartViewer viewer,
			Shell parentShell) {
		super(parentShell);
		_changes = changes;
		_viewer = viewer;
		//	setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	public Control createDialogArea(Composite parent) {

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_UPDATE_WINDOW);

		getShell().setText(Messages.DiagramRefreshDialog_Diagram_Updat_);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createListArea(composite);

		//PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IDeployHelpContextIds.CREATE_DEPENDENCY_LINK_DIALOG);

		return composite;
	}

	/**
	 * Create the List widget
	 * 
	 * @param parent
	 *           The parent to create this widget in
	 */
	private void createListArea(Composite parent) {

		Label l = new Label(parent, SWT.NONE);
		l.setText(Messages.DiagramRefreshDialog_The_diagram_was_updated_to_reflect_);

		Table table = new Table(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 600;
		gridData.heightHint = 150;
		table.setLayoutData(gridData);
		table.setFont(parent.getFont());

		Label status = new Label(parent, SWT.NONE);
		status.setText(Messages.DiagramUpdateDialog_Select_a_non_deleted_item_to_highli_);

		resolutionViewer = new TableViewer(table);
		resolutionViewer.setContentProvider(new DependencyContentProvider());
		resolutionViewer.setLabelProvider(new DependencyLabelProvider());
		resolutionViewer.setSorter(new ViewerSorter() {

			public int compare(Viewer viewer, Object o1, Object o2) {
				if (o1 instanceof DiagramUpdateData && o2 instanceof DiagramUpdateData) {

					DiagramUpdateData d1 = (DiagramUpdateData) o1;
					DiagramUpdateData d2 = (DiagramUpdateData) o2;
					// first sort on type of change
					if (d1.getChange() < d2.getChange()) {
						return -1;
					} else if (d2.getChange() < d1.getChange()) {
						return 1;
					}
					// then put units at the top
					if (d1.isUnit() && !d2.isUnit()) {
						return -1;
					} else if (!d1.isUnit() && d2.isUnit()) {
						return 1;
					} else if (!d1.isUnit() && !d2.isUnit()) {
						return d1.getType().compareTo(d2.getType());
					}
					return 0;
				}
				return super.compare(viewer, o1, o2);
			}
		});

		// Create columns
		resolutionViewer.setColumnProperties(tableColumnProperties);
		for (int i = 0; i < tableColumnProperties.length; i++) {
			tableLayout.addColumnData(tableColumnLayouts[i]);
			TableColumn tc = new TableColumn(table, SWT.NONE, i);
			tc.setResizable(tableColumnLayouts[i].resizable);
			tc.setText(variableTableColumnHeaders[i]);
		}

		// add selection listener
		resolutionViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				TableItem[] tableitems = resolutionViewer.getTable().getSelection();
				if (tableitems.length > 0) {
					DiagramUpdateData data = (DiagramUpdateData) tableitems[0].getData();
					if (data.getView() != null) {
						_viewer.deselectAll();
						final EditPart ep = (EditPart) _viewer.getEditPartRegistry().get(data.getView());
						if (ep instanceof EditPart) {
							BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

								public void run() {
									_viewer.reveal(ep);
									_viewer.select(ep);
								}
							});
						}
					}
				}
			}

		});
		resolutionViewer.setInput(this);
	}

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////

	private class DependencyContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return _changes.toArray();
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
			DiagramUpdateData data = (DiagramUpdateData) element;
			switch (columnIndex)
			{
			case 0:
				switch (data.getChange())
				{
				case DiagramUpdateData.CREATED:
					return Messages.DiagramRefreshDialog_create_;
				case DiagramUpdateData.DELETED:
					return Messages.DiagramRefreshDialog_delete_;
				case DiagramUpdateData.UNREFED:
					return Messages.DiagramRefreshDialog_unreference_;
				case DiagramUpdateData.REREFED:
					return Messages.DiagramUpdateDialog_Rereference_;
				case DiagramUpdateData.UNCONTAINED:
					return Messages.DiagramUpdateDialog_Uncontaine_;
				default:
				}
				break;
			case 1:
				return data.getType();
			case 2:
				return data.getName();
			}
			return null;
		}
	}

}
