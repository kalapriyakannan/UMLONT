/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 */
public class ShowOrNotShowUnitOnHostCommand extends AbstractTransactionalCommand {
	private final DeployShapeNodeEditPart _selectedEP;
	private final DeployDiagramEditPart _diagramEP;

	/**
	 * @param selectedEP
	 *           selected configuration unit editpart
	 */
	public ShowOrNotShowUnitOnHostCommand(DeployShapeNodeEditPart selectedEP) {
		super(selectedEP.getEditingDomain(), Messages.SHOW_UNIT_ON_HOST_ACTION_LABEL,
				getWorkspaceFiles(selectedEP.getNotationView()));

		_selectedEP = selectedEP;
		_diagramEP = GMFUtils.getDeployDiagramEditPart(selectedEP);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		View movedView = _selectedEP.getNotationView();
		Unit movedUnit = (Unit) movedView.getElement();
		boolean isContained = ContainmentStateUtils.isContainedUnit(_selectedEP, movedUnit);
		moveAllViewsOnOrOffHost(_diagramEP, _selectedEP, null, isContained, true);
		return CommandResult.newOKCommandResult(null);
	}

	/**
	 * @param ddep
	 * @param selectedEP
	 * @param toContainerEP
	 * @param isContained
	 * @param isMoveSelectedEP
	 */
	public static void moveAllViewsOnOrOffHost(DeployDiagramEditPart ddep,
			DeployShapeNodeEditPart selectedEP, DeployShapeNodeEditPart toContainerEP,
			boolean isContained, boolean isMoveSelectedEP) {

		View movedView = selectedEP.getNotationView();
		DiagramRootEditPart rootEP = (DiagramRootEditPart) selectedEP.getRoot();
		final DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) rootEP.getChildren().get(0);

		Unit movedUnit = (Unit) movedView.getElement();
		Diagram diagram = ContainmentStateUtils.getDiagram(movedView);
		Map<?, ?> v2eMap = selectedEP.getViewer().getEditPartRegistry();

		/*
		 * we're adding the unit to the diagram or import/import diagram/diagram node
		 */
		if (isContained) {
			// change containment state in diagram model
			ContainmentStateUtils.setContainedUnitState(movedView, false);

			// for all duplicates of this view that are hosted in their containers, delete their views
			List<View> views = GMFUtils.getAllDuplicateViewsFor(diagramEP, movedView, false);
			for (View view : views) {
				// when called from Copy/MoveViewCommand, ignore the moved view--that command has already handled it
				if (!isMoveSelectedEP && view.equals(movedView)) {
					continue;
				}
				View compartmentView = (View) view.eContainer();
				EditPart ep = (EditPart) v2eMap.get(view);

				// if this view isn't affected
				if (ContainmentStateUtils.getDiagram(view) != diagram) {
					continue;
				}

				// if ep is in an import in tree mode, ignore it (style has already been changed
				if (GMFUtils.isImportTreeTopology(ep)) {
					continue;
				}

				View topologyView = getTopologyView(ep, diagramEP);
				// is this a hosting relationship?
				if (isViewHosteeOfCompartment(view, compartmentView)) {
					// see if this topology compartment already has a view to this unit
					boolean hasObjectView = false;
					for (Iterator<?> it = topologyView.getPersistedChildren().iterator(); it.hasNext()
							&& !hasObjectView;) {
						Object ev = it.next();
						if (ev instanceof View) {
							hasObjectView = movedUnit.equals(ViewUtil.resolveSemanticElement((View) ev));
							if (hasObjectView) {
								break;
							}
						}
					}

					// if last view in an inner tree compartment, collapse compartment
					View parentView = (View) view.eContainer();
					if (parentView.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)
							&& parentView.getPersistedChildren().size() == 1) {
						if (parentView.eContainer() != null
								&& parentView.eContainer().eContainer() instanceof View) {
							View grandParentView = (View) parentView.eContainer().eContainer();
							if (grandParentView.getType() != null
									&& grandParentView.getType().equals(
											DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)) {
								ViewUtil.setStructuralFeatureValue(parentView, NotationPackage.eINSTANCE
										.getDrawerStyle_Collapsed(), Boolean.TRUE);
							}
						}
					}

					if (!hasObjectView) {
						// get the parent view of the view to move in order to figure out where
						// to place the moved view in the diagram
						while (parentView.eContainer() != topologyView) {
							parentView = (View) parentView.eContainer();
						}
						Integer newX = (Integer) ViewUtil.getStructuralFeatureValue(parentView,
								NotationPackage.eINSTANCE.getLocation_X());
						Integer newY = new Integer(((Integer) ViewUtil.getStructuralFeatureValue(
								parentView, NotationPackage.eINSTANCE.getLocation_Y())).intValue()
								- DeployCoreConstants.SERVER_UNIT_HEIGHT * 2);
						ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
								.getLocation_X(), newX);
						ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
								.getLocation_Y(), newY);

						// Insert moved view into children list of the diagram view
						topologyView.insertChild(view, true);

						// else delete it
					} else {
						ViewUtil.destroy(view);
					}
				}
			}

			// tell new contained units to fill in their views
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					CanonicalUtils.refreshLinks(diagramEP);
				}
			});

			/*
			 * we're adding the unit back to the list
			 */
		} else {
			// change containment state in diagram model
			ContainmentStateUtils.setContainedUnitState(movedView, true);

			// who is this unit's host?
			Unit hostee = (Unit) selectedEP.resolveSemanticElement();
			List<Unit> hosts = GMFUtils.getAllHosts(hostee);

			// for each host
			if (hosts.size() > 0) {
				boolean succeeded = false;
				for (Unit host : hosts) {
					// then add it to host container
					View containerView = null;
					// there can be duplicate hosts
					List<DeployShapeNodeEditPart> hostEPList = GMFUtils
							.getEditPartsFor(selectedEP, host);
					for (DeployShapeNodeEditPart hostEP : hostEPList) {
						// when called from Copy/MoveViewCommand, ignore the moved view--that command has already handled it
						if (!isMoveSelectedEP
								&& (isAlreadyInHost(movedUnit, hostEP) || hostEP.equals(toContainerEP))) {
							succeeded = true;
							continue;
						}

						// if this view isn't affected
						if (ContainmentStateUtils.getDiagram(hostEP.getNotationView()) != diagram) {
							continue;
						}

						// we ignore duplicate hosts in import trees/diagrams
						if (!GMFUtils.isImportTreeTopology(hostEP) && !GMFUtils.isDiagramNode(hostEP)) {
							// else we copy the original view to the new container
							IGraphicalEditPart containerEP = DeployShapeNodeEditPart
									.getShapesCompartment(hostEP);
							if (containerEP == null) {
								containerEP = DeployShapeNodeEditPart.getListCompartment(hostEP);
							}
							if (containerEP != null) {
								containerView = containerEP.getNotationView();
								succeeded = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyView(
										diagramEP, containerView, movedView) != null;
							}
						}
						if (containerView != null) {
							ViewUtil.setStructuralFeatureValue(containerView, NotationPackage.eINSTANCE
									.getDrawerStyle_Collapsed(), new Boolean(false));
						}
						if (succeeded) {
							hostEP.refresh();
						}

					}

				}
				// if at least one view moved in, we succeeded
				if (succeeded) {

					// delete all hostees
					List<DeployShapeNodeEditPart> hosteeEPList = GMFUtils.getEditPartsFor(selectedEP,
							movedUnit);
					for (DeployShapeNodeEditPart hosteeEP : hosteeEPList) {
						if (ContainmentStateUtils.getDiagram(hosteeEP.getNotationView()) == diagram) {

							// kill old view if on canvas-- if in a container, there's 
							//  another member/host link to that container so we leave it be
							EditPart parentEP = hosteeEP.getParent();
							if (parentEP instanceof DiagramEditPart
									|| parentEP instanceof ImportShapesCompartmentEditPart
									|| parentEP instanceof DiagramShapesCompartmentEditPart) {
								if (!isMoveSelectedEP && hosteeEP.equals(selectedEP)) {
									continue;
								}
								ViewUtil.destroy(hosteeEP.getNotationView());
							}
						}
					}

					// tell new contained units to fill in their views
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							CanonicalUtils.refreshLinks(diagramEP);
						}
					});
				}
			}
		}
	}

	private static boolean isAlreadyInHost(Unit movedUnit, DeployShapeNodeEditPart hostEP) {
		IGraphicalEditPart ep = DeployShapeNodeEditPart.getShapesCompartment(hostEP);
		if (ep == null) {
			ep = DeployShapeNodeEditPart.getListCompartment(hostEP);
		}
		if (ep != null) {
			for (Iterator<?> it = ep.getChildren().iterator(); it.hasNext();) {
				EditPart child = (EditPart) it.next();
				if (child instanceof GraphicalEditPart
						&& movedUnit.equals(((GraphicalEditPart) child).resolveSemanticElement())
						&& GMFUtils.isHosteeOf((GraphicalEditPart) child, hostEP)) {
					return true;
				}
			}
		}
		return false;
	}

	static private boolean isViewHosteeOfCompartment(View view, View compartmentView) {
		EObject hostee = ViewUtil.resolveSemanticElement(view);
		EObject host = ViewUtil.resolveSemanticElement(compartmentView);
		if (host instanceof Unit) {
			return GMFUtils.isHosteeOf(hostee, (Unit) host);
		}
		return false;
	}

	// does this ep live in the canvas or an import or an import diagram
	static private View getTopologyView(EditPart ep, DeployDiagramEditPart diagramEP) {
		// see if unit is in a import/import diagram or diagram
		View topologyView = diagramEP.getNotationView();
		GraphicalEditPart externalEP = GMFUtils.getDiagramNodeEP(ep);
		if (externalEP == null) {
			externalEP = GMFUtils.getImportTopologyEP(ep);
			if (externalEP != null) {
				topologyView = externalEP
						.getChildViewBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
			}
		} else {
			topologyView = externalEP
					.getChildViewBySemanticHint(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		return topologyView;
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doRedo(monitor, info);
		CanonicalUtils.refreshLinks(_diagramEP);
		return status;
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doUndo(monitor, info);
		CanonicalUtils.refreshLinks(_diagramEP);
		return status;
	}
}
