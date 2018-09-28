/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualServerDef.java,v 1.3 2008/04/04 21:32:01 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Server Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				VMwareVirtualImage holds details in addition to the attributes on VirtualServerDef, of the image file on
 * 				behalf of a {@link VirtualImageUnit}.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getGuestOS <em>Guest OS</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getVirtualHWVersion <em>Virtual HW Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerDef()
 * @model extendedMetaData="name='VMwareVirtualServerDef' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualServerDef extends VirtualServerDef {
	/**
	 * Returns the value of the '<em><b>Guest OS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Guest operating system
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Guest OS</em>' attribute.
	 * @see #setGuestOS(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerDef_GuestOS()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='guestOS'"
	 * @generated
	 */
	String getGuestOS();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getGuestOS <em>Guest OS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guest OS</em>' attribute.
	 * @see #getGuestOS()
	 * @generated
	 */
	void setGuestOS(String value);

	/**
	 * Returns the value of the '<em><b>Virtual HW Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * VMware virtual hardware version, e.g. "4"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Virtual HW Version</em>' attribute.
	 * @see #setVirtualHWVersion(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerDef_VirtualHWVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='virtualHWVersion'"
	 * @generated
	 */
	String getVirtualHWVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getVirtualHWVersion <em>Virtual HW Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual HW Version</em>' attribute.
	 * @see #getVirtualHWVersion()
	 * @generated
	 */
	void setVirtualHWVersion(String value);

} // VMwareVirtualServerDef
