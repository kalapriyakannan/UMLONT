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

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.provider.discovery.CurrentTopologyDiscoverer;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitDiscovererDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

/**
 * Implementation of IdeTopologyDiscoverer.
 * 
 * @since 1.0
 * 
 */
public class IdeTopologyDiscoverer extends CurrentTopologyDiscoverer {

	public boolean canDiscover(DiscoveryFilter filter) {
		if (filter == null) {
			return false;
		}
		Unit unit = filter.getUnit();
		if (unit == null)
			return false;
		if (getTopology() == null)
			if (filter.getTopology() == null)
				return false;
		if (unit instanceof SoftwareComponent)
			return true;
		return super.canDiscover(filter);
	}

	public List findAll(DiscoveryFilter filter) {
		List retValue = new ArrayList();
		if (filter == null) {
			return retValue;
		}
		setTopology(filter.getTopology());
		retValue = ideFindAll(filter);
		/*
		 * This is now done in TopologyDiscoverer service call if(retValue.size() == 0)
		 * retValue.addAll(super.findAll(filter));
		 */
		return retValue;
	}

	protected List ideFindAll(DiscoveryFilter filter) {
		List result = new ArrayList();

		// check if topology is valid
		if (getTopology() == null) {
			return result;
		}

		// try special casing to find if we are trying to traverse existing
		// links
		if (DiscoveryFilterFactory.isFindHostFilter(filter)) {
			//TODO implement this???
			return ideGetHost(filter);
		}

		if (DiscoveryFilterFactory.isFindHostedFilter(filter)) {
			//TODO ??
			return ideGetHosted(filter);
		}
		if (DiscoveryFilterFactory.isFindPossibleHostsFilter(filter)) {
			return ideGetPossibleHosts(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleHostedFilter(filter)) {
			return ideGetPossibleHosted(filter);
		}
		if (DiscoveryFilterFactory.isFollowDependencyFilter(filter)) {
			//TODO ??
			return ideTraverseDependencyLink(filter);
		}

		return result;
	}

	private List ideGetHosted(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		return result;
	}

	private List ideGetHost(DiscoveryFilter filter) {
		// BA 2007/03/10 getAllHosts gets all hosts in peers-of-unit realization chain.
		// Should this be findHost(filter)?
//		Unit unit = filter.getUnit();
//		List hosts = ValidatorUtils.getAllHosts(unit);
		List hosts = getHost(filter);
		ArrayList results = new ArrayList(hosts.size());
		for (Iterator iter = hosts.iterator(); iter.hasNext();) {
			UnitDescriptor hostUD = (UnitDescriptor) iter.next();
			if (hostUD != null) {
				Unit host = hostUD.getUnitValue();
				if (host != null) {
					results.add(new IdeUnitDescriptorImpl(host, topology));
				}
			}
		}
		return results;
	}

	protected List ideTraverseDependencyLink(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		return result;
	}

	protected List ideGetPossibleHosted(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		return result;
	}

	protected List ideGetPossibleHosts(DiscoveryFilter filter) {
		// TODO use the annotation on the Unit to find the host
		List results = new ArrayList();
		results = ideGetExistingPossibleHost(filter);
		if (results.size() == 0) {
			//results.addAll(findPossibleHostInCurrentTopology(filter));
			results.addAll(findPossibleHostInCurrentWorkspace(filter));
		}

		return results;
	}

	private List ideGetExistingPossibleHost(DiscoveryFilter filter) {
		Unit unit = filter.getUnit();

		//TODO use the annotation on the Unit to find the host
		//If already hosted then it should not be in the list to ask
		//Or else the host will be returned
		// BA 2007/03/10 getAllHosts gets all hosts in peers-of-unit realization chain. 
		// Should this be findHost(filter)?
//		List hosts = ValidatorUtils.getAllHosts(unit);		
		List hosts = getHost(filter);

		if (!hosts.isEmpty()) {
			ArrayList results = new ArrayList(hosts.size());
			for (Iterator iter = hosts.iterator(); iter.hasNext();) {
				Unit host = (Unit) iter.next();
				results.add(new IdeUnitDescriptorImpl(host, topology));
			}
			return results;
		}
		Topology topology = getTopology();
		ArrayList results = new ArrayList();
		List annotations = unit.getAnnotations();
		for (Iterator iter = annotations.iterator(); iter.hasNext();) {
			Annotation annotation = (Annotation) iter.next();
			if (!annotation.getContext().equals(IAnnotationConstants.ENVIRONMENT_WTP))
				continue;
			String runtimeTypeId = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_TYPE);
			String runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
			if (runtimeTypeId == null || runtimeId == null)
				continue;
			//call that service to return the possible hosts, filter units based on the annotation
			//pick first and return that
			List existingUnitList = IdeDiscoveryUtil.INSTANCE.getPossibleHosts(unit, annotation);
			//TODO Cannot reuse module annotation here - create new one or use existing one on the existing host unit
			if (existingUnitList.size() > 0) {
				//get either installed unit or first one
				Unit installedOrFirstHostUnit = findInstalledOrFirstUnit(existingUnitList);
				Annotation newAnnotation = installedOrFirstHostUnit
						.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
				if (newAnnotation == null) // this should never be?
				{
					newAnnotation = CoreFactory.eINSTANCE.createAnnotation();
					newAnnotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
					newAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtimeId);
					newAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE, runtimeTypeId);
				}
				results.add(new IdeUnitDescriptorImpl((Unit) existingUnitList.get(0), newAnnotation,
						topology));
			} else {

				Annotation newAnnotation = CoreFactory.eINSTANCE.createAnnotation();
				newAnnotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
				newAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtimeId);
				newAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE, runtimeTypeId);
				results.add(new IdeUnitDescriptorImpl(newAnnotation, topology));
			}
		}
		return results;
	}

	private Unit findInstalledOrFirstUnit(List existingUnitList) {
		for (Iterator iter = existingUnitList.iterator(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (unit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
				return unit;
			}
		}
		return (Unit) existingUnitList.get(0);
	}

	private List findPossibleHostInCurrentTopology(DiscoveryFilter filter) {
		List existingUnitList = IdeDiscoveryUtil.INSTANCE.getPossibleHosts(filter.getUnit());
		List result = new ArrayList();
		if (existingUnitList != null && existingUnitList.size() > 0) {
			Unit installedOrFirstHostUnit = findInstalledOrFirstUnit(existingUnitList);
			if (installedOrFirstHostUnit != null) {
				// add installed unit as first possible choice if exists
				result.add(new IdeUnitDescriptorImpl(installedOrFirstHostUnit, getTopology()));
				existingUnitList.remove(installedOrFirstHostUnit);
				for (Iterator iter = existingUnitList.iterator(); iter.hasNext();) {
					Unit element = (Unit) iter.next();
					result.add(new IdeUnitDescriptorImpl(element, getTopology()));
				}
			}
		}
		return result;
	}

	private List findPossibleHostInCurrentWorkspace(DiscoveryFilter filter) {
		List result = new ArrayList();
		UnitDiscovererDescriptor[] unitDiscovererDescs = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitDiscoverersByInputOnly(filter.getUnit());
		for (int i = 0; i < unitDiscovererDescs.length; ++i) {
			UnitDiscoverer unitDiscoverer = unitDiscovererDescs[i].createUnitDiscoverer();
			if (unitDiscoverer.canDiscover(filter)) {
				List res = unitDiscoverer.findAll(filter);
				if (res != null)
					result.addAll(unitDiscoverer.findAll(filter));
			}
		}
		return result;
	}

}
