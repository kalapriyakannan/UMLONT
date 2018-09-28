/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.j2ee.validator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.j2ee.jms.IJmsTemplateConstants;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJNDIBindingConstraintValidator;
import com.ibm.ccl.soa.deploy.was.validator.resolution.RemoveWasJ2EEConstraintResolutionGenerator;

public class WasJmsRealizationTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasJmsRealizationTest";

	private NullProgressMonitor monitor = new NullProgressMonitor();
	private WasJNDIBindingConstraintValidator validator = new WasJNDIBindingConstraintValidator();
    private DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	private RemoveWasJ2EEConstraintResolutionGenerator removeGenerator = new RemoveWasJ2EEConstraintResolutionGenerator();
	
	private static EClass WasJNDIBindingConstraintType = WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT;
	private static String WasJNDIBindingConstraintName = "WebSphere JNDI Binding Constraint";


	/**
	 * 
	 * 
	 */
	public WasJmsRealizationTest() {
		super(PROJECT_NAME);
	}
	
	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}
	
	public void testJMSQueueRealization() throws Exception {
		Topology t = createTopology ("testJMSQueueRealization");
		Unit jms = (Unit) ResolutionUtils.addFromTemplate(IJmsTemplateConstants.JMS_QUEUE_DESTINATION, t);
		Unit was = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT, t);
		assert dvs.canCreateLink(jms, was, LinkType.REALIZATION_SET).isOK();
		Unit wasC = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT_CONCEPTUAL, t);
		assert dvs.canCreateLink(jms, wasC, LinkType.REALIZATION_SET).isOK();
	}	

	public void testJMSQueueCFRealization() throws Exception {
		Topology t = createTopology ("testJMSQueueCFRealization");
		Unit jms = (Unit) ResolutionUtils.addFromTemplate(IJmsTemplateConstants.JMS_QUEUE_CONNECTION_FACTORY, t);
		Unit was = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT, t);
		assert dvs.canCreateLink(jms, was, LinkType.REALIZATION_SET).isOK();
		Unit wasC = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT_CONCEPTUAL, t);
		assert dvs.canCreateLink(jms, wasC, LinkType.REALIZATION_SET).isOK();
	}	

	public void testJMSTopicRealization() throws Exception {
		Topology t = createTopology ("testJMSTopicRealization");
		Unit jms = (Unit) ResolutionUtils.addFromTemplate(IJmsTemplateConstants.JMS_TOPIC_DESTINATION, t);
		Unit was = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT, t);
		assert dvs.canCreateLink(jms, was, LinkType.REALIZATION_SET).isOK();
		Unit wasC = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT_CONCEPTUAL, t);
		assert dvs.canCreateLink(jms, wasC, LinkType.REALIZATION_SET).isOK();
	}	

	public void testJMSTopicCFRealization() throws Exception {
		Topology t = createTopology ("testJMSTopicCFRealization");
		Unit jms = (Unit) ResolutionUtils.addFromTemplate(IJmsTemplateConstants.JMS_TOPIC_CONNECTION_FACTORY, t);
		Unit was = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT, t);
		assert dvs.canCreateLink(jms, was, LinkType.REALIZATION_SET).isOK();
		Unit wasC = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT_CONCEPTUAL, t);
		assert dvs.canCreateLink(jms, wasC, LinkType.REALIZATION_SET).isOK();
	}	

	public void testJMSActivationSpecificationRealization() throws Exception {
		Topology t = createTopology ("testJMSActivationSpecificationRealization");
		Unit jms = (Unit) ResolutionUtils.addFromTemplate(IJmsTemplateConstants.JMS_ACTIVATION_SPECIFICATION, t);
		Unit was = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT, t);
		assert dvs.canCreateLink(jms, was, LinkType.REALIZATION_SET).isOK();
		Unit wasC = (Unit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT_CONCEPTUAL, t);
		assert dvs.canCreateLink(jms, wasC, LinkType.REALIZATION_SET).isOK();
	}	

}
