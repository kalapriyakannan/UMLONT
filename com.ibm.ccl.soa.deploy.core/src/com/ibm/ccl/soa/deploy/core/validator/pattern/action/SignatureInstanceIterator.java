/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.TypeObjectFilter;

/**
 * An iterator that returns lists of unit instances that match a given "signature" or interface; a
 * list of unit types.
 */
public class SignatureInstanceIterator implements Iterator {

	private ISignature _signature;
	private Topology _topology;

	private List<DeployModelObject>[] _unitLists;
	private int[] _unitListsPositions;
	private DeployModelObject[] _current;

	/**
	 * Constructor
	 * 
	 * @param signature
	 *           the list of unit types
	 * @param topology
	 *           the topology from which unit instances should be extracted
	 */
	public SignatureInstanceIterator(ISignature signature, Topology topology) {
		assert null != signature;
		assert 0 != signature.getNumberParameters();
		assert null != topology;
		for (int i = 0; i < signature.getNumberParameters(); i++) {
			assert null != signature.get(i);
			assert CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(signature.get(i));
		}

		_signature = signature;
		_topology = topology;
		_current = new Unit[_signature.getNumberParameters()];
		_unitLists = new List[_signature.getNumberParameters()];
		_unitListsPositions = new int[_signature.getNumberParameters()];
		for (int i = 0; i < _signature.getNumberParameters(); i++) {
			_unitLists[i] = new ArrayList<DeployModelObject>();
			_unitListsPositions[i] = 0;
			Iterator<DeployModelObject> unitIterator = getUnitIterator(_signature.get(i));
			while (unitIterator.hasNext()) {
				_unitLists[i].add(unitIterator.next());
			}

			if (_unitLists[i].size() > 0) {
				_current[i] = null;
			} else {
				_current = null;
				//jangan: Have to break the loop here. Otherwise there may be a NullPointerExeception in the next rount trying to set _current[i]
				break;
			}

		}
	}

	public boolean hasNext() {
		// there is another if any of the iterators has a next element
		if (_current == null) {
			return false;
		}

		for (int i = 0; i < _unitLists.length; i++) {
			if (_unitListsPositions[i] <= _unitLists[i].size())
				return true;
		}
		return false;
	}

	public List<DeployModelObject> next() {
		for (int i = _current.length; i > 0; i--) {
			if (_unitListsPositions[i - 1] < _unitLists[i - 1].size()) {
				_current[i - 1] = _unitLists[i - 1].get(_unitListsPositions[i - 1]);
				_unitListsPositions[i - 1] = ++_unitListsPositions[i - 1];
				for (int j = i; j < _current.length; j++) {
					_unitListsPositions[j] = 0;
					_current[j] = _unitLists[j].get(0);
					_unitListsPositions[j] = 1;
				}
				List<DeployModelObject> result = new ArrayList<DeployModelObject>(_current.length);
				for (int k = 0; k < _current.length; k++) {
					//avoiding that a unit combination contains the same instance twice
					if (result.contains(_current[k]))
						result.add(null);
					result.add(_current[k]);
				}
				return result;
				// return _current;
			}
		}
		_current = null;

		return new ArrayList<DeployModelObject>(0);
		// return _current;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	private Iterator<DeployModelObject> getUnitIterator(EClass type) {
		if (CorePackage.Literals.UNIT.isSuperTypeOf(type)) {
			return new FilterIterator(_topology.findAllUnits(), new TypeObjectFilter(type));
		} else {
			// TODO support other types
			return new ArrayList<DeployModelObject>(0).iterator();
		}
	}

}
