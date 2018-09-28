/**
 * <copyright>
 * </copyright>
 *
 * $Id: InetOrgPerson.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inet Org Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     The inetOrgPerson represents people who are associated with an
 *                     organization in some way. It is a structural class and is derived from
 *                     the {@link OrganizationalPerson} class which is defined in X.521
 *                     [X521].
 *                 </p>
 *                 <p>
 *                     An 'inetOrgPerson' object MAY have the following attributes:
 *                     <menu>
 *                         <li>audio</li>
 *                         <li>businessCategory</li>
 *                         <li>carLicense</li>
 *                         <li>departmentNumber</li>
 *                         <li>displayName</li>
 *                         <li>employeeNumber</li>
 *                         <li>employeeType</li>
 *                         <li>givenName</li>
 *                         <li>homePhone</li>
 *                         <li>homePostalAddress</li>
 *                         <li>initials</li>
 *                         <li>jpegPhoto</li>
 *                         <li>labeledURI</li>
 *                         <li>mail</li>
 *                         <li>manager</li>
 *                         <li>mobile</li>
 *                         <li>o</li>
 *                         <li>pager</li>
 *                         <li>photo</li>
 *                         <li>preferredLanguage</li>
 *                         <li>roomNumber</li>
 *                         <li>secretary</li>
 *                         <li>uid</li>
 *                         <li>userCertificate</li>
 *                         <li>userPKCS12</li>
 *                         <li>userSMIMECertificate</li>
 *                         <li>x500uniqueIdentifier</li>
 *                     </menu>
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccessHint <em>Access Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccountHint <em>Account Hint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAudio <em>Audio</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getBusinessCategory <em>Business Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getC <em>C</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getCarLicense <em>Car License</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getConfigPtr <em>Config Ptr</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getDepartmentNumber <em>Department Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeNumber <em>Employee Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeType <em>Employee Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGenerationQualifier <em>Generation Qualifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomeFax <em>Home Fax</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePhone <em>Home Phone</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePostalAddress <em>Home Postal Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getInitials <em>Initials</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getJpegPhoto <em>Jpeg Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getLabeledURI <em>Labeled URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMail <em>Mail</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getManager <em>Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMobile <em>Mobile</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getO <em>O</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOrganizationalStatus <em>Organizational Status</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOtherMailbox <em>Other Mailbox</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPager <em>Pager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPersonalTitle <em>Personal Title</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPhoto <em>Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPreferredLanguage <em>Preferred Language</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getRoomNumber <em>Room Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getSecretary <em>Secretary</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailLogo <em>Thumbnail Logo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUid <em>Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserCertificate <em>User Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserPKCS12 <em>User PKCS12</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson()
 * @model extendedMetaData="name='InetOrgPerson' kind='elementOnly'"
 * @generated
 */
public interface InetOrgPerson extends OrganizationalPerson {

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_AccessHint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='accessHint'"
	 * @generated
	 */
	String getAccessHint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccessHint <em>Access Hint</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_AccountHint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='accountHint'"
	 * @generated
	 */
	String getAccountHint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccountHint <em>Account Hint</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Audio()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='audio'"
	 * @generated
	 */
	String getAudio();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAudio <em>Audio</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_BusinessCategory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='businessCategory'"
	 * @generated
	 */
	String getBusinessCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getBusinessCategory <em>Business Category</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_C()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='c'"
	 * @generated
	 */
	String getC();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getC <em>C</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_CarLicense()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='carLicense'"
	 * @generated
	 */
	String getCarLicense();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getCarLicense <em>Car License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Car License</em>' attribute.
	 * @see #getCarLicense()
	 * @generated
	 */
	void setCarLicense(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_ConfigPtr()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configPtr'"
	 * @generated
	 */
	String getConfigPtr();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getConfigPtr <em>Config Ptr</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_DepartmentNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='departmentNumber'"
	 * @generated
	 */
	String getDepartmentNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getDepartmentNumber <em>Department Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department Number</em>' attribute.
	 * @see #getDepartmentNumber()
	 * @generated
	 */
	void setDepartmentNumber(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_EmployeeNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='employeeNumber'"
	 * @generated
	 */
	String getEmployeeNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeNumber <em>Employee Number</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_EmployeeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='employeeType'"
	 * @generated
	 */
	String getEmployeeType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeType <em>Employee Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee Type</em>' attribute.
	 * @see #getEmployeeType()
	 * @generated
	 */
	void setEmployeeType(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_GenerationQualifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='generationQualifier'"
	 * @generated
	 */
	String getGenerationQualifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGenerationQualifier <em>Generation Qualifier</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_GivenName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='givenName'"
	 * @generated
	 */
	String getGivenName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGivenName <em>Given Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_HomeFax()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homeFax'"
	 * @generated
	 */
	String getHomeFax();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomeFax <em>Home Fax</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_HomePhone()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homePhone'"
	 * @generated
	 */
	String getHomePhone();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePhone <em>Home Phone</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_HomePostalAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='homePostalAddress'"
	 * @generated
	 */
	String getHomePostalAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePostalAddress <em>Home Postal Address</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Initials()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initials'"
	 * @generated
	 */
	String getInitials();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getInitials <em>Initials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initials</em>' attribute.
	 * @see #getInitials()
	 * @generated
	 */
	void setInitials(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_JpegPhoto()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jpegPhoto'"
	 * @generated
	 */
	String getJpegPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getJpegPhoto <em>Jpeg Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jpeg Photo</em>' attribute.
	 * @see #getJpegPhoto()
	 * @generated
	 */
	void setJpegPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_LabeledURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='labeledURI'"
	 * @generated
	 */
	String getLabeledURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getLabeledURI <em>Labeled URI</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Mail()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mail'"
	 * @generated
	 */
	String getMail();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMail <em>Mail</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Manager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='manager'"
	 * @generated
	 */
	String getManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getManager <em>Manager</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_MiddleName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='middleName'"
	 * @generated
	 */
	String getMiddleName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMiddleName <em>Middle Name</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Mobile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mobile'"
	 * @generated
	 */
	String getMobile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMobile <em>Mobile</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_O()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='o'"
	 * @generated
	 */
	String getO();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getO <em>O</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_OrganizationalStatus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='organizationalStatus'"
	 * @generated
	 */
	String getOrganizationalStatus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOrganizationalStatus <em>Organizational Status</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_OtherMailbox()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='otherMailbox'"
	 * @generated
	 */
	String getOtherMailbox();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOtherMailbox <em>Other Mailbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Mailbox</em>' attribute.
	 * @see #getOtherMailbox()
	 * @generated
	 */
	void setOtherMailbox(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Pager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pager'"
	 * @generated
	 */
	String getPager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPager <em>Pager</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_PersonalTitle()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='personalTitle'"
	 * @generated
	 */
	String getPersonalTitle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPersonalTitle <em>Personal Title</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Photo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='photo'"
	 * @generated
	 */
	String getPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPhoto <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo</em>' attribute.
	 * @see #getPhoto()
	 * @generated
	 */
	void setPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_PreferredLanguage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='preferredLanguage'"
	 * @generated
	 */
	String getPreferredLanguage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPreferredLanguage <em>Preferred Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Language</em>' attribute.
	 * @see #getPreferredLanguage()
	 * @generated
	 */
	void setPreferredLanguage(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_RoomNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='roomNumber'"
	 * @generated
	 */
	String getRoomNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getRoomNumber <em>Room Number</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Secretary()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='secretary'"
	 * @generated
	 */
	String getSecretary();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getSecretary <em>Secretary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secretary</em>' attribute.
	 * @see #getSecretary()
	 * @generated
	 */
	void setSecretary(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_ThumbnailLogo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='thumbnailLogo'"
	 * @generated
	 */
	String getThumbnailLogo();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailLogo <em>Thumbnail Logo</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_ThumbnailPhoto()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='thumbnailPhoto'"
	 * @generated
	 */
	String getThumbnailPhoto();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thumbnail Photo</em>' attribute.
	 * @see #getThumbnailPhoto()
	 * @generated
	 */
	void setThumbnailPhoto(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_Uid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uid'"
	 * @generated
	 */
	String getUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUid <em>Uid</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_UniqueIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uniqueIdentifier'"
	 * @generated
	 */
	String getUniqueIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUniqueIdentifier <em>Unique Identifier</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_UserCertificate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userCertificate'"
	 * @generated
	 */
	String getUserCertificate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserCertificate <em>User Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Certificate</em>' attribute.
	 * @see #getUserCertificate()
	 * @generated
	 */
	void setUserCertificate(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_UserPKCS12()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPKCS12'"
	 * @generated
	 */
	String getUserPKCS12();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserPKCS12 <em>User PKCS12</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_UserSMIMECertificate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userSMIMECertificate'"
	 * @generated
	 */
	String getUserSMIMECertificate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User SMIME Certificate</em>' attribute.
	 * @see #getUserSMIMECertificate()
	 * @generated
	 */
	void setUserSMIMECertificate(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getInetOrgPerson_X500UniqueIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='x500UniqueIdentifier'"
	 * @generated
	 */
	String getX500UniqueIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X500 Unique Identifier</em>' attribute.
	 * @see #getX500UniqueIdentifier()
	 * @generated
	 */
	void setX500UniqueIdentifier(String value);
} // InetOrgPerson
