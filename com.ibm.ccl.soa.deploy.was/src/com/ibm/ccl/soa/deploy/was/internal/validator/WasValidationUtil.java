/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Static WAS validation utilities.
 * <p>
 * Enable users to navigate the cell models declaratively, without dealing with the types of
 * relationships that link the WAS units together.
 */
public final class WasValidationUtil {

	private WasValidationUtil() {
		// prevent instantiation
	}

	/**
	 * Returns the {@link WasNodeUnit} which provides the {@link WasCellUnit}.
	 * 
	 * @param cellUnit
	 *           a WAS cell unit (may be null).
	 * @return the WAS node unit providing the cell, or null if it cannot be found.
	 */
	public WasNodeUnit discoverWasNodeUnit(WasCellUnit cellUnit) {
		if (cellUnit == null) {
			return null;
		}
		// Cells are hosted on the nodes
		Unit host = ValidatorUtils.discoverHost(cellUnit, null);
		if (host instanceof WasNodeUnit) {
			return (WasNodeUnit) host;
		}
		return null;
	}

	/**
	 * Returns the {@link WasSystemUnit} on which the {@link WasNodeUnit} is hosted.
	 * 
	 * @param nodeUnit
	 *           a WAS Node unit (may be null).
	 * @return the WAS system hosting the node, or null if it cannot be found.
	 */
	public WasSystemUnit discoverWasSystemUnit(WasNodeUnit nodeUnit) {
		if (nodeUnit == null) {
			return null;
		}
		// Nodes are hosted on systems
		Unit host = ValidatorUtils.discoverHost(nodeUnit, null);
		if (host instanceof WasSystemUnit) {
			return (WasSystemUnit) host;
		}
		return null;
	}

	/**
	 * Returns the {@link WasNodeUnit} which provides the {@link WasWebServerUnit}.
	 * 
	 * @param webServerUnit
	 *           a WAS Web Server unit (may be null).
	 * @return the WAS node unit providing the web server, or null if it cannot be found.
	 */
	public WasNodeUnit discoverWasNodeUnit(WasWebServerUnit webServerUnit) {
		if (webServerUnit == null) {
			return null;
		}
		// Currently web servers are grouped in a node
		return (WasNodeUnit) ValidatorUtils.discoverGroupByUnitType(webServerUnit,
				WasPackage.Literals.WAS_NODE_UNIT, null);
	}

	/**
	 * Returns the {@link WasNodeUnit} which provides the {@link WebsphereAppServerUnit}.
	 * 
	 * @param appServerUnit
	 *           a WAS Application Server unit (may be null)
	 * @return the WAS node unit providing the app server, or null if it cannot be found.
	 */
	public WasNodeUnit discoverWasNodeUnit(WebsphereAppServerUnit appServerUnit) {
		if (appServerUnit == null) {
			return null;
		}
		// Currently app servers are grouped in a node
		return (WasNodeUnit) ValidatorUtils.discoverGroupByUnitType(appServerUnit,
				WasPackage.Literals.WAS_NODE_UNIT, null);
	}

	/**
	 * Returns the {@link WasSystemUnit} on which the {@link WasWebServer} is indirectly provided.
	 * 
	 * @param webServerUnit
	 *           a WAS Web Server unit (may be null).
	 * @return the WAS system indirectly providing the web server, or null if it cannot be found.
	 */
	public WasSystemUnit discoverWasSystemUnit(WasWebServerUnit webServerUnit) {
		if (webServerUnit == null) {
			return null;
		}
		return discoverWasSystemUnit(discoverWasNodeUnit(webServerUnit));
	}

	/**
	 * Returns the {@link WasSystemUnit} on which the {@link WebsphereAppServerUnit} is indirectly
	 * provided.
	 * 
	 * @param appServerUnit
	 *           a WAS App Server unit (may be null).
	 * @return the WAS system indirectly providing the app server, or null if it cannot be found.
	 */
	public WasSystemUnit discoverWasSystemUnit(WebsphereAppServerUnit appServerUnit) {
		if (appServerUnit == null) {
			return null;
		}
		return discoverWasSystemUnit(discoverWasNodeUnit(appServerUnit));
	}
}
