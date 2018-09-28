/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

/**
 * 
 * Provides a change implementation that provides some of the common implementations like focusing
 * on a modified element and returning a given name.
 * 
 * <p>
 * Clients must implement the {@link Change#perform(IProgressMonitor)} method, and optionally
 * implement {@link Change#initializeValidationData(IProgressMonitor)} and
 * {@link Change#isValid(IProgressMonitor)}.
 * </p>
 * 
 * @since 1.0
 * 
 */
public abstract class SynchronizationChange extends Change {

	private String name;
	private Object modifiedElement;

	/**
	 * Create a subclass focused on the given element to be modified and described by the given name.
	 * 
	 * @param modifiedElement
	 *           The element that will be modified as a result of this change.
	 * @param name
	 *           A display name to be shown to the user.
	 */
	public SynchronizationChange(Object modifiedElement, String name) {
		this.modifiedElement = modifiedElement;
		this.name = name;
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

}
