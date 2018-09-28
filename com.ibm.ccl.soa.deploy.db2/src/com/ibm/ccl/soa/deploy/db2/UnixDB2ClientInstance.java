/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unix DB2 Client Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType <em>Authentication Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGID <em>Fenced GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGroupName <em>Fenced Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUID <em>Fenced UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserName <em>Fenced User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserPassword <em>Fenced User Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGID <em>GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGroupName <em>Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType <em>Instance Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUID <em>UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUsername <em>Username</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth <em>Word Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance()
 * @model extendedMetaData="name='UnixDB2ClientInstance' kind='elementOnly'"
 * @generated
 */
public interface UnixDB2ClientInstance extends DB2ClientInstance {
	/**
	 * Returns the value of the '<em><b>Authentication Type</b></em>' attribute.
	 * The default value is <code>"SERVER"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authentication Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authentication Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @see #isSetAuthenticationType()
	 * @see #unsetAuthenticationType()
	 * @see #setAuthenticationType(AuthenticationTypeType)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_AuthenticationType()
	 * @model default="SERVER" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='authenticationType'"
	 * @generated
	 */
	AuthenticationTypeType getAuthenticationType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authentication Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @see #isSetAuthenticationType()
	 * @see #unsetAuthenticationType()
	 * @see #getAuthenticationType()
	 * @generated
	 */
	void setAuthenticationType(AuthenticationTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType <em>Authentication Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAuthenticationType()
	 * @see #getAuthenticationType()
	 * @see #setAuthenticationType(AuthenticationTypeType)
	 * @generated
	 */
	void unsetAuthenticationType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType <em>Authentication Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Authentication Type</em>' attribute is set.
	 * @see #unsetAuthenticationType()
	 * @see #getAuthenticationType()
	 * @see #setAuthenticationType(AuthenticationTypeType)
	 * @generated
	 */
	boolean isSetAuthenticationType();

	/**
	 * Returns the value of the '<em><b>Fenced GID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fenced GID</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group identifier for the DB2 fenced user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fenced GID</em>' attribute.
	 * @see #setFencedGID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_FencedGID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fencedGID'"
	 * @generated
	 */
	String getFencedGID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGID <em>Fenced GID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fenced GID</em>' attribute.
	 * @see #getFencedGID()
	 * @generated
	 */
	void setFencedGID(String value);

	/**
	 * Returns the value of the '<em><b>Fenced Group Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fenced Group Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fenced Group Name</em>' attribute.
	 * @see #setFencedGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_FencedGroupName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fencedGroupName'"
	 * @generated
	 */
	String getFencedGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGroupName <em>Fenced Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fenced Group Name</em>' attribute.
	 * @see #getFencedGroupName()
	 * @generated
	 */
	void setFencedGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Fenced UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fenced UID</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group identifier for the DB2 fenced user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fenced UID</em>' attribute.
	 * @see #setFencedUID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_FencedUID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fencedUID'"
	 * @generated
	 */
	String getFencedUID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUID <em>Fenced UID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fenced UID</em>' attribute.
	 * @see #getFencedUID()
	 * @generated
	 */
	void setFencedUID(String value);

	/**
	 * Returns the value of the '<em><b>Fenced User Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fenced User Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fenced User Name</em>' attribute.
	 * @see #setFencedUserName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_FencedUserName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fencedUserName'"
	 * @generated
	 */
	String getFencedUserName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserName <em>Fenced User Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fenced User Name</em>' attribute.
	 * @see #getFencedUserName()
	 * @generated
	 */
	void setFencedUserName(String value);

	/**
	 * Returns the value of the '<em><b>Fenced User Password</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fenced User Password</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fenced User Password</em>' attribute.
	 * @see #setFencedUserPassword(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_FencedUserPassword()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fencedUserPassword'"
	 * @generated
	 */
	String getFencedUserPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserPassword <em>Fenced User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fenced User Password</em>' attribute.
	 * @see #getFencedUserPassword()
	 * @generated
	 */
	void setFencedUserPassword(String value);

	/**
	 * Returns the value of the '<em><b>GID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>GID</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group identifier for administration of the DB2 Client instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>GID</em>' attribute.
	 * @see #setGID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_GID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='GID'"
	 * @generated
	 */
	String getGID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGID <em>GID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>GID</em>' attribute.
	 * @see #getGID()
	 * @generated
	 */
	void setGID(String value);

	/**
	 * Returns the value of the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group name for administration of the DB2 Client instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Group Name</em>' attribute.
	 * @see #setGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_GroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='groupName'"
	 * @generated
	 */
	String getGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGroupName <em>Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Name</em>' attribute.
	 * @see #getGroupName()
	 * @generated
	 */
	void setGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Instance Type</b></em>' attribute.
	 * The default value is <code>"Client"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Type</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @see #isSetInstanceType()
	 * @see #unsetInstanceType()
	 * @see #setInstanceType(UnixInstanceTypeType)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_InstanceType()
	 * @model default="Client" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='instanceType'"
	 * @generated
	 */
	UnixInstanceTypeType getInstanceType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @see #isSetInstanceType()
	 * @see #unsetInstanceType()
	 * @see #getInstanceType()
	 * @generated
	 */
	void setInstanceType(UnixInstanceTypeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetInstanceType()
	 * @see #getInstanceType()
	 * @see #setInstanceType(UnixInstanceTypeType)
	 * @generated
	 */
	void unsetInstanceType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType <em>Instance Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Instance Type</em>' attribute is set.
	 * @see #unsetInstanceType()
	 * @see #getInstanceType()
	 * @see #setInstanceType(UnixInstanceTypeType)
	 * @generated
	 */
	boolean isSetInstanceType();

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Password of user for administration of the DB2 Client instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UID</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * User identifier for administration of the DB2 Client instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>UID</em>' attribute.
	 * @see #setUID(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_UID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='UID'"
	 * @generated
	 */
	String getUID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUID <em>UID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>UID</em>' attribute.
	 * @see #getUID()
	 * @generated
	 */
	void setUID(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of user for administration of the DB2 Client instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_Username()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='username'"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Word Width</b></em>' attribute.
	 * The default value is <code>"31"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.db2.WordWidthType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Width</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Word width for the DB2 client (31 || 32 || 64)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Word Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @see #isSetWordWidth()
	 * @see #unsetWordWidth()
	 * @see #setWordWidth(WordWidthType)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getUnixDB2ClientInstance_WordWidth()
	 * @model default="31" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='wordWidth'"
	 * @generated
	 */
	WordWidthType getWordWidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth <em>Word Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @see #isSetWordWidth()
	 * @see #unsetWordWidth()
	 * @see #getWordWidth()
	 * @generated
	 */
	void setWordWidth(WordWidthType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth <em>Word Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetWordWidth()
	 * @see #getWordWidth()
	 * @see #setWordWidth(WordWidthType)
	 * @generated
	 */
	void unsetWordWidth();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth <em>Word Width</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Word Width</em>' attribute is set.
	 * @see #unsetWordWidth()
	 * @see #getWordWidth()
	 * @see #setWordWidth(WordWidthType)
	 * @generated
	 */
	boolean isSetWordWidth();

} // UnixDB2ClientInstance
