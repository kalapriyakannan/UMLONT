/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Static utility methods for deploy {@link Capability} instances.
 */
public final class CapabilityUtil {
	private CapabilityUtil() {
		// static methods only
	}

	/**
	 * @deprecated no callers use ValidatorUtils
	 * Returns a list of {@link HostingLink} links to hosted units.
	 * <p>
	 * Equivalent to ((Unit) cap.getParent()).getHostingLinks()
	 * 
	 * @param cap
	 *           a capability contained in a topology {@link Unit}.
	 * 
	 * @return a list of hosting links for the {@link unit}.
	 */
	public static List getHostingLinks(Capability cap) {
		assert cap != null;
		assert (cap.getLinkType() == CapabilityLinkTypes.HOSTING_LITERAL)
				|| (cap.getLinkType() == CapabilityLinkTypes.ANY_LITERAL);
		if (!(cap.getParent() instanceof Unit)) {
			return Collections.EMPTY_LIST;
		}
		Unit unit = (Unit) cap.getParent();
		if (unit == null) {
			return Collections.EMPTY_LIST;
		}
		return unit.getHostingLinks();
	}

	/**
	 * Returns the first capability in the unit matching the specified type.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param eclass
	 *           the eclass of the capability to find in the unit
	 * @return the found capabililty, null if not found
	 */
	public static Capability findCapabilityOfType(Unit unit, EClass eclass) {
		// Returns only the first one
		IObjectFilter filter = new EObjectTypeFilter(eclass, true);
		FilterIterator iter = new FilterIterator(unit.getCapabilities(), filter);
		if ((iter != null) && iter.hasNext())
			return (Capability) iter.next();

		return null;
	}

	/**
	 * Returns the first requirement in the unit whose dmoType matches the specified type.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param eclass
	 *           the eclass of the requirement dmoType to find in the unit
	 * @return the found requirement, null if not found
	 */
	public static Requirement findRequirementOfType(Unit unit, EClass eclass) {
		// Returns only the first one
		RequirementCapabilityTypeFilter filter = new RequirementCapabilityTypeFilter(eclass);
		FilterIterator iter = new FilterIterator(unit.getRequirements(), filter);
		if ((iter != null) && iter.hasNext())
			return (Requirement) iter.next();

		return null;
	}

	/**
	 * @deprecated no callers, use ValidatorUtils
	 * 
	 * Returns the first member requirement in the unit whose dmoType matches the specified type.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param eclass
	 *           the eclass of the requirement dmoType to find in the unit
	 * @return the found requirement, null if not found
	 */
	public static Requirement findMemberRequirementOfType(Unit unit, EClass eclass) {
		// Returns only the first one
		RequirementCapabilityTypeFilter filter = new RequirementCapabilityTypeFilter(eclass);
		FilterIterator iter = new FilterIterator(unit.getRequirements(), filter);
		if (iter != null) {
			while (iter.hasNext()) {
				Requirement requirement = (Requirement) iter.next();
				if (requirement.getLinkType().equals(RequirementLinkTypes.MEMBER_LITERAL)) {
					return requirement;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the value of the attribute in the capability contained by the specified unit
	 * 
	 * @param unit
	 *           The unit containing the capability
	 * @param eAttribute
	 *           The eAttribute to retrieve from the capability
	 * @param capability
	 * @parm capability The type of capability to retrieve from the unit
	 * 
	 * @return the value of the attribute, or null if the or attribute capability is not found
	 */
	public static Object getAttributeFromUnitCapability(Unit unit, EAttribute eAttribute,
			EClass capability) {
		Capability cap = CapabilityUtil.findCapabilityOfType(unit, capability);
		if (cap != null) {
			return cap.getEObject().eGet(eAttribute);
		}

		return null;
	}

	/**
	 * Get the value of an attribute or {@link ExtendedAttribute} of a Capability.
	 * 
	 * @param cap
	 * @param attrName
	 * @return the value
	 */
	public static Object getValue(Capability cap, String attrName) {
		// Note: this code nearly duplicates RequirementExpressionInterpreter2.getLValue()
		// and could be merged.
		if (cap == null) {
			return null;
		}

		EStructuralFeature esf = cap.eClass().getEStructuralFeature(attrName);
		if (esf != null) {
			return cap.eGet(esf);
		}

		ExtendedAttribute ea = cap.getExtendedAttribute(attrName);
		if (ea != null) {
			return ea.getValue();
		}

		return null;
	}

	/**
	 * @deprecated no callers, use ValidatorUtil
	 * Get the value of an attribute or {@link ExtendedAttribute} of a Capability.
	 * 
	 * @param cap
	 * @param attrName
	 * @return the value as a String
	 */
	public static String getValueAsString(Capability cap, String attrName) {
		Object retVal = getValue(cap, attrName);
		return (retVal == null) ? null : retVal.toString();
	}
}
