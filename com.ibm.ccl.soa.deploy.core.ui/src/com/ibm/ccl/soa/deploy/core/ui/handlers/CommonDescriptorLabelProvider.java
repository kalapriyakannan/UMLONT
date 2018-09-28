/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.handlers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.saf.handler.ICommonDescriptor;

/**
 * Provides labels and icons for {@link ICommonDescriptor} which represent information parsed from
 * various extension points.
 * 
 */
public class CommonDescriptorLabelProvider extends LabelProvider implements ILabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof ICommonDescriptor) {
			return ((ICommonDescriptor) element).getName();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ICommonDescriptor) {
			ICommonDescriptor descriptor = (ICommonDescriptor) element;
			if (descriptor.getSmallIcon() != null) {
				ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
				return sharedImages.getImage(descriptor.getSmallIcon());
			}
		}
		return super.getImage(element);
	}
}
