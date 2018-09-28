/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployPopupBarEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployableUnitElementUIService;

/**
 * This ModelingAssistantProvider calls DeployableUnitElementUIService to get deployable
 * configuration units on the host server unit and compose context pop-up bar content.
 * 
 * <p>
 * This class is registered on the
 * <code>org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders</code> extension point and is
 * directly called by GMF.
 * 
 * <p>
 * This code is indirectly called by DeployPopupBarEditPolicy.populatePopupBars(). That method is
 * implemented using ModelingAssistantService.getInstance().getTypesForPopupBar(unit). Although the
 * methods have a pre-Java generic signature, the documentation says the list must be
 * List&lt;IElementType&gt;. So although the {@link UnitFilter}s and DeployableUnitElementUIService
 * make a distinction between the kind of relationship desired (hostee or member), this class
 * mustn't return that information in a form that DeployPopupBarEditPolicy can use!
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author Ed Snible
 * 
 * @see DeployableUnitElementUIService
 * @see DeployPopupBarEditPolicy
 * 
 * @deprecated we no longer use the modeling assistant in the popup bar edit policy; and this code
 *             doesn't work with UnitFilter extended return types either.
 */
public class DeployCoreModelingAssistantProvider extends ModelingAssistantProvider {

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {

		/** Get target EditPart */
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		/**
		 * Call supporting service to get a list of ElementType for deployable configuration units and
		 * member units, and return the merged list. After UnitGroup's compartments are ready, we will
		 * return the target list seperately for the different compartment.
		 */
		Unit unit = (Unit) editPart.getNotationView().getElement();
		List<IElementType> nubUnits = DeployableUnitElementUIService.getInstance()
				.getAllowableNubUnitElements(unit);
		List<IElementType> members = DeployableUnitElementUIService.getInstance()
				.getAllowableMemberUnitElements(unit);
		List<IElementType> hosteeUnits = DeployableUnitElementUIService.getInstance()
				.getAllowableHostingUnitElements(unit);

		List<IElementType> list = new ArrayList<IElementType>();
		list.addAll(nubUnits);
		list.addAll(members);
		list.addAll(hosteeUnits);

		return list;
	}

} // end class DeployCoreModelingAssistantProvider
