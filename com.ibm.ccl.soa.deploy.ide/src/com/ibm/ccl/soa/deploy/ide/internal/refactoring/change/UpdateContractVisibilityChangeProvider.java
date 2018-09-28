/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange}. The provider is required
 * by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateContractVisibilityChangeProvider extends DeployRefactoringChangeProvider
		implements IUpdateContractVisibilityChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateContractVisibilityChangeProperties#DMO_TO_UPDATE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDmo() {

		Assert
				.isTrue(model.getProperty(IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE) instanceof org.eclipse.emf.common.util.URI);

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the View property.
	 * @see IDeleteViewChangeProperties#VIEW
	 * @see DeleteViewChange#getView()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.emf.common.util.URI getDefaultDmo() {
		return null;
	}

	public IStatus validateContractFlag() {

		Assert
				.isTrue(model.getProperty(IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG) instanceof java.lang.Integer);

		return Status.OK_STATUS;
	}

	protected Integer getDefaultContractFlag() {
		return new Integer(1);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE.equals(property)) {
			return validateDmo();
		} else if (IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG.equals(property)) {
			return validateContractFlag();
		} else {
			return super.validate(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE.equals(property)) {
			return getDefaultDmo();
		} else if (IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG.equals(property)) {
			return getDefaultContractFlag();
		} else {
			return super.validate(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE);
		propertyNames.add(IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		throw new UnsupportedOperationException(
				"getDefaultOperation() is not support in the " + getClass().getCanonicalName() + " class."); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
