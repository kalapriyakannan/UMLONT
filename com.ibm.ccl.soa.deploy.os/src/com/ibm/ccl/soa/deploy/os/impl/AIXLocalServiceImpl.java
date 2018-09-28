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
import com.ibm.ccl.soa.deploy.os.AIXLocalService;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>AIX Local Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#getActionType <em>Action Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#getExecutablePath <em>Executable Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelEight <em>Startup Run Level Eight</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelFive <em>Startup Run Level Five</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelFour <em>Startup Run Level Four</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelNine <em>Startup Run Level Nine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelOne <em>Startup Run Level One</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelSix <em>Startup Run Level Six</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelThree <em>Startup Run Level Three</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelTwo <em>Startup Run Level Two</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl#isStartupRunLevelZero <em>Startup Run Level Zero</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIXLocalServiceImpl extends CapabilityImpl implements AIXLocalService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getActionType() <em>Action Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionType() <em>Action Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
	protected String actionType = ACTION_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #isStartupRunLevelEight() <em>Startup Run Level Eight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelEight()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_EIGHT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelEight() <em>Startup Run Level Eight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelEight()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelEight = STARTUP_RUN_LEVEL_EIGHT_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Eight attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelEightESet;

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
	 * The default value of the '{@link #isStartupRunLevelNine() <em>Startup Run Level Nine</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelNine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_NINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelNine() <em>Startup Run Level Nine</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelNine()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelNine = STARTUP_RUN_LEVEL_NINE_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Nine attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelNineESet;

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
	 * The default value of the '{@link #isStartupRunLevelSeven() <em>Startup Run Level Seven</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelSeven()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STARTUP_RUN_LEVEL_SEVEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStartupRunLevelSeven() <em>Startup Run Level Seven</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isStartupRunLevelSeven()
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelSeven = STARTUP_RUN_LEVEL_SEVEN_EDEFAULT;

	/**
	 * This is true if the Startup Run Level Seven attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startupRunLevelSevenESet;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AIXLocalServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.AIX_LOCAL_SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionType(String newActionType) {
		String oldActionType = actionType;
		actionType = newActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_SERVICE__ACTION_TYPE, oldActionType, actionType));
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
					OsPackage.AIX_LOCAL_SERVICE__EXECUTABLE_PATH, oldExecutablePath, executablePath));
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
					OsPackage.AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION, oldServiceDescription,
					serviceDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartupRunLevelEight() {
		return startupRunLevelEight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelEight(boolean newStartupRunLevelEight) {
		boolean oldStartupRunLevelEight = startupRunLevelEight;
		startupRunLevelEight = newStartupRunLevelEight;
		boolean oldStartupRunLevelEightESet = startupRunLevelEightESet;
		startupRunLevelEightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT, oldStartupRunLevelEight,
					startupRunLevelEight, !oldStartupRunLevelEightESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelEight() {
		boolean oldStartupRunLevelEight = startupRunLevelEight;
		boolean oldStartupRunLevelEightESet = startupRunLevelEightESet;
		startupRunLevelEight = STARTUP_RUN_LEVEL_EIGHT_EDEFAULT;
		startupRunLevelEightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT, oldStartupRunLevelEight,
					STARTUP_RUN_LEVEL_EIGHT_EDEFAULT, oldStartupRunLevelEightESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelEight() {
		return startupRunLevelEightESet;
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE, oldStartupRunLevelFive,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE, oldStartupRunLevelFive,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR, oldStartupRunLevelFour,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR, oldStartupRunLevelFour,
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
	public boolean isStartupRunLevelNine() {
		return startupRunLevelNine;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelNine(boolean newStartupRunLevelNine) {
		boolean oldStartupRunLevelNine = startupRunLevelNine;
		startupRunLevelNine = newStartupRunLevelNine;
		boolean oldStartupRunLevelNineESet = startupRunLevelNineESet;
		startupRunLevelNineESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE, oldStartupRunLevelNine,
					startupRunLevelNine, !oldStartupRunLevelNineESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelNine() {
		boolean oldStartupRunLevelNine = startupRunLevelNine;
		boolean oldStartupRunLevelNineESet = startupRunLevelNineESet;
		startupRunLevelNine = STARTUP_RUN_LEVEL_NINE_EDEFAULT;
		startupRunLevelNineESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE, oldStartupRunLevelNine,
					STARTUP_RUN_LEVEL_NINE_EDEFAULT, oldStartupRunLevelNineESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelNine() {
		return startupRunLevelNineESet;
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE, oldStartupRunLevelOne,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE, oldStartupRunLevelOne,
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
	public boolean isStartupRunLevelSeven() {
		return startupRunLevelSeven;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartupRunLevelSeven(boolean newStartupRunLevelSeven) {
		boolean oldStartupRunLevelSeven = startupRunLevelSeven;
		startupRunLevelSeven = newStartupRunLevelSeven;
		boolean oldStartupRunLevelSevenESet = startupRunLevelSevenESet;
		startupRunLevelSevenESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN, oldStartupRunLevelSeven,
					startupRunLevelSeven, !oldStartupRunLevelSevenESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartupRunLevelSeven() {
		boolean oldStartupRunLevelSeven = startupRunLevelSeven;
		boolean oldStartupRunLevelSevenESet = startupRunLevelSevenESet;
		startupRunLevelSeven = STARTUP_RUN_LEVEL_SEVEN_EDEFAULT;
		startupRunLevelSevenESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN, oldStartupRunLevelSeven,
					STARTUP_RUN_LEVEL_SEVEN_EDEFAULT, oldStartupRunLevelSevenESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartupRunLevelSeven() {
		return startupRunLevelSevenESet;
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX, oldStartupRunLevelSix,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX, oldStartupRunLevelSix,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE, oldStartupRunLevelThree,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE, oldStartupRunLevelThree,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO, oldStartupRunLevelTwo,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO, oldStartupRunLevelTwo,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO, oldStartupRunLevelZero,
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
					OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO, oldStartupRunLevelZero,
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.AIX_LOCAL_SERVICE__ACTION_TYPE:
			return getActionType();
		case OsPackage.AIX_LOCAL_SERVICE__EXECUTABLE_PATH:
			return getExecutablePath();
		case OsPackage.AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return getServiceDescription();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT:
			return isStartupRunLevelEight() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			return isStartupRunLevelFive() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			return isStartupRunLevelFour() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE:
			return isStartupRunLevelNine() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			return isStartupRunLevelOne() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN:
			return isStartupRunLevelSeven() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			return isStartupRunLevelSix() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			return isStartupRunLevelThree() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			return isStartupRunLevelTwo() ? Boolean.TRUE : Boolean.FALSE;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			return isStartupRunLevelZero() ? Boolean.TRUE : Boolean.FALSE;
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
		case OsPackage.AIX_LOCAL_SERVICE__ACTION_TYPE:
			setActionType((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT:
			setStartupRunLevelEight(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			setStartupRunLevelFive(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			setStartupRunLevelFour(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE:
			setStartupRunLevelNine(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			setStartupRunLevelOne(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN:
			setStartupRunLevelSeven(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			setStartupRunLevelSix(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			setStartupRunLevelThree(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			setStartupRunLevelTwo(((Boolean) newValue).booleanValue());
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			setStartupRunLevelZero(((Boolean) newValue).booleanValue());
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
		case OsPackage.AIX_LOCAL_SERVICE__ACTION_TYPE:
			setActionType(ACTION_TYPE_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__EXECUTABLE_PATH:
			setExecutablePath(EXECUTABLE_PATH_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			setServiceDescription(SERVICE_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT:
			unsetStartupRunLevelEight();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			unsetStartupRunLevelFive();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			unsetStartupRunLevelFour();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE:
			unsetStartupRunLevelNine();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			unsetStartupRunLevelOne();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN:
			unsetStartupRunLevelSeven();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			unsetStartupRunLevelSix();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			unsetStartupRunLevelThree();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			unsetStartupRunLevelTwo();
			return;
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			unsetStartupRunLevelZero();
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
		case OsPackage.AIX_LOCAL_SERVICE__ACTION_TYPE:
			return ACTION_TYPE_EDEFAULT == null ? actionType != null : !ACTION_TYPE_EDEFAULT
					.equals(actionType);
		case OsPackage.AIX_LOCAL_SERVICE__EXECUTABLE_PATH:
			return EXECUTABLE_PATH_EDEFAULT == null ? executablePath != null
					: !EXECUTABLE_PATH_EDEFAULT.equals(executablePath);
		case OsPackage.AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
			return SERVICE_DESCRIPTION_EDEFAULT == null ? serviceDescription != null
					: !SERVICE_DESCRIPTION_EDEFAULT.equals(serviceDescription);
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT:
			return isSetStartupRunLevelEight();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
			return isSetStartupRunLevelFive();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
			return isSetStartupRunLevelFour();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE:
			return isSetStartupRunLevelNine();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
			return isSetStartupRunLevelOne();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN:
			return isSetStartupRunLevelSeven();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
			return isSetStartupRunLevelSix();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
			return isSetStartupRunLevelThree();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
			return isSetStartupRunLevelTwo();
		case OsPackage.AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
			return isSetStartupRunLevelZero();
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
		result.append(" (actionType: "); //$NON-NLS-1$
		result.append(actionType);
		result.append(", executablePath: "); //$NON-NLS-1$
		result.append(executablePath);
		result.append(", serviceDescription: "); //$NON-NLS-1$
		result.append(serviceDescription);
		result.append(", startupRunLevelEight: "); //$NON-NLS-1$
		if (startupRunLevelEightESet)
			result.append(startupRunLevelEight);
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
		result.append(", startupRunLevelNine: "); //$NON-NLS-1$
		if (startupRunLevelNineESet)
			result.append(startupRunLevelNine);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelOne: "); //$NON-NLS-1$
		if (startupRunLevelOneESet)
			result.append(startupRunLevelOne);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", startupRunLevelSeven: "); //$NON-NLS-1$
		if (startupRunLevelSevenESet)
			result.append(startupRunLevelSeven);
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
		result.append(')');
		return result.toString();
	}

} //AIXLocalServiceImpl
