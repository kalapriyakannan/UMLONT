/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.ui.internal.editHelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;

public class WebsphereAppServerEditHelperAdvice extends AbstractEditHelperAdvice {

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

	/*
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
	 */
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final IElementType type = request.getElementType();
		if (!(type instanceof IUnitElementType)) {
			return null;
		}

		return new ConfigureElementCommand(new ConfigureRequest(request.getEditingDomain(), request
				.getNewElement(), type)) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				// Disabled functionality for M2/1.5 because it triggered UI bugs 12212, 12213, 12214
//				String typeId = null;
//				if (type instanceof ElementType) {
//					typeId = ((ElementType) type).getId();
//				}
//				Collection objects = (Collection) info.getAdapter(Collection.class);
//				if ("was.WasUnmanagedNodeWithWebServer.6".equals(typeId)) { //$NON-NLS-1$
//					return new CommandResult(
//							configureWasUnmanagedNodeWithServer(objects));
//				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
