/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.status;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.ObjectTypeFilter;

/**
 * An iterator over {@link IDeployStatus} supporting filtering for deploy status subtypes.
 */
public class DeployStatusIterator implements Iterator<IDeployStatus> {

	/**
	 * Filters instances of {@link IDeployStatus}.
	 * 
	 * @see FilterIterator
	 */
	public static final IObjectFilter DEPLOY_STATUS_FILTER = new ObjectTypeFilter(
			IDeployStatus.class, true);

	/** The wrapped iterator. */
	protected final Iterator<IDeployStatus> iterator;

	/**
	 * Construct an iterator over all deploy statuses of an object.
	 * 
	 * @see DeployModelObject#getStatus()
	 * 
	 * @param object
	 *           a deploy model object.
	 */
	public DeployStatusIterator(DeployModelObject object) {
		this(object.getStatus(), null);
	}

	/**
	 * Construct an iterator over all deploy status objects contained in a status.
	 * 
	 * @param status
	 *           an eclipse status.
	 */
	public DeployStatusIterator(IStatus status) {
		this(status, null);
	}

	/**
	 * Construct a deploy status iterator over all deploy status objects that are a subtype of the
	 * specified type.
	 * 
	 * @param object
	 *           a deploy object assocaited with status.
	 * @param statusType
	 *           the supertype of the deploy status returned.
	 */
	public DeployStatusIterator(DeployModelObject object, Class<?> statusType) {
		this(object.getStatus(), statusType);
	}

	/**
	 * Construct a deploy sttus iterator over all deploy status that are a subtype of the status
	 * type.
	 * 
	 * @param status
	 *           a status containing deploy statuses.
	 * @param statusType
	 *           the subtype of {@link IDeployStatus}.
	 */
	public DeployStatusIterator(IStatus status, Class<?> statusType) {
		IObjectFilter filter;
		if (statusType == null) {
			filter = DEPLOY_STATUS_FILTER;
		} else {
			if (!IDeployStatus.class.isAssignableFrom(statusType)) {
				throw new IllegalArgumentException(statusType.getName());
			}
			filter = new ObjectTypeFilter(statusType, true);
		}

		iterator = new FilterIterator<IStatus, IDeployStatus>(new StatusIterator(status), filter);
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return iterator.hasNext();
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public IDeployStatus next() {
		return iterator.next();
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		iterator.remove();
	}
}
