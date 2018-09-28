/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage
 * @generated
 */
public class WasAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static WasPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WasPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected WasSwitch modelSwitch = new WasSwitch() {
			public Object caseClassloader(Classloader object) {
				return createClassloaderAdapter();
			}
			public Object caseDB2JdbcProvider(DB2JdbcProvider object) {
				return createDB2JdbcProviderAdapter();
			}
			public Object caseDB2JdbcProviderUnit(DB2JdbcProviderUnit object) {
				return createDB2JdbcProviderUnitAdapter();
			}
			public Object caseDerbyJdbcProvider(DerbyJdbcProvider object) {
				return createDerbyJdbcProviderAdapter();
			}
			public Object caseDerbyJdbcProviderUnit(DerbyJdbcProviderUnit object) {
				return createDerbyJdbcProviderUnitAdapter();
			}
			public Object caseExtendedJdbcProvider(ExtendedJdbcProvider object) {
				return createExtendedJdbcProviderAdapter();
			}
			public Object caseExtendedJdbcProviderUnit(ExtendedJdbcProviderUnit object) {
				return createExtendedJdbcProviderUnitAdapter();
			}
			public Object caseHostNameAliasType(HostNameAliasType object) {
				return createHostNameAliasTypeAdapter();
			}
			public Object caseSharedLibraryEntry(SharedLibraryEntry object) {
				return createSharedLibraryEntryAdapter();
			}
			public Object caseVirtualHostType(VirtualHostType object) {
				return createVirtualHostTypeAdapter();
			}
			public Object caseWasAdvancedLdapConfiguration(WasAdvancedLdapConfiguration object) {
				return createWasAdvancedLdapConfigurationAdapter();
			}
			public Object caseWasApplicationClassLoaderPolicy(WasApplicationClassLoaderPolicy object) {
				return createWasApplicationClassLoaderPolicyAdapter();
			}
			public Object caseWasApplicationExt(WasApplicationExt object) {
				return createWasApplicationExtAdapter();
			}
			public Object caseWasApplicationServerClassLoaderPolicy(WasApplicationServerClassLoaderPolicy object) {
				return createWasApplicationServerClassLoaderPolicyAdapter();
			}
			public Object caseWasCell(WasCell object) {
				return createWasCellAdapter();
			}
			public Object caseWasCellUnit(WasCellUnit object) {
				return createWasCellUnitAdapter();
			}
			public Object caseWasClassLoaderConfigurationUnit(WasClassLoaderConfigurationUnit object) {
				return createWasClassLoaderConfigurationUnitAdapter();
			}
			public Object caseWasClassLoaderPolicy(WasClassLoaderPolicy object) {
				return createWasClassLoaderPolicyAdapter();
			}
			public Object caseWasCluster(WasCluster object) {
				return createWasClusterAdapter();
			}
			public Object caseWasClusterUnit(WasClusterUnit object) {
				return createWasClusterUnitAdapter();
			}
			public Object caseWasConfigurationContainer(WasConfigurationContainer object) {
				return createWasConfigurationContainerAdapter();
			}
			public Object caseWasDatasource(WasDatasource object) {
				return createWasDatasourceAdapter();
			}
			public Object caseWasDatasourceUnit(WasDatasourceUnit object) {
				return createWasDatasourceUnitAdapter();
			}
			public Object caseWasDefaultMessagingConnectionFactoryConfiguration(WasDefaultMessagingConnectionFactoryConfiguration object) {
				return createWasDefaultMessagingConnectionFactoryConfigurationAdapter();
			}
			public Object caseWasDefaultMessagingConnectionFactoryUnit(WasDefaultMessagingConnectionFactoryUnit object) {
				return createWasDefaultMessagingConnectionFactoryUnitAdapter();
			}
			public Object caseWasDefaultMessagingQueueConnectionFactoryConfiguration(WasDefaultMessagingQueueConnectionFactoryConfiguration object) {
				return createWasDefaultMessagingQueueConnectionFactoryConfigurationAdapter();
			}
			public Object caseWasDefaultMessagingQueueConnectionFactoryUnit(WasDefaultMessagingQueueConnectionFactoryUnit object) {
				return createWasDefaultMessagingQueueConnectionFactoryUnitAdapter();
			}
			public Object caseWasDefaultMessagingQueueDestination(WasDefaultMessagingQueueDestination object) {
				return createWasDefaultMessagingQueueDestinationAdapter();
			}
			public Object caseWasDefaultMessagingQueueDestinationUnit(WasDefaultMessagingQueueDestinationUnit object) {
				return createWasDefaultMessagingQueueDestinationUnitAdapter();
			}
			public Object caseWasDefaultMessagingTopicConnectionFactoryConfiguration(WasDefaultMessagingTopicConnectionFactoryConfiguration object) {
				return createWasDefaultMessagingTopicConnectionFactoryConfigurationAdapter();
			}
			public Object caseWasDefaultMessagingTopicConnectionFactoryUnit(WasDefaultMessagingTopicConnectionFactoryUnit object) {
				return createWasDefaultMessagingTopicConnectionFactoryUnitAdapter();
			}
			public Object caseWasDefaultMessagingTopicDestination(WasDefaultMessagingTopicDestination object) {
				return createWasDefaultMessagingTopicDestinationAdapter();
			}
			public Object caseWasDefaultMessagingTopicDestinationUnit(WasDefaultMessagingTopicDestinationUnit object) {
				return createWasDefaultMessagingTopicDestinationUnitAdapter();
			}
			public Object caseWasDeploymentManager(WasDeploymentManager object) {
				return createWasDeploymentManagerAdapter();
			}
			public Object caseWasDeploymentManagerUnit(WasDeploymentManagerUnit object) {
				return createWasDeploymentManagerUnitAdapter();
			}
			public Object caseWasDeployRoot(WasDeployRoot object) {
				return createWasDeployRootAdapter();
			}
			public Object caseWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint object) {
				return createWasEarClassloaderPolicyConstraintAdapter();
			}
			public Object caseWasEndpointListenerConfiguration(WasEndpointListenerConfiguration object) {
				return createWasEndpointListenerConfigurationAdapter();
			}
			public Object caseWasEndpointListenerUnit(WasEndpointListenerUnit object) {
				return createWasEndpointListenerUnitAdapter();
			}
			public Object caseWasHandlerList(WasHandlerList object) {
				return createWasHandlerListAdapter();
			}
			public Object caseWASJ2CAuthenticationDataEntry(WASJ2CAuthenticationDataEntry object) {
				return createWASJ2CAuthenticationDataEntryAdapter();
			}
			public Object caseWASJ2CAuthenticationUnit(WASJ2CAuthenticationUnit object) {
				return createWASJ2CAuthenticationUnitAdapter();
			}
			public Object caseWasJ2EEConstraint(WasJ2EEConstraint object) {
				return createWasJ2EEConstraintAdapter();
			}
			public Object caseWasJ2EEServer(WasJ2EEServer object) {
				return createWasJ2EEServerAdapter();
			}
			public Object caseWasJMSActivationSpecification(WasJMSActivationSpecification object) {
				return createWasJMSActivationSpecificationAdapter();
			}
			public Object caseWasJMSActivationSpecificationUnit(WasJMSActivationSpecificationUnit object) {
				return createWasJMSActivationSpecificationUnitAdapter();
			}
			public Object caseWasJNDIBindingConstraint(WasJNDIBindingConstraint object) {
				return createWasJNDIBindingConstraintAdapter();
			}
			public Object caseWasLdapConfiguration(WasLdapConfiguration object) {
				return createWasLdapConfigurationAdapter();
			}
			public Object caseWasLdapConfigurationUnit(WasLdapConfigurationUnit object) {
				return createWasLdapConfigurationUnitAdapter();
			}
			public Object caseWasMessagingEngine(WasMessagingEngine object) {
				return createWasMessagingEngineAdapter();
			}
			public Object caseWasMessagingEngineUnit(WasMessagingEngineUnit object) {
				return createWasMessagingEngineUnitAdapter();
			}
			public Object caseWasModuleClassLoaderPolicy(WasModuleClassLoaderPolicy object) {
				return createWasModuleClassLoaderPolicyAdapter();
			}
			public Object caseWasModuleClassloaderPolicyConstraint(WasModuleClassloaderPolicyConstraint object) {
				return createWasModuleClassloaderPolicyConstraintAdapter();
			}
			public Object caseWasModuleStartWeightConstraint(WasModuleStartWeightConstraint object) {
				return createWasModuleStartWeightConstraintAdapter();
			}
			public Object caseWasNode(WasNode object) {
				return createWasNodeAdapter();
			}
			public Object caseWasNodeGroup(WasNodeGroup object) {
				return createWasNodeGroupAdapter();
			}
			public Object caseWasNodeGroupUnit(WasNodeGroupUnit object) {
				return createWasNodeGroupUnitAdapter();
			}
			public Object caseWasNodeUnit(WasNodeUnit object) {
				return createWasNodeUnitAdapter();
			}
			public Object caseWasNodeWindowsServiceUnit(WasNodeWindowsServiceUnit object) {
				return createWasNodeWindowsServiceUnitAdapter();
			}
			public Object caseWasPluginAdmin(WasPluginAdmin object) {
				return createWasPluginAdminAdapter();
			}
			public Object caseWasPluginRedirection(WasPluginRedirection object) {
				return createWasPluginRedirectionAdapter();
			}
			public Object caseWasSecurity(WasSecurity object) {
				return createWasSecurityAdapter();
			}
			public Object caseWasSecuritySubject(WasSecuritySubject object) {
				return createWasSecuritySubjectAdapter();
			}
			public Object caseWasSecuritySubjectConstraint(WasSecuritySubjectConstraint object) {
				return createWasSecuritySubjectConstraintAdapter();
			}
			public Object caseWasServer(WasServer object) {
				return createWasServerAdapter();
			}
			public Object caseWasSharedLibContainer(WasSharedLibContainer object) {
				return createWasSharedLibContainerAdapter();
			}
			public Object caseWasSharedLibraryEntryUnit(WasSharedLibraryEntryUnit object) {
				return createWasSharedLibraryEntryUnitAdapter();
			}
			public Object caseWasSibDestination(WasSibDestination object) {
				return createWasSibDestinationAdapter();
			}
			public Object caseWasSibDestinationUnit(WasSibDestinationUnit object) {
				return createWasSibDestinationUnitAdapter();
			}
			public Object caseWasSibForeignBus(WasSibForeignBus object) {
				return createWasSibForeignBusAdapter();
			}
			public Object caseWasSibInboundPort(WasSibInboundPort object) {
				return createWasSibInboundPortAdapter();
			}
			public Object caseWasSibInboundPortUnit(WasSibInboundPortUnit object) {
				return createWasSibInboundPortUnitAdapter();
			}
			public Object caseWasSibInboundService(WasSibInboundService object) {
				return createWasSibInboundServiceAdapter();
			}
			public Object caseWasSibInboundServiceUnit(WasSibInboundServiceUnit object) {
				return createWasSibInboundServiceUnitAdapter();
			}
			public Object caseWasSibMediation(WasSibMediation object) {
				return createWasSibMediationAdapter();
			}
			public Object caseWasSibMediationUnit(WasSibMediationUnit object) {
				return createWasSibMediationUnitAdapter();
			}
			public Object caseWasSibOutboundPort(WasSibOutboundPort object) {
				return createWasSibOutboundPortAdapter();
			}
			public Object caseWasSibOutboundPortUnit(WasSibOutboundPortUnit object) {
				return createWasSibOutboundPortUnitAdapter();
			}
			public Object caseWasSibOutboundService(WasSibOutboundService object) {
				return createWasSibOutboundServiceAdapter();
			}
			public Object caseWasSibOutboundServiceUnit(WasSibOutboundServiceUnit object) {
				return createWasSibOutboundServiceUnitAdapter();
			}
			public Object caseWasSibServiceIntegrationBusLink(WasSibServiceIntegrationBusLink object) {
				return createWasSibServiceIntegrationBusLinkAdapter();
			}
			public Object caseWasSIBus(WasSIBus object) {
				return createWasSIBusAdapter();
			}
			public Object caseWasSIBusUnit(WasSIBusUnit object) {
				return createWasSIBusUnitAdapter();
			}
			public Object caseWasSubstitutionVariable(WasSubstitutionVariable object) {
				return createWasSubstitutionVariableAdapter();
			}
			public Object caseWasSystem(WasSystem object) {
				return createWasSystemAdapter();
			}
			public Object caseWasSystemUnit(WasSystemUnit object) {
				return createWasSystemUnitAdapter();
			}
			public Object caseWasV4Datasource(WasV4Datasource object) {
				return createWasV4DatasourceAdapter();
			}
			public Object caseWasV5Datasource(WasV5Datasource object) {
				return createWasV5DatasourceAdapter();
			}
			public Object caseWasV5DB2Datasource(WasV5DB2Datasource object) {
				return createWasV5DB2DatasourceAdapter();
			}
			public Object caseWasV5DB2ZosDatasource(WasV5DB2ZosDatasource object) {
				return createWasV5DB2ZosDatasourceAdapter();
			}
			public Object caseWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint object) {
				return createWasWarClassloaderPolicyConstraintAdapter();
			}
			public Object caseWasWebAppExt(WasWebAppExt object) {
				return createWasWebAppExtAdapter();
			}
			public Object caseWasWebServer(WasWebServer object) {
				return createWasWebServerAdapter();
			}
			public Object caseWasWebServerManagement(WasWebServerManagement object) {
				return createWasWebServerManagementAdapter();
			}
			public Object caseWasWebServerPlugin(WasWebServerPlugin object) {
				return createWasWebServerPluginAdapter();
			}
			public Object caseWasWebServerUnit(WasWebServerUnit object) {
				return createWasWebServerUnitAdapter();
			}
			public Object caseWebsphereAppServerUnit(WebsphereAppServerUnit object) {
				return createWebsphereAppServerUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseJdbcProvider(JdbcProvider object) {
				return createJdbcProviderAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseJdbcProviderUnit(JdbcProviderUnit object) {
				return createJdbcProviderUnitAdapter();
			}
			public Object caseJ2EEServer(J2EEServer object) {
				return createJ2EEServerAdapter();
			}
			public Object caseJ2EEDatasource(J2EEDatasource object) {
				return createJ2EEDatasourceAdapter();
			}
			public Object caseJMSConnectionFactory(JMSConnectionFactory object) {
				return createJMSConnectionFactoryAdapter();
			}
			public Object caseJMSConnectionFactoryUnit(JMSConnectionFactoryUnit object) {
				return createJMSConnectionFactoryUnitAdapter();
			}
			public Object caseJMSQueueConnectionFactory(JMSQueueConnectionFactory object) {
				return createJMSQueueConnectionFactoryAdapter();
			}
			public Object caseJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit object) {
				return createJMSQueueConnectionFactoryUnitAdapter();
			}
			public Object caseJMSDestination(JMSDestination object) {
				return createJMSDestinationAdapter();
			}
			public Object caseJMSQueueDestination(JMSQueueDestination object) {
				return createJMSQueueDestinationAdapter();
			}
			public Object caseJMSQueueDestinationUnit(JMSQueueDestinationUnit object) {
				return createJMSQueueDestinationUnitAdapter();
			}
			public Object caseJMSTopicConnectionFactory(JMSTopicConnectionFactory object) {
				return createJMSTopicConnectionFactoryAdapter();
			}
			public Object caseJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit object) {
				return createJMSTopicConnectionFactoryUnitAdapter();
			}
			public Object caseJMSTopicDestination(JMSTopicDestination object) {
				return createJMSTopicDestinationAdapter();
			}
			public Object caseJMSTopicDestinationUnit(JMSTopicDestinationUnit object) {
				return createJMSTopicDestinationUnitAdapter();
			}
			public Object caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			public Object caseJ2CAuthenticationDataEntry(J2CAuthenticationDataEntry object) {
				return createJ2CAuthenticationDataEntryAdapter();
			}
			public Object caseJ2CAuthenticationUnit(J2CAuthenticationUnit object) {
				return createJ2CAuthenticationUnitAdapter();
			}
			public Object caseJMSActivationSpecification(JMSActivationSpecification object) {
				return createJMSActivationSpecificationAdapter();
			}
			public Object caseJMSActivationSpecificationUnit(JMSActivationSpecificationUnit object) {
				return createJMSActivationSpecificationUnitAdapter();
			}
			public Object caseWindowsLocalServiceUnit(WindowsLocalServiceUnit object) {
				return createWindowsLocalServiceUnitAdapter();
			}
			public Object caseJ2EEServerUnit(J2EEServerUnit object) {
				return createJ2EEServerUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.Classloader <em>Classloader</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.Classloader
	 * @generated
	 */
	public Adapter createClassloaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProvider <em>DB2 Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.DB2JdbcProvider
	 * @generated
	 */
	public Adapter createDB2JdbcProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit <em>DB2 Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit
	 * @generated
	 */
	public Adapter createDB2JdbcProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider <em>Derby Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider
	 * @generated
	 */
	public Adapter createDerbyJdbcProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderUnit <em>Derby Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderUnit
	 * @generated
	 */
	public Adapter createDerbyJdbcProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.ExtendedJdbcProvider <em>Extended Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.ExtendedJdbcProvider
	 * @generated
	 */
	public Adapter createExtendedJdbcProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.ExtendedJdbcProviderUnit <em>Extended Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.ExtendedJdbcProviderUnit
	 * @generated
	 */
	public Adapter createExtendedJdbcProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.HostNameAliasType <em>Host Name Alias Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.HostNameAliasType
	 * @generated
	 */
	public Adapter createHostNameAliasTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.SharedLibraryEntry <em>Shared Library Entry</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.SharedLibraryEntry
	 * @generated
	 */
	public Adapter createSharedLibraryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.VirtualHostType <em>Virtual Host Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.VirtualHostType
	 * @generated
	 */
	public Adapter createVirtualHostTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration <em>Advanced Ldap Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration
	 * @generated
	 */
	public Adapter createWasAdvancedLdapConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy <em>Application Class Loader Policy</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy
	 * @generated
	 */
	public Adapter createWasApplicationClassLoaderPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt <em>Application Ext</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasApplicationExt
	 * @generated
	 */
	public Adapter createWasApplicationExtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasApplicationServerClassLoaderPolicy <em>Application Server Class Loader Policy</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasApplicationServerClassLoaderPolicy
	 * @generated
	 */
	public Adapter createWasApplicationServerClassLoaderPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasCell <em>Cell</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasCell
	 * @generated
	 */
	public Adapter createWasCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasCellUnit <em>Cell Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasCellUnit
	 * @generated
	 */
	public Adapter createWasCellUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderConfigurationUnit <em>Class Loader Configuration Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasClassLoaderConfigurationUnit
	 * @generated
	 */
	public Adapter createWasClassLoaderConfigurationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy <em>Class Loader Policy</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy
	 * @generated
	 */
	public Adapter createWasClassLoaderPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasCluster
	 * @generated
	 */
	public Adapter createWasClusterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasClusterUnit <em>Cluster Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasClusterUnit
	 * @generated
	 */
	public Adapter createWasClusterUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasConfigurationContainer <em>Configuration Container</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasConfigurationContainer
	 * @generated
	 */
	public Adapter createWasConfigurationContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDatasource <em>Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDatasource
	 * @generated
	 */
	public Adapter createWasDatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDatasourceUnit <em>Datasource Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDatasourceUnit
	 * @generated
	 */
	public Adapter createWasDatasourceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration <em>Default Messaging Connection Factory Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration
	 * @generated
	 */
	public Adapter createWasDefaultMessagingConnectionFactoryConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryUnit <em>Default Messaging Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createWasDefaultMessagingConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration <em>Default Messaging Queue Connection Factory Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration
	 * @generated
	 */
	public Adapter createWasDefaultMessagingQueueConnectionFactoryConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryUnit <em>Default Messaging Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createWasDefaultMessagingQueueConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination <em>Default Messaging Queue Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination
	 * @generated
	 */
	public Adapter createWasDefaultMessagingQueueDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit <em>Default Messaging Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit
	 * @generated
	 */
	public Adapter createWasDefaultMessagingQueueDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryConfiguration <em>Default Messaging Topic Connection Factory Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryConfiguration
	 * @generated
	 */
	public Adapter createWasDefaultMessagingTopicConnectionFactoryConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryUnit <em>Default Messaging Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createWasDefaultMessagingTopicConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination <em>Default Messaging Topic Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination
	 * @generated
	 */
	public Adapter createWasDefaultMessagingTopicDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit <em>Default Messaging Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit
	 * @generated
	 */
	public Adapter createWasDefaultMessagingTopicDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDeploymentManager <em>Deployment Manager</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDeploymentManager
	 * @generated
	 */
	public Adapter createWasDeploymentManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit <em>Deployment Manager Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit
	 * @generated
	 */
	public Adapter createWasDeploymentManagerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasDeployRoot
	 * @generated
	 */
	public Adapter createWasDeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint <em>Ear Classloader Policy Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint
	 * @generated
	 */
	public Adapter createWasEarClassloaderPolicyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration <em>Endpoint Listener Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration
	 * @generated
	 */
	public Adapter createWasEndpointListenerConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit <em>Endpoint Listener Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit
	 * @generated
	 */
	public Adapter createWasEndpointListenerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasHandlerList <em>Handler List</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasHandlerList
	 * @generated
	 */
	public Adapter createWasHandlerListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry <em>WASJ2C Authentication Data Entry</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry
	 * @generated
	 */
	public Adapter createWASJ2CAuthenticationDataEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit <em>WASJ2C Authentication Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit
	 * @generated
	 */
	public Adapter createWASJ2CAuthenticationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasJ2EEConstraint <em>J2EE Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasJ2EEConstraint
	 * @generated
	 */
	public Adapter createWasJ2EEConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasJ2EEServer <em>J2EE Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasJ2EEServer
	 * @generated
	 */
	public Adapter createWasJ2EEServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification <em>JMS Activation Specification</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification
	 * @generated
	 */
	public Adapter createWasJMSActivationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit <em>JMS Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit
	 * @generated
	 */
	public Adapter createWasJMSActivationSpecificationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint <em>JNDI Binding Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint
	 * @generated
	 */
	public Adapter createWasJNDIBindingConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration <em>Ldap Configuration</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasLdapConfiguration
	 * @generated
	 */
	public Adapter createWasLdapConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasLdapConfigurationUnit <em>Ldap Configuration Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasLdapConfigurationUnit
	 * @generated
	 */
	public Adapter createWasLdapConfigurationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasMessagingEngine <em>Messaging Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasMessagingEngine
	 * @generated
	 */
	public Adapter createWasMessagingEngineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasMessagingEngineUnit <em>Messaging Engine Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasMessagingEngineUnit
	 * @generated
	 */
	public Adapter createWasMessagingEngineUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy <em>Module Class Loader Policy</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasModuleClassLoaderPolicy
	 * @generated
	 */
	public Adapter createWasModuleClassLoaderPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasModuleClassloaderPolicyConstraint <em>Module Classloader Policy Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasModuleClassloaderPolicyConstraint
	 * @generated
	 */
	public Adapter createWasModuleClassloaderPolicyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint <em>Module Start Weight Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint
	 * @generated
	 */
	public Adapter createWasModuleStartWeightConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasNode <em>Node</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasNode
	 * @generated
	 */
	public Adapter createWasNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroup <em>Node Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasNodeGroup
	 * @generated
	 */
	public Adapter createWasNodeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit <em>Node Group Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit
	 * @generated
	 */
	public Adapter createWasNodeGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasNodeUnit <em>Node Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasNodeUnit
	 * @generated
	 */
	public Adapter createWasNodeUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit <em>Node Windows Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasNodeWindowsServiceUnit
	 * @generated
	 */
	public Adapter createWasNodeWindowsServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasPluginAdmin <em>Plugin Admin</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasPluginAdmin
	 * @generated
	 */
	public Adapter createWasPluginAdminAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasPluginRedirection <em>Plugin Redirection</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasPluginRedirection
	 * @generated
	 */
	public Adapter createWasPluginRedirectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSecurity <em>Security</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSecurity
	 * @generated
	 */
	public Adapter createWasSecurityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubject <em>Security Subject</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSecuritySubject
	 * @generated
	 */
	public Adapter createWasSecuritySubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint <em>Security Subject Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint
	 * @generated
	 */
	public Adapter createWasSecuritySubjectConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasServer <em>Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasServer
	 * @generated
	 */
	public Adapter createWasServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSharedLibContainer <em>Shared Lib Container</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSharedLibContainer
	 * @generated
	 */
	public Adapter createWasSharedLibContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit <em>Shared Library Entry Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit
	 * @generated
	 */
	public Adapter createWasSharedLibraryEntryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibDestination <em>Sib Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibDestination
	 * @generated
	 */
	public Adapter createWasSibDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit <em>Sib Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit
	 * @generated
	 */
	public Adapter createWasSibDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus <em>Sib Foreign Bus</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibForeignBus
	 * @generated
	 */
	public Adapter createWasSibForeignBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundPort <em>Sib Inbound Port</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibInboundPort
	 * @generated
	 */
	public Adapter createWasSibInboundPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit <em>Sib Inbound Port Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit
	 * @generated
	 */
	public Adapter createWasSibInboundPortUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundService <em>Sib Inbound Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibInboundService
	 * @generated
	 */
	public Adapter createWasSibInboundServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit <em>Sib Inbound Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibInboundServiceUnit
	 * @generated
	 */
	public Adapter createWasSibInboundServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibMediation <em>Sib Mediation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibMediation
	 * @generated
	 */
	public Adapter createWasSibMediationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibMediationUnit <em>Sib Mediation Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibMediationUnit
	 * @generated
	 */
	public Adapter createWasSibMediationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibOutboundPort <em>Sib Outbound Port</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibOutboundPort
	 * @generated
	 */
	public Adapter createWasSibOutboundPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit <em>Sib Outbound Port Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit
	 * @generated
	 */
	public Adapter createWasSibOutboundPortUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibOutboundService <em>Sib Outbound Service</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibOutboundService
	 * @generated
	 */
	public Adapter createWasSibOutboundServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit <em>Sib Outbound Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit
	 * @generated
	 */
	public Adapter createWasSibOutboundServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink <em>Sib Service Integration Bus Link</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink
	 * @generated
	 */
	public Adapter createWasSibServiceIntegrationBusLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSIBus <em>SI Bus</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSIBus
	 * @generated
	 */
	public Adapter createWasSIBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSIBusUnit <em>SI Bus Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSIBusUnit
	 * @generated
	 */
	public Adapter createWasSIBusUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable <em>Substitution Variable</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable
	 * @generated
	 */
	public Adapter createWasSubstitutionVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSystem <em>System</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSystem
	 * @generated
	 */
	public Adapter createWasSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasSystemUnit <em>System Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasSystemUnit
	 * @generated
	 */
	public Adapter createWasSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasV4Datasource <em>V4 Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasV4Datasource
	 * @generated
	 */
	public Adapter createWasV4DatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource <em>V5 Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasV5Datasource
	 * @generated
	 */
	public Adapter createWasV5DatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource <em>V5DB2 Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource
	 * @generated
	 */
	public Adapter createWasV5DB2DatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2ZosDatasource <em>V5DB2 Zos Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasV5DB2ZosDatasource
	 * @generated
	 */
	public Adapter createWasV5DB2ZosDatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint <em>War Classloader Policy Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint
	 * @generated
	 */
	public Adapter createWasWarClassloaderPolicyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt <em>Web App Ext</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebAppExt
	 * @generated
	 */
	public Adapter createWasWebAppExtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWebServer <em>Web Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServer
	 * @generated
	 */
	public Adapter createWasWebServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWebServerManagement <em>Web Server Management</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerManagement
	 * @generated
	 */
	public Adapter createWasWebServerManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWebServerPlugin <em>Web Server Plugin</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerPlugin
	 * @generated
	 */
	public Adapter createWasWebServerPluginAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WasWebServerUnit <em>Web Server Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WasWebServerUnit
	 * @generated
	 */
	public Adapter createWasWebServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit <em>Websphere App Server Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit
	 * @generated
	 */
	public Adapter createWebsphereAppServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider <em>Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider
	 * @generated
	 */
	public Adapter createJdbcProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.java.JdbcProviderUnit <em>Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProviderUnit
	 * @generated
	 */
	public Adapter createJdbcProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource <em>J2EE Datasource</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource
	 * @generated
	 */
	public Adapter createJ2EEDatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory <em>JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory
	 * @generated
	 */
	public Adapter createJMSConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit <em>JMS Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory <em>JMS Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory
	 * @generated
	 */
	public Adapter createJMSQueueConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit <em>JMS Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSQueueConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination <em>JMS Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination
	 * @generated
	 */
	public Adapter createJMSDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination <em>JMS Queue Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination
	 * @generated
	 */
	public Adapter createJMSQueueDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit <em>JMS Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit
	 * @generated
	 */
	public Adapter createJMSQueueDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory <em>JMS Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory
	 * @generated
	 */
	public Adapter createJMSTopicConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit <em>JMS Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSTopicConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination <em>JMS Topic Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination
	 * @generated
	 */
	public Adapter createJMSTopicDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit <em>JMS Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit
	 * @generated
	 */
	public Adapter createJMSTopicDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry <em>J2C Authentication Data Entry</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry
	 * @generated
	 */
	public Adapter createJ2CAuthenticationDataEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit <em>J2C Authentication Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit
	 * @generated
	 */
	public Adapter createJ2CAuthenticationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification <em>JMS Activation Specification</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification
	 * @generated
	 */
	public Adapter createJMSActivationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit <em>JMS Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit
	 * @generated
	 */
	public Adapter createJMSActivationSpecificationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit <em>Windows Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit
	 * @generated
	 */
	public Adapter createWindowsLocalServiceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit <em>J2EE Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit
	 * @generated
	 */
	public Adapter createJ2EEServerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEServer <em>J2EE Server</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEServer
	 * @generated
	 */
	public Adapter createJ2EEServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WasAdapterFactory
