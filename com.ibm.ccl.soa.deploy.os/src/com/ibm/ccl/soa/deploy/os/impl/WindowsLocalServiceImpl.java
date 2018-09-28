/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType;
import com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows Local Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getDependantComponents <em>Dependant Components</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getErrorControl <em>Error Control</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getExecutablePath <em>Executable Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#isLogOnAsSystem <em>Log On As System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getRunProgram <em>Run Program</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceAccount <em>Service Account</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceAccountPassword <em>Service Account Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceDisplayName <em>Service Display Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getServiceStatus <em>Service Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getStartParams <em>Start Params</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl#getStartupType <em>Startup Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsLocalServiceImpl extends CapabilityImpl implements WindowsLocalService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDependantComponents() <em>Dependant Components</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependantComponents()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDANT_COMPONENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependantComponents() <em>Dependant Components</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependantComponents()
	 * @generated
	 * @ordered
	 */
	protected String dependantComponents = DEPENDANT_COMPONENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorControl() <em>Error Control</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getErrorControl()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsServiceErrorControlType ERROR_CONTROL_EDEFAULT = WindowsServiceErrorControlType.IGNORE_LITERAL;

	/**
	 * The cached value of the '{@link #getErrorControl() <em>Error Control</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getErrorControl()
	 * @generated
	 * @ordered
	 */
	protected WindowsServiceErrorControlType errorControl = ERROR_CONTROL_EDEFAULT;

	/**
	 * This is true if the Error Control attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean errorControlESet;

	/**
	 * The default value of the '{@link #getExecutablePath() <em>Executable Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExecutablePath()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTABLE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutablePath() <em>Executable Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExecutablePath()
	 * @generated
	 * @ordered
	 */
	protected String executablePath = EXECUTABLE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isLogOnAsSystem() <em>Log On As System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isLogOnAsSystem()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_ON_AS_SYSTEM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLogOnAsSystem() <em>Log On As System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isLogOnAsSystem()
	 * @generated
	 * @ordered
	 */
	protected boolean logOnAsSystem = LOG_ON_AS_SYSTEM_EDEFAULT;

	/**
	 * This is true if the Log On As System attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean logOnAsSystemESet;

	/**
	 * The default value of the '{@link #getRunProgram() <em>Run Program</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRunProgram()
	 * @generated
	 * @ordered
	 */
	protected static final String RUN_PROGRAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRunProgram() <em>Run Program</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRunProgram()
	 * @generated
	 * @ordered
	 */
	protected String runProgram = RUN_PROGRAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceAccount() <em>Service Account</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceAccount()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_ACCOUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceAccount() <em>Service Account</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceAccount()
	 * @generated
	 * @ordered
	 */
	protected String serviceAccount = SERVICE_ACCOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceAccountPassword() <em>Service Account Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceAccountPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_ACCOUNT_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceAccountPassword() <em>Service Account Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceAccountPassword()
	 * @generated
	 * @ordered
	 */
	protected String serviceAccountPassword = SERVICE_ACCOUNT_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceDependencies() <em>Service Dependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_DEPENDENCIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceDependencies() <em>Service Dependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDependencies()
	 * @generated
	 * @ordered
	 */
	protected String serviceDependencies = SERVICE_DEPENDENCIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceDescription() <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceDescription() <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDescription()
	 * @generated
	 * @ordered
	 */
	protected String serviceDescription = SERVICE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceDisplayName() <em>Service Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceDisplayName() <em>Service Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String serviceDisplayName = SERVICE_DISPLAY_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getServiceStatus() <em>Service Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceStatus()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsServiceStatusType SERVICE_STATUS_EDEFAULT = WindowsServiceStatusType.RUNNING_LITERAL;

	/**
	 * The cached value of the '{@link #getServiceStatus() <em>Service Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceStatus()
	 * @generated
	 * @ordered
	 */
	protected WindowsServiceStatusType serviceStatus = SERVICE_STATUS_EDEFAULT;

	/**
	 * This is true if the Service Status attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serviceStatusESet;

	/**
	 * The default value of the '{@link #getStartParams() <em>Start Params</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartParams()
	 * @generated
	 * @ordered
	 */
	protected static final String START_PARAMS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartParams() <em>Start Params</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartParams()
	 * @generated
	 * @ordered
	 */
	protected String startParams = START_PARAMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartupType() <em>Startup Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartupType()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsServiceStartupType STARTUP_TYPE_EDEFAULT = WindowsServiceStartupType.BOOT_LITERAL;

	/**
	 * The cached value of the '{@link #getStartupType() <em>Startup Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartupType()
	 * @generated
	 * @ordered
	 */
	protected WindowsServiceStartupType startupType = STARTUP_TYPE_EDEFAULT;

	/**
	 * This is true if the Startup Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupTypeESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsLocalServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.WINDOWS_LOCAL_SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDependantComponents() {
		return dependantComponents;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependantComponents(String newDependantComponents) {
		String oldDependantComponents = dependantComponents;
		dependantComponents = newDependantComponents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS, oldDependantComponents,
					dependantComponents));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceErrorControlType getErrorControl() {
		return errorControl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorControl(WindowsServiceErrorControlType newErrorControl) {
		WindowsServiceErrorControlType oldErrorControl = errorControl;
		errorControl = newErrorControl == null ? ERROR_CONTROL_EDEFAULT : newErrorControl;
		boolean oldErrorControlESet = errorControlESet;
		errorControlESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL, oldErrorControl, errorControl,
					!oldErrorControlESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetErrorControl() {
		WindowsServiceErrorControlType oldErrorControl = errorControl;
		boolean oldErrorControlESet = errorControlESet;
		errorControl = ERROR_CONTROL_EDEFAULT;
		errorControlESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL, oldErrorControl,
					ERROR_CONTROL_EDEFAULT, oldErrorControlESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetErrorControl() {
		return errorControlESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutablePath() {
		return executablePath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutablePath(String newExecutablePath) {
		String oldExecutablePath = executablePath;
		executablePath = newExecutablePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH, oldExecutablePath, executablePath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogOnAsSystem() {
		return logOnAsSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogOnAsSystem(boolean newLogOnAsSystem) {
		boolean oldLogOnAsSystem = logOnAsSystem;
		logOnAsSystem = newLogOnAsSystem;
		boolean oldLogOnAsSystemESet = logOnAsSystemESet;
		logOnAsSystemESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM, oldLogOnAsSystem, logOnAsSystem,
					!oldLogOnAsSystemESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLogOnAsSystem() {
		boolean oldLogOnAsSystem = logOnAsSystem;
		boolean oldLogOnAsSystemESet = logOnAsSystemESet;
		logOnAsSystem = LOG_ON_AS_SYSTEM_EDEFAULT;
		logOnAsSystemESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM, oldLogOnAsSystem,
					LOG_ON_AS_SYSTEM_EDEFAULT, oldLogOnAsSystemESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLogOnAsSystem() {
		return logOnAsSystemESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRunProgram() {
		return runProgram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunProgram(String newRunProgram) {
		String oldRunProgram = runProgram;
		runProgram = newRunProgram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__RUN_PROGRAM, oldRunProgram, runProgram));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceAccount() {
		return serviceAccount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceAccount(String newServiceAccount) {
		String oldServiceAccount = serviceAccount;
		serviceAccount = newServiceAccount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT, oldServiceAccount, serviceAccount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceAccountPassword() {
		return serviceAccountPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceAccountPassword(String newServiceAccountPassword) {
		String oldServiceAccountPassword = serviceAccountPassword;
		serviceAccountPassword = newServiceAccountPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD,
					oldServiceAccountPassword, serviceAccountPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDependencies() {
		return serviceDependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDependencies(String newServiceDependencies) {
		String oldServiceDependencies = serviceDependencies;
		serviceDependencies = newServiceDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES, oldServiceDependencies,
					serviceDependencies));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDescription(String newServiceDescription) {
		String oldServiceDescription = serviceDescription;
		serviceDescription = newServiceDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION, oldServiceDescription,
					serviceDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDisplayName() {
		return serviceDisplayName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDisplayName(String newServiceDisplayName) {
		String oldServiceDisplayName = serviceDisplayName;
		serviceDisplayName = newServiceDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME, oldServiceDisplayName,
					serviceDisplayName));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStatusType getServiceStatus() {
		return serviceStatus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceStatus(WindowsServiceStatusType newServiceStatus) {
		WindowsServiceStatusType oldServiceStatus = serviceStatus;
		serviceStatus = newServiceStatus == null ? SERVICE_STATUS_EDEFAULT : newServiceStatus;
		boolean oldServiceStatusESet = serviceStatusESet;
		serviceStatusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS, oldServiceStatus, serviceStatus,
					!oldServiceStatusESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServiceStatus() {
		WindowsServiceStatusType oldServiceStatus = serviceStatus;
		boolean oldServiceStatusESet = serviceStatusESet;
		serviceStatus = SERVICE_STATUS_EDEFAULT;
		serviceStatusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS, oldServiceStatus,
					SERVICE_STATUS_EDEFAULT, oldServiceStatusESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServiceStatus() {
		return serviceStatusESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartParams() {
		return startParams;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParams(String newStartParams) {
		String oldStartParams = startParams;
		startParams = newStartParams;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__START_PARAMS, oldStartParams, startParams));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsServiceStartupType getStartupType() {
		return startupType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupType(WindowsServiceStartupType newStartupType) {
		WindowsServiceStartupType oldStartupType = startupType;
		startupType = newStartupType == null ? STARTUP_TYPE_EDEFAULT : newStartupType;
		boolean oldStartupTypeESet = startupTypeESet;
		startupTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE, oldStartupType, startupType,
					!oldStartupTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupType() {
		WindowsServiceStartupType oldStartupType = startupType;
		boolean oldStartupTypeESet = startupTypeESet;
		startupType = STARTUP_TYPE_EDEFAULT;
		startupTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE, oldStartupType,
					STARTUP_TYPE_EDEFAULT, oldStartupTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupType() {
		return startupTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS:
			return getDependantComponents();
		case OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL:
			return getErrorControl();
		case OsPackage.WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH:
			return getExecutablePath();
		case OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM:
			return isLogOnAsSystem() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.WINDOWS_LOCAL_SERVICE__RUN_PROGRAM:
			return getRunProgram();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT:
			return getServiceAccount();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD:
			return getServiceAccountPassword();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES:
			return getServiceDependencies();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return getServiceDescription();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME:
			return getServiceDisplayName();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_NAME:
			return getServiceName();
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS:
			return getServiceStatus();
		case OsPackage.WINDOWS_LOCAL_SERVICE__START_PARAMS:
			return getStartParams();
		case OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE:
			return getStartupType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS:
			setDependantComponents((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL:
			setErrorControl((WindowsServiceErrorControlType) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM:
			setLogOnAsSystem(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__RUN_PROGRAM:
			setRunProgram((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT:
			setServiceAccount((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD:
			setServiceAccountPassword((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES:
			setServiceDependencies((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME:
			setServiceDisplayName((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_NAME:
			setServiceName((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS:
			setServiceStatus((WindowsServiceStatusType) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__START_PARAMS:
			setStartParams((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE:
			setStartupType((WindowsServiceStartupType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS:
			setDependantComponents(DEPENDANT_COMPONENTS_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL:
			unsetErrorControl();
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath(EXECUTABLE_PATH_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM:
			unsetLogOnAsSystem();
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__RUN_PROGRAM:
			setRunProgram(RUN_PROGRAM_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT:
			setServiceAccount(SERVICE_ACCOUNT_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD:
			setServiceAccountPassword(SERVICE_ACCOUNT_PASSWORD_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES:
			setServiceDependencies(SERVICE_DEPENDENCIES_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription(SERVICE_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME:
			setServiceDisplayName(SERVICE_DISPLAY_NAME_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_NAME:
			setServiceName(SERVICE_NAME_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS:
			unsetServiceStatus();
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__START_PARAMS:
			setStartParams(START_PARAMS_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE:
			unsetStartupType();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS:
			return DEPENDANT_COMPONENTS_EDEFAULT == null ? dependantComponents != null
					: !DEPENDANT_COMPONENTS_EDEFAULT.equals(dependantComponents);
		case OsPackage.WINDOWS_LOCAL_SERVICE__ERROR_CONTROL:
			return isSetErrorControl();
		case OsPackage.WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH:
			return EXECUTABLE_PATH_EDEFAULT == null ? executablePath != null
					: !EXECUTABLE_PATH_EDEFAULT.equals(executablePath);
		case OsPackage.WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM:
			return isSetLogOnAsSystem();
		case OsPackage.WINDOWS_LOCAL_SERVICE__RUN_PROGRAM:
			return RUN_PROGRAM_EDEFAULT == null ? runProgram != null : !RUN_PROGRAM_EDEFAULT
					.equals(runProgram);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT:
			return SERVICE_ACCOUNT_EDEFAULT == null ? serviceAccount != null
					: !SERVICE_ACCOUNT_EDEFAULT.equals(serviceAccount);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD:
			return SERVICE_ACCOUNT_PASSWORD_EDEFAULT == null ? serviceAccountPassword != null
					: !SERVICE_ACCOUNT_PASSWORD_EDEFAULT.equals(serviceAccountPassword);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES:
			return SERVICE_DEPENDENCIES_EDEFAULT == null ? serviceDependencies != null
					: !SERVICE_DEPENDENCIES_EDEFAULT.equals(serviceDependencies);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return SERVICE_DESCRIPTION_EDEFAULT == null ? serviceDescription != null
					: !SERVICE_DESCRIPTION_EDEFAULT.equals(serviceDescription);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME:
			return SERVICE_DISPLAY_NAME_EDEFAULT == null ? serviceDisplayName != null
					: !SERVICE_DISPLAY_NAME_EDEFAULT.equals(serviceDisplayName);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_NAME:
			return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT
					.equals(serviceName);
		case OsPackage.WINDOWS_LOCAL_SERVICE__SERVICE_STATUS:
			return isSetServiceStatus();
		case OsPackage.WINDOWS_LOCAL_SERVICE__START_PARAMS:
			return START_PARAMS_EDEFAULT == null ? startParams != null : !START_PARAMS_EDEFAULT
					.equals(startParams);
		case OsPackage.WINDOWS_LOCAL_SERVICE__STARTUP_TYPE:
			return isSetStartupType();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dependantComponents: "); //$NON-NLS-1$
		result.append(dependantComponents);
		result.append(", errorControl: "); //$NON-NLS-1$
		if (errorControlESet)
			result.append(errorControl);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", executablePath: "); //$NON-NLS-1$
		result.append(executablePath);
		result.append(", logOnAsSystem: "); //$NON-NLS-1$
		if (logOnAsSystemESet)
			result.append(logOnAsSystem);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", runProgram: "); //$NON-NLS-1$
		result.append(runProgram);
		result.append(", serviceAccount: "); //$NON-NLS-1$
		result.append(serviceAccount);
		result.append(", serviceAccountPassword: "); //$NON-NLS-1$
		result.append(serviceAccountPassword);
		result.append(", serviceDependencies: "); //$NON-NLS-1$
		result.append(serviceDependencies);
		result.append(", serviceDescription: "); //$NON-NLS-1$
		result.append(serviceDescription);
		result.append(", serviceDisplayName: "); //$NON-NLS-1$
		result.append(serviceDisplayName);
		result.append(", serviceName: "); //$NON-NLS-1$
		result.append(serviceName);
		result.append(", serviceStatus: "); //$NON-NLS-1$
		if (serviceStatusESet)
			result.append(serviceStatus);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startParams: "); //$NON-NLS-1$
		result.append(startParams);
		result.append(", startupType: "); //$NON-NLS-1$
		if (startupTypeESet)
			result.append(startupType);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WindowsLocalServiceImpl
