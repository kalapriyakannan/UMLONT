/**
 * <copyright>
 * </copyright>
 *
 * $Id: InetOrgPersonImpl.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.InetOrgPerson;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inet Org Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getAccessHint <em>Access Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getAccountHint <em>Account Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getAudio <em>Audio</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getBusinessCategory <em>Business Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getC <em>C</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getCarLicense <em>Car License</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getConfigPtr <em>Config Ptr</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getDepartmentNumber <em>Department Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getEmployeeNumber <em>Employee Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getEmployeeType <em>Employee Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getGenerationQualifier <em>Generation Qualifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getHomeFax <em>Home Fax</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getHomePhone <em>Home Phone</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getHomePostalAddress <em>Home Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getInitials <em>Initials</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getJpegPhoto <em>Jpeg Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getLabeledURI <em>Labeled URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getMobile <em>Mobile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getO <em>O</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getOrganizationalStatus <em>Organizational Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getOtherMailbox <em>Other Mailbox</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getPager <em>Pager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getPersonalTitle <em>Personal Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getPhoto <em>Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getPreferredLanguage <em>Preferred Language</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getRoomNumber <em>Room Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getSecretary <em>Secretary</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getThumbnailLogo <em>Thumbnail Logo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getThumbnailPhoto <em>Thumbnail Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getUid <em>Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getUserCertificate <em>User Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getUserPKCS12 <em>User PKCS12</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getUserSMIMECertificate <em>User SMIME Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InetOrgPersonImpl extends OrganizationalPersonImpl implements InetOrgPerson {
	/**
	 * The default value of the '{@link #getAccessHint() <em>Access Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessHint()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCESS_HINT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAccessHint() <em>Access Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessHint()
	 * @generated
	 * @ordered
	 */
	protected String accessHint = ACCESS_HINT_EDEFAULT;
	/**
	 * The default value of the '{@link #getAccountHint() <em>Account Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountHint()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCOUNT_HINT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAccountHint() <em>Account Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountHint()
	 * @generated
	 * @ordered
	 */
	protected String accountHint = ACCOUNT_HINT_EDEFAULT;
	/**
	 * The default value of the '{@link #getAudio() <em>Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudio()
	 * @generated
	 * @ordered
	 */
	protected static final String AUDIO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAudio() <em>Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudio()
	 * @generated
	 * @ordered
	 */
	protected String audio = AUDIO_EDEFAULT;
	/**
	 * The default value of the '{@link #getBusinessCategory() <em>Business Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String BUSINESS_CATEGORY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBusinessCategory() <em>Business Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessCategory()
	 * @generated
	 * @ordered
	 */
	protected String businessCategory = BUSINESS_CATEGORY_EDEFAULT;
	/**
	 * The default value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected static final String C_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected String c = C_EDEFAULT;
	/**
	 * The default value of the '{@link #getCarLicense() <em>Car License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCarLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String CAR_LICENSE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCarLicense() <em>Car License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCarLicense()
	 * @generated
	 * @ordered
	 */
	protected String carLicense = CAR_LICENSE_EDEFAULT;
	/**
	 * The default value of the '{@link #getConfigPtr() <em>Config Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigPtr()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_PTR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getConfigPtr() <em>Config Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigPtr()
	 * @generated
	 * @ordered
	 */
	protected String configPtr = CONFIG_PTR_EDEFAULT;
	/**
	 * The default value of the '{@link #getDepartmentNumber() <em>Department Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartmentNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPARTMENT_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDepartmentNumber() <em>Department Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartmentNumber()
	 * @generated
	 * @ordered
	 */
	protected String departmentNumber = DEPARTMENT_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getEmployeeNumber() <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String EMPLOYEE_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEmployeeNumber() <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeNumber()
	 * @generated
	 * @ordered
	 */
	protected String employeeNumber = EMPLOYEE_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getEmployeeType() <em>Employee Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeType()
	 * @generated
	 * @ordered
	 */
	protected static final String EMPLOYEE_TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEmployeeType() <em>Employee Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeType()
	 * @generated
	 * @ordered
	 */
	protected String employeeType = EMPLOYEE_TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getGenerationQualifier() <em>Generation Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATION_QUALIFIER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGenerationQualifier() <em>Generation Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationQualifier()
	 * @generated
	 * @ordered
	 */
	protected String generationQualifier = GENERATION_QUALIFIER_EDEFAULT;
	/**
	 * The default value of the '{@link #getGivenName() <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGivenName()
	 * @generated
	 * @ordered
	 */
	protected static final String GIVEN_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGivenName() <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGivenName()
	 * @generated
	 * @ordered
	 */
	protected String givenName = GIVEN_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getHomeFax() <em>Home Fax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomeFax()
	 * @generated
	 * @ordered
	 */
	protected static final String HOME_FAX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHomeFax() <em>Home Fax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomeFax()
	 * @generated
	 * @ordered
	 */
	protected String homeFax = HOME_FAX_EDEFAULT;
	/**
	 * The default value of the '{@link #getHomePhone() <em>Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomePhone()
	 * @generated
	 * @ordered
	 */
	protected static final String HOME_PHONE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHomePhone() <em>Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomePhone()
	 * @generated
	 * @ordered
	 */
	protected String homePhone = HOME_PHONE_EDEFAULT;
	/**
	 * The default value of the '{@link #getHomePostalAddress() <em>Home Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomePostalAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String HOME_POSTAL_ADDRESS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHomePostalAddress() <em>Home Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomePostalAddress()
	 * @generated
	 * @ordered
	 */
	protected String homePostalAddress = HOME_POSTAL_ADDRESS_EDEFAULT;
	/**
	 * The default value of the '{@link #getInitials() <em>Initials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitials()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIALS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInitials() <em>Initials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitials()
	 * @generated
	 * @ordered
	 */
	protected String initials = INITIALS_EDEFAULT;
	/**
	 * The default value of the '{@link #getJpegPhoto() <em>Jpeg Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJpegPhoto()
	 * @generated
	 * @ordered
	 */
	protected static final String JPEG_PHOTO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getJpegPhoto() <em>Jpeg Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJpegPhoto()
	 * @generated
	 * @ordered
	 */
	protected String jpegPhoto = JPEG_PHOTO_EDEFAULT;
	/**
	 * The default value of the '{@link #getLabeledURI() <em>Labeled URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabeledURI()
	 * @generated
	 * @ordered
	 */
	protected static final String LABELED_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLabeledURI() <em>Labeled URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabeledURI()
	 * @generated
	 * @ordered
	 */
	protected String labeledURI = LABELED_URI_EDEFAULT;
	/**
	 * The default value of the '{@link #getMail() <em>Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMail()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMail() <em>Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMail()
	 * @generated
	 * @ordered
	 */
	protected String mail = MAIL_EDEFAULT;
	/**
	 * The default value of the '{@link #getManager() <em>Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected String manager = MANAGER_EDEFAULT;
	/**
	 * The default value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected static final String MIDDLE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected String middleName = MIDDLE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getMobile() <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobile()
	 * @generated
	 * @ordered
	 */
	protected static final String MOBILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMobile() <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobile()
	 * @generated
	 * @ordered
	 */
	protected String mobile = MOBILE_EDEFAULT;
	/**
	 * The default value of the '{@link #getO() <em>O</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getO()
	 * @generated
	 * @ordered
	 */
	protected static final String O_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getO() <em>O</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getO()
	 * @generated
	 * @ordered
	 */
	protected String o = O_EDEFAULT;
	/**
	 * The default value of the '{@link #getOrganizationalStatus() <em>Organizational Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationalStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATIONAL_STATUS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOrganizationalStatus() <em>Organizational Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationalStatus()
	 * @generated
	 * @ordered
	 */
	protected String organizationalStatus = ORGANIZATIONAL_STATUS_EDEFAULT;
	/**
	 * The default value of the '{@link #getOtherMailbox() <em>Other Mailbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherMailbox()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_MAILBOX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOtherMailbox() <em>Other Mailbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherMailbox()
	 * @generated
	 * @ordered
	 */
	protected String otherMailbox = OTHER_MAILBOX_EDEFAULT;
	/**
	 * The default value of the '{@link #getPager() <em>Pager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPager()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPager() <em>Pager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPager()
	 * @generated
	 * @ordered
	 */
	protected String pager = PAGER_EDEFAULT;
	/**
	 * The default value of the '{@link #getPersonalTitle() <em>Personal Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonalTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSONAL_TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPersonalTitle() <em>Personal Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonalTitle()
	 * @generated
	 * @ordered
	 */
	protected String personalTitle = PERSONAL_TITLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoto()
	 * @generated
	 * @ordered
	 */
	protected static final String PHOTO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoto()
	 * @generated
	 * @ordered
	 */
	protected String photo = PHOTO_EDEFAULT;
	/**
	 * The default value of the '{@link #getPreferredLanguage() <em>Preferred Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFERRED_LANGUAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPreferredLanguage() <em>Preferred Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredLanguage()
	 * @generated
	 * @ordered
	 */
	protected String preferredLanguage = PREFERRED_LANGUAGE_EDEFAULT;
	/**
	 * The default value of the '{@link #getRoomNumber() <em>Room Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoomNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOM_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRoomNumber() <em>Room Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoomNumber()
	 * @generated
	 * @ordered
	 */
	protected String roomNumber = ROOM_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getSecretary() <em>Secretary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecretary()
	 * @generated
	 * @ordered
	 */
	protected static final String SECRETARY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSecretary() <em>Secretary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecretary()
	 * @generated
	 * @ordered
	 */
	protected String secretary = SECRETARY_EDEFAULT;
	/**
	 * The default value of the '{@link #getThumbnailLogo() <em>Thumbnail Logo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnailLogo()
	 * @generated
	 * @ordered
	 */
	protected static final String THUMBNAIL_LOGO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getThumbnailLogo() <em>Thumbnail Logo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnailLogo()
	 * @generated
	 * @ordered
	 */
	protected String thumbnailLogo = THUMBNAIL_LOGO_EDEFAULT;
	/**
	 * The default value of the '{@link #getThumbnailPhoto() <em>Thumbnail Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnailPhoto()
	 * @generated
	 * @ordered
	 */
	protected static final String THUMBNAIL_PHOTO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getThumbnailPhoto() <em>Thumbnail Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnailPhoto()
	 * @generated
	 * @ordered
	 */
	protected String thumbnailPhoto = THUMBNAIL_PHOTO_EDEFAULT;
	/**
	 * The default value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected String uid = UID_EDEFAULT;
	/**
	 * The default value of the '{@link #getUniqueIdentifier() <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIQUE_IDENTIFIER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUniqueIdentifier() <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String uniqueIdentifier = UNIQUE_IDENTIFIER_EDEFAULT;
	/**
	 * The default value of the '{@link #getUserCertificate() <em>User Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserCertificate()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_CERTIFICATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUserCertificate() <em>User Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserCertificate()
	 * @generated
	 * @ordered
	 */
	protected String userCertificate = USER_CERTIFICATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getUserPKCS12() <em>User PKCS12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPKCS12()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_PKCS12_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUserPKCS12() <em>User PKCS12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPKCS12()
	 * @generated
	 * @ordered
	 */
	protected String userPKCS12 = USER_PKCS12_EDEFAULT;
	/**
	 * The default value of the '{@link #getUserSMIMECertificate() <em>User SMIME Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserSMIMECertificate()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_SMIME_CERTIFICATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUserSMIMECertificate() <em>User SMIME Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserSMIMECertificate()
	 * @generated
	 * @ordered
	 */
	protected String userSMIMECertificate = USER_SMIME_CERTIFICATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getX500UniqueIdentifier() <em>X500 Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX500UniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String X500_UNIQUE_IDENTIFIER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getX500UniqueIdentifier() <em>X500 Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX500UniqueIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String x500UniqueIdentifier = X500_UNIQUE_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InetOrgPersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.INET_ORG_PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccessHint() {
		return accessHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessHint(String newAccessHint) {
		String oldAccessHint = accessHint;
		accessHint = newAccessHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__ACCESS_HINT, oldAccessHint, accessHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccountHint() {
		return accountHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountHint(String newAccountHint) {
		String oldAccountHint = accountHint;
		accountHint = newAccountHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT, oldAccountHint, accountHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAudio() {
		return audio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudio(String newAudio) {
		String oldAudio = audio;
		audio = newAudio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__AUDIO, oldAudio, audio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessCategory(String newBusinessCategory) {
		String oldBusinessCategory = businessCategory;
		businessCategory = newBusinessCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY, oldBusinessCategory, businessCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getC() {
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setC(String newC) {
		String oldC = c;
		c = newC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__C, oldC, c));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCarLicense() {
		return carLicense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCarLicense(String newCarLicense) {
		String oldCarLicense = carLicense;
		carLicense = newCarLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__CAR_LICENSE, oldCarLicense, carLicense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigPtr() {
		return configPtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigPtr(String newConfigPtr) {
		String oldConfigPtr = configPtr;
		configPtr = newConfigPtr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__CONFIG_PTR, oldConfigPtr, configPtr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepartmentNumber() {
		return departmentNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartmentNumber(String newDepartmentNumber) {
		String oldDepartmentNumber = departmentNumber;
		departmentNumber = newDepartmentNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER, oldDepartmentNumber, departmentNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployeeNumber(String newEmployeeNumber) {
		String oldEmployeeNumber = employeeNumber;
		employeeNumber = newEmployeeNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER, oldEmployeeNumber, employeeNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployeeType(String newEmployeeType) {
		String oldEmployeeType = employeeType;
		employeeType = newEmployeeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE, oldEmployeeType, employeeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGenerationQualifier() {
		return generationQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerationQualifier(String newGenerationQualifier) {
		String oldGenerationQualifier = generationQualifier;
		generationQualifier = newGenerationQualifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER, oldGenerationQualifier, generationQualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGivenName(String newGivenName) {
		String oldGivenName = givenName;
		givenName = newGivenName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__GIVEN_NAME, oldGivenName, givenName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomeFax() {
		return homeFax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomeFax(String newHomeFax) {
		String oldHomeFax = homeFax;
		homeFax = newHomeFax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__HOME_FAX, oldHomeFax, homeFax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomePhone(String newHomePhone) {
		String oldHomePhone = homePhone;
		homePhone = newHomePhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__HOME_PHONE, oldHomePhone, homePhone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomePostalAddress() {
		return homePostalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomePostalAddress(String newHomePostalAddress) {
		String oldHomePostalAddress = homePostalAddress;
		homePostalAddress = newHomePostalAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS, oldHomePostalAddress, homePostalAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitials(String newInitials) {
		String oldInitials = initials;
		initials = newInitials;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__INITIALS, oldInitials, initials));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJpegPhoto() {
		return jpegPhoto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJpegPhoto(String newJpegPhoto) {
		String oldJpegPhoto = jpegPhoto;
		jpegPhoto = newJpegPhoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__JPEG_PHOTO, oldJpegPhoto, jpegPhoto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabeledURI() {
		return labeledURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabeledURI(String newLabeledURI) {
		String oldLabeledURI = labeledURI;
		labeledURI = newLabeledURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__LABELED_URI, oldLabeledURI, labeledURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMail(String newMail) {
		String oldMail = mail;
		mail = newMail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__MAIL, oldMail, mail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(String newManager) {
		String oldManager = manager;
		manager = newManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__MANAGER, oldManager, manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddleName(String newMiddleName) {
		String oldMiddleName = middleName;
		middleName = newMiddleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__MIDDLE_NAME, oldMiddleName, middleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMobile(String newMobile) {
		String oldMobile = mobile;
		mobile = newMobile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__MOBILE, oldMobile, mobile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getO() {
		return o;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setO(String newO) {
		String oldO = o;
		o = newO;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__O, oldO, o));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrganizationalStatus() {
		return organizationalStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganizationalStatus(String newOrganizationalStatus) {
		String oldOrganizationalStatus = organizationalStatus;
		organizationalStatus = newOrganizationalStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS, oldOrganizationalStatus, organizationalStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOtherMailbox() {
		return otherMailbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherMailbox(String newOtherMailbox) {
		String oldOtherMailbox = otherMailbox;
		otherMailbox = newOtherMailbox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX, oldOtherMailbox, otherMailbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPager() {
		return pager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPager(String newPager) {
		String oldPager = pager;
		pager = newPager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__PAGER, oldPager, pager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersonalTitle() {
		return personalTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersonalTitle(String newPersonalTitle) {
		String oldPersonalTitle = personalTitle;
		personalTitle = newPersonalTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE, oldPersonalTitle, personalTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhoto(String newPhoto) {
		String oldPhoto = photo;
		photo = newPhoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__PHOTO, oldPhoto, photo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferredLanguage(String newPreferredLanguage) {
		String oldPreferredLanguage = preferredLanguage;
		preferredLanguage = newPreferredLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE, oldPreferredLanguage, preferredLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoomNumber(String newRoomNumber) {
		String oldRoomNumber = roomNumber;
		roomNumber = newRoomNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__ROOM_NUMBER, oldRoomNumber, roomNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecretary() {
		return secretary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecretary(String newSecretary) {
		String oldSecretary = secretary;
		secretary = newSecretary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__SECRETARY, oldSecretary, secretary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThumbnailLogo() {
		return thumbnailLogo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThumbnailLogo(String newThumbnailLogo) {
		String oldThumbnailLogo = thumbnailLogo;
		thumbnailLogo = newThumbnailLogo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO, oldThumbnailLogo, thumbnailLogo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThumbnailPhoto() {
		return thumbnailPhoto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThumbnailPhoto(String newThumbnailPhoto) {
		String oldThumbnailPhoto = thumbnailPhoto;
		thumbnailPhoto = newThumbnailPhoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO, oldThumbnailPhoto, thumbnailPhoto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUid(String newUid) {
		String oldUid = uid;
		uid = newUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__UID, oldUid, uid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUniqueIdentifier(String newUniqueIdentifier) {
		String oldUniqueIdentifier = uniqueIdentifier;
		uniqueIdentifier = newUniqueIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER, oldUniqueIdentifier, uniqueIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserCertificate() {
		return userCertificate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserCertificate(String newUserCertificate) {
		String oldUserCertificate = userCertificate;
		userCertificate = newUserCertificate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE, oldUserCertificate, userCertificate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserPKCS12() {
		return userPKCS12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserPKCS12(String newUserPKCS12) {
		String oldUserPKCS12 = userPKCS12;
		userPKCS12 = newUserPKCS12;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__USER_PKCS12, oldUserPKCS12, userPKCS12));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserSMIMECertificate() {
		return userSMIMECertificate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSMIMECertificate(String newUserSMIMECertificate) {
		String oldUserSMIMECertificate = userSMIMECertificate;
		userSMIMECertificate = newUserSMIMECertificate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE, oldUserSMIMECertificate, userSMIMECertificate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getX500UniqueIdentifier() {
		return x500UniqueIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX500UniqueIdentifier(String newX500UniqueIdentifier) {
		String oldX500UniqueIdentifier = x500UniqueIdentifier;
		x500UniqueIdentifier = newX500UniqueIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER, oldX500UniqueIdentifier, x500UniqueIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.INET_ORG_PERSON__ACCESS_HINT:
				return getAccessHint();
			case LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT:
				return getAccountHint();
			case LdapPackage.INET_ORG_PERSON__AUDIO:
				return getAudio();
			case LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY:
				return getBusinessCategory();
			case LdapPackage.INET_ORG_PERSON__C:
				return getC();
			case LdapPackage.INET_ORG_PERSON__CAR_LICENSE:
				return getCarLicense();
			case LdapPackage.INET_ORG_PERSON__CONFIG_PTR:
				return getConfigPtr();
			case LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER:
				return getDepartmentNumber();
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER:
				return getEmployeeNumber();
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE:
				return getEmployeeType();
			case LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER:
				return getGenerationQualifier();
			case LdapPackage.INET_ORG_PERSON__GIVEN_NAME:
				return getGivenName();
			case LdapPackage.INET_ORG_PERSON__HOME_FAX:
				return getHomeFax();
			case LdapPackage.INET_ORG_PERSON__HOME_PHONE:
				return getHomePhone();
			case LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS:
				return getHomePostalAddress();
			case LdapPackage.INET_ORG_PERSON__INITIALS:
				return getInitials();
			case LdapPackage.INET_ORG_PERSON__JPEG_PHOTO:
				return getJpegPhoto();
			case LdapPackage.INET_ORG_PERSON__LABELED_URI:
				return getLabeledURI();
			case LdapPackage.INET_ORG_PERSON__MAIL:
				return getMail();
			case LdapPackage.INET_ORG_PERSON__MANAGER:
				return getManager();
			case LdapPackage.INET_ORG_PERSON__MIDDLE_NAME:
				return getMiddleName();
			case LdapPackage.INET_ORG_PERSON__MOBILE:
				return getMobile();
			case LdapPackage.INET_ORG_PERSON__O:
				return getO();
			case LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS:
				return getOrganizationalStatus();
			case LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX:
				return getOtherMailbox();
			case LdapPackage.INET_ORG_PERSON__PAGER:
				return getPager();
			case LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE:
				return getPersonalTitle();
			case LdapPackage.INET_ORG_PERSON__PHOTO:
				return getPhoto();
			case LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE:
				return getPreferredLanguage();
			case LdapPackage.INET_ORG_PERSON__ROOM_NUMBER:
				return getRoomNumber();
			case LdapPackage.INET_ORG_PERSON__SECRETARY:
				return getSecretary();
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO:
				return getThumbnailLogo();
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO:
				return getThumbnailPhoto();
			case LdapPackage.INET_ORG_PERSON__UID:
				return getUid();
			case LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER:
				return getUniqueIdentifier();
			case LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE:
				return getUserCertificate();
			case LdapPackage.INET_ORG_PERSON__USER_PKCS12:
				return getUserPKCS12();
			case LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE:
				return getUserSMIMECertificate();
			case LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER:
				return getX500UniqueIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.INET_ORG_PERSON__ACCESS_HINT:
				setAccessHint((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT:
				setAccountHint((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__AUDIO:
				setAudio((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY:
				setBusinessCategory((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__C:
				setC((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__CAR_LICENSE:
				setCarLicense((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__CONFIG_PTR:
				setConfigPtr((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER:
				setDepartmentNumber((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER:
				setEmployeeNumber((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE:
				setEmployeeType((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER:
				setGenerationQualifier((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__GIVEN_NAME:
				setGivenName((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_FAX:
				setHomeFax((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_PHONE:
				setHomePhone((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS:
				setHomePostalAddress((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__INITIALS:
				setInitials((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__JPEG_PHOTO:
				setJpegPhoto((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__LABELED_URI:
				setLabeledURI((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__MAIL:
				setMail((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__MANAGER:
				setManager((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__MIDDLE_NAME:
				setMiddleName((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__MOBILE:
				setMobile((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__O:
				setO((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS:
				setOrganizationalStatus((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX:
				setOtherMailbox((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__PAGER:
				setPager((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE:
				setPersonalTitle((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__PHOTO:
				setPhoto((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE:
				setPreferredLanguage((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__ROOM_NUMBER:
				setRoomNumber((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__SECRETARY:
				setSecretary((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO:
				setThumbnailLogo((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO:
				setThumbnailPhoto((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__UID:
				setUid((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER:
				setUniqueIdentifier((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE:
				setUserCertificate((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_PKCS12:
				setUserPKCS12((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE:
				setUserSMIMECertificate((String)newValue);
				return;
			case LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER:
				setX500UniqueIdentifier((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LdapPackage.INET_ORG_PERSON__ACCESS_HINT:
				setAccessHint(ACCESS_HINT_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT:
				setAccountHint(ACCOUNT_HINT_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__AUDIO:
				setAudio(AUDIO_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY:
				setBusinessCategory(BUSINESS_CATEGORY_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__C:
				setC(C_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__CAR_LICENSE:
				setCarLicense(CAR_LICENSE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__CONFIG_PTR:
				setConfigPtr(CONFIG_PTR_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER:
				setDepartmentNumber(DEPARTMENT_NUMBER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER:
				setEmployeeNumber(EMPLOYEE_NUMBER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE:
				setEmployeeType(EMPLOYEE_TYPE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER:
				setGenerationQualifier(GENERATION_QUALIFIER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__GIVEN_NAME:
				setGivenName(GIVEN_NAME_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_FAX:
				setHomeFax(HOME_FAX_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_PHONE:
				setHomePhone(HOME_PHONE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS:
				setHomePostalAddress(HOME_POSTAL_ADDRESS_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__INITIALS:
				setInitials(INITIALS_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__JPEG_PHOTO:
				setJpegPhoto(JPEG_PHOTO_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__LABELED_URI:
				setLabeledURI(LABELED_URI_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__MAIL:
				setMail(MAIL_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__MANAGER:
				setManager(MANAGER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__MIDDLE_NAME:
				setMiddleName(MIDDLE_NAME_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__MOBILE:
				setMobile(MOBILE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__O:
				setO(O_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS:
				setOrganizationalStatus(ORGANIZATIONAL_STATUS_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX:
				setOtherMailbox(OTHER_MAILBOX_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__PAGER:
				setPager(PAGER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE:
				setPersonalTitle(PERSONAL_TITLE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__PHOTO:
				setPhoto(PHOTO_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE:
				setPreferredLanguage(PREFERRED_LANGUAGE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__ROOM_NUMBER:
				setRoomNumber(ROOM_NUMBER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__SECRETARY:
				setSecretary(SECRETARY_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO:
				setThumbnailLogo(THUMBNAIL_LOGO_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO:
				setThumbnailPhoto(THUMBNAIL_PHOTO_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__UID:
				setUid(UID_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER:
				setUniqueIdentifier(UNIQUE_IDENTIFIER_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE:
				setUserCertificate(USER_CERTIFICATE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_PKCS12:
				setUserPKCS12(USER_PKCS12_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE:
				setUserSMIMECertificate(USER_SMIME_CERTIFICATE_EDEFAULT);
				return;
			case LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER:
				setX500UniqueIdentifier(X500_UNIQUE_IDENTIFIER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LdapPackage.INET_ORG_PERSON__ACCESS_HINT:
				return ACCESS_HINT_EDEFAULT == null ? accessHint != null : !ACCESS_HINT_EDEFAULT.equals(accessHint);
			case LdapPackage.INET_ORG_PERSON__ACCOUNT_HINT:
				return ACCOUNT_HINT_EDEFAULT == null ? accountHint != null : !ACCOUNT_HINT_EDEFAULT.equals(accountHint);
			case LdapPackage.INET_ORG_PERSON__AUDIO:
				return AUDIO_EDEFAULT == null ? audio != null : !AUDIO_EDEFAULT.equals(audio);
			case LdapPackage.INET_ORG_PERSON__BUSINESS_CATEGORY:
				return BUSINESS_CATEGORY_EDEFAULT == null ? businessCategory != null : !BUSINESS_CATEGORY_EDEFAULT.equals(businessCategory);
			case LdapPackage.INET_ORG_PERSON__C:
				return C_EDEFAULT == null ? c != null : !C_EDEFAULT.equals(c);
			case LdapPackage.INET_ORG_PERSON__CAR_LICENSE:
				return CAR_LICENSE_EDEFAULT == null ? carLicense != null : !CAR_LICENSE_EDEFAULT.equals(carLicense);
			case LdapPackage.INET_ORG_PERSON__CONFIG_PTR:
				return CONFIG_PTR_EDEFAULT == null ? configPtr != null : !CONFIG_PTR_EDEFAULT.equals(configPtr);
			case LdapPackage.INET_ORG_PERSON__DEPARTMENT_NUMBER:
				return DEPARTMENT_NUMBER_EDEFAULT == null ? departmentNumber != null : !DEPARTMENT_NUMBER_EDEFAULT.equals(departmentNumber);
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_NUMBER:
				return EMPLOYEE_NUMBER_EDEFAULT == null ? employeeNumber != null : !EMPLOYEE_NUMBER_EDEFAULT.equals(employeeNumber);
			case LdapPackage.INET_ORG_PERSON__EMPLOYEE_TYPE:
				return EMPLOYEE_TYPE_EDEFAULT == null ? employeeType != null : !EMPLOYEE_TYPE_EDEFAULT.equals(employeeType);
			case LdapPackage.INET_ORG_PERSON__GENERATION_QUALIFIER:
				return GENERATION_QUALIFIER_EDEFAULT == null ? generationQualifier != null : !GENERATION_QUALIFIER_EDEFAULT.equals(generationQualifier);
			case LdapPackage.INET_ORG_PERSON__GIVEN_NAME:
				return GIVEN_NAME_EDEFAULT == null ? givenName != null : !GIVEN_NAME_EDEFAULT.equals(givenName);
			case LdapPackage.INET_ORG_PERSON__HOME_FAX:
				return HOME_FAX_EDEFAULT == null ? homeFax != null : !HOME_FAX_EDEFAULT.equals(homeFax);
			case LdapPackage.INET_ORG_PERSON__HOME_PHONE:
				return HOME_PHONE_EDEFAULT == null ? homePhone != null : !HOME_PHONE_EDEFAULT.equals(homePhone);
			case LdapPackage.INET_ORG_PERSON__HOME_POSTAL_ADDRESS:
				return HOME_POSTAL_ADDRESS_EDEFAULT == null ? homePostalAddress != null : !HOME_POSTAL_ADDRESS_EDEFAULT.equals(homePostalAddress);
			case LdapPackage.INET_ORG_PERSON__INITIALS:
				return INITIALS_EDEFAULT == null ? initials != null : !INITIALS_EDEFAULT.equals(initials);
			case LdapPackage.INET_ORG_PERSON__JPEG_PHOTO:
				return JPEG_PHOTO_EDEFAULT == null ? jpegPhoto != null : !JPEG_PHOTO_EDEFAULT.equals(jpegPhoto);
			case LdapPackage.INET_ORG_PERSON__LABELED_URI:
				return LABELED_URI_EDEFAULT == null ? labeledURI != null : !LABELED_URI_EDEFAULT.equals(labeledURI);
			case LdapPackage.INET_ORG_PERSON__MAIL:
				return MAIL_EDEFAULT == null ? mail != null : !MAIL_EDEFAULT.equals(mail);
			case LdapPackage.INET_ORG_PERSON__MANAGER:
				return MANAGER_EDEFAULT == null ? manager != null : !MANAGER_EDEFAULT.equals(manager);
			case LdapPackage.INET_ORG_PERSON__MIDDLE_NAME:
				return MIDDLE_NAME_EDEFAULT == null ? middleName != null : !MIDDLE_NAME_EDEFAULT.equals(middleName);
			case LdapPackage.INET_ORG_PERSON__MOBILE:
				return MOBILE_EDEFAULT == null ? mobile != null : !MOBILE_EDEFAULT.equals(mobile);
			case LdapPackage.INET_ORG_PERSON__O:
				return O_EDEFAULT == null ? o != null : !O_EDEFAULT.equals(o);
			case LdapPackage.INET_ORG_PERSON__ORGANIZATIONAL_STATUS:
				return ORGANIZATIONAL_STATUS_EDEFAULT == null ? organizationalStatus != null : !ORGANIZATIONAL_STATUS_EDEFAULT.equals(organizationalStatus);
			case LdapPackage.INET_ORG_PERSON__OTHER_MAILBOX:
				return OTHER_MAILBOX_EDEFAULT == null ? otherMailbox != null : !OTHER_MAILBOX_EDEFAULT.equals(otherMailbox);
			case LdapPackage.INET_ORG_PERSON__PAGER:
				return PAGER_EDEFAULT == null ? pager != null : !PAGER_EDEFAULT.equals(pager);
			case LdapPackage.INET_ORG_PERSON__PERSONAL_TITLE:
				return PERSONAL_TITLE_EDEFAULT == null ? personalTitle != null : !PERSONAL_TITLE_EDEFAULT.equals(personalTitle);
			case LdapPackage.INET_ORG_PERSON__PHOTO:
				return PHOTO_EDEFAULT == null ? photo != null : !PHOTO_EDEFAULT.equals(photo);
			case LdapPackage.INET_ORG_PERSON__PREFERRED_LANGUAGE:
				return PREFERRED_LANGUAGE_EDEFAULT == null ? preferredLanguage != null : !PREFERRED_LANGUAGE_EDEFAULT.equals(preferredLanguage);
			case LdapPackage.INET_ORG_PERSON__ROOM_NUMBER:
				return ROOM_NUMBER_EDEFAULT == null ? roomNumber != null : !ROOM_NUMBER_EDEFAULT.equals(roomNumber);
			case LdapPackage.INET_ORG_PERSON__SECRETARY:
				return SECRETARY_EDEFAULT == null ? secretary != null : !SECRETARY_EDEFAULT.equals(secretary);
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_LOGO:
				return THUMBNAIL_LOGO_EDEFAULT == null ? thumbnailLogo != null : !THUMBNAIL_LOGO_EDEFAULT.equals(thumbnailLogo);
			case LdapPackage.INET_ORG_PERSON__THUMBNAIL_PHOTO:
				return THUMBNAIL_PHOTO_EDEFAULT == null ? thumbnailPhoto != null : !THUMBNAIL_PHOTO_EDEFAULT.equals(thumbnailPhoto);
			case LdapPackage.INET_ORG_PERSON__UID:
				return UID_EDEFAULT == null ? uid != null : !UID_EDEFAULT.equals(uid);
			case LdapPackage.INET_ORG_PERSON__UNIQUE_IDENTIFIER:
				return UNIQUE_IDENTIFIER_EDEFAULT == null ? uniqueIdentifier != null : !UNIQUE_IDENTIFIER_EDEFAULT.equals(uniqueIdentifier);
			case LdapPackage.INET_ORG_PERSON__USER_CERTIFICATE:
				return USER_CERTIFICATE_EDEFAULT == null ? userCertificate != null : !USER_CERTIFICATE_EDEFAULT.equals(userCertificate);
			case LdapPackage.INET_ORG_PERSON__USER_PKCS12:
				return USER_PKCS12_EDEFAULT == null ? userPKCS12 != null : !USER_PKCS12_EDEFAULT.equals(userPKCS12);
			case LdapPackage.INET_ORG_PERSON__USER_SMIME_CERTIFICATE:
				return USER_SMIME_CERTIFICATE_EDEFAULT == null ? userSMIMECertificate != null : !USER_SMIME_CERTIFICATE_EDEFAULT.equals(userSMIMECertificate);
			case LdapPackage.INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER:
				return X500_UNIQUE_IDENTIFIER_EDEFAULT == null ? x500UniqueIdentifier != null : !X500_UNIQUE_IDENTIFIER_EDEFAULT.equals(x500UniqueIdentifier);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accessHint: "); //$NON-NLS-1$
		result.append(accessHint);
		result.append(", accountHint: "); //$NON-NLS-1$
		result.append(accountHint);
		result.append(", audio: "); //$NON-NLS-1$
		result.append(audio);
		result.append(", businessCategory: "); //$NON-NLS-1$
		result.append(businessCategory);
		result.append(", c: "); //$NON-NLS-1$
		result.append(c);
		result.append(", carLicense: "); //$NON-NLS-1$
		result.append(carLicense);
		result.append(", configPtr: "); //$NON-NLS-1$
		result.append(configPtr);
		result.append(", departmentNumber: "); //$NON-NLS-1$
		result.append(departmentNumber);
		result.append(", employeeNumber: "); //$NON-NLS-1$
		result.append(employeeNumber);
		result.append(", employeeType: "); //$NON-NLS-1$
		result.append(employeeType);
		result.append(", generationQualifier: "); //$NON-NLS-1$
		result.append(generationQualifier);
		result.append(", givenName: "); //$NON-NLS-1$
		result.append(givenName);
		result.append(", homeFax: "); //$NON-NLS-1$
		result.append(homeFax);
		result.append(", homePhone: "); //$NON-NLS-1$
		result.append(homePhone);
		result.append(", homePostalAddress: "); //$NON-NLS-1$
		result.append(homePostalAddress);
		result.append(", initials: "); //$NON-NLS-1$
		result.append(initials);
		result.append(", jpegPhoto: "); //$NON-NLS-1$
		result.append(jpegPhoto);
		result.append(", labeledURI: "); //$NON-NLS-1$
		result.append(labeledURI);
		result.append(", mail: "); //$NON-NLS-1$
		result.append(mail);
		result.append(", manager: "); //$NON-NLS-1$
		result.append(manager);
		result.append(", middleName: "); //$NON-NLS-1$
		result.append(middleName);
		result.append(", mobile: "); //$NON-NLS-1$
		result.append(mobile);
		result.append(", o: "); //$NON-NLS-1$
		result.append(o);
		result.append(", organizationalStatus: "); //$NON-NLS-1$
		result.append(organizationalStatus);
		result.append(", otherMailbox: "); //$NON-NLS-1$
		result.append(otherMailbox);
		result.append(", pager: "); //$NON-NLS-1$
		result.append(pager);
		result.append(", personalTitle: "); //$NON-NLS-1$
		result.append(personalTitle);
		result.append(", photo: "); //$NON-NLS-1$
		result.append(photo);
		result.append(", preferredLanguage: "); //$NON-NLS-1$
		result.append(preferredLanguage);
		result.append(", roomNumber: "); //$NON-NLS-1$
		result.append(roomNumber);
		result.append(", secretary: "); //$NON-NLS-1$
		result.append(secretary);
		result.append(", thumbnailLogo: "); //$NON-NLS-1$
		result.append(thumbnailLogo);
		result.append(", thumbnailPhoto: "); //$NON-NLS-1$
		result.append(thumbnailPhoto);
		result.append(", uid: "); //$NON-NLS-1$
		result.append(uid);
		result.append(", uniqueIdentifier: "); //$NON-NLS-1$
		result.append(uniqueIdentifier);
		result.append(", userCertificate: "); //$NON-NLS-1$
		result.append(userCertificate);
		result.append(", userPKCS12: "); //$NON-NLS-1$
		result.append(userPKCS12);
		result.append(", userSMIMECertificate: "); //$NON-NLS-1$
		result.append(userSMIMECertificate);
		result.append(", x500UniqueIdentifier: "); //$NON-NLS-1$
		result.append(x500UniqueIdentifier);
		result.append(')');
		return result.toString();
	}

} //InetOrgPersonImpl
