/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl#getInterfaceGroup <em>Interface Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends RequirementImpl implements Reference {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInterfaceGroup() <em>Interface Group</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInterfaceGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap interfaceGroup;

	/**
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final String RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected String range = RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getInterfaceGroup() {
		if (interfaceGroup == null) {
			interfaceGroup = new BasicFeatureMap(this, CorePackage.REFERENCE__INTERFACE_GROUP);
		}
		return interfaceGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface() {
		return (Interface)getInterfaceGroup().get(CorePackage.Literals.REFERENCE__INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getInterfaceGroup()).basicAdd(CorePackage.Literals.REFERENCE__INTERFACE, newInterface, msgs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Reference#setInterface(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public void setInterface(Interface newInterface) {
		EStructuralFeature subfeature = FeatureAdapter.getFeature(newInterface,
				CorePackage.Literals.REFERENCE__INTERFACE);
		Assert.isNotNull(subfeature);
		((FeatureMap.Internal) getInterfaceGroup()).set(subfeature, newInterface);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceGen(Interface newInterface) {
		((FeatureMap.Internal)getInterfaceGroup()).set(CorePackage.Literals.REFERENCE__INTERFACE, newInterface);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(String newRange) {
		String oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REFERENCE__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.REFERENCE__INTERFACE_GROUP:
				return ((InternalEList)getInterfaceGroup()).basicRemove(otherEnd, msgs);
			case CorePackage.REFERENCE__INTERFACE:
				return basicSetInterface(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.REFERENCE__INTERFACE_GROUP:
				if (coreType) return getInterfaceGroup();
				return ((FeatureMap.Internal)getInterfaceGroup()).getWrapper();
			case CorePackage.REFERENCE__INTERFACE:
				return getInterface();
			case CorePackage.REFERENCE__RANGE:
				return getRange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.REFERENCE__INTERFACE_GROUP:
				((FeatureMap.Internal)getInterfaceGroup()).set(newValue);
				return;
			case CorePackage.REFERENCE__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case CorePackage.REFERENCE__RANGE:
				setRange((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.REFERENCE__INTERFACE_GROUP:
				getInterfaceGroup().clear();
				return;
			case CorePackage.REFERENCE__INTERFACE:
				setInterface((Interface)null);
				return;
			case CorePackage.REFERENCE__RANGE:
				setRange(RANGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.REFERENCE__INTERFACE_GROUP:
				return interfaceGroup != null && !interfaceGroup.isEmpty();
			case CorePackage.REFERENCE__INTERFACE:
				return getInterface() != null;
			case CorePackage.REFERENCE__RANGE:
				return RANGE_EDEFAULT == null ? range != null : !RANGE_EDEFAULT.equals(range);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (interfaceGroup: "); //$NON-NLS-1$
		result.append(interfaceGroup);
		result.append(", range: "); //$NON-NLS-1$
		result.append(range);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
