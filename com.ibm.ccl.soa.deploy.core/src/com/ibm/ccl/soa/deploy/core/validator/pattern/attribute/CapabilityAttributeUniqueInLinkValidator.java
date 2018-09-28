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
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that the attribute of a {@link Capability} is unique in the between other units that
 * are dependent on the same {@link Capability} through a {@link Requirement}.
 * <p>
 * Example: validates that <code>attr</code> is unique for all capabilities of type
 * <code>uniqueEClass</code> provided by units with a requirement with a dependency link to
 * <code>trgCap</code>
 * <pre>
 *   +------------------------+
 *   | trgCap : $uniqueEClass |
 *   |          (or subtype)  |
 *   +------------------------+
 *   | attr : EAttribute      |
 *   +------------------------+
 *                &circ;
 *          Capabilities
 *                |        
 *   +------------------------+
 *   | TrgUnit:  Unit         |
 *   +------------------------+
 *                |
 *           Requirements
 *                v
 *   +------------------------+                           +-----------------------+
 *   | trgReq: Requirement    |      +--------------+     | trgCap : $targetClass |
 *   | dmoEType=       | -----|DependencyLink|----&gt;|       (or subtype)    |
 *   |      $targetEClass     |      +--------------+     +-----------------------+
 *   |      (or subtype)      |                           |                       |
 *   +------------------------+                           +-----------------------+
 *           
 * </pre>
 */
public class CapabilityAttributeUniqueInLinkValidator extends DeployAttributeValidator {

	protected final EClass uniqueEClass;

	protected final EAttribute uniqueEAttribute;

	protected final EClass linkTargetEClass;

	protected EClass unitType = CorePackage.eINSTANCE.getUnit();

	/**
	 * Construct a capability attribute uniqueness validator.
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param uniqueEAttribute
	 *           the target capability attribute.
	 * @param linkTargetEClass
	 *           the source capability type (or supertype).
	 */
	public CapabilityAttributeUniqueInLinkValidator(String validatorID, EAttribute uniqueEAttribute,
			EClass linkTargetEClass) {
		this(validatorID, uniqueEAttribute.getEContainingClass(), uniqueEAttribute, linkTargetEClass);
	}

	/**
	 * Construct a capability attribute uniqueness validator.
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param uniqueEClass
	 *           the target capability type (or supertype).
	 * @param uniqueEAttribute
	 *           the target capability attribute.
	 * @param linkTargetEClass
	 *           the source capability type (or supertype).
	 */
	public CapabilityAttributeUniqueInLinkValidator(String validatorID, EClass uniqueEClass,
			EAttribute uniqueEAttribute, EClass linkTargetEClass) {
		super(validatorID, uniqueEAttribute);
		this.uniqueEClass = uniqueEClass;
		this.uniqueEAttribute = uniqueEAttribute;
		this.linkTargetEClass = linkTargetEClass;

		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(uniqueEClass);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(linkTargetEClass);
		assert uniqueEClass.getEAllAttributes().contains(uniqueEAttribute);
	}

	/**
	 * Validates the uniqueness of the capability.
	 * 
	 * @param object
	 *           the object whose attribute is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Capability cap = (Capability) object;
		Unit unit = (Unit) cap.getParent();
		validate(unit, cap, context, reporter);
	}

	/**
	 * Validates the propagation over the specified capability provided by the unit.
	 * 
	 * @param unit
	 *           the unit whose provided capability is the target of propagation.
	 * @param uniqueCap
	 *           the provided capability of the unit which is a subtype of the target EClass.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	public void validate(Unit unit, Capability uniqueCap, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert uniqueCap.getEObject().eClass().isSuperTypeOf(uniqueCap.getEObject().eClass());
		assert unit.getCapabilities().contains(uniqueCap);

		Requirement req = null;
		for (Iterator iter = unit.getRequirements().iterator(); iter.hasNext();) {
			Requirement curr = (Requirement) iter.next();
			if ((curr.getDmoEType() != null) && (linkTargetEClass.isSuperTypeOf(curr.getDmoEType()))) {
				req = curr;
			}
		}
		if (req == null) {
			// TODO -- warn of missing requirement?
			return;
		}

		Capability linkTargetCap = null;
		boolean isAmbiguous = false;
		if ((req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL)
				|| (req.getLinkType() == RequirementLinkTypes.ANY_LITERAL)) {
			Unit linkTargetUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, req
					.getDmoEType(), unit.getTopology());
			if (linkTargetUnit != null) {
				linkTargetCap = DeployValidatorUtils.findTargetCapability(req, unit, linkTargetUnit);
			}
		}

		if ((req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL)
				|| (req.getLinkType() == RequirementLinkTypes.ANY_LITERAL)) {
			if (unit.getTopology() != null) {

//				Unit[] hosts = unit.getTopology().findHosts(unit);
				Unit host = TopologyDiscovererService.INSTANCE.findHost(unit, unit.getTopology());
//				if ((hosts != null) && (hosts.length > 0)) {
				if (host != null) {
					for (Iterator iter = host.getHostingOrAnyCapabilities().iterator(); iter.hasNext();) {
						Capability curr = (Capability) iter.next();
						if (linkTargetEClass.isSuperTypeOf(curr.getEObject().eClass())) {
							if (linkTargetCap == null) {
								linkTargetCap = curr;
							} else {
								isAmbiguous = true;
							}
						}

					}
				}
			}
		}
		if ((linkTargetCap == null) || isAmbiguous) {
			// TODO -- issue warning?
			return;
		}
		Topology top = linkTargetCap.getTopology();
		if (top == null) {
			return;
		}
		Object value = uniqueCap.getEObject().eGet(uniqueEAttribute);

//		Requirement[] peerReqs = top.findDependentRequirements(linkTargetCap);
		List linkSourceUnitDescriptors = TopologyDiscovererService.INSTANCE.findSources(
				(Unit) linkTargetCap.getParent(), linkTargetCap, top);
//		for (int i = 0; i < peerReqs.length; i++) {
		for (Iterator iter = linkSourceUnitDescriptors.iterator(); iter.hasNext();) {

//			Unit peerUnit = (Unit) peerReqs[i].getParent();
			UnitDescriptor peerUnitDescriptor = (UnitDescriptor) iter.next();
			if (peerUnitDescriptor == null) {
				continue;
			}
			Unit peerUnit = peerUnitDescriptor.getUnitValue();
			if (peerUnit == null) {
				continue;
			}
			for (Iterator iter2 = peerUnit.getCapabilities().iterator(); iter2.hasNext();) {
				Capability peerCap = (Capability) iter2.next();
				if ((peerCap == uniqueCap) || (!uniqueEClass.isInstance(peerCap))) {
					continue;
				}
				Object peerValue = peerCap.getEObject().eGet(uniqueEAttribute);
				boolean conflict = false;
				if ((value != null) && (peerValue != null)) {
					conflict = value.equals(peerValue);
				}

				if (conflict) {
					if (ValidatorUtils.dmoParentUnitsSameRealizationSet(peerCap, uniqueCap)) {
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
									new Object[] { uniqueCap, attribute.getName(), linkTargetCap.getParent() },
									uniqueCap, getFullAttributeName());
					reporter.addStatus(status);
					// Report at most one uniqueness conflict.
					return;
				}
			}
		}
	}
}
