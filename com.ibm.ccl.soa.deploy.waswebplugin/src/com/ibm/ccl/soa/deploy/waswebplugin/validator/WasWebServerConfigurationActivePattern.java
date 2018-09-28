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

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidationActivePattern;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginAdmin;
import com.ibm.ccl.soa.deploy.was.WasPluginRedirection;
import com.ibm.ccl.soa.deploy.was.WasWebServerManagement;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;

/**
 * A pattern for the connection between a {@link WasWebServerUnit} and a {@link IhsWasPluginUnit}.
 */
public class WasWebServerConfigurationActivePattern extends DeployValidationActivePattern {

	protected final WasWebServerUnit wasWebServerUnit;

	protected final IhsWasPluginUnit ihsWasPluginUnit;

	protected IhsWasPluginConfigurationActivePattern ihsWasPluginConfigurationActivePattern;

	protected WasPluginRedirection wasPluginRedirection;

	protected WasPluginAdmin wasPluginAdmin;

	protected WasWebServerManagement wasWebServerManagement;

	/**
	 * Constructs a pattern on {@link WasWebServerUnit} configuration.
	 * 
	 * @param wasWebServer
	 *           the WAS WebServer unit.
	 * @param the
	 *           IHS WAS Plugin unit.
	 */
	public WasWebServerConfigurationActivePattern(WasWebServerUnit wasWebServer,
			IhsWasPluginUnit ihsWasPluginUnit) {
		assert wasWebServer != null;
		assert ihsWasPluginUnit != null;

		wasWebServerUnit = wasWebServer;
		this.ihsWasPluginUnit = ihsWasPluginUnit;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.IDeployValidationActivePattern#find(boolean,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus find(boolean fix, IProgressMonitor monitor) {
		clear();
		ihsWasPluginConfigurationActivePattern = new IhsWasPluginConfigurationActivePattern(
				ihsWasPluginUnit);
		IStatus status = ihsWasPluginConfigurationActivePattern.find(fix, monitor);
		if (!status.isOK()) {
			return status;
		}

		// Identify the WAS plugin capabilities which are targets of the
		// WebServer requirements.
		Requirement redirectReq = ValidatorUtils.getFirstRequirement(wasWebServerUnit,
				WasPackage.eINSTANCE.getWasPluginRedirection());
		if (redirectReq == null) {
			return FAIL_NO_FIX;
		}

		Requirement adminReq = ValidatorUtils.getFirstRequirement(wasWebServerUnit,
				WasPackage.eINSTANCE.getWasPluginAdmin());
		if (adminReq == null) {
			return FAIL_NO_FIX;
		}

		wasPluginRedirection = (WasPluginRedirection) ValidatorUtils.getFirstCapability(
				ihsWasPluginConfigurationActivePattern.getWasModuleUnit(), WasPackage.eINSTANCE
						.getWasPluginRedirection());
		status = findDependencyLink(redirectReq, wasPluginRedirection, fix);
		if (!status.isOK()) {
			return status;
		}

		wasPluginAdmin = (WasPluginAdmin) ValidatorUtils.getFirstCapability(
				ihsWasPluginConfigurationActivePattern.getWasAdminModuleUnit(), WasPackage.eINSTANCE
						.getWasPluginAdmin());
		status = findDependencyLink(adminReq, wasPluginAdmin, fix);
		if (!status.isOK()) {
			return status;
		}

		wasWebServerManagement = (WasWebServerManagement) ValidatorUtils.getFirstCapability(
				wasWebServerUnit, WasPackage.eINSTANCE.getWasWebServerManagement());
		if (wasWebServerManagement != null && wasWebServerManagement.isAutoConfigPropagation()) {
			// Was plugin admin must host user
			Unit pluginAdminUnit = (Unit) wasPluginAdmin.getParent();
			List users = ValidatorUtils.discoverHostedWithCapability(pluginAdminUnit,
					IhsPackage.eINSTANCE.getIhsUser(), false, monitor);
			if (users.size() == 0) {
				if (!fix) {
					return FAIL_HAS_FIX;
				}
				status = ResolutionUtils.hostTemplateUnit(pluginAdminUnit, "ihsUserUnitTool.spec");//$NON-NLS-1$
				if (!status.isOK()) {
					return status;
				}
				users = ValidatorUtils.discoverHostedWithCapability(pluginAdminUnit,
						IhsPackage.eINSTANCE.getIhsUser(), false, monitor);
			}
			if (fix) {
				if (users.size() == 1) {
					IhsUser user = (IhsUser) ValidatorUtils.getFirstCapability((Unit) users.get(0),
							IhsPackage.eINSTANCE.getIhsUser());
					if (user != null && user.getUserId() == null) {
						user.setUserId("ihsadmin");//$NON-NLS-1$
					}
				}
			}
		}

		return Status.OK_STATUS;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public IhsWasPluginConfigurationActivePattern getIhsWasPluginConfigurationActivePattern() {
		return ihsWasPluginConfigurationActivePattern;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public IhsWasPluginUnit getIhsWasPluginUnit() {
		return ihsWasPluginUnit;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public WasPluginAdmin getWasPluginAdmin() {
		return wasPluginAdmin;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public WasPluginRedirection getWasPluginRedirection() {
		return wasPluginRedirection;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public WasWebServerManagement getWasWebServerManagement() {
		return wasWebServerManagement;
	}

	/**
	 * @returns the unit matched by the last find.
	 */
	public WasWebServerUnit getWasWebServerUnit() {
		return wasWebServerUnit;
	}

	/**
	 * Clears the results of the last {@link find()}.
	 */
	public void clear() {
		ihsWasPluginConfigurationActivePattern = null;
		wasPluginRedirection = null;
		wasPluginAdmin = null;
		wasWebServerManagement = null;
	}

}
