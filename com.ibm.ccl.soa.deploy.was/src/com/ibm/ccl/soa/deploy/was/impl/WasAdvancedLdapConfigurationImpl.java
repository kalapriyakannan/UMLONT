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
import com.ibm.ccl.soa.deploy.was.CertificateMapMode;
import com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Advanced Ldap Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getCertificateFilter <em>Certificate Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getCertificateMapMode <em>Certificate Map Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getGroupFilter <em>Group Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getGroupIdMap <em>Group Id Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getGroupMemberIdMap <em>Group Member Id Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getUserFilter <em>User Filter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasAdvancedLdapConfigurationImpl#getUserIdMap <em>User Id Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasAdvancedLdapConfigurationImpl extends CapabilityImpl implements
		WasAdvancedLdapConfiguration {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCertificateFilter() <em>Certificate Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCertificateFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String CERTIFICATE_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCertificateFilter() <em>Certificate Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCertificateFilter()
	 * @generated
	 * @ordered
	 */
	protected String certificateFilter = CERTIFICATE_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCertificateMapMode() <em>Certificate Map Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCertificateMapMode()
	 * @generated
	 * @ordered
	 */
	protected static final CertificateMapMode CERTIFICATE_MAP_MODE_EDEFAULT = CertificateMapMode.EXACTDN_LITERAL;

	/**
	 * The cached value of the '{@link #getCertificateMapMode() <em>Certificate Map Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCertificateMapMode()
	 * @generated
	 * @ordered
	 */
	protected CertificateMapMode certificateMapMode = CERTIFICATE_MAP_MODE_EDEFAULT;

	/**
	 * This is true if the Certificate Map Mode attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean certificateMapModeESet;

	/**
	 * The default value of the '{@link #getGroupFilter() <em>Group Filter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupFilter() <em>Group Filter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupFilter()
	 * @generated
	 * @ordered
	 */
	protected String groupFilter = GROUP_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupIdMap() <em>Group Id Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupIdMap()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupIdMap() <em>Group Id Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupIdMap()
	 * @generated
	 * @ordered
	 */
	protected String groupIdMap = GROUP_ID_MAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupMemberIdMap() <em>Group Member Id Map</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGroupMemberIdMap()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_MEMBER_ID_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupMemberIdMap() <em>Group Member Id Map</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGroupMemberIdMap()
	 * @generated
	 * @ordered
	 */
	protected String groupMemberIdMap = GROUP_MEMBER_ID_MAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserFilter() <em>User Filter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserFilter() <em>User Filter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserFilter()
	 * @generated
	 * @ordered
	 */
	protected String userFilter = USER_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserIdMap() <em>User Id Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserIdMap()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserIdMap() <em>User Id Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserIdMap()
	 * @generated
	 * @ordered
	 */
	protected String userIdMap = USER_ID_MAP_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasAdvancedLdapConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_ADVANCED_LDAP_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCertificateFilter() {
		return certificateFilter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCertificateFilter(String newCertificateFilter) {
		String oldCertificateFilter = certificateFilter;
		certificateFilter = newCertificateFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER, oldCertificateFilter, certificateFilter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CertificateMapMode getCertificateMapMode() {
		return certificateMapMode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCertificateMapMode(CertificateMapMode newCertificateMapMode) {
		CertificateMapMode oldCertificateMapMode = certificateMapMode;
		certificateMapMode = newCertificateMapMode == null ? CERTIFICATE_MAP_MODE_EDEFAULT : newCertificateMapMode;
		boolean oldCertificateMapModeESet = certificateMapModeESet;
		certificateMapModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE, oldCertificateMapMode, certificateMapMode, !oldCertificateMapModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCertificateMapMode() {
		CertificateMapMode oldCertificateMapMode = certificateMapMode;
		boolean oldCertificateMapModeESet = certificateMapModeESet;
		certificateMapMode = CERTIFICATE_MAP_MODE_EDEFAULT;
		certificateMapModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE, oldCertificateMapMode, CERTIFICATE_MAP_MODE_EDEFAULT, oldCertificateMapModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCertificateMapMode() {
		return certificateMapModeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupFilter() {
		return groupFilter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupFilter(String newGroupFilter) {
		String oldGroupFilter = groupFilter;
		groupFilter = newGroupFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER, oldGroupFilter, groupFilter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupIdMap() {
		return groupIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupIdMap(String newGroupIdMap) {
		String oldGroupIdMap = groupIdMap;
		groupIdMap = newGroupIdMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP, oldGroupIdMap, groupIdMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupMemberIdMap() {
		return groupMemberIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupMemberIdMap(String newGroupMemberIdMap) {
		String oldGroupMemberIdMap = groupMemberIdMap;
		groupMemberIdMap = newGroupMemberIdMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP, oldGroupMemberIdMap, groupMemberIdMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserFilter() {
		return userFilter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserFilter(String newUserFilter) {
		String oldUserFilter = userFilter;
		userFilter = newUserFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER, oldUserFilter, userFilter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserIdMap() {
		return userIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserIdMap(String newUserIdMap) {
		String oldUserIdMap = userIdMap;
		userIdMap = newUserIdMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP, oldUserIdMap, userIdMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER:
				return getCertificateFilter();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE:
				return getCertificateMapMode();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER:
				return getGroupFilter();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP:
				return getGroupIdMap();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP:
				return getGroupMemberIdMap();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER:
				return getUserFilter();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP:
				return getUserIdMap();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER:
				setCertificateFilter((String)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE:
				setCertificateMapMode((CertificateMapMode)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER:
				setGroupFilter((String)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP:
				setGroupIdMap((String)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP:
				setGroupMemberIdMap((String)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER:
				setUserFilter((String)newValue);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP:
				setUserIdMap((String)newValue);
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
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER:
				setCertificateFilter(CERTIFICATE_FILTER_EDEFAULT);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE:
				unsetCertificateMapMode();
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER:
				setGroupFilter(GROUP_FILTER_EDEFAULT);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP:
				setGroupIdMap(GROUP_ID_MAP_EDEFAULT);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP:
				setGroupMemberIdMap(GROUP_MEMBER_ID_MAP_EDEFAULT);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER:
				setUserFilter(USER_FILTER_EDEFAULT);
				return;
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP:
				setUserIdMap(USER_ID_MAP_EDEFAULT);
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
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER:
				return CERTIFICATE_FILTER_EDEFAULT == null ? certificateFilter != null : !CERTIFICATE_FILTER_EDEFAULT.equals(certificateFilter);
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE:
				return isSetCertificateMapMode();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER:
				return GROUP_FILTER_EDEFAULT == null ? groupFilter != null : !GROUP_FILTER_EDEFAULT.equals(groupFilter);
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP:
				return GROUP_ID_MAP_EDEFAULT == null ? groupIdMap != null : !GROUP_ID_MAP_EDEFAULT.equals(groupIdMap);
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP:
				return GROUP_MEMBER_ID_MAP_EDEFAULT == null ? groupMemberIdMap != null : !GROUP_MEMBER_ID_MAP_EDEFAULT.equals(groupMemberIdMap);
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER:
				return USER_FILTER_EDEFAULT == null ? userFilter != null : !USER_FILTER_EDEFAULT.equals(userFilter);
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP:
				return USER_ID_MAP_EDEFAULT == null ? userIdMap != null : !USER_ID_MAP_EDEFAULT.equals(userIdMap);
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
		result.append(" (certificateFilter: "); //$NON-NLS-1$
		result.append(certificateFilter);
		result.append(", certificateMapMode: "); //$NON-NLS-1$
		if (certificateMapModeESet) result.append(certificateMapMode); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", groupFilter: "); //$NON-NLS-1$
		result.append(groupFilter);
		result.append(", groupIdMap: "); //$NON-NLS-1$
		result.append(groupIdMap);
		result.append(", groupMemberIdMap: "); //$NON-NLS-1$
		result.append(groupMemberIdMap);
		result.append(", userFilter: "); //$NON-NLS-1$
		result.append(userFilter);
		result.append(", userIdMap: "); //$NON-NLS-1$
		result.append(userIdMap);
		result.append(')');
		return result.toString();
	}

} //WasAdvancedLdapConfigurationImpl
