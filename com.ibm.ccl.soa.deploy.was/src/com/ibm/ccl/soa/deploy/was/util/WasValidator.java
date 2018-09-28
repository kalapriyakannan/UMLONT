/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import com.ibm.ccl.soa.deploy.was.*;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage
 * @generated
 */
public class WasValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final WasValidator INSTANCE = new WasValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
	 * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.ibm.ccl.soa.deploy.was"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WasValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EPackage getEPackage() {
		return WasPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map context) {
		switch (classifierID)
		{
		case WasPackage.CLASSLOADER:
			return validateClassloader((Classloader) value, diagnostics, context);
		case WasPackage.DB2_JDBC_PROVIDER:
			return validateDB2JdbcProvider((DB2JdbcProvider) value, diagnostics, context);
		case WasPackage.DB2_JDBC_PROVIDER_UNIT:
			return validateDB2JdbcProviderUnit((DB2JdbcProviderUnit) value, diagnostics, context);
		case WasPackage.HOST_NAME_ALIAS_TYPE:
			return validateHostNameAliasType((HostNameAliasType) value, diagnostics, context);
		case WasPackage.SHARED_LIBRARY_ENTRY:
			return validateSharedLibraryEntry((SharedLibraryEntry) value, diagnostics, context);
		case WasPackage.VIRTUAL_HOST_TYPE:
			return validateVirtualHostType((VirtualHostType) value, diagnostics, context);
		case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION:
			return validateWasAdvancedLdapConfiguration((WasAdvancedLdapConfiguration) value,
					diagnostics, context);
		case WasPackage.WAS_CELL:
			return validateWasCell((WasCell) value, diagnostics, context);
		case WasPackage.WAS_CELL_UNIT:
			return validateWasCellUnit((WasCellUnit) value, diagnostics, context);
		case WasPackage.WAS_CLUSTER:
			return validateWasCluster((WasCluster) value, diagnostics, context);
		case WasPackage.WAS_CLUSTER_UNIT:
			return validateWasClusterUnit((WasClusterUnit) value, diagnostics, context);
		case WasPackage.WAS_CONFIGURATION_CONTAINER:
			return validateWasConfigurationContainer((WasConfigurationContainer) value, diagnostics,
					context);
		case WasPackage.WAS_DATASOURCE:
			return validateWasDatasource((WasDatasource) value, diagnostics, context);
		case WasPackage.WAS_DATASOURCE_UNIT:
			return validateWasDatasourceUnit((WasDatasourceUnit) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION:
			return validateWasDefaultMessagingConnectionFactoryConfiguration(
					(WasDefaultMessagingConnectionFactoryConfiguration) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT:
			return validateWasDefaultMessagingConnectionFactoryUnit(
					(WasDefaultMessagingConnectionFactoryUnit) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION:
			return validateWasDefaultMessagingQueueConnectionFactoryConfiguration(
					(WasDefaultMessagingQueueConnectionFactoryConfiguration) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT:
			return validateWasDefaultMessagingQueueConnectionFactoryUnit(
					(WasDefaultMessagingQueueConnectionFactoryUnit) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION:
			return validateWasDefaultMessagingQueueDestination(
					(WasDefaultMessagingQueueDestination) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT:
			return validateWasDefaultMessagingQueueDestinationUnit(
					(WasDefaultMessagingQueueDestinationUnit) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION:
			return validateWasDefaultMessagingTopicConnectionFactoryConfiguration(
					(WasDefaultMessagingTopicConnectionFactoryConfiguration) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT:
			return validateWasDefaultMessagingTopicConnectionFactoryUnit(
					(WasDefaultMessagingTopicConnectionFactoryUnit) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION:
			return validateWasDefaultMessagingTopicDestination(
					(WasDefaultMessagingTopicDestination) value, diagnostics, context);
		case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT:
			return validateWasDefaultMessagingTopicDestinationUnit(
					(WasDefaultMessagingTopicDestinationUnit) value, diagnostics, context);
		case WasPackage.WAS_DEPLOYMENT_MANAGER:
			return validateWasDeploymentManager((WasDeploymentManager) value, diagnostics, context);
		case WasPackage.WAS_DEPLOYMENT_MANAGER_UNIT:
			return validateWasDeploymentManagerUnit((WasDeploymentManagerUnit) value, diagnostics,
					context);
		case WasPackage.WAS_DEPLOY_ROOT:
			return validateWasDeployRoot((WasDeployRoot) value, diagnostics, context);
		case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION:
			return validateWasEndpointListenerConfiguration((WasEndpointListenerConfiguration) value,
					diagnostics, context);
		case WasPackage.WAS_ENDPOINT_LISTENER_UNIT:
			return validateWasEndpointListenerUnit((WasEndpointListenerUnit) value, diagnostics,
					context);
		case WasPackage.WAS_HANDLER_LIST:
			return validateWasHandlerList((WasHandlerList) value, diagnostics, context);
		case WasPackage.WASJ2C_AUTHENTICATION_DATA_ENTRY:
			return validateWASJ2CAuthenticationDataEntry((WASJ2CAuthenticationDataEntry) value,
					diagnostics, context);
		case WasPackage.WASJ2C_AUTHENTICATION_UNIT:
			return validateWASJ2CAuthenticationUnit((WASJ2CAuthenticationUnit) value, diagnostics,
					context);
		case WasPackage.WAS_J2EE_SERVER:
			return validateWasJ2EEServer((WasJ2EEServer) value, diagnostics, context);
		case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION:
			return validateWasJMSActivationSpecification((WasJMSActivationSpecification) value,
					diagnostics, context);
		case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT:
			return validateWasJMSActivationSpecificationUnit(
					(WasJMSActivationSpecificationUnit) value, diagnostics, context);
		case WasPackage.WAS_LDAP_CONFIGURATION:
			return validateWasLdapConfiguration((WasLdapConfiguration) value, diagnostics, context);
		case WasPackage.WAS_LDAP_CONFIGURATION_UNIT:
			return validateWasLdapConfigurationUnit((WasLdapConfigurationUnit) value, diagnostics,
					context);
		case WasPackage.WAS_NODE:
			return validateWasNode((WasNode) value, diagnostics, context);
		case WasPackage.WAS_NODE_GROUP:
			return validateWasNodeGroup((WasNodeGroup) value, diagnostics, context);
		case WasPackage.WAS_NODE_GROUP_UNIT:
			return validateWasNodeGroupUnit((WasNodeGroupUnit) value, diagnostics, context);
		case WasPackage.WAS_NODE_UNIT:
			return validateWasNodeUnit((WasNodeUnit) value, diagnostics, context);
		case WasPackage.WAS_NODE_WINDOWS_SERVICE_UNIT:
			return validateWasNodeWindowsServiceUnit((WasNodeWindowsServiceUnit) value, diagnostics,
					context);
		case WasPackage.WAS_PLUGIN_ADMIN:
			return validateWasPluginAdmin((WasPluginAdmin) value, diagnostics, context);
		case WasPackage.WAS_PLUGIN_REDIRECTION:
			return validateWasPluginRedirection((WasPluginRedirection) value, diagnostics, context);
		case WasPackage.WAS_SECURITY:
			return validateWasSecurity((WasSecurity) value, diagnostics, context);
		case WasPackage.WAS_SERVER:
			return validateWasServer((WasServer) value, diagnostics, context);
		case WasPackage.WAS_SHARED_LIB_CONTAINER:
			return validateWasSharedLibContainer((WasSharedLibContainer) value, diagnostics, context);
		case WasPackage.WAS_SHARED_LIBRARY_ENTRY_UNIT:
			return validateWasSharedLibraryEntryUnit((WasSharedLibraryEntryUnit) value, diagnostics,
					context);
		case WasPackage.WAS_SIB_DESTINATION:
			return validateWasSibDestination((WasSibDestination) value, diagnostics, context);
		case WasPackage.WAS_SIB_DESTINATION_UNIT:
			return validateWasSibDestinationUnit((WasSibDestinationUnit) value, diagnostics, context);
		case WasPackage.WAS_SIB_FOREIGN_BUS:
			return validateWasSibForeignBus((WasSibForeignBus) value, diagnostics, context);
		case WasPackage.WAS_SIB_INBOUND_PORT:
			return validateWasSibInboundPort((WasSibInboundPort) value, diagnostics, context);
		case WasPackage.WAS_SIB_INBOUND_PORT_UNIT:
			return validateWasSibInboundPortUnit((WasSibInboundPortUnit) value, diagnostics, context);
		case WasPackage.WAS_SIB_INBOUND_SERVICE:
			return validateWasSibInboundService((WasSibInboundService) value, diagnostics, context);
		case WasPackage.WAS_SIB_INBOUND_SERVICE_UNIT:
			return validateWasSibInboundServiceUnit((WasSibInboundServiceUnit) value, diagnostics,
					context);
		case WasPackage.WAS_SIB_MEDIATION:
			return validateWasSibMediation((WasSibMediation) value, diagnostics, context);
		case WasPackage.WAS_SIB_MEDIATION_UNIT:
			return validateWasSibMediationUnit((WasSibMediationUnit) value, diagnostics, context);
		case WasPackage.WAS_SIB_OUTBOUND_PORT:
			return validateWasSibOutboundPort((WasSibOutboundPort) value, diagnostics, context);
		case WasPackage.WAS_SIB_OUTBOUND_PORT_UNIT:
			return validateWasSibOutboundPortUnit((WasSibOutboundPortUnit) value, diagnostics, context);
		case WasPackage.WAS_SIB_OUTBOUND_SERVICE:
			return validateWasSibOutboundService((WasSibOutboundService) value, diagnostics, context);
		case WasPackage.WAS_SIB_OUTBOUND_SERVICE_UNIT:
			return validateWasSibOutboundServiceUnit((WasSibOutboundServiceUnit) value, diagnostics,
					context);
		case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK:
			return validateWasSibServiceIntegrationBusLink((WasSibServiceIntegrationBusLink) value,
					diagnostics, context);
		case WasPackage.WAS_SI_BUS:
			return validateWasSIBus((WasSIBus) value, diagnostics, context);
		case WasPackage.WAS_SI_BUS_UNIT:
			return validateWasSIBusUnit((WasSIBusUnit) value, diagnostics, context);
		case WasPackage.WAS_SUBSTITUTION_VARIABLE:
			return validateWasSubstitutionVariable((WasSubstitutionVariable) value, diagnostics,
					context);
		case WasPackage.WAS_SYSTEM:
			return validateWasSystem((WasSystem) value, diagnostics, context);
		case WasPackage.WAS_SYSTEM_UNIT:
			return validateWasSystemUnit((WasSystemUnit) value, diagnostics, context);
		case WasPackage.WAS_V4_DATASOURCE:
			return validateWasV4Datasource((WasV4Datasource) value, diagnostics, context);
		case WasPackage.WAS_V5_DATASOURCE:
			return validateWasV5Datasource((WasV5Datasource) value, diagnostics, context);
		case WasPackage.WAS_V5DB2_DATASOURCE:
			return validateWasV5DB2Datasource((WasV5DB2Datasource) value, diagnostics, context);
		case WasPackage.WAS_V5DB2_ZOS_DATASOURCE:
			return validateWasV5DB2ZosDatasource((WasV5DB2ZosDatasource) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER:
			return validateWasWebServer((WasWebServer) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_MANAGEMENT:
			return validateWasWebServerManagement((WasWebServerManagement) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_PLUGIN:
			return validateWasWebServerPlugin((WasWebServerPlugin) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_UNIT:
			return validateWasWebServerUnit((WasWebServerUnit) value, diagnostics, context);
		case WasPackage.WEBSPHERE_APP_SERVER_UNIT:
			return validateWebsphereAppServerUnit((WebsphereAppServerUnit) value, diagnostics, context);
		case WasPackage.ACKNOWLEDGE_MODE_ENUM:
			return validateAcknowledgeModeEnum((AcknowledgeModeEnum) value, diagnostics, context);
		case WasPackage.CERTIFICATE_MAP_MODE:
			return validateCertificateMapMode((CertificateMapMode) value, diagnostics, context);
		case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM:
			return validateCFTargetSignificanceEnum((CFTargetSignificanceEnum) value, diagnostics,
					context);
		case WasPackage.CLASSLOADER_MODE:
			return validateClassloaderMode((ClassloaderMode) value, diagnostics, context);
		case WasPackage.CONNECTION_DELIVERY_MODE_ENUM:
			return validateConnectionDeliveryModeEnum((ConnectionDeliveryModeEnum) value, diagnostics,
					context);
		case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM:
			return validateConnectionFactoryTargetTypeEnum((ConnectionFactoryTargetTypeEnum) value,
					diagnostics, context);
		case WasPackage.CONNECTION_PROXIMITY_ENUM:
			return validateConnectionProximityEnum((ConnectionProximityEnum) value, diagnostics,
					context);
		case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES:
			return validateDataSourceHelperClassNames((DataSourceHelperClassNames) value, diagnostics,
					context);
		case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM:
			return validateDB2DataSourceTemplateEnum((DB2DataSourceTemplateEnum) value, diagnostics,
					context);
		case WasPackage.DB2_JDBC_PROVIDER_TYPE:
			return validateDB2JdbcProviderType((DB2JdbcProviderType) value, diagnostics, context);
		case WasPackage.IIOP_SECURITY_PROTOCOLS:
			return validateIIOPSecurityProtocols((IIOPSecurityProtocols) value, diagnostics, context);
		case WasPackage.JMS_DESTINATION_TYPE_ENUM:
			return validateJMSDestinationTypeEnum((JMSDestinationTypeEnum) value, diagnostics, context);
		case WasPackage.LDAP_DIRECTORY_TYPE:
			return validateLDAPDirectoryType((LDAPDirectoryType) value, diagnostics, context);
		case WasPackage.MESSAGE_RELIABILITY_ENUM:
			return validateMessageReliabilityEnum((MessageReliabilityEnum) value, diagnostics, context);
		case WasPackage.POLICIES:
			return validatePolicies((Policies) value, diagnostics, context);
		case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM:
			return validateReadAheadOptimizationEnum((ReadAheadOptimizationEnum) value, diagnostics,
					context);
		case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM:
			return validateShareDurableSubscriptionsEnum((ShareDurableSubscriptionsEnum) value,
					diagnostics, context);
		case WasPackage.WAR_CLASSLOADER_POLICY:
			return validateWARClassloaderPolicy((WARClassloaderPolicy) value, diagnostics, context);
		case WasPackage.WAS_ACCOUNT_TYPE_ENUM:
			return validateWasAccountTypeEnum((WasAccountTypeEnum) value, diagnostics, context);
		case WasPackage.WAS_APPLICATION_MAP:
			return validateWasApplicationMap((WasApplicationMap) value, diagnostics, context);
		case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES:
			return validateWasDeploymentManagerPortNames((WasDeploymentManagerPortNames) value,
					diagnostics, context);
		case WasPackage.WAS_EDITION_ENUM:
			return validateWasEditionEnum((WasEditionEnum) value, diagnostics, context);
		case WasPackage.WAS_ENDPOINT_LISTENER_TYPE:
			return validateWasEndpointListenerType((WasEndpointListenerType) value, diagnostics,
					context);
		case WasPackage.WAS_NODE_GROUP_TYPE_ENUM:
			return validateWasNodeGroupTypeEnum((WasNodeGroupTypeEnum) value, diagnostics, context);
		case WasPackage.WAS_NODE_PORT_NAMES:
			return validateWasNodePortNames((WasNodePortNames) value, diagnostics, context);
		case WasPackage.WAS_PROFILE_TYPE_ENUM:
			return validateWasProfileTypeEnum((WasProfileTypeEnum) value, diagnostics, context);
		case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM:
			return validateWasRoutingDefinitionTypeEnum((WasRoutingDefinitionTypeEnum) value,
					diagnostics, context);
		case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM:
			return validateWasSibDestinationTypeEnum((WasSibDestinationTypeEnum) value, diagnostics,
					context);
		case WasPackage.WAS_WEB_SERVER_NODE_TYPE:
			return validateWasWebServerNodeType((WasWebServerNodeType) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_OS:
			return validateWasWebServerOS((WasWebServerOS) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_TYPE:
			return validateWasWebServerType((WasWebServerType) value, diagnostics, context);
		case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES:
			return validateWebsphereAppServerPortNames((WebsphereAppServerPortNames) value,
					diagnostics, context);
		case WasPackage.ACKNOWLEDGE_MODE_ENUM_OBJECT:
			return validateAcknowledgeModeEnumObject((AcknowledgeModeEnum) value, diagnostics, context);
		case WasPackage.CERTIFICATE_MAP_MODE_OBJECT:
			return validateCertificateMapModeObject((CertificateMapMode) value, diagnostics, context);
		case WasPackage.CF_TARGET_SIGNIFICANCE_ENUM_OBJECT:
			return validateCFTargetSignificanceEnumObject((CFTargetSignificanceEnum) value,
					diagnostics, context);
		case WasPackage.CLASSLOADER_MODE_OBJECT:
			return validateClassloaderModeObject((ClassloaderMode) value, diagnostics, context);
		case WasPackage.CONNECTION_DELIVERY_MODE_ENUM_OBJECT:
			return validateConnectionDeliveryModeEnumObject((ConnectionDeliveryModeEnum) value,
					diagnostics, context);
		case WasPackage.CONNECTION_FACTORY_TARGET_TYPE_ENUM_OBJECT:
			return validateConnectionFactoryTargetTypeEnumObject(
					(ConnectionFactoryTargetTypeEnum) value, diagnostics, context);
		case WasPackage.CONNECTION_PROXIMITY_ENUM_OBJECT:
			return validateConnectionProximityEnumObject((ConnectionProximityEnum) value, diagnostics,
					context);
		case WasPackage.DATA_SOURCE_HELPER_CLASS_NAMES_OBJECT:
			return validateDataSourceHelperClassNamesObject((DataSourceHelperClassNames) value,
					diagnostics, context);
		case WasPackage.DB2_DATA_SOURCE_TEMPLATE_ENUM_OBJECT:
			return validateDB2DataSourceTemplateEnumObject((DB2DataSourceTemplateEnum) value,
					diagnostics, context);
		case WasPackage.DB2_JDBC_PROVIDER_TYPE_OBJECT:
			return validateDB2JdbcProviderTypeObject((DB2JdbcProviderType) value, diagnostics, context);
		case WasPackage.IIOP_SECURITY_PROTOCOLS_OBJECT:
			return validateIIOPSecurityProtocolsObject((IIOPSecurityProtocols) value, diagnostics,
					context);
		case WasPackage.JMS_DESTINATION_TYPE_ENUM_OBJECT:
			return validateJMSDestinationTypeEnumObject((JMSDestinationTypeEnum) value, diagnostics,
					context);
		case WasPackage.LDAP_DIRECTORY_TYPE_OBJECT:
			return validateLDAPDirectoryTypeObject((LDAPDirectoryType) value, diagnostics, context);
		case WasPackage.MESSAGE_RELIABILITY_ENUM_OBJECT:
			return validateMessageReliabilityEnumObject((MessageReliabilityEnum) value, diagnostics,
					context);
		case WasPackage.POLICIES_OBJECT:
			return validatePoliciesObject((Policies) value, diagnostics, context);
		case WasPackage.READ_AHEAD_OPTIMIZATION_ENUM_OBJECT:
			return validateReadAheadOptimizationEnumObject((ReadAheadOptimizationEnum) value,
					diagnostics, context);
		case WasPackage.SHARE_DURABLE_SUBSCRIPTIONS_ENUM_OBJECT:
			return validateShareDurableSubscriptionsEnumObject((ShareDurableSubscriptionsEnum) value,
					diagnostics, context);
		case WasPackage.WAR_CLASSLOADER_POLICY_OBJECT:
			return validateWARClassloaderPolicyObject((WARClassloaderPolicy) value, diagnostics,
					context);
		case WasPackage.WAS_ACCOUNT_TYPE_ENUM_OBJECT:
			return validateWasAccountTypeEnumObject((WasAccountTypeEnum) value, diagnostics, context);
		case WasPackage.WAS_APPLICATION_MAP_OBJECT:
			return validateWasApplicationMapObject((WasApplicationMap) value, diagnostics, context);
		case WasPackage.WAS_DEPLOYMENT_MANAGER_PORT_NAMES_OBJECT:
			return validateWasDeploymentManagerPortNamesObject((WasDeploymentManagerPortNames) value,
					diagnostics, context);
		case WasPackage.WAS_EDITION_ENUM_OBJECT:
			return validateWasEditionEnumObject((WasEditionEnum) value, diagnostics, context);
		case WasPackage.WAS_ENDPOINT_LISTENER_TYPE_OBJECT:
			return validateWasEndpointListenerTypeObject((WasEndpointListenerType) value, diagnostics,
					context);
		case WasPackage.WAS_NODE_GROUP_TYPE_ENUM_OBJECT:
			return validateWasNodeGroupTypeEnumObject((WasNodeGroupTypeEnum) value, diagnostics,
					context);
		case WasPackage.WAS_NODE_PORT_NAMES_OBJECT:
			return validateWasNodePortNamesObject((WasNodePortNames) value, diagnostics, context);
		case WasPackage.WAS_PROFILE_TYPE_ENUM_OBJECT:
			return validateWasProfileTypeEnumObject((WasProfileTypeEnum) value, diagnostics, context);
		case WasPackage.WAS_ROUTING_DEFINITION_TYPE_ENUM_OBJECT:
			return validateWasRoutingDefinitionTypeEnumObject((WasRoutingDefinitionTypeEnum) value,
					diagnostics, context);
		case WasPackage.WAS_SIB_DESTINATION_TYPE_ENUM_OBJECT:
			return validateWasSibDestinationTypeEnumObject((WasSibDestinationTypeEnum) value,
					diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_NODE_TYPE_OBJECT:
			return validateWasWebServerNodeTypeObject((WasWebServerNodeType) value, diagnostics,
					context);
		case WasPackage.WAS_WEB_SERVER_OS_OBJECT:
			return validateWasWebServerOSObject((WasWebServerOS) value, diagnostics, context);
		case WasPackage.WAS_WEB_SERVER_TYPE_OBJECT:
			return validateWasWebServerTypeObject((WasWebServerType) value, diagnostics, context);
		case WasPackage.WEBSPHERE_APP_SERVER_PORT_NAMES_OBJECT:
			return validateWebsphereAppServerPortNamesObject((WebsphereAppServerPortNames) value,
					diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassloader(Classloader classloader, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint((EObject) classloader, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2JdbcProvider(DB2JdbcProvider db2JdbcProvider,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(db2JdbcProvider, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2JdbcProviderUnit(DB2JdbcProviderUnit db2JdbcProviderUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(db2JdbcProviderUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateHostNameAliasType(HostNameAliasType hostNameAliasType,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject) hostNameAliasType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSharedLibraryEntry(SharedLibraryEntry sharedLibraryEntry,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(sharedLibraryEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVirtualHostType(VirtualHostType virtualHostType,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(virtualHostType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasAdvancedLdapConfiguration(
			WasAdvancedLdapConfiguration wasAdvancedLdapConfiguration, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasAdvancedLdapConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasCell(WasCell wasCell, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasCell, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasCellUnit(WasCellUnit wasCellUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasCellUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasCluster(WasCluster wasCluster, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasCluster, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasClusterUnit(WasClusterUnit wasClusterUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasClusterUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasConfigurationContainer(
			WasConfigurationContainer wasConfigurationContainer, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasConfigurationContainer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDatasource(WasDatasource wasDatasource, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasDatasource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDatasourceUnit(WasDatasourceUnit wasDatasourceUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDatasourceUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration wasDefaultMessagingConnectionFactoryConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingConnectionFactoryConfiguration,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit wasDefaultMessagingConnectionFactoryUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingConnectionFactoryUnit, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration wasDefaultMessagingQueueConnectionFactoryConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(
				wasDefaultMessagingQueueConnectionFactoryConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit wasDefaultMessagingQueueConnectionFactoryUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingQueueConnectionFactoryUnit,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingQueueDestination(
			WasDefaultMessagingQueueDestination wasDefaultMessagingQueueDestination,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingQueueDestination, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingQueueDestinationUnit(
			WasDefaultMessagingQueueDestinationUnit wasDefaultMessagingQueueDestinationUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingQueueDestinationUnit, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration wasDefaultMessagingTopicConnectionFactoryConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(
				wasDefaultMessagingTopicConnectionFactoryConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit wasDefaultMessagingTopicConnectionFactoryUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingTopicConnectionFactoryUnit,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingTopicDestination(
			WasDefaultMessagingTopicDestination wasDefaultMessagingTopicDestination,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingTopicDestination, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDefaultMessagingTopicDestinationUnit(
			WasDefaultMessagingTopicDestinationUnit wasDefaultMessagingTopicDestinationUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDefaultMessagingTopicDestinationUnit, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDeploymentManager(WasDeploymentManager wasDeploymentManager,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDeploymentManager, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDeploymentManagerUnit(
			WasDeploymentManagerUnit wasDeploymentManagerUnit, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasDeploymentManagerUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDeployRoot(WasDeployRoot wasDeployRoot, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint((EObject) wasDeployRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEndpointListenerConfiguration(
			WasEndpointListenerConfiguration wasEndpointListenerConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasEndpointListenerConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEndpointListenerUnit(WasEndpointListenerUnit wasEndpointListenerUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasEndpointListenerUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasHandlerList(WasHandlerList wasHandlerList,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasHandlerList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWASJ2CAuthenticationDataEntry(
			WASJ2CAuthenticationDataEntry wasj2CAuthenticationDataEntry, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasj2CAuthenticationDataEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWASJ2CAuthenticationUnit(
			WASJ2CAuthenticationUnit wasj2CAuthenticationUnit, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasj2CAuthenticationUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasJ2EEServer(WasJ2EEServer wasJ2EEServer, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasJ2EEServer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasJMSActivationSpecification(
			WasJMSActivationSpecification wasJMSActivationSpecification, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasJMSActivationSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasJMSActivationSpecificationUnit(
			WasJMSActivationSpecificationUnit wasJMSActivationSpecificationUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasJMSActivationSpecificationUnit, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasLdapConfiguration(WasLdapConfiguration wasLdapConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasLdapConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasLdapConfigurationUnit(
			WasLdapConfigurationUnit wasLdapConfigurationUnit, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasLdapConfigurationUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNode(WasNode wasNode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeGroup(WasNodeGroup wasNodeGroup, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasNodeGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeGroupUnit(WasNodeGroupUnit wasNodeGroupUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasNodeGroupUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeUnit(WasNodeUnit wasNodeUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasNodeUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeWindowsServiceUnit(
			WasNodeWindowsServiceUnit wasNodeWindowsServiceUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasNodeWindowsServiceUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasPluginAdmin(WasPluginAdmin wasPluginAdmin,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasPluginAdmin, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasPluginRedirection(WasPluginRedirection wasPluginRedirection,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasPluginRedirection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSecurity(WasSecurity wasSecurity, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasSecurity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasServer(WasServer wasServer, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasServer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSharedLibContainer(WasSharedLibContainer wasSharedLibContainer,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSharedLibContainer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSharedLibraryEntryUnit(
			WasSharedLibraryEntryUnit wasSharedLibraryEntryUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasSharedLibraryEntryUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibDestination(WasSibDestination wasSibDestination,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibDestination, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibDestinationUnit(WasSibDestinationUnit wasSibDestinationUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibDestinationUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibForeignBus(WasSibForeignBus wasSibForeignBus,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibForeignBus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibInboundPort(WasSibInboundPort wasSibInboundPort,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibInboundPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibInboundPortUnit(WasSibInboundPortUnit wasSibInboundPortUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibInboundPortUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibInboundService(WasSibInboundService wasSibInboundService,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibInboundService, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibInboundServiceUnit(
			WasSibInboundServiceUnit wasSibInboundServiceUnit, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibInboundServiceUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibMediation(WasSibMediation wasSibMediation,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibMediation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibMediationUnit(WasSibMediationUnit wasSibMediationUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibMediationUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibOutboundPort(WasSibOutboundPort wasSibOutboundPort,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibOutboundPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibOutboundPortUnit(WasSibOutboundPortUnit wasSibOutboundPortUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibOutboundPortUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibOutboundService(WasSibOutboundService wasSibOutboundService,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibOutboundService, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibOutboundServiceUnit(
			WasSibOutboundServiceUnit wasSibOutboundServiceUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasSibOutboundServiceUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibServiceIntegrationBusLink(
			WasSibServiceIntegrationBusLink wasSibServiceIntegrationBusLink,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSibServiceIntegrationBusLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSIBus(WasSIBus wasSIBus, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSIBus, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSIBusUnit(WasSIBusUnit wasSIBusUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasSIBusUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSubstitutionVariable(WasSubstitutionVariable wasSubstitutionVariable,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSubstitutionVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSystem(WasSystem wasSystem, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasSystem, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSystemUnit(WasSystemUnit wasSystemUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasSystemUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasV4Datasource(WasV4Datasource wasV4Datasource,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasV4Datasource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasV5Datasource(WasV5Datasource wasV5Datasource,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasV5Datasource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasV5DB2Datasource(WasV5DB2Datasource wasV5DB2Datasource,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasV5DB2Datasource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasV5DB2ZosDatasource(WasV5DB2ZosDatasource wasV5DB2ZosDatasource,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasV5DB2ZosDatasource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServer(WasWebServer wasWebServer, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(wasWebServer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerManagement(WasWebServerManagement wasWebServerManagement,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasWebServerManagement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerPlugin(WasWebServerPlugin wasWebServerPlugin,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasWebServerPlugin, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerUnit(WasWebServerUnit wasWebServerUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(wasWebServerUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWebsphereAppServerUnit(WebsphereAppServerUnit websphereAppServerUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(websphereAppServerUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAcknowledgeModeEnum(AcknowledgeModeEnum acknowledgeModeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCertificateMapMode(CertificateMapMode certificateMapMode,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCFTargetSignificanceEnum(
			CFTargetSignificanceEnum cfTargetSignificanceEnum, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassloaderMode(ClassloaderMode classloaderMode,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionDeliveryModeEnum(
			ConnectionDeliveryModeEnum connectionDeliveryModeEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionFactoryTargetTypeEnum(
			ConnectionFactoryTargetTypeEnum connectionFactoryTargetTypeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionProximityEnum(ConnectionProximityEnum connectionProximityEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDataSourceHelperClassNames(
			DataSourceHelperClassNames dataSourceHelperClassNames, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2DataSourceTemplateEnum(
			DB2DataSourceTemplateEnum db2DataSourceTemplateEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2JdbcProviderType(DB2JdbcProviderType db2JdbcProviderType,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIIOPSecurityProtocols(IIOPSecurityProtocols iiopSecurityProtocols,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateJMSDestinationTypeEnum(JMSDestinationTypeEnum jmsDestinationTypeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateLDAPDirectoryType(LDAPDirectoryType ldapDirectoryType,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMessageReliabilityEnum(MessageReliabilityEnum messageReliabilityEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePolicies(Policies policies, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateReadAheadOptimizationEnum(
			ReadAheadOptimizationEnum readAheadOptimizationEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShareDurableSubscriptionsEnum(
			ShareDurableSubscriptionsEnum shareDurableSubscriptionsEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWARClassloaderPolicy(WARClassloaderPolicy warClassloaderPolicy,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasAccountTypeEnum(WasAccountTypeEnum wasAccountTypeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasApplicationMap(WasApplicationMap wasApplicationMap,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDeploymentManagerPortNames(
			WasDeploymentManagerPortNames wasDeploymentManagerPortNames, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEditionEnum(WasEditionEnum wasEditionEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEndpointListenerType(WasEndpointListenerType wasEndpointListenerType,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeGroupTypeEnum(WasNodeGroupTypeEnum wasNodeGroupTypeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodePortNames(WasNodePortNames wasNodePortNames,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasProfileTypeEnum(WasProfileTypeEnum wasProfileTypeEnum,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasRoutingDefinitionTypeEnum(
			WasRoutingDefinitionTypeEnum wasRoutingDefinitionTypeEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibDestinationTypeEnum(
			WasSibDestinationTypeEnum wasSibDestinationTypeEnum, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerNodeType(WasWebServerNodeType wasWebServerNodeType,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerOS(WasWebServerOS wasWebServerOS,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerType(WasWebServerType wasWebServerType,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWebsphereAppServerPortNames(
			WebsphereAppServerPortNames websphereAppServerPortNames, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAcknowledgeModeEnumObject(AcknowledgeModeEnum acknowledgeModeEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCertificateMapModeObject(CertificateMapMode certificateMapModeObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCFTargetSignificanceEnumObject(
			CFTargetSignificanceEnum cfTargetSignificanceEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassloaderModeObject(ClassloaderMode classloaderModeObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionDeliveryModeEnumObject(
			ConnectionDeliveryModeEnum connectionDeliveryModeEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionFactoryTargetTypeEnumObject(
			ConnectionFactoryTargetTypeEnum connectionFactoryTargetTypeEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionProximityEnumObject(
			ConnectionProximityEnum connectionProximityEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDataSourceHelperClassNamesObject(
			DataSourceHelperClassNames dataSourceHelperClassNamesObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2DataSourceTemplateEnumObject(
			DB2DataSourceTemplateEnum db2DataSourceTemplateEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDB2JdbcProviderTypeObject(DB2JdbcProviderType db2JdbcProviderTypeObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateEndPointListenerNameString_Pattern
	 */
	public static final PatternMatcher[][] END_POINT_LISTENER_NAME_STRING__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("[SOAPHTTPChannel1|SOAPHTTPChannel2|SOAPJMSChannel1|SOAPJMSChannel2]") //$NON-NLS-1$
	} };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIIOPSecurityProtocolsObject(
			IIOPSecurityProtocols iiopSecurityProtocolsObject, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateJMSDestinationTypeEnumObject(
			JMSDestinationTypeEnum jmsDestinationTypeEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateLDAPDirectoryTypeObject(LDAPDirectoryType ldapDirectoryTypeObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMessageReliabilityEnumObject(
			MessageReliabilityEnum messageReliabilityEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePoliciesObject(Policies policiesObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateReadAheadOptimizationEnumObject(
			ReadAheadOptimizationEnum readAheadOptimizationEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShareDurableSubscriptionsEnumObject(
			ShareDurableSubscriptionsEnum shareDurableSubscriptionsEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWARClassloaderPolicyObject(
			WARClassloaderPolicy warClassloaderPolicyObject, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasAccountTypeEnumObject(WasAccountTypeEnum wasAccountTypeEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasApplicationMapObject(WasApplicationMap wasApplicationMapObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasDeploymentManagerPortNamesObject(
			WasDeploymentManagerPortNames wasDeploymentManagerPortNamesObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEditionEnumObject(WasEditionEnum wasEditionEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasEndpointListenerTypeObject(
			WasEndpointListenerType wasEndpointListenerTypeObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodeGroupTypeEnumObject(
			WasNodeGroupTypeEnum wasNodeGroupTypeEnumObject, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasNodePortNamesObject(WasNodePortNames wasNodePortNamesObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasProfileTypeEnumObject(WasProfileTypeEnum wasProfileTypeEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasRoutingDefinitionTypeEnumObject(
			WasRoutingDefinitionTypeEnum wasRoutingDefinitionTypeEnumObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasSibDestinationTypeEnumObject(
			WasSibDestinationTypeEnum wasSibDestinationTypeEnumObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerNodeTypeObject(
			WasWebServerNodeType wasWebServerNodeTypeObject, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerOSObject(WasWebServerOS wasWebServerOSObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWasWebServerTypeObject(WasWebServerType wasWebServerTypeObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWebsphereAppServerPortNamesObject(
			WebsphereAppServerPortNames websphereAppServerPortNamesObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //WasValidator
