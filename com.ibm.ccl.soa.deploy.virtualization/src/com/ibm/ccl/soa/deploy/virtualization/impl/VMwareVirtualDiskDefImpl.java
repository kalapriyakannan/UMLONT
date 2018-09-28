/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskDefImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Disk Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#isAutodetect <em>Autodetect</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#getDiskMode <em>Disk Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#isPresent <em>Present</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl#isStartConnected <em>Start Connected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualDiskDefImpl extends VirtualDiskDefImpl implements VMwareVirtualDiskDef {
	/**
	 * The default value of the '{@link #isAutodetect() <em>Autodetect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutodetect()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTODETECT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutodetect() <em>Autodetect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutodetect()
	 * @generated
	 * @ordered
	 */
	protected boolean autodetect = AUTODETECT_EDEFAULT;

	/**
	 * This is true if the Autodetect attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autodetectESet;

	/**
	 * The default value of the '{@link #getDeviceType() <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceType()
	 * @generated
	 * @ordered
	 */
	protected static final String DEVICE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeviceType() <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceType()
	 * @generated
	 * @ordered
	 */
	protected String deviceType = DEVICE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiskMode() <em>Disk Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskMode()
	 * @generated
	 * @ordered
	 */
	protected static final String DISK_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiskMode() <em>Disk Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiskMode()
	 * @generated
	 * @ordered
	 */
	protected String diskMode = DISK_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isPresent() <em>Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPresent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRESENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPresent() <em>Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPresent()
	 * @generated
	 * @ordered
	 */
	protected boolean present = PRESENT_EDEFAULT;

	/**
	 * This is true if the Present attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean presentESet;

	/**
	 * The default value of the '{@link #isStartConnected() <em>Start Connected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartConnected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean START_CONNECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartConnected() <em>Start Connected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartConnected()
	 * @generated
	 * @ordered
	 */
	protected boolean startConnected = START_CONNECTED_EDEFAULT;

	/**
	 * This is true if the Start Connected attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startConnectedESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_DISK_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutodetect() {
		return autodetect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutodetect(boolean newAutodetect) {
		boolean oldAutodetect = autodetect;
		autodetect = newAutodetect;
		boolean oldAutodetectESet = autodetectESet;
		autodetectESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT, oldAutodetect, autodetect, !oldAutodetectESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutodetect() {
		boolean oldAutodetect = autodetect;
		boolean oldAutodetectESet = autodetectESet;
		autodetect = AUTODETECT_EDEFAULT;
		autodetectESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT, oldAutodetect, AUTODETECT_EDEFAULT, oldAutodetectESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutodetect() {
		return autodetectESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceType(String newDeviceType) {
		String oldDeviceType = deviceType;
		deviceType = newDeviceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE, oldDeviceType, deviceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiskMode() {
		return diskMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiskMode(String newDiskMode) {
		String oldDiskMode = diskMode;
		diskMode = newDiskMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DISK_MODE, oldDiskMode, diskMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPresent() {
		return present;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresent(boolean newPresent) {
		boolean oldPresent = present;
		present = newPresent;
		boolean oldPresentESet = presentESet;
		presentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT, oldPresent, present, !oldPresentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPresent() {
		boolean oldPresent = present;
		boolean oldPresentESet = presentESet;
		present = PRESENT_EDEFAULT;
		presentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT, oldPresent, PRESENT_EDEFAULT, oldPresentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPresent() {
		return presentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartConnected() {
		return startConnected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartConnected(boolean newStartConnected) {
		boolean oldStartConnected = startConnected;
		startConnected = newStartConnected;
		boolean oldStartConnectedESet = startConnectedESet;
		startConnectedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED, oldStartConnected, startConnected, !oldStartConnectedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartConnected() {
		boolean oldStartConnected = startConnected;
		boolean oldStartConnectedESet = startConnectedESet;
		startConnected = START_CONNECTED_EDEFAULT;
		startConnectedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED, oldStartConnected, START_CONNECTED_EDEFAULT, oldStartConnectedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartConnected() {
		return startConnectedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT:
				return isAutodetect() ? Boolean.TRUE : Boolean.FALSE;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE:
				return getDeviceType();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DISK_MODE:
				return getDiskMode();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__FILE_NAME:
				return getFileName();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT:
				return isPresent() ? Boolean.TRUE : Boolean.FALSE;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED:
				return isStartConnected() ? Boolean.TRUE : Boolean.FALSE;
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT:
				setAutodetect(((Boolean)newValue).booleanValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE:
				setDeviceType((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DISK_MODE:
				setDiskMode((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__FILE_NAME:
				setFileName((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT:
				setPresent(((Boolean)newValue).booleanValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED:
				setStartConnected(((Boolean)newValue).booleanValue());
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT:
				unsetAutodetect();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE:
				setDeviceType(DEVICE_TYPE_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DISK_MODE:
				setDiskMode(DISK_MODE_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT:
				unsetPresent();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED:
				unsetStartConnected();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__AUTODETECT:
				return isSetAutodetect();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE:
				return DEVICE_TYPE_EDEFAULT == null ? deviceType != null : !DEVICE_TYPE_EDEFAULT.equals(deviceType);
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__DISK_MODE:
				return DISK_MODE_EDEFAULT == null ? diskMode != null : !DISK_MODE_EDEFAULT.equals(diskMode);
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__PRESENT:
				return isSetPresent();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED:
				return isSetStartConnected();
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
		result.append(" (autodetect: "); //$NON-NLS-1$
		if (autodetectESet) result.append(autodetect); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", deviceType: "); //$NON-NLS-1$
		result.append(deviceType);
		result.append(", diskMode: "); //$NON-NLS-1$
		result.append(diskMode);
		result.append(", fileName: "); //$NON-NLS-1$
		result.append(fileName);
		result.append(", present: "); //$NON-NLS-1$
		if (presentESet) result.append(present); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", startConnected: "); //$NON-NLS-1$
		if (startConnectedESet) result.append(startConnected); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualDiskDefImpl
