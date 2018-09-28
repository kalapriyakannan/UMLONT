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

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasSIBusUnitValidator;

public class WasSiBusUnitValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "WasSiBusUnitValidatorTest";
	private final String STANDARD_6_WASVERSION = "6.0.0.1";//$NON-NLS-1$	
	private Topology _top;
	private IDeployValidationContext _context;
	private IDeployReporter _reporter;
	private WasCellUnit _wasCellUnit;
	private WasCell _wasCell;
	private WasSIBusUnit _wasSibusUnit;

	/**
	 * 
	 */
	public WasSiBusUnitValidatorTest() {
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
	public void testWasSiBusUnitValidator() throws IOException, CoreException {
		buildUpFundamentalTestEnv();
		WasSIBusUnitValidator validator = new WasSIBusUnitValidator();

		ValidatorTestUtils.assertValidationErrorCount(2, _top, _wasSibusUnit,
				_context, _reporter, validator);

		_wasCellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT, _top);

		ValidatorTestUtils.member(_wasCellUnit, _wasSibusUnit);

		ValidatorTestUtils.assertValidationErrorCount(1, _top, _wasSibusUnit,
				_context, _reporter, validator);

		WasSIBus wasSibusCap = (WasSIBus) ValidatorUtils.getCapability(
				_wasSibusUnit, WasPackage.eINSTANCE.getWasSIBus());

		wasSibusCap.setBusName("notempty");

		ValidatorTestUtils.assertValidationErrorCount(0, _top, _wasSibusUnit,
				_context, _reporter, validator);

	}

	/**
	 * 
	 * @throws IOException
	 */
	private void buildUpFundamentalTestEnv() throws IOException {

		_top = createTopology(PROJECT_NAME, true);
		_context = createValidationContext(_top);
		_reporter = createDeployReporter();

		_wasSibusUnit = (WasSIBusUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_SIBUS_UNIT, _top);
		_wasSibusUnit.getCapabilities();
		_wasSibusUnit.getRequirements();
		//

		// create SibusUnit
		/*
		 * _wasSibusUnit.getRequirements(); _wasSibusUnit =
		 * WasFactory.eINSTANCE.createWasSIBusUnit();
		 * 
		 * _wasSibusUnit.setName("wasSibusUnit");
		 * _wasSibusUnit.setDisplayName("wasSibusUnit");
		 * _top.getUnits().add(_wasSibusUnit);
		 */

		//
		//
		// create wasCellUnit
		//
		/**
		 * _wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		 * _wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		 * _wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		 * _top.getUnits().add(_wasCellUnit);
		 * 
		 * _wasCell = WasFactory.eINSTANCE.createWasCell();
		 * _wasCell.setName("providedWasCell");//$NON-NLS-1$
		 * _wasCell.setDisplayName("providedWasCell");//$NON-NLS-1$
		 * _wasCell.setCellName("standAloneCell");//$NON-NLS-1$
		 * _wasCell.setIsDistributed(false);
		 * _wasCell.setWasVersion(STANDARD_6_WASVERSION);
		 * _wasCell.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		 * _wasCellUnit.getCapabilities().add(_wasCell);
		 */

	}

}
