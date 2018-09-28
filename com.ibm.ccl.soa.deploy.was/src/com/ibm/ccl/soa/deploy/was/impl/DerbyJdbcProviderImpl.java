/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderTypeType;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Derby Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.DerbyJdbcProviderImpl#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerbyJdbcProviderImpl extends ExtendedJdbcProviderImpl implements DerbyJdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getTemplate() <em>Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final DerbyJdbcProviderTypeType TEMPLATE_EDEFAULT = DerbyJdbcProviderTypeType.CLOUDSCAPE_JDBC_PROVIDER_LITERAL;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected DerbyJdbcProviderTypeType template = TEMPLATE_EDEFAULT;

	/**
	 * This is true if the Template attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean templateESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DerbyJdbcProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.DERBY_JDBC_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProviderTypeType getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(DerbyJdbcProviderTypeType newTemplate) {
		DerbyJdbcProviderTypeType oldTemplate = template;
		template = newTemplate == null ? TEMPLATE_EDEFAULT : newTemplate;
		boolean oldTemplateESet = templateESet;
		templateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE, oldTemplate, template, !oldTemplateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemplate() {
		DerbyJdbcProviderTypeType oldTemplate = template;
		boolean oldTemplateESet = templateESet;
		template = TEMPLATE_EDEFAULT;
		templateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE, oldTemplate, TEMPLATE_EDEFAULT, oldTemplateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemplate() {
		return templateESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE:
				return getTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE:
				setTemplate((DerbyJdbcProviderTypeType)newValue);
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
			case WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE:
				unsetTemplate();
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
			case WasPackage.DERBY_JDBC_PROVIDER__TEMPLATE:
				return isSetTemplate();
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
		result.append(" (template: "); //$NON-NLS-1$
		if (templateESet) result.append(template); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //DerbyJdbcProviderImpl
