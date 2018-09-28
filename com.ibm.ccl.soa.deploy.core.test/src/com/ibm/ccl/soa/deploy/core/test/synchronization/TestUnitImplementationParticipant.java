/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.synchronization;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;

import com.ibm.ccl.soa.deploy.core.ChangeProvider;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationArguments;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationParticipant;

public class TestUnitImplementationParticipant extends
		SynchronizationParticipant {

	public TestUnitImplementationParticipant() {
		// TODO Auto-generated constructor stub
	}

	protected boolean initialize(Topology element) {
		// TODO Auto-generated method stub
		return false;
	}

	protected void initialize(SynchronizationArguments arguments) {
		// TODO Auto-generated method stub

	}

	public RefactoringStatus checkConditions(IProgressMonitor arg0,
			CheckConditionsContext arg1) throws OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

	public Change createChange(IProgressMonitor arg0) throws CoreException,
			OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	protected ChangeProvider[] getChangeProviders() {
		// TODO Auto-generated method stub
		return null;
	}

}
