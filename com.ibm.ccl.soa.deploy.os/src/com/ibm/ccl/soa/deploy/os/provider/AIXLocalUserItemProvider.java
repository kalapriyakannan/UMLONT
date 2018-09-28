/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.provider;

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
import com.ibm.ccl.soa.deploy.os.AIXLocalUser;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.os.AIXLocalUser} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class AIXLocalUserItemProvider extends UserItemProvider implements
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
	public AIXLocalUserItemProvider(AdapterFactory adapterFactory) {
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

			addAccountDescriptionPropertyDescriptor(object);
			addAccountDisabledPropertyDescriptor(object);
			addAccountExpirationTimePropertyDescriptor(object);
			addChangePasswordNextLogonPropertyDescriptor(object);
			addFullNamePropertyDescriptor(object);
			addHomeDirPropertyDescriptor(object);
			addIsAdminPropertyDescriptor(object);
			addLoginPermittedPropertyDescriptor(object);
			addLoginRetriesPropertyDescriptor(object);
			addLoginTimesPropertyDescriptor(object);
			addMaxCharRepeatsPropertyDescriptor(object);
			addMaxPasswordAgeInWeeksPropertyDescriptor(object);
			addMaxPasswordValidWeeksPropertyDescriptor(object);
			addMinAlphaCharsInPasswordPropertyDescriptor(object);
			addMinDiffCharsPropertyDescriptor(object);
			addMinOtherCharsInPasswordPropertyDescriptor(object);
			addMinPasswordAgeInWeeksPropertyDescriptor(object);
			addMinPasswordLengthPropertyDescriptor(object);
			addNotReusableNumberOfPasswordsPropertyDescriptor(object);
			addPassReuseNotAllowedInWeeksPropertyDescriptor(object);
			addPasswordChangeWarnTimePropertyDescriptor(object);
			addPasswordNeverExpiresPropertyDescriptor(object);
			addPrimaryAuthMethodPropertyDescriptor(object);
			addRemoteLoginIsAllowedPropertyDescriptor(object);
			addSecondaryAuthMethodPropertyDescriptor(object);
			addShellPropertyDescriptor(object);
			addSuGroupsAllowedPropertyDescriptor(object);
			addSuIsAllowedPropertyDescriptor(object);
			addTimeLastLoginPropertyDescriptor(object);
			addUserCannotChangePasswordPropertyDescriptor(object);
			addUserNamePropertyDescriptor(object);
			addUserRegisteringMethodPropertyDescriptor(object);
			addUserSidPropertyDescriptor(object);
			addUsuccessfulLoginCountPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Account Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccountDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_accountDescription_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_accountDescription_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Account Disabled feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addAccountDisabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_accountDisabled_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_accountDisabled_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__ACCOUNT_DISABLED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Account Expiration Time feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccountExpirationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_accountExpirationTime_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_accountExpirationTime_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Change Password Next Logon feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addChangePasswordNextLogonPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_changePasswordNextLogon_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_changePasswordNextLogon_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Full Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addFullNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_fullName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_fullName_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__FULL_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Home Dir feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addHomeDirPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_homeDir_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_homeDir_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__HOME_DIR, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Is Admin feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addIsAdminPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_isAdmin_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_isAdmin_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__IS_ADMIN, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Login Permitted feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLoginPermittedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_loginPermitted_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_loginPermitted_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__LOGIN_PERMITTED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Login Retries feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLoginRetriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_loginRetries_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_loginRetries_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__LOGIN_RETRIES, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Login Times feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLoginTimesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_loginTimes_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_loginTimes_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__LOGIN_TIMES, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Max Char Repeats feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addMaxCharRepeatsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_maxCharRepeats_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_maxCharRepeats_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MAX_CHAR_REPEATS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Max Password Age In Weeks feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxPasswordAgeInWeeksPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_maxPasswordAgeInWeeks_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_maxPasswordAgeInWeeks_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Max Password Valid Weeks feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxPasswordValidWeeksPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_maxPasswordValidWeeks_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_maxPasswordValidWeeks_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Alpha Chars In Password feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMinAlphaCharsInPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_minAlphaCharsInPassword_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_minAlphaCharsInPassword_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Diff Chars feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addMinDiffCharsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_minDiffChars_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_minDiffChars_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MIN_DIFF_CHARS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Other Chars In Password feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMinOtherCharsInPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_minOtherCharsInPassword_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_minOtherCharsInPassword_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Password Age In Weeks feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinPasswordAgeInWeeksPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_minPasswordAgeInWeeks_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_minPasswordAgeInWeeks_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Password Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinPasswordLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_minPasswordLength_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_minPasswordLength_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Not Reusable Number Of Passwords feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNotReusableNumberOfPasswordsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_notReusableNumberOfPasswords_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_notReusableNumberOfPasswords_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Pass Reuse Not Allowed In Weeks feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPassReuseNotAllowedInWeeksPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_passReuseNotAllowedInWeeks_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_passReuseNotAllowedInWeeks_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Password Change Warn Time feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordChangeWarnTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_passwordChangeWarnTime_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_passwordChangeWarnTime_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Password Never Expires feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordNeverExpiresPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_passwordNeverExpires_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_passwordNeverExpires_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Primary Auth Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryAuthMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_primaryAuthMethod_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_primaryAuthMethod_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Remote Login Is Allowed feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRemoteLoginIsAllowedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_remoteLoginIsAllowed_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_remoteLoginIsAllowed_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Secondary Auth Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecondaryAuthMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_secondaryAuthMethod_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_secondaryAuthMethod_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Shell feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addShellPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_shell_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_shell_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__SHELL, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Su Groups Allowed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuGroupsAllowedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_suGroupsAllowed_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_suGroupsAllowed_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__SU_GROUPS_ALLOWED, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Su Is Allowed feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSuIsAllowedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_suIsAllowed_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_suIsAllowed_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__SU_IS_ALLOWED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Time Last Login feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTimeLastLoginPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_timeLastLogin_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_timeLastLogin_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__TIME_LAST_LOGIN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the User Cannot Change Password feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addUserCannotChangePasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_userCannotChangePassword_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_userCannotChangePassword_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the User Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUserNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_userName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_userName_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__USER_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the User Registering Method feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserRegisteringMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_userRegisteringMethod_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_userRegisteringMethod_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__USER_REGISTERING_METHOD, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the User Sid feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addUserSidPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_userSid_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_userSid_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__USER_SID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Usuccessful Login Count feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsuccessfulLoginCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AIXLocalUser_usuccessfulLoginCount_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_AIXLocalUser_usuccessfulLoginCount_feature", "_UI_AIXLocalUser_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns AIXLocalUser.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AIXLocalUser")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((AIXLocalUser) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_AIXLocalUser_type") : //$NON-NLS-1$
				getString("_UI_AIXLocalUser_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AIXLocalUser.class))
		{
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DESCRIPTION:
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_DISABLED:
		case OsPackage.AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME:
		case OsPackage.AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON:
		case OsPackage.AIX_LOCAL_USER__FULL_NAME:
		case OsPackage.AIX_LOCAL_USER__HOME_DIR:
		case OsPackage.AIX_LOCAL_USER__IS_ADMIN:
		case OsPackage.AIX_LOCAL_USER__LOGIN_PERMITTED:
		case OsPackage.AIX_LOCAL_USER__LOGIN_RETRIES:
		case OsPackage.AIX_LOCAL_USER__LOGIN_TIMES:
		case OsPackage.AIX_LOCAL_USER__MAX_CHAR_REPEATS:
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS:
		case OsPackage.AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS:
		case OsPackage.AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD:
		case OsPackage.AIX_LOCAL_USER__MIN_DIFF_CHARS:
		case OsPackage.AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD:
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS:
		case OsPackage.AIX_LOCAL_USER__MIN_PASSWORD_LENGTH:
		case OsPackage.AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS:
		case OsPackage.AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS:
		case OsPackage.AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME:
		case OsPackage.AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES:
		case OsPackage.AIX_LOCAL_USER__PRIMARY_AUTH_METHOD:
		case OsPackage.AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED:
		case OsPackage.AIX_LOCAL_USER__SECONDARY_AUTH_METHOD:
		case OsPackage.AIX_LOCAL_USER__SHELL:
		case OsPackage.AIX_LOCAL_USER__SU_GROUPS_ALLOWED:
		case OsPackage.AIX_LOCAL_USER__SU_IS_ALLOWED:
		case OsPackage.AIX_LOCAL_USER__TIME_LAST_LOGIN:
		case OsPackage.AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD:
		case OsPackage.AIX_LOCAL_USER__USER_NAME:
		case OsPackage.AIX_LOCAL_USER__USER_REGISTERING_METHOD:
		case OsPackage.AIX_LOCAL_USER__USER_SID:
		case OsPackage.AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
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

		if (childFeature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE
				|| childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
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
		return OsEditPlugin.INSTANCE;
	}

}
