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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage
 * @generated
 */
public class JmsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static JmsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JmsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JmsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected JmsSwitch modelSwitch = new JmsSwitch() {
			public Object caseJMSActivationSpecification(JMSActivationSpecification object) {
				return createJMSActivationSpecificationAdapter();
			}
			public Object caseJMSActivationSpecificationUnit(JMSActivationSpecificationUnit object) {
				return createJMSActivationSpecificationUnitAdapter();
			}
			public Object caseJMSConnectionFactory(JMSConnectionFactory object) {
				return createJMSConnectionFactoryAdapter();
			}
			public Object caseJMSConnectionFactoryUnit(JMSConnectionFactoryUnit object) {
				return createJMSConnectionFactoryUnitAdapter();
			}
			public Object caseJMSDeployRoot(JMSDeployRoot object) {
				return createJMSDeployRootAdapter();
			}
			public Object caseJMSDestination(JMSDestination object) {
				return createJMSDestinationAdapter();
			}
			public Object caseJMSProvider(JMSProvider object) {
				return createJMSProviderAdapter();
			}
			public Object caseJMSProviderUnit(JMSProviderUnit object) {
				return createJMSProviderUnitAdapter();
			}
			public Object caseJMSQueueConnectionFactory(JMSQueueConnectionFactory object) {
				return createJMSQueueConnectionFactoryAdapter();
			}
			public Object caseJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit object) {
				return createJMSQueueConnectionFactoryUnitAdapter();
			}
			public Object caseJMSQueueDestination(JMSQueueDestination object) {
				return createJMSQueueDestinationAdapter();
			}
			public Object caseJMSQueueDestinationUnit(JMSQueueDestinationUnit object) {
				return createJMSQueueDestinationUnitAdapter();
			}
			public Object caseJMSTopicConnectionFactory(JMSTopicConnectionFactory object) {
				return createJMSTopicConnectionFactoryAdapter();
			}
			public Object caseJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit object) {
				return createJMSTopicConnectionFactoryUnitAdapter();
			}
			public Object caseJMSTopicDestination(JMSTopicDestination object) {
				return createJMSTopicDestinationAdapter();
			}
			public Object caseJMSTopicDestinationUnit(JMSTopicDestinationUnit object) {
				return createJMSTopicDestinationUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification <em>JMS Activation Specification</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification
	 * @generated
	 */
	public Adapter createJMSActivationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit <em>JMS Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit
	 * @generated
	 */
	public Adapter createJMSActivationSpecificationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory <em>JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory
	 * @generated
	 */
	public Adapter createJMSConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit <em>JMS Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot <em>JMS Deploy Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot
	 * @generated
	 */
	public Adapter createJMSDeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination <em>JMS Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination
	 * @generated
	 */
	public Adapter createJMSDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider <em>JMS Provider</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider
	 * @generated
	 */
	public Adapter createJMSProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit <em>JMS Provider Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit
	 * @generated
	 */
	public Adapter createJMSProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory <em>JMS Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory
	 * @generated
	 */
	public Adapter createJMSQueueConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit <em>JMS Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSQueueConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination <em>JMS Queue Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination
	 * @generated
	 */
	public Adapter createJMSQueueDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit <em>JMS Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit
	 * @generated
	 */
	public Adapter createJMSQueueDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory <em>JMS Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory
	 * @generated
	 */
	public Adapter createJMSTopicConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit <em>JMS Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createJMSTopicConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination <em>JMS Topic Destination</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination
	 * @generated
	 */
	public Adapter createJMSTopicDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit <em>JMS Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit
	 * @generated
	 */
	public Adapter createJMSTopicDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JmsAdapterFactory
