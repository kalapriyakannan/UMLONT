/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 1.0
 * 
 * This canonical edit policy makes sure there's a view for every semantic member/hostee of this
 * compartment.
 */
public class HybridListCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {

	private Set<Unit> _childUnitSet = null;

	/**
	 * 
	 */
	public HybridListCompartmentCanonicalEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Unit) {
			Unit unit = (Unit) eObject;

			// Check for cycle: don't show children in that case
			if (hasEditPartCycle(unit, host())) {
				return Collections.EMPTY_LIST;
			}

			return getSemanticChildrenListHelper(unit, getChildUnitSet(unit));
		}
		return Collections.EMPTY_LIST;
	}

	// import trees show all hosting links by containment (hostee is a branch under host)
	// for consistency sake all non-import trees should also show hosting links by containment
	// therefore we need to determine if a hosting link is between two children of this non-import tree
	private Set<Unit> getChildUnitSet(Unit unit) {
		Set<Unit> childUnitSet = null;
		if (!GMFUtils.isImportTopology(getHost()) && !GMFUtils.isDiagramNode(getHost())) {
			DeployListCompartmentEditPart topList = GMFUtils.getTopList((GraphicalEditPart) getHost());
			// if this is the top list of a tree, fill child list
			if (topList == getHost()) {
				collectChildSet(unit);
				childUnitSet = _childUnitSet;
			} else {
				// else get the child set filled in by top list
				EditPolicy policy = topList.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
				if (policy instanceof HybridListCompartmentCanonicalEditPolicy) {
					HybridListCompartmentCanonicalEditPolicy topPolicy = (HybridListCompartmentCanonicalEditPolicy) policy;
					childUnitSet = topPolicy.getChildUnitSet();
				}
			}
		}
		return childUnitSet;
	}

	private void collectChildSet(Unit unit) {
		// init set
		if (_childUnitSet == null) {
			_childUnitSet = new HashSet<Unit>();
		} else {
			_childUnitSet.clear();
		}

		// fill with all children of this list/tree
		List<Unit> semanticList = new ArrayList<Unit>();
		semanticList.add(unit);
		List<Unit> processedList = new ArrayList<Unit>();
		collectChildSetHelper(semanticList, _childUnitSet, processedList, null);
		_childUnitSet.remove(unit);

		// if this isn't the top container, remove children/grandchildren of top container excluding this tree
		// (top container is a shape container and hosting links are visible)
		Set<Unit> otherChildSet = null;
		GraphicalEditPart topEP = (GraphicalEditPart) GEFUtils.getTopEditPart(getHost());
		if (topEP != getHost().getParent()) {
			otherChildSet = new HashSet<Unit>();
			semanticList.clear();
			EObject eo = topEP.resolveSemanticElement();
			if (eo instanceof Unit) {
				semanticList.add((Unit) eo);
			}
			processedList.clear();
			collectChildSetHelper(semanticList, otherChildSet, processedList, unit);
			_childUnitSet.removeAll(otherChildSet);
		}
	}

	private void collectChildSetHelper(List<Unit> semanticList, Set<Unit> childSet,
			List<Unit> processedList, Unit excludeUnit) {
		for (Unit unit : semanticList) {
			// don't process if already processed (avoid link cycle)
			// don't process if the host unit (to collect all but host unit's tree children)
			if (unit != excludeUnit && !processedList.contains(unit)) {
				processedList.add(unit);
				List childList = getSemanticChildrenListHelper(unit, null);
				if (childList.size() > 0) {
					childSet.addAll(childList);
					collectChildSetHelper(childList, childSet, processedList, excludeUnit);
				}
			}
		}
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}

	/**
	 * @return all units that belong to this tree
	 */
	public Set<Unit> getChildUnitSet() {
		return _childUnitSet;
	}

	protected Command getCreateViewCommand(CreateRequest request) {
		return getCreateViewCommandRestricted(request);
	}

}
