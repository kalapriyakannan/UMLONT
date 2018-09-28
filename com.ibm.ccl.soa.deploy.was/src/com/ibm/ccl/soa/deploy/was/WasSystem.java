/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>System</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSystem#getInstallerDir <em>Installer Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasEdition <em>Was Edition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasHome <em>Was Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSystem()
 * @model extendedMetaData="name='WasSystem' kind='elementOnly'"
 * @generated
 */
public interface WasSystem extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Installer Dir</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Installer Dir</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installer Dir</em>' attribute.
	 * @see #setInstallerDir(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSystem_InstallerDir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installerDir'"
	 * @generated
	 */
	String getInstallerDir();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getInstallerDir <em>Installer Dir</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installer Dir</em>' attribute.
	 * @see #getInstallerDir()
	 * @generated
	 */
	void setInstallerDir(String value);

	/**
	 * Returns the value of the '<em><b>Was Edition</b></em>' attribute.
	 * The default value is <code>"Base"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasEditionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Edition</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Edition</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasEditionEnum
	 * @see #isSetWasEdition()
	 * @see #unsetWasEdition()
	 * @see #setWasEdition(WasEditionEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSystem_WasEdition()
	 * @model default="Base" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='wasEdition'"
	 * @generated
	 */
	WasEditionEnum getWasEdition();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasEdition <em>Was Edition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Edition</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasEditionEnum
	 * @see #isSetWasEdition()
	 * @see #unsetWasEdition()
	 * @see #getWasEdition()
	 * @generated
	 */
	void setWasEdition(WasEditionEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasEdition <em>Was Edition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetWasEdition()
	 * @see #getWasEdition()
	 * @see #setWasEdition(WasEditionEnum)
	 * @generated
	 */
	void unsetWasEdition();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasEdition <em>Was Edition</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Was Edition</em>' attribute is set.
	 * @see #unsetWasEdition()
	 * @see #getWasEdition()
	 * @see #setWasEdition(WasEditionEnum)
	 * @generated
	 */
	boolean isSetWasEdition();

	/**
	 * Returns the value of the '<em><b>Was Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Home</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Home</em>' attribute.
	 * @see #setWasHome(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSystem_WasHome()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='wasHome'"
	 * @generated
	 */
	String getWasHome();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasHome <em>Was Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Home</em>' attribute.
	 * @see #getWasHome()
	 * @generated
	 */
	void setWasHome(String value);

	/**
	 * Returns the value of the '<em><b>Was Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Version</em>' attribute.
	 * @see #setWasVersion(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSystem_WasVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasVersion'"
	 * @generated
	 */
	String getWasVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSystem#getWasVersion <em>Was Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Version</em>' attribute.
	 * @see #getWasVersion()
	 * @generated
	 */
	void setWasVersion(String value);

} // WasSystem
