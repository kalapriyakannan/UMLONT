/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLInteractionConstraintImpl.java,v 1.3 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Interaction Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl#getInteractionQName <em>Interaction QName</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLInteractionConstraintImpl extends ConstraintImpl implements UMLInteractionConstraint {
	/**
	 * The default value of the '{@link #getInteractionQName() <em>Interaction QName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionQName()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERACTION_QNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInteractionQName() <em>Interaction QName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionQName()
	 * @generated
	 * @ordered
	 */
	protected String interactionQName = INTERACTION_QNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceURI()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceURI()
	 * @generated
	 * @ordered
	 */
	protected String resourceURI = RESOURCE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLInteractionConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.Literals.UML_INTERACTION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInteractionQName() {
		return interactionQName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionQName(String newInteractionQName) {
		String oldInteractionQName = interactionQName;
		interactionQName = newInteractionQName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME, oldInteractionQName, interactionQName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceURI() {
		return resourceURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceURI(String newResourceURI) {
		String oldResourceURI = resourceURI;
		resourceURI = newResourceURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.UML_INTERACTION_CONSTRAINT__RESOURCE_URI, oldResourceURI, resourceURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlPackage.UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME:
				return getInteractionQName();
			case UmlPackage.UML_INTERACTION_CONSTRAINT__RESOURCE_URI:
				return getResourceURI();
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
			case UmlPackage.UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME:
				setInteractionQName((String)newValue);
				return;
			case UmlPackage.UML_INTERACTION_CONSTRAINT__RESOURCE_URI:
				setResourceURI((String)newValue);
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
			case UmlPackage.UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME:
				setInteractionQName(INTERACTION_QNAME_EDEFAULT);
				return;
			case UmlPackage.UML_INTERACTION_CONSTRAINT__RESOURCE_URI:
				setResourceURI(RESOURCE_URI_EDEFAULT);
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
			case UmlPackage.UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME:
				return INTERACTION_QNAME_EDEFAULT == null ? interactionQName != null : !INTERACTION_QNAME_EDEFAULT.equals(interactionQName);
			case UmlPackage.UML_INTERACTION_CONSTRAINT__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceURI != null : !RESOURCE_URI_EDEFAULT.equals(resourceURI);
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
		result.append(" (interactionQName: "); //$NON-NLS-1$
		result.append(interactionQName);
		result.append(", resourceURI: "); //$NON-NLS-1$
		result.append(resourceURI);
		result.append(')');
		return result.toString();
	}

} //UMLInteractionConstraintImpl
