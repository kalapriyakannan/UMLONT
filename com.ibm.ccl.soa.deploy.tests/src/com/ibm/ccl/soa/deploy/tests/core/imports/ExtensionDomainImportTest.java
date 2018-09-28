/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.core.imports;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUser;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit;

/**
 * Tests for topology imports that refer to non-core domains.
 */
public class ExtensionDomainImportTest extends TopologyTestCase {

	/**
	 * Construct a test class.
	 */
	public ExtensionDomainImportTest() {
		super("ExtensionDomainImportTest");
	}

	/**
	 * Tests the methods of the explicit contract.
	 * 
	 * @throws Exception
	 */
	public void testExplicitContract() throws Exception {
		Topology top = createTopology("testExplicitContract");

		// Create sample topology
		Unit u1 = addUnit(top, "u1");
		Capability c1 = addCapability(u1, "c1", CapabilityLinkTypes.ANY_LITERAL);
		Requirement r1 = addRequirement(u1, "r1",
				RequirementLinkTypes.ANY_LITERAL);
		EAttribute uAttr = CorePackage.Literals.UNIT__BUILD_VERSION;
		EAttribute cAttr = CorePackage.Literals.CAPABILITY__BUILD_VERSION;
		RequirementExpression re1 = Equals.createExpression(uAttr, "foo");
		r1.getExpressions().add(re1);

		// Create and assign explicit contract
		ExplicitContract contract = CoreFactory.eINSTANCE
				.createExplicitContract();
		contract.setName("contract");
		top.setConfigurationContract(contract);

		// Default is non-linkable and non-configurable
		assertTrue(!contract.isPublic(u1));
		assertTrue(!contract.isPublic(c1));
		assertTrue(!contract.isPublic(r1));
		assertTrue(!contract.isPublic(re1));

		assertTrue(!contract.isPublicEditable(u1));
		assertTrue(!contract.isPublicEditable(c1));
		assertTrue(!contract.isPublicEditable(r1));
		assertTrue(!contract.isPublicEditable(re1));

		assertTrue(!contract.isPublicEditable(u1, uAttr.getName()));
		assertTrue(!contract.isPublicEditable(c1, cAttr.getName()));

		// Make unit linkable
		contract.export(u1, false);

		assertTrue(contract.isPublic(u1));
		assertTrue(contract.isPublic(c1));
		assertTrue(contract.isPublic(r1));
		assertTrue(contract.isPublic(re1));

		assertTrue(!contract.isPublicEditable(u1));
		assertTrue(!contract.isPublicEditable(c1));
		assertTrue(!contract.isPublicEditable(r1));
		assertTrue(!contract.isPublicEditable(re1));

		assertTrue(!contract.isPublicEditable(u1, uAttr.getName()));
		assertTrue(!contract.isPublicEditable(c1, cAttr.getName()));

		// Make unit configurable
		contract.export(u1, true);

		assertTrue(contract.isPublic(u1));
		assertTrue(contract.isPublic(c1));
		assertTrue(contract.isPublic(r1));
		assertTrue(contract.isPublic(re1));

		assertTrue(contract.isPublicEditable(u1));
		assertTrue(contract.isPublicEditable(c1));
		assertTrue(contract.isPublicEditable(r1));
		assertTrue(contract.isPublicEditable(re1));

		assertTrue(contract.isPublicEditable(u1, uAttr.getName()));
		assertTrue(contract.isPublicEditable(c1, cAttr.getName()));

		// Unexport the unit
		contract.unexport(u1);
		assertTrue(!contract.isPublic(u1));
		assertTrue(!contract.isPublic(c1));
		assertTrue(!contract.isPublic(r1));
		assertTrue(!contract.isPublic(re1));

		assertTrue(!contract.isPublicEditable(u1));
		assertTrue(!contract.isPublicEditable(c1));
		assertTrue(!contract.isPublicEditable(r1));
		assertTrue(!contract.isPublicEditable(re1));

		assertTrue(!contract.isPublicEditable(u1, uAttr.getName()));
		assertTrue(!contract.isPublicEditable(c1, cAttr.getName()));
	}

	/**
	 * Tests that parameter attributes are not marked as errors in the business
	 * and template DS.
	 */
	public void testParameterStatus() throws Exception {
		//
		// Create imported topology
		//
		Topology top = createTopology("testParameterStatus");
		top
				.setDecoratorSemantic(IDecoratorSemanticConstants.BusinessApplicationDS_ID);

		// Add a Windows user
		ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_LOCAL_USER_UNIT, top);
		assert top.getUnits().size() == 1;
		WindowsLocalUserUnit userUnit = (WindowsLocalUserUnit) top.getUnits()
				.get(0);
		WindowsLocalUser user = (WindowsLocalUser) ValidatorUtils
				.getFirstCapability(userUnit,
						OsPackage.Literals.WINDOWS_LOCAL_USER);
		assert user != null;
		userUnit.setInitInstallState(InstallState.INSTALLED_LITERAL);

		// Assert has user undefined errors
		validate(top);
		assertHasDeployStatus(user,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		// Make OS user name and password parameters
		AttributeMetaData userIdMeta = DeployModelObjectUtil
				.getOrCreateAttributeMetaData(user,
						OsPackage.Literals.USER__USER_ID.getName());
		userIdMeta.setParameter(true);

		AttributeMetaData userPasswordMeta = DeployModelObjectUtil
				.getOrCreateAttributeMetaData(user,
						OsPackage.Literals.USER__USER_PASSWORD.getName());
		userPasswordMeta.setParameter(true);

		// Assert no validation ERROR (since the two required attributes are
		// parameters).
		validate(top);
		assert userPasswordMeta.isParameter();
		assertHasNoErrorStatus(top);

		// Remove attribute meta-data & confirm that validation errors are
		// created
		userIdMeta.setParameter(false);
		userPasswordMeta.setParameter(false);
		validate(top);
		assertHasDeployStatus(user,
				ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, IStatus.ERROR);

		// Create contract
		ExplicitContract contract = CoreFactory.eINSTANCE
				.createExplicitContract();
		contract.setName("contract");
		top.setConfigurationContract(contract);

		// Mark user unit as exported and configurable
		contract.export(userUnit, true);

		// TODO in M6 export OS User ID and password.
		// contract.export(user, OsPackage.Literals.USER__USER_ID);
		// contract.export(user, OsPackage.Literals.USER__USER_PASSWORD);

		// Assert no validation ERROR (since unit is configurable)
		validate(top);
		assertHasNoErrorStatus(top);
	}
}
