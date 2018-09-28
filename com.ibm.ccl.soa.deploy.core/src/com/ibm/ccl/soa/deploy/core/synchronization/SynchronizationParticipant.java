/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.synchronization;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

import com.ibm.ccl.soa.deploy.core.ChangeProvider;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * A common super type for all participants that wish to contribute to the implementation of a set
 * of components within a particular {@link Topology}.
 * 
 * @since 1.0
 * 
 */
public abstract class SynchronizationParticipant extends RefactoringParticipant {

	public final boolean initialize(RefactoringProcessor processor, Object element,
			RefactoringArguments arguments) {
		return super.initialize(processor, element, arguments);
	}

	protected final boolean initialize(Object element) {
		Assert.isTrue(element instanceof Topology);
		return initialize((Topology) element);
	}

	protected final void initialize(RefactoringArguments arguments) {
		Assert.isTrue(arguments instanceof SynchronizationArguments);
		initialize((SynchronizationArguments) arguments);
	}

	/**
	 * Called after {@link #initialize(SynchronizationArguments)} with the Topology that is the
	 * source of the Implementation operation. A subset of the components contained within the
	 * Topology may be selected, so be sure to check
	 * {@link SynchronizationArguments#getImplementationDatamodel() the datamodel} for the exact set
	 * of {@link ImplementationDatamodel#getComponents() components} selected by the user.
	 * 
	 * @param element
	 *           The topology that is about to be implemented.
	 * @return True if the given participant can operate on the given element.
	 * @see #initialize(SynchronizationArguments)
	 */
	protected abstract boolean initialize(Topology element);

	/**
	 * Called before {@link #initialize(Topology)} with necessary information to carry out the
	 * implementation.
	 * 
	 * @param arguments
	 *           A set of arguments supplied by the user to carry out the operation.
	 * 
	 * @see ImplementationDatamodel
	 * @see ImplementationDatamodel#getComponents()
	 * 
	 */
	protected abstract void initialize(SynchronizationArguments arguments);

	/**
	 * Provide a non-null array of ChangeProviders to use in calculating the synchronization of the
	 * model to the world or the world to the model.
	 * 
	 * @return A non-null array of ChangeProviders to use in calculating the synchronization of the
	 *         model to the world or the world to the model.
	 */
	protected abstract ChangeProvider[] getChangeProviders();

}
