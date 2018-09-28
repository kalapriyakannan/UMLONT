/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployActionStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployActionStatus;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Tests {@link DeployCoreStatusFactory}.
 */
public class DeployCoreMessageFactoryTest extends TopologyTestCase {

	public static final String PROJECT_NAME = "DeployCoreMessageFactoryTest";

	public DeployCoreMessageFactoryTest() {
		super(PROJECT_NAME);
	}

	public interface MessageChecker {
		public void checkStatus(IDeployStatus message);
	}

	/**
	 * Checks a status in memory and after serialization.
	 * 
	 * @param topology
	 *            the topology of the message.
	 * @param status
	 *            the status to be checked, that has <b>not</b> been added to
	 *            its deploy object.
	 * @param checker
	 *            the status checker.
	 * @exception CoreException
	 *                if the marker could not be created or read.
	 */
	protected void checkStatusSerialization(Topology topology,
			IDeployStatus status, MessageChecker checker) throws CoreException {
		assert status.getSeverity() != IStatus.OK;
		assert status.getDeployObject() != null;
		assert status.getDeployObject().getStatus().getSeverity() == IStatus.OK;
		assert DeployMarker.getInstances(topology).length == 0;
		assertHasNoDeployStatus(status.getDeployObject(), status);

		// Validate before serialization
		checker.checkStatus(status);

		// Serialize status as marker ...
		IMarker marker = status.createMarker();
		assert marker != null;
		assert marker.exists();
		assert marker.getResource().equals(
				WorkbenchResourceHelper.getFile(topology));

		// Deserialize from marker ...
		IDeployStatus status2 = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(marker, topology);
		assert status2 != null;
		assert status2.getClass() == status.getClass();
		assert status2.getMarker() == marker;
		assert status2.getDeployObject() == status.getDeployObject() : status2
				.getDeployObject();
		assert status2.getSeverity() == status.getSeverity();
		assert status2.equals(status) : getString(status2) + "\n!=\n"
				+ getString(status);
		checker.checkStatus(status2);
		assert DeployMarker.getInstances(topology).length == 1;

		// Delete marker and check that status is deleted ...
		marker.delete();
		assert DeployMarker.getInstances(topology).length == 0;
		assert status.getDeployObject().getStatus().isOK();

		// Recreate marker ...
		IMarker marker2 = status2.createMarker();
		assert marker2 != null;
		assert marker2.exists();
		IDeployStatus status3 = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(marker2, topology);
		assert status3 != null;
		assert status3.getClass() == status.getClass();
		assert status3.getMarker() == marker2;
		assert status3.getDeployObject() == status.getDeployObject();
		assert status3.getSeverity() == status.getSeverity();
		assert status3.equals(status);

		checker.checkStatus(status3);
		assert DeployMarker.getInstances(topology).length == 1;

		// Delete new marker ...
		marker2.delete();
		assert DeployMarker.getInstances(topology).length == 0;
		assert ((DeployModelObject) status.getDeployObject()).getStatus()
				.getSeverity() == IStatus.OK;
	}

	public void testMessageFactory() throws Exception {
		final Topology top = createTopology("testMessageFactory", true);

		final Unit hostee = CoreFactory.eINSTANCE.createUnit();
		hostee.setName("hostee");
		top.getUnits().add(hostee);

		final Requirement hosteeConsumed = CoreFactory.eINSTANCE
				.createRequirement();
		hosteeConsumed.setName("hosteeConsumed");
		hosteeConsumed.setDmoEType(CorePackage.eINSTANCE.getCapability());
		hostee.getOnlyDependencyRequirements().add(hosteeConsumed);

		final Requirement hosteeConsumedHosting = CoreFactory.eINSTANCE
				.createRequirement();
		hosteeConsumedHosting.setName("hosteeConsumedHosting");
		hosteeConsumedHosting
				.setDmoEType(CorePackage.eINSTANCE.getCapability());
		hostee.getOnlyHostingRequirements().add(hosteeConsumedHosting);

		//
		final Unit hoster = CoreFactory.eINSTANCE.createUnit();
		hoster.setName("hoster");
		top.getUnits().add(hoster);

		final Capability hosterProvidedHosting = CoreFactory.eINSTANCE
				.createCapability();
		hosterProvidedHosting.setName("hosterProvidedHosting");
		hoster.getHostingOrAnyCapabilities().add(hosterProvidedHosting);

		final Capability hosterProvided = CoreFactory.eINSTANCE
				.createCapability();
		hosterProvided.setName("hosterProvided");
		hoster.getOnlyDependencyCapabilities().add(hosterProvided);

		final Requirement hosterReq = CoreFactory.eINSTANCE.createRequirement();
		hosterReq.setName("hosterReq");
		hosterReq.setDmoEType(CorePackage.eINSTANCE.getCapability());
		hoster.getRequirements().add(hosterReq);

		//
		final DependencyLink serviceLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		serviceLink.setName("serviceLink");
		serviceLink.setTarget(hosterProvided);
		hosteeConsumed.setLink(serviceLink);

		//
		final HostingLink hostingLink = CoreFactory.eINSTANCE
				.createHostingLink();
		hostingLink.setName("hostingLink");
		hostingLink.setHosted(hostee);
		hoster.getHostingLinks().add(hostingLink);

		top.getEObject().eResource().save(null);

		//
		// IDeployStatus
		//
		final DeployCoreStatusFactory factory = DeployCoreStatusFactory.INSTANCE;
		final String messageId = "TestMessageId";
		final String problemType = ICoreProblemType.OBJECT_CONTAINER_UNDEFINED;

		IDeployStatus message = factory.createDeployStatus(problemType, top);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		message.setUnboundMessage(messageId);
		message.setSeverity(IStatus.ERROR);

		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				assert message.getProblemType().equals(problemType);
				assert message.getSeverity() == IStatus.ERROR;
				assert message.getDeployObject().equals(top);
				assert message.getUnboundMessage().equals(messageId);
			}
		});

		//
		// IDeployStatus
		//
		message = factory.createObjectStatus(problemType, hoster);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		message.setUnboundMessage(messageId);
		message.setSeverity(IStatus.WARNING);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				assert message.getProblemType().equals(problemType);
				assert message.getSeverity() == IStatus.WARNING;
				assert message.getDeployObject().equals(hoster);
				assert message.getUnboundMessage().equals(messageId);
			}
		});

		//
		// IDeployObjectAttributeMessage
		//
		final EAttribute attribute = CorePackage.eINSTANCE
				.getDeployModelObject_Description();
		message = factory.createAttributeStatus(problemType, hoster, attribute);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		message.setUnboundMessage(messageId);
		message.setSeverity(IStatus.INFO);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployAttributeStatus aMessage = (IDeployAttributeStatus) message;
				assert message.getProblemType().equals(problemType);
				assert message.getSeverity() == IStatus.INFO;
				assert message.getDeployObject().equals(hoster);
				assert message.getUnboundMessage().equals(messageId);
				assert aMessage.getAttributeName().equals(
						DeployCoreStatusUtil.getFullEAttributeName(attribute));

			}
		});

		//
		// IDeployObjectAttributeValueMessage
		//
		final String expectedValue = "1.2.3";
		message = factory.createAttributeValueStatus(problemType, hoster,
				attribute, expectedValue);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		message.setUnboundMessage(messageId);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployAttributeValueStatus aMessage = (IDeployAttributeValueStatus) message;
				assert message.getProblemType().equals(problemType);
				assert message.getDeployObject().equals(hoster);
				assert message.getUnboundMessage().equals(messageId);
				assert aMessage.getAttributeName().equals(
						DeployCoreStatusUtil.getFullEAttributeName(attribute));
				assert aMessage.getAttributeExpectedValue(
						attribute.getEAttributeType(), top).equals(
						expectedValue);

			}
		});

		//
		// IDeployObjectAttributeValueSourceMessage
		//
		final EAttribute sourceAttribute = CorePackage.eINSTANCE
				.getDeployModelObject_Description();
		hostee.getEObject().eSet(sourceAttribute, expectedValue);
		message = factory.createAttributeValueSourceStatus(IStatus.ERROR,
				"TEST", problemType, messageId, null, hoster, attribute,
				hostee, sourceAttribute);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployAttributeValueSourceStatus aMessage = (IDeployAttributeValueSourceStatus) message;
				assert message.getProblemType().equals(problemType);
				assert message.getDeployObject().equals(hoster);
				assert message.getUnboundMessage().equals(messageId);
				assert aMessage.getAttributeName().equals(
						DeployCoreStatusUtil.getFullEAttributeName(attribute));
				assert aMessage.getAttributeExpectedValue().equals(
						expectedValue);
				assert aMessage.getAttributeExpectedValueSourceObject().equals(
						hostee);
				assert aMessage
						.getAttributeExpectedValueSourceAttributeName()
						.equals(
								DeployCoreStatusUtil
										.getFullEAttributeName(sourceAttribute));
			}
		});

		//
		// IDeployActionStatus
		//
		final List<DeployModelObject> actionParams = new ArrayList<DeployModelObject>();
		message = new DeployActionStatus(IStatus.ERROR, "TEST", problemType,
				messageId, null, hoster, actionParams);
		assert message.getMarkerType().equals(IDeployMarker.MARKER_ID);
		// empty list
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployActionStatus aMessage = (IDeployActionStatus) message;
				assert aMessage.getParameters().equals(actionParams);
			}
		});
		// list size = 1
		actionParams.add(hostee);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployActionStatus aMessage = (IDeployActionStatus) message;
				assert aMessage.getParameters().equals(actionParams);
			}
		});
		// list size = 2
		actionParams.add(hosteeConsumed);
		checkStatusSerialization(top, message, new MessageChecker() {
			public void checkStatus(IDeployStatus message) {
				IDeployActionStatus aMessage = (IDeployActionStatus) message;
				assert aMessage.getParameters().equals(actionParams);
			}
		});
	}
}
