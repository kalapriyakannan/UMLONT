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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
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
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ExtendedAttributeItemProvider extends ItemProviderAdapter implements
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
	public ExtendedAttributeItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_ExtendedAttribute_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtendedAttribute_name_feature", "_UI_ExtendedAttribute_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.EXTENDED_ATTRIBUTE__NAME,
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
			childrenFeatures.add(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA);
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
	 * This returns ExtendedAttribute.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExtendedAttribute")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((ExtendedAttribute)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExtendedAttribute_type") : //$NON-NLS-1$
			getString("_UI_ExtendedAttribute_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ExtendedAttribute.class)) {
			case CorePackage.EXTENDED_ATTRIBUTE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.EXTENDED_ATTRIBUTE__DATA:
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
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createAttributeMetaData()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createAugmentation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createBaseComponentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createBundleCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createCommunicationCapability()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createConceptualNode()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createDeployLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createConstraintLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createDependencyLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createDeployModelObjectSet()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createExplicitContract()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createExported()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createExportedUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createExtendedAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createFileArtifact()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createUnitLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createHostingLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createInstanceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createInstantiation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createMemberLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createRealizationLink()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createRequirementExpression()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createService()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createSoftwareComponent()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.create(CorePackage.Literals.STRING_TO_STRING_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 CoreFactory.eINSTANCE.createTopology()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 EcoreFactory.eINSTANCE.createETypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EXTENDED_ATTRIBUTE__DATA,
				 XMLTypeFactory.eINSTANCE.createAnyType()));
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
