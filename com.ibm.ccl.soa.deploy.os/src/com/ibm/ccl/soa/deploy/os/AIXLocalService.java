/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>AIX Local Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getActionType <em>Action Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getExecutablePath <em>Executable Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight <em>Startup Run Level Eight</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine <em>Startup Run Level Nine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService()
 * @model extendedMetaData="name='AIXLocalService' kind='elementOnly'"
 * @generated
 */
public interface AIXLocalService extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see #setActionType(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_ActionType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ActionType'"
	 * @generated
	 */
	String getActionType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(String value);

	/**
	 * Returns the value of the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Executable Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable Path</em>' attribute.
	 * @see #setExecutablePath(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_ExecutablePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExecutablePath'"
	 * @generated
	 */
	String getExecutablePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getExecutablePath <em>Executable Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable Path</em>' attribute.
	 * @see #getExecutablePath()
	 * @generated
	 */
	void setExecutablePath(String value);

	/**
	 * Returns the value of the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Description</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Description</em>' attribute.
	 * @see #setServiceDescription(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_ServiceDescription()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ServiceDescription'"
	 * @generated
	 */
	String getServiceDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getServiceDescription <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Description</em>' attribute.
	 * @see #getServiceDescription()
	 * @generated
	 */
	void setServiceDescription(String value);

	/**
	 * Returns the value of the '<em><b>Startup Run Level Eight</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Eight</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Eight</em>' attribute.
	 * @see #isSetStartupRunLevelEight()
	 * @see #unsetStartupRunLevelEight()
	 * @see #setStartupRunLevelEight(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelEight()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelEight'"
	 * @generated
	 */
	boolean isStartupRunLevelEight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight <em>Startup Run Level Eight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Eight</em>' attribute.
	 * @see #isSetStartupRunLevelEight()
	 * @see #unsetStartupRunLevelEight()
	 * @see #isStartupRunLevelEight()
	 * @generated
	 */
	void setStartupRunLevelEight(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight <em>Startup Run Level Eight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelEight()
	 * @see #isStartupRunLevelEight()
	 * @see #setStartupRunLevelEight(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelEight();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight <em>Startup Run Level Eight</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Eight</em>' attribute is set.
	 * @see #unsetStartupRunLevelEight()
	 * @see #isStartupRunLevelEight()
	 * @see #setStartupRunLevelEight(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelEight();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Five</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Five</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Five</em>' attribute.
	 * @see #isSetStartupRunLevelFive()
	 * @see #unsetStartupRunLevelFive()
	 * @see #setStartupRunLevelFive(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelFive()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelFive'"
	 * @generated
	 */
	boolean isStartupRunLevelFive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Five</em>' attribute.
	 * @see #isSetStartupRunLevelFive()
	 * @see #unsetStartupRunLevelFive()
	 * @see #isStartupRunLevelFive()
	 * @generated
	 */
	void setStartupRunLevelFive(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelFive()
	 * @see #isStartupRunLevelFive()
	 * @see #setStartupRunLevelFive(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelFive();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Five</em>' attribute is set.
	 * @see #unsetStartupRunLevelFive()
	 * @see #isStartupRunLevelFive()
	 * @see #setStartupRunLevelFive(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelFive();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Four</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Four</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Four</em>' attribute.
	 * @see #isSetStartupRunLevelFour()
	 * @see #unsetStartupRunLevelFour()
	 * @see #setStartupRunLevelFour(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelFour()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelFour'"
	 * @generated
	 */
	boolean isStartupRunLevelFour();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Four</em>' attribute.
	 * @see #isSetStartupRunLevelFour()
	 * @see #unsetStartupRunLevelFour()
	 * @see #isStartupRunLevelFour()
	 * @generated
	 */
	void setStartupRunLevelFour(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelFour()
	 * @see #isStartupRunLevelFour()
	 * @see #setStartupRunLevelFour(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelFour();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Four</em>' attribute is set.
	 * @see #unsetStartupRunLevelFour()
	 * @see #isStartupRunLevelFour()
	 * @see #setStartupRunLevelFour(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelFour();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Nine</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Nine</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Nine</em>' attribute.
	 * @see #isSetStartupRunLevelNine()
	 * @see #unsetStartupRunLevelNine()
	 * @see #setStartupRunLevelNine(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelNine()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelNine'"
	 * @generated
	 */
	boolean isStartupRunLevelNine();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine <em>Startup Run Level Nine</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Nine</em>' attribute.
	 * @see #isSetStartupRunLevelNine()
	 * @see #unsetStartupRunLevelNine()
	 * @see #isStartupRunLevelNine()
	 * @generated
	 */
	void setStartupRunLevelNine(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine <em>Startup Run Level Nine</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelNine()
	 * @see #isStartupRunLevelNine()
	 * @see #setStartupRunLevelNine(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelNine();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine <em>Startup Run Level Nine</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Nine</em>' attribute is set.
	 * @see #unsetStartupRunLevelNine()
	 * @see #isStartupRunLevelNine()
	 * @see #setStartupRunLevelNine(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelNine();

	/**
	 * Returns the value of the '<em><b>Startup Run Level One</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level One</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level One</em>' attribute.
	 * @see #isSetStartupRunLevelOne()
	 * @see #unsetStartupRunLevelOne()
	 * @see #setStartupRunLevelOne(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelOne()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelOne'"
	 * @generated
	 */
	boolean isStartupRunLevelOne();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level One</em>' attribute.
	 * @see #isSetStartupRunLevelOne()
	 * @see #unsetStartupRunLevelOne()
	 * @see #isStartupRunLevelOne()
	 * @generated
	 */
	void setStartupRunLevelOne(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelOne()
	 * @see #isStartupRunLevelOne()
	 * @see #setStartupRunLevelOne(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelOne();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level One</em>' attribute is set.
	 * @see #unsetStartupRunLevelOne()
	 * @see #isStartupRunLevelOne()
	 * @see #setStartupRunLevelOne(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelOne();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Seven</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Seven</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Seven</em>' attribute.
	 * @see #isSetStartupRunLevelSeven()
	 * @see #unsetStartupRunLevelSeven()
	 * @see #setStartupRunLevelSeven(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelSeven()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelSeven'"
	 * @generated
	 */
	boolean isStartupRunLevelSeven();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Seven</em>' attribute.
	 * @see #isSetStartupRunLevelSeven()
	 * @see #unsetStartupRunLevelSeven()
	 * @see #isStartupRunLevelSeven()
	 * @generated
	 */
	void setStartupRunLevelSeven(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelSeven()
	 * @see #isStartupRunLevelSeven()
	 * @see #setStartupRunLevelSeven(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelSeven();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Seven</em>' attribute is set.
	 * @see #unsetStartupRunLevelSeven()
	 * @see #isStartupRunLevelSeven()
	 * @see #setStartupRunLevelSeven(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelSeven();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Six</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Six</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Six</em>' attribute.
	 * @see #isSetStartupRunLevelSix()
	 * @see #unsetStartupRunLevelSix()
	 * @see #setStartupRunLevelSix(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelSix()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelSix'"
	 * @generated
	 */
	boolean isStartupRunLevelSix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Six</em>' attribute.
	 * @see #isSetStartupRunLevelSix()
	 * @see #unsetStartupRunLevelSix()
	 * @see #isStartupRunLevelSix()
	 * @generated
	 */
	void setStartupRunLevelSix(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelSix()
	 * @see #isStartupRunLevelSix()
	 * @see #setStartupRunLevelSix(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelSix();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Six</em>' attribute is set.
	 * @see #unsetStartupRunLevelSix()
	 * @see #isStartupRunLevelSix()
	 * @see #setStartupRunLevelSix(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelSix();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Three</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Three</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Three</em>' attribute.
	 * @see #isSetStartupRunLevelThree()
	 * @see #unsetStartupRunLevelThree()
	 * @see #setStartupRunLevelThree(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelThree()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelThree'"
	 * @generated
	 */
	boolean isStartupRunLevelThree();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Three</em>' attribute.
	 * @see #isSetStartupRunLevelThree()
	 * @see #unsetStartupRunLevelThree()
	 * @see #isStartupRunLevelThree()
	 * @generated
	 */
	void setStartupRunLevelThree(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelThree()
	 * @see #isStartupRunLevelThree()
	 * @see #setStartupRunLevelThree(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelThree();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Three</em>' attribute is set.
	 * @see #unsetStartupRunLevelThree()
	 * @see #isStartupRunLevelThree()
	 * @see #setStartupRunLevelThree(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelThree();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Two</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Two</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Two</em>' attribute.
	 * @see #isSetStartupRunLevelTwo()
	 * @see #unsetStartupRunLevelTwo()
	 * @see #setStartupRunLevelTwo(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelTwo()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelTwo'"
	 * @generated
	 */
	boolean isStartupRunLevelTwo();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Two</em>' attribute.
	 * @see #isSetStartupRunLevelTwo()
	 * @see #unsetStartupRunLevelTwo()
	 * @see #isStartupRunLevelTwo()
	 * @generated
	 */
	void setStartupRunLevelTwo(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelTwo()
	 * @see #isStartupRunLevelTwo()
	 * @see #setStartupRunLevelTwo(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelTwo();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Two</em>' attribute is set.
	 * @see #unsetStartupRunLevelTwo()
	 * @see #isStartupRunLevelTwo()
	 * @see #setStartupRunLevelTwo(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelTwo();

	/**
	 * Returns the value of the '<em><b>Startup Run Level Zero</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startup Run Level Zero</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Startup Run Level Zero</em>' attribute.
	 * @see #isSetStartupRunLevelZero()
	 * @see #unsetStartupRunLevelZero()
	 * @see #setStartupRunLevelZero(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXLocalService_StartupRunLevelZero()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='StartupRunLevelZero'"
	 * @generated
	 */
	boolean isStartupRunLevelZero();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startup Run Level Zero</em>' attribute.
	 * @see #isSetStartupRunLevelZero()
	 * @see #unsetStartupRunLevelZero()
	 * @see #isStartupRunLevelZero()
	 * @generated
	 */
	void setStartupRunLevelZero(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartupRunLevelZero()
	 * @see #isStartupRunLevelZero()
	 * @see #setStartupRunLevelZero(boolean)
	 * @generated
	 */
	void unsetStartupRunLevelZero();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Startup Run Level Zero</em>' attribute is set.
	 * @see #unsetStartupRunLevelZero()
	 * @see #isStartupRunLevelZero()
	 * @see #setStartupRunLevelZero(boolean)
	 * @generated
	 */
	boolean isSetStartupRunLevelZero();

} // AIXLocalService
