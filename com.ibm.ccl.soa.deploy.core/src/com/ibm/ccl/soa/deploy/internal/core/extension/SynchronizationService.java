/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationParticipantDescriptor;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationService;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationParticipant;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * A state-managing service to track instantiated {@link SynchronizationParticipant participants}.
 * 
 * The service does not define a dispose method as the base type of {@link RefactoringParticipant}
 * does not support a dispose lifecycle.
 * 
 * @since 1.0
 * 
 */
public class SynchronizationService implements ISynchronizationService {

	private final static SynchronizationParticipant[] NO_PARTICIPANTS = new SynchronizationParticipant[0];

	private final Map<ISynchronizationParticipantDescriptor, SynchronizationParticipant> participants = new HashMap<ISynchronizationParticipantDescriptor, SynchronizationParticipant>();
	private Object lock = new Object();

	private Topology topology;

	/**
	 * @param topology
	 *           The topology that is the target of the implementation.
	 */
	public SynchronizationService(Topology topology) {
		this.topology = topology;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.extension.ISynchronizationService#findEnabledParticipants(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public SynchronizationParticipant[] findEnabledParticipants(Unit component) {

		List<SynchronizationParticipant> participants = new ArrayList<SynchronizationParticipant>();
		Set<ISynchronizationParticipantDescriptor> descriptors = SynchronizationParticipantManager
				.getInstance().findDescriptorsEnabledFor(component);
		for (Iterator<ISynchronizationParticipantDescriptor> iter = descriptors.iterator(); iter
				.hasNext();) {
			ISynchronizationParticipantDescriptor descriptor = iter.next();
			participants.add(getParticipant(descriptor));

		}
		if (participants.size() == 0)
			return NO_PARTICIPANTS;

		return participants.toArray(new SynchronizationParticipant[participants.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.extension.ISynchronizationService#findEnabledParticipants(com.ibm.ccl.soa.deploy.core.Unit[])
	 */
	public SynchronizationParticipant[] findEnabledParticipants(Unit[] components) {

		List<SynchronizationParticipant> participants = new ArrayList<SynchronizationParticipant>();
		Set<ISynchronizationParticipantDescriptor> descriptors = SynchronizationParticipantManager
				.getInstance().findDescriptorsEnabledFor(components);
		for (Iterator<ISynchronizationParticipantDescriptor> iter = descriptors.iterator(); iter
				.hasNext();) {
			ISynchronizationParticipantDescriptor descriptor = iter.next();
			participants.add(getParticipant(descriptor));
		}
		if (participants.size() == 0)
			return NO_PARTICIPANTS;
		return participants.toArray(new SynchronizationParticipant[participants.size()]);
	}

	private SynchronizationParticipant getParticipant(
			ISynchronizationParticipantDescriptor descriptor) {
		SynchronizationParticipant participant = null;
		synchronized (lock) {
			participant = participants.get(descriptor);
			if (participant == null) {
				participants.put(descriptor, participant = descriptor.createParticipant());

			}
		}
		return participant;
	}

	protected Topology getTopology() {
		return topology;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.extension.ISynchronizationService#loadEnabledParticipants(com.ibm.ccl.soa.deploy.core.Unit[],
	 *      org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor,
	 *      com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments)
	 */
	public SynchronizationParticipant[] loadEnabledParticipants(Unit[] components,
			final RefactoringProcessor processor, final SynchronizationArguments arguments) {
		List<SynchronizationParticipant> collectedParticipants = new ArrayList<SynchronizationParticipant>();
		Set<ISynchronizationParticipantDescriptor> descriptors = SynchronizationParticipantManager
				.getInstance().findDescriptorsEnabledFor(components);
		for (Iterator<ISynchronizationParticipantDescriptor> iter = descriptors.iterator(); iter
				.hasNext();) {
			ISynchronizationParticipantDescriptor descriptor = iter.next();
			collectedParticipants.add(getParticipant(descriptor));
		}
		if (collectedParticipants.size() == 0)
			return NO_PARTICIPANTS;

		for (final SynchronizationParticipant synchronizationParticipant : collectedParticipants) {
			SafeRunner.run(new DeployCoreSafeRunnable() {
				public void run() throws Exception {
					synchronizationParticipant.initialize(processor, topology, arguments);
				}
			});
		}

		return collectedParticipants.toArray(new SynchronizationParticipant[collectedParticipants
				.size()]);
	}

}
