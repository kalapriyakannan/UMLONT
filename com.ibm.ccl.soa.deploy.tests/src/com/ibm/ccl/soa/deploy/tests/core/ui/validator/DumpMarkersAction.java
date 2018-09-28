/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.validator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Testing action for marker dumping on a topology.
 * 
 * Questions: contact avk@us.ibm.com
 */
public class DumpMarkersAction implements IObjectActionDelegate {
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
			StringBuffer buffer = new StringBuffer();
			buffer.append("*** Deploy markers on ");
			buffer.append(file.getFullPath());
			IMarker[] markers = file.findMarkers(IDeployMarker.MARKER_ID, true,
					IResource.DEPTH_INFINITE);
			for (int i = 0; i < markers.length; i++) {
				buffer.append("\n");
				buffer.append(DeployMarker.toString(markers[i]));
			}

			buffer.append("\n*** END DUMP");
			System.err.println(buffer);
		} catch (CoreException e) {
			// TODO log error (temporary action in any case)
			e.printStackTrace();
		}
	}
}
