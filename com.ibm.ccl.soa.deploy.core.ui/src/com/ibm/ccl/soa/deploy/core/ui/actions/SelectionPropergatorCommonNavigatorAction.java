/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class SelectionPropergatorCommonNavigatorAction extends Action {

	public SelectionPropergatorCommonNavigatorAction() {
		super(Messages.SelectionPropergatorCommonNavigatorAction_Show_in_Deployment_Navigato_);
		// TODO Auto-generated constructor stub
	}

	public void run(Unit unit) {
		if (unit == null) {
			return;
		}
		CommonNavigator nav = getCommonNavigator();
		nav.selectReveal(getUnderlyingObject(unit));
	}

	public void run() {
		super.run();
		try {
			ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getSelection();
			getUnit((IStructuredSelection) selection);
		} catch (RuntimeException e) {
			// action will not run
		}
	}

	private void getUnit(IStructuredSelection selection) {
		Object object = selection.getFirstElement();
		if (object instanceof EditPart) {
			EditPart part = (EditPart) object;
			EObject eo = ViewUtil.resolveSemanticElement((View) part.getModel());
			if (eo instanceof Unit) {
				run((Unit) eo);
			}
		}

	}

	private ISelection getUnderlyingObject(Unit unit) {
		ArrayList selectionList = new ArrayList();
		IUnitProviderService unitProviderService = ExtensionsCore.createProviderService();
		UnitProvider[] providers = unitProviderService.findEnabledProvidersByInputOnly(unit);
		for (int i = 0; i < providers.length; i++) {
			UnitProvider provider = providers[i];
			Object objects = provider.resolveUnderlyingResource(unit, null);
			if (objects instanceof List) {

				List list = (List) objects;
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Object element = iter.next();
					if (element instanceof Resource) {
						Resource resource = (Resource) element;
						IFile file = WorkbenchResourceHelper.getFile(resource);
						selectionList.add(file);
					} else {
						selectionList.add(element);
					}
				}
			}
		}
		selectionList.add(unit);
		IStructuredSelection selections = new StructuredSelection(selectionList);
		return selections;
	}

	private CommonNavigator getCommonNavigator() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IViewReference references[] = page.getViewReferences();
			for (int i = 0; i < references.length; i++) {
				IViewReference reference = references[i];
				if (reference.getId().equals("org.eclipse.ui.navigator.ProjectExplorer")) { //$NON-NLS-1$
					return (CommonNavigator) reference.getPart(false);
				}
			}

		}
		return null;
	}

}
