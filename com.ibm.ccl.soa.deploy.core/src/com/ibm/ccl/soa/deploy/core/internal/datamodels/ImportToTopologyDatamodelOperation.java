/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.ImportRefactoringProcessor;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.SynchronizationRefactoring;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * 	 
 * Executes a set of actions for the ImportToTopologyDatamodel model.
 * 
 * <p>
 * Clients should use {@link ImportToTopologyDatamodel#createConfiguredOperation()} to create
 * an instance of this operation, configured with the necessary model properties.
 * </p>
 *
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel
 * @generated (mde.utilities.datamodels)
 */
public class ImportToTopologyDatamodelOperation extends AbstractDataModelOperation implements
		IImportToTopologyDatamodelProperties {

	private ImportToTopologyDatamodel typesafeModel;
	private AbstractEMFOperation operation;

	/**
   * Construct an operation pre-configured with the given data model.
   * 
   * @param dMdl The datamodel to use when executing this operation. 
   * @generated (mde.utilities.datamodels)
   */
	public ImportToTopologyDatamodelOperation(IDataModel dMdl) {
    super(dMdl); 
    setTypeSafeModel(new ImportToTopologyDatamodel(dMdl));
  }

	/**
   * Construct an operation pre-configured with the given type-safe data model.
   * 
   * @param tsMdl The type-safe datamodel to use when executing this operation. 
   * @generated (mde.utilities.datamodels)
   */
	public ImportToTopologyDatamodelOperation(ImportToTopologyDatamodel tsMdl) {
    super(tsMdl.getUnderlyingDataModel());
    setTypeSafeModel(tsMdl);
  }

	@Override
	public boolean canExecute() {
		return getDataModel().validate().getSeverity() != IStatus.ERROR;

	}

	@Override
	public boolean canUndo() {
		return operation != null;
	}

	@Override
	public boolean canRedo() {
		return operation != null;
	}

	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Assert.isNotNull(getDataModel());

		IStatus opStatus = getDataModel().validate();

		//Continue if the status is OK or a WARNING.
		if (opStatus.getSeverity() == IStatus.ERROR) {
			return opStatus;
		}

		ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
				.createChangeScopeForWrite(typesafeModel.getTopologyFile());
		if (operation == null) {
			operation = createOperation(scope.getTransactionalEditingDomain());
		}

		try {
			opStatus = operation.execute(monitor, scope);
		} finally {
			if (monitor.isCanceled()) {
				scope.close(new SubProgressMonitor(monitor, 1));
				throw new OperationCanceledException();
			}
			scope.close(new SubProgressMonitor(monitor, 1));

			monitor.done();
		}
		return opStatus;
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (operation != null) {
			IStatus status = null;
			ChangeScope<Topology, DeploymentTopologyDomain> scope = null;
			try {
				scope = ChangeScope.createChangeScopeForWrite(typesafeModel.getTopologyFile());
				status = operation.undo(monitor, scope);
			} finally {
				if (scope != null) {
					if (monitor.isCanceled()) {

						scope.close(new SubProgressMonitor(monitor, 1));
						throw new OperationCanceledException();
					}
					status = scope.close(new SubProgressMonitor(monitor, 1));
					if (!status.isOK()) {
						return status;
					}
				}

				monitor.done();
			}
			return status;
		}
		return Status.CANCEL_STATUS;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (operation != null) {
			IStatus status = null;
			ChangeScope<Topology, DeploymentTopologyDomain> scope = null;
			try {
				scope = ChangeScope.createChangeScopeForWrite(typesafeModel.getTopologyFile());
				status = operation.redo(monitor, scope);
			} finally {
				if (scope != null) {
					if (monitor.isCanceled()) {
						scope.close(new SubProgressMonitor(monitor, 1));
						throw new OperationCanceledException();
					}
					status = scope.close(new SubProgressMonitor(monitor, 1));
					if (!status.isOK()) {
						return status;
					}
				}

				monitor.done();
			}
			return status;
		}
		return Status.CANCEL_STATUS;
	}

	private AbstractEMFOperation createOperation(
			TransactionalEditingDomain transactionalEditingDomain) {

		IFile topologyFile = typesafeModel.getTopologyFile();
		final IResource[] resources = typesafeModel.getResources();
		return new AbstractEMFOperation(
				transactionalEditingDomain,
				NLS
						.bind(
								DeployCoreMessages.ImportToTopologyDatamodelOperation_Importing_Resources_into_Topology_,
								resources.length, topologyFile.getName())) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				if (monitor == null) {
					monitor = new NullProgressMonitor();
				}

				monitor.beginTask(getLabel(), 10);
				try {
					ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
							.findChangeScope(info);

					Topology topology = scope.openTopology();

					final Set<TopologyUnitStub> stubs = resolveStubs(topology, resources, scope,
							DeployCorePlugin.subprogress(monitor, 2));

					SynchronizationDatamodel datamodel = SynchronizationDatamodel.createModel();
					datamodel.setStubs(stubs.toArray(new TopologyUnitStub[stubs.size()]));
					datamodel.setTopology(topology);
					SynchronizationRefactoring refactor = new SynchronizationRefactoring(
							new ImportRefactoringProcessor(datamodel));

					try {
						RefactoringStatus checkInitialConditions = refactor
								.checkInitialConditions(DeployCorePlugin.subprogress(monitor, 1));
						if (checkInitialConditions.isOK() && !monitor.isCanceled()) {

							RefactoringStatus checkFinalConditions = refactor
									.checkFinalConditions(DeployCorePlugin.subprogress(monitor, 1));
							if (checkFinalConditions.isOK() && !monitor.isCanceled()) {
								final PerformChangeOperation makeChanges = new PerformChangeOperation(
										new CreateChangeOperation(refactor));

								makeChanges.run(DeployCorePlugin.subprogress(monitor, 6));
							} else {
								return convert(checkFinalConditions);
							}
						} else {
							return convert(checkInitialConditions);
						}
					} catch (CoreException e) {
						IStatus errorStatus = DeployCorePlugin
								.createErrorStatus(
										0,
										DeployCoreMessages.ImportToTopologyDatamodelOperation_Could_not_import_selected_resources_,
										e);
						DeployCorePlugin.log(errorStatus);
						return errorStatus;

					}
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					return Status.OK_STATUS;
				} finally {
					monitor.done();
				}
			}

		};
	}

	/**
	 * @param droppedObjects
	 * @param dropObject
	 * @param monitor
	 * @return list of units
	 */
	private Set<TopologyUnitStub> resolveStubs(DeployModelObject importTarget,
			IResource[] resources, ChangeScope<Topology, DeploymentTopologyDomain> scope,
			IProgressMonitor monitor) {

		try {
			monitor.beginTask(
					DeployCoreMessages.ImportToTopologyDatamodelOperation_Resolving_resources_,
					resources.length * 4);

			IUnitProviderService providerService = ExtensionsCore.createProviderService();

			Set<TopologyUnitStub> dropChanges = new HashSet<TopologyUnitStub>();

			for (int i = 0; i < resources.length; i++) {
				monitor.subTask(resources[i].getName());

				UnitProvider[] unitProviders = providerService.findEnabledProvidersByInputOnly(
						resources[i], scope.openTopology().getDecoratorSemantic());

				monitor.worked(1);

				dropChanges.addAll(resolveStubsForDroppedObject(scope, resources[i], importTarget,
						unitProviders, DeployCorePlugin.subprogress(monitor, 3)));
			}

			return dropChanges;

		} finally {
			monitor.done();
		}
	}

	private Set<TopologyUnitStub> resolveStubsForDroppedObject(
			ChangeScope<Topology, DeploymentTopologyDomain> scope, Object dropObject,
			DeployModelObject dropTarget, UnitProvider[] unitProviders, IProgressMonitor monitor) {
		monitor.beginTask(DeployCoreMessages.ImportToTopologyDatamodelOperation_Resolving_stubs_,
				unitProviders.length);

		Set<TopologyUnitStub> cache = new HashSet<TopologyUnitStub>();
		for (int x = 0; x < unitProviders.length; ++x) {
			TopologyUnitStub[] topologyUnitStubs = unitProviders[x].resolveStubs(dropObject);

			if (topologyUnitStubs != null) {
				for (int y = 0; y < topologyUnitStubs.length; ++y) {
					monitor.subTask(topologyUnitStubs[y].getName());
					topologyUnitStubs[y].setTopology(scope.openTopology());
					topologyUnitStubs[y].setSource(unitProviders[x]);
					topologyUnitStubs[y].setDropTarget(dropTarget);
				}
				cache.addAll(Arrays.asList(topologyUnitStubs));
			}
			monitor.worked(1);
		}
		monitor.done();

		return cache;
	}

	private IStatus convert(RefactoringStatus status) {

		RefactoringStatusEntry[] entries = status.getEntries();

		RefactoringStatusEntry highestSeverityEntry = status.getEntryWithHighestSeverity();
		IStatus highestSeverity = highestSeverityEntry.toStatus();
		final MultiStatus warningStatus = new MultiStatus(highestSeverity.getPlugin(),
				highestSeverity.getCode(), highestSeverity.getMessage(), highestSeverity.getException());
		for (int i = 0; i < entries.length; i++) {
			warningStatus.add(entries[i].toStatus());
		}

		return warningStatus;
	}

	/**
   * This operation can accept a typesafe model that provides a more usable
   * interface to the {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
   * 
   * @param mdl The typesafe model that will drive this operation.
   * @generated (mde.utilities.datamodels)
   */
	private void setTypeSafeModel(ImportToTopologyDatamodel mdl) {
    typesafeModel = mdl;
  }
}
