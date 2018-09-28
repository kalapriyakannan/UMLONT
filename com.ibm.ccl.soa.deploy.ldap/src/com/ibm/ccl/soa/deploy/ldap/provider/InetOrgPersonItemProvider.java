/**
 * <copyright>
 * </copyright>
 *
 * $Id: InetOrgPersonItemProvider.java,v 1.2 2008/06/25 22:31:02 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.provider;


import com.ibm.ccl.soa.deploy.core.CorePackage;

import com.ibm.ccl.soa.deploy.ldap.InetOrgPerson;

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
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InetOrgPersonItemProvider
	extends OrganizationalPersonItemProvider
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
	public InetOrgPersonItemProvider(AdapterFactory adapterFactory) {
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
			addConfigPtrPropertyDescriptor(object);
			addDepartmentNumberPropertyDescriptor(object);
			addEmployeeNumberPropertyDescriptor(object);
			addEmployeeTypePropertyDescriptor(object);
			addGenerationQualifierPropertyDescriptor(object);
			addGivenNamePropertyDescriptor(object);
			addHomeFaxPropertyDescriptor(object);
			addHomePhonePropertyDescriptor(object);
			addHomePostalAddressPropertyDescriptor(object);
			addInitialsPropertyDescriptor(object);
			addJpegPhotoPropertyDescriptor(object);
			addLabeledURIPropertyDescriptor(object);
			addMailPropertyDescriptor(object);
			addManagerPropertyDescriptor(object);
			addMiddleNamePropertyDescriptor(object);
			addMobilePropertyDescriptor(object);
			addOPropertyDescriptor(object);
			addOrganizationalStatusPropertyDescriptor(object);
			addOtherMailboxPropertyDescriptor(object);
			addPagerPropertyDescriptor(object);
			addPersonalTitlePropertyDescriptor(object);
			addPhotoPropertyDescriptor(object);
			addPreferredLanguagePropertyDescriptor(object);
			addRoomNumberPropertyDescriptor(object);
			addSecretaryPropertyDescriptor(object);
			addThumbnailLogoPropertyDescriptor(object);
			addThumbnailPhotoPropertyDescriptor(object);
			addUidPropertyDescriptor(object);
			addUniqueIdentifierPropertyDescriptor(object);
			addUserCertificatePropertyDescriptor(object);
			addUserPKCS12PropertyDescriptor(object);
			addUserSMIMECertificatePropertyDescriptor(object);
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
				 getString("_UI_InetOrgPerson_accessHint_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_accessHint_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__ACCESS_HINT,
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
				 getString("_UI_InetOrgPerson_accountHint_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_accountHint_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__ACCOUNT_HINT,
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
				 getString("_UI_InetOrgPerson_audio_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_audio_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__AUDIO,
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
				 getString("_UI_InetOrgPerson_businessCategory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_businessCategory_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__BUSINESS_CATEGORY,
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
				 getString("_UI_InetOrgPerson_c_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_c_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__C,
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
				 getString("_UI_InetOrgPerson_carLicense_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_carLicense_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__CAR_LICENSE,
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
				 getString("_UI_InetOrgPerson_configPtr_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_configPtr_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__CONFIG_PTR,
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
				 getString("_UI_InetOrgPerson_departmentNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_departmentNumber_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__DEPARTMENT_NUMBER,
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
				 getString("_UI_InetOrgPerson_employeeNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_employeeNumber_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__EMPLOYEE_NUMBER,
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
				 getString("_UI_InetOrgPerson_employeeType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_employeeType_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__EMPLOYEE_TYPE,
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
				 getString("_UI_InetOrgPerson_generationQualifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_generationQualifier_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__GENERATION_QUALIFIER,
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
				 getString("_UI_InetOrgPerson_givenName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_givenName_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__GIVEN_NAME,
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
				 getString("_UI_InetOrgPerson_homeFax_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_homeFax_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__HOME_FAX,
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
				 getString("_UI_InetOrgPerson_homePhone_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_homePhone_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__HOME_PHONE,
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
				 getString("_UI_InetOrgPerson_homePostalAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_homePostalAddress_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__HOME_POSTAL_ADDRESS,
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
				 getString("_UI_InetOrgPerson_initials_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_initials_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__INITIALS,
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
				 getString("_UI_InetOrgPerson_jpegPhoto_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_jpegPhoto_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__JPEG_PHOTO,
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
				 getString("_UI_InetOrgPerson_labeledURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_labeledURI_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__LABELED_URI,
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
				 getString("_UI_InetOrgPerson_mail_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_mail_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__MAIL,
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
				 getString("_UI_InetOrgPerson_manager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_manager_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__MANAGER,
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
				 getString("_UI_InetOrgPerson_middleName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_middleName_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__MIDDLE_NAME,
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
				 getString("_UI_InetOrgPerson_mobile_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_mobile_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__MOBILE,
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
				 getString("_UI_InetOrgPerson_o_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_o_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__O,
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
				 getString("_UI_InetOrgPerson_organizationalStatus_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_organizationalStatus_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__ORGANIZATIONAL_STATUS,
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
				 getString("_UI_InetOrgPerson_otherMailbox_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_otherMailbox_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__OTHER_MAILBOX,
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
				 getString("_UI_InetOrgPerson_pager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_pager_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__PAGER,
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
				 getString("_UI_InetOrgPerson_personalTitle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_personalTitle_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__PERSONAL_TITLE,
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
				 getString("_UI_InetOrgPerson_photo_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_photo_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__PHOTO,
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
				 getString("_UI_InetOrgPerson_preferredLanguage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_preferredLanguage_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__PREFERRED_LANGUAGE,
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
				 getString("_UI_InetOrgPerson_roomNumber_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_roomNumber_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__ROOM_NUMBER,
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
				 getString("_UI_InetOrgPerson_secretary_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_secretary_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__SECRETARY,
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
				 getString("_UI_InetOrgPerson_thumbnailLogo_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_thumbnailLogo_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__THUMBNAIL_LOGO,
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
				 getString("_UI_InetOrgPerson_thumbnailPhoto_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_thumbnailPhoto_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__THUMBNAIL_PHOTO,
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
				 getString("_UI_InetOrgPerson_uid_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_uid_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__UID,
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
				 getString("_UI_InetOrgPerson_uniqueIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_uniqueIdentifier_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__UNIQUE_IDENTIFIER,
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
				 getString("_UI_InetOrgPerson_userCertificate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_userCertificate_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__USER_CERTIFICATE,
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
				 getString("_UI_InetOrgPerson_userPKCS12_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_userPKCS12_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__USER_PKCS12,
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
				 getString("_UI_InetOrgPerson_userSMIMECertificate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_userSMIMECertificate_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__USER_SMIME_CERTIFICATE,
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
				 getString("_UI_InetOrgPerson_x500UniqueIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_InetOrgPerson_x500UniqueIdentifier_feature", "_UI_InetOrgPerson_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LdapPackage.Literals.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns InetOrgPerson.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InetOrgPerson")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((InetOrgPerson)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InetOrgPerson_type") : //$NON-NLS-1$
			getString("_UI_InetOrgPerson_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(InetOrgPerson.class)) {
			case LdapPackage.INET_ORG_PERSON__ACCESS_HINT:
			case LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT:
			case LdapPackage.INET_ORG_PERSON__AUDIO:
			case LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY:
			case LdapPackage.INET_ORG_PERSON__C:
			case LdapPackage.INET_ORG_PERSON__CAR_LICENSE:
			case LdapPackage.INET_ORG_PERSON__CONFIG_PTR:
			case LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER:
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER:
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE:
			case LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER:
			case LdapPackage.INET_ORG_PERSON__GIVEN_NAME:
			case LdapPackage.INET_ORG_PERSON__HOME_FAX:
			case LdapPackage.INET_ORG_PERSON__HOME_PHONE:
			case LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS:
			case LdapPackage.INET_ORG_PERSON__INITIALS:
			case LdapPackage.INET_ORG_PERSON__JPEG_PHOTO:
			case LdapPackage.INET_ORG_PERSON__LABELED_URI:
			case LdapPackage.INET_ORG_PERSON__MAIL:
			case LdapPackage.INET_ORG_PERSON__MANAGER:
			case LdapPackage.INET_ORG_PERSON__MIDDLE_NAME:
			case LdapPackage.INET_ORG_PERSON__MOBILE:
			case LdapPackage.INET_ORG_PERSON__O:
			case LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS:
			case LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX:
			case LdapPackage.INET_ORG_PERSON__PAGER:
			case LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE:
			case LdapPackage.INET_ORG_PERSON__PHOTO:
			case LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE:
			case LdapPackage.INET_ORG_PERSON__ROOM_NUMBER:
			case LdapPackage.INET_ORG_PERSON__SECRETARY:
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO:
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO:
			case LdapPackage.INET_ORG_PERSON__UID:
			case LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER:
			case LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE:
			case LdapPackage.INET_ORG_PERSON__USER_PKCS12:
			case LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE:
			case LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER:
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
