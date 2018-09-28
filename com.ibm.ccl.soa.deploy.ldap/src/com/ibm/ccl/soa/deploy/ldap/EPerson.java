/**
 * <copyright>
 * </copyright>
 *
 * $Id: EPerson.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPerson</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     <strong>
 *                         This is an ITDS-defined class, and should be factored out into a
 *                         separate .deploy.itds domain extension at some point.
 *                     </strong>
 *                 </p>
 *                 <p>
 *                     This auxiliary class collects commonly used attributes from a number
 *                     of different industry-defined person classes. It also has several DN
 *                     pointers to help integrate these entries into other CIM-based classes.
 *                 </p>
 *                 <p>
 *                     An 'ePerson' object MAY have the following attributes:
 *                     <menu>
 *                         <li>accesshint</li>
 *                         <li>accounthint</li>
 *                         <li>audio</li>
 *                         <li>businesscategory</li>
 *                         <li>c</li>
 *                         <li>carlicense</li>
 *                         <li>configptr</li>
 *                         <li>departmentnumber</li>
 *                         <li>description</li>
 *                         <li>destinationindicator</li>
 *                         <li>displayname</li>
 *                         <li>employeenumber</li>
 *                         <li>employeetype</li>
 *                         <li>facsimiletelephonenumber</li>
 *                         <li>generationqualifier</li>
 *                         <li>givenname</li>
 *                         <li>homefax</li>
 *                         <li>homephone</li>
 *                         <li>homepostaladdress</li>
 *                         <li>initials</li>
 *                         <li>internationalisdnnumber</li>
 *                         <li>jpegphoto</li>
 *                         <li>l</li>
 *                         <li>labeleduri</li>
 *                         <li>mail</li>
 *                         <li>manager</li>
 *                         <li>middlename</li>
 *                         <li>mobile</li>
 *                         <li>o</li>
 *                         <li>organizationalstatus</li>
 *                         <li>othermailbox</li>
 *                         <li>ou</li>
 *                         <li>pager</li>
 *                         <li>personaltitle</li>
 *                         <li>photo</li>
 *                         <li>physicaldeliveryofficename</li>
 *                         <li>postaladdress</li>
 *                         <li>postalcode</li>
 *                         <li>postofficebox</li>
 *                         <li>preferreddeliverymethod</li>
 *                         <li>preferredlanguage</li>
 *                         <li>registeredaddress</li>
 *                         <li>roomnumber</li>
 *                         <li>secretary</li>
 *                         <li>seealso</li>
 *                         <li>st</li>
 *                         <li>street</li>
 *                         <li>telephonenumber</li>
 *                         <li>teletexterminalidentifier</li>
 *                         <li>telexnumber</li>
 *                         <li>thumbnaillogo</li>
 *                         <li>thumbnailphoto</li>
 *                         <li>title</li>
 *                         <li>uid</li>
 *                         <li>uniqueidentifier</li>
 *                         <li>usercertificate</li>
 *                         <li>userpassword</li>
 *                         <li>userpkcs12</li>
 *                         <li>usersmimecertificate</li>
 *                         <li>x121address</li>
 *                         <li>x500uniqueidentifier</li>
 *                     </menu>
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccessHint <em>Access Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccountHint <em>Account Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAudio <em>Audio</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getBusinessCategory <em>Business Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getC <em>C</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCarLicense <em>Car License</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCn <em>Cn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getConfigPtr <em>Config Ptr</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDepartmentNumber <em>Department Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDestinationIndicator <em>Destination Indicator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeNumber <em>Employee Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeType <em>Employee Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGenerationQualifier <em>Generation Qualifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomeFax <em>Home Fax</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePhone <em>Home Phone</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePostalAddress <em>Home Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInitials <em>Initials</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInternationalISDNumber <em>International ISD Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getJpegPhoto <em>Jpeg Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getL <em>L</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getLabeledURI <em>Labeled URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMail <em>Mail</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getManager <em>Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMobile <em>Mobile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getO <em>O</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOrganizationalStatus <em>Organizational Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOtherMailbox <em>Other Mailbox</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOu <em>Ou</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPager <em>Pager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPersonalTitle <em>Personal Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhoto <em>Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalAddress <em>Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostOfficebox <em>Post Officebox</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredLanguage <em>Preferred Language</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRegisteredAddress <em>Registered Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRoomNumber <em>Room Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSecretary <em>Secretary</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSeeAlso <em>See Also</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSn <em>Sn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSt <em>St</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getStreet <em>Street</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelephoneNumber <em>Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelexNumber <em>Telex Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailLogo <em>Thumbnail Logo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTitle <em>Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUid <em>Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserCertificate <em>User Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPassword <em>User Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPKCS12 <em>User PKCS12</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX121Address <em>X121 Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson()
 * @model extendedMetaData="name='EPerson' kind='elementOnly'"
 * @generated
 */
public interface EPerson extends LdapAuxiliaryClass {

	/**
	 * Returns the value of the '<em><b>Access Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Hint</em>' attribute.
	 * @see #setAccessHint(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_AccessHint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='accessHint'"
	 * @generated
	 */
	String getAccessHint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccessHint <em>Access Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Hint</em>' attribute.
	 * @see #getAccessHint()
	 * @generated
	 */
	void setAccessHint(String value);

	/**
	 * Returns the value of the '<em><b>Account Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Hint</em>' attribute.
	 * @see #setAccountHint(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_AccountHint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='accountHint'"
	 * @generated
	 */
	String getAccountHint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccountHint <em>Account Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Hint</em>' attribute.
	 * @see #getAccountHint()
	 * @generated
	 */
	void setAccountHint(String value);

	/**
	 * Returns the value of the '<em><b>Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audio</em>' attribute.
	 * @see #setAudio(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Audio()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='audio'"
	 * @generated
	 */
	String getAudio();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAudio <em>Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audio</em>' attribute.
	 * @see #getAudio()
	 * @generated
	 */
	void setAudio(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_BusinessCategory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='businessCategory'"
	 * @generated
	 */
	String getBusinessCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getBusinessCategory <em>Business Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Category</em>' attribute.
	 * @see #getBusinessCategory()
	 * @generated
	 */
	void setBusinessCategory(String value);

	/**
	 * Returns the value of the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' attribute.
	 * @see #setC(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_C()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='c'"
	 * @generated
	 */
	String getC();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getC <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' attribute.
	 * @see #getC()
	 * @generated
	 */
	void setC(String value);

	/**
	 * Returns the value of the '<em><b>Car License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Car License</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Car License</em>' attribute.
	 * @see #setCarLicense(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_CarLicense()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='carLicense'"
	 * @generated
	 */
	String getCarLicense();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCarLicense <em>Car License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Car License</em>' attribute.
	 * @see #getCarLicense()
	 * @generated
	 */
	void setCarLicense(String value);

	/**
	 * Returns the value of the '<em><b>Cn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cn</em>' attribute.
	 * @see #setCn(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Cn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cn'"
	 * @generated
	 */
	String getCn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCn <em>Cn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cn</em>' attribute.
	 * @see #getCn()
	 * @generated
	 */
	void setCn(String value);

	/**
	 * Returns the value of the '<em><b>Config Ptr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Ptr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Ptr</em>' attribute.
	 * @see #setConfigPtr(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_ConfigPtr()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configPtr'"
	 * @generated
	 */
	String getConfigPtr();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getConfigPtr <em>Config Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config Ptr</em>' attribute.
	 * @see #getConfigPtr()
	 * @generated
	 */
	void setConfigPtr(String value);

	/**
	 * Returns the value of the '<em><b>Department Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department Number</em>' attribute.
	 * @see #setDepartmentNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_DepartmentNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='departmentNumber'"
	 * @generated
	 */
	String getDepartmentNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDepartmentNumber <em>Department Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department Number</em>' attribute.
	 * @see #getDepartmentNumber()
	 * @generated
	 */
	void setDepartmentNumber(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_DestinationIndicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destinationIndicator'"
	 * @generated
	 */
	String getDestinationIndicator();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDestinationIndicator <em>Destination Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Indicator</em>' attribute.
	 * @see #getDestinationIndicator()
	 * @generated
	 */
	void setDestinationIndicator(String value);

	/**
	 * Returns the value of the '<em><b>Employee Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee Number</em>' attribute.
	 * @see #setEmployeeNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_EmployeeNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='employeeNumber'"
	 * @generated
	 */
	String getEmployeeNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeNumber <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee Number</em>' attribute.
	 * @see #getEmployeeNumber()
	 * @generated
	 */
	void setEmployeeNumber(String value);

	/**
	 * Returns the value of the '<em><b>Employee Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee Type</em>' attribute.
	 * @see #setEmployeeType(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_EmployeeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='employeeType'"
	 * @generated
	 */
	String getEmployeeType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeType <em>Employee Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee Type</em>' attribute.
	 * @see #getEmployeeType()
	 * @generated
	 */
	void setEmployeeType(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_FacsimileTelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='facsimileTelephoneNumber'"
	 * @generated
	 */
	String getFacsimileTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facsimile Telephone Number</em>' attribute.
	 * @see #getFacsimileTelephoneNumber()
	 * @generated
	 */
	void setFacsimileTelephoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Generation Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generation Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generation Qualifier</em>' attribute.
	 * @see #setGenerationQualifier(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_GenerationQualifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='generationQualifier'"
	 * @generated
	 */
	String getGenerationQualifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGenerationQualifier <em>Generation Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generation Qualifier</em>' attribute.
	 * @see #getGenerationQualifier()
	 * @generated
	 */
	void setGenerationQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Given Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Given Name</em>' attribute.
	 * @see #setGivenName(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_GivenName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='givenName'"
	 * @generated
	 */
	String getGivenName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGivenName <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Given Name</em>' attribute.
	 * @see #getGivenName()
	 * @generated
	 */
	void setGivenName(String value);

	/**
	 * Returns the value of the '<em><b>Home Fax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Fax</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Fax</em>' attribute.
	 * @see #setHomeFax(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_HomeFax()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homeFax'"
	 * @generated
	 */
	String getHomeFax();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomeFax <em>Home Fax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Fax</em>' attribute.
	 * @see #getHomeFax()
	 * @generated
	 */
	void setHomeFax(String value);

	/**
	 * Returns the value of the '<em><b>Home Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Phone</em>' attribute.
	 * @see #setHomePhone(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_HomePhone()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homePhone'"
	 * @generated
	 */
	String getHomePhone();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePhone <em>Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Phone</em>' attribute.
	 * @see #getHomePhone()
	 * @generated
	 */
	void setHomePhone(String value);

	/**
	 * Returns the value of the '<em><b>Home Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Postal Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Postal Address</em>' attribute.
	 * @see #setHomePostalAddress(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_HomePostalAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homePostalAddress'"
	 * @generated
	 */
	String getHomePostalAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePostalAddress <em>Home Postal Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Postal Address</em>' attribute.
	 * @see #getHomePostalAddress()
	 * @generated
	 */
	void setHomePostalAddress(String value);

	/**
	 * Returns the value of the '<em><b>Initials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initials</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initials</em>' attribute.
	 * @see #setInitials(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Initials()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initials'"
	 * @generated
	 */
	String getInitials();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInitials <em>Initials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initials</em>' attribute.
	 * @see #getInitials()
	 * @generated
	 */
	void setInitials(String value);

	/**
	 * Returns the value of the '<em><b>International ISD Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>International ISD Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>International ISD Number</em>' attribute.
	 * @see #setInternationalISDNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_InternationalISDNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='internationalISDNumber'"
	 * @generated
	 */
	String getInternationalISDNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInternationalISDNumber <em>International ISD Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>International ISD Number</em>' attribute.
	 * @see #getInternationalISDNumber()
	 * @generated
	 */
	void setInternationalISDNumber(String value);

	/**
	 * Returns the value of the '<em><b>Jpeg Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jpeg Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jpeg Photo</em>' attribute.
	 * @see #setJpegPhoto(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_JpegPhoto()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jpegPhoto'"
	 * @generated
	 */
	String getJpegPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getJpegPhoto <em>Jpeg Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jpeg Photo</em>' attribute.
	 * @see #getJpegPhoto()
	 * @generated
	 */
	void setJpegPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_L()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='l'"
	 * @generated
	 */
	String getL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getL <em>L</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L</em>' attribute.
	 * @see #getL()
	 * @generated
	 */
	void setL(String value);

	/**
	 * Returns the value of the '<em><b>Labeled URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labeled URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labeled URI</em>' attribute.
	 * @see #setLabeledURI(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_LabeledURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='labeledURI'"
	 * @generated
	 */
	String getLabeledURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getLabeledURI <em>Labeled URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Labeled URI</em>' attribute.
	 * @see #getLabeledURI()
	 * @generated
	 */
	void setLabeledURI(String value);

	/**
	 * Returns the value of the '<em><b>Mail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mail</em>' attribute.
	 * @see #setMail(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Mail()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mail'"
	 * @generated
	 */
	String getMail();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMail <em>Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail</em>' attribute.
	 * @see #getMail()
	 * @generated
	 */
	void setMail(String value);

	/**
	 * Returns the value of the '<em><b>Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager</em>' attribute.
	 * @see #setManager(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Manager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='manager'"
	 * @generated
	 */
	String getManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getManager <em>Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' attribute.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(String value);

	/**
	 * Returns the value of the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Middle Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Middle Name</em>' attribute.
	 * @see #setMiddleName(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_MiddleName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='middleName'"
	 * @generated
	 */
	String getMiddleName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMiddleName <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Middle Name</em>' attribute.
	 * @see #getMiddleName()
	 * @generated
	 */
	void setMiddleName(String value);

	/**
	 * Returns the value of the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mobile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mobile</em>' attribute.
	 * @see #setMobile(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Mobile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mobile'"
	 * @generated
	 */
	String getMobile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMobile <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mobile</em>' attribute.
	 * @see #getMobile()
	 * @generated
	 */
	void setMobile(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_O()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='o'"
	 * @generated
	 */
	String getO();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getO <em>O</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>O</em>' attribute.
	 * @see #getO()
	 * @generated
	 */
	void setO(String value);

	/**
	 * Returns the value of the '<em><b>Organizational Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organizational Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organizational Status</em>' attribute.
	 * @see #setOrganizationalStatus(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_OrganizationalStatus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='organizationalStatus'"
	 * @generated
	 */
	String getOrganizationalStatus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOrganizationalStatus <em>Organizational Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organizational Status</em>' attribute.
	 * @see #getOrganizationalStatus()
	 * @generated
	 */
	void setOrganizationalStatus(String value);

	/**
	 * Returns the value of the '<em><b>Other Mailbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Mailbox</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Mailbox</em>' attribute.
	 * @see #setOtherMailbox(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_OtherMailbox()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='otherMailbox'"
	 * @generated
	 */
	String getOtherMailbox();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOtherMailbox <em>Other Mailbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Mailbox</em>' attribute.
	 * @see #getOtherMailbox()
	 * @generated
	 */
	void setOtherMailbox(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Ou()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ou'"
	 * @generated
	 */
	String getOu();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOu <em>Ou</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ou</em>' attribute.
	 * @see #getOu()
	 * @generated
	 */
	void setOu(String value);

	/**
	 * Returns the value of the '<em><b>Pager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pager</em>' attribute.
	 * @see #setPager(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Pager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pager'"
	 * @generated
	 */
	String getPager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPager <em>Pager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pager</em>' attribute.
	 * @see #getPager()
	 * @generated
	 */
	void setPager(String value);

	/**
	 * Returns the value of the '<em><b>Personal Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Personal Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Personal Title</em>' attribute.
	 * @see #setPersonalTitle(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PersonalTitle()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='personalTitle'"
	 * @generated
	 */
	String getPersonalTitle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPersonalTitle <em>Personal Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Personal Title</em>' attribute.
	 * @see #getPersonalTitle()
	 * @generated
	 */
	void setPersonalTitle(String value);

	/**
	 * Returns the value of the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Photo</em>' attribute.
	 * @see #setPhoto(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Photo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='photo'"
	 * @generated
	 */
	String getPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhoto <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo</em>' attribute.
	 * @see #getPhoto()
	 * @generated
	 */
	void setPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PhysicalDeliveryOfficeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='physicalDeliveryOfficeName'"
	 * @generated
	 */
	String getPhysicalDeliveryOfficeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PostalAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalAddress'"
	 * @generated
	 */
	String getPostalAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalAddress <em>Postal Address</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PostalCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postalCode'"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Returns the value of the '<em><b>Post Officebox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Officebox</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Officebox</em>' attribute.
	 * @see #setPostOfficebox(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PostOfficebox()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='postOfficebox'"
	 * @generated
	 */
	String getPostOfficebox();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostOfficebox <em>Post Officebox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Officebox</em>' attribute.
	 * @see #getPostOfficebox()
	 * @generated
	 */
	void setPostOfficebox(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PreferredDeliveryMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='preferredDeliveryMethod'"
	 * @generated
	 */
	String getPreferredDeliveryMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Delivery Method</em>' attribute.
	 * @see #getPreferredDeliveryMethod()
	 * @generated
	 */
	void setPreferredDeliveryMethod(String value);

	/**
	 * Returns the value of the '<em><b>Preferred Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Language</em>' attribute.
	 * @see #setPreferredLanguage(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_PreferredLanguage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='preferredLanguage'"
	 * @generated
	 */
	String getPreferredLanguage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredLanguage <em>Preferred Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Language</em>' attribute.
	 * @see #getPreferredLanguage()
	 * @generated
	 */
	void setPreferredLanguage(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_RegisteredAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='registeredAddress'"
	 * @generated
	 */
	String getRegisteredAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRegisteredAddress <em>Registered Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registered Address</em>' attribute.
	 * @see #getRegisteredAddress()
	 * @generated
	 */
	void setRegisteredAddress(String value);

	/**
	 * Returns the value of the '<em><b>Room Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Room Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Room Number</em>' attribute.
	 * @see #setRoomNumber(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_RoomNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='roomNumber'"
	 * @generated
	 */
	String getRoomNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRoomNumber <em>Room Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Room Number</em>' attribute.
	 * @see #getRoomNumber()
	 * @generated
	 */
	void setRoomNumber(String value);

	/**
	 * Returns the value of the '<em><b>Secretary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secretary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secretary</em>' attribute.
	 * @see #setSecretary(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Secretary()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='secretary'"
	 * @generated
	 */
	String getSecretary();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSecretary <em>Secretary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secretary</em>' attribute.
	 * @see #getSecretary()
	 * @generated
	 */
	void setSecretary(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_SeeAlso()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='seeAlso'"
	 * @generated
	 */
	String getSeeAlso();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSeeAlso <em>See Also</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>See Also</em>' attribute.
	 * @see #getSeeAlso()
	 * @generated
	 */
	void setSeeAlso(String value);

	/**
	 * Returns the value of the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sn</em>' attribute.
	 * @see #setSn(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Sn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sn'"
	 * @generated
	 */
	String getSn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSn <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sn</em>' attribute.
	 * @see #getSn()
	 * @generated
	 */
	void setSn(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_St()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='st'"
	 * @generated
	 */
	String getSt();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSt <em>St</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Street()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='street'"
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getStreet <em>Street</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_TelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telephoneNumber'"
	 * @generated
	 */
	String getTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelephoneNumber <em>Telephone Number</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_TeletexTerminalIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='teletexTerminalIdentifier'"
	 * @generated
	 */
	String getTeletexTerminalIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_TelexNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telexNumber'"
	 * @generated
	 */
	String getTelexNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelexNumber <em>Telex Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telex Number</em>' attribute.
	 * @see #getTelexNumber()
	 * @generated
	 */
	void setTelexNumber(String value);

	/**
	 * Returns the value of the '<em><b>Thumbnail Logo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thumbnail Logo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thumbnail Logo</em>' attribute.
	 * @see #setThumbnailLogo(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_ThumbnailLogo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='thumbnailLogo'"
	 * @generated
	 */
	String getThumbnailLogo();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailLogo <em>Thumbnail Logo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thumbnail Logo</em>' attribute.
	 * @see #getThumbnailLogo()
	 * @generated
	 */
	void setThumbnailLogo(String value);

	/**
	 * Returns the value of the '<em><b>Thumbnail Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thumbnail Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thumbnail Photo</em>' attribute.
	 * @see #setThumbnailPhoto(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_ThumbnailPhoto()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='thumbnailPhoto'"
	 * @generated
	 */
	String getThumbnailPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thumbnail Photo</em>' attribute.
	 * @see #getThumbnailPhoto()
	 * @generated
	 */
	void setThumbnailPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Title()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='title'"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid</em>' attribute.
	 * @see #setUid(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_Uid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uid'"
	 * @generated
	 */
	String getUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUid <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid</em>' attribute.
	 * @see #getUid()
	 * @generated
	 */
	void setUid(String value);

	/**
	 * Returns the value of the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Identifier</em>' attribute.
	 * @see #setUniqueIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_UniqueIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uniqueIdentifier'"
	 * @generated
	 */
	String getUniqueIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUniqueIdentifier <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Identifier</em>' attribute.
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	void setUniqueIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>User Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Certificate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Certificate</em>' attribute.
	 * @see #setUserCertificate(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_UserCertificate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userCertificate'"
	 * @generated
	 */
	String getUserCertificate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserCertificate <em>User Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Certificate</em>' attribute.
	 * @see #getUserCertificate()
	 * @generated
	 */
	void setUserCertificate(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_UserPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPassword'"
	 * @generated
	 */
	String getUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPassword <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Password</em>' attribute.
	 * @see #getUserPassword()
	 * @generated
	 */
	void setUserPassword(String value);

	/**
	 * Returns the value of the '<em><b>User PKCS12</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User PKCS12</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User PKCS12</em>' attribute.
	 * @see #setUserPKCS12(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_UserPKCS12()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPKCS12'"
	 * @generated
	 */
	String getUserPKCS12();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPKCS12 <em>User PKCS12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User PKCS12</em>' attribute.
	 * @see #getUserPKCS12()
	 * @generated
	 */
	void setUserPKCS12(String value);

	/**
	 * Returns the value of the '<em><b>User SMIME Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User SMIME Certificate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User SMIME Certificate</em>' attribute.
	 * @see #setUserSMIMECertificate(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_UserSMIMECertificate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userSMIMECertificate'"
	 * @generated
	 */
	String getUserSMIMECertificate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User SMIME Certificate</em>' attribute.
	 * @see #getUserSMIMECertificate()
	 * @generated
	 */
	void setUserSMIMECertificate(String value);

	/**
	 * Returns the value of the '<em><b>X121 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X121 Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X121 Address</em>' attribute.
	 * @see #setX121Address(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_X121Address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='x121Address'"
	 * @generated
	 */
	String getX121Address();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX121Address <em>X121 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X121 Address</em>' attribute.
	 * @see #getX121Address()
	 * @generated
	 */
	void setX121Address(String value);

	/**
	 * Returns the value of the '<em><b>X500 Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X500 Unique Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X500 Unique Identifier</em>' attribute.
	 * @see #setX500UniqueIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getEPerson_X500UniqueIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='x500UniqueIdentifier'"
	 * @generated
	 */
	String getX500UniqueIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X500 Unique Identifier</em>' attribute.
	 * @see #getX500UniqueIdentifier()
	 * @generated
	 */
	void setX500UniqueIdentifier(String value);
} // EPerson
