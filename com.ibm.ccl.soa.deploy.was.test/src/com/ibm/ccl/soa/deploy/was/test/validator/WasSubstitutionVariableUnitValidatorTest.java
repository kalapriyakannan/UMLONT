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

// import org.eclipse.emf.ecore.resource.Resource;

// import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
// import com.ibm.ccl.soa.deploy.core.Requirement;
// import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

/**
 * import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
 * import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter; import
 * com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext; import
 * com.ibm.ccl.soa.deploy.was.WasCellUnit; import
 * com.ibm.ccl.soa.deploy.was.WasConfigurationContainer; import
 * com.ibm.ccl.soa.deploy.was.WasFactory; import
 * com.ibm.ccl.soa.deploy.was.WasPackage; import
 * com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable; import
 * com.ibm.ccl.soa.deploy.was.WasSubstitutionVariableUnit; import
 * com.ibm.ccl.soa.deploy.was.internal.validator.WasSubstitutionVariableUnitValidator;
 */
/**
 * Tests {@link WasSubstitutionVariableUnitValidator}
 * 
 * @since 3.2
 * 
 */
public class WasSubstitutionVariableUnitValidatorTest extends TopologyTestCase {
	private static final String PROJECT_NAME = "WasSubstitutionVariableUnitValidatorTest";

	/**
	 * 
	 * 
	 */
	public WasSubstitutionVariableUnitValidatorTest() {
		super(PROJECT_NAME);
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	public void testWasSubstitutionVariableUnitValidator() throws IOException,
			CoreException {

		/**
		 * Topology top = createTopology("WasSubstitutionVariableUnitValidator",
		 * true);
		 * 
		 * IDeployValidationContext context = createValidationContext(top);
		 * IDeployReporter reporter = createDeployReporter();
		 * WasSubstitutionVariableUnitValidator validator = new
		 * WasSubstitutionVariableUnitValidator();
		 *  // variableUnit WasSubstitutionVariable variable =
		 * WasFactory.eINSTANCE.createWasSubstitutionVariable();
		 * variable.setName("variable");//$NON-NLS-1$
		 * variable.setDisplayName("variable");//$NON-NLS-1$
		 * variable.setVariableName("variable");//$NON-NLS-1$
		 * variable.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		 * WasSubstitutionVariableUnit variableUnit =
		 * WasFactory.eINSTANCE.createWasSubstitutionVariableUnit();
		 * variableUnit.setName("variableUnit");//$NON-NLS-1$
		 * variableUnit.getCapabilities().add(variable); top.getUnits().add(
		 * variableUnit );
		 * 
		 * Requirement requiredWasConfigurationContainer;
		 * requiredWasConfigurationContainer =
		 * ValidatorTestUtils.createHostingRequirement(WasPackage.eINSTANCE.getWasConfigurationContainer(),
		 * "requiredWasConfigurationContainer");//$NON-NLS-1$
		 * variableUnit.getRequirements().add(requiredWasConfigurationContainer);
		 * 
		 * WasCellUnit wasCellUnit = WasFactory.eINSTANCE.createWasCellUnit();
		 * wasCellUnit.setName("wasCellUnit");//$NON-NLS-1$
		 * wasCellUnit.setDisplayName("wasCellUnit");//$NON-NLS-1$
		 * top.getUnits().add(wasCellUnit);
		 * 
		 * WasConfigurationContainer provideWasConfigurationContainer =
		 * WasFactory.eINSTANCE.createWasConfigurationContainer();
		 * provideWasConfigurationContainer.setDisplayName("provideWasConfigurationContainer");//$NON-NLS-1$
		 * provideWasConfigurationContainer.setName("provideWasConfigurationContainer");//$NON-NLS-1$
		 * wasCellUnit.getHostingOrAnyCapabilities().add(provideWasConfigurationContainer);
		 * 
		 * ValidatorTestUtils.hosts(wasCellUnit, variableUnit);
		 * 
		 * /////////////////// Resource res = top.getEObject().eResource();
		 * res.save(null); ///////////////////
		 * 
		 * validator.validate(variableUnit, context, reporter);
		 * System.out.println("In " + this.getClass()); //$NON-NLS-1$
		 * dumpMarkers(top);
		 * 
		 * ValidatorTestUtils.assertValidationErrorCount(0, top, variableUnit,
		 * context, reporter, validator);
		 * 
		 * String savedVariableName = variable.getVariableName();
		 * variable.setVariableName("");//$NON-NLS-1$
		 * ValidatorTestUtils.assertValidationErrorCount(1, top, variableUnit,
		 * context, reporter, validator);
		 * variable.setVariableName(savedVariableName);
		 * ValidatorTestUtils.assertValidationErrorCount(0, top, variableUnit,
		 * context, reporter, validator);
		 */
	}
}
