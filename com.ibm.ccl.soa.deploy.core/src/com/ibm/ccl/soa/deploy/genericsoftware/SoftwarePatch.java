/**
 * <copyright>
 * </copyright>
 *
 * $Id: SoftwarePatch.java,v 1.1 2008/02/04 15:55:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Patch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				SoftwarePatchUnit is a configuration unit hosted on whatever it patches
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch#getPatchID <em>Patch ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwarePatch()
 * @model extendedMetaData="name='SoftwarePatch' kind='elementOnly'"
 * @generated
 */
public interface SoftwarePatch extends Capability {
	/**
	 * Returns the value of the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Date and time patch was or will be installed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Date</em>' attribute.
	 * @see #setInstallDate(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwarePatch_InstallDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installDate'"
	 * @generated
	 */
	String getInstallDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch#getInstallDate <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Date</em>' attribute.
	 * @see #getInstallDate()
	 * @generated
	 */
	void setInstallDate(String value);

	/**
	 * Returns the value of the '<em><b>Patch ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ID or name of the patch. E.g. "KB931768"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Patch ID</em>' attribute.
	 * @see #setPatchID(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwarePatch_PatchID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='patchID'"
	 * @generated
	 */
	String getPatchID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch#getPatchID <em>Patch ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Patch ID</em>' attribute.
	 * @see #getPatchID()
	 * @generated
	 */
	void setPatchID(String value);

} // SoftwarePatch
