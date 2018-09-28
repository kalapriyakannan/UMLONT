/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidationActivePattern;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystem;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * A pattern for IHS WAS Plugin configuration on an IHS Server.
 * 
 * @see IhsWasPluginUnit
 * @see IhsSystemUnit
 * @see IhsServerUnit
 * @see IhsWasModuleUnit
 * @see IhsWasAdminModuleUnit
 */
public class IhsWasPluginConfigurationActivePattern extends DeployValidationActivePattern {

	protected static final String CONTENT_SERVICE_NAME_PREFIX = "IBMHTTPServer";//$NON-NLS-1$

	protected static final String ADMIN_SERVICE_NAME_PREFIX = "IBMHTTPAdministrator";//$NON-NLS-1$

	protected final IhsWasPluginUnit wasPluginUnit;

	protected Requirement ihsSystemReq;

	protected DependencyLink pluginToIhsLink;

	protected Unit ihsSystemUnit;

	protected IhsWasPlugin wasPlugin;

	protected Unit adminServerUnit;

	protected Unit contentServerUnit;

	protected Unit wasModuleUnit;

	protected Requirement contentPluginReq;

	protected DependencyLink contentPluginLink;

	protected Unit wasAdminModuleUnit;

	protected Requirement adminPluginReq;

	protected WindowsLocalService adminWindowsService;

	/**
	 * Constructs a pattern on the IHS WAS plugin and looks for it in the topology.
	 * 
	 * @param unit
	 *           the IHS WAS plugin unit.
	 */
	public IhsWasPluginConfigurationActivePattern(IhsWasPluginUnit unit) {
		assert unit != null;
		wasPluginUnit = unit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Requirement getAdminPluginReq() {
		return adminPluginReq;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Unit getAdminServerUnit() {
		return adminServerUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public WindowsLocalService getAdminWindowsService() {
		return adminWindowsService;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public DependencyLink getContentPluginLink() {
		return contentPluginLink;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Requirement getContentPluginReq() {
		return contentPluginReq;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Unit getContentServerUnit() {
		return contentServerUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Requirement getIhsSystemReq() {
		return ihsSystemReq;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Unit getIhsSystemUnit() {
		return ihsSystemUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public DependencyLink getPluginToIhsLink() {
		return pluginToIhsLink;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Unit getWasAdminModuleUnit() {
		return wasAdminModuleUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public IhsWasAdminModule getWasAdminModule() {
		if (wasAdminModuleUnit == null) {
			return null;
		}
		return (IhsWasAdminModule) ValidatorUtils.getFirstCapability(wasAdminModuleUnit,
				IhsPackage.eINSTANCE.getIhsWasAdminModule());
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public Unit getWasModuleUnit() {
		return wasModuleUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public IhsWasPlugin getWasPlugin() {
		return wasPlugin;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public IhsWasPluginUnit getWasPluginUnit() {
		return wasPluginUnit;
	}

	/**
	 * Clears the results of the last find.
	 */
	public void clear() {
		adminPluginReq = null;
		adminServerUnit = null;
		adminWindowsService = null;
		contentPluginLink = null;
		contentPluginReq = null;
		contentServerUnit = null;
		ihsSystemReq = null;
		ihsSystemUnit = null;
		pluginToIhsLink = null;
		wasAdminModuleUnit = null;
		wasModuleUnit = null;
		wasPlugin = null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IDeployValidationActivePattern#find(boolean,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus find(boolean fix, IProgressMonitor monitor) {
		clear();
		Topology top = wasPluginUnit.getEditTopology();
		if (top == null) {
			return FAIL_NO_FIX;
		}
		//
		// Find "key" capabilities/units
		//
		ihsSystemReq = ValidatorUtils.getFirstRequirement(wasPluginUnit, IhsPackage.eINSTANCE
				.getIhsSystem());
		if (ihsSystemReq == null) {
			return FAIL_NO_FIX;
		}

		pluginToIhsLink = ihsSystemReq.getLink();
		if (pluginToIhsLink == null || pluginToIhsLink.getTarget() == null) {
			if (!fix) {
				return FAIL_NO_FIX;
			}
			// Find IhsSystem hosted on the same OS
			Unit osUnit = ValidatorUtils.discoverHost(wasPluginUnit, null);
			if (osUnit == null) {
				return FAIL_NO_FIX;
			}
			List ihsSystemList = ValidatorUtils.discoverHostedCapabilities(osUnit,
					IhsPackage.eINSTANCE.getIhsSystem(), false, null);
			if (ihsSystemList.size() != 1) {
				return FAIL_NO_FIX;
			}
			if (pluginToIhsLink == null) {
				pluginToIhsLink = CoreFactory.eINSTANCE.createDependencyLink();
				pluginToIhsLink.setSource(ihsSystemReq);
				ihsSystemReq.setLink(pluginToIhsLink);
				UnitUtil.assignUniqueName(pluginToIhsLink);
			}
			pluginToIhsLink.setTarget((IhsSystem) ihsSystemList.get(0));
		}

		ihsSystemUnit = ValidatorUtils.getTargetUnit(pluginToIhsLink);
		if (ihsSystemUnit == null) {
			return FAIL_NO_FIX;
		}
		wasPlugin = (IhsWasPlugin) ValidatorUtils.getFirstCapability(wasPluginUnit,
				WaswebpluginPackage.eINSTANCE.getIhsWasPlugin());
		if (wasPlugin == null) {
			return FAIL_NO_FIX;
		}

		//
		// Find the content and administration HTTP servers: their only
		// distinguishing mark is the different Windows service names.
		//
		List serverUnitList = ValidatorUtils.discoverHostedWithCapability(ihsSystemUnit,
				IhsPackage.eINSTANCE.getIhsServer(), false, monitor);
		if (serverUnitList.size() != 2) {
			return FAIL_NO_FIX;
		}
		adminServerUnit = (Unit) serverUnitList.get(0);
		adminWindowsService = (WindowsLocalService) ValidatorUtils.getFirstCapability(
				adminServerUnit, OsPackage.eINSTANCE.getWindowsLocalService());
		if (adminWindowsService == null || adminWindowsService.getServiceName() == null) {
			return FAIL_NO_FIX;
		}

		if (adminWindowsService.getServiceName().startsWith(ADMIN_SERVICE_NAME_PREFIX)) {
			contentServerUnit = (Unit) serverUnitList.get(1);
		} else if (adminWindowsService.getServiceName().startsWith(CONTENT_SERVICE_NAME_PREFIX)) {
			contentServerUnit = adminServerUnit;
			adminServerUnit = (Unit) serverUnitList.get(1);
			adminWindowsService = (WindowsLocalService) ValidatorUtils.getFirstCapability(
					adminServerUnit, OsPackage.eINSTANCE.getWindowsLocalService());
		} else {
			return FAIL_NO_FIX;
		}

		//
		// Check {@link IhsWasModule} hosted on content redirection server
		//
		IStatus status = findHostedUnit(contentServerUnit, IhsPackage.eINSTANCE.getIhsWasModule(),
				"ihsWasModUnitTool.spec", fix);//$NON-NLS-1$
		if (!status.isOK()) {
			return status;
		}
		wasModuleUnit = ValidatorUtils.discoverHostedWithCapability(contentServerUnit,
				IhsPackage.eINSTANCE.getIhsWasModule(), false, monitor).get(0);

		//
		// Check content redirection dependency link
		//
		contentPluginReq = ValidatorUtils.getFirstRequirement(wasModuleUnit,
				WaswebpluginPackage.eINSTANCE.getIhsWasPlugin());
		status = super.findDependencyLink(contentPluginReq, wasPlugin, fix);
		if (!status.isOK()) {
			return status;
		}
		contentPluginLink = contentPluginReq.getLink();

		//
		// Check {@link IhsWasAdminModule} hosted on admin server
		//
		status = super.findHostedUnit(adminServerUnit, IhsPackage.eINSTANCE.getIhsWasAdminModule(),
				"ihsWasAdminModuleUnitTool.spec", fix);//$NON-NLS-1$
		if (!status.isOK()) {
			return status;
		}
		wasAdminModuleUnit = ValidatorUtils.discoverHostedWithCapability(adminServerUnit,
				IhsPackage.eINSTANCE.getIhsWasAdminModule(), false, null).get(0);

		//
		// Check admin dependency link
		//
		adminPluginReq = ValidatorUtils.getFirstRequirement(wasAdminModuleUnit,
				WaswebpluginPackage.eINSTANCE.getIhsWasPlugin());
		status = findDependencyLink(adminPluginReq, wasPlugin, fix);
		if (!status.isOK()) {
			return status;
		}

		return Status.OK_STATUS;
	}
}
