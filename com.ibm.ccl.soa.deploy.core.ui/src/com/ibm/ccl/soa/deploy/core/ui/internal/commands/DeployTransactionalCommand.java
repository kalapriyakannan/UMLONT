/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;

/**
 * @since 7.0
 * 
 */
public abstract class DeployTransactionalCommand extends AbstractTransactionalCommand {

	/**
	 * @param dmo
	 * @param label
	 */
	public DeployTransactionalCommand(com.ibm.ccl.soa.deploy.core.DeployModelObject dmo, String label) {
		super(TransactionUtil.getEditingDomain(dmo), label, getAllWorkspaceFiles(dmo));
	}

	/**
	 * @param anEditPart
	 * @param label
	 * @param immediateFileOnly
	 */
	public DeployTransactionalCommand(IGraphicalEditPart anEditPart, String label,
			boolean immediateFileOnly) {
		super(anEditPart.getEditingDomain(), label, immediateFileOnly ? getWorkspaceFiles(anEditPart)
				: getAllWorkspaceFiles(anEditPart));
	}

	/**
	 * @param anEditPart
	 * @param label
	 * @param someOptions
	 * @param immediateFileOnly
	 */
	@SuppressWarnings("unchecked")
	public DeployTransactionalCommand(IGraphicalEditPart anEditPart, String label, Map someOptions,
			boolean immediateFileOnly) {
		super(anEditPart.getEditingDomain(), label, someOptions,
				immediateFileOnly ? getWorkspaceFiles(anEditPart) : getAllWorkspaceFiles(anEditPart));
	}

	/**
	 * @param aView
	 * @param label
	 * @param someOptions
	 * @param immediateFileOnly
	 */
	@SuppressWarnings("unchecked")
	public DeployTransactionalCommand(View aView, String label, Map someOptions,
			boolean immediateFileOnly) {
		super(TransactionUtil.getEditingDomain(aView), label, someOptions,
				immediateFileOnly ? getWorkspaceFiles(aView) : getAllWorkspaceFiles(aView));
	}

	/**
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public DeployTransactionalCommand(TransactionalEditingDomain domain, String label,
			List affectedFiles) {
		super(domain, label, affectedFiles);
	}

	/**
	 * @param domain
	 * @param label
	 * @param options
	 * @param affectedFiles
	 */
	public DeployTransactionalCommand(TransactionalEditingDomain domain, String label, Map options,
			List affectedFiles) {
		super(domain, label, options, affectedFiles);
	}

	@SuppressWarnings("unchecked")
	protected static List<Resource> getAllWorkspaceFiles(View aView) {
		if (aView != null) {
			List<EObject> objs = new ArrayList<EObject>(2);
			objs.add(aView);
			EObject obj = aView.getElement();
			if (obj != null) {
				objs.add(aView.getElement());
			}
			return getWorkspaceFiles(objs);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected static List<Resource> getWorkspaceFiles(View aView) {
		if (aView != null) {
			return getWorkspaceFiles(Collections.singletonList(aView));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected static List<Resource> getAllWorkspaceFiles(IGraphicalEditPart ep) {
		if (ep != null) {
			if (ep instanceof DeployDiagramEditPart) {
				return getAllWorkspaceFiles(((DeployDiagramEditPart) ep).getDiagramView());
			}
			return getAllWorkspaceFiles(ep.getPrimaryView());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected static List<Resource> getWorkspaceFiles(IGraphicalEditPart ep) {
		if (ep != null) {
			if (ep instanceof DeployDiagramEditPart) {
				return getWorkspaceFiles(((DeployDiagramEditPart) ep).getDiagramView());
			}
			return getWorkspaceFiles(ep.getPrimaryView());
		}
		return null;
	}

	/**
	 * @param dmo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Resource> getAllWorkspaceFiles(EObject dmo) {
		if (dmo != null) {
			List files = getWorkspaceFiles(dmo);
			//Check for active diagram as well.
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (window != null) {
				IEditorPart editor = window.getActivePage().getActiveEditor();
				if (editor != null) {
					if (editor.getEditorInput() instanceof FileEditorInput) {
						files.add(((FileEditorInput) editor.getEditorInput()).getFile());
					}
				}
			}
			return files;
		}
		return null;
	}
}
