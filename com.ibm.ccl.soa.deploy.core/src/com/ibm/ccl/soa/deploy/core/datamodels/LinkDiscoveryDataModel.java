/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ILinkDiscoveryDataModelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelProvider;

/**
 * 
 * This datamodel is used to determine types of links to be discovered
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>unit</b>: The Unit property. </li>
 * <li><b>isHosting</b>: Sets hosting link as the relationship type used for discovery. </li>
 * <li><b>isLogical</b>: Sets logical link as the relationship type used for discovery. </li>
 * <li><b>isDependency</b>: Sets group as the relationship type used for discovery. </li>
 * <li><b>isGroup</b>: Sets group as the relationship type used for discovery. </li>
 * <li><b>deploymentObjectModel</b>: The DeploymentObjectModel property. </li>
 * <li><b>descriptors</b>: The Descriptors property. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class LinkDiscoveryDataModel {

	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static LinkDiscoveryDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new LinkDiscoveryDataModel(model);
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
		return new LinkDiscoveryDataModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public LinkDiscoveryDataModel(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * Return the value of Unit field.
	 * 
	 * @return The value of Unit field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Unit getUnit() {
		return (Unit) model.getProperty(ILinkDiscoveryDataModelProperties.UNIT);
	}

	/**
	 * The Unit property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newUnit
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setUnit(Unit newUnit) {
		model.setProperty(ILinkDiscoveryDataModelProperties.UNIT, newUnit);
	}

	/**
	 * Determine if the Unit property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Unit
	 *         property is valid.
	 * @see #getUnit()
	 * @see #setUnit(Unit)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUnit() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.UNIT);

	}

	/**
	 * Determine the default value of the Unit property.
	 * 
	 * @return The default value of the Unit property.
	 * @see #getUnit()
	 * @see #setUnit(Unit)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Unit getDefaultUnit() {
		return (Unit) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.UNIT);
	}

	/**
	 * Return the value of IsHosting field.
	 * 
	 * @return The value of IsHosting field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getIsHosting() {
		return (Boolean) model.getProperty(ILinkDiscoveryDataModelProperties.IS_HOSTING);
	}

	/**
	 * Sets hosting link as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newIsHosting
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setIsHosting(Boolean newIsHosting) {
		model.setProperty(ILinkDiscoveryDataModelProperties.IS_HOSTING, newIsHosting);
	}

	/**
	 * Determine if the IsHosting property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the IsHosting
	 *         property is valid.
	 * @see #getIsHosting()
	 * @see #setIsHosting(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIsHosting() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.IS_HOSTING);

	}

	/**
	 * Determine the default value of the IsHosting property.
	 * 
	 * @return The default value of the IsHosting property.
	 * @see #getIsHosting()
	 * @see #setIsHosting(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsHosting() {
		return (Boolean) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.IS_HOSTING);
	}

	/**
	 * Return the value of IsLogical field.
	 * 
	 * @return The value of IsLogical field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getIsLogical() {
		return (Boolean) model.getProperty(ILinkDiscoveryDataModelProperties.IS_LOGICAL);
	}

	/**
	 * Sets logical link as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newIsLogical
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setIsLogical(Boolean newIsLogical) {
		model.setProperty(ILinkDiscoveryDataModelProperties.IS_LOGICAL, newIsLogical);
	}

	/**
	 * Determine if the IsLogical property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the IsLogical
	 *         property is valid.
	 * @see #getIsLogical()
	 * @see #setIsLogical(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIsLogical() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.IS_LOGICAL);

	}

	/**
	 * Determine the default value of the IsLogical property.
	 * 
	 * @return The default value of the IsLogical property.
	 * @see #getIsLogical()
	 * @see #setIsLogical(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsLogical() {
		return (Boolean) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.IS_LOGICAL);
	}

	/**
	 * Return the value of IsDependency field.
	 * 
	 * @return The value of IsDependency field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getIsDependency() {
		return (Boolean) model.getProperty(ILinkDiscoveryDataModelProperties.IS_DEPENDENCY);
	}

	/**
	 * Sets group as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newIsDependency
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setIsDependency(Boolean newIsDependency) {
		model.setProperty(ILinkDiscoveryDataModelProperties.IS_DEPENDENCY, newIsDependency);
	}

	/**
	 * Determine if the IsDependency property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         IsDependency property is valid.
	 * @see #getIsDependency()
	 * @see #setIsDependency(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIsDependency() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.IS_DEPENDENCY);

	}

	/**
	 * Determine the default value of the IsDependency property.
	 * 
	 * @return The default value of the IsDependency property.
	 * @see #getIsDependency()
	 * @see #setIsDependency(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsDependency() {
		return (Boolean) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.IS_DEPENDENCY);
	}

	/**
	 * Return the value of IsGroup field.
	 * 
	 * @return The value of IsGroup field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getIsGroup() {
		return (Boolean) model.getProperty(ILinkDiscoveryDataModelProperties.IS_GROUP);
	}

	/**
	 * Sets group as the relationship type used for discovery.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newIsGroup
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setIsGroup(Boolean newIsGroup) {
		model.setProperty(ILinkDiscoveryDataModelProperties.IS_GROUP, newIsGroup);
	}

	/**
	 * Determine if the IsGroup property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the IsGroup
	 *         property is valid.
	 * @see #getIsGroup()
	 * @see #setIsGroup(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIsGroup() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.IS_GROUP);

	}

	/**
	 * Determine the default value of the IsGroup property.
	 * 
	 * @return The default value of the IsGroup property.
	 * @see #getIsGroup()
	 * @see #setIsGroup(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsGroup() {
		return (Boolean) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.IS_GROUP);
	}

	/**
	 * Return the value of DeploymentObjectModel field.
	 * 
	 * @return The value of DeploymentObjectModel field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Requirement getRequirement() {
		return (Requirement) model.getProperty(ILinkDiscoveryDataModelProperties.REQUIREMENT);
	}

	public void setRequirement(Requirement requirement) {
		model.setProperty(ILinkDiscoveryDataModelProperties.REQUIREMENT, requirement);
	}

	/**
	 * Determine if the DeploymentObjectModel property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         DeploymentObjectModel property is valid.
	 * @see #getDeploymentObjectModel()
	 * @see #setDeploymentObjectModel(DeployModelObject)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDeploymentObjectModel() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.REQUIREMENT);

	}

	/**
	 * Determine the default value of the DeploymentObjectModel property.
	 * 
	 * @return The default value of the DeploymentObjectModel property.
	 * @see #getDeploymentObjectModel()
	 * @see #setDeploymentObjectModel(DeployModelObject)
	 * @generated (mde.utilities.datamodels)
	 */
	protected DeployModelObject getDefaultRequirement() {
		return (Requirement) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.REQUIREMENT);
	}

	/**
	 * Return the value of Descriptors field.
	 * 
	 * @return The value of Descriptors field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Object[] getDescriptors() {
		return (Object[]) model.getProperty(ILinkDiscoveryDataModelProperties.DESCRIPTORS);
	}

	/**
	 * The Descriptors property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDescriptors
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDescriptors(Object[] newDescriptors) {
		model.setProperty(ILinkDiscoveryDataModelProperties.DESCRIPTORS, newDescriptors);
	}

	/**
	 * Determine if the Descriptors property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Descriptors
	 *         property is valid.
	 * @see #getDescriptors()
	 * @see #setDescriptors(List)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDescriptors() {
		return model.validateProperty(ILinkDiscoveryDataModelProperties.DESCRIPTORS);

	}

	/**
	 * Determine the default value of the Descriptors property.
	 * 
	 * @return The default value of the Descriptors property.
	 * @see #getDescriptors()
	 * @see #setDescriptors(List)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Object[] getDefaultDescriptors() {
		return (Object[]) model.getDefaultProperty(ILinkDiscoveryDataModelProperties.DESCRIPTORS);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		LinkDiscoveryDataModelOperation operation = new LinkDiscoveryDataModelOperation(this);
		return operation;
	}

	/**
	 * The underlying datamodel that backs this facade.
	 * 
	 * @return The underlying datamodel that backs this facade.
	 */
	public final IDataModel getUnderlyingDataModel() {
		return model;
	}

	/**
	 * Validates all properties associated with this type-safe data model.
	 * 
	 * @return The collective status of all properties associated with the underlying datamodel.
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate() {
		return model.validate(false);
	}

	public Boolean shouldCreateSelectionPage() {
		return (Boolean) model
				.getProperty(ILinkDiscoveryDataModelProperties.SHOULD_SHOW_SELCTION_PAGE);
	}

	public Boolean getShouldShowSelectionPage() {
		return (Boolean) model
				.getProperty(ILinkDiscoveryDataModelProperties.SHOULD_SHOW_SELCTION_PAGE);
	}

	public void setShouldShowSelectionPage(Boolean aBoolean) {
		model.setProperty(ILinkDiscoveryDataModelProperties.SHOULD_SHOW_SELCTION_PAGE, aBoolean);
	}
}
