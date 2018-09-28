/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualImageSnapshotContainerImpl.java,v 1.1 2008/04/28 19:50:59 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Image Snapshot Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl#getCurrentSnapshotUid <em>Current Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl#getLastSnapshotUid <em>Last Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl#getNumSnapshots <em>Num Snapshots</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualImageSnapshotContainerImpl extends VirtualImageSnapshotContainerImpl implements VMwareVirtualImageSnapshotContainer {
	/**
	 * The default value of the '{@link #getCurrentSnapshotUid() <em>Current Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_SNAPSHOT_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentSnapshotUid() <em>Current Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected String currentSnapshotUid = CURRENT_SNAPSHOT_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSnapshotUid() <em>Last Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_SNAPSHOT_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastSnapshotUid() <em>Last Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected String lastSnapshotUid = LAST_SNAPSHOT_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumSnapshots() <em>Num Snapshots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumSnapshots()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_SNAPSHOTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumSnapshots() <em>Num Snapshots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumSnapshots()
	 * @generated
	 * @ordered
	 */
	protected int numSnapshots = NUM_SNAPSHOTS_EDEFAULT;

	/**
	 * This is true if the Num Snapshots attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numSnapshotsESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualImageSnapshotContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentSnapshotUid() {
		return currentSnapshotUid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentSnapshotUid(String newCurrentSnapshotUid) {
		String oldCurrentSnapshotUid = currentSnapshotUid;
		currentSnapshotUid = newCurrentSnapshotUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID, oldCurrentSnapshotUid, currentSnapshotUid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSnapshotUid() {
		return lastSnapshotUid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSnapshotUid(String newLastSnapshotUid) {
		String oldLastSnapshotUid = lastSnapshotUid;
		lastSnapshotUid = newLastSnapshotUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID, oldLastSnapshotUid, lastSnapshotUid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumSnapshots() {
		return numSnapshots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumSnapshots(int newNumSnapshots) {
		int oldNumSnapshots = numSnapshots;
		numSnapshots = newNumSnapshots;
		boolean oldNumSnapshotsESet = numSnapshotsESet;
		numSnapshotsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS, oldNumSnapshots, numSnapshots, !oldNumSnapshotsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumSnapshots() {
		int oldNumSnapshots = numSnapshots;
		boolean oldNumSnapshotsESet = numSnapshotsESet;
		numSnapshots = NUM_SNAPSHOTS_EDEFAULT;
		numSnapshotsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS, oldNumSnapshots, NUM_SNAPSHOTS_EDEFAULT, oldNumSnapshotsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumSnapshots() {
		return numSnapshotsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID:
				return getCurrentSnapshotUid();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID:
				return getLastSnapshotUid();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS:
				return new Integer(getNumSnapshots());
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID:
				setCurrentSnapshotUid((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID:
				setLastSnapshotUid((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS:
				setNumSnapshots(((Integer)newValue).intValue());
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID:
				setCurrentSnapshotUid(CURRENT_SNAPSHOT_UID_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID:
				setLastSnapshotUid(LAST_SNAPSHOT_UID_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS:
				unsetNumSnapshots();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID:
				return CURRENT_SNAPSHOT_UID_EDEFAULT == null ? currentSnapshotUid != null : !CURRENT_SNAPSHOT_UID_EDEFAULT.equals(currentSnapshotUid);
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID:
				return LAST_SNAPSHOT_UID_EDEFAULT == null ? lastSnapshotUid != null : !LAST_SNAPSHOT_UID_EDEFAULT.equals(lastSnapshotUid);
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS:
				return isSetNumSnapshots();
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
		result.append(" (currentSnapshotUid: "); //$NON-NLS-1$
		result.append(currentSnapshotUid);
		result.append(", lastSnapshotUid: "); //$NON-NLS-1$
		result.append(lastSnapshotUid);
		result.append(", numSnapshots: "); //$NON-NLS-1$
		if (numSnapshotsESet) result.append(numSnapshots); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualImageSnapshotContainerImpl
