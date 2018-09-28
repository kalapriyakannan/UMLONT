/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitAmplifierService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ProductVersionManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ProductVersionValue;

/**
 * Validator to validate 'ProductIdentifierConstraint' constrait type.
 */
public class ProductIdentifierConstraintValidator extends ConstraintValidator {
	IUnitAmplifierService ampedService = ExtensionsCore.createAmplifierService();
	ProductVersionManager manager = ProductVersionManager.getInstance();

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return true;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		RealizationLink link = null;
		if (context instanceof Unit) {
			Unit sourceUnit = (Unit) context;
			IStatus status = validateProductIndentifierValue(constraint, sourceUnit);
			if (!status.isOK()) {
				return status;
			}

			link = ValidatorUtils.getRealizationLink(sourceUnit);
			if (link != null) {
				DeployModelObject targetContext = link.getTarget();
				if (targetContext instanceof Unit) {
					Unit targetUnit = (Unit) targetContext;
					List<Constraint> constraints = ValidatorUtils.getConstraints(targetContext,
							ConstraintPackage.eINSTANCE.getProductIdentifierConstraint());
					if (constraints.isEmpty()) {
						return warningStatus(sourceUnit, targetUnit);
					}
					for (Iterator iterator = constraints.iterator(); iterator.hasNext();) {
						Constraint targetConstraint = (Constraint) iterator.next();
						if (link != null && targetConstraint instanceof ProductIdentifierConstraint
								&& constraint instanceof ProductIdentifierConstraint) {
							ProductIdentifierConstraint targetProductConstraint = (ProductIdentifierConstraint) targetConstraint;
							ProductIdentifierConstraint sourceProductConstraint = (ProductIdentifierConstraint) constraint;
							if (targetConstraint.getDisplayName().equals(
									sourceProductConstraint.getDisplayName())) {
								String sourceValue = sourceProductConstraint.getProductIdentifier();

								String targetValue = targetProductConstraint.getProductIdentifier();
								if (sourceValue.equals(targetValue)) {
									return Status.OK_STATUS;
								}

								String productKey = targetConstraint.getDisplayName();
								ProductVersionValue sourceVersionValue = manager.getProductVersionValue(
										productKey, sourceValue);
								if (sourceVersionValue == null) {
									return infoStatus(sourceUnit);
								}
								ProductVersionValue targetVersionValue = manager.getProductVersionValue(
										productKey, targetValue);
								if (!manager.isLoaded(productKey)) {
									loadManager(targetUnit, sourceUnit);
								}
								if (!manager.inRange(targetConstraint.getDisplayName(), sourceVersionValue,
										targetVersionValue)) {
									return reportRangeErrorStatus(sourceUnit, targetUnit,
											sourceVersionValue, targetVersionValue);
								}
							}

						}

					}
				}

			}
		}

		return Status.OK_STATUS;
	}

	private IStatus validateProductIndentifierValue(Constraint constraint, Unit unit) {
		ProductIdentifierConstraint sourceProductConstraint = (ProductIdentifierConstraint) constraint;
		String sourceValue = sourceProductConstraint.getProductIdentifier();
		String productKey = sourceProductConstraint.getDisplayName();
		if (!manager.isLoaded(productKey)) {
			loadValues(unit);
		}
		ProductVersionValue sourceVersionValue = manager.getProductVersionValue(productKey,
				sourceValue);
		if (sourceVersionValue == null) {
			return infoStatus(unit);
		}
		return Status.OK_STATUS;
	}

	private void loadManager(Unit targetUnit, Unit sourceUnit) {
		loadValues(targetUnit);
		loadValues(sourceUnit);
	}

	private void loadValues(Unit targetUnit) {
		UnitAmplifier[] amplifilers = ampedService
				.findEnabledTopologyUnitAmplifiersByInputOnly(targetUnit);
		for (int i = 0; i < amplifilers.length; i++) {
			UnitAmplifier unitAmplifier = amplifilers[i];
			unitAmplifier.getValues(targetUnit);

		}
	}

	private IStatus warningStatus(Unit unit, Unit targetContext) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.WARNING,
						NLS
								.bind(
										DeployCoreMessages.ProductIdentifierConstraintValidator_Unit_0_is_missing_a_valid_product_,
										targetContext.getDisplayName()),
						ICoreProblemType.EXPECTED_PRODUCT_IDENTIFIER,
						NLS
								.bind(
										DeployCoreMessages.ProductIdentifierConstraintValidator_Unit_0_is_missing_a_valid_product_,
										targetContext.getDisplayName()), new Object[0], targetContext);
		return status;
	}

	private IStatus infoStatus(Unit unit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.INFO,
						DeployCoreMessages.ProductIdentifierConstraintValidator_Unable_to_resolve_identifier_versio_,
						ICoreProblemType.EXPECTED_PRODUCT_IDENTIFIER,
						DeployCoreMessages.ProductIdentifierConstraintValidator_Unable_to_resolve_identifier_versio_,
						new Object[0], unit);
		return status;
	}

	private IStatus reportRangeErrorStatus(Unit sourceUnit, Unit targetUnit,
			ProductVersionValue sourceVersionValue, ProductVersionValue targetVersionValue) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.ERROR,
						DeployCoreMessages.ProductIdentifierConstraintValidator_Product_Version_Constraint_is_not_i_,
						ICoreProblemType.EXPECTED_PRODUCT_IDENTIFIER,
						DeployCoreMessages.ProductIdentifierConstraintValidator_Product_Version_Constraint_is_not_i_,
						new Object[0], sourceUnit);
		return status;

	}
}
