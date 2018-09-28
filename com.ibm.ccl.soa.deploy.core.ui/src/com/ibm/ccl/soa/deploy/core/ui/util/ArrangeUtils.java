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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.SnapEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployConnectionLayerEx;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployDeferredLayoutCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

/**
 * @author jswanke
 * 
 */
public class ArrangeUtils {

	private static int SPACER = MapModeUtil.getMapMode().DPtoLP(15);
	private static int NEWUNIT_VSPACER = MapModeUtil.getMapMode().DPtoLP(20);
	private static int NEWUNIT_HSPACER = MapModeUtil.getMapMode().DPtoLP(30);

	public static int UNKNOWNLINK = 0;
	public static int HOSTINGLINK = 1;
	public static int DEPENDENCYLINK = 2;
	public static int REALIZATIONLINK = 3;
	public static int CONSTRAINTLINK = 4;
	public static int COLLATIONLINK = 5;
	public static int ANTICOLLATIONLINK = 6;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// LAY CANVAS OUT AROUND NEW FIGURES ///////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param editparts
	 * @param orgPt
	 * @param sourceDiagram --
	 *           if not null, use matching editparts in this diagram to arrange
	 * @param isSelection --
	 *           this is a selection arrange action -- therefore get pt origin from the most upper
	 *           left corner of all editparts that are to be arranged
	 * @param useOperation --
	 *           if true, do view position changes in an operation; if flase, this must be called in
	 *           a command or operation
	 * @return boundary of newly arrange units
	 */
	public static Rectangle arrangeEditParts(final List<GraphicalEditPart> editpartz, Point orgPt,
			final boolean isSelection, final boolean useOperation) {
		if (editpartz.size() == 0) {
			return Rectangle.SINGLETON.setSize(0, 0);
		}

		// if parts have multiple parents, use the top editparts instead
		boolean useTopEditParts = false;
		EditPart commonContainer = null;
		Set<GraphicalEditPart> topEditPartSet = new HashSet<GraphicalEditPart>();
		for (GraphicalEditPart ep : editpartz) {
			if (!useTopEditParts) {
				if (commonContainer == null) {
					commonContainer = GMFUtils.getEditPartContainer(ep);
				} else if (!commonContainer.equals(GMFUtils.getEditPartContainer(ep))) {
					useTopEditParts = true;
					commonContainer = GMFUtils.getDeployDiagramEditPart(ep);
					// if there are snap groups, filter out the snapeditparts
				} else if (ep instanceof SnapEditPart) {
					useTopEditParts = true;
					continue;
				}
			}
			topEditPartSet.add((GraphicalEditPart) GEFUtils.getTopEditPart(ep));
		}
		List<GraphicalEditPart> topEditParts = useTopEditParts ? new ArrayList<GraphicalEditPart>(
				topEditPartSet) : editpartz;

		// get viewer and editing domain
		final GraphicalEditPart firstEP = topEditParts.get(0);
		EditPartViewer viewer = firstEP.getViewer();
		final TransactionalEditingDomain editingDomain = firstEP.getEditingDomain();
		Map v2eMap = viewer.getEditPartRegistry();

		// determine the width of the screen
		int displayWidth = viewer.getControl().getBounds().width;
		if (displayWidth == 0) {
			displayWidth = 600;
		}
		displayWidth = MapModeUtil.getMapMode().DPtoLP(displayWidth);

		// determine the upper/left corner to arrange these parts from
		GraphicalEditPart topLeftPart = null;
		if (orgPt == null) {
			orgPt = new Point(NEWUNIT_HSPACER, NEWUNIT_VSPACER);
			if (isSelection) {
				topLeftPart = getTopLeftEditPart(topEditParts);
				orgPt = topLeftPart.getFigure().getBounds().getTopLeft();
			}
		}

		// collapse all editparts and reset layout states
		if (!isSelection) {
			viewer.deselectAll();
		}
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(firstEP);
		ddep.getLayoutStateList().clear();

		Map<View, Point> moveMap = new HashMap<View, Point>();
		boolean isContainedArrange = false;
		Rectangle boundary = arrangeEditPartsHelper(topEditParts, viewer, commonContainer, v2eMap,
				orgPt, displayWidth * 7 / 6, ddep, useOperation, topLeftPart, isSelection,
				isContainedArrange, moveMap);

		// do the actual arrangement
		LayoutUtils.setViewsBounds(editingDomain, moveMap, v2eMap, true, useOperation);

		return boundary;

	}

	private static Rectangle arrangeEditPartsHelper(List<GraphicalEditPart> topEditParts,
			EditPartViewer viewer, EditPart commonContainer, Map v2eMap, Point orgPt,
			int displayWidth, DeployDiagramEditPart ddep, boolean useOperation,
			GraphicalEditPart topLeftPart, boolean isSelection, boolean isContainedArrange,
			Map<View, Point> moveMap) {
		// collect linking data on all selected editparts
		Map<GraphicalEditPart, LinkData> linkMap = createLinkMap(topEditParts, commonContainer,
				viewer.getVisualPartMap());

		// sort ep's into two big linked and unlinked clusters
		LinkingCluster unlinkedCluster = new ArrangeUtils().new LinkingCluster(null, 0, v2eMap);
		LinkingCluster linkedCluster = new ArrangeUtils().new LinkingCluster(null, 0, v2eMap);
		createLinkedAndUnlinkedClusters(topEditParts, linkMap, unlinkedCluster, linkedCluster, v2eMap);

		// analysis links in linkedCluster into smaller clusters with multiple rows of units all related by links
		List<LinkingCluster> linkingClusterList = new ArrayList<LinkingCluster>();
		createLinkingClusters(linkedCluster, linkingClusterList, linkMap, v2eMap);

		// arrange unlinked cluster by putting imports at top
		// create multiple rows out of linked and unlinked cluster to fit in screen 
		arrangeClusterRows(unlinkedCluster, linkedCluster, linkingClusterList, orgPt, displayWidth,
				linkMap);

		// sort list of linking clusters by size (smallest at top)
		sortClusters(linkingClusterList);

		// move clusters into rows
		Rectangle boundary = moveClusters(orgPt, unlinkedCluster, linkedCluster, linkingClusterList,
				moveMap, topEditParts, displayWidth, v2eMap, viewer, ddep, useOperation, topLeftPart,
				isSelection, isContainedArrange);

		// now arrange any containers
		for (GraphicalEditPart ep : topEditParts) {
			IGraphicalEditPart gep = DeployShapeNodeEditPart.getShapesCompartment(ep);
			if (gep != null) {
				int width = ep.getFigure().getBounds().width;
				if (width < DeployCoreConstants.SERVER_UNIT_WIDTH * 4) {
					width = DeployCoreConstants.SERVER_UNIT_WIDTH * 4;
				}
				arrangeEditPartsHelper(gep.getChildren(), viewer, gep, v2eMap, new Point(100, 100),
						width, ddep, useOperation, null, isSelection, true, moveMap);
			}
		}
		return boundary;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   HELPER METHODS        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// divides units into a big row of linked and unlink units
	private static void createLinkedAndUnlinkedClusters(List<GraphicalEditPart> editparts,
			Map<GraphicalEditPart, LinkData> linkMap, LinkingCluster unlinkedCluster,
			LinkingCluster linkedCluster, Map v2eMap) {

		// loop through all editparts adding to linked or unlinked cluster
		for (Iterator<GraphicalEditPart> it = editparts.iterator(); it.hasNext();) {
			GraphicalEditPart ep = it.next();
			LinkData ld = linkMap.get(ep);

			// if a unit has no links or if an import topology figure, add to unlinked clusters
			if (ep instanceof ImportTopologyEditPart || ld._sources.size() == 0
					&& ld._targets.size() == 0) {
				ld._ed = unlinkedCluster.addToRow(0, ep, v2eMap);
			} else {
				ld._ed = linkedCluster.addToRow(0, ep, v2eMap);
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// create clusters (aka stacks) using links as the guide
	private static void createLinkingClusters(LinkingCluster linkedCluster,
			List<LinkingCluster> linkingClusterList, Map<GraphicalEditPart, LinkData> linkMap,
			Map v2eMap) {

		// get pool of linked units that we can create stacks out of
		List<EditPartData> poolList = linkedCluster.rows.get(0); // linked cluster only has one row at this point

		// until this pool of linked units is empty OR the last loop didn't remove anything from the pool
		int lastPoolSize = 1000000;
		while (!poolList.isEmpty() && poolList.size() < lastPoolSize) {
			lastPoolSize = poolList.size();

			// find the current longest strand of links in the pool ex: a->b->c->d
			int[] longestStrandType = new int[] { -1 };

			List<EditPartData> longestStrand = findLongestStrand(poolList, linkMap, longestStrandType);
			if (longestStrand.isEmpty()) {
				return; // impossible state taken care of here
			}

//			String cause = "Longest strand is "; //$NON-NLS-1$
//			for (EditPartData ed : longestStrand) {
//				cause += "'" + GMFUtils.getDmoName(ed.ep.resolveSemanticElement()) + "' "; //$NON-NLS-1$ //$NON-NLS-2$
//			}
//			System.out.println(cause);

			// create new linkingCluster using this strand and add to linkingClusterList
			LinkingCluster linkingCluster = new ArrangeUtils().new LinkingCluster(null,
					longestStrandType[0], v2eMap);
			linkingClusterList.add(linkingCluster);
			int thisRow = 0;
			for (EditPartData ed : longestStrand) {
				ed.rowPosition = EditPartData.MIDDLE;
				ed.isPredominate = true;
				linkingCluster.addToRow(thisRow++, ed, linkedCluster, v2eMap);
			}
			// remove strand from pool of available ep's
			poolList.removeAll(longestStrand);

//			cause = "left in pool "; //$NON-NLS-1$
//			for (EditPartData ed : poolList) {
//				cause += "'" + GMFUtils.getDmoName(ed.ep.resolveSemanticElement()) + "' "; //$NON-NLS-1$ //$NON-NLS-2$
//			}
//			System.out.println(cause);

			// loop thru the rows in the new cluster from the top down (last row to first) until nothing was removed from pool
			int lastPoolSize2 = 1000000;
			while (poolList.size() < lastPoolSize2) {
				lastPoolSize2 = poolList.size();

				// when filling in the units associated with the main strand, we add the predominate units first (linked
				// to the strand with the longest strand's link type) so that the main link type is always pointing down
				// otherwise units would be added randomly and the predominate link might actually even point up

				// just fill in units attached to the longest strand with the predominate link
//				System.out.println("fill predominate " + longestStrandType[0]); //$NON-NLS-1$
				fillCluster(linkingCluster, longestStrandType[0], true, poolList, linkMap);

				// then fill in units attached by any link type to the main strand
//				System.out.println("fill rest"); //$NON-NLS-1$
				fillCluster(linkingCluster, longestStrandType[0], false, poolList, linkMap);

				// repeat until cluster is filled out
			}
		}
	}

	private static void fillCluster(LinkingCluster linkingCluster, int predominateLinkType,
			boolean fillPredominateLink, List<EditPartData> poolList,
			Map<GraphicalEditPart, LinkData> linkMap) {

		// loop thru the rows in the new cluster from the top down (last row to first) until nothing was removed from pool
		List<List<EditPartData>> rows = linkingCluster.rows;
		int lastPoolSize = 1000000;
		while (poolList.size() < lastPoolSize) {
			lastPoolSize = poolList.size();

			// pad linkingCluster with empty rows on top and bottom to allow for expansion
			// on first loop, we always add padding, on subsequent loops, we only add padding if the 
			// previous loop used up one of these paddings
			if (!rows.get(0).isEmpty()) {
				rows.add(0, new ArrayList<EditPartData>());
			}
			if (!rows.get(rows.size() - 1).isEmpty()) {
				rows.add(new ArrayList<EditPartData>());
			}

			// for every row in this new linkingCluster, for every ed in that row, add all of that ed's
			//   sources/targets to previous/next rows in cluster
			for (int thisRow = rows.size() - 2; thisRow > 0; thisRow--) {
				List<EditPartData> row = rows.get(thisRow);
				int[] rowPositionToggle = new int[] { EditPartData.START };
				List<EditPartData> appendFront = new ArrayList<EditPartData>();
				List<EditPartData> appendBack = new ArrayList<EditPartData>();
				for (EditPartData ed : row) {
					// we look thru these rows only for eds whose sources/targets haven't already been processed
					if (ed.processedState == EditPartData.UNPROCESSED && fillPredominateLink
							|| ed.processedState == EditPartData.PRIMARYPROCESSED && !fillPredominateLink) {
						if (fillPredominateLink) {
							ed.processedState = EditPartData.PRIMARYPROCESSED;
						} else if (ed.processedState == EditPartData.PRIMARYPROCESSED) {
							ed.processedState = EditPartData.PROCESSED;
						}
						LinkData hd = linkMap.get(ed.ep);
						for (Entry<LinkData, Integer> entry : hd._sources.entrySet()) {
							LinkData ld = entry.getKey();
							EditPartData thisEd = ld._ed;
							if (thisEd != null && poolList.contains(thisEd)) {
								int linkType = entry.getValue();
								// predominate units can only be added to predominate units 
								if (fillPredominateLink && linkType == predominateLinkType
										&& ed.isPredominate || !fillPredominateLink
										&& linkType != predominateLinkType
										&& inCluster(thisEd, linkMap, linkingCluster)) {
									addToRow(thisEd, poolList, linkingCluster, thisRow, rows,
											ed.rowPosition, fillPredominateLink, predominateLinkType,
											rowPositionToggle, appendFront, appendBack, true);
								}
							}
						}
						for (Entry<LinkData, Integer> entry : hd._targets.entrySet()) {
							LinkData ld = entry.getKey();
							EditPartData thisEd = ld._ed;
							if (thisEd != null && poolList.contains(thisEd)) {
								int linkType = entry.getValue();
								if (fillPredominateLink && linkType == predominateLinkType
										&& ed.isPredominate || !fillPredominateLink
										&& linkType != predominateLinkType
										&& inCluster(thisEd, linkMap, linkingCluster)) {
									addToRow(thisEd, poolList, linkingCluster, thisRow, rows,
											ed.rowPosition, fillPredominateLink, predominateLinkType,
											rowPositionToggle, appendFront, appendBack, false);
								}
							}
						}
					}
				}
				// to prevent concurrent problems on row array, we add ed's to the row at the end
				row.addAll(0, appendFront);
				row.addAll(appendBack);
			}
		}
		// remove any unused padding added to this new cluster
		if (rows.get(0).isEmpty()) {
			rows.remove(0);
		}
		if (rows.get(rows.size() - 1).isEmpty()) {
			rows.remove(rows.size() - 1);
		}
	}

	// does this unit have a primary link to outside of this cluster?
	private static boolean inCluster(EditPartData thisEd, Map<GraphicalEditPart, LinkData> linkMap,
			LinkingCluster linkingCluster) {

//		String cause = "Currently in cluster "; //$NON-NLS-1$
//		for (EditPartData ed : linkingCluster.editPartDataList) {
//			cause += "'" + GMFUtils.getDmoName(ed.ep.resolveSemanticElement()) + "' "; //$NON-NLS-1$ //$NON-NLS-2$
//		}
//		System.out.println(cause);

		LinkData hd = linkMap.get(thisEd.ep);
		for (Entry<LinkData, Integer> entry : hd._sources.entrySet()) {
			LinkData ld = entry.getKey();
			if (!linkingCluster.editPartDataList.contains(ld._ed)) {
//				System.out
//						.println("this ed " + GMFUtils.getDmoName(thisEd.ep.resolveSemanticElement()) + //$NON-NLS-1$
//								" has link to outside cluster " + //$NON-NLS-1$
//								GMFUtils.getDmoName(ld._ed.ep.resolveSemanticElement()));
				return false;
			}
		}
		for (Entry<LinkData, Integer> entry : hd._targets.entrySet()) {
			LinkData ld = entry.getKey();
			if (!linkingCluster.editPartDataList.contains(ld._ed)) {
//				System.out
//						.println("this ed " + GMFUtils.getDmoName(thisEd.ep.resolveSemanticElement()) + //$NON-NLS-1$
//								" has link to outside cluster " + //$NON-NLS-1$
//								GMFUtils.getDmoName(ld._ed.ep.resolveSemanticElement()));
				return false;
			}
		}
		return true;
	}

	private static void addToRow(EditPartData thisEd, List<EditPartData> poolList,
			LinkingCluster linkingCluster, int thisRow, List<List<EditPartData>> rows,
			int rowPosition, boolean fillPredominateLink, int predominateLinkType,
			int[] rowPositionToggle, List<EditPartData> appendFront, List<EditPartData> appendBack,
			boolean isSource) {

//		System.out.println("adding " + GMFUtils.getDmoName(thisEd.ep.resolveSemanticElement()) + //$NON-NLS-1$ 
//				" to row " + (isSource ? thisRow + 1 : thisRow - 1)); //$NON-NLS-1$ 

		poolList.remove(thisEd);
		linkingCluster.editPartDataList.add(thisEd);

		// part of the predominate cluster
		thisEd.isPredominate = fillPredominateLink;

		// determine which row based on whether this is a source or a target
		int rowInx = thisRow;
		// if attached with a secondary link, better to have source and target in same row
		if (fillPredominateLink && predominateLinkType == HOSTINGLINK || !thisEd.isAttached) {
			if (isSource) {
				rowInx++;
			} else {
				rowInx--;
			}
		}
		List<EditPartData> row = rows.get(rowInx);

		// determine which end of row to put ed based on postion of parent in its row
		if (rowPosition == EditPartData.MIDDLE) {
			rowPosition = rowPositionToggle[0];
			rowPositionToggle[0] = rowPosition == EditPartData.START ? EditPartData.END
					: EditPartData.START;
		}
		switch (rowPosition)
		{
		case EditPartData.START:
			thisEd.rowPosition = EditPartData.START;
			if (rowInx == thisRow) {
				appendFront.add(thisEd);
			} else {
				row.add(0, thisEd);
			}
			break;

		case EditPartData.END:
			thisEd.rowPosition = EditPartData.END;
			if (rowInx == thisRow) {
				appendBack.add(thisEd);
			} else {
				row.add(thisEd);
			}
			break;
		}
	}

	private static List<EditPartData> findLongestStrand(List<EditPartData> poolList,
			Map<GraphicalEditPart, LinkData> linkMap, int[] longestStrandType) {
		List<EditPartData> longestStrand = new ArrayList<EditPartData>();
		for (EditPartData ed : poolList) {
			LinkData hd = linkMap.get(ed.ep);
			// start a strand for each ed in the pool that has at least one source (not top of a strand)
			if (hd._sources.size() > 0) {
				// we don't start on just unit's w/o targets (at the bottom of a strand) since 
				//  a unit might be in a loop (a->b->c->a)
				List<EditPartData> currentStrand = new ArrayList<EditPartData>();
				currentStrand.add(ed);
				findLongestStrandHelper(hd._sources, currentStrand, -1, longestStrand,
						longestStrandType, poolList);
			}
		}
		return longestStrand;
	}

	private static void findLongestStrandHelper(Map<LinkData, Integer> sources,
			List<EditPartData> parentStrand, int parentStrandType, List<EditPartData> longestStrand,
			int[] longestStrandType, List<EditPartData> poolList) {

		for (Entry<LinkData, Integer> entry : sources.entrySet()) {
			LinkData sourceLd = entry.getKey();
			int thisStrandType = entry.getValue();

			// is this ed connected to its parent with the same type of link that connected the parent to its parent?
			// AND this unit isn't already in the strand (a loop  (a->b->c->a))
			List<EditPartData> currentStrand = parentStrand;
			if (sourceLd._ed != null && thisStrandType != UNKNOWNLINK
					&& thisStrandType != REALIZATIONLINK
					&& (parentStrandType == -1 || thisStrandType == parentStrandType)
					&& !parentStrand.contains(sourceLd._ed) && poolList.contains(sourceLd._ed)
					&& parentStrand.size() < 30) {
				parentStrandType = thisStrandType;

				// create a new strand composed of the parent strand and this source
				currentStrand = new ArrayList<EditPartData>(parentStrand);
				currentStrand.add(sourceLd._ed);

				// if this source has additional sources, we keep re-iterating down
				if (sourceLd._sources.size() > 0) {
					findLongestStrandHelper(sourceLd._sources, currentStrand, thisStrandType,
							longestStrand, longestStrandType, poolList);
					continue;
				}
			}

//			String cause = "due to "; //$NON-NLS-1$
//			if (sourceLd._ed == null) {
//				cause += "sourceLd._ed == null (" + GMFUtils.getDmoName(sourceLd._ep.resolveSemanticElement()) + "): "; //$NON-NLS-1$ //$NON-NLS-2$
//			}
//			if (parentStrandType != -1 && thisStrandType != parentStrandType) {
//				cause += "thisStrandType != parentStrandType: " + thisStrandType + parentStrandType; //$NON-NLS-1$					
//			}
//			if (parentStrand.contains(sourceLd._ep)) {
//				cause += "parentStrand.contains(sourceLd._ep): "; //$NON-NLS-1$					
//			}
//			if (sourceLd != null && sourceLd._sources.size() == 0) {
//				cause += "hd.otherSources.size()== 0: "; //$NON-NLS-1$					
//			}
//
//			for (EditPartData ed : currentStrand) {
//				cause += "'" + GMFUtils.getDmoName(ed.ep.resolveSemanticElement()) + "' "; //$NON-NLS-1$ //$NON-NLS-2$
//			}
//			System.out.println(cause);

			// if the current strand is longer then the longest strand, replace it
			// if there's a tie, we pick hosting links (this is  deployment tool)
			if (currentStrand.size() > longestStrand.size()
					|| currentStrand.size() == longestStrand.size() && parentStrandType == HOSTINGLINK) {
				longestStrand.clear();
				longestStrand.addAll(currentStrand);
				longestStrandType[0] = parentStrandType;
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// make linked & unlinked rows multiple rows to fit on screen
	private static void arrangeClusterRows(LinkingCluster unlinkedCluster,
			LinkingCluster linkedCluster, List<LinkingCluster> linkingClusterList, Point orgPt,
			int displayWidth, Map<GraphicalEditPart, LinkData> linkMap) {

		// sort unlinkedCluster cluster by import at the top
		Collections.sort(unlinkedCluster.getRows().get(0), new Comparator<EditPartData>() {
			public int compare(EditPartData e1, EditPartData e2) {
				boolean isE1 = e1.ep instanceof ImportTopologyEditPart;
				boolean isE2 = e2.ep instanceof ImportTopologyEditPart;
				if (isE1 && !isE2) {
					return -1;
				} else if (!isE1 && isE2) {
					return 1;
				}
				return 0;
			}
		});

		// if cluster too wide, move lower rows into upper rows
		unlinkedCluster.calcSize();
		linkedCluster.calcSize();
		unlinkedCluster.setClusterWidth(orgPt.x, displayWidth);
		linkedCluster.setClusterWidth(orgPt.x, displayWidth);
		unlinkedCluster.calcSize();
		linkedCluster.calcSize();

		// make sure each cluster is not bigger then displayWidth and calc size
		for (Iterator<LinkingCluster> it = linkingClusterList.iterator(); it.hasNext();) {
			LinkingCluster cluster = it.next();
			sortColumns(cluster, linkMap);
			cluster.calcSize();
			//			cluster.setClusterWidth(orgPt.x, displayWidth);
			//			cluster.calcSize();
		}
	}

	//sort columns
	private static void sortColumns(LinkingCluster cluster,
			final Map<GraphicalEditPart, LinkData> linkMap) {

		final List<List<EditPartData>> rows = cluster.rows;
		final int predominateLinkType = cluster.predominateLinkType;

		// first we put the strand that was originally in the middle back in the middle
		for (List<EditPartData> row : rows) {
			int rowSz = row.size();
			if (rowSz > 2) {
				EditPartData middleEd = null;
				for (EditPartData ed : row) {
					if (ed.rowPosition == EditPartData.MIDDLE) {
						middleEd = ed;
					}
				}
				if (middleEd != null) {
					row.remove(middleEd);
					row.add(rowSz / 2, middleEd);

//					System.out
//							.println("reinsert '" + GMFUtils.getDmoName(middleEd.ep.resolveSemanticElement()) + " at " + rowSz / 2); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}

		// then we try to line up units in one row with their target in the next row
		for (int thisRow = 1; thisRow < rows.size(); thisRow++) {
			List<EditPartData> row = rows.get(thisRow);
			final int lowerRow = thisRow - 1;
			Collections.sort(row, new Comparator<EditPartData>() {
				public int compare(EditPartData e1, EditPartData e2) {
					int targetIndex1 = findTarget(e1, lowerRow);
					int targetIndex2 = findTarget(e2, lowerRow);
					if (targetIndex1 < targetIndex2) {
						return -1;
					} else if (targetIndex1 > targetIndex2) {
						return 1;
					}
					return 0;
				}

				// find the index of the target in the lower row (if any)
				private int findTarget(EditPartData ed, int lowerRo) {
					LinkData ld = linkMap.get(ed.ep);
					List<EditPartData> lowerR = rows.get(lowerRo);
					if (ld != null) {
						for (Entry<LinkData, Integer> entry : ld._targets.entrySet()) {
							if (entry.getValue() == predominateLinkType || ld._targets.size() == 1) {
								int index = 0;
								LinkData targetLd = entry.getKey();
								for (EditPartData targetEd : lowerR) {
									if (targetLd._ed.equals(targetEd)) {
										return index;
									}
									index++;
								}

							}
						}
					}
					return lowerR.size();
				}
			});
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// sort clusters
	private static void sortClusters(List<LinkingCluster> hostingClusterList) {

		// sort general clusters by their size-- smallest at the top
		Collections.sort(hostingClusterList, new Comparator<LinkingCluster>() {
			public int compare(LinkingCluster c1, LinkingCluster c2) {
				Dimension d1 = c1.getSize();
				Dimension d2 = c2.getSize();
				int x1 = d1.width * d1.height;
				int x2 = d2.width * d2.height;
				if (x1 < x2) {
					return -1;
				} else if (x1 > x2) {
					return 1;
				}
				return 0;
			}
		});
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// move clusters into rows
	// unlinked cluster -- all units without any links to them
	// linked cluster -- big cluster with linked units that are not hosting links
	// linking clusters -- smaller clusters of hosting stacks 
	private static Rectangle moveClusters(Point orgPt, LinkingCluster unlinkedCluster,
			LinkingCluster linkedCluster, List<LinkingCluster> hostingClusterList,
			Map<View, Point> moveMap, List<GraphicalEditPart> editparts, int displayWidth, Map v2eMap,
			EditPartViewer viewer, DeployDiagramEditPart ddep, boolean useOperation,
			GraphicalEditPart topLeftPart, boolean isSelectionArrange, boolean isContainedArrange) {
		// loop through clusters building a moveMap
		Rectangle boundary = null;
		editparts.clear();
		int maxHeight = -1;

		// add the unlinked cluster to the top of the arrangement (we go in reverse order)
		Point pt = orgPt;
		if (!unlinkedCluster.isEmpty()) {
			pt = unlinkedCluster.addToMoveMap(orgPt, moveMap, editparts, false, false).getBottomLeft();
		}

		// if this is not an arrange all -- if only selected canvas units are being arranged
		//  we add the linked cluster now
		// in arrange all, we add the linked cluster after the first complete row of hosting clusters
		//  so that they can be closer to all hosting clusters
		boolean didLinkedCluster = isSelectionArrange || linkedCluster.isEmpty();
		if (isSelectionArrange && !linkedCluster.isEmpty()) {
			Rectangle bounds = linkedCluster.addToMoveMap(pt, moveMap, editparts, false, true);
			pt = bounds.getBottomLeft();
			if (boundary == null) {
				boundary = bounds;
			} else {
				boundary = boundary.union(bounds);
			}
		}

		// now we add the hosting clusters
		for (Iterator<LinkingCluster> it = hostingClusterList.iterator(); it.hasNext();) {
			LinkingCluster hostingCluster = it.next();
			if (hostingCluster.isEmpty()) {
				continue;
			}
			if (pt.x + hostingCluster.getSize().width > displayWidth) {
				// adding the linked cluster after the first complete row of hosting clusters
				if (!didLinkedCluster) {
					didLinkedCluster = true;
					pt.x = orgPt.x;
					pt.y += maxHeight;
					Rectangle bounds = linkedCluster.addToMoveMap(pt, moveMap, editparts, false, true);
					if (boundary == null) {
						boundary = bounds;
					} else {
						boundary = boundary.union(bounds);
					}
					maxHeight = bounds.height;
				}
				pt.x = orgPt.x;
				pt.y += maxHeight;
				maxHeight = -1;
			}
			Rectangle bounds = hostingCluster.addToMoveMap(pt, moveMap, editparts, true, true);
			if (bounds.height > maxHeight) {
				maxHeight = bounds.height;
			}
			pt = bounds.getTopRight();
			if (boundary == null) {
				boundary = bounds;
			} else {
				boundary = boundary.union(bounds);
			}
		}
		// if we never did get a chance to add the linked cluster (not enough hosting clusters), add it now
		if (!didLinkedCluster) {
			didLinkedCluster = true;
			pt.x = orgPt.x;
			pt.y += maxHeight;
			Rectangle bounds = linkedCluster.addToMoveMap(pt, moveMap, editparts, false, true);
			if (boundary == null) {
				boundary = bounds;
			} else {
				boundary = boundary.union(bounds);
			}
		}

		// refresh attachments of moved views
		if (!isContainedArrange) {
			arrangeSnappedGroups(moveMap, unlinkedCluster, hostingClusterList, isSelectionArrange,
					viewer, ddep, topLeftPart, useOperation);
		}

		return boundary;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////// rearrange attachments //////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	private static IStatus arrangeSnappedGroups(final Map<View, Point> moveMap,
			final LinkingCluster unlinkedCluster, final List<LinkingCluster> hostingClusterList,
			final boolean isSelectionArrange, final EditPartViewer viewer,
			final DeployDiagramEditPart ddep, final GraphicalEditPart topLeftPart, boolean useOperation) {
		if (useOperation) {
			Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			AbstractEMFOperation operation = new DeployTransactionalCommand(ddep, StringStatics.BLANK,
					options, true) {
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
					realignSnappedGroupsHelper(moveMap.keySet(), unlinkedCluster, hostingClusterList,
							viewer, isSelectionArrange, topLeftPart, ddep);
					return null;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
			}
		} else {
			realignSnappedGroupsHelper(moveMap.keySet(), unlinkedCluster, hostingClusterList, viewer,
					isSelectionArrange, topLeftPart, ddep);
		}
		return Status.OK_STATUS;
	}

	protected static void realignSnappedGroupsHelper(Set<View> viewSet,
			LinkingCluster unlinkedCluster, List<LinkingCluster> hostingClusterList,
			EditPartViewer viewer, boolean isSelectionArrange, GraphicalEditPart topLeftPart,
			DeployDiagramEditPart ddep) {

		// detach all views that are being arranged
		// remember views which are not being arranged but which are attached so that their attachment lists can be refreshed
		// delete all current snap groups
		Set<View> snappedViewSet = new HashSet<View>();
		for (View view : viewSet) {
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				if (!snappedViewSet.contains(view)) {
					if (style != null && style.getSnapParent() != null
							&& style.getSnapParent().eContainer() != null) {
						snappedViewSet.addAll(ViewUtil.getAllSnapGroupViews(view));
						org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy((View) style
								.getSnapParent().eContainer());
					}
				}
				style.setSnapParent(null);
			}
		}
		if (snappedViewSet.isEmpty()) {
			return;
		}

		// for each linking cluster
		View snapGroup = null;
		for (LinkingCluster cluster : hostingClusterList) {
			// loop through cluster rows, bottom to top, attaching the centers to each other

			// first we get the indexes of the center views of this cluster
			List<Integer> centerInxList = new ArrayList<Integer>();
			for (List<EditPartData> row : cluster.rows) {
				int colInx = 0;
				int centerInx = row.size() / 2;
				for (EditPartData ed : row) {
					if (ed.rowPosition == EditPartData.MIDDLE) {
						centerInx = colInx;
						break;
					}
					colInx++;
				}
				centerInxList.add(centerInx);
			}

			// create a new snap group for this cluster
			// when an arrange selection, all snapped units in one snap group
			if (snapGroup == null || !isSelectionArrange) {
				snapGroup = ViewService.getInstance().createView(Node.class, null,
						ddep.getNotationView(), DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1, true,
						ddep.getDiagramPreferencesHint());
			}

			// try to add center views to new snap group
			int rowInx = 0;
			boolean firstRowAdded = false;
			List<View> snapRowList = new ArrayList<View>();
			for (List<EditPartData> row : cluster.rows) {
				if (rowInx + 1 < cluster.rows.size()) {
					View view = row.get(centerInxList.get(rowInx)).view;
					List<EditPartData> nextRow = cluster.rows.get(rowInx + 1);
					View nextView = nextRow.get(centerInxList.get(rowInx + 1)).view;
					// we only attach if they have been attached before
					if (snappedViewSet.contains(view) && snappedViewSet.contains(nextView)) {
						// if first row not added add now
						if (!firstRowAdded) {
							firstRowAdded = true;
							DeployStyle style = (DeployStyle) view
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							View snapRow = ViewService.getInstance().createView(Node.class, null,
									snapGroup, DeployCoreConstants.SNAPROW_SEMANTICHINT, 0, true,
									ddep.getDiagramPreferencesHint());
							snapRowList.add(snapRow);
							DeployStyle snapRowStyle = (DeployStyle) snapRow
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							snapRowStyle.getSnapChildren().add(view);
							style.setSnapParent(snapRow);
						}
						// add next row to group
						DeployStyle style = (DeployStyle) nextView
								.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
						View snapRow = ViewService.getInstance().createView(Node.class, null, snapGroup,
								DeployCoreConstants.SNAPROW_SEMANTICHINT, 0, true,
								ddep.getDiagramPreferencesHint());
						snapRowList.add(snapRow);
						DeployStyle snapRowStyle = (DeployStyle) snapRow
								.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
						snapRowStyle.getSnapChildren().add(nextView);
						style.setSnapParent(snapRow);
						rowInx++;
					} else {
						break;
					}
				}
			}

			// no center views to snap therefore no snap group for this cluster
			if (snapGroup.getChildren().isEmpty() && !isSelectionArrange) {
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.destroy(snapGroup);
				continue;
			}

			// else for each row add attachments to left and right of center column
			rowInx = 0;
			int snapRowInx = 0;
			for (List<EditPartData> row : cluster.rows) {
				int centerInx = centerInxList.get(rowInx++);
				View snapRow = snapRowList.get(snapRowInx++);
				DeployStyle snapRowStyle = (DeployStyle) snapRow
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				for (int colInx = centerInx; colInx + 1 < row.size(); colInx++) {
					View view = row.get(colInx).view;
					View rightView = row.get(colInx + 1).view;
					if (snappedViewSet.contains(view) && snappedViewSet.contains(rightView)) {
						snapRowStyle.getSnapChildren().add(rightView);
						DeployStyle style = (DeployStyle) rightView
								.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
						style.setSnapParent(snapRow);
					}
				}
			}

			// loop from center to left attaching views
			rowInx = 0;
			snapRowInx = 0;
			for (List<EditPartData> row : cluster.rows) {
				int centerInx = centerInxList.get(rowInx++);
				View snapRow = snapRowList.get(snapRowInx++);
				DeployStyle snapRowStyle = (DeployStyle) snapRow
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				for (int colInx = centerInx; colInx > 0; colInx--) {
					View view = row.get(colInx - 1).view;
					View rightView = row.get(colInx).view;
					if (snappedViewSet.contains(view) && snappedViewSet.contains(rightView)) {
						snapRowStyle.getSnapChildren().add(0, view);
						DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
								.getDeployStyle());
						style.setSnapParent(snapRow);
					}
				}
			}
			if (!isSelectionArrange) {
				// realign this cluster on the center view
				ArrangeSnappedViewsCommand.arrangeSnappedViews(snapGroup, viewer,
						SnapUtils.ANCHOR_GROUP, null);
			}
		}

		// if selection arrange we add the unlinked cluster to the snap group
		if (isSelectionArrange) {
			for (List<EditPartData> row : unlinkedCluster.rows) {
				if (row.size() > 0) {
					if (snapGroup == null) {
						snapGroup = ViewService.getInstance().createView(Node.class, null,
								ddep.getNotationView(), DeployCoreConstants.SNAPGROUP_SEMANTICHINT, -1,
								true, ddep.getDiagramPreferencesHint());
					}
					View snapRow = ViewService.getInstance().createView(Node.class, null, snapGroup,
							DeployCoreConstants.SNAPROW_SEMANTICHINT, 0, true,
							ddep.getDiagramPreferencesHint());
					DeployStyle snapRowStyle = (DeployStyle) snapRow
							.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
					for (int colInx = 0; colInx < row.size(); colInx++) {
						View view = row.get(colInx).view;
						if (snappedViewSet.contains(view)) {
							snapRowStyle.getSnapChildren().add(view);
							DeployStyle style = (DeployStyle) view
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							style.setSnapParent(snapRow);
						}
					}
				}
			}

			// realign this cluster on the center view
			ArrangeSnappedViewsCommand.arrangeSnappedViews(topLeftPart.getNotationView(), viewer, 0,
					null);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static GraphicalEditPart getTopLeftEditPart(List<GraphicalEditPart> editparts) {
		List<Entry<Rectangle, GraphicalEditPart>> list = new ArrayList<Entry<Rectangle, GraphicalEditPart>>(
				editparts.size());
		Map<Rectangle, GraphicalEditPart> map = new HashMap<Rectangle, GraphicalEditPart>();
		for (Iterator<GraphicalEditPart> it = editparts.iterator(); it.hasNext();) {
			GraphicalEditPart ep = it.next();
			map.put(ep.getFigure().getBounds(), ep);
		}
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Rectangle, GraphicalEditPart>>() {
			public int compare(Entry<Rectangle, GraphicalEditPart> e1,
					Entry<Rectangle, GraphicalEditPart> e2) {
				return GMFUtils.compareRectangles(e1.getKey(), e2.getKey());
			}
		});
		return list.get(0).getValue();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   HELPER DATA CLASSES        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// maintain info on a collection of editparts that are hosted on each other 
	private class LinkingCluster {
		// rows are lists of EditPartData lists
		List<List<EditPartData>> rows = new ArrayList<List<EditPartData>>();
		// keep track of all editpartdata in this cluster
		List<EditPartData> editPartDataList = new ArrayList<EditPartData>();
		// row widths
		Map<List<EditPartData>, Integer> rowWidthMap = new HashMap<List<EditPartData>, Integer>();
		// size of this cluster including spacing
		Dimension size = null;
		// predominate link type in this cluster
		int predominateLinkType = 0;

		// init collections and add bottom host to first row
		LinkingCluster(GraphicalEditPart rootEP, int predominateLinkType, Map v2eMap) {
			List<EditPartData> rootRow = new ArrayList<EditPartData>();
			if (rootEP != null) {
				EditPartData ed = new EditPartData(rootEP, v2eMap);
				rootRow.add(ed);
				editPartDataList.add(ed);
			}
			rows.add(rootRow);
			this.predominateLinkType = predominateLinkType;
		}

		/**
		 * @return if this cluster is empty
		 */
		public boolean isEmpty() {
			return size == null || size.isEmpty();
		}

		/**
		 * set size of this cluster-- only calculated once
		 * 
		 * @return size of cluster
		 */
		public Dimension calcSize() {
			size = new Dimension();
			int y = 0;
			int x = 0;
			int maxWidth = -1;
			for (Iterator<List<EditPartData>> itRow = rows.iterator(); itRow.hasNext();) {
				int maxHeight = -1;
				List<EditPartData> row = itRow.next();
				for (Iterator<EditPartData> itCol = row.iterator(); itCol.hasNext();) {
					Dimension siz = itCol.next().size;
					x += siz.width;
					if (x > maxWidth) {
						maxWidth = x;
					}
					if (siz.height > maxHeight) {
						maxHeight = siz.height;
					}
				}
				rowWidthMap.put(row, new Integer(x));
				x = 0;
				y += maxHeight;
				maxHeight = -1;
			}
			size.width = maxWidth;
			size.height = y;
			return size;
		}

		/**
		 * @param inx
		 * @return width of this row
		 */
		public int getRowWidth(int inx) {
			List<EditPartData> row = rows.get(inx);
			return rowWidthMap.get(row).intValue();
		}

		/**
		 * @param pt
		 * @param moveMap
		 * @param editparts
		 * @param reverseOrder
		 * @param center
		 * @return boundary of added cluster
		 */
		public Rectangle addToMoveMap(Point pt, Map<View, Point> moveMap,
				List<GraphicalEditPart> editparts, boolean reverseOrder, boolean center) {
			int x = pt.x;
			int y = pt.y;

			List<List<EditPartData>> rowz = new ArrayList<List<EditPartData>>(rows.size());
			if (reverseOrder) {
				for (int inx = rows.size() - 1; inx >= 0; inx--) {
					rowz.add(rows.get(inx));
				}
			} else {
				rowz.addAll(rows);
			}
			for (Iterator<List<EditPartData>> it = rowz.iterator(); it.hasNext();) {
				List<EditPartData> row = it.next();
				// if multiple rows, center this row in cluster
				if (center && rows.size() > 1) {
					int clusterWidth = size.width;
					int rowWidth = rowWidthMap.get(row).intValue();
					x += (clusterWidth - rowWidth) / 2;
				}
				int maxHeight = -1;
				for (Iterator<EditPartData> itCol = row.iterator(); itCol.hasNext();) {
					EditPartData epData = itCol.next();
					moveMap.put(epData.view, new Point(x, y));
					editparts.add(epData.ep);
					x += epData.size.width;
					if (epData.size.height > maxHeight) {
						maxHeight = epData.size.height;
					}
				}
				x = pt.x;
				y += maxHeight;
				maxHeight = -1;
			}
			// return bounds
			return new Rectangle(pt, size);
		}

		/**
		 * @param row
		 * @param ep
		 * @param v2eMap
		 * @return EditPartData created
		 */
		public EditPartData addToRow(int row, GraphicalEditPart ep, Map v2eMap) {
			if (row >= rows.size()) {
				rows.add(new ArrayList<EditPartData>());
			}
			EditPartData epd = new EditPartData(ep, v2eMap);
			rows.get(row).add(epd);
			editPartDataList.add(epd);
			return epd;
		}

		/**
		 * @param row
		 * @param ed
		 * @param fromCluster
		 * @param v2eMap
		 */
		public void addToRow(int row, EditPartData ed, LinkingCluster fromCluster, Map v2eMap) {
			if (row >= rows.size()) {
				rows.add(new ArrayList<EditPartData>());
			}
			rows.get(row).add(ed);
			editPartDataList.add(ed);
			if (fromCluster != null) {
				fromCluster.editPartDataList.remove(ed);
			}
		}

		/**
		 * @param xOrg
		 * @param maxWidth
		 */
		public void setClusterWidth(int xOrg, int maxWidth) {
			int x = xOrg;
			int cnt = 0;
			do {
				cnt = rows.size();
				for (int i = 0; i < cnt; i++) {
					List<EditPartData> row = rows.get(i);

					// determine what should be moved from this row due to size
					// but if first item, it has to be on this row
					boolean firstColumn = true;
					List<EditPartData> moveList = new ArrayList<EditPartData>();
					for (Iterator<EditPartData> itCol = row.iterator(); itCol.hasNext();) {
						EditPartData epd = itCol.next();
						int width = epd.size.width;
						if (x + width > maxWidth && !firstColumn) {
							moveList.add(epd);
						} else {
							x += width;
						}
						firstColumn = false;
					}
					// setup for next row
					rowWidthMap.put(row, new Integer(x - xOrg));
					x = xOrg;

					// move those items into next row
					if (moveList.size() > 0) {
						// if nothing at top, add another row
						if (i + 1 >= rows.size()) {
							rows.add(new ArrayList<EditPartData>());
						}
						List<EditPartData> nextRow = rows.get(i + 1);
						nextRow.addAll(moveList);
						row.removeAll(moveList);
					}
				}
				// repeat if new rows were added
			} while (cnt < rows.size());
		}

		/**
		 * @return rows
		 */
		public List<List<EditPartData>> getRows() {
			return rows;
		}

		public Dimension getSize() {
			return size;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// maintain info on the size of each editpart 
	// size is actually padded size
	private class EditPartData {
		final GraphicalEditPart ep;
		final View view;
		final Dimension size;
		final boolean isAttached;

		// used to mark an ed whose source/targets have already been added to the stack
		static final int UNPROCESSED = 1;
		static final int PRIMARYPROCESSED = 2;
		static final int PROCESSED = 3;
		int processedState = UNPROCESSED;

		// when creating a stack, where should new source/target ed's be placed in the 
		// row above/below the current row-- helps to disperse the units around the center
		static final int START = 1;
		static final int MIDDLE = 2;
		static final int END = 3;
		int rowPosition = MIDDLE;

		// are we linked to the cluster by a predominate link?
		boolean isPredominate = false;

		EditPartData(GraphicalEditPart ep, Map v2eMap) {
			this.ep = ep;
			view = ep.getNotationView();
			size = LayoutUtils.getFigureBounds(view, v2eMap).getSize().expand(NEWUNIT_HSPACER,
					NEWUNIT_VSPACER);
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			isAttached = style != null && style.getSnapParent() != null;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static Map<GraphicalEditPart, LinkData> createLinkMap(
			List<GraphicalEditPart> topEditParts, EditPart commonContainer, Map f2eMap) {
		// first we initialize map with EditPartData for every top editpart we will be arranging
		Map<GraphicalEditPart, LinkData> linkMap = new HashMap<GraphicalEditPart, LinkData>();
		for (GraphicalEditPart ep : topEditParts) {
			linkMap.put(ep, new ArrangeUtils().new LinkData(ep));
		}

		// next we add links to each EditPartData
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			DeployConnectionLayerEx layer = editor.getConnectionLayer();

			// for all links in the canvas, fill in the sources and targets of the LinkData's in the linkMap
			for (Iterator<?> it = layer.getChildren().iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof DeployLinkConnection) {
					DeployLinkConnection link = (DeployLinkConnection) o;
					if (link.isVisible()) {
						Object l = f2eMap.get(link);
						if (l instanceof DeployConnectionNodeEditPart) {
							DeployConnectionNodeEditPart linkEP = (DeployConnectionNodeEditPart) l;
							GraphicalEditPart topSrcEP = GMFUtils.getTopContainedEditPart(linkEP
									.getSource(), commonContainer);
							GraphicalEditPart topTgtEP = GMFUtils.getTopContainedEditPart(linkEP
									.getTarget(), commonContainer);
							if (topSrcEP != topTgtEP) {
								LinkData srcLinkData = linkMap.get(topSrcEP);
								LinkData tgtLinkData = linkMap.get(topTgtEP);
								if (srcLinkData != null && tgtLinkData != null) {
									int st = getLinkType(linkEP);
									srcLinkData._targets.put(tgtLinkData, st);
									tgtLinkData._sources.put(srcLinkData, st);
								}
							}
						}
					}
				}
			}

		}
		return linkMap;
	}

	private class LinkData {
		GraphicalEditPart _ep;
		EditPartData _ed = null;
		Map<LinkData, Integer> _sources = new HashMap<LinkData, Integer>();
		Map<LinkData, Integer> _targets = new HashMap<LinkData, Integer>();

		LinkData(GraphicalEditPart ep) {
			_ep = ep;
		}
	}

	private static int getLinkType(DeployConnectionNodeEditPart link) {
		if (link instanceof ConsolidationLinkEditPart) {
			ConsolidationLinkEditPart clink = (ConsolidationLinkEditPart) link;
			int type = 0;
			for (DeployConnectionNodeEditPart l : clink.getConsolidatedLinkList()) {
				int t = getLinkTypeHelper(l);
				if (type == 0) {
					type = t;
				} else if (type != t) {
					return 0;
				}
			}
			return type;
		}
		return getLinkTypeHelper(link);
	}

	private static int getLinkTypeHelper(DeployConnectionNodeEditPart link) {
		EObject eo = link.resolveSemanticElement();
		if (eo instanceof HostingLink) {
			return HOSTINGLINK;
		} else if (eo instanceof DependencyLink) {
			return DEPENDENCYLINK;
		} else if (eo instanceof RealizationLink) {
			return REALIZATIONLINK;
		} else if (eo instanceof ConstraintLink) {
			ConstraintLink clink = (ConstraintLink) eo;
			if (clink.getConstraints().size() != 1) {
				return CONSTRAINTLINK;
			}
			if (clink.getConstraints().get(0) instanceof DeferredHostingConstraint) {
				return HOSTINGLINK;
			}
			if (clink.getConstraints().get(0) instanceof CollocationConstraint) {
				CollocationConstraint cc = (CollocationConstraint) clink.getConstraints().get(0);
				if (cc.getType() == CollocationConstraintTypes.ANTICOLLOCATION_LITERAL) {
					return ANTICOLLATIONLINK;
				} else if (cc.getType() == CollocationConstraintTypes.COLLOCATION_LITERAL) {
					return COLLATIONLINK;
				}
			} else {
				return CONSTRAINTLINK;
			}
		}
		return UNKNOWNLINK;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   GRID LAYOUTS FOR SHAPES VIEWS        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param cmd
	 * @param request
	 * @param host
	 * @return command to layout figures
	 */
	public static Command gridLayout(Command cmd, CreateRequest request, EditPart host) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) host).getEditingDomain();
		return cmd.chain(new ICommandProxy(new DeployDeferredLayoutCommand(editingDomain,
				((CreateViewRequest) request).getViewDescriptors(), (IGraphicalEditPart) host, host,
				null, false, true)));
	}
}
