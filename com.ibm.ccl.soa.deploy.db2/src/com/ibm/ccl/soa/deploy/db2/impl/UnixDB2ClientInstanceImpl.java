/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WordWidthType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unix DB2 Client Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getAuthenticationType <em>Authentication Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getFencedGID <em>Fenced GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getFencedGroupName <em>Fenced Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getFencedUID <em>Fenced UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getFencedUserName <em>Fenced User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getFencedUserPassword <em>Fenced User Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getGID <em>GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getGroupName <em>Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getInstanceType <em>Instance Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getUID <em>UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl#getWordWidth <em>Word Width</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnixDB2ClientInstanceImpl extends DB2ClientInstanceImpl implements
		UnixDB2ClientInstance {
	/**
	 * The default value of the '{@link #getAuthenticationType() <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAuthenticationType()
	 * @generated
	 * @ordered
	 */
	protected static final AuthenticationTypeType AUTHENTICATION_TYPE_EDEFAULT = AuthenticationTypeType.SERVER_LITERAL;

	/**
	 * The cached value of the '{@link #getAuthenticationType() <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAuthenticationType()
	 * @generated
	 * @ordered
	 */
	protected AuthenticationTypeType authenticationType = AUTHENTICATION_TYPE_EDEFAULT;

	/**
	 * This is true if the Authentication Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean authenticationTypeESet;

	/**
	 * The default value of the '{@link #getFencedGID() <em>Fenced GID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFencedGID()
	 * @generated
	 * @ordered
	 */
	protected static final String FENCED_GID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFencedGID() <em>Fenced GID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFencedGID()
	 * @generated
	 * @ordered
	 */
	protected String fencedGID = FENCED_GID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFencedGroupName() <em>Fenced Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String FENCED_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFencedGroupName() <em>Fenced Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedGroupName()
	 * @generated
	 * @ordered
	 */
	protected String fencedGroupName = FENCED_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFencedUID() <em>Fenced UID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFencedUID()
	 * @generated
	 * @ordered
	 */
	protected static final String FENCED_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFencedUID() <em>Fenced UID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFencedUID()
	 * @generated
	 * @ordered
	 */
	protected String fencedUID = FENCED_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFencedUserName() <em>Fenced User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String FENCED_USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFencedUserName() <em>Fenced User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedUserName()
	 * @generated
	 * @ordered
	 */
	protected String fencedUserName = FENCED_USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFencedUserPassword() <em>Fenced User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedUserPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String FENCED_USER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFencedUserPassword() <em>Fenced User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFencedUserPassword()
	 * @generated
	 * @ordered
	 */
	protected String fencedUserPassword = FENCED_USER_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getGID() <em>GID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGID()
	 * @generated
	 * @ordered
	 */
	protected static final String GID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGID() <em>GID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGID()
	 * @generated
	 * @ordered
	 */
	protected String gID = GID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupName() <em>Group Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupName() <em>Group Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupName()
	 * @generated
	 * @ordered
	 */
	protected String groupName = GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceType() <em>Instance Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceType()
	 * @generated
	 * @ordered
	 */
	protected static final UnixInstanceTypeType INSTANCE_TYPE_EDEFAULT = UnixInstanceTypeType.CLIENT_LITERAL;

	/**
	 * The cached value of the '{@link #getInstanceType() <em>Instance Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceType()
	 * @generated
	 * @ordered
	 */
	protected UnixInstanceTypeType instanceType = INSTANCE_TYPE_EDEFAULT;

	/**
	 * This is true if the Instance Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean instanceTypeESet;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getUID() <em>UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUID()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUID() <em>UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUID()
	 * @generated
	 * @ordered
	 */
	protected String uID = UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWordWidth() <em>Word Width</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWordWidth()
	 * @generated
	 * @ordered
	 */
	protected static final WordWidthType WORD_WIDTH_EDEFAULT = WordWidthType._31_LITERAL;

	/**
	 * The cached value of the '{@link #getWordWidth() <em>Word Width</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWordWidth()
	 * @generated
	 * @ordered
	 */
	protected WordWidthType wordWidth = WORD_WIDTH_EDEFAULT;

	/**
	 * This is true if the Word Width attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean wordWidthESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnixDB2ClientInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.UNIX_DB2_CLIENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AuthenticationTypeType getAuthenticationType() {
		return authenticationType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthenticationType(AuthenticationTypeType newAuthenticationType) {
		AuthenticationTypeType oldAuthenticationType = authenticationType;
		authenticationType = newAuthenticationType == null ? AUTHENTICATION_TYPE_EDEFAULT : newAuthenticationType;
		boolean oldAuthenticationTypeESet = authenticationTypeESet;
		authenticationTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE, oldAuthenticationType, authenticationType, !oldAuthenticationTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAuthenticationType() {
		AuthenticationTypeType oldAuthenticationType = authenticationType;
		boolean oldAuthenticationTypeESet = authenticationTypeESet;
		authenticationType = AUTHENTICATION_TYPE_EDEFAULT;
		authenticationTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE, oldAuthenticationType, AUTHENTICATION_TYPE_EDEFAULT, oldAuthenticationTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAuthenticationType() {
		return authenticationTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFencedGID() {
		return fencedGID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFencedGID(String newFencedGID) {
		String oldFencedGID = fencedGID;
		fencedGID = newFencedGID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GID, oldFencedGID, fencedGID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFencedGroupName() {
		return fencedGroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFencedGroupName(String newFencedGroupName) {
		String oldFencedGroupName = fencedGroupName;
		fencedGroupName = newFencedGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME, oldFencedGroupName, fencedGroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFencedUID() {
		return fencedUID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFencedUID(String newFencedUID) {
		String oldFencedUID = fencedUID;
		fencedUID = newFencedUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_UID, oldFencedUID, fencedUID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFencedUserName() {
		return fencedUserName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFencedUserName(String newFencedUserName) {
		String oldFencedUserName = fencedUserName;
		fencedUserName = newFencedUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME, oldFencedUserName, fencedUserName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFencedUserPassword() {
		return fencedUserPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFencedUserPassword(String newFencedUserPassword) {
		String oldFencedUserPassword = fencedUserPassword;
		fencedUserPassword = newFencedUserPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD, oldFencedUserPassword, fencedUserPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGID() {
		return gID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGID(String newGID) {
		String oldGID = gID;
		gID = newGID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__GID, oldGID, gID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupName(String newGroupName) {
		String oldGroupName = groupName;
		groupName = newGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME, oldGroupName, groupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixInstanceTypeType getInstanceType() {
		return instanceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceType(UnixInstanceTypeType newInstanceType) {
		UnixInstanceTypeType oldInstanceType = instanceType;
		instanceType = newInstanceType == null ? INSTANCE_TYPE_EDEFAULT : newInstanceType;
		boolean oldInstanceTypeESet = instanceTypeESet;
		instanceTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE, oldInstanceType, instanceType, !oldInstanceTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInstanceType() {
		UnixInstanceTypeType oldInstanceType = instanceType;
		boolean oldInstanceTypeESet = instanceTypeESet;
		instanceType = INSTANCE_TYPE_EDEFAULT;
		instanceTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE, oldInstanceType, INSTANCE_TYPE_EDEFAULT, oldInstanceTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInstanceType() {
		return instanceTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUID() {
		return uID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUID(String newUID) {
		String oldUID = uID;
		uID = newUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__UID, oldUID, uID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WordWidthType getWordWidth() {
		return wordWidth;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordWidth(WordWidthType newWordWidth) {
		WordWidthType oldWordWidth = wordWidth;
		wordWidth = newWordWidth == null ? WORD_WIDTH_EDEFAULT : newWordWidth;
		boolean oldWordWidthESet = wordWidthESet;
		wordWidthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH, oldWordWidth, wordWidth, !oldWordWidthESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWordWidth() {
		WordWidthType oldWordWidth = wordWidth;
		boolean oldWordWidthESet = wordWidthESet;
		wordWidth = WORD_WIDTH_EDEFAULT;
		wordWidthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH, oldWordWidth, WORD_WIDTH_EDEFAULT, oldWordWidthESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWordWidth() {
		return wordWidthESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE:
				return getAuthenticationType();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GID:
				return getFencedGID();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME:
				return getFencedGroupName();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_UID:
				return getFencedUID();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME:
				return getFencedUserName();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD:
				return getFencedUserPassword();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GID:
				return getGID();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME:
				return getGroupName();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE:
				return getInstanceType();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__PASSWORD:
				return getPassword();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__UID:
				return getUID();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__USERNAME:
				return getUsername();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH:
				return getWordWidth();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE:
				setAuthenticationType((AuthenticationTypeType)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GID:
				setFencedGID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME:
				setFencedGroupName((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_UID:
				setFencedUID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME:
				setFencedUserName((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD:
				setFencedUserPassword((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GID:
				setGID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME:
				setGroupName((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE:
				setInstanceType((UnixInstanceTypeType)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__PASSWORD:
				setPassword((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__UID:
				setUID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__USERNAME:
				setUsername((String)newValue);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH:
				setWordWidth((WordWidthType)newValue);
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
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE:
				unsetAuthenticationType();
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GID:
				setFencedGID(FENCED_GID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME:
				setFencedGroupName(FENCED_GROUP_NAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_UID:
				setFencedUID(FENCED_UID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME:
				setFencedUserName(FENCED_USER_NAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD:
				setFencedUserPassword(FENCED_USER_PASSWORD_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GID:
				setGID(GID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME:
				setGroupName(GROUP_NAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE:
				unsetInstanceType();
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__UID:
				setUID(UID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH:
				unsetWordWidth();
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
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE:
				return isSetAuthenticationType();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GID:
				return FENCED_GID_EDEFAULT == null ? fencedGID != null : !FENCED_GID_EDEFAULT.equals(fencedGID);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME:
				return FENCED_GROUP_NAME_EDEFAULT == null ? fencedGroupName != null : !FENCED_GROUP_NAME_EDEFAULT.equals(fencedGroupName);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_UID:
				return FENCED_UID_EDEFAULT == null ? fencedUID != null : !FENCED_UID_EDEFAULT.equals(fencedUID);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME:
				return FENCED_USER_NAME_EDEFAULT == null ? fencedUserName != null : !FENCED_USER_NAME_EDEFAULT.equals(fencedUserName);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD:
				return FENCED_USER_PASSWORD_EDEFAULT == null ? fencedUserPassword != null : !FENCED_USER_PASSWORD_EDEFAULT.equals(fencedUserPassword);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GID:
				return GID_EDEFAULT == null ? gID != null : !GID_EDEFAULT.equals(gID);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME:
				return GROUP_NAME_EDEFAULT == null ? groupName != null : !GROUP_NAME_EDEFAULT.equals(groupName);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE:
				return isSetInstanceType();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__UID:
				return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH:
				return isSetWordWidth();
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
		result.append(" (authenticationType: "); //$NON-NLS-1$
		if (authenticationTypeESet) result.append(authenticationType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", fencedGID: "); //$NON-NLS-1$
		result.append(fencedGID);
		result.append(", fencedGroupName: "); //$NON-NLS-1$
		result.append(fencedGroupName);
		result.append(", fencedUID: "); //$NON-NLS-1$
		result.append(fencedUID);
		result.append(", fencedUserName: "); //$NON-NLS-1$
		result.append(fencedUserName);
		result.append(", fencedUserPassword: "); //$NON-NLS-1$
		result.append(fencedUserPassword);
		result.append(", gID: "); //$NON-NLS-1$
		result.append(gID);
		result.append(", groupName: "); //$NON-NLS-1$
		result.append(groupName);
		result.append(", instanceType: "); //$NON-NLS-1$
		if (instanceTypeESet) result.append(instanceType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", uID: "); //$NON-NLS-1$
		result.append(uID);
		result.append(", username: "); //$NON-NLS-1$
		result.append(username);
		result.append(", wordWidth: "); //$NON-NLS-1$
		if (wordWidthESet) result.append(wordWidth); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //UnixDB2ClientInstanceImpl
