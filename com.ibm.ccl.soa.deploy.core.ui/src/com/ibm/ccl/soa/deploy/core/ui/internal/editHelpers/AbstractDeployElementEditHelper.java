/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.editHelpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * @since 1.0
 * 
 */
public class AbstractDeployElementEditHelper extends AbstractEditHelper {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xtools.emf.type.edithelper.AbstractEditHelper#getContainerCommand(com.ibm.xtools.emf.type.requests.GetContainerRequest)
	 */
	protected ICommand getEditContextCommand(GetEditContextRequest req) {

		GetEditContextCommand result = null;

		IEditCommandRequest editRequest = req.getEditCommandRequest();

		if (editRequest instanceof CreateElementRequest) {
			result = new GetEditContextCommand(req);
			EObject container = ((CreateElementRequest) editRequest).getContainer();

			if (container instanceof Diagram) {
				EObject element = ((Diagram) container).getElement();

				if (element == null) {
					// Element is null if the diagram was created using the wizard
					EObject annotation = ((Diagram) container).eContainer();

					if (annotation != null) {
						element = annotation.eContainer();
					}
				}
				container = element;
			}
			result.setEditContext(container);
		}
		return result;
	}
}
