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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.notation.Edge;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployLinkCanonicalConnectorEditPolicy;

/**
 * @author jswanke
 * 
 */
public class FilteringUtils {

	/**
	 * filter out secondary duplicate links, the primary link being between the topmost two source
	 * and target
	 * 
	 * @param potentialList --
	 *           potential list, is returned filtered
	 * @param policy --
	 *           a canonical edit policy to delete any existing edge if it's not a primary edge
	 */
	public static void filterDupLinks(List<FilterLinkData> potentialList,
			DeployLinkCanonicalConnectorEditPolicy policy) {

		// look for primary links (connected to top most editparts)
		int srcLvl = 0, tgtLvl = 0;
		FilterLinkData primary = null;
		Set<FilterLinkData> primaryList = new HashSet<FilterLinkData>();
		Set<FilterLinkData> sameLevelList = new HashSet<FilterLinkData>();
		for (Iterator<FilterLinkData> it = potentialList.iterator(); it.hasNext();) {
			FilterLinkData data = it.next();
			int __srcLvl = getEditpartLevel(data.getSource());
			int __tgtLvl = getEditpartLevel(data.getTarget());
			if (primary == null) {
				// init primary link
				primary = data;
				primaryList.add(data);
				srcLvl = __srcLvl;
				tgtLvl = __tgtLvl;
			} else if (__srcLvl == srcLvl && __tgtLvl == tgtLvl) {
				// if at same level as the primary link, this is a dup primary link
				primaryList.add(data);
			} else if (__srcLvl <= srcLvl && __tgtLvl <= tgtLvl) {
				// if either end is lower, we have a new primary link
				primary = data;
				primaryList.clear();
				primaryList.add(data);
				srcLvl = __srcLvl;
				tgtLvl = __tgtLvl;
			}
			// also allow links between units in the same container
			if (data.getSource().getParent() == data.getTarget().getParent()) {
				sameLevelList.add(data);
			}

		}

		// add back any connections within the same level
		primaryList.addAll(sameLevelList);

		// if there still multiple primary links, filter out any to import/diagram targets
		if (primaryList.size() > 1) {
			Set<FilterLinkData> externalList = new HashSet<FilterLinkData>();
			for (FilterLinkData data : primaryList) {
				if (GMFUtils.isImportTopology(data.getSource())
						|| GMFUtils.isDiagramNode(data.getSource())
						|| GMFUtils.isImportTopology(data.getTarget())
						|| GMFUtils.isDiagramNode(data.getTarget())) {
					externalList.add(data);
				}
			}
			if (externalList.size() != 0 && externalList.size() != primaryList.size()) {
				primaryList.removeAll(externalList);
			}
		}

		// if there's a primary link, remove the rest from the list
		if (primary != null) {
			// delete any existing edges that aren't the primary link
			if (policy != null) {
				// create a list
				List<Edge> removeList = new ArrayList<Edge>();
				for (Iterator<FilterLinkData> it = potentialList.iterator(); it.hasNext();) {
					FilterLinkData data = it.next();
					if (!primaryList.contains(data) && data.hasExistingEdge()) {
						removeList.add(data.getExistingEdge());
					}
				}

				// and delete	
				policy.deleteEdges(removeList.iterator());
			}

			// set up list for return
			potentialList.clear();
			potentialList.addAll(primaryList);
		}
	}

	private static int getEditpartLevel(GraphicalEditPart ep) {
		int lvl = 0;
		EditPart walker = ep;
		while (walker != null) {
			// GMF group view containers don't count 
			if (!(walker instanceof GroupEditPart)) {
				lvl++;
			}
			walker = walker.getParent();
		}
		return lvl;
	}

}
