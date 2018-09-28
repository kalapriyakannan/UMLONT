/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Schedular</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getDataBaseName <em>Data Base Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getServerName <em>Server Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getApplicationSchedular()
 * @model extendedMetaData="name='ApplicationSchedular' kind='elementOnly'"
 * @generated
 */
public interface ApplicationSchedular extends Capability {
	/**
	 * Returns the value of the '<em><b>Data Base Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Base Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Base Name</em>' attribute.
	 * @see #setDataBaseName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getApplicationSchedular_DataBaseName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DataBaseName'"
	 * @generated
	 */
	String getDataBaseName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getDataBaseName <em>Data Base Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Base Name</em>' attribute.
	 * @see #getDataBaseName()
	 * @generated
	 */
	void setDataBaseName(String value);

	/**
	 * Returns the value of the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Name</em>' attribute.
	 * @see #setServerName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getApplicationSchedular_ServerName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServerName'"
	 * @generated
	 */
	String getServerName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getServerName <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Name</em>' attribute.
	 * @see #getServerName()
	 * @generated
	 */
	void setServerName(String value);

} // ApplicationSchedular
