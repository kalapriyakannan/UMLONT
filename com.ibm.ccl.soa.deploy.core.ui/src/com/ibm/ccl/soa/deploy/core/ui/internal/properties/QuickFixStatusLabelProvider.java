/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigureFactory;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class QuickFixStatusLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		if (element instanceof DeployStatus) {
			return ErrorMarkerFigureFactory.getFigureImage((IStatus) element, true);
		}
		if (element instanceof EObject) {
			return IconService.getInstance().getIcon(new EObjectAdapter((EObject) element),
					IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		}
		return null;
	}

	public String getText(Object element) {
		if (element instanceof Unit) {
			return ((Unit) element).getCaptionProvider().title((Unit) element);
		}
		if (element instanceof DeployStatus) {
			DeployStatus deployStatus = (DeployStatus) element;
			return deployStatus.getMessage();
		}
		//TODO Need to improve text for DeployLinks
		if (element instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) element;
			return DeployModelObjectUtil.getTitle(dmo);
		}
		return element.getClass().getName();

	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
