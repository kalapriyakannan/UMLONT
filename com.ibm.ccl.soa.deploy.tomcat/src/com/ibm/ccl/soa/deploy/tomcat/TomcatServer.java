/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat;

import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.TomcatServer#getTomcatVersion <em>Tomcat Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatServer()
 * @model extendedMetaData="name='TomcatServer' kind='elementOnly'"
 * @generated
 */
public interface TomcatServer extends J2EEServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Tomcat Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Tomcat Version</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tomcat Version</em>' attribute.
	 * @see #setTomcatVersion(String)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcatServer_TomcatVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='tomcatVersion'"
	 * @generated
	 */
	String getTomcatVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatServer#getTomcatVersion <em>Tomcat Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tomcat Version</em>' attribute.
	 * @see #getTomcatVersion()
	 * @generated
	 */
	void setTomcatVersion(String value);

} // TomcatServer
