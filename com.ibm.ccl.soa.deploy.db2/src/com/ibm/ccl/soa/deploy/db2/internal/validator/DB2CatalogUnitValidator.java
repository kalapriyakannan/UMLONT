/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.Db2DomainMessages;

/**
 * Validates a {link DB2CatalogUnit}.
 * <ul>
 * <li> {@link IDB2ValidatorID.DB2_CATALOG_UNIT_DB_NAME_001}
 * <li> {@link IDB2ValidatorID.DB2_CATALOG_UNIT_DB_ALIAS_001}
 * </ul>
 */
public class DB2CatalogUnitValidator extends ConfigurationUnitValidator {

	/**
	 * 
	 */
	public DB2CatalogUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2CatalogUnit());
	}

	/**
	 * @param unitType
	 */
	protected DB2CatalogUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2CatalogUnit().isSuperTypeOf(unitType);

		addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2Database(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2CatalogedNode(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2Database(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_CATALOG_UNIT_DB_NAME_001, Db2Package.eINSTANCE
						.getDB2Database_DbName(), IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IDB2ValidatorID.DB2_CATALOG_UNIT_DB_NAME_002, Db2Package.eINSTANCE
						.getDB2Database_DbName(), Db2Package.eINSTANCE.getDB2Database_DbName()));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_CATALOG_UNIT_DB_ALIAS_001, Db2Package.eINSTANCE
						.getDB2Database_DbAlias(), IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_CATALOG_UNIT_DB_ALIAS_002, Db2Package.eINSTANCE
						.getDB2Database_DbAlias()));

		addCapabilityValidator(new DB2DatabaseValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateDependencyLinkTarget(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.DependencyLink,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateDependencyLinkTarget(Capability cap, Requirement req,
			DependencyLink link, Unit sourceUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		super.validateDependencyLinkTarget(cap, req, link, sourceUnit, context, reporter);
		Unit targetUnit = ValidatorUtils.getUnit(cap);
		if (sourceUnit instanceof DB2CatalogUnit && targetUnit instanceof DB2CatalogUnit) {
			reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDB2ValidatorID.DB2_CATALOG_CATALOGS_CATALOG_001,
					ICoreProblemType.DEPENDENCY_LINK_TARGET_INVALID,
					Db2DomainMessages.Validator_0_cannot_catalog_1, new String[] {
							sourceUnit.getDisplayName(), targetUnit.getDisplayName() },
					req.getLink() == null ? req : req.getLink()));
		}
	}

}
