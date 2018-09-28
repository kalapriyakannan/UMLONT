/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Use this operation to set the visibility of a given {@link DeployModelObject} within the
 * {@link ConfigurationContract} of the edit {@link Topology}.
 * 
 * @since CCL 2.0
 * 
 * @see #PUBLIC_FLAG
 * @see #PUBLIC_EDITABLE_FLAG
 * @see #PRIVATE_FLAG
 * 
 */
public class UpdateContractOperation extends AbstractEMFOperation {

	/**
	 * Flag for contract setting to Public-Editable.
	 */
	public static final int PUBLIC_EDITABLE_FLAG = 0;
	/**
	 * Flag for contract setting to Public.
	 */
	public static final int PUBLIC_FLAG = 1;
	/**
	 * Flag for contract setting to Private.
	 */
	public static final int PRIVATE_FLAG = 2;
	private final DeployModelObject dmo;
	private final int contractFlag;

	/**
	 * Creates a new instance of an {@link IUndoableOperation} that is capable of updating the
	 * contract configurations of the passed {@link DeployModelObject}s. The only requirement is
	 * that all of the passed {@link DeployModelObject}s must belong to the same
	 * {@link EditingDomain}.
	 * 
	 * @param objectsToUpdate
	 *           A {@link List} of {@link DeployModelObject}s that will be updated in the contract.
	 * @param contractFlag
	 *           A flag describing the contract change. This must be one of the following:
	 *           <p>
	 *           {@link #PUBLIC_FLAG}, {@link #PUBLIC_EDITABLE_FLAG}, or {@link #PRIVATE_FLAG}
	 *           </p>
	 * @param label
	 *           A {@link String} label describing the change.
	 * @return An {@link IUndoableOperation}.
	 */
	public static IUndoableOperation createUpdateContractOperation(
			List<? extends DeployModelObject> objectsToUpdate, int contractFlag, String label) {
		if (objectsToUpdate != null && !objectsToUpdate.isEmpty()) {
			DeployModelObject firstObject = objectsToUpdate.get(0);
			//Get editing Domain.
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(firstObject
					.getEObject());
			if (objectsToUpdate.size() > 1) {
				List<UpdateContractOperation> childOps = new ArrayList<UpdateContractOperation>(
						objectsToUpdate.size());
				for (Iterator<? extends DeployModelObject> it = objectsToUpdate.iterator(); it
						.hasNext();) {
					childOps.add(new UpdateContractOperation(it.next(), contractFlag, label));
				}
				return new CompositeEMFOperation(domain, label, childOps);
			}
			return new UpdateContractOperation(firstObject, contractFlag, label);
		}
		return null;
	}

	/**
	 * 
	 * Creates a new instance of this operation to update the contract configurations of the passed
	 * {@link DeployModelObject}.
	 * 
	 * @param dmo
	 *           A {@link DeployModelObject} that will be updated in the contract.
	 * @param contractFlag
	 *           A flag describing the contract change. This must be one of the following:
	 *           <p>
	 *           {@link #PUBLIC_FLAG}, {@link #PUBLIC_EDITABLE_FLAG}, or {@link #PRIVATE_FLAG}
	 *           </p>
	 * @param label
	 *           A {@link String} label describing the change.
	 */
	public UpdateContractOperation(DeployModelObject dmo, int contractFlag, String label) {
		super(TransactionUtil.getEditingDomain(dmo.getEObject()), label);
		this.dmo = dmo;
		this.contractFlag = contractFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
		assert dmo.getEditTopology() != null;
		ConfigurationContract contract = dmo.getEditTopology().getConfigurationContract();
		if (contract == null) {
			//No contract exists.  Return error status.
			return DeployCorePlugin.createErrorStatus(0, NLS.bind(
					DeployCoreMessages.UpdateContractOperation_No_contract_defined_for_0_, dmo
							.getTopology().getDisplayName()), null);
		}
//	/	setOriginalContractFlag(contract);
		switch (contractFlag)
		{
		case PUBLIC_EDITABLE_FLAG:
			contract.export(dmo, true);
			break;
		case PUBLIC_FLAG:
			contract.export(dmo, false);
			break;
		case PRIVATE_FLAG:
			contract.unexport(dmo);
		}
		return Status.OK_STATUS;
	}

//	@Override
//	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) {
//		ConfigurationContract contract = dmo.getEditTopology().getConfigurationContract();
//		switch (originalFlag) {
//		case PUBLIC_EDITABLE_FLAG:
//			contract.export(dmo, true);
//			break;
//		case PUBLIC_FLAG:
//			contract.export(dmo, false);
//			break;
//		case PRIVATE_FLAG:
//			contract.unexport(dmo);
//		}
//		return Status.OK_STATUS;
//	}
//	
//	@Override
//	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info){
//		return doExecute(monitor, info);
//	}
//
//	private void setOriginalContractFlag(ConfigurationContract contract) {
//		if (contract.isConfigurable(dmo)) {
//			originalFlag = PUBLIC_EDITABLE_FLAG;
//		} else if (contract.isLinkable(dmo)) {
//			originalFlag = PUBLIC_FLAG;
//		} else {
//			originalFlag = PRIVATE_FLAG;
//		}
//	}
}
