/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployOperation;

/**
 * AbstractTransactionalCommand that wraps an EMF.Edit and GMF commands to provide transactionality.
 * 
 */
public class TransactionCommandWrapper2 extends DeployTransactionalCommand {

	private static final List<DeployModelObject> EMPTY_LIST = Collections.emptyList();

	private final Executable executable;
	private final List<DeployModelObject> visualizeList;
	private final boolean refreshLinks;

	/**
	 * A common interface for various kinds of commands to execute.
	 * 
	 */
	public static interface Executable {

		/**
		 * The execute method should map to the specific delegate commands method and signature.
		 * 
		 * @param monitor
		 */
		public void execute(IProgressMonitor monitor);
	}

	protected static class GEFWrapper implements Executable {
		org.eclipse.gef.commands.Command cmd;

		protected GEFWrapper(org.eclipse.gef.commands.Command command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			cmd.execute();
		}
	}

	protected static class EMFWrapper implements Executable {
		Command cmd;

		protected EMFWrapper(Command command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			cmd.execute();
		}
	}

	protected static class RunnableWrapper implements Executable {
		Runnable cmd;

		protected RunnableWrapper(Runnable command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			cmd.run();
		}
	}

	protected static class AbstractCommandWrapper implements Executable {
		AbstractCommand cmd;

		protected AbstractCommandWrapper(AbstractCommand command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			cmd.execute();
		}
	}

	protected static class GMFAbstractCommandWrapper implements Executable {
		org.eclipse.gmf.runtime.common.core.command.AbstractCommand cmd;

		protected GMFAbstractCommandWrapper(
				org.eclipse.gmf.runtime.common.core.command.AbstractCommand command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			try {
				cmd.execute(monitor, null);
			} catch (ExecutionException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
		}
	}

	protected static class DeployOperationWrapper implements Executable {
		DeployOperation cmd;

		protected DeployOperationWrapper(DeployOperation command) {
			cmd = command;
		}

		public void execute(IProgressMonitor monitor) {
			cmd.run(monitor);
		}
	}

	/**
	 * @param dmo
	 * @param command
	 * @param refreshLinks
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo, Command command,
			boolean refreshLinks) {
		return new TransactionCommandWrapper2(dmo, new EMFWrapper(command), command.getLabel(),
				refreshLinks, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param command
	 * @param refreshLinks
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo,
			org.eclipse.gef.commands.Command command, boolean refreshLinks) {
		return new TransactionCommandWrapper2(dmo, new GEFWrapper(command), command.getLabel(),
				refreshLinks, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param label
	 * @param runnable
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo, String label, Runnable runnable) {
		return new TransactionCommandWrapper2(dmo, new RunnableWrapper(runnable), label, false,
				EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param label
	 * @param runnable
	 * @param refreshLinks
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo, String label, Runnable runnable,
			boolean refreshLinks) {
		return new TransactionCommandWrapper2(dmo, new RunnableWrapper(runnable), label,
				refreshLinks, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param command
	 * @param refreshLinks
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo, AbstractCommand command,
			boolean refreshLinks) {
		return new TransactionCommandWrapper2(dmo, new AbstractCommandWrapper(command), command
				.getLabel(), refreshLinks, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param displayName
	 * @param command
	 * @param refreshLinks
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo, String displayName,
			DeployOperation command, boolean refreshLinks) {
		return new TransactionCommandWrapper2(dmo, new DeployOperationWrapper(command), command
				.getDisplayName(), refreshLinks, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param command
	 * @return An instance of the normalization type {@link TransactionCommandWrapper2} which
	 *         supports the required {@link AbstractTransactionalCommand} type needed for undo and
	 *         ValidateEdit support.
	 */
	public static TransactionCommandWrapper2 create(EObject dmo,
			org.eclipse.gmf.runtime.common.core.command.AbstractCommand command) {
		return new TransactionCommandWrapper2(dmo, new GMFAbstractCommandWrapper(command), command
				.getLabel(), true, EMPTY_LIST);
	}

	/**
	 * @param dmo
	 * @param command
	 * @param label
	 * @param shouldRefreshLinks
	 * @param objectsToVisualize
	 */
	public TransactionCommandWrapper2(EObject dmo, Executable command, String label,
			boolean shouldRefreshLinks, List<DeployModelObject> objectsToVisualize) {
		super(TransactionUtil.getEditingDomain(dmo), label, getAllWorkspaceFiles(dmo));

		executable = command;
		visualizeList = objectsToVisualize;
		refreshLinks = shouldRefreshLinks;
	}

	/**
	 * @param dmo
	 * @param command
	 * @param shouldRefreshLinks
	 */
	public TransactionCommandWrapper2(EObject dmo, Command command, boolean shouldRefreshLinks) {
		super(TransactionUtil.getEditingDomain(dmo), command.getLabel(), getAllWorkspaceFiles(dmo));

		executable = new EMFWrapper(command);
		visualizeList = null;
		refreshLinks = shouldRefreshLinks;
	}

	/**
	 * @param dmo
	 * @param command
	 * @param objectsToVisualize
	 */
	public TransactionCommandWrapper2(EObject dmo, Command command,
			List<DeployModelObject> objectsToVisualize) {
		super(TransactionUtil.getEditingDomain(dmo), command.getLabel(), getAllWorkspaceFiles(dmo));

		executable = new EMFWrapper(command);

		visualizeList = objectsToVisualize;
		refreshLinks = false;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		executable.execute(monitor);

		if (visualizeList != null) {
			CanonicalUtils.refreshViews(visualizeList, false);
		}
		if (refreshLinks) {
			CanonicalUtils.refreshLinks();
		}

		return CommandResult.newOKCommandResult();
	}

}
