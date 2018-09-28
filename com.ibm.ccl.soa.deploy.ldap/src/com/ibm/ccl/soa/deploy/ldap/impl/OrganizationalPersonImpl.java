/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrganizationalPersonImpl.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Organizational Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getDestinationIndicator <em>Destination Indicator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getInternationalISDNNumber <em>International ISDN Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getL <em>L</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getOu <em>Ou</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getPostalAddress <em>Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getPostOfficeBox <em>Post Office Box</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getRegisteredAddress <em>Registered Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getSt <em>St</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getTelexNumber <em>Telex Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl#getX121address <em>X12 1address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrganizationalPersonImpl extends PersonImpl implements OrganizationalPerson {
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
	 * The default value of the '{@link #getOu() <em>Ou</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOu()
	 * @generated
	 * @ordered
	 */
	protected static final String OU_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOu() <em>Ou</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOu()
	 * @generated
	 * @ordered
	 */
	protected String ou = OU_EDEFAULT;
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
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;
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
	protected OrganizationalPersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.ORGANIZATIONAL_PERSON;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR, oldDestinationIndicator, destinationIndicator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER, oldFacsimileTelephoneNumber, facsimileTelephoneNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER, oldInternationalISDNNumber, internationalISDNNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__L, oldL, l));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOu() {
		return ou;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOu(String newOu) {
		String oldOu = ou;
		ou = newOu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__OU, oldOu, ou));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME, oldPhysicalDeliveryOfficeName, physicalDeliveryOfficeName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS, oldPostalAddress, postalAddress));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE, oldPostalCode, postalCode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX, oldPostOfficeBox, postOfficeBox));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD, oldPreferredDeliveryMethod, preferredDeliveryMethod));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS, oldRegisteredAddress, registeredAddress));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__ST, oldSt, st));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__STREET, oldStreet, street));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER, oldTeletexTerminalIdentifier, teletexTerminalIdentifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER, oldTelexNumber, telexNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS, oldX121address, x121address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR:
				return getDestinationIndicator();
			case LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER:
				return getFacsimileTelephoneNumber();
			case LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER:
				return getInternationalISDNNumber();
			case LdapPackage.ORGANIZATIONAL_PERSON__L:
				return getL();
			case LdapPackage.ORGANIZATIONAL_PERSON__OU:
				return getOu();
			case LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
				return getPhysicalDeliveryOfficeName();
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS:
				return getPostalAddress();
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE:
				return getPostalCode();
			case LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX:
				return getPostOfficeBox();
			case LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD:
				return getPreferredDeliveryMethod();
			case LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS:
				return getRegisteredAddress();
			case LdapPackage.ORGANIZATIONAL_PERSON__ST:
				return getSt();
			case LdapPackage.ORGANIZATIONAL_PERSON__STREET:
				return getStreet();
			case LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER:
				return getTeletexTerminalIdentifier();
			case LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER:
				return getTelexNumber();
			case LdapPackage.ORGANIZATIONAL_PERSON__TITLE:
				return getTitle();
			case LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS:
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
			case LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR:
				setDestinationIndicator((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER:
				setFacsimileTelephoneNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER:
				setInternationalISDNNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__L:
				setL((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__OU:
				setOu((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
				setPhysicalDeliveryOfficeName((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS:
				setPostalAddress((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX:
				setPostOfficeBox((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD:
				setPreferredDeliveryMethod((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS:
				setRegisteredAddress((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__ST:
				setSt((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__STREET:
				setStreet((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER:
				setTeletexTerminalIdentifier((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER:
				setTelexNumber((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TITLE:
				setTitle((String)newValue);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS:
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
			case LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR:
				setDestinationIndicator(DESTINATION_INDICATOR_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER:
				setFacsimileTelephoneNumber(FACSIMILE_TELEPHONE_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER:
				setInternationalISDNNumber(INTERNATIONAL_ISDN_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__L:
				setL(L_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__OU:
				setOu(OU_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
				setPhysicalDeliveryOfficeName(PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS:
				setPostalAddress(POSTAL_ADDRESS_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX:
				setPostOfficeBox(POST_OFFICE_BOX_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD:
				setPreferredDeliveryMethod(PREFERRED_DELIVERY_METHOD_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS:
				setRegisteredAddress(REGISTERED_ADDRESS_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__ST:
				setSt(ST_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER:
				setTeletexTerminalIdentifier(TELETEX_TERMINAL_IDENTIFIER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER:
				setTelexNumber(TELEX_NUMBER_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS:
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
			case LdapPackage.ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR:
				return DESTINATION_INDICATOR_EDEFAULT == null ? destinationIndicator != null : !DESTINATION_INDICATOR_EDEFAULT.equals(destinationIndicator);
			case LdapPackage.ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER:
				return FACSIMILE_TELEPHONE_NUMBER_EDEFAULT == null ? facsimileTelephoneNumber != null : !FACSIMILE_TELEPHONE_NUMBER_EDEFAULT.equals(facsimileTelephoneNumber);
			case LdapPackage.ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER:
				return INTERNATIONAL_ISDN_NUMBER_EDEFAULT == null ? internationalISDNNumber != null : !INTERNATIONAL_ISDN_NUMBER_EDEFAULT.equals(internationalISDNNumber);
			case LdapPackage.ORGANIZATIONAL_PERSON__L:
				return L_EDEFAULT == null ? l != null : !L_EDEFAULT.equals(l);
			case LdapPackage.ORGANIZATIONAL_PERSON__OU:
				return OU_EDEFAULT == null ? ou != null : !OU_EDEFAULT.equals(ou);
			case LdapPackage.ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME:
				return PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT == null ? physicalDeliveryOfficeName != null : !PHYSICAL_DELIVERY_OFFICE_NAME_EDEFAULT.equals(physicalDeliveryOfficeName);
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_ADDRESS:
				return POSTAL_ADDRESS_EDEFAULT == null ? postalAddress != null : !POSTAL_ADDRESS_EDEFAULT.equals(postalAddress);
			case LdapPackage.ORGANIZATIONAL_PERSON__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case LdapPackage.ORGANIZATIONAL_PERSON__POST_OFFICE_BOX:
				return POST_OFFICE_BOX_EDEFAULT == null ? postOfficeBox != null : !POST_OFFICE_BOX_EDEFAULT.equals(postOfficeBox);
			case LdapPackage.ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD:
				return PREFERRED_DELIVERY_METHOD_EDEFAULT == null ? preferredDeliveryMethod != null : !PREFERRED_DELIVERY_METHOD_EDEFAULT.equals(preferredDeliveryMethod);
			case LdapPackage.ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS:
				return REGISTERED_ADDRESS_EDEFAULT == null ? registeredAddress != null : !REGISTERED_ADDRESS_EDEFAULT.equals(registeredAddress);
			case LdapPackage.ORGANIZATIONAL_PERSON__ST:
				return ST_EDEFAULT == null ? st != null : !ST_EDEFAULT.equals(st);
			case LdapPackage.ORGANIZATIONAL_PERSON__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case LdapPackage.ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER:
				return TELETEX_TERMINAL_IDENTIFIER_EDEFAULT == null ? teletexTerminalIdentifier != null : !TELETEX_TERMINAL_IDENTIFIER_EDEFAULT.equals(teletexTerminalIdentifier);
			case LdapPackage.ORGANIZATIONAL_PERSON__TELEX_NUMBER:
				return TELEX_NUMBER_EDEFAULT == null ? telexNumber != null : !TELEX_NUMBER_EDEFAULT.equals(telexNumber);
			case LdapPackage.ORGANIZATIONAL_PERSON__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case LdapPackage.ORGANIZATIONAL_PERSON__X121ADDRESS:
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
		result.append(" (destinationIndicator: "); //$NON-NLS-1$
		result.append(destinationIndicator);
		result.append(", facsimileTelephoneNumber: "); //$NON-NLS-1$
		result.append(facsimileTelephoneNumber);
		result.append(", internationalISDNNumber: "); //$NON-NLS-1$
		result.append(internationalISDNNumber);
		result.append(", l: "); //$NON-NLS-1$
		result.append(l);
		result.append(", ou: "); //$NON-NLS-1$
		result.append(ou);
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
		result.append(", st: "); //$NON-NLS-1$
		result.append(st);
		result.append(", street: "); //$NON-NLS-1$
		result.append(street);
		result.append(", teletexTerminalIdentifier: "); //$NON-NLS-1$
		result.append(teletexTerminalIdentifier);
		result.append(", telexNumber: "); //$NON-NLS-1$
		result.append(telexNumber);
		result.append(", title: "); //$NON-NLS-1$
		result.append(title);
		result.append(", x121address: "); //$NON-NLS-1$
		result.append(x121address);
		result.append(')');
		return result.toString();
	}

} //OrganizationalPersonImpl
