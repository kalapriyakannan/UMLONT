/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.util.CapabilityCaptionProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#getBuildVersion <em>Build Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapabilityImpl extends DeployModelObjectImpl implements Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList stereotypes;

	/**
	 * The default value of the '{@link #getBuildVersion() <em>Build Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBuildVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildVersion() <em>Build Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBuildVersion()
	 * @generated
	 * @ordered
	 */
	protected String buildVersion = BUILD_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final CapabilityLinkTypes LINK_TYPE_EDEFAULT = CapabilityLinkTypes.DEPENDENCY_LITERAL;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected CapabilityLinkTypes linkType = LINK_TYPE_EDEFAULT;

	/**
	 * This is true if the Link Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean linkTypeESet;

	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CapabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CAPABILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectContainmentEList(Stereotype.class, this, CorePackage.CAPABILITY__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBuildVersion() {
		return buildVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildVersion(String newBuildVersion) {
		String oldBuildVersion = buildVersion;
		buildVersion = newBuildVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CAPABILITY__BUILD_VERSION, oldBuildVersion, buildVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityLinkTypes getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(CapabilityLinkTypes newLinkType) {
		CapabilityLinkTypes oldLinkType = linkType;
		linkType = newLinkType == null ? LINK_TYPE_EDEFAULT : newLinkType;
		boolean oldLinkTypeESet = linkTypeESet;
		linkTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CAPABILITY__LINK_TYPE, oldLinkType, linkType, !oldLinkTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinkType() {
		CapabilityLinkTypes oldLinkType = linkType;
		boolean oldLinkTypeESet = linkTypeESet;
		linkType = LINK_TYPE_EDEFAULT;
		linkTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.CAPABILITY__LINK_TYPE, oldLinkType, LINK_TYPE_EDEFAULT, oldLinkTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinkType() {
		return linkTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CAPABILITY__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isVisible() {
		return super.isVisible();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublic() {
		return super.isPublic();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublicEditable() {
		return super.isPublicEditable();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CAPABILITY__STEREOTYPES:
				return ((InternalEList)getStereotypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.CAPABILITY__STEREOTYPES:
				return getStereotypes();
			case CorePackage.CAPABILITY__BUILD_VERSION:
				return getBuildVersion();
			case CorePackage.CAPABILITY__LINK_TYPE:
				return getLinkType();
			case CorePackage.CAPABILITY__ORIGIN:
				return getOrigin();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.CAPABILITY__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection)newValue);
				return;
			case CorePackage.CAPABILITY__BUILD_VERSION:
				setBuildVersion((String)newValue);
				return;
			case CorePackage.CAPABILITY__LINK_TYPE:
				setLinkType((CapabilityLinkTypes)newValue);
				return;
			case CorePackage.CAPABILITY__ORIGIN:
				setOrigin((String)newValue);
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
			case CorePackage.CAPABILITY__STEREOTYPES:
				getStereotypes().clear();
				return;
			case CorePackage.CAPABILITY__BUILD_VERSION:
				setBuildVersion(BUILD_VERSION_EDEFAULT);
				return;
			case CorePackage.CAPABILITY__LINK_TYPE:
				unsetLinkType();
				return;
			case CorePackage.CAPABILITY__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
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
			case CorePackage.CAPABILITY__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case CorePackage.CAPABILITY__BUILD_VERSION:
				return BUILD_VERSION_EDEFAULT == null ? buildVersion != null : !BUILD_VERSION_EDEFAULT.equals(buildVersion);
			case CorePackage.CAPABILITY__LINK_TYPE:
				return isSetLinkType();
			case CorePackage.CAPABILITY__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
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
		result.append(" (buildVersion: "); //$NON-NLS-1$
		result.append(buildVersion);
		result.append(", linkType: "); //$NON-NLS-1$
		if (linkTypeESet) result.append(linkType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", origin: "); //$NON-NLS-1$
		result.append(origin);
		result.append(')');
		return result.toString();
	}

	//	/*
	//	 * If a Capability contributes titleKeys() then use them to synthesize a title, otherwise return
	//	 * null.
	//	 * 
	//	 * @see com.ibm.ccl.soa.deploy.core.Capability#calculatedTitle(java.util.Map)
	//	 * @deprecated
	//	 */
	//	public String calculatedTitle(Map<String, Object> hypotheticals) {
	//		List<EAttribute> titleKeys = titleKeys();
	//		if (titleKeys == null || titleKeys.size() == 0) {
	//			return null;
	//		}
	//
	//		// Optimization to avoid string buffer creation for common case of single key
	//		if (titleKeys.size() == 1) {
	//			return keyValue(titleKeys.get(0), hypotheticals);
	//		}
	//
	//		StringBuffer title = new StringBuffer();
	//		for (int i = 0; i < titleKeys.size(); i++) {
	//			title.append(keyValue(titleKeys.get(i), hypotheticals));
	//			if (i < titleKeys().size() - 1) {
	//				title.append(':');
	//			}
	//		}
	//		return title.toString();
	//	}

	//	private String keyValue(Object key, Map hypotheticals) {
	//		// No matter what is in the object, the hypothethical new value always overrides
	//		if (hypotheticals != null) {
	//			Object obj = hypotheticals.get(key);
	//			if (obj instanceof String) {
	//				return (String) obj;
	//			}
	//		}
	//
	//		Object retVal = null;
	//		if (key instanceof EStructuralFeature) {
	//			retVal = eGet((EStructuralFeature) key);
	//		} else if (key instanceof String) {
	//			retVal = DeployModelObjectUtil.getAttributeValue(this, (String) key);
	//		}
	//
	//		// Defect #415 fixed -- don't treat the empty string as more valid than null string
	//		if (retVal != null && (!(retVal instanceof String) || ((String) retVal).length() > 0)) {
	//			return retVal.toString();
	//		}
	//
	//		//		if (retVal != null) {
	//		//			return retVal.toString();
	//		//		}
	//
	//		// Attribute was null
	//		String attrName;
	//		if (key instanceof EStructuralFeature) {
	//			attrName = ((EStructuralFeature) key).getName();
	//		} else {
	//			attrName = key.toString();
	//		}
	//
	//		return "<no " + attrName + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	//	}

	//	/**
	//	 * @deprecated
	//	 */
	//	public String title() {
	//		if (getDisplayName() != null) {
	//			return getDisplayName();
	//		}
	//
	//		String retVal = calculatedTitle(null);
	//		if (retVal != null) {
	//			return retVal;
	//		}
	//
	//		return getName();
	//	}
	//
	//	/**
	//	 * @deprecated
	//	 */
	//	public String titleWithContext() {
	//		if (getParent() instanceof Unit) {
	//			Unit parent = (Unit) getParent();
	//			return title() + " in " + parent.getCaptionProvider().titleWithContext(parent); //$NON-NLS-1$
	//		}
	//
	//		return title();
	//	}

	public List<EAttribute> titleKeys() {
		return Collections.emptyList();
	}

	public CapabilityCaptionProvider getCaptionProvider() {
		return capCaptionProvider;
	}

	private static CapabilityCaptionProvider capCaptionProvider = new CapabilityCaptionProvider();

} //CapabilityImpl
