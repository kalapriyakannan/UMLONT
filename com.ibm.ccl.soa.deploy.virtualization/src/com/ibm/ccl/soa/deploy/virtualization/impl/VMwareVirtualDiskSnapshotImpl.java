/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskSnapshotImpl.java,v 1.2 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Disk Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl#getDiskFileName <em>Disk File Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl#getDiskNum <em>Disk Num</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl#getSnapshotDiskFileName <em>Snapshot Disk File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualDiskSnapshotImpl extends VirtualDiskSnapshotImpl implements VMwareVirtualDiskSnapshot {
	/**
	 * The default value of the '{@link #getDiskFileName() <em>Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISK_FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiskFileName() <em>Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskFileName()
	 * @generated
	 * @ordered
	 */
	protected String diskFileName = DISK_FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiskNum() <em>Disk Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskNum()
	 * @generated
	 * @ordered
	 */
	protected static final int DISK_NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDiskNum() <em>Disk Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskNum()
	 * @generated
	 * @ordered
	 */
	protected int diskNum = DISK_NUM_EDEFAULT;

	/**
	 * This is true if the Disk Num attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean diskNumESet;

	/**
	 * The default value of the '{@link #getSnapshotDiskFileName() <em>Snapshot Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotDiskFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAPSHOT_DISK_FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSnapshotDiskFileName() <em>Snapshot Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotDiskFileName()
	 * @generated
	 * @ordered
	 */
	protected String snapshotDiskFileName = SNAPSHOT_DISK_FILE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskSnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_DISK_SNAPSHOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiskFileName() {
		return diskFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiskFileName(String newDiskFileName) {
		String oldDiskFileName = diskFileName;
		diskFileName = newDiskFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME, oldDiskFileName, diskFileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDiskNum() {
		return diskNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiskNum(int newDiskNum) {
		int oldDiskNum = diskNum;
		diskNum = newDiskNum;
		boolean oldDiskNumESet = diskNumESet;
		diskNumESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM, oldDiskNum, diskNum, !oldDiskNumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiskNum() {
		int oldDiskNum = diskNum;
		boolean oldDiskNumESet = diskNumESet;
		diskNum = DISK_NUM_EDEFAULT;
		diskNumESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM, oldDiskNum, DISK_NUM_EDEFAULT, oldDiskNumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiskNum() {
		return diskNumESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSnapshotDiskFileName() {
		return snapshotDiskFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshotDiskFileName(String newSnapshotDiskFileName) {
		String oldSnapshotDiskFileName = snapshotDiskFileName;
		snapshotDiskFileName = newSnapshotDiskFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME, oldSnapshotDiskFileName, snapshotDiskFileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME:
				return getDiskFileName();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM:
				return new Integer(getDiskNum());
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME:
				return getSnapshotDiskFileName();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME:
				setDiskFileName((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM:
				setDiskNum(((Integer)newValue).intValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME:
				setSnapshotDiskFileName((String)newValue);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME:
				setDiskFileName(DISK_FILE_NAME_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM:
				unsetDiskNum();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME:
				setSnapshotDiskFileName(SNAPSHOT_DISK_FILE_NAME_EDEFAULT);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME:
				return DISK_FILE_NAME_EDEFAULT == null ? diskFileName != null : !DISK_FILE_NAME_EDEFAULT.equals(diskFileName);
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM:
				return isSetDiskNum();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME:
				return SNAPSHOT_DISK_FILE_NAME_EDEFAULT == null ? snapshotDiskFileName != null : !SNAPSHOT_DISK_FILE_NAME_EDEFAULT.equals(snapshotDiskFileName);
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
		result.append(" (diskFileName: "); //$NON-NLS-1$
		result.append(diskFileName);
		result.append(", diskNum: "); //$NON-NLS-1$
		if (diskNumESet) result.append(diskNum); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", snapshotDiskFileName: "); //$NON-NLS-1$
		result.append(snapshotDiskFileName);
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualDiskSnapshotImpl
