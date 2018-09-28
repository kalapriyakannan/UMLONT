/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasApplicationMap;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerOS;
import com.ibm.ccl.soa.deploy.was.WasWebServerType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getConfigFile <em>Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getLogFileAccess <em>Log File Access</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getLogFileError <em>Log File Error</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getMapApplications <em>Map Applications</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getServerName <em>Server Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerImpl#isUseSecureProtocol <em>Use Secure Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasWebServerImpl extends CapabilityImpl implements WasWebServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getConfigFile() <em>Config File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigFile() <em>Config File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected String configFile = CONFIG_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected String installLocation = INSTALL_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogFileAccess() <em>Log File Access</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLogFileAccess()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_FILE_ACCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogFileAccess() <em>Log File Access</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLogFileAccess()
	 * @generated
	 * @ordered
	 */
	protected String logFileAccess = LOG_FILE_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogFileError() <em>Log File Error</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLogFileError()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_FILE_ERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogFileError() <em>Log File Error</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogFileError()
	 * @generated
	 * @ordered
	 */
	protected String logFileError = LOG_FILE_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMapApplications() <em>Map Applications</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapApplications()
	 * @generated
	 * @ordered
	 */
	protected static final WasApplicationMap MAP_APPLICATIONS_EDEFAULT = WasApplicationMap.MAPNONE_LITERAL;

	/**
	 * The cached value of the '{@link #getMapApplications() <em>Map Applications</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapApplications()
	 * @generated
	 * @ordered
	 */
	protected WasApplicationMap mapApplications = MAP_APPLICATIONS_EDEFAULT;

	/**
	 * This is true if the Map Applications attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean mapApplicationsESet;

	/**
	 * The default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final WasWebServerOS OPERATING_SYSTEM_EDEFAULT = WasWebServerOS.WINDOWS_LITERAL;

	/**
	 * The cached value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected WasWebServerOS operatingSystem = OPERATING_SYSTEM_EDEFAULT;

	/**
	 * This is true if the Operating System attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean operatingSystemESet;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger port = PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerName() <em>Server Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerName() <em>Server Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected String serverName = SERVER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected String serviceName = SERVICE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final WasWebServerType TYPE_EDEFAULT = WasWebServerType.IHS_LITERAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected WasWebServerType type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * The default value of the '{@link #isUseSecureProtocol() <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseSecureProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_SECURE_PROTOCOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseSecureProtocol() <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseSecureProtocol()
	 * @generated
	 * @ordered
	 */
	protected boolean useSecureProtocol = USE_SECURE_PROTOCOL_EDEFAULT;

	/**
	 * This is true if the Use Secure Protocol attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useSecureProtocolESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasWebServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_WEB_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigFile(String newConfigFile) {
		String oldConfigFile = configFile;
		configFile = newConfigFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__CONFIG_FILE, oldConfigFile, configFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallLocation() {
		return installLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallLocation(String newInstallLocation) {
		String oldInstallLocation = installLocation;
		installLocation = newInstallLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__INSTALL_LOCATION, oldInstallLocation, installLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogFileAccess() {
		return logFileAccess;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogFileAccess(String newLogFileAccess) {
		String oldLogFileAccess = logFileAccess;
		logFileAccess = newLogFileAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__LOG_FILE_ACCESS, oldLogFileAccess, logFileAccess));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogFileError() {
		return logFileError;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogFileError(String newLogFileError) {
		String oldLogFileError = logFileError;
		logFileError = newLogFileError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__LOG_FILE_ERROR, oldLogFileError, logFileError));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationMap getMapApplications() {
		return mapApplications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapApplications(WasApplicationMap newMapApplications) {
		WasApplicationMap oldMapApplications = mapApplications;
		mapApplications = newMapApplications == null ? MAP_APPLICATIONS_EDEFAULT : newMapApplications;
		boolean oldMapApplicationsESet = mapApplicationsESet;
		mapApplicationsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS, oldMapApplications, mapApplications, !oldMapApplicationsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMapApplications() {
		WasApplicationMap oldMapApplications = mapApplications;
		boolean oldMapApplicationsESet = mapApplicationsESet;
		mapApplications = MAP_APPLICATIONS_EDEFAULT;
		mapApplicationsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS, oldMapApplications, MAP_APPLICATIONS_EDEFAULT, oldMapApplicationsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMapApplications() {
		return mapApplicationsESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerOS getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingSystem(WasWebServerOS newOperatingSystem) {
		WasWebServerOS oldOperatingSystem = operatingSystem;
		operatingSystem = newOperatingSystem == null ? OPERATING_SYSTEM_EDEFAULT : newOperatingSystem;
		boolean oldOperatingSystemESet = operatingSystemESet;
		operatingSystemESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM, oldOperatingSystem, operatingSystem, !oldOperatingSystemESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOperatingSystem() {
		WasWebServerOS oldOperatingSystem = operatingSystem;
		boolean oldOperatingSystemESet = operatingSystemESet;
		operatingSystem = OPERATING_SYSTEM_EDEFAULT;
		operatingSystemESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM, oldOperatingSystem, OPERATING_SYSTEM_EDEFAULT, oldOperatingSystemESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOperatingSystem() {
		return operatingSystemESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(BigInteger newPort) {
		BigInteger oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerName(String newServerName) {
		String oldServerName = serverName;
		serverName = newServerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__SERVER_NAME, oldServerName, serverName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		String oldServiceName = serviceName;
		serviceName = newServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(WasWebServerType newType) {
		WasWebServerType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		WasWebServerType oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseSecureProtocol() {
		return useSecureProtocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseSecureProtocol(boolean newUseSecureProtocol) {
		boolean oldUseSecureProtocol = useSecureProtocol;
		useSecureProtocol = newUseSecureProtocol;
		boolean oldUseSecureProtocolESet = useSecureProtocolESet;
		useSecureProtocolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL, oldUseSecureProtocol, useSecureProtocol, !oldUseSecureProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseSecureProtocol() {
		boolean oldUseSecureProtocol = useSecureProtocol;
		boolean oldUseSecureProtocolESet = useSecureProtocolESet;
		useSecureProtocol = USE_SECURE_PROTOCOL_EDEFAULT;
		useSecureProtocolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL, oldUseSecureProtocol, USE_SECURE_PROTOCOL_EDEFAULT, oldUseSecureProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseSecureProtocol() {
		return useSecureProtocolESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER__CONFIG_FILE:
				return getConfigFile();
			case WasPackage.WAS_WEB_SERVER__HOST:
				return getHost();
			case WasPackage.WAS_WEB_SERVER__INSTALL_LOCATION:
				return getInstallLocation();
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ACCESS:
				return getLogFileAccess();
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ERROR:
				return getLogFileError();
			case WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS:
				return getMapApplications();
			case WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM:
				return getOperatingSystem();
			case WasPackage.WAS_WEB_SERVER__PORT:
				return getPort();
			case WasPackage.WAS_WEB_SERVER__SERVER_NAME:
				return getServerName();
			case WasPackage.WAS_WEB_SERVER__SERVICE_NAME:
				return getServiceName();
			case WasPackage.WAS_WEB_SERVER__TYPE:
				return getType();
			case WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL:
				return isUseSecureProtocol() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER__CONFIG_FILE:
				setConfigFile((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__HOST:
				setHost((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__INSTALL_LOCATION:
				setInstallLocation((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ACCESS:
				setLogFileAccess((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ERROR:
				setLogFileError((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS:
				setMapApplications((WasApplicationMap)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM:
				setOperatingSystem((WasWebServerOS)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__PORT:
				setPort((BigInteger)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__SERVER_NAME:
				setServerName((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__SERVICE_NAME:
				setServiceName((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__TYPE:
				setType((WasWebServerType)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL:
				setUseSecureProtocol(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER__CONFIG_FILE:
				setConfigFile(CONFIG_FILE_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__INSTALL_LOCATION:
				setInstallLocation(INSTALL_LOCATION_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ACCESS:
				setLogFileAccess(LOG_FILE_ACCESS_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ERROR:
				setLogFileError(LOG_FILE_ERROR_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS:
				unsetMapApplications();
				return;
			case WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM:
				unsetOperatingSystem();
				return;
			case WasPackage.WAS_WEB_SERVER__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__SERVER_NAME:
				setServerName(SERVER_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__SERVICE_NAME:
				setServiceName(SERVICE_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER__TYPE:
				unsetType();
				return;
			case WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL:
				unsetUseSecureProtocol();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER__CONFIG_FILE:
				return CONFIG_FILE_EDEFAULT == null ? configFile != null : !CONFIG_FILE_EDEFAULT.equals(configFile);
			case WasPackage.WAS_WEB_SERVER__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case WasPackage.WAS_WEB_SERVER__INSTALL_LOCATION:
				return INSTALL_LOCATION_EDEFAULT == null ? installLocation != null : !INSTALL_LOCATION_EDEFAULT.equals(installLocation);
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ACCESS:
				return LOG_FILE_ACCESS_EDEFAULT == null ? logFileAccess != null : !LOG_FILE_ACCESS_EDEFAULT.equals(logFileAccess);
			case WasPackage.WAS_WEB_SERVER__LOG_FILE_ERROR:
				return LOG_FILE_ERROR_EDEFAULT == null ? logFileError != null : !LOG_FILE_ERROR_EDEFAULT.equals(logFileError);
			case WasPackage.WAS_WEB_SERVER__MAP_APPLICATIONS:
				return isSetMapApplications();
			case WasPackage.WAS_WEB_SERVER__OPERATING_SYSTEM:
				return isSetOperatingSystem();
			case WasPackage.WAS_WEB_SERVER__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case WasPackage.WAS_WEB_SERVER__SERVER_NAME:
				return SERVER_NAME_EDEFAULT == null ? serverName != null : !SERVER_NAME_EDEFAULT.equals(serverName);
			case WasPackage.WAS_WEB_SERVER__SERVICE_NAME:
				return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
			case WasPackage.WAS_WEB_SERVER__TYPE:
				return isSetType();
			case WasPackage.WAS_WEB_SERVER__USE_SECURE_PROTOCOL:
				return isSetUseSecureProtocol();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (configFile: "); //$NON-NLS-1$
		result.append(configFile);
		result.append(", host: "); //$NON-NLS-1$
		result.append(host);
		result.append(", installLocation: "); //$NON-NLS-1$
		result.append(installLocation);
		result.append(", logFileAccess: "); //$NON-NLS-1$
		result.append(logFileAccess);
		result.append(", logFileError: "); //$NON-NLS-1$
		result.append(logFileError);
		result.append(", mapApplications: "); //$NON-NLS-1$
		if (mapApplicationsESet) result.append(mapApplications); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", operatingSystem: "); //$NON-NLS-1$
		if (operatingSystemESet) result.append(operatingSystem); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", serverName: "); //$NON-NLS-1$
		result.append(serverName);
		result.append(", serviceName: "); //$NON-NLS-1$
		result.append(serviceName);
		result.append(", type: "); //$NON-NLS-1$
		if (typeESet) result.append(type); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", useSecureProtocol: "); //$NON-NLS-1$
		if (useSecureProtocolESet) result.append(useSecureProtocol); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(WasPackage.eINSTANCE
			.getWasWebServer_ServerName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasWebServerImpl
