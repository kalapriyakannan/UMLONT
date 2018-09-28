/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageCollectionImpl.java,v 1.1 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;

import com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Image Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionImpl#getCollectionId <em>Collection Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualImageCollectionImpl extends CapabilityImpl implements VirtualImageCollection {
	/**
	 * The default value of the '{@link #getCollectionId() <em>Collection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionId()
	 * @generated
	 * @ordered
	 */
	protected static final String COLLECTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollectionId() <em>Collection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionId()
	 * @generated
	 * @ordered
	 */
	protected String collectionId = COLLECTION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VIRTUAL_IMAGE_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCollectionId() {
		return collectionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionId(String newCollectionId) {
		String oldCollectionId = collectionId;
		collectionId = newCollectionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID, oldCollectionId, collectionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID:
				return getCollectionId();
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
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID:
				setCollectionId((String)newValue);
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
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID:
				setCollectionId(COLLECTION_ID_EDEFAULT);
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
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID:
				return COLLECTION_ID_EDEFAULT == null ? collectionId != null : !COLLECTION_ID_EDEFAULT.equals(collectionId);
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
		result.append(" (collectionId: "); //$NON-NLS-1$
		result.append(collectionId);
		result.append(')');
		return result.toString();
	}

} //VirtualImageCollectionImpl
