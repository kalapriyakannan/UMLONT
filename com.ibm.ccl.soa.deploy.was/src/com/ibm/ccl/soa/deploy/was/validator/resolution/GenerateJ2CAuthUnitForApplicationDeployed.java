/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class GenerateJ2CAuthUnitForApplicationDeployed extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// TODO: remove use of bindings for passing parameters; use attributes on DeployStatus
		Object[] bindings = context.getDeployStatus().getBindings();
		assert bindings != null && bindings.length > 2;
		assert bindings[0] instanceof String;
		String aliasName = (String) bindings[0];
		assert bindings[1] != null;
		assert bindings[1] instanceof WasCellUnit;
		assert bindings[2] != null;
		assert bindings[2] instanceof Requirement;
		return new IDeployResolution[] { new CreateGenerateAndInsertJ2CAuthUnitIntoCellScopeResolution(
				context, this, aliasName, (Unit) bindings[1], (Requirement) bindings[2]) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!IWasValidatorID.VALIDAT_WAS_APP_S_MISSING_J2CAUTHEN_REQ.equals(context.getDeployStatus()
				.getValidatorID())) {
			return false;
		}

		// TODO: remove use of bindings for passing parameters; use attributes on DeployStatus
		Object[] bindings = context.getDeployStatus().getBindings();
		if (bindings[1] == null || !(bindings[1] instanceof WasCellUnit)) {
			return false;
		}
		if (bindings[2] == null || !(bindings[2] instanceof Requirement)) {
			return false;
		}

		// check that resolution can do what it needs to do:
		// (a) create authentication unit
		// (b) host authentication unit on cell unit
		// (c) create link to authentication unit

		// (a) create authentication unit
		// can always do this in edit topology

		// (b) host authentication unit on cell unit
		// cell unit must be public
		if (!((WasCellUnit) bindings[1]).isPublic()) {
			return false;
		}
		// (c) create link to authentication unit
		// source unit requirement must be public
		if (!((Requirement) bindings[2]).isPublic()) {
			return false;
		}

		return true;
	}

	private static class CreateGenerateAndInsertJ2CAuthUnitIntoCellScopeResolution extends
			DeployResolution {
		private final String _alias;
		private final Unit _cellUnit;
		private final Requirement _req;

		public CreateGenerateAndInsertJ2CAuthUnitIntoCellScopeResolution(
				IDeployResolutionContext context, IDeployResolutionGenerator generator, String alias,
				Unit cellUnit, Requirement req) {
			super(context, generator, WasDomainMessages.Resolution_create_required_authentication_unit);
			_alias = alias;
			_cellUnit = cellUnit;
			_req = req;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			String templateId = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT;
			WASJ2CAuthenticationUnit j2cAuthUnit = (WASJ2CAuthenticationUnit) ResolutionUtils
					.addFromTemplate(templateId, _cellUnit.getEditTopology());
			WASJ2CAuthenticationDataEntry j2cAuthData = (WASJ2CAuthenticationDataEntry) ValidatorUtils
					.getCapability(j2cAuthUnit, WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY);
			assert j2cAuthData != null;
			j2cAuthData.setAlias(_alias);
			j2cAuthUnit
					.setDescription(WasDomainMessages.Resolution_create_required_authentication_unit_description);
			ResolutionUtils.hosts(context, _cellUnit, j2cAuthUnit);
			ResolutionUtils.link(context, _req, j2cAuthData);
			return Status.OK_STATUS;
		}

	}

}
