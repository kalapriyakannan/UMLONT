package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.CreateNamespaceChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateNamespaceChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.CreateNamespaceChangeOperation;

public class CreateNamespaceChange extends DeployRefactoringChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static CreateNamespaceChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new CreateNamespaceChange(model);
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
		return new CreateNamespaceChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceChange(IDataModel mdl) {
		super(mdl);
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
		getUnderlyingDataModel().setProperty(ICreateNamespaceChangeProperties.SOURCE_PATH,
				newSourcePath);
	}

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * @return The value of the SourcePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getSourcePath() {
		return (String) getUnderlyingDataModel().getProperty(
				ICreateNamespaceChangeProperties.SOURCE_PATH);
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
		return getUnderlyingDataModel()
				.validateProperty(ICreateNamespaceChangeProperties.SOURCE_PATH);
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
		return (String) getUnderlyingDataModel().getDefaultProperty(
				ICreateNamespaceChangeProperties.SOURCE_PATH);
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
		getUnderlyingDataModel().setProperty(ICreateNamespaceChangeProperties.NAMESPACE_PATH,
				newNamespacePath);
	}

	/**
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * @return The value of the NamespacePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getNamespacePath() {
		return (String) getUnderlyingDataModel().getProperty(
				ICreateNamespaceChangeProperties.NAMESPACE_PATH);
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
		return getUnderlyingDataModel().validateProperty(
				ICreateNamespaceChangeProperties.NAMESPACE_PATH);
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
		return (String) getUnderlyingDataModel().getDefaultProperty(
				ICreateNamespaceChangeProperties.NAMESPACE_PATH);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		CreateNamespaceChangeOperation operation = new CreateNamespaceChangeOperation(this);
		return operation;
	}

	/**
	 * Validates all properties associated with this type-safe data model.
	 * 
	 * @return The collective status of all properties associated with the underlying datamodel.
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate() {
		return getUnderlyingDataModel().validate(false);
	}

	/**
	 * @return An {@link IContainer} defined for the
	 *         {@link ICreateTopologyDataModelProperties#SOURCE_PATH} property.
	 */
	public IContainer getSourceContainer() {
		String sourcePath = getSourcePath();
		if (sourcePath != null) {
			return CreateNamespaceChangeProvider.getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	public IContainer getNamespaceContainer() {
		String namepsacePath = getUnderlyingDataModel().getStringProperty(
				ICreateNamespaceChangeProperties.NAMESPACE_PATH);
		return CreateNamespaceChangeProvider.computeContainerFromNamespace(getSourceContainer(),
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

	@Override
	public Object getModifiedElement() {
		return getNamespaceContainer();
	}

	@Override
	public String getName() {
		return NLS.bind(Messages.CreateNamespaceChange_create_namespace_0_,
				getQualifiedNamespaceName());
	}

}
