/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

//import com.ibm.ccl.soa.deploy.core.ui.util.ArrangeUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * The shell of this command has been adpated from cmahoney
 */
public class DeployDeferredArrangeCommand extends AbstractTransactionalCommand {

	/** the IAdaptables from which an View can be retrieved */
	protected List viewAdapters;

	/** the diagram editpart used to get the editpart registry */
	protected IGraphicalEditPart containerEP;

	/**
	 * Constructor for <code>DeployDeferredLayoutCommand</code>.
	 * 
	 * @param editingDomain
	 *           the editing domain through which model changes are made
	 * @param viewAdapters
	 *           the IAdaptables from which an IView can be retrieved
	 * @param containerEP
	 *           the container editpart used to get the editpart registry
	 * @param isSelectionArrange
	 */
	public DeployDeferredArrangeCommand(TransactionalEditingDomain editingDomain, List viewAdapters,
			IGraphicalEditPart containerEP) {

		super(editingDomain, DiagramUIMessages.Command_Deferred_Layout, null);
		this.viewAdapters = viewAdapters;
		this.containerEP = containerEP;
	}

	public List getAffectedFiles() {
		if (containerEP != null) {
			View view = (View) containerEP.getModel();
			if (view != null) {
				IFile f = WorkspaceSynchronizer.getFile(view.eResource());
				return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * Executes a layout command with all the editparts for the view adapters.
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {

		/*
		 * define a thread that will execute after the view descriptors have views in them that then
		 * make sure there are editparts for every view and returns those editparts
		 */
		RunnableWithResult refreshRunnable = new RunnableWithResult() {

			private IStatus status;
			private Object result;

			public Object getResult() {
				return result;
			}

			public void setStatus(IStatus status) {
				this.status = status;
			}

			public IStatus getStatus() {
				return status;
			}

			public void run() {
				GEFUtils.refreshTree(containerEP);

				// The layout command requires that the figure world is updated.
				getContainerFigure().invalidate();
				getContainerFigure().validate();

				List editParts = new ArrayList(viewAdapters.size());
				Map epRegistry = containerEP.getRoot().getViewer().getEditPartRegistry();
				for (Iterator iter = viewAdapters.iterator(); iter.hasNext();) {
					IAdaptable ad = (IAdaptable) iter.next();
					View view = (View) ad.getAdapter(View.class);
					Object ep = epRegistry.get(view);
					if (ep != null) {
						editParts.add(ep);
					}
				}

				if (editParts.isEmpty()) {
					result = editParts;
					return;
				}

				Set layoutSet = new HashSet(editParts.size());
				layoutSet.addAll(editParts);

				// refresh source and target connections of any shapes in the container not being considered for layout
				Iterator iter = containerEP.getChildren().iterator();
				while (iter.hasNext()) {
					Object obj = iter.next();
					if (!layoutSet.contains(obj) && obj instanceof IGraphicalEditPart) {
						IGraphicalEditPart ep = (IGraphicalEditPart) obj;
						ep.refresh();
					}
				}

				result = editParts;
			}
		};

		/*
		 * run the thread after the view descriptors have been filled with views
		 */
		EditPartUtil.synchronizeRunnableToMainThread(containerEP, refreshRunnable);
		List<GraphicalEditPart> editParts = (List<GraphicalEditPart>) refreshRunnable.getResult();
		if (editParts == null || editParts.isEmpty()) {
			return CommandResult.newOKCommandResult();
		}

		/*
		 * now arrange the editparts
		 */
		//	ArrangeUtils.arrangeEditParts(editParts,true);
		return CommandResult.newOKCommandResult();
	}

	protected void cleanup() {
		containerEP = null;//for garbage collection
		viewAdapters = null;
		super.cleanup();
	}

	/**
	 * gets the container edit part's figure
	 * 
	 * @return the container figure
	 */
	protected IFigure getContainerFigure() {
		return containerEP.getFigure();
	}
}
