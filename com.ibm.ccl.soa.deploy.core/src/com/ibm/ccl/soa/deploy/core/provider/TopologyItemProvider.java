/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider;

import java.util.ArrayList;
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

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.Topology} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TopologyItemProvider extends DeployModelObjectItemProvider implements
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
	public TopologyItemProvider(AdapterFactory adapterFactory) {
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

			addDecoratorSemanticPropertyDescriptor(object);
			addMutabilityConfigurablePropertyDescriptor(object);
			addNamespacePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Decorator Semantic feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDecoratorSemanticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Topology_decoratorSemantic_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Topology_decoratorSemantic_feature", "_UI_Topology_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.TOPOLOGY__DECORATOR_SEMANTIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mutability Configurable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMutabilityConfigurablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Topology_mutabilityConfigurable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Topology_mutabilityConfigurable_feature", "_UI_Topology_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.TOPOLOGY__MUTABILITY_CONFIGURABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Namespace feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Topology_namespace_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Topology_namespace_feature", "_UI_Topology_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.TOPOLOGY__NAMESPACE,
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
//			childrenFeatures.add(CorePackage.Literals.TOPOLOGY__UNIT_GROUP);
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
	 * This returns Topology.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Topology")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. Removed the getName, changed to display
	 * name <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getText(Object object) {
		String label = ((Topology) object).getDisplayName();
		return label == null || label.length() == 0 ? getString("_UI_Topology_type") : //$NON-NLS-1$
				getString("_UI_Topology_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Topology.class)) {
			case CorePackage.TOPOLOGY__DECORATOR_SEMANTIC:
			case CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE:
			case CorePackage.TOPOLOGY__NAMESPACE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.TOPOLOGY__UNIT_GROUP:
			case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			case CorePackage.TOPOLOGY__IMPORTS:
			case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
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
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNITS,
					 CoreFactory.eINSTANCE.createUnit())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNITS,
					 CoreFactory.eINSTANCE.createBaseComponentUnit())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNITS,
					 CoreFactory.eINSTANCE.createConceptualNode())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNITS,
					 CoreFactory.eINSTANCE.createSoftwareComponent())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT,
					 CoreFactory.eINSTANCE.createBaseComponentUnit())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT,
					 CoreFactory.eINSTANCE.createSoftwareComponent())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT,
					 CoreFactory.eINSTANCE.createSoftwareComponent())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE,
					 CoreFactory.eINSTANCE.createConceptualNode())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNIT_LINKS,
					 CoreFactory.eINSTANCE.createUnitLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNIT_LINKS,
					 CoreFactory.eINSTANCE.createHostingLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__UNIT_LINKS,
					 CoreFactory.eINSTANCE.createMemberLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING,
					 CoreFactory.eINSTANCE.createHostingLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER,
					 CoreFactory.eINSTANCE.createMemberLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__CONSTRAINT_LINKS,
				 CoreFactory.eINSTANCE.createConstraintLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__DEPENDENCY_LINK_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__DEPENDENCY_LINKS,
					 CoreFactory.eINSTANCE.createDependencyLink())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__REALIZATION_LINKS,
				 CoreFactory.eINSTANCE.createRealizationLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__IMPORTS,
				 CoreFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT,
					 CoreFactory.eINSTANCE.createExplicitContract())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT,
					 CoreFactory.eINSTANCE.createExplicitContract())));
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
			childFeature == CorePackage.Literals.TOPOLOGY__UNITS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT ||
			childFeature == CorePackage.Literals.TOPOLOGY__UNIT_LINKS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER ||
			childFeature == CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT;

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

	/**
	 * Force the Deployment Navigator to have Units and Imports as the children of Topologies.
	 * 
	 * @generated NOT
	 */
	public Collection getChildren(Object object) {
		Topology top = (Topology) object;
		List children = new ArrayList(); //Collection containing imports and units
		children.addAll(top.getImports());
		children.addAll(top.getUnits());

		return children;
	}

}
