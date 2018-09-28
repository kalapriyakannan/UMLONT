package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.listener;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.ui.services.dnd.core.AbstractDragDropListenerProvider;
import org.eclipse.gmf.runtime.common.ui.services.dnd.core.IDropListenerContext;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drop.IDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.xtools.mmi.ui.dnd.MMIDropTargetListener;

public class DeployUMLDragDropListenerProvider extends AbstractDragDropListenerProvider {

	@Override
	public IDropTargetListener[] getDropTargetListeners(IDropListenerContext context) {
		if (context == null) {
			return super.getDropTargetListeners(context);
		}
		IWorkbenchPart part = context.getActivePart();
		if (part == null) {
			return super.getDropTargetListeners(context);
		}
		Object editorPartObj = part.getAdapter(IEditorPart.class);
		if (editorPartObj == null) {
			return super.getDropTargetListeners(context);
		}
		IEditorPart editorPart = (IEditorPart) editorPartObj;
		Object input = editorPart.getEditorInput();
		Resource resource = null;
		if (input != null && input instanceof DiagramEditorInput) {
			DiagramEditorInput diagramEditInput = (DiagramEditorInput) editorPart.getEditorInput();
			resource = diagramEditInput.getDiagram().eResource();
		} else if (input != null && input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IFile file = fileInput.getFile();
			resource = ResourceUtil.findResource(file.getRawLocation().toString());
		}
		return getDropTargetListeners(context, resource);
	}

	public IDropTargetListener[] getDropTargetListeners(IDropListenerContext context,
			Resource resource) {
		if (resource == null) {
			return super.getDropTargetListeners(context);
		}
		DeployUMLDragDropListener dropListener = DeployUMLDragDropListener.getInstance();
		MMIDropTargetListener mmiDropListener = MMIDropTargetListener.getInstance();
		dropListener.setUmlResource(resource);
		return new IDropTargetListener[] { mmiDropListener, dropListener };

	}

}
