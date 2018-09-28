/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Cache of a {@link Unit} and, optionally, a {@link Requirement}.
 */
public class UnitRequirement {

	private final Unit _unit;
	private final Requirement _req;

	/**
	 * Constructor: create a record of a unit
	 * 
	 * @param unit
	 *           the unit
	 */
	public UnitRequirement(Unit unit) {
		_unit = unit;
		_req = null;
	}

	/**
	 * Constructor: create record of {@link Unit}/{@link Requirement} pair
	 * 
	 * @param unit
	 *           the unit
	 * @param req
	 *           a requirement on the unit
	 */
	public UnitRequirement(Unit unit, Requirement req) {
		_unit = unit;
		_req = req;
	}

	/**
	 * Retrieve any {@link Unit}
	 * 
	 * @return unit
	 */
	public Unit getUnit() {
		return _unit;
	}

	/**
	 * Retrieve any {@link Requirement}
	 * 
	 * @return requirement
	 */
	public Requirement getRequirment() {
		return _req;
	}
}
