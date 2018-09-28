/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class TreeLabelProvider extends LabelProvider implements ITableLabelProvider {
	private IStatusField[] fields;

	/**
	 * @param fields
	 */
	public TreeLabelProvider(IStatusField[] fields) {
		super();
		this.fields = fields;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex < fields.length) {
			return fields[columnIndex].getImage(element);

		}
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (columnIndex < fields.length) {

			try {
				return fields[columnIndex].getValue(element);
			} catch (NotSupportedTargetException e) {
				return Messages.NULL_MESSAGE;
			}

		}
		return Messages.NULL_MESSAGE;
	}

}
