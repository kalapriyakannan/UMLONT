/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.discoverer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @author nmakin
 * 
 */
public class IdeDiscoveryUtil {
	public static IdeDiscoveryUtil INSTANCE = new IdeDiscoveryUtil();

	public IdeDiscoveryUtil() {

	}

	/**
	 * Returns list of hosts that a) match all hosting requirements and b) have the same WTP server
	 * annotations as the srcUnit
	 * 
	 * @param srcUnit
	 * @param annotation
	 * @return
	 */
	public List getPossibleHosts(Unit srcUnit, Annotation annotation) {
		List possibleHosts = getPossibleHosts(srcUnit);
		List results = new ArrayList();
		for (Iterator it = possibleHosts.iterator(); it.hasNext();) {
			Unit candidate = (Unit) it.next();
			List annotations = candidate.getAnnotations();
			for (Iterator iter = annotations.iterator(); iter.hasNext();) {
				Annotation candAnnotation = (Annotation) iter.next();
				if (!candAnnotation.getContext().equals(annotation.getContext()))
					continue;
				String candRuntimeTypeId = (String) candAnnotation.getDetails().get(
						IAnnotationConstants.RUNTIME_TYPE);
				String candRuntimeId = (String) candAnnotation.getDetails().get(
						IAnnotationConstants.RUNTIME_ID);
				if ((candRuntimeTypeId == null) || (candRuntimeId == null))
					continue;
				String runtimeTypeId = (String) annotation.getDetails().get(
						IAnnotationConstants.RUNTIME_TYPE);
				String runtimeId = (String) annotation.getDetails()
						.get(IAnnotationConstants.RUNTIME_ID);
				if (candRuntimeTypeId.equals(runtimeTypeId) && candRuntimeId.equals(runtimeId))
					results.add(candidate);
			}
		}
		return results;
	}

	/**
	 * Returns list of hosts that match hosting requirements of srcUnit
	 * 
	 * @param srcUnit
	 * @return
	 */
	public List getPossibleHosts(Unit srcUnit) {

		List results = new ArrayList();

		//IDeployResolutionContext context = new DeployResolutionContext( null, null );
		//DeployValidatorService dvs = context.getDeployValidatorService();
		DeployValidatorService dvs = new DeployValidatorService();

		LinkType[] linkTypes = new LinkType[] { LinkType.HOSTING };

		Topology top = srcUnit.getTopology();
		if (top != null) {
			for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
				Unit candidate = (Unit) it.next();
				if (candidate != srcUnit) {
					LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(candidate, srcUnit,
							linkTypes);
					if (linkDescriptorArray.length > 0) {
						results.add(candidate);
					}
				}
			}
		}
		return results;
	}

	// TODO API to determine if unit corresponding to given runtime type, id already exists in topology
	/**
	 * Returns the unit matching the given runtime type and id, null if not found
	 * 
	 * @param targetRuntimeType
	 * @param targetRuntimeId
	 * @param topology
	 * 
	 * @return the found unit, or null
	 */
	public Unit findUnitInTopology(String targetRuntimeType, String targetRuntimeId,
			Topology topology) {
		Iterator units = topology.getUnits().iterator();
		while (units.hasNext()) {
			Unit unit = (Unit) units.next();
			Annotation annotation = unit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
			if (annotation != null) {
				String runtimeType = (String) annotation.getDetails().get(
						IAnnotationConstants.RUNTIME_TYPE);
				String runtimeId = (String) annotation.getDetails()
						.get(IAnnotationConstants.RUNTIME_ID);
				if ((runtimeType != null) && (runtimeId != null)) {
					if (runtimeType.equals(targetRuntimeType) && runtimeId.equals(targetRuntimeId))
						return unit;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the unit matching the given runtime type and id, null if not found
	 * 
	 * @param runtimeType
	 * @param runtimeId
	 * @param topology
	 * 
	 * @return the found unit, or null
	 */
	public Unit findUnitInTopology(Unit targetUnit, Topology topology) {
		Annotation annotation = targetUnit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeType = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_TYPE);
			String runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
			if ((runtimeType != null) && (runtimeId != null)) {
				return findUnitInTopology(runtimeType, runtimeId, topology);
			}
		}

		return null;
	}

	/**
	 * Finds all the units hosted by this unit that possess a capability of the specified type.
	 * 
	 * Will recurse each hosted unit to inspect its hosted units, etc.
	 * 
	 * @param host
	 *           The host unit to inspect
	 * @param type
	 *           The capability type to query on each hosted unit
	 * 
	 * @return an list of units in the hosting stack of host that contain the specified capability
	 *         type
	 */
	public List findAllHostedUnitsofType(Unit host, EClass type) {
		List hostedUnits = new ArrayList();
		if (host != null) {
			Iterator hostedIter = ValidatorUtils.getHosted(host).iterator();
			while (hostedIter.hasNext()) {
				Unit hosted = (Unit) hostedIter.next();
				if (hosted != null) {
					if (CapabilityUtil.findCapabilityOfType(hosted, type) != null)
						hostedUnits.add(hosted);
					List moreHostedUnits = findAllHostedUnitsofType(hosted, type); //recurse
					hostedUnits.addAll(moreHostedUnits);
				}
			}
		}

		return hostedUnits;
	}

}
