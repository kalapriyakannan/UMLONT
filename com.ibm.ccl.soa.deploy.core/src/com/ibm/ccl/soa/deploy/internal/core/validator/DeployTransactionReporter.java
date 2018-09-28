/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils.ITopologyOperation;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Default implementation of the deploy reporter.
 */
public class DeployTransactionReporter implements IDeployTransactionReporter {

	/** The topology of the transaction. */
	protected Topology topology = null;

	/** List of deploy status added during a transaction. */
	protected List<IDeployStatus> statusList = new ArrayList<IDeployStatus>();

	/** Optional executor of the deploy update operation (may be null). */
	protected IDeployOperationExecutor topologyUpdateExecutor = null;

	/** The validator group identifier (may be null). */
	protected String groupID = null;

	/**
	 * Create a deploy reporter which serializes errors as markers.
	 */
	public DeployTransactionReporter() {
	}

	/**
	 * Sets the executor of the topology update on {@link #commitTransaction(IObjectFilter)}.
	 * 
	 * @param executor
	 *           a deploy operation executor (may be null).
	 */
	public void setTopologyUpdateExecutor(IDeployOperationExecutor executor) {
		topologyUpdateExecutor = executor;
	}

	/**
	 * @return the executor of the topology update on {@link #commitTransaction(IObjectFilter)} (may
	 *         be null).
	 */
	public IDeployOperationExecutor getTopologyUpdateExecutor() {
		return topologyUpdateExecutor;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployTransactionReporter#getTransactionTopology()
	 */
	public Topology getTransactionTopology() {
		return topology;
	}

	/**
	 * Sets the validator group ID that will be assigned on reported statuses.
	 * 
	 * @param id
	 *           the validator group ID (may be null).
	 * @see IDomainValidator#getGroupID()
	 */
	public void setGroupID(String id) {
		groupID = id;
	}

	/**
	 * The ID of the validator group assigned to reported statuses.
	 * 
	 * @return the validator group ID (may be null)
	 * @see IDomainValidator#getGroupID()
	 */
	public String getGroupID() {
		return groupID;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core
	 * .validator.status.IDeployStatus)
	 */
	public void addStatus(IDeployStatus status) {
		if (status.getMessage() == null) {
			IllegalArgumentException e = new IllegalArgumentException(status.toString());
			String message = DeployCoreMessages.Validator_reported_status_with_null_message;
			DeployCorePlugin.log(IStatus.WARNING, 0, message, e);
		}
		if (status.getDeployObject() == null) {
			Exception e = new Exception();
			DeployCorePlugin.log(IStatus.ERROR, 0,
					DeployCoreMessages.Validator_reported_status_0_on_null_object, e);
		} else {
			if (status instanceof DeployStatus) {
				((DeployStatus) status).setValidatorGroupID(groupID);
			}
			statusList.add(status);
		}
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.IDeployTransactionReporter#abortTransaction()
	 */
	public void abortTransaction() {
		synchronized (this) {
			statusList.clear();
			topology = null;
		}
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.IDeployTransactionReporter#beginTransaction
	 * (com.ibm.ccl.soa.deploy.core.Topology)
	 */
	public void beginTransaction(Topology topology) {
		assert topology != null;
		synchronized (this) {
			abortTransaction();
			this.topology = topology;
		}
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.IDeployTransactionReporter#getTransactionContents
	 * ()
	 */
	public List<IDeployStatus> getTransactionContents() {
		return statusList;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.IDeployTransactionReporter#commitTransaction()
	 */
	public IStatus commitTransaction() {
		final Topology commitTopology;
		final List<IDeployStatus> commitStatusList;
		synchronized (this) {
			if (topology == null) {
				return Status.CANCEL_STATUS;
			}
			commitTopology = topology;
			if (statusList.size() == 0) {
				commitStatusList = Collections.emptyList();
			} else {
				commitStatusList = statusList;
				statusList = new ArrayList<IDeployStatus>(statusList.size());
			}
			topology = null;
		}

		//
		// Post-process status
		//

		// Sort the committed statuses
		Collections.sort(commitStatusList);

		// Remove duplicates from sorted list
		Set<IDeployStatus> statusSet = new HashSet<IDeployStatus>();
		for (Iterator<IDeployStatus> iter = commitStatusList.iterator(); iter.hasNext();) {
			IDeployStatus cur = iter.next();
			if (statusSet.contains(cur)) {
				iter.remove();
			} else {
				statusSet.add(cur);
			}
		}

		// Commit the statuses
		IStatus result;
		if (topologyUpdateExecutor == null) {
			result = internalCommitTransaction(commitTopology, commitStatusList);
		} else {
			result = topologyUpdateExecutor.asyncExec(new DeployOperation(NLS
					.bind(DeployCoreMessages.Deploy_topology_0_validation_job, commitTopology
							.getDisplayName())) {
				public IStatus run(IProgressMonitor monitor) {
					return internalCommitTransaction(commitTopology, commitStatusList);
				}
			});
		}
		return result;
	}

	/**
	 * Commits the transaction in a write EMF transaction.
	 * 
	 * @param commitTopology
	 *           the topology being committed.
	 * @param commitStatusList
	 *           a list of status that is committed sorted by deploy object global path.
	 * @return the status of operation.
	 */
	protected IStatus internalCommitTransaction(final Topology commitTopology,
			final List<IDeployStatus> commitStatusList) {
		IStatus result = ValidatorUtils.executeWriteOperation(commitTopology,
				new ITopologyOperation() {
					public IStatus doExecute(DeployModelObject object, IProgressMonitor monitor,
							IAdaptable info) {
						try {
							updateTopology(commitTopology, commitStatusList);
						} catch (Throwable e) {
							String message = e.getMessage();
							if (message == null) {
								// TODO fix
								message = DeployCoreMessages.Validation_marker_creation_error;
							}
							DeployCorePlugin.logError(0, message, e);
							return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, e);
						}

						return Status.OK_STATUS;
					}

				});
		return result;
	}

	/**
	 * Incrementally updates the topology markers.
	 * <p>
	 * Must be invoked in a write transaction.
	 * 
	 * @param commitTopology
	 *           the topology to be committed.
	 * @param commitStatusList
	 *           a list of status that is committed sorted by object global path.
	 */
	private void updateTopology(Topology commitTopology, List<IDeployStatus> commitStatusList) {
		Set<DeployModelObject> objectSet = new HashSet<DeployModelObject>();
		for (Iterator<DeployModelObject> iter = commitTopology.findAllDeployModelObjects(); iter
				.hasNext();) {
			objectSet.add(iter.next());
		}

		List<IStatus> newObjectStatusList = new ArrayList<IStatus>();
		List<IStatus> oldObjectStatusList = new ArrayList<IStatus>();
		DeployModelObject curObject = null;
		for (Iterator<IDeployStatus> iter = commitStatusList.iterator(); iter.hasNext();) {
			IDeployStatus status = iter.next();
			DeployModelObject statusObject = commitTopology.resolve(status.getDeployObject()
					.getFullPath());
			if (statusObject == null) {
				statusObject = commitTopology.resolve(DeployModelObjectUtil.getGlobalPath(status
						.getDeployObject()));
			}
			if (statusObject != curObject) {
				if (curObject != null) {
					updateStatus(curObject, oldObjectStatusList, newObjectStatusList);
					objectSet.remove(curObject);
				}
				oldObjectStatusList.clear();
				newObjectStatusList.clear();
				curObject = statusObject;
			}
			newObjectStatusList.add(status);
		}

		if (curObject != null) {
			updateStatus(curObject, oldObjectStatusList, newObjectStatusList);
			objectSet.remove(curObject);
		}

		// Deal with objects for which no statuses were listed
		for (Iterator<DeployModelObject> iter = objectSet.iterator(); iter.hasNext();) {
			DeployModelObject object = iter.next();
			newObjectStatusList.clear();
			oldObjectStatusList.clear();
			updateStatus(object, oldObjectStatusList, newObjectStatusList);
		}
	}

	/**
	 * Updates the status on the deploy object.
	 * 
	 * @param object
	 *           the object whose status will be changed.
	 * @param oldObjectStatusList
	 *           a list used to store the old status on the object (will be changed).
	 * @param newObjectStatusList
	 *           a list of the new status to be added to the object (may be changed based on old
	 *           status that needs to be preserved).
	 */
	public void updateStatus(DeployModelObject object, List<IStatus> oldObjectStatusList,
			List<IStatus> newObjectStatusList) {

		//
		// If object had no status add all new status and return.
		//
		if (object.getStatus() == Status.OK_STATUS) {
			if (!newObjectStatusList.isEmpty()) {
				for (Iterator<IStatus> iter = newObjectStatusList.iterator(); iter.hasNext();) {
					IStatus cur = iter.next();
					object.addStatus(cur);
				}
			}
			return;
		}

		//
		// Populate the old object status list.
		//
		oldObjectStatusList.clear();
		boolean noNewStatusAdded = newObjectStatusList.isEmpty();
		int rejectOldStatusCount = 0;
		if (object.getStatus().isMultiStatus()) {
			IStatus[] children = object.getStatus().getChildren();
			for (int i = 0; i < children.length; i++) {
				oldObjectStatusList.add(children[i]);
				if (keepExistingStatus(children[i])) {
					// Keep the old non-validator issued status
					newObjectStatusList.add(children[i]);
				} else {
					rejectOldStatusCount++;
				}
			}
		} else {
			oldObjectStatusList.add(object.getStatus());
			if (keepExistingStatus(object.getStatus())) {
				// Keep the old non-validator issued status
				newObjectStatusList.add(object.getStatus());
			} else {
				rejectOldStatusCount++;
			}
		}

		if (noNewStatusAdded && rejectOldStatusCount == 0) {
			return;
		}

		// Check if the status has changed
		boolean setStatus = false;
		if (newObjectStatusList.size() != oldObjectStatusList.size()) {
			// List sizes are different so there has been a change.
			setStatus = true;
		} else {
			// Compare elements of the two lists
			for (Iterator<IStatus> iter = newObjectStatusList.iterator(); iter.hasNext();) {
				IStatus newStatus = iter.next();
				boolean found = false;
				for (Iterator<IStatus> iter2 = oldObjectStatusList.iterator(); iter2.hasNext();) {
					IStatus oldStatus = iter2.next();
					if (newStatus.equals(oldStatus)) {
						found = true;
						break;
					}
				}
				if (!found) {
					setStatus = true;
					break;
				}
			}
		}

		if (setStatus) {
			object.clearStatus();
			for (Iterator<IStatus> iter = newObjectStatusList.iterator(); iter.hasNext();) {
				IStatus newStatus = iter.next();
				object.addStatus(newStatus);
			}
		}
	}

	/**
	 * Returns true if the an existing status on the object should be kept because it is not related
	 * to this reporter.
	 * 
	 * @param value
	 *           an existing object status.
	 * @return true if it should be kept, false otherwise.
	 */
	protected boolean keepExistingStatus(IStatus value) {
		if (value == null || value == Status.OK_STATUS) {
			return false;
		}
		if (value instanceof IDeployPublishStatus) {
			return true;
		}
		if (groupID != null && value instanceof IDeployStatus) {
			IDeployStatus dStatus = (IDeployStatus) value;
			String statusGID = dStatus.getValidatorGroupID();
			if (statusGID == null) {
				statusGID = IConstants.DEFAULT_VALIDATOR_GROUP_ID;
			}
			if (!groupID.equals(statusGID)) {
				return true;
			}
		}
		// Accept all other non IDeployStatus status.
		return !(value instanceof IDeployStatus);
	}
}
