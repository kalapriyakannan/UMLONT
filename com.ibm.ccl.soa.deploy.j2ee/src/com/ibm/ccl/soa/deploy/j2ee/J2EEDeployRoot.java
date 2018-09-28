/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>J2EE Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityAppClientModule <em>Capability App Client Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEarModule <em>Capability Ear Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjb <em>Capability Ejb</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbContainer <em>Capability Ejb Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbModule <em>Capability Ejb Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeContainer <em>Capability J2ee Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeDatasource <em>Capability J2ee Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeModule <em>Capability J2ee Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceEnvironmentRequirement <em>Capability J2ee Resource Environment Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceRequirement <em>Capability J2ee Resource Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeSecurityRole <em>Capability J2ee Security Role</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeServer <em>Capability J2ee Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJarModule <em>Capability Jar Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaContainer <em>Capability Jca Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaModule <em>Capability Jca Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJspContainer <em>Capability Jsp Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityServletContainer <em>Capability Servlet Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityWebModule <em>Capability Web Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEar <em>Component Ear</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEjb <em>Component Ejb</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentJar <em>Component Jar</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentWeb <em>Component Web</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceJava <em>Interface Java</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceUrl <em>Interface Url</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceWsdl <em>Interface Wsdl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceEntity <em>Service Entity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceServlet <em>Service Servlet</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceSession <em>Service Session</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceWs <em>Service Ws</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitAppClient <em>Unit App Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServer <em>Unit J2ee Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServerUnit <em>Unit J2ee Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJcaModule <em>Unit Jca Module</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitWebServer <em>Unit Web Server</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface J2EEDeployRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability App Client Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability App Client Module</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability App Client Module</em>' containment reference.
	 * @see #setCapabilityAppClientModule(AppClientModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityAppClientModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.appClientModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	AppClientModule getCapabilityAppClientModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityAppClientModule <em>Capability App Client Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability App Client Module</em>' containment reference.
	 * @see #getCapabilityAppClientModule()
	 * @generated
	 */
	void setCapabilityAppClientModule(AppClientModule value);

	/**
	 * Returns the value of the '<em><b>Capability Ear Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ear Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ear Module</em>' containment reference.
	 * @see #setCapabilityEarModule(EARModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityEarModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.earModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EARModuleCapability getCapabilityEarModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEarModule <em>Capability Ear Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ear Module</em>' containment reference.
	 * @see #getCapabilityEarModule()
	 * @generated
	 */
	void setCapabilityEarModule(EARModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability Ejb</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ejb</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Ejb</em>' containment reference.
	 * @see #setCapabilityEjb(EJB)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityEjb()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ejb' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EJB getCapabilityEjb();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjb <em>Capability Ejb</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ejb</em>' containment reference.
	 * @see #getCapabilityEjb()
	 * @generated
	 */
	void setCapabilityEjb(EJB value);

	/**
	 * Returns the value of the '<em><b>Capability Ejb Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ejb Container</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ejb Container</em>' containment reference.
	 * @see #setCapabilityEjbContainer(EJBContainer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityEjbContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ejbContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EJBContainer getCapabilityEjbContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbContainer <em>Capability Ejb Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ejb Container</em>' containment reference.
	 * @see #getCapabilityEjbContainer()
	 * @generated
	 */
	void setCapabilityEjbContainer(EJBContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Ejb Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ejb Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ejb Module</em>' containment reference.
	 * @see #setCapabilityEjbModule(EJBModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityEjbModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ejbModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EJBModuleCapability getCapabilityEjbModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbModule <em>Capability Ejb Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ejb Module</em>' containment reference.
	 * @see #getCapabilityEjbModule()
	 * @generated
	 */
	void setCapabilityEjbModule(EJBModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Container</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Container</em>' containment reference.
	 * @see #setCapabilityJ2eeContainer(J2EEContainer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEContainer getCapabilityJ2eeContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeContainer <em>Capability J2ee Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Container</em>' containment reference.
	 * @see #getCapabilityJ2eeContainer()
	 * @generated
	 */
	void setCapabilityJ2eeContainer(J2EEContainer value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Datasource</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Datasource</em>' containment reference.
	 * @see #setCapabilityJ2eeDatasource(J2EEDatasource)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeDatasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeDatasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEDatasource getCapabilityJ2eeDatasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeDatasource <em>Capability J2ee Datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Datasource</em>' containment reference.
	 * @see #getCapabilityJ2eeDatasource()
	 * @generated
	 */
	void setCapabilityJ2eeDatasource(J2EEDatasource value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Module</em>' containment reference.
	 * @see #setCapabilityJ2eeModule(J2EEModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEModuleCapability getCapabilityJ2eeModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeModule <em>Capability J2ee Module</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Module</em>' containment reference.
	 * @see #getCapabilityJ2eeModule()
	 * @generated
	 */
	void setCapabilityJ2eeModule(J2EEModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Resource Environment Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Resource Environment Requirement</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Resource Environment Requirement</em>' containment reference.
	 * @see #setCapabilityJ2eeResourceEnvironmentRequirement(J2EEResourceEnvironmentRequirement)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeResourceEnvironmentRequirement' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEResourceEnvironmentRequirement getCapabilityJ2eeResourceEnvironmentRequirement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceEnvironmentRequirement <em>Capability J2ee Resource Environment Requirement</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Resource Environment Requirement</em>' containment reference.
	 * @see #getCapabilityJ2eeResourceEnvironmentRequirement()
	 * @generated
	 */
	void setCapabilityJ2eeResourceEnvironmentRequirement(J2EEResourceEnvironmentRequirement value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Resource Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Resource Requirement</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Resource Requirement</em>' containment reference.
	 * @see #setCapabilityJ2eeResourceRequirement(J2EEResourceRequirement)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeResourceRequirement' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEResourceRequirement getCapabilityJ2eeResourceRequirement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceRequirement <em>Capability J2ee Resource Requirement</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Resource Requirement</em>' containment reference.
	 * @see #getCapabilityJ2eeResourceRequirement()
	 * @generated
	 */
	void setCapabilityJ2eeResourceRequirement(J2EEResourceRequirement value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Security Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Security Role</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Security Role</em>' containment reference.
	 * @see #setCapabilityJ2eeSecurityRole(J2EESecurityRole)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeSecurityRole()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeSecurityRole' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EESecurityRole getCapabilityJ2eeSecurityRole();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeSecurityRole <em>Capability J2ee Security Role</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Security Role</em>' containment reference.
	 * @see #getCapabilityJ2eeSecurityRole()
	 * @generated
	 */
	void setCapabilityJ2eeSecurityRole(J2EESecurityRole value);

	/**
	 * Returns the value of the '<em><b>Capability J2ee Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability J2ee Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability J2ee Server</em>' containment reference.
	 * @see #setCapabilityJ2eeServer(J2EEServer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJ2eeServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.j2eeServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	J2EEServer getCapabilityJ2eeServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeServer <em>Capability J2ee Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability J2ee Server</em>' containment reference.
	 * @see #getCapabilityJ2eeServer()
	 * @generated
	 */
	void setCapabilityJ2eeServer(J2EEServer value);

	/**
	 * Returns the value of the '<em><b>Capability Jar Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jar Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jar Module</em>' containment reference.
	 * @see #setCapabilityJarModule(JarModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJarModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jarModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JarModuleCapability getCapabilityJarModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJarModule <em>Capability Jar Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jar Module</em>' containment reference.
	 * @see #getCapabilityJarModule()
	 * @generated
	 */
	void setCapabilityJarModule(JarModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability Jca Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jca Container</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jca Container</em>' containment reference.
	 * @see #setCapabilityJcaContainer(JCAContainer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJcaContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jcaContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JCAContainer getCapabilityJcaContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaContainer <em>Capability Jca Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jca Container</em>' containment reference.
	 * @see #getCapabilityJcaContainer()
	 * @generated
	 */
	void setCapabilityJcaContainer(JCAContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Jca Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jca Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jca Module</em>' containment reference.
	 * @see #setCapabilityJcaModule(JCAModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJcaModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jcaModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JCAModuleCapability getCapabilityJcaModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaModule <em>Capability Jca Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jca Module</em>' containment reference.
	 * @see #getCapabilityJcaModule()
	 * @generated
	 */
	void setCapabilityJcaModule(JCAModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability Jsp Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Jsp Container</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Jsp Container</em>' containment reference.
	 * @see #setCapabilityJspContainer(JSPContainer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityJspContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.jspContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JSPContainer getCapabilityJspContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJspContainer <em>Capability Jsp Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Jsp Container</em>' containment reference.
	 * @see #getCapabilityJspContainer()
	 * @generated
	 */
	void setCapabilityJspContainer(JSPContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Servlet Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Servlet Container</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Servlet Container</em>' containment reference.
	 * @see #setCapabilityServletContainer(ServletContainer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityServletContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.servletContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ServletContainer getCapabilityServletContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityServletContainer <em>Capability Servlet Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Servlet Container</em>' containment reference.
	 * @see #getCapabilityServletContainer()
	 * @generated
	 */
	void setCapabilityServletContainer(ServletContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Web Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Web Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Web Module</em>' containment reference.
	 * @see #setCapabilityWebModule(WebModuleCapability)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_CapabilityWebModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.webModule' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WebModuleCapability getCapabilityWebModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityWebModule <em>Capability Web Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Web Module</em>' containment reference.
	 * @see #getCapabilityWebModule()
	 * @generated
	 */
	void setCapabilityWebModule(WebModuleCapability value);

	/**
	 * Returns the value of the '<em><b>Component Ear</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ear</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Component Ear</em>' containment reference.
	 * @see #setComponentEar(EarModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ComponentEar()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.ear' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	EarModule getComponentEar();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEar <em>Component Ear</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ear</em>' containment reference.
	 * @see #getComponentEar()
	 * @generated
	 */
	void setComponentEar(EarModule value);

	/**
	 * Returns the value of the '<em><b>Component Ejb</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ejb</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Component Ejb</em>' containment reference.
	 * @see #setComponentEjb(EjbModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ComponentEjb()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.ejb' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	EjbModule getComponentEjb();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEjb <em>Component Ejb</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ejb</em>' containment reference.
	 * @see #getComponentEjb()
	 * @generated
	 */
	void setComponentEjb(EjbModule value);

	/**
	 * Returns the value of the '<em><b>Component Jar</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Jar</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Component Jar</em>' containment reference.
	 * @see #setComponentJar(JarModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ComponentJar()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.jar' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JarModule getComponentJar();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentJar <em>Component Jar</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Jar</em>' containment reference.
	 * @see #getComponentJar()
	 * @generated
	 */
	void setComponentJar(JarModule value);

	/**
	 * Returns the value of the '<em><b>Component Web</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Web</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Component Web</em>' containment reference.
	 * @see #setComponentWeb(WebModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ComponentWeb()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.web' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WebModule getComponentWeb();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentWeb <em>Component Web</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Web</em>' containment reference.
	 * @see #getComponentWeb()
	 * @generated
	 */
	void setComponentWeb(WebModule value);

	/**
	 * Returns the value of the '<em><b>Interface Java</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Java</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface Java</em>' containment reference.
	 * @see #setInterfaceJava(JavaInterface)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_InterfaceJava()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface.java' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface'"
	 * @generated
	 */
	JavaInterface getInterfaceJava();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceJava <em>Interface Java</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Java</em>' containment reference.
	 * @see #getInterfaceJava()
	 * @generated
	 */
	void setInterfaceJava(JavaInterface value);

	/**
	 * Returns the value of the '<em><b>Interface Url</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Url</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface Url</em>' containment reference.
	 * @see #setInterfaceUrl(URLInterface)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_InterfaceUrl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface.url' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface'"
	 * @generated
	 */
	URLInterface getInterfaceUrl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceUrl <em>Interface Url</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Url</em>' containment reference.
	 * @see #getInterfaceUrl()
	 * @generated
	 */
	void setInterfaceUrl(URLInterface value);

	/**
	 * Returns the value of the '<em><b>Interface Wsdl</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Wsdl</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface Wsdl</em>' containment reference.
	 * @see #setInterfaceWsdl(WSDLInterface)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_InterfaceWsdl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface.wsdl' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#interface'"
	 * @generated
	 */
	WSDLInterface getInterfaceWsdl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceWsdl <em>Interface Wsdl</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Wsdl</em>' containment reference.
	 * @see #getInterfaceWsdl()
	 * @generated
	 */
	void setInterfaceWsdl(WSDLInterface value);

	/**
	 * Returns the value of the '<em><b>Service Entity</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Entity</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Entity</em>' containment reference.
	 * @see #setServiceEntity(EntityService)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ServiceEntity()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service.entity' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EntityService getServiceEntity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceEntity <em>Service Entity</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Entity</em>' containment reference.
	 * @see #getServiceEntity()
	 * @generated
	 */
	void setServiceEntity(EntityService value);

	/**
	 * Returns the value of the '<em><b>Service Servlet</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Servlet</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Servlet</em>' containment reference.
	 * @see #setServiceServlet(URLService)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ServiceServlet()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service.servlet' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	URLService getServiceServlet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceServlet <em>Service Servlet</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Servlet</em>' containment reference.
	 * @see #getServiceServlet()
	 * @generated
	 */
	void setServiceServlet(URLService value);

	/**
	 * Returns the value of the '<em><b>Service Session</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Session</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Session</em>' containment reference.
	 * @see #setServiceSession(SessionService)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ServiceSession()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service.session' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SessionService getServiceSession();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceSession <em>Service Session</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Session</em>' containment reference.
	 * @see #getServiceSession()
	 * @generated
	 */
	void setServiceSession(SessionService value);

	/**
	 * Returns the value of the '<em><b>Service Ws</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Ws</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Ws</em>' containment reference.
	 * @see #setServiceWs(WebService)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_ServiceWs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service.ws' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WebService getServiceWs();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceWs <em>Service Ws</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Ws</em>' containment reference.
	 * @see #getServiceWs()
	 * @generated
	 */
	void setServiceWs(WebService value);

	/**
	 * Returns the value of the '<em><b>Unit App Client</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit App Client</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit App Client</em>' containment reference.
	 * @see #setUnitAppClient(AppClient)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_UnitAppClient()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.appClient' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	AppClient getUnitAppClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitAppClient <em>Unit App Client</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit App Client</em>' containment reference.
	 * @see #getUnitAppClient()
	 * @generated
	 */
	void setUnitAppClient(AppClient value);

	/**
	 * Returns the value of the '<em><b>Unit J2ee Server</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit J2ee Server</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit J2ee Server</em>' containment reference.
	 * @see #setUnitJ2eeServer(GenericJ2eeServer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_UnitJ2eeServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.j2eeServer' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	GenericJ2eeServer getUnitJ2eeServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServer <em>Unit J2ee Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit J2ee Server</em>' containment reference.
	 * @see #getUnitJ2eeServer()
	 * @generated
	 */
	void setUnitJ2eeServer(GenericJ2eeServer value);

	/**
	 * Returns the value of the '<em><b>Unit J2ee Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit J2ee Server Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit J2ee Server Unit</em>' containment reference.
	 * @see #setUnitJ2eeServerUnit(J2EEServerUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_UnitJ2eeServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.j2eeServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	J2EEServerUnit getUnitJ2eeServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServerUnit <em>Unit J2ee Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit J2ee Server Unit</em>' containment reference.
	 * @see #getUnitJ2eeServerUnit()
	 * @generated
	 */
	void setUnitJ2eeServerUnit(J2EEServerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Jca Module</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Jca Module</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Jca Module</em>' containment reference.
	 * @see #setUnitJcaModule(JCAModule)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_UnitJcaModule()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.jcaModule' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JCAModule getUnitJcaModule();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJcaModule <em>Unit Jca Module</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Jca Module</em>' containment reference.
	 * @see #getUnitJcaModule()
	 * @generated
	 */
	void setUnitJcaModule(JCAModule value);

	/**
	 * Returns the value of the '<em><b>Unit Web Server</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Web Server</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Web Server</em>' containment reference.
	 * @see #setUnitWebServer(GenericWebServer)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJ2EEDeployRoot_UnitWebServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.webServer' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	GenericWebServer getUnitWebServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitWebServer <em>Unit Web Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Web Server</em>' containment reference.
	 * @see #getUnitWebServer()
	 * @generated
	 */
	void setUnitWebServer(GenericWebServer value);

} // J2EEDeployRoot
