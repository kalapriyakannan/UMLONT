/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IHS Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsModule <em>Capability Ihs Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsServer <em>Capability Ihs Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsSystem <em>Capability Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUser <em>Capability Ihs User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUserRepository <em>Capability Ihs User Repository</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasAdminModule <em>Capability Ihs Was Admin Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasModule <em>Capability Ihs Was Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityLinuxIhsSystem <em>Capability Linux Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityWindowsIhsSystem <em>Capability Windows Ihs System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsServerUnit <em>Unit Ihs Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsSystemUnit <em>Unit Ihs System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsUserUnit <em>Unit Ihs User Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasAdminModuleUnit <em>Unit Ihs Was Admin Module Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasModuleUnit <em>Unit Ihs Was Module Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface IHSDeployRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Ihs Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs Module</em>' containment reference.
	 * @see #setCapabilityIhsModule(IhsModule)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsModule getCapabilityIhsModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsModule <em>Capability Ihs Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs Module</em>' containment reference.
	 * @see #getCapabilityIhsModule()
	 * @generated
	 */
	void setCapabilityIhsModule(IhsModule value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs Server</em>' containment reference.
	 * @see #setCapabilityIhsServer(IhsServer)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsServer getCapabilityIhsServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsServer <em>Capability Ihs Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs Server</em>' containment reference.
	 * @see #getCapabilityIhsServer()
	 * @generated
	 */
	void setCapabilityIhsServer(IhsServer value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs System</em>' containment reference.
	 * @see #setCapabilityIhsSystem(IhsSystem)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsSystem getCapabilityIhsSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsSystem <em>Capability Ihs System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs System</em>' containment reference.
	 * @see #getCapabilityIhsSystem()
	 * @generated
	 */
	void setCapabilityIhsSystem(IhsSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs User</em>' containment reference.
	 * @see #setCapabilityIhsUser(IhsUser)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsUser getCapabilityIhsUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUser <em>Capability Ihs User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs User</em>' containment reference.
	 * @see #getCapabilityIhsUser()
	 * @generated
	 */
	void setCapabilityIhsUser(IhsUser value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs User Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs User Repository</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs User Repository</em>' containment reference.
	 * @see #setCapabilityIhsUserRepository(IhsUserRepository)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsUserRepository()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsUserRepository' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsUserRepository getCapabilityIhsUserRepository();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUserRepository <em>Capability Ihs User Repository</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs User Repository</em>' containment reference.
	 * @see #getCapabilityIhsUserRepository()
	 * @generated
	 */
	void setCapabilityIhsUserRepository(IhsUserRepository value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs Was Admin Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs Was Admin Module</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs Was Admin Module</em>' containment reference.
	 * @see #setCapabilityIhsWasAdminModule(IhsWasAdminModule)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsWasAdminModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsWasAdminModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsWasAdminModule getCapabilityIhsWasAdminModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasAdminModule <em>Capability Ihs Was Admin Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs Was Admin Module</em>' containment reference.
	 * @see #getCapabilityIhsWasAdminModule()
	 * @generated
	 */
	void setCapabilityIhsWasAdminModule(IhsWasAdminModule value);

	/**
	 * Returns the value of the '<em><b>Capability Ihs Was Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ihs Was Module</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ihs Was Module</em>' containment reference.
	 * @see #setCapabilityIhsWasModule(IhsWasModule)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityIhsWasModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ihsWasModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IhsWasModule getCapabilityIhsWasModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasModule <em>Capability Ihs Was Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ihs Was Module</em>' containment reference.
	 * @see #getCapabilityIhsWasModule()
	 * @generated
	 */
	void setCapabilityIhsWasModule(IhsWasModule value);

	/**
	 * Returns the value of the '<em><b>Capability Linux Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Linux Ihs System</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Linux Ihs System</em>' containment reference.
	 * @see #setCapabilityLinuxIhsSystem(LinuxIhsSystem)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityLinuxIhsSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.linuxIhsSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LinuxIhsSystem getCapabilityLinuxIhsSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityLinuxIhsSystem <em>Capability Linux Ihs System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Linux Ihs System</em>' containment reference.
	 * @see #getCapabilityLinuxIhsSystem()
	 * @generated
	 */
	void setCapabilityLinuxIhsSystem(LinuxIhsSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Ihs System</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Ihs System</em>' containment reference.
	 * @see #setCapabilityWindowsIhsSystem(WindowsIhsSystem)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_CapabilityWindowsIhsSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsIhsSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsIhsSystem getCapabilityWindowsIhsSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityWindowsIhsSystem <em>Capability Windows Ihs System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Ihs System</em>' containment reference.
	 * @see #getCapabilityWindowsIhsSystem()
	 * @generated
	 */
	void setCapabilityWindowsIhsSystem(WindowsIhsSystem value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs Server Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ihs Server Unit</em>' containment reference.
	 * @see #setUnitIhsServerUnit(IhsServerUnit)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_UnitIhsServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsServerUnit getUnitIhsServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsServerUnit <em>Unit Ihs Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs Server Unit</em>' containment reference.
	 * @see #getUnitIhsServerUnit()
	 * @generated
	 */
	void setUnitIhsServerUnit(IhsServerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ihs System Unit</em>' containment reference.
	 * @see #setUnitIhsSystemUnit(IhsSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_UnitIhsSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsSystemUnit getUnitIhsSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsSystemUnit <em>Unit Ihs System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs System Unit</em>' containment reference.
	 * @see #getUnitIhsSystemUnit()
	 * @generated
	 */
	void setUnitIhsSystemUnit(IhsSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs User Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs User Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Ihs User Unit</em>' containment reference.
	 * @see #setUnitIhsUserUnit(IhsUserUnit)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_UnitIhsUserUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsUserUnit' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsUserUnit getUnitIhsUserUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsUserUnit <em>Unit Ihs User Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs User Unit</em>' containment reference.
	 * @see #getUnitIhsUserUnit()
	 * @generated
	 */
	void setUnitIhsUserUnit(IhsUserUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs Was Admin Module Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs Was Admin Module Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ihs Was Admin Module Unit</em>' containment reference.
	 * @see #setUnitIhsWasAdminModuleUnit(IhsWasAdminModuleUnit)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_UnitIhsWasAdminModuleUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsWasAdminModuleUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsWasAdminModuleUnit getUnitIhsWasAdminModuleUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasAdminModuleUnit <em>Unit Ihs Was Admin Module Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs Was Admin Module Unit</em>' containment reference.
	 * @see #getUnitIhsWasAdminModuleUnit()
	 * @generated
	 */
	void setUnitIhsWasAdminModuleUnit(IhsWasAdminModuleUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ihs Was Module Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ihs Was Module Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ihs Was Module Unit</em>' containment reference.
	 * @see #setUnitIhsWasModuleUnit(IhsWasModuleUnit)
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsPackage#getIHSDeployRoot_UnitIhsWasModuleUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ihsWasModuleUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IhsWasModuleUnit getUnitIhsWasModuleUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasModuleUnit <em>Unit Ihs Was Module Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ihs Was Module Unit</em>' containment reference.
	 * @see #getUnitIhsWasModuleUnit()
	 * @generated
	 */
	void setUnitIhsWasModuleUnit(IhsWasModuleUnit value);

} // IHSDeployRoot
