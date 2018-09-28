/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.text.NumberFormat;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Abstract base class for all atribute value constraints.
 */
public abstract class AttributeValueConstraintValidator extends ConstraintValidator {

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		AttributeValueConstraint theConstraint = (AttributeValueConstraint) constraint;

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(theConstraint);
		}
		if (!(context instanceof Capability || context instanceof Unit)) {
			return ConstraintUtil.createInvalidContextStatus(theConstraint, context);
		}

		if (theConstraint.getAttributeName() == null
				|| theConstraint.getAttributeName().trim().length() == 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, theConstraint.eClass().getName(),
					ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Attribute_constraint_0_has_empty_attribute_name,
					new Object[] { title(constraint) }, constraint,
					"attributeName", Collections.singletonList(constraint)); //$NON-NLS-1$
			return status;
		}

		IDeployStatus[] astat = new IDeployStatus[1];
		EDataType aedt[] = new EDataType[1];
		Object attributeValue = getAttributeValue(theConstraint, context, astat, aedt);
		if (astat[0] != null) {
			return astat[0];
		}
		//5662: Invalid validation status for missing constrained values
		//If the attribute value is null and the target context's unit is conceptual
		//then it is not valid to ensure the constraint value must match.
		if (attributeValue == null) {
			Unit unit = context instanceof Capability ? (Unit) ((Capability) context).getParent()
					: (Unit) context;
			if (unit.isConceptual()) {
				return validateConceptualAttributeValue(attributeValue, aedt[0], theConstraint, context);
			}
		}
		return validateAttributeValue(attributeValue, aedt[0], theConstraint, context);
	}

	protected IStatus validateConceptualAttributeValue(Object attributeValue, EDataType dataType,
			AttributeValueConstraint theConstraint, DeployModelObject context) {
		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		AttributeValueConstraint theConstraint = (AttributeValueConstraint) constraint;

		if (context == null) {
			return ConstraintUtil.createNullContextStatus(theConstraint);
		}
		if (!(context instanceof Capability || context instanceof Unit)) {
			return ConstraintUtil.createInvalidContextStatus(theConstraint, context);
		}

		AttributeStatusInternal attributeStatus = getAttributeStatus(theConstraint, context);

		if (attributeStatus == AttributeStatusInternal.ATTRIBUTE_NOT_REFERRED) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					theConstraint.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
					DeployCoreMessages.Attribute_constraint_0_has_empty_attribute_name,
					new Object[] { title(constraint) }, constraint, Collections
							.singletonList(constraint));
			return status;
		}

		if (attributeStatus == AttributeStatusInternal.ATTRIBUTE_NOT_PRESENT) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					constraint.eClass().getName(),
					ICoreProblemType.ATTRIBUTE_CONSTRAINT_INVALID_ATTRIBUTE,
					DeployCoreMessages.Attribute_constraint_0_attribute_1_not_found_on_object_2,
					new Object[] { title(constraint), theConstraint.getAttributeName(), context },
					context, Collections.singletonList(constraint));
			return status;
		}

		if (DeployModelObjectUtil.isSettable(context, theConstraint.getAttributeName())) {
			// if attribute is mutable, we will be able to change it later
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// AT 2/29/2008: Jazz Defect 5569
		// if attribute is not mutable, is on a conceptual DMO, and is not set, it can later be realized by a DMO with a valid value 
		if (DeployModelObjectUtil.isConceptual(context)
				&& attributeStatus == AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// if it is not mutable, and is not conceotual, need to fully validate it 
		return validate(constraint, context, new NullProgressMonitor());
	}

	/**
	 * Validates attribute value against the constraint.
	 * 
	 * @param attributeValue
	 *           the value of the attribute
	 * @param edt
	 *           EDataType of the attribute
	 * @param constraint
	 *           attribute value constraint
	 * @param context
	 *           context
	 * @return Istatus of the validation
	 */
	protected abstract IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context);

	/**
	 * Get value of whatever is on the left side of the operatator.
	 * 
	 * @param constraint
	 * @param context
	 * @param astat
	 * @param aedt
	 * @return the value of the attribute
	 */
	protected Object getAttributeValue(AttributeValueConstraint constraint,
			DeployModelObject context, IDeployStatus[] astat, EDataType[] aedt) {
		assert constraint != null;
		assert constraint.getAttributeName() != null;

		EStructuralFeature esf = context.eClass()
				.getEStructuralFeature(constraint.getAttributeName());
		if (esf instanceof EAttribute) {
			EAttribute attribute = (EAttribute) esf;
			aedt[0] = attribute.getEAttributeType();
			if (context.eIsSet(attribute)) {
				return context.eGet(attribute);
			} else {
				Class clazz = aedt[0].getInstanceClass();
				if (clazz != null && clazz.isPrimitive()) {
					//Get the default primitive value if not set.
					return context.eGet(attribute);
				}
			}
			return null;
		}

		// it may be Extended Attribute
		ExtendedAttribute ea = context.getExtendedAttribute(constraint.getAttributeName());
		if (ea != null) {
			if (ea.getInstanceType() != null) {
				aedt[0] = ea.getInstanceType();
				return ea.getValue();
			} else {
				astat[0] = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						constraint.eClass().getName(),
						ICoreProblemType.ATTRIBUTE_CONSTRAINT_EXTENDED_ATTRIBUTE_HAS_NO_TYPE,
						DeployCoreMessages.Extended_attribute_0_has_no_instance_type_on_object_1,
						new Object[] { constraint.getAttributeName(), title(constraint) }, context,
						Collections.singletonList((Constraint) constraint));
				return null;
			}
		}

		// ooops, we don't have such attribute
		astat[0] = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint
				.eClass().getName(), ICoreProblemType.ATTRIBUTE_CONSTRAINT_INVALID_ATTRIBUTE,
				DeployCoreMessages.Attribute_constraint_0_attribute_1_not_found_on_object_2,
				new Object[] { title(constraint), constraint.getAttributeName(), context }, context,
				Collections.singletonList((Constraint) constraint));
		return null;
	}

	/**
	 * Returns the value of the right type. It CAN NOT return empty string "", always will return
	 * null.
	 * 
	 * @param raw
	 *           string representation of the value.
	 * @param type
	 *           type of the value.
	 * @return value, as instance of corresponding Java class
	 */
	protected Object getValueFromString(String raw, EDataType type) {
		if (raw == null || raw.trim().equals("")) { //$NON-NLS-1$
			return null;
		}
		Object value = null;
		try {
			value = EcoreUtil.createFromString(type, raw.trim());
		} catch (Exception e) {
			ConvertedValue cValue = ConvertedValue.parse(raw, type);
			value = cValue.deconvert();
		}
		return value;
	}

	/**
	 * Checks equality of two objects. Gives special treatment to Strings: trims them and treats
	 * empty string and null object as equal objects.
	 * 
	 * @param o1
	 *           object 1
	 * @param o2
	 *           object 2
	 * @return true ro false
	 */
	protected boolean checkEquality(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null || o2 instanceof String && ((String) o2).trim().equals(""); //$NON-NLS-1$
		}
		if (o2 == null) {
			return o1 == null || o1 instanceof String && ((String) o1).trim().equals(""); //$NON-NLS-1$
		}

		// neither o1 or o2 are null
		if (o1 instanceof String) {
			if (o2 instanceof String) {
				return ((String) o1).trim().equals(((String) o2).trim());
			} else {
				return false;
			}
		}
		return o1.equals(o2);
	}

	protected IDeployStatus generateGenericMismatchStatus(AttributeValueConstraint constraint,
			DeployModelObject context, Object attributeValue) {

		int severity;
		if (DeployModelObjectUtil.isConceptual(context)) {
			severity = IStatus.WARNING;
		} else {
			severity = IStatus.ERROR;
		}

		if (attributeValue instanceof Number) {
			attributeValue = NumberFormat.getNumberInstance().format(attributeValue);
		}

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus(
						severity,
						constraint.eClass().getName(),
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Attribute_constraint_0_not_satisfied_by_target_attribute_1_value_2_of_object_3,
						new Object[] { title(constraint), constraint.getAttributeName(), attributeValue,
								context }, context, constraint.getAttributeName(), Collections
								.singletonList((Constraint) constraint));
		return status;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// no child constraints allowed
		return null;
	}

	/**
	 * Check if the AttributeValueConstraint constraints an attribute and whether this attribute is
	 * present in the context and is set.
	 * 
	 * @param constraint
	 *           Attribute Value Constraint
	 * @param context
	 *           context DMO
	 * @return attribute status
	 */
	private static AttributeStatusInternal getAttributeStatus(AttributeValueConstraint constraint,
			DeployModelObject context) {
		assert constraint != null;
		assert context != null;

		if (constraint.getAttributeName() == null
				|| constraint.getAttributeName().trim().length() == 0) {
			// the AVC does not refer to attribute
			return AttributeStatusInternal.ATTRIBUTE_NOT_REFERRED;
		}

		EStructuralFeature esf = context.eClass()
				.getEStructuralFeature(constraint.getAttributeName());
		if (esf instanceof EAttribute) {
			if (context.eIsSet(esf)) {
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
			}
			return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
		}

		// try extended atribute
		ExtendedAttribute ea = context.getExtendedAttribute(constraint.getAttributeName());
		if (ea != null) {
			if (ea.getValue() == null) {
				return AttributeStatusInternal.ATTRIBUTE_PRESENT_BUT_NOT_SET;
			}
			return AttributeStatusInternal.ATTRIBUTE_PRESENT_AND_SET;
		}
		return AttributeStatusInternal.ATTRIBUTE_NOT_PRESENT; // did not find this attribute
	}

	private static class AttributeStatusInternal {

		private final int _status;

		private AttributeStatusInternal(int i) {
			_status = i;
		}

		private static AttributeStatusInternal ATTRIBUTE_NOT_REFERRED = new AttributeStatusInternal(1);
		private static AttributeStatusInternal ATTRIBUTE_NOT_PRESENT = new AttributeStatusInternal(2);
		private static AttributeStatusInternal ATTRIBUTE_PRESENT_BUT_NOT_SET = new AttributeStatusInternal(
				3);
		private static AttributeStatusInternal ATTRIBUTE_PRESENT_AND_SET = new AttributeStatusInternal(
				4);
	}
}
