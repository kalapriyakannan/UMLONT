/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.ObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployWrapperStatus;

/**
 * A resolution which invokes {@link DeploySetAttributeResolution} on all current
 * {@link IDeployAttributeValueStatus}, repeating until no more are found.
 * 
 * @see SetAllAttributesInUnitResolution
 */
public class SetAllAttributesInTopologyResolution extends DeployResolution {

	/**
	 * Annotation key for mapping original full path names to copy full path names.
	 */
	public static final String ORIGINAL_TO_COPY_ANNOTATION = SetAllAttributesInTopologyResolution.class
			.getName()
			+ "$original2copy"; //$NON-NLS-1$
	/**
	 * Annotation key for mapping copy full path names to original full path names.
	 */
	public static final String COPY_TO_ORIGINAL_ANNOTATION = SetAllAttributesInTopologyResolution.class
			.getName()
			+ "$copy2original"; //$NON-NLS-1$

	/**
	 * Default number of iterations of validation and resolution (to break cycles).
	 */
	public final static int DEFAULT_MAX_PASS_COUNT = 100;

	/**
	 * Filters instances of {@link IDeployAttributeValueStatus}.
	 * 
	 * @see FilterIterator
	 */
	public static final IObjectFilter DEPLOY_ATTRIBUTE_VALUE_STATUS_FILTER = new ObjectTypeFilter(
			IDeployAttributeValueStatus.class, true);

	/**
	 * Maximum number of validate/resolve iterations.
	 */
	protected int maxPassCount = DEFAULT_MAX_PASS_COUNT;

	/**
	 * Construct a deploy resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public SetAllAttributesInTopologyResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployCoreMessages.Resolution_set_all_attribute_values_in_topology);
		setPriority(-50);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		monitor.beginTask(DeployCoreMessages.Resolution_set_all_attribute_values_in_topology, 3);

		//
		// Copy topology to experiment with validation & resolutions
		//
		monitor.subTask(DeployCoreMessages.Resolution_duplicating_topology);
		Topology copy = duplicate(context.getTopology());
		monitor.worked(1);

		//
		// Search for attribute values
		//
		monitor.subTask(DeployCoreMessages.Resolution_searching_attribute_values);

		/**
		 * Number of attributes propagated in the last validation/resolution cycle.
		 */
		int propagationCount = 0;

		/** Number of validate/resolve iterations. */
		int passCount = 0;

		/**
		 * Special object placed in the map to signify a conflict (multiple expected values for a
		 * given attribute).
		 */
		final Object CONFLICT = new Object();

		/**
		 * Map<String, Object> unique object + attribute key identifier to either
		 * IDeployAttributeValueStatus or <code>CONFLICT</code>
		 */
		Map keyStatusMap = new HashMap();

		/**
		 * Map of object name + attribute keys used within each pass to find conflicts <em>within</em>
		 * the pass.
		 */
		Map passKeyStatusMap = new HashMap();

		do {
			passCount++;
			propagationCount = 0;

			// Validate
			context.getDeployValidatorService().validate(copy);

			// Collect all the {@link IDeployAttributeValueStatus} on objects
			// of the topology into the <code>passKeyStatusMap</code>.
			passKeyStatusMap.clear();
			for (Iterator iter = copy.findAllDeployModelObjects(); iter.hasNext();) {
				DeployModelObject dmo = (DeployModelObject) iter.next();
				if (dmo.getStatus().isOK()) {
					continue;
				}
				for (DeployStatusIterator it = new DeployStatusIterator(dmo); it.hasNext();) {
					com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus s = it.next();
					if (s instanceof DeployWrapperStatus) {
						s = ((DeployWrapperStatus) s).getWrappedStatus();
					}
					if (s instanceof IDeployAttributeValueStatus) {
//				for (Iterator iter2 = new FilterIterator(new StatusIterator(dmo),
//						DEPLOY_ATTRIBUTE_VALUE_STATUS_FILTER); iter2.hasNext();) {
						IDeployAttributeValueStatus valueStatus = (IDeployAttributeValueStatus) s;
						if (valueStatus.getAttributeName() == null
								|| !ResolutionUtils.isSettable(valueStatus)) {
							continue;
						}
						String key = valueStatus.getDeployObject().getFullPath() + '.'
								+ valueStatus.getAttributeName();
						if (passKeyStatusMap.containsKey(key)) {
							// Multiple settings of key in the same pass
							passKeyStatusMap.put(key, CONFLICT);
						} else {
							// Accept for this pass
							passKeyStatusMap.put(key, valueStatus);
						}
					}
				}
			}

			//
			// Apply non-conflicting and non-cyclical attribute propagations.
			//
			for (Iterator iter2 = passKeyStatusMap.entrySet().iterator(); iter2.hasNext();) {
				Map.Entry entry = (Map.Entry) iter2.next();
				if (!(entry.getValue() instanceof IDeployAttributeValueStatus)) {
					continue;
				}
				String key = (String) entry.getKey();
				IDeployAttributeValueStatus status = (IDeployAttributeValueStatus) entry.getValue();
				// Note: may override a previous setting (last one wins)
				keyStatusMap.put(key, status);

				IDeployResolutionContext context2 = createResolutionContext(status, context);
				DeploySetAttributeResolution resolution = new DeploySetAttributeResolution(status,
						context2, null);
				IStatus resolveStatus = resolution.resolve(monitor);
				if (!resolveStatus.isOK()) {
					return resolveStatus;
				}
				propagationCount++;
			}

			if (passCount > maxPassCount) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
						DeployCoreMessages.Resolution_propagation_cycle_found_or_max_length_exceeded,
						null);
			}
		} while (propagationCount > 0);

		monitor.worked(1);

		//
		// Apply attribute value updates on current topology
		//
		monitor.subTask(DeployCoreMessages.Resolution_setting_attribute_values);
		for (Iterator iter2 = keyStatusMap.values().iterator(); iter2.hasNext();) {
			Object next = iter2.next();
			if (!(next instanceof IDeployAttributeValueStatus)) {
				continue;
			}
			IDeployAttributeValueStatus valueStatus = (IDeployAttributeValueStatus) next;
			DeployModelObject object = context.getTopology().resolve(
					valueStatus.getDeployObject().getFullPath());
			Object value = valueStatus.getAttributeExpectedValue();
			if (value instanceof DeployModelObject
					&& copy == ((DeployModelObject) value).getTopology()) {
				value = context.getTopology().resolve(((DeployModelObject) value).getFullPath());
			}

			if (valueStatus.getAttributeType() != null) {
				object.eSet(valueStatus.getAttributeType(), value);
			} else {
				ExtendedAttribute attr = object.getExtendedAttribute(valueStatus.getAttributeName());
				if (attr != null) {
					attr.setValue(value);
				}
			}

		}
		monitor.worked(1);
		monitor.done();

		return Status.OK_STATUS;
	}

	/**
	 * Duplicate all objects in a topology.
	 * <p>
	 * Copies all units of the topology as well as all imported topologies.
	 * <p>
	 * This logic is not general. We now have non-unit contents in topologies such as
	 * ConfigurationContract. We could expand the logic, or generalize the proxy layer and use one
	 * here as well. M5 material.
	 * 
	 * @param top
	 *           the topology to be duplicated.
	 * @return a copy of the topology.
	 */
	public static Topology duplicate(Topology top) {
		Topology copy = CoreFactory.eINSTANCE.createTopology();
		copy.setDecoratorSemantic(top.getDecoratorSemantic());
		copy.setName(top.getName());
		copy.setNamespace(top.getNamespace());
		copy.setDisplayName(top.getDisplayName());

		ArrayList unitList = new ArrayList();
		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			unitList.add(iter.next());
		}
		Annotation originalAnn = CoreFactory.eINSTANCE.createAnnotation();
		originalAnn.setContext(ORIGINAL_TO_COPY_ANNOTATION);
		copy.getAnnotations().add(originalAnn);

		Annotation copyAnn = CoreFactory.eINSTANCE.createAnnotation();
		copyAnn.setContext(COPY_TO_ORIGINAL_ANNOTATION);
		copy.getAnnotations().add(copyAnn);

		Map unitCopyMap = ResolutionUtils.intelligentDeepCopyMap(unitList, copy, false);
		for (Iterator iter = unitCopyMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			Unit unit = (Unit) entry.getKey();
			Unit unitCopy = (Unit) entry.getValue();
			copy.getUnits().add(unitCopy);
			originalAnn.getDetails().put(unit.getFullPath(), unitCopy.getFullPath());
			copyAnn.getDetails().put(unitCopy.getFullPath(), unit.getFullPath());
		}
		// Topology-level links should have been handled by the proxy's
		// interception of getXXXLinks().

		// we explicitly do the realizaion links
		// copy realization links: owned by topology
		for (Iterator it = top.findAllRealizationLinks(); it.hasNext();) {
			RealizationLink link = (RealizationLink) it.next(); // MK 2/27/2007
			DeployModelObject source = resolveDuplicate(link.getSource(), copy);
			DeployModelObject target = resolveDuplicate(link.getTarget(), copy);
			LinkFactory.createRealizationLink(source, target); //, copy);
		}

		return copy;
	}

	/**
	 * Resolves the full path of an original object to its copy object.
	 * 
	 * @param object
	 *           an object in the original topology duplicated using {@link #duplicate(Topology)}.
	 * @param dupTop
	 *           a topology created as a duplicate using {@link #duplicate(Topology)}.
	 * @return the resolved object, or null if not found.
	 */
	public static DeployModelObject resolveDuplicate(DeployModelObject object, Topology dupTop) {
		if (object == null) {
			return null;
		}
		return resolveDuplicate(object.getFullPath(), dupTop);
	}

	/**
	 * Resolves the full path of an original object to its copy object.
	 * 
	 * @param originalPath
	 *           the original object's {@link DeployModelObject#getFullPath()}.
	 * @param dupTop
	 *           a topology created as a duplicate using {@link #duplicate(Topology)}.
	 * @return the resolved object, or null if not found.
	 */
	public static DeployModelObject resolveDuplicate(String originalPath, Topology dupTop) {
		if (originalPath == null || dupTop == null) {
			return null;
		}
		Annotation annotation = dupTop.findAnnotation(ORIGINAL_TO_COPY_ANNOTATION);
		if (annotation == null) {
			return null;
		}
		Object path = annotation.getDetails().get(originalPath);
		if (path instanceof String) {
			return dupTop.resolve((String) path);
		}
		return null;
	}

	/**
	 * Returns the full path to the deploy model object originating the copy.
	 * <p>
	 * The copy should have been made using {@link #duplicate(Topology)}.
	 * 
	 * @param copy
	 *           the duplicate object.
	 * @return the full path to the original.
	 */
	public static String getOriginalPath(DeployModelObject copy) {
		if (copy == null) {
			return null;
		}
		Topology copyTop = copy.getTopology();
		if (copyTop == null) {
			return null;
		}
		Annotation annotation = copyTop.findAnnotation(COPY_TO_ORIGINAL_ANNOTATION);
		if (annotation == null) {
			return null;
		}
		Object path = annotation.getDetails().get(copy.getFullPath());
		if (path instanceof String) {
			return (String) path;
		}
		return null;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SetAllAttributesInTopologyResolution)) {
			return false;
		}

		if (getDeployStatus().getDeployObject().getTopology() == null) {
			return false;
		}
		return getDeployStatus().getDeployObject().getTopology().equals(
				((SetAllAttributesInTopologyResolution) obj).getDeployStatus().getDeployObject()
						.getTopology());
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (getDeployStatus().getDeployObject().getTopology() == null) {
			return super.hashCode();
		}
		return getDeployStatus().getDeployObject().getTopology().hashCode();
	}
}
