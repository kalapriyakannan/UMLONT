package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class StatusViewFilter extends ViewerFilter {

	private boolean filterWarning = true;
	private boolean filterError = true;
	private boolean filterInfo = true;
	private boolean showParent;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IStatus) {
			IStatus status = (IStatus) element;
			switch (status.getSeverity())
			{
			case IStatus.ERROR: {
				return isFilterError();
			}
			case IStatus.WARNING: {
				return isFilterWarning();
			}
			case IStatus.INFO: {
				return isFilterInfo();
			}
			default:
				break;
			}
		}
		return true;
	}

	public boolean isFilterWarning() {
		return filterWarning;
	}

	public void setFilterWarning(boolean filterWarning) {
		this.filterWarning = filterWarning;
	}

	public boolean isFilterError() {
		return filterError;
	}

	public void setFilterError(boolean filterError) {
		this.filterError = filterError;
	}

	public boolean isFilterInfo() {
		return filterInfo;
	}

	public void setFilterInfo(boolean filterInfo) {
		this.filterInfo = filterInfo;
	}

	public boolean isShowParent() {
		return showParent;
	}

	public void setShowParent(boolean showParent) {
		this.showParent = showParent;
	}

}
