/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.generic.GenericDeployRoot;
import com.ibm.ccl.soa.deploy.generic.GenericPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class GenericDeployRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public GenericDeployRootItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED);
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
	 * This returns GenericDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenericDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_GenericDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(GenericDeployRoot.class)) {
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
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
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC,
					 CoreFactory.eINSTANCE.createCapability())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC,
					 CoreFactory.eINSTANCE.createBundleCapability())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC,
					 CoreFactory.eINSTANCE.createCommunicationCapability())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC,
					 CoreFactory.eINSTANCE.createService())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT,
					 CoreFactory.eINSTANCE.createUnit())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT,
					 CoreFactory.eINSTANCE.createBaseComponentUnit())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT,
					 CoreFactory.eINSTANCE.createConceptualNode())));

		newChildDescriptors.add
			(createChildParameter
				(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT,
					 CoreFactory.eINSTANCE.createSoftwareComponent())));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return GenericEditPlugin.INSTANCE;
	}

}
