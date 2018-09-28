/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MQ Queue Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannel#getChannelName <em>Channel Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueChannel()
 * @model extendedMetaData="name='MQQueueChannel' kind='elementOnly'"
 * @generated
 */
public interface MQQueueChannel extends Capability {
	/**
	 * Returns the value of the '<em><b>Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Name</em>' attribute.
	 * @see #setChannelName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQQueueChannel_ChannelName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='channelName'"
	 * @generated
	 */
	String getChannelName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannel#getChannelName <em>Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Name</em>' attribute.
	 * @see #getChannelName()
	 * @generated
	 */
	void setChannelName(String value);

} // MQQueueChannel
