/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatusGrouper;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.IDeployStatusGroupType;

public class SectionStatusContentProvider implements ITreeContentProvider, IDeployStatusGroupType {
	private DeployStatusGrouper grouper;
	private final String statusType;
	private boolean showContainer;

	public SectionStatusContentProvider(String statusType) {
		this.statusType = statusType;
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof DeployStatusGrouper) {
			grouper = (DeployStatusGrouper) parentElement;
			if (showContainer) {
				return grouper.getDeployModelObjects(statusType);
			} else {
				return grouper.getStatus(statusType);
			}

		}
		if (parentElement instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) parentElement;
			return grouper.getStatuses(dmo, statusType);
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		return element instanceof DeployModelObject;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public boolean isShowContainer() {
		return showContainer;
	}

	public void setShowContainer(boolean showContainer) {
		this.showContainer = showContainer;
	}

}
