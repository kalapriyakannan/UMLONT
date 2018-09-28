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
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.DeleteTopologyOperation;

public class DeleteTopologyModelProvider extends AbstractDataModelProvider implements
		IDeleteTopologyModelProperties {

	public IStatus validateTopology() {

		Assert.isTrue(model.getProperty(IDeleteTopologyModelProperties.TOPOLOGY) instanceof String);

		String path = model.getStringProperty(IDeleteTopologyModelProperties.TOPOLOGY);

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

		IStatus status = Status.OK_STATUS;
		ROTopologyModelManager manager = null;
		Topology topology = null;

		try {
			manager = ROTopologyModelManager.create();
			topology = manager.openModel(file, new Listener() {
				public void onUnload(IFile unloadedResource) {
				}
			});

			if (null != topology && topology.eResource().isModified()) {
				status = new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
						Messages.DeleteTopologyModelProvider_The_topology_file_0_contains_unsa_, file
								.getFullPath().toString()));
			}

			if (null == topology) {
				status = new Status(IStatus.INFO, IDEPlugin.PLUGIN_ID, NLS.bind(
						Messages.DeleteTopologyModelProvider_0_is_not_a_valid_topology_model_f_, file
								.getName()));
			}

		} catch (Exception ex) {
			IDEPlugin.logError(0, ex.toString(), ex);
		} finally {
			if (null != manager) {
				manager.dispose();
			}
		}

		return status;
	}

	protected String getDefaultTopology() {
		return new String();
	}

	public IStatus validate(String property) {
		if (IDeleteTopologyModelProperties.TOPOLOGY.equals(property)) {
			return validateTopology();
		} else {
			return Status.OK_STATUS;
		}

	}

	public Object getDefaultProperty(String property) {
		if (IDeleteTopologyModelProperties.TOPOLOGY.equals(property)) {
			return getDefaultTopology();
		} else {
			return null;
		}

	}

	public boolean propertySet(String propertyName, Object propertyValue) {
		return super.propertySet(propertyName, propertyValue);
	}

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IDeleteTopologyModelProperties.TOPOLOGY);
		return propertyNames;
	}

	public IDataModelOperation getDefaultOperation() {
		return new DeleteTopologyOperation(model);
	}
}
