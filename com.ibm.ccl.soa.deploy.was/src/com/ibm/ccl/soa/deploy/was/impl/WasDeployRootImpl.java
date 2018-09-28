/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.was.Classloader;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.ExtendedJdbcProvider;
import com.ibm.ccl.soa.deploy.was.ExtendedJdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.HostNameAliasType;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.VirtualHostType;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasApplicationExt;
import com.ibm.ccl.soa.deploy.was.WasApplicationServerClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClassLoaderConfigurationUnit;
import com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasDeployRoot;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManager;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasHandlerList;
import com.ibm.ccl.soa.deploy.was.WasJ2EEConstraint;
import com.ibm.ccl.soa.deploy.was.WasJ2EEServer;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasLdapConfigurationUnit;
import com.ibm.ccl.soa.deploy.was.WasMessagingEngine;
import com.ibm.ccl.soa.deploy.was.WasMessagingEngineUnit;
import com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasModuleClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasPluginAdmin;
import com.ibm.ccl.soa.deploy.was.WasPluginRedirection;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubject;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibForeignBus;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibInboundService;
import com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasSibMediation;
import com.ibm.ccl.soa.deploy.was.WasSibMediationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit;
import com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasV4Datasource;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;
import com.ibm.ccl.soa.deploy.was.WasV5DB2ZosDatasource;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasWebAppExt;
import com.ibm.ccl.soa.deploy.was.WasWebServer;
import com.ibm.ccl.soa.deploy.was.WasWebServerManagement;
import com.ibm.ccl.soa.deploy.was.WasWebServerPlugin;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityDb2JdbcProvider <em>Capability Db2 Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityDerbyJdbcProvider <em>Capability Derby Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityExtendedJdbcProvider <em>Capability Extended Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasAdvancedLdapConfiguration <em>Capability Was Advanced Ldap Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasApplicationClassLoaderPolicy <em>Capability Was Application Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasApplicationExt <em>Capability Was Application Ext</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasApplicationServerClassLoaderPolicy <em>Capability Was Application Server Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasCell <em>Capability Was Cell</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasClassLoaderPolicy <em>Capability Was Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasCluster <em>Capability Was Cluster</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasConfigurationContainer <em>Capability Was Configuration Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDatasource <em>Capability Was Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDefaultMessagingConnectionFactoryConfiguration <em>Capability Was Default Messaging Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration <em>Capability Was Default Messaging Queue Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDefaultMessagingQueueDestination <em>Capability Was Default Messaging Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration <em>Capability Was Default Messaging Topic Connection Factory Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDefaultMessagingTopicDestination <em>Capability Was Default Messaging Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasDeploymentManager <em>Capability Was Deployment Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasEndpointListenerConfiguration <em>Capability Was Endpoint Listener Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasHandlerList <em>Capability Was Handler List</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasJ2CAuth <em>Capability Was J2C Auth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasJ2EEServer <em>Capability Was J2EE Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasJMSActivationSpecification <em>Capability Was JMS Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasLdapConfiguration <em>Capability Was Ldap Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasMessagingEngine <em>Capability Was Messaging Engine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasModuleClassLoaderPolicy <em>Capability Was Module Class Loader Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasNode <em>Capability Was Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasNodeGroup <em>Capability Was Node Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasPluginAdmin <em>Capability Was Plugin Admin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasPluginRedirection <em>Capability Was Plugin Redirection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSecurity <em>Capability Was Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSecuritySubject <em>Capability Was Security Subject</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasServer <em>Capability Was Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSharedLibContainer <em>Capability Was Shared Lib Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSharedLibrary <em>Capability Was Shared Library</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibDestination <em>Capability Was Sib Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibForeignBus <em>Capability Was Sib Foreign Bus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibInboundPort <em>Capability Was Sib Inbound Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibInboundService <em>Capability Was Sib Inbound Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibMediation <em>Capability Was Sib Mediation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibOutboundPort <em>Capability Was Sib Outbound Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibOutboundService <em>Capability Was Sib Outbound Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSibServiceIntegrationBusLink <em>Capability Was Sib Service Integration Bus Link</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSIBus <em>Capability Was SI Bus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSubstitutionVariable <em>Capability Was Substitution Variable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasSystem <em>Capability Was System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasv4datasource <em>Capability Wasv4datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasv5datasource <em>Capability Wasv5datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasv5DB2Datasource <em>Capability Wasv5 DB2 Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasv5DB2ZosDatasource <em>Capability Wasv5 DB2 Zos Datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasVirtualHost <em>Capability Was Virtual Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasWebAppExt <em>Capability Was Web App Ext</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasWebServer <em>Capability Was Web Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasWebServerManagement <em>Capability Was Web Server Management</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getCapabilityWasWebServerPlugin <em>Capability Was Web Server Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getClassloader <em>Classloader</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasEarClassloaderPolicyConstraint <em>Constraint Was Ear Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasJ2EEConstraint <em>Constraint Was J2EE Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasJNDIBindingConstraint <em>Constraint Was JNDI Binding Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasModuleClassloaderPolicyConstraint <em>Constraint Was Module Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasModuleStartWeightConstraint <em>Constraint Was Module Start Weight Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasSecuritySubjectConstraint <em>Constraint Was Security Subject Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getConstraintWasWarClassloaderPolicyConstraint <em>Constraint Was War Classloader Policy Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getHostNameAlias <em>Host Name Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitDb2JdbcProviderUnit <em>Unit Db2 Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitDerbyJdbcProviderUnit <em>Unit Derby Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitExtendedJdbcProviderUnit <em>Unit Extended Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasAppServer <em>Unit Was App Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasCellUnit <em>Unit Was Cell Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasClassLoaderConfigurationUnit <em>Unit Was Class Loader Configuration Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasClusterUnit <em>Unit Was Cluster Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasdatasource <em>Unit Wasdatasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDefaultMessagingConnectionFactoryUnit <em>Unit Was Default Messaging Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDefaultMessagingQueueConnectionFactoryUnit <em>Unit Was Default Messaging Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDefaultMessagingQueueDestinationUnit <em>Unit Was Default Messaging Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDefaultMessagingTopicConnectionFactoryUnit <em>Unit Was Default Messaging Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDefaultMessagingTopicDestinationUnit <em>Unit Was Default Messaging Topic Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasDeploymentManagerUnit <em>Unit Was Deployment Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasEndpointListenerUnit <em>Unit Was Endpoint Listener Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasJ2CAuth <em>Unit Was J2C Auth</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasJMSActivationSpecificationUnit <em>Unit Was JMS Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasLdapConfigurationUnit <em>Unit Was Ldap Configuration Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasMessagingEngine <em>Unit Was Messaging Engine</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasNodeGroupUnit <em>Unit Was Node Group Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasNodeUnit <em>Unit Was Node Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasNodeWindowsServiceUnit <em>Unit Was Node Windows Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSharedLibraryEntryUnit <em>Unit Was Shared Library Entry Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibDestinationUnit <em>Unit Was Sib Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibInboundPortUnit <em>Unit Was Sib Inbound Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibInboundServiceUnit <em>Unit Was Sib Inbound Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibMediationUnit <em>Unit Was Sib Mediation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibOutboundPortUnit <em>Unit Was Sib Outbound Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSibOutboundServiceUnit <em>Unit Was Sib Outbound Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSIBusUnit <em>Unit Was SI Bus Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasSystemUnit <em>Unit Was System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDeployRootImpl#getUnitWasWebServerUnit <em>Unit Was Web Server Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasDeployRootImpl extends EObjectImpl implements WasDeployRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, WasPackage.WAS_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProvider getCapabilityDb2JdbcProvider() {
		return (DB2JdbcProvider)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDb2JdbcProvider(
			DB2JdbcProvider newCapabilityDb2JdbcProvider, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER, newCapabilityDb2JdbcProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDb2JdbcProvider(DB2JdbcProvider newCapabilityDb2JdbcProvider) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER, newCapabilityDb2JdbcProvider);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProvider getCapabilityDerbyJdbcProvider() {
		return (DerbyJdbcProvider)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDerbyJdbcProvider(
			DerbyJdbcProvider newCapabilityDerbyJdbcProvider, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER, newCapabilityDerbyJdbcProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDerbyJdbcProvider(DerbyJdbcProvider newCapabilityDerbyJdbcProvider) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER, newCapabilityDerbyJdbcProvider);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedJdbcProvider getCapabilityExtendedJdbcProvider() {
		return (ExtendedJdbcProvider)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityExtendedJdbcProvider(
			ExtendedJdbcProvider newCapabilityExtendedJdbcProvider, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER, newCapabilityExtendedJdbcProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityExtendedJdbcProvider(
			ExtendedJdbcProvider newCapabilityExtendedJdbcProvider) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER, newCapabilityExtendedJdbcProvider);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasAdvancedLdapConfiguration getCapabilityWasAdvancedLdapConfiguration() {
		return (WasAdvancedLdapConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasAdvancedLdapConfiguration(
			WasAdvancedLdapConfiguration newCapabilityWasAdvancedLdapConfiguration,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION, newCapabilityWasAdvancedLdapConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasAdvancedLdapConfiguration(
			WasAdvancedLdapConfiguration newCapabilityWasAdvancedLdapConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION, newCapabilityWasAdvancedLdapConfiguration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationClassLoaderPolicy getCapabilityWasApplicationClassLoaderPolicy() {
		return (WasApplicationClassLoaderPolicy)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasApplicationClassLoaderPolicy(
			WasApplicationClassLoaderPolicy newCapabilityWasApplicationClassLoaderPolicy,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY, newCapabilityWasApplicationClassLoaderPolicy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasApplicationClassLoaderPolicy(
			WasApplicationClassLoaderPolicy newCapabilityWasApplicationClassLoaderPolicy) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY, newCapabilityWasApplicationClassLoaderPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationExt getCapabilityWasApplicationExt() {
		return (WasApplicationExt)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasApplicationExt(
			WasApplicationExt newCapabilityWasApplicationExt, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT, newCapabilityWasApplicationExt, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasApplicationExt(WasApplicationExt newCapabilityWasApplicationExt) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT, newCapabilityWasApplicationExt);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationServerClassLoaderPolicy getCapabilityWasApplicationServerClassLoaderPolicy() {
		return (WasApplicationServerClassLoaderPolicy)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasApplicationServerClassLoaderPolicy(
			WasApplicationServerClassLoaderPolicy newCapabilityWasApplicationServerClassLoaderPolicy,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY, newCapabilityWasApplicationServerClassLoaderPolicy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasApplicationServerClassLoaderPolicy(
			WasApplicationServerClassLoaderPolicy newCapabilityWasApplicationServerClassLoaderPolicy) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY, newCapabilityWasApplicationServerClassLoaderPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCell getCapabilityWasCell() {
		return (WasCell)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasCell(WasCell newCapabilityWasCell,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL, newCapabilityWasCell, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasCell(WasCell newCapabilityWasCell) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL, newCapabilityWasCell);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClassLoaderPolicy getCapabilityWasClassLoaderPolicy() {
		return (WasClassLoaderPolicy)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasClassLoaderPolicy(
			WasClassLoaderPolicy newCapabilityWasClassLoaderPolicy, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY, newCapabilityWasClassLoaderPolicy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasClassLoaderPolicy(
			WasClassLoaderPolicy newCapabilityWasClassLoaderPolicy) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY, newCapabilityWasClassLoaderPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCluster getCapabilityWasCluster() {
		return (WasCluster)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasCluster(WasCluster newCapabilityWasCluster,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER, newCapabilityWasCluster, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasCluster(WasCluster newCapabilityWasCluster) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER, newCapabilityWasCluster);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasConfigurationContainer getCapabilityWasConfigurationContainer() {
		return (WasConfigurationContainer)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasConfigurationContainer(
			WasConfigurationContainer newCapabilityWasConfigurationContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER, newCapabilityWasConfigurationContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasConfigurationContainer(
			WasConfigurationContainer newCapabilityWasConfigurationContainer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER, newCapabilityWasConfigurationContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDatasource getCapabilityWasDatasource() {
		return (WasDatasource)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDatasource(
			WasDatasource newCapabilityWasDatasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE, newCapabilityWasDatasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDatasource(WasDatasource newCapabilityWasDatasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE, newCapabilityWasDatasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingConnectionFactoryConfiguration getCapabilityWasDefaultMessagingConnectionFactoryConfiguration() {
		return (WasDefaultMessagingConnectionFactoryConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration newCapabilityWasDefaultMessagingConnectionFactoryConfiguration,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingConnectionFactoryConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration newCapabilityWasDefaultMessagingConnectionFactoryConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingConnectionFactoryConfiguration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueConnectionFactoryConfiguration getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration() {
		return (WasDefaultMessagingQueueConnectionFactoryConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration newCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration newCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueDestination getCapabilityWasDefaultMessagingQueueDestination() {
		return (WasDefaultMessagingQueueDestination)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDefaultMessagingQueueDestination(
			WasDefaultMessagingQueueDestination newCapabilityWasDefaultMessagingQueueDestination,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION, newCapabilityWasDefaultMessagingQueueDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDefaultMessagingQueueDestination(
			WasDefaultMessagingQueueDestination newCapabilityWasDefaultMessagingQueueDestination) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION, newCapabilityWasDefaultMessagingQueueDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicConnectionFactoryConfiguration getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration() {
		return (WasDefaultMessagingTopicConnectionFactoryConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration newCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration newCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION, newCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicDestination getCapabilityWasDefaultMessagingTopicDestination() {
		return (WasDefaultMessagingTopicDestination)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDefaultMessagingTopicDestination(
			WasDefaultMessagingTopicDestination newCapabilityWasDefaultMessagingTopicDestination,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION, newCapabilityWasDefaultMessagingTopicDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDefaultMessagingTopicDestination(
			WasDefaultMessagingTopicDestination newCapabilityWasDefaultMessagingTopicDestination) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION, newCapabilityWasDefaultMessagingTopicDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManager getCapabilityWasDeploymentManager() {
		return (WasDeploymentManager)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasDeploymentManager(
			WasDeploymentManager newCapabilityWasDeploymentManager, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER, newCapabilityWasDeploymentManager, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasDeploymentManager(
			WasDeploymentManager newCapabilityWasDeploymentManager) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER, newCapabilityWasDeploymentManager);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerConfiguration getCapabilityWasEndpointListenerConfiguration() {
		return (WasEndpointListenerConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasEndpointListenerConfiguration(
			WasEndpointListenerConfiguration newCapabilityWasEndpointListenerConfiguration,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION, newCapabilityWasEndpointListenerConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasEndpointListenerConfiguration(
			WasEndpointListenerConfiguration newCapabilityWasEndpointListenerConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION, newCapabilityWasEndpointListenerConfiguration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasHandlerList getCapabilityWasHandlerList() {
		return (WasHandlerList)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasHandlerList(
			WasHandlerList newCapabilityWasHandlerList, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST, newCapabilityWasHandlerList, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasHandlerList(WasHandlerList newCapabilityWasHandlerList) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST, newCapabilityWasHandlerList);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WASJ2CAuthenticationDataEntry getCapabilityWasJ2CAuth() {
		return (WASJ2CAuthenticationDataEntry)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasJ2CAuth(
			WASJ2CAuthenticationDataEntry newCapabilityWasJ2CAuth, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH, newCapabilityWasJ2CAuth, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasJ2CAuth(WASJ2CAuthenticationDataEntry newCapabilityWasJ2CAuth) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH, newCapabilityWasJ2CAuth);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJ2EEServer getCapabilityWasJ2EEServer() {
		return (WasJ2EEServer)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasJ2EEServer(
			WasJ2EEServer newCapabilityWasJ2EEServer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER, newCapabilityWasJ2EEServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasJ2EEServer(WasJ2EEServer newCapabilityWasJ2EEServer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER, newCapabilityWasJ2EEServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJMSActivationSpecification getCapabilityWasJMSActivationSpecification() {
		return (WasJMSActivationSpecification)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasJMSActivationSpecification(
			WasJMSActivationSpecification newCapabilityWasJMSActivationSpecification,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION, newCapabilityWasJMSActivationSpecification, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasJMSActivationSpecification(
			WasJMSActivationSpecification newCapabilityWasJMSActivationSpecification) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION, newCapabilityWasJMSActivationSpecification);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasLdapConfiguration getCapabilityWasLdapConfiguration() {
		return (WasLdapConfiguration)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasLdapConfiguration(
			WasLdapConfiguration newCapabilityWasLdapConfiguration, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION, newCapabilityWasLdapConfiguration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasLdapConfiguration(
			WasLdapConfiguration newCapabilityWasLdapConfiguration) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION, newCapabilityWasLdapConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasMessagingEngine getCapabilityWasMessagingEngine() {
		return (WasMessagingEngine)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasMessagingEngine(WasMessagingEngine newCapabilityWasMessagingEngine, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE, newCapabilityWasMessagingEngine, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasMessagingEngine(WasMessagingEngine newCapabilityWasMessagingEngine) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE, newCapabilityWasMessagingEngine);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleClassLoaderPolicy getCapabilityWasModuleClassLoaderPolicy() {
		return (WasModuleClassLoaderPolicy)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasModuleClassLoaderPolicy(
			WasModuleClassLoaderPolicy newCapabilityWasModuleClassLoaderPolicy, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY, newCapabilityWasModuleClassLoaderPolicy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasModuleClassLoaderPolicy(
			WasModuleClassLoaderPolicy newCapabilityWasModuleClassLoaderPolicy) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY, newCapabilityWasModuleClassLoaderPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNode getCapabilityWasNode() {
		return (WasNode)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasNode(WasNode newCapabilityWasNode,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE, newCapabilityWasNode, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasNode(WasNode newCapabilityWasNode) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE, newCapabilityWasNode);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroup getCapabilityWasNodeGroup() {
		return (WasNodeGroup)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasNodeGroup(WasNodeGroup newCapabilityWasNodeGroup,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP, newCapabilityWasNodeGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasNodeGroup(WasNodeGroup newCapabilityWasNodeGroup) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP, newCapabilityWasNodeGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasPluginAdmin getCapabilityWasPluginAdmin() {
		return (WasPluginAdmin)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasPluginAdmin(
			WasPluginAdmin newCapabilityWasPluginAdmin, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN, newCapabilityWasPluginAdmin, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasPluginAdmin(WasPluginAdmin newCapabilityWasPluginAdmin) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN, newCapabilityWasPluginAdmin);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasPluginRedirection getCapabilityWasPluginRedirection() {
		return (WasPluginRedirection)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasPluginRedirection(
			WasPluginRedirection newCapabilityWasPluginRedirection, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION, newCapabilityWasPluginRedirection, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasPluginRedirection(
			WasPluginRedirection newCapabilityWasPluginRedirection) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION, newCapabilityWasPluginRedirection);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecurity getCapabilityWasSecurity() {
		return (WasSecurity)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSecurity(WasSecurity newCapabilityWasSecurity,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY, newCapabilityWasSecurity, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSecurity(WasSecurity newCapabilityWasSecurity) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY, newCapabilityWasSecurity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecuritySubject getCapabilityWasSecuritySubject() {
		return (WasSecuritySubject)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSecuritySubject(
			WasSecuritySubject newCapabilityWasSecuritySubject, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT, newCapabilityWasSecuritySubject, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSecuritySubject(WasSecuritySubject newCapabilityWasSecuritySubject) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT, newCapabilityWasSecuritySubject);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasServer getCapabilityWasServer() {
		return (WasServer)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasServer(WasServer newCapabilityWasServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER, newCapabilityWasServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasServer(WasServer newCapabilityWasServer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER, newCapabilityWasServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSharedLibContainer getCapabilityWasSharedLibContainer() {
		return (WasSharedLibContainer)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSharedLibContainer(
			WasSharedLibContainer newCapabilityWasSharedLibContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER, newCapabilityWasSharedLibContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSharedLibContainer(
			WasSharedLibContainer newCapabilityWasSharedLibContainer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER, newCapabilityWasSharedLibContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SharedLibraryEntry getCapabilityWasSharedLibrary() {
		return (SharedLibraryEntry)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSharedLibrary(
			SharedLibraryEntry newCapabilityWasSharedLibrary, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY, newCapabilityWasSharedLibrary, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSharedLibrary(SharedLibraryEntry newCapabilityWasSharedLibrary) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY, newCapabilityWasSharedLibrary);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestination getCapabilityWasSibDestination() {
		return (WasSibDestination)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibDestination(
			WasSibDestination newCapabilityWasSibDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION, newCapabilityWasSibDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibDestination(WasSibDestination newCapabilityWasSibDestination) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION, newCapabilityWasSibDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibForeignBus getCapabilityWasSibForeignBus() {
		return (WasSibForeignBus)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibForeignBus(
			WasSibForeignBus newCapabilityWasSibForeignBus, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS, newCapabilityWasSibForeignBus, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibForeignBus(WasSibForeignBus newCapabilityWasSibForeignBus) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS, newCapabilityWasSibForeignBus);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundPort getCapabilityWasSibInboundPort() {
		return (WasSibInboundPort)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibInboundPort(
			WasSibInboundPort newCapabilityWasSibInboundPort, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT, newCapabilityWasSibInboundPort, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibInboundPort(WasSibInboundPort newCapabilityWasSibInboundPort) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT, newCapabilityWasSibInboundPort);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundService getCapabilityWasSibInboundService() {
		return (WasSibInboundService)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibInboundService(
			WasSibInboundService newCapabilityWasSibInboundService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE, newCapabilityWasSibInboundService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibInboundService(
			WasSibInboundService newCapabilityWasSibInboundService) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE, newCapabilityWasSibInboundService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibMediation getCapabilityWasSibMediation() {
		return (WasSibMediation)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibMediation(
			WasSibMediation newCapabilityWasSibMediation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION, newCapabilityWasSibMediation, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibMediation(WasSibMediation newCapabilityWasSibMediation) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION, newCapabilityWasSibMediation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundPort getCapabilityWasSibOutboundPort() {
		return (WasSibOutboundPort)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibOutboundPort(
			WasSibOutboundPort newCapabilityWasSibOutboundPort, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT, newCapabilityWasSibOutboundPort, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibOutboundPort(WasSibOutboundPort newCapabilityWasSibOutboundPort) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT, newCapabilityWasSibOutboundPort);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundService getCapabilityWasSibOutboundService() {
		return (WasSibOutboundService)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibOutboundService(
			WasSibOutboundService newCapabilityWasSibOutboundService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE, newCapabilityWasSibOutboundService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibOutboundService(
			WasSibOutboundService newCapabilityWasSibOutboundService) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE, newCapabilityWasSibOutboundService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibServiceIntegrationBusLink getCapabilityWasSibServiceIntegrationBusLink() {
		return (WasSibServiceIntegrationBusLink)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSibServiceIntegrationBusLink(
			WasSibServiceIntegrationBusLink newCapabilityWasSibServiceIntegrationBusLink,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK, newCapabilityWasSibServiceIntegrationBusLink, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSibServiceIntegrationBusLink(
			WasSibServiceIntegrationBusLink newCapabilityWasSibServiceIntegrationBusLink) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK, newCapabilityWasSibServiceIntegrationBusLink);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSIBus getCapabilityWasSIBus() {
		return (WasSIBus)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSIBus(WasSIBus newCapabilityWasSIBus,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS, newCapabilityWasSIBus, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSIBus(WasSIBus newCapabilityWasSIBus) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS, newCapabilityWasSIBus);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSubstitutionVariable getCapabilityWasSubstitutionVariable() {
		return (WasSubstitutionVariable)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSubstitutionVariable(
			WasSubstitutionVariable newCapabilityWasSubstitutionVariable, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE, newCapabilityWasSubstitutionVariable, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSubstitutionVariable(
			WasSubstitutionVariable newCapabilityWasSubstitutionVariable) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE, newCapabilityWasSubstitutionVariable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSystem getCapabilityWasSystem() {
		return (WasSystem)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasSystem(WasSystem newCapabilityWasSystem,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM, newCapabilityWasSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasSystem(WasSystem newCapabilityWasSystem) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM, newCapabilityWasSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV4Datasource getCapabilityWasv4datasource() {
		return (WasV4Datasource)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasv4datasource(
			WasV4Datasource newCapabilityWasv4datasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE, newCapabilityWasv4datasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasv4datasource(WasV4Datasource newCapabilityWasv4datasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE, newCapabilityWasv4datasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5Datasource getCapabilityWasv5datasource() {
		return (WasV5Datasource)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasv5datasource(
			WasV5Datasource newCapabilityWasv5datasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE, newCapabilityWasv5datasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasv5datasource(WasV5Datasource newCapabilityWasv5datasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE, newCapabilityWasv5datasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5DB2Datasource getCapabilityWasv5DB2Datasource() {
		return (WasV5DB2Datasource)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasv5DB2Datasource(
			WasV5DB2Datasource newCapabilityWasv5DB2Datasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE, newCapabilityWasv5DB2Datasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasv5DB2Datasource(WasV5DB2Datasource newCapabilityWasv5DB2Datasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE, newCapabilityWasv5DB2Datasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5DB2ZosDatasource getCapabilityWasv5DB2ZosDatasource() {
		return (WasV5DB2ZosDatasource)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasv5DB2ZosDatasource(
			WasV5DB2ZosDatasource newCapabilityWasv5DB2ZosDatasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE, newCapabilityWasv5DB2ZosDatasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasv5DB2ZosDatasource(
			WasV5DB2ZosDatasource newCapabilityWasv5DB2ZosDatasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE, newCapabilityWasv5DB2ZosDatasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualHostType getCapabilityWasVirtualHost() {
		return (VirtualHostType)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasVirtualHost(
			VirtualHostType newCapabilityWasVirtualHost, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST, newCapabilityWasVirtualHost, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasVirtualHost(VirtualHostType newCapabilityWasVirtualHost) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST, newCapabilityWasVirtualHost);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebAppExt getCapabilityWasWebAppExt() {
		return (WasWebAppExt)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasWebAppExt(WasWebAppExt newCapabilityWasWebAppExt,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT, newCapabilityWasWebAppExt, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasWebAppExt(WasWebAppExt newCapabilityWasWebAppExt) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT, newCapabilityWasWebAppExt);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServer getCapabilityWasWebServer() {
		return (WasWebServer)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasWebServer(WasWebServer newCapabilityWasWebServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER, newCapabilityWasWebServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasWebServer(WasWebServer newCapabilityWasWebServer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER, newCapabilityWasWebServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerManagement getCapabilityWasWebServerManagement() {
		return (WasWebServerManagement)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasWebServerManagement(
			WasWebServerManagement newCapabilityWasWebServerManagement, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT, newCapabilityWasWebServerManagement, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasWebServerManagement(
			WasWebServerManagement newCapabilityWasWebServerManagement) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT, newCapabilityWasWebServerManagement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerPlugin getCapabilityWasWebServerPlugin() {
		return (WasWebServerPlugin)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityWasWebServerPlugin(
			WasWebServerPlugin newCapabilityWasWebServerPlugin, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN, newCapabilityWasWebServerPlugin, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityWasWebServerPlugin(WasWebServerPlugin newCapabilityWasWebServerPlugin) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN, newCapabilityWasWebServerPlugin);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Classloader getClassloader() {
		return (Classloader)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CLASSLOADER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassloader(Classloader newClassloader, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CLASSLOADER, newClassloader, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassloader(Classloader newClassloader) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CLASSLOADER, newClassloader);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasEarClassloaderPolicyConstraint getConstraintWasEarClassloaderPolicyConstraint() {
		return (WasEarClassloaderPolicyConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint newConstraintWasEarClassloaderPolicyConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasEarClassloaderPolicyConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint newConstraintWasEarClassloaderPolicyConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasEarClassloaderPolicyConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasJ2EEConstraint getConstraintWasJ2EEConstraint() {
		return (WasJ2EEConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasJ2EEConstraint(WasJ2EEConstraint newConstraintWasJ2EEConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT, newConstraintWasJ2EEConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasJ2EEConstraint(WasJ2EEConstraint newConstraintWasJ2EEConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT, newConstraintWasJ2EEConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasJNDIBindingConstraint getConstraintWasJNDIBindingConstraint() {
		return (WasJNDIBindingConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasJNDIBindingConstraint(WasJNDIBindingConstraint newConstraintWasJNDIBindingConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT, newConstraintWasJNDIBindingConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasJNDIBindingConstraint(WasJNDIBindingConstraint newConstraintWasJNDIBindingConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT, newConstraintWasJNDIBindingConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleClassloaderPolicyConstraint getConstraintWasModuleClassloaderPolicyConstraint() {
		return (WasModuleClassloaderPolicyConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint newConstraintWasModuleClassloaderPolicyConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasModuleClassloaderPolicyConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint newConstraintWasModuleClassloaderPolicyConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasModuleClassloaderPolicyConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleStartWeightConstraint getConstraintWasModuleStartWeightConstraint() {
		return (WasModuleStartWeightConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasModuleStartWeightConstraint(WasModuleStartWeightConstraint newConstraintWasModuleStartWeightConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT, newConstraintWasModuleStartWeightConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasModuleStartWeightConstraint(WasModuleStartWeightConstraint newConstraintWasModuleStartWeightConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT, newConstraintWasModuleStartWeightConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecuritySubjectConstraint getConstraintWasSecuritySubjectConstraint() {
		return (WasSecuritySubjectConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasSecuritySubjectConstraint(WasSecuritySubjectConstraint newConstraintWasSecuritySubjectConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT, newConstraintWasSecuritySubjectConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasSecuritySubjectConstraint(WasSecuritySubjectConstraint newConstraintWasSecuritySubjectConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT, newConstraintWasSecuritySubjectConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasWarClassloaderPolicyConstraint getConstraintWasWarClassloaderPolicyConstraint() {
		return (WasWarClassloaderPolicyConstraint)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint newConstraintWasWarClassloaderPolicyConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasWarClassloaderPolicyConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint newConstraintWasWarClassloaderPolicyConstraint) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT, newConstraintWasWarClassloaderPolicyConstraint);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HostNameAliasType getHostNameAlias() {
		return (HostNameAliasType)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHostNameAlias(HostNameAliasType newHostNameAlias,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS, newHostNameAlias, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostNameAlias(HostNameAliasType newHostNameAlias) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS, newHostNameAlias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProviderUnit getUnitDb2JdbcProviderUnit() {
		return (DB2JdbcProviderUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDb2JdbcProviderUnit(
			DB2JdbcProviderUnit newUnitDb2JdbcProviderUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT, newUnitDb2JdbcProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDb2JdbcProviderUnit(DB2JdbcProviderUnit newUnitDb2JdbcProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT, newUnitDb2JdbcProviderUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProviderUnit getUnitDerbyJdbcProviderUnit() {
		return (DerbyJdbcProviderUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDerbyJdbcProviderUnit(
			DerbyJdbcProviderUnit newUnitDerbyJdbcProviderUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT, newUnitDerbyJdbcProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDerbyJdbcProviderUnit(DerbyJdbcProviderUnit newUnitDerbyJdbcProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT, newUnitDerbyJdbcProviderUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedJdbcProviderUnit getUnitExtendedJdbcProviderUnit() {
		return (ExtendedJdbcProviderUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitExtendedJdbcProviderUnit(
			ExtendedJdbcProviderUnit newUnitExtendedJdbcProviderUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT, newUnitExtendedJdbcProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitExtendedJdbcProviderUnit(
			ExtendedJdbcProviderUnit newUnitExtendedJdbcProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT, newUnitExtendedJdbcProviderUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebsphereAppServerUnit getUnitWasAppServer() {
		return (WebsphereAppServerUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasAppServer(WebsphereAppServerUnit newUnitWasAppServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER, newUnitWasAppServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasAppServer(WebsphereAppServerUnit newUnitWasAppServer) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER, newUnitWasAppServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCellUnit getUnitWasCellUnit() {
		return (WasCellUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasCellUnit(WasCellUnit newUnitWasCellUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT, newUnitWasCellUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasCellUnit(WasCellUnit newUnitWasCellUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT, newUnitWasCellUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClassLoaderConfigurationUnit getUnitWasClassLoaderConfigurationUnit() {
		return (WasClassLoaderConfigurationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasClassLoaderConfigurationUnit(
			WasClassLoaderConfigurationUnit newUnitWasClassLoaderConfigurationUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT, newUnitWasClassLoaderConfigurationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasClassLoaderConfigurationUnit(
			WasClassLoaderConfigurationUnit newUnitWasClassLoaderConfigurationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT, newUnitWasClassLoaderConfigurationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClusterUnit getUnitWasClusterUnit() {
		return (WasClusterUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasClusterUnit(WasClusterUnit newUnitWasClusterUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT, newUnitWasClusterUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasClusterUnit(WasClusterUnit newUnitWasClusterUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT, newUnitWasClusterUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDatasourceUnit getUnitWasdatasource() {
		return (WasDatasourceUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasdatasource(WasDatasourceUnit newUnitWasdatasource,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE, newUnitWasdatasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasdatasource(WasDatasourceUnit newUnitWasdatasource) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE, newUnitWasdatasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingConnectionFactoryUnit getUnitWasDefaultMessagingConnectionFactoryUnit() {
		return (WasDefaultMessagingConnectionFactoryUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit newUnitWasDefaultMessagingConnectionFactoryUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit newUnitWasDefaultMessagingConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueConnectionFactoryUnit getUnitWasDefaultMessagingQueueConnectionFactoryUnit() {
		return (WasDefaultMessagingQueueConnectionFactoryUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit newUnitWasDefaultMessagingQueueConnectionFactoryUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingQueueConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit newUnitWasDefaultMessagingQueueConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingQueueConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueDestinationUnit getUnitWasDefaultMessagingQueueDestinationUnit() {
		return (WasDefaultMessagingQueueDestinationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDefaultMessagingQueueDestinationUnit(
			WasDefaultMessagingQueueDestinationUnit newUnitWasDefaultMessagingQueueDestinationUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT, newUnitWasDefaultMessagingQueueDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDefaultMessagingQueueDestinationUnit(
			WasDefaultMessagingQueueDestinationUnit newUnitWasDefaultMessagingQueueDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT, newUnitWasDefaultMessagingQueueDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicConnectionFactoryUnit getUnitWasDefaultMessagingTopicConnectionFactoryUnit() {
		return (WasDefaultMessagingTopicConnectionFactoryUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit newUnitWasDefaultMessagingTopicConnectionFactoryUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingTopicConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit newUnitWasDefaultMessagingTopicConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT, newUnitWasDefaultMessagingTopicConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicDestinationUnit getUnitWasDefaultMessagingTopicDestinationUnit() {
		return (WasDefaultMessagingTopicDestinationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDefaultMessagingTopicDestinationUnit(
			WasDefaultMessagingTopicDestinationUnit newUnitWasDefaultMessagingTopicDestinationUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT, newUnitWasDefaultMessagingTopicDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDefaultMessagingTopicDestinationUnit(
			WasDefaultMessagingTopicDestinationUnit newUnitWasDefaultMessagingTopicDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT, newUnitWasDefaultMessagingTopicDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManagerUnit getUnitWasDeploymentManagerUnit() {
		return (WasDeploymentManagerUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasDeploymentManagerUnit(
			WasDeploymentManagerUnit newUnitWasDeploymentManagerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT, newUnitWasDeploymentManagerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasDeploymentManagerUnit(
			WasDeploymentManagerUnit newUnitWasDeploymentManagerUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT, newUnitWasDeploymentManagerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerUnit getUnitWasEndpointListenerUnit() {
		return (WasEndpointListenerUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasEndpointListenerUnit(
			WasEndpointListenerUnit newUnitWasEndpointListenerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT, newUnitWasEndpointListenerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasEndpointListenerUnit(WasEndpointListenerUnit newUnitWasEndpointListenerUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT, newUnitWasEndpointListenerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WASJ2CAuthenticationUnit getUnitWasJ2CAuth() {
		return (WASJ2CAuthenticationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasJ2CAuth(WASJ2CAuthenticationUnit newUnitWasJ2CAuth,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH, newUnitWasJ2CAuth, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasJ2CAuth(WASJ2CAuthenticationUnit newUnitWasJ2CAuth) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH, newUnitWasJ2CAuth);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJMSActivationSpecificationUnit getUnitWasJMSActivationSpecificationUnit() {
		return (WasJMSActivationSpecificationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasJMSActivationSpecificationUnit(
			WasJMSActivationSpecificationUnit newUnitWasJMSActivationSpecificationUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT, newUnitWasJMSActivationSpecificationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasJMSActivationSpecificationUnit(
			WasJMSActivationSpecificationUnit newUnitWasJMSActivationSpecificationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT, newUnitWasJMSActivationSpecificationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasLdapConfigurationUnit getUnitWasLdapConfigurationUnit() {
		return (WasLdapConfigurationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasLdapConfigurationUnit(
			WasLdapConfigurationUnit newUnitWasLdapConfigurationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT, newUnitWasLdapConfigurationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasLdapConfigurationUnit(
			WasLdapConfigurationUnit newUnitWasLdapConfigurationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT, newUnitWasLdapConfigurationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasMessagingEngineUnit getUnitWasMessagingEngine() {
		return (WasMessagingEngineUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasMessagingEngine(WasMessagingEngineUnit newUnitWasMessagingEngine, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE, newUnitWasMessagingEngine, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasMessagingEngine(WasMessagingEngineUnit newUnitWasMessagingEngine) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE, newUnitWasMessagingEngine);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroupUnit getUnitWasNodeGroupUnit() {
		return (WasNodeGroupUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasNodeGroupUnit(WasNodeGroupUnit newUnitWasNodeGroupUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT, newUnitWasNodeGroupUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasNodeGroupUnit(WasNodeGroupUnit newUnitWasNodeGroupUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT, newUnitWasNodeGroupUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeUnit getUnitWasNodeUnit() {
		return (WasNodeUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasNodeUnit(WasNodeUnit newUnitWasNodeUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT, newUnitWasNodeUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasNodeUnit(WasNodeUnit newUnitWasNodeUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT, newUnitWasNodeUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeWindowsServiceUnit getUnitWasNodeWindowsServiceUnit() {
		return (WasNodeWindowsServiceUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasNodeWindowsServiceUnit(
			WasNodeWindowsServiceUnit newUnitWasNodeWindowsServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT, newUnitWasNodeWindowsServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasNodeWindowsServiceUnit(
			WasNodeWindowsServiceUnit newUnitWasNodeWindowsServiceUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT, newUnitWasNodeWindowsServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSharedLibraryEntryUnit getUnitWasSharedLibraryEntryUnit() {
		return (WasSharedLibraryEntryUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSharedLibraryEntryUnit(
			WasSharedLibraryEntryUnit newUnitWasSharedLibraryEntryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT, newUnitWasSharedLibraryEntryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSharedLibraryEntryUnit(
			WasSharedLibraryEntryUnit newUnitWasSharedLibraryEntryUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT, newUnitWasSharedLibraryEntryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestinationUnit getUnitWasSibDestinationUnit() {
		return (WasSibDestinationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibDestinationUnit(
			WasSibDestinationUnit newUnitWasSibDestinationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT, newUnitWasSibDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibDestinationUnit(WasSibDestinationUnit newUnitWasSibDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT, newUnitWasSibDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundPortUnit getUnitWasSibInboundPortUnit() {
		return (WasSibInboundPortUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibInboundPortUnit(
			WasSibInboundPortUnit newUnitWasSibInboundPortUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT, newUnitWasSibInboundPortUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibInboundPortUnit(WasSibInboundPortUnit newUnitWasSibInboundPortUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT, newUnitWasSibInboundPortUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundServiceUnit getUnitWasSibInboundServiceUnit() {
		return (WasSibInboundServiceUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibInboundServiceUnit(
			WasSibInboundServiceUnit newUnitWasSibInboundServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT, newUnitWasSibInboundServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibInboundServiceUnit(
			WasSibInboundServiceUnit newUnitWasSibInboundServiceUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT, newUnitWasSibInboundServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibMediationUnit getUnitWasSibMediationUnit() {
		return (WasSibMediationUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibMediationUnit(
			WasSibMediationUnit newUnitWasSibMediationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT, newUnitWasSibMediationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibMediationUnit(WasSibMediationUnit newUnitWasSibMediationUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT, newUnitWasSibMediationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundPortUnit getUnitWasSibOutboundPortUnit() {
		return (WasSibOutboundPortUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibOutboundPortUnit(
			WasSibOutboundPortUnit newUnitWasSibOutboundPortUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT, newUnitWasSibOutboundPortUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibOutboundPortUnit(WasSibOutboundPortUnit newUnitWasSibOutboundPortUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT, newUnitWasSibOutboundPortUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundServiceUnit getUnitWasSibOutboundServiceUnit() {
		return (WasSibOutboundServiceUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSibOutboundServiceUnit(
			WasSibOutboundServiceUnit newUnitWasSibOutboundServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT, newUnitWasSibOutboundServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSibOutboundServiceUnit(
			WasSibOutboundServiceUnit newUnitWasSibOutboundServiceUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT, newUnitWasSibOutboundServiceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSIBusUnit getUnitWasSIBusUnit() {
		return (WasSIBusUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSIBusUnit(WasSIBusUnit newUnitWasSIBusUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT, newUnitWasSIBusUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSIBusUnit(WasSIBusUnit newUnitWasSIBusUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT, newUnitWasSIBusUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSystemUnit getUnitWasSystemUnit() {
		return (WasSystemUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasSystemUnit(WasSystemUnit newUnitWasSystemUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT, newUnitWasSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasSystemUnit(WasSystemUnit newUnitWasSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT, newUnitWasSystemUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerUnit getUnitWasWebServerUnit() {
		return (WasWebServerUnit)getMixed().get(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitWasWebServerUnit(WasWebServerUnit newUnitWasWebServerUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT, newUnitWasWebServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitWasWebServerUnit(WasWebServerUnit newUnitWasWebServerUnit) {
		((FeatureMap.Internal)getMixed()).set(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT, newUnitWasWebServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER:
				return basicSetCapabilityDb2JdbcProvider(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER:
				return basicSetCapabilityDerbyJdbcProvider(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER:
				return basicSetCapabilityExtendedJdbcProvider(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION:
				return basicSetCapabilityWasAdvancedLdapConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY:
				return basicSetCapabilityWasApplicationClassLoaderPolicy(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT:
				return basicSetCapabilityWasApplicationExt(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY:
				return basicSetCapabilityWasApplicationServerClassLoaderPolicy(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL:
				return basicSetCapabilityWasCell(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY:
				return basicSetCapabilityWasClassLoaderPolicy(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER:
				return basicSetCapabilityWasCluster(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER:
				return basicSetCapabilityWasConfigurationContainer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE:
				return basicSetCapabilityWasDatasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
				return basicSetCapabilityWasDefaultMessagingConnectionFactoryConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
				return basicSetCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
				return basicSetCapabilityWasDefaultMessagingQueueDestination(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
				return basicSetCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
				return basicSetCapabilityWasDefaultMessagingTopicDestination(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER:
				return basicSetCapabilityWasDeploymentManager(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION:
				return basicSetCapabilityWasEndpointListenerConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST:
				return basicSetCapabilityWasHandlerList(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH:
				return basicSetCapabilityWasJ2CAuth(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER:
				return basicSetCapabilityWasJ2EEServer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION:
				return basicSetCapabilityWasJMSActivationSpecification(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION:
				return basicSetCapabilityWasLdapConfiguration(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
				return basicSetCapabilityWasMessagingEngine(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY:
				return basicSetCapabilityWasModuleClassLoaderPolicy(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE:
				return basicSetCapabilityWasNode(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP:
				return basicSetCapabilityWasNodeGroup(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN:
				return basicSetCapabilityWasPluginAdmin(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION:
				return basicSetCapabilityWasPluginRedirection(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY:
				return basicSetCapabilityWasSecurity(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT:
				return basicSetCapabilityWasSecuritySubject(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER:
				return basicSetCapabilityWasServer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER:
				return basicSetCapabilityWasSharedLibContainer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY:
				return basicSetCapabilityWasSharedLibrary(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION:
				return basicSetCapabilityWasSibDestination(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS:
				return basicSetCapabilityWasSibForeignBus(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT:
				return basicSetCapabilityWasSibInboundPort(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE:
				return basicSetCapabilityWasSibInboundService(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION:
				return basicSetCapabilityWasSibMediation(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT:
				return basicSetCapabilityWasSibOutboundPort(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE:
				return basicSetCapabilityWasSibOutboundService(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
				return basicSetCapabilityWasSibServiceIntegrationBusLink(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS:
				return basicSetCapabilityWasSIBus(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE:
				return basicSetCapabilityWasSubstitutionVariable(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM:
				return basicSetCapabilityWasSystem(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE:
				return basicSetCapabilityWasv4datasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE:
				return basicSetCapabilityWasv5datasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE:
				return basicSetCapabilityWasv5DB2Datasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE:
				return basicSetCapabilityWasv5DB2ZosDatasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST:
				return basicSetCapabilityWasVirtualHost(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT:
				return basicSetCapabilityWasWebAppExt(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER:
				return basicSetCapabilityWasWebServer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT:
				return basicSetCapabilityWasWebServerManagement(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN:
				return basicSetCapabilityWasWebServerPlugin(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CLASSLOADER:
				return basicSetClassloader(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
				return basicSetConstraintWasEarClassloaderPolicyConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
				return basicSetConstraintWasJ2EEConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
				return basicSetConstraintWasJNDIBindingConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
				return basicSetConstraintWasModuleClassloaderPolicyConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
				return basicSetConstraintWasModuleStartWeightConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
				return basicSetConstraintWasSecuritySubjectConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
				return basicSetConstraintWasWarClassloaderPolicyConstraint(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS:
				return basicSetHostNameAlias(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT:
				return basicSetUnitDb2JdbcProviderUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT:
				return basicSetUnitDerbyJdbcProviderUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT:
				return basicSetUnitExtendedJdbcProviderUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER:
				return basicSetUnitWasAppServer(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT:
				return basicSetUnitWasCellUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT:
				return basicSetUnitWasClassLoaderConfigurationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT:
				return basicSetUnitWasClusterUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE:
				return basicSetUnitWasdatasource(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
				return basicSetUnitWasDefaultMessagingConnectionFactoryUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
				return basicSetUnitWasDefaultMessagingQueueConnectionFactoryUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
				return basicSetUnitWasDefaultMessagingQueueDestinationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
				return basicSetUnitWasDefaultMessagingTopicConnectionFactoryUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
				return basicSetUnitWasDefaultMessagingTopicDestinationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT:
				return basicSetUnitWasDeploymentManagerUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT:
				return basicSetUnitWasEndpointListenerUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH:
				return basicSetUnitWasJ2CAuth(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return basicSetUnitWasJMSActivationSpecificationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT:
				return basicSetUnitWasLdapConfigurationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				return basicSetUnitWasMessagingEngine(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT:
				return basicSetUnitWasNodeGroupUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT:
				return basicSetUnitWasNodeUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT:
				return basicSetUnitWasNodeWindowsServiceUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT:
				return basicSetUnitWasSharedLibraryEntryUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT:
				return basicSetUnitWasSibDestinationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT:
				return basicSetUnitWasSibInboundPortUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT:
				return basicSetUnitWasSibInboundServiceUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT:
				return basicSetUnitWasSibMediationUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT:
				return basicSetUnitWasSibOutboundPortUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT:
				return basicSetUnitWasSibOutboundServiceUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT:
				return basicSetUnitWasSIBusUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT:
				return basicSetUnitWasSystemUnit(null, msgs);
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT:
				return basicSetUnitWasWebServerUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER:
				return getCapabilityDb2JdbcProvider();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER:
				return getCapabilityDerbyJdbcProvider();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER:
				return getCapabilityExtendedJdbcProvider();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION:
				return getCapabilityWasAdvancedLdapConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY:
				return getCapabilityWasApplicationClassLoaderPolicy();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT:
				return getCapabilityWasApplicationExt();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY:
				return getCapabilityWasApplicationServerClassLoaderPolicy();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL:
				return getCapabilityWasCell();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY:
				return getCapabilityWasClassLoaderPolicy();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER:
				return getCapabilityWasCluster();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER:
				return getCapabilityWasConfigurationContainer();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE:
				return getCapabilityWasDatasource();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingConnectionFactoryConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
				return getCapabilityWasDefaultMessagingQueueDestination();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
				return getCapabilityWasDefaultMessagingTopicDestination();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER:
				return getCapabilityWasDeploymentManager();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION:
				return getCapabilityWasEndpointListenerConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST:
				return getCapabilityWasHandlerList();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH:
				return getCapabilityWasJ2CAuth();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER:
				return getCapabilityWasJ2EEServer();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION:
				return getCapabilityWasJMSActivationSpecification();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION:
				return getCapabilityWasLdapConfiguration();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
				return getCapabilityWasMessagingEngine();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY:
				return getCapabilityWasModuleClassLoaderPolicy();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE:
				return getCapabilityWasNode();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP:
				return getCapabilityWasNodeGroup();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN:
				return getCapabilityWasPluginAdmin();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION:
				return getCapabilityWasPluginRedirection();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY:
				return getCapabilityWasSecurity();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT:
				return getCapabilityWasSecuritySubject();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER:
				return getCapabilityWasServer();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER:
				return getCapabilityWasSharedLibContainer();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY:
				return getCapabilityWasSharedLibrary();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION:
				return getCapabilityWasSibDestination();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS:
				return getCapabilityWasSibForeignBus();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT:
				return getCapabilityWasSibInboundPort();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE:
				return getCapabilityWasSibInboundService();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION:
				return getCapabilityWasSibMediation();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT:
				return getCapabilityWasSibOutboundPort();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE:
				return getCapabilityWasSibOutboundService();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
				return getCapabilityWasSibServiceIntegrationBusLink();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS:
				return getCapabilityWasSIBus();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE:
				return getCapabilityWasSubstitutionVariable();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM:
				return getCapabilityWasSystem();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE:
				return getCapabilityWasv4datasource();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE:
				return getCapabilityWasv5datasource();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE:
				return getCapabilityWasv5DB2Datasource();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE:
				return getCapabilityWasv5DB2ZosDatasource();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST:
				return getCapabilityWasVirtualHost();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT:
				return getCapabilityWasWebAppExt();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER:
				return getCapabilityWasWebServer();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT:
				return getCapabilityWasWebServerManagement();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN:
				return getCapabilityWasWebServerPlugin();
			case WasPackage.WAS_DEPLOY_ROOT__CLASSLOADER:
				return getClassloader();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasEarClassloaderPolicyConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
				return getConstraintWasJ2EEConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
				return getConstraintWasJNDIBindingConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasModuleClassloaderPolicyConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
				return getConstraintWasModuleStartWeightConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
				return getConstraintWasSecuritySubjectConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasWarClassloaderPolicyConstraint();
			case WasPackage.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS:
				return getHostNameAlias();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT:
				return getUnitDb2JdbcProviderUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT:
				return getUnitDerbyJdbcProviderUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT:
				return getUnitExtendedJdbcProviderUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER:
				return getUnitWasAppServer();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT:
				return getUnitWasCellUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT:
				return getUnitWasClassLoaderConfigurationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT:
				return getUnitWasClusterUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE:
				return getUnitWasdatasource();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingConnectionFactoryUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingQueueConnectionFactoryUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
				return getUnitWasDefaultMessagingQueueDestinationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingTopicConnectionFactoryUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
				return getUnitWasDefaultMessagingTopicDestinationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT:
				return getUnitWasDeploymentManagerUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT:
				return getUnitWasEndpointListenerUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH:
				return getUnitWasJ2CAuth();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitWasJMSActivationSpecificationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT:
				return getUnitWasLdapConfigurationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				return getUnitWasMessagingEngine();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT:
				return getUnitWasNodeGroupUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT:
				return getUnitWasNodeUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT:
				return getUnitWasNodeWindowsServiceUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT:
				return getUnitWasSharedLibraryEntryUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT:
				return getUnitWasSibDestinationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT:
				return getUnitWasSibInboundPortUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT:
				return getUnitWasSibInboundServiceUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT:
				return getUnitWasSibMediationUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT:
				return getUnitWasSibOutboundPortUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT:
				return getUnitWasSibOutboundServiceUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT:
				return getUnitWasSIBusUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT:
				return getUnitWasSystemUnit();
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT:
				return getUnitWasWebServerUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER:
				setCapabilityDb2JdbcProvider((DB2JdbcProvider)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER:
				setCapabilityDerbyJdbcProvider((DerbyJdbcProvider)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER:
				setCapabilityExtendedJdbcProvider((ExtendedJdbcProvider)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION:
				setCapabilityWasAdvancedLdapConfiguration((WasAdvancedLdapConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY:
				setCapabilityWasApplicationClassLoaderPolicy((WasApplicationClassLoaderPolicy)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT:
				setCapabilityWasApplicationExt((WasApplicationExt)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY:
				setCapabilityWasApplicationServerClassLoaderPolicy((WasApplicationServerClassLoaderPolicy)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL:
				setCapabilityWasCell((WasCell)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY:
				setCapabilityWasClassLoaderPolicy((WasClassLoaderPolicy)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER:
				setCapabilityWasCluster((WasCluster)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER:
				setCapabilityWasConfigurationContainer((WasConfigurationContainer)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE:
				setCapabilityWasDatasource((WasDatasource)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingConnectionFactoryConfiguration((WasDefaultMessagingConnectionFactoryConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration((WasDefaultMessagingQueueConnectionFactoryConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
				setCapabilityWasDefaultMessagingQueueDestination((WasDefaultMessagingQueueDestination)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration((WasDefaultMessagingTopicConnectionFactoryConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
				setCapabilityWasDefaultMessagingTopicDestination((WasDefaultMessagingTopicDestination)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER:
				setCapabilityWasDeploymentManager((WasDeploymentManager)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION:
				setCapabilityWasEndpointListenerConfiguration((WasEndpointListenerConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST:
				setCapabilityWasHandlerList((WasHandlerList)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH:
				setCapabilityWasJ2CAuth((WASJ2CAuthenticationDataEntry)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER:
				setCapabilityWasJ2EEServer((WasJ2EEServer)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION:
				setCapabilityWasJMSActivationSpecification((WasJMSActivationSpecification)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION:
				setCapabilityWasLdapConfiguration((WasLdapConfiguration)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
				setCapabilityWasMessagingEngine((WasMessagingEngine)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY:
				setCapabilityWasModuleClassLoaderPolicy((WasModuleClassLoaderPolicy)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE:
				setCapabilityWasNode((WasNode)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP:
				setCapabilityWasNodeGroup((WasNodeGroup)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN:
				setCapabilityWasPluginAdmin((WasPluginAdmin)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION:
				setCapabilityWasPluginRedirection((WasPluginRedirection)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY:
				setCapabilityWasSecurity((WasSecurity)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT:
				setCapabilityWasSecuritySubject((WasSecuritySubject)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER:
				setCapabilityWasServer((WasServer)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER:
				setCapabilityWasSharedLibContainer((WasSharedLibContainer)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY:
				setCapabilityWasSharedLibrary((SharedLibraryEntry)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION:
				setCapabilityWasSibDestination((WasSibDestination)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS:
				setCapabilityWasSibForeignBus((WasSibForeignBus)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT:
				setCapabilityWasSibInboundPort((WasSibInboundPort)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE:
				setCapabilityWasSibInboundService((WasSibInboundService)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION:
				setCapabilityWasSibMediation((WasSibMediation)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT:
				setCapabilityWasSibOutboundPort((WasSibOutboundPort)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE:
				setCapabilityWasSibOutboundService((WasSibOutboundService)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
				setCapabilityWasSibServiceIntegrationBusLink((WasSibServiceIntegrationBusLink)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS:
				setCapabilityWasSIBus((WasSIBus)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE:
				setCapabilityWasSubstitutionVariable((WasSubstitutionVariable)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM:
				setCapabilityWasSystem((WasSystem)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE:
				setCapabilityWasv4datasource((WasV4Datasource)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE:
				setCapabilityWasv5datasource((WasV5Datasource)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE:
				setCapabilityWasv5DB2Datasource((WasV5DB2Datasource)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE:
				setCapabilityWasv5DB2ZosDatasource((WasV5DB2ZosDatasource)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST:
				setCapabilityWasVirtualHost((VirtualHostType)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT:
				setCapabilityWasWebAppExt((WasWebAppExt)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER:
				setCapabilityWasWebServer((WasWebServer)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT:
				setCapabilityWasWebServerManagement((WasWebServerManagement)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN:
				setCapabilityWasWebServerPlugin((WasWebServerPlugin)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CLASSLOADER:
				setClassloader((Classloader)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasEarClassloaderPolicyConstraint((WasEarClassloaderPolicyConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
				setConstraintWasJ2EEConstraint((WasJ2EEConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
				setConstraintWasJNDIBindingConstraint((WasJNDIBindingConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasModuleClassloaderPolicyConstraint((WasModuleClassloaderPolicyConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
				setConstraintWasModuleStartWeightConstraint((WasModuleStartWeightConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
				setConstraintWasSecuritySubjectConstraint((WasSecuritySubjectConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasWarClassloaderPolicyConstraint((WasWarClassloaderPolicyConstraint)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS:
				setHostNameAlias((HostNameAliasType)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT:
				setUnitDb2JdbcProviderUnit((DB2JdbcProviderUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT:
				setUnitDerbyJdbcProviderUnit((DerbyJdbcProviderUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT:
				setUnitExtendedJdbcProviderUnit((ExtendedJdbcProviderUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER:
				setUnitWasAppServer((WebsphereAppServerUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT:
				setUnitWasCellUnit((WasCellUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT:
				setUnitWasClassLoaderConfigurationUnit((WasClassLoaderConfigurationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT:
				setUnitWasClusterUnit((WasClusterUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE:
				setUnitWasdatasource((WasDatasourceUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingConnectionFactoryUnit((WasDefaultMessagingConnectionFactoryUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingQueueConnectionFactoryUnit((WasDefaultMessagingQueueConnectionFactoryUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
				setUnitWasDefaultMessagingQueueDestinationUnit((WasDefaultMessagingQueueDestinationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingTopicConnectionFactoryUnit((WasDefaultMessagingTopicConnectionFactoryUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
				setUnitWasDefaultMessagingTopicDestinationUnit((WasDefaultMessagingTopicDestinationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT:
				setUnitWasDeploymentManagerUnit((WasDeploymentManagerUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT:
				setUnitWasEndpointListenerUnit((WasEndpointListenerUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH:
				setUnitWasJ2CAuth((WASJ2CAuthenticationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
				setUnitWasJMSActivationSpecificationUnit((WasJMSActivationSpecificationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT:
				setUnitWasLdapConfigurationUnit((WasLdapConfigurationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				setUnitWasMessagingEngine((WasMessagingEngineUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT:
				setUnitWasNodeGroupUnit((WasNodeGroupUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT:
				setUnitWasNodeUnit((WasNodeUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT:
				setUnitWasNodeWindowsServiceUnit((WasNodeWindowsServiceUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT:
				setUnitWasSharedLibraryEntryUnit((WasSharedLibraryEntryUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT:
				setUnitWasSibDestinationUnit((WasSibDestinationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT:
				setUnitWasSibInboundPortUnit((WasSibInboundPortUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT:
				setUnitWasSibInboundServiceUnit((WasSibInboundServiceUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT:
				setUnitWasSibMediationUnit((WasSibMediationUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT:
				setUnitWasSibOutboundPortUnit((WasSibOutboundPortUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT:
				setUnitWasSibOutboundServiceUnit((WasSibOutboundServiceUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT:
				setUnitWasSIBusUnit((WasSIBusUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT:
				setUnitWasSystemUnit((WasSystemUnit)newValue);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT:
				setUnitWasWebServerUnit((WasWebServerUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER:
				setCapabilityDb2JdbcProvider((DB2JdbcProvider)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER:
				setCapabilityDerbyJdbcProvider((DerbyJdbcProvider)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER:
				setCapabilityExtendedJdbcProvider((ExtendedJdbcProvider)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION:
				setCapabilityWasAdvancedLdapConfiguration((WasAdvancedLdapConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY:
				setCapabilityWasApplicationClassLoaderPolicy((WasApplicationClassLoaderPolicy)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT:
				setCapabilityWasApplicationExt((WasApplicationExt)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY:
				setCapabilityWasApplicationServerClassLoaderPolicy((WasApplicationServerClassLoaderPolicy)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL:
				setCapabilityWasCell((WasCell)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY:
				setCapabilityWasClassLoaderPolicy((WasClassLoaderPolicy)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER:
				setCapabilityWasCluster((WasCluster)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER:
				setCapabilityWasConfigurationContainer((WasConfigurationContainer)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE:
				setCapabilityWasDatasource((WasDatasource)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingConnectionFactoryConfiguration((WasDefaultMessagingConnectionFactoryConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration((WasDefaultMessagingQueueConnectionFactoryConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
				setCapabilityWasDefaultMessagingQueueDestination((WasDefaultMessagingQueueDestination)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
				setCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration((WasDefaultMessagingTopicConnectionFactoryConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
				setCapabilityWasDefaultMessagingTopicDestination((WasDefaultMessagingTopicDestination)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER:
				setCapabilityWasDeploymentManager((WasDeploymentManager)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION:
				setCapabilityWasEndpointListenerConfiguration((WasEndpointListenerConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST:
				setCapabilityWasHandlerList((WasHandlerList)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH:
				setCapabilityWasJ2CAuth((WASJ2CAuthenticationDataEntry)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER:
				setCapabilityWasJ2EEServer((WasJ2EEServer)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION:
				setCapabilityWasJMSActivationSpecification((WasJMSActivationSpecification)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION:
				setCapabilityWasLdapConfiguration((WasLdapConfiguration)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
				setCapabilityWasMessagingEngine((WasMessagingEngine)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY:
				setCapabilityWasModuleClassLoaderPolicy((WasModuleClassLoaderPolicy)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE:
				setCapabilityWasNode((WasNode)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP:
				setCapabilityWasNodeGroup((WasNodeGroup)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN:
				setCapabilityWasPluginAdmin((WasPluginAdmin)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION:
				setCapabilityWasPluginRedirection((WasPluginRedirection)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY:
				setCapabilityWasSecurity((WasSecurity)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT:
				setCapabilityWasSecuritySubject((WasSecuritySubject)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER:
				setCapabilityWasServer((WasServer)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER:
				setCapabilityWasSharedLibContainer((WasSharedLibContainer)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY:
				setCapabilityWasSharedLibrary((SharedLibraryEntry)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION:
				setCapabilityWasSibDestination((WasSibDestination)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS:
				setCapabilityWasSibForeignBus((WasSibForeignBus)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT:
				setCapabilityWasSibInboundPort((WasSibInboundPort)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE:
				setCapabilityWasSibInboundService((WasSibInboundService)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION:
				setCapabilityWasSibMediation((WasSibMediation)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT:
				setCapabilityWasSibOutboundPort((WasSibOutboundPort)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE:
				setCapabilityWasSibOutboundService((WasSibOutboundService)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
				setCapabilityWasSibServiceIntegrationBusLink((WasSibServiceIntegrationBusLink)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS:
				setCapabilityWasSIBus((WasSIBus)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE:
				setCapabilityWasSubstitutionVariable((WasSubstitutionVariable)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM:
				setCapabilityWasSystem((WasSystem)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE:
				setCapabilityWasv4datasource((WasV4Datasource)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE:
				setCapabilityWasv5datasource((WasV5Datasource)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE:
				setCapabilityWasv5DB2Datasource((WasV5DB2Datasource)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE:
				setCapabilityWasv5DB2ZosDatasource((WasV5DB2ZosDatasource)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST:
				setCapabilityWasVirtualHost((VirtualHostType)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT:
				setCapabilityWasWebAppExt((WasWebAppExt)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER:
				setCapabilityWasWebServer((WasWebServer)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT:
				setCapabilityWasWebServerManagement((WasWebServerManagement)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN:
				setCapabilityWasWebServerPlugin((WasWebServerPlugin)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CLASSLOADER:
				setClassloader((Classloader)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasEarClassloaderPolicyConstraint((WasEarClassloaderPolicyConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
				setConstraintWasJ2EEConstraint((WasJ2EEConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
				setConstraintWasJNDIBindingConstraint((WasJNDIBindingConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasModuleClassloaderPolicyConstraint((WasModuleClassloaderPolicyConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
				setConstraintWasModuleStartWeightConstraint((WasModuleStartWeightConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
				setConstraintWasSecuritySubjectConstraint((WasSecuritySubjectConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
				setConstraintWasWarClassloaderPolicyConstraint((WasWarClassloaderPolicyConstraint)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS:
				setHostNameAlias((HostNameAliasType)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT:
				setUnitDb2JdbcProviderUnit((DB2JdbcProviderUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT:
				setUnitDerbyJdbcProviderUnit((DerbyJdbcProviderUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT:
				setUnitExtendedJdbcProviderUnit((ExtendedJdbcProviderUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER:
				setUnitWasAppServer((WebsphereAppServerUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT:
				setUnitWasCellUnit((WasCellUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT:
				setUnitWasClassLoaderConfigurationUnit((WasClassLoaderConfigurationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT:
				setUnitWasClusterUnit((WasClusterUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE:
				setUnitWasdatasource((WasDatasourceUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingConnectionFactoryUnit((WasDefaultMessagingConnectionFactoryUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingQueueConnectionFactoryUnit((WasDefaultMessagingQueueConnectionFactoryUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
				setUnitWasDefaultMessagingQueueDestinationUnit((WasDefaultMessagingQueueDestinationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitWasDefaultMessagingTopicConnectionFactoryUnit((WasDefaultMessagingTopicConnectionFactoryUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
				setUnitWasDefaultMessagingTopicDestinationUnit((WasDefaultMessagingTopicDestinationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT:
				setUnitWasDeploymentManagerUnit((WasDeploymentManagerUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT:
				setUnitWasEndpointListenerUnit((WasEndpointListenerUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH:
				setUnitWasJ2CAuth((WASJ2CAuthenticationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
				setUnitWasJMSActivationSpecificationUnit((WasJMSActivationSpecificationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT:
				setUnitWasLdapConfigurationUnit((WasLdapConfigurationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				setUnitWasMessagingEngine((WasMessagingEngineUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT:
				setUnitWasNodeGroupUnit((WasNodeGroupUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT:
				setUnitWasNodeUnit((WasNodeUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT:
				setUnitWasNodeWindowsServiceUnit((WasNodeWindowsServiceUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT:
				setUnitWasSharedLibraryEntryUnit((WasSharedLibraryEntryUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT:
				setUnitWasSibDestinationUnit((WasSibDestinationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT:
				setUnitWasSibInboundPortUnit((WasSibInboundPortUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT:
				setUnitWasSibInboundServiceUnit((WasSibInboundServiceUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT:
				setUnitWasSibMediationUnit((WasSibMediationUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT:
				setUnitWasSibOutboundPortUnit((WasSibOutboundPortUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT:
				setUnitWasSibOutboundServiceUnit((WasSibOutboundServiceUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT:
				setUnitWasSIBusUnit((WasSIBusUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT:
				setUnitWasSystemUnit((WasSystemUnit)null);
				return;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT:
				setUnitWasWebServerUnit((WasWebServerUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case WasPackage.WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case WasPackage.WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER:
				return getCapabilityDb2JdbcProvider() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER:
				return getCapabilityDerbyJdbcProvider() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER:
				return getCapabilityExtendedJdbcProvider() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION:
				return getCapabilityWasAdvancedLdapConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY:
				return getCapabilityWasApplicationClassLoaderPolicy() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT:
				return getCapabilityWasApplicationExt() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY:
				return getCapabilityWasApplicationServerClassLoaderPolicy() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL:
				return getCapabilityWasCell() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY:
				return getCapabilityWasClassLoaderPolicy() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER:
				return getCapabilityWasCluster() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER:
				return getCapabilityWasConfigurationContainer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE:
				return getCapabilityWasDatasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingConnectionFactoryConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
				return getCapabilityWasDefaultMessagingQueueDestination() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
				return getCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
				return getCapabilityWasDefaultMessagingTopicDestination() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER:
				return getCapabilityWasDeploymentManager() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION:
				return getCapabilityWasEndpointListenerConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST:
				return getCapabilityWasHandlerList() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH:
				return getCapabilityWasJ2CAuth() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER:
				return getCapabilityWasJ2EEServer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION:
				return getCapabilityWasJMSActivationSpecification() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION:
				return getCapabilityWasLdapConfiguration() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
				return getCapabilityWasMessagingEngine() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY:
				return getCapabilityWasModuleClassLoaderPolicy() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE:
				return getCapabilityWasNode() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP:
				return getCapabilityWasNodeGroup() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN:
				return getCapabilityWasPluginAdmin() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION:
				return getCapabilityWasPluginRedirection() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY:
				return getCapabilityWasSecurity() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT:
				return getCapabilityWasSecuritySubject() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER:
				return getCapabilityWasServer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER:
				return getCapabilityWasSharedLibContainer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY:
				return getCapabilityWasSharedLibrary() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION:
				return getCapabilityWasSibDestination() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS:
				return getCapabilityWasSibForeignBus() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT:
				return getCapabilityWasSibInboundPort() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE:
				return getCapabilityWasSibInboundService() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION:
				return getCapabilityWasSibMediation() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT:
				return getCapabilityWasSibOutboundPort() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE:
				return getCapabilityWasSibOutboundService() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
				return getCapabilityWasSibServiceIntegrationBusLink() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS:
				return getCapabilityWasSIBus() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE:
				return getCapabilityWasSubstitutionVariable() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM:
				return getCapabilityWasSystem() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE:
				return getCapabilityWasv4datasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE:
				return getCapabilityWasv5datasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE:
				return getCapabilityWasv5DB2Datasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE:
				return getCapabilityWasv5DB2ZosDatasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST:
				return getCapabilityWasVirtualHost() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT:
				return getCapabilityWasWebAppExt() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER:
				return getCapabilityWasWebServer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT:
				return getCapabilityWasWebServerManagement() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN:
				return getCapabilityWasWebServerPlugin() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CLASSLOADER:
				return getClassloader() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasEarClassloaderPolicyConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
				return getConstraintWasJ2EEConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
				return getConstraintWasJNDIBindingConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasModuleClassloaderPolicyConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
				return getConstraintWasModuleStartWeightConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
				return getConstraintWasSecuritySubjectConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
				return getConstraintWasWarClassloaderPolicyConstraint() != null;
			case WasPackage.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS:
				return getHostNameAlias() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT:
				return getUnitDb2JdbcProviderUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT:
				return getUnitDerbyJdbcProviderUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT:
				return getUnitExtendedJdbcProviderUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER:
				return getUnitWasAppServer() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT:
				return getUnitWasCellUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT:
				return getUnitWasClassLoaderConfigurationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT:
				return getUnitWasClusterUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE:
				return getUnitWasdatasource() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingConnectionFactoryUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingQueueConnectionFactoryUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
				return getUnitWasDefaultMessagingQueueDestinationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitWasDefaultMessagingTopicConnectionFactoryUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
				return getUnitWasDefaultMessagingTopicDestinationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT:
				return getUnitWasDeploymentManagerUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT:
				return getUnitWasEndpointListenerUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH:
				return getUnitWasJ2CAuth() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitWasJMSActivationSpecificationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT:
				return getUnitWasLdapConfigurationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				return getUnitWasMessagingEngine() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT:
				return getUnitWasNodeGroupUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT:
				return getUnitWasNodeUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT:
				return getUnitWasNodeWindowsServiceUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT:
				return getUnitWasSharedLibraryEntryUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT:
				return getUnitWasSibDestinationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT:
				return getUnitWasSibInboundPortUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT:
				return getUnitWasSibInboundServiceUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT:
				return getUnitWasSibMediationUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT:
				return getUnitWasSibOutboundPortUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT:
				return getUnitWasSibOutboundServiceUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT:
				return getUnitWasSIBusUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT:
				return getUnitWasSystemUnit() != null;
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT:
				return getUnitWasWebServerUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //WasDeployRootImpl
