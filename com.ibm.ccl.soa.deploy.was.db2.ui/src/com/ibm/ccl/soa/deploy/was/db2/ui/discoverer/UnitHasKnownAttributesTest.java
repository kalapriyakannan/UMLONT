/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.discoverer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * Filter test to be used on results from a discoverer to ensure that the units returned all have a
 * specific set of mutable attributes.
 */
public class UnitHasKnownAttributesTest implements IDiscoveryResultFilterTest {

	/** list of attributes that may need to be matched */
	private final EAttribute[] mutableAttributes;

	/** values of those attributes */
	private final Object[] values;

	/** capability containing the attributes */
	private final EClass capabilityEClass;

	/**
	 * Constructor
	 * 
	 * @param capabilityEClass
	 *           EClass of capability containing the mutable attributes
	 * @param mutableAttributes
	 *           array of attributes that must be mutable
	 * @param values
	 *           array of attribute values (if the attribute is immutable)
	 */
	public UnitHasKnownAttributesTest(EClass capabilityEClass, EAttribute[] mutableAttributes,
			Object[] values) {
		this.capabilityEClass = capabilityEClass;
		this.mutableAttributes = mutableAttributes;
		this.values = values;
	}

	public boolean isUnitOK(Unit unit) {
		if (null == unit)
			return false;
		Capability capability = ValidatorUtils.getFirstCapability(unit, capabilityEClass);
		if (null == capability)
			return false;

		return doAttributesMatch(capability, mutableAttributes, values);
	}

	/**
	 * Determine if all of the specified attributes match the desired values.
	 * 
	 * @param capability
	 *           the capability with the attibutes
	 * @param attributes
	 *           the list of attributes
	 * @param values
	 *           the corresponding list of values
	 * @return true if all match, false otherwise
	 */
	private boolean doAttributesMatch(Capability capability, EAttribute[] attributes, Object[] values) {
		if (attributes.length != values.length)
			return false;

		for (int i = 0; i < attributes.length; i++) {
			EAttribute attribute = attributes[i];
			if (null == attribute)
				return false;
			String attributeName = attribute.getName();
			if (null == attributeName)
				return false;

			if (!attributeValueMatches(capability, attributeName, values[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determine if an attribute has a particular value.
	 * 
	 * @param capability
	 *           the capability with the attribute
	 * @param attributeName
	 *           the attribute name
	 * @param value
	 *           attribute value; null means don't care
	 * @return true if value is null or the attribute has the value
	 */
	private boolean attributeValueMatches(Capability capability, String attributeName, Object value) {
		if (null == value)
			return true;
		return value.equals(CapabilityUtil.getValue(capability, attributeName));
	}

}
