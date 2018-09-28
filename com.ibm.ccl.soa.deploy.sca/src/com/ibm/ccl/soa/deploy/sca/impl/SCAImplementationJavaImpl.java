/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationJava;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Implementation Java</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl#getPolicySets <em>Policy Sets</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl#getRequires <em>Requires</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCAImplementationJavaImpl extends CapabilityImpl implements SCAImplementationJava {
	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolicySets() <em>Policy Sets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicySets()
	 * @generated
	 * @ordered
	 */
	protected static final String POLICY_SETS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPolicySets() <em>Policy Sets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicySets()
	 * @generated
	 * @ordered
	 */
	protected String policySets = POLICY_SETS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequires() <em>Requires</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected String requires = REQUIRES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCAImplementationJavaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_IMPLEMENTATION_JAVA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_IMPLEMENTATION_JAVA__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPolicySets() {
		return policySets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicySets(String newPolicySets) {
		String oldPolicySets = policySets;
		policySets = newPolicySets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_IMPLEMENTATION_JAVA__POLICY_SETS, oldPolicySets, policySets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequires() {
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequires(String newRequires) {
		String oldRequires = requires;
		requires = newRequires;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_IMPLEMENTATION_JAVA__REQUIRES, oldRequires, requires));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__CLASS:
				return getClass_();
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__POLICY_SETS:
				return getPolicySets();
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__REQUIRES:
				return getRequires();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__CLASS:
				setClass((String)newValue);
				return;
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__POLICY_SETS:
				setPolicySets((String)newValue);
				return;
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__REQUIRES:
				setRequires((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__POLICY_SETS:
				setPolicySets(POLICY_SETS_EDEFAULT);
				return;
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__REQUIRES:
				setRequires(REQUIRES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__POLICY_SETS:
				return POLICY_SETS_EDEFAULT == null ? policySets != null : !POLICY_SETS_EDEFAULT.equals(policySets);
			case ScaPackage.SCA_IMPLEMENTATION_JAVA__REQUIRES:
				return REQUIRES_EDEFAULT == null ? requires != null : !REQUIRES_EDEFAULT.equals(requires);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (class: "); //$NON-NLS-1$
		result.append(class_);
		result.append(", policySets: "); //$NON-NLS-1$
		result.append(policySets);
		result.append(", requires: "); //$NON-NLS-1$
		result.append(requires);
		result.append(')');
		return result.toString();
	}

} //SCAImplementationJavaImpl
