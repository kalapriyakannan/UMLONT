/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualDiskDef.java,v 1.2 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xen Virtual Disk Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link DiskUnits}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getBackendDev <em>Backend Dev</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getFrontendDev <em>Frontend Dev</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualDiskDef()
 * @model extendedMetaData="name='XenVirtualDiskDef' kind='elementOnly'"
 * @generated
 */
public interface XenVirtualDiskDef extends VirtualDiskDef {
	/**
	 * Returns the value of the '<em><b>Backend Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The backend device for this virtual disk. Can be of form "phys:device" or
	 * 							"file://path/to/file"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Backend Dev</em>' attribute.
	 * @see #setBackendDev(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualDiskDef_BackendDev()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='backendDev'"
	 * @generated
	 */
	String getBackendDev();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getBackendDev <em>Backend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backend Dev</em>' attribute.
	 * @see #getBackendDev()
	 * @generated
	 */
	void setBackendDev(String value);

	/**
	 * Returns the value of the '<em><b>Frontend Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							How the device should appear in the guest domain. The device can be in symbolic form, as in
	 * 							"xvda", or "sda7"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Frontend Dev</em>' attribute.
	 * @see #setFrontendDev(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualDiskDef_FrontendDev()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='frontendDev'"
	 * @generated
	 */
	String getFrontendDev();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getFrontendDev <em>Frontend Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frontend Dev</em>' attribute.
	 * @see #getFrontendDev()
	 * @generated
	 */
	void setFrontendDev(String value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The access mode for the device. There are 2 valid options, r (read-only), w (read/write)
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualDiskDef_Mode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mode'"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

} // XenVirtualDiskDef
