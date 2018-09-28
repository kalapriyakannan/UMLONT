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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>SUSE Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getLastBootUpDate <em>Last Boot Up Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getSUSELinuxOperatingSystem()
 * @model extendedMetaData="name='SUSELinuxOperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface SUSELinuxOperatingSystem extends LinuxOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Boot Loader</b></em>' attribute.
	 * The default value is <code>"GRUB"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boot Loader</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boot Loader</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @see #isSetBootLoader()
	 * @see #unsetBootLoader()
	 * @see #setBootLoader(SUSELinuxBootLoaderType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getSUSELinuxOperatingSystem_BootLoader()
	 * @model default="GRUB" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='BootLoader'"
	 * @generated
	 */
	SUSELinuxBootLoaderType getBootLoader();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boot Loader</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @see #isSetBootLoader()
	 * @see #unsetBootLoader()
	 * @see #getBootLoader()
	 * @generated
	 */
	void setBootLoader(SUSELinuxBootLoaderType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetBootLoader()
	 * @see #getBootLoader()
	 * @see #setBootLoader(SUSELinuxBootLoaderType)
	 * @generated
	 */
	void unsetBootLoader();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boot Loader</em>' attribute is set.
	 * @see #unsetBootLoader()
	 * @see #getBootLoader()
	 * @see #setBootLoader(SUSELinuxBootLoaderType)
	 * @generated
	 */
	boolean isSetBootLoader();

	/**
	 * Returns the value of the '<em><b>Desktop</b></em>' attribute.
	 * The default value is <code>"GNOME"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.SUSEDesktopType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desktop</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #setDesktop(SUSEDesktopType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getSUSELinuxOperatingSystem_Desktop()
	 * @model default="GNOME" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Desktop'"
	 * @generated
	 */
	SUSEDesktopType getDesktop();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @generated
	 */
	void setDesktop(SUSEDesktopType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(SUSEDesktopType)
	 * @generated
	 */
	void unsetDesktop();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Desktop</em>' attribute is set.
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(SUSEDesktopType)
	 * @generated
	 */
	boolean isSetDesktop();

	/**
	 * Returns the value of the '<em><b>Last Boot Up Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Boot Up Date</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Boot Up Date</em>' attribute.
	 * @see #setLastBootUpDate(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getSUSELinuxOperatingSystem_LastBootUpDate()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LastBootUpDate'"
	 * @generated
	 */
	String getLastBootUpDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getLastBootUpDate <em>Last Boot Up Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Boot Up Date</em>' attribute.
	 * @see #getLastBootUpDate()
	 * @generated
	 */
	void setLastBootUpDate(String value);

} // SUSELinuxOperatingSystem
