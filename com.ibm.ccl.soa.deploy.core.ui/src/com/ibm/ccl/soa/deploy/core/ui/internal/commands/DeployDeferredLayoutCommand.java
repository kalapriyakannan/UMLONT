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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;

/**
 * The shell of this command has been adpated from cmahoney
 */
public class DeployDeferredLayoutCommand extends AbstractTransactionalCommand {

	/** the IAdaptables from which an View can be retrieved */
	protected List<CreateViewRequest.ViewDescriptor> viewAdapters = null;

	/** just units */
	protected List<Unit> unitList = null;

	/** the diagram editpart used to get the editpart registry */
	protected IGraphicalEditPart containerEP;
	protected EditPart _refreshEP;

	private final Point _location;

	private final boolean _fillInViews;

	private final boolean _layoutContainer;

	/**
	 * Constructor for <code>DeployDeferredLayoutCommand</code>.
	 * 
	 * @param editingDomain
	 *           the editing domain through which model changes are made
	 * @param viewAdapters
	 *           the IAdaptables from which an IView can be retrieved
	 * @param containerEP
	 *           the container editpart used to get the editpart registry
	 * @param refreshEP
	 *           TODO
	 * @param location
	 *           TODO
	 * @param fillInViews --
	 *           do canonical refresh on new editparts
	 * @param selectResults
	 *           TODO
	 */
	public DeployDeferredLayoutCommand(TransactionalEditingDomain editingDomain,
			List<CreateViewRequest.ViewDescriptor> viewAdapters, IGraphicalEditPart containerEP,
			EditPart refreshEP, Point location, boolean fillInViews, boolean selectResults) {

		super(editingDomain, DiagramUIMessages.Command_Deferred_Layout, null);
		this.viewAdapters = viewAdapters;
		this.containerEP = containerEP;
		_refreshEP = refreshEP;
		_location = location;
		_fillInViews = fillInViews;
		_layoutContainer = selectResults;
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
				containerEP.refresh();
				if (_refreshEP != null) {
					_refreshEP.refresh();
				}

				// The layout command requires that the figure world is updated.
				getContainerFigure().invalidate();
				getContainerFigure().validate();

				// do we get editpart list using view adapters or unitlist?
				List editParts = null;
				if (viewAdapters != null) {
					editParts = new ArrayList(viewAdapters.size());
					Map epRegistry = containerEP.getRoot().getViewer().getEditPartRegistry();
					for (Iterator<CreateViewRequest.ViewDescriptor> it = viewAdapters.iterator(); it
							.hasNext();) {
						IAdaptable ad = it.next();
						View view = (View) ad.getAdapter(View.class);
						Object ep = epRegistry.get(view);
						if (ep != null) {
							editParts.add(ep);
						}
					}
					// else use getEditPartsFor() to get the editparts for the units
				} else if (unitList != null) {
					editParts = new ArrayList();
					for (Iterator<Unit> it = unitList.iterator(); it.hasNext();) {
						List<DeployShapeNodeEditPart> list = GMFUtils.getEditPartsFor(containerEP, it
								.next());
						for (Iterator<DeployShapeNodeEditPart> it2 = list.iterator(); it2.hasNext();) {
							DeployShapeNodeEditPart ep = it2.next();
							// we can only arrange the ep's on the canvas
							if (ep.getParent() instanceof DeployDiagramEditPart) {
								editParts.add(ep);
							}
						}
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
		 * now layout each created editpart
		 */
		LayoutUtils.layoutNewShapes(editParts, _location);
		/*
		 * fill in the views of each editpart
		 */
		if (_fillInViews) {
			for (Iterator<GraphicalEditPart> it = editParts.iterator(); it.hasNext();) {
				CanonicalUtils.refresh(it.next(), true);
			}
		}

		/*
		 * and select the editpart(s)
		 */
		if (_layoutContainer) {
			// if we just laid out the contents of a shapes container, select the container and shrink wrap it
			EditPart container = containerEP.getParent();
			if (container instanceof IGraphicalEditPart) {
				containerEP.getViewer().select(containerEP.getParent());
				new ShrinkWrapViewCommand(containerEP.getEditingDomain(),
						(IGraphicalEditPart) container).execute(new NullProgressMonitor(), null);
			}

		} else {
			SelectionUtils.selectName(editParts);
		}

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
