/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.contexts.IContextIds;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;

/**
 * This class is used to register global undo/redo actions based on the {@link IUndoContext} of an
 * {@link IEditorPart}. This class will handle the case when the IEditorPart is not active (i.e.,
 * such as a dialog)
 * 
 */
public class UndoRedoActionGroup extends ActionGroup {
	protected IContextService contextService;
	protected IContextActivation contextActivation;

	protected IHandlerActivation globalUndoActivation;
	protected IHandlerActivation globalRedoActivation;

	protected UndoActionHandler undoActionHandler;
	protected RedoActionHandler redoActionHandler;

	protected IUndoContext undoContext;
	protected final IWorkbenchPartSite site;

	/**
	 * Create an action group for the given Editor part including the {@link IWorkbenchPartSite} and
	 * requests an {@link IUndoContext} via {@link IAdaptable#getAdapter(Class)}.
	 * 
	 * @param anEditorPart
	 *           The relevant Editor part to register undo actions for
	 */
	public UndoRedoActionGroup(IEditorPart anEditorPart) {
		this(anEditorPart.getSite(), findUndoContext(anEditorPart));

		// Ensure the handlers are activated in this context
		activateHandlers();
	}

	/**
	 * Create an action group for the given {@link IWorkbenchPartSite} and {@link IUndoContext}
	 * 
	 * @param workbenchSite
	 *           The workbench site to use to create the {@link UndoActionHandler} and
	 *           {@link RedoActionHandler} handlers.
	 * @param defaultContext
	 *           The initial undo context.
	 * 
	 */
	public UndoRedoActionGroup(IWorkbenchPartSite workbenchSite, IUndoContext defaultContext) {
		site = workbenchSite;
		undoContext = defaultContext;
		createActions();
	}

	public void setUndoContext(IUndoContext context) {
		undoContext = context;
		undoActionHandler.setContext(undoContext);
		redoActionHandler.setContext(undoContext);
	}

	public IUndoContext getUndoContext() {
		return undoContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		if (undoActionHandler != null && redoActionHandler != null) {
			actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoActionHandler);
			actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoActionHandler);
		}
	}

	protected void activateHandlers() {
		IHandlerService handlerServ = (IHandlerService) site.getService(IHandlerService.class);

		//Activate handlers
		globalUndoActivation = handlerServ.activateHandler(
				"org.eclipse.ui.edit.undo", new ActionHandler(undoActionHandler), null, true); //$NON-NLS-1$

		globalRedoActivation = handlerServ.activateHandler(
				"org.eclipse.ui.edit.redo", new ActionHandler(redoActionHandler), null, true); //$NON-NLS-1$

		contextService = (IContextService) PlatformUI.getWorkbench()
				.getService(IContextService.class);
		if (contextService != null) {
			contextActivation = contextService.activateContext(IContextIds.CONTEXT_ID_WINDOW);
		}
	}

	protected void createActions() {
		// create the undo action handler
		undoActionHandler = new UndoActionHandler(site, undoContext);
		undoActionHandler.setPruneHistory(false);

		// create the redo action handler
		redoActionHandler = new RedoActionHandler(site, undoContext);
		redoActionHandler.setPruneHistory(false);
	}

	protected static IUndoContext findUndoContext(IEditorPart part) {
		return (IUndoContext) part.getAdapter(IUndoContext.class);
	}

	public void dispose() {
		if (contextService != null && contextActivation != null) {
			contextService.deactivateContext(contextActivation);
		}
		contextService = null;
		contextActivation = null;

		if (globalUndoActivation != null) {
			globalUndoActivation.getHandlerService().deactivateHandler(globalUndoActivation);
		}

		if (globalRedoActivation != null) {
			globalRedoActivation.getHandlerService().deactivateHandler(globalRedoActivation);
		}

		globalRedoActivation = null;
		globalUndoActivation = null;
	}
}
