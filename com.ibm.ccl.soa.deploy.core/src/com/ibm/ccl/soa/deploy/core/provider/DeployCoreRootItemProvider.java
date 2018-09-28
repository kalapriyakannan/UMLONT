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
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Visibility;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DeployCoreRootItemProvider extends ItemProviderAdapter implements
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
	public DeployCoreRootItemProvider(AdapterFactory adapterFactory) {
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

			addVisibilityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Visibility feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeployCoreRoot_visibility_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DeployCoreRoot_visibility_feature", "_UI_DeployCoreRoot_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.DEPLOY_CORE_ROOT__VISIBILITY,
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
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__ANNOTATION);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CONSTRAINT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__IMPORT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__INTERFACE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__PROPERTY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__STEREOTYPE);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__TOPOLOGY);
			childrenFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE);
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
	 * This returns DeployCoreRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DeployCoreRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		Visibility labelValue = ((DeployCoreRoot)object).getVisibility();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_DeployCoreRoot_type") : //$NON-NLS-1$
			getString("_UI_DeployCoreRoot_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DeployCoreRoot.class)) {
			case CorePackage.DEPLOY_CORE_ROOT__VISIBILITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
			case CorePackage.DEPLOY_CORE_ROOT__CONSTRAINT:
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
			case CorePackage.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT:
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
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
				(CorePackage.Literals.DEPLOY_CORE_ROOT__ANNOTATION,
				 CoreFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT,
				 CoreFactory.eINSTANCE.createFileArtifact()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE,
				 CoreFactory.eINSTANCE.createFileArtifact()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT,
				 CoreFactory.eINSTANCE.createBaseComponentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT,
				 CoreFactory.eINSTANCE.createSoftwareComponent()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT,
				 CoreFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT,
				 CoreFactory.eINSTANCE.createBaseComponentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT,
				 CoreFactory.eINSTANCE.createConceptualNode()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT,
				 CoreFactory.eINSTANCE.createSoftwareComponent()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
				 CoreFactory.eINSTANCE.createCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
				 CoreFactory.eINSTANCE.createBundleCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
				 CoreFactory.eINSTANCE.createCommunicationCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY,
				 CoreFactory.eINSTANCE.createService()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE,
				 CoreFactory.eINSTANCE.createBundleCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION,
				 CoreFactory.eINSTANCE.createCommunicationCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY,
				 CoreFactory.eINSTANCE.createInstanceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT,
				 CoreFactory.eINSTANCE.createExplicitContract()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY,
				 CoreFactory.eINSTANCE.createExplicitContract()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__IMPORT,
				 CoreFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION,
				 CoreFactory.eINSTANCE.createInstantiation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT,
				 CoreFactory.eINSTANCE.createConstraintLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY,
				 CoreFactory.eINSTANCE.createDependencyLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createDeployLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createConstraintLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createDependencyLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createUnitLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createHostingLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createMemberLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY,
				 CoreFactory.eINSTANCE.createRealizationLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING,
				 CoreFactory.eINSTANCE.createHostingLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT,
				 CoreFactory.eINSTANCE.createUnitLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT,
				 CoreFactory.eINSTANCE.createHostingLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT,
				 CoreFactory.eINSTANCE.createMemberLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER,
				 CoreFactory.eINSTANCE.createMemberLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION,
				 CoreFactory.eINSTANCE.createRealizationLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__PROPERTY,
				 CoreFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE,
				 CoreFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT,
				 CoreFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT,
				 CoreFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR,
				 CoreFactory.eINSTANCE.createRequirementExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE,
				 CoreFactory.eINSTANCE.createService()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT,
				 CoreFactory.eINSTANCE.createSoftwareComponent()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__STEREOTYPE,
				 CoreFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__TOPOLOGY,
				 CoreFactory.eINSTANCE.createTopology()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE,
				 CoreFactory.eINSTANCE.createConceptualNode()));
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

		boolean qualify =
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT;

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
