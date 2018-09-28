/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class StatusTreeViewer extends TreeViewer {
	private TableViewerConfig setting;

	private IWorkbenchSiteProgressService progressService;

	/**
	 * 
	 * @param parent
	 * @param setting
	 * @param progressService
	 */
	public StatusTreeViewer(Composite parent, TableViewerConfig setting,
			IWorkbenchSiteProgressService progressService) {
		super(new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION));
		this.setting = setting;
		this.progressService = progressService;

	}

	public void createControl() {
		createScollable();
		createColumnTitle();

	}

	protected void createScollable() {
		final Scrollable scrollable = (Scrollable) getControl();
		ScrollBar bar = scrollable.getVerticalBar();
		if (bar != null) {
			bar.setSelection(setting.getVerticalScrollBarPosition());
		}
		bar = scrollable.getHorizontalBar();
		if (bar != null) {
			bar.setSelection(setting.getHorizonScollBarPosition());
		}
	}

	private void createColumnTitle() {
		int i = 0;
		final Tree table = getTree();
		final int[] widthArr = setting.getColumnWidth();

		for (i = 0; i < setting.getTableFields().length; i++) {
			final TreeColumn column = new TreeColumn(table, 16384);
			column.setText(setting.getTableFields()[i].getColumnHeaderText());
			column.setAlignment(SWT.LEFT);
			column.setWidth(widthArr[i]);
			column.setMoveable(true);

			column.addSelectionListener(getHeaderListener());
			column.setData(setting.getTableFields()[i]);

		}
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setEnabled(true);
		final int[] order = setting.getColumnOrder();
		if (order != null && order.length == setting.getTableFields().length) {
			table.setColumnOrder(order);
		}
	}

	protected SelectionListener getHeaderListener() {
		return new SelectionAdapter() {
			/**
			 * Resort the table based on field.
			 * 
			 * @param column
			 *           the column being updated
			 * @param field
			 * @param monitor
			 */
			private void resortTable(final TreeColumn column, final IStatusField field,
					IProgressMonitor monitor) {
				monitor.beginTask(Messages.PublisherProblems_UpdateStatusJob_Name, 100);
				monitor.worked(10);
				if (field.equals(getTableSorter().getTopField()))
					getTableSorter().reverseTopPriority();
				else
					getTableSorter().setTopPriority(field);

				monitor.worked(15);
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					/*
					 * (non-Javadoc)
					 * 
					 * @see java.lang.Runnable#run()
					 */
					public void run() {
						refresh();
						updateDirectionIndicator(column);
					}
				});

				monitor.done();
			}

			/**
			 * Handles the case of user selecting the header area.
			 */
			public void widgetSelected(SelectionEvent e) {

				final TreeColumn column = (TreeColumn) e.widget;
				final IStatusField field = (IStatusField) column.getData();

				try {
					final IWorkbenchSiteProgressService ps = progressService;
					if (progressService == null)
						BusyIndicator.showWhile(getControl().getShell().getDisplay(), new Runnable() {
							/*
							 * (non-Javadoc)
							 * 
							 * @see java.lang.Runnable#run()
							 */
							public void run() {
								resortTable(column, field, new NullProgressMonitor());

							}
						});
					else
						ps.busyCursorWhile(new IRunnableWithProgress() {
							/*
							 * (non-Javadoc)
							 * 
							 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
							 */
							public void run(IProgressMonitor monitor) {
								resortTable(column, field, monitor);
							}
						});
				} catch (final InvocationTargetException e1) {
					//TODO
					/*
					 * IDEWorkbenchPlugin.getDefault().getLog().log( Util.errorStatus(e1));
					 */
				} catch (final InterruptedException e1) {
					return;
				}

			}
		};
	}

	/**
	 * 
	 * @return statusSorter
	 */

	public StatusSorter getTableSorter() {
		return (StatusSorter) getSorter();
	}

	private void updateDirectionIndicator(TreeColumn column) {
		getTree().setSortColumn(column);
		if (getTableSorter().getTopPriorityDirection() == StatusSorter.ASCENDING)
			getTree().setSortDirection(SWT.UP);
		else
			getTree().setSortDirection(SWT.DOWN);
	}

	void setSortIndicators() {

		final IStatusField top = getTableSorter().getTopField();
		final TreeColumn[] columns = getTree().getColumns();
		for (int i = 0; i < columns.length; i++) {
			final TreeColumn column = columns[i];
			if (column.getData().equals(top)) {
				updateDirectionIndicator(column);
				return;
			}
		}
	}

	/**
	 * 
	 * @param dialog
	 */
	public void updateSorter(SortDialog dialog) {
		StatusSorter newSorter = dialog.getSorter();
		setSorter(newSorter);
		refresh();
		setSortIndicators();
	}

	/**
	 * 
	 * 
	 */
	public void resetColumnWidth() {
		TreeColumn[] columns = getTree().getColumns();
		final int[] widthArr = setting.getColumnWidth();
		for (int i = 0; i < columns.length; i++) {
			columns[i].setWidth(widthArr[i]);

		}

	}

}
