package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

public class DeleteImportChangeProvider extends DeployRefactoringChangeProvider implements
		IDeleteImportChangeProperties {

	public IStatus validateImportedTopology() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeleteImportChangeProperties.IMPORTED_TOPOLOGY) instanceof IFile);

		return Status.OK_STATUS;
	}

	protected IFile getDefaultImportedTopology() {
		return null;
	}

	public IStatus validateTopology() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IDeleteImportChangeProperties.TOPOLOGY) instanceof IFile);

		return Status.OK_STATUS;
	}

	protected IFile getDefaultTopology() {
		return null;
	}

	public IStatus validate(String property) {
		if (IDeleteImportChangeProperties.IMPORTED_TOPOLOGY.equals(property)) {
			return validateImportedTopology();
		} else if (IDeleteImportChangeProperties.TOPOLOGY.equals(property)) {
			return validateTopology();
		} else {
			return super.validate(property);
		}

	}

	public Object getDefaultProperty(String property) {
		if (IDeleteImportChangeProperties.IMPORTED_TOPOLOGY.equals(property)) {
			return getDefaultImportedTopology();
		} else if (IDeleteImportChangeProperties.TOPOLOGY.equals(property)) {
			return getDefaultTopology();
		} else {
			return super.getDefaultProperty(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IDeleteImportChangeProperties.IMPORTED_TOPOLOGY);
		propertyNames.add(IDeleteImportChangeProperties.TOPOLOGY);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		throw new UnsupportedOperationException(
				"getDefaultOperation() is not supported in the " + getClass().getCanonicalName() + " class."); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
