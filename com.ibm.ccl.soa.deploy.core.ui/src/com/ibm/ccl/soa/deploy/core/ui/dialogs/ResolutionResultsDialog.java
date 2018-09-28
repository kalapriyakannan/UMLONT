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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionResultsData;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;

/**
 * @since 1.0
 * 
 */
public class ResolutionResultsDialog extends Dialog {

	private TableViewer resolutionViewer = null;
	Map<View, EditPart> editpartMap;
	private Map<Object, ResolutionResultsData> _resolutionResultsMap = null;

	// column data
	protected String[] variableTableColumnHeaders = { Messages.CHANGE, Messages.TYPE, Messages.NAME, };
	protected static String[] tableColumnProperties = { Messages.CHANGE, Messages.TYPE,
			Messages.NAME, };
	protected ColumnLayoutData[] tableColumnLayouts = { new ColumnWeightData(10),
			new ColumnWeightData(20), new ColumnWeightData(70), };

	private final String resolutionDesc;

	private final EditPartViewer viewer;

	/**
	 * @param results
	 * @param parentShell
	 * @param resolutionDesc
	 * @param viewer
	 */
	public ResolutionResultsDialog(Map<Object, ResolutionResultsData> results, Shell parentShell,
			String resolutionDesc, EditPartViewer viewer) {
		super(parentShell);
		this.resolutionDesc = resolutionDesc;
		this.viewer = viewer;
		editpartMap = viewer.getEditPartRegistry();
		_resolutionResultsMap = results;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	public Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.ENABLE_QUICKFIX_RESULT_DIALOG);

		getShell().setText(Messages.SELECT_RESOLUTIONDMO_TITLE);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createListArea(composite);

		return composite;
	}

	/**
	 * Create the List widget
	 * 
	 * @param parent
	 *           The parent to create this widget in
	 */
	private void createListArea(Composite parent) {

		Label resnote = new Label(parent, SWT.NONE);
		resnote.setText(NLS.bind(Messages.SELECT_RESOLUTIONDMO_RESNOTE, resolutionDesc));

		Table table = new Table(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 550;
		gridData.heightHint = 150;
		table.setLayoutData(gridData);
		table.setFont(parent.getFont());

		Label status = new Label(parent, SWT.NONE);
		status.setText(Messages.SELECT_RESOLUTIONDMO_NOTE);

		resolutionViewer = new TableViewer(table);
		resolutionViewer.setContentProvider(new DependencyContentProvider());
		resolutionViewer.setLabelProvider(new DependencyLabelProvider());
		resolutionViewer.setSorter(new ViewerSorter() {

			public int compare(Viewer viewer, Object o1, Object o2) {
				if (o1 instanceof Entry && o2 instanceof Entry) {

					ResolutionResultsData d1 = (ResolutionResultsData) ((Entry) o1).getValue();
					ResolutionResultsData d2 = (ResolutionResultsData) ((Entry) o2).getValue();
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
						if (!d1.isHidden() && d2.isHidden()) {
							return -1;
						} else if (d1.isHidden() && !d2.isHidden()) {
							return 1;
						} else {
							return d1.getType().compareTo(d2.getType());
						}
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
		resolutionViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				TableItem[] tableitems = resolutionViewer.getTable().getSelection();
				if (tableitems.length > 0) {
					Entry entry = (Entry) tableitems[0].getData();
					ResolutionResultsData data = (ResolutionResultsData) entry.getValue();
					if (data.getChange() != ResolutionResultsData.DELETED) {
						viewer.deselectAll();
						DeployModelObject dmo = data.getDmo();
						List<AbstractGraphicalEditPart> epList = ResolutionUIUtils.getEditPartsForUnit(
								editpartMap, dmo);
						if (epList.size() == 0) {
							if (dmo instanceof MemberLink) {
								MemberLink link = (MemberLink) dmo;
								epList = ResolutionUIUtils.getTargetEditParts(editpartMap,
										link.getSource(), link.getTarget());
							} else if (dmo instanceof HostingLink) {
								HostingLink link = (HostingLink) dmo;
								epList = ResolutionUIUtils.getTargetEditParts(editpartMap,
										link.getSource(), link.getTarget());
							}
						}
						for (Iterator<AbstractGraphicalEditPart> it = epList.iterator(); it.hasNext();) {
							AbstractGraphicalEditPart ep = it.next();
							if (ep instanceof GraphicalEditPart) {
								ZoomUtils.expose(((GraphicalEditPart) ep).getEditingDomain(), ep);
							}
						}
						if (epList.size() > 0) {
							viewer.reveal(epList.get(0));
							viewer.setSelection(new StructuredSelection(epList));
						}
					}
				}
			}

		});
		resolutionViewer.setInput(this);
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		if (id == IDialogConstants.CANCEL_ID) {
			label = Messages.ResolutionResultsDialog_0;
		}
		return super.createButton(parent, id, label, defaultButton);
	}

	@Override
	protected void cancelPressed() {
		viewer.getEditDomain().getCommandStack().undo();
		super.cancelPressed();
	}

	@Override
	public int open() {
		// make this dialog modeless
		setBlockOnOpen(false);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | getDefaultOrientation());
		// now open it
		return super.open();
	}

	// position at bootom of screen
	@Override
	protected Point getInitialLocation(Point initialSize) {
		Composite parent = getShell().getParent();
		Monitor monitor = getShell().getDisplay().getPrimaryMonitor();
		if (parent != null) {
			monitor = parent.getMonitor();
		}
		Rectangle monitorBounds = monitor.getClientArea();
		if (parent != null) {
			monitorBounds = parent.getBounds();
		}
		int x = monitorBounds.x + monitorBounds.width - initialSize.x - 30;
		x = Math.max(monitorBounds.x, x);
		int y = monitorBounds.y + monitorBounds.height - initialSize.y - 30;
		y = Math.max(monitorBounds.y, y);
		return new Point(x, y);
	}

	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////
	///////////////////////////////////// CONTENT PROVIDER /////////////////////////////////////////////

	private class DependencyContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return _resolutionResultsMap.entrySet().toArray();
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
			Entry entry = (Entry) element;
			ResolutionResultsData data = (ResolutionResultsData) entry.getValue();
			switch (columnIndex)
			{
			case 0:
				switch (data.getChange())
				{
				case ResolutionResultsData.ADDED:
					return "new"; //$NON-NLS-1$
				case ResolutionResultsData.DELETED:
					return "deleted"; //$NON-NLS-1$
				case ResolutionResultsData.RETARGETED:
					return "retargeted"; //$NON-NLS-1$
				default:
				}
				break;
			case 1:
				return (data.isHidden() ? "Hidden " : "") + data.getType(); //$NON-NLS-1$//$NON-NLS-2$
			case 2:
				return data.getName();
			}
			return null;
		}
	}

}
