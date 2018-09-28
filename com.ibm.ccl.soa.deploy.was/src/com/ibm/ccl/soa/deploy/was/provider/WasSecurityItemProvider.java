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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.was.WasSecurity} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class WasSecurityItemProvider extends CapabilityItemProvider implements
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
	public WasSecurityItemProvider(AdapterFactory adapterFactory) {
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

			addActiveAuthMechanismPropertyDescriptor(object);
			addActiveProtocolPropertyDescriptor(object);
			addActiveUserRegistryPropertyDescriptor(object);
			addAllowAllPermissionForApplicationPropertyDescriptor(object);
			addCacheTimeoutPropertyDescriptor(object);
			addEnforceFineGrainedJCASecurityPropertyDescriptor(object);
			addEnforceJava2SecRuntimeFileteringPropertyDescriptor(object);
			addEnforceJava2SecurityPropertyDescriptor(object);
			addGlobalSecurityEnabledPropertyDescriptor(object);
			addIssuePermissionWarningPropertyDescriptor(object);
			addUseDomainQualifiedNamesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Active Auth Mechanism feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveAuthMechanismPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_activeAuthMechanism_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_activeAuthMechanism_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ACTIVE_AUTH_MECHANISM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Active Protocol feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addActiveProtocolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_activeProtocol_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_activeProtocol_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ACTIVE_PROTOCOL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Active User Registry feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveUserRegistryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_activeUserRegistry_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_activeUserRegistry_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ACTIVE_USER_REGISTRY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow All Permission For Application feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAllowAllPermissionForApplicationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_allowAllPermissionForApplication_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_allowAllPermissionForApplication_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cache Timeout feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCacheTimeoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_cacheTimeout_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_cacheTimeout_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__CACHE_TIMEOUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enforce Fine Grained JCA Security feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addEnforceFineGrainedJCASecurityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_enforceFineGrainedJCASecurity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_enforceFineGrainedJCASecurity_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enforce Java2 Sec Runtime Filetering feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addEnforceJava2SecRuntimeFileteringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_enforceJava2SecRuntimeFiletering_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_enforceJava2SecRuntimeFiletering_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enforce Java2 Security feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnforceJava2SecurityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_enforceJava2Security_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_enforceJava2Security_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ENFORCE_JAVA2_SECURITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Global Security Enabled feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGlobalSecurityEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_globalSecurityEnabled_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_globalSecurityEnabled_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__GLOBAL_SECURITY_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Issue Permission Warning feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIssuePermissionWarningPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_issuePermissionWarning_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_issuePermissionWarning_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__ISSUE_PERMISSION_WARNING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Domain Qualified Names feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addUseDomainQualifiedNamesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasSecurity_useDomainQualifiedNames_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasSecurity_useDomainQualifiedNames_feature", "_UI_WasSecurity_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns WasSecurity.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/WasSecurity")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WasSecurity)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_WasSecurity_type") : //$NON-NLS-1$
			getString("_UI_WasSecurity_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WasSecurity.class)) {
			case WasPackage.WAS_SECURITY__ACTIVE_AUTH_MECHANISM:
			case WasPackage.WAS_SECURITY__ACTIVE_PROTOCOL:
			case WasPackage.WAS_SECURITY__ACTIVE_USER_REGISTRY:
			case WasPackage.WAS_SECURITY__ALLOW_ALL_PERMISSION_FOR_APPLICATION:
			case WasPackage.WAS_SECURITY__CACHE_TIMEOUT:
			case WasPackage.WAS_SECURITY__ENFORCE_FINE_GRAINED_JCA_SECURITY:
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SEC_RUNTIME_FILETERING:
			case WasPackage.WAS_SECURITY__ENFORCE_JAVA2_SECURITY:
			case WasPackage.WAS_SECURITY__GLOBAL_SECURITY_ENABLED:
			case WasPackage.WAS_SECURITY__ISSUE_PERMISSION_WARNING:
			case WasPackage.WAS_SECURITY__USE_DOMAIN_QUALIFIED_NAMES:
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
