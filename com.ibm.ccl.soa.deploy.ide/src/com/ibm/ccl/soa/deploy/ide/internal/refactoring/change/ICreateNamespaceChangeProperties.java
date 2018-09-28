package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

public interface ICreateNamespaceChangeProperties extends IRefactoringDataModelChangeProperties {

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
	String SOURCE_PATH = "ICreateNamespaceChangeProperties.SOURCE_PATH"; //$NON-NLS-1$

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
	String NAMESPACE_PATH = "ICreateNamespaceChangeProperties.NAMESPACE_PATH"; //$NON-NLS-1$
}
