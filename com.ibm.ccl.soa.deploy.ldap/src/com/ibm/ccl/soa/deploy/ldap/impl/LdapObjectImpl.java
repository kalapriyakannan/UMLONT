/**
 * <copyright>
 * </copyright>
 *
 * $Id: LdapObjectImpl.java,v 1.1 2008/06/17 19:59:18 pershng Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;

import com.ibm.ccl.soa.deploy.ldap.LdapObject;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDAP Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class LdapObjectImpl extends CapabilityImpl implements LdapObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_OBJECT;
	}

} //LdapObjectImpl
