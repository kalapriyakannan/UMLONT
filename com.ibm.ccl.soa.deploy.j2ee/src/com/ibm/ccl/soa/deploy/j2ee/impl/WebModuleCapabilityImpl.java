/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web Module Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleCapabilityImpl#getContextRoot <em>Context Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebModuleCapabilityImpl extends J2EEModuleCapabilityImpl implements
		WebModuleCapability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getContextRoot() <em>Context Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContextRoot()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_ROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContextRoot() <em>Context Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContextRoot()
	 * @generated
	 * @ordered
	 */
	protected String contextRoot = CONTEXT_ROOT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WebModuleCapabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.WEB_MODULE_CAPABILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextRoot() {
		return contextRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextRoot(String newContextRoot) {
		String oldContextRoot = contextRoot;
		contextRoot = newContextRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.WEB_MODULE_CAPABILITY__CONTEXT_ROOT, oldContextRoot, contextRoot));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.WEB_MODULE_CAPABILITY__CONTEXT_ROOT:
			return getContextRoot();
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
		case J2eePackage.WEB_MODULE_CAPABILITY__CONTEXT_ROOT:
			setContextRoot((String) newValue);
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
		case J2eePackage.WEB_MODULE_CAPABILITY__CONTEXT_ROOT:
			setContextRoot(CONTEXT_ROOT_EDEFAULT);
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
		case J2eePackage.WEB_MODULE_CAPABILITY__CONTEXT_ROOT:
			return CONTEXT_ROOT_EDEFAULT == null ? contextRoot != null : !CONTEXT_ROOT_EDEFAULT
					.equals(contextRoot);
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
		result.append(" (contextRoot: "); //$NON-NLS-1$
		result.append(contextRoot);
		result.append(')');
		return result.toString();
	}

} //WebModuleCapabilityImpl
