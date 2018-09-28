/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that the attribute of a {@link Capability} is unique in the <em>host</em> of its
 * {@link Unit}.
 * <p>
 * Example: assert that v1 != v2
 * 
 * <pre>
 * +------------------+    +------------------+
 * | Cap1: Capability |    | Cap2: Capability |
 * +------------------+    +------------------+
 * | attribute a = v1 |    | attribute a = v2 |
 * +------------------+    +------------------+
 *       &circ;                           &circ;
 *       | Capabilities              | Capabilities
 * +------------------+    +------------------+
 * | Container1: Unit |    | Container2: Unit |
 * +------------------+    +------------------+
 *       &circ;                              &circ;
 *       | HostingLink                  | HostingLink
 * +------------------+                 |
 * | host: Unit       |-----------------+
 * +------------------+
 * </pre>
 */
public class CapabilityAttributeUniqueInHostValidator extends DeployAttributeValidator {

	/**
	 * Construct a capability attribute unique in host validator.
	 * 
	 * @param validatorID
	 *           the validator ID.
	 * @param attribute
	 *           the capability attribute validated.
	 */
	public CapabilityAttributeUniqueInHostValidator(String validatorID, EAttribute attribute) {
		super(validatorID, attribute);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(attribute.getEContainingClass());
	}

	/**
	 * Validates that the attribute of the {@link Capability} is unique in the context its
	 * {@link Unit} host.
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
		Unit containerUnit = (Unit) cap.getParent();
		if (top == null || containerUnit == null) {
			return;
		}

		// Discover host
		Unit hostUnit = TopologyDiscovererService.INSTANCE.findHost(containerUnit, containerUnit
				.getTopology());
		if (hostUnit == null) {
			return;
		}

		// Discover peer units with a capability of the same type
		List hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE.findHosted(hostUnit,
				top);
		for (Iterator iter = hostedByHostUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hostedUnitDescriptor = (UnitDescriptor) iter.next();
			if (hostedUnitDescriptor == null) {
				return;
			}
			Unit hostedUnit = hostedUnitDescriptor.getUnitValue();
			if (hostedUnit == null) {
				continue;
			}

			Collection<DeployModelObject> realizationColl = RealizationLinkUtil
					.getAllImplicitRealizationLinkedObjects(cap);

			for (Iterator iter2 = hostedUnit.getCapabilities().iterator(); iter2.hasNext();) {
				Capability peer = (Capability) iter2.next();
				if (peer == cap || realizationColl.contains(peer)) {
					continue;
				}
				if (!appliesTo(peer, context)) {
					continue;
				}
				if (attribute.getEContainingClass().isInstance(peer)) {
					Object peerValue = peer.getEObject().eGet(attribute);
					boolean conflict = false;
					if (value != null && peerValue != null) {
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
										IStatus.ERROR,
										validatorID,
										ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
										DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_not_unique_in_the_context_of_2,
										new Object[] { cap, attribute.getName(), hostUnit }, cap,
										getFullAttributeName());
						reporter.addStatus(status);
						// Report at most one such conflict
						break;
					}
				}
			}
		}
	}
}
