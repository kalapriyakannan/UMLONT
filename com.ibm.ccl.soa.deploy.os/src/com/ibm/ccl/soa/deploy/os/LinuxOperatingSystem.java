/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem#getKernelRelease <em>Kernel Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxOperatingSystem()
 * @model extendedMetaData="name='LinuxOperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface LinuxOperatingSystem extends OperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Kernel Release</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Kernel Release</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kernel Release</em>' attribute.
	 * @see #setKernelRelease(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getLinuxOperatingSystem_KernelRelease()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='KernelRelease'"
	 * @generated
	 */
	String getKernelRelease();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem#getKernelRelease <em>Kernel Release</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel Release</em>' attribute.
	 * @see #getKernelRelease()
	 * @generated
	 */
	void setKernelRelease(String value);

} // LinuxOperatingSystem
