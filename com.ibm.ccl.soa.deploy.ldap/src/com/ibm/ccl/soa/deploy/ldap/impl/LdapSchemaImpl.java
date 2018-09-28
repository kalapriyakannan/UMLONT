/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSchema;
import com.ibm.ccl.soa.deploy.ldap.SchemaAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Schema</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapSchemaImpl extends CapabilityImpl implements LdapSchema {
	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final SchemaAction ACTION_EDEFAULT = SchemaAction.ADD_LITERAL;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected SchemaAction action = ACTION_EDEFAULT;

	/**
	 * This is true if the Action attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean actionESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapSchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaAction getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(SchemaAction newAction) {
		SchemaAction oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		boolean oldActionESet = actionESet;
		actionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_SCHEMA__ACTION, oldAction, action, !oldActionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAction() {
		SchemaAction oldAction = action;
		boolean oldActionESet = actionESet;
		action = ACTION_EDEFAULT;
		actionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LdapPackage.LDAP_SCHEMA__ACTION, oldAction, ACTION_EDEFAULT, oldActionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAction() {
		return actionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_SCHEMA__ACTION:
				return getAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_SCHEMA__ACTION:
				setAction((SchemaAction)newValue);
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
			case LdapPackage.LDAP_SCHEMA__ACTION:
				unsetAction();
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
			case LdapPackage.LDAP_SCHEMA__ACTION:
				return isSetAction();
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
		result.append(" (action: "); //$NON-NLS-1$
		if (actionESet) result.append(action); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //LdapSchemaImpl
