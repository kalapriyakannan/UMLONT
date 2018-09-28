/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: ProductIdentifierConstraintImpl.java,v 1.6 2008/06/27 13:57:44 blancett Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Product Identifier Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ProductIdentifierConstraintImpl#getProductIdentifier <em>Product Identifier</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProductIdentifierConstraintImpl extends ConstraintImpl implements
		ProductIdentifierConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getProductIdentifier() <em>Product Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductIdentifier() <em>Product Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProductIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String productIdentifier = PRODUCT_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProductIdentifierConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.PRODUCT_IDENTIFIER_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProductIdentifier() {
		return productIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProductIdentifier(String newProductIdentifier) {
		String oldProductIdentifier = productIdentifier;
		productIdentifier = newProductIdentifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER,
					oldProductIdentifier, productIdentifier));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER:
			return getProductIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER:
			setProductIdentifier((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER:
			setProductIdentifier(PRODUCT_IDENTIFIER_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER:
			return PRODUCT_IDENTIFIER_EDEFAULT == null ? productIdentifier != null
					: !PRODUCT_IDENTIFIER_EDEFAULT.equals(productIdentifier);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (productIdentifier: "); //$NON-NLS-1$
		result.append(productIdentifier);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		if (o instanceof ProductIdentifierConstraint) {
			ProductIdentifierConstraint targetPIConstraint = (ProductIdentifierConstraint) o;
			if (targetPIConstraint.getProductIdentifier() == null) {
				return false;
			}
			return getProductIdentifier().equals(targetPIConstraint.getProductIdentifier());
		}
		// TODO Auto-generated method stub
		return super.equals(o);
	}

	public int hashCode() {
		int hash = 7;
		hash = 31 * hash;
		hash = 31 * hash + (null == getProductIdentifier() ? 0 : getProductIdentifier().hashCode());
		return hash;
	}
} //ProductIdentifierConstraintImpl
