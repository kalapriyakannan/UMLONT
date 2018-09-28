/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.synchronization;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a {@link Refactoring} based on the {@link ImplementationRefactoringProcessor}.
 * 
 * @since 1.0
 * 
 */
public class SynchronizationRefactoring extends ProcessorBasedRefactoring {

	private RefactoringProcessor processor;

	/**
	 * Create an Implementation based refactoring using the given processor.
	 * 
	 * @param processor
	 *           The processor to drive this refactoring.
	 */
	public SynchronizationRefactoring(RefactoringProcessor processor) {
		super(processor);
		this.processor = processor;
	}

	public String getName() {
		return DeployCoreMessages.ImplementationRefactoring_Implementation_Refactorin_;
	}

	public RefactoringProcessor getProcessor() {
		return processor;
	}

}
