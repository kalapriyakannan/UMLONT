/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Web Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getConfigFile <em>Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getLogFileAccess <em>Log File Access</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getLogFileError <em>Log File Error</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getMapApplications <em>Map Applications</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getServerName <em>Server Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getType <em>Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebServer#isUseSecureProtocol <em>Use Secure Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer()
 * @model extendedMetaData="name='WasWebServer' kind='elementOnly'"
 * @generated
 */
public interface WasWebServer extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config File</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config File</em>' attribute.
	 * @see #setConfigFile(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_ConfigFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configFile'"
	 * @generated
	 */
	String getConfigFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getConfigFile <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config File</em>' attribute.
	 * @see #getConfigFile()
	 * @generated
	 */
	void setConfigFile(String value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_Host()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='host'"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Install Location</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Location</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Install Location</em>' attribute.
	 * @see #setInstallLocation(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_InstallLocation()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installLocation'"
	 * @generated
	 */
	String getInstallLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getInstallLocation <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Location</em>' attribute.
	 * @see #getInstallLocation()
	 * @generated
	 */
	void setInstallLocation(String value);

	/**
	 * Returns the value of the '<em><b>Log File Access</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Log File Access</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log File Access</em>' attribute.
	 * @see #setLogFileAccess(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_LogFileAccess()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='logFileAccess'"
	 * @generated
	 */
	String getLogFileAccess();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getLogFileAccess <em>Log File Access</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log File Access</em>' attribute.
	 * @see #getLogFileAccess()
	 * @generated
	 */
	void setLogFileAccess(String value);

	/**
	 * Returns the value of the '<em><b>Log File Error</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Log File Error</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log File Error</em>' attribute.
	 * @see #setLogFileError(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_LogFileError()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='logFileError'"
	 * @generated
	 */
	String getLogFileError();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getLogFileError <em>Log File Error</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log File Error</em>' attribute.
	 * @see #getLogFileError()
	 * @generated
	 */
	void setLogFileError(String value);

	/**
	 * Returns the value of the '<em><b>Map Applications</b></em>' attribute.
	 * The default value is <code>"MAP_NONE"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasApplicationMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Applications</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Applications</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasApplicationMap
	 * @see #isSetMapApplications()
	 * @see #unsetMapApplications()
	 * @see #setMapApplications(WasApplicationMap)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_MapApplications()
	 * @model default="MAP_NONE" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='mapApplications'"
	 * @generated
	 */
	WasApplicationMap getMapApplications();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getMapApplications <em>Map Applications</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Applications</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasApplicationMap
	 * @see #isSetMapApplications()
	 * @see #unsetMapApplications()
	 * @see #getMapApplications()
	 * @generated
	 */
	void setMapApplications(WasApplicationMap value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getMapApplications <em>Map Applications</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMapApplications()
	 * @see #getMapApplications()
	 * @see #setMapApplications(WasApplicationMap)
	 * @generated
	 */
	void unsetMapApplications();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getMapApplications <em>Map Applications</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Map Applications</em>' attribute is set.
	 * @see #unsetMapApplications()
	 * @see #getMapApplications()
	 * @see #setMapApplications(WasApplicationMap)
	 * @generated
	 */
	boolean isSetMapApplications();

	/**
	 * Returns the value of the '<em><b>Operating System</b></em>' attribute.
	 * The default value is <code>"WINDOWS"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasWebServerOS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating System</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating System</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerOS
	 * @see #isSetOperatingSystem()
	 * @see #unsetOperatingSystem()
	 * @see #setOperatingSystem(WasWebServerOS)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_OperatingSystem()
	 * @model default="WINDOWS" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='operatingSystem'"
	 * @generated
	 */
	WasWebServerOS getOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getOperatingSystem <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating System</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerOS
	 * @see #isSetOperatingSystem()
	 * @see #unsetOperatingSystem()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	void setOperatingSystem(WasWebServerOS value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getOperatingSystem <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetOperatingSystem()
	 * @see #getOperatingSystem()
	 * @see #setOperatingSystem(WasWebServerOS)
	 * @generated
	 */
	void unsetOperatingSystem();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getOperatingSystem <em>Operating System</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Operating System</em>' attribute is set.
	 * @see #unsetOperatingSystem()
	 * @see #getOperatingSystem()
	 * @see #setOperatingSystem(WasWebServerOS)
	 * @generated
	 */
	boolean isSetOperatingSystem();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_Port()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Server Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Server Name</em>' attribute.
	 * @see #setServerName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_ServerName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serverName'"
	 * @generated
	 */
	String getServerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getServerName <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Name</em>' attribute.
	 * @see #getServerName()
	 * @generated
	 */
	void setServerName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_ServiceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serviceName'"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"IHS"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasWebServerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(WasWebServerType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_Type()
	 * @model default="IHS" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	WasWebServerType getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(WasWebServerType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(WasWebServerType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(WasWebServerType)
	 * @generated
	 */
	boolean isSetType();

	/**
	 * Returns the value of the '<em><b>Use Secure Protocol</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Secure Protocol</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Secure Protocol</em>' attribute.
	 * @see #isSetUseSecureProtocol()
	 * @see #unsetUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServer_UseSecureProtocol()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='useSecureProtocol'"
	 * @generated
	 */
	boolean isUseSecureProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Secure Protocol</em>' attribute.
	 * @see #isSetUseSecureProtocol()
	 * @see #unsetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @generated
	 */
	void setUseSecureProtocol(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @generated
	 */
	void unsetUseSecureProtocol();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebServer#isUseSecureProtocol <em>Use Secure Protocol</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Secure Protocol</em>' attribute is set.
	 * @see #unsetUseSecureProtocol()
	 * @see #isUseSecureProtocol()
	 * @see #setUseSecureProtocol(boolean)
	 * @generated
	 */
	boolean isSetUseSecureProtocol();

} // WasWebServer
