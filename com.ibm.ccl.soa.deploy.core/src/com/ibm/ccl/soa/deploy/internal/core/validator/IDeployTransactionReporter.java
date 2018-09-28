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

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * A deploy reporter supporting transactional addition of statuses to their objects.
 */
public interface IDeployTransactionReporter extends IDeployReporter {

	/**
	 * Begins a transaction in which {@link #addStatus(IDeployStatus)} are logged.
	 * <p>
	 * If a transaction has already been started, the effects of this method will be to
	 * {@link #abortTransaction()} first.
	 * <p>
	 * It is safe to report statuses in the context of a transaction even if the an editing domain
	 * has not been obtained on the topology. No changes will be performed on the objects until
	 * {@link #commitTransaction()}.
	 * 
	 * @param topology
	 *           the topology over whose objects the validation errors will be reported.
	 * @param groupID
	 *           identifies the {@link IDeployStatus#getValidatorGroupID()} on existing object
	 *           statuses which will be cleared if not reported again a commit.
	 */
	void beginTransaction(Topology topology);

	/**
	 * Abort the status added in the course of the transaction.
	 * <p>
	 * Clears the contents of the transaction ({@link #getTransactionContents()}.
	 */
	void abortTransaction();

	/**
	 * Returns the topology of an active transaction.
	 * 
	 * @return the topology of an active transaction, or null if the transaction was not started, or
	 *         was aborted or committed.
	 */
	Topology getTransactionTopology();

	/**
	 * Returns a list of status objects reported since the last {@link #beginTransaction(Topology)}.
	 * <p>
	 * The list is cleared when {@link #abortTransaction()} or {@link #commitTransaction()} has been
	 * invoked.
	 * 
	 * @return a list of deploy statuses reported using
	 *         {@link IDeployReporter#addStatus(IDeployStatus)}.
	 */
	List<IDeployStatus> getTransactionContents();

	/**
	 * Commit the status added using {@link #addStatus(IDeployStatus)} since the last
	 * {@link #beginTransaction(Topology)}.
	 * <p>
	 * 
	 * <p>
	 * If an editing domain has not been associated with the topology, one will be created.
	 * 
	 * @return the status of the transaction commit.
	 */
	IStatus commitTransaction();
}
