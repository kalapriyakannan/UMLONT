/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>URL Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.URLInterfaceImpl#getParamName <em>Param Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLInterfaceImpl extends InterfaceImpl implements URLInterface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getParamName() <em>Param Name</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParamName()
	 * @generated
	 * @ordered
	 */
	protected EList paramName;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected URLInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.URL_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParamName() {
		if (paramName == null) {
			paramName = new EDataTypeEList(String.class, this, J2eePackage.URL_INTERFACE__PARAM_NAME);
		}
		return paramName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.URL_INTERFACE__PARAM_NAME:
			return getParamName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case J2eePackage.URL_INTERFACE__PARAM_NAME:
			getParamName().clear();
			getParamName().addAll((Collection) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case J2eePackage.URL_INTERFACE__PARAM_NAME:
			getParamName().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case J2eePackage.URL_INTERFACE__PARAM_NAME:
			return paramName != null && !paramName.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (paramName: "); //$NON-NLS-1$
		result.append(paramName);
		result.append(')');
		return result.toString();
	}

	public String getDisplayString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer();
		result.append("paramNames"); //$NON-NLS-1$
		result.append(paramName);
		return result.toString();
	}

	public boolean isFastEquivalencyCheck(Interface anotherInterface) {
		if (anotherInterface != null && anotherInterface instanceof URLInterface) {
			List params = getParamName();
			List otherParams = ((URLInterface) anotherInterface).getParamName();
			if (params.size() != otherParams.size()) {
				return false;
			}
			Iterator it1 = params.iterator();
			Iterator it2 = otherParams.iterator();
			while (it1.hasNext()) {
				String paramName1 = (String) it1.next();
				String paramName2 = (String) it2.next();
				if (!paramName1.equals(paramName2)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

} //URLInterfaceImpl
