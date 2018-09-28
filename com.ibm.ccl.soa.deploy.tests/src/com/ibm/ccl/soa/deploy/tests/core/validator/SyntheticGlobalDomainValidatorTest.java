/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.core.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsFactory;

/**
 * Test that the global domain validator gets invoked on every topology created.
 * 
 * @see SyntheticGlobalDomainValidator
 * 
 */
public class SyntheticGlobalDomainValidatorTest extends TopologyTestCase {

	/**
	 * Special description that triggers an error in
	 * {@link SyntheticGlobalDomainValidator}.
	 */
	public static final String SPECIAL_DESCRIPTION = SyntheticGlobalDomainValidator.SPECIAL_DESCRIPTION;

	public SyntheticGlobalDomainValidatorTest() {
		super("SyntheticGlobarDomainValidatorTest"); //$NON-NLS-1$
	}

	/**
	 * Tests that the synthetic global domain validator gets invoked on an empty
	 * topology.
	 */
	public void testEmptyTopology() throws Exception {
		Topology top = createTopology("emptyTopology");
		DeployValidatorService validator = getValidatorService();

		// No error: topology does not have special description
		validator.validate(top);
		assertHasNoErrorStatus(top);

		// Error: topology has special description
		top.setDescription(SPECIAL_DESCRIPTION);
		validator.validate(top);
		assertHasDeployStatus(top, SPECIAL_DESCRIPTION, IStatus.ERROR);
	}

	/**
	 * Tests that the synthetic global domain validator gets invoked on a
	 * topology containing a non-core object.
	 */
	public void testNonCoreUnitTopology() throws Exception {
		Topology top = createTopology("emptyTopology");
		DeployValidatorService validator = getValidatorService();

		OperatingSystemUnit unit = OsFactory.eINSTANCE
				.createOperatingSystemUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		// No error: topology does not have special description
		validator.validate(top);
		assertHasNoDeployStatus(unit, SPECIAL_DESCRIPTION, IStatus.ERROR);

		// Error: topology has special description
		unit.setDescription(SPECIAL_DESCRIPTION);
		validator.validate(top);
		assert top.getStatus().isOK();
		assert !unit.getStatus().isOK();
		assertHasDeployStatus(unit, SPECIAL_DESCRIPTION, IStatus.ERROR);
	}
}
