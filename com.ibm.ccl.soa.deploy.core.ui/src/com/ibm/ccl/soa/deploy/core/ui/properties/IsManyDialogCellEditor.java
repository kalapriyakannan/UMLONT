/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.List;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A cell editor for isMany() properties.
 * 
 * @author Ed Snible
 * @see ListEditorDialog
 * @deprecated
 */
public class IsManyDialogCellEditor extends DialogCellEditor {

	/**
	 * @param composite
	 */
	public IsManyDialogCellEditor(Composite composite) {
		super(composite);
	}

	protected Object openDialogBox(Control cellEditorWindow) {
		ListEditorDialog led = new ListEditorDialog(cellEditorWindow.getShell());
		Object value = getValue();

		if (value != null) {
			led.setList((List) value);
		}

		if (led.open() == Window.OK) {
			List retVal = led.getList();
			return retVal;
		}

		// Set it to the old value.
		// TODO Would it be more efficient to return something else, like null?
		// I don't want to leave an UNDO if cancel was pressed....
		return value;
	}
} // end class IsManyDialogCellEditor
