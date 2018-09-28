/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServer;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;

/**
 * Static IHS validation utility methods.
 */
public final class IhsValidatorUtil {

	private IhsValidatorUtil() {
		// prevent instantiation
	}

	/**
	 * Returns the {@link IhsSystem} capability for the unit.
	 * <p>
	 * Delegates to {@link #foo}
	 * 
	 * @param unit
	 *           a deployment unit .
	 * @return the hosting {@link IhsSystem} capability, or null if not found.
	 */
	public static IhsSystem discoverIhsSystem(Unit unit) {
		if (unit == null) {
			return null;
		}
		if (unit instanceof IhsServerUnit) {
			return discoverIhsSystem((IhsServerUnit) unit);
		}
		return (IhsSystem) ValidatorUtils.getFirstCapability(unit, IhsPackage.eINSTANCE
				.getIhsSystem());
	}

	/**
	 * Returns the {@link IhsSystem} capability for the IHS system hosting the {@link IhsServer}
	 * unit.
	 * 
	 * @param server
	 *           an IHS server capability instance (may be null).
	 * @return the hosting {@link IhsSystem} capability, or null if not found.
	 */
	public static IhsSystem discoverIhsSystem(IhsServer server) {
		return (IhsSystem) ValidatorUtils.discoverHostCapability(server, IhsPackage.eINSTANCE
				.getIhsSystem(), null);
	}

	/**
	 * Returns the {@link IhsSystem} capability for the IHS system hosting the {@link IhsServerUnit}.
	 * 
	 * @param serverUnit
	 *           an IHS server unit (may be null).
	 * @return the hosting {@link IhsSystem} capability, or null if not found.
	 */
	public static IhsSystem discoverIhsSystem(IhsServerUnit serverUnit) {
		return (IhsSystem) ValidatorUtils.discoverHostCapability(serverUnit, IhsPackage.eINSTANCE
				.getIhsSystem(), null);
	}

	/**
	 * Returns the {@link IhsSystemUnit} hosting the {@link IhsServer} unit.
	 * 
	 * @param server
	 *           an IHS server capability instance (may be null).
	 * @return the hosting {@link IhsSystem} capability, or null if not found.
	 */
	public static IhsSystemUnit discoverIhsSystemUnit(IhsServer server) {
		return (IhsSystemUnit) ValidatorUtils.discoverHost(server, IhsPackage.eINSTANCE
				.getIhsSystemUnit(), null);
	}

	/**
	 * Returns the {@link IhsSystemUnit} hosting the {@link IhsServerUnit} unit.
	 * 
	 * @param serverUnit
	 *           an IHS server unit (may be null).
	 * @return the hosting {@link IhsSystem} capability, or null if not found.
	 */
	public static IhsSystemUnit discoverIhsSystemUnit(IhsServerUnit serverUnit) {
		return (IhsSystemUnit) ValidatorUtils.discoverHost(serverUnit, IhsPackage.eINSTANCE
				.getIhsSystemUnit(), null);
	}

	/**
	 * Returns the port of the IHS redirection module..
	 * 
	 * @param server
	 *           an IHS server.
	 * @return the port of the IHS server.
	 */
	public static Port getPort(IhsServer server) {
		return OsValidatorUtils.getPort(server, null);
	}
}
