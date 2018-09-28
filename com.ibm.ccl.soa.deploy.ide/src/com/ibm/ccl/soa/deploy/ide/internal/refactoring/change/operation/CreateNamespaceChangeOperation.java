package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateNamespaceChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateNamespaceChange;

public class CreateNamespaceChangeOperation extends DeployRefactoringChangeOperation implements
		ICreateNamespaceChangeProperties {

	private CreateNamespaceChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new CreateNamespaceChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateNamespaceChangeOperation(CreateNamespaceChange tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	public IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {

		IContainer src = typesafeModel.getSourceContainer();
		IContainer container = typesafeModel.getNamespaceContainer();

		try {
			NamespaceCore.createRoot(src, monitor);
			INamespaceFragment fragment = (INamespaceFragment) NamespaceCore.create(container);
			fragment.create(monitor);
		} catch (CoreException ex) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex.toString(), ex);
		}

		return Status.OK_STATUS;
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(CreateNamespaceChange mdl) {
		typesafeModel = mdl;
	}
}
