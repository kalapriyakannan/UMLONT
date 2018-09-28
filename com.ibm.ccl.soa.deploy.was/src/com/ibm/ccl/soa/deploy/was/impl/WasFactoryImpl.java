/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.was.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class WasFactoryImpl extends EFactoryImpl implements WasFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasFactory init() {
		try {
			WasFactory theWasFactory = (WasFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/was/1.0.0/"); //$NON-NLS-1$ 
			if (theWasFactory != null) {
				return theWasFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WasFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WasPackage.CLASSLOADER: return (EObject)createClassloader();
			case WasPackage.DB2_JDBC_PROVIDER: return createDB2JdbcProvider();
			case WasPackage.DB2_JDBC_PROVIDER_UNIT: return createDB2JdbcProviderUnit();
			case WasPackage.DERBY_JDBC_PROVIDER: return createDerbyJdbcProvider();
			case WasPackage.DERBY_JDBC_PROVIDER_UNIT: return createDerbyJdbcProviderUnit();
			case WasPackage.EXTENDED_JDBC_PROVIDER: return createExtendedJdbcProvider();
			case WasPackage.EXTENDED_JDBC_PROVIDER_UNIT: return createExtendedJdbcProviderUnit();
			case WasPackage.HOST_NAME_ALIAS_TYPE: return (EObject)createHostNameAliasType();
			case WasPackage.SHARED_LIBRARY_ENTRY: return createSharedLibraryEntry();
			case WasPackage.VIRTUAL_HOST_TYPE: return createVirtualHostType();
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION: return createWasAdvancedLdapConfiguration();
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY: return createWasApplicationClassLoaderPolicy();
			case WasPackage.WAS_APPLICATION_EXT: return createWasApplicationExt();
			case WasPackage.WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY: return createWasApplicationServerClassLoaderPolicy();
			case WasPackage.WAS_CELL: return createWasCell();
			case WasPackage.WAS_CELL_UNIT: return createWasCellUnit();
			case WasPackage.WAS_CLASS_LOADER_CONFIGURATION_UNIT: return createWasClassLoaderConfigurationUnit();
			case WasPackage.WAS_CLASS_LOADER_POLICY: return createWasClassLoaderPolicy();
			case WasPackage.WAS_CLUSTER: return createWasCluster();
			case WasPackage.WAS_CLUSTER_UNIT: return createWasClusterUnit();
			case WasPackage.WAS_CONFIGURATION_CONTAINER: return createWasConfigurationContainer();
			case WasPackage.WAS_DATASOURCE: return createWasDatasource();
			case WasPackage.WAS_DATASOURCE_UNIT: return createWasDatasourceUnit();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION: return createWasDefaultMessagingConnectionFactoryConfiguration();
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT: return createWasDefaultMessagingConnectionFactoryUnit();
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION: return createWasDefaultMessagingQueueConnectionFactoryConfiguration();
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT: return createWasDefaultMessagingQueueConnectionFactoryUnit();
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION: return createWasDefaultMessagingQueueDestination();
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT: return createWasDefaultMessagingQueueDestinationUnit();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION: return createWasDefaultMessagingTopicConnectionFactoryConfiguration();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT: return createWasDefaultMessagingTopicConnectionFactoryUnit();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION: return createWasDefaultMessagingTopicDestination();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT: return createWasDefaultMessagingTopicDestinationUnit();
			case WasPackage.WAS_DEPLOYMENT_MANAGER: return createWasDeploymentManager();
			case WasPackage.WAS_DEPLOYMENT_MANAGER_UNIT: return createWasDeploymentManagerUnit();
			case WasPackage.WAS_DEPLOY_ROOT: return (EObject)createWasDeployRoot();
			case WasPackage.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT: return createWasEarClassloaderPolicyConstraint();
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION: return createWasEndpointListenerConfiguration();
			case WasPackage.WAS_ENDPOINT_LISTENER_UNIT: return createWasEndpointListenerUnit();
			case WasPackage.WAS_HANDLER_LIST: return createWasHandlerList();
			case WasPackage.WASJ2C_AUTHENTICATION_DATA_ENTRY: return createWASJ2CAuthenticationDataEntry();
			case WasPackage.WASJ2C_AUTHENTICATION_UNIT: return createWASJ2CAuthenticationUnit();
			case WasPackage.WAS_J2EE_CONSTRAINT: return createWasJ2EEConstraint();
			case WasPackage.WAS_J2EE_SERVER: return createWasJ2EEServer();
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION: return createWasJMSActivationSpecification();
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT: return createWasJMSActivationSpecificationUnit();
			case WasPackage.WAS_JNDI_BINDING_CONSTRAINT: return createWasJNDIBindingConstraint();
			case WasPackage.WAS_LDAP_CONFIGURATION: return createWasLdapConfiguration();
			case WasPackage.WAS_LDAP_CONFIGURATION_UNIT: return createWasLdapConfigurationUnit();
			case WasPackage.WAS_MESSAGING_ENGINE: return createWasMessagingEngine();
			case WasPackage.WAS_MESSAGING_ENGINE_UNIT: return createWasMessagingEngineUnit();
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY: return createWasModuleClassLoaderPolicy();
			case WasPackage.WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT: return createWasModuleClassloaderPolicyConstraint();
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT: return createWasModuleStartWeightConstraint();
			case WasPackage.WAS_NODE: return createWasNode();
			case WasPackage.WAS_NODE_GROUP: return createWasNodeGroup();
			case WasPackage.WAS_NODE_GROUP_UNIT: return createWasNodeGroupUnit();
			case WasPackage.WAS_NODE_UNIT: return createWasNodeUnit();
			case WasPackage.WAS_NODE_WINDOWS_SERVICE_UNIT: return createWasNodeWindowsServiceUnit();
			case WasPackage.WAS_PLUGIN_ADMIN: return createWasPluginAdmin();
			case WasPackage.WAS_PLUGIN_REDIRECTION: return createWasPluginRedirection();
			case WasPackage.WAS_SECURITY: return createWasSecurity();
			case WasPackage.WAS_SECURITY_SUBJECT: return createWasSecuritySubject();
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT: return createWasSecuritySubjectConstraint();
			case WasPackage.WAS_SERVER: return createWasServer();
			case WasPackage.WAS_SHARED_LIB_CONTAINER: return createWasSharedLibContainer();
			case WasPackage.WAS_SHARED_LIBRARY_ENTRY_UNIT: return createWasSharedLibraryEntryUnit();
			case WasPackage.WAS_SIB_DESTINATION: return createWasSibDestination();
			case WasPackage.WAS_SIB_DESTINATION_UNIT: return createWasSibDestinationUnit();
			case WasPackage.WAS_SIB_FOREIGN_BUS: return createWasSibForeignBus();
			case WasPackage.WAS_SIB_INBOUND_PORT: return createWasSibInboundPort();
			case WasPackage.WAS_SIB_INBOUND_PORT_UNIT: return createWasSibInboundPortUnit();
			case WasPackage.WAS_SIB_INBOUND_SERVICE: return createWasSibInboundService();
			case WasPackage.WAS_SIB_INBOUND_SERVICE_UNIT: return createWasSibInboundServiceUnit();
			case WasPackage.WAS_SIB_MEDIATION: return createWasSibMediation();
			case WasPackage.WAS_SIB_MEDIATION_UNIT: return createWasSibMediationUnit();
			case WasPackage.WAS_SIB_OUTBOUND_PORT: return createWasSibOutboundPort();
			case WasPackage.WAS_SIB_OUTBOUND_PORT_UNIT: return createWasSibOutboundPortUnit();
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE: return createWasSibOutboundService();
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE_UNIT: return createWasSibOutboundServiceUnit();
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK: return createWasSibServiceIntegrationBusLink();
			case WasPackage.WAS_SI_BUS: return createWasSIBus();
			case WasPackage.WAS_SI_BUS_UNIT: return createWasSIBusUnit();
			case WasPackage.WAS_SUBSTITUTION_VARIABLE: return createWasSubstitutionVariable();
			case WasPackage.WAS_SYSTEM: return createWasSystem();
			case WasPackage.WAS_SYSTEM_UNIT: return createWasSystemUnit();
			case WasPackage.WAS_V4_DATASOURCE: return createWasV4Datasource();
			case WasPackage.WAS_V5_DATASOURCE: return createWasV5Datasource();
			case WasPackage.WAS_V5DB2_DATASOURCE: return createWasV5DB2Datasource();
			case WasPackage.WAS_V5DB2_ZOS_DATASOURCE: return createWasV5DB2ZosDatasource();
			case WasPackage.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT: return createWasWarClassloaderPolicyConstraint();
			case WasPackage.WAS_WEB_APP_EXT: return createWasWebAppExt();
			case WasPackage.WAS_WEB_SERVER: return createWasWebServer();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT: return createWasWebServerManagement();
			case WasPackage.WAS_WEB_SERVER_PLUGIN: return createWasWebServerPlugin();
			case WasPackage.WAS_WEB_SERVER_UNIT: return createWasWebServerUnit();
			case WasPackage.WEBSPHERE_APP_SERVER_UNIT: return createWebsphereAppServerUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case WasPackage.ACKNOWLEDGE_MODE_ENUM:
				return createAcknowledgeModeEnumFromString(eDataType, initialValue);
			case WasPackage.CERTIFICATE_MAP_MODE:
				return createCertificateMapModeFromString(eDataType, initialValue);
			case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM:
				return createCFTargetSignificanceEnumFromString(eDataType, initialValue);
			case WasPackage.CLASSLOADER_MODE:
				return createClassloaderModeFromString(eDataType, initialValue);
			case WasPackage.CLASSLOADER_POLICY_TYPE:
				return createClassloaderPolicyTypeFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_DELIVERY_MODE_ENUM:
				return createConnectionDeliveryModeEnumFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM:
				return createConnectionFactoryTargetTypeEnumFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_PROXIMITY_ENUM:
				return createConnectionProximityEnumFromString(eDataType, initialValue);
			case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES:
				return createDataSourceHelperClassNamesFromString(eDataType, initialValue);
			case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM:
				return createDB2DataSourceTemplateEnumFromString(eDataType, initialValue);
			case WasPackage.DB2_JDBC_PROVIDER_TYPE:
				return createDB2JdbcProviderTypeFromString(eDataType, initialValue);
			case WasPackage.DERBY_JDBC_PROVIDER_TYPE_TYPE:
				return createDerbyJdbcProviderTypeTypeFromString(eDataType, initialValue);
			case WasPackage.END_POINT_LISTENER_NAME_ENUM:
				return createEndPointListenerNameEnumFromString(eDataType, initialValue);
			case WasPackage.IIOP_SECURITY_PROTOCOLS:
				return createIIOPSecurityProtocolsFromString(eDataType, initialValue);
			case WasPackage.JDBC_IMPLEMENTATION_TYPE_TYPE:
				return createJdbcImplementationTypeTypeFromString(eDataType, initialValue);
			case WasPackage.JMS_DESTINATION_TYPE_ENUM:
				return createJMSDestinationTypeEnumFromString(eDataType, initialValue);
			case WasPackage.LDAP_DIRECTORY_TYPE:
				return createLDAPDirectoryTypeFromString(eDataType, initialValue);
			case WasPackage.MESSAGE_RELIABILITY_ENUM:
				return createMessageReliabilityEnumFromString(eDataType, initialValue);
			case WasPackage.POLICIES:
				return createPoliciesFromString(eDataType, initialValue);
			case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM:
				return createReadAheadOptimizationEnumFromString(eDataType, initialValue);
			case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM:
				return createShareDurableSubscriptionsEnumFromString(eDataType, initialValue);
			case WasPackage.WAR_CLASSLOADER_POLICY:
				return createWARClassloaderPolicyFromString(eDataType, initialValue);
			case WasPackage.WAS_ACCOUNT_TYPE_ENUM:
				return createWasAccountTypeEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_APPLICATION_MAP:
				return createWasApplicationMapFromString(eDataType, initialValue);
			case WasPackage.WAS_DEFAULT_SECURITY_SUBJECT_ENUM:
				return createWasDefaultSecuritySubjectEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES:
				return createWasDeploymentManagerPortNamesFromString(eDataType, initialValue);
			case WasPackage.WAS_EDITION_ENUM:
				return createWasEditionEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_ENDPOINT_LISTENER_TYPE:
				return createWasEndpointListenerTypeFromString(eDataType, initialValue);
			case WasPackage.WAS_NODE_GROUP_TYPE_ENUM:
				return createWasNodeGroupTypeEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_NODE_PORT_NAMES:
				return createWasNodePortNamesFromString(eDataType, initialValue);
			case WasPackage.WAS_PROFILE_TYPE_ENUM:
				return createWasProfileTypeEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM:
				return createWasRoutingDefinitionTypeEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM:
				return createWasSibDestinationTypeEnumFromString(eDataType, initialValue);
			case WasPackage.WAS_USER_REGISTRY_TYPES:
				return createWasUserRegistryTypesFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_NODE_TYPE:
				return createWasWebServerNodeTypeFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_OS:
				return createWasWebServerOSFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_TYPE:
				return createWasWebServerTypeFromString(eDataType, initialValue);
			case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES:
				return createWebsphereAppServerPortNamesFromString(eDataType, initialValue);
			case WasPackage.ACKNOWLEDGE_MODE_ENUM_OBJECT:
				return createAcknowledgeModeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.CERTIFICATE_MAP_MODE_OBJECT:
				return createCertificateMapModeObjectFromString(eDataType, initialValue);
			case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM_OBJECT:
				return createCFTargetSignificanceEnumObjectFromString(eDataType, initialValue);
			case WasPackage.CLASSLOADER_MODE_OBJECT:
				return createClassloaderModeObjectFromString(eDataType, initialValue);
			case WasPackage.CLASSLOADER_POLICY_TYPE_OBJECT:
				return createClassloaderPolicyTypeObjectFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_DELIVERY_MODE_ENUM_OBJECT:
				return createConnectionDeliveryModeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM_OBJECT:
				return createConnectionFactoryTargetTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.CONNECTION_PROXIMITY_ENUM_OBJECT:
				return createConnectionProximityEnumObjectFromString(eDataType, initialValue);
			case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES_OBJECT:
				return createDataSourceHelperClassNamesObjectFromString(eDataType, initialValue);
			case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM_OBJECT:
				return createDB2DataSourceTemplateEnumObjectFromString(eDataType, initialValue);
			case WasPackage.DB2_JDBC_PROVIDER_TYPE_OBJECT:
				return createDB2JdbcProviderTypeObjectFromString(eDataType, initialValue);
			case WasPackage.DERBY_JDBC_PROVIDER_TYPE_TYPE_OBJECT:
				return createDerbyJdbcProviderTypeTypeObjectFromString(eDataType, initialValue);
			case WasPackage.END_POINT_LISTENER_NAME_ENUM_OBJECT:
				return createEndPointListenerNameEnumObjectFromString(eDataType, initialValue);
			case WasPackage.IIOP_SECURITY_PROTOCOLS_OBJECT:
				return createIIOPSecurityProtocolsObjectFromString(eDataType, initialValue);
			case WasPackage.JDBC_IMPLEMENTATION_TYPE_TYPE_OBJECT:
				return createJdbcImplementationTypeTypeObjectFromString(eDataType, initialValue);
			case WasPackage.JMS_DESTINATION_TYPE_ENUM_OBJECT:
				return createJMSDestinationTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.LDAP_DIRECTORY_TYPE_OBJECT:
				return createLDAPDirectoryTypeObjectFromString(eDataType, initialValue);
			case WasPackage.MESSAGE_RELIABILITY_ENUM_OBJECT:
				return createMessageReliabilityEnumObjectFromString(eDataType, initialValue);
			case WasPackage.POLICIES_OBJECT:
				return createPoliciesObjectFromString(eDataType, initialValue);
			case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM_OBJECT:
				return createReadAheadOptimizationEnumObjectFromString(eDataType, initialValue);
			case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM_OBJECT:
				return createShareDurableSubscriptionsEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAR_CLASSLOADER_POLICY_OBJECT:
				return createWARClassloaderPolicyObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_ACCOUNT_TYPE_ENUM_OBJECT:
				return createWasAccountTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_APPLICATION_MAP_OBJECT:
				return createWasApplicationMapObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_DEFAULT_SECURITY_SUBJECT_ENUM_OBJECT:
				return createWasDefaultSecuritySubjectEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES_OBJECT:
				return createWasDeploymentManagerPortNamesObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_EDITION_ENUM_OBJECT:
				return createWasEditionEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_ENDPOINT_LISTENER_TYPE_OBJECT:
				return createWasEndpointListenerTypeObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_NODE_GROUP_TYPE_ENUM_OBJECT:
				return createWasNodeGroupTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_NODE_PORT_NAMES_OBJECT:
				return createWasNodePortNamesObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_PROFILE_TYPE_ENUM_OBJECT:
				return createWasProfileTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM_OBJECT:
				return createWasRoutingDefinitionTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM_OBJECT:
				return createWasSibDestinationTypeEnumObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_USER_REGISTRY_TYPES_OBJECT:
				return createWasUserRegistryTypesObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_NODE_TYPE_OBJECT:
				return createWasWebServerNodeTypeObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_OS_OBJECT:
				return createWasWebServerOSObjectFromString(eDataType, initialValue);
			case WasPackage.WAS_WEB_SERVER_TYPE_OBJECT:
				return createWasWebServerTypeObjectFromString(eDataType, initialValue);
			case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES_OBJECT:
				return createWebsphereAppServerPortNamesObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case WasPackage.ACKNOWLEDGE_MODE_ENUM:
				return convertAcknowledgeModeEnumToString(eDataType, instanceValue);
			case WasPackage.CERTIFICATE_MAP_MODE:
				return convertCertificateMapModeToString(eDataType, instanceValue);
			case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM:
				return convertCFTargetSignificanceEnumToString(eDataType, instanceValue);
			case WasPackage.CLASSLOADER_MODE:
				return convertClassloaderModeToString(eDataType, instanceValue);
			case WasPackage.CLASSLOADER_POLICY_TYPE:
				return convertClassloaderPolicyTypeToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_DELIVERY_MODE_ENUM:
				return convertConnectionDeliveryModeEnumToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM:
				return convertConnectionFactoryTargetTypeEnumToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_PROXIMITY_ENUM:
				return convertConnectionProximityEnumToString(eDataType, instanceValue);
			case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES:
				return convertDataSourceHelperClassNamesToString(eDataType, instanceValue);
			case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM:
				return convertDB2DataSourceTemplateEnumToString(eDataType, instanceValue);
			case WasPackage.DB2_JDBC_PROVIDER_TYPE:
				return convertDB2JdbcProviderTypeToString(eDataType, instanceValue);
			case WasPackage.DERBY_JDBC_PROVIDER_TYPE_TYPE:
				return convertDerbyJdbcProviderTypeTypeToString(eDataType, instanceValue);
			case WasPackage.END_POINT_LISTENER_NAME_ENUM:
				return convertEndPointListenerNameEnumToString(eDataType, instanceValue);
			case WasPackage.IIOP_SECURITY_PROTOCOLS:
				return convertIIOPSecurityProtocolsToString(eDataType, instanceValue);
			case WasPackage.JDBC_IMPLEMENTATION_TYPE_TYPE:
				return convertJdbcImplementationTypeTypeToString(eDataType, instanceValue);
			case WasPackage.JMS_DESTINATION_TYPE_ENUM:
				return convertJMSDestinationTypeEnumToString(eDataType, instanceValue);
			case WasPackage.LDAP_DIRECTORY_TYPE:
				return convertLDAPDirectoryTypeToString(eDataType, instanceValue);
			case WasPackage.MESSAGE_RELIABILITY_ENUM:
				return convertMessageReliabilityEnumToString(eDataType, instanceValue);
			case WasPackage.POLICIES:
				return convertPoliciesToString(eDataType, instanceValue);
			case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM:
				return convertReadAheadOptimizationEnumToString(eDataType, instanceValue);
			case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM:
				return convertShareDurableSubscriptionsEnumToString(eDataType, instanceValue);
			case WasPackage.WAR_CLASSLOADER_POLICY:
				return convertWARClassloaderPolicyToString(eDataType, instanceValue);
			case WasPackage.WAS_ACCOUNT_TYPE_ENUM:
				return convertWasAccountTypeEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_APPLICATION_MAP:
				return convertWasApplicationMapToString(eDataType, instanceValue);
			case WasPackage.WAS_DEFAULT_SECURITY_SUBJECT_ENUM:
				return convertWasDefaultSecuritySubjectEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES:
				return convertWasDeploymentManagerPortNamesToString(eDataType, instanceValue);
			case WasPackage.WAS_EDITION_ENUM:
				return convertWasEditionEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_ENDPOINT_LISTENER_TYPE:
				return convertWasEndpointListenerTypeToString(eDataType, instanceValue);
			case WasPackage.WAS_NODE_GROUP_TYPE_ENUM:
				return convertWasNodeGroupTypeEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_NODE_PORT_NAMES:
				return convertWasNodePortNamesToString(eDataType, instanceValue);
			case WasPackage.WAS_PROFILE_TYPE_ENUM:
				return convertWasProfileTypeEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM:
				return convertWasRoutingDefinitionTypeEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM:
				return convertWasSibDestinationTypeEnumToString(eDataType, instanceValue);
			case WasPackage.WAS_USER_REGISTRY_TYPES:
				return convertWasUserRegistryTypesToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_NODE_TYPE:
				return convertWasWebServerNodeTypeToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_OS:
				return convertWasWebServerOSToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_TYPE:
				return convertWasWebServerTypeToString(eDataType, instanceValue);
			case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES:
				return convertWebsphereAppServerPortNamesToString(eDataType, instanceValue);
			case WasPackage.ACKNOWLEDGE_MODE_ENUM_OBJECT:
				return convertAcknowledgeModeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.CERTIFICATE_MAP_MODE_OBJECT:
				return convertCertificateMapModeObjectToString(eDataType, instanceValue);
			case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM_OBJECT:
				return convertCFTargetSignificanceEnumObjectToString(eDataType, instanceValue);
			case WasPackage.CLASSLOADER_MODE_OBJECT:
				return convertClassloaderModeObjectToString(eDataType, instanceValue);
			case WasPackage.CLASSLOADER_POLICY_TYPE_OBJECT:
				return convertClassloaderPolicyTypeObjectToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_DELIVERY_MODE_ENUM_OBJECT:
				return convertConnectionDeliveryModeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM_OBJECT:
				return convertConnectionFactoryTargetTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.CONNECTION_PROXIMITY_ENUM_OBJECT:
				return convertConnectionProximityEnumObjectToString(eDataType, instanceValue);
			case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES_OBJECT:
				return convertDataSourceHelperClassNamesObjectToString(eDataType, instanceValue);
			case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM_OBJECT:
				return convertDB2DataSourceTemplateEnumObjectToString(eDataType, instanceValue);
			case WasPackage.DB2_JDBC_PROVIDER_TYPE_OBJECT:
				return convertDB2JdbcProviderTypeObjectToString(eDataType, instanceValue);
			case WasPackage.DERBY_JDBC_PROVIDER_TYPE_TYPE_OBJECT:
				return convertDerbyJdbcProviderTypeTypeObjectToString(eDataType, instanceValue);
			case WasPackage.END_POINT_LISTENER_NAME_ENUM_OBJECT:
				return convertEndPointListenerNameEnumObjectToString(eDataType, instanceValue);
			case WasPackage.IIOP_SECURITY_PROTOCOLS_OBJECT:
				return convertIIOPSecurityProtocolsObjectToString(eDataType, instanceValue);
			case WasPackage.JDBC_IMPLEMENTATION_TYPE_TYPE_OBJECT:
				return convertJdbcImplementationTypeTypeObjectToString(eDataType, instanceValue);
			case WasPackage.JMS_DESTINATION_TYPE_ENUM_OBJECT:
				return convertJMSDestinationTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.LDAP_DIRECTORY_TYPE_OBJECT:
				return convertLDAPDirectoryTypeObjectToString(eDataType, instanceValue);
			case WasPackage.MESSAGE_RELIABILITY_ENUM_OBJECT:
				return convertMessageReliabilityEnumObjectToString(eDataType, instanceValue);
			case WasPackage.POLICIES_OBJECT:
				return convertPoliciesObjectToString(eDataType, instanceValue);
			case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM_OBJECT:
				return convertReadAheadOptimizationEnumObjectToString(eDataType, instanceValue);
			case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM_OBJECT:
				return convertShareDurableSubscriptionsEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAR_CLASSLOADER_POLICY_OBJECT:
				return convertWARClassloaderPolicyObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_ACCOUNT_TYPE_ENUM_OBJECT:
				return convertWasAccountTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_APPLICATION_MAP_OBJECT:
				return convertWasApplicationMapObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_DEFAULT_SECURITY_SUBJECT_ENUM_OBJECT:
				return convertWasDefaultSecuritySubjectEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES_OBJECT:
				return convertWasDeploymentManagerPortNamesObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_EDITION_ENUM_OBJECT:
				return convertWasEditionEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_ENDPOINT_LISTENER_TYPE_OBJECT:
				return convertWasEndpointListenerTypeObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_NODE_GROUP_TYPE_ENUM_OBJECT:
				return convertWasNodeGroupTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_NODE_PORT_NAMES_OBJECT:
				return convertWasNodePortNamesObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_PROFILE_TYPE_ENUM_OBJECT:
				return convertWasProfileTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM_OBJECT:
				return convertWasRoutingDefinitionTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM_OBJECT:
				return convertWasSibDestinationTypeEnumObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_USER_REGISTRY_TYPES_OBJECT:
				return convertWasUserRegistryTypesObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_NODE_TYPE_OBJECT:
				return convertWasWebServerNodeTypeObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_OS_OBJECT:
				return convertWasWebServerOSObjectToString(eDataType, instanceValue);
			case WasPackage.WAS_WEB_SERVER_TYPE_OBJECT:
				return convertWasWebServerTypeObjectToString(eDataType, instanceValue);
			case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES_OBJECT:
				return convertWebsphereAppServerPortNamesObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Classloader createClassloader() {
		ClassloaderImpl classloader = new ClassloaderImpl();
		return classloader;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProvider createDB2JdbcProvider() {
		DB2JdbcProviderImpl db2JdbcProvider = new DB2JdbcProviderImpl();
		return db2JdbcProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProviderUnit createDB2JdbcProviderUnit() {
		DB2JdbcProviderUnitImpl db2JdbcProviderUnit = new DB2JdbcProviderUnitImpl();
		return db2JdbcProviderUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProvider createDerbyJdbcProvider() {
		DerbyJdbcProviderImpl derbyJdbcProvider = new DerbyJdbcProviderImpl();
		return derbyJdbcProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProviderUnit createDerbyJdbcProviderUnit() {
		DerbyJdbcProviderUnitImpl derbyJdbcProviderUnit = new DerbyJdbcProviderUnitImpl();
		return derbyJdbcProviderUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedJdbcProvider createExtendedJdbcProvider() {
		ExtendedJdbcProviderImpl extendedJdbcProvider = new ExtendedJdbcProviderImpl();
		return extendedJdbcProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedJdbcProviderUnit createExtendedJdbcProviderUnit() {
		ExtendedJdbcProviderUnitImpl extendedJdbcProviderUnit = new ExtendedJdbcProviderUnitImpl();
		return extendedJdbcProviderUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HostNameAliasType createHostNameAliasType() {
		HostNameAliasTypeImpl hostNameAliasType = new HostNameAliasTypeImpl();
		return hostNameAliasType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SharedLibraryEntry createSharedLibraryEntry() {
		SharedLibraryEntryImpl sharedLibraryEntry = new SharedLibraryEntryImpl();
		return sharedLibraryEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualHostType createVirtualHostType() {
		VirtualHostTypeImpl virtualHostType = new VirtualHostTypeImpl();
		return virtualHostType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasAdvancedLdapConfiguration createWasAdvancedLdapConfiguration() {
		WasAdvancedLdapConfigurationImpl wasAdvancedLdapConfiguration = new WasAdvancedLdapConfigurationImpl();
		return wasAdvancedLdapConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationClassLoaderPolicy createWasApplicationClassLoaderPolicy() {
		WasApplicationClassLoaderPolicyImpl wasApplicationClassLoaderPolicy = new WasApplicationClassLoaderPolicyImpl();
		return wasApplicationClassLoaderPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationExt createWasApplicationExt() {
		WasApplicationExtImpl wasApplicationExt = new WasApplicationExtImpl();
		return wasApplicationExt;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationServerClassLoaderPolicy createWasApplicationServerClassLoaderPolicy() {
		WasApplicationServerClassLoaderPolicyImpl wasApplicationServerClassLoaderPolicy = new WasApplicationServerClassLoaderPolicyImpl();
		return wasApplicationServerClassLoaderPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCell createWasCell() {
		WasCellImpl wasCell = new WasCellImpl();
		return wasCell;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCellUnit createWasCellUnit() {
		WasCellUnitImpl wasCellUnit = new WasCellUnitImpl();
		return wasCellUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClassLoaderConfigurationUnit createWasClassLoaderConfigurationUnit() {
		WasClassLoaderConfigurationUnitImpl wasClassLoaderConfigurationUnit = new WasClassLoaderConfigurationUnitImpl();
		return wasClassLoaderConfigurationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClassLoaderPolicy createWasClassLoaderPolicy() {
		WasClassLoaderPolicyImpl wasClassLoaderPolicy = new WasClassLoaderPolicyImpl();
		return wasClassLoaderPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasCluster createWasCluster() {
		WasClusterImpl wasCluster = new WasClusterImpl();
		return wasCluster;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasClusterUnit createWasClusterUnit() {
		WasClusterUnitImpl wasClusterUnit = new WasClusterUnitImpl();
		return wasClusterUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasConfigurationContainer createWasConfigurationContainer() {
		WasConfigurationContainerImpl wasConfigurationContainer = new WasConfigurationContainerImpl();
		return wasConfigurationContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDatasource createWasDatasource() {
		WasDatasourceImpl wasDatasource = new WasDatasourceImpl();
		return wasDatasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDatasourceUnit createWasDatasourceUnit() {
		WasDatasourceUnitImpl wasDatasourceUnit = new WasDatasourceUnitImpl();
		return wasDatasourceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingConnectionFactoryConfiguration createWasDefaultMessagingConnectionFactoryConfiguration() {
		WasDefaultMessagingConnectionFactoryConfigurationImpl wasDefaultMessagingConnectionFactoryConfiguration = new WasDefaultMessagingConnectionFactoryConfigurationImpl();
		return wasDefaultMessagingConnectionFactoryConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingConnectionFactoryUnit createWasDefaultMessagingConnectionFactoryUnit() {
		WasDefaultMessagingConnectionFactoryUnitImpl wasDefaultMessagingConnectionFactoryUnit = new WasDefaultMessagingConnectionFactoryUnitImpl();
		return wasDefaultMessagingConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueConnectionFactoryConfiguration createWasDefaultMessagingQueueConnectionFactoryConfiguration() {
		WasDefaultMessagingQueueConnectionFactoryConfigurationImpl wasDefaultMessagingQueueConnectionFactoryConfiguration = new WasDefaultMessagingQueueConnectionFactoryConfigurationImpl();
		return wasDefaultMessagingQueueConnectionFactoryConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueConnectionFactoryUnit createWasDefaultMessagingQueueConnectionFactoryUnit() {
		WasDefaultMessagingQueueConnectionFactoryUnitImpl wasDefaultMessagingQueueConnectionFactoryUnit = new WasDefaultMessagingQueueConnectionFactoryUnitImpl();
		return wasDefaultMessagingQueueConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueDestination createWasDefaultMessagingQueueDestination() {
		WasDefaultMessagingQueueDestinationImpl wasDefaultMessagingQueueDestination = new WasDefaultMessagingQueueDestinationImpl();
		return wasDefaultMessagingQueueDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingQueueDestinationUnit createWasDefaultMessagingQueueDestinationUnit() {
		WasDefaultMessagingQueueDestinationUnitImpl wasDefaultMessagingQueueDestinationUnit = new WasDefaultMessagingQueueDestinationUnitImpl();
		return wasDefaultMessagingQueueDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicConnectionFactoryConfiguration createWasDefaultMessagingTopicConnectionFactoryConfiguration() {
		WasDefaultMessagingTopicConnectionFactoryConfigurationImpl wasDefaultMessagingTopicConnectionFactoryConfiguration = new WasDefaultMessagingTopicConnectionFactoryConfigurationImpl();
		return wasDefaultMessagingTopicConnectionFactoryConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicConnectionFactoryUnit createWasDefaultMessagingTopicConnectionFactoryUnit() {
		WasDefaultMessagingTopicConnectionFactoryUnitImpl wasDefaultMessagingTopicConnectionFactoryUnit = new WasDefaultMessagingTopicConnectionFactoryUnitImpl();
		return wasDefaultMessagingTopicConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicDestination createWasDefaultMessagingTopicDestination() {
		WasDefaultMessagingTopicDestinationImpl wasDefaultMessagingTopicDestination = new WasDefaultMessagingTopicDestinationImpl();
		return wasDefaultMessagingTopicDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingTopicDestinationUnit createWasDefaultMessagingTopicDestinationUnit() {
		WasDefaultMessagingTopicDestinationUnitImpl wasDefaultMessagingTopicDestinationUnit = new WasDefaultMessagingTopicDestinationUnitImpl();
		return wasDefaultMessagingTopicDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManager createWasDeploymentManager() {
		WasDeploymentManagerImpl wasDeploymentManager = new WasDeploymentManagerImpl();
		return wasDeploymentManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManagerUnit createWasDeploymentManagerUnit() {
		WasDeploymentManagerUnitImpl wasDeploymentManagerUnit = new WasDeploymentManagerUnitImpl();
		return wasDeploymentManagerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeployRoot createWasDeployRoot() {
		WasDeployRootImpl wasDeployRoot = new WasDeployRootImpl();
		return wasDeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasEarClassloaderPolicyConstraint createWasEarClassloaderPolicyConstraint() {
		WasEarClassloaderPolicyConstraintImpl wasEarClassloaderPolicyConstraint = new WasEarClassloaderPolicyConstraintImpl();
		return wasEarClassloaderPolicyConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerConfiguration createWasEndpointListenerConfiguration() {
		WasEndpointListenerConfigurationImpl wasEndpointListenerConfiguration = new WasEndpointListenerConfigurationImpl();
		return wasEndpointListenerConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerUnit createWasEndpointListenerUnit() {
		WasEndpointListenerUnitImpl wasEndpointListenerUnit = new WasEndpointListenerUnitImpl();
		return wasEndpointListenerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasHandlerList createWasHandlerList() {
		WasHandlerListImpl wasHandlerList = new WasHandlerListImpl();
		return wasHandlerList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WASJ2CAuthenticationDataEntry createWASJ2CAuthenticationDataEntry() {
		WASJ2CAuthenticationDataEntryImpl wasj2CAuthenticationDataEntry = new WASJ2CAuthenticationDataEntryImpl();
		return wasj2CAuthenticationDataEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WASJ2CAuthenticationUnit createWASJ2CAuthenticationUnit() {
		WASJ2CAuthenticationUnitImpl wasj2CAuthenticationUnit = new WASJ2CAuthenticationUnitImpl();
		return wasj2CAuthenticationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasJ2EEConstraint createWasJ2EEConstraint() {
		WasJ2EEConstraintImpl wasJ2EEConstraint = new WasJ2EEConstraintImpl();
		return wasJ2EEConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJ2EEServer createWasJ2EEServer() {
		WasJ2EEServerImpl wasJ2EEServer = new WasJ2EEServerImpl();
		return wasJ2EEServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJMSActivationSpecification createWasJMSActivationSpecification() {
		WasJMSActivationSpecificationImpl wasJMSActivationSpecification = new WasJMSActivationSpecificationImpl();
		return wasJMSActivationSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasJMSActivationSpecificationUnit createWasJMSActivationSpecificationUnit() {
		WasJMSActivationSpecificationUnitImpl wasJMSActivationSpecificationUnit = new WasJMSActivationSpecificationUnitImpl();
		return wasJMSActivationSpecificationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasJNDIBindingConstraint createWasJNDIBindingConstraint() {
		WasJNDIBindingConstraintImpl wasJNDIBindingConstraint = new WasJNDIBindingConstraintImpl();
		return wasJNDIBindingConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasLdapConfiguration createWasLdapConfiguration() {
		WasLdapConfigurationImpl wasLdapConfiguration = new WasLdapConfigurationImpl();
		return wasLdapConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasLdapConfigurationUnit createWasLdapConfigurationUnit() {
		WasLdapConfigurationUnitImpl wasLdapConfigurationUnit = new WasLdapConfigurationUnitImpl();
		return wasLdapConfigurationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasMessagingEngine createWasMessagingEngine() {
		WasMessagingEngineImpl wasMessagingEngine = new WasMessagingEngineImpl();
		return wasMessagingEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasMessagingEngineUnit createWasMessagingEngineUnit() {
		WasMessagingEngineUnitImpl wasMessagingEngineUnit = new WasMessagingEngineUnitImpl();
		return wasMessagingEngineUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleClassLoaderPolicy createWasModuleClassLoaderPolicy() {
		WasModuleClassLoaderPolicyImpl wasModuleClassLoaderPolicy = new WasModuleClassLoaderPolicyImpl();
		return wasModuleClassLoaderPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleClassloaderPolicyConstraint createWasModuleClassloaderPolicyConstraint() {
		WasModuleClassloaderPolicyConstraintImpl wasModuleClassloaderPolicyConstraint = new WasModuleClassloaderPolicyConstraintImpl();
		return wasModuleClassloaderPolicyConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasModuleStartWeightConstraint createWasModuleStartWeightConstraint() {
		WasModuleStartWeightConstraintImpl wasModuleStartWeightConstraint = new WasModuleStartWeightConstraintImpl();
		return wasModuleStartWeightConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNode createWasNode() {
		WasNodeImpl wasNode = new WasNodeImpl();
		return wasNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroup createWasNodeGroup() {
		WasNodeGroupImpl wasNodeGroup = new WasNodeGroupImpl();
		return wasNodeGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroupUnit createWasNodeGroupUnit() {
		WasNodeGroupUnitImpl wasNodeGroupUnit = new WasNodeGroupUnitImpl();
		return wasNodeGroupUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeUnit createWasNodeUnit() {
		WasNodeUnitImpl wasNodeUnit = new WasNodeUnitImpl();
		return wasNodeUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeWindowsServiceUnit createWasNodeWindowsServiceUnit() {
		WasNodeWindowsServiceUnitImpl wasNodeWindowsServiceUnit = new WasNodeWindowsServiceUnitImpl();
		return wasNodeWindowsServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasPluginAdmin createWasPluginAdmin() {
		WasPluginAdminImpl wasPluginAdmin = new WasPluginAdminImpl();
		return wasPluginAdmin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasPluginRedirection createWasPluginRedirection() {
		WasPluginRedirectionImpl wasPluginRedirection = new WasPluginRedirectionImpl();
		return wasPluginRedirection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecurity createWasSecurity() {
		WasSecurityImpl wasSecurity = new WasSecurityImpl();
		return wasSecurity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecuritySubject createWasSecuritySubject() {
		WasSecuritySubjectImpl wasSecuritySubject = new WasSecuritySubjectImpl();
		return wasSecuritySubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasSecuritySubjectConstraint createWasSecuritySubjectConstraint() {
		WasSecuritySubjectConstraintImpl wasSecuritySubjectConstraint = new WasSecuritySubjectConstraintImpl();
		return wasSecuritySubjectConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasServer createWasServer() {
		WasServerImpl wasServer = new WasServerImpl();
		return wasServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSharedLibContainer createWasSharedLibContainer() {
		WasSharedLibContainerImpl wasSharedLibContainer = new WasSharedLibContainerImpl();
		return wasSharedLibContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSharedLibraryEntryUnit createWasSharedLibraryEntryUnit() {
		WasSharedLibraryEntryUnitImpl wasSharedLibraryEntryUnit = new WasSharedLibraryEntryUnitImpl();
		return wasSharedLibraryEntryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestination createWasSibDestination() {
		WasSibDestinationImpl wasSibDestination = new WasSibDestinationImpl();
		return wasSibDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestinationUnit createWasSibDestinationUnit() {
		WasSibDestinationUnitImpl wasSibDestinationUnit = new WasSibDestinationUnitImpl();
		return wasSibDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibForeignBus createWasSibForeignBus() {
		WasSibForeignBusImpl wasSibForeignBus = new WasSibForeignBusImpl();
		return wasSibForeignBus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundPort createWasSibInboundPort() {
		WasSibInboundPortImpl wasSibInboundPort = new WasSibInboundPortImpl();
		return wasSibInboundPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundPortUnit createWasSibInboundPortUnit() {
		WasSibInboundPortUnitImpl wasSibInboundPortUnit = new WasSibInboundPortUnitImpl();
		return wasSibInboundPortUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundService createWasSibInboundService() {
		WasSibInboundServiceImpl wasSibInboundService = new WasSibInboundServiceImpl();
		return wasSibInboundService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibInboundServiceUnit createWasSibInboundServiceUnit() {
		WasSibInboundServiceUnitImpl wasSibInboundServiceUnit = new WasSibInboundServiceUnitImpl();
		return wasSibInboundServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibMediation createWasSibMediation() {
		WasSibMediationImpl wasSibMediation = new WasSibMediationImpl();
		return wasSibMediation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibMediationUnit createWasSibMediationUnit() {
		WasSibMediationUnitImpl wasSibMediationUnit = new WasSibMediationUnitImpl();
		return wasSibMediationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundPort createWasSibOutboundPort() {
		WasSibOutboundPortImpl wasSibOutboundPort = new WasSibOutboundPortImpl();
		return wasSibOutboundPort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundPortUnit createWasSibOutboundPortUnit() {
		WasSibOutboundPortUnitImpl wasSibOutboundPortUnit = new WasSibOutboundPortUnitImpl();
		return wasSibOutboundPortUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundService createWasSibOutboundService() {
		WasSibOutboundServiceImpl wasSibOutboundService = new WasSibOutboundServiceImpl();
		return wasSibOutboundService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibOutboundServiceUnit createWasSibOutboundServiceUnit() {
		WasSibOutboundServiceUnitImpl wasSibOutboundServiceUnit = new WasSibOutboundServiceUnitImpl();
		return wasSibOutboundServiceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibServiceIntegrationBusLink createWasSibServiceIntegrationBusLink() {
		WasSibServiceIntegrationBusLinkImpl wasSibServiceIntegrationBusLink = new WasSibServiceIntegrationBusLinkImpl();
		return wasSibServiceIntegrationBusLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSIBus createWasSIBus() {
		WasSIBusImpl wasSIBus = new WasSIBusImpl();
		return wasSIBus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSIBusUnit createWasSIBusUnit() {
		WasSIBusUnitImpl wasSIBusUnit = new WasSIBusUnitImpl();
		return wasSIBusUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSubstitutionVariable createWasSubstitutionVariable() {
		WasSubstitutionVariableImpl wasSubstitutionVariable = new WasSubstitutionVariableImpl();
		return wasSubstitutionVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSystem createWasSystem() {
		WasSystemImpl wasSystem = new WasSystemImpl();
		return wasSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSystemUnit createWasSystemUnit() {
		WasSystemUnitImpl wasSystemUnit = new WasSystemUnitImpl();
		return wasSystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV4Datasource createWasV4Datasource() {
		WasV4DatasourceImpl wasV4Datasource = new WasV4DatasourceImpl();
		return wasV4Datasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5Datasource createWasV5Datasource() {
		WasV5DatasourceImpl wasV5Datasource = new WasV5DatasourceImpl();
		return wasV5Datasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5DB2Datasource createWasV5DB2Datasource() {
		WasV5DB2DatasourceImpl wasV5DB2Datasource = new WasV5DB2DatasourceImpl();
		return wasV5DB2Datasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasV5DB2ZosDatasource createWasV5DB2ZosDatasource() {
		WasV5DB2ZosDatasourceImpl wasV5DB2ZosDatasource = new WasV5DB2ZosDatasourceImpl();
		return wasV5DB2ZosDatasource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasWarClassloaderPolicyConstraint createWasWarClassloaderPolicyConstraint() {
		WasWarClassloaderPolicyConstraintImpl wasWarClassloaderPolicyConstraint = new WasWarClassloaderPolicyConstraintImpl();
		return wasWarClassloaderPolicyConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebAppExt createWasWebAppExt() {
		WasWebAppExtImpl wasWebAppExt = new WasWebAppExtImpl();
		return wasWebAppExt;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServer createWasWebServer() {
		WasWebServerImpl wasWebServer = new WasWebServerImpl();
		return wasWebServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerManagement createWasWebServerManagement() {
		WasWebServerManagementImpl wasWebServerManagement = new WasWebServerManagementImpl();
		return wasWebServerManagement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerPlugin createWasWebServerPlugin() {
		WasWebServerPluginImpl wasWebServerPlugin = new WasWebServerPluginImpl();
		return wasWebServerPlugin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerUnit createWasWebServerUnit() {
		WasWebServerUnitImpl wasWebServerUnit = new WasWebServerUnitImpl();
		return wasWebServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebsphereAppServerUnit createWebsphereAppServerUnit() {
		WebsphereAppServerUnitImpl websphereAppServerUnit = new WebsphereAppServerUnitImpl();
		return websphereAppServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AcknowledgeModeEnum createAcknowledgeModeEnumFromString(EDataType eDataType,
			String initialValue) {
		AcknowledgeModeEnum result = AcknowledgeModeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAcknowledgeModeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CertificateMapMode createCertificateMapModeFromString(EDataType eDataType,
			String initialValue) {
		CertificateMapMode result = CertificateMapMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCertificateMapModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CFTargetSignificanceEnum createCFTargetSignificanceEnumFromString(EDataType eDataType,
			String initialValue) {
		CFTargetSignificanceEnum result = CFTargetSignificanceEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCFTargetSignificanceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderMode createClassloaderModeFromString(EDataType eDataType, String initialValue) {
		ClassloaderMode result = ClassloaderMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassloaderModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderPolicyType createClassloaderPolicyTypeFromString(EDataType eDataType,
			String initialValue) {
		ClassloaderPolicyType result = ClassloaderPolicyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassloaderPolicyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionDeliveryModeEnum createConnectionDeliveryModeEnumFromString(
			EDataType eDataType, String initialValue) {
		ConnectionDeliveryModeEnum result = ConnectionDeliveryModeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionDeliveryModeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactoryTargetTypeEnum createConnectionFactoryTargetTypeEnumFromString(
			EDataType eDataType, String initialValue) {
		ConnectionFactoryTargetTypeEnum result = ConnectionFactoryTargetTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionFactoryTargetTypeEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionProximityEnum createConnectionProximityEnumFromString(EDataType eDataType,
			String initialValue) {
		ConnectionProximityEnum result = ConnectionProximityEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionProximityEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceHelperClassNames createDataSourceHelperClassNamesFromString(
			EDataType eDataType, String initialValue) {
		DataSourceHelperClassNames result = DataSourceHelperClassNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataSourceHelperClassNamesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DataSourceTemplateEnum createDB2DataSourceTemplateEnumFromString(EDataType eDataType,
			String initialValue) {
		DB2DataSourceTemplateEnum result = DB2DataSourceTemplateEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2DataSourceTemplateEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProviderType createDB2JdbcProviderTypeFromString(EDataType eDataType,
			String initialValue) {
		DB2JdbcProviderType result = DB2JdbcProviderType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2JdbcProviderTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProviderTypeType createDerbyJdbcProviderTypeTypeFromString(EDataType eDataType,
			String initialValue) {
		DerbyJdbcProviderTypeType result = DerbyJdbcProviderTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDerbyJdbcProviderTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointListenerNameEnum createEndPointListenerNameEnumFromString(EDataType eDataType,
			String initialValue) {
		EndPointListenerNameEnum result = EndPointListenerNameEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointListenerNameEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IIOPSecurityProtocols createIIOPSecurityProtocolsFromString(EDataType eDataType,
			String initialValue) {
		IIOPSecurityProtocols result = IIOPSecurityProtocols.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIIOPSecurityProtocolsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcImplementationTypeType createJdbcImplementationTypeTypeFromString(
			EDataType eDataType, String initialValue) {
		JdbcImplementationTypeType result = JdbcImplementationTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJdbcImplementationTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSDestinationTypeEnum createJMSDestinationTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		JMSDestinationTypeEnum result = JMSDestinationTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSDestinationTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LDAPDirectoryType createLDAPDirectoryTypeFromString(EDataType eDataType,
			String initialValue) {
		LDAPDirectoryType result = LDAPDirectoryType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLDAPDirectoryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MessageReliabilityEnum createMessageReliabilityEnumFromString(EDataType eDataType,
			String initialValue) {
		MessageReliabilityEnum result = MessageReliabilityEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageReliabilityEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Policies createPoliciesFromString(EDataType eDataType, String initialValue) {
		Policies result = Policies.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPoliciesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReadAheadOptimizationEnum createReadAheadOptimizationEnumFromString(EDataType eDataType,
			String initialValue) {
		ReadAheadOptimizationEnum result = ReadAheadOptimizationEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReadAheadOptimizationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShareDurableSubscriptionsEnum createShareDurableSubscriptionsEnumFromString(
			EDataType eDataType, String initialValue) {
		ShareDurableSubscriptionsEnum result = ShareDurableSubscriptionsEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShareDurableSubscriptionsEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WARClassloaderPolicy createWARClassloaderPolicyFromString(EDataType eDataType,
			String initialValue) {
		WARClassloaderPolicy result = WARClassloaderPolicy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWARClassloaderPolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasAccountTypeEnum createWasAccountTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		WasAccountTypeEnum result = WasAccountTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasAccountTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationMap createWasApplicationMapFromString(EDataType eDataType,
			String initialValue) {
		WasApplicationMap result = WasApplicationMap.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasApplicationMapToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultSecuritySubjectEnum createWasDefaultSecuritySubjectEnumFromString(EDataType eDataType, String initialValue) {
		WasDefaultSecuritySubjectEnum result = WasDefaultSecuritySubjectEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasDefaultSecuritySubjectEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManagerPortNames createWasDeploymentManagerPortNamesFromString(
			EDataType eDataType, String initialValue) {
		WasDeploymentManagerPortNames result = WasDeploymentManagerPortNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasDeploymentManagerPortNamesToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEditionEnum createWasEditionEnumFromString(EDataType eDataType, String initialValue) {
		WasEditionEnum result = WasEditionEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasEditionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerType createWasEndpointListenerTypeFromString(EDataType eDataType,
			String initialValue) {
		WasEndpointListenerType result = WasEndpointListenerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasEndpointListenerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroupTypeEnum createWasNodeGroupTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		WasNodeGroupTypeEnum result = WasNodeGroupTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasNodeGroupTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodePortNames createWasNodePortNamesFromString(EDataType eDataType, String initialValue) {
		WasNodePortNames result = WasNodePortNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasNodePortNamesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasProfileTypeEnum createWasProfileTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		WasProfileTypeEnum result = WasProfileTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasProfileTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasRoutingDefinitionTypeEnum createWasRoutingDefinitionTypeEnumFromString(
			EDataType eDataType, String initialValue) {
		WasRoutingDefinitionTypeEnum result = WasRoutingDefinitionTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasRoutingDefinitionTypeEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestinationTypeEnum createWasSibDestinationTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		WasSibDestinationTypeEnum result = WasSibDestinationTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasSibDestinationTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasUserRegistryTypes createWasUserRegistryTypesFromString(EDataType eDataType, String initialValue) {
		WasUserRegistryTypes result = WasUserRegistryTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasUserRegistryTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerNodeType createWasWebServerNodeTypeFromString(EDataType eDataType,
			String initialValue) {
		WasWebServerNodeType result = WasWebServerNodeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerNodeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerOS createWasWebServerOSFromString(EDataType eDataType, String initialValue) {
		WasWebServerOS result = WasWebServerOS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerOSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerType createWasWebServerTypeFromString(EDataType eDataType, String initialValue) {
		WasWebServerType result = WasWebServerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebsphereAppServerPortNames createWebsphereAppServerPortNamesFromString(
			EDataType eDataType, String initialValue) {
		WebsphereAppServerPortNames result = WebsphereAppServerPortNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWebsphereAppServerPortNamesToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AcknowledgeModeEnum createAcknowledgeModeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createAcknowledgeModeEnumFromString(WasPackage.Literals.ACKNOWLEDGE_MODE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAcknowledgeModeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAcknowledgeModeEnumToString(WasPackage.Literals.ACKNOWLEDGE_MODE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CertificateMapMode createCertificateMapModeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createCertificateMapModeFromString(WasPackage.Literals.CERTIFICATE_MAP_MODE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCertificateMapModeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertCertificateMapModeToString(WasPackage.Literals.CERTIFICATE_MAP_MODE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CFTargetSignificanceEnum createCFTargetSignificanceEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createCFTargetSignificanceEnumFromString(WasPackage.Literals.CF_TARGET_SIGNIFICANCE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCFTargetSignificanceEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertCFTargetSignificanceEnumToString(WasPackage.Literals.CF_TARGET_SIGNIFICANCE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderMode createClassloaderModeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createClassloaderModeFromString(WasPackage.Literals.CLASSLOADER_MODE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassloaderModeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertClassloaderModeToString(WasPackage.Literals.CLASSLOADER_MODE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassloaderPolicyType createClassloaderPolicyTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createClassloaderPolicyTypeFromString(WasPackage.Literals.CLASSLOADER_POLICY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassloaderPolicyTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertClassloaderPolicyTypeToString(WasPackage.Literals.CLASSLOADER_POLICY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionDeliveryModeEnum createConnectionDeliveryModeEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createConnectionDeliveryModeEnumFromString(WasPackage.Literals.CONNECTION_DELIVERY_MODE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionDeliveryModeEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertConnectionDeliveryModeEnumToString(WasPackage.Literals.CONNECTION_DELIVERY_MODE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactoryTargetTypeEnum createConnectionFactoryTargetTypeEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createConnectionFactoryTargetTypeEnumFromString(WasPackage.Literals.CONNECTION_FACTORY_TARGET_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionFactoryTargetTypeEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertConnectionFactoryTargetTypeEnumToString(WasPackage.Literals.CONNECTION_FACTORY_TARGET_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionProximityEnum createConnectionProximityEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createConnectionProximityEnumFromString(WasPackage.Literals.CONNECTION_PROXIMITY_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionProximityEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertConnectionProximityEnumToString(WasPackage.Literals.CONNECTION_PROXIMITY_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceHelperClassNames createDataSourceHelperClassNamesObjectFromString(
			EDataType eDataType, String initialValue) {
		return createDataSourceHelperClassNamesFromString(WasPackage.Literals.DATA_SOURCE_HELPER_CLASS_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataSourceHelperClassNamesObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertDataSourceHelperClassNamesToString(WasPackage.Literals.DATA_SOURCE_HELPER_CLASS_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DataSourceTemplateEnum createDB2DataSourceTemplateEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createDB2DataSourceTemplateEnumFromString(WasPackage.Literals.DB2_DATA_SOURCE_TEMPLATE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2DataSourceTemplateEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertDB2DataSourceTemplateEnumToString(WasPackage.Literals.DB2_DATA_SOURCE_TEMPLATE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcProviderType createDB2JdbcProviderTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createDB2JdbcProviderTypeFromString(WasPackage.Literals.DB2_JDBC_PROVIDER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2JdbcProviderTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDB2JdbcProviderTypeToString(WasPackage.Literals.DB2_JDBC_PROVIDER_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyJdbcProviderTypeType createDerbyJdbcProviderTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createDerbyJdbcProviderTypeTypeFromString(WasPackage.Literals.DERBY_JDBC_PROVIDER_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDerbyJdbcProviderTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertDerbyJdbcProviderTypeTypeToString(WasPackage.Literals.DERBY_JDBC_PROVIDER_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointListenerNameEnum createEndPointListenerNameEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createEndPointListenerNameEnumFromString(WasPackage.Literals.END_POINT_LISTENER_NAME_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointListenerNameEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertEndPointListenerNameEnumToString(WasPackage.Literals.END_POINT_LISTENER_NAME_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IIOPSecurityProtocols createIIOPSecurityProtocolsObjectFromString(EDataType eDataType,
			String initialValue) {
		return createIIOPSecurityProtocolsFromString(WasPackage.Literals.IIOP_SECURITY_PROTOCOLS, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIIOPSecurityProtocolsObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertIIOPSecurityProtocolsToString(WasPackage.Literals.IIOP_SECURITY_PROTOCOLS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcImplementationTypeType createJdbcImplementationTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createJdbcImplementationTypeTypeFromString(WasPackage.Literals.JDBC_IMPLEMENTATION_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJdbcImplementationTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertJdbcImplementationTypeTypeToString(WasPackage.Literals.JDBC_IMPLEMENTATION_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSDestinationTypeEnum createJMSDestinationTypeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createJMSDestinationTypeEnumFromString(WasPackage.Literals.JMS_DESTINATION_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSDestinationTypeEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertJMSDestinationTypeEnumToString(WasPackage.Literals.JMS_DESTINATION_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LDAPDirectoryType createLDAPDirectoryTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createLDAPDirectoryTypeFromString(WasPackage.Literals.LDAP_DIRECTORY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLDAPDirectoryTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLDAPDirectoryTypeToString(WasPackage.Literals.LDAP_DIRECTORY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MessageReliabilityEnum createMessageReliabilityEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createMessageReliabilityEnumFromString(WasPackage.Literals.MESSAGE_RELIABILITY_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageReliabilityEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertMessageReliabilityEnumToString(WasPackage.Literals.MESSAGE_RELIABILITY_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Policies createPoliciesObjectFromString(EDataType eDataType, String initialValue) {
		return createPoliciesFromString(WasPackage.Literals.POLICIES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPoliciesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPoliciesToString(WasPackage.Literals.POLICIES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReadAheadOptimizationEnum createReadAheadOptimizationEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createReadAheadOptimizationEnumFromString(WasPackage.Literals.READ_AHEAD_OPTIMIZATION_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReadAheadOptimizationEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertReadAheadOptimizationEnumToString(WasPackage.Literals.READ_AHEAD_OPTIMIZATION_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShareDurableSubscriptionsEnum createShareDurableSubscriptionsEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createShareDurableSubscriptionsEnumFromString(WasPackage.Literals.SHARE_DURABLE_SUBSCRIPTIONS_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShareDurableSubscriptionsEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertShareDurableSubscriptionsEnumToString(WasPackage.Literals.SHARE_DURABLE_SUBSCRIPTIONS_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WARClassloaderPolicy createWARClassloaderPolicyObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWARClassloaderPolicyFromString(WasPackage.Literals.WAR_CLASSLOADER_POLICY, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWARClassloaderPolicyObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWARClassloaderPolicyToString(WasPackage.Literals.WAR_CLASSLOADER_POLICY, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasAccountTypeEnum createWasAccountTypeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasAccountTypeEnumFromString(WasPackage.Literals.WAS_ACCOUNT_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasAccountTypeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasAccountTypeEnumToString(WasPackage.Literals.WAS_ACCOUNT_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasApplicationMap createWasApplicationMapObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasApplicationMapFromString(WasPackage.Literals.WAS_APPLICATION_MAP, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasApplicationMapObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasApplicationMapToString(WasPackage.Literals.WAS_APPLICATION_MAP, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasDefaultSecuritySubjectEnum createWasDefaultSecuritySubjectEnumObjectFromString(EDataType eDataType, String initialValue) {
		return createWasDefaultSecuritySubjectEnumFromString(WasPackage.Literals.WAS_DEFAULT_SECURITY_SUBJECT_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasDefaultSecuritySubjectEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasDefaultSecuritySubjectEnumToString(WasPackage.Literals.WAS_DEFAULT_SECURITY_SUBJECT_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasDeploymentManagerPortNames createWasDeploymentManagerPortNamesObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWasDeploymentManagerPortNamesFromString(WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_PORT_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasDeploymentManagerPortNamesObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWasDeploymentManagerPortNamesToString(WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_PORT_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEditionEnum createWasEditionEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasEditionEnumFromString(WasPackage.Literals.WAS_EDITION_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasEditionEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasEditionEnumToString(WasPackage.Literals.WAS_EDITION_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEndpointListenerType createWasEndpointListenerTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWasEndpointListenerTypeFromString(WasPackage.Literals.WAS_ENDPOINT_LISTENER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasEndpointListenerTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWasEndpointListenerTypeToString(WasPackage.Literals.WAS_ENDPOINT_LISTENER_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodeGroupTypeEnum createWasNodeGroupTypeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasNodeGroupTypeEnumFromString(WasPackage.Literals.WAS_NODE_GROUP_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasNodeGroupTypeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasNodeGroupTypeEnumToString(WasPackage.Literals.WAS_NODE_GROUP_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasNodePortNames createWasNodePortNamesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasNodePortNamesFromString(WasPackage.Literals.WAS_NODE_PORT_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasNodePortNamesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasNodePortNamesToString(WasPackage.Literals.WAS_NODE_PORT_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasProfileTypeEnum createWasProfileTypeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasProfileTypeEnumFromString(WasPackage.Literals.WAS_PROFILE_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasProfileTypeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasProfileTypeEnumToString(WasPackage.Literals.WAS_PROFILE_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasRoutingDefinitionTypeEnum createWasRoutingDefinitionTypeEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWasRoutingDefinitionTypeEnumFromString(WasPackage.Literals.WAS_ROUTING_DEFINITION_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasRoutingDefinitionTypeEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWasRoutingDefinitionTypeEnumToString(WasPackage.Literals.WAS_ROUTING_DEFINITION_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSibDestinationTypeEnum createWasSibDestinationTypeEnumObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWasSibDestinationTypeEnumFromString(WasPackage.Literals.WAS_SIB_DESTINATION_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasSibDestinationTypeEnumObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWasSibDestinationTypeEnumToString(WasPackage.Literals.WAS_SIB_DESTINATION_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasUserRegistryTypes createWasUserRegistryTypesObjectFromString(EDataType eDataType, String initialValue) {
		return createWasUserRegistryTypesFromString(WasPackage.Literals.WAS_USER_REGISTRY_TYPES, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasUserRegistryTypesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasUserRegistryTypesToString(WasPackage.Literals.WAS_USER_REGISTRY_TYPES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerNodeType createWasWebServerNodeTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasWebServerNodeTypeFromString(WasPackage.Literals.WAS_WEB_SERVER_NODE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerNodeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasWebServerNodeTypeToString(WasPackage.Literals.WAS_WEB_SERVER_NODE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerOS createWasWebServerOSObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasWebServerOSFromString(WasPackage.Literals.WAS_WEB_SERVER_OS, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerOSObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasWebServerOSToString(WasPackage.Literals.WAS_WEB_SERVER_OS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerType createWasWebServerTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createWasWebServerTypeFromString(WasPackage.Literals.WAS_WEB_SERVER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWasWebServerTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWasWebServerTypeToString(WasPackage.Literals.WAS_WEB_SERVER_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WebsphereAppServerPortNames createWebsphereAppServerPortNamesObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWebsphereAppServerPortNamesFromString(WasPackage.Literals.WEBSPHERE_APP_SERVER_PORT_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWebsphereAppServerPortNamesObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWebsphereAppServerPortNamesToString(WasPackage.Literals.WEBSPHERE_APP_SERVER_PORT_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasPackage getWasPackage() {
		return (WasPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static WasPackage getPackage() {
		return WasPackage.eINSTANCE;
	}

} //WasFactoryImpl
