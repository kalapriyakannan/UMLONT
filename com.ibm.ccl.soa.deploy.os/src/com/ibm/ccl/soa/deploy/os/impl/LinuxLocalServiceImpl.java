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
import com.ibm.ccl.soa.deploy.os.LinuxLocalService;
import com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType;
import com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Linux Local Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getExecutablePath <em>Executable Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getServiceAccount <em>Service Account</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getServiceStatus <em>Service Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelFive <em>Startup Run Level Five</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelFour <em>Startup Run Level Four</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelOne <em>Startup Run Level One</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelSix <em>Startup Run Level Six</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelThree <em>Startup Run Level Three</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelTwo <em>Startup Run Level Two</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#isStartupRunLevelZero <em>Startup Run Level Zero</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl#getStartupType <em>Startup Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinuxLocalServiceImpl extends CapabilityImpl implements LinuxLocalService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	protected static final LinuxServiceStatusType SERVICE_STATUS_EDEFAULT = LinuxServiceStatusType.RUNNING_LITERAL;

	/**
	 * The cached value of the '{@link #getServiceStatus() <em>Service Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServiceStatus()
	 * @generated
	 * @ordered
	 */
	protected LinuxServiceStatusType serviceStatus = SERVICE_STATUS_EDEFAULT;

	/**
	 * This is true if the Service Status attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serviceStatusESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelFive() <em>Startup Run Level Five</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelFive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_FIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelFive() <em>Startup Run Level Five</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelFive()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelFive = STARTUP_RUN_LEVEL_FIVE_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Five attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelFiveESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelFour() <em>Startup Run Level Four</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelFour()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_FOUR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelFour() <em>Startup Run Level Four</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelFour()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelFour = STARTUP_RUN_LEVEL_FOUR_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Four attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelFourESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelOne() <em>Startup Run Level One</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelOne()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_ONE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelOne() <em>Startup Run Level One</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelOne()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelOne = STARTUP_RUN_LEVEL_ONE_EDEFAULT;

	/**
	 * This is true if the Startup Run Level One attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelOneESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelSix() <em>Startup Run Level Six</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelSix()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_SIX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelSix() <em>Startup Run Level Six</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelSix()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelSix = STARTUP_RUN_LEVEL_SIX_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Six attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelSixESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelThree() <em>Startup Run Level Three</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelThree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_THREE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelThree() <em>Startup Run Level Three</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelThree()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelThree = STARTUP_RUN_LEVEL_THREE_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Three attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelThreeESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelTwo() <em>Startup Run Level Two</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelTwo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_TWO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelTwo() <em>Startup Run Level Two</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelTwo()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelTwo = STARTUP_RUN_LEVEL_TWO_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Two attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelTwoESet;

	/**
	 * The default value of the '{@link #isStartupRunLevelZero() <em>Startup Run Level Zero</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelZero()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_ZERO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelZero() <em>Startup Run Level Zero</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelZero()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelZero = STARTUP_RUN_LEVEL_ZERO_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Zero attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelZeroESet;

	/**
	 * The default value of the '{@link #getStartupType() <em>Startup Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartupType()
	 * @generated
	 * @ordered
	 */
	protected static final LinuxServiceStartupTypeType STARTUP_TYPE_EDEFAULT = LinuxServiceStartupTypeType.AUTOMATIC_LITERAL;

	/**
	 * The cached value of the '{@link #getStartupType() <em>Startup Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartupType()
	 * @generated
	 * @ordered
	 */
	protected LinuxServiceStartupTypeType startupType = STARTUP_TYPE_EDEFAULT;

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
	protected LinuxLocalServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.LINUX_LOCAL_SERVICE;
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
					OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH, oldExecutablePath, executablePath));
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
					OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT, oldServiceAccount, serviceAccount));
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
					OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION, oldServiceDescription,
					serviceDescription));
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
					OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStatusType getServiceStatus() {
		return serviceStatus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceStatus(LinuxServiceStatusType newServiceStatus) {
		LinuxServiceStatusType oldServiceStatus = serviceStatus;
		serviceStatus = newServiceStatus == null ? SERVICE_STATUS_EDEFAULT : newServiceStatus;
		boolean oldServiceStatusESet = serviceStatusESet;
		serviceStatusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS, oldServiceStatus, serviceStatus,
					!oldServiceStatusESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServiceStatus() {
		LinuxServiceStatusType oldServiceStatus = serviceStatus;
		boolean oldServiceStatusESet = serviceStatusESet;
		serviceStatus = SERVICE_STATUS_EDEFAULT;
		serviceStatusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS, oldServiceStatus,
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
	public boolean isStartupRunLevelFive() {
		return startupRunLevelFive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelFive(boolean newStartupRunLevelFive) {
		boolean oldStartupRunLevelFive = startupRunLevelFive;
		startupRunLevelFive = newStartupRunLevelFive;
		boolean oldStartupRunLevelFiveESet = startupRunLevelFiveESet;
		startupRunLevelFiveESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE, oldStartupRunLevelFive,
					startupRunLevelFive, !oldStartupRunLevelFiveESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelFive() {
		boolean oldStartupRunLevelFive = startupRunLevelFive;
		boolean oldStartupRunLevelFiveESet = startupRunLevelFiveESet;
		startupRunLevelFive = STARTUP_RUN_LEVEL_FIVE_EDEFAULT;
		startupRunLevelFiveESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE, oldStartupRunLevelFive,
					STARTUP_RUN_LEVEL_FIVE_EDEFAULT, oldStartupRunLevelFiveESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelFive() {
		return startupRunLevelFiveESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelFour() {
		return startupRunLevelFour;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelFour(boolean newStartupRunLevelFour) {
		boolean oldStartupRunLevelFour = startupRunLevelFour;
		startupRunLevelFour = newStartupRunLevelFour;
		boolean oldStartupRunLevelFourESet = startupRunLevelFourESet;
		startupRunLevelFourESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR, oldStartupRunLevelFour,
					startupRunLevelFour, !oldStartupRunLevelFourESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelFour() {
		boolean oldStartupRunLevelFour = startupRunLevelFour;
		boolean oldStartupRunLevelFourESet = startupRunLevelFourESet;
		startupRunLevelFour = STARTUP_RUN_LEVEL_FOUR_EDEFAULT;
		startupRunLevelFourESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR, oldStartupRunLevelFour,
					STARTUP_RUN_LEVEL_FOUR_EDEFAULT, oldStartupRunLevelFourESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelFour() {
		return startupRunLevelFourESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelOne() {
		return startupRunLevelOne;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelOne(boolean newStartupRunLevelOne) {
		boolean oldStartupRunLevelOne = startupRunLevelOne;
		startupRunLevelOne = newStartupRunLevelOne;
		boolean oldStartupRunLevelOneESet = startupRunLevelOneESet;
		startupRunLevelOneESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE, oldStartupRunLevelOne,
					startupRunLevelOne, !oldStartupRunLevelOneESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelOne() {
		boolean oldStartupRunLevelOne = startupRunLevelOne;
		boolean oldStartupRunLevelOneESet = startupRunLevelOneESet;
		startupRunLevelOne = STARTUP_RUN_LEVEL_ONE_EDEFAULT;
		startupRunLevelOneESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE, oldStartupRunLevelOne,
					STARTUP_RUN_LEVEL_ONE_EDEFAULT, oldStartupRunLevelOneESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelOne() {
		return startupRunLevelOneESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelSix() {
		return startupRunLevelSix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelSix(boolean newStartupRunLevelSix) {
		boolean oldStartupRunLevelSix = startupRunLevelSix;
		startupRunLevelSix = newStartupRunLevelSix;
		boolean oldStartupRunLevelSixESet = startupRunLevelSixESet;
		startupRunLevelSixESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX, oldStartupRunLevelSix,
					startupRunLevelSix, !oldStartupRunLevelSixESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelSix() {
		boolean oldStartupRunLevelSix = startupRunLevelSix;
		boolean oldStartupRunLevelSixESet = startupRunLevelSixESet;
		startupRunLevelSix = STARTUP_RUN_LEVEL_SIX_EDEFAULT;
		startupRunLevelSixESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX, oldStartupRunLevelSix,
					STARTUP_RUN_LEVEL_SIX_EDEFAULT, oldStartupRunLevelSixESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelSix() {
		return startupRunLevelSixESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelThree() {
		return startupRunLevelThree;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelThree(boolean newStartupRunLevelThree) {
		boolean oldStartupRunLevelThree = startupRunLevelThree;
		startupRunLevelThree = newStartupRunLevelThree;
		boolean oldStartupRunLevelThreeESet = startupRunLevelThreeESet;
		startupRunLevelThreeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE, oldStartupRunLevelThree,
					startupRunLevelThree, !oldStartupRunLevelThreeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelThree() {
		boolean oldStartupRunLevelThree = startupRunLevelThree;
		boolean oldStartupRunLevelThreeESet = startupRunLevelThreeESet;
		startupRunLevelThree = STARTUP_RUN_LEVEL_THREE_EDEFAULT;
		startupRunLevelThreeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE, oldStartupRunLevelThree,
					STARTUP_RUN_LEVEL_THREE_EDEFAULT, oldStartupRunLevelThreeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelThree() {
		return startupRunLevelThreeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelTwo() {
		return startupRunLevelTwo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelTwo(boolean newStartupRunLevelTwo) {
		boolean oldStartupRunLevelTwo = startupRunLevelTwo;
		startupRunLevelTwo = newStartupRunLevelTwo;
		boolean oldStartupRunLevelTwoESet = startupRunLevelTwoESet;
		startupRunLevelTwoESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO, oldStartupRunLevelTwo,
					startupRunLevelTwo, !oldStartupRunLevelTwoESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelTwo() {
		boolean oldStartupRunLevelTwo = startupRunLevelTwo;
		boolean oldStartupRunLevelTwoESet = startupRunLevelTwoESet;
		startupRunLevelTwo = STARTUP_RUN_LEVEL_TWO_EDEFAULT;
		startupRunLevelTwoESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO, oldStartupRunLevelTwo,
					STARTUP_RUN_LEVEL_TWO_EDEFAULT, oldStartupRunLevelTwoESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelTwo() {
		return startupRunLevelTwoESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelZero() {
		return startupRunLevelZero;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelZero(boolean newStartupRunLevelZero) {
		boolean oldStartupRunLevelZero = startupRunLevelZero;
		startupRunLevelZero = newStartupRunLevelZero;
		boolean oldStartupRunLevelZeroESet = startupRunLevelZeroESet;
		startupRunLevelZeroESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO, oldStartupRunLevelZero,
					startupRunLevelZero, !oldStartupRunLevelZeroESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelZero() {
		boolean oldStartupRunLevelZero = startupRunLevelZero;
		boolean oldStartupRunLevelZeroESet = startupRunLevelZeroESet;
		startupRunLevelZero = STARTUP_RUN_LEVEL_ZERO_EDEFAULT;
		startupRunLevelZeroESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO, oldStartupRunLevelZero,
					STARTUP_RUN_LEVEL_ZERO_EDEFAULT, oldStartupRunLevelZeroESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelZero() {
		return startupRunLevelZeroESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LinuxServiceStartupTypeType getStartupType() {
		return startupType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupType(LinuxServiceStartupTypeType newStartupType) {
		LinuxServiceStartupTypeType oldStartupType = startupType;
		startupType = newStartupType == null ? STARTUP_TYPE_EDEFAULT : newStartupType;
		boolean oldStartupTypeESet = startupTypeESet;
		startupTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE, oldStartupType, startupType,
					!oldStartupTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupType() {
		LinuxServiceStartupTypeType oldStartupType = startupType;
		boolean oldStartupTypeESet = startupTypeESet;
		startupType = STARTUP_TYPE_EDEFAULT;
		startupTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE, oldStartupType, STARTUP_TYPE_EDEFAULT,
					oldStartupTypeESet));
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
		case OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH:
			return getExecutablePath();
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT:
			return getServiceAccount();
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return getServiceDescription();
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME:
			return getServiceName();
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS:
			return getServiceStatus();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			return isStartupRunLevelFive() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			return isStartupRunLevelFour() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			return isStartupRunLevelOne() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			return isStartupRunLevelSix() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			return isStartupRunLevelThree() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			return isStartupRunLevelTwo() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			return isStartupRunLevelZero() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE:
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
		case OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT:
			setServiceAccount((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME:
			setServiceName((String) newValue);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS:
			setServiceStatus((LinuxServiceStatusType) newValue);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			setStartupRunLevelFive(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			setStartupRunLevelFour(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			setStartupRunLevelOne(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			setStartupRunLevelSix(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			setStartupRunLevelThree(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			setStartupRunLevelTwo(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			setStartupRunLevelZero(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE:
			setStartupType((LinuxServiceStartupTypeType) newValue);
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
		case OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath(EXECUTABLE_PATH_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT:
			setServiceAccount(SERVICE_ACCOUNT_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription(SERVICE_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME:
			setServiceName(SERVICE_NAME_EDEFAULT);
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS:
			unsetServiceStatus();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			unsetStartupRunLevelFive();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			unsetStartupRunLevelFour();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			unsetStartupRunLevelOne();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			unsetStartupRunLevelSix();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			unsetStartupRunLevelThree();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			unsetStartupRunLevelTwo();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			unsetStartupRunLevelZero();
			return;
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE:
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
		case OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH:
			return EXECUTABLE_PATH_EDEFAULT == null ? executablePath != null
					: !EXECUTABLE_PATH_EDEFAULT.equals(executablePath);
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT:
			return SERVICE_ACCOUNT_EDEFAULT == null ? serviceAccount != null
					: !SERVICE_ACCOUNT_EDEFAULT.equals(serviceAccount);
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return SERVICE_DESCRIPTION_EDEFAULT == null ? serviceDescription != null
					: !SERVICE_DESCRIPTION_EDEFAULT.equals(serviceDescription);
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME:
			return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT
					.equals(serviceName);
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS:
			return isSetServiceStatus();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			return isSetStartupRunLevelFive();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			return isSetStartupRunLevelFour();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			return isSetStartupRunLevelOne();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			return isSetStartupRunLevelSix();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			return isSetStartupRunLevelThree();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			return isSetStartupRunLevelTwo();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			return isSetStartupRunLevelZero();
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE:
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
		result.append(" (executablePath: "); //$NON-NLS-1$
		result.append(executablePath);
		result.append(", serviceAccount: "); //$NON-NLS-1$
		result.append(serviceAccount);
		result.append(", serviceDescription: "); //$NON-NLS-1$
		result.append(serviceDescription);
		result.append(", serviceName: "); //$NON-NLS-1$
		result.append(serviceName);
		result.append(", serviceStatus: "); //$NON-NLS-1$
		if (serviceStatusESet)
			result.append(serviceStatus);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelFive: "); //$NON-NLS-1$
		if (startupRunLevelFiveESet)
			result.append(startupRunLevelFive);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelFour: "); //$NON-NLS-1$
		if (startupRunLevelFourESet)
			result.append(startupRunLevelFour);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelOne: "); //$NON-NLS-1$
		if (startupRunLevelOneESet)
			result.append(startupRunLevelOne);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelSix: "); //$NON-NLS-1$
		if (startupRunLevelSixESet)
			result.append(startupRunLevelSix);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelThree: "); //$NON-NLS-1$
		if (startupRunLevelThreeESet)
			result.append(startupRunLevelThree);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelTwo: "); //$NON-NLS-1$
		if (startupRunLevelTwoESet)
			result.append(startupRunLevelTwo);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelZero: "); //$NON-NLS-1$
		if (startupRunLevelZeroESet)
			result.append(startupRunLevelZero);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupType: "); //$NON-NLS-1$
		if (startupTypeESet)
			result.append(startupType);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //LinuxLocalServiceImpl
