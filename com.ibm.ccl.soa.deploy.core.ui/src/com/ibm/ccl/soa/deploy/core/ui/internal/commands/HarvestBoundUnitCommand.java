/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 */
public class HarvestBoundUnitCommand extends DeployTransactionalCommand {
	private final DeployShapeNodeEditPart selectedEP;

	// Disable until working fully
	private static final boolean INCLUDE_CONTAINED_UNITS = false;

	/**
	 * @param selectedEP
	 *           selected editpart
	 */
	public HarvestBoundUnitCommand(DeployShapeNodeEditPart selectedEP) {
		super(selectedEP.getEditingDomain(), Messages.HarvestBoundUnitCommand_HarvestBoundUnit,
				getAllWorkspaceFiles(selectedEP.getNotationView()));
		this.selectedEP = selectedEP;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		View selectedView = selectedEP.getNotationView();
		DiagramRootEditPart rootEP = (DiagramRootEditPart) selectedEP.getRoot();
		DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) rootEP.getChildren().get(0);
		Unit selectedUnit = (Unit) selectedView.getElement();
		Topology top = selectedUnit.getEditTopology();

		// Create harvested unit
		List units = new ArrayList();
		units.add(selectedUnit);

		Collection newunits = ResolutionUtils.partialIntelligentDeepCopy(units, selectedUnit
				.getEditTopology(), true);
		Unit newUnit = (Unit) newunits.iterator().next();
		newUnit.setOrigin(null);
		top.getUnits().add(newUnit);

		// TODO more logic around capturing contianed (member) units, ala bank unit action
		// disabled for now
		if (INCLUDE_CONTAINED_UNITS && selectedUnit.isGroup()) {
			Collection members = ValidatorUtils.getMembers(selectedUnit);
			Iterator it = members.iterator();
			ArrayList memberList = new ArrayList();
			while (it.hasNext()) {
				Unit member = (Unit) it.next();
				memberList.add(member);
			}

			Collection memberunits = ResolutionUtils.partialIntelligentDeepCopy(memberList,
					selectedUnit.getEditTopology(), true);
			it = memberunits.iterator();
			while (it.hasNext()) {
				Unit newmember = (Unit) it.next();
				top.getUnits().add(newmember);
				ResolutionUtils.addMember(null, newUnit, newmember);
			}

		}

		// create new view for new unit
		View containerView = ((IGraphicalEditPart) selectedEP.getParent()).getNotationView();
		View newView = ViewUtil.createNode(new EObjectAdapter(newUnit), containerView, selectedView
				.getType(), -1, diagramEP.getDiagramPreferencesHint());

		// position new view next to harvested unit's view
		Integer newX = new Integer(((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getLocation_X()))
				.intValue()
				+ DeployCoreConstants.SERVER_UNIT_WIDTH * 2);
		Integer newY = (Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getLocation_Y());
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(newView,
				NotationPackage.eINSTANCE.getLocation_X(), newX);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(newView,
				NotationPackage.eINSTANCE.getLocation_Y(), newY);

		// copy font and color of harvested view
		ViewUtil.copyFont(selectedView, newView);
		ViewUtil.copyColorsAndText(selectedView, newView);

		return CommandResult.newOKCommandResult(null);
	}
}
