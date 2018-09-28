/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.matcher;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Matching logic for realization links.
 * 
 * <p>
 * For the authoritative list of realization matching rules, see
 * <code>/com.ibm.ccl.soa.deploy.core/designs/com/ibm/ccl/soa/deploy/core/validator/matcher/package.html</code>.
 * 
 * @see RealizationMatcherUtils
 * @see ConceptualNode
 */
public class RealizationLinkMatcher extends LinkMatcher {

	public Set<LinkDescriptor> getPossibleLinks(Unit conceptualUnit, Unit targetUnit) {
		HashSet<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		if (canCreateLink(conceptualUnit, targetUnit).isOK()) {
			links.add(getLinkDescriptorFactory().createLinkDescriptor(LinkType.REALIZATION,
					conceptualUnit, targetUnit));
		}

		return links;
	}

	public IStatus canBeLinkSource(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.REALIZATION_LINK_NOT_POSSIBLE;
		}

		// can't be source if not conceptual
		if (!unit.isConceptual()) {
			return DeployMatcherStatus.REALIZATION_LINK_NOT_POSSIBLE;
		}
// Disabled as of V8M5
//		// can't be source if already realized
//		if (!ValidatorUtils.getSourceRealizationLinks(unit).isEmpty()) {
//			return DeployMatcherStatus.REALIZATION_LINK_NOT_POSSIBLE;
//		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	@Override
	public IStatus canBeLinkTarget(Unit unit) {
		return booleanToStatus(true);
	}

	@Override
	public IStatus canCreateLink(Unit conceptualUnit, Unit targetUnit) {
		return canCreateLink(conceptualUnit, targetUnit, false, false);
	}

	/**
	 * @see #canCreateLink(Unit, Unit)
	 * 
	 * @param conceptualUnit
	 * @param targetUnit
	 * @param strictAttributeValueMatchMode
	 *           Default for realization link matching allows mismatched attribute values if the
	 *           target attribute is settable. If this parameter is true, then mismatched attribute
	 *           values will prevent a realization match.
	 * @param fullyValidateConstraints
	 *           Default for matching evaluates constraints for potential match. If this parameter is
	 *           true, constraints will be fully validated.
	 * @return true if a realization link can be created in specified attribute match mode
	 */
	public IStatus canCreateLink(Unit conceptualUnit, Unit targetUnit,
			boolean strictAttributeValueMatchMode, boolean fullyValidateConstraints) {
		assert null != conceptualUnit;
		assert null != targetUnit;

		IStatus result = RealizationMatcherUtils.localRealizationMatch(conceptualUnit, targetUnit,
				strictAttributeValueMatchMode, fullyValidateConstraints);
		if (result.isOK()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(conceptualUnit.getEObject()
						.eClass())) {
			result = RealizationMatcherUtils.conceptualNodeMatch((ConceptualNode) conceptualUnit,
					targetUnit);
		}
		return result;
	}
}
