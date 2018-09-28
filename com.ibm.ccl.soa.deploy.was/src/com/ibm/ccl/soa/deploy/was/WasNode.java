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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Node</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsDefaultProfile <em>Is Default Profile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsManaged <em>Is Managed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileLocation <em>Profile Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileType <em>Profile Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasNode#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode()
 * @model extendedMetaData="name='WasNode' kind='elementOnly'"
 * @generated
 */
public interface WasNode extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Is Default Profile</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Default Profile</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Default Profile</em>' attribute.
	 * @see #isSetIsDefaultProfile()
	 * @see #unsetIsDefaultProfile()
	 * @see #setIsDefaultProfile(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_IsDefaultProfile()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isDefaultProfile'"
	 * @generated
	 */
	boolean isIsDefaultProfile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsDefaultProfile <em>Is Default Profile</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default Profile</em>' attribute.
	 * @see #isSetIsDefaultProfile()
	 * @see #unsetIsDefaultProfile()
	 * @see #isIsDefaultProfile()
	 * @generated
	 */
	void setIsDefaultProfile(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsDefaultProfile <em>Is Default Profile</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIsDefaultProfile()
	 * @see #isIsDefaultProfile()
	 * @see #setIsDefaultProfile(boolean)
	 * @generated
	 */
	void unsetIsDefaultProfile();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsDefaultProfile <em>Is Default Profile</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Default Profile</em>' attribute is set.
	 * @see #unsetIsDefaultProfile()
	 * @see #isIsDefaultProfile()
	 * @see #setIsDefaultProfile(boolean)
	 * @generated
	 */
	boolean isSetIsDefaultProfile();

	/**
	 * Returns the value of the '<em><b>Is Managed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Managed</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Managed</em>' attribute.
	 * @see #isSetIsManaged()
	 * @see #unsetIsManaged()
	 * @see #setIsManaged(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_IsManaged()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isManaged'"
	 * @generated
	 */
	boolean isIsManaged();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsManaged <em>Is Managed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Managed</em>' attribute.
	 * @see #isSetIsManaged()
	 * @see #unsetIsManaged()
	 * @see #isIsManaged()
	 * @generated
	 */
	void setIsManaged(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsManaged <em>Is Managed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetIsManaged()
	 * @see #isIsManaged()
	 * @see #setIsManaged(boolean)
	 * @generated
	 */
	void unsetIsManaged();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#isIsManaged <em>Is Managed</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Managed</em>' attribute is set.
	 * @see #unsetIsManaged()
	 * @see #isIsManaged()
	 * @see #setIsManaged(boolean)
	 * @generated
	 */
	boolean isSetIsManaged();

	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_NodeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='nodeName'"
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * Returns the value of the '<em><b>Profile Location</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Location</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Profile Location</em>' attribute.
	 * @see #setProfileLocation(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_ProfileLocation()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='profileLocation'"
	 * @generated
	 */
	String getProfileLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileLocation <em>Profile Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Location</em>' attribute.
	 * @see #getProfileLocation()
	 * @generated
	 */
	void setProfileLocation(String value);

	/**
	 * Returns the value of the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Profile Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Name</em>' attribute.
	 * @see #setProfileName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_ProfileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='profileName'"
	 * @generated
	 */
	String getProfileName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileName <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Name</em>' attribute.
	 * @see #getProfileName()
	 * @generated
	 */
	void setProfileName(String value);

	/**
	 * Returns the value of the '<em><b>Profile Type</b></em>' attribute.
	 * The default value is <code>"dmgr"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum
	 * @see #isSetProfileType()
	 * @see #unsetProfileType()
	 * @see #setProfileType(WasProfileTypeEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_ProfileType()
	 * @model default="dmgr" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='profileType'"
	 * @generated
	 */
	WasProfileTypeEnum getProfileType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileType <em>Profile Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum
	 * @see #isSetProfileType()
	 * @see #unsetProfileType()
	 * @see #getProfileType()
	 * @generated
	 */
	void setProfileType(WasProfileTypeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileType <em>Profile Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetProfileType()
	 * @see #getProfileType()
	 * @see #setProfileType(WasProfileTypeEnum)
	 * @generated
	 */
	void unsetProfileType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getProfileType <em>Profile Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Profile Type</em>' attribute is set.
	 * @see #unsetProfileType()
	 * @see #getProfileType()
	 * @see #setProfileType(WasProfileTypeEnum)
	 * @generated
	 */
	boolean isSetProfileType();

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasNode_WasVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasVersion'"
	 * @generated
	 */
	String getWasVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasNode#getWasVersion <em>Was Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Version</em>' attribute.
	 * @see #getWasVersion()
	 * @generated
	 */
	void setWasVersion(String value);

} // WasNode
