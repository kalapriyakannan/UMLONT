/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @since 1.0
 * 
 */
public class DeployLabelProvider extends LabelProvider implements ICommonLabelProvider {

	private final LabelProvider workbenchContentProvider;

	//private AdapterFactoryLabelProvider delegateLabelProvider;

	/**
	 * 
	 */
	public DeployLabelProvider() {
		super();
		workbenchContentProvider = new WorkbenchLabelProvider();
	}

	public String getText(Object element) {
		if (element instanceof IProject) {
			return workbenchContentProvider.getText(element);
		} else if (element instanceof IJavaProject) {
			return workbenchContentProvider.getText(((IJavaProject) element).getProject());
		}
		return null;
	}

	public Image getImage(Object element) {
		if (element instanceof IProject) {
			return workbenchContentProvider.getImage(element);
		} else if (element instanceof IJavaProject) {
			return workbenchContentProvider.getImage(((IJavaProject) element).getProject());
		}
		return null;
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public String getDescription(Object anElement) {
		return getText(anElement);
	}

	public void init(ICommonContentExtensionSite aConfig) {
	}

}
