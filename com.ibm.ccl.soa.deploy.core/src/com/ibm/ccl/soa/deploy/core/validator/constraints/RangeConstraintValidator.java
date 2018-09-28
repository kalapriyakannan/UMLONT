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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'RangeConstraint' constrait type.
 */
public class RangeConstraintValidator extends AttributeValueConstraintValidator implements
		IAttributeConstraintSolver {

	/**
	 * Unicode 'less than or equals'.
	 */
	private static final String LESS_THAN_EQUALS = new Character((char) 8804).toString();

	/**
	 * Unicode 'infinity'.
	 */
	private static final String INFINITY = new Character((char) 8734).toString();

	/**
	 * Validates attribute value against the constraint.
	 * 
	 * @param attributeValue
	 *           the value of the attribute
	 * @param edt
	 *           EDataType of the attribute
	 * @return Istatus of the validation
	 */
	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		RangeConstraint theConstraint = (RangeConstraint) constraint;

		assert edt != null;

		// validate String attributes differently
		if (edt.getInstanceClass().equals(String.class)) {
			return validateStringLength((String) attributeValue, theConstraint, context);
		}

		// null of not minValue is specified
		Object minValue = null;
		// null ifi no maxvalue is specified
		Object maxValue = null;

		if (theConstraint.getMinValue() != null && theConstraint.getMinValue().trim().length() > 0) {
			try {
				minValue = getValueFromString(theConstraint.getMinValue().trim(), edt);
			} catch (Exception e) {
				return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
			}
		}
		if (theConstraint.getMaxValue() != null && theConstraint.getMaxValue().trim().length() > 0) {
			try {
				maxValue = getValueFromString(theConstraint.getMaxValue().trim(), edt);
			} catch (Exception e) {
				return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
			}
		}

		if (attributeValue == null) {
			if (minValue == null && maxValue == null) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			} else {
				return generateGenericMismatchStatus(constraint, context, attributeValue);
			}
		}

		// Comparable
		if (attributeValue instanceof Comparable) {
			Comparable compAttrValue = (Comparable) attributeValue;

			if (minValue != null) {
				int comparison = compAttrValue.compareTo(minValue);
				if (!theConstraint.isMinValueInclusive() && comparison <= 0
						|| theConstraint.isMinValueInclusive() && comparison < 0) {
					return generateGenericMismatchStatus(constraint, context, attributeValue);
				}
			}

			if (maxValue != null) {
				int comparison = compAttrValue.compareTo(maxValue);
				if (!theConstraint.isMaxValueInclusive() && comparison >= 0
						|| theConstraint.isMaxValueInclusive() && comparison > 0) {
					return generateGenericMismatchStatus(constraint, context, attributeValue);
				}
			}
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// AbstractEnumerator
		if (attributeValue instanceof AbstractEnumerator) {
			int intAttrValue = ((AbstractEnumerator) attributeValue).getValue();

			if (minValue != null) {
				int intMinValue = ((AbstractEnumerator) minValue).getValue();
				if (!theConstraint.isMinValueInclusive() && intAttrValue <= intMinValue
						|| theConstraint.isMinValueInclusive() && intAttrValue < intMinValue) {
					return generateGenericMismatchStatus(constraint, context, attributeValue);
				}
			}

			if (maxValue != null) {
				int intMaxValue = ((AbstractEnumerator) maxValue).getValue();
				if (!theConstraint.isMaxValueInclusive() && intAttrValue >= intMaxValue
						|| theConstraint.isMaxValueInclusive() && intAttrValue > intMaxValue) {
					return generateGenericMismatchStatus(constraint, context, attributeValue);
				}
			}
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// return OK if min = value = max
		if (attributeValue.equals(minValue) && attributeValue.equals(maxValue)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// attribute type is not comparable, the context does not make sense
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, theConstraint
				.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
				DeployCoreMessages.Range_constraint_0_on_object_1_attribute_not_comparable,
				new Object[] { title(constraint), context }, constraint, Collections
						.singletonList((Constraint) constraint));
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof RangeConstraint) {
			return true;
		}
		return false;
	}

	public String title(Constraint constraint) {
		RangeConstraint rc = (RangeConstraint) constraint;
		StringBuffer sb = new StringBuffer();

		if ((rc.getMinValue() == null || rc.getMinValue().trim().equals("")) //$NON-NLS-1$
				&& (rc.getMaxValue() == null || rc.getMaxValue().trim().equals(""))) { //$NON-NLS-1$
			// unrestricted value
			sb.append('-');
			sb.append(INFINITY);
			sb.append(' ');
			sb.append('<');
			sb.append(' ');
			sb.append(rc.getAttributeName());
			sb.append(' ');
			sb.append('<');
			sb.append(' ');
			sb.append(INFINITY);
			return sb.toString();
		}

		if (rc.getMinValue() != null && !rc.getMinValue().trim().equals("")) { //$NON-NLS-1$
			sb.append(rc.getMinValue().trim());
			sb.append(' ');
			if (rc.isMinValueInclusive()) {
				sb.append(LESS_THAN_EQUALS);
			} else {
				sb.append('<');
			}
			sb.append(' ');
		}
		sb.append(getAttributeName(rc));
		if (rc.getMaxValue() != null && !rc.getMaxValue().trim().equals("")) { //$NON-NLS-1$
			sb.append(' ');
			if (rc.isMaxValueInclusive()) {
				sb.append(LESS_THAN_EQUALS);
			} else {
				sb.append('<');
			}
			sb.append(' ');
			sb.append(rc.getMaxValue().trim());
		}
		return sb.toString();
	}

	/**
	 * @param length
	 *           length of the string
	 * @param theConstraint
	 *           RangeConstraint
	 * @return status of the validation
	 */
	private IDeployStatus validateStringLength(String str, RangeConstraint theConstraint,
			DeployModelObject context) {
		int length = str == null ? 0 : str.length();
		String minValue = theConstraint.getMinValue();
		if (minValue != null && minValue.trim().length() > 0) {
			int min = 0;
			try {
				min = Integer.parseInt(minValue.trim());
			} catch (NumberFormatException ex) {
				return ConstraintUtil.generateConstraintMalformedStatus(theConstraint, context);
			}
			if (theConstraint.isMinValueInclusive() && length < min
					|| !theConstraint.isMinValueInclusive() && length <= min) {
				return generateGenericMismatchStatus(theConstraint, context, str);
			}
		}

		String maxValue = theConstraint.getMaxValue();
		if (maxValue != null && maxValue.trim().length() > 0) {
			int max = 0;
			try {
				max = Integer.parseInt(maxValue.trim());
			} catch (NumberFormatException ex) {
				return ConstraintUtil.generateConstraintMalformedStatus(theConstraint, context);
			}
			if (theConstraint.isMaxValueInclusive() && length > max
					|| !theConstraint.isMaxValueInclusive() && length >= max) {
				return generateGenericMismatchStatus(theConstraint, context, str);
			}
		}

		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.IAttributeConstraintSolver#getAttributeValues(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      java.lang.Object, org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeValues getAttributeValues(Constraint constraint, Object context,
			EAttribute attribute) {
		if (!(constraint instanceof RangeConstraint)) {
			return new AttributeValues();
		}
		RangeConstraint rc = (RangeConstraint) constraint;

		if (attribute == null) {
			return new AttributeValues();
		}
		if (rc.getAttributeName() == null || !attribute.getName().equals(rc.getAttributeName())) {
			return new AttributeValues();

		}
		AttributeValues result = new AttributeValues();
		try {
			Comparable min = null;
			if (rc.getMinValue() != null) {
				min = (Comparable) super.getValueFromString(rc.getMinValue(), attribute
						.getEAttributeType());
			}
			Comparable max = null;
			if (rc.getMaxValue() != null) {
				max = (Comparable) super.getValueFromString(rc.getMaxValue(), attribute
						.getEAttributeType());
			}
			AttributeValuesRange range = new AttributeValuesRange(min, rc.isMinValueInclusive(), max,
					rc.isMaxValueInclusive());
			result.getValidRanges().add(range);
			result.setValidValuesExclusive(true);
			result.compactValidRanges();
		} catch (RuntimeException e) {
			// Parsing error
			result.getStatusList().add(
					DeployCorePlugin.createStatus(IStatus.ERROR, 0, e.getMessage(), e));
		}
		return result;
	}
}
