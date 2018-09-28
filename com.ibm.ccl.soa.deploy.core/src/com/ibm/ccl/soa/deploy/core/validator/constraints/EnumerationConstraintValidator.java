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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

/**
 * Validator to validate 'EnumerationConstraint' constrait type.
 */
public class EnumerationConstraintValidator extends AttributeValueConstraintValidator implements
		IAttributeConstraintSolver {

	/**
	 * Unicode 'isin', ELEMENT OF.
	 */
	private static final String IS_IN = new Character((char) 8712).toString();

	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		EnumerationConstraint theConstraint = (EnumerationConstraint) constraint;

		Iterator iter = theConstraint.getValues().iterator();
		if (!iter.hasNext()) {
			// empty values list
			return ConstraintUtil.generateConstraintMalformedStatus(theConstraint, context);
		}

		while (iter.hasNext()) {
			Object legalValue = null;
			try {
				legalValue = getValueFromString(((SingleValue) iter.next()).getValue(), edt);
			} catch (Exception e) {
				return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
			}
			if (checkEquality(attributeValue, legalValue)) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
		}

		// TODO: produce more detailed message
		// a special status type associated with several possible values
		// need also new resolution for this
		return generateGenericMismatchStatus(constraint, context, attributeValue);
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow to have child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof EnumerationConstraint) {
			return true;
		}
		return false;
	}

	public String title(Constraint constraint) {
		EnumerationConstraint ec = (EnumerationConstraint) constraint;
		StringBuffer b = new StringBuffer();
		b.append(getAttributeName(ec));
		b.append(' ');
		b.append(IS_IN);
		b.append(' ');
		b.append('{');
		for (Iterator iter = ec.getValues().iterator(); iter.hasNext();) {
			b.append(((SingleValue) iter.next()).getValue());
			if (iter.hasNext()) {
				b.append(',');
			}
		}
		b.append('}');
		return b.toString();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.constraints.IDeployConstraintAttributeValueSolver#getAttributeValues(com.ibm.ccl.soa.deploy.core.Constraint,
	 *      java.lang.Object, org.eclipse.emf.ecore.EAttribute)
	 */
	public AttributeValues getAttributeValues(Constraint constraint, Object context,
			EAttribute attribute) {
		if (!(constraint instanceof EnumerationConstraint)) {
			return new AttributeValues();
		}
		EnumerationConstraint ec = (EnumerationConstraint) constraint;
		if (attribute != null
				&& (ec.getAttributeName() == null || !attribute.getName().equals(ec.getAttributeName()))) {
			return new AttributeValues();
		}
		AttributeValues result = new AttributeValues();
		for (SingleValue value : (List<SingleValue>) ec.getValues()) {
			if (value != null) {
				result.getValidValues().add(value.getValueObject());
			}

		}
		result.setValidValuesExclusive(true);
		return result;
	}
}
