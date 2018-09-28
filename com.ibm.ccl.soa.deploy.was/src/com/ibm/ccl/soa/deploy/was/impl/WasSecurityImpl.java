/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.IIOPSecurityProtocols;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Security</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#getActiveAuthMechanism <em>Active Auth Mechanism</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#getActiveProtocol <em>Active Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#getActiveUserRegistry <em>Active User Registry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isAllowAllPermissionForApplication <em>Allow All Permission For Application</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isEnforceFineGrainedJCASecurity <em>Enforce Fine Grained JCA Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isEnforceJava2SecRuntimeFiletering <em>Enforce Java2 Sec Runtime Filetering</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isEnforceJava2Security <em>Enforce Java2 Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isGlobalSecurityEnabled <em>Global Security Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isIssuePermissionWarning <em>Issue Permission Warning</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecurityImpl#isUseDomainQualifiedNames <em>Use Domain Qualified Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSecurityImpl extends CapabilityImpl implements WasSecurity {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getActiveAuthMechanism() <em>Active Auth Mechanism</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveAuthMechanism()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVE_AUTH_MECHANISM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActiveAuthMechanism() <em>Active Auth Mechanism</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveAuthMechanism()
	 * @generated
	 * @ordered
	 */
	protected String activeAuthMechanism = ACTIVE_AUTH_MECHANISM_EDEFAULT;

	/**
	 * The default value of the '{@link #getActiveProtocol() <em>Active Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final IIOPSecurityProtocols ACTIVE_PROTOCOL_EDEFAULT = IIOPSecurityProtocols.IBM_LITERAL;

	/**
	 * The cached value of the '{@link #getActiveProtocol() <em>Active Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveProtocol()
	 * @generated
	 * @ordered
	 */
	protected IIOPSecurityProtocols activeProtocol = ACTIVE_PROTOCOL_EDEFAULT;

	/**
	 * This is true if the Active Protocol attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean activeProtocolESet;

	/**
	 * The default value of the '{@link #getActiveUserRegistry() <em>Active User Registry</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveUserRegistry()
	 * @generated
	 * @ordered
	 */
	protected static final WasUserRegistryTypes ACTIVE_USER_REGISTRY_EDEFAULT = WasUserRegistryTypes.OS_LITERAL;

	/**
	 * The cached value of the '{@link #getActiveUserRegistry() <em>Active User Registry</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActiveUserRegistry()
	 * @generated
	 * @ordered
	 */
	protected WasUserRegistryTypes activeUserRegistry = ACTIVE_USER_REGISTRY_EDEFAULT;

	/**
	 * This is true if the Active User Registry attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean activeUserRegistryESet;

	/**
	 * The default value of the '{@link #isAllowAllPermissionForApplication() <em>Allow All Permission For Application</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAllowAllPermissionForApplication()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_ALL_PERMISSION_FOR_APPLICATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowAllPermissionForApplication() <em>Allow All Permission For Application</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAllowAllPermissionForApplication()
	 * @generated
	 * @ordered
	 */
	protected boolean allowAllPermissionForApplication = ALLOW_ALL_PERMISSION_FOR_APPLICATION_EDEFAULT;

	/**
	 * This is true if the Allow All Permission For Application attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean allowAllPermissionForApplicationESet;

	/**
	 * The default value of the '{@link #getCacheTimeout() <em>Cache Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCacheTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String CACHE_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCacheTimeout() <em>Cache Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCacheTimeout()
	 * @generated
	 * @ordered
	 */
	protected String cacheTimeout = CACHE_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnforceFineGrainedJCASecurity() <em>Enforce Fine Grained JCA Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceFineGrainedJCASecurity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_FINE_GRAINED_JCA_SECURITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforceFineGrainedJCASecurity() <em>Enforce Fine Grained JCA Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceFineGrainedJCASecurity()
	 * @generated
	 * @ordered
	 */
	protected boolean enforceFineGrainedJCASecurity = ENFORCE_FINE_GRAINED_JCA_SECURITY_EDEFAULT;

	/**
	 * This is true if the Enforce Fine Grained JCA Security attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean enforceFineGrainedJCASecurityESet;

	/**
	 * The default value of the '{@link #isEnforceJava2SecRuntimeFiletering() <em>Enforce Java2 Sec Runtime Filetering</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceJava2SecRuntimeFiletering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_JAVA2_SEC_RUNTIME_FILETERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforceJava2SecRuntimeFiletering() <em>Enforce Java2 Sec Runtime Filetering</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceJava2SecRuntimeFiletering()
	 * @generated
	 * @ordered
	 */
	protected boolean enforceJava2SecRuntimeFiletering = ENFORCE_JAVA2_SEC_RUNTIME_FILETERING_EDEFAULT;

	/**
	 * This is true if the Enforce Java2 Sec Runtime Filetering attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean enforceJava2SecRuntimeFileteringESet;

	/**
	 * The default value of the '{@link #isEnforceJava2Security() <em>Enforce Java2 Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceJava2Security()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_JAVA2_SECURITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforceJava2Security() <em>Enforce Java2 Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEnforceJava2Security()
	 * @generated
	 * @ordered
	 */
	protected boolean enforceJava2Security = ENFORCE_JAVA2_SECURITY_EDEFAULT;

	/**
	 * This is true if the Enforce Java2 Security attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean enforceJava2SecurityESet;

	/**
	 * The default value of the '{@link #isGlobalSecurityEnabled() <em>Global Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isGlobalSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GLOBAL_SECURITY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGlobalSecurityEnabled() <em>Global Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isGlobalSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean globalSecurityEnabled = GLOBAL_SECURITY_ENABLED_EDEFAULT;

	/**
	 * This is true if the Global Security Enabled attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean globalSecurityEnabledESet;

	/**
	 * The default value of the '{@link #isIssuePermissionWarning() <em>Issue Permission Warning</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIssuePermissionWarning()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ISSUE_PERMISSION_WARNING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIssuePermissionWarning() <em>Issue Permission Warning</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIssuePermissionWarning()
	 * @generated
	 * @ordered
	 */
	protected boolean issuePermissionWarning = ISSUE_PERMISSION_WARNING_EDEFAULT;

	/**
	 * This is true if the Issue Permission Warning attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean issuePermissionWarningESet;

	/**
	 * The default value of the '{@link #isUseDomainQualifiedNames() <em>Use Domain Qualified Names</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseDomainQualifiedNames()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_DOMAIN_QUALIFIED_NAMES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseDomainQualifiedNames() <em>Use Domain Qualified Names</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseDomainQualifiedNames()
	 * @generated
	 * @ordered
	 */
	protected boolean useDomainQualifiedNames = USE_DOMAIN_QUALIFIED_NAMES_EDEFAULT;

	/**
	 * This is true if the Use Domain Qualified Names attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useDomainQualifiedNamesESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSecurityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SECURITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getActiveAuthMechanism() {
		return activeAuthMechanism;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveAuthMechanism(String newActiveAuthMechanism) {
		String oldActiveAuthMechanism = activeAuthMechanism;
		activeAuthMechanism = newActiveAuthMechanism;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM, oldActiveAuthMechanism, activeAuthMechanism));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IIOPSecurityProtocols getActiveProtocol() {
		return activeProtocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveProtocol(IIOPSecurityProtocols newActiveProtocol) {
		IIOPSecurityProtocols oldActiveProtocol = activeProtocol;
		activeProtocol = newActiveProtocol == null ? ACTIVE_PROTOCOL_EDEFAULT : newActiveProtocol;
		boolean oldActiveProtocolESet = activeProtocolESet;
		activeProtocolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL, oldActiveProtocol, activeProtocol, !oldActiveProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActiveProtocol() {
		IIOPSecurityProtocols oldActiveProtocol = activeProtocol;
		boolean oldActiveProtocolESet = activeProtocolESet;
		activeProtocol = ACTIVE_PROTOCOL_EDEFAULT;
		activeProtocolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL, oldActiveProtocol, ACTIVE_PROTOCOL_EDEFAULT, oldActiveProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActiveProtocol() {
		return activeProtocolESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasUserRegistryTypes getActiveUserRegistry() {
		return activeUserRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveUserRegistry(WasUserRegistryTypes newActiveUserRegistry) {
		WasUserRegistryTypes oldActiveUserRegistry = activeUserRegistry;
		activeUserRegistry = newActiveUserRegistry == null ? ACTIVE_USER_REGISTRY_EDEFAULT : newActiveUserRegistry;
		boolean oldActiveUserRegistryESet = activeUserRegistryESet;
		activeUserRegistryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY, oldActiveUserRegistry, activeUserRegistry, !oldActiveUserRegistryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActiveUserRegistry() {
		WasUserRegistryTypes oldActiveUserRegistry = activeUserRegistry;
		boolean oldActiveUserRegistryESet = activeUserRegistryESet;
		activeUserRegistry = ACTIVE_USER_REGISTRY_EDEFAULT;
		activeUserRegistryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY, oldActiveUserRegistry, ACTIVE_USER_REGISTRY_EDEFAULT, oldActiveUserRegistryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActiveUserRegistry() {
		return activeUserRegistryESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowAllPermissionForApplication() {
		return allowAllPermissionForApplication;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowAllPermissionForApplication(boolean newAllowAllPermissionForApplication) {
		boolean oldAllowAllPermissionForApplication = allowAllPermissionForApplication;
		allowAllPermissionForApplication = newAllowAllPermissionForApplication;
		boolean oldAllowAllPermissionForApplicationESet = allowAllPermissionForApplicationESet;
		allowAllPermissionForApplicationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION, oldAllowAllPermissionForApplication, allowAllPermissionForApplication, !oldAllowAllPermissionForApplicationESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAllowAllPermissionForApplication() {
		boolean oldAllowAllPermissionForApplication = allowAllPermissionForApplication;
		boolean oldAllowAllPermissionForApplicationESet = allowAllPermissionForApplicationESet;
		allowAllPermissionForApplication = ALLOW_ALL_PERMISSION_FOR_APPLICATION_EDEFAULT;
		allowAllPermissionForApplicationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION, oldAllowAllPermissionForApplication, ALLOW_ALL_PERMISSION_FOR_APPLICATION_EDEFAULT, oldAllowAllPermissionForApplicationESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAllowAllPermissionForApplication() {
		return allowAllPermissionForApplicationESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCacheTimeout() {
		return cacheTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheTimeout(String newCacheTimeout) {
		String oldCacheTimeout = cacheTimeout;
		cacheTimeout = newCacheTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__CACHE_TIMEOUT, oldCacheTimeout, cacheTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforceFineGrainedJCASecurity() {
		return enforceFineGrainedJCASecurity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforceFineGrainedJCASecurity(boolean newEnforceFineGrainedJCASecurity) {
		boolean oldEnforceFineGrainedJCASecurity = enforceFineGrainedJCASecurity;
		enforceFineGrainedJCASecurity = newEnforceFineGrainedJCASecurity;
		boolean oldEnforceFineGrainedJCASecurityESet = enforceFineGrainedJCASecurityESet;
		enforceFineGrainedJCASecurityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY, oldEnforceFineGrainedJCASecurity, enforceFineGrainedJCASecurity, !oldEnforceFineGrainedJCASecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnforceFineGrainedJCASecurity() {
		boolean oldEnforceFineGrainedJCASecurity = enforceFineGrainedJCASecurity;
		boolean oldEnforceFineGrainedJCASecurityESet = enforceFineGrainedJCASecurityESet;
		enforceFineGrainedJCASecurity = ENFORCE_FINE_GRAINED_JCA_SECURITY_EDEFAULT;
		enforceFineGrainedJCASecurityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY, oldEnforceFineGrainedJCASecurity, ENFORCE_FINE_GRAINED_JCA_SECURITY_EDEFAULT, oldEnforceFineGrainedJCASecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnforceFineGrainedJCASecurity() {
		return enforceFineGrainedJCASecurityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforceJava2SecRuntimeFiletering() {
		return enforceJava2SecRuntimeFiletering;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforceJava2SecRuntimeFiletering(boolean newEnforceJava2SecRuntimeFiletering) {
		boolean oldEnforceJava2SecRuntimeFiletering = enforceJava2SecRuntimeFiletering;
		enforceJava2SecRuntimeFiletering = newEnforceJava2SecRuntimeFiletering;
		boolean oldEnforceJava2SecRuntimeFileteringESet = enforceJava2SecRuntimeFileteringESet;
		enforceJava2SecRuntimeFileteringESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING, oldEnforceJava2SecRuntimeFiletering, enforceJava2SecRuntimeFiletering, !oldEnforceJava2SecRuntimeFileteringESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnforceJava2SecRuntimeFiletering() {
		boolean oldEnforceJava2SecRuntimeFiletering = enforceJava2SecRuntimeFiletering;
		boolean oldEnforceJava2SecRuntimeFileteringESet = enforceJava2SecRuntimeFileteringESet;
		enforceJava2SecRuntimeFiletering = ENFORCE_JAVA2_SEC_RUNTIME_FILETERING_EDEFAULT;
		enforceJava2SecRuntimeFileteringESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING, oldEnforceJava2SecRuntimeFiletering, ENFORCE_JAVA2_SEC_RUNTIME_FILETERING_EDEFAULT, oldEnforceJava2SecRuntimeFileteringESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnforceJava2SecRuntimeFiletering() {
		return enforceJava2SecRuntimeFileteringESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforceJava2Security() {
		return enforceJava2Security;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforceJava2Security(boolean newEnforceJava2Security) {
		boolean oldEnforceJava2Security = enforceJava2Security;
		enforceJava2Security = newEnforceJava2Security;
		boolean oldEnforceJava2SecurityESet = enforceJava2SecurityESet;
		enforceJava2SecurityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY, oldEnforceJava2Security, enforceJava2Security, !oldEnforceJava2SecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnforceJava2Security() {
		boolean oldEnforceJava2Security = enforceJava2Security;
		boolean oldEnforceJava2SecurityESet = enforceJava2SecurityESet;
		enforceJava2Security = ENFORCE_JAVA2_SECURITY_EDEFAULT;
		enforceJava2SecurityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY, oldEnforceJava2Security, ENFORCE_JAVA2_SECURITY_EDEFAULT, oldEnforceJava2SecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnforceJava2Security() {
		return enforceJava2SecurityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGlobalSecurityEnabled() {
		return globalSecurityEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalSecurityEnabled(boolean newGlobalSecurityEnabled) {
		boolean oldGlobalSecurityEnabled = globalSecurityEnabled;
		globalSecurityEnabled = newGlobalSecurityEnabled;
		boolean oldGlobalSecurityEnabledESet = globalSecurityEnabledESet;
		globalSecurityEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED, oldGlobalSecurityEnabled, globalSecurityEnabled, !oldGlobalSecurityEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGlobalSecurityEnabled() {
		boolean oldGlobalSecurityEnabled = globalSecurityEnabled;
		boolean oldGlobalSecurityEnabledESet = globalSecurityEnabledESet;
		globalSecurityEnabled = GLOBAL_SECURITY_ENABLED_EDEFAULT;
		globalSecurityEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED, oldGlobalSecurityEnabled, GLOBAL_SECURITY_ENABLED_EDEFAULT, oldGlobalSecurityEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGlobalSecurityEnabled() {
		return globalSecurityEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIssuePermissionWarning() {
		return issuePermissionWarning;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssuePermissionWarning(boolean newIssuePermissionWarning) {
		boolean oldIssuePermissionWarning = issuePermissionWarning;
		issuePermissionWarning = newIssuePermissionWarning;
		boolean oldIssuePermissionWarningESet = issuePermissionWarningESet;
		issuePermissionWarningESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING, oldIssuePermissionWarning, issuePermissionWarning, !oldIssuePermissionWarningESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIssuePermissionWarning() {
		boolean oldIssuePermissionWarning = issuePermissionWarning;
		boolean oldIssuePermissionWarningESet = issuePermissionWarningESet;
		issuePermissionWarning = ISSUE_PERMISSION_WARNING_EDEFAULT;
		issuePermissionWarningESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING, oldIssuePermissionWarning, ISSUE_PERMISSION_WARNING_EDEFAULT, oldIssuePermissionWarningESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIssuePermissionWarning() {
		return issuePermissionWarningESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseDomainQualifiedNames() {
		return useDomainQualifiedNames;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseDomainQualifiedNames(boolean newUseDomainQualifiedNames) {
		boolean oldUseDomainQualifiedNames = useDomainQualifiedNames;
		useDomainQualifiedNames = newUseDomainQualifiedNames;
		boolean oldUseDomainQualifiedNamesESet = useDomainQualifiedNamesESet;
		useDomainQualifiedNamesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES, oldUseDomainQualifiedNames, useDomainQualifiedNames, !oldUseDomainQualifiedNamesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseDomainQualifiedNames() {
		boolean oldUseDomainQualifiedNames = useDomainQualifiedNames;
		boolean oldUseDomainQualifiedNamesESet = useDomainQualifiedNamesESet;
		useDomainQualifiedNames = USE_DOMAIN_QUALIFIED_NAMES_EDEFAULT;
		useDomainQualifiedNamesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES, oldUseDomainQualifiedNames, USE_DOMAIN_QUALIFIED_NAMES_EDEFAULT, oldUseDomainQualifiedNamesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseDomainQualifiedNames() {
		return useDomainQualifiedNamesESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM:
				return getActiveAuthMechanism();
			case WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL:
				return getActiveProtocol();
			case WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY:
				return getActiveUserRegistry();
			case WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION:
				return isAllowAllPermissionForApplication() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__CACHE_TIMEOUT:
				return getCacheTimeout();
			case WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY:
				return isEnforceFineGrainedJCASecurity() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING:
				return isEnforceJava2SecRuntimeFiletering() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY:
				return isEnforceJava2Security() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED:
				return isGlobalSecurityEnabled() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING:
				return isIssuePermissionWarning() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES:
				return isUseDomainQualifiedNames() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM:
				setActiveAuthMechanism((String)newValue);
				return;
			case WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL:
				setActiveProtocol((IIOPSecurityProtocols)newValue);
				return;
			case WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY:
				setActiveUserRegistry((WasUserRegistryTypes)newValue);
				return;
			case WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION:
				setAllowAllPermissionForApplication(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__CACHE_TIMEOUT:
				setCacheTimeout((String)newValue);
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY:
				setEnforceFineGrainedJCASecurity(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING:
				setEnforceJava2SecRuntimeFiletering(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY:
				setEnforceJava2Security(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED:
				setGlobalSecurityEnabled(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING:
				setIssuePermissionWarning(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES:
				setUseDomainQualifiedNames(((Boolean)newValue).booleanValue());
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
			case WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM:
				setActiveAuthMechanism(ACTIVE_AUTH_MECHANISM_EDEFAULT);
				return;
			case WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL:
				unsetActiveProtocol();
				return;
			case WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY:
				unsetActiveUserRegistry();
				return;
			case WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION:
				unsetAllowAllPermissionForApplication();
				return;
			case WasPackage.WAS_SECURITY__CACHE_TIMEOUT:
				setCacheTimeout(CACHE_TIMEOUT_EDEFAULT);
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY:
				unsetEnforceFineGrainedJCASecurity();
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING:
				unsetEnforceJava2SecRuntimeFiletering();
				return;
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY:
				unsetEnforceJava2Security();
				return;
			case WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED:
				unsetGlobalSecurityEnabled();
				return;
			case WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING:
				unsetIssuePermissionWarning();
				return;
			case WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES:
				unsetUseDomainQualifiedNames();
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
			case WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM:
				return ACTIVE_AUTH_MECHANISM_EDEFAULT == null ? activeAuthMechanism != null : !ACTIVE_AUTH_MECHANISM_EDEFAULT.equals(activeAuthMechanism);
			case WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL:
				return isSetActiveProtocol();
			case WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY:
				return isSetActiveUserRegistry();
			case WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION:
				return isSetAllowAllPermissionForApplication();
			case WasPackage.WAS_SECURITY__CACHE_TIMEOUT:
				return CACHE_TIMEOUT_EDEFAULT == null ? cacheTimeout != null : !CACHE_TIMEOUT_EDEFAULT.equals(cacheTimeout);
			case WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY:
				return isSetEnforceFineGrainedJCASecurity();
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING:
				return isSetEnforceJava2SecRuntimeFiletering();
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY:
				return isSetEnforceJava2Security();
			case WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED:
				return isSetGlobalSecurityEnabled();
			case WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING:
				return isSetIssuePermissionWarning();
			case WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES:
				return isSetUseDomainQualifiedNames();
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
		result.append(" (activeAuthMechanism: "); //$NON-NLS-1$
		result.append(activeAuthMechanism);
		result.append(", activeProtocol: "); //$NON-NLS-1$
		if (activeProtocolESet) result.append(activeProtocol); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", activeUserRegistry: "); //$NON-NLS-1$
		if (activeUserRegistryESet) result.append(activeUserRegistry); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", allowAllPermissionForApplication: "); //$NON-NLS-1$
		if (allowAllPermissionForApplicationESet) result.append(allowAllPermissionForApplication); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", cacheTimeout: "); //$NON-NLS-1$
		result.append(cacheTimeout);
		result.append(", enforceFineGrainedJCASecurity: "); //$NON-NLS-1$
		if (enforceFineGrainedJCASecurityESet) result.append(enforceFineGrainedJCASecurity); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", enforceJava2SecRuntimeFiletering: "); //$NON-NLS-1$
		if (enforceJava2SecRuntimeFileteringESet) result.append(enforceJava2SecRuntimeFiletering); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", enforceJava2Security: "); //$NON-NLS-1$
		if (enforceJava2SecurityESet) result.append(enforceJava2Security); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", globalSecurityEnabled: "); //$NON-NLS-1$
		if (globalSecurityEnabledESet) result.append(globalSecurityEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", issuePermissionWarning: "); //$NON-NLS-1$
		if (issuePermissionWarningESet) result.append(issuePermissionWarning); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", useDomainQualifiedNames: "); //$NON-NLS-1$
		if (useDomainQualifiedNamesESet) result.append(useDomainQualifiedNames); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasSecurityImpl
