/**
 * <copyright>
 * </copyright>
 *
 * $Id: L2InterfaceItemProvider.java,v 1.2 2008/04/29 23:04:03 esnible Exp $
 */
package com.ibm.ccl.soa.deploy.net.provider;


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
import com.ibm.ccl.soa.deploy.core.provider.CapabilityItemProvider;
import com.ibm.ccl.soa.deploy.net.L2Interface;
import com.ibm.ccl.soa.deploy.net.NetPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.net.L2Interface} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class L2InterfaceItemProvider
	extends CapabilityItemProvider
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
	public L2InterfaceItemProvider(AdapterFactory adapterFactory) {
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

			addAutoNegotiationPropertyDescriptor(object);
			addBroadcastPropertyDescriptor(object);
			addDuplexPropertyDescriptor(object);
			addEncapsulationPropertyDescriptor(object);
			addHwAddressPropertyDescriptor(object);
			addIndexPropertyDescriptor(object);
			addL2InterfaceNamePropertyDescriptor(object);
			addLoopbackPropertyDescriptor(object);
			addMtuPropertyDescriptor(object);
			addPrivatePropertyDescriptor(object);
			addPromiscuousPropertyDescriptor(object);
			addSpeedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Auto Negotiation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoNegotiationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_autoNegotiation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_autoNegotiation_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__AUTO_NEGOTIATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broadcast feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBroadcastPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_broadcast_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_broadcast_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__BROADCAST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Duplex feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDuplexPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_duplex_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_duplex_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__DUPLEX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Encapsulation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEncapsulationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_encapsulation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_encapsulation_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__ENCAPSULATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hw Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHwAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_hwAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_hwAddress_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__HW_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_index_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_index_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__INDEX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the L2 Interface Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addL2InterfaceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_l2InterfaceName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_l2InterfaceName_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__L2_INTERFACE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Loopback feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoopbackPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_loopback_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_loopback_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__LOOPBACK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mtu feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMtuPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_mtu_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_mtu_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__MTU,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Private feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrivatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_private_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_private_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__PRIVATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Promiscuous feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPromiscuousPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_promiscuous_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_promiscuous_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__PROMISCUOUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_L2Interface_speed_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_L2Interface_speed_feature", "_UI_L2Interface_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NetPackage.Literals.L2_INTERFACE__SPEED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns L2Interface.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/L2Interface")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((L2Interface)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_L2Interface_type") : //$NON-NLS-1$
			getString("_UI_L2Interface_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(L2Interface.class)) {
			case NetPackage.L2_INTERFACE__AUTO_NEGOTIATION:
			case NetPackage.L2_INTERFACE__BROADCAST:
			case NetPackage.L2_INTERFACE__DUPLEX:
			case NetPackage.L2_INTERFACE__ENCAPSULATION:
			case NetPackage.L2_INTERFACE__HW_ADDRESS:
			case NetPackage.L2_INTERFACE__INDEX:
			case NetPackage.L2_INTERFACE__L2_INTERFACE_NAME:
			case NetPackage.L2_INTERFACE__LOOPBACK:
			case NetPackage.L2_INTERFACE__MTU:
			case NetPackage.L2_INTERFACE__PRIVATE:
			case NetPackage.L2_INTERFACE__PROMISCUOUS:
			case NetPackage.L2_INTERFACE__SPEED:
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
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return NetEditPlugin.INSTANCE;
	}

}
