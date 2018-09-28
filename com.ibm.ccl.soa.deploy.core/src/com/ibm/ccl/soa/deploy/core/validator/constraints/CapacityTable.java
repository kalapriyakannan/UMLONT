package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeCapacityStatus;

public class CapacityTable {

	private final Map<DeployModelObject, Collection<EAttribute>> keys = new HashMap<DeployModelObject, Collection<EAttribute>>();
	private final Map<String, Number> exclusive = new HashMap<String, Number>();
	private final Map<String, Number> shared = new HashMap<String, Number>();

	private final Set<DeployAttributeCapacityStatus> observed = new HashSet<DeployAttributeCapacityStatus>();

	public void add(DeployModelObject deployObject, DeployAttributeCapacityStatus restriction) {
		if (!observed.contains(restriction) && isValid(restriction.getRestriction())) {
			double current = get(deployObject, restriction.getAttributeType(), restriction
					.isExclusive());

			ConvertedValue convertedValue = ConvertedValue.parse(restriction.getRestriction()
					.getValue(), restriction.getAttributeDataType());
			double newValue = convertedValue != null ? convertedValue.deconvert().doubleValue() : 0.0;

			if (restriction.isExclusive()) {
				put(deployObject, restriction.getAttributeType(), restriction.isExclusive(), current
						+ newValue);
			} else if (current < newValue) {
				put(deployObject, restriction.getAttributeType(), restriction.isExclusive(), newValue);
			}

			observed.add(restriction);
		}
	}

	private boolean isValid(Constraint c) {
		return c != null && !c.eIsProxy() && c.getTopology() != null;
	}

	public double total(DeployModelObject dmo, EAttribute attribute) {
		return get(dmo, attribute, true) + get(dmo, attribute, false);
	}

	public Collection<DeployModelObject> keys() {
		return keys.keySet();
	}

	/**
	 * Return the collection of observed attributes for the given {@link DeployModelObject}.
	 * 
	 * @param dmo
	 * @return The collection of observed attributes for the given {@link DeployModelObject}.
	 */
	public Collection<EAttribute> attributes(DeployModelObject dmo) {
		Collection<EAttribute> attrs = keys.get(dmo);
		if (attrs != null) {
			return attrs;
		}
		return Collections.emptySet();
	}

	/**
	 * Return the set of observed statuses; an observed status is one that has been added to the
	 * table via {{@link #add(DeployModelObject, DeployAttributeCapacityStatus)}.
	 * 
	 * @return The set of observed statuses; an observed status is one that has been added to the
	 *         table via {{@link #add(DeployModelObject, DeployAttributeCapacityStatus)}.
	 */
	public Collection<DeployAttributeCapacityStatus> getObserved() {
		return observed;
	}

	/**
	 * Return the set of observed statuses related to the given {@link EAttribute}; an observed
	 * status is one that has been added to the table via {
	 * {@link #add(DeployModelObject, DeployAttributeCapacityStatus)}.
	 * 
	 * @param attr
	 *           An attribute that has been observed
	 * 
	 * @return The set of observed statuses; an observed status is one that has been added to the
	 *         table via {{@link #add(DeployModelObject, DeployAttributeCapacityStatus)} or the empty
	 *         set.
	 */
	public Collection<DeployAttributeCapacityStatus> getObserved(EAttribute attr) {
		if (attr == null) {
			return Collections.emptyList();
		}
		Collection<DeployAttributeCapacityStatus> results = new ArrayList<DeployAttributeCapacityStatus>(
				3);
		for (DeployAttributeCapacityStatus cStatus : getObserved()) {
			if (attr.equals(cStatus.getAttributeType())) {
				results.add(cStatus);
			}
		}
		return results;
	}

	private void put(DeployModelObject dmo, EAttribute attribute, boolean isExclusive, double value) {
		String key = generateKey(dmo, attribute);
		if (isExclusive) {
			exclusive.put(key, value);
		} else {

			shared.put(key, value);
		}
	}

	private String generateKey(DeployModelObject dmo, EAttribute attribute) {
		Collection<EAttribute> attributes = keys.get(dmo);
		if (attributes == null) {
			keys.put(dmo, attributes = new HashSet<EAttribute>());
		}
		attributes.add(attribute);
		return dmo.getFullPath() + IConstants.ATTRIBUTE_SEPARATOR + attribute.getName();
	}

	private double get(DeployModelObject dmo, EAttribute attribute, boolean isExclusive) {

		String key = generateKey(dmo, attribute);
		Number result = null;
		if (isExclusive) {
			result = exclusive.get(key);
		} else {
			result = shared.get(key);
		}

		return result != null ? result.doubleValue() : 0.0;
	}

}
