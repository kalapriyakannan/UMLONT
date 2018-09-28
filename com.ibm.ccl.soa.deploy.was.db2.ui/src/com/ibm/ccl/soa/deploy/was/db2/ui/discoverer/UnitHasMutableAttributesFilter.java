/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.discoverer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;

/**
 * Filter to be used on results from a discoverer to ensure that the units returned all have a
 * specific set of mutable attributes.
 */
public class UnitHasMutableAttributesFilter implements IDiscoveryResultFilter {

	/** list of attributes that need to be immutable */
	private final EAttribute[] mutableAttributes;

	/**
	 * Constructor
	 * 
	 * @param mutableAttributes
	 *           array of attributes that must be mutable
	 */
	public UnitHasMutableAttributesFilter(EAttribute[] mutableAttributes) {
		this.mutableAttributes = mutableAttributes;
	}

	public List select(List unitDescriptors) {
		List filtered = new ArrayList();
		for (Iterator uIt = unitDescriptors.iterator(); uIt.hasNext();) {
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			Unit unit = ud.getUnitValue();
			if (unitHasMutableAttributes(unit)) {
				filtered.add(unit);
			}
		}
		return filtered;
	}

	private boolean unitHasMutableAttributes(Unit unit) {
		for (int i = 0; i < mutableAttributes.length; i++) {
			if (!isMutableAttribute(unit, mutableAttributes[i].getName()))
				return false;
		}
		return true;
	}

	private boolean isMutableAttribute(Unit unit, String attributeName) {
		if (null == unit)
			return false;
		if (null == attributeName)
			return false;

		if (!unit.isMutable())
			return false;

		AttributeMetaData md = unit.getAttributeMetaData(attributeName);
		if (null == md)
			return true;
		return md.isMutable();
	}

}
