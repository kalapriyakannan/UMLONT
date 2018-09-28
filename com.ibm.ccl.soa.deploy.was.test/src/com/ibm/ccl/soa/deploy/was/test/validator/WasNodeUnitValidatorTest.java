/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test.validator;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was5DmgrNodeUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was5NonDmgrNodeUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was6DmgrNodeUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was6NonDmgrNodeUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasGenericNodeUnitValidator;

/**
 * Tests {@link WasGenericNodeUnitValidator} and its subValidators
 * 
 * @since 3.2
 * 
 */
public class WasNodeUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasNodeUnitValidatorTest"; //$NON-NLS-1$
	private Topology _top;
	private WasNodeUnit _wasNodeUnit;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;
	private WasNode _wasNode;
	private WasSystem _providedWasSystem;
	private WasSystemUnit _wasSystemUnit;
	private WasCellUnit _wasCellUnit;
	private WasCell _providedWasCell;
	private WasNodeGroupUnit _wasNodeGroupUnit;
	private WindowsOperatingSystemUnit _windowsOperatingSystemUnit;
	private WindowsOperatingSystem _windowsOperatingSystem;

	/**
	 * 
	 * 
	 */
	public WasNodeUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasNodeUnitValidator() throws IOException, CoreException {
		buildUpWasNodeFundamentalTestEnv();
		//
		// create another wasNodeUnit
		//
		WasNodeUnit wasNodeUnit2 = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit2.setName("wasNodeUnit2"); //$NON-NLS-1$
		wasNodeUnit2.setDisplayName("wasNodeUnit2"); //$NON-NLS-1$		
		_top.getUnits().add(wasNodeUnit2);
		_wasNode.setWasVersion("6.0.0.1");//$NON-NLS-1$
		_providedWasSystem.setWasVersion("6.0.0.1");

		//
		// create another wasNode service
		//
		WasNode wasNode2 = WasFactory.eINSTANCE.createWasNode();
		wasNode2.setName("wasNode2"); //$NON-NLS-1$
		wasNode2.setDisplayName("wasNode2"); //$NON-NLS-1$
		wasNode2.setNodeName("Node2");//$NON-NLS-1$
		wasNode2.setProfileName("AppSrv02");//$NON-NLS-1$
		wasNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit2.getCapabilities().add(wasNode2);

		ValidatorTestUtils.hosts(_wasSystemUnit, wasNodeUnit2);

		WasGenericNodeUnitValidator validator = new WasGenericNodeUnitValidator();

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasNodeUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		checkBasicAttributesNotEmpty(validator);
		checkBasicAttributesValid(validator);

		// profileName unique on wasSystem
		String savedProfileName = _wasNode.getProfileName();
		_wasNode.setProfileName(wasNode2.getProfileName());
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileName(savedProfileName);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// wasVersion not empty
		String savedWasVersion = _wasNode.getWasVersion();
		_wasNode.setWasVersion(""); //$NON-NLS-1$
		// 3 errors: wasVersion undefined, wasVersion not versionString,
		// wasVersion not same with wasSystem
		ValidatorTestUtils.assertValidationErrorCount(3, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		// wasVersion is valid version String
		_wasNode.setWasVersion("yyfdjkl"); //$NON-NLS-1$
		// One for invalid syntax, one for wasVersion not equals
		ValidatorTestUtils.assertValidationErrorCount(2, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// wasNode.wasVersion == wasSystem.wasVersion
		_providedWasSystem.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("7.3");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
	}

	/**
	 * test for Was5NonDmgrNodeUnitValidator
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas6NonDmgrNodeUnitValidator() throws IOException,
			CoreException {

		buildUpWasNodeFundamentalTestEnv();
		// addSharedLibAndConfigurationContainerCap();
		addPortConsumerToWasNodeUnit();
		addWasNodeGroupUnitIntoTestEnv();
		addWasAppServerUnitIntoTestEnv();

		//
		// set unmanaged default V6 wasNode service attributes
		//
		_wasNode.setIsManaged(false);
		_wasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		_wasNode.setWasVersion("6.0.0.1");//$NON-NLS-1$
		_providedWasSystem.setWasVersion("6.0.0.1");//$NON-NLS-1$

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		WasGenericNodeUnitValidator validator = new Was6NonDmgrNodeUnitValidator();

		validator.validate(_wasNodeUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		checkBasicAttributesNotEmpty(validator);
		checkBasicAttributesValid(validator);

		// wasNode.wasVersion == wasSystem.wasVersion
		String savedWasVersion = _providedWasSystem.getWasVersion();
		_providedWasSystem.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		_providedWasSystem.setWasVersion(savedWasVersion);

		// won't run this validation when version equals to 5.*
		_wasNode.setWasVersion("5.1.0.1");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		//
		// standalone Cell
		//
		// wasNode.wasVersion <= wasCell.wasVersion,
		_providedWasCell.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasCell.setWasVersion("6.0.0.0");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// isManaged == false, could not find wasCell, use FVT to check
		/*
		 * // _wasNode.setIsManaged(true);
		 * ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
		 * _context, _reporter, validator); _wasNode.setIsManaged(false);
		 * ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
		 * _context, _reporter, validator); //
		 */
		// providedWasCell.setIsDistributed(true);
		// ValidatorTestUtils.assertValidationErrorCount(1, top, wasNodeUnit,
		// context, reporter, validator);//blocked by RequestExpression Cons
		// method, use FVT to check this
		// providedWasCell.setIsDistributed(false);
		// server cardinality will be checked by FVT
	}

	/**
	 * test for Was5NonDmgrNodeUnitValidator
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas5NonDmgrNodeUnitValidator() throws IOException,
			CoreException {
		buildUpWasNodeFundamentalTestEnv();
		// addSharedLibAndConfigurationContainerCap();
		addPortConsumerToWasNodeUnit();
		addWasAppServerUnitIntoTestEnv();

		//
		// set unmanaged default V6 wasNode service attributes
		//
		_wasNode.setIsManaged(false);
		_wasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		_wasNode.setWasVersion("5.1.0.0");//$NON-NLS-1$
		_providedWasSystem.setWasVersion("5.1.0.0");//$NON-NLS-1$

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		WasGenericNodeUnitValidator validator = new Was5NonDmgrNodeUnitValidator();

		validator.validate(_wasNodeUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		checkBasicAttributesNotEmpty(validator);
		checkBasicAttributesValid(validator);

		// wasNode.wasVersion == wasSystem.wasVersion
		String savedWasVersion = _providedWasSystem.getWasVersion();
		_providedWasSystem.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		_providedWasSystem.setWasVersion(savedWasVersion);

		// won't run this validation when version equals to 6.*
		_wasNode.setWasVersion("6.1.0.1");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
	}

	/**
	 * test for Was6DmgrNodeUnitValidator
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas6DmgrNodeUnitValidator() throws IOException,
			CoreException {
		buildUpWasNodeFundamentalTestEnv();
		addWasNodeGroupUnitIntoTestEnv();
		addDmgrUnitIntoTestEnv();

		//
		// set unmanaged default V6 wasNode service attributes
		//
		_wasNode.setIsManaged(false);
		_wasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		_wasNode.setWasVersion("6.0.0.1");//$NON-NLS-1$
		_providedWasSystem.setWasVersion("6.0.0.1");//$NON-NLS-1$
		_providedWasSystem
				.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		WasGenericNodeUnitValidator validator = new Was6DmgrNodeUnitValidator();

		validator.validate(_wasNodeUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		checkBasicAttributesNotEmpty(validator);
		checkBasicAttributesValid(validator);
		// wasNode.wasVersion == wasSystem.wasVersion
		String savedWasVersion = _providedWasSystem.getWasVersion();
		_providedWasSystem.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		_providedWasSystem.setWasVersion(savedWasVersion);

		// won't run this validation when version equals to 5.*
		_wasNode.setWasVersion("5.1.0.1");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// isManaged == false
		_wasNode.setIsManaged(true);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setIsManaged(false);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
	}

	/**
	 * test for Was5DmgrNodeUnitValidator
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas5DmgrNodeUnitValidator() throws IOException,
			CoreException {
		buildUpWasNodeFundamentalTestEnv();
		addDmgrUnitIntoTestEnv();

		//
		// set unmanaged default V6 wasNode service attributes
		//
		_wasNode.setIsManaged(false);
		_wasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		_wasNode.setWasVersion("5.0.0.1");//$NON-NLS-1$
		_providedWasSystem.setWasVersion("5.0.0.1");//$NON-NLS-1$
		_providedWasSystem
				.setWasEdition(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL);

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		WasGenericNodeUnitValidator validator = new Was5DmgrNodeUnitValidator();

		validator.validate(_wasNodeUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		checkBasicAttributesNotEmpty(validator);
		checkBasicAttributesValid(validator);

		// isManaged == false
		_wasNode.setIsManaged(true);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setIsManaged(false);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// wasNode.wasVersion == wasSystem.wasVersion
		String savedWasVersion = _providedWasSystem.getWasVersion();
		_providedWasSystem.setWasVersion("6.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_providedWasSystem.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion("5.1.0.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		_providedWasSystem.setWasVersion(savedWasVersion);

		// won't run this validation when version equals to 6.*
		_wasNode.setWasVersion("6.1.0.1");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
	}

	/**
	 * It includes: 1. create a topology 2. add a WasNodeUnit and wasNode
	 * service, wasSharedLibContainer service and Configuration container
	 * service into the WasNodeUnit 3. add a WasSystem hosting requirement, and
	 * a hoster for this wasNode 4. add a WasCellUnit as its grouping Container
	 * 
	 * @throws IOException
	 */
	private void buildUpWasNodeFundamentalTestEnv() throws IOException {
		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		//
		// create wasNodeUnit
		//
		_wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		_wasNodeUnit.setName("wasNodeUnit"); //$NON-NLS-1$
		_wasNodeUnit.setDisplayName("wasNodeUnit"); //$NON-NLS-1$		
		_top.getUnits().add(_wasNodeUnit);

		//
		// create an wasNode service
		//
		_wasNode = WasFactory.eINSTANCE.createWasNode();
		_wasNode.setName("wasNode"); //$NON-NLS-1$
		_wasNode.setDisplayName("wasNode"); //$NON-NLS-1$
		_wasNode.setNodeName("Node1");//$NON-NLS-1$
		_wasNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasNodeUnit.getCapabilities().add(_wasNode);

		//
		// add substitutionVaraible Capbality
		//
		WasSubstitutionVariable variableCap = WasFactory.eINSTANCE
				.createWasSubstitutionVariable();
		variableCap.setName("substitutionVariableCap");//$NON-NLS-1$
		variableCap.setDisplayName("substitutionVariable_Capability");//$NON-NLS-1$
		variableCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasNodeUnit.getCapabilities().add(variableCap);

		//
		// Require wasSystem to hosting on
		//
		Requirement requiredWasSystem = CoreFactory.eINSTANCE
				.createRequirement();
		requiredWasSystem.setName("requiredWasSystem"); //$NON-NLS-1$
		requiredWasSystem.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasSystem.setDmoEType(WasPackage.eINSTANCE.getWasSystem());
		_wasNodeUnit.getRequirements().add(requiredWasSystem);

		_wasSystemUnit = WasFactory.eINSTANCE.createWasSystemUnit();
		_wasSystemUnit.setName("wasSystemUnit"); //$NON-NLS-1$
		_top.getUnits().add(_wasSystemUnit);

		_providedWasSystem = WasFactory.eINSTANCE.createWasSystem();
		_providedWasSystem.setName("providedWasSystem"); //$NON-NLS-1$
		_providedWasSystem.setDisplayName("ProvidedWasSystem");//$NON-NLS-1$

		_wasSystemUnit.getHostingOrAnyCapabilities().add(_providedWasSystem);

		Requirement _requiredOS = ValidatorTestUtils.createHostingRequirement(
				OsPackage.eINSTANCE.getWindowsOperatingSystem(), "requiredOS");
		_wasSystemUnit.getRequirements().add(_requiredOS);

		ValidatorTestUtils.hosts(_wasSystemUnit, _wasNodeUnit);

		_windowsOperatingSystemUnit = OsFactory.eINSTANCE
				.createWindowsOperatingSystemUnit();
		_windowsOperatingSystemUnit.setName("_windowsOperatingSystemUnit");
		_windowsOperatingSystemUnit
				.setDisplayName("_windowsOperatingSystemUnit");
		_top.getUnits().add(_windowsOperatingSystemUnit);

		_windowsOperatingSystem = OsFactory.eINSTANCE
				.createWindowsOperatingSystem();
		_windowsOperatingSystem.setName("_windowsOperatingSystem");
		_windowsOperatingSystem.setDisplayName("_windowsOperatingSystem");
		_windowsOperatingSystem
				.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
		_windowsOperatingSystem.setOsType(OperatingSystemType.WINDOWS_LITERAL
				.getLiteral());
		_windowsOperatingSystemUnit.getCapabilities().add(
				_windowsOperatingSystem);

		ValidatorTestUtils.hosts(_windowsOperatingSystemUnit, _wasSystemUnit);

		//
		// Require wasCellUint
		//
		Requirement requiredWasCellUnit = ValidatorTestUtils
				.createMemberRequirement(WasPackage.Literals.WAS_CELL_UNIT,
						"requiredWasCellUnit");//$NON-NLS-1$
		// request expression will be checked by FVT
		_wasNodeUnit.getRequirements().add(requiredWasCellUnit);

		_wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		_wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		_wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		_top.getUnits().add(_wasCellUnit);

		_providedWasCell = WasFactory.eINSTANCE.createWasCell();
		_providedWasCell.setName("providedWasCell");//$NON-NLS-1$
		_providedWasCell.setDisplayName("providedWasCell");//$NON-NLS-1$
		_providedWasCell.setCellName("standAloneCell");//$NON-NLS-1$
		_providedWasCell.setIsDistributed(false);
		_providedWasCell.setWasVersion("6.0.0.1");//$NON-NLS-1$
		_wasCellUnit.getCapabilities().add(_providedWasCell);

		// member link between wasNodeUnit and wasCellUnit
		MemberLink cell_NodeMemberLink = CoreFactory.eINSTANCE
				.createMemberLink();
		cell_NodeMemberLink.setTarget(_wasNodeUnit);
		cell_NodeMemberLink.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(cell_NodeMemberLink);
		_wasCellUnit.getMemberLinks().add(cell_NodeMemberLink);

		_wasNode.setProfileName("AppSrv01");//$NON-NLS-1$
		_wasNode
				.setProfileLocation("C:\\Program Files\\IBM\\WebSphere\\AppServer\\profiles\\AppSrv01");//$NON-NLS-1$

		_providedWasSystem.setWasEdition(WasEditionEnum.BASE_LITERAL);

		addSharedLibAndConfigurationContainerCap();
	}

	private void addSharedLibAndConfigurationContainerCap() {
		//
		// Shared Lib Container service
		//
		WasSharedLibContainer sharedLibContainer = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		sharedLibContainer.setName("sharedLibContainer");//$NON-NLS-1$
		sharedLibContainer.setDisplayName("ProvideSharedLibContainer");//$NON-NLS-1$
		sharedLibContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasNodeUnit.getCapabilities().add(sharedLibContainer);

		//
		// Configuration container service
		//
		WasConfigurationContainer configurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		configurationContainer.setName("configurationContainer");//$NON-NLS-1$
		configurationContainer.setDisplayName("ProvideConfigurationContainer");//$NON-NLS-1$
		configurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasNodeUnit.getCapabilities().add(configurationContainer);
	}

	/**
	 * add Port Consumer service to WasNodeUnit
	 * 
	 */
	private void addPortConsumerToWasNodeUnit() {
		//
		// PortConsumer service
		//
		PortConsumer portConsumer = OsFactory.eINSTANCE.createPortConsumer();
		portConsumer.setName("portConsumer");//$NON-NLS-1$
		portConsumer.setDisplayName("portConsumer");//$NON-NLS-1$
		portConsumer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasNodeUnit.getCapabilities().add(portConsumer);

	}

	/**
	 * add wasNodeGroupUnit as requirement and also add a unit into the topology
	 * 
	 */
	private void addWasNodeGroupUnitIntoTestEnv() {
		//
		// Require NodeGroup
		//
		Requirement requiredWasNodeGroupUnit = ValidatorTestUtils
				.createMemberRequirement(
						WasPackage.Literals.WAS_NODE_GROUP_UNIT,
						"requiredWasNodeGroupUnit");//$NON-NLS-1$
		_wasNodeUnit.getRequirements().add(requiredWasNodeGroupUnit);

		_wasNodeGroupUnit = WasFactory.eINSTANCE.createWasNodeGroupUnit();
		_wasNodeGroupUnit.setName("wasNodeGroupUnit");//$NON-NLS-1$
		_wasNodeGroupUnit.setDisplayName("wasNodeGroupUnit");//$NON-NLS-1$
		_top.getUnits().add(_wasNodeGroupUnit);

		// member link between WASNodeUnit and WasNodeGroupUnit
		MemberLink ng_NodeMemberLink = CoreFactory.eINSTANCE.createMemberLink();
		ng_NodeMemberLink.setTarget(_wasNodeUnit);
		ng_NodeMemberLink.setSource(_wasNodeGroupUnit);
		ValidatorTestUtils.createLinkName(ng_NodeMemberLink);
		_wasNodeGroupUnit.getMemberLinks().add(ng_NodeMemberLink);
	}

	/**
	 * add websphereAppServerUnit as requirement and also add a unit into the
	 * topology
	 * 
	 */
	private void addWasAppServerUnitIntoTestEnv() {
		//
		// Require WebsphereAppServerUnit as member
		//
// Requirement requiredWebSphereAppServerUnit =
// ValidatorTestUtils.createMemberRequirement(WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT,
// "requiredWebsphereAppServerUnit");//$NON-NLS-1$
// _wasNodeUnit.getRequirements().add(requiredWebSphereAppServerUnit);

		WebsphereAppServerUnit webSphereAppServerUnit = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		webSphereAppServerUnit.setName("webSphereAppServerUnit");//$NON-NLS-1$
		webSphereAppServerUnit.setDisplayName("webSphereAppServerUnit");//$NON-NLS-1$
		_top.getUnits().add(webSphereAppServerUnit);

		Requirement wasNodeUnitHostingRequirement = ValidatorTestUtils
				.createHostingRequirement(WasPackage.eINSTANCE.getWasNode(),
						"WasNodeReq");
		webSphereAppServerUnit.getRequirements().add(
				wasNodeUnitHostingRequirement);

		ValidatorTestUtils.hosts(_wasNodeUnit, webSphereAppServerUnit);
// //member link between wasNodeUnit and webSphereAppServerUnit
// MemberLink serverNodeMemberLink = CoreFactory.eINSTANCE.createMemberLink();
// serverNodeMemberLink.setTarget(webSphereAppServerUnit);
// serverNodeMemberLink.setSource(_wasNodeUnit);
// ValidatorTestUtils.createLinkName(serverNodeMemberLink);
// _wasNodeUnit.getMemberLinks().add(serverNodeMemberLink);
	}

	/**
	 * add wasDeploymentManagerUnit as requirement and also add a unit into the
	 * topology
	 * 
	 */
	private void addDmgrUnitIntoTestEnv() {
		//
		// Require for WasDeploymentManagerUnit as member
		//
// Requirement requiredWasDmgrUnit =
// ValidatorTestUtils.createMemberRequirement(WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT,
// "requiredWasDmgrUnit");//$NON-NLS-1$
// _wasNodeUnit.getRequirements().add(requiredWasDmgrUnit);

		WasDeploymentManagerUnit wasDmgrUnit = WasFactory.eINSTANCE
				.createWasDeploymentManagerUnit();
		wasDmgrUnit.setName("wasDeploymentManagerUnit");//$NON-NLS-1$
		wasDmgrUnit.setDisplayName("wasDeploymentManagerUnit");//$NON-NLS-1$
		_top.getUnits().add(wasDmgrUnit);

		Requirement wasNodeUnitHostingRequirementDmgr = ValidatorTestUtils
				.createHostingRequirement(WasPackage.eINSTANCE.getWasNode(),
						"WasNodeReqDmgr");
		wasDmgrUnit.getRequirements().add(wasNodeUnitHostingRequirementDmgr);

		ValidatorTestUtils.hosts(_wasNodeUnit, wasDmgrUnit);
// //memberLink between wasNodeUnit and the dmgrUnit
// MemberLink dmgrrNodeMemberLink = CoreFactory.eINSTANCE.createMemberLink();
// dmgrrNodeMemberLink.setTarget(wasDmgrUnit);
// dmgrrNodeMemberLink.setSource(_wasNodeUnit);
// ValidatorTestUtils.createLinkName(dmgrrNodeMemberLink);
// _wasNodeUnit.getMemberLinks().add(dmgrrNodeMemberLink);
	}

	/**
	 * check profileName, NodeName are not Empty
	 * 
	 * @param validator
	 * @throws CoreException
	 */
	private void checkBasicAttributesNotEmpty(
			WasGenericNodeUnitValidator validator) throws CoreException {
		// profileName not empty
		String savedProfileName = _wasNode.getProfileName();
		_wasNode.setProfileName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileName(savedProfileName);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// nodeName not empty
		String savedNodeName = _wasNode.getNodeName();
		_wasNode.setNodeName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setNodeName(savedNodeName);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);

		// profileLocation not empty
		String savedProfileLocation = _wasNode.getProfileLocation();
		_wasNode.setProfileLocation("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileLocation(savedProfileLocation);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
	}

	/**
	 * check profileLocation valid
	 * 
	 * @param validator
	 * @throws CoreException
	 */
	private void checkBasicAttributesValid(WasGenericNodeUnitValidator validator)
			throws CoreException {
		// profileLocation not empty
		String savedProfileLocation = _wasNode.getProfileLocation();
		_wasNode.setProfileLocation("${wasHome}/profiles/default");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileLocation("c:/tmp");
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileLocation("/tmp");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileLocation("\tmp");
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasNodeUnit,
				_context, _reporter, validator);
		_wasNode.setProfileLocation(savedProfileLocation);
	}
}
