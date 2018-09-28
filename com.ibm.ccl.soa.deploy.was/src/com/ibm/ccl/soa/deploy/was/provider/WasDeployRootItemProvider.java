/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.was.WasDeployRoot;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.was.WasDeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class WasDeployRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public WasDeployRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
	 * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT);
			childrenFeatures.add(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns WasDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/WasDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_WasDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WasDeployRoot.class)) {
			case WasPackage.WAS_DEPLOY_ROOT__MIXED:
			case WasPackage.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT:
			case WasPackage.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER,
					 WasFactory.eINSTANCE.createDB2JdbcProvider())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER,
					 WasFactory.eINSTANCE.createDerbyJdbcProvider())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER,
					 WasFactory.eINSTANCE.createExtendedJdbcProvider())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER,
					 WasFactory.eINSTANCE.createDB2JdbcProvider())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER,
					 WasFactory.eINSTANCE.createDerbyJdbcProvider())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ADVANCED_LDAP_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasAdvancedLdapConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasApplicationClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_EXT,
					 WasFactory.eINSTANCE.createWasApplicationExt())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasApplicationServerClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CELL,
					 WasFactory.eINSTANCE.createWasCell())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasApplicationClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasApplicationServerClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasModuleClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER,
					 WasFactory.eINSTANCE.createWasCluster())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CONFIGURATION_CONTAINER,
					 WasFactory.eINSTANCE.createWasConfigurationContainer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasDatasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV4Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2ZosDatasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasDefaultMessagingConnectionFactoryConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasDefaultMessagingQueueConnectionFactoryConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION,
					 WasFactory.eINSTANCE.createWasDefaultMessagingQueueDestination())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasDefaultMessagingTopicConnectionFactoryConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION,
					 WasFactory.eINSTANCE.createWasDefaultMessagingTopicDestination())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DEPLOYMENT_MANAGER,
					 WasFactory.eINSTANCE.createWasDeploymentManager())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_ENDPOINT_LISTENER_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasEndpointListenerConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_HANDLER_LIST,
					 WasFactory.eINSTANCE.createWasHandlerList())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2C_AUTH,
					 WasFactory.eINSTANCE.createWASJ2CAuthenticationDataEntry())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER,
					 WasFactory.eINSTANCE.createWasJ2EEServer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER,
					 WasFactory.eINSTANCE.createWasCluster())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER,
					 WasFactory.eINSTANCE.createWasServer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_JMS_ACTIVATION_SPECIFICATION,
					 WasFactory.eINSTANCE.createWasJMSActivationSpecification())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_LDAP_CONFIGURATION,
					 WasFactory.eINSTANCE.createWasLdapConfiguration())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE,
					 WasFactory.eINSTANCE.createWasMessagingEngine())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY,
					 WasFactory.eINSTANCE.createWasModuleClassLoaderPolicy())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE,
					 WasFactory.eINSTANCE.createWasNode())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_NODE_GROUP,
					 WasFactory.eINSTANCE.createWasNodeGroup())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_ADMIN,
					 WasFactory.eINSTANCE.createWasPluginAdmin())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_PLUGIN_REDIRECTION,
					 WasFactory.eINSTANCE.createWasPluginRedirection())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY,
					 WasFactory.eINSTANCE.createWasSecurity())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SECURITY_SUBJECT,
					 WasFactory.eINSTANCE.createWasSecuritySubject())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER,
					 WasFactory.eINSTANCE.createWasServer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIB_CONTAINER,
					 WasFactory.eINSTANCE.createWasSharedLibContainer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SHARED_LIBRARY,
					 WasFactory.eINSTANCE.createSharedLibraryEntry())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_DESTINATION,
					 WasFactory.eINSTANCE.createWasSibDestination())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_FOREIGN_BUS,
					 WasFactory.eINSTANCE.createWasSibForeignBus())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_PORT,
					 WasFactory.eINSTANCE.createWasSibInboundPort())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_INBOUND_SERVICE,
					 WasFactory.eINSTANCE.createWasSibInboundService())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_MEDIATION,
					 WasFactory.eINSTANCE.createWasSibMediation())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_PORT,
					 WasFactory.eINSTANCE.createWasSibOutboundPort())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_OUTBOUND_SERVICE,
					 WasFactory.eINSTANCE.createWasSibOutboundService())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SIB_SERVICE_INTEGRATION_BUS_LINK,
					 WasFactory.eINSTANCE.createWasSibServiceIntegrationBusLink())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SI_BUS,
					 WasFactory.eINSTANCE.createWasSIBus())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SUBSTITUTION_VARIABLE,
					 WasFactory.eINSTANCE.createWasSubstitutionVariable())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SYSTEM,
					 WasFactory.eINSTANCE.createWasSystem())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE,
					 WasFactory.eINSTANCE.createWasV4Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2ZosDatasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2Datasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE,
					 WasFactory.eINSTANCE.createWasV5DB2ZosDatasource())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_VIRTUAL_HOST,
					 WasFactory.eINSTANCE.createVirtualHostType())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_APP_EXT,
					 WasFactory.eINSTANCE.createWasWebAppExt())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER,
					 WasFactory.eINSTANCE.createWasWebServer())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_MANAGEMENT,
					 WasFactory.eINSTANCE.createWasWebServerManagement())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_WEB_SERVER_PLUGIN,
					 WasFactory.eINSTANCE.createWasWebServerPlugin())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CLASSLOADER,
					 WasFactory.eINSTANCE.createClassloader())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasJ2EEConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasModuleClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasJNDIBindingConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasModuleStartWeightConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasSecuritySubjectConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasJNDIBindingConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasModuleClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasModuleStartWeightConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasSecuritySubjectConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT,
					 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__HOST_NAME_ALIAS,
					 WasFactory.eINSTANCE.createHostNameAliasType())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT,
					 WasFactory.eINSTANCE.createDB2JdbcProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT,
					 WasFactory.eINSTANCE.createDerbyJdbcProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT,
					 WasFactory.eINSTANCE.createExtendedJdbcProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT,
					 WasFactory.eINSTANCE.createDB2JdbcProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT,
					 WasFactory.eINSTANCE.createDerbyJdbcProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_APP_SERVER,
					 WasFactory.eINSTANCE.createWebsphereAppServerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CELL_UNIT,
					 WasFactory.eINSTANCE.createWasCellUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLASS_LOADER_CONFIGURATION_UNIT,
					 WasFactory.eINSTANCE.createWasClassLoaderConfigurationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_CLUSTER_UNIT,
					 WasFactory.eINSTANCE.createWasClusterUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WASDATASOURCE,
					 WasFactory.eINSTANCE.createWasDatasourceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT,
					 WasFactory.eINSTANCE.createWasDefaultMessagingConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT,
					 WasFactory.eINSTANCE.createWasDefaultMessagingQueueConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT,
					 WasFactory.eINSTANCE.createWasDefaultMessagingQueueDestinationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT,
					 WasFactory.eINSTANCE.createWasDefaultMessagingTopicConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT,
					 WasFactory.eINSTANCE.createWasDefaultMessagingTopicDestinationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_DEPLOYMENT_MANAGER_UNIT,
					 WasFactory.eINSTANCE.createWasDeploymentManagerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_ENDPOINT_LISTENER_UNIT,
					 WasFactory.eINSTANCE.createWasEndpointListenerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_J2C_AUTH,
					 WasFactory.eINSTANCE.createWASJ2CAuthenticationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_JMS_ACTIVATION_SPECIFICATION_UNIT,
					 WasFactory.eINSTANCE.createWasJMSActivationSpecificationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_LDAP_CONFIGURATION_UNIT,
					 WasFactory.eINSTANCE.createWasLdapConfigurationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE,
					 WasFactory.eINSTANCE.createWasMessagingEngineUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_GROUP_UNIT,
					 WasFactory.eINSTANCE.createWasNodeGroupUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_UNIT,
					 WasFactory.eINSTANCE.createWasNodeUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_NODE_WINDOWS_SERVICE_UNIT,
					 WasFactory.eINSTANCE.createWasNodeWindowsServiceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SHARED_LIBRARY_ENTRY_UNIT,
					 WasFactory.eINSTANCE.createWasSharedLibraryEntryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_DESTINATION_UNIT,
					 WasFactory.eINSTANCE.createWasSibDestinationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_PORT_UNIT,
					 WasFactory.eINSTANCE.createWasSibInboundPortUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_INBOUND_SERVICE_UNIT,
					 WasFactory.eINSTANCE.createWasSibInboundServiceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_MEDIATION_UNIT,
					 WasFactory.eINSTANCE.createWasSibMediationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_PORT_UNIT,
					 WasFactory.eINSTANCE.createWasSibOutboundPortUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SIB_OUTBOUND_SERVICE_UNIT,
					 WasFactory.eINSTANCE.createWasSibOutboundServiceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SI_BUS_UNIT,
					 WasFactory.eINSTANCE.createWasSIBusUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_SYSTEM_UNIT,
					 WasFactory.eINSTANCE.createWasSystemUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_WEB_SERVER_UNIT,
					 WasFactory.eINSTANCE.createWasWebServerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE,
				 WasFactory.eINSTANCE.createWasMessagingEngine()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasJ2EEConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasModuleClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasJNDIBindingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasModuleStartWeightConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasSecuritySubjectConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasJNDIBindingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasModuleClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasModuleStartWeightConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasSecuritySubjectConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT,
				 WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE,
				 WasFactory.eINSTANCE.createWasMessagingEngineUnit()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_PROVIDER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_EXTENDED_JDBC_PROVIDER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_DERBY_JDBC_PROVIDER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_CLASS_LOADER_POLICY ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLASS_LOADER_POLICY ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_APPLICATION_SERVER_CLASS_LOADER_POLICY ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MODULE_CLASS_LOADER_POLICY ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_CLUSTER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_J2EE_SERVER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_DATASOURCE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV4DATASOURCE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5DATASOURCE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_DATASOURCE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WASV5_DB2_ZOS_DATASOURCE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_SERVER ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CAPABILITY_WAS_MESSAGING_ENGINE ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_J2EE_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_CLASSLOADER_POLICY_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_JNDI_BINDING_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_MODULE_START_WEIGHT_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__CONSTRAINT_WAS_SECURITY_SUBJECT_CONSTRAINT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DB2_JDBC_PROVIDER_UNIT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_EXTENDED_JDBC_PROVIDER_UNIT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_DERBY_JDBC_PROVIDER_UNIT ||
			childFeature == WasPackage.Literals.WAS_DEPLOY_ROOT__UNIT_WAS_MESSAGING_ENGINE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getCreateChildImage(Object owner, Object feature, Object child,
			Collection selection) {
		if (feature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();        
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject)child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			}
			catch (Exception e) {
				WasEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return WasEditPlugin.INSTANCE;
	}

}
