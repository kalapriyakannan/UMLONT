/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
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
import com.ibm.ccl.soa.deploy.database.provider.DatabaseItemProvider;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.db2.DB2Database} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DB2DatabaseItemProvider extends DatabaseItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DB2DatabaseItemProvider(AdapterFactory adapterFactory) {
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

			addCatalogSpPropertyDescriptor(object);
			addCodeSetPropertyDescriptor(object);
			addCreatePathPropertyDescriptor(object);
			addDb2VersionPropertyDescriptor(object);
			addDbAliasPropertyDescriptor(object);
			addDbDrivePropertyDescriptor(object);
			addDbNamePropertyDescriptor(object);
			addDftExtentSizePropertyDescriptor(object);
			addPageSizePropertyDescriptor(object);
			addTempSpPropertyDescriptor(object);
			addTerritoryPropertyDescriptor(object);
			addUserSpPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Catalog Sp feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCatalogSpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_catalogSp_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_catalogSp_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__CATALOG_SP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Code Set feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCodeSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_codeSet_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_codeSet_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__CODE_SET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Create Path feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCreatePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_createPath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_createPath_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__CREATE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Db2 Version feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDb2VersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_db2Version_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_db2Version_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__DB2_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Db Alias feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDbAliasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_dbAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_dbAlias_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__DB_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Db Drive feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDbDrivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_dbDrive_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_dbDrive_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__DB_DRIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Db Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDbNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_dbName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_dbName_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__DB_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dft Extent Size feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDftExtentSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_dftExtentSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_dftExtentSize_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__DFT_EXTENT_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Page Size feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addPageSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_pageSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_pageSize_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__PAGE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temp Sp feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTempSpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_tempSp_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_tempSp_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__TEMP_SP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Territory feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTerritoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_territory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_territory_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__TERRITORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User Sp feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUserSpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2Database_userSp_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2Database_userSp_feature", "_UI_DB2Database_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2Package.Literals.DB2_DATABASE__USER_SP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DB2Database.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DB2Database")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((DB2Database)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DB2Database_type") : //$NON-NLS-1$
			getString("_UI_DB2Database_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DB2Database.class)) {
			case Db2Package.DB2_DATABASE__CATALOG_SP:
			case Db2Package.DB2_DATABASE__CODE_SET:
			case Db2Package.DB2_DATABASE__CREATE_PATH:
			case Db2Package.DB2_DATABASE__DB2_VERSION:
			case Db2Package.DB2_DATABASE__DB_ALIAS:
			case Db2Package.DB2_DATABASE__DB_DRIVE:
			case Db2Package.DB2_DATABASE__DB_NAME:
			case Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE:
			case Db2Package.DB2_DATABASE__PAGE_SIZE:
			case Db2Package.DB2_DATABASE__TEMP_SP:
			case Db2Package.DB2_DATABASE__TERRITORY:
			case Db2Package.DB2_DATABASE__USER_SP:
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Db2DomainEditPlugin.INSTANCE;
	}

}
