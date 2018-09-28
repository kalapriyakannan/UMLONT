/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows Local Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getDependantComponents <em>Dependant Components</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl <em>Error Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getExecutablePath <em>Executable Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem <em>Log On As System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getRunProgram <em>Run Program</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccount <em>Service Account</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccountPassword <em>Service Account Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDisplayName <em>Service Display Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus <em>Service Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartParams <em>Start Params</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType <em>Startup Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService()
 * @model extendedMetaData="name='WindowsLocalService' kind='elementOnly'"
 * @generated
 */
public interface WindowsLocalService extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Dependant Components</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependant Components</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dependant Components</em>' attribute.
	 * @see #setDependantComponents(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_DependantComponents()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DependantComponents'"
	 * @generated
	 */
	String getDependantComponents();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getDependantComponents <em>Dependant Components</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependant Components</em>' attribute.
	 * @see #getDependantComponents()
	 * @generated
	 */
	void setDependantComponents(String value);

	/**
	 * Returns the value of the '<em><b>Error Control</b></em>' attribute.
	 * The default value is <code>"Ignore"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Control</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Control</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @see #isSetErrorControl()
	 * @see #unsetErrorControl()
	 * @see #setErrorControl(WindowsServiceErrorControlType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ErrorControl()
	 * @model default="Ignore" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ErrorControl'"
	 * @generated
	 */
	WindowsServiceErrorControlType getErrorControl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl <em>Error Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Control</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @see #isSetErrorControl()
	 * @see #unsetErrorControl()
	 * @see #getErrorControl()
	 * @generated
	 */
	void setErrorControl(WindowsServiceErrorControlType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl <em>Error Control</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetErrorControl()
	 * @see #getErrorControl()
	 * @see #setErrorControl(WindowsServiceErrorControlType)
	 * @generated
	 */
	void unsetErrorControl();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl <em>Error Control</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Error Control</em>' attribute is set.
	 * @see #unsetErrorControl()
	 * @see #getErrorControl()
	 * @see #setErrorControl(WindowsServiceErrorControlType)
	 * @generated
	 */
	boolean isSetErrorControl();

	/**
	 * Returns the value of the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Executable Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable Path</em>' attribute.
	 * @see #setExecutablePath(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ExecutablePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExecutablePath'"
	 * @generated
	 */
	String getExecutablePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getExecutablePath <em>Executable Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable Path</em>' attribute.
	 * @see #getExecutablePath()
	 * @generated
	 */
	void setExecutablePath(String value);

	/**
	 * Returns the value of the '<em><b>Log On As System</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log On As System</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Log On As System</em>' attribute.
	 * @see #isSetLogOnAsSystem()
	 * @see #unsetLogOnAsSystem()
	 * @see #setLogOnAsSystem(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_LogOnAsSystem()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='LogOnAsSystem'"
	 * @generated
	 */
	boolean isLogOnAsSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem <em>Log On As System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log On As System</em>' attribute.
	 * @see #isSetLogOnAsSystem()
	 * @see #unsetLogOnAsSystem()
	 * @see #isLogOnAsSystem()
	 * @generated
	 */
	void setLogOnAsSystem(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem <em>Log On As System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetLogOnAsSystem()
	 * @see #isLogOnAsSystem()
	 * @see #setLogOnAsSystem(boolean)
	 * @generated
	 */
	void unsetLogOnAsSystem();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem <em>Log On As System</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Log On As System</em>' attribute is set.
	 * @see #unsetLogOnAsSystem()
	 * @see #isLogOnAsSystem()
	 * @see #setLogOnAsSystem(boolean)
	 * @generated
	 */
	boolean isSetLogOnAsSystem();

	/**
	 * Returns the value of the '<em><b>Run Program</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Program</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Program</em>' attribute.
	 * @see #setRunProgram(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_RunProgram()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RunProgram'"
	 * @generated
	 */
	String getRunProgram();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getRunProgram <em>Run Program</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Program</em>' attribute.
	 * @see #getRunProgram()
	 * @generated
	 */
	void setRunProgram(String value);

	/**
	 * Returns the value of the '<em><b>Service Account</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Service Account</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Account</em>' attribute.
	 * @see #setServiceAccount(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceAccount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceAccount'"
	 * @generated
	 */
	String getServiceAccount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccount <em>Service Account</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Account</em>' attribute.
	 * @see #getServiceAccount()
	 * @generated
	 */
	void setServiceAccount(String value);

	/**
	 * Returns the value of the '<em><b>Service Account Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Account Password</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Account Password</em>' attribute.
	 * @see #setServiceAccountPassword(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceAccountPassword()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceAccountPassword'"
	 * @generated
	 */
	String getServiceAccountPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccountPassword <em>Service Account Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Account Password</em>' attribute.
	 * @see #getServiceAccountPassword()
	 * @generated
	 */
	void setServiceAccountPassword(String value);

	/**
	 * Returns the value of the '<em><b>Service Dependencies</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Dependencies</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Dependencies</em>' attribute.
	 * @see #setServiceDependencies(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceDependencies()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceDependencies'"
	 * @generated
	 */
	String getServiceDependencies();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDependencies <em>Service Dependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Dependencies</em>' attribute.
	 * @see #getServiceDependencies()
	 * @generated
	 */
	void setServiceDependencies(String value);

	/**
	 * Returns the value of the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Description</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Description</em>' attribute.
	 * @see #setServiceDescription(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceDescription'"
	 * @generated
	 */
	String getServiceDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDescription <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Description</em>' attribute.
	 * @see #getServiceDescription()
	 * @generated
	 */
	void setServiceDescription(String value);

	/**
	 * Returns the value of the '<em><b>Service Display Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Display Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Display Name</em>' attribute.
	 * @see #setServiceDisplayName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceDisplayName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceDisplayName'"
	 * @generated
	 */
	String getServiceDisplayName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDisplayName <em>Service Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Display Name</em>' attribute.
	 * @see #getServiceDisplayName()
	 * @generated
	 */
	void setServiceDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceName'"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Service Status</b></em>' attribute.
	 * The default value is <code>"Running"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Status</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Status</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @see #isSetServiceStatus()
	 * @see #unsetServiceStatus()
	 * @see #setServiceStatus(WindowsServiceStatusType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_ServiceStatus()
	 * @model default="Running" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ServiceStatus'"
	 * @generated
	 */
	WindowsServiceStatusType getServiceStatus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus <em>Service Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Status</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @see #isSetServiceStatus()
	 * @see #unsetServiceStatus()
	 * @see #getServiceStatus()
	 * @generated
	 */
	void setServiceStatus(WindowsServiceStatusType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus <em>Service Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetServiceStatus()
	 * @see #getServiceStatus()
	 * @see #setServiceStatus(WindowsServiceStatusType)
	 * @generated
	 */
	void unsetServiceStatus();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus <em>Service Status</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Service Status</em>' attribute is set.
	 * @see #unsetServiceStatus()
	 * @see #getServiceStatus()
	 * @see #setServiceStatus(WindowsServiceStatusType)
	 * @generated
	 */
	boolean isSetServiceStatus();

	/**
	 * Returns the value of the '<em><b>Start Params</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Start Params</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Params</em>' attribute.
	 * @see #setStartParams(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_StartParams()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='StartParams'"
	 * @generated
	 */
	String getStartParams();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartParams <em>Start Params</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Params</em>' attribute.
	 * @see #getStartParams()
	 * @generated
	 */
	void setStartParams(String value);

	/**
	 * Returns the value of the '<em><b>Startup Type</b></em>' attribute.
	 * The default value is <code>"Boot"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Startup Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @see #isSetStartupType()
	 * @see #unsetStartupType()
	 * @see #setStartupType(WindowsServiceStartupType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsLocalService_StartupType()
	 * @model default="Boot" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='StartupType'"
	 * @generated
	 */
	WindowsServiceStartupType getStartupType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType <em>Startup Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @see #isSetStartupType()
	 * @see #unsetStartupType()
	 * @see #getStartupType()
	 * @generated
	 */
	void setStartupType(WindowsServiceStartupType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType <em>Startup Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupType()
	 * @see #getStartupType()
	 * @see #setStartupType(WindowsServiceStartupType)
	 * @generated
	 */
	void unsetStartupType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType <em>Startup Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Type</em>' attribute is set.
	 * @see #unsetStartupType()
	 * @see #getStartupType()
	 * @see #setStartupType(WindowsServiceStartupType)
	 * @generated
	 */
	boolean isSetStartupType();

} // WindowsLocalService
