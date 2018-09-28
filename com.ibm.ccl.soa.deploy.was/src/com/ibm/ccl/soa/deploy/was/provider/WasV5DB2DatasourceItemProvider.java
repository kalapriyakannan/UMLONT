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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class WasV5DB2DatasourceItemProvider extends WasV5DatasourceItemProvider implements
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
	public WasV5DB2DatasourceItemProvider(AdapterFactory adapterFactory) {
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

			addCliSchemaPropertyDescriptor(object);
			addCurrentPackageSetPropertyDescriptor(object);
			addCurrentSchemaPropertyDescriptor(object);
			addDeferPreparesPropertyDescriptor(object);
			addFullyMaterializeLobDataPropertyDescriptor(object);
			addResultSetHoldabilityPropertyDescriptor(object);
			addTraceFilePropertyDescriptor(object);
			addTraceLevelPropertyDescriptor(object);
			addUseTemplatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cli Schema feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCliSchemaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_cliSchema_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_cliSchema_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__CLI_SCHEMA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Package Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentPackageSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_currentPackageSet_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_currentPackageSet_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Schema feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCurrentSchemaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_currentSchema_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_currentSchema_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Defer Prepares feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDeferPreparesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_deferPrepares_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_deferPrepares_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__DEFER_PREPARES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fully Materialize Lob Data feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFullyMaterializeLobDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_fullyMaterializeLobData_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_fullyMaterializeLobData_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Set Holdability feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultSetHoldabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_resultSetHoldability_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_resultSetHoldability_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace File feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTraceFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_traceFile_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_traceFile_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__TRACE_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace Level feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTraceLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_traceLevel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_traceLevel_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__TRACE_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Template feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUseTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasV5DB2Datasource_useTemplate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasV5DB2Datasource_useTemplate_feature", "_UI_WasV5DB2Datasource_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_V5DB2_DATASOURCE__USE_TEMPLATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns WasV5DB2Datasource.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/WasV5DB2Datasource")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WasV5DB2Datasource)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_WasV5DB2Datasource_type") : //$NON-NLS-1$
			getString("_UI_WasV5DB2Datasource_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WasV5DB2Datasource.class)) {
			case WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA:
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET:
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA:
			case WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES:
			case WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA:
			case WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY:
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE:
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL:
			case WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE:
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
		return WasEditPlugin.INSTANCE;
	}

}
