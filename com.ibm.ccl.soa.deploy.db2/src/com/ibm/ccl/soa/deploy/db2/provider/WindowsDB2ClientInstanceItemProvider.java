/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.provider;

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
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance;

/**
 * This is the item provider adapter for a
 * {@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class WindowsDB2ClientInstanceItemProvider extends DB2ClientInstanceItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public WindowsDB2ClientInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDefaultInstancePropertyDescriptor(object);
			addInstanceTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Default Instance feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDefaultInstancePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsDB2ClientInstance_defaultInstance_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsDB2ClientInstance_defaultInstance_feature", "_UI_WindowsDB2ClientInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						Db2Package.Literals.WINDOWS_DB2_CLIENT_INSTANCE__DEFAULT_INSTANCE, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Instance Type feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInstanceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsDB2ClientInstance_instanceType_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsDB2ClientInstance_instanceType_feature", "_UI_WindowsDB2ClientInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						Db2Package.Literals.WINDOWS_DB2_CLIENT_INSTANCE__INSTANCE_TYPE, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns WindowsDB2ClientInstance.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/WindowsDB2ClientInstance")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WindowsDB2ClientInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_WindowsDB2ClientInstance_type") : //$NON-NLS-1$
				getString("_UI_WindowsDB2ClientInstance_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WindowsDB2ClientInstance.class))
		{
		case Db2Package.WINDOWS_DB2_CLIENT_INSTANCE__DEFAULT_INSTANCE:
		case Db2Package.WINDOWS_DB2_CLIENT_INSTANCE__INSTANCE_TYPE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
	 * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Db2DomainEditPlugin.INSTANCE;
	}

}
