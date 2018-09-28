/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that an attribute of e deploy model object is not (not-null).
 * <p>
 * To validate the existance of a non-null {@link RequirementExpression} use
 * {@link DeployRequirementAttributeNotNullValidator}.
 */
public class DeployAttributeStringNotEmptyValidator extends DeployAttributeValidator {

	protected int severity;

	/**
	 * Construct a validator that an attribute is non-null.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attribute
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployAttributeStringNotEmptyValidator(String validatorID, EAttribute attribute,
			int severity) {
		super(validatorID, attribute);
		if (!String.class.equals(attribute.getEAttributeType().getInstanceClass())) {
			throw new IllegalArgumentException(DeployNLS.bind(
					DeployCoreMessages.Attribute_0_type_1_not_a_subtype_of_2, new Object[] {
							attribute.getName(),
							attribute.getEAttributeType().getInstanceClass().getName(),
							String.class.getName() }));
		}
		this.severity = severity;
	}

	/**
	 * Construct a validator that an attribute is non-null.
	 * 
	 * @param validatorID
	 *           {@inheritDoc}
	 * @param attributeContainer
	 *           {@inheritDoc}
	 * @param attributeName
	 *           {@inheritDoc}
	 * @param severity
	 *           the {@link IStatus#getSeverity()} used when creating a status.
	 */
	public DeployAttributeStringNotEmptyValidator(String validatorID, EClass attributeContainer,
			String attributeName, int severity) {
		super(validatorID, attributeContainer, attributeName);
		this.severity = severity;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
//		Set<DeployModelObject> peerSet = RealizationLinkUtil
//				.getAllImplicitRealizationLinkedObjects(object);
//		for (Iterator<DeployModelObject> peers = peerSet.iterator(); peers.hasNext();) {
//			DeployModelObject peer = peers.next();
//			String value = (String) getAttributeValue(peer);
//			if (value != null && value.length() != 0) {
//				return;
//			}
//		}
//		// no peer provided a value
//		super.reportAttributeUndefinedStatus(severity, object, context, reporter);
		String value = (String) getAttributeValue(object);
		if (value == null || value.length() == 0) {
			super.reportAttributeUndefinedStatus(severity, object, context, reporter);
		}
	}

}
