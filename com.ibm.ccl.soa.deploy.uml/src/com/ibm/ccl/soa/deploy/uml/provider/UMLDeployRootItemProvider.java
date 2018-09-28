/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLDeployRootItemProvider.java,v 1.9 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.provider;


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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.uml.UMLDeployRoot;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDeployRootItemProvider
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
	public UMLDeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT);
			childrenFeatures.add(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT);
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
	 * This returns UMLDeployRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UMLDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_UMLDeployRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(UMLDeployRoot.class)) {
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
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
				(UmlPackage.Literals.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT,
				 UmlFactory.eINSTANCE.createUMLElementArtifact()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR,
				 UmlFactory.eINSTANCE.createUMLActor()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT,
				 UmlFactory.eINSTANCE.createUMLComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE,
				 UmlFactory.eINSTANCE.createUMLInterface()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP,
				 UmlFactory.eINSTANCE.createUMLPackageCap()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION,
				 UmlFactory.eINSTANCE.createUMLInteractionConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT,
				 UmlFactory.eINSTANCE.createUMLActorUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT,
				 UmlFactory.eINSTANCE.createUMLInterfaceUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT,
				 UmlFactory.eINSTANCE.createUMLPackageUnit()));
	}

	/**
	 * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection selection) {
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
				UmlDomainEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return UmlDomainEditPlugin.INSTANCE;
	}

}
