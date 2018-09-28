/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange
 * @generated (mde.utilities.datamodels)
 */
public class DeployRefactoringChangeProvider extends AbstractScribblerDataModelProvider
		implements IRefactoringDataModelChangeProperties {

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRefactoringDataModelChangeProperties#SCRIBBLER_DEFINITION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateScribblerDefinition() {

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IRefactoringDataModelChangeProperties#SCRIBBLER_DEFINITION
	 * @generated (mde.utilities.datamodels)
	 */
	protected IDataModel getDefaultScribblerDefinition() {
		// TODO Return the default value of the ScribblerDefinition property.
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION.equals(property)) {
			return validateScribblerDefinition();
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
		if (IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION.equals(property)) {
			return getDefaultScribblerDefinition();
		} else {
			return super.getDefaultProperty(property);
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
		propertyNames.add(IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION);
		propertyNames.addAll(super.getPropertyNames());
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
				"getDefaultOperation() is not supported by " + getClass().getName()); //$NON-NLS-1$
	}

}
