/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.amplifier;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.ProductVersionManager;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Was version amplifier
 */
public class WasProductVersionUnitAmplifier extends UnitAmplifier implements
		IWasProductVersionValues {

	@Override
	public String[] getValues(Unit unit) {
		//input from CH data
		WebsphereAppServerUnit wasUnit = (WebsphereAppServerUnit) unit;
		WasServer wasServer = (WasServer) ValidatorUtils.getCapability(wasUnit, WasPackage.eINSTANCE
				.getWasServer());
		Bundle bundle = WasDeployPlugin.getDefault().getBundle();
		String version = wasServer.getWasVersion();

		ProductVersionManager manager = ProductVersionManager.getInstance();
		if (version.equals(WAS_60_PRODUCT_VERSION)) {
			String key = WAS_60_APPSERVER_NAME;
			if (!manager.isLoaded(key)) {
				manager.loadProductVersionData(key, WAS_60_PRODUCT_VERSION_INFO_FILE_NAME, bundle);
			}
			return manager.getValues(key);
		} else if (version.equals(WAS_50_PRODUCT_VERSION)) {
			String key = WAS_50_APPSERVER_NAME;
			if (!manager.isLoaded(key)) {
				manager.loadProductVersionData(key, WAS_50_PRODUCT_VERSION_INFO_FILE_NAME, bundle);
			}
			return manager.getValues(key);
		} else if (version.equals(WAS_51_PRODUCT_VERSION)) {
			String key = WAS_51_APPSERVER_NAME;
			if (!manager.isLoaded(key)) {
				manager.loadProductVersionData(key, WAS_51_PRODUCT_VERSION_INFO_FILE_NAME, bundle);
			}
			return manager.getValues(key);
		}
		return new String[0];
	}

	@Override
	public IStatus modify(Unit unit, Object input) {
		if (input instanceof String) {
			final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(unit);
			try {
				String value = (String) input;
				changeScope.execute(getModifyOperation(unit, changeScope, value),
						ChangeScope.OPTION_DO_NOT_SAVE, null);

			} finally {
				if (changeScope != null) {
					changeScope.close(null);
				}
			}
		}
		return Status.OK_STATUS;
	}

	public AbstractEMFOperation getModifyOperation(final Unit sourceUnit, ChangeScope changeScope,
			final String value) {
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(), "") { //$NON-NLS-1$
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				ProductIdentifierConstraint productIdentifierConstraint = getProductConstraint(sourceUnit);
				if (productIdentifierConstraint == null) {
					productIdentifierConstraint = ConstraintFactory.eINSTANCE
							.createProductIdentifierConstraint();
					productIdentifierConstraint.setDisplayName(WEBSPHERE_FAMILY_NAME);
					productIdentifierConstraint
							.setDescription(WasDomainMessages.WasProductVersionUnitAmplifier_Product_versio_);
					sourceUnit.getConstraints().add(productIdentifierConstraint);
				}
				productIdentifierConstraint.setProductIdentifier(value);
				productIdentifierConstraint.setName(value);
				return Status.OK_STATUS;

			}
		};

		return op;

	}

	public String getExistingProductConstraintValue(Unit unit) {
		ProductIdentifierConstraint constraint = getProductConstraint(unit);
		if (constraint == null) {
			return null;
		}
		return constraint.getProductIdentifier();

	}

	public ProductIdentifierConstraint getProductConstraint(Unit unit) {
		List<Constraint> piConstraints = ValidatorUtils.getConstraints(unit,
				ConstraintPackage.eINSTANCE.getProductIdentifierConstraint());
		if (piConstraints.isEmpty()) {
			return null;
		}
		return (ProductIdentifierConstraint) piConstraints.get(0);
	}

}
