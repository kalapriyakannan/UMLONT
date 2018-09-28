package com.ibm.ccl.soa.deploy.ide.refactoring;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IRenameNamespaceModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.RenameNamespaceModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.operation.RenameNamespaceOperation;

public class RenameNamespaceRefactoringDescriptor extends RefactoringDescriptor {

	/**
	 * Refactoring id of the 'Rename Namespace' refactoring (value:
	 * <code>com.ibm.ccl.soa.deploy.ide.refactoring.rename.namespace</code>).
	 * <p>
	 * Clients may safely cast the obtained refactoring descriptor to
	 * {@link RenameNamespaceRefactoringDescriptor}.
	 * </p>
	 */
	public static final String ID = "com.ibm.ccl.soa.deploy.ide.refactoring.rename.namespace"; //$NON-NLS-1$

	private final IDataModel model;
	private final ROTopologyModelManager modelManager = null;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static RenameNamespaceRefactoringDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new RenameNamespaceRefactoringDescriptor(model);
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
		return new RenameNamespaceModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameNamespaceRefactoringDescriptor(IDataModel mdl) {
		super(
				ID,
				null,
				"N/A", null, RefactoringDescriptor.STRUCTURAL_CHANGE | RefactoringDescriptor.MULTI_CHANGE); //$NON-NLS-1$
		model = mdl;
	}

	@Override
	public Refactoring createRefactoring(RefactoringStatus status) throws CoreException {
		RenameNamespaceProcessor processor = new RenameNamespaceProcessor(this);
		return new RenameRefactoring(processor);
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
	public void setSourcePath(String sourcePath) {
		model.setProperty(IRenameNamespaceModelProperties.SOURCE_PATH, sourcePath);
	}

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * @return The value of the SourcePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getSourcePath() {
		return (String) model.getProperty(IRenameNamespaceModelProperties.SOURCE_PATH);
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
		return model.validateProperty(IRenameNamespaceModelProperties.SOURCE_PATH);
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
		return (String) model.getDefaultProperty(IRenameNamespaceModelProperties.SOURCE_PATH);
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
	public void setPreviousNamespacePath(String previousNamespacePath) {
		model.setProperty(IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH,
				previousNamespacePath);
	}

	/**
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * @return The value of the NamespacePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getPreviousNamespacePath() {
		return (String) model.getProperty(IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH);
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
	public IStatus validatePreviousNamespacePath() {
		return model.validateProperty(IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH);
	}

	/**
	 * Determine the default value of the NamespacePath property.
	 * 
	 * @return The default value of the NamespacePath property.
	 * @see #getNamespacePath()
	 * @see #setNamespacePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultPreviousNamespacePath() {
		return (String) model
				.getDefaultProperty(IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH);
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
	public void setNewNamespacePath(String newNamespacePath) {
		model.setProperty(IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH, newNamespacePath);
	}

	/**
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * @return The value of the NamespacePath property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getNewNamespacePath() {
		return (String) model.getProperty(IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH);
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
	public IStatus validateNewNamespacePath() {
		return model.validateProperty(IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH);
	}

	/**
	 * Determine the default value of the NamespacePath property.
	 * 
	 * @return The default value of the NamespacePath property.
	 * @see #getNamespacePath()
	 * @see #setNamespacePath(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultNewNamespacePath() {
		return (String) model.getDefaultProperty(IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH);
	}

	/**
	 * This is a boolean value indicating if subnamespaces should also be renamed.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param rename
	 *           boolean indicating if subnamespaces should be renamed
	 * @generated (mde.utilities.datamodels)
	 */
	public void setRenameSubNamespaces(Boolean rename) {
		model.setProperty(IRenameNamespaceModelProperties.RENAME_SUBNAMESPACES, rename);
	}

	/**
	 * This is a boolean value indicating if subnamespaces should also be renamed.
	 * 
	 * @return The value of the RenameSubNamespaces property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getRenameSubNamespaces() {
		return (Boolean) model.getProperty(IRenameNamespaceModelProperties.RENAME_SUBNAMESPACES);
	}

	/**
	 * Determine if the RenameSubNamespaces property is valid
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         RenameSubNamespaces property is valid.
	 * @see #getRenameSubNamespaces()
	 * @see #setRenameSubNamespaces(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateRenameSubNamespaces() {
		return model.validateProperty(IRenameNamespaceModelProperties.RENAME_SUBNAMESPACES);
	}

	/**
	 * Determine the default value of the RenameSubNamespaces property.
	 * 
	 * @return The default value of the RenameSubNamespaces property.
	 * @see #getRenameSubNamespaces()
	 * @see #setRenameSubNamespaces(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultRenameSubNamespaces() {
		return (Boolean) model
				.getDefaultProperty(IRenameNamespaceModelProperties.RENAME_SUBNAMESPACES);
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
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		RenameNamespaceOperation operation = new RenameNamespaceOperation(this);
		return operation;
	}

	/**
	 * @return An {@link IContainer} defined for the
	 *         {@link ICreateTopologyDataModelProperties#SOURCE_PATH} property.
	 */
	public IContainer getSourceContainer() {
		String sourcePath = getSourcePath();
		if (sourcePath != null) {
			return RenameNamespaceModelProvider.getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	public IContainer getPreviousNamespaceContainer() {
		String namepsacePath = model
				.getStringProperty(IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH);
		return RenameNamespaceModelProvider.computeContainerFromNamespace(getSourceContainer(),
				namepsacePath);
	}

	public String getPreviousNamespaceQualifiedName() {
		String sourcePath = getSourcePath();
		String namespacePath = getPreviousNamespacePath();

		String namespace = new String();

		if (namespacePath != null && sourcePath != null
				&& namespacePath.length() > sourcePath.length()) {
			namespace = namespacePath.substring(sourcePath.length()).replace(IPath.SEPARATOR,
					IConstants.DOT_SEPARATOR);
		}

		return namespace;
	}

	public IContainer getNewNamespaceContainer() {
		String namepsacePath = model
				.getStringProperty(IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH);
		return RenameNamespaceModelProvider.computeContainerFromNamespace(getSourceContainer(),
				namepsacePath);
	}

	public String getNewNamespaceQualifiedName() {
		String sourcePath = getSourcePath();
		String namespacePath = getNewNamespacePath();

		String namespace = new String();

		if (namespacePath != null && sourcePath != null
				&& namespacePath.length() > sourcePath.length()) {
			namespace = namespacePath.substring(sourcePath.length()).replace(IPath.SEPARATOR,
					IConstants.DOT_SEPARATOR);
		}

		return namespace;
	}

	public void dispose() {
		if (modelManager != null) {
			modelManager.dispose();
		}
	}

}
