/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateContractVisibilityChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateContractVisibilityChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.UpdateContractVisibilityChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the DeleteViewChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>view</b>: The View property. </li>
 * </ul>
 * 
 */
public class UpdateContractVisibilityChange extends DeployRefactoringChange {

	/**
	 * Flag for contract setting to Public-Editable.
	 */
	public static final int PUBLIC_EDITABLE_FLAG = 0;
	/**
	 * Flag for contract setting to Public.
	 */
	public static final int PUBLIC_FLAG = 1;
	/**
	 * Flag for contract setting to Private.
	 */
	public static final int PRIVATE_FLAG = 2;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static UpdateContractVisibilityChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new UpdateContractVisibilityChange(model);
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
		return new UpdateContractVisibilityChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateContractVisibilityChange(IDataModel mdl) {
		super(mdl);
	}

	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(getDmo().toPlatformString(true)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return "update contract to " + getContractName(getContractFlag()); //$NON-NLS-1$
	}

	private String getContractName(int flag) {
		switch (flag)
		{
		case PUBLIC_EDITABLE_FLAG:
			return "public editable"; //$NON-NLS-1$

		case PUBLIC_FLAG:
			return "public"; //$NON-NLS-1$

		case PRIVATE_FLAG:
			return "private"; //$NON-NLS-1$

		default:
			return "unknown contract type"; //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDmo
	 *           The new value of the Dmo property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDmo(org.eclipse.emf.common.util.URI newDmo) {
		getUnderlyingDataModel().setProperty(IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE,
				newDmo);
	}

	/**
	 * 
	 * 
	 * @return The value of the Dmo property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDmo() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getProperty(
				IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE);
	}

	/**
	 * Determine if the Dmo property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the View
	 *         property is valid.
	 * @see #getDmo()
	 * @see #setDmo(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDmo() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE);
	}

	/**
	 * Determine the default value of the Dmo property.
	 * 
	 * @return The default value of the Dmo property.
	 * @see #getDmo()
	 * @see #setDmo(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public Integer getDefaultDmo() {
		return (Integer) getUnderlyingDataModel().getDefaultProperty(
				IUpdateContractVisibilityChangeProperties.DMO_TO_UPDATE);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newContractFlag
	 *           The new value of the ContractFlag property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setContractFlag(Integer newContractFlag) {
		getUnderlyingDataModel().setProperty(IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG,
				newContractFlag);
	}

	/**
	 * 
	 * 
	 * @return The value of the ContractFlag property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Integer getContractFlag() {
		return (Integer) getUnderlyingDataModel().getProperty(
				IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG);
	}

	/**
	 * Determine if the ContractFlag property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the View
	 *         property is valid.
	 * @see #getContractFlag()
	 * @see #setContractFlag(java.lang.Integer)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateContractFlag() {
		return getUnderlyingDataModel().validateProperty(
				IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG);
	}

	/**
	 * Determine the default value of the ContractFlag property.
	 * 
	 * @return The default value of the ContractFlag property.
	 * @see #getContractFlag()
	 * @see #setContractFlag(java.lang.Integer)
	 * @generated (mde.utilities.datamodels)
	 */
	public Integer getDefaultContractFlag() {
		return (Integer) getUnderlyingDataModel().getDefaultProperty(
				IUpdateContractVisibilityChangeProperties.CONTRACT_FLAG);
	}

	@Override
	public IUndoableOperation createConfiguredOperation() {
		UpdateContractVisibilityChangeOperation operation = new UpdateContractVisibilityChangeOperation(
				this);
		return operation;
	}

}
