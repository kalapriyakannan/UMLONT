/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnsetInterface;

/**
 * @deprecated
 */
public class CapabilityLabelProvider extends AdapterFactoryLabelProvider {
	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		return super.getImage(object);
	}

	public CapabilityLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Image getImage(Object element) {
		if (element instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) element;
			return PropertyUtils.getStatusTableImage(dmo.getStatus());
		}

		return super.getImage(element);
	}

	public String getText(Object element) {
		if (element instanceof Capability) {
			Capability cap = (Capability) element;
			return cap.getCaptionProvider().title(cap);

		}
		if (element instanceof UnsetInterface) {
			return Messages.RequirementsPropertiesLabelProvider_Set_Interface_;
		}

		return super.getText(element);
	}
}
