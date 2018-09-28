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

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>J2EE Resource Environment Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class J2EEResourceEnvironmentRequirementImpl extends CapabilityImpl implements
		J2EEResourceEnvironmentRequirement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected J2EEResourceEnvironmentRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME, oldJndiName, jndiName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME:
			return getJndiName();
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE:
			return getType();
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
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME:
			setJndiName((String) newValue);
			return;
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE:
			setType((String) newValue);
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
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME:
			setJndiName(JNDI_NAME_EDEFAULT);
			return;
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE:
			setType(TYPE_EDEFAULT);
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
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME:
			return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT
					.equals(jndiName);
		case J2eePackage.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //J2EEResourceEnvironmentRequirementImpl
