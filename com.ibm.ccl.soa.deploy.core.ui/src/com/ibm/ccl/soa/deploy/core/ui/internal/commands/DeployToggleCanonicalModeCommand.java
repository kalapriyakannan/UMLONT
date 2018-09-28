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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * same as GMF class except will alternatively affect the links canonical editpolicies if the links
 * flag is true
 */
public class DeployToggleCanonicalModeCommand extends Command {

	/** enablement flag. */
	private boolean _enable;

	/** enablement flag. */
	private boolean _links;

	/** list of semantic elements canonical editpolicies are listening to. */
	private final Collection _semanticHosts = new ArrayList();

	// an operation to enable undo using Transaction API is possible
	private AbstractEMFOperation op = null;

	// domain to use to record the change that will happen when we re-enable the edit policy
	private TransactionalEditingDomain domain;

	// also pause cache refresh
	private boolean _pauseCache = false;

	/**
	 * Create an instance.
	 * 
	 * @param editParts
	 *           collection of editparts who's canonical editpolicies will be affected.
	 * @param links
	 * @param enable
	 *           enablement flag
	 * @param pauseCache
	 *           TODO
	 */
	public DeployToggleCanonicalModeCommand(Collection editParts, boolean links, boolean enable,
			boolean pauseCache) {
		super(DiagramUIMessages.ToggleCanonicalModeCommand_Label);
		_links = links;
		Object[] editparts = new Object[editParts.size()];
		editParts.toArray(editparts);
		for (int i = 0; i < editparts.length; i++) {
			EditPart editPart = (EditPart) editparts[i];
			if (editPart != null) {
				CanonicalEditPolicy editPolicy = getCanonicalEditPolicy(editPart);
				if (editPolicy != null) {
					_semanticHosts.add(new WeakReference(editPolicy.getSemanticHost()));
				}
			}
		}
		_enable = enable;
		_pauseCache = pauseCache;
	}

	/**
	 * Create an instance.
	 * 
	 * @param element
	 *           a semantic element
	 * @param enable
	 *           enablement flag
	 */
	public DeployToggleCanonicalModeCommand(EObject element, boolean enable) {
		super(DiagramUIMessages.ToggleCanonicalModeCommand_Label);
		_semanticHosts.add(new WeakReference(element));
		_enable = enable;
	}

	/**
	 * Create an instance.
	 * 
	 * @param target
	 *           the target editpart
	 * @param links
	 * @param enable
	 *           the enablement flag
	 */
	public DeployToggleCanonicalModeCommand(EditPart target, boolean links, boolean enable) {
		this(Collections.singletonList(target), links, enable, false);
	}

	/**
	 * <code>ToggleCanonicalModeCommand</code> factory method.
	 * 
	 * @param editParts
	 *           collection of editparts who's canonical editpolicies will be affected.
	 * @param links
	 * @param enable
	 *           enablement flag
	 * @param pauseCache
	 *           TODO
	 * @return a <code>ToggleCanonicalModeCommand</code> if at least one of the supplied editparts
	 *         has a <code>CanonicalEditPolicy</code> installed on it, otherwise <tt>null</tt>.
	 */
	public static DeployToggleCanonicalModeCommand getToggleCanonicalModeCommand(
			Collection editParts, boolean links, boolean enable, boolean pauseCache) {
		DeployToggleCanonicalModeCommand cmd = new DeployToggleCanonicalModeCommand(editParts, links,
				enable, pauseCache);
		return cmd.getSemanticHosts().isEmpty() && !pauseCache ? null : cmd;
	}

	/**
	 * <code>ToggleCanonicalModeCommand</code> factory method. This copy constructor style factory
	 * will return a new command that shares the supplied commands semantic hosts.
	 * 
	 * @param tcmd
	 *           a <code>ToggleCanonicalModeCommand</code>
	 * @param links
	 * @param enable
	 *           enablement flag
	 * @param pauseCache
	 *           TODO
	 * @return a <code>ToggleCanonicalModeCommand</code> if at least one of the supplied editparts
	 *         has a <code>CanonicalEditPolicy</code> installed on it, otherwise <tt>null</tt>.
	 */
	public static DeployToggleCanonicalModeCommand getToggleCanonicalModeCommand(
			DeployToggleCanonicalModeCommand tcmd, boolean links, boolean enable, boolean pauseCache) {
		if (tcmd == null || tcmd.getSemanticHosts().isEmpty() && !pauseCache) {
			return null;
		}
		DeployToggleCanonicalModeCommand cmd = new DeployToggleCanonicalModeCommand(
				Collections.EMPTY_LIST, links, enable, pauseCache);
		cmd.setSemanticHosts(tcmd.getSemanticHosts());
		return cmd;
	}

	/**
	 * Return the set of semantic hosts on which a canonical editpolicy is listening.
	 * 
	 * @return semantic hosts
	 */
	protected final Collection getSemanticHosts() {
		return _semanticHosts;
	}

	private final void setSemanticHosts(Collection hosts) {
		_semanticHosts.clear();
		_semanticHosts.addAll(hosts);
	}

	/**
	 * Return the canonical editpolicy installed on the supplied editpart.
	 * 
	 * @param editPart
	 *           edit part to use
	 * @return the canoncial edit policy if there is any
	 */
	protected CanonicalEditPolicy getCanonicalEditPolicy(EditPart editPart) {
		if (_links) {
			return (CanonicalEditPolicy) editPart
					.getEditPolicy(DeployEditPolicyRoles.HOSTING_CANONICAL_ROLE);
		}
		// diagram edit policy is different to allow just the view to be deleted
		// otherwise default CANONICAL_ROLE prevents a view from being deleted
		return (CanonicalEditPolicy) editPart
				.getEditPolicy(editPart instanceof DeployDiagramEditPart ? DeployEditPolicyRoles.DIAGRAM_CANONICAL_ROLE
						: EditPolicyRoles.CANONICAL_ROLE);
	}

	/** Removes the canonical editpolict from the target editpart. */
	public void execute() {
		// pause cache when pausing canonical refresh?
		if (_pauseCache) {
			DeployDiagramEditPart ddep = (DeployDiagramEditPart) ResourceUtils
					.getActiveDeployEditDomain().getDiagramEditPart();
			if (!_enable) {
				CanonicalUtils.pauseSemanticCacheRefresh(ddep);
			} else {
				CanonicalUtils.resumeSemanticCacheRefresh(ddep);
			}

		}
		// try to record only if we are enabling the edit policy
		if (_enable && domain != null) {
			op = new AbstractEMFOperation(domain, "") { //$NON-NLS-1$

				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
					DoEnable(_enable);
					return Status.OK_STATUS;
				}

			};
			try {
				op.execute(null, null);
			} catch (ExecutionException e) {
				//I give up... just do the enable.
				DoEnable(_enable);
			}
		} else {
			DoEnable(_enable);
		}
	}

	/**
	 * Enables the canonical editpolicies listening of the list of semantic elements.
	 * 
	 * @param enable
	 *           enablement flag
	 */
	private void DoEnable(boolean enable) {
		Iterator references = getSemanticHosts().iterator();
		while (references.hasNext()) {
			WeakReference wr = (WeakReference) references.next();
			EObject semanticHost = (EObject) wr.get();
			if (semanticHost != null) {
				List ceps = CanonicalEditPolicy.getRegisteredEditPolicies(semanticHost);
				for (int i = 0; i < ceps.size(); i++) {
					CanonicalEditPolicy cep = (CanonicalEditPolicy) ceps.get(i);
					if (cep instanceof DeployCanonicalEditPolicy) {
						((DeployCanonicalEditPolicy) cep).setisForceEnabledOff(!enable);
					}
					cep.enableRefresh(enable);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		// the enable is not an EMF command, so we had to undo it manually before undo the EMF operation
		DoEnable(!_enable);
		if (op != null) {
			try {
				op.undo(null, null);
			} catch (ExecutionException e) {
				// Give up...
			}
		}
	}

	/**
	 * @param d
	 */
	public void setDomain(TransactionalEditingDomain d) {
		domain = d;
	}
}
