/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

public class URLInterfaceUIHandler extends AbstractUIHandler {

	public AbstractDescriptionProvider getDescriptionProvider() {
		return new AbstractDescriptionProvider() {
			public String getName(Object interfaceObject) {
				return "URLInterfaceUIHandler_name"; //$NON-NLS-1$
			}

			/*
			 * @see com.ibm.ccl.soa.core.saf.handler.IInterfaceHandler.IInterfaceLabelProvider#getQualifier(java.lang.Object)
			 */
			public String getQualifier(Object interfaceObject) {
				return "URLInterfaceUIHandler_qualifier"; //$NON-NLS-1$				
			}

			public Image getObjectImage(Object interfaceObject) {
				return null;
			}

			public IFile getFile(Object interfaceObject) {
				return null;
			}

			public Image getContainerImage(Object interfaceObject) {
				return null;
			}
		};
	}

	public void open(Substitutable interfaze) throws SAFException {

		boolean openWarning = false;

		if (openWarning) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			Shell activeShell = workbench.getDisplay().getActiveShell();

			MessageDialog.openWarning(activeShell, Messages.FEATURE_NOT_IMPLEMENTED,
					Messages.FEATURE_NOT_IMPLEMENTED);
		}
	}

	@Override
	public boolean canOpen(Substitutable substitutableObj) {
		return false;
	}

	public Object createNewSubstitutableObject(IContainer defaultLocation, Shell shell)
			throws SAFException, InvalidOperationException {
		return null;
	}

	public boolean isUIHandlerForObject(Substitutable interfaze) {
		return interfaze instanceof URLInterface;
	}

	public boolean editSubstitutable(Shell shell, final DeployModelObject nubDmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		if (substitutable instanceof URLInterface) {
			URLInterface urlInterface = (URLInterface) substitutable;
			URLInterfaceDialog dialog = new URLInterfaceDialog(shell, isEditNubDmo ? nubDmo : null);
			final List oldParamList = urlInterface.getParamName();
			dialog.setParamList(oldParamList);
			if (dialog.open() == Window.OK) {
				final boolean isService = dialog.isService();
				final String displayName = dialog.getDisplayName();
				final String description = dialog.getDescription();
				final List newParamList = dialog.getParamList();
				AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
						.getEditingDomain(nubDmo), Messages.Edit_URL_interface, null) {
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
						if (isService) {
							nubDmo.setDisplayName(displayName);
							nubDmo.setDescription(description);
						}
						oldParamList.clear();
						oldParamList.addAll(newParamList);
						return CommandResult.newOKCommandResult();
					}
				};
				try {
					editCmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
				}
				// open interface in editor if user asked
				if (dialog.isOpenServlet()) {
					open(urlInterface);
				}
				return true;
			}
		}
		return false;
	}

}
