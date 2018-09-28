package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.MoveEMFResourceChangeProvider;

public class RenameEMFResourceChange extends MoveEMFResourceChange {
	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static RenameEMFResourceChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new RenameEMFResourceChange(model);
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
	public RenameEMFResourceChange(IDataModel mdl) {
		super(mdl);
	}

	@Override
	public String getName() {
		return "rename to '" + getDestination().lastSegment() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
