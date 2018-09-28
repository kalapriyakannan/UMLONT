/**
 * <copyright> </copyright>
 * 
 * $Id: UMLElementCapabilityImpl.java,v 1.3 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl;
import com.ibm.ccl.soa.deploy.uml.UMLElementCapability;
import com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>UML Element Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementCapabilityImpl#getUmlVisibilityKind <em>Uml Visibility Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLElementCapabilityImpl extends BundleCapabilityImpl implements
		UMLElementCapability {
	/**
	 * The default value of the '{@link #getUmlVisibilityKind() <em>Uml Visibility Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUmlVisibilityKind()
	 * @generated
	 * @ordered
	 */
	protected static final UMLVisibilityKind UML_VISIBILITY_KIND_EDEFAULT = UMLVisibilityKind.PUBLIC_LITERAL;

	/**
	 * The cached value of the '{@link #getUmlVisibilityKind() <em>Uml Visibility Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUmlVisibilityKind()
	 * @generated
	 * @ordered
	 */
	protected UMLVisibilityKind umlVisibilityKind = UML_VISIBILITY_KIND_EDEFAULT;

	/**
	 * This is true if the Uml Visibility Kind attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean umlVisibilityKindESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLElementCapabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.Literals.UML_ELEMENT_CAPABILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLVisibilityKind getUmlVisibilityKind() {
		return umlVisibilityKind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlVisibilityKind(UMLVisibilityKind newUmlVisibilityKind) {
		UMLVisibilityKind oldUmlVisibilityKind = umlVisibilityKind;
		umlVisibilityKind = newUmlVisibilityKind == null ? UML_VISIBILITY_KIND_EDEFAULT : newUmlVisibilityKind;
		boolean oldUmlVisibilityKindESet = umlVisibilityKindESet;
		umlVisibilityKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND, oldUmlVisibilityKind, umlVisibilityKind, !oldUmlVisibilityKindESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUmlVisibilityKind() {
		UMLVisibilityKind oldUmlVisibilityKind = umlVisibilityKind;
		boolean oldUmlVisibilityKindESet = umlVisibilityKindESet;
		umlVisibilityKind = UML_VISIBILITY_KIND_EDEFAULT;
		umlVisibilityKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND, oldUmlVisibilityKind, UML_VISIBILITY_KIND_EDEFAULT, oldUmlVisibilityKindESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUmlVisibilityKind() {
		return umlVisibilityKindESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND:
				return getUmlVisibilityKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND:
				setUmlVisibilityKind((UMLVisibilityKind)newValue);
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
			case UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND:
				unsetUmlVisibilityKind();
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
			case UmlPackage.UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND:
				return isSetUmlVisibilityKind();
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
		result.append(" (umlVisibilityKind: "); //$NON-NLS-1$
		if (umlVisibilityKindESet) result.append(umlVisibilityKind); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //UMLElementCapabilityImpl
