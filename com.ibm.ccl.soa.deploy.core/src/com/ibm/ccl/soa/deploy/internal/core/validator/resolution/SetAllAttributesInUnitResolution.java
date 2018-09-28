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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A resolution which invokes {@link DeploySetAttributeResolution} on all current
 * {@link IDeployAttributeValueStatus} in a unit and its contained objects.
 * 
 * @see SetAllAttributesInTopologyResolution
 */
public class SetAllAttributesInUnitResolution extends DeployResolution {

	/**
	 * Default number of iterations of validation and resolution (to break cycles).
	 */
	public final static int DEFAULT_MAX_PASS_COUNT = 100;

	/**
	 * Construct a deploy resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public SetAllAttributesInUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployCoreMessages.Resolution_set_all_attribute_values_in_unit);
		setPriority(-49);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		Unit unit = ValidatorUtils.getUnit(context.getDeployStatus().getDeployObject());

		if (unit == null) {
			return Status.CANCEL_STATUS;
		}
		List valueStatusList = ValidatorUtils.getDeployStatusRecursive(unit,
				IDeployAttributeValueStatus.class);
		if (valueStatusList.size() == 0) {
			return Status.CANCEL_STATUS;
		}
		return resolve(valueStatusList, monitor);
	}

	/**
	 * Resolves all {@link IDeployAttributeValue} statuses on the unit and its contained objects
	 * (recursive).
	 * 
	 * @param valueStatusList
	 *           List<IDeployAttributeValue>
	 * @param monitor
	 *           an optional progress monitor (may be null).
	 * @return the resolution status.
	 */
	public IStatus resolve(List valueStatusList, IProgressMonitor monitor) {
		// Find duplicate values
		Set attributeSet = new HashSet();
		Set duplicateAttributeSet = new HashSet();
		for (Iterator iter = valueStatusList.iterator(); iter.hasNext();) {
			IDeployAttributeValueStatus valueStatus = (IDeployAttributeValueStatus) iter.next();
			String key = valueStatus.getDeployObject().getFullPath() + '.'
					+ valueStatus.getAttributeName();
			if (attributeSet.contains(key)) {
				duplicateAttributeSet.add(key);
			} else {
				attributeSet.add(key);
			}
		}

		// Remove and read only duplicate values
		if (duplicateAttributeSet.size() > 0) {
			for (Iterator iter = valueStatusList.iterator(); iter.hasNext();) {
				IDeployAttributeValueStatus valueStatus = (IDeployAttributeValueStatus) iter.next();
				String key = valueStatus.getDeployObject().getFullPath() + '.'
						+ valueStatus.getAttributeName();
				if (duplicateAttributeSet.contains(key)) {
					iter.remove();
				} else if (!ResolutionUtils.isSettable(valueStatus)) {
					iter.remove();
				}
			}
		}

		if (valueStatusList.size() == 0) {
			return Status.CANCEL_STATUS;
		}

		monitor.beginTask(DeployCoreMessages.Resolution_set_all_attribute_values_in_unit,
				valueStatusList.size());
		for (Iterator iter = valueStatusList.iterator(); iter.hasNext();) {
			IDeployAttributeValueStatus valueStatus = (IDeployAttributeValueStatus) iter.next();
			DeployModelObject object = valueStatus.getDeployObject();
			Object value = valueStatus.getAttributeExpectedValue();

			if (valueStatus.getAttributeType() != null) {
				object.eSet(valueStatus.getAttributeType(), value);
			} else {
				ExtendedAttribute attr = object.getExtendedAttribute(valueStatus.getAttributeName());
				if (attr != null) {
					attr.setValue(value);
				}
			}
			monitor.worked(1);
		}

		monitor.done();
		return Status.OK_STATUS;
	}

	/**
	 * Duplicate all objects in a topology
	 * 
	 * @param top
	 *           the topology to be duplicated.
	 * @return a copy of the topology.
	 */
	public static Topology duplicate(Topology top) {
		Topology copy = CoreFactory.eINSTANCE.createTopology();
		copy.setName(top.getName());
		copy.setDisplayName(top.getDisplayName());
		ArrayList unitList = new ArrayList();
		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
			unitList.add(iter.next());
		}
		Collection unitCopies = ResolutionUtils.intelligentDeepCopy(unitList, copy);
		for (Iterator iter = unitCopies.iterator(); iter.hasNext();) {
			Object unitCopy = iter.next();
			if (unitCopy instanceof Import) {
				copy.getImports().add(unitCopy);
			} else if (unitCopy instanceof Unit) {
				copy.getUnits().add(unitCopy);
			}
		}
		return copy;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SetAllAttributesInUnitResolution)) {
			return false;
		}

		if (getDeployStatus().getDeployObject().getTopology() == null) {
			return false;
		}
		return getDeployStatus().getDeployObject().getTopology().equals(
				((SetAllAttributesInUnitResolution) obj).getDeployStatus().getDeployObject()
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
