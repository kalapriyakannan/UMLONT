/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.MemberCardinalityConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;

/**
 * Check for valid multiplicity.
 * 
 * <p>
 * TODO If there is a Java-originated membership constraint as well as a Requirement.MEMBER on the
 * Unit, which takes precedence?
 * 
 * <p>
 * NOTE: A Unit can be a link source if it has a Requirement with linktype MEMBER and that
 * Requirement has either at least one OutCardinality (or one {@link MemberCardinalityConstraint})
 * or it has no InCardinality (no {@link GroupCardinalityConstraint}).
 */
public class MultiplicityChecker {

//	private final static Collection constraints = new LinkedList();

	private static Map<EClass, Requirement> ctmMemberReqMap = new ConcurrentHashMap<EClass, Requirement>();
	private static Map<EClass, Requirement> csmMemberReqMap = new ConcurrentHashMap<EClass, Requirement>();

	/**
	 * Unbounded range boundary (+infinity).
	 */
	public static final int RANGE_UNBOUNDED = -1;

	/**
	 * The range boundary is malformed (e.g., 'lemon..chicken').
	 */
	public static final int RANGE_MALFORMED = -2;

	/**
	 * Would it be legal to add a MemberLink between 'source' and 'target'?
	 * 
	 * @param source
	 * @param target
	 * @param respectMultiplicity
	 *           if <code>false</code>, loosen rules by not insisting in respecting multiplicity
	 * @return <code>true</code> if a link would be correct if added
	 */
	static public boolean newMemberLinkOK(Unit source, Unit target, boolean respectMultiplicity) {
		MultiplicityConstraint constraint = getConstraint(source, target);

		// If there is no constraint, the link is not valid
		if (constraint == null) {
			return false;
		}

		// Relationships are allowed; skip multiplicity check if possible
		if (!respectMultiplicity) {
			return true;
		}

		int currentSourceMultiplicity = calculateSourceMultiplicity(source, target.eClass(), null);
		int currentTargetMultiplicity = calculateTargetMultiplicity(target, source.eClass(), null);

		// MK 8/16/2007 - changed to allow link if not enough but not if too many
		return currentSourceMultiplicity + 1 <= constraint.sourceMaxOccurs()
				&& currentTargetMultiplicity + 1 <= constraint.targetMaxOccurs();
	}

	/**
	 * @param unit
	 * @return <code>true</code> if Unit has a domain or instance constraint as link source
	 * @see Unit#isGroup()
	 */
	public static boolean canBeLinkSource(Unit unit) {
//		// Is there a Java-originated type constraint?
//		Collection constraints = getDomainConstraints();
//		for (Iterator it = constraints.iterator(); it.hasNext();) {
//			MultiplicityConstraint constraint = (MultiplicityConstraint) it.next();
//			if (constraint.getSourceType().isInstance(unit)) {
//				return true;
//			}
//		}

		// Is there a model-originated instance constraint?
		for (Iterator<Requirement> it = unit.getRequirements().iterator(); it.hasNext();) {
			Requirement req = it.next();
			if (isGroup(req)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param req
	 *           Requirement
	 * @return returns true if 'req' has either a RE with OutCardinality interpreter or a
	 *         MemberCardinality Constraint
	 */
	private static boolean hasOutCardinality(Requirement req) {
		for (Iterator<Constraint> it = req.getConstraints().iterator(); it.hasNext();) {
			Constraint cnstr = it.next();
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
					return true;
				}
			}
			if (cnstr instanceof MemberCardinalityConstraint) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param req
	 *           Requirement
	 * @return returns true if 'req' has either a RE with InCardinality interpreter or a
	 *         GroupCardinality Constraint
	 */
	private static boolean hasInCardinality(Requirement req) {
		for (Iterator<Constraint> it = req.getConstraints().iterator(); it.hasNext();) {
			Constraint cnstr = it.next();
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (re.getInterpreter().equals(InCardinality.INTERPRETER_ID)) {
					return true;
				}
			}
			if (cnstr instanceof GroupCardinalityConstraint) {
				return true;
			}
		}
		return false;
	}

	/**
	 * How many member links in <code>target</code>'s {@link Topology} are from instances of
	 * <code>ec</code>? Returns number of concrete targets if any. Returns number of conceptual if
	 * none.
	 * 
	 * @param target
	 * @param ec
	 * @param monitor
	 *           TODO
	 * @return number of matching MemberLinks
	 */
	public static int calculateTargetMultiplicity(Unit target, EClass ec, IProgressMonitor monitor) {
		List<UnitDescriptor> udList;
		Requirement ctmMemberReq = ctmMemberReqMap.get(ec);
		if (ctmMemberReq == null) {
			ctmMemberReq = CoreFactory.eINSTANCE.createRequirement();
			ctmMemberReq.setName("InCardinalityMemberReq"); //$NON-NLS-1$
			ctmMemberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			RequirementExpression inMultiplicity = InCardinality.createExpression(0, RANGE_UNBOUNDED);
			ctmMemberReq.getExpressions().add(inMultiplicity);
			ctmMemberReq.setDmoEType(ec);
			ctmMemberReqMap.put(ec, ctmMemberReq);
		}

		udList = TopologyDiscovererService.INSTANCE.getGroups(target, ctmMemberReq, target
				.getTopology(), monitor);
		if (null == udList) {
			return 0;
		}

		return getFilteredCount(udList);
	}

	private static int getFilteredCount(List<UnitDescriptor> udList) {
		int numConceptual = 0;
		int numNonConceptual = 0;
		for (UnitDescriptor ud : udList) {
			Unit u = ud.getUnitValue();
			if (u == null) {
				continue;
			}
			if (u.isConceptual()) {
				numConceptual++;
			} else {
				numNonConceptual++;
			}
		}

		if (numNonConceptual > 0) {
			return numNonConceptual;
		}
		return numConceptual;
	}

	/**
	 * How many member links from source target in an instance of 'ec'?
	 * 
	 * @param source
	 * @param ec
	 * @param monitor
	 *           TODO
	 * @return number of matching MemberLinks
	 */
	public static int calculateSourceMultiplicity(Unit source, EClass ec, IProgressMonitor monitor) {
//		int retVal = 0;
//		
		// MK 9/29/2006 added discovery service check instead of topology check
		List<UnitDescriptor> udList;
		Requirement csmMemberReq = csmMemberReqMap.get(ec);
		if (csmMemberReq == null) {
			csmMemberReq = CoreFactory.eINSTANCE.createRequirement();
			csmMemberReq.setName("OutCardinalityMemberReq"); //$NON-NLS-1$
			csmMemberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			csmMemberReq.setDmoEType(ec);
			csmMemberReqMap.put(ec, csmMemberReq);
		}

		udList = TopologyDiscovererService.INSTANCE.getMembers(source, csmMemberReq, source
				.getTopology(), monitor);

		if (null == udList) {
			return 0;
		}
//		return udList.size();
		return getFilteredCount(udList);

		// MK 9/29/2006 replaced code
//		for (Iterator it = source.getMemberLinks().iterator(); it.hasNext();) {
//			MemberLink link = (MemberLink) it.next();
//			if (ec.isInstance(link.getTarget())) {
//				retVal++;
//			}
//		}
//		
//		return retVal;
	}

	private static MultiplicityConstraint getConstraint(Unit source, Unit target) {
//		// Note: Assuming domain constraints take precedence over model ones
//		Collection constraints = getDomainConstraints();
//		for (Iterator it = constraints.iterator(); it.hasNext();) {
//			MultiplicityConstraint constraint = (MultiplicityConstraint) it.next();
//			if (constraint.constraintForPair(source.eClass(), target.eClass())) {
//				return constraint;
//			}
//		}

		return getModelConstraint(source, target);
	}

	private static MultiplicityConstraint getModelConstraint(Unit source, Unit target) {
		MultiplicityConstraint sourceConstraint = getModelSourceConstraint(source, target.eClass());
		if (sourceConstraint == null) {
			// If the source has no constraint, then it cannot contain the target.  Sources must
			// be explicit.
			return null;
		}

		MultiplicityConstraint targetConstraint = getModelTargetConstraint(source.eClass(), target);

//		// (If neither side has a constraint there is no merged constraint)
//		if (sourceConstraint == null && targetConstraint == null) {
//			return null;
//		}

		// Merge the two constraints
		EClass ecSource = CorePackage.eINSTANCE.getUnit();
		EClass ecTarget = CorePackage.eINSTANCE.getUnit();
		int minSource = 0;
		int maxSource = RANGE_UNBOUNDED;
		int minTarget = 0;
		int maxTarget = RANGE_UNBOUNDED;
//		if (sourceConstraint != null) {
		ecSource = sourceConstraint.getSourceType();
		minSource = sourceConstraint.sourceMinOccurs();
		maxSource = sourceConstraint.sourceMaxOccurs();
//		}
		if (targetConstraint != null) {
			ecTarget = targetConstraint.getSourceType();
			minTarget = targetConstraint.targetMinOccurs();
			maxTarget = targetConstraint.targetMaxOccurs();
		}
		return new MultiplicityConstraint(ecSource, minSource, maxSource, ecTarget, minTarget,
				maxTarget);
	}

	/**
	 * @param ecSource
	 * @param target
	 * @return a constraint on MemberLink between instances of 'ecSource' and the target node.
	 */
	public static MultiplicityConstraint getConstraint(EClass ecSource, Unit target) {
//		// Note: Assuming domain constraints take precedence over model ones
//		Collection constraints = getDomainConstraints();
//		for (Iterator it = constraints.iterator(); it.hasNext();) {
//			MultiplicityConstraint constraint = (MultiplicityConstraint) it.next();
//			if (constraint.constraintForPair(ecSource, target.eClass())) {
//				return constraint;
//			}
//		}

		return getModelTargetConstraint(ecSource, target);
	}

	/**
	 * @param source
	 * @param ecTarget
	 * @return a constraint on MemberLink between the source node and instances of 'ecTarget'
	 */
	public static MultiplicityConstraint getConstraint(Requirement source, EClass ecTarget) {
		return getModelSourceConstraint(source, ecTarget);
	}

	/**
	 * @param source
	 * @param ecTarget
	 * @return a constraint on MemberLink between the source node and instances of 'ecTarget'
	 */
	public static MultiplicityConstraint getConstraint(Unit source, EClass ecTarget) {
//		// Note: Assuming domain constraints take precedence over model ones
//		Collection constraints = getDomainConstraints();
//		for (Iterator it = constraints.iterator(); it.hasNext();) {
//			MultiplicityConstraint constraint = (MultiplicityConstraint) it.next();
//			if (constraint.constraintForPair(source.eClass(), ecTarget)) {
//				return constraint;
//			}
//		}

		return getModelSourceConstraint(source, ecTarget);
	}

	/**
	 * Look for Requirement MEMBER on target with InCardinality interpreter
	 */
	private static MultiplicityConstraint getModelTargetConstraint(EClass ecSource, Unit target) {
		for (Iterator<Requirement> it = target.getRequirements().iterator(); it.hasNext();) {
			Requirement req = it.next();
			if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
				if (compatibleEType(req, ecSource) && !hasOutCardinality(req)) {
					int targetMultiplicity[] = calculateTargetMultiplicityConstraint(req);
					return new MultiplicityConstraint(getRequirementTypeFilter(req), 0, RANGE_UNBOUNDED,
							target.eClass(), targetMultiplicity[0], targetMultiplicity[1]);
				}
			}
		}
		return null;
	}

	private static boolean compatibleEType(Requirement reqConstraint, EClass candidate) {
		return getRequirementTypeFilter(reqConstraint).isSuperTypeOf(candidate);
	}

	/**
	 * Look for Requirement MEMBER on target with no InCardinality interpreter (may have
	 * OutCardinality interpreter).
	 */
	private static MultiplicityConstraint getModelSourceConstraint(Unit source, EClass ecTarget) {
		for (Iterator<Requirement> it = source.getRequirements().iterator(); it.hasNext();) {
			Requirement req = it.next();
			if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
				if (compatibleEType(req, ecTarget) && !hasInCardinality(req)) {
					return getModelSourceConstraint(req, ecTarget);
				}
			}
		}
		return null;
	}

	private static MultiplicityConstraint getModelSourceConstraint(Requirement source,
			EClass ecTarget) {
		int sourceMultiplicity[] = calculateSourceMultiplicityConstraint(source);
		return new MultiplicityConstraint(source.eClass(), sourceMultiplicity[0],
				sourceMultiplicity[1], getRequirementTypeFilter(source), 0, RANGE_UNBOUNDED);
	}

//	/**
//	 * Return model-described constraint between source and target types, or null if member
//	 * link isn't possible.
//	 */
//	private static MultiplicityConstraint getModelConstraint(Unit source, Unit target) {
//		for (Iterator it = source.getRequirements().iterator(); it.hasNext(); ) {
//			Requirement req = (Requirement) it.next();
//			if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
//				if (getRequirementTypeFilter(req).isInstance(target)) {
//					int sourceMultiplicity[] = calculateSourceMultiplicity(req);
////					int targetMultiplicity[] = calculateTargetMultiplicity(req);
//					return new MultiplicityConstraint(
//							source.eClass(), sourceMultiplicity[0], sourceMultiplicity[1], 
//							getRequirementTypeFilter(req), targetMultiplicity[0], targetMultiplicity[1]);
//				}
//				
//				// TODO Michael K suggests member links with etype of Capability.
//				// If we implement this, then we'd check isInstance for each of target's
//				// capabilities here...
//			}
//		}
//		
//		return null;
//	}

	private static int[] calculateTargetMultiplicityConstraint(Requirement req) {
		for (Iterator<Constraint> it = req.getConstraints().iterator(); it.hasNext();) {
			Constraint cnstr = it.next();
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (re.getInterpreter().equals(InCardinality.INTERPRETER_ID)) {
					return calculateMultiplicity(re.getValue());
				}
			}
			if (cnstr instanceof GroupCardinalityConstraint) {
				return calculateMultiplicity((GroupCardinalityConstraint) cnstr);
			}
		}

		// Since there is no constraint assume 0..unbounded
		return new int[] { 0, RANGE_UNBOUNDED };
	}

	private static int[] calculateSourceMultiplicityConstraint(Requirement req) {
		for (Iterator<Constraint> it = req.getConstraints().iterator(); it.hasNext();) {
			Constraint cnstr = it.next();
			if (cnstr instanceof RequirementExpression) {
				RequirementExpression re = (RequirementExpression) cnstr;
				if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
					return calculateMultiplicity(re.getValue());
				}
			}
			if (cnstr instanceof MemberCardinalityConstraint) {
				return calculateMultiplicity((MemberCardinalityConstraint) cnstr);
			}
		}

		// Since there is no constraint assume 0..unbounded
		return new int[] { 0, RANGE_UNBOUNDED };
	}

	/**
	 * @param rangeVal
	 *           string like '1', '0..*', or '1..2'
	 * @return int[2], where the first value is the minOccurs and the second is the maxOccurs
	 */
	private static int[] calculateMultiplicity(String rangeVal) {
		if (rangeVal == null) {
			return new int[] { RANGE_MALFORMED, RANGE_MALFORMED };
		}

		int pos = rangeVal.indexOf(".."); //$NON-NLS-1$
		if (pos < 0) {
			// No range, just a single
			int minMax = multString(rangeVal);
			return new int[] { minMax, minMax };
		}

		int min = multString(rangeVal.substring(0, pos));
		int max = multString(rangeVal.substring(pos + 2));
		return new int[] { min, max };
	}

	/**
	 * Calculates multiplicity of a MemberCardinality Constraint.
	 * 
	 * @param memberCnstr
	 *           MemberCardinality Constraint
	 * @return int[2], where the first value is the minOccurs and the second is the maxOccurs
	 */
	private static int[] calculateMultiplicity(MemberCardinalityConstraint memberCnstr) {
		if (memberCnstr == null) {
			return new int[] { RANGE_MALFORMED, RANGE_MALFORMED };
		}

		int min = multStringForConstraint(memberCnstr.getMinValue());
		if (min == RANGE_UNBOUNDED) {
			min = 0;
		}
		int max = multStringForConstraint(memberCnstr.getMaxValue());
		return new int[] { min, max };
	}

	/**
	 * Calculates multiplicity of a GroupCardinality Constraint.
	 * 
	 * @param groupCnstr
	 *           GroupCardinality Constraint
	 * @return int[2], where the first value is the minOccurs and the second is the maxOccurs
	 */
	private static int[] calculateMultiplicity(GroupCardinalityConstraint groupCnstr) {
		if (groupCnstr == null) {
			return new int[] { RANGE_MALFORMED, RANGE_MALFORMED };
		}

		int min = multStringForConstraint(groupCnstr.getMinValue());
		if (min == RANGE_UNBOUNDED) {
			min = 0;
		}
		int max = multStringForConstraint(groupCnstr.getMaxValue());
		return new int[] { min, max };
	}

	private static int multString(String str) {
		if (str.equals("*")) { //$NON-NLS-1$
			return RANGE_UNBOUNDED;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return RANGE_MALFORMED; // error
		}
	}

	private static int multStringForConstraint(String str) {
		if (str == null
				|| str.trim().equals("") || str.equals(MemberCardinalityConstraintValidator.UNBOUNDED_LITERAL)) { //$NON-NLS-1$
			return RANGE_UNBOUNDED;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return RANGE_MALFORMED; // error
		}
	}

	/**
	 * @param req
	 * @return the EClass constraint for a Requirement
	 */
	public static EClass getRequirementTypeFilter(Requirement req) {
		EClass ec = req.getDmoEType();

		if (ec == null) {
			return CorePackage.eINSTANCE.getUnit();
		}

		return ec;
	}

//	/**
//	 * @deprecated AVK thinks this is confusing as we don't support domain constraints at all
//	 */
//	private static Collection getDomainConstraints() {
//		return Collections.unmodifiableCollection(constraints);
//	}

	/**
	 * Does 'req' make it's owner a group Unit?
	 * 
	 * @param req
	 * @return <code>true</code> if 'req' makes its owner a group Unit
	 */
	public static boolean isGroup(Requirement req) {
		if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
			return hasOutCardinality(req) || !hasInCardinality(req);
		}
		return false;
	}

	/**
	 * Is 'req' the <b>only</b> Requirement of 'unit' that causes unit.isGroup() to return true?
	 * 
	 * @param unit
	 * @param req
	 *           a Requirement of 'unit'
	 * @return <code>true</code> if Unit.isGroup() will become false without 'req' as a member
	 */
	public static boolean onlyGroupingRequirement(Unit unit, Requirement req) {
		// If 'req' isn't a grouping requirement then it definately isn't the only one
		if (!isGroup(req)) {
			return false;
		}

		// Can another Requirement contribute a group nature? 
		for (Iterator<Requirement> it = unit.getRequirements().iterator(); it.hasNext();) {
			Requirement reqOther = it.next();
			if (req != reqOther && isGroup(reqOther)) {
				return false;
			}
		}

		// 'req' is the only group nature requirement on unit
		return true;
	}

} // end class MultiplicityChecker
