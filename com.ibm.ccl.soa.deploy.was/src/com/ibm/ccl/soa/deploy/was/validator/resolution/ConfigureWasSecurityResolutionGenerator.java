/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution Generator for resolution to configure security properties of a was server.
 */
public class ConfigureWasSecurityResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployStatus status = (DeployStatus) context.getDeployStatus();

		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		WebsphereAppServerUnit server = (WebsphereAppServerUnit) status.getDeployObject();

		String disabled = DeployNLS.bind(
				WasDomainMessages.Resolution_Configure_Was_Security_Disabled, new Object[] {});
		String usingOS = DeployNLS.bind(
				WasDomainMessages.Resolution_Configure_Was_Security_Enabled_0,
				new Object[] { WasUserRegistryTypes.OS_LITERAL });
		String usingLDAP = DeployNLS.bind(
				WasDomainMessages.Resolution_Configure_Was_Security_Enabled_0,
				new Object[] { WasUserRegistryTypes.LDAP_LITERAL });
		String usingCUSTOM = DeployNLS.bind(
				WasDomainMessages.Resolution_Configure_Was_Security_Enabled_0,
				new Object[] { WasUserRegistryTypes.CUSTOM_LITERAL });

		IDeployResolution[] resolutions = {
				new ConfigureWasSecurityResolution(context, this, disabled, server, false, null),
				new ConfigureWasSecurityResolution(context, this, usingOS, server, true,
						WasUserRegistryTypes.OS_LITERAL),
				new ConfigureWasSecurityResolution(context, this, usingLDAP, server, true,
						WasUserRegistryTypes.LDAP_LITERAL),
				new ConfigureWasSecurityResolution(context, this, usingCUSTOM, server, true,
						WasUserRegistryTypes.CUSTOM_LITERAL) };

		return resolutions;

	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		DeployStatus status = (DeployStatus) context.getDeployStatus();

		if (IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED.equals(status
				.getProblemType())) {
			DeployModelObject object = status.getDeployObject();
			if (WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(object.getEObject()
					.eClass())) {
				WebsphereAppServerUnit server = (WebsphereAppServerUnit) object;
				if (0 == ValidatorUtils.getCapabilities(server, WasPackage.Literals.WAS_SECURITY)
						.size()) {
					if (server.isPublic()) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
