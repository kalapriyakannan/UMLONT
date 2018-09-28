/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JMS Activation Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getDurableScriptionHome <em>Durable Scription Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxBatchSize <em>Max Batch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxConcurrentEndpoints <em>Max Concurrent Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getShareDurableSubscription <em>Share Durable Subscription</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasJMSActivationSpecification()
 * @model extendedMetaData="name='WasJMSActivationSpecification' kind='elementOnly'"
 * @generated
 */
public interface WasJMSActivationSpecification extends JMSActivationSpecification {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Durable Scription Home</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Durable Scription Home</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Durable Scription Home</em>' attribute.
	 * @see #setDurableScriptionHome(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasJMSActivationSpecification_DurableScriptionHome()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='durableScriptionHome'"
	 * @generated
	 */
	String getDurableScriptionHome();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getDurableScriptionHome <em>Durable Scription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Durable Scription Home</em>' attribute.
	 * @see #getDurableScriptionHome()
	 * @generated
	 */
	void setDurableScriptionHome(String value);

	/**
	 * Returns the value of the '<em><b>Max Batch Size</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Max Batch Size</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Batch Size</em>' attribute.
	 * @see #isSetMaxBatchSize()
	 * @see #unsetMaxBatchSize()
	 * @see #setMaxBatchSize(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasJMSActivationSpecification_MaxBatchSize()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='MaxBatchSize'"
	 * @generated
	 */
	int getMaxBatchSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxBatchSize <em>Max Batch Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Batch Size</em>' attribute.
	 * @see #isSetMaxBatchSize()
	 * @see #unsetMaxBatchSize()
	 * @see #getMaxBatchSize()
	 * @generated
	 */
	void setMaxBatchSize(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxBatchSize <em>Max Batch Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMaxBatchSize()
	 * @see #getMaxBatchSize()
	 * @see #setMaxBatchSize(int)
	 * @generated
	 */
	void unsetMaxBatchSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxBatchSize <em>Max Batch Size</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Batch Size</em>' attribute is set.
	 * @see #unsetMaxBatchSize()
	 * @see #getMaxBatchSize()
	 * @see #setMaxBatchSize(int)
	 * @generated
	 */
	boolean isSetMaxBatchSize();

	/**
	 * Returns the value of the '<em><b>Max Concurrent Endpoints</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Concurrent Endpoints</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Concurrent Endpoints</em>' attribute.
	 * @see #isSetMaxConcurrentEndpoints()
	 * @see #unsetMaxConcurrentEndpoints()
	 * @see #setMaxConcurrentEndpoints(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasJMSActivationSpecification_MaxConcurrentEndpoints()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='maxConcurrentEndpoints'"
	 * @generated
	 */
	int getMaxConcurrentEndpoints();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxConcurrentEndpoints <em>Max Concurrent Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Concurrent Endpoints</em>' attribute.
	 * @see #isSetMaxConcurrentEndpoints()
	 * @see #unsetMaxConcurrentEndpoints()
	 * @see #getMaxConcurrentEndpoints()
	 * @generated
	 */
	void setMaxConcurrentEndpoints(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxConcurrentEndpoints <em>Max Concurrent Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMaxConcurrentEndpoints()
	 * @see #getMaxConcurrentEndpoints()
	 * @see #setMaxConcurrentEndpoints(int)
	 * @generated
	 */
	void unsetMaxConcurrentEndpoints();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getMaxConcurrentEndpoints <em>Max Concurrent Endpoints</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Concurrent Endpoints</em>' attribute is set.
	 * @see #unsetMaxConcurrentEndpoints()
	 * @see #getMaxConcurrentEndpoints()
	 * @see #setMaxConcurrentEndpoints(int)
	 * @generated
	 */
	boolean isSetMaxConcurrentEndpoints();

	/**
	 * Returns the value of the '<em><b>Share Durable Subscription</b></em>' attribute.
	 * The default value is <code>"In cluster"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Share Durable Subscription</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Share Durable Subscription</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum
	 * @see #isSetShareDurableSubscription()
	 * @see #unsetShareDurableSubscription()
	 * @see #setShareDurableSubscription(ShareDurableSubscriptionsEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasJMSActivationSpecification_ShareDurableSubscription()
	 * @model default="In cluster" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='shareDurableSubscription'"
	 * @generated
	 */
	ShareDurableSubscriptionsEnum getShareDurableSubscription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getShareDurableSubscription <em>Share Durable Subscription</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Share Durable Subscription</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum
	 * @see #isSetShareDurableSubscription()
	 * @see #unsetShareDurableSubscription()
	 * @see #getShareDurableSubscription()
	 * @generated
	 */
	void setShareDurableSubscription(ShareDurableSubscriptionsEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getShareDurableSubscription <em>Share Durable Subscription</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetShareDurableSubscription()
	 * @see #getShareDurableSubscription()
	 * @see #setShareDurableSubscription(ShareDurableSubscriptionsEnum)
	 * @generated
	 */
	void unsetShareDurableSubscription();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification#getShareDurableSubscription <em>Share Durable Subscription</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Share Durable Subscription</em>' attribute is set.
	 * @see #unsetShareDurableSubscription()
	 * @see #getShareDurableSubscription()
	 * @see #setShareDurableSubscription(ShareDurableSubscriptionsEnum)
	 * @generated
	 */
	boolean isSetShareDurableSubscription();

} // WasJMSActivationSpecification
