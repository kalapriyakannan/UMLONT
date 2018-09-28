/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Utility methods for WAS specific J2EE validators.
 */
public class WasJ2eeValidatorUtils {

	private static EClass wasServerUnitType = WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	private static EClass wasClusterUnitType = WasPackage.Literals.WAS_CLUSTER_UNIT;
	private static EClass earModuleType = J2eePackage.Literals.EAR_MODULE;
	private static EClass ejbModuleType = J2eePackage.Literals.EJB_MODULE;
	private static EClass webModuleType = J2eePackage.Literals.WEB_MODULE;

	/**
	 * Get a dependency requirement of a given type that is available to be satisfied; that is, does
	 * not currently contain a dependency link).
	 * 
	 * @param unit
	 *           the unit to search
	 * @param reqType
	 *           the {@link Requirement} DMO type
	 * @return an unlinked {@link Requirement}
	 */
	public static Requirement getAvailableRequirement(Unit unit, EClass reqType) {
		List<Requirement> reqs = ValidatorUtils.getRequirements(unit, reqType);
		for (int i = 0; i < reqs.size(); i++) {
			Requirement r = reqs.get(i);
			if (r.isPublic() && null == r.getLink() && 0 == r.getExpressions().size()) {
				// there is already an available requirement for linking
				return r;
			}
		}
		return null;
	}

	/**
	 * Find a requirement that depends on a specific {@link DeployModelObject} type.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param dmoEType
	 *           the type to search for
	 * @return a {@link Requirement}
	 */
	public static Requirement findRequirement(Unit unit, EClass dmoEType) {
		List requirements = unit.getRequirements();
		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (dmoEType.isSuperTypeOf(req.getDmoEType())) {
				return req;
			}
		}

		return null;
	}

	/**
	 * Find a capability of a specific type.
	 * 
	 * @param unit
	 *           the unit to search
	 * @param dmoEType
	 *           the type to search for
	 * @return a {@link Capability}
	 */
	public static Capability findCapability(Unit unit, EClass dmoEType) {
		List capabilities = unit.getCapabilities();
		for (Iterator iter = capabilities.iterator(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			if (dmoEType.isSuperTypeOf(cap.eClass())) {
				return cap;
			}
		}

		return null;
	}

//	/**
//	 * Determine if a hosting link is between a WAS runtime ({@link WebsphereAppServerUnit} or
//	 * {@link WasClusterUnit}) and a J2EE module ({@link EarModule}, {@link EjbModule} or
//	 * {@link WebModule}).
//	 * 
//	 * @param link
//	 *           a {@link HostingLink} to test
//	 * @return true if the link is of the desired type
//	 */
//	public static boolean isJ2eeHostedOnWas(HostingLink link) {
//		Unit realizedHost = (Unit) RealizationLinkUtil.getFinalRealization(link.getSource());
//		if (null == realizedHost) {
//			return false;
//		}
//		Unit realizedHostee = (Unit) RealizationLinkUtil.getFinalRealization(link.getTarget());
//		if (null == realizedHostee) {
//			return false;
//		}
//
//		if (!WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(realizedHost.getEObject()
//				.eClass())
//				&& !WasPackage.Literals.WAS_CLUSTER_UNIT.isSuperTypeOf(realizedHost.getEObject()
//						.eClass())) {
//			return false;
//		}
//		if (!J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(realizedHostee.getEObject().eClass())
//				&& !J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(realizedHostee.getEObject().eClass())
//				&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(realizedHostee.getEObject().eClass())) {
//			return false;
//		}
//
//		return true;
//	}
//
	public static boolean isJ2eeHostedOnWas(DeployModelObject dmo) {//, IProgressMonitor monitor) {

		if (null == dmo) {
			return false;
		}

		Unit module = getModule(dmo);
		if (null == module) {
			return false;
		}

		Unit host = getHost(module);
		if (null != host) {
			return true;
		}

		// host was null and module was an EAR module
		return false;
	}

	private static Unit getHost(Unit module) {

		IProgressMonitor monitor = new NullProgressMonitor();
		Unit host = ValidatorUtils.discoverHost(module, monitor);
		if (isHostedOnWas(host)) {
			return host;
		}

		// host was null; we need to consider that the module may be 
		// realized to another unit that is hosted on WAS
		Unit realization = module;
		while (null != realization && null == host) {
			realization = ValidatorUtils.getRealizationUnit(realization);
			host = getHost(realization);
		}

		if (null != host) {
			return host;
		}

		// host was null; we need to consider that the module could be a member 
		// of a group that is hosted on WAS
		List<Unit> groups = ValidatorUtils.discoverGroups(module, monitor);
		for (Iterator<Unit> iter = groups.iterator(); iter.hasNext();) {
			host = getHost(iter.next());
			if (null != host) {
				return host;
			}
		}

		return null;
	}

//	public static boolean isJ2eeHostedOnWas(DeployModelObject dmo) {
//
//		boolean hostedOnWas = false;
//		HostingLink link = findHostingLink(dmo);
//		if (link != null) {
//			hostedOnWas = isJ2eeHostedOnWas(link);
//		}
//
//		return hostedOnWas;
//	}
//
	private static Unit getModule(DeployModelObject dmo) {
		// climb model until we find a J2EE module
		while (dmo != null && !earModuleType.isSuperTypeOf(dmo.getEObject().eClass())
				&& !webModuleType.isSuperTypeOf(dmo.getEObject().eClass())
				&& !ejbModuleType.isSuperTypeOf(dmo.getEObject().eClass())) {
			dmo = dmo.getParent();
		}

		// make sure dmo is not null and is a J2EE module
		if (dmo != null
				&& (earModuleType.isSuperTypeOf(dmo.getEObject().eClass())
						|| webModuleType.isSuperTypeOf(dmo.getEObject().eClass()) || ejbModuleType
						.isSuperTypeOf(dmo.getEObject().eClass()))) {
			return (Unit) dmo;
		}

		return null;
	}

	private static boolean isHostedOnWas(Unit host) {
		return null != host
				&& (wasServerUnitType.isSuperTypeOf(host.getEObject().eClass()) || wasClusterUnitType
						.isSuperTypeOf(host.getEObject().eClass()));
	}

	public static Requirement addSharedLibraryEntryRequirement(Unit unit) {
		Requirement r = CoreFactory.eINSTANCE.createRequirement();
		r.setDisplayName("Shared Library Entry"); //$NON-NLS-1$
		r.setName(getUniqueName(unit, "SharedLibraryEntry")); //$NON-NLS-1$
		r.setDmoEType(WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		r.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		r.setUse(RequirementUsage.OPTIONAL_LITERAL);
		unit.getRequirements().add(r);
		return r;

	}

	public static Requirement addBundleCapabilityRequirement(Unit unit) {
		Requirement r = CoreFactory.eINSTANCE.createRequirement();
		r.setDisplayName("Utility JAR"); //$NON-NLS-1$
		r.setName(getUniqueName(unit, "utilityJAR")); //$NON-NLS-1$
		r.setDmoEType(CorePackage.Literals.BUNDLE_CAPABILITY);
		r.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		r.setUse(RequirementUsage.OPTIONAL_LITERAL);
		unit.getRequirements().add(r);
		return r;

	}

	public static String getUniqueName(DeployModelObject container, String name) {
		String linkName = name;
		int uniqifier = 0;
		while (null != container.resolve(linkName)) {
			linkName += uniqifier++;
		}

		return linkName;
	}

	public static void removeJarFromModule(Unit jar, Unit earModule) {
		for (Iterator iter = earModule.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink link = (MemberLink) iter.next();
			if (link.getTarget().equals(jar)) {
				iter.remove();
			}
		}
	}

	public static HostingLink findHostingLink(DeployModelObject dmo) {

		// climb model until we find either a WebModule or an EarModule
		while (dmo != null
				&& !J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
				&& !J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
				&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())) {
			dmo = dmo.getParent();
		}

		// make sure dmo is not null and is either a WebModule or an EarModule
		if (dmo != null
				&& (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
						|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass()) || J2eePackage.Literals.EJB_MODULE
						.isSuperTypeOf(dmo.getEObject().eClass()))) {

			Topology top = dmo.getEditTopology();
			if (top == null) {
				top = dmo.getTopology();
			}

			if (top == null) {
				return null;
			}

			// find all hosting links that have the dmo as their target ( hostee )
			for (Iterator<HostingLink> iter = top.findAllHostingLinks(); iter.hasNext();) {
				HostingLink link = iter.next();
				if (link == null) {
					return null;
				}
				// WCA reverse order of equals to prevent NPE 2007/07/19
				// TODO verify that core validation checks for missing link source/target
				if (dmo.equals(link.getTarget())) {
					return link;
				}
			}

			// if no hosting link has been found yet and the dmo is a WebModule or EjbModule try to find
			// an EarModule that this WebModule or EjbModule is a member of and repeat the findHostingLink process
			if (J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
					|| J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())) {
				for (Iterator<MemberLink> iter = top.findAllMemberLinks(); iter.hasNext();) {
					MemberLink link = iter.next();
					if (dmo.equals(link.getTarget())) {
						HostingLink hostingLink = findHostingLink(link.getSource());
						if (hostingLink != null) {
							return hostingLink;
						}
					}
				}
			}
		}

		return null;
	}

	public static void validateSingleConstraintInstance(DeployModelObject dmo,
			EClass constraintType, Unit was, boolean required, String validatorId,
			IDeployValidationContext context, IDeployReporter reporter) {
		List<Constraint> constraints = ValidatorUtils.getConstraints(dmo, constraintType);
		if (constraints.size() == 0) {
			// too few
			int severity = required ? dmo.getEditTopology().getConfigurationContract().isPublic(dmo) ? IStatus.WARNING
					: IStatus.ERROR
					: IStatus.INFO;
			reporter.addStatus(WasValidationUtil.createMissingConstraint(severity, validatorId, dmo,
					constraintType, was));
		}
		if (constraints.size() > 1) {
			// too many
			reporter.addStatus(WasValidationUtil.createTooManyConstraints(IStatus.ERROR, validatorId,
					dmo, constraintType));
		}
	}

	public static void validateSecurityConstraints(Unit module, Unit wasHost,
			IDeployValidationContext context, IDeployReporter reporter) {
		List<Capability> roles = ValidatorUtils.getCapabilities(module,
				J2eePackage.Literals.J2EE_SECURITY_ROLE);
		for (int i = 0; i < roles.size(); i++) {
			J2EESecurityRole role = (J2EESecurityRole) roles.get(i);
			validateSingleConstraintInstance(role,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT, wasHost, false,
					IWasValidatorID.WAS_J2EE_SECURITY_SUBJECT_CONSTRAINT_MISSING_001, context, reporter);
		}
	}

}
