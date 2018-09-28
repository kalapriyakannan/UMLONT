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
 * A representation of the model object '<em><b>SDO Runtime</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.SDORuntime#getInstallationPath <em>Installation Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getSDORuntime()
 * @model extendedMetaData="name='SDORuntime' kind='elementOnly'"
 * @generated
 */
public interface SDORuntime extends Capability {
	/**
	 * Returns the value of the '<em><b>Installation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installation Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installation Path</em>' attribute.
	 * @see #setInstallationPath(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getSDORuntime_InstallationPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstallationPath'"
	 * @generated
	 */
	String getInstallationPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.SDORuntime#getInstallationPath <em>Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installation Path</em>' attribute.
	 * @see #getInstallationPath()
	 * @generated
	 */
	void setInstallationPath(String value);

} // SDORuntime
