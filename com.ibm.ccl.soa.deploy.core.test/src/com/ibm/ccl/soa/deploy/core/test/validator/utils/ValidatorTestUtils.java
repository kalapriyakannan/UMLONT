/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorAdapter;

/**
 * Static utils for validation testing
 * 
 * @author barnold These could probably all be moved to TopologyTestCase.
 */
public final class ValidatorTestUtils {

	private ValidatorTestUtils() {
		// static methods only
	}

	/**
	 * @param link
	 */
	public static void createLinkName(HostingLink link) {
		String name;
		name = "hosted" + link.getHosted().getName() + "In" + link.getHost().getName(); //$NON-NLS-1$ //$NON-NLS-2$
		link.setName(name);
	}

	/**
	 * @param link
	 */
	public static void createLinkName(MemberLink link) {
		String name;
		name = "member" + link.getTarget().getName() + "In" + link.getSource().getName(); //$NON-NLS-1$ //$NON-NLS-2$
		link.setName(name);
	}

	/**
	 * Create a name for a DependencyLink based on the source and target names.
	 * 
	 * @param link
	 */
	public static void createLinkName(DependencyLink link) {
		assert link.getTarget() != null;
		assert link.getTarget().getName() != null;
		Assert.assertNotNull(link.getTarget());

		String sourceName = null;
		EObject parent = link.eContainer();
		if (parent != null
				&& parent.eClass() != CorePackage.eINSTANCE.getTopology()) {
			// If we are not owned by a Topology then we must be owned by a
			// Capability
			if (parent instanceof DeployModelObject) {
				sourceName = ((DeployModelObject) parent).getName();
			}
		}
		assert sourceName != null;

		String name;
		name = "link" + sourceName + "To" + link.getTarget().getName();
		link.setName(name);
	}

	/**
	 * Create, test and return a hosting link from hoster to hostee
	 * 
	 * @param hoster
	 *            the unit hosting the created link
	 * @param hostee
	 *            the unit hosted by the created link
	 * @return the new hosting link
	 */
	public static HostingLink hosts(Unit hoster, Unit hostee) {
		assert hoster != null;
		assert hostee != null;
		assert hoster != hostee;

		assert hostee.getTopology() != null;
		assert hoster.getTopology() != null;
		if (hostee.getTopology() != hoster.getTopology()) {
			// Cross topology hosting: either hostee imports hoster or vice
			// versa
			if (TopologyTestUtils.isProxy(hostee)) {
				assert !TopologyTestUtils.isProxy(hoster);
				assert hoster.resolve(DeployModelObjectUtil
						.getGlobalPath(hostee)) == hostee;
			} else if (TopologyTestUtils.isProxy(hoster)) {
				assert !TopologyTestUtils.isProxy(hostee);
				assert hostee.resolve(DeployModelObjectUtil
						.getGlobalPath(hoster)) == hoster;
			} else {
				// May be OK in the future
				assert false : "neither hoster and hostee are proxy objects";
			}
		}
		assert hostee.getTopology().findHosts(hostee).length == 0 : "Hostee \"" + hostee.getName() //$NON-NLS-1$
				+ "\" already hosted by \"" + hostee.getTopology().findHosts(hostee)[0].getName() + "\""; //$NON-NLS-1$//$NON-NLS-2$
		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setHosted(hostee);
		hoster.getHostingLinks().add(hl);
		createLinkName(hl);
		assert hostee.getTopology().findHosts(hostee).length == 1 : "Topology.getHosts() error: returned " //$NON-NLS-1$
				+ hostee.getTopology().findHosts(hostee).length
				+ " hosts for hoster \"" + hoster.getName() //$NON-NLS-1$
				+ "\" for hostee \"" + hostee.getName() + "\"; hostee contained in \"" + hostee.getParent().getName() //$NON-NLS-1$//$NON-NLS-2$
				+ "\", hoster contained in \"" + hoster.getParent().getName() + "\""; //$NON-NLS-1$//$NON-NLS-2$
		assert hostee.getTopology().findHosts(hostee)[0] == hoster;
		return hl;
	}

	/**
	 * Create and return a hosting link from hoster to hostee
	 * 
	 * @param hoster
	 *            the unit hosting the created link
	 * @param hostee
	 *            the unit hosted by the created link
	 * @return the new hosting link
	 */
	public static DependencyLink depends(Unit powerMan, Capability providedCap,
			Unit relier, Requirement requirement) {
		assert powerMan != null;
		assert relier != null;
		assert powerMan != relier;

		assert relier.getTopology() != null;
		assert powerMan.getTopology() != null;
		assert relier.getTopology() == powerMan.getTopology();
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setTarget(providedCap);
		requirement.setLink(link);
		createLinkName(link);
		return link;
	}

	/**
	 * Create and return a member link from container to member
	 * 
	 * @param container
	 * @param member
	 * @return new memberlink
	 */

	public static MemberLink member(Unit container, Unit member) {
		assert container != null;
		assert member != null;
		assert container != member;
		assert container.getTopology() != null;
		assert member.getTopology() != null;
		assert container.getTopology() == member.getTopology();

		MemberLink memberLink = CoreFactory.eINSTANCE.createMemberLink();
		memberLink.setTarget(member);
		memberLink.setSource(container);
		createLinkName(memberLink);
		container.getMemberLinks().add(memberLink);

		return memberLink;
	}

	/**
	 * Returns the number of {@link IStatus#ERROR} status errors placed on
	 * deploy model objects contained in the topology.
	 * 
	 * @param top
	 *            a topology.
	 * @return the number of {@link IStatus#ERROR} count on the topology
	 *         objects.
	 */
	public static int getTopologyErrorCount(Topology top) {
		int count = 0;
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IStatus s = (IStatus) iter2.next();
					if (s.getSeverity() == IStatus.ERROR) {
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * Returns the number of statuses of severity "statusSeverity" placed on
	 * deploy model objects contained in the topology.
	 * 
	 * @param top
	 *            a topology.
	 * @param statusSeverity
	 *            a status severity value (e.g. IStatus.WARNING)
	 * @return the number of statuses of specified type on the topology objects.
	 */
	public static int getTopologyStatusOfSeverityCount(Topology top,
			int statusSeverity) {
		int count = 0;
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == statusSeverity) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IStatus s = (IStatus) iter2.next();
					if (s.getSeverity() == statusSeverity) {
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * Returns true if all problem types on statuses in topology are in set
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of problem types
	 * @return true if all problem types on statuses in topology are in set
	 * 
	 */
	public static boolean topologyProblemTypesInSet(Topology top, Set set) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (!set.contains((deployStatus.getProblemType()))) {
					System.out.println("Problem type not in allowed set : "
							+ deployStatus.getProblemType() + " ("
							+ obj.getName() + ")");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if no problem types on statuses in topology are in set
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of problem types
	 * @param severityMask
	 *            the status severity bitmask (see {@link IStatus#matches(int)}).
	 * @param log
	 *            string buffer used to log error info (may be null)
	 * 
	 * @return true if no problem types on statuses are in set
	 * 
	 */
	public static boolean topologyNoProblemTypesInSet(Topology top, Set set,
			int severityMask, StringBuffer log) {
		boolean foundProblemTypeInSet = false;
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if ((deployStatus.matches(severityMask))
						&& (set.contains((deployStatus.getProblemType())))) {
					if (log != null) {
						log.append("Problem type in disallowed set : "
								+ deployStatus.getProblemType() + " ("
								+ obj.getName() + ")\n");
					}
					// Don't just return, since we may want to know what all the
					// problems are.
					foundProblemTypeInSet = true;
				}
			}
		}
		return !foundProblemTypeInSet;
	}

	/**
	 * Returns true if no validator ids on statuses in topology are in set
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of validator ids
	 * @param severityMask
	 *            the status severity bitmask (see {@link IStatus#matches(int)}).
	 * @param log
	 *            string buffer used to log error info (may be null)
	 * @return true if no validator ids on statuses are in set
	 * 
	 */
	public static boolean topologyNoValidatorIdsInSet(Topology top, Set set,
			int severityMask, StringBuffer log) {
		boolean foundValidatorIdInSet = false;
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.matches(severityMask)
						&& (set.contains((deployStatus.getValidatorID())))) {
					if (log != null) {
						log.append("Validator ID in disallowed set : "
								+ deployStatus.getValidatorID() + " ("
								+ obj.getName() + ")\n");
					}
					// Don't just return, since we may want to know what all the
					// validator ids are.
					foundValidatorIdInSet = true;
				}
			}
		}
		return !foundValidatorIdInSet;
	}

	/**
	 * Returns true if all validator IDs on statuses in topology are in set
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of validator IDs
	 * @return true if all validator IDs on statuses in topology are in set
	 * 
	 */
	public static boolean topologyValidatorIDsInSet(Topology top, Set set) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (!set.contains((deployStatus.getValidatorID()))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if all validator IDs on statuses in topology at specified
	 * severity level are in set
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of validator IDs
	 * @param severity
	 * 
	 * @return true if all validator IDs on statuses at specified severity level
	 *         in topology are in set
	 * 
	 */
	public static boolean topologyValidatorIDsInSet(Topology top, Set set,
			int severity) {
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getSeverity() == severity
						&& !set.contains((deployStatus.getValidatorID()))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if all validator IDs in set are found at least once on
	 * statuses in topology
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of validator IDs
	 * @return true if all validator IDs in set are found at least once on
	 *         statuses in topology
	 * 
	 */
	public static boolean topologyValidatorIDSetCover(Topology top,
			Set<String> set) {
		HashSet<String> tmpSet = new HashSet<String>(set);
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				tmpSet.remove(deployStatus.getValidatorID());
			}
		}
		return tmpSet.size() == 0;
	}

	/**
	 * Returns true if all validator IDs in set at specified severity level are
	 * found at least once on statuses in topology
	 * 
	 * @param top
	 *            a topology.
	 * @param set
	 *            a set of validator IDs
	 * @return true if all validator IDs in set are found at least once on
	 *         statuses at specified severity level in topology
	 * 
	 */
	public static boolean topologyValidatorIDSetCover(Topology top,
			Set<String> set, int severity) {
		HashSet<String> tmpSet = new HashSet<String>(set);
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getSeverity() == severity) {
					tmpSet.remove(deployStatus.getValidatorID());
				}
			}
		}
		return tmpSet.size() == 0;
	}

	/**
	 * Returns a description of the {@link IStatus#ERROR} on the topology
	 * objects.
	 * 
	 * @param top
	 *            a deploy topology.
	 * @return a new-line separated string description of the errors.
	 */
	public static String getTopologyErrorDescription(Topology top) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (!obj.getStatus().isOK()) {
				for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IDeployStatus deployStatus = (IDeployStatus) iter2.next();
					if (deployStatus.getSeverity() == IStatus.ERROR) {
						if (result.length() > 0) {
							result.append('\n');
						}
						result.append(deployStatus.getMessage());
						result.append('\n');
						result
								.append(deployStatus.getProblemType() == null ? "[null]"
										: deployStatus.getProblemType());
						result.append('\n');
						result
								.append(deployStatus.getValidatorID() == null ? "[null]"
										: deployStatus.getValidatorID());
						result.append('\n');
						result
								.append("severity: "
										+ deployStatus.getSeverity());
						result.append('\n');
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * Returns a description of the {@link IStatus#ERROR} on the
	 * DeployModelObject.
	 * 
	 * @param dmo
	 *            a DeployModelObject.
	 * @return a new-line separated string description of the warnings.
	 */
	public static String getDmoErrorDescription(DeployModelObject dmo) {
		StringBuffer result = new StringBuffer();
		if (!dmo.getStatus().isOK()) {
			for (Iterator iter2 = new FilterIterator(new StatusIterator(dmo
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getSeverity() == IStatus.ERROR) {
					if (result.length() > 0) {
						result.append('\n');
					}
					result.append(deployStatus.getMessage());
					result.append('\n');
					result
							.append(deployStatus.getProblemType() == null ? "[null]"
									: deployStatus.getProblemType());
					result.append('\n');
// result.append(deployStatus.getValidatorID() == null ? "[null]" :
// deployStatus.getValidatorID());
// result.append('\n');
// result.append("severity: " + deployStatus.getSeverity());
// result.append('\n');
				}
			}
		}
		return result.toString();
	}

	/**
	 * Returns a description of the {@link IStatus#WARNING} on the topology
	 * objects.
	 * 
	 * @param top
	 *            a deploy topology.
	 * @return a new-line separated string description of the warnings.
	 */
	public static String getTopologyWarningDescription(Topology top) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			for (Iterator iter2 = new FilterIterator(new StatusIterator(obj
					.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
					.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getSeverity() == IStatus.WARNING) {
					if (result.length() > 0) {
						result.append('\n');
					}
					result.append(deployStatus.getMessage());
					result.append('\n');
					result
							.append(deployStatus.getProblemType() == null ? "[null]"
									: deployStatus.getProblemType());
					result.append('\n');
					result
							.append(deployStatus.getValidatorID() == null ? "[null]"
									: deployStatus.getValidatorID());
					result.append('\n');
					result.append("severity: " + deployStatus.getSeverity());
					result.append('\n');
				}
			}
		}
		return result.toString();
	}

	/**
	 * @param expectedErrorCount
	 * @param top
	 * @param unit
	 * @param context
	 * @param reporter
	 * @param validator
	 * @throws CoreException
	 */
	public static void assertValidationErrorCount(int expectedErrorCount,
			Topology top, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter, UnitValidator validator)
			throws CoreException {
		DeployMarker.deleteInstances(top);
		DeployValidatorAdapter.clearDeployNonPublisherStatus(top);
		validator.validate(unit, context, reporter);
		assert (getTopologyErrorCount(top) == expectedErrorCount) : "Expected "
				+ expectedErrorCount + " errors, found "
				+ getTopologyErrorCount(top) + ":\n"
				+ getTopologyErrorDescription(top);
	}

	/**
	 * @param minExpectedErrorCount
	 * @param maxExpectedErrorCount
	 * @param top
	 * @param unit
	 * @param context
	 * @param reporter
	 * @param validator
	 * @throws CoreException
	 */
	public static void assertValidationErrorCountRange(
			int minExpectedErrorCount, int maxExpectedErrorCount, Topology top,
			Unit unit, IDeployValidationContext context,
			IDeployReporter reporter, UnitValidator validator)
			throws CoreException {
		DeployMarker.deleteInstances(top);
		validator.validate(unit, context, reporter);
		assert (DeployMarker.getInstances(top).length >= minExpectedErrorCount && DeployMarker
				.getInstances(top).length <= maxExpectedErrorCount) : "ErrorCount="
				+ DeployMarker.getInstances(top).length;
	}

	/**
	 * @param eClass
	 *            EClass of required capability
	 * @param name
	 *            name for requirement
	 * @param displayName
	 *            display name for requirement
	 * @return hosting requirement
	 */
	public static Requirement createHostingRequirement(EClass eClass,
			String name, String displayName) {
		Requirement hr = CoreFactory.eINSTANCE.createRequirement();
		hr.setDisplayName(displayName);
		hr.setDmoEType(eClass);
		hr.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hr.setName(name);
		return hr;
	}

	/**
	 * @param eClass
	 *            eclass of required capability
	 * @param name
	 *            name for requirement
	 * @return hosting requirement (displayName identical to name)
	 */
	public static Requirement createHostingRequirement(EClass eClass,
			String name) {
		return createHostingRequirement(eClass, name, name);
	}

	/**
	 * @param eClass
	 *            EClass of required unit
	 * @param name
	 *            name for member requirement
	 * @param displayName
	 *            display name for member requirement
	 * @return member requirement
	 */
	public static Requirement createMemberRequirement(EClass eClass,
			String name, String displayName) {
		Requirement hr = CoreFactory.eINSTANCE.createRequirement();
		hr.setDisplayName(displayName);
		hr.setDmoEType(eClass);
		hr.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		hr.setName(name);
		return hr;
	}

	/**
	 * @param eClass
	 *            eclass of required unit
	 * @param name
	 *            name for member requirement
	 * @return member requirement (displayName identical to name)
	 */
	public static Requirement createMemberRequirement(EClass eClass, String name) {
		return createMemberRequirement(eClass, name, name);
	}

	/**
	 * @param req requirement on which the constraint should be added
	 * @param minValue the minimum cardinality
	 * @param maxValue the maximum cardinality
	 */
	public static void addMemberCardinalityConstraint (Requirement req, String minValue, String maxValue) {
		MemberCardinalityConstraint mcc = ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint();
		mcc.setName(MemberCardinalityConstraint.class.getName().substring(MemberCardinalityConstraint.class.getName().lastIndexOf('.') + 1));
		mcc.setMinValue(minValue);
		mcc.setMaxValue(maxValue);
		req.getConstraints().add(mcc);
	}

	/**
	 * @param req requirement on which the constraint should be added
	 * @param minValue the minimum cardinality
	 * @param maxValue the maximum cardinality
	 */
	public static void addGroupCardinalityConstraint (Requirement req, String minValue, String maxValue) {
		GroupCardinalityConstraint gcc = ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint();
		gcc.setName(GroupCardinalityConstraint.class.getName().substring(GroupCardinalityConstraint.class.getName().lastIndexOf('.') + 1));
		gcc.setMinValue(minValue);
		gcc.setMaxValue(maxValue);
		req.getConstraints().add(gcc);
	}

	/**
	 * @param eClass
	 *            EClass of required capability
	 * @param name
	 *            name for requirement
	 * @param displayName
	 *            display name for requirement
	 * @return dependency requirement
	 */
	public static Requirement createDependencyRequirement(EClass eClass,
			String name, String displayName) {
		Requirement dr = CoreFactory.eINSTANCE.createRequirement();
		dr.setDisplayName(displayName);
		dr.setDmoEType(eClass);
		dr.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		dr.setName(name);
		return dr;
	}

	/**
	 * @param eClass
	 *            eclass of required capability
	 * @param name
	 *            name for requirement
	 * @return hosting requirement (displayName identical to name)
	 */
	public static Requirement createDependencyRequirement(EClass eClass,
			String name) {
		return createDependencyRequirement(eClass, name, name);
	}

	/**
	 * @param req
	 *            Requirement to add equals expression to
	 * @param ea
	 *            EAttribute for comparison
	 * @param o
	 *            object to compare
	 * @deprecated use addEqualsConstraint()
	 */
	public static void addEqualsExpression(Requirement req, EAttribute ea,
			Object o) {
		req.getExpressions().add(Equals.createExpression(ea, o));
	}
	
	public static void addEqualsConstraint (Requirement req, EAttribute ea, Object o) {
		EqualsConstraint ec = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		ec.setName(EqualsConstraint.class.getName().substring(EqualsConstraint.class.getName().lastIndexOf('.') + 1)
				+ ' ' + ea.getName());
		ec.setAttributeName(ea.getName());
		if (o == null) {
			ec.setValue(null);
		} else {
			ec.setValue(EcoreUtil.convertToString(ea.getEAttributeType(), o));
		}
		req.getConstraints().add(ec);
	}
	
	public static void addGreaterThanConstraint (Requirement req, EAttribute ea, Object o, boolean equals) {
		RangeConstraint rc = ConstraintFactory.eINSTANCE.createRangeConstraint();
		rc.setName(RangeConstraint.class.getName().substring(RangeConstraint.class.getName().lastIndexOf('.') + 1)
				+ ' ' + ea.getName());
		rc.setAttributeName(ea.getName());
		if (o == null) {
			rc.setMinValue(null);
		} else {
			rc.setMinValue(EcoreUtil.convertToString(ea.getEAttributeType(), o));
		}
		rc.setMinValueInclusive(equals);
		req.getConstraints().add(rc);
	}
	
	public static void addVersionConstraint (Requirement req, EAttribute ea, Object o) {
		VersionConstraint vc = ConstraintFactory.eINSTANCE.createVersionConstraint();
		vc.setName(VersionConstraint.class.getName().substring(VersionConstraint.class.getName().lastIndexOf('.') + 1)
				+ ' ' + ea.getName());
		vc.setAttributeName(ea.getName());
		if (o == null) {
			vc.setValue(null);
		} else {
			vc.setValue(EcoreUtil.convertToString(ea.getEAttributeType(), o));
		}
		req.getConstraints().add(vc);
	}

}
