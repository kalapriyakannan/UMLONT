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
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Servlet Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.ServletContainerImpl#getContainerVersion <em>Container Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServletContainerImpl extends CapabilityImpl implements ServletContainer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getContainerVersion() <em>Container Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContainerVersion()
	 * @generated
	 * @ordered
	 */
	protected static final ServletContainerVersion CONTAINER_VERSION_EDEFAULT = ServletContainerVersion._22_LITERAL;

	/**
	 * The cached value of the '{@link #getContainerVersion() <em>Container Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContainerVersion()
	 * @generated
	 * @ordered
	 */
	protected ServletContainerVersion containerVersion = CONTAINER_VERSION_EDEFAULT;

	/**
	 * This is true if the Container Version attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean containerVersionESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ServletContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.SERVLET_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServletContainerVersion getContainerVersion() {
		return containerVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerVersion(ServletContainerVersion newContainerVersion) {
		ServletContainerVersion oldContainerVersion = containerVersion;
		containerVersion = newContainerVersion == null ? CONTAINER_VERSION_EDEFAULT
				: newContainerVersion;
		boolean oldContainerVersionESet = containerVersionESet;
		containerVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION, oldContainerVersion,
					containerVersion, !oldContainerVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainerVersion() {
		ServletContainerVersion oldContainerVersion = containerVersion;
		boolean oldContainerVersionESet = containerVersionESet;
		containerVersion = CONTAINER_VERSION_EDEFAULT;
		containerVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION, oldContainerVersion,
					CONTAINER_VERSION_EDEFAULT, oldContainerVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainerVersion() {
		return containerVersionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION:
			return getContainerVersion();
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
		case J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION:
			setContainerVersion((ServletContainerVersion) newValue);
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
		case J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION:
			unsetContainerVersion();
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
		case J2eePackage.SERVLET_CONTAINER__CONTAINER_VERSION:
			return isSetContainerVersion();
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
		result.append(" (containerVersion: "); //$NON-NLS-1$
		if (containerVersionESet)
			result.append(containerVersion);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ServletContainerImpl
