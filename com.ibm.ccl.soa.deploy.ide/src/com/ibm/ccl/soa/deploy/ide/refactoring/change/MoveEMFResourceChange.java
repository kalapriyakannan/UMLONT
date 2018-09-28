/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.ui.ide.undo.MoveResourcesOperation;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.MoveEMFResourceChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.CompositeEMFDataModelOperation;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.MoveEMFResourceChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the MoveResourceChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>source</b>:
 * 
 * </li>
 * <li><b>destination</b>:
 * 
 * </li>
 * </ul>
 * 
 * <p>
 * The following <b>nested models</b> are used by this datamodel. Nested datamodels are used to
 * supplement the information collected by an enclosing datamodel or to execute nested operations
 * directly. The type-safe facade provides generates type-safe facades for each of the nested
 * datamodels, and provides the appropriate accessors and mutators.
 * </p>
 * <p>
 * Accessors (methods that begin with "get") will first check the facaded datamodel for an instance
 * of the nested datamodel, and if found, wrap it in a type-safe facade. Otherwise, the appropriate
 * datamodel will be created, wrapped, and returned.
 * </p>
 * <p>
 * Clients are not required to supply their own instances of nested models (as they are created when
 * accessors ("get") methods are called, but may access the
 * {@link #getUnderlyingDataModel() underlying datamodel} directly if they require advanced
 * customization.
 * </p>
 * <ul>
 * <li><b>scribblerDefinition</b> (Type:
 * {@link com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel} ) : Used by
 * {@code DeployRefactoringChange} classes that need to modify EMF models. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class MoveEMFResourceChange extends MoveResourceChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static MoveEMFResourceChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new MoveEMFResourceChange(model);
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
		return new MoveEMFResourceChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveEMFResourceChange(IDataModel mdl) {
		super(mdl);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {

		IFile source = ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
		MoveEMFResourceChangeOperation moveEMFResourceOperation = new MoveEMFResourceChangeOperation(
				this);

		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(Transaction.OPTION_NO_TRIGGERS, Boolean.TRUE);
		CompositeEMFDataModelOperation operation = new CompositeEMFDataModelOperation(
				moveEMFResourceOperation.getEditingDomain(), getName(), options);
		operation.setTransactionNestingEnabled(false);
		operation.add(new MoveResourcesOperation(source, getDestination(), getName()));
		operation.add(moveEMFResourceOperation);

		return operation;
	}
}
