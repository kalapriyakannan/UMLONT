/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualSCSIDiskDef.java,v 1.2 2008/04/04 17:59:42 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual SCSI Disk Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link DiskUnits}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber <em>Controller Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType <em>Controller Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber <em>Device Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualSCSIDiskDef()
 * @model extendedMetaData="name='VMwareVirtualSCSIDiskDef' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualSCSIDiskDef extends VMwareVirtualDiskDef {
	/**
	 * Returns the value of the '<em><b>Controller Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * number of the SCSI controller (e.g. 0, 1, 2)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Controller Number</em>' attribute.
	 * @see #isSetControllerNumber()
	 * @see #unsetControllerNumber()
	 * @see #setControllerNumber(int)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualSCSIDiskDef_ControllerNumber()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='controllerNumber'"
	 * @generated
	 */
	int getControllerNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber <em>Controller Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Number</em>' attribute.
	 * @see #isSetControllerNumber()
	 * @see #unsetControllerNumber()
	 * @see #getControllerNumber()
	 * @generated
	 */
	void setControllerNumber(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber <em>Controller Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetControllerNumber()
	 * @see #getControllerNumber()
	 * @see #setControllerNumber(int)
	 * @generated
	 */
	void unsetControllerNumber();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber <em>Controller Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Controller Number</em>' attribute is set.
	 * @see #unsetControllerNumber()
	 * @see #getControllerNumber()
	 * @see #setControllerNumber(int)
	 * @generated
	 */
	boolean isSetControllerNumber();

	/**
	 * Returns the value of the '<em><b>Controller Type</b></em>' attribute.
	 * The default value is <code>"buslogic"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "lsilogic" or "buslogic" enumeration
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Controller Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @see #isSetControllerType()
	 * @see #unsetControllerType()
	 * @see #setControllerType(VMwareSCSIControllerType)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualSCSIDiskDef_ControllerType()
	 * @model default="buslogic" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='controllerType'"
	 * @generated
	 */
	VMwareSCSIControllerType getControllerType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType <em>Controller Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @see #isSetControllerType()
	 * @see #unsetControllerType()
	 * @see #getControllerType()
	 * @generated
	 */
	void setControllerType(VMwareSCSIControllerType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType <em>Controller Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetControllerType()
	 * @see #getControllerType()
	 * @see #setControllerType(VMwareSCSIControllerType)
	 * @generated
	 */
	void unsetControllerType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType <em>Controller Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Controller Type</em>' attribute is set.
	 * @see #unsetControllerType()
	 * @see #getControllerType()
	 * @see #setControllerType(VMwareSCSIControllerType)
	 * @generated
	 */
	boolean isSetControllerType();

	/**
	 * Returns the value of the '<em><b>Device Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * number of the SCSI device (e.g. 0, 1, 2)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Device Number</em>' attribute.
	 * @see #isSetDeviceNumber()
	 * @see #unsetDeviceNumber()
	 * @see #setDeviceNumber(int)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualSCSIDiskDef_DeviceNumber()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='deviceNumber'"
	 * @generated
	 */
	int getDeviceNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber <em>Device Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Number</em>' attribute.
	 * @see #isSetDeviceNumber()
	 * @see #unsetDeviceNumber()
	 * @see #getDeviceNumber()
	 * @generated
	 */
	void setDeviceNumber(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber <em>Device Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeviceNumber()
	 * @see #getDeviceNumber()
	 * @see #setDeviceNumber(int)
	 * @generated
	 */
	void unsetDeviceNumber();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber <em>Device Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Device Number</em>' attribute is set.
	 * @see #unsetDeviceNumber()
	 * @see #getDeviceNumber()
	 * @see #setDeviceNumber(int)
	 * @generated
	 */
	boolean isSetDeviceNumber();

} // VMwareVirtualSCSIDiskDef
