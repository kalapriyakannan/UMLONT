/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.ui.IMemento;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class TableViewerConfig {
	protected IStatusField[] columnFields;
	protected int verticalScrollBarPosition = 0;
	protected int horizonScollBarPosition = 0;
	protected int columnOrder[];
	protected int columnWidth[];

	/**
	 * 
	 * @param columnFields
	 */
	public TableViewerConfig(IStatusField[] columnFields) {
		super();
		this.columnFields = columnFields;
		columnOrder = new int[columnFields.length];
		columnWidth = new int[columnFields.length];
		for (int i = 0; i < columnFields.length; i++) {
			columnOrder[i] = i;
			columnWidth[i] = columnFields[i].getPreferredWidth();
		}
	}

	public TableViewerConfig() {
		this(new IStatusField[] { new FieldMessage(), new FieldException() });
	}

	/**
	 * 
	 * @return column order
	 */
	public int[] getColumnOrder() {
		return columnOrder;
	}

	/**
	 * 
	 * @return column width
	 */
	public int[] getColumnWidth() {
		// TODO Auto-generated method stub
		return columnWidth;
	}

	/**
	 * 
	 * @return horizon scollbar position
	 */
	public int getHorizonScollBarPosition() {

		return horizonScollBarPosition;
	}

	public int getVerticalScrollBarPosition() {
		return verticalScrollBarPosition;
	}

	public IStatusField[] getTableFields() {
		return columnFields;
	}

	/**
	 * @param columnFields
	 *           the columnFields to set
	 */
	public void setTableFields(IStatusField[] columnFields) {
		this.columnFields = columnFields;
	}

	/**
	 * TAG
	 */
	private static String TAG_VERTICAL_SCOLLBAR_POSTITION = "vertical_scollbar_postition"; //$NON-NLS-1$
	private static String TAG_HORIZON_SCOLLBAR_POSTION = "horizon_scollbar_postion"; //$NON-NLS-1$
	private static String TAG_COLUMN_ORDER = "column_order"; //$NON-NLS-1$
	private static String TAG_COLUMN_WIDTH = "column_width"; //$NON-NLS-1$
	private static String TAG_COLUMN_NUM = "column_num"; //$NON-NLS-1$

	/**
	 * 
	 * @param memento
	 */
	public void restoreState(IMemento memento) {
		if (memento != null) {
			int num = Util.getSavedValue(memento, TAG_COLUMN_NUM, -1);
			verticalScrollBarPosition = Util.getSavedValue(memento, TAG_VERTICAL_SCOLLBAR_POSTITION,
					50);
			horizonScollBarPosition = Util.getSavedValue(memento, TAG_HORIZON_SCOLLBAR_POSTION, 50);
			num = (num > columnFields.length ? columnFields.length : num);
			for (int i = 0; i < num; i++) {
				columnOrder[i] = Util.getSavedValue(memento, TAG_COLUMN_ORDER + i, i);
				columnWidth[i] = Util.getSavedValue(memento, TAG_COLUMN_WIDTH + i, columnFields[i]
						.getPreferredWidth());
			}

		}
	}

	/**
	 * save state to memento
	 * 
	 * @param memento
	 */
	public void saveState(IMemento memento) {
		memento.putInteger(TAG_COLUMN_NUM, columnFields.length);
		memento.putInteger(TAG_VERTICAL_SCOLLBAR_POSTITION, verticalScrollBarPosition);
		memento.putInteger(TAG_HORIZON_SCOLLBAR_POSTION, horizonScollBarPosition);
		for (int i = 0; i < columnFields.length; i++) {
			memento.putInteger(TAG_COLUMN_ORDER + i, columnOrder[i]);
			memento.putInteger(TAG_COLUMN_WIDTH + i, columnWidth[i]);
		}

	}

}
