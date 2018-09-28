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
import com.ibm.ccl.soa.deploy.ldap.LdapLdif;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdifAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ldif</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl#getAction <em>Action</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl#getSubtreeDn <em>Subtree Dn</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapLdifImpl extends CapabilityImpl implements LdapLdif {
	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final LdifAction ACTION_EDEFAULT = LdifAction.IMPORT_LITERAL;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected LdifAction action = ACTION_EDEFAULT;

	/**
	 * This is true if the Action attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean actionESet;

	/**
	 * The default value of the '{@link #getSubtreeDn() <em>Subtree Dn</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubtreeDn()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBTREE_DN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubtreeDn() <em>Subtree Dn</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubtreeDn()
	 * @generated
	 * @ordered
	 */
	protected String subtreeDn = SUBTREE_DN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapLdifImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_LDIF;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdifAction getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(LdifAction newAction) {
		LdifAction oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		boolean oldActionESet = actionESet;
		actionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_LDIF__ACTION, oldAction, action, !oldActionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAction() {
		LdifAction oldAction = action;
		boolean oldActionESet = actionESet;
		action = ACTION_EDEFAULT;
		actionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LdapPackage.LDAP_LDIF__ACTION, oldAction, ACTION_EDEFAULT, oldActionESet));
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
	public String getSubtreeDn() {
		return subtreeDn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubtreeDn(String newSubtreeDn) {
		String oldSubtreeDn = subtreeDn;
		subtreeDn = newSubtreeDn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.LDAP_LDIF__SUBTREE_DN, oldSubtreeDn, subtreeDn));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_LDIF__ACTION:
				return getAction();
			case LdapPackage.LDAP_LDIF__SUBTREE_DN:
				return getSubtreeDn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_LDIF__ACTION:
				setAction((LdifAction)newValue);
				return;
			case LdapPackage.LDAP_LDIF__SUBTREE_DN:
				setSubtreeDn((String)newValue);
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
			case LdapPackage.LDAP_LDIF__ACTION:
				unsetAction();
				return;
			case LdapPackage.LDAP_LDIF__SUBTREE_DN:
				setSubtreeDn(SUBTREE_DN_EDEFAULT);
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
			case LdapPackage.LDAP_LDIF__ACTION:
				return isSetAction();
			case LdapPackage.LDAP_LDIF__SUBTREE_DN:
				return SUBTREE_DN_EDEFAULT == null ? subtreeDn != null : !SUBTREE_DN_EDEFAULT.equals(subtreeDn);
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
		result.append(", subtreeDn: "); //$NON-NLS-1$
		result.append(subtreeDn);
		result.append(')');
		return result.toString();
	}

} //LdapLdifImpl
