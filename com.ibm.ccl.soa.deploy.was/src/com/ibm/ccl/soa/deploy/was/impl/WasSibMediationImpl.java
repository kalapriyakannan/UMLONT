/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibMediation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sib Mediation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibMediationImpl#getHandlerListName <em>Handler List Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibMediationImpl#getMediationName <em>Mediation Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSibMediationImpl extends CapabilityImpl implements WasSibMediation {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getHandlerListName() <em>Handler List Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHandlerListName()
	 * @generated
	 * @ordered
	 */
	protected static final String HANDLER_LIST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHandlerListName() <em>Handler List Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHandlerListName()
	 * @generated
	 * @ordered
	 */
	protected String handlerListName = HANDLER_LIST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMediationName() <em>Mediation Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMediationName()
	 * @generated
	 * @ordered
	 */
	protected static final String MEDIATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMediationName() <em>Mediation Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMediationName()
	 * @generated
	 * @ordered
	 */
	protected String mediationName = MEDIATION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSibMediationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SIB_MEDIATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHandlerListName() {
		return handlerListName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandlerListName(String newHandlerListName) {
		String oldHandlerListName = handlerListName;
		handlerListName = newHandlerListName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_MEDIATION__HANDLER_LIST_NAME, oldHandlerListName, handlerListName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMediationName() {
		return mediationName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediationName(String newMediationName) {
		String oldMediationName = mediationName;
		mediationName = newMediationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_MEDIATION__MEDIATION_NAME, oldMediationName, mediationName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SIB_MEDIATION__HANDLER_LIST_NAME:
				return getHandlerListName();
			case WasPackage.WAS_SIB_MEDIATION__MEDIATION_NAME:
				return getMediationName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SIB_MEDIATION__HANDLER_LIST_NAME:
				setHandlerListName((String)newValue);
				return;
			case WasPackage.WAS_SIB_MEDIATION__MEDIATION_NAME:
				setMediationName((String)newValue);
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
			case WasPackage.WAS_SIB_MEDIATION__HANDLER_LIST_NAME:
				setHandlerListName(HANDLER_LIST_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_MEDIATION__MEDIATION_NAME:
				setMediationName(MEDIATION_NAME_EDEFAULT);
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
			case WasPackage.WAS_SIB_MEDIATION__HANDLER_LIST_NAME:
				return HANDLER_LIST_NAME_EDEFAULT == null ? handlerListName != null : !HANDLER_LIST_NAME_EDEFAULT.equals(handlerListName);
			case WasPackage.WAS_SIB_MEDIATION__MEDIATION_NAME:
				return MEDIATION_NAME_EDEFAULT == null ? mediationName != null : !MEDIATION_NAME_EDEFAULT.equals(mediationName);
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
		result.append(" (handlerListName: "); //$NON-NLS-1$
		result.append(handlerListName);
		result.append(", mediationName: "); //$NON-NLS-1$
		result.append(mediationName);
		result.append(')');
		return result.toString();
	}

} //WasSibMediationImpl
