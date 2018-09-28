/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validation;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

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
import com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasModuleClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit;
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
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.was.WasDeployRoot}. This doesn't
 * really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WasDeployRootValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);

	boolean validateXMLNSPrefixMap(Map value);

	boolean validateXSISchemaLocation(Map value);

	boolean validateCapabilityDb2JdbcProvider(DB2JdbcProvider value);

	boolean validateCapabilityDerbyJdbcProvider(DerbyJdbcProvider value);

	boolean validateCapabilityExtendedJdbcProvider(ExtendedJdbcProvider value);

	boolean validateCapabilityWasAdvancedLdapConfiguration(WasAdvancedLdapConfiguration value);

	boolean validateCapabilityWasApplicationClassLoaderPolicy(WasApplicationClassLoaderPolicy value);

	boolean validateCapabilityWasApplicationExt(WasApplicationExt value);

	boolean validateCapabilityWasApplicationServerClassLoaderPolicy(
			WasApplicationServerClassLoaderPolicy value);

	boolean validateCapabilityWasCell(WasCell value);

	boolean validateCapabilityWasClassLoaderPolicy(WasClassLoaderPolicy value);

	boolean validateCapabilityWasCluster(WasCluster value);

	boolean validateCapabilityWasConfigurationContainer(WasConfigurationContainer value);

	boolean validateCapabilityWasDatasource(WasDatasource value);

	boolean validateCapabilityWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration value);

	boolean validateCapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration value);

	boolean validateCapabilityWasDefaultMessagingQueueDestination(
			WasDefaultMessagingQueueDestination value);

	boolean validateCapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration value);

	boolean validateCapabilityWasDefaultMessagingTopicDestination(
			WasDefaultMessagingTopicDestination value);

	boolean validateCapabilityWasDeploymentManager(WasDeploymentManager value);

	boolean validateCapabilityWasEndpointListenerConfiguration(WasEndpointListenerConfiguration value);

	boolean validateCapabilityWasHandlerList(WasHandlerList value);

	boolean validateCapabilityWasJ2CAuth(WASJ2CAuthenticationDataEntry value);

	boolean validateCapabilityWasJ2EEServer(WasJ2EEServer value);

	boolean validateCapabilityWasJMSActivationSpecification(WasJMSActivationSpecification value);

	boolean validateCapabilityWasLdapConfiguration(WasLdapConfiguration value);

	boolean validateCapabilityWasModuleClassLoaderPolicy(WasModuleClassLoaderPolicy value);

	boolean validateCapabilityWasNode(WasNode value);

	boolean validateCapabilityWasNodeGroup(WasNodeGroup value);

	boolean validateCapabilityWasPluginAdmin(WasPluginAdmin value);

	boolean validateCapabilityWasPluginRedirection(WasPluginRedirection value);

	boolean validateCapabilityWasSecurity(WasSecurity value);

	boolean validateCapabilityWasSecuritySubject(WasSecuritySubject value);

	boolean validateCapabilityWasServer(WasServer value);

	boolean validateCapabilityWasSharedLibContainer(WasSharedLibContainer value);

	boolean validateCapabilityWasSharedLibrary(SharedLibraryEntry value);

	boolean validateCapabilityWasSibDestination(WasSibDestination value);

	boolean validateCapabilityWasSibForeignBus(WasSibForeignBus value);

	boolean validateCapabilityWasSibInboundPort(WasSibInboundPort value);

	boolean validateCapabilityWasSibInboundService(WasSibInboundService value);

	boolean validateCapabilityWasSibMediation(WasSibMediation value);

	boolean validateCapabilityWasSibOutboundPort(WasSibOutboundPort value);

	boolean validateCapabilityWasSibOutboundService(WasSibOutboundService value);

	boolean validateCapabilityWasSibServiceIntegrationBusLink(WasSibServiceIntegrationBusLink value);

	boolean validateCapabilityWasSIBus(WasSIBus value);

	boolean validateCapabilityWasSubstitutionVariable(WasSubstitutionVariable value);

	boolean validateCapabilityWasSystem(WasSystem value);

	boolean validateCapabilityWasv4datasource(WasV4Datasource value);

	boolean validateCapabilityWasv5datasource(WasV5Datasource value);

	boolean validateCapabilityWasv5DB2Datasource(WasV5DB2Datasource value);

	boolean validateCapabilityWasv5DB2ZosDatasource(WasV5DB2ZosDatasource value);

	boolean validateCapabilityWasVirtualHost(VirtualHostType value);

	boolean validateCapabilityWasWebAppExt(WasWebAppExt value);

	boolean validateCapabilityWasWebServer(WasWebServer value);

	boolean validateCapabilityWasWebServerManagement(WasWebServerManagement value);

	boolean validateCapabilityWasWebServerPlugin(WasWebServerPlugin value);

	boolean validateClassloader(Classloader value);

	boolean validateConstraintWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint value);

	boolean validateConstraintWasJ2EEConstraint(WasJ2EEConstraint value);

	boolean validateConstraintWasJNDIBindingConstraint(WasJNDIBindingConstraint value);

	boolean validateConstraintWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint value);

	boolean validateConstraintWasModuleStartWeightConstraint(WasModuleStartWeightConstraint value);

	boolean validateConstraintWasSecuritySubjectConstraint(WasSecuritySubjectConstraint value);

	boolean validateConstraintWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint value);

	boolean validateHostNameAlias(HostNameAliasType value);

	boolean validateUnitDb2JdbcProviderUnit(DB2JdbcProviderUnit value);

	boolean validateUnitDerbyJdbcProviderUnit(DerbyJdbcProviderUnit value);

	boolean validateUnitExtendedJdbcProviderUnit(ExtendedJdbcProviderUnit value);

	boolean validateUnitWasAppServer(WebsphereAppServerUnit value);

	boolean validateUnitWasCellUnit(WasCellUnit value);

	boolean validateUnitWasClassLoaderConfigurationUnit(WasClassLoaderConfigurationUnit value);

	boolean validateUnitWasClusterUnit(WasClusterUnit value);

	boolean validateUnitWasdatasource(WasDatasourceUnit value);

	boolean validateUnitWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit value);

	boolean validateUnitWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit value);

	boolean validateUnitWasDefaultMessagingQueueDestinationUnit(
			WasDefaultMessagingQueueDestinationUnit value);

	boolean validateUnitWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit value);

	boolean validateUnitWasDefaultMessagingTopicDestinationUnit(
			WasDefaultMessagingTopicDestinationUnit value);

	boolean validateUnitWasDeploymentManagerUnit(WasDeploymentManagerUnit value);

	boolean validateUnitWasEndpointListenerUnit(WasEndpointListenerUnit value);

	boolean validateUnitWasJ2CAuth(WASJ2CAuthenticationUnit value);

	boolean validateUnitWasJMSActivationSpecificationUnit(WasJMSActivationSpecificationUnit value);

	boolean validateUnitWasLdapConfigurationUnit(WasLdapConfigurationUnit value);

	boolean validateUnitWasNodeGroupUnit(WasNodeGroupUnit value);

	boolean validateUnitWasNodeUnit(WasNodeUnit value);

	boolean validateUnitWasNodeWindowsServiceUnit(WasNodeWindowsServiceUnit value);

	boolean validateUnitWasSharedLibraryEntryUnit(WasSharedLibraryEntryUnit value);

	boolean validateUnitWasSibDestinationUnit(WasSibDestinationUnit value);

	boolean validateUnitWasSibInboundPortUnit(WasSibInboundPortUnit value);

	boolean validateUnitWasSibInboundServiceUnit(WasSibInboundServiceUnit value);

	boolean validateUnitWasSibMediationUnit(WasSibMediationUnit value);

	boolean validateUnitWasSibOutboundPortUnit(WasSibOutboundPortUnit value);

	boolean validateUnitWasSibOutboundServiceUnit(WasSibOutboundServiceUnit value);

	boolean validateUnitWasSIBusUnit(WasSIBusUnit value);

	boolean validateUnitWasSystemUnit(WasSystemUnit value);

	boolean validateUnitWasWebServerUnit(WasWebServerUnit value);
}
