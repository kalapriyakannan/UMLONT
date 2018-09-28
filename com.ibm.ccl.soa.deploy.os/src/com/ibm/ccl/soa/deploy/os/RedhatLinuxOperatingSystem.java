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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Redhat Linux Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType <em>Product Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState <em>SE Linux State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem()
 * @model extendedMetaData="name='RedhatLinuxOperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface RedhatLinuxOperatingSystem extends LinuxOperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Boot Loader</b></em>' attribute.
	 * The default value is <code>"GRUB"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boot Loader</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boot Loader</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @see #isSetBootLoader()
	 * @see #unsetBootLoader()
	 * @see #setBootLoader(RedhatLinuxBootLoaderType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_BootLoader()
	 * @model default="GRUB" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='BootLoader'"
	 * @generated
	 */
	RedhatLinuxBootLoaderType getBootLoader();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boot Loader</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @see #isSetBootLoader()
	 * @see #unsetBootLoader()
	 * @see #getBootLoader()
	 * @generated
	 */
	void setBootLoader(RedhatLinuxBootLoaderType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetBootLoader()
	 * @see #getBootLoader()
	 * @see #setBootLoader(RedhatLinuxBootLoaderType)
	 * @generated
	 */
	void unsetBootLoader();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boot Loader</em>' attribute is set.
	 * @see #unsetBootLoader()
	 * @see #getBootLoader()
	 * @see #setBootLoader(RedhatLinuxBootLoaderType)
	 * @generated
	 */
	boolean isSetBootLoader();

	/**
	 * Returns the value of the '<em><b>Desktop</b></em>' attribute.
	 * The default value is <code>"GNOME"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.RedhatDesktopType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desktop</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #setDesktop(RedhatDesktopType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_Desktop()
	 * @model default="GNOME" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Desktop'"
	 * @generated
	 */
	RedhatDesktopType getDesktop();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @generated
	 */
	void setDesktop(RedhatDesktopType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(RedhatDesktopType)
	 * @generated
	 */
	void unsetDesktop();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop <em>Desktop</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Desktop</em>' attribute is set.
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(RedhatDesktopType)
	 * @generated
	 */
	boolean isSetDesktop();

	/**
	 * Returns the value of the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Install Date</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Date</em>' attribute.
	 * @see #setInstallDate(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_InstallDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstallDate'"
	 * @generated
	 */
	String getInstallDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getInstallDate <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Date</em>' attribute.
	 * @see #getInstallDate()
	 * @generated
	 */
	void setInstallDate(String value);

	/**
	 * Returns the value of the '<em><b>Last Boot Up Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Boot Up Time</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #setLastBootUpTime(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_LastBootUpTime()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LastBootUpTime'"
	 * @generated
	 */
	String getLastBootUpTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #getLastBootUpTime()
	 * @generated
	 */
	void setLastBootUpTime(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Product Type</b></em>' attribute.
	 * The default value is <code>"Server"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @see #isSetProductType()
	 * @see #unsetProductType()
	 * @see #setProductType(RedhatLinuxProductTypeType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_ProductType()
	 * @model default="Server" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ProductType'"
	 * @generated
	 */
	RedhatLinuxProductTypeType getProductType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType <em>Product Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @see #isSetProductType()
	 * @see #unsetProductType()
	 * @see #getProductType()
	 * @generated
	 */
	void setProductType(RedhatLinuxProductTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType <em>Product Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetProductType()
	 * @see #getProductType()
	 * @see #setProductType(RedhatLinuxProductTypeType)
	 * @generated
	 */
	void unsetProductType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType <em>Product Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Product Type</em>' attribute is set.
	 * @see #unsetProductType()
	 * @see #getProductType()
	 * @see #setProductType(RedhatLinuxProductTypeType)
	 * @generated
	 */
	boolean isSetProductType();

	/**
	 * Returns the value of the '<em><b>SE Linux State</b></em>' attribute.
	 * The default value is <code>"disabled"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.SELinuxStateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SE Linux State</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SE Linux State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @see #isSetSELinuxState()
	 * @see #unsetSELinuxState()
	 * @see #setSELinuxState(SELinuxStateType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxOperatingSystem_SELinuxState()
	 * @model default="disabled" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='SELinuxState'"
	 * @generated
	 */
	SELinuxStateType getSELinuxState();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState <em>SE Linux State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>SE Linux State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @see #isSetSELinuxState()
	 * @see #unsetSELinuxState()
	 * @see #getSELinuxState()
	 * @generated
	 */
	void setSELinuxState(SELinuxStateType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState <em>SE Linux State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSELinuxState()
	 * @see #getSELinuxState()
	 * @see #setSELinuxState(SELinuxStateType)
	 * @generated
	 */
	void unsetSELinuxState();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState <em>SE Linux State</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>SE Linux State</em>' attribute is set.
	 * @see #unsetSELinuxState()
	 * @see #getSELinuxState()
	 * @see #setSELinuxState(SELinuxStateType)
	 * @generated
	 */
	boolean isSetSELinuxState();

} // RedhatLinuxOperatingSystem
