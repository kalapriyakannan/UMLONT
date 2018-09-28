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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * &lt;interfaceUIHandler&gt; on the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code>
 * extension point to provide a UI for editing {@link WSDLInterface}s.
 * 
 * @see IUIHandlerService
 */
public class WSDLInterfaceUIHandler extends AbstractUIHandler {

	public AbstractDescriptionProvider getDescriptionProvider() {
		return new AbstractDescriptionProvider() {
			public String getName(Object interfaceObject) {
				return "WSDLInterfaceUIHandler_name"; //$NON-NLS-1$
			}

			/*
			 * @see com.ibm.ccl.soa.core.saf.handler.IInterfaceHandler.IInterfaceLabelProvider#getQualifier(java.lang.Object)
			 */
			public String getQualifier(Object interfaceObject) {
				return "WSDLInterfaceUIHandler_qualifier"; //$NON-NLS-1$				
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
		if (interfaze instanceof WSDLInterface) {
			WSDLInterface wsdlInterface = (WSDLInterface) interfaze;
			String typeUri = wsdlInterface.getTypeUri();
			if (typeUri != null && typeUri.length() > 0) {
				// strip off stuff after #
				int len = typeUri.indexOf('#');
				if (len < 0) {
					len = typeUri.length();
				}
				String wsdlName = typeUri.substring(0, len);
				IFile file = WorkbenchResourceHelperBase.getIFile(URI.createURI(wsdlName));
				try {
					openInEditor(file, true);
				} catch (PartInitException e) {
					throw new SAFException(e);
				}
			} else {
				MessageBox msgBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
				msgBox.setMessage(Messages.WSDL_TYPE_NOT_SET);
				msgBox.open();
			}
		}
	}

	private IEditorPart openInEditor(IFile file, boolean activate) throws PartInitException {
		if (file != null) {
			IWorkbenchPage p = ResourceUtils.getActiveWorkbenchPage();
			if (p != null) {
				IEditorPart editorPart = IDE.openEditor(p, file, activate);
				return editorPart;
			}
		}
		return null;
	}

	@Override
	public String getWizardId() {
		return "org.eclipse.wst.wsdl.ui"; //$NON-NLS-1$
	}

	public boolean isUIHandlerForObject(Substitutable interfaze) {
		return interfaze instanceof WSDLInterface;
	}

	public boolean editSubstitutable(Shell shell, final DeployModelObject nubDmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		if (substitutable instanceof WSDLInterface) {
			final WSDLInterface wsdlInterface = (WSDLInterface) substitutable;
			WSDLInterfaceDialog dialog = new WSDLInterfaceDialog(shell, wsdlInterface.getTypeUri(),
					isEditNubDmo ? nubDmo : null);
			if (dialog.open() == Window.OK) {
				final boolean isService = dialog.isService();
				final String displayName = dialog.getDisplayName();
				final String description = dialog.getDescription();
				final String newTypeUri = dialog.getTypeUri();
				AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
						.getEditingDomain(nubDmo), Messages.Edit_WSDL_interface, null) {
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
						if (isService) {
							nubDmo.setDisplayName(displayName);
							nubDmo.setDescription(description);
						}
						wsdlInterface.setTypeUri(newTypeUri);
						return CommandResult.newOKCommandResult();
					}
				};
				try {
					editCmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
				}
				// open schema in editor if user asked
				if (dialog.isOpenWSDL()) {
					open(wsdlInterface);
				}
				return true;
			}
		}
		return false;
	}

}
