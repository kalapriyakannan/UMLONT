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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Collects deploy status reports into a list.
 */
public class ListLogDeployReporter implements IDeployReporter {

	/**
	 * A list of statuses reported.
	 */
	protected final List<IDeployStatus> statusList = new ArrayList<IDeployStatus>();

	/**
	 * Optional validator group ID that will be set on reported statuses.
	 * 
	 * @see IDeployStatus#getValidatorGroupID()
	 */
	protected final String groupID;

	/**
	 * Construct a deploy reporter.
	 */
	public ListLogDeployReporter() {
		this(null);
	}

	/**
	 * Construct a deploy reporter which sets the group ID on reported statuses.
	 * 
	 * @param validatorGroupID
	 *           the group ID that will be set on reported statuses (null for none).
	 * @see IDeployStatus#getValidatorGroupID()
	 */
	public ListLogDeployReporter(String validatorGroupID) {
		groupID = validatorGroupID;
	}

	/**
	 * @return true if any of the reported statuses have error severity.
	 * @see IStatus#getSeverity()
	 * @see IStatus#ERRORa
	 */
	public boolean hasErrors() {
		for (IDeployStatus pStatus : getReportedStatusList()) {
			if (pStatus.getSeverity() == IStatus.ERROR) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the validator group ID that will be set on reported statuses (null for none).
	 * @see IDeployStatus#getValidatorGroupID()
	 */
	public String getValidatorGroupID() {
		return groupID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
	 */
	public void addStatus(IDeployStatus status) {
		if (status != null) {
			if (groupID != null && status instanceof DeployStatus) {
				((DeployStatus) status).setValidatorGroupID(groupID);
			}
			statusList.add(status);
		}
	}

	/**
	 * Returns the list of reported statuses.
	 * 
	 * @return List<IDeployStatus>
	 */
	public List<IDeployStatus> getReportedStatusList() {
		return statusList;
	}

	/**
	 * Adds the reported statuses into the topology in an edit transaction.
	 * 
	 * @param topology
	 *           a deploy topology.
	 * @param monitor
	 *           a progress monitor.
	 */
	public void addReportedInEditTransaction(Topology topology, IProgressMonitor monitor) {
		assert topology != null;
		assert monitor != null;

		//
		// Set up editing domain
		//
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(topology);
		assert editingDomain != null;

		//
		// Clear previously reported statuses with the same validator ID
		//
		if (groupID != null) {
			final Topology finalTop = topology;
			AbstractEMFOperation statusClearOperation = new AbstractEMFOperation(editingDomain,
					IConstants.EMPTY_STRING) {
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
					ValidatorUtils.clearTopologyStatus(finalTop, new IObjectFilter<IDeployStatus>() {
						public boolean accept(IDeployStatus status) {
							return status != null && groupID.equals(status.getValidatorGroupID());
						}
					});
					return Status.OK_STATUS;
				}
			};
			try {
				IProgressMonitor submonitor = new SubProgressMonitor(monitor, 1);
				statusClearOperation.execute(submonitor, null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		//
		// Add reported status objects.
		//
		if (!statusList.isEmpty()) {
			final List<IDeployStatus> finalStatusList = statusList;
			AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain,
					IConstants.EMPTY_STRING) {
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
					for (IDeployStatus status : finalStatusList) {
						if (monitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						status.getDeployObject().addStatus(status);
						monitor.worked(1);
					}
					monitor.done();
					return Status.OK_STATUS;
				}
			};
			try {
				IProgressMonitor submonitor = new SubProgressMonitor(monitor, finalStatusList.size());
				operation.execute(submonitor, null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
