/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ShowRelatedDialog;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CollapseCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * 
 * @author jswanke
 */
public class ShowRelatedAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public ShowRelatedAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setId(DeployActionIds.ACTION_SHOW_RELATED);
		setText(Messages.ShowRelatedAction_11);
		setToolTipText(Messages.ShowRelatedAction_11);
		init();
	}

	@Override
	protected boolean calculateEnabled() {
		List<?> selected = getSelectedObjects();
		if (selected.size() == 1 && selected.get(0) instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) getSelectedObjects().get(0);
			EObject eo = ep.resolveSemanticElement();
			if (eo instanceof Unit) {
				return true;
			}
		}
		return false;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	protected void doRun(IProgressMonitor progressMonitor) {

		// get related elements to visualize
		ShowRelatedDialog dlg = new ShowRelatedDialog(Display.getCurrent().getActiveShell());
		dlg.open();
		if (dlg.getReturnCode() == Window.CANCEL) {
			return;
		}
		List<Integer> selections = dlg.getSelections();
		int level = dlg.getLevel();

		// get a list of all contained related units as either a unit that has 
		// no view or as an existing editpart that must be selected
		final DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) getSelectedObjects().get(0);
		Unit unit = (Unit) ep.resolveSemanticElement();
		List<DeployModelObject> newUncontainedList = new ArrayList<DeployModelObject>();
		List<DeployShapeNodeEditPart> oldList = new ArrayList<DeployShapeNodeEditPart>();
		for (Unit u : filterPrivateUnits(getAllUncontainedRelatedUnits(unit, selections, level))) {
			List<DeployShapeNodeEditPart> list = GMFUtils.getEditPartsFor(ep, u);
			if (list.size() == 0) {
				newUncontainedList.add(u);
			} else {
				oldList.addAll(list);
			}
		}

		// get a list of all uncontained related units as either a unit that has 
		// no view or as an existing editpart that must be selected
		final List<DeployModelObject> newContainedList = new ArrayList<DeployModelObject>();
		for (Unit u : filterPrivateUnits(getAllContainedRelatedUnits(unit, selections, level))) {
			List<DeployShapeNodeEditPart> list = GMFUtils.getEditPartsFor(ep, u);
			if (list.size() == 0) {
				newContainedList.add(u);
			} else {
				oldList.addAll(list);
			}
		}

		// create views for related units that currently have no view
		if (newContainedList.size() != 0 || newUncontainedList.size() != 0) {
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
			CompositeCommand cc = new CompositeCommand(getCommandLabel());

			// add command that will add units to canvas
			if (newUncontainedList.size() > 0) {
				IFigure fig = GEFUtils.getTopFigure(ep.getFigure());
				Point pt = fig.getBounds().getTopRight().getTranslated(750, 0);
				fig.translateToAbsolute(pt);
				VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(ep
						.getEditingDomain(), ddep, newUncontainedList, null, pt);
				cc.compose(visualizeCmd);
			}

			// add command that will add units to canvas
			if (newContainedList.size() > 0) {
				IGraphicalEditPart toEP = ep
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (toEP == null) {
					toEP = ep.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				}
				if (toEP != null) {
					CollapseCommand expandCommand = new CollapseCommand(ddep.getEditingDomain(), ep,
							false);
					cc.compose(expandCommand);
					cc.compose(new AbstractTransactionalCommand(ddep.getEditingDomain(), "", null) {//$NON-NLS-1$
								// remove any filters
								protected CommandResult doExecuteWithResult(
										IProgressMonitor progressMonitor, IAdaptable info) {
									View view = ep.getNotationView();
									DeployStyle style = (DeployStyle) view
											.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
									style.getFilteredSemanticElements().removeAll(newContainedList);

									return CommandResult.newOKCommandResult();
								}
							});
					// then visualize
					VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(ep
							.getEditingDomain(), toEP, newContainedList, null, null);
					cc.compose(visualizeCmd);
				}
			}
			execute(new ICommandProxy(cc), progressMonitor);
		}

		// select existing related editparts
		if (oldList.size() != 0) {
			ep.getViewer().setSelection(new StructuredSelection(oldList));
		}

	}

	private Set<Unit> filterPrivateUnits(Set<Unit> inSet) {
		Set<Unit> set = new HashSet<Unit>();
		for (Unit unit : inSet) {
			if (!PropertyUtils.isProxy(unit) || unit.isVisible()) {
				set.add(unit);
			}
		}
		return set;
	}

	private Set<Unit> getAllContainedRelatedUnits(Unit unit, List<Integer> selections, int maxLevel) {
		Set<Unit> set = new HashSet<Unit>();
		getContainedRelatedUnits(unit, set, selections, 0, maxLevel);
		return set;
	}

	private void getContainedRelatedUnits(Unit unit, Set<Unit> allSet, List<Integer> selections,
			int level, int maxLevel) {
		level++;
		Set<Unit> thisSet = getContainedRelatedUnitsHelper(unit, selections);
		for (Unit u : thisSet) {
			if (!allSet.contains(u)) {
				allSet.add(u);
				if (level < maxLevel) {
					getContainedRelatedUnits(u, allSet, selections, level, maxLevel);
				}
			}
		}
	}

	private Set<Unit> getContainedRelatedUnitsHelper(Unit unit, List<Integer> selections) {
		Set<Unit> list = new HashSet<Unit>();
		Topology topology = unit.getEditTopology();
		if (selections.contains(ShowRelatedDialog.SHOW_HOSTEES)) {
			for (Iterator<HostingLink> it = topology.findAllHostingLinks(); it.hasNext();) {
				HostingLink link = it.next();
				if (unit.equals(link.getHost()) && link.getHosted().isConfigurationUnit()) {
					list.add(link.getHosted());
				}
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_MEMBERS)) {
			for (Iterator<MemberLink> it = topology.findAllMemberLinks(); it.hasNext();) {
				MemberLink link = it.next();
				if (unit.equals(getUnit(link.getSource()))) {
					list.add(getUnit(link.getTarget()));
				}
			}
		}
		return list;
	}

	private Set<Unit> getAllUncontainedRelatedUnits(Unit unit, List<Integer> selections, int maxLevel) {
		Set<Unit> set = new HashSet<Unit>();
		getUncontainedRelatedUnits(unit, set, selections, 0, maxLevel);
		return set;
	}

	private void getUncontainedRelatedUnits(Unit unit, Set<Unit> allSet, List<Integer> selections,
			int level, int maxLevel) {
		level++;
		Set<Unit> thisSet = getUncontainedRelatedUnitsHelper(unit, selections);
		for (Unit u : thisSet) {
			if (!allSet.contains(u)) {
				allSet.add(u);
				if (level < maxLevel) {
					getUncontainedRelatedUnits(u, allSet, selections, level, maxLevel);
				}
			}
		}
	}

	private Set<Unit> getUncontainedRelatedUnitsHelper(Unit unit, List<Integer> selections) {
		Set<Unit> list = new HashSet<Unit>();
		Topology topology = unit.getEditTopology();
		IRelationshipChecker relationships = topology.getRelationships();
		if (selections.contains(ShowRelatedDialog.SHOW_HOSTS)) {
			for (Iterator<HostingLink> it = relationships.getHostLinks(unit).iterator(); it.hasNext();) {
				HostingLink link = it.next();
				list.add(link.getHost());
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_HOSTEES)) {
			for (Iterator<HostingLink> it = relationships.getHostedLinks(unit).iterator(); it
					.hasNext();) {
				HostingLink link = it.next();
				if (!link.getHosted().isConfigurationUnit()) {
					list.add(link.getHosted());
				}
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_REQUIREMENTS)) {
			for (Iterator<DependencyLink> it = topology.findAllDependencyLinks(); it.hasNext();) {
				DependencyLink link = it.next();
				if (unit.equals(getUnit(link.getSource()))) {
					list.add(getUnit(link.getTarget()));
				}
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_CAPABILITIES)) {
			for (Iterator<DependencyLink> it = topology.findAllDependencyLinks(); it.hasNext();) {
				DependencyLink link = it.next();
				if (unit.equals(getUnit(link.getTarget()))) {
					list.add(getUnit(link.getSource()));
				}
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_CONSTRAINTS)) {
			for (Iterator<?> it = relationships.getConstraintLinkTargets(unit).iterator(); it
					.hasNext();) {
				list.add((Unit) it.next());
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_CONSTRAINTERS)) {
			for (Iterator<?> it = relationships.getConstraintLinkSources(unit).iterator(); it
					.hasNext();) {
				list.add((Unit) it.next());
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_CONTAINERS)) {
			for (Iterator<MemberLink> it = topology.findAllMemberLinks(); it.hasNext();) {
				MemberLink link = it.next();
				if (unit.equals(getUnit(link.getTarget()))) {
					list.add(getUnit(link.getSource()));
				}
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_REALIZED)) {
			for (Iterator<?> it = relationships.getRealizes(unit).iterator(); it.hasNext();) {
				list.add((Unit) it.next());
			}
		}
		if (selections.contains(ShowRelatedDialog.SHOW_REALIZER)) {
			for (Iterator<?> it = relationships.getRealizedBy(unit).iterator(); it.hasNext();) {
				list.add((Unit) it.next());
			}
		}
		return list;
	}

	static private Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}
}
