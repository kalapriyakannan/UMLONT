/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#isIsDefaultProfile <em>Is Default Profile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#isIsManaged <em>Is Managed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#getProfileLocation <em>Profile Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#getProfileType <em>Profile Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeImpl#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasNodeImpl extends CapabilityImpl implements WasNode {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isIsDefaultProfile() <em>Is Default Profile</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsDefaultProfile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFAULT_PROFILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefaultProfile() <em>Is Default Profile</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsDefaultProfile()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefaultProfile = IS_DEFAULT_PROFILE_EDEFAULT;

	/**
	 * This is true if the Is Default Profile attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isDefaultProfileESet;

	/**
	 * The default value of the '{@link #isIsManaged() <em>Is Managed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsManaged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANAGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsManaged() <em>Is Managed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsManaged()
	 * @generated
	 * @ordered
	 */
	protected boolean isManaged = IS_MANAGED_EDEFAULT;

	/**
	 * This is true if the Is Managed attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isManagedESet;

	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileLocation() <em>Profile Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProfileLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileLocation() <em>Profile Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProfileLocation()
	 * @generated
	 * @ordered
	 */
	protected String profileLocation = PROFILE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileName() <em>Profile Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfileName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileName() <em>Profile Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfileName()
	 * @generated
	 * @ordered
	 */
	protected String profileName = PROFILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileType() <em>Profile Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfileType()
	 * @generated
	 * @ordered
	 */
	protected static final WasProfileTypeEnum PROFILE_TYPE_EDEFAULT = WasProfileTypeEnum.DMGR_LITERAL;

	/**
	 * The cached value of the '{@link #getProfileType() <em>Profile Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProfileType()
	 * @generated
	 * @ordered
	 */
	protected WasProfileTypeEnum profileType = PROFILE_TYPE_EDEFAULT;

	/**
	 * This is true if the Profile Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean profileTypeESet;

	/**
	 * The default value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasVersion = WAS_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDefaultProfile() {
		return isDefaultProfile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDefaultProfile(boolean newIsDefaultProfile) {
		boolean oldIsDefaultProfile = isDefaultProfile;
		isDefaultProfile = newIsDefaultProfile;
		boolean oldIsDefaultProfileESet = isDefaultProfileESet;
		isDefaultProfileESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__IS_DEFAULT_PROFILE, oldIsDefaultProfile, isDefaultProfile, !oldIsDefaultProfileESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsDefaultProfile() {
		boolean oldIsDefaultProfile = isDefaultProfile;
		boolean oldIsDefaultProfileESet = isDefaultProfileESet;
		isDefaultProfile = IS_DEFAULT_PROFILE_EDEFAULT;
		isDefaultProfileESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_NODE__IS_DEFAULT_PROFILE, oldIsDefaultProfile, IS_DEFAULT_PROFILE_EDEFAULT, oldIsDefaultProfileESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsDefaultProfile() {
		return isDefaultProfileESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsManaged() {
		return isManaged;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsManaged(boolean newIsManaged) {
		boolean oldIsManaged = isManaged;
		isManaged = newIsManaged;
		boolean oldIsManagedESet = isManagedESet;
		isManagedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__IS_MANAGED, oldIsManaged, isManaged, !oldIsManagedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsManaged() {
		boolean oldIsManaged = isManaged;
		boolean oldIsManagedESet = isManagedESet;
		isManaged = IS_MANAGED_EDEFAULT;
		isManagedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_NODE__IS_MANAGED, oldIsManaged, IS_MANAGED_EDEFAULT, oldIsManagedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsManaged() {
		return isManagedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__NODE_NAME, oldNodeName, nodeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileLocation() {
		return profileLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileLocation(String newProfileLocation) {
		String oldProfileLocation = profileLocation;
		profileLocation = newProfileLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__PROFILE_LOCATION, oldProfileLocation, profileLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileName(String newProfileName) {
		String oldProfileName = profileName;
		profileName = newProfileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__PROFILE_NAME, oldProfileName, profileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasProfileTypeEnum getProfileType() {
		return profileType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileType(WasProfileTypeEnum newProfileType) {
		WasProfileTypeEnum oldProfileType = profileType;
		profileType = newProfileType == null ? PROFILE_TYPE_EDEFAULT : newProfileType;
		boolean oldProfileTypeESet = profileTypeESet;
		profileTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__PROFILE_TYPE, oldProfileType, profileType, !oldProfileTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileType() {
		WasProfileTypeEnum oldProfileType = profileType;
		boolean oldProfileTypeESet = profileTypeESet;
		profileType = PROFILE_TYPE_EDEFAULT;
		profileTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_NODE__PROFILE_TYPE, oldProfileType, PROFILE_TYPE_EDEFAULT, oldProfileTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileType() {
		return profileTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasVersion() {
		return wasVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasVersion(String newWasVersion) {
		String oldWasVersion = wasVersion;
		wasVersion = newWasVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE__WAS_VERSION, oldWasVersion, wasVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_NODE__IS_DEFAULT_PROFILE:
				return isIsDefaultProfile() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_NODE__IS_MANAGED:
				return isIsManaged() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_NODE__NODE_NAME:
				return getNodeName();
			case WasPackage.WAS_NODE__PROFILE_LOCATION:
				return getProfileLocation();
			case WasPackage.WAS_NODE__PROFILE_NAME:
				return getProfileName();
			case WasPackage.WAS_NODE__PROFILE_TYPE:
				return getProfileType();
			case WasPackage.WAS_NODE__WAS_VERSION:
				return getWasVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_NODE__IS_DEFAULT_PROFILE:
				setIsDefaultProfile(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_NODE__IS_MANAGED:
				setIsManaged(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_NODE__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case WasPackage.WAS_NODE__PROFILE_LOCATION:
				setProfileLocation((String)newValue);
				return;
			case WasPackage.WAS_NODE__PROFILE_NAME:
				setProfileName((String)newValue);
				return;
			case WasPackage.WAS_NODE__PROFILE_TYPE:
				setProfileType((WasProfileTypeEnum)newValue);
				return;
			case WasPackage.WAS_NODE__WAS_VERSION:
				setWasVersion((String)newValue);
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
			case WasPackage.WAS_NODE__IS_DEFAULT_PROFILE:
				unsetIsDefaultProfile();
				return;
			case WasPackage.WAS_NODE__IS_MANAGED:
				unsetIsManaged();
				return;
			case WasPackage.WAS_NODE__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_NODE__PROFILE_LOCATION:
				setProfileLocation(PROFILE_LOCATION_EDEFAULT);
				return;
			case WasPackage.WAS_NODE__PROFILE_NAME:
				setProfileName(PROFILE_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_NODE__PROFILE_TYPE:
				unsetProfileType();
				return;
			case WasPackage.WAS_NODE__WAS_VERSION:
				setWasVersion(WAS_VERSION_EDEFAULT);
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
			case WasPackage.WAS_NODE__IS_DEFAULT_PROFILE:
				return isSetIsDefaultProfile();
			case WasPackage.WAS_NODE__IS_MANAGED:
				return isSetIsManaged();
			case WasPackage.WAS_NODE__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case WasPackage.WAS_NODE__PROFILE_LOCATION:
				return PROFILE_LOCATION_EDEFAULT == null ? profileLocation != null : !PROFILE_LOCATION_EDEFAULT.equals(profileLocation);
			case WasPackage.WAS_NODE__PROFILE_NAME:
				return PROFILE_NAME_EDEFAULT == null ? profileName != null : !PROFILE_NAME_EDEFAULT.equals(profileName);
			case WasPackage.WAS_NODE__PROFILE_TYPE:
				return isSetProfileType();
			case WasPackage.WAS_NODE__WAS_VERSION:
				return WAS_VERSION_EDEFAULT == null ? wasVersion != null : !WAS_VERSION_EDEFAULT.equals(wasVersion);
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
		result.append(" (isDefaultProfile: "); //$NON-NLS-1$
		if (isDefaultProfileESet) result.append(isDefaultProfile); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", isManaged: "); //$NON-NLS-1$
		if (isManagedESet) result.append(isManaged); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", nodeName: "); //$NON-NLS-1$
		result.append(nodeName);
		result.append(", profileLocation: "); //$NON-NLS-1$
		result.append(profileLocation);
		result.append(", profileName: "); //$NON-NLS-1$
		result.append(profileName);
		result.append(", profileType: "); //$NON-NLS-1$
		if (profileTypeESet) result.append(profileType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", wasVersion: "); //$NON-NLS-1$
		result.append(wasVersion);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.unmodifiableList(Arrays
			.asList(new EAttribute[] { WasPackage.eINSTANCE.getWasNode_ProfileName(),
					WasPackage.eINSTANCE.getWasNode_NodeName() }));

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasNodeImpl
