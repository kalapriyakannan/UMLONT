/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Based on ElementToEditPartsMap written by chmahone
 * 
 */
public class DeployElementToEditPartsMap {

	/**
	 * A registry of editparts, mapping an element's id string to a list of <code>EditParts</code>.
	 */
	private final Map<EObject, List<AbstractGraphicalEditPart>> objectToEditpartMap = new HashMap<EObject, List<AbstractGraphicalEditPart>>();
	private final Map<Topology, List<AbstractGraphicalEditPart>> topologyToProxiesMap = new HashMap<Topology, List<AbstractGraphicalEditPart>>();

	/**
	 * @param eo
	 * @param editPartClass
	 * @return found list
	 */
	public List<AbstractGraphicalEditPart> findEditPartsForElement(EObject eo, Class editPartClass) {

		List<AbstractGraphicalEditPart> allEPs = objectToEditpartMap.get(eo);
		if (allEPs == null) {
			return Collections.emptyList();
		}
		List<AbstractGraphicalEditPart> specificEPs = new ArrayList<AbstractGraphicalEditPart>();
		for (Iterator<AbstractGraphicalEditPart> iter = allEPs.iterator(); iter.hasNext();) {
			Object ep = iter.next();
			if (editPartClass.isInstance(ep)) {
				specificEPs.add((AbstractGraphicalEditPart) ep);
			}
		}
		return specificEPs;
	}

	/**
	 * @param topology
	 * @return found list
	 */
	public List<AbstractGraphicalEditPart> findProxyEditPartsForTopology(Topology topology) {
		return topologyToProxiesMap.get(topology);
	}

	/**
	 * @param eo
	 * @param ep
	 */
	public void registerEditPartForElement(EObject eo, EditPart ep) {

		if (eo == null || ep == null) {
			return;
		}

		List<AbstractGraphicalEditPart> epList = objectToEditpartMap.get(eo);
		if (epList != null) {
			if (!epList.contains(ep)) {
				epList.add((AbstractGraphicalEditPart) ep);
			}
		} else {
			ArrayList<AbstractGraphicalEditPart> newList = new ArrayList<AbstractGraphicalEditPart>(1);
			newList.add((AbstractGraphicalEditPart) ep);
			objectToEditpartMap.put(eo, newList);
		}

		// if a proxy, register with proxy map-- to be used if its import is deleted
		if (ep instanceof DeployShapeNodeEditPart && eo instanceof DeployModelObject
				&& PropertyUtils.isProxy((DeployModelObject) eo) && !GMFUtils.isImportTopology(ep)) {
			Topology topology = ((DeployModelObject) eo).getTopology();
			epList = topologyToProxiesMap.get(topology);
			if (epList != null) {
				if (!epList.contains(ep)) {
					epList.add((AbstractGraphicalEditPart) ep);
				}
			} else {
				ArrayList<AbstractGraphicalEditPart> newList = new ArrayList<AbstractGraphicalEditPart>(
						1);
				newList.add((AbstractGraphicalEditPart) ep);
				topologyToProxiesMap.put(topology, newList);
			}
		}

	}

	/**
	 * @param eo
	 * @param ep
	 */
	public void unregisterEditPartForElement(EObject eo, EditPart ep) {

		if (eo == null || ep == null) {
			return;
		}

		List<AbstractGraphicalEditPart> epList = objectToEditpartMap.get(eo);
		if (epList != null && epList.contains(ep)) {
			epList.remove(ep);
			if (epList.isEmpty()) {
				objectToEditpartMap.remove(eo);
			}
		}

		// if a proxy, register with proxy map-- used if its import is deleted
		if (eo instanceof DeployModelObject && PropertyUtils.isProxy((DeployModelObject) eo)
				&& !GMFUtils.isImportTopology(ep)) {
			Topology topology = ((DeployModelObject) eo).getTopology();
			epList = topologyToProxiesMap.get(topology);
			if (epList != null && epList.contains(ep)) {
				epList.remove(ep);
				if (epList.isEmpty()) {
					topologyToProxiesMap.remove(eo);
				}
			}
		}

	}

	/**
	 * @return the map
	 */
	public Map<EObject, List<AbstractGraphicalEditPart>> getMap() {
		return objectToEditpartMap;
	}

}
