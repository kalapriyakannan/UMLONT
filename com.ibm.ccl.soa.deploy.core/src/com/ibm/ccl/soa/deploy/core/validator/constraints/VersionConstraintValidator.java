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

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

/**
 * Validator to validate 'VersionConstraint' constrait type.
 */
public class VersionConstraintValidator extends AttributeValueConstraintValidator {

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

		VersionConstraint theConstraint = (VersionConstraint) constraint;

		if (attributeValue == null) {
			return generateGenericMismatchStatus(constraint, context, attributeValue);
		}

		if (theConstraint.getValue() == null) {
			return ConstraintUtil.generateConstraintMalformedStatus(constraint, context);
		}

		String version = attributeValue.toString();
		String pattern = theConstraint.getValue().toString();

		if (interpString(pattern, version)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}
		return generateGenericMismatchStatus(constraint, context, attributeValue);
	}

	private boolean interpString(String pattern, String version) {
		String[] psections = makeSections(pattern);
		String[] vsections = makeSections(version);

		for (int i = 0; i < psections.length; i++) {
			// Does a further section end with '+'?
			boolean lookaheadPlus = false;
			for (int j = i + 1; j < psections.length; j++) {
				if (psections[j].endsWith("+")) { //$NON-NLS-1$
					lookaheadPlus = true;
					break;
				}
			}

			if (lookaheadPlus) {
				if (exceedsSection(psections[i], vsections[i])) {
					return true;
				}
			}

			if (!interpSection(psections[i], i < vsections.length ? vsections[i] : null)) {
				return false;
			}
		}

		return true;
	}

	private boolean interpSection(String pattern, String version /* , boolean plus */) {
		// pattern should be either 'x' or [digits]+ or [digits]+'+'
		if (pattern.equals("x")) { //$NON-NLS-1$
			return true;
		}

		if (pattern.endsWith("+")) { //$NON-NLS-1$
			return comparePlus(pattern.substring(0, pattern.length() - 1), version);
		}

		//		if (plus) {
		//			return comparePlus(pattern, version);
		//		}

		return compare(pattern, version);
	}

	/**
	 * Checks for versions definately exceeding, for example "1..." doesn't exceed 1.1+ but "2" does.
	 * 
	 * @param pattern
	 * @param version
	 * @return true if there is definate exceeding
	 */
	private boolean exceedsSection(String pattern, String version) {
		int verConstraint = digitsToVersion(pattern);
		if (verConstraint < 0) {
			return false;
		}

		// remove trailing letters
		version = stripTrailingNonDigits(version);

		if (version.length() == 0) {
			return false;
		}

		return Integer.parseInt(version) > verConstraint;
	}

	private boolean comparePlus(String digits, String version) {
		if (version == null) {
			return false;
		}

		int verConstraint = digitsToVersion(digits);
		if (verConstraint < 0) {
			return false;
		}

		// remove trailing letters
		version = stripTrailingNonDigits(version);

		if (version.length() == 0) {
			return false;
		}

		return Integer.parseInt(version) >= verConstraint;
	}

	private boolean compare(String digits, String version) {
		if (version == null) {
			return false;
		}

		int ver = digitsToVersion(digits);
		if (ver < 0) {
			return false;
		}

		// remove trailing letters
		version = stripTrailingNonDigits(version);

		if (version.length() == 0) {
			return false;
		}

		return Integer.parseInt(version) == ver;
	}

	private int digitsToVersion(String digits) {
		try {
			return Integer.parseInt(digits);
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	private String stripTrailingNonDigits(String version) {
		for (int i = 0; i < version.length(); i++) {
			if (!Character.isDigit(version.charAt(i))) {
				return version.substring(0, i);
			}
		}

		return version;
	}

	private String[] makeSections(String s) {
		List retVal = new LinkedList();
		StringTokenizer st = new StringTokenizer(s, "."); //$NON-NLS-1$
		while (st.hasMoreTokens()) {
			retVal.add(st.nextToken());
		}
		return (String[]) retVal.toArray(new String[0]);
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof VersionConstraint) {
			return true;
		}
		return false;
	}

	public String title(Constraint constraint) {
		VersionConstraint vc = (VersionConstraint) constraint;
		StringBuffer sb = new StringBuffer();
		sb.append("Version ("); //$NON-NLS-1$
		sb.append(getAttributeName(vc));
		sb.append(',');
		sb.append(' ');
		sb.append(vc.getValue());
		sb.append(')');
		return sb.toString();
	}
}
