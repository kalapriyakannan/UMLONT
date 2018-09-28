/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.synchronization;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.ChangeProvider;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationService;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * Defines a processor that carries out the import operation, including support for the extensible
 * participants.
 * 
 * @since 1.0
 * 
 */
public class ImportRefactoringProcessor extends RefactoringProcessor {

	private static final String PROCESSOR_ID = ImportRefactoringProcessor.class.getName();

	private final SynchronizationDatamodel datamodel;
	private final ISynchronizationService implementationService;

	/**
	 * Create a processor with the given datamodel, which should be shared with the UI exposed to the
	 * user.
	 * 
	 * @param datamodel
	 */
	public ImportRefactoringProcessor(SynchronizationDatamodel datamodel) {
		this.datamodel = datamodel;
		implementationService = ISynchronizationService.Factory.create(datamodel.getTopology());
	}

	public RefactoringStatus checkInitialConditions(IProgressMonitor monitor)
			throws OperationCanceledException {
		// could check validations on unit that would prevent a correct implementation 
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor,
			CheckConditionsContext context) throws OperationCanceledException {

		RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);
		try {
			TopologyUnitStub[] stubs = datamodel.getStubs();
			monitor.beginTask(
					DeployCoreMessages.ImportRefactoringProcessor_Verifying_the_import_refactoring_wi_,
					stubs.length);

			for (int i = 0; i < stubs.length; i++) {

				monitor.subTask(stubs[i].getName());
				CheckConditionsRunnable safeConditionsChecker = new CheckConditionsRunnable(status,
						stubs[i], monitor);

				ChangeProvider provider = stubs[i].getSource();
				safeConditionsChecker.setProvider(provider);
				SafeRunner.run(safeConditionsChecker);
				monitor.worked(1);
			}

		} finally {
			monitor.done();
		}

		return status;
	}

	public Change createChange(IProgressMonitor monitor) throws OperationCanceledException {

		// log message with monitor
		CompositeChange change = new CompositeChange(getProcessorName());
		try {
			TopologyUnitStub[] stubs = datamodel.getStubs();
			monitor.beginTask(
					DeployCoreMessages.ImportRefactoringProcessor_Calculating_changes_for_importing_,
					stubs.length);

			for (int i = 0; i < stubs.length; i++) {
				CompositeChange unitChange = new CompositeChange(NLS.bind(
						DeployCoreMessages.ImplementationRefactoringProcessor_Implement_the_0_component_,
						stubs[i].getName()));

				monitor.subTask(stubs[i].getName());
				CreateChangeRunnable safeChangeCreator = new CreateChangeRunnable(unitChange, stubs[i],
						monitor);

				ChangeProvider provider = stubs[i].getSource();
				safeChangeCreator.setProvider(provider);
				SafeRunner.run(safeChangeCreator);

				if (unitChange.getChildren().length > 0)
					change.add(unitChange);
			}

		} finally {
			monitor.done();
		}
		return change;

	}

	public Object[] getElements() {
		return datamodel.getComponents();
	}

	public String getIdentifier() {
		return PROCESSOR_ID;
	}

	public String getProcessorName() {
		return DeployCoreMessages.ImplementationRefactoringProcessor_Component_Implementation_Processo_;
	}

	public boolean isApplicable() {
		return true;
	}

	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants sharedParticipants) {
		return implementationService.loadEnabledParticipants(datamodel.getComponents(), this,
				new SynchronizationArguments(datamodel));
	}

	/**
	 * A common base type for provider runnables.
	 * 
	 * @since 1.0
	 * 
	 */
	private abstract class ImportProviderRunnable extends DeployCoreSafeRunnable {

		private final TopologyUnitStub stub;
		private final IProgressMonitor parentMonitor;

		private ChangeProvider provider;

		/**
		 * Stores the units as {@link #getPublicUnits()} and the makes the child monitor available as
		 * {@link #createSubProgressMonitor()}.
		 * 
		 * @param stub
		 *           The stub that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public ImportProviderRunnable(TopologyUnitStub stub, IProgressMonitor monitor) {
			Assert.isNotNull(stub);

			this.stub = stub;
			if (monitor == null)
				this.parentMonitor = new NullProgressMonitor();
			else
				this.parentMonitor = monitor;
		}

		protected final void setProvider(ChangeProvider provider) {
			this.provider = provider;
		}

		protected final ChangeProvider getProvider() {
			return provider;
		}

		protected final TopologyUnitStub getStub() {
			return stub;
		}

		protected final IProgressMonitor getParentMonitor() {
			return parentMonitor;
		}

		protected final IProgressMonitor createSubProgressMonitor() {
			return new SubProgressMonitor(getParentMonitor(), 5);
		}
	}

	private class CreateChangeRunnable extends ImportProviderRunnable {

		private final CompositeChange compositeChange;

		/**
		 * Create a safe runnable type that can execute the calculation of the implementation change
		 * for a given {@link #setProvider(CapabilityProvider) CapabilityProvider}.
		 * 
		 * @param compositeChange
		 *           A composite change created by the enclosing type.
		 * @param stub
		 *           The stub that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public CreateChangeRunnable(CompositeChange compositeChange, TopologyUnitStub stub,
				IProgressMonitor monitor) {
			super(stub, monitor);
			Assert.isNotNull(compositeChange);

			this.compositeChange = compositeChange;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * Be sure to set the provider before calling run!
		 * 
		 * @see #setProvider(CapabilityProvider)
		 */
		public void run() throws Exception {
			ChangeProvider cProvider = getProvider();
			if (cProvider != null) {
				Change[] changes = cProvider.createImportChange(datamodel.getTopology(), getStub(),
						createSubProgressMonitor());

				if (changes.length > 1) {
					CompositeChange importChange = new CompositeChange(NLS.bind(
							DeployCoreMessages.ImportRefactoringProcessor_Import_0_into_the_mode_,
							getStub().getName()));
					importChange.addAll(changes);
					compositeChange.add(importChange);
				} else { // importChanges.length == 1
					compositeChange.add(changes[0]);
				}

			}
		}
	}

	private class CheckConditionsRunnable extends ImportProviderRunnable {

		private final RefactoringStatus compositeStatus;

		/**
		 * Create a safe runnable type that can execute the calculation of the implementation change
		 * for a given {@link #setProvider(CapabilityProvider) CapabilityProvider}.
		 * 
		 * @param compositeStatus
		 *           A composite status created by the enclosing type.
		 * @param stub
		 *           The unit that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public CheckConditionsRunnable(RefactoringStatus compositeStatus, TopologyUnitStub stub,
				IProgressMonitor monitor) {
			super(stub, monitor);
			Assert.isNotNull(compositeStatus);

			this.compositeStatus = compositeStatus;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * Be sure to set the provider before calling run!
		 * 
		 * @see #setProvider(CapabilityProvider)
		 */
		public void run() throws Exception {
			ChangeProvider cProvider = getProvider();
			if (cProvider != null) {
				RefactoringStatus status = cProvider.checkConditionsForImport(getStub(),
						createSubProgressMonitor());
				if (status != null)
					compositeStatus.merge(status);
			}
		}
	}

}
