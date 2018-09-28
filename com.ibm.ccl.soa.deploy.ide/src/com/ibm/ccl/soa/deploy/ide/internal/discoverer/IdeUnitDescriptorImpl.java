/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.discoverer;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * 
 * @since 1.0
 * 
 */
public class IdeUnitDescriptorImpl extends UnitDescriptor {

	private Annotation annotation;
	private Topology topology;
	private String runtimeTypeId;
	private String runtimeId;

	public IdeUnitDescriptorImpl(Unit unit, Topology topology) {
		existingUnit = true;
		this.topology = topology;
		this.setAnnotation(unit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP));
		this.setUnitValue(unit);
	}

	public IdeUnitDescriptorImpl(Unit unit, Annotation annotation, Topology topology) {
		existingUnit = true;
		this.topology = topology;
		this.setAnnotation(annotation);
		this.setUnitValue(unit);
	}

	public IdeUnitDescriptorImpl(Annotation annotation, Topology topology) {
		this.setAnnotation(annotation);
		this.topology = topology;
	}

	protected String createDescriptorName() {
		if (annotation != null) {
			StringBuffer buf = new StringBuffer(getRuntimeTypeId());
			buf.append("."); //$NON-NLS-1$
			buf.append(getRuntimeId());
			return buf.toString();
		}
		return "defaultDescriptorName"; //$NON-NLS-1$
	}

	private String getRuntimeId() {
		if (runtimeId == null) {
			if (annotation != null) {
				runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
			}
		}
		return runtimeId;
	}

	private String getRuntimeTypeId() {
		if (runtimeTypeId == null) {
			if (annotation != null) {
				runtimeTypeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_TYPE);
			}
		}
		return runtimeTypeId;
	}

	protected Unit getUnit() {
		if (!existingUnit) {
			return (Unit) getCreatedUnits()[0];
		}
		return unit;
	}

	protected String createDisplayName() {
		return getRuntimeId();
	}

	private Object[] getCreatedUnits() {
		if (annotation != null) {
			IUnitProviderService unitProviderService = ExtensionsCore.createProviderService();
			UnitProvider[] providers = unitProviderService.findEnabledProvidersByInputOnly(annotation);
			if (providers.length > 0 && providers[0] != null) {
				TopologyUnitStub[] stubs = providers[0].resolveStubs(annotation);
				stubs[0].setTopology(topology);
				return providers[0].resolveUnit(stubs[0], true, new NullProgressMonitor());
			}
		}
		return new Object[0];
	}

	protected Unit getUnitAndAddToTopology(Topology topology) {
		if (!existingUnit) {
			Object[] objects = getCreatedUnits();
			for (int i = 0; i < objects.length; i++) {
				ResolutionUtils.makeNameUnique((Unit) objects[i], topology);
				topology.getUnits().add(objects[i]);
			}
			return (Unit) objects[0];
		}
		return unit;
	}

	/**
	 * @param annotation
	 *           the annotation to set
	 */
	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}

	/**
	 * @return the annotation
	 */
	public Annotation getAnnotation() {
		return annotation;
	}

	/**
	 * @param topology
	 *           the topology to set
	 */
	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	/**
	 * @return the topology
	 */
	public Topology getTopology() {
		return topology;
	}

	public boolean referencesUnit(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean referencesUnit(UnitDescriptor descriptor) {
		// TODO Auto-generated method stub
		return false;
	}

}
