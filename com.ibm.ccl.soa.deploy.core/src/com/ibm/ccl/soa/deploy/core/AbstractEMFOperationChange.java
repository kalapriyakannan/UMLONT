/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class AbstractEMFOperationChange extends Change {

	private String name;
	private Object modifiedElement;
	private AbstractEMFOperation op;
	private boolean isUndo;

	public AbstractEMFOperationChange(String name, Object modifiedElement, AbstractEMFOperation op,
			boolean isUndo) {
		this.name = name;
		this.modifiedElement = modifiedElement;
		this.op = op;
		this.isUndo = isUndo;
	}

	@Override
	public Object getModifiedElement() {
		return modifiedElement;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {

	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			if (isUndo)
				op.undo(pm, null);
			else
				op.execute(pm, null);
		} catch (ExecutionException e) {
			throw new CoreException(DeployCorePlugin.createErrorStatus(0, e.getMessage(), e));
		}

		return new AbstractEMFOperationChange(name, modifiedElement, op, !isUndo);
	}

}
