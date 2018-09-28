/**
 * <copyright>
 * </copyright>
 *
 * $Id: SoftwarePatchImpl.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Patch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwarePatchImpl#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwarePatchImpl#getPatchID <em>Patch ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwarePatchImpl extends CapabilityImpl implements SoftwarePatch {
	/**
	 * The default value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected String installDate = INSTALL_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPatchID() <em>Patch ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatchID()
	 * @generated
	 * @ordered
	 */
	protected static final String PATCH_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatchID() <em>Patch ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatchID()
	 * @generated
	 * @ordered
	 */
	protected String patchID = PATCH_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwarePatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenericsoftwarePackage.Literals.SOFTWARE_PATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallDate() {
		return installDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallDate(String newInstallDate) {
		String oldInstallDate = installDate;
		installDate = newInstallDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_PATCH__INSTALL_DATE, oldInstallDate, installDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatchID() {
		return patchID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatchID(String newPatchID) {
		String oldPatchID = patchID;
		patchID = newPatchID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_PATCH__PATCH_ID, oldPatchID, patchID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericsoftwarePackage.SOFTWARE_PATCH__INSTALL_DATE:
				return getInstallDate();
			case GenericsoftwarePackage.SOFTWARE_PATCH__PATCH_ID:
				return getPatchID();
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
			case GenericsoftwarePackage.SOFTWARE_PATCH__INSTALL_DATE:
				setInstallDate((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_PATCH__PATCH_ID:
				setPatchID((String)newValue);
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
			case GenericsoftwarePackage.SOFTWARE_PATCH__INSTALL_DATE:
				setInstallDate(INSTALL_DATE_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_PATCH__PATCH_ID:
				setPatchID(PATCH_ID_EDEFAULT);
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
			case GenericsoftwarePackage.SOFTWARE_PATCH__INSTALL_DATE:
				return INSTALL_DATE_EDEFAULT == null ? installDate != null : !INSTALL_DATE_EDEFAULT.equals(installDate);
			case GenericsoftwarePackage.SOFTWARE_PATCH__PATCH_ID:
				return PATCH_ID_EDEFAULT == null ? patchID != null : !PATCH_ID_EDEFAULT.equals(patchID);
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
		result.append(" (installDate: "); //$NON-NLS-1$
		result.append(installDate);
		result.append(", patchID: "); //$NON-NLS-1$
		result.append(patchID);
		result.append(')');
		return result.toString();
	}

} //SoftwarePatchImpl
