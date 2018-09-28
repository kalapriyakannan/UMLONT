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
 * A representation of the model object '<em><b>Base System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getProfileDir <em>Profile Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWpsBaseSystem()
 * @model extendedMetaData="name='WpsBaseSystem' kind='elementOnly'"
 * @generated
 */
public interface WpsBaseSystem extends Capability {
	/**
	 * Returns the value of the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Location</em>' attribute.
	 * @see #setInstallLocation(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWpsBaseSystem_InstallLocation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installLocation'"
	 * @generated
	 */
	String getInstallLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getInstallLocation <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Location</em>' attribute.
	 * @see #getInstallLocation()
	 * @generated
	 */
	void setInstallLocation(String value);

	/**
	 * Returns the value of the '<em><b>Profile Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Dir</em>' attribute.
	 * @see #setProfileDir(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWpsBaseSystem_ProfileDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProfileDir'"
	 * @generated
	 */
	String getProfileDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getProfileDir <em>Profile Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Dir</em>' attribute.
	 * @see #getProfileDir()
	 * @generated
	 */
	void setProfileDir(String value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWpsBaseSystem_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // WpsBaseSystem
