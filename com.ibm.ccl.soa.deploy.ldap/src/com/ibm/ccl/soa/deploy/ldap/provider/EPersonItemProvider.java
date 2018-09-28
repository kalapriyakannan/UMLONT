/**
 * <copyright>
 * </copyright>
 *
 * $Id: EPersonItemProvider.java,v 1.2 2008/06/25 22:31:02 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.provider;


import com.ibm.ccl.soa.deploy.core.CorePackage;

import com.ibm.ccl.soa.deploy.ldap.EPerson;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
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
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.ldap.EPerson} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EPersonItemProvider
	extends LdapAuxiliaryClassItemProvider
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
	public EPersonItemProvider(AdapterFactory adapterFactory) {
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

			addAccessHintPropertyDescriptor(object);
			addAccountHintPropertyDescriptor(object);
			addAudioPropertyDescriptor(object);
			addBusinessCategoryPropertyDescriptor(object);
			addCPropertyDescriptor(object);
			addCarLicensePropertyDescriptor(object);
			addCnPropertyDescriptor(object);
			addConfigPtrPropertyDescriptor(object);
			addDepartmentNumberPropertyDescriptor(object);
			addDestinationIndicatorPropertyDescriptor(object);
			addEmployeeNumberPropertyDescriptor(object);
			addEmployeeTypePropertyDescriptor(object);
			addFacsimileTelephoneNumberPropertyDescriptor(object);
			addGenerationQualifierPropertyDescriptor(object);
			addGivenNamePropertyDescriptor(object);
			addHomeFaxPropertyDescriptor(object);
			addHomePhonePropertyDescriptor(object);
			addHomePostalAddressPropertyDescriptor(object);
			addInitialsPropertyDescriptor(object);
			addInternationalISDNumberPropertyDescriptor(object);
			addJpegPhotoPropertyDescriptor(object);
			addLPropertyDescriptor(object);
			addLabeledURIPropertyDescriptor(object);
			addMailPropertyDescriptor(object);
			addManagerPropertyDescriptor(object);
			addMiddleNamePropertyDescriptor(object);
			addMobilePropertyDescriptor(object);
			addOPropertyDescriptor(object);
			addOrganizationalStatusPropertyDescriptor(object);
			addOtherMailboxPropertyDescriptor(object);
			addOuPropertyDescriptor(object);
			addPagerPropertyDescriptor(object);
			addPersonalTitlePropertyDescriptor(object);
			addPhotoPropertyDescriptor(object);
			addPhysicalDeliveryOfficeNamePropertyDescriptor(object);
			addPostalAddressPropertyDescriptor(object);
			addPostalCodePropertyDescriptor(object);
			addPostOfficeboxPropertyDescriptor(object);
			addPreferredDeliveryMethodPropertyDescriptor(object);
			addPreferredLanguagePropertyDescriptor(object);
			addRegisteredAddressPropertyDescriptor(object);
			addRoomNumberPropertyDescriptor(object);
			addSecretaryPropertyDescriptor(object);
			addSeeAlsoPropertyDescriptor(object);
			addSnPropertyDescriptor(object);
			addStPropertyDescriptor(object);
			addStreetPropertyDescriptor(object);
			addTelephoneNumberPropertyDescriptor(object);
			addTeletexTerminalIdentifierPropertyDescriptor(object);
			addTelexNumberPropertyDescriptor(object);
			addThumbnailLogoPropertyDescriptor(object);
			addThumbnailPhotoPropertyDescriptor(object);
			addTitlePropertyDescriptor(object);
			addUidPropertyDescriptor(object);
			addUniqueIdentifierPropertyDescriptor(object);
			addUserCertificatePropertyDescriptor(object);
			addUserPasswordPropertyDescriptor(object);
			addUserPKCS12PropertyDescriptor(object);
			addUserSMIMECertificatePropertyDescriptor(object);
			addX121AddressPropertyDescriptor(object);
			addX500UniqueIdentifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Access Hint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccessHintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_accessHint_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_accessHint_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__ACCESS_HINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Account Hint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccountHintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_accountHint_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_accountHint_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__ACCOUNT_HINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Audio feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAudioPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_audio_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_audio_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__AUDIO,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Business Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBusinessCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_businessCategory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_businessCategory_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__BUSINESS_CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the C feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_c_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_c_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__C,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Car License feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCarLicensePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_carLicense_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_carLicense_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__CAR_LICENSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cn feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_cn_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_cn_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__CN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Config Ptr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigPtrPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_configPtr_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_configPtr_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__CONFIG_PTR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Department Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepartmentNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_departmentNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_departmentNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__DEPARTMENT_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_EPerson_destinationIndicator_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_destinationIndicator_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__DESTINATION_INDICATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Employee Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmployeeNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_employeeNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_employeeNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__EMPLOYEE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Employee Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmployeeTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_employeeType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_employeeType_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__EMPLOYEE_TYPE,
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
				 getString("_UI_EPerson_facsimileTelephoneNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_facsimileTelephoneNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__FACSIMILE_TELEPHONE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Generation Qualifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenerationQualifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_generationQualifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_generationQualifier_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__GENERATION_QUALIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Given Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGivenNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_givenName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_givenName_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__GIVEN_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Home Fax feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHomeFaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_homeFax_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_homeFax_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__HOME_FAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Home Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHomePhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_homePhone_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_homePhone_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__HOME_PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Home Postal Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHomePostalAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_homePostalAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_homePostalAddress_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__HOME_POSTAL_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initials feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_initials_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_initials_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__INITIALS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the International ISD Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInternationalISDNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_internationalISDNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_internationalISDNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__INTERNATIONAL_ISD_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Jpeg Photo feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJpegPhotoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_jpegPhoto_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_jpegPhoto_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__JPEG_PHOTO,
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
				 getString("_UI_EPerson_l_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_l_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__L,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Labeled URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabeledURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_labeledURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_labeledURI_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__LABELED_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mail feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_mail_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_mail_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__MAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manager feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_manager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_manager_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__MANAGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Middle Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMiddleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_middleName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_middleName_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__MIDDLE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mobile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMobilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_mobile_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_mobile_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__MOBILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the O feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_o_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_o_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__O,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organizational Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationalStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_organizationalStatus_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_organizationalStatus_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__ORGANIZATIONAL_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Other Mailbox feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOtherMailboxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_otherMailbox_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_otherMailbox_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__OTHER_MAILBOX,
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
				 getString("_UI_EPerson_ou_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_ou_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__OU,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pager feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPagerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_pager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_pager_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PAGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Personal Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPersonalTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_personalTitle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_personalTitle_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PERSONAL_TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Photo feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhotoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_photo_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_photo_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PHOTO,
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
				 getString("_UI_EPerson_physicalDeliveryOfficeName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_physicalDeliveryOfficeName_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PHYSICAL_DELIVERY_OFFICE_NAME,
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
				 getString("_UI_EPerson_postalAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_postalAddress_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__POSTAL_ADDRESS,
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
				 getString("_UI_EPerson_postalCode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_postalCode_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__POSTAL_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Post Officebox feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostOfficeboxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_postOfficebox_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_postOfficebox_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__POST_OFFICEBOX,
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
				 getString("_UI_EPerson_preferredDeliveryMethod_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_preferredDeliveryMethod_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PREFERRED_DELIVERY_METHOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preferred Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreferredLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_preferredLanguage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_preferredLanguage_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__PREFERRED_LANGUAGE,
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
				 getString("_UI_EPerson_registeredAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_registeredAddress_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__REGISTERED_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Room Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoomNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_roomNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_roomNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__ROOM_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Secretary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecretaryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_secretary_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_secretary_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__SECRETARY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the See Also feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeeAlsoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_seeAlso_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_seeAlso_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__SEE_ALSO,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sn feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_sn_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_sn_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__SN,
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
				 getString("_UI_EPerson_st_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_st_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__ST,
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
				 getString("_UI_EPerson_street_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_street_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__STREET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Telephone Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTelephoneNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_telephoneNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_telephoneNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__TELEPHONE_NUMBER,
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
				 getString("_UI_EPerson_teletexTerminalIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_teletexTerminalIdentifier_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__TELETEX_TERMINAL_IDENTIFIER,
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
				 getString("_UI_EPerson_telexNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_telexNumber_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__TELEX_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Thumbnail Logo feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThumbnailLogoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_thumbnailLogo_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_thumbnailLogo_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__THUMBNAIL_LOGO,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Thumbnail Photo feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThumbnailPhotoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_thumbnailPhoto_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_thumbnailPhoto_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__THUMBNAIL_PHOTO,
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
				 getString("_UI_EPerson_title_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_title_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_uid_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_uid_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__UID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unique Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUniqueIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_uniqueIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_uniqueIdentifier_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__UNIQUE_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User Certificate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserCertificatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_userCertificate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_userCertificate_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__USER_CERTIFICATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_userPassword_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_userPassword_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__USER_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User PKCS12 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserPKCS12PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_userPKCS12_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_userPKCS12_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__USER_PKCS12,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User SMIME Certificate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserSMIMECertificatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_userSMIMECertificate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_userSMIMECertificate_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__USER_SMIME_CERTIFICATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the X121 Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addX121AddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_x121Address_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_x121Address_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__X121_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the X500 Unique Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addX500UniqueIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPerson_x500UniqueIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EPerson_x500UniqueIdentifier_feature", "_UI_EPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.EPERSON__X500_UNIQUE_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns EPerson.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EPerson")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((EPerson)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EPerson_type") : //$NON-NLS-1$
			getString("_UI_EPerson_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(EPerson.class)) {
			case LdapPackage.EPERSON__ACCESS_HINT:
			case LdapPackage.EPERSON__ACCOUNT_HINT:
			case LdapPackage.EPERSON__AUDIO:
			case LdapPackage.EPERSON__BUSINESS_CATEGORY:
			case LdapPackage.EPERSON__C:
			case LdapPackage.EPERSON__CAR_LICENSE:
			case LdapPackage.EPERSON__CN:
			case LdapPackage.EPERSON__CONFIG_PTR:
			case LdapPackage.EPERSON__DEPARTMENT_NUMBER:
			case LdapPackage.EPERSON__DESTINATION_INDICATOR:
			case LdapPackage.EPERSON__EMPLOYEE_NUMBER:
			case LdapPackage.EPERSON__EMPLOYEE_TYPE:
			case LdapPackage.EPERSON__FACSIMILE_TELEPHONE_NUMBER:
			case LdapPackage.EPERSON__GENERATION_QUALIFIER:
			case LdapPackage.EPERSON__GIVEN_NAME:
			case LdapPackage.EPERSON__HOME_FAX:
			case LdapPackage.EPERSON__HOME_PHONE:
			case LdapPackage.EPERSON__HOME_POSTAL_ADDRESS:
			case LdapPackage.EPERSON__INITIALS:
			case LdapPackage.EPERSON__INTERNATIONAL_ISD_NUMBER:
			case LdapPackage.EPERSON__JPEG_PHOTO:
			case LdapPackage.EPERSON__L:
			case LdapPackage.EPERSON__LABELED_URI:
			case LdapPackage.EPERSON__MAIL:
			case LdapPackage.EPERSON__MANAGER:
			case LdapPackage.EPERSON__MIDDLE_NAME:
			case LdapPackage.EPERSON__MOBILE:
			case LdapPackage.EPERSON__O:
			case LdapPackage.EPERSON__ORGANIZATIONAL_STATUS:
			case LdapPackage.EPERSON__OTHER_MAILBOX:
			case LdapPackage.EPERSON__OU:
			case LdapPackage.EPERSON__PAGER:
			case LdapPackage.EPERSON__PERSONAL_TITLE:
			case LdapPackage.EPERSON__PHOTO:
			case LdapPackage.EPERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
			case LdapPackage.EPERSON__POSTAL_ADDRESS:
			case LdapPackage.EPERSON__POSTAL_CODE:
			case LdapPackage.EPERSON__POST_OFFICEBOX:
			case LdapPackage.EPERSON__PREFERRED_DELIVERY_METHOD:
			case LdapPackage.EPERSON__PREFERRED_LANGUAGE:
			case LdapPackage.EPERSON__REGISTERED_ADDRESS:
			case LdapPackage.EPERSON__ROOM_NUMBER:
			case LdapPackage.EPERSON__SECRETARY:
			case LdapPackage.EPERSON__SEE_ALSO:
			case LdapPackage.EPERSON__SN:
			case LdapPackage.EPERSON__ST:
			case LdapPackage.EPERSON__STREET:
			case LdapPackage.EPERSON__TELEPHONE_NUMBER:
			case LdapPackage.EPERSON__TELETEX_TERMINAL_IDENTIFIER:
			case LdapPackage.EPERSON__TELEX_NUMBER:
			case LdapPackage.EPERSON__THUMBNAIL_LOGO:
			case LdapPackage.EPERSON__THUMBNAIL_PHOTO:
			case LdapPackage.EPERSON__TITLE:
			case LdapPackage.EPERSON__UID:
			case LdapPackage.EPERSON__UNIQUE_IDENTIFIER:
			case LdapPackage.EPERSON__USER_CERTIFICATE:
			case LdapPackage.EPERSON__USER_PASSWORD:
			case LdapPackage.EPERSON__USER_PKCS12:
			case LdapPackage.EPERSON__USER_SMIME_CERTIFICATE:
			case LdapPackage.EPERSON__X121_ADDRESS:
			case LdapPackage.EPERSON__X500_UNIQUE_IDENTIFIER:
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
