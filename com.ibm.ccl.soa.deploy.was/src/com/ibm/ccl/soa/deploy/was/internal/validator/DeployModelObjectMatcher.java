/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * Comparator class for DeployModelObjects used by WAS validators.
 */
public class DeployModelObjectMatcher {

	private final DeployModelObject _dmo;
	private final EAttribute[] _attributes;

	private boolean _match = false;
	private boolean _matchTested = false;
	private boolean _compatible = false;
	private boolean _compatibleTested = false;
	private boolean _compatibleWithValue = false;
	private final boolean _compatibleWithValueTested = false;
	private boolean _failure = false;
	private final List<CompareResult[]> _results = new ArrayList<CompareResult[]>();

	/**
	 * Constructor
	 * 
	 * @param dmo
	 *           the (target) object to be compared
	 * @param attributes
	 *           the attributes that should be compared
	 */
	public DeployModelObjectMatcher(DeployModelObject dmo, EAttribute[] attributes) {
		_dmo = dmo;
		_attributes = attributes;
		clear();
	}

	/**
	 * Get the object that the comparisons were made against
	 * 
	 * @return the object
	 */
	public DeployModelObject getDmo() {
		return _dmo;
	}

	private void clear() {
		_matchTested = false;
		_compatibleTested = false;
		_failure = false;

		_results.clear();
	}

	/**
	 * Compare a list of bjects against the one defined by the constructor
	 * 
	 * @param candidates
	 *           list of objects
	 * @param attributes
	 *           attributes in objects
	 */
	public void compare(Set<DeployModelObject> candidates, EAttribute[] attributes) {
		clear();

		if (null == candidates || 0 == candidates.size() || null == attributes
				|| attributes.length != _attributes.length) {
			_failure = true;
			return;
		}

		for (DeployModelObject candidate : candidates) {
			_results.add(compare(candidate, attributes));
		}
	}

	private CompareResult[] compare(DeployModelObject candidate, EAttribute[] attributes) {
		if (null == candidate || null == attributes || attributes.length != _attributes.length) {
			_failure = true;
			return null;
		}

		CompareResult[] r = new CompareResult[attributes.length];
		for (int i = 0; i < attributes.length; i++) {
			r[i] = compare(_attributes[i], candidate, attributes[i]);
		}

		return r;
	}

	/**
	 * Determine if the results of the comparison indicate a match between objects.
	 * 
	 * @return true if a match exists
	 */
	public boolean hasExactMatch() {
		if (_failure) {
			return false;
		}

		if (_matchTested) {
			return _match;
		}

		_match = false;
		for (CompareResult[] result : _results) {
			for (int i = 0; i < result.length; i++) {
				if (result[i].isMatch()) {
					_match = true;
					break;
				}
			}
			if (_match) {
				break;
			}
		}
		_matchTested = true;
		return _match;
	}

	/**
	 * Determine if the results of the comparison indicate compatibility between the objects (except
	 * for settable attribute values)
	 * 
	 * @return true if compatible
	 */
	public boolean hasCompatibleMatch() {
		if (_failure) {
			return false;
		}

		if (_compatibleTested) {
			return _compatible;
		}

		_compatible = false;
		for (CompareResult[] result : _results) {
			if (isCompatible(result)) {
				_compatible = true;
				break;
			}
		}
		return _compatible;
	}

	/**
	 * Determine if the reults of the comparison indicate compatibility between objects and values
	 * are known that will make them match
	 * 
	 * @return true if compatible and values known
	 */
	public boolean hasCompatibleMatchWithValue() {
		if (_failure) {
			return false;
		}

		if (_compatibleWithValueTested) {
			return _compatibleWithValue;
		}

		_compatibleWithValue = false;
		for (CompareResult[] result : _results) {
			boolean currentCompatible = true;
			boolean currentHasValue = false;
			for (int i = 0; i < result.length; i++) {
				if (!result[i].isCompatible()) {
					currentCompatible = false;
					break;
				}
				if (null != result[i].getValue()) {
					currentHasValue = true;
				}
			}
			if (currentCompatible && currentHasValue) {
				_compatibleWithValue = true;
				break;
			}
		}
		return _compatibleWithValue;
	}

	/**
	 * Return values that could be assigned to {@link #getDmo()} to make it match.
	 * 
	 * @return map of values to assign
	 */
	public Map<EAttribute, Set<Object>> getValueOptions() {
		if (_failure) {
			return Collections.emptyMap();
		}

		Map<EAttribute, Set<Object>> resultMap = new HashMap<EAttribute, Set<Object>>();

		for (CompareResult[] result : _results) {
			if (!isCompatible(result)) {
				continue;
			}
			for (int i = 0; i < result.length; i++) {
				Object value = result[i].getValue();
				if (null == value) {
					continue;
				}
				EAttribute attribute = result[i].getTargetAttribute();
				Set<Object> entrySet = resultMap.get(attribute);
				if (null == entrySet) {
					entrySet = new HashSet<Object>();
					resultMap.put(attribute, entrySet);
				}
				entrySet.add(value);
			}
		}
		return resultMap;
	}

	private boolean isCompatible(CompareResult[] result) {
		boolean compatible = true;
		for (int i = 0; i < result.length; i++) {
			if (!result[i].isCompatible()) {
				compatible = false;
				break;
			}
		}

		return compatible;
	}

	private CompareResult compare(EAttribute targetAttr, DeployModelObject sourceObj,
			EAttribute sourceAttr) {
		// targetDmo is this._dmo

		boolean isTargetSet = _dmo.getEObject().eIsSet(targetAttr);
		boolean isTargetSettable = DeployModelObjectUtil.isSettable(_dmo, targetAttr);
		boolean isSourceSet = sourceObj.getEObject().eIsSet(sourceAttr);
		Object targetValue = DeployModelObjectUtil.getAttributeValue(_dmo, targetAttr);
		Object sourceValue = DeployModelObjectUtil.getAttributeValue(sourceObj, sourceAttr);

		if (!isTargetSet && !isTargetSettable) {
			return new CompareResult(CompareResult.INCOMPATIBLE, targetAttr);
		}

		if (!isTargetSet && isTargetSettable && isSourceSet) {
			return new CompareResult(targetAttr, DeployModelObjectUtil.getAttributeValue(sourceObj,
					sourceAttr));
		}

		if (!isSourceSet) {
			// is compatible but can't propagate
			return new CompareResult(CompareResult.COMPATIBLE, targetAttr);
		}

		// isTargetSet && isSourceSet
//		Object targetValue = DeployModelObjectUtil.getAttributeValue(_dmo, targetAttr);
//		Object sourceValue = DeployModelObjectUtil.getAttributeValue(sourceObj, sourceAttr);

		if (isSourceSet && targetValue.equals(sourceValue)) {
			return new CompareResult(CompareResult.MATCH, targetAttr);
		}

		// target set but not equal to source
		if (isTargetSettable) {
			return new CompareResult(targetAttr, sourceValue);
		}

		return new CompareResult(CompareResult.INCOMPATIBLE, targetAttr);
	}

	private class CompareResult {

		/** Indicator that all attriubtes match exactly */
		public final static String MATCH = "MATCH"; //$NON-NLS-1$
		/**
		 * Indicator that the tested attribute can match if at least one is changed (the target or the
		 * source). Further, one of them can be changed (cf.
		 * {@link DeployModelObjectUtil#isSettable(DeployModelObject, EAttribute)}). However, it does
		 * mean that we know what value the target attribute should be set to. Use
		 * {@link CompareResult#getValue()} to determine a value is known.
		 */
		public final static String COMPATIBLE = "COMPATIBLE"; //$NON-NLS-1$
		/** Indicator that at least one attribute does not match and there is no way to make them match */
		public final static String INCOMPATIBLE = "INCOMPATIBLE"; //$NON-NLS-1$

		private final boolean _match;
		private final boolean _incompatible;
		private final Object _value;
		private final EAttribute _targetAttribute;

		/**
		 * Constructor
		 * 
		 * @param status
		 *           what the result should show
		 * @param targetAttribute
		 *           the target attribute
		 */
		public CompareResult(String status, EAttribute targetAttribute) {
			if (MATCH.equals(status)) {
				_match = true;
				_incompatible = false;
				_value = null;
			} else if (INCOMPATIBLE.equals(status)) {
				_match = false;
				_incompatible = true;
				_value = null;
			} else if (COMPATIBLE.equals(status)) {
				_match = false;
				_incompatible = false;
				_value = null;
			} else {
				throw new IllegalArgumentException();
			}
			_targetAttribute = targetAttribute;
		}

		/**
		 * Consructor for COMPATIBLE match where value is known.
		 * 
		 * @param targetAttribute
		 * @param value
		 */
		public CompareResult(EAttribute targetAttribute, Object value) {
			_match = false;
			_incompatible = false;
			_value = value;
			_targetAttribute = targetAttribute;
		}

		/**
		 * Determine if the result indicates a perfect match (the tested attribute matches) or not
		 * 
		 * @return true if match is perfect; false otherwise
		 */
		public boolean isMatch() {
			return _match;
		}

		/**
		 * Determine whether or not the result indicates that a match is possible (though it isn't one
		 * yet)
		 * 
		 * @return true if match is compatible; false otherwise
		 */
		public boolean isCompatible() {
			return !_incompatible;
		}

		/**
		 * Get the value that, if assigned to the target attribute, will make the match perfect.
		 * 
		 * @return the value
		 */
		public Object getValue() {
			return _value;
		}

		/**
		 * Get the attribute targeted by the compare result
		 * 
		 * @return attribute
		 */
		public EAttribute getTargetAttribute() {
			return _targetAttribute;
		}
	}
}