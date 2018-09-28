/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.wps.BusinessRulesManager;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Rules Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerImpl#getBusinessRulesManager <em>Business Rules Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessRulesManagerImpl extends CapabilityImpl implements BusinessRulesManager {
	/**
	 * The default value of the '{@link #getBusinessRulesManager() <em>Business Rules Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessRulesManager()
	 * @generated
	 * @ordered
	 */
	protected static final String BUSINESS_RULES_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusinessRulesManager() <em>Business Rules Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessRulesManager()
	 * @generated
	 * @ordered
	 */
	protected String businessRulesManager = BUSINESS_RULES_MANAGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessRulesManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.BUSINESS_RULES_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBusinessRulesManager() {
		return businessRulesManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessRulesManager(String newBusinessRulesManager) {
		String oldBusinessRulesManager = businessRulesManager;
		businessRulesManager = newBusinessRulesManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER, oldBusinessRulesManager, businessRulesManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER:
				return getBusinessRulesManager();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WpsPackage.BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER:
				setBusinessRulesManager((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WpsPackage.BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER:
				setBusinessRulesManager(BUSINESS_RULES_MANAGER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WpsPackage.BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER:
				return BUSINESS_RULES_MANAGER_EDEFAULT == null ? businessRulesManager != null : !BUSINESS_RULES_MANAGER_EDEFAULT.equals(businessRulesManager);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (businessRulesManager: "); //$NON-NLS-1$
		result.append(businessRulesManager);
		result.append(')');
		return result.toString();
	}

} //BusinessRulesManagerImpl
