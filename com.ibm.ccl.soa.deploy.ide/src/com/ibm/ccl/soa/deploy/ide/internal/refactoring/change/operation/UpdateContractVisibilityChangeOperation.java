/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateContractVisibilityChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateContractVisibilityChange;

/**
 * 
 * Provides a type-specific implementation of the DeleteViewChange model.
 * 
 * <p>
 * Clients should use {@link DeleteViewChange#createConfiguredOperation()} to create an instance of
 * this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateContractVisibilityChangeOperation extends DeployRefactoringChangeOperation
		implements IUpdateContractVisibilityChangeProperties {

	private UpdateContractVisibilityChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateContractVisibilityChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new UpdateContractVisibilityChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateContractVisibilityChangeOperation(UpdateContractVisibilityChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	@Override
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		try {

			URI uri = typesafeModel.getDmo();
			int flag = typesafeModel.getContractFlag();

			IFile topologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(uri.toPlatformString(true)));

			Topology topology = getTopology(topologyFile);
			DeployModelObject dmo = topology.resolve(uri.fragment());
			ConfigurationContract contract = dmo.getEditTopology().getConfigurationContract();
			if (contract == null) {
				return IDEPlugin.createErrorStatus(0, NLS.bind(
						Messages.UpdateContractVisibilityChangeOperation_No_contract_defined_for_0_, dmo
								.getTopology().getDisplayName()), null);
			}

			switch (flag)
			{
			case UpdateContractVisibilityChange.PUBLIC_EDITABLE_FLAG:
				contract.export(dmo, true);
				break;
			case UpdateContractVisibilityChange.PUBLIC_FLAG:
				contract.export(dmo, false);
				break;
			case UpdateContractVisibilityChange.PRIVATE_FLAG:
				contract.unexport(dmo);
			}

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
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
	private void setTypeSafeModel(UpdateContractVisibilityChange mdl) {
		typesafeModel = mdl;
	}
}
