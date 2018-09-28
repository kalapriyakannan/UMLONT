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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.db2high.DB2HighRoot;
import com.ibm.ccl.soa.deploy.db2high.Db2highFactory;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DB2HighRootItemProvider
	extends ItemProviderAdapter
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
	public DB2HighRootItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER);
			childrenFeatures.add(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DB2HighRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DB2HighRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_DB2HighRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(DB2HighRoot.class)) {
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL,
				 Db2highFactory.eINSTANCE.createDB2BufferPool()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP,
				 Db2highFactory.eINSTANCE.createDB2PartitionGroup()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE,
				 Db2highFactory.eINSTANCE.createDB2TableSpace()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER,
				 Db2highFactory.eINSTANCE.createDB2Manager()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT,
				 Db2highFactory.eINSTANCE.createDB2BufferPoolUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT,
				 Db2highFactory.eINSTANCE.createDB2Constraint()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT,
				 Db2highFactory.eINSTANCE.createDB2ConstraintUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD,
				 Db2highFactory.eINSTANCE.createDB2Field()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT,
				 Db2highFactory.eINSTANCE.createDB2FieldUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX,
				 Db2highFactory.eINSTANCE.createDB2Index()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT,
				 Db2highFactory.eINSTANCE.createDB2IndexUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT,
				 Db2highFactory.eINSTANCE.createDB2ManagerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT,
				 Db2highFactory.eINSTANCE.createDB2PartitionGroupUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION,
				 Db2highFactory.eINSTANCE.createDB2Permission()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT,
				 Db2highFactory.eINSTANCE.createDB2PermissionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE,
				 Db2highFactory.eINSTANCE.createDB2Table()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT,
				 Db2highFactory.eINSTANCE.createDB2TableSpaceUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT,
				 Db2highFactory.eINSTANCE.createDB2TableUnit()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER,
				 Db2highFactory.eINSTANCE.createDB2User()));

		newChildDescriptors.add
			(createChildParameter
				(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT,
				 Db2highFactory.eINSTANCE.createDB2UserUnit()));
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
