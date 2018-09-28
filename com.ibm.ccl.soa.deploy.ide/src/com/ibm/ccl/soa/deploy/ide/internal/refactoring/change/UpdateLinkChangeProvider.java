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

import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange}. The provider is required
 * by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateLinkChangeProvider extends DeployRefactoringChangeProvider implements
		IUpdateLinkChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateLinkChangeProperties#LINK
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateLink() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IUpdateLinkChangeProperties.LINK) instanceof org.eclipse.emf.common.util.URI);
		//org.eclipse.emf.common.util.URI linkProperty = (org.eclipse.emf.common.util.URI)  model.getProperty(IUpdateLinkChangeProperties.LINK);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Link property.
	 * @see IUpdateLinkChangeProperties#LINK
	 * @see UpdateLinkChange#getLink()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.emf.common.util.URI getDefaultLink() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateLinkChangeProperties#SOURCE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IUpdateLinkChangeProperties.SOURCE) instanceof String);
		//String sourceProperty = (String)  model.getProperty(IUpdateLinkChangeProperties.SOURCE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Source property.
	 * @see IUpdateLinkChangeProperties#SOURCE
	 * @see UpdateLinkChange#getSource()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultSource() {
		return "null"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateLinkChangeProperties#DESTINATION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IUpdateLinkChangeProperties.DESTINATION) instanceof String);
		//String destinationProperty = (String)  model.getProperty(IUpdateLinkChangeProperties.DESTINATION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Destination property.
	 * @see IUpdateLinkChangeProperties#DESTINATION
	 * @see UpdateLinkChange#getDestination()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultDestination() {
		return "null"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateLinkChangeProperties#ENDPOINT
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateEndpoint() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IUpdateLinkChangeProperties.ENDPOINT) instanceof Integer);
		//Integer endpointProperty = (Integer)  model.getProperty(IUpdateLinkChangeProperties.ENDPOINT);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Endpoint property.
	 * @see IUpdateLinkChangeProperties#ENDPOINT
	 * @see UpdateLinkChange#getEndpoint()
	 * @generated (mde.utilities.datamodels)
	 */
	protected Integer getDefaultEndpoint() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IUpdateLinkChangeProperties.DESTINATION.equals(property)) {
			return validateDestination();
		} else if (IUpdateLinkChangeProperties.SOURCE.equals(property)) {
			return validateSource();
		} else if (IUpdateLinkChangeProperties.LINK.equals(property)) {
			return validateLink();
		} else if (IUpdateLinkChangeProperties.ENDPOINT.equals(property)) {
			return validateEndpoint();
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
		if (IUpdateLinkChangeProperties.DESTINATION.equals(property)) {
			return getDefaultDestination();
		} else if (IUpdateLinkChangeProperties.SOURCE.equals(property)) {
			return getDefaultSource();
		} else if (IUpdateLinkChangeProperties.LINK.equals(property)) {
			return getDefaultLink();
		} else if (IUpdateLinkChangeProperties.ENDPOINT.equals(property)) {
			return getDefaultEndpoint();
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
		propertyNames.add(IUpdateLinkChangeProperties.DESTINATION);
		propertyNames.add(IUpdateLinkChangeProperties.SOURCE);
		propertyNames.add(IUpdateLinkChangeProperties.LINK);
		propertyNames.add(IUpdateLinkChangeProperties.ENDPOINT);
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
