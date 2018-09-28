/**
 * <copyright> </copyright>
 * 
 * $Id: Organization.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     The 'organization' object class is the basis of an entry that
 *                     represents a structured group of people. (Source: X.521 [X.521])
 *                 </p>
 *                 <p>
 *                     An 'organization' object MUST have the following attribute:
 *                     <menu>
 *                         <li>o</li>
 *                     </menu>
 *                 </p>
 *                 <p>
 *                     An 'organization' object MAY have the following attributes:
 *                     <menu>
 *                         <li>businessCategory</li>
 *                         <li>description</li>
 *                         <li>destinationIndicator</li>
 *                         <li>facsimileTelephoneNumber</li>
 *                         <li>internationalISDNNumber</li>
 *                         <li>l</li>
 *                         <li>physicalDeliveryOfficeName</li>
 *                         <li>postOfficeBox</li>
 *                         <li>postalAddress</li>
 *                         <li>postalCode</li>
 *                         <li>preferredDeliveryMethod</li>
 *                         <li>registeredAddress</li>
 *                         <li>searchGuide</li>
 *                         <li>seeAlso</li>
 *                         <li>st</li>
 *                         <li>street</li>
 *                         <li>telephoneNumber</li>
 *                         <li>teletexTerminalIdentifier</li>
 *                         <li>telexNumber</li>
 *                         <li>userPassword</li>
 *                         <li>x121Address</li>
 *                     </menu>
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getBusinessCategory <em>Business Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDestinationIndicator <em>Destination Indicator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getInternationalISDNNumber <em>International ISDN Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getL <em>L</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getO <em>O</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalAddress <em>Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostOfficeBox <em>Post Office Box</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getRegisteredAddress <em>Registered Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSearchGuide <em>Search Guide</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSeeAlso <em>See Also</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSt <em>St</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getStreet <em>Street</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelephoneNumber <em>Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelexNumber <em>Telex Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getUserPassword <em>User Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Organization#getX121address <em>X12 1address</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization()
 * @model extendedMetaData="name='Organization' kind='elementOnly'"
 * @generated
 */
public interface Organization extends Top {

	/**
	 * Returns the value of the '<em><b>Business Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Category</em>' attribute.
	 * @see #setBusinessCategory(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_BusinessCategory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='businessCategory'"
	 * @generated
	 */
	String getBusinessCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getBusinessCategory <em>Business Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Category</em>' attribute.
	 * @see #getBusinessCategory()
	 * @generated
	 */
	void setBusinessCategory(String value);

	/**
	 * Returns the value of the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description1</em>' attribute.
	 * @see #setDescription1(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_DestinationIndicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationIndicator'"
	 * @generated
	 */
	String getDestinationIndicator();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDestinationIndicator <em>Destination Indicator</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_FacsimileTelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='facsimileTelephoneNumber'"
	 * @generated
	 */
	String getFacsimileTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_InternationalISDNNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='internationalISDNNumber'"
	 * @generated
	 */
	String getInternationalISDNNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getInternationalISDNNumber <em>International ISDN Number</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_L()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='l'"
	 * @generated
	 */
	String getL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getL <em>L</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L</em>' attribute.
	 * @see #getL()
	 * @generated
	 */
	void setL(String value);

	/**
	 * Returns the value of the '<em><b>O</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>O</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>O</em>' attribute.
	 * @see #setO(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_O()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='o'"
	 * @generated
	 */
	String getO();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getO <em>O</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>O</em>' attribute.
	 * @see #getO()
	 * @generated
	 */
	void setO(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_PhysicalDeliveryOfficeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='physicalDeliveryOfficeName'"
	 * @generated
	 */
	String getPhysicalDeliveryOfficeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_PostalAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalAddress'"
	 * @generated
	 */
	String getPostalAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalAddress <em>Postal Address</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_PostalCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalCode'"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalCode <em>Postal Code</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_PostOfficeBox()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postOfficeBox'"
	 * @generated
	 */
	String getPostOfficeBox();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostOfficeBox <em>Post Office Box</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_PreferredDeliveryMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='preferredDeliveryMethod'"
	 * @generated
	 */
	String getPreferredDeliveryMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_RegisteredAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='registeredAddress'"
	 * @generated
	 */
	String getRegisteredAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getRegisteredAddress <em>Registered Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registered Address</em>' attribute.
	 * @see #getRegisteredAddress()
	 * @generated
	 */
	void setRegisteredAddress(String value);

	/**
	 * Returns the value of the '<em><b>Search Guide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Guide</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Guide</em>' attribute.
	 * @see #setSearchGuide(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_SearchGuide()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='searchGuide'"
	 * @generated
	 */
	String getSearchGuide();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSearchGuide <em>Search Guide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Guide</em>' attribute.
	 * @see #getSearchGuide()
	 * @generated
	 */
	void setSearchGuide(String value);

	/**
	 * Returns the value of the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>See Also</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>See Also</em>' attribute.
	 * @see #setSeeAlso(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_SeeAlso()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='seeAlso'"
	 * @generated
	 */
	String getSeeAlso();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSeeAlso <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>See Also</em>' attribute.
	 * @see #getSeeAlso()
	 * @generated
	 */
	void setSeeAlso(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_St()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='st'"
	 * @generated
	 */
	String getSt();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSt <em>St</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_Street()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='street'"
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telephone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telephone Number</em>' attribute.
	 * @see #setTelephoneNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_TelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telephoneNumber'"
	 * @generated
	 */
	String getTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelephoneNumber <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telephone Number</em>' attribute.
	 * @see #getTelephoneNumber()
	 * @generated
	 */
	void setTelephoneNumber(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_TeletexTerminalIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='teletexTerminalIdentifier'"
	 * @generated
	 */
	String getTeletexTerminalIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_TelexNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telexNumber'"
	 * @generated
	 */
	String getTelexNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelexNumber <em>Telex Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telex Number</em>' attribute.
	 * @see #getTelexNumber()
	 * @generated
	 */
	void setTelexNumber(String value);

	/**
	 * Returns the value of the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Password</em>' attribute.
	 * @see #setUserPassword(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_UserPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPassword'"
	 * @generated
	 */
	String getUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getUserPassword <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Password</em>' attribute.
	 * @see #getUserPassword()
	 * @generated
	 */
	void setUserPassword(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getOrganization_X121address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='x121address'"
	 * @generated
	 */
	String getX121address();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getX121address <em>X12 1address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X12 1address</em>' attribute.
	 * @see #getX121address()
	 * @generated
	 */
	void setX121address(String value);
} // Organization
