/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualServerDef.java,v 1.4 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Server Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				VirtualServerDefs hold details for the virtual machine itself on behalf of a {@link VirtualImageUnit}.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVcpus <em>Vcpus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVirtualHWFamily <em>Virtual HW Family</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualServerDef()
 * @model extendedMetaData="name='VirtualServerDef' kind='elementOnly'"
 * @generated
 */
public interface VirtualServerDef extends Capability {
	/**
	 * Returns the value of the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Memory size, in 1024 byte units
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Memory Size</em>' attribute.
	 * @see #setMemorySize(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualServerDef_MemorySize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.UnsignedLong"
	 *        extendedMetaData="kind='attribute' name='memorySize'"
	 * @generated
	 */
	BigInteger getMemorySize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Vcpus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Number of virtual CPUs as seen by a hosted multi-cpu-capable operating system.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vcpus</em>' attribute.
	 * @see #setVcpus(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualServerDef_Vcpus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.UnsignedLong"
	 *        extendedMetaData="kind='attribute' name='vcpus'"
	 * @generated
	 */
	BigInteger getVcpus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVcpus <em>Vcpus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vcpus</em>' attribute.
	 * @see #getVcpus()
	 * @generated
	 */
	void setVcpus(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Virtual HW Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The virtual system type. When set, this should use the same format as the VirtualSystemType
	 * 							field in an OVF descriptor. It uniquely identifies the family of virtual hardware that is
	 * 							required. Multiple families can be specified with comma separation. For example, a family
	 * 							identifier could be vmx-4 for VMware's 4th generation virtual hardware or xen-3 for Xen's
	 * 							3rd generation virtual hardware.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Virtual HW Family</em>' attribute.
	 * @see #setVirtualHWFamily(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualServerDef_VirtualHWFamily()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='virtualHWFamily'"
	 * @generated
	 */
	String getVirtualHWFamily();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVirtualHWFamily <em>Virtual HW Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual HW Family</em>' attribute.
	 * @see #getVirtualHWFamily()
	 * @generated
	 */
	void setVirtualHWFamily(String value);

} // VirtualServerDef
