/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.TreeItem;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusNode;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusView;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * clear the selected publishstatus.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ClearPublishStatusAction extends Action {
	private StatusView view;

	/**
	 * constructor method.
	 * 
	 * @param view
	 *           StatusView
	 */
	public ClearPublishStatusAction(StatusView view) {
		this.view = view;
		setText(Messages.Views_Action_ClearStatus_Text);
		setToolTipText(Messages.Views_Action_ClearStatus_Tip);
		setImageDescriptor(DeployCoreImages.IMAGE_CLEAR_STATUS);
		setDisabledImageDescriptor(DeployCoreImages.IMAGE_CLEAR_STATUS_D);
	}

	private boolean removeStatus(IDeployPublishStatus status) {
		final DeployModelObject dmo = status.getDeployObject();
		final IDeployPublishStatus fStatus = status;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain == null) {
			// if the topology hasn't been associated with a domain yet,
			// create one
			editingDomain = GMFEditingDomainFactory.getInstance().createEditingDomain();
		}

		//clear status operation
		final AbstractEMFOperation operation1 = new AbstractEMFOperation(editingDomain,
				StringStatics.BLANK) {
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {

				IStatus parent = dmo.getStatus();
				if (parent == fStatus) {
					dmo.clearStatus();
				} else if (parent.isMultiStatus()) {
					IStatus[] children = parent.getChildren();
					for (int i = 0; i < children.length; i++) {
						if (children[i].equals(fStatus)) {
							children[i] = Status.OK_STATUS;
							break;

						}
					}
				}

				return Status.OK_STATUS;
			}
		};
		try {
			operation1.execute(new NullProgressMonitor(), null);
		} catch (final ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void run() {
		super.run();
		final TreeItem[] selections = view.getViewer().getTree().getSelection();
		for (int i = 0; i < selections.length; i++) {

			if (selections[i].getData() instanceof StatusNode) {
				IDeployPublishStatus status = (IDeployPublishStatus) ((StatusNode) selections[i]
						.getData()).getStatus();
				removeStatus(status);
			}

		}
		view.update();

	}

}
