/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.OpenToplogyAction;

/**
 * Link unit in editor when user navigate status in Publish Problem View
 * 
 * @author <a mailto:fenglin@cn.ibm.com>Ella Feng</a>
 * 
 */
public class SetSelectionOnEditorAction extends OpenToplogyAction {

	public SetSelectionOnEditorAction(IWorkbenchPage page) {

		super(page);
		this.setEnabled(true);

	}

	public boolean updateSelection(IStructuredSelection s) {

		return super.updateSelection(transformSelection(s));
	}

	private IStructuredSelection transformSelection(IStructuredSelection s) {
		final FieldUnit unitField = new FieldUnit();
		Object obj = s.getFirstElement();
		try {
			DeployModelObject dmo = (DeployModelObject) unitField.getDMO(obj);
			return new StructuredSelection(dmo);
		} catch (NotSupportedTargetException e) {

		}

		return s;
	}

}
