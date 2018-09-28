/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.synchronization;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.swt.graphics.Font;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

public class SynchronizeDialogLabelProvider extends AdapterFactoryLabelProvider implements
		IFontProvider {

	public SynchronizeDialogLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);

	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (columnIndex == 0) {
			return getText(element);
		}
		return super.getColumnText(element, columnIndex);
	}

	@Override
	public String getText(Object element) {
		String text = Messages.SynchronizeDialogLabelProvider_no_label_;
		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			if (!unit.isConfigurationUnit()) {
				text = unit.getCaptionProvider().titleWithContext(unit);
			} else {
				text = unit.getCaptionProvider().title(unit);
			}
		} else {
			text = super.getText(element);
		}

		if (text == null || text.trim().length() == 0) {
			return Messages.SynchronizeDialogLabelProvider_no_label_;
		}
		return text;
	}

	public Font getFont(Object element) {

		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			if (unit.isConfigurationUnit()) {
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DIALOG_FONT);
			}
		}
		return JFaceResources.getFontRegistry().get(JFaceResources.DIALOG_FONT);
	}

}
