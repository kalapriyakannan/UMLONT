/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class WasPackageImpl extends EPackageImpl implements WasPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classloaderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2JdbcProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2JdbcProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyJdbcProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyJdbcProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedJdbcProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedJdbcProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hostNameAliasTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedLibraryEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualHostTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasAdvancedLdapConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasApplicationClassLoaderPolicyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasApplicationExtEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasApplicationServerClassLoaderPolicyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasCellEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasCellUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasClassLoaderConfigurationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasClassLoaderPolicyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasClusterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasClusterUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasConfigurationContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDatasourceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingConnectionFactoryConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingQueueConnectionFactoryConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingQueueConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingQueueDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingQueueDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingTopicConnectionFactoryConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingTopicConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingTopicDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDefaultMessagingTopicDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDeploymentManagerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDeploymentManagerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasEarClassloaderPolicyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasEndpointListenerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasEndpointListenerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasHandlerListEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasj2CAuthenticationDataEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasj2CAuthenticationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasJ2EEConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasJ2EEServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasJMSActivationSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasJMSActivationSpecificationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasJNDIBindingConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasLdapConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasLdapConfigurationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasMessagingEngineEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasMessagingEngineUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasModuleClassLoaderPolicyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasModuleClassloaderPolicyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasModuleStartWeightConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasNodeGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasNodeGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasNodeUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasNodeWindowsServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasPluginAdminEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasPluginRedirectionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSecurityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSecuritySubjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSecuritySubjectConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSharedLibContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSharedLibraryEntryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibForeignBusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibInboundPortEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibInboundPortUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibInboundServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibInboundServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibMediationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibMediationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibOutboundPortEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibOutboundPortUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibOutboundServiceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibOutboundServiceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSibServiceIntegrationBusLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSIBusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSIBusUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSubstitutionVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasV4DatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasV5DatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasV5DB2DatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasV5DB2ZosDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWarClassloaderPolicyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebAppExtEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebServerManagementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebServerPluginEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wasWebServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass websphereAppServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum acknowledgeModeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum certificateMapModeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cfTargetSignificanceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classloaderModeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classloaderPolicyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionDeliveryModeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionFactoryTargetTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionProximityEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataSourceHelperClassNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum db2DataSourceTemplateEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum db2JdbcProviderTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum derbyJdbcProviderTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endPointListenerNameEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum iiopSecurityProtocolsEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jdbcImplementationTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jmsDestinationTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ldapDirectoryTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum messageReliabilityEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum policiesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum readAheadOptimizationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum shareDurableSubscriptionsEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum warClassloaderPolicyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasAccountTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasApplicationMapEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasDefaultSecuritySubjectEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasDeploymentManagerPortNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasEditionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasEndpointListenerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasNodeGroupTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasNodePortNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasProfileTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasRoutingDefinitionTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasSibDestinationTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasUserRegistryTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasWebServerNodeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasWebServerOSEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wasWebServerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum websphereAppServerPortNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType acknowledgeModeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType certificateMapModeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cfTargetSignificanceEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classloaderModeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classloaderPolicyTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType connectionDeliveryModeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType connectionFactoryTargetTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType connectionProximityEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dataSourceHelperClassNamesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType db2DataSourceTemplateEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType db2JdbcProviderTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType derbyJdbcProviderTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType endPointListenerNameEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iiopSecurityProtocolsObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jdbcImplementationTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jmsDestinationTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ldapDirectoryTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType messageReliabilityEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType policiesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType readAheadOptimizationEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType shareDurableSubscriptionsEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType warClassloaderPolicyObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasAccountTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasApplicationMapObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasDefaultSecuritySubjectEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasDeploymentManagerPortNamesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasEditionEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasEndpointListenerTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasNodeGroupTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasNodePortNamesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasProfileTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasRoutingDefinitionTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasSibDestinationTypeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasUserRegistryTypesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasWebServerNodeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasWebServerOSObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wasWebServerTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType websphereAppServerPortNamesObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WasPackageImpl() {
		super(eNS_URI, WasFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WasPackage init() {
		if (isInited) return (WasPackage)EPackage.Registry.INSTANCE.getEPackage(WasPackage.eNS_URI);

		// Obtain or create and register package
		WasPackageImpl theWasPackage = (WasPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WasPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WasPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConstraintPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		J2eePackage.eINSTANCE.eClass();
		JavaPackage.eINSTANCE.eClass();
		JmsPackage.eINSTANCE.eClass();
		OsPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWasPackage.createPackageContents();

		// Initialize created meta-data
		theWasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWasPackage.freeze();

		return theWasPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassloader() {
		return classloaderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassloader_Mode() {
		return (EAttribute)classloaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassloader_StartWeight() {
		return (EAttribute)classloaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassloader_WarClassLoaderPolicy() {
		return (EAttribute)classloaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2JdbcProvider() {
		return db2JdbcProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcProvider_JdbcType() {
		return (EAttribute)db2JdbcProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcProvider_Template() {
		return (EAttribute)db2JdbcProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2JdbcProviderUnit() {
		return db2JdbcProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyJdbcProvider() {
		return derbyJdbcProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyJdbcProvider_Template() {
		return (EAttribute)derbyJdbcProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyJdbcProviderUnit() {
		return derbyJdbcProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedJdbcProvider() {
		return extendedJdbcProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedJdbcProviderUnit() {
		return extendedJdbcProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHostNameAliasType() {
		return hostNameAliasTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHostNameAliasType_Hostname() {
		return (EAttribute)hostNameAliasTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHostNameAliasType_HostnameAlias() {
		return (EAttribute)hostNameAliasTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSharedLibraryEntry() {
		return sharedLibraryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSharedLibraryEntry_ClassPath() {
		return (EAttribute)sharedLibraryEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSharedLibraryEntry_NativePath() {
		return (EAttribute)sharedLibraryEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSharedLibraryEntry_SharedLibraryEntryName() {
		return (EAttribute)sharedLibraryEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualHostType() {
		return virtualHostTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualHostType_HostNameAlias() {
		return (EReference)virtualHostTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualHostType_HostName() {
		return (EAttribute)virtualHostTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasAdvancedLdapConfiguration() {
		return wasAdvancedLdapConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_CertificateFilter() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_CertificateMapMode() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_GroupFilter() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_GroupIdMap() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_GroupMemberIdMap() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_UserFilter() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasAdvancedLdapConfiguration_UserIdMap() {
		return (EAttribute)wasAdvancedLdapConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasApplicationClassLoaderPolicy() {
		return wasApplicationClassLoaderPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasApplicationClassLoaderPolicy_ReloadClasses() {
		return (EAttribute)wasApplicationClassLoaderPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasApplicationClassLoaderPolicy_ReloadInterval() {
		return (EAttribute)wasApplicationClassLoaderPolicyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasApplicationExt() {
		return wasApplicationExtEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasApplicationExt_ReloadInterval() {
		return (EAttribute)wasApplicationExtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasApplicationExt_ShareSessionContext() {
		return (EAttribute)wasApplicationExtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasApplicationServerClassLoaderPolicy() {
		return wasApplicationServerClassLoaderPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasCell() {
		return wasCellEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCell_CellName() {
		return (EAttribute)wasCellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCell_IsDistributed() {
		return (EAttribute)wasCellEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCell_WasVersion() {
		return (EAttribute)wasCellEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasCellUnit() {
		return wasCellUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasClassLoaderConfigurationUnit() {
		return wasClassLoaderConfigurationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasClassLoaderPolicy() {
		return wasClassLoaderPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasClassLoaderPolicy_Order() {
		return (EAttribute)wasClassLoaderPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasClassLoaderPolicy_Policy() {
		return (EAttribute)wasClassLoaderPolicyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasCluster() {
		return wasClusterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCluster_ClusterName() {
		return (EAttribute)wasClusterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCluster_CreateReplicationDomain() {
		return (EAttribute)wasClusterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCluster_PreferLocal() {
		return (EAttribute)wasClusterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasCluster_WasVersion() {
		return (EAttribute)wasClusterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasClusterUnit() {
		return wasClusterUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasConfigurationContainer() {
		return wasConfigurationContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDatasource() {
		return wasDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDatasource_Category() {
		return (EAttribute)wasDatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDatasource_ConnectionTimeout() {
		return (EAttribute)wasDatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDatasource_MaxConnections() {
		return (EAttribute)wasDatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDatasource_MinConnections() {
		return (EAttribute)wasDatasourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDatasource_StatementCacheSize() {
		return (EAttribute)wasDatasourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDatasourceUnit() {
		return wasDatasourceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingConnectionFactoryConfiguration() {
		return wasDefaultMessagingConnectionFactoryConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_Category() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_ClientIdentifier() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_ConnectionProximity() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_DurableSubscriptionHome() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_NonpersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_PersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_ProviderEndpoints() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_ReadAhead() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_ShareDurableSubscriptions() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_Target() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_TargetInboundTransportChain() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_TargetSignificance() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_TargetType() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_TempQnamePrefix() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingConnectionFactoryConfiguration_TempTopicNamePrefix() {
		return (EAttribute)wasDefaultMessagingConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingConnectionFactoryUnit() {
		return wasDefaultMessagingConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingQueueConnectionFactoryConfiguration() {
		return wasDefaultMessagingQueueConnectionFactoryConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_Category() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_ClientIdentifier() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_ConnectionProximity() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_NonpersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_PersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_ProviderEndpoints() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_ReadAhead() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_Target() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetInboundTransportChain() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetSignificance() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetType() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueConnectionFactoryConfiguration_TempQNamePrefix() {
		return (EAttribute)wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingQueueConnectionFactoryUnit() {
		return wasDefaultMessagingQueueConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingQueueDestination() {
		return wasDefaultMessagingQueueDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueDestination_ConnectionDeliveryMode() {
		return (EAttribute)wasDefaultMessagingQueueDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueDestination_MessageLiveTime() {
		return (EAttribute)wasDefaultMessagingQueueDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingQueueDestination_MessagePriority() {
		return (EAttribute)wasDefaultMessagingQueueDestinationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingQueueDestinationUnit() {
		return wasDefaultMessagingQueueDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingTopicConnectionFactoryConfiguration() {
		return wasDefaultMessagingTopicConnectionFactoryConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_Category() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_ClientIdentifier() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_ConnectionProximity() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_DurableSubscriptionHome() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_NonpersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_PersistentMessageReliability() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_ProviderEndpoints() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_ReadAhead() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_ShareDurableSubscriptions() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_Target() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetInboundTransportChain() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetSignificance() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetType() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicConnectionFactoryConfiguration_TempTopicNamePrefix() {
		return (EAttribute)wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingTopicConnectionFactoryUnit() {
		return wasDefaultMessagingTopicConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingTopicDestination() {
		return wasDefaultMessagingTopicDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicDestination_ConnectionDeliveryMode() {
		return (EAttribute)wasDefaultMessagingTopicDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicDestination_MessageLiveTime() {
		return (EAttribute)wasDefaultMessagingTopicDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicDestination_MessagePriority() {
		return (EAttribute)wasDefaultMessagingTopicDestinationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDefaultMessagingTopicDestination_TopicName() {
		return (EAttribute)wasDefaultMessagingTopicDestinationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDefaultMessagingTopicDestinationUnit() {
		return wasDefaultMessagingTopicDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDeploymentManager() {
		return wasDeploymentManagerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDeploymentManagerUnit() {
		return wasDeploymentManagerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasDeployRoot() {
		return wasDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasDeployRoot_Mixed() {
		return (EAttribute)wasDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_XMLNSPrefixMap() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_XSISchemaLocation() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityDb2JdbcProvider() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityDerbyJdbcProvider() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityExtendedJdbcProvider() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasAdvancedLdapConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasApplicationClassLoaderPolicy() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasApplicationExt() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasApplicationServerClassLoaderPolicy() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasCell() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasClassLoaderPolicy() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasCluster() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasConfigurationContainer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDatasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDefaultMessagingConnectionFactoryConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDefaultMessagingQueueDestination() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDefaultMessagingTopicDestination() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasDeploymentManager() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasEndpointListenerConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasHandlerList() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasJ2CAuth() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasJ2EEServer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasJMSActivationSpecification() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasLdapConfiguration() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasMessagingEngine() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasModuleClassLoaderPolicy() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasNode() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasNodeGroup() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasPluginAdmin() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasPluginRedirection() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSecurity() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSecuritySubject() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasServer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSharedLibContainer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSharedLibrary() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibDestination() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibForeignBus() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibInboundPort() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibInboundService() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibMediation() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibOutboundPort() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibOutboundService() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSibServiceIntegrationBusLink() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSIBus() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSubstitutionVariable() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasSystem() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasv4datasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasv5datasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasv5DB2Datasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasv5DB2ZosDatasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasVirtualHost() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasWebAppExt() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasWebServer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasWebServerManagement() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_CapabilityWasWebServerPlugin() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_Classloader() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasEarClassloaderPolicyConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasJ2EEConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasJNDIBindingConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasModuleClassloaderPolicyConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasModuleStartWeightConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasSecuritySubjectConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_ConstraintWasWarClassloaderPolicyConstraint() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_HostNameAlias() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitDb2JdbcProviderUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitDerbyJdbcProviderUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitExtendedJdbcProviderUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasAppServer() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasCellUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasClassLoaderConfigurationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasClusterUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasdatasource() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDefaultMessagingConnectionFactoryUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDefaultMessagingQueueConnectionFactoryUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDefaultMessagingQueueDestinationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDefaultMessagingTopicConnectionFactoryUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDefaultMessagingTopicDestinationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasDeploymentManagerUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasEndpointListenerUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasJ2CAuth() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasJMSActivationSpecificationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasLdapConfigurationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasMessagingEngine() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasNodeGroupUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasNodeUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasNodeWindowsServiceUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSharedLibraryEntryUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibDestinationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibInboundPortUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibInboundServiceUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibMediationUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibOutboundPortUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSibOutboundServiceUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSIBusUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasSystemUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWasDeployRoot_UnitWasWebServerUnit() {
		return (EReference)wasDeployRootEClass.getEStructuralFeatures().get(98);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasEarClassloaderPolicyConstraint() {
		return wasEarClassloaderPolicyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEarClassloaderPolicyConstraint_Policy() {
		return (EAttribute)wasEarClassloaderPolicyConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEarClassloaderPolicyConstraint_ReloadClasses() {
		return (EAttribute)wasEarClassloaderPolicyConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEarClassloaderPolicyConstraint_ReloadInterval() {
		return (EAttribute)wasEarClassloaderPolicyConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasEndpointListenerConfiguration() {
		return wasEndpointListenerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEndpointListenerConfiguration_EndpointListenerName() {
		return (EAttribute)wasEndpointListenerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEndpointListenerConfiguration_UrlRoot() {
		return (EAttribute)wasEndpointListenerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasEndpointListenerConfiguration_WsdlUrlRoot() {
		return (EAttribute)wasEndpointListenerConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasEndpointListenerUnit() {
		return wasEndpointListenerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasHandlerList() {
		return wasHandlerListEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasHandlerList_HandlerlistName() {
		return (EAttribute)wasHandlerListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWASJ2CAuthenticationDataEntry() {
		return wasj2CAuthenticationDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWASJ2CAuthenticationUnit() {
		return wasj2CAuthenticationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasJ2EEConstraint() {
		return wasJ2EEConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasJ2EEServer() {
		return wasJ2EEServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasJMSActivationSpecification() {
		return wasJMSActivationSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasJMSActivationSpecification_DurableScriptionHome() {
		return (EAttribute)wasJMSActivationSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasJMSActivationSpecification_MaxBatchSize() {
		return (EAttribute)wasJMSActivationSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasJMSActivationSpecification_MaxConcurrentEndpoints() {
		return (EAttribute)wasJMSActivationSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasJMSActivationSpecification_ShareDurableSubscription() {
		return (EAttribute)wasJMSActivationSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasJMSActivationSpecificationUnit() {
		return wasJMSActivationSpecificationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasJNDIBindingConstraint() {
		return wasJNDIBindingConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasJNDIBindingConstraint_JndiName() {
		return (EAttribute)wasJNDIBindingConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasLdapConfiguration() {
		return wasLdapConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_BaseDN() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_BindDN() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_BindPassword() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_IgnoreCase() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_LdapHostname() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_LdapPort() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_Limit() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_MonitorInterval() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_Realm() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_ReuseConnection() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_SearchTimeout() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_ServerId() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_ServerPassword() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_SslConfig() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_SslEnabled() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasLdapConfiguration_Type() {
		return (EAttribute)wasLdapConfigurationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasLdapConfigurationUnit() {
		return wasLdapConfigurationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasMessagingEngine() {
		return wasMessagingEngineEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasMessagingEngine_EngineName() {
		return (EAttribute)wasMessagingEngineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasMessagingEngineUnit() {
		return wasMessagingEngineUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasModuleClassLoaderPolicy() {
		return wasModuleClassLoaderPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasModuleClassLoaderPolicy_StartWeight() {
		return (EAttribute)wasModuleClassLoaderPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasModuleClassloaderPolicyConstraint() {
		return wasModuleClassloaderPolicyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasModuleStartWeightConstraint() {
		return wasModuleStartWeightConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasModuleStartWeightConstraint_StartingWeight() {
		return (EAttribute)wasModuleStartWeightConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasNode() {
		return wasNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_IsDefaultProfile() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_IsManaged() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_NodeName() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_ProfileLocation() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_ProfileName() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_ProfileType() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNode_WasVersion() {
		return (EAttribute)wasNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasNodeGroup() {
		return wasNodeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNodeGroup_IsDefaultType() {
		return (EAttribute)wasNodeGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasNodeGroup_NodeGroupName() {
		return (EAttribute)wasNodeGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasNodeGroupUnit() {
		return wasNodeGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasNodeUnit() {
		return wasNodeUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasNodeWindowsServiceUnit() {
		return wasNodeWindowsServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasPluginAdmin() {
		return wasPluginAdminEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasPluginAdmin_WasPluginVersion() {
		return (EAttribute)wasPluginAdminEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasPluginRedirection() {
		return wasPluginRedirectionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasPluginRedirection_WasPluginVersion() {
		return (EAttribute)wasPluginRedirectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSecurity() {
		return wasSecurityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_ActiveAuthMechanism() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_ActiveProtocol() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_ActiveUserRegistry() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_AllowAllPermissionForApplication() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_CacheTimeout() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_EnforceFineGrainedJCASecurity() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_EnforceJava2SecRuntimeFiletering() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_EnforceJava2Security() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_GlobalSecurityEnabled() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_IssuePermissionWarning() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecurity_UseDomainQualifiedNames() {
		return (EAttribute)wasSecurityEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSecuritySubject() {
		return wasSecuritySubjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecuritySubject_AccessId() {
		return (EAttribute)wasSecuritySubjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecuritySubject_SubjectName() {
		return (EAttribute)wasSecuritySubjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSecuritySubjectConstraint() {
		return wasSecuritySubjectConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSecuritySubjectConstraint_WasSecuritySubject() {
		return (EAttribute)wasSecuritySubjectConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasServer() {
		return wasServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasServer_ServerName() {
		return (EAttribute)wasServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasServer_WasVersion() {
		return (EAttribute)wasServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSharedLibContainer() {
		return wasSharedLibContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSharedLibraryEntryUnit() {
		return wasSharedLibraryEntryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibDestination() {
		return wasSibDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibDestination_DestinationName() {
		return (EAttribute)wasSibDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibDestination_Type() {
		return (EAttribute)wasSibDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibDestinationUnit() {
		return wasSibDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibForeignBus() {
		return wasSibForeignBusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibForeignBus_ForeignBusName() {
		return (EAttribute)wasSibForeignBusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibForeignBus_InBoundUserID() {
		return (EAttribute)wasSibForeignBusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibForeignBus_OutBoundUserID() {
		return (EAttribute)wasSibForeignBusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibForeignBus_RoutingDefinitionType() {
		return (EAttribute)wasSibForeignBusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibInboundPort() {
		return wasSibInboundPortEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibInboundPort_PortName() {
		return (EAttribute)wasSibInboundPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibInboundPortUnit() {
		return wasSibInboundPortUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibInboundService() {
		return wasSibInboundServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibInboundService_ServiceName() {
		return (EAttribute)wasSibInboundServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibInboundService_WsdlLocation() {
		return (EAttribute)wasSibInboundServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibInboundService_WsdlServiceNamespace() {
		return (EAttribute)wasSibInboundServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibInboundServiceUnit() {
		return wasSibInboundServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibMediation() {
		return wasSibMediationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibMediation_HandlerListName() {
		return (EAttribute)wasSibMediationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibMediation_MediationName() {
		return (EAttribute)wasSibMediationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibMediationUnit() {
		return wasSibMediationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibOutboundPort() {
		return wasSibOutboundPortEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibOutboundPort_PortName() {
		return (EAttribute)wasSibOutboundPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibOutboundPortUnit() {
		return wasSibOutboundPortUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibOutboundService() {
		return wasSibOutboundServiceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibOutboundService_ServiceName() {
		return (EAttribute)wasSibOutboundServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibOutboundService_WsdlLocation() {
		return (EAttribute)wasSibOutboundServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibOutboundService_WsdlServiceNamespace() {
		return (EAttribute)wasSibOutboundServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibOutboundServiceUnit() {
		return wasSibOutboundServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSibServiceIntegrationBusLink() {
		return wasSibServiceIntegrationBusLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibServiceIntegrationBusLink_BootTrapEndpoints() {
		return (EAttribute)wasSibServiceIntegrationBusLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibServiceIntegrationBusLink_ForeignBusName() {
		return (EAttribute)wasSibServiceIntegrationBusLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibServiceIntegrationBusLink_LinkName() {
		return (EAttribute)wasSibServiceIntegrationBusLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSibServiceIntegrationBusLink_RemoteMessagingEngineName() {
		return (EAttribute)wasSibServiceIntegrationBusLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSIBus() {
		return wasSIBusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSIBus_BusName() {
		return (EAttribute)wasSIBusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSIBus_ConfigurationReload() {
		return (EAttribute)wasSIBusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSIBus_DiscardMessages() {
		return (EAttribute)wasSIBusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSIBus_HighMessageThreshold() {
		return (EAttribute)wasSIBusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSIBus_InterEngineTransportChain() {
		return (EAttribute)wasSIBusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSIBusUnit() {
		return wasSIBusUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSubstitutionVariable() {
		return wasSubstitutionVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSystem() {
		return wasSystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSystem_InstallerDir() {
		return (EAttribute)wasSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSystem_WasEdition() {
		return (EAttribute)wasSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSystem_WasHome() {
		return (EAttribute)wasSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasSystem_WasVersion() {
		return (EAttribute)wasSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasSystemUnit() {
		return wasSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasV4Datasource() {
		return wasV4DatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV4Datasource_DisableAutoConnectionCleanup() {
		return (EAttribute)wasV4DatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV4Datasource_IdleTimeout() {
		return (EAttribute)wasV4DatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV4Datasource_OrphanTimeout() {
		return (EAttribute)wasV4DatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasV5Datasource() {
		return wasV5DatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_AgedTimeout() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_DataSourceHelperClassName() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_J2cAuthAlias() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_PurgePolicy() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_ReapTime() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5Datasource_UnusedTimeout() {
		return (EAttribute)wasV5DatasourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasV5DB2Datasource() {
		return wasV5DB2DatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_CliSchema() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_CurrentPackageSet() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_CurrentSchema() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_DeferPrepares() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_FullyMaterializeLobData() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_ResultSetHoldability() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_TraceFile() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_TraceLevel() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasV5DB2Datasource_UseTemplate() {
		return (EAttribute)wasV5DB2DatasourceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasV5DB2ZosDatasource() {
		return wasV5DB2ZosDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWarClassloaderPolicyConstraint() {
		return wasWarClassloaderPolicyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWarClassloaderPolicyConstraint_Order() {
		return (EAttribute)wasWarClassloaderPolicyConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebAppExt() {
		return wasWebAppExtEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_AdditionalClassPath() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_AutoLoadFilters() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_AutoRequestEncoding() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_AutoResponseEncoding() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_DefaultErrorPage() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_DirectoryBrowsingEnabled() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_FileServingEnabled() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_PreCompileJSPs() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_ReloadingEnabled() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_ReloadInterval() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebAppExt_ServeServletsByClassnameEnabled() {
		return (EAttribute)wasWebAppExtEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebServer() {
		return wasWebServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_ConfigFile() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_Host() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_InstallLocation() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_LogFileAccess() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_LogFileError() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_MapApplications() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_OperatingSystem() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_Port() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_ServerName() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_ServiceName() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_Type() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServer_UseSecureProtocol() {
		return (EAttribute)wasWebServerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebServerManagement() {
		return wasWebServerManagementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_AutoConfigPropagation() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_Host() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_Password() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_Port() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_UserId() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerManagement_UseSecureProtocol() {
		return (EAttribute)wasWebServerManagementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebServerPlugin() {
		return wasWebServerPluginEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWasWebServerPlugin_InstallLocation() {
		return (EAttribute)wasWebServerPluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWasWebServerUnit() {
		return wasWebServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebsphereAppServerUnit() {
		return websphereAppServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAcknowledgeModeEnum() {
		return acknowledgeModeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCertificateMapMode() {
		return certificateMapModeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCFTargetSignificanceEnum() {
		return cfTargetSignificanceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassloaderMode() {
		return classloaderModeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassloaderPolicyType() {
		return classloaderPolicyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionDeliveryModeEnum() {
		return connectionDeliveryModeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionFactoryTargetTypeEnum() {
		return connectionFactoryTargetTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionProximityEnum() {
		return connectionProximityEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataSourceHelperClassNames() {
		return dataSourceHelperClassNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDB2DataSourceTemplateEnum() {
		return db2DataSourceTemplateEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDB2JdbcProviderType() {
		return db2JdbcProviderTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDerbyJdbcProviderTypeType() {
		return derbyJdbcProviderTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndPointListenerNameEnum() {
		return endPointListenerNameEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIIOPSecurityProtocols() {
		return iiopSecurityProtocolsEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJdbcImplementationTypeType() {
		return jdbcImplementationTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJMSDestinationTypeEnum() {
		return jmsDestinationTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLDAPDirectoryType() {
		return ldapDirectoryTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMessageReliabilityEnum() {
		return messageReliabilityEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPolicies() {
		return policiesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReadAheadOptimizationEnum() {
		return readAheadOptimizationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getShareDurableSubscriptionsEnum() {
		return shareDurableSubscriptionsEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWARClassloaderPolicy() {
		return warClassloaderPolicyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasAccountTypeEnum() {
		return wasAccountTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasApplicationMap() {
		return wasApplicationMapEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasDefaultSecuritySubjectEnum() {
		return wasDefaultSecuritySubjectEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasDeploymentManagerPortNames() {
		return wasDeploymentManagerPortNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasEditionEnum() {
		return wasEditionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasEndpointListenerType() {
		return wasEndpointListenerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasNodeGroupTypeEnum() {
		return wasNodeGroupTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasNodePortNames() {
		return wasNodePortNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasProfileTypeEnum() {
		return wasProfileTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasRoutingDefinitionTypeEnum() {
		return wasRoutingDefinitionTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasSibDestinationTypeEnum() {
		return wasSibDestinationTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasUserRegistryTypes() {
		return wasUserRegistryTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasWebServerNodeType() {
		return wasWebServerNodeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasWebServerOS() {
		return wasWebServerOSEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWasWebServerType() {
		return wasWebServerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWebsphereAppServerPortNames() {
		return websphereAppServerPortNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAcknowledgeModeEnumObject() {
		return acknowledgeModeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCertificateMapModeObject() {
		return certificateMapModeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCFTargetSignificanceEnumObject() {
		return cfTargetSignificanceEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClassloaderModeObject() {
		return classloaderModeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClassloaderPolicyTypeObject() {
		return classloaderPolicyTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConnectionDeliveryModeEnumObject() {
		return connectionDeliveryModeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConnectionFactoryTargetTypeEnumObject() {
		return connectionFactoryTargetTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConnectionProximityEnumObject() {
		return connectionProximityEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDataSourceHelperClassNamesObject() {
		return dataSourceHelperClassNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDB2DataSourceTemplateEnumObject() {
		return db2DataSourceTemplateEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDB2JdbcProviderTypeObject() {
		return db2JdbcProviderTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDerbyJdbcProviderTypeTypeObject() {
		return derbyJdbcProviderTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEndPointListenerNameEnumObject() {
		return endPointListenerNameEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIIOPSecurityProtocolsObject() {
		return iiopSecurityProtocolsObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJdbcImplementationTypeTypeObject() {
		return jdbcImplementationTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJMSDestinationTypeEnumObject() {
		return jmsDestinationTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLDAPDirectoryTypeObject() {
		return ldapDirectoryTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMessageReliabilityEnumObject() {
		return messageReliabilityEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPoliciesObject() {
		return policiesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReadAheadOptimizationEnumObject() {
		return readAheadOptimizationEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getShareDurableSubscriptionsEnumObject() {
		return shareDurableSubscriptionsEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWARClassloaderPolicyObject() {
		return warClassloaderPolicyObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasAccountTypeEnumObject() {
		return wasAccountTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasApplicationMapObject() {
		return wasApplicationMapObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasDefaultSecuritySubjectEnumObject() {
		return wasDefaultSecuritySubjectEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasDeploymentManagerPortNamesObject() {
		return wasDeploymentManagerPortNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasEditionEnumObject() {
		return wasEditionEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasEndpointListenerTypeObject() {
		return wasEndpointListenerTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasNodeGroupTypeEnumObject() {
		return wasNodeGroupTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasNodePortNamesObject() {
		return wasNodePortNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasProfileTypeEnumObject() {
		return wasProfileTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasRoutingDefinitionTypeEnumObject() {
		return wasRoutingDefinitionTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasSibDestinationTypeEnumObject() {
		return wasSibDestinationTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasUserRegistryTypesObject() {
		return wasUserRegistryTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasWebServerNodeTypeObject() {
		return wasWebServerNodeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasWebServerOSObject() {
		return wasWebServerOSObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWasWebServerTypeObject() {
		return wasWebServerTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWebsphereAppServerPortNamesObject() {
		return websphereAppServerPortNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasFactory getWasFactory() {
		return (WasFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		classloaderEClass = createEClass(CLASSLOADER);
		createEAttribute(classloaderEClass, CLASSLOADER__MODE);
		createEAttribute(classloaderEClass, CLASSLOADER__START_WEIGHT);
		createEAttribute(classloaderEClass, CLASSLOADER__WAR_CLASS_LOADER_POLICY);

		db2JdbcProviderEClass = createEClass(DB2_JDBC_PROVIDER);
		createEAttribute(db2JdbcProviderEClass, DB2_JDBC_PROVIDER__JDBC_TYPE);
		createEAttribute(db2JdbcProviderEClass, DB2_JDBC_PROVIDER__TEMPLATE);

		db2JdbcProviderUnitEClass = createEClass(DB2_JDBC_PROVIDER_UNIT);

		derbyJdbcProviderEClass = createEClass(DERBY_JDBC_PROVIDER);
		createEAttribute(derbyJdbcProviderEClass, DERBY_JDBC_PROVIDER__TEMPLATE);

		derbyJdbcProviderUnitEClass = createEClass(DERBY_JDBC_PROVIDER_UNIT);

		extendedJdbcProviderEClass = createEClass(EXTENDED_JDBC_PROVIDER);

		extendedJdbcProviderUnitEClass = createEClass(EXTENDED_JDBC_PROVIDER_UNIT);

		hostNameAliasTypeEClass = createEClass(HOST_NAME_ALIAS_TYPE);
		createEAttribute(hostNameAliasTypeEClass, HOST_NAME_ALIAS_TYPE__HOSTNAME);
		createEAttribute(hostNameAliasTypeEClass, HOST_NAME_ALIAS_TYPE__HOSTNAME_ALIAS);

		sharedLibraryEntryEClass = createEClass(SHARED_LIBRARY_ENTRY);
		createEAttribute(sharedLibraryEntryEClass, SHARED_LIBRARY_ENTRY__CLASS_PATH);
		createEAttribute(sharedLibraryEntryEClass, SHARED_LIBRARY_ENTRY__NATIVE_PATH);
		createEAttribute(sharedLibraryEntryEClass, SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME);

		virtualHostTypeEClass = createEClass(VIRTUAL_HOST_TYPE);
		createEReference(virtualHostTypeEClass, VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS);
		createEAttribute(virtualHostTypeEClass, VIRTUAL_HOST_TYPE__HOST_NAME);

		wasAdvancedLdapConfigurationEClass = createEClass(WAS_ADVANCED_LDAP_CONFIGURATION);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_FILTER);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__CERTIFICATE_MAP_MODE);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_FILTER);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_ID_MAP);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__GROUP_MEMBER_ID_MAP);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__USER_FILTER);
		createEAttribute(wasAdvancedLdapConfigurationEClass, WAS_ADVANCED_LDAP_CONFIGURATION__USER_ID_MAP);

		wasApplicationClassLoaderPolicyEClass = createEClass(WAS_APPLICATION_CLASS_LOADER_POLICY);
		createEAttribute(wasApplicationClassLoaderPolicyEClass, WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_CLASSES);
		createEAttribute(wasApplicationClassLoaderPolicyEClass, WAS_APPLICATION_CLASS_LOADER_POLICY__RELOAD_INTERVAL);

		wasApplicationExtEClass = createEClass(WAS_APPLICATION_EXT);
		createEAttribute(wasApplicationExtEClass, WAS_APPLICATION_EXT__RELOAD_INTERVAL);
		createEAttribute(wasApplicationExtEClass, WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT);

		wasApplicationServerClassLoaderPolicyEClass = createEClass(WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY);

		wasCellEClass = createEClass(WAS_CELL);
		createEAttribute(wasCellEClass, WAS_CELL__CELL_NAME);
		createEAttribute(wasCellEClass, WAS_CELL__IS_DISTRIBUTED);
		createEAttribute(wasCellEClass, WAS_CELL__WAS_VERSION);

		wasCellUnitEClass = createEClass(WAS_CELL_UNIT);

		wasClassLoaderConfigurationUnitEClass = createEClass(WAS_CLASS_LOADER_CONFIGURATION_UNIT);

		wasClassLoaderPolicyEClass = createEClass(WAS_CLASS_LOADER_POLICY);
		createEAttribute(wasClassLoaderPolicyEClass, WAS_CLASS_LOADER_POLICY__ORDER);
		createEAttribute(wasClassLoaderPolicyEClass, WAS_CLASS_LOADER_POLICY__POLICY);

		wasClusterEClass = createEClass(WAS_CLUSTER);
		createEAttribute(wasClusterEClass, WAS_CLUSTER__CLUSTER_NAME);
		createEAttribute(wasClusterEClass, WAS_CLUSTER__CREATE_REPLICATION_DOMAIN);
		createEAttribute(wasClusterEClass, WAS_CLUSTER__PREFER_LOCAL);
		createEAttribute(wasClusterEClass, WAS_CLUSTER__WAS_VERSION);

		wasClusterUnitEClass = createEClass(WAS_CLUSTER_UNIT);

		wasConfigurationContainerEClass = createEClass(WAS_CONFIGURATION_CONTAINER);

		wasDatasourceEClass = createEClass(WAS_DATASOURCE);
		createEAttribute(wasDatasourceEClass, WAS_DATASOURCE__CATEGORY);
		createEAttribute(wasDatasourceEClass, WAS_DATASOURCE__CONNECTION_TIMEOUT);
		createEAttribute(wasDatasourceEClass, WAS_DATASOURCE__MAX_CONNECTIONS);
		createEAttribute(wasDatasourceEClass, WAS_DATASOURCE__MIN_CONNECTIONS);
		createEAttribute(wasDatasourceEClass, WAS_DATASOURCE__STATEMENT_CACHE_SIZE);

		wasDatasourceUnitEClass = createEClass(WAS_DATASOURCE_UNIT);

		wasDefaultMessagingConnectionFactoryConfigurationEClass = createEClass(WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX);
		createEAttribute(wasDefaultMessagingConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX);

		wasDefaultMessagingConnectionFactoryUnitEClass = createEClass(WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT);

		wasDefaultMessagingQueueConnectionFactoryConfigurationEClass = createEClass(WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__CATEGORY);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__TARGET);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE);
		createEAttribute(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX);

		wasDefaultMessagingQueueConnectionFactoryUnitEClass = createEClass(WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT);

		wasDefaultMessagingQueueDestinationEClass = createEClass(WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION);
		createEAttribute(wasDefaultMessagingQueueDestinationEClass, WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION__CONNECTION_DELIVERY_MODE);
		createEAttribute(wasDefaultMessagingQueueDestinationEClass, WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION__MESSAGE_LIVE_TIME);
		createEAttribute(wasDefaultMessagingQueueDestinationEClass, WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION__MESSAGE_PRIORITY);

		wasDefaultMessagingQueueDestinationUnitEClass = createEClass(WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT);

		wasDefaultMessagingTopicConnectionFactoryConfigurationEClass = createEClass(WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__CATEGORY);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__TARGET);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE);
		createEAttribute(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX);

		wasDefaultMessagingTopicConnectionFactoryUnitEClass = createEClass(WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT);

		wasDefaultMessagingTopicDestinationEClass = createEClass(WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION);
		createEAttribute(wasDefaultMessagingTopicDestinationEClass, WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE);
		createEAttribute(wasDefaultMessagingTopicDestinationEClass, WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME);
		createEAttribute(wasDefaultMessagingTopicDestinationEClass, WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY);
		createEAttribute(wasDefaultMessagingTopicDestinationEClass, WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME);

		wasDefaultMessagingTopicDestinationUnitEClass = createEClass(WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT);

		wasDeploymentManagerEClass = createEClass(WAS_DEPLOYMENT_MANAGER);

		wasDeploymentManagerUnitEClass = createEClass(WAS_DEPLOYMENT_MANAGER_UNIT);

		wasDeployRootEClass = createEClass(WAS_DEPLOY_ROOT);
		createEAttribute(wasDeployRootEClass, WAS_DEPLOY_ROOT__MIXED);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CLASSLOADER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__HOST_NAME_ALIAS);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT);
		createEReference(wasDeployRootEClass, WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT);

		wasEarClassloaderPolicyConstraintEClass = createEClass(WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT);
		createEAttribute(wasEarClassloaderPolicyConstraintEClass, WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT__POLICY);
		createEAttribute(wasEarClassloaderPolicyConstraintEClass, WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT__RELOAD_CLASSES);
		createEAttribute(wasEarClassloaderPolicyConstraintEClass, WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT__RELOAD_INTERVAL);

		wasEndpointListenerConfigurationEClass = createEClass(WAS_ENDPOINT_LISTENER_CONFIGURATION);
		createEAttribute(wasEndpointListenerConfigurationEClass, WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME);
		createEAttribute(wasEndpointListenerConfigurationEClass, WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT);
		createEAttribute(wasEndpointListenerConfigurationEClass, WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT);

		wasEndpointListenerUnitEClass = createEClass(WAS_ENDPOINT_LISTENER_UNIT);

		wasHandlerListEClass = createEClass(WAS_HANDLER_LIST);
		createEAttribute(wasHandlerListEClass, WAS_HANDLER_LIST__HANDLERLIST_NAME);

		wasj2CAuthenticationDataEntryEClass = createEClass(WASJ2C_AUTHENTICATION_DATA_ENTRY);

		wasj2CAuthenticationUnitEClass = createEClass(WASJ2C_AUTHENTICATION_UNIT);

		wasJ2EEConstraintEClass = createEClass(WAS_J2EE_CONSTRAINT);

		wasJ2EEServerEClass = createEClass(WAS_J2EE_SERVER);

		wasJMSActivationSpecificationEClass = createEClass(WAS_JMS_ACTIVATION_SPECIFICATION);
		createEAttribute(wasJMSActivationSpecificationEClass, WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME);
		createEAttribute(wasJMSActivationSpecificationEClass, WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE);
		createEAttribute(wasJMSActivationSpecificationEClass, WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS);
		createEAttribute(wasJMSActivationSpecificationEClass, WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION);

		wasJMSActivationSpecificationUnitEClass = createEClass(WAS_JMS_ACTIVATION_SPECIFICATION_UNIT);

		wasJNDIBindingConstraintEClass = createEClass(WAS_JNDI_BINDING_CONSTRAINT);
		createEAttribute(wasJNDIBindingConstraintEClass, WAS_JNDI_BINDING_CONSTRAINT__JNDI_NAME);

		wasLdapConfigurationEClass = createEClass(WAS_LDAP_CONFIGURATION);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__BASE_DN);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__BIND_DN);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__BIND_PASSWORD);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__IGNORE_CASE);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__LDAP_PORT);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__LIMIT);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__REALM);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__REUSE_CONNECTION);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__SERVER_ID);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__SERVER_PASSWORD);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__SSL_CONFIG);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__SSL_ENABLED);
		createEAttribute(wasLdapConfigurationEClass, WAS_LDAP_CONFIGURATION__TYPE);

		wasLdapConfigurationUnitEClass = createEClass(WAS_LDAP_CONFIGURATION_UNIT);

		wasMessagingEngineEClass = createEClass(WAS_MESSAGING_ENGINE);
		createEAttribute(wasMessagingEngineEClass, WAS_MESSAGING_ENGINE__ENGINE_NAME);

		wasMessagingEngineUnitEClass = createEClass(WAS_MESSAGING_ENGINE_UNIT);

		wasModuleClassLoaderPolicyEClass = createEClass(WAS_MODULE_CLASS_LOADER_POLICY);
		createEAttribute(wasModuleClassLoaderPolicyEClass, WAS_MODULE_CLASS_LOADER_POLICY__START_WEIGHT);

		wasModuleClassloaderPolicyConstraintEClass = createEClass(WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT);

		wasModuleStartWeightConstraintEClass = createEClass(WAS_MODULE_START_WEIGHT_CONSTRAINT);
		createEAttribute(wasModuleStartWeightConstraintEClass, WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT);

		wasNodeEClass = createEClass(WAS_NODE);
		createEAttribute(wasNodeEClass, WAS_NODE__IS_DEFAULT_PROFILE);
		createEAttribute(wasNodeEClass, WAS_NODE__IS_MANAGED);
		createEAttribute(wasNodeEClass, WAS_NODE__NODE_NAME);
		createEAttribute(wasNodeEClass, WAS_NODE__PROFILE_LOCATION);
		createEAttribute(wasNodeEClass, WAS_NODE__PROFILE_NAME);
		createEAttribute(wasNodeEClass, WAS_NODE__PROFILE_TYPE);
		createEAttribute(wasNodeEClass, WAS_NODE__WAS_VERSION);

		wasNodeGroupEClass = createEClass(WAS_NODE_GROUP);
		createEAttribute(wasNodeGroupEClass, WAS_NODE_GROUP__IS_DEFAULT_TYPE);
		createEAttribute(wasNodeGroupEClass, WAS_NODE_GROUP__NODE_GROUP_NAME);

		wasNodeGroupUnitEClass = createEClass(WAS_NODE_GROUP_UNIT);

		wasNodeUnitEClass = createEClass(WAS_NODE_UNIT);

		wasNodeWindowsServiceUnitEClass = createEClass(WAS_NODE_WINDOWS_SERVICE_UNIT);

		wasPluginAdminEClass = createEClass(WAS_PLUGIN_ADMIN);
		createEAttribute(wasPluginAdminEClass, WAS_PLUGIN_ADMIN__WAS_PLUGIN_VERSION);

		wasPluginRedirectionEClass = createEClass(WAS_PLUGIN_REDIRECTION);
		createEAttribute(wasPluginRedirectionEClass, WAS_PLUGIN_REDIRECTION__WAS_PLUGIN_VERSION);

		wasSecurityEClass = createEClass(WAS_SECURITY);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ACTIVE_AUTH_MECHANISM);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ACTIVE_PROTOCOL);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ACTIVE_USER_REGISTRY);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__CACHE_TIMEOUT);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ENFORCE_JAVA2_SECURITY);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__GLOBAL_SECURITY_ENABLED);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__ISSUE_PERMISSION_WARNING);
		createEAttribute(wasSecurityEClass, WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES);

		wasSecuritySubjectEClass = createEClass(WAS_SECURITY_SUBJECT);
		createEAttribute(wasSecuritySubjectEClass, WAS_SECURITY_SUBJECT__ACCESS_ID);
		createEAttribute(wasSecuritySubjectEClass, WAS_SECURITY_SUBJECT__SUBJECT_NAME);

		wasSecuritySubjectConstraintEClass = createEClass(WAS_SECURITY_SUBJECT_CONSTRAINT);
		createEAttribute(wasSecuritySubjectConstraintEClass, WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);

		wasServerEClass = createEClass(WAS_SERVER);
		createEAttribute(wasServerEClass, WAS_SERVER__SERVER_NAME);
		createEAttribute(wasServerEClass, WAS_SERVER__WAS_VERSION);

		wasSharedLibContainerEClass = createEClass(WAS_SHARED_LIB_CONTAINER);

		wasSharedLibraryEntryUnitEClass = createEClass(WAS_SHARED_LIBRARY_ENTRY_UNIT);

		wasSibDestinationEClass = createEClass(WAS_SIB_DESTINATION);
		createEAttribute(wasSibDestinationEClass, WAS_SIB_DESTINATION__DESTINATION_NAME);
		createEAttribute(wasSibDestinationEClass, WAS_SIB_DESTINATION__TYPE);

		wasSibDestinationUnitEClass = createEClass(WAS_SIB_DESTINATION_UNIT);

		wasSibForeignBusEClass = createEClass(WAS_SIB_FOREIGN_BUS);
		createEAttribute(wasSibForeignBusEClass, WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME);
		createEAttribute(wasSibForeignBusEClass, WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID);
		createEAttribute(wasSibForeignBusEClass, WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID);
		createEAttribute(wasSibForeignBusEClass, WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE);

		wasSibInboundPortEClass = createEClass(WAS_SIB_INBOUND_PORT);
		createEAttribute(wasSibInboundPortEClass, WAS_SIB_INBOUND_PORT__PORT_NAME);

		wasSibInboundPortUnitEClass = createEClass(WAS_SIB_INBOUND_PORT_UNIT);

		wasSibInboundServiceEClass = createEClass(WAS_SIB_INBOUND_SERVICE);
		createEAttribute(wasSibInboundServiceEClass, WAS_SIB_INBOUND_SERVICE__SERVICE_NAME);
		createEAttribute(wasSibInboundServiceEClass, WAS_SIB_INBOUND_SERVICE__WSDL_LOCATION);
		createEAttribute(wasSibInboundServiceEClass, WAS_SIB_INBOUND_SERVICE__WSDL_SERVICE_NAMESPACE);

		wasSibInboundServiceUnitEClass = createEClass(WAS_SIB_INBOUND_SERVICE_UNIT);

		wasSibMediationEClass = createEClass(WAS_SIB_MEDIATION);
		createEAttribute(wasSibMediationEClass, WAS_SIB_MEDIATION__HANDLER_LIST_NAME);
		createEAttribute(wasSibMediationEClass, WAS_SIB_MEDIATION__MEDIATION_NAME);

		wasSibMediationUnitEClass = createEClass(WAS_SIB_MEDIATION_UNIT);

		wasSibOutboundPortEClass = createEClass(WAS_SIB_OUTBOUND_PORT);
		createEAttribute(wasSibOutboundPortEClass, WAS_SIB_OUTBOUND_PORT__PORT_NAME);

		wasSibOutboundPortUnitEClass = createEClass(WAS_SIB_OUTBOUND_PORT_UNIT);

		wasSibOutboundServiceEClass = createEClass(WAS_SIB_OUTBOUND_SERVICE);
		createEAttribute(wasSibOutboundServiceEClass, WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME);
		createEAttribute(wasSibOutboundServiceEClass, WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION);
		createEAttribute(wasSibOutboundServiceEClass, WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE);

		wasSibOutboundServiceUnitEClass = createEClass(WAS_SIB_OUTBOUND_SERVICE_UNIT);

		wasSibServiceIntegrationBusLinkEClass = createEClass(WAS_SIB_SERVICE_INTEGRATION_BUS_LINK);
		createEAttribute(wasSibServiceIntegrationBusLinkEClass, WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS);
		createEAttribute(wasSibServiceIntegrationBusLinkEClass, WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME);
		createEAttribute(wasSibServiceIntegrationBusLinkEClass, WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME);
		createEAttribute(wasSibServiceIntegrationBusLinkEClass, WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME);

		wasSIBusEClass = createEClass(WAS_SI_BUS);
		createEAttribute(wasSIBusEClass, WAS_SI_BUS__BUS_NAME);
		createEAttribute(wasSIBusEClass, WAS_SI_BUS__CONFIGURATION_RELOAD);
		createEAttribute(wasSIBusEClass, WAS_SI_BUS__DISCARD_MESSAGES);
		createEAttribute(wasSIBusEClass, WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD);
		createEAttribute(wasSIBusEClass, WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN);

		wasSIBusUnitEClass = createEClass(WAS_SI_BUS_UNIT);

		wasSubstitutionVariableEClass = createEClass(WAS_SUBSTITUTION_VARIABLE);

		wasSystemEClass = createEClass(WAS_SYSTEM);
		createEAttribute(wasSystemEClass, WAS_SYSTEM__INSTALLER_DIR);
		createEAttribute(wasSystemEClass, WAS_SYSTEM__WAS_EDITION);
		createEAttribute(wasSystemEClass, WAS_SYSTEM__WAS_HOME);
		createEAttribute(wasSystemEClass, WAS_SYSTEM__WAS_VERSION);

		wasSystemUnitEClass = createEClass(WAS_SYSTEM_UNIT);

		wasV4DatasourceEClass = createEClass(WAS_V4_DATASOURCE);
		createEAttribute(wasV4DatasourceEClass, WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP);
		createEAttribute(wasV4DatasourceEClass, WAS_V4_DATASOURCE__IDLE_TIMEOUT);
		createEAttribute(wasV4DatasourceEClass, WAS_V4_DATASOURCE__ORPHAN_TIMEOUT);

		wasV5DatasourceEClass = createEClass(WAS_V5_DATASOURCE);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__AGED_TIMEOUT);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__J2C_AUTH_ALIAS);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__PURGE_POLICY);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__REAP_TIME);
		createEAttribute(wasV5DatasourceEClass, WAS_V5_DATASOURCE__UNUSED_TIMEOUT);

		wasV5DB2DatasourceEClass = createEClass(WAS_V5DB2_DATASOURCE);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__CLI_SCHEMA);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__DEFER_PREPARES);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__TRACE_FILE);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__TRACE_LEVEL);
		createEAttribute(wasV5DB2DatasourceEClass, WAS_V5DB2_DATASOURCE__USE_TEMPLATE);

		wasV5DB2ZosDatasourceEClass = createEClass(WAS_V5DB2_ZOS_DATASOURCE);

		wasWarClassloaderPolicyConstraintEClass = createEClass(WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT);
		createEAttribute(wasWarClassloaderPolicyConstraintEClass, WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT__ORDER);

		wasWebAppExtEClass = createEClass(WAS_WEB_APP_EXT);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__FILE_SERVING_ENABLED);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__RELOADING_ENABLED);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__RELOAD_INTERVAL);
		createEAttribute(wasWebAppExtEClass, WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED);

		wasWebServerEClass = createEClass(WAS_WEB_SERVER);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__CONFIG_FILE);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__HOST);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__INSTALL_LOCATION);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__LOG_FILE_ACCESS);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__LOG_FILE_ERROR);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__MAP_APPLICATIONS);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__OPERATING_SYSTEM);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__PORT);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__SERVER_NAME);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__SERVICE_NAME);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__TYPE);
		createEAttribute(wasWebServerEClass, WAS_WEB_SERVER__USE_SECURE_PROTOCOL);

		wasWebServerManagementEClass = createEClass(WAS_WEB_SERVER_MANAGEMENT);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__HOST);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__PASSWORD);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__PORT);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__USER_ID);
		createEAttribute(wasWebServerManagementEClass, WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL);

		wasWebServerPluginEClass = createEClass(WAS_WEB_SERVER_PLUGIN);
		createEAttribute(wasWebServerPluginEClass, WAS_WEB_SERVER_PLUGIN__INSTALL_LOCATION);

		wasWebServerUnitEClass = createEClass(WAS_WEB_SERVER_UNIT);

		websphereAppServerUnitEClass = createEClass(WEBSPHERE_APP_SERVER_UNIT);

		// Create enums
		acknowledgeModeEnumEEnum = createEEnum(ACKNOWLEDGE_MODE_ENUM);
		certificateMapModeEEnum = createEEnum(CERTIFICATE_MAP_MODE);
		cfTargetSignificanceEnumEEnum = createEEnum(CF_TARGET_SIGNIFICANCE_ENUM);
		classloaderModeEEnum = createEEnum(CLASSLOADER_MODE);
		classloaderPolicyTypeEEnum = createEEnum(CLASSLOADER_POLICY_TYPE);
		connectionDeliveryModeEnumEEnum = createEEnum(CONNECTION_DELIVERY_MODE_ENUM);
		connectionFactoryTargetTypeEnumEEnum = createEEnum(CONNECTION_FACTORY_TARGET_TYPE_ENUM);
		connectionProximityEnumEEnum = createEEnum(CONNECTION_PROXIMITY_ENUM);
		dataSourceHelperClassNamesEEnum = createEEnum(DATA_SOURCE_HELPER_CLASS_NAMES);
		db2DataSourceTemplateEnumEEnum = createEEnum(DB2_DATA_SOURCE_TEMPLATE_ENUM);
		db2JdbcProviderTypeEEnum = createEEnum(DB2_JDBC_PROVIDER_TYPE);
		derbyJdbcProviderTypeTypeEEnum = createEEnum(DERBY_JDBC_PROVIDER_TYPE_TYPE);
		endPointListenerNameEnumEEnum = createEEnum(END_POINT_LISTENER_NAME_ENUM);
		iiopSecurityProtocolsEEnum = createEEnum(IIOP_SECURITY_PROTOCOLS);
		jdbcImplementationTypeTypeEEnum = createEEnum(JDBC_IMPLEMENTATION_TYPE_TYPE);
		jmsDestinationTypeEnumEEnum = createEEnum(JMS_DESTINATION_TYPE_ENUM);
		ldapDirectoryTypeEEnum = createEEnum(LDAP_DIRECTORY_TYPE);
		messageReliabilityEnumEEnum = createEEnum(MESSAGE_RELIABILITY_ENUM);
		policiesEEnum = createEEnum(POLICIES);
		readAheadOptimizationEnumEEnum = createEEnum(READ_AHEAD_OPTIMIZATION_ENUM);
		shareDurableSubscriptionsEnumEEnum = createEEnum(SHARE_DURABLE_SUBSCRIPTIONS_ENUM);
		warClassloaderPolicyEEnum = createEEnum(WAR_CLASSLOADER_POLICY);
		wasAccountTypeEnumEEnum = createEEnum(WAS_ACCOUNT_TYPE_ENUM);
		wasApplicationMapEEnum = createEEnum(WAS_APPLICATION_MAP);
		wasDefaultSecuritySubjectEnumEEnum = createEEnum(WAS_DEFAULT_SECURITY_SUBJECT_ENUM);
		wasDeploymentManagerPortNamesEEnum = createEEnum(WAS_DEPLOYMENT_MANAGER_PORT_NAMES);
		wasEditionEnumEEnum = createEEnum(WAS_EDITION_ENUM);
		wasEndpointListenerTypeEEnum = createEEnum(WAS_ENDPOINT_LISTENER_TYPE);
		wasNodeGroupTypeEnumEEnum = createEEnum(WAS_NODE_GROUP_TYPE_ENUM);
		wasNodePortNamesEEnum = createEEnum(WAS_NODE_PORT_NAMES);
		wasProfileTypeEnumEEnum = createEEnum(WAS_PROFILE_TYPE_ENUM);
		wasRoutingDefinitionTypeEnumEEnum = createEEnum(WAS_ROUTING_DEFINITION_TYPE_ENUM);
		wasSibDestinationTypeEnumEEnum = createEEnum(WAS_SIB_DESTINATION_TYPE_ENUM);
		wasUserRegistryTypesEEnum = createEEnum(WAS_USER_REGISTRY_TYPES);
		wasWebServerNodeTypeEEnum = createEEnum(WAS_WEB_SERVER_NODE_TYPE);
		wasWebServerOSEEnum = createEEnum(WAS_WEB_SERVER_OS);
		wasWebServerTypeEEnum = createEEnum(WAS_WEB_SERVER_TYPE);
		websphereAppServerPortNamesEEnum = createEEnum(WEBSPHERE_APP_SERVER_PORT_NAMES);

		// Create data types
		acknowledgeModeEnumObjectEDataType = createEDataType(ACKNOWLEDGE_MODE_ENUM_OBJECT);
		certificateMapModeObjectEDataType = createEDataType(CERTIFICATE_MAP_MODE_OBJECT);
		cfTargetSignificanceEnumObjectEDataType = createEDataType(CF_TARGET_SIGNIFICANCE_ENUM_OBJECT);
		classloaderModeObjectEDataType = createEDataType(CLASSLOADER_MODE_OBJECT);
		classloaderPolicyTypeObjectEDataType = createEDataType(CLASSLOADER_POLICY_TYPE_OBJECT);
		connectionDeliveryModeEnumObjectEDataType = createEDataType(CONNECTION_DELIVERY_MODE_ENUM_OBJECT);
		connectionFactoryTargetTypeEnumObjectEDataType = createEDataType(CONNECTION_FACTORY_TARGET_TYPE_ENUM_OBJECT);
		connectionProximityEnumObjectEDataType = createEDataType(CONNECTION_PROXIMITY_ENUM_OBJECT);
		dataSourceHelperClassNamesObjectEDataType = createEDataType(DATA_SOURCE_HELPER_CLASS_NAMES_OBJECT);
		db2DataSourceTemplateEnumObjectEDataType = createEDataType(DB2_DATA_SOURCE_TEMPLATE_ENUM_OBJECT);
		db2JdbcProviderTypeObjectEDataType = createEDataType(DB2_JDBC_PROVIDER_TYPE_OBJECT);
		derbyJdbcProviderTypeTypeObjectEDataType = createEDataType(DERBY_JDBC_PROVIDER_TYPE_TYPE_OBJECT);
		endPointListenerNameEnumObjectEDataType = createEDataType(END_POINT_LISTENER_NAME_ENUM_OBJECT);
		iiopSecurityProtocolsObjectEDataType = createEDataType(IIOP_SECURITY_PROTOCOLS_OBJECT);
		jdbcImplementationTypeTypeObjectEDataType = createEDataType(JDBC_IMPLEMENTATION_TYPE_TYPE_OBJECT);
		jmsDestinationTypeEnumObjectEDataType = createEDataType(JMS_DESTINATION_TYPE_ENUM_OBJECT);
		ldapDirectoryTypeObjectEDataType = createEDataType(LDAP_DIRECTORY_TYPE_OBJECT);
		messageReliabilityEnumObjectEDataType = createEDataType(MESSAGE_RELIABILITY_ENUM_OBJECT);
		policiesObjectEDataType = createEDataType(POLICIES_OBJECT);
		readAheadOptimizationEnumObjectEDataType = createEDataType(READ_AHEAD_OPTIMIZATION_ENUM_OBJECT);
		shareDurableSubscriptionsEnumObjectEDataType = createEDataType(SHARE_DURABLE_SUBSCRIPTIONS_ENUM_OBJECT);
		warClassloaderPolicyObjectEDataType = createEDataType(WAR_CLASSLOADER_POLICY_OBJECT);
		wasAccountTypeEnumObjectEDataType = createEDataType(WAS_ACCOUNT_TYPE_ENUM_OBJECT);
		wasApplicationMapObjectEDataType = createEDataType(WAS_APPLICATION_MAP_OBJECT);
		wasDefaultSecuritySubjectEnumObjectEDataType = createEDataType(WAS_DEFAULT_SECURITY_SUBJECT_ENUM_OBJECT);
		wasDeploymentManagerPortNamesObjectEDataType = createEDataType(WAS_DEPLOYMENT_MANAGER_PORT_NAMES_OBJECT);
		wasEditionEnumObjectEDataType = createEDataType(WAS_EDITION_ENUM_OBJECT);
		wasEndpointListenerTypeObjectEDataType = createEDataType(WAS_ENDPOINT_LISTENER_TYPE_OBJECT);
		wasNodeGroupTypeEnumObjectEDataType = createEDataType(WAS_NODE_GROUP_TYPE_ENUM_OBJECT);
		wasNodePortNamesObjectEDataType = createEDataType(WAS_NODE_PORT_NAMES_OBJECT);
		wasProfileTypeEnumObjectEDataType = createEDataType(WAS_PROFILE_TYPE_ENUM_OBJECT);
		wasRoutingDefinitionTypeEnumObjectEDataType = createEDataType(WAS_ROUTING_DEFINITION_TYPE_ENUM_OBJECT);
		wasSibDestinationTypeEnumObjectEDataType = createEDataType(WAS_SIB_DESTINATION_TYPE_ENUM_OBJECT);
		wasUserRegistryTypesObjectEDataType = createEDataType(WAS_USER_REGISTRY_TYPES_OBJECT);
		wasWebServerNodeTypeObjectEDataType = createEDataType(WAS_WEB_SERVER_NODE_TYPE_OBJECT);
		wasWebServerOSObjectEDataType = createEDataType(WAS_WEB_SERVER_OS_OBJECT);
		wasWebServerTypeObjectEDataType = createEDataType(WAS_WEB_SERVER_TYPE_OBJECT);
		websphereAppServerPortNamesObjectEDataType = createEDataType(WEBSPHERE_APP_SERVER_PORT_NAMES_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		JavaPackage theJavaPackage = (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		J2eePackage theJ2eePackage = (J2eePackage)EPackage.Registry.INSTANCE.getEPackage(J2eePackage.eNS_URI);
		JmsPackage theJmsPackage = (JmsPackage)EPackage.Registry.INSTANCE.getEPackage(JmsPackage.eNS_URI);
		OsPackage theOsPackage = (OsPackage)EPackage.Registry.INSTANCE.getEPackage(OsPackage.eNS_URI);

		// Add supertypes to classes
		db2JdbcProviderEClass.getESuperTypes().add(this.getExtendedJdbcProvider());
		db2JdbcProviderUnitEClass.getESuperTypes().add(this.getExtendedJdbcProviderUnit());
		derbyJdbcProviderEClass.getESuperTypes().add(this.getExtendedJdbcProvider());
		derbyJdbcProviderUnitEClass.getESuperTypes().add(this.getExtendedJdbcProviderUnit());
		extendedJdbcProviderEClass.getESuperTypes().add(theJavaPackage.getJdbcProvider());
		extendedJdbcProviderUnitEClass.getESuperTypes().add(theJavaPackage.getJdbcProviderUnit());
		sharedLibraryEntryEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualHostTypeEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasAdvancedLdapConfigurationEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasApplicationClassLoaderPolicyEClass.getESuperTypes().add(this.getWasClassLoaderPolicy());
		wasApplicationExtEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasApplicationServerClassLoaderPolicyEClass.getESuperTypes().add(this.getWasClassLoaderPolicy());
		wasCellEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasCellUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasClassLoaderConfigurationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasClassLoaderPolicyEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasClusterEClass.getESuperTypes().add(this.getWasJ2EEServer());
		wasClusterUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasConfigurationContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasDatasourceEClass.getESuperTypes().add(theJ2eePackage.getJ2EEDatasource());
		wasDatasourceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasDefaultMessagingConnectionFactoryConfigurationEClass.getESuperTypes().add(theJmsPackage.getJMSConnectionFactory());
		wasDefaultMessagingConnectionFactoryUnitEClass.getESuperTypes().add(theJmsPackage.getJMSConnectionFactoryUnit());
		wasDefaultMessagingQueueConnectionFactoryConfigurationEClass.getESuperTypes().add(theJmsPackage.getJMSQueueConnectionFactory());
		wasDefaultMessagingQueueConnectionFactoryUnitEClass.getESuperTypes().add(theJmsPackage.getJMSQueueConnectionFactoryUnit());
		wasDefaultMessagingQueueDestinationEClass.getESuperTypes().add(theJmsPackage.getJMSQueueDestination());
		wasDefaultMessagingQueueDestinationUnitEClass.getESuperTypes().add(theJmsPackage.getJMSQueueDestinationUnit());
		wasDefaultMessagingTopicConnectionFactoryConfigurationEClass.getESuperTypes().add(theJmsPackage.getJMSTopicConnectionFactory());
		wasDefaultMessagingTopicConnectionFactoryUnitEClass.getESuperTypes().add(theJmsPackage.getJMSTopicConnectionFactoryUnit());
		wasDefaultMessagingTopicDestinationEClass.getESuperTypes().add(theJmsPackage.getJMSTopicDestination());
		wasDefaultMessagingTopicDestinationUnitEClass.getESuperTypes().add(theJmsPackage.getJMSTopicDestinationUnit());
		wasDeploymentManagerEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasDeploymentManagerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasEarClassloaderPolicyConstraintEClass.getESuperTypes().add(this.getWasWarClassloaderPolicyConstraint());
		wasEndpointListenerConfigurationEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasEndpointListenerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasHandlerListEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasj2CAuthenticationDataEntryEClass.getESuperTypes().add(theJ2eePackage.getJ2CAuthenticationDataEntry());
		wasj2CAuthenticationUnitEClass.getESuperTypes().add(theJ2eePackage.getJ2CAuthenticationUnit());
		wasJ2EEConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		wasJ2EEServerEClass.getESuperTypes().add(theJ2eePackage.getJ2EEServer());
		wasJMSActivationSpecificationEClass.getESuperTypes().add(theJmsPackage.getJMSActivationSpecification());
		wasJMSActivationSpecificationUnitEClass.getESuperTypes().add(theJmsPackage.getJMSActivationSpecificationUnit());
		wasJNDIBindingConstraintEClass.getESuperTypes().add(this.getWasJ2EEConstraint());
		wasLdapConfigurationEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasLdapConfigurationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasMessagingEngineEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasMessagingEngineUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasModuleClassLoaderPolicyEClass.getESuperTypes().add(this.getWasClassLoaderPolicy());
		wasModuleClassloaderPolicyConstraintEClass.getESuperTypes().add(this.getWasJ2EEConstraint());
		wasModuleStartWeightConstraintEClass.getESuperTypes().add(this.getWasJ2EEConstraint());
		wasNodeEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasNodeGroupEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasNodeGroupUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasNodeUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasNodeWindowsServiceUnitEClass.getESuperTypes().add(theOsPackage.getWindowsLocalServiceUnit());
		wasPluginAdminEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasPluginRedirectionEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSecurityEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSecuritySubjectEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSecuritySubjectConstraintEClass.getESuperTypes().add(this.getWasJ2EEConstraint());
		wasServerEClass.getESuperTypes().add(this.getWasJ2EEServer());
		wasSharedLibContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSharedLibraryEntryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibDestinationEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibDestinationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibForeignBusEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibInboundPortEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibInboundPortUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibInboundServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibInboundServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibMediationEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibMediationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibOutboundPortEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibOutboundPortUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibOutboundServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSibOutboundServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSibServiceIntegrationBusLinkEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSIBusEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSIBusUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasSubstitutionVariableEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		wasV4DatasourceEClass.getESuperTypes().add(this.getWasDatasource());
		wasV5DatasourceEClass.getESuperTypes().add(this.getWasDatasource());
		wasV5DB2DatasourceEClass.getESuperTypes().add(this.getWasV5Datasource());
		wasV5DB2ZosDatasourceEClass.getESuperTypes().add(this.getWasV5Datasource());
		wasWarClassloaderPolicyConstraintEClass.getESuperTypes().add(this.getWasModuleClassloaderPolicyConstraint());
		wasWebAppExtEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasWebServerEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasWebServerManagementEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasWebServerPluginEClass.getESuperTypes().add(theCorePackage.getCapability());
		wasWebServerUnitEClass.getESuperTypes().add(theJ2eePackage.getJ2EEServerUnit());
		websphereAppServerUnitEClass.getESuperTypes().add(theJ2eePackage.getJ2EEServerUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(classloaderEClass, Classloader.class, "Classloader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getClassloader_Mode(), this.getClassloaderMode(), "mode", "PARENT_FIRST", 0, 1, Classloader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getClassloader_StartWeight(), theXMLTypePackage.getInt(), "startWeight", null, 0, 1, Classloader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassloader_WarClassLoaderPolicy(), this.getWARClassloaderPolicy(), "warClassLoaderPolicy", "MODULE", 0, 1, Classloader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(db2JdbcProviderEClass, DB2JdbcProvider.class, "DB2JdbcProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2JdbcProvider_JdbcType(), theJavaPackage.getJdbcTypeType(), "jdbcType", "1", 0, 1, DB2JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDB2JdbcProvider_Template(), this.getDB2JdbcProviderType(), "template", "none", 0, 1, DB2JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(db2JdbcProviderUnitEClass, DB2JdbcProviderUnit.class, "DB2JdbcProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(derbyJdbcProviderEClass, DerbyJdbcProvider.class, "DerbyJdbcProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDerbyJdbcProvider_Template(), this.getDerbyJdbcProviderTypeType(), "template", "Cloudscape JDBC Provider", 0, 1, DerbyJdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(derbyJdbcProviderUnitEClass, DerbyJdbcProviderUnit.class, "DerbyJdbcProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(extendedJdbcProviderEClass, ExtendedJdbcProvider.class, "ExtendedJdbcProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(extendedJdbcProviderUnitEClass, ExtendedJdbcProviderUnit.class, "ExtendedJdbcProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(hostNameAliasTypeEClass, HostNameAliasType.class, "HostNameAliasType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getHostNameAliasType_Hostname(), theXMLTypePackage.getString(), "hostname", null, 0, 1, HostNameAliasType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getHostNameAliasType_HostnameAlias(), theXMLTypePackage.getString(), "hostnameAlias", null, 0, 1, HostNameAliasType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sharedLibraryEntryEClass, SharedLibraryEntry.class, "SharedLibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSharedLibraryEntry_ClassPath(), theXMLTypePackage.getString(), "classPath", null, 0, -1, SharedLibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSharedLibraryEntry_NativePath(), theXMLTypePackage.getString(), "nativePath", null, 0, -1, SharedLibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSharedLibraryEntry_SharedLibraryEntryName(), theXMLTypePackage.getString(), "sharedLibraryEntryName", null, 0, 1, SharedLibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(virtualHostTypeEClass, VirtualHostType.class, "VirtualHostType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVirtualHostType_HostNameAlias(), this.getHostNameAliasType(), null, "hostNameAlias", null, 1, 1, VirtualHostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualHostType_HostName(), theXMLTypePackage.getString(), "hostName", null, 0, 1, VirtualHostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasAdvancedLdapConfigurationEClass, WasAdvancedLdapConfiguration.class, "WasAdvancedLdapConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_CertificateFilter(), theXMLTypePackage.getString(), "certificateFilter", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_CertificateMapMode(), this.getCertificateMapMode(), "certificateMapMode", "EXACT_DN", 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasAdvancedLdapConfiguration_GroupFilter(), theXMLTypePackage.getString(), "groupFilter", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_GroupIdMap(), theXMLTypePackage.getString(), "groupIdMap", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_GroupMemberIdMap(), theXMLTypePackage.getString(), "groupMemberIdMap", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_UserFilter(), theXMLTypePackage.getString(), "userFilter", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasAdvancedLdapConfiguration_UserIdMap(), theXMLTypePackage.getString(), "userIdMap", null, 0, 1, WasAdvancedLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasApplicationClassLoaderPolicyEClass, WasApplicationClassLoaderPolicy.class, "WasApplicationClassLoaderPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasApplicationClassLoaderPolicy_ReloadClasses(), theXMLTypePackage.getBoolean(), "reloadClasses", null, 0, 1, WasApplicationClassLoaderPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasApplicationClassLoaderPolicy_ReloadInterval(), theXMLTypePackage.getInt(), "reloadInterval", null, 0, 1, WasApplicationClassLoaderPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasApplicationExtEClass, WasApplicationExt.class, "WasApplicationExt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasApplicationExt_ReloadInterval(), theXMLTypePackage.getLong(), "reloadInterval", null, 0, 1, WasApplicationExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasApplicationExt_ShareSessionContext(), theXMLTypePackage.getBoolean(), "shareSessionContext", null, 0, 1, WasApplicationExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasApplicationServerClassLoaderPolicyEClass, WasApplicationServerClassLoaderPolicy.class, "WasApplicationServerClassLoaderPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasCellEClass, WasCell.class, "WasCell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasCell_CellName(), theXMLTypePackage.getString(), "cellName", null, 0, 1, WasCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasCell_IsDistributed(), theXMLTypePackage.getBoolean(), "isDistributed", null, 0, 1, WasCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasCell_WasVersion(), theCorePackage.getVersionString(), "wasVersion", null, 0, 1, WasCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasCellUnitEClass, WasCellUnit.class, "WasCellUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasClassLoaderConfigurationUnitEClass, WasClassLoaderConfigurationUnit.class, "WasClassLoaderConfigurationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasClassLoaderPolicyEClass, WasClassLoaderPolicy.class, "WasClassLoaderPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasClassLoaderPolicy_Order(), this.getClassloaderMode(), "order", "PARENT_FIRST", 0, 1, WasClassLoaderPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasClassLoaderPolicy_Policy(), this.getClassloaderPolicyType(), "policy", "SINGLE", 0, 1, WasClassLoaderPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasClusterEClass, WasCluster.class, "WasCluster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasCluster_ClusterName(), theXMLTypePackage.getString(), "clusterName", null, 0, 1, WasCluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasCluster_CreateReplicationDomain(), theXMLTypePackage.getBoolean(), "createReplicationDomain", null, 0, 1, WasCluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasCluster_PreferLocal(), theXMLTypePackage.getBoolean(), "preferLocal", null, 0, 1, WasCluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasCluster_WasVersion(), theCorePackage.getVersionString(), "wasVersion", null, 0, 1, WasCluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasClusterUnitEClass, WasClusterUnit.class, "WasClusterUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasConfigurationContainerEClass, WasConfigurationContainer.class, "WasConfigurationContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDatasourceEClass, WasDatasource.class, "WasDatasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDatasource_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, WasDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDatasource_ConnectionTimeout(), theXMLTypePackage.getString(), "connectionTimeout", null, 0, 1, WasDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDatasource_MaxConnections(), theXMLTypePackage.getString(), "maxConnections", null, 0, 1, WasDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDatasource_MinConnections(), theXMLTypePackage.getString(), "minConnections", null, 0, 1, WasDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDatasource_StatementCacheSize(), theXMLTypePackage.getString(), "statementCacheSize", null, 0, 1, WasDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDatasourceUnitEClass, WasDatasourceUnit.class, "WasDatasourceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDefaultMessagingConnectionFactoryConfigurationEClass, WasDefaultMessagingConnectionFactoryConfiguration.class, "WasDefaultMessagingConnectionFactoryConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_ClientIdentifier(), theXMLTypePackage.getString(), "clientIdentifier", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_ConnectionProximity(), this.getConnectionProximityEnum(), "connectionProximity", "Bus", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_DurableSubscriptionHome(), theXMLTypePackage.getString(), "durableSubscriptionHome", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_NonpersistentMessageReliability(), this.getMessageReliabilityEnum(), "nonpersistentMessageReliability", "None", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_PersistentMessageReliability(), this.getMessageReliabilityEnum(), "persistentMessageReliability", "None", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_ProviderEndpoints(), theXMLTypePackage.getString(), "providerEndpoints", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_ReadAhead(), this.getReadAheadOptimizationEnum(), "readAhead", "Default", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_ShareDurableSubscriptions(), this.getShareDurableSubscriptionsEnum(), "shareDurableSubscriptions", "In cluster", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_Target(), theXMLTypePackage.getString(), "target", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_TargetInboundTransportChain(), theXMLTypePackage.getString(), "targetInboundTransportChain", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_TargetSignificance(), this.getCFTargetSignificanceEnum(), "targetSignificance", "Preferred", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_TargetType(), this.getConnectionFactoryTargetTypeEnum(), "targetType", "BusMember", 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_TempQnamePrefix(), theXMLTypePackage.getString(), "tempQnamePrefix", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingConnectionFactoryConfiguration_TempTopicNamePrefix(), theXMLTypePackage.getString(), "tempTopicNamePrefix", null, 0, 1, WasDefaultMessagingConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDefaultMessagingConnectionFactoryUnitEClass, WasDefaultMessagingConnectionFactoryUnit.class, "WasDefaultMessagingConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, "WasDefaultMessagingQueueConnectionFactoryConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_ClientIdentifier(), theXMLTypePackage.getString(), "clientIdentifier", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_ConnectionProximity(), this.getConnectionProximityEnum(), "connectionProximity", "Bus", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_NonpersistentMessageReliability(), this.getMessageReliabilityEnum(), "nonpersistentMessageReliability", "None", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_PersistentMessageReliability(), this.getMessageReliabilityEnum(), "persistentMessageReliability", "None", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_ProviderEndpoints(), theXMLTypePackage.getString(), "providerEndpoints", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_ReadAhead(), this.getReadAheadOptimizationEnum(), "readAhead", "Default", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_Target(), theXMLTypePackage.getString(), "target", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetInboundTransportChain(), theXMLTypePackage.getString(), "targetInboundTransportChain", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetSignificance(), this.getCFTargetSignificanceEnum(), "targetSignificance", "Preferred", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetType(), this.getConnectionFactoryTargetTypeEnum(), "targetType", "BusMember", 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueConnectionFactoryConfiguration_TempQNamePrefix(), theXMLTypePackage.getString(), "tempQNamePrefix", null, 0, 1, WasDefaultMessagingQueueConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDefaultMessagingQueueConnectionFactoryUnitEClass, WasDefaultMessagingQueueConnectionFactoryUnit.class, "WasDefaultMessagingQueueConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDefaultMessagingQueueDestinationEClass, WasDefaultMessagingQueueDestination.class, "WasDefaultMessagingQueueDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueDestination_ConnectionDeliveryMode(), this.getConnectionDeliveryModeEnum(), "connectionDeliveryMode", "Application", 0, 1, WasDefaultMessagingQueueDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingQueueDestination_MessageLiveTime(), theXMLTypePackage.getLong(), "messageLiveTime", null, 0, 1, WasDefaultMessagingQueueDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingQueueDestination_MessagePriority(), theXMLTypePackage.getInt(), "messagePriority", null, 0, 1, WasDefaultMessagingQueueDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDefaultMessagingQueueDestinationUnitEClass, WasDefaultMessagingQueueDestinationUnit.class, "WasDefaultMessagingQueueDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, "WasDefaultMessagingTopicConnectionFactoryConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_ClientIdentifier(), theXMLTypePackage.getString(), "clientIdentifier", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_ConnectionProximity(), this.getConnectionProximityEnum(), "connectionProximity", "Bus", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_DurableSubscriptionHome(), theXMLTypePackage.getString(), "durableSubscriptionHome", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_NonpersistentMessageReliability(), this.getMessageReliabilityEnum(), "nonpersistentMessageReliability", "None", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_PersistentMessageReliability(), this.getMessageReliabilityEnum(), "persistentMessageReliability", "None", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_ProviderEndpoints(), theXMLTypePackage.getString(), "providerEndpoints", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_ReadAhead(), this.getReadAheadOptimizationEnum(), "readAhead", "Default", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_ShareDurableSubscriptions(), this.getShareDurableSubscriptionsEnum(), "shareDurableSubscriptions", "In cluster", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_Target(), theXMLTypePackage.getString(), "target", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetInboundTransportChain(), theXMLTypePackage.getString(), "targetInboundTransportChain", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetSignificance(), this.getCFTargetSignificanceEnum(), "targetSignificance", "Preferred", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetType(), this.getConnectionFactoryTargetTypeEnum(), "targetType", "BusMember", 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicConnectionFactoryConfiguration_TempTopicNamePrefix(), theXMLTypePackage.getString(), "tempTopicNamePrefix", null, 0, 1, WasDefaultMessagingTopicConnectionFactoryConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDefaultMessagingTopicConnectionFactoryUnitEClass, WasDefaultMessagingTopicConnectionFactoryUnit.class, "WasDefaultMessagingTopicConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDefaultMessagingTopicDestinationEClass, WasDefaultMessagingTopicDestination.class, "WasDefaultMessagingTopicDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicDestination_ConnectionDeliveryMode(), this.getConnectionDeliveryModeEnum(), "connectionDeliveryMode", "Application", 0, 1, WasDefaultMessagingTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasDefaultMessagingTopicDestination_MessageLiveTime(), theXMLTypePackage.getLong(), "messageLiveTime", null, 0, 1, WasDefaultMessagingTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicDestination_MessagePriority(), theXMLTypePackage.getInt(), "messagePriority", null, 0, 1, WasDefaultMessagingTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasDefaultMessagingTopicDestination_TopicName(), theXMLTypePackage.getString(), "topicName", null, 0, 1, WasDefaultMessagingTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasDefaultMessagingTopicDestinationUnitEClass, WasDefaultMessagingTopicDestinationUnit.class, "WasDefaultMessagingTopicDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDeploymentManagerEClass, WasDeploymentManager.class, "WasDeploymentManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDeploymentManagerUnitEClass, WasDeploymentManagerUnit.class, "WasDeploymentManagerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasDeployRootEClass, WasDeployRoot.class, "WasDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityDb2JdbcProvider(), this.getDB2JdbcProvider(), null, "capabilityDb2JdbcProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityDerbyJdbcProvider(), this.getDerbyJdbcProvider(), null, "capabilityDerbyJdbcProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityExtendedJdbcProvider(), this.getExtendedJdbcProvider(), null, "capabilityExtendedJdbcProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasAdvancedLdapConfiguration(), this.getWasAdvancedLdapConfiguration(), null, "capabilityWasAdvancedLdapConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasApplicationClassLoaderPolicy(), this.getWasApplicationClassLoaderPolicy(), null, "capabilityWasApplicationClassLoaderPolicy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasApplicationExt(), this.getWasApplicationExt(), null, "capabilityWasApplicationExt", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasApplicationServerClassLoaderPolicy(), this.getWasApplicationServerClassLoaderPolicy(), null, "capabilityWasApplicationServerClassLoaderPolicy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasCell(), this.getWasCell(), null, "capabilityWasCell", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasClassLoaderPolicy(), this.getWasClassLoaderPolicy(), null, "capabilityWasClassLoaderPolicy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasCluster(), this.getWasCluster(), null, "capabilityWasCluster", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasConfigurationContainer(), this.getWasConfigurationContainer(), null, "capabilityWasConfigurationContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDatasource(), this.getWasDatasource(), null, "capabilityWasDatasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDefaultMessagingConnectionFactoryConfiguration(), this.getWasDefaultMessagingConnectionFactoryConfiguration(), null, "capabilityWasDefaultMessagingConnectionFactoryConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(), this.getWasDefaultMessagingQueueConnectionFactoryConfiguration(), null, "capabilityWasDefaultMessagingQueueConnectionFactoryConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDefaultMessagingQueueDestination(), this.getWasDefaultMessagingQueueDestination(), null, "capabilityWasDefaultMessagingQueueDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(), this.getWasDefaultMessagingTopicConnectionFactoryConfiguration(), null, "capabilityWasDefaultMessagingTopicConnectionFactoryConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDefaultMessagingTopicDestination(), this.getWasDefaultMessagingTopicDestination(), null, "capabilityWasDefaultMessagingTopicDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasDeploymentManager(), this.getWasDeploymentManager(), null, "capabilityWasDeploymentManager", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasEndpointListenerConfiguration(), this.getWasEndpointListenerConfiguration(), null, "capabilityWasEndpointListenerConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasHandlerList(), this.getWasHandlerList(), null, "capabilityWasHandlerList", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasJ2CAuth(), this.getWASJ2CAuthenticationDataEntry(), null, "capabilityWasJ2CAuth", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasJ2EEServer(), this.getWasJ2EEServer(), null, "capabilityWasJ2EEServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasJMSActivationSpecification(), this.getWasJMSActivationSpecification(), null, "capabilityWasJMSActivationSpecification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasLdapConfiguration(), this.getWasLdapConfiguration(), null, "capabilityWasLdapConfiguration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasMessagingEngine(), this.getWasMessagingEngine(), null, "capabilityWasMessagingEngine", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasModuleClassLoaderPolicy(), this.getWasModuleClassLoaderPolicy(), null, "capabilityWasModuleClassLoaderPolicy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasNode(), this.getWasNode(), null, "capabilityWasNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasNodeGroup(), this.getWasNodeGroup(), null, "capabilityWasNodeGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasPluginAdmin(), this.getWasPluginAdmin(), null, "capabilityWasPluginAdmin", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasPluginRedirection(), this.getWasPluginRedirection(), null, "capabilityWasPluginRedirection", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSecurity(), this.getWasSecurity(), null, "capabilityWasSecurity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSecuritySubject(), this.getWasSecuritySubject(), null, "capabilityWasSecuritySubject", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasServer(), this.getWasServer(), null, "capabilityWasServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSharedLibContainer(), this.getWasSharedLibContainer(), null, "capabilityWasSharedLibContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSharedLibrary(), this.getSharedLibraryEntry(), null, "capabilityWasSharedLibrary", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibDestination(), this.getWasSibDestination(), null, "capabilityWasSibDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibForeignBus(), this.getWasSibForeignBus(), null, "capabilityWasSibForeignBus", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibInboundPort(), this.getWasSibInboundPort(), null, "capabilityWasSibInboundPort", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibInboundService(), this.getWasSibInboundService(), null, "capabilityWasSibInboundService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibMediation(), this.getWasSibMediation(), null, "capabilityWasSibMediation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibOutboundPort(), this.getWasSibOutboundPort(), null, "capabilityWasSibOutboundPort", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibOutboundService(), this.getWasSibOutboundService(), null, "capabilityWasSibOutboundService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSibServiceIntegrationBusLink(), this.getWasSibServiceIntegrationBusLink(), null, "capabilityWasSibServiceIntegrationBusLink", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSIBus(), this.getWasSIBus(), null, "capabilityWasSIBus", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSubstitutionVariable(), this.getWasSubstitutionVariable(), null, "capabilityWasSubstitutionVariable", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasSystem(), this.getWasSystem(), null, "capabilityWasSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasv4datasource(), this.getWasV4Datasource(), null, "capabilityWasv4datasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasv5datasource(), this.getWasV5Datasource(), null, "capabilityWasv5datasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasv5DB2Datasource(), this.getWasV5DB2Datasource(), null, "capabilityWasv5DB2Datasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasv5DB2ZosDatasource(), this.getWasV5DB2ZosDatasource(), null, "capabilityWasv5DB2ZosDatasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasVirtualHost(), this.getVirtualHostType(), null, "capabilityWasVirtualHost", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasWebAppExt(), this.getWasWebAppExt(), null, "capabilityWasWebAppExt", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasWebServer(), this.getWasWebServer(), null, "capabilityWasWebServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasWebServerManagement(), this.getWasWebServerManagement(), null, "capabilityWasWebServerManagement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_CapabilityWasWebServerPlugin(), this.getWasWebServerPlugin(), null, "capabilityWasWebServerPlugin", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_Classloader(), this.getClassloader(), null, "classloader", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasEarClassloaderPolicyConstraint(), this.getWasEarClassloaderPolicyConstraint(), null, "constraintWasEarClassloaderPolicyConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasJ2EEConstraint(), this.getWasJ2EEConstraint(), null, "constraintWasJ2EEConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasJNDIBindingConstraint(), this.getWasJNDIBindingConstraint(), null, "constraintWasJNDIBindingConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasModuleClassloaderPolicyConstraint(), this.getWasModuleClassloaderPolicyConstraint(), null, "constraintWasModuleClassloaderPolicyConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasModuleStartWeightConstraint(), this.getWasModuleStartWeightConstraint(), null, "constraintWasModuleStartWeightConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasSecuritySubjectConstraint(), this.getWasSecuritySubjectConstraint(), null, "constraintWasSecuritySubjectConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_ConstraintWasWarClassloaderPolicyConstraint(), this.getWasWarClassloaderPolicyConstraint(), null, "constraintWasWarClassloaderPolicyConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_HostNameAlias(), this.getHostNameAliasType(), null, "hostNameAlias", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitDb2JdbcProviderUnit(), this.getDB2JdbcProviderUnit(), null, "unitDb2JdbcProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitDerbyJdbcProviderUnit(), this.getDerbyJdbcProviderUnit(), null, "unitDerbyJdbcProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitExtendedJdbcProviderUnit(), this.getExtendedJdbcProviderUnit(), null, "unitExtendedJdbcProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasAppServer(), this.getWebsphereAppServerUnit(), null, "unitWasAppServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasCellUnit(), this.getWasCellUnit(), null, "unitWasCellUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasClassLoaderConfigurationUnit(), this.getWasClassLoaderConfigurationUnit(), null, "unitWasClassLoaderConfigurationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasClusterUnit(), this.getWasClusterUnit(), null, "unitWasClusterUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasdatasource(), this.getWasDatasourceUnit(), null, "unitWasdatasource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDefaultMessagingConnectionFactoryUnit(), this.getWasDefaultMessagingConnectionFactoryUnit(), null, "unitWasDefaultMessagingConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDefaultMessagingQueueConnectionFactoryUnit(), this.getWasDefaultMessagingQueueConnectionFactoryUnit(), null, "unitWasDefaultMessagingQueueConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDefaultMessagingQueueDestinationUnit(), this.getWasDefaultMessagingQueueDestinationUnit(), null, "unitWasDefaultMessagingQueueDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDefaultMessagingTopicConnectionFactoryUnit(), this.getWasDefaultMessagingTopicConnectionFactoryUnit(), null, "unitWasDefaultMessagingTopicConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDefaultMessagingTopicDestinationUnit(), this.getWasDefaultMessagingTopicDestinationUnit(), null, "unitWasDefaultMessagingTopicDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasDeploymentManagerUnit(), this.getWasDeploymentManagerUnit(), null, "unitWasDeploymentManagerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasEndpointListenerUnit(), this.getWasEndpointListenerUnit(), null, "unitWasEndpointListenerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasJ2CAuth(), this.getWASJ2CAuthenticationUnit(), null, "unitWasJ2CAuth", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasJMSActivationSpecificationUnit(), this.getWasJMSActivationSpecificationUnit(), null, "unitWasJMSActivationSpecificationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasLdapConfigurationUnit(), this.getWasLdapConfigurationUnit(), null, "unitWasLdapConfigurationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasMessagingEngine(), this.getWasMessagingEngineUnit(), null, "unitWasMessagingEngine", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasNodeGroupUnit(), this.getWasNodeGroupUnit(), null, "unitWasNodeGroupUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasNodeUnit(), this.getWasNodeUnit(), null, "unitWasNodeUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasNodeWindowsServiceUnit(), this.getWasNodeWindowsServiceUnit(), null, "unitWasNodeWindowsServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSharedLibraryEntryUnit(), this.getWasSharedLibraryEntryUnit(), null, "unitWasSharedLibraryEntryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibDestinationUnit(), this.getWasSibDestinationUnit(), null, "unitWasSibDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibInboundPortUnit(), this.getWasSibInboundPortUnit(), null, "unitWasSibInboundPortUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibInboundServiceUnit(), this.getWasSibInboundServiceUnit(), null, "unitWasSibInboundServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibMediationUnit(), this.getWasSibMediationUnit(), null, "unitWasSibMediationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibOutboundPortUnit(), this.getWasSibOutboundPortUnit(), null, "unitWasSibOutboundPortUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSibOutboundServiceUnit(), this.getWasSibOutboundServiceUnit(), null, "unitWasSibOutboundServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSIBusUnit(), this.getWasSIBusUnit(), null, "unitWasSIBusUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasSystemUnit(), this.getWasSystemUnit(), null, "unitWasSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWasDeployRoot_UnitWasWebServerUnit(), this.getWasWebServerUnit(), null, "unitWasWebServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasEarClassloaderPolicyConstraintEClass, WasEarClassloaderPolicyConstraint.class, "WasEarClassloaderPolicyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasEarClassloaderPolicyConstraint_Policy(), this.getClassloaderPolicyType(), "policy", "SINGLE", 0, 1, WasEarClassloaderPolicyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasEarClassloaderPolicyConstraint_ReloadClasses(), theXMLTypePackage.getBoolean(), "reloadClasses", null, 0, 1, WasEarClassloaderPolicyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasEarClassloaderPolicyConstraint_ReloadInterval(), theXMLTypePackage.getInt(), "reloadInterval", null, 0, 1, WasEarClassloaderPolicyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasEndpointListenerConfigurationEClass, WasEndpointListenerConfiguration.class, "WasEndpointListenerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasEndpointListenerConfiguration_EndpointListenerName(), this.getEndPointListenerNameEnum(), "endpointListenerName", "SOAPHTTPChannel1", 0, 1, WasEndpointListenerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasEndpointListenerConfiguration_UrlRoot(), theXMLTypePackage.getString(), "urlRoot", null, 0, 1, WasEndpointListenerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasEndpointListenerConfiguration_WsdlUrlRoot(), theXMLTypePackage.getString(), "wsdlUrlRoot", null, 0, 1, WasEndpointListenerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasEndpointListenerUnitEClass, WasEndpointListenerUnit.class, "WasEndpointListenerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasHandlerListEClass, WasHandlerList.class, "WasHandlerList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasHandlerList_HandlerlistName(), theXMLTypePackage.getString(), "handlerlistName", null, 0, 1, WasHandlerList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasj2CAuthenticationDataEntryEClass, WASJ2CAuthenticationDataEntry.class, "WASJ2CAuthenticationDataEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasj2CAuthenticationUnitEClass, WASJ2CAuthenticationUnit.class, "WASJ2CAuthenticationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasJ2EEConstraintEClass, WasJ2EEConstraint.class, "WasJ2EEConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasJ2EEServerEClass, WasJ2EEServer.class, "WasJ2EEServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasJMSActivationSpecificationEClass, WasJMSActivationSpecification.class, "WasJMSActivationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasJMSActivationSpecification_DurableScriptionHome(), theXMLTypePackage.getString(), "durableScriptionHome", null, 0, 1, WasJMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasJMSActivationSpecification_MaxBatchSize(), theXMLTypePackage.getInt(), "maxBatchSize", null, 0, 1, WasJMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasJMSActivationSpecification_MaxConcurrentEndpoints(), theXMLTypePackage.getInt(), "maxConcurrentEndpoints", null, 0, 1, WasJMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasJMSActivationSpecification_ShareDurableSubscription(), this.getShareDurableSubscriptionsEnum(), "shareDurableSubscription", "In cluster", 0, 1, WasJMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasJMSActivationSpecificationUnitEClass, WasJMSActivationSpecificationUnit.class, "WasJMSActivationSpecificationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasJNDIBindingConstraintEClass, WasJNDIBindingConstraint.class, "WasJNDIBindingConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasJNDIBindingConstraint_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, WasJNDIBindingConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasLdapConfigurationEClass, WasLdapConfiguration.class, "WasLdapConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_BaseDN(), theXMLTypePackage.getString(), "baseDN", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_BindDN(), theXMLTypePackage.getString(), "bindDN", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_BindPassword(), theXMLTypePackage.getString(), "bindPassword", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_IgnoreCase(), theXMLTypePackage.getBoolean(), "ignoreCase", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_LdapHostname(), theXMLTypePackage.getString(), "ldapHostname", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_LdapPort(), theXMLTypePackage.getInteger(), "ldapPort", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_Limit(), theXMLTypePackage.getString(), "limit", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_MonitorInterval(), theXMLTypePackage.getString(), "monitorInterval", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_Realm(), theXMLTypePackage.getString(), "realm", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_ReuseConnection(), theXMLTypePackage.getBoolean(), "reuseConnection", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_SearchTimeout(), theXMLTypePackage.getString(), "searchTimeout", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_ServerId(), theXMLTypePackage.getString(), "serverId", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_ServerPassword(), theXMLTypePackage.getString(), "serverPassword", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_SslConfig(), theXMLTypePackage.getString(), "sslConfig", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_SslEnabled(), theXMLTypePackage.getBoolean(), "sslEnabled", null, 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasLdapConfiguration_Type(), this.getLDAPDirectoryType(), "type", "IBM_DIRECTORY_SERVER", 0, 1, WasLdapConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasLdapConfigurationUnitEClass, WasLdapConfigurationUnit.class, "WasLdapConfigurationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasMessagingEngineEClass, WasMessagingEngine.class, "WasMessagingEngine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasMessagingEngine_EngineName(), theXMLTypePackage.getString(), "engineName", null, 0, 1, WasMessagingEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasMessagingEngineUnitEClass, WasMessagingEngineUnit.class, "WasMessagingEngineUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasModuleClassLoaderPolicyEClass, WasModuleClassLoaderPolicy.class, "WasModuleClassLoaderPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasModuleClassLoaderPolicy_StartWeight(), theXMLTypePackage.getInt(), "startWeight", null, 0, 1, WasModuleClassLoaderPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasModuleClassloaderPolicyConstraintEClass, WasModuleClassloaderPolicyConstraint.class, "WasModuleClassloaderPolicyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasModuleStartWeightConstraintEClass, WasModuleStartWeightConstraint.class, "WasModuleStartWeightConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasModuleStartWeightConstraint_StartingWeight(), theXMLTypePackage.getInt(), "startingWeight", null, 0, 1, WasModuleStartWeightConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasNodeEClass, WasNode.class, "WasNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasNode_IsDefaultProfile(), theXMLTypePackage.getBoolean(), "isDefaultProfile", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNode_IsManaged(), theXMLTypePackage.getBoolean(), "isManaged", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNode_NodeName(), theXMLTypePackage.getString(), "nodeName", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNode_ProfileLocation(), theXMLTypePackage.getString(), "profileLocation", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNode_ProfileName(), theXMLTypePackage.getString(), "profileName", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNode_ProfileType(), this.getWasProfileTypeEnum(), "profileType", "dmgr", 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasNode_WasVersion(), theCorePackage.getVersionString(), "wasVersion", null, 0, 1, WasNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasNodeGroupEClass, WasNodeGroup.class, "WasNodeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasNodeGroup_IsDefaultType(), theXMLTypePackage.getBoolean(), "isDefaultType", null, 0, 1, WasNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasNodeGroup_NodeGroupName(), theXMLTypePackage.getString(), "nodeGroupName", null, 0, 1, WasNodeGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasNodeGroupUnitEClass, WasNodeGroupUnit.class, "WasNodeGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasNodeUnitEClass, WasNodeUnit.class, "WasNodeUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasNodeWindowsServiceUnitEClass, WasNodeWindowsServiceUnit.class, "WasNodeWindowsServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasPluginAdminEClass, WasPluginAdmin.class, "WasPluginAdmin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasPluginAdmin_WasPluginVersion(), theCorePackage.getVersionString(), "wasPluginVersion", null, 0, 1, WasPluginAdmin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasPluginRedirectionEClass, WasPluginRedirection.class, "WasPluginRedirection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasPluginRedirection_WasPluginVersion(), theCorePackage.getVersionString(), "wasPluginVersion", null, 0, 1, WasPluginRedirection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSecurityEClass, WasSecurity.class, "WasSecurity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSecurity_ActiveAuthMechanism(), theXMLTypePackage.getString(), "activeAuthMechanism", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_ActiveProtocol(), this.getIIOPSecurityProtocols(), "activeProtocol", "IBM", 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasSecurity_ActiveUserRegistry(), this.getWasUserRegistryTypes(), "activeUserRegistry", "OS", 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasSecurity_AllowAllPermissionForApplication(), theXMLTypePackage.getBoolean(), "allowAllPermissionForApplication", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_CacheTimeout(), theXMLTypePackage.getString(), "cacheTimeout", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_EnforceFineGrainedJCASecurity(), theXMLTypePackage.getBoolean(), "enforceFineGrainedJCASecurity", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_EnforceJava2SecRuntimeFiletering(), theXMLTypePackage.getBoolean(), "enforceJava2SecRuntimeFiletering", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_EnforceJava2Security(), theXMLTypePackage.getBoolean(), "enforceJava2Security", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_GlobalSecurityEnabled(), theXMLTypePackage.getBoolean(), "globalSecurityEnabled", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_IssuePermissionWarning(), theXMLTypePackage.getBoolean(), "issuePermissionWarning", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecurity_UseDomainQualifiedNames(), theXMLTypePackage.getBoolean(), "useDomainQualifiedNames", null, 0, 1, WasSecurity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSecuritySubjectEClass, WasSecuritySubject.class, "WasSecuritySubject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSecuritySubject_AccessId(), theXMLTypePackage.getString(), "accessId", null, 0, 1, WasSecuritySubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSecuritySubject_SubjectName(), theXMLTypePackage.getString(), "subjectName", null, 0, 1, WasSecuritySubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSecuritySubjectConstraintEClass, WasSecuritySubjectConstraint.class, "WasSecuritySubjectConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSecuritySubjectConstraint_WasSecuritySubject(), theXMLTypePackage.getString(), "wasSecuritySubject", null, 1, 1, WasSecuritySubjectConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasServerEClass, WasServer.class, "WasServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasServer_ServerName(), theXMLTypePackage.getString(), "serverName", null, 0, 1, WasServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasServer_WasVersion(), theCorePackage.getVersionString(), "wasVersion", null, 0, 1, WasServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSharedLibContainerEClass, WasSharedLibContainer.class, "WasSharedLibContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSharedLibraryEntryUnitEClass, WasSharedLibraryEntryUnit.class, "WasSharedLibraryEntryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibDestinationEClass, WasSibDestination.class, "WasSibDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibDestination_DestinationName(), theXMLTypePackage.getString(), "destinationName", null, 0, 1, WasSibDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibDestination_Type(), this.getWasSibDestinationTypeEnum(), "type", "WebService", 0, 1, WasSibDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasSibDestinationUnitEClass, WasSibDestinationUnit.class, "WasSibDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibForeignBusEClass, WasSibForeignBus.class, "WasSibForeignBus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibForeignBus_ForeignBusName(), theXMLTypePackage.getString(), "foreignBusName", null, 0, 1, WasSibForeignBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibForeignBus_InBoundUserID(), theXMLTypePackage.getString(), "inBoundUserID", null, 0, 1, WasSibForeignBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibForeignBus_OutBoundUserID(), theXMLTypePackage.getString(), "outBoundUserID", null, 0, 1, WasSibForeignBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibForeignBus_RoutingDefinitionType(), this.getWasRoutingDefinitionTypeEnum(), "routingDefinitionType", "Direct,Service Integration Bus link", 0, 1, WasSibForeignBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasSibInboundPortEClass, WasSibInboundPort.class, "WasSibInboundPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibInboundPort_PortName(), theXMLTypePackage.getString(), "portName", null, 0, 1, WasSibInboundPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSibInboundPortUnitEClass, WasSibInboundPortUnit.class, "WasSibInboundPortUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibInboundServiceEClass, WasSibInboundService.class, "WasSibInboundService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibInboundService_ServiceName(), theXMLTypePackage.getString(), "serviceName", null, 0, 1, WasSibInboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibInboundService_WsdlLocation(), theXMLTypePackage.getAnyURI(), "wsdlLocation", null, 0, 1, WasSibInboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibInboundService_WsdlServiceNamespace(), theXMLTypePackage.getString(), "wsdlServiceNamespace", null, 0, 1, WasSibInboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSibInboundServiceUnitEClass, WasSibInboundServiceUnit.class, "WasSibInboundServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibMediationEClass, WasSibMediation.class, "WasSibMediation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibMediation_HandlerListName(), theXMLTypePackage.getString(), "handlerListName", null, 0, 1, WasSibMediation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibMediation_MediationName(), theXMLTypePackage.getString(), "mediationName", null, 0, 1, WasSibMediation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSibMediationUnitEClass, WasSibMediationUnit.class, "WasSibMediationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibOutboundPortEClass, WasSibOutboundPort.class, "WasSibOutboundPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibOutboundPort_PortName(), theXMLTypePackage.getString(), "portName", null, 0, 1, WasSibOutboundPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSibOutboundPortUnitEClass, WasSibOutboundPortUnit.class, "WasSibOutboundPortUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibOutboundServiceEClass, WasSibOutboundService.class, "WasSibOutboundService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibOutboundService_ServiceName(), theXMLTypePackage.getString(), "serviceName", null, 0, 1, WasSibOutboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibOutboundService_WsdlLocation(), theXMLTypePackage.getAnyURI(), "wsdlLocation", null, 0, 1, WasSibOutboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibOutboundService_WsdlServiceNamespace(), theXMLTypePackage.getString(), "wsdlServiceNamespace", null, 0, 1, WasSibOutboundService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSibOutboundServiceUnitEClass, WasSibOutboundServiceUnit.class, "WasSibOutboundServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSibServiceIntegrationBusLinkEClass, WasSibServiceIntegrationBusLink.class, "WasSibServiceIntegrationBusLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSibServiceIntegrationBusLink_BootTrapEndpoints(), theXMLTypePackage.getString(), "bootTrapEndpoints", null, 0, 1, WasSibServiceIntegrationBusLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibServiceIntegrationBusLink_ForeignBusName(), theXMLTypePackage.getString(), "foreignBusName", null, 0, 1, WasSibServiceIntegrationBusLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibServiceIntegrationBusLink_LinkName(), theXMLTypePackage.getString(), "linkName", null, 0, 1, WasSibServiceIntegrationBusLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSibServiceIntegrationBusLink_RemoteMessagingEngineName(), theXMLTypePackage.getString(), "remoteMessagingEngineName", null, 0, 1, WasSibServiceIntegrationBusLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSIBusEClass, WasSIBus.class, "WasSIBus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSIBus_BusName(), theXMLTypePackage.getString(), "busName", null, 0, 1, WasSIBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSIBus_ConfigurationReload(), theXMLTypePackage.getBoolean(), "configurationReload", null, 0, 1, WasSIBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSIBus_DiscardMessages(), theXMLTypePackage.getBoolean(), "discardMessages", null, 0, 1, WasSIBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSIBus_HighMessageThreshold(), theXMLTypePackage.getInt(), "highMessageThreshold", "50000", 0, 1, WasSIBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasSIBus_InterEngineTransportChain(), theXMLTypePackage.getString(), "interEngineTransportChain", null, 0, 1, WasSIBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSIBusUnitEClass, WasSIBusUnit.class, "WasSIBusUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSubstitutionVariableEClass, WasSubstitutionVariable.class, "WasSubstitutionVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasSystemEClass, WasSystem.class, "WasSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasSystem_InstallerDir(), theXMLTypePackage.getString(), "installerDir", null, 0, 1, WasSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSystem_WasEdition(), this.getWasEditionEnum(), "wasEdition", "Base", 0, 1, WasSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasSystem_WasHome(), theXMLTypePackage.getString(), "wasHome", null, 0, 1, WasSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasSystem_WasVersion(), theCorePackage.getVersionString(), "wasVersion", null, 0, 1, WasSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasSystemUnitEClass, WasSystemUnit.class, "WasSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasV4DatasourceEClass, WasV4Datasource.class, "WasV4Datasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasV4Datasource_DisableAutoConnectionCleanup(), theXMLTypePackage.getBoolean(), "disableAutoConnectionCleanup", null, 0, 1, WasV4Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV4Datasource_IdleTimeout(), theXMLTypePackage.getString(), "idleTimeout", null, 0, 1, WasV4Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV4Datasource_OrphanTimeout(), theXMLTypePackage.getString(), "orphanTimeout", null, 0, 1, WasV4Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasV5DatasourceEClass, WasV5Datasource.class, "WasV5Datasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasV5Datasource_AgedTimeout(), theXMLTypePackage.getString(), "agedTimeout", null, 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5Datasource_DataSourceHelperClassName(), this.getDataSourceHelperClassNames(), "dataSourceHelperClassName", "com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper", 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasV5Datasource_J2cAuthAlias(), theXMLTypePackage.getString(), "j2cAuthAlias", null, 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5Datasource_PurgePolicy(), this.getPolicies(), "purgePolicy", "EntirePool", 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasV5Datasource_ReapTime(), theXMLTypePackage.getString(), "reapTime", null, 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5Datasource_UnusedTimeout(), theXMLTypePackage.getString(), "unusedTimeout", null, 0, 1, WasV5Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasV5DB2DatasourceEClass, WasV5DB2Datasource.class, "WasV5DB2Datasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_CliSchema(), theXMLTypePackage.getString(), "cliSchema", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_CurrentPackageSet(), theXMLTypePackage.getString(), "currentPackageSet", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_CurrentSchema(), theXMLTypePackage.getString(), "currentSchema", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_DeferPrepares(), theXMLTypePackage.getBoolean(), "deferPrepares", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_FullyMaterializeLobData(), theXMLTypePackage.getBoolean(), "fullyMaterializeLobData", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_ResultSetHoldability(), theXMLTypePackage.getInt(), "resultSetHoldability", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_TraceFile(), theXMLTypePackage.getString(), "traceFile", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_TraceLevel(), theXMLTypePackage.getInt(), "traceLevel", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasV5DB2Datasource_UseTemplate(), theXMLTypePackage.getBoolean(), "useTemplate", null, 0, 1, WasV5DB2Datasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasV5DB2ZosDatasourceEClass, WasV5DB2ZosDatasource.class, "WasV5DB2ZosDatasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wasWarClassloaderPolicyConstraintEClass, WasWarClassloaderPolicyConstraint.class, "WasWarClassloaderPolicyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWarClassloaderPolicyConstraint_Order(), this.getClassloaderMode(), "order", "PARENT_FIRST", 0, 1, WasWarClassloaderPolicyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(wasWebAppExtEClass, WasWebAppExt.class, "WasWebAppExt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_AdditionalClassPath(), theXMLTypePackage.getString(), "additionalClassPath", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_AutoLoadFilters(), theXMLTypePackage.getBoolean(), "autoLoadFilters", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_AutoRequestEncoding(), theXMLTypePackage.getBoolean(), "autoRequestEncoding", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_AutoResponseEncoding(), theXMLTypePackage.getBoolean(), "autoResponseEncoding", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_DefaultErrorPage(), theXMLTypePackage.getString(), "defaultErrorPage", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_DirectoryBrowsingEnabled(), theXMLTypePackage.getBoolean(), "directoryBrowsingEnabled", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_FileServingEnabled(), theXMLTypePackage.getBoolean(), "fileServingEnabled", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_PreCompileJSPs(), theXMLTypePackage.getBoolean(), "preCompileJSPs", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_ReloadingEnabled(), theXMLTypePackage.getBoolean(), "reloadingEnabled", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_ReloadInterval(), theXMLTypePackage.getInt(), "reloadInterval", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebAppExt_ServeServletsByClassnameEnabled(), theXMLTypePackage.getBoolean(), "serveServletsByClassnameEnabled", null, 0, 1, WasWebAppExt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasWebServerEClass, WasWebServer.class, "WasWebServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWebServer_ConfigFile(), theXMLTypePackage.getString(), "configFile", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_Host(), theXMLTypePackage.getString(), "host", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_LogFileAccess(), theXMLTypePackage.getString(), "logFileAccess", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_LogFileError(), theXMLTypePackage.getString(), "logFileError", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_MapApplications(), this.getWasApplicationMap(), "mapApplications", "MAP_NONE", 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasWebServer_OperatingSystem(), this.getWasWebServerOS(), "operatingSystem", "WINDOWS", 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasWebServer_Port(), theXMLTypePackage.getInteger(), "port", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_ServerName(), theXMLTypePackage.getString(), "serverName", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_ServiceName(), theXMLTypePackage.getString(), "serviceName", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServer_Type(), this.getWasWebServerType(), "type", "IHS", 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getWasWebServer_UseSecureProtocol(), theXMLTypePackage.getBoolean(), "useSecureProtocol", null, 0, 1, WasWebServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasWebServerManagementEClass, WasWebServerManagement.class, "WasWebServerManagement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_AutoConfigPropagation(), theXMLTypePackage.getBoolean(), "autoConfigPropagation", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_Host(), theXMLTypePackage.getString(), "host", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_Port(), theXMLTypePackage.getInteger(), "port", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_UserId(), theXMLTypePackage.getString(), "userId", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWasWebServerManagement_UseSecureProtocol(), theXMLTypePackage.getBoolean(), "useSecureProtocol", null, 0, 1, WasWebServerManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasWebServerPluginEClass, WasWebServerPlugin.class, "WasWebServerPlugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWasWebServerPlugin_InstallLocation(), theXMLTypePackage.getString(), "installLocation", null, 0, 1, WasWebServerPlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wasWebServerUnitEClass, WasWebServerUnit.class, "WasWebServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(websphereAppServerUnitEClass, WebsphereAppServerUnit.class, "WebsphereAppServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.class, "AcknowledgeModeEnum"); //$NON-NLS-1$
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.AUTO_ACKNOWLEDGE_LITERAL);
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL);
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.NON_PERSISTENT_LITERAL);

		initEEnum(certificateMapModeEEnum, CertificateMapMode.class, "CertificateMapMode"); //$NON-NLS-1$
		addEEnumLiteral(certificateMapModeEEnum, CertificateMapMode.EXACTDN_LITERAL);
		addEEnumLiteral(certificateMapModeEEnum, CertificateMapMode.CERTIFICATEFILTER_LITERAL);
		addEEnumLiteral(certificateMapModeEEnum, CertificateMapMode.OTHER_LITERAL);

		initEEnum(cfTargetSignificanceEnumEEnum, CFTargetSignificanceEnum.class, "CFTargetSignificanceEnum"); //$NON-NLS-1$
		addEEnumLiteral(cfTargetSignificanceEnumEEnum, CFTargetSignificanceEnum.PREFERRED_LITERAL);
		addEEnumLiteral(cfTargetSignificanceEnumEEnum, CFTargetSignificanceEnum.REQUIRED_LITERAL);

		initEEnum(classloaderModeEEnum, ClassloaderMode.class, "ClassloaderMode"); //$NON-NLS-1$
		addEEnumLiteral(classloaderModeEEnum, ClassloaderMode.PARENTFIRST_LITERAL);
		addEEnumLiteral(classloaderModeEEnum, ClassloaderMode.PARENTLAST_LITERAL);

		initEEnum(classloaderPolicyTypeEEnum, ClassloaderPolicyType.class, "ClassloaderPolicyType"); //$NON-NLS-1$
		addEEnumLiteral(classloaderPolicyTypeEEnum, ClassloaderPolicyType.SINGLE_LITERAL);
		addEEnumLiteral(classloaderPolicyTypeEEnum, ClassloaderPolicyType.MULTIPLE_LITERAL);

		initEEnum(connectionDeliveryModeEnumEEnum, ConnectionDeliveryModeEnum.class, "ConnectionDeliveryModeEnum"); //$NON-NLS-1$
		addEEnumLiteral(connectionDeliveryModeEnumEEnum, ConnectionDeliveryModeEnum.APPLICATION_LITERAL);
		addEEnumLiteral(connectionDeliveryModeEnumEEnum, ConnectionDeliveryModeEnum.PERSISTENT_LITERAL);
		addEEnumLiteral(connectionDeliveryModeEnumEEnum, ConnectionDeliveryModeEnum.NON_PERSISTENT_LITERAL);

		initEEnum(connectionFactoryTargetTypeEnumEEnum, ConnectionFactoryTargetTypeEnum.class, "ConnectionFactoryTargetTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(connectionFactoryTargetTypeEnumEEnum, ConnectionFactoryTargetTypeEnum.BUS_MEMBER_LITERAL);
		addEEnumLiteral(connectionFactoryTargetTypeEnumEEnum, ConnectionFactoryTargetTypeEnum.CUSTOM_LITERAL);
		addEEnumLiteral(connectionFactoryTargetTypeEnumEEnum, ConnectionFactoryTargetTypeEnum.ME_LITERAL);

		initEEnum(connectionProximityEnumEEnum, ConnectionProximityEnum.class, "ConnectionProximityEnum"); //$NON-NLS-1$
		addEEnumLiteral(connectionProximityEnumEEnum, ConnectionProximityEnum.BUS_LITERAL);
		addEEnumLiteral(connectionProximityEnumEEnum, ConnectionProximityEnum.HOST_LITERAL);
		addEEnumLiteral(connectionProximityEnumEEnum, ConnectionProximityEnum.CLUSTER_LITERAL);
		addEEnumLiteral(connectionProximityEnumEEnum, ConnectionProximityEnum.SERVER_LITERAL);

		initEEnum(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.class, "DataSourceHelperClassNames"); //$NON-NLS-1$
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_UNIVERSAL_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CLOUDSCAPE_NETWORK_SERVER_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_INFORMIX_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_SYBASE_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_ORACLE_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CONNECT_JDBC_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_WS_CONNECT_JDBC_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_SEQUE_LINK_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_MSSQL_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CONNECT_JDBC_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DATA_DIRECT_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2390_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_SYBASE11_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CLOUDSCAPE_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2AS400_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_ORACLE10G_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2390_LOCAL_DATA_STORE_HELPER_CLASS_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DERBY_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DERBY_NETWORK_SERVER_DATA_STORE_HELPER_LITERAL);
		addEEnumLiteral(dataSourceHelperClassNamesEEnum, DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_GENERIC_DATA_STORE_HELPER_LITERAL);

		initEEnum(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.class, "DB2DataSourceTemplateEnum"); //$NON-NLS-1$
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_UNIVERSAL_JDBC_DRIVER40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_UNIVERSAL_JDBC_DRIVER_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_UNIVERSAL_JDBC_DRIVER40_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_UNIVERSAL_JDBC_DRIVER_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_LEGACY_CLI_BASED_JDBC_DRIVER40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_LEGACY_CLI_BASED_JDBC_DRIVER_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_LEGACY_CLI_BASED_JDBC_DRIVER40_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_LEGACY_CLI_BASED_JDBC_DRIVER_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_NATIVE40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_NATIVE_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_NATIVE_XA40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_NATIVE_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_TOOLBOX40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_TOOLBOX_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_TOOLBOX_XA40_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2UDB_FOR_ISERIES_TOOLBOX_XA_DATA_SOURCE_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_FOR_ZOS_LOCAL_JDBC_DRIVER40_DATA_SOURCE_RRS_LITERAL);
		addEEnumLiteral(db2DataSourceTemplateEnumEEnum, DB2DataSourceTemplateEnum.DB2_FOR_ZOS_LOCAL_JDBC_DRIVER_DATA_SOURCE_RRS_LITERAL);

		initEEnum(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.class, "DB2JdbcProviderType"); //$NON-NLS-1$
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.NONE_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL);
		addEEnumLiteral(db2JdbcProviderTypeEEnum, DB2JdbcProviderType.DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL);

		initEEnum(derbyJdbcProviderTypeTypeEEnum, DerbyJdbcProviderTypeType.class, "DerbyJdbcProviderTypeType"); //$NON-NLS-1$
		addEEnumLiteral(derbyJdbcProviderTypeTypeEEnum, DerbyJdbcProviderTypeType.CLOUDSCAPE_JDBC_PROVIDER_LITERAL);
		addEEnumLiteral(derbyJdbcProviderTypeTypeEEnum, DerbyJdbcProviderTypeType.CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL);
		addEEnumLiteral(derbyJdbcProviderTypeTypeEEnum, DerbyJdbcProviderTypeType.CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL);

		initEEnum(endPointListenerNameEnumEEnum, EndPointListenerNameEnum.class, "EndPointListenerNameEnum"); //$NON-NLS-1$
		addEEnumLiteral(endPointListenerNameEnumEEnum, EndPointListenerNameEnum.SOAPHTTP_CHANNEL1_LITERAL);
		addEEnumLiteral(endPointListenerNameEnumEEnum, EndPointListenerNameEnum.SOAPHTTP_CHANNEL2_LITERAL);
		addEEnumLiteral(endPointListenerNameEnumEEnum, EndPointListenerNameEnum.SOAPJMS_CHANNEL1_LITERAL);
		addEEnumLiteral(endPointListenerNameEnumEEnum, EndPointListenerNameEnum.SOAPJMS_CHANNEL2_LITERAL);

		initEEnum(iiopSecurityProtocolsEEnum, IIOPSecurityProtocols.class, "IIOPSecurityProtocols"); //$NON-NLS-1$
		addEEnumLiteral(iiopSecurityProtocolsEEnum, IIOPSecurityProtocols.IBM_LITERAL);
		addEEnumLiteral(iiopSecurityProtocolsEEnum, IIOPSecurityProtocols.CSI_LITERAL);
		addEEnumLiteral(iiopSecurityProtocolsEEnum, IIOPSecurityProtocols.BOTH_LITERAL);
		addEEnumLiteral(iiopSecurityProtocolsEEnum, IIOPSecurityProtocols.OTHER_LITERAL);

		initEEnum(jdbcImplementationTypeTypeEEnum, JdbcImplementationTypeType.class, "JdbcImplementationTypeType"); //$NON-NLS-1$
		addEEnumLiteral(jdbcImplementationTypeTypeEEnum, JdbcImplementationTypeType.CONNECTION_POOL_LITERAL);
		addEEnumLiteral(jdbcImplementationTypeTypeEEnum, JdbcImplementationTypeType.XA_LITERAL);

		initEEnum(jmsDestinationTypeEnumEEnum, JMSDestinationTypeEnum.class, "JMSDestinationTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(jmsDestinationTypeEnumEEnum, JMSDestinationTypeEnum.QUEUE_LITERAL);
		addEEnumLiteral(jmsDestinationTypeEnumEEnum, JMSDestinationTypeEnum.TOPIC_LITERAL);

		initEEnum(ldapDirectoryTypeEEnum, LDAPDirectoryType.class, "LDAPDirectoryType"); //$NON-NLS-1$
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.IBMDIRECTORYSERVER_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.SECUREWAY_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.IPLANET_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.NETSCAPE_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.DOMINO502_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.NDS_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.ACTIVEDIRECTORY_LITERAL);
		addEEnumLiteral(ldapDirectoryTypeEEnum, LDAPDirectoryType.CUSTOM_LITERAL);

		initEEnum(messageReliabilityEnumEEnum, MessageReliabilityEnum.class, "MessageReliabilityEnum"); //$NON-NLS-1$
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.NONE_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.BEST_EFFORT_NONPERSISTENT_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.EXPRESS_NONPERSISTENT_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.RELIABLE_NONPERSISTENT_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.RELIABLE_PERSISTENT_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.ASSURED_PERSISTENT_LITERAL);
		addEEnumLiteral(messageReliabilityEnumEEnum, MessageReliabilityEnum.AS_BUS_DESTINATION_LITERAL);

		initEEnum(policiesEEnum, Policies.class, "Policies"); //$NON-NLS-1$
		addEEnumLiteral(policiesEEnum, Policies.ENTIRE_POOL_LITERAL);
		addEEnumLiteral(policiesEEnum, Policies.FAILING_CONNECTION_ONLY_LITERAL);

		initEEnum(readAheadOptimizationEnumEEnum, ReadAheadOptimizationEnum.class, "ReadAheadOptimizationEnum"); //$NON-NLS-1$
		addEEnumLiteral(readAheadOptimizationEnumEEnum, ReadAheadOptimizationEnum.DEFAULT_LITERAL);
		addEEnumLiteral(readAheadOptimizationEnumEEnum, ReadAheadOptimizationEnum.ALWAYS_ON_LITERAL);
		addEEnumLiteral(readAheadOptimizationEnumEEnum, ReadAheadOptimizationEnum.ALWAYS_OFF_LITERAL);

		initEEnum(shareDurableSubscriptionsEnumEEnum, ShareDurableSubscriptionsEnum.class, "ShareDurableSubscriptionsEnum"); //$NON-NLS-1$
		addEEnumLiteral(shareDurableSubscriptionsEnumEEnum, ShareDurableSubscriptionsEnum.IN_CLUSTER_LITERAL);
		addEEnumLiteral(shareDurableSubscriptionsEnumEEnum, ShareDurableSubscriptionsEnum.ALWAYS_SHARED_LITERAL);
		addEEnumLiteral(shareDurableSubscriptionsEnumEEnum, ShareDurableSubscriptionsEnum.NEVER_SHARED_LITERAL);

		initEEnum(warClassloaderPolicyEEnum, WARClassloaderPolicy.class, "WARClassloaderPolicy"); //$NON-NLS-1$
		addEEnumLiteral(warClassloaderPolicyEEnum, WARClassloaderPolicy.MODULE_LITERAL);
		addEEnumLiteral(warClassloaderPolicyEEnum, WARClassloaderPolicy.APPLICATION_LITERAL);

		initEEnum(wasAccountTypeEnumEEnum, WasAccountTypeEnum.class, "WasAccountTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasAccountTypeEnumEEnum, WasAccountTypeEnum.LOCALSYSTEM_LITERAL);
		addEEnumLiteral(wasAccountTypeEnumEEnum, WasAccountTypeEnum.SPECIFIEDUSER_LITERAL);

		initEEnum(wasApplicationMapEEnum, WasApplicationMap.class, "WasApplicationMap"); //$NON-NLS-1$
		addEEnumLiteral(wasApplicationMapEEnum, WasApplicationMap.MAPNONE_LITERAL);
		addEEnumLiteral(wasApplicationMapEEnum, WasApplicationMap.MAPDEFAULT_LITERAL);
		addEEnumLiteral(wasApplicationMapEEnum, WasApplicationMap.MAPALL_LITERAL);
		addEEnumLiteral(wasApplicationMapEEnum, WasApplicationMap.UNKNOWN_LITERAL);

		initEEnum(wasDefaultSecuritySubjectEnumEEnum, WasDefaultSecuritySubjectEnum.class, "WasDefaultSecuritySubjectEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasDefaultSecuritySubjectEnumEEnum, WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL);
		addEEnumLiteral(wasDefaultSecuritySubjectEnumEEnum, WasDefaultSecuritySubjectEnum.EVERYONE_LITERAL);

		initEEnum(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.class, "WasDeploymentManagerPortNames"); //$NON-NLS-1$
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.BOOTSTRAP_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.CELL_DISCOVERY_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.DCS_UNICAST_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.ORB_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.SOAP_CONNECTOR_ADDRESS_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.WC_ADMINHOST_LITERAL);
		addEEnumLiteral(wasDeploymentManagerPortNamesEEnum, WasDeploymentManagerPortNames.WC_ADMINHOST_SECURE_LITERAL);

		initEEnum(wasEditionEnumEEnum, WasEditionEnum.class, "WasEditionEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasEditionEnumEEnum, WasEditionEnum.BASE_LITERAL);
		addEEnumLiteral(wasEditionEnumEEnum, WasEditionEnum.EXPRESS_LITERAL);
		addEEnumLiteral(wasEditionEnumEEnum, WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);

		initEEnum(wasEndpointListenerTypeEEnum, WasEndpointListenerType.class, "WasEndpointListenerType"); //$NON-NLS-1$
		addEEnumLiteral(wasEndpointListenerTypeEEnum, WasEndpointListenerType.SOAP_OVER_HTTP_LITERAL);
		addEEnumLiteral(wasEndpointListenerTypeEEnum, WasEndpointListenerType.SOAP_OVER_JMS_LITERAL);

		initEEnum(wasNodeGroupTypeEnumEEnum, WasNodeGroupTypeEnum.class, "WasNodeGroupTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasNodeGroupTypeEnumEEnum, WasNodeGroupTypeEnum.DEFAULT_LITERAL);
		addEEnumLiteral(wasNodeGroupTypeEnumEEnum, WasNodeGroupTypeEnum.USER_LITERAL);

		initEEnum(wasNodePortNamesEEnum, WasNodePortNames.class, "WasNodePortNames"); //$NON-NLS-1$
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.BOOTSTRAP_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.DCS_UNICAST_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.DRS_CLEINT_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.NODE_DISCOVERY_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.NODE_IPV6_MULITCAST_DISCOVERY_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.NODE_MULTICAST_DISCOVERY_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.ORB_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(wasNodePortNamesEEnum, WasNodePortNames.SOAP_CONNECTOR_ADDRESS_LITERAL);

		initEEnum(wasProfileTypeEnumEEnum, WasProfileTypeEnum.class, "WasProfileTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasProfileTypeEnumEEnum, WasProfileTypeEnum.DMGR_LITERAL);
		addEEnumLiteral(wasProfileTypeEnumEEnum, WasProfileTypeEnum.MANAGED_LITERAL);
		addEEnumLiteral(wasProfileTypeEnumEEnum, WasProfileTypeEnum.DEFAULT_LITERAL);
		addEEnumLiteral(wasProfileTypeEnumEEnum, WasProfileTypeEnum.NONE_LITERAL);

		initEEnum(wasRoutingDefinitionTypeEnumEEnum, WasRoutingDefinitionTypeEnum.class, "WasRoutingDefinitionTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasRoutingDefinitionTypeEnumEEnum, WasRoutingDefinitionTypeEnum.DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL);
		addEEnumLiteral(wasRoutingDefinitionTypeEnumEEnum, WasRoutingDefinitionTypeEnum.DIRECT_WEBSPHERE_MQ_LINK_LITERAL);

		initEEnum(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.class, "WasSibDestinationTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.WEB_SERVICE_LITERAL);
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.PORT_LITERAL);
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.QUEUE_LITERAL);
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.TOPIC_SPACE_LITERAL);
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.ALIAS_LITERAL);
		addEEnumLiteral(wasSibDestinationTypeEnumEEnum, WasSibDestinationTypeEnum.FOREIGN_LITERAL);

		initEEnum(wasUserRegistryTypesEEnum, WasUserRegistryTypes.class, "WasUserRegistryTypes"); //$NON-NLS-1$
		addEEnumLiteral(wasUserRegistryTypesEEnum, WasUserRegistryTypes.OS_LITERAL);
		addEEnumLiteral(wasUserRegistryTypesEEnum, WasUserRegistryTypes.LDAP_LITERAL);
		addEEnumLiteral(wasUserRegistryTypesEEnum, WasUserRegistryTypes.CUSTOM_LITERAL);

		initEEnum(wasWebServerNodeTypeEEnum, WasWebServerNodeType.class, "WasWebServerNodeType"); //$NON-NLS-1$
		addEEnumLiteral(wasWebServerNodeTypeEEnum, WasWebServerNodeType.MANAGED_LITERAL);
		addEEnumLiteral(wasWebServerNodeTypeEEnum, WasWebServerNodeType.UNMANAGED_LITERAL);

		initEEnum(wasWebServerOSEEnum, WasWebServerOS.class, "WasWebServerOS"); //$NON-NLS-1$
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.WINDOWS_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.SOLARIS_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.AIX_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.HPUX_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.LINUX_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.OS400_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.OS390_LITERAL);
		addEEnumLiteral(wasWebServerOSEEnum, WasWebServerOS.UNKNOWN_LITERAL);

		initEEnum(wasWebServerTypeEEnum, WasWebServerType.class, "WasWebServerType"); //$NON-NLS-1$
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.IHS_LITERAL);
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.APACHE_LITERAL);
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.IIS_LITERAL);
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.DOMINO_LITERAL);
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.SUNJAVASYSTEM_LITERAL);
		addEEnumLiteral(wasWebServerTypeEEnum, WasWebServerType.UNKNOWN_LITERAL);

		initEEnum(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.class, "WebsphereAppServerPortNames"); //$NON-NLS-1$
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.DCS_UNICAST_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.BOOTSTRAP_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SOAP_CONNECTOR_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.WC_ADMINHOST_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.WC_ADMINHOST_SECURE_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.WC_DEFAULTHOST_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.WC_DEFAULTHOST_SECURE_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SIB_ENDPOINT_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SIB_ENDPOINT_SECURE_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SIB_MQ_ENDPOINT_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.SIB_MQ_ENDPOINT_SECURE_ADDRESS_LITERAL);
		addEEnumLiteral(websphereAppServerPortNamesEEnum, WebsphereAppServerPortNames.ORB_LISTENER_ADDRESS_LITERAL);

		// Initialize data types
		initEDataType(acknowledgeModeEnumObjectEDataType, AcknowledgeModeEnum.class, "AcknowledgeModeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(certificateMapModeObjectEDataType, CertificateMapMode.class, "CertificateMapModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(cfTargetSignificanceEnumObjectEDataType, CFTargetSignificanceEnum.class, "CFTargetSignificanceEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(classloaderModeObjectEDataType, ClassloaderMode.class, "ClassloaderModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(classloaderPolicyTypeObjectEDataType, ClassloaderPolicyType.class, "ClassloaderPolicyTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(connectionDeliveryModeEnumObjectEDataType, ConnectionDeliveryModeEnum.class, "ConnectionDeliveryModeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(connectionFactoryTargetTypeEnumObjectEDataType, ConnectionFactoryTargetTypeEnum.class, "ConnectionFactoryTargetTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(connectionProximityEnumObjectEDataType, ConnectionProximityEnum.class, "ConnectionProximityEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(dataSourceHelperClassNamesObjectEDataType, DataSourceHelperClassNames.class, "DataSourceHelperClassNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(db2DataSourceTemplateEnumObjectEDataType, DB2DataSourceTemplateEnum.class, "DB2DataSourceTemplateEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(db2JdbcProviderTypeObjectEDataType, DB2JdbcProviderType.class, "DB2JdbcProviderTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(derbyJdbcProviderTypeTypeObjectEDataType, DerbyJdbcProviderTypeType.class, "DerbyJdbcProviderTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(endPointListenerNameEnumObjectEDataType, EndPointListenerNameEnum.class, "EndPointListenerNameEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iiopSecurityProtocolsObjectEDataType, IIOPSecurityProtocols.class, "IIOPSecurityProtocolsObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jdbcImplementationTypeTypeObjectEDataType, JdbcImplementationTypeType.class, "JdbcImplementationTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jmsDestinationTypeEnumObjectEDataType, JMSDestinationTypeEnum.class, "JMSDestinationTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(ldapDirectoryTypeObjectEDataType, LDAPDirectoryType.class, "LDAPDirectoryTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(messageReliabilityEnumObjectEDataType, MessageReliabilityEnum.class, "MessageReliabilityEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(policiesObjectEDataType, Policies.class, "PoliciesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(readAheadOptimizationEnumObjectEDataType, ReadAheadOptimizationEnum.class, "ReadAheadOptimizationEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(shareDurableSubscriptionsEnumObjectEDataType, ShareDurableSubscriptionsEnum.class, "ShareDurableSubscriptionsEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(warClassloaderPolicyObjectEDataType, WARClassloaderPolicy.class, "WARClassloaderPolicyObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasAccountTypeEnumObjectEDataType, WasAccountTypeEnum.class, "WasAccountTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasApplicationMapObjectEDataType, WasApplicationMap.class, "WasApplicationMapObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasDefaultSecuritySubjectEnumObjectEDataType, WasDefaultSecuritySubjectEnum.class, "WasDefaultSecuritySubjectEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasDeploymentManagerPortNamesObjectEDataType, WasDeploymentManagerPortNames.class, "WasDeploymentManagerPortNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasEditionEnumObjectEDataType, WasEditionEnum.class, "WasEditionEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasEndpointListenerTypeObjectEDataType, WasEndpointListenerType.class, "WasEndpointListenerTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasNodeGroupTypeEnumObjectEDataType, WasNodeGroupTypeEnum.class, "WasNodeGroupTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasNodePortNamesObjectEDataType, WasNodePortNames.class, "WasNodePortNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasProfileTypeEnumObjectEDataType, WasProfileTypeEnum.class, "WasProfileTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasRoutingDefinitionTypeEnumObjectEDataType, WasRoutingDefinitionTypeEnum.class, "WasRoutingDefinitionTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasSibDestinationTypeEnumObjectEDataType, WasSibDestinationTypeEnum.class, "WasSibDestinationTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasUserRegistryTypesObjectEDataType, WasUserRegistryTypes.class, "WasUserRegistryTypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasWebServerNodeTypeObjectEDataType, WasWebServerNodeType.class, "WasWebServerNodeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasWebServerOSObjectEDataType, WasWebServerOS.class, "WasWebServerOSObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wasWebServerTypeObjectEDataType, WasWebServerType.class, "WasWebServerTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(websphereAppServerPortNamesObjectEDataType, WebsphereAppServerPortNames.class, "WebsphereAppServerPortNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (acknowledgeModeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "AcknowledgeModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (acknowledgeModeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "AcknowledgeModeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "AcknowledgeModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (certificateMapModeEEnum, 
		   source, 
		   new String[] {
			 "name", "CertificateMapMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (certificateMapModeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "CertificateMapMode:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "CertificateMapMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (cfTargetSignificanceEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "CFTargetSignificanceEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (cfTargetSignificanceEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "CFTargetSignificanceEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "CFTargetSignificanceEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (classloaderEClass, 
		   source, 
		   new String[] {
			 "name", "Classloader", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getClassloader_Mode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getClassloader_StartWeight(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "startWeight" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getClassloader_WarClassLoaderPolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "warClassLoaderPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (classloaderModeEEnum, 
		   source, 
		   new String[] {
			 "name", "ClassloaderMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (classloaderModeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ClassloaderMode:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ClassloaderMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (classloaderPolicyTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ClassloaderPolicyType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (classloaderPolicyTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ClassloaderPolicyType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ClassloaderPolicyType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionDeliveryModeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "ConnectionDeliveryModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionDeliveryModeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ConnectionDeliveryModeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ConnectionDeliveryModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionFactoryTargetTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "ConnectionFactoryTargetTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionFactoryTargetTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ConnectionFactoryTargetTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ConnectionFactoryTargetTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionProximityEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "ConnectionProximityEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (connectionProximityEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ConnectionProximityEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ConnectionProximityEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (dataSourceHelperClassNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "DataSourceHelperClassNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (dataSourceHelperClassNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DataSourceHelperClassNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DataSourceHelperClassNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DataSourceTemplateEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "DB2DataSourceTemplateEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DataSourceTemplateEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DB2DataSourceTemplateEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DB2DataSourceTemplateEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2JdbcProviderEClass, 
		   source, 
		   new String[] {
			 "name", "DB2JdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2JdbcProvider_JdbcType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jdbcType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2JdbcProvider_Template(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "template" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2JdbcProviderTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DB2JdbcProviderType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2JdbcProviderTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DB2JdbcProviderType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DB2JdbcProviderType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2JdbcProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2JdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyJdbcProviderEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyJdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyJdbcProvider_Template(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "template" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyJdbcProviderTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DerbyJdbcProviderTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyJdbcProviderTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DerbyJdbcProviderTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DerbyJdbcProviderTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyJdbcProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyJdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (endPointListenerNameEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "EndPointListenerNameEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (endPointListenerNameEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "EndPointListenerNameEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "EndPointListenerNameEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (extendedJdbcProviderEClass, 
		   source, 
		   new String[] {
			 "name", "ExtendedJdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (extendedJdbcProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "ExtendedJdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (hostNameAliasTypeEClass, 
		   source, 
		   new String[] {
			 "name", "HostNameAliasType", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHostNameAliasType_Hostname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getHostNameAliasType_HostnameAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostnameAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (iiopSecurityProtocolsEEnum, 
		   source, 
		   new String[] {
			 "name", "IIOPSecurityProtocols" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (iiopSecurityProtocolsObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "IIOPSecurityProtocols:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "IIOPSecurityProtocols" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdbcImplementationTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "JdbcImplementationTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdbcImplementationTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JdbcImplementationTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "JdbcImplementationTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsDestinationTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "JMSDestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsDestinationTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JMSDestinationTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "JMSDestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldapDirectoryTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "LDAPDirectoryType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldapDirectoryTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "LDAPDirectoryType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "LDAPDirectoryType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (messageReliabilityEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "MessageReliabilityEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });									
		addAnnotation
		  (messageReliabilityEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "MessageReliabilityEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "MessageReliabilityEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (policiesEEnum, 
		   source, 
		   new String[] {
			 "name", "Policies" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (policiesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Policies:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "Policies" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (readAheadOptimizationEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "ReadAheadOptimizationEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (readAheadOptimizationEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ReadAheadOptimizationEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ReadAheadOptimizationEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (sharedLibraryEntryEClass, 
		   source, 
		   new String[] {
			 "name", "SharedLibraryEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSharedLibraryEntry_ClassPath(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classPath", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSharedLibraryEntry_NativePath(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nativePath", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSharedLibraryEntry_SharedLibraryEntryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sharedLibraryEntryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (shareDurableSubscriptionsEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "ShareDurableSubscriptionsEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });					
		addAnnotation
		  (shareDurableSubscriptionsEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ShareDurableSubscriptionsEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ShareDurableSubscriptionsEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (virtualHostTypeEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualHostType", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualHostType_HostNameAlias(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostNameAlias", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualHostType_HostName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (warClassloaderPolicyEEnum, 
		   source, 
		   new String[] {
			 "name", "WARClassloaderPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (warClassloaderPolicyObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WARClassloaderPolicy:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WARClassloaderPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasAccountTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasAccountTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasAccountTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasAccountTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasAccountTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasAdvancedLdapConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasAdvancedLdapConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_CertificateFilter(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "certificateFilter" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_CertificateMapMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "certificateMapMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_GroupFilter(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "groupFilter" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_GroupIdMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "groupIdMap" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_GroupMemberIdMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "groupMemberIdMap" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_UserFilter(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userFilter" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasAdvancedLdapConfiguration_UserIdMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userIdMap" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasApplicationClassLoaderPolicyEClass, 
		   source, 
		   new String[] {
			 "name", "WasApplicationClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasApplicationClassLoaderPolicy_ReloadClasses(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadClasses" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasApplicationClassLoaderPolicy_ReloadInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasApplicationExtEClass, 
		   source, 
		   new String[] {
			 "name", "WasApplicationExt", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasApplicationExt_ReloadInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasApplicationExt_ShareSessionContext(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "shareSessionContext" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasApplicationMapEEnum, 
		   source, 
		   new String[] {
			 "name", "WasApplicationMap" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasApplicationMapObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasApplicationMap:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasApplicationMap" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasApplicationServerClassLoaderPolicyEClass, 
		   source, 
		   new String[] {
			 "name", "WasApplicationServerClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasCellEClass, 
		   source, 
		   new String[] {
			 "name", "WasCell", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCell_CellName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "cellName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCell_IsDistributed(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "isDistributed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCell_WasVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasCellUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasCellUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasClassLoaderConfigurationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasClassLoaderConfigurationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasClassLoaderPolicyEClass, 
		   source, 
		   new String[] {
			 "name", "WasClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasClassLoaderPolicy_Order(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "order" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasClassLoaderPolicy_Policy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasClusterEClass, 
		   source, 
		   new String[] {
			 "name", "WasCluster", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCluster_ClusterName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clusterName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCluster_CreateReplicationDomain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "createReplicationDomain" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCluster_PreferLocal(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferLocal" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasCluster_WasVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasClusterUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasClusterUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasConfigurationContainerEClass, 
		   source, 
		   new String[] {
			 "name", "WasConfigurationContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasDatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "WasDatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDatasource_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "category" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDatasource_ConnectionTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDatasource_MaxConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "maxConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDatasource_MinConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "minConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDatasource_StatementCacheSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "statementCacheSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDatasourceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDatasourceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingConnectionFactoryConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_ClientIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_ConnectionProximity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionProximity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_DurableSubscriptionHome(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "durableSubscriptionHome" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_NonpersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nonpersistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_PersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "persistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_ProviderEndpoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerEndpoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_ReadAhead(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "readAhead" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_ShareDurableSubscriptions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ShareDurableSubscriptions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_Target(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "target" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_TargetInboundTransportChain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetInboundTransportChain" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_TargetSignificance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetSignificance" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_TargetType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_TempQnamePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tempQnamePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingConnectionFactoryConfiguration_TempTopicNamePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tempTopicNamePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingQueueConnectionFactoryConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingQueueConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_ClientIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_ConnectionProximity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionProximity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_NonpersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nonpersistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_PersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "persistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_ProviderEndpoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerEndpoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_ReadAhead(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "readAhead" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_Target(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "target" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetInboundTransportChain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetInboundTransportChain" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetSignificance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetSignificance" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_TargetType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingQueueConnectionFactoryConfiguration_TempQNamePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tempQNamePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingQueueConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingQueueDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueDestination_ConnectionDeliveryMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionDeliveryMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingQueueDestination_MessageLiveTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "messageLiveTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingQueueDestination_MessagePriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "messagePriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingQueueDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingTopicConnectionFactoryConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingTopicConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_ClientIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_ConnectionProximity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionProximity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_DurableSubscriptionHome(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "durableSubscriptionHome" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_NonpersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nonpersistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_PersistentMessageReliability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "persistentMessageReliability" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_ProviderEndpoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerEndpoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_ReadAhead(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "readAhead" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_ShareDurableSubscriptions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ShareDurableSubscriptions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_Target(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "target" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetInboundTransportChain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetInboundTransportChain" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetSignificance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetSignificance" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_TargetType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "targetType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingTopicConnectionFactoryConfiguration_TempTopicNamePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tempTopicNamePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingTopicConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingTopicDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicDestination_ConnectionDeliveryMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "connectionDeliveryMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicDestination_MessageLiveTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "messageLiveTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDefaultMessagingTopicDestination_MessagePriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "messagePriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDefaultMessagingTopicDestination_TopicName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "topicName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultMessagingTopicDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDefaultMessagingTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultSecuritySubjectEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasDefaultSecuritySubjectEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDefaultSecuritySubjectEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasDefaultSecuritySubjectEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasDefaultSecuritySubjectEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDeploymentManagerEClass, 
		   source, 
		   new String[] {
			 "name", "WasDeploymentManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDeploymentManagerPortNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "WasDeploymentManagerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDeploymentManagerPortNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasDeploymentManagerPortNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasDeploymentManagerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDeploymentManagerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasDeploymentManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityDb2JdbcProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2JdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityDerbyJdbcProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.derbyJdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityExtendedJdbcProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.extendedJdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasAdvancedLdapConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasAdvancedLdapConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasApplicationClassLoaderPolicy(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasApplicationClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasApplicationExt(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasApplicationExt", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasApplicationServerClassLoaderPolicy(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasApplicationServerClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasCell(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasCell", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasClassLoaderPolicy(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasCluster(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasCluster", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasConfigurationContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasConfigurationContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDatasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDefaultMessagingConnectionFactoryConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDefaultMessagingConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDefaultMessagingQueueConnectionFactoryConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDefaultMessagingQueueConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDefaultMessagingQueueDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDefaultMessagingQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDefaultMessagingTopicConnectionFactoryConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDefaultMessagingTopicConnectionFactoryConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDefaultMessagingTopicDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDefaultMessagingTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasDeploymentManager(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasDeploymentManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasEndpointListenerConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasEndpointListenerConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasHandlerList(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasHandlerList", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasJ2CAuth(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasJ2CAuth", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasJ2EEServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasJ2EEServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasJMSActivationSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasJMSActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasLdapConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasLdapConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasMessagingEngine(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasMessagingEngine", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasModuleClassLoaderPolicy(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasModuleClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasNode(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasNodeGroup(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasNodeGroup", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasPluginAdmin(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasPluginAdmin", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasPluginRedirection(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasPluginRedirection", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSecurity(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSecurity", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSecuritySubject(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSecuritySubject", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSharedLibContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSharedLibContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSharedLibrary(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSharedLibrary", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibForeignBus(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.WasSibForeignBus", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibInboundPort(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibInboundPort", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibInboundService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibInboundService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibMediation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibMediation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibOutboundPort(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibOutboundPort", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibOutboundService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibOutboundService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSibServiceIntegrationBusLink(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSibServiceIntegrationBusLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSIBus(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSIBus", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSubstitutionVariable(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSubstitutionVariable", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasv4datasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasv4datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasv5datasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasv5datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasv5DB2Datasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasv5DB2Datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasv5DB2ZosDatasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasv5DB2ZosDatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasVirtualHost(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasVirtualHost", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasWebAppExt(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasWebAppExt", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasWebServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasWebServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasWebServerManagement(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasWebServerManagement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_CapabilityWasWebServerPlugin(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.wasWebServerPlugin", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_Classloader(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classloader", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasEarClassloaderPolicyConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasEarClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasJ2EEConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasJ2EEConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasDeployRoot_ConstraintWasJNDIBindingConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasJNDIBindingConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasModuleClassloaderPolicyConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasModuleClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasModuleStartWeightConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasModuleStartWeightConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasSecuritySubjectConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasSecuritySubjectConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_ConstraintWasWarClassloaderPolicyConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.wasWarClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_HostNameAlias(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostNameAlias", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitDb2JdbcProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2JdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitDerbyJdbcProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.derbyJdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitExtendedJdbcProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.extendedJdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasAppServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasAppServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasCellUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasCellUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasClassLoaderConfigurationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasClassLoaderConfigurationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasClusterUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasClusterUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasdatasource(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasdatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDefaultMessagingConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDefaultMessagingConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDefaultMessagingQueueConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDefaultMessagingQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDefaultMessagingQueueDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDefaultMessagingQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDefaultMessagingTopicConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDefaultMessagingTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDefaultMessagingTopicDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDefaultMessagingTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasDeploymentManagerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasDeploymentManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasEndpointListenerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasEndpointListenerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasJ2CAuth(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasJ2CAuth", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasJMSActivationSpecificationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasJMSActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasLdapConfigurationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasLdapConfigurationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasMessagingEngine(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasMessagingEngine", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasNodeGroupUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasNodeGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasNodeUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasNodeUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasNodeWindowsServiceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasNodeWindowsServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSharedLibraryEntryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSharedLibraryEntryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibInboundPortUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibInboundPortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibInboundServiceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibInboundServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibMediationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibMediationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibOutboundPortUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibOutboundPortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSibOutboundServiceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSibOutboundServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSIBusUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSIBusUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasDeployRoot_UnitWasWebServerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.wasWebServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasEarClassloaderPolicyConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasEarClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEarClassloaderPolicyConstraint_Policy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEarClassloaderPolicyConstraint_ReloadClasses(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadClasses" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEarClassloaderPolicyConstraint_ReloadInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEditionEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasEditionEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEditionEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasEditionEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasEditionEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEndpointListenerConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasEndpointListenerConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEndpointListenerConfiguration_EndpointListenerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "endpointListenerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEndpointListenerConfiguration_UrlRoot(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "urlRoot" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasEndpointListenerConfiguration_WsdlUrlRoot(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wsdlUrlRoot" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEndpointListenerTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "WasEndpointListenerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEndpointListenerTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasEndpointListenerType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasEndpointListenerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasEndpointListenerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasEndpointListenerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasHandlerListEClass, 
		   source, 
		   new String[] {
			 "name", "WasHandlerList", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasHandlerList_HandlerlistName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "handlerlistName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasj2CAuthenticationDataEntryEClass, 
		   source, 
		   new String[] {
			 "name", "WASJ2CAuthenticationDataEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasj2CAuthenticationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WASJ2CAuthenticationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasJ2EEConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasJ2EEConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasJ2EEServerEClass, 
		   source, 
		   new String[] {
			 "name", "WasJ2EEServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasJMSActivationSpecificationEClass, 
		   source, 
		   new String[] {
			 "name", "WasJMSActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasJMSActivationSpecification_DurableScriptionHome(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "durableScriptionHome" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasJMSActivationSpecification_MaxBatchSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxBatchSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasJMSActivationSpecification_MaxConcurrentEndpoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "maxConcurrentEndpoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasJMSActivationSpecification_ShareDurableSubscription(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "shareDurableSubscription" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasJMSActivationSpecificationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasJMSActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasJNDIBindingConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasJNDIBindingConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasJNDIBindingConstraint_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasLdapConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "WasLdapConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_BaseDN(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "baseDN" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_BindDN(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bindDN" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_BindPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bindPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_IgnoreCase(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ignoreCase" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_LdapHostname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldapHostname" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_LdapPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldapPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_Limit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "limit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_MonitorInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "monitorInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_Realm(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "realm" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_ReuseConnection(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reuseConnection" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_SearchTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "searchTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_ServerId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serverId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_ServerPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serverPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_SslConfig(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sslConfig" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_SslEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sslEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasLdapConfiguration_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasLdapConfigurationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasLdapConfigurationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasMessagingEngineEClass, 
		   source, 
		   new String[] {
			 "name", "WasMessagingEngine", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasMessagingEngine_EngineName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "engineName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasMessagingEngineUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasMessagingEngineUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasModuleClassLoaderPolicyEClass, 
		   source, 
		   new String[] {
			 "name", "WasModuleClassLoaderPolicy", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasModuleClassLoaderPolicy_StartWeight(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "startWeight" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasModuleClassloaderPolicyConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasModuleClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasModuleStartWeightConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasModuleStartWeightConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasModuleStartWeightConstraint_StartingWeight(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "startingWeight" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeEClass, 
		   source, 
		   new String[] {
			 "name", "WasNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_IsDefaultProfile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "isDefaultProfile" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_IsManaged(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "isManaged" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_NodeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nodeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_ProfileLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "profileLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_ProfileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "profileName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_ProfileType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "profileType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNode_WasVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeGroupEClass, 
		   source, 
		   new String[] {
			 "name", "WasNodeGroup", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNodeGroup_IsDefaultType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "isDefaultType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasNodeGroup_NodeGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nodeGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeGroupTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasNodeGroupTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeGroupTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasNodeGroupTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasNodeGroupTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeGroupUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasNodeGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodePortNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "WasNodePortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodePortNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasNodePortNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasNodePortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasNodeUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasNodeWindowsServiceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasNodeWindowsServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasPluginAdminEClass, 
		   source, 
		   new String[] {
			 "name", "WasPluginAdmin", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasPluginAdmin_WasPluginVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasPluginVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasPluginRedirectionEClass, 
		   source, 
		   new String[] {
			 "name", "WasPluginRedirection", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasPluginRedirection_WasPluginVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasPluginVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasProfileTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasProfileTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasProfileTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasProfileTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasProfileTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasRoutingDefinitionTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasRoutingDefinitionTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasRoutingDefinitionTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasRoutingDefinitionTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasRoutingDefinitionTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSecurityEClass, 
		   source, 
		   new String[] {
			 "name", "WasSecurity", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_ActiveAuthMechanism(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "activeAuthMechanism" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_ActiveProtocol(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "activeProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_ActiveUserRegistry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "activeUserRegistry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_AllowAllPermissionForApplication(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "allowAllPermissionForApplication" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_CacheTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "cacheTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_EnforceFineGrainedJCASecurity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "enforceFineGrainedJCASecurity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_EnforceJava2SecRuntimeFiletering(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "enforceJava2SecRuntimeFiletering" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_EnforceJava2Security(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "enforceJava2Security" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_GlobalSecurityEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "globalSecurityEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_IssuePermissionWarning(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "issuePermissionWarning" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecurity_UseDomainQualifiedNames(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "useDomainQualifiedNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSecuritySubjectEClass, 
		   source, 
		   new String[] {
			 "name", "WasSecuritySubject", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecuritySubject_AccessId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "accessId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecuritySubject_SubjectName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subjectName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasSecuritySubjectConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasSecuritySubjectConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSecuritySubjectConstraint_WasSecuritySubject(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasSecuritySubject" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasServerEClass, 
		   source, 
		   new String[] {
			 "name", "WasServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasServer_ServerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serverName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasServer_WasVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSharedLibContainerEClass, 
		   source, 
		   new String[] {
			 "name", "WasSharedLibContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSharedLibraryEntryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSharedLibraryEntryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibDestination_DestinationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibDestination_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibDestinationTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "WasSibDestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibDestinationTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasSibDestinationTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasSibDestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibForeignBusEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibForeignBus", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibForeignBus_ForeignBusName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "foreignBusName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibForeignBus_InBoundUserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "inBoundUserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibForeignBus_OutBoundUserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "outBoundUserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibForeignBus_RoutingDefinitionType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "routingDefinitionType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibInboundPortEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibInboundPort", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibInboundPort_PortName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "portName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibInboundPortUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibInboundPortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibInboundServiceEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibInboundService", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibInboundService_ServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serviceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibInboundService_WsdlLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wsdlLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibInboundService_WsdlServiceNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wsdlServiceNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibInboundServiceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibInboundServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibMediationEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibMediation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibMediation_HandlerListName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "handlerListName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibMediation_MediationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mediationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibMediationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibMediationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibOutboundPortEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibOutboundPort", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibOutboundPort_PortName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "portName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibOutboundPortUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibOutboundPortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibOutboundServiceEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibOutboundService", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibOutboundService_ServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serviceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibOutboundService_WsdlLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wsdlLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibOutboundService_WsdlServiceNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wsdlServiceNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibOutboundServiceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibOutboundServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSibServiceIntegrationBusLinkEClass, 
		   source, 
		   new String[] {
			 "name", "WasSibServiceIntegrationBusLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibServiceIntegrationBusLink_BootTrapEndpoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bootTrapEndpoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibServiceIntegrationBusLink_ForeignBusName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "foreignBusName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibServiceIntegrationBusLink_LinkName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "linkName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSibServiceIntegrationBusLink_RemoteMessagingEngineName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "remoteMessagingEngineName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSIBusEClass, 
		   source, 
		   new String[] {
			 "name", "WasSIBus", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSIBus_BusName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "busName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSIBus_ConfigurationReload(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configurationReload" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSIBus_DiscardMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DiscardMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSIBus_HighMessageThreshold(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "highMessageThreshold" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSIBus_InterEngineTransportChain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InterEngineTransportChain" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSIBusUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSIBusUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSubstitutionVariableEClass, 
		   source, 
		   new String[] {
			 "name", "WasSubstitutionVariable", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSystemEClass, 
		   source, 
		   new String[] {
			 "name", "WasSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSystem_InstallerDir(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installerDir" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSystem_WasEdition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasEdition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSystem_WasHome(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasHome" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasSystem_WasVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wasVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasUserRegistryTypesEEnum, 
		   source, 
		   new String[] {
			 "name", "WasUserRegistryTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasUserRegistryTypesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasUserRegistryTypes:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasUserRegistryTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasV4DatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "WasV4Datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV4Datasource_DisableAutoConnectionCleanup(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "disableAutoConnectionCleanup" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV4Datasource_IdleTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "idleTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV4Datasource_OrphanTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "orphanTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasV5DatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "WasV5Datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5Datasource_AgedTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "agedTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV5Datasource_DataSourceHelperClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dataSourceHelperClassName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV5Datasource_J2cAuthAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "j2cAuthAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5Datasource_PurgePolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "purgePolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5Datasource_ReapTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reapTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5Datasource_UnusedTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unusedTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasV5DB2DatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "WasV5DB2Datasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_CliSchema(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "cliSchema" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_CurrentPackageSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "currentPackageSet" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_CurrentSchema(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "currentSchema" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_DeferPrepares(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deferPrepares" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_FullyMaterializeLobData(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fullyMaterializeLobData" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_ResultSetHoldability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "resultSetHoldability" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_TraceFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "traceFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasV5DB2Datasource_TraceLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "traceLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasV5DB2Datasource_UseTemplate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "useTemplate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasV5DB2ZosDatasourceEClass, 
		   source, 
		   new String[] {
			 "name", "WasV5DB2ZosDatasource", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWarClassloaderPolicyConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "WasWarClassloaderPolicyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWarClassloaderPolicyConstraint_Order(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "order" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasWebAppExtEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebAppExt", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_AdditionalClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "additionalClassPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_AutoLoadFilters(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoLoadFilters" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_AutoRequestEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoRequestEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_AutoResponseEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoResponseEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_DefaultErrorPage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "defaultErrorPage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_DirectoryBrowsingEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "directoryBrowsingEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_FileServingEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fileServingEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_PreCompileJSPs(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preCompileJSPs" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_ReloadingEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadingEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_ReloadInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reloadInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebAppExt_ServeServletsByClassnameEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serveServletsByClassnameEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_ConfigFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_Host(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "host" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_LogFileAccess(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "logFileAccess" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_LogFileError(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "logFileError" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_MapApplications(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mapApplications" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_OperatingSystem(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "operatingSystem" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWasWebServer_ServerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serverName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_ServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "serviceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServer_UseSecureProtocol(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "useSecureProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerManagementEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebServerManagement", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_AutoConfigPropagation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoConfigPropagation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_Host(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "host" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_UserId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerManagement_UseSecureProtocol(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "useSecureProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerNodeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "WasWebServerNodeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasWebServerNodeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasWebServerNodeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasWebServerNodeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerOSEEnum, 
		   source, 
		   new String[] {
			 "name", "WasWebServerOS" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasWebServerOSObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasWebServerOS:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasWebServerOS" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerPluginEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebServerPlugin", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWasWebServerPlugin_InstallLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "WasWebServerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wasWebServerTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WasWebServerType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WasWebServerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wasWebServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WasWebServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (websphereAppServerPortNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "WebsphereAppServerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (websphereAppServerPortNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WebsphereAppServerPortNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WebsphereAppServerPortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (websphereAppServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "WebsphereAppServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //WasPackageImpl
