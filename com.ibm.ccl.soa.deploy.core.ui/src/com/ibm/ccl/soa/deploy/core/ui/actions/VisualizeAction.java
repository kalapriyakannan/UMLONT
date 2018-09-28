/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.editor.TopologyDiagramCreateHelper;
import com.ibm.ccl.soa.deploy.core.ui.editor.VisualizeFileEditorInput;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ImportListCompartmentCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.util.AdaptabilityUtility;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * This action is used to toggle conceptual attribute on a unit.
 */
public class VisualizeAction extends DiagramAction {
	private static final int VISUALIZE_TO_CURRENT_DIAGRAM = 0;
	private static final int VISUALIZE_TO_NEW_DIAGRAM = 1;
	private final int _mode;

	/**
	 * @param workbenchPage
	 */
	public VisualizeAction(IWorkbenchPage workbenchPage, int mode) {
		super(workbenchPage);
		_mode = mode;
		init();
	}

	public void init() {
		super.init();

		setId(DeployActionIds.ACTION_TOGGLE_CONCEPTUAL);
		setHoverImageDescriptor(getImageDescriptor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#calculateEnabled()
	 */
	protected boolean calculateEnabled() {
		if (getSelectedObjects().isEmpty()) {
			return false;
		}
		switch (_mode)
		{
		// enable to current if single with GMF.getDIagram!=null
		case VISUALIZE_TO_CURRENT_DIAGRAM: {
			Object selected = getSelectedObjects().get(0);
			return getSelectedObjects().size() == 1
					&& (selected instanceof ImportTopologyEditPart
							&& ((ImportTopologyEditPart) selected).isImportDiagram() || selected instanceof DiagramNodeEditPart);
		}

			// enable if all DeployShapeNodeEditPart
		case VISUALIZE_TO_NEW_DIAGRAM: {
			for (Iterator<?> i = getSelectedObjects().iterator(); i.hasNext();) {
				Object selected = i.next();
				if (!(selected instanceof DeployShapeNodeEditPart)
						|| selected instanceof ImportTopologyEditPart
						|| selected instanceof DiagramNodeEditPart) {
					return false;
				}
			}
			return true;
		}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#doRun(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		AbstractTransactionalCommand toggleCmd = new AbstractTransactionalCommand(
				getDiagramEditPart().getEditingDomain(), getToolTipText(), null) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				switch (_mode)
				{
				case VISUALIZE_TO_CURRENT_DIAGRAM: {
					// collect all dmos in source diagram
					IGraphicalEditPart ep = (IGraphicalEditPart) getSelectedObjects().get(0);
					List<DeployModelObject> dmoList = new ArrayList<DeployModelObject>();
					List visibleUnits = null;
					Diagram diagram = GMFUtils.getDiagram(ep);
					if (ep instanceof DiagramNodeEditPart) {
						for (Iterator<?> it = DiagramUtils.getAllChildViewsIncludingGroup(diagram)
								.iterator(); it.hasNext();) {
							dmoList.add((DeployModelObject) ViewUtil.resolveSemanticElement((View) it
									.next()));
						}
					} else {
						DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
						Import imprt = (Import) ep.resolveSemanticElement();
						InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
						visibleUnits = ddep.getSemanticCacheData().getImportCacheMap()
								.get(instanceConfig);
						if (visibleUnits != null) {
							dmoList = ImportListCompartmentCanonicalEditPolicy.getDiagramUnits(diagram,
									visibleUnits);
						}
					}
					try {
						// visualize in this diagram using old diagram views as template
						VisualizeFromNotationalCommand visualizeCmd = new VisualizeFromNotationalCommand(
								getEditingDomain(), getDiagramEditPart(), dmoList, visibleUnits, diagram,
								ep.getFigure().getBounds().getBottomLeft().getTranslated(0,
										DeployCoreConstants.SERVER_UNIT_HEIGHT), false, false);
						visualizeCmd.execute(monitor, null);
					} catch (ExecutionException e) {
						DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					} finally {
						monitor.done();
					}

					break;

				}

				case VISUALIZE_TO_NEW_DIAGRAM: {
					// filter out children of a parent that's already selected
					List<?> selectedObjects = getSelectedObjects();
					Map<DeployModelObject, View> viewMap = new HashMap<DeployModelObject, View>();
					for (Iterator<?> it = selectedObjects.iterator(); it.hasNext();) {
						DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) it.next();
						if (GEFUtils.isChildOf(ep, selectedObjects)) {
							continue;
						}
						viewMap
								.put((DeployModelObject) ep.resolveSemanticElement(), ep.getNotationView());
					}
					if (viewMap.size() > 0) {
						try {

							// create the new diagram
							IFile file = (IFile) AdaptabilityUtility.getAdapter(viewMap.keySet()
									.iterator().next(), IFile.class);
							IFile diagramFile = TopologyDiagramCreateHelper.createTopologyDiagram(file,
									null);

							// open new diagram and pass this diagram's views as a template for creating new views 
							if (diagramFile != null) {
								IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
										.getActivePage();
								IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
								page.openEditor(new VisualizeFileEditorInput(diagramFile, viewMap),
										registry.getDefaultEditor(file.getName()).getId());
							}
						} catch (PartInitException e) {
							DeployCorePlugin.log(IStatus.ERROR, 0, e.getMessage(), e);
						}
					}
				}
				}
				return CommandResult.newOKCommandResult();
			}
		};

		DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
				.getDiagramCommandStack();
		cmdStack.execute(new ICommandProxy(toggleCmd));
	}

	public static VisualizeAction createVisualizeToCurrentDiagram(IWorkbenchPage workbenchPage) {
		VisualizeAction action = new VisualizeAction(workbenchPage, VISUALIZE_TO_CURRENT_DIAGRAM);
		action.setText(Messages.VisualizeAction_Visualize_to_Current_Diagra_);
		action.setToolTipText(Messages.VisualizeAction_Visualize_to_Current_Diagra_);
		return action;
	}

	public static VisualizeAction createVisualizeToNewDiagram(IWorkbenchPage workbenchPage) {
		VisualizeAction action = new VisualizeAction(workbenchPage, VISUALIZE_TO_NEW_DIAGRAM);
		action.setText(Messages.VisualizeAction_Visualize_to_New_Diagra_);
		action.setToolTipText(Messages.VisualizeAction_Visualize_to_New_Diagra_);
		return action;
	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}
}
