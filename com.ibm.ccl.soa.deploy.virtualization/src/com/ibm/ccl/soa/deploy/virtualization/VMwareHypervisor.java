/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareHypervisor.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Hypervisor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				This capability may be provided by {@link Unit}s that can host VMware virtual machines images.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareProduct <em>Vmware Product</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareVersion <em>Vmware Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareHypervisor()
 * @model extendedMetaData="name='VMwareHypervisor' kind='elementOnly'"
 * @generated
 */
public interface VMwareHypervisor extends Hypervisor {

	/**
	 * Returns the value of the '<em><b>Vmware Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional name of the VMware product, e.g. ESX Server
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vmware Product</em>' attribute.
	 * @see #setVmwareProduct(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareHypervisor_VmwareProduct()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vmwareProduct'"
	 * @generated
	 */
	String getVmwareProduct();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareProduct <em>Vmware Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmware Product</em>' attribute.
	 * @see #getVmwareProduct()
	 * @generated
	 */
	void setVmwareProduct(String value);

	/**
	 * Returns the value of the '<em><b>Vmware Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional version number of the VMware product, e.g. 1.0.3
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vmware Version</em>' attribute.
	 * @see #setVmwareVersion(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareHypervisor_VmwareVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vmwareVersion'"
	 * @generated
	 */
	String getVmwareVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareVersion <em>Vmware Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmware Version</em>' attribute.
	 * @see #getVmwareVersion()
	 * @generated
	 */
	void setVmwareVersion(String value);
} // VMwareHypervisor
