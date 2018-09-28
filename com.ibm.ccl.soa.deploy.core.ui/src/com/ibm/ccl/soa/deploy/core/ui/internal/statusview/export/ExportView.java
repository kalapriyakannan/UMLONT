/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.export;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusViewConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusView;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusViewConfig;

/**
 * Export View to show export result
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ExportView extends StatusView {

	private final StatusViewConfig config;
	private final ExportConfigProvider provider;

	/**
	 * 
	 * 
	 */
	public ExportView() {
		provider = new ExportConfigProvider();
		config = new StatusViewConfig(provider);
		config.setName("Export"); //$NON-NLS-1$
		seperate = true;
	}

	protected IStatusViewConfig getSetting() {

		return config;
	}

	/**
	 * show export status
	 * 
	 * @param exportErrors
	 */
	public void show(List exportErrors) {
		Status[] statuses = (Status[]) exportErrors.toArray(new Status[exportErrors.size()]);
		this.getViewer().setInput(statuses);
		this.refresh();
	}

	/**
	 * show export status
	 * 
	 * @param exportErrores
	 */
	public void show(IStatus[] exportErrores) {
		this.getViewer().setInput(exportErrores);
		this.refresh();
	}

	public void createPartControl(org.eclipse.swt.widgets.Composite parent) {
		super.createPartControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EXPORT_PROBLEMS_VIEW);

	}

}
