/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrganizationImpl.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.Organization;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Organization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getBusinessCategory <em>Business Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getDestinationIndicator <em>Destination Indicator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getInternationalISDNNumber <em>International ISDN Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getL <em>L</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getO <em>O</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getPostalAddress <em>Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getPostOfficeBox <em>Post Office Box</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getRegisteredAddress <em>Registered Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getSearchGuide <em>Search Guide</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getSeeAlso <em>See Also</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getSt <em>St</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getTelephoneNumber <em>Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getTelexNumber <em>Telex Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getUserPassword <em>User Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl#getX121address <em>X12 1address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrganizationImpl extends TopImpl implements Organization {
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
	 * The default value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION1_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected String description1 = DESCRIPTION1_EDEFAULT;
	/**
	 * The default value of the '{@link #getDestinationIndicator() <em>Destination Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationIndicator()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_INDICATOR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDestinationIndicator() <em>Destination Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationIndicator()
	 * @generated
	 * @ordered
	 */
	protected String destinationIndicator = DESTINATION_INDICATOR_EDEFAULT;
	/**
	 * The default value of the '{@link #getFacsimileTelephoneNumber() <em>Facsimile Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacsimileTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String FACSIMILE_TELEPHONE_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFacsimileTelephoneNumber() <em>Facsimile Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacsimileTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String facsimileTelephoneNumber = FACSIMILE_TELEPHONE_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getInternationalISDNNumber() <em>International ISDN Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternationalISDNNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERNATIONAL_ISDN_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInternationalISDNNumber() <em>International ISDN Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternationalISDNNumber()
	 * @generated
	 * @ordered
	 */
	protected String internationalISDNNumber = INTERNATIONAL_ISDN_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getL() <em>L</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL()
	 * @generated
	 * @ordered
	 */
	protected static final String L_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getL() <em>L</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL()
	 * @generated
	 * @ordered
	 */
	protected String l = L_EDEFAULT;
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
	 * The default value of the '{@link #getPhysicalDeliveryOfficeName() <em>Physical Delivery Office Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalDeliveryOfficeName()
	 * @generated
	 * @ordered
	 */
	protected static final String PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPhysicalDeliveryOfficeName() <em>Physical Delivery Office Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalDeliveryOfficeName()
	 * @generated
	 * @ordered
	 */
	protected String physicalDeliveryOfficeName = PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getPostalAddress() <em>Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_ADDRESS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPostalAddress() <em>Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalAddress()
	 * @generated
	 * @ordered
	 */
	protected String postalAddress = POSTAL_ADDRESS_EDEFAULT;
	/**
	 * The default value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_CODE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected String postalCode = POSTAL_CODE_EDEFAULT;
	/**
	 * The default value of the '{@link #getPostOfficeBox() <em>Post Office Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostOfficeBox()
	 * @generated
	 * @ordered
	 */
	protected static final String POST_OFFICE_BOX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPostOfficeBox() <em>Post Office Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostOfficeBox()
	 * @generated
	 * @ordered
	 */
	protected String postOfficeBox = POST_OFFICE_BOX_EDEFAULT;
	/**
	 * The default value of the '{@link #getPreferredDeliveryMethod() <em>Preferred Delivery Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredDeliveryMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFERRED_DELIVERY_METHOD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPreferredDeliveryMethod() <em>Preferred Delivery Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredDeliveryMethod()
	 * @generated
	 * @ordered
	 */
	protected String preferredDeliveryMethod = PREFERRED_DELIVERY_METHOD_EDEFAULT;
	/**
	 * The default value of the '{@link #getRegisteredAddress() <em>Registered Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisteredAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTERED_ADDRESS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRegisteredAddress() <em>Registered Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisteredAddress()
	 * @generated
	 * @ordered
	 */
	protected String registeredAddress = REGISTERED_ADDRESS_EDEFAULT;
	/**
	 * The default value of the '{@link #getSearchGuide() <em>Search Guide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchGuide()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_GUIDE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSearchGuide() <em>Search Guide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchGuide()
	 * @generated
	 * @ordered
	 */
	protected String searchGuide = SEARCH_GUIDE_EDEFAULT;
	/**
	 * The default value of the '{@link #getSeeAlso() <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeeAlso()
	 * @generated
	 * @ordered
	 */
	protected static final String SEE_ALSO_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSeeAlso() <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeeAlso()
	 * @generated
	 * @ordered
	 */
	protected String seeAlso = SEE_ALSO_EDEFAULT;
	/**
	 * The default value of the '{@link #getSt() <em>St</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSt()
	 * @generated
	 * @ordered
	 */
	protected static final String ST_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSt() <em>St</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSt()
	 * @generated
	 * @ordered
	 */
	protected String st = ST_EDEFAULT;
	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;
	/**
	 * The default value of the '{@link #getTelephoneNumber() <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String TELEPHONE_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTelephoneNumber() <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String telephoneNumber = TELEPHONE_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getTeletexTerminalIdentifier() <em>Teletex Terminal Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeletexTerminalIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String TELETEX_TERMINAL_IDENTIFIER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTeletexTerminalIdentifier() <em>Teletex Terminal Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeletexTerminalIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String teletexTerminalIdentifier = TELETEX_TERMINAL_IDENTIFIER_EDEFAULT;
	/**
	 * The default value of the '{@link #getTelexNumber() <em>Telex Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelexNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String TELEX_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTelexNumber() <em>Telex Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelexNumber()
	 * @generated
	 * @ordered
	 */
	protected String telexNumber = TELEX_NUMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getUserPassword() <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_PASSWORD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUserPassword() <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected String userPassword = USER_PASSWORD_EDEFAULT;
	/**
	 * The default value of the '{@link #getX121address() <em>X12 1address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX121address()
	 * @generated
	 * @ordered
	 */
	protected static final String X121ADDRESS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getX121address() <em>X12 1address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX121address()
	 * @generated
	 * @ordered
	 */
	protected String x121address = X121ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrganizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.ORGANIZATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__BUSINESS_CATEGORY, oldBusinessCategory, businessCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription1() {
		return description1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription1(String newDescription1) {
		String oldDescription1 = description1;
		description1 = newDescription1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestinationIndicator() {
		return destinationIndicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationIndicator(String newDestinationIndicator) {
		String oldDestinationIndicator = destinationIndicator;
		destinationIndicator = newDestinationIndicator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__DESTINATION_INDICATOR, oldDestinationIndicator, destinationIndicator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacsimileTelephoneNumber() {
		return facsimileTelephoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacsimileTelephoneNumber(String newFacsimileTelephoneNumber) {
		String oldFacsimileTelephoneNumber = facsimileTelephoneNumber;
		facsimileTelephoneNumber = newFacsimileTelephoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER, oldFacsimileTelephoneNumber, facsimileTelephoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternationalISDNNumber() {
		return internationalISDNNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternationalISDNNumber(String newInternationalISDNNumber) {
		String oldInternationalISDNNumber = internationalISDNNumber;
		internationalISDNNumber = newInternationalISDNNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__INTERNATIONAL_ISDN_NUMBER, oldInternationalISDNNumber, internationalISDNNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getL() {
		return l;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL(String newL) {
		String oldL = l;
		l = newL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__L, oldL, l));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__O, oldO, o));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhysicalDeliveryOfficeName() {
		return physicalDeliveryOfficeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalDeliveryOfficeName(String newPhysicalDeliveryOfficeName) {
		String oldPhysicalDeliveryOfficeName = physicalDeliveryOfficeName;
		physicalDeliveryOfficeName = newPhysicalDeliveryOfficeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME, oldPhysicalDeliveryOfficeName, physicalDeliveryOfficeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalAddress(String newPostalAddress) {
		String oldPostalAddress = postalAddress;
		postalAddress = newPostalAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__POSTAL_ADDRESS, oldPostalAddress, postalAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(String newPostalCode) {
		String oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__POSTAL_CODE, oldPostalCode, postalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostOfficeBox(String newPostOfficeBox) {
		String oldPostOfficeBox = postOfficeBox;
		postOfficeBox = newPostOfficeBox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__POST_OFFICE_BOX, oldPostOfficeBox, postOfficeBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreferredDeliveryMethod() {
		return preferredDeliveryMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferredDeliveryMethod(String newPreferredDeliveryMethod) {
		String oldPreferredDeliveryMethod = preferredDeliveryMethod;
		preferredDeliveryMethod = newPreferredDeliveryMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__PREFERRED_DELIVERY_METHOD, oldPreferredDeliveryMethod, preferredDeliveryMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegisteredAddress() {
		return registeredAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegisteredAddress(String newRegisteredAddress) {
		String oldRegisteredAddress = registeredAddress;
		registeredAddress = newRegisteredAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__REGISTERED_ADDRESS, oldRegisteredAddress, registeredAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchGuide() {
		return searchGuide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchGuide(String newSearchGuide) {
		String oldSearchGuide = searchGuide;
		searchGuide = newSearchGuide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__SEARCH_GUIDE, oldSearchGuide, searchGuide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeeAlso() {
		return seeAlso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeeAlso(String newSeeAlso) {
		String oldSeeAlso = seeAlso;
		seeAlso = newSeeAlso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__SEE_ALSO, oldSeeAlso, seeAlso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSt() {
		return st;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSt(String newSt) {
		String oldSt = st;
		st = newSt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__ST, oldSt, st));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTelephoneNumber(String newTelephoneNumber) {
		String oldTelephoneNumber = telephoneNumber;
		telephoneNumber = newTelephoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__TELEPHONE_NUMBER, oldTelephoneNumber, telephoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTeletexTerminalIdentifier() {
		return teletexTerminalIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeletexTerminalIdentifier(String newTeletexTerminalIdentifier) {
		String oldTeletexTerminalIdentifier = teletexTerminalIdentifier;
		teletexTerminalIdentifier = newTeletexTerminalIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER, oldTeletexTerminalIdentifier, teletexTerminalIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTelexNumber() {
		return telexNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTelexNumber(String newTelexNumber) {
		String oldTelexNumber = telexNumber;
		telexNumber = newTelexNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__TELEX_NUMBER, oldTelexNumber, telexNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserPassword(String newUserPassword) {
		String oldUserPassword = userPassword;
		userPassword = newUserPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__USER_PASSWORD, oldUserPassword, userPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getX121address() {
		return x121address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX121address(String newX121address) {
		String oldX121address = x121address;
		x121address = newX121address;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATION__X121ADDRESS, oldX121address, x121address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.ORGANIZATION__BUSINESS_CATEGORY:
				return getBusinessCategory();
			case LdapPackage.ORGANIZATION__DESCRIPTION1:
				return getDescription1();
			case LdapPackage.ORGANIZATION__DESTINATION_INDICATOR:
				return getDestinationIndicator();
			case LdapPackage.ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER:
				return getFacsimileTelephoneNumber();
			case LdapPackage.ORGANIZATION__INTERNATIONAL_ISDN_NUMBER:
				return getInternationalISDNNumber();
			case LdapPackage.ORGANIZATION__L:
				return getL();
			case LdapPackage.ORGANIZATION__O:
				return getO();
			case LdapPackage.ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME:
				return getPhysicalDeliveryOfficeName();
			case LdapPackage.ORGANIZATION__POSTAL_ADDRESS:
				return getPostalAddress();
			case LdapPackage.ORGANIZATION__POSTAL_CODE:
				return getPostalCode();
			case LdapPackage.ORGANIZATION__POST_OFFICE_BOX:
				return getPostOfficeBox();
			case LdapPackage.ORGANIZATION__PREFERRED_DELIVERY_METHOD:
				return getPreferredDeliveryMethod();
			case LdapPackage.ORGANIZATION__REGISTERED_ADDRESS:
				return getRegisteredAddress();
			case LdapPackage.ORGANIZATION__SEARCH_GUIDE:
				return getSearchGuide();
			case LdapPackage.ORGANIZATION__SEE_ALSO:
				return getSeeAlso();
			case LdapPackage.ORGANIZATION__ST:
				return getSt();
			case LdapPackage.ORGANIZATION__STREET:
				return getStreet();
			case LdapPackage.ORGANIZATION__TELEPHONE_NUMBER:
				return getTelephoneNumber();
			case LdapPackage.ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER:
				return getTeletexTerminalIdentifier();
			case LdapPackage.ORGANIZATION__TELEX_NUMBER:
				return getTelexNumber();
			case LdapPackage.ORGANIZATION__USER_PASSWORD:
				return getUserPassword();
			case LdapPackage.ORGANIZATION__X121ADDRESS:
				return getX121address();
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
			case LdapPackage.ORGANIZATION__BUSINESS_CATEGORY:
				setBusinessCategory((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__DESCRIPTION1:
				setDescription1((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__DESTINATION_INDICATOR:
				setDestinationIndicator((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER:
				setFacsimileTelephoneNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__INTERNATIONAL_ISDN_NUMBER:
				setInternationalISDNNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__L:
				setL((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__O:
				setO((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME:
				setPhysicalDeliveryOfficeName((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__POSTAL_ADDRESS:
				setPostalAddress((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__POST_OFFICE_BOX:
				setPostOfficeBox((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__PREFERRED_DELIVERY_METHOD:
				setPreferredDeliveryMethod((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__REGISTERED_ADDRESS:
				setRegisteredAddress((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__SEARCH_GUIDE:
				setSearchGuide((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__SEE_ALSO:
				setSeeAlso((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__ST:
				setSt((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__STREET:
				setStreet((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__TELEPHONE_NUMBER:
				setTelephoneNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER:
				setTeletexTerminalIdentifier((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__TELEX_NUMBER:
				setTelexNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__USER_PASSWORD:
				setUserPassword((String)newValue);
				return;
			case LdapPackage.ORGANIZATION__X121ADDRESS:
				setX121address((String)newValue);
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
			case LdapPackage.ORGANIZATION__BUSINESS_CATEGORY:
				setBusinessCategory(BUSINESS_CATEGORY_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__DESTINATION_INDICATOR:
				setDestinationIndicator(DESTINATION_INDICATOR_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER:
				setFacsimileTelephoneNumber(FACSIMILE_TELEPHONE_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__INTERNATIONAL_ISDN_NUMBER:
				setInternationalISDNNumber(INTERNATIONAL_ISDN_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__L:
				setL(L_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__O:
				setO(O_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME:
				setPhysicalDeliveryOfficeName(PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__POSTAL_ADDRESS:
				setPostalAddress(POSTAL_ADDRESS_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__POST_OFFICE_BOX:
				setPostOfficeBox(POST_OFFICE_BOX_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__PREFERRED_DELIVERY_METHOD:
				setPreferredDeliveryMethod(PREFERRED_DELIVERY_METHOD_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__REGISTERED_ADDRESS:
				setRegisteredAddress(REGISTERED_ADDRESS_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__SEARCH_GUIDE:
				setSearchGuide(SEARCH_GUIDE_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__SEE_ALSO:
				setSeeAlso(SEE_ALSO_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__ST:
				setSt(ST_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__TELEPHONE_NUMBER:
				setTelephoneNumber(TELEPHONE_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER:
				setTeletexTerminalIdentifier(TELETEX_TERMINAL_IDENTIFIER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__TELEX_NUMBER:
				setTelexNumber(TELEX_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__USER_PASSWORD:
				setUserPassword(USER_PASSWORD_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATION__X121ADDRESS:
				setX121address(X121ADDRESS_EDEFAULT);
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
			case LdapPackage.ORGANIZATION__BUSINESS_CATEGORY:
				return BUSINESS_CATEGORY_EDEFAULT == null ? businessCategory != null : !BUSINESS_CATEGORY_EDEFAULT.equals(businessCategory);
			case LdapPackage.ORGANIZATION__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case LdapPackage.ORGANIZATION__DESTINATION_INDICATOR:
				return DESTINATION_INDICATOR_EDEFAULT == null ? destinationIndicator != null : !DESTINATION_INDICATOR_EDEFAULT.equals(destinationIndicator);
			case LdapPackage.ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER:
				return FACSIMILE_TELEPHONE_NUMBER_EDEFAULT == null ? facsimileTelephoneNumber != null : !FACSIMILE_TELEPHONE_NUMBER_EDEFAULT.equals(facsimileTelephoneNumber);
			case LdapPackage.ORGANIZATION__INTERNATIONAL_ISDN_NUMBER:
				return INTERNATIONAL_ISDN_NUMBER_EDEFAULT == null ? internationalISDNNumber != null : !INTERNATIONAL_ISDN_NUMBER_EDEFAULT.equals(internationalISDNNumber);
			case LdapPackage.ORGANIZATION__L:
				return L_EDEFAULT == null ? l != null : !L_EDEFAULT.equals(l);
			case LdapPackage.ORGANIZATION__O:
				return O_EDEFAULT == null ? o != null : !O_EDEFAULT.equals(o);
			case LdapPackage.ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME:
				return PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT == null ? physicalDeliveryOfficeName != null : !PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT.equals(physicalDeliveryOfficeName);
			case LdapPackage.ORGANIZATION__POSTAL_ADDRESS:
				return POSTAL_ADDRESS_EDEFAULT == null ? postalAddress != null : !POSTAL_ADDRESS_EDEFAULT.equals(postalAddress);
			case LdapPackage.ORGANIZATION__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case LdapPackage.ORGANIZATION__POST_OFFICE_BOX:
				return POST_OFFICE_BOX_EDEFAULT == null ? postOfficeBox != null : !POST_OFFICE_BOX_EDEFAULT.equals(postOfficeBox);
			case LdapPackage.ORGANIZATION__PREFERRED_DELIVERY_METHOD:
				return PREFERRED_DELIVERY_METHOD_EDEFAULT == null ? preferredDeliveryMethod != null : !PREFERRED_DELIVERY_METHOD_EDEFAULT.equals(preferredDeliveryMethod);
			case LdapPackage.ORGANIZATION__REGISTERED_ADDRESS:
				return REGISTERED_ADDRESS_EDEFAULT == null ? registeredAddress != null : !REGISTERED_ADDRESS_EDEFAULT.equals(registeredAddress);
			case LdapPackage.ORGANIZATION__SEARCH_GUIDE:
				return SEARCH_GUIDE_EDEFAULT == null ? searchGuide != null : !SEARCH_GUIDE_EDEFAULT.equals(searchGuide);
			case LdapPackage.ORGANIZATION__SEE_ALSO:
				return SEE_ALSO_EDEFAULT == null ? seeAlso != null : !SEE_ALSO_EDEFAULT.equals(seeAlso);
			case LdapPackage.ORGANIZATION__ST:
				return ST_EDEFAULT == null ? st != null : !ST_EDEFAULT.equals(st);
			case LdapPackage.ORGANIZATION__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case LdapPackage.ORGANIZATION__TELEPHONE_NUMBER:
				return TELEPHONE_NUMBER_EDEFAULT == null ? telephoneNumber != null : !TELEPHONE_NUMBER_EDEFAULT.equals(telephoneNumber);
			case LdapPackage.ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER:
				return TELETEX_TERMINAL_IDENTIFIER_EDEFAULT == null ? teletexTerminalIdentifier != null : !TELETEX_TERMINAL_IDENTIFIER_EDEFAULT.equals(teletexTerminalIdentifier);
			case LdapPackage.ORGANIZATION__TELEX_NUMBER:
				return TELEX_NUMBER_EDEFAULT == null ? telexNumber != null : !TELEX_NUMBER_EDEFAULT.equals(telexNumber);
			case LdapPackage.ORGANIZATION__USER_PASSWORD:
				return USER_PASSWORD_EDEFAULT == null ? userPassword != null : !USER_PASSWORD_EDEFAULT.equals(userPassword);
			case LdapPackage.ORGANIZATION__X121ADDRESS:
				return X121ADDRESS_EDEFAULT == null ? x121address != null : !X121ADDRESS_EDEFAULT.equals(x121address);
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
		result.append(" (businessCategory: "); //$NON-NLS-1$
		result.append(businessCategory);
		result.append(", description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", destinationIndicator: "); //$NON-NLS-1$
		result.append(destinationIndicator);
		result.append(", facsimileTelephoneNumber: "); //$NON-NLS-1$
		result.append(facsimileTelephoneNumber);
		result.append(", internationalISDNNumber: "); //$NON-NLS-1$
		result.append(internationalISDNNumber);
		result.append(", l: "); //$NON-NLS-1$
		result.append(l);
		result.append(", o: "); //$NON-NLS-1$
		result.append(o);
		result.append(", physicalDeliveryOfficeName: "); //$NON-NLS-1$
		result.append(physicalDeliveryOfficeName);
		result.append(", postalAddress: "); //$NON-NLS-1$
		result.append(postalAddress);
		result.append(", postalCode: "); //$NON-NLS-1$
		result.append(postalCode);
		result.append(", postOfficeBox: "); //$NON-NLS-1$
		result.append(postOfficeBox);
		result.append(", preferredDeliveryMethod: "); //$NON-NLS-1$
		result.append(preferredDeliveryMethod);
		result.append(", registeredAddress: "); //$NON-NLS-1$
		result.append(registeredAddress);
		result.append(", searchGuide: "); //$NON-NLS-1$
		result.append(searchGuide);
		result.append(", seeAlso: "); //$NON-NLS-1$
		result.append(seeAlso);
		result.append(", st: "); //$NON-NLS-1$
		result.append(st);
		result.append(", street: "); //$NON-NLS-1$
		result.append(street);
		result.append(", telephoneNumber: "); //$NON-NLS-1$
		result.append(telephoneNumber);
		result.append(", teletexTerminalIdentifier: "); //$NON-NLS-1$
		result.append(teletexTerminalIdentifier);
		result.append(", telexNumber: "); //$NON-NLS-1$
		result.append(telexNumber);
		result.append(", userPassword: "); //$NON-NLS-1$
		result.append(userPassword);
		result.append(", x121address: "); //$NON-NLS-1$
		result.append(x121address);
		result.append(')');
		return result.toString();
	}

} //OrganizationImpl
