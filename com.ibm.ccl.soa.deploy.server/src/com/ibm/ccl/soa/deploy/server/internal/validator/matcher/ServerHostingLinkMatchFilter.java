/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.server.internal.validator.matcher;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.server.ServerDeployPlugin;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * Filter to disallow links - os hosting on server if there is already one hosted on the server.
 */
public class ServerHostingLinkMatchFilter extends LinkMatchFilter {

	private EClassifier osclass;
	private boolean osclassSet = false;

	@Override
	public IStatus canCreateLink(Unit host, Unit hostee) {
		if (!alreadyHosting(host, hostee)) {
			return DeployMatcherStatus.MATCH_NOT_REJECTED;
		}
		return new Status(IStatus.ERROR, ServerDeployPlugin.pluginID, 0,
				ServerMatcherMessages.AnotherOperatingSystemAlreadyHostedOnServer, null);
	}

	/**
	 * @param host
	 * @param hostee
	 * @return true if host is already hosting an installed operating system and
	 */
	// TODO make this consistent with ServerUnit validation.
	private boolean alreadyHosting(Unit host, Unit hostee) {
		// Operating system would not be uniquely hosted and operating system already present is in installed state.
		if (host instanceof ServerUnit) {
			for (Iterator<Unit> iter = ValidatorUtils.getHosted(host).iterator(); iter.hasNext();) {
				Unit hostedUnit = iter.next();
				if (hostedUnit == null) {
					continue;
				}

				if (hostedUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)
						&& isOperatingSystem(hostedUnit) && isOperatingSystem(hostee)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isOperatingSystem(Unit hostedUnit) {
		EClassifier classifier = getOperatingSystemEClass();
		if (classifier != null) {
			return classifier.isInstance(hostedUnit);
		}
		return false;
	}

	/*
	 * This is a back door hack because the server plugin cannot depend on the os plugin.
	 */
	private EClassifier getOperatingSystemEClass() {
		if (!osclassSet) {
			osclassSet = true;
			EPackage pack = EPackage.Registry.INSTANCE
					.getEPackage("http://www.ibm.com/ccl/soa/deploy/os/1.0.0/"); //$NON-NLS-1$
			if (pack != null) {
				osclass = pack.getEClassifier("OperatingSystemUnit"); //$NON-NLS-1$
			}
		}
		return osclass;
	}

}
