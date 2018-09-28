/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.extension.IUnitPublisherService;

public abstract class IdeUnitPublisher extends UnitPublisher {

	/**
	 * Constant represents tooling is based on solely wtp/dtp function
	 * 
	 * 
	 */
	public static String ENVIRONMENT_WTP = IAnnotationConstants.ENVIRONMENT_WTP;
	/**
	 * Constant represents tooling is based on wtp and ast function
	 * 
	 * @since 1.0
	 */
	public static String ENVIRONMENT_AST = "ast"; //$NON-NLS-1$

	/**
	 * Annotations iterated through to find a module uri.
	 * 
	 * @see getServerModules(Modules[])
	 * @since 1.0
	 * @return String ,a uri for locating a Module with in a workspace or platform.
	 */

	protected abstract String getModuleURI(List annotations);

	/**
	 * Returns true if this publisher can publish the specified host unit
	 * 
	 * @since 1.0
	 */

	public boolean canPublish(Unit hostUnit) {

		// Check runtime annotations exist
		// TODO report error?
		String runtimeInstanceId = getRuntimeInstanceId(hostUnit);
		if (runtimeInstanceId == null || runtimeInstanceId.equals("")) //$NON-NLS-1$
			return false;
		String runtimeTypeId = getRuntimeTypeId(hostUnit);
		if (runtimeTypeId == null || runtimeTypeId.equals("")) //$NON-NLS-1$
			return false;

		return true;
	}

	/**
	 * Iterates through hosts gathering modules and configurations. Durning the iteration
	 * publish(host,modules,configurationModules) is called for each host.
	 * 
	 * @since 1.0
	 * @return IStatus - could contain many IStatus collected during the publish process
	 */

	public IStatus publish(Topology topology, IUnitPublisherService unitService) {
		setUnitPublisherService(unitService);
		List hosts = unitService.getHostsForPublisher(this);
		for (int i = 0; i < hosts.size(); i++) {
			Unit host = (Unit) hosts.get(i);
			List modules = unitService.getTopologyCache().getHostedUnits(host);
			List configurationModules = unitService.getTopologyCache()
					.getHostedConfigUnitsForHostUnit(host);
			// Remove units w/o publishIntent == PUBLISH
			List newModules = null;
			if (modules != null) {
				newModules = new ArrayList();
				for (int j = 0; j < modules.size(); j++) {
					Unit module = (Unit) modules.get(j);
					if (module.getPublishIntent().equals(PublishIntent.PUBLISH_LITERAL))
						newModules.add(module);
				}
			}
			List newConfigs = null;
			if (configurationModules != null) {
				newConfigs = new ArrayList();
				for (int j = 0; j < configurationModules.size(); j++) {
					Unit config = (Unit) configurationModules.get(j);
					if (config.getPublishIntent().equals(PublishIntent.PUBLISH_LITERAL))
						newConfigs.add(config);
				}
			}
			publish(host, newModules, newConfigs);
		}
		// TODO gather status
		return Status.OK_STATUS;
	}

	/**
	 * Intended to be overridden by clients. Per host, releated modules and configuration units are
	 * passed.
	 * 
	 * @since 1.0
	 * @return IStatus - could contain many IStatus collected during the publish process
	 */

	abstract protected IStatus publish(Unit host, List modules, List configurationModules);

	/**
	 * Retrieves runtime type information from an annotation on the host. Can be overriden by client
	 * for annotation mining. Types must exist for server creatation.
	 * 
	 * @since 1.0
	 * @return String runtimeType
	 */

	public String getRuntimeInstanceId(Unit hostUnit) {
		List annotations = hostUnit.getAnnotations();
		// get annotations by 
		String runtimeID = null;
		for (Iterator iter = annotations.iterator(); iter.hasNext();) {
			Annotation element = (Annotation) iter.next();
			if (element.getContext().equals(getEnvironment())) {
				Object obj = element.getDetails().get(IAnnotationConstants.RUNTIME_ID);
				if (obj != null && (obj instanceof String))
					runtimeID = (String) obj;
			}
		}
		return runtimeID;
	}

	/**
	 * Retrieves runtime type information from an annotation on the host. Can be overriden by client
	 * for annotation mining. Types must exist for server creatation.
	 * 
	 * @since 1.0
	 * @return String runtimeType
	 */

	public String getRuntimeTypeId(Unit hostUnit) {
		List annotations = hostUnit.getAnnotations();
		String runtimeType = null;
		for (Iterator iter = annotations.iterator(); iter.hasNext();) {
			Annotation element = (Annotation) iter.next();
			if (element.getContext().equals(getEnvironment())) {
				Object obj = element.getDetails().get(IAnnotationConstants.RUNTIME_TYPE);
				if (obj != null && (obj instanceof String))
					runtimeType = (String) obj;
			}
		}
		return runtimeType;
	}

	/**
	 * For performance list are converted to []
	 * 
	 * @since 1.0
	 * @return Module[]
	 */

	protected Unit[] toModuleArray(List moduleList) {
		if (moduleList == null)
			return null;
		return (Unit[]) moduleList.toArray(new Unit[moduleList.size()]);

	}

}
