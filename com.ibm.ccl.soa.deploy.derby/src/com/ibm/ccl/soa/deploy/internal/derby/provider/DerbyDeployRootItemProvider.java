/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.provider;

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

import com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DerbyDeployRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DerbyDeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED);
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
	 * This returns DerbyDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DerbyDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_DerbyDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DerbyDeployRoot.class)) {
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
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
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL,
					 DerbyFactory.eINSTANCE.createDerbyDDLArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE,
					 DerbyFactory.eINSTANCE.createDerbyDatabase())));

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE,
					 DerbyFactory.eINSTANCE.createDerbyInstance())));

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT,
					 DerbyFactory.eINSTANCE.createDerbyDatabaseInstanceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT,
					 DerbyFactory.eINSTANCE.createDerbyDatabaseUnit())));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return DerbyDomainEditPlugin.INSTANCE;
	}

}
