/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualSCSIDiskDefImpl.java,v 1.2 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual SCSI Disk Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl#getControllerNumber <em>Controller Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl#getControllerType <em>Controller Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl#getDeviceNumber <em>Device Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualSCSIDiskDefImpl extends VMwareVirtualDiskDefImpl implements VMwareVirtualSCSIDiskDef {
	/**
	 * The default value of the '{@link #getControllerNumber() <em>Controller Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int CONTROLLER_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getControllerNumber() <em>Controller Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerNumber()
	 * @generated
	 * @ordered
	 */
	protected int controllerNumber = CONTROLLER_NUMBER_EDEFAULT;

	/**
	 * This is true if the Controller Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean controllerNumberESet;

	/**
	 * The default value of the '{@link #getControllerType() <em>Controller Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerType()
	 * @generated
	 * @ordered
	 */
	protected static final VMwareSCSIControllerType CONTROLLER_TYPE_EDEFAULT = VMwareSCSIControllerType.BUSLOGIC_LITERAL;

	/**
	 * The cached value of the '{@link #getControllerType() <em>Controller Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerType()
	 * @generated
	 * @ordered
	 */
	protected VMwareSCSIControllerType controllerType = CONTROLLER_TYPE_EDEFAULT;

	/**
	 * This is true if the Controller Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean controllerTypeESet;

	/**
	 * The default value of the '{@link #getDeviceNumber() <em>Device Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int DEVICE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDeviceNumber() <em>Device Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceNumber()
	 * @generated
	 * @ordered
	 */
	protected int deviceNumber = DEVICE_NUMBER_EDEFAULT;

	/**
	 * This is true if the Device Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean deviceNumberESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualSCSIDiskDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_SCSI_DISK_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getControllerNumber() {
		return controllerNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerNumber(int newControllerNumber) {
		int oldControllerNumber = controllerNumber;
		controllerNumber = newControllerNumber;
		boolean oldControllerNumberESet = controllerNumberESet;
		controllerNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER, oldControllerNumber, controllerNumber, !oldControllerNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetControllerNumber() {
		int oldControllerNumber = controllerNumber;
		boolean oldControllerNumberESet = controllerNumberESet;
		controllerNumber = CONTROLLER_NUMBER_EDEFAULT;
		controllerNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER, oldControllerNumber, CONTROLLER_NUMBER_EDEFAULT, oldControllerNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetControllerNumber() {
		return controllerNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareSCSIControllerType getControllerType() {
		return controllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerType(VMwareSCSIControllerType newControllerType) {
		VMwareSCSIControllerType oldControllerType = controllerType;
		controllerType = newControllerType == null ? CONTROLLER_TYPE_EDEFAULT : newControllerType;
		boolean oldControllerTypeESet = controllerTypeESet;
		controllerTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE, oldControllerType, controllerType, !oldControllerTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetControllerType() {
		VMwareSCSIControllerType oldControllerType = controllerType;
		boolean oldControllerTypeESet = controllerTypeESet;
		controllerType = CONTROLLER_TYPE_EDEFAULT;
		controllerTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE, oldControllerType, CONTROLLER_TYPE_EDEFAULT, oldControllerTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetControllerType() {
		return controllerTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDeviceNumber() {
		return deviceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceNumber(int newDeviceNumber) {
		int oldDeviceNumber = deviceNumber;
		deviceNumber = newDeviceNumber;
		boolean oldDeviceNumberESet = deviceNumberESet;
		deviceNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER, oldDeviceNumber, deviceNumber, !oldDeviceNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeviceNumber() {
		int oldDeviceNumber = deviceNumber;
		boolean oldDeviceNumberESet = deviceNumberESet;
		deviceNumber = DEVICE_NUMBER_EDEFAULT;
		deviceNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER, oldDeviceNumber, DEVICE_NUMBER_EDEFAULT, oldDeviceNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeviceNumber() {
		return deviceNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER:
				return new Integer(getControllerNumber());
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE:
				return getControllerType();
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER:
				return new Integer(getDeviceNumber());
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER:
				setControllerNumber(((Integer)newValue).intValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE:
				setControllerType((VMwareSCSIControllerType)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER:
				setDeviceNumber(((Integer)newValue).intValue());
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER:
				unsetControllerNumber();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE:
				unsetControllerType();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER:
				unsetDeviceNumber();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER:
				return isSetControllerNumber();
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE:
				return isSetControllerType();
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER:
				return isSetDeviceNumber();
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
		result.append(" (controllerNumber: "); //$NON-NLS-1$
		if (controllerNumberESet) result.append(controllerNumber); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", controllerType: "); //$NON-NLS-1$
		if (controllerTypeESet) result.append(controllerType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", deviceNumber: "); //$NON-NLS-1$
		if (deviceNumberESet) result.append(deviceNumber); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualSCSIDiskDefImpl
