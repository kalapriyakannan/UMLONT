/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation.provider;


import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DeployStyleItemProvider
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
	public DeployStyleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIsDuplicateCanvasViewPropertyDescriptor(object);
			addProxyHashCodePropertyDescriptor(object);
			addElementNamePropertyDescriptor(object);
			addElementCategoryPropertyDescriptor(object);
			addImportPropertyDescriptor(object);
			addSnapParentPropertyDescriptor(object);
			addSnapChildrenPropertyDescriptor(object);
			addFilteredSemanticElementsPropertyDescriptor(object);
			addFilteredDecorationsPropertyDescriptor(object);
			addSnapStylePropertyDescriptor(object);
			addCollapseWidthPropertyDescriptor(object);
			addCollapseHeightPropertyDescriptor(object);
			addExpandWidthPropertyDescriptor(object);
			addExpandHeightPropertyDescriptor(object);
			addContainedObjsPropertyDescriptor(object);
			addUncontainedObjsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Duplicate Canvas View feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDuplicateCanvasViewPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_isDuplicateCanvasView_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_isDuplicateCanvasView_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Proxy Hash Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProxyHashCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_proxyHashCode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_proxyHashCode_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__PROXY_HASH_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Element Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_elementName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_elementName_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Element Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_elementCategory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_elementCategory_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__ELEMENT_CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Import feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_import_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_import_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__IMPORT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snap Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSnapParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_snapParent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_snapParent_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__SNAP_PARENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snap Children feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSnapChildrenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_snapChildren_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_snapChildren_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__SNAP_CHILDREN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Filtered Semantic Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFilteredSemanticElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_filteredSemanticElements_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_filteredSemanticElements_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Filtered Decorations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFilteredDecorationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_filteredDecorations_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_filteredDecorations_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__FILTERED_DECORATIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snap Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSnapStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_snapStyle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_snapStyle_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__SNAP_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Collapse Width feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCollapseWidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_collapseWidth_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_collapseWidth_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__COLLAPSE_WIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Collapse Height feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCollapseHeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_collapseHeight_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_collapseHeight_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__COLLAPSE_HEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expand Width feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpandWidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_expandWidth_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_expandWidth_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__EXPAND_WIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expand Height feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpandHeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_expandHeight_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_expandHeight_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__EXPAND_HEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Contained Objs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedObjsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_containedObjs_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_containedObjs_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__CONTAINED_OBJS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uncontained Objs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUncontainedObjsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployStyle_uncontainedObjs_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployStyle_uncontainedObjs_feature", "_UI_DeployStyle_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 DeployNotationPackage.Literals.DEPLOY_STYLE__UNCONTAINED_OBJS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns DeployStyle.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DeployStyle")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DeployStyle)object).getElementName();
		return label == null || label.length() == 0 ?
			getString("_UI_DeployStyle_type") : //$NON-NLS-1$
			getString("_UI_DeployStyle_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DeployStyle.class)) {
			case DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW:
			case DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE:
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME:
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY:
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS:
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE:
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH:
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT:
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH:
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT:
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
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DeployNotationEditPlugin.INSTANCE;
	}

}
