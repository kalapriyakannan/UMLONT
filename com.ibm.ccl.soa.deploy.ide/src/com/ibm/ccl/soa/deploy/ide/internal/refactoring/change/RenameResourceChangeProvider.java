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
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameResourceChange}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameResourceChange
 * @generated (mde.utilities.datamodels)
 */
public class RenameResourceChangeProvider extends DeployRefactoringChangeProvider implements
		IRenameResourceChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameResourceChangeProperties#SOURCE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IRenameResourceChangeProperties.SOURCE) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath sourceProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(IRenameResourceChangeProperties.SOURCE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Source property.
	 * @see IRenameResourceChangeProperties#SOURCE
	 * @see RenameResourceChange#getSource()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultSource() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameResourceChangeProperties#DESTINATION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IRenameResourceChangeProperties.DESTINATION) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath destinationProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(IRenameResourceChangeProperties.DESTINATION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Destination property.
	 * @see IRenameResourceChangeProperties#DESTINATION
	 * @see RenameResourceChange#getDestination()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultDestination() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IRenameResourceChangeProperties.SOURCE.equals(property)) {
			return validateSource();
		} else if (IRenameResourceChangeProperties.DESTINATION.equals(property)) {
			return validateDestination();
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
		if (IRenameResourceChangeProperties.SOURCE.equals(property)) {
			return getDefaultSource();
		} else if (IRenameResourceChangeProperties.DESTINATION.equals(property)) {
			return getDefaultDestination();
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
		propertyNames.add(IRenameResourceChangeProperties.SOURCE);
		propertyNames.add(IRenameResourceChangeProperties.DESTINATION);
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
