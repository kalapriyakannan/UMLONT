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
import com.ibm.ccl.soa.deploy.sca.SCAReference;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl#getAutowire <em>Autowire</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl#getWiredByImpl <em>Wired By Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCAReferenceImpl extends CapabilityImpl implements SCAReference {
	/**
	 * The default value of the '{@link #getAutowire() <em>Autowire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutowire()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTOWIRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutowire() <em>Autowire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutowire()
	 * @generated
	 * @ordered
	 */
	protected String autowire = AUTOWIRE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String multiplicity = MULTIPLICITY_EDEFAULT;

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
	 * The default value of the '{@link #getWiredByImpl() <em>Wired By Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWiredByImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String WIRED_BY_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWiredByImpl() <em>Wired By Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWiredByImpl()
	 * @generated
	 * @ordered
	 */
	protected String wiredByImpl = WIRED_BY_IMPL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCAReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutowire() {
		return autowire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutowire(String newAutowire) {
		String oldAutowire = autowire;
		autowire = newAutowire;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_REFERENCE__AUTOWIRE, oldAutowire, autowire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(String newMultiplicity) {
		String oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_REFERENCE__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_REFERENCE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWiredByImpl() {
		return wiredByImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWiredByImpl(String newWiredByImpl) {
		String oldWiredByImpl = wiredByImpl;
		wiredByImpl = newWiredByImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_REFERENCE__WIRED_BY_IMPL, oldWiredByImpl, wiredByImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_REFERENCE__AUTOWIRE:
				return getAutowire();
			case ScaPackage.SCA_REFERENCE__MULTIPLICITY:
				return getMultiplicity();
			case ScaPackage.SCA_REFERENCE__NAME1:
				return getName1();
			case ScaPackage.SCA_REFERENCE__WIRED_BY_IMPL:
				return getWiredByImpl();
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
			case ScaPackage.SCA_REFERENCE__AUTOWIRE:
				setAutowire((String)newValue);
				return;
			case ScaPackage.SCA_REFERENCE__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case ScaPackage.SCA_REFERENCE__NAME1:
				setName1((String)newValue);
				return;
			case ScaPackage.SCA_REFERENCE__WIRED_BY_IMPL:
				setWiredByImpl((String)newValue);
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
			case ScaPackage.SCA_REFERENCE__AUTOWIRE:
				setAutowire(AUTOWIRE_EDEFAULT);
				return;
			case ScaPackage.SCA_REFERENCE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case ScaPackage.SCA_REFERENCE__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case ScaPackage.SCA_REFERENCE__WIRED_BY_IMPL:
				setWiredByImpl(WIRED_BY_IMPL_EDEFAULT);
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
			case ScaPackage.SCA_REFERENCE__AUTOWIRE:
				return AUTOWIRE_EDEFAULT == null ? autowire != null : !AUTOWIRE_EDEFAULT.equals(autowire);
			case ScaPackage.SCA_REFERENCE__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case ScaPackage.SCA_REFERENCE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case ScaPackage.SCA_REFERENCE__WIRED_BY_IMPL:
				return WIRED_BY_IMPL_EDEFAULT == null ? wiredByImpl != null : !WIRED_BY_IMPL_EDEFAULT.equals(wiredByImpl);
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
		result.append(" (autowire: "); //$NON-NLS-1$
		result.append(autowire);
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", wiredByImpl: "); //$NON-NLS-1$
		result.append(wiredByImpl);
		result.append(')');
		return result.toString();
	}

} //SCAReferenceImpl
