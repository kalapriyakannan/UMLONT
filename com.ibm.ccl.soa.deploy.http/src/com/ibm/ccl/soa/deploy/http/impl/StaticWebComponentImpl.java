/**
 * <copyright>
 * </copyright>
 *
 * $Id: StaticWebComponentImpl.java,v 1.2 2008/02/05 22:18:08 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.http.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.StaticWebComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Web Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StaticWebComponentImpl extends BundleCapabilityImpl implements StaticWebComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticWebComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return HttpPackage.Literals.STATIC_WEB_COMPONENT;
	}

} //StaticWebComponentImpl
