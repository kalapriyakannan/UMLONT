/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage
 * @generated
 */
public class JmsSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static JmsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JmsSwitch() {
		if (modelPackage == null) {
			modelPackage = JmsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JmsPackage.JMS_ACTIVATION_SPECIFICATION: {
				JMSActivationSpecification jmsActivationSpecification = (JMSActivationSpecification)theEObject;
				Object result = caseJMSActivationSpecification(jmsActivationSpecification);
				if (result == null) result = caseCapability(jmsActivationSpecification);
				if (result == null) result = caseDeployModelObject(jmsActivationSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_ACTIVATION_SPECIFICATION_UNIT: {
				JMSActivationSpecificationUnit jmsActivationSpecificationUnit = (JMSActivationSpecificationUnit)theEObject;
				Object result = caseJMSActivationSpecificationUnit(jmsActivationSpecificationUnit);
				if (result == null) result = caseUnit(jmsActivationSpecificationUnit);
				if (result == null) result = caseDeployModelObject(jmsActivationSpecificationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_CONNECTION_FACTORY: {
				JMSConnectionFactory jmsConnectionFactory = (JMSConnectionFactory)theEObject;
				Object result = caseJMSConnectionFactory(jmsConnectionFactory);
				if (result == null) result = caseCapability(jmsConnectionFactory);
				if (result == null) result = caseDeployModelObject(jmsConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_CONNECTION_FACTORY_UNIT: {
				JMSConnectionFactoryUnit jmsConnectionFactoryUnit = (JMSConnectionFactoryUnit)theEObject;
				Object result = caseJMSConnectionFactoryUnit(jmsConnectionFactoryUnit);
				if (result == null) result = caseUnit(jmsConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(jmsConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_DEPLOY_ROOT: {
				JMSDeployRoot jmsDeployRoot = (JMSDeployRoot)theEObject;
				Object result = caseJMSDeployRoot(jmsDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_DESTINATION: {
				JMSDestination jmsDestination = (JMSDestination)theEObject;
				Object result = caseJMSDestination(jmsDestination);
				if (result == null) result = caseCapability(jmsDestination);
				if (result == null) result = caseDeployModelObject(jmsDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_PROVIDER: {
				JMSProvider jmsProvider = (JMSProvider)theEObject;
				Object result = caseJMSProvider(jmsProvider);
				if (result == null) result = caseCapability(jmsProvider);
				if (result == null) result = caseDeployModelObject(jmsProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_PROVIDER_UNIT: {
				JMSProviderUnit jmsProviderUnit = (JMSProviderUnit)theEObject;
				Object result = caseJMSProviderUnit(jmsProviderUnit);
				if (result == null) result = caseUnit(jmsProviderUnit);
				if (result == null) result = caseDeployModelObject(jmsProviderUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_QUEUE_CONNECTION_FACTORY: {
				JMSQueueConnectionFactory jmsQueueConnectionFactory = (JMSQueueConnectionFactory)theEObject;
				Object result = caseJMSQueueConnectionFactory(jmsQueueConnectionFactory);
				if (result == null) result = caseCapability(jmsQueueConnectionFactory);
				if (result == null) result = caseDeployModelObject(jmsQueueConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_QUEUE_CONNECTION_FACTORY_UNIT: {
				JMSQueueConnectionFactoryUnit jmsQueueConnectionFactoryUnit = (JMSQueueConnectionFactoryUnit)theEObject;
				Object result = caseJMSQueueConnectionFactoryUnit(jmsQueueConnectionFactoryUnit);
				if (result == null) result = caseUnit(jmsQueueConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(jmsQueueConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_QUEUE_DESTINATION: {
				JMSQueueDestination jmsQueueDestination = (JMSQueueDestination)theEObject;
				Object result = caseJMSQueueDestination(jmsQueueDestination);
				if (result == null) result = caseJMSDestination(jmsQueueDestination);
				if (result == null) result = caseCapability(jmsQueueDestination);
				if (result == null) result = caseDeployModelObject(jmsQueueDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_QUEUE_DESTINATION_UNIT: {
				JMSQueueDestinationUnit jmsQueueDestinationUnit = (JMSQueueDestinationUnit)theEObject;
				Object result = caseJMSQueueDestinationUnit(jmsQueueDestinationUnit);
				if (result == null) result = caseUnit(jmsQueueDestinationUnit);
				if (result == null) result = caseDeployModelObject(jmsQueueDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY: {
				JMSTopicConnectionFactory jmsTopicConnectionFactory = (JMSTopicConnectionFactory)theEObject;
				Object result = caseJMSTopicConnectionFactory(jmsTopicConnectionFactory);
				if (result == null) result = caseCapability(jmsTopicConnectionFactory);
				if (result == null) result = caseDeployModelObject(jmsTopicConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY_UNIT: {
				JMSTopicConnectionFactoryUnit jmsTopicConnectionFactoryUnit = (JMSTopicConnectionFactoryUnit)theEObject;
				Object result = caseJMSTopicConnectionFactoryUnit(jmsTopicConnectionFactoryUnit);
				if (result == null) result = caseUnit(jmsTopicConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(jmsTopicConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_TOPIC_DESTINATION: {
				JMSTopicDestination jmsTopicDestination = (JMSTopicDestination)theEObject;
				Object result = caseJMSTopicDestination(jmsTopicDestination);
				if (result == null) result = caseJMSDestination(jmsTopicDestination);
				if (result == null) result = caseCapability(jmsTopicDestination);
				if (result == null) result = caseDeployModelObject(jmsTopicDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmsPackage.JMS_TOPIC_DESTINATION_UNIT: {
				JMSTopicDestinationUnit jmsTopicDestinationUnit = (JMSTopicDestinationUnit)theEObject;
				Object result = caseJMSTopicDestinationUnit(jmsTopicDestinationUnit);
				if (result == null) result = caseUnit(jmsTopicDestinationUnit);
				if (result == null) result = caseDeployModelObject(jmsTopicDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSActivationSpecification(JMSActivationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Activation Specification Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSActivationSpecificationUnit(JMSActivationSpecificationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSConnectionFactory(JMSConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSConnectionFactoryUnit(JMSConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSDeployRoot(JMSDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSDestination(JMSDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Provider</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSProvider(JMSProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Provider Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSProviderUnit(JMSProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueConnectionFactory(JMSQueueConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueDestination(JMSQueueDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Queue Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Queue Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSQueueDestinationUnit(JMSQueueDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicConnectionFactory(JMSTopicConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Destination</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicDestination(JMSTopicDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMS Topic Destination Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMS Topic Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJMSTopicDestinationUnit(JMSTopicDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //JmsSwitch
