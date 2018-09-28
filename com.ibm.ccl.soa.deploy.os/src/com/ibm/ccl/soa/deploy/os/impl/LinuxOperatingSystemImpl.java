/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemImpl#getKernelRelease <em>Kernel Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinuxOperatingSystemImpl extends OperatingSystemImpl implements LinuxOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getKernelRelease() <em>Kernel Release</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getKernelRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String KERNEL_RELEASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKernelRelease() <em>Kernel Release</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getKernelRelease()
	 * @generated
	 * @ordered
	 */
	protected String kernelRelease = KERNEL_RELEASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinuxOperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.LINUX_OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getKernelRelease() {
		return kernelRelease;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setKernelRelease(String newKernelRelease) {
		String oldKernelRelease = kernelRelease;
		kernelRelease = newKernelRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_OPERATING_SYSTEM__KERNEL_RELEASE, oldKernelRelease, kernelRelease));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.LINUX_OPERATING_SYSTEM__KERNEL_RELEASE:
			return getKernelRelease();
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
		case OsPackage.LINUX_OPERATING_SYSTEM__KERNEL_RELEASE:
			setKernelRelease((String) newValue);
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
		case OsPackage.LINUX_OPERATING_SYSTEM__KERNEL_RELEASE:
			setKernelRelease(KERNEL_RELEASE_EDEFAULT);
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
		case OsPackage.LINUX_OPERATING_SYSTEM__KERNEL_RELEASE:
			return KERNEL_RELEASE_EDEFAULT == null ? kernelRelease != null : !KERNEL_RELEASE_EDEFAULT
					.equals(kernelRelease);
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
		result.append(" (kernelRelease: "); //$NON-NLS-1$
		result.append(kernelRelease);
		result.append(')');
		return result.toString();
	}

} //LinuxOperatingSystemImpl
