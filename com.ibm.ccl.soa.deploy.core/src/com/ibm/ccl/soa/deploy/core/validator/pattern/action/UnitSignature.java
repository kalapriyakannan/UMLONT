/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Class containing signatures which are composed wholly of units.
 */
public class UnitSignature implements ISignature {

	protected EClass[] _signature;

	/**
	 * Constructor.
	 * 
	 * @param signature
	 *           list of EClass defining interface
	 */
	public UnitSignature(List<EClass> signature) {
		assert null != signature;
		assert 0 < signature.size();
		_signature = new EClass[signature.size()];
		for (int i = 0; i < signature.size(); i++) {
			EClass type = signature.get(i);
			assert CorePackage.Literals.UNIT.isSuperTypeOf(type);
			_signature[i] = type;
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param signature
	 *           array of EClass defining interface
	 */
	public UnitSignature(EClass[] signature) {
		assert null != signature;
		assert 0 < signature.length;
		_signature = new EClass[signature.length];
		for (int i = 0; i < signature.length; i++) {
			EClass type = signature[i];
			assert CorePackage.Literals.UNIT.isSuperTypeOf(type);
			_signature[i] = type;
		}
	}

	public boolean isValidInstance(List<DeployModelObject> parameters) {
		for (int i = 0; i < parameters.size(); i++) {
			EClass paramType = parameters.get(i).getEObject().eClass();
			if (!this._signature[i].isSuperTypeOf(paramType)) {
				return false;
			}
		}
		return true;
	}

	public int getNumberParameters() {
		return _signature.length;
	}

	public EClass get(int index) {
		if ((index < 0) || (index > (_signature.length - 1))) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return _signature[index];
	}
}
