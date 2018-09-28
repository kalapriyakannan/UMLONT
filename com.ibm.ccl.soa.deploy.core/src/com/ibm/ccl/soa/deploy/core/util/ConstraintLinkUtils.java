/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * Utility methods for constraint links.
 * 
 */
public class ConstraintLinkUtils {

	/**
	 * Retrieve the requirement at the source end of a logical link if there is one
	 * 
	 * @param link
	 *           the logical link
	 * @return the requirement at the source end of a logical link; null if none
	 */
	public static Requirement getLogicalLinkSourceRequirement(ConstraintLink link) {
		if (null == link) {
			return null;
		}
		DeployModelObject sourceObj = link.getSource();
		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(sourceObj.getEObject().eClass())) {
			return (Requirement) sourceObj;
		}
		return null;
	}

	/**
	 * Retrieve the unit at the source end of a logical link.
	 * 
	 * @param link
	 *           the logical link
	 * @return the unit at the source end of the logical link
	 */
	public static Unit getLogicalLinkSourceUnit(ConstraintLink link) {
		if (null == link) {
			return null;
		}
		DeployModelObject sourceObj = link.getSource();
		return ValidatorUtils.getUnit(sourceObj);
	}

	/**
	 * Retrieve the capability at the target end of a logical link if there is one
	 * 
	 * @param link
	 *           the logical link
	 * @return the capability at the target end of a logical link; null if none
	 */
	public static Capability getLogicalLinkTargetCapability(ConstraintLink link) {
		if (null == link) {
			return null;
		}
		DeployModelObject targetObj = link.getTarget();
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(targetObj.getEObject().eClass())) {
			return (Capability) targetObj;
		}
		return null;
	}

	/**
	 * Retrieve the unit at the target end of a logical link.
	 * 
	 * @param link
	 *           the link
	 * @return the unit at the target end of the logical link
	 */
	public static Unit getLogicalLinkTargetedUnit(ConstraintLink link) {
		if (null == link) {
			return null;
		}
		DeployModelObject targetObj = link.getTarget();
		return ValidatorUtils.getUnit(targetObj);
	}

}
