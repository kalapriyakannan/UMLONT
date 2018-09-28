/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateLinkChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateLinkChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.UpdateLinkChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the UpdateLinkChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>link</b>: The Link property. </li>
 * <li><b>source</b>: The Source property. </li>
 * <li><b>destination</b>: The Destination property. </li>
 * <li><b>endpoint</b>: The Endpoint property. </li>
 * </ul>
 * 
 */
public class UpdateLinkChange extends DeployRefactoringChange {

	public static final Integer SOURCE = IUpdateLinkChangeProperties.END_POINT_SOURCE;

	public static final Integer TARGET = IUpdateLinkChangeProperties.END_POINT_TARGET;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static UpdateLinkChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new UpdateLinkChange(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new UpdateLinkChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateLinkChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(getLink().toPlatformString(false)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "update " + (UpdateLinkChange.SOURCE.equals(getEndpoint()) ? "sourceURI" : "targetURI") + " to '" + getDestination() + "'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newLink
	 *           The new value of the Link property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setLink(org.eclipse.emf.common.util.URI newLink) {
		getUnderlyingDataModel().setProperty(IUpdateLinkChangeProperties.LINK, newLink);
	}

	/**
	 * 
	 * 
	 * @return The value of the Link property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getLink() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getProperty(
				IUpdateLinkChangeProperties.LINK);
	}

	/**
	 * Determine if the Link property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Link
	 *         property is valid.
	 * @see #getLink()
	 * @see #setLink(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateLink() {
		return getUnderlyingDataModel().validateProperty(IUpdateLinkChangeProperties.LINK);
	}

	/**
	 * Determine the default value of the Link property.
	 * 
	 * @return The default value of the Link property.
	 * @see #getLink()
	 * @see #setLink(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDefaultLink() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getDefaultProperty(
				IUpdateLinkChangeProperties.LINK);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newSource
	 *           The new value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setSource(String newSource) {
		getUnderlyingDataModel().setProperty(IUpdateLinkChangeProperties.SOURCE, newSource);
	}

	/**
	 * 
	 * 
	 * @return The value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getSource() {
		return (String) getUnderlyingDataModel().getProperty(IUpdateLinkChangeProperties.SOURCE);
	}

	/**
	 * Determine if the Source property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Source
	 *         property is valid.
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		return getUnderlyingDataModel().validateProperty(IUpdateLinkChangeProperties.SOURCE);
	}

	/**
	 * Determine the default value of the Source property.
	 * 
	 * @return The default value of the Source property.
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultSource() {
		return (String) getUnderlyingDataModel().getDefaultProperty(
				IUpdateLinkChangeProperties.SOURCE);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDestination
	 *           The new value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDestination(String newDestination) {
		getUnderlyingDataModel().setProperty(IUpdateLinkChangeProperties.DESTINATION, newDestination);
	}

	/**
	 * 
	 * 
	 * @return The value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDestination() {
		return (String) getUnderlyingDataModel().getProperty(IUpdateLinkChangeProperties.DESTINATION);
	}

	/**
	 * Determine if the Destination property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Destination
	 *         property is valid.
	 * @see #getDestination()
	 * @see #setDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		return getUnderlyingDataModel().validateProperty(IUpdateLinkChangeProperties.DESTINATION);
	}

	/**
	 * Determine the default value of the Destination property.
	 * 
	 * @return The default value of the Destination property.
	 * @see #getDestination()
	 * @see #setDestination(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDestination() {
		return (String) getUnderlyingDataModel().getDefaultProperty(
				IUpdateLinkChangeProperties.DESTINATION);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newEndpoint
	 *           The new value of the Endpoint property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setEndpoint(Integer newEndpoint) {
		getUnderlyingDataModel().setProperty(IUpdateLinkChangeProperties.ENDPOINT, newEndpoint);
	}

	/**
	 * 
	 * 
	 * @return The value of the Endpoint property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Integer getEndpoint() {
		return (Integer) getUnderlyingDataModel().getProperty(IUpdateLinkChangeProperties.ENDPOINT);
	}

	/**
	 * Determine if the Endpoint property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Endpoint
	 *         property is valid.
	 * @see #getEndpoint()
	 * @see #setEndpoint(Integer)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateEndpoint() {
		return getUnderlyingDataModel().validateProperty(IUpdateLinkChangeProperties.ENDPOINT);
	}

	/**
	 * Determine the default value of the Endpoint property.
	 * 
	 * @return The default value of the Endpoint property.
	 * @see #getEndpoint()
	 * @see #setEndpoint(Integer)
	 * @generated (mde.utilities.datamodels)
	 */
	public Integer getDefaultEndpoint() {
		return (Integer) getUnderlyingDataModel().getDefaultProperty(
				IUpdateLinkChangeProperties.ENDPOINT);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		UpdateLinkChangeOperation operation = new UpdateLinkChangeOperation(this);
		return operation;
	}
}
