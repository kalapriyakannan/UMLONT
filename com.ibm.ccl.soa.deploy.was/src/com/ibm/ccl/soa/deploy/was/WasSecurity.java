/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveAuthMechanism <em>Active Auth Mechanism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveProtocol <em>Active Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveUserRegistry <em>Active User Registry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isAllowAllPermissionForApplication <em>Allow All Permission For Application</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceFineGrainedJCASecurity <em>Enforce Fine Grained JCA Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2SecRuntimeFiletering <em>Enforce Java2 Sec Runtime Filetering</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2Security <em>Enforce Java2 Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isGlobalSecurityEnabled <em>Global Security Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isIssuePermissionWarning <em>Issue Permission Warning</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isUseDomainQualifiedNames <em>Use Domain Qualified Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity()
 * @model extendedMetaData="name='WasSecurity' kind='elementOnly'"
 * @generated
 */
public interface WasSecurity extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Active Auth Mechanism</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Auth Mechanism</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Active Auth Mechanism</em>' attribute.
	 * @see #setActiveAuthMechanism(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_ActiveAuthMechanism()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='activeAuthMechanism'"
	 * @generated
	 */
	String getActiveAuthMechanism();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveAuthMechanism <em>Active Auth Mechanism</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Auth Mechanism</em>' attribute.
	 * @see #getActiveAuthMechanism()
	 * @generated
	 */
	void setActiveAuthMechanism(String value);

	/**
	 * Returns the value of the '<em><b>Active Protocol</b></em>' attribute.
	 * The default value is <code>"IBM"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Protocol</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Protocol</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols
	 * @see #isSetActiveProtocol()
	 * @see #unsetActiveProtocol()
	 * @see #setActiveProtocol(IIOPSecurityProtocols)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_ActiveProtocol()
	 * @model default="IBM" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='activeProtocol'"
	 * @generated
	 */
	IIOPSecurityProtocols getActiveProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveProtocol <em>Active Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Protocol</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols
	 * @see #isSetActiveProtocol()
	 * @see #unsetActiveProtocol()
	 * @see #getActiveProtocol()
	 * @generated
	 */
	void setActiveProtocol(IIOPSecurityProtocols value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveProtocol <em>Active Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetActiveProtocol()
	 * @see #getActiveProtocol()
	 * @see #setActiveProtocol(IIOPSecurityProtocols)
	 * @generated
	 */
	void unsetActiveProtocol();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveProtocol <em>Active Protocol</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Active Protocol</em>' attribute is set.
	 * @see #unsetActiveProtocol()
	 * @see #getActiveProtocol()
	 * @see #setActiveProtocol(IIOPSecurityProtocols)
	 * @generated
	 */
	boolean isSetActiveProtocol();

	/**
	 * Returns the value of the '<em><b>Active User Registry</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active User Registry</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Active User Registry</em>' attribute.
	 * @see #setActiveUserRegistry(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_ActiveUserRegistry()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='activeUserRegistry'"
	 * @generated
	 */
	WasUserRegistryTypes getActiveUserRegistry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveUserRegistry <em>Active User Registry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active User Registry</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes
	 * @see #isSetActiveUserRegistry()
	 * @see #unsetActiveUserRegistry()
	 * @see #getActiveUserRegistry()
	 * @generated
	 */
	void setActiveUserRegistry(WasUserRegistryTypes value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveUserRegistry <em>Active User Registry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActiveUserRegistry()
	 * @see #getActiveUserRegistry()
	 * @see #setActiveUserRegistry(WasUserRegistryTypes)
	 * @generated
	 */
	void unsetActiveUserRegistry();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getActiveUserRegistry <em>Active User Registry</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Active User Registry</em>' attribute is set.
	 * @see #unsetActiveUserRegistry()
	 * @see #getActiveUserRegistry()
	 * @see #setActiveUserRegistry(WasUserRegistryTypes)
	 * @generated
	 */
	boolean isSetActiveUserRegistry();

	/**
	 * Returns the value of the '<em><b>Allow All Permission For Application</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow All Permission For Application</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow All Permission For Application</em>' attribute.
	 * @see #isSetAllowAllPermissionForApplication()
	 * @see #unsetAllowAllPermissionForApplication()
	 * @see #setAllowAllPermissionForApplication(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_AllowAllPermissionForApplication()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='allowAllPermissionForApplication'"
	 * @generated
	 */
	boolean isAllowAllPermissionForApplication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isAllowAllPermissionForApplication <em>Allow All Permission For Application</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow All Permission For Application</em>' attribute.
	 * @see #isSetAllowAllPermissionForApplication()
	 * @see #unsetAllowAllPermissionForApplication()
	 * @see #isAllowAllPermissionForApplication()
	 * @generated
	 */
	void setAllowAllPermissionForApplication(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isAllowAllPermissionForApplication <em>Allow All Permission For Application</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAllowAllPermissionForApplication()
	 * @see #isAllowAllPermissionForApplication()
	 * @see #setAllowAllPermissionForApplication(boolean)
	 * @generated
	 */
	void unsetAllowAllPermissionForApplication();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isAllowAllPermissionForApplication <em>Allow All Permission For Application</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Allow All Permission For Application</em>' attribute is set.
	 * @see #unsetAllowAllPermissionForApplication()
	 * @see #isAllowAllPermissionForApplication()
	 * @see #setAllowAllPermissionForApplication(boolean)
	 * @generated
	 */
	boolean isSetAllowAllPermissionForApplication();

	/**
	 * Returns the value of the '<em><b>Cache Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Cache Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Timeout</em>' attribute.
	 * @see #setCacheTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_CacheTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cacheTimeout'"
	 * @generated
	 */
	String getCacheTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#getCacheTimeout <em>Cache Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Timeout</em>' attribute.
	 * @see #getCacheTimeout()
	 * @generated
	 */
	void setCacheTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Enforce Fine Grained JCA Security</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce Fine Grained JCA Security</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforce Fine Grained JCA Security</em>' attribute.
	 * @see #isSetEnforceFineGrainedJCASecurity()
	 * @see #unsetEnforceFineGrainedJCASecurity()
	 * @see #setEnforceFineGrainedJCASecurity(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_EnforceFineGrainedJCASecurity()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='enforceFineGrainedJCASecurity'"
	 * @generated
	 */
	boolean isEnforceFineGrainedJCASecurity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceFineGrainedJCASecurity <em>Enforce Fine Grained JCA Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce Fine Grained JCA Security</em>' attribute.
	 * @see #isSetEnforceFineGrainedJCASecurity()
	 * @see #unsetEnforceFineGrainedJCASecurity()
	 * @see #isEnforceFineGrainedJCASecurity()
	 * @generated
	 */
	void setEnforceFineGrainedJCASecurity(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceFineGrainedJCASecurity <em>Enforce Fine Grained JCA Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEnforceFineGrainedJCASecurity()
	 * @see #isEnforceFineGrainedJCASecurity()
	 * @see #setEnforceFineGrainedJCASecurity(boolean)
	 * @generated
	 */
	void unsetEnforceFineGrainedJCASecurity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceFineGrainedJCASecurity <em>Enforce Fine Grained JCA Security</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enforce Fine Grained JCA Security</em>' attribute is set.
	 * @see #unsetEnforceFineGrainedJCASecurity()
	 * @see #isEnforceFineGrainedJCASecurity()
	 * @see #setEnforceFineGrainedJCASecurity(boolean)
	 * @generated
	 */
	boolean isSetEnforceFineGrainedJCASecurity();

	/**
	 * Returns the value of the '<em><b>Enforce Java2 Sec Runtime Filetering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce Java2 Sec Runtime Filetering</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforce Java2 Sec Runtime Filetering</em>' attribute.
	 * @see #isSetEnforceJava2SecRuntimeFiletering()
	 * @see #unsetEnforceJava2SecRuntimeFiletering()
	 * @see #setEnforceJava2SecRuntimeFiletering(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_EnforceJava2SecRuntimeFiletering()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='enforceJava2SecRuntimeFiletering'"
	 * @generated
	 */
	boolean isEnforceJava2SecRuntimeFiletering();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2SecRuntimeFiletering <em>Enforce Java2 Sec Runtime Filetering</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce Java2 Sec Runtime Filetering</em>' attribute.
	 * @see #isSetEnforceJava2SecRuntimeFiletering()
	 * @see #unsetEnforceJava2SecRuntimeFiletering()
	 * @see #isEnforceJava2SecRuntimeFiletering()
	 * @generated
	 */
	void setEnforceJava2SecRuntimeFiletering(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2SecRuntimeFiletering <em>Enforce Java2 Sec Runtime Filetering</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEnforceJava2SecRuntimeFiletering()
	 * @see #isEnforceJava2SecRuntimeFiletering()
	 * @see #setEnforceJava2SecRuntimeFiletering(boolean)
	 * @generated
	 */
	void unsetEnforceJava2SecRuntimeFiletering();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2SecRuntimeFiletering <em>Enforce Java2 Sec Runtime Filetering</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enforce Java2 Sec Runtime Filetering</em>' attribute is set.
	 * @see #unsetEnforceJava2SecRuntimeFiletering()
	 * @see #isEnforceJava2SecRuntimeFiletering()
	 * @see #setEnforceJava2SecRuntimeFiletering(boolean)
	 * @generated
	 */
	boolean isSetEnforceJava2SecRuntimeFiletering();

	/**
	 * Returns the value of the '<em><b>Enforce Java2 Security</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce Java2 Security</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enforce Java2 Security</em>' attribute.
	 * @see #isSetEnforceJava2Security()
	 * @see #unsetEnforceJava2Security()
	 * @see #setEnforceJava2Security(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_EnforceJava2Security()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='enforceJava2Security'"
	 * @generated
	 */
	boolean isEnforceJava2Security();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2Security <em>Enforce Java2 Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce Java2 Security</em>' attribute.
	 * @see #isSetEnforceJava2Security()
	 * @see #unsetEnforceJava2Security()
	 * @see #isEnforceJava2Security()
	 * @generated
	 */
	void setEnforceJava2Security(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2Security <em>Enforce Java2 Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEnforceJava2Security()
	 * @see #isEnforceJava2Security()
	 * @see #setEnforceJava2Security(boolean)
	 * @generated
	 */
	void unsetEnforceJava2Security();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isEnforceJava2Security <em>Enforce Java2 Security</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enforce Java2 Security</em>' attribute is set.
	 * @see #unsetEnforceJava2Security()
	 * @see #isEnforceJava2Security()
	 * @see #setEnforceJava2Security(boolean)
	 * @generated
	 */
	boolean isSetEnforceJava2Security();

	/**
	 * Returns the value of the '<em><b>Global Security Enabled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Security Enabled</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Global Security Enabled</em>' attribute.
	 * @see #isSetGlobalSecurityEnabled()
	 * @see #unsetGlobalSecurityEnabled()
	 * @see #setGlobalSecurityEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_GlobalSecurityEnabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='globalSecurityEnabled'"
	 * @generated
	 */
	boolean isGlobalSecurityEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isGlobalSecurityEnabled <em>Global Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Security Enabled</em>' attribute.
	 * @see #isSetGlobalSecurityEnabled()
	 * @see #unsetGlobalSecurityEnabled()
	 * @see #isGlobalSecurityEnabled()
	 * @generated
	 */
	void setGlobalSecurityEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isGlobalSecurityEnabled <em>Global Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetGlobalSecurityEnabled()
	 * @see #isGlobalSecurityEnabled()
	 * @see #setGlobalSecurityEnabled(boolean)
	 * @generated
	 */
	void unsetGlobalSecurityEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isGlobalSecurityEnabled <em>Global Security Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Global Security Enabled</em>' attribute is set.
	 * @see #unsetGlobalSecurityEnabled()
	 * @see #isGlobalSecurityEnabled()
	 * @see #setGlobalSecurityEnabled(boolean)
	 * @generated
	 */
	boolean isSetGlobalSecurityEnabled();

	/**
	 * Returns the value of the '<em><b>Issue Permission Warning</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue Permission Warning</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Issue Permission Warning</em>' attribute.
	 * @see #isSetIssuePermissionWarning()
	 * @see #unsetIssuePermissionWarning()
	 * @see #setIssuePermissionWarning(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_IssuePermissionWarning()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='issuePermissionWarning'"
	 * @generated
	 */
	boolean isIssuePermissionWarning();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isIssuePermissionWarning <em>Issue Permission Warning</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Permission Warning</em>' attribute.
	 * @see #isSetIssuePermissionWarning()
	 * @see #unsetIssuePermissionWarning()
	 * @see #isIssuePermissionWarning()
	 * @generated
	 */
	void setIssuePermissionWarning(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isIssuePermissionWarning <em>Issue Permission Warning</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIssuePermissionWarning()
	 * @see #isIssuePermissionWarning()
	 * @see #setIssuePermissionWarning(boolean)
	 * @generated
	 */
	void unsetIssuePermissionWarning();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isIssuePermissionWarning <em>Issue Permission Warning</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Issue Permission Warning</em>' attribute is set.
	 * @see #unsetIssuePermissionWarning()
	 * @see #isIssuePermissionWarning()
	 * @see #setIssuePermissionWarning(boolean)
	 * @generated
	 */
	boolean isSetIssuePermissionWarning();

	/**
	 * Returns the value of the '<em><b>Use Domain Qualified Names</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Domain Qualified Names</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Domain Qualified Names</em>' attribute.
	 * @see #isSetUseDomainQualifiedNames()
	 * @see #unsetUseDomainQualifiedNames()
	 * @see #setUseDomainQualifiedNames(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSecurity_UseDomainQualifiedNames()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='useDomainQualifiedNames'"
	 * @generated
	 */
	boolean isUseDomainQualifiedNames();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isUseDomainQualifiedNames <em>Use Domain Qualified Names</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Domain Qualified Names</em>' attribute.
	 * @see #isSetUseDomainQualifiedNames()
	 * @see #unsetUseDomainQualifiedNames()
	 * @see #isUseDomainQualifiedNames()
	 * @generated
	 */
	void setUseDomainQualifiedNames(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isUseDomainQualifiedNames <em>Use Domain Qualified Names</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUseDomainQualifiedNames()
	 * @see #isUseDomainQualifiedNames()
	 * @see #setUseDomainQualifiedNames(boolean)
	 * @generated
	 */
	void unsetUseDomainQualifiedNames();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSecurity#isUseDomainQualifiedNames <em>Use Domain Qualified Names</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Domain Qualified Names</em>' attribute is set.
	 * @see #unsetUseDomainQualifiedNames()
	 * @see #isUseDomainQualifiedNames()
	 * @see #setUseDomainQualifiedNames(boolean)
	 * @generated
	 */
	boolean isSetUseDomainQualifiedNames();

} // WasSecurity
