/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationParticipant;

/**
 * Provides a common base type for {@link UnitProvider}, {@link CapabilityProvider} as well as the
 * mechanism for {@link SynchronizationParticipant participants} to provide {@link Change changes}
 * to the Synchronization Framework.
 * 
 * @since 1.0
 * 
 */
public class ChangeProvider {

	/**
	 * A reusable definition of an empty array of {@link Change changes}.
	 */
	public static final Change[] NO_CHANGES = new Change[0];

	/**
	 * Return true if the current provider can reflect values from artifacts in the workspace.
	 * Defaults to "true".
	 * 
	 * 
	 * @return True if the current provider can reflect values from artifacts in the workspace.
	 */
	public boolean canReflect() {
		return true;
	}

	/**
	 * Return true if the current provider can reflect values from artifacts in the workspace.
	 * Defaults to "true".
	 * 
	 * 
	 * @return True if the current provider can reflect values from artifacts in the workspace.
	 */
	public boolean canImplement() {
		return false;
	}

	/**
	 * Create a change object to carry out modifications to the set of Units based on the current
	 * state of the reflected artifacts.
	 * 
	 * @param unitChange
	 *           A change object, which may be undoable, to carry out changes necessary in order to
	 *           synchronize the state of the external artifacts with the state of the model.
	 * 
	 * @param unit
	 *           The affected unit, chosen by the user, to update in the model.
	 * 
	 * @return A change object, which may be undoable, to carry out changes necessary in order to
	 *         synchronize the state of the model with the state of the external artifacts.
	 */
	public Change[] createReflectionChange(Unit unit, IProgressMonitor monitor) {
		return NO_CHANGES;
	}

	/**
	 * Create a change object to carry out modifications to the workspace or external artifacts in
	 * order to synchronize the external artifacts witht the model.
	 * 
	 * @param unitChange
	 *           A change object, which may be undoable, to carry out changes necessary in order to
	 *           synchronize the state of the external artifacts with the state of the model.
	 * 
	 * @param unit
	 *           The affected unit, chosen by the user, to update in the workspace or external
	 *           artifacts. The set of units may not be the entire set of units contained in a given
	 *           Topology, and not all given Units may be recognizable by this CapabilityProvider.
	 * @param monitor
	 *           A progress monitor to provide feedback to the user about the current step of the
	 *           operation.
	 * 
	 * @return An non-null array of changes that could be carried out on implementation. Be aware
	 *         that the user may choose to only carry out a subset of these changes.
	 */
	public Change[] createImplementationChange(Unit unit, IProgressMonitor monitor) {
		return NO_CHANGES;
	}

	/**
	 * Create a change object to carry out modifications to the set of Units based on the current
	 * state of the reflected artifacts.
	 * 
	 * @param unitChange
	 *           A change object, which may be undoable, to carry out changes necessary in order to
	 *           synchronize the state of the external artifacts with the state of the model.
	 * 
	 * @param stub
	 *           The affected stub, reflected by the unit provider, and chosen by the user to add to
	 *           the model.
	 * 
	 * @return A change object, which may be undoable, to carry out changes necessary in order to
	 *         synchronize the state of the model with the state of the external artifacts.
	 */
	public Change[] createImportChange(Topology topology, TopologyUnitStub stub,
			IProgressMonitor monitor) {
		return NO_CHANGES;
	}

	/**
	 * Called prior to the creation of an implementation change. Clients should use this hook to
	 * validate whether all conditions are met for the given unit to be implemented.
	 * 
	 * @param unit
	 *           The unit that is to be implemented.
	 * @param monitor
	 *           A monitor to track the progress of the validation.
	 * @return A {@link RefactoringStatus} indicating whether there will be any problem with carrying
	 *         out the implementation. Returning {@link RefactoringStatus#FATAL} will cause the
	 *         implementation to be aborted.
	 * @throws OperationCanceledException
	 *            If the progress monitor is cancelled while the validation is taking place.
	 */
	public RefactoringStatus checkConditionsForImplementation(Unit unit, IProgressMonitor monitor)
			throws OperationCanceledException {
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	/**
	 * Called prior to the creation of an reflected change. Clients should use this hook to validate
	 * whether all conditions are met for the given unit to be implemented.
	 * 
	 * @param unit
	 *           The unit that is to be reflected.
	 * @param monitor
	 *           A monitor to track the progress of the validation.
	 * @return A {@link RefactoringStatus} indicating whether there will be any problem with carrying
	 *         out the reflected. Returning {@link RefactoringStatus#FATAL} will cause the reflected
	 *         to be aborted.
	 * @throws OperationCanceledException
	 *            If the progress monitor is cancelled while the validation is taking place.
	 */
	public RefactoringStatus checkConditionsForReflection(Unit unit, IProgressMonitor monitor)
			throws OperationCanceledException {
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	/**
	 * Called prior to the creation of an import change. Clients should use this hook to validate
	 * whether all conditions are met for the given unit to be implemented.
	 * 
	 * @param stub
	 *           The stub that is to be imported.
	 * @param monitor
	 *           A monitor to track the progress of the validation.
	 * @return A {@link RefactoringStatus} indicating whether there will be any problem with carrying
	 *         out the import. Returning {@link RefactoringStatus#FATAL} will cause the import to be
	 *         aborted.
	 * @throws OperationCanceledException
	 *            If the progress monitor is cancelled while the validation is taking place.
	 */
	public RefactoringStatus checkConditionsForImport(TopologyUnitStub stub, IProgressMonitor monitor)
			throws OperationCanceledException {
		return RefactoringStatus.create(Status.OK_STATUS);
	}
}
