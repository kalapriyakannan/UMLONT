/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrganizationalPersonItemProvider.java,v 1.2 2008/06/25 22:31:02 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.provider;


import com.ibm.ccl.soa.deploy.core.CorePackage;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson;

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

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationalPersonItemProvider
	extends PersonItemProvider
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
	public OrganizationalPersonItemProvider(AdapterFactory adapterFactory) {
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

			addDestinationIndicatorPropertyDescriptor(object);
			addFacsimileTelephoneNumberPropertyDescriptor(object);
			addInternationalISDNNumberPropertyDescriptor(object);
			addLPropertyDescriptor(object);
			addOuPropertyDescriptor(object);
			addPhysicalDeliveryOfficeNamePropertyDescriptor(object);
			addPostalAddressPropertyDescriptor(object);
			addPostalCodePropertyDescriptor(object);
			addPostOfficeBoxPropertyDescriptor(object);
			addPreferredDeliveryMethodPropertyDescriptor(object);
			addRegisteredAddressPropertyDescriptor(object);
			addStPropertyDescriptor(object);
			addStreetPropertyDescriptor(object);
			addTeletexTerminalIdentifierPropertyDescriptor(object);
			addTelexNumberPropertyDescriptor(object);
			addTitlePropertyDescriptor(object);
			addX121addressPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Destination Indicator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationIndicatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_destinationIndicator_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_destinationIndicator_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facsimile Telephone Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacsimileTelephoneNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_facsimileTelephoneNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_facsimileTelephoneNumber_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the International ISDN Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInternationalISDNNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_internationalISDNNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_internationalISDNNumber_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the L feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_l_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_l_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__L,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ou feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOuPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_ou_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_ou_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__OU,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Physical Delivery Office Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhysicalDeliveryOfficeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_physicalDeliveryOfficeName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_physicalDeliveryOfficeName_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postal Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostalAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_postalAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_postalAddress_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postal Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostalCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_postalCode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_postalCode_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__POSTAL_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Post Office Box feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostOfficeBoxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_postOfficeBox_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_postOfficeBox_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preferred Delivery Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreferredDeliveryMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_preferredDeliveryMethod_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_preferredDeliveryMethod_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Registered Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRegisteredAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_registeredAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_registeredAddress_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the St feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_st_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_st_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__ST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Street feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStreetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_street_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_street_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__STREET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Teletex Terminal Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTeletexTerminalIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_teletexTerminalIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_teletexTerminalIdentifier_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Telex Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTelexNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_telexNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_telexNumber_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__TELEX_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_title_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_title_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the X12 1address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addX121addressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OrganizationalPerson_x121address_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OrganizationalPerson_x121address_feature", "_UI_OrganizationalPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.ORGANIZATIONAL_PERSON__X121ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns OrganizationalPerson.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OrganizationalPerson")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((OrganizationalPerson)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_OrganizationalPerson_type") : //$NON-NLS-1$
			getString("_UI_OrganizationalPerson_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(OrganizationalPerson.class)) {
			case LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR:
			case LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER:
			case LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER:
			case LdapPackage.ORGANIZATIONAL_PERSON__L:
			case LdapPackage.ORGANIZATIONAL_PERSON__OU:
			case LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS:
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE:
			case LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX:
			case LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD:
			case LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS:
			case LdapPackage.ORGANIZATIONAL_PERSON__ST:
			case LdapPackage.ORGANIZATIONAL_PERSON__STREET:
			case LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER:
			case LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER:
			case LdapPackage.ORGANIZATIONAL_PERSON__TITLE:
			case LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS:
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
		return LdapDomainEditPlugin.INSTANCE;
	}

}
