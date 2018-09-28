/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant;

import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.MoveTopologyOperation;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyDescriptor;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyDescriptor}. The provider
 * is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class MoveTopologyModelProvider extends AbstractDataModelProvider implements
		IMoveTopologyModelProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveTopologyModelProperties#CONTAINER
	 * 
	 */
	public IStatus validateContainer() {

		Assert.isTrue(model.getProperty(IMoveTopologyModelProperties.CONTAINER) instanceof String);

		String path = model.getStringProperty(IMoveTopologyModelProperties.CONTAINER);

		if (null == path || path.trim().length() == 0) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_The_container_path_is_not_valid_,
					path));
		}

		if (!path.startsWith(new String() + IConstants.PATH_SEPARATOR)) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_The_container_path_is_not_valid_,
					path));
		}

		IContainer container = null;
		IPath containerPath = new Path(path);

		if (containerPath.segmentCount() == 0) {
			return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_The_container_path_is_not_valid_,
					path));
		} else if (containerPath.segmentCount() == 1) {
			container = ResourcesPlugin.getWorkspace().getRoot().getProject(containerPath.segment(0));
		} else if (containerPath.segmentCount() > 1) {
			container = ResourcesPlugin.getWorkspace().getRoot().getFolder(containerPath);
		}

		if (null == container) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_Invalid_container_path_0_, path));
		}

		if (!container.isAccessible()) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_The_container_path_is_not_valid_,
					path));
		}

		INamespaceFragmentRoot root = NamespaceCore.getRoot(container);
		if (root == null) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
					Messages.MoveTopologyRefactoringDataModelProvider_0_is_not_contained_in_a_topology_,
					container.getFullPath()));
		}

		IResource[] topologies = (IResource[]) model
				.getProperty(IMoveTopologyModelProperties.TOPOLOGIES);
		for (int i = 0; i < topologies.length; i++) {
			if (topologies[i].getType() == IResource.FILE) {
				IFile file = (IFile) topologies[i];
				if (file.getParent().equals(container)) {
					return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
							Messages.MoveTopologyRefactoringDataModelProvider_Cannot_move_0_to_1_,
							new Object[] { file.getName(), container.getProjectRelativePath() }));
				}
			} else {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveTopologyRefactoringDataModelProvider_Cannot_move_0_to_1_,
						new Object[] { topologies[i].getName(), container.getProjectRelativePath() }));
			}
		}

		if (!topologies[0].getProject().equals(container.getProject())) {
			return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID,
					Messages.MoveTopologyModelProvider_Cannot_move_topology_files_to_proje_);
		}

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Container property.
	 * @see IMoveTopologyModelProperties#CONTAINER
	 * @see MoveTopologyDescriptor#getContainer()
	 * 
	 */
	protected String getDefaultContainer() {
		return ""; //$NON-NLS-1$ 
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveTopologyModelProperties#TOPOLOGIES
	 * 
	 */
	public IStatus validateTopologies() {
		Assert
				.isTrue(model.getProperty(IMoveTopologyModelProperties.TOPOLOGIES) instanceof IResource[]);

		ROTopologyModelManager manager = ROTopologyModelManager.create();

		try {

			IResource[] topologies = (IResource[]) model
					.getProperty(IMoveTopologyModelProperties.TOPOLOGIES);

			if (topologies == null || topologies.length == 0) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
						Messages.MoveTopologyRefactoringDataModelProvider_No_topologies_to_be_moved_);
			}

			for (int i = 0; i < topologies.length; i++) {
				if (topologies[i].getType() != IResource.FILE) {
					return new Status(
							IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID,
							NLS
									.bind(
											Messages.MoveTopologyRefactoringDataModelProvider_Cannot_move_non_topology_resources_,
											topologies[i].getFullPath()));
				}

				IFile topologyFile = (IFile) topologies[i];
				Topology topology = manager.openModel(topologyFile, new Listener() {
					public void onUnload(IFile unloadedResource) {
					}
				});

				if (topology.eResource().isModified()) {
					return new Status(
							IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID,
							NLS
									.bind(
											Messages.MoveTopologyRefactoringDataModelProvider_The_topology_0_has_unsaved_change_,
											topology.getQualifiedName()));
				}
			}
		} catch (Exception ex) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex.getLocalizedMessage(), ex);
		} finally {
			manager.dispose();
		}

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IMoveTopologyModelProperties#TOPOLOGIES
	 * 
	 */
	protected IResource[] getDefaultTopologies() {
		return new IResource[0];
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IMoveTopologyModelProperties.CONTAINER.equals(property)) {
			return validateContainer();
		} else if (IMoveTopologyModelProperties.TOPOLOGIES.equals(property)) {
			return validateTopologies();
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
		if (IMoveTopologyModelProperties.CONTAINER.equals(property)) {
			return getDefaultContainer();
		} else if (IMoveTopologyModelProperties.TOPOLOGIES.equals(property)) {
			return getDefaultTopologies();
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
		propertyNames.add(IMoveTopologyModelProperties.CONTAINER);
		propertyNames.add(IMoveTopologyModelProperties.TOPOLOGIES);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new MoveTopologyOperation(model);
	}

}
