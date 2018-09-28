/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>J2EE Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getDatasourceName <em>Datasource Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#isUsedForCmp <em>Used For Cmp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class J2EEDatasourceImpl extends CapabilityImpl implements J2EEDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDatasourceName() <em>Datasource Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDatasourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATASOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatasourceName() <em>Datasource Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDatasourceName()
	 * @generated
	 * @ordered
	 */
	protected String datasourceName = DATASOURCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected String dbName = DB_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

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
	 * The default value of the '{@link #isUsedForCmp() <em>Used For Cmp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUsedForCmp()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_FOR_CMP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUsedForCmp() <em>Used For Cmp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUsedForCmp()
	 * @generated
	 * @ordered
	 */
	protected boolean usedForCmp = USED_FOR_CMP_EDEFAULT;

	/**
	 * This is true if the Used For Cmp attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean usedForCmpESet;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected J2EEDatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.J2EE_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatasourceName() {
		return datasourceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatasourceName(String newDatasourceName) {
		String oldDatasourceName = datasourceName;
		datasourceName = newDatasourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME, oldDatasourceName, datasourceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbName(String newDbName) {
		String oldDbName = dbName;
		dbName = newDbName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__DB_NAME, oldDbName, dbName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__JNDI_NAME, oldJndiName, jndiName));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET, J2eePackage.J2EE_DATASOURCE__PORT,
					oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUsedForCmp() {
		return usedForCmp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedForCmp(boolean newUsedForCmp) {
		boolean oldUsedForCmp = usedForCmp;
		usedForCmp = newUsedForCmp;
		boolean oldUsedForCmpESet = usedForCmpESet;
		usedForCmpESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP, oldUsedForCmp, usedForCmp,
					!oldUsedForCmpESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsedForCmp() {
		boolean oldUsedForCmp = usedForCmp;
		boolean oldUsedForCmpESet = usedForCmpESet;
		usedForCmp = USED_FOR_CMP_EDEFAULT;
		usedForCmpESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP, oldUsedForCmp, USED_FOR_CMP_EDEFAULT,
					oldUsedForCmpESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsedForCmp() {
		return usedForCmpESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2EE_DATASOURCE__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME:
			return getDatasourceName();
		case J2eePackage.J2EE_DATASOURCE__DB_NAME:
			return getDbName();
		case J2eePackage.J2EE_DATASOURCE__HOSTNAME:
			return getHostname();
		case J2eePackage.J2EE_DATASOURCE__JNDI_NAME:
			return getJndiName();
		case J2eePackage.J2EE_DATASOURCE__PASSWORD:
			return getPassword();
		case J2eePackage.J2EE_DATASOURCE__PORT:
			return getPort();
		case J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP:
			return isUsedForCmp() ? Boolean.TRUE : Boolean.FALSE;
		case J2eePackage.J2EE_DATASOURCE__USERNAME:
			return getUsername();
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
		case J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME:
			setDatasourceName((String) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__DB_NAME:
			setDbName((String) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__HOSTNAME:
			setHostname((String) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__JNDI_NAME:
			setJndiName((String) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__PASSWORD:
			setPassword((String) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__PORT:
			setPort((BigInteger) newValue);
			return;
		case J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP:
			setUsedForCmp(((Boolean) newValue).booleanValue());
			return;
		case J2eePackage.J2EE_DATASOURCE__USERNAME:
			setUsername((String) newValue);
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
		case J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME:
			setDatasourceName(DATASOURCE_NAME_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__DB_NAME:
			setDbName(DB_NAME_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__HOSTNAME:
			setHostname(HOSTNAME_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__JNDI_NAME:
			setJndiName(JNDI_NAME_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__PASSWORD:
			setPassword(PASSWORD_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__PORT:
			setPort(PORT_EDEFAULT);
			return;
		case J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP:
			unsetUsedForCmp();
			return;
		case J2eePackage.J2EE_DATASOURCE__USERNAME:
			setUsername(USERNAME_EDEFAULT);
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
		case J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME:
			return DATASOURCE_NAME_EDEFAULT == null ? datasourceName != null
					: !DATASOURCE_NAME_EDEFAULT.equals(datasourceName);
		case J2eePackage.J2EE_DATASOURCE__DB_NAME:
			return DB_NAME_EDEFAULT == null ? dbName != null : !DB_NAME_EDEFAULT.equals(dbName);
		case J2eePackage.J2EE_DATASOURCE__HOSTNAME:
			return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
		case J2eePackage.J2EE_DATASOURCE__JNDI_NAME:
			return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT
					.equals(jndiName);
		case J2eePackage.J2EE_DATASOURCE__PASSWORD:
			return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
		case J2eePackage.J2EE_DATASOURCE__PORT:
			return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
		case J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP:
			return isSetUsedForCmp();
		case J2eePackage.J2EE_DATASOURCE__USERNAME:
			return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
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
		result.append(" (datasourceName: "); //$NON-NLS-1$
		result.append(datasourceName);
		result.append(", dbName: "); //$NON-NLS-1$
		result.append(dbName);
		result.append(", hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", usedForCmp: "); //$NON-NLS-1$
		if (usedForCmpESet)
			result.append(usedForCmp);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", username: "); //$NON-NLS-1$
		result.append(username);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(J2eePackage.eINSTANCE
			.getJ2EEDatasource_JndiName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //J2EEDatasourceImpl
