/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLPackageCapImpl.java,v 1.3 2007/12/05 21:54:25 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Package Cap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLPackageCapImpl#isCanonical <em>Canonical</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLPackageCapImpl extends UMLElementCapabilityImpl implements UMLPackageCap {
	/**
	 * The default value of the '{@link #isCanonical() <em>Canonical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanonical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CANONICAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanonical() <em>Canonical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanonical()
	 * @generated
	 * @ordered
	 */
	protected boolean canonical = CANONICAL_EDEFAULT;

	/**
	 * This is true if the Canonical attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean canonicalESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLPackageCapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.Literals.UML_PACKAGE_CAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanonical() {
		return canonical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanonical(boolean newCanonical) {
		boolean oldCanonical = canonical;
		canonical = newCanonical;
		boolean oldCanonicalESet = canonicalESet;
		canonicalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.UML_PACKAGE_CAP__CANONICAL, oldCanonical, canonical, !oldCanonicalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCanonical() {
		boolean oldCanonical = canonical;
		boolean oldCanonicalESet = canonicalESet;
		canonical = CANONICAL_EDEFAULT;
		canonicalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, UmlPackage.UML_PACKAGE_CAP__CANONICAL, oldCanonical, CANONICAL_EDEFAULT, oldCanonicalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCanonical() {
		return canonicalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlPackage.UML_PACKAGE_CAP__CANONICAL:
				return isCanonical() ? Boolean.TRUE : Boolean.FALSE;
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
			case UmlPackage.UML_PACKAGE_CAP__CANONICAL:
				setCanonical(((Boolean)newValue).booleanValue());
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
			case UmlPackage.UML_PACKAGE_CAP__CANONICAL:
				unsetCanonical();
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
			case UmlPackage.UML_PACKAGE_CAP__CANONICAL:
				return isSetCanonical();
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
		result.append(" (canonical: "); //$NON-NLS-1$
		if (canonicalESet) result.append(canonical); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //UMLPackageCapImpl
