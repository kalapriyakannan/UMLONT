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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;

/**
 * @since 1.0
 * 
 */
public class DeployCopyCommand extends DeployTransactionalCommand {

	private final DeployDiagramEditPart _dep;
	private final List<?> _views;
	private final boolean _isUndoable;

	/**
	 * @param editingDomain
	 * @param dep
	 * @param label
	 * @param views
	 * @param isUndoable
	 */
	public DeployCopyCommand(TransactionalEditingDomain editingDomain, DeployDiagramEditPart dep,
			String label, List<?> views, boolean isUndoable) {
		super(editingDomain, label, getAllWorkspaceFiles(dep));
		_dep = dep;
		_views = views;
		_isUndoable = isUndoable;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		// create a deploy object clip for the clipboard
		Topology toTopology = CoreFactory.eINSTANCE.createTopology();
		Diagram toDiagram = ViewService.getInstance().createDiagram(new EObjectAdapter(toTopology),
				DeployCoreConstants.DEPLOY_CORE, _dep.getDiagramPreferencesHint());
		ViewUtil.copyDiagramElementsAndViews(_views, toDiagram, _dep, null, false, null);

		// remove links to units that aren't in the clipped units
		List<Unit> units = new ArrayList<Unit>();
		ViewUtil.collectDiagramUnits(toDiagram.getPersistedChildren(), units);
		Set<EObject> trash = new HashSet<EObject>();
		for (Unit unit : units) {
			for (Iterator<?> it = unit.getHostingLinks().iterator(); it.hasNext();) {
				HostingLink link = (HostingLink) it.next();
				if (link != null && link.getTarget() == null) {
					trash.add(link);
				}
			}
			for (Iterator<?> iterator = unit.getDependencyOrAnyRequirements().iterator(); iterator
					.hasNext();) {
				Requirement req = (Requirement) iterator.next();
				DependencyLink link = req.getLink();
				if (link != null && link.getTarget() == null) {
					trash.add(link);
				}
			}
			for (Iterator<?> it = unit.getConstraintLinks().iterator(); it.hasNext();) {
				ConstraintLink link = (ConstraintLink) it.next();
				if (link != null && link.getTarget() == null) {
					trash.add(link);
				}
			}
		}
		for (EObject link : trash) {
			EcoreUtil.remove(link);
		}

		// stick the clip on the clipboard
		Clipboard clipboard = new Clipboard(_dep.getViewer().getControl().getDisplay());
		clipboard.setContents(new Object[] { toDiagram }, new Transfer[] { DeployObjectTransfer
				.getInstance() });
		clipboard.dispose();

		return CommandResult.newOKCommandResult();
	}

	public boolean canUndo() {
		return _isUndoable;
	}

	public boolean canRedo() {
		return _isUndoable;
	}

	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (_isUndoable) {
			return Status.OK_STATUS;
		}
		return super.doUndo(monitor, info);
	}

	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (_isUndoable) {
			return Status.OK_STATUS;
		}
		return super.doRedo(monitor, info);
	}

	public boolean canExecute() {
		return true;
	}

}
