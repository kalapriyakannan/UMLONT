/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider;

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
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.Unit} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class UnitItemProvider extends DeployModelObjectItemProvider implements
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
	public UnitItemProvider(AdapterFactory adapterFactory) {
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

			addBuildVersionPropertyDescriptor(object);
			addConceptualPropertyDescriptor(object);
			addConfigurationUnitPropertyDescriptor(object);
			addGoalInstallStatePropertyDescriptor(object);
			addInitInstallStatePropertyDescriptor(object);
			addOriginPropertyDescriptor(object);
			addPublishIntentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Build Version feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addBuildVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_buildVersion_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_buildVersion_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__BUILD_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Conceptual feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addConceptualPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_conceptual_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_conceptual_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__CONCEPTUAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configuration Unit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigurationUnitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_configurationUnit_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_configurationUnit_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__CONFIGURATION_UNIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Goal Install State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGoalInstallStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_goalInstallState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_goalInstallState_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__GOAL_INSTALL_STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Init Install State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitInstallStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_initInstallState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_initInstallState_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__INIT_INSTALL_STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Origin feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addOriginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_origin_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_origin_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__ORIGIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publish Intent feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addPublishIntentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Unit_publishIntent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Unit_publishIntent_feature", "_UI_Unit_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.UNIT__PUBLISH_INTENT,
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
//			childrenFeatures.add(CorePackage.Literals.UNIT__CAPABILITY_GROUP);
//			childrenFeatures.add(CorePackage.Literals.UNIT__REQUIREMENT_GROUP);
//			childrenFeatures.add(CorePackage.Literals.UNIT__REQUIREMENTS);
//			childrenFeatures.add(CorePackage.Literals.UNIT__UNIT_LINKS_GROUP);
//			childrenFeatures.add(CorePackage.Literals.UNIT__LOGICAL_LINKS);
//			childrenFeatures.add(CorePackage.Literals.UNIT__ARTIFACT_GROUP);
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

	public Object getImage(Object object) {
//		if (object instanceof Unit)
//		{
//			Unit unit = (Unit) object;
//			if (unit.isConceptual())
//				return overlayImage(object, getResourceLocator().getImage("full/obj16/conceptual_node_16")); //$NON-NLS-1$
//		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Unit")); //$NON-NLS-1$
	}

	public String getText(Object object) {

		String label = ((Unit) object).getDisplayName();
		label = label == null || label.length() == 0 ? ((Unit) object).getName() : label;
		return label == null || label.length() == 0 ? getString("_UI_Unit_type") : //$NON-NLS-1$
				label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Unit.class)) {
			case CorePackage.UNIT__BUILD_VERSION:
			case CorePackage.UNIT__CONCEPTUAL:
			case CorePackage.UNIT__CONFIGURATION_UNIT:
			case CorePackage.UNIT__GOAL_INSTALL_STATE:
			case CorePackage.UNIT__INIT_INSTALL_STATE:
			case CorePackage.UNIT__ORIGIN:
			case CorePackage.UNIT__PUBLISH_INTENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.UNIT__CAPABILITY_GROUP:
			case CorePackage.UNIT__REQUIREMENT_GROUP:
			case CorePackage.UNIT__UNIT_LINKS_GROUP:
			case CorePackage.UNIT__CONSTRAINT_LINKS:
			case CorePackage.UNIT__REALIZATION_LINKS:
			case CorePackage.UNIT__STEREOTYPES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated NOT
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		/*
		 * newChildDescriptors.add (createChildParameter (CorePackage.Literals.UNIT__CONTAINS,
		 * CoreFactory.eINSTANCE.createUnit()));
		 */

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
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR ||
			childFeature == CorePackage.Literals.UNIT__CAPABILITIES ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE ||
			childFeature == CorePackage.Literals.UNIT__REQUIREMENTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE ||
			childFeature == CorePackage.Literals.UNIT__UNIT_LINKS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER;

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
		return DeployCoreEditPlugin.INSTANCE;
	}

}
