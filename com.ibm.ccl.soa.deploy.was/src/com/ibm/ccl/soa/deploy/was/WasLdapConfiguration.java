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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ldap Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBaseDN <em>Base DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBindDN <em>Bind DN</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBindPassword <em>Bind Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isIgnoreCase <em>Ignore Case</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLdapHostname <em>Ldap Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLdapPort <em>Ldap Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLimit <em>Limit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getMonitorInterval <em>Monitor Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getRealm <em>Realm</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isReuseConnection <em>Reuse Connection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getSearchTimeout <em>Search Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getServerId <em>Server Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getServerPassword <em>Server Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getSslConfig <em>Ssl Config</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isSslEnabled <em>Ssl Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration()
 * @model extendedMetaData="name='WasLdapConfiguration' kind='elementOnly'"
 * @generated
 */
public interface WasLdapConfiguration extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Base DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base DN</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base DN</em>' attribute.
	 * @see #setBaseDN(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_BaseDN()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='baseDN'"
	 * @generated
	 */
	String getBaseDN();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBaseDN <em>Base DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base DN</em>' attribute.
	 * @see #getBaseDN()
	 * @generated
	 */
	void setBaseDN(String value);

	/**
	 * Returns the value of the '<em><b>Bind DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bind DN</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind DN</em>' attribute.
	 * @see #setBindDN(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_BindDN()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bindDN'"
	 * @generated
	 */
	String getBindDN();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBindDN <em>Bind DN</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind DN</em>' attribute.
	 * @see #getBindDN()
	 * @generated
	 */
	void setBindDN(String value);

	/**
	 * Returns the value of the '<em><b>Bind Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Bind Password</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Password</em>' attribute.
	 * @see #setBindPassword(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_BindPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bindPassword'"
	 * @generated
	 */
	String getBindPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getBindPassword <em>Bind Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Password</em>' attribute.
	 * @see #getBindPassword()
	 * @generated
	 */
	void setBindPassword(String value);

	/**
	 * Returns the value of the '<em><b>Ignore Case</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Case</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore Case</em>' attribute.
	 * @see #isSetIgnoreCase()
	 * @see #unsetIgnoreCase()
	 * @see #setIgnoreCase(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_IgnoreCase()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ignoreCase'"
	 * @generated
	 */
	boolean isIgnoreCase();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isIgnoreCase <em>Ignore Case</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Case</em>' attribute.
	 * @see #isSetIgnoreCase()
	 * @see #unsetIgnoreCase()
	 * @see #isIgnoreCase()
	 * @generated
	 */
	void setIgnoreCase(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isIgnoreCase <em>Ignore Case</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIgnoreCase()
	 * @see #isIgnoreCase()
	 * @see #setIgnoreCase(boolean)
	 * @generated
	 */
	void unsetIgnoreCase();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isIgnoreCase <em>Ignore Case</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ignore Case</em>' attribute is set.
	 * @see #unsetIgnoreCase()
	 * @see #isIgnoreCase()
	 * @see #setIgnoreCase(boolean)
	 * @generated
	 */
	boolean isSetIgnoreCase();

	/**
	 * Returns the value of the '<em><b>Ldap Hostname</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Ldap Hostname</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Hostname</em>' attribute.
	 * @see #setLdapHostname(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_LdapHostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ldapHostname'"
	 * @generated
	 */
	String getLdapHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLdapHostname <em>Ldap Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Hostname</em>' attribute.
	 * @see #getLdapHostname()
	 * @generated
	 */
	void setLdapHostname(String value);

	/**
	 * Returns the value of the '<em><b>Ldap Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Port</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Port</em>' attribute.
	 * @see #setLdapPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_LdapPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='ldapPort'"
	 * @generated
	 */
	BigInteger getLdapPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLdapPort <em>Ldap Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Port</em>' attribute.
	 * @see #getLdapPort()
	 * @generated
	 */
	void setLdapPort(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Limit</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit</em>' attribute.
	 * @see #setLimit(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_Limit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='limit'"
	 * @generated
	 */
	String getLimit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getLimit <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit</em>' attribute.
	 * @see #getLimit()
	 * @generated
	 */
	void setLimit(String value);

	/**
	 * Returns the value of the '<em><b>Monitor Interval</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitor Interval</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Monitor Interval</em>' attribute.
	 * @see #setMonitorInterval(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_MonitorInterval()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='monitorInterval'"
	 * @generated
	 */
	String getMonitorInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getMonitorInterval <em>Monitor Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitor Interval</em>' attribute.
	 * @see #getMonitorInterval()
	 * @generated
	 */
	void setMonitorInterval(String value);

	/**
	 * Returns the value of the '<em><b>Realm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realm</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realm</em>' attribute.
	 * @see #setRealm(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_Realm()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='realm'"
	 * @generated
	 */
	String getRealm();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getRealm <em>Realm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realm</em>' attribute.
	 * @see #getRealm()
	 * @generated
	 */
	void setRealm(String value);

	/**
	 * Returns the value of the '<em><b>Reuse Connection</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reuse Connection</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reuse Connection</em>' attribute.
	 * @see #isSetReuseConnection()
	 * @see #unsetReuseConnection()
	 * @see #setReuseConnection(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_ReuseConnection()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reuseConnection'"
	 * @generated
	 */
	boolean isReuseConnection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isReuseConnection <em>Reuse Connection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reuse Connection</em>' attribute.
	 * @see #isSetReuseConnection()
	 * @see #unsetReuseConnection()
	 * @see #isReuseConnection()
	 * @generated
	 */
	void setReuseConnection(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isReuseConnection <em>Reuse Connection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReuseConnection()
	 * @see #isReuseConnection()
	 * @see #setReuseConnection(boolean)
	 * @generated
	 */
	void unsetReuseConnection();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isReuseConnection <em>Reuse Connection</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reuse Connection</em>' attribute is set.
	 * @see #unsetReuseConnection()
	 * @see #isReuseConnection()
	 * @see #setReuseConnection(boolean)
	 * @generated
	 */
	boolean isSetReuseConnection();

	/**
	 * Returns the value of the '<em><b>Search Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Search Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Timeout</em>' attribute.
	 * @see #setSearchTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_SearchTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='searchTimeout'"
	 * @generated
	 */
	String getSearchTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getSearchTimeout <em>Search Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Timeout</em>' attribute.
	 * @see #getSearchTimeout()
	 * @generated
	 */
	void setSearchTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Server Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Id</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Id</em>' attribute.
	 * @see #setServerId(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_ServerId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serverId'"
	 * @generated
	 */
	String getServerId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getServerId <em>Server Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Id</em>' attribute.
	 * @see #getServerId()
	 * @generated
	 */
	void setServerId(String value);

	/**
	 * Returns the value of the '<em><b>Server Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Server Password</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Password</em>' attribute.
	 * @see #setServerPassword(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_ServerPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serverPassword'"
	 * @generated
	 */
	String getServerPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getServerPassword <em>Server Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Password</em>' attribute.
	 * @see #getServerPassword()
	 * @generated
	 */
	void setServerPassword(String value);

	/**
	 * Returns the value of the '<em><b>Ssl Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ssl Config</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssl Config</em>' attribute.
	 * @see #setSslConfig(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_SslConfig()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sslConfig'"
	 * @generated
	 */
	String getSslConfig();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getSslConfig <em>Ssl Config</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssl Config</em>' attribute.
	 * @see #getSslConfig()
	 * @generated
	 */
	void setSslConfig(String value);

	/**
	 * Returns the value of the '<em><b>Ssl Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ssl Enabled</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssl Enabled</em>' attribute.
	 * @see #isSetSslEnabled()
	 * @see #unsetSslEnabled()
	 * @see #setSslEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_SslEnabled()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='sslEnabled'"
	 * @generated
	 */
	boolean isSslEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isSslEnabled <em>Ssl Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssl Enabled</em>' attribute.
	 * @see #isSetSslEnabled()
	 * @see #unsetSslEnabled()
	 * @see #isSslEnabled()
	 * @generated
	 */
	void setSslEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isSslEnabled <em>Ssl Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSslEnabled()
	 * @see #isSslEnabled()
	 * @see #setSslEnabled(boolean)
	 * @generated
	 */
	void unsetSslEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#isSslEnabled <em>Ssl Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ssl Enabled</em>' attribute is set.
	 * @see #unsetSslEnabled()
	 * @see #isSslEnabled()
	 * @see #setSslEnabled(boolean)
	 * @generated
	 */
	boolean isSetSslEnabled();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"IBM_DIRECTORY_SERVER"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.LDAPDirectoryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.LDAPDirectoryType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(LDAPDirectoryType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasLdapConfiguration_Type()
	 * @model default="IBM_DIRECTORY_SERVER" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	LDAPDirectoryType getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.LDAPDirectoryType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(LDAPDirectoryType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(LDAPDirectoryType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(LDAPDirectoryType)
	 * @generated
	 */
	boolean isSetType();

} // WasLdapConfiguration
