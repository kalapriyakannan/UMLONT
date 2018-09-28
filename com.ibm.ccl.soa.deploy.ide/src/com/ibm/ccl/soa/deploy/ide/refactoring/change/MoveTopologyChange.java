package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.RenameTopologyChangeOperation;

public class MoveTopologyChange extends RenameTopologyChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static MoveTopologyChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new MoveTopologyChange(model);
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveTopologyChange(IDataModel mdl) {
		super(mdl);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		return new RenameTopologyChangeOperation(this);
//		RenameTopologyChangeOperation rename = new RenameTopologyChangeOperation(this);
//		CompositeEMFDataModelOperation operation = new CompositeEMFDataModelOperation(rename
//				.getEditingDomain(), getName());
//		operation.setTransactionNestingEnabled(false);
//
//		IFile source = ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
//		operation.add(new MoveResourcesOperation(source, getDestination(), getName()));
//		operation.add(rename);
//
//		return operation;
	}
}
