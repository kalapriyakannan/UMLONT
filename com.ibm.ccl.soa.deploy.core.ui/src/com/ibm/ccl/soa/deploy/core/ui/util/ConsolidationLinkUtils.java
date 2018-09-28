/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.ConsolidationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;

/**
 * @author jswanke
 * 
 */
public class ConsolidationLinkUtils {

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  ConsolidatedLinkData ////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @since 7.0 maintain data on each consolidated link
	 * 
	 */
	public class ConsolidatedLinkData {
		IFigure _source;
		IFigure _target;
		Edge _consolidatedLink;
		List<DeployLinkConnection> _links = new ArrayList<DeployLinkConnection>();

		/**
		 * create using non-consolidation link
		 * 
		 * @param link
		 */
		public ConsolidatedLinkData(DeployLinkConnection link) {
			ConnectionAnchor anchor = link.getSourceAnchor();
			_source = anchor != null ? anchor.getOwner() : null;
			anchor = link.getTargetAnchor();
			_target = anchor != null ? anchor.getOwner() : null;
			_links.add(link);
			_consolidatedLink = null;
		}

		/**
		 * create using consolidation link
		 * 
		 * @param link
		 * @param edge
		 */
		public ConsolidatedLinkData(DeployLinkConnection link, Edge edge) {
			ConnectionAnchor anchor = link.getSourceAnchor();
			_source = anchor != null ? anchor.getOwner() : null;
			anchor = link.getTargetAnchor();
			_target = anchor != null ? anchor.getOwner() : null;
			_consolidatedLink = edge;
		}

		/**
		 * @param link
		 * @return does this link belong in this consolidated link?
		 */
		public boolean isEqual(DeployLinkConnection link) {
			ConnectionAnchor anchor = link.getSourceAnchor();
			IFigure source = anchor != null ? anchor.getOwner() : null;
			anchor = link.getTargetAnchor();
			IFigure target = anchor != null ? anchor.getOwner() : null;
			return source == _source && target == _target || source == _target && target == _source;
		}

		/**
		 * @return source
		 */
		public IFigure getSource() {
			return _source;
		}

		/**
		 * @return target
		 */
		public IFigure getTarget() {
			return _target;
		}

		/**
		 * @return links
		 */
		public List<DeployLinkConnection> getLinks() {
			return _links;
		}

		/**
		 * @return edge of consolidated link
		 */
		public Edge getConsolidatedLink() {
			return _consolidatedLink;
		}

		/**
		 * @param consolidatedLink
		 */
		public void setConsolidatedLink(Edge consolidatedLink) {
			_consolidatedLink = consolidatedLink;
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  UTILITIES ////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * refresh consolidate links on canvas-- create new ones, delete old ones
	 * 
	 * @param ep
	 */
	static public void refreshConsolidatedLinks(final IGraphicalEditPart ep) {

		Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		AbstractEMFOperation operation = new AbstractEMFOperation(ep.getEditingDomain(),
				StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
				if (ddep == null) {
					return Status.OK_STATUS;
				}
				boolean dirtyFlag = false;
				Resource res = ((EObject) ddep.getModel()).eResource();
				if (res != null) {
					dirtyFlag = res.isModified();
				}
				try {
					return doExecute(ddep, monitor, info);
				} finally {
					if (res != null) {
						res.setModified(dirtyFlag);
					}
				}
			}

			private IStatus doExecute(DeployDiagramEditPart ddep, IProgressMonitor monitor,
					IAdaptable info) {
				// get consolidated link data
				List<ConsolidatedLinkData> consolidatedLinkDataList = ddep
						.getConsolidatedLinkDataList();

				// refresh link data
				for (Iterator<ConsolidatedLinkData> it = consolidatedLinkDataList.iterator(); it
						.hasNext();) {
					it.next().getLinks().clear();
				}
				IFigure connectionLayer = LayerManager.Helper.find(ep).getLayer(
						LayerConstants.CONNECTION_LAYER);
				for (Iterator<?> it = connectionLayer.getChildren().iterator(); it.hasNext();) {
					IFigure fig = (IFigure) it.next();
					// make sure consolidated links are in the list
					if (fig instanceof ConsolidationLinkConnection) {
						ConsolidationLinkConnection linkFig = (ConsolidationLinkConnection) fig;
						Edge edge = (Edge) linkFig.getConnectionEP().getNotationView();
						boolean b = false;
						for (Iterator<ConsolidatedLinkData> it2 = consolidatedLinkDataList.iterator(); it2
								.hasNext()
								&& !b;) {
							b = it2.next().getConsolidatedLink() == edge;
						}
						if (!b) {
							consolidatedLinkDataList
									.add(new ConsolidationLinkUtils().new ConsolidatedLinkData(linkFig, edge));
						}
					} else if (fig instanceof DeployLinkConnection
							&& ((DeployLinkConnection) fig).isVisibleIgnoringConsolidation()) {
						DeployLinkConnection linkFig = (DeployLinkConnection) fig;
						boolean b = false;
						for (Iterator<ConsolidatedLinkData> it2 = consolidatedLinkDataList.iterator(); it2
								.hasNext();) {
							ConsolidatedLinkData linkData = it2.next();
							if ((b = linkData.isEqual(linkFig)) == true) {
								linkData.getLinks().add(linkFig);
								break;
							}
						}
						if (!b) {
							consolidatedLinkDataList
									.add(new ConsolidationLinkUtils().new ConsolidatedLinkData(linkFig));
						}
					}
				}

				// find and process consolidated links
				Map figToEditpartRegistry = ep.getViewer().getVisualPartMap();
				Map edgeToEditpartRegistry = ep.getViewer().getEditPartRegistry();
				List<ConsolidatedLinkData> removeList = new ArrayList<ConsolidatedLinkData>();
				for (Iterator<ConsolidatedLinkData> it = consolidatedLinkDataList.iterator(); it
						.hasNext();) {
					ConsolidatedLinkData linkData = it.next();
					int nLinks = linkData.getLinks().size();
					// if one or less links, no consolidated links
					if (nLinks <= 1) {
						// if this had a consolidated link before, delete it now
						if (linkData.getConsolidatedLink() != null) {
							Edge edge = linkData.getConsolidatedLink();
							// determine if this is permanent
							EObject eo = edge.eContainer();
							boolean isPersisted = eo instanceof Diagram
									&& ((Diagram) eo).getPersistedEdges().contains(edge);
							ViewUtil.destroy(linkData.getConsolidatedLink());
							if (isPersisted) {
								recordDelete(ddep);
							}
						}
						// make link visible if we made it invisible
						if (nLinks == 1) {
							DeployLinkConnection linkFig = linkData.getLinks().get(0);
							if (linkFig.isConsolidated()) {
								linkFig.setConsolidated(false);
								linkFig.setVisible(true);
							}
						}
						removeList.add(linkData);
					} else {
						// make all consolidated links invisible
						for (Iterator<DeployLinkConnection> it2 = linkData.getLinks().iterator(); it2
								.hasNext();) {
							DeployLinkConnection linkFig = it2.next();
							linkFig.setConsolidated(true);
						}
						// if there is no consolidated link edge, create it now
						if (linkData.getConsolidatedLink() == null) {
							Edge edge = ViewService.getInstance().createEdge(null, ddep.getNotationView(),
									DeployCoreConstants.CONSOLIDATIONLINK_SEMANTICHINT, -1, false,
									ddep.getDiagramPreferencesHint());
							IGraphicalEditPart srcEP = (IGraphicalEditPart) figToEditpartRegistry
									.get(linkData.getSource());
							edge.setSource(srcEP.getNotationView());
							IGraphicalEditPart tgtEP = (IGraphicalEditPart) figToEditpartRegistry
									.get(linkData.getTarget());
							edge.setTarget(tgtEP.getNotationView());
							linkData.setConsolidatedLink(edge);
							// else refresh the editpart of the current one
						} else {
							// make sure this view is transient (GMF makes transient views 
							// persisted if ANY other persisted view is added to the diagram
							Edge edge = linkData.getConsolidatedLink();
							EObject eo = edge.eContainer();
							if (eo instanceof Diagram && ((Diagram) eo).getPersistedEdges().contains(edge)) {
								Diagram diagram = (Diagram) eo;
								diagram.getPersistedEdges().remove(edge);
								diagram.getTransientEdges().add(edge);
							}
							ConsolidationLinkEditPart linkEP = (ConsolidationLinkEditPart) edgeToEditpartRegistry
									.get(edge);
							if (linkEP != null
									&& isConsolidatedListChanged(linkEP.getConsolidatedLinkList(), linkData
											.getLinks())) {
								linkEP.refresh();
							}
						}
					}
				}
				consolidatedLinkDataList.removeAll(removeList);
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			DeployCoreUIPlugin.logError(0, "Could not add consolidated links", null); //$NON-NLS-1$
		}

	}

	private static boolean isConsolidatedListChanged(List<DeployConnectionNodeEditPart> eplist,
			List<DeployLinkConnection> links) {
		if (eplist.size() == links.size()) {
			for (DeployConnectionNodeEditPart linkEP : eplist) {
				if (!links.contains(linkEP.getFigure())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	static private void recordDelete(DeployDiagramEditPart ddep) {
		if (ddep.getInitialCanonicalChanges() != null) {
			ddep.getInitialCanonicalChanges().add(
					new DiagramUpdateData(null, null, null, Messages.UNKNOWN_LABEL,
							Messages.ConsolidationLinkUtils_Consolidation_lin_, false,
							DiagramUpdateData.DELETED));
		}
	}

	/**
	 * given a consolidated link return the consolidation link it lives in
	 * 
	 * @param linkEP
	 * @return consolidation link
	 */
	public static ConsolidationLinkEditPart getConsolidationLink(DeployConnectionNodeEditPart linkEP) {
		IFigure linkFig = linkEP.getFigure();
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(linkEP);
		List<ConsolidatedLinkData> consolidatedLinkDataList = ddep.getConsolidatedLinkDataList();
		for (Iterator<ConsolidatedLinkData> it = consolidatedLinkDataList.iterator(); it.hasNext();) {
			ConsolidatedLinkData linkData = it.next();
			if (linkData.getLinks().contains(linkFig)) {
				Map edgeToEditpartRegistry = linkEP.getViewer().getEditPartRegistry();
				return (ConsolidationLinkEditPart) edgeToEditpartRegistry.get(linkData
						.getConsolidatedLink());
			}
		}
		return null;
	}
}
