/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum;
import com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum;
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
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class JmsPackageImpl extends EPackageImpl implements JmsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsActivationSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsActivationSpecificationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsQueueConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsQueueConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsQueueDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsQueueDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsTopicConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsTopicConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsTopicDestinationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jmsTopicDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum acknowledgeModeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum destinationTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType acknowledgeModeEnumObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType destinationTypeEnumObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JmsPackageImpl() {
		super(eNS_URI, JmsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JmsPackage init() {
		if (isInited) return (JmsPackage)EPackage.Registry.INSTANCE.getEPackage(JmsPackage.eNS_URI);

		// Obtain or create and register package
		JmsPackageImpl theJmsPackage = (JmsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof JmsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new JmsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJmsPackage.createPackageContents();

		// Initialize created meta-data
		theJmsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJmsPackage.freeze();

		return theJmsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSActivationSpecification() {
		return jmsActivationSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_AcknowledgeMode() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_ClientIdentifier() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_JndiName() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_MesasageSelector() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_SpecificationName() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_SubscriptionDurable() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSActivationSpecification_SubscriptionName() {
		return (EAttribute)jmsActivationSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSActivationSpecificationUnit() {
		return jmsActivationSpecificationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSConnectionFactory() {
		return jmsConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSConnectionFactory_FactoryName() {
		return (EAttribute)jmsConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSConnectionFactory_JndiName() {
		return (EAttribute)jmsConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSConnectionFactoryUnit() {
		return jmsConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSDeployRoot() {
		return jmsDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSDeployRoot_Mixed() {
		return (EAttribute)jmsDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_XMLNSPrefixMap() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_XSISchemaLocation() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSActivationSpecification() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSConnectionFactory() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSDestination() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSProvider() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSQueueConnectionFactory() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSQueueDestination() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSTopicConnectionFactory() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_CapabilityJMSTopicDestination() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSActivationSpecificationUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSConnectionFactoryUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSProviderUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSQueueDestinationUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJMSDeployRoot_UnitJMSTopicDestinationUnit() {
		return (EReference)jmsDeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSDestination() {
		return jmsDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSDestination_DestinationName() {
		return (EAttribute)jmsDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSDestination_JndiName() {
		return (EAttribute)jmsDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSProvider() {
		return jmsProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_ClassPath() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_InitialContextFactory() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_NativePath() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_ProviderName() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_ProviderURL() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSProvider_ProviderVersion() {
		return (EAttribute)jmsProviderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSProviderUnit() {
		return jmsProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSQueueConnectionFactory() {
		return jmsQueueConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSQueueConnectionFactory_FactoryName() {
		return (EAttribute)jmsQueueConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSQueueConnectionFactory_JndiName() {
		return (EAttribute)jmsQueueConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSQueueConnectionFactoryUnit() {
		return jmsQueueConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSQueueDestination() {
		return jmsQueueDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSQueueDestinationUnit() {
		return jmsQueueDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSTopicConnectionFactory() {
		return jmsTopicConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSTopicConnectionFactory_FactoryName() {
		return (EAttribute)jmsTopicConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJMSTopicConnectionFactory_JndiName() {
		return (EAttribute)jmsTopicConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSTopicConnectionFactoryUnit() {
		return jmsTopicConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSTopicDestination() {
		return jmsTopicDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJMSTopicDestinationUnit() {
		return jmsTopicDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAcknowledgeModeEnum() {
		return acknowledgeModeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDestinationTypeEnum() {
		return destinationTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAcknowledgeModeEnumObject() {
		return acknowledgeModeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDestinationTypeEnumObject() {
		return destinationTypeEnumObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JmsFactory getJmsFactory() {
		return (JmsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		jmsActivationSpecificationEClass = createEClass(JMS_ACTIVATION_SPECIFICATION);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__JNDI_NAME);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE);
		createEAttribute(jmsActivationSpecificationEClass, JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME);

		jmsActivationSpecificationUnitEClass = createEClass(JMS_ACTIVATION_SPECIFICATION_UNIT);

		jmsConnectionFactoryEClass = createEClass(JMS_CONNECTION_FACTORY);
		createEAttribute(jmsConnectionFactoryEClass, JMS_CONNECTION_FACTORY__FACTORY_NAME);
		createEAttribute(jmsConnectionFactoryEClass, JMS_CONNECTION_FACTORY__JNDI_NAME);

		jmsConnectionFactoryUnitEClass = createEClass(JMS_CONNECTION_FACTORY_UNIT);

		jmsDeployRootEClass = createEClass(JMS_DEPLOY_ROOT);
		createEAttribute(jmsDeployRootEClass, JMS_DEPLOY_ROOT__MIXED);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT);
		createEReference(jmsDeployRootEClass, JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT);

		jmsDestinationEClass = createEClass(JMS_DESTINATION);
		createEAttribute(jmsDestinationEClass, JMS_DESTINATION__DESTINATION_NAME);
		createEAttribute(jmsDestinationEClass, JMS_DESTINATION__JNDI_NAME);

		jmsProviderEClass = createEClass(JMS_PROVIDER);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__CLASS_PATH);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__NATIVE_PATH);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__INITIAL_CONTEXT_FACTORY);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__PROVIDER_NAME);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__PROVIDER_URL);
		createEAttribute(jmsProviderEClass, JMS_PROVIDER__PROVIDER_VERSION);

		jmsProviderUnitEClass = createEClass(JMS_PROVIDER_UNIT);

		jmsQueueConnectionFactoryEClass = createEClass(JMS_QUEUE_CONNECTION_FACTORY);
		createEAttribute(jmsQueueConnectionFactoryEClass, JMS_QUEUE_CONNECTION_FACTORY__FACTORY_NAME);
		createEAttribute(jmsQueueConnectionFactoryEClass, JMS_QUEUE_CONNECTION_FACTORY__JNDI_NAME);

		jmsQueueConnectionFactoryUnitEClass = createEClass(JMS_QUEUE_CONNECTION_FACTORY_UNIT);

		jmsQueueDestinationEClass = createEClass(JMS_QUEUE_DESTINATION);

		jmsQueueDestinationUnitEClass = createEClass(JMS_QUEUE_DESTINATION_UNIT);

		jmsTopicConnectionFactoryEClass = createEClass(JMS_TOPIC_CONNECTION_FACTORY);
		createEAttribute(jmsTopicConnectionFactoryEClass, JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME);
		createEAttribute(jmsTopicConnectionFactoryEClass, JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME);

		jmsTopicConnectionFactoryUnitEClass = createEClass(JMS_TOPIC_CONNECTION_FACTORY_UNIT);

		jmsTopicDestinationEClass = createEClass(JMS_TOPIC_DESTINATION);

		jmsTopicDestinationUnitEClass = createEClass(JMS_TOPIC_DESTINATION_UNIT);

		// Create enums
		acknowledgeModeEnumEEnum = createEEnum(ACKNOWLEDGE_MODE_ENUM);
		destinationTypeEnumEEnum = createEEnum(DESTINATION_TYPE_ENUM);

		// Create data types
		acknowledgeModeEnumObjectEDataType = createEDataType(ACKNOWLEDGE_MODE_ENUM_OBJECT);
		destinationTypeEnumObjectEDataType = createEDataType(DESTINATION_TYPE_ENUM_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		jmsActivationSpecificationEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsActivationSpecificationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsConnectionFactoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsConnectionFactoryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsDestinationEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsProviderEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsProviderUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsQueueConnectionFactoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsQueueConnectionFactoryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsQueueDestinationEClass.getESuperTypes().add(this.getJMSDestination());
		jmsQueueDestinationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsTopicConnectionFactoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		jmsTopicConnectionFactoryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jmsTopicDestinationEClass.getESuperTypes().add(this.getJMSDestination());
		jmsTopicDestinationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(jmsActivationSpecificationEClass, JMSActivationSpecification.class, "JMSActivationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_AcknowledgeMode(), this.getAcknowledgeModeEnum(), "acknowledgeMode", "Auto-acknowledge", 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJMSActivationSpecification_ClientIdentifier(), theXMLTypePackage.getString(), "clientIdentifier", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_MesasageSelector(), theXMLTypePackage.getString(), "mesasageSelector", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_SpecificationName(), theXMLTypePackage.getString(), "specificationName", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_SubscriptionDurable(), theXMLTypePackage.getBoolean(), "subscriptionDurable", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSActivationSpecification_SubscriptionName(), theXMLTypePackage.getString(), "subscriptionName", null, 0, 1, JMSActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsActivationSpecificationUnitEClass, JMSActivationSpecificationUnit.class, "JMSActivationSpecificationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsConnectionFactoryEClass, JMSConnectionFactory.class, "JMSConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSConnectionFactory_FactoryName(), theXMLTypePackage.getString(), "factoryName", null, 0, 1, JMSConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSConnectionFactory_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, JMSConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsConnectionFactoryUnitEClass, JMSConnectionFactoryUnit.class, "JMSConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsDeployRootEClass, JMSDeployRoot.class, "JMSDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSActivationSpecification(), this.getJMSActivationSpecification(), null, "capabilityJMSActivationSpecification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSConnectionFactory(), this.getJMSConnectionFactory(), null, "capabilityJMSConnectionFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSDestination(), this.getJMSDestination(), null, "capabilityJMSDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSProvider(), this.getJMSProvider(), null, "capabilityJMSProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSQueueConnectionFactory(), this.getJMSQueueConnectionFactory(), null, "capabilityJMSQueueConnectionFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSQueueDestination(), this.getJMSQueueDestination(), null, "capabilityJMSQueueDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSTopicConnectionFactory(), this.getJMSTopicConnectionFactory(), null, "capabilityJMSTopicConnectionFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_CapabilityJMSTopicDestination(), this.getJMSTopicDestination(), null, "capabilityJMSTopicDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSActivationSpecificationUnit(), this.getJMSActivationSpecificationUnit(), null, "unitJMSActivationSpecificationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSConnectionFactoryUnit(), this.getJMSConnectionFactoryUnit(), null, "unitJMSConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSProviderUnit(), this.getJMSProviderUnit(), null, "unitJMSProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit(), this.getJMSQueueConnectionFactoryUnit(), null, "unitJMSQueueConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSQueueDestinationUnit(), this.getJMSQueueDestinationUnit(), null, "unitJMSQueueDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit(), this.getJMSTopicConnectionFactoryUnit(), null, "unitJMSTopicConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJMSDeployRoot_UnitJMSTopicDestinationUnit(), this.getJMSTopicDestinationUnit(), null, "unitJMSTopicDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsDestinationEClass, JMSDestination.class, "JMSDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSDestination_DestinationName(), theXMLTypePackage.getString(), "destinationName", null, 0, 1, JMSDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSDestination_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, JMSDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsProviderEClass, JMSProvider.class, "JMSProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSProvider_ClassPath(), theXMLTypePackage.getString(), "classPath", null, 0, -1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSProvider_NativePath(), theXMLTypePackage.getString(), "nativePath", null, 0, -1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSProvider_InitialContextFactory(), theXMLTypePackage.getString(), "initialContextFactory", null, 0, 1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSProvider_ProviderName(), theXMLTypePackage.getString(), "providerName", null, 0, 1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSProvider_ProviderURL(), theXMLTypePackage.getAnyURI(), "providerURL", null, 0, 1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSProvider_ProviderVersion(), theCorePackage.getVersionString(), "providerVersion", null, 0, 1, JMSProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsProviderUnitEClass, JMSProviderUnit.class, "JMSProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsQueueConnectionFactoryEClass, JMSQueueConnectionFactory.class, "JMSQueueConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSQueueConnectionFactory_FactoryName(), theXMLTypePackage.getString(), "factoryName", null, 0, 1, JMSQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSQueueConnectionFactory_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, JMSQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsQueueConnectionFactoryUnitEClass, JMSQueueConnectionFactoryUnit.class, "JMSQueueConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsQueueDestinationEClass, JMSQueueDestination.class, "JMSQueueDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsQueueDestinationUnitEClass, JMSQueueDestinationUnit.class, "JMSQueueDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsTopicConnectionFactoryEClass, JMSTopicConnectionFactory.class, "JMSTopicConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJMSTopicConnectionFactory_FactoryName(), theXMLTypePackage.getString(), "factoryName", null, 0, 1, JMSTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJMSTopicConnectionFactory_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, JMSTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jmsTopicConnectionFactoryUnitEClass, JMSTopicConnectionFactoryUnit.class, "JMSTopicConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsTopicDestinationEClass, JMSTopicDestination.class, "JMSTopicDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jmsTopicDestinationUnitEClass, JMSTopicDestinationUnit.class, "JMSTopicDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.class, "AcknowledgeModeEnum"); //$NON-NLS-1$
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.AUTO_ACKNOWLEDGE_LITERAL);
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.DUPLICATES_OK_AUTO_ACKNOWLEDGE_LITERAL);
		addEEnumLiteral(acknowledgeModeEnumEEnum, AcknowledgeModeEnum.NON_PERSISTENT_LITERAL);

		initEEnum(destinationTypeEnumEEnum, DestinationTypeEnum.class, "DestinationTypeEnum"); //$NON-NLS-1$
		addEEnumLiteral(destinationTypeEnumEEnum, DestinationTypeEnum.JAVAX_JMS_QUEUE_LITERAL);
		addEEnumLiteral(destinationTypeEnumEEnum, DestinationTypeEnum.JAVAX_JMS_TOPIC_LITERAL);

		// Initialize data types
		initEDataType(acknowledgeModeEnumObjectEDataType, AcknowledgeModeEnum.class, "AcknowledgeModeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(destinationTypeEnumObjectEDataType, DestinationTypeEnum.class, "DestinationTypeEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (acknowledgeModeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "AcknowledgeModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (acknowledgeModeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "AcknowledgeModeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "AcknowledgeModeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (destinationTypeEnumEEnum, 
		   source, 
		   new String[] {
			 "name", "DestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (destinationTypeEnumObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DestinationTypeEnum:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DestinationTypeEnum" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsActivationSpecificationEClass, 
		   source, 
		   new String[] {
			 "name", "JMSActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_AcknowledgeMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "acknowledgeMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_ClientIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_MesasageSelector(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mesasageSelector" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_SpecificationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "specificationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_SubscriptionDurable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subscriptionDurable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSActivationSpecification_SubscriptionName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subscriptionName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsActivationSpecificationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsConnectionFactoryEClass, 
		   source, 
		   new String[] {
			 "name", "JMSConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSConnectionFactory_FactoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSConnectionFactory_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSActivationSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSQueueConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSQueueConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSQueueDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSTopicConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSTopicConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_CapabilityJMSTopicDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.JMSTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSActivationSpecificationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSQueueDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDeployRoot_UnitJMSTopicDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.JMSTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "JMSDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDestination_DestinationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSDestination_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsProviderEClass, 
		   source, 
		   new String[] {
			 "name", "JMSProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_ClassPath(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classPath", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_NativePath(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nativePath", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_InitialContextFactory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initialContextFactory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_ProviderName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_ProviderURL(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerURL" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSProvider_ProviderVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsQueueConnectionFactoryEClass, 
		   source, 
		   new String[] {
			 "name", "JMSQueueConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSQueueConnectionFactory_FactoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSQueueConnectionFactory_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsQueueConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsQueueDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "JMSQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsQueueDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsTopicConnectionFactoryEClass, 
		   source, 
		   new String[] {
			 "name", "JMSTopicConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSTopicConnectionFactory_FactoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJMSTopicConnectionFactory_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsTopicConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsTopicDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "JMSTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jmsTopicDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JMSTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //JmsPackageImpl
