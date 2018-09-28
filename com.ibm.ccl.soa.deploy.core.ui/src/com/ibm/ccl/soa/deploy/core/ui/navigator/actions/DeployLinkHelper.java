/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import com.ibm.ccl.soa.deploy.core.ui.editor.TopologySaveableInput;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;

public class DeployLinkHelper implements ILinkHelper {

	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		//If we select a diagram node, we need to switch editors
		if (aSelection.getFirstElement() instanceof TopologyDiagramNode) {
			IFile file = (IFile) ((TopologyDiagramNode) aSelection.getFirstElement())
					.getAdapter(IFile.class);
			IEditorPart part = EditorUtility.isOpenInEditor(file);
			if (part != null) {
				aPage.bringToTop(part);
			}
			return;
		}

//		IEditorPart part = aPage.getActiveEditor();
//		if (part instanceof DeployCoreEditor) {
//			DeployCoreEditor editor = (DeployCoreEditor) part;
//			editor.selectReveal(aSelection);
//		}
	}

	public IStructuredSelection findSelection(IEditorInput anInput) {
		if (anInput instanceof TopologySaveableInput) {
			TopologySaveableInput editorInput = (TopologySaveableInput) anInput;

			if (editorInput.getFile() != null) {
				TopologyDiagramNode node = new TopologyDiagramNode(editorInput.getFile());
				if (node.getTopologyFile() != null) {
					IStructuredSelection selection = new StructuredSelection(new Object[] { node,
							node.getTopologyFile() });
					return selection;
				}
			}
		}
		return null;
	}

}
