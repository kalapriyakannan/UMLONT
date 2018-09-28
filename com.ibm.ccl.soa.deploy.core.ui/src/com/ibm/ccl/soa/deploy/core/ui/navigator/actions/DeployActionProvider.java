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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import com.ibm.ccl.soa.deploy.core.ui.actions.DeleteTopologyDiagramNodeActionGroup;
import com.ibm.ccl.soa.deploy.core.ui.actions.HighlightUnusedNodesActionGroup;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UndoRedoActionGroup;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;

/**
 * DeployActionProvider contributes the Deployment specific actions to the Deployment Navigator
 * 
 */
public class DeployActionProvider extends CommonActionProvider {
	private IStructuredSelection selection;
	private ICommonActionExtensionSite aConfig;
	private OpenActionGroup openActionGroup;
	private TopologyPublisherActionGroup topologyPublisherActionGroup;
//	private DiscoverLinksActionGroup discoverLinksActionGroup;
	private boolean isInitialized;
	private DeleteTopologyDiagramNodeActionGroup deleteTopologyDiagramNodeActionGroup;
	private AddToPaletteActionGroup addToPaletteActionGroup;
	private OpenCloseTopologyActionGroup openCloseTopologyActionGroup;
	private HighlightUnusedNodesActionGroup highlightUnusedNodesActionGroup;
	private UndoRedoActionGroup undoGroup;

	private IWorkbenchPartSite viewSite = null;

	public void init(ICommonActionExtensionSite aConfig) {
		ICommonViewerWorkbenchSite workbenchSite = null;
		this.aConfig = aConfig;
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			workbenchSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
		}
		if (workbenchSite != null) {
			isInitialized = true;
			viewSite = workbenchSite.getSite();
			openActionGroup = new OpenActionGroup(viewSite);
			topologyPublisherActionGroup = new TopologyPublisherActionGroup(viewSite);
//			discoverLinksActionGroup = new DiscoverLinksActionGroup(viewSite);
			openCloseTopologyActionGroup = new OpenCloseTopologyActionGroup(viewSite);
			highlightUnusedNodesActionGroup = new HighlightUnusedNodesActionGroup(viewSite);
			deleteTopologyDiagramNodeActionGroup = new DeleteTopologyDiagramNodeActionGroup(viewSite);
			addToPaletteActionGroup = new AddToPaletteActionGroup(viewSite);
			aConfig.getStructuredViewer().addSelectionChangedListener(
					deleteTopologyDiagramNodeActionGroup);

			undoGroup = new UndoRedoActionGroup(workbenchSite.getSite(), new EditingDomainUndoContext(
					null));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#dispose()
	 */
	public void dispose() {
		if (isInitialized) {
			openActionGroup.dispose();
			topologyPublisherActionGroup.dispose();
//			discoverLinksActionGroup.dispose();
			openCloseTopologyActionGroup.dispose();
			highlightUnusedNodesActionGroup.dispose();
			aConfig.getStructuredViewer().removeSelectionChangedListener(
					deleteTopologyDiagramNodeActionGroup);
			deleteTopologyDiagramNodeActionGroup.dispose();
			addToPaletteActionGroup.dispose();
			undoGroup.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#setActionContext(org.eclipse.ui.actions.ActionContext)
	 */
	/**
	 * @param aContext
	 */
	public void setContext(ActionContext aContext) {
		super.setContext(aContext);
		if (isInitialized) {
			if (aContext.getSelection() instanceof IStructuredSelection) {
				selection = (IStructuredSelection) aContext.getSelection();
				openActionGroup.setSelection(selection);
				topologyPublisherActionGroup.setSelection(selection);
//				discoverLinksActionGroup.setSelection(selection);
				openCloseTopologyActionGroup.setSelection(selection);
				deleteTopologyDiagramNodeActionGroup.setSelection(selection);
				addToPaletteActionGroup.setSelection(selection);

				IStructuredSelection sSel = selection;
				if (sSel.size() == 1 && sSel.getFirstElement() instanceof EObject) {
					undoGroup.setUndoContext(LightweightOperationFactory.createContext((EObject) sSel
							.getFirstElement()));
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager aMenu) {
		if (isInitialized) {
			openActionGroup.fillContextMenu(aMenu);
			topologyPublisherActionGroup.fillContextMenu(aMenu);
//			discoverLinksActionGroup.fillContextMenu(aMenu);
			openCloseTopologyActionGroup.fillContextMenu(aMenu);
			highlightUnusedNodesActionGroup.fillContextMenu(aMenu);
			deleteTopologyDiagramNodeActionGroup.fillContextMenu(aMenu);
			addToPaletteActionGroup.fillContextMenu(aMenu);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars theActionBars) {
		if (isInitialized) {
			// register an action on the theActionBars for ICommonActionConstants.OPEN
//			theActionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, )
			openActionGroup.fillActionBars(theActionBars);
			topologyPublisherActionGroup.fillActionBars(theActionBars);
//			discoverLinksActionGroup.fillActionBars(theActionBars);
			openCloseTopologyActionGroup.fillActionBars(theActionBars);
			highlightUnusedNodesActionGroup.fillActionBars(theActionBars);
			deleteTopologyDiagramNodeActionGroup.fillActionBars(theActionBars);
			addToPaletteActionGroup.fillActionBars(theActionBars);

			if (undoGroup.getUndoContext() != null) {
				undoGroup.fillActionBars(theActionBars);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento aMemento) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento aMemento) {
	}

}
