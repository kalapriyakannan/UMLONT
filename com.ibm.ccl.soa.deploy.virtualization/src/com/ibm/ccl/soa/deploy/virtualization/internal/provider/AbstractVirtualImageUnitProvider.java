/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.virtualization.internal.provider;

import java.math.BigInteger;
import java.util.Comparator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPlugin;

/**
 * Abstract supertype of the Xen and VMware virtual image unit providers.
 */
public abstract class AbstractVirtualImageUnitProvider extends UnitProvider {

	/**
	 * Compares two string ignoring the case.
	 */
	protected static final Comparator<String> STRING_IGNORE_CASE_COMPARATOR = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return (s1).compareToIgnoreCase(s2);
		}
	};

	/**
	 * Trims a string of all whitespace.
	 * <p>
	 * This method is needed because {@link String#trim()} only removes spaces.
	 * 
	 * @param value
	 *            a string value.
	 * @return the string with the leading and tail whitespace removed.
	 */
	protected String trim(String value) {
		if (value == null) {
			return value;
		}
		int startIndex = 0;
		while (startIndex < value.length()) {
			if (!Character.isWhitespace(value.charAt(startIndex))) {
				break;
			}
			startIndex++;
		}
		if (startIndex == value.length()) {
			return ""; //$NON-NLS-1$
		}
		int endIndex = value.length();
		while ((endIndex > startIndex) && (endIndex > 0)) {
			if (!Character.isWhitespace(value.charAt(endIndex - 1))) {
				break;
			}
			endIndex--;
		}
		return value.substring(startIndex, endIndex);
	}

	/**
	 * Adds an extended attribute guessing the type of the value from the
	 * string.
	 * <p>
	 * The method will try to determine if the value is a boolean, integer, or
	 * float before defaulting to string.
	 * 
	 * @param object
	 *            the object to which the attribute will be added.
	 * @param name
	 *            the name of the attribute.
	 * @param value
	 *            the value of the attribute.
	 */
	protected void addExtendedAttribute(DeployModelObject object, String name,
			String value) {
		if (object == null) {
			return;
		}
		name = getValidAttributeName(object, name);
		if (name == null) {
			return;
		}
		EDataType type = null;
		Object cvalue = null;
		if (value == null) {
			type = XMLTypePackage.eINSTANCE.getString();
			cvalue = value;
		}

		if (type == null) {
			if ("TRUE".equalsIgnoreCase(value)) { //$NON-NLS-1$
				type = XMLTypePackage.eINSTANCE.getBoolean();
				cvalue = Boolean.TRUE;
			} else if ("FALSE".equalsIgnoreCase(value)) { //$NON-NLS-1$
				type = XMLTypePackage.eINSTANCE.getBoolean();
				cvalue = Boolean.FALSE;
			}
		}
		if ((type == null) && (value.indexOf('.') != -1)) {
			try {
				BigInteger i = new BigInteger(value);
				type = XMLTypePackage.eINSTANCE.getInteger();
				cvalue = i;
			} catch (NumberFormatException e) {
				// ignore fall back
			}
		}
		if ((type == null) && (value.indexOf('.') != -1)) {
			try {
				Double d = new Double(value);
				type = XMLTypePackage.eINSTANCE.getFloat();
				cvalue = d;
			} catch (NumberFormatException e) {
				// ignore fall back
			}
		}

		if (type == null) {
			type = XMLTypePackage.eINSTANCE.getString();
			cvalue = value;
		}

		ExtendedAttribute attr = DeployModelObjectUtil.createExtendedAttribute(
				object, name, type);
		attr.setValue(cvalue);
	}

	/**
	 * Adds an extended attribute to the object of string type.
	 * 
	 * @param object
	 *            the object to which the attribute will be added.
	 * @param name
	 *            the name of the attribute.
	 * @param value
	 *            the value of the attribute.
	 */
	protected void addExtendedStringAttribute(DeployModelObject object,
			String name, String value) {
		name = getValidAttributeName(object, name);
		if (name == null) {
			return;
		}
		ExtendedAttribute attr = DeployModelObjectUtil.createExtendedAttribute(
				object, name, XMLTypePackage.eINSTANCE.getString());
		attr.setValue(value);
	}

	/**
	 * Adds an extended attribute to the object of boolean type.
	 * 
	 * @param object
	 *            the object to which the attribute will be added.
	 * @param name
	 *            the name of the attribute.
	 * @param value
	 *            the string representation of the boolean value of the
	 *            attribute (TRUE, FALSE).
	 */
	protected void addExtendedBooleanAttribute(DeployModelObject object,
			String name, String value) {
		name = getValidAttributeName(object, name);
		if (name == null) {
			return;
		}
		ExtendedAttribute attr = DeployModelObjectUtil.createExtendedAttribute(
				object, name, XMLTypePackage.eINSTANCE.getBoolean());
		Boolean b = getBooleanValue(value);
		if (b != null) {
			attr.setValue(b);
		}
	}

	/**
	 * Returns a valid extended attribute name for the object.
	 * 
	 * @param object
	 *            a deploy object.
	 * @param defaultName
	 *            the prefix of the name to be used.
	 * @return a valid extended attribute name for the object.
	 */
	protected String getValidAttributeName(DeployModelObject object,
			String defaultName) {
		String name = "extended"; // $NON-NLS-1$
		if (defaultName != null) {
			char[] nameChars = defaultName.toCharArray();
			for (int i = 0; i < nameChars.length; i++) {
				char c = nameChars[i];
				if (!Character.isLetter(c) && !Character.isDigit(c)
						&& !Character.isWhitespace(c)) {
					nameChars[i] = '_';
				}
			}
			name = new String(nameChars);
		}
		if (object == null) {
			return name;
		}
		if (DeployModelObjectUtil.getAttribute(object, name) == null) {
			return name;
		}
		int count = 1;
		String nameWithCount = name + count;
		while (DeployModelObjectUtil.getAttribute(object, nameWithCount) != null) {
			count++;
			nameWithCount = name + count;
		}
		return nameWithCount;
	}

	/**
	 * Returns a boolean value for the specified string.
	 * 
	 * @param value
	 *            true or false case insensitive.
	 * @return TRUE, FALSE, or null.
	 */
	protected Boolean getBooleanValue(String value) {
		if (value == null) {
			return null;
		}
		if ("TRUE".equalsIgnoreCase(value)) { //$NON-NLS-1$
			return Boolean.TRUE;
		} else if ("FALSE".equalsIgnoreCase(value)) { //$NON-NLS-1$
			return Boolean.FALSE;
		}
		return null;
	}

	/**
	 * Returns a integer value for the specified string.
	 * 
	 * @param value
	 *            a string value containing an integer.
	 * @return the parsed number, or null if it could not be parsed.
	 */
	protected Integer getIntegerValue(String value) {
		if (value == null) {
			return null;
		}
		try {
			return Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Sets the value of an EAttribute to a big integer value parsed from a
	 * string.
	 * 
	 * @param object
	 *            a deploy object.
	 * @param attribute
	 *            a deploy object attribute.
	 * @param value
	 *            the string representation of the big integer.
	 * @return true if the value was set, false if it could not be parsed.
	 */
	protected boolean setBigInteger(DeployModelObject object,
			EAttribute attribute, String value) {
		try {
			BigInteger b = new BigInteger(value);
			object.getEObject().eSet(attribute, b);
			return true;
		} catch (NumberFormatException e) {
			VirtualizationPlugin.log(IStatus.WARNING, e);
			return false;
		}
	}

	/**
	 * Sets the value of an EAttribute to an integer value parsed from a string.
	 * 
	 * @param object
	 *            a deploy object.
	 * @param attribute
	 *            a deploy object attribute.
	 * @param value
	 *            the string representation of the integer.
	 * @return true if the value was set, false if it could not be parsed.
	 */
	protected boolean setInteger(DeployModelObject object,
			EAttribute attribute, String value) {
		try {
			Integer b = new Integer(value);
			object.getEObject().eSet(attribute, b);
			return true;
		} catch (NumberFormatException e) {
			VirtualizationPlugin.log(IStatus.WARNING, e);
			return false;
		}
	}

	/**
	 * Sets the value of an EAttribute to an long value parsed from a string.
	 * 
	 * @param object
	 *            a deploy object.
	 * @param attribute
	 *            a deploy object attribute.
	 * @param value
	 *            the string representation of the long integer.
	 * @return true if the value was set, false if it could not be parsed.
	 */
	protected boolean setLong(DeployModelObject object,
			EAttribute attribute, String value) {
		try {
			Long b = new Long(value);
			object.getEObject().eSet(attribute, b);
			return true;
		} catch (NumberFormatException e) {
			VirtualizationPlugin.log(IStatus.WARNING, e);
			return false;
		}
	}

	/**
	 * Sets the value of an EAttribute to a boolena value parsed from a string.
	 * 
	 * @param object
	 *            a deploy object.
	 * @param attribute
	 *            a deploy object attribute.
	 * @param value
	 *            the string representation of the integer.
	 * @return true if the value was set, false if it could not be parsed.
	 */
	protected boolean setBoolean(DeployModelObject object,
			EAttribute attribute, String value) {
		Boolean bool = getBooleanValue(value);
		if (bool != null) {
			object.getEObject().eSet(attribute, bool);
			return true;
		}
		return false;
	}
}
