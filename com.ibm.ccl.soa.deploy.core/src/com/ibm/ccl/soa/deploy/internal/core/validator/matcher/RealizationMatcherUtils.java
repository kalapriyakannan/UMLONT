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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployWrapperStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static utility methods for use by the matcher.
 * 
 * @see RealizationLinkMatcher
 */
public class RealizationMatcherUtils {

	/**
	 * Target unit may be conceptual or concrete.
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate unit which would realize source unit
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	public static IStatus localRealizationMatch(Unit cu, Unit tu) {
		return localRealizationMatch(cu, tu, false, false);
	}

	/**
	 * Target unit may be conceptual or concrete.
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate unit which would realize source unit
	 * @param strictAttributeMatch
	 *           Match attribute values regardless of whether target attribute is settable.
	 * @param validateConstraints
	 *           Validate constraints against final realization of target, rather than simply
	 *           validate for potential match
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	public static IStatus localRealizationMatch(Unit cu, Unit tu, boolean strictAttributeMatch,
			boolean validateConstraints) {
		if (!cu.isConceptual()) {
			return DeployMatcherStatus.SOURCE_NOT_CONCEPTUAL;
		}

		if (!cu.getEObject().eClass().isSuperTypeOf(tu.getEObject().eClass())
				&& !(cu instanceof ConceptualNode)) {
			return DeployMatcherStatus.REALIZATION_LINK_TYPE_MISMATCH;
		}

		if (cu.equals(tu)) {
			return DeployMatcherStatus.CANNOT_CREATE_LINK_TO_SELF;
		}

// Disabled as of V8M5
//		if (RealizationLinkUtil.getRealizations(cu).length > 0) {
//			return DeployMatcherStatus.LINK_ALREADY_PRESENT;
//		}

		// 
		if (!cu.isPublic()) {
			return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_REALIZED;
		}
		if (!tu.isPublic()) {
			return DeployMatcherStatus.PRIVATE_UNIT_CANNOT_BE_REALIZATION_TARGET;
		}

		if (hasFinalRealizationCycle(cu, tu)) {
			return DeployMatcherStatus.REALIZATION_CYCLE;
		}

		if (cu instanceof ConceptualNode) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// Simple capabilities match
		IStatus customStatus = null;
		for (Iterator cuCapIter = cu.getCapabilities().iterator(); cuCapIter.hasNext();) {
			Capability cuCap = (Capability) cuCapIter.next();
			if (ignoreCapability(cuCap)) {
				continue;
			}
			boolean foundMatchingCap = false;
			for (Iterator tuCapIter = tu.getCapabilities().iterator(); tuCapIter.hasNext();) {
				Capability tuCap = (Capability) tuCapIter.next();
				IStatus capMatchResult = capMatches(cuCap, tuCap, false, true, strictAttributeMatch,
						validateConstraints, null, null);
				if (capMatchResult.isOK()) {
					foundMatchingCap = true;
					break;
				}
				if (capMatchResult.getCode() == DeployMatcherStatus.CUSTOM_MESSAGE_CODE) {
					customStatus = capMatchResult;
				}
			}
			if (!foundMatchingCap) {
				if (customStatus != null) {
					return customStatus;
				}
				Object params[] = { (cuCap.getDisplayName() != null ? cuCap.getDisplayName() : cuCap
						.getName()) };
				return DeployMatcherStatus
						.createMatchNotFound(
								DeployCoreMessages.DeployMatcherStatus_Realization_Capability_0_Unmatched,
								params);
			}
		}

		// Simple requirements match
		for (Iterator cuReqIter = cu.getRequirements().iterator(); cuReqIter.hasNext();) {
			Requirement cuReq = (Requirement) cuReqIter.next();
			if (ignoreRequirement(cuReq)) {
				continue;
			}
			boolean foundMatchingReq = false;
			for (Iterator tuReqIter = tu.getRequirements().iterator(); tuReqIter.hasNext();) {
				Requirement tuReq = (Requirement) tuReqIter.next();
				if (reqMatches(cuReq, tuReq, false, true, validateConstraints, null, null).isOK()) {
					foundMatchingReq = true;
					break;
				}
			}
			if (!foundMatchingReq) {
				Object params[] = { (cuReq.getDisplayName() != null ? cuReq.getDisplayName() : cuReq
						.getName()) };
				return DeployMatcherStatus.createMatchNotFound(
						DeployCoreMessages.DeployMatcherStatus_Realization_Requirement_0_Unmatched,
						params);
			}
		}

		// Pair capabilities match.
		// Have already verified that single capabilities all match.
		IStatus matchResultCapPairs = capabilityPairMatch(cu, tu);
		if (!matchResultCapPairs.isOK()) {
			return matchResultCapPairs;
		}

		// Pair requirements match.
		// Have already verified that single capabilities all match.
		IStatus matchResultReqPairs = requirementPairMatch(cu, tu);
		if (!matchResultReqPairs.isOK()) {
			return matchResultReqPairs;
		}

		// Unit attributes match
		IStatus unitAttributesMatchResult = unitAttributesMatch(cu, tu, null, null);
		if (!unitAttributesMatchResult.isOK()) {
			return unitAttributesMatchResult;
		}

		// Unit constraints validate
		IStatus dmoConstraintsSatisfiedOnNCFRStatus = dmoConstraintsSatisfiedOnNCFR(cu, tu,
				validateConstraints, null);
		if (!dmoConstraintsSatisfiedOnNCFRStatus.isOK()) {
			return dmoConstraintsSatisfiedOnNCFRStatus;
		}

		// Extended attributes on units match
		IStatus unitExtendedAttributesMatchResult = extendedAttributesMatch(cu, tu,
				strictAttributeMatch, null, null);
		if (!unitExtendedAttributesMatchResult.isOK()) {
			return unitExtendedAttributesMatchResult;
		}

		// Host
		IStatus matchResultHost = checkHoster(cu, tu);
		if (!matchResultHost.isOK()) {
			return matchResultHost;
		}

		// Hostees
		IStatus matchResultHostees = checkHostees(cu, tu);
		if (!matchResultHostees.isOK()) {
			return matchResultHostees;
		}

		// Target
		IStatus matchResultTarget = checkTarget(cu, tu);
		if (!matchResultTarget.isOK()) {
			return matchResultTarget;
		}

		// Sources
		IStatus matchResultSources = checkSources(cu, tu);
		if (!matchResultSources.isOK()) {
			return matchResultSources;
		}

		// Groups
		IStatus matchResultGroups = checkGroups(cu, tu);
		if (!matchResultGroups.isOK()) {
			return matchResultGroups;
		}

		// Members
		IStatus matchResultMembers = checkMembers(cu, tu);
		if (!matchResultMembers.isOK()) {
			return matchResultMembers;
		}

		// The following two checks are for matching only. 
		// Validation finds these errors in a different manner.

		// Hosting links would still be valid?
		IStatus hostingLinkMatchResults = checkHostingLinksValidAfterRealization(cu, tu);
		if (!hostingLinkMatchResults.isOK()) {
			return hostingLinkMatchResults;
		}
		hostingLinkMatchResults = checkTargetHostValidAfterRealization(cu, tu);
		if (!hostingLinkMatchResults.isOK()) {
			return hostingLinkMatchResults;
		}

		// Dependency links would still be valid?
		IStatus dependencyLinkMatchResults = checkDependencyLinksValidAfterRealization(cu, tu);
		if (!dependencyLinkMatchResults.isOK()) {
			return dependencyLinkMatchResults;
		}
		// TODO check that for each dependency requirements on cu, for the corresponding requirement on
		// the concrete final realization of tu (if any), if it has a dependency link, 
		// verify that it could be sourced by cu, and block match if not. 

		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Imperfect test to prevent match if any unit in realization chain has a hosted unit that would
	 * not be hostable on the final realization of parameter tu.
	 * 
	 * @param cu
	 *           realization source - unit to be realized
	 * @param tu
	 *           realization target - unit to realize unit to be realized
	 * @return IStatus indicating OK or that link would create a hosting link error
	 */
	private static IStatus checkHostingLinksValidAfterRealization(Unit cu, Unit tu) {
		Unit tuFR = (Unit) RealizationLinkUtil.getFinalRealization(tu);
		// Note: ValidatorUtils.getHosted() returns all most-realized hosts in the realization chain
		for (Iterator<Unit> hostedIter = ValidatorUtils.getHosted(cu).iterator(); hostedIter
				.hasNext();) {
			Unit hosted = hostedIter.next();
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			IStatus cclStatus = dvs.canCreateLink(tuFR, hosted, new LinkType[] { LinkType.HOSTING });
			// DVS has decided link is OK. E.g., might be a logical hosting link. 
			if (cclStatus.isOK()) {
				continue;
			}
			// DVS has decided link is not OK. Verify that it is not OK because hosting requirements are unmatched (at least). 
			// If hosting requirements are unmatched, then report status. 
			if (!HostingLinkMatcher.hostingRequirementsSatisfied(hosted.getHostingOrAnyRequirements(),
					tuFR)) {
				IStatus status = DeployMatcherStatus.createMatchNotFound(
						DeployCoreMessages.DeployMatcherStatus_Realization_Hostee_0_on_1_Invalid,
						new Object[] { hosted.getCaptionProvider().titleWithContext(hosted),
								tuFR.getCaptionProvider().titleWithContext(tuFR) });
				return status;
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Test to prevent match if final realization of target and its host are concrete, and
	 * constraints on the source (as evaluated by the matcher) would prevent hosting.
	 * 
	 * @param cu
	 *           realization source - unit to be realized
	 * @param tu
	 *           realization target - unit to realize unit to be realized
	 * @return IStatus indicating OK or that link would create a hosting link error
	 */
	private static IStatus checkTargetHostValidAfterRealization(Unit cu, Unit tu) {
		if (cu.getHostingOrAnyRequirements().size() == 0) {
			// No hosting requirements at all.
			return DeployMatcherStatus.MATCH_FOUND;
		}
		Unit tuFR = (Unit) RealizationLinkUtil.getFinalRealization(tu);
		if (!tuFR.isConceptual()) {
			Unit tuFRHost = ValidatorUtils.getHost(tuFR);
			Unit cuHost = ValidatorUtils.getHost(cu);
			if (cuHost == null && tuFRHost != null && !tuFRHost.isConceptual()) {
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				IStatus cclStatus = dvs
						.canCreateLink(tuFRHost, cu, new LinkType[] { LinkType.HOSTING });
				if (!cclStatus.isOK()) {
					// Make sure reason is simply unsatisified requirements
					if (!HostingLinkMatcher.hostingRequirementsSatisfied(cu
							.getHostingOrAnyRequirements(), tuFRHost)) {
						IStatus status = DeployMatcherStatus.createMatchNotFound(
								DeployCoreMessages.DeployMatcherStatus_Realization_Hostee_0_on_1_Invalid,
								new Object[] { cu.getCaptionProvider().titleWithContext(cu),
										tuFRHost.getCaptionProvider().titleWithContext(tuFRHost) });
						return status;
					}
				}
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Imperfect test to prevent match if any unit in realization chain has a dependency link to one
	 * of its capabilities that would not be valid on the final realization of parameter tu.
	 * 
	 * @param cu
	 *           realization source - unit to be realized
	 * @param tu
	 *           realization target - unit to realize unit to be realized
	 * @return IStatus indicating OK or that link would create a dependency link error
	 */
	private static IStatus checkDependencyLinksValidAfterRealization(Unit cu, Unit tu) {
		Unit tuFR = (Unit) RealizationLinkUtil.getFinalRealization(tu);
		// For all capabilities on the unit cu
		for (Iterator<Capability> capsIter = cu.getCapabilities().iterator(); capsIter.hasNext();) {
			Capability cap = capsIter.next();
			// For all dependency links pointed to the capability on the unit in the realization chain for cu
			for (Iterator<Requirement> dlsIter = ValidatorUtils.getDependencyLinkSources(cap)
					.iterator(); dlsIter.hasNext();) {
				Requirement dls = dlsIter.next();
				boolean foundValidTargetCap = false;
				// Does final realization have a valid target capability for the dependency link?
				for (Iterator<Capability> tuCapsIter = ValidatorUtils.findCapabilities(tuFR,
						cap.eClass()).iterator(); tuCapsIter.hasNext();) {
					Capability tuCap = tuCapsIter.next();
					ReqEvaluationContext rec = new ReqEvaluationContext(tuCap);
					IStatus dlvs = RequirementUtil.validate(dls, rec);
					if (dlvs.isOK()) {
						foundValidTargetCap = true;
						break;
					}
				}
				if (!foundValidTargetCap) {
					Unit dlsUnit = ValidatorUtils.getUnit(dls);
					IStatus status = DeployMatcherStatus
							.createMatchNotFound(
									DeployCoreMessages.DeployMatcherStatus_Realization_Dependency_Link_From_0_to_1_Invalid,
									new Object[] { dlsUnit.getCaptionProvider().titleWithContext(dlsUnit),
											tuFR.getCaptionProvider().titleWithContext(tuFR) });
					return status;
				}
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	// Nothing ignored ATM.
	private static boolean ignoreCapability(Capability cap) {
		return cap instanceof BundleCapability;
	}

	// Ignore optional hosting requirements
	private static boolean ignoreRequirement(Requirement req) {
		if (RequirementUsage.OPTIONAL_LITERAL.equals(req.getUse())) {
			if (RequirementLinkTypes.DEPENDENCY_LITERAL.equals(req.getLinkType())
					&& req.getLink() != null) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Target unit may be conceptual or concrete.
	 * 
	 * @param cn
	 *           {@link ConceptualNode} which link would realize
	 * @param tu
	 *           Candidate unit which would realize source unit
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	public static IStatus conceptualNodeMatch(ConceptualNode cn, Unit tu) {
		return conceptualNodeMatch(cn, tu, null, null, null);
	}

	private static IStatus conceptualNodeMatch(ConceptualNode cn, Unit tu, RealizationLink rl,
			IDeployValidationContext context, IDeployReporter reporter) {

		if (tu instanceof ConceptualNode) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		List hReqs = new ArrayList();
		IStatus retVal = DeployMatcherStatus.MATCH_FOUND;

		// find all the hosting requirements of the units hosted on the conceptual
		// node
		for (Iterator hosteeIter = ValidatorUtils.getHosted(cn).iterator(); hosteeIter.hasNext();) {
			Unit hostee = (Unit) hosteeIter.next();
			List reqs = hostee.getOnlyHostingRequirements();
			for (int j = 0; j < reqs.size(); j++) {
				Requirement req = (Requirement) reqs.get(j);
				if (!ignoreRequirement(req)) {
					hReqs.add(req);
				}
			}
		}

		// if there is nothing hosted, allow any realization
		if (0 == hReqs.size()) {
			return retVal;
		}

		List unsatisfiedHostingRequirements = HostingLinkMatcher.unsatisfiedHostingRequirements(
				hReqs, tu);
		if (unsatisfiedHostingRequirements.size() > 0) {
			Requirement firstReq = (Requirement) unsatisfiedHostingRequirements.get(0);
			Object params[] = { (firstReq.getDisplayName() != null ? firstReq.getDisplayName()
					: firstReq.getName()) };
			retVal = DeployMatcherStatus
					.createMatchNotFound(
							DeployCoreMessages.DeployMatcherStatus_Realization_Link_Conceptual_Node_Hosting_Requirement_0_Not_Satisfied,
							params);
			if (reporter != null) {
				for (Iterator uHRIter = unsatisfiedHostingRequirements.iterator(); uHRIter.hasNext();) {
					Requirement r = (Requirement) uHRIter.next();

					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.REALIZATION_LINK_012,
									ICoreProblemType.REALIZATION_LINK_UNMATCHED_REQUIREMENT,
									DeployCoreMessages.DeployMatcherStatus_Realization_Link_Conceptual_Node_Hosting_Requirement_0_Not_Satisfied,
									new Object[] { (r.getDisplayName() != null ? r.getDisplayName() : r
											.getName()) }, rl != null ? (DeployModelObject) rl
											: (DeployModelObject) cn);
					reporter.addStatus(status);
				}
			}
		}

		// the target unit must satisfy all of the hosting requirements

		return retVal;
	}

	/**
	 * Note: this method does not evaluate (for match) constraints on the conceptual capability.
	 * 
	 * @param cuCap
	 * @param tuCap
	 * @return a DeployMatcherStatus, either MATCH_FOUND or a mismatch status
	 */
	public static IStatus capMatches(Capability cuCap, Capability tuCap) {
		return capMatches(cuCap, tuCap, false, false, false, false, null, null);
	}

	/**
	 * If reporter is non-null, report validator statuses in addition to returning a matcher status.
	 * 
	 * @param cuCap
	 * @param tuCap
	 * @param realizationValidationMode
	 * @param evaluateConstraints
	 *           if true, evaluate constraints, either for potential match or full validation
	 * @param strictAttributeMatchMode
	 *           if true, attributes must match even if target is modifiable
	 * @param validateConstraints
	 *           if true, validate constraints on DMOs being matched rather than simply validate for
	 *           potential match.
	 * @param context
	 * @param reporter
	 * @return a DeployMatcherStatus, either MATCH_FOUND, or a status resulting from mismatched
	 *         attributes or a type mismatch
	 */
	public static IStatus capMatches(Capability cuCap, Capability tuCap,
			boolean realizationValidationMode, boolean evaluateConstraints,
			boolean strictAttributeMatchMode, boolean validateConstraints,
			IDeployValidationContext context, IDeployReporter reporter) {
		// special case for COMMUNICATION_CAPABILITY on a CONCEPTUAL_NODE
		// TODO move special case code
		if (isCommunicationCapOnConceptualNode(cuCap)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// Match interfaces
		if (cuCap instanceof Service && tuCap instanceof Service) {
			Interface cuCapInterface = ((Service) cuCap).getInterface();
			Interface tuCapInterface = ((Service) tuCap).getInterface();
			if (cuCapInterface != null) {
				if (tuCapInterface == null) {
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				} else {
					if (realizationValidationMode) {
						if (!cuCapInterface.isEquivalent(tuCapInterface)) {
							return DeployMatcherStatus.MATCH_NOT_FOUND;
						}
					} else {
						if (!cuCapInterface.isFastEquivalencyCheck(tuCapInterface)) {
							return DeployMatcherStatus.MATCH_NOT_FOUND;
						}
					}
				}
			}
		}

		// System.out.println("cap matching " + cuCap.getName() + ":" +
		// tuCap.getName()); //$NON-NLS-1$ //$NON-NLS-2$
		if (cuCap.getEObject().eClass().isSuperTypeOf(tuCap.getEObject().eClass())) {
			// Check that EAttributes match
			IStatus matchResult = eAttributesMatch(cuCap, tuCap, strictAttributeMatchMode, context,
					reporter);
			if (!matchResult.isOK()) {
				return matchResult;
			}
			// Check that extended attributes match
			matchResult = extendedAttributesMatch(cuCap, tuCap, strictAttributeMatchMode, context,
					reporter);
			if (!matchResult.isOK()) {
				return matchResult;
			}
			// Check that stereotypes match
			matchResult = checkStereotypes(cuCap, tuCap, context, reporter);
			if (!matchResult.isOK()) {
				return matchResult;
			}

		} else {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!realizationValidationMode && evaluateConstraints) {
			IStatus s = dmoConstraintsSatisfiedOnNCFR(cuCap, tuCap, validateConstraints,
					context != null ? context.getProgressMonitor() : null);
			if (!s.isOK()) {
				return s;
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	private static boolean isCommunicationCapOnConceptualNode(Capability cCap) {
		return cCap != null
				&& CorePackage.Literals.COMMUNICATION_CAPABILITY.isSuperTypeOf(cCap.getEObject()
						.eClass())
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(cCap.getParent().getEObject()
						.eClass());
	}

	private static boolean isCommunicationReqOnConceptualNode(Requirement cReq) {
		return cReq.getDmoEType() != null
				&& CorePackage.Literals.COMMUNICATION_CAPABILITY.isSuperTypeOf(cReq.getDmoEType())
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(cReq.getParent().getEObject()
						.eClass());
	}

	/**
	 * @param cuReq
	 * @param tuReq
	 * @return a DeployMatcherStatus, either MATCH_FOUND, or a status resulting from mismatched
	 *         attributes or a type mismatch
	 */
	public static IStatus reqMatches(Requirement cuReq, Requirement tuReq) {
		return reqMatches(cuReq, tuReq, false, false, false, null, null);
	}

	/**
	 * Match attributes on Unit
	 * 
	 * @param cu
	 *           Conceptual Unit
	 * @param tu
	 *           Realization Target Unit
	 * @param context
	 * @param reporter
	 * @return DeployMatcherStatus.MATCH_FOUND if match, and either
	 *         DeployMatcherStatus.MATCH_NOT_FOUND or some more specific status if no match. Reports
	 *         validation statuses as well if reporter is non-null.
	 */
	private static IStatus unitAttributesMatch(Unit cu, Unit tu, IDeployValidationContext context,
			IDeployReporter reporter) {
		IStatus retVal = DeployMatcherStatus.MATCH_FOUND;
		// "publishIntent" matches according to the following rules:
		// C.publishIntent = publish U.publishIntent must be publish
		// C.publishIntent = doNotPublish U.publishIntent must be doNotPublish
		// C.publishIntent = unknown U.publishIntent can be anything
		// Bill Arnold 2007/04/06 consensus is PublishIntent is advisory
		// and should not be check for matching.
		// if (cu.getPublishIntent().equals(PublishIntent.PUBLISH_LITERAL)) {
		// if (!tu.getPublishIntent().equals(PublishIntent.PUBLISH_LITERAL)) {
		// retVal = reportUnmatchedAttribute(cu,
		// CorePackage.eINSTANCE.getUnit_PublishIntent(), context, reporter);
		// if (reporter == null) {
		// return retVal;
		// }
		// }
		// }
		// if (cu.getPublishIntent().equals(PublishIntent.DO_NOT_PUBLISH_LITERAL))
		// {
		// if
		// (!tu.getPublishIntent().equals(PublishIntent.DO_NOT_PUBLISH_LITERAL)) {
		// retVal = reportUnmatchedAttribute(cu,
		// CorePackage.eINSTANCE.getUnit_PublishIntent(), context, reporter);
		// if (reporter == null) {
		// return retVal;
		// }
		// }
		// }
		// "initInstallState" matches according to the following rules:
		// C.initInstallState = installed U.initInstallState must be installed
		// C.initInstallState = notInstalled U.initInstallState must be notInstalled
		// C.initInstallState = unknown U.initInstallState can be anything
		if (cu.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			if (!tu.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
				retVal = reportUnmatchedAttribute(cu, cu.getInitInstallState(), tu, tu
						.getInitInstallState(), CorePackage.eINSTANCE.getUnit_InitInstallState(),
						context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}
		if (cu.getInitInstallState().equals(InstallState.NOT_INSTALLED_LITERAL)) {
			if (!tu.getInitInstallState().equals(InstallState.NOT_INSTALLED_LITERAL)) {
				retVal = reportUnmatchedAttribute(cu, cu.getInitInstallState(), tu, tu
						.getInitInstallState(), CorePackage.eINSTANCE.getUnit_InitInstallState(),
						context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}
		// "goalInstallState" matches according to the following rules:
		// if (C.goalInstallState == installed) then U.goalInstallState must be installed
		//             OR (U.goalInstallState = unknown AND U.initInstallState = installed) 
		// if (C.goalInstallState == notInstalled) then U.goalInstallState must be notInstalled
		//             OR (U.goalInstallState = unknown AND U.initInstallState = notInstalled)
		// C.galInstallState = unknown  U.goalInstallState can be anything
		if (cu.getGoalInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			if (!(tu.getGoalInstallState().equals(InstallState.INSTALLED_LITERAL) || tu
					.getGoalInstallState().equals(InstallState.UNKNOWN_LITERAL)
					&& tu.getInitInstallState().equals(InstallState.INSTALLED_LITERAL))) {
				retVal = reportUnmatchedAttribute(cu, cu.getGoalInstallState(), tu, tu
						.getGoalInstallState(), CorePackage.eINSTANCE.getUnit_GoalInstallState(),
						context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}
		if (cu.getGoalInstallState().equals(InstallState.NOT_INSTALLED_LITERAL)) {
			if (!(tu.getGoalInstallState().equals(InstallState.NOT_INSTALLED_LITERAL) || tu
					.getGoalInstallState().equals(InstallState.UNKNOWN_LITERAL)
					&& tu.getInitInstallState().equals(InstallState.NOT_INSTALLED_LITERAL))) {
				retVal = reportUnmatchedAttribute(cu, cu.getGoalInstallState(), tu, tu
						.getGoalInstallState(), CorePackage.eINSTANCE.getUnit_GoalInstallState(),
						context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}
		// "configurationUnit" matches according to the following rules:
		// C.configurationUnit = U.configurationUnit
		if (!(cu.isConfigurationUnit() == tu.isConfigurationUnit())) {
			retVal = reportUnmatchedAttribute(cu, null, tu, null, CorePackage.eINSTANCE
					.getUnit_ConfigurationUnit(), context, reporter);
			if (reporter == null) {
				return retVal;
			}
		}
		// Note - no consensus on this rule about mutability
		// "mutable" matches according to the following rules:
		// C is mutable, U is mutable match
		// C is mutable, U is immutable match
		// C is immutable, U is mutable no match
		// C is immutable, U is immutable match

		return retVal;
	}

	/**
	 * If reporter is non-null, report validator statuses in addition to returning a matcher status.
	 * 
	 * @param cuReq
	 * @param tuReq
	 * @param realizationValidationMode
	 *           if true, softer match, including fast interfaces match
	 * @param evaluateConstraints
	 *           if true, evaluate constraints, either for potential match or full validation
	 * @param validateConstraints
	 *           if true, validate constraints on DMOs being matched rather than simply validate for
	 *           potential match.
	 * @param context
	 * @param reporter
	 * @return a DeployMatcherStatus, either MATCH_FOUND, or a status resulting from mismatched
	 *         attributes or a type mismatch
	 */
	private static IStatus reqMatches(Requirement cuReq, Requirement tuReq,
			boolean realizationValidationMode, boolean evaluateConstraints,
			boolean validateConstraints, IDeployValidationContext context, IDeployReporter reporter) {
		// special case for DmoEType of COMMUNICATION_CAPABILITY
		// TODO move special case code
		if (isCommunicationReqOnConceptualNode(cuReq)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// Match interfaces
		if (cuReq instanceof Reference && tuReq instanceof Reference) {
			Interface cuReqInterface = ((Reference) cuReq).getInterface();
			Interface tuReqInterface = ((Reference) tuReq).getInterface();
			if (cuReqInterface != null) {
				if (tuReqInterface == null) {
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				} else {
					if (realizationValidationMode) {
						if (!cuReqInterface.isEquivalent(tuReqInterface)) {
							return DeployMatcherStatus.MATCH_NOT_FOUND;
						}
					} else {
						if (!cuReqInterface.isFastEquivalencyCheck(tuReqInterface)) {
							return DeployMatcherStatus.MATCH_NOT_FOUND;
						}
					}
				}
			}
		}

		// FIXME - evaluate for match in derived context
//		if (!realizationValidationMode && evaluateConstraints) {
//			IStatus s = dmoConstraintsSatisfiedOnNCFR(cuReq, tuReq, validateConstraints,
//					context != null ? context.getProgressMonitor() : null);
//			if (!s.isOK()) {
//				return s;
//			}
//		}

		// TODO report specific statuses?
		if (cuReq.getDmoEType() != null && tuReq.getDmoEType() != null) {
			if (!cuReq.getDmoEType().isSuperTypeOf(tuReq.getDmoEType())) {
				return DeployMatcherStatus.REALIZATION_LINK_REQUIREMENT_DMO_TYPE_MISMATCH;
			}
		}
		if (cuReq.getDmoEType() != null && tuReq.getDmoEType() == null) {
			return DeployMatcherStatus.REALIZATION_LINK_REQUIREMENT_DMO_TYPE_MISMATCH;
		}
		// LinkType ANY invalid, but validated tested elsewhere
		if (cuReq.getLinkType() != null && !cuReq.getLinkType().equals(tuReq.getLinkType())) {
			return DeployMatcherStatus.REALIZATION_LINK_REQUIREMENT_LINK_TYPE_MISMATCH;
		}
		if (cuReq.getUse() != null && !cuReq.getUse().equals(tuReq.getUse())) {
			return DeployMatcherStatus.REALIZATION_LINK_REQUIREMENT_USE_MISMATCH;
		}
		for (Iterator cuReqExprIter = cuReq.getExpressions().iterator(); cuReqExprIter.hasNext();) {
			RequirementExpression cuRe = (RequirementExpression) cuReqExprIter.next();
			boolean foundMatchingRequirementExpression = false;
			// TODO Fix this and reqExprMatches when requirement expression
			// comparator is designed.
			if (cuRe.getInterpreter() != null && cuRe.getInterpreter().equals(Equals.INTERPRETER_ID)) {
				for (Iterator tuReqExprIter = tuReq.getExpressions().iterator(); tuReqExprIter
						.hasNext();) {
					RequirementExpression tuRe = (RequirementExpression) tuReqExprIter.next();
					if (reqExprMatches(cuRe, tuRe)) {
						foundMatchingRequirementExpression = true;
					}
					break;
				}
				if (!foundMatchingRequirementExpression) {
					cuRe.getAttributeName();
					Object params[] = {
							(cuReq.getDisplayName() != null ? cuReq.getDisplayName() : cuReq.getName()),
							cuRe.getAttributeName(), cuRe.getValue(), cuRe.getInterpreter() };
					return DeployMatcherStatus
							.createMatchNotFound(
									DeployCoreMessages.DeployMatcherStatus_Realization_Attribute_Unmatched,
									params);
				}
			}
		}
		// TODO add paired-requirement-expression test, after requirement
		// comparison is settled.
		return DeployMatcherStatus.MATCH_FOUND;

	}

	// TODO return DeployMatcherStatus
	private static boolean reqExprMatches(RequirementExpression cRE, RequirementExpression tRE) {
		if (cRE.getAttributeName() != null && !cRE.getAttributeName().equals(tRE.getAttributeName())) {
			return false;
		}
		if (cRE.getUse() != null && !cRE.getUse().equals(tRE.getUse())) {
			return false;
		}

		// TODO improve check
		// TODO better test for value
		// if ((cRE.getInterpreter() != null) &&
		// !cRE.getInterpreter().equals(tRE.getInterpreter())) {
		// return false;
		// }
		// Safe checks (no false mismatches)
		if (cRE.getInterpreter() != null && tRE.getInterpreter() == null) {
			return false;
		}
		if (cRE.getInterpreter() != null && tRE.getInterpreter() != null
				&& cRE.getInterpreter().equals(Equals.INTERPRETER_ID)
				&& tRE.getInterpreter().equals(Equals.INTERPRETER_ID)
				&& !cRE.getValue().equals(tRE.getValue())) {
			return false;
		}
		if (cRE.getInterpreter().equals(Equals.INTERPRETER_ID)
				&& !tRE.getInterpreter().equals(Equals.INTERPRETER_ID)) {
			return false;
		}

		return true;
	}

	/**
	 * Check that attributes follow our realization matching rules.
	 * 
	 * @param cdmo
	 *           'Conceptual DMO'
	 * @param tdmo
	 *           'Target DMO'
	 * @param strictAttributeMatchMode
	 *           true if validating, which means attribute values must match even if modifiable.
	 * @return {@link DeployMatcherStatus#MATCH_FOUND} if every set attribute on cdmo has the same
	 *         value on tdmo
	 */
	private static IStatus eAttributesMatch(DeployModelObject cdmo, DeployModelObject tdmo,
			boolean strictAttributeMatchMode, IDeployValidationContext context,
			IDeployReporter reporter) {
		// Check that EAttributes match
		IStatus retVal = DeployMatcherStatus.MATCH_FOUND;
		for (Iterator attrIter = cdmo.eClass().getEAllAttributes().iterator(); attrIter.hasNext();) {
			EAttribute ea = (EAttribute) attrIter.next();

			// Does the target even have the attribute?
			if (!tdmo.eClass().getEAllAttributes().contains(ea)) {
				retVal = DeployMatcherStatus.MATCH_NOT_FOUND;
				if (reporter == null) {
					break;
				}
				// TODO Report missing attribute on target status
				continue;
			}

			// Excludes all core EAttributes that are FeatureMaps
			if (FeatureMapUtil.isFeatureMap(ea)) {
				continue;
			}

			// Note: Excludes all core DMO attributes, including "mutable".
			// (If we want special handling for mutable it will need to be
			// special-cased.)
			// Exclude attributes that aren't set on the 'conceptual' DMO
			if (isCoreDmoAttribute(ea) || isUnsetAttribute(cdmo, ea)) {
				continue;
			}

			Object cuEaVal = cdmo.eGet(ea);
			Object tuEaVal = tdmo.eGet(ea);

			// Special case for Capability.linkType
			if (cuEaVal != null && ea.equals(CorePackage.eINSTANCE.getCapability_LinkType())) {
				if (cuEaVal.equals(CapabilityLinkTypes.DEPENDENCY_LITERAL)) {
					if (!cuEaVal.equals(tuEaVal)) {
						retVal = DeployMatcherStatus.REALIZATION_LINK_CAPABILITY_LINK_TYPE_MISMATCH;
						if (reporter == null) {
							break;
						}
					}
				} else if (cuEaVal.equals(CapabilityLinkTypes.HOSTING_LITERAL)) {
					if (!cuEaVal.equals(tuEaVal)) {
						retVal = DeployMatcherStatus.REALIZATION_LINK_CAPABILITY_LINK_TYPE_MISMATCH;
						if (reporter == null) {
							break;
						}
					}
				} else if (cuEaVal.equals(CapabilityLinkTypes.ANY_LITERAL)) {
					if (tuEaVal != null
							&& !(tuEaVal.equals(CapabilityLinkTypes.DEPENDENCY_LITERAL)
									|| tuEaVal.equals(CapabilityLinkTypes.HOSTING_LITERAL) || tuEaVal
									.equals(CapabilityLinkTypes.ANY_LITERAL))) {
						retVal = DeployMatcherStatus.REALIZATION_LINK_CAPABILITY_LINK_TYPE_MISMATCH;
						if (reporter == null) {
							break;
						}
					}
				}
				if (retVal.equals(DeployMatcherStatus.REALIZATION_LINK_CAPABILITY_LINK_TYPE_MISMATCH)) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
							IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_007,
							ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE, retVal
									.getMessage(), new Object[] {}, cdmo, ea);
					reporter.addStatus(status);
				}
			} else if (cuEaVal != null
					&& !(cuEaVal instanceof String && ((String) cuEaVal).trim().length() == 0)) {
				// If validation context, or target attribute is not setable
				if (strictAttributeMatchMode || !eAttributeIsSetable(tdmo, ea)) {
					boolean eAttrMatched = true;
					if (ea.getEAttributeType().equals(CorePackage.eINSTANCE.getVersionString())) {
						if (!Version.getInstance().interp(tuEaVal, cuEaVal)) {
							eAttrMatched = false;
						}
					} else if (!cuEaVal.equals(tuEaVal)) {
						eAttrMatched = false;
					}
					if (!eAttrMatched) {
						retVal = reportUnmatchedAttribute(cdmo, cuEaVal, tdmo, tuEaVal, ea, context,
								reporter);
						if (reporter == null) {
							break;
						}
					}
				}
			}
			IStatus attributeMetaDataMatchCheck = attributeMetaDataMatchCheck(cdmo, tdmo,
					ea.getName(), context, reporter);
			if (!attributeMetaDataMatchCheck.isOK()) {
				retVal = attributeMetaDataMatchCheck;
				if (reporter == null) {
					break;
				}
			}
		}
		return retVal;
	}

	private static boolean attributeIsSetable(DeployModelObject owningDmo, String attributeName) {
		if (!owningDmo.isPublicEditable(attributeName)) {
			return false;
		}
		if (!DeployModelObjectUtil.isMutable(owningDmo, attributeName)) {
			return false;
		}
		return true;
	}

	private static boolean eAttributeIsSetable(DeployModelObject owningDmo, EAttribute ea) {
		return attributeIsSetable(owningDmo, ea.getName());
	}

	/**
	 * @param cdmo
	 *           conceptual DMO
	 * @param tdmo
	 *           target DMO
	 * @param ea
	 *           EAttribute with mismatched value
	 * @param context
	 * @param reporter
	 * @return Custom match not found status with informative message
	 */
	private static IStatus reportUnmatchedAttribute(DeployModelObject cdmo, Object cVal,
			DeployModelObject tdmo, Object tVal, EAttribute ea, IDeployValidationContext context,
			IDeployReporter reporter) {
//		String translatedAttribName = DeployNLS.getName(cdmo, ea);
		Object params[] = { ea.getName() /* translatedAttribName */,
				(cdmo.getDisplayName() != null ? cdmo.getDisplayName() : cdmo.getName()) };
		IStatus retVal = DeployMatcherStatus.createMatchNotFound(
				DeployCoreMessages.DeployMatcherStatus_Realization_Attribute_Unmatched, params);
		if (reporter != null) {
			// Report.
			IDeployStatus status;
			// set target if conceptual is set, else report simple status on conceptual
			if (!emptyObject(cVal)) {
				status = DeployCoreStatusFactory.INSTANCE.createAttributeValueSourceStatus(
						IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_007,
						ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE, retVal.getMessage(),
						new Object[] {}, tdmo, ea, cdmo, ea);
			} else {
				status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR,
						IDeployCoreValidators.REALIZATION_LINK_007,
						ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE, retVal.getMessage(),
						new Object[] {}, tdmo, ea);
			}
			RealizationLink rl = ValidatorUtils.getRealizationLink(ValidatorUtils.getUnit(cdmo));
			if (rl != null) {
				IDeployWrapperStatus wrappedStatus = DeployCoreStatusFactory.INSTANCE
						.createDeployWrapperStatus(IStatus.ERROR, IDeployCoreValidators.HOSTING_004,
								ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE, status
										.getMessage(), null, rl, status);
				reporter.addStatus(wrappedStatus);
			} else {
				reporter.addStatus(status);
			}
		}
		return retVal;
	}

	/**
	 * @param cdmo
	 *           conceptual DMO
	 * @param tdmo
	 *           target DMO
	 * @param ea
	 *           Stereotype with mismatched value
	 * @param context
	 * @param reporter
	 * @return Custom match not found status with informative message
	 */
	private static IStatus reportUnmatchedStereotype(DeployModelObject cdmo, DeployModelObject tdmo,
			String stereotypes, IDeployValidationContext context, IDeployReporter reporter) {
		IStatus retVal = DeployMatcherStatus
				.createMatchNotFound(DeployCoreMessages.DeployMatcherStatus_Realization_Link_Stereotype_Mismatch);
		// TODO use parms?
		if (reporter != null) {
			// Report.
			IDeployStatus status;
			RealizationLink rl = ValidatorUtils.getRealizationLink(ValidatorUtils.getUnit(cdmo),
					ValidatorUtils.getUnit(tdmo));

			if (rl != null) {
				String problemType;
				if (cdmo instanceof Unit) {
					problemType = ICoreProblemType.REALIZATION_LINK_UNIT_SOURCE_TARGET_STEREOTYPE_MISMATCH;
				} else {
					problemType = ICoreProblemType.REALIZATION_LINK_CAP_SOURCE_TARGET_STEREOTYPE_MISMATCH;
				}

				status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(
								IStatus.ERROR,
								IDeployCoreValidators.REALIZATION_LINK_013,
								problemType,
								DeployCoreMessages.Validator_realization_link_target_missing_required_stereotypes_0,
								new Object[] { stereotypes, cdmo, tdmo }, rl);
				reporter.addStatus(status);

			}
		}
		return retVal;
	}

	/**
	 * Return true if object is empty from UI perspective. (null or empty string.)
	 * 
	 * @param o
	 * @return
	 */
	private static boolean emptyObject(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof String && ((String) o).length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param cdmo
	 *           Conceptual DMO
	 * @param ea
	 *           EAttribute with mismatched metadata
	 * @param context
	 * @param reporter
	 * @return Custom match not found status with informative message
	 */
	private static IStatus reportUnmatchedAttributeMetaData(DeployModelObject cdmo,
			String attributeName, IDeployValidationContext context, IDeployReporter reporter) {
		Object params[] = { attributeName,
				(cdmo.getDisplayName() != null ? cdmo.getDisplayName() : cdmo.getName()) };
		IStatus retVal = DeployMatcherStatus
				.createMatchNotFound(
						DeployCoreMessages.DeployMatcherStatus_Realization_Attribute_MetaData_Unmatched,
						params);
		if (reporter != null) {
			// Report. 
			// TODO use variation on reportUnmatchedAttribute();
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_009,
					ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_METADATA, retVal.getMessage(),
					new Object[] {}, cdmo, attributeName);
			reporter.addStatus(status);
		}
		return retVal;
	}

	private static boolean isCoreDmoAttribute(EAttribute ea) {
		return CorePackage.eINSTANCE.getDeployModelObject().getEAllAttributes().contains(ea);
		// final EList dmoEAttrs =
		// CorePackage.eINSTANCE.getDeployModelObject().getEAllAttributes();
	}

	private static boolean isUnsetAttribute(DeployModelObject cdmo, EAttribute ea) {
		return !cdmo.eIsSet(ea);
	}

	/**
	 * @param cdmo
	 * @param tdmo
	 * @param strictMatchMode
	 * @param context
	 * @param reporter
	 * @return
	 */
	private static IStatus extendedAttributesMatch(DeployModelObject cdmo, DeployModelObject tdmo,
			boolean strictMatchMode, IDeployValidationContext context, IDeployReporter reporter) {
		boolean allCuEAsMatched = true;
		IStatus retVal = DeployMatcherStatus.MATCH_NOT_FOUND;
		for (Iterator cuEAIter = cdmo.getExtendedAttributes().iterator(); cuEAIter.hasNext();) {
			ExtendedAttribute cuEA = (ExtendedAttribute) cuEAIter.next();
			ExtendedAttribute tuEA = tdmo.getExtendedAttribute(cuEA.getName());

			if (cuEA != null && tuEA == null) {
				String attribName = cuEA.getName();
				Object params[] = { attribName,
						(cdmo.getDisplayName() != null ? cdmo.getDisplayName() : cdmo.getName()) };
				retVal = DeployMatcherStatus.createMatchNotFound(
						DeployCoreMessages.DeployMatcherStatus_Realization_Attribute_Unmatched, params);
				allCuEAsMatched = false;
				if (reporter == null) {
					break;
				}
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_010,
						ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE, retVal.getMessage(),
						new Object[] {}, cdmo, cuEA.getName());
				reporter.addStatus(status);
				break;
			}
			Object tuEAVal = tuEA.getValue();
			Object cuEAVal = cuEA.getValue();
			if (cuEAVal != null
					&& !(cuEAVal instanceof String && ((String) cuEAVal).trim().length() == 0)) {
				// If validation context, or target attribute is not setable
				if (strictMatchMode || !attributeIsSetable(tdmo, tuEA.getName())) {
					if (!cuEAVal.equals(tuEAVal)) {
						String attribName = cuEA.getName();
						Object params[] = { attribName,
								(cdmo.getDisplayName() != null ? cdmo.getDisplayName() : cdmo.getName()) };
						retVal = DeployMatcherStatus.createMatchNotFound(
								DeployCoreMessages.DeployMatcherStatus_Realization_Attribute_Unmatched,
								params);
						allCuEAsMatched = false;
						if (reporter == null) {
							break;
						}
						if (reporter != null) {
							// Report. Should this be an AttributeValueSourceStatus?
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
									IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_007,
									ICoreProblemType.REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE, retVal
											.getMessage(), new Object[] {}, cdmo, cuEA.getName());
							reporter.addStatus(status);
						}
					}
					break;
				}
			}
			IStatus attributeMetaDataMatchCheck = attributeMetaDataMatchCheck(cdmo, tdmo, cuEA
					.getName(), context, reporter);
			if (!attributeMetaDataMatchCheck.isOK()) {
				retVal = attributeMetaDataMatchCheck;
				if (reporter == null) {
					break;
				}
				allCuEAsMatched = false;
			}
		}
		if (allCuEAsMatched) {
			retVal = DeployMatcherStatus.MATCH_FOUND;
		}
		return retVal;
	}

	private static IStatus attributeMetaDataMatchCheck(DeployModelObject cdmo,
			DeployModelObject tdmo, String attributeName, IDeployValidationContext context,
			IDeployReporter reporter) {
		IStatus retVal = DeployMatcherStatus.MATCH_FOUND;
		if (cdmo == null || tdmo == null || attributeName == null) {
			return retVal;
		}

		// "encrypted" matches according to the following rules:
		// a.isEncrypted = true - a'.isEncrypted = true
		// a.isEncrypted = false - a'.isEncrypted = anything
		// a.isEncrypted = null - a'.isEncrypted = anything
		if (DeployModelObjectUtil.isEncrypted(cdmo, attributeName)) {
			if (!DeployModelObjectUtil.isEncrypted(tdmo, attributeName)) {
				retVal = reportUnmatchedAttributeMetaData(cdmo, attributeName, context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}

		// "encryptionRequired" matches according to the following rules:
		// a.isEncryptionRequired = true - a'.isEncryptionRequired = true
		// a.isEncryptionRequired = false - a'.isEncryptionRequired = anything
		// a.isEncryptionRequired = null - a'.isEncryptionRequired = anything
		AttributeMetaData mDataC = getAttributeMetaData(cdmo, attributeName);
		AttributeMetaData mDataT = getAttributeMetaData(tdmo, attributeName);
		if (mDataC != null && mDataT != null) {
			if (mDataC.isEncryptionRequired() && !mDataT.isEncryptionRequired()) {
				retVal = reportUnmatchedAttributeMetaData(cdmo, attributeName, context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}

		// No consensus on mutability matching
		// "mutable" matches according the following rules:
		// a is mutable, a' is mutable - match
		// a is mutable, a' is immutable - match
		// a is immutable, a' is mutable - no match
		// a is immutable, a' is immutable - match

		// "optional" matches according to the following rules:
		// a.isOptional = true - a'.isOptional = anything
		// a.isOptional = false - a'.isOptional = false
		// a.isOptional = null - a'.isOptional = anything
		if (mDataC != null && mDataT != null) {
			if (!mDataC.isOptional() && mDataT.isOptional()) {
				retVal = reportUnmatchedAttributeMetaData(cdmo, attributeName, context, reporter);
				if (reporter == null) {
					return retVal;
				}
			}
		}

		return retVal;
	}

	private static AttributeMetaData getAttributeMetaData(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return null;
		}

		AttributeMetaData data = dmo.getAttributeMetaData(attributeName);
		return data;
	}

	private static IStatus cachedCapMatches(Map<CapPair, IStatus> cacheMap, Capability cuCap,
			Capability tuCap, IDeployValidationContext context, IDeployReporter reporter) {
		CapPair capPair = new CapPair(cuCap, tuCap);
		if (cacheMap.get(capPair) != null) {
			return cacheMap.get(capPair);
		}
		IStatus capMatchResult = capMatches(cuCap, tuCap, false, true, false, false, context,
				reporter);
		cacheMap.put(capPair, capMatchResult);
		return capMatchResult;
	}

	// TODO fix performance, or eliminate this test
	// Note: Performance partially addressed with short-lived cache used by
	// cachedCapMatches
	private static IStatus capabilityPairMatch(Unit cu, Unit tu) {
		Object cuCaps[] = cu.getCapabilities().toArray();
		Object tuCaps[] = tu.getCapabilities().toArray();
		if (cuCaps.length < 2) {
			return DeployMatcherStatus.MATCH_FOUND;
		}
		HashMap capPairsMatchMap = new HashMap();
		// System.out.println("pairCapProcessing " + cuCaps.length + ":" +
		// tuCaps.length); //$NON-NLS-1$ //$NON-NLS-2$
		// This appears to be between O(N^2) and O(N^3) in practice.
		// PortConfig units are the worst case in current models and performance
		// is very reasonable.
		for (int i = 0; i < cuCaps.length; ++i) {
			Capability cuCap = (Capability) cuCaps[i];
			if (isCommunicationCapOnConceptualNode(cuCap)) {
				continue;
			}
			if (ignoreCapability(cuCap)) {
				continue;
			}
			for (int j = i + 1; j < cuCaps.length; ++j) {
				Capability cuCapPrime = (Capability) cuCaps[j];
				if (isCommunicationCapOnConceptualNode(cuCapPrime)) {
					continue;
				}
				if (ignoreCapability(cuCapPrime)) {
					continue;
				}
				// System.out.println("pair " + cuCap.getName() + ":" +
				// cuCapPrime.getName()); //$NON-NLS-1$//$NON-NLS-2$
				boolean pairMatchFound = false;
				for (int ii = 0; ii < tuCaps.length; ++ii) {
					Capability tuCap = (Capability) tuCaps[ii];
					// System.out.println("against " + tuCap.getName());
					// //$NON-NLS-1$
					if (isCommunicationCapOnConceptualNode(tuCap)) {
						continue;
					}
					if (cachedCapMatches(capPairsMatchMap, cuCap, tuCap, null, null).isOK()) {
						// Test pairs in both orders.
						for (int jj = 0; jj < tuCaps.length; ++jj) {
							Capability tuCapPrime = (Capability) tuCaps[jj];
							if (isCommunicationCapOnConceptualNode(tuCapPrime)) {
								continue;
							}
							if (tuCapPrime == tuCap) {
								continue;
							}
							if (cachedCapMatches(capPairsMatchMap, cuCapPrime, tuCapPrime, null, null)
									.isOK()) {
								// System.out.println("pairPrime matches " +
								// tuCap.getName() + ":" + tuCapPrime.getName());
								// //$NON-NLS-1$//$NON-NLS-2$
								pairMatchFound = true;
								break;
							}
						}
					}
					if (pairMatchFound) {
						break;
					}
				}
				if (!pairMatchFound) {
					// System.out.println("match not found"); //$NON-NLS-1$
					Object params[] = { cuCap.getCaptionProvider().title(cuCap),
							cuCapPrime.getCaptionProvider().title(cuCapPrime) };
					IStatus matchResult = DeployMatcherStatus
							.createMatchNotFound(
									DeployMatcherStatus.REALIZATION_LINK_CAPABILITY_PAIR,
									DeployCoreMessages.DeployMatcherStatus_Realization_Capability_Pair_0_1_Unmatched,
									params);
					return matchResult;
				}
			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	// TODO fix performance, or eliminate this test
	private static IStatus requirementPairMatch(Unit cu, Unit tu) {
		Object cuReqs[] = cu.getRequirements().toArray();
		Object tuReqs[] = tu.getRequirements().toArray();
		// System.out.println("pairReqProcessing " + cuReqs.length + ":" +
		// tuReqs.length); //$NON-NLS-1$ //$NON-NLS-2$
		// This appears to be between O(N^2) and O(N^3) in practice.
		for (int i = 0; i < cuReqs.length; ++i) {
			Requirement cuReq = (Requirement) cuReqs[i];
			if (isCommunicationReqOnConceptualNode(cuReq)) {
				continue;
			}
			if (ignoreRequirement(cuReq)) {
				continue;
			}
			for (int j = i + 1; j < cuReqs.length; ++j) {
				Requirement cuReqPrime = (Requirement) cuReqs[j];
				if (isCommunicationReqOnConceptualNode(cuReqPrime)) {
					continue;
				}
				if (ignoreRequirement(cuReqPrime)) {
					continue;
				}
				// System.out.println("pair " + cuReq.getName() + ":" +
				// cuReqPrime.getName()); //$NON-NLS-1$//$NON-NLS-2$
				boolean pairMatchFound = false;
				for (int ii = 0; ii < tuReqs.length; ++ii) {
					Requirement tuReq = (Requirement) tuReqs[ii];
					if (isCommunicationReqOnConceptualNode(tuReq)) {
						continue;
					}
					if (reqMatches(cuReq, tuReq, false, false, false, null, null).isOK()) {
						// Test pairs in both orders.
						for (int jj = 0; jj < tuReqs.length; ++jj) {
							Requirement tuReqPrime = (Requirement) tuReqs[jj];
							if (isCommunicationReqOnConceptualNode(tuReqPrime)) {
								continue;
							}
							if (tuReqPrime == tuReq) {
								continue;
							}
							if (reqMatches(cuReqPrime, tuReqPrime, false, false, false, null, null).isOK()) {
								// System.out.println("pairPrime matches " +
								// tuReq.getName() + ":" + tuReqPrime.getName());
								// //$NON-NLS-1$//$NON-NLS-2$
								pairMatchFound = true;
								break;
							}
						}
					}
					if (pairMatchFound) {
						break;
					}
				}
				if (!pairMatchFound) {
					// System.out.println("match not found"); //$NON-NLS-1$
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				}
			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if host is valid.
	 * <p>
	 * If {@link Unit} <i>C</i> is hosted by {@link Unit} <i>D</i>, then
	 * <ol>
	 * <li> <i>FinalRealization(D)</i></a> is not equal to <i>FinalRealization(C)</i></a>; i.e.,
	 * <i>C</i> is not <i>D</i>; and </li>
	 * <li> FinalRealization(C)</i></a> is not in <i>HostsR(D)</i></a>; i.e., <i>D</i> is not
	 * hosted on <i>C</i>; and </li>
	 * <li> <i>HostsR(C)</i></a> can contain at most one concrete {@link Unit}; i.e., there is at
	 * most one host. </li>
	 * </ol>
	 * Target unit may be conceptual or concrete.
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkHoster(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		//		Unit cuHost = RealizationPatternCacheService.INSTANCE.getImmediateHost(cu);
		Unit cuHost = ValidatorUtils.getImmediateHost(cu);
		if (null == cuHost) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// * <li> <i>FinalRealization(D)</i></a> is not equal to
		// * <i>FinalRealization(C)</i></a>; i.e., <i>C</i> is not <i>D</i>; and
		// * </li>
		// FinalRealization(C) is FinalRealization (tu) since tu is the target of
		// RealizationLink
		Unit frC = (Unit) RealizationLinkUtil.getFinalRealization(tu);
		Unit frD = (Unit) RealizationLinkUtil.getFinalRealization(cuHost);
		if (frC == frD) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTER;
		}

		// * <li> FinalRealization(C)</i></a> is not in <i>HostsR(D)</i></a>;
		// * i.e., <i>D</i> is not hosted on <i>C</i>; and </li>
		//		List hostsD = RealizationPatternCacheService.INSTANCE.getAllHosts(cuHost);
		List hostsD = ValidatorUtils.getAllHosts(cuHost);
		if (hostsD.contains(frC)) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTER;
		}

		// * <li> <i>HostsR(C)</i></a> can contain at most one concrete
		// * {@link Unit}; i.e., there is at most one host. </li>
		// hostsR(C) is hostsR(C) union hostsR(U) since realizing C with U
		Set hosts = new HashSet();

		//		List hostsC = RealizationPatternCacheService.INSTANCE.getAllHosts(cu);
		List hostsC = ValidatorUtils.getAllHosts(cu);
		hosts.addAll(hostsC);
		//		List hostsU = RealizationPatternCacheService.INSTANCE.getAllHosts(tu);
		List hostsU = ValidatorUtils.getAllHosts(tu);
		hosts.addAll(hostsU);
// Support multiple realization as of V8M5		
//		if (numNonConceptualUnits(hosts) > 1) {
//			return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTER;
//		}

		// default result; all checks complete
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if hostees are valid.
	 * <p>
	 * For all {@link Unit}s <i>D</i> such that <i>C</i> hosts {@link Unit} <i>D</i>, then
	 * <ol>
	 * <li> <i>FinalRealization(D)</i></a> is not equal to <i>FinalRealization(C)</i></a>; i.e.,
	 * <i>C</i> is not <i>D</i>; and </li>
	 * <li> <i>FinalRealization(D)</i></a> is not in <i>HostsR(C)</i></a>; i.e., <i>C</i> is not
	 * hosted on <i>D</i>; and </li>
	 * <li> <i>HostsR(D)</i></a> can contain at most one concrete {@link Unit}; i.e., <i>C</i> is
	 * hosted by at most 1 {@link Unit}. </li>
	 * </ol>
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkHostees(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		for (Iterator hostees = ValidatorUtils.getHosted(cu).iterator(); hostees.hasNext();) {
			Unit hosteeD = (Unit) hostees.next();

			// <li> <i>FinalRealization(D)</i></a> is not equal to
			// <i>FinalRealization(C)</i></a>; i.e., <i>C</i> is not <i>D</i>
			Unit frD = (Unit) RealizationLinkUtil.getFinalRealization(hosteeD);
			// FinalRealization(C) is FinalRealization (tu) since tu is the target
			// of RealizationLink
			Unit frC = (Unit) RealizationLinkUtil.getFinalRealization(tu);
			if (frD == frC) {
				return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTEES;
			}

			// <li> <i>FinalRealization(D)</i></a> is not in <i>HostsR(C)</i></a>;
			// i.e., <i>C</i> is not hosted on <i>D</i>
			// hostsR(C) is hostsR(C) union hostsR(U) since realizing C with U
			//			List hostsC = RealizationPatternCacheService.INSTANCE.getAllHosts(cu);
			List hostsC = ValidatorUtils.getAllHosts(cu);
			//			List hostsU = RealizationPatternCacheService.INSTANCE.getAllHosts(tu);
			List hostsU = ValidatorUtils.getAllHosts(tu);
			if (hostsC.contains(frD) || hostsU.contains(frD)) {
				return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTEES;
			}

			// <li> <i>HostsR(D)</i></a> can contain at most one concrete
			// {@link Unit}; i.e., <i>C</i> is hosted by at most 1 {@link Unit}.
			//			List hostsD = RealizationPatternCacheService.INSTANCE.getAllHosts(hosteeD);
			// Updated in V8M5 to avoid flagging multiple concrete hosts as an issue.			
//			List hostsD = ValidatorUtils.getAllHosts(hosteeD);
//			if (numNonConceptualUnits(hostsD) > 1) {
//				return DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTEES;
//			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if targets are valid.
	 * <p>
	 * For every {@link Requirement} <i>r</i> on <i>C</i> such that <tt>r.getLink()</tt> is not
	 * empty, then <i>TargetsR(r)</i></a> can contain at most one {@link Capability} on a concrete
	 * {@link Unit}
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkTarget(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		List reqs = cu.getDependencyOrAnyRequirements();
		for (int i = 0; i < reqs.size(); i++) {
			Requirement cr = (Requirement) reqs.get(i);
			DependencyLink link = cr.getLink();
			if (link == null) {
				continue;
			}
			// Capability tc = link.getTarget();

			// targetsR(cr) is targetsR(cr) union targetsR(tr) since realizing cu
			// with tu
			Set targets = new HashSet();
			List targetsR = ValidatorUtils.getDependencyLinkTargets(cr);
			targets.addAll(targetsR);

			Map rMap = matchRequirements(cu, tu, null, null);
			if (null != getUnmatchedRequirement(rMap)) {
				// should not happen because this was checked earlier
				return DeployMatcherStatus.CONCEPTUAL_INVALID_DL_TARGET;
			}
			Set S = (Set) rMap.get(cr);
			// find a tr that works
			boolean works = false;
			for (Iterator it = S.iterator(); it.hasNext();) {
				Requirement tr = (Requirement) it.next();
				List targetsTR = ValidatorUtils.getDependencyLinkTargets(tr);
				targets.addAll(targetsTR);
				if (numNonConceptualUnits(targets) <= 1) {
					works = true;
					break;
				}
				// should modify rMap
			}
			if (!works) {
				return DeployMatcherStatus.MATCH_FOUND;
			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if sources are valid.
	 * <p>
	 * For every {@link Capability} <i>c</i> on <i>C</i> such that there is an <i>r</i> that
	 * depends on <i>c</i>; i.e., there is a {@link DependencyLink} from <i>r</i> to <i>c</i>,
	 * then <i>TargetsR(r)</i></a> can contain at most one {@link Capability} on a concrete
	 * {@link Unit}
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkSources(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		// Removing unused local variables
		// List cuCaps = cu.getCapabilities();
		// for (int i = 0; i < cuCaps.size(); i++) {
		// Capability cuCap = (Capability) cuCaps.get(i);
		// // find link terminating at cuCap
		// // this seems like an expensive test for matching
		// // sources can be in any topology
		// // return DeployMatcherStatus.CONCEPTUAL_INVALID_DL_SOURCES;
		// }
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if containing groups are valid.
	 * <p>
	 * <ol>
	 * <li> <i>FinalRealization(C)</i></a> is not in <i>GroupsR(C)</i></a>; i.e., <i>C</i>
	 * cannot be contained in itself; and</li>
	 * <li>The concrete members of <i>GroupsR(C)</i></a> satisfy the {@link InCardinality}
	 * requirements on unit <i>C</i>; and</li>
	 * </ol>
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkGroups(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// * <li> <i>FinalRealization(C)</i></a> is not in <i>GroupsR(C)</i></a>;
		// * i.e., <i>C</i> cannot be contained in itself; and</li>
		// FinalRealization(C) is FinalRealization (tu) since tu is the target of
		// RealizationLink
		Unit frC = (Unit) RealizationLinkUtil.getFinalRealization(tu);

		// groupsR(cu) is groupsR(cu) union groupsR(tu) since realizing cu with tu
		List groupsC = ValidatorUtils.getGroups(cu);
		List groupsU = ValidatorUtils.getGroups(tu);

		if (groupsC.contains(frC) || groupsU.contains(frC)) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_GROUPS;
		}

		// * <li>The concrete members of <i>GroupsR(C)</i></a> satisfy the
		// * {@link InCardinality} requirements on unit <i>C</i>; and</li>
		Set ncGroups = selectNonConceptualUnits(groupsC);
		ncGroups.addAll(selectNonConceptualUnits(groupsU));

		if (!inCardinalityChecks(cu, ncGroups)) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_GROUPS;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if group members are valid.
	 * <p>
	 * <ol>
	 * <li> <i>FinalRealization(C)</i></a> is not in <i>MembersR(C)</i></a>; i.e., <i>C</i>
	 * cannot contain itself; and </li>
	 * <li> The concrete members of <i>MembersR(C)</i></a> satisify the {@link OutCardinality}
	 * requirements on unit <i>C</i>. </li>
	 * </ol>
	 * 
	 * @param cu
	 *           Conceptual unit which link would realize
	 * @param tu
	 *           Candidate target unit which would realize source unit
	 * @param context
	 *           Context of realization ie, set of related topologies
	 * @return IStatus.MATCH_FOUND or ISTATUS.MATCH_NOT_FOUND
	 */
	private static IStatus checkMembers(Unit cu, Unit tu) {
		if (null == cu || null == tu) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// * <li> <i>FinalRealization(C)</i></a> is not in <i>MembersR(C)</i></a>;
		// * i.e., <i>C</i> cannot contain itself; and </li>
		// FinalRealization(C) is FinalRealization (tu) since tu is the target of
		// RealizationLink
		Unit frC = (Unit) RealizationLinkUtil.getFinalRealization(tu);

		// membersR(C) is membersR(C) union membersR(U) since realizing C with U
		List membersC = ValidatorUtils.getMembers(cu);
		List membersU = ValidatorUtils.getMembers(tu);

		if (membersC.contains(frC) || membersU.contains(frC)) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_MEMBERS;
		}

		// * <li> The concrete members of <i>MembersR(C)</i></a> satisify
		// the
		// * {@link OutCardinality} requirements on unit <i>C</i>. </li>
		Set ncMembers = selectNonConceptualUnits(membersC);
		ncMembers.addAll(selectNonConceptualUnits(membersU));

		if (!outCardinalityChecks(cu, ncMembers)) {
			return DeployMatcherStatus.CONCEPTUAL_INVALID_MEMBERS;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Determine if stereotypes are valid.
	 * 
	 * @param cdmo
	 *           DMO which link would realize
	 * @param tdmo
	 *           Candidate DMO unit which would realize source Dmo
	 * @return appropriate status of match attempt
	 */
	private static IStatus checkStereotypes(DeployModelObject cdmo, DeployModelObject tdmo,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (null == cdmo || null == tdmo) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		List<Stereotype> cSts = null;
		List<Stereotype> tSts = null;
		if (cdmo instanceof Unit && tdmo instanceof Unit) {
			cSts = ((Unit) cdmo).getStereotypes();
			tSts = ((Unit) tdmo).getStereotypes();
		} else if (cdmo instanceof Capability && tdmo instanceof Capability) {
			cSts = ((Capability) cdmo).getStereotypes();
			tSts = ((Capability) tdmo).getStereotypes();
		}

		// No source stereotypes, nothing to match
		if (cSts == null) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		List<String> targetStereotypes = new ArrayList<String>();
		if (tSts != null) {
			Iterator<Stereotype> it = tSts.iterator();
			while (it.hasNext()) {
				Stereotype targetSt = it.next();
				String target_keyword = targetSt.getKeyword();
				targetStereotypes.add(target_keyword);
			}
		}

		Iterator<Stereotype> it2 = cSts.iterator();
		String missingStereotypes = null;
		while (it2.hasNext()) {
			Stereotype sourceSt = it2.next();
			if (sourceSt.isRequired()) {
				String source_keyword = sourceSt.getKeyword();
				if (!targetStereotypes.contains(source_keyword)) {
					if (missingStereotypes == null) {
						missingStereotypes = source_keyword;
					} else {
						missingStereotypes += "," + source_keyword; //$NON-NLS-1$
					}
				}
			}
		}
		if (missingStereotypes != null) {
			return reportUnmatchedStereotype(cdmo, tdmo, missingStereotypes, context, reporter);
		} else {
			return DeployMatcherStatus.MATCH_FOUND;
		}

	}

	private static boolean inCardinalityChecks(Unit cu, Set groups) {
		// TODO implement
		return true;
	}

	private static boolean outCardinalityChecks(Unit cu, Set members) {
		// TODO implement
		return true;
	}

	/**
	 * Count the number of conceptual units in a collection of units.
	 * 
	 * @param units
	 *           the collection of units
	 * @return the number of units where {@link Unit#isConceptual()} is true
	 */
	private static int numNonConceptualUnits(Collection units) {
		return selectNonConceptualUnits(units).size();
	}

	/**
	 * Return a set of the concrete units in a given collection.
	 * 
	 * @param units
	 *           the units to be considered
	 * @return Set of concrete units
	 */
	private static Set selectNonConceptualUnits(Collection units) {
		Set ncUnits = new HashSet();

		if (null == units) {
			return ncUnits;
		}

		for (Iterator it = units.iterator(); it.hasNext();) {
			DeployModelObject o = (DeployModelObject) it.next();
			Unit unit = null;
			if (o instanceof Capability || o instanceof Requirement) {
				unit = (Unit) o.getParent();
			} else if (o instanceof Unit) {
				unit = (Unit) o;
			}

			if (!unit.isConceptual()) {
				ncUnits.add(unit);
			}
		}

		return ncUnits;
	}

	/**
	 * Create a mapping from the requirements of a conceptual unit to the requirements of a target
	 * unit. Each entry in the map is a Set of requirement that can match.
	 * 
	 * <p>
	 * If the source Unit has multiple realization links out of it, there could be multiple valid
	 * matches for the Requirements.
	 * </p>
	 * 
	 * @param cu
	 *           the source (conceptual) unit
	 * @param tu
	 *           the target unit
	 * @return a Map of Sets of requirements; null if no consistent mapping can be found.
	 */
	private static Map<Requirement, Set<Requirement>> matchRequirements(Unit cu, Unit tu,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (null == cu || null == tu) {
			return null;
		}

		List<Requirement> cuReqs = new ArrayList<Requirement>(cu.getRequirements());
		List<Requirement> tuReqs = new ArrayList<Requirement>(tu.getRequirements());
		HashMap rMap = new HashMap();

		for (Iterator<Requirement> iter = cuReqs.iterator(); iter.hasNext();) {
			Requirement cuReq = iter.next();
			if (ignoreRequirement(cuReq)) {
				iter.remove();
			} else {
				Requirement[] reqRealization = RealizationLinkUtil.getRealizations(cuReq);
				for (int j = 0; j < reqRealization.length; j++) {
					if (reqRealization[j] != null && !reqRealization[j].equals(cuReq)) {
						// Remove this req->req realization from consideration, after adding
						// to results map
						if (tuReqs.contains(reqRealization[j])) {
							iter.remove();
							tuReqs.remove(reqRealization[j]);
							HashSet s = new HashSet();
							s.add(reqRealization[j]);
							rMap.put(cuReq, s);
						} else {
							// Error. Does UnitValidator already check for this?
						}
					}
				}
			}
		}

		for (int i = 0; i < cuReqs.size(); i++) {
			HashSet S = new HashSet();
			Requirement cuReq = cuReqs.get(i);
			if (isCommunicationReqOnConceptualNode(cuReq)) {
				continue;
			}
			for (int j = 0; j < tuReqs.size(); j++) {
				Requirement tuReq = tuReqs.get(j);
				if (isCommunicationReqOnConceptualNode(tuReq)) {
					continue;
				}
				if (reqMatches(cuReq, tuReq, true, false, false, context, reporter).isOK()) {
					S.add(tuReq);
				}
			}
			if (S.size() == 0) {
				// mapInconsistent = true;
				// TODO for matching break early (still need to update rMap)
				// break;
			}
			rMap.put(cuReq, S);
		}
		// return mapInconsistent ? null : filterRMap(rMap);
		return filterRMap(rMap);
	}

	/**
	 * Filters a requirements mapping (@see #matchRequirements(Unit, Unit)) by removing options from
	 * Sets if a target requirement can be identified as unique in any other given matching.
	 * 
	 * @param rMap
	 *           the requirements map
	 * @return a refiend requirements map or null if no consistent mapping can be found
	 */
	private static Map filterRMap(Map rMap) {
		boolean mapInconsistent = false;
		boolean change = true;
		while (change && !mapInconsistent) {
			change = false;
			for (Iterator it = rMap.keySet().iterator(); it.hasNext();) {
				Requirement ri = (Requirement) it.next();
				Set Si = (Set) rMap.get(ri);

				if (Si.size() == 0) {
					mapInconsistent = true;
					break;
				}

				if (Si.size() == 1) {
					Object SiElement = Si.toArray()[0];
					for (Iterator jt = rMap.keySet().iterator(); jt.hasNext();) {
						Requirement rj = (Requirement) jt.next();
						if (ri != rj) {
							Set Sj = (Set) rMap.get(rj);
							Sj.remove(SiElement);
							rMap.put(rj, Sj);
							if (Sj.size() == 0) {
								mapInconsistent = true;
								break;
							}
						}
					}
				}

			}
		}

		// return mapInconsistent ? null : rMap;
		return rMap;
	}

	/**
	 * Create a mapping from the capabilities of a conceptual unit to the capabilities of a target
	 * unit. Each entry in the map is a Set of capability that can match.
	 * 
	 * @param cu
	 *           the source (conceptual) unit
	 * @param tu
	 *           the target unit
	 * @return a Map of Sets of capabilities; null if no consistent mapping can be found.
	 */
	private static Map<Capability, Set<Capability>> matchCapabilities(Unit cu, Unit tu,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (null == cu || null == tu) {
			return null;
		}

		Map<Capability, Set<Capability>> cMap = new HashMap();

		List<Capability> cuCaps = new ArrayList<Capability>(cu.getCapabilities());
		List<Capability> tuCaps = new ArrayList<Capability>(tu.getCapabilities());

		for (Iterator<Capability> iter = cuCaps.iterator(); iter.hasNext();) {
			Capability cuCap = iter.next();
			if (ignoreCapability(cuCap)) {
				iter.remove();
			} else {
				Capability[] capRealizations = RealizationLinkUtil.getRealizations(cuCap);
				for (int j = 0; j < capRealizations.length; j++) {
					if (capRealizations[j] != null && !capRealizations[j].equals(cuCap)) {
						// Remove this cap->cap realization from consideration, after adding
						// to results map
						if (tuCaps.contains(capRealizations[j])) {
							iter.remove();
							tuCaps.remove(capRealizations[j]);
							HashSet s = new HashSet();
							s.add(capRealizations[j]);
							cMap.put(cuCap, s);
						} else {
							// Error. Does UnitValidator already check for this?
						}
					}
				}
			}
		}

		for (int i = 0; i < cuCaps.size(); i++) {
			HashSet S = new HashSet();
			Capability cuCap = cuCaps.get(i);
			if (isCommunicationCapOnConceptualNode(cuCap)) {
				continue;
			}
			Capability tuCapTypeMatch = null;
			for (int j = 0; j < tuCaps.size(); j++) {
				Capability tuCap = tuCaps.get(j);
				if (isCommunicationCapOnConceptualNode(tuCap)) {
					continue;
				}
				IStatus capMatchesStatus = capMatches(cuCap, tuCap, true, false, true, false, null,
						null);
				if (capMatchesStatus.isOK()) {
					S.add(tuCap);
				} else if (capTypesMatch(cuCap, tuCap)) {
					// Attribute mismatch?
					tuCapTypeMatch = tuCap;
				}
			}
			if (S.size() == 0) {
				// If a type match was found but not a full capability match, then
				// report statuses
				if (tuCapTypeMatch != null) {
					capMatches(cuCap, tuCapTypeMatch, true, false, true, false, context, reporter);
				}
			}
			cMap.put(cuCap, S);
		}
		return filterCMap(cMap);
	}

	private static IStatus dmoConstraintsSatisfiedOnNCFR(DeployModelObject cDmo,
			DeployModelObject tDmo, boolean validationMode, IProgressMonitor monitor) {
		if (cDmo.getConstraints().size() == 0) {
			return DeployMatcherStatus.MATCH_FOUND;
		}
		DeployModelObject tDmoFR = RealizationLinkUtil.getImplicitFinalRealization(tDmo);
		if (ValidatorUtils.getUnit(tDmoFR).isConceptual()) {
			return DeployMatcherStatus.MATCH_FOUND;
		}
		for (Constraint c : (List<Constraint>) cDmo.getConstraints()) {
			IStatus s = null;
			if (validationMode) {
				s = ConstraintService.INSTANCE.validate(c, tDmoFR, monitor);
			} else {
				s = ConstraintService.INSTANCE.validateForPotentialMatch(c, tDmoFR);
			}
			if (!s.isOK()) {
				if (!(s instanceof IDeployStatus && ((IDeployStatus) s).getProblemType().equals(
						ICoreProblemType.CONSTRAINT_CONTEXT_INVALID))) {

					Object params[] = { s.getMessage() };
					IStatus matchResult = DeployMatcherStatus
							.createMatchNotFound(
									DeployMatcherStatus.CUSTOM_MESSAGE_CODE,
									DeployCoreMessages.DeployMatcherStatus_Realization_Constraint_Not_Satisfied_On_Final_Realization,
									params);
					return matchResult;
				}
			}
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	private static boolean capTypesMatch(Capability cuCap, Capability tuCap) {
		return cuCap.getEObject().eClass().isSuperTypeOf(tuCap.getEObject().eClass());
	}

	/**
	 * Filters a requirements mapping (@see #matchRequirements(Unit, Unit)) by removing options from
	 * Sets if a target requirement can be identified as unique in any other given matching.
	 * 
	 * @param rMap
	 *           the requirements map
	 * @return a refiend requirements map or null if no consistent mapping can be found
	 */
	private static Map filterCMap(Map cMap) {
		boolean mapInconsistent = false;
		boolean change = true;
		while (change && !mapInconsistent) {
			change = false;
			for (Iterator it = cMap.keySet().iterator(); it.hasNext();) {
				Capability ri = (Capability) it.next();
				Set Si = (Set) cMap.get(ri);

				if (Si.size() == 0) {
					mapInconsistent = true;
					break;
				}

				if (Si.size() == 1) {
					Object SiElement = Si.toArray()[0];
					for (Iterator jt = cMap.keySet().iterator(); jt.hasNext();) {
						Capability rj = (Capability) jt.next();
						if (ri != rj) {
							Set Sj = (Set) cMap.get(rj);
							Sj.remove(SiElement);
							cMap.put(rj, Sj);
							if (Sj.size() == 0) {
								mapInconsistent = true;
								break;
							}
						}
					}
				}

			}
		}

		// return mapInconsistent ? null : cMap;
		return cMap;
	}

	/**
	 * Identify the {@link Requirement} ({@link Capability}) in a requirement (capability) mapping
	 * that does not have any corresponing requirement (capability).
	 * 
	 * @param map
	 *           the requirement or capability map
	 * @return first unmatched entry found in map
	 */
	private static DeployModelObject getUnmatchedEntry(Map map) {
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			DeployModelObject reqCap = (DeployModelObject) it.next();
			Set Si = (Set) map.get(reqCap);

			if (Si.size() == 0) {
				return reqCap;
			}

		}
		return null;
	}

	/**
	 * Identify the {@link Requirement} ({@link Capability}) in a requirement (capability) mapping
	 * that does not have any corresponding requirement (capability).
	 * 
	 * @param map
	 *           the requirement or capability map
	 * @return set of unmatched entries. empty set if no unmatched entries.
	 */
	private static Set getUnmatchedEntries(Map map) {
		HashSet unmatchedEntries = new HashSet();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			DeployModelObject reqCap = (DeployModelObject) it.next();
			Set Si = (Set) map.get(reqCap);

			if (Si.size() == 0) {
				unmatchedEntries.add(reqCap);
			}
		}
		return unmatchedEntries;
	}

	/**
	 * Identify the {@link Requirement} in a requirement mapping that does not have any corresponing
	 * requirement.
	 * 
	 * @param map
	 *           the requirement map
	 * @return true if each source (key) requirement has a non-empty matching set
	 */
	private static Requirement getUnmatchedRequirement(Map map) {
		return (Requirement) getUnmatchedEntry(map);
	}

	/**
	 * Validate the implementation of the realization link.
	 * 
	 * @param link
	 *           the link whose source unit is validated.
	 * @param source
	 *           the {@link DeployModelObject} whose realization is to be validated.
	 * @param target
	 *           the target of the realization link.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	public static void validateRealizationLink(RealizationLink link, DeployModelObject source,
			DeployModelObject target, IDeployValidationContext context, IDeployReporter reporter) {

		if (source == null || target == null) {
			return;
		}
		assert null != link;

		IDeployStatus status = null;

		IStatus result = isLinkValid(source, target, link, context, reporter);
		if (null == result || result.isOK()) {
			return;
		}

		for (StatusIterator sIt = new StatusIterator(result); sIt.hasNext();) {
			IStatus s = sIt.next();
			if (s.isMultiStatus()) {
				continue;
			}
			// TODO merge DeployMatcherStatus and DeployStatus, to reduce/eliminate
			// need for mapping
			if (s.equals(DeployMatcherStatus.REALIZATION_LINK_TYPE_MISMATCH)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.REALIZATION_LINK_003,
						ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH,
						DeployCoreMessages.Validator_realization_link_source_0_target_1_type_mismatch,
						new Object[] { source.eClass().getName(), target.eClass().getName() }, link);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.SOURCE_NOT_CONCEPTUAL)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_UNIT_002,
						ICoreProblemType.NON_CONCEPTUAL_UNIT_REALIZED,
						DeployCoreMessages.Validator_non_conceptual_unit_0_realized_in_link_1,
						new Object[] { source, link }, link);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CANNOT_CREATE_LINK_TO_SELF)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.REALIZATION_LINK_004,
						ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_SAME,
						DeployCoreMessages.Validator_realization_link_source_target_same,
						new Object[] {}, source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTER)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_HOSTER_001,
						ICoreProblemType.CONCEPTUAL_INVALID_HOSTER, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_HOSTEES)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_HOSTEES_001,
						ICoreProblemType.CONCEPTUAL_INVALID_HOSTEES, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_DL_TARGET)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_DL_TARGET_001,
						ICoreProblemType.CONCEPTUAL_INVALID_DL_TARGET, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_DL_SOURCES)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_DL_SOURCES_001,
						ICoreProblemType.CONCEPTUAL_INVALID_DL_SOURCES, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_GROUPS)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_GROUPS_001,
						ICoreProblemType.CONCEPTUAL_INVALID_GROUPS, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
			} else if (s.equals(DeployMatcherStatus.CONCEPTUAL_INVALID_MEMBERS)) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONCEPTUAL_INVALID_MEMBERS_001,
						ICoreProblemType.CONCEPTUAL_INVALID_MEMBERS, s.getMessage(), new Object[] {},
						source);
				reporter.addStatus(status);
				// } else if (!s.equals(DeployMatcherStatus.MATCH_NOT_FOUND)) {
				// status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
				// IStatus.ERROR,
				// IDeployCoreValidators.REALIZATION_LINK_011,
				// ICoreProblemType.REALIZATION_LINK_INVALID,
				// s.getMessage(),
				// new Object[] {}, source);
				// reporter.addStatus(status);
			} else {
				// String msg = s.getMessage();
				// System.out.println("msg=" + msg); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Check if a realization link between a given source and target is valid.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @param target
	 *           the target of the realization link
	 * @param context
	 *           the validation context
	 * @param reporter
	 *           reporter for reporting statuses in-line. If null, then no statuses are reported
	 * @return a IStatus (typically from class {@link DeployMatcherStatus} indicating the validity of
	 *         the link.
	 */
	private static IStatus isLinkValid(DeployModelObject source, DeployModelObject target,
			RealizationLink rl, IDeployValidationContext context, IDeployReporter reporter) {
		IStatus result = DeployMatcherStatus.MATCH_NOT_FOUND;
		if (source instanceof Unit && target instanceof Unit) {
			result = checkUnitMatch((Unit) source, (Unit) target, rl, context, reporter);
		} else if (source instanceof Capability && target instanceof Capability) {
			result = checkCapabilityMatch((Capability) source, (Capability) target, rl, context,
					reporter);
		} else if (source instanceof Requirement && target instanceof Requirement) {
			result = checkRequirementMatch((Requirement) source, (Requirement) target, rl, context,
					reporter);
		} else {
			result = DeployMatcherStatus.REALIZATION_LINK_TYPE_MISMATCH;
		}
		return result;
	}

	/**
	 * This is a validation test. It is not used for matching.
	 * 
	 * @param cu
	 * @param tu
	 * @param rl
	 * @param context
	 * @param reporter
	 * @return
	 */
	protected static IStatus checkUnitMatch(Unit cu, Unit tu, RealizationLink rl,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (!cu.isConceptual()) {
			return DeployMatcherStatus.SOURCE_NOT_CONCEPTUAL;
		}

		if (!cu.getEObject().eClass().isSuperTypeOf(tu.getEObject().eClass())
				&& !(cu instanceof ConceptualNode)) {
			return DeployMatcherStatus.REALIZATION_LINK_TYPE_MISMATCH;
		}

		if (cu.equals(tu)) {
			return DeployMatcherStatus.CANNOT_CREATE_LINK_TO_SELF;
		}

		if (hasFinalRealizationCycle(cu, null)) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REALIZATION_LINK_007, ICoreProblemType.REALIZATION_CYCLE,
					DeployMatcherStatus.REALIZATION_CYCLE.getMessage(), new Object[] {}, cu);
			reporter.addStatus(status);
			return DeployMatcherStatus.REALIZATION_CYCLE;
		}

		if (cu instanceof ConceptualNode) {
			conceptualNodeMatch((ConceptualNode) cu, tu, rl, context, reporter);
		}

		// Simple capabilities match
		Map<Capability, Set<Capability>> cMap = matchCapabilities(cu, tu, context, reporter);
		Set unMatchedCapabilities = getUnmatchedEntries(cMap);
		if (unMatchedCapabilities.size() > 0) {
			Capability anUnmatchedCap = (Capability) unMatchedCapabilities.toArray()[0];
			Object params[] = { anUnmatchedCap.getCaptionProvider().titleWithContext(anUnmatchedCap) };
			IStatus matchResult = DeployMatcherStatus.createMatchNotFound(
					DeployMatcherStatus.REALIZATION_LINK_UNMATCHED_CAPABILITY,
					DeployCoreMessages.DeployMatcherStatus_Realization_Capability_0_Unmatched, params);
			if (reporter == null) {
				return matchResult;
			}
			for (Iterator unmatchedCapsIter = unMatchedCapabilities.iterator(); unmatchedCapsIter
					.hasNext();) {
				Capability unMatchedCapability = (Capability) unmatchedCapsIter.next();
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_005,
						ICoreProblemType.REALIZATION_LINK_INVALID,
						DeployCoreMessages.DeployMatcherStatus_Realization_Capability_0_Unmatched,
						new Object[] { unMatchedCapability.getCaptionProvider().titleWithContext(
								unMatchedCapability) }, unMatchedCapability);
				reporter.addStatus(status);
			}
		}

		// TODO Add pair-caps test

		// Simple requirements match
		Map<Requirement, Set<Requirement>> rMap = matchRequirements(cu, tu, context, reporter);
		Set unMatchedRequirements = getUnmatchedEntries(rMap);
		if (unMatchedRequirements.size() > 0) {
			Requirement anUnmatchedReq = (Requirement) unMatchedRequirements.toArray()[0];
			Object params[] = { (anUnmatchedReq.getDisplayName() != null ? anUnmatchedReq
					.getDisplayName() : anUnmatchedReq.getName()) };
			IStatus matchResult = DeployMatcherStatus.createMatchNotFound(
					DeployMatcherStatus.REALIZATION_LINK_UNMATCHED_REQUIREMENT,
					DeployCoreMessages.DeployMatcherStatus_Realization_Requirement_0_Unmatched, params);
			if (reporter == null) {
				return matchResult;
			}
			for (Iterator unmatchedReqsIter = unMatchedRequirements.iterator(); unmatchedReqsIter
					.hasNext();) {
				Requirement unMatchedReq = (Requirement) unmatchedReqsIter.next();

				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_006,
						ICoreProblemType.REALIZATION_LINK_UNMATCHED_REQUIREMENT,
						DeployCoreMessages.DeployMatcherStatus_Realization_Requirement_0_Unmatched,
						new Object[] { (unMatchedReq.getDisplayName() != null ? unMatchedReq
								.getDisplayName() : unMatchedReq.getName()) }, unMatchedReq);
				reporter.addStatus(status);
			}
		}

		IStatus unitAttributesMatchResult = unitAttributesMatch(cu, tu, context, reporter);
		if (!unitAttributesMatchResult.isOK() && reporter == null) {
			return unitAttributesMatchResult;
		}

		// TODO is this test redundant on validation? 
		// Constraint validate for potential match
		IStatus s = dmoConstraintsSatisfiedOnNCFR(cu, tu, true, context != null ? context
				.getProgressMonitor() : null);
		if (!s.isOK()) {
			Object params[] = { s.getMessage() };
			IStatus matchResult = DeployMatcherStatus
					.createMatchNotFound(
							DeployMatcherStatus.CUSTOM_MESSAGE_CODE,
							DeployCoreMessages.DeployMatcherStatus_Realization_Constraint_Not_Satisfied_On_Final_Realization,
							params);
			return matchResult;
		}

		// TODO Add pair-reqs test

		IStatus matchResultExtendedAttrs = extendedAttributesMatch(cu, tu, true, context, reporter);
		if (!matchResultExtendedAttrs.isOK() && reporter == null) {
			return matchResultExtendedAttrs;
		}

		IStatus matchResultHost = checkHoster(cu, tu);
		if (!matchResultHost.isOK()) {
			return matchResultHost;
		}

		// Hostees
		IStatus matchResultHostees = checkHostees(cu, tu);
		if (!matchResultHostees.isOK()) {
			return matchResultHostees;
		}

		// Target
		IStatus matchResultTarget = checkTarget(cu, tu);
		if (!matchResultTarget.isOK()) {
			return matchResultTarget;
		}

		// Sources
		IStatus matchResultSources = checkSources(cu, tu);
		if (!matchResultSources.isOK()) {
			return matchResultSources;
		}

		// Groups
		IStatus matchResultGroups = checkGroups(cu, tu);
		if (!matchResultGroups.isOK()) {
			return matchResultGroups;
		}

		// Members
		IStatus matchResultMembers = checkMembers(cu, tu);
		if (!matchResultMembers.isOK()) {
			return matchResultMembers;
		}

		// Stereotypes
//		IStatus matchResultStereotypes = checkStereotypes(cu, tu);
//		if (!matchResultStereotypes.isOK()) {
//			return matchResultStereotypes;
//		}

		IStatus matchResultStereotypes = checkStereotypes(cu, tu, context, reporter);
		if (!matchResultStereotypes.isOK() && reporter == null) {
			return matchResultStereotypes;
		}

		// TODO complete implemention
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Validate an existing capability-to-capability realization link
	 * 
	 * @param cuCap
	 * @param tuCap
	 * @param context
	 * @param reporter
	 * @return
	 */
	private static IStatus checkCapabilityMatch(Capability cuCap, Capability tuCap,
			RealizationLink rl, IDeployValidationContext context, IDeployReporter reporter) {
		// TODO parent units realization linked, capabilities match, parent units
		// distinct
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Validate an existing requirement-to-requirement realization link
	 * 
	 * @param cuReq
	 * @param tuReq
	 * @param context
	 * @param reporter
	 * @return
	 */
	private static IStatus checkRequirementMatch(Requirement cuReq, Requirement tuReq,
			RealizationLink rl, IDeployValidationContext context, IDeployReporter reporter) {
		// TODO parent units realization linked, requirements match, parent units
		// distinct
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Return true if a realization cycle is found starting with the {@link DeployModelObject}
	 * <p>
	 * If a realization link cycle is found, then return true
	 * <p>
	 * Otherwise, return false
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit},
	 * {@link Capability}, or {@link Requirement}. Again, this method does not check this
	 * condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @param realization
	 *           optional realization target. Otherwise, determined from realization link
	 * @return true if a realization cycle is found, false otherwise
	 */
	private static boolean hasFinalRealizationCycle(DeployModelObject source,
			DeployModelObject realization) {
		return hasFinalRealizationCycle(source, realization, false);
	}

	/**
	 * Return true if a realization cycle is found starting with the {@link DeployModelObject}
	 * <p>
	 * Implicit realizations are followed.
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit},
	 * {@link Capability}, or {@link Requirement}. Again, this method does not check this
	 * condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @param realization
	 * @return true if a realization cycle is found, false otherwise
	 */
	//	public static boolean hasImplicitFinalRealizationCycle(DeployModelObject source,
	//			DeployModelObject realization) {
	//		return hasFinalRealizationCycle(source, realization, true);
	//	}
	/**
	 * Returns true if a realization cycle is found, false otherwise
	 * 
	 * @param source
	 *           the realization source.
	 * @param realization
	 *           optional realization target. Otherwise, determined from realization link optional
	 *           realization target. Otherwise, determined from realization link
	 * @param implicit
	 *           true if implicit realizations should be honored (see
	 *           {@link #getImplicitRealizations(DeployModelObject)}.
	 * @return true if a realization cycle is found, false otherwise
	 */
	private static boolean hasFinalRealizationCycle(DeployModelObject source,
			DeployModelObject realization, boolean implicit) {
		if (null == source) {
			return false;
		}

		HashSet<DeployModelObject> visitSet = new HashSet<DeployModelObject>();
		visitSet.add(source);

		if (realization == null) {
			DeployModelObject[] nextRealizations = null;
			nextRealizations = implicit ? RealizationLinkUtil.getImplicitRealizations(source)
					: RealizationLinkUtil.getRealizations(source);
			for (int i = 0; i < nextRealizations.length; i++) {
				visitSet.add(nextRealizations[i]);
			}
			for (int i = 0; i < nextRealizations.length; i++) {
				if (hasFinalRealizationCycle(nextRealizations[i], visitSet, implicit)) {
					return true;
				}
			}
			return false;

		}

		visitSet.add(realization);
		return hasFinalRealizationCycle(realization, visitSet, implicit);
	}

	private static final boolean hasFinalRealizationCycle(DeployModelObject source,
			Set<DeployModelObject> realizations, boolean implicit) {
		DeployModelObject[] nextRealizations = null;
		if (source != null) {
			nextRealizations = implicit ? RealizationLinkUtil.getImplicitRealizations(source)
					: RealizationLinkUtil.getRealizations(source);
			if (nextRealizations.length == 0) {
				// not realized;
				return false;
			}
			for (int i = 0; i < nextRealizations.length; i++) {
				if (realizations.contains(nextRealizations[i])) {
					// cycle
					return true;
				}
				realizations.add(nextRealizations[i]);
				return hasFinalRealizationCycle(nextRealizations[i], realizations, implicit);
			}
		}
		return false;
	}

	static private class CapPair {
		Capability _cap1;
		Capability _cap2;

		CapPair(Capability cap1, Capability cap2) {
			_cap1 = cap1;
			_cap2 = cap2;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + (_cap1 == null ? 0 : _cap1.hashCode());
			result = PRIME * result + (_cap2 == null ? 0 : _cap2.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final CapPair other = (CapPair) obj;
			if (_cap1 == null) {
				if (other._cap1 != null) {
					return false;
				}
			} else if (!_cap1.equals(other._cap1)) {
				return false;
			}
			if (_cap2 == null) {
				if (other._cap2 != null) {
					return false;
				}
			} else if (!_cap2.equals(other._cap2)) {
				return false;
			}
			return true;
		}

	}

}
