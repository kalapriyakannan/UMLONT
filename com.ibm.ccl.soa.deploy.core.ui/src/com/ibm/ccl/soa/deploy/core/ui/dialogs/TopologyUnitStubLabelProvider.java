/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;

/**
 * Provides labels for {@link TopologyUnitStub stubs}.
 * 
 */
public class TopologyUnitStubLabelProvider extends LabelProvider implements ITableLabelProvider {

	public Image getImage(Object element) {
		return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ACTN_CORRECTION);
	}

	public String getText(Object element) {
		if (element instanceof TopologyUnitStub) {
			TopologyUnitStub stub = (TopologyUnitStub) element;
			UnitProvider source = stub.getSource();
			UnitProviderDescriptor descriptor = source.getDescriptor();
			String name = descriptor.getName();
			int indx = -1;
			if ((indx = name.lastIndexOf('.')) > -1) {
				name = name.substring(indx + 1);
			}
			return NLS.bind(Messages.SelectChangeQuickDialog_0_can_create_1_, new Object[] { name,
					stub.getName() });

		}
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return getImage(element);
	}

	public String getColumnText(Object element, int columnIndex) {
		return getText(element);
	}
}