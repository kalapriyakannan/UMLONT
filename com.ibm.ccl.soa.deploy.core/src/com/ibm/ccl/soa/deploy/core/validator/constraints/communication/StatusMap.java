/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * A {@link Map <Constraint, IStatus>} mapping the status of a constraint to its status. Used to
 * keep track, for example, of child constraint statuses. For undocumented methods see {@link Map}.
 */
public class StatusMap {

	private final Map<Constraint, IStatus> _map = new HashMap<Constraint, IStatus>();

	/**
	 * Determine if all of the statuses in the {@link Map} are OK
	 * 
	 * @return true if all non-null and OK; false otherwise
	 */
	public boolean allOK() {
		for (Iterator<IStatus> sIt = _map.values().iterator(); sIt.hasNext();) {
			IStatus status = sIt.next();
			if (null != status && !status.isOK()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determine if any of the statuses in the map are OK
	 * 
	 * @return true if any are null or OK; false otherwise
	 */
	public boolean anyOK() {
		for (Iterator<IStatus> sIt = _map.values().iterator(); sIt.hasNext();) {
			IStatus status = sIt.next();
			if (null == status || status.isOK()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convert {@link StatusMap} to a {@link IStatus} containing all the statuses in the
	 * {@link StatusMap}. This may mean returning a {@link MultiStatus}.
	 * 
	 * @return status
	 */
	public IStatus getStatuses() {
		IStatus returnStatus = null;

		for (Iterator<Constraint> cIt = _map.keySet().iterator(); cIt.hasNext();) {
			Constraint childConstraint = cIt.next();
			IStatus status = _map.get(childConstraint);
			if (null != status && !status.isOK()) {
				returnStatus = ValidatorUtils.addStatus(returnStatus, status);
			}
		}

		if (null == returnStatus) {
			returnStatus = Status.OK_STATUS;
		}

		return returnStatus;
	}

	public void clear() {
		_map.clear();

	}

	public boolean containsKey(Constraint key) {
		return _map.containsKey(key);
	}

	public boolean containsValue(IStatus value) {
		return _map.containsValue(value);
	}

	public Set entrySet() {
		return _map.entrySet();
	}

	public IStatus get(Constraint key) {
		return _map.get(key);
	}

	public boolean isEmpty() {
		return _map.isEmpty();
	}

	public Set keySet() {
		return _map.keySet();
	}

	public IStatus put(Constraint key, IStatus value) {
		return _map.put(key, value);
	}

	public void putAll(StatusMap t) {
		for (Iterator<Constraint> it = _map.keySet().iterator(); it.hasNext();) {
			Constraint key = it.next();
			_map.put(key, t.get(key));
		}
	}

	public IStatus remove(Constraint key) {
		return _map.remove(key);
	}

	public int size() {
		return _map.size();
	}

	public Collection values() {
		return _map.values();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof StatusMap)) {
			return false;
		}
		return _map.equals(((StatusMap) obj)._map);
	}

	public int hashCode() {
		return _map.hashCode();
	}

}
