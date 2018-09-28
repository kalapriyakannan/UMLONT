/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getVersion <em>Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getWonderful <em>Wonderful</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage#getTdsBaseSystem()
 * @model extendedMetaData="name='TdsBaseSystem' kind='elementOnly'"
 * @generated
 */
public interface TdsBaseSystem extends Capability {
	/**
	 * Returns the value of the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Location</em>' attribute.
	 * @see #setInstallLocation(String)
	 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage#getTdsBaseSystem_InstallLocation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installLocation'"
	 * @generated
	 */
	String getInstallLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getInstallLocation <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Location</em>' attribute.
	 * @see #getInstallLocation()
	 * @generated
	 */
	void setInstallLocation(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage#getTdsBaseSystem_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Wonderful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wonderful</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wonderful</em>' attribute.
	 * @see #setWonderful(String)
	 * @see com.ibm.ccl.soa.deploy.tds.TdsPackage#getTdsBaseSystem_Wonderful()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='wonderful'"
	 * @generated
	 */
	String getWonderful();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tds.TdsBaseSystem#getWonderful <em>Wonderful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wonderful</em>' attribute.
	 * @see #getWonderful()
	 * @generated
	 */
	void setWonderful(String value);

} // TdsBaseSystem
