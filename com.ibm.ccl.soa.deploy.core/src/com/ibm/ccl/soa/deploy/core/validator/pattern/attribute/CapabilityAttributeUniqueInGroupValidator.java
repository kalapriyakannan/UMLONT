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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that the attribute of a {@link Capability} is unique in the <em>group</em> of its
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
 *       | MemberLink                   | MemberLink
 * +------------------+                 |
 * | Group: Unit      |-----------------+
 * +------------------+
 * </pre>
 * 
 */
public class CapabilityAttributeUniqueInGroupValidator extends DeployAttributeValidator {
	protected final EClass memberUnitEClass;
	protected final EClass groupUnitEClass;

	/**
	 * Construct a capability attribute unique in group validator.
	 * 
	 * @param validatorID
	 *           the validator ID.
	 * @param memberUnitEClass
	 *           member Unit's EClass
	 * @param memberEAttribute
	 *           the capability attribute validated.
	 * @param groupUnitEClass
	 *           group Unit's EClass
	 */
	public CapabilityAttributeUniqueInGroupValidator(String validatorID, EClass memberUnitEClass,
			EAttribute memberEAttribute, EClass groupUnitEClass) {
		super(validatorID, memberEAttribute);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(
				memberEAttribute.getEContainingClass());
		this.memberUnitEClass = memberUnitEClass;
		this.groupUnitEClass = groupUnitEClass;
	}

	/**
	 * Validates that the attribute of the {@link Capability} is unique in the context its
	 * {@link Unit} groups.
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

		if ((top == null) || (containerUnit == null)) {
			return;
		}

		List inReqL = ValidatorUtils.getRequirements(containerUnit, groupUnitEClass);
		Requirement inReq = null;
		if (inReqL != null)
			if (inReqL.size() > 0)
				inReq = (Requirement) inReqL.get(0);
		if (inReq == null)
			return;

		List groupUnitDesL = TopologyDiscovererService.INSTANCE.getGroups(containerUnit, inReq,
				containerUnit.getTopology());
		if (groupUnitDesL == null) {
			return;
		}

		for (Iterator iter = groupUnitDesL.iterator(); iter.hasNext();) {
			UnitDescriptor groupUnitDescriptor = (UnitDescriptor) iter.next();
			if (groupUnitDescriptor == null)
				return;
			Unit groupUnit = groupUnitDescriptor.getUnitValue();
			if (groupUnit == null) {
				continue;
			}
			//check it unique in each group
			List outReqL = ValidatorUtils.getRequirements(groupUnit, memberUnitEClass);
			Requirement outReq = null;
			if (outReqL != null)
				if (outReqL.size() > 0)
					outReq = (Requirement) outReqL.get(0);
			if (outReq == null)
				continue;

			List groupedByGroupUnitDescriptors = TopologyDiscovererService.INSTANCE.getMembers(
					groupUnit, outReq, containerUnit.getTopology());

			for (Iterator iter2 = groupedByGroupUnitDescriptors.iterator(); iter2.hasNext();) {
				UnitDescriptor groupedUnitDescriptor = (UnitDescriptor) iter2.next();
				if (groupedUnitDescriptor == null) {
					continue;
				}
				Unit groupedUnit = groupedUnitDescriptor.getUnitValue();
				if (groupedUnit == null) {
					continue;
				}

				for (Iterator iter3 = groupedUnit.getCapabilities().iterator(); iter3.hasNext();) {
					Capability peer = (Capability) iter3.next();
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
											IStatus.ERROR,
											validatorID,
											ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
											DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_not_unique_in_the_context_of_2,
											new Object[] { cap, attribute.getName(), groupUnit }, cap,
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

}
