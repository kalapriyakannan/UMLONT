/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.impl.RequirementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Collocation Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl#getCapabilityType <em>Capability Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollocationConstraintImpl extends StructuralConstraintImpl implements
		CollocationConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCapabilityType() <em>Capability Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCapabilityType()
	 * @generated
	 * @ordered
	 */
	protected static final QName CAPABILITY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapabilityType() <em>Capability Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCapabilityType()
	 * @generated
	 * @ordered
	 */
	protected QName capabilityType = CAPABILITY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CollocationConstraintTypes TYPE_EDEFAULT = CollocationConstraintTypes.COLLOCATION_LITERAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CollocationConstraintTypes type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * Transient type of the capabilityType.
	 * 
	 * @generated NOT
	 */
	protected EClass capabilityEType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CollocationConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.COLLOCATION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QName getCapabilityType() {
		return capabilityType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityType(QName newCapabilityType) {
		QName oldCapabilityType = capabilityType;
		capabilityType = newCapabilityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE, oldCapabilityType, capabilityType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CollocationConstraintTypes getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CollocationConstraintTypes newType) {
		CollocationConstraintTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		CollocationConstraintTypes oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE:
				return getCapabilityType();
			case ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE:
				setCapabilityType((QName)newValue);
				return;
			case ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE:
				setType((CollocationConstraintTypes)newValue);
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
			case ConstraintPackage.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE:
				setCapabilityType(CAPABILITY_TYPE_EDEFAULT);
				return;
			case ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE:
				unsetType();
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
			case ConstraintPackage.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE:
				return CAPABILITY_TYPE_EDEFAULT == null ? capabilityType != null : !CAPABILITY_TYPE_EDEFAULT.equals(capabilityType);
			case ConstraintPackage.COLLOCATION_CONSTRAINT__TYPE:
				return isSetType();
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
		result.append(" (capabilityType: "); //$NON-NLS-1$
		result.append(capabilityType);
		result.append(", type: "); //$NON-NLS-1$
		if (typeESet) result.append(type); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns the {@link #getCapabilityType()} XMLNS {@link QualifiedName} converted to an EMF
	 * {@link EClass}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @return the EClass corresponding to the XMLNS {@link QualifiedName}; or null, if a problem
	 *         happens.
	 * 
	 * @generated NOT
	 */
	public EClass getCapabilityEType() {
		if (capabilityEType != null) {
			return capabilityEType;
		}

		if (capabilityType == null) {
			return null;
		}

		capabilityEType = deserializeCapabilityType(capabilityType);
		return capabilityEType;
	}

	/**
	 * Sets the value of the {@link #setCapabilityType(QName)} attribute by converting the
	 * {@link EClass} to an XMLNS {@link QualifiedName}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @param eType
	 *           the ECore type to be converted to an XMLNS {@link QualifiedName}.
	 * 
	 * Copied from {@link RequirementImpl}
	 * 
	 * @generated NOT
	 */
	public void setCapabilityEType(EClass eType) {
		Object oldCapabilityType = capabilityType;
		if (eType == null) {
			capabilityType = null;
			capabilityEType = null;
		} else {
			capabilityEType = eType;
			EPackage epkg = eType.getEPackage();
			capabilityType = (QName) XMLTypeUtil.createQName(epkg.getNsURI(),
					ExtendedMetaData.INSTANCE.getName(eType), epkg.getNsPrefix());
		}

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__DMO_TYPE,
					oldCapabilityType, capabilityType));
		}
	}

	/**
	 * Deserializes the capability type QName.
	 * 
	 * @param obj
	 *           a serialized capability type QName.
	 * @return the deserialized EClass.
	 * 
	 * Copied from {@link RequirementImpl}
	 * 
	 * @generated NOT
	 */
	protected EClass deserializeCapabilityType(Object obj) {

		if (obj == null) {
			return null;
		}
		QName qName = (QName) obj;
		if (qName.getNamespaceURI() != null && qName.getNamespaceURI().length() > 0) {
			String packageURI = qName.getNamespaceURI();
			if (packageURI == null) {
				return null;
				// throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0, qName.getNamespaceURI()));
			}
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(packageURI);
			if (pkg == null) {
				return null;
				// throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0, packageURI));
			}
			// TODO do we need to use the ExtendedMetadata here to get the generated
			// type name?
			return (EClass) pkg.getEClassifier(qName.getLocalPart());
		}
		return (EClass) CorePackage.eINSTANCE.getEClassifier(qName.getLocalPart());
	}

} //CollocationConstraintImpl
