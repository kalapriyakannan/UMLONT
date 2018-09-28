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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;

/**
 * Command to discover linked objects to a set of units.
 */
public abstract class AbstractDiscoverCommand extends
		AbstractTransactionalCommand {

	private final List<Unit> selectedUnits;
	private final List selectedParts;
	private final Point point;

	private final DiagramEditPart diagramEP;
	private List<View> lastCreatedViews = new ArrayList<View>();

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
	public AbstractDiscoverCommand(List<Unit> selectedUnits,
			List selectedParts, DiagramEditPart targetEP, Point point) {
		super(targetEP.getEditingDomain(), Messages.Discover_host,
				getWorkspaceFiles(targetEP.getNotationView()));
		this.selectedParts = selectedParts;
		this.diagramEP = targetEP;
		this.selectedUnits = selectedUnits;
		this.point = point;
	}

	/*
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		List<DeployModelObject> newDiagramObjects = new ArrayList<DeployModelObject>();
		for (Unit unit : selectedUnits) {
			List<UnitDescriptor> unitDescriptors = getUnitDescriptors(unit,
					monitor);
			if (unitDescriptors == null) {
				unitDescriptors = Collections.emptyList();
			}
			for (UnitDescriptor ud : unitDescriptors) {
				if (ud == null) {
					continue;
				}
				if (!ud.isInTopology(unit.getEditTopology())) {
					Unit discoveredUnit = ud.getUnitValueAndAddToTopology(unit
							.getEditTopology());
					newDiagramObjects.add(discoveredUnit);
				} else {
					// If the unit is not in the diagram, we need to add it.
					Unit discoveredUnit = ud.getUnitValue();
					boolean foundInDiagram = false;
					for (Iterator iter = this.diagramEP.getDiagramView()
							.getChildren().iterator(); iter.hasNext();) {
						Object diagramChild = iter.next();
						if (diagramChild instanceof Node) {
							Node node = (Node) diagramChild;
							if (discoveredUnit.equals(node.getElement())) {
								foundInDiagram = true;
								break;
							}
						}
					}
					if (!foundInDiagram) {
						newDiagramObjects.add(discoveredUnit);
					}
				}
			}
		}
		//
		// Update the diagram
		// /
		if (newDiagramObjects.size() > 0) {
			VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(
					diagramEP.getEditingDomain(), diagramEP, newDiagramObjects,
					lastCreatedViews, point);
			visualizeCmd.execute(monitor, info);
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Returns a list of unit descriptors for the unit.
	 * <p>
	 * This method should be implemented by subtypes
	 * 
	 * @param unit
	 *            the unit from which discovery should be performed.
	 * @param monitor
	 *            a discovery progress monitor.
	 * @return a list of unit descriptors.
	 */
	public abstract List<UnitDescriptor> getUnitDescriptors(Unit unit,
			IProgressMonitor monitor);
}
