/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployCanonicalEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @see DeployDecoratorProvider
 */
public class HybridListCollapseButtonDecorator extends DeployListCollapseButtonDecorator {

	/**
	 * @param decoratorTarget
	 */
	public HybridListCollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected void refreshStatus(View view, EObject object) {
		// look for the compartment
		DrawerStyle style = (DrawerStyle) view.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		boolean isCollapsed = style != null ? style.isCollapsed() : true;

		// if component is expanded, we always add a button
		if (isCollapsed) {
			// else if collapsed we only add a button if the compeoent has members
			EObject element = view.getElement();
			if (!(element instanceof Unit)) {
				hideFigure();
				return;
			}
			Unit unit = (Unit) element;

			// if nothing in inner list, no button
			List<?> filteredElements = null;
			if (view.eContainer() instanceof View) {
				DeployStyle dstyle = (DeployStyle) ((View) view.eContainer())
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (dstyle != null) {
					filteredElements = dstyle.getFilteredSemanticElements();
				}
			}
			if (!hasMembers(unit, filteredElements) && !hasHostedItems(unit, filteredElements)
					&& view.getPersistedChildren().size() == 0) {
				hideFigure();
				return;
			}
			// Don't show decoration if we have a cycle
			if (DeployCanonicalEditPolicy.hasEditPartCycle(unit, editpart)) {
				hideFigure();
				return;
			}
		}
		addCollapsedDecoration(isCollapsed);
	}

	protected View getCompartmentView() {
		// look for the compartment
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		Iterator it = view.getPersistedChildren().iterator();
		while (it.hasNext()) {
			View child = (View) it.next();
			if (child.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)) {
				return child;
			}
		}
		return null;
	}

	private boolean hasMembers(Unit unit, List<?> filteredElements) {
		Iterator<?> it = unit.getMemberLinks().iterator();
		while (it.hasNext()) {
			MemberLink link = (MemberLink) it.next();
			if (unit == link.getSource()
					&& (filteredElements == null || !filteredElements.contains(link.getTarget()))) {
				return true;
			}
		}
		return false;
	}

}
