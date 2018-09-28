/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.jms.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployPlugin;
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
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

/**
 * Validator identifiers for the {@link JmsPackage} deploy domain.
 */

public interface IJMSValidatorID {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSProvider} of a {@link JMSProviderUnit} has an illegal
	 * {@link JMSProvider#getClassPath()} value
	 * </ul>
	 */
	public final static String JMS_PROVIDER_UNIT_CLASSPATH_INVALID_001 = JMSDeployPlugin.pluginID
			+ ".JMS_PROVIDER_UNIT_CLASSPATH_INVALID_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSQueueConnectionFactory} of a
	 * {@link JMSQueueConnectionFactoryUnit} has an illegal
	 * {@link JMSQueueConnectionFactory#getFactoryName()} value
	 * </ul>
	 */
	public final static String JMS_QUEUE_CONNECTIONFACTORY_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_CONNECTIONFACTORY_NAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSQueueConnectionFactory} of a
	 * {@link JMSQueueConnectionFactoryUnit} does not have a unique value
	 * {@link JMSQueueConnectionFactory#getFactoryName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_QUEUE_CONNECTIONFACTORY_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_CONNECTIONFACTORY_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} does not
	 * have a unique value {@link JMSDestination#getDestinationName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_QUEUE_DESTINATION_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_DESTINATION_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} does not
	 * have a unique value {@link JMSDestination#getDestinationName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_TOPIC_DESTINATION_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_DESTINATION_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSTopicConnectionFactory} of a
	 * {@link JMSTopicConnectionFactoryUnit} does not have a unique value
	 * {@link JMSTopicConnectionFactory#getFactoryName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_TOPIC_CONNECTIONFACTORY_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_CONNECTIONFACTORY_NAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSConnectionFactory} of a {@link JMSConnectionFactoryUnit} does
	 * not have a unique value {@link JMSConnectionFactory#getFactoryName()} in the context of the
	 * hosting
	 * </ul>
	 */
	public final static String JMS_CONNECTIONFACTORY_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_CONNECTIONFACTORY_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSTopicConnectionFactory} of a
	 * {@link JMSTopicConnectionFactoryUnit} has an illegal
	 * {@link JMSTopicConnectionFactory#getFactoryName()} value
	 * </ul>
	 */
	public final static String JMS_TOPIC_CONNECTIONFACTORY_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_CONNECTIONFACTORY_NAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSConnectionFactory} of a {@link JMSConnectionFactoryUnit} has
	 * an illegal {@link JMSConnectionFactory#getFactoryName()} value
	 * </ul>
	 */
	public final static String JMS_CONNECTIONFACTORY_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_CONNECTIONFACTORY_NAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSConnectionFactory} of a {@link JMSConnectionFactoryUnit} has
	 * an illegal {@link JMSConnectionFactory#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSQueueConnectionFactory} of a
	 * {@link JMSQueueConnectionFactoryUnit} has an illegal
	 * {@link JMSQueueConnectionFactory#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_QUEUE_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} has an
	 * illegal {@link JMSDestination#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_QUEUE_DESTINATION_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_DESTINATION_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} has an
	 * illegal {@link JMSDestination#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_TOPIC_DESTINATION_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_DESTINATION_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSTopicConnectionFactory} of a
	 * {@link JMSTopicConnectionFactoryUnit} has an illegal
	 * {@link JMSTopicConnectionFactory#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSConnectionFactory} of a {@link JMSConnectionFactoryUnit} does
	 * not have a unique value {@link JMSConnectionFactory#getJndiName()} in the context of the
	 * hosting
	 * </ul>
	 */
	public final static String JMS_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSQueueConnectionFactory} of a
	 * {@link JMSQueueConnectionFactoryUnit} does not have a unique value
	 * {@link JMSQueueConnectionFactory#getJndiName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_QUEUE_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} does not
	 * have a unique value {@link JMSDestination#getJndiName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_QUEUE_DESTINATION_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_DESTINATION_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSDestination} of a {@link JMSQueueDestinationUnit} does not
	 * have a unique value {@link JMSDestination#getJndiName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_TOPIC_DESTINATION_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_DESTINATION_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSTopicConnectionFactory} of a
	 * {@link JMSTopicConnectionFactoryUnit} does not have a unique value
	 * {@link JMSTopicConnectionFactory#getJndiName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_CONNECTIONFACTORY_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSQueueDestination} of a {@link JMSQueueDestinationUnit} has an
	 * illegal {@link JMSQueueDestination#getDestinationName()} value
	 * </ul>
	 */
	public final static String JMS_QUEUE_DESTINATION_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_QUEUE_DESTINATION_NAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSTopicDestination} of a {@link JMSTopicDestinationUnit} has an
	 * illegal {@link JMSTopicDestination#getDestinationName()} value
	 * </ul>
	 */
	public final static String JMS_TOPIC_DESTINATION_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_TOPIC_DESTINATION_NAME_NOT_EMPTY_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSActivationSpecification} of a
	 * {@link JMSConnectionFactoryUnit} has an illegal
	 * {@link JMSActivationSpecification#getSpecificationName()} value
	 * </ul>
	 */
	public final static String JMS_ACTIVATIONSPECIFICATION_NAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_ACTIVATIONSPECIFICATION_NAME_NOT_EMPTY_001"; //$NON-NLS-1$	
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSActivationSpecification} of a
	 * {@link JMSConnectionFactoryUnit} does not have a unique value
	 * {@link JMSActivationSpecification#getSpecificationName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_ACTIVATIONSPECIFICATION_NAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_ACTIVATIONSPECIFICATION_NAME_UNIQUENESS_001"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSActivationSpecification} of a
	 * {@link JMSConnectionFactoryUnit} has an illegal
	 * {@link JMSActivationSpecification#getJndiName()} value
	 * </ul>
	 */
	public final static String JMS_ACTIVATIONSPECIFICATION_JNDINAME_NOT_EMPTY_001 = JMSDeployPlugin.pluginID
			+ ".JMS_ACTIVATIONSPECIFICATION_JNDINAME_NOT_EMPTY_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link JMSActivationSpecification} of a
	 * {@link JMSConnectionFactoryUnit} does not have a unique value
	 * {@link JMSActivationSpecification#getJndiName()} in the context of the hosting
	 * </ul>
	 */
	public final static String JMS_ACTIVATIONSPECIFICATION_JNDINAME_UNIQUENESS_001 = JMSDeployPlugin.pluginID
			+ ".JMS_ACTIVATIONSPECIFICATION_JNDINAME_UNIQUENESS_001"; //$NON-NLS-1$	

}
