/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrganizationalPerson.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Organizational Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     The 'organizationalPerson' object class is the basis of an entry that
 *                     represents a person in relation to an organization. (Source: X.521
 *                     [X.521])
 *                 </p>
 *                 <p>
 *                     An 'organizationalPerson' object MAY have the following attributes:
 *                     <menu>
 *                         <li>title</li>
 *                         <li>x121Address</li>
 *                         <li>registeredAddress</li>
 *                         <li>destinationIndicator</li>
 *                         <li>preferredDeliveryMethod</li>
 *                         <li>telexNumber</li>
 *                         <li>teletexTerminalIdentifier</li>
 *                         <li>telephoneNumber</li>
 *                         <li>internationalISDNNumber</li>
 *                         <li>facsimileTelephoneNumber</li>
 *                         <li>street</li>
 *                         <li>postOfficeBox</li>
 *                         <li>postalCode</li>
 *                         <li>postalAddress</li>
 *                         <li>physicalDeliveryOfficeName</li>
 *                         <li>ou</li>
 *                         <li>st</li>
 *                         <li>l</li>
 *                     </menu>
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getDestinationIndicator <em>Destination Indicator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getInternationalISDNNumber <em>International ISDN Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getL <em>L</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getOu <em>Ou</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalAddress <em>Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostOfficeBox <em>Post Office Box</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getRegisteredAddress <em>Registered Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getSt <em>St</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getStreet <em>Street</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTelexNumber <em>Telex Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTitle <em>Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getX121address <em>X12 1address</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson()
 * @model extendedMetaData="name='OrganizationalPerson' kind='elementOnly'"
 * @generated
 */
public interface OrganizationalPerson extends Person {

	/**
	 * Returns the value of the '<em><b>Destination Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Indicator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Indicator</em>' attribute.
	 * @see #setDestinationIndicator(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_DestinationIndicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationIndicator'"
	 * @generated
	 */
	String getDestinationIndicator();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getDestinationIndicator <em>Destination Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Indicator</em>' attribute.
	 * @see #getDestinationIndicator()
	 * @generated
	 */
	void setDestinationIndicator(String value);

	/**
	 * Returns the value of the '<em><b>Facsimile Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facsimile Telephone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facsimile Telephone Number</em>' attribute.
	 * @see #setFacsimileTelephoneNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_FacsimileTelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='facsimileTelephoneNumber'"
	 * @generated
	 */
	String getFacsimileTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facsimile Telephone Number</em>' attribute.
	 * @see #getFacsimileTelephoneNumber()
	 * @generated
	 */
	void setFacsimileTelephoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>International ISDN Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>International ISDN Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>International ISDN Number</em>' attribute.
	 * @see #setInternationalISDNNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_InternationalISDNNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='internationalISDNNumber'"
	 * @generated
	 */
	String getInternationalISDNNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getInternationalISDNNumber <em>International ISDN Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>International ISDN Number</em>' attribute.
	 * @see #getInternationalISDNNumber()
	 * @generated
	 */
	void setInternationalISDNNumber(String value);

	/**
	 * Returns the value of the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>L</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>L</em>' attribute.
	 * @see #setL(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_L()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='l'"
	 * @generated
	 */
	String getL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getL <em>L</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L</em>' attribute.
	 * @see #getL()
	 * @generated
	 */
	void setL(String value);

	/**
	 * Returns the value of the '<em><b>Ou</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ou</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ou</em>' attribute.
	 * @see #setOu(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_Ou()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ou'"
	 * @generated
	 */
	String getOu();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getOu <em>Ou</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ou</em>' attribute.
	 * @see #getOu()
	 * @generated
	 */
	void setOu(String value);

	/**
	 * Returns the value of the '<em><b>Physical Delivery Office Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physical Delivery Office Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physical Delivery Office Name</em>' attribute.
	 * @see #setPhysicalDeliveryOfficeName(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_PhysicalDeliveryOfficeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='physicalDeliveryOfficeName'"
	 * @generated
	 */
	String getPhysicalDeliveryOfficeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Delivery Office Name</em>' attribute.
	 * @see #getPhysicalDeliveryOfficeName()
	 * @generated
	 */
	void setPhysicalDeliveryOfficeName(String value);

	/**
	 * Returns the value of the '<em><b>Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Address</em>' attribute.
	 * @see #setPostalAddress(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_PostalAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalAddress'"
	 * @generated
	 */
	String getPostalAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalAddress <em>Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Address</em>' attribute.
	 * @see #getPostalAddress()
	 * @generated
	 */
	void setPostalAddress(String value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #setPostalCode(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_PostalCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalCode'"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Returns the value of the '<em><b>Post Office Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Office Box</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Office Box</em>' attribute.
	 * @see #setPostOfficeBox(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_PostOfficeBox()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postOfficeBox'"
	 * @generated
	 */
	String getPostOfficeBox();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostOfficeBox <em>Post Office Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Office Box</em>' attribute.
	 * @see #getPostOfficeBox()
	 * @generated
	 */
	void setPostOfficeBox(String value);

	/**
	 * Returns the value of the '<em><b>Preferred Delivery Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Delivery Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Delivery Method</em>' attribute.
	 * @see #setPreferredDeliveryMethod(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_PreferredDeliveryMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='preferredDeliveryMethod'"
	 * @generated
	 */
	String getPreferredDeliveryMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Delivery Method</em>' attribute.
	 * @see #getPreferredDeliveryMethod()
	 * @generated
	 */
	void setPreferredDeliveryMethod(String value);

	/**
	 * Returns the value of the '<em><b>Registered Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registered Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registered Address</em>' attribute.
	 * @see #setRegisteredAddress(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_RegisteredAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='registeredAddress'"
	 * @generated
	 */
	String getRegisteredAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getRegisteredAddress <em>Registered Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registered Address</em>' attribute.
	 * @see #getRegisteredAddress()
	 * @generated
	 */
	void setRegisteredAddress(String value);

	/**
	 * Returns the value of the '<em><b>St</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>St</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>St</em>' attribute.
	 * @see #setSt(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_St()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='st'"
	 * @generated
	 */
	String getSt();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getSt <em>St</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>St</em>' attribute.
	 * @see #getSt()
	 * @generated
	 */
	void setSt(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_Street()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='street'"
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>Teletex Terminal Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Teletex Terminal Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Teletex Terminal Identifier</em>' attribute.
	 * @see #setTeletexTerminalIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_TeletexTerminalIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='teletexTerminalIdentifier'"
	 * @generated
	 */
	String getTeletexTerminalIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Teletex Terminal Identifier</em>' attribute.
	 * @see #getTeletexTerminalIdentifier()
	 * @generated
	 */
	void setTeletexTerminalIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Telex Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telex Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telex Number</em>' attribute.
	 * @see #setTelexNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_TelexNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telexNumber'"
	 * @generated
	 */
	String getTelexNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTelexNumber <em>Telex Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telex Number</em>' attribute.
	 * @see #getTelexNumber()
	 * @generated
	 */
	void setTelexNumber(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_Title()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='title'"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>X12 1address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X12 1address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X12 1address</em>' attribute.
	 * @see #setX121address(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganizationalPerson_X121address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='x121address'"
	 * @generated
	 */
	String getX121address();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getX121address <em>X12 1address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X12 1address</em>' attribute.
	 * @see #getX121address()
	 * @generated
	 */
	void setX121address(String value);
} // OrganizationalPerson
