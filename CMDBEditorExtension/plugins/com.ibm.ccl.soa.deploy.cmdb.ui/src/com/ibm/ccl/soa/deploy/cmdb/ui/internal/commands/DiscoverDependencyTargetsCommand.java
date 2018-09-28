/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.cmdb.ui.internal.commands;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;

/**
 * Command to discover the hosts of a set of units.
 */
public class DiscoverDependencyTargetsCommand extends AbstractDiscoverCommand {

	/**
	 * Construct a command to discover linked objects.
	 * 
	 * @param selectedUnits
	 *            the units selected by the user.
	 * @param selectedParts
	 *            the corresponding selected parts.
	 * @param targetEP
	 *            the diagram edit part.
	 * @param point
	 *            the point in which the command was executed (used to provide
	 *            the figures).
	 */
	public DiscoverDependencyTargetsCommand(List<Unit> selectedUnits,
			List selectedParts, DiagramEditPart targetEP, Point point) {
		super(selectedUnits, selectedParts, targetEP, point);
	}

	/**
	 * Returns a list of dependency target descriptors for the unit's
	 * requirements.
	 * 
	 * @param unit
	 *            the unit from which discovery should be performed.
	 * @param monitor
	 *            a discovery progress monitor.
	 * @return a list of unit descriptors.
	 */
	public List<UnitDescriptor> getUnitDescriptors(Unit unit,
			IProgressMonitor monitor) {
		if (unit == null) {
			return Collections.emptyList();
		}
		UnitDescriptor descr = TopologyDiscovererService.INSTANCE.findTarget(
				unit, (Requirement) null, unit.getEditTopology(), monitor);
		if (descr != null) {
			return Collections.singletonList(descr);
		}
		return Collections.emptyList();
		/*
		 * List<UnitDescriptor> result = null; for (Requirement req : (List<Requirement>)
		 * unit.getRequirements()) { if (req.getLinkType() !=
		 * RequirementLinkTypes.DEPENDENCY_LITERAL) { continue; } UnitDescriptor
		 * descr = TopologyDiscovererService.INSTANCE .findTarget(unit, req,
		 * unit.getEditTopology(), monitor); if (descr != null) { if (result ==
		 * null) { result = new ArrayList<UnitDescriptor>(); }
		 * result.add(descr); } } if (result == null) { return
		 * Collections.emptyList(); } return result;
		 */
	}
}