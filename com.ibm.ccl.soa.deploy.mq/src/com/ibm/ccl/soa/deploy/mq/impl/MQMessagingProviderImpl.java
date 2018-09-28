/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.mq.MQMessagingProvider;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Messaging Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl#getNativePath <em>Native Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQMessagingProviderImpl extends CapabilityImpl implements MQMessagingProvider {
	/**
	 * The default value of the '{@link #getClassPath() <em>Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPath()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassPath() <em>Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPath()
	 * @generated
	 * @ordered
	 */
	protected String classPath = CLASS_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected String description1 = DESCRIPTION1_EDEFAULT;

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
	 * The default value of the '{@link #getNativePath() <em>Native Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativePath()
	 * @generated
	 * @ordered
	 */
	protected static final String NATIVE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNativePath() <em>Native Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativePath()
	 * @generated
	 * @ordered
	 */
	protected String nativePath = NATIVE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQMessagingProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_MESSAGING_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassPath() {
		return classPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassPath(String newClassPath) {
		String oldClassPath = classPath;
		classPath = newClassPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_MESSAGING_PROVIDER__CLASS_PATH, oldClassPath, classPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription1() {
		return description1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription1(String newDescription1) {
		String oldDescription1 = description1;
		description1 = newDescription1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_MESSAGING_PROVIDER__DESCRIPTION1, oldDescription1, description1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_MESSAGING_PROVIDER__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNativePath() {
		return nativePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativePath(String newNativePath) {
		String oldNativePath = nativePath;
		nativePath = newNativePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_MESSAGING_PROVIDER__NATIVE_PATH, oldNativePath, nativePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_MESSAGING_PROVIDER__CLASS_PATH:
				return getClassPath();
			case MqPackage.MQ_MESSAGING_PROVIDER__DESCRIPTION1:
				return getDescription1();
			case MqPackage.MQ_MESSAGING_PROVIDER__NAME1:
				return getName1();
			case MqPackage.MQ_MESSAGING_PROVIDER__NATIVE_PATH:
				return getNativePath();
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
			case MqPackage.MQ_MESSAGING_PROVIDER__CLASS_PATH:
				setClassPath((String)newValue);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__NAME1:
				setName1((String)newValue);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__NATIVE_PATH:
				setNativePath((String)newValue);
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
			case MqPackage.MQ_MESSAGING_PROVIDER__CLASS_PATH:
				setClassPath(CLASS_PATH_EDEFAULT);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case MqPackage.MQ_MESSAGING_PROVIDER__NATIVE_PATH:
				setNativePath(NATIVE_PATH_EDEFAULT);
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
			case MqPackage.MQ_MESSAGING_PROVIDER__CLASS_PATH:
				return CLASS_PATH_EDEFAULT == null ? classPath != null : !CLASS_PATH_EDEFAULT.equals(classPath);
			case MqPackage.MQ_MESSAGING_PROVIDER__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case MqPackage.MQ_MESSAGING_PROVIDER__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case MqPackage.MQ_MESSAGING_PROVIDER__NATIVE_PATH:
				return NATIVE_PATH_EDEFAULT == null ? nativePath != null : !NATIVE_PATH_EDEFAULT.equals(nativePath);
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
		result.append(" (classPath: "); //$NON-NLS-1$
		result.append(classPath);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", nativePath: "); //$NON-NLS-1$
		result.append(nativePath);
		result.append(')');
		return result.toString();
	}

} //MQMessagingProviderImpl
