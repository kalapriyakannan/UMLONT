package com.ibm.ccl.soa.deploy.ide.internal.refactoring;

public interface IRenameNamespaceModelProperties {

	/**
	 * 
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String SOURCE_PATH = "IRenameNamespaceModelProperties.SOURCE_PATH"; //$NON-NLS-1$

	/**
	 * 
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String PREVIOUS_NAMESPACE_PATH = "IRenameNamespaceModelProperties.PREVIOUS_NAMESPACE_PATH"; //$NON-NLS-1$

	/**
	 * 
	 * This is the path for the namespace. This property is optional. If a value is not set then the
	 * defaul will be an empty namespace.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String NEW_NAMESPACE_PATH = "IRenameNamespaceModelProperties.NEW_NAMESPACE_PATH"; //$NON-NLS-1$

	/**
	 * 
	 * This is a boolean idicating if subnamespaces of the renamed namespace should also be rename so
	 * that they will continue to be parented by the renamed namespace.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String RENAME_SUBNAMESPACES = "IRenameNamespaceModelProperties.RENAME_SUBNAMESPACES"; //$NON-NLS-1$
}
