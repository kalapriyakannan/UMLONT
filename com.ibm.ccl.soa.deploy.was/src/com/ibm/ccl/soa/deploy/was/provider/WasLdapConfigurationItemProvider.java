/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
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
import com.ibm.ccl.soa.deploy.was.WasLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.was.WasLdapConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class WasLdapConfigurationItemProvider extends CapabilityItemProvider implements
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
	public WasLdapConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addBaseDNPropertyDescriptor(object);
			addBindDNPropertyDescriptor(object);
			addBindPasswordPropertyDescriptor(object);
			addIgnoreCasePropertyDescriptor(object);
			addLdapHostnamePropertyDescriptor(object);
			addLdapPortPropertyDescriptor(object);
			addLimitPropertyDescriptor(object);
			addMonitorIntervalPropertyDescriptor(object);
			addRealmPropertyDescriptor(object);
			addReuseConnectionPropertyDescriptor(object);
			addSearchTimeoutPropertyDescriptor(object);
			addServerIdPropertyDescriptor(object);
			addServerPasswordPropertyDescriptor(object);
			addSslConfigPropertyDescriptor(object);
			addSslEnabledPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base DN feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addBaseDNPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_baseDN_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_baseDN_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__BASE_DN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bind DN feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addBindDNPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_bindDN_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_bindDN_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__BIND_DN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bind Password feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addBindPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_bindPassword_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_bindPassword_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__BIND_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ignore Case feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addIgnoreCasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_ignoreCase_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_ignoreCase_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__IGNORE_CASE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ldap Hostname feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLdapHostnamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_ldapHostname_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_ldapHostname_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ldap Port feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLdapPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_ldapPort_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_ldapPort_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__LDAP_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Limit feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLimitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_limit_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_limit_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__LIMIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Monitor Interval feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addMonitorIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_monitorInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_monitorInterval_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Realm feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addRealmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_realm_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_realm_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__REALM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reuse Connection feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addReuseConnectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_reuseConnection_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_reuseConnection_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Search Timeout feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSearchTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_searchTimeout_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_searchTimeout_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Server Id feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addServerIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_serverId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_serverId_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__SERVER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Server Password feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addServerPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_serverPassword_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_serverPassword_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ssl Config feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSslConfigPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_sslConfig_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_sslConfig_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__SSL_CONFIG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ssl Enabled feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSslEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_sslEnabled_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_sslEnabled_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__SSL_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasLdapConfiguration_type_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasLdapConfiguration_type_feature", "_UI_WasLdapConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_LDAP_CONFIGURATION__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns WasLdapConfiguration.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/WasLdapConfiguration")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WasLdapConfiguration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_WasLdapConfiguration_type") : //$NON-NLS-1$
			getString("_UI_WasLdapConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WasLdapConfiguration.class)) {
			case WasPackage.WAS_LDAP_CONFIGURATION__BASE_DN:
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_DN:
			case WasPackage.WAS_LDAP_CONFIGURATION__BIND_PASSWORD:
			case WasPackage.WAS_LDAP_CONFIGURATION__IGNORE_CASE:
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_HOSTNAME:
			case WasPackage.WAS_LDAP_CONFIGURATION__LDAP_PORT:
			case WasPackage.WAS_LDAP_CONFIGURATION__LIMIT:
			case WasPackage.WAS_LDAP_CONFIGURATION__MONITOR_INTERVAL:
			case WasPackage.WAS_LDAP_CONFIGURATION__REALM:
			case WasPackage.WAS_LDAP_CONFIGURATION__REUSE_CONNECTION:
			case WasPackage.WAS_LDAP_CONFIGURATION__SEARCH_TIMEOUT:
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_ID:
			case WasPackage.WAS_LDAP_CONFIGURATION__SERVER_PASSWORD:
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_CONFIG:
			case WasPackage.WAS_LDAP_CONFIGURATION__SSL_ENABLED:
			case WasPackage.WAS_LDAP_CONFIGURATION__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
