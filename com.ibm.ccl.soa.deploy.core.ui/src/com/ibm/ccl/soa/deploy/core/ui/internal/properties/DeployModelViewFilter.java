package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

public class DeployModelViewFilter extends ViewerFilter {

	private boolean showParent;

	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof DeployModelObject) {
			return isShowParent();
		}
		return true;
	}

	public boolean isShowParent() {
		return showParent;
	}

	public void setShowParent(boolean showParent) {
		this.showParent = showParent;
	}
}