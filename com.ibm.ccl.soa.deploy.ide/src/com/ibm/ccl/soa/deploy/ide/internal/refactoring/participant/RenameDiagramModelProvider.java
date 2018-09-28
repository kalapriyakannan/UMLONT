package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.RenameDiagramOperation;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameDiagramDescriptor;

public class RenameDiagramModelProvider extends AbstractDataModelProvider implements
		IRenameDiagramModelProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameDiagramModelProperties#DIAGRAM
	 * 
	 */
	public IStatus validateDiagram() {

		Assert.isTrue(model.getProperty(IRenameDiagramModelProperties.DIAGRAM) instanceof String);

		String path = model.getStringProperty(IRenameDiagramModelProperties.DIAGRAM);

		if (null == path || path.trim().length() == 0) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_Invalid_topology_file_path_0_,
					path));
		}

		if (!path.startsWith(new String() + IConstants.PATH_SEPARATOR)) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_Invalid_topology_file_path_0_,
					path));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		if (!IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_Invalid_topology_file_path_0_,
					path));
		}

		if (!file.isAccessible()) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_The_topology_file_0_is_not_ac_,
					file.getFullPath().toString()));
		}

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Topology property.
	 * @see IRenameDiagramModelProperties#DIAGRAM
	 * @see RenameDiagramDescriptor#getDiagram()
	 * 
	 */
	public String getDefaultDiagram() {
		return new String();
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameDiagramModelProperties#NAME
	 * 
	 */
	public IStatus validateName() {

		Assert.isTrue(model.getProperty(IRenameDiagramModelProperties.NAME) instanceof String);

		String newName = model.getStringProperty(IRenameDiagramModelProperties.NAME);

		if (newName == null || newName.trim().equals(new String())) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					Messages.RenameTopologyRefactoringDataModelProvider_Topology_name_is_required_);
		}

		if (!newName.endsWith(IConstants.TOPOLOGYV_EXTENSION)) {
			return new Status(
					IStatus.ERROR,
					DeployCorePlugin.PLUGIN_ID,
					NLS
							.bind(
									Messages.RenameTopologyRefactoringDataModelProvider_The_topology_name_must_use_the_file_,
									IConstants.TOPOLOGYV_EXTENSION));
		}

		if (!newName.startsWith(new String() + IConstants.PATH_SEPARATOR)) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_Invalid_topology_name_0_,
					newName));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(newName));
		if (file.exists()) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.RenameTopologyRefactoringDataModelProvider_A_topology_with_the_name_0_al_,
					file.getFullPath().lastSegment()));
		}

		return Status.OK_STATUS;
	}

	protected String getDefaultName() {
		return new String();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IRenameDiagramModelProperties.NAME.equals(property)) {
			return validateName();
		} else if (IRenameDiagramModelProperties.DIAGRAM.equals(property)) {
			return validateDiagram();
		} else {
			return Status.OK_STATUS;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IRenameDiagramModelProperties.NAME.equals(property)) {
			return getDefaultName();
		} else if (IRenameDiagramModelProperties.DIAGRAM.equals(property)) {
			return getDefaultDiagram();
		} else {
			return null;
		}

	}

	/**
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		return super.propertySet(propertyName, propertyValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IRenameDiagramModelProperties.NAME);
		propertyNames.add(IRenameDiagramModelProperties.DIAGRAM);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new RenameDiagramOperation(model);
	}
}
