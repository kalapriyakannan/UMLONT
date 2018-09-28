/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.discoverer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.ServerUtil;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;

/**
 * @author nmakin
 * 
 */
public class IdeJ2EEUnitDiscoverer extends UnitDiscoverer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitDiscoverer#canDiscover(com.ibm.ccl.soa.deploy.core.DiscoveryFilter)
	 */
	public boolean canDiscover(DiscoveryFilter filter) {
		Unit unit = filter.getUnit();
		if (null != unit) {
			if (unit instanceof EarModule || unit instanceof WebModule || unit instanceof EjbModule
					|| unit instanceof JCAModule || unit instanceof AppClient) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitDiscoverer#findAll(com.ibm.ccl.soa.deploy.core.DiscoveryFilter)
	 */
	public List findAll(DiscoveryFilter filter) {
		List result = new ArrayList();

		// try special casing to find if we are trying to traverse existing
		// links
		if (DiscoveryFilterFactory.isFindPossibleHostsFilter(filter)) {
			//TODO implement this???
			return ideGetPossibleHost(filter);
		}

		if (DiscoveryFilterFactory.isFindPossibleHostedFilter(filter)) {
			//TODO ??
			return ideGetPossibleHosted(filter);
		}

		return result;
	}

	private List ideGetPossibleHosted(DiscoveryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	private List ideGetPossibleHost(DiscoveryFilter filter) {
		Unit hostee = filter.getUnit();
		List results = new ArrayList();
		if (hostee != null) {
			Annotation annotation = hostee.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
			if (annotation != null) {
				String moduleType = (String) annotation.getDetails().get(
						IAnnotationConstants.MODULE_TYPE);
				IRuntime[] runtimes = ServerUtil.getRuntimes(moduleType, "*"); //$NON-NLS-1$				
				for (int i = 0; runtimes != null && i < runtimes.length; i++) {
					Annotation hostAnnotation = CoreFactory.eINSTANCE.createAnnotation();
					hostAnnotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
					hostAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_ID,
							runtimes[i].getName());
					hostAnnotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
							runtimes[i].getRuntimeType().getId());
					results.add(new IdeUnitDescriptorImpl(hostAnnotation, hostee.getTopology()));
				}
			}
		}
		return results;
	}

}
