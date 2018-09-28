/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.EndPointListenerNameEnum;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasEndPointListenerConfigurationUnitValidator extends ConfigurationUnitValidator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasEndpointListenerUnit();
	}

	public WasEndPointListenerConfigurationUnitValidator() {
		super(WasPackage.eINSTANCE.getWasEndpointListenerUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasEndpointListenerConfiguration(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasJ2EEServer(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_ENDPOINT_LISTENER_URLROOT_EMPTY_001,
				WasPackage.Literals.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT, IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_ENDPOINT_LISTENER_WSDLURLROOT_EMPTY_001,
				WasPackage.Literals.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT, IStatus.ERROR));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		WasEndpointListenerConfiguration endCap = (WasEndpointListenerConfiguration) ValidatorUtils
				.getCapability(unit, WasPackage.eINSTANCE.getWasEndpointListenerConfiguration());

		String httpUrlRootPostFix1 = "wsgwsoaphttp1";//$NON-NLS-1$
		String httpUrlRootPostFix2 = "wsgwsoaphttp2"; //$NON-NLS-1$
		String wsdlUrlRootPostFix1 = "sibws";//$NON-NLS-1$
		String wsdljmsUrlRootPreFix1 = "jms";//$NON-NLS-1$

		if (endCap.getWsdlUrlRoot() != null) {

			if (!endCap.getWsdlUrlRoot().endsWith(wsdlUrlRootPostFix1)) {

				IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
						IStatus.ERROR,
						IWasValidatorID.WAS_ENDPOINT_LISTENER_WSDLURLROOT_ATTR_INVALID_001, endCap,
						WasPackage.eINSTANCE.getWasEndpointListenerConfiguration_WsdlUrlRoot());

				reporter.addStatus(message);

			}

		}

		if (endCap.getEndpointListenerName().getLiteral().equals(
				EndPointListenerNameEnum.SOAPHTTP_CHANNEL1_LITERAL.getLiteral())) {

			if (endCap.getUrlRoot() != null) {

				if (!(endCap.getUrlRoot().endsWith(httpUrlRootPostFix1))) {

					IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
							IStatus.ERROR, IWasValidatorID.WAS_ENDPOINT_LISTENER_URLROOT_ATTR_INVALID_001,
							endCap, WasPackage.eINSTANCE.getWasEndpointListenerConfiguration_UrlRoot());
					reporter.addStatus(message);

				}
			}

		} else if (endCap.getEndpointListenerName().getLiteral().equals(
				EndPointListenerNameEnum.SOAPHTTP_CHANNEL2_LITERAL.getLiteral())) {

			if (endCap.getUrlRoot() != null) {

				if (!endCap.getUrlRoot().endsWith(httpUrlRootPostFix2)) {

					IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
							IStatus.ERROR, IWasValidatorID.WAS_ENDPOINT_LISTENER_URLROOT_ATTR_INVALID_001,
							endCap, WasPackage.eINSTANCE.getWasEndpointListenerConfiguration_UrlRoot());
					reporter.addStatus(message);

				}
			}
		} else {

			if (endCap.getUrlRoot() != null) {

				if (!(endCap.getUrlRoot().startsWith(wsdljmsUrlRootPreFix1))) {

					IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
							IStatus.ERROR, IWasValidatorID.WAS_ENDPOINT_LISTENER_URLROOT_ATTR_INVALID_001,
							endCap, WasPackage.eINSTANCE.getWasEndpointListenerConfiguration_UrlRoot());
					reporter.addStatus(message);

				}
			}

		}

	}

}
