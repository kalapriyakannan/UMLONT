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
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.ObjectTypeFilter;

/**
 * Recursively iterates over all {@link IStatus} objects on a {@link DeployModelObject}.
 * 
 * @see DeployModelObject#getStatus()
 */
public class StatusIterator implements Iterator<IStatus> {

	/**
	 * Filters instances of {@link IDeployStatus}.
	 * 
	 * @see FilterIterator
	 * @deprecated use {@link DeployStatusIterator}.
	 */
	public static final IObjectFilter DEPLOY_STATUS_FILTER = new ObjectTypeFilter(
			IDeployStatus.class, true);

	/** Next status to be returned. */
	protected IStatus next;

	/** Stack of pending statuses. */
	protected List<IStatus> stack = null;

	/**
	 * Construct an iterator over all status objects of a {@link DeployModelObject}.
	 * <p>
	 * A {@link DeployModelObject} has one {@link IStatus} object which may be a
	 * {@link IStatus#isMultiStatus()} and have {@link IStatus#getChildren()}.
	 * 
	 * @param obj
	 *           the deploy object which will be recursively iterated over.
	 */
	public StatusIterator(DeployModelObject obj) {
		this(obj.getStatus());
	}

	/**
	 * Construct an iterator over the status object and all its children (recursive).
	 * 
	 * @param status
	 *           the first status object returned.
	 */
	public StatusIterator(IStatus status) {
		this.next = status;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return next != null;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public IStatus next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		IStatus result = next;

		if (result.isMultiStatus()) {
			IStatus[] children = result.getChildren();
			if (children.length > 0) {
				if (stack == null) {
					stack = new LinkedList<IStatus>();
				}
				for (int i = 0; i < children.length; i++) {
					if (children[i] != null) {
						stack.add(children[i]);
					}
				}
			}
		}
		if ((stack != null) && (stack.size() > 0)) {
			next = stack.remove(0);
		} else {
			next = null;
		}

		return result;
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
