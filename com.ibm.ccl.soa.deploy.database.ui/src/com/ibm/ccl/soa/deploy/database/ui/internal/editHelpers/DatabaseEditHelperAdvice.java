/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui.internal.editHelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;

public class DatabaseEditHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
		IElementType type = request.getTypeToConfigure();

		if (type instanceof IUnitElementType) {
			return new ConfigureElementCommand(request) {
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					return CommandResult.newOKCommandResult();
				}
			};
		}

		return null;
	}
}
