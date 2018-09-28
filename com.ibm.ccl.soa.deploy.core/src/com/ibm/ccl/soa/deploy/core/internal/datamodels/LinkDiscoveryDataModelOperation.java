/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;
import com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation;

/**
 * 
 * This datamodel is used to determine types of links to be discovered
 * 
 * <p>
 * Clients should use {@link LinkDiscoveryDataModel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel
 * @generated (mde.utilities.datamodels)
 */
public class LinkDiscoveryDataModelOperation extends AbstractEMFScribblerOperation implements
		ILinkDiscoveryDataModelProperties {

	private LinkDiscoveryDataModel typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public LinkDiscoveryDataModelOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new LinkDiscoveryDataModel(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public LinkDiscoveryDataModelOperation(LinkDiscoveryDataModel tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {

		return ChangeScope.execute(new AbstractEMFOperation(getEditingDomain(), getLabel()) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				Object[] descriptors = typesafeModel.getDescriptors();
				for (int i = 0; i < descriptors.length; i++) {
					DiscoveryDescriptor descriptor = (DiscoveryDescriptor) descriptors[i];
					if (descriptor.getDescriptor() != null) {
						descriptor.getDescriptor().create();
					} else {
						switch (descriptor.getType().getValue())
						{
						case LinkType.HOSTING_VALUE:
							DiscoverAndAddService.INSTANCE.addAndHostDiscoveredUnitToTopology(descriptor
									.getTarget(), descriptor.getUd());
							break;

						case LinkType.DEPENDENCY_VALUE:
							DiscoverAndAddService.INSTANCE.addTargetUnitAndDependenyLinkToTopology(
									descriptor.getReq(), descriptor.getCap());
							break;
						case LinkType.MEMBER_VALUE:
							DiscoverAndAddService.INSTANCE.addAndContainDiscoveredUnitToTopology(
									descriptor.getTarget(), descriptor.getUd());
							break;
						}
					}
				}

				return Status.OK_STATUS;
			}

		}, getEditModelScribbler().getUndoContext(), monitor, null);

	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(LinkDiscoveryDataModel mdl) {
		typesafeModel = mdl;
	}

}
