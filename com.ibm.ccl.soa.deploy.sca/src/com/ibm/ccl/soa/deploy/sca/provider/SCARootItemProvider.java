/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.provider;


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

import com.ibm.ccl.soa.deploy.sca.SCARoot;
import com.ibm.ccl.soa.deploy.sca.ScaFactory;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.sca.SCARoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SCARootItemProvider
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
	public SCARootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_BINDING);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_COMPONENT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_INTERFACE);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_OPERATION);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_SET);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_REFERENCE);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_SERVICE);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_BINDING_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_OPERATION_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT);
			childrenFeatures.add(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_SERVICE_UNIT);
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
	 * This returns SCARoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SCARoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_SCARoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(SCARoot.class)) {
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
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
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION,
				 ScaFactory.eINSTANCE.createGenericSCAImplementation()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_BINDING,
				 ScaFactory.eINSTANCE.createSCABinding()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_COMPONENT,
				 ScaFactory.eINSTANCE.createSCAComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL,
				 ScaFactory.eINSTANCE.createSCAImplementationBPEL()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE,
				 ScaFactory.eINSTANCE.createSCAImplementationComposite()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS,
				 ScaFactory.eINSTANCE.createSCAImplementationCplusplus()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA,
				 ScaFactory.eINSTANCE.createSCAImplementationJava()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_INTERFACE,
				 ScaFactory.eINSTANCE.createSCAInterface()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_OPERATION,
				 ScaFactory.eINSTANCE.createSCAOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT,
				 ScaFactory.eINSTANCE.createSCAPolicyIntent()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_SET,
				 ScaFactory.eINSTANCE.createSCAPolicySet()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY,
				 ScaFactory.eINSTANCE.createSCAProperty()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE,
				 ScaFactory.eINSTANCE.createScaPropertyValue()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_REFERENCE,
				 ScaFactory.eINSTANCE.createSCAReference()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_SERVICE,
				 ScaFactory.eINSTANCE.createSCAService()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT,
				 ScaFactory.eINSTANCE.createGenericSCAImplementationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_BINDING_UNIT,
				 ScaFactory.eINSTANCE.createSCABindingUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT,
				 ScaFactory.eINSTANCE.createSCAComponentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT,
				 ScaFactory.eINSTANCE.createSCAImplementationBPELUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT,
				 ScaFactory.eINSTANCE.createSCAImplementationCompositeUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT,
				 ScaFactory.eINSTANCE.createSCAImplementationCplusplusUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT,
				 ScaFactory.eINSTANCE.createSCAImplementationJavaUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT,
				 ScaFactory.eINSTANCE.createSCAInterfaceUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_OPERATION_UNIT,
				 ScaFactory.eINSTANCE.createSCAOperationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT,
				 ScaFactory.eINSTANCE.createSCAPolicyIntentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT,
				 ScaFactory.eINSTANCE.createSCAPolicySetUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT,
				 ScaFactory.eINSTANCE.createSCAPropertyUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT,
				 ScaFactory.eINSTANCE.createSCAPropertyValueUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT,
				 ScaFactory.eINSTANCE.createSCAReferenceUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_SERVICE_UNIT,
				 ScaFactory.eINSTANCE.createSCAServiceUnit()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return ScaEditPlugin.INSTANCE;
	}

}
