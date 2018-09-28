/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;

import com.ibm.ccl.soa.deploy.core.ChangeProvider;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationParticipant;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A Skeleton type to return from the descriptor to avoid null pointer exceptions due to invalid
 * extensions.
 * 
 * @since 1.0
 * 
 */
public class SkeletonImplementationParticipant extends SynchronizationParticipant {

	public static final SynchronizationParticipant INSTANCE = new SkeletonImplementationParticipant();

	protected boolean initialize(Topology element) {
		return false;
	}

	protected void initialize(SynchronizationArguments arguments) {

	}

	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		return RefactoringStatus
				.createErrorStatus(DeployCoreMessages.SkeletonImplementationParticipant_A_implementation_participant_failed_);
	}

	public Change createChange(IProgressMonitor pm) throws OperationCanceledException {
		return null;
	}

	public String getName() {
		return DeployCoreMessages.SkeletonImplementationParticipant_Invalid_implementation_participan_;
	}

	protected ChangeProvider[] getChangeProviders() {
		// TODO Auto-generated method stub
		return null;
	}

}
