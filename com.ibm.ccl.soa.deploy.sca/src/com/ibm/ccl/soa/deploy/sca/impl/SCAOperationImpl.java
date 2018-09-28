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
import com.ibm.ccl.soa.deploy.sca.SCAOperation;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl#getPolicySets <em>Policy Sets</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl#getRequires <em>Requires</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCAOperationImpl extends CapabilityImpl implements SCAOperation {
	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

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
	protected SCAOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_OPERATION__NAME1, oldName1, name1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_OPERATION__POLICY_SETS, oldPolicySets, policySets));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_OPERATION__REQUIRES, oldRequires, requires));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_OPERATION__NAME1:
				return getName1();
			case ScaPackage.SCA_OPERATION__POLICY_SETS:
				return getPolicySets();
			case ScaPackage.SCA_OPERATION__REQUIRES:
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
			case ScaPackage.SCA_OPERATION__NAME1:
				setName1((String)newValue);
				return;
			case ScaPackage.SCA_OPERATION__POLICY_SETS:
				setPolicySets((String)newValue);
				return;
			case ScaPackage.SCA_OPERATION__REQUIRES:
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
			case ScaPackage.SCA_OPERATION__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case ScaPackage.SCA_OPERATION__POLICY_SETS:
				setPolicySets(POLICY_SETS_EDEFAULT);
				return;
			case ScaPackage.SCA_OPERATION__REQUIRES:
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
			case ScaPackage.SCA_OPERATION__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case ScaPackage.SCA_OPERATION__POLICY_SETS:
				return POLICY_SETS_EDEFAULT == null ? policySets != null : !POLICY_SETS_EDEFAULT.equals(policySets);
			case ScaPackage.SCA_OPERATION__REQUIRES:
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
		result.append(" (name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", policySets: "); //$NON-NLS-1$
		result.append(policySets);
		result.append(", requires: "); //$NON-NLS-1$
		result.append(requires);
		result.append(')');
		return result.toString();
	}

} //SCAOperationImpl
