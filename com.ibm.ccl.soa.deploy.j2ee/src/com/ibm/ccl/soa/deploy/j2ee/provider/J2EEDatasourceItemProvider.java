/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.provider;

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
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class J2EEDatasourceItemProvider extends CapabilityItemProvider implements
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
	public J2EEDatasourceItemProvider(AdapterFactory adapterFactory) {
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

			addDatasourceNamePropertyDescriptor(object);
			addDbNamePropertyDescriptor(object);
			addHostnamePropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addPortPropertyDescriptor(object);
			addUsedForCmpPropertyDescriptor(object);
			addUsernamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Datasource Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDatasourceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_datasourceName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_datasourceName_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__DATASOURCE_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Db Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDbNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_dbName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_dbName_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hostname feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addHostnamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_hostname_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_hostname_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__HOSTNAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Jndi Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addJndiNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_jndiName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_jndiName_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_password_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_password_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__PASSWORD, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Port feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_port_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_port_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__PORT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Used For Cmp feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUsedForCmpPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_usedForCmp_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_usedForCmp_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Username feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUsernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_J2EEDatasource_username_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_J2EEDatasource_username_feature", "_UI_J2EEDatasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						J2eePackage.Literals.J2EE_DATASOURCE__USERNAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns J2EEDatasource.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		//		return overlayImage(object, getResourceLocator().getImage("full/obj16/J2EEDatasource")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public String getText(Object object) {
		String label = ((J2EEDatasource) object).getDisplayName();
		label = label == null || label.length() == 0 ? ((J2EEDatasource) object).getName() : label;
		return label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(J2EEDatasource.class))
		{
		case J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME:
		case J2eePackage.J2EE_DATASOURCE__DB_NAME:
		case J2eePackage.J2EE_DATASOURCE__HOSTNAME:
		case J2eePackage.J2EE_DATASOURCE__JNDI_NAME:
		case J2eePackage.J2EE_DATASOURCE__PASSWORD:
		case J2eePackage.J2EE_DATASOURCE__PORT:
		case J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP:
		case J2eePackage.J2EE_DATASOURCE__USERNAME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
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

		if (childFeature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE
				|| childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
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
		if (feature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject) child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			} catch (Exception e) {
				J2eeEditPlugin.INSTANCE.log(e);
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
		return J2eeEditPlugin.INSTANCE;
	}

}
