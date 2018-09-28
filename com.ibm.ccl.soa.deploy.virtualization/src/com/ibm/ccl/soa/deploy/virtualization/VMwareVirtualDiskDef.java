/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskDef.java,v 1.4 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Disk Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link DiskUnits}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect <em>Autodetect</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDiskMode <em>Disk Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getFileName <em>File Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent <em>Present</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected <em>Start Connected</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef()
 * @model extendedMetaData="name='VMwareVirtualDiskDef' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualDiskDef extends VirtualDiskDef {
	/**
	 * Returns the value of the '<em><b>Autodetect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autodetect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autodetect</em>' attribute.
	 * @see #isSetAutodetect()
	 * @see #unsetAutodetect()
	 * @see #setAutodetect(boolean)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_Autodetect()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autodetect'"
	 * @generated
	 */
	boolean isAutodetect();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect <em>Autodetect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autodetect</em>' attribute.
	 * @see #isSetAutodetect()
	 * @see #unsetAutodetect()
	 * @see #isAutodetect()
	 * @generated
	 */
	void setAutodetect(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect <em>Autodetect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAutodetect()
	 * @see #isAutodetect()
	 * @see #setAutodetect(boolean)
	 * @generated
	 */
	void unsetAutodetect();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect <em>Autodetect</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Autodetect</em>' attribute is set.
	 * @see #unsetAutodetect()
	 * @see #isAutodetect()
	 * @see #setAutodetect(boolean)
	 * @generated
	 */
	boolean isSetAutodetect();

	/**
	 * Returns the value of the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "cdrom-raw"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Device Type</em>' attribute.
	 * @see #setDeviceType(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_DeviceType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='deviceType'"
	 * @generated
	 */
	String getDeviceType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDeviceType <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Type</em>' attribute.
	 * @see #getDeviceType()
	 * @generated
	 */
	void setDeviceType(String value);

	/**
	 * Returns the value of the '<em><b>Disk Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Disk mode (persistent, etc)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disk Mode</em>' attribute.
	 * @see #setDiskMode(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_DiskMode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='diskMode'"
	 * @generated
	 */
	String getDiskMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDiskMode <em>Disk Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disk Mode</em>' attribute.
	 * @see #getDiskMode()
	 * @generated
	 */
	void setDiskMode(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path to vmdk, e.g. "RLELAS4.vmdk" or "RHELAS4-000001.vmdk"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_FileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fileName'"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates whether this disk is present in the virtual machine
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Present</em>' attribute.
	 * @see #isSetPresent()
	 * @see #unsetPresent()
	 * @see #setPresent(boolean)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_Present()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='present'"
	 * @generated
	 */
	boolean isPresent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent <em>Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Present</em>' attribute.
	 * @see #isSetPresent()
	 * @see #unsetPresent()
	 * @see #isPresent()
	 * @generated
	 */
	void setPresent(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent <em>Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPresent()
	 * @see #isPresent()
	 * @see #setPresent(boolean)
	 * @generated
	 */
	void unsetPresent();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent <em>Present</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Present</em>' attribute is set.
	 * @see #unsetPresent()
	 * @see #isPresent()
	 * @see #setPresent(boolean)
	 * @generated
	 */
	boolean isSetPresent();

	/**
	 * Returns the value of the '<em><b>Start Connected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Set for CD-ROM only. Indicates whether CD-ROM is connected at startup.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Connected</em>' attribute.
	 * @see #isSetStartConnected()
	 * @see #unsetStartConnected()
	 * @see #setStartConnected(boolean)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDef_StartConnected()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='startConnected'"
	 * @generated
	 */
	boolean isStartConnected();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected <em>Start Connected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Connected</em>' attribute.
	 * @see #isSetStartConnected()
	 * @see #unsetStartConnected()
	 * @see #isStartConnected()
	 * @generated
	 */
	void setStartConnected(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected <em>Start Connected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartConnected()
	 * @see #isStartConnected()
	 * @see #setStartConnected(boolean)
	 * @generated
	 */
	void unsetStartConnected();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected <em>Start Connected</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Connected</em>' attribute is set.
	 * @see #unsetStartConnected()
	 * @see #isStartConnected()
	 * @see #setStartConnected(boolean)
	 * @generated
	 */
	boolean isSetStartConnected();

} // VMwareVirtualDiskDef
