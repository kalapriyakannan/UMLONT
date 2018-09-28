/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateNamespaceDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateNamespaceDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateNamespaceDataModelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;

/**
 * 
 * This data model is used to create a new namespace within a project in the workspace.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>sourcePath</b>: This is the path to the root folder for the topologies. The path must be
 * at least one segment long where the first segment is a valid project name. </li>
 * <li><b>namespacePath</b>: This is the path for the namespace. This property is optional. If a
 * value is not set then the defaul will be an empty namespace. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class CreateNamespaceDataModel {

	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static CreateNamespaceDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new CreateNamespaceDataModel(model);
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
		return new CreateNamespaceDataModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceDataModel(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newSourcePath
	 *           The new value of the SourcePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setSourcePath(String newSourcePath) {
		model.setProperty(ICreateNamespaceDataModelProperties.SOURCE_PATH, newSourcePath);
	}

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * @return The value of the SourcePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getSourcePath() {
		return (String) model.getProperty(ICreateNamespaceDataModelProperties.SOURCE_PATH);
	}

	/**
	 * Determine if the SourcePath property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the SourcePath
	 *         property is valid.
	 * @see #getSourcePath()
	 * @see #setSourcePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSourcePath() {
		return model.validateProperty(ICreateNamespaceDataModelProperties.SOURCE_PATH);
	}

	/**
	 * Determine the default value of the SourcePath property.
	 * 
	 * @return The default value of the SourcePath property.
	 * @see #getSourcePath()
	 * @see #setSourcePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultSourcePath() {
		return (String) model.getDefaultProperty(ICreateNamespaceDataModelProperties.SOURCE_PATH);
	}

	/**
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newNamespacePath
	 *           The new value of the NamespacePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setNamespacePath(String newNamespacePath) {
		model.setProperty(ICreateNamespaceDataModelProperties.NAMESPACE_PATH, newNamespacePath);
	}

	/**
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * @return The value of the NamespacePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getNamespacePath() {
		return (String) model.getProperty(ICreateNamespaceDataModelProperties.NAMESPACE_PATH);
	}

	/**
	 * Determine if the NamespacePath property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         NamespacePath property is valid.
	 * @see #getNamespacePath()
	 * @see #setNamespacePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateNamespacePath() {
		return model.validateProperty(ICreateNamespaceDataModelProperties.NAMESPACE_PATH);
	}

	/**
	 * Determine the default value of the NamespacePath property.
	 * 
	 * @return The default value of the NamespacePath property.
	 * @see #getNamespacePath()
	 * @see #setNamespacePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultNamespacePath() {
		return (String) model.getDefaultProperty(ICreateNamespaceDataModelProperties.NAMESPACE_PATH);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		CreateNamespaceDataModelOperation operation = new CreateNamespaceDataModelOperation(this);
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

	/**
	 * @return An {@link IContainer} defined for the
	 *         {@link ICreateTopologyDataModelProperties#SOURCE_PATH} property.
	 */
	public IContainer getSourceContainer() {
		String sourcePath = getSourcePath();
		if (sourcePath != null) {
			return CreateNamespaceDataModelProvider
					.getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	public IContainer getNamespaceContainer() {
		String namepsacePath = model
				.getStringProperty(ICreateNamespaceDataModelProperties.NAMESPACE_PATH);
		return CreateNamespaceDataModelProvider.computeContainerFromNamespace(getSourceContainer(),
				namepsacePath);
	}

	public String getQualifiedNamespaceName() {
		String sourcePath = getSourcePath();
		String namespacePath = getNamespacePath();

		String namespace = new String();

		if (namespacePath != null && sourcePath != null
				&& namespacePath.length() > sourcePath.length()) {
			namespace = namespacePath.substring(sourcePath.length()).replace(IPath.SEPARATOR,
					IConstants.DOT_SEPARATOR);
		}

		return namespace;
	}
}
