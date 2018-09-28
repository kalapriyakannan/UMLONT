/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.validator;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyMarkerFactory;

/**
 * Temporary action for manual file validation.
 * 
 * TODO migrate function to modeler.
 * 
 * Questions: contact avk@us.ibm.com
 */
public class ValidateTopologyAction implements IObjectActionDelegate {
	protected IWorkbenchPart part = null;

	protected ISelection selection = null;

	/*
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.part = targetPart;
	}

	/*
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/**
	 * Load the selected topology, clear its markers and validate using the
	 * validator service.
	 * 
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// TODO temporary -- should run as task
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		IStructuredSelection ss = (IStructuredSelection) selection;
		Object element = ss.getFirstElement();
		if (!(element instanceof IFile)) {
			return;
		}
		IFile file = (IFile) element;
		try {
			//
			// Load topology
			//
			Resource res = WorkbenchResourceHelperBase.getResource(file, true);
			assert res != null;
			res.load(Collections.EMPTY_MAP);
			DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents()
					.get(0);
			Topology topology = deployCoreRoot.getTopology();
			assert topology != null;

			//
			// Validate topology
			//
			TopologyMarkerFactory.deleteDeployMarkers(file);
			DeployValidatorService validator = DeployValidatorService.getDefaultValidatorService();
			validator.validate(topology);
		} catch (IOException e) {
			// TODO log error (temporary action in any case)
		} catch (CoreException e) {
			// TODO log error (temporary action in any case)
			e.printStackTrace();
		}
	}
}
