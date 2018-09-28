/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Managing Eventservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.ManagingEventservice#getEventsInfrastructureEmitterFactoryJNDIName <em>Events Infrastructure Emitter Factory JNDI Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getManagingEventservice()
 * @model extendedMetaData="name='ManagingEventservice' kind='elementOnly'"
 * @generated
 */
public interface ManagingEventservice extends Capability {
	/**
	 * Returns the value of the '<em><b>Events Infrastructure Emitter Factory JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events Infrastructure Emitter Factory JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events Infrastructure Emitter Factory JNDI Name</em>' attribute.
	 * @see #setEventsInfrastructureEmitterFactoryJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EventsInfrastructureEmitterFactoryJNDIName'"
	 * @generated
	 */
	String getEventsInfrastructureEmitterFactoryJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.ManagingEventservice#getEventsInfrastructureEmitterFactoryJNDIName <em>Events Infrastructure Emitter Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Events Infrastructure Emitter Factory JNDI Name</em>' attribute.
	 * @see #getEventsInfrastructureEmitterFactoryJNDIName()
	 * @generated
	 */
	void setEventsInfrastructureEmitterFactoryJNDIName(String value);

} // ManagingEventservice
