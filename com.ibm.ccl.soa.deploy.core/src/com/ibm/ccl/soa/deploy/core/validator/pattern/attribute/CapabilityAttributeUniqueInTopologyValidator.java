/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that the attribute of a {@link Capability} is unique in the topology.
 * <p>
 * All other instances of the {@link Capability} in the topology are compared.
 */
public class CapabilityAttributeUniqueInTopologyValidator extends DeployAttributeValidator {

	protected int severity;

	/**
	 * Construct a capability attribute unique in host validator.
	 * 
	 * @param validatorID
	 *           the validator ID.
	 * @param attribute
	 *           the capability attribute validated.
	 * @param severity
	 *           the severity of the error.
	 */
	public CapabilityAttributeUniqueInTopologyValidator(String validatorID, EAttribute attribute,
			int severity) {
		super(validatorID, attribute);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(attribute.getEContainingClass());
		this.severity = severity;
	}

	/**
	 * Validates that the attribute of the {@link Capability} is unique in the topology.
	 * 
	 * @see IDeployValidationContext#findAllCapabilities(org.eclipse.emf.ecore.EClass)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator#validate(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Capability cap = (Capability) object;
		Object value = getAttributeValue(cap);
		Topology top = cap.getTopology();
		if (top == null) {
			return;
		}
		for (Iterator iter = context.findAllCapabilities(attribute.getEContainingClass()); iter
				.hasNext();) {
			Capability peer = (Capability) iter.next();
			if (peer == cap) {
				continue;
			}
			if (attribute.getEContainingClass().isInstance(peer)) {
				Object peerValue = peer.getEObject().eGet(attribute);
				boolean conflict = false;
				if ((value != null) && (peerValue != null)) {
					conflict = value.equals(peerValue);
				}

				if (conflict) {
					if (ValidatorUtils.dmoParentUnitsSameRealizationSet(peer, cap)) {
						conflict = false;
					}
				}

				if (conflict) {
					IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
							.createAttributeStatus(
									severity,
									validatorID,
									ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
									DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_not_unique_in_the_context_of_2,
									new Object[] { cap, attribute.getName(), top }, cap,
									getFullAttributeName());
					reporter.addStatus(status);
				}
			}
		}
	}
}
