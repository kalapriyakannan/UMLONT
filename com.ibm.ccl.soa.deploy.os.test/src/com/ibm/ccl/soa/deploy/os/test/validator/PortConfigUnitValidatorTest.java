package com.ibm.ccl.soa.deploy.os.test.validator;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.math.BigInteger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;
import com.ibm.ccl.soa.deploy.os.internal.validator.PortConfigUnitValidator;
import com.ibm.ccl.soa.deploy.os.internal.validator.PortSignature;

/**
 * Tests {@link PortConfigUnitValidator}.
 */
public class PortConfigUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "PortConfigUnitValidatorTest"; //$NON-NLS-1$

	protected OperatingSystem consumedPortOs;

	private PortConfigUnit portConfigUnit;

	public PortConfigUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testPortConfigUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("PortConfigUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		PortConfigUnitValidator validator = new PortConfigUnitValidator();

		// Provided Port
		Port providedPort1 = OsFactory.eINSTANCE.createPort();
		providedPort1.setName("providedPort1");
		providedPort1.setDisplayName("providedPort1");
		providedPort1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedPort1.setIpAddressOrHostname("foo.bar.com");
		providedPort1.setPort(BigInteger.valueOf(9060));
		providedPort1.setPortName("adminhost");
		providedPort1
				.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);

		// Provided Port
		Port providedPort2 = OsFactory.eINSTANCE.createPort();
		providedPort2.setName("providedPort2");
		providedPort2.setDisplayName("providedPort2");
		providedPort2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedPort2.setIpAddressOrHostname("foo.bar.com");
		providedPort2.setPort(BigInteger.valueOf(9090));
		providedPort2.setPortName("anotherport");
		providedPort2
				.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);

		Requirement requiredPortConsumer = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.PORT_CONSUMER,
						"requiredPortConsumer");

		portConfigUnit = OsFactory.eINSTANCE.createPortConfigUnit();
		portConfigUnit.setName("portConfigUnit");
		portConfigUnit.setDisplayName("portConfigUnit");
		portConfigUnit.setConfigurationUnit(true);

		top.getUnits().add(portConfigUnit);
		portConfigUnit.getCapabilities().add(providedPort1);
		portConfigUnit.getCapabilities().add(providedPort2);
		portConfigUnit.getRequirements().add(requiredPortConsumer);

		OperatingSystem operatingSystem = OsFactory.eINSTANCE
				.createOperatingSystem();
		operatingSystem.setName("operatingSystem");
		operatingSystem.setDisplayName("operatingSystem");
		operatingSystem.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		PortConsumer portConsumer = OsFactory.eINSTANCE.createPortConsumer();
		portConsumer.setName("portConsumer");
		portConsumer.setDisplayName("portConsumer");
		portConsumer.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);

		// Any Unit would do.
		OperatingSystemUnit operatingSystemUnit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		operatingSystemUnit.setName("operatingSystemUnit");
		operatingSystemUnit.setDisplayName("operatingSystemUnit");
		top.getUnits().add(operatingSystemUnit);
		operatingSystemUnit.getCapabilities().add(operatingSystem);
		operatingSystemUnit.getCapabilities().add(portConsumer);
		ValidatorTestUtils.hosts(operatingSystemUnit, portConfigUnit);

		Resource res = top.getEObject().eResource();
		res.save(null);

		// no markers
		IStatus status = runValidation(top, validator, portConfigUnit, context,
				reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, portConfigUnit,
				context, reporter, validator);
		assert status.getSeverity() == IStatus.OK;

		// Port name is set and not empty
		String goodPortName = providedPort1.getPortName();
		providedPort1.setPortName(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, portConfigUnit,
				context, reporter, validator);
		providedPort1.setPortName("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, portConfigUnit,
				context, reporter, validator);
		providedPort1.setPortName(goodPortName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, portConfigUnit,
				context, reporter, validator);

		// Port name is unique in host (both ports will be flagged)
		providedPort1.setPortName(providedPort2.getPortName());
		ValidatorTestUtils.assertValidationErrorCount(2, top, portConfigUnit,
				context, reporter, validator);
		providedPort1.setPortName(goodPortName);
		ValidatorTestUtils.assertValidationErrorCount(0, top, portConfigUnit,
				context, reporter, validator);
	}

	private IStatus runValidation(Topology top, UnitValidator validator,
			Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) throws IOException, CoreException {
		top.getEObject().eResource().save(null);
		DeployMarker.deleteInstances(top);
		assert unit.getStatus().getSeverity() == IStatus.OK;
		validator.validate(unit, context, reporter);
		IStatus status = unit.getStatus();
		dumpMarkers(top);
		return status;
	}

	public void testPortSignatureCompare() throws Exception {

		Port pt1 = OsFactory.eINSTANCE.createPort();
		pt1.setIpAddressOrHostname("9.2.10.10");
		pt1.setPort(BigInteger.valueOf(1));
		pt1.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		Port pt2 = OsFactory.eINSTANCE.createPort();
		pt2.setIpAddressOrHostname("9.2.10.10");
		pt2.setPort(BigInteger.valueOf(1));
		pt2.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);

		PortSignature ps1;
		PortSignature ps2;

		ps1 = new PortSignature(pt1);
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) == 0);

		pt1.setIpAddressOrHostname(null);
		pt2.setIpAddressOrHostname(null);
		ps1 = new PortSignature(pt1);
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) == 0);

		pt1.setPort(null);
		ps1 = new PortSignature(pt1);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) != 0);

		pt1.setPort(BigInteger.valueOf(1));
		pt1.setIpAddressOrHostname("foo.bar.com"); //$NON-NLS-1$
		ps1 = new PortSignature(pt1);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) == 0);

		pt2.setIpAddressOrHostname("9.2.10.10");
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) != 0);

		pt2.setTransportLayerProtocol(TransportLayerProtocolType.UDP_LITERAL);
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) != 0);

		pt2.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		pt2.setPort(BigInteger.valueOf(1).add(pt1.getPort()));
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) != 0);

		// TransportLayerProtocol is an enumeration; null means the default, TCP
		pt2.setTransportLayerProtocol(null);
		assert (pt2.getTransportLayerProtocol() != null);

		pt2.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		pt2.setIpAddressOrHostname(pt1.getIpAddressOrHostname());
		pt2.setPort(pt1.getPort());
		ps2 = new PortSignature(pt2);
// System.out.println(ps1.toString() + ":" + ps2.toString() + ":" +
// ps1.compareTo(ps2)); //$NON-NLS-1$//$NON-NLS-2$
		assert (ps1.compareTo(ps2) == 0);
	}
}
