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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @author jswanke
 * 
 * View positions are saved in PositionState. PositionStates are store in a list based on what
 * compartments were collapsed when the state was saved. THis list of collpased compartments is
 * therefore the keyMap which is used to retrieve a PositionState
 * 
 */
public class LayoutStates {

	private static int MOVE_THRESHHOLD = MapModeUtil.getMapMode().DPtoLP(20);

	/**
	 * @author jswanke
	 * 
	 * keyMap -- what compartments are collpased in this saved state (each entry is
	 * collpasedFigure:null) layoutMap -- all of the view positions in for this key (each entry is
	 * view:rect)
	 */
	public class LayoutState {
		Map<View, Object> keyMap;
		Map<View, Rectangle> layoutMap;

		/**
		 * @param keyMap
		 */
		public LayoutState(Map<View, Object> keyMap) {
			super();
			this.keyMap = new HashMap<View, Object>();
			this.keyMap.putAll(keyMap);
			layoutMap = new HashMap<View, Rectangle>();
		}

		/**
		 * @return keyMap
		 */
		public Map<View, Object> getKeyMap() {
			return keyMap;
		}

		/**
		 * @return positions
		 */
		public Map<View, Rectangle> getLayoutMap() {
			return layoutMap;
		}
	}

	/**
	 * save all view positions for this keyMap
	 * 
	 * @param ddep
	 * @param keyMap --
	 *           what key to save the current view positions under
	 * @param overrideView --
	 *           a view whose current size should be ignored
	 * @param overrideSize --
	 *           the size that should be used instead for overrideView
	 */
	public static void saveState(DeployDiagramEditPart ddep, Map<View, Object> keyMap,
			View overrideView, Dimension overrideSize) {
		// get current layout state for this configuration of collapsed compartments
		LayoutState state = getLayoutState(ddep, keyMap);
		if (state == null) {
			state = new LayoutStates().new LayoutState(keyMap);
			ddep.getLayoutStateList().add(state);
		}

		// get all movable views
		Diagram diagram = (Diagram) ddep.getNotationView();
		state.getLayoutMap().clear();
		saveStateHelper(DiagramUtils.getAllChildViewsIncludingGroup(diagram), state.getLayoutMap(),
				keyMap, overrideView, overrideSize);
	}

	private static void saveStateHelper(List<View> children, Map<View, Rectangle> movableViewsMap,
			Map keyMap, View overrideView, Dimension overrideSize) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			Object v = it.next();
			if (v instanceof View) {
				View view = (View) v;

				if (!LayoutUtils.isCompartmentView(view)) {
					Rectangle rect = LayoutUtils.getViewBounds(view);
					if (!(rect.x == 0 && rect.y == 0 && rect.width == -1 && rect.height == -1)) {
						if (view == overrideView) {
							rect.setSize(overrideSize);
						}
						if (keyMap.containsKey(view)) {
							rect.setSize(-1, -1);
						}
						movableViewsMap.put(view, rect);
					}
				}

				// if this isn't a tree compartment, we know there's nothing movable below
				if (!LayoutUtils.isTreeCompartmentView(view)) {
					saveStateHelper(view.getChildren(), movableViewsMap, keyMap, overrideView,
							overrideSize);
				}
			}
		}
	}

	/**
	 * restore all view positions for this keyMap
	 * 
	 * @param ddep
	 * @param keyMap --
	 *           what key to restore the layout positions of
	 * @param v2eMap
	 * @return return whther a state has been restored
	 */
	public static boolean restoreState(DeployDiagramEditPart ddep, Map<View, Object> keyMap,
			Map v2eMap) {
		// get current layout state for this configuration of collapsed compartments
		LayoutState state = getLayoutState(ddep, keyMap);
		if (state == null) {
			return false;
		}

		// restore states
		LayoutUtils
				.setViewsBounds(ddep.getEditingDomain(), state.getLayoutMap(), v2eMap, false, true);
		return true;
	}

	/**
	 * make sure keyMaps in saved PositionStates are updated when a figure is deleted/added to canvas
	 * 
	 * @param ddep
	 * @param addNewKeys --
	 *           view compartments that if new, should be added to newKeys
	 * @param removeNewKeys --
	 *           view compartments that if new, should be removed from newkeys
	 * @param location
	 * @param layoutMode
	 * @param view
	 * @return a keyMap for the current canvas
	 */
	public static Map<View, Object> refreshStates(DeployDiagramEditPart ddep,
			Map<View, Object> addNewKeys, Map<View, Object> removeNewKeys) {
		// get a map of all the compartments in the canvas
		Map<View, Object> newMap = getCurrentCompartmentViews(ddep);

		// create a new and old key list to update the current layout states with
		Map<View, Object> oldMap = ddep.getLastCompartmentViewMap();
		if (oldMap != null) {
			// find new compartment views
			Map<View, Object> newKeys = new HashMap<View, Object>();
			for (Iterator it = newMap.keySet().iterator(); it.hasNext();) {
				View v = (View) it.next();
				if (!oldMap.containsKey(v)) {
					newKeys.put(v, null);
				}
			}
			// clean up keys
			// use only new collapsed keys
			// add other new keys to map or remove--but only if they are new
			boolean isAddNewKeys = containsKeys(newKeys, addNewKeys);
			newKeys = getCollapsedViews(newKeys);
			if (isAddNewKeys) {
				newKeys.putAll(addNewKeys);
			}
			removeAll(newKeys, removeNewKeys);

			// find deleted compartment views
			Map<View, Object> delKeys = new HashMap<View, Object>();
			for (Iterator it = oldMap.keySet().iterator(); it.hasNext();) {
				View v = (View) it.next();
				if (!newMap.containsKey(v)) {
					delKeys.put(v, null);
				}
			}

			// if there's a change, now update all the saved keyMaps with these changes
			if (newKeys.size() > 0 || delKeys.size() > 0) {
				List stateList = ddep.getLayoutStateList();
				for (Iterator it = stateList.iterator(); it.hasNext();) {
					LayoutState state = (LayoutState) it.next();
					// add new collapsed compartments to each keyMap
					// remove missing collapsed compartments to each keyMap
					state.getKeyMap().putAll(newKeys);
					removeAll(state.getKeyMap(), delKeys);
				}
			}
		}
		ddep.setLastCompartmentViewMap(newMap);

		// return a Map of just the collpased views
		return getCollapsedViews(newMap);
	}

	/**
	 * @param ddep
	 * @param view
	 * @param oldLocation
	 * @param newLocation
	 */
	public static void refreshStates(DeployDiagramEditPart ddep, View view, Point oldLocation,
			Point newLocation) {
		if (Math.abs(oldLocation.x - newLocation.x) > MOVE_THRESHHOLD
				|| Math.abs(oldLocation.y - newLocation.y) > MOVE_THRESHHOLD) {
			List stateList = ddep.getLayoutStateList();
			Set<View> viewSet = new HashSet<View>();
			viewSet.add(view);
			viewSet.addAll(ViewUtil.getAllSnapGroupViews(view));
			for (Iterator it = stateList.iterator(); it.hasNext();) {
				LayoutState state = (LayoutState) it.next();
				for (View v : viewSet) {
					state.getLayoutMap().remove(v);
				}
			}
		}
	}

	/*
	 * get all compartment views in the canvas
	 */
	private static Map<View, Object> getCurrentCompartmentViews(DeployDiagramEditPart ddep) {
		Diagram diagram = (Diagram) ddep.getNotationView();
		Map<View, Object> compartmentViewsMap = new HashMap<View, Object>();
		getCurrentCompartmentViewsHelper(DiagramUtils.getAllChildViewsIncludingGroup(diagram),
				compartmentViewsMap);
		return compartmentViewsMap;
	}

	private static void getCurrentCompartmentViewsHelper(List<View> children,
			Map<View, Object> compartmentViewsMap) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			Object v = it.next();
			if (v instanceof View) {
				View view = (View) v;
				if (LayoutUtils.isCompartmentView(view)) {
					compartmentViewsMap.put(view, null);
				}

				// if this isn't a tree view, dig deeper
				if (!LayoutUtils.isTreeCompartmentView(view)) {
					getCurrentCompartmentViewsHelper(view.getChildren(), compartmentViewsMap);
				}
			}
		}
	}

	/*
	 * given a map of compartment figures, return just the collpased figures
	 */
	private static Map<View, Object> getCollapsedViews(Map compartmentViewsMap) {
		Map<View, Object> collapsedViewsMap = new HashMap<View, Object>();
		for (Iterator it = compartmentViewsMap.keySet().iterator(); it.hasNext();) {
			View view = (View) it.next();
			if (((Boolean) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
							.getDrawerStyle_Collapsed())).booleanValue()) {
				collapsedViewsMap.put(view, null);
			}
		}
		return collapsedViewsMap;
	}

	/**
	 * gets the top compartments in this view
	 * 
	 * @param view
	 * @return top compartments
	 */
	public static Map<View, Object> getCompartmentViews(View view) {
		Map<View, Object> map = new HashMap<View, Object>();
		getCompartmentViewsHelper(view.getChildren(), map);
		return map;
	}

	private static void getCompartmentViewsHelper(EList children, Map<View, Object> map) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			Object v = it.next();
			if (v instanceof View) {
				View view = (View) v;
				if (LayoutUtils.isCompartmentView(view)) {
					map.put(view, null);
				} else {
					getCompartmentViewsHelper(view.getChildren(), map);
				}
			}
		}
	}

	/**
	 * removes the keys in one map from another
	 * 
	 * @param mapKey
	 * @param viewKey
	 */
	public static void removeAll(Map mapKey, Map viewKey) {
		if (viewKey == null) {
			return;
		}
		for (Iterator it = viewKey.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			if (mapKey.containsKey(key)) {
				mapKey.remove(key);
			}
		}
	}

	/**
	 * @param container
	 * @param keys
	 * @return true if they are contained
	 */
	public static boolean containsKeys(Map container, Map keys) {
		if (keys == null) {
			return false;
		}
		boolean isContainsKeys = true;
		for (Iterator it = container.keySet().iterator(); it.hasNext() && isContainsKeys;) {
			isContainsKeys = keys.containsKey(it.next());
		}
		return isContainsKeys;
	}

	/*
	 * get a PositionState from list based on a keyMap
	 */
	private static LayoutState getLayoutState(DeployDiagramEditPart ddep, Map<View, Object> keyMap) {
		// strip keyMap of keys that don't affect the layout (invisible keys)
		Map filteredKeyMap = filterInvisibleKeys(keyMap);
		// now search states for a matching key
		List stateList = ddep.getLayoutStateList();
		for (Iterator it = stateList.iterator(); it.hasNext();) {
			LayoutState state = (LayoutState) it.next();

			// also filter each keyMap in states of invisible keys
			Map filteredKeyTest = filterInvisibleKeys(state.getKeyMap());

			// simple test: not the same size
			if (filteredKeyMap.size() != filteredKeyTest.size()) {
				continue;
			}

			// else check every key
			boolean isMatch = true;
			for (Iterator it2 = filteredKeyTest.keySet().iterator(); it2.hasNext() && isMatch;) {
				isMatch = filteredKeyMap.containsKey(it2.next());
			}
			if (isMatch) {
				return state;
			}

		}
		return null;
	}

	private static Map<View, Object> filterInvisibleKeys(Map<View, Object> keyMap) {
		Map<View, Object> map = new HashMap<View, Object>();
		for (Iterator it = keyMap.keySet().iterator(); it.hasNext();) {
			View view = (View) it.next();
			if (GMFUtils.isViewVisible(view)) {
				map.put(view, null);
			}
		}
		return map;
	}

}
