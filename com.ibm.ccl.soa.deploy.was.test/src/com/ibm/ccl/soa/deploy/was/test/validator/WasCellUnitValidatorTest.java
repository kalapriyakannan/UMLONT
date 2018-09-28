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
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasConfigurationContainer;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSharedLibContainer;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was5DistributedCellUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was5StandaloneCellUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was6DistributedCellUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.Was6StandaloneCellUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasGenericCellUnitValidator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasUnknownVersionCellUnitValidator;

/**
 * Tests {@link WasGenericCellUnitValidator} and its subValidators
 * 
 * @since 3.2
 * 
 */
public class WasCellUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasCellUnitValidatorTest"; //$NON-NLS-1$
	private final String STANDARD_5_WASVERSION = "5.1.0.1";//$NON-NLS-1$
	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$

	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;
	private WasCellUnit _wasCellUnit;
	private WasCell _wasCell;
	private WasNodeUnit _wasNodeUnit;
	private WasNode _provideWasNode;
	private WasNodeGroupUnit _wasNodeGroupUnit;
	private WasNodeGroup _provideWasNodeGroup;
	private WasClusterUnit _wasClusterUnit;
	private MemberLink _nodeCellMemberLink;
	private MemberLink _ng_CellMemberLink;

	/**
	 * 
	 * 
	 */
	public WasCellUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * test {@link WasCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasCellUnitValidator() throws IOException, CoreException {
		buildUpWasCellFundamentalTestEnv();
		WasGenericCellUnitValidator validator = new WasGenericCellUnitValidator();

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		checkCellNameNotEmpty(validator);
		// wasVersion is valid
		checkWasVersionAsValidVersionString(validator);
	}

	/**
	 * test {@link WasUnknownVersionCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasUnknownVersionCellUnitValidator() throws IOException,
			CoreException {
		buildUpWasCellFundamentalTestEnv();
		addWasNodeGroupUnitToTestEnv();
		addWasClusterUnitToTestEnv();
		WasGenericCellUnitValidator validator = new WasUnknownVersionCellUnitValidator();

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// wasVersion between 7 to 5
		String savedWasVersion = _wasCell.getWasVersion();
		_wasCell.setWasVersion("7.3.4.1"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion("4.3.4.1"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * test {@link Was5StandaloneCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 * 
	 */
	public void testWas5StandaloneCellUnitValidator() throws IOException,
			CoreException {
		buildUpWasCellFundamentalTestEnv();
		WasGenericCellUnitValidator validator = new Was5StandaloneCellUnitValidator();
		_wasCell.setWasVersion(STANDARD_5_WASVERSION);//$NON-NLS-1$
		_provideWasNode.setWasVersion(STANDARD_5_WASVERSION);//$NON-NLS-1$
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// cell + 1 node
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		_provideWasNode.setProfileType(WasProfileTypeEnum.MANAGED_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// comment out, this will be checked in NodeUnit itself.
		/*
		 * _provideWasNode.setIsManaged(true);
		 * ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
		 * _context, _reporter, validator); _provideWasNode.setIsManaged(false);
		 * ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
		 * _context, _reporter, validator);
		 */

		String savedCellVersion = _wasCell.getWasVersion();
		_wasCell.setWasVersion("5.3.9.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setWasVersion("5.3.9.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedCellVersion);
		_provideWasNode.setWasVersion(savedCellVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// cell + 0 node
		_wasCellUnit.getMemberLinks().remove(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().add(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// Cell + 2 nodes
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit2 = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit2.setName("wasNodeUnit2"); //$NON-NLS-1$
		wasNodeUnit2.setDisplayName("wasNodeUnit2"); //$NON-NLS-1$		
		_top.getUnits().add(wasNodeUnit2);
		// add wasNodeService
		WasNode provideWasNode2 = WasFactory.eINSTANCE.createWasNode();
		provideWasNode2.setName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setDisplayName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setNodeName("Node2");//$NON-NLS-1$
		provideWasNode2.setWasVersion(STANDARD_5_WASVERSION);
		provideWasNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit2.getCapabilities().add(provideWasNode2);
		// member link between wasNodeUnit and webSphereAppServerUnit
		MemberLink nodeCellMemberLink_2 = CoreFactory.eINSTANCE
				.createMemberLink();
		nodeCellMemberLink_2.setTarget(wasNodeUnit2);
		nodeCellMemberLink_2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(nodeCellMemberLink_2);
		_wasCellUnit.getMemberLinks().add(nodeCellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().remove(nodeCellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * test {@link Was5DistributedCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas5DistributedCellUnitValidator() throws IOException,
			CoreException {
		buildUpWasCellFundamentalTestEnv();
		_wasCell.setCellName("distributedCell");//$NON-NLS-1$
		_wasCell.setIsDistributed(true);
		_wasCell.setWasVersion(this.STANDARD_5_WASVERSION);
		_provideWasNode.setWasVersion(this.STANDARD_5_WASVERSION);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);

		addWasClusterUnitToTestEnv();
		WasGenericCellUnitValidator validator = new Was5DistributedCellUnitValidator();

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// node <1
		//
		_wasCellUnit.getMemberLinks().remove(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().add(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// 1 node
		//
		// non dmgr node
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// wasCell.wasVersion == dmgrNode.wasVersion
		_provideWasNode.setWasVersion("5.7.8");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion("5.7.8");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setWasVersion(this.STANDARD_5_WASVERSION);
		_wasCell.setWasVersion(this.STANDARD_5_WASVERSION);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// node>1
		//
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit2 = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit2.setName("wasNodeUnit2"); //$NON-NLS-1$
		wasNodeUnit2.setDisplayName("wasNodeUnit2"); //$NON-NLS-1$		
		_top.getUnits().add(wasNodeUnit2);
		// add wasNodeService
		WasNode provideWasNode2 = WasFactory.eINSTANCE.createWasNode();
		provideWasNode2.setName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setDisplayName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setNodeName("Node2");//$NON-NLS-1$
		provideWasNode2.setWasVersion(STANDARD_5_WASVERSION);
		provideWasNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit2.getCapabilities().add(provideWasNode2);
		// member link between wasNodeUnit and webSphereAppServerUnit
		MemberLink nodeCellMemberLink_2 = CoreFactory.eINSTANCE
				.createMemberLink();
		nodeCellMemberLink_2.setTarget(wasNodeUnit2);
		nodeCellMemberLink_2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(nodeCellMemberLink_2);
		_wasCellUnit.getMemberLinks().add(nodeCellMemberLink_2);

		// 2 dmgr node
		provideWasNode2.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		provideWasNode2.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * test {@link Was6DistributedCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 * 
	 */
	public void testWas6DistributedCellUnitValidator() throws IOException,
			CoreException {
		buildUpWasCellFundamentalTestEnv();
		_wasCell.setCellName("distributedCell");//$NON-NLS-1$
		_wasCell.setIsDistributed(true);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);

		addWasNodeGroupUnitToTestEnv();
		_provideWasNodeGroup.setIsDefaultType(true);
		addWasClusterUnitToTestEnv();
		WasGenericCellUnitValidator validator = new Was6DistributedCellUnitValidator();

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// node <1
		//
		_wasCellUnit.getMemberLinks().remove(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().add(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// 1 node
		//
		// non dmgr node
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// wasCell.wasVersion == dmgrNode.wasVersion
		_provideWasNode.setWasVersion("6.7.8");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion("6.7.8");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setWasVersion(this.STANDARD_6_WASVERSION);
		_wasCell.setWasVersion(this.STANDARD_6_WASVERSION);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		//
		// node>1
		//
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit2 = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit2.setName("wasNodeUnit2"); //$NON-NLS-1$
		wasNodeUnit2.setDisplayName("wasNodeUnit2"); //$NON-NLS-1$		
		_top.getUnits().add(wasNodeUnit2);
		// add wasNodeService
		WasNode provideWasNode2 = WasFactory.eINSTANCE.createWasNode();
		provideWasNode2.setName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setDisplayName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setNodeName("Node2");//$NON-NLS-1$
		provideWasNode2.setWasVersion(STANDARD_6_WASVERSION);
		provideWasNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit2.getCapabilities().add(provideWasNode2);
		// member link between wasNodeUnit and webSphereAppServerUnit
		MemberLink nodeCellMemberLink_2 = CoreFactory.eINSTANCE
				.createMemberLink();
		nodeCellMemberLink_2.setTarget(wasNodeUnit2);
		nodeCellMemberLink_2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(nodeCellMemberLink_2);
		_wasCellUnit.getMemberLinks().add(nodeCellMemberLink_2);

		// 2 dmgr node
		provideWasNode2.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		provideWasNode2.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// 0 default NG
		_wasCellUnit.getMemberLinks().remove(_ng_CellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().add(_ng_CellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// 2 default NG
		WasNodeGroupUnit wasNodeGroupUnit2 = WasFactory.eINSTANCE
				.createWasNodeGroupUnit();
		wasNodeGroupUnit2.setName("wasNodeGroupUnit2");//$NON-NLS-1$
		wasNodeGroupUnit2.setDisplayName("wasNodeGroupUnit2");//$NON-NLS-1$
		_top.getUnits().add(wasNodeGroupUnit2);

		// add wasNodeGroup Service
		WasNodeGroup provideWasNodeGroup2 = WasFactory.eINSTANCE
				.createWasNodeGroup();
		provideWasNodeGroup2.setName("provideWasNodeGroup2");//$NON-NLS-1$
		provideWasNodeGroup2.setDisplayName("provideWasNodeGroup2");//$NON-NLS-1$
		provideWasNodeGroup2.setIsDefaultType(true);
		provideWasNodeGroup2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		provideWasNodeGroup2.setNodeGroupName("provideWasNodeGroup2");//$NON-NLS-1$
		wasNodeGroupUnit2.getCapabilities().add(provideWasNodeGroup2);

		// member link between WASCellUnit and WasNodeGroupUnit
		MemberLink ng_CellMemberLink2 = CoreFactory.eINSTANCE
				.createMemberLink();
		ng_CellMemberLink2.setTarget(wasNodeGroupUnit2);
		ng_CellMemberLink2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(ng_CellMemberLink2);
		_wasCellUnit.getMemberLinks().add(ng_CellMemberLink2);

		provideWasNodeGroup2.setIsDefaultType(true);
		ValidatorTestUtils.assertValidationErrorCount(2, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNodeGroup.setIsDefaultType(false);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNodeGroup.setIsDefaultType(true);
		provideWasNodeGroup2.setIsDefaultType(false);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * test {@link Was6StandaloneCellUnitValidator}
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWas6StandaloneCellUnitValidator() throws IOException,
			CoreException {
		buildUpWasCellFundamentalTestEnv();
		addWasNodeGroupUnitToTestEnv();
		WasGenericCellUnitValidator validator = new Was6StandaloneCellUnitValidator();
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);

		// /////////////////
		Resource res = _top.getEObject().eResource();
		res.save(null);
		// /////////////////

		validator.validate(_wasCellUnit, _context, _reporter);
		System.out.println("In " + this.getClass()); //$NON-NLS-1$
		dumpMarkers(_top);

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// cell + 1 node
		_provideWasNode.setProfileType(WasProfileTypeEnum.DMGR_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		_provideWasNode.setProfileType(WasProfileTypeEnum.MANAGED_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNode.setProfileType(WasProfileTypeEnum.DEFAULT_LITERAL);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// comment out, this will be checked in NodeUnit itself.
		/*
		 * _provideWasNode.setIsManaged(true);
		 * ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
		 * _context, _reporter, validator); _provideWasNode.setIsManaged(false);
		 * ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
		 * _context, _reporter, validator);
		 */

		String savedCellVersion = _wasCell.getWasVersion();
		_wasCell.setWasVersion("6.3.9.1");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedCellVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// cell + 0 node
		_wasCellUnit.getMemberLinks().remove(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().add(_nodeCellMemberLink);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// Cell + 2 nodes
		// create wasNodeUnit
		WasNodeUnit wasNodeUnit2 = WasFactory.eINSTANCE.createWasNodeUnit();
		wasNodeUnit2.setName("wasNodeUnit2"); //$NON-NLS-1$
		wasNodeUnit2.setDisplayName("wasNodeUnit2"); //$NON-NLS-1$		
		_top.getUnits().add(wasNodeUnit2);
		// add wasNodeService
		WasNode provideWasNode2 = WasFactory.eINSTANCE.createWasNode();
		provideWasNode2.setName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setDisplayName("provideWasNode2"); //$NON-NLS-1$
		provideWasNode2.setNodeName("Node2");//$NON-NLS-1$
		provideWasNode2.setWasVersion(STANDARD_6_WASVERSION);
		provideWasNode2.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		wasNodeUnit2.getCapabilities().add(provideWasNode2);
		// member link between wasNodeUnit and webSphereAppServerUnit
		MemberLink nodeCellMemberLink_2 = CoreFactory.eINSTANCE
				.createMemberLink();
		nodeCellMemberLink_2.setTarget(wasNodeUnit2);
		nodeCellMemberLink_2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(nodeCellMemberLink_2);
		_wasCellUnit.getMemberLinks().add(nodeCellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().remove(nodeCellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// Cell + 1 NG
		_provideWasNodeGroup.setIsDefaultType(false);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_provideWasNodeGroup.setIsDefaultType(true);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);

		// Cell + 2 NGs
		//
		// add another invalid NodeGroupUnit as a member
		//
		WasNodeGroupUnit wasNodeGroupUnit2 = WasFactory.eINSTANCE
				.createWasNodeGroupUnit();
		wasNodeGroupUnit2.setName("wasNodeGroupUnit2");//$NON-NLS-1$
		wasNodeGroupUnit2.setDisplayName("wasNodeGroupUnit2");//$NON-NLS-1$
		_top.getUnits().add(wasNodeGroupUnit2);

		// member link between WASCellUnit and WasNodeGroupUnit
		MemberLink ng_CellMemberLink_2 = CoreFactory.eINSTANCE
				.createMemberLink();
		ng_CellMemberLink_2.setTarget(wasNodeGroupUnit2);
		ng_CellMemberLink_2.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(ng_CellMemberLink_2);
		_wasCellUnit.getMemberLinks().add(ng_CellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCellUnit.getMemberLinks().remove(ng_CellMemberLink_2);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * check cellName not empty
	 * 
	 * @param validator
	 * @throws CoreException
	 */
	private void checkCellNameNotEmpty(WasGenericCellUnitValidator validator)
			throws CoreException {
		// cellName not empty
		String savedCellName = _wasCell.getCellName();
		_wasCell.setCellName("");//$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setCellName(savedCellName);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * check wasVersion is a valid versionString
	 * 
	 * @param validator
	 * @throws CoreException
	 */
	private void checkWasVersionAsValidVersionString(
			WasGenericCellUnitValidator validator) throws CoreException {
		// wasVersion not empty
		String savedWasVersion = _wasCell.getWasVersion();
		_wasCell.setWasVersion(""); //$NON-NLS-1$
		// 3 errors: wasVersion not versionString,
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
		// wasVersion is valid version String
		_wasCell.setWasVersion("yyfdjkl"); //$NON-NLS-1$
		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasCellUnit,
				_context, _reporter, validator);
		_wasCell.setWasVersion(savedWasVersion);
		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasCellUnit,
				_context, _reporter, validator);
	}

	/**
	 * create: - Topology - WasCellUnit(wasCell service, SharedLibContainer
	 * service and ConfigurationContainer Service) - Required wasNodeUnit
	 * member(memberLink, and hosting Link)
	 * 
	 * @throws IOException
	 */
	private void buildUpWasCellFundamentalTestEnv() throws IOException {
		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		//
		// create wasCellUnit
		//
		_wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		_wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		_wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		_top.getUnits().add(_wasCellUnit);

		_wasCell = WasFactory.eINSTANCE.createWasCell();
		_wasCell.setName("providedWasCell");//$NON-NLS-1$
		_wasCell.setDisplayName("providedWasCell");//$NON-NLS-1$
		_wasCell.setCellName("standAloneCell");//$NON-NLS-1$
		_wasCell.setIsDistributed(false);
		_wasCell.setWasVersion(STANDARD_6_WASVERSION);
		_wasCell.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasCellUnit.getCapabilities().add(_wasCell);

		//
		// Shared Lib Container service
		//
		WasSharedLibContainer sharedLibContainer = WasFactory.eINSTANCE
				.createWasSharedLibContainer();
		sharedLibContainer.setName("sharedLibContainer");//$NON-NLS-1$
		sharedLibContainer.setDisplayName("ProvideSharedLibContainer");//$NON-NLS-1$
		sharedLibContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasCellUnit.getCapabilities().add(sharedLibContainer);

		//
		// Configuration container service
		//
		WasConfigurationContainer configurationContainer = WasFactory.eINSTANCE
				.createWasConfigurationContainer();
		configurationContainer.setName("configurationContainer");//$NON-NLS-1$
		configurationContainer.setDisplayName("ProvideConfigurationContainer");//$NON-NLS-1$
		configurationContainer.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasCellUnit.getCapabilities().add(configurationContainer);

		//
		// add substitutionVaraible Capbality
		//
		WasSubstitutionVariable variableCap = WasFactory.eINSTANCE
				.createWasSubstitutionVariable();
		variableCap.setName("substitutionVariableCap");//$NON-NLS-1$
		variableCap.setDisplayName("substitutionVariable_Capability");//$NON-NLS-1$
		variableCap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_wasCellUnit.getCapabilities().add(variableCap);

		//
		// Require wasNodeUnit as member
		//
		Requirement requiredWasNodeUnit = ValidatorTestUtils
				.createMemberRequirement(WasPackage.Literals.WAS_NODE_UNIT,
						"requiredWasNodeUnit");//$NON-NLS-1$
		_wasCellUnit.getRequirements().add(requiredWasNodeUnit);
		// create wasNodeUnit
		_wasNodeUnit = WasFactory.eINSTANCE.createWasNodeUnit();
		_wasNodeUnit.setName("wasNodeUnit"); //$NON-NLS-1$
		_wasNodeUnit.setDisplayName("wasNodeUnit"); //$NON-NLS-1$		
		_top.getUnits().add(_wasNodeUnit);
		// add wasNodeService
		_provideWasNode = WasFactory.eINSTANCE.createWasNode();
		_provideWasNode.setName("wasNode"); //$NON-NLS-1$
		_provideWasNode.setDisplayName("wasNode"); //$NON-NLS-1$
		_provideWasNode.setNodeName("Node1");//$NON-NLS-1$
		_provideWasNode.setWasVersion(STANDARD_6_WASVERSION);
		_provideWasNode.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		// member link between wasNodeUnit and webSphereAppServerUnit
		_nodeCellMemberLink = CoreFactory.eINSTANCE.createMemberLink();
		_nodeCellMemberLink.setTarget(_wasNodeUnit);
		_nodeCellMemberLink.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(_nodeCellMemberLink);
		_wasCellUnit.getMemberLinks().add(_nodeCellMemberLink);
		// hostingLink between cell and Node
		Requirement requiredWasNode = CoreFactory.eINSTANCE.createRequirement();
		requiredWasNode.setName("requiredWasNode"); //$NON-NLS-1$
		requiredWasNode.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requiredWasNode.setDmoEType(WasPackage.eINSTANCE.getWasNode());
		_wasCellUnit.getRequirements().add(requiredWasNode);
		_wasNodeUnit.getHostingOrAnyCapabilities().add(_provideWasNode);
		ValidatorTestUtils.hosts(_wasNodeUnit, _wasCellUnit);
	}

	/**
	 * create requirement for NGUnit, and add NGUnit to test Topology
	 * 
	 */
	private void addWasNodeGroupUnitToTestEnv() {
		//
		// Require NodeGroupUnit as a member
		//
		Requirement requiredWasNodeGroupUnit = ValidatorTestUtils
				.createMemberRequirement(
						WasPackage.Literals.WAS_NODE_GROUP_UNIT,
						"requiredWasNodeGroupUnit");//$NON-NLS-1$
		_wasCellUnit.getRequirements().add(requiredWasNodeGroupUnit);

		_wasNodeGroupUnit = WasFactory.eINSTANCE.createWasNodeGroupUnit();
		_wasNodeGroupUnit.setName("wasNodeGroupUnit");//$NON-NLS-1$
		_wasNodeGroupUnit.setDisplayName("wasNodeGroupUnit");//$NON-NLS-1$
		_top.getUnits().add(_wasNodeGroupUnit);

		// add wasNodeGroup Service
		_provideWasNodeGroup = WasFactory.eINSTANCE.createWasNodeGroup();
		_provideWasNodeGroup.setName("wasDefaultNodeGroup");//$NON-NLS-1$
		_provideWasNodeGroup.setDisplayName("wasDefaultNodeGroup");//$NON-NLS-1$
		_provideWasNodeGroup.setIsDefaultType(true);
		_provideWasNodeGroup.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		_provideWasNodeGroup.setNodeGroupName("wasDefaultNodeGroup");//$NON-NLS-1$
		_wasNodeGroupUnit.getCapabilities().add(_provideWasNodeGroup);

		// member link between WASCellUnit and WasNodeGroupUnit
		_ng_CellMemberLink = CoreFactory.eINSTANCE.createMemberLink();
		_ng_CellMemberLink.setTarget(_wasNodeGroupUnit);
		_ng_CellMemberLink.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(_ng_CellMemberLink);
		_wasCellUnit.getMemberLinks().add(_ng_CellMemberLink);
	}

	/**
	 * create requirement for ClusterUnit, and add ClusterUnit to test Topology
	 * 
	 */
	private void addWasClusterUnitToTestEnv() {
		//
		// Require ClusterUnit as a member
		//
		Requirement requiredWasClusterUnit = ValidatorTestUtils
				.createMemberRequirement(WasPackage.Literals.WAS_CLUSTER_UNIT,
						"requiredWasClusterUnit");//$NON-NLS-1$
		_wasCellUnit.getRequirements().add(requiredWasClusterUnit);

		_wasClusterUnit = WasFactory.eINSTANCE.createWasClusterUnit();
		_wasClusterUnit.setName("_wasClusterUnit");//$NON-NLS-1$
		_wasClusterUnit.setDisplayName("_wasClusterUnit");//$NON-NLS-1$
		_top.getUnits().add(_wasClusterUnit);

		// member link between WASCellUnit and WasClusterUnit
		MemberLink ng_CellMemberLink = CoreFactory.eINSTANCE.createMemberLink();
		ng_CellMemberLink.setTarget(_wasClusterUnit);
		ng_CellMemberLink.setSource(_wasCellUnit);
		ValidatorTestUtils.createLinkName(ng_CellMemberLink);
		_wasCellUnit.getMemberLinks().add(ng_CellMemberLink);
	}
}
