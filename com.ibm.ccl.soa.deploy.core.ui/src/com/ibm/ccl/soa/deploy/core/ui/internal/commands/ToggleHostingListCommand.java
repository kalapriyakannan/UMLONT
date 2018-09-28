/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.Assert;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 1.0
 * 
 */
public class ToggleHostingListCommand extends AbstractTransactionalCommand {
	private final DeployDiagramEditPart diagramEP;
	private final Unit configUnit;
	private final Unit serverUnit;
	private final boolean addToHostingList;

	/**
	 * @param editingDomain
	 * @param diagramEP
	 * @param configUnit
	 * @param serverUnit
	 * @param options
	 * @param addToHostingList
	 */
	public ToggleHostingListCommand(TransactionalEditingDomain editingDomain, Map options,
			DeployDiagramEditPart diagramEP, Unit configUnit, Unit serverUnit, boolean addToHostingList) {

		super(editingDomain, "Toggle Hosting List Command", options, null); //$NON-NLS-1$

		Assert.isNotNull(diagramEP);
		Assert.isNotNull(configUnit);
		Assert.isNotNull(serverUnit);

		this.diagramEP = diagramEP;
		this.configUnit = configUnit;
		this.serverUnit = serverUnit;
		this.addToHostingList = addToHostingList;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		// find all existing config units views
		List configList = GMFUtils.getEditPartsFor(diagramEP, configUnit);

		// find all existing server editparts
		List serverList = GMFUtils.getEditPartsFor(diagramEP, serverUnit);

		// get view we're creating
		EditPart configEP = (EditPart) configList.get(0);
		View configView = (View) configEP.getModel();
		/*
		 * adding config unit view to all hosting lists
		 */
		if (addToHostingList) {
			// at least one server must be visible to proceed
			// otherwise config unit will diasspaer without a trace
			if (!isOneServerVisible(serverList)) {
				return CommandResult.newErrorCommandResult("No Server Visible"); //$NON-NLS-1$
			}

			// iterate through all existing server views and add a new configUnit view to it
			for (Iterator it = serverList.iterator(); it.hasNext();) {
				IGraphicalEditPart serverEP = (IGraphicalEditPart) it.next();
				View serverView = (View) serverEP.getModel();
				View containerEP = ViewUtil.getChildBySemanticHint(serverView,
						DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (containerEP == null) {
					containerEP = ViewUtil.getChildBySemanticHint(serverView,
							DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				}

				// make sure the hosting list is expanded
				ViewUtil.setStructuralFeatureValue(containerEP, NotationPackage.eINSTANCE
						.getDrawerStyle_Collapsed(), new Boolean(false));

				// create a new config unit view in the hosting list
				com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.createNode(new EObjectAdapter(configUnit),
						containerEP, configView.getType(), -1, diagramEP.getDiagramPreferencesHint());
			}

			// after all that, if server is no longer visible because it's hosted/member of config unit,
			//  create a dup view of the server in the canvas
			GMFUtils.createDupViewForLinkCycleProblem(getEditingDomain(), diagramEP, serverUnit);

		} else {
			/*
			 * removing config unit view from all hosting lists
			 */
			// create new config unit view in the diagram
			Node newView = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.createNode(new EObjectAdapter(
					configUnit), (View) diagramEP.getModel(), configView.getType(), -1, diagramEP
					.getDiagramPreferencesHint());

			// position it next to first server
			EditPart serverEP = (EditPart) serverList.get(0);
			EditPart walker = serverEP;
			while (walker != null) {
				if (walker.getParent() == diagramEP) {
					break;
				}
				walker = walker.getParent();
			}
			if (walker != null) {
				serverEP = walker;
			}
			View serverView = (View) serverEP.getModel();
			Integer x = (Integer) ViewUtil.getStructuralFeatureValue(serverView,
					NotationPackage.eINSTANCE.getLocation_X());
			int y = ((Integer) ViewUtil.getStructuralFeatureValue(serverView,
					NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			int height = ((Integer) ViewUtil.getStructuralFeatureValue(serverView,
					NotationPackage.eINSTANCE.getSize_Height())).intValue();
			ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_X(), x);
			ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_Y(),
					new Integer(y + height + 250));
		}

		// delete all found config unit views
		for (Iterator it = configList.iterator(); it.hasNext();) {
			ViewUtil.destroy((View) ((EditPart) it.next()).getModel());
		}
		diagramEP.refresh();

		return CommandResult.newOKCommandResult();
	}

	private boolean isOneServerVisible(List serverList) {
		for (Iterator it = serverList.iterator(); it.hasNext();) {
			IGraphicalEditPart serverEP = (IGraphicalEditPart) it.next();
			if (GMFUtils.isFigureVisible(serverEP.getFigure())) {
				return true;
			}
		}
		return false;
	}

	public boolean canExecute() {
		return true;
	}

}
