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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.LDAPDirectoryType;
import com.ibm.ccl.soa.deploy.was.WasLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ldap Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getBaseDN <em>Base DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getBindDN <em>Bind DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getBindPassword <em>Bind Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#isIgnoreCase <em>Ignore Case</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getLdapHostname <em>Ldap Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getLdapPort <em>Ldap Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getMonitorInterval <em>Monitor Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getRealm <em>Realm</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#isReuseConnection <em>Reuse Connection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getSearchTimeout <em>Search Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getServerId <em>Server Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getServerPassword <em>Server Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getSslConfig <em>Ssl Config</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#isSslEnabled <em>Ssl Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasLdapConfigurationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasLdapConfigurationImpl extends CapabilityImpl implements WasLdapConfiguration {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBaseDN() <em>Base DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseDN()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_DN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseDN() <em>Base DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseDN()
	 * @generated
	 * @ordered
	 */
	protected String baseDN = BASE_DN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBindDN() <em>Bind DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBindDN()
	 * @generated
	 * @ordered
	 */
	protected static final String BIND_DN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBindDN() <em>Bind DN</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBindDN()
	 * @generated
	 * @ordered
	 */
	protected String bindDN = BIND_DN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBindPassword() <em>Bind Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBindPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String BIND_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBindPassword() <em>Bind Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBindPassword()
	 * @generated
	 * @ordered
	 */
	protected String bindPassword = BIND_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #isIgnoreCase() <em>Ignore Case</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIgnoreCase()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_CASE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreCase() <em>Ignore Case</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIgnoreCase()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreCase = IGNORE_CASE_EDEFAULT;

	/**
	 * This is true if the Ignore Case attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreCaseESet;

	/**
	 * The default value of the '{@link #getLdapHostname() <em>Ldap Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLdapHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String LDAP_HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLdapHostname() <em>Ldap Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLdapHostname()
	 * @generated
	 * @ordered
	 */
	protected String ldapHostname = LDAP_HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLdapPort() <em>Ldap Port</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLdapPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LDAP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLdapPort() <em>Ldap Port</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLdapPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger ldapPort = LDAP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getLimit()
	 * @generated
	 * @ordered
	 */
	protected String limit = LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMonitorInterval() <em>Monitor Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMonitorInterval()
	 * @generated
	 * @ordered
	 */
	protected static final String MONITOR_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMonitorInterval() <em>Monitor Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMonitorInterval()
	 * @generated
	 * @ordered
	 */
	protected String monitorInterval = MONITOR_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRealm() <em>Realm</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getRealm()
	 * @generated
	 * @ordered
	 */
	protected static final String REALM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRealm() <em>Realm</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getRealm()
	 * @generated
	 * @ordered
	 */
	protected String realm = REALM_EDEFAULT;

	/**
	 * The default value of the '{@link #isReuseConnection() <em>Reuse Connection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReuseConnection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REUSE_CONNECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReuseConnection() <em>Reuse Connection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReuseConnection()
	 * @generated
	 * @ordered
	 */
	protected boolean reuseConnection = REUSE_CONNECTION_EDEFAULT;

	/**
	 * This is true if the Reuse Connection attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reuseConnectionESet;

	/**
	 * The default value of the '{@link #getSearchTimeout() <em>Search Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSearchTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSearchTimeout() <em>Search Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSearchTimeout()
	 * @generated
	 * @ordered
	 */
	protected String searchTimeout = SEARCH_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerId() <em>Server Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerId()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerId() <em>Server Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerId()
	 * @generated
	 * @ordered
	 */
	protected String serverId = SERVER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerPassword() <em>Server Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServerPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerPassword() <em>Server Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServerPassword()
	 * @generated
	 * @ordered
	 */
	protected String serverPassword = SERVER_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSslConfig() <em>Ssl Config</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSslConfig()
	 * @generated
	 * @ordered
	 */
	protected static final String SSL_CONFIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSslConfig() <em>Ssl Config</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSslConfig()
	 * @generated
	 * @ordered
	 */
	protected String sslConfig = SSL_CONFIG_EDEFAULT;

	/**
	 * The default value of the '{@link #isSslEnabled() <em>Ssl Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSslEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SSL_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSslEnabled() <em>Ssl Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSslEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean sslEnabled = SSL_ENABLED_EDEFAULT;

	/**
	 * This is true if the Ssl Enabled attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sslEnabledESet;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final LDAPDirectoryType TYPE_EDEFAULT = LDAPDirectoryType.IBMDIRECTORYSERVER_LITERAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected LDAPDirectoryType type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasLdapConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_LDAP_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseDN() {
		return baseDN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseDN(String newBaseDN) {
		String oldBaseDN = baseDN;
		baseDN = newBaseDN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN, oldBaseDN, baseDN));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBindDN() {
		return bindDN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindDN(String newBindDN) {
		String oldBindDN = bindDN;
		bindDN = newBindDN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN, oldBindDN, bindDN));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBindPassword() {
		return bindPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindPassword(String newBindPassword) {
		String oldBindPassword = bindPassword;
		bindPassword = newBindPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD, oldBindPassword, bindPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreCase(boolean newIgnoreCase) {
		boolean oldIgnoreCase = ignoreCase;
		ignoreCase = newIgnoreCase;
		boolean oldIgnoreCaseESet = ignoreCaseESet;
		ignoreCaseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE, oldIgnoreCase, ignoreCase, !oldIgnoreCaseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIgnoreCase() {
		boolean oldIgnoreCase = ignoreCase;
		boolean oldIgnoreCaseESet = ignoreCaseESet;
		ignoreCase = IGNORE_CASE_EDEFAULT;
		ignoreCaseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE, oldIgnoreCase, IGNORE_CASE_EDEFAULT, oldIgnoreCaseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIgnoreCase() {
		return ignoreCaseESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLdapHostname() {
		return ldapHostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapHostname(String newLdapHostname) {
		String oldLdapHostname = ldapHostname;
		ldapHostname = newLdapHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME, oldLdapHostname, ldapHostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLdapPort() {
		return ldapPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapPort(BigInteger newLdapPort) {
		BigInteger oldLdapPort = ldapPort;
		ldapPort = newLdapPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT, oldLdapPort, ldapPort));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimit(String newLimit) {
		String oldLimit = limit;
		limit = newLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__LIMIT, oldLimit, limit));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMonitorInterval() {
		return monitorInterval;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitorInterval(String newMonitorInterval) {
		String oldMonitorInterval = monitorInterval;
		monitorInterval = newMonitorInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL, oldMonitorInterval, monitorInterval));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRealm() {
		return realm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealm(String newRealm) {
		String oldRealm = realm;
		realm = newRealm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__REALM, oldRealm, realm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReuseConnection() {
		return reuseConnection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReuseConnection(boolean newReuseConnection) {
		boolean oldReuseConnection = reuseConnection;
		reuseConnection = newReuseConnection;
		boolean oldReuseConnectionESet = reuseConnectionESet;
		reuseConnectionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION, oldReuseConnection, reuseConnection, !oldReuseConnectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReuseConnection() {
		boolean oldReuseConnection = reuseConnection;
		boolean oldReuseConnectionESet = reuseConnectionESet;
		reuseConnection = REUSE_CONNECTION_EDEFAULT;
		reuseConnectionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION, oldReuseConnection, REUSE_CONNECTION_EDEFAULT, oldReuseConnectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReuseConnection() {
		return reuseConnectionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchTimeout() {
		return searchTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchTimeout(String newSearchTimeout) {
		String oldSearchTimeout = searchTimeout;
		searchTimeout = newSearchTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT, oldSearchTimeout, searchTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerId() {
		return serverId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerId(String newServerId) {
		String oldServerId = serverId;
		serverId = newServerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID, oldServerId, serverId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerPassword() {
		return serverPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerPassword(String newServerPassword) {
		String oldServerPassword = serverPassword;
		serverPassword = newServerPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD, oldServerPassword, serverPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSslConfig() {
		return sslConfig;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSslConfig(String newSslConfig) {
		String oldSslConfig = sslConfig;
		sslConfig = newSslConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG, oldSslConfig, sslConfig));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSslEnabled() {
		return sslEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSslEnabled(boolean newSslEnabled) {
		boolean oldSslEnabled = sslEnabled;
		sslEnabled = newSslEnabled;
		boolean oldSslEnabledESet = sslEnabledESet;
		sslEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED, oldSslEnabled, sslEnabled, !oldSslEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSslEnabled() {
		boolean oldSslEnabled = sslEnabled;
		boolean oldSslEnabledESet = sslEnabledESet;
		sslEnabled = SSL_ENABLED_EDEFAULT;
		sslEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED, oldSslEnabled, SSL_ENABLED_EDEFAULT, oldSslEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSslEnabled() {
		return sslEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LDAPDirectoryType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(LDAPDirectoryType newType) {
		LDAPDirectoryType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_LDAP_CONFIGURATION__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		LDAPDirectoryType oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_LDAP_CONFIGURATION__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN:
				return getBaseDN();
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN:
				return getBindDN();
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD:
				return getBindPassword();
			case WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE:
				return isIgnoreCase() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME:
				return getLdapHostname();
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT:
				return getLdapPort();
			case WasPackage.WAS_LDAP_CONFIGURATION__LIMIT:
				return getLimit();
			case WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL:
				return getMonitorInterval();
			case WasPackage.WAS_LDAP_CONFIGURATION__REALM:
				return getRealm();
			case WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION:
				return isReuseConnection() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT:
				return getSearchTimeout();
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID:
				return getServerId();
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD:
				return getServerPassword();
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG:
				return getSslConfig();
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED:
				return isSslEnabled() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_LDAP_CONFIGURATION__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN:
				setBaseDN((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN:
				setBindDN((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD:
				setBindPassword((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE:
				setIgnoreCase(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME:
				setLdapHostname((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT:
				setLdapPort((BigInteger)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LIMIT:
				setLimit((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL:
				setMonitorInterval((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__REALM:
				setRealm((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION:
				setReuseConnection(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT:
				setSearchTimeout((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID:
				setServerId((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD:
				setServerPassword((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG:
				setSslConfig((String)newValue);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED:
				setSslEnabled(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__TYPE:
				setType((LDAPDirectoryType)newValue);
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
			case WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN:
				setBaseDN(BASE_DN_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN:
				setBindDN(BIND_DN_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD:
				setBindPassword(BIND_PASSWORD_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE:
				unsetIgnoreCase();
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME:
				setLdapHostname(LDAP_HOSTNAME_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT:
				setLdapPort(LDAP_PORT_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__LIMIT:
				setLimit(LIMIT_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL:
				setMonitorInterval(MONITOR_INTERVAL_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__REALM:
				setRealm(REALM_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION:
				unsetReuseConnection();
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT:
				setSearchTimeout(SEARCH_TIMEOUT_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID:
				setServerId(SERVER_ID_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD:
				setServerPassword(SERVER_PASSWORD_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG:
				setSslConfig(SSL_CONFIG_EDEFAULT);
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED:
				unsetSslEnabled();
				return;
			case WasPackage.WAS_LDAP_CONFIGURATION__TYPE:
				unsetType();
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
			case WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN:
				return BASE_DN_EDEFAULT == null ? baseDN != null : !BASE_DN_EDEFAULT.equals(baseDN);
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN:
				return BIND_DN_EDEFAULT == null ? bindDN != null : !BIND_DN_EDEFAULT.equals(bindDN);
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD:
				return BIND_PASSWORD_EDEFAULT == null ? bindPassword != null : !BIND_PASSWORD_EDEFAULT.equals(bindPassword);
			case WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE:
				return isSetIgnoreCase();
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME:
				return LDAP_HOSTNAME_EDEFAULT == null ? ldapHostname != null : !LDAP_HOSTNAME_EDEFAULT.equals(ldapHostname);
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT:
				return LDAP_PORT_EDEFAULT == null ? ldapPort != null : !LDAP_PORT_EDEFAULT.equals(ldapPort);
			case WasPackage.WAS_LDAP_CONFIGURATION__LIMIT:
				return LIMIT_EDEFAULT == null ? limit != null : !LIMIT_EDEFAULT.equals(limit);
			case WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL:
				return MONITOR_INTERVAL_EDEFAULT == null ? monitorInterval != null : !MONITOR_INTERVAL_EDEFAULT.equals(monitorInterval);
			case WasPackage.WAS_LDAP_CONFIGURATION__REALM:
				return REALM_EDEFAULT == null ? realm != null : !REALM_EDEFAULT.equals(realm);
			case WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION:
				return isSetReuseConnection();
			case WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT:
				return SEARCH_TIMEOUT_EDEFAULT == null ? searchTimeout != null : !SEARCH_TIMEOUT_EDEFAULT.equals(searchTimeout);
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID:
				return SERVER_ID_EDEFAULT == null ? serverId != null : !SERVER_ID_EDEFAULT.equals(serverId);
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD:
				return SERVER_PASSWORD_EDEFAULT == null ? serverPassword != null : !SERVER_PASSWORD_EDEFAULT.equals(serverPassword);
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG:
				return SSL_CONFIG_EDEFAULT == null ? sslConfig != null : !SSL_CONFIG_EDEFAULT.equals(sslConfig);
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED:
				return isSetSslEnabled();
			case WasPackage.WAS_LDAP_CONFIGURATION__TYPE:
				return isSetType();
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
		result.append(" (baseDN: "); //$NON-NLS-1$
		result.append(baseDN);
		result.append(", bindDN: "); //$NON-NLS-1$
		result.append(bindDN);
		result.append(", bindPassword: "); //$NON-NLS-1$
		result.append(bindPassword);
		result.append(", ignoreCase: "); //$NON-NLS-1$
		if (ignoreCaseESet) result.append(ignoreCase); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", ldapHostname: "); //$NON-NLS-1$
		result.append(ldapHostname);
		result.append(", ldapPort: "); //$NON-NLS-1$
		result.append(ldapPort);
		result.append(", limit: "); //$NON-NLS-1$
		result.append(limit);
		result.append(", monitorInterval: "); //$NON-NLS-1$
		result.append(monitorInterval);
		result.append(", realm: "); //$NON-NLS-1$
		result.append(realm);
		result.append(", reuseConnection: "); //$NON-NLS-1$
		if (reuseConnectionESet) result.append(reuseConnection); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", searchTimeout: "); //$NON-NLS-1$
		result.append(searchTimeout);
		result.append(", serverId: "); //$NON-NLS-1$
		result.append(serverId);
		result.append(", serverPassword: "); //$NON-NLS-1$
		result.append(serverPassword);
		result.append(", sslConfig: "); //$NON-NLS-1$
		result.append(sslConfig);
		result.append(", sslEnabled: "); //$NON-NLS-1$
		if (sslEnabledESet) result.append(sslEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", type: "); //$NON-NLS-1$
		if (typeESet) result.append(type); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasLdapConfigurationImpl
