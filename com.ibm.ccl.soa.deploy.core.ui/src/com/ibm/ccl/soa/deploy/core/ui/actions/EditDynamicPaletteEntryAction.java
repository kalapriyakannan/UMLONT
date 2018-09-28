/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Context action: Edit Palette Entry, on Palette context menu
 * 
 * @author snible@us.ibm.com
 */
public class EditDynamicPaletteEntryAction extends Action {
	private final String resourceId;

	/**
	 * @param resId
	 */
	public EditDynamicPaletteEntryAction(String resId) {
		resourceId = resId;

		setText(Messages.EditDynamicPaletteEntryAction_Edit_Palette_Entr_);
	}

	public void run() {
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		String uri = rts.getTemplateURI(resourceId);

		IFile topologyFile = uriToIFile(uri);

		if (topologyFile != null) {
			IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
			IEditorDescriptor currentDescriptor = registry.getDefaultEditor(topologyFile.getName());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (page != null && currentDescriptor != null) {
				try {
					page.openEditor(new FileEditorInput(topologyFile), currentDescriptor.getId());
				} catch (PartInitException e) {
					// do nothing
				}
			}
		}

	}

	private IFile uriToIFile(String uri) {
		return uriToIFile(URI.createURI(uri));
	}

	private IFile uriToIFile(URI uri) {
		String scheme = uri.scheme();
		if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) { //$NON-NLS-1$//$NON-NLS-2$
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			}

			return ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(platformResourcePath.toString()));
		}

		return null;
	}

} // end class EditDynamicPaletteEntryAction
