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

import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange
 * @generated (mde.utilities.datamodels)
 */
public class CreateImportChangeProvider extends DeployRefactoringChangeProvider implements
		ICreateImportChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateImportChangeProperties#IMPORTS
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateImports() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateImportChangeProperties.IMPORTS) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath importsProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(ICreateImportChangeProperties.IMPORTS);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Imports property.
	 * @see ICreateImportChangeProperties#IMPORTS
	 * @see CreateImportChange#getImports()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultImports() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateImportChangeProperties#IMPORTED
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateImported() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateImportChangeProperties.IMPORTED) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath importedProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(ICreateImportChangeProperties.IMPORTED);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Imported property.
	 * @see ICreateImportChangeProperties#IMPORTED
	 * @see CreateImportChange#getImported()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultImported() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (ICreateImportChangeProperties.IMPORTED.equals(property)) {
			return validateImported();
		} else if (ICreateImportChangeProperties.IMPORTS.equals(property)) {
			return validateImports();
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
		if (ICreateImportChangeProperties.IMPORTED.equals(property)) {
			return getDefaultImported();
		} else if (ICreateImportChangeProperties.IMPORTS.equals(property)) {
			return getDefaultImports();
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
		propertyNames.add(ICreateImportChangeProperties.IMPORTED);
		propertyNames.add(ICreateImportChangeProperties.IMPORTS);
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
				"getDefaultOperation() is not support in the " + getClass().getCanonicalName() + " class."); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
