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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;

/**
 * 
 * @author jswanke
 */
public class ConvertToShapesOrTreeCommand extends AbstractTransactionalCommand {
	private final boolean _isShapesToTree;
	private final List _selectedObjects;
	private final DeployDiagramEditPart _diagramEP;

	/**
	 * @param diagramEP
	 * @param selectedObjects
	 * @param isShapeToTree
	 * @param cmdName
	 */
	public ConvertToShapesOrTreeCommand(DeployDiagramEditPart diagramEP, List selectedObjects,
			boolean isShapeToTree, String cmdName) {
		super(diagramEP.getEditingDomain(), cmdName, getWorkspaceFiles(diagramEP.getPrimaryView()));

		_isShapesToTree = isShapeToTree;
		_selectedObjects = selectedObjects;
		_diagramEP = diagramEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		for (Iterator<?> it = _selectedObjects.iterator(); it.hasNext();) {
			IGraphicalEditPart selectedEP = (IGraphicalEditPart) it.next();
			// capture info from old view
			View oldView = selectedEP.getNotationView();
			View containerView = (View) oldView.eContainer();
			EObject element = selectedEP.resolveSemanticElement();
			Integer x = (Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE.getLocation_X());
			Integer y = (Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(oldView, NotationPackage.eINSTANCE.getLocation_Y());
			boolean isShapeMode = DeployShapeNodeEditPart.isShapesMode(selectedEP);
			// this one is already that mode, no conversion
			if (_isShapesToTree != isShapeMode) {
				continue;
			}

			// get collapse state -- don't expand new widget unless old view was expanded
			final IGraphicalEditPart compartmentEP = isShapeMode ? DeployShapeNodeEditPart
					.getShapesCompartment(selectedEP) : DeployShapeNodeEditPart
					.getListCompartment(selectedEP);
			boolean wasExpanded = _selectedObjects.size() == 1 && !_isShapesToTree
					|| ((ResizableCompartmentFigure) compartmentEP.getFigure()).isExpanded()
					&& compartmentEP.getChildren().size() > 0;

			// if this is an import diagram, we need to copy the diagram link
			Diagram importDiagram = selectedEP instanceof ImportTopologyEditPart ? ((ImportTopologyEditPart) selectedEP)
					.getImportDiagram()
					: null;

			// recreate view with overridden preference for tree or shape compartment
			IGraphicalEditPart parent = (IGraphicalEditPart) selectedEP.getParent();
			DeployCoreViewProvider
					.setOverridePreference(_isShapesToTree ? DeployCoreViewProvider.FORCE_TREE
							: DeployCoreViewProvider.FORCE_SHAPES);
			View newView = ViewUtil.createNode(new EObjectAdapter(element), containerView, oldView
					.getType(), -1, _diagramEP.getDiagramPreferencesHint());
			DeployCoreViewProvider.setOverridePreference(0);

			// position new view where old one was
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(newView,
					NotationPackage.eINSTANCE.getLocation_X(), x);
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(newView,
					NotationPackage.eINSTANCE.getLocation_Y(), y);

			// if there's a diagram link, add it to the new view
			if (importDiagram != null) {
				DiagramLinkStyle style = (DiagramLinkStyle) newView.getStyle(NotationPackage.eINSTANCE
						.getDiagramLinkStyle());
				if (style != null) {
					style.setDiagramLink(importDiagram);
				}
			}

			// copy colors
			ViewUtil.copyColorsAndText(oldView, newView);
			ViewUtil.copyFont(oldView, newView);

			// if any contained views were deleted (invisible) copy invisibility style
			ViewUtil.copyFilteredElements(oldView, newView);

			// copy import stuff if any
			ViewUtil.copyImportSupport(oldView, newView);

			DeployStyle oldStyle = (DeployStyle) oldView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			DeployStyle newStyle = (DeployStyle) newView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());

			// copy duplicate view style
			if (oldStyle.isIsDuplicateCanvasView()) {
				newStyle.setIsDuplicateCanvasView(true);
			}

			// copy any snap group association
			View snapGroup = null;
			if (oldStyle.getSnapParent() != null) {
				View snapRow = oldStyle.getSnapParent();
				snapGroup = (View) snapRow.eContainer();
				DeployStyle snapRowStyle = (DeployStyle) snapRow
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				int inx = snapRowStyle.getSnapChildren().indexOf(oldView);
				snapRowStyle.getSnapChildren().set(inx, newView);
				oldStyle.setSnapParent(null);
				newStyle.setSnapParent(snapRow);
			}

			// copy children's format's etc --but not for diagrams--they already grab their visual model from source diagram
			if (compartmentEP instanceof HybridListCompartmentEditPart
					|| compartmentEP instanceof HybridShapesCompartmentEditPart) {
				ViewUtil.copyViewChildren(_diagramEP, oldView, newView);
			}

			// destroy old view
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(oldView);

			// ask the parent to make a new editpart for the new view
			parent.refresh();

			// expand compartment if old view was expanded
			if (wasExpanded) {
				expandCompartment(newView, element);
			}

			// re-layout connectors
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					GEFUtils.layoutConnectors();
				}
			});

			// realign snapped groups
			if (snapGroup != null) {
				final View sg = snapGroup;
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						ArrangeSnappedViewsCommand.arrangeSnappedViews(_diagramEP.getEditingDomain(), sg,
								_diagramEP.getViewer(), SnapUtils.ANCHOR_GROUP, null);
					}
				});
			}

		}

		return CommandResult.newOKCommandResult(null);
	}

	private void expandCompartment(View newView, final EObject element) {
		View compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getChildBySemanticHint(newView, DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView, DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView, DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView,
							DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView, DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
		}
		if (compartmentView == null) {
			compartmentView = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getChildBySemanticHint(newView, DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		if (compartmentView != null) {
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(
					compartmentView, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), new Boolean(
							false));
		}

// update contained views and links
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				for (DeployShapeNodeEditPart ep : GMFUtils.getEditPartsFor(_diagramEP, element)) {
					CanonicalUtils.refresh(ep, true);
				}
				CanonicalUtils.refreshLinks();
			}

		});
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
