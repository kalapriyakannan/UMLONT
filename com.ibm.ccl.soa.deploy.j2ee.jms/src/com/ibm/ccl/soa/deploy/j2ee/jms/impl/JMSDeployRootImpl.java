/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSActivationSpecification <em>Capability JMS Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSConnectionFactory <em>Capability JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSDestination <em>Capability JMS Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSProvider <em>Capability JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSQueueConnectionFactory <em>Capability JMS Queue Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSQueueDestination <em>Capability JMS Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSTopicConnectionFactory <em>Capability JMS Topic Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getCapabilityJMSTopicDestination <em>Capability JMS Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSActivationSpecificationUnit <em>Unit JMS Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSConnectionFactoryUnit <em>Unit JMS Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSProviderUnit <em>Unit JMS Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSQueueConnectionFactoryUnit <em>Unit JMS Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSQueueDestinationUnit <em>Unit JMS Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSTopicConnectionFactoryUnit <em>Unit JMS Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl#getUnitJMSTopicDestinationUnit <em>Unit JMS Topic Destination Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JMSDeployRootImpl extends EObjectImpl implements JMSDeployRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JMSDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JmsPackage.Literals.JMS_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, JmsPackage.JMS_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSActivationSpecification getCapabilityJMSActivationSpecification() {
		return (JMSActivationSpecification)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSActivationSpecification(
			JMSActivationSpecification newCapabilityJMSActivationSpecification, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION, newCapabilityJMSActivationSpecification, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSActivationSpecification(
			JMSActivationSpecification newCapabilityJMSActivationSpecification) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION, newCapabilityJMSActivationSpecification);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactory getCapabilityJMSConnectionFactory() {
		return (JMSConnectionFactory)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSConnectionFactory(
			JMSConnectionFactory newCapabilityJMSConnectionFactory, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY, newCapabilityJMSConnectionFactory, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSConnectionFactory(
			JMSConnectionFactory newCapabilityJMSConnectionFactory) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY, newCapabilityJMSConnectionFactory);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSDestination getCapabilityJMSDestination() {
		return (JMSDestination)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSDestination(
			JMSDestination newCapabilityJMSDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION, newCapabilityJMSDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSDestination(JMSDestination newCapabilityJMSDestination) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION, newCapabilityJMSDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSProvider getCapabilityJMSProvider() {
		return (JMSProvider)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSProvider(JMSProvider newCapabilityJMSProvider,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER, newCapabilityJMSProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSProvider(JMSProvider newCapabilityJMSProvider) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER, newCapabilityJMSProvider);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueConnectionFactory getCapabilityJMSQueueConnectionFactory() {
		return (JMSQueueConnectionFactory)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSQueueConnectionFactory(
			JMSQueueConnectionFactory newCapabilityJMSQueueConnectionFactory, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY, newCapabilityJMSQueueConnectionFactory, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSQueueConnectionFactory(
			JMSQueueConnectionFactory newCapabilityJMSQueueConnectionFactory) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY, newCapabilityJMSQueueConnectionFactory);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueDestination getCapabilityJMSQueueDestination() {
		return (JMSQueueDestination)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSQueueDestination(
			JMSQueueDestination newCapabilityJMSQueueDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION, newCapabilityJMSQueueDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSQueueDestination(JMSQueueDestination newCapabilityJMSQueueDestination) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION, newCapabilityJMSQueueDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicConnectionFactory getCapabilityJMSTopicConnectionFactory() {
		return (JMSTopicConnectionFactory)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSTopicConnectionFactory(
			JMSTopicConnectionFactory newCapabilityJMSTopicConnectionFactory, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY, newCapabilityJMSTopicConnectionFactory, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSTopicConnectionFactory(
			JMSTopicConnectionFactory newCapabilityJMSTopicConnectionFactory) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY, newCapabilityJMSTopicConnectionFactory);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicDestination getCapabilityJMSTopicDestination() {
		return (JMSTopicDestination)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJMSTopicDestination(
			JMSTopicDestination newCapabilityJMSTopicDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION, newCapabilityJMSTopicDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJMSTopicDestination(JMSTopicDestination newCapabilityJMSTopicDestination) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION, newCapabilityJMSTopicDestination);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSActivationSpecificationUnit getUnitJMSActivationSpecificationUnit() {
		return (JMSActivationSpecificationUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSActivationSpecificationUnit(
			JMSActivationSpecificationUnit newUnitJMSActivationSpecificationUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT, newUnitJMSActivationSpecificationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSActivationSpecificationUnit(
			JMSActivationSpecificationUnit newUnitJMSActivationSpecificationUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT, newUnitJMSActivationSpecificationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactoryUnit getUnitJMSConnectionFactoryUnit() {
		return (JMSConnectionFactoryUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSConnectionFactoryUnit(
			JMSConnectionFactoryUnit newUnitJMSConnectionFactoryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT, newUnitJMSConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSConnectionFactoryUnit(
			JMSConnectionFactoryUnit newUnitJMSConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT, newUnitJMSConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSProviderUnit getUnitJMSProviderUnit() {
		return (JMSProviderUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSProviderUnit(JMSProviderUnit newUnitJMSProviderUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT, newUnitJMSProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSProviderUnit(JMSProviderUnit newUnitJMSProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT, newUnitJMSProviderUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueConnectionFactoryUnit getUnitJMSQueueConnectionFactoryUnit() {
		return (JMSQueueConnectionFactoryUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSQueueConnectionFactoryUnit(
			JMSQueueConnectionFactoryUnit newUnitJMSQueueConnectionFactoryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT, newUnitJMSQueueConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSQueueConnectionFactoryUnit(
			JMSQueueConnectionFactoryUnit newUnitJMSQueueConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT, newUnitJMSQueueConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueDestinationUnit getUnitJMSQueueDestinationUnit() {
		return (JMSQueueDestinationUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSQueueDestinationUnit(
			JMSQueueDestinationUnit newUnitJMSQueueDestinationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT, newUnitJMSQueueDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSQueueDestinationUnit(JMSQueueDestinationUnit newUnitJMSQueueDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT, newUnitJMSQueueDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicConnectionFactoryUnit getUnitJMSTopicConnectionFactoryUnit() {
		return (JMSTopicConnectionFactoryUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSTopicConnectionFactoryUnit(
			JMSTopicConnectionFactoryUnit newUnitJMSTopicConnectionFactoryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT, newUnitJMSTopicConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSTopicConnectionFactoryUnit(
			JMSTopicConnectionFactoryUnit newUnitJMSTopicConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT, newUnitJMSTopicConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicDestinationUnit getUnitJMSTopicDestinationUnit() {
		return (JMSTopicDestinationUnit)getMixed().get(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJMSTopicDestinationUnit(
			JMSTopicDestinationUnit newUnitJMSTopicDestinationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT, newUnitJMSTopicDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJMSTopicDestinationUnit(JMSTopicDestinationUnit newUnitJMSTopicDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT, newUnitJMSTopicDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION:
				return basicSetCapabilityJMSActivationSpecification(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY:
				return basicSetCapabilityJMSConnectionFactory(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION:
				return basicSetCapabilityJMSDestination(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER:
				return basicSetCapabilityJMSProvider(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY:
				return basicSetCapabilityJMSQueueConnectionFactory(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION:
				return basicSetCapabilityJMSQueueDestination(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY:
				return basicSetCapabilityJMSTopicConnectionFactory(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION:
				return basicSetCapabilityJMSTopicDestination(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return basicSetUnitJMSActivationSpecificationUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT:
				return basicSetUnitJMSConnectionFactoryUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT:
				return basicSetUnitJMSProviderUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT:
				return basicSetUnitJMSQueueConnectionFactoryUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT:
				return basicSetUnitJMSQueueDestinationUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT:
				return basicSetUnitJMSTopicConnectionFactoryUnit(null, msgs);
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT:
				return basicSetUnitJMSTopicDestinationUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION:
				return getCapabilityJMSActivationSpecification();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY:
				return getCapabilityJMSConnectionFactory();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION:
				return getCapabilityJMSDestination();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER:
				return getCapabilityJMSProvider();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY:
				return getCapabilityJMSQueueConnectionFactory();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION:
				return getCapabilityJMSQueueDestination();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY:
				return getCapabilityJMSTopicConnectionFactory();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION:
				return getCapabilityJMSTopicDestination();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitJMSActivationSpecificationUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT:
				return getUnitJMSConnectionFactoryUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT:
				return getUnitJMSProviderUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitJMSQueueConnectionFactoryUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT:
				return getUnitJMSQueueDestinationUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitJMSTopicConnectionFactoryUnit();
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT:
				return getUnitJMSTopicDestinationUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION:
				setCapabilityJMSActivationSpecification((JMSActivationSpecification)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY:
				setCapabilityJMSConnectionFactory((JMSConnectionFactory)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION:
				setCapabilityJMSDestination((JMSDestination)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER:
				setCapabilityJMSProvider((JMSProvider)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY:
				setCapabilityJMSQueueConnectionFactory((JMSQueueConnectionFactory)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION:
				setCapabilityJMSQueueDestination((JMSQueueDestination)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY:
				setCapabilityJMSTopicConnectionFactory((JMSTopicConnectionFactory)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION:
				setCapabilityJMSTopicDestination((JMSTopicDestination)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT:
				setUnitJMSActivationSpecificationUnit((JMSActivationSpecificationUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT:
				setUnitJMSConnectionFactoryUnit((JMSConnectionFactoryUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT:
				setUnitJMSProviderUnit((JMSProviderUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitJMSQueueConnectionFactoryUnit((JMSQueueConnectionFactoryUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT:
				setUnitJMSQueueDestinationUnit((JMSQueueDestinationUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitJMSTopicConnectionFactoryUnit((JMSTopicConnectionFactoryUnit)newValue);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT:
				setUnitJMSTopicDestinationUnit((JMSTopicDestinationUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION:
				setCapabilityJMSActivationSpecification((JMSActivationSpecification)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY:
				setCapabilityJMSConnectionFactory((JMSConnectionFactory)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION:
				setCapabilityJMSDestination((JMSDestination)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER:
				setCapabilityJMSProvider((JMSProvider)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY:
				setCapabilityJMSQueueConnectionFactory((JMSQueueConnectionFactory)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION:
				setCapabilityJMSQueueDestination((JMSQueueDestination)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY:
				setCapabilityJMSTopicConnectionFactory((JMSTopicConnectionFactory)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION:
				setCapabilityJMSTopicDestination((JMSTopicDestination)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT:
				setUnitJMSActivationSpecificationUnit((JMSActivationSpecificationUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT:
				setUnitJMSConnectionFactoryUnit((JMSConnectionFactoryUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT:
				setUnitJMSProviderUnit((JMSProviderUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitJMSQueueConnectionFactoryUnit((JMSQueueConnectionFactoryUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT:
				setUnitJMSQueueDestinationUnit((JMSQueueDestinationUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitJMSTopicConnectionFactoryUnit((JMSTopicConnectionFactoryUnit)null);
				return;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT:
				setUnitJMSTopicDestinationUnit((JMSTopicDestinationUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case JmsPackage.JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case JmsPackage.JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION:
				return getCapabilityJMSActivationSpecification() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY:
				return getCapabilityJMSConnectionFactory() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION:
				return getCapabilityJMSDestination() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER:
				return getCapabilityJMSProvider() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY:
				return getCapabilityJMSQueueConnectionFactory() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION:
				return getCapabilityJMSQueueDestination() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY:
				return getCapabilityJMSTopicConnectionFactory() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION:
				return getCapabilityJMSTopicDestination() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitJMSActivationSpecificationUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT:
				return getUnitJMSConnectionFactoryUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT:
				return getUnitJMSProviderUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitJMSQueueConnectionFactoryUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT:
				return getUnitJMSQueueDestinationUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitJMSTopicConnectionFactoryUnit() != null;
			case JmsPackage.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT:
				return getUnitJMSTopicDestinationUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //JMSDeployRootImpl
