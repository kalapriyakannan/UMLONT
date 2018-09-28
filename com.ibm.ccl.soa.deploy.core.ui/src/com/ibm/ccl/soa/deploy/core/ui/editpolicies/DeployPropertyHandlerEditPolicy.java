/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TopGraphicEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PropertyHandlerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;

/**
 * @author jswanke
 * 
 */
public class DeployPropertyHandlerEditPolicy extends PropertyHandlerEditPolicy {
	public Command getCommand(Request request) {
		if (!understandsRequest(request)) {
			return null;
		}

		if (request.getType().equals(RequestConstants.REQ_SHOW_ALL_COMPARTMENTS)) {
			EditPart ep = getHost();
			if (ep instanceof TopGraphicEditPart) {
				TopGraphicEditPart topEP = (TopGraphicEditPart) ep;
				List resizableViews = topEP.getResizableNotationViews();
				if (resizableViews.isEmpty())
					return null;
				ChangePropertyValueRequest cpvr = (ChangePropertyValueRequest) request;
				CompositeCommand compositeCommand = new CompositeCommand(cpvr.getPropertyName());

				// rather then make the compartment invisible, just collpase it
				final boolean explode = ((Boolean) ((ChangePropertyValueRequest) request).getValue())
						.booleanValue();
				for (Iterator iter = resizableViews.iterator(); iter.hasNext();) {
					final View childView = (View) iter.next();
					final GraphicalEditPart gep = (GraphicalEditPart) ep;
					compositeCommand.compose(new AbstractTransactionalCommand(getEditingDomain(),
							"", null) {//$NON-NLS-1$
								protected CommandResult doExecuteWithResult(
										IProgressMonitor progressMonitor, IAdaptable info) {

									boolean isExploded = !((Boolean) ViewUtil.getStructuralFeatureValue(
											childView, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed()))
											.booleanValue();
									if (isExploded != explode) {
										ZoomUtils.deselect(gep);
										ZoomUtils.explode(gep.getEditingDomain(), gep, explode);
									}
									return CommandResult.newOKCommandResult();
								}
							});
				}
				return new ICommandProxy(compositeCommand);
			}
			return null;
		}
		return super.getCommand(request);
	}

}
