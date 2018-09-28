/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.waswebplugin.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginAdmin;
import com.ibm.ccl.soa.deploy.was.WasPluginRedirection;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerManagement;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * Static utilities for validating {@link WaswebpluginPackage} objects.
 */
public final class WaswebpluginValidatorUtil {

	private WaswebpluginValidatorUtil() {
		// prevent instantiation
	}

	/**
	 * Discovers the {@link WasPluginRedirection} capability that is indirectly hosted on the
	 * {@link IhsSystem} unit.
	 * 
	 * @param system
	 *           an IHS system capability.
	 * @return the redirection capability or null if not found.
	 */
	public static WasPluginRedirection discoverWasPluginRedirection(IhsSystem system) {
		if (system == null || !(system.getParent() instanceof IhsSystemUnit)) {
			return null;
		}
		return discoverWasPluginRedirection((IhsSystemUnit) system.getParent());
	}

	/**
	 * Discovers the {@link WasPluginRedirection} capability that is indirectly hosted on the
	 * {@link IhsSystemUnit}.
	 * 
	 * @param system
	 *           an IHS system unit.
	 * @return the redirection capability or null if not found.
	 */
	public static WasPluginRedirection discoverWasPluginRedirection(IhsSystemUnit unit) {
		// WasPluginRedirection <-hosted- WasServer <-hosted- WasSystem
		List unitList = ValidatorUtils.discoverHostedWithCapability(unit, WasPackage.eINSTANCE
				.getWasPluginRedirection(), true, null);
		if (unitList.size() > 0) {
			return (WasPluginRedirection) ValidatorUtils.getFirstCapability((Unit) unitList.get(0),
					WasPackage.eINSTANCE.getWasPluginRedirection());

		}
		return null;
	}

	/**
	 * Discovers the {@link WasPluginAdmin} capability that is indirectly hosted on the
	 * {@link IhsSystem} unit.
	 * 
	 * @param system
	 *           an IHS system capability.
	 * @return the redirection capability or null if not found.
	 */
	public static WasPluginAdmin discoverWasPluginAdmin(IhsSystem system) {
		if (system == null || !(system.getParent() instanceof IhsSystemUnit)) {
			return null;
		}
		return discoverWasPluginAdmin((IhsSystemUnit) system.getParent());
	}

	/**
	 * Discovers the {@link WasPluginAdmin} capability that is indirectly hosted on the
	 * {@link IhsSystemUnit}.
	 * 
	 * @param system
	 *           an IHS system unit.
	 * @return the redirection capability or null if not found.
	 */
	public static WasPluginAdmin discoverWasPluginAdmin(IhsSystemUnit unit) {
		// WasPluginAdmin <-hosted- WasServer <-hosted- WasSystem
		List unitList = ValidatorUtils.discoverHostedWithCapability(unit, WasPackage.eINSTANCE
				.getWasPluginAdmin(), true, null);
		if (unitList.size() > 0) {
			return (WasPluginAdmin) ValidatorUtils.getFirstCapability((Unit) unitList.get(0),
					WasPackage.eINSTANCE.getWasPluginAdmin());

		}
		return null;
	}

	/**
	 * Discover the first {@link WasWebServer} that depends on the on the redirection module.
	 * 
	 * @param redirect
	 *           a WAS IHS plugin redirection module.
	 * @return the first web server, or null if not found.
	 */
	public static WasWebServer[] discoverWasWebServers(WasPluginRedirection redirect) {
		if (redirect == null || !(redirect.getParent() instanceof Unit)) {
			return null;
		}
		List resultList = new ArrayList();
		List unitDescriptorList = TopologyDiscovererService.INSTANCE.findSources((Unit) redirect
				.getParent(), redirect, redirect.getEditTopology());
		for (Iterator iter = unitDescriptorList.iterator(); iter.hasNext();) {
			UnitDescriptor descr = (UnitDescriptor) iter.next();
			Unit sourceUnit = descr.getUnitValue();
			WasWebServer webServer = (WasWebServer) ValidatorUtils.getFirstCapability(sourceUnit,
					WasPackage.eINSTANCE.getWasWebServer());
			if (webServer != null) {
				resultList.add(webServer);
			}
		}
		return (WasWebServer[]) resultList.toArray(new WasWebServer[resultList.size()]);
	}

	/**
	 * Discover the first {@link WasWebServerManagement} that depends on the on the admin module.
	 * 
	 * @param redirect
	 *           a WAS IHS plugin redirection module.
	 * @return the first web server, or null if not found.
	 */
	public static WasWebServerManagement[] discoverWasWebServerManagement(WasPluginAdmin redirect) {
		if (redirect == null || !(redirect.getParent() instanceof Unit)) {
			return null;
		}
		List resultList = new ArrayList();
		List unitDescriptorList = TopologyDiscovererService.INSTANCE.findSources((Unit) redirect
				.getParent(), redirect, redirect.getTopology());
		for (Iterator iter = unitDescriptorList.iterator(); iter.hasNext();) {
			UnitDescriptor descr = (UnitDescriptor) iter.next();
			Unit sourceUnit = descr.getUnitValue();
			WasWebServerManagement webServerMgmt = (WasWebServerManagement) ValidatorUtils
					.getFirstCapability(sourceUnit, WasPackage.eINSTANCE.getWasWebServerManagement());
			if (webServerMgmt != null) {
				resultList.add(webServerMgmt);
			}
		}
		return (WasWebServerManagement[]) resultList.toArray(new WasWebServerManagement[resultList
				.size()]);
	}

	/**
	 * Discover the first {@link WasWebServer} that depends on the on the admin module.
	 * 
	 * @param admin
	 *           a WAS IHS plugin admin module.
	 * @return the first web server, or null if not found.
	 */
	public static WasWebServer[] discoverWasWebServers(WasPluginAdmin admin) {
		if (admin == null || !(admin.getParent() instanceof Unit)) {
			return null;
		}
		List resultList = new ArrayList();
		List unitDescriptorList = TopologyDiscovererService.INSTANCE.findSources((Unit) admin
				.getParent(), admin, admin.getTopology());
		for (Iterator iter = unitDescriptorList.iterator(); iter.hasNext();) {
			UnitDescriptor descr = (UnitDescriptor) iter.next();
			Unit sourceUnit = descr.getUnitValue();
			WasWebServer webServer = (WasWebServer) ValidatorUtils.getFirstCapability(sourceUnit,
					WasPackage.eINSTANCE.getWasWebServer());
			if (webServer != null) {
				resultList.add(webServer);
			}
		}
		return (WasWebServer[]) resultList.toArray(new WasWebServer[resultList.size()]);
	}
}
