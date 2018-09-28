/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Utility class for validating the propagation of an attribute from the capability of a unit to the
 * capability of another unit.
 * <p>
 * The units may be linked via a requirement dependency link, or via a hosting link.
 * <p>
 * If the requirement is not consumed by the unit of the capability, but by one that is down the
 * stack, users may invoke {@link #setSearchInHostingStack(boolean)}.
 * 
 * <pre>
 * +------------------------+
 * | TrgCap : $targetEClass |
 * |          (or subtype)  |
 * +------------------------+
 * | EAttribute             |
 * +------------------------+
 *              &circ;
 *        Capabilities
 *              |        
 * +------------------------+
 * | TrgUnit:  Unit         |
 * +------------------------+
 *              |
 *         Requirements
 *              v
 * +------------------------+                           +-----------------------+
 * | TrgReq: Requirement    |      +--------------+     | SrcCap : $sourceClass |
 * | dmoEType=              | -----|DependencyLink|----&gt;|       (or subtype)    |
 * |      $sourceEClass     |      +--------------+     +-----------------------+
 * |      (or subtype)      |                           | EAttribute            |
 * +------------------------+                           +-----------------------+
 *     
 * </pre>
 */
public class CapabilityAttributeToAttributePropagationValidator extends DeployAttributeValidator {

	protected final EClass targetEClass;

	protected final EAttribute targetEAttribute;

	protected final EClass sourceEClass;

	protected final EAttribute sourceEAttribute;

	protected EClass unitType = CorePackage.eINSTANCE.getUnit();

	protected boolean ignoreHosting = true;

	protected boolean searchInHostingStack = false;

	/** Optional comparator to use instead of {@link Object#equals(Object)}. */
	protected final Comparator comparator;

	/**
	 * Construct a capability attribute validator where the expected value is propagated from
	 * provided capability linked to the unit provided capability.
	 * <p>
	 * The type of the target {@link Capability} is derived from
	 * {@link EAttribute#getEContainingClass()}
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param targetEAttribute
	 *           the target capability attribute.
	 * @param sourceEAttribute
	 *           the source capability attribute.
	 */
	public CapabilityAttributeToAttributePropagationValidator(String validatorID,
			EAttribute targetEAttribute, EAttribute sourceEAttribute) {
		this(validatorID, targetEAttribute.getEContainingClass(), targetEAttribute, sourceEAttribute
				.getEContainingClass(), sourceEAttribute);
	}

	/**
	 * Construct a capability attribute validator where the expected value is propagated from
	 * provided capability linked to the unit provided capability.
	 * <p>
	 * The type of the target {@link Capability} is derived from
	 * {@link EAttribute#getEContainingClass()}
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param targetEAttribute
	 *           the target capability attribute.
	 * @param sourceEAttribute
	 *           the source capability attribute.
	 * @param comparator
	 *           optional comparator used instead of {@link Object#equals(Object)} (may be null).
	 */
	public CapabilityAttributeToAttributePropagationValidator(String validatorID,
			EAttribute targetEAttribute, EAttribute sourceEAttribute, Comparator comparator) {
		this(validatorID, targetEAttribute.getEContainingClass(), targetEAttribute, sourceEAttribute
				.getEContainingClass(), sourceEAttribute, comparator);
	}

	/**
	 * Construct a capability attribute validator where the expected value is propagated from
	 * provided capability linked to the unit provided capability.
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param targetEClass
	 *           the target capability type (or supertype).
	 * @param targetEAttribute
	 *           the target capability attribute.
	 * @param sourceEClass
	 *           the source capability type (or supertype).
	 * @param sourceEAttribute
	 *           the source capability attribute.
	 */
	public CapabilityAttributeToAttributePropagationValidator(String validatorID,
			EClass targetEClass, EAttribute targetEAttribute, EClass sourceEClass,
			EAttribute sourceEAttribute) {
		this(validatorID, targetEClass, targetEAttribute, sourceEClass, sourceEAttribute, null);
	}

	/**
	 * Construct a capability attribute validator where the expected value is propagated from
	 * provided capability linked to the unit provided capability.
	 * 
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param targetEClass
	 *           the target capability type (or supertype).
	 * @param targetEAttribute
	 *           the target capability attribute.
	 * @param sourceEClass
	 *           the source capability type (or supertype).
	 * @param sourceEAttribute
	 *           the source capability attribute.
	 * @param comparator
	 *           optional comparator used instead of {@link Object#equals(Object)} (may be null).
	 */
	public CapabilityAttributeToAttributePropagationValidator(String validatorID,
			EClass targetEClass, EAttribute targetEAttribute, EClass sourceEClass,
			EAttribute sourceEAttribute, Comparator comparator) {
		super(validatorID, targetEAttribute);
		this.targetEClass = targetEClass;
		this.targetEAttribute = targetEAttribute;
		this.sourceEClass = sourceEClass;
		this.sourceEAttribute = sourceEAttribute;
		this.comparator = comparator;

		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(targetEClass);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(sourceEClass);
		assert targetEClass.getEAllAttributes().contains(targetEAttribute);
		assert sourceEClass.getEAllAttributes().contains(sourceEAttribute);
	}

	/**
	 * Validates the propagation of the capability attribute over the object.
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
		// TODO remove compatibility 
		if (object instanceof Capability) {
			Capability cap = (Capability) object;
			Unit unit = (Unit) cap.getParent();
			validate(unit, cap, context, reporter);
		} else if (object instanceof Unit) {
			Unit unit = (Unit) object;
			assert unitType.isSuperTypeOf(unit.getEObject().eClass());

			for (Iterator iter = unit.getCapabilities().iterator(); iter.hasNext();) {
				Capability target = (Capability) iter.next();
				if (targetEClass.isSuperTypeOf(target.getEObject().eClass())) {
					validate(unit, target, context, reporter);
				}
			}
		}
	}

	/**
	 * Configures the validator to look for a requirement of the matching type down the target unit's
	 * hosting stack.
	 * 
	 * @param search
	 *           true if the hosting stack should be search for the first matching requirement.
	 */
	public void setSearchInHostingStack(boolean search) {
		this.searchInHostingStack = search;
	}

	/**
	 * @return true if the hosting stack should be search for the first matching requirement.
	 */
	public boolean getSearchInHostingStack() {
		return searchInHostingStack;
	}

	/**
	 * Validates the propagation over the specified capability provided by the unit.
	 * 
	 * @param unit
	 *           the unit whose provided capability is the target of propagation.
	 * @param targetCap
	 *           the provided capability of the unit which is a subtype of the target EClass.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	public void validate(Unit unit, Capability targetCap, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert targetCap.getEObject().eClass().isSuperTypeOf(targetCap.getEObject().eClass());
		assert unit.getCapabilities().contains(targetCap);

		Requirement req = null;
		for (Iterator iter = unit.getRequirements().iterator(); iter.hasNext();) {
			Requirement curr = (Requirement) iter.next();
			if ((curr.getDmoEType() != null) && (curr.getDmoEType().isSuperTypeOf(sourceEClass))) {
				req = curr;
				break;
			}
		}

		if ((req == null) && (searchInHostingStack)) {
			Unit curUnit = unit;
			while ((req == null) && (curUnit != null) && (curUnit.getTopology() != null)) {
				Unit host = TopologyDiscovererService.INSTANCE.findHost(curUnit, curUnit.getTopology());

				if (host != null) {
					for (Iterator iter = host.getRequirements().iterator(); iter.hasNext();) {
						Requirement curReq = (Requirement) iter.next();
						if ((curReq.getDmoEType() != null)
								&& (sourceEClass.isSuperTypeOf(curReq.getDmoEType()))) {
							req = curReq;
							unit = host;
							break;
						}
					}
				}
				curUnit = host;
			}
		}

		if (req == null) {
			// TODO -- warn of missing requirement?
			return;
		}

		Capability sourceCap = null;
		boolean isAmbiguous = false;
		if ((req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL)
				|| (req.getLinkType() == RequirementLinkTypes.ANY_LITERAL)) {
			Unit linkTargetUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, req
					.getDmoEType(), unit.getTopology());
			if (linkTargetUnit != null) {
				sourceCap = DeployValidatorUtils.findTargetCapability(req, unit, linkTargetUnit);
			}
		}

		if ((req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL)
				|| (req.getLinkType() == RequirementLinkTypes.ANY_LITERAL)) {
			if (unit.getTopology() != null) {
				Unit host = TopologyDiscovererService.INSTANCE.findHost(unit, unit.getTopology());
				if (host != null) {
					for (Iterator iter = host.getHostingOrAnyCapabilities().iterator(); iter.hasNext();) {
						Capability curr = (Capability) iter.next();
						if (sourceEClass.isSuperTypeOf(curr.getEObject().eClass())) {
							if (sourceCap == null) {
								sourceCap = curr;
							} else {
								isAmbiguous = true;
							}
						}
					}
				}
			}
		}

		if ((sourceCap == null) || isAmbiguous) {
			// TODO -- issue warning?
			return;
		}

		Object sourceValue = sourceCap.getEObject().eGet(sourceEAttribute);
		boolean isSourceSet = sourceCap.getEObject().eIsSet(sourceEAttribute);
		Object targetValue = targetCap.getEObject().eGet(targetEAttribute);
		boolean isTargetSet = targetCap.getEObject().eIsSet(targetEAttribute);

		if ((sourceValue == null) || (!isSourceSet)) {
			if ((targetValue == null) || (!isTargetSet)) {
				// both are null or unset (users have to specify seperately if
				// the attribute is required)
			} else {
				IDeployAttributeValueSourceStatus status = DeployCoreStatusFactory.INSTANCE
						.createAttributeValueSourceStatus(
								IStatus.INFO,
								validatorID,
								ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
								DeployCoreMessages.Validator_deploy_model_object_0_propagated_attribute_1_cannot_validated_because_source_is_not_set,
								new Object[] { targetCap, attribute }, targetCap, attribute, sourceCap,
								sourceEAttribute);
				reporter.addStatus(status);
			}
		} else {
			int severity = IStatus.OK;
			if (comparator != null) {
				if (comparator.compare(sourceValue, targetValue) != 0) {
					severity = IStatus.ERROR;
				}
			} else if (!sourceValue.equals(targetValue)) {
				severity = IStatus.ERROR;
			}

			if (severity != IStatus.OK) {
				reporter.addStatus(DeployCoreStatusUtil.createAttributeInvalidSourceValueStatus(
						severity, validatorID, targetCap, targetEAttribute, sourceCap, sourceEAttribute));
			}
		}
	}
}
