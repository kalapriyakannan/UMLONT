/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.edithelpers.ContainerEditHelper;
import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;

/**
 * 
 * @since 1.0
 * @see ContainerEditHelper
 */
public class CopyUnitFromTemplateCommand extends CreateElementCommand {

	/**
	 * Constructs a new command to create a model element.
	 * 
	 * @param request
	 *           the request
	 */
	public CopyUnitFromTemplateCommand(CreateElementRequest request) {
		super(request);
	}

	/**
	 * Add the Unit(s) in the .template file to the 'containment feature' (which is the Topology.unit
	 * reference).
	 */
	protected EObject doDefaultElementCreation() {
		CreateElementRequest request = getCreateRequest();
		IElementType type = request.getElementType();

		if (type instanceof IUnitElementType) {
			Topology container = (Topology) getElementToEdit();
			return ResolutionUIUtils.doDefaultElementCreation(type, container);
		}

		return super.doDefaultElementCreation();
	}
}
