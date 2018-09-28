/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Websphere App Server Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WebsphereAppServerUnitImpl extends J2EEServerUnitImpl implements WebsphereAppServerUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * 
	 */
	private String specializedTypeId = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WebsphereAppServerUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	}

	public String getSpecializedTypeId() {
		if (specializedTypeId != null)
			return specializedTypeId;
		String wasVersion = null;
		Iterator it = getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasServer) {
				WasServer server = (WasServer) capability;
				wasVersion = server.getWasVersion();
				break;
			}
		}
		specializedTypeId = "com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit." + wasVersion; //$NON-NLS-1$
		return specializedTypeId;
	}
} //WebsphereAppServerUnitImpl
