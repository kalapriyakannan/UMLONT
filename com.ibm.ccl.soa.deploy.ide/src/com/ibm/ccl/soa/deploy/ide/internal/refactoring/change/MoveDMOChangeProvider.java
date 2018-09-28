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

import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange}. The provider is required by
 * the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange
 * @generated (mde.utilities.datamodels)
 */
public abstract class MoveDMOChangeProvider extends DeployRefactoringChangeProvider implements
		IMoveDMOChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveDMOChangeProperties#SOURCE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IMoveDMOChangeProperties.SOURCE) instanceof org.eclipse.emf.common.util.URI);
		//org.eclipse.emf.common.util.URI sourceProperty = (org.eclipse.emf.common.util.URI)  model.getProperty(IMoveDMOChangeProperties.SOURCE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Source property.
	 * @see IMoveDMOChangeProperties#SOURCE
	 * @see MoveDMOChange#getSource()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.emf.common.util.URI getDefaultSource() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveDMOChangeProperties#DESTINATION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IMoveDMOChangeProperties.DESTINATION) instanceof org.eclipse.emf.common.util.URI);
		//org.eclipse.emf.common.util.URI destinationProperty = (org.eclipse.emf.common.util.URI)  model.getProperty(IMoveDMOChangeProperties.DESTINATION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Destination property.
	 * @see IMoveDMOChangeProperties#DESTINATION
	 * @see MoveDMOChange#getDestination()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.emf.common.util.URI getDefaultDestination() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IMoveDMOChangeProperties.DESTINATION.equals(property)) {
			return validateDestination();
		} else if (IMoveDMOChangeProperties.SOURCE.equals(property)) {
			return validateSource();
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
		if (IMoveDMOChangeProperties.DESTINATION.equals(property)) {
			return getDefaultDestination();
		} else if (IMoveDMOChangeProperties.SOURCE.equals(property)) {
			return getDefaultSource();
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
		propertyNames.add(IMoveDMOChangeProperties.DESTINATION);
		propertyNames.add(IMoveDMOChangeProperties.SOURCE);
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
