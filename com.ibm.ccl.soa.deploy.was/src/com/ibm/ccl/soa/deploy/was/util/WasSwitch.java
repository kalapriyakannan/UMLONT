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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage
 * @generated
 */
public class WasSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static WasPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasSwitch() {
		if (modelPackage == null) {
			modelPackage = WasPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WasPackage.CLASSLOADER: {
				Classloader classloader = (Classloader)theEObject;
				Object result = caseClassloader(classloader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.DB2_JDBC_PROVIDER: {
				DB2JdbcProvider db2JdbcProvider = (DB2JdbcProvider)theEObject;
				Object result = caseDB2JdbcProvider(db2JdbcProvider);
				if (result == null) result = caseExtendedJdbcProvider(db2JdbcProvider);
				if (result == null) result = caseJdbcProvider(db2JdbcProvider);
				if (result == null) result = caseCapability(db2JdbcProvider);
				if (result == null) result = caseDeployModelObject(db2JdbcProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.DB2_JDBC_PROVIDER_UNIT: {
				DB2JdbcProviderUnit db2JdbcProviderUnit = (DB2JdbcProviderUnit)theEObject;
				Object result = caseDB2JdbcProviderUnit(db2JdbcProviderUnit);
				if (result == null) result = caseExtendedJdbcProviderUnit(db2JdbcProviderUnit);
				if (result == null) result = caseJdbcProviderUnit(db2JdbcProviderUnit);
				if (result == null) result = caseUnit(db2JdbcProviderUnit);
				if (result == null) result = caseDeployModelObject(db2JdbcProviderUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.DERBY_JDBC_PROVIDER: {
				DerbyJdbcProvider derbyJdbcProvider = (DerbyJdbcProvider)theEObject;
				Object result = caseDerbyJdbcProvider(derbyJdbcProvider);
				if (result == null) result = caseExtendedJdbcProvider(derbyJdbcProvider);
				if (result == null) result = caseJdbcProvider(derbyJdbcProvider);
				if (result == null) result = caseCapability(derbyJdbcProvider);
				if (result == null) result = caseDeployModelObject(derbyJdbcProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.DERBY_JDBC_PROVIDER_UNIT: {
				DerbyJdbcProviderUnit derbyJdbcProviderUnit = (DerbyJdbcProviderUnit)theEObject;
				Object result = caseDerbyJdbcProviderUnit(derbyJdbcProviderUnit);
				if (result == null) result = caseExtendedJdbcProviderUnit(derbyJdbcProviderUnit);
				if (result == null) result = caseJdbcProviderUnit(derbyJdbcProviderUnit);
				if (result == null) result = caseUnit(derbyJdbcProviderUnit);
				if (result == null) result = caseDeployModelObject(derbyJdbcProviderUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.EXTENDED_JDBC_PROVIDER: {
				ExtendedJdbcProvider extendedJdbcProvider = (ExtendedJdbcProvider)theEObject;
				Object result = caseExtendedJdbcProvider(extendedJdbcProvider);
				if (result == null) result = caseJdbcProvider(extendedJdbcProvider);
				if (result == null) result = caseCapability(extendedJdbcProvider);
				if (result == null) result = caseDeployModelObject(extendedJdbcProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.EXTENDED_JDBC_PROVIDER_UNIT: {
				ExtendedJdbcProviderUnit extendedJdbcProviderUnit = (ExtendedJdbcProviderUnit)theEObject;
				Object result = caseExtendedJdbcProviderUnit(extendedJdbcProviderUnit);
				if (result == null) result = caseJdbcProviderUnit(extendedJdbcProviderUnit);
				if (result == null) result = caseUnit(extendedJdbcProviderUnit);
				if (result == null) result = caseDeployModelObject(extendedJdbcProviderUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.HOST_NAME_ALIAS_TYPE: {
				HostNameAliasType hostNameAliasType = (HostNameAliasType)theEObject;
				Object result = caseHostNameAliasType(hostNameAliasType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.SHARED_LIBRARY_ENTRY: {
				SharedLibraryEntry sharedLibraryEntry = (SharedLibraryEntry)theEObject;
				Object result = caseSharedLibraryEntry(sharedLibraryEntry);
				if (result == null) result = caseCapability(sharedLibraryEntry);
				if (result == null) result = caseDeployModelObject(sharedLibraryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.VIRTUAL_HOST_TYPE: {
				VirtualHostType virtualHostType = (VirtualHostType)theEObject;
				Object result = caseVirtualHostType(virtualHostType);
				if (result == null) result = caseCapability(virtualHostType);
				if (result == null) result = caseDeployModelObject(virtualHostType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_ADVANCED_LDAP_CONFIGURATION: {
				WasAdvancedLdapConfiguration wasAdvancedLdapConfiguration = (WasAdvancedLdapConfiguration)theEObject;
				Object result = caseWasAdvancedLdapConfiguration(wasAdvancedLdapConfiguration);
				if (result == null) result = caseCapability(wasAdvancedLdapConfiguration);
				if (result == null) result = caseDeployModelObject(wasAdvancedLdapConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_APPLICATION_CLASS_LOADER_POLICY: {
				WasApplicationClassLoaderPolicy wasApplicationClassLoaderPolicy = (WasApplicationClassLoaderPolicy)theEObject;
				Object result = caseWasApplicationClassLoaderPolicy(wasApplicationClassLoaderPolicy);
				if (result == null) result = caseWasClassLoaderPolicy(wasApplicationClassLoaderPolicy);
				if (result == null) result = caseCapability(wasApplicationClassLoaderPolicy);
				if (result == null) result = caseDeployModelObject(wasApplicationClassLoaderPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_APPLICATION_EXT: {
				WasApplicationExt wasApplicationExt = (WasApplicationExt)theEObject;
				Object result = caseWasApplicationExt(wasApplicationExt);
				if (result == null) result = caseCapability(wasApplicationExt);
				if (result == null) result = caseDeployModelObject(wasApplicationExt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY: {
				WasApplicationServerClassLoaderPolicy wasApplicationServerClassLoaderPolicy = (WasApplicationServerClassLoaderPolicy)theEObject;
				Object result = caseWasApplicationServerClassLoaderPolicy(wasApplicationServerClassLoaderPolicy);
				if (result == null) result = caseWasClassLoaderPolicy(wasApplicationServerClassLoaderPolicy);
				if (result == null) result = caseCapability(wasApplicationServerClassLoaderPolicy);
				if (result == null) result = caseDeployModelObject(wasApplicationServerClassLoaderPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CELL: {
				WasCell wasCell = (WasCell)theEObject;
				Object result = caseWasCell(wasCell);
				if (result == null) result = caseCapability(wasCell);
				if (result == null) result = caseDeployModelObject(wasCell);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CELL_UNIT: {
				WasCellUnit wasCellUnit = (WasCellUnit)theEObject;
				Object result = caseWasCellUnit(wasCellUnit);
				if (result == null) result = caseUnit(wasCellUnit);
				if (result == null) result = caseDeployModelObject(wasCellUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CLASS_LOADER_CONFIGURATION_UNIT: {
				WasClassLoaderConfigurationUnit wasClassLoaderConfigurationUnit = (WasClassLoaderConfigurationUnit)theEObject;
				Object result = caseWasClassLoaderConfigurationUnit(wasClassLoaderConfigurationUnit);
				if (result == null) result = caseUnit(wasClassLoaderConfigurationUnit);
				if (result == null) result = caseDeployModelObject(wasClassLoaderConfigurationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CLASS_LOADER_POLICY: {
				WasClassLoaderPolicy wasClassLoaderPolicy = (WasClassLoaderPolicy)theEObject;
				Object result = caseWasClassLoaderPolicy(wasClassLoaderPolicy);
				if (result == null) result = caseCapability(wasClassLoaderPolicy);
				if (result == null) result = caseDeployModelObject(wasClassLoaderPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CLUSTER: {
				WasCluster wasCluster = (WasCluster)theEObject;
				Object result = caseWasCluster(wasCluster);
				if (result == null) result = caseWasJ2EEServer(wasCluster);
				if (result == null) result = caseJ2EEServer(wasCluster);
				if (result == null) result = caseCapability(wasCluster);
				if (result == null) result = caseDeployModelObject(wasCluster);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CLUSTER_UNIT: {
				WasClusterUnit wasClusterUnit = (WasClusterUnit)theEObject;
				Object result = caseWasClusterUnit(wasClusterUnit);
				if (result == null) result = caseUnit(wasClusterUnit);
				if (result == null) result = caseDeployModelObject(wasClusterUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_CONFIGURATION_CONTAINER: {
				WasConfigurationContainer wasConfigurationContainer = (WasConfigurationContainer)theEObject;
				Object result = caseWasConfigurationContainer(wasConfigurationContainer);
				if (result == null) result = caseCapability(wasConfigurationContainer);
				if (result == null) result = caseDeployModelObject(wasConfigurationContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DATASOURCE: {
				WasDatasource wasDatasource = (WasDatasource)theEObject;
				Object result = caseWasDatasource(wasDatasource);
				if (result == null) result = caseJ2EEDatasource(wasDatasource);
				if (result == null) result = caseCapability(wasDatasource);
				if (result == null) result = caseDeployModelObject(wasDatasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DATASOURCE_UNIT: {
				WasDatasourceUnit wasDatasourceUnit = (WasDatasourceUnit)theEObject;
				Object result = caseWasDatasourceUnit(wasDatasourceUnit);
				if (result == null) result = caseUnit(wasDatasourceUnit);
				if (result == null) result = caseDeployModelObject(wasDatasourceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION: {
				WasDefaultMessagingConnectionFactoryConfiguration wasDefaultMessagingConnectionFactoryConfiguration = (WasDefaultMessagingConnectionFactoryConfiguration)theEObject;
				Object result = caseWasDefaultMessagingConnectionFactoryConfiguration(wasDefaultMessagingConnectionFactoryConfiguration);
				if (result == null) result = caseJMSConnectionFactory(wasDefaultMessagingConnectionFactoryConfiguration);
				if (result == null) result = caseCapability(wasDefaultMessagingConnectionFactoryConfiguration);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingConnectionFactoryConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT: {
				WasDefaultMessagingConnectionFactoryUnit wasDefaultMessagingConnectionFactoryUnit = (WasDefaultMessagingConnectionFactoryUnit)theEObject;
				Object result = caseWasDefaultMessagingConnectionFactoryUnit(wasDefaultMessagingConnectionFactoryUnit);
				if (result == null) result = caseJMSConnectionFactoryUnit(wasDefaultMessagingConnectionFactoryUnit);
				if (result == null) result = caseUnit(wasDefaultMessagingConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION: {
				WasDefaultMessagingQueueConnectionFactoryConfiguration wasDefaultMessagingQueueConnectionFactoryConfiguration = (WasDefaultMessagingQueueConnectionFactoryConfiguration)theEObject;
				Object result = caseWasDefaultMessagingQueueConnectionFactoryConfiguration(wasDefaultMessagingQueueConnectionFactoryConfiguration);
				if (result == null) result = caseJMSQueueConnectionFactory(wasDefaultMessagingQueueConnectionFactoryConfiguration);
				if (result == null) result = caseCapability(wasDefaultMessagingQueueConnectionFactoryConfiguration);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingQueueConnectionFactoryConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT: {
				WasDefaultMessagingQueueConnectionFactoryUnit wasDefaultMessagingQueueConnectionFactoryUnit = (WasDefaultMessagingQueueConnectionFactoryUnit)theEObject;
				Object result = caseWasDefaultMessagingQueueConnectionFactoryUnit(wasDefaultMessagingQueueConnectionFactoryUnit);
				if (result == null) result = caseJMSQueueConnectionFactoryUnit(wasDefaultMessagingQueueConnectionFactoryUnit);
				if (result == null) result = caseUnit(wasDefaultMessagingQueueConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingQueueConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION: {
				WasDefaultMessagingQueueDestination wasDefaultMessagingQueueDestination = (WasDefaultMessagingQueueDestination)theEObject;
				Object result = caseWasDefaultMessagingQueueDestination(wasDefaultMessagingQueueDestination);
				if (result == null) result = caseJMSQueueDestination(wasDefaultMessagingQueueDestination);
				if (result == null) result = caseJMSDestination(wasDefaultMessagingQueueDestination);
				if (result == null) result = caseCapability(wasDefaultMessagingQueueDestination);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingQueueDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT: {
				WasDefaultMessagingQueueDestinationUnit wasDefaultMessagingQueueDestinationUnit = (WasDefaultMessagingQueueDestinationUnit)theEObject;
				Object result = caseWasDefaultMessagingQueueDestinationUnit(wasDefaultMessagingQueueDestinationUnit);
				if (result == null) result = caseJMSQueueDestinationUnit(wasDefaultMessagingQueueDestinationUnit);
				if (result == null) result = caseUnit(wasDefaultMessagingQueueDestinationUnit);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingQueueDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION: {
				WasDefaultMessagingTopicConnectionFactoryConfiguration wasDefaultMessagingTopicConnectionFactoryConfiguration = (WasDefaultMessagingTopicConnectionFactoryConfiguration)theEObject;
				Object result = caseWasDefaultMessagingTopicConnectionFactoryConfiguration(wasDefaultMessagingTopicConnectionFactoryConfiguration);
				if (result == null) result = caseJMSTopicConnectionFactory(wasDefaultMessagingTopicConnectionFactoryConfiguration);
				if (result == null) result = caseCapability(wasDefaultMessagingTopicConnectionFactoryConfiguration);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingTopicConnectionFactoryConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT: {
				WasDefaultMessagingTopicConnectionFactoryUnit wasDefaultMessagingTopicConnectionFactoryUnit = (WasDefaultMessagingTopicConnectionFactoryUnit)theEObject;
				Object result = caseWasDefaultMessagingTopicConnectionFactoryUnit(wasDefaultMessagingTopicConnectionFactoryUnit);
				if (result == null) result = caseJMSTopicConnectionFactoryUnit(wasDefaultMessagingTopicConnectionFactoryUnit);
				if (result == null) result = caseUnit(wasDefaultMessagingTopicConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingTopicConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION: {
				WasDefaultMessagingTopicDestination wasDefaultMessagingTopicDestination = (WasDefaultMessagingTopicDestination)theEObject;
				Object result = caseWasDefaultMessagingTopicDestination(wasDefaultMessagingTopicDestination);
				if (result == null) result = caseJMSTopicDestination(wasDefaultMessagingTopicDestination);
				if (result == null) result = caseJMSDestination(wasDefaultMessagingTopicDestination);
				if (result == null) result = caseCapability(wasDefaultMessagingTopicDestination);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingTopicDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT: {
				WasDefaultMessagingTopicDestinationUnit wasDefaultMessagingTopicDestinationUnit = (WasDefaultMessagingTopicDestinationUnit)theEObject;
				Object result = caseWasDefaultMessagingTopicDestinationUnit(wasDefaultMessagingTopicDestinationUnit);
				if (result == null) result = caseJMSTopicDestinationUnit(wasDefaultMessagingTopicDestinationUnit);
				if (result == null) result = caseUnit(wasDefaultMessagingTopicDestinationUnit);
				if (result == null) result = caseDeployModelObject(wasDefaultMessagingTopicDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEPLOYMENT_MANAGER: {
				WasDeploymentManager wasDeploymentManager = (WasDeploymentManager)theEObject;
				Object result = caseWasDeploymentManager(wasDeploymentManager);
				if (result == null) result = caseCapability(wasDeploymentManager);
				if (result == null) result = caseDeployModelObject(wasDeploymentManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEPLOYMENT_MANAGER_UNIT: {
				WasDeploymentManagerUnit wasDeploymentManagerUnit = (WasDeploymentManagerUnit)theEObject;
				Object result = caseWasDeploymentManagerUnit(wasDeploymentManagerUnit);
				if (result == null) result = caseUnit(wasDeploymentManagerUnit);
				if (result == null) result = caseDeployModelObject(wasDeploymentManagerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_DEPLOY_ROOT: {
				WasDeployRoot wasDeployRoot = (WasDeployRoot)theEObject;
				Object result = caseWasDeployRoot(wasDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT: {
				WasEarClassloaderPolicyConstraint wasEarClassloaderPolicyConstraint = (WasEarClassloaderPolicyConstraint)theEObject;
				Object result = caseWasEarClassloaderPolicyConstraint(wasEarClassloaderPolicyConstraint);
				if (result == null) result = caseWasWarClassloaderPolicyConstraint(wasEarClassloaderPolicyConstraint);
				if (result == null) result = caseWasModuleClassloaderPolicyConstraint(wasEarClassloaderPolicyConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasEarClassloaderPolicyConstraint);
				if (result == null) result = caseConstraint(wasEarClassloaderPolicyConstraint);
				if (result == null) result = caseDeployModelObject(wasEarClassloaderPolicyConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION: {
				WasEndpointListenerConfiguration wasEndpointListenerConfiguration = (WasEndpointListenerConfiguration)theEObject;
				Object result = caseWasEndpointListenerConfiguration(wasEndpointListenerConfiguration);
				if (result == null) result = caseCapability(wasEndpointListenerConfiguration);
				if (result == null) result = caseDeployModelObject(wasEndpointListenerConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_ENDPOINT_LISTENER_UNIT: {
				WasEndpointListenerUnit wasEndpointListenerUnit = (WasEndpointListenerUnit)theEObject;
				Object result = caseWasEndpointListenerUnit(wasEndpointListenerUnit);
				if (result == null) result = caseUnit(wasEndpointListenerUnit);
				if (result == null) result = caseDeployModelObject(wasEndpointListenerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_HANDLER_LIST: {
				WasHandlerList wasHandlerList = (WasHandlerList)theEObject;
				Object result = caseWasHandlerList(wasHandlerList);
				if (result == null) result = caseCapability(wasHandlerList);
				if (result == null) result = caseDeployModelObject(wasHandlerList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WASJ2C_AUTHENTICATION_DATA_ENTRY: {
				WASJ2CAuthenticationDataEntry wasj2CAuthenticationDataEntry = (WASJ2CAuthenticationDataEntry)theEObject;
				Object result = caseWASJ2CAuthenticationDataEntry(wasj2CAuthenticationDataEntry);
				if (result == null) result = caseJ2CAuthenticationDataEntry(wasj2CAuthenticationDataEntry);
				if (result == null) result = caseCapability(wasj2CAuthenticationDataEntry);
				if (result == null) result = caseDeployModelObject(wasj2CAuthenticationDataEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WASJ2C_AUTHENTICATION_UNIT: {
				WASJ2CAuthenticationUnit wasj2CAuthenticationUnit = (WASJ2CAuthenticationUnit)theEObject;
				Object result = caseWASJ2CAuthenticationUnit(wasj2CAuthenticationUnit);
				if (result == null) result = caseJ2CAuthenticationUnit(wasj2CAuthenticationUnit);
				if (result == null) result = caseUnit(wasj2CAuthenticationUnit);
				if (result == null) result = caseDeployModelObject(wasj2CAuthenticationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_J2EE_CONSTRAINT: {
				WasJ2EEConstraint wasJ2EEConstraint = (WasJ2EEConstraint)theEObject;
				Object result = caseWasJ2EEConstraint(wasJ2EEConstraint);
				if (result == null) result = caseConstraint(wasJ2EEConstraint);
				if (result == null) result = caseDeployModelObject(wasJ2EEConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_J2EE_SERVER: {
				WasJ2EEServer wasJ2EEServer = (WasJ2EEServer)theEObject;
				Object result = caseWasJ2EEServer(wasJ2EEServer);
				if (result == null) result = caseJ2EEServer(wasJ2EEServer);
				if (result == null) result = caseCapability(wasJ2EEServer);
				if (result == null) result = caseDeployModelObject(wasJ2EEServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION: {
				WasJMSActivationSpecification wasJMSActivationSpecification = (WasJMSActivationSpecification)theEObject;
				Object result = caseWasJMSActivationSpecification(wasJMSActivationSpecification);
				if (result == null) result = caseJMSActivationSpecification(wasJMSActivationSpecification);
				if (result == null) result = caseCapability(wasJMSActivationSpecification);
				if (result == null) result = caseDeployModelObject(wasJMSActivationSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT: {
				WasJMSActivationSpecificationUnit wasJMSActivationSpecificationUnit = (WasJMSActivationSpecificationUnit)theEObject;
				Object result = caseWasJMSActivationSpecificationUnit(wasJMSActivationSpecificationUnit);
				if (result == null) result = caseJMSActivationSpecificationUnit(wasJMSActivationSpecificationUnit);
				if (result == null) result = caseUnit(wasJMSActivationSpecificationUnit);
				if (result == null) result = caseDeployModelObject(wasJMSActivationSpecificationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_JNDI_BINDING_CONSTRAINT: {
				WasJNDIBindingConstraint wasJNDIBindingConstraint = (WasJNDIBindingConstraint)theEObject;
				Object result = caseWasJNDIBindingConstraint(wasJNDIBindingConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasJNDIBindingConstraint);
				if (result == null) result = caseConstraint(wasJNDIBindingConstraint);
				if (result == null) result = caseDeployModelObject(wasJNDIBindingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_LDAP_CONFIGURATION: {
				WasLdapConfiguration wasLdapConfiguration = (WasLdapConfiguration)theEObject;
				Object result = caseWasLdapConfiguration(wasLdapConfiguration);
				if (result == null) result = caseCapability(wasLdapConfiguration);
				if (result == null) result = caseDeployModelObject(wasLdapConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_LDAP_CONFIGURATION_UNIT: {
				WasLdapConfigurationUnit wasLdapConfigurationUnit = (WasLdapConfigurationUnit)theEObject;
				Object result = caseWasLdapConfigurationUnit(wasLdapConfigurationUnit);
				if (result == null) result = caseUnit(wasLdapConfigurationUnit);
				if (result == null) result = caseDeployModelObject(wasLdapConfigurationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_MESSAGING_ENGINE: {
				WasMessagingEngine wasMessagingEngine = (WasMessagingEngine)theEObject;
				Object result = caseWasMessagingEngine(wasMessagingEngine);
				if (result == null) result = caseCapability(wasMessagingEngine);
				if (result == null) result = caseDeployModelObject(wasMessagingEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_MESSAGING_ENGINE_UNIT: {
				WasMessagingEngineUnit wasMessagingEngineUnit = (WasMessagingEngineUnit)theEObject;
				Object result = caseWasMessagingEngineUnit(wasMessagingEngineUnit);
				if (result == null) result = caseUnit(wasMessagingEngineUnit);
				if (result == null) result = caseDeployModelObject(wasMessagingEngineUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_MODULE_CLASS_LOADER_POLICY: {
				WasModuleClassLoaderPolicy wasModuleClassLoaderPolicy = (WasModuleClassLoaderPolicy)theEObject;
				Object result = caseWasModuleClassLoaderPolicy(wasModuleClassLoaderPolicy);
				if (result == null) result = caseWasClassLoaderPolicy(wasModuleClassLoaderPolicy);
				if (result == null) result = caseCapability(wasModuleClassLoaderPolicy);
				if (result == null) result = caseDeployModelObject(wasModuleClassLoaderPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT: {
				WasModuleClassloaderPolicyConstraint wasModuleClassloaderPolicyConstraint = (WasModuleClassloaderPolicyConstraint)theEObject;
				Object result = caseWasModuleClassloaderPolicyConstraint(wasModuleClassloaderPolicyConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasModuleClassloaderPolicyConstraint);
				if (result == null) result = caseConstraint(wasModuleClassloaderPolicyConstraint);
				if (result == null) result = caseDeployModelObject(wasModuleClassloaderPolicyConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT: {
				WasModuleStartWeightConstraint wasModuleStartWeightConstraint = (WasModuleStartWeightConstraint)theEObject;
				Object result = caseWasModuleStartWeightConstraint(wasModuleStartWeightConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasModuleStartWeightConstraint);
				if (result == null) result = caseConstraint(wasModuleStartWeightConstraint);
				if (result == null) result = caseDeployModelObject(wasModuleStartWeightConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_NODE: {
				WasNode wasNode = (WasNode)theEObject;
				Object result = caseWasNode(wasNode);
				if (result == null) result = caseCapability(wasNode);
				if (result == null) result = caseDeployModelObject(wasNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_NODE_GROUP: {
				WasNodeGroup wasNodeGroup = (WasNodeGroup)theEObject;
				Object result = caseWasNodeGroup(wasNodeGroup);
				if (result == null) result = caseCapability(wasNodeGroup);
				if (result == null) result = caseDeployModelObject(wasNodeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_NODE_GROUP_UNIT: {
				WasNodeGroupUnit wasNodeGroupUnit = (WasNodeGroupUnit)theEObject;
				Object result = caseWasNodeGroupUnit(wasNodeGroupUnit);
				if (result == null) result = caseUnit(wasNodeGroupUnit);
				if (result == null) result = caseDeployModelObject(wasNodeGroupUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_NODE_UNIT: {
				WasNodeUnit wasNodeUnit = (WasNodeUnit)theEObject;
				Object result = caseWasNodeUnit(wasNodeUnit);
				if (result == null) result = caseUnit(wasNodeUnit);
				if (result == null) result = caseDeployModelObject(wasNodeUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_NODE_WINDOWS_SERVICE_UNIT: {
				WasNodeWindowsServiceUnit wasNodeWindowsServiceUnit = (WasNodeWindowsServiceUnit)theEObject;
				Object result = caseWasNodeWindowsServiceUnit(wasNodeWindowsServiceUnit);
				if (result == null) result = caseWindowsLocalServiceUnit(wasNodeWindowsServiceUnit);
				if (result == null) result = caseUnit(wasNodeWindowsServiceUnit);
				if (result == null) result = caseDeployModelObject(wasNodeWindowsServiceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_PLUGIN_ADMIN: {
				WasPluginAdmin wasPluginAdmin = (WasPluginAdmin)theEObject;
				Object result = caseWasPluginAdmin(wasPluginAdmin);
				if (result == null) result = caseCapability(wasPluginAdmin);
				if (result == null) result = caseDeployModelObject(wasPluginAdmin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_PLUGIN_REDIRECTION: {
				WasPluginRedirection wasPluginRedirection = (WasPluginRedirection)theEObject;
				Object result = caseWasPluginRedirection(wasPluginRedirection);
				if (result == null) result = caseCapability(wasPluginRedirection);
				if (result == null) result = caseDeployModelObject(wasPluginRedirection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SECURITY: {
				WasSecurity wasSecurity = (WasSecurity)theEObject;
				Object result = caseWasSecurity(wasSecurity);
				if (result == null) result = caseCapability(wasSecurity);
				if (result == null) result = caseDeployModelObject(wasSecurity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SECURITY_SUBJECT: {
				WasSecuritySubject wasSecuritySubject = (WasSecuritySubject)theEObject;
				Object result = caseWasSecuritySubject(wasSecuritySubject);
				if (result == null) result = caseCapability(wasSecuritySubject);
				if (result == null) result = caseDeployModelObject(wasSecuritySubject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT: {
				WasSecuritySubjectConstraint wasSecuritySubjectConstraint = (WasSecuritySubjectConstraint)theEObject;
				Object result = caseWasSecuritySubjectConstraint(wasSecuritySubjectConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasSecuritySubjectConstraint);
				if (result == null) result = caseConstraint(wasSecuritySubjectConstraint);
				if (result == null) result = caseDeployModelObject(wasSecuritySubjectConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SERVER: {
				WasServer wasServer = (WasServer)theEObject;
				Object result = caseWasServer(wasServer);
				if (result == null) result = caseWasJ2EEServer(wasServer);
				if (result == null) result = caseJ2EEServer(wasServer);
				if (result == null) result = caseCapability(wasServer);
				if (result == null) result = caseDeployModelObject(wasServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SHARED_LIB_CONTAINER: {
				WasSharedLibContainer wasSharedLibContainer = (WasSharedLibContainer)theEObject;
				Object result = caseWasSharedLibContainer(wasSharedLibContainer);
				if (result == null) result = caseCapability(wasSharedLibContainer);
				if (result == null) result = caseDeployModelObject(wasSharedLibContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SHARED_LIBRARY_ENTRY_UNIT: {
				WasSharedLibraryEntryUnit wasSharedLibraryEntryUnit = (WasSharedLibraryEntryUnit)theEObject;
				Object result = caseWasSharedLibraryEntryUnit(wasSharedLibraryEntryUnit);
				if (result == null) result = caseUnit(wasSharedLibraryEntryUnit);
				if (result == null) result = caseDeployModelObject(wasSharedLibraryEntryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_DESTINATION: {
				WasSibDestination wasSibDestination = (WasSibDestination)theEObject;
				Object result = caseWasSibDestination(wasSibDestination);
				if (result == null) result = caseCapability(wasSibDestination);
				if (result == null) result = caseDeployModelObject(wasSibDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_DESTINATION_UNIT: {
				WasSibDestinationUnit wasSibDestinationUnit = (WasSibDestinationUnit)theEObject;
				Object result = caseWasSibDestinationUnit(wasSibDestinationUnit);
				if (result == null) result = caseUnit(wasSibDestinationUnit);
				if (result == null) result = caseDeployModelObject(wasSibDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_FOREIGN_BUS: {
				WasSibForeignBus wasSibForeignBus = (WasSibForeignBus)theEObject;
				Object result = caseWasSibForeignBus(wasSibForeignBus);
				if (result == null) result = caseCapability(wasSibForeignBus);
				if (result == null) result = caseDeployModelObject(wasSibForeignBus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_INBOUND_PORT: {
				WasSibInboundPort wasSibInboundPort = (WasSibInboundPort)theEObject;
				Object result = caseWasSibInboundPort(wasSibInboundPort);
				if (result == null) result = caseCapability(wasSibInboundPort);
				if (result == null) result = caseDeployModelObject(wasSibInboundPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_INBOUND_PORT_UNIT: {
				WasSibInboundPortUnit wasSibInboundPortUnit = (WasSibInboundPortUnit)theEObject;
				Object result = caseWasSibInboundPortUnit(wasSibInboundPortUnit);
				if (result == null) result = caseUnit(wasSibInboundPortUnit);
				if (result == null) result = caseDeployModelObject(wasSibInboundPortUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_INBOUND_SERVICE: {
				WasSibInboundService wasSibInboundService = (WasSibInboundService)theEObject;
				Object result = caseWasSibInboundService(wasSibInboundService);
				if (result == null) result = caseCapability(wasSibInboundService);
				if (result == null) result = caseDeployModelObject(wasSibInboundService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_INBOUND_SERVICE_UNIT: {
				WasSibInboundServiceUnit wasSibInboundServiceUnit = (WasSibInboundServiceUnit)theEObject;
				Object result = caseWasSibInboundServiceUnit(wasSibInboundServiceUnit);
				if (result == null) result = caseUnit(wasSibInboundServiceUnit);
				if (result == null) result = caseDeployModelObject(wasSibInboundServiceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_MEDIATION: {
				WasSibMediation wasSibMediation = (WasSibMediation)theEObject;
				Object result = caseWasSibMediation(wasSibMediation);
				if (result == null) result = caseCapability(wasSibMediation);
				if (result == null) result = caseDeployModelObject(wasSibMediation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_MEDIATION_UNIT: {
				WasSibMediationUnit wasSibMediationUnit = (WasSibMediationUnit)theEObject;
				Object result = caseWasSibMediationUnit(wasSibMediationUnit);
				if (result == null) result = caseUnit(wasSibMediationUnit);
				if (result == null) result = caseDeployModelObject(wasSibMediationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_OUTBOUND_PORT: {
				WasSibOutboundPort wasSibOutboundPort = (WasSibOutboundPort)theEObject;
				Object result = caseWasSibOutboundPort(wasSibOutboundPort);
				if (result == null) result = caseCapability(wasSibOutboundPort);
				if (result == null) result = caseDeployModelObject(wasSibOutboundPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_OUTBOUND_PORT_UNIT: {
				WasSibOutboundPortUnit wasSibOutboundPortUnit = (WasSibOutboundPortUnit)theEObject;
				Object result = caseWasSibOutboundPortUnit(wasSibOutboundPortUnit);
				if (result == null) result = caseUnit(wasSibOutboundPortUnit);
				if (result == null) result = caseDeployModelObject(wasSibOutboundPortUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE: {
				WasSibOutboundService wasSibOutboundService = (WasSibOutboundService)theEObject;
				Object result = caseWasSibOutboundService(wasSibOutboundService);
				if (result == null) result = caseCapability(wasSibOutboundService);
				if (result == null) result = caseDeployModelObject(wasSibOutboundService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE_UNIT: {
				WasSibOutboundServiceUnit wasSibOutboundServiceUnit = (WasSibOutboundServiceUnit)theEObject;
				Object result = caseWasSibOutboundServiceUnit(wasSibOutboundServiceUnit);
				if (result == null) result = caseUnit(wasSibOutboundServiceUnit);
				if (result == null) result = caseDeployModelObject(wasSibOutboundServiceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK: {
				WasSibServiceIntegrationBusLink wasSibServiceIntegrationBusLink = (WasSibServiceIntegrationBusLink)theEObject;
				Object result = caseWasSibServiceIntegrationBusLink(wasSibServiceIntegrationBusLink);
				if (result == null) result = caseCapability(wasSibServiceIntegrationBusLink);
				if (result == null) result = caseDeployModelObject(wasSibServiceIntegrationBusLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SI_BUS: {
				WasSIBus wasSIBus = (WasSIBus)theEObject;
				Object result = caseWasSIBus(wasSIBus);
				if (result == null) result = caseCapability(wasSIBus);
				if (result == null) result = caseDeployModelObject(wasSIBus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SI_BUS_UNIT: {
				WasSIBusUnit wasSIBusUnit = (WasSIBusUnit)theEObject;
				Object result = caseWasSIBusUnit(wasSIBusUnit);
				if (result == null) result = caseUnit(wasSIBusUnit);
				if (result == null) result = caseDeployModelObject(wasSIBusUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SUBSTITUTION_VARIABLE: {
				WasSubstitutionVariable wasSubstitutionVariable = (WasSubstitutionVariable)theEObject;
				Object result = caseWasSubstitutionVariable(wasSubstitutionVariable);
				if (result == null) result = caseCapability(wasSubstitutionVariable);
				if (result == null) result = caseDeployModelObject(wasSubstitutionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SYSTEM: {
				WasSystem wasSystem = (WasSystem)theEObject;
				Object result = caseWasSystem(wasSystem);
				if (result == null) result = caseCapability(wasSystem);
				if (result == null) result = caseDeployModelObject(wasSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_SYSTEM_UNIT: {
				WasSystemUnit wasSystemUnit = (WasSystemUnit)theEObject;
				Object result = caseWasSystemUnit(wasSystemUnit);
				if (result == null) result = caseUnit(wasSystemUnit);
				if (result == null) result = caseDeployModelObject(wasSystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_V4_DATASOURCE: {
				WasV4Datasource wasV4Datasource = (WasV4Datasource)theEObject;
				Object result = caseWasV4Datasource(wasV4Datasource);
				if (result == null) result = caseWasDatasource(wasV4Datasource);
				if (result == null) result = caseJ2EEDatasource(wasV4Datasource);
				if (result == null) result = caseCapability(wasV4Datasource);
				if (result == null) result = caseDeployModelObject(wasV4Datasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_V5_DATASOURCE: {
				WasV5Datasource wasV5Datasource = (WasV5Datasource)theEObject;
				Object result = caseWasV5Datasource(wasV5Datasource);
				if (result == null) result = caseWasDatasource(wasV5Datasource);
				if (result == null) result = caseJ2EEDatasource(wasV5Datasource);
				if (result == null) result = caseCapability(wasV5Datasource);
				if (result == null) result = caseDeployModelObject(wasV5Datasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_V5DB2_DATASOURCE: {
				WasV5DB2Datasource wasV5DB2Datasource = (WasV5DB2Datasource)theEObject;
				Object result = caseWasV5DB2Datasource(wasV5DB2Datasource);
				if (result == null) result = caseWasV5Datasource(wasV5DB2Datasource);
				if (result == null) result = caseWasDatasource(wasV5DB2Datasource);
				if (result == null) result = caseJ2EEDatasource(wasV5DB2Datasource);
				if (result == null) result = caseCapability(wasV5DB2Datasource);
				if (result == null) result = caseDeployModelObject(wasV5DB2Datasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_V5DB2_ZOS_DATASOURCE: {
				WasV5DB2ZosDatasource wasV5DB2ZosDatasource = (WasV5DB2ZosDatasource)theEObject;
				Object result = caseWasV5DB2ZosDatasource(wasV5DB2ZosDatasource);
				if (result == null) result = caseWasV5Datasource(wasV5DB2ZosDatasource);
				if (result == null) result = caseWasDatasource(wasV5DB2ZosDatasource);
				if (result == null) result = caseJ2EEDatasource(wasV5DB2ZosDatasource);
				if (result == null) result = caseCapability(wasV5DB2ZosDatasource);
				if (result == null) result = caseDeployModelObject(wasV5DB2ZosDatasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT: {
				WasWarClassloaderPolicyConstraint wasWarClassloaderPolicyConstraint = (WasWarClassloaderPolicyConstraint)theEObject;
				Object result = caseWasWarClassloaderPolicyConstraint(wasWarClassloaderPolicyConstraint);
				if (result == null) result = caseWasModuleClassloaderPolicyConstraint(wasWarClassloaderPolicyConstraint);
				if (result == null) result = caseWasJ2EEConstraint(wasWarClassloaderPolicyConstraint);
				if (result == null) result = caseConstraint(wasWarClassloaderPolicyConstraint);
				if (result == null) result = caseDeployModelObject(wasWarClassloaderPolicyConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WEB_APP_EXT: {
				WasWebAppExt wasWebAppExt = (WasWebAppExt)theEObject;
				Object result = caseWasWebAppExt(wasWebAppExt);
				if (result == null) result = caseCapability(wasWebAppExt);
				if (result == null) result = caseDeployModelObject(wasWebAppExt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WEB_SERVER: {
				WasWebServer wasWebServer = (WasWebServer)theEObject;
				Object result = caseWasWebServer(wasWebServer);
				if (result == null) result = caseCapability(wasWebServer);
				if (result == null) result = caseDeployModelObject(wasWebServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT: {
				WasWebServerManagement wasWebServerManagement = (WasWebServerManagement)theEObject;
				Object result = caseWasWebServerManagement(wasWebServerManagement);
				if (result == null) result = caseCapability(wasWebServerManagement);
				if (result == null) result = caseDeployModelObject(wasWebServerManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WEB_SERVER_PLUGIN: {
				WasWebServerPlugin wasWebServerPlugin = (WasWebServerPlugin)theEObject;
				Object result = caseWasWebServerPlugin(wasWebServerPlugin);
				if (result == null) result = caseCapability(wasWebServerPlugin);
				if (result == null) result = caseDeployModelObject(wasWebServerPlugin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WAS_WEB_SERVER_UNIT: {
				WasWebServerUnit wasWebServerUnit = (WasWebServerUnit)theEObject;
				Object result = caseWasWebServerUnit(wasWebServerUnit);
				if (result == null) result = caseJ2EEServerUnit(wasWebServerUnit);
				if (result == null) result = caseUnit(wasWebServerUnit);
				if (result == null) result = caseDeployModelObject(wasWebServerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WasPackage.WEBSPHERE_APP_SERVER_UNIT: {
				WebsphereAppServerUnit websphereAppServerUnit = (WebsphereAppServerUnit)theEObject;
				Object result = caseWebsphereAppServerUnit(websphereAppServerUnit);
				if (result == null) result = caseJ2EEServerUnit(websphereAppServerUnit);
				if (result == null) result = caseUnit(websphereAppServerUnit);
				if (result == null) result = caseDeployModelObject(websphereAppServerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classloader</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classloader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassloader(Classloader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Jdbc Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2JdbcProvider(DB2JdbcProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Jdbc Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2JdbcProviderUnit(DB2JdbcProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derby Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derby Jdbc Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDerbyJdbcProvider(DerbyJdbcProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derby Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derby Jdbc Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDerbyJdbcProviderUnit(DerbyJdbcProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Jdbc Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtendedJdbcProvider(ExtendedJdbcProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Jdbc Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtendedJdbcProviderUnit(ExtendedJdbcProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Host Name Alias Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Host Name Alias Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHostNameAliasType(HostNameAliasType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Library Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Library Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSharedLibraryEntry(SharedLibraryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Host Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Host Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualHostType(VirtualHostType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advanced Ldap Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advanced Ldap Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasAdvancedLdapConfiguration(WasAdvancedLdapConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Class Loader Policy</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Class Loader Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasApplicationClassLoaderPolicy(WasApplicationClassLoaderPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Ext</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Ext</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasApplicationExt(WasApplicationExt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Server Class Loader Policy</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Server Class Loader Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasApplicationServerClassLoaderPolicy(
			WasApplicationServerClassLoaderPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Cell</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Cell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasCell(WasCell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cell Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cell Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasCellUnit(WasCellUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Loader Configuration Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Loader Configuration Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasClassLoaderConfigurationUnit(WasClassLoaderConfigurationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Loader Policy</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Loader Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasClassLoaderPolicy(WasClassLoaderPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Cluster</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Cluster</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasCluster(WasCluster object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cluster Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cluster Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasClusterUnit(WasClusterUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasConfigurationContainer(WasConfigurationContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDatasource(WasDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datasource Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datasource Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDatasourceUnit(WasDatasourceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Connection Factory Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingConnectionFactoryConfiguration(
			WasDefaultMessagingConnectionFactoryConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingConnectionFactoryUnit(
			WasDefaultMessagingConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Queue Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Queue Connection Factory Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingQueueConnectionFactoryConfiguration(
			WasDefaultMessagingQueueConnectionFactoryConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Queue Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Queue Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingQueueConnectionFactoryUnit(
			WasDefaultMessagingQueueConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Queue Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Queue Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingQueueDestination(WasDefaultMessagingQueueDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Queue Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Queue Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingQueueDestinationUnit(
			WasDefaultMessagingQueueDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Topic Connection Factory Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Topic Connection Factory Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingTopicConnectionFactoryConfiguration(
			WasDefaultMessagingTopicConnectionFactoryConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Topic Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Topic Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingTopicConnectionFactoryUnit(
			WasDefaultMessagingTopicConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Topic Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Topic Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingTopicDestination(WasDefaultMessagingTopicDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Messaging Topic Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Messaging Topic Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDefaultMessagingTopicDestinationUnit(
			WasDefaultMessagingTopicDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Manager</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDeploymentManager(WasDeploymentManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Manager Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Manager Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDeploymentManagerUnit(WasDeploymentManagerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasDeployRoot(WasDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ear Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ear Classloader Policy Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasEarClassloaderPolicyConstraint(WasEarClassloaderPolicyConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endpoint Listener Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endpoint Listener Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasEndpointListenerConfiguration(WasEndpointListenerConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endpoint Listener Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endpoint Listener Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasEndpointListenerUnit(WasEndpointListenerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Handler List</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Handler List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasHandlerList(WasHandlerList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WASJ2C Authentication Data Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WASJ2C Authentication Data Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWASJ2CAuthenticationDataEntry(WASJ2CAuthenticationDataEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WASJ2C Authentication Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WASJ2C Authentication Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWASJ2CAuthenticationUnit(WASJ2CAuthenticationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasJ2EEConstraint(WasJ2EEConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasJ2EEServer(WasJ2EEServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasJMSActivationSpecification(WasJMSActivationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasJMSActivationSpecificationUnit(WasJMSActivationSpecificationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JNDI Binding Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JNDI Binding Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasJNDIBindingConstraint(WasJNDIBindingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ldap Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ldap Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasLdapConfiguration(WasLdapConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ldap Configuration Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ldap Configuration Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasLdapConfigurationUnit(WasLdapConfigurationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Messaging Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Messaging Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasMessagingEngine(WasMessagingEngine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Messaging Engine Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Messaging Engine Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasMessagingEngineUnit(WasMessagingEngineUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Class Loader Policy</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Class Loader Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasModuleClassLoaderPolicy(WasModuleClassLoaderPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Classloader Policy Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasModuleClassloaderPolicyConstraint(
			WasModuleClassloaderPolicyConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Start Weight Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Start Weight Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasModuleStartWeightConstraint(WasModuleStartWeightConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Node</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasNode(WasNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasNodeGroup(WasNodeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Group Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasNodeGroupUnit(WasNodeGroupUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasNodeUnit(WasNodeUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Windows Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Windows Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasNodeWindowsServiceUnit(WasNodeWindowsServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Admin</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Admin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasPluginAdmin(WasPluginAdmin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Redirection</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Redirection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasPluginRedirection(WasPluginRedirection object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Security</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Security</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSecurity(WasSecurity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Subject</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Subject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSecuritySubject(WasSecuritySubject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Subject Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Subject Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSecuritySubjectConstraint(WasSecuritySubjectConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Server</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasServer(WasServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Lib Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Lib Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSharedLibContainer(WasSharedLibContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Library Entry Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Library Entry Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSharedLibraryEntryUnit(WasSharedLibraryEntryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibDestination(WasSibDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibDestinationUnit(WasSibDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Foreign Bus</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Foreign Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibForeignBus(WasSibForeignBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Inbound Port</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Inbound Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibInboundPort(WasSibInboundPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Inbound Port Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Inbound Port Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibInboundPortUnit(WasSibInboundPortUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Inbound Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Inbound Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibInboundService(WasSibInboundService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Inbound Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Inbound Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibInboundServiceUnit(WasSibInboundServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Mediation</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Mediation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibMediation(WasSibMediation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Mediation Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Mediation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibMediationUnit(WasSibMediationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Outbound Port</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Outbound Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibOutboundPort(WasSibOutboundPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Outbound Port Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Outbound Port Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibOutboundPortUnit(WasSibOutboundPortUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Outbound Service</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Outbound Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibOutboundService(WasSibOutboundService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Outbound Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Outbound Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibOutboundServiceUnit(WasSibOutboundServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sib Service Integration Bus Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sib Service Integration Bus Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSibServiceIntegrationBusLink(WasSibServiceIntegrationBusLink object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>SI Bus</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>SI Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSIBus(WasSIBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI Bus Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI Bus Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSIBusUnit(WasSIBusUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substitution Variable</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substitution Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSubstitutionVariable(WasSubstitutionVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>System</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSystem(WasSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasSystemUnit(WasSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>V4 Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>V4 Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasV4Datasource(WasV4Datasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>V5 Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>V5 Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasV5Datasource(WasV5Datasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>V5DB2 Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>V5DB2 Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasV5DB2Datasource(WasV5DB2Datasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>V5DB2 Zos Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>V5DB2 Zos Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasV5DB2ZosDatasource(WasV5DB2ZosDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>War Classloader Policy Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>War Classloader Policy Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWarClassloaderPolicyConstraint(WasWarClassloaderPolicyConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web App Ext</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web App Ext</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWebAppExt(WasWebAppExt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWebServer(WasWebServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Server Management</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Server Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWebServerManagement(WasWebServerManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Server Plugin</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Server Plugin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWebServerPlugin(WasWebServerPlugin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Server Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWasWebServerUnit(WasWebServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Websphere App Server Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Websphere App Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWebsphereAppServerUnit(WebsphereAppServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jdbc Provider</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jdbc Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJdbcProvider(JdbcProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jdbc Provider Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jdbc Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJdbcProviderUnit(JdbcProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Datasource</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEDatasource(J2EEDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSConnectionFactory(JMSConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSConnectionFactoryUnit(JMSConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueConnectionFactory(JMSQueueConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSDestination(JMSDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueDestination(JMSQueueDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueDestinationUnit(JMSQueueDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicConnectionFactory(JMSTopicConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicDestination(JMSTopicDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicDestinationUnit(JMSTopicDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2C Authentication Data Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2C Authentication Data Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2CAuthenticationDataEntry(J2CAuthenticationDataEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2C Authentication Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2C Authentication Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2CAuthenticationUnit(J2CAuthenticationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSActivationSpecification(JMSActivationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSActivationSpecificationUnit(JMSActivationSpecificationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Windows Local Service Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Windows Local Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindowsLocalServiceUnit(WindowsLocalServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEServerUnit(J2EEServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>J2EE Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJ2EEServer(J2EEServer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //WasSwitch
