/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;

/**
 * Provide Icons to GMF that have been described via the ResourceType framework.
 */
public class ResourceTypeIconProvider extends AbstractProvider implements IIconProvider {

	private static ImageRegistry imageRegistry;

	public boolean provides(IOperation operation) {

		IIconOperation oper = (IIconOperation) operation;
		IAdaptable adapter = oper.getHint();
		if (adapter == null) {
			return false;
		}

		// IElementType
		IElementType elementType = (IElementType) oper.getHint().getAdapter(IElementType.class);
		if (elementType != null) {
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			if (rts.getResourceTypeUIBindingDescriptor(elementType.getId()) != null) {
				return true;
			}
		}

		return false;
	}

	public Image getIcon(IAdaptable hint, int flags) {

		// IElementType

		IElementType elementType = (IElementType) hint.getAdapter(IElementType.class);
		if (elementType != null) {
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			ResourceTypeUIBindingDescriptor desc = rts.getResourceTypeUIBindingDescriptor(elementType
					.getId());
			if (desc != null) {
				Image im = getIcon(desc.getSmallIconFullyQualified());
				return im;
			}
		}
		return null;
	}

	private static Image getIcon(String path) {
		if (imageRegistry == null) {
			imageRegistry = DeployCoreUIPlugin.getDefault().getImageRegistry();
		}

		Image image = imageRegistry.get(path);
		if (image == null) {
			image = createImage(path);
			imageRegistry.put(path, image);
		}

		return image;
	}

	private static Image createImage(String path) {
		try {
			return createImageDescriptor(path).createImage();
		} catch (Exception ex) {
			return null;
		}
	}

	private static ImageDescriptor createImageDescriptor(String path) {
		return DeployCoreUIPlugin.getImageDescriptor(path);
	}
}
