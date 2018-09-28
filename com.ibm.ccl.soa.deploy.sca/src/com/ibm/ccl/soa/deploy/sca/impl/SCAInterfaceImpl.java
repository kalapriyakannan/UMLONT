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
import com.ibm.ccl.soa.deploy.sca.SCAInterface;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl#getCallBackInterface <em>Call Back Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl#getConversational <em>Conversational</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCAInterfaceImpl extends CapabilityImpl implements SCAInterface {
	/**
	 * The default value of the '{@link #getCallBackInterface() <em>Call Back Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallBackInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String CALL_BACK_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCallBackInterface() <em>Call Back Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallBackInterface()
	 * @generated
	 * @ordered
	 */
	protected String callBackInterface = CALL_BACK_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConversational() <em>Conversational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversational()
	 * @generated
	 * @ordered
	 */
	protected static final String CONVERSATIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConversational() <em>Conversational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversational()
	 * @generated
	 * @ordered
	 */
	protected String conversational = CONVERSATIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected String interface_ = INTERFACE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCAInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCallBackInterface() {
		return callBackInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallBackInterface(String newCallBackInterface) {
		String oldCallBackInterface = callBackInterface;
		callBackInterface = newCallBackInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_INTERFACE__CALL_BACK_INTERFACE, oldCallBackInterface, callBackInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConversational() {
		return conversational;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConversational(String newConversational) {
		String oldConversational = conversational;
		conversational = newConversational;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_INTERFACE__CONVERSATIONAL, oldConversational, conversational));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(String newInterface) {
		String oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_INTERFACE__INTERFACE, oldInterface, interface_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_INTERFACE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_INTERFACE__CALL_BACK_INTERFACE:
				return getCallBackInterface();
			case ScaPackage.SCA_INTERFACE__CONVERSATIONAL:
				return getConversational();
			case ScaPackage.SCA_INTERFACE__INTERFACE:
				return getInterface();
			case ScaPackage.SCA_INTERFACE__NAME1:
				return getName1();
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
			case ScaPackage.SCA_INTERFACE__CALL_BACK_INTERFACE:
				setCallBackInterface((String)newValue);
				return;
			case ScaPackage.SCA_INTERFACE__CONVERSATIONAL:
				setConversational((String)newValue);
				return;
			case ScaPackage.SCA_INTERFACE__INTERFACE:
				setInterface((String)newValue);
				return;
			case ScaPackage.SCA_INTERFACE__NAME1:
				setName1((String)newValue);
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
			case ScaPackage.SCA_INTERFACE__CALL_BACK_INTERFACE:
				setCallBackInterface(CALL_BACK_INTERFACE_EDEFAULT);
				return;
			case ScaPackage.SCA_INTERFACE__CONVERSATIONAL:
				setConversational(CONVERSATIONAL_EDEFAULT);
				return;
			case ScaPackage.SCA_INTERFACE__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case ScaPackage.SCA_INTERFACE__NAME1:
				setName1(NAME1_EDEFAULT);
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
			case ScaPackage.SCA_INTERFACE__CALL_BACK_INTERFACE:
				return CALL_BACK_INTERFACE_EDEFAULT == null ? callBackInterface != null : !CALL_BACK_INTERFACE_EDEFAULT.equals(callBackInterface);
			case ScaPackage.SCA_INTERFACE__CONVERSATIONAL:
				return CONVERSATIONAL_EDEFAULT == null ? conversational != null : !CONVERSATIONAL_EDEFAULT.equals(conversational);
			case ScaPackage.SCA_INTERFACE__INTERFACE:
				return INTERFACE_EDEFAULT == null ? interface_ != null : !INTERFACE_EDEFAULT.equals(interface_);
			case ScaPackage.SCA_INTERFACE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
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
		result.append(" (callBackInterface: "); //$NON-NLS-1$
		result.append(callBackInterface);
		result.append(", conversational: "); //$NON-NLS-1$
		result.append(conversational);
		result.append(", interface: "); //$NON-NLS-1$
		result.append(interface_);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(')');
		return result.toString();
	}

} //SCAInterfaceImpl
