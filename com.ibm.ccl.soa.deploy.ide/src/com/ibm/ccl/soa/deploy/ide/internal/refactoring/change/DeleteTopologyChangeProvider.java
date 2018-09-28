package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

public class DeleteTopologyChangeProvider extends DeployRefactoringChangeProvider implements
		IDeleteTopologyChangeProperties {

	public IStatus validateTopology() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IDeleteTopologyChangeProperties.TOPOLOGY) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath sourceProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(IDeleteTopologyChangeProperties.TOPOLOGY);		

		return Status.OK_STATUS;
	}

	protected org.eclipse.core.runtime.IPath getDefaultTopology() {
		return null;
	}

	public IStatus validate(String property) {
		if (IDeleteTopologyChangeProperties.TOPOLOGY.equals(property)) {
			return validateTopology();
		} else {
			return super.validate(property);
		}

	}

	public Object getDefaultProperty(String property) {
		if (IDeleteTopologyChangeProperties.TOPOLOGY.equals(property)) {
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
		propertyNames.add(IDeleteTopologyChangeProperties.TOPOLOGY);
		propertyNames.addAll(super.getPropertyNames());
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
