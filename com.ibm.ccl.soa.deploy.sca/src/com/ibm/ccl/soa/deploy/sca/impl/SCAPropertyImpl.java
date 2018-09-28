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
import com.ibm.ccl.soa.deploy.sca.SCAProperty;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl#getElement <em>Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl#getMany <em>Many</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl#getMustSupply <em>Must Supply</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCAPropertyImpl extends CapabilityImpl implements SCAProperty {
	/**
	 * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected String element = ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMany()
	 * @generated
	 * @ordered
	 */
	protected static final String MANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMany()
	 * @generated
	 * @ordered
	 */
	protected String many = MANY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMustSupply() <em>Must Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMustSupply()
	 * @generated
	 * @ordered
	 */
	protected static final String MUST_SUPPLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMustSupply() <em>Must Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMustSupply()
	 * @generated
	 * @ordered
	 */
	protected String mustSupply = MUST_SUPPLY_EDEFAULT;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCAPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(String newElement) {
		String oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMany() {
		return many;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMany(String newMany) {
		String oldMany = many;
		many = newMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY__MANY, oldMany, many));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMustSupply() {
		return mustSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMustSupply(String newMustSupply) {
		String oldMustSupply = mustSupply;
		mustSupply = newMustSupply;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY__MUST_SUPPLY, oldMustSupply, mustSupply));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_PROPERTY__ELEMENT:
				return getElement();
			case ScaPackage.SCA_PROPERTY__MANY:
				return getMany();
			case ScaPackage.SCA_PROPERTY__MUST_SUPPLY:
				return getMustSupply();
			case ScaPackage.SCA_PROPERTY__NAME1:
				return getName1();
			case ScaPackage.SCA_PROPERTY__VALUE:
				return getValue();
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
			case ScaPackage.SCA_PROPERTY__ELEMENT:
				setElement((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY__MANY:
				setMany((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY__MUST_SUPPLY:
				setMustSupply((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY__NAME1:
				setName1((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY__VALUE:
				setValue((String)newValue);
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
			case ScaPackage.SCA_PROPERTY__ELEMENT:
				setElement(ELEMENT_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY__MANY:
				setMany(MANY_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY__MUST_SUPPLY:
				setMustSupply(MUST_SUPPLY_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ScaPackage.SCA_PROPERTY__ELEMENT:
				return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
			case ScaPackage.SCA_PROPERTY__MANY:
				return MANY_EDEFAULT == null ? many != null : !MANY_EDEFAULT.equals(many);
			case ScaPackage.SCA_PROPERTY__MUST_SUPPLY:
				return MUST_SUPPLY_EDEFAULT == null ? mustSupply != null : !MUST_SUPPLY_EDEFAULT.equals(mustSupply);
			case ScaPackage.SCA_PROPERTY__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case ScaPackage.SCA_PROPERTY__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (element: "); //$NON-NLS-1$
		result.append(element);
		result.append(", many: "); //$NON-NLS-1$
		result.append(many);
		result.append(", mustSupply: "); //$NON-NLS-1$
		result.append(mustSupply);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //SCAPropertyImpl
