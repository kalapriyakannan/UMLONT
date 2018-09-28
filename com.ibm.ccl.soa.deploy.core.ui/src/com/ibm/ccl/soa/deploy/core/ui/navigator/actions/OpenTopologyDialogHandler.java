/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.DeployActionIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.OpenTopologyDialog;

/**
 * Implements the open topology action. Opens a dialog prompting for a file and opens the selected
 * file in an editor. This class is almost a copy of the OpenResourceHandler class (with the
 * exception of queryFileResource).
 * 
 * TODO Get Icon for action Get keybinding for action
 * 
 * @author NKruk
 * 
 */
public class OpenTopologyDialogHandler extends Action implements IHandler,
		IWorkbenchWindowActionDelegate {

	/**
	 * The identifier of the parameter storing the file path.
	 */
	private static final String PARAM_ID_FILE_PATH = "filePath"; //$NON-NLS-1$

	/**
	 * A collection of objects listening to changes to this manager. This collection is
	 * <code>null</code> if there are no listeners.
	 */
	private transient ListenerList listenerList = null;

	/**
	 * Constructor.
	 */
	public OpenTopologyDialogHandler() {
		super();
		setText(Messages.OpenTopologyDialog_Open_Topolog_);
		setId(DeployActionIds.ACTION_OPEN_TOPOLOGY_DIALOG);
		setActionDefinitionId(DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
				+ DeployActionIds.ACTION_OPEN_TOPOLOGY_DIALOG);
		setToolTipText(Messages.OpenTopologyDialog_Open_Topolog_);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#addHandlerListener(org.eclipse.core.commands.IHandlerListener)
	 */
	public void addHandlerListener(final IHandlerListener listener) {
		if (listenerList == null) {
			listenerList = new ListenerList(ListenerList.IDENTITY);
		}
		listenerList.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#removeHandlerListener(org.eclipse.core.commands.IHandlerListener)
	 */
	public void removeHandlerListener(final IHandlerListener listener) {
		if (listenerList != null) {
			listenerList.remove(listener);

			if (listenerList.isEmpty()) {
				listenerList = null;
			}
		}
	}

	/**
	 * Opens the dialog for the user to select a topology and returns the IFile.
	 * 
	 * @return the file the user selected or null if no file was selected
	 */
	private IFile queryFileResource() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Shell shell = window.getShell();

		OpenTopologyDialog dialog = new OpenTopologyDialog(shell);
		if (dialog.open() == Window.OK) {
			return (IFile) dialog.getResult()[0];
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
		listenerList = null;
	}

	@Override
	public void run() {
		try {
			execute(new ExecutionEvent());
		} catch (final ExecutionException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(final IAction action) {
		try {
			execute(new ExecutionEvent());
		} catch (final ExecutionException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile file;
		if (event.getParameter(PARAM_ID_FILE_PATH) == null) {
			// Prompt the user for the topology to open.
			file = queryFileResource();
		} else {
			// Use the given parameter.
			final IResource resource = (IResource) event
					.getObjectParameterForExecution(PARAM_ID_FILE_PATH);
			if (!(resource instanceof IFile)) {
				throw new ExecutionException("filePath parameter must identify a file"); //$NON-NLS-1$
			}
			file = (IFile) resource;
		}

		//If we still don't have a file for some reason, then just give up.
		if (file == null) {
			return null;
		}

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			throw new ExecutionException("no active workbench window"); //$NON-NLS-1$
		}

		final IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			throw new ExecutionException("no active workbench page"); //$NON-NLS-1$
		}
		try {
			IDE.openEditor(page, file, true);
		} catch (final PartInitException e) {
			throw new ExecutionException("error opening file in editor", e); //$NON-NLS-1$
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(final IAction action, final ISelection selection) {
		// Do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void init(IWorkbenchWindow win) {
		// Do nothing
	}

}
