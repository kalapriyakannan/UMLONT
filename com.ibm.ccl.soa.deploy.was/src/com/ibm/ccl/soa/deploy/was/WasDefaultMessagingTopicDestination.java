/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Default Messaging Topic Destination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getConnectionDeliveryMode <em>Connection Delivery Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessageLiveTime <em>Message Live Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessagePriority <em>Message Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getTopicName <em>Topic Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingTopicDestination()
 * @model extendedMetaData="name='WasDefaultMessagingTopicDestination' kind='elementOnly'"
 * @generated
 */
public interface WasDefaultMessagingTopicDestination extends JMSTopicDestination {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Connection Delivery Mode</b></em>' attribute.
	 * The default value is <code>"Application"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ConnectionDeliveryModeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Delivery Mode</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Delivery Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionDeliveryModeEnum
	 * @see #isSetConnectionDeliveryMode()
	 * @see #unsetConnectionDeliveryMode()
	 * @see #setConnectionDeliveryMode(ConnectionDeliveryModeEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingTopicDestination_ConnectionDeliveryMode()
	 * @model default="Application" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='connectionDeliveryMode'"
	 * @generated
	 */
	ConnectionDeliveryModeEnum getConnectionDeliveryMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getConnectionDeliveryMode <em>Connection Delivery Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Delivery Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ConnectionDeliveryModeEnum
	 * @see #isSetConnectionDeliveryMode()
	 * @see #unsetConnectionDeliveryMode()
	 * @see #getConnectionDeliveryMode()
	 * @generated
	 */
	void setConnectionDeliveryMode(ConnectionDeliveryModeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getConnectionDeliveryMode <em>Connection Delivery Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConnectionDeliveryMode()
	 * @see #getConnectionDeliveryMode()
	 * @see #setConnectionDeliveryMode(ConnectionDeliveryModeEnum)
	 * @generated
	 */
	void unsetConnectionDeliveryMode();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getConnectionDeliveryMode <em>Connection Delivery Mode</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connection Delivery Mode</em>' attribute is set.
	 * @see #unsetConnectionDeliveryMode()
	 * @see #getConnectionDeliveryMode()
	 * @see #setConnectionDeliveryMode(ConnectionDeliveryModeEnum)
	 * @generated
	 */
	boolean isSetConnectionDeliveryMode();

	/**
	 * Returns the value of the '<em><b>Message Live Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Live Time</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Live Time</em>' attribute.
	 * @see #isSetMessageLiveTime()
	 * @see #unsetMessageLiveTime()
	 * @see #setMessageLiveTime(long)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingTopicDestination_MessageLiveTime()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='messageLiveTime'"
	 * @generated
	 */
	long getMessageLiveTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessageLiveTime <em>Message Live Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Live Time</em>' attribute.
	 * @see #isSetMessageLiveTime()
	 * @see #unsetMessageLiveTime()
	 * @see #getMessageLiveTime()
	 * @generated
	 */
	void setMessageLiveTime(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessageLiveTime <em>Message Live Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMessageLiveTime()
	 * @see #getMessageLiveTime()
	 * @see #setMessageLiveTime(long)
	 * @generated
	 */
	void unsetMessageLiveTime();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessageLiveTime <em>Message Live Time</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Message Live Time</em>' attribute is set.
	 * @see #unsetMessageLiveTime()
	 * @see #getMessageLiveTime()
	 * @see #setMessageLiveTime(long)
	 * @generated
	 */
	boolean isSetMessageLiveTime();

	/**
	 * Returns the value of the '<em><b>Message Priority</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> range from 0~9 <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Message Priority</em>' attribute.
	 * @see #isSetMessagePriority()
	 * @see #unsetMessagePriority()
	 * @see #setMessagePriority(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingTopicDestination_MessagePriority()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='messagePriority'"
	 * @generated
	 */
	int getMessagePriority();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessagePriority <em>Message Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Priority</em>' attribute.
	 * @see #isSetMessagePriority()
	 * @see #unsetMessagePriority()
	 * @see #getMessagePriority()
	 * @generated
	 */
	void setMessagePriority(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessagePriority <em>Message Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMessagePriority()
	 * @see #getMessagePriority()
	 * @see #setMessagePriority(int)
	 * @generated
	 */
	void unsetMessagePriority();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getMessagePriority <em>Message Priority</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Message Priority</em>' attribute is set.
	 * @see #unsetMessagePriority()
	 * @see #getMessagePriority()
	 * @see #setMessagePriority(int)
	 * @generated
	 */
	boolean isSetMessagePriority();

	/**
	 * Returns the value of the '<em><b>Topic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic Name</em>' attribute.
	 * @see #setTopicName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDefaultMessagingTopicDestination_TopicName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='topicName'"
	 * @generated
	 */
	String getTopicName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination#getTopicName <em>Topic Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic Name</em>' attribute.
	 * @see #getTopicName()
	 * @generated
	 */
	void setTopicName(String value);

} // WasDefaultMessagingTopicDestination
