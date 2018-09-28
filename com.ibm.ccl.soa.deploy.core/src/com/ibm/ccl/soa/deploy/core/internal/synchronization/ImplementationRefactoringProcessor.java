/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.synchronization;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationService;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * Defines a processor that carries out the implementation operation, including support for the
 * extensible participants.
 * 
 * @since 1.0
 * 
 */
public class ImplementationRefactoringProcessor extends RefactoringProcessor {

	private static final String PROCESSOR_ID = ImplementationRefactoringProcessor.class.getName();

	private final SynchronizationDatamodel datamodel;
	private final ISynchronizationService implementationService;
	private final IUnitProviderService unitProviderService;
	private final ICapabilityProviderService capabilityProviderService;

	/**
	 * Create a processor with the given datamodel, which should be shared with the UI exposed to the
	 * user.
	 * 
	 * @param datamodel
	 */
	public ImplementationRefactoringProcessor(SynchronizationDatamodel datamodel) {
		this.datamodel = datamodel;
		implementationService = ISynchronizationService.Factory.create(datamodel.getTopology());
		unitProviderService = ExtensionsCore.createProviderService();
		capabilityProviderService = ExtensionsCore.createCapabilityProviderService();
	}

	public RefactoringStatus checkInitialConditions(IProgressMonitor monitor)
			throws OperationCanceledException {
		// could check validations on unit that would prevent a correct
		// implementation
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor,
			CheckConditionsContext context) throws OperationCanceledException {

		RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);
		try {
			Unit[] units = datamodel.getComponents();
			monitor
					.beginTask(
							DeployCoreMessages.ImplementationRefactoringProcessor_Verifying_the_implementation_refact_,
							units.length);

			for (int i = 0; i < units.length; i++) {

				monitor.subTask(units[i].getDisplayName());

				Set<ChangeProvider> providers = getImplementingProviders(units[i]);
				SubProgressMonitor subprogress = new SubProgressMonitor(monitor, providers.size());
				CheckConditionsRunnable safeConditionsChecker = new CheckConditionsRunnable(status,
						units[i], subprogress);

				for (Iterator iter = providers.iterator(); iter.hasNext();) {
					ChangeProvider provider = (ChangeProvider) iter.next();
					safeConditionsChecker.setProvider(provider);

					// ticks off 1 from the parent monitor
					SafeRunner.run(safeConditionsChecker);
				}
				monitor.worked(1); // for the unit

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
			Unit[] units = datamodel.getComponents();
			monitor
					.beginTask(
							DeployCoreMessages.ImplementationRefactoringProcessor_Creating_the_implementation_refacto_,
							units.length);

			for (int i = 0; i < units.length; i++) {
				CompositeChange unitChange = new SortedCompositeChange(NLS.bind(
						DeployCoreMessages.ImplementationRefactoringProcessor_Implement_the_0_component_,
						units[i].getDisplayName()));

				CreateChangeRunnable safeChangeCreator = new CreateChangeRunnable(unitChange, units[i],
						monitor);

				for (Iterator iter = getImplementingProviders(units[i]).iterator(); iter.hasNext();) {
					monitor.subTask(units[i].getDisplayName());
					ChangeProvider provider = (ChangeProvider) iter.next();
					safeChangeCreator.setProvider(provider);
					SafeRunner.run(safeChangeCreator);
				}
				if (unitChange.getChildren().length > 0) {
					change.add(unitChange);
				}

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

		// ensure topology is valid
		// final Topology topology = datamodel.getTopology();

		// ensure the components are valid
		Unit[] components = datamodel.getComponents();

		return implementationService.loadEnabledParticipants(components, this,
				new SynchronizationArguments(datamodel));
	}

	protected final Set<ChangeProvider> getImplementingProviders(Unit component) {

		String semantic = null;
		if (component.getEditTopology() != null) {
			semantic = component.getEditTopology().getDecoratorSemantic();
		}

		// a simple sorter to push capabilities to the front
		Set<ChangeProvider> implementingProviders = new TreeSet<ChangeProvider>(
				new ChangeProviderCompator());

		UnitProvider[] unitProviders = unitProviderService.findEnabledProvidersByOutputOnly(
				component, semantic);

		ChangeProvider[] capabilityProviders = capabilityProviderService
				.findEnabledCapabilityProvidersByOutputOnly(component);

		for (int i = 0; i < unitProviders.length; i++) {
			if (unitProviders[i].canImplement()) {
				implementingProviders.add(unitProviders[i]);
			}
		}

		for (int i = 0; i < capabilityProviders.length; i++) {
			if (capabilityProviders[i].canImplement()) {
				implementingProviders.add(capabilityProviders[i]);
			}
		}

		return implementingProviders;
	}

	/**
	 * A common base type for provider runnables.
	 * 
	 * @since 1.0
	 * 
	 */
	private abstract class ImplementationProviderRunnable extends DeployCoreSafeRunnable {

		private final Unit unit;
		private final IProgressMonitor parentMonitor;

		private ChangeProvider provider;

		/**
		 * Stores the units as {@link #getPublicUnits()} and the makes the child monitor available as
		 * {@link #createSubProgressMonitor()}.
		 * 
		 * @param unit
		 *           The unit that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public ImplementationProviderRunnable(Unit unit, IProgressMonitor monitor) {
			Assert.isNotNull(unit);

			this.unit = unit;
			if (monitor == null) {
				parentMonitor = new NullProgressMonitor();
			} else {
				parentMonitor = monitor;
			}
		}

		protected final void setProvider(ChangeProvider provider) {
			this.provider = provider;
		}

		protected final ChangeProvider getProvider() {
			return provider;
		}

		protected final Unit getUnit() {
			return unit;
		}

		protected final IProgressMonitor getParentMonitor() {
			return parentMonitor;
		}

		protected final IProgressMonitor createSubProgressMonitor() {
			return new SubProgressMonitor(getParentMonitor(), 1);
		}
	}

	private class CreateChangeRunnable extends ImplementationProviderRunnable {

		private final CompositeChange compositeChange;

		/**
		 * Create a safe runnable type that can execute the calculation of the implementation change
		 * for a given {@link #setProvider(CapabilityProvider) CapabilityProvider}.
		 * 
		 * @param compositeChange
		 *           A composite change created by the enclosing type.
		 * @param unit
		 *           The unit that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public CreateChangeRunnable(CompositeChange compositeChange, Unit unit,
				IProgressMonitor monitor) {
			super(unit, monitor);
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
			if (cProvider != null && cProvider.canImplement()) {
				Change[] changes = cProvider.createImplementationChange(getUnit(),
						createSubProgressMonitor());
				if (changes != null && changes.length > 0) {
					compositeChange.addAll(changes);
				}
			}
		}
	}

	private class CheckConditionsRunnable extends ImplementationProviderRunnable {

		private final RefactoringStatus compositeStatus;

		/**
		 * Create a safe runnable type that can execute the calculation of the implementation change
		 * for a given {@link #setProvider(CapabilityProvider) CapabilityProvider}.
		 * 
		 * @param compositeStatus
		 *           A composite status created by the enclosing type.
		 * @param unit
		 *           The unit that the client wishes to be implemented.
		 * @param monitor
		 *           A progress monitor to publish feedback to. The monitor will be wrapped in a
		 *           {@link SubProgressMonitor} and recorded as 5 ticks from the wrapped monitor.
		 */
		public CheckConditionsRunnable(RefactoringStatus compositeStatus, Unit unit,
				IProgressMonitor monitor) {
			super(unit, monitor);
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
			if (cProvider != null && cProvider.canImplement()) {
				RefactoringStatus status = cProvider.checkConditionsForImplementation(getUnit(),
						createSubProgressMonitor());
				if (status != null) {
					compositeStatus.merge(status);
				}
			}
		}
	}

}
