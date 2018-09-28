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
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.TypeConstraintImpl#getDmoType <em>Dmo Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeConstraintImpl extends ConstraintImpl implements TypeConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDmoType() <em>Dmo Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoType()
	 * @generated
	 * @ordered
	 */
	protected static final QName DMO_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDmoType() <em>Dmo Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoType()
	 * @generated
	 * @ordered
	 */
	protected QName dmoType = DMO_TYPE_EDEFAULT;

	/**
	 * Transient type of the dmoType.
	 * 
	 * @generated NOT
	 */
	protected EClass dmoEType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.TYPE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QName getDmoType() {
		return dmoType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDmoType(QName newDmoType) {
		QName oldDmoType = dmoType;
		dmoType = newDmoType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.TYPE_CONSTRAINT__DMO_TYPE, oldDmoType, dmoType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.TYPE_CONSTRAINT__DMO_TYPE:
				return getDmoType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.TYPE_CONSTRAINT__DMO_TYPE:
				setDmoType((QName)newValue);
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
			case ConstraintPackage.TYPE_CONSTRAINT__DMO_TYPE:
				setDmoType(DMO_TYPE_EDEFAULT);
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
			case ConstraintPackage.TYPE_CONSTRAINT__DMO_TYPE:
				return DMO_TYPE_EDEFAULT == null ? dmoType != null : !DMO_TYPE_EDEFAULT.equals(dmoType);
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
		result.append(" (dmoType: "); //$NON-NLS-1$
		result.append(dmoType);
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns the {@link #getDmoType()} XMLNS {@link QualifiedName} converted to an EMF
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
	public EClass getDmoEType() {
		if (dmoEType != null) {
			return dmoEType;
		}

		if (dmoType == null) {
			return null;
		}

		dmoEType = deserializeCapabilityType(dmoType);
		return dmoEType;
	}

	/**
	 * Sets the value of the {@link #setDmoType(QName)} attribute by converting the {@link EClass} to
	 * an XMLNS {@link QualifiedName}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @param type
	 *           the ECore type to be converted to an XMLNS {@link QualifiedName}.
	 * 
	 * @generated NOT
	 */
	public void setDmoEType(EClass type) {
		Object oldDmoType = dmoType;
		if (type == null) {
			dmoType = null;
			dmoEType = null;
		} else {
			dmoEType = type;
			EPackage epkg = type.getEPackage();
			dmoType = (QName) XMLTypeUtil.createQName(epkg.getNsURI(), ExtendedMetaData.INSTANCE
					.getName(type), epkg.getNsPrefix());
		}

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__DMO_TYPE,
					oldDmoType, dmoType));
		}
	}

	/**
	 * Deserializes the capability type QName.
	 * 
	 * @param obj
	 *           a serialized capability type QName.
	 * @return the deserialized EClass.
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

} //TypeConstraintImpl
