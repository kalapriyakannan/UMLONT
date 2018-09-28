/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.provider.CapabilityItemProvider;
import com.ibm.ccl.soa.deploy.db2high.DB2Manager;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.db2high.DB2Manager} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DB2ManagerItemProvider
	extends CapabilityItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ManagerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAgentPoolSizePropertyDescriptor(object);
			addAgentPriorityPropertyDescriptor(object);
			addAgentStackSizePropertyDescriptor(object);
			addApplicationSupportLayerHeapSizePropertyDescriptor(object);
			addAuditBufferSizePropertyDescriptor(object);
			addAuthenticationTypePropertyDescriptor(object);
			addAuthenticationTypeForIncomingConnectionsPropertyDescriptor(object);
			addBypassFederatedAuthenticationPropertyDescriptor(object);
			addCatalogingAllowedWithoutAuthorityPropertyDescriptor(object);
			addClientIOBlockSizePropertyDescriptor(object);
			addClientKerberosPluginPropertyDescriptor(object);
			addClientUseridPasswordPluginPropertyDescriptor(object);
			addCommunicationsBandwidthPropertyDescriptor(object);
			addConfigurationFileReleaseLevelPropertyDescriptor(object);
			addConnectionElapseTimePropertyDescriptor(object);
			addCPUSpeedPropertyDescriptor(object);
			addDatabaseSystemMonitorHeapSizePropertyDescriptor(object);
			addDefaultChargeBackAccountPropertyDescriptor(object);
			addDefaultDatabasePathPropertyDescriptor(object);
			addDefaultDatabaseSystemMonitorSwitchesPropertyDescriptor(object);
			addDiagnosticDataDirectoryPathPropertyDescriptor(object);
			addDiagnosticErrorCaptureLevelPropertyDescriptor(object);
			addDirectoryCacheSupportPropertyDescriptor(object);
			addDiscoverServerInstancePropertyDescriptor(object);
			addDiscoveryModePropertyDescriptor(object);
			addEnablePntrapartitionParallelismPropertyDescriptor(object);
			addFederatedDatabaseSystemSupportPropertyDescriptor(object);
			addGroupPluginPropertyDescriptor(object);
			addHealthMonitoringPropertyDescriptor(object);
			addIndexRecreationTimePropertyDescriptor(object);
			addInitialNumberOfAgentsInPoolPropertyDescriptor(object);
			addInitialNumberOfFencedProcessesPropertyDescriptor(object);
			addInstanceImpactPolicyPropertyDescriptor(object);
			addInstanceMemoryPropertyDescriptor(object);
			addKeepFencedProcessPropertyDescriptor(object);
			addListOfGSSAPIPluginsForIncomingConnectionsPropertyDescriptor(object);
			addLocalGSSAPIPluginPropertyDescriptor(object);
			addMachineNodeTypePropertyDescriptor(object);
			addMaximumAsynchronousTQsPerQueryPropertyDescriptor(object);
			addMaximumJavaInterpreterHeapSizePropertyDescriptor(object);
			addMaximumNumberOfAgentsPropertyDescriptor(object);
			addMaximumNumberOfClientConnectionsPropertyDescriptor(object);
			addMaximumNumberOfConcurrentAgentsPropertyDescriptor(object);
			addMaximumNumberOfConcurrentlyActiveDatabasesPropertyDescriptor(object);
			addMaximumNumberOfCoordinatingAgentsPropertyDescriptor(object);
			addMaximumNumberOfFencedProcessesPropertyDescriptor(object);
			addMaximumQueryDegreeOfParallelismPropertyDescriptor(object);
			addMaximumTimeDifferenceAmongNodesPropertyDescriptor(object);
			addNodeConnectionRetriesPropertyDescriptor(object);
			addNotifyLevelPropertyDescriptor(object);
			addNumberOfFCMBuffersPropertyDescriptor(object);
			addNumberOfFCMChannelsPropertyDescriptor(object);
			addQueryHeapSizePropertyDescriptor(object);
			addServerPluginModePropertyDescriptor(object);
			addSoftwareDevelopersKitForJavaInstallationPathPropertyDescriptor(object);
			addSortHeapThresholdPropertyDescriptor(object);
			addStartAndStopTimeoutPropertyDescriptor(object);
			addSyncPointManagerLogFilePathPropertyDescriptor(object);
			addSyncPointManagerLogFileSizePropertyDescriptor(object);
			addSyncPointManagerNamePropertyDescriptor(object);
			addSyncPointManagerResyncAgentLimitPropertyDescriptor(object);
			addSystemAdministrationAuthorityGroupNamePropertyDescriptor(object);
			addSystemControlAuthorityGroupNamePropertyDescriptor(object);
			addSystemMaintenanceAuthorityGroupNamePropertyDescriptor(object);
			addSystemMonitorAuthorityGroupNamePropertyDescriptor(object);
			addTCPIPServiceNamePropertyDescriptor(object);
			addTransactionManagerDatabaseNamePropertyDescriptor(object);
			addTransactionProcessorMonitorNamePropertyDescriptor(object);
			addTransactionResyncIntervalPropertyDescriptor(object);
			addTrustAllClientsPropertyDescriptor(object);
			addTrustedClientsAuthenticationPropertyDescriptor(object);
			addUseridPasswordPlugInPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Agent Pool Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgentPoolSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_agentPoolSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_agentPoolSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AGENT_POOL_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Agent Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgentPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_agentPriority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_agentPriority_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AGENT_PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Agent Stack Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgentStackSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_agentStackSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_agentStackSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AGENT_STACK_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Application Support Layer Heap Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addApplicationSupportLayerHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_applicationSupportLayerHeapSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_applicationSupportLayerHeapSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Audit Buffer Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuditBufferSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_auditBufferSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_auditBufferSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AUDIT_BUFFER_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Authentication Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthenticationTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_authenticationType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_authenticationType_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AUTHENTICATION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Authentication Type For Incoming Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthenticationTypeForIncomingConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_authenticationTypeForIncomingConnections_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_authenticationTypeForIncomingConnections_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bypass Federated Authentication feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBypassFederatedAuthenticationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_bypassFederatedAuthentication_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_bypassFederatedAuthentication_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cataloging Allowed Without Authority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCatalogingAllowedWithoutAuthorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_catalogingAllowedWithoutAuthority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_catalogingAllowedWithoutAuthority_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client IO Block Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientIOBlockSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_clientIOBlockSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_clientIOBlockSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client Kerberos Plugin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientKerberosPluginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_clientKerberosPlugin_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_clientKerberosPlugin_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client Userid Password Plugin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientUseridPasswordPluginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_clientUseridPasswordPlugin_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_clientUseridPasswordPlugin_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Communications Bandwidth feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommunicationsBandwidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_communicationsBandwidth_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_communicationsBandwidth_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configuration File Release Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigurationFileReleaseLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_configurationFileReleaseLevel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_configurationFileReleaseLevel_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Elapse Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionElapseTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_connectionElapseTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_connectionElapseTime_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CONNECTION_ELAPSE_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the CPU Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCPUSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_cPUSpeed_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_cPUSpeed_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__CPU_SPEED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Database System Monitor Heap Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatabaseSystemMonitorHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_databaseSystemMonitorHeapSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_databaseSystemMonitorHeapSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Charge Back Account feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultChargeBackAccountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_defaultChargeBackAccount_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_defaultChargeBackAccount_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Database Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultDatabasePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_defaultDatabasePath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_defaultDatabasePath_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DEFAULT_DATABASE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Database System Monitor Switches feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultDatabaseSystemMonitorSwitchesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_defaultDatabaseSystemMonitorSwitches_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_defaultDatabaseSystemMonitorSwitches_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Diagnostic Data Directory Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiagnosticDataDirectoryPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_diagnosticDataDirectoryPath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_diagnosticDataDirectoryPath_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Diagnostic Error Capture Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiagnosticErrorCaptureLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_diagnosticErrorCaptureLevel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_diagnosticErrorCaptureLevel_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Directory Cache Support feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirectoryCacheSupportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_directoryCacheSupport_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_directoryCacheSupport_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Discover Server Instance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiscoverServerInstancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_discoverServerInstance_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_discoverServerInstance_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DISCOVER_SERVER_INSTANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Discovery Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiscoveryModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_discoveryMode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_discoveryMode_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__DISCOVERY_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Pntrapartition Parallelism feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnablePntrapartitionParallelismPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_enablePntrapartitionParallelism_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_enablePntrapartitionParallelism_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Federated Database System Support feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFederatedDatabaseSystemSupportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_federatedDatabaseSystemSupport_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_federatedDatabaseSystemSupport_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Group Plugin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupPluginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_groupPlugin_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_groupPlugin_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__GROUP_PLUGIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Health Monitoring feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHealthMonitoringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_healthMonitoring_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_healthMonitoring_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__HEALTH_MONITORING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Index Recreation Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexRecreationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_indexRecreationTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_indexRecreationTime_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__INDEX_RECREATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Number Of Agents In Pool feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialNumberOfAgentsInPoolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_initialNumberOfAgentsInPool_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_initialNumberOfAgentsInPool_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Number Of Fenced Processes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialNumberOfFencedProcessesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_initialNumberOfFencedProcesses_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_initialNumberOfFencedProcesses_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Instance Impact Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstanceImpactPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_instanceImpactPolicy_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_instanceImpactPolicy_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__INSTANCE_IMPACT_POLICY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Instance Memory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstanceMemoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_instanceMemory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_instanceMemory_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__INSTANCE_MEMORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Keep Fenced Process feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeepFencedProcessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_keepFencedProcess_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_keepFencedProcess_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__KEEP_FENCED_PROCESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the List Of GSSAPI Plugins For Incoming Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addListOfGSSAPIPluginsForIncomingConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_listOfGSSAPIPluginsForIncomingConnections_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_listOfGSSAPIPluginsForIncomingConnections_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Local GSSAPI Plugin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocalGSSAPIPluginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_localGSSAPIPlugin_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_localGSSAPIPlugin_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Machine Node Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMachineNodeTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_machineNodeType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_machineNodeType_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MACHINE_NODE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Asynchronous TQs Per Query feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumAsynchronousTQsPerQueryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumAsynchronousTQsPerQuery_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumAsynchronousTQsPerQuery_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Java Interpreter Heap Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumJavaInterpreterHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumJavaInterpreterHeapSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumJavaInterpreterHeapSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Agents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfAgentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfAgents_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfAgents_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Client Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfClientConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfClientConnections_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfClientConnections_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Concurrent Agents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfConcurrentAgentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfConcurrentAgents_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfConcurrentAgents_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Concurrently Active Databases feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfConcurrentlyActiveDatabasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfConcurrentlyActiveDatabases_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfConcurrentlyActiveDatabases_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Coordinating Agents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfCoordinatingAgentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfCoordinatingAgents_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfCoordinatingAgents_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Number Of Fenced Processes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumNumberOfFencedProcessesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumNumberOfFencedProcesses_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumNumberOfFencedProcesses_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Query Degree Of Parallelism feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumQueryDegreeOfParallelismPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumQueryDegreeOfParallelism_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumQueryDegreeOfParallelism_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Time Difference Among Nodes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumTimeDifferenceAmongNodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_maximumTimeDifferenceAmongNodes_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_maximumTimeDifferenceAmongNodes_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node Connection Retries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNodeConnectionRetriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_nodeConnectionRetries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_nodeConnectionRetries_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__NODE_CONNECTION_RETRIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Notify Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotifyLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_notifyLevel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_notifyLevel_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__NOTIFY_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of FCM Buffers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfFCMBuffersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_numberOfFCMBuffers_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_numberOfFCMBuffers_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of FCM Channels feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfFCMChannelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_numberOfFCMChannels_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_numberOfFCMChannels_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Query Heap Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueryHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_queryHeapSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_queryHeapSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__QUERY_HEAP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Server Plugin Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServerPluginModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_serverPluginMode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_serverPluginMode_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SERVER_PLUGIN_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Software Developers Kit For Java Installation Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSoftwareDevelopersKitForJavaInstallationPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_softwareDevelopersKitForJavaInstallationPath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_softwareDevelopersKitForJavaInstallationPath_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sort Heap Threshold feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSortHeapThresholdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_sortHeapThreshold_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_sortHeapThreshold_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SORT_HEAP_THRESHOLD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start And Stop Timeout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartAndStopTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_startAndStopTimeout_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_startAndStopTimeout_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__START_AND_STOP_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Point Manager Log File Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncPointManagerLogFilePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_syncPointManagerLogFilePath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_syncPointManagerLogFilePath_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Point Manager Log File Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncPointManagerLogFileSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_syncPointManagerLogFileSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_syncPointManagerLogFileSize_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Point Manager Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncPointManagerNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_syncPointManagerName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_syncPointManagerName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYNC_POINT_MANAGER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Point Manager Resync Agent Limit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncPointManagerResyncAgentLimitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_syncPointManagerResyncAgentLimit_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_syncPointManagerResyncAgentLimit_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System Administration Authority Group Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemAdministrationAuthorityGroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_systemAdministrationAuthorityGroupName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_systemAdministrationAuthorityGroupName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System Control Authority Group Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemControlAuthorityGroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_systemControlAuthorityGroupName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_systemControlAuthorityGroupName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System Maintenance Authority Group Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemMaintenanceAuthorityGroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_systemMaintenanceAuthorityGroupName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_systemMaintenanceAuthorityGroupName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System Monitor Authority Group Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemMonitorAuthorityGroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_systemMonitorAuthorityGroupName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_systemMonitorAuthorityGroupName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the TCPIP Service Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTCPIPServiceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_tCPIPServiceName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_tCPIPServiceName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TCPIP_SERVICE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transaction Manager Database Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransactionManagerDatabaseNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_transactionManagerDatabaseName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_transactionManagerDatabaseName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transaction Processor Monitor Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransactionProcessorMonitorNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_transactionProcessorMonitorName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_transactionProcessorMonitorName_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transaction Resync Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransactionResyncIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_transactionResyncInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_transactionResyncInterval_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trust All Clients feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTrustAllClientsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_trustAllClients_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_trustAllClients_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TRUST_ALL_CLIENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trusted Clients Authentication feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTrustedClientsAuthenticationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_trustedClientsAuthentication_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_trustedClientsAuthentication_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Userid Password Plug In feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseridPasswordPlugInPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Manager_useridPasswordPlugIn_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Manager_useridPasswordPlugIn_feature", "_UI_DB2Manager_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_MANAGER__USERID_PASSWORD_PLUG_IN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DB2Manager.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DB2Manager")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((DB2Manager)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DB2Manager_type") : //$NON-NLS-1$
			getString("_UI_DB2Manager_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DB2Manager.class)) {
			case Db2highPackage.DB2_MANAGER__AGENT_POOL_SIZE:
			case Db2highPackage.DB2_MANAGER__AGENT_PRIORITY:
			case Db2highPackage.DB2_MANAGER__AGENT_STACK_SIZE:
			case Db2highPackage.DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE:
			case Db2highPackage.DB2_MANAGER__AUDIT_BUFFER_SIZE:
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE:
			case Db2highPackage.DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS:
			case Db2highPackage.DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION:
			case Db2highPackage.DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY:
			case Db2highPackage.DB2_MANAGER__CLIENT_IO_BLOCK_SIZE:
			case Db2highPackage.DB2_MANAGER__CLIENT_KERBEROS_PLUGIN:
			case Db2highPackage.DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN:
			case Db2highPackage.DB2_MANAGER__COMMUNICATIONS_BANDWIDTH:
			case Db2highPackage.DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL:
			case Db2highPackage.DB2_MANAGER__CONNECTION_ELAPSE_TIME:
			case Db2highPackage.DB2_MANAGER__CPU_SPEED:
			case Db2highPackage.DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE:
			case Db2highPackage.DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT:
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_PATH:
			case Db2highPackage.DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES:
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH:
			case Db2highPackage.DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL:
			case Db2highPackage.DB2_MANAGER__DIRECTORY_CACHE_SUPPORT:
			case Db2highPackage.DB2_MANAGER__DISCOVER_SERVER_INSTANCE:
			case Db2highPackage.DB2_MANAGER__DISCOVERY_MODE:
			case Db2highPackage.DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM:
			case Db2highPackage.DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT:
			case Db2highPackage.DB2_MANAGER__GROUP_PLUGIN:
			case Db2highPackage.DB2_MANAGER__HEALTH_MONITORING:
			case Db2highPackage.DB2_MANAGER__INDEX_RECREATION_TIME:
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL:
			case Db2highPackage.DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES:
			case Db2highPackage.DB2_MANAGER__INSTANCE_IMPACT_POLICY:
			case Db2highPackage.DB2_MANAGER__INSTANCE_MEMORY:
			case Db2highPackage.DB2_MANAGER__KEEP_FENCED_PROCESS:
			case Db2highPackage.DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS:
			case Db2highPackage.DB2_MANAGER__LOCAL_GSSAPI_PLUGIN:
			case Db2highPackage.DB2_MANAGER__MACHINE_NODE_TYPE:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM:
			case Db2highPackage.DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES:
			case Db2highPackage.DB2_MANAGER__NODE_CONNECTION_RETRIES:
			case Db2highPackage.DB2_MANAGER__NOTIFY_LEVEL:
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_BUFFERS:
			case Db2highPackage.DB2_MANAGER__NUMBER_OF_FCM_CHANNELS:
			case Db2highPackage.DB2_MANAGER__QUERY_HEAP_SIZE:
			case Db2highPackage.DB2_MANAGER__SERVER_PLUGIN_MODE:
			case Db2highPackage.DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH:
			case Db2highPackage.DB2_MANAGER__SORT_HEAP_THRESHOLD:
			case Db2highPackage.DB2_MANAGER__START_AND_STOP_TIMEOUT:
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH:
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE:
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_NAME:
			case Db2highPackage.DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT:
			case Db2highPackage.DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME:
			case Db2highPackage.DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME:
			case Db2highPackage.DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME:
			case Db2highPackage.DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME:
			case Db2highPackage.DB2_MANAGER__TCPIP_SERVICE_NAME:
			case Db2highPackage.DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME:
			case Db2highPackage.DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME:
			case Db2highPackage.DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL:
			case Db2highPackage.DB2_MANAGER__TRUST_ALL_CLIENTS:
			case Db2highPackage.DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION:
			case Db2highPackage.DB2_MANAGER__USERID_PASSWORD_PLUG_IN:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Db2highEditPlugin.INSTANCE;
	}

}
