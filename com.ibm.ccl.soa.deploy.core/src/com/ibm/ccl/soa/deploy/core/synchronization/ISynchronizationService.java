/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.synchronization;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.extension.SynchronizationService;

/**
 * The Synchronization Service can provide aggregations of {@link Change changes} and
 * {@link SynchronizationParticipant participants} to clients.
 * 
 * @since 1.0
 * 
 */
public interface ISynchronizationService {

	/**
	 * A standard Factory pattern for creating instances of {@link ISynchronizationService}.
	 * 
	 * @since 1.0
	 * 
	 */
	public class Factory {

		/**
		 * Create an instance of the Synchronization Service to access SynchronizationParticipants.
		 * 
		 * @param topology
		 * @return
		 */
		public static ISynchronizationService create(Topology topology) {
			return new SynchronizationService(topology);
		}
	}

	/**
	 * Return a non-null array of participants declared as enabled for one or more of the components
	 * in the given list.
	 * 
	 * @param topology
	 *           The topology that is the target of the implementation.
	 * @param component
	 *           The component to implement.
	 * @return A non-null array of participants interested in one or more of the components.
	 */
	SynchronizationParticipant[] findEnabledParticipants(Unit component);

	/**
	 * Return a non-null array of participants declared as enabled for one or more of the components
	 * in the given list. The set of participants returned from this method may or may not be
	 * initialized. To acquire your own set of initialized participants, use
	 * {@link #loadEnabledParticipants(Unit[], SynchronizationArguments)}.
	 * 
	 * @param components
	 *           The list of components selected by the user to implement.
	 * @return A non-null array of participants interested in one or more of the components.
	 */
	SynchronizationParticipant[] findEnabledParticipants(Unit[] components);

	/**
	 * Return a non-null array of participants declared as enabled for one or more of the components
	 * in the given list.
	 * 
	 * @param components
	 *           The list of components selected by the user to implement.
	 * @param processor
	 *           The refactoring processor that these participants will be associated with
	 * @param arguments
	 *           The set of arguments to supply to the participants.
	 * @return A non-null array of participants interested in one or more of the components.
	 */
	SynchronizationParticipant[] loadEnabledParticipants(Unit[] components,
			RefactoringProcessor processor, SynchronizationArguments arguments);

}