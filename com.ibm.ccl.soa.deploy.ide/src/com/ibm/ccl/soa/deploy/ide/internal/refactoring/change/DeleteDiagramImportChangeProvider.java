package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

public class DeleteDiagramImportChangeProvider extends DeployRefactoringChangeProvider implements
		IDeleteDiagramImportChangeProperties {

	public IStatus validateImportedTopology() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY) instanceof IFile);

		return Status.OK_STATUS;
	}

	protected IFile getDefaultImportedTopology() {
		return null;
	}

	public IStatus validateDiagram() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeleteDiagramImportChangeProperties.DIAGRAM) instanceof IFile);

		return Status.OK_STATUS;
	}

	protected IFile getDefaultDiagram() {
		return null;
	}

	public IStatus validate(String property) {
		if (IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY.equals(property)) {
			return validateImportedTopology();
		} else if (IDeleteDiagramImportChangeProperties.DIAGRAM.equals(property)) {
			return validateDiagram();
		} else {
			return super.validate(property);
		}

	}

	public Object getDefaultProperty(String property) {
		if (IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY.equals(property)) {
			return getDefaultImportedTopology();
		} else if (IDeleteDiagramImportChangeProperties.DIAGRAM.equals(property)) {
			return getDefaultDiagram();
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
		propertyNames.add(IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY);
		propertyNames.add(IDeleteDiagramImportChangeProperties.DIAGRAM);
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
