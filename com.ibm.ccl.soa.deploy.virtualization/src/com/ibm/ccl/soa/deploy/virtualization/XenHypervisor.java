/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenHypervisor.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xen Hypervisor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				This capability may be provided by {@link Unit}s that can host Xen virtual machines images.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor#getXenVersion <em>Xen Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenHypervisor()
 * @model extendedMetaData="name='XenHypervisor' kind='elementOnly'"
 * @generated
 */
public interface XenHypervisor extends Hypervisor {

	/**
	 * Returns the value of the '<em><b>Xen Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional version of the Xen hypervisor, e.g. 3.0
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Xen Version</em>' attribute.
	 * @see #setXenVersion(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenHypervisor_XenVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='xenVersion'"
	 * @generated
	 */
	String getXenVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor#getXenVersion <em>Xen Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xen Version</em>' attribute.
	 * @see #getXenVersion()
	 * @generated
	 */
	void setXenVersion(String value);
} // XenHypervisor
