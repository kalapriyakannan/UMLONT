/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.DeployModelObject} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DeployModelObjectItemProvider extends ItemProviderAdapter implements
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
	public DeployModelObjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDescriptionPropertyDescriptor(object);
			addDisplayNamePropertyDescriptor(object);
			addMutablePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployModelObject_description_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployModelObject_description_feature", "_UI_DeployModelObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDisplayNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployModelObject_displayName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployModelObject_displayName_feature", "_UI_DeployModelObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mutable feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addMutablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployModelObject_mutable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployModelObject_mutable_feature", "_UI_DeployModelObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.DEPLOY_MODEL_OBJECT__MUTABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployModelObject_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployModelObject_name_feature", "_UI_DeployModelObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
	 * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// Commentted out for deployable navigator so as to show only units
			// as the smallest possible node under a topology.
			//
//			childrenFeatures.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ANNOTATIONS);
//			childrenFeatures.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA);
//			childrenFeatures.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES);
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
	 * This returns DeployModelObject.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DeployModelObject")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public String getText(Object object) {
		String label = ((DeployModelObject) object).getDisplayName();
		return label == null || label.length() == 0 ? getString("_UI_DeployModelObject_type") : //$NON-NLS-1$
				getString("_UI_DeployModelObject_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DeployModelObject.class)) {
			case CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION:
			case CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME:
			case CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE:
			case CorePackage.DEPLOY_MODEL_OBJECT__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
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
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ANNOTATIONS,
				 CoreFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA,
				 CoreFactory.eINSTANCE.createAttributeMetaData()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES,
				 CoreFactory.eINSTANCE.createExtendedAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS,
					 CoreFactory.eINSTANCE.createFileArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE,
					 CoreFactory.eINSTANCE.createFileArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS,
					 CoreFactory.eINSTANCE.createRequirementExpression())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR,
					 CoreFactory.eINSTANCE.createRequirementExpression())));
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
				DeployCoreEditPlugin.INSTANCE.log(e);
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
		return DeployCoreEditPlugin.INSTANCE;
	}

}
