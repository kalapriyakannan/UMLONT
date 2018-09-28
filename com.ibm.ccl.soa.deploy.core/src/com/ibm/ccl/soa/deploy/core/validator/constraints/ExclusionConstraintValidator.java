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
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

/**
 * Validator to validate 'ExclusionConstraint' constrait type.
 */
public class ExclusionConstraintValidator extends AttributeValueConstraintValidator {

	/**
	 * Unicode 'not in'.
	 */
	private static final String NOT_IN = new Character((char) 8713).toString();

	protected IStatus validateAttributeValue(Object attributeValue, EDataType edt,
			AttributeValueConstraint constraint, DeployModelObject context) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}

		ExclusionConstraint theConstraint = (ExclusionConstraint) constraint;

		Iterator iter = theConstraint.getValues().iterator();
		if (!iter.hasNext()) {
			// empty values list
			ConstraintUtil.generateConstraintMalformedStatus(theConstraint, context);
		}

		while (iter.hasNext()) {
			Object legalValue = null;
			try {
				legalValue = getValueFromString(((SingleValue) iter.next()).getValue(), edt);
			} catch (Exception e) {
				return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
			}
			if (checkEquality(attributeValue, legalValue)) {
				// TODO: produce more detailed message
				// a special status type associated with several possible values
				// need also new resolution for this
				return generateGenericMismatchStatus(constraint, context, attributeValue);
			}
		}
		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow to have child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof ExclusionConstraint) {
			return true;
		}
		return false;
	}

	public String title(Constraint constraint) {
		ExclusionConstraint ec = (ExclusionConstraint) constraint;
		StringBuffer b = new StringBuffer();
		b.append(getAttributeName(ec));
		b.append(' ');
		b.append(NOT_IN);
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
}
