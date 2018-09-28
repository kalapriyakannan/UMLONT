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

import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.DB2JdbcProviderImpl#getJdbcType <em>Jdbc Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.DB2JdbcProviderImpl#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2JdbcProviderImpl extends ExtendedJdbcProviderImpl implements DB2JdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected static final JdbcTypeType JDBC_TYPE_EDEFAULT = JdbcTypeType._1_LITERAL;

	/**
	 * The cached value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected JdbcTypeType jdbcType = JDBC_TYPE_EDEFAULT;

	/**
	 * This is true if the Jdbc Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jdbcTypeESet;

	/**
	 * The default value of the '{@link #getTemplate() <em>Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final DB2JdbcProviderType TEMPLATE_EDEFAULT = DB2JdbcProviderType.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected DB2JdbcProviderType template = TEMPLATE_EDEFAULT;

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
	protected DB2JdbcProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.DB2_JDBC_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcTypeType getJdbcType() {
		return jdbcType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJdbcType(JdbcTypeType newJdbcType) {
		JdbcTypeType oldJdbcType = jdbcType;
		jdbcType = newJdbcType == null ? JDBC_TYPE_EDEFAULT : newJdbcType;
		boolean oldJdbcTypeESet = jdbcTypeESet;
		jdbcTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE, oldJdbcType, jdbcType, !oldJdbcTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJdbcType() {
		JdbcTypeType oldJdbcType = jdbcType;
		boolean oldJdbcTypeESet = jdbcTypeESet;
		jdbcType = JDBC_TYPE_EDEFAULT;
		jdbcTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE, oldJdbcType, JDBC_TYPE_EDEFAULT, oldJdbcTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJdbcType() {
		return jdbcTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProviderType getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(DB2JdbcProviderType newTemplate) {
		DB2JdbcProviderType oldTemplate = template;
		template = newTemplate == null ? TEMPLATE_EDEFAULT : newTemplate;
		boolean oldTemplateESet = templateESet;
		templateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.DB2_JDBC_PROVIDER__TEMPLATE, oldTemplate, template, !oldTemplateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemplate() {
		DB2JdbcProviderType oldTemplate = template;
		boolean oldTemplateESet = templateESet;
		template = TEMPLATE_EDEFAULT;
		templateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.DB2_JDBC_PROVIDER__TEMPLATE, oldTemplate, TEMPLATE_EDEFAULT, oldTemplateESet));
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
			case WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE:
				return getJdbcType();
			case WasPackage.DB2_JDBC_PROVIDER__TEMPLATE:
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
			case WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE:
				setJdbcType((JdbcTypeType)newValue);
				return;
			case WasPackage.DB2_JDBC_PROVIDER__TEMPLATE:
				setTemplate((DB2JdbcProviderType)newValue);
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
			case WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE:
				unsetJdbcType();
				return;
			case WasPackage.DB2_JDBC_PROVIDER__TEMPLATE:
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
			case WasPackage.DB2_JDBC_PROVIDER__JDBC_TYPE:
				return isSetJdbcType();
			case WasPackage.DB2_JDBC_PROVIDER__TEMPLATE:
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
		result.append(" (jdbcType: "); //$NON-NLS-1$
		if (jdbcTypeESet) result.append(jdbcType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", template: "); //$NON-NLS-1$
		if (templateESet) result.append(template); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //DB2JdbcProviderImpl
