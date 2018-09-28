/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityDb2JdbcProvider <em>Capability Db2 Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityDerbyJdbcProvider <em>Capability Derby Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityExtendedJdbcProvider <em>Capability Extended Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasAdvancedLdapConfiguration <em>Capability Was Advanced Ldap Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationClassLoaderPolicy <em>Capability Was Application Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationExt <em>Capability Was Application Ext</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationServerClassLoaderPolicy <em>Capability Was Application Server Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasCell <em>Capability Was Cell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasClassLoaderPolicy <em>Capability Was Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasCluster <em>Capability Was Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasConfigurationContainer <em>Capability Was Configuration Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDatasource <em>Capability Was Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingConnectionFactoryConfiguration <em>Capability Was Default Messaging Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration <em>Capability Was Default Messaging Queue Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingQueueDestination <em>Capability Was Default Messaging Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration <em>Capability Was Default Messaging Topic Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingTopicDestination <em>Capability Was Default Messaging Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDeploymentManager <em>Capability Was Deployment Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasEndpointListenerConfiguration <em>Capability Was Endpoint Listener Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasHandlerList <em>Capability Was Handler List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJ2CAuth <em>Capability Was J2C Auth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJ2EEServer <em>Capability Was J2EE Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJMSActivationSpecification <em>Capability Was JMS Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasLdapConfiguration <em>Capability Was Ldap Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasMessagingEngine <em>Capability Was Messaging Engine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasModuleClassLoaderPolicy <em>Capability Was Module Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasNode <em>Capability Was Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasNodeGroup <em>Capability Was Node Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasPluginAdmin <em>Capability Was Plugin Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasPluginRedirection <em>Capability Was Plugin Redirection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSecurity <em>Capability Was Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSecuritySubject <em>Capability Was Security Subject</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasServer <em>Capability Was Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSharedLibContainer <em>Capability Was Shared Lib Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSharedLibrary <em>Capability Was Shared Library</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibDestination <em>Capability Was Sib Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibForeignBus <em>Capability Was Sib Foreign Bus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibInboundPort <em>Capability Was Sib Inbound Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibInboundService <em>Capability Was Sib Inbound Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibMediation <em>Capability Was Sib Mediation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibOutboundPort <em>Capability Was Sib Outbound Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibOutboundService <em>Capability Was Sib Outbound Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibServiceIntegrationBusLink <em>Capability Was Sib Service Integration Bus Link</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSIBus <em>Capability Was SI Bus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSubstitutionVariable <em>Capability Was Substitution Variable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSystem <em>Capability Was System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv4datasource <em>Capability Wasv4datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5datasource <em>Capability Wasv5datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5DB2Datasource <em>Capability Wasv5 DB2 Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5DB2ZosDatasource <em>Capability Wasv5 DB2 Zos Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasVirtualHost <em>Capability Was Virtual Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebAppExt <em>Capability Was Web App Ext</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServer <em>Capability Was Web Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServerManagement <em>Capability Was Web Server Management</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServerPlugin <em>Capability Was Web Server Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getClassloader <em>Classloader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasEarClassloaderPolicyConstraint <em>Constraint Was Ear Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasJ2EEConstraint <em>Constraint Was J2EE Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasJNDIBindingConstraint <em>Constraint Was JNDI Binding Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasModuleClassloaderPolicyConstraint <em>Constraint Was Module Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasModuleStartWeightConstraint <em>Constraint Was Module Start Weight Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasSecuritySubjectConstraint <em>Constraint Was Security Subject Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasWarClassloaderPolicyConstraint <em>Constraint Was War Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getHostNameAlias <em>Host Name Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitDb2JdbcProviderUnit <em>Unit Db2 Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitDerbyJdbcProviderUnit <em>Unit Derby Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitExtendedJdbcProviderUnit <em>Unit Extended Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasAppServer <em>Unit Was App Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasCellUnit <em>Unit Was Cell Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasClassLoaderConfigurationUnit <em>Unit Was Class Loader Configuration Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasClusterUnit <em>Unit Was Cluster Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasdatasource <em>Unit Wasdatasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingConnectionFactoryUnit <em>Unit Was Default Messaging Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingQueueConnectionFactoryUnit <em>Unit Was Default Messaging Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingQueueDestinationUnit <em>Unit Was Default Messaging Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingTopicConnectionFactoryUnit <em>Unit Was Default Messaging Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingTopicDestinationUnit <em>Unit Was Default Messaging Topic Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDeploymentManagerUnit <em>Unit Was Deployment Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasEndpointListenerUnit <em>Unit Was Endpoint Listener Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasJ2CAuth <em>Unit Was J2C Auth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasJMSActivationSpecificationUnit <em>Unit Was JMS Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasLdapConfigurationUnit <em>Unit Was Ldap Configuration Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasMessagingEngine <em>Unit Was Messaging Engine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeGroupUnit <em>Unit Was Node Group Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeUnit <em>Unit Was Node Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeWindowsServiceUnit <em>Unit Was Node Windows Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSharedLibraryEntryUnit <em>Unit Was Shared Library Entry Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibDestinationUnit <em>Unit Was Sib Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibInboundPortUnit <em>Unit Was Sib Inbound Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibInboundServiceUnit <em>Unit Was Sib Inbound Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibMediationUnit <em>Unit Was Sib Mediation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibOutboundPortUnit <em>Unit Was Sib Outbound Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibOutboundServiceUnit <em>Unit Was Sib Outbound Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSIBusUnit <em>Unit Was SI Bus Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSystemUnit <em>Unit Was System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasWebServerUnit <em>Unit Was Web Server Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface WasDeployRoot {
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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Db2 Jdbc Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Db2 Jdbc Provider</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Db2 Jdbc Provider</em>' containment reference.
	 * @see #setCapabilityDb2JdbcProvider(DB2JdbcProvider)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityDb2JdbcProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.db2JdbcProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2JdbcProvider getCapabilityDb2JdbcProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityDb2JdbcProvider <em>Capability Db2 Jdbc Provider</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Db2 Jdbc Provider</em>' containment reference.
	 * @see #getCapabilityDb2JdbcProvider()
	 * @generated
	 */
	void setCapabilityDb2JdbcProvider(DB2JdbcProvider value);

	/**
	 * Returns the value of the '<em><b>Capability Derby Jdbc Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Derby Jdbc Provider</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Derby Jdbc Provider</em>' containment reference.
	 * @see #setCapabilityDerbyJdbcProvider(DerbyJdbcProvider)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityDerbyJdbcProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.derbyJdbcProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DerbyJdbcProvider getCapabilityDerbyJdbcProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityDerbyJdbcProvider <em>Capability Derby Jdbc Provider</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Derby Jdbc Provider</em>' containment reference.
	 * @see #getCapabilityDerbyJdbcProvider()
	 * @generated
	 */
	void setCapabilityDerbyJdbcProvider(DerbyJdbcProvider value);

	/**
	 * Returns the value of the '<em><b>Capability Extended Jdbc Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Extended Jdbc Provider</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Extended Jdbc Provider</em>' containment reference.
	 * @see #setCapabilityExtendedJdbcProvider(ExtendedJdbcProvider)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityExtendedJdbcProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.extendedJdbcProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ExtendedJdbcProvider getCapabilityExtendedJdbcProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityExtendedJdbcProvider <em>Capability Extended Jdbc Provider</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Extended Jdbc Provider</em>' containment reference.
	 * @see #getCapabilityExtendedJdbcProvider()
	 * @generated
	 */
	void setCapabilityExtendedJdbcProvider(ExtendedJdbcProvider value);

	/**
	 * Returns the value of the '<em><b>Capability Was Advanced Ldap Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Advanced Ldap Configuration</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Advanced Ldap Configuration</em>' containment reference.
	 * @see #setCapabilityWasAdvancedLdapConfiguration(WasAdvancedLdapConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasAdvancedLdapConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasAdvancedLdapConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasAdvancedLdapConfiguration getCapabilityWasAdvancedLdapConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasAdvancedLdapConfiguration <em>Capability Was Advanced Ldap Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Advanced Ldap Configuration</em>' containment reference.
	 * @see #getCapabilityWasAdvancedLdapConfiguration()
	 * @generated
	 */
	void setCapabilityWasAdvancedLdapConfiguration(WasAdvancedLdapConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Application Class Loader Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Application Class Loader Policy</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Application Class Loader Policy</em>' containment reference.
	 * @see #setCapabilityWasApplicationClassLoaderPolicy(WasApplicationClassLoaderPolicy)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasApplicationClassLoaderPolicy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasApplicationClassLoaderPolicy' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasApplicationClassLoaderPolicy getCapabilityWasApplicationClassLoaderPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationClassLoaderPolicy <em>Capability Was Application Class Loader Policy</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Application Class Loader Policy</em>' containment reference.
	 * @see #getCapabilityWasApplicationClassLoaderPolicy()
	 * @generated
	 */
	void setCapabilityWasApplicationClassLoaderPolicy(WasApplicationClassLoaderPolicy value);

	/**
	 * Returns the value of the '<em><b>Capability Was Application Server Class Loader Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Application Server Class Loader Policy</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Application Server Class Loader Policy</em>' containment reference.
	 * @see #setCapabilityWasApplicationServerClassLoaderPolicy(WasApplicationServerClassLoaderPolicy)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasApplicationServerClassLoaderPolicy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasApplicationServerClassLoaderPolicy' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasApplicationServerClassLoaderPolicy getCapabilityWasApplicationServerClassLoaderPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationServerClassLoaderPolicy <em>Capability Was Application Server Class Loader Policy</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Application Server Class Loader Policy</em>' containment reference.
	 * @see #getCapabilityWasApplicationServerClassLoaderPolicy()
	 * @generated
	 */
	void setCapabilityWasApplicationServerClassLoaderPolicy(
			WasApplicationServerClassLoaderPolicy value);

	/**
	 * Returns the value of the '<em><b>Capability Was Application Ext</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Application Ext</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Application Ext</em>' containment reference.
	 * @see #setCapabilityWasApplicationExt(WasApplicationExt)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasApplicationExt()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasApplicationExt' namespace='##targetNamespace'"
	 * @generated
	 */
	WasApplicationExt getCapabilityWasApplicationExt();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasApplicationExt <em>Capability Was Application Ext</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Application Ext</em>' containment reference.
	 * @see #getCapabilityWasApplicationExt()
	 * @generated
	 */
	void setCapabilityWasApplicationExt(WasApplicationExt value);

	/**
	 * Returns the value of the '<em><b>Capability Was Cell</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Cell</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Cell</em>' containment reference.
	 * @see #setCapabilityWasCell(WasCell)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasCell()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasCell' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasCell getCapabilityWasCell();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasCell <em>Capability Was Cell</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Cell</em>' containment reference.
	 * @see #getCapabilityWasCell()
	 * @generated
	 */
	void setCapabilityWasCell(WasCell value);

	/**
	 * Returns the value of the '<em><b>Capability Was Class Loader Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Class Loader Policy</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Class Loader Policy</em>' containment reference.
	 * @see #setCapabilityWasClassLoaderPolicy(WasClassLoaderPolicy)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasClassLoaderPolicy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasClassLoaderPolicy' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasClassLoaderPolicy getCapabilityWasClassLoaderPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasClassLoaderPolicy <em>Capability Was Class Loader Policy</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Class Loader Policy</em>' containment reference.
	 * @see #getCapabilityWasClassLoaderPolicy()
	 * @generated
	 */
	void setCapabilityWasClassLoaderPolicy(WasClassLoaderPolicy value);

	/**
	 * Returns the value of the '<em><b>Capability Was Cluster</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Cluster</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Cluster</em>' containment reference.
	 * @see #setCapabilityWasCluster(WasCluster)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasCluster()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasCluster' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasCluster getCapabilityWasCluster();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasCluster <em>Capability Was Cluster</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Cluster</em>' containment reference.
	 * @see #getCapabilityWasCluster()
	 * @generated
	 */
	void setCapabilityWasCluster(WasCluster value);

	/**
	 * Returns the value of the '<em><b>Capability Was Configuration Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Configuration Container</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Configuration Container</em>' containment reference.
	 * @see #setCapabilityWasConfigurationContainer(WasConfigurationContainer)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasConfigurationContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasConfigurationContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasConfigurationContainer getCapabilityWasConfigurationContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasConfigurationContainer <em>Capability Was Configuration Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Configuration Container</em>' containment reference.
	 * @see #getCapabilityWasConfigurationContainer()
	 * @generated
	 */
	void setCapabilityWasConfigurationContainer(WasConfigurationContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Was Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Datasource</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Datasource</em>' containment reference.
	 * @see #setCapabilityWasDatasource(WasDatasource)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDatasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDatasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDatasource getCapabilityWasDatasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDatasource <em>Capability Was Datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Datasource</em>' containment reference.
	 * @see #getCapabilityWasDatasource()
	 * @generated
	 */
	void setCapabilityWasDatasource(WasDatasource value);

	/**
	 * Returns the value of the '<em><b>Capability Was Default Messaging Connection Factory Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Default Messaging Connection Factory Configuration</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Default Messaging Connection Factory Configuration</em>' containment reference.
	 * @see #setCapabilityWasDefaultMessagingConnectionFactoryConfiguration(WasDefaultMessagingConnectionFactoryConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDefaultMessagingConnectionFactoryConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDefaultMessagingConnectionFactoryConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDefaultMessagingConnectionFactoryConfiguration getCapabilityWasDefaultMessagingConnectionFactoryConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingConnectionFactoryConfiguration <em>Capability Was Default Messaging Connection Factory Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Default Messaging Connection Factory Configuration</em>' containment reference.
	 * @see #getCapabilityWasDefaultMessagingConnectionFactoryConfiguration()
	 * @generated
	 */
	void setCapabilityWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Default Messaging Queue Connection Factory Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Default Messaging Queue Connection Factory Configuration</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Default Messaging Queue Connection Factory Configuration</em>' containment reference.
	 * @see #setCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(WasDefaultMessagingQueueConnectionFactoryConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDefaultMessagingQueueConnectionFactoryConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDefaultMessagingQueueConnectionFactoryConfiguration getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration <em>Capability Was Default Messaging Queue Connection Factory Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Default Messaging Queue Connection Factory Configuration</em>' containment reference.
	 * @see #getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration()
	 * @generated
	 */
	void setCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Default Messaging Queue Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Default Messaging Queue Destination</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Default Messaging Queue Destination</em>' containment reference.
	 * @see #setCapabilityWasDefaultMessagingQueueDestination(WasDefaultMessagingQueueDestination)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDefaultMessagingQueueDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDefaultMessagingQueueDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDefaultMessagingQueueDestination getCapabilityWasDefaultMessagingQueueDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingQueueDestination <em>Capability Was Default Messaging Queue Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Default Messaging Queue Destination</em>' containment reference.
	 * @see #getCapabilityWasDefaultMessagingQueueDestination()
	 * @generated
	 */
	void setCapabilityWasDefaultMessagingQueueDestination(WasDefaultMessagingQueueDestination value);

	/**
	 * Returns the value of the '<em><b>Capability Was Default Messaging Topic Connection Factory Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Default Messaging Topic Connection Factory Configuration</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Default Messaging Topic Connection Factory Configuration</em>' containment reference.
	 * @see #setCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(WasDefaultMessagingTopicConnectionFactoryConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDefaultMessagingTopicConnectionFactoryConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDefaultMessagingTopicConnectionFactoryConfiguration getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration <em>Capability Was Default Messaging Topic Connection Factory Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Default Messaging Topic Connection Factory Configuration</em>' containment reference.
	 * @see #getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration()
	 * @generated
	 */
	void setCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Default Messaging Topic Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Default Messaging Topic Destination</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Default Messaging Topic Destination</em>' containment reference.
	 * @see #setCapabilityWasDefaultMessagingTopicDestination(WasDefaultMessagingTopicDestination)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDefaultMessagingTopicDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDefaultMessagingTopicDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDefaultMessagingTopicDestination getCapabilityWasDefaultMessagingTopicDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDefaultMessagingTopicDestination <em>Capability Was Default Messaging Topic Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Default Messaging Topic Destination</em>' containment reference.
	 * @see #getCapabilityWasDefaultMessagingTopicDestination()
	 * @generated
	 */
	void setCapabilityWasDefaultMessagingTopicDestination(WasDefaultMessagingTopicDestination value);

	/**
	 * Returns the value of the '<em><b>Capability Was Deployment Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Deployment Manager</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Deployment Manager</em>' containment reference.
	 * @see #setCapabilityWasDeploymentManager(WasDeploymentManager)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasDeploymentManager()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasDeploymentManager' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasDeploymentManager getCapabilityWasDeploymentManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasDeploymentManager <em>Capability Was Deployment Manager</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Deployment Manager</em>' containment reference.
	 * @see #getCapabilityWasDeploymentManager()
	 * @generated
	 */
	void setCapabilityWasDeploymentManager(WasDeploymentManager value);

	/**
	 * Returns the value of the '<em><b>Capability Was Endpoint Listener Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Endpoint Listener Configuration</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Endpoint Listener Configuration</em>' containment reference.
	 * @see #setCapabilityWasEndpointListenerConfiguration(WasEndpointListenerConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasEndpointListenerConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasEndpointListenerConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasEndpointListenerConfiguration getCapabilityWasEndpointListenerConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasEndpointListenerConfiguration <em>Capability Was Endpoint Listener Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Endpoint Listener Configuration</em>' containment reference.
	 * @see #getCapabilityWasEndpointListenerConfiguration()
	 * @generated
	 */
	void setCapabilityWasEndpointListenerConfiguration(WasEndpointListenerConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Handler List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Handler List</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Handler List</em>' containment reference.
	 * @see #setCapabilityWasHandlerList(WasHandlerList)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasHandlerList()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasHandlerList' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasHandlerList getCapabilityWasHandlerList();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasHandlerList <em>Capability Was Handler List</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Handler List</em>' containment reference.
	 * @see #getCapabilityWasHandlerList()
	 * @generated
	 */
	void setCapabilityWasHandlerList(WasHandlerList value);

	/**
	 * Returns the value of the '<em><b>Capability Was J2C Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was J2C Auth</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was J2C Auth</em>' containment reference.
	 * @see #setCapabilityWasJ2CAuth(WASJ2CAuthenticationDataEntry)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasJ2CAuth()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasJ2CAuth' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WASJ2CAuthenticationDataEntry getCapabilityWasJ2CAuth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJ2CAuth <em>Capability Was J2C Auth</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was J2C Auth</em>' containment reference.
	 * @see #getCapabilityWasJ2CAuth()
	 * @generated
	 */
	void setCapabilityWasJ2CAuth(WASJ2CAuthenticationDataEntry value);

	/**
	 * Returns the value of the '<em><b>Capability Was J2EE Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was J2EE Server</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was J2EE Server</em>' containment reference.
	 * @see #setCapabilityWasJ2EEServer(WasJ2EEServer)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasJ2EEServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasJ2EEServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasJ2EEServer getCapabilityWasJ2EEServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJ2EEServer <em>Capability Was J2EE Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was J2EE Server</em>' containment reference.
	 * @see #getCapabilityWasJ2EEServer()
	 * @generated
	 */
	void setCapabilityWasJ2EEServer(WasJ2EEServer value);

	/**
	 * Returns the value of the '<em><b>Capability Was JMS Activation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was JMS Activation Specification</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was JMS Activation Specification</em>' containment reference.
	 * @see #setCapabilityWasJMSActivationSpecification(WasJMSActivationSpecification)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasJMSActivationSpecification()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasJMSActivationSpecification' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasJMSActivationSpecification getCapabilityWasJMSActivationSpecification();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasJMSActivationSpecification <em>Capability Was JMS Activation Specification</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was JMS Activation Specification</em>' containment reference.
	 * @see #getCapabilityWasJMSActivationSpecification()
	 * @generated
	 */
	void setCapabilityWasJMSActivationSpecification(WasJMSActivationSpecification value);

	/**
	 * Returns the value of the '<em><b>Capability Was Ldap Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Ldap Configuration</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Ldap Configuration</em>' containment reference.
	 * @see #setCapabilityWasLdapConfiguration(WasLdapConfiguration)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasLdapConfiguration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasLdapConfiguration' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasLdapConfiguration getCapabilityWasLdapConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasLdapConfiguration <em>Capability Was Ldap Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Ldap Configuration</em>' containment reference.
	 * @see #getCapabilityWasLdapConfiguration()
	 * @generated
	 */
	void setCapabilityWasLdapConfiguration(WasLdapConfiguration value);

	/**
	 * Returns the value of the '<em><b>Capability Was Messaging Engine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Messaging Engine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Messaging Engine</em>' containment reference.
	 * @see #setCapabilityWasMessagingEngine(WasMessagingEngine)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasMessagingEngine()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasMessagingEngine' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasMessagingEngine getCapabilityWasMessagingEngine();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasMessagingEngine <em>Capability Was Messaging Engine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Messaging Engine</em>' containment reference.
	 * @see #getCapabilityWasMessagingEngine()
	 * @generated
	 */
	void setCapabilityWasMessagingEngine(WasMessagingEngine value);

	/**
	 * Returns the value of the '<em><b>Capability Was Module Class Loader Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Module Class Loader Policy</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Module Class Loader Policy</em>' containment reference.
	 * @see #setCapabilityWasModuleClassLoaderPolicy(WasModuleClassLoaderPolicy)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasModuleClassLoaderPolicy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasModuleClassLoaderPolicy' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasModuleClassLoaderPolicy getCapabilityWasModuleClassLoaderPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasModuleClassLoaderPolicy <em>Capability Was Module Class Loader Policy</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Module Class Loader Policy</em>' containment reference.
	 * @see #getCapabilityWasModuleClassLoaderPolicy()
	 * @generated
	 */
	void setCapabilityWasModuleClassLoaderPolicy(WasModuleClassLoaderPolicy value);

	/**
	 * Returns the value of the '<em><b>Capability Was Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Node</em>' containment reference.
	 * @see #setCapabilityWasNode(WasNode)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasNode()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasNode' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasNode getCapabilityWasNode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasNode <em>Capability Was Node</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Node</em>' containment reference.
	 * @see #getCapabilityWasNode()
	 * @generated
	 */
	void setCapabilityWasNode(WasNode value);

	/**
	 * Returns the value of the '<em><b>Capability Was Node Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Node Group</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Node Group</em>' containment reference.
	 * @see #setCapabilityWasNodeGroup(WasNodeGroup)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasNodeGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasNodeGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasNodeGroup getCapabilityWasNodeGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasNodeGroup <em>Capability Was Node Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Node Group</em>' containment reference.
	 * @see #getCapabilityWasNodeGroup()
	 * @generated
	 */
	void setCapabilityWasNodeGroup(WasNodeGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Was Plugin Admin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Plugin Admin</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Plugin Admin</em>' containment reference.
	 * @see #setCapabilityWasPluginAdmin(WasPluginAdmin)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasPluginAdmin()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasPluginAdmin' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasPluginAdmin getCapabilityWasPluginAdmin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasPluginAdmin <em>Capability Was Plugin Admin</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Plugin Admin</em>' containment reference.
	 * @see #getCapabilityWasPluginAdmin()
	 * @generated
	 */
	void setCapabilityWasPluginAdmin(WasPluginAdmin value);

	/**
	 * Returns the value of the '<em><b>Capability Was Plugin Redirection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Plugin Redirection</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Plugin Redirection</em>' containment reference.
	 * @see #setCapabilityWasPluginRedirection(WasPluginRedirection)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasPluginRedirection()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasPluginRedirection' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasPluginRedirection getCapabilityWasPluginRedirection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasPluginRedirection <em>Capability Was Plugin Redirection</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Plugin Redirection</em>' containment reference.
	 * @see #getCapabilityWasPluginRedirection()
	 * @generated
	 */
	void setCapabilityWasPluginRedirection(WasPluginRedirection value);

	/**
	 * Returns the value of the '<em><b>Capability Was Security</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Security</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Security</em>' containment reference.
	 * @see #setCapabilityWasSecurity(WasSecurity)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSecurity()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSecurity' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSecurity getCapabilityWasSecurity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSecurity <em>Capability Was Security</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Security</em>' containment reference.
	 * @see #getCapabilityWasSecurity()
	 * @generated
	 */
	void setCapabilityWasSecurity(WasSecurity value);

	/**
	 * Returns the value of the '<em><b>Capability Was Security Subject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Security Subject</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Security Subject</em>' containment reference.
	 * @see #setCapabilityWasSecuritySubject(WasSecuritySubject)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSecuritySubject()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSecuritySubject' namespace='##targetNamespace'"
	 * @generated
	 */
	WasSecuritySubject getCapabilityWasSecuritySubject();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSecuritySubject <em>Capability Was Security Subject</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Security Subject</em>' containment reference.
	 * @see #getCapabilityWasSecuritySubject()
	 * @generated
	 */
	void setCapabilityWasSecuritySubject(WasSecuritySubject value);

	/**
	 * Returns the value of the '<em><b>Capability Was Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Server</em>' containment reference.
	 * @see #setCapabilityWasServer(WasServer)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasServer getCapabilityWasServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasServer <em>Capability Was Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Server</em>' containment reference.
	 * @see #getCapabilityWasServer()
	 * @generated
	 */
	void setCapabilityWasServer(WasServer value);

	/**
	 * Returns the value of the '<em><b>Capability Was Shared Lib Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Shared Lib Container</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Shared Lib Container</em>' containment reference.
	 * @see #setCapabilityWasSharedLibContainer(WasSharedLibContainer)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSharedLibContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSharedLibContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSharedLibContainer getCapabilityWasSharedLibContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSharedLibContainer <em>Capability Was Shared Lib Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Shared Lib Container</em>' containment reference.
	 * @see #getCapabilityWasSharedLibContainer()
	 * @generated
	 */
	void setCapabilityWasSharedLibContainer(WasSharedLibContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Was Shared Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Shared Library</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Shared Library</em>' containment reference.
	 * @see #setCapabilityWasSharedLibrary(SharedLibraryEntry)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSharedLibrary()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSharedLibrary' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SharedLibraryEntry getCapabilityWasSharedLibrary();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSharedLibrary <em>Capability Was Shared Library</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Shared Library</em>' containment reference.
	 * @see #getCapabilityWasSharedLibrary()
	 * @generated
	 */
	void setCapabilityWasSharedLibrary(SharedLibraryEntry value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Destination</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Destination</em>' containment reference.
	 * @see #setCapabilityWasSibDestination(WasSibDestination)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibDestination getCapabilityWasSibDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibDestination <em>Capability Was Sib Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Destination</em>' containment reference.
	 * @see #getCapabilityWasSibDestination()
	 * @generated
	 */
	void setCapabilityWasSibDestination(WasSibDestination value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Foreign Bus</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Foreign Bus</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Foreign Bus</em>' containment reference.
	 * @see #setCapabilityWasSibForeignBus(WasSibForeignBus)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibForeignBus()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.WasSibForeignBus' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibForeignBus getCapabilityWasSibForeignBus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibForeignBus <em>Capability Was Sib Foreign Bus</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Foreign Bus</em>' containment reference.
	 * @see #getCapabilityWasSibForeignBus()
	 * @generated
	 */
	void setCapabilityWasSibForeignBus(WasSibForeignBus value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Inbound Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Inbound Port</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Inbound Port</em>' containment reference.
	 * @see #setCapabilityWasSibInboundPort(WasSibInboundPort)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibInboundPort()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibInboundPort' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibInboundPort getCapabilityWasSibInboundPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibInboundPort <em>Capability Was Sib Inbound Port</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Inbound Port</em>' containment reference.
	 * @see #getCapabilityWasSibInboundPort()
	 * @generated
	 */
	void setCapabilityWasSibInboundPort(WasSibInboundPort value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Inbound Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Inbound Service</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Inbound Service</em>' containment reference.
	 * @see #setCapabilityWasSibInboundService(WasSibInboundService)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibInboundService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibInboundService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibInboundService getCapabilityWasSibInboundService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibInboundService <em>Capability Was Sib Inbound Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Inbound Service</em>' containment reference.
	 * @see #getCapabilityWasSibInboundService()
	 * @generated
	 */
	void setCapabilityWasSibInboundService(WasSibInboundService value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Mediation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Mediation</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Mediation</em>' containment reference.
	 * @see #setCapabilityWasSibMediation(WasSibMediation)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibMediation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibMediation' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibMediation getCapabilityWasSibMediation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibMediation <em>Capability Was Sib Mediation</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Mediation</em>' containment reference.
	 * @see #getCapabilityWasSibMediation()
	 * @generated
	 */
	void setCapabilityWasSibMediation(WasSibMediation value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Outbound Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Outbound Port</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Outbound Port</em>' containment reference.
	 * @see #setCapabilityWasSibOutboundPort(WasSibOutboundPort)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibOutboundPort()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibOutboundPort' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibOutboundPort getCapabilityWasSibOutboundPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibOutboundPort <em>Capability Was Sib Outbound Port</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Outbound Port</em>' containment reference.
	 * @see #getCapabilityWasSibOutboundPort()
	 * @generated
	 */
	void setCapabilityWasSibOutboundPort(WasSibOutboundPort value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Outbound Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Outbound Service</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Outbound Service</em>' containment reference.
	 * @see #setCapabilityWasSibOutboundService(WasSibOutboundService)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibOutboundService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibOutboundService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibOutboundService getCapabilityWasSibOutboundService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibOutboundService <em>Capability Was Sib Outbound Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Outbound Service</em>' containment reference.
	 * @see #getCapabilityWasSibOutboundService()
	 * @generated
	 */
	void setCapabilityWasSibOutboundService(WasSibOutboundService value);

	/**
	 * Returns the value of the '<em><b>Capability Was Sib Service Integration Bus Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Sib Service Integration Bus Link</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Sib Service Integration Bus Link</em>' containment reference.
	 * @see #setCapabilityWasSibServiceIntegrationBusLink(WasSibServiceIntegrationBusLink)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSibServiceIntegrationBusLink()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSibServiceIntegrationBusLink' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSibServiceIntegrationBusLink getCapabilityWasSibServiceIntegrationBusLink();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSibServiceIntegrationBusLink <em>Capability Was Sib Service Integration Bus Link</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Sib Service Integration Bus Link</em>' containment reference.
	 * @see #getCapabilityWasSibServiceIntegrationBusLink()
	 * @generated
	 */
	void setCapabilityWasSibServiceIntegrationBusLink(WasSibServiceIntegrationBusLink value);

	/**
	 * Returns the value of the '<em><b>Capability Was SI Bus</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was SI Bus</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was SI Bus</em>' containment reference.
	 * @see #setCapabilityWasSIBus(WasSIBus)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSIBus()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSIBus' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSIBus getCapabilityWasSIBus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSIBus <em>Capability Was SI Bus</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was SI Bus</em>' containment reference.
	 * @see #getCapabilityWasSIBus()
	 * @generated
	 */
	void setCapabilityWasSIBus(WasSIBus value);

	/**
	 * Returns the value of the '<em><b>Capability Was Substitution Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Substitution Variable</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Substitution Variable</em>' containment reference.
	 * @see #setCapabilityWasSubstitutionVariable(WasSubstitutionVariable)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSubstitutionVariable()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSubstitutionVariable' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSubstitutionVariable getCapabilityWasSubstitutionVariable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSubstitutionVariable <em>Capability Was Substitution Variable</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Substitution Variable</em>' containment reference.
	 * @see #getCapabilityWasSubstitutionVariable()
	 * @generated
	 */
	void setCapabilityWasSubstitutionVariable(WasSubstitutionVariable value);

	/**
	 * Returns the value of the '<em><b>Capability Was System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was System</em>' containment reference.
	 * @see #setCapabilityWasSystem(WasSystem)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasSystem getCapabilityWasSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasSystem <em>Capability Was System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was System</em>' containment reference.
	 * @see #getCapabilityWasSystem()
	 * @generated
	 */
	void setCapabilityWasSystem(WasSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Wasv4datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Wasv4datasource</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Wasv4datasource</em>' containment reference.
	 * @see #setCapabilityWasv4datasource(WasV4Datasource)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasv4datasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasv4datasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasV4Datasource getCapabilityWasv4datasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv4datasource <em>Capability Wasv4datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Wasv4datasource</em>' containment reference.
	 * @see #getCapabilityWasv4datasource()
	 * @generated
	 */
	void setCapabilityWasv4datasource(WasV4Datasource value);

	/**
	 * Returns the value of the '<em><b>Capability Wasv5datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Wasv5datasource</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Wasv5datasource</em>' containment reference.
	 * @see #setCapabilityWasv5datasource(WasV5Datasource)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasv5datasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasv5datasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasV5Datasource getCapabilityWasv5datasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5datasource <em>Capability Wasv5datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Wasv5datasource</em>' containment reference.
	 * @see #getCapabilityWasv5datasource()
	 * @generated
	 */
	void setCapabilityWasv5datasource(WasV5Datasource value);

	/**
	 * Returns the value of the '<em><b>Capability Wasv5 DB2 Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Wasv5 DB2 Datasource</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Wasv5 DB2 Datasource</em>' containment reference.
	 * @see #setCapabilityWasv5DB2Datasource(WasV5DB2Datasource)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasv5DB2Datasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasv5DB2Datasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasV5DB2Datasource getCapabilityWasv5DB2Datasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5DB2Datasource <em>Capability Wasv5 DB2 Datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Wasv5 DB2 Datasource</em>' containment reference.
	 * @see #getCapabilityWasv5DB2Datasource()
	 * @generated
	 */
	void setCapabilityWasv5DB2Datasource(WasV5DB2Datasource value);

	/**
	 * Returns the value of the '<em><b>Capability Wasv5 DB2 Zos Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Wasv5 DB2 Zos Datasource</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Wasv5 DB2 Zos Datasource</em>' containment reference.
	 * @see #setCapabilityWasv5DB2ZosDatasource(WasV5DB2ZosDatasource)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasv5DB2ZosDatasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasv5DB2ZosDatasource' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasV5DB2ZosDatasource getCapabilityWasv5DB2ZosDatasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasv5DB2ZosDatasource <em>Capability Wasv5 DB2 Zos Datasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Wasv5 DB2 Zos Datasource</em>' containment reference.
	 * @see #getCapabilityWasv5DB2ZosDatasource()
	 * @generated
	 */
	void setCapabilityWasv5DB2ZosDatasource(WasV5DB2ZosDatasource value);

	/**
	 * Returns the value of the '<em><b>Capability Was Virtual Host</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Virtual Host</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Virtual Host</em>' containment reference.
	 * @see #setCapabilityWasVirtualHost(VirtualHostType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasVirtualHost()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasVirtualHost' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualHostType getCapabilityWasVirtualHost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasVirtualHost <em>Capability Was Virtual Host</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Virtual Host</em>' containment reference.
	 * @see #getCapabilityWasVirtualHost()
	 * @generated
	 */
	void setCapabilityWasVirtualHost(VirtualHostType value);

	/**
	 * Returns the value of the '<em><b>Capability Was Web App Ext</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Web App Ext</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Web App Ext</em>' containment reference.
	 * @see #setCapabilityWasWebAppExt(WasWebAppExt)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasWebAppExt()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasWebAppExt' namespace='##targetNamespace'"
	 * @generated
	 */
	WasWebAppExt getCapabilityWasWebAppExt();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebAppExt <em>Capability Was Web App Ext</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Web App Ext</em>' containment reference.
	 * @see #getCapabilityWasWebAppExt()
	 * @generated
	 */
	void setCapabilityWasWebAppExt(WasWebAppExt value);

	/**
	 * Returns the value of the '<em><b>Capability Was Web Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Web Server</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Web Server</em>' containment reference.
	 * @see #setCapabilityWasWebServer(WasWebServer)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasWebServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasWebServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasWebServer getCapabilityWasWebServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServer <em>Capability Was Web Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Web Server</em>' containment reference.
	 * @see #getCapabilityWasWebServer()
	 * @generated
	 */
	void setCapabilityWasWebServer(WasWebServer value);

	/**
	 * Returns the value of the '<em><b>Capability Was Web Server Management</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Web Server Management</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Web Server Management</em>' containment reference.
	 * @see #setCapabilityWasWebServerManagement(WasWebServerManagement)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasWebServerManagement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasWebServerManagement' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasWebServerManagement getCapabilityWasWebServerManagement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServerManagement <em>Capability Was Web Server Management</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Web Server Management</em>' containment reference.
	 * @see #getCapabilityWasWebServerManagement()
	 * @generated
	 */
	void setCapabilityWasWebServerManagement(WasWebServerManagement value);

	/**
	 * Returns the value of the '<em><b>Capability Was Web Server Plugin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Was Web Server Plugin</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Was Web Server Plugin</em>' containment reference.
	 * @see #setCapabilityWasWebServerPlugin(WasWebServerPlugin)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_CapabilityWasWebServerPlugin()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.wasWebServerPlugin' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WasWebServerPlugin getCapabilityWasWebServerPlugin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getCapabilityWasWebServerPlugin <em>Capability Was Web Server Plugin</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Was Web Server Plugin</em>' containment reference.
	 * @see #getCapabilityWasWebServerPlugin()
	 * @generated
	 */
	void setCapabilityWasWebServerPlugin(WasWebServerPlugin value);

	/**
	 * Returns the value of the '<em><b>Classloader</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classloader</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Classloader</em>' containment reference.
	 * @see #setClassloader(Classloader)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_Classloader()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='classloader' namespace='##targetNamespace'"
	 * @generated
	 */
	Classloader getClassloader();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getClassloader <em>Classloader</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classloader</em>' containment reference.
	 * @see #getClassloader()
	 * @generated
	 */
	void setClassloader(Classloader value);

	/**
	 * Returns the value of the '<em><b>Constraint Was Ear Classloader Policy Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was Ear Classloader Policy Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was Ear Classloader Policy Constraint</em>' containment reference.
	 * @see #setConstraintWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasEarClassloaderPolicyConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasEarClassloaderPolicyConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasEarClassloaderPolicyConstraint getConstraintWasEarClassloaderPolicyConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasEarClassloaderPolicyConstraint <em>Constraint Was Ear Classloader Policy Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was Ear Classloader Policy Constraint</em>' containment reference.
	 * @see #getConstraintWasEarClassloaderPolicyConstraint()
	 * @generated
	 */
	void setConstraintWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was J2EE Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was J2EE Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was J2EE Constraint</em>' containment reference.
	 * @see #setConstraintWasJ2EEConstraint(WasJ2EEConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasJ2EEConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasJ2EEConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasJ2EEConstraint getConstraintWasJ2EEConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasJ2EEConstraint <em>Constraint Was J2EE Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was J2EE Constraint</em>' containment reference.
	 * @see #getConstraintWasJ2EEConstraint()
	 * @generated
	 */
	void setConstraintWasJ2EEConstraint(WasJ2EEConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was JNDI Binding Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				Was JNDI binding constraint, used for binding J2EE
	 * 				capabilities to specific JNDI names on a was server,
	 * 				cluster, cell, or node.
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint Was JNDI Binding Constraint</em>' containment reference.
	 * @see #setConstraintWasJNDIBindingConstraint(WasJNDIBindingConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasJNDIBindingConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasJNDIBindingConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasJNDIBindingConstraint getConstraintWasJNDIBindingConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasJNDIBindingConstraint <em>Constraint Was JNDI Binding Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was JNDI Binding Constraint</em>' containment reference.
	 * @see #getConstraintWasJNDIBindingConstraint()
	 * @generated
	 */
	void setConstraintWasJNDIBindingConstraint(WasJNDIBindingConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was Module Classloader Policy Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was Module Classloader Policy Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was Module Classloader Policy Constraint</em>' containment reference.
	 * @see #setConstraintWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasModuleClassloaderPolicyConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasModuleClassloaderPolicyConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasModuleClassloaderPolicyConstraint getConstraintWasModuleClassloaderPolicyConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasModuleClassloaderPolicyConstraint <em>Constraint Was Module Classloader Policy Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was Module Classloader Policy Constraint</em>' containment reference.
	 * @see #getConstraintWasModuleClassloaderPolicyConstraint()
	 * @generated
	 */
	void setConstraintWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was Module Start Weight Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was Module Start Weight Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was Module Start Weight Constraint</em>' containment reference.
	 * @see #setConstraintWasModuleStartWeightConstraint(WasModuleStartWeightConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasModuleStartWeightConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasModuleStartWeightConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasModuleStartWeightConstraint getConstraintWasModuleStartWeightConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasModuleStartWeightConstraint <em>Constraint Was Module Start Weight Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was Module Start Weight Constraint</em>' containment reference.
	 * @see #getConstraintWasModuleStartWeightConstraint()
	 * @generated
	 */
	void setConstraintWasModuleStartWeightConstraint(WasModuleStartWeightConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was Security Subject Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was Security Subject Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was Security Subject Constraint</em>' containment reference.
	 * @see #setConstraintWasSecuritySubjectConstraint(WasSecuritySubjectConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasSecuritySubjectConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasSecuritySubjectConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasSecuritySubjectConstraint getConstraintWasSecuritySubjectConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasSecuritySubjectConstraint <em>Constraint Was Security Subject Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was Security Subject Constraint</em>' containment reference.
	 * @see #getConstraintWasSecuritySubjectConstraint()
	 * @generated
	 */
	void setConstraintWasSecuritySubjectConstraint(WasSecuritySubjectConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Was War Classloader Policy Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Was War Classloader Policy Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Was War Classloader Policy Constraint</em>' containment reference.
	 * @see #setConstraintWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_ConstraintWasWarClassloaderPolicyConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.wasWarClassloaderPolicyConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	WasWarClassloaderPolicyConstraint getConstraintWasWarClassloaderPolicyConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getConstraintWasWarClassloaderPolicyConstraint <em>Constraint Was War Classloader Policy Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Was War Classloader Policy Constraint</em>' containment reference.
	 * @see #getConstraintWasWarClassloaderPolicyConstraint()
	 * @generated
	 */
	void setConstraintWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint value);

	/**
	 * Returns the value of the '<em><b>Host Name Alias</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host Name Alias</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Host Name Alias</em>' containment reference.
	 * @see #setHostNameAlias(HostNameAliasType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_HostNameAlias()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='hostNameAlias' namespace='##targetNamespace'"
	 * @generated
	 */
	HostNameAliasType getHostNameAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getHostNameAlias <em>Host Name Alias</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Name Alias</em>' containment reference.
	 * @see #getHostNameAlias()
	 * @generated
	 */
	void setHostNameAlias(HostNameAliasType value);

	/**
	 * Returns the value of the '<em><b>Unit Db2 Jdbc Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Db2 Jdbc Provider Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Db2 Jdbc Provider Unit</em>' containment reference.
	 * @see #setUnitDb2JdbcProviderUnit(DB2JdbcProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitDb2JdbcProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.db2JdbcProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2JdbcProviderUnit getUnitDb2JdbcProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitDb2JdbcProviderUnit <em>Unit Db2 Jdbc Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Db2 Jdbc Provider Unit</em>' containment reference.
	 * @see #getUnitDb2JdbcProviderUnit()
	 * @generated
	 */
	void setUnitDb2JdbcProviderUnit(DB2JdbcProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Derby Jdbc Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Derby Jdbc Provider Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Derby Jdbc Provider Unit</em>' containment reference.
	 * @see #setUnitDerbyJdbcProviderUnit(DerbyJdbcProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitDerbyJdbcProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.derbyJdbcProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DerbyJdbcProviderUnit getUnitDerbyJdbcProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitDerbyJdbcProviderUnit <em>Unit Derby Jdbc Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Derby Jdbc Provider Unit</em>' containment reference.
	 * @see #getUnitDerbyJdbcProviderUnit()
	 * @generated
	 */
	void setUnitDerbyJdbcProviderUnit(DerbyJdbcProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Extended Jdbc Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Extended Jdbc Provider Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Extended Jdbc Provider Unit</em>' containment reference.
	 * @see #setUnitExtendedJdbcProviderUnit(ExtendedJdbcProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitExtendedJdbcProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.extendedJdbcProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	ExtendedJdbcProviderUnit getUnitExtendedJdbcProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitExtendedJdbcProviderUnit <em>Unit Extended Jdbc Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Extended Jdbc Provider Unit</em>' containment reference.
	 * @see #getUnitExtendedJdbcProviderUnit()
	 * @generated
	 */
	void setUnitExtendedJdbcProviderUnit(ExtendedJdbcProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was App Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was App Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was App Server</em>' containment reference.
	 * @see #setUnitWasAppServer(WebsphereAppServerUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasAppServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasAppServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WebsphereAppServerUnit getUnitWasAppServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasAppServer <em>Unit Was App Server</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was App Server</em>' containment reference.
	 * @see #getUnitWasAppServer()
	 * @generated
	 */
	void setUnitWasAppServer(WebsphereAppServerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Cell Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Cell Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Was Cell Unit</em>' containment reference.
	 * @see #setUnitWasCellUnit(WasCellUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasCellUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasCellUnit' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasCellUnit getUnitWasCellUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasCellUnit <em>Unit Was Cell Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Cell Unit</em>' containment reference.
	 * @see #getUnitWasCellUnit()
	 * @generated
	 */
	void setUnitWasCellUnit(WasCellUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Class Loader Configuration Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Class Loader Configuration Unit</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Class Loader Configuration Unit</em>' containment reference.
	 * @see #setUnitWasClassLoaderConfigurationUnit(WasClassLoaderConfigurationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasClassLoaderConfigurationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasClassLoaderConfigurationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasClassLoaderConfigurationUnit getUnitWasClassLoaderConfigurationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasClassLoaderConfigurationUnit <em>Unit Was Class Loader Configuration Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Class Loader Configuration Unit</em>' containment reference.
	 * @see #getUnitWasClassLoaderConfigurationUnit()
	 * @generated
	 */
	void setUnitWasClassLoaderConfigurationUnit(WasClassLoaderConfigurationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Cluster Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Cluster Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Cluster Unit</em>' containment reference.
	 * @see #setUnitWasClusterUnit(WasClusterUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasClusterUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasClusterUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasClusterUnit getUnitWasClusterUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasClusterUnit <em>Unit Was Cluster Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Cluster Unit</em>' containment reference.
	 * @see #getUnitWasClusterUnit()
	 * @generated
	 */
	void setUnitWasClusterUnit(WasClusterUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Wasdatasource</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Wasdatasource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Wasdatasource</em>' containment reference.
	 * @see #setUnitWasdatasource(WasDatasourceUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasdatasource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasdatasource'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDatasourceUnit getUnitWasdatasource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasdatasource <em>Unit Wasdatasource</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Wasdatasource</em>' containment reference.
	 * @see #getUnitWasdatasource()
	 * @generated
	 */
	void setUnitWasdatasource(WasDatasourceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Default Messaging Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Default Messaging Connection Factory Unit</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Default Messaging Connection Factory Unit</em>' containment reference.
	 * @see #setUnitWasDefaultMessagingConnectionFactoryUnit(WasDefaultMessagingConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDefaultMessagingConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDefaultMessagingConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDefaultMessagingConnectionFactoryUnit getUnitWasDefaultMessagingConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingConnectionFactoryUnit <em>Unit Was Default Messaging Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Default Messaging Connection Factory Unit</em>' containment reference.
	 * @see #getUnitWasDefaultMessagingConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Default Messaging Queue Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Default Messaging Queue Connection Factory Unit</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Default Messaging Queue Connection Factory Unit</em>' containment reference.
	 * @see #setUnitWasDefaultMessagingQueueConnectionFactoryUnit(WasDefaultMessagingQueueConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDefaultMessagingQueueConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDefaultMessagingQueueConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDefaultMessagingQueueConnectionFactoryUnit getUnitWasDefaultMessagingQueueConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingQueueConnectionFactoryUnit <em>Unit Was Default Messaging Queue Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Default Messaging Queue Connection Factory Unit</em>' containment reference.
	 * @see #getUnitWasDefaultMessagingQueueConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Default Messaging Queue Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Default Messaging Queue Destination Unit</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Default Messaging Queue Destination Unit</em>' containment reference.
	 * @see #setUnitWasDefaultMessagingQueueDestinationUnit(WasDefaultMessagingQueueDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDefaultMessagingQueueDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDefaultMessagingQueueDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDefaultMessagingQueueDestinationUnit getUnitWasDefaultMessagingQueueDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingQueueDestinationUnit <em>Unit Was Default Messaging Queue Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Default Messaging Queue Destination Unit</em>' containment reference.
	 * @see #getUnitWasDefaultMessagingQueueDestinationUnit()
	 * @generated
	 */
	void setUnitWasDefaultMessagingQueueDestinationUnit(WasDefaultMessagingQueueDestinationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Default Messaging Topic Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Default Messaging Topic Connection Factory Unit</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Default Messaging Topic Connection Factory Unit</em>' containment reference.
	 * @see #setUnitWasDefaultMessagingTopicConnectionFactoryUnit(WasDefaultMessagingTopicConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDefaultMessagingTopicConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDefaultMessagingTopicConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDefaultMessagingTopicConnectionFactoryUnit getUnitWasDefaultMessagingTopicConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingTopicConnectionFactoryUnit <em>Unit Was Default Messaging Topic Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Default Messaging Topic Connection Factory Unit</em>' containment reference.
	 * @see #getUnitWasDefaultMessagingTopicConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Default Messaging Topic Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Default Messaging Topic Destination Unit</em>'
	 * containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Default Messaging Topic Destination Unit</em>' containment reference.
	 * @see #setUnitWasDefaultMessagingTopicDestinationUnit(WasDefaultMessagingTopicDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDefaultMessagingTopicDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDefaultMessagingTopicDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDefaultMessagingTopicDestinationUnit getUnitWasDefaultMessagingTopicDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDefaultMessagingTopicDestinationUnit <em>Unit Was Default Messaging Topic Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Default Messaging Topic Destination Unit</em>' containment reference.
	 * @see #getUnitWasDefaultMessagingTopicDestinationUnit()
	 * @generated
	 */
	void setUnitWasDefaultMessagingTopicDestinationUnit(WasDefaultMessagingTopicDestinationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Deployment Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Deployment Manager Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Deployment Manager Unit</em>' containment reference.
	 * @see #setUnitWasDeploymentManagerUnit(WasDeploymentManagerUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasDeploymentManagerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasDeploymentManagerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasDeploymentManagerUnit getUnitWasDeploymentManagerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasDeploymentManagerUnit <em>Unit Was Deployment Manager Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Deployment Manager Unit</em>' containment reference.
	 * @see #getUnitWasDeploymentManagerUnit()
	 * @generated
	 */
	void setUnitWasDeploymentManagerUnit(WasDeploymentManagerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Endpoint Listener Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Endpoint Listener Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Endpoint Listener Unit</em>' containment reference.
	 * @see #setUnitWasEndpointListenerUnit(WasEndpointListenerUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasEndpointListenerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasEndpointListenerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasEndpointListenerUnit getUnitWasEndpointListenerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasEndpointListenerUnit <em>Unit Was Endpoint Listener Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Endpoint Listener Unit</em>' containment reference.
	 * @see #getUnitWasEndpointListenerUnit()
	 * @generated
	 */
	void setUnitWasEndpointListenerUnit(WasEndpointListenerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was J2C Auth</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was J2C Auth</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Was J2C Auth</em>' containment reference.
	 * @see #setUnitWasJ2CAuth(WASJ2CAuthenticationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasJ2CAuth()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasJ2CAuth' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WASJ2CAuthenticationUnit getUnitWasJ2CAuth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasJ2CAuth <em>Unit Was J2C Auth</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was J2C Auth</em>' containment reference.
	 * @see #getUnitWasJ2CAuth()
	 * @generated
	 */
	void setUnitWasJ2CAuth(WASJ2CAuthenticationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was JMS Activation Specification Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was JMS Activation Specification Unit</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was JMS Activation Specification Unit</em>' containment reference.
	 * @see #setUnitWasJMSActivationSpecificationUnit(WasJMSActivationSpecificationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasJMSActivationSpecificationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasJMSActivationSpecificationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasJMSActivationSpecificationUnit getUnitWasJMSActivationSpecificationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasJMSActivationSpecificationUnit <em>Unit Was JMS Activation Specification Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was JMS Activation Specification Unit</em>' containment reference.
	 * @see #getUnitWasJMSActivationSpecificationUnit()
	 * @generated
	 */
	void setUnitWasJMSActivationSpecificationUnit(WasJMSActivationSpecificationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Ldap Configuration Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Ldap Configuration Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Ldap Configuration Unit</em>' containment reference.
	 * @see #setUnitWasLdapConfigurationUnit(WasLdapConfigurationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasLdapConfigurationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasLdapConfigurationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasLdapConfigurationUnit getUnitWasLdapConfigurationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasLdapConfigurationUnit <em>Unit Was Ldap Configuration Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Ldap Configuration Unit</em>' containment reference.
	 * @see #getUnitWasLdapConfigurationUnit()
	 * @generated
	 */
	void setUnitWasLdapConfigurationUnit(WasLdapConfigurationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Messaging Engine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Messaging Engine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Messaging Engine</em>' containment reference.
	 * @see #setUnitWasMessagingEngine(WasMessagingEngineUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasMessagingEngine()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasMessagingEngine' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasMessagingEngineUnit getUnitWasMessagingEngine();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasMessagingEngine <em>Unit Was Messaging Engine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Messaging Engine</em>' containment reference.
	 * @see #getUnitWasMessagingEngine()
	 * @generated
	 */
	void setUnitWasMessagingEngine(WasMessagingEngineUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Node Group Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Node Group Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Node Group Unit</em>' containment reference.
	 * @see #setUnitWasNodeGroupUnit(WasNodeGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasNodeGroupUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasNodeGroupUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasNodeGroupUnit getUnitWasNodeGroupUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeGroupUnit <em>Unit Was Node Group Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Node Group Unit</em>' containment reference.
	 * @see #getUnitWasNodeGroupUnit()
	 * @generated
	 */
	void setUnitWasNodeGroupUnit(WasNodeGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Node Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Node Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Was Node Unit</em>' containment reference.
	 * @see #setUnitWasNodeUnit(WasNodeUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasNodeUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasNodeUnit' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasNodeUnit getUnitWasNodeUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeUnit <em>Unit Was Node Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Node Unit</em>' containment reference.
	 * @see #getUnitWasNodeUnit()
	 * @generated
	 */
	void setUnitWasNodeUnit(WasNodeUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Node Windows Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Node Windows Service Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Node Windows Service Unit</em>' containment reference.
	 * @see #setUnitWasNodeWindowsServiceUnit(WasNodeWindowsServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasNodeWindowsServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasNodeWindowsServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasNodeWindowsServiceUnit getUnitWasNodeWindowsServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasNodeWindowsServiceUnit <em>Unit Was Node Windows Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Node Windows Service Unit</em>' containment reference.
	 * @see #getUnitWasNodeWindowsServiceUnit()
	 * @generated
	 */
	void setUnitWasNodeWindowsServiceUnit(WasNodeWindowsServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Shared Library Entry Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Shared Library Entry Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Shared Library Entry Unit</em>' containment reference.
	 * @see #setUnitWasSharedLibraryEntryUnit(WasSharedLibraryEntryUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSharedLibraryEntryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSharedLibraryEntryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSharedLibraryEntryUnit getUnitWasSharedLibraryEntryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSharedLibraryEntryUnit <em>Unit Was Shared Library Entry Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Shared Library Entry Unit</em>' containment reference.
	 * @see #getUnitWasSharedLibraryEntryUnit()
	 * @generated
	 */
	void setUnitWasSharedLibraryEntryUnit(WasSharedLibraryEntryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Destination Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Destination Unit</em>' containment reference.
	 * @see #setUnitWasSibDestinationUnit(WasSibDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibDestinationUnit getUnitWasSibDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibDestinationUnit <em>Unit Was Sib Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Destination Unit</em>' containment reference.
	 * @see #getUnitWasSibDestinationUnit()
	 * @generated
	 */
	void setUnitWasSibDestinationUnit(WasSibDestinationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Inbound Port Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Inbound Port Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Inbound Port Unit</em>' containment reference.
	 * @see #setUnitWasSibInboundPortUnit(WasSibInboundPortUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibInboundPortUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibInboundPortUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibInboundPortUnit getUnitWasSibInboundPortUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibInboundPortUnit <em>Unit Was Sib Inbound Port Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Inbound Port Unit</em>' containment reference.
	 * @see #getUnitWasSibInboundPortUnit()
	 * @generated
	 */
	void setUnitWasSibInboundPortUnit(WasSibInboundPortUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Inbound Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Inbound Service Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Inbound Service Unit</em>' containment reference.
	 * @see #setUnitWasSibInboundServiceUnit(WasSibInboundServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibInboundServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibInboundServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibInboundServiceUnit getUnitWasSibInboundServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibInboundServiceUnit <em>Unit Was Sib Inbound Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Inbound Service Unit</em>' containment reference.
	 * @see #getUnitWasSibInboundServiceUnit()
	 * @generated
	 */
	void setUnitWasSibInboundServiceUnit(WasSibInboundServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Mediation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Mediation Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Mediation Unit</em>' containment reference.
	 * @see #setUnitWasSibMediationUnit(WasSibMediationUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibMediationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibMediationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibMediationUnit getUnitWasSibMediationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibMediationUnit <em>Unit Was Sib Mediation Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Mediation Unit</em>' containment reference.
	 * @see #getUnitWasSibMediationUnit()
	 * @generated
	 */
	void setUnitWasSibMediationUnit(WasSibMediationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Outbound Port Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Outbound Port Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Outbound Port Unit</em>' containment reference.
	 * @see #setUnitWasSibOutboundPortUnit(WasSibOutboundPortUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibOutboundPortUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibOutboundPortUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibOutboundPortUnit getUnitWasSibOutboundPortUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibOutboundPortUnit <em>Unit Was Sib Outbound Port Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Outbound Port Unit</em>' containment reference.
	 * @see #getUnitWasSibOutboundPortUnit()
	 * @generated
	 */
	void setUnitWasSibOutboundPortUnit(WasSibOutboundPortUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Sib Outbound Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Sib Outbound Service Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Sib Outbound Service Unit</em>' containment reference.
	 * @see #setUnitWasSibOutboundServiceUnit(WasSibOutboundServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSibOutboundServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSibOutboundServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSibOutboundServiceUnit getUnitWasSibOutboundServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSibOutboundServiceUnit <em>Unit Was Sib Outbound Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Sib Outbound Service Unit</em>' containment reference.
	 * @see #getUnitWasSibOutboundServiceUnit()
	 * @generated
	 */
	void setUnitWasSibOutboundServiceUnit(WasSibOutboundServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was SI Bus Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was SI Bus Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was SI Bus Unit</em>' containment reference.
	 * @see #setUnitWasSIBusUnit(WasSIBusUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSIBusUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSIBusUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSIBusUnit getUnitWasSIBusUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSIBusUnit <em>Unit Was SI Bus Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was SI Bus Unit</em>' containment reference.
	 * @see #getUnitWasSIBusUnit()
	 * @generated
	 */
	void setUnitWasSIBusUnit(WasSIBusUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was System Unit</em>' containment reference.
	 * @see #setUnitWasSystemUnit(WasSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasSystemUnit getUnitWasSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasSystemUnit <em>Unit Was System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was System Unit</em>' containment reference.
	 * @see #getUnitWasSystemUnit()
	 * @generated
	 */
	void setUnitWasSystemUnit(WasSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Was Web Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Was Web Server Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Was Web Server Unit</em>' containment reference.
	 * @see #setUnitWasWebServerUnit(WasWebServerUnit)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeployRoot_UnitWasWebServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.wasWebServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WasWebServerUnit getUnitWasWebServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot#getUnitWasWebServerUnit <em>Unit Was Web Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Was Web Server Unit</em>' containment reference.
	 * @see #getUnitWasWebServerUnit()
	 * @generated
	 */
	void setUnitWasWebServerUnit(WasWebServerUnit value);

} // WasDeployRoot
