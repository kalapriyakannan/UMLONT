/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui.handlers;

import java.util.ArrayList;

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
import org.eclipse.wst.common.core.search.scope.SearchScope;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.ui.Messages;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

public class DDLInterfaceUIHandler extends AbstractUIHandler {

	public AbstractDescriptionProvider getDescriptionProvider() {
		return new AbstractDescriptionProvider() {
			public String getName(Object interfaceObject) {
				return "DDLInterfaceUIHandler_name"; //$NON-NLS-1$
			}

			/*
			 * @see com.ibm.ccl.soa.core.saf.handler.IInterfaceHandler.IInterfaceLabelProvider#getQualifier(java.lang.Object)
			 */
			public String getQualifier(Object interfaceObject) {
				return "DDLInterfaceUIHandler_qualifier"; //$NON-NLS-1$				
			}

			public Image getObjectImage(Object interfaceObject) {
				return null;
			}

			public IFile getFile(Object interfaceObject) {
				if (interfaceObject instanceof DDLInterface) {
					DDLInterface ddlInterface = (DDLInterface) interfaceObject;
					String sSchemaUri = ddlInterface.getSchemaUri();
					if (sSchemaUri != null && sSchemaUri.length() > 0) {
						return WorkbenchResourceHelperBase.getIFile(URI.createURI(sSchemaUri));
					}
				}
				return null;
			}

			public Image getContainerImage(Object interfaceObject) {
				return null;
			}
		};
	}

	public Object[] getInterfaceObjects(SearchScope searchScope, IProgressMonitor pm) {
		ArrayList typeInfos = new ArrayList();
		return typeInfos.toArray();
	}

	public void open(Substitutable interfaze) throws SAFException {
		if (interfaze instanceof DDLInterface) {
			DDLInterface ddlInterface = (DDLInterface) interfaze;
			String sSchemaUri = ddlInterface.getSchemaUri();
			if (sSchemaUri != null && sSchemaUri.length() > 0) {
				IFile file = WorkbenchResourceHelperBase.getIFile(URI.createURI(sSchemaUri));
				try {
					openInEditor(file, true);
				} catch (PartInitException e) {
					throw new SAFException(e);
				}
			} else {
				MessageBox msgBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
				msgBox.setMessage(Messages.SCHEMA_NOT_SET);
				msgBox.open();
			}
		}
	}

	@Override
	public String getWizardId() {
		return "com.ibm.datatools.core.ui.wizards.NewModelWizard"; //$NON-NLS-1$
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
	public boolean isUIHandlerForObject(Substitutable obj) {
		return obj instanceof DDLInterface;
	}

	/*
	 * edits interface attributes and allows user to open the interface file
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractInterfaceUIHandler#editInterface(org.eclipse.swt.widgets.Shell,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject, com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public boolean editSubstitutable(Shell shell, final DeployModelObject nubDmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		if (substitutable instanceof DDLInterface) {
			final DDLInterface ddlInterface = (DDLInterface) substitutable;
			DDLInterfaceDialog dialog = new DDLInterfaceDialog(shell, isEditNubDmo ? nubDmo : null);
			dialog.setSchemaUri(ddlInterface.getSchemaUri());
			if (dialog.open() == Window.OK) {
				final boolean isService = dialog.isService();
				final String displayName = dialog.getDisplayName();
				final String description = dialog.getDescription();
				final String schemaUri = dialog.getSchemaUri();
				AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
						.getEditingDomain(nubDmo), Messages.Edit_DDL_interface, null) {
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
						if (isService) {
							nubDmo.setDisplayName(displayName);
							nubDmo.setDescription(description);
						}
						ddlInterface.setSchemaUri(schemaUri);
						return CommandResult.newOKCommandResult();
					}
				};
				try {
					editCmd.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
				}

				// open schema in editor if user asked
				if (dialog.isOpenSchema()) {
					open(ddlInterface);
				}
				return true;
			}
		}
		return false;
	}

}
