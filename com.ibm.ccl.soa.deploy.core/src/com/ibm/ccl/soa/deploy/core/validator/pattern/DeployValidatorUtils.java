/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.internal.core.validator.SequentialIterator;

/**
 * Static validation utility methods.
 */
public final class DeployValidatorUtils {

	private DeployValidatorUtils() {
		// static methods only
	}

	/**
	 * Long obsolete, and unused.
	 * 
	 * Validates that the service attribute matches over all <em>service</em> links.
	 * 
	 * @param attribute
	 *           a service attribute.
	 * @param requiredConsumed
	 *           true if the attribute should be defined on consumed units.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 * @deprecated
	 */
//	public static void validateServiceAttributeMatch(EAttribute attribute, boolean requiredConsumed,
//			IDeployValidationContext context, IDeployReporter reporter) {
//		assert attribute != null;
//		EClass serviceType = attribute.getEContainingClass();
//		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(serviceType);
//
//		Iterator serviceIter;
//		if (requiredConsumed) {
//			serviceIter = context.findAllCapabilities(serviceType);
//		} else {
//			serviceIter = context.findAllNonHostingCapabilities(serviceType);
//		}
//		
//
//		while (serviceIter.hasNext()) {
//			Capability ds = (Capability) serviceIter.next();
//			if (ds.eGet(attribute) == null) {
//				reporter.addStatus(DeployCoreStatusUtil
//						.createObjectAttributeUndefinedStatus(ds, attribute));
//			}
//		}
//
//		for (Iterator linkIter = context
//				.findAllDependencyLinksBySourceType(serviceType); linkIter
//				.hasNext();) {
//			DependencyLink link = (DependencyLink) linkIter.next();
//			if ((link.getCapabilitySource() == null)
//					|| (link.getTarget() == null)
//					|| (!link.getCapabilitySource().getEObject().eClass().isSuperTypeOf(
//							link.getTarget().getEObject().eClass()))) {
//				continue;
//			}
//
//			Capability source = link.getCapabilitySource();
//			Capability target = link.getTarget();
//			Object sourceValue = source.eGet(attribute);
//			Object targetValue = target.eGet(attribute);
//			if (((sourceValue != null) && (!sourceValue.equals(targetValue))) || source.isHosting() != target.isHosting()) {
//				reporter.addStatus(DeployCoreStatusUtil
//						.createDependencyLinkEndpointAttributeMismatchStatus(
//								link, serviceType, serviceType, attribute));
//			}
//		}
//	}
	/**
	 * Asserts that the provided service attribute must be non-null.
	 * 
	 * @param attribute
	 * @param context
	 * @param reporter
	 */
	public static void validateProvidedServiceAttributeDefined(EAttribute attribute,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert attribute != null;
		EClass serviceType = attribute.getEContainingClass();
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(serviceType);
		for (Iterator iter = context.findAllNonHostingCapabilities(attribute.getEContainingClass()); iter
				.hasNext();) {
			Capability service = (Capability) iter.next();
			Object value = service.eGet(attribute);
			if (value == null) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(service,
						attribute));
			}
		}
	}

	/**
	 * Validate that the service link endpoint attributes match (equals). Long unused, and obsolete.
	 * 
	 * @param link
	 * @param attribute
	 * @param context
	 * @param reporter
	 */
//	public static void validServiceLinkServiceAttributeMatch(DependencyLink link,
//			EAttribute attribute, IDeployValidationContext context,
//			IDeployReporter reporter) {
//		Requirement req = link.getSource();
//		Capability cap = link.getTarget();
//		if ((req == null) || (cap == null)) {
//			return;
//		}
//		if ((req.getDmoEType() == null)
//				|| (!attribute.getEContainingClass().isSuperTypeOf(
//						req.getDmoEType()))) {
//			return;
//		}
//		if (!attribute.getEContainingClass().isSuperTypeOf(
//				link.getTarget().getEObject().eClass())) {
//			return;
//		}
//		
//		Object sourceValue = RequirementUtil.getAttributeValue(req, attribute);
//		Object targetValue = cap.eGet(attribute);
//		if ((sourceValue != null) && (!sourceValue.equals(targetValue))) {
//			reporter.addStatus(DeployCoreStatusUtil
//					.createDependencyLinkEndpointAttributeMismatchStatus(link,
//							attribute.getEContainingClass(), attribute
//									.getEContainingClass(), attribute));
//		}
//	}
	/**
	 * Finds a provided capability of the specified type down the unit's hosting stack.
	 * 
	 * @param capabilityType
	 *           the capability type.
	 * @param unit
	 *           the unit from which to start the search (the unit's provided capabilities are not
	 *           searched).
	 * @return the capability found, null if it does not exist, or multiple instances are found, or
	 *         if a cycle is detected
	 */
	public static Capability findProvidedCapabilityInHostingStack(EClass capabilityType, Unit unit) {
//		HashSet hostingStackUnits = new HashSet();
//		hostingStackUnits.add(unit);
//		Unit[] hosts = unit.getTopology().findHosts(unit);
//		while (hosts.length == 1) {
//			Capability result = null;
//			int count = 0;
//			Unit host = hosts[0];
//			if (hostingStackUnits.contains(host)) {
//				return null;
//			} else {
//				hostingStackUnits.add(host);
//			}
//			for (Iterator iter = new SequentialIterator(host.getOnlyDependencyCapabilities()
//					.iterator(), host.getHostingOrAnyCapabilities().iterator()); iter
//					.hasNext();) {
//				Capability service = (Capability) iter.next();
//				if (capabilityType.isSuperTypeOf(service.getEObject().eClass())) {
//					result = service;
//					count++;
//				}
//			}
//			if (count == 1) {
//				return result;
//			} else if (count > 1) {
//				return null;
//			}
//			hosts = host.getTopology().findHosts(host);
//		}
//		return null;

		HashSet hostingStackUnits = new HashSet();
		hostingStackUnits.add(unit);
//		Unit[] hosts = unit.getTopology().findHosts(unit);
		Unit host = TopologyDiscovererService.INSTANCE.findHost(unit, unit.getTopology());
//		while (hosts.length == 1) {
		while (host != null) {
			Capability result = null;
			int count = 0;
			if (hostingStackUnits.contains(host)) {
				return null;
			}

			hostingStackUnits.add(host);
			for (Iterator iter = new SequentialIterator(host.getOnlyDependencyCapabilities()
					.iterator(), host.getHostingOrAnyCapabilities().iterator()); iter.hasNext();) {
				Capability cap = (Capability) iter.next();
				if (capabilityType.isSuperTypeOf(cap.getEObject().eClass())) {
					result = cap;
					count++;
				}
			}
			if (count == 1) {
				return result;
			} else if (count > 1) {
				return null;
			}
//			hosts = host.getTopology().findHosts(host);
			host = TopologyDiscovererService.INSTANCE.findHost(host, unit.getTopology());
		}
		return null;
	}

	/**
	 * Returns target capability, using (a) requirement's link's target, or (b) if no link on
	 * requirement, the discovery service.
	 * 
	 * 
	 * @param sourceUnit
	 * @param req
	 * @param targetUnit
	 * @return Capability
	 */
	// TODO MK Please consider providing this function in discovery service
	public static Capability findTargetCapability(Requirement req, Unit sourceUnit, Unit targetUnit) {
		Capability returnCap = ValidatorUtils.getDependencyLinkTarget(req);
		if (returnCap != null) {
			return returnCap;
		}
		int targetCount = 0;
		// TODO use unit.getCapabilities() with filter
		for (Iterator iter = ValidatorUtils.getCapabilities(targetUnit, req.getDmoEType()).iterator(); iter
				.hasNext();) {
			Capability cap = (Capability) iter.next();
			List sourcesList = TopologyDiscovererService.INSTANCE.findSources(targetUnit, cap,
					sourceUnit.getTopology());
			for (Iterator innerIter = sourcesList.iterator(); innerIter.hasNext();) {
				UnitDescriptor testSourceUD = (UnitDescriptor) innerIter.next();
				if ((testSourceUD == null) || (testSourceUD.getUnitValue() == null)) {
					continue;
				}
				if (testSourceUD.getUnitValue().equals(sourceUnit)) {
					returnCap = cap;
					targetCount += sourcesList.size();
				}
			}
		}
		if (targetCount != 1) {
			return null;
		}
		return returnCap;
	}

}
