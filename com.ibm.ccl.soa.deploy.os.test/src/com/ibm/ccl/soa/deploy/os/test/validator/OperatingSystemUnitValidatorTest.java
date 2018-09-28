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

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.Directory;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;
import com.ibm.ccl.soa.deploy.os.UnixDirectory;
import com.ibm.ccl.soa.deploy.os.WindowsDirectory;
import com.ibm.ccl.soa.deploy.os.internal.validator.OperatingSystemUnitValidator;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerFactory;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * Tests {@link OperatingSystemUnitValidator}.
 */
public class OperatingSystemUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "OsUnitValidatorTest"; //$NON-NLS-1$

	private OperatingSystemUnit OsUnit1;

	private OperatingSystemUnit OsUnit12;

	private OperatingSystemUnit OsUnit2;

	public OperatingSystemUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	public void testOsUnitValidator() throws IOException, CoreException {
		Topology top = createTopology("OsUnitValidator", true);

		IDeployValidationContext context = createValidationContext(top);
		IDeployReporter reporter = createDeployReporter();
		OperatingSystemUnitValidator validator = new OperatingSystemUnitValidator();

		//
		// build test topology
		//

		Port port1 = OsFactory.eINSTANCE.createPort();
		port1.setName("port1");
		port1.setDisplayName("port1");
		port1.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		port1.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		port1.setPort(new BigInteger("5555"));
		port1.setPortName("TestPort1");

		Port port2 = OsFactory.eINSTANCE.createPort();
		port2.setName("port2");
		port2.setDisplayName("port2");
		port2.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		port2.setTransportLayerProtocol(TransportLayerProtocolType.TCP_LITERAL);
		port2.setPort(new BigInteger("5556"));
		port2.setPortName("TestPort2");

		AttributeMetaData portNameData1 = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		portNameData1.setAttributeName(OsPackage.Literals.PORT__PORT_NAME
				.getName());
		portNameData1.setMutable(false);
		port1.getAttributeMetaData().add(portNameData1);

		AttributeMetaData portNameData2 = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		portNameData2.setAttributeName(OsPackage.Literals.PORT__PORT_NAME
				.getName());
		portNameData2.setMutable(false);
		port2.getAttributeMetaData().add(portNameData2);

		AttributeMetaData testGetMetadata = port2
				.getAttributeMetaData(OsPackage.Literals.PORT__PORT_NAME
						.getName());

		PortConfigUnit portConfigUnit1 = OsFactory.eINSTANCE
				.createPortConfigUnit();
		portConfigUnit1.setName("portConfigUnit1");
		portConfigUnit1.setDisplayName("portConfigUnit1");
		top.getUnits().add(portConfigUnit1);
		portConfigUnit1.getCapabilities().add(port1);
		portConfigUnit1.getCapabilities().add(port2);
		Requirement portConsumerReq1 = ValidatorTestUtils
				.createHostingRequirement(OsPackage.Literals.PORT_CONSUMER,
						"portConsumerReq1");
		portConfigUnit1.getRequirements().add(portConsumerReq1);

		// Provided operating system
		OperatingSystem providedWinOs1 = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		providedWinOs1.setName("providedWinOs1");
		providedWinOs1.setHostname("rf12.watson.ibm.com");
		providedWinOs1
				.setOsType(OperatingSystemType.WINDOWS_LITERAL.toString());
		providedWinOs1.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		PortConsumer providedPortConsumer = OsFactory.eINSTANCE
				.createPortConsumer();
		providedPortConsumer.setName("providedPortConsumer");
		providedPortConsumer.setDisplayName("providedPortConsumer");
		providedPortConsumer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		WindowsDirectory providedDirectory = OsFactory.eINSTANCE
				.createWindowsDirectory();
		providedDirectory.setName("providedDirectory");
		providedDirectory.setFixedPath("providedDirectory");
		providedDirectory.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		Requirement requiredServer = ValidatorTestUtils
				.createHostingRequirement(ServerPackage.Literals.SERVER,
						"requiredServer");

		OsUnit1 = OsFactory.eINSTANCE.createOperatingSystemUnit();
		OsUnit1.setName("OsUnit1");
		top.getUnits().add(OsUnit1);
		OsUnit1.getCapabilities().add(providedWinOs1);
		OsUnit1.getCapabilities().add(providedPortConsumer);
		OsUnit1.getCapabilities().add(providedDirectory);
		OsUnit1.getRequirements().add(requiredServer);

		// Provided operating system
		OperatingSystem providedLinuxOs2 = OsFactory.eINSTANCE
				.createOperatingSystem();
		providedLinuxOs2.setName("providedOs2");
		providedLinuxOs2.setHostname("rf11.watson.ibm.com");
		providedLinuxOs2
				.setOsType(OperatingSystemType.LINUX_LITERAL.toString());
		providedLinuxOs2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		UnixDirectory providedUnixDirectory = OsFactory.eINSTANCE
				.createUnixDirectory();
		providedUnixDirectory.setName("providedDirectory");
		providedUnixDirectory.setFixedPath("providedDirectory");
		providedUnixDirectory.setLinkType(CapabilityLinkTypes.ANY_LITERAL);

		OsUnit2 = OsFactory.eINSTANCE.createOperatingSystemUnit();
		OsUnit2.setName("OsUnit2");
		top.getUnits().add(OsUnit2);
		OsUnit2.getCapabilities().add(providedLinuxOs2);
		OsUnit2.getCapabilities().add(providedUnixDirectory);

		Server providedServer = ServerFactory.eINSTANCE.createServer();
		providedServer.setName("providedServer");
		providedServer.setDisplayName("providedServer");
		providedServer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		providedServer.setCpuArchitecture("intel");
		ServerUnit serverUnit = ServerFactory.eINSTANCE.createServerUnit();
		top.getUnits().add(serverUnit);
		serverUnit.getCapabilities().add(providedServer);
		ValidatorTestUtils.hosts(serverUnit, OsUnit1);
		ValidatorTestUtils.hosts(OsUnit1, portConfigUnit1);

		Requirement requiredServer2 = ValidatorTestUtils
				.createHostingRequirement(ServerPackage.Literals.SERVER,
						"requiredServer2");

		OsUnit12 = OsFactory.eINSTANCE.createOperatingSystemUnit();
		OsUnit12.setName("OsUnit12");
		top.getUnits().add(OsUnit12);
		OsUnit12.getRequirements().add(requiredServer2);

		Resource res = top.getEObject().eResource();
		res.save(null);

		runValidation(top, validator, OsUnit1, context, reporter);
		// Hostname not unique in topology test
		assert (ValidatorTestUtils.getTopologyStatusOfSeverityCount(top,
				IStatus.WARNING) == 0);

		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);
		String goodHostname = providedWinOs1.getHostname();
		providedWinOs1.setHostname("");
		ValidatorTestUtils.assertValidationErrorCount(1, top, OsUnit1, context,
				reporter, validator);
		providedWinOs1.setHostname(null);
		ValidatorTestUtils.assertValidationErrorCount(1, top, OsUnit1, context,
				reporter, validator);
		providedWinOs1.setHostname(goodHostname);
		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);

		// Hostname not unique in topology test
		providedWinOs1.setHostname(providedLinuxOs2.getHostname());
		runValidation(top, validator, OsUnit1, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);
		assert (ValidatorTestUtils.getTopologyStatusOfSeverityCount(top,
				IStatus.WARNING) == 1) : ValidatorTestUtils
				.getTopologyStatusOfSeverityCount(top, IStatus.WARNING);
		providedWinOs1.setHostname(goodHostname);
		runValidation(top, validator, OsUnit1, context, reporter);
		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);
		assert (ValidatorTestUtils.getTopologyStatusOfSeverityCount(top,
				IStatus.WARNING) == 0) : ValidatorTestUtils
				.getTopologyStatusOfSeverityCount(top, IStatus.WARNING);

		BigInteger goodPort1Port = port1.getPort();
		port1.setPort(port2.getPort());
		ValidatorTestUtils.assertValidationErrorCount(2, top, OsUnit1, context,
				reporter, validator);
		port1.setPort(goodPort1Port);
		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);

		String goodOSType = providedWinOs1.getOsType();
		providedWinOs1.setOsType(OperatingSystemType.AIX_LITERAL.toString());
		ValidatorTestUtils.assertValidationErrorCount(1, top, OsUnit1, context,
				reporter, validator);
		providedWinOs1.setOsType(goodOSType);
		ValidatorTestUtils.assertValidationErrorCount(0, top, OsUnit1, context,
				reporter, validator);
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
}
