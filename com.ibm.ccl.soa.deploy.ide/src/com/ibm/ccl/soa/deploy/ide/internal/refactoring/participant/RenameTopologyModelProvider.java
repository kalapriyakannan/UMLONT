/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
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
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.RenameTopologyOperation;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor}. The
 * provider is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class RenameTopologyModelProvider extends AbstractDataModelProvider implements
		IRenameTopologyModelProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameTopologyModelProperties#TOPOLOGY
	 * 
	 */
	public IStatus validateTopology() {

		Assert.isTrue(model.getProperty(IRenameTopologyModelProperties.TOPOLOGY) instanceof String);

		String path = model.getStringProperty(IRenameTopologyModelProperties.TOPOLOGY);

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
		if (!IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
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
	 * @see IRenameTopologyModelProperties#TOPOLOGY
	 * @see RenameTopologyDescriptor#getTopology()
	 * 
	 */
	protected String getDefaultTopology() {
		return new String();
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IRenameTopologyModelProperties#NAME
	 * 
	 */
	public IStatus validateName() {

		Assert.isTrue(model.getProperty(IRenameTopologyModelProperties.NAME) instanceof String);

		String newName = model.getStringProperty(IRenameTopologyModelProperties.NAME);

		if (newName == null || newName.trim().equals(new String())) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					Messages.RenameTopologyRefactoringDataModelProvider_Topology_name_is_required_);
		}

		if (!newName.endsWith(IConstants.TOPOLOGY_EXTENSION)) {
			return new Status(
					IStatus.ERROR,
					DeployCorePlugin.PLUGIN_ID,
					NLS
							.bind(
									Messages.RenameTopologyRefactoringDataModelProvider_The_topology_name_must_use_the_file_,
									IConstants.TOPOLOGY_EXTENSION));
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

	/**
	 * 
	 * @return The default value of the Name property.
	 * @see IRenameTopologyModelProperties#NAME
	 * @see RenameTopologyDescriptor#getName()
	 * @generated (mde.utilities.datamodels)
	 */
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
		if (IRenameTopologyModelProperties.NAME.equals(property)) {
			return validateName();
		} else if (IRenameTopologyModelProperties.TOPOLOGY.equals(property)) {
			return validateTopology();
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
		if (IRenameTopologyModelProperties.NAME.equals(property)) {
			return getDefaultName();
		} else if (IRenameTopologyModelProperties.TOPOLOGY.equals(property)) {
			return getDefaultTopology();
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
		propertyNames.add(IRenameTopologyModelProperties.NAME);
		propertyNames.add(IRenameTopologyModelProperties.TOPOLOGY);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new RenameTopologyOperation(model);
	}

}
