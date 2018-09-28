/**
 * <copyright>
 * </copyright>
 *
 * $Id: Person.java,v 1.2 2008/06/25 22:31:01 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.ldap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *                 <p>
 *                     The 'person' object class is the basis of an entry that represents a
 *                     human being. (Source: X.521 [X.521])
 *                 </p>
 *                 <p>
 *                     A 'person' object MUST have the following attributes:
 *                     <menu>
 *                         <li>sn</li>
 *                         <li>cn</li>
 *                     </menu>
 *                 </p>
 *                 <p>
 *                     A 'person' object MAY have the following attributes:
 *                     <menu>
 *                         <li>userPassword</li>
 *                         <li>telephoneNumber</li>
 *                         <li>seeAlso</li>
 *                         <li>description</li>
 *                     </menu>
 *                 </p>
 *             
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Person#getCn <em>Cn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Person#getSeeAlso <em>See Also</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Person#getSn <em>Sn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Person#getTelephoneNumber <em>Telephone Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.Person#getUserPassword <em>User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson()
 * @model extendedMetaData="name='Person' kind='elementOnly'"
 * @generated
 */
public interface Person extends Top {

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson_Cn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cn'"
	 * @generated
	 */
	String getCn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Person#getCn <em>Cn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cn</em>' attribute.
	 * @see #getCn()
	 * @generated
	 */
	void setCn(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson_SeeAlso()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='seeAlso'"
	 * @generated
	 */
	String getSeeAlso();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Person#getSeeAlso <em>See Also</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson_Sn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sn'"
	 * @generated
	 */
	String getSn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Person#getSn <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sn</em>' attribute.
	 * @see #getSn()
	 * @generated
	 */
	void setSn(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson_TelephoneNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='telephoneNumber'"
	 * @generated
	 */
	String getTelephoneNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Person#getTelephoneNumber <em>Telephone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telephone Number</em>' attribute.
	 * @see #getTelephoneNumber()
	 * @generated
	 */
	void setTelephoneNumber(String value);

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
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getPerson_UserPassword()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userPassword'"
	 * @generated
	 */
	String getUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.Person#getUserPassword <em>User Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Password</em>' attribute.
	 * @see #getUserPassword()
	 * @generated
	 */
	void setUserPassword(String value);
} // Person
