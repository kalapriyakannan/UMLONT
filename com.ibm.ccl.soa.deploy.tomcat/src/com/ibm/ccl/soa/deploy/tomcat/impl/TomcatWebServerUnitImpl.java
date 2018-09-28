/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web Server Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TomcatWebServerUnitImpl extends J2EEServerUnitImpl implements TomcatWebServerUnit {
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
	protected TomcatWebServerUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TomcatPackage.Literals.TOMCAT_WEB_SERVER_UNIT;
	}

	public String getSpecializedTypeId() {
		if (specializedTypeId != null)
			return specializedTypeId;
		String version = null;
		Iterator it = getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof TomcatServer) {
				TomcatServer server = (TomcatServer) capability;
				version = server.getTomcatVersion();
				break;
			}
		}
		specializedTypeId = "com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit." + version; //$NON-NLS-1$
		return specializedTypeId;

	}
} //TomcatWebServerUnitImpl
