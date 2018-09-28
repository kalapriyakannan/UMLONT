/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateMemberOrHostingLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployDeferredLayoutCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;

/**
 * @since 1.0
 * 
 */
public class VisualizeFromSemanticCommand extends AbstractTransactionalCommand {
	private final IGraphicalEditPart _targetEP;
	private final List<DeployModelObject> _dmoList = new ArrayList<DeployModelObject>();
	private final List<View> _createdViewList;
	private Point _location;
	private final View _movedView;
	private final Point _originalPt;

	/**
	 * @param editingDomain
	 * @param targetEP
	 * @param dmoList
	 * @param createdViewList
	 * @param location
	 */
	public VisualizeFromSemanticCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<DeployModelObject> dmoList, List<View> createdViewList,
			Point location) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		_dmoList.addAll(dmoList);
		_createdViewList = createdViewList;
		_location = location;
		_movedView = null;
		_originalPt = null;

		setResult(CommandResult.newOKCommandResult(null));
	}

	/**
	 * @param editingDomain
	 * @param targetEP
	 * @param dmoList
	 * @param createdViewList
	 * @param location
	 * @param movedView
	 * @param originalPt
	 */
	public VisualizeFromSemanticCommand(TransactionalEditingDomain editingDomain,
			IGraphicalEditPart targetEP, List<DeployModelObject> dmoList, List<View> createdViewList,
			Point location, View movedView, Point originalPt) {

		super(editingDomain, Messages.VisualizeCommand_Visualiz_, null);
		_targetEP = targetEP;
		_dmoList.addAll(dmoList);
		_createdViewList = createdViewList;
		_location = location;
		_movedView = movedView;
		_originalPt = originalPt;

		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		if (_dmoList.size() == 0) {
			return CommandResult.newOKCommandResult();
		}

		// create a view descriptor for each object
		List<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		for (Iterator<DeployModelObject> it = _dmoList.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			// restrict the view creation to Units and Imports for now 
			if (dmo instanceof Unit || dmo instanceof Import) {
				viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(dmo),
						_targetEP.getDiagramPreferencesHint()));
			}
		}

		// create the views
		Command command = createViewCommand(viewDescriptors);
		if (!command.canExecute()) {
			return CommandResult
					.newErrorCommandResult("VisualizeFromSemanticCommand-failure to visulize"); //$NON-NLS-1$
		}
		command.execute();

		// save created views in a return list
		Collection<Unit> rootUnits = GMFUtils.getRootElements(_dmoList);
		List<View> rootViewList = new ArrayList<View>();
		for (Iterator<CreateViewRequest.ViewDescriptor> it = viewDescriptors.iterator(); it.hasNext();) {
			View view = (View) it.next().getAdapter(View.class);
			if (view != null) {
				if (_createdViewList != null) {
					_createdViewList.add(view);
				}
				// if this is a root element added to the diagram, make it a dup view so it isn't deleted
				// by canonical edit policy because it also exists in a container
				EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.resolveSemanticElement(view);
				boolean isRootView = rootUnits.contains(eo);
				if (isRootView) {
					rootViewList.add(view);
				}

				if (view.eContainer() instanceof Diagram) {
					if (isRootView) {
						DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
								.getDeployStyle());
						style.setIsDuplicateCanvasView(true);
					}
				} else {
					// this view might not be in the diagram, but if another copy is in the diagram we need to make sure
					// that one is marked as a duplicate view to prevent it from being deleted by canonical
					for (DeployShapeNodeEditPart ep : GMFUtils.getEditPartsFor(_targetEP, eo)) {
						if (ep.getParent() instanceof DeployDiagramEditPart) {
							View otherView = ep.getNotationView();
							if (otherView != null) {
								DeployStyle style = (DeployStyle) otherView
										.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
								style.setIsDuplicateCanvasView(true);
							}
							break;
						}
					}
				}
			}
		}

		// if not onto diagram, create links from a container to dmoList roots
		if (_targetEP != null && !(_targetEP instanceof DeployDiagramEditPart)) {
			_location = CreateMemberOrHostingLinkCommand.getLocation(_targetEP, _location);
			CreateMemberOrHostingLinkCommand.createLinks(getEditingDomain(), _targetEP, rootViewList);
		}

		// fill in other diagram views related to these views
		// don't fill in views for import-- performance issue
		List<DeployModelObject> nonImportDmoList = new ArrayList<DeployModelObject>();
		for (Iterator<DeployModelObject> it = _dmoList.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (!(dmo instanceof Import)) {
				nonImportDmoList.add(dmo);
			}
		}
		CanonicalUtils.refreshViews(GMFUtils.getDeployDiagramEditPart(_targetEP), nonImportDmoList,
				true);

		// layout/arrange new views using standard layout routine
		DeployDeferredLayoutCommand layoutCommand = new DeployDeferredLayoutCommand(_targetEP
				.getEditingDomain(), viewDescriptors, _targetEP, null, _location, false, false);
		if (layoutCommand.canExecute()) {
			try {
				layoutCommand.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				DeployCoreUIPlugin
						.logError(0, "VisualizeFromSemanticCommand -- Could not layout", null); //$NON-NLS-1$
			}
		}

		if (_movedView != null) {
			// position original view where it was before we started (undo SetBoundsCommand)
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_movedView,
					NotationPackage.eINSTANCE.getLocation_X(), new Integer(_originalPt.x));
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(_movedView,
					NotationPackage.eINSTANCE.getLocation_Y(), new Integer(_originalPt.y));
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * createViewsAndArrangeCommand Method to create all the view based on the viewDescriptors list
	 * 
	 * @param viewDescriptors
	 * @return command
	 */
	private Command createViewCommand(List<CreateViewRequest.ViewDescriptor> viewDescriptors) {
		final View containerView = _targetEP.getNotationView();
		final EditPart parentEP = _targetEP.getParent();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(),
				DiagramUIMessages.AddCommand_Label);
		Iterator<CreateViewRequest.ViewDescriptor> it = viewDescriptors.iterator();
		while (it.hasNext()) {
			final CreateViewRequest.ViewDescriptor descriptor = it.next();

			// create view
			cc.compose(new AbstractTransactionalCommand(getEditingDomain(), "", null) {//$NON-NLS-1$
						protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
								IAdaptable info) {

							// if adding to a container make sure this unit isn't filtered
							if (!(_targetEP instanceof DiagramEditPart)
									&& parentEP instanceof IGraphicalEditPart) {
								DeployStyle style = (DeployStyle) ((IGraphicalEditPart) parentEP)
										.getNotationView().getStyle(
												DeployNotationPackage.eINSTANCE.getDeployStyle());
								if (style != null) {
									EObject eo = (EObject) descriptor.getElementAdapter().getAdapter(
											EObject.class);
									style.getFilteredSemanticElements().remove(eo);
								}
							}

							View newView = ViewUtil.createView(descriptor.getViewKind(), descriptor
									.getElementAdapter(), containerView, descriptor.getSemanticHint(),
									descriptor.getIndex(), descriptor.isPersisted(), descriptor
											.getPreferencesHint());
							descriptor.setView(newView);
							return CommandResult.newOKCommandResult();
						}
					});

		}
		return new ICommandProxy(cc);
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doRedo(monitor, info);
		CanonicalUtils.refreshLinks(GMFUtils.getDeployDiagramEditPart(_targetEP));
		return status;
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doUndo(monitor, info);
		CanonicalUtils.refreshLinks(GMFUtils.getDeployDiagramEditPart(_targetEP));
		return status;
	}

	public boolean canExecute() {
		return true;
	}
}
