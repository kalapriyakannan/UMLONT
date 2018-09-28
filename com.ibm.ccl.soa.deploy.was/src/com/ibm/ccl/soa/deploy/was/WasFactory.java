/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage
 * @generated
 */
public interface WasFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WasFactory eINSTANCE = com.ibm.ccl.soa.deploy.was.impl.WasFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Classloader</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Classloader</em>'.
	 * @generated
	 */
	Classloader createClassloader();

	/**
	 * Returns a new object of class '<em>DB2 Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>DB2 Jdbc Provider</em>'.
	 * @generated
	 */
	DB2JdbcProvider createDB2JdbcProvider();

	/**
	 * Returns a new object of class '<em>DB2 Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB2 Jdbc Provider Unit</em>'.
	 * @generated
	 */
	DB2JdbcProviderUnit createDB2JdbcProviderUnit();

	/**
	 * Returns a new object of class '<em>Derby Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Derby Jdbc Provider</em>'.
	 * @generated
	 */
	DerbyJdbcProvider createDerbyJdbcProvider();

	/**
	 * Returns a new object of class '<em>Derby Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derby Jdbc Provider Unit</em>'.
	 * @generated
	 */
	DerbyJdbcProviderUnit createDerbyJdbcProviderUnit();

	/**
	 * Returns a new object of class '<em>Extended Jdbc Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Jdbc Provider</em>'.
	 * @generated
	 */
	ExtendedJdbcProvider createExtendedJdbcProvider();

	/**
	 * Returns a new object of class '<em>Extended Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Jdbc Provider Unit</em>'.
	 * @generated
	 */
	ExtendedJdbcProviderUnit createExtendedJdbcProviderUnit();

	/**
	 * Returns a new object of class '<em>Host Name Alias Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Host Name Alias Type</em>'.
	 * @generated
	 */
	HostNameAliasType createHostNameAliasType();

	/**
	 * Returns a new object of class '<em>Shared Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Library Entry</em>'.
	 * @generated
	 */
	SharedLibraryEntry createSharedLibraryEntry();

	/**
	 * Returns a new object of class '<em>Virtual Host Type</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Virtual Host Type</em>'.
	 * @generated
	 */
	VirtualHostType createVirtualHostType();

	/**
	 * Returns a new object of class '<em>Advanced Ldap Configuration</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Advanced Ldap Configuration</em>'.
	 * @generated
	 */
	WasAdvancedLdapConfiguration createWasAdvancedLdapConfiguration();

	/**
	 * Returns a new object of class '<em>Application Class Loader Policy</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Application Class Loader Policy</em>'.
	 * @generated
	 */
	WasApplicationClassLoaderPolicy createWasApplicationClassLoaderPolicy();

	/**
	 * Returns a new object of class '<em>Application Server Class Loader Policy</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Application Server Class Loader Policy</em>'.
	 * @generated
	 */
	WasApplicationServerClassLoaderPolicy createWasApplicationServerClassLoaderPolicy();

	/**
	 * Returns a new object of class '<em>Application Ext</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Application Ext</em>'.
	 * @generated
	 */
	WasApplicationExt createWasApplicationExt();

	/**
	 * Returns a new object of class '<em>Cell</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Cell</em>'.
	 * @generated
	 */
	WasCell createWasCell();

	/**
	 * Returns a new object of class '<em>Cell Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Cell Unit</em>'.
	 * @generated
	 */
	WasCellUnit createWasCellUnit();

	/**
	 * Returns a new object of class '<em>Class Loader Configuration Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Loader Configuration Unit</em>'.
	 * @generated
	 */
	WasClassLoaderConfigurationUnit createWasClassLoaderConfigurationUnit();

	/**
	 * Returns a new object of class '<em>Class Loader Policy</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Class Loader Policy</em>'.
	 * @generated
	 */
	WasClassLoaderPolicy createWasClassLoaderPolicy();

	/**
	 * Returns a new object of class '<em>Cluster</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Cluster</em>'.
	 * @generated
	 */
	WasCluster createWasCluster();

	/**
	 * Returns a new object of class '<em>Cluster Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Cluster Unit</em>'.
	 * @generated
	 */
	WasClusterUnit createWasClusterUnit();

	/**
	 * Returns a new object of class '<em>Configuration Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Container</em>'.
	 * @generated
	 */
	WasConfigurationContainer createWasConfigurationContainer();

	/**
	 * Returns a new object of class '<em>Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Datasource</em>'.
	 * @generated
	 */
	WasDatasource createWasDatasource();

	/**
	 * Returns a new object of class '<em>Datasource Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Datasource Unit</em>'.
	 * @generated
	 */
	WasDatasourceUnit createWasDatasourceUnit();

	/**
	 * Returns a new object of class '<em>Default Messaging Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Messaging Connection Factory Configuration</em>'.
	 * @generated
	 */
	WasDefaultMessagingConnectionFactoryConfiguration createWasDefaultMessagingConnectionFactoryConfiguration();

	/**
	 * Returns a new object of class '<em>Default Messaging Connection Factory Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Messaging Connection Factory Unit</em>'.
	 * @generated
	 */
	WasDefaultMessagingConnectionFactoryUnit createWasDefaultMessagingConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>Default Messaging Queue Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Messaging Queue Connection Factory Configuration</em>'.
	 * @generated
	 */
	WasDefaultMessagingQueueConnectionFactoryConfiguration createWasDefaultMessagingQueueConnectionFactoryConfiguration();

	/**
	 * Returns a new object of class '<em>Default Messaging Queue Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Messaging Queue Connection Factory Unit</em>'.
	 * @generated
	 */
	WasDefaultMessagingQueueConnectionFactoryUnit createWasDefaultMessagingQueueConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>Default Messaging Queue Destination</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Messaging Queue Destination</em>'.
	 * @generated
	 */
	WasDefaultMessagingQueueDestination createWasDefaultMessagingQueueDestination();

	/**
	 * Returns a new object of class '<em>Default Messaging Queue Destination Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Messaging Queue Destination Unit</em>'.
	 * @generated
	 */
	WasDefaultMessagingQueueDestinationUnit createWasDefaultMessagingQueueDestinationUnit();

	/**
	 * Returns a new object of class '<em>Default Messaging Topic Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Messaging Topic Connection Factory Configuration</em>'.
	 * @generated
	 */
	WasDefaultMessagingTopicConnectionFactoryConfiguration createWasDefaultMessagingTopicConnectionFactoryConfiguration();

	/**
	 * Returns a new object of class '<em>Default Messaging Topic Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Messaging Topic Connection Factory Unit</em>'.
	 * @generated
	 */
	WasDefaultMessagingTopicConnectionFactoryUnit createWasDefaultMessagingTopicConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>Default Messaging Topic Destination</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Messaging Topic Destination</em>'.
	 * @generated
	 */
	WasDefaultMessagingTopicDestination createWasDefaultMessagingTopicDestination();

	/**
	 * Returns a new object of class '<em>Default Messaging Topic Destination Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Messaging Topic Destination Unit</em>'.
	 * @generated
	 */
	WasDefaultMessagingTopicDestinationUnit createWasDefaultMessagingTopicDestinationUnit();

	/**
	 * Returns a new object of class '<em>Deployment Manager</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deployment Manager</em>'.
	 * @generated
	 */
	WasDeploymentManager createWasDeploymentManager();

	/**
	 * Returns a new object of class '<em>Deployment Manager Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Manager Unit</em>'.
	 * @generated
	 */
	WasDeploymentManagerUnit createWasDeploymentManagerUnit();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	WasDeployRoot createWasDeployRoot();

	/**
	 * Returns a new object of class '<em>Ear Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ear Classloader Policy Constraint</em>'.
	 * @generated
	 */
	WasEarClassloaderPolicyConstraint createWasEarClassloaderPolicyConstraint();

	/**
	 * Returns a new object of class '<em>Endpoint Listener Configuration</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Endpoint Listener Configuration</em>'.
	 * @generated
	 */
	WasEndpointListenerConfiguration createWasEndpointListenerConfiguration();

	/**
	 * Returns a new object of class '<em>Endpoint Listener Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endpoint Listener Unit</em>'.
	 * @generated
	 */
	WasEndpointListenerUnit createWasEndpointListenerUnit();

	/**
	 * Returns a new object of class '<em>Handler List</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Handler List</em>'.
	 * @generated
	 */
	WasHandlerList createWasHandlerList();

	/**
	 * Returns a new object of class '<em>WASJ2C Authentication Data Entry</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>WASJ2C Authentication Data Entry</em>'.
	 * @generated
	 */
	WASJ2CAuthenticationDataEntry createWASJ2CAuthenticationDataEntry();

	/**
	 * Returns a new object of class '<em>WASJ2C Authentication Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>WASJ2C Authentication Unit</em>'.
	 * @generated
	 */
	WASJ2CAuthenticationUnit createWASJ2CAuthenticationUnit();

	/**
	 * Returns a new object of class '<em>J2EE Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>J2EE Constraint</em>'.
	 * @generated
	 */
	WasJ2EEConstraint createWasJ2EEConstraint();

	/**
	 * Returns a new object of class '<em>J2EE Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>J2EE Server</em>'.
	 * @generated
	 */
	WasJ2EEServer createWasJ2EEServer();

	/**
	 * Returns a new object of class '<em>JMS Activation Specification</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Activation Specification</em>'.
	 * @generated
	 */
	WasJMSActivationSpecification createWasJMSActivationSpecification();

	/**
	 * Returns a new object of class '<em>JMS Activation Specification Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JMS Activation Specification Unit</em>'.
	 * @generated
	 */
	WasJMSActivationSpecificationUnit createWasJMSActivationSpecificationUnit();

	/**
	 * Returns a new object of class '<em>JNDI Binding Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JNDI Binding Constraint</em>'.
	 * @generated
	 */
	WasJNDIBindingConstraint createWasJNDIBindingConstraint();

	/**
	 * Returns a new object of class '<em>Ldap Configuration</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ldap Configuration</em>'.
	 * @generated
	 */
	WasLdapConfiguration createWasLdapConfiguration();

	/**
	 * Returns a new object of class '<em>Ldap Configuration Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ldap Configuration Unit</em>'.
	 * @generated
	 */
	WasLdapConfigurationUnit createWasLdapConfigurationUnit();

	/**
	 * Returns a new object of class '<em>Messaging Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Messaging Engine</em>'.
	 * @generated
	 */
	WasMessagingEngine createWasMessagingEngine();

	/**
	 * Returns a new object of class '<em>Messaging Engine Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Messaging Engine Unit</em>'.
	 * @generated
	 */
	WasMessagingEngineUnit createWasMessagingEngineUnit();

	/**
	 * Returns a new object of class '<em>Module Class Loader Policy</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Class Loader Policy</em>'.
	 * @generated
	 */
	WasModuleClassLoaderPolicy createWasModuleClassLoaderPolicy();

	/**
	 * Returns a new object of class '<em>Module Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Classloader Policy Constraint</em>'.
	 * @generated
	 */
	WasModuleClassloaderPolicyConstraint createWasModuleClassloaderPolicyConstraint();

	/**
	 * Returns a new object of class '<em>Module Start Weight Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Start Weight Constraint</em>'.
	 * @generated
	 */
	WasModuleStartWeightConstraint createWasModuleStartWeightConstraint();

	/**
	 * Returns a new object of class '<em>Node</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	WasNode createWasNode();

	/**
	 * Returns a new object of class '<em>Node Group</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Node Group</em>'.
	 * @generated
	 */
	WasNodeGroup createWasNodeGroup();

	/**
	 * Returns a new object of class '<em>Node Group Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Node Group Unit</em>'.
	 * @generated
	 */
	WasNodeGroupUnit createWasNodeGroupUnit();

	/**
	 * Returns a new object of class '<em>Node Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Node Unit</em>'.
	 * @generated
	 */
	WasNodeUnit createWasNodeUnit();

	/**
	 * Returns a new object of class '<em>Node Windows Service Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Windows Service Unit</em>'.
	 * @generated
	 */
	WasNodeWindowsServiceUnit createWasNodeWindowsServiceUnit();

	/**
	 * Returns a new object of class '<em>Plugin Admin</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Plugin Admin</em>'.
	 * @generated
	 */
	WasPluginAdmin createWasPluginAdmin();

	/**
	 * Returns a new object of class '<em>Plugin Redirection</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Plugin Redirection</em>'.
	 * @generated
	 */
	WasPluginRedirection createWasPluginRedirection();

	/**
	 * Returns a new object of class '<em>Security</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Security</em>'.
	 * @generated
	 */
	WasSecurity createWasSecurity();

	/**
	 * Returns a new object of class '<em>Security Subject</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Security Subject</em>'.
	 * @generated
	 */
	WasSecuritySubject createWasSecuritySubject();

	/**
	 * Returns a new object of class '<em>Security Subject Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Subject Constraint</em>'.
	 * @generated
	 */
	WasSecuritySubjectConstraint createWasSecuritySubjectConstraint();

	/**
	 * Returns a new object of class '<em>Server</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	WasServer createWasServer();

	/**
	 * Returns a new object of class '<em>Shared Lib Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Lib Container</em>'.
	 * @generated
	 */
	WasSharedLibContainer createWasSharedLibContainer();

	/**
	 * Returns a new object of class '<em>Shared Library Entry Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Library Entry Unit</em>'.
	 * @generated
	 */
	WasSharedLibraryEntryUnit createWasSharedLibraryEntryUnit();

	/**
	 * Returns a new object of class '<em>Sib Destination</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Destination</em>'.
	 * @generated
	 */
	WasSibDestination createWasSibDestination();

	/**
	 * Returns a new object of class '<em>Sib Destination Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Destination Unit</em>'.
	 * @generated
	 */
	WasSibDestinationUnit createWasSibDestinationUnit();

	/**
	 * Returns a new object of class '<em>Sib Foreign Bus</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Foreign Bus</em>'.
	 * @generated
	 */
	WasSibForeignBus createWasSibForeignBus();

	/**
	 * Returns a new object of class '<em>Sib Inbound Port</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Inbound Port</em>'.
	 * @generated
	 */
	WasSibInboundPort createWasSibInboundPort();

	/**
	 * Returns a new object of class '<em>Sib Inbound Port Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Inbound Port Unit</em>'.
	 * @generated
	 */
	WasSibInboundPortUnit createWasSibInboundPortUnit();

	/**
	 * Returns a new object of class '<em>Sib Inbound Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Inbound Service</em>'.
	 * @generated
	 */
	WasSibInboundService createWasSibInboundService();

	/**
	 * Returns a new object of class '<em>Sib Inbound Service Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Inbound Service Unit</em>'.
	 * @generated
	 */
	WasSibInboundServiceUnit createWasSibInboundServiceUnit();

	/**
	 * Returns a new object of class '<em>Sib Mediation</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Mediation</em>'.
	 * @generated
	 */
	WasSibMediation createWasSibMediation();

	/**
	 * Returns a new object of class '<em>Sib Mediation Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Mediation Unit</em>'.
	 * @generated
	 */
	WasSibMediationUnit createWasSibMediationUnit();

	/**
	 * Returns a new object of class '<em>Sib Outbound Port</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Sib Outbound Port</em>'.
	 * @generated
	 */
	WasSibOutboundPort createWasSibOutboundPort();

	/**
	 * Returns a new object of class '<em>Sib Outbound Port Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Outbound Port Unit</em>'.
	 * @generated
	 */
	WasSibOutboundPortUnit createWasSibOutboundPortUnit();

	/**
	 * Returns a new object of class '<em>Sib Outbound Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Outbound Service</em>'.
	 * @generated
	 */
	WasSibOutboundService createWasSibOutboundService();

	/**
	 * Returns a new object of class '<em>Sib Outbound Service Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Sib Outbound Service Unit</em>'.
	 * @generated
	 */
	WasSibOutboundServiceUnit createWasSibOutboundServiceUnit();

	/**
	 * Returns a new object of class '<em>Sib Service Integration Bus Link</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sib Service Integration Bus Link</em>'.
	 * @generated
	 */
	WasSibServiceIntegrationBusLink createWasSibServiceIntegrationBusLink();

	/**
	 * Returns a new object of class '<em>SI Bus</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>SI Bus</em>'.
	 * @generated
	 */
	WasSIBus createWasSIBus();

	/**
	 * Returns a new object of class '<em>SI Bus Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>SI Bus Unit</em>'.
	 * @generated
	 */
	WasSIBusUnit createWasSIBusUnit();

	/**
	 * Returns a new object of class '<em>Substitution Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substitution Variable</em>'.
	 * @generated
	 */
	WasSubstitutionVariable createWasSubstitutionVariable();

	/**
	 * Returns a new object of class '<em>System</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	WasSystem createWasSystem();

	/**
	 * Returns a new object of class '<em>System Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>System Unit</em>'.
	 * @generated
	 */
	WasSystemUnit createWasSystemUnit();

	/**
	 * Returns a new object of class '<em>V4 Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>V4 Datasource</em>'.
	 * @generated
	 */
	WasV4Datasource createWasV4Datasource();

	/**
	 * Returns a new object of class '<em>V5 Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>V5 Datasource</em>'.
	 * @generated
	 */
	WasV5Datasource createWasV5Datasource();

	/**
	 * Returns a new object of class '<em>V5DB2 Datasource</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>V5DB2 Datasource</em>'.
	 * @generated
	 */
	WasV5DB2Datasource createWasV5DB2Datasource();

	/**
	 * Returns a new object of class '<em>V5DB2 Zos Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>V5DB2 Zos Datasource</em>'.
	 * @generated
	 */
	WasV5DB2ZosDatasource createWasV5DB2ZosDatasource();

	/**
	 * Returns a new object of class '<em>War Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>War Classloader Policy Constraint</em>'.
	 * @generated
	 */
	WasWarClassloaderPolicyConstraint createWasWarClassloaderPolicyConstraint();

	/**
	 * Returns a new object of class '<em>Web App Ext</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web App Ext</em>'.
	 * @generated
	 */
	WasWebAppExt createWasWebAppExt();

	/**
	 * Returns a new object of class '<em>Web Server</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Server</em>'.
	 * @generated
	 */
	WasWebServer createWasWebServer();

	/**
	 * Returns a new object of class '<em>Web Server Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Server Management</em>'.
	 * @generated
	 */
	WasWebServerManagement createWasWebServerManagement();

	/**
	 * Returns a new object of class '<em>Web Server Plugin</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Server Plugin</em>'.
	 * @generated
	 */
	WasWebServerPlugin createWasWebServerPlugin();

	/**
	 * Returns a new object of class '<em>Web Server Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Web Server Unit</em>'.
	 * @generated
	 */
	WasWebServerUnit createWasWebServerUnit();

	/**
	 * Returns a new object of class '<em>Websphere App Server Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Websphere App Server Unit</em>'.
	 * @generated
	 */
	WebsphereAppServerUnit createWebsphereAppServerUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WasPackage getWasPackage();

} //WasFactory
