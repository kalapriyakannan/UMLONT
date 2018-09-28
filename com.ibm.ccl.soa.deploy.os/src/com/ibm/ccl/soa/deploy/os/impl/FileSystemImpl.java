/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: FileSystemImpl.java,v 1.1 2007/12/19 23:37:06 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.os.FileSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl#getAvailableSpace <em>Available Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileSystemImpl extends CapabilityImpl implements FileSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAvailableSpace() <em>Available Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableSpace()
	 * @generated
	 * @ordered
	 */
	protected static final long AVAILABLE_SPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getAvailableSpace() <em>Available Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableSpace()
	 * @generated
	 * @ordered
	 */
	protected long availableSpace = AVAILABLE_SPACE_EDEFAULT;

	/**
	 * This is true if the Available Space attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean availableSpaceESet;

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final long CAPACITY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected long capacity = CAPACITY_EDEFAULT;

	/**
	 * This is true if the Capacity attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean capacityESet;

	/**
	 * The default value of the '{@link #getMountPoint() <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String MOUNT_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMountPoint() <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountPoint()
	 * @generated
	 * @ordered
	 */
	protected String mountPoint = MOUNT_POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.FILE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getAvailableSpace() {
		return availableSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableSpace(long newAvailableSpace) {
		long oldAvailableSpace = availableSpace;
		availableSpace = newAvailableSpace;
		boolean oldAvailableSpaceESet = availableSpaceESet;
		availableSpaceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM__AVAILABLE_SPACE, oldAvailableSpace, availableSpace,
					!oldAvailableSpaceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAvailableSpace() {
		long oldAvailableSpace = availableSpace;
		boolean oldAvailableSpaceESet = availableSpaceESet;
		availableSpace = AVAILABLE_SPACE_EDEFAULT;
		availableSpaceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.FILE_SYSTEM__AVAILABLE_SPACE, oldAvailableSpace, AVAILABLE_SPACE_EDEFAULT,
					oldAvailableSpaceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAvailableSpace() {
		return availableSpaceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(long newCapacity) {
		long oldCapacity = capacity;
		capacity = newCapacity;
		boolean oldCapacityESet = capacityESet;
		capacityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.FILE_SYSTEM__CAPACITY,
					oldCapacity, capacity, !oldCapacityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCapacity() {
		long oldCapacity = capacity;
		boolean oldCapacityESet = capacityESet;
		capacity = CAPACITY_EDEFAULT;
		capacityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OsPackage.FILE_SYSTEM__CAPACITY,
					oldCapacity, CAPACITY_EDEFAULT, oldCapacityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCapacity() {
		return capacityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMountPoint() {
		return mountPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMountPoint(String newMountPoint) {
		String oldMountPoint = mountPoint;
		mountPoint = newMountPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.FILE_SYSTEM__MOUNT_POINT,
					oldMountPoint, mountPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.FILE_SYSTEM__TYPE,
					oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM__AVAILABLE_SPACE:
			return new Long(getAvailableSpace());
		case OsPackage.FILE_SYSTEM__CAPACITY:
			return new Long(getCapacity());
		case OsPackage.FILE_SYSTEM__MOUNT_POINT:
			return getMountPoint();
		case OsPackage.FILE_SYSTEM__TYPE:
			return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM__AVAILABLE_SPACE:
			setAvailableSpace(((Long) newValue).longValue());
			return;
		case OsPackage.FILE_SYSTEM__CAPACITY:
			setCapacity(((Long) newValue).longValue());
			return;
		case OsPackage.FILE_SYSTEM__MOUNT_POINT:
			setMountPoint((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM__TYPE:
			setType((String) newValue);
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
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM__AVAILABLE_SPACE:
			unsetAvailableSpace();
			return;
		case OsPackage.FILE_SYSTEM__CAPACITY:
			unsetCapacity();
			return;
		case OsPackage.FILE_SYSTEM__MOUNT_POINT:
			setMountPoint(MOUNT_POINT_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM__TYPE:
			setType(TYPE_EDEFAULT);
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
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM__AVAILABLE_SPACE:
			return isSetAvailableSpace();
		case OsPackage.FILE_SYSTEM__CAPACITY:
			return isSetCapacity();
		case OsPackage.FILE_SYSTEM__MOUNT_POINT:
			return MOUNT_POINT_EDEFAULT == null ? mountPoint != null : !MOUNT_POINT_EDEFAULT
					.equals(mountPoint);
		case OsPackage.FILE_SYSTEM__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (availableSpace: "); //$NON-NLS-1$
		if (availableSpaceESet)
			result.append(availableSpace);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", capacity: "); //$NON-NLS-1$
		if (capacityESet)
			result.append(capacity);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", mountPoint: "); //$NON-NLS-1$
		result.append(mountPoint);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //FileSystemImpl
