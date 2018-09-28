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
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpace;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DB2TableSpaceItemProvider
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
	public DB2TableSpaceItemProvider(AdapterFactory adapterFactory) {
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

			addAutoResizePropertyDescriptor(object);
			addDroppedTableRecoveryPropertyDescriptor(object);
			addEventSizePropertyDescriptor(object);
			addFilePropertyDescriptor(object);
			addIncreaseSizePropertyDescriptor(object);
			addManagedByPropertyDescriptor(object);
			addMaxSizePropertyDescriptor(object);
			addName1PropertyDescriptor(object);
			addOverheadPropertyDescriptor(object);
			addPageSizePropertyDescriptor(object);
			addPrefetchSizePropertyDescriptor(object);
			addTransferRatePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Auto Resize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoResizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_autoResize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_autoResize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__AUTO_RESIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dropped Table Recovery feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDroppedTableRecoveryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_droppedTableRecovery_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_droppedTableRecovery_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Event Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_eventSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_eventSize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__EVENT_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_file_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_file_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Increase Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncreaseSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_increaseSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_increaseSize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__INCREASE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Managed By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_managedBy_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_managedBy_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__MANAGED_BY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_maxSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_maxSize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__MAX_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_name1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_name1_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__NAME1,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Overhead feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverheadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_overhead_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_overhead_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__OVERHEAD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Page Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPageSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_pageSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_pageSize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__PAGE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prefetch Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrefetchSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_prefetchSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_prefetchSize_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__PREFETCH_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transfer Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransferRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_transferRate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_transferRate_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__TRANSFER_RATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DB2TableSpace_type_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DB2TableSpace_type_feature", "_UI_DB2TableSpace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 Db2highPackage.Literals.DB2_TABLE_SPACE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DB2TableSpace.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DB2TableSpace")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((DB2TableSpace)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DB2TableSpace_type") : //$NON-NLS-1$
			getString("_UI_DB2TableSpace_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(DB2TableSpace.class)) {
			case Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE:
			case Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY:
			case Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE:
			case Db2highPackage.DB2_TABLE_SPACE__FILE:
			case Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE:
			case Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY:
			case Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE:
			case Db2highPackage.DB2_TABLE_SPACE__NAME1:
			case Db2highPackage.DB2_TABLE_SPACE__OVERHEAD:
			case Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE:
			case Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE:
			case Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE:
			case Db2highPackage.DB2_TABLE_SPACE__TYPE:
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
